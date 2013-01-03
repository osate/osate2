/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Outgoing Propagation Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OutgoingPropagationConditionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OutgoingPropagationConditionImpl#getState <em>State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OutgoingPropagationConditionImpl#getTypeTokenConstraint <em>Type Token Constraint</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OutgoingPropagationConditionImpl#isAll <em>All</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OutgoingPropagationConditionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OutgoingPropagationConditionImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OutgoingPropagationConditionImpl#getTypeToken <em>Type Token</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OutgoingPropagationConditionImpl#isMask <em>Mask</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutgoingPropagationConditionImpl extends ElementImpl implements OutgoingPropagationCondition
{
  /**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
  protected static final String NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
  protected String name = NAME_EDEFAULT;

  /**
	 * The cached value of the '{@link #getState() <em>State</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
  protected ErrorBehaviorState state;

  /**
	 * The cached value of the '{@link #getTypeTokenConstraint() <em>Type Token Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTypeTokenConstraint()
	 * @generated
	 * @ordered
	 */
  protected TypeSet typeTokenConstraint;

  /**
	 * The default value of the '{@link #isAll() <em>All</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isAll()
	 * @generated
	 * @ordered
	 */
  protected static final boolean ALL_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isAll() <em>All</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isAll()
	 * @generated
	 * @ordered
	 */
  protected boolean all = ALL_EDEFAULT;

  /**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
  protected ConditionExpression condition;

  /**
	 * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOutgoing()
	 * @generated
	 * @ordered
	 */
  protected ErrorPropagation outgoing;

  /**
	 * The cached value of the '{@link #getTypeToken() <em>Type Token</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTypeToken()
	 * @generated
	 * @ordered
	 */
  protected TypeToken typeToken;

  /**
	 * The default value of the '{@link #isMask() <em>Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isMask()
	 * @generated
	 * @ordered
	 */
  protected static final boolean MASK_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isMask() <em>Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isMask()
	 * @generated
	 * @ordered
	 */
  protected boolean mask = MASK_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected OutgoingPropagationConditionImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return ErrorModelPackage.Literals.OUTGOING_PROPAGATION_CONDITION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getName()
  {
		return name;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setName(String newName)
  {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__NAME, oldName, name));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorBehaviorState getState()
  {
		if (state != null && state.eIsProxy()) {
			InternalEObject oldState = (InternalEObject)state;
			state = (ErrorBehaviorState)eResolveProxy(oldState);
			if (state != oldState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__STATE, oldState, state));
			}
		}
		return state;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorBehaviorState basicGetState()
  {
		return state;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setState(ErrorBehaviorState newState)
  {
		ErrorBehaviorState oldState = state;
		state = newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__STATE, oldState, state));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeSet getTypeTokenConstraint()
  {
		return typeTokenConstraint;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetTypeTokenConstraint(TypeSet newTypeTokenConstraint, NotificationChain msgs)
  {
		TypeSet oldTypeTokenConstraint = typeTokenConstraint;
		typeTokenConstraint = newTypeTokenConstraint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT, oldTypeTokenConstraint, newTypeTokenConstraint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTypeTokenConstraint(TypeSet newTypeTokenConstraint)
  {
		if (newTypeTokenConstraint != typeTokenConstraint) {
			NotificationChain msgs = null;
			if (typeTokenConstraint != null)
				msgs = ((InternalEObject)typeTokenConstraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT, null, msgs);
			if (newTypeTokenConstraint != null)
				msgs = ((InternalEObject)newTypeTokenConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT, null, msgs);
			msgs = basicSetTypeTokenConstraint(newTypeTokenConstraint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT, newTypeTokenConstraint, newTypeTokenConstraint));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isAll()
  {
		return all;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAll(boolean newAll)
  {
		boolean oldAll = all;
		all = newAll;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__ALL, oldAll, all));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ConditionExpression getCondition()
  {
		return condition;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetCondition(ConditionExpression newCondition, NotificationChain msgs)
  {
		ConditionExpression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCondition(ConditionExpression newCondition)
  {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION, newCondition, newCondition));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorPropagation getOutgoing()
  {
		if (outgoing != null && outgoing.eIsProxy()) {
			InternalEObject oldOutgoing = (InternalEObject)outgoing;
			outgoing = (ErrorPropagation)eResolveProxy(oldOutgoing);
			if (outgoing != oldOutgoing) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__OUTGOING, oldOutgoing, outgoing));
			}
		}
		return outgoing;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorPropagation basicGetOutgoing()
  {
		return outgoing;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setOutgoing(ErrorPropagation newOutgoing)
  {
		ErrorPropagation oldOutgoing = outgoing;
		outgoing = newOutgoing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__OUTGOING, oldOutgoing, outgoing));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeToken getTypeToken()
  {
		return typeToken;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetTypeToken(TypeToken newTypeToken, NotificationChain msgs)
  {
		TypeToken oldTypeToken = typeToken;
		typeToken = newTypeToken;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN, oldTypeToken, newTypeToken);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTypeToken(TypeToken newTypeToken)
  {
		if (newTypeToken != typeToken) {
			NotificationChain msgs = null;
			if (typeToken != null)
				msgs = ((InternalEObject)typeToken).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN, null, msgs);
			if (newTypeToken != null)
				msgs = ((InternalEObject)newTypeToken).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN, null, msgs);
			msgs = basicSetTypeToken(newTypeToken, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN, newTypeToken, newTypeToken));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isMask()
  {
		return mask;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMask(boolean newMask)
  {
		boolean oldMask = mask;
		mask = newMask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__MASK, oldMask, mask));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT:
				return basicSetTypeTokenConstraint(null, msgs);
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION:
				return basicSetCondition(null, msgs);
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN:
				return basicSetTypeToken(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__NAME:
				return getName();
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__STATE:
				if (resolve) return getState();
				return basicGetState();
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT:
				return getTypeTokenConstraint();
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__ALL:
				return isAll();
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION:
				return getCondition();
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__OUTGOING:
				if (resolve) return getOutgoing();
				return basicGetOutgoing();
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN:
				return getTypeToken();
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__MASK:
				return isMask();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__NAME:
				setName((String)newValue);
				return;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__STATE:
				setState((ErrorBehaviorState)newValue);
				return;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT:
				setTypeTokenConstraint((TypeSet)newValue);
				return;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__ALL:
				setAll((Boolean)newValue);
				return;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION:
				setCondition((ConditionExpression)newValue);
				return;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__OUTGOING:
				setOutgoing((ErrorPropagation)newValue);
				return;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN:
				setTypeToken((TypeToken)newValue);
				return;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__MASK:
				setMask((Boolean)newValue);
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
  public void eUnset(int featureID)
  {
		switch (featureID) {
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__STATE:
				setState((ErrorBehaviorState)null);
				return;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT:
				setTypeTokenConstraint((TypeSet)null);
				return;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__ALL:
				setAll(ALL_EDEFAULT);
				return;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION:
				setCondition((ConditionExpression)null);
				return;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__OUTGOING:
				setOutgoing((ErrorPropagation)null);
				return;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN:
				setTypeToken((TypeToken)null);
				return;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__MASK:
				setMask(MASK_EDEFAULT);
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
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__STATE:
				return state != null;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN_CONSTRAINT:
				return typeTokenConstraint != null;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__ALL:
				return all != ALL_EDEFAULT;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__CONDITION:
				return condition != null;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__OUTGOING:
				return outgoing != null;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__TYPE_TOKEN:
				return typeToken != null;
			case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION__MASK:
				return mask != MASK_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString()
  {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", all: ");
		result.append(all);
		result.append(", mask: ");
		result.append(mask);
		result.append(')');
		return result.toString();
	}

} //OutgoingPropagationConditionImpl
