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
package org.osate.ge.internal.ui.handlers;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.function.Consumer;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.ge.EmfContainerProvider;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.Delete;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.DeleteRaw;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.model.EmbeddedBusinessObject;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.AadlModificationService.Modification;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.util.AnnotationUtil;
import org.osate.ge.internal.util.DiagramElementUtil;
import org.osate.ge.services.ReferenceBuilderService;

import com.google.common.base.Predicates;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

public class DeleteHandler extends AbstractHandler {
	@Override
	public void setEnabled(final Object evaluationContext) {
		final boolean enabled = calculateEnabled(evaluationContext);
		setBaseEnabled(enabled);
	}

	private boolean calculateEnabled(final Object evaluationContext) {
		final IEditorPart activeEditor = AgeHandlerUtil.getActiveEditorFromContext(evaluationContext);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			return false;
		}

		final AgeDiagramEditor ageEditor = (AgeDiagramEditor) activeEditor;
		final GraphitiAgeDiagram graphitiAgeDiagram = ageEditor.getGraphitiAgeDiagram();
		if (graphitiAgeDiagram == null) {
			return false;
		}

		final ExtensionService extensionService = Objects.requireNonNull(
				(ExtensionService) ageEditor.getAdapter(ExtensionService.class),
				"Unable to retrieve extension service");

		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();

