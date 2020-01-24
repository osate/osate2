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
package org.osate.xtext.aadl2.errormodel.serializer

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer
import org.osate.aadl2.AadlPackage
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType

class ErrorModelCrossReferenceSerializer extends CrossReferenceSerializer {
	val public static PREFIX = "emv2$"
	
	override serializeCrossRef(EObject semanticObject, CrossReference crossref, EObject target, INode node, Acceptor errors) {
		val crossRefString = super.serializeCrossRef(semanticObject, crossref, target, node, errors)
		if (crossRefString.startsWith(PREFIX)) {
			crossRefString.substring(PREFIX.length)
		} else {
			crossRefString
		}
	}
	
	override protected getCrossReferenceNameFromScope(EObject semanticObject, CrossReference crossref, EObject target,
		IScope scope, Acceptor errors) {
		/*
		 * For references to ErrorType or TypeSet that must be qualified, use the package name where the ErrorType or
		 * TypeSet is actually declared. This fixes a problem where the reference was being qualified with an error
		 * library which extends the library that contains the definition. If the reference does not need to be
		 * qualified, then use a simple name.
		 * 
		 * getCrossReferenceNameFromScope is only called if there is no node model. If there is a node model, then the
		 * reference is serialized based on the original text.
		 * 
		 * See https://github.com/osate/osate2/issues/1399
		 */
		switch GrammarUtil.getReference(crossref) {
			case ErrorModelPackage.Literals.TYPE_TOKEN__TYPE,
			case ErrorModelPackage.Literals.ERROR_TYPE__SUPER_TYPE,
			case ErrorModelPackage.Literals.ERROR_TYPE__ALIASED_TYPE,
			case ErrorModelPackage.Literals.TYPE_SET__ALIASED_TYPE: {
				val simpleName = (target as ErrorTypes).name
				if (scope.getSingleElement(QualifiedName.create(simpleName)) === null) {
					target.getContainerOfType(AadlPackage).name + "::" + simpleName
				} else {
					simpleName
				}
			}
			default: super.getCrossReferenceNameFromScope(semanticObject, crossref, target, scope, errors)
		}
	}
}