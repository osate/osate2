/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ui.propertyview;

import java.util.ArrayList;
import java.util.StringJoiner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.xtext.aadl2.ui.MyAadl2Activator;

class PropertyColumnLabelProvider extends ColumnLabelProvider {
	private static final String MODE_ICON = "icons/propertyview/mode.gif";

	private static final String SCALAR_ICON = "icons/propertyview/scalar.gif";

	private static final String LIST_ICON = "icons/propertyview/list.gif";

	private static final String PROPERTY_SET_ICON = "icons/propertyview/property_set.gif";

	private final AadlPropertyView propertyView;

	/** Cached Icon for property set nodes */
	private Image propSetImage = null;

	/** Cached Icon for list property value nodes */
	private Image listImage = null;

	/** Cached Icon for scalar property value nodes */
	private Image scalarImage = null;

	/** Cached Icon for modes */
	private Image modeImage = null;

	PropertyColumnLabelProvider(AadlPropertyView propertyView) {
		this.propertyView = propertyView;
	}

	@Override
	public String getText(Object element) {
		if (!(element instanceof TreeEntry entry)) {
			return null;
		}
		return switch (entry.getTreeElement()) {
		case URI uri -> propertyView.safeRead(resourceSet -> switch (resourceSet.getEObject(uri, true)) {
			case PropertySet propertySet -> propertySet.getName();
			/* Property is a BasicProperty, so this also covers properties. */
			case BasicProperty basicProperty -> basicProperty.getName();
			case ModalPropertyValue modalPropertyValue -> inModesText(resourceSet, modalPropertyValue);
			case BasicPropertyAssociation basicPropertyAssociation -> basicPropertyAssociation.getProperty().getName();
			case null, default -> null;
		});
		case RangeElement rangeElement -> rangeElement.getLabel();
		case ListElement listElement -> "# " + listElement.getIndex();
		case null, default -> null;
		};
	}

	private String inModesText(ResourceSet resourceSet, ModalPropertyValue modalPropertyValue) {
		Iterable<? extends Mode> modes;
		if (modalPropertyValue.getAllInModes().isEmpty()) {
			/*
			 * This ModalPropertyValue exists in all modes that are not listed for other ModalPropertyValues.
			 */
			var association = (PropertyAssociation) modalPropertyValue.getOwner();
			var unlistedModes = new ArrayList<Mode>();
			for (var classifierMode : getModesFromClassifierThatDeclaresModes(
					resourceSet.getEObject(propertyView.getInput(), true))) {
				if (association.getOwnedValues()
						.stream()
						.noneMatch(ownedValue -> ownedValue.getAllInModes().contains(classifierMode))) {
					unlistedModes.add(classifierMode);
				}
			}
			modes = unlistedModes;
		} else {
			modes = modalPropertyValue.getAllInModes();
		}

		var names = new StringJoiner(", ");
		for (var mode : modes) {
			names.add(mode.getName());
		}
		return "in modes (" + names + ")";
	}

	/**
	 * Get the ComponentClassifier that declares the modes that may appear in "in modes" clauses
	 * property associations on this object.
	 */
	private static ComponentClassifier getClassifierThatDeclaresModes(EObject propertySrc) {
		if (propertySrc instanceof Subcomponent subcomponent) {
			// Subcomponent: use the classifier of the subcomponent
			return subcomponent.getClassifier();
		}
		// TODO: Check for instance model
		/*
		 * Find the nearest enclosing classifier. The below method could return a FeatureGroup in theory, but feature
		 * groups cannot have modes, so they wouldn't be encountered in this situation.
		 */
		return (ComponentClassifier) AadlUtil.getContainingClassifier(propertySrc);
	}

	private static Iterable<? extends Mode> getModesFromClassifierThatDeclaresModes(EObject propertySrc) {
		if (propertySrc instanceof InstanceObject instanceObject) {
			return instanceObject.getSystemInstance().getSystemOperationModes();
		}
		return getClassifierThatDeclaresModes(propertySrc).getAllModes();
	}

	@Override
	public Color getForeground(Object element) {
		if (!(element instanceof TreeEntry entry) || !(entry.getTreeElement() instanceof URI propertyURI)) {
			return null;
		}
		return propertyView.safeRead(resourceSet -> {
			var treeElementEObject = resourceSet.getEObject(propertyURI, true);
			boolean undefined;
			if (treeElementEObject instanceof Property) {
				var parentEntry = (TreeEntry) entry.getParent();
				undefined = propertyView.getPropertyStatus((URI) parentEntry.getTreeElement(),
						propertyURI) == PropertyStatus.UNDEFINED;
			} else {
				/* Reaching here already implies the element is not a Property. */
				undefined = treeElementEObject instanceof BasicProperty;
			}
			return undefined ? propertyView.getSite().getShell().getDisplay().getSystemColor(SWT.COLOR_RED) : null;
		});
	}

	@Override
	public Image getImage(Object element) {
		if (!(element instanceof TreeEntry entry) || !(entry.getTreeElement() instanceof URI propertyURI)) {
			return null;
		}
		return propertyView.safeRead(resourceSet -> switch (resourceSet.getEObject(propertyURI, true)) {
		case PropertySet propertySet -> {
			if (propSetImage == null) {
				propSetImage = MyAadl2Activator.getImageDescriptor(PROPERTY_SET_ICON).createImage();
			}
			yield propSetImage;
		}
		case Property property when property.isList() -> {
			if (listImage == null) {
				listImage = MyAadl2Activator.getImageDescriptor(LIST_ICON).createImage();
			}
			yield listImage;
		}
		case Property property -> {
			if (scalarImage == null) {
				scalarImage = MyAadl2Activator.getImageDescriptor(SCALAR_ICON).createImage();
			}
			yield scalarImage;
		}
		case ModalPropertyValue modalPropertyValue -> {
			if (modeImage == null) {
				modeImage = MyAadl2Activator.getImageDescriptor(MODE_ICON).createImage();
			}
			yield modeImage;
		}
		case null, default -> null;
		});
	}

	@Override
	public void dispose() {
		propSetImage = disposed(propSetImage);
		listImage = disposed(listImage);
		scalarImage = disposed(scalarImage);
		modeImage = disposed(modeImage);
		super.dispose();
	}

	private static Image disposed(Image image) {
		if (image != null) {
			image.dispose();
		}
		return null;
	}
}
