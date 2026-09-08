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
package org.osate.xtext.aadl2.properties.formatting2;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.internal.SinglelineCodeCommentReplacer;
import org.eclipse.xtext.formatting2.internal.SinglelineDocCommentReplacer;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.resource.XtextResource;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Operation;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.xtext.aadl2.properties.services.PropertiesGrammarAccess;

import com.google.inject.Inject;

public class PropertiesFormatter extends AbstractFormatter2 {
	@Inject
	private PropertiesGrammarAccess grammarAccess;

	@Override
	public ITextReplacer createCommentReplacer(IComment comment) {
		var grammarElement = comment.getGrammarElement();
		if (grammarElement instanceof AbstractRule) {
			if (comment.getLineRegions().getFirst().getIndentation().getLength() > 0) {
				return new SinglelineDocCommentReplacer(comment, "--") {
					@Override
					public ITextReplacerContext createReplacements(ITextReplacerContext context) {
						return context;
					}
				};
			}
			return new SinglelineCodeCommentReplacer(comment, "--");
		}
		var elementName = new GrammarElementTitleSwitch().showQualified().showRule().doSwitch(grammarElement);
		throw new IllegalStateException(
				"No " + ITextReplacer.class.getSimpleName() + " configured for " + elementName);
	}

	/**
	 * Dispatches to the {@code _format} implementation for the most specific handled type. The type order is the one
	 * the Xtend {@code dispatch} compiler produced, and the inherited {@code _format} overloads for
	 * {@link XtextResource}, {@link EObject}, {@link Void} and {@link Object} remain the fallbacks, so a null object
	 * still reaches {@code _format((Void) null, document)}.
	 */
	@Override
	public void format(Object object, IFormattableDocument document) {
		switch (object) {
		case IntegerLiteral integerLiteral -> _format(integerLiteral, document);
		case RealLiteral realLiteral -> _format(realLiteral, document);
		case ClassifierValue classifierValue -> _format(classifierValue, document);
		case ComputedValue computedValue -> _format(computedValue, document);
		case ModalPropertyValue modalPropertyValue -> _format(modalPropertyValue, document);
		case RangeValue rangeValue -> _format(rangeValue, document);
		case RecordValue recordValue -> _format(recordValue, document);
		case ReferenceValue referenceValue -> _format(referenceValue, document);
		case ListValue listValue -> _format(listValue, document);
		case Operation operation -> _format(operation, document);
		case XtextResource xtextResource -> _format(xtextResource, document);
		case ArrayRange arrayRange -> _format(arrayRange, document);
		case BasicPropertyAssociation basicPropertyAssociation -> _format(basicPropertyAssociation, document);
		case ContainmentPathElement containmentPathElement -> _format(containmentPathElement, document);
		case EObject eObject -> _format(eObject, document);
		case null -> _format((Void) null, document);
		default -> _format(object, document);
		}
	}

	protected void _format(ModalPropertyValue modalPropertyValue, IFormattableDocument document) {
		format(modalPropertyValue.getOwnedValue(), document);

		// OptionalModalPropertyValue
		var access = grammarAccess.getOptionalModalPropertyValueAccess();
		var leftParenthesis = textRegionExtensions.regionFor(modalPropertyValue)
				.keyword(access.getLeftParenthesisKeyword_1_2());
		var rightParenthesis = textRegionExtensions.regionFor(modalPropertyValue)
				.keyword(access.getRightParenthesisKeyword_1_5());
		if (leftParenthesis != null && rightParenthesis != null) {
			document.surround(textRegionExtensions.regionFor(modalPropertyValue).keyword(access.getInKeyword_1_0()),
					it -> it.oneSpace());
			document.interior(leftParenthesis, rightParenthesis, it -> it.indent());
			document.append(document.prepend(leftParenthesis, it -> it.oneSpace()), it -> {
				it.noSpace();
				it.setNewLines(0, 0, 1);
				it.autowrap();
			});
			textRegionExtensions.regionFor(modalPropertyValue)
					.keywords(access.getCommaKeyword_1_4_0())
					.forEach(comma -> formatSeparator(document, comma));
			prependNewLineOrNoSpace(document, rightParenthesis);
		}
	}

