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
 * $Id: InstanceObject.java,v 1.12 2011-04-11 13:35:57 lwrage Exp $
 */
package org.osate.aadl2.instance;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Object</b></em>'. <!-- end-user-doc -->
 *
 *
 * @see org.osate.aadl2.instance.InstancePackage#getInstanceObject()
 * @model abstract="true"
 * @generated
 */
public interface InstanceObject extends EObject, NamedElement {
	/**
	 * Returns the closest ancestor component (in the containment hierarchy)
	 * that is a <code>ComponentInstance</code>.
	 * 
	 * @return containing component instance
	 */
	ComponentInstance getContainingComponentInstance();

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
	 * Returns the System Operation Modes in which the element exists, or
	 * <code>null</code> if the element always exists.
	 * 
	 * @return
	 */
	List<SystemOperationMode> getExistsInModes();

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

	boolean isActive(SystemOperationMode som);

} // InstanceObject
