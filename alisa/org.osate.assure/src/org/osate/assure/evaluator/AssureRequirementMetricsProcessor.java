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
package org.osate.assure.evaluator;

import java.util.Collections;
import java.util.HashSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.google.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.xbase.lib.XbaseGenerated;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.Feature;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.ModelResult;
import org.osate.assure.assure.SubsystemResult;
import org.osate.categories.categories.Categories;
import org.osate.categories.categories.CategoriesPackage;
import org.osate.categories.categories.CategoryFilter;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.SystemRequirementSet;
import org.osate.reqspec.util.IReqspecGlobalReferenceFinder;
import org.osate.verify.verify.VerificationPlan;

public class AssureRequirementMetricsProcessor implements IAssureRequirementMetricsProcessor {
	private final ResourceDescriptionsProvider resourceDescriptionsProvider;

	private CategoryFilter filter;

	@Inject
	private IReqspecGlobalReferenceFinder reqSpecReferenceFinder;

	@Inject
	protected IResourceDescriptions rds;

	@Inject
	public AssureRequirementMetricsProcessor(ResourceDescriptionsProvider resourceDescriptionsProvider) {
		this.resourceDescriptionsProvider = resourceDescriptionsProvider;
	}

	@Override
	public void processCase(AssuranceCaseResult assureResult, CategoryFilter filter, IProgressMonitor monitor) {
		this.filter = filter;
		process(assureResult);
	}

	protected void _process(AssuranceCaseResult caseResult) {
		caseResult.getModelResult().forEach(this::process);
	}

	public int getTotalQualityCategoriesCount(EObject element) {
		EcoreUtil.resolveAll(element);
		var resourceDescriptions = resourceDescriptionsProvider.getResourceDescriptions(element.eResource());

		return stream(resourceDescriptions.getExportedObjectsByType(CategoriesPackage.eINSTANCE.getCategories()))
				.map(description -> (Categories) EcoreUtil.resolve(description.getEObjectOrProxy(), element))
				.filter(categories -> categories.getName().equalsIgnoreCase("quality"))
				.flatMap(categories -> categories.getCategory().stream())
				.collect(Collectors.toCollection(HashSet::new))
				.size();
	}

