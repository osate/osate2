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
package org.osate.ge.internal.ui.editor.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.resources.IProject;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ComponentTypeRename;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.DiagramNodePredicates;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.model.EmbeddedBusinessObject;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.AadlModificationService.SimpleModifier;
import org.osate.ge.internal.services.ClipboardService;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.handlers.AgeHandlerUtil;
import org.osate.ge.internal.util.AadlImportsUtil;
import org.osate.ge.internal.util.AadlNameUtil;
import org.osate.ge.internal.util.DiagramElementUtil;
import org.osate.ge.internal.util.RenameUtil;
import org.osate.ge.internal.util.classifiers.ClassifierCreationHelper;
import org.osate.ge.services.ReferenceBuilderService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.common.base.Predicates;

public class PasteAction extends ActionStackAction {
	private final ClipboardService.Clipboard clipboard;

	public PasteAction(final AgeDiagramEditor part) {
		super(part);

		setId(ActionFactory.PASTE.getId());
		setText("Paste");

		// Get clipboard
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
		this.clipboard = Objects.requireNonNull(context.get(ClipboardService.class), "Unable to get clipboard service")
				.getClipboard();
	}

	@Override
	public void run() {
		// Get services
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
		final AadlModificationService aadlModificationService = Objects.requireNonNull(
				context.getActive(AadlModificationService.class), "Unable to retrieve AADL modification service");
		final ReferenceBuilderService refBuilder = Objects.requireNonNull(
				context.getActive(ReferenceBuilderService.class), "Unable to retrieve reference builder service");
		final ProjectProvider projectProvider = Objects.requireNonNull(
				getWorkbenchPart().getAdapter(ProjectProvider.class), "Unable to retrieve project provider");
		final ExtensionService extService = Objects.requireNonNull(
				getWorkbenchPart().getAdapter(ExtensionService.class), "Unable to retrieve extension service");
		final NamingService namingService = Objects.requireNonNull(getWorkbenchPart().getAdapter(NamingService.class),
				"Unable to retrieve naming service");

		// This is safe because the constructor requires the part to be an AgeDiagramEditor.
		final AgeDiagramEditor editor = (AgeDiagramEditor) getWorkbenchPart();

		// Perform modification
		final DiagramNode dstDiagramNode = getDestinationDiagramNode();
		final EObject dstBo = getDestinationEObject(dstDiagramNode);
		final AgeDiagram diagram = DiagramElementUtil.getDiagram(dstDiagramNode);
		final List<DiagramElement> newDiagramElements = new ArrayList<>();
		diagram.modify("Paste", m -> {
			// The modifier will do the actual copying to the diagram elements. It will also copy the business objects
			// if the copied element includes the business object.
			final SimpleModifier<EObject> modifier = dstBoToModify -> {
				newDiagramElements.addAll(copyClipboardContents(dstBoToModify, dstDiagramNode, m, refBuilder,
						projectProvider, extService, namingService));
			};

			// If any non-embedded business objects have been copied, then modify the AADL model. Otherwise, just modify the diagram.
			final boolean anyHaveNonEmbeddedBo = getCopiedDiagramElements().stream()
					.anyMatch(de -> de.getCopiedBusinessObject() instanceof EObject);
			if (anyHaveNonEmbeddedBo) {
				aadlModificationService.modify(dstBo, modifier);
			} else {
				modifier.modify(null);
			}

			// Update the diagram. This will set business objects and update the diagram to be consistent.
			final AgeFeatureProvider featureProvider = (AgeFeatureProvider) editor.getDiagramTypeProvider()
					.getFeatureProvider();
			final DiagramUpdater diagramUpdater = featureProvider.getDiagramUpdater();
			diagramUpdater.updateDiagram(diagram);
		});

		// Update selection to match created diagram elements
		editor.selectDiagramElements(newDiagramElements.toArray(new DiagramElement[newDiagramElements.size()]));
	}

