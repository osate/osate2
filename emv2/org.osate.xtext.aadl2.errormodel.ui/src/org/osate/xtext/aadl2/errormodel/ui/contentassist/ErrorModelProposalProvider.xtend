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
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import org.osate.xtext.aadl2.errormodel.util.EMV2Util

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
class ErrorModelProposalProvider extends AbstractErrorModelProposalProvider {
	
	override completeErrorModelLibrary_Extends(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.getTerminal() as CrossReference, context, acceptor,
		 [model !=  EcoreUtil.resolve(EObjectOrProxy, model) ])
	}
	
	override completeTypeDefinition_SuperType(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.getTerminal() as CrossReference, context, acceptor,
			[!(name.toString.equalsIgnoreCase((model as ErrorType).name))])
	}
	
	def List<ErrorModelLibrary> getExtendedLibraries(ErrorModelLibrary eml, List<ErrorModelLibrary> results){
		eml.extends.forEach[extEml | 
			results.add(extEml)
			extEml.getExtendedLibraries(results) ]
		results
	}
	
	override completeTypeSetElement_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val modelContainer = model.eContainer
		switch modelContainer{
			ErrorPath case modelContainer.incoming !== null : {
				filterTypeSetTokenTypes( modelContainer.incoming.typeSet, model, assignment, context, acceptor)
			}
			TypeSet case modelContainer.getContainerOfType(ErrorPath)?.incoming !== null : {
				filterTypeSetTokenTypes( modelContainer.getContainerOfType(ErrorPath).incoming.typeSet, model, assignment, context, acceptor)
			}
			TypeSet case modelContainer.getContainerOfType(ErrorSource)?.outgoing !== null : {
				filterTypeSetTokenTypes(modelContainer.getContainerOfType(ErrorSource).outgoing.typeSet, model, assignment, context, acceptor)
			}
			TypeSet case modelContainer.getContainerOfType(ErrorSink)?.incoming !== null : {
				filterTypeSetTokenTypes(modelContainer.getContainerOfType(ErrorSink).incoming.typeSet, model, assignment, context, acceptor)
			}
			ErrorSource case modelContainer.outgoing !== null && modelContainer.typeTokenConstraint == model: {
				filterTypeSetTokenTypes(modelContainer.outgoing.typeSet, model, assignment, context, acceptor)
			}
			ErrorSource case modelContainer.failureModeReference !== null && modelContainer.failureModeType == model: {
				filterTypeSetTokenTypes(modelContainer.failureModeReference.typeSet, model, assignment, context, acceptor)
			}
			ErrorSink case modelContainer.incoming !== null : {
				filterTypeSetTokenTypes(modelContainer.incoming.typeSet, model, assignment, context, acceptor)
			}
			ErrorBehaviorTransition case model instanceof TypeSet: {
				filterTypeSetTokenTypes(modelContainer.source.typeSet, model, assignment, context, acceptor)
			}
			ErrorBehaviorTransition case model instanceof ConditionElement && (model as ConditionElement).qualifiedErrorPropagationReference !== null : {
				val incoming = EMV2Util.getErrorEventOrPropagation(model as ConditionElement)
				switch incoming {
					ErrorPropagation : filterTypeSetTokenTypes(incoming.typeSet, model, assignment, context, acceptor)
					ErrorEvent : filterTypeSetTokenTypes(incoming.typeSet, model, assignment, context, acceptor)
				}
			}
			default : super.completeTypeSetElement_Type(model, assignment, context, acceptor)
		}
	}
//
//	override void completeTypeToken_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
//		val modelContainer = model.eContainer
//		switch modelContainer{
//			ErrorPath case modelContainer.outgoing !== null : {
//				filterTypeSetTokenTypes( modelContainer.outgoing.typeSet, model, assignment, context, acceptor)
//			}
//			ErrorBehaviorTransition case modelContainer.target !== null: {
//				filterTypeSetTokenTypes( modelContainer.target.typeSet, model, assignment, context, acceptor)
//			}
//			default : super.completeTypeToken_Type(model, assignment, context, acceptor)
//		}
//	}

	def filterTypeSetTokenTypes(TypeSet typeSet, EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor){
		val validErrorTypesList = new ArrayList<ErrorTypes> 
		typeSet.typeTokens.forEach[token | token.type.getValidTypes( validErrorTypesList) ]
		lookupCrossReference(assignment.getTerminal() as CrossReference, context, acceptor,
			[
				val proposedObj = EcoreUtil.resolve(EObjectOrProxy, model)
				val validSuperTypesOfProposed = new ArrayList<ErrorTypes>
				if (proposedObj instanceof ErrorTypes) getProposedObjectSuperTypes(proposedObj, validSuperTypesOfProposed, proposedObj)
				validErrorTypesList.contains(proposedObj) || 
					validErrorTypesList.exists[type| validSuperTypesOfProposed.contains(type)] 
			])
	}

	def List<ErrorTypes> getValidTypes(List<ErrorTypes> etsIn, List<ErrorTypes> validErrorTypesList){
		etsIn?.forEach[ets | 
			if (ets !== null) {
				if (!validErrorTypesList.contains(ets)) validErrorTypesList.add(ets)
				if (ets instanceof TypeSet) ets.typeTokens?.forEach[token | token?.type?.getValidTypes(validErrorTypesList)]
			}
		]
		validErrorTypesList
	}

	def List<ErrorTypes> getProposedObjectSuperTypes(ErrorTypes et, List<ErrorTypes> results, EObject proposedObj){
		if (!results.contains(et) && et != proposedObj) results.add(et)
		if (et instanceof ErrorType){et.superType?.getProposedObjectSuperTypes(results, proposedObj)}
		results
	}

}