	protected void _process(ModelResult modelResult) {
		var targetComponent = modelResult.getTarget();
		var categoryFilter = filter;
		var metrics = modelResult.getMetrics();

		metrics.setFeaturesCount(targetComponent.getAllFeatures().size());

		var plan = modelResult.getPlan();
		EcoreUtil.resolveAll(plan);
		var verificationPlans = plan.getAssure();
		var claimRequirements = verificationPlans.stream()
				.flatMap(verificationPlan -> verificationPlan.getClaim().stream())
				.map(claim -> claim.getRequirement())
				.filter(requirement -> filterRequirement(requirement, categoryFilter))
				.collect(Collectors.toCollection(HashSet::new));
		var targetRequirements = reqSpecReferenceFinder.getSystemRequirementSets(targetComponent);

		var exceptionRequirementCount = requirements(targetRequirements)
				.filter(requirement -> filterRequirement(requirement, categoryFilter))
				.flatMap(requirement -> requirement.getCategory().stream())
				.filter(category -> EcoreUtil2.getContainerOfType(category, Categories.class)
						.getName()
						.equalsIgnoreCase("exception"))
				.collect(Collectors.toCollection(HashSet::new))
				.size();
		var mitigatesRequirementCount = requirements(targetRequirements)
				.filter(requirement -> requirement.getException() != null)
				.filter(requirement -> filterRequirement(requirement, categoryFilter))
				.count();

		Supplier<Stream<ClassifierFeature>> featuresRequiringClassifiers = () -> requirements(targetRequirements)
				.filter(requirement -> filterRequirement(requirement, categoryFilter))
				.map(Requirement::getTargetElement)
				.filter(ClassifierFeature.class::isInstance)
				.map(ClassifierFeature.class::cast)
				.filter(AssureRequirementMetricsProcessor::requiresClassifier);
		featuresRequiringClassifiers.get().forEach(EcoreUtil::resolveAll);

		metrics.setFeaturesRequiringClassifierCount((int) featuresRequiringClassifiers.get().count());
		metrics.setFeaturesWithRequiredClassifierCount((int) featuresRequiringClassifiers.get()
				.filter(AssureRequirementMetricsProcessor::hasClassifier)
				.count());
		metrics.setTotalQualityCategoryCount(getTotalQualityCategoriesCount(modelResult));
		metrics.setRequirementsCount(
				(int) requirements(targetRequirements).collect(Collectors.toCollection(HashSet::new))
						.stream()
						.filter(requirement -> filterRequirement(requirement, categoryFilter))
						.count());
		metrics.setRequirementsWithoutPlanClaimCount(
				(int) requirements(targetRequirements).collect(Collectors.toCollection(HashSet::new))
						.stream()
						.filter(requirement -> filterRequirement(requirement, categoryFilter))
						.filter(requirement -> !claimRequirements.contains(requirement))
						.count());
		metrics.setQualityCategoryRequirementsCount(requirements(targetRequirements)
				.filter(requirement -> !(requirement.getTargetElement() instanceof Feature))
				.filter(requirement -> filterRequirement(requirement, categoryFilter))
				.flatMap(requirement -> requirement.getCategory().stream())
				.filter(category -> EcoreUtil2.getContainerOfType(category, Categories.class)
						.getName()
						.equalsIgnoreCase("quality"))
				.collect(Collectors.toCollection(HashSet::new))
				.size());
		metrics.setFeaturesRequirementsCount(requirements(targetRequirements).map(Requirement::getTargetElement)
				.filter(Feature.class::isInstance)
				.map(Feature.class::cast)
				.collect(Collectors.toCollection(HashSet::new))
				.size());
		metrics.setNoVerificationPlansCount(
				(int) verificationPlans.stream().filter(AssureRequirementMetricsProcessor::hasNoClaims).count());
		metrics.setExceptionsCount((int) (exceptionRequirementCount + mitigatesRequirementCount));

		modelResult.getSubsystemResult().forEach(this::process);
	}

