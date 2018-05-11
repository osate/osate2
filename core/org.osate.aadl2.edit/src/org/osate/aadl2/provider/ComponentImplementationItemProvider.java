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
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
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
 * $Id: ComponentImplementationItemProvider.java,v 1.31 2011-04-11 13:36:14 lwrage Exp $
 */
package org.osate.aadl2.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.ComponentImplementation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentImplementationItemProvider extends ComponentClassifierItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentImplementationItemProvider(AdapterFactory adapterFactory) {
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

			addTypePropertyDescriptor(object);
			addOwnedSubcomponentPropertyDescriptor(object);
			addExtendedPropertyDescriptor(object);
			addOwnedConnectionPropertyDescriptor(object);
			addNoSubcomponentsPropertyDescriptor(object);
			addNoConnectionsPropertyDescriptor(object);
			addNoCallsPropertyDescriptor(object);
			addOwnedProcessorFeaturePropertyDescriptor(object);
			addOwnedInternalFeaturePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ComponentImplementation_type_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_ComponentImplementation_type_feature",
								"_UI_ComponentImplementation_type"),
						Aadl2Package.eINSTANCE.getComponentImplementation_Type(), true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Owned Subcomponent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOwnedSubcomponentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ComponentImplementation_ownedSubcomponent_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ComponentImplementation_ownedSubcomponent_feature",
						"_UI_ComponentImplementation_type"),
				Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent(), false, false, false, null, null,
				null));
	}

	/**
	 * This adds a property descriptor for the No Subcomponents feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNoSubcomponentsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ComponentImplementation_noSubcomponents_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ComponentImplementation_noSubcomponents_feature",
						"_UI_ComponentImplementation_type"),
				Aadl2Package.eINSTANCE.getComponentImplementation_NoSubcomponents(), true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the No Calls feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNoCallsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ComponentImplementation_noCalls_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_ComponentImplementation_noCalls_feature",
								"_UI_ComponentImplementation_type"),
						Aadl2Package.eINSTANCE.getComponentImplementation_NoCalls(), true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Owned Processor Feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOwnedProcessorFeaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ComponentImplementation_ownedProcessorFeature_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_ComponentImplementation_ownedProcessorFeature_feature",
								"_UI_ComponentImplementation_type"),
						Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature(), false, false, false,
						null, null, null));
	}

	/**
	 * This adds a property descriptor for the Owned Internal Feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOwnedInternalFeaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ComponentImplementation_ownedInternalFeature_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ComponentImplementation_ownedInternalFeature_feature", "_UI_ComponentImplementation_type"),
				Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature(), false, false, false, null,
				null, null));
	}

	/**
	 * This adds a property descriptor for the No Connections feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNoConnectionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ComponentImplementation_noConnections_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ComponentImplementation_noConnections_feature",
						"_UI_ComponentImplementation_type"),
				Aadl2Package.eINSTANCE.getComponentImplementation_NoConnections(), true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Extended feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExtendedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ComponentImplementation_extended_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ComponentImplementation_extended_feature",
						"_UI_ComponentImplementation_type"),
				Aadl2Package.eINSTANCE.getComponentImplementation_Extended(), true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Owned Connection feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOwnedConnectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ComponentImplementation_ownedConnection_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ComponentImplementation_ownedConnection_feature",
						"_UI_ComponentImplementation_type"),
				Aadl2Package.eINSTANCE.getComponentImplementation_OwnedConnection(), false, false, false, null, null,
				null));
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
			childrenFeatures.add(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedFlowImplementation());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedExtension());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedRealization());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedEndToEndFlow());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedAbstractSubcomponent());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedAccessConnection());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedParameterConnection());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedPortConnection());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedFeatureConnection());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedFeatureGroupConnection());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedEventSource());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedEventDataSource());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedPortProxy());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubprogramProxy());
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ComponentImplementation) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_ComponentImplementation_type")
				: getString("_UI_ComponentImplementation_type") + " " + label;
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

		switch (notification.getFeatureID(ComponentImplementation.class)) {
		case Aadl2Package.COMPONENT_IMPLEMENTATION__NO_SUBCOMPONENTS:
		case Aadl2Package.COMPONENT_IMPLEMENTATION__NO_CONNECTIONS:
		case Aadl2Package.COMPONENT_IMPLEMENTATION__NO_CALLS:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EXTENSION:
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_REALIZATION:
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_CONNECTION:
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_SOURCE:
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_PROXY:
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedFlowImplementation(),
						Aadl2Factory.eINSTANCE.createFlowImplementation()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedExtension(),
				Aadl2Factory.eINSTANCE.createImplementationExtension()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedRealization(),
						Aadl2Factory.eINSTANCE.createRealization()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedEndToEndFlow(),
						Aadl2Factory.eINSTANCE.createEndToEndFlow()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedAbstractSubcomponent(),
						Aadl2Factory.eINSTANCE.createAbstractSubcomponent()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedAccessConnection(),
						Aadl2Factory.eINSTANCE.createAccessConnection()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedParameterConnection(),
						Aadl2Factory.eINSTANCE.createParameterConnection()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedPortConnection(),
						Aadl2Factory.eINSTANCE.createPortConnection()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedFeatureConnection(),
						Aadl2Factory.eINSTANCE.createFeatureConnection()));

		newChildDescriptors.add(
				createChildParameter(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedFeatureGroupConnection(),
						Aadl2Factory.eINSTANCE.createFeatureGroupConnection()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedEventSource(),
						Aadl2Factory.eINSTANCE.createEventSource()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedEventDataSource(),
						Aadl2Factory.eINSTANCE.createEventDataSource()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedPortProxy(),
				Aadl2Factory.eINSTANCE.createPortProxy()));

		newChildDescriptors
				.add(createChildParameter(Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubprogramProxy(),
						Aadl2Factory.eINSTANCE.createSubprogramProxy()));
	}

}
