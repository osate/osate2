/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.reqspec.serializer;

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer
import org.osate.aadl2.ComponentClassifier

class ReqSpecCrossReferenceSerializer extends CrossReferenceSerializer {

	override serializeCrossRef(EObject semanticObject, CrossReference crossref, EObject target, INode node,
			Acceptor errors) {

		val crossRefString = super.serializeCrossRef(semanticObject, crossref, target, node, errors)
		
		switch target{
			ComponentClassifier : {
				val qn =  target.qualifiedName()
				val qnDoubleColonIndex = qn.indexOf("::")
				if (qnDoubleColonIndex < 0 || crossRefString.indexOf("::") > -1) crossRefString
				else {
					val crsPeriodIndex = crossRefString.indexOf(".")
					if (crsPeriodIndex == qnDoubleColonIndex){
						val checkString = crossRefString.substring(0, crsPeriodIndex) + "::" 
										+ crossRefString.substring(crsPeriodIndex + 1)
						if (checkString.equalsIgnoreCase(qn)) checkString
						else crossRefString
					} else crossRefString
				}
			}
			default : crossRefString
		}

	}
	

}
