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
package org.osate.xtext.aadl2.ui.contentassist;

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.jface.viewers.StyledString
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.osate.aadl2.AadlInteger
import org.osate.aadl2.AbstractFeature
import org.osate.aadl2.AbstractPrototype
import org.osate.aadl2.Access
import org.osate.aadl2.AccessConnection
import org.osate.aadl2.AccessConnectionEnd
import org.osate.aadl2.AccessSpecification
import org.osate.aadl2.BasicProperty
import org.osate.aadl2.BusPrototype
import org.osate.aadl2.Classifier
import org.osate.aadl2.ClassifierValue
import org.osate.aadl2.ComponentCategory
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.ComponentImplementationReference
import org.osate.aadl2.ComponentPrototype
import org.osate.aadl2.ComponentPrototypeActual
import org.osate.aadl2.ComponentPrototypeBinding
import org.osate.aadl2.ComponentType
import org.osate.aadl2.ConnectedElement
import org.osate.aadl2.Connection
import org.osate.aadl2.DataAccess
import org.osate.aadl2.DataPort
import org.osate.aadl2.DataPrototype
import org.osate.aadl2.DataSubcomponent
import org.osate.aadl2.DevicePrototype
import org.osate.aadl2.EndToEndFlow
import org.osate.aadl2.EndToEndFlowSegment
import org.osate.aadl2.EventDataPort
import org.osate.aadl2.Feature
import org.osate.aadl2.FeatureConnection
import org.osate.aadl2.FeatureConnectionEnd
import org.osate.aadl2.FeatureGroup
import org.osate.aadl2.FeatureGroupConnection
import org.osate.aadl2.FeatureGroupConnectionEnd
import org.osate.aadl2.FeatureGroupPrototype
import org.osate.aadl2.FeatureGroupPrototypeActual
import org.osate.aadl2.FeatureGroupPrototypeBinding
import org.osate.aadl2.FeatureGroupType
import org.osate.aadl2.FeaturePrototypeReference
import org.osate.aadl2.Flow
import org.osate.aadl2.FlowSegment
import org.osate.aadl2.FlowSpecification
import org.osate.aadl2.ImplementationExtension
import org.osate.aadl2.InternalFeature
import org.osate.aadl2.MemoryPrototype
import org.osate.aadl2.ModalElement
import org.osate.aadl2.ModalPath
import org.osate.aadl2.ModeBinding
import org.osate.aadl2.ModeTransition
import org.osate.aadl2.ModeTransitionTrigger
import org.osate.aadl2.PackageSection
import org.osate.aadl2.Parameter
import org.osate.aadl2.ParameterConnection
import org.osate.aadl2.ParameterConnectionEnd
import org.osate.aadl2.Port
import org.osate.aadl2.PortConnection
import org.osate.aadl2.PortConnectionEnd
import org.osate.aadl2.PortProxy
import org.osate.aadl2.ProcessPrototype
import org.osate.aadl2.ProcessorPrototype
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyConstant
import org.osate.aadl2.PropertySet
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.SubprogramCall
import org.osate.aadl2.SubprogramGroupPrototype
import org.osate.aadl2.SubprogramPrototype
import org.osate.aadl2.ThreadGroupPrototype
import org.osate.aadl2.ThreadPrototype
import org.osate.aadl2.TypeExtension
import org.osate.aadl2.VirtualBusPrototype
import org.osate.aadl2.VirtualProcessorPrototype
import org.osate.aadl2.modelsupport.util.AadlUtil
import org.osate.annexsupport.AnnexContentAssistRegistry
import org.osate.annexsupport.AnnexRegistry
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess

/**
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on
 * how to customize content assistant
 */
class Aadl2ProposalProvider extends AbstractAadl2ProposalProvider {
	@Inject extension Aadl2GrammarAccess
	
	var package AnnexContentAssistRegistry annexContentAssistRegistry

