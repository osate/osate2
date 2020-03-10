/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.Literal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.BehaviorInstanceImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.BehaviorInstanceImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.BehaviorInstanceImpl#isSource <em>Source</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.BehaviorInstanceImpl#isSink <em>Sink</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorInstanceImpl extends EMV2InstanceObjectImpl implements BehaviorInstance {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Literal condition;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstrainedInstanceObject> actions;

	/**
	 * The default value of the '{@link #isSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSource()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SOURCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSource()
	 * @generated
	 * @ordered
	 */
	protected boolean source = SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isSink() <em>Sink</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSink()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SINK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSink() <em>Sink</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSink()
	 * @generated
	 * @ordered
	 */
	protected boolean sink = SINK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.BEHAVIOR_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Literal getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(Literal newCondition, NotificationChain msgs) {
		Literal oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.BEHAVIOR_INSTANCE__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCondition(Literal newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.BEHAVIOR_INSTANCE__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.BEHAVIOR_INSTANCE__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.BEHAVIOR_INSTANCE__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConstrainedInstanceObject> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<ConstrainedInstanceObject>(ConstrainedInstanceObject.class, this, EMV2InstancePackage.BEHAVIOR_INSTANCE__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(boolean newSource) {
		boolean oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.BEHAVIOR_INSTANCE__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSink() {
		return sink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSink(boolean newSink) {
		boolean oldSink = sink;
		sink = newSink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.BEHAVIOR_INSTANCE__SINK, oldSink, sink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__CONDITION:
				return basicSetCondition(null, msgs);
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
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
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__CONDITION:
				return getCondition();
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__ACTIONS:
				return getActions();
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__SOURCE:
				return isSource();
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__SINK:
				return isSink();
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
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__CONDITION:
				setCondition((Literal)newValue);
				return;
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends ConstrainedInstanceObject>)newValue);
				return;
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__SOURCE:
				setSource((Boolean)newValue);
				return;
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__SINK:
				setSink((Boolean)newValue);
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
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__CONDITION:
				setCondition((Literal)null);
				return;
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__ACTIONS:
				getActions().clear();
				return;
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__SOURCE:
				setSource(SOURCE_EDEFAULT);
				return;
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__SINK:
				setSink(SINK_EDEFAULT);
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
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__CONDITION:
				return condition != null;
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__ACTIONS:
				return actions != null && !actions.isEmpty();
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__SOURCE:
				return source != SOURCE_EDEFAULT;
			case EMV2InstancePackage.BEHAVIOR_INSTANCE__SINK:
				return sink != SINK_EDEFAULT;
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
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (source: ");
		result.append(source);
		result.append(", sink: ");
		result.append(sink);
		result.append(')');
		return result.toString();
	}

} //BehaviorInstanceImpl
