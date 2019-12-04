/*
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
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
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.scoping;

import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.IScope
import org.osate.aadl2.Classifier
import org.osate.aadl2.ConnectedElement
import org.osate.aadl2.ContainmentPathElement
import org.osate.aadl2.Context
import org.osate.aadl2.Element
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.ReferenceValue

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import org.osate.aadl2.ContainedNamedElement
import org.eclipse.xtext.EcoreUtil2.ElementReferenceAcceptor
import org.eclipse.xtext.EcoreUtil2

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 * 
 */
class Aadl2SerializerScopeProvider extends Aadl2ScopeProvider {

	// Reference is from ConnectedElement in Aadl2.xtext
	override scope_ConnectedElement_connectionEnd(ConnectedElement context, EReference reference) {
		val classifier = context.getContainerOfType(Classifier)
		val previousConnectedElement = context.eContainer
		if (previousConnectedElement instanceof ConnectedElement) {
			val previous = previousConnectedElement.connectionEnd
			if (previous instanceof Context) {
				previous.scopeForElementsOfContext(classifier, [allConnectionEnds.filterRefined])
			} else {
				IScope.NULLSCOPE
			}
		} else if (context.context === null) {
			classifier.allConnectionEnds.filterRefined.scopeFor
		} else {
			context.context.scopeForElementsOfContext(classifier, [allConnectionEnds.filterRefined])
		}
	}

	def scope_ContainmentPathElement_namedElement(ContainmentPathElement context, EReference reference) {
		val previous = context.owner
		if (previous instanceof ContainmentPathElement) {
			val namespace = previous.classifierForPreviousContainmentPathElement
			namespace?.allMembers?.filterRefined?.scopeFor ?: IScope::NULLSCOPE
		} else
			null
	}
	
	def scope_ContainmentPathElement_namedElement(ContainedNamedElement context, EReference reference) {
		val propertyAssociation = EcoreUtil2.getContainerOfType(context, PropertyAssociation)
		val namespace = propertyAssociation.namespaceForPropertyAssociation
		namespace?.allMembers?.filterRefined?.scopeFor ?: IScope::NULLSCOPE
	}
	
}
