/**
 * <copyright>
 * </copyright>
 *
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Branch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TransitionBranchImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TransitionBranchImpl#getTargetToken <em>Target Token</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TransitionBranchImpl#isMask <em>Mask</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TransitionBranchImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionBranchImpl extends ElementImpl implements TransitionBranch
{
  /**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
  protected ErrorBehaviorState target;

  /**
	 * The cached value of the '{@link #getTargetToken() <em>Target Token</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTargetToken()
	 * @generated
	 * @ordered
	 */
  protected TypeToken targetToken;

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
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
  protected static final String VALUE_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
  protected String value = VALUE_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TransitionBranchImpl()
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
		return ErrorModelPackage.Literals.TRANSITION_BRANCH;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorBehaviorState getTarget()
  {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (ErrorBehaviorState)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.TRANSITION_BRANCH__TARGET, oldTarget, target));
			}
		}
		return target;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorBehaviorState basicGetTarget()
  {
		return target;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTarget(ErrorBehaviorState newTarget)
  {
		ErrorBehaviorState oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TRANSITION_BRANCH__TARGET, oldTarget, target));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeToken getTargetToken()
  {
		return targetToken;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetTargetToken(TypeToken newTargetToken, NotificationChain msgs)
  {
		TypeToken oldTargetToken = targetToken;
		targetToken = newTargetToken;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN, oldTargetToken, newTargetToken);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTargetToken(TypeToken newTargetToken)
  {
		if (newTargetToken != targetToken) {
			NotificationChain msgs = null;
			if (targetToken != null)
				msgs = ((InternalEObject)targetToken).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN, null, msgs);
			if (newTargetToken != null)
				msgs = ((InternalEObject)newTargetToken).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN, null, msgs);
			msgs = basicSetTargetToken(newTargetToken, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN, newTargetToken, newTargetToken));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TRANSITION_BRANCH__MASK, oldMask, mask));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getValue()
  {
		return value;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setValue(String newValue)
  {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TRANSITION_BRANCH__VALUE, oldValue, value));
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
			case ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN:
				return basicSetTargetToken(null, msgs);
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
			case ErrorModelPackage.TRANSITION_BRANCH__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN:
				return getTargetToken();
			case ErrorModelPackage.TRANSITION_BRANCH__MASK:
				return isMask();
			case ErrorModelPackage.TRANSITION_BRANCH__VALUE:
				return getValue();
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
			case ErrorModelPackage.TRANSITION_BRANCH__TARGET:
				setTarget((ErrorBehaviorState)newValue);
				return;
			case ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN:
				setTargetToken((TypeToken)newValue);
				return;
			case ErrorModelPackage.TRANSITION_BRANCH__MASK:
				setMask((Boolean)newValue);
				return;
			case ErrorModelPackage.TRANSITION_BRANCH__VALUE:
				setValue((String)newValue);
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
			case ErrorModelPackage.TRANSITION_BRANCH__TARGET:
				setTarget((ErrorBehaviorState)null);
				return;
			case ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN:
				setTargetToken((TypeToken)null);
				return;
			case ErrorModelPackage.TRANSITION_BRANCH__MASK:
				setMask(MASK_EDEFAULT);
				return;
			case ErrorModelPackage.TRANSITION_BRANCH__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case ErrorModelPackage.TRANSITION_BRANCH__TARGET:
				return target != null;
			case ErrorModelPackage.TRANSITION_BRANCH__TARGET_TOKEN:
				return targetToken != null;
			case ErrorModelPackage.TRANSITION_BRANCH__MASK:
				return mask != MASK_EDEFAULT;
			case ErrorModelPackage.TRANSITION_BRANCH__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
		result.append(" (mask: ");
		result.append(mask);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //TransitionBranchImpl
