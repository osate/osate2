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
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType

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
			ErrorPath case modelContainer.incoming != null : {
				filterErrorPropagationTokenTypes( modelContainer.incoming, model, assignment, context, acceptor)
			}
			TypeSet case modelContainer.getContainerOfType(ErrorPath)?.incoming != null : {
				filterErrorPropagationTokenTypes( modelContainer.getContainerOfType(ErrorPath).incoming, model, assignment, context, acceptor)
			}
			TypeSet case modelContainer.getContainerOfType(ErrorSource)?.outgoing != null : {
				filterErrorPropagationTokenTypes(modelContainer.getContainerOfType(ErrorSource).outgoing, model, assignment, context, acceptor)
			}
			TypeSet case modelContainer.getContainerOfType(ErrorSink)?.incoming != null : {
				filterErrorPropagationTokenTypes(modelContainer.getContainerOfType(ErrorSink).incoming, model, assignment, context, acceptor)
			}
			ErrorSource case modelContainer.outgoing != null : {
				filterErrorPropagationTokenTypes(modelContainer.outgoing, model, assignment, context, acceptor)
			}
			ErrorSink case modelContainer.incoming != null : {
				filterErrorPropagationTokenTypes(modelContainer.incoming, model, assignment, context, acceptor)
			}
			default : super.completeTypeSetElement_Type(model, assignment, context, acceptor)
		}
	}

	override void completeTypeToken_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val modelContainer = model.eContainer
		switch modelContainer{
			ErrorPath case modelContainer.outgoing != null : {
				filterErrorPropagationTokenTypes( modelContainer.outgoing, model, assignment, context, acceptor)
			}
			default : super.completeTypeToken_Type(model, assignment, context, acceptor)
		}
	}

	def filterErrorPropagationTokenTypes(ErrorPropagation errorPropagation, EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor){
		val validErrorTypesList = new ArrayList<ErrorTypes> 
		val validWithSuperTypes = new ArrayList<ErrorTypes>
		errorPropagation.typeSet.typeTokens.forEach[token | token.type.getValidTypes( validErrorTypesList) ]
		validErrorTypesList.forEach[errorType | errorType.getSuperTypes(validWithSuperTypes)]
		lookupCrossReference(assignment.getTerminal() as CrossReference, context, acceptor,
		[validWithSuperTypes.contains(EcoreUtil.resolve(EObjectOrProxy, model))])
	}

	def List<ErrorTypes> getValidTypes(List<ErrorTypes> etsIn, List<ErrorTypes> validErrorTypesList){
		etsIn?.forEach[ets | 
			if (ets != null) {
				if (!validErrorTypesList.contains(ets)) validErrorTypesList.add(ets)
				if (ets instanceof TypeSet) ets.typeTokens?.forEach[token | token?.type?.getValidTypes(validErrorTypesList)]
			}
		]
		validErrorTypesList
	}

	def List<ErrorTypes> getSuperTypes(ErrorTypes et, List<ErrorTypes> results){
		if (!results.contains(et)) results.add(et)
		if (et instanceof ErrorType){et.superType?.getSuperTypes(results)}
		results
	}

}
