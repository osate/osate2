/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
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
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.osate.ge.internal.GraphicalEditorException;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ModelChangeNotifier.Lock;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;
import org.osgi.framework.FrameworkUtil;

import com.google.inject.Injector;

/**
 * Action which renames a model element using a Language Toolkit (LTK) rename refactoring.
 *
 */
@SuppressWarnings("restriction")
public class LtkRenameAction implements AgeAction {
	private final ProjectProvider projectProvider;
	private final ModelChangeNotifier modelChangeNotifier;
	private final BusinessObjectSupplier boSupplier;
	private final String originalName;
	private final String newName;

	/**
	 * Interface for providing the action with the model element to be renamed. This is required because elements are invalidated whenever a
	 * rename occurs, this is needed to ensure undo and redo actions can retrieve the appropriate model element.
	 *
	 */
	public static interface BusinessObjectSupplier {
		/**
		 * Returns the business object that should be renamed based on its current name
		 * @param currentName is the current name of the object
		 * @return the business object to rename
		 */
		EObject getBusinessObject(final String currentName);
	}

	/**
	 * Creates a new instance
	 * @param projectProvider the provider which returns the project being modified. The project is built during the modification process.
	 * @param modelChangeNotifier the model change notifier used to lock the model
	 * @param boSupplier the supplier of the model element to modify
	 * @param newName the name to which the model element should be renamed
	 * @param originalName the current name of the model element.
	 */
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
		final EObject bo = boSupplier.getBusinessObject(originalName);
		if (bo == null) {
			throw new GraphicalEditorException("Unable to retrieve business object to rename.");
		}

		return renameWithLtk(bo, newName)
				? new LtkRenameAction(projectProvider, modelChangeNotifier, boSupplier, originalName, newName)
						: null;
	}

	/**
	 * Renames the specified model element using an LTK rename refactoring.
	 * @param bo the model element to rename
	 * @param value the new name for the model element
	 * @return true if the rename occurred
	 */
	private boolean renameWithLtk(final EObject bo, final String value) {
		// Lock the diagram to treat all model change notifications as part of the current action.
		// Prevent model notification changes from being sent until after the refactoring
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
					protected void execute(IProgressMonitor monitor) throws CoreException {
						// Perform the modification
						change.perform(monitor);

						// Build the project, reconcile all open AADL text editors and then build again.
						// This seems to be the best way to ensure that all the model change events have been
						// queued before the model change notification lock is released
						buildProject();
						ensureReconciled() ;
						buildProject();
					}
				}.run(null);
			} catch (final InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new GraphicalEditorException(e);
			} catch (final RuntimeException | InvocationTargetException | CoreException e) {
				throw new GraphicalEditorException(e);
			}
		}
		return true;
	}

	/**
	 * Performs an incremental build of the project returned by the project provider
	 */
	private void buildProject() {
		try {
			projectProvider.getProject().build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
		} catch (final CoreException e) {
			// Log and ignore any errors that occur while building the project
			StatusManager.getManager()
			.handle(new Status(IStatus.ERROR, FrameworkUtil.getBundle(getClass()).getSymbolicName(),
					"Error building projects during rename", e), StatusManager.LOG);
		}
	}

	/**
	 * Ensure that all AADL text editors have been reconciled.
	 */
	private void ensureReconciled() {
		final String languageName = getLanguageName();
		for (final IEditorReference editorRef : PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow()
				.getActivePage()
				.getEditorReferences()) {
			final IEditorPart editor = editorRef.getEditor(false);
			if (editor instanceof XtextEditor) {
				final XtextEditor xtextEditor = (XtextEditor) editor;

				// Only ensure reconciliation of AADL editors
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
	}

	/**
	 * Configures the refactoring to rename the model element to the specified name and checks conditions.
	 * @param refactoring the refactoring object which will be used to rename the model element.
	 * @param newName the new name for the model element
	 * @return the status of the refactoring operation. An OK status indicates that the refactoring can proceed.
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

	/**
	 * Class that is used with a dependency injector to retrieve the language name used the AADL Xtext editors
	 *
	 */
	private static class LanguageNameRetriever {
		@Inject
		@Named(org.eclipse.xtext.Constants.LANGUAGE_NAME)
		public String languageName;
	}

	/**
	 * Retrieves the AADL xtext language name by injecting it into a new object.
	 * @return the language name used by AADL Xtext editors.
	 */
	private static String getLanguageName() {
		final Injector injector = Objects.requireNonNull(
				Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2),
				"Unable to retrieve injector");

		final LanguageNameRetriever obj = injector.getInstance(LanguageNameRetriever.class);
		return obj.languageName;
	}
}