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
 * $Id: ClassifierItemProvider.java,v 1.21 2011-04-11 13:36:03 lwrage Exp $
 */
package org.osate.aadl2.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
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
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;

/**
 * This is the item provider adapter for a {@link org.osate.aadl2.Classifier} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassifierItemProvider extends NamespaceItemProvider implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierItemProvider(AdapterFactory adapterFactory) {
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

			addClassifierFeaturePropertyDescriptor(object);
			addInheritedMemberPropertyDescriptor(object);
			addGeneralPropertyDescriptor(object);
			addNoPrototypesPropertyDescriptor(object);
			addNoAnnexesPropertyDescriptor(object);
			addNoPropertiesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Classifier Feature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClassifierFeaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Classifier_classifierFeature_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Classifier_classifierFeature_feature",
						"_UI_Classifier_type"), Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature(), false, false,
				false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Inherited Member feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInheritedMemberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Classifier_inheritedMember_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Classifier_inheritedMember_feature",
						"_UI_Classifier_type"), Aadl2Package.eINSTANCE.getClassifier_InheritedMember(), false, false,
				false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the General feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGeneralPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_Classifier_general_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Classifier_general_feature",
								"_UI_Classifier_type"), Aadl2Package.eINSTANCE.getClassifier_General(), false, false,
						false, null, null, null));
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
				getString("_UI_Classifier_noProperties_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Classifier_noProperties_feature",
						"_UI_Classifier_type"), Aadl2Package.eINSTANCE.getClassifier_NoProperties(), true, false,
				false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the No Prototypes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNoPrototypesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Classifier_noPrototypes_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Classifier_noPrototypes_feature",
						"_UI_Classifier_type"), Aadl2Package.eINSTANCE.getClassifier_NoPrototypes(), true, false,
				false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
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
				getString("_UI_Classifier_noAnnexes_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Classifier_noAnnexes_feature",
						"_UI_Classifier_type"), Aadl2Package.eINSTANCE.getClassifier_NoAnnexes(), true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
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
			childrenFeatures.add(Aadl2Package.eINSTANCE.getClassifier_Generalization());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getClassifier_OwnedAnnexSubclause());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype());
			childrenFeatures.add(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototypeBinding());
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
		String label = ((Classifier) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Classifier_type")
				: getString("_UI_Classifier_type") + " " + label;
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

		switch (notification.getFeatureID(Classifier.class)) {
		case Aadl2Package.CLASSIFIER__NO_PROTOTYPES:
		case Aadl2Package.CLASSIFIER__NO_ANNEXES:
		case Aadl2Package.CLASSIFIER__NO_PROPERTIES:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case Aadl2Package.CLASSIFIER__GENERALIZATION:
		case Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE:
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE:
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE_BINDING:
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

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedAnnexSubclause(),
				Aadl2Factory.eINSTANCE.createDefaultAnnexSubclause()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createFeatureGroupPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createFeaturePrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createAbstractPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createBusPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createDataPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createDevicePrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createMemoryPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createSubprogramPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createSubprogramGroupPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createSystemPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createProcessorPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createProcessPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createThreadPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createThreadGroupPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createVirtualBusPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototype(),
				Aadl2Factory.eINSTANCE.createVirtualProcessorPrototype()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototypeBinding(),
				Aadl2Factory.eINSTANCE.createComponentPrototypeBinding()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototypeBinding(),
				Aadl2Factory.eINSTANCE.createFeatureGroupPrototypeBinding()));

		newChildDescriptors.add(createChildParameter(Aadl2Package.eINSTANCE.getClassifier_OwnedPrototypeBinding(),
				Aadl2Factory.eINSTANCE.createFeaturePrototypeBinding()));
	}

}
