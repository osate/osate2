/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 *
 * $Id: ComponentInstanceItemProvider.java,v 1.6 2010-05-12 20:09:31 lwrage Exp $
 */
package org.osate.aadl2.instance.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.SystemInstance;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.instance.ComponentInstance} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentInstanceItemProvider extends ConnectionInstanceEndItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstanceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addCategoryPropertyDescriptor(object);
			addInModePropertyDescriptor(object);
			addSubcomponentPropertyDescriptor(object);
			addIndexPropertyDescriptor(object);
			addClassifierPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Category feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCategoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ComponentInstance_category_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_ComponentInstance_category_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_ComponentInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.COMPONENT_INSTANCE__CATEGORY, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the In Mode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInModePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ComponentInstance_inMode_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_ComponentInstance_inMode_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_ComponentInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.COMPONENT_INSTANCE__IN_MODE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Subcomponent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSubcomponentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ComponentInstance_subcomponent_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_ComponentInstance_subcomponent_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_ComponentInstance_type"), //$NON-NLS-1$
				InstancePackage.Literals.COMPONENT_INSTANCE__SUBCOMPONENT, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Index feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIndexPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ComponentInstance_index_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_ComponentInstance_index_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_ComponentInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.COMPONENT_INSTANCE__INDEX, true, false, false,
						ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Classifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClassifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ComponentInstance_classifier_feature"), //$NON-NLS-1$
						getString("_UI_PropertyDescriptor_description", "_UI_ComponentInstance_classifier_feature", //$NON-NLS-1$//$NON-NLS-2$
								"_UI_ComponentInstance_type"), //$NON-NLS-1$
						InstancePackage.Literals.COMPONENT_INSTANCE__CLASSIFIER, true, false, true, null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(InstancePackage.Literals.COMPONENT_INSTANCE__FEATURE_INSTANCE);
			childrenFeatures.add(InstancePackage.Literals.COMPONENT_INSTANCE__COMPONENT_INSTANCE);
			childrenFeatures.add(InstancePackage.Literals.COMPONENT_INSTANCE__MODE_INSTANCE);
			childrenFeatures.add(InstancePackage.Literals.COMPONENT_INSTANCE__MODE_TRANSITION_INSTANCE);
			childrenFeatures.add(InstancePackage.Literals.COMPONENT_INSTANCE__FLOW_SPECIFICATION);
			childrenFeatures.add(InstancePackage.Literals.COMPONENT_INSTANCE__END_TO_END_FLOW);
			childrenFeatures.add(InstancePackage.Literals.COMPONENT_INSTANCE__CONNECTION_INSTANCE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ComponentInstance.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		ComponentCategory cat = ((ComponentInstance) object).getCategory();
		String name = "ComponentInstance";
		if (cat != null) {
			name = cat.getLiteral();
			int idx = name.indexOf(" ");
			if (idx < 0) {
				name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase() + ".gif";
			} else {
				name = name.substring(0, 1).toUpperCase() + name.substring(1, idx).toLowerCase()
						+ name.substring(idx + 1, idx + 2).toUpperCase() + name.substring(idx + 2).toLowerCase()
						+ ".gif";
			}
		}
		if (object instanceof SystemInstance) {
			name = "System";
		}
		return overlayImage(object, getResourceLocator().getImage("full/obj16/" + name)); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		ComponentInstance ci = (ComponentInstance) object;
		String label = ci.getFullName();
		String ctype = ci.getCategory().getName();
		return (ctype == null || ctype.length() == 0 ? getString("_UI_ComponentInstance_type") : ctype) //$NON-NLS-1$
				+ (label == null || label.length() == 0 ? "" : " " + label);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ComponentInstance.class)) {
		case InstancePackage.COMPONENT_INSTANCE__CATEGORY:
		case InstancePackage.COMPONENT_INSTANCE__INDEX:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case InstancePackage.COMPONENT_INSTANCE__FEATURE_INSTANCE:
		case InstancePackage.COMPONENT_INSTANCE__COMPONENT_INSTANCE:
		case InstancePackage.COMPONENT_INSTANCE__MODE_INSTANCE:
		case InstancePackage.COMPONENT_INSTANCE__MODE_TRANSITION_INSTANCE:
		case InstancePackage.COMPONENT_INSTANCE__FLOW_SPECIFICATION:
		case InstancePackage.COMPONENT_INSTANCE__END_TO_END_FLOW:
		case InstancePackage.COMPONENT_INSTANCE__CONNECTION_INSTANCE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

}
