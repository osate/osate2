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
 * $Id: ComponentInstanceImpl.java,v 1.25 2010-06-14 17:29:03 lwrage Exp $
 */
package org.osate.aadl2.instance.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.MetaclassReference;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyOwner;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.util.Aadl2Util;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.ComponentInstanceImpl#getFeatureInstances <em>Feature Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ComponentInstanceImpl#getComponentInstances <em>Component Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ComponentInstanceImpl#getModeInstances <em>Mode Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ComponentInstanceImpl#getModeTransitionInstances <em>Mode Transition Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ComponentInstanceImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ComponentInstanceImpl#getInModes <em>In Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ComponentInstanceImpl#getFlowSpecifications <em>Flow Specification</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ComponentInstanceImpl#getEndToEndFlows <em>End To End Flow</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ComponentInstanceImpl#getConnectionInstances <em>Connection Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ComponentInstanceImpl#getSubcomponent <em>Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ComponentInstanceImpl#getIndices <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentInstanceImpl extends ConnectionInstanceEndImpl implements ComponentInstance {
	/**
	 * The cached value of the '{@link #getFeatureInstances() <em>Feature Instance</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureInstance> featureInstances;

	/**
	 * The cached value of the '{@link #getComponentInstances() <em>Component Instance</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentInstance> componentInstances;

	/**
	 * The cached value of the '{@link #getModeInstances() <em>Mode Instance</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModeInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeInstance> modeInstances;

	/**
	 * The cached value of the '{@link #getModeTransitionInstances() <em>Mode Transition Instance</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModeTransitionInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeTransitionInstance> modeTransitionInstances;

	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final ComponentCategory CATEGORY_EDEFAULT = ComponentCategory.ABSTRACT;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected ComponentCategory category = CATEGORY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInModes() <em>In Mode</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInModes()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeInstance> inModes;

	/**
	 * The cached value of the '{@link #getFlowSpecifications() <em>Flow Specification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlowSpecifications()
	 * @generated
	 * @ordered
	 */
	protected EList<FlowSpecificationInstance> flowSpecifications;

	/**
	 * The cached value of the '{@link #getEndToEndFlows() <em>End To End Flow</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndToEndFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<EndToEndFlowInstance> endToEndFlows;

	/**
	 * The cached value of the '{@link #getConnectionInstances() <em>Connection Instance</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionInstance> connectionInstances;

	/**
	 * The cached value of the '{@link #getSubcomponent() <em>Subcomponent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubcomponent()
	 * @generated
	 * @ordered
	 */
	protected Subcomponent subcomponent;

	/**
	 * The cached value of the '{@link #getIndices() <em>Index</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndices()
	 * @generated
	 * @ordered
	 */
	protected EList<Long> indices;

	/**
	 * The current ModeInstance that this component instance has been
	 * projected into, or <code>null</code> if the component instance has not
	 * been projected into any mode.
	 */
	private ModeInstance currentMode = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.COMPONENT_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FeatureInstance> getFeatureInstances() {
		if (featureInstances == null) {
			featureInstances = new EObjectContainmentEList<FeatureInstance>(FeatureInstance.class, this,
					InstancePackage.COMPONENT_INSTANCE__FEATURE_INSTANCE);
		}
		return featureInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureInstance createFeatureInstance() {
		FeatureInstance newFeatureInstance = (FeatureInstance) create(InstancePackage.Literals.FEATURE_INSTANCE);
		getFeatureInstances().add(newFeatureInstance);
		return newFeatureInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ComponentInstance> getComponentInstances() {
		if (componentInstances == null) {
			componentInstances = new EObjectContainmentEList<ComponentInstance>(ComponentInstance.class, this,
					InstancePackage.COMPONENT_INSTANCE__COMPONENT_INSTANCE);
		}
		return componentInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComponentInstance createComponentInstance(EClass eClass) {
		ComponentInstance newComponentInstance = (ComponentInstance) create(eClass);
		getComponentInstances().add(newComponentInstance);
		return newComponentInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComponentInstance createComponentInstance() {
		return createComponentInstance(InstancePackage.Literals.COMPONENT_INSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Subcomponent getSubcomponent() {
		if (subcomponent != null && ((EObject) subcomponent).eIsProxy()) {
			InternalEObject oldSubcomponent = (InternalEObject) subcomponent;
			subcomponent = (Subcomponent) eResolveProxy(oldSubcomponent);
			if (subcomponent != oldSubcomponent) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.COMPONENT_INSTANCE__SUBCOMPONENT, oldSubcomponent, subcomponent));
				}
			}
		}
		return subcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subcomponent basicGetSubcomponent() {
		return subcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSubcomponent(Subcomponent newSubcomponent) {
		Subcomponent oldSubcomponent = subcomponent;
		subcomponent = newSubcomponent;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.COMPONENT_INSTANCE__SUBCOMPONENT,
					oldSubcomponent, subcomponent));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Long> getIndices() {
		if (indices == null) {
			indices = new EDataTypeEList<Long>(Long.class, this, InstancePackage.COMPONENT_INSTANCE__INDEX);
		}
		return indices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModeInstance> getModeInstances() {
		if (modeInstances == null) {
			modeInstances = new EObjectContainmentEList<ModeInstance>(ModeInstance.class, this,
					InstancePackage.COMPONENT_INSTANCE__MODE_INSTANCE);
		}
		return modeInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModeInstance createModeInstance() {
		ModeInstance newModeInstance = (ModeInstance) create(InstancePackage.Literals.MODE_INSTANCE);
		getModeInstances().add(newModeInstance);
		return newModeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModeTransitionInstance> getModeTransitionInstances() {
		if (modeTransitionInstances == null) {
			modeTransitionInstances = new EObjectContainmentEList<ModeTransitionInstance>(ModeTransitionInstance.class,
					this, InstancePackage.COMPONENT_INSTANCE__MODE_TRANSITION_INSTANCE);
		}
		return modeTransitionInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModeTransitionInstance createModeTransitionInstance() {
		ModeTransitionInstance newModeTransitionInstance = (ModeTransitionInstance) create(InstancePackage.Literals.MODE_TRANSITION_INSTANCE);
		getModeTransitionInstances().add(newModeTransitionInstance);
		return newModeTransitionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComponentCategory getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCategory(ComponentCategory newCategory) {
		ComponentCategory oldCategory = category;
		category = newCategory == null ? CATEGORY_EDEFAULT : newCategory;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.COMPONENT_INSTANCE__CATEGORY,
					oldCategory, category));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModeInstance> getInModes() {
		if (inModes == null) {
			inModes = new EObjectResolvingEList<ModeInstance>(ModeInstance.class, this,
					InstancePackage.COMPONENT_INSTANCE__IN_MODE);
		}
		return inModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FlowSpecificationInstance> getFlowSpecifications() {
		if (flowSpecifications == null) {
			flowSpecifications = new EObjectContainmentEList<FlowSpecificationInstance>(
					FlowSpecificationInstance.class, this, InstancePackage.COMPONENT_INSTANCE__FLOW_SPECIFICATION);
		}
		return flowSpecifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FlowSpecificationInstance createFlowSpecification() {
		FlowSpecificationInstance newFlowSpecification = (FlowSpecificationInstance) create(InstancePackage.Literals.FLOW_SPECIFICATION_INSTANCE);
		getFlowSpecifications().add(newFlowSpecification);
		return newFlowSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EndToEndFlowInstance> getEndToEndFlows() {
		if (endToEndFlows == null) {
			endToEndFlows = new EObjectContainmentEList<EndToEndFlowInstance>(EndToEndFlowInstance.class, this,
					InstancePackage.COMPONENT_INSTANCE__END_TO_END_FLOW);
		}
		return endToEndFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EndToEndFlowInstance createEndToEndFlow() {
		EndToEndFlowInstance newEndToEndFlow = (EndToEndFlowInstance) create(InstancePackage.Literals.END_TO_END_FLOW_INSTANCE);
		getEndToEndFlows().add(newEndToEndFlow);
		return newEndToEndFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConnectionInstance> getConnectionInstances() {
		if (connectionInstances == null) {
			connectionInstances = new EObjectContainmentEList<ConnectionInstance>(ConnectionInstance.class, this,
					InstancePackage.COMPONENT_INSTANCE__CONNECTION_INSTANCE);
		}
		return connectionInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectionInstance createConnectionInstance() {
		ConnectionInstance newConnectionInstance = (ConnectionInstance) create(InstancePackage.Literals.CONNECTION_INSTANCE);
		getConnectionInstances().add(newConnectionInstance);
		return newConnectionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case InstancePackage.COMPONENT_INSTANCE__FEATURE_INSTANCE:
			return ((InternalEList<?>) getFeatureInstances()).basicRemove(otherEnd, msgs);
		case InstancePackage.COMPONENT_INSTANCE__COMPONENT_INSTANCE:
			return ((InternalEList<?>) getComponentInstances()).basicRemove(otherEnd, msgs);
		case InstancePackage.COMPONENT_INSTANCE__MODE_INSTANCE:
			return ((InternalEList<?>) getModeInstances()).basicRemove(otherEnd, msgs);
		case InstancePackage.COMPONENT_INSTANCE__MODE_TRANSITION_INSTANCE:
			return ((InternalEList<?>) getModeTransitionInstances()).basicRemove(otherEnd, msgs);
		case InstancePackage.COMPONENT_INSTANCE__FLOW_SPECIFICATION:
			return ((InternalEList<?>) getFlowSpecifications()).basicRemove(otherEnd, msgs);
		case InstancePackage.COMPONENT_INSTANCE__END_TO_END_FLOW:
			return ((InternalEList<?>) getEndToEndFlows()).basicRemove(otherEnd, msgs);
		case InstancePackage.COMPONENT_INSTANCE__CONNECTION_INSTANCE:
			return ((InternalEList<?>) getConnectionInstances()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InstancePackage.COMPONENT_INSTANCE__FEATURE_INSTANCE:
			return getFeatureInstances();
		case InstancePackage.COMPONENT_INSTANCE__COMPONENT_INSTANCE:
			return getComponentInstances();
		case InstancePackage.COMPONENT_INSTANCE__MODE_INSTANCE:
			return getModeInstances();
		case InstancePackage.COMPONENT_INSTANCE__MODE_TRANSITION_INSTANCE:
			return getModeTransitionInstances();
		case InstancePackage.COMPONENT_INSTANCE__CATEGORY:
			return getCategory();
		case InstancePackage.COMPONENT_INSTANCE__IN_MODE:
			return getInModes();
		case InstancePackage.COMPONENT_INSTANCE__FLOW_SPECIFICATION:
			return getFlowSpecifications();
		case InstancePackage.COMPONENT_INSTANCE__END_TO_END_FLOW:
			return getEndToEndFlows();
		case InstancePackage.COMPONENT_INSTANCE__CONNECTION_INSTANCE:
			return getConnectionInstances();
		case InstancePackage.COMPONENT_INSTANCE__SUBCOMPONENT:
			if (resolve) {
				return getSubcomponent();
			}
			return basicGetSubcomponent();
		case InstancePackage.COMPONENT_INSTANCE__INDEX:
			return getIndices();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case InstancePackage.COMPONENT_INSTANCE__FEATURE_INSTANCE:
			getFeatureInstances().clear();
			getFeatureInstances().addAll((Collection<? extends FeatureInstance>) newValue);
			return;
		case InstancePackage.COMPONENT_INSTANCE__COMPONENT_INSTANCE:
			getComponentInstances().clear();
			getComponentInstances().addAll((Collection<? extends ComponentInstance>) newValue);
			return;
		case InstancePackage.COMPONENT_INSTANCE__MODE_INSTANCE:
			getModeInstances().clear();
			getModeInstances().addAll((Collection<? extends ModeInstance>) newValue);
			return;
		case InstancePackage.COMPONENT_INSTANCE__MODE_TRANSITION_INSTANCE:
			getModeTransitionInstances().clear();
			getModeTransitionInstances().addAll((Collection<? extends ModeTransitionInstance>) newValue);
			return;
		case InstancePackage.COMPONENT_INSTANCE__CATEGORY:
			setCategory((ComponentCategory) newValue);
			return;
		case InstancePackage.COMPONENT_INSTANCE__IN_MODE:
			getInModes().clear();
			getInModes().addAll((Collection<? extends ModeInstance>) newValue);
			return;
		case InstancePackage.COMPONENT_INSTANCE__FLOW_SPECIFICATION:
			getFlowSpecifications().clear();
			getFlowSpecifications().addAll((Collection<? extends FlowSpecificationInstance>) newValue);
			return;
		case InstancePackage.COMPONENT_INSTANCE__END_TO_END_FLOW:
			getEndToEndFlows().clear();
			getEndToEndFlows().addAll((Collection<? extends EndToEndFlowInstance>) newValue);
			return;
		case InstancePackage.COMPONENT_INSTANCE__CONNECTION_INSTANCE:
			getConnectionInstances().clear();
			getConnectionInstances().addAll((Collection<? extends ConnectionInstance>) newValue);
			return;
		case InstancePackage.COMPONENT_INSTANCE__SUBCOMPONENT:
			setSubcomponent((Subcomponent) newValue);
			return;
		case InstancePackage.COMPONENT_INSTANCE__INDEX:
			getIndices().clear();
			getIndices().addAll((Collection<? extends Long>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case InstancePackage.COMPONENT_INSTANCE__FEATURE_INSTANCE:
			getFeatureInstances().clear();
			return;
		case InstancePackage.COMPONENT_INSTANCE__COMPONENT_INSTANCE:
			getComponentInstances().clear();
			return;
		case InstancePackage.COMPONENT_INSTANCE__MODE_INSTANCE:
			getModeInstances().clear();
			return;
		case InstancePackage.COMPONENT_INSTANCE__MODE_TRANSITION_INSTANCE:
			getModeTransitionInstances().clear();
			return;
		case InstancePackage.COMPONENT_INSTANCE__CATEGORY:
			setCategory(CATEGORY_EDEFAULT);
			return;
		case InstancePackage.COMPONENT_INSTANCE__IN_MODE:
			getInModes().clear();
			return;
		case InstancePackage.COMPONENT_INSTANCE__FLOW_SPECIFICATION:
			getFlowSpecifications().clear();
			return;
		case InstancePackage.COMPONENT_INSTANCE__END_TO_END_FLOW:
			getEndToEndFlows().clear();
			return;
		case InstancePackage.COMPONENT_INSTANCE__CONNECTION_INSTANCE:
			getConnectionInstances().clear();
			return;
		case InstancePackage.COMPONENT_INSTANCE__SUBCOMPONENT:
			setSubcomponent((Subcomponent) null);
			return;
		case InstancePackage.COMPONENT_INSTANCE__INDEX:
			getIndices().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case InstancePackage.COMPONENT_INSTANCE__FEATURE_INSTANCE:
			return featureInstances != null && !featureInstances.isEmpty();
		case InstancePackage.COMPONENT_INSTANCE__COMPONENT_INSTANCE:
			return componentInstances != null && !componentInstances.isEmpty();
		case InstancePackage.COMPONENT_INSTANCE__MODE_INSTANCE:
			return modeInstances != null && !modeInstances.isEmpty();
		case InstancePackage.COMPONENT_INSTANCE__MODE_TRANSITION_INSTANCE:
			return modeTransitionInstances != null && !modeTransitionInstances.isEmpty();
		case InstancePackage.COMPONENT_INSTANCE__CATEGORY:
			return category != CATEGORY_EDEFAULT;
		case InstancePackage.COMPONENT_INSTANCE__IN_MODE:
			return inModes != null && !inModes.isEmpty();
		case InstancePackage.COMPONENT_INSTANCE__FLOW_SPECIFICATION:
			return flowSpecifications != null && !flowSpecifications.isEmpty();
		case InstancePackage.COMPONENT_INSTANCE__END_TO_END_FLOW:
			return endToEndFlows != null && !endToEndFlows.isEmpty();
		case InstancePackage.COMPONENT_INSTANCE__CONNECTION_INSTANCE:
			return connectionInstances != null && !connectionInstances.isEmpty();
		case InstancePackage.COMPONENT_INSTANCE__SUBCOMPONENT:
			return subcomponent != null;
		case InstancePackage.COMPONENT_INSTANCE__INDEX:
			return indices != null && !indices.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (category: "); //$NON-NLS-1$
		result.append(category);
		result.append(", index: "); //$NON-NLS-1$
		result.append(indices);
		result.append(')');
		return result.toString();
	}

	@Override
	public boolean acceptsProperty(Property property) {
		// OsateDebug.osateDebug("[CompnentInstanceImpl] property=" + property);

		for (final PropertyOwner propOwner : property.getAppliesTos()) {

			if (propOwner instanceof MetaclassReference) {
				MetaclassReference metaRef = (MetaclassReference) propOwner;

				if (getCategory().equals(ComponentCategory.ABSTRACT)) {
					return true;
				}

				if (metaRef.getMetaclassNames().size() > 0 && metaRef.getMetaclassNames().get(0).equals("all")) {
					return true;
				}

				if (metaRef.getMetaclass() == null) {
					return false;
				}

				String catLitteral = metaRef.getMetaclass().getName().toLowerCase();

				/*
				 * JD: fixes for bug #126
				 * The following line has been added to fix bug #126
				 * When getting the literal value of the category from the meta model,
				 * we get the literal "virtualprocessor" or "virtualbus" because
				 * it is splitted into two words. On the other hand, the ComponentCategory
				 * class use a space between the two. For these reason, we
				 * force the category litteral when finding virtualprocessor
				 * or virtualbus.
				 */
				if (catLitteral.equals("virtualprocessor")) {
					catLitteral = "virtual processor";
				} else if (catLitteral.equals("virtualbus")) {
					catLitteral = "virtual bus";
				} else if (catLitteral.equals("subprogramgroup")) {
					catLitteral = "subprogram group";
				} else if (catLitteral.equals("threadgroup")) {
					catLitteral = "thread group";
				}

				final ComponentCategory categ = ComponentCategory.get(catLitteral);

				if (getCategory().equals(categ)) {
					return true;
				}
			}
		}

		final ComponentClassifier cc = getComponentClassifier();

		return (cc == null) ? false : cc.checkAppliesToClassifier(property);

	}

	/**
	 * find the mode transition instance of this component instance
	 * @param mt mode transition whose instance is to be found
	 * @return mode transition with the specified mode transition, or null
	 */
	@Override
	public ModeTransitionInstance findModeTransitionInstance(ModeTransition mt) {
		EList<ModeTransitionInstance> subcil = getModeTransitionInstances();
		for (Iterator<ModeTransitionInstance> it = subcil.iterator(); it.hasNext();) {
			ModeTransitionInstance mi = it.next();
			if (mi.getModeTransition() == mt) {
				return mi;
			}
		}
		return null;
	}

	/**
	 * find the mode instance of this component instance
	 * @param mode mode whose instance is to be found
	 * @return mode instance with the specified mode, or null
	 */
	@Override
	public ModeInstance findModeInstance(Mode mode) {
		EList<ModeInstance> subcil = getModeInstances();
		if (subcil == null) {
			return null;
		}
		for (Iterator<ModeInstance> it = subcil.iterator(); it.hasNext();) {
			ModeInstance mi = it.next();
			if (mi.getMode() == mode) {
				return mi;
			}
		}
		return null;
	}

	/**
	 * find the subcomponent instance of this component instance
	 * @param sc subcomponent
	 * @return component instance with the specified subcomponent, or null
	 */
	@Override
	public ComponentInstance findSubcomponentInstance(Subcomponent sc) {
		if (sc == null) {
			return null;
		}
		EList<ComponentInstance> subcil = getComponentInstances();
		for (Iterator<ComponentInstance> it = subcil.iterator(); it.hasNext();) {
			ComponentInstance ci = it.next();
			// XXX: Do we need to do this for modes and end-to-end flows too???
			EList<Subcomponent> scl = ci.getSubcomponent().getAllSubcomponentRefinements();
			if (scl.contains(sc)) {
				return ci;
			}
		}
		return null;
	}

	/**
	 * find the feature instance of this component instance
	 * @param feature feature whose instance is to be found
	 * @return feature instance with the specified feature, or null
	 */
	@Override
	public FeatureInstance findFeatureInstance(Feature feature) {
		if (feature == null) {
			return null;
		}
		EList<FeatureInstance> subcil = getFeatureInstances();
		for (Iterator<FeatureInstance> it = subcil.iterator(); it.hasNext();) {
			FeatureInstance fi = it.next();
			EList<Feature> fl = fi.getFeature().getAllFeatureRefinements();
			if (fl.contains(feature)) {
				return fi;
			}
		}
		return null;
	}

	/**
	 * Project this component into the given mode.  The mode must be
	 * an element of {@link #getModeInstances()}, but this is not currently
	 * checked.
	 */
	@Override
	public void setCurrentMode(ModeInstance newMode) {
		currentMode = newMode;
	}

	/**
	 * find the flowspec instance of this component instance
	 * @param flowspec flowspec whose instance is to be found
	 * @return flowspec instance with the specified flowspec, or null
	 */
	@Override
	public FlowSpecificationInstance findFlowSpecInstance(FlowSpecification flowspec) {
		if (flowspec == null) {
			return null;
		}
		EList<FlowSpecificationInstance> subcil = getFlowSpecifications();
		for (Iterator<FlowSpecificationInstance> it = subcil.iterator(); it.hasNext();) {
			FlowSpecificationInstance fi = it.next();
			if (fi.getFlowSpecification() == flowspec) {
				return fi;
			}
		}
		return null;
	}

	@Override
	public List<SystemOperationMode> getExistsInModes() {
		final List<ModeInstance> inModes = getInModes();

		if (inModes == null || inModes.isEmpty()) {
			return null;
		} else {
			// Get all SOMs that contain one of the mode instances in inModes
			final List<SystemOperationMode> processedModes = new ArrayList<SystemOperationMode>();

			for (SystemOperationMode som : getSystemInstance().getSystemOperationModes()) {
				for (ModeInstance mi : som.getCurrentModes()) {
					if (inModes.contains(mi)) {
						processedModes.add(som);
						break;
					}
				}
			}
			return processedModes;
		}
	}

	/**
	 * find the Connection instance of this component instance
	 * @param conn Connection whose instance is to be found
	 * @return Connection instance list with the specified Connection
	 */
	@Override
	public EList<ConnectionInstance> findConnectionInstance(Connection conn) {
		EList<ConnectionInstance> result = new BasicEList<ConnectionInstance>();

		for (ConnectionInstance conni : getSystemInstance().allConnectionInstances()) {
			for (ConnectionReference connRef : conni.getConnectionReferences()) {
				if (isSameOrRefined(connRef.getConnection(), conn)
						&& ((this == connRef.getContext()) || connRef.getContext() == null)) {
					result.add(conni);
					break;
				}
			}
		}
		return result;
	}

	/**
	 * find the endtoendflow instance of this component instance
	 * @param ete endtoendflow whose instance is to be found
	 * @return endtoendflow instance with the specified endtoendflow, or null
	 */
	@Override
	public EndToEndFlowInstance findEndToEndFlowInstance(EndToEndFlow ete) {
		if (ete == null) {
			return null;
		}
		EList<EndToEndFlowInstance> subcil = getEndToEndFlows();
		for (Iterator<EndToEndFlowInstance> it = subcil.iterator(); it.hasNext();) {
			EndToEndFlowInstance fi = it.next();
			if (fi.getEndToEndFlow() == ete) {
				return fi;
			}
		}
		return null;
	}

	/**
	 * determine whether two connections are the same or one is a refinement of the other
	 * @param firstconn Connection
	 * @param secondconn Connection
	 * @return boolean true if same or refined
	 */
	private static boolean isSameOrRefined(Connection firstconn, Connection secondconn) {
		if (firstconn == secondconn) {
			return true;
		}
		Connection cfi = firstconn;
		while (cfi != null) {
			if (secondconn == cfi) {
				return true;
			}
			cfi = cfi.getRefined();
		}
		cfi = secondconn;
		while (cfi != null) {
			if (firstconn == cfi) {
				return true;
			}
			cfi = cfi.getRefined();
		}
		return false;
	}

	@Override
	public List<? extends NamedElement> getInstantiatedObjects() {
		return Collections.singletonList(getSubcomponent());
	}

	/**
	 * return all component instances in the containment structure including the root
	 * The root being this
	 */
	@Override
	public EList<ComponentInstance> getAllComponentInstances() {
		EList<ComponentInstance> result = new BasicEList<ComponentInstance>();
		doAddComponentInstances(result);
		return result;
	}

	private void doAddComponentInstances(EList<ComponentInstance> result) {
		result.add(this);
		EList<ComponentInstance> children = getComponentInstances();
		for (Iterator<ComponentInstance> it = children.iterator(); it.hasNext();) {
			((ComponentInstanceImpl) it.next()).doAddComponentInstances(result);
		}
	}

	@Override
	public boolean isActive(SystemOperationMode som) {
		if (getInModes().isEmpty()) {
			return getContainingComponentInstance().isActive(som);
		}
		for (ModeInstance m : getInModes()) {

			if (som.getCurrentModes().contains(m)) {
				return true;
				// return getContainingComponentInstance().isActive(som);
			}
		}
		return false;
	}

	@Override
	public ComponentClassifier getComponentClassifier() {
		Subcomponent sub = getSubcomponent();
		if (Aadl2Util.isNull(sub)) {
			return null;
		}
		return sub.getClassifier();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.instance.impl.InstanceObjectImpl#getPathName()
	 */
	@Override
	public String getFullName() {
		String array = "";
		for (Long i : getIndices()) {
			if (i > 0) {
				array += "[" + i + "]";
			}
		}
		return getName() + array;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.instance.impl.InstanceObjectImpl#findInstanceObjectsHelper(java.util.ListIterator, java.util.List)
	 */
	@Override
	protected boolean findInstanceObjectsHelper(ListIterator<ContainmentPathElement> pathIter, List<InstanceObject> ios) {
		boolean result = super.findInstanceObjectsHelper(pathIter, ios);

		if (!result && pathIter.hasNext()) {
			// add connections
			ContainmentPathElement cpe = pathIter.next();
			NamedElement ne = cpe.getNamedElement();

			if (ne instanceof Connection) {
				ios.addAll(findConnectionInstance((Connection) ne));
			}
			pathIter.previous();
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.instance.InstanceObject#matchesIndex(java.util.List)
	 */
	@Override
	public boolean matchesIndex(List<ArrayRange> ranges) {
		if (ranges.size() == 0) {
			return true;
		}
		if (ranges.size() == indices.size()) {
			int i = 0;
			for (ArrayRange r : ranges) {
				if (r.getLowerBound() > 0 || r.getUpperBound() > 0) {
					if (indices.get(i) < (r.getLowerBound() > 0 ? r.getLowerBound() : r.getUpperBound())
							|| indices.get(i) > (r.getUpperBound() > 0 ? r.getUpperBound() : r.getLowerBound())) {
						return false;
					}
				}
				i++;
			}
			return true;
		}
		return false;
	}

} // ComponentInstanceImpl
