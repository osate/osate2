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
 * $Id: FeatureInstanceImpl.java,v 1.15 2010-05-12 20:09:22 lwrage Exp $
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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
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
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.FeatureInstanceImpl#getSrcFlowSpecs <em>Src Flow Spec</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FeatureInstanceImpl#getDstFlowSpecs <em>Dst Flow Spec</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FeatureInstanceImpl#getFeatureInstances <em>Feature Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FeatureInstanceImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FeatureInstanceImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FeatureInstanceImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.FeatureInstanceImpl#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
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
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.FEATURE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Feature getFeature() {
		if (feature != null && ((EObject) feature).eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject) feature;
			feature = (Feature) eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.FEATURE_INSTANCE__FEATURE, oldFeature, feature));
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
	@Override
	public void setFeature(Feature newFeature) {
		Feature oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.FEATURE_INSTANCE__FEATURE,
					oldFeature, feature));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
	public EList<FlowSpecificationInstance> getSrcFlowSpecs() {
		if (srcFlowSpecs == null) {
			srcFlowSpecs = new EObjectWithInverseResolvingEList<FlowSpecificationInstance>(
					FlowSpecificationInstance.class, this, InstancePackage.FEATURE_INSTANCE__SRC_FLOW_SPEC,
					InstancePackage.FLOW_SPECIFICATION_INSTANCE__SOURCE);
		}
		return srcFlowSpecs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FlowSpecificationInstance> getDstFlowSpecs() {
		if (dstFlowSpecs == null) {
			dstFlowSpecs = new EObjectWithInverseResolvingEList<FlowSpecificationInstance>(
					FlowSpecificationInstance.class, this, InstancePackage.FEATURE_INSTANCE__DST_FLOW_SPEC,
					InstancePackage.FLOW_SPECIFICATION_INSTANCE__DESTINATION);
		}
		return dstFlowSpecs;
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
					InstancePackage.FEATURE_INSTANCE__FEATURE_INSTANCE);
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
	public FeatureCategory getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public DirectionType getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public final List<SystemOperationMode> getExistsInModes() {
		// Features always exist
		return null;
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	@Override
	public List<Feature> getInstantiatedObjects() {
		return Collections.singletonList(getFeature());
	}

	@Override
	public boolean isActive(SystemOperationMode som) {
		return getContainingComponentInstance().isActive(som);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.instance.impl.InstanceObjectImpl#getPathName()
	 */
	@Override
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
	@Override
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

} // FeatureInstanceImpl
