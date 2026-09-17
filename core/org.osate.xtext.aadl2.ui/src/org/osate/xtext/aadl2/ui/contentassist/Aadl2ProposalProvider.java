/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.AccessConnectionEnd;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentImplementationReference;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureConnection;
import org.osate.aadl2.FeatureConnectionEnd;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FeatureGroupConnectionEnd;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototypeReference;
import org.osate.aadl2.Flow;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.ParameterConnection;
import org.osate.aadl2.ParameterConnectionEnd;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.PortConnectionEnd;
import org.osate.aadl2.PortProxy;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.annexsupport.AnnexContentAssistRegistry;
import org.osate.annexsupport.AnnexRegistry;

import com.google.common.base.Predicate;

/**
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on
 * how to customize content assistant
 */
public class Aadl2ProposalProvider extends AbstractAadl2ProposalProvider {
	AnnexContentAssistRegistry annexContentAssistRegistry;

	protected void initAnnexContentAssistRegistry() {
		if (annexContentAssistRegistry == null) {
			annexContentAssistRegistry = (AnnexContentAssistRegistry) AnnexRegistry
					.getRegistry(AnnexRegistry.ANNEX_CONTENT_ASSIST_EXT_ID);
		}
	}

	/**
	 * Look up the cross reference of the given assignment, keeping only the proposals accepted by the filter. The
	 * filter is the Guava <code>Predicate</code> required by the Xtext content assist API.
	 */
	private void lookupCrossReference(Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor, Predicate<IEObjectDescription> filter) {
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, filter);
	}

	@Override
	public void completeDefaultAnnexSubclause_SourceText(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		var containingAnnex = AadlUtil.getContainingAnnex(model);
		var annexName = containingAnnex == null ? null : containingAnnex.getName();
		if (annexName != null) {
			if (annexContentAssistRegistry == null) {
				initAnnexContentAssistRegistry();
			}
			var contentAssist = annexContentAssistRegistry == null ? null
					: annexContentAssistRegistry.getAnnexContentAssist(annexName);
			if (contentAssist != null) {
				var results = contentAssist.annexCompletionSuggestions(model, context.getOffset());
				super.completeDefaultAnnexLibrary_SourceText(model, assignment, context, acceptor);
				var prefix = context.getPrefix();
				results.forEach(result -> acceptor
						.accept(createCompletionProposal(prefix + result, new StyledString(result), null, context)));
			}
		}
	}

	@Override
	public void completeDefaultAnnexLibrary_SourceText(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		completeDefaultAnnexSubclause_SourceText(model, assignment, context, acceptor);
	}

	@Override
	public void completePublicPackageSection_ImportedUnit(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterImport(objDesc, model));
	}

	@Override
	public void completePrivatePackageSection_ImportedUnit(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterImport(objDesc, model));
	}

	@Override
	public void completePropertySet_ImportedUnit(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterImport(objDesc, model));
	}

	private boolean filterImport(IEObjectDescription objDesc, EObject model) {
		var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
		List<ModelUnit> importedUnits;
		boolean sameObj;
		if (model instanceof PackageSection packageSection) {
			importedUnits = packageSection.getImportedUnits();
			sameObj = packageSection.eContainer() == proposedObj;
		} else {
			var propertySet = (PropertySet) model;
			importedUnits = propertySet.getImportedUnits();
			sameObj = propertySet == proposedObj;
		}
		var predeclared = proposedObj instanceof PropertySet proposedPropertySet
				&& AadlUtil.isPredeclaredPropertySet(proposedPropertySet.getFullName());
		return !sameObj && !predeclared && importedUnits.stream().noneMatch(unit -> unit == proposedObj);
	}

	@Override
	public void completeTypeExtension_Extended(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			var proposedCategory = ((ComponentType) proposedObj).getCategory();
			var typeExtContainer = (ComponentType) model.eContainer();
			return proposedObj != typeExtContainer && (proposedCategory == typeExtContainer.getCategory()
					|| proposedCategory == ComponentCategory.ABSTRACT);
		});
	}

	@Override
	public void completeRealization_Implemented(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedCategory = ((ComponentType) EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model))
					.getCategory();
			var modelCategory = ((ComponentImplementation) model).getCategory();
			return proposedCategory == modelCategory || proposedCategory == ComponentCategory.ABSTRACT;
		});
	}

	@Override
	public void completeImplementationExtension_Extended(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			var proposedCategory = ((ComponentImplementation) proposedObj).getCategory();
			var containerType = (ComponentImplementation) model.eContainer();
			return proposedObj != containerType && (proposedCategory == containerType.getCategory()
					|| proposedCategory == ComponentCategory.ABSTRACT);
		});
	}

	@Override
	public void completeGroupExtension_Extended(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var container = model.eContainer();
			var proposedObj = (FeatureGroupType) EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			if (proposedObj == container) {
				return false;
			}
			if (proposedObj.getInverse() == null) {
				return true;
			}
			var allFeatures = proposedObj.getAllFeatures();
			return allFeatures != null && !allFeatures.isEmpty();
		});
	}

	@Override
	public void completeFeatureGroupType_Inverse(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = (FeatureGroupType) EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			return proposedObj != model && proposedObj.getInverse() == null;
		});
	}

	@Override
	public void completeFeatureGroup_FeatureType(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			if (!((FeatureGroup) model).isInverse()) {
				return true;
			}
			if (proposedObj instanceof FeatureGroupPrototype) {
				return true;
			}
			return proposedObj instanceof FeatureGroupType featureGroupType && featureGroupType.getInverse() == null;
		});
	}

	private boolean filterFeatureRefined(IEObjectDescription objDesc, EObject model) {
		var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
		return ((ComponentType) model).getOwnedFeatures()
				.stream()
				.noneMatch(feature -> feature.getRefined() == proposedObj);
	}

	@Override
	public void completeDataPort_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterFeatureRefined(objDesc, model));
	}

	@Override
	public void completeEventDataPort_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterFeatureRefined(objDesc, model));
	}

	@Override
	public void completeEventPort_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterFeatureRefined(objDesc, model));
	}

	@Override
	public void completeFeatureGroup_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterFeatureRefined(objDesc, model));
	}

	@Override
	public void completeParameter_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterFeatureRefined(objDesc, model));
	}

	@Override
	public void completeSubprogramAccess_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterFeatureRefined(objDesc, model));
	}

	@Override
	public void completeSubprogramGroupAccess_Refined(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterFeatureRefined(objDesc, model));
	}

	@Override
	public void completeBusAccess_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterFeatureRefined(objDesc, model));
	}

	@Override
	public void completeDataAccess_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterFeatureRefined(objDesc, model));
	}

	@Override
	public void completeAbstractFeature_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterFeatureRefined(objDesc, model));
	}

	private boolean filterSubComponentRefined(IEObjectDescription objDesc, EObject model) {
		var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
		return ((ComponentImplementation) model).getOwnedSubcomponents()
				.stream()
				.noneMatch(subcomponent -> subcomponent.getRefined() == proposedObj);
	}

	@Override
	public void completeAbstractSubcomponent_Refined(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterSubComponentRefined(objDesc, model));
	}

	@Override
	public void completeSystemSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterSubComponentRefined(objDesc, model));
	}

	@Override
	public void completeProcessSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterSubComponentRefined(objDesc, model));
	}

	@Override
	public void completeThreadGroupSubcomponent_Refined(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterSubComponentRefined(objDesc, model));
	}

	@Override
	public void completeThreadSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterSubComponentRefined(objDesc, model));
	}

	@Override
	public void completeSubprogramSubcomponent_Refined(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterSubComponentRefined(objDesc, model));
	}

	@Override
	public void completeSubprogramGroupSubcomponent_Refined(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterSubComponentRefined(objDesc, model));
	}

	@Override
	public void completeProcessorSubcomponent_Refined(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterSubComponentRefined(objDesc, model));
	}

	@Override
	public void completeVirtualProcessorSubcomponent_Refined(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterSubComponentRefined(objDesc, model));
	}

	@Override
	public void completeDeviceSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterSubComponentRefined(objDesc, model));
	}

	@Override
	public void completeMemorySubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterSubComponentRefined(objDesc, model));
	}

	@Override
	public void completeBusSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterSubComponentRefined(objDesc, model));
	}

	@Override
	public void completeVirtualBusSubcomponent_Refined(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterSubComponentRefined(objDesc, model));
	}

	@Override
	public void completeDataSubcomponent_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterSubComponentRefined(objDesc, model));
	}

	private boolean filterPrototypeRefined(IEObjectDescription objDesc, EObject model) {
		var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
		return ((Classifier) model).getOwnedPrototypes()
				.stream()
				.noneMatch(prototype -> prototype.getRefined() == proposedObj);
	}

	@Override
	public void completeAbstractPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterPrototypeRefined(objDesc, model));
	}

	@Override
	public void completeBusPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterPrototypeRefined(objDesc, model));
	}

	@Override
	public void completeDataPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterPrototypeRefined(objDesc, model));
	}

	@Override
	public void completeDevicePrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterPrototypeRefined(objDesc, model));
	}

	@Override
	public void completeMemoryPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterPrototypeRefined(objDesc, model));
	}

	@Override
	public void completeProcessPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterPrototypeRefined(objDesc, model));
	}

	@Override
	public void completeProcessorPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterPrototypeRefined(objDesc, model));
	}

	@Override
	public void completeSubprogramPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterPrototypeRefined(objDesc, model));
	}

	@Override
	public void completeSubprogramGroupPrototype_Refined(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterPrototypeRefined(objDesc, model));
	}

	@Override
	public void completeSystemPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterPrototypeRefined(objDesc, model));
	}

	@Override
	public void completeThreadPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterPrototypeRefined(objDesc, model));
	}

	@Override
	public void completeThreadGroupPrototype_Refined(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterPrototypeRefined(objDesc, model));
	}

	@Override
	public void completeVirtualBusPrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterPrototypeRefined(objDesc, model));
	}

	@Override
	public void completeVirtualProcessorPrototype_Refined(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterPrototypeRefined(objDesc, model));
	}

	@Override
	public void completeFeatureGroupPrototype_Refined(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterPrototypeRefined(objDesc, model));
	}

	@Override
	public void completeFeaturePrototype_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterPrototypeRefined(objDesc, model));
	}

	private boolean filterConnectionRefined(IEObjectDescription objDesc, EObject model) {
		var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
		return ((ComponentImplementation) model).getOwnedConnections()
				.stream()
				.noneMatch(connection -> connection.getRefined() == proposedObj);
	}

	@Override
	public void completePortConnection_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterConnectionRefined(objDesc, model));
	}

	@Override
	public void completeAccessConnection_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterConnectionRefined(objDesc, model));
	}

	@Override
	public void completeFeatureGroupConnection_Refined(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterConnectionRefined(objDesc, model));
	}

	@Override
	public void completeFeatureConnection_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterConnectionRefined(objDesc, model));
	}

	@Override
	public void completeParameterConnection_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterConnectionRefined(objDesc, model));
	}

	private boolean filterInModeOrTransition(IEObjectDescription objDesc, EObject model) {
		var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
		return ((ModalPath) model).getInModeOrTransitions().stream().noneMatch(mode -> mode == proposedObj);
	}

	@Override
	public void completePortConnection_InModeOrTransition(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterInModeOrTransition(objDesc, model));
	}

	@Override
	public void completeAccessConnection_InModeOrTransition(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterInModeOrTransition(objDesc, model));
	}

	@Override
	public void completeFeatureGroupConnection_InModeOrTransition(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterInModeOrTransition(objDesc, model));
	}

	@Override
	public void completeFeatureConnection_InModeOrTransition(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterInModeOrTransition(objDesc, model));
	}

	@Override
	public void completeParameterConnection_InModeOrTransition(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterInModeOrTransition(objDesc, model));
	}

	@Override
	public void completeEndToEndFlow_InModeOrTransition(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterInModeOrTransition(objDesc, model));
	}

	private boolean filterInMode(IEObjectDescription objDesc, EObject model) {
		var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
		return ((ModalElement) model).getInModes().stream().noneMatch(mode -> mode == proposedObj);
	}

	@Override
	public void completeSubprogramCallSequence_InMode(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterInMode(objDesc, model));
	}

	@Override
	public void completeDefaultAnnexSubclause_InMode(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterInMode(objDesc, model));
	}

	@Override
	public void completeEndToEndFlow_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			return ((ComponentImplementation) model).getOwnedEndToEndFlows()
					.stream()
					.noneMatch(flow -> flow.getRefined() == proposedObj);
		});
	}

	@Override
	public void completeFlowSpecRefinement_Refined(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			return ((ComponentType) model).getOwnedFlowSpecifications()
					.stream()
					.noneMatch(flowSpec -> flowSpec.getRefined() == proposedObj);
		});
	}

	@Override
	public void completeModeTransition_Destination(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			return proposedObj != ((ModeTransition) model).getSource();
		});
	}

	@Override
	public void completeQCReference_Classifier(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			return ((Property) model).getAppliesTos()
					.stream()
					.noneMatch(appliesTo -> appliesTo instanceof ClassifierValue classifierValue
							&& classifierValue.getClassifier() == proposedObj);
		});
	}

	@Override
	public void completeArraySize_SizeProperty(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			PropertyType propertyType = null;
			if (proposedObj instanceof BasicProperty basicProperty) {
				propertyType = basicProperty.getPropertyType();
			} else if (proposedObj instanceof PropertyConstant propertyConstant) {
				propertyType = propertyConstant.getPropertyType();
			}
			return propertyType instanceof AadlInteger aadlInteger && aadlInteger.getUnitsType() == null;
		});
	}

	@Override
	public void completeComponentImplementationReference_Implementation(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = (ComponentImplementation) EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			var modelSubComp = (Subcomponent) model;
			return modelSubComp.getComponentType() == proposedObj.getType()
					&& modelSubComp.getComponentImplementation() == null;
		});
	}

	private boolean filterProtoTypeBindingFormal(IEObjectDescription objDesc, EObject model) {
		var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
		if (model instanceof Classifier classifier) {
			return noBindingFor(classifier.getOwnedPrototypeBindings(), proposedObj);
		}
		if (model instanceof ComponentImplementationReference implementationReference) {
			return noBindingFor(implementationReference.getOwnedPrototypeBindings(), proposedObj);
		}
		if (model instanceof ComponentPrototypeActual prototypeActual) {
			return noBindingFor(prototypeActual.getBindings(), proposedObj);
		}
		if (model instanceof FeatureGroupPrototypeActual prototypeActual) {
			return noBindingFor(prototypeActual.getBindings(), proposedObj);
		}
		if (model instanceof Subcomponent subcomponent) {
			return noBindingFor(subcomponent.getOwnedPrototypeBindings(), proposedObj);
		}
		return true;
	}

	private static boolean noBindingFor(List<? extends PrototypeBinding> bindings, EObject proposedObj) {
		return bindings.stream().noneMatch(binding -> binding.getFormal() == proposedObj);
	}

	@Override
	public void completeFeatureGroupPrototypeBinding_Formal(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterProtoTypeBindingFormal(objDesc, model));
	}

	@Override
	public void completeFeaturePrototypeBinding_Formal(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterProtoTypeBindingFormal(objDesc, model));
	}

	@Override
	public void completeComponentPrototypeBinding_Formal(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> filterProtoTypeBindingFormal(objDesc, model));
	}

	@Override
	public void completePortSpecification_Classifier(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedCategory = ((ComponentClassifier) EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model))
					.getCategory();
			return proposedCategory == ComponentCategory.DATA || proposedCategory == ComponentCategory.ABSTRACT;
		});
	}

	@Override
	public void completeAccessSpecification_Classifier(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var modelCategory = ComponentCategory.getByName(((AccessSpecification) model).getCategory().getName());
			var proposedCategory = ((ComponentClassifier) EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model))
					.getCategory();
			return proposedCategory == modelCategory || proposedCategory == ComponentCategory.ABSTRACT;
		});
	}

	@Override
	public void completeComponentReference_SubcomponentType(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			var prototypeActual = (ComponentPrototypeActual) model;
			if (proposedObj == ((ComponentPrototypeBinding) prototypeActual.getOwner()).getFormal()) {
				return false;
			}
			ComponentCategory proposedCategory = null;
			if (proposedObj instanceof ComponentClassifier componentClassifier) {
				proposedCategory = componentClassifier.getCategory();
			} else if (proposedObj instanceof ComponentPrototype componentPrototype) {
				proposedCategory = componentPrototype.getCategory();
			}
			return proposedCategory == prototypeActual.getCategory() || proposedCategory == ComponentCategory.ABSTRACT;
		});
	}

	@Override
	public void completeFeatureGroupPrototypeActual_FeatureType(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			return proposedObj != ((FeatureGroupPrototypeBinding) model).getFormal();
		});
	}

	@Override
	public void completeFeaturePrototypeReference_Prototype(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			return proposedObj != ((FeaturePrototypeReference) model).getPrototype();
		});
	}

	@Override
	public void completeModeRef_ParentMode(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			return ((Subcomponent) model).getOwnedModeBindings()
					.stream()
					.noneMatch(modeBinding -> modeBinding.getParentMode() == proposedObj);
		});
	}

	@Override
	public void completeModeRef_DerivedMode(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			var owningSubComponent = (Subcomponent) ((ModeBinding) model).getOwner();
			return owningSubComponent.getOwnedModeBindings()
					.stream()
					.noneMatch(modeBinding -> modeBinding.getDerivedMode() == proposedObj);
		});
	}

	private boolean filterTriggerPort(IEObjectDescription objDesc, ModeTransitionTrigger model) {
		var triggerContext = model.getContext();
		if (triggerContext == null) {
			return true;
		}
		var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
		var abstractFeatureOrPort = proposedObj instanceof AbstractFeature || proposedObj instanceof Port;
		var validContext = triggerContext instanceof Subcomponent || triggerContext instanceof FeatureGroup
				|| triggerContext instanceof SubprogramCall;
		return validContext && abstractFeatureOrPort;
	}

	@Override
	public void completeTrigger_Context(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			return proposedObj instanceof Subcomponent || proposedObj instanceof FeatureGroup
					|| proposedObj instanceof SubprogramCall;
		});
	}

	@Override
	public void completeTrigger_TriggerPort(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			if (model instanceof ModeTransition) {
				return true;
			}
			if (model instanceof ModeTransitionTrigger trigger) {
				return filterTriggerPort(objDesc, trigger);
			}
			return false;
		});
	}

	@Override
	public void completeConnectedElement_Context(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor,
				objDesc -> filterConnectionContext(objDesc, (Connection) model));
	}

	@Override
	public void completeConnectedElement_ConnectionEnd(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			if (model instanceof Connection connection) {
				return filterConnectionContext(objDesc, connection);
			}
			if (model instanceof ConnectedElement connectedElement) {
				return filterConnectionEnd(objDesc, connectedElement);
			}
			return false;
		});
	}

	private boolean filterConnectionContext(IEObjectDescription objDesc, Connection model) {
		var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
		if (model instanceof AccessConnection) {
			return proposedObj instanceof Subcomponent || proposedObj instanceof FeatureGroup
					|| proposedObj instanceof SubprogramCall || proposedObj instanceof AccessConnectionEnd;
		}
		if (model instanceof FeatureConnection) {
			return proposedObj instanceof Subcomponent || proposedObj instanceof FeatureGroup
					|| proposedObj instanceof SubprogramCall || proposedObj instanceof FeatureConnectionEnd;
		}
		if (model instanceof FeatureGroupConnection) {
			return proposedObj instanceof Subcomponent || proposedObj instanceof FeatureGroup
					|| proposedObj instanceof FeatureGroupConnectionEnd;
		}
		if (model instanceof ParameterConnection) {
			return proposedObj instanceof Parameter || proposedObj instanceof DataPort
					|| proposedObj instanceof EventDataPort || proposedObj instanceof SubprogramCall
					|| proposedObj instanceof FeatureGroup || proposedObj instanceof ParameterConnectionEnd;
		}
		if (model instanceof PortConnection) {
			return proposedObj instanceof FeatureGroup || proposedObj instanceof SubprogramCall
					|| proposedObj instanceof Subcomponent || proposedObj instanceof DataPort
					|| proposedObj instanceof EventDataPort || proposedObj instanceof PortConnectionEnd;
		}
		return false;
	}

	/*
	 * The context tests keep the first-match order of the connection kinds they came from. In particular a
	 * DataSubcomponent context must be answered before the general Subcomponent test below it.
	 */
	private boolean filterConnectionEnd(IEObjectDescription objDesc, ConnectedElement model) {
		var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
		var owner = model.getOwner();
		var connectionContext = model.getContext();
		if (owner instanceof AccessConnection) {
			if (connectionContext == null) {
				return proposedObj instanceof AccessConnectionEnd;
			}
			return (connectionContext instanceof Subcomponent || connectionContext instanceof FeatureGroup
					|| connectionContext instanceof SubprogramCall) && proposedObj instanceof Access;
		}
		if (owner instanceof FeatureConnection) {
			if (connectionContext == null) {
				return proposedObj instanceof FeatureConnectionEnd;
			}
			return (connectionContext instanceof Subcomponent || connectionContext instanceof FeatureGroup
					|| connectionContext instanceof SubprogramCall) && proposedObj instanceof Feature;
		}
		if (owner instanceof FeatureGroupConnection) {
			return (connectionContext == null || connectionContext instanceof Subcomponent
					|| connectionContext instanceof FeatureGroup) && proposedObj instanceof FeatureGroupConnectionEnd;
		}
		if (owner instanceof ParameterConnection) {
			if (connectionContext == null || connectionContext instanceof FeatureGroup) {
				return proposedObj instanceof ParameterConnectionEnd;
			}
			if (connectionContext instanceof Parameter || connectionContext instanceof DataPort
					|| connectionContext instanceof EventDataPort) {
				return proposedObj instanceof DataSubcomponent;
			}
			return connectionContext instanceof SubprogramCall && proposedObj instanceof Parameter;
		}
		if (owner instanceof PortConnection) {
			if (connectionContext == null) {
				return proposedObj instanceof PortConnectionEnd;
			}
			if (connectionContext instanceof FeatureGroup || connectionContext instanceof SubprogramCall) {
				return proposedObj instanceof ParameterConnectionEnd || proposedObj instanceof InternalFeature
						|| proposedObj instanceof PortProxy;
			}
			if (connectionContext instanceof DataSubcomponent || connectionContext instanceof DataPort
					|| connectionContext instanceof EventDataPort) {
				return proposedObj instanceof DataSubcomponent;
			}
			return connectionContext instanceof Subcomponent
					&& (proposedObj instanceof Port || proposedObj instanceof DataAccess);
		}
		return false;
	}

	@Override
	public void completeFlowEnd_Feature(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			return proposedObj instanceof DataAccess || proposedObj instanceof AbstractFeature
					|| proposedObj instanceof FeatureGroup || proposedObj instanceof Parameter
					|| proposedObj instanceof Port;
		});
	}

	@Override
	public void completeSubcomponentFlow_Context(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor,
				objDesc -> EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model) instanceof Subcomponent);
	}

	@Override
	public void completeSubcomponentFlow_FlowElement(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			if (model instanceof Flow || model instanceof FlowSegment segment && segment.getContext() == null) {
				return proposedObj instanceof DataAccess || proposedObj instanceof Subcomponent;
			}
			if (model instanceof FlowSegment segment && segment.getContext() instanceof Subcomponent) {
				return proposedObj instanceof FlowSpecification;
			}
			return false;
		});
	}

	@Override
	public void completeConnectionFlow_FlowElement(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor,
				objDesc -> EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model) instanceof Connection);
	}

	@Override
	public void completeETESubcomponentFlow_Context(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor,
				objDesc -> EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model) instanceof Subcomponent);
	}

	@Override
	public void completeETESubcomponentFlow_FlowElement(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor, objDesc -> {
			var proposedObj = EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model);
			if (model instanceof EndToEndFlow
					|| model instanceof EndToEndFlowSegment segment && segment.getContext() == null) {
				return proposedObj instanceof DataAccess || proposedObj instanceof Subcomponent
						|| proposedObj instanceof EndToEndFlow;
			}
			if (model instanceof EndToEndFlowSegment segment && segment.getContext() instanceof Subcomponent) {
				return proposedObj instanceof FlowSpecification;
			}
			return false;
		});
	}

	@Override
	public void completeETEConnectionFlow_FlowElement(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(assignment, context, acceptor,
				objDesc -> EcoreUtil.resolve(objDesc.getEObjectOrProxy(), model) instanceof Connection);
	}
}
