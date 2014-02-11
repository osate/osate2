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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.osate.aadl2.Aadl2Factory;

import org.osate.aadl2.provider.NamedElementItemProvider;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

/**
 * This is the item provider adapter for a {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ErrorDetectionItemProvider
	extends NamedElementItemProvider
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
	public ErrorDetectionItemProvider(AdapterFactory adapterFactory) {
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

			addStatePropertyDescriptor(object);
			addAllStatesPropertyDescriptor(object);
			addDetectionReportingPortPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ErrorDetection_state_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ErrorDetection_state_feature", "_UI_ErrorDetection_type"),
				 ErrorModelPackage.Literals.ERROR_DETECTION__STATE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the All States feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllStatesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ErrorDetection_allStates_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ErrorDetection_allStates_feature", "_UI_ErrorDetection_type"),
				 ErrorModelPackage.Literals.ERROR_DETECTION__ALL_STATES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Detection Reporting Port feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDetectionReportingPortPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ErrorDetection_detectionReportingPort_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ErrorDetection_detectionReportingPort_feature", "_UI_ErrorDetection_type"),
				 ErrorModelPackage.Literals.ERROR_DETECTION__DETECTION_REPORTING_PORT,
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
			childrenFeatures.add(ErrorModelPackage.Literals.ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT);
			childrenFeatures.add(ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION);
			childrenFeatures.add(ErrorModelPackage.Literals.ERROR_DETECTION__INTERNAL_DETECTION_PORT);
			childrenFeatures.add(ErrorModelPackage.Literals.ERROR_DETECTION__ERROR_CODE);
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
	 * This returns ErrorDetection.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ErrorDetection"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ErrorDetection)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ErrorDetection_type") :
			getString("_UI_ErrorDetection_type") + " " + label;
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

		switch (notification.getFeatureID(ErrorDetection.class)) {
			case ErrorModelPackage.ERROR_DETECTION__ALL_STATES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ErrorModelPackage.ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT:
			case ErrorModelPackage.ERROR_DETECTION__CONDITION:
			case ErrorModelPackage.ERROR_DETECTION__INTERNAL_DETECTION_PORT:
			case ErrorModelPackage.ERROR_DETECTION__ERROR_CODE:
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
				(ErrorModelPackage.Literals.ERROR_DETECTION__TYPE_TOKEN_CONSTRAINT,
				 ErrorModelFactory.eINSTANCE.createTypeSet()));

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION,
				 ErrorModelFactory.eINSTANCE.createConditionExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION,
				 ErrorModelFactory.eINSTANCE.createOrmoreExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION,
				 ErrorModelFactory.eINSTANCE.createOrlessExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION,
				 ErrorModelFactory.eINSTANCE.createConditionElement()));

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION,
				 ErrorModelFactory.eINSTANCE.createOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION,
				 ErrorModelFactory.eINSTANCE.createAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION,
				 ErrorModelFactory.eINSTANCE.createSOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_DETECTION__CONDITION,
				 ErrorModelFactory.eINSTANCE.createSAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_DETECTION__INTERNAL_DETECTION_PORT,
				 Aadl2Factory.eINSTANCE.createInternalEvent()));

		newChildDescriptors.add
			(createChildParameter
				(ErrorModelPackage.Literals.ERROR_DETECTION__ERROR_CODE,
				 ErrorModelFactory.eINSTANCE.createErrorCodeValue()));
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
