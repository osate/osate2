package org.osate.ge.internal.ui.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.util.Strings;
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
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.internal.AgeDiagramProvider;
import org.osate.ge.internal.di.Deactivate;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.di.SelectionChanged;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramConfigurationBuilder;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.AadlModificationService.Modification;
import org.osate.ge.internal.services.AadlModificationService.SimpleModifier;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.xtext.aadl2.properties.util.DeploymentProperties;
import org.osate.xtext.aadl2.properties.util.GetProperties;

/**
 * The Set Binding Action presents a non-modal dialog to the user that allows create a property association for a standard AADL binding property.
 * Assumes that all selected elements are descendants of the same component implementation
 */
public class SetBindingTool {
	public static final String setBindingIdentifier = "org.osate.ge.SetBinding";
	private SetBindingWindow currentWindow = null;

	@Activate
	public void activate(@Named(InternalNames.SELECTED_DIAGRAM_ELEMENTS) final BusinessObjectContext[] selectedBocs,
			final AgeDiagramProvider diagramProvider,
			final AadlModificationService aadlModService,
			final UiService uiService) {
		try {
			final BusinessObjectContext componentImplementationBoc = ToolUtil
					.findComponentImplementationBoc(selectedBocs[0]);

			// Open Dialog
			if (currentWindow == null && componentImplementationBoc != null) {
				currentWindow = new SetBindingWindow(Display.getCurrent().getActiveShell(), componentImplementationBoc,
						selectedBocs);
				if(currentWindow.open() == Window.OK) {
					// Ensure the diagram is configured to show the specified binding property
					final AgeDiagram diagram = diagramProvider.getAgeDiagram();
					if (!diagram.getConfiguration().getEnabledAadlPropertyNames()
							.contains(currentWindow.getSelectedProperty().getQualifiedName().toLowerCase())) {
						diagram.modify("Configure Diagram", m -> {
							m.setDiagramConfiguration(new DiagramConfigurationBuilder(diagram.getConfiguration()).
									addAadlProperty(currentWindow.getSelectedProperty().getQualifiedName()).
									build());
						});
					}

					// Create the property association
					createPropertyAssociations(aadlModService);
				}

				currentWindow = null;
			}
		} finally {
			uiService.deactivateActiveTool();
		}
	}

	@SelectionChanged
	public void onSelectionChanged(@Named(InternalNames.SELECTED_DIAGRAM_ELEMENTS) final DiagramElement[] selectedDiagramElements) {
		if(currentWindow != null && currentWindow.getShell() != null && currentWindow.getShell().isVisible()) {
			currentWindow.setTargetBusinessObjectContexts(selectedDiagramElements);
		}
	}

	@Deactivate
	public void deactivate(final UiService uiService) {
		if(currentWindow != null) {
			currentWindow.cancel();
			currentWindow = null;
		}
	}

	private static class SetBindingWindow extends TitleAreaDialog {
		private final BusinessObjectContext componentImplementationBoc;
		private final BusinessObjectContext[] bocsToBind;
		private final NamedElement[] elementsToBind;
		private ComboViewer bindingPropertyCombo;
		private Label selectionStatusLabel;
		private IStructuredSelection currentPropComboSel;
		private BusinessObjectContext[] targetBocs = new BusinessObjectContext[0];
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

		public SetBindingWindow(final Shell parentShell,
				final BusinessObjectContext componentImplementationBoc,
				final BusinessObjectContext[] bocsToBind) {
			super(parentShell);
			this.componentImplementationBoc = Objects.requireNonNull(componentImplementationBoc, "componentImplementationBoc must not be null");
			this.bocsToBind = Objects.requireNonNull(bocsToBind, "bocsToBind must not be null");
			this.elementsToBind = Arrays.stream(bocsToBind).map(boc -> (NamedElement) boc.getBusinessObject())
					.toArray(size -> new NamedElement[size]);
			setShellStyle(SWT.RESIZE | SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE);
			setHelpAvailable(false);
		}

