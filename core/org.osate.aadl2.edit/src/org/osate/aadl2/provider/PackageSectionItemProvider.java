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
 * $Id: PackageSectionItemProvider.java,v 1.28 2011-04-11 13:36:11 lwrage Exp $
 */
package org.osate.aadl2.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.PackageSection;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.PackageSection} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PackageSectionItemProvider extends NamespaceItemProvider implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageSectionItemProvider(AdapterFactory adapterFactory) {
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

			addImportedPackagePropertyDescriptor(object);
			addNoAnnexesPropertyDescriptor(object);
			addNoPropertiesPropertyDescriptor(object);
			addImportedPropertySetPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Imported Package feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImportedPackagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_PackageSection_importedPackage_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_PackageSection_importedPackage_feature",
						"_UI_PackageSection_type"), Aadl2Package.eINSTANCE.getPackageSection_ImportedPackage(), true,
				false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the No Properties feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNoPropertiesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_PackageSection_noProperties_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_PackageSection_noProperties_feature",
						"_UI_PackageSection_type"), Aadl2Package.eINSTANCE.getPackageSection_NoProperties(), true,
				false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Imported Property Set feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImportedPropertySetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_PackageSection_importedPropertySet_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_PackageSection_importedPropertySet_feature",
						"_UI_PackageSection_type"), Aadl2Package.eINSTANCE.getPackageSection_ImportedPropertySet(),
				true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the No Annexes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNoAnnexesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_PackageSection_noAnnexes_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_PackageSection_noAnnexes_feature",
						"_UI_PackageSection_type"), Aadl2Package.eINSTANCE.getPackageSection_NoAnnexes(), true, false,
				false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
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
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedAnnexLibrary());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedAbstractType());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedAbstractImplementation());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedBusType());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedBusImplementation());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedDataType());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedDataImplementation());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedDeviceType());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedDeviceImplementation());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedMemoryType());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedMemoryImplementation());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedProcessType());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedProcessorType());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedProcessImplementation());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedProcessorImplementation());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedSubprogramType());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedSubprogramImplementation());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedSubprogramGroupType());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedSubprogramGroupImplementation());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedSystemType());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedSystemImplementation());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedThreadType());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedThreadImplementation());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedThreadGroupType());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedThreadGroupImplementation());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedVirtualBusType());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedVirtualBusImplementation());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedVirtualProcessorType());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedVirtualProcessorImplementation());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getPackageSection_OwnedFeatureGroupType());
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
		String label = ((PackageSection) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_PackageSection_type")
				: getString("_UI_PackageSection_type") + " " + label;
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

		switch (notification.getFeatureID(PackageSection.class)) {
		case Aadl2Package.PACKAGE_SECTION__NO_ANNEXES:
		case Aadl2Package.PACKAGE_SECTION__NO_PROPERTIES:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case Aadl2Package.PACKAGE_SECTION__OWNED_ANNEX_LIBRARY:
		case Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_TYPE:
		case Aadl2Package.PACKAGE_SECTION__OWNED_ABSTRACT_IMPLEMENTATION:
		case Aadl2Package.PACKAGE_SECTION__OWNED_BUS_TYPE:
		case Aadl2Package.PACKAGE_SECTION__OWNED_BUS_IMPLEMENTATION:
		case Aadl2Package.PACKAGE_SECTION__OWNED_DATA_TYPE:
		case Aadl2Package.PACKAGE_SECTION__OWNED_DATA_IMPLEMENTATION:
		case Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_TYPE:
		case Aadl2Package.PACKAGE_SECTION__OWNED_DEVICE_IMPLEMENTATION:
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_TYPE:
		case Aadl2Package.PACKAGE_SECTION__OWNED_MEMORY_IMPLEMENTATION:
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_TYPE:
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_TYPE:
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESS_IMPLEMENTATION:
		case Aadl2Package.PACKAGE_SECTION__OWNED_PROCESSOR_IMPLEMENTATION:
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_TYPE:
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_IMPLEMENTATION:
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_TYPE:
		case Aadl2Package.PACKAGE_SECTION__OWNED_SUBPROGRAM_GROUP_IMPLEMENTATION:
		case Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_TYPE:
		case Aadl2Package.PACKAGE_SECTION__OWNED_SYSTEM_IMPLEMENTATION:
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_TYPE:
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_IMPLEMENTATION:
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_TYPE:
		case Aadl2Package.PACKAGE_SECTION__OWNED_THREAD_GROUP_IMPLEMENTATION:
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_TYPE:
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_BUS_IMPLEMENTATION:
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_TYPE:
		case Aadl2Package.PACKAGE_SECTION__OWNED_VIRTUAL_PROCESSOR_IMPLEMENTATION:
		case Aadl2Package.PACKAGE_SECTION__OWNED_FEATURE_GROUP_TYPE:
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

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPackageSection_OwnedAnnexLibrary(),
				Aadl2Factory.eINSTANCE.createDefaultAnnexLibrary()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPackageSection_OwnedAbstractType(),
				Aadl2Factory.eINSTANCE.createAbstractType()));

		newChildDescriptors.add(createChildParameter(
				Aadl2Package.eINSTANCE.getPackageSection_OwnedAbstractImplementation(),
				Aadl2Factory.eINSTANCE.createAbstractImplementation()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPackageSection_OwnedBusType(),
				Aadl2Factory.eINSTANCE.createBusType()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPackageSection_OwnedBusImplementation(),
				Aadl2Factory.eINSTANCE.createBusImplementation()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPackageSection_OwnedDataType(),
				Aadl2Factory.eINSTANCE.createDataType()));

		newChildDescriptors.add(createChildParameter(
				Aadl2Package.eINSTANCE.getPackageSection_OwnedDataImplementation(),
				Aadl2Factory.eINSTANCE.createDataImplementation()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPackageSection_OwnedDeviceType(),
				Aadl2Factory.eINSTANCE.createDeviceType()));

		newChildDescriptors.add(createChildParameter(
				Aadl2Package.eINSTANCE.getPackageSection_OwnedDeviceImplementation(),
				Aadl2Factory.eINSTANCE.createDeviceImplementation()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPackageSection_OwnedMemoryType(),
				Aadl2Factory.eINSTANCE.createMemoryType()));

		newChildDescriptors.add(createChildParameter(
				Aadl2Package.eINSTANCE.getPackageSection_OwnedMemoryImplementation(),
				Aadl2Factory.eINSTANCE.createMemoryImplementation()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPackageSection_OwnedProcessType(),
				Aadl2Factory.eINSTANCE.createProcessType()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPackageSection_OwnedProcessorType(),
				Aadl2Factory.eINSTANCE.createProcessorType()));

		newChildDescriptors.add(createChildParameter(
				Aadl2Package.eINSTANCE.getPackageSection_OwnedProcessImplementation(),
				Aadl2Factory.eINSTANCE.createProcessImplementation()));

		newChildDescriptors.add(createChildParameter(
				Aadl2Package.eINSTANCE.getPackageSection_OwnedProcessorImplementation(),
				Aadl2Factory.eINSTANCE.createProcessorImplementation()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPackageSection_OwnedSubprogramType(),
				Aadl2Factory.eINSTANCE.createSubprogramType()));

		newChildDescriptors.add(createChildParameter(
				Aadl2Package.eINSTANCE.getPackageSection_OwnedSubprogramImplementation(),
				Aadl2Factory.eINSTANCE.createSubprogramImplementation()));

		newChildDescriptors.add(createChildParameter(
				Aadl2Package.eINSTANCE.getPackageSection_OwnedSubprogramGroupType(),
				Aadl2Factory.eINSTANCE.createSubprogramGroupType()));

		newChildDescriptors.add(createChildParameter(
				Aadl2Package.eINSTANCE.getPackageSection_OwnedSubprogramGroupImplementation(),
				Aadl2Factory.eINSTANCE.createSubprogramGroupImplementation()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPackageSection_OwnedSystemType(),
				Aadl2Factory.eINSTANCE.createSystemType()));

		newChildDescriptors.add(createChildParameter(
				Aadl2Package.eINSTANCE.getPackageSection_OwnedSystemImplementation(),
				Aadl2Factory.eINSTANCE.createSystemImplementation()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPackageSection_OwnedThreadType(),
				Aadl2Factory.eINSTANCE.createThreadType()));

		newChildDescriptors.add(createChildParameter(
				Aadl2Package.eINSTANCE.getPackageSection_OwnedThreadImplementation(),
				Aadl2Factory.eINSTANCE.createThreadImplementation()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPackageSection_OwnedThreadGroupType(),
				Aadl2Factory.eINSTANCE.createThreadGroupType()));

		newChildDescriptors.add(createChildParameter(
				Aadl2Package.eINSTANCE.getPackageSection_OwnedThreadGroupImplementation(),
				Aadl2Factory.eINSTANCE.createThreadGroupImplementation()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPackageSection_OwnedVirtualBusType(),
				Aadl2Factory.eINSTANCE.createVirtualBusType()));

		newChildDescriptors.add(createChildParameter(
				Aadl2Package.eINSTANCE.getPackageSection_OwnedVirtualBusImplementation(),
				Aadl2Factory.eINSTANCE.createVirtualBusImplementation()));

		newChildDescriptors.add(createChildParameter(
				Aadl2Package.eINSTANCE.getPackageSection_OwnedVirtualProcessorType(),
				Aadl2Factory.eINSTANCE.createVirtualProcessorType()));

		newChildDescriptors.add(createChildParameter(
				Aadl2Package.eINSTANCE.getPackageSection_OwnedVirtualProcessorImplementation(),
				Aadl2Factory.eINSTANCE.createVirtualProcessorImplementation()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getPackageSection_OwnedFeatureGroupType(),
				Aadl2Factory.eINSTANCE.createFeatureGroupType()));
	}

}
