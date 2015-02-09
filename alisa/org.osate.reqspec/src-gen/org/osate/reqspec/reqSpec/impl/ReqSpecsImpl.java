/**
 */
package org.osate.reqspec.reqSpec.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.XExpression;

import org.osate.aadl2.Classifier;

import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.ReqSpecs;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Req Specs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqSpecsImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqSpecsImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqSpecsImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqSpecsImpl#getOtherreqspecs <em>Otherreqspecs</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqSpecsImpl#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ReqSpecsImpl#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReqSpecsImpl extends ReqSpecImpl implements ReqSpecs
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
   * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected static final String TITLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected String title = TITLE_EDEFAULT;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected Classifier target;

  /**
   * The cached value of the '{@link #getOtherreqspecs() <em>Otherreqspecs</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOtherreqspecs()
   * @generated
   * @ordered
   */
  protected EList<ReqSpecs> otherreqspecs;

  /**
   * The cached value of the '{@link #getConstants() <em>Constants</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstants()
   * @generated
   * @ordered
   */
  protected EList<XExpression> constants;

  /**
   * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContent()
   * @generated
   * @ordered
   */
  protected EList<EObject> content;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReqSpecsImpl()
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
    return ReqSpecPackage.Literals.REQ_SPECS;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQ_SPECS__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTitle()
  {
    return title;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTitle(String newTitle)
  {
    String oldTitle = title;
    title = newTitle;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQ_SPECS__TITLE, oldTitle, title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Classifier getTarget()
  {
    if (target != null && ((EObject)target).eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (Classifier)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.REQ_SPECS__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Classifier basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(Classifier newTarget)
  {
    Classifier oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.REQ_SPECS__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ReqSpecs> getOtherreqspecs()
  {
    if (otherreqspecs == null)
    {
      otherreqspecs = new EObjectResolvingEList<ReqSpecs>(ReqSpecs.class, this, ReqSpecPackage.REQ_SPECS__OTHERREQSPECS);
    }
    return otherreqspecs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<XExpression> getConstants()
  {
    if (constants == null)
    {
      constants = new EObjectContainmentEList<XExpression>(XExpression.class, this, ReqSpecPackage.REQ_SPECS__CONSTANTS);
    }
    return constants;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getContent()
  {
    if (content == null)
    {
      content = new EObjectContainmentEList<EObject>(EObject.class, this, ReqSpecPackage.REQ_SPECS__CONTENT);
    }
    return content;
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
      case ReqSpecPackage.REQ_SPECS__CONSTANTS:
        return ((InternalEList<?>)getConstants()).basicRemove(otherEnd, msgs);
      case ReqSpecPackage.REQ_SPECS__CONTENT:
        return ((InternalEList<?>)getContent()).basicRemove(otherEnd, msgs);
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
      case ReqSpecPackage.REQ_SPECS__NAME:
        return getName();
      case ReqSpecPackage.REQ_SPECS__TITLE:
        return getTitle();
      case ReqSpecPackage.REQ_SPECS__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case ReqSpecPackage.REQ_SPECS__OTHERREQSPECS:
        return getOtherreqspecs();
      case ReqSpecPackage.REQ_SPECS__CONSTANTS:
        return getConstants();
      case ReqSpecPackage.REQ_SPECS__CONTENT:
        return getContent();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ReqSpecPackage.REQ_SPECS__NAME:
        setName((String)newValue);
        return;
      case ReqSpecPackage.REQ_SPECS__TITLE:
        setTitle((String)newValue);
        return;
      case ReqSpecPackage.REQ_SPECS__TARGET:
        setTarget((Classifier)newValue);
        return;
      case ReqSpecPackage.REQ_SPECS__OTHERREQSPECS:
        getOtherreqspecs().clear();
        getOtherreqspecs().addAll((Collection<? extends ReqSpecs>)newValue);
        return;
      case ReqSpecPackage.REQ_SPECS__CONSTANTS:
        getConstants().clear();
        getConstants().addAll((Collection<? extends XExpression>)newValue);
        return;
      case ReqSpecPackage.REQ_SPECS__CONTENT:
        getContent().clear();
        getContent().addAll((Collection<? extends EObject>)newValue);
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
      case ReqSpecPackage.REQ_SPECS__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ReqSpecPackage.REQ_SPECS__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case ReqSpecPackage.REQ_SPECS__TARGET:
        setTarget((Classifier)null);
        return;
      case ReqSpecPackage.REQ_SPECS__OTHERREQSPECS:
        getOtherreqspecs().clear();
        return;
      case ReqSpecPackage.REQ_SPECS__CONSTANTS:
        getConstants().clear();
        return;
      case ReqSpecPackage.REQ_SPECS__CONTENT:
        getContent().clear();
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
      case ReqSpecPackage.REQ_SPECS__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ReqSpecPackage.REQ_SPECS__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case ReqSpecPackage.REQ_SPECS__TARGET:
        return target != null;
      case ReqSpecPackage.REQ_SPECS__OTHERREQSPECS:
        return otherreqspecs != null && !otherreqspecs.isEmpty();
      case ReqSpecPackage.REQ_SPECS__CONSTANTS:
        return constants != null && !constants.isEmpty();
      case ReqSpecPackage.REQ_SPECS__CONTENT:
        return content != null && !content.isEmpty();
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
    result.append(", title: ");
    result.append(title);
    result.append(')');
    return result.toString();
  }

} //ReqSpecsImpl
