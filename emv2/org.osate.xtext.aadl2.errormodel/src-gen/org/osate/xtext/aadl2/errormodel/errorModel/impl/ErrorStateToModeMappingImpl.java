/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.aadl2.Mode;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error State To Mode Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorStateToModeMappingImpl#getErrorState <em>Error State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorStateToModeMappingImpl#getMappedModes <em>Mapped Modes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorStateToModeMappingImpl extends MinimalEObjectImpl.Container implements ErrorStateToModeMapping
{
  /**
	 * The cached value of the '{@link #getErrorState() <em>Error State</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getErrorState()
	 * @generated
	 * @ordered
	 */
  protected ErrorBehaviorState errorState;

  /**
	 * The cached value of the '{@link #getMappedModes() <em>Mapped Modes</em>}' reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMappedModes()
	 * @generated
	 * @ordered
	 */
  protected EList<Mode> mappedModes;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ErrorStateToModeMappingImpl()
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
		return ErrorModelPackage.Literals.ERROR_STATE_TO_MODE_MAPPING;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorBehaviorState getErrorState()
  {
		if (errorState != null && errorState.eIsProxy()) {
			InternalEObject oldErrorState = (InternalEObject)errorState;
			errorState = (ErrorBehaviorState)eResolveProxy(oldErrorState);
			if (errorState != oldErrorState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__ERROR_STATE, oldErrorState, errorState));
			}
		}
		return errorState;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ErrorBehaviorState basicGetErrorState()
  {
		return errorState;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setErrorState(ErrorBehaviorState newErrorState)
  {
		ErrorBehaviorState oldErrorState = errorState;
		errorState = newErrorState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__ERROR_STATE, oldErrorState, errorState));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Mode> getMappedModes()
  {
		if (mappedModes == null) {
			mappedModes = new EObjectResolvingEList<Mode>(Mode.class, this, ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__MAPPED_MODES);
		}
		return mappedModes;
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
			case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__ERROR_STATE:
				if (resolve) return getErrorState();
				return basicGetErrorState();
			case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__MAPPED_MODES:
				return getMappedModes();
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
			case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__ERROR_STATE:
				setErrorState((ErrorBehaviorState)newValue);
				return;
			case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__MAPPED_MODES:
				getMappedModes().clear();
				getMappedModes().addAll((Collection<? extends Mode>)newValue);
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
			case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__ERROR_STATE:
				setErrorState((ErrorBehaviorState)null);
				return;
			case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__MAPPED_MODES:
				getMappedModes().clear();
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
			case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__ERROR_STATE:
				return errorState != null;
			case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING__MAPPED_MODES:
				return mappedModes != null && !mappedModes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ErrorStateToModeMappingImpl