	protected void _process(SubsystemResult caseResult) {
		var targetSystem = caseResult.getTargetSystem();
		var categoryFilter = filter;
		var metrics = caseResult.getMetrics();

		metrics.setFeaturesCount(targetSystem.getAllFeatures().size());

		var claimResults = caseResult.getClaimResult();
		var verificationPlans = claimResults.stream()
				.map(claimResult -> claimResult.getTargetReference().getVerificationPlan())
				.toList();
		var claimRequirements = claimResults.stream()
				.flatMap(claimResult -> claimResult.getTargetReference().getVerificationPlan().getClaim().stream())
				.map(claim -> claim.getRequirement())
				.filter(requirement -> filterRequirement(requirement, categoryFilter))
				.collect(Collectors.toCollection(HashSet::new));
		var systemRequirements = reqSpecReferenceFinder.getSystemRequirementSets(targetSystem.getComponentType());

		var exceptionRequirementCount = requirements(systemRequirements)
				.filter(requirement -> filterRequirement(requirement, categoryFilter))
				.flatMap(requirement -> requirement.getCategory().stream())
				.filter(category -> EcoreUtil2.getContainerOfType(category, Categories.class)
						.getName()
						.equalsIgnoreCase("exception"))
				.collect(Collectors.toCollection(HashSet::new))
				.size();
		var mitigatesRequirementCount = requirements(systemRequirements)
				.filter(requirement -> requirement.getException() != null)
				.filter(requirement -> filterRequirement(requirement, categoryFilter))
				.count();

		Supplier<Stream<ClassifierFeature>> featuresRequiringClassifiers = () -> requirements(systemRequirements)
				.filter(requirement -> filterRequirement(requirement, categoryFilter))
				.map(Requirement::getTargetElement)
				.filter(ClassifierFeature.class::isInstance)
				.map(ClassifierFeature.class::cast)
				.filter(AssureRequirementMetricsProcessor::requiresClassifier);
		featuresRequiringClassifiers.get().forEach(EcoreUtil::resolveAll);

		metrics.setFeaturesRequiringClassifierCount((int) featuresRequiringClassifiers.get().count());
		metrics.setFeaturesWithRequiredClassifierCount((int) featuresRequiringClassifiers.get()
				.filter(AssureRequirementMetricsProcessor::hasClassifier)
				.count());
		metrics.setTotalQualityCategoryCount(getTotalQualityCategoriesCount(caseResult));
		metrics.setRequirementsCount(
				(int) requirements(systemRequirements).collect(Collectors.toCollection(HashSet::new))
						.stream()
						.filter(requirement -> filterRequirement(requirement, categoryFilter))
						.count());
		metrics.setRequirementsWithoutPlanClaimCount(
				(int) requirements(systemRequirements).collect(Collectors.toCollection(HashSet::new))
						.stream()
						.filter(requirement -> !claimRequirements.contains(requirement))
						.filter(requirement -> filterRequirement(requirement, categoryFilter))
						.count());
		metrics.setQualityCategoryRequirementsCount(requirements(systemRequirements)
				.filter(requirement -> !(requirement.getTargetElement() instanceof ClassifierFeature))
				.filter(requirement -> filterRequirement(requirement, categoryFilter))
				.flatMap(requirement -> requirement.getCategory().stream())
				.collect(Collectors.toCollection(HashSet::new))
				.size());
		metrics.setFeaturesRequirementsCount(
				requirements(systemRequirements).filter(requirement -> filterRequirement(requirement, categoryFilter))
						.map(Requirement::getTargetElement)
						.filter(ClassifierFeature.class::isInstance)
						.map(ClassifierFeature.class::cast)
						.collect(Collectors.toCollection(HashSet::new))
						.size());
		metrics.setNoVerificationPlansCount(
				(int) verificationPlans.stream().filter(AssureRequirementMetricsProcessor::hasNoClaims).count());
		metrics.setExceptionsCount((int) (exceptionRequirementCount + mitigatesRequirementCount));

		caseResult.getSubsystemResult().forEach(this::process);
	}

	public boolean filterRequirement(Requirement requirement, CategoryFilter filter) {
		if (filter == null) {
			return true;
		}
		if (filter.isAnyCategory()) {
			return !Collections.disjoint(requirement.getCategory(), filter.getCategory());
		}
		return requirement.getCategory().containsAll(filter.getCategory());
	}

	private static boolean requiresClassifier(ClassifierFeature feature) {
		return feature instanceof BusAccess || feature instanceof DataPort || feature instanceof EventDataPort
				|| feature instanceof DataAccess;
	}

	private static boolean hasClassifier(ClassifierFeature feature) {
		return switch (feature) {
		case BusAccess busAccess -> busAccess.getBusFeatureClassifier() != null;
		case DataPort dataPort -> dataPort.getDataFeatureClassifier() != null;
		case EventDataPort eventDataPort -> eventDataPort.getDataFeatureClassifier() != null;
		case DataAccess dataAccess -> dataAccess.getDataFeatureClassifier() != null;
		case null, default -> false;
		};
	}

	private static boolean hasNoClaims(VerificationPlan verificationPlan) {
		return verificationPlan.getClaim() == null || verificationPlan.getClaim().isEmpty();
	}

	private static Stream<Requirement> requirements(Iterable<SystemRequirementSet> requirementSets) {
		return stream(requirementSets).flatMap(requirementSet -> requirementSet.getRequirements().stream());
	}

	private static <T> Stream<T> stream(Iterable<T> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false);
	}

	@XbaseGenerated
	public void process(AssureResult caseResult) {
		switch (caseResult) {
		case AssuranceCaseResult assuranceCaseResult -> _process(assuranceCaseResult);
		case ModelResult modelResult -> _process(modelResult);
		case SubsystemResult subsystemResult -> _process(subsystemResult);
		case null, default -> throw new IllegalArgumentException("Unhandled parameter types: [" + caseResult + "]");
		}
	}
}
