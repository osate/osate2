/*
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
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
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE
 */
package org.osate.xtext.aadl2.errormodel.ui.contentassist;

import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.osate.aadl2.AadlPackage
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.osate.xtext.aadl2.errormodel.util.ErrorModelUtil.getAllErrorTypes

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
class ErrorModelProposalProvider extends AbstractErrorModelProposalProvider {
	
	override completeErrorModelLibrary_Extends(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.getTerminal() as CrossReference, context, acceptor,
		 [model !=  EcoreUtil.resolve(EObjectOrProxy, model) ])
	}
	
	override completeTypeDefinition_SuperType(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val containingEML = model.getContainerOfType(ErrorModelLibrary)
		val results = new ArrayList<ErrorModelLibrary>() as List<ErrorModelLibrary>
		results.add(containingEML)
		val extendedNames = containingEML.getExtendedLibraries(results).map([it.getContainerOfType(AadlPackage).name])

		lookupCrossReference(assignment.getTerminal() as CrossReference, context, acceptor,
			[
				switch it.qualifiedName.segmentCount{
					case 1 : true
					case 2 : !extendedNames.exists[en | qualifiedName.segments.head.equalsIgnoreCase(en)]
					default : false
				}
			])
	}
	
	def List<ErrorModelLibrary> getExtendedLibraries(ErrorModelLibrary eml, List<ErrorModelLibrary> results){
		eml.extends.forEach[extEml | 
			results.add(extEml)
			extEml.getExtendedLibraries(results) ]
		results
	}
	
	override completeTypeSetElement_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (model instanceof TypeSet && model.eContainer instanceof ErrorEvent && model.getContainerOfType(ErrorBehaviorStateMachine) != null) {
			val emls = model.getContainerOfType(ErrorBehaviorStateMachine).useTypes 
			lookupCrossReference(assignment.terminal as CrossReference, context, acceptor,
			[
				val proposedObj = EcoreUtil.resolve(EObjectOrProxy, model)
				emls.map([eml | eml.allErrorTypes]).flatten.exists[it == proposedObj]
			])
		} else {
			super.completeTypeSetElement_Type(model, assignment, context, acceptor)
		}
	}

}
