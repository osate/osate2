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
package org.osate.ge.internal.ui.editor;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.NamedElement;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.ProjectUtil;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.internal.util.AgeAadlUtil;
import org.osate.ge.aadl2.internal.util.RenameUtil;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.CanRenameContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.DiagramService.ReferenceCollection;
import org.osate.ge.internal.services.DiagramService.UpdatedReferenceValueProvider;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.ui.LtkRenameAction;
import org.osate.ge.services.ReferenceBuilderService;

/**
 * Utility class for renaming elements. Intended to be used when implementing interactive renaming from the graphical editor.
 */
public class EditorRenameUtil {
	private EditorRenameUtil() {
	}

	public static String getCurrentName(final DiagramElement de) {
		return de.getBusinessObjectHandler().getNameForRenaming(new GetNameContext(de.getBusinessObject()));
	}

	/**
	 * Checks the validity of a new name for an element.
	 * @param de the element which is being renamed.
	 * @param newName the new name
	 * @return null if the name is valid. Otherwise, returns a descriptions of the validation error.
	 */
	public static String validateName(final DiagramElement de, final String newName) {
		return RenameUtil.checkNewNameValidity(de.getBusinessObject(), de.getBusinessObjectHandler(), newName);
	}

	public static boolean canRename(final DiagramElement de) {
		final Object bo = de.getBusinessObject();

		// Only EObjects are supported at this time
		if (!(bo instanceof EObject)) {
			return false;
		}

		final BusinessObjectHandler handler = de.getBusinessObjectHandler();
		if (!handler.canRename(new CanRenameContext(bo))) {
			return false;
		}

		if (!RenameUtil.supportsNonLtkRename(handler) && RenameUtil.getRenameRefactoring(bo) == null) {
			return false;
		}

		return true;
	}

	public static void rename(final DiagramElement de, final String value, final InternalDiagramEditor editor) {
		final ReferenceBuilderService referenceBuilder = Objects.requireNonNull(
				editor.getAdapter(ReferenceBuilderService.class), "Unable to retrieve reference builder service");
		final DiagramService diagramService = Objects.requireNonNull(editor.getAdapter(DiagramService.class),
				"Unable to retrieve diagram service");
		final AadlModificationService aadlModService = Objects.requireNonNull(
				editor.getAdapter(AadlModificationService.class), "Unable to retrieve AADL modification service");
		final ProjectProvider projectProvider = Objects.requireNonNull(editor.getAdapter(ProjectProvider.class),
				"Unable to retrieve project provider");
		final ActionExecutor actionExecutor = editor.getActionExecutor();
		final ModelChangeNotifier modelChangeNotifier = Objects.requireNonNull(
				editor.getAdapter(ModelChangeNotifier.class), "Unable to retrieve model change notifier");

		final EObject bo = (EObject) de.getBusinessObject();
		final BusinessObjectHandler handler = de.getBusinessObjectHandler();
		final String initialValue = getCurrentName(de);

		// If the business object handler provides a Rename method, then use it to rename the element instead of using LTK refactoring.
		if (RenameUtil.supportsNonLtkRename(handler)) {
			final CanonicalBusinessObjectReference canonicalRef = referenceBuilder.getCanonicalReference(bo);
			final IProject project = ProjectUtil.getProjectOrNull(EcoreUtil.getURI(bo));
			final ReferenceCollection references;
			if (canonicalRef == null || project == null) {
				references = null;
			} else {
				final Set<IProject> relevantProjects = ProjectUtil.getAffectedProjects(project, new HashSet<>());
				references = diagramService.getReferences(relevantProjects, Collections.singleton(canonicalRef));
			}

			aadlModService.modify(bo, (boToModify) -> {
				RenameUtil.performNonLtkRename(boToModify, handler, value);

				// Update diagram references. This is done in the modify block because the project is build and the diagram is updated before the modify()
				// function returns.
				final CanonicalBusinessObjectReference newCanonicalRef = referenceBuilder
						.getCanonicalReference(boToModify);
				final RelativeBusinessObjectReference newRelRef = referenceBuilder.getRelativeReference(boToModify);

				if (newCanonicalRef != null && newRelRef != null) {
					references.update(new UpdatedReferenceValueProvider() {
						@Override
						public CanonicalBusinessObjectReference getNewCanonicalReference(
								final CanonicalBusinessObjectReference originalCanonicalReference) {
							if (originalCanonicalReference.equals(canonicalRef)) {
								return newCanonicalRef;
							}

							return null;
						}

						@Override
						public RelativeBusinessObjectReference getNewRelativeReference(
								final CanonicalBusinessObjectReference originalCanonicalReference) {
							if (originalCanonicalReference.equals(canonicalRef)) {
								return newRelRef;
							}

							return null;
						}
					});
				}
			});
		} else { // Rename using LTK
			actionExecutor.execute("Rename Element " + initialValue + " to " + value,
					ActionExecutor.ExecutionMode.NORMAL,
					new LtkRenameAction(projectProvider, modelChangeNotifier, new BoSupplier(de), value, initialValue));
		}
	}

	/**
	 * Supplier that returns the latest business object from a diagram element but prevents memory leaks by only retaining a
	 * weak reference to the diagram element.
	 *
	 */
	private static class BoSupplier implements LtkRenameAction.BusinessObjectSupplier {
		private final WeakReference<DiagramElement> weakDiagramElement;

		public BoSupplier(final DiagramElement diagramElement) {
			this.weakDiagramElement = new WeakReference<>(
					Objects.requireNonNull(diagramElement, "diagramElement must not be null"));
		}

		@Override
		public EObject getBusinessObject(final String currentName) {
			final DiagramElement de = weakDiagramElement.get();
			if (de == null) {
				return null;
			}

			Object bo = de.getBusinessObject();
			if (bo instanceof NamedElement) {
				bo = AgeAadlUtil.getRootRefinedElement((NamedElement) bo);
			}
			return bo instanceof EObject ? (EObject) bo : null;
		}
	}
}
