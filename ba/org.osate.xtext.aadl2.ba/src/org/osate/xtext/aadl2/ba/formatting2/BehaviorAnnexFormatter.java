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

package org.osate.xtext.aadl2.ba.formatting2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorPropertyAssociation;
import org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement;
import org.osate.xtext.aadl2.ba.services.BehaviorAnnexGrammarAccess;
import org.osate.xtext.aadl2.properties.formatting2.PropertiesFormatter;

import com.google.inject.Inject;

/**
 * Formats BA sections and nested action blocks while applying consistent punctuation and expression spacing across
 * the complete annex subtree.
 *
 * <p>
 * Every rule below addresses grammar elements instead of token text, because the same token means different things in
 * different positions: the {@code if} of {@code end if} is not the {@code if} of a condition, the {@code *} of
 * {@code *!<} is not the multiplication operator, and the {@code #} of
 * {@code reference#property_set::property} is not the {@code #} of a property value that stands on its own. Token text
 * cannot tell those apart, and because the lexer ignores case it would also have to lower case every region first.
 *
 * <p>
 * The operators of the expression rules are reached through their data type rule call rather than through the keywords
 * of that rule: a region that a data type rule produced carries the rule call, so the keywords inside
 * {@code RelationalOperator} and its siblings never appear as a grammar element.
 */
public final class BehaviorAnnexFormatter extends PropertiesFormatter {
	@Inject
	private BehaviorAnnexGrammarAccess grammarAccess;

	private Set<EObject> noSpaceBefore;
	private Set<EObject> noSpaceAfter;
	private Set<EObject> spacedAround;
	private Set<EObject> newLineAfter;
	private Set<EObject> oneSpaceAfter;

	@Override
	public void format(final Object object, final IFormattableDocument document) {
		if (object instanceof BehaviorAnnex annex) {
			_format(annex, document);
		} else {
			// Property values are AADL property expressions, so the inherited formatter owns them.
			super.format(object, document);
		}
	}

	protected void _format(final BehaviorAnnex annex, final IFormattableDocument document) {
		var regions = textRegionExtensions.allSemanticRegions(annex);
		var semanticRegions = regions instanceof List<?> ? (List<ISemanticRegion>) regions
				: StreamSupport.stream(regions.spliterator(), false).toList();
		for (var i = 0; i + 1 < semanticRegions.size(); i++) {
			if (isAnnexSyntax(semanticRegions.get(i)) && isAnnexSyntax(semanticRegions.get(i + 1))) {
				document.append(semanticRegions.get(i), it -> {
					it.lowPriority();
					it.oneSpace();
				});
			}
		}

		for (var region : semanticRegions) {
			var element = region.getGrammarElement();
			if (noSpaceBefore().contains(element)) {
				document.prepend(region, it -> {
					it.highPriority();
					it.noSpace();
				});
			}
			if (noSpaceAfter().contains(element)) {
				document.append(region, it -> {
					it.highPriority();
					it.noSpace();
				});
			}
			if (spacedAround().contains(element)) {
				document.surround(region, it -> {
					it.highPriority();
					it.oneSpace();
				});
			}
			if (newLineAfter().contains(element)) {
				document.append(region, BehaviorAnnexFormatter::newLine);
			}
			if (oneSpaceAfter().contains(element)) {
				document.append(region, it -> {
					it.highPriority();
					it.oneSpace();
				});
			}
		}

		formatSections(annex, document, semanticRegions);
		formatBlocks(annex, document);

		for (var iterator = annex.eAllContents(); iterator.hasNext();) {
			var object = iterator.next();
			if (object instanceof IfStatement ifStatement) {
				formatBranches(ifStatement, document);
			} else if (object instanceof BehaviorPropertyAssociation association) {
				document.format(association.getOwnedValue());
			}
		}
	}

