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
package org.osate.reqspec.ui.quickfix;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.osate.aadl2.ComponentClassifier;
import org.osate.reqspec.reqSpec.DocumentSection;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.ReqDocument;
import org.osate.reqspec.reqSpec.ReqSpec;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.StakeholderGoals;
import org.osate.reqspec.reqSpec.SystemRequirementSet;
import org.osate.reqspec.validation.ReqSpecValidator;

/**
 * Custom quickfixes.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
public class ReqSpecQuickfixProvider extends DefaultQuickfixProvider {
	/**
	 * QuickFix for removing a goal duplicated within a StakeholdersGoals
	 * The issue data array is expected to have one element:
	 *
	 * issue.getData()[0]: The URI of the StakeHoldersGoals
	 */
	@Fix(ReqSpecValidator.DUPLICATE_GOAL_WITHIN_STAKEHOLDER_GOALS)
	public void fixDuplicateGoal(final Issue issue, final IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove goal", null, null, new ISemanticModification() {
			@Override
			public void apply(final EObject element, final IModificationContext context) throws Exception {
				var resourceSet = element.eResource().getResourceSet();
				var stakeholderGoals = (StakeholderGoals) resourceSet.getEObject(URI.createURI(head(issue.getData())),
						true);
				stakeholderGoals.getGoals().remove((Goal) element);
			}
		});
	}

	/**
	 * QuickFix for removing a duplicated StakeholderGoals
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The offset of the StakeholderGoals
	 * issue.getData()[1]: The length of the StakeholderGoals
	 */
	@Fix(ReqSpecValidator.DUPLICATE_STAKEHOLDER_GOALS)
	public void fixDuplicateStakeholderGoals(final Issue issue, final IssueResolutionAcceptor acceptor) {
		var offset = Integer.parseInt(issue.getData()[0]);
		var length = Integer.parseInt(issue.getData()[1]);
		acceptor.accept(issue, "Remove StakeholderGoals", null, null, new IModification() {
			@Override
			public void apply(final IModificationContext context) throws Exception {
				context.getXtextDocument().replace(offset, length, "");
			}
		});
	}

	/**
	 * QuickFix for rename a reqspec target to match a StakeholdersGoals target based on matching requirement and goal
	 * The issue data array is expected to have one element:
	 * issue.getData()[0]: The name the needs changed
	 * issue.getData()[1]: name it needs changed to
	 * issue.getData()[2]: the uri of what it needs changed to
	 */
	@Fix(ReqSpecValidator.REQSPEC_FOR_DIFFERS_FROM_STAKEHOLDERGOALS_FOR)
	public void fixDifferingFor(final Issue issue, final IssueResolutionAcceptor acceptor) {
		var fromName = issue.getData()[0];
		var toName = issue.getData()[1];
		var targetUri = issue.getData()[2];
		acceptor.accept(issue, "Change System Requirement 'for' from '" + fromName + "' to '" + toName + "'", null,
				null, new ISemanticModification() {
					@Override
					public void apply(final EObject element, final IModificationContext context) throws Exception {
						var resourceSet = element.eResource().getResourceSet();
						var classifier = (ComponentClassifier) resourceSet.getEObject(URI.createURI(targetUri), true);
						((SystemRequirementSet) element).setTarget(classifier);
					}
				});
	}

	/**
	 * QuickFix for removing a duplicated SystemRequirements
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The offset of the SystemRequirements
	 * issue.getData()[1]: The length of the SystemRequirements
	 */
	@Fix(ReqSpecValidator.DUPLICATE_REQUIREMENTS)
	public void fixDuplicateSystemRequirements(final Issue issue, final IssueResolutionAcceptor acceptor) {
		var offset = Integer.parseInt(issue.getData()[0]);
		var length = Integer.parseInt(issue.getData()[1]);
		acceptor.accept(issue, "Remove SystemsRequirement", null, null, new IModification() {
			@Override
			public void apply(final IModificationContext context) throws Exception {
				context.getXtextDocument().replace(offset, length, "");
			}
		});
	}

	/**
	 * QuickFix for removing a goal duplicated within a StakeholdersGoals
	 * The issue data array is expected to have one element:
	 *
	 * issue.getData()[0]: The URI of the StakeHoldersGoals
	 */
	@Fix(ReqSpecValidator.DUPLICATE_REQUIREMENT_WITHIN_REQUIREMENTS)
	public void fixDuplicateRequirement(final Issue issue, final IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove requirement", null, null, new ISemanticModification() {
			@Override
			public void apply(final EObject element, final IModificationContext context) throws Exception {
				var resourceSet = element.eResource().getResourceSet();
				var systemRequirements = (SystemRequirementSet) resourceSet
						.getEObject(URI.createURI(head(issue.getData())), true);
				systemRequirements.getRequirements().remove((Requirement) element);
			}
		});
	}

	/**
	 * QuickFix for removing a refined from a goal with cycle dependencies
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The name of the refined goal
	 * issue.getData()[1]: The uri of the refined goal
	 */
	@Fix(ReqSpecValidator.CYCLE_IN_GOAL_REFINE_HIERARCHY)
	public void fixCycleInGoalRefineHierarchy(final Issue issue, final IssueResolutionAcceptor acceptor) {
		var refinedGoalName = head(issue.getData());
		var refinedGoalUri = issue.getData()[1];
		acceptor.accept(issue, "Remove refines " + refinedGoalName, null, null, new ISemanticModification() {
			@Override
			public void apply(final EObject element, final IModificationContext context) throws Exception {
				var resourceSet = element.eResource().getResourceSet();
				var refinedGoal = (Goal) resourceSet.getEObject(URI.createURI(refinedGoalUri), true);
				((Goal) element).getRefinesReference().remove(refinedGoal);
			}
		});
	}

	/**
	 * QuickFix for removing a refined from a requirement with cycle dependencies
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The name of the refined requirement
	 * issue.getData()[1]: The uri of the refined requirement
	 */
	@Fix(ReqSpecValidator.CYCLE_IN_REQUIREMENT_REFINE_HIERARCHY)
	public void fixCycleInRequiremntRefineHierarchy(final Issue issue, final IssueResolutionAcceptor acceptor) {
		var refinedRequirementName = head(issue.getData());
		var refinedRequirementUri = issue.getData()[1];
		acceptor.accept(issue, "Remove refines " + refinedRequirementName, null, null, new ISemanticModification() {
			@Override
			public void apply(final EObject element, final IModificationContext context) throws Exception {
				var resourceSet = element.eResource().getResourceSet();
				var refinedRequirement = (Requirement) resourceSet.getEObject(URI.createURI(refinedRequirementUri),
						true);
				((Requirement) element).getRefinesReference().remove(refinedRequirement);
			}
		});
	}

	/**
	 * QuickFix for removing an illegal object from a document section of a reqdoc or goaldoc
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The type of element
	 * issue.getData()[1]: The uri of the containing section
	 */
	@Fix(ReqSpecValidator.ILLEGAL_OBJECT_FOR_FILETYPE_IN_DOCUMENTSECTION)
	public void fixIllegalObjectForFileTypeInDocumentSection(final Issue issue,
			final IssueResolutionAcceptor acceptor) {
		var elementType = head(issue.getData());
		var sectionUri = issue.getData()[1];
		acceptor.accept(issue, "Remove " + elementType + " from section.", null, null, new ISemanticModification() {
			@Override
			public void apply(final EObject element, final IModificationContext context) throws Exception {
				var resourceSet = element.eResource().getResourceSet();
				var section = (DocumentSection) resourceSet.getEObject(URI.createURI(sectionUri), true);
				section.getContent().remove(element);
			}
		});
	}

	/**
	 * QuickFix for removing an illegal object in a reqdoc or goaldoc
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The type of element
	 * issue.getData()[1]: The uri of the containing parent
	 */
	@Fix(ReqSpecValidator.ILLEGAL_OBJECT_FOR_FILETYPE_IN_REQDOCUMENT)
	public void fixIllegalObjectForFileTypeInReqDocument(final Issue issue, final IssueResolutionAcceptor acceptor) {
		var elementType = head(issue.getData());
		var documentUri = issue.getData()[1];
		acceptor.accept(issue, "Remove " + elementType + ".", null, null, new ISemanticModification() {
			@Override
			public void apply(final EObject element, final IModificationContext context) throws Exception {
				var resourceSet = element.eResource().getResourceSet();
				var document = (ReqDocument) resourceSet.getEObject(URI.createURI(documentUri), true);
				document.getContent().remove(element);
			}
		});
	}

	/**
	 * QuickFix for removing an illegal object in a ReqSpec
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The type of element
	 * issue.getData()[1]: The uri of the containing parent
	 */
	@Fix(ReqSpecValidator.ILLEGAL_OBJECT_FOR_FILETYPE_IN_REQSPEC)
	public void fixIllegalObjectForFileTypeInReqSpec(final Issue issue, final IssueResolutionAcceptor acceptor) {
		var elementType = head(issue.getData());
		var reqSpecUri = issue.getData()[1];
		acceptor.accept(issue, "Remove " + elementType + ".", null, null, new ISemanticModification() {
			@Override
			public void apply(final EObject element, final IModificationContext context) throws Exception {
				var resourceSet = element.eResource().getResourceSet();
				var reqSpec = (ReqSpec) resourceSet.getEObject(URI.createURI(reqSpecUri), true);
				reqSpec.getParts().remove(element);
			}
		});
	}

//	/**
//	 * QuickFix for removing a duplicated GlobalRequirements
//	 * The issue data array is expected to have two elements:
//	 *
//	 * issue.getData()[0]: The offset of the GlobalRequirements
//	 * issue.getData()[1]: The length of the GlobalRequirements
//	 */
//	@Fix(ReqSpecValidator.DUPLICATE_GLOBALREQUIREMENTS)
//	public void fixDuplicateReqSpecContainer(Issue issue, IssueResolutionAcceptor acceptor) {
//		var offset = Integer.parseInt(issue.getData()[0]);
//		var length = Integer.parseInt(issue.getData()[1]);
//		acceptor.accept(issue, "Remove Global Requirements", null, null,
//				context -> context.getXtextDocument().replace(offset, length, ""));
//	}

	private static String head(final String[] values) {
		return values.length == 0 ? null : values[0];
	}
}
