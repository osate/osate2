/**
 */
package org.osate.aadl2.errormodel.FaultTree.provider;

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
import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.errormodel.FaultTree.EventType;
import org.osate.aadl2.errormodel.FaultTree.FaultTreePackage;
import org.osate.aadl2.errormodel.FaultTree.LogicOperation;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.errormodel.FaultTree.Event} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EventItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addMessagePropertyDescriptor(object);
			addSubEventsPropertyDescriptor(object);
			addKPropertyDescriptor(object);
			addAssignedProbabilityPropertyDescriptor(object);
			addComputedProbabilityPropertyDescriptor(object);
			addRelatedInstanceObjectPropertyDescriptor(object);
			addRelatedErrorTypePropertyDescriptor(object);
			addReferenceCountPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addSubEventLogicPropertyDescriptor(object);
			addRelatedEMV2ObjectPropertyDescriptor(object);
			addScalePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_name_feature", "_UI_Event_type"),
				 FaultTreePackage.Literals.EVENT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Message feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMessagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_message_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_message_feature", "_UI_Event_type"),
				 FaultTreePackage.Literals.EVENT__MESSAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sub Events feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSubEventsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_subEvents_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_subEvents_feature", "_UI_Event_type"),
				 FaultTreePackage.Literals.EVENT__SUB_EVENTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the K feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_k_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_k_feature", "_UI_Event_type"),
				 FaultTreePackage.Literals.EVENT__K,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Assigned Probability feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAssignedProbabilityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_assignedProbability_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_assignedProbability_feature", "_UI_Event_type"),
				 FaultTreePackage.Literals.EVENT__ASSIGNED_PROBABILITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Computed Probability feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addComputedProbabilityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_computedProbability_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_computedProbability_feature", "_UI_Event_type"),
				 FaultTreePackage.Literals.EVENT__COMPUTED_PROBABILITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Related Instance Object feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRelatedInstanceObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_relatedInstanceObject_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_relatedInstanceObject_feature", "_UI_Event_type"),
				 FaultTreePackage.Literals.EVENT__RELATED_INSTANCE_OBJECT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Related Error Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRelatedErrorTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_relatedErrorType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_relatedErrorType_feature", "_UI_Event_type"),
				 FaultTreePackage.Literals.EVENT__RELATED_ERROR_TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Reference Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferenceCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_referenceCount_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_referenceCount_feature", "_UI_Event_type"),
				 FaultTreePackage.Literals.EVENT__REFERENCE_COUNT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_type_feature", "_UI_Event_type"),
				 FaultTreePackage.Literals.EVENT__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sub Event Logic feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSubEventLogicPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_subEventLogic_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_subEventLogic_feature", "_UI_Event_type"),
				 FaultTreePackage.Literals.EVENT__SUB_EVENT_LOGIC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Related EMV2 Object feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRelatedEMV2ObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_relatedEMV2Object_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_relatedEMV2Object_feature", "_UI_Event_type"),
				 FaultTreePackage.Literals.EVENT__RELATED_EMV2_OBJECT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Scale feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScalePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_scale_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_scale_feature", "_UI_Event_type"),
				 FaultTreePackage.Literals.EVENT__SCALE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns Event.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOTgenerated
	 */
	@Override
	public Object getImage(Object object) {
		Event ev = (Event) object;
		if (ev.getType() == EventType.BASIC) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/BasicEventBW"));
		}
		if (ev.getType() == EventType.UNDEVELOPED) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/UndevelopedEventBW"));
		}
		if (ev.getType() == EventType.EXTERNAL) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/ExternalEventBW"));
		}
		if (ev.getType() == EventType.INTERMEDIATE && ev.getSubEvents().size() < 2) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/IntermediateEventBW"));
		}
		if (ev.getSubEventLogic() == LogicOperation.AND) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/AndOpBW"));
		}
		if (ev.getSubEventLogic() == LogicOperation.OR) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/OrOpBW"));
		}
		if (ev.getSubEventLogic() == LogicOperation.XOR) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/XorOpBW"));
		}
		if (ev.getSubEventLogic() == LogicOperation.PRIORITY_AND) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/PAndOpBW"));
		}
		if (ev.getSubEventLogic() == LogicOperation.KORMORE) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/OrMoreOpBW"));
		}
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Event"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Event)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Event_type") :
			getString("_UI_Event_type") + " " + label;
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

		switch (notification.getFeatureID(Event.class)) {
			case FaultTreePackage.EVENT__NAME:
			case FaultTreePackage.EVENT__MESSAGE:
			case FaultTreePackage.EVENT__K:
			case FaultTreePackage.EVENT__ASSIGNED_PROBABILITY:
			case FaultTreePackage.EVENT__COMPUTED_PROBABILITY:
			case FaultTreePackage.EVENT__REFERENCE_COUNT:
			case FaultTreePackage.EVENT__TYPE:
			case FaultTreePackage.EVENT__SUB_EVENT_LOGIC:
			case FaultTreePackage.EVENT__SCALE:
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
		return FaultTreeEditPlugin.INSTANCE;
	}

}