	protected void _format(ReferenceValue referenceValue, IFormattableDocument document) {
		var access = grammarAccess.getReferenceTermAccess();
		document.append(document.prepend(
				textRegionExtensions.regionFor(referenceValue).keyword(access.getLeftParenthesisKeyword_1()),
				it -> it.oneSpace()), it -> it.noSpace());
		format(referenceValue.getPath(), document);
		document.prepend(textRegionExtensions.regionFor(referenceValue).keyword(access.getRightParenthesisKeyword_3()),
				it -> it.noSpace());
	}

	protected void _format(RecordValue recordValue, IFormattableDocument document) {
		var access = grammarAccess.getRecordTermAccess();
		var leftBracket = textRegionExtensions.regionFor(recordValue).keyword(access.getLeftSquareBracketKeyword_0());
		var rightBracket = textRegionExtensions.regionFor(recordValue).keyword(access.getRightSquareBracketKeyword_2());
		document.interior(leftBracket, rightBracket, it -> it.indent());
		document.append(leftBracket, it -> {
			it.noSpace();
			it.setNewLines(0, 0, 1);
			it.autowrap();
		});
		var fieldValues = recordValue.getOwnedFieldValues();
		/* Separate every field value from the previous one; the first one is preceded by the bracket. */
		for (int i = 1; i < fieldValues.size(); i++) {
			document.prepend(fieldValues.get(i), it -> {
				it.oneSpace();
				it.setNewLines(0, 0, 1);
				it.autowrap();
			});
		}
		fieldValues.forEach(fieldValue -> format(fieldValue, document));
		prependNewLineOrNoSpace(document, rightBracket);
	}

	protected void _format(ComputedValue computedValue, IFormattableDocument document) {
		var access = grammarAccess.getComputedTermAccess();
		document.append(document.prepend(
				textRegionExtensions.regionFor(computedValue).keyword(access.getLeftParenthesisKeyword_1()),
				it -> it.oneSpace()), it -> it.noSpace());
		document.prepend(textRegionExtensions.regionFor(computedValue).keyword(access.getRightParenthesisKeyword_3()),
				it -> it.noSpace());
	}

	protected void _format(ClassifierValue classifierValue, IFormattableDocument document) {
		var access = grammarAccess.getComponentClassifierTermAccess();
		document.append(document.prepend(
				textRegionExtensions.regionFor(classifierValue).keyword(access.getLeftParenthesisKeyword_1()),
				it -> it.oneSpace()), it -> it.noSpace());
		document.prepend(textRegionExtensions.regionFor(classifierValue).keyword(access.getRightParenthesisKeyword_3()),
				it -> it.noSpace());
	}

	protected void _format(ListValue listValue, IFormattableDocument document) {
		var access = grammarAccess.getListTermAccess();
		var leftParenthesis = textRegionExtensions.regionFor(listValue).keyword(access.getLeftParenthesisKeyword_1());
		if (listValue.getOwnedListElements().isEmpty()) {
			document.append(leftParenthesis, it -> it.noSpace());
			return;
		}
		var rightParenthesis = textRegionExtensions.regionFor(listValue).keyword(access.getRightParenthesisKeyword_3());
		document.interior(leftParenthesis, rightParenthesis, it -> it.indent());
		document.append(leftParenthesis, it -> {
			it.noSpace();
			it.setNewLines(0, 0, 1);
			it.autowrap();
		});
		textRegionExtensions.regionFor(listValue)
				.keywords(access.getCommaKeyword_2_1_0())
				.forEach(comma -> formatSeparator(document, comma));
		listValue.getOwnedListElements().forEach(listElement -> format(listElement, document));
		prependNewLineOrNoSpace(document, rightParenthesis);
	}

