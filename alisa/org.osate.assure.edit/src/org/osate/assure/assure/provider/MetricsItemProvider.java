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

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.Metrics;

/**
 * This is the item provider adapter for a {@link org.osate.assure.assure.Metrics} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MetricsItemProvider 
	extends ItemProviderAdapter
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
	public MetricsItemProvider(AdapterFactory adapterFactory) {
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

			addTbdCountPropertyDescriptor(object);
			addSuccessCountPropertyDescriptor(object);
			addFailCountPropertyDescriptor(object);
			addTimeoutCountPropertyDescriptor(object);
			addErrorCountPropertyDescriptor(object);
			addDidelseCountPropertyDescriptor(object);
			addThenskipCountPropertyDescriptor(object);
			addPreconditionfailCountPropertyDescriptor(object);
			addValidationfailCountPropertyDescriptor(object);
			addFeaturesCountPropertyDescriptor(object);
			addFeaturesRequirementsCountPropertyDescriptor(object);
			addQualityCategoryRequirementsCountPropertyDescriptor(object);
			addTotalQualityCategoryCountPropertyDescriptor(object);
			addRequirementsWithoutPlanClaimCountPropertyDescriptor(object);
			addNoVerificationPlansCountPropertyDescriptor(object);
			addRequirementsCountPropertyDescriptor(object);
			addExceptionsCountPropertyDescriptor(object);
			addReqTargetHasEMV2SubclauseCountPropertyDescriptor(object);
			addFeaturesRequiringClassifierCountPropertyDescriptor(object);
			addFeaturesWithRequiredClassifierCountPropertyDescriptor(object);
			addWeightPropertyDescriptor(object);
			addExecutionTimePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Tbd Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTbdCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_tbdCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_tbdCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__TBD_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Success Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuccessCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_successCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_successCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__SUCCESS_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fail Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFailCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_failCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_failCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__FAIL_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Timeout Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTimeoutCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_timeoutCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_timeoutCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__TIMEOUT_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Error Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addErrorCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_errorCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_errorCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__ERROR_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Didelse Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDidelseCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_didelseCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_didelseCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__DIDELSE_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Thenskip Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addThenskipCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_thenskipCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_thenskipCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__THENSKIP_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Preconditionfail Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPreconditionfailCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_preconditionfailCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_preconditionfailCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__PRECONDITIONFAIL_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Validationfail Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValidationfailCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_validationfailCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_validationfailCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__VALIDATIONFAIL_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Features Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeaturesCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_featuresCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_featuresCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__FEATURES_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Features Requirements Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeaturesRequirementsCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_featuresRequirementsCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_featuresRequirementsCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__FEATURES_REQUIREMENTS_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Quality Category Requirements Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQualityCategoryRequirementsCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_qualityCategoryRequirementsCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_qualityCategoryRequirementsCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__QUALITY_CATEGORY_REQUIREMENTS_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Total Quality Category Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTotalQualityCategoryCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_totalQualityCategoryCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_totalQualityCategoryCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__TOTAL_QUALITY_CATEGORY_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Requirements Without Plan Claim Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequirementsWithoutPlanClaimCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_requirementsWithoutPlanClaimCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_requirementsWithoutPlanClaimCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__REQUIREMENTS_WITHOUT_PLAN_CLAIM_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the No Verification Plans Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNoVerificationPlansCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_noVerificationPlansCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_noVerificationPlansCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__NO_VERIFICATION_PLANS_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Requirements Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequirementsCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_requirementsCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_requirementsCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__REQUIREMENTS_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Exceptions Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExceptionsCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_exceptionsCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_exceptionsCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__EXCEPTIONS_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Req Target Has EMV2 Subclause Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReqTargetHasEMV2SubclauseCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_reqTargetHasEMV2SubclauseCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_reqTargetHasEMV2SubclauseCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__REQ_TARGET_HAS_EMV2_SUBCLAUSE_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Features Requiring Classifier Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeaturesRequiringClassifierCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_featuresRequiringClassifierCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_featuresRequiringClassifierCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__FEATURES_REQUIRING_CLASSIFIER_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Features With Required Classifier Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeaturesWithRequiredClassifierCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_featuresWithRequiredClassifierCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_featuresWithRequiredClassifierCount_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__FEATURES_WITH_REQUIRED_CLASSIFIER_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Weight feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWeightPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_weight_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_weight_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__WEIGHT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Execution Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExecutionTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Metrics_executionTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Metrics_executionTime_feature", "_UI_Metrics_type"),
				 AssurePackage.Literals.METRICS__EXECUTION_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns Metrics.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Metrics"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		Metrics metrics = (Metrics)object;
		return getString("_UI_Metrics_type") + " " + metrics.getTbdCount();
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

		switch (notification.getFeatureID(Metrics.class)) {
			case AssurePackage.METRICS__TBD_COUNT:
			case AssurePackage.METRICS__SUCCESS_COUNT:
			case AssurePackage.METRICS__FAIL_COUNT:
			case AssurePackage.METRICS__TIMEOUT_COUNT:
			case AssurePackage.METRICS__ERROR_COUNT:
			case AssurePackage.METRICS__DIDELSE_COUNT:
			case AssurePackage.METRICS__THENSKIP_COUNT:
			case AssurePackage.METRICS__PRECONDITIONFAIL_COUNT:
			case AssurePackage.METRICS__VALIDATIONFAIL_COUNT:
			case AssurePackage.METRICS__FEATURES_COUNT:
			case AssurePackage.METRICS__FEATURES_REQUIREMENTS_COUNT:
			case AssurePackage.METRICS__QUALITY_CATEGORY_REQUIREMENTS_COUNT:
			case AssurePackage.METRICS__TOTAL_QUALITY_CATEGORY_COUNT:
			case AssurePackage.METRICS__REQUIREMENTS_WITHOUT_PLAN_CLAIM_COUNT:
			case AssurePackage.METRICS__NO_VERIFICATION_PLANS_COUNT:
			case AssurePackage.METRICS__REQUIREMENTS_COUNT:
			case AssurePackage.METRICS__EXCEPTIONS_COUNT:
			case AssurePackage.METRICS__REQ_TARGET_HAS_EMV2_SUBCLAUSE_COUNT:
			case AssurePackage.METRICS__FEATURES_REQUIRING_CLASSIFIER_COUNT:
			case AssurePackage.METRICS__FEATURES_WITH_REQUIRED_CLASSIFIER_COUNT:
			case AssurePackage.METRICS__WEIGHT:
			case AssurePackage.METRICS__EXECUTION_TIME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return AssureEditPlugin.INSTANCE;
	}

}
