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
package org.osate.xtext.aadl2.errormodel.ui.contentassist;

import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.RuleCall
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
import org.osate.xtext.aadl2.errormodel.services.ErrorModelGrammarAccess
import org.osate.xtext.aadl2.errormodel.util.EMV2Util

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
class ErrorModelProposalProvider extends AbstractErrorModelProposalProvider {
	@Inject extension ErrorModelGrammarAccess
	
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
			TypeSet case modelContainer.getContainerOfType(ErrorSource)?.sourceModelElement !== null && modelContainer.getContainerOfType(ErrorSource)?.sourceModelElement instanceof ErrorPropagation: {
				filterTypeSetTokenTypes((modelContainer.getContainerOfType(ErrorSource).sourceModelElement as ErrorPropagation).typeSet, model, assignment, context, acceptor)
			}
			TypeSet case modelContainer.getContainerOfType(ErrorSink)?.incoming !== null : {
				filterTypeSetTokenTypes(modelContainer.getContainerOfType(ErrorSink).incoming.typeSet, model, assignment, context, acceptor)
			}
			ErrorSource case modelContainer.sourceModelElement !== null&& modelContainer.sourceModelElement instanceof ErrorPropagation && modelContainer.typeTokenConstraint == model: {
				filterTypeSetTokenTypes((modelContainer.sourceModelElement as ErrorPropagation).typeSet, model, assignment, context, acceptor)
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
	
	override complete_ComponentErrorBehaviorKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		componentErrorBehaviorKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_CompositeErrorBehaviorKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		compositeErrorBehaviorKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_ConnectionErrorKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		connectionErrorKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_EndBehaviorKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		endBehaviorKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_EndComponentKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		endComponentKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_EndCompositeKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		endCompositeKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_EndConnectionKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		endConnectionKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_EndMappingsKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		endMappingsKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_EndPathsKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		endPathsKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_EndPropagationsKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		endPropagationsKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_EndSubclauseKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		endSubclauseKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_EndTransformationsKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		endTransformationsKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_EndTypesKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		endTypesKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_ErrorBehaviorKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		errorBehaviorKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_ErrorEventKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		errorEventKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_ErrorPathKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		errorPathKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_ErrorPropagationsKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		errorPropagationsKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_ErrorSinkKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		errorSinkKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_ErrorSourceKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		errorSourceKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_ErrorTypesKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		errorTypesKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_ModeMappingsKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		modeMappingsKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_PropagationPathsKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		propagationPathsKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_PropagationPointKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		propagationPointKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_RecoverEventKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		recoverEventKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_RepairEventKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		repairEventKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_SameStateKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		sameStateKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_TypeMappingsKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		typeMappingsKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_TypeSetKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		typeSetKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_TypeTransformationsKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		typeTransformationsKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_UseBehaviorKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		useBehaviorKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_UseMappingsKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		useMappingsKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_UseTransformationsKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		useTransformationsKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_UseTypeEquivalenceKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		useTypeEquivalenceKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_UseTypesKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		useTypesKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
}