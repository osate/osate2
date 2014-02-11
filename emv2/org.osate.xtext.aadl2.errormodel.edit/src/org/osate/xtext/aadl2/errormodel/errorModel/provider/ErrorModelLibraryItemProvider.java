/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;

import org.osate.aadl2.provider.AnnexLibraryItemProvider;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

/**
 * This is the item provider adapter for a {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ErrorModelLibraryItemProvider
	extends AnnexLibraryItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorModelLibraryItemProvider(AdapterFactory adapterFactory) {
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

			addExtendsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Extends feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExtendsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ErrorModelLibrary_extends_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ErrorModelLibrary_extends_feature", "_UI_ErrorModelLibrary_type"),
				 ErrorModelPackage.Literals.ERROR_MODEL_LIBRARY__EXTENDS,
				 true,
				 false,
				 true,
				 null,
				 null,
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
			childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_LIBRARY__TYPES);
			childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_LIBRARY__PROPERTIES);
			childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_LIBRARY__BEHAVIORS);
			childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_LIBRARY__MAPPINGS);
			childrenFeatures.add(ErrorModelPackage.Literals.ERROR_MODEL_LIBRARY__TRANSFORMATIONS);
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
	 * This returns ErrorModelLibrary.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ErrorModelLibrary"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ErrorModelLibrary)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ErrorModelLibrary_type") :
			getString("_UI_ErrorModelLibrary_type") + " " + label;
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

		switch (notification.getFeatureID(ErrorModelLibrary.class)) {
			case ErrorModelPackage.ERROR_MODEL_LIBRARY__TYPES:
			case ErrorModelPackage.ERROR_MODEL_LIBRARY__PROPERTIES:
			case ErrorModelPackage.ERROR_MODEL_LIBRARY__BEHAVIORS:
			case ErrorModelPackage.ERROR_MODEL_LIBRARY__MAPPINGS:
			case ErrorModelPackage.ERROR_MODEL_LIBRARY__TRANSFORMATIONS:
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

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_MODEL_LIBRARY__TYPES,
				 ErrorModelFactory.eINSTANCE.createErrorTypes()));

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_MODEL_LIBRARY__TYPES,
				 ErrorModelFactory.eINSTANCE.createErrorType()));

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_MODEL_LIBRARY__TYPES,
				 ErrorModelFactory.eINSTANCE.createTypeSet()));

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_MODEL_LIBRARY__PROPERTIES,
				 Aadl2Factory.eINSTANCE.createPropertyAssociation()));

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_MODEL_LIBRARY__BEHAVIORS,
				 ErrorModelFactory.eINSTANCE.createErrorBehaviorStateMachine()));

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_MODEL_LIBRARY__MAPPINGS,
				 ErrorModelFactory.eINSTANCE.createTypeMappingSet()));

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_MODEL_LIBRARY__TRANSFORMATIONS,
				 ErrorModelFactory.eINSTANCE.createTypeTransformationSet()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == Aadl2Package.eINSTANCE.getNamedElement_OwnedPropertyAssociation() ||
			childFeature == ErrorModelPackage.Literals.ERROR_MODEL_LIBRARY__PROPERTIES;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ErrorModelEditPlugin.INSTANCE;
	}

}
