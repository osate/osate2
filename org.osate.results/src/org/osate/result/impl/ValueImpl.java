/**
 */
package org.osate.result.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.result.ResultPackage;
import org.osate.result.Value;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ValueImpl extends MinimalEObjectImpl.Container implements Value {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResultPackage.Literals.VALUE;
	}

} //ValueImpl
