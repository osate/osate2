/**
 */
package org.osate.aadl2.errormodel.PropagationGraph;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage
 * @generated
 */
public interface PropagationGraphFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PropagationGraphFactory eINSTANCE = org.osate.aadl2.errormodel.PropagationGraph.impl.PropagationGraphFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Propagation Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Propagation Graph</em>'.
	 * @generated
	 */
	PropagationGraph createPropagationGraph();

	/**
	 * Returns a new object of class '<em>Propagation Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Propagation Path</em>'.
	 * @generated
	 */
	PropagationPath createPropagationPath();

	/**
	 * Returns a new object of class '<em>Propagation Path End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Propagation Path End</em>'.
	 * @generated
	 */
	PropagationPathEnd createPropagationPathEnd();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PropagationGraphPackage getPropagationGraphPackage();

} //PropagationGraphFactory