		return canExecute(selectedDiagramElements, extensionService);
	}

	private boolean canExecute(final List<DiagramElement> selectedDiagramElements,
			final ExtensionService extensionService) {
		if (selectedDiagramElements.size() == 0) {
			return false;
		}

		// Don't allow deleting multiple objects if one of the objects is inside an annex
		if (selectedDiagramElements.size() > 1 && anyIsInAnnex(selectedDiagramElements)) {
			return false;
		}

		// If DeleteRaw is going to be used, then only allow deleting a single element at a time.
		if (anyRequiresRawDelete(selectedDiagramElements) && selectedDiagramElements.size() != 1) {
			return false;
		}

		for (final DiagramElement de : selectedDiagramElements) {
			if (!canDelete(de, extensionService)) {
				return false;
			}
		}

		return true;
	}

	private boolean canDelete(final DiagramElement de, final ExtensionService extService) {
		final Object bo = de.getBusinessObject();

		final Object boHandler = de.getBusinessObjectHandler();
		if (boHandler == null) {
			return false;
		}

		if (!AnnotationUtil.hasMethodWithAnnotation(CanDelete.class, boHandler)) {
			return false;
		}

		// Don't allow proxies.
		if (bo instanceof EObject) {
			final EObject eobj = ((EObject) bo);
			if (eobj.eIsProxy()) {
				return false;
			}

			// Prevent deletion of resources which are part of plugins
			final Resource res = eobj.eResource();
			if (res != null && res.getURI().isPlatformPlugin()) {
				return false;
			}
		}

		final IEclipseContext childCtx = extService.createChildContext();
		try {
			childCtx.set(Names.BUSINESS_OBJECT, bo);
			childCtx.set(Names.BUSINESS_OBJECT_CONTEXT, de);
			return (boolean) ContextInjectionFactory.invoke(boHandler, CanDelete.class, childCtx, false);
		} finally {
			childCtx.dispose();
		}
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		final AgeDiagramEditor ageEditor = (AgeDiagramEditor) activeEditor;

		final ExtensionService extensionService = Objects.requireNonNull(
				(ExtensionService) ageEditor.getAdapter(ExtensionService.class),
				"Unable to retrieve extension service");
		final ReferenceBuilderService refBuilder = Objects.requireNonNull(
				(ReferenceBuilderService) ageEditor.getAdapter(ReferenceBuilderService.class),
				"Unable to retrieve reference builder service");
		final AadlModificationService aadlModificationService = Objects.requireNonNull(
				(AadlModificationService) ageEditor.getAdapter(AadlModificationService.class),
				"Unable to retrieve modification service");

		// Get diagram and selected elements
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		if (!canExecute(selectedDiagramElements, extensionService)) {
			throw new RuntimeException("canExecute() returned false");
		}

		if (!confirmDelete(selectedDiagramElements)) {
			return null;
		}

		final boolean boIsContext = anyBoIsDiagramContext(selectedDiagramElements, ageEditor.getAgeDiagram(),
				refBuilder);

		ageEditor.getActionExecutor().execute("Delete", ExecutionMode.NORMAL, () -> {
			if (anyRequiresRawDelete(selectedDiagramElements)) {
				if (selectedDiagramElements.size() != 1) {
					throw new RuntimeException("Deleting multiple elements when using DeleteRaw is not supported");
				}

				deleteRaw(selectedDiagramElements.get(0), extensionService);
			} else if (anyIsInAnnex(selectedDiagramElements)) {
				if (selectedDiagramElements.size() != 1) {
					throw new RuntimeException(
							"Deleting multiple elements when deleting an element inside of an annex is not supported");
				}

				// Handle annex specially because we need to modify the annex itself instead of the root of the model.
				// Only a single annex element can be modified at a time because modifying annex elements as part of a
				// group is not supported.
				final BusinessObjectRemoval modInfo = createBusinessObjectRemovalOrRemoveDiagramElement(
						selectedDiagramElements.get(0),
						extensionService);
				if (modInfo != null) {
					aadlModificationService.modify(modInfo.staleBoToModify, (boToModify) -> {
						modInfo.remover.accept(boToModify);
					});
				}

			} else {
				// Group elements to be removed by resource. All the elements will be removed as part of the same modification.
				// This ensures that the appropriate element is retrieved regardless of the order in the model or the URI scheme.
				final ListMultimap<Resource, BusinessObjectRemoval> removals = ArrayListMultimap.create();
				for (final DiagramElement de : selectedDiagramElements) {
					final BusinessObjectRemoval removal = createBusinessObjectRemovalOrRemoveDiagramElement(de,
							extensionService);
					if (removal != null) {
						removals.put(removal.staleBoToModify.eResource(), removal);
					}
				}

				// Perform the modifications. One modification will be performed for each resource.
				final List<AadlModificationService.Modification<?, ?>> modifications = new ArrayList<>();
				for (final Entry<Resource, Collection<BusinessObjectRemoval>> entry : removals.asMap().entrySet()) {
					final Resource resource = entry.getKey();
					final EObject root = Objects.requireNonNull(resource.getContents().get(0),
							"unable to retrieve root element");
					final Modification<EObject, EObject> mod = AadlModificationService.Modification.create(root,
							(rootToModify) -> {
								// Store objects which should be modified. This is performed before any modifications to the resource
								// so that the correct object will be removed regardless of URI scheme. Otherwise, the object's URI
								// could change in between removals and an incorrect element will be removed.
								for (final BusinessObjectRemoval removal : entry.getValue()) {
									final URI uri = EcoreUtil.getURI(removal.staleBoToModify);
									Objects.requireNonNull(uri,
											"unable to retrieve uri for " + removal.staleBoToModify);
									removal.boToModify = rootToModify.eResource().getResourceSet().getEObject(uri,
											true);
								}

								// Remove the business object using the stored business object to modify
								for (final BusinessObjectRemoval removal : entry.getValue()) {
									removal.remover.accept(removal.boToModify);
								}
							});
					modifications.add(mod);
				}

				if (!modifications.isEmpty()) {
					aadlModificationService.modify(modifications);
				}
			}

			return null;
		});

		if (boIsContext) {
			// Close the editor if the context was deleted
			Display.getDefault().syncExec(() -> ageEditor.close());
		} else {
			// Clear selection
			ageEditor.selectPictogramElements(new PictogramElement[0]);
		}

		return null;
	}

	/**
	 * Stores information regarding business objects being removed.
	 *
	 */
	private static class BusinessObjectRemoval {
		public final EObject staleBoToModify; // The non-live version of the business object which should be passed to the remover.
		public final Consumer<EObject> remover; // Performs the removal by modifying the passed in business object.
		public EObject boToModify; // Populated during the modification process. The live version of the owner business object.

		public BusinessObjectRemoval(final EObject staleBoToModify, final Consumer<EObject> remover) {
			this.staleBoToModify = Objects.requireNonNull(staleBoToModify, "staleBoToModify must not be null");
			this.remover = Objects.requireNonNull(remover, "remover must not be null");
		}
	}

	/**
	 * Creates a BusinessObjectRemoval object which can be used to remove the business object for the diagram element.
	 * If the diagram element's business object is an embedded business object, remove the element.
	 * @param de
	 * @param extService
	 * @return
	 */
	private static BusinessObjectRemoval createBusinessObjectRemovalOrRemoveDiagramElement(final DiagramElement de,
			final ExtensionService extService) {
		// Remove the EObject from the model
		final Object bo = de.getBusinessObject();

		final Object boHandler = de.getBusinessObjectHandler();
		if (bo instanceof EObject) {
			final EObject boEObj = (EObject) bo;
			return new BusinessObjectRemoval(boEObj, (boToModify) -> {
				EcoreUtil.remove(boToModify);
			});
		} else if (bo instanceof EmfContainerProvider) {
			final EObject ownerBo = ((EmfContainerProvider) bo).getEmfContainer();
			return new BusinessObjectRemoval(ownerBo, (boToModify) -> {
				// Call delete
				final IEclipseContext eclipseCtx = extService.createChildContext();
				try {
					eclipseCtx.set(Names.BUSINESS_OBJECT, bo);
					eclipseCtx.set(Names.MODIFY_BO, boToModify);
					ContextInjectionFactory.invoke(boHandler, Delete.class, eclipseCtx);
				} finally {
					eclipseCtx.dispose();
				}
			});
		} else if (bo instanceof EmbeddedBusinessObject) {
			// For embedded business objects, there isn't a model from which to remove the business object.
			// Instead, we remove the diagram element and return null.
			final AgeDiagram diagram = DiagramElementUtil.getDiagram(de);
			diagram.modify("Delete Element", m -> m.removeElement(de));
			return null;
		} else {
			// canDelete() should have returned false in this case
			throw new RuntimeException("Unhandled case: " + bo);
		}
	}

	private static void deleteRaw(final DiagramElement de, final ExtensionService extService) {
		// Call raw delete method
		final Object bo = de.getBusinessObject();
		final Object boHandler = de.getBusinessObjectHandler();
		final IEclipseContext eclipseCtx = extService.createChildContext();
		try {
			eclipseCtx.set(Names.BUSINESS_OBJECT, bo);
			ContextInjectionFactory.invoke(boHandler, DeleteRaw.class, eclipseCtx);
		} finally {
			eclipseCtx.dispose();
		}
	}

	private static boolean confirmDelete(final List<DiagramElement> diagramElements) {
		if (diagramElements.size() == 1) {
			final Object bo = diagramElements.get(0).getBusinessObject();
			if (bo == null) {
				return false;
			}

			final String elementName = (bo instanceof NamedElement) ? ((NamedElement) bo).getQualifiedName() : null;
			final String msg = (elementName != null)
					? MessageFormat.format("Are you sure you want to delete ''{0}''?", elementName)
							: "Are you sure you want to delete this element?";
					if (!MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
							"Confirm Delete", msg)) {
						return false;
					}
		} else {
			final String msg = MessageFormat.format("Are you sure you want to delete {0} elements?",
					diagramElements.size());
			if (!MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					"Confirm Delete", msg)) {
				return false;
			}
		}

		return true;
	}

	private static boolean anyBoIsDiagramContext(final List<DiagramElement> diagramElements, final AgeDiagram diagram,
			final ReferenceBuilderService refBuilder) {
		final CanonicalBusinessObjectReference diagramContextRef = diagram.getConfiguration().getContextBoReference();
		return diagramElements.stream().map(de -> refBuilder.getCanonicalReference(de.getBusinessObject()))
				.filter(Predicates.notNull()).anyMatch(boRef -> boRef.equals(diagramContextRef));
	}

	private static boolean anyIsInAnnex(final List<DiagramElement> diagramElements) {
		return diagramElements.stream().map(DiagramElement::getBusinessObject).anyMatch(DeleteHandler::isInAnnex);
	}

	private static boolean anyRequiresRawDelete(final List<DiagramElement> diagramElements) {
		return diagramElements.stream()
				.anyMatch(bo -> AnnotationUtil.hasMethodWithAnnotation(DeleteRaw.class, bo.getBusinessObjectHandler()));
	}

	private static boolean isInAnnex(final Object bo) {
		for (Object tmp = getContainer(bo); tmp != null; tmp = getContainer(tmp)) {
			if (tmp instanceof AnnexLibrary || tmp instanceof AnnexSubclause) {
				return true;
			}
		}

		return false;
	}

	private static Object getContainer(final Object bo) {
		if (bo instanceof EmfContainerProvider) {
			return ((EmfContainerProvider) bo).getEmfContainer();
		} else if (bo instanceof EObject) {
			return ((EObject) bo).eContainer();
		} else {
			return null;
		}
	}
}