	/**
	 * Puts each section keyword on a line of its own and indents the declarations that follow it. The first section
	 * starts the annex text, so nothing may precede it.
	 */
	private void formatSections(final BehaviorAnnex annex, final IFormattableDocument document,
			final List<ISemanticRegion> semanticRegions) {
		var annexAccess = grammarAccess.getBehaviorAnnexAccess();
		var annexRegions = textRegionExtensions.regionFor(annex);
		var sections = new ArrayList<ISemanticRegion>(3);
		for (var keyword : List.of(annexAccess.getVariablesKeyword_1_0(), annexAccess.getStatesKeyword_2_0(),
				annexAccess.getTransitionsKeyword_3_0())) {
			var section = annexRegions.keyword(keyword);
			if (section != null) {
				sections.add(section);
			}
		}

		for (var i = 0; i < sections.size(); i++) {
			var section = sections.get(i);
			var isFirst = i == 0;
			document.prepend(section, it -> {
				it.highPriority();
				it.noSpace();
				if (!isFirst) {
					it.newLine();
				}
			});
			document.append(section, BehaviorAnnexFormatter::newLine);
			var end = i + 1 < sections.size() ? sections.get(i + 1) : semanticRegions.getLast();
			document.interior(section, end, it -> it.indent());
		}
	}

	/**
	 * Puts the contents of every braced block on lines of their own and indents them.
	 */
	private void formatBlocks(final BehaviorAnnex annex, final IFormattableDocument document) {
		var regions = textRegionExtensions.allRegionsFor(annex);
		var variableGroup = grammarAccess.getBehaviorVariableGroupAccess();
		var actionBlock = grammarAccess.getBehaviorActionBlockAccess();
		var forStatement = grammarAccess.getForStatementAccess();
		var whileStatement = grammarAccess.getWhileStatementAccess();
		formatBlock(document, regions, variableGroup.getLeftCurlyBracketKeyword_5_0(),
				variableGroup.getRightCurlyBracketKeyword_5_2());
		formatBlock(document, regions, actionBlock.getLeftCurlyBracketKeyword_0(),
				actionBlock.getRightCurlyBracketKeyword_2());
		formatBlock(document, regions, forStatement.getLeftCurlyBracketKeyword_7(),
				forStatement.getRightCurlyBracketKeyword_9());
		formatBlock(document, regions, whileStatement.getLeftCurlyBracketKeyword_4(),
				whileStatement.getRightCurlyBracketKeyword_6());
	}

	private static void formatBlock(final IFormattableDocument document, final ISemanticRegionsFinder regions,
			final Keyword open, final Keyword close) {
		for (var pair : regions.keywordPairs(open, close)) {
			var left = pair.getKey();
			var right = pair.getValue();
			// Not high priority: a block that directly contains a block starts the inner block on a line of its own,
			// and the line break of the outer brace has to outrank this space.
			document.prepend(left, it -> it.oneSpace());
			document.append(left, BehaviorAnnexFormatter::newLine);
			document.prepend(right, BehaviorAnnexFormatter::newLine);
			document.interior(left, right, it -> it.indent());
		}
	}

	/**
	 * Indents every branch of the given if statement on lines of its own, so that the condition of a branch, the branch
	 * itself, and the keyword that ends the branch each start a line.
	 */
	private void formatBranches(final IfStatement ifStatement, final IFormattableDocument document) {
		var ifAccess = grammarAccess.getIfStatementAccess();
		var elseIfAccess = grammarAccess.getElseIfClauseAccess();
		var ifRegions = textRegionExtensions.regionFor(ifStatement);

		// The keyword that introduces a branch and the keyword that ends it, collected in source order.
		var branchStarts = new ArrayList<ISemanticRegion>();
		var branchEnds = new ArrayList<ISemanticRegion>();
		branchStarts.add(ifRegions.keyword(ifAccess.getRightParenthesisKeyword_3()));
		for (var elseIfClause : ifStatement.getElseIfs()) {
			var elseIfRegions = textRegionExtensions.regionFor(elseIfClause);
			branchEnds.add(elseIfRegions.keyword(elseIfAccess.getElsifKeyword_0()));
			branchStarts.add(elseIfRegions.keyword(elseIfAccess.getRightParenthesisKeyword_3()));
		}
		var elseKeyword = ifRegions.keyword(ifAccess.getElseKeyword_6_0());
		if (elseKeyword != null) {
			branchEnds.add(elseKeyword);
			branchStarts.add(elseKeyword);
		}
		branchEnds.add(ifRegions.keyword(ifAccess.getEndKeyword_7()));

		for (var i = 0; i < branchStarts.size(); i++) {
			formatBranch(document, branchStarts.get(i), branchEnds.get(i),
					grammarAccess.getBehaviorActionBlockAccess().getLeftCurlyBracketKeyword_0());
		}
	}

