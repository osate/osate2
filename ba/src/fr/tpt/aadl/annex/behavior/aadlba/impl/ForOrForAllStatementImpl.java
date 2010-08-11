/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions;
import fr.tpt.aadl.annex.behavior.aadlba.CondStatement;
import fr.tpt.aadl.annex.behavior.aadlba.ElementValues;
import fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;
import fr.tpt.aadl.annex.behavior.aadlba.LoopStatement;
import fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Or For All Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl#getDataUniqueCmtClassRef <em>Data Unique Cmt Class Ref</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl#getElementValuesOwned <em>Element Values Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl#isForAll <em>For All</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForOrForAllStatementImpl extends NamedElementImpl implements ForOrForAllStatement
{
   /**
	 * The cached value of the '{@link #getBehaviorActionsOwned() <em>Behavior Actions Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getBehaviorActionsOwned()
	 * @generated
	 * @ordered
	 */
   protected BehaviorActions behaviorActionsOwned;

   /**
	 * This is true if the Behavior Actions Owned containment reference has been set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
   protected boolean behaviorActionsOwnedESet;

			/**
	 * The cached value of the '{@link #getDataUniqueCmtClassRef() <em>Data Unique Cmt Class Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getDataUniqueCmtClassRef()
	 * @generated
	 * @ordered
	 */
   protected UniqueComponentClassifierReference dataUniqueCmtClassRef;

			/**
	 * The cached value of the '{@link #getElementValuesOwned() <em>Element Values Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getElementValuesOwned()
	 * @generated
	 * @ordered
	 */
   protected ElementValues elementValuesOwned;

   /**
	 * The default value of the '{@link #isForAll() <em>For All</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isForAll()
	 * @generated
	 * @ordered
	 */
   protected static final boolean FOR_ALL_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isForAll() <em>For All</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isForAll()
	 * @generated
	 * @ordered
	 */
   protected boolean forAll = FOR_ALL_EDEFAULT;

   /**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected Identifier element;

			/**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected ForOrForAllStatementImpl()
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
		return AadlBaPackage.Literals.FOR_OR_FOR_ALL_STATEMENT;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public UniqueComponentClassifierReference getDataUniqueCmtClassRef()
   {
		return dataUniqueCmtClassRef;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetDataUniqueCmtClassRef(UniqueComponentClassifierReference newDataUniqueCmtClassRef, NotificationChain msgs)
   {
		UniqueComponentClassifierReference oldDataUniqueCmtClassRef = dataUniqueCmtClassRef;
		dataUniqueCmtClassRef = newDataUniqueCmtClassRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_CMT_CLASS_REF, oldDataUniqueCmtClassRef, newDataUniqueCmtClassRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setDataUniqueCmtClassRef(UniqueComponentClassifierReference newDataUniqueCmtClassRef)
   {
		if (newDataUniqueCmtClassRef != dataUniqueCmtClassRef) {
			NotificationChain msgs = null;
			if (dataUniqueCmtClassRef != null)
				msgs = ((InternalEObject)dataUniqueCmtClassRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_CMT_CLASS_REF, null, msgs);
			if (newDataUniqueCmtClassRef != null)
				msgs = ((InternalEObject)newDataUniqueCmtClassRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_CMT_CLASS_REF, null, msgs);
			msgs = basicSetDataUniqueCmtClassRef(newDataUniqueCmtClassRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_CMT_CLASS_REF, newDataUniqueCmtClassRef, newDataUniqueCmtClassRef));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ElementValues getElementValuesOwned()
   {
		return elementValuesOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetElementValuesOwned(ElementValues newElementValuesOwned, NotificationChain msgs)
   {
		ElementValues oldElementValuesOwned = elementValuesOwned;
		elementValuesOwned = newElementValuesOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED, oldElementValuesOwned, newElementValuesOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setElementValuesOwned(ElementValues newElementValuesOwned)
   {
		if (newElementValuesOwned != elementValuesOwned) {
			NotificationChain msgs = null;
			if (elementValuesOwned != null)
				msgs = ((InternalEObject)elementValuesOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED, null, msgs);
			if (newElementValuesOwned != null)
				msgs = ((InternalEObject)newElementValuesOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED, null, msgs);
			msgs = basicSetElementValuesOwned(newElementValuesOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED, newElementValuesOwned, newElementValuesOwned));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public BehaviorActions getBehaviorActionsOwned()
   {
		return behaviorActionsOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetBehaviorActionsOwned(BehaviorActions newBehaviorActionsOwned, NotificationChain msgs)
   {
		BehaviorActions oldBehaviorActionsOwned = behaviorActionsOwned;
		behaviorActionsOwned = newBehaviorActionsOwned;
		boolean oldBehaviorActionsOwnedESet = behaviorActionsOwnedESet;
		behaviorActionsOwnedESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED, oldBehaviorActionsOwned, newBehaviorActionsOwned, !oldBehaviorActionsOwnedESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setBehaviorActionsOwned(BehaviorActions newBehaviorActionsOwned)
   {
		if (newBehaviorActionsOwned != behaviorActionsOwned) {
			NotificationChain msgs = null;
			if (behaviorActionsOwned != null)
				msgs = ((InternalEObject)behaviorActionsOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED, null, msgs);
			if (newBehaviorActionsOwned != null)
				msgs = ((InternalEObject)newBehaviorActionsOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED, null, msgs);
			msgs = basicSetBehaviorActionsOwned(newBehaviorActionsOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldBehaviorActionsOwnedESet = behaviorActionsOwnedESet;
			behaviorActionsOwnedESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED, newBehaviorActionsOwned, newBehaviorActionsOwned, !oldBehaviorActionsOwnedESet));
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicUnsetBehaviorActionsOwned(NotificationChain msgs)
   {
		BehaviorActions oldBehaviorActionsOwned = behaviorActionsOwned;
		behaviorActionsOwned = null;
		boolean oldBehaviorActionsOwnedESet = behaviorActionsOwnedESet;
		behaviorActionsOwnedESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED, oldBehaviorActionsOwned, null, oldBehaviorActionsOwnedESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetBehaviorActionsOwned()
   {
		if (behaviorActionsOwned != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)behaviorActionsOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED, null, msgs);
			msgs = basicUnsetBehaviorActionsOwned(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldBehaviorActionsOwnedESet = behaviorActionsOwnedESet;
			behaviorActionsOwnedESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED, null, null, oldBehaviorActionsOwnedESet));
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetBehaviorActionsOwned()
   {
		return behaviorActionsOwnedESet;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isForAll()
   {
		return forAll;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setForAll(boolean newForAll)
   {
		boolean oldForAll = forAll;
		forAll = newForAll;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__FOR_ALL, oldForAll, forAll));
	}

   /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getElement() {
		return element;
	}

			/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElement(Identifier newElement, NotificationChain msgs) {
		Identifier oldElement = element;
		element = newElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT, oldElement, newElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

			/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(Identifier newElement) {
		if (newElement != element) {
			NotificationChain msgs = null;
			if (element != null)
				msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT, null, msgs);
			if (newElement != null)
				msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT, null, msgs);
			msgs = basicSetElement(newElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT, newElement, newElement));
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
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				return basicUnsetBehaviorActionsOwned(msgs);
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_CMT_CLASS_REF:
				return basicSetDataUniqueCmtClassRef(null, msgs);
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED:
				return basicSetElementValuesOwned(null, msgs);
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT:
				return basicSetElement(null, msgs);
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
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				return getBehaviorActionsOwned();
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_CMT_CLASS_REF:
				return getDataUniqueCmtClassRef();
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED:
				return getElementValuesOwned();
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__FOR_ALL:
				return isForAll();
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT:
				return getElement();
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
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				setBehaviorActionsOwned((BehaviorActions)newValue);
				return;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_CMT_CLASS_REF:
				setDataUniqueCmtClassRef((UniqueComponentClassifierReference)newValue);
				return;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED:
				setElementValuesOwned((ElementValues)newValue);
				return;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__FOR_ALL:
				setForAll((Boolean)newValue);
				return;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT:
				setElement((Identifier)newValue);
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
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				unsetBehaviorActionsOwned();
				return;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_CMT_CLASS_REF:
				setDataUniqueCmtClassRef((UniqueComponentClassifierReference)null);
				return;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED:
				setElementValuesOwned((ElementValues)null);
				return;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__FOR_ALL:
				setForAll(FOR_ALL_EDEFAULT);
				return;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT:
				setElement((Identifier)null);
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
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				return isSetBehaviorActionsOwned();
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__DATA_UNIQUE_CMT_CLASS_REF:
				return dataUniqueCmtClassRef != null;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT_VALUES_OWNED:
				return elementValuesOwned != null;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__FOR_ALL:
				return forAll != FOR_ALL_EDEFAULT;
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__ELEMENT:
				return element != null;
		}
		return super.eIsSet(featureID);
	}

   /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == CondStatement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == LoopStatement.class) {
			switch (derivedFeatureID) {
				case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED: return AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

			/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == CondStatement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == LoopStatement.class) {
			switch (baseFeatureID) {
				case AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED: return AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS_OWNED;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (ForAll: ");
		result.append(forAll);
		result.append(')');
		return result.toString();
	}

} //ForOrForAllStatementImpl
