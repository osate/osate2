/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelGrammarRoot;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grammar Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelGrammarRootImpl#getEml <em>Eml</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelGrammarRootImpl#getEmsc <em>Emsc</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorModelGrammarRootImpl extends MinimalEObjectImpl.Container implements ErrorModelGrammarRoot
{
  /**
	 * The cached value of the '{@link #getEml() <em>Eml</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getEml()
	 * @generated
	 * @ordered
	 */
  protected ErrorModelLibrary eml;

  /**
	 * The cached value of the '{@link #getEmsc() <em>Emsc</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getEmsc()
	 * @generated
	 * @ordered
	 */
  protected ErrorModelSubclause emsc;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ErrorModelGrammarRootImpl()
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
		return ErrorModelPackage.Literals.ERROR_MODEL_GRAMMAR_ROOT;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorModelLibrary getEml()
  {
		return eml;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetEml(ErrorModelLibrary newEml, NotificationChain msgs)
  {
		ErrorModelLibrary oldEml = eml;
		eml = newEml;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EML, oldEml, newEml);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setEml(ErrorModelLibrary newEml)
  {
		if (newEml != eml) {
			NotificationChain msgs = null;
			if (eml != null)
				msgs = ((InternalEObject)eml).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EML, null, msgs);
			if (newEml != null)
				msgs = ((InternalEObject)newEml).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EML, null, msgs);
			msgs = basicSetEml(newEml, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EML, newEml, newEml));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorModelSubclause getEmsc()
  {
		return emsc;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetEmsc(ErrorModelSubclause newEmsc, NotificationChain msgs)
  {
		ErrorModelSubclause oldEmsc = emsc;
		emsc = newEmsc;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EMSC, oldEmsc, newEmsc);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setEmsc(ErrorModelSubclause newEmsc)
  {
		if (newEmsc != emsc) {
			NotificationChain msgs = null;
			if (emsc != null)
				msgs = ((InternalEObject)emsc).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EMSC, null, msgs);
			if (newEmsc != null)
				msgs = ((InternalEObject)newEmsc).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EMSC, null, msgs);
			msgs = basicSetEmsc(newEmsc, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EMSC, newEmsc, newEmsc));
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
			case ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EML:
				return basicSetEml(null, msgs);
			case ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EMSC:
				return basicSetEmsc(null, msgs);
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
			case ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EML:
				return getEml();
			case ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EMSC:
				return getEmsc();
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
			case ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EML:
				setEml((ErrorModelLibrary)newValue);
				return;
			case ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EMSC:
				setEmsc((ErrorModelSubclause)newValue);
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
			case ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EML:
				setEml((ErrorModelLibrary)null);
				return;
			case ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EMSC:
				setEmsc((ErrorModelSubclause)null);
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
			case ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EML:
				return eml != null;
			case ErrorModelPackage.ERROR_MODEL_GRAMMAR_ROOT__EMSC:
				return emsc != null;
		}
		return super.eIsSet(featureID);
	}

} //ErrorModelGrammarRootImpl
