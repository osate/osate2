/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.DirectionType;

import org.osate.aadl2.impl.NamedElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Propagation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl#getFeatureorPPRefs <em>Featureor PP Refs</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl#isNot <em>Not</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl#getTypeSet <em>Type Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorPropagationImpl extends NamedElementImpl implements ErrorPropagation
{
  /**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
  protected static final String KIND_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
  protected String kind = KIND_EDEFAULT;

  /**
	 * The cached value of the '{@link #getFeatureorPPRefs() <em>Featureor PP Refs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFeatureorPPRefs()
	 * @generated
	 * @ordered
	 */
  protected EList<FeatureorPPReference> featureorPPRefs;

  /**
	 * The default value of the '{@link #isNot() <em>Not</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isNot()
	 * @generated
	 * @ordered
	 */
  protected static final boolean NOT_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isNot() <em>Not</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isNot()
	 * @generated
	 * @ordered
	 */
  protected boolean not = NOT_EDEFAULT;

  /**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
  protected static final DirectionType DIRECTION_EDEFAULT = DirectionType.IN;

  /**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
  protected DirectionType direction = DIRECTION_EDEFAULT;

  /**
	 * The cached value of the '{@link #getTypeSet() <em>Type Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTypeSet()
	 * @generated
	 * @ordered
	 */
  protected TypeSet typeSet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ErrorPropagationImpl()
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
		return ErrorModelPackage.Literals.ERROR_PROPAGATION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getKind()
  {
		return kind;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setKind(String newKind)
  {
		String oldKind = kind;
		kind = newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION__KIND, oldKind, kind));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<FeatureorPPReference> getFeatureorPPRefs()
  {
		if (featureorPPRefs == null) {
			featureorPPRefs = new EObjectContainmentEList<FeatureorPPReference>(FeatureorPPReference.class, this, ErrorModelPackage.ERROR_PROPAGATION__FEATUREOR_PP_REFS);
		}
		return featureorPPRefs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isNot()
  {
		return not;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setNot(boolean newNot)
  {
		boolean oldNot = not;
		not = newNot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION__NOT, oldNot, not));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DirectionType getDirection()
  {
		return direction;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDirection(DirectionType newDirection)
  {
		DirectionType oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION__DIRECTION, oldDirection, direction));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypeSet getTypeSet()
  {
		return typeSet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetTypeSet(TypeSet newTypeSet, NotificationChain msgs)
  {
		TypeSet oldTypeSet = typeSet;
		typeSet = newTypeSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET, oldTypeSet, newTypeSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTypeSet(TypeSet newTypeSet)
  {
		if (newTypeSet != typeSet) {
			NotificationChain msgs = null;
			if (typeSet != null)
				msgs = ((InternalEObject)typeSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET, null, msgs);
			if (newTypeSet != null)
				msgs = ((InternalEObject)newTypeSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET, null, msgs);
			msgs = basicSetTypeSet(newTypeSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET, newTypeSet, newTypeSet));
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
			case ErrorModelPackage.ERROR_PROPAGATION__FEATUREOR_PP_REFS:
				return ((InternalEList<?>)getFeatureorPPRefs()).basicRemove(otherEnd, msgs);
			case ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET:
				return basicSetTypeSet(null, msgs);
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
			case ErrorModelPackage.ERROR_PROPAGATION__KIND:
				return getKind();
			case ErrorModelPackage.ERROR_PROPAGATION__FEATUREOR_PP_REFS:
				return getFeatureorPPRefs();
			case ErrorModelPackage.ERROR_PROPAGATION__NOT:
				return isNot();
			case ErrorModelPackage.ERROR_PROPAGATION__DIRECTION:
				return getDirection();
			case ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET:
				return getTypeSet();
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
		switch (featureID) {
			case ErrorModelPackage.ERROR_PROPAGATION__KIND:
				setKind((String)newValue);
				return;
			case ErrorModelPackage.ERROR_PROPAGATION__FEATUREOR_PP_REFS:
				getFeatureorPPRefs().clear();
				getFeatureorPPRefs().addAll((Collection<? extends FeatureorPPReference>)newValue);
				return;
			case ErrorModelPackage.ERROR_PROPAGATION__NOT:
				setNot((Boolean)newValue);
				return;
			case ErrorModelPackage.ERROR_PROPAGATION__DIRECTION:
				setDirection((DirectionType)newValue);
				return;
			case ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET:
				setTypeSet((TypeSet)newValue);
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
			case ErrorModelPackage.ERROR_PROPAGATION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ErrorModelPackage.ERROR_PROPAGATION__FEATUREOR_PP_REFS:
				getFeatureorPPRefs().clear();
				return;
			case ErrorModelPackage.ERROR_PROPAGATION__NOT:
				setNot(NOT_EDEFAULT);
				return;
			case ErrorModelPackage.ERROR_PROPAGATION__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
				return;
			case ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET:
				setTypeSet((TypeSet)null);
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
			case ErrorModelPackage.ERROR_PROPAGATION__KIND:
				return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
			case ErrorModelPackage.ERROR_PROPAGATION__FEATUREOR_PP_REFS:
				return featureorPPRefs != null && !featureorPPRefs.isEmpty();
			case ErrorModelPackage.ERROR_PROPAGATION__NOT:
				return not != NOT_EDEFAULT;
			case ErrorModelPackage.ERROR_PROPAGATION__DIRECTION:
				return direction != DIRECTION_EDEFAULT;
			case ErrorModelPackage.ERROR_PROPAGATION__TYPE_SET:
				return typeSet != null;
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(", not: ");
		result.append(not);
		result.append(", direction: ");
		result.append(direction);
		result.append(')');
		return result.toString();
	}

} //ErrorPropagationImpl
