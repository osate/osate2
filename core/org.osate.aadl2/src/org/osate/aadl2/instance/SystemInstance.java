/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 * $Id: SystemInstance.java,v 1.10 2010-05-07 20:01:28 lwrage Exp $
 */
package org.osate.aadl2.instance;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>System Instance</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.SystemInstance#getSystemOperationModes <em>System Operation Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.SystemInstance#getComponentImplementation <em>Component Implementation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.aadl2.instance.InstancePackage#getSystemInstance()
 * @model
 * @generated
 */
public interface SystemInstance extends ComponentInstance {
	/**
	 * Returns the value of the '<em><b>System Operation Mode</b></em>'
	 * containment reference list. The list contents are of type
	 * {@link org.osate.aadl2.instance.SystemOperationMode}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Operation Mode</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>System Operation Mode</em>' containment
	 *         reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getSystemInstance_SystemOperationMode()
	 * @model containment="true"
	 * @generated
	 */
	EList<SystemOperationMode> getSystemOperationModes();

	/**
	 * Creates a new {@link org.osate.aadl2.instance.SystemOperationMode} and appends it to the '<em><b>System Operation Mode</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.instance.SystemOperationMode}.
	 * @see #getSystemOperationModes()
	 * @generated
	 */
	SystemOperationMode createSystemOperationMode();

	/**
	 * Returns the value of the '<em><b>Component Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Implementation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Implementation</em>' reference.
	 * @see #setComponentImplementation(ComponentImplementation)
	 * @see org.osate.aadl2.instance.InstancePackage#getSystemInstance_ComponentImplementation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ComponentImplementation getComponentImplementation();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.SystemInstance#getComponentImplementation <em>Component Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Implementation</em>' reference.
	 * @see #getComponentImplementation()
	 * @generated
	 */
	void setComponentImplementation(ComponentImplementation value);

	@Override
	ComponentImplementation getComponentClassifier();

	/**
	 * get all SOMs that contain the ModeInstance list
	 *
	 * @param mis List of mode instances
	 * @return SOM that match the ModeInstance list
	 */
	List<SystemOperationMode> getSystemOperationModesFor(final List<ModeInstance> mis);

	/**
	 * Sets the current modes of the component instances contained in this
	 * system instance to match the state of the specified system operation
	 * mode. This system operation mode is also set globally on the system
	 * instance. There is an invariant over the instance model that if the
	 * current system operation mode of the root system instance is non-
	 * <code>null</code>, then the "current mode" state of the component
	 * instances in the model match that state.
	 *
	 * @param som SystemOperationMode whose values are used to set the
	 *            currentMode in the instance model
	 * @see #clearCurrentSystemOperationMode()
	 * @see #getCurrentSystemOperationMode()
	 */
	void setCurrentSystemOperationMode(SystemOperationMode som);

	/**
	 * Get the current system operation mode of the system, or <code>null</code>
	 * if it has not been set.
	 */
	SystemOperationMode getCurrentSystemOperationMode();

	/**
	 * Clear the mode states for a given SystemInstance. That is, the modal
	 * adapters for the model all have their modes set to <code>null</code>.
	 */
	void clearCurrentSystemOperationMode();

	/**
	 * find the Connection instance for these feature instances. The connection
	 * instance may point to the enclosing feature group instance The connection
	 * instance may go through the feature to a subcomponent instance
	 * <p>
	 * This method is sensitive to the {@link #getCurrentSystemOperationMode()
	 * current system operation mode}.
	 *
	 * @param srcFI source feature instance
	 * @param dstFI destination feature instance
	 * @return Connection instance with the specified source and destination, or
	 *         <code>null</code> if no such connection exists in the current
	 *         som.
	 */
	ConnectionInstance findConnectionInstance(FeatureInstance srcFI, FeatureInstance dstFI);

	/**
	 * Find all connection instances that pass through two declarative connections in
	 * the same order as given in the parameters.
	 * <p>
	 * This method is sensitive to the {@link #getCurrentSystemOperationMode()
	 * current system operation mode}.
	 *
	 * @param first the first connection that should occur in the connection instance
	 * @param second the connection that should occur after the first in the connection instance
	 * @return the list of connection instances
	 */
	List<ConnectionInstance> findConnectionInstances(Connection first, Connection second);

	/**
	 * Get the system operation modes containing the given mode instance.
	 *
	 * @param mi The mode instance to look for
	 * @return The system operation modes containing the given mode instance.
	 */
	List<SystemOperationMode> getSystemOperationModesFor(ModeInstance mi);

	SystemOperationMode getInitialSystemOperationMode();

	/**
	 * Iterates over all connection instances in the instance model.
	 * This iterator give you all connection instances in the model by collecting them by walking the model.
	 */
	Iterable<ConnectionInstance> allConnectionInstances();

	/**
	 * Get all connection instances in the instance model.
	 * This iterator give you all connection instances in the model by collecting them by walking the model.
	 * This method provides the functionality of the getConnectionInstances method when all connection instances
	 * were stored with the system instance. We now store a connection instance with the closest enclosing component instance
	 * of both endpoints.
	 */
	EList<ConnectionInstance> getAllConnectionInstances();

} // SystemInstance
