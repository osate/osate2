/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.NamedElement;

import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.Rationale;
import org.osate.alisa.common.common.Uncertainty;
import org.osate.alisa.common.common.ValDeclaration;

import org.osate.categories.categories.Category;

import org.osate.reqspec.reqSpec.ContractualElement;
import org.osate.reqspec.reqSpec.ExternalDocument;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.WhenCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contractual Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#getTargetDescription <em>Target Description</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#getTargetElement <em>Target Element</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#getWhencondition <em>Whencondition</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#getRationale <em>Rationale</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#getChangeUncertainty <em>Change Uncertainty</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#getEvolvesReference <em>Evolves Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#isDropped <em>Dropped</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#getDropRationale <em>Drop Rationale</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#getDocReference <em>Doc Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#getIssues <em>Issues</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl#getGoalReference <em>Goal Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContractualElementImpl extends MinimalEObjectImpl.Container implements ContractualElement
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
   * The default value of the '{@link #getTargetDescription() <em>Target Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetDescription()
   * @generated
   * @ordered
   */
  protected static final String TARGET_DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTargetDescription() <em>Target Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetDescription()
   * @generated
   * @ordered
   */
  protected String targetDescription = TARGET_DESCRIPTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected ComponentClassifier target;

  /**
   * The cached value of the '{@link #getTargetElement() <em>Target Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetElement()
   * @generated
   * @ordered
   */
  protected NamedElement targetElement;

  /**
   * The cached value of the '{@link #getCategory() <em>Category</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected EList<Category> category;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected Description description;

  /**
   * The cached value of the '{@link #getConstants() <em>Constants</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstants()
   * @generated
   * @ordered
   */
  protected EList<ValDeclaration> constants;

  /**
   * The cached value of the '{@link #getWhencondition() <em>Whencondition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWhencondition()
   * @generated
   * @ordered
   */
  protected WhenCondition whencondition;

  /**
   * The cached value of the '{@link #getRationale() <em>Rationale</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRationale()
   * @generated
   * @ordered
   */
  protected Rationale rationale;

  /**
   * The cached value of the '{@link #getChangeUncertainty() <em>Change Uncertainty</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChangeUncertainty()
   * @generated
   * @ordered
   */
  protected Uncertainty changeUncertainty;

  /**
   * The cached value of the '{@link #getEvolvesReference() <em>Evolves Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvolvesReference()
   * @generated
   * @ordered
   */
  protected EList<Requirement> evolvesReference;

  /**
   * The default value of the '{@link #isDropped() <em>Dropped</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDropped()
   * @generated
   * @ordered
   */
  protected static final boolean DROPPED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDropped() <em>Dropped</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDropped()
   * @generated
   * @ordered
   */
  protected boolean dropped = DROPPED_EDEFAULT;

  /**
   * The default value of the '{@link #getDropRationale() <em>Drop Rationale</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDropRationale()
   * @generated
   * @ordered
   */
  protected static final String DROP_RATIONALE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDropRationale() <em>Drop Rationale</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDropRationale()
   * @generated
   * @ordered
   */
  protected String dropRationale = DROP_RATIONALE_EDEFAULT;

  /**
   * The cached value of the '{@link #getDocReference() <em>Doc Reference</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocReference()
   * @generated
   * @ordered
   */
  protected EList<ExternalDocument> docReference;

  /**
   * The cached value of the '{@link #getIssues() <em>Issues</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIssues()
   * @generated
   * @ordered
   */
  protected EList<String> issues;

  /**
   * The cached value of the '{@link #getGoalReference() <em>Goal Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGoalReference()
   * @generated
   * @ordered
   */
  protected EList<Goal> goalReference;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContractualElementImpl()
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
    return ReqSpecPackage.Literals.CONTRACTUAL_ELEMENT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.CONTRACTUAL_ELEMENT__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.CONTRACTUAL_ELEMENT__TITLE, oldTitle, title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTargetDescription()
  {
    return targetDescription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetDescription(String newTargetDescription)
  {
    String oldTargetDescription = targetDescription;
    targetDescription = newTargetDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET_DESCRIPTION, oldTargetDescription, targetDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentClassifier getTarget()
  {
    if (target != null && ((EObject)target).eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (ComponentClassifier)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentClassifier basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(ComponentClassifier newTarget)
  {
    ComponentClassifier oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement getTargetElement()
  {
    if (targetElement != null && ((EObject)targetElement).eIsProxy())
    {
      InternalEObject oldTargetElement = (InternalEObject)targetElement;
      targetElement = (NamedElement)eResolveProxy(oldTargetElement);
      if (targetElement != oldTargetElement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET_ELEMENT, oldTargetElement, targetElement));
      }
    }
    return targetElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement basicGetTargetElement()
  {
    return targetElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetElement(NamedElement newTargetElement)
  {
    NamedElement oldTargetElement = targetElement;
    targetElement = newTargetElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET_ELEMENT, oldTargetElement, targetElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Category> getCategory()
  {
    if (category == null)
    {
      category = new EObjectResolvingEList<Category>(Category.class, this, ReqSpecPackage.CONTRACTUAL_ELEMENT__CATEGORY);
    }
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Description getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDescription(Description newDescription, NotificationChain msgs)
  {
    Description oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.CONTRACTUAL_ELEMENT__DESCRIPTION, oldDescription, newDescription);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(Description newDescription)
  {
    if (newDescription != description)
    {
      NotificationChain msgs = null;
      if (description != null)
        msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.CONTRACTUAL_ELEMENT__DESCRIPTION, null, msgs);
      if (newDescription != null)
        msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.CONTRACTUAL_ELEMENT__DESCRIPTION, null, msgs);
      msgs = basicSetDescription(newDescription, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.CONTRACTUAL_ELEMENT__DESCRIPTION, newDescription, newDescription));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ValDeclaration> getConstants()
  {
    if (constants == null)
    {
      constants = new EObjectContainmentEList<ValDeclaration>(ValDeclaration.class, this, ReqSpecPackage.CONTRACTUAL_ELEMENT__CONSTANTS);
    }
    return constants;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhenCondition getWhencondition()
  {
    return whencondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetWhencondition(WhenCondition newWhencondition, NotificationChain msgs)
  {
    WhenCondition oldWhencondition = whencondition;
    whencondition = newWhencondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.CONTRACTUAL_ELEMENT__WHENCONDITION, oldWhencondition, newWhencondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWhencondition(WhenCondition newWhencondition)
  {
    if (newWhencondition != whencondition)
    {
      NotificationChain msgs = null;
      if (whencondition != null)
        msgs = ((InternalEObject)whencondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.CONTRACTUAL_ELEMENT__WHENCONDITION, null, msgs);
      if (newWhencondition != null)
        msgs = ((InternalEObject)newWhencondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.CONTRACTUAL_ELEMENT__WHENCONDITION, null, msgs);
      msgs = basicSetWhencondition(newWhencondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.CONTRACTUAL_ELEMENT__WHENCONDITION, newWhencondition, newWhencondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rationale getRationale()
  {
    return rationale;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRationale(Rationale newRationale, NotificationChain msgs)
  {
    Rationale oldRationale = rationale;
    rationale = newRationale;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.CONTRACTUAL_ELEMENT__RATIONALE, oldRationale, newRationale);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRationale(Rationale newRationale)
  {
    if (newRationale != rationale)
    {
      NotificationChain msgs = null;
      if (rationale != null)
        msgs = ((InternalEObject)rationale).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.CONTRACTUAL_ELEMENT__RATIONALE, null, msgs);
      if (newRationale != null)
        msgs = ((InternalEObject)newRationale).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.CONTRACTUAL_ELEMENT__RATIONALE, null, msgs);
      msgs = basicSetRationale(newRationale, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.CONTRACTUAL_ELEMENT__RATIONALE, newRationale, newRationale));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Uncertainty getChangeUncertainty()
  {
    return changeUncertainty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChangeUncertainty(Uncertainty newChangeUncertainty, NotificationChain msgs)
  {
    Uncertainty oldChangeUncertainty = changeUncertainty;
    changeUncertainty = newChangeUncertainty;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReqSpecPackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY, oldChangeUncertainty, newChangeUncertainty);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChangeUncertainty(Uncertainty newChangeUncertainty)
  {
    if (newChangeUncertainty != changeUncertainty)
    {
      NotificationChain msgs = null;
      if (changeUncertainty != null)
        msgs = ((InternalEObject)changeUncertainty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY, null, msgs);
      if (newChangeUncertainty != null)
        msgs = ((InternalEObject)newChangeUncertainty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReqSpecPackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY, null, msgs);
      msgs = basicSetChangeUncertainty(newChangeUncertainty, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY, newChangeUncertainty, newChangeUncertainty));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Requirement> getEvolvesReference()
  {
    if (evolvesReference == null)
    {
      evolvesReference = new EObjectResolvingEList<Requirement>(Requirement.class, this, ReqSpecPackage.CONTRACTUAL_ELEMENT__EVOLVES_REFERENCE);
    }
    return evolvesReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDropped()
  {
    return dropped;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDropped(boolean newDropped)
  {
    boolean oldDropped = dropped;
    dropped = newDropped;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.CONTRACTUAL_ELEMENT__DROPPED, oldDropped, dropped));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDropRationale()
  {
    return dropRationale;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDropRationale(String newDropRationale)
  {
    String oldDropRationale = dropRationale;
    dropRationale = newDropRationale;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.CONTRACTUAL_ELEMENT__DROP_RATIONALE, oldDropRationale, dropRationale));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExternalDocument> getDocReference()
  {
    if (docReference == null)
    {
      docReference = new EObjectContainmentEList<ExternalDocument>(ExternalDocument.class, this, ReqSpecPackage.CONTRACTUAL_ELEMENT__DOC_REFERENCE);
    }
    return docReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getIssues()
  {
    if (issues == null)
    {
      issues = new EDataTypeEList<String>(String.class, this, ReqSpecPackage.CONTRACTUAL_ELEMENT__ISSUES);
    }
    return issues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Goal> getGoalReference()
  {
    if (goalReference == null)
    {
      goalReference = new EObjectResolvingEList<Goal>(Goal.class, this, ReqSpecPackage.CONTRACTUAL_ELEMENT__GOAL_REFERENCE);
    }
    return goalReference;
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
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DESCRIPTION:
        return basicSetDescription(null, msgs);
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__CONSTANTS:
        return ((InternalEList<?>)getConstants()).basicRemove(otherEnd, msgs);
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__WHENCONDITION:
        return basicSetWhencondition(null, msgs);
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__RATIONALE:
        return basicSetRationale(null, msgs);
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY:
        return basicSetChangeUncertainty(null, msgs);
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DOC_REFERENCE:
        return ((InternalEList<?>)getDocReference()).basicRemove(otherEnd, msgs);
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
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__NAME:
        return getName();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__TITLE:
        return getTitle();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET_DESCRIPTION:
        return getTargetDescription();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET_ELEMENT:
        if (resolve) return getTargetElement();
        return basicGetTargetElement();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__CATEGORY:
        return getCategory();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DESCRIPTION:
        return getDescription();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__CONSTANTS:
        return getConstants();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__WHENCONDITION:
        return getWhencondition();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__RATIONALE:
        return getRationale();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY:
        return getChangeUncertainty();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__EVOLVES_REFERENCE:
        return getEvolvesReference();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DROPPED:
        return isDropped();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DROP_RATIONALE:
        return getDropRationale();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DOC_REFERENCE:
        return getDocReference();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__ISSUES:
        return getIssues();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__GOAL_REFERENCE:
        return getGoalReference();
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
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__NAME:
        setName((String)newValue);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__TITLE:
        setTitle((String)newValue);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET_DESCRIPTION:
        setTargetDescription((String)newValue);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET:
        setTarget((ComponentClassifier)newValue);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET_ELEMENT:
        setTargetElement((NamedElement)newValue);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__CATEGORY:
        getCategory().clear();
        getCategory().addAll((Collection<? extends Category>)newValue);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DESCRIPTION:
        setDescription((Description)newValue);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__CONSTANTS:
        getConstants().clear();
        getConstants().addAll((Collection<? extends ValDeclaration>)newValue);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__WHENCONDITION:
        setWhencondition((WhenCondition)newValue);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__RATIONALE:
        setRationale((Rationale)newValue);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY:
        setChangeUncertainty((Uncertainty)newValue);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__EVOLVES_REFERENCE:
        getEvolvesReference().clear();
        getEvolvesReference().addAll((Collection<? extends Requirement>)newValue);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DROPPED:
        setDropped((Boolean)newValue);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DROP_RATIONALE:
        setDropRationale((String)newValue);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DOC_REFERENCE:
        getDocReference().clear();
        getDocReference().addAll((Collection<? extends ExternalDocument>)newValue);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__ISSUES:
        getIssues().clear();
        getIssues().addAll((Collection<? extends String>)newValue);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__GOAL_REFERENCE:
        getGoalReference().clear();
        getGoalReference().addAll((Collection<? extends Goal>)newValue);
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
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET_DESCRIPTION:
        setTargetDescription(TARGET_DESCRIPTION_EDEFAULT);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET:
        setTarget((ComponentClassifier)null);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET_ELEMENT:
        setTargetElement((NamedElement)null);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__CATEGORY:
        getCategory().clear();
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DESCRIPTION:
        setDescription((Description)null);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__CONSTANTS:
        getConstants().clear();
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__WHENCONDITION:
        setWhencondition((WhenCondition)null);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__RATIONALE:
        setRationale((Rationale)null);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY:
        setChangeUncertainty((Uncertainty)null);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__EVOLVES_REFERENCE:
        getEvolvesReference().clear();
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DROPPED:
        setDropped(DROPPED_EDEFAULT);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DROP_RATIONALE:
        setDropRationale(DROP_RATIONALE_EDEFAULT);
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DOC_REFERENCE:
        getDocReference().clear();
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__ISSUES:
        getIssues().clear();
        return;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__GOAL_REFERENCE:
        getGoalReference().clear();
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
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET_DESCRIPTION:
        return TARGET_DESCRIPTION_EDEFAULT == null ? targetDescription != null : !TARGET_DESCRIPTION_EDEFAULT.equals(targetDescription);
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET:
        return target != null;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__TARGET_ELEMENT:
        return targetElement != null;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__CATEGORY:
        return category != null && !category.isEmpty();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DESCRIPTION:
        return description != null;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__CONSTANTS:
        return constants != null && !constants.isEmpty();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__WHENCONDITION:
        return whencondition != null;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__RATIONALE:
        return rationale != null;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY:
        return changeUncertainty != null;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__EVOLVES_REFERENCE:
        return evolvesReference != null && !evolvesReference.isEmpty();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DROPPED:
        return dropped != DROPPED_EDEFAULT;
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DROP_RATIONALE:
        return DROP_RATIONALE_EDEFAULT == null ? dropRationale != null : !DROP_RATIONALE_EDEFAULT.equals(dropRationale);
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__DOC_REFERENCE:
        return docReference != null && !docReference.isEmpty();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__ISSUES:
        return issues != null && !issues.isEmpty();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT__GOAL_REFERENCE:
        return goalReference != null && !goalReference.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(", title: ");
    result.append(title);
    result.append(", targetDescription: ");
    result.append(targetDescription);
    result.append(", dropped: ");
    result.append(dropped);
    result.append(", dropRationale: ");
    result.append(dropRationale);
    result.append(", issues: ");
    result.append(issues);
    result.append(')');
    return result.toString();
  }

} //ContractualElementImpl