	/**
	 * Copies the clipboard contents to the destination business object and diagram element.
	 * @return the diagram elements which were created. Does not include children of created diagram elements.
	 */
	private Collection<DiagramElement> copyClipboardContents(final EObject dstBoToModify,
			final DiagramNode dstDiagramNode, final DiagramModification m, final ReferenceBuilderService refBuilder,
			final ProjectProvider projectProvider, final ExtensionService extService,
			final NamingService namingService) {
		// Determine the minimum coordinates from the elements whose positions will be copied
		// The minimum coordinates is null if none of the copied diagram elements have an absolute position. This is reasonable because the minimum coordinates
		// are only needed if a copied diagram element has an absolute position.
		final Point minCoordinates = getCopiedDiagramElements().stream().map(CopiedDiagramElement::getAbsolutePosition)
				.filter(Predicates.notNull()).reduce((a, b) -> new Point(Math.min(a.x, b.x), Math.min(a.y, b.y)))
				.orElse(null);

		// This list will contain the diagram elements that are created by the copying process. Does not contain their children.
		final List<DiagramElement> newDiagramElements = new ArrayList<>();

		// Copy each copied diagram element into the diagram and model.
		for (final CopiedDiagramElement copiedDiagramElement : getCopiedDiagramElements()) {
			final DiagramElement newDiagramElement;
			if (copiedDiagramElement.getCopiedBusinessObject() == null) {
				newDiagramElement = CopyAndPasteUtil.copyDiagramElement(copiedDiagramElement.getDiagramElement(),
						dstDiagramNode, copiedDiagramElement.getDiagramElement().getRelativeReference(), refBuilder);
			} else {
				final Object boFromCopiedDiagramElement = copiedDiagramElement.getCopiedBusinessObject();

				final RelativeBusinessObjectReference newRelativeRef;
				if (boFromCopiedDiagramElement instanceof EmbeddedBusinessObject) {
					// The relative reference will be assigned when copying the diagram element.
					newRelativeRef = null;
				} else if (boFromCopiedDiagramElement instanceof EObject) {
					// Get the list that to which the copied object will be added
					final EStructuralFeature compatibleFeature = getCompatibleStructuralFeature(
							copiedDiagramElement.getContainingFeature(), dstBoToModify.eClass());
					final Object containingFeatureValue = dstBoToModify.eGet(compatibleFeature);
					if (!(containingFeatureValue instanceof Collection)) {
						throw new RuntimeException("Unexpected case. Value of containing feature was not a collection");
					}
					@SuppressWarnings("unchecked")
					final Collection<EObject> containingFeatureValueCollection = (Collection<EObject>) containingFeatureValue;

					final EObject copiedEObject = EcoreUtil.copy((EObject) boFromCopiedDiagramElement);
					containingFeatureValueCollection.add(copiedEObject);

					ensureBusinessObjectHasUniqueName(copiedEObject,
							copiedDiagramElement.getDiagramElement().getBusinessObjectHandler(),
							copiedDiagramElement.getDiagramElement().getLabelName(), projectProvider.getProject(),
							namingService, extService);

					ensurePackagesAreImported(copiedEObject);

					newRelativeRef = refBuilder.getRelativeReference(copiedEObject);
				} else {
					throw new RuntimeException("Unsupported case:  " + boFromCopiedDiagramElement);
				}

				newDiagramElement = CopyAndPasteUtil.copyDiagramElement(copiedDiagramElement.getDiagramElement(),
						dstDiagramNode, newRelativeRef, refBuilder);
			}

			// Set the position of the new diagram element. They are positioned relative to each other at a fixed offset within the new parent.
			final Point cp = copiedDiagramElement.getAbsolutePosition();
			final Point newPosition = cp == null ? null
					: new Point(cp.x - minCoordinates.x + 50, cp.y - minCoordinates.y + 50);
			m.setPosition(newDiagramElement, newPosition);

			// Remove existing element
			final DiagramElement existingDiagramElement = dstDiagramNode
					.getByRelativeReference(newDiagramElement.getRelativeReference());
			if (existingDiagramElement != null) {
				m.removeElement(existingDiagramElement);
			}

			// Add the new diagram element to the diagram.
			m.addElement(newDiagramElement);

			newDiagramElements.add(newDiagramElement);
		}

		return newDiagramElements;
	}

	/**
	 * If the element is renameable and the name can be validated, then generate a name that passes validation.
	 * Otherwise, do not change the element's name. Contains special handling for component implementations.
	 * @param bo
	 * @param boHandler
	 * @param diagramElementName the name provided by the diagram element. Treated as the current name unless the business object handler provided an editing name using GetNameForEditing
	 * @param project
	 * @param namingService
	 * @param extService
	 */
	private static void ensureBusinessObjectHasUniqueName(final EObject bo, final Object boHandler,
			final String diagramElementName, final IProject project, final NamingService namingService,
			final ExtensionService extService) {
		if (supportsRenaming(bo, boHandler) && RenameUtil.hasValidateNameMethod(boHandler)) {
			// Determine the current name of the business object.
			final String originalName = RenameUtil.getCurrentEditingName(bo, boHandler, extService, diagramElementName);

			// See the name of the business object to something other than the current name so that name validation for the
			// copied business object will not treat the name as unchanged. For component implementations, the name needs to
			// contain the component type / component type alias appropriate for the destination package.
			if (bo instanceof ComponentImplementation) {
				final ComponentImplementation ci = (ComponentImplementation) bo;
				final ComponentType ct = ci.getType();
				final ClassifierCreationHelper classifierCreationHelper = new ClassifierCreationHelper(namingService,
						ci.eResource().getResourceSet());

				final String ciTypeName;
				if (ct == null) {
					ciTypeName = ci.getTypeName();
				} else {
					if (!AadlNameUtil.namesAreEqual(ci.getNamespace(), ct.getNamespace())) {
						if (!(ci.getNamespace() instanceof PackageSection)) {
							throw new RuntimeException(
									"New component implementation is not contained in a package section");
						}

						final PackageSection section = (PackageSection) ci.getNamespace();

						// Import the package if necessary
						final AadlPackage typePkg = (AadlPackage) ct.getNamespace().getOwner();
						AadlImportsUtil.addImportIfNeeded(section, typePkg);

						// Create an alias for the component type
						final ClassifierCreationHelper.RenamedTypeDetails aliasDetails = classifierCreationHelper
								.getRenamedType(section, typePkg, ct.getName());
						if (!aliasDetails.exists) {
							final ComponentTypeRename ctr = section.createOwnedComponentTypeRename();
							ctr.setName(aliasDetails.aliasName);
							ctr.setCategory(ct.getCategory());
							ctr.setRenamedComponentType(ct);
						}

						ciTypeName = aliasDetails.aliasName;
					} else {
						ciTypeName = ct.getName();
					}
				}

				setName(bo, boHandler, ciTypeName + ".osate_ge_temporary_name_00001", extService);
			} else {
				// Set name to dummy name so that validate name will work as expected. Many implementations
				// of validate name check if the name has changed.
				setName(bo, boHandler, "", extService);
			}

			// Determine a new name for the business object
			final String baseName = originalName;
			String newName = originalName;

			int count = 1;
			while (true) {
				final String result = RenameUtil.checkNewNameValidity(bo, boHandler, newName, project, extService);

				if (result == null) {
					break;
				}

				newName = baseName + "_copy" + (count == 1 ? "" : Integer.toString(count));
				count++;
			}

			// For component implementation's, build a new name using the current type name. getTypeName() returns a type name
			// based on the currently set name which could be an alias instead of getting the name from the referenced component type.
			// This is not added before this point because the component implementation business object handler requires that the
			// specified value does not include the type name.
			if (bo instanceof ComponentImplementation) {
				newName = ((ComponentImplementation) bo).getTypeName() + "." + newName;
			}

			// Update the business object's name
			setName(bo, boHandler, newName, extService);
		}
	}

	/**
	 * Updates the model to ensure packages referenced by the the BO or its children are imported into the BO's package.
	 * @param bo
	 */
	private static void ensurePackagesAreImported(final EObject bo) {
		final Classifier classifierToImport;

		// If copied element is a classifier(type, implementation or feature group) ensure import of package for extended classifier
		if (bo instanceof Classifier) {
			classifierToImport = ((Classifier) bo).getExtended();
		} else if (bo instanceof Subcomponent) { // If copied element is a subcomponent, ensure import of referenced classifier.
			classifierToImport = ((Subcomponent) bo).getClassifier();
		} else if (bo instanceof Feature) { // If copied element is a feature, ensure import of referenced classifier.
			classifierToImport = ((Feature) bo).getClassifier();
		} else {
			classifierToImport = null;
		}

		if (classifierToImport != null) {
			AadlImportsUtil.ensurePackageIsImportedForClassifier((Element) bo, classifierToImport);
		}

		for (final EObject child : bo.eContents()) {
			ensurePackagesAreImported(child);
		}
	}

	/**
	 * Returns true if the paste action supports renaming the business object
	 * @param bo
	 * @param handler
	 * @return
	 */
	private static boolean supportsRenaming(final Object bo, final Object handler) {
		if (bo instanceof NamedElement) {
			return true;
		}

		if (RenameUtil.supportsNonLtkRename(handler)) {
			return true;
		}

		return false;
	}

	private static void setName(final Object bo, final Object handler, final String newName,
			final ExtensionService extService) {
		if (bo instanceof NamedElement) {
			((NamedElement) bo).setName(newName);
		} else {
			RenameUtil.performNonLtkRename(bo, handler, newName, extService);
		}
	}

	@Override
	protected boolean calculateEnabled() {
		// Return value if this is called before constructor is finished
		if (clipboard == null) {
			return false;
		}

		final DiagramNode dstDiagramNode = getDestinationDiagramNode();
		if (dstDiagramNode == null) {
			return false;
		}

		final Collection<CopiedDiagramElement> copiedDiagramElements = getCopiedDiagramElements();
		if (copiedDiagramElements.isEmpty()) {
			return false;
		}

		final boolean anyEmbeddedBoCopied = copiedDiagramElements.stream()
				.anyMatch(de -> de.getCopiedBusinessObject() instanceof EmbeddedBusinessObject);
		final boolean anyEObjectCopied = copiedDiagramElements.stream()
				.anyMatch(de -> de.getCopiedBusinessObject() instanceof EObject);

		// Don't allow pasting inside an embedded business object.
		// Such objects are not supported because layout issues have been observed.
		return !(getBusinessObject(dstDiagramNode) instanceof EmbeddedBusinessObject)
				&& (!anyEmbeddedBoCopied || DiagramNodePredicates.isDiagramOrUndockedShape(dstDiagramNode))
				&& (!anyEObjectCopied || getDestinationEObject(dstDiagramNode) != null);
	}

	/**
	 * Returns the diagram node inside which contents will be pasted.
	 * @return the diagram node to use as a parent or null if there is not exactly one diagram node selected.
	 */
	private DiagramNode getDestinationDiagramNode() {
		// Only allow pasting if a single diagram node is selected.
		final List<DiagramNode> selectedDiagramNodes = AgeHandlerUtil.getSelectedDiagramNodes();
		if (selectedDiagramNodes.size() != 1) {
			return null;
		}

		return selectedDiagramNodes.get(0);
	}

	private static Object getBusinessObject(final DiagramNode dstDiagramNode) {
		if (!(dstDiagramNode instanceof DiagramElement)) {
			return null;
		}

		final DiagramElement dstDiagramElement = (DiagramElement) dstDiagramNode;
		return dstDiagramElement.getBusinessObject();
	}

	private EObject getDestinationEObject(final DiagramNode dstDiagramNode) {
		if (!(dstDiagramNode instanceof DiagramElement)) {
			return null;
		}

		final DiagramElement dstDiagramElement = (DiagramElement) dstDiagramNode;

		if (!(dstDiagramElement.getBusinessObject() instanceof EObject)) {
			return null;
		}

		EObject dstBo = (EObject) dstDiagramElement.getBusinessObject();

		final Collection<CopiedDiagramElement> copiedDiagramElements = getCopiedDiagramElements();
		if (copiedDiagramElements.size() == 0) {
			return null;
		}

		// Determine the business object inside which to copy the copied business objects
		while (dstBo != null) {
			// Check if all copied business objects may be copied to the potential destination business object
			final EClass dstBoEClass = dstBo.eClass();
			final boolean allElementsAreCompatible = copiedDiagramElements.stream().allMatch(
					copiedDiagramElement -> !(copiedDiagramElement.getCopiedBusinessObject() instanceof EObject)
					|| getCompatibleStructuralFeature(copiedDiagramElement.getContainingFeature(),
							dstBoEClass) != null);

			if (allElementsAreCompatible) {
				break;
			}

			// Select a new destination business object.
			if (dstBo instanceof ComponentImplementation) {
				dstBo = ((ComponentImplementation) dstBo).getType();
			} else if (dstBo instanceof Subcomponent) {
				dstBo = ((Subcomponent) dstBo).getAllClassifier();
			} else if (dstBo instanceof AadlPackage) {
				dstBo = ((AadlPackage) dstBo).getPublicSection();
			} else {
				dstBo = null;
			}
		}

		// Only allow pasting of the destination has a valid XtextResource
		if (dstBo != null && !(dstBo.eResource() instanceof XtextResource)) {
			return null;
		}

		return dstBo;
	}

	private Collection<CopiedDiagramElement> getCopiedDiagramElements() {
		final Object contents = clipboard.getContents();
		if (contents instanceof CopiedDiagramElements) {
			return ((CopiedDiagramElements) contents).getCopiedDiagramElements();
		}

		return Collections.emptyList();
	}

	private static EStructuralFeature getCompatibleStructuralFeature(final EStructuralFeature searchFeature,
			final EClass eClass) {
		if (!(searchFeature.getEType() instanceof EClass)) {
			return null;
		}

		final EClass searchEClass = (EClass) searchFeature.getEType();

		// Look for the structural feature
		for (final EStructuralFeature tmp : eClass.getEAllStructuralFeatures()) {
			if (Objects.equals(searchFeature.getName(), tmp.getName()) && searchFeature.isMany() == tmp.isMany()
					&& tmp.isChangeable()) {
				if (tmp.getEType() instanceof EClass) {
					final EClass tmpEClass = (EClass) tmp.getEType();
					if (tmpEClass.isSuperTypeOf(searchEClass)) {
						return tmp;
					}
				}
			}
		}

		return null;
	}
}
