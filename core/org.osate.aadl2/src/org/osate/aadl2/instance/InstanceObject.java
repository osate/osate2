/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.instance;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Object</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.InstanceObject#getAnnexInstances <em>Annex Instance</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.instance.InstancePackage#getInstanceObject()
 * @model abstract="true"
 *        annotation="duplicates"
 * @generated
 */
public interface InstanceObject extends EObject, NamedElement {
	/**
	 * Returns the value of the '<em><b>Annex Instance</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.AnnexInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annex Instance</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annex Instance</em>' containment reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getInstanceObject_AnnexInstance()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AnnexInstance> getAnnexInstances();

	/**
	 * Returns the closest ancestor component (in the containment hierarchy)
	 * that is a <code>ComponentInstance</code>.
	 *
	 * @return containing component instance
	 */
	ComponentInstance getContainingComponentInstance();

	/**
	 * Get the containing component instance of an instance object, or itself if
	 * this is a component instance
	 *
	 * @return containing component instance
	 */
	ComponentInstance getComponentInstance();

	/**
	 * find the enclosing SystemInstance
	 *
	 * @return SytstemInstance object
	 */
	SystemInstance getSystemInstance();

	/**
	 * Construct a string path from the system instance as root
	 *
	 * @return path as string
	 */
	String getInstanceObjectPath();

	/**
	 * Construct a string path excluding the system instance as root.
	 *
	 * @return path as string
	 */
	String getComponentInstancePath();

	/**
	 * Return the declarative objects that define this instance. Most of the
	 * time this will return a singleton list. But in the case of semantic
	 * connections, it will return a list of connection objects.
	 *
	 * @return A List of NamedElement objects that should be declarative model
	 *         elements. Returns an empty list if no named declarative object
	 *         exists, such as in the case of {@link ModeTransitionInstance}s.
	 */
	public List<? extends NamedElement> getInstantiatedObjects();

	/**
	 * Find all instance object that match a given containment path.
	 *
	 * @param referencePath the search path for contained instance objects
	 * @return the list of matching instance objects
	 */
	List<InstanceObject> findInstanceObjects(EList<ContainmentPathElement> referencePath);

	boolean matchesIndex(List<ArrayRange> ranges);

	boolean isActive(SystemOperationMode som);

	/**
	 * Iterates over all connection instances that are contained in enclosing component instances the instance model.
	 * This will give you the subset of connection instances whose endpoints potentially refer to or into the target object.
	 * This function is useful since we now store connection instances in the closest enclosing component instance
	 * rather than always with the the system instance. The allConnectionInstances method does collect all connection instances
	 * by walking the whole model.
	 * We start looking for connection instances at the containing component instance of the THIS
	 * We then work our way up the enclosing component instance hierarchy.
	 */
	Iterable<ConnectionInstance> allEnclosingConnectionInstances();

	/**
	 * Get all connection instances in the instance model that are contained in enclosing component instances the instance model.
	 * This will give you the subset of connection instances whose endpoints potentially refer to or into the target object.
	 * This function is useful since we now store connection instances in the closest enclosing component instance
	 * rather than always with the the system instance. The allConnectionInstances method does collect all connection instances
	 * by walking the whole model.
	 * We start looking for connection instances at the containing component instance of the THIS
	 * We then work our way up the enclosing component instance hierarchy.
	 */
	EList<ConnectionInstance> getAllEnclosingConnectionInstances();

} // InstanceObject
