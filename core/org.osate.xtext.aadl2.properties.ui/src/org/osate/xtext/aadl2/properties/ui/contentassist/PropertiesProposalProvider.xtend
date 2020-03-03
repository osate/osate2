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
import org.osate.aadl2.util.Aadl2Util
import org.osate.aadl2.ListValue
import org.osate.aadl2.PropertyType
import org.osate.aadl2.ListType

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
				ListValue: getListElementType(model)
			}
		
		switch proposedObj:  EcoreUtil.resolve(objDesc.EObjectOrProxy, model){
		 	EnumerationLiteral: true
		 	PropertyConstant: {
		 		Aadl2Util.arePropertyTypesEqual(expectedPropertyType, proposedObj.propertyType) &&
		 		(	
		 			switch model {
						PropertyConstant: model != proposedObj
						default: true
					}
				)		 		
		 	}
		 	Property: {
		 		Aadl2Util.arePropertyTypesEqual(expectedPropertyType, proposedObj.propertyType) &&
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
	
	def private PropertyType getListElementType(ListValue listValue) {
		return getListElementType(listValue, 0)
	}
	
	def private PropertyType getListElementType(EObject model, int listCount) {
		switch model {
			ListValue: getListElementType(model.eContainer, listCount + 1)
			PropertyAssociation: getNestedElementType(model.property.propertyType as ListType, listCount)
			BasicPropertyAssociation: getNestedElementType(model.property.propertyType as ListType, listCount)
			Property: getNestedElementType(model.propertyType as ListType, listCount)
			PropertyConstant: getNestedElementType(model.propertyType as ListType, listCount)
			default: getListElementType(model.eContainer, listCount)
		}
	}
	
	def private PropertyType getNestedElementType(ListType listType, int n) {
		if (n == 1) {
			listType.elementType
		} else {
			getNestedElementType(listType.elementType as ListType, n - 1)
		}
	}
	
	def private getPropertyType(ClassifierValue model){
		EcoreUtil2.getContainerOfType(model, BasicPropertyAssociation)?.property?.propertyType ?:
			EcoreUtil2.getContainerOfType(model, PropertyAssociation)?.property?.propertyType ?:
			EcoreUtil2.getContainerOfType(model, Property)?.propertyType ?:
			EcoreUtil2.getContainerOfType(model, PropertyConstant).propertyType
	}
}