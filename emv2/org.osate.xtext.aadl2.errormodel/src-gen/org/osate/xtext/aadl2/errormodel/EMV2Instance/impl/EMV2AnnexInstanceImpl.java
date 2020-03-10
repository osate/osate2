/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.instance.AnnexInstance;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.impl.InstanceObjectImpl;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceObject;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMV2 Annex Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl#getAnnexSubclause <em>Annex Subclause</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EMV2AnnexInstanceImpl extends InstanceObjectImpl implements EMV2AnnexInstance {
	/**
	 * The cached value of the '{@link #getAnnexSubclause() <em>Annex Subclause</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnexSubclause()
	 * @generated
	 * @ordered
	 */
	protected AnnexSubclause annexSubclause;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMV2AnnexInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.EMV2_ANNEX_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnexSubclause getAnnexSubclause() {
		if (annexSubclause != null && ((EObject)annexSubclause).eIsProxy()) {
			InternalEObject oldAnnexSubclause = (InternalEObject)annexSubclause;
			annexSubclause = (AnnexSubclause)eResolveProxy(oldAnnexSubclause);
			if (annexSubclause != oldAnnexSubclause) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ANNEX_SUBCLAUSE, oldAnnexSubclause, annexSubclause));
				}
			}
		}
		return annexSubclause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnexSubclause basicGetAnnexSubclause() {
		return annexSubclause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAnnexSubclause(AnnexSubclause newAnnexSubclause) {
		AnnexSubclause oldAnnexSubclause = annexSubclause;
		annexSubclause = newAnnexSubclause;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ANNEX_SUBCLAUSE, oldAnnexSubclause, annexSubclause));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ANNEX_SUBCLAUSE:
				if (resolve) {
					return getAnnexSubclause();
				}
				return basicGetAnnexSubclause();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ANNEX_SUBCLAUSE:
				setAnnexSubclause((AnnexSubclause)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ANNEX_SUBCLAUSE:
				setAnnexSubclause((AnnexSubclause)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ANNEX_SUBCLAUSE:
				return annexSubclause != null;
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
		if (baseClass == AnnexInstance.class) {
			switch (derivedFeatureID) {
				case EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ANNEX_SUBCLAUSE: return InstancePackage.ANNEX_INSTANCE__ANNEX_SUBCLAUSE;
				default: return -1;
			}
		}
		if (baseClass == EMV2InstanceObject.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == AnnexInstance.class) {
			switch (baseFeatureID) {
				case InstancePackage.ANNEX_INSTANCE__ANNEX_SUBCLAUSE: return EMV2InstancePackage.EMV2_ANNEX_INSTANCE__ANNEX_SUBCLAUSE;
				default: return -1;
			}
		}
		if (baseClass == EMV2InstanceObject.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	@Override
	public boolean isActive(SystemOperationMode som) {
		return true;
	}

} //EMV2AnnexInstanceImpl
