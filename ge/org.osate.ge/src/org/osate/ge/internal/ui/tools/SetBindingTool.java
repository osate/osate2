/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.ListType;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.MetaclassReference;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.ReferenceType;
import org.osate.aadl2.ReferenceValue;
import org.osate.ge.di.Activate;
import org.osate.ge.di.CanActivate;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.di.Deactivate;
import org.osate.ge.internal.di.Description;
import org.osate.ge.internal.di.Icon;
import org.osate.ge.internal.di.Id;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.di.SelectionChanged;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.GraphitiService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.xtext.aadl2.properties.util.DeploymentProperties;
import org.osate.xtext.aadl2.properties.util.GetProperties;

/**
 * The Set Binding Action presents a non-modal dialog to the user that allows create a property association for a standard AADL binding property.
 *
 */
public class SetBindingTool {
	private SetBindingWindow currentWindow = null;

	@Id
	public final static String ID = "org.osate.ge.ui.tools.SetBindingTool";
	
	@Description
	public final static String DESCRIPTION = "Bind...";

	@Icon
	public final static ImageDescriptor ICON = Activator.getImageDescriptor("icons/SetBinding.gif");

	@CanActivate
	public boolean canActivate(final GraphitiService graphiti, final BusinessObjectResolutionService bor) {
		return getSelectedPictogramElement((AgeDiagramEditor)graphiti.getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer(), bor) != null && 
				currentWindow == null && 
				bor.getBusinessObjectForPictogramElement(graphiti.getDiagram()) instanceof ComponentImplementation;
	}
	
	@Activate
	public void activate(final GraphitiService graphiti, final BusinessObjectResolutionService bor, final AadlModificationService aadlModService, final DiagramModificationService diagramModService, final ConnectionService connectionService) {
		final AgeDiagramEditor editor = (AgeDiagramEditor)graphiti.getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer();

		// Open Dialog
		if (currentWindow == null) {
			currentWindow = new SetBindingWindow(editor.getSite().getShell(), bor, getSelectedPictogramElement(editor, bor));
			if(currentWindow.open() == Dialog.OK) {
				createPropertyAssociation(graphiti.getDiagramTypeProvider().getDiagram(), bor, aadlModService, diagramModService, connectionService);
			}
			
			currentWindow = null;
		}
	}
	
	@SelectionChanged
	public void onSelectionChanged(@Named(InternalNames.SELECTED_PICTOGRAM_ELEMENTS) final PictogramElement[] selectedPes, final GraphitiService graphiti,
			final BusinessObjectResolutionService bor, final ShapeService shapeService, final ConnectionService connectionService) {
		if(currentWindow != null && currentWindow.getShell() != null && currentWindow.getShell().isVisible()) {
			final TransactionalEditingDomain editingDomain = graphiti.getDiagramTypeProvider().getDiagramBehavior().getEditingDomain();
			editingDomain.getCommandStack().execute(new NonUndoableToolCommand() {
				@Override
				public void execute() {
					if(currentWindow != null) {
						currentWindow.setTargetPictogramElements(selectedPes);
					}
				}
			});
		}
	}
	
	@Deactivate
	public void deactivate(final GraphitiService graphiti, final UiService uiService) {
		final TransactionalEditingDomain editingDomain = graphiti.getDiagramTypeProvider().getDiagramBehavior().getEditingDomain();
		editingDomain.getCommandStack().execute(new NonUndoableToolCommand() {
			@Override
			public void execute() {
				if(currentWindow != null) {
					currentWindow.cancel();
					currentWindow = null;
				}
			}
		});
	}

	private static class SetBindingWindow extends TitleAreaDialog {
		private final BusinessObjectResolutionService bor;
		private final PictogramElement pictogramToBind;
		private final NamedElement elementToBind;
		private ComboViewer bindingPropertyCombo;
		private Label selectionStatusLabel;
		private IStructuredSelection currentPropComboSel;
		private PictogramElement[] targetPictogramElements = new PictogramElement[0];
		private final LabelProvider propertyLabelProvider = new LabelProvider() {
	    	@Override
	    	public String getText(final Object element) {
	    		final Property p = (Property)element;
	    		if(p == null) {
	    			return "";
	    		}
	    		
	    		return p.getName();
	    	}
	    };
	    
		public SetBindingWindow(final Shell parentShell, final BusinessObjectResolutionService bor, final PictogramElement pictogramToBind) {
			super(parentShell);

			this.bor = bor;
			this.pictogramToBind = pictogramToBind;
			this.elementToBind = (NamedElement) bor.getBusinessObjectForPictogramElement(pictogramToBind);

			setShellStyle(SWT.RESIZE | SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE);
			setHelpAvailable(false);
		}

