/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.impl.InstanceObjectImpl;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceObject;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class EMV2InstanceObjectImpl extends InstanceObjectImpl implements EMV2InstanceObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMV2InstanceObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.EMV2_INSTANCE_OBJECT;
	}

	@Override
	public boolean isActive(SystemOperationMode som) {
		return getContainingEMV2AnnexInstance().isActive(som) || getContainingComponentInstance().isActive(som);
	}

	/**
	 * @return the EMV2 Annex instance that contains this object.
	 */
	public EMV2AnnexInstance getContainingEMV2AnnexInstance() {
		EObject eobj = this;

		do {
			eobj = eobj.eContainer();
		} while (eobj != null && !(eobj instanceof EMV2AnnexInstance));

		return (EMV2AnnexInstance) eobj;
	}

} //EMV2InstanceObjectImpl
