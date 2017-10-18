/*
 * /**
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
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
package org.osate.xtext.aadl2.properties.ui.contentassist;

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.Group
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.osate.aadl2.BasicPropertyAssociation
import org.osate.aadl2.ClassifierType
import org.osate.aadl2.ClassifierValue
import org.osate.aadl2.EnumerationLiteral
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.PropertyConstant
import org.osate.aadl2.RecordValue
import org.osate.aadl2.modelsupport.util.AadlUtil
import org.osate.xtext.aadl2.properties.services.PropertiesGrammarAccess

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
class PropertiesProposalProvider extends AbstractPropertiesProposalProvider {
	@Inject extension PropertiesGrammarAccess
	
	override completeOptionalModalPropertyValue_InMode(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model)
			val propertyAssoc = model.eContainer as PropertyAssociation
			! propertyAssoc.ownedValues.map[inModes].flatten.exists[it == proposedObj]
		])
	}
	
	override completeLiteralorReferenceTerm_NamedValue(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			showCrossReference(model)
		])
	}
	
	override completeConstantValue_NamedValue(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			showCrossReference(model)
		])
	}
	
	override completeComponentClassifierTerm_Classifier(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val propertyType = AadlUtil.getBasePropertyType((model as ClassifierValue).propertyType)
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model)
			switch propertyType {
				 ClassifierType case propertyType.classifierReferences.nullOrEmpty : true
				 ClassifierType : propertyType.classifierReferences.exists([it.metaclass.isSuperTypeOf(proposedObj.eClass)])
				 default : false
			}
		])
	}

	override completeFieldPropertyAssociation_Property(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model)
			switch model {
				RecordValue: ! model.ownedFieldValues.exists[property == proposedObj]
				default: true
			}
		])
	}
	
	override complete_AppliesToKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		appliesToKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_InBindingKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		inBindingKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_InModesKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		inModesKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	//Based on example from https://blogs.itemis.com/en/xtext-hint-content-assist-for-multiple-consecutive-keywords
	def protected void createKeywordProposal(Group group, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (group !== null) {
			val proposalString = group.elements.filter(Keyword).map[value].join(" ")
			acceptor.accept(createCompletionProposal(proposalString, proposalString, getImage(group), context))
		}
	}
	
	def private showCrossReference(IEObjectDescription objDesc, EObject model){
		val expectedPropertyType = 
			switch model {
				PropertyAssociation: model.property.propertyType
				BasicPropertyAssociation: model.property.propertyType
				Property: model.propertyType
				PropertyConstant: model.propertyType
			}
		
		switch proposedObj:  EcoreUtil.resolve(objDesc.EObjectOrProxy, model){
		 	EnumerationLiteral: true
		 	PropertyConstant: {
		 		expectedPropertyType == proposedObj.propertyType &&
		 		(	
		 			switch model {
						PropertyConstant: model != proposedObj
						default: true
					}
				)		 		
		 	}
		 	Property: {
		 		expectedPropertyType == proposedObj.propertyType &&
		 		(	
		 			switch model {
						PropertyAssociation: model.property != proposedObj
						Property: model != proposedObj
						default: true
					}
				)
			}
			default: {false}
		 }
	}
	
	def private getPropertyType(ClassifierValue model){
		EcoreUtil2.getContainerOfType(model, BasicPropertyAssociation)?.property?.propertyType ?:
			EcoreUtil2.getContainerOfType(model, PropertyAssociation)?.property?.propertyType ?:
			EcoreUtil2.getContainerOfType(model, Property)?.propertyType ?:
			EcoreUtil2.getContainerOfType(model, PropertyConstant).propertyType
	}
}