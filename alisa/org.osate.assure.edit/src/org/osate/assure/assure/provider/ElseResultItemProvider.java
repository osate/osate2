/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */
package org.osate.assure.assure.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.osate.assure.assure.AssureFactory;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.ElseResult;
import org.osate.assure.util.AssureUtilExtension;

/**
 * This is the item provider adapter for a {@link org.osate.assure.assure.ElseResult} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ElseResultItemProvider extends VerificationExprItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElseResultItemProvider(AdapterFactory adapterFactory) {
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

			addDidFailPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Did Fail feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDidFailPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ElseResult_didFail_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ElseResult_didFail_feature", "_UI_ElseResult_type"),
				 AssurePackage.Literals.ELSE_RESULT__DID_FAIL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(AssurePackage.Literals.ELSE_RESULT__FIRST);
			childrenFeatures.add(AssurePackage.Literals.ELSE_RESULT__ERROR);
			childrenFeatures.add(AssurePackage.Literals.ELSE_RESULT__FAIL);
			childrenFeatures.add(AssurePackage.Literals.ELSE_RESULT__TIMEOUT);
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
	 * This returns ElseResult.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(image((ElseResult) object)));
	}

	private String image(ElseResult ele) {
		if (AssureUtilExtension.isSuccessful(ele)) {
			return "valid.png";
		}
		if (AssureUtilExtension.isFail(ele)) {
			return "invalid.png";
		}
		if (AssureUtilExtension.isErrorTimeOut(ele)) {
			return "error.png";
		}
		if (AssureUtilExtension.isZeroCount(ele)) {
			return "info.png";
		}
		return "questionmark.png";
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ElseResult_type");
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

		switch (notification.getFeatureID(ElseResult.class)) {
			case AssurePackage.ELSE_RESULT__DID_FAIL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case AssurePackage.ELSE_RESULT__FIRST:
			case AssurePackage.ELSE_RESULT__ERROR:
			case AssurePackage.ELSE_RESULT__FAIL:
			case AssurePackage.ELSE_RESULT__TIMEOUT:
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
				(AssurePackage.Literals.ELSE_RESULT__FIRST,
				 AssureFactory.eINSTANCE.createVerificationResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__FIRST,
				 AssureFactory.eINSTANCE.createVerificationExpr()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__FIRST,
				 AssureFactory.eINSTANCE.createElseResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__FIRST,
				 AssureFactory.eINSTANCE.createThenResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__FIRST,
				 AssureFactory.eINSTANCE.createPreconditionResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__FIRST,
				 AssureFactory.eINSTANCE.createValidationResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__FIRST,
				 AssureFactory.eINSTANCE.createVerificationActivityResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__FIRST,
				 AssureFactory.eINSTANCE.createPredicateResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__ERROR,
				 AssureFactory.eINSTANCE.createVerificationResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__ERROR,
				 AssureFactory.eINSTANCE.createVerificationExpr()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__ERROR,
				 AssureFactory.eINSTANCE.createElseResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__ERROR,
				 AssureFactory.eINSTANCE.createThenResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__ERROR,
				 AssureFactory.eINSTANCE.createPreconditionResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__ERROR,
				 AssureFactory.eINSTANCE.createValidationResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__ERROR,
				 AssureFactory.eINSTANCE.createVerificationActivityResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__ERROR,
				 AssureFactory.eINSTANCE.createPredicateResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__FAIL,
				 AssureFactory.eINSTANCE.createVerificationResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__FAIL,
				 AssureFactory.eINSTANCE.createVerificationExpr()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__FAIL,
				 AssureFactory.eINSTANCE.createElseResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__FAIL,
				 AssureFactory.eINSTANCE.createThenResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__FAIL,
				 AssureFactory.eINSTANCE.createPreconditionResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__FAIL,
				 AssureFactory.eINSTANCE.createValidationResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__FAIL,
				 AssureFactory.eINSTANCE.createVerificationActivityResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__FAIL,
				 AssureFactory.eINSTANCE.createPredicateResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__TIMEOUT,
				 AssureFactory.eINSTANCE.createVerificationResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__TIMEOUT,
				 AssureFactory.eINSTANCE.createVerificationExpr()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__TIMEOUT,
				 AssureFactory.eINSTANCE.createElseResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__TIMEOUT,
				 AssureFactory.eINSTANCE.createThenResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__TIMEOUT,
				 AssureFactory.eINSTANCE.createPreconditionResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__TIMEOUT,
				 AssureFactory.eINSTANCE.createValidationResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__TIMEOUT,
				 AssureFactory.eINSTANCE.createVerificationActivityResult()));

		newChildDescriptors.add
			(createChildParameter
				(AssurePackage.Literals.ELSE_RESULT__TIMEOUT,
				 AssureFactory.eINSTANCE.createPredicateResult()));
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
			childFeature == AssurePackage.Literals.ELSE_RESULT__FIRST ||
			childFeature == AssurePackage.Literals.ELSE_RESULT__ERROR ||
			childFeature == AssurePackage.Literals.ELSE_RESULT__FAIL ||
			childFeature == AssurePackage.Literals.ELSE_RESULT__TIMEOUT;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
