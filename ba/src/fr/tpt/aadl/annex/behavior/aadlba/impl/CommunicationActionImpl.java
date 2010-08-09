/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.CommActionParameter;
import fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction;
import fr.tpt.aadl.annex.behavior.aadlba.Name;
import fr.tpt.aadl.annex.behavior.aadlba.SubprogramParameterList;
import fr.tpt.aadl.annex.behavior.aadlba.Target;
import fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Communication Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CommunicationActionImpl#getActionType <em>Action Type</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CommunicationActionImpl#getEltNameOwned <em>Elt Name Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CommunicationActionImpl#getSubpgmParamListOwned <em>Subpgm Param List Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CommunicationActionImpl#isHasValueExpression <em>Has Value Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CommunicationActionImpl#isHasTarget <em>Has Target</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CommunicationActionImpl#getValueExprOwned <em>Value Expr Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CommunicationActionImpl#getTarOwned <em>Tar Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CommunicationActionImpl#getDataUniqueComponentClassifierReference <em>Data Unique Component Classifier Reference</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CommunicationActionImpl#isCatchTimeout <em>Catch Timeout</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CommunicationActionImpl#isAll <em>All</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommunicationActionImpl extends BasicActionImpl implements CommunicationAction
{
   /**
	 * The default value of the '{@link #getActionType() <em>Action Type</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getActionType()
	 * @generated
	 * @ordered
	 */
   protected static final CommActionParameter ACTION_TYPE_EDEFAULT = CommActionParameter.NONE;

   /**
	 * The cached value of the '{@link #getActionType() <em>Action Type</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getActionType()
	 * @generated
	 * @ordered
	 */
   protected CommActionParameter actionType = ACTION_TYPE_EDEFAULT;

   /**
	 * The cached value of the '{@link #getEltNameOwned() <em>Elt Name Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getEltNameOwned()
	 * @generated
	 * @ordered
	 */
   protected Name eltNameOwned;

   /**
	 * The cached value of the '{@link #getSubpgmParamListOwned() <em>Subpgm Param List Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getSubpgmParamListOwned()
	 * @generated
	 * @ordered
	 */
   protected SubprogramParameterList subpgmParamListOwned;

   /**
	 * This is true if the Subpgm Param List Owned containment reference has been set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
   protected boolean subpgmParamListOwnedESet;

   /**
	 * The default value of the '{@link #isHasValueExpression() <em>Has Value Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isHasValueExpression()
	 * @generated
	 * @ordered
	 */
   protected static final boolean HAS_VALUE_EXPRESSION_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isHasValueExpression() <em>Has Value Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isHasValueExpression()
	 * @generated
	 * @ordered
	 */
   protected boolean hasValueExpression = HAS_VALUE_EXPRESSION_EDEFAULT;

   /**
	 * The default value of the '{@link #isHasTarget() <em>Has Target</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isHasTarget()
	 * @generated
	 * @ordered
	 */
   protected static final boolean HAS_TARGET_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isHasTarget() <em>Has Target</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isHasTarget()
	 * @generated
	 * @ordered
	 */
   protected boolean hasTarget = HAS_TARGET_EDEFAULT;

   /**
	 * The cached value of the '{@link #getValueExprOwned() <em>Value Expr Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getValueExprOwned()
	 * @generated
	 * @ordered
	 */
   protected ValueExpression valueExprOwned;

   /**
	 * The cached value of the '{@link #getTarOwned() <em>Tar Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getTarOwned()
	 * @generated
	 * @ordered
	 */
   protected Target tarOwned;

   /**
	 * The cached value of the '{@link #getDataUniqueComponentClassifierReference() <em>Data Unique Component Classifier Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getDataUniqueComponentClassifierReference()
	 * @generated
	 * @ordered
	 */
   protected UniqueComponentClassifierReference dataUniqueComponentClassifierReference;

   /**
	 * This is true if the Data Unique Component Classifier Reference containment reference has been set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
   protected boolean dataUniqueComponentClassifierReferenceESet;

   /**
	 * The default value of the '{@link #isCatchTimeout() <em>Catch Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isCatchTimeout()
	 * @generated
	 * @ordered
	 */
   protected static final boolean CATCH_TIMEOUT_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isCatchTimeout() <em>Catch Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isCatchTimeout()
	 * @generated
	 * @ordered
	 */
   protected boolean catchTimeout = CATCH_TIMEOUT_EDEFAULT;

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
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected CommunicationActionImpl()
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
		return AadlBaPackage.Literals.COMMUNICATION_ACTION;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public CommActionParameter getActionType()
   {
		return actionType;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setActionType(CommActionParameter newActionType)
   {
		CommActionParameter oldActionType = actionType;
		actionType = newActionType == null ? ACTION_TYPE_EDEFAULT : newActionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMMUNICATION_ACTION__ACTION_TYPE, oldActionType, actionType));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Name getEltNameOwned()
   {
		return eltNameOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetEltNameOwned(Name newEltNameOwned, NotificationChain msgs)
   {
		Name oldEltNameOwned = eltNameOwned;
		eltNameOwned = newEltNameOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMMUNICATION_ACTION__ELT_NAME_OWNED, oldEltNameOwned, newEltNameOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setEltNameOwned(Name newEltNameOwned)
   {
		if (newEltNameOwned != eltNameOwned) {
			NotificationChain msgs = null;
			if (eltNameOwned != null)
				msgs = ((InternalEObject)eltNameOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMMUNICATION_ACTION__ELT_NAME_OWNED, null, msgs);
			if (newEltNameOwned != null)
				msgs = ((InternalEObject)newEltNameOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMMUNICATION_ACTION__ELT_NAME_OWNED, null, msgs);
			msgs = basicSetEltNameOwned(newEltNameOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMMUNICATION_ACTION__ELT_NAME_OWNED, newEltNameOwned, newEltNameOwned));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public SubprogramParameterList getSubpgmParamListOwned()
   {
		return subpgmParamListOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetSubpgmParamListOwned(SubprogramParameterList newSubpgmParamListOwned, NotificationChain msgs)
   {
		SubprogramParameterList oldSubpgmParamListOwned = subpgmParamListOwned;
		subpgmParamListOwned = newSubpgmParamListOwned;
		boolean oldSubpgmParamListOwnedESet = subpgmParamListOwnedESet;
		subpgmParamListOwnedESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMMUNICATION_ACTION__SUBPGM_PARAM_LIST_OWNED, oldSubpgmParamListOwned, newSubpgmParamListOwned, !oldSubpgmParamListOwnedESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setSubpgmParamListOwned(SubprogramParameterList newSubpgmParamListOwned)
   {
		if (newSubpgmParamListOwned != subpgmParamListOwned) {
			NotificationChain msgs = null;
			if (subpgmParamListOwned != null)
				msgs = ((InternalEObject)subpgmParamListOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMMUNICATION_ACTION__SUBPGM_PARAM_LIST_OWNED, null, msgs);
			if (newSubpgmParamListOwned != null)
				msgs = ((InternalEObject)newSubpgmParamListOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMMUNICATION_ACTION__SUBPGM_PARAM_LIST_OWNED, null, msgs);
			msgs = basicSetSubpgmParamListOwned(newSubpgmParamListOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSubpgmParamListOwnedESet = subpgmParamListOwnedESet;
			subpgmParamListOwnedESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMMUNICATION_ACTION__SUBPGM_PARAM_LIST_OWNED, newSubpgmParamListOwned, newSubpgmParamListOwned, !oldSubpgmParamListOwnedESet));
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicUnsetSubpgmParamListOwned(NotificationChain msgs)
   {
		SubprogramParameterList oldSubpgmParamListOwned = subpgmParamListOwned;
		subpgmParamListOwned = null;
		boolean oldSubpgmParamListOwnedESet = subpgmParamListOwnedESet;
		subpgmParamListOwnedESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.COMMUNICATION_ACTION__SUBPGM_PARAM_LIST_OWNED, oldSubpgmParamListOwned, null, oldSubpgmParamListOwnedESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetSubpgmParamListOwned()
   {
		if (subpgmParamListOwned != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)subpgmParamListOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMMUNICATION_ACTION__SUBPGM_PARAM_LIST_OWNED, null, msgs);
			msgs = basicUnsetSubpgmParamListOwned(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSubpgmParamListOwnedESet = subpgmParamListOwnedESet;
			subpgmParamListOwnedESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.COMMUNICATION_ACTION__SUBPGM_PARAM_LIST_OWNED, null, null, oldSubpgmParamListOwnedESet));
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetSubpgmParamListOwned()
   {
		return subpgmParamListOwnedESet;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isHasValueExpression()
   {
		return hasValueExpression;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setHasValueExpression(boolean newHasValueExpression)
   {
		boolean oldHasValueExpression = hasValueExpression;
		hasValueExpression = newHasValueExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMMUNICATION_ACTION__HAS_VALUE_EXPRESSION, oldHasValueExpression, hasValueExpression));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isHasTarget()
   {
		return hasTarget;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setHasTarget(boolean newHasTarget)
   {
		boolean oldHasTarget = hasTarget;
		hasTarget = newHasTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMMUNICATION_ACTION__HAS_TARGET, oldHasTarget, hasTarget));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ValueExpression getValueExprOwned()
   {
		return valueExprOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetValueExprOwned(ValueExpression newValueExprOwned, NotificationChain msgs)
   {
		ValueExpression oldValueExprOwned = valueExprOwned;
		valueExprOwned = newValueExprOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMMUNICATION_ACTION__VALUE_EXPR_OWNED, oldValueExprOwned, newValueExprOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setValueExprOwned(ValueExpression newValueExprOwned)
   {
		if (newValueExprOwned != valueExprOwned) {
			NotificationChain msgs = null;
			if (valueExprOwned != null)
				msgs = ((InternalEObject)valueExprOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMMUNICATION_ACTION__VALUE_EXPR_OWNED, null, msgs);
			if (newValueExprOwned != null)
				msgs = ((InternalEObject)newValueExprOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMMUNICATION_ACTION__VALUE_EXPR_OWNED, null, msgs);
			msgs = basicSetValueExprOwned(newValueExprOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMMUNICATION_ACTION__VALUE_EXPR_OWNED, newValueExprOwned, newValueExprOwned));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Target getTarOwned()
   {
		return tarOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetTarOwned(Target newTarOwned, NotificationChain msgs)
   {
		Target oldTarOwned = tarOwned;
		tarOwned = newTarOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMMUNICATION_ACTION__TAR_OWNED, oldTarOwned, newTarOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setTarOwned(Target newTarOwned)
   {
		if (newTarOwned != tarOwned) {
			NotificationChain msgs = null;
			if (tarOwned != null)
				msgs = ((InternalEObject)tarOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMMUNICATION_ACTION__TAR_OWNED, null, msgs);
			if (newTarOwned != null)
				msgs = ((InternalEObject)newTarOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMMUNICATION_ACTION__TAR_OWNED, null, msgs);
			msgs = basicSetTarOwned(newTarOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMMUNICATION_ACTION__TAR_OWNED, newTarOwned, newTarOwned));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public UniqueComponentClassifierReference getDataUniqueComponentClassifierReference()
   {
		return dataUniqueComponentClassifierReference;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetDataUniqueComponentClassifierReference(UniqueComponentClassifierReference newDataUniqueComponentClassifierReference, NotificationChain msgs)
   {
		UniqueComponentClassifierReference oldDataUniqueComponentClassifierReference = dataUniqueComponentClassifierReference;
		dataUniqueComponentClassifierReference = newDataUniqueComponentClassifierReference;
		boolean oldDataUniqueComponentClassifierReferenceESet = dataUniqueComponentClassifierReferenceESet;
		dataUniqueComponentClassifierReferenceESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMMUNICATION_ACTION__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE, oldDataUniqueComponentClassifierReference, newDataUniqueComponentClassifierReference, !oldDataUniqueComponentClassifierReferenceESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setDataUniqueComponentClassifierReference(UniqueComponentClassifierReference newDataUniqueComponentClassifierReference)
   {
		if (newDataUniqueComponentClassifierReference != dataUniqueComponentClassifierReference) {
			NotificationChain msgs = null;
			if (dataUniqueComponentClassifierReference != null)
				msgs = ((InternalEObject)dataUniqueComponentClassifierReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMMUNICATION_ACTION__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE, null, msgs);
			if (newDataUniqueComponentClassifierReference != null)
				msgs = ((InternalEObject)newDataUniqueComponentClassifierReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMMUNICATION_ACTION__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE, null, msgs);
			msgs = basicSetDataUniqueComponentClassifierReference(newDataUniqueComponentClassifierReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldDataUniqueComponentClassifierReferenceESet = dataUniqueComponentClassifierReferenceESet;
			dataUniqueComponentClassifierReferenceESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMMUNICATION_ACTION__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE, newDataUniqueComponentClassifierReference, newDataUniqueComponentClassifierReference, !oldDataUniqueComponentClassifierReferenceESet));
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicUnsetDataUniqueComponentClassifierReference(NotificationChain msgs)
   {
		UniqueComponentClassifierReference oldDataUniqueComponentClassifierReference = dataUniqueComponentClassifierReference;
		dataUniqueComponentClassifierReference = null;
		boolean oldDataUniqueComponentClassifierReferenceESet = dataUniqueComponentClassifierReferenceESet;
		dataUniqueComponentClassifierReferenceESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.COMMUNICATION_ACTION__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE, oldDataUniqueComponentClassifierReference, null, oldDataUniqueComponentClassifierReferenceESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetDataUniqueComponentClassifierReference()
   {
		if (dataUniqueComponentClassifierReference != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)dataUniqueComponentClassifierReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMMUNICATION_ACTION__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE, null, msgs);
			msgs = basicUnsetDataUniqueComponentClassifierReference(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldDataUniqueComponentClassifierReferenceESet = dataUniqueComponentClassifierReferenceESet;
			dataUniqueComponentClassifierReferenceESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.COMMUNICATION_ACTION__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE, null, null, oldDataUniqueComponentClassifierReferenceESet));
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetDataUniqueComponentClassifierReference()
   {
		return dataUniqueComponentClassifierReferenceESet;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isCatchTimeout()
   {
		return catchTimeout;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setCatchTimeout(boolean newCatchTimeout)
   {
		boolean oldCatchTimeout = catchTimeout;
		catchTimeout = newCatchTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMMUNICATION_ACTION__CATCH_TIMEOUT, oldCatchTimeout, catchTimeout));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMMUNICATION_ACTION__ALL, oldAll, all));
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
			case AadlBaPackage.COMMUNICATION_ACTION__ELT_NAME_OWNED:
				return basicSetEltNameOwned(null, msgs);
			case AadlBaPackage.COMMUNICATION_ACTION__SUBPGM_PARAM_LIST_OWNED:
				return basicUnsetSubpgmParamListOwned(msgs);
			case AadlBaPackage.COMMUNICATION_ACTION__VALUE_EXPR_OWNED:
				return basicSetValueExprOwned(null, msgs);
			case AadlBaPackage.COMMUNICATION_ACTION__TAR_OWNED:
				return basicSetTarOwned(null, msgs);
			case AadlBaPackage.COMMUNICATION_ACTION__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE:
				return basicUnsetDataUniqueComponentClassifierReference(msgs);
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
			case AadlBaPackage.COMMUNICATION_ACTION__ACTION_TYPE:
				return getActionType();
			case AadlBaPackage.COMMUNICATION_ACTION__ELT_NAME_OWNED:
				return getEltNameOwned();
			case AadlBaPackage.COMMUNICATION_ACTION__SUBPGM_PARAM_LIST_OWNED:
				return getSubpgmParamListOwned();
			case AadlBaPackage.COMMUNICATION_ACTION__HAS_VALUE_EXPRESSION:
				return isHasValueExpression();
			case AadlBaPackage.COMMUNICATION_ACTION__HAS_TARGET:
				return isHasTarget();
			case AadlBaPackage.COMMUNICATION_ACTION__VALUE_EXPR_OWNED:
				return getValueExprOwned();
			case AadlBaPackage.COMMUNICATION_ACTION__TAR_OWNED:
				return getTarOwned();
			case AadlBaPackage.COMMUNICATION_ACTION__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE:
				return getDataUniqueComponentClassifierReference();
			case AadlBaPackage.COMMUNICATION_ACTION__CATCH_TIMEOUT:
				return isCatchTimeout();
			case AadlBaPackage.COMMUNICATION_ACTION__ALL:
				return isAll();
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
			case AadlBaPackage.COMMUNICATION_ACTION__ACTION_TYPE:
				setActionType((CommActionParameter)newValue);
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__ELT_NAME_OWNED:
				setEltNameOwned((Name)newValue);
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__SUBPGM_PARAM_LIST_OWNED:
				setSubpgmParamListOwned((SubprogramParameterList)newValue);
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__HAS_VALUE_EXPRESSION:
				setHasValueExpression((Boolean)newValue);
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__HAS_TARGET:
				setHasTarget((Boolean)newValue);
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__VALUE_EXPR_OWNED:
				setValueExprOwned((ValueExpression)newValue);
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__TAR_OWNED:
				setTarOwned((Target)newValue);
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE:
				setDataUniqueComponentClassifierReference((UniqueComponentClassifierReference)newValue);
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__CATCH_TIMEOUT:
				setCatchTimeout((Boolean)newValue);
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__ALL:
				setAll((Boolean)newValue);
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
			case AadlBaPackage.COMMUNICATION_ACTION__ACTION_TYPE:
				setActionType(ACTION_TYPE_EDEFAULT);
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__ELT_NAME_OWNED:
				setEltNameOwned((Name)null);
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__SUBPGM_PARAM_LIST_OWNED:
				unsetSubpgmParamListOwned();
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__HAS_VALUE_EXPRESSION:
				setHasValueExpression(HAS_VALUE_EXPRESSION_EDEFAULT);
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__HAS_TARGET:
				setHasTarget(HAS_TARGET_EDEFAULT);
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__VALUE_EXPR_OWNED:
				setValueExprOwned((ValueExpression)null);
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__TAR_OWNED:
				setTarOwned((Target)null);
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE:
				unsetDataUniqueComponentClassifierReference();
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__CATCH_TIMEOUT:
				setCatchTimeout(CATCH_TIMEOUT_EDEFAULT);
				return;
			case AadlBaPackage.COMMUNICATION_ACTION__ALL:
				setAll(ALL_EDEFAULT);
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
			case AadlBaPackage.COMMUNICATION_ACTION__ACTION_TYPE:
				return actionType != ACTION_TYPE_EDEFAULT;
			case AadlBaPackage.COMMUNICATION_ACTION__ELT_NAME_OWNED:
				return eltNameOwned != null;
			case AadlBaPackage.COMMUNICATION_ACTION__SUBPGM_PARAM_LIST_OWNED:
				return isSetSubpgmParamListOwned();
			case AadlBaPackage.COMMUNICATION_ACTION__HAS_VALUE_EXPRESSION:
				return hasValueExpression != HAS_VALUE_EXPRESSION_EDEFAULT;
			case AadlBaPackage.COMMUNICATION_ACTION__HAS_TARGET:
				return hasTarget != HAS_TARGET_EDEFAULT;
			case AadlBaPackage.COMMUNICATION_ACTION__VALUE_EXPR_OWNED:
				return valueExprOwned != null;
			case AadlBaPackage.COMMUNICATION_ACTION__TAR_OWNED:
				return tarOwned != null;
			case AadlBaPackage.COMMUNICATION_ACTION__DATA_UNIQUE_COMPONENT_CLASSIFIER_REFERENCE:
				return isSetDataUniqueComponentClassifierReference();
			case AadlBaPackage.COMMUNICATION_ACTION__CATCH_TIMEOUT:
				return catchTimeout != CATCH_TIMEOUT_EDEFAULT;
			case AadlBaPackage.COMMUNICATION_ACTION__ALL:
				return all != ALL_EDEFAULT;
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
		result.append(" (ActionType: ");
		result.append(actionType);
		result.append(", hasValueExpression: ");
		result.append(hasValueExpression);
		result.append(", hasTarget: ");
		result.append(hasTarget);
		result.append(", CatchTimeout: ");
		result.append(catchTimeout);
		result.append(", All: ");
		result.append(all);
		result.append(')');
		return result.toString();
	}

} //CommunicationActionImpl