	protected void _format(BasicPropertyAssociation basicPropertyAssociation, IFormattableDocument document) {
		var access = grammarAccess.getFieldPropertyAssociationAccess();
		document.surround(textRegionExtensions.regionFor(basicPropertyAssociation)
				.keyword(access.getEqualsSignGreaterThanSignKeyword_1()), it -> it.oneSpace());
		format(basicPropertyAssociation.getOwnedValue(), document);
		document.prepend(
				textRegionExtensions.regionFor(basicPropertyAssociation).keyword(access.getSemicolonKeyword_3()),
				it -> it.noSpace());
	}

	protected void _format(ContainmentPathElement containmentPathElement, IFormattableDocument document) {
		// Array range
		containmentPathElement.getArrayRanges().forEach(arrayRange -> {
			document.prepend(arrayRange, it -> it.noSpace());
			format(arrayRange, document);
		});

		// Next element in path
		document.surround(textRegionExtensions.regionFor(containmentPathElement)
				.keyword(grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0()),
				it -> it.noSpace());
		format(containmentPathElement.getPath(), document);
	}

	protected void _format(ArrayRange arrayRange, IFormattableDocument document) {
		var access = grammarAccess.getArrayRangeAccess();
		document.append(textRegionExtensions.regionFor(arrayRange).keyword(access.getLeftSquareBracketKeyword_1()),
				it -> it.noSpace());
		document.surround(textRegionExtensions.regionFor(arrayRange).keyword(access.getFullStopFullStopKeyword_3_0()),
				it -> it.oneSpace());
		document.prepend(textRegionExtensions.regionFor(arrayRange).keyword(access.getRightSquareBracketKeyword_4()),
				it -> it.noSpace());
	}

	protected void _format(Operation operation, IFormattableDocument document) {
		document.append(textRegionExtensions.regionFor(operation)
				.assignment(grammarAccess.getSignedConstantAccess().getOpAssignment_0()), it -> it.noSpace());
	}

	protected void _format(IntegerLiteral integerLiteral, IFormattableDocument document) {
		formatUnit(document, textRegionExtensions.regionFor(integerLiteral)
				.assignment(grammarAccess.getIntegerTermAccess().getUnitAssignment_1()));
	}

	protected void _format(RealLiteral realLiteral, IFormattableDocument document) {
		formatUnit(document, textRegionExtensions.regionFor(realLiteral)
				.assignment(grammarAccess.getRealTermAccess().getUnitAssignment_1()));
	}

	protected void _format(RangeValue rangeValue, IFormattableDocument document) {
		var access = grammarAccess.getNumericRangeTermAccess();
		format(rangeValue.getMinimum(), document);
		document.surround(textRegionExtensions.regionFor(rangeValue).keyword(access.getFullStopFullStopKeyword_1()),
				it -> it.oneSpace());
		format(rangeValue.getMaximum(), document);
		document.surround(textRegionExtensions.regionFor(rangeValue).keyword(access.getDeltaKeyword_3_0()),
				it -> it.oneSpace());
		format(rangeValue.getDelta(), document);
	}

	/**
	 * Short units stay attached to the number, longer ones are separated by a space.
	 */
	private static void formatUnit(IFormattableDocument document, ISemanticRegion unitAssignment) {
		if (unitAssignment != null && unitAssignment.getText().length() <= 2) {
			document.prepend(unitAssignment, it -> it.noSpace());
		} else {
			document.prepend(unitAssignment, it -> it.oneSpace());
		}
	}

	private static void formatSeparator(IFormattableDocument document, ISemanticRegion comma) {
		document.append(document.prepend(comma, it -> it.noSpace()), it -> {
			it.oneSpace();
			it.setNewLines(0, 0, 1);
			it.autowrap();
		});
	}

	/**
	 * Puts a closing bracket or parenthesis on its own line when the enclosed region spans several lines, and
	 * directly after the last element otherwise. Tolerates a missing region, as the original code did.
	 */
	private static void prependNewLineOrNoSpace(IFormattableDocument document, ISemanticRegion closingRegion) {
		if (closingRegion == null) {
			return;
		}
		if (closingRegion.getPreviousHiddenRegion().isMultiline()) {
			document.prepend(closingRegion, it -> it.setNewLines(1));
		} else {
			document.prepend(closingRegion, it -> it.noSpace());
		}
	}
}
