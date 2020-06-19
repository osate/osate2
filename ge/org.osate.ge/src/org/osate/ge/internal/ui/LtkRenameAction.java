/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.ui;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.ltk.ui.refactoring.RefactoringUI;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ModelChangeNotifier.Lock;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.util.RenameUtil;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class LtkRenameAction implements AgeAction {
	private final ProjectProvider projectProvider;
	private final ModelChangeNotifier modelChangeNotifier;
	private final BusinessObjectSupplier boSupplier;
	private final String originalName;
	private final String newName;

	public static interface BusinessObjectSupplier {
		/**
		 * Returns the business object that should be renamed based on its current name
		 * @param currentName is the current name of the object
		 * @return the business object to rename
		 */
		EObject getBusinessObject(final String currentName);
	}

	public LtkRenameAction(final ProjectProvider projectProvider, final ModelChangeNotifier modelChangeNotifier,
			final BusinessObjectSupplier boSupplier,
			final String newName, final String originalName) {
		this.projectProvider = Objects.requireNonNull(projectProvider, "projectProvider must not be null");
		this.modelChangeNotifier = Objects.requireNonNull(modelChangeNotifier, "modelChangeNotifier must not be null");
		this.boSupplier = Objects.requireNonNull(boSupplier, "boSupplier must not be null");
		this.newName = newName;
		this.originalName = originalName;
	}

	@Override
	public boolean canExecute() {
		return boSupplier.getBusinessObject(originalName) != null && newName != null;
	}

	@Override
	public boolean isValid() {
		return boSupplier.getBusinessObject(originalName) != null;
	}

	@Override
	public AgeAction execute() {
		final EObject bo = (EObject) boSupplier.getBusinessObject(originalName);
		if (bo == null) {
			throw new RuntimeException("Unable to retrieve business object to rename.");
		}

		return renameWithLtk(bo, newName)
				? new LtkRenameAction(projectProvider, modelChangeNotifier, boSupplier, originalName, newName)
						: null;
	}

	/**
	 * Returns true if the rename occurred
	 * @param bo
	 * @param value
	 * @return
	 */
	private boolean renameWithLtk(final EObject bo, final String value) {
		// Lock the diagram to treat all model change notifications as part of the current action.
		try (Lock lock = modelChangeNotifier.lock()) {
			// Rename the element using LTK
			final ProcessorBasedRefactoring renameRefactoring = RenameUtil.getRenameRefactoring(bo);
			final RefactoringStatus refactoringStatus = prepareAndCheck(renameRefactoring, value);
			if (!refactoringStatus.isOK()) {
				final Dialog dlg = RefactoringUI.createRefactoringStatusDialog(refactoringStatus,
						Display.getCurrent().getActiveShell(), "Refactoring", false);
				if (dlg.open() != Window.OK) {
					// Abort
					return false;
				}
			}

			try {
				final Change change = renameRefactoring.createChange(new NullProgressMonitor());
				new WorkspaceModifyOperation() {
					@Override
					protected void execute(IProgressMonitor monitor)
							throws CoreException, InvocationTargetException, InterruptedException {
						// Prevent model notification changes from being sent until after the refactoring

						// Perform the modification
						change.perform(monitor);

						// Build the project to prevent reference resolver from using old objects.
						try {
							projectProvider.getProject().build(IncrementalProjectBuilder.INCREMENTAL_BUILD,
									new NullProgressMonitor());
						} catch (CoreException e) {
							// Ignore any errors that occur while building the project
							e.printStackTrace();
						}

						final String languageName = getLanguageName();
						// Force reconciliation
						for (final IEditorReference editorRef : PlatformUI.getWorkbench().getActiveWorkbenchWindow()
								.getActivePage().getEditorReferences()) {
							final IEditorPart editor = editorRef.getEditor(false);
							if (editor instanceof XtextEditor) {
								final XtextEditor xtextEditor = (XtextEditor) editor;

								// Only force reconciliation for AADL editors
								if (Objects.equals(xtextEditor.getLanguageName(), languageName)) {
									final SyncUtil syncUtil = Aadl2Activator.getInstance()
											.getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2)
											.getInstance(SyncUtil.class);

									// Only waiting once will result in the reconciler processing a change outside the lock.
									// Doing it twice appears to wait for pending runs of the reconciler.
									syncUtil.waitForReconciler(xtextEditor);
									syncUtil.waitForReconciler(xtextEditor);
								}
							}
						}

						// Build the project to prevent reference resolver from using old objects.
						try {
							projectProvider.getProject().build(IncrementalProjectBuilder.INCREMENTAL_BUILD,
									new NullProgressMonitor());
						} catch (CoreException e) {
							// Ignore any errors that occur while building the project
							e.printStackTrace();
						}

					}
				}.run(null);

			} catch (final Exception e) {
				throw new RuntimeException(e);
			}
		}
		return true;
	}

	/**
	 * Sets the new name of the refactoring's processor. Check arguments and initial conditions. Returns true if rename can proceed.
	 * @param refactoring
	 * @param newName
	 * @return
	 */
	private static RefactoringStatus prepareAndCheck(final ProcessorBasedRefactoring refactoring,
			final String newName) {
		try {
			if (refactoring == null) {
				return RefactoringStatus.createFatalErrorStatus("Refactoring is null");
			}

			final RefactoringProcessor refactoringProcessor = refactoring.getProcessor();
			if (!(refactoringProcessor instanceof AbstractRenameProcessor)) {
				return RefactoringStatus
						.createFatalErrorStatus("refactoringProcessor is not an AbstractRenameProcessor");
			}

			// Set the name
			((AbstractRenameProcessor) refactoringProcessor).setNewName(newName);
			final RefactoringStatus initialStatus = refactoring.checkInitialConditions(new NullProgressMonitor());
			if (!initialStatus.isOK()) {
				return initialStatus;
			}

			final RefactoringStatus finalStatus = refactoring.checkFinalConditions(new NullProgressMonitor());
			if (!finalStatus.isOK()) {
				return finalStatus;
			}
		} catch (final CoreException ex) {
			return RefactoringStatus.create(ex.getStatus());
		}

		return new RefactoringStatus();
	}

	private static class LanguageNameRetriever {
		@Inject
		@Named(org.eclipse.xtext.Constants.LANGUAGE_NAME)
		public String languageName;
	}

	/**
	 * Retrieves the language name by injecting it into a new object.
	 * @return
	 */
	private static String getLanguageName() {
		final Injector injector = Objects.requireNonNull(
				Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2),
				"Unable to retrieve injector");

		final LanguageNameRetriever obj = injector.getInstance(LanguageNameRetriever.class);
		return obj.languageName;
	}
}