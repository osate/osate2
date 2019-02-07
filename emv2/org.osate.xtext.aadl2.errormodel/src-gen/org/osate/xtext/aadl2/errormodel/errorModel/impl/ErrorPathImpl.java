/**
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
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl#isAllIncoming <em>All Incoming</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl#isAllOutgoing <em>All Outgoing</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl#getTargetToken <em>Target Token</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl#getTypeMappingSet <em>Type Mapping Set</em>}</li>
 * </ul>
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
   * The default value of the '{@link #isAllIncoming() <em>All Incoming</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllIncoming()
   * @generated
   * @ordered
   */
  protected static final boolean ALL_INCOMING_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAllIncoming() <em>All Incoming</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllIncoming()
   * @generated
   * @ordered
   */
  protected boolean allIncoming = ALL_INCOMING_EDEFAULT;

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
   * The default value of the '{@link #isAllOutgoing() <em>All Outgoing</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllOutgoing()
   * @generated
   * @ordered
   */
  protected static final boolean ALL_OUTGOING_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAllOutgoing() <em>All Outgoing</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllOutgoing()
   * @generated
   * @ordered
   */
  protected boolean allOutgoing = ALL_OUTGOING_EDEFAULT;

  /**
   * The cached value of the '{@link #getTargetToken() <em>Target Token</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetToken()
   * @generated
   * @ordered
   */
  protected TypeSet targetToken;

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
    if (incoming != null && incoming.eIsProxy())
    {
      InternalEObject oldIncoming = (InternalEObject)incoming;
      incoming = (ErrorPropagation)eResolveProxy(oldIncoming);
      if (incoming != oldIncoming)
      {
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
  public boolean isAllIncoming()
  {
    return allIncoming;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAllIncoming(boolean newAllIncoming)
  {
    boolean oldAllIncoming = allIncoming;
    allIncoming = newAllIncoming;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PATH__ALL_INCOMING, oldAllIncoming, allIncoming));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorPropagation getOutgoing()
  {
    if (outgoing != null && outgoing.eIsProxy())
    {
      InternalEObject oldOutgoing = (InternalEObject)outgoing;
      outgoing = (ErrorPropagation)eResolveProxy(oldOutgoing);
      if (outgoing != oldOutgoing)
      {
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
  public boolean isAllOutgoing()
  {
    return allOutgoing;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAllOutgoing(boolean newAllOutgoing)
  {
    boolean oldAllOutgoing = allOutgoing;
    allOutgoing = newAllOutgoing;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PATH__ALL_OUTGOING, oldAllOutgoing, allOutgoing));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSet getTargetToken()
  {
    return targetToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTargetToken(TypeSet newTargetToken, NotificationChain msgs)
  {
    TypeSet oldTargetToken = targetToken;
    targetToken = newTargetToken;
    if (eNotificationRequired())
    {
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
  public void setTargetToken(TypeSet newTargetToken)
  {
    if (newTargetToken != targetToken)
    {
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
    if (typeMappingSet != null && typeMappingSet.eIsProxy())
    {
      InternalEObject oldTypeMappingSet = (InternalEObject)typeMappingSet;
      typeMappingSet = (TypeMappingSet)eResolveProxy(oldTypeMappingSet);
      if (typeMappingSet != oldTypeMappingSet)
      {
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
    switch (featureID)
    {
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
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_PATH__INCOMING:
        if (resolve) return getIncoming();
        return basicGetIncoming();
      case ErrorModelPackage.ERROR_PATH__ALL_INCOMING:
        return isAllIncoming();
      case ErrorModelPackage.ERROR_PATH__OUTGOING:
        if (resolve) return getOutgoing();
        return basicGetOutgoing();
      case ErrorModelPackage.ERROR_PATH__ALL_OUTGOING:
        return isAllOutgoing();
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
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_PATH__INCOMING:
        setIncoming((ErrorPropagation)newValue);
        return;
      case ErrorModelPackage.ERROR_PATH__ALL_INCOMING:
        setAllIncoming((Boolean)newValue);
        return;
      case ErrorModelPackage.ERROR_PATH__OUTGOING:
        setOutgoing((ErrorPropagation)newValue);
        return;
      case ErrorModelPackage.ERROR_PATH__ALL_OUTGOING:
        setAllOutgoing((Boolean)newValue);
        return;
      case ErrorModelPackage.ERROR_PATH__TARGET_TOKEN:
        setTargetToken((TypeSet)newValue);
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
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_PATH__INCOMING:
        setIncoming((ErrorPropagation)null);
        return;
      case ErrorModelPackage.ERROR_PATH__ALL_INCOMING:
        setAllIncoming(ALL_INCOMING_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_PATH__OUTGOING:
        setOutgoing((ErrorPropagation)null);
        return;
      case ErrorModelPackage.ERROR_PATH__ALL_OUTGOING:
        setAllOutgoing(ALL_OUTGOING_EDEFAULT);
        return;
      case ErrorModelPackage.ERROR_PATH__TARGET_TOKEN:
        setTargetToken((TypeSet)null);
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
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_PATH__INCOMING:
        return incoming != null;
      case ErrorModelPackage.ERROR_PATH__ALL_INCOMING:
        return allIncoming != ALL_INCOMING_EDEFAULT;
      case ErrorModelPackage.ERROR_PATH__OUTGOING:
        return outgoing != null;
      case ErrorModelPackage.ERROR_PATH__ALL_OUTGOING:
        return allOutgoing != ALL_OUTGOING_EDEFAULT;
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (allIncoming: ");
    result.append(allIncoming);
    result.append(", allOutgoing: ");
    result.append(allOutgoing);
    result.append(')');
    return result.toString();
  }

} //ErrorPathImpl
