/**
 */
package org.osate.aadl2.errormodel.FaultTree;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage
 * @generated
 */
public interface FaultTreeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FaultTreeFactory eINSTANCE = org.osate.aadl2.errormodel.FaultTree.impl.FaultTreeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Fault Tree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fault Tree</em>'.
	 * @generated
	 */
	FaultTree createFaultTree();

	/**
	 * Returns a new object of class '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event</em>'.
	 * @generated
	 */
	Event createEvent();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FaultTreePackage getFaultTreePackage();

} //FaultTreeFactory