		@Override
		public void create() {
			super.create();

			setTitle("Select Elements");
			setMessage("Select a binding property and the elements from the diagram to bind " + elementToBind.getName()
					+ ".");
			validate();
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			final Composite container = (Composite) super.createDialogArea(parent);

			final GridLayout layout = new GridLayout();
			layout.marginHeight = IDialogConstants.VERTICAL_MARGIN;
			layout.marginWidth = IDialogConstants.HORIZONTAL_MARGIN;
			layout.verticalSpacing = IDialogConstants.VERTICAL_SPACING;
			layout.horizontalSpacing = IDialogConstants.HORIZONTAL_SPACING;
			container.setLayout(layout);

			final List<Property> bindingProperties = new ArrayList<Property>();
			addPropertyIfApplicable(bindingProperties, GetProperties.lookupPropertyDefinition(elementToBind,
					DeploymentProperties._NAME, DeploymentProperties.ACTUAL_CONNECTION_BINDING));
			addPropertyIfApplicable(bindingProperties, GetProperties.lookupPropertyDefinition(elementToBind,
					DeploymentProperties._NAME, DeploymentProperties.ALLOWED_CONNECTION_BINDING));
			addPropertyIfApplicable(bindingProperties, GetProperties.lookupPropertyDefinition(elementToBind,
					DeploymentProperties._NAME, DeploymentProperties.ACTUAL_FUNCTION_BINDING));
			addPropertyIfApplicable(bindingProperties, GetProperties.lookupPropertyDefinition(elementToBind,
					DeploymentProperties._NAME, DeploymentProperties.ACTUAL_MEMORY_BINDING));
			addPropertyIfApplicable(bindingProperties, GetProperties.lookupPropertyDefinition(elementToBind,
					DeploymentProperties._NAME, DeploymentProperties.ALLOWED_MEMORY_BINDING));
			addPropertyIfApplicable(bindingProperties, GetProperties.lookupPropertyDefinition(elementToBind,
					DeploymentProperties._NAME, DeploymentProperties.ACTUAL_PROCESSOR_BINDING));
			addPropertyIfApplicable(bindingProperties, GetProperties.lookupPropertyDefinition(elementToBind,
					DeploymentProperties._NAME, DeploymentProperties.ALLOWED_PROCESSOR_BINDING));

			// Create combo box for selection type
			bindingPropertyCombo = new ComboViewer(container, SWT.DROP_DOWN | SWT.READ_ONLY);
			bindingPropertyCombo.getControl().setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
			bindingPropertyCombo.setContentProvider(new ArrayContentProvider());
			bindingPropertyCombo.setLabelProvider(propertyLabelProvider);
			bindingPropertyCombo.setInput(bindingProperties);
			bindingPropertyCombo.addSelectionChangedListener(new ISelectionChangedListener() {
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					setSelectedProperty((IStructuredSelection) bindingPropertyCombo.getSelection());
					validate();
				}
			});

			selectionStatusLabel = new Label(container, SWT.WRAP);
			selectionStatusLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			return container;
		}

		// Returns whether a property is applicable to the element to bind
		private boolean isApplicable(final Property property) {
			for (final MetaclassReference mcr : property.getAppliesToMetaclasses()) {
				if (mcr.getMetaclass() != null && mcr.getMetaclass().isSuperTypeOf(elementToBind.eClass())) {
					return true;
				}
			}

			return false;
		}

		// Adds a property to the collection if it is applicable to the element to bind
		private void addPropertyIfApplicable(final Collection<Property> properties, final Property property) {
			if (isApplicable(property)) {
				properties.add(property);
			}
		}

