package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.ArraySize;
import org.osate.aadl2.ArrayableElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.DiagramElementProxy;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.di.ModifiesBusinessObjects;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.ui.dialogs.EditDimensionsDialog;
import org.osate.ge.internal.ui.util.SelectionHelper;

@ModifiesBusinessObjects
public class SetDimensionsCommand {
	private static final StandaloneDiagramElementQuery parentQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestor(1));

	@GetLabel
	public String getLabel() {
		return "Modify Dimensions...";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final ArrayableElement ae,
			@Named(InternalNames.DIAGRAM_ELEMENT_PROXY) final DiagramElementProxy diagramElement,
			final QueryService queryService) {
		final Object diagram = queryService.getFirstBusinessObject(parentQuery, diagramElement);
		return ae.getContainingClassifier() == diagram;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final ArrayableElement ae) {
		final EditDimensionsDialog dlg = new EditDimensionsDialog(Display.getCurrent().getActiveShell(), SelectionHelper.getProject(ae.eResource()), ae.getArrayDimensions(), ae instanceof Subcomponent);
		if(dlg.open() == Dialog.CANCEL) {
			return false;
		}
		// Replace the element's array dimensions in a round about way.
		// For some reason, if the dimension is a dimension property and it is replaced with a copy, the aadl source is updated properly but the reference to the property is broken.
		for(int dimIndex = 0; dimIndex < dlg.getDimensions().size(); dimIndex++) {
			final ArrayDimension newDimension = dlg.getDimensions().get(dimIndex);
			if(ae.getArrayDimensions().size() > dimIndex) {
				// See if it changed
				final ArrayDimension oldDimension = ae.getArrayDimensions().get(dimIndex);
				final ArraySize oldSize = oldDimension.getSize();
				final ArraySize newSize = newDimension.getSize();
				boolean equals = false;
				if(oldSize == null && newSize == null) {
					equals = true;
				} else if(oldSize != null && newSize != null) {
					// Possibly equals
					if(oldSize.getSizeProperty() == null && newSize.getSizeProperty() == null) {
						if(oldSize.getSize() == newSize.getSize()) {
							equals = true;
						}
					} else if(oldSize.getSizeProperty() instanceof NamedElement && newSize.getSizeProperty() instanceof NamedElement) {
						final NamedElement oldSizeProperty = (NamedElement)oldSize.getSizeProperty();
						final NamedElement newSizeProperty = (NamedElement)newSize.getSizeProperty();
						if(newSizeProperty.getQualifiedName() != null && newSizeProperty.getQualifiedName().equalsIgnoreCase(oldSizeProperty.getQualifiedName())) {
							equals = true;
						}
					}
				}

				if(!equals) {
					ae.getArrayDimensions().set(dimIndex, newDimension);
				}
			} else {
				// Add the array dimension
				ae.getArrayDimensions().add(newDimension);
			}     				
		}

		// Remove array dimensions that are not in the specified list so that the dimensions will match
		while(ae.getArrayDimensions().size() > dlg.getDimensions().size()) {
			ae.getArrayDimensions().remove(dlg.getDimensions().size());
		}

		// Add imports as needed
		// Get current package
		if(ae.getElementRoot() instanceof AadlPackage) {
			final PackageSection section = ((AadlPackage)ae.getElementRoot()).getPublicSection();
			if(section != null) {
				// Import packages if necessary
				for(final ArrayDimension dim : ae.getArrayDimensions()) {
					if(dim.getSize() != null) {
						final ArraySize size = dim.getSize();
						if(size.getSizeProperty() instanceof Element) {
							final Element sizeProperty = (Element)size.getSizeProperty();

							if(sizeProperty.getElementRoot() instanceof ModelUnit) {
								final ModelUnit propertyModelUnit = (ModelUnit)sizeProperty.getElementRoot();
								if(propertyModelUnit.getQualifiedName() != null && !AadlUtil.isPredeclaredPropertySet(propertyModelUnit.getQualifiedName())) {
									boolean imported = false;
									for(final ModelUnit importedUnit : section.getImportedUnits()) {
										if(propertyModelUnit.getQualifiedName().equalsIgnoreCase(importedUnit.getQualifiedName())) {
											imported = true;
										}
									}

									if(!imported) {
										section.getImportedUnits().add((ModelUnit)sizeProperty.getElementRoot());
									}
								}
							}
						}
					}
				}
			}
		}

		return true;
	}
}