	/**
	 * Indents the branch between {@code start} and {@code end} on lines of its own. A branch that is written as an
	 * action block keeps its opening brace on the line of the condition or of the {@code else} keyword, so the block
	 * rules remain in charge of that branch.
	 */
	private static void formatBranch(final IFormattableDocument document, final ISemanticRegion start,
			final ISemanticRegion end, final Keyword openBrace) {
		if (start == null || end == null || isFollowedBy(start, openBrace)) {
			return;
		}
		document.append(start, BehaviorAnnexFormatter::newLine);
		document.prepend(end, BehaviorAnnexFormatter::newLine);
		document.interior(start, end, it -> it.indent());
	}

	/**
	 * Forces a line break and pins the space of the hidden region. Pinning matters because the single space that the
	 * low priority rule above puts on every hidden region is adopted by the formatting of this rule when the two are
	 * merged, and it would then collide with the next rule that pins the space of the same hidden region.
	 */
	private static void newLine(final IHiddenRegionFormatter formatter) {
		formatter.highPriority();
		formatter.noSpace();
		formatter.newLine();
	}

	/**
	 * Whether the region belongs to the annex grammar. A region of an inherited rule belongs to an AADL property
	 * expression, whose whitespace the inherited formatter owns.
	 */
	private boolean isAnnexSyntax(final ISemanticRegion region) {
		return GrammarUtil.getGrammar(region.getGrammarElement()) == grammarAccess.getGrammar();
	}

	/**
	 * Whether the region behind {@code region} is the given keyword, ignoring the whitespace and comments in between.
	 */
	private static boolean isFollowedBy(final ISemanticRegion region, final Keyword keyword) {
		var next = region.getNextSemanticRegion();
		return next != null && next.getGrammarElement() == keyword;
	}