		@Override
		public void create() {
			super.create();

			setTitle("Select Elements");
			setMessage("Select a binding property and the elements from the diagram to bind " + Arrays
					.stream(elementsToBind).map(e -> Strings.emptyIfNull(e.getName())).collect(Collectors.joining(","))
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
			addPropertyIfApplicable(bindingProperties, GetProperties.lookupPropertyDefinition(elementsToBind[0],
					DeploymentProperties._NAME, DeploymentProperties.ACTUAL_CONNECTION_BINDING));
			addPropertyIfApplicable(bindingProperties, GetProperties.lookupPropertyDefinition(elementsToBind[0],
					DeploymentProperties._NAME, DeploymentProperties.ALLOWED_CONNECTION_BINDING));
			addPropertyIfApplicable(bindingProperties, GetProperties.lookupPropertyDefinition(elementsToBind[0],
					DeploymentProperties._NAME, DeploymentProperties.ACTUAL_FUNCTION_BINDING));
			addPropertyIfApplicable(bindingProperties, GetProperties.lookupPropertyDefinition(elementsToBind[0],
					DeploymentProperties._NAME, DeploymentProperties.ACTUAL_MEMORY_BINDING));
			addPropertyIfApplicable(bindingProperties, GetProperties.lookupPropertyDefinition(elementsToBind[0],
					DeploymentProperties._NAME, DeploymentProperties.ALLOWED_MEMORY_BINDING));
			addPropertyIfApplicable(bindingProperties, GetProperties.lookupPropertyDefinition(elementsToBind[0],
					DeploymentProperties._NAME, DeploymentProperties.ACTUAL_PROCESSOR_BINDING));
			addPropertyIfApplicable(bindingProperties, GetProperties.lookupPropertyDefinition(elementsToBind[0],
					DeploymentProperties._NAME, DeploymentProperties.ALLOWED_PROCESSOR_BINDING));

			// Create combo box for selection type
			bindingPropertyCombo = new ComboViewer(container, SWT.DROP_DOWN | SWT.READ_ONLY);
			bindingPropertyCombo.getControl().setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
			bindingPropertyCombo.getControl().setData(UiUtil.AUTOMATED_SWTBOT_TESTING_KEY, setBindingIdentifier);
			bindingPropertyCombo.setContentProvider(new ArrayContentProvider());
			bindingPropertyCombo.setLabelProvider(propertyLabelProvider);
			bindingPropertyCombo.setInput(bindingProperties);
			bindingPropertyCombo.addSelectionChangedListener(event -> {
				setSelectedProperty((IStructuredSelection) bindingPropertyCombo.getSelection());
				validate();
			});

			selectionStatusLabel = new Label(container, SWT.WRAP);
			selectionStatusLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			return container;
		}

		// Returns whether a property is applicable to the element to bind
		private boolean isApplicable(final Property property) {
			return Arrays.stream(elementsToBind).allMatch(e -> isApplicableForElement(property, e));
		}

		private static boolean isApplicableForElement(final Property property, final NamedElement element) {
			for (final MetaclassReference mcr : property.getAppliesToMetaclasses()) {
				if (mcr.getMetaclass() != null && mcr.getMetaclass().isSuperTypeOf(element.eClass())) {
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
				selectionStatusLabel.setText("Elements selected: " + targetBocs.length);
				final Property selectedProperty = getSelectedProperty();
				if (selectedProperty == null) {
					selectionStatusLabel.setText("Select a binding property.");
				} else {
					final ListType listType = (ListType) selectedProperty.getPropertyType();
					final ReferenceType refType = (ReferenceType) listType.getElementType();

					// Check target business object context
					validationSuccessful = true;
					for (final BusinessObjectContext targetBoc : targetBocs) {
						boolean boIsValid = false;
						if(ToolUtil.findComponentImplementationBoc(targetBoc) == componentImplementationBoc) {
							final Element bo = (Element)targetBoc.getBusinessObject();
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
			return super.close();
		}

		public BusinessObjectContext getComponentImplementationBoc() {
			return componentImplementationBoc;
		}

		public BusinessObjectContext[] getBocsToBind() {
			return bocsToBind;
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

		public void setTargetBusinessObjectContexts(final BusinessObjectContext[] value) {
			targetBocs = value;
			if(getShell() != null && !getShell().isDisposed()) {
				validate();
			}
		}

		public BusinessObjectContext[] getTargetBocs() {
			return targetBocs;
		}
	};

	private void createPropertyAssociations(final AadlModificationService aadlModService) {
		final BusinessObjectContext ciBoc = currentWindow.getComponentImplementationBoc();
		final ComponentImplementation ci = (ComponentImplementation)ciBoc.getBusinessObject();
		aadlModService.modify(Modification.create(ci, new SimpleModifier<ComponentClassifier>() {
			@Override
			public void modify(final ComponentClassifier ci) {
				for (final BusinessObjectContext bocToBind : currentWindow.getBocsToBind()) {
					final PropertyAssociation newPa = Aadl2Factory.eINSTANCE.createPropertyAssociation();

					// Set property
					newPa.setProperty(currentWindow.getSelectedProperty());

					// Set applies to
					if (ciBoc != bocToBind) {
						setContainedNamedElementPath(newPa.createAppliesTo(), ciBoc, bocToBind);
					}

					// Create owned values
					final ModalPropertyValue pv = newPa.createOwnedValue();
					final ListValue lv = (ListValue) pv.createOwnedValue(Aadl2Factory.eINSTANCE.getAadl2Package()
							.getListValue());

					for (final BusinessObjectContext targetBoc : currentWindow.getTargetBocs()) {
						// Ignore diagram selections
						final ReferenceValue rv = (ReferenceValue) lv.createOwnedListElement(Aadl2Factory.eINSTANCE.getAadl2Package().getReferenceValue());
						setContainedNamedElementPath(rv, ciBoc, targetBoc);
					}

					removeOldPropertyAssociation(ci, newPa);

					// Add the property association
					ci.setNoProperties(false);
					ci.getOwnedPropertyAssociations().add(newPa);
				}
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

							// Delete the property association if it was the last element in the applies to clause
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
		}));
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
			if (cp1.getNamedElement().getName() != null
					&& !cp1.getNamedElement().getName().equalsIgnoreCase(cp2.getNamedElement().getName())) {
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

	private ContainmentPathElement setContainedNamedElementPath(final ContainedNamedElement c, final BusinessObjectContext ciBoc, BusinessObjectContext bocToAdd) {
		if (bocToAdd == null || bocToAdd == ciBoc) {
			return null;
		}

		// Create the path element for the container
		ContainmentPathElement pathElement = setContainedNamedElementPath(c, ciBoc, bocToAdd.getParent());

		// Create the path element for the business object context
		final NamedElement bo = (NamedElement)bocToAdd.getBusinessObject();
		if (bo != null) {
			pathElement = (pathElement == null) ? c.createPath() : pathElement.createPath();
			pathElement.setNamedElement(bo);
		}

		return pathElement;
	}
}
