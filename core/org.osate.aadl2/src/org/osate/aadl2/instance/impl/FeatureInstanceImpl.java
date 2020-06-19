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
package org.osate.aadl2.instance.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.SystemOperationMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.FeatureInstanceImpl#getSrcFlowSpecs <em>Src Flow Spec</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FeatureInstanceImpl#getDstFlowSpecs <em>Dst Flow Spec</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FeatureInstanceImpl#getFeatureInstances <em>Feature Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FeatureInstanceImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FeatureInstanceImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FeatureInstanceImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FeatureInstanceImpl#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureInstanceImpl extends ConnectionInstanceEndImpl implements FeatureInstance {
	/**
	 * The cached value of the '{@link #getSrcFlowSpecs() <em>Src Flow Spec</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcFlowSpecs()
	 * @generated
	 * @ordered
	 */
	protected EList<FlowSpecificationInstance> srcFlowSpecs;

	/**
	 * The cached value of the '{@link #getDstFlowSpecs() <em>Dst Flow Spec</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstFlowSpecs()
	 * @generated
	 * @ordered
	 */
	protected EList<FlowSpecificationInstance> dstFlowSpecs;

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
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final FeatureCategory CATEGORY_EDEFAULT = FeatureCategory.DATA_PORT;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected FeatureCategory category = CATEGORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final DirectionType DIRECTION_EDEFAULT = DirectionType.IN;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected DirectionType direction = DIRECTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected Feature feature;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final long INDEX_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected long index = INDEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return InstancePackage.Literals.FEATURE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getFeature() {
		if (feature != null && ((EObject) feature).eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject) feature;
			feature = (Feature) eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InstancePackage.FEATURE_INSTANCE__FEATURE,
							oldFeature, feature));
				}
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(Feature newFeature) {
		Feature oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.FEATURE_INSTANCE__FEATURE, oldFeature,
					feature));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(long newIndex) {
		long oldIndex = index;
		index = newIndex;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.FEATURE_INSTANCE__INDEX, oldIndex,
					index));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case InstancePackage.FEATURE_INSTANCE__SRC_FLOW_SPEC:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSrcFlowSpecs()).basicAdd(otherEnd, msgs);
		case InstancePackage.FEATURE_INSTANCE__DST_FLOW_SPEC:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDstFlowSpecs()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FlowSpecificationInstance> getSrcFlowSpecs() {
		if (srcFlowSpecs == null) {
			srcFlowSpecs = new EObjectWithInverseEList<FlowSpecificationInstance>(FlowSpecificationInstance.class, this,
					InstancePackage.FEATURE_INSTANCE__SRC_FLOW_SPEC,
					InstancePackage.FLOW_SPECIFICATION_INSTANCE__SOURCE);
		}
		return srcFlowSpecs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FlowSpecificationInstance> getDstFlowSpecs() {
		if (dstFlowSpecs == null) {
			dstFlowSpecs = new EObjectWithInverseEList<FlowSpecificationInstance>(FlowSpecificationInstance.class, this,
					InstancePackage.FEATURE_INSTANCE__DST_FLOW_SPEC,
					InstancePackage.FLOW_SPECIFICATION_INSTANCE__DESTINATION);
		}
		return dstFlowSpecs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureInstance> getFeatureInstances() {
		if (featureInstances == null) {
			featureInstances = new EObjectContainmentEList<FeatureInstance>(FeatureInstance.class, this,
					InstancePackage.FEATURE_INSTANCE__FEATURE_INSTANCE);
		}
		return featureInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public FeatureCategory getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(FeatureCategory newCategory) {
		FeatureCategory oldCategory = category;
		category = newCategory == null ? CATEGORY_EDEFAULT : newCategory;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.FEATURE_INSTANCE__CATEGORY,
					oldCategory, category));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionType getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(DirectionType newDirection) {
		DirectionType oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.FEATURE_INSTANCE__DIRECTION,
					oldDirection, direction));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case InstancePackage.FEATURE_INSTANCE__SRC_FLOW_SPEC:
			return ((InternalEList<?>) getSrcFlowSpecs()).basicRemove(otherEnd, msgs);
		case InstancePackage.FEATURE_INSTANCE__DST_FLOW_SPEC:
			return ((InternalEList<?>) getDstFlowSpecs()).basicRemove(otherEnd, msgs);
		case InstancePackage.FEATURE_INSTANCE__FEATURE_INSTANCE:
			return ((InternalEList<?>) getFeatureInstances()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InstancePackage.FEATURE_INSTANCE__SRC_FLOW_SPEC:
			return getSrcFlowSpecs();
		case InstancePackage.FEATURE_INSTANCE__DST_FLOW_SPEC:
			return getDstFlowSpecs();
		case InstancePackage.FEATURE_INSTANCE__FEATURE_INSTANCE:
			return getFeatureInstances();
		case InstancePackage.FEATURE_INSTANCE__CATEGORY:
			return getCategory();
		case InstancePackage.FEATURE_INSTANCE__DIRECTION:
			return getDirection();
		case InstancePackage.FEATURE_INSTANCE__FEATURE:
			if (resolve) {
				return getFeature();
			}
			return basicGetFeature();
		case InstancePackage.FEATURE_INSTANCE__INDEX:
			return getIndex();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case InstancePackage.FEATURE_INSTANCE__SRC_FLOW_SPEC:
			getSrcFlowSpecs().clear();
			getSrcFlowSpecs().addAll((Collection<? extends FlowSpecificationInstance>) newValue);
			return;
		case InstancePackage.FEATURE_INSTANCE__DST_FLOW_SPEC:
			getDstFlowSpecs().clear();
			getDstFlowSpecs().addAll((Collection<? extends FlowSpecificationInstance>) newValue);
			return;
		case InstancePackage.FEATURE_INSTANCE__FEATURE_INSTANCE:
			getFeatureInstances().clear();
			getFeatureInstances().addAll((Collection<? extends FeatureInstance>) newValue);
			return;
		case InstancePackage.FEATURE_INSTANCE__CATEGORY:
			setCategory((FeatureCategory) newValue);
			return;
		case InstancePackage.FEATURE_INSTANCE__DIRECTION:
			setDirection((DirectionType) newValue);
			return;
		case InstancePackage.FEATURE_INSTANCE__FEATURE:
			setFeature((Feature) newValue);
			return;
		case InstancePackage.FEATURE_INSTANCE__INDEX:
			setIndex((Long) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
		case InstancePackage.FEATURE_INSTANCE__SRC_FLOW_SPEC:
			getSrcFlowSpecs().clear();
			return;
		case InstancePackage.FEATURE_INSTANCE__DST_FLOW_SPEC:
			getDstFlowSpecs().clear();
			return;
		case InstancePackage.FEATURE_INSTANCE__FEATURE_INSTANCE:
			getFeatureInstances().clear();
			return;
		case InstancePackage.FEATURE_INSTANCE__CATEGORY:
			setCategory(CATEGORY_EDEFAULT);
			return;
		case InstancePackage.FEATURE_INSTANCE__DIRECTION:
			setDirection(DIRECTION_EDEFAULT);
			return;
		case InstancePackage.FEATURE_INSTANCE__FEATURE:
			setFeature((Feature) null);
			return;
		case InstancePackage.FEATURE_INSTANCE__INDEX:
			setIndex(INDEX_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case InstancePackage.FEATURE_INSTANCE__SRC_FLOW_SPEC:
			return srcFlowSpecs != null && !srcFlowSpecs.isEmpty();
		case InstancePackage.FEATURE_INSTANCE__DST_FLOW_SPEC:
			return dstFlowSpecs != null && !dstFlowSpecs.isEmpty();
		case InstancePackage.FEATURE_INSTANCE__FEATURE_INSTANCE:
			return featureInstances != null && !featureInstances.isEmpty();
		case InstancePackage.FEATURE_INSTANCE__CATEGORY:
			return category != CATEGORY_EDEFAULT;
		case InstancePackage.FEATURE_INSTANCE__DIRECTION:
			return direction != DIRECTION_EDEFAULT;
		case InstancePackage.FEATURE_INSTANCE__FEATURE:
			return feature != null;
		case InstancePackage.FEATURE_INSTANCE__INDEX:
			return index != INDEX_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (category: "); //$NON-NLS-1$
		result.append(category);
		result.append(", direction: "); //$NON-NLS-1$
		result.append(direction);
		result.append(", index: "); //$NON-NLS-1$
		result.append(index);
		result.append(')');
		return result.toString();
	}

	/**
	 * find the matching inverse feature group instance in this feature group instance
	 * the contained feature group instance must have the inverse feature group type
	 * @param targetpgt feature group instance with feature group type to be found
	 * @return feature instance with the specified feature, or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public FeatureInstance findInverseFeatureGroup(FeatureGroupType targetpgt) {
		if (!(getFeature() instanceof FeatureGroup)) {
			return null;
		}
		EList<FeatureInstance> subcil = getFeatureInstances();
		for (Iterator<FeatureInstance> it = subcil.iterator(); it.hasNext();) {
			FeatureInstance fi = it.next();
			if (fi.getFeature() instanceof FeatureGroup) {
				FeatureGroupType srcpgt = ((FeatureGroup) fi.getFeature()).getFeatureGroupType();
				if (srcpgt != null && srcpgt.isInverseOf(targetpgt)) {
					return fi;
				}
				fi.findInverseFeatureGroup(targetpgt);
			}
		}
		return null;
	}

	/**
	 * set the featureinstance category to that of the supplied feature
	 * @param f Feature
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public void setCategory(Feature f) {
		if (f instanceof AbstractFeature) {
			setCategory(FeatureCategory.ABSTRACT_FEATURE);
		} else if (f instanceof BusAccess) {
			setCategory(FeatureCategory.BUS_ACCESS);
		} else if (f instanceof DataAccess) {
			setCategory(FeatureCategory.DATA_ACCESS);
		} else if (f instanceof DataPort) {
			setCategory(FeatureCategory.DATA_PORT);
		} else if (f instanceof EventDataPort) {
			setCategory(FeatureCategory.EVENT_DATA_PORT);
		} else if (f instanceof EventPort) {
			setCategory(FeatureCategory.EVENT_PORT);
		} else if (f instanceof FeatureGroup) {
			setCategory(FeatureCategory.FEATURE_GROUP);
		} else if (f instanceof Parameter) {
			setCategory(FeatureCategory.PARAMETER);
		} else if (f instanceof SubprogramAccess) {
			setCategory(FeatureCategory.SUBPROGRAM_ACCESS);
		} else if (f instanceof SubprogramGroupAccess) {
			setCategory(FeatureCategory.SUBPROGRAM_GROUP_ACCESS);
		}
	}

	/**
	 * find the feature instance of this feature instance
	 * @param feature feature whose instance is to be found
	 * @return feature instance with the specified feature, or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup work.
	public FeatureInstance findFeatureInstance(Feature feature) {
		EList<FeatureInstance> subcil = getFeatureInstances();
		for (Iterator<FeatureInstance> it = subcil.iterator(); it.hasNext();) {
			FeatureInstance fi = it.next();
			if (fi.getFeature() == feature) {
				return fi;
			}
		}
		return null;
	}

	/**
	 * Get all feature instances that fit a given path in a feature group.
	 */
	public Collection<FeatureInstance> findFeatureInstances(final EList<ContainmentPathElement> referencePath) {
		if (referencePath.isEmpty()) {
			return Collections.singleton((FeatureInstance) this);
		} else {
			FeatureInstance fi = this;

			for (Iterator<ContainmentPathElement> pathIter = referencePath.iterator(); pathIter.hasNext();) {
				NamedElement ne = pathIter.next().getNamedElement();

				if (ne instanceof Feature) {
					fi = fi.findFeatureInstance((Feature) ne);
					while ((fi != null) && (ne instanceof FeatureGroup) && pathIter.hasNext()) {
						// we may point to a port in a feature group
						ne = pathIter.next().getNamedElement();
						if (ne instanceof Feature) {
							fi = fi.findFeatureInstance((Feature) ne);
						}
					}
				}
			}
			return Collections.singleton(fi);
		}
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public List<Feature> getInstantiatedObjects() {
		return Collections.singletonList(getFeature());
	}

	public boolean isActive(SystemOperationMode som) {
		return getContainingComponentInstance().isActive(som);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.instance.impl.InstanceObjectImpl#getPathName()
	 */
	public String getFullName() {
		String array = "";
		if (getIndex() > 0) {
			array = "[" + getIndex() + "]";
		}
		return getName() + array;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.instance.InstanceObject#matchesIndex(java.util.List)
	 */
	public boolean matchesIndex(List<ArrayRange> ranges) {
		if (ranges.size() == 0) {
			return true;
		}
		if (ranges.size() == 1) {
			ArrayRange r = ranges.get(0);
			if ((r.getLowerBound() == 0 && r.getUpperBound() == 0)
					|| (r.getLowerBound() == 0 && index == r.getUpperBound())
					|| (r.getUpperBound() == 0 && index == r.getLowerBound())
					|| (r.getLowerBound() <= index && index <= r.getUpperBound())) {
				return true;
			}
		}
		return false;
	}

	public boolean isAccess() {
		return getCategory().isAccess();
	}

	public DirectionType getFlowDirection() {
		return isAccess() ? DirectionType.IN_OUT : getDirection();
	}

} // FeatureInstanceImpl
