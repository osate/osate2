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
package org.osate.reqspec.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.validation.Check;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemImplementation;
import org.osate.alisa.common.common.TargetType;
import org.osate.alisa.common.util.CommonUtilExtension;
import org.osate.pluginsupport.ExecuteJavaUtil;
import org.osate.reqspec.reqSpec.ContractualElement;
import org.osate.reqspec.reqSpec.DocumentSection;
import org.osate.reqspec.reqSpec.GlobalConstants;
import org.osate.reqspec.reqSpec.GlobalRequirementSet;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.IncludeGlobalRequirement;
import org.osate.reqspec.reqSpec.ReqDocument;
import org.osate.reqspec.reqSpec.ReqSpec;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.RequirementSet;
import org.osate.reqspec.reqSpec.StakeholderGoals;
import org.osate.reqspec.reqSpec.SystemRequirementSet;
import org.osate.reqspec.reqSpec.WhenCondition;
import org.osate.reqspec.util.IReqspecGlobalReferenceFinder;
import org.osate.reqspec.util.ReqSpecUtilExtension;

import com.google.inject.Inject;

/**
 * Custom validation rules.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
public class ReqSpecValidator extends AbstractReqSpecValidator {
	public static final String MISSING_STAKEHOLDER = "missingStakeholder";
	public static final String MISSING_STAKEHOLDER_GOAL = "missingStakeholderGoal";
	public static final String MULTIPLE_CLASSIFIERS = "multipleClassifiers";
	public static final String FEATURES_WITHOUT_REQUIREMENT = "featuresWithoutRequirement";
	public static final String DUPLICATE_GOAL_WITHIN_STAKEHOLDER_GOALS = "org.osate.reqspec.validation.duplicate.goal.within.stakeholdergoals";
	public static final String DUPLICATE_STAKEHOLDER_GOALS = "org.osate.reqspec.validation.duplicate.stakeholdergoals";
	public static final String REQSPEC_FOR_DIFFERS_FROM_STAKEHOLDERGOALS_FOR = "org.osate.reqspec.validation.reqspec.for.differs.from.stakeholdergoals.for";
	public static final String GOAL_REFERENCE_NOT_FOUND = "org.osate.reqspec.validation.goal.reference.not.found";
	public static final String DUPLICATE_REQUIREMENTS = "org.osate.reqspec.validation.duplicate.requirements";
	public static final String DUPLICATE_REQUIREMENT_WITHIN_REQUIREMENTS = "org.osate.reqspec.validation.duplicate.requirement.within.requirements";
	public static final String CYCLE_IN_GOAL_REFINE_HIERARCHY = "org.osate.reqspec.validation.cycle.in.goal.refine.hierarchy";
	public static final String CYCLE_IN_REQUIREMENT_REFINE_HIERARCHY = "org.osate.reqspec.validation.cycle.in.requirement.refine.hierarchy";
	public static final String ILLEGAL_OBJECT_FOR_FILETYPE_IN_DOCUMENTSECTION = "org.osate.reqspec.validation.illegal.object.for.filetype.in.documentsection";
	public static final String ILLEGAL_OBJECT_FOR_FILETYPE_IN_REQSPEC = "org.osate.reqspec.validation.illegal.object.for.filetype.in.reqspec";
	public static final String ILLEGAL_OBJECT_FOR_FILETYPE_IN_REQDOCUMENT = "org.osate.reqspec.validation.illegal.object.for.filetype.in.reqdocument";
	public static final String REQSPEC_FILE_EXT = "reqspec";
	public static final String GOALS_FILE_EXT = "goals";
	public static final String REQDOC_FILE_EXT = "reqdoc";
	public static final String GOALDOC_FILE_EXT = "goaldoc";
	public static final String CONSTANTS_FILE_EXT = "constants";
	public static final String INCORRECT_GLOBAL_REQUIREMENT_INCLUDE = "org.osate.reqspec.validation.incorrect.global.requirement.include";
	public static final String CONDITION_METHOD_NOT_FOUND = "org.osate.reqspec.validation.condition.method.not.found";
	public static final String DUPLICATE_GLOBALREQUIREMENTS = "org.osate.reqspec.validation.duplicate.globalrequirements";
	public static final String ELEMENT_TARGETTYPE = "org.osate.reqspec.validation.element.targettype";

	@Inject
	private IReqspecGlobalReferenceFinder reqSpecrefFinder;

	@Check
	public void checkMissingStakeholder(final Goal goal) {
		if (goal.getStakeholderReference().isEmpty() && goal.getRefinesReference().isEmpty()) {
			warning("Goal should have stakeholders", ReqSpecPackage.Literals.GOAL__STAKEHOLDER_REFERENCE,
					MISSING_STAKEHOLDER);
		}
	}

	@Check
	public void checkMissingGoal(final Requirement requirement) {
		if (requirement.getGoalReference().isEmpty() && requirement.getRefinesReference().isEmpty()) {
			warning("System requirement should have stakeholder goal or requirement reference",
					ReqSpecPackage.Literals.CONTRACTUAL_ELEMENT__GOAL_REFERENCE, MISSING_STAKEHOLDER_GOAL);
		}
	}

	@Check
	public void checkMultipleSystems(final ReqDocument document) {
		var classifiers = new ArrayList<ComponentClassifier>();
		for (var element : document.getContent()) {
			if (element instanceof ContractualElement contractualElement) {
				classifiers.add(ReqSpecUtilExtension.targetClassifier(contractualElement));
			}
		}
		if (classifiers.size() > 1) {
			warning("Requirements cover multiple classifiers: " + names(classifiers),
					ReqSpecPackage.Literals.REQ_DOCUMENT__CONTENT, MULTIPLE_CLASSIFIERS);
		}
	}

	@Check
	public void checkMultipleSystems(final DocumentSection section) {
		var classifiers = new ArrayList<ComponentClassifier>();
		for (var element : section.getContent()) {
			if (element instanceof ContractualElement contractualElement) {
				classifiers.add(ReqSpecUtilExtension.targetClassifier(contractualElement));
			}
		}
		if (!classifiers.isEmpty()) {
			warning("Requirements cover multiple classifiers: " + names(classifiers),
					ReqSpecPackage.Literals.DOCUMENT_SECTION__CONTENT, MULTIPLE_CLASSIFIERS);
		}
	}

	@Check
	public void checkFeatureCoverage(final SystemRequirementSet systemRequirements) {
		var classifier = systemRequirements.getTarget();
		if (classifier == null || classifier.getAllFeatures().isEmpty()) {
			return;
		}

		var uncoveredFeatures = new ArrayList<NamedElement>();
		for (var feature : classifier.getAllFeatures()) {
			var covered = systemRequirements.getRequirements()
					.stream()
					.anyMatch(requirement -> Objects.equals(requirement.getTargetElement(), feature));
			if (!covered) {
				uncoveredFeatures.add(feature);
			}
		}
		if (!uncoveredFeatures.isEmpty()) {
			warning("Features without requirement: " + names(uncoveredFeatures),
					ReqSpecPackage.Literals.REQUIREMENT_SET__REQUIREMENTS, FEATURES_WITHOUT_REQUIREMENT);
		}
	}

	@Check
	public void checkDuplicateGoal(final StakeholderGoals stakeholderGoals) {
		for (var goal : stakeholderGoals.getGoals()) {
			var duplicateCount = stakeholderGoals.getGoals()
					.stream()
					.filter(candidate -> Objects.equals(candidate.getName(), goal.getName()))
					.count();
			if (duplicateCount > 1) {
				error("Duplicate goal name '" + goal.getName() + "' in StakeholderGoals '" + stakeholderGoals.getName()
						+ "'", goal, ReqSpecPackage.Literals.CONTRACTUAL_ELEMENT__NAME,
						DUPLICATE_GOAL_WITHIN_STAKEHOLDER_GOALS, EcoreUtil.getURI(stakeholderGoals).toString());
			}
		}
	}

	@Check
	public void checkDuplicateRequirement(final RequirementSet requirementSet) {
		for (var requirement : requirementSet.getRequirements()) {
			var duplicateCount = requirementSet.getRequirements()
					.stream()
					.filter(candidate -> Objects.equals(candidate.getName(), requirement.getName()))
					.count();
			if (duplicateCount > 1) {
				error("Duplicate requirement name '" + requirement.getName() + "' in requirements '"
						+ requirementSet.getName() + "'", requirement,
						ReqSpecPackage.Literals.CONTRACTUAL_ELEMENT__NAME, DUPLICATE_REQUIREMENT_WITHIN_REQUIREMENTS,
						EcoreUtil.getURI(requirementSet).toString());
			}
		}
	}

	@Check
	public void checkSpecGoalTargetConsistency(final SystemRequirementSet systemRequirements) {
		var requirementTarget = systemRequirements.getTarget();
		var resource = systemRequirements.eResource();
		for (var requirement : systemRequirements.getRequirements()) {
			for (var goalReference : requirement.getGoalReference()) {
				Goal resolvedGoal;
				if (!goalReference.eIsProxy()) {
					resolvedGoal = goalReference;
				} else if (EcoreUtil.resolve(goalReference, resource.getResourceSet()).eIsProxy()) {
					resolvedGoal = null;
				} else {
					resolvedGoal = (Goal) EcoreUtil.resolve(goalReference, resource.getResourceSet());
				}

				if (resolvedGoal != null && ReqSpecUtilExtension.targetClassifier(resolvedGoal) != null
						&& !CommonUtilExtension.isSameorExtends(requirementTarget,
								ReqSpecUtilExtension.targetClassifier(resolvedGoal))) {
					var goalTarget = ReqSpecUtilExtension.targetClassifier(resolvedGoal);
					error("System Requirement '" + systemRequirements.getName()
							+ "' is not for the same component as the StakeholderGoals that "
							+ "holds the goal that corresponds to requirement '" + requirement.getName() + "'",
							systemRequirements, ReqSpecPackage.Literals.SYSTEM_REQUIREMENT_SET__TARGET,
							REQSPEC_FOR_DIFFERS_FROM_STAKEHOLDERGOALS_FOR, systemRequirements.getTarget().getName(),
							goalTarget.getName(), EcoreUtil.getURI(goalTarget).toString());
				}
			}
		}
	}

	@Check
	public void checkGoalForCycles(final Goal goal) {
		var path = new ArrayList<Goal>();
		path.add(goal);
		for (var index = 0; index < goal.getRefinesReference().size(); index++) {
			var refinedGoal = goal.getRefinesReference().get(index);
			path.add(refinedGoal);
			if (checkGoalForCycles(refinedGoal, path)) {
				error("A circular dependency or dependencies exists in the 'refined' hierarchy of " + goal.getName()
						+ ".", goal, ReqSpecPackage.Literals.GOAL__REFINES_REFERENCE, index,
						CYCLE_IN_GOAL_REFINE_HIERARCHY, refinedGoal.getName(),
						EcoreUtil.getURI(refinedGoal).toString());
			}
			path.removeLast();
		}
	}

	private boolean checkGoalForCycles(final Goal goal, final List<Goal> path) {
		for (var refinedGoal : goal.getRefinesReference()) {
			if (path.contains(refinedGoal)) {
				return true;
			}
		}
		for (var refinedGoal : goal.getRefinesReference()) {
			path.add(refinedGoal);
			var cycles = checkGoalForCycles(refinedGoal, path);
			path.removeLast();
			if (cycles) {
				return true;
			}
		}
		return false;
	}

	@Check
	public void checkRequirementTargetType(final Requirement requirement) {
		if (requirement.getTargetType() == TargetType.ELEMENT) {
			error("Target type of global requirement cannot be 'element'", requirement,
					ReqSpecPackage.Literals.REQUIREMENT__TARGET_TYPE, ELEMENT_TARGETTYPE);
		}
	}

	@Check
	public void checkRequirementForCycles(final Requirement requirement) {
		var path = new ArrayList<Requirement>();
		path.add(requirement);
		for (var index = 0; index < requirement.getRefinesReference().size(); index++) {
			var refinedRequirement = requirement.getRefinesReference().get(index);
			path.add(refinedRequirement);
			if (checkRequirementForCycles(refinedRequirement, path)) {
				error("A circular dependency or dependencies exists in the 'refined' hierarchy of "
						+ requirement.getName() + ".", requirement,
						ReqSpecPackage.Literals.REQUIREMENT__REFINES_REFERENCE, index,
						CYCLE_IN_REQUIREMENT_REFINE_HIERARCHY, refinedRequirement.getName(),
						EcoreUtil.getURI(refinedRequirement).toString());
			}
			path.removeLast();
		}
	}

	private boolean checkRequirementForCycles(final Requirement requirement, final List<Requirement> path) {
		for (var refinedRequirement : requirement.getRefinesReference()) {
			if (path.contains(refinedRequirement)) {
				return true;
			}
		}
		for (var refinedRequirement : requirement.getRefinesReference()) {
			path.add(refinedRequirement);
			var cycles = checkRequirementForCycles(refinedRequirement, path);
			path.removeLast();
			if (cycles) {
				return true;
			}
		}
		return false;
	}

	@Check
	public void checkCoverage(final StakeholderGoals stakeholderGoals) {
		var target = stakeholderGoals.getTarget();
		if (!(target instanceof SystemImplementation)) {
			return;
		}
		var systemRequirements = reqSpecrefFinder.getSystemRequirementSets(target);
		for (var goal : stakeholderGoals.getGoals()) {
			if (!hasRequirementForGoal(systemRequirements, goal)) {
				error("Goal " + goal.getName() + " does not have a corresponding System Requirement.", goal,
						ReqSpecPackage.Literals.CONTRACTUAL_ELEMENT__NAME);
			}
		}
	}

	private static boolean hasRequirementForGoal(final Iterable<SystemRequirementSet> requirementSets,
			final Goal goal) {
		for (var requirementSet : requirementSets) {
			for (var requirement : requirementSet.getRequirements()) {
				if (requirement.getGoalReference().stream().anyMatch(reference -> reference == goal)) {
					return true;
				}
			}
		}
		return false;
	}

	@Check
	public void checkFileTypeContents(final ReqSpec reqSpec) {
		var fileExtension = EcoreUtil.getURI(reqSpec).fileExtension().toLowerCase();
		switch (fileExtension) {
		case REQSPEC_FILE_EXT -> {
			for (var part : reqSpec.getParts()) {
				switch (part) {
				case SystemRequirementSet ignored -> {
				}
				case GlobalRequirementSet ignored -> {
				}
				case GlobalConstants ignored -> fileTypeWarning(fileExtension, "constants", part);
				default -> fileTypeWarning(fileExtension, part.getClass().getName(), part);
				}
			}
		}
		case GOALS_FILE_EXT -> {
			for (var part : reqSpec.getParts()) {
				switch (part) {
				case StakeholderGoals ignored -> {
				}
				case SystemRequirementSet ignored -> fileTypeWarning(fileExtension, "system requirements", part);
				case ReqDocument ignored -> fileTypeWarning(fileExtension, "document", part);
				case GlobalConstants ignored -> fileTypeWarning(fileExtension, "constants", part);
				default -> fileTypeWarning(fileExtension, part.getClass().getName(), part);
				}
			}
		}
		case REQDOC_FILE_EXT -> {
			for (var part : reqSpec.getParts()) {
				switch (part) {
				case ReqDocument document -> checkRequirementDocument(fileExtension, document);
				case SystemRequirementSet ignored -> fileTypeWarning(fileExtension, "system requirements", part);
				case GlobalRequirementSet ignored -> fileTypeWarning(fileExtension, "global requirements", part);
				case GlobalConstants ignored -> fileTypeWarning(fileExtension, "constants", part);
				case StakeholderGoals ignored -> fileTypeWarning(fileExtension, "stakeholder goals", part);
				default -> fileTypeWarning(fileExtension, part.getClass().getName(), part);
				}
			}
		}
		case GOALDOC_FILE_EXT -> {
			for (var part : reqSpec.getParts()) {
				switch (part) {
				case ReqDocument document -> checkGoalDocument(fileExtension, document);
				case SystemRequirementSet ignored -> fileTypeWarning(fileExtension, "system requirements", part);
				case GlobalRequirementSet ignored -> fileTypeWarning(fileExtension, "global requirements", part);
				case GlobalConstants ignored -> fileTypeWarning(fileExtension, "constants", part);
				case StakeholderGoals ignored -> fileTypeWarning(fileExtension, "stakeholder goals", part);
				default -> fileTypeWarning(fileExtension, part.getClass().getName(), part);
				}
			}
		}
		case CONSTANTS_FILE_EXT -> {
			for (var part : reqSpec.getParts()) {
				switch (part) {
				case GlobalConstants ignored -> {
				}
				case SystemRequirementSet ignored -> fileTypeWarning(fileExtension, "system requirements", part);
				case GlobalRequirementSet ignored -> fileTypeWarning(fileExtension, "global requirements", part);
				case StakeholderGoals ignored -> fileTypeWarning(fileExtension, "stakeholder goals", part);
				case ReqDocument ignored -> fileTypeWarning(fileExtension, "document", part);
				default -> fileTypeWarning(fileExtension, part.getClass().getName(), part);
				}
			}
		}
		default -> {
		}
		}
	}

	private void checkRequirementDocument(final String fileExtension, final ReqDocument document) {
		for (var element : document.getContent()) {
			switch (element) {
			case Requirement ignored -> {
			}
			case Goal ignored -> fileTypeWarning(fileExtension, "goal", element);
			case DocumentSection section -> checkRecDocSection(section);
			default -> fileTypeWarning(fileExtension, element.getClass().getName(), element);
			}
		}
	}

	private void checkGoalDocument(final String fileExtension, final ReqDocument document) {
		for (var element : document.getContent()) {
			switch (element) {
			case Goal ignored -> {
			}
			case Requirement ignored -> fileTypeWarning(fileExtension, "requirement", element);
			case DocumentSection section -> checkGoalDocSection(section);
			default -> fileTypeWarning(fileExtension, element.getClass().getName(), element);
			}
		}
	}

	public void fileTypeWarning(final String fileType, final String partName, final EObject part) {
		warning(partName + " not allowed in '" + fileType + "' file.", part, null);
	}

	/** TODO: These methods invoke the QuickFixes, not using yet do to unexpected behavior:
	 * 		  when removing illegal stakeholder goal from reqspec, the SystemsRequirementSet elements re-order in a way causing an error
	 * public void fileTypeError(String fileType, String partName, EObject part, ReqSpec parent) {
	 * 	error(partName + " not allowed in '" + fileType + "' file.", part, null,
	 * 			ILLEGAL_OBJECT_FOR_FILETYPE_IN_REQSPEC, partName, EcoreUtil.getURI(parent).toString());
	 * }
	 * public void fileTypeError(String fileType, String partName, EObject part, ReqDocument parent) {
	 * 	error(partName + " not allowed in '" + fileType + "' file.", part, null,
	 * 			ILLEGAL_OBJECT_FOR_FILETYPE_IN_REQDOCUMENT, partName, EcoreUtil.getURI(parent).toString());
	 * }
	 * public void fileTypeError(String fileType, String partName, EObject part, DocumentSection parent) {
	 * 	error(partName + " not allowed in '" + fileType + "' file.", part, null,
	 * 			ILLEGAL_OBJECT_FOR_FILETYPE_IN_DOCUMENTSECTION, partName, EcoreUtil.getURI(parent).toString());
	 * }
	 */
	public void checkRecDocSection(final DocumentSection section) {
		for (var element : section.getContent()) {
			switch (element) {
			case Requirement ignored -> {
			}
			case Goal ignored -> fileTypeWarning(REQDOC_FILE_EXT, "goal", element);
			case DocumentSection nestedSection -> checkRecDocSection(nestedSection);
			default -> fileTypeWarning(REQDOC_FILE_EXT, element.getClass().getName(), element);
			}
		}
	}

	public void checkGoalDocSection(final DocumentSection section) {
		for (var element : section.getContent()) {
			switch (element) {
			case Goal ignored -> {
			}
			case Requirement ignored -> fileTypeWarning(GOALDOC_FILE_EXT, "requirement", element);
			case DocumentSection nestedSection -> checkGoalDocSection(nestedSection);
			default -> fileTypeWarning(GOALDOC_FILE_EXT, element.getClass().getName(), element);
			}
		}
	}

	@Check
	public void checkSystemRequirementsUniqueToComponentClassifier(final SystemRequirementSet systemRequirements) {
		var target = systemRequirements.getTarget();
		var allSystemRequirements = reqSpecrefFinder.getSystemRequirementSetsNoExtends(target);
		if (count(allSystemRequirements) > 1) {
			error("Other System Requirements exist for '" + target.getName()
					+ "'. Only one System Requirement is allowed for a specific component.", systemRequirements,
					ReqSpecPackage.Literals.SYSTEM_REQUIREMENT_SET__TARGET);
		}
	}

	@Check
	public void checkStakeholderGoalsUniqueToComponentClassifier(final StakeholderGoals stakeholderGoals) {
		var target = stakeholderGoals.getTarget();
		var allStakeholderGoals = reqSpecrefFinder.getStakeholderGoals(target);
		if (count(allStakeholderGoals) > 1) {
			error("Other Stakeholder Goals exist for '" + target.getName()
					+ "'. Only one Stakeholder Goals is allowed for a specific component.", stakeholderGoals,
					ReqSpecPackage.Literals.STAKEHOLDER_GOALS__TARGET);
		}
	}

	@Check
	public void checkRequirementShadowing(final Requirement requirement) {
		var requirementName = requirement.getName().toLowerCase();
		var evolvesReferences = requirement.getEvolvesReference();
		var requirementSet = ReqSpecUtilExtension.containingRequirementSet(requirement);
		if (requirementSet instanceof SystemRequirementSet systemRequirements) {
			var componentClassifier = systemRequirements.getTarget();
			var classifierParents = new ArrayList<ComponentClassifier>();
			buildExtended(componentClassifier, classifierParents);

			for (var classifierParent : new HashSet<>(classifierParents)) {
				for (var parentRequirements : reqSpecrefFinder.getSystemRequirementSets(classifierParent)) {
					var shadows = parentRequirements.getRequirements()
							.stream()
							.anyMatch(candidate -> Objects.equals(candidate.getName().toLowerCase(), requirementName)
									&& !candidate.isDropped() && !evolvesReferences.contains(candidate));
					if (shadows) {
						error("Requirement '" + requirement.getName() + "' for '" + componentClassifier.getName()
								+ "' shadows a requirement of the same name in the System Requirements for '"
								+ classifierParent.getName() + "'. Shadowing '" + requirementName
								+ "' must evolve original or original '" + requirementName
								+ "' must be tagged as 'dropped'", requirement,
								ReqSpecPackage.Literals.CONTRACTUAL_ELEMENT__NAME);
					}
				}
			}
		}
	}

	public void buildExtended(final ComponentClassifier componentClassifier,
			final List<ComponentClassifier> ancestors) {
		if (componentClassifier.getExtended() instanceof ComponentClassifier extended) {
			ancestors.add(extended);
			buildExtended(extended, ancestors);
		}
		if (componentClassifier instanceof ComponentImplementation implementation) {
			var type = implementation.getType();
			ancestors.add(type);
			buildExtended(type, ancestors);
		}
	}

	@Check
	public void checkRequirementRefinement(final Requirement requirement) {
		if (requirement.getRefinesReference().isEmpty()) {
			return;
		}

		var refinedRequirement = requirement.getRefinesReference().getFirst();
		if (ReqSpecUtilExtension.containingRequirementSet(refinedRequirement) == ReqSpecUtilExtension
				.containingRequirementSet(requirement)) {
			return;
		}

		var classifierParents = new ArrayList<ComponentClassifier>();
		var requirementSet = ReqSpecUtilExtension.containingRequirementSet(requirement);
		if (requirementSet instanceof SystemRequirementSet systemRequirements) {
			buildExtended(systemRequirements.getTarget(), classifierParents);
			var refinedRequirementSet = ReqSpecUtilExtension.containingRequirementSet(refinedRequirement);
			if (refinedRequirementSet instanceof SystemRequirementSet refinedSystemRequirements) {
				if (classifierParents.contains(refinedSystemRequirements.getTarget())) {
					return;
				}
				error("Requirement '" + requirement.getName() + "' refined from '" + refinedRequirement.getName()
						+ "' and must either be in the same System Requirements or '" + requirement.getName()
						+ "' must be for an extension or implementation of the component '"
						+ refinedRequirement.getName() + "' is for. '", requirement,
						ReqSpecPackage.Literals.CONTRACTUAL_ELEMENT__NAME);
			}
		}
	}

	@Check
	public void checkIncludeGlobalRequirement(final IncludeGlobalRequirement include) {
		if (!(include.getInclude() instanceof GlobalRequirementSet || include.getInclude() instanceof Requirement)) {
			error("Must include global requirements or requirement in global requirements.", include,
					ReqSpecPackage.Literals.INCLUDE_GLOBAL_REQUIREMENT__INCLUDE, INCORRECT_GLOBAL_REQUIREMENT_INCLUDE);
		}
	}

	@Check
	public void checkWhenCondition(final WhenCondition condition) {
		if (ExecuteJavaUtil.getJavaMethod(condition.getCondition()) == null) {
			error("Could not find Java method " + condition.getCondition() + " with single EObject parameter",
					ReqSpecPackage.Literals.WHEN_CONDITION__CONDITION, CONDITION_METHOD_NOT_FOUND);
		}
	}

	private static String names(final Iterable<? extends NamedElement> elements) {
		return StreamSupport.stream(elements.spliterator(), false)
				.map(NamedElement::getName)
				.collect(Collectors.joining(" "));
	}

	private static long count(final Iterable<?> elements) {
		return StreamSupport.stream(elements.spliterator(), false).count();
	}
}