	def protected void initAnnexContentAssistRegistry() {
		if (annexContentAssistRegistry === null) {
			annexContentAssistRegistry = AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_CONTENT_ASSIST_EXT_ID) as AnnexContentAssistRegistry
		}
	}

	override completeDefaultAnnexSubclause_SourceText(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val annexName = AadlUtil.getContainingAnnex(model)?.name
		if (annexName !== null) {
			if (annexContentAssistRegistry === null) {
				initAnnexContentAssistRegistry
			}
			val contentAssist = annexContentAssistRegistry?.getAnnexContentAssist(annexName)
			if (contentAssist !== null) {
				val results = contentAssist.annexCompletionSuggestions(model, context.offset)
				super.completeDefaultAnnexLibrary_SourceText(model, assignment, context, acceptor)
				val prefix = context.prefix
				results.forEach[acceptor.accept(createCompletionProposal(prefix + it, new StyledString(it), null, context))]
			}
		}
	}

	override completeDefaultAnnexLibrary_SourceText(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		completeDefaultAnnexSubclause_SourceText(model, assignment, context, acceptor)
	}
	
	override completePublicPackageSection_ImportedUnit(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterImport(model)
		])
	}
	
	override completePrivatePackageSection_ImportedUnit(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterImport(model)
		])
	}
	
	override completePropertySet_ImportedUnit(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterImport(model)
		])
	}
	
	def private filterImport(IEObjectDescription objDesc, EObject model){
	
		val proposedObj = EcoreUtil.resolve(objDesc.EObjectOrProxy, model)
		val importedUnits =
			switch model {
				PackageSection: model.importedUnits
				PropertySet: model.importedUnits
			}

		val sameObj =
			switch model {
				PackageSection: model.eContainer == proposedObj
				PropertySet: model == proposedObj
			}
			
		val predeclared =
			switch proposedObj {
				PropertySet: AadlUtil.isPredeclaredPropertySet(proposedObj.fullName)
				default : false
			}	

		!sameObj &&	!predeclared && !importedUnits.exists[ it == proposedObj]
	}
	
	override completeTypeExtension_Extended(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model)
			val proposedCategory = (proposedObj as ComponentType).category
			val typeExtContainer = (model as TypeExtension).eContainer as ComponentType
			proposedObj != typeExtContainer && 
				(proposedCategory == typeExtContainer.category || proposedCategory == ComponentCategory.ABSTRACT) 
		])
	}
	
	override completeRealization_Implemented(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedCategory =  (EcoreUtil.resolve(EObjectOrProxy, model)as ComponentType).category
			val modelCategory = (model as ComponentImplementation).category
			proposedCategory == modelCategory || proposedCategory == ComponentCategory.ABSTRACT 
		])
	}
	
	override completeImplementationExtension_Extended(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model)
			val proposedCategory = (proposedObj as ComponentImplementation).category
			val containerType = (model as ImplementationExtension).eContainer as ComponentImplementation
			(proposedObj != containerType) && 
				(proposedCategory == containerType.category || proposedCategory == ComponentCategory.ABSTRACT) 
		])
	}
	
	override completeGroupExtension_Extended(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val container = model.eContainer
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model) as FeatureGroupType

			switch proposedObj {
				case proposedObj == container : false
				case proposedObj.inverse === null : true
				case proposedObj.allFeatures.nullOrEmpty : false 
				default : true
			}
		])
	}
	
	override completeFeatureGroupType_Inverse(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model) as FeatureGroupType 
			if (proposedObj == model) false else proposedObj.inverse === null
		])
	}
	
	override completeFeatureGroup_FeatureType(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model)
			val featureGroupModel = model as FeatureGroup
			
			if (featureGroupModel.inverse) {
				switch proposedObj {
					FeatureGroupPrototype : true
					FeatureGroupType : proposedObj.inverse === null
					default : false
				}
			} else true
		])
	}
	
	def private filterFeatureRefined(IEObjectDescription objDesc, EObject model){
		val proposedObj = EcoreUtil.resolve(objDesc.EObjectOrProxy, model)
		!((model as ComponentType).ownedFeatures).exists([proposedObj == refined]);
	}
	
	override completeDataPort_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterFeatureRefined(model)
		])
	}
	
	override completeEventDataPort_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterFeatureRefined(model)
		])
	}
	
	override completeEventPort_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterFeatureRefined(model)
		])
	}
	
	override completeFeatureGroup_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterFeatureRefined(model)
		])
	}
	
	override completeParameter_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterFeatureRefined(model)
		])
	}
	
	override completeSubprogramAccess_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterFeatureRefined(model)
		])
	}
	
	override completeSubprogramGroupAccess_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterFeatureRefined(model)
		])
	}
	
	override completeBusAccess_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterFeatureRefined(model)
		])
	}
	
	override completeDataAccess_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterFeatureRefined(model)
		])
	}
	
	override completeAbstractFeature_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterFeatureRefined(model)
		])
	}

	def private filterSubComponentRefined(IEObjectDescription objDesc, EObject model){
		val proposedObj = EcoreUtil.resolve(objDesc.EObjectOrProxy, model)
		!((model as ComponentImplementation).ownedSubcomponents).exists([proposedObj == refined]);
	}

	override completeAbstractSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterSubComponentRefined(model)
		])
	}
	
	override completeSystemSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterSubComponentRefined(model)
		])
	}
	
	override completeProcessSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterSubComponentRefined(model)
		])
	}
	
	override completeThreadGroupSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterSubComponentRefined(model)
		])
	}
	
	override completeThreadSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterSubComponentRefined(model)
		])
	}
	
	override completeSubprogramSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterSubComponentRefined(model)
		])
	}
	
	override completeSubprogramGroupSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterSubComponentRefined(model)
		])
	}
	
	override completeProcessorSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterSubComponentRefined(model)
		])
	}
	
	override completeVirtualProcessorSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterSubComponentRefined(model)
		])
	}
	
	override completeDeviceSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterSubComponentRefined(model)
		])
	}
	
	override completeMemorySubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterSubComponentRefined(model)
		])
	}
	
	override completeBusSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterSubComponentRefined(model)
		])
	}
	
	override completeVirtualBusSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterSubComponentRefined(model)
		])
	}
	
	override completeDataSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterSubComponentRefined(model)
		])
	}

	def private filterPrototypeRefined(IEObjectDescription objDesc, EObject model){
		val proposedObj = EcoreUtil.resolve(objDesc.EObjectOrProxy, model)
		!((model as Classifier).ownedPrototypes).exists([proposedObj == refined]);
	}

	override completeAbstractPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterPrototypeRefined(model)
		])
	}
	
	override completeBusPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterPrototypeRefined(model)
		])
	}
	
	override completeDataPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterPrototypeRefined(model)
		])
	}
	
	override completeDevicePrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterPrototypeRefined(model)
		])
	}
	
	override completeMemoryPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterPrototypeRefined(model)
		])
	}
	
	override completeProcessPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterPrototypeRefined(model)
		])
	}
	
	override completeProcessorPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterPrototypeRefined(model)
		])
	}
	
	override completeSubprogramPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterPrototypeRefined(model)
		])
	}
	
	override completeSubprogramGroupPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterPrototypeRefined(model)
		])
	}
	
	override completeSystemPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterPrototypeRefined(model)
		])
	}
	
	override completeThreadPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterPrototypeRefined(model)
		])
	}
	
	override completeThreadGroupPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterPrototypeRefined(model)
		])
	}
	
	override completeVirtualBusPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterPrototypeRefined(model)
		])
	}
	
	override completeVirtualProcessorPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterPrototypeRefined(model)
		])
	}
	
	override completeFeatureGroupPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterPrototypeRefined(model)
		])
	}
	
	override completeFeaturePrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterPrototypeRefined(model)
		])
	}

	def private filterConnectionRefined(IEObjectDescription objDesc, EObject model){
		val proposedObj = EcoreUtil.resolve(objDesc.EObjectOrProxy, model)
		!((model as ComponentImplementation).ownedConnections).exists([proposedObj == refined]);
	}
	
	override completePortConnection_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterConnectionRefined(model)
		])
	}

	override completeAccessConnection_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterConnectionRefined(model)
		])
	}
	
	override completeFeatureGroupConnection_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterConnectionRefined(model)
		])
	}
	
	override completeFeatureConnection_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterConnectionRefined(model)
		])
	}
	
	override completeParameterConnection_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterConnectionRefined(model)
		])
	}
	
	def private filterInModeOrTransition(IEObjectDescription objDesc, EObject model){
		val proposedObj = EcoreUtil.resolve(objDesc.EObjectOrProxy, model)
		!(model as ModalPath).inModeOrTransitions.exists([it == proposedObj])
	}
	
	override completePortConnection_InModeOrTransition(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterInModeOrTransition(model)
		])
	}
	
	override completeAccessConnection_InModeOrTransition(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterInModeOrTransition(model)
		])
	}
	
	override completeFeatureGroupConnection_InModeOrTransition(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterInModeOrTransition(model)
		])
	}
	
	override completeFeatureConnection_InModeOrTransition(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterInModeOrTransition(model)
		])
	}
	
	override completeParameterConnection_InModeOrTransition(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterInModeOrTransition(model)
		])
	}
	
	override completeEndToEndFlow_InModeOrTransition(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterInModeOrTransition(model)
		])
	}
	
	def private filterInMode(IEObjectDescription objDesc, EObject model){
		val proposedObj = EcoreUtil.resolve(objDesc.EObjectOrProxy, model)
		!(model as ModalElement).inModes.exists([it == proposedObj])
	}
	
	override completeSubprogramCallSequence_InMode(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterInMode(model)
		])
	}
	
	override completeDefaultAnnexSubclause_InMode(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterInMode(model)
		])
	}
	
	override completeEndToEndFlow_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model)
			!(model as ComponentImplementation).ownedEndToEndFlows.exists([proposedObj == refined])
		])
	}
	
	override completeFlowSpecRefinement_Refined(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model)
			!(model as ComponentType).ownedFlowSpecifications.exists([proposedObj == refined])
		])
	}
	
	override completeModeTransition_Destination(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model)
			proposedObj != (model as ModeTransition).source
		])
	}
	
	override completeQCReference_Classifier(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model);
			!((model as Property).appliesTos).filter(ClassifierValue).exists([proposedObj == classifier]);
		])
	}
	
	override completeArraySize_SizeProperty(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model)
			val propertyType =
				switch proposedObj{
					BasicProperty: {
						proposedObj.propertyType
					}
					PropertyConstant: {
						proposedObj.propertyType
					}
					default: null
				}
			if( propertyType ?: propertyType instanceof AadlInteger)
				(propertyType as AadlInteger).unitsType === null
			else false
		])
	}
	
	override completeComponentImplementationReference_Implementation(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model) as ComponentImplementation;
			val modelSubComp = model as Subcomponent
 			modelSubComp.componentType ?: modelSubComp.componentType == proposedObj.type
				&& modelSubComp.componentImplementation === null 
		])
	}


	def private filterProtoTypeBindingFormal(IEObjectDescription objDesc, EObject model){
		val proposedObj = EcoreUtil.resolve(objDesc.EObjectOrProxy, model)
		switch model {
			Classifier : {
				!(model.ownedPrototypeBindings).exists([formal == proposedObj])
			}
			ComponentImplementationReference : {
				!(model.ownedPrototypeBindings).exists([formal == proposedObj])
			}
			ComponentPrototypeActual : {
				!(model.bindings).exists([formal == proposedObj])
			}
			FeatureGroupPrototypeActual : {
				!(model.bindings).exists[formal == proposedObj]
			}
			Subcomponent : {
				!(model.ownedPrototypeBindings).exists[formal == proposedObj]
			}
			default : {
				true
			}
		}
	}

	override completeFeatureGroupPrototypeBinding_Formal(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterProtoTypeBindingFormal(model)
		])
	}
	
	override completeFeaturePrototypeBinding_Formal(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterProtoTypeBindingFormal(model)
		])
	}
	
	override completeComponentPrototypeBinding_Formal(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterProtoTypeBindingFormal(model)
		])
	}
	
	override completePortSpecification_Classifier(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedCategory = (EcoreUtil.resolve(EObjectOrProxy, model) as ComponentClassifier).category
			proposedCategory == ComponentCategory.DATA || proposedCategory == ComponentCategory.ABSTRACT
		])
	}
	
	override completeAccessSpecification_Classifier(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val modelCategory = ComponentCategory.getByName((model as AccessSpecification).category.getName)
			val proposedCategory = (EcoreUtil.resolve(EObjectOrProxy, model) as ComponentClassifier).category
			proposedCategory == modelCategory || proposedCategory == ComponentCategory.ABSTRACT
		])
	}
	
	

	def private deriveCategory(ComponentPrototype prototype){
		switch prototype {
			AbstractPrototype : ComponentCategory.ABSTRACT 
			BusPrototype : ComponentCategory.BUS
			DataPrototype : ComponentCategory.DATA
			DevicePrototype : ComponentCategory.DEVICE
			MemoryPrototype : ComponentCategory.MEMORY
			ProcessPrototype : ComponentCategory.PROCESS
			ProcessorPrototype : ComponentCategory.PROCESSOR
			SubprogramPrototype : ComponentCategory.SUBPROGRAM
			SubprogramGroupPrototype: ComponentCategory.SUBPROGRAM_GROUP
			ThreadPrototype : ComponentCategory.THREAD
			ThreadGroupPrototype : ComponentCategory.THREAD_GROUP
			VirtualBusPrototype : ComponentCategory.VIRTUAL_BUS
			VirtualProcessorPrototype : ComponentCategory.VIRTUAL_PROCESSOR
		}
	}
	
	override completeComponentReference_SubcomponentType(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj = EcoreUtil.resolve(EObjectOrProxy, model)
			if (proposedObj == ((model as ComponentPrototypeActual).owner as ComponentPrototypeBinding).formal) false
			else {
				val proposedCategory =
					switch proposedObj {
						ComponentClassifier : proposedObj.category
						ComponentPrototype : proposedObj.deriveCategory
					}
				proposedCategory == (model as ComponentPrototypeActual).category || proposedCategory == ComponentCategory.ABSTRACT
			}
		])
	}
	
	override completeFeatureGroupPrototypeActual_FeatureType(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			EcoreUtil.resolve(EObjectOrProxy, model) != (model as FeatureGroupPrototypeBinding).formal
		])
	}
	
	override completeFeaturePrototypeReference_Prototype(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			EcoreUtil.resolve(EObjectOrProxy, model) != (model as FeaturePrototypeReference).prototype
		])
	}
	
	override completeModeRef_ParentMode(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj = EcoreUtil.resolve(EObjectOrProxy, model)
			!(model as Subcomponent).ownedModeBindings.exists([proposedObj == parentMode])
		])
	}
	
	override completeModeRef_DerivedMode(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj = EcoreUtil.resolve(EObjectOrProxy, model)
			val owningSubComponent = (model as ModeBinding).owner as Subcomponent
			!owningSubComponent.ownedModeBindings.exists([proposedObj == it.derivedMode])
		])
	}

	def private filterTriggerContext(IEObjectDescription objDesc, EObject model){
		val proposedObj = EcoreUtil.resolve(objDesc.EObjectOrProxy, model)
		switch proposedObj{
			Subcomponent : true
			FeatureGroup : true
			SubprogramCall : true
			default : false
		}
	}
	
	
	def private filterTriggerPort(IEObjectDescription objDesc, ModeTransitionTrigger model){
		if (model.context === null) true 
		else {
			val proposedObj = EcoreUtil.resolve(objDesc.EObjectOrProxy, model)
			val abstractFeatureOrPort = proposedObj instanceof AbstractFeature || proposedObj instanceof Port
			switch model.context {
				Subcomponent : abstractFeatureOrPort
				FeatureGroup : abstractFeatureOrPort
				SubprogramCall : abstractFeatureOrPort
				default : false
			}
		}
	}
	
	override completeTrigger_Context(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterTriggerContext(model)
		])
	}
	
	override completeTrigger_TriggerPort(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			switch model {
				ModeTransition : true
				ModeTransitionTrigger : filterTriggerPort(model)
				default : false
			}
		])
	}
	
	override completeConnectedElement_Context(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			filterConnectionContext(model as Connection)
		])
	}
	
	override completeConnectedElement_ConnectionEnd(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			switch model {
				Connection : filterConnectionContext(model)
				ConnectedElement : filterConnectionEnd(model)
				default : false
			}
		])
	}

	def private filterConnectionContext(IEObjectDescription objDesc, Connection model){
		val proposedObj = EcoreUtil.resolve(objDesc.EObjectOrProxy, model)
		switch model{
			AccessConnection : {
				switch proposedObj {
					Subcomponent : true
					FeatureGroup : true
					SubprogramCall : true
					AccessConnectionEnd : true
					default : false
				}
			}
			FeatureConnection : {
				switch proposedObj {
					Subcomponent : true
					FeatureGroup : true
					SubprogramCall : true
					FeatureConnectionEnd : true
					default : false
				}
			}
			FeatureGroupConnection :{
				switch proposedObj {
					Subcomponent : true
					FeatureGroup : true
					FeatureGroupConnectionEnd : true
					default : false
				}
			}
			ParameterConnection : {
				switch proposedObj {
					Parameter : true
					DataPort : true
					EventDataPort : true
					SubprogramCall : true
					FeatureGroup : true
					ParameterConnectionEnd : true
					default : false
				}
			}
			PortConnection : {
				switch proposedObj {
					FeatureGroup : true
					SubprogramCall : true
					Subcomponent : true
					DataPort : true
					EventDataPort : true
					PortConnectionEnd : true
					default : false
				}
			}
		}
	}


	def private filterConnectionEnd(IEObjectDescription objDesc, ConnectedElement model){
		val proposedObj = EcoreUtil.resolve(objDesc.EObjectOrProxy, model)
		switch model.owner{
			AccessConnection : {
				switch model.context {
					case null : proposedObj instanceof AccessConnectionEnd
					Subcomponent : proposedObj instanceof Access
					FeatureGroup : proposedObj instanceof Access
					SubprogramCall : proposedObj instanceof Access
					default : false
				}
			}
			FeatureConnection : {
				switch model.context {
					case null : proposedObj instanceof FeatureConnectionEnd
					Subcomponent : proposedObj instanceof Feature
					FeatureGroup : proposedObj instanceof Feature
					SubprogramCall : proposedObj instanceof Feature
					default : false
				}
			}
			FeatureGroupConnection :{
				switch model.context {
					case null : proposedObj instanceof FeatureGroupConnectionEnd
					Subcomponent : proposedObj instanceof FeatureGroupConnectionEnd
					FeatureGroup : proposedObj instanceof FeatureGroupConnectionEnd
					default : false
				}
				
			}
			ParameterConnection : {
				switch model.context {
					case null : proposedObj instanceof ParameterConnectionEnd
					Parameter : proposedObj instanceof DataSubcomponent
					DataPort : proposedObj instanceof DataSubcomponent
					EventDataPort : proposedObj instanceof DataSubcomponent
					SubprogramCall : proposedObj instanceof Parameter
					FeatureGroup : proposedObj instanceof ParameterConnectionEnd
					default : false
				}
			}
			PortConnection : {
				switch model.context {
					case null : proposedObj instanceof PortConnectionEnd
					FeatureGroup : {
						proposedObj instanceof ParameterConnectionEnd ||
						proposedObj instanceof InternalFeature ||
						proposedObj instanceof PortProxy
					}
					SubprogramCall : {
						proposedObj instanceof ParameterConnectionEnd ||
						proposedObj instanceof InternalFeature ||
						proposedObj instanceof PortProxy
					}
					DataSubcomponent : proposedObj instanceof DataSubcomponent
					Subcomponent : {
						proposedObj instanceof Port ||
						proposedObj instanceof DataAccess
					}
					DataPort : proposedObj instanceof DataSubcomponent
					EventDataPort : proposedObj instanceof DataSubcomponent
					default : false
				}
			}
		}
	}
	
	override completeFlowEnd_Context(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model)
			proposedObj instanceof FeatureGroup
		])
	}

	override completeFlowEnd_Feature(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model)
			switch proposedObj{
				DataAccess : true
				AbstractFeature : true
				FeatureGroup : true
				Parameter : true
				Port : true
				default : false
			}
		])
	}
	
	override completeSubcomponentFlow_Context(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj = EcoreUtil.resolve(EObjectOrProxy, model)
			proposedObj instanceof Subcomponent
		])
	}
	
	override completeSubcomponentFlow_FlowElement(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
		val proposedObj = EcoreUtil.resolve(EObjectOrProxy, model)
			switch model{
				Flow, FlowSegment case model.context === null : proposedObj instanceof DataAccess || proposedObj instanceof Subcomponent
				FlowSegment case model.context instanceof Subcomponent : proposedObj instanceof FlowSpecification
				default: false
			}
		])
	}
	
	
	override completeConnectionFlow_FlowElement(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model)
			proposedObj instanceof Connection
		])
	}
	
	override completeETESubcomponentFlow_Context(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model)
			proposedObj instanceof Subcomponent
		])
	}

	override completeETESubcomponentFlow_FlowElement(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model)
			switch model{
				EndToEndFlow, EndToEndFlowSegment case model.context === null : {
					proposedObj instanceof DataAccess || 
					proposedObj instanceof Subcomponent ||
					proposedObj instanceof EndToEndFlow
				}
				EndToEndFlowSegment case model.context instanceof Subcomponent : proposedObj instanceof FlowSpecification
				default: false
			}
		])
	}
	
	override completeETEConnectionFlow_FlowElement(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment.terminal as CrossReference, context, acceptor, [ 
			val proposedObj =  EcoreUtil.resolve(EObjectOrProxy, model)
			proposedObj instanceof Connection
		])
	}
	
	override complete_AbstractImplementationKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		abstractImplementationKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_BusAccessKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		busAccessKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_BusImplementationKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		busImplementationKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_DataAccessKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		dataAccessKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_DataImplementationKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		dataImplementationKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_DataPortKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		dataPortKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_DeviceImplementationKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		deviceImplementationKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_EndToEndFlowKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		endToEndFlowKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_EventDataKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		eventDataKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_EventDataPortKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		eventDataPortKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_EventPortKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		eventPortKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_FeatureGroupKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		featureGroupKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_InternalFeaturesKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		internalFeaturesKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_InverseOfKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		inverseOfKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_ListOfKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		listOfKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_MemoryImplementationKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		memoryImplementationKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_ProcessImplementationKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		processImplementationKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_ProcessorFeaturesKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		processorFeaturesKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_ProcessorImplementationKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		processorImplementationKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_RangeOfKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		rangeOfKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_RefinedToKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		refinedToKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_RequiresModesKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		requiresModesKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_SubprogramAccessKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		subprogramAccessKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_SubprogramGroupKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		subprogramGroupKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_SubprogramGroupAccessKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		subprogramGroupAccessKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_SubprogramGroupImplementationKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		subprogramGroupImplementationKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_SubprogramImplementationKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		subprogramImplementationKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_SystemImplementationKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		systemImplementationKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_ThreadGroupKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		threadGroupKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_ThreadGroupImplementationKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		threadGroupImplementationKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_ThreadImplementationKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		threadImplementationKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_VirtualBusKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		virtualBusKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_VirtualBusImplementationKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		virtualBusImplementationKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_VirtualProcessorKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		virtualProcessorKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
	
	override complete_VirtualProcessorImplementationKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		virtualProcessorImplementationKeywordsAccess.group.createKeywordProposal(context, acceptor)
	}
}