		@SuppressWarnings("unchecked")
		private void validate() {
			boolean validationSuccessful = false;
			if (((List<Property>) bindingPropertyCombo.getInput()).size() == 0) {
				selectionStatusLabel.setText("No applicable binding properties.");
			} else {
				selectionStatusLabel.setText("Elements selected: " + targetPictogramElements.length);
				final Property selectedProperty = getSelectedProperty();
				if (selectedProperty == null) {
					selectionStatusLabel.setText("Select a binding property.");
				} else {
					final ListType listType = (ListType) selectedProperty.getPropertyType();
					final ReferenceType refType = (ReferenceType) listType.getElementType();

					// Check target pictogram elements...
					validationSuccessful = true;
					for (final PictogramElement targetPe : targetPictogramElements) {
					
						boolean boIsValid = false;
						final Element bo = (Element) bor.getBusinessObjectForPictogramElement(targetPe);
						
						if (bo != null) {
							// The root element can not be a target element
							if (!(bo instanceof Classifier)) {
								for (final MetaclassReference mcr : refType.getNamedElementReferences()) {
									if (mcr.getMetaclass() != null && mcr.getMetaclass().isSuperTypeOf(bo.eClass())) {
										boIsValid = true;
										break;
									}
								}
							}
						}
						
						// Show an error message if the BO is not valid
						if (!boIsValid) {
							validationSuccessful = false;
							selectionStatusLabel.setText("One or more of the selected target elements are not valid.");
							break;
						}
						
					}
				}
			}
			
			final Button okButton = getButton(IDialogConstants.OK_ID);
			okButton.setEnabled(validationSuccessful);
		}

		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("Bind");
			newShell.setSize(400, 225);
			newShell.setMinimumSize(250, 220);
		}

		public void cancel() {
			setReturnCode(CANCEL);
			close();
		}

		@Override
		public boolean close() {
			//closeListener.onClosed();
			return super.close();
		}

		public PictogramElement getPictogramToBind() {
			return pictogramToBind;
		}

		public Property getSelectedProperty() {
			if (currentPropComboSel instanceof StructuredSelection) {
				final StructuredSelection selection = (StructuredSelection) currentPropComboSel;
				return (Property) selection.getFirstElement();
			}

			return null;
		}
		
		public void setSelectedProperty(final IStructuredSelection propComboSelection) {
			currentPropComboSel = propComboSelection;
		}

		public void setTargetPictogramElements(final PictogramElement[] value) {
			targetPictogramElements = value;
			if(getShell() != null && !getShell().isDisposed()) {
				validate();
			}
		}

		public PictogramElement[] getTargetPictogramElements() {
			return targetPictogramElements;
		}
	};

	/**
	 * Returns the selected pictogram element. If there is more than one pictogram element selected, or if it is a diagram, then null is returned.
	 * @return
	 */
	private static PictogramElement getSelectedPictogramElement(final AgeDiagramEditor editor, final BusinessObjectResolutionService bor) {
		if (editor.getSelectedPictogramElements().length != 1) {
			return null;
		}

		final PictogramElement pe = editor.getSelectedPictogramElements()[0];
		if (pe instanceof Diagram) {
			return null;
		}

		if (bor.getBusinessObjectForPictogramElement(pe) instanceof NamedElement) {
			return pe;
		}
		
		return null;
	}

	private void createPropertyAssociation(final Diagram diagram, final BusinessObjectResolutionService bor, final AadlModificationService aadlModService, 
			final DiagramModificationService diagramModService, final ConnectionService connectionService) {
		final ComponentClassifier cc = (ComponentClassifier) bor.getBusinessObjectForPictogramElement(diagram);

		if (cc == null) {
			throw new RuntimeException("Unexpected case. Unable to find component classifier");
		} else {
			aadlModService.modify(cc, new AbstractModifier<ComponentClassifier, Object>() {
				private DiagramModificationService.Modification diagramMod;

				@Override
				public Object modify(final Resource resource, final ComponentClassifier cc) {
					// Start the diagram modification
					diagramMod = diagramModService.startModification();

					final PropertyAssociation newPa = Aadl2Factory.eINSTANCE.createPropertyAssociation();
					
					// Set property
					newPa.setProperty(currentWindow.getSelectedProperty());

					// Set applies to
					final Object elementToBind = bor.getBusinessObjectForPictogramElement(currentWindow.getPictogramToBind());
					final Object diagramBo = bor.getBusinessObjectForPictogramElement(diagram);
					if (elementToBind != null && elementToBind != diagramBo) {
						setContainedNamedElementPath(newPa.createAppliesTo(), currentWindow.getPictogramToBind(), bor, connectionService);
					}

					// Create owned values
					final ModalPropertyValue pv = newPa.createOwnedValue();
					final ListValue lv = (ListValue) pv.createOwnedValue(Aadl2Factory.eINSTANCE.getAadl2Package()
							.getListValue());

					for (final PictogramElement pe : currentWindow.getTargetPictogramElements()) {
						// Ignore diagram selections
						if (!(pe instanceof Diagram)) {
							final ReferenceValue rv = (ReferenceValue) lv.createOwnedListElement(Aadl2Factory.eINSTANCE
									.getAadl2Package().getReferenceValue());
							setContainedNamedElementPath(rv, pe, bor, connectionService);
						}
					}

					removeOldPropertyAssociation(cc, newPa);

					// Add the property association
					cc.setNoProperties(false);
					cc.getOwnedPropertyAssociations().add(newPa);

					diagramMod.markOpenRelatedDiagramsAsDirty(cc);
					
					return null;
				}

				// Deletes any existing property associations/removes the bound element from any property associations that matches the property association
				// being created.
				private void removeOldPropertyAssociation(final ComponentClassifier cc, final PropertyAssociation newPa) {
					final List<PropertyAssociation> propertyAssociationsToDelete = new ArrayList<PropertyAssociation>();
					for (final PropertyAssociation existingPa : cc.getOwnedPropertyAssociations()) {
						// If Property matches
						if (newPa.getProperty().getFullName().equals(existingPa.getProperty().getFullName())) {
							if (existingPa.getAppliesTos().size() == 0 || newPa.getAppliesTos().size() == 0) {
								if (existingPa.getAppliesTos().size() == 0 && newPa.getAppliesTos().size() == 0) {
									propertyAssociationsToDelete.add(existingPa);
								}
							} else {
								final List<ContainedNamedElement> containedElementsToDelete = new ArrayList<ContainedNamedElement>();
								for (final ContainedNamedElement existingContainedElement : existingPa.getAppliesTos()) {
									if (containmentPathsMatch(existingContainedElement.getPath(), newPa.getAppliesTos()
											.get(0).getPath())) {
										// Add the contained element to the list of objects to delete
										containedElementsToDelete.add(existingContainedElement);
									}
								}

								// Delete objects
								for (final EObject ce : containedElementsToDelete) {
									EcoreUtil.delete(ce);
								}

								// Delete the property association of it was the last element in the applies to clause
								if (existingPa.getAppliesTos().size() == 0) {
									propertyAssociationsToDelete.add(existingPa);
								}

							}
						}
					}

					// Delete property association(s) that are being replaced
					for (final PropertyAssociation pa : propertyAssociationsToDelete) {
						EcoreUtil.delete(pa);
					}
				}

				@Override
				public void beforeCommit(final Resource resource, final ComponentClassifier cc,
						final Object modificationResult) {
					diagramMod.commit();
				}
			});
		}
	}

	private boolean containmentPathsMatch(ContainmentPathElement cp1, ContainmentPathElement cp2) {
		if (cp1 == cp2) {
			return true;
		}

		if (cp1 == null || cp2 == null) {
			return false;
		}

		while (cp1 != null) {
			// Compare Named Elements
			if (cp1.getNamedElement() != cp2.getNamedElement()) {
				return false;
			}

			// Compare Array Ranges
			if (cp1.getArrayRanges().size() != cp2.getArrayRanges().size()) {
				return false;
			}

			for (int i = 0; i < cp1.getArrayRanges().size(); i++) {
				final ArrayRange ar1 = cp1.getArrayRanges().get(i);
				final ArrayRange ar2 = cp2.getArrayRanges().get(i);
				if (ar1.getUpperBound() != ar2.getUpperBound() || ar1.getLowerBound() != ar2.getLowerBound()) {
					return false;
				}
			}

			// Annex Name
			if (cp1.getAnnexName() != cp2.getAnnexName()
					&& (cp1.getAnnexName() != null && !cp1.getAnnexName().equalsIgnoreCase(cp2.getAnnexName()))) {
				return false;
			}

			cp1 = cp1.getPath();
			cp2 = cp2.getPath();
		}

		return cp1 == cp2; // Both should be null
	}

	private ContainmentPathElement setContainedNamedElementPath(final ContainedNamedElement c, final PictogramElement pe, final BusinessObjectResolutionService bor, final ConnectionService connectionService) {
		if (pe == null || bor.getBusinessObjectForPictogramElement(pe) instanceof Classifier) {
			return null;
		}

		// Get the container/owner
		final Shape container;
		if (pe instanceof Connection) {
			container = connectionService.getOwnerShape((Connection) pe);
		} else if (pe instanceof Shape) {
			container = ((Shape) pe).getContainer();
		} else {
			container = null;
		}

		if (container == null) {
			throw new RuntimeException("Unable to get container for pictogram element type: " + pe.getClass());
		}

		// Create the path element for the container
		ContainmentPathElement pathElement = setContainedNamedElementPath(c, container, bor, connectionService);

		// Create the path element for the pictogram element
		final NamedElement bo = (NamedElement) bor.getBusinessObjectForPictogramElement(pe);
		if (bo != null) {
			pathElement = (pathElement == null) ? c.createPath() : pathElement.createPath();
			pathElement.setNamedElement(bo);
		}

		return pathElement;
	}

}
