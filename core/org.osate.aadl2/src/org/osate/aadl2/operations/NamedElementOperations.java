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
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
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
 * $Id: NamedElementOperations.java,v 1.9 2009-02-26 21:21:13 lwrage Exp $
 */
package org.osate.aadl2.operations;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.aadl2.util.Aadl2Util;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Named Element</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.NamedElement#getNamespace() <em>Get Namespace</em>}</li>
 *   <li>{@link org.osate.aadl2.NamedElement#qualifiedName() <em>Qualified Name</em>}</li>
 *   <li>{@link org.osate.aadl2.NamedElement#getPropertyValues(java.lang.String, java.lang.String) <em>Get Property Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamedElementOperations extends ElementOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedElementOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static Namespace getNamespace(NamedElement namedElement) {
		// DONE: implement this method
		return namedElement.getOwner() instanceof Namespace ? (Namespace) namedElement.getOwner() : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When there is a name, and all of the containing namespaces have a name, the qualified name is constructed from the names of the containing namespaces.
	 * if self.name->notEmpty() and self.allNamespaces()->select(ns | ns.name->isEmpty())->isEmpty() then
	 *   self.allNamespaces()->iterate(ns: Namespace; result: String = self.name | ns.name.concat(self.separator()).concat(result))
	 * else
	 *   ''
	 * endif
	 * @param namedElement The receiving '<em><b>Named Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static String qualifiedName(NamedElement namedElement) {
		if (namedElement.hasName()) {
			Namespace namespace = namedElement.getNamespace();
			if (namespace != null) {
				if (namespace instanceof PropertySet && namespace.hasName()) {
					return namespace.getName() + "::" + namedElement.getName();
				} else if (namespace instanceof PackageSection && ((AadlPackage) namespace.getOwner()).hasName()) {
					return ((AadlPackage) namespace.getOwner()).getName() + "::" + namedElement.getName();
				} else {
					return qualifiedName(namespace) + '.' + namedElement.getName();
				}
			} else {
				return namedElement.getName();
			}
		} else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated Will be removed in 2.7.
	 * @generated NOT
	 */
	@Deprecated
	public static EList<PropertyExpression> getPropertyValues(NamedElement namedElement, String propertySetName,
			String propertyName) {
		final EList<PropertyExpression> result = new BasicEList<PropertyExpression>();
		final Property property = Aadl2Util.lookupPropertyDefinition(namedElement, propertySetName, propertyName);

		try {
			if (property.isList()) {
				result.addAll(namedElement.getPropertyValueList(property));
			} else {
				result.add(namedElement.getSimplePropertyValue(property));
			}
		} catch (final PropertyNotPresentException p_ex) {
			// We simply return an empty list when there is no property associations
		}

		return result;
	}

} // NamedElementOperations