	/**
	 * The elements that follow the element in front of them without a space.
	 */
	private Set<EObject> noSpaceBefore() {
		if (noSpaceBefore == null) {
			noSpaceBefore = Set.<EObject>of(
					grammarAccess.getArrayDimensionAccess().getRightSquareBracketKeyword_2(), // ]
					grammarAccess.getArrayIndexAccess().getRightSquareBracketKeyword_2(), // ]
					grammarAccess.getBehaviorActionBlockAccess().getRightCurlyBracketKeyword_2(), // }
					grammarAccess.getBehaviorActionsAccess().getSemicolonKeyword_1_0_1(), // ;
					grammarAccess.getBehaviorActionsAccess().getSemicolonKeyword_1_0_3_0(), // ;
					grammarAccess.getBehaviorPropertyAssociationAccess().getSemicolonKeyword_3(), // ;
					grammarAccess.getBehaviorStateGroupAccess().getColonKeyword_2(), // :
					grammarAccess.getBehaviorStateGroupAccess().getCommaKeyword_1_0(), // ,
					grammarAccess.getBehaviorStateGroupAccess().getSemicolonKeyword_7(), // ;
					grammarAccess.getBehaviorTransitionAccess().getColonKeyword_0_2(), // :
					grammarAccess.getBehaviorTransitionAccess().getCommaKeyword_2_0(), // ,
					grammarAccess.getBehaviorTransitionAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_5(), // ]->
					grammarAccess.getBehaviorTransitionAccess().getRightSquareBracketKeyword_0_1_2(), // ]
					grammarAccess.getBehaviorTransitionAccess().getSemicolonKeyword_8(), // ;
					grammarAccess.getBehaviorVariableGroupAccess().getColonKeyword_2(), // :
					grammarAccess.getBehaviorVariableGroupAccess().getCommaKeyword_1_0(), // ,
					grammarAccess.getBehaviorVariableGroupAccess().getRightCurlyBracketKeyword_5_2(), // }
					grammarAccess.getBehaviorVariableGroupAccess().getSemicolonKeyword_6(), // ;
					grammarAccess.getCommunicationActionAccess().getAllLockExclamationMarkLessThanSignKeyword_1_1_0_0(), // !<
					grammarAccess.getCommunicationActionAccess().getAllUnlockExclamationMarkGreaterThanSignKeyword_1_1_1_0(), // !>
					grammarAccess.getCommunicationActionAccess().getCommaKeyword_0_1_0_1_2_0(), // ,
					grammarAccess.getCommunicationActionAccess().getDequeueQuestionMarkKeyword_0_1_1_0_0(), // ?
					grammarAccess.getCommunicationActionAccess().getFreezeGreaterThanSignGreaterThanSignKeyword_0_1_2_0(), // >>
					grammarAccess.getCommunicationActionAccess().getLockExclamationMarkLessThanSignKeyword_0_1_3_0(), // !<
					grammarAccess.getCommunicationActionAccess().getRightParenthesisKeyword_0_1_0_1_3(), // )
					grammarAccess.getCommunicationActionAccess().getRightParenthesisKeyword_0_1_1_1_2(), // )
					grammarAccess.getCommunicationActionAccess().getSendExclamationMarkKeyword_0_1_0_0_0(), // !
					grammarAccess.getCommunicationActionAccess().getUnlockExclamationMarkGreaterThanSignKeyword_0_1_4_0(), // !>
					grammarAccess.getDispatchConditionAccess().getCommaKeyword_3_3_0(), // ,
					grammarAccess.getDispatchConditionAccess().getRightParenthesisKeyword_3_4(), // )
					grammarAccess.getDispatchTriggerConditionAccess().getRightParenthesisKeyword_1_1_3(), // )
					grammarAccess.getDoUntilStatementAccess().getRightParenthesisKeyword_5(), // )
					grammarAccess.getElseIfClauseAccess().getRightParenthesisKeyword_3(), // )
					grammarAccess.getForStatementAccess().getColonKeyword_3_0(), // :
					grammarAccess.getForStatementAccess().getRightCurlyBracketKeyword_9(), // }
					grammarAccess.getForStatementAccess().getRightParenthesisKeyword_6(), // )
					grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_3(), // )
					grammarAccess.getModeSwitchTriggerAccess().getRightParenthesisKeyword_1_2(), // )
					grammarAccess.getNamedPropertyFieldAccess().getFullStopKeyword_0(), // .
					grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2(), // )
					grammarAccess.getPropertyArrayIndexAccess().getRightSquareBracketKeyword_2(), // ]
					grammarAccess.getPropertyReferenceTailAccess().getNumberSignKeyword_0(), // #
					grammarAccess.getReferenceExpressionAccess().getApostropheKeyword_1_2_0(), // '
					grammarAccess.getReferenceExpressionAccess().getDequeueQuestionMarkKeyword_1_1_0(), // ?
					grammarAccess.getReferenceTailAccess().getSeparatorReferenceSeparatorParserRuleCall_0_0(), // :: .
					grammarAccess.getTimedActionAccess().getCommaKeyword_5_4_0(), // ,
					grammarAccess.getTimedActionAccess().getRightParenthesisKeyword_4(), // )
					grammarAccess.getTimedActionAccess().getRightParenthesisKeyword_5_5(), // )
					grammarAccess.getUnindexedReferenceExpressionAccess().getApostropheKeyword_1_1_0(), // '
					grammarAccess.getUnindexedReferenceExpressionAccess().getDequeueQuestionMarkKeyword_1_0_0(), // ?
					grammarAccess.getUnindexedReferenceTailAccess().getSeparatorReferenceSeparatorParserRuleCall_0_0(), // :: .
					grammarAccess.getWhileStatementAccess().getRightCurlyBracketKeyword_6(), // }
					grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_3()); // )
		}
		return noSpaceBefore;
	}

