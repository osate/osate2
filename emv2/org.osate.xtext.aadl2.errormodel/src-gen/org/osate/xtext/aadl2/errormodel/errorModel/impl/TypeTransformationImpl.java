/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.impl.ElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TypeTransformationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TypeTransformationImpl#isAllSources <em>All Sources</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TypeTransformationImpl#getContributor <em>Contributor</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TypeTransformationImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeTransformationImpl extends ElementImpl implements TypeTransformation
{
  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected TypeSet source;

  /**
   * The default value of the '{@link #isAllSources() <em>All Sources</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllSources()
   * @generated
   * @ordered
   */
  protected static final boolean ALL_SOURCES_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAllSources() <em>All Sources</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllSources()
   * @generated
   * @ordered
   */
  protected boolean allSources = ALL_SOURCES_EDEFAULT;

  /**
   * The cached value of the '{@link #getContributor() <em>Contributor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContributor()
   * @generated
   * @ordered
   */
  protected TypeSet contributor;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected TypeSet target;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeTransformationImpl()
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
    return ErrorModelPackage.Literals.TYPE_TRANSFORMATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSet getSource()
  {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSource(TypeSet newSource, NotificationChain msgs)
  {
    TypeSet oldSource = source;
    source = newSource;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TYPE_TRANSFORMATION__SOURCE, oldSource, newSource);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSource(TypeSet newSource)
  {
    if (newSource != source)
    {
      NotificationChain msgs = null;
      if (source != null)
        msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.TYPE_TRANSFORMATION__SOURCE, null, msgs);
      if (newSource != null)
        msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.TYPE_TRANSFORMATION__SOURCE, null, msgs);
      msgs = basicSetSource(newSource, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TYPE_TRANSFORMATION__SOURCE, newSource, newSource));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAllSources()
  {
    return allSources;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAllSources(boolean newAllSources)
  {
    boolean oldAllSources = allSources;
    allSources = newAllSources;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TYPE_TRANSFORMATION__ALL_SOURCES, oldAllSources, allSources));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSet getContributor()
  {
    return contributor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContributor(TypeSet newContributor, NotificationChain msgs)
  {
    TypeSet oldContributor = contributor;
    contributor = newContributor;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TYPE_TRANSFORMATION__CONTRIBUTOR, oldContributor, newContributor);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContributor(TypeSet newContributor)
  {
    if (newContributor != contributor)
    {
      NotificationChain msgs = null;
      if (contributor != null)
        msgs = ((InternalEObject)contributor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.TYPE_TRANSFORMATION__CONTRIBUTOR, null, msgs);
      if (newContributor != null)
        msgs = ((InternalEObject)newContributor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.TYPE_TRANSFORMATION__CONTRIBUTOR, null, msgs);
      msgs = basicSetContributor(newContributor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TYPE_TRANSFORMATION__CONTRIBUTOR, newContributor, newContributor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSet getTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTarget(TypeSet newTarget, NotificationChain msgs)
  {
    TypeSet oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TYPE_TRANSFORMATION__TARGET, oldTarget, newTarget);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(TypeSet newTarget)
  {
    if (newTarget != target)
    {
      NotificationChain msgs = null;
      if (target != null)
        msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.TYPE_TRANSFORMATION__TARGET, null, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.TYPE_TRANSFORMATION__TARGET, null, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.TYPE_TRANSFORMATION__TARGET, newTarget, newTarget));
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
      case ErrorModelPackage.TYPE_TRANSFORMATION__SOURCE:
        return basicSetSource(null, msgs);
      case ErrorModelPackage.TYPE_TRANSFORMATION__CONTRIBUTOR:
        return basicSetContributor(null, msgs);
      case ErrorModelPackage.TYPE_TRANSFORMATION__TARGET:
        return basicSetTarget(null, msgs);
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
      case ErrorModelPackage.TYPE_TRANSFORMATION__SOURCE:
        return getSource();
      case ErrorModelPackage.TYPE_TRANSFORMATION__ALL_SOURCES:
        return isAllSources();
      case ErrorModelPackage.TYPE_TRANSFORMATION__CONTRIBUTOR:
        return getContributor();
      case ErrorModelPackage.TYPE_TRANSFORMATION__TARGET:
        return getTarget();
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
      case ErrorModelPackage.TYPE_TRANSFORMATION__SOURCE:
        setSource((TypeSet)newValue);
        return;
      case ErrorModelPackage.TYPE_TRANSFORMATION__ALL_SOURCES:
        setAllSources((Boolean)newValue);
        return;
      case ErrorModelPackage.TYPE_TRANSFORMATION__CONTRIBUTOR:
        setContributor((TypeSet)newValue);
        return;
      case ErrorModelPackage.TYPE_TRANSFORMATION__TARGET:
        setTarget((TypeSet)newValue);
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
      case ErrorModelPackage.TYPE_TRANSFORMATION__SOURCE:
        setSource((TypeSet)null);
        return;
      case ErrorModelPackage.TYPE_TRANSFORMATION__ALL_SOURCES:
        setAllSources(ALL_SOURCES_EDEFAULT);
        return;
      case ErrorModelPackage.TYPE_TRANSFORMATION__CONTRIBUTOR:
        setContributor((TypeSet)null);
        return;
      case ErrorModelPackage.TYPE_TRANSFORMATION__TARGET:
        setTarget((TypeSet)null);
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
      case ErrorModelPackage.TYPE_TRANSFORMATION__SOURCE:
        return source != null;
      case ErrorModelPackage.TYPE_TRANSFORMATION__ALL_SOURCES:
        return allSources != ALL_SOURCES_EDEFAULT;
      case ErrorModelPackage.TYPE_TRANSFORMATION__CONTRIBUTOR:
        return contributor != null;
      case ErrorModelPackage.TYPE_TRANSFORMATION__TARGET:
        return target != null;
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
    result.append(" (allSources: ");
    result.append(allSources);
    result.append(')');
    return result.toString();
  }

} //TypeTransformationImpl
