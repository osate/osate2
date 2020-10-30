/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.provider;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IDecoratorManager;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.impl.FlowSpecificationImpl;
import org.osate.aadl2.provider.Decorator.DecoratorPlugin;
import org.osate.aadl2.provider.Decorator.Images;
import org.osate.aadl2.provider.Decorator.LightWeightDecorator;
import org.osate.aadl2.provider.Decorator.ResourcePropertiesManager;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.FlowSpecification} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FlowSpecificationItemProvider extends FlowFeatureItemProvider
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowSpecificationItemProvider(AdapterFactory adapterFactory) {
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

			addInModePropertyDescriptor(object);
			addInModeOrTransitionPropertyDescriptor(object);
			addRefinedPropertyDescriptor(object);
			addKindPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
						getResourceLocator(), getString("_UI_ModalElement_inMode_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_ModalElement_inMode_feature",
								"_UI_ModalElement_type"),
						Aadl2Package.eINSTANCE.getModalElement_InMode(), true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the In Mode Or Transition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInModeOrTransitionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ModalPath_inModeOrTransition_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_ModalPath_inModeOrTransition_feature",
								"_UI_ModalPath_type"),
						Aadl2Package.eINSTANCE.getModalPath_InModeOrTransition(), true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Kind feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKindPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_FlowSpecification_kind_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_FlowSpecification_kind_feature",
								"_UI_FlowSpecification_type"),
						Aadl2Package.eINSTANCE.getFlowSpecification_Kind(), true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
			childrenFeatures.add(Aadl2Package.eINSTANCE.getFlowSpecification_OutEnd());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getFlowSpecification_InEnd());
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
	 * This adds a property descriptor for the Refined feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRefinedPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_FlowSpecification_refined_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_FlowSpecification_refined_feature",
								"_UI_FlowSpecification_type"),
						Aadl2Package.eINSTANCE.getFlowSpecification_Refined(), true, false, true, null, null, null));
	}

	/**
	 * This returns FlowSpecification.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		if (((FlowSpecificationImpl) object).getAllInEnd() == null
				&& ((FlowSpecificationImpl) object).getAllOutEnd() == null) {
			return null;
		} else if (((FlowSpecificationImpl) object).getAllInEnd() == null) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/FlowSource"));
		} else if (((FlowSpecificationImpl) object).getAllOutEnd() == null) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/FlowSink"));
		}

		return overlayImage(object, getResourceLocator().getImage("full/obj16/FlowPath"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((FlowSpecification) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_FlowSpecification_type")
				: getString("_UI_FlowSpecification_type") + " " + label;
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

		switch (notification.getFeatureID(FlowSpecification.class)) {
		case Aadl2Package.FLOW_SPECIFICATION__KIND:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case Aadl2Package.FLOW_SPECIFICATION__OUT_END:
		case Aadl2Package.FLOW_SPECIFICATION__IN_END:
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

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getFlowSpecification_OutEnd(),
				Aadl2Factory.eINSTANCE.createFlowEnd()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getFlowSpecification_InEnd(),
				Aadl2Factory.eINSTANCE.createFlowEnd()));
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

		boolean qualify = childFeature == Aadl2Package.eINSTANCE.getFlowSpecification_OutEnd()
				|| childFeature == Aadl2Package.eINSTANCE.getFlowSpecification_InEnd();

		if (qualify) {
			return getString("_UI_CreateChild_text2",
					new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	private static Images demoImage_ = new Images();

	/**
	 * Boolean indicator to differenciate decoration at the start or not.. Not used
	 */
	private static boolean newDecorationRequest_ = false;

	/**
	 *
	 */
	private static List initialDecoratorList_ = new Vector();

	private static boolean decorateTextLabels_ = true;
	private static boolean decorateProject_ = true;

	/**
	 * Get the static instance of DemoDecorator
	 *
	 * @return Demo decorator object
	 * @since 4.1
	 *
	 */
	public static LightWeightDecorator getDemoDecorator() {
		IDecoratorManager decoratorManager = DecoratorPlugin.getDefault().getWorkbench().getDecoratorManager();

		if (decoratorManager.getEnabled("org.osate.aadl2.provider.Decorator.decorator")) {
			return (LightWeightDecorator) decoratorManager
					.getLightweightLabelDecorator("org.osate.aadl2.provider.Decorator.decorator");
		}
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang.Object, org.eclipse.jface.viewers.IDecoration)
	 * @since 4.1
	 */
	public void decorate(Object object, IDecoration decoration) {
		IResource objectResource;

		// Get the resource using the adaptable mechanism.
		objectResource = getResource(object);

		Vector decoratorImageKeys = new Vector();
		if (objectResource == null) {
			// The IResource object is null for all the members / member methods etc
			// for a java file in a package explorer.
			return;
		}

		// Decorating a Project

		// The project should be decorated with DecoratorDemo text label.
		if (objectResource.getType() == IResource.PROJECT) {
			if (decorateProject_) {
				decoration.addSuffix(" [ " + "Decorator Demo" + " ]");
				return;
			}
		}

		// Decorating a Folder
		if (objectResource.getType() == IResource.FOLDER) {
			// Folders should not be decorated..
			return;
		}

		try {
			// Resource properties have been changed.

			// Find the decorator with which the image should be decorated
			decoratorImageKeys = ResourcePropertiesManager.findDecorationImageForResource(objectResource);

			// Get the prefix value specified in the file property page
			String prefixValue = ResourcePropertiesManager.getPrefix(objectResource);

			// Get the suffix value specified in the file property page
			String suffixValue = ResourcePropertiesManager.getSuffix(objectResource);

			DecoratorManager.removeResource(objectResource);
			if (decorateTextLabels_) {
				if (prefixValue != null && prefixValue.length() != 0) {
					decoration.addPrefix(" [ " + prefixValue + " ] ");
				}
				if (suffixValue != null && suffixValue.length() != 0) {
					decoration.addSuffix(" [ " + suffixValue + " ]");
				}
			}
			if (decoratorImageKeys.size() != 0) {
				decoration.addOverlay(Images.lockDescriptor);
			}
			return;
		} catch (Exception e) {
			// Logger.logError(e);
		}
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 * @since 4.1
	 */
	public void addListener(ILabelProviderListener arg0) {

	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
		// Disposal of images present in the image registry can be performed in this
		// method
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 * @since 4.1
	 */
	public boolean isLabelProperty(Object arg0, String arg1) {
		return false;
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 * @since 4.1
	 */
	public void removeListener(ILabelProviderListener arg0) {
	}

	/**
	 * Refresh the project. This is used to refresh the label decorators of
	 * of the resources.
	 * @since 4.1
	 *
	 */
	public void refresh() {
		newDecorationRequest_ = true;
		initialDecoratorList_ = null;

		List resourcesToBeUpdated;

		// Get the Demo decorator
		LightWeightDecorator demoDecorator = getDemoDecorator();
		if (demoDecorator == null) {
			return;
		} else {
			resourcesToBeUpdated = DecoratorManager.getSuccessResources();
			// Fire a label provider changed event to decorate the
			// resources whose image needs to be updated

			demoDecorator.fireLabelEvent(new LabelProviderChangedEvent(demoDecorator, resourcesToBeUpdated.toArray()));
		}
	}

	/**
	 * Refresh all the resources in the project
	 * @since 4.1
	 */
	public void refreshAll(boolean displayTextLabel, boolean displayProject) {
		decorateTextLabels_ = displayTextLabel;
		decorateProject_ = displayProject;

		LightWeightDecorator demoDecorator = getDemoDecorator();
		if (demoDecorator == null) {
			return;
		} else {
			demoDecorator.fireLabelEvent(new LabelProviderChangedEvent(demoDecorator));
		}
	}

	/**
	 * @since 4.1
	 */
	public void refresh(List resourcesToBeUpdated) {
		newDecorationRequest_ = true;
		initialDecoratorList_ = null;

		LightWeightDecorator demoDecorator = getDemoDecorator();
		if (demoDecorator == null) {
			return;
		} else {
			// Fire a label provider changed event to decorate the
			// resources whose image needs to be updated
			fireLabelEvent(new LabelProviderChangedEvent(demoDecorator, resourcesToBeUpdated.toArray()));
		}
	}

	/**
	 * Fire a Label Change event so that the label decorators are
	 * automatically refreshed.
	 *
	 * @param event LabelProviderChangedEvent
	 */
	private void fireLabelEvent(final LabelProviderChangedEvent event) {
		// We need to get the thread of execution to fire the label provider
		// changed event , else WSWB complains of thread exception.
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				// fireLabelProviderChanged(event);
			}
		});
	}

	/**
	 * Returns the resource for the given input object, or
	 * null if there is no resource associated with it.
	 *
	 * @param object  the object to find the resource for
	 * @return the resource for the given object, or null
	 */
	private IResource getResource(Object object) {
		if (object instanceof IResource) {
			return (IResource) object;
		}
		if (object instanceof IAdaptable) {
			return ((IAdaptable) object).getAdapter(IResource.class);
		}
		return null;
	}

}