	/**
	 * The elements that are followed by the next element without a space.
	 */
	private Set<EObject> noSpaceAfter() {
		if (noSpaceAfter == null) {
			noSpaceAfter = Set.<EObject>of(
					// A unary operator belongs to the operand behind it, so '-1' and '+y' are not separated.
					grammarAccess.getSimpleExpressionAccess().getOperatorUnaryAddingOperatorParserRuleCall_0_0_1_0(),
					grammarAccess.getArrayDimensionAccess().getLeftSquareBracketKeyword_0(), // [
					grammarAccess.getArrayIndexAccess().getLeftSquareBracketKeyword_0(), // [
					grammarAccess.getBehaviorTransitionAccess().getHyphenMinusLeftSquareBracketKeyword_3(), // -[
					grammarAccess.getBehaviorTransitionAccess().getLeftSquareBracketKeyword_0_1_0(), // [
					grammarAccess.getCommunicationActionAccess().getAllLockExclamationMarkLessThanSignKeyword_1_1_0_0(), // !<
					grammarAccess.getCommunicationActionAccess().getAllUnlockExclamationMarkGreaterThanSignKeyword_1_1_1_0(), // !>
					grammarAccess.getCommunicationActionAccess().getDequeueQuestionMarkKeyword_0_1_1_0_0(), // ?
					grammarAccess.getCommunicationActionAccess().getFreezeGreaterThanSignGreaterThanSignKeyword_0_1_2_0(), // >>
					grammarAccess.getCommunicationActionAccess().getLeftParenthesisKeyword_0_1_0_1_0(), // (
					grammarAccess.getCommunicationActionAccess().getLeftParenthesisKeyword_0_1_1_1_0(), // (
					grammarAccess.getCommunicationActionAccess().getLockExclamationMarkLessThanSignKeyword_0_1_3_0(), // !<
					grammarAccess.getCommunicationActionAccess().getSendExclamationMarkKeyword_0_1_0_0_0(), // !
					grammarAccess.getCommunicationActionAccess().getUnlockExclamationMarkGreaterThanSignKeyword_0_1_4_0(), // !>
					grammarAccess.getDispatchConditionAccess().getLeftParenthesisKeyword_3_1(), // (
					grammarAccess.getDispatchTriggerConditionAccess().getLeftParenthesisKeyword_1_1_0(), // (
					grammarAccess.getDoUntilStatementAccess().getLeftParenthesisKeyword_3(), // (
					grammarAccess.getElseIfClauseAccess().getLeftParenthesisKeyword_1(), // (
					grammarAccess.getForStatementAccess().getLeftParenthesisKeyword_1(), // (
					grammarAccess.getHashPropertyReferenceAccess().getNumberSignKeyword_0(), // #
					grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1(), // (
					grammarAccess.getModeSwitchTriggerAccess().getLeftParenthesisKeyword_1_0(), // (
					grammarAccess.getNamedPropertyFieldAccess().getFullStopKeyword_0(), // .
					grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), // (
					grammarAccess.getPropertyArrayIndexAccess().getLeftSquareBracketKeyword_0(), // [
					grammarAccess.getPropertyIndexPropertyReferenceAccess().getNumberSignKeyword_0(), // #
					grammarAccess.getPropertyReferenceTailAccess().getNumberSignKeyword_0(), // #
					grammarAccess.getReferenceExpressionAccess().getApostropheKeyword_1_2_0(), // '
					grammarAccess.getReferenceTailAccess().getSeparatorReferenceSeparatorParserRuleCall_0_0(), // :: .
					grammarAccess.getTimedActionAccess().getLeftParenthesisKeyword_1(), // (
					grammarAccess.getTimedActionAccess().getLeftParenthesisKeyword_5_2(), // (
					grammarAccess.getUnindexedReferenceExpressionAccess().getApostropheKeyword_1_1_0(), // '
					grammarAccess.getUnindexedReferenceTailAccess().getSeparatorReferenceSeparatorParserRuleCall_0_0(), // :: .
					grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_1()); // (
		}
		return noSpaceAfter;
	}

	/**
	 * The operators that are separated from their operands by exactly one space.
	 */
	private Set<EObject> spacedAround() {
		if (spacedAround == null) {
			spacedAround = Set.<EObject>of(
					grammarAccess.getAssignmentActionAccess().getColonEqualsSignKeyword_1(), // :=
					grammarAccess.getBehaviorPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1(), // =>
					grammarAccess.getBehaviorVariableGroupAccess().getColonEqualsSignKeyword_4_0(), // :=
					grammarAccess.getDispatchConjunctionAccess().getAndKeyword_1_0(), // and
					grammarAccess.getDispatchTriggerConditionAccess().getOrKeyword_1_1_2_0(), // or
					grammarAccess.getDispatchTriggerLogicalExpressionAccess().getOrKeyword_1_0(), // or
					grammarAccess.getElementValuesAccess().getFullStopFullStopKeyword_1_0(), // ..
					grammarAccess.getFactorAccess().getOperatorBinaryNumericOperatorParserRuleCall_0_1_1_0(), // **
					grammarAccess.getInternalConditionAccess().getOrKeyword_2_0(), // or
					grammarAccess.getModeSwitchConditionAccess().getLogicalOperatorsLogicalOperatorParserRuleCall_1_0_0(), // and or xor
					grammarAccess.getRelationAccess().getOperatorRelationalOperatorParserRuleCall_1_1_0(), // = != < <= > >=
					grammarAccess.getSimpleExpressionAccess().getOperatorBinaryAddingOperatorParserRuleCall_1_1_0(), // + -
					grammarAccess.getTermAccess().getOperatorMultiplyingOperatorParserRuleCall_1_1_0(), // * / mod rem
					grammarAccess.getTimedActionAccess().getFullStopFullStopKeyword_3_0(), // ..
					grammarAccess.getValueExpressionAccess().getOperatorLogicalOperatorParserRuleCall_1_1_0()); // and or xor
		}
		return spacedAround;
	}

	/**
	 * The terminators that end a line.
	 */
	private Set<EObject> newLineAfter() {
		if (newLineAfter == null) {
			newLineAfter = Set.<EObject>of(
					grammarAccess.getBehaviorActionsAccess().getSemicolonKeyword_1_0_1(), // ;
					grammarAccess.getBehaviorActionsAccess().getSemicolonKeyword_1_0_3_0(), // ;
					grammarAccess.getBehaviorPropertyAssociationAccess().getSemicolonKeyword_3(), // ;
					grammarAccess.getBehaviorStateGroupAccess().getSemicolonKeyword_7(), // ;
					grammarAccess.getBehaviorTransitionAccess().getSemicolonKeyword_8(), // ;
					grammarAccess.getBehaviorVariableGroupAccess().getSemicolonKeyword_6()); // ;
		}
		return newLineAfter;
	}

	/**
	 * The elements that are followed by exactly one space.
	 */
	private Set<EObject> oneSpaceAfter() {
		if (oneSpaceAfter == null) {
			oneSpaceAfter = Set.<EObject>of(
					grammarAccess.getBehaviorStateGroupAccess().getCommaKeyword_1_0(), // ,
					grammarAccess.getBehaviorTransitionAccess().getCommaKeyword_2_0(), // ,
					grammarAccess.getBehaviorTransitionAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_5(), // ]->
					grammarAccess.getBehaviorVariableGroupAccess().getCommaKeyword_1_0(), // ,
					grammarAccess.getCommunicationActionAccess().getCommaKeyword_0_1_0_1_2_0(), // ,
					grammarAccess.getDispatchConditionAccess().getCommaKeyword_3_3_0(), // ,
					grammarAccess.getDoUntilStatementAccess().getUntilKeyword_2(), // until
					grammarAccess.getElseIfClauseAccess().getElsifKeyword_0(), // elsif
					grammarAccess.getForStatementAccess().getForForKeyword_0_0_0(), // for
					grammarAccess.getForStatementAccess().getForallForallKeyword_0_1_0(), // forall
					grammarAccess.getIfStatementAccess().getIfKeyword_0(), // if
					grammarAccess.getTimedActionAccess().getBindingKeyword_5_1(), // binding
					grammarAccess.getTimedActionAccess().getCommaKeyword_5_4_0(), // ,
					grammarAccess.getTimedActionAccess().getComputationKeyword_0(), // computation
					grammarAccess.getWhileStatementAccess().getWhileKeyword_0()); // while
		}
		return oneSpaceAfter;
	}
}
