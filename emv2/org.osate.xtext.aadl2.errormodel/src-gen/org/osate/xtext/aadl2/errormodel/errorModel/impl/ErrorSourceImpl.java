/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateOrTypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl#isAll <em>All</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl#getFailureModeReference <em>Failure Mode Reference</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl#getFailureModeType <em>Failure Mode Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorSourceImpl extends ErrorFlowImpl implements ErrorSource
{
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
	 * The cached value of the '{@link #getFailureModeReference() <em>Failure Mode Reference</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFailureModeReference()
	 * @generated
	 * @ordered
	 */
  protected ErrorBehaviorStateOrTypeSet failureModeReference;

  /**
	 * The cached value of the '{@link #getFailureModeType() <em>Failure Mode Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFailureModeType()
	 * @generated
	 * @ordered
	 */
  protected TypeSet failureModeType;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ErrorSourceImpl()
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
		return ErrorModelPackage.Literals.ERROR_SOURCE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_SOURCE__OUTGOING, oldOutgoing, outgoing));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_SOURCE__OUTGOING, oldOutgoing, outgoing));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_SOURCE__ALL, oldAll, all));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorBehaviorStateOrTypeSet getFailureModeReference()
  {
		if (failureModeReference != null && failureModeReference.eIsProxy()) {
			InternalEObject oldFailureModeReference = (InternalEObject)failureModeReference;
			failureModeReference = (ErrorBehaviorStateOrTypeSet)eResolveProxy(oldFailureModeReference);
			if (failureModeReference != oldFailureModeReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_REFERENCE, oldFailureModeReference, failureModeReference));
			}
		}
		return failureModeReference;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorBehaviorStateOrTypeSet basicGetFailureModeReference()
  {
		return failureModeReference;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFailureModeReference(ErrorBehaviorStateOrTypeSet newFailureModeReference)
  {
		ErrorBehaviorStateOrTypeSet oldFailureModeReference = failureModeReference;
		failureModeReference = newFailureModeReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_REFERENCE, oldFailureModeReference, failureModeReference));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeSet getFailureModeType()
  {
		return failureModeType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetFailureModeType(TypeSet newFailureModeType, NotificationChain msgs)
  {
		TypeSet oldFailureModeType = failureModeType;
		failureModeType = newFailureModeType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE, oldFailureModeType, newFailureModeType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFailureModeType(TypeSet newFailureModeType)
  {
		if (newFailureModeType != failureModeType) {
			NotificationChain msgs = null;
			if (failureModeType != null)
				msgs = ((InternalEObject)failureModeType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE, null, msgs);
			if (newFailureModeType != null)
				msgs = ((InternalEObject)newFailureModeType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE, null, msgs);
			msgs = basicSetFailureModeType(newFailureModeType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE, newFailureModeType, newFailureModeType));
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
			case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE:
				return basicSetFailureModeType(null, msgs);
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
			case ErrorModelPackage.ERROR_SOURCE__OUTGOING:
				if (resolve) return getOutgoing();
				return basicGetOutgoing();
			case ErrorModelPackage.ERROR_SOURCE__ALL:
				return isAll();
			case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_REFERENCE:
				if (resolve) return getFailureModeReference();
				return basicGetFailureModeReference();
			case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE:
				return getFailureModeType();
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
			case ErrorModelPackage.ERROR_SOURCE__OUTGOING:
				setOutgoing((ErrorPropagation)newValue);
				return;
			case ErrorModelPackage.ERROR_SOURCE__ALL:
				setAll((Boolean)newValue);
				return;
			case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_REFERENCE:
				setFailureModeReference((ErrorBehaviorStateOrTypeSet)newValue);
				return;
			case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE:
				setFailureModeType((TypeSet)newValue);
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
			case ErrorModelPackage.ERROR_SOURCE__OUTGOING:
				setOutgoing((ErrorPropagation)null);
				return;
			case ErrorModelPackage.ERROR_SOURCE__ALL:
				setAll(ALL_EDEFAULT);
				return;
			case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_REFERENCE:
				setFailureModeReference((ErrorBehaviorStateOrTypeSet)null);
				return;
			case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE:
				setFailureModeType((TypeSet)null);
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
			case ErrorModelPackage.ERROR_SOURCE__OUTGOING:
				return outgoing != null;
			case ErrorModelPackage.ERROR_SOURCE__ALL:
				return all != ALL_EDEFAULT;
			case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_REFERENCE:
				return failureModeReference != null;
			case ErrorModelPackage.ERROR_SOURCE__FAILURE_MODE_TYPE:
				return failureModeType != null;
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
		result.append(" (all: ");
		result.append(all);
		result.append(')');
		return result.toString();
	}

} //ErrorSourceImpl
