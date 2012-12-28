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

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl#isAll <em>All</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl#getTargetToken <em>Target Token</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl#getTypeMappingSet <em>Type Mapping Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorPathImpl extends ErrorFlowImpl implements ErrorPath
{
  /**
	 * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getIncoming()
	 * @generated
	 * @ordered
	 */
  protected ErrorPropagation incoming;

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
	 * The cached value of the '{@link #getTargetToken() <em>Target Token</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTargetToken()
	 * @generated
	 * @ordered
	 */
  protected TypeToken targetToken;

  /**
	 * The cached value of the '{@link #getTypeMappingSet() <em>Type Mapping Set</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTypeMappingSet()
	 * @generated
	 * @ordered
	 */
  protected TypeMappingSet typeMappingSet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ErrorPathImpl()
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
		return ErrorModelPackage.Literals.ERROR_PATH;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorPropagation getIncoming()
  {
		if (incoming != null && incoming.eIsProxy()) {
			InternalEObject oldIncoming = (InternalEObject)incoming;
			incoming = (ErrorPropagation)eResolveProxy(oldIncoming);
			if (incoming != oldIncoming) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_PATH__INCOMING, oldIncoming, incoming));
			}
		}
		return incoming;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorPropagation basicGetIncoming()
  {
		return incoming;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setIncoming(ErrorPropagation newIncoming)
  {
		ErrorPropagation oldIncoming = incoming;
		incoming = newIncoming;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PATH__INCOMING, oldIncoming, incoming));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_PATH__OUTGOING, oldOutgoing, outgoing));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PATH__OUTGOING, oldOutgoing, outgoing));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PATH__ALL, oldAll, all));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PATH__TARGET_TOKEN, oldTargetToken, newTargetToken);
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
				msgs = ((InternalEObject)targetToken).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_PATH__TARGET_TOKEN, null, msgs);
			if (newTargetToken != null)
				msgs = ((InternalEObject)newTargetToken).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_PATH__TARGET_TOKEN, null, msgs);
			msgs = basicSetTargetToken(newTargetToken, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PATH__TARGET_TOKEN, newTargetToken, newTargetToken));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeMappingSet getTypeMappingSet()
  {
		if (typeMappingSet != null && typeMappingSet.eIsProxy()) {
			InternalEObject oldTypeMappingSet = (InternalEObject)typeMappingSet;
			typeMappingSet = (TypeMappingSet)eResolveProxy(oldTypeMappingSet);
			if (typeMappingSet != oldTypeMappingSet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_PATH__TYPE_MAPPING_SET, oldTypeMappingSet, typeMappingSet));
			}
		}
		return typeMappingSet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeMappingSet basicGetTypeMappingSet()
  {
		return typeMappingSet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTypeMappingSet(TypeMappingSet newTypeMappingSet)
  {
		TypeMappingSet oldTypeMappingSet = typeMappingSet;
		typeMappingSet = newTypeMappingSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PATH__TYPE_MAPPING_SET, oldTypeMappingSet, typeMappingSet));
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
			case ErrorModelPackage.ERROR_PATH__TARGET_TOKEN:
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
			case ErrorModelPackage.ERROR_PATH__INCOMING:
				if (resolve) return getIncoming();
				return basicGetIncoming();
			case ErrorModelPackage.ERROR_PATH__OUTGOING:
				if (resolve) return getOutgoing();
				return basicGetOutgoing();
			case ErrorModelPackage.ERROR_PATH__ALL:
				return isAll();
			case ErrorModelPackage.ERROR_PATH__TARGET_TOKEN:
				return getTargetToken();
			case ErrorModelPackage.ERROR_PATH__TYPE_MAPPING_SET:
				if (resolve) return getTypeMappingSet();
				return basicGetTypeMappingSet();
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
			case ErrorModelPackage.ERROR_PATH__INCOMING:
				setIncoming((ErrorPropagation)newValue);
				return;
			case ErrorModelPackage.ERROR_PATH__OUTGOING:
				setOutgoing((ErrorPropagation)newValue);
				return;
			case ErrorModelPackage.ERROR_PATH__ALL:
				setAll((Boolean)newValue);
				return;
			case ErrorModelPackage.ERROR_PATH__TARGET_TOKEN:
				setTargetToken((TypeToken)newValue);
				return;
			case ErrorModelPackage.ERROR_PATH__TYPE_MAPPING_SET:
				setTypeMappingSet((TypeMappingSet)newValue);
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
			case ErrorModelPackage.ERROR_PATH__INCOMING:
				setIncoming((ErrorPropagation)null);
				return;
			case ErrorModelPackage.ERROR_PATH__OUTGOING:
				setOutgoing((ErrorPropagation)null);
				return;
			case ErrorModelPackage.ERROR_PATH__ALL:
				setAll(ALL_EDEFAULT);
				return;
			case ErrorModelPackage.ERROR_PATH__TARGET_TOKEN:
				setTargetToken((TypeToken)null);
				return;
			case ErrorModelPackage.ERROR_PATH__TYPE_MAPPING_SET:
				setTypeMappingSet((TypeMappingSet)null);
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
			case ErrorModelPackage.ERROR_PATH__INCOMING:
				return incoming != null;
			case ErrorModelPackage.ERROR_PATH__OUTGOING:
				return outgoing != null;
			case ErrorModelPackage.ERROR_PATH__ALL:
				return all != ALL_EDEFAULT;
			case ErrorModelPackage.ERROR_PATH__TARGET_TOKEN:
				return targetToken != null;
			case ErrorModelPackage.ERROR_PATH__TYPE_MAPPING_SET:
				return typeMappingSet != null;
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

} //ErrorPathImpl
