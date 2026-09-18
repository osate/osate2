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
package org.osate.xtext.aadl2.formatting2;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.internal.AbstractTextReplacer;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeModelBasedRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.internal.StringBasedRegionAccess;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.osate.aadl2.*;
import org.osate.annexsupport.AnnexUtil;
import org.osate.annexsupport.ParseResultHolder;
import org.osate.xtext.aadl2.properties.formatting2.PropertiesFormatter;
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess;

import com.google.inject.ConfigurationException;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.ProvisionException;

/**
 * @since 5.0
 */
public class Aadl2Formatter extends PropertiesFormatter {
	@Inject
	private Aadl2GrammarAccess grammarAccess;

	protected void _format(PropertySet propertySet, IFormattableDocument document) {
		document.surround(propertySet, IHiddenRegionFormatter::noSpace);

		// Declaration line
		document.surround(textRegionExtensions.regionFor(propertySet).keyword(
				grammarAccess.getPropertySetAccess().getSetKeyword_1()), IHiddenRegionFormatter::oneSpace);
		ISemanticRegion isKeyword = textRegionExtensions.regionFor(propertySet)
				.keyword(grammarAccess.getPropertySetAccess().getIsKeyword_3());
		document.append(document.prepend(isKeyword, IHiddenRegionFormatter::oneSpace),
				formatter -> formatter.setNewLines(1, 1, 2));
		ISemanticRegion endKeyword = textRegionExtensions.regionFor(propertySet)
				.keyword(grammarAccess.getPropertySetAccess().getEndKeyword_7());
		document.interior(isKeyword, endKeyword, IHiddenRegionFormatter::indent);

		// With statements
		List<ISemanticRegion> withSemicolons = textRegionExtensions.regionFor(propertySet)
				.keywords(grammarAccess.getPropertySetAccess().getSemicolonKeyword_4_3());
		if (!withSemicolons.isEmpty()) {
			textRegionExtensions.regionFor(propertySet)
					.keywords(grammarAccess.getPropertySetAccess().getWithKeyword_4_0())
					.forEach(element -> document.append(element, IHiddenRegionFormatter::oneSpace));
			textRegionExtensions.regionFor(propertySet)
					.keywords(grammarAccess.getPropertySetAccess().getCommaKeyword_4_2_0()).forEach(element -> {
						document.append(document.prepend(element, IHiddenRegionFormatter::noSpace),
								IHiddenRegionFormatter::oneSpace);
					});
			take(withSemicolons, withSemicolons.size() - 1).forEach(element -> {
				document.append(document.prepend(element, IHiddenRegionFormatter::noSpace),
						formatter -> formatter.setNewLines(1));
			});
			boolean hasContents = !propertySet.getOwnedPropertyTypes().isEmpty()
					|| !propertySet.getOwnedProperties().isEmpty()
					|| !propertySet.getOwnedPropertyConstants().isEmpty()
					|| !propertySet.getOwnedAnnexSubclauses().isEmpty();
			int newLineCount = hasContents ? 2 : 1;
			document.append(document.prepend(lastOrNull(withSemicolons), IHiddenRegionFormatter::noSpace),
					formatter -> formatter.setNewLines(newLineCount));
		}

		// Contents
		propertySet.getOwnedPropertyTypes().forEach(element -> format(element, document));
		propertySet.getOwnedProperties().forEach(element -> format(element, document));
		propertySet.getOwnedPropertyConstants().forEach(element -> format(element, document));
		propertySet.getOwnedAnnexSubclauses().forEach(element -> format(element, document));

		// End line
		document.append(endKeyword, IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(propertySet)
						.keyword(grammarAccess.getPropertySetAccess().getSemicolonKeyword_9()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(AadlBoolean aadlBoolean, IFormattableDocument document) {
		if (aadlBoolean.getName() != null) {
			conditionalAppend(aadlBoolean, document, formatter -> formatter.setNewLines(1, 1, 2));
			document.append(document.prepend(
					textRegionExtensions.regionFor(aadlBoolean)
							.keyword(grammarAccess.getBooleanTypeAccess().getColonKeyword_1()),
					IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
			document.append(document.prepend(
					textRegionExtensions.regionFor(aadlBoolean)
							.keyword(grammarAccess.getBooleanTypeAccess().getAadlbooleanKeyword_3()),
					IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
		}
	}

	protected void _format(AadlString aadlString, IFormattableDocument document) {
		if (aadlString.getName() != null) {
			conditionalAppend(aadlString, document, formatter -> formatter.setNewLines(1, 1, 2));
			document.append(document.prepend(
					textRegionExtensions.regionFor(aadlString)
							.keyword(grammarAccess.getStringTypeAccess().getColonKeyword_1()),
					IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
			document.append(document.prepend(
					textRegionExtensions.regionFor(aadlString)
							.keyword(grammarAccess.getStringTypeAccess().getAadlstringKeyword_3()),
					IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
		}
	}

	protected void _format(EnumerationType enumerationType, IFormattableDocument document) {
		if (enumerationType.getName() == null) {
			document.append(
					textRegionExtensions.regionFor(enumerationType)
							.keyword(grammarAccess.getUnnamedEnumerationTypeAccess().getEnumerationKeyword_0()),
					IHiddenRegionFormatter::oneSpace);
			formatEnumerationTypeCommon(document,
					textRegionExtensions.regionFor(enumerationType).keyword(
							grammarAccess.getUnnamedEnumerationTypeAccess().getLeftParenthesisKeyword_1()),
					textRegionExtensions.regionFor(enumerationType).keyword(
							grammarAccess.getUnnamedEnumerationTypeAccess().getRightParenthesisKeyword_4()),
					textRegionExtensions.regionFor(enumerationType)
							.keywords(grammarAccess.getUnnamedEnumerationTypeAccess().getCommaKeyword_3_0()));
		} else {
			conditionalAppend(enumerationType, document,
					formatter -> formatter.setNewLines(1, 1, 2));
			document.append(document.prepend(
					textRegionExtensions.regionFor(enumerationType)
							.keyword(grammarAccess.getEnumerationTypeAccess().getColonKeyword_1()),
					IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
			document.surround(
					textRegionExtensions.regionFor(enumerationType)
							.keyword(grammarAccess.getEnumerationTypeAccess().getEnumerationKeyword_3()),
					IHiddenRegionFormatter::oneSpace);
			formatEnumerationTypeCommon(document,
					textRegionExtensions.regionFor(enumerationType)
							.keyword(grammarAccess.getEnumerationTypeAccess().getLeftParenthesisKeyword_4()),
					textRegionExtensions.regionFor(enumerationType)
							.keyword(grammarAccess.getEnumerationTypeAccess().getRightParenthesisKeyword_7()),
					textRegionExtensions.regionFor(enumerationType)
							.keywords(grammarAccess.getEnumerationTypeAccess().getCommaKeyword_6_0()));
			document.prepend(
					textRegionExtensions.regionFor(enumerationType)
							.keyword(grammarAccess.getPropertyTypeAccess().getSemicolonKeyword_1()),
					IHiddenRegionFormatter::noSpace);
		}
	}

	private void formatEnumerationTypeCommon(IFormattableDocument document, ISemanticRegion leftParenthesis,
			ISemanticRegion rightParenthesis, Iterable<ISemanticRegion> commas) {
		document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
		document.append(leftParenthesis, Aadl2Formatter::wrappableNoSpace);
		commas.forEach(comma -> formatSeparator(document, comma));
		prependNewLineOrNoSpace(document, rightParenthesis);
	}

	protected void _format(UnitsType unitsType, IFormattableDocument document) {
		if (unitsType.getName() == null) {
			document.append(
					textRegionExtensions.regionFor(unitsType)
							.keyword(grammarAccess.getUnnamedUnitsTypeAccess().getUnitsKeyword_0()),
					IHiddenRegionFormatter::oneSpace);
			formatUnitsTypeCommon(unitsType, document,
					textRegionExtensions.regionFor(unitsType)
							.keyword(grammarAccess.getUnnamedUnitsTypeAccess().getLeftParenthesisKeyword_1()),
					textRegionExtensions.regionFor(unitsType)
							.keyword(grammarAccess.getUnnamedUnitsTypeAccess().getRightParenthesisKeyword_4()),
					textRegionExtensions.regionFor(unitsType)
							.keywords(grammarAccess.getUnnamedUnitsTypeAccess().getCommaKeyword_3_0()));
		} else {
			conditionalAppend(unitsType, document, formatter -> formatter.setNewLines(1, 1, 2));
			document.append(document.prepend(
					textRegionExtensions.regionFor(unitsType)
							.keyword(grammarAccess.getUnitsTypeAccess().getColonKeyword_1()),
					IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
			document.surround(
					textRegionExtensions.regionFor(unitsType)
							.keyword(grammarAccess.getUnitsTypeAccess().getUnitsKeyword_3()),
					IHiddenRegionFormatter::oneSpace);
			formatUnitsTypeCommon(unitsType, document,
					textRegionExtensions.regionFor(unitsType)
							.keyword(grammarAccess.getUnitsTypeAccess().getLeftParenthesisKeyword_4()),
					textRegionExtensions.regionFor(unitsType)
							.keyword(grammarAccess.getUnitsTypeAccess().getRightParenthesisKeyword_7()),
					textRegionExtensions.regionFor(unitsType)
							.keywords(grammarAccess.getUnitsTypeAccess().getCommaKeyword_6_0()));
			document.prepend(
					textRegionExtensions.regionFor(unitsType)
							.keyword(grammarAccess.getPropertyTypeAccess().getSemicolonKeyword_1()),
					IHiddenRegionFormatter::noSpace);
		}
	}

	private void formatUnitsTypeCommon(UnitsType unitsType, IFormattableDocument document,
			ISemanticRegion leftParenthesis, ISemanticRegion rightParenthesis, Iterable<ISemanticRegion> commas) {
		document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
		document.append(leftParenthesis, Aadl2Formatter::wrappableNoSpace);
		unitsType.getOwnedLiterals().forEach(literal -> format(literal, document));
		commas.forEach(comma -> formatSeparator(document, comma));
		prependNewLineOrNoSpace(document, rightParenthesis);
	}

	protected void _format(UnitLiteral unitLiteral, IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(unitLiteral).keyword(
						grammarAccess.getUnitLiteralConversionAccess().getEqualsSignGreaterThanSignKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(unitLiteral)
						.ruleCall(grammarAccess.getUnitLiteralConversionAccess().getSTARParserRuleCall_3()),
				IHiddenRegionFormatter::oneSpace);
	}

	protected void _format(AadlReal aadlReal, IFormattableDocument document) {
		if (aadlReal.getName() == null) {
			formatAadlRealCommon(aadlReal, document, textRegionExtensions.regionFor(aadlReal)
					.keyword(grammarAccess.getUnnamedRealTypeAccess().getUnitsKeyword_3_1_0()));
		} else {
			conditionalAppend(aadlReal, document, formatter -> formatter.setNewLines(1, 1, 2));
			document.append(document.prepend(
					textRegionExtensions.regionFor(aadlReal)
							.keyword(grammarAccess.getRealTypeAccess().getColonKeyword_1()),
					IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
			document.prepend(
					textRegionExtensions.regionFor(aadlReal)
							.keyword(grammarAccess.getRealTypeAccess().getAadlrealKeyword_3()),
					IHiddenRegionFormatter::oneSpace);
			formatAadlRealCommon(aadlReal, document, textRegionExtensions.regionFor(aadlReal)
					.keyword(grammarAccess.getRealTypeAccess().getUnitsKeyword_5_1_0()));
			document.prepend(
					textRegionExtensions.regionFor(aadlReal)
							.keyword(grammarAccess.getPropertyTypeAccess().getSemicolonKeyword_1()),
					IHiddenRegionFormatter::noSpace);
		}
	}

	private void formatAadlRealCommon(AadlReal aadlReal,
			IFormattableDocument document, ISemanticRegion unitsKeyword) {
		// Range
		document.prepend(aadlReal.getRange(), IHiddenRegionFormatter::oneSpace);
		format(aadlReal.getRange(), document);

		// Owned units
		document.prepend(aadlReal.getOwnedUnitsType(), IHiddenRegionFormatter::oneSpace);
		format(aadlReal.getOwnedUnitsType(), document);

		// Referenced units
		document.surround(unitsKeyword, IHiddenRegionFormatter::oneSpace);
	}

	protected void _format(NumericRange numericRange, IFormattableDocument document) {
		format(numericRange.getLowerBound(), document);
		document.surround(
				textRegionExtensions.regionFor(numericRange)
						.keyword(grammarAccess.getIntegerRangeAccess().getFullStopFullStopKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(numericRange)
						.keyword(grammarAccess.getRealRangeAccess().getFullStopFullStopKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		format(numericRange.getUpperBound(), document);
	}

	protected void _format(AadlInteger aadlInteger, IFormattableDocument document) {
		if (aadlInteger.getName() == null) {
			formatAadlIntegerCommon(aadlInteger, document, textRegionExtensions.regionFor(aadlInteger)
					.keyword(grammarAccess.getUnnamedIntegerTypeAccess().getUnitsKeyword_3_1_0()));
		} else {
			conditionalAppend(aadlInteger, document, formatter -> formatter.setNewLines(1, 1, 2));
			document.append(document.prepend(
					textRegionExtensions.regionFor(aadlInteger)
							.keyword(grammarAccess.getIntegerTypeAccess().getColonKeyword_1()),
					IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
			document.prepend(
					textRegionExtensions.regionFor(aadlInteger)
							.keyword(grammarAccess.getIntegerTypeAccess().getAadlintegerKeyword_3()),
					IHiddenRegionFormatter::oneSpace);
			formatAadlIntegerCommon(aadlInteger, document, textRegionExtensions.regionFor(aadlInteger)
					.keyword(grammarAccess.getIntegerTypeAccess().getUnitsKeyword_5_1_0()));
			document.prepend(
					textRegionExtensions.regionFor(aadlInteger)
							.keyword(grammarAccess.getPropertyTypeAccess().getSemicolonKeyword_1()),
					IHiddenRegionFormatter::noSpace);
		}
	}

	private void formatAadlIntegerCommon(AadlInteger aadlInteger,
			IFormattableDocument document, ISemanticRegion unitsKeyword) {
		// Range
		document.prepend(aadlInteger.getRange(), IHiddenRegionFormatter::oneSpace);
		format(aadlInteger.getRange(), document);

		// Owned Units
		document.prepend(aadlInteger.getOwnedUnitsType(), IHiddenRegionFormatter::oneSpace);
		format(aadlInteger.getOwnedUnitsType(), document);

		// Referenced units
		document.surround(unitsKeyword, IHiddenRegionFormatter::oneSpace);
	}

	protected void _format(RangeType rangeType, IFormattableDocument document) {
		if (rangeType.getName() == null) {
			document.append(
					textRegionExtensions.regionFor(rangeType)
							.keyword(grammarAccess.getUnnamedRangeTypeAccess().getRangeKeyword_1()),
					IHiddenRegionFormatter::oneSpace);
			formatRangeTypeCommon(rangeType, document, textRegionExtensions.regionFor(rangeType).assignment(
					grammarAccess.getUnnamedRangeTypeAccess().getReferencedNumberTypeAssignment_3_1()));
		} else {
			conditionalAppend(rangeType, document, formatter -> formatter.setNewLines(1, 1, 2));
			document.append(document.prepend(
					textRegionExtensions.regionFor(rangeType)
							.keyword(grammarAccess.getRangeTypeAccess().getColonKeyword_1()),
					IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
			document.surround(
					textRegionExtensions.regionFor(rangeType)
							.keyword(grammarAccess.getRangeTypeAccess().getRangeKeyword_3()),
					IHiddenRegionFormatter::oneSpace);
			formatRangeTypeCommon(rangeType, document, textRegionExtensions.regionFor(rangeType)
					.assignment(grammarAccess.getRangeTypeAccess().getReferencedNumberTypeAssignment_5_1()));
			document.prepend(
					textRegionExtensions.regionFor(rangeType)
							.keyword(grammarAccess.getPropertyTypeAccess().getSemicolonKeyword_1()),
					IHiddenRegionFormatter::noSpace);
		}
	}

	private void formatRangeTypeCommon(RangeType rangeType,
			IFormattableDocument document, ISemanticRegion referencedNumberType) {
		// Owned number type
		document.prepend(rangeType.getOwnedNumberType(), IHiddenRegionFormatter::oneSpace);
		format(rangeType.getOwnedNumberType(), document);

		// Referenced number type
		document.prepend(referencedNumberType, IHiddenRegionFormatter::oneSpace);
	}

	protected void _format(ClassifierType classifierType, IFormattableDocument document) {
		if (classifierType.getName() == null) {
			formatClassifierTypeCommon(classifierType, document,
					textRegionExtensions.regionFor(classifierType).keyword(
							grammarAccess.getUnnamedClassifierTypeAccess().getLeftParenthesisKeyword_2_0()),
					textRegionExtensions.regionFor(classifierType).keyword(
							grammarAccess.getUnnamedClassifierTypeAccess().getRightParenthesisKeyword_2_3()),
					textRegionExtensions.regionFor(classifierType)
							.keywords(grammarAccess.getUnnamedClassifierTypeAccess().getCommaKeyword_2_2_0()));
		} else {
			conditionalAppend(classifierType, document,
					formatter -> formatter.setNewLines(1, 1, 2));
			document.append(document.prepend(
					textRegionExtensions.regionFor(classifierType)
							.keyword(grammarAccess.getClassifierTypeAccess().getColonKeyword_1()),
					IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
			document.prepend(
					textRegionExtensions.regionFor(classifierType)
							.keyword(grammarAccess.getClassifierTypeAccess().getClassifierKeyword_3()),
					IHiddenRegionFormatter::oneSpace);
			formatClassifierTypeCommon(classifierType, document,
					textRegionExtensions.regionFor(classifierType)
							.keyword(grammarAccess.getClassifierTypeAccess().getLeftParenthesisKeyword_4_0()),
					textRegionExtensions.regionFor(classifierType)
							.keyword(grammarAccess.getClassifierTypeAccess().getRightParenthesisKeyword_4_3()),
					textRegionExtensions.regionFor(classifierType)
							.keywords(grammarAccess.getClassifierTypeAccess().getCommaKeyword_4_2_0()));
			document.prepend(
					textRegionExtensions.regionFor(classifierType)
							.keyword(grammarAccess.getPropertyTypeAccess().getSemicolonKeyword_1()),
					IHiddenRegionFormatter::noSpace);
		}
	}

	private void formatClassifierTypeCommon(ClassifierType classifierType, IFormattableDocument document,
			ISemanticRegion leftParenthesis, ISemanticRegion rightParenthesis, Iterable<ISemanticRegion> commas) {
		if (leftParenthesis == null || rightParenthesis == null) {
			return;
		}
		document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
		document.append(document.prepend(leftParenthesis, IHiddenRegionFormatter::oneSpace),
				Aadl2Formatter::wrappableNoSpace);
		commas.forEach(comma -> formatSeparator(document, comma));
		classifierType.getClassifierReferences().forEach(reference -> format(reference, document));
		prependNewLineOrNoSpace(document, rightParenthesis);
	}

	protected void _format(MetaclassReference metaclassReference, IFormattableDocument document) {
		// Annex prefix
		document.surround(
				textRegionExtensions.regionFor(metaclassReference)
						.assignment(grammarAccess.getQMReferenceAccess().getAnnexNameAssignment_0_1()),
				IHiddenRegionFormatter::noSpace);
		document.surround(
				textRegionExtensions.regionFor(metaclassReference)
						.ruleCall(grammarAccess.getQMReferenceAccess().getSTARParserRuleCall_0_3()),
				IHiddenRegionFormatter::noSpace);
		document.append(
				textRegionExtensions.regionFor(metaclassReference)
						.ruleCall(grammarAccess.getQMReferenceAccess().getSTARParserRuleCall_0_4()),
				IHiddenRegionFormatter::noSpace);

		// Names
		tail(textRegionExtensions.regionFor(metaclassReference)
				.assignments(grammarAccess.getQMReferenceAccess().getMetaclassNameAssignment_1()))
				.forEach(element -> document.prepend(element, IHiddenRegionFormatter::oneSpace));
	}

	protected void _format(ReferenceType referenceType, IFormattableDocument document) {
		if (referenceType.getName() == null) {
			formatReferenceTypeCommon(referenceType, document,
					textRegionExtensions.regionFor(referenceType).keyword(
							grammarAccess.getUnnamedReferenceTypeAccess().getLeftParenthesisKeyword_2_0()),
					textRegionExtensions.regionFor(referenceType).keyword(
							grammarAccess.getUnnamedReferenceTypeAccess().getRightParenthesisKeyword_2_3()),
					textRegionExtensions.regionFor(referenceType)
							.keywords(grammarAccess.getUnnamedReferenceTypeAccess().getCommaKeyword_2_2_0()));
		} else {
			conditionalAppend(referenceType, document, formatter -> formatter.setNewLines(1, 1, 2));
			document.append(document.prepend(
					textRegionExtensions.regionFor(referenceType)
							.keyword(grammarAccess.getReferenceTypeAccess().getColonKeyword_1()),
					IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
			document.prepend(
					textRegionExtensions.regionFor(referenceType)
							.keyword(grammarAccess.getReferenceTypeAccess().getReferenceKeyword_3()),
					IHiddenRegionFormatter::oneSpace);
			formatReferenceTypeCommon(referenceType, document,
					textRegionExtensions.regionFor(referenceType)
							.keyword(grammarAccess.getReferenceTypeAccess().getLeftParenthesisKeyword_4_0()),
					textRegionExtensions.regionFor(referenceType)
							.keyword(grammarAccess.getReferenceTypeAccess().getRightParenthesisKeyword_4_3()),
					textRegionExtensions.regionFor(referenceType)
							.keywords(grammarAccess.getReferenceTypeAccess().getCommaKeyword_4_2_0()));
			document.prepend(
					textRegionExtensions.regionFor(referenceType)
							.keyword(grammarAccess.getPropertyTypeAccess().getSemicolonKeyword_1()),
					IHiddenRegionFormatter::noSpace);
		}
	}

	private void formatReferenceTypeCommon(ReferenceType referenceType, IFormattableDocument document,
			ISemanticRegion leftParenthesis, ISemanticRegion rightParenthesis, Iterable<ISemanticRegion> commas) {
		if (leftParenthesis == null || rightParenthesis == null) {
			return;
		}
		document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
		document.append(document.prepend(leftParenthesis, IHiddenRegionFormatter::oneSpace),
				Aadl2Formatter::wrappableNoSpace);
		commas.forEach(comma -> formatSeparator(document, comma));
		referenceType.getNamedElementReferences().forEach(reference -> format(reference, document));
		prependNewLineOrNoSpace(document, rightParenthesis);
	}

	protected void _format(RecordType recordType, IFormattableDocument document) {
		if (recordType.getName() == null) {
			formatRecordTypeCommon(recordType, document,
					textRegionExtensions.regionFor(recordType)
							.keyword(grammarAccess.getUnnamedRecordTypeAccess().getLeftParenthesisKeyword_1()),
					textRegionExtensions.regionFor(recordType)
							.keyword(grammarAccess.getUnnamedRecordTypeAccess().getRightParenthesisKeyword_3()));
		} else {
			conditionalAppend(recordType, document, formatter -> formatter.setNewLines(1, 1, 2));
			document.append(document.prepend(
					textRegionExtensions.regionFor(recordType)
							.keyword(grammarAccess.getRecordTypeAccess().getColonKeyword_1()),
					IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
			document.append(
					textRegionExtensions.regionFor(recordType)
							.keyword(grammarAccess.getRecordTypeAccess().getTypeKeyword_2()),
					IHiddenRegionFormatter::oneSpace);
			formatRecordTypeCommon(recordType, document,
					textRegionExtensions.regionFor(recordType)
							.keyword(grammarAccess.getRecordTypeAccess().getLeftParenthesisKeyword_4()),
					textRegionExtensions.regionFor(recordType)
							.keyword(grammarAccess.getRecordTypeAccess().getRightParenthesisKeyword_6()));
			document.prepend(
					textRegionExtensions.regionFor(recordType)
							.keyword(grammarAccess.getPropertyTypeAccess().getSemicolonKeyword_1()),
					IHiddenRegionFormatter::noSpace);
		}
	}

	private void formatRecordTypeCommon(RecordType recordType, IFormattableDocument document,
			ISemanticRegion leftParenthesis, ISemanticRegion rightParenthesis) {
		document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
		document.append(document.prepend(leftParenthesis, IHiddenRegionFormatter::oneSpace),
				Aadl2Formatter::wrappableNoSpace);
		// Separate every field from the previous one; the first one is preceded by the parenthesis.
		tail(recordType.getOwnedFields()).forEach(field -> document.prepend(field, Aadl2Formatter::wrappableSpace));
		recordType.getOwnedFields().forEach(field -> format(field, document));
		prependNewLineOrNoSpace(document, rightParenthesis);
	}

	protected void _format(BasicProperty basicProperty, IFormattableDocument document) {
		document.append(document.prepend(
				textRegionExtensions.regionFor(basicProperty)
						.keyword(grammarAccess.getRecordFieldAccess().getColonKeyword_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		format(basicProperty.getOwnedPropertyType(), document);
		document.prepend(
				textRegionExtensions.regionFor(basicProperty)
						.keyword(grammarAccess.getRecordFieldAccess().getSemicolonKeyword_3()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(ListType listType, IFormattableDocument document) {
		document.surround(textRegionExtensions.regionFor(listType)
				.keyword(grammarAccess.getListTypeAccess().getOfKeyword_1()), IHiddenRegionFormatter::oneSpace);
		format(listType.getOwnedElementType(), document);
	}

	protected void _format(PropertyConstant propertyConstant, IFormattableDocument document) {
		conditionalAppend(propertyConstant, document,
				formatter -> formatter.setNewLines(1, 1, 2));
		document.append(document.prepend(
				textRegionExtensions.regionFor(propertyConstant)
						.keyword(grammarAccess.getPropertyConstantAccess().getColonKeyword_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(propertyConstant)
						.keyword(grammarAccess.getPropertyConstantAccess().getConstantKeyword_2()),
				IHiddenRegionFormatter::oneSpace);

		// Owned property type
		format(propertyConstant.getOwnedPropertyType(), document);
		document.surround(
				textRegionExtensions.regionFor(propertyConstant).keyword(
						grammarAccess.getPropertyConstantAccess().getEqualsSignGreaterThanSignKeyword_4()),
				IHiddenRegionFormatter::oneSpace);

		// Constant value
		format(propertyConstant.getConstantValue(), document);
		document.prepend(
				textRegionExtensions.regionFor(propertyConstant)
						.keyword(grammarAccess.getPropertyConstantAccess().getSemicolonKeyword_6()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(Property property, IFormattableDocument document) {
		conditionalAppend(property, document, formatter -> formatter.setNewLines(1, 1, 2));
		document.append(document.prepend(
				textRegionExtensions.regionFor(property)
						.keyword(grammarAccess.getPropertyDefinitionAccess().getColonKeyword_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(property)
						.keyword(grammarAccess.getPropertyDefinitionAccess().getInheritInheritKeyword_2_0()),
				IHiddenRegionFormatter::oneSpace);

		// Owned property type
		format(property.getOwnedPropertyType(), document);

		// Default value
		document.surround(
				textRegionExtensions.regionFor(property).keyword(
						grammarAccess.getPropertyDefinitionAccess().getEqualsSignGreaterThanSignKeyword_4_0()),
				IHiddenRegionFormatter::oneSpace);
		format(property.getDefaultValue(), document);

		// Applies to
		document.surround(
				textRegionExtensions.regionFor(property)
						.keyword(grammarAccess.getPropertyDefinitionAccess().getAppliesKeyword_5()),
				IHiddenRegionFormatter::oneSpace);
		ISemanticRegion leftParenthesis = textRegionExtensions.regionFor(property)
				.keyword(grammarAccess.getPropertyDefinitionAccess().getLeftParenthesisKeyword_7());
		ISemanticRegion rightParenthesis = textRegionExtensions.regionFor(property)
				.keyword(grammarAccess.getPropertyDefinitionAccess().getRightParenthesisKeyword_9());
		document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
		document.append(document.prepend(leftParenthesis, IHiddenRegionFormatter::oneSpace),
				Aadl2Formatter::wrappableNoSpace);
		textRegionExtensions.regionFor(property)
				.keywords(grammarAccess.getPropertyDefinitionAccess().getCommaKeyword_8_0_1_0())
				.forEach(element -> formatSeparator(document, element));
		property.getAppliesTos().forEach(element -> format(element, document));
		if (rightParenthesis != null) {
			prependNewLineOrNoSpace(document, rightParenthesis);
			document.append(rightParenthesis, IHiddenRegionFormatter::noSpace);
		}
	}

	protected void _format(AadlPackage aadlPackage, IFormattableDocument document) {
		document.surround(aadlPackage, IHiddenRegionFormatter::noSpace);

		// Declaration line
		document.append(document.prepend(
				textRegionExtensions.regionFor(aadlPackage)
						.assignment(grammarAccess.getAadlPackageAccess().getNameAssignment_1()),
				IHiddenRegionFormatter::oneSpace), formatter -> formatter.setNewLines(1, 1, 2));

		// Sections
		format(aadlPackage.getOwnedPublicSection(), document);
		format(aadlPackage.getOwnedPrivateSection(), document);

		// Properties
		ISemanticRegion propertiesKeyword = textRegionExtensions.regionFor(aadlPackage)
				.keyword(grammarAccess.getAadlPackageAccess().getPropertiesKeyword_3_0());
		document.append(propertiesKeyword, formatter -> formatter.setNewLines(1, 1, 2));
		ISemanticRegion endKeyword = textRegionExtensions.regionFor(aadlPackage)
				.keyword(grammarAccess.getAadlPackageAccess().getEndKeyword_4());
		document.interior(propertiesKeyword, endKeyword, IHiddenRegionFormatter::indent);
		aadlPackage.getOwnedPropertyAssociations().forEach(element -> {
			document.append(element, formatter -> formatter.setNewLines(1, 1, 2));
			format(element, document);
		});
		document.append(document.prepend(
				textRegionExtensions.regionFor(aadlPackage)
						.keyword(grammarAccess.getAadlPackageAccess().getSemicolonKeyword_3_1_1_1()),
				IHiddenRegionFormatter::noSpace), formatter -> formatter.setNewLines(1, 1, 2));

		// End line
		document.append(endKeyword, IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(aadlPackage)
						.keyword(grammarAccess.getAadlPackageAccess().getSemicolonKeyword_6()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(PropertyAssociation propertyAssociation, IFormattableDocument document) {
		// Prefix
		document.surround(textRegionExtensions.regionFor(propertyAssociation).keyword("=>"),
				IHiddenRegionFormatter::oneSpace);
		document.surround(textRegionExtensions.regionFor(propertyAssociation).keyword("+=>"),
				IHiddenRegionFormatter::oneSpace);
		document.append(textRegionExtensions.regionFor(propertyAssociation).keyword("constant"),
				IHiddenRegionFormatter::oneSpace);

		// Values
		propertyAssociation.getOwnedValues().forEach(element -> format(element, document));
		textRegionExtensions.regionFor(propertyAssociation).keywords(",").forEach(element -> {
			document.append(document.prepend(element, IHiddenRegionFormatter::noSpace),
					IHiddenRegionFormatter::oneSpace);
		});

		// Applies to
		document.surround(
				textRegionExtensions.regionFor(propertyAssociation)
						.keyword(grammarAccess.getContainedPropertyAssociationAccess().getAppliesKeyword_4_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(propertyAssociation)
						.keyword(grammarAccess.getContainedPropertyAssociationAccess().getToKeyword_4_1()),
				IHiddenRegionFormatter::oneSpace);
		propertyAssociation.getAppliesTos().forEach(element -> format(element, document));

		// In binding
		document.surround(textRegionExtensions.regionFor(propertyAssociation).keyword("in"),
				IHiddenRegionFormatter::oneSpace);
		document.append(document.prepend(textRegionExtensions.regionFor(propertyAssociation).keyword("("),
				IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
		document.prepend(textRegionExtensions.regionFor(propertyAssociation).keyword(")"),
				IHiddenRegionFormatter::noSpace);
		document.prepend(textRegionExtensions.regionFor(propertyAssociation).keyword(";"),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(PublicPackageSection publicPackageSection, IFormattableDocument document) {
		formatPackageSectionCommon(publicPackageSection, document,
				textRegionExtensions.regionFor(publicPackageSection)
						.keyword(grammarAccess.getPublicPackageSectionAccess().getPublicKeyword_1()),
				textRegionExtensions.regionFor(publicPackageSection)
						.keywords(grammarAccess.getPublicPackageSectionAccess().getWithKeyword_2_0_0()),
				textRegionExtensions.regionFor(publicPackageSection)
						.keywords(grammarAccess.getPublicPackageSectionAccess().getCommaKeyword_2_0_2_0()),
				textRegionExtensions.regionFor(publicPackageSection)
						.keywords(grammarAccess.getPublicPackageSectionAccess().getSemicolonKeyword_2_0_3()));
	}

	protected void _format(PrivatePackageSection privatePackageSection, IFormattableDocument document) {
		formatPackageSectionCommon(privatePackageSection, document,
				textRegionExtensions.regionFor(privatePackageSection)
						.keyword(grammarAccess.getPrivatePackageSectionAccess().getPrivateKeyword_1()),
				textRegionExtensions.regionFor(privatePackageSection)
						.keywords(grammarAccess.getPrivatePackageSectionAccess().getWithKeyword_2_0_0()),
				textRegionExtensions.regionFor(privatePackageSection)
						.keywords(grammarAccess.getPrivatePackageSectionAccess().getCommaKeyword_2_0_2_0()),
				textRegionExtensions.regionFor(privatePackageSection)
						.keywords(grammarAccess.getPrivatePackageSectionAccess().getSemicolonKeyword_2_0_3()));
	}

	private void formatPackageSectionCommon(PackageSection packageSection,
			IFormattableDocument document, ISemanticRegion visibilityKeyword,
			Iterable<ISemanticRegion> withs, Iterable<ISemanticRegion> commas,
			Iterable<ISemanticRegion> semicolons) {
		if (!packageSection.eContents().isEmpty() || !packageSection.getImportedUnits().isEmpty()) {
			document.interior(packageSection, IHiddenRegionFormatter::indent);
		}

		// Visibility label
		document.append(visibilityKeyword, formatter -> formatter.setNewLines(1, 1, 2));

		// With statements
		withs.forEach(element -> document.append(element, IHiddenRegionFormatter::oneSpace));
		commas.forEach(element -> {
			document.append(document.prepend(element, IHiddenRegionFormatter::noSpace),
					IHiddenRegionFormatter::oneSpace);
		});
		semicolons.forEach(element -> {
			var nextElement = nextSemanticElement(element);
			int newLineCount = startsTopLevelDeclaration(nextElement) && nextElement != packageSection ? 2 : 1;
			document.append(document.prepend(element, IHiddenRegionFormatter::noSpace),
					formatter -> formatter.setNewLines(newLineCount));
		});

		// Renames
		packageSection.getOwnedPackageRenames().forEach(element -> format(element, document));
		packageSection.getOwnedFeatureGroupTypeRenames().forEach(element -> format(element, document));
		packageSection.getOwnedComponentTypeRenames().forEach(element -> format(element, document));

		// Contents
		packageSection.getOwnedClassifiers().forEach(element -> format(element, document));
		packageSection.getOwnedAnnexLibraries().forEach(element -> format(element, document));
	}

	protected void _format(PackageRename packageRename, IFormattableDocument document) {
		int newLineCount = startsTopLevelDeclaration(nextSemanticElement(packageRename)) ? 2 : 1;
		conditionalAppend(packageRename, document,
				formatter -> formatter.setNewLines(newLineCount));

		// PackageRename parser rule
		document.surround(
				textRegionExtensions.regionFor(packageRename)
						.keyword(grammarAccess.getPackageRenameAccess().getRenamesKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(packageRename)
						.keyword(grammarAccess.getPackageRenameAccess().getPackageKeyword_2()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(packageRename)
						.keyword(grammarAccess.getPackageRenameAccess().getColonColonKeyword_4_0()),
				IHiddenRegionFormatter::noSpace);
		document.prepend(
				textRegionExtensions.regionFor(packageRename)
						.keyword(grammarAccess.getPackageRenameAccess().getSemicolonKeyword_5()),
				IHiddenRegionFormatter::noSpace);

		// RenameAll parser rule
		document.append(
				textRegionExtensions.regionFor(packageRename)
						.keyword(grammarAccess.getRenameAllAccess().getRenamesKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(packageRename)
						.keyword(grammarAccess.getRenameAllAccess().getColonColonKeyword_2()),
				IHiddenRegionFormatter::noSpace);
		document.prepend(
				textRegionExtensions.regionFor(packageRename)
						.keyword(grammarAccess.getRenameAllAccess().getSemicolonKeyword_4()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(FeatureGroupTypeRename featureGroupTypeRename, IFormattableDocument document) {
		int newLineCount = startsTopLevelDeclaration(nextSemanticElement(featureGroupTypeRename)) ? 2 : 1;
		conditionalAppend(featureGroupTypeRename, document,
				formatter -> formatter.setNewLines(newLineCount));
		document.append(
				textRegionExtensions.regionFor(featureGroupTypeRename)
						.assignment(grammarAccess.getFGTRenameAccess().getNameAssignment_0()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(featureGroupTypeRename)
						.keyword(grammarAccess.getFGTRenameAccess().getFeatureKeyword_2()),
				IHiddenRegionFormatter::oneSpace);
		document.append(textRegionExtensions.regionFor(featureGroupTypeRename).keyword(
				grammarAccess.getFGTRenameAccess().getGroupKeyword_3()), IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(featureGroupTypeRename)
						.keyword(grammarAccess.getFGTRenameAccess().getSemicolonKeyword_5()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(ComponentTypeRename componentTypeRename, IFormattableDocument document) {
		int newLineCount = startsTopLevelDeclaration(nextSemanticElement(componentTypeRename)) ? 2 : 1;
		conditionalAppend(componentTypeRename, document,
				formatter -> formatter.setNewLines(newLineCount));
		document.append(
				textRegionExtensions.regionFor(componentTypeRename)
						.assignment(grammarAccess.getCTRenameAccess().getNameAssignment_0()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(componentTypeRename)
						.assignment(grammarAccess.getCTRenameAccess().getCategoryAssignment_2()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(componentTypeRename)
						.keyword(grammarAccess.getCTRenameAccess().getSemicolonKeyword_4()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(DefaultAnnexLibrary defaultAnnexLibrary, IFormattableDocument document) {
		int newLineCount = startsTopLevelDeclaration(nextSemanticElement(defaultAnnexLibrary)) ? 2 : 1;
		conditionalAppend(defaultAnnexLibrary, document,
				formatter -> formatter.setNewLines(newLineCount, newLineCount, 2));
		document.surround(
				textRegionExtensions.regionFor(defaultAnnexLibrary)
						.assignment(grammarAccess.getDefaultAnnexLibraryAccess().getNameAssignment_1()),
				IHiddenRegionFormatter::oneSpace);
		AnnexLibrary parsedLibrary = defaultAnnexLibrary.getParsedAnnexLibrary();
		ISemanticRegion sourceTextRegion = textRegionExtensions.regionFor(defaultAnnexLibrary)
				.assignment(grammarAccess.getDefaultAnnexLibraryAccess().getSourceTextAssignment_2());
		formatAnnexText(parsedLibrary, defaultAnnexLibrary.getName(), sourceTextRegion, 1, document);
		performModification(defaultAnnexLibrary, () -> defaultAnnexLibrary.setParsedAnnexLibrary(parsedLibrary));
		document.prepend(
				textRegionExtensions.regionFor(defaultAnnexLibrary)
						.keyword(grammarAccess.getDefaultAnnexLibraryAccess().getSemicolonKeyword_3()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(AbstractType abstractType, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(abstractType)
						.keyword(grammarAccess.getAbstractTypeAccess().getAbstractKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentTypeCommon(abstractType, document, textRegionExtensions.regionFor(abstractType)
				.assignment(grammarAccess.getAbstractTypeAccess().getNameAssignment_1()));
	}

	protected void _format(SystemType systemType, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(systemType)
						.keyword(grammarAccess.getSystemTypeAccess().getSystemKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentTypeCommon(systemType, document, textRegionExtensions.regionFor(systemType)
				.assignment(grammarAccess.getSystemTypeAccess().getNameAssignment_1()));
	}

	protected void _format(ProcessType processType, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(processType)
						.keyword(grammarAccess.getProcessTypeAccess().getProcessKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentTypeCommon(processType, document, textRegionExtensions.regionFor(processType)
				.assignment(grammarAccess.getProcessTypeAccess().getNameAssignment_1()));
	}

	protected void _format(ThreadGroupType threadGroupType, IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(threadGroupType)
						.keyword(grammarAccess.getThreadGroupTypeAccess().getGroupKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentTypeCommon(threadGroupType, document, textRegionExtensions.regionFor(threadGroupType)
				.assignment(grammarAccess.getThreadGroupTypeAccess().getNameAssignment_2()));
	}

	protected void _format(ThreadType threadType, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(threadType)
						.keyword(grammarAccess.getThreadTypeAccess().getThreadKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentTypeCommon(threadType, document, textRegionExtensions.regionFor(threadType)
				.assignment(grammarAccess.getThreadTypeAccess().getNameAssignment_1()));
	}

	protected void _format(SubprogramType subprogramType, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(subprogramType)
						.keyword(grammarAccess.getSubprogramTypeAccess().getSubprogramKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentTypeCommon(subprogramType, document, textRegionExtensions.regionFor(subprogramType)
				.assignment(grammarAccess.getSubprogramTypeAccess().getNameAssignment_1()));
	}

	protected void _format(SubprogramGroupType subprogramGroupType, IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(subprogramGroupType)
						.keyword(grammarAccess.getSubprogramGroupTypeAccess().getGroupKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentTypeCommon(subprogramGroupType, document,
				textRegionExtensions.regionFor(subprogramGroupType)
						.assignment(grammarAccess.getSubprogramGroupTypeAccess().getNameAssignment_2()));
	}

	protected void _format(ProcessorType processorType, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(processorType)
						.keyword(grammarAccess.getProcessorTypeAccess().getProcessorKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentTypeCommon(processorType, document, textRegionExtensions.regionFor(processorType)
				.assignment(grammarAccess.getProcessorTypeAccess().getNameAssignment_1()));
	}

	protected void _format(DeviceType deviceType, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(deviceType)
						.keyword(grammarAccess.getDeviceTypeAccess().getDeviceKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentTypeCommon(deviceType, document, textRegionExtensions.regionFor(deviceType)
				.assignment(grammarAccess.getDeviceTypeAccess().getNameAssignment_1()));
	}

	protected void _format(MemoryType memoryType, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(memoryType)
						.keyword(grammarAccess.getMemoryTypeAccess().getMemoryKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentTypeCommon(memoryType, document, textRegionExtensions.regionFor(memoryType)
				.assignment(grammarAccess.getMemoryTypeAccess().getNameAssignment_1()));
	}

	protected void _format(BusType busType, IFormattableDocument document) {
		document.append(textRegionExtensions.regionFor(busType)
				.keyword(grammarAccess.getBusTypeAccess().getBusKeyword_0()), IHiddenRegionFormatter::oneSpace);
		formatComponentTypeCommon(busType, document, textRegionExtensions.regionFor(busType)
				.assignment(grammarAccess.getBusTypeAccess().getNameAssignment_1()));
	}

	protected void _format(VirtualBusType virtualBusType, IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(virtualBusType)
						.keyword(grammarAccess.getVirtualBusTypeAccess().getBusKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentTypeCommon(virtualBusType, document, textRegionExtensions.regionFor(virtualBusType)
				.assignment(grammarAccess.getVirtualBusTypeAccess().getNameAssignment_2()));
	}

	protected void _format(VirtualProcessorType virtualProcessorType, IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(virtualProcessorType)
						.keyword(grammarAccess.getVirtualProcessorTypeAccess().getProcessorKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentTypeCommon(virtualProcessorType, document,
				textRegionExtensions.regionFor(virtualProcessorType)
						.assignment(grammarAccess.getVirtualProcessorTypeAccess().getNameAssignment_2()));
	}

	protected void _format(DataType dataType, IFormattableDocument document) {
		document.append(textRegionExtensions.regionFor(dataType)
				.keyword(grammarAccess.getDataTypeAccess().getDataKeyword_0()), IHiddenRegionFormatter::oneSpace);
		formatComponentTypeCommon(dataType, document, textRegionExtensions.regionFor(dataType)
				.assignment(grammarAccess.getDataTypeAccess().getNameAssignment_1()));
	}

	private void formatComponentTypeCommon(ComponentType componentType,
			IFormattableDocument document, ISemanticRegion nameAssignment) {
		int newLineCount = startsTopLevelDeclaration(nextSemanticElement(componentType)) ? 2 : 1;
		conditionalAppend(componentType, document,
				formatter -> formatter.setNewLines(newLineCount, newLineCount, 2));
		ISemanticRegion endKeyword = textRegionExtensions.regionFor(componentType).keyword("end");

		// Declaration line
		if (componentType.getOwnedExtension() == null) {
			document.append(nameAssignment, formatter -> formatter.setNewLines(1, 1, 2));
			document.interior(nameAssignment, endKeyword, IHiddenRegionFormatter::indent);
		} else {
			document.append(nameAssignment, IHiddenRegionFormatter::oneSpace);
			format(componentType.getOwnedExtension(), document);
			if (componentType.getOwnedPrototypeBindings().isEmpty()) {
				document.append(componentType.getOwnedExtension(),
						formatter -> formatter.setNewLines(1, 1, 2));
				document.interior(
						lastOrNull(textRegionExtensions.allSemanticRegions(componentType.getOwnedExtension())),
						endKeyword, IHiddenRegionFormatter::indent);
			} else {
				ISemanticRegion leftParenthesis = textRegionExtensions.regionFor(componentType)
						.keyword("(");
				ISemanticRegion rightParenthesis = textRegionExtensions.regionFor(componentType)
						.keyword(")");
				document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
				document.append(document.prepend(leftParenthesis, IHiddenRegionFormatter::oneSpace),
						Aadl2Formatter::wrappableNoSpace);
				textRegionExtensions.regionFor(componentType)
						.keywords(",")
						.forEach(element -> formatSeparator(document, element));
				componentType.getOwnedPrototypeBindings().forEach(element -> format(element, document));
				if (rightParenthesis != null) {
					prependNewLineOrNoSpace(document, rightParenthesis);
					document.append(rightParenthesis, formatter -> formatter.setNewLines(1, 1, 2));
					document.interior(rightParenthesis, endKeyword, IHiddenRegionFormatter::indent);
				}
			}
		}

		// Section headings
		ISemanticRegion prototypesKeyword = textRegionExtensions.regionFor(componentType)
				.keyword("prototypes");
		ISemanticRegion featuresKeyword = textRegionExtensions.regionFor(componentType)
				.keyword("features");
		ISemanticRegion flowsKeyword = textRegionExtensions.regionFor(componentType).keyword("flows");
		ISemanticRegion requiresKeyword = textRegionExtensions.regionFor(componentType)
				.keyword("requires");
		ISemanticRegion modesKeyword = textRegionExtensions.regionFor(componentType).keyword("modes");
		ISemanticRegion propertiesKeyword = textRegionExtensions.regionFor(componentType)
				.keyword("properties");
		ISemanticRegion annexRegion = first(
				textRegionExtensions.semanticRegions(first(componentType.getOwnedAnnexSubclauses())));
		if (prototypesKeyword != null) {
			document.append(prototypesKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker = firstPresent(featuresKeyword, flowsKeyword, requiresKeyword, modesKeyword,
					propertiesKeyword, annexRegion, endKeyword);
			document.interior(prototypesKeyword, endMarker, IHiddenRegionFormatter::indent);
		}
		if (featuresKeyword != null) {
			document.append(featuresKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker_1 = firstPresent(flowsKeyword, requiresKeyword, modesKeyword, propertiesKeyword,
					annexRegion, endKeyword);
			document.interior(featuresKeyword, endMarker_1, IHiddenRegionFormatter::indent);
		}
		if (flowsKeyword != null) {
			document.append(flowsKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker_2 = firstPresent(requiresKeyword, modesKeyword, propertiesKeyword, annexRegion, endKeyword);
			document.interior(flowsKeyword, endMarker_2, IHiddenRegionFormatter::indent);
		}
		if (modesKeyword != null) {
			document.append(modesKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker_3 = firstPresent(propertiesKeyword, annexRegion, endKeyword);
			document.interior(modesKeyword, endMarker_3, IHiddenRegionFormatter::indent);
		}
		if (propertiesKeyword != null) {
			document.append(propertiesKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker_4 = firstPresent(annexRegion, endKeyword);
			document.interior(propertiesKeyword, endMarker_4, IHiddenRegionFormatter::indent);
		}
		document.append(requiresKeyword, IHiddenRegionFormatter::oneSpace);

		// None keywords
		textRegionExtensions.regionFor(componentType).keywords("none")
				.forEach(element -> document.append(element, IHiddenRegionFormatter::noSpace));

		// Semicolons after none keywords
		List<ISemanticRegion> semicolons = textRegionExtensions.regionFor(componentType).keywords(";");
		if (semicolons.size() > 1) {
			take(semicolons, semicolons.size() - 1)
					.forEach(element -> document.append(element, formatter -> formatter.setNewLines(1, 1, 2)));
		}

		// Contents
		componentType.getOwnedPrototypes().forEach(element -> format(element, document));
		componentType.getOwnedFeatures().forEach(element -> format(element, document));
		componentType.getOwnedFlowSpecifications().forEach(element -> format(element, document));
		componentType.getOwnedModes().forEach(element -> format(element, document));
		componentType.getOwnedModeTransitions().forEach(element -> format(element, document));
		componentType.getOwnedAnnexSubclauses().forEach(element -> format(element, document));

		// Properties
		componentType.getOwnedPropertyAssociations().forEach(element -> {
			document.append(element, formatter -> formatter.setNewLines(1, 1, 2));
			format(element, document);
		});

		// End line
		document.append(endKeyword, IHiddenRegionFormatter::oneSpace);
		document.prepend(lastOrNull(semicolons), IHiddenRegionFormatter::noSpace);
	}

	protected void _format(TypeExtension typeExtension, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(typeExtension)
						.keyword(grammarAccess.getTypeExtensionAccess().getExtendsKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
	}

	protected void _format(FeatureGroupPrototypeBinding featureGroupPrototypeBinding, IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(featureGroupPrototypeBinding).keyword(grammarAccess
						.getFeatureGroupPrototypeBindingAccess().getEqualsSignGreaterThanSignKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(featureGroupPrototypeBinding)
						.keyword(grammarAccess.getFeatureGroupPrototypeBindingAccess().getGroupKeyword_3()),
				IHiddenRegionFormatter::oneSpace);
		format(featureGroupPrototypeBinding.getActual(), document);
	}

	protected void _format(FeatureGroupPrototypeActual featureGroupPrototypeActual, IFormattableDocument document) {
		ISemanticRegion leftParenthesis = textRegionExtensions.regionFor(featureGroupPrototypeActual)
				.keyword(grammarAccess.getFeatureGroupPrototypeActualAccess().getLeftParenthesisKeyword_1_0());
		ISemanticRegion rightParenthesis = textRegionExtensions.regionFor(featureGroupPrototypeActual)
				.keyword(grammarAccess.getFeatureGroupPrototypeActualAccess().getRightParenthesisKeyword_1_3());
		if (leftParenthesis != null && rightParenthesis != null) {
			document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
			document.append(document.prepend(leftParenthesis, IHiddenRegionFormatter::oneSpace),
					Aadl2Formatter::wrappableNoSpace);
			textRegionExtensions.regionFor(featureGroupPrototypeActual)
					.keywords(grammarAccess.getFeatureGroupPrototypeActualAccess().getCommaKeyword_1_2_0())
					.forEach(element -> formatSeparator(document, element));
			featureGroupPrototypeActual.getBindings().forEach(element -> format(element, document));
			prependNewLineOrNoSpace(document, rightParenthesis);
		}
	}

	protected void _format(FeaturePrototypeBinding featurePrototypeBinding, IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(featurePrototypeBinding).keyword(
						grammarAccess.getFeaturePrototypeBindingAccess().getEqualsSignGreaterThanSignKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		format(featurePrototypeBinding.getActual(), document);
	}

	protected void _format(PortSpecification portSpecification, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(portSpecification)
						.keyword(grammarAccess.getPortSpecificationAccess().getInInKeyword_0_0_0_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(portSpecification)
						.keyword(grammarAccess.getPortSpecificationAccess().getOutOutKeyword_0_0_1_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(portSpecification)
						.keyword(grammarAccess.getPortSpecificationAccess().getOutOutKeyword_0_1_0()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(portSpecification)
						.keyword(grammarAccess.getPortSpecificationAccess().getPortKeyword_2()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(portSpecification)
						.assignment(grammarAccess.getPortSpecificationAccess().getClassifierAssignment_3()),
				IHiddenRegionFormatter::oneSpace);
	}

	protected void _format(AccessSpecification accessSpecification, IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(accessSpecification)
						.assignment(grammarAccess.getAccessSpecificationAccess().getCategoryAssignment_1()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(accessSpecification)
						.assignment(grammarAccess.getAccessSpecificationAccess().getClassifierAssignment_3()),
				IHiddenRegionFormatter::oneSpace);
	}

	protected void _format(FeaturePrototypeReference featurePrototypeReference, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(featurePrototypeReference)
						.keyword(grammarAccess.getFeaturePrototypeReferenceAccess().getInInKeyword_0_0_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(featurePrototypeReference)
						.keyword(grammarAccess.getFeaturePrototypeReferenceAccess().getOutOutKeyword_0_1_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(featurePrototypeReference)
						.keyword(grammarAccess.getFeaturePrototypeReferenceAccess().getFeatureKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
	}

	protected void _format(ComponentPrototypeBinding componentPrototypeBinding, IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(componentPrototypeBinding).keyword(grammarAccess
						.getComponentPrototypeBindingAccess().getEqualsSignGreaterThanSignKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		componentPrototypeBinding.getActuals().forEach(element -> format(element, document));
		ISemanticRegion leftParenthesis = textRegionExtensions.regionFor(componentPrototypeBinding)
				.keyword(grammarAccess.getComponentPrototypeBindingAccess().getLeftParenthesisKeyword_2_1_0());
		ISemanticRegion rightParenthesis = textRegionExtensions.regionFor(componentPrototypeBinding)
				.keyword(grammarAccess.getComponentPrototypeBindingAccess().getRightParenthesisKeyword_2_1_3());
		if (leftParenthesis != null && rightParenthesis != null) {
			document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
			document.append(leftParenthesis, Aadl2Formatter::wrappableNoSpace);
			textRegionExtensions.regionFor(componentPrototypeBinding)
					.keywords(grammarAccess.getComponentPrototypeBindingAccess().getCommaKeyword_2_1_2_0())
					.forEach(element -> formatSeparator(document, element));
			prependNewLineOrNoSpace(document, rightParenthesis);
		}
	}

	protected void _format(ComponentPrototypeActual componentPrototypeActual, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(componentPrototypeActual)
						.assignment(grammarAccess.getComponentReferenceAccess().getCategoryAssignment_0()),
				IHiddenRegionFormatter::oneSpace);
		ISemanticRegion leftParenthesis = textRegionExtensions.regionFor(componentPrototypeActual)
				.keyword(grammarAccess.getComponentReferenceAccess().getLeftParenthesisKeyword_2_0());
		ISemanticRegion rightParenthesis = textRegionExtensions.regionFor(componentPrototypeActual)
				.keyword(grammarAccess.getComponentReferenceAccess().getRightParenthesisKeyword_2_3());
		if (leftParenthesis != null && rightParenthesis != null) {
			document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
			document.append(document.prepend(leftParenthesis, IHiddenRegionFormatter::oneSpace),
					Aadl2Formatter::wrappableNoSpace);
			textRegionExtensions.regionFor(componentPrototypeActual)
					.keywords(grammarAccess.getComponentReferenceAccess().getCommaKeyword_2_2_0())
					.forEach(element -> formatSeparator(document, element));
			componentPrototypeActual.getBindings().forEach(element -> format(element, document));
			prependNewLineOrNoSpace(document, rightParenthesis);
		}
	}

	protected void _format(DataPort dataPort, IFormattableDocument document) {
		conditionalAppend(dataPort, document, formatter -> formatter.setNewLines(1, 1, 2));

		// Named
		document.append(document.prepend(
				textRegionExtensions.regionFor(dataPort)
						.keyword(grammarAccess.getDataPortAccess().getColonKeyword_1_0_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);

		// Refined
		document.append(document.prepend(
				textRegionExtensions.regionFor(dataPort)
						.keyword(grammarAccess.getDataPortAccess().getColonKeyword_1_1_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(textRegionExtensions.regionFor(dataPort).keyword(
				grammarAccess.getDataPortAccess().getToKeyword_1_1_3()), IHiddenRegionFormatter::oneSpace);

		// Direction
		document.append(
				textRegionExtensions.regionFor(dataPort)
						.keyword(grammarAccess.getDataPortAccess().getInInKeyword_2_0_0_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(dataPort)
						.keyword(grammarAccess.getDataPortAccess().getOutOutKeyword_2_0_1_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(dataPort)
						.keyword(grammarAccess.getDataPortAccess().getOutOutKeyword_2_1_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(textRegionExtensions.regionFor(dataPort)
				.keyword(grammarAccess.getDataPortAccess().getDataKeyword_3()), IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(dataPort)
						.assignment(grammarAccess.getDataPortAccess().getDataFeatureClassifierAssignment_5()),
				IHiddenRegionFormatter::oneSpace);
		dataPort.getArrayDimensions().forEach(element -> {
			document.prepend(element, IHiddenRegionFormatter::noSpace);
			format(element, document);
		});
		formatCurlyProperties(dataPort, document,
				textRegionExtensions.regionFor(dataPort)
						.keyword(grammarAccess.getDataPortAccess().getLeftCurlyBracketKeyword_7_0()),
				textRegionExtensions.regionFor(dataPort)
						.keyword(grammarAccess.getDataPortAccess().getRightCurlyBracketKeyword_7_2()));
		document.prepend(
				textRegionExtensions.regionFor(dataPort)
						.keyword(grammarAccess.getDataPortAccess().getSemicolonKeyword_8()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(ArrayDimension arrayDimension, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(arrayDimension)
						.keyword(grammarAccess.getArrayDimensionAccess().getLeftSquareBracketKeyword_1()),
				IHiddenRegionFormatter::noSpace);
		format(arrayDimension.getSize(), document);
		document.prepend(
				textRegionExtensions.regionFor(arrayDimension)
						.keyword(grammarAccess.getArrayDimensionAccess().getRightSquareBracketKeyword_3()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(EventDataPort eventDataPort, IFormattableDocument document) {
		conditionalAppend(eventDataPort, document, formatter -> formatter.setNewLines(1, 1, 2));

		// Named
		document.append(document.prepend(
				textRegionExtensions.regionFor(eventDataPort)
						.keyword(grammarAccess.getEventDataPortAccess().getColonKeyword_1_0_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);

		// Refined
		document.append(document.prepend(
				textRegionExtensions.regionFor(eventDataPort)
						.keyword(grammarAccess.getEventDataPortAccess().getColonKeyword_1_1_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(eventDataPort)
						.keyword(grammarAccess.getEventDataPortAccess().getToKeyword_1_1_3()),
				IHiddenRegionFormatter::oneSpace);

		// Direction
		document.append(
				textRegionExtensions.regionFor(eventDataPort)
						.keyword(grammarAccess.getEventDataPortAccess().getInInKeyword_2_0_0_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(eventDataPort)
						.keyword(grammarAccess.getEventDataPortAccess().getOutOutKeyword_2_0_1_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(eventDataPort)
						.keyword(grammarAccess.getEventDataPortAccess().getOutOutKeyword_2_1_0()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(eventDataPort)
						.keyword(grammarAccess.getEventDataPortAccess().getDataKeyword_4()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(eventDataPort)
						.assignment(grammarAccess.getEventDataPortAccess().getDataFeatureClassifierAssignment_6()),
				IHiddenRegionFormatter::oneSpace);
		eventDataPort.getArrayDimensions().forEach(element -> {
			document.prepend(element, IHiddenRegionFormatter::noSpace);
			format(element, document);
		});
		formatCurlyProperties(eventDataPort, document,
				textRegionExtensions.regionFor(eventDataPort)
						.keyword(grammarAccess.getEventDataPortAccess().getLeftCurlyBracketKeyword_8_0()),
				textRegionExtensions.regionFor(eventDataPort)
						.keyword(grammarAccess.getEventDataPortAccess().getRightCurlyBracketKeyword_8_2()));
		document.prepend(
				textRegionExtensions.regionFor(eventDataPort)
						.keyword(grammarAccess.getEventDataPortAccess().getSemicolonKeyword_9()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(EventPort eventPort, IFormattableDocument document) {
		conditionalAppend(eventPort, document, formatter -> formatter.setNewLines(1, 1, 2));

		// Named
		document.append(document.prepend(
				textRegionExtensions.regionFor(eventPort)
						.keyword(grammarAccess.getEventPortAccess().getColonKeyword_1_0_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);

		// Refined
		document.append(document.prepend(
				textRegionExtensions.regionFor(eventPort)
						.keyword(grammarAccess.getEventPortAccess().getColonKeyword_1_1_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(eventPort)
						.keyword(grammarAccess.getEventPortAccess().getToKeyword_1_1_3()),
				IHiddenRegionFormatter::oneSpace);

		// Direction
		document.append(
				textRegionExtensions.regionFor(eventPort)
						.keyword(grammarAccess.getEventPortAccess().getInInKeyword_2_0_0_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(eventPort)
						.keyword(grammarAccess.getEventPortAccess().getOutOutKeyword_2_0_1_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(eventPort)
						.keyword(grammarAccess.getEventPortAccess().getOutOutKeyword_2_1_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(textRegionExtensions.regionFor(eventPort).keyword(
				grammarAccess.getEventPortAccess().getEventKeyword_3()), IHiddenRegionFormatter::oneSpace);
		eventPort.getArrayDimensions().forEach(element -> {
			document.prepend(element, IHiddenRegionFormatter::noSpace);
			format(element, document);
		});
		formatCurlyProperties(eventPort, document,
				textRegionExtensions.regionFor(eventPort)
						.keyword(grammarAccess.getEventPortAccess().getLeftCurlyBracketKeyword_6_0()),
				textRegionExtensions.regionFor(eventPort)
						.keyword(grammarAccess.getEventPortAccess().getRightCurlyBracketKeyword_6_2()));
		document.prepend(
				textRegionExtensions.regionFor(eventPort)
						.keyword(grammarAccess.getEventPortAccess().getSemicolonKeyword_7()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(FeatureGroup featureGroup, IFormattableDocument document) {
		conditionalAppend(featureGroup, document, formatter -> formatter.setNewLines(1, 1, 2));

		// Named
		document.append(document.prepend(
				textRegionExtensions.regionFor(featureGroup)
						.keyword(grammarAccess.getFeatureGroupAccess().getColonKeyword_0_0_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);

		// Refined
		document.append(document.prepend(
				textRegionExtensions.regionFor(featureGroup)
						.keyword(grammarAccess.getFeatureGroupAccess().getColonKeyword_0_1_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(featureGroup)
						.keyword(grammarAccess.getFeatureGroupAccess().getToKeyword_0_1_3()),
				IHiddenRegionFormatter::oneSpace);

		// Direction
		document.append(
				textRegionExtensions.regionFor(featureGroup)
						.keyword(grammarAccess.getFeatureGroupAccess().getInInKeyword_1_0_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(featureGroup)
						.keyword(grammarAccess.getFeatureGroupAccess().getOutOutKeyword_1_1_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(featureGroup)
						.keyword(grammarAccess.getFeatureGroupAccess().getFeatureKeyword_2()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(featureGroup)
						.keyword(grammarAccess.getFeatureGroupAccess().getInverseInverseKeyword_4_0_0_0()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(featureGroup)
						.assignment(grammarAccess.getFeatureGroupAccess().getFeatureTypeAssignment_4_1()),
				IHiddenRegionFormatter::oneSpace);
		featureGroup.getArrayDimensions().forEach(element -> {
			document.prepend(element, IHiddenRegionFormatter::noSpace);
			format(element, document);
		});
		formatCurlyProperties(featureGroup, document,
				textRegionExtensions.regionFor(featureGroup)
						.keyword(grammarAccess.getFeatureGroupAccess().getLeftCurlyBracketKeyword_6_0()),
				textRegionExtensions.regionFor(featureGroup)
						.keyword(grammarAccess.getFeatureGroupAccess().getRightCurlyBracketKeyword_6_2()));
		document.prepend(
				textRegionExtensions.regionFor(featureGroup)
						.keyword(grammarAccess.getFeatureGroupAccess().getSemicolonKeyword_7()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(ContainedNamedElement containedNamedElement, IFormattableDocument document) {
		format(containedNamedElement.getPath(), document);
	}

	protected void _format(Parameter parameter, IFormattableDocument document) {
		conditionalAppend(parameter, document, formatter -> formatter.setNewLines(1, 1, 2));

		// Named
		document.append(document.prepend(
				textRegionExtensions.regionFor(parameter)
						.keyword(grammarAccess.getParameterAccess().getColonKeyword_0_0_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);

		// Refined
		document.append(document.prepend(
				textRegionExtensions.regionFor(parameter)
						.keyword(grammarAccess.getParameterAccess().getColonKeyword_0_1_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(parameter)
						.keyword(grammarAccess.getParameterAccess().getToKeyword_0_1_3()),
				IHiddenRegionFormatter::oneSpace);

		// Direction
		document.append(
				textRegionExtensions.regionFor(parameter)
						.keyword(grammarAccess.getParameterAccess().getInInKeyword_1_0_0_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(parameter)
						.keyword(grammarAccess.getParameterAccess().getOutOutKeyword_1_0_1_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(parameter)
						.keyword(grammarAccess.getParameterAccess().getOutOutKeyword_1_1_0()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(parameter)
						.assignment(grammarAccess.getParameterAccess().getDataFeatureClassifierAssignment_3()),
				IHiddenRegionFormatter::oneSpace);
		parameter.getArrayDimensions().forEach(element -> {
			document.prepend(element, IHiddenRegionFormatter::noSpace);
			format(element, document);
		});
		formatCurlyProperties(parameter, document,
				textRegionExtensions.regionFor(parameter)
						.keyword(grammarAccess.getParameterAccess().getLeftCurlyBracketKeyword_5_0()),
				textRegionExtensions.regionFor(parameter)
						.keyword(grammarAccess.getParameterAccess().getRightCurlyBracketKeyword_5_2()));
		document.prepend(
				textRegionExtensions.regionFor(parameter)
						.keyword(grammarAccess.getParameterAccess().getSemicolonKeyword_6()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(SubprogramAccess subprogramAccess, IFormattableDocument document) {
		conditionalAppend(subprogramAccess, document,
				formatter -> formatter.setNewLines(1, 1, 2));
		document.append(document.prepend(
				textRegionExtensions.regionFor(subprogramAccess)
						.keyword(grammarAccess.getSubprogramAccessAccess().getColonKeyword_0_0_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.append(document.prepend(
				textRegionExtensions.regionFor(subprogramAccess)
						.keyword(grammarAccess.getSubprogramAccessAccess().getColonKeyword_0_1_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(subprogramAccess)
						.keyword(grammarAccess.getSubprogramAccessAccess().getToKeyword_0_1_3()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(subprogramAccess)
						.keyword(grammarAccess.getSubprogramAccessAccess().getSubprogramKeyword_2()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(subprogramAccess).assignment(
						grammarAccess.getSubprogramAccessAccess().getSubprogramFeatureClassifierAssignment_4()),
				IHiddenRegionFormatter::oneSpace);
		subprogramAccess.getArrayDimensions().forEach(element -> {
			document.prepend(element, IHiddenRegionFormatter::noSpace);
			format(element, document);
		});
		formatCurlyProperties(subprogramAccess, document,
				textRegionExtensions.regionFor(subprogramAccess)
						.keyword(grammarAccess.getSubprogramAccessAccess().getLeftCurlyBracketKeyword_6_0()),
				textRegionExtensions.regionFor(subprogramAccess)
						.keyword(grammarAccess.getSubprogramAccessAccess().getRightCurlyBracketKeyword_6_2()));
		document.prepend(
				textRegionExtensions.regionFor(subprogramAccess)
						.keyword(grammarAccess.getSubprogramAccessAccess().getSemicolonKeyword_7()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(SubprogramGroupAccess subprogramGroupAccess, IFormattableDocument document) {
		conditionalAppend(subprogramGroupAccess, document,
				formatter -> formatter.setNewLines(1, 1, 2));
		document.append(document.prepend(
				textRegionExtensions.regionFor(subprogramGroupAccess)
						.keyword(grammarAccess.getSubprogramGroupAccessAccess().getColonKeyword_0_0_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.append(document.prepend(
				textRegionExtensions.regionFor(subprogramGroupAccess)
						.keyword(grammarAccess.getSubprogramGroupAccessAccess().getColonKeyword_0_1_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(subprogramGroupAccess)
						.keyword(grammarAccess.getSubprogramGroupAccessAccess().getToKeyword_0_1_3()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(subprogramGroupAccess)
						.keyword(grammarAccess.getSubprogramGroupAccessAccess().getSubprogramKeyword_2()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(subprogramGroupAccess)
						.keyword(grammarAccess.getSubprogramGroupAccessAccess().getGroupKeyword_3()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(subprogramGroupAccess).assignment(grammarAccess
						.getSubprogramGroupAccessAccess().getSubprogramGroupFeatureClassifierAssignment_5()),
				IHiddenRegionFormatter::oneSpace);
		subprogramGroupAccess.getArrayDimensions().forEach(element -> {
			document.prepend(element, IHiddenRegionFormatter::noSpace);
			format(element, document);
		});
		formatCurlyProperties(subprogramGroupAccess, document,
				textRegionExtensions.regionFor(subprogramGroupAccess)
						.keyword(grammarAccess.getSubprogramGroupAccessAccess().getLeftCurlyBracketKeyword_7_0()),
				textRegionExtensions.regionFor(subprogramGroupAccess).keyword(
						grammarAccess.getSubprogramGroupAccessAccess().getRightCurlyBracketKeyword_7_2()));
		document.prepend(
				textRegionExtensions.regionFor(subprogramGroupAccess)
						.keyword(grammarAccess.getSubprogramGroupAccessAccess().getSemicolonKeyword_8()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(BusAccess busAccess, IFormattableDocument document) {
		conditionalAppend(busAccess, document, formatter -> formatter.setNewLines(1, 1, 2));
		document.append(document.prepend(
				textRegionExtensions.regionFor(busAccess)
						.keyword(grammarAccess.getBusAccessAccess().getColonKeyword_0_0_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.append(document.prepend(
				textRegionExtensions.regionFor(busAccess)
						.keyword(grammarAccess.getBusAccessAccess().getColonKeyword_0_1_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(busAccess)
						.keyword(grammarAccess.getBusAccessAccess().getToKeyword_0_1_3()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(busAccess)
						.keyword(grammarAccess.getBusAccessAccess().getVirtualVirtualKeyword_2_0()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(textRegionExtensions.regionFor(busAccess)
				.keyword(grammarAccess.getBusAccessAccess().getBusKeyword_3()), IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(busAccess)
						.assignment(grammarAccess.getBusAccessAccess().getBusFeatureClassifierAssignment_5()),
				IHiddenRegionFormatter::oneSpace);
		busAccess.getArrayDimensions().forEach(element -> {
			document.prepend(element, IHiddenRegionFormatter::noSpace);
			format(element, document);
		});
		formatCurlyProperties(busAccess, document,
				textRegionExtensions.regionFor(busAccess)
						.keyword(grammarAccess.getBusAccessAccess().getLeftCurlyBracketKeyword_7_0()),
				textRegionExtensions.regionFor(busAccess)
						.keyword(grammarAccess.getBusAccessAccess().getRightCurlyBracketKeyword_7_2()));
		document.prepend(
				textRegionExtensions.regionFor(busAccess)
						.keyword(grammarAccess.getBusAccessAccess().getSemicolonKeyword_8()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(DataAccess dataAccess, IFormattableDocument document) {
		conditionalAppend(dataAccess, document, formatter -> formatter.setNewLines(1, 1, 2));
		document.append(document.prepend(
				textRegionExtensions.regionFor(dataAccess)
						.keyword(grammarAccess.getDataAccessAccess().getColonKeyword_0_0_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.append(document.prepend(
				textRegionExtensions.regionFor(dataAccess)
						.keyword(grammarAccess.getDataAccessAccess().getColonKeyword_0_1_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(dataAccess)
						.keyword(grammarAccess.getDataAccessAccess().getToKeyword_0_1_3()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(textRegionExtensions.regionFor(dataAccess).keyword(
				grammarAccess.getDataAccessAccess().getDataKeyword_2()), IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(dataAccess)
						.assignment(grammarAccess.getDataAccessAccess().getDataFeatureClassifierAssignment_4()),
				IHiddenRegionFormatter::oneSpace);
		dataAccess.getArrayDimensions().forEach(element -> {
			document.prepend(element, IHiddenRegionFormatter::noSpace);
			format(element, document);
		});
		formatCurlyProperties(dataAccess, document,
				textRegionExtensions.regionFor(dataAccess)
						.keyword(grammarAccess.getDataAccessAccess().getLeftCurlyBracketKeyword_6_0()),
				textRegionExtensions.regionFor(dataAccess)
						.keyword(grammarAccess.getDataAccessAccess().getRightCurlyBracketKeyword_6_2()));
		document.prepend(
				textRegionExtensions.regionFor(dataAccess)
						.keyword(grammarAccess.getDataAccessAccess().getSemicolonKeyword_7()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(AbstractFeature abstractFeature, IFormattableDocument document) {
		conditionalAppend(abstractFeature, document, formatter -> formatter.setNewLines(1, 1, 2));

		// Named
		document.append(document.prepend(
				textRegionExtensions.regionFor(abstractFeature)
						.keyword(grammarAccess.getAbstractFeatureAccess().getColonKeyword_0_0_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);

		// Refined
		document.append(document.prepend(
				textRegionExtensions.regionFor(abstractFeature)
						.keyword(grammarAccess.getAbstractFeatureAccess().getColonKeyword_0_1_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(abstractFeature)
						.keyword(grammarAccess.getAbstractFeatureAccess().getToKeyword_0_1_3()),
				IHiddenRegionFormatter::oneSpace);

		// Direction
		document.append(
				textRegionExtensions.regionFor(abstractFeature)
						.keyword(grammarAccess.getAbstractFeatureAccess().getInInKeyword_1_0_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(abstractFeature)
						.keyword(grammarAccess.getAbstractFeatureAccess().getOutOutKeyword_1_1_0()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(abstractFeature).assignment(
						grammarAccess.getAbstractFeatureAccess().getFeaturePrototypeAssignment_2_0_1()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(abstractFeature).assignment(
						grammarAccess.getAbstractFeatureAccess().getAbstractFeatureClassifierAssignment_2_1_1()),
				IHiddenRegionFormatter::oneSpace);
		abstractFeature.getArrayDimensions().forEach(element -> {
			document.prepend(element, IHiddenRegionFormatter::noSpace);
			format(element, document);
		});
		formatCurlyProperties(abstractFeature, document,
				textRegionExtensions.regionFor(abstractFeature)
						.keyword(grammarAccess.getAbstractFeatureAccess().getLeftCurlyBracketKeyword_4_0()),
				textRegionExtensions.regionFor(abstractFeature)
						.keyword(grammarAccess.getAbstractFeatureAccess().getRightCurlyBracketKeyword_4_2()));
		document.prepend(
				textRegionExtensions.regionFor(abstractFeature)
						.keyword(grammarAccess.getAbstractFeatureAccess().getSemicolonKeyword_5()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(Mode mode, IFormattableDocument document) {
		conditionalAppend(mode, document, formatter -> formatter.setNewLines(1, 1, 2));
		document.append(
				document.prepend(
						textRegionExtensions.regionFor(mode)
								.keyword(grammarAccess.getModeAccess().getColonKeyword_1()),
						IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(mode)
						.keyword(grammarAccess.getModeAccess().getInitialInitialKeyword_2_0()),
				IHiddenRegionFormatter::oneSpace);
		formatCurlyProperties(mode, document,
				textRegionExtensions.regionFor(mode)
						.keyword(grammarAccess.getModeAccess().getLeftCurlyBracketKeyword_4_0()),
				textRegionExtensions.regionFor(mode)
						.keyword(grammarAccess.getModeAccess().getRightCurlyBracketKeyword_4_2()));
		document.prepend(textRegionExtensions.regionFor(mode)
				.keyword(grammarAccess.getModeAccess().getSemicolonKeyword_5()), IHiddenRegionFormatter::noSpace);
	}

	protected void _format(ModeTransition modeTransition, IFormattableDocument document) {
		conditionalAppend(modeTransition, document, formatter -> formatter.setNewLines(1, 1, 2));
		document.append(document.prepend(
				textRegionExtensions.regionFor(modeTransition)
						.keyword(grammarAccess.getModeTransitionAccess().getColonKeyword_0_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);

		// Triggers
		ISemanticRegion leftMarker = textRegionExtensions.regionFor(modeTransition)
				.keyword(grammarAccess.getModeTransitionAccess().getHyphenMinusLeftSquareBracketKeyword_2());
		ISemanticRegion rightMarker = textRegionExtensions.regionFor(modeTransition)
				.keyword(grammarAccess.getModeTransitionAccess()
						.getRightSquareBracketHyphenMinusGreaterThanSignKeyword_5());
		document.interior(leftMarker, rightMarker, IHiddenRegionFormatter::indent);
		document.append(document.prepend(leftMarker, IHiddenRegionFormatter::oneSpace),
				Aadl2Formatter::wrappableNoSpace);
		modeTransition.getOwnedTriggers().forEach(element -> format(element, document));
		textRegionExtensions.regionFor(modeTransition)
				.keywords(grammarAccess.getModeTransitionAccess().getCommaKeyword_4_0())
						.forEach(element -> formatSeparator(document, element));
		var previousHidden = rightMarker == null ? null : rightMarker.getPreviousHiddenRegion();
		if (previousHidden != null && previousHidden.isMultiline()) {
			document.append(document.prepend(rightMarker, formatter -> formatter.setNewLines(1)),
					IHiddenRegionFormatter::oneSpace);
		} else {
			document.append(document.prepend(rightMarker, IHiddenRegionFormatter::noSpace),
					IHiddenRegionFormatter::oneSpace);
		}
		formatCurlyProperties(modeTransition, document,
				textRegionExtensions.regionFor(modeTransition)
						.keyword(grammarAccess.getModeTransitionAccess().getLeftCurlyBracketKeyword_7_0()),
				textRegionExtensions.regionFor(modeTransition)
						.keyword(grammarAccess.getModeTransitionAccess().getRightCurlyBracketKeyword_7_2()));
		document.prepend(
				textRegionExtensions.regionFor(modeTransition)
						.keyword(grammarAccess.getModeTransitionAccess().getSemicolonKeyword_8()),
				IHiddenRegionFormatter::noSpace);
	}

	private void formatCurlyProperties(NamedElement namedElement, IFormattableDocument document,
			ISemanticRegion leftCurly, ISemanticRegion rightCurly) {
		if (leftCurly == null || rightCurly == null) {
			return;
		}
		document.interior(leftCurly, rightCurly, IHiddenRegionFormatter::indent);
		document.append(document.prepend(leftCurly, IHiddenRegionFormatter::oneSpace),
				Aadl2Formatter::wrappableNoSpace);
		// Separate every property association from the previous one; the first one is preceded by the curly brace.
		tail(namedElement.getOwnedPropertyAssociations())
				.forEach(association -> document.prepend(association, Aadl2Formatter::wrappableSpace));
		namedElement.getOwnedPropertyAssociations().forEach(association -> format(association, document));
		prependNewLineOrNoSpace(document, rightCurly);
	}

	protected void _format(ModeTransitionTrigger modeTransitionTrigger, IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(modeTransitionTrigger)
						.keyword(grammarAccess.getTriggerAccess().getFullStopKeyword_0_0_1()),
				IHiddenRegionFormatter::noSpace);
		document.surround(
				textRegionExtensions.regionFor(modeTransitionTrigger)
						.keyword(grammarAccess.getTriggerAccess().getFullStopKeyword_1_1()),
				IHiddenRegionFormatter::noSpace);
		document.surround(
				textRegionExtensions.regionFor(modeTransitionTrigger)
						.keyword(grammarAccess.getTriggerAccess().getFullStopKeyword_2_1()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(FeatureGroupPrototype featureGroupPrototype, IFormattableDocument document) {
		conditionalAppend(featureGroupPrototype, document,
				formatter -> formatter.setNewLines(1, 1, 2));

		// Named
		document.append(document.prepend(
				textRegionExtensions.regionFor(featureGroupPrototype)
						.keyword(grammarAccess.getFeatureGroupPrototypeAccess().getColonKeyword_0_0_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);

		// Refined
		document.append(document.prepend(
				textRegionExtensions.regionFor(featureGroupPrototype)
						.keyword(grammarAccess.getFeatureGroupPrototypeAccess().getColonKeyword_0_1_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(featureGroupPrototype)
						.keyword(grammarAccess.getFeatureGroupPrototypeAccess().getToKeyword_0_1_3()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(featureGroupPrototype)
						.keyword(grammarAccess.getFeatureGroupPrototypeAccess().getFeatureKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(featureGroupPrototype).assignment(grammarAccess
						.getFeatureGroupPrototypeAccess().getConstrainingFeatureGroupTypeAssignment_3()),
				IHiddenRegionFormatter::oneSpace);
		formatCurlyProperties(featureGroupPrototype, document,
				textRegionExtensions.regionFor(featureGroupPrototype)
						.keyword(grammarAccess.getFeatureGroupPrototypeAccess().getLeftCurlyBracketKeyword_4_0()),
				textRegionExtensions.regionFor(featureGroupPrototype).keyword(
						grammarAccess.getFeatureGroupPrototypeAccess().getRightCurlyBracketKeyword_4_2()));
		document.prepend(
				textRegionExtensions.regionFor(featureGroupPrototype)
						.keyword(grammarAccess.getFeatureGroupPrototypeAccess().getSemicolonKeyword_5()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(FeaturePrototype featurePrototype, IFormattableDocument document) {
		conditionalAppend(featurePrototype, document,
				formatter -> formatter.setNewLines(1, 1, 2));

		// Named
		document.append(document.prepend(
				textRegionExtensions.regionFor(featurePrototype)
						.keyword(grammarAccess.getFeaturePrototypeAccess().getColonKeyword_0_0_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);

		// Refined
		document.append(document.prepend(
				textRegionExtensions.regionFor(featurePrototype)
						.keyword(grammarAccess.getFeaturePrototypeAccess().getColonKeyword_0_1_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(featurePrototype)
						.keyword(grammarAccess.getFeaturePrototypeAccess().getToKeyword_0_1_3()),
				IHiddenRegionFormatter::oneSpace);

		// Direction
		document.append(
				textRegionExtensions.regionFor(featurePrototype)
						.keyword(grammarAccess.getFeaturePrototypeAccess().getInInKeyword_1_0_0()),
				IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(featurePrototype)
						.keyword(grammarAccess.getFeaturePrototypeAccess().getOutOutKeyword_1_1_0()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(featurePrototype).assignment(
						grammarAccess.getFeaturePrototypeAccess().getConstrainingClassifierAssignment_3()),
				IHiddenRegionFormatter::oneSpace);
		formatCurlyProperties(featurePrototype, document,
				textRegionExtensions.regionFor(featurePrototype)
						.keyword(grammarAccess.getFeaturePrototypeAccess().getLeftCurlyBracketKeyword_4_0()),
				textRegionExtensions.regionFor(featurePrototype)
						.keyword(grammarAccess.getFeaturePrototypeAccess().getRightCurlyBracketKeyword_4_2()));
		document.prepend(
				textRegionExtensions.regionFor(featurePrototype)
						.keyword(grammarAccess.getFeaturePrototypeAccess().getSemicolonKeyword_5()),
				IHiddenRegionFormatter::noSpace);
	}

	private void formatComponentPrototypeCommon(ComponentPrototype componentPrototype,
			IFormattableDocument document, ISemanticRegion constrainingClassifierAssignment) {
		conditionalAppend(componentPrototype, document,
				formatter -> formatter.setNewLines(1, 1, 2));

		// Named and refined
		document.append(document.prepend(textRegionExtensions.regionFor(componentPrototype).keyword(":"),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(textRegionExtensions.regionFor(componentPrototype).keyword("to"),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(constrainingClassifierAssignment, IHiddenRegionFormatter::oneSpace);
		document.surround(textRegionExtensions.regionFor(componentPrototype).keyword("["),
				IHiddenRegionFormatter::noSpace);
		formatCurlyProperties(componentPrototype, document,
				textRegionExtensions.regionFor(componentPrototype).keyword("{"),
				textRegionExtensions.regionFor(componentPrototype).keyword("}"));
		document.prepend(textRegionExtensions.regionFor(componentPrototype).keyword(";"),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(AbstractPrototype abstractPrototype, IFormattableDocument document) {
		formatComponentPrototypeCommon(abstractPrototype, document,
				textRegionExtensions.regionFor(abstractPrototype).assignment(
						grammarAccess.getAbstractPrototypeAccess().getConstrainingClassifierAssignment_2()));
	}

	protected void _format(BusPrototype busPrototype, IFormattableDocument document) {
		formatComponentPrototypeCommon(busPrototype, document, textRegionExtensions.regionFor(busPrototype)
				.assignment(grammarAccess.getBusPrototypeAccess().getConstrainingClassifierAssignment_2()));
	}

	protected void _format(DataPrototype dataPrototype, IFormattableDocument document) {
		formatComponentPrototypeCommon(dataPrototype, document, textRegionExtensions.regionFor(dataPrototype)
				.assignment(grammarAccess.getDataPrototypeAccess().getConstrainingClassifierAssignment_2()));
	}

	protected void _format(DevicePrototype devicePrototype, IFormattableDocument document) {
		formatComponentPrototypeCommon(devicePrototype, document,
				textRegionExtensions.regionFor(devicePrototype).assignment(
						grammarAccess.getDevicePrototypeAccess().getConstrainingClassifierAssignment_2()));
	}

	protected void _format(MemoryPrototype memoryPrototype, IFormattableDocument document) {
		formatComponentPrototypeCommon(memoryPrototype, document,
				textRegionExtensions.regionFor(memoryPrototype).assignment(
						grammarAccess.getMemoryPrototypeAccess().getConstrainingClassifierAssignment_2()));
	}

	protected void _format(ProcessPrototype processPrototype, IFormattableDocument document) {
		formatComponentPrototypeCommon(processPrototype, document,
				textRegionExtensions.regionFor(processPrototype).assignment(
						grammarAccess.getProcessPrototypeAccess().getConstrainingClassifierAssignment_2()));
	}

	protected void _format(ProcessorPrototype processorPrototype, IFormattableDocument document) {
		formatComponentPrototypeCommon(processorPrototype, document,
				textRegionExtensions.regionFor(processorPrototype).assignment(
						grammarAccess.getProcessorPrototypeAccess().getConstrainingClassifierAssignment_2()));
	}

	protected void _format(SubprogramPrototype subprogramPrototype, IFormattableDocument document) {
		formatComponentPrototypeCommon(subprogramPrototype, document,
				textRegionExtensions.regionFor(subprogramPrototype).assignment(
						grammarAccess.getSubprogramPrototypeAccess().getConstrainingClassifierAssignment_2()));
	}

	protected void _format(SubprogramGroupPrototype subprogramGroupPrototype, IFormattableDocument document) {
		formatComponentPrototypeCommon(subprogramGroupPrototype, document,
				textRegionExtensions.regionFor(subprogramGroupPrototype).assignment(grammarAccess
						.getSubprogramGroupPrototypeAccess().getConstrainingClassifierAssignment_3()));
		document.append(
				textRegionExtensions.regionFor(subprogramGroupPrototype)
						.keyword(grammarAccess.getSubprogramGroupPrototypeAccess().getSubprogramKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
	}

	protected void _format(SystemPrototype systemPrototype, IFormattableDocument document) {
		formatComponentPrototypeCommon(systemPrototype, document,
				textRegionExtensions.regionFor(systemPrototype).assignment(
						grammarAccess.getSystemPrototypeAccess().getConstrainingClassifierAssignment_2()));
	}

	protected void _format(ThreadPrototype threadPrototype, IFormattableDocument document) {
		formatComponentPrototypeCommon(threadPrototype, document,
				textRegionExtensions.regionFor(threadPrototype).assignment(
						grammarAccess.getThreadPrototypeAccess().getConstrainingClassifierAssignment_2()));
	}

	protected void _format(ThreadGroupPrototype threadGroupPrototype, IFormattableDocument document) {
		formatComponentPrototypeCommon(threadGroupPrototype, document,
				textRegionExtensions.regionFor(threadGroupPrototype).assignment(
						grammarAccess.getThreadGroupPrototypeAccess().getConstrainingClassifierAssignment_3()));
		document.append(
				textRegionExtensions.regionFor(threadGroupPrototype)
						.keyword(grammarAccess.getThreadGroupPrototypeAccess().getThreadKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
	}

	protected void _format(VirtualBusPrototype virtualBusPrototype, IFormattableDocument document) {
		formatComponentPrototypeCommon(virtualBusPrototype, document,
				textRegionExtensions.regionFor(virtualBusPrototype).assignment(
						grammarAccess.getVirtualBusPrototypeAccess().getConstrainingClassifierAssignment_3()));
		document.append(
				textRegionExtensions.regionFor(virtualBusPrototype)
						.keyword(grammarAccess.getVirtualBusPrototypeAccess().getVirtualKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
	}

	protected void _format(VirtualProcessorPrototype virtualProcessorPrototype, IFormattableDocument document) {
		formatComponentPrototypeCommon(virtualProcessorPrototype, document,
				textRegionExtensions.regionFor(virtualProcessorPrototype).assignment(grammarAccess
						.getVirtualProcessorPrototypeAccess().getConstrainingClassifierAssignment_3()));
		document.append(
				textRegionExtensions.regionFor(virtualProcessorPrototype)
						.keyword(grammarAccess.getVirtualProcessorPrototypeAccess().getVirtualKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
	}

	protected void _format(DefaultAnnexSubclause defaultAnnexSubclause, IFormattableDocument document) {
		conditionalAppend(defaultAnnexSubclause, document,
				formatter -> formatter.setNewLines(1, 1, 2));
		document.surround(
				textRegionExtensions.regionFor(defaultAnnexSubclause)
						.assignment(grammarAccess.getDefaultAnnexSubclauseAccess().getNameAssignment_1()),
				IHiddenRegionFormatter::oneSpace);
		AnnexSubclause parsedSubclause = defaultAnnexSubclause.getParsedAnnexSubclause();
		ISemanticRegion sourceTextRegion = textRegionExtensions.regionFor(defaultAnnexSubclause)
				.assignment(grammarAccess.getDefaultAnnexSubclauseAccess().getSourceTextAssignment_2());
		formatAnnexText(parsedSubclause, defaultAnnexSubclause.getName(), sourceTextRegion, 2, document);
		performModification(defaultAnnexSubclause,
				() -> defaultAnnexSubclause.setParsedAnnexSubclause(parsedSubclause));

		// In modes
		ISemanticRegion leftParenthesis = textRegionExtensions.regionFor(defaultAnnexSubclause)
				.keyword(grammarAccess.getDefaultAnnexSubclauseAccess().getLeftParenthesisKeyword_3_2());
		ISemanticRegion rightParenthesis = textRegionExtensions.regionFor(defaultAnnexSubclause)
				.keyword(grammarAccess.getDefaultAnnexSubclauseAccess().getRightParenthesisKeyword_3_4());
		if (leftParenthesis != null && rightParenthesis != null) {
			document.surround(
					textRegionExtensions.regionFor(defaultAnnexSubclause)
							.keyword(grammarAccess.getDefaultAnnexSubclauseAccess().getInKeyword_3_0()),
					IHiddenRegionFormatter::oneSpace);
			document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
			document.append(document.prepend(leftParenthesis, IHiddenRegionFormatter::oneSpace),
					Aadl2Formatter::wrappableNoSpace);
			textRegionExtensions.regionFor(defaultAnnexSubclause)
					.keywords(grammarAccess.getDefaultAnnexSubclauseAccess().getCommaKeyword_3_3_1_0())
					.forEach(element -> formatSeparator(document, element));
			prependNewLineOrNoSpace(document, rightParenthesis);
		}
		document.prepend(
				textRegionExtensions.regionFor(defaultAnnexSubclause)
						.keyword(grammarAccess.getDefaultAnnexSubclauseAccess().getSemicolonKeyword_4()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(FeatureGroupType featureGroupType, IFormattableDocument document) {
		int newLineCount = startsTopLevelDeclaration(nextSemanticElement(featureGroupType)) ? 2 : 1;
		conditionalAppend(featureGroupType, document,
				formatter -> formatter.setNewLines(newLineCount, newLineCount, 2));
		document.surround(
				textRegionExtensions.regionFor(featureGroupType)
						.keyword(grammarAccess.getFeatureGroupTypeAccess().getGroupKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		ISemanticRegion endKeyword = textRegionExtensions.regionFor(featureGroupType)
				.keyword(grammarAccess.getFeatureGroupTypeAccess().getEndKeyword_9());

		// Declaration line
		ISemanticRegion nameAssignment = textRegionExtensions.regionFor(featureGroupType)
				.assignment(grammarAccess.getFeatureGroupTypeAccess().getNameAssignment_2());
		if (featureGroupType.getOwnedExtension() == null) {
			document.append(nameAssignment, formatter -> formatter.setNewLines(1, 1, 2));
			document.interior(nameAssignment, endKeyword, IHiddenRegionFormatter::indent);
		} else {
			document.append(nameAssignment, IHiddenRegionFormatter::oneSpace);
			format(featureGroupType.getOwnedExtension(), document);
			if (featureGroupType.getOwnedPrototypeBindings().isEmpty()) {
				document.append(featureGroupType.getOwnedExtension(),
						formatter -> formatter.setNewLines(1, 1, 2));
				document.interior(
						lastOrNull(textRegionExtensions.allSemanticRegions(featureGroupType.getOwnedExtension())),
						endKeyword, IHiddenRegionFormatter::indent);
			} else {
				ISemanticRegion leftParenthesis = textRegionExtensions.regionFor(featureGroupType)
						.keyword(grammarAccess.getFeatureGroupTypeAccess().getLeftParenthesisKeyword_3_1_0());
				ISemanticRegion rightParenthesis = textRegionExtensions.regionFor(featureGroupType)
						.keyword(grammarAccess.getFeatureGroupTypeAccess().getRightParenthesisKeyword_3_1_3());
				document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
				document.append(document.prepend(leftParenthesis, IHiddenRegionFormatter::oneSpace),
						Aadl2Formatter::wrappableNoSpace);
				textRegionExtensions.regionFor(featureGroupType)
						.keywords(grammarAccess.getFeatureGroupTypeAccess().getCommaKeyword_3_1_2_0())
						.forEach(element -> formatSeparator(document, element));
				featureGroupType.getOwnedPrototypeBindings().forEach(element -> format(element, document));
				if (rightParenthesis != null) {
					prependNewLineOrNoSpace(document, rightParenthesis);
					document.append(rightParenthesis, formatter -> formatter.setNewLines(1, 1, 2));
					document.interior(rightParenthesis, endKeyword, IHiddenRegionFormatter::indent);
				}
			}
		}

		// Section headings
		ISemanticRegion prototypesKeyword = textRegionExtensions.regionFor(featureGroupType)
				.keyword(grammarAccess.getFeatureGroupTypeAccess().getPrototypesKeyword_4_0());
		ISemanticRegion featuresKeyword = textRegionExtensions.regionFor(featureGroupType)
				.keyword(grammarAccess.getFeatureGroupTypeAccess().getFeaturesKeyword_5_0());
		ISemanticRegion inverseKeyword = textRegionExtensions.regionFor(featureGroupType)
				.keyword(grammarAccess.getFeatureGroupTypeAccess().getInverseKeyword_6_0());
		ISemanticRegion inverseAssignment = textRegionExtensions.regionFor(featureGroupType)
				.assignment(grammarAccess.getFeatureGroupTypeAccess().getInverseAssignment_6_2());
		ISemanticRegion propertiesKeyword = textRegionExtensions.regionFor(featureGroupType)
				.keyword(grammarAccess.getFeatureGroupTypeAccess().getPropertiesKeyword_7_0());
		ISemanticRegion annexRegion = first(
				textRegionExtensions.semanticRegions(first(featureGroupType.getOwnedAnnexSubclauses())));
		if (prototypesKeyword != null) {
			document.append(prototypesKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker = firstPresent(featuresKeyword, inverseKeyword, propertiesKeyword, annexRegion, endKeyword);
			document.interior(prototypesKeyword, endMarker, IHiddenRegionFormatter::indent);
		}
		if (featuresKeyword != null) {
			document.append(featuresKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker_1 = firstPresent(inverseKeyword, propertiesKeyword, annexRegion, endKeyword);
			document.interior(featuresKeyword, endMarker_1, IHiddenRegionFormatter::indent);
		}
		if (propertiesKeyword != null) {
			document.append(propertiesKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker_2 = firstPresent(annexRegion, endKeyword);
			document.interior(propertiesKeyword, endMarker_2, IHiddenRegionFormatter::indent);
		}

		// None keywords
		textRegionExtensions.regionFor(featureGroupType)
				.keywords(grammarAccess.getFeatureGroupTypeAccess().getNoPrototypesNoneKeyword_4_1_0_0_0(),
						grammarAccess.getFeatureGroupTypeAccess().getNoPropertiesNoneKeyword_7_1_1_0_0())
				.forEach(element -> document.append(element, IHiddenRegionFormatter::noSpace));

		// Semicolons after none keywords
		List<ISemanticRegion> semicolons = textRegionExtensions.regionFor(featureGroupType).keywords(";");
		if (semicolons.size() > 1) {
			take(semicolons, semicolons.size() - 1)
					.forEach(element -> document.append(element, formatter -> formatter.setNewLines(1, 1, 2)));
		}

		// Contents
		featureGroupType.getOwnedPrototypes().forEach(element -> format(element, document));
		featureGroupType.getOwnedFeatures().forEach(element -> format(element, document));
		featureGroupType.getOwnedAnnexSubclauses().forEach(element -> format(element, document));

		// Inverse of
		document.append(inverseKeyword, IHiddenRegionFormatter::oneSpace);
		document.append(document.prepend(inverseAssignment, IHiddenRegionFormatter::oneSpace),
				formatter -> formatter.setNewLines(1, 1, 2));

		// Properties
		featureGroupType.getOwnedPropertyAssociations().forEach(element -> {
			document.append(element, formatter -> formatter.setNewLines(1, 1, 2));
			format(element, document);
		});

		// End line
		document.append(endKeyword, IHiddenRegionFormatter::oneSpace);
		document.prepend(lastOrNull(semicolons), IHiddenRegionFormatter::noSpace);
	}

	protected void _format(GroupExtension groupExtension, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(groupExtension)
						.keyword(grammarAccess.getGroupExtensionAccess().getExtendsKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
	}

	private void formatComponentImplementationCommon(ComponentImplementation componentImplementation,
			IFormattableDocument document, ISemanticRegion nameAssignment,
			ISemanticRegion internalFeaturesKeyword, ISemanticRegion processorKeyword,
			ISemanticRegion processorFeaturesKeyword) {
		int newLineCount = startsTopLevelDeclaration(nextSemanticElement(componentImplementation)) ? 2 : 1;
		conditionalAppend(componentImplementation, document,
				formatter -> formatter.setNewLines(newLineCount, newLineCount, 2));
		ISemanticRegion endKeyword = textRegionExtensions.regionFor(componentImplementation)
				.keyword("end");

		// Declaration line
		document.append(document.prepend(componentImplementation.getOwnedRealization(),
				IHiddenRegionFormatter::oneSpace), IHiddenRegionFormatter::noSpace);
		document.prepend(nameAssignment, IHiddenRegionFormatter::noSpace);
		if (componentImplementation.getOwnedExtension() == null && componentImplementation.getOwnedPrototypeBindings()
				.isEmpty()) {
			document.append(nameAssignment, formatter -> formatter.setNewLines(1, 1, 2));
			document.interior(nameAssignment, endKeyword, IHiddenRegionFormatter::indent);
		} else {
			document.append(nameAssignment, IHiddenRegionFormatter::oneSpace);
			format(componentImplementation.getOwnedExtension(), document);
			if (componentImplementation.getOwnedPrototypeBindings().isEmpty()) {
				document.append(componentImplementation.getOwnedExtension(),
						formatter -> formatter.setNewLines(1, 1, 2));
				document.interior(
						lastOrNull(textRegionExtensions
								.allSemanticRegions(componentImplementation.getOwnedExtension())),
						endKeyword, IHiddenRegionFormatter::indent);
			} else {
				document.append(componentImplementation.getOwnedExtension(), IHiddenRegionFormatter::oneSpace);
				ISemanticRegion leftParenthesis = textRegionExtensions.regionFor(componentImplementation)
						.keyword("(");
				ISemanticRegion rightParenthesis = textRegionExtensions
						.regionFor(componentImplementation).keyword(")");
				document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
				document.append(leftParenthesis, Aadl2Formatter::wrappableNoSpace);
				textRegionExtensions.regionFor(componentImplementation)
						.keywords(",")
						.forEach(element -> formatSeparator(document, element));
				componentImplementation.getOwnedPrototypeBindings().forEach(element -> format(element, document));
				if (rightParenthesis != null) {
					prependNewLineOrNoSpace(document, rightParenthesis);
					document.append(rightParenthesis, formatter -> formatter.setNewLines(1, 1, 2));
					document.interior(rightParenthesis, endKeyword, IHiddenRegionFormatter::indent);
				}
			}
		}

		// Section headings
		ISemanticRegion prototypesKeyword = textRegionExtensions.regionFor(componentImplementation)
				.keyword("prototypes");
		ISemanticRegion subcomponentsKeyword = textRegionExtensions.regionFor(componentImplementation)
				.keyword("subcomponents");
		ISemanticRegion internalKeyword = textRegionExtensions.regionFor(componentImplementation)
				.keyword("internal");
		ISemanticRegion callsKeyword = textRegionExtensions.regionFor(componentImplementation)
				.keyword("calls");
		ISemanticRegion connectionsKeyword = textRegionExtensions.regionFor(componentImplementation)
				.keyword("connections");
		ISemanticRegion flowsKeyword = textRegionExtensions.regionFor(componentImplementation)
				.keyword("flows");
		ISemanticRegion modesKeyword = textRegionExtensions.regionFor(componentImplementation)
				.keyword("modes");
		ISemanticRegion propertiesKeyword = textRegionExtensions.regionFor(componentImplementation)
				.keyword("properties");
		ISemanticRegion annexRegion = first(textRegionExtensions
				.semanticRegions(first(componentImplementation.getOwnedAnnexSubclauses())));
		if (prototypesKeyword != null) {
			document.append(prototypesKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker = firstPresent(subcomponentsKeyword, internalKeyword, processorKeyword, callsKeyword,
					connectionsKeyword, flowsKeyword, modesKeyword, propertiesKeyword, annexRegion, endKeyword);
			document.interior(prototypesKeyword, endMarker, IHiddenRegionFormatter::indent);
		}
		if (subcomponentsKeyword != null) {
			document.append(subcomponentsKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker_1 = firstPresent(internalKeyword, processorKeyword, callsKeyword, connectionsKeyword,
					flowsKeyword, modesKeyword, propertiesKeyword, annexRegion, endKeyword);
			document.interior(subcomponentsKeyword, endMarker_1, IHiddenRegionFormatter::indent);
		}
		if (internalFeaturesKeyword != null) {
			document.append(internalFeaturesKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker_2 = firstPresent(processorKeyword, callsKeyword, connectionsKeyword, flowsKeyword,
					modesKeyword, propertiesKeyword, annexRegion, endKeyword);
			document.interior(internalFeaturesKeyword, endMarker_2, IHiddenRegionFormatter::indent);
		}
		if (processorFeaturesKeyword != null) {
			document.append(processorFeaturesKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker_3 = firstPresent(callsKeyword, connectionsKeyword, flowsKeyword, modesKeyword,
					propertiesKeyword, annexRegion, endKeyword);
			document.interior(processorFeaturesKeyword, endMarker_3, IHiddenRegionFormatter::indent);
		}
		if (callsKeyword != null) {
			document.append(callsKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker_4 = firstPresent(connectionsKeyword, flowsKeyword, modesKeyword, propertiesKeyword,
					annexRegion, endKeyword);
			document.interior(callsKeyword, endMarker_4, IHiddenRegionFormatter::indent);
		}
		if (connectionsKeyword != null) {
			document.append(connectionsKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker_5 = firstPresent(flowsKeyword, modesKeyword, propertiesKeyword, annexRegion, endKeyword);
			document.interior(connectionsKeyword, endMarker_5, IHiddenRegionFormatter::indent);
		}
		if (flowsKeyword != null) {
			document.append(flowsKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker_6 = firstPresent(modesKeyword, propertiesKeyword, annexRegion, endKeyword);
			document.interior(flowsKeyword, endMarker_6, IHiddenRegionFormatter::indent);
		}
		if (modesKeyword != null) {
			document.append(modesKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker_7 = firstPresent(propertiesKeyword, annexRegion, endKeyword);
			document.interior(modesKeyword, endMarker_7, IHiddenRegionFormatter::indent);
		}
		if (propertiesKeyword != null) {
			document.append(propertiesKeyword, formatter -> formatter.setNewLines(1, 1, 2));
			var endMarker_8 = firstPresent(annexRegion, endKeyword);
			document.interior(propertiesKeyword, endMarker_8, IHiddenRegionFormatter::indent);
		}

		// Internal and processor features
		document.append(internalKeyword, IHiddenRegionFormatter::oneSpace);
		document.append(processorKeyword, IHiddenRegionFormatter::oneSpace);

		// None keywords
		textRegionExtensions.regionFor(componentImplementation).keywords("none")
				.forEach(element -> document.append(element, IHiddenRegionFormatter::noSpace));

		// Semicolons after none keywords
		List<ISemanticRegion> semicolons = textRegionExtensions.regionFor(componentImplementation)
				.keywords(";");
		if (semicolons.size() > 1) {
			take(semicolons, semicolons.size() - 1)
					.forEach(element -> document.append(element, formatter -> formatter.setNewLines(1, 1, 2)));
		}

		// Contents
		componentImplementation.getOwnedPrototypes().forEach(element -> format(element, document));
		componentImplementation.getOwnedSubcomponents().forEach(element -> format(element, document));
		componentImplementation.getOwnedInternalFeatures().forEach(element -> format(element, document));
		componentImplementation.getOwnedProcessorFeatures().forEach(element -> format(element, document));
		componentImplementation.getOwnedConnections().forEach(element -> format(element, document));
		componentImplementation.getOwnedFlowImplementations().forEach(element -> format(element, document));
		componentImplementation.getOwnedEndToEndFlows().forEach(element -> format(element, document));
		componentImplementation.getOwnedModes().forEach(element -> format(element, document));
		componentImplementation.getOwnedModeTransitions().forEach(element -> format(element, document));
		componentImplementation.getOwnedAnnexSubclauses().forEach(element -> format(element, document));

		// Properties
		componentImplementation.getOwnedPropertyAssociations().forEach(element -> {
			document.append(element, formatter -> formatter.setNewLines(1, 1, 2));
			format(element, document);
		});

		// End line
		document.append(endKeyword, IHiddenRegionFormatter::oneSpace);
		document.prepend(lastOrNull(semicolons), IHiddenRegionFormatter::noSpace);
	}

	private void formatBehavioredImplementationCommon(
			BehavioredImplementation behavioredImplementation, IFormattableDocument document,
			ISemanticRegion nameAssignment, ISemanticRegion internalFeaturesKeyword,
			ISemanticRegion processorKeyword, ISemanticRegion processorFeaturesKeyword) {
		behavioredImplementation.getOwnedSubprogramCallSequences().forEach(element -> format(element, document));
		formatComponentImplementationCommon(behavioredImplementation, document,
				nameAssignment, internalFeaturesKeyword, processorKeyword, processorFeaturesKeyword);
	}

	protected void _format(AbstractImplementation abstractImplementation, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(abstractImplementation)
						.keyword(grammarAccess.getAbstractImplementationAccess().getAbstractKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatBehavioredImplementationCommon(abstractImplementation, document,
				textRegionExtensions.regionFor(abstractImplementation)
						.assignment(grammarAccess.getAbstractImplementationAccess().getNameAssignment_4()),
				textRegionExtensions.regionFor(abstractImplementation)
						.keyword(grammarAccess.getAbstractImplementationAccess().getFeaturesKeyword_9_1()),
				textRegionExtensions.regionFor(abstractImplementation)
						.keyword(grammarAccess.getAbstractImplementationAccess().getProcessorKeyword_10_0()),
				textRegionExtensions.regionFor(abstractImplementation)
						.keyword(grammarAccess.getAbstractImplementationAccess().getFeaturesKeyword_10_1()));
	}

	protected void _format(ThreadImplementation threadImplementation, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(threadImplementation)
						.keyword(grammarAccess.getThreadImplementationAccess().getThreadKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatBehavioredImplementationCommon(threadImplementation, document,
				textRegionExtensions.regionFor(threadImplementation)
						.assignment(grammarAccess.getThreadImplementationAccess().getNameAssignment_4()),
				textRegionExtensions.regionFor(threadImplementation)
						.keyword(grammarAccess.getThreadImplementationAccess().getFeaturesKeyword_9_1()),
				textRegionExtensions.regionFor(threadImplementation)
						.keyword(grammarAccess.getThreadImplementationAccess().getProcessorKeyword_10_0()),
				textRegionExtensions.regionFor(threadImplementation)
						.keyword(grammarAccess.getThreadImplementationAccess().getFeaturesKeyword_10_1()));
	}

	protected void _format(SubprogramImplementation subprogramImplementation, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(subprogramImplementation)
						.keyword(grammarAccess.getSubprogramImplementationAccess().getSubprogramKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatBehavioredImplementationCommon(subprogramImplementation, document,
				textRegionExtensions.regionFor(subprogramImplementation)
						.assignment(grammarAccess.getSubprogramImplementationAccess().getNameAssignment_4()),
				textRegionExtensions.regionFor(subprogramImplementation)
						.keyword(grammarAccess.getSubprogramImplementationAccess().getFeaturesKeyword_9_1()),
				textRegionExtensions.regionFor(subprogramImplementation)
						.keyword(grammarAccess.getSubprogramImplementationAccess().getProcessorKeyword_10_0()),
				textRegionExtensions.regionFor(subprogramImplementation)
						.keyword(grammarAccess.getSubprogramImplementationAccess().getFeaturesKeyword_10_1()));
	}

	protected void _format(SystemImplementation systemImplementation, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(systemImplementation)
						.keyword(grammarAccess.getSystemImplementationAccess().getSystemKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentImplementationCommon(systemImplementation, document,
				textRegionExtensions.regionFor(systemImplementation)
						.assignment(grammarAccess.getSystemImplementationAccess().getNameAssignment_4()),
				textRegionExtensions.regionFor(systemImplementation)
						.keyword(grammarAccess.getSystemImplementationAccess().getFeaturesKeyword_9_1()),
				textRegionExtensions.regionFor(systemImplementation)
						.keyword(grammarAccess.getSystemImplementationAccess().getProcessorKeyword_10_0()),
				textRegionExtensions.regionFor(systemImplementation)
						.keyword(grammarAccess.getSystemImplementationAccess().getFeaturesKeyword_10_1()));
	}

	protected void _format(ProcessImplementation processImplementation, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(processImplementation)
						.keyword(grammarAccess.getProcessImplementationAccess().getProcessKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentImplementationCommon(processImplementation, document,
				textRegionExtensions.regionFor(processImplementation)
						.assignment(grammarAccess.getProcessImplementationAccess().getNameAssignment_4()),
				textRegionExtensions.regionFor(processImplementation)
						.keyword(grammarAccess.getProcessImplementationAccess().getFeaturesKeyword_9_1()),
				textRegionExtensions.regionFor(processImplementation)
						.keyword(grammarAccess.getProcessImplementationAccess().getProcessorKeyword_10_0()),
				textRegionExtensions.regionFor(processImplementation)
						.keyword(grammarAccess.getProcessImplementationAccess().getFeaturesKeyword_10_1()));
	}

	protected void _format(ThreadGroupImplementation threadGroupImplementation, IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(threadGroupImplementation)
						.keyword(grammarAccess.getThreadGroupImplementationAccess().getGroupKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentImplementationCommon(threadGroupImplementation, document,
				textRegionExtensions.regionFor(threadGroupImplementation)
						.assignment(grammarAccess.getThreadGroupImplementationAccess().getNameAssignment_5()),
				textRegionExtensions.regionFor(threadGroupImplementation)
						.keyword(grammarAccess.getThreadGroupImplementationAccess().getFeaturesKeyword_10_1()),
				textRegionExtensions.regionFor(threadGroupImplementation)
						.keyword(grammarAccess.getThreadGroupImplementationAccess().getProcessorKeyword_11_0()),
				textRegionExtensions.regionFor(threadGroupImplementation)
						.keyword(grammarAccess.getThreadGroupImplementationAccess().getFeaturesKeyword_11_1()));
	}

	protected void _format(SubprogramGroupImplementation subprogramGroupImplementation, IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(subprogramGroupImplementation)
						.keyword(grammarAccess.getSubprogramGroupImplementationAccess().getGroupKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentImplementationCommon(subprogramGroupImplementation, document,
				textRegionExtensions.regionFor(subprogramGroupImplementation)
						.assignment(grammarAccess.getSubprogramGroupImplementationAccess().getNameAssignment_5()),
				textRegionExtensions.regionFor(subprogramGroupImplementation)
						.keyword(grammarAccess.getSubprogramGroupImplementationAccess().getFeaturesKeyword_10_1()),
				textRegionExtensions.regionFor(subprogramGroupImplementation).keyword(
						grammarAccess.getSubprogramGroupImplementationAccess().getProcessorKeyword_11_0()),
				textRegionExtensions.regionFor(subprogramGroupImplementation).keyword(
						grammarAccess.getSubprogramGroupImplementationAccess().getFeaturesKeyword_11_1()));
	}

	protected void _format(ProcessorImplementation processorImplementation, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(processorImplementation)
						.keyword(grammarAccess.getProcessorImplementationAccess().getProcessorKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentImplementationCommon(processorImplementation, document,
				textRegionExtensions.regionFor(processorImplementation)
						.assignment(grammarAccess.getProcessorImplementationAccess().getNameAssignment_4()),
				textRegionExtensions.regionFor(processorImplementation).keyword(
						grammarAccess.getProcessorImplementationAccess().getFeaturesKeyword_9_1()),
				null, null);
	}

	protected void _format(VirtualProcessorImplementation virtualProcessorImplementation,
			IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(virtualProcessorImplementation)
						.keyword(grammarAccess.getVirtualProcessorImplementationAccess().getProcessorKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentImplementationCommon(virtualProcessorImplementation, document,
				textRegionExtensions.regionFor(virtualProcessorImplementation)
						.assignment(grammarAccess.getVirtualProcessorImplementationAccess().getNameAssignment_5()),
				textRegionExtensions.regionFor(virtualProcessorImplementation).keyword(
						grammarAccess.getVirtualProcessorImplementationAccess().getFeaturesKeyword_10_1()),
				textRegionExtensions.regionFor(virtualProcessorImplementation).keyword(
						grammarAccess.getVirtualProcessorImplementationAccess().getProcessorKeyword_11_0()),
				textRegionExtensions.regionFor(virtualProcessorImplementation).keyword(
						grammarAccess.getVirtualProcessorImplementationAccess().getFeaturesKeyword_11_1()));
	}

	protected void _format(DeviceImplementation deviceImplementation, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(deviceImplementation)
						.keyword(grammarAccess.getDeviceImplementationAccess().getDeviceKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentImplementationCommon(deviceImplementation, document,
				textRegionExtensions.regionFor(deviceImplementation)
						.assignment(grammarAccess.getDeviceImplementationAccess().getNameAssignment_4()),
				textRegionExtensions.regionFor(deviceImplementation)
						.keyword(grammarAccess.getDeviceImplementationAccess().getFeaturesKeyword_9_1()),
				textRegionExtensions.regionFor(deviceImplementation)
						.keyword(grammarAccess.getDeviceImplementationAccess().getProcessorKeyword_10_0()),
				textRegionExtensions.regionFor(deviceImplementation)
						.keyword(grammarAccess.getDeviceImplementationAccess().getFeaturesKeyword_10_1()));
	}

	protected void _format(MemoryImplementation memoryImplementation, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(memoryImplementation)
						.keyword(grammarAccess.getMemoryImplementationAccess().getMemoryKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentImplementationCommon(memoryImplementation, document,
				textRegionExtensions.regionFor(memoryImplementation)
						.assignment(grammarAccess.getMemoryImplementationAccess().getNameAssignment_4()),
				textRegionExtensions.regionFor(memoryImplementation).keyword(
						grammarAccess.getMemoryImplementationAccess().getFeaturesKeyword_9_1()),
				null, null);
	}

	protected void _format(BusImplementation busImplementation, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(busImplementation)
						.keyword(grammarAccess.getBusImplementationAccess().getBusKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentImplementationCommon(busImplementation, document,
				textRegionExtensions.regionFor(busImplementation)
						.assignment(grammarAccess.getBusImplementationAccess().getNameAssignment_4()),
				textRegionExtensions.regionFor(busImplementation)
						.keyword(grammarAccess.getBusImplementationAccess().getFeaturesKeyword_9_1()),
				null, null);
	}

	protected void _format(VirtualBusImplementation virtualBusImplementation, IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(virtualBusImplementation)
						.keyword(grammarAccess.getVirtualBusImplementationAccess().getBusKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentImplementationCommon(virtualBusImplementation, document,
				textRegionExtensions.regionFor(virtualBusImplementation)
						.assignment(grammarAccess.getVirtualBusImplementationAccess().getNameAssignment_5()),
				textRegionExtensions.regionFor(virtualBusImplementation).keyword(
						grammarAccess.getVirtualBusImplementationAccess().getFeaturesKeyword_10_1()),
				null, null);
	}

	protected void _format(DataImplementation dataImplementation, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(dataImplementation)
						.keyword(grammarAccess.getDataImplementationAccess().getDataKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		formatComponentImplementationCommon(dataImplementation, document,
				textRegionExtensions.regionFor(dataImplementation)
						.assignment(grammarAccess.getDataImplementationAccess().getNameAssignment_5()),
				textRegionExtensions.regionFor(dataImplementation).keyword(
						grammarAccess.getDataImplementationAccess().getFeaturesKeyword_10_1()),
				null, null);
	}

	protected void _format(ImplementationExtension implementationExtension, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(implementationExtension)
						.keyword(grammarAccess.getImplementationExtensionAccess().getExtendsKeyword_0()),
				IHiddenRegionFormatter::oneSpace);
	}

	protected void _format(EventSource eventSource, IFormattableDocument document) {
		conditionalAppend(eventSource, document, formatter -> formatter.setNewLines(1, 1, 2));
		document.append(document.prepend(
				textRegionExtensions.regionFor(eventSource)
						.keyword(grammarAccess.getEventSourceAccess().getColonKeyword_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		formatCurlyProperties(eventSource, document,
				textRegionExtensions.regionFor(eventSource)
						.keyword(grammarAccess.getEventSourceAccess().getLeftCurlyBracketKeyword_3_0()),
				textRegionExtensions.regionFor(eventSource)
						.keyword(grammarAccess.getEventSourceAccess().getRightCurlyBracketKeyword_3_2()));
		document.prepend(
				textRegionExtensions.regionFor(eventSource)
						.keyword(grammarAccess.getEventSourceAccess().getSemicolonKeyword_4()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(EventDataSource eventDataSource, IFormattableDocument document) {
		conditionalAppend(eventDataSource, document, formatter -> formatter.setNewLines(1, 1, 2));
		document.append(document.prepend(
				textRegionExtensions.regionFor(eventDataSource)
						.keyword(grammarAccess.getEventDataSourceAccess().getColonKeyword_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(eventDataSource)
						.keyword(grammarAccess.getEventDataSourceAccess().getEventKeyword_2()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(eventDataSource)
						.assignment(grammarAccess.getEventDataSourceAccess().getDataClassifierAssignment_4()),
				IHiddenRegionFormatter::oneSpace);
		formatCurlyProperties(eventDataSource, document,
				textRegionExtensions.regionFor(eventDataSource)
						.keyword(grammarAccess.getEventDataSourceAccess().getLeftCurlyBracketKeyword_5_0()),
				textRegionExtensions.regionFor(eventDataSource)
						.keyword(grammarAccess.getEventDataSourceAccess().getRightCurlyBracketKeyword_5_2()));
		document.prepend(
				textRegionExtensions.regionFor(eventDataSource)
						.keyword(grammarAccess.getEventDataSourceAccess().getSemicolonKeyword_6()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(PortProxy portProxy, IFormattableDocument document) {
		conditionalAppend(portProxy, document, formatter -> formatter.setNewLines(1, 1, 2));
		document.append(
				document.prepend(
						textRegionExtensions.regionFor(portProxy)
								.keyword(grammarAccess.getPortProxyAccess().getColonKeyword_1()),
						IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(portProxy)
						.assignment(grammarAccess.getPortProxyAccess().getDataClassifierAssignment_3()),
				IHiddenRegionFormatter::oneSpace);
		formatCurlyProperties(portProxy, document,
				textRegionExtensions.regionFor(portProxy)
						.keyword(grammarAccess.getPortProxyAccess().getLeftCurlyBracketKeyword_4_0()),
				textRegionExtensions.regionFor(portProxy)
						.keyword(grammarAccess.getPortProxyAccess().getRightCurlyBracketKeyword_4_2()));
		document.prepend(
				textRegionExtensions.regionFor(portProxy)
						.keyword(grammarAccess.getPortProxyAccess().getSemicolonKeyword_5()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(SubprogramProxy subprogramProxy, IFormattableDocument document) {
		conditionalAppend(subprogramProxy, document, formatter -> formatter.setNewLines(1, 1, 2));
		document.append(document.prepend(
				textRegionExtensions.regionFor(subprogramProxy)
						.keyword(grammarAccess.getSubprogramProxyAccess().getColonKeyword_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.prepend(
				textRegionExtensions.regionFor(subprogramProxy).assignment(
						grammarAccess.getSubprogramProxyAccess().getSubprogramClassifierAssignment_3()),
				IHiddenRegionFormatter::oneSpace);
		formatCurlyProperties(subprogramProxy, document,
				textRegionExtensions.regionFor(subprogramProxy)
						.keyword(grammarAccess.getSubprogramProxyAccess().getLeftCurlyBracketKeyword_4_0()),
				textRegionExtensions.regionFor(subprogramProxy)
						.keyword(grammarAccess.getSubprogramProxyAccess().getRightCurlyBracketKeyword_4_2()));
		document.prepend(
				textRegionExtensions.regionFor(subprogramProxy)
						.keyword(grammarAccess.getSubprogramProxyAccess().getSemicolonKeyword_5()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(SubprogramCallSequence subprogramCallSequence, IFormattableDocument document) {
		conditionalAppend(subprogramCallSequence, document,
				formatter -> formatter.setNewLines(1, 1, 2));
		document.append(document.prepend(
				textRegionExtensions.regionFor(subprogramCallSequence)
						.keyword(grammarAccess.getSubprogramCallSequenceAccess().getColonKeyword_1()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		ISemanticRegion leftCurly = textRegionExtensions.regionFor(subprogramCallSequence)
				.keyword(grammarAccess.getSubprogramCallSequenceAccess().getLeftCurlyBracketKeyword_2());
		document.append(leftCurly, formatter -> formatter.setNewLines(1, 1, 2));
		document.interior(leftCurly,
				textRegionExtensions.regionFor(subprogramCallSequence)
						.keyword(grammarAccess.getSubprogramCallSequenceAccess().getRightCurlyBracketKeyword_4()),
				IHiddenRegionFormatter::indent);
		subprogramCallSequence.getOwnedSubprogramCalls().forEach(element -> format(element, document));
		formatCurlyProperties(subprogramCallSequence, document,
				textRegionExtensions.regionFor(subprogramCallSequence)
						.keyword(grammarAccess.getSubprogramCallSequenceAccess().getLeftCurlyBracketKeyword_5_0()),
				textRegionExtensions.regionFor(subprogramCallSequence).keyword(
						grammarAccess.getSubprogramCallSequenceAccess().getRightCurlyBracketKeyword_5_2()));

		// In modes
		ISemanticRegion leftParenthesis = textRegionExtensions.regionFor(subprogramCallSequence)
				.keyword(grammarAccess.getSubprogramCallSequenceAccess().getLeftParenthesisKeyword_6_2());
		ISemanticRegion rightParenthesis = textRegionExtensions.regionFor(subprogramCallSequence)
				.keyword(grammarAccess.getSubprogramCallSequenceAccess().getRightParenthesisKeyword_6_4());
		if (leftParenthesis != null && rightParenthesis != null) {
			document.surround(
					textRegionExtensions.regionFor(subprogramCallSequence)
							.keyword(grammarAccess.getSubprogramCallSequenceAccess().getInKeyword_6_0()),
					IHiddenRegionFormatter::oneSpace);
			document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
			document.append(document.prepend(leftParenthesis, IHiddenRegionFormatter::oneSpace),
					Aadl2Formatter::wrappableNoSpace);
			textRegionExtensions.regionFor(subprogramCallSequence)
					.keywords(grammarAccess.getSubprogramCallSequenceAccess().getCommaKeyword_6_3_1_0())
					.forEach(element -> formatSeparator(document, element));
			prependNewLineOrNoSpace(document, rightParenthesis);
		}
		document.prepend(
				textRegionExtensions.regionFor(subprogramCallSequence)
						.keyword(grammarAccess.getSubprogramCallSequenceAccess().getSemicolonKeyword_7()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(SubprogramCall subprogramCall, IFormattableDocument document) {
		conditionalAppend(subprogramCall, document, formatter -> formatter.setNewLines(1, 1, 2));
		document.append(document.prepend(
				textRegionExtensions.regionFor(subprogramCall)
						.keyword(grammarAccess.getSubprogramCallAccess().getColonKeyword_2()),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.append(
				textRegionExtensions.regionFor(subprogramCall)
						.keyword(grammarAccess.getSubprogramCallAccess().getSubprogramKeyword_3()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(subprogramCall)
						.keyword(grammarAccess.getSubprogramCallAccess().getFullStopKeyword_4_0_1()),
				IHiddenRegionFormatter::noSpace);
		document.surround(
				textRegionExtensions.regionFor(subprogramCall)
						.keyword(grammarAccess.getSubprogramCallAccess().getFullStopKeyword_4_2_1()),
				IHiddenRegionFormatter::noSpace);
		formatCurlyProperties(subprogramCall, document,
				textRegionExtensions.regionFor(subprogramCall)
						.keyword(grammarAccess.getSubprogramCallAccess().getLeftCurlyBracketKeyword_5_0()),
				textRegionExtensions.regionFor(subprogramCall)
						.keyword(grammarAccess.getSubprogramCallAccess().getRightCurlyBracketKeyword_5_2()));
		document.prepend(
				textRegionExtensions.regionFor(subprogramCall)
						.keyword(grammarAccess.getSubprogramCallAccess().getSemicolonKeyword_6()),
				IHiddenRegionFormatter::noSpace);
	}

	private void formatSubcomponentCommon(Subcomponent subcomponent,
			IFormattableDocument document, ISemanticRegion subcomponentTypeAssignment) {
		conditionalAppend(subcomponent, document, formatter -> formatter.setNewLines(1, 1, 2));

		// Named and refined to
		document.append(document.prepend(textRegionExtensions.regionFor(subcomponent).keyword(":"),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(textRegionExtensions.regionFor(subcomponent).keyword("to"), IHiddenRegionFormatter::oneSpace);
		document.prepend(subcomponentTypeAssignment, IHiddenRegionFormatter::oneSpace);

		// Parenthesis found in prototype bindings, implementation references, and mode bindings
		textRegionExtensions.regionFor(subcomponent).keywordPairs("(", ")").forEach(pair -> {
			document.interior(pair.getKey(), pair.getValue(), IHiddenRegionFormatter::indent);
			document.append(document.prepend(pair.getKey(), IHiddenRegionFormatter::oneSpace),
					Aadl2Formatter::wrappableNoSpace);
			if (pair.getValue().getPreviousHiddenRegion().isMultiline()) {
				document.prepend(pair.getValue(), formatter -> formatter.setNewLines(1));
			} else {
				document.prepend(pair.getValue(), IHiddenRegionFormatter::noSpace);
			}
		});

		// Commas found in prototype bindings, implementation references, and mode bindings
		textRegionExtensions.regionFor(subcomponent)
				.keywords(",")
				.forEach(element -> formatSeparator(document, element));
		subcomponent.getOwnedPrototypeBindings().forEach(element -> format(element, document));
		subcomponent.getArrayDimensions().forEach(element -> {
			document.prepend(element, IHiddenRegionFormatter::noSpace);
			format(element, document);
		});
		subcomponent.getImplementationReferences().forEach(element -> format(element, document));
		formatCurlyProperties(subcomponent, document,
				textRegionExtensions.regionFor(subcomponent).keyword("{"),
				textRegionExtensions.regionFor(subcomponent).keyword("}"));

		// In modes
		document.surround(textRegionExtensions.regionFor(subcomponent).keyword("in"), IHiddenRegionFormatter::oneSpace);
		subcomponent.getOwnedModeBindings().forEach(element -> format(element, document));
		document.prepend(textRegionExtensions.regionFor(subcomponent).keyword(";"), IHiddenRegionFormatter::noSpace);
	}

	protected void _format(AbstractSubcomponent abstractSubcomponent, IFormattableDocument document) {
		formatSubcomponentCommon(abstractSubcomponent, document,
				textRegionExtensions.regionFor(abstractSubcomponent).assignment(grammarAccess
						.getAbstractSubcomponentAccess().getAbstractSubcomponentTypeAssignment_2_0()));
	}

	protected void _format(SystemSubcomponent systemSubcomponent, IFormattableDocument document) {
		formatSubcomponentCommon(systemSubcomponent, document,
				textRegionExtensions.regionFor(systemSubcomponent).assignment(
						grammarAccess.getSystemSubcomponentAccess().getSystemSubcomponentTypeAssignment_2_0()));
	}

	protected void _format(ProcessSubcomponent processSubcomponent, IFormattableDocument document) {
		formatSubcomponentCommon(processSubcomponent, document,
				textRegionExtensions.regionFor(processSubcomponent).assignment(
						grammarAccess.getProcessSubcomponentAccess().getProcessSubcomponentTypeAssignment_2_0()));
	}

	protected void _format(ThreadGroupSubcomponent threadGroupSubcomponent, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(threadGroupSubcomponent)
						.keyword(grammarAccess.getThreadGroupSubcomponentAccess().getThreadKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		formatSubcomponentCommon(threadGroupSubcomponent, document,
				textRegionExtensions.regionFor(threadGroupSubcomponent).assignment(grammarAccess
						.getThreadGroupSubcomponentAccess().getThreadGroupSubcomponentTypeAssignment_3_0()));
	}

	protected void _format(ThreadSubcomponent threadSubcomponent, IFormattableDocument document) {
		formatSubcomponentCommon(threadSubcomponent, document,
				textRegionExtensions.regionFor(threadSubcomponent).assignment(
						grammarAccess.getThreadSubcomponentAccess().getThreadSubcomponentTypeAssignment_2_0()));
	}

	protected void _format(SubprogramSubcomponent subprogramSubcomponent, IFormattableDocument document) {
		formatSubcomponentCommon(subprogramSubcomponent, document,
				textRegionExtensions.regionFor(subprogramSubcomponent).assignment(grammarAccess
						.getSubprogramSubcomponentAccess().getSubprogramSubcomponentTypeAssignment_2_0()));
	}

	protected void _format(SubprogramGroupSubcomponent subprogramGroupSubcomponent, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(subprogramGroupSubcomponent)
						.keyword(grammarAccess.getSubprogramGroupSubcomponentAccess().getSubprogramKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		formatSubcomponentCommon(subprogramGroupSubcomponent, document,
				textRegionExtensions.regionFor(subprogramGroupSubcomponent).assignment(grammarAccess
						.getSubprogramGroupSubcomponentAccess().getSubprogramGroupSubcomponentTypeAssignment_3_0()));
	}

	protected void _format(ProcessorSubcomponent processorSubcomponent, IFormattableDocument document) {
		formatSubcomponentCommon(processorSubcomponent, document,
				textRegionExtensions.regionFor(processorSubcomponent).assignment(grammarAccess
						.getProcessorSubcomponentAccess().getProcessorSubcomponentTypeAssignment_2_0()));
	}

	protected void _format(VirtualProcessorSubcomponent virtualProcessorSubcomponent, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(virtualProcessorSubcomponent)
						.keyword(grammarAccess.getVirtualProcessorSubcomponentAccess().getVirtualKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		formatSubcomponentCommon(virtualProcessorSubcomponent, document,
				textRegionExtensions.regionFor(virtualProcessorSubcomponent).assignment(grammarAccess
						.getVirtualProcessorSubcomponentAccess().getVirtualProcessorSubcomponentTypeAssignment_3_0()));
	}

	protected void _format(DeviceSubcomponent deviceSubcomponent, IFormattableDocument document) {
		formatSubcomponentCommon(deviceSubcomponent, document,
				textRegionExtensions.regionFor(deviceSubcomponent).assignment(
						grammarAccess.getDeviceSubcomponentAccess().getDeviceSubcomponentTypeAssignment_2_0()));
	}

	protected void _format(MemorySubcomponent memorySubcomponent, IFormattableDocument document) {
		formatSubcomponentCommon(memorySubcomponent, document,
				textRegionExtensions.regionFor(memorySubcomponent).assignment(
						grammarAccess.getMemorySubcomponentAccess().getMemorySubcomponentTypeAssignment_2_0()));
	}

	protected void _format(BusSubcomponent busSubcomponent, IFormattableDocument document) {
		formatSubcomponentCommon(busSubcomponent, document, textRegionExtensions.regionFor(busSubcomponent)
				.assignment(grammarAccess.getBusSubcomponentAccess().getBusSubcomponentTypeAssignment_2_0()));
	}

	protected void _format(VirtualBusSubcomponent virtualBusSubcomponent, IFormattableDocument document) {
		document.append(
				textRegionExtensions.regionFor(virtualBusSubcomponent)
						.keyword(grammarAccess.getVirtualBusSubcomponentAccess().getVirtualKeyword_1()),
				IHiddenRegionFormatter::oneSpace);
		formatSubcomponentCommon(virtualBusSubcomponent, document,
				textRegionExtensions.regionFor(virtualBusSubcomponent).assignment(grammarAccess
						.getVirtualBusSubcomponentAccess().getVirtualBusSubcomponentTypeAssignment_3_0()));
	}

	protected void _format(DataSubcomponent dataSubcomponent, IFormattableDocument document) {
		formatSubcomponentCommon(dataSubcomponent, document, textRegionExtensions.regionFor(dataSubcomponent)
				.assignment(grammarAccess.getDataSubcomponentAccess().getDataSubcomponentTypeAssignment_2_0()));
	}

	protected void _format(ComponentImplementationReference componentImplementationReference,
			IFormattableDocument document) {
		ISemanticRegion leftParenthesis = textRegionExtensions.regionFor(componentImplementationReference)
				.keyword(
						grammarAccess.getComponentImplementationReferenceAccess().getLeftParenthesisKeyword_2_0());
		ISemanticRegion rightParenthesis = textRegionExtensions.regionFor(componentImplementationReference)
				.keyword(grammarAccess.getComponentImplementationReferenceAccess()
						.getRightParenthesisKeyword_2_3());
		if (leftParenthesis != null && rightParenthesis != null) {
			document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
			document.append(document.prepend(leftParenthesis, IHiddenRegionFormatter::oneSpace),
					Aadl2Formatter::wrappableNoSpace);
			componentImplementationReference.getOwnedPrototypeBindings().forEach(element -> format(element, document));
			textRegionExtensions.regionFor(componentImplementationReference)
					.keywords(grammarAccess.getComponentImplementationReferenceAccess().getCommaKeyword_2_2_0())
					.forEach(element -> formatSeparator(document, element));
			prependNewLineOrNoSpace(document, rightParenthesis);
		}
	}

	protected void _format(ModeBinding modeBinding, IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(modeBinding)
						.keyword(grammarAccess.getModeRefAccess().getEqualsSignGreaterThanSignKeyword_1_0()),
				IHiddenRegionFormatter::oneSpace);
	}

	private void formatConnectionCommon(Connection connection, IFormattableDocument document) {
		conditionalAppend(connection, document, formatter -> formatter.setNewLines(1, 1, 2));

		// Named and refined to
		document.append(document.prepend(textRegionExtensions.regionFor(connection).keyword(":"),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(textRegionExtensions.regionFor(connection).keyword("to"), IHiddenRegionFormatter::oneSpace);

		// Connection ends
		document.surround(connection.getSource(), IHiddenRegionFormatter::oneSpace);
		format(connection.getSource(), document);
		document.prepend(connection.getDestination(), IHiddenRegionFormatter::oneSpace);
		format(connection.getDestination(), document);
		formatCurlyProperties(connection, document,
				textRegionExtensions.regionFor(connection).keyword("{"),
				textRegionExtensions.regionFor(connection).keyword("}"));

		// In modes
		ISemanticRegion leftParenthesis = textRegionExtensions.regionFor(connection).keyword("(");
		ISemanticRegion rightParenthesis = textRegionExtensions.regionFor(connection).keyword(")");
		if (leftParenthesis != null && rightParenthesis != null) {
			document.surround(textRegionExtensions.regionFor(connection).keyword("in"),
					IHiddenRegionFormatter::oneSpace);
			document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
			document.append(document.prepend(leftParenthesis, IHiddenRegionFormatter::oneSpace),
					Aadl2Formatter::wrappableNoSpace);
			textRegionExtensions.regionFor(connection)
					.keywords(",")
					.forEach(element -> formatSeparator(document, element));
			prependNewLineOrNoSpace(document, rightParenthesis);
		}
		document.prepend(textRegionExtensions.regionFor(connection).keyword(";"), IHiddenRegionFormatter::noSpace);
	}

	protected void _format(PortConnection portConnection, IFormattableDocument document) {
		formatConnectionCommon(portConnection, document);
	}

	protected void _format(AccessConnection accessConnection, IFormattableDocument document) {
		document.prepend(textRegionExtensions.regionFor(accessConnection).keyword("access"),
				IHiddenRegionFormatter::oneSpace);
		formatConnectionCommon(accessConnection, document);
	}

	protected void _format(FeatureGroupConnection featureGroupConnection, IFormattableDocument document) {
		document.append(textRegionExtensions.regionFor(featureGroupConnection).keyword("feature"),
				IHiddenRegionFormatter::oneSpace);
		formatConnectionCommon(featureGroupConnection, document);
	}

	protected void _format(FeatureConnection featureConnection, IFormattableDocument document) {
		formatConnectionCommon(featureConnection, document);
	}

	protected void _format(ParameterConnection parameterConnection, IFormattableDocument document) {
		formatConnectionCommon(parameterConnection, document);
	}

	protected void _format(ConnectedElement connectedElement, IFormattableDocument document) {
		document.surround(textRegionExtensions.regionFor(connectedElement).keyword("."),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(FlowSpecification flowSpecification, IFormattableDocument document) {
		conditionalAppend(flowSpecification, document,
				formatter -> formatter.setNewLines(1, 1, 2));

		// Named and refined to
		document.append(document.prepend(textRegionExtensions.regionFor(flowSpecification).keyword(":"),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(flowSpecification)
						.keyword(grammarAccess.getFlowSpecRefinementAccess().getToKeyword_3()),
				IHiddenRegionFormatter::oneSpace);
		document.append(textRegionExtensions.regionFor(flowSpecification).keyword("flow"),
				IHiddenRegionFormatter::oneSpace);

		// In and out ends
		document.prepend(flowSpecification.getInEnd(), IHiddenRegionFormatter::oneSpace);
		format(flowSpecification.getInEnd(), document);
		document.prepend(
				textRegionExtensions.regionFor(flowSpecification)
						.keyword(grammarAccess.getFlowPathSpecAccess().getHyphenMinusGreaterThanSignKeyword_5()),
				IHiddenRegionFormatter::oneSpace);
		document.prepend(flowSpecification.getOutEnd(), IHiddenRegionFormatter::oneSpace);
		format(flowSpecification.getOutEnd(), document);
		formatCurlyProperties(flowSpecification, document,
				textRegionExtensions.regionFor(flowSpecification).keyword("{"),
				textRegionExtensions.regionFor(flowSpecification).keyword("}"));

		// In modes
		ISemanticRegion leftParenthesis = textRegionExtensions.regionFor(flowSpecification).keyword("(");
		ISemanticRegion rightParenthesis = textRegionExtensions.regionFor(flowSpecification).keyword(")");
		if (leftParenthesis != null && rightParenthesis != null) {
			document.surround(textRegionExtensions.regionFor(flowSpecification).keyword("in"),
					IHiddenRegionFormatter::oneSpace);
			document.append(document.prepend(leftParenthesis, IHiddenRegionFormatter::oneSpace),
					Aadl2Formatter::wrappableNoSpace);
			document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
			textRegionExtensions.regionFor(flowSpecification)
					.keywords(",")
					.forEach(element -> formatSeparator(document, element));
			prependNewLineOrNoSpace(document, rightParenthesis);
		}
		document.prepend(textRegionExtensions.regionFor(flowSpecification).keyword(";"),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(FlowEnd flowEnd, IFormattableDocument document) {
		textRegionExtensions.regionFor(flowEnd)
				.keywords(grammarAccess.getFlowEndAccess().getFullStopKeyword_1_1())
						.forEach(element -> document.surround(element, IHiddenRegionFormatter::noSpace));
	}

	protected void _format(FlowImplementation flowImplementation, IFormattableDocument document) {
		conditionalAppend(flowImplementation, document,
				formatter -> formatter.setNewLines(1, 1, 2));
		document.append(document.prepend(textRegionExtensions.regionFor(flowImplementation).keyword(":"),
				IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(flowImplementation)
						.assignment(grammarAccess.getFlowSourceImplAccess().getKindAssignment_3()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(flowImplementation)
						.assignment(grammarAccess.getFlowSinkImplAccess().getKindAssignment_3()),
				IHiddenRegionFormatter::oneSpace);
		document.surround(
				textRegionExtensions.regionFor(flowImplementation)
						.assignment(grammarAccess.getFlowPathImplAccess().getKindAssignment_3()),
				IHiddenRegionFormatter::oneSpace);

		// Segments
		textRegionExtensions.regionFor(flowImplementation).keywords("->")
				.forEach(element -> document.surround(element, IHiddenRegionFormatter::oneSpace));
		flowImplementation.getOwnedFlowSegments().forEach(element -> format(element, document));
		formatCurlyProperties(flowImplementation, document,
				textRegionExtensions.regionFor(flowImplementation).keyword("{"),
				textRegionExtensions.regionFor(flowImplementation).keyword("}"));

		// In modes
		ISemanticRegion leftParenthesis = textRegionExtensions.regionFor(flowImplementation).keyword("(");
		ISemanticRegion rightParenthesis = textRegionExtensions.regionFor(flowImplementation).keyword(")");
		if (leftParenthesis != null && rightParenthesis != null) {
			document.surround(textRegionExtensions.regionFor(flowImplementation).keyword("in"),
					IHiddenRegionFormatter::oneSpace);
			document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
			document.append(document.prepend(leftParenthesis, IHiddenRegionFormatter::oneSpace),
					Aadl2Formatter::wrappableNoSpace);
			textRegionExtensions.regionFor(flowImplementation)
					.keywords(",")
					.forEach(element -> formatSeparator(document, element));
			prependNewLineOrNoSpace(document, rightParenthesis);
		}
		document.prepend(textRegionExtensions.regionFor(flowImplementation).keyword(";"),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(FlowSegment flowSegment, IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(flowSegment)
						.keyword(grammarAccess.getSubcomponentFlowAccess().getFullStopKeyword_0_1()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(EndToEndFlow endToEndFlow, IFormattableDocument document) {
		conditionalAppend(endToEndFlow, document, formatter -> formatter.setNewLines(1, 1, 2));
		if (endToEndFlow.getRefined() == null) {
			// Named
			document.append(document.prepend(
					textRegionExtensions.regionFor(endToEndFlow)
							.keyword(grammarAccess.getEndToEndFlowAccess().getColonKeyword_0_0_1()),
					IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
			document.surround(
					textRegionExtensions.regionFor(endToEndFlow)
							.keyword(grammarAccess.getEndToEndFlowAccess().getToKeyword_0_0_3()),
					IHiddenRegionFormatter::oneSpace);
			document.surround(
					textRegionExtensions.regionFor(endToEndFlow)
							.keyword(grammarAccess.getEndToEndFlowAccess().getFlowKeyword_0_0_5()),
					IHiddenRegionFormatter::oneSpace);
			endToEndFlow.getOwnedEndToEndFlowSegments().forEach(element -> format(element, document));
			textRegionExtensions.regionFor(endToEndFlow).keywords("->")
					.forEach(element -> document.surround(element, IHiddenRegionFormatter::oneSpace));
		} else {
			// Refined to
			document.append(document.prepend(
					textRegionExtensions.regionFor(endToEndFlow)
							.keyword(grammarAccess.getEndToEndFlowAccess().getColonKeyword_0_1_1()),
					IHiddenRegionFormatter::noSpace), IHiddenRegionFormatter::oneSpace);
			document.surround(
					textRegionExtensions.regionFor(endToEndFlow)
							.keyword(grammarAccess.getEndToEndFlowAccess().getToKeyword_0_1_3()),
					IHiddenRegionFormatter::oneSpace);
			document.surround(
					textRegionExtensions.regionFor(endToEndFlow)
							.keyword(grammarAccess.getEndToEndFlowAccess().getToKeyword_0_1_5()),
					IHiddenRegionFormatter::oneSpace);
			document.prepend(
					textRegionExtensions.regionFor(endToEndFlow)
							.keyword(grammarAccess.getEndToEndFlowAccess().getFlowKeyword_0_1_7()),
					IHiddenRegionFormatter::oneSpace);
		}
		formatCurlyProperties(endToEndFlow, document,
				textRegionExtensions.regionFor(endToEndFlow)
						.keyword(grammarAccess.getEndToEndFlowAccess().getLeftCurlyBracketKeyword_1_0()),
				textRegionExtensions.regionFor(endToEndFlow)
						.keyword(grammarAccess.getEndToEndFlowAccess().getRightCurlyBracketKeyword_1_2()));

		// In modes
		ISemanticRegion leftParenthesis = textRegionExtensions.regionFor(endToEndFlow)
				.keyword(grammarAccess.getEndToEndFlowAccess().getLeftParenthesisKeyword_2_2());
		ISemanticRegion rightParenthesis = textRegionExtensions.regionFor(endToEndFlow)
				.keyword(grammarAccess.getEndToEndFlowAccess().getRightParenthesisKeyword_2_5());
		if (leftParenthesis != null && rightParenthesis != null) {
			document.surround(
					textRegionExtensions.regionFor(endToEndFlow)
							.keyword(grammarAccess.getEndToEndFlowAccess().getInKeyword_2_0()),
					IHiddenRegionFormatter::oneSpace);
			document.interior(leftParenthesis, rightParenthesis, IHiddenRegionFormatter::indent);
			document.append(document.prepend(leftParenthesis, IHiddenRegionFormatter::oneSpace),
					Aadl2Formatter::wrappableNoSpace);
			textRegionExtensions.regionFor(endToEndFlow)
					.keywords(grammarAccess.getEndToEndFlowAccess().getCommaKeyword_2_4_0())
							.forEach(element -> formatSeparator(document, element));
			prependNewLineOrNoSpace(document, rightParenthesis);
		}
		document.prepend(
				textRegionExtensions.regionFor(endToEndFlow)
						.keyword(grammarAccess.getEndToEndFlowAccess().getSemicolonKeyword_3()),
				IHiddenRegionFormatter::noSpace);
	}

	protected void _format(EndToEndFlowSegment endToEndFlowSegment, IFormattableDocument document) {
		document.surround(
				textRegionExtensions.regionFor(endToEndFlowSegment)
						.keyword(grammarAccess.getETESubcomponentFlowAccess().getFullStopKeyword_0_1()),
				IHiddenRegionFormatter::noSpace);
	}

	/**
	 * The first element, or {@code null} when there is none.
	 */
	private static <T> T first(Iterable<T> elements) {
		var iterator = elements.iterator();
		return iterator.hasNext() ? iterator.next() : null;
	}

	/**
	 * The last element, or {@code null} when there is none.
	 */
	private static <T> T lastOrNull(Iterable<T> elements) {
		T last = null;
		for (var element : elements) {
			last = element;
		}
		return last;
	}

	/**
	 * A lazy view of the first {@code count} elements.
	 */
	private static <T> Iterable<T> take(Iterable<T> elements, long count) {
		return () -> StreamSupport.stream(elements.spliterator(), false).limit(count).iterator();
	}

	/**
	 * A lazy view of all elements but the first.
	 */
	private static <T> Iterable<T> tail(Iterable<T> elements) {
		return () -> StreamSupport.stream(elements.spliterator(), false).skip(1).iterator();
	}

	/**
	 * Separates the surrounded elements by a single space that may be turned into a line break when the line gets too
	 * long.
	 */
	private static void wrappableSpace(IHiddenRegionFormatter formatter) {
		formatter.oneSpace();
		formatter.setNewLines(0, 0, 1);
		formatter.autowrap();
	}

	/**
	 * Keeps the surrounded elements directly adjacent, but still allows a line break when the line gets too long.
	 */
	private static void wrappableNoSpace(IHiddenRegionFormatter formatter) {
		formatter.noSpace();
		formatter.setNewLines(0, 0, 1);
		formatter.autowrap();
	}

	/**
	 * Puts a separator, typically a comma, directly behind the preceding element and separates it from the following
	 * one by a wrappable space.
	 */
	private static void formatSeparator(IFormattableDocument document, ISemanticRegion separator) {
		document.append(document.prepend(separator, IHiddenRegionFormatter::noSpace), Aadl2Formatter::wrappableSpace);
	}

	/**
	 * The semantic element that follows the given one in the text, or {@code null} if nothing follows it or the element
	 * has no text of its own.
	 */
	private static EObject nextSemanticElement(ISemanticRegion region) {
		var nextRegion = region.getNextSemanticRegion();
		return nextRegion == null ? null : nextRegion.getSemanticElement();
	}

	/**
	 * The semantic element that follows the given one in the text, or {@code null} if nothing follows it or the element
	 * has no text of its own.
	 */
	private EObject nextSemanticElement(EObject element) {
		var elementRegion = textRegionExtensions.regionForEObject(element);
		if (elementRegion == null) {
			return null;
		}
		var nextRegion = elementRegion.getNextSemanticRegion();
		return nextRegion == null ? null : nextRegion.getSemanticElement();
	}

	/**
	 * The first of the given regions that is present. Used to find where an indented section ends when all of the
	 * following sections are optional.
	 */
	private static ISemanticRegion firstPresent(ISemanticRegion... regions) {
		return Stream.of(regions).filter(Objects::nonNull).findFirst().orElse(null);
	}

	/**
	 * Top level declarations are separated from each other by a blank line, everything else by a plain line break.
	 */
	private static boolean startsTopLevelDeclaration(EObject element) {
		return element instanceof Classifier || element instanceof AnnexLibrary || element instanceof PackageSection;
	}

	/**
	 * Puts a closing bracket or parenthesis on its own line when the enclosed region spans several lines, and directly
	 * behind the last element otherwise. Tolerates a missing region, as the original code did.
	 */
	private static void prependNewLineOrNoSpace(IFormattableDocument document, ISemanticRegion closingRegion) {
		if (closingRegion == null) {
			return;
		}
		if (closingRegion.getPreviousHiddenRegion().isMultiline()) {
			document.prepend(closingRegion, formatter -> formatter.setNewLines(1));
		} else {
			document.prepend(closingRegion, IHiddenRegionFormatter::noSpace);
		}
	}

	/**
	 * Appends if there is another semantic region after {@code appendAfter}.
	 */
	private <T extends EObject> T conditionalAppend(T appendAfter, IFormattableDocument document,
			Consumer<? super IHiddenRegionFormatter> initializer) {
		var region = appendAfter == null ? null : textRegionExtensions.regionForEObject(appendAfter);
		if (region != null && region.getNextSemanticRegion() != null) {
			document.append(appendAfter, initializer::accept);
		}
		return appendAfter;
	}

	/**
	 * The process for formatting an annex is as follows: 1. Place the annex object
	 * into its own resource. This causes the annex text to effectively exist
	 * isolated and independent of the surrounding core text. 2. Inject the annex
	 * formatter and format the annex text. 3. Replace the annex text in the aadl
	 * file with the formatted annex text.
	 *
	 * The specifics of setting up the FormatterRequest for the annex formatter are
	 * different based upon how the core formatter was invoked. If the user invoked
	 * formatting on a text file, then the node model is available which is then
	 * used to setup the FormatterRequest. If formatting was invoked as a part of
	 * serialization, then the node model is not be available and the serializer is
	 * used to setup the FormatterRequest.
	 *
	 * We need to setup an XtextResource with the AnnexLibrary or AnnexSubclause as
	 * the root object. If the FormatterRequest is based on the node model, then the
	 * XtextResource also needs the IParseResult attached as well. This is necessary
	 * because the annex formatter takes a resource as a parameter and then it
	 * formats the AnnexLibrary or AnnexSubclause contained as a top level element
	 * of the resource.
	 *
	 * For figuring out how to invoke the formatter such that a String is returned,
	 * I looked at FormatterTestHelper to learn how to do that. The method of most
	 * interest is assertFormatted(FormatterTestRequest).
	 *
	 * It was not obvious how to replace an ISemanticRegion with a given String. It
	 * is not enough to simply call ISemanticRegion.replaceWith(String). This must
	 * be wrapped in an ITextReplacer which is then added to the document. See
	 * https://www.eclipse.org/forums/index.php/t/1093069/
	 *
	 * Since the annex object is placed into its resource, it is removed from its
	 * existing resource. The caller of this method is responsible for re-attaching
	 * the annex object to the DefaultAnnexLibrary or DefaultAnnexSubclause.
	 *
	 * @param annexObject
	 *            The AnnexLibrary or AnnexSubclause to format.
	 * @param sourceTextRegion
	 *            The ISemanticRegion for the sourceText assignment of the
	 *            DefaultAnnexLibrary or DefaultAnnexSubclause.
	 * @param indentationLevel
	 *            Indentation level of the DefaultAnnexLibrary or
	 *            DefaultAnnexSubclause. The closing "**}" is placed at
	 *            indentationLevel. All lines of the formatted annex text are placed
	 *            at indentationLevel + 1.
	 * @param document
	 *            The document passed to the format method.
	 */
	private void formatAnnexText(NamedElement annexObject, String annexName,
			ISemanticRegion sourceTextRegion, int indentationLevel, IFormattableDocument document) {
		if (annexObject != null && sourceTextRegion != null) {
			try {
				unsafeFormatAnnexText(annexObject, annexName, sourceTextRegion, indentationLevel, document);
			} catch (ConfigurationException | ProvisionException exception) {
				// The annex does not have a formatter.
			}
		}
	}

	private void unsafeFormatAnnexText(NamedElement annexObject, String annexName,
			ISemanticRegion sourceTextRegion, int indentationLevel, IFormattableDocument document) {
		if (getTextRegionAccess() instanceof NodeModelBasedRegionAccess) {
			formatAnnexTextFromNodeModel(annexObject, sourceTextRegion, indentationLevel, document);
		} else if (getTextRegionAccess() instanceof StringBasedRegionAccess) {
			formatAnnexTextFromSerializer(annexObject, annexName, sourceTextRegion, indentationLevel, document);
		}
	}

	/**
	 * Formatting was invoked on a text file, so the node model is available and is used to set up the annex
	 * formatter's request.
	 */
	private static void formatAnnexTextFromNodeModel(NamedElement annexObject, ISemanticRegion sourceTextRegion,
			int indentationLevel, IFormattableDocument document) {
		var annexParseResult = ParseResultHolder.Factory.INSTANCE.adapt(annexObject).getParseResult();
		if (annexParseResult == null) {
			return;
		}

		// Get the injector for the annex.
		var annexInjector = AnnexUtil.getInjector(annexParseResult);
		var annexFormatter = annexInjector == null ? null : annexInjector.getInstance(IFormatter2.class);
		if (annexFormatter == null) {
			return;
		}

		// Create resource and populate it with the library or subclause and the parse result.
		var fakeResource = setupAnnexResource(annexInjector, annexObject);
		fakeResource.setParseResult(annexParseResult);
		var request = annexInjector.getInstance(FormatterRequest.class);
		var accessBuilder = annexInjector.getProvider(TextRegionAccessBuilder.class).get();

		// Set up the formatting request based on the node model.
		request.setTextRegionAccess(accessBuilder.forNodeModel(fakeResource).create());

		// Format the annex text.
		invokeAnnexFormatter(annexFormatter, request, sourceTextRegion, indentationLevel, document);
	}

	/**
	 * Formatting was invoked as a part of serialization, so the node model is not available and the annex serializer is
	 * used to set up the annex formatter's request.
	 */
	private static void formatAnnexTextFromSerializer(NamedElement annexObject, String annexName,
			ISemanticRegion sourceTextRegion, int indentationLevel, IFormattableDocument document) {
		// Get the injector for the annex.
		var annexInjector = AnnexUtil.getInjector(annexName);
		var annexFormatter = annexInjector == null ? null : annexInjector.getInstance(IFormatter2.class);
		if (annexFormatter == null) {
			return;
		}
		try {
			// Create resource and populate it with the library or subclause.
			setupAnnexResource(annexInjector, annexObject);
			var request = annexInjector.getInstance(FormatterRequest.class);
			var serializer = (Serializer) annexInjector.getInstance(ISerializer.class);

			// Set up the formatting request with the serializer.
			request.setTextRegionAccess(serializer.serializeToRegions(annexObject));

			// Format the annex text.
			invokeAnnexFormatter(annexFormatter, request, sourceTextRegion, indentationLevel, document);
		} catch (NullPointerException exception) {
			// The annex serializer could not produce regions for this object.
		}
	}

	private static XtextResource setupAnnexResource(Injector annexInjector, NamedElement annexObject) {
		var resourceFactory = annexInjector.getInstance(IResourceFactory.class);
		var annexExtension = annexInjector.getInstance(FileExtensionProvider.class).getPrimaryFileExtension();
		var fakeURI = URI.createURI("__synthetic." + annexExtension);
		var fakeResource = (XtextResource) resourceFactory.createResource(fakeURI);
		performModification(annexObject, () -> fakeResource.getContents().add(annexObject));
		return fakeResource;
	}

	private static void invokeAnnexFormatter(IFormatter2 annexFormatter, FormatterRequest request,
			ISemanticRegion sourceTextRegion, int indentationLevel, IFormattableDocument document) {
		List<ITextReplacement> replacements = annexFormatter.format(request);
		String formatted = request.getTextRegionAccess().getRewriter().renderToString(replacements);
		document.addReplacer(new AbstractTextReplacer(document, sourceTextRegion) {
			@Override
			public ITextReplacerContext createReplacements(ITextReplacerContext context) {
				var annexIndentation = context.getIndentationString(indentationLevel + 1);
				var indented = formatted.replace("\n", "\n" + annexIndentation);
				var newText = "{**\n" + annexIndentation + indented;
				if (!newText.endsWith("\n")) {
					newText += "\n";
				}
				newText += context.getIndentationString(indentationLevel) + "**}";
				if (!Objects.equals(newText, sourceTextRegion.getText())) {
					context.addReplacement(getRegion().replaceWith(newText));
				}
				return context;
			}
		});
	}

	/**
	 * Runs the modification inside a recording command when the object belongs to a transactional editing domain, so
	 * that moving the annex object into its own resource does not violate the domain's write protocol.
	 */
	private static void performModification(EObject semanticObject, Runnable runnable) {
		var resource = semanticObject == null ? null : semanticObject.eResource();
		var resourceSet = resource == null ? null : resource.getResourceSet();
		var domain = resourceSet == null ? null
				: TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(resourceSet);
		if (domain == null) {
			runnable.run();
		} else {
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					runnable.run();
				}
			});
		}
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
			case AbstractImplementation abstractImplementation -> _format(abstractImplementation, document);
			case DataPort dataPort -> _format(dataPort, document);
			case EventDataPort eventDataPort -> _format(eventDataPort, document);
			case EventPort eventPort -> _format(eventPort, document);
			case SubprogramImplementation subprogramImplementation -> _format(subprogramImplementation, document);
			case ThreadImplementation threadImplementation -> _format(threadImplementation, document);
			case AadlInteger aadlInteger -> _format(aadlInteger, document);
			case AadlReal aadlReal -> _format(aadlReal, document);
			case AbstractFeature abstractFeature -> _format(abstractFeature, document);
			case AbstractPrototype abstractPrototype -> _format(abstractPrototype, document);
			case AbstractType abstractType -> _format(abstractType, document);
			case BusAccess busAccess -> _format(busAccess, document);
			case BusImplementation busImplementation -> _format(busImplementation, document);
			case BusPrototype busPrototype -> _format(busPrototype, document);
			case BusType busType -> _format(busType, document);
			case DataAccess dataAccess -> _format(dataAccess, document);
			case DataImplementation dataImplementation -> _format(dataImplementation, document);
			case DataPrototype dataPrototype -> _format(dataPrototype, document);
			case DataType dataType -> _format(dataType, document);
			case DeviceImplementation deviceImplementation -> _format(deviceImplementation, document);
			case DevicePrototype devicePrototype -> _format(devicePrototype, document);
			case DeviceType deviceType -> _format(deviceType, document);
			case FeatureGroup featureGroup -> _format(featureGroup, document);
			case MemoryImplementation memoryImplementation -> _format(memoryImplementation, document);
			case MemoryPrototype memoryPrototype -> _format(memoryPrototype, document);
			case MemoryType memoryType -> _format(memoryType, document);
			case Parameter parameter -> _format(parameter, document);
			case ProcessImplementation processImplementation -> _format(processImplementation, document);
			case ProcessPrototype processPrototype -> _format(processPrototype, document);
			case ProcessType processType -> _format(processType, document);
			case ProcessorImplementation processorImplementation -> _format(processorImplementation, document);
			case ProcessorPrototype processorPrototype -> _format(processorPrototype, document);
			case ProcessorType processorType -> _format(processorType, document);
			case SubprogramAccess subprogramAccess -> _format(subprogramAccess, document);
			case SubprogramGroupAccess subprogramGroupAccess -> _format(subprogramGroupAccess, document);
			case SubprogramGroupImplementation subprogramGroupImplementation ->
				_format(subprogramGroupImplementation, document);
			case SubprogramGroupPrototype subprogramGroupPrototype -> _format(subprogramGroupPrototype, document);
			case SubprogramGroupType subprogramGroupType -> _format(subprogramGroupType, document);
			case SubprogramPrototype subprogramPrototype -> _format(subprogramPrototype, document);
			case SubprogramType subprogramType -> _format(subprogramType, document);
			case SystemImplementation systemImplementation -> _format(systemImplementation, document);
			case SystemPrototype systemPrototype -> _format(systemPrototype, document);
			case SystemType systemType -> _format(systemType, document);
			case ThreadGroupImplementation threadGroupImplementation -> _format(threadGroupImplementation, document);
			case ThreadGroupPrototype threadGroupPrototype -> _format(threadGroupPrototype, document);
			case ThreadGroupType threadGroupType -> _format(threadGroupType, document);
			case ThreadPrototype threadPrototype -> _format(threadPrototype, document);
			case ThreadType threadType -> _format(threadType, document);
			case UnitsType unitsType -> _format(unitsType, document);
			case VirtualBusImplementation virtualBusImplementation -> _format(virtualBusImplementation, document);
			case VirtualBusPrototype virtualBusPrototype -> _format(virtualBusPrototype, document);
			case VirtualBusType virtualBusType -> _format(virtualBusType, document);
			case VirtualProcessorImplementation virtualProcessorImplementation ->
				_format(virtualProcessorImplementation, document);
			case VirtualProcessorPrototype virtualProcessorPrototype -> _format(virtualProcessorPrototype, document);
			case VirtualProcessorType virtualProcessorType -> _format(virtualProcessorType, document);
			case AadlBoolean aadlBoolean -> _format(aadlBoolean, document);
			case AadlString aadlString -> _format(aadlString, document);
			case AbstractSubcomponent abstractSubcomponent -> _format(abstractSubcomponent, document);
			case AccessConnection accessConnection -> _format(accessConnection, document);
			case BusSubcomponent busSubcomponent -> _format(busSubcomponent, document);
			case ClassifierType classifierType -> _format(classifierType, document);
			case DataSubcomponent dataSubcomponent -> _format(dataSubcomponent, document);
			case DeviceSubcomponent deviceSubcomponent -> _format(deviceSubcomponent, document);
			case EndToEndFlow endToEndFlow -> _format(endToEndFlow, document);
			case EnumerationType enumerationType -> _format(enumerationType, document);
			case EventDataSource eventDataSource -> _format(eventDataSource, document);
			case EventSource eventSource -> _format(eventSource, document);
			case FeatureConnection featureConnection -> _format(featureConnection, document);
			case FeatureGroupConnection featureGroupConnection -> _format(featureGroupConnection, document);
			case FeatureGroupPrototype featureGroupPrototype -> _format(featureGroupPrototype, document);
			case FeaturePrototype featurePrototype -> _format(featurePrototype, document);
			case FlowSpecification flowSpecification -> _format(flowSpecification, document);
			case MemorySubcomponent memorySubcomponent -> _format(memorySubcomponent, document);
			case ParameterConnection parameterConnection -> _format(parameterConnection, document);
			case PortConnection portConnection -> _format(portConnection, document);
			case PortProxy portProxy -> _format(portProxy, document);
			case ProcessSubcomponent processSubcomponent -> _format(processSubcomponent, document);
			case ProcessorSubcomponent processorSubcomponent -> _format(processorSubcomponent, document);
			case RangeType rangeType -> _format(rangeType, document);
			case RecordType recordType -> _format(recordType, document);
			case ReferenceType referenceType -> _format(referenceType, document);
			case SubprogramGroupSubcomponent subprogramGroupSubcomponent ->
				_format(subprogramGroupSubcomponent, document);
			case SubprogramProxy subprogramProxy -> _format(subprogramProxy, document);
			case SubprogramSubcomponent subprogramSubcomponent -> _format(subprogramSubcomponent, document);
			case SystemSubcomponent systemSubcomponent -> _format(systemSubcomponent, document);
			case ThreadGroupSubcomponent threadGroupSubcomponent -> _format(threadGroupSubcomponent, document);
			case ThreadSubcomponent threadSubcomponent -> _format(threadSubcomponent, document);
			case VirtualBusSubcomponent virtualBusSubcomponent -> _format(virtualBusSubcomponent, document);
			case VirtualProcessorSubcomponent virtualProcessorSubcomponent ->
				_format(virtualProcessorSubcomponent, document);
			case DefaultAnnexSubclause defaultAnnexSubclause -> _format(defaultAnnexSubclause, document);
			case FeatureGroupType featureGroupType -> _format(featureGroupType, document);
			case FlowImplementation flowImplementation -> _format(flowImplementation, document);
			case GroupExtension groupExtension -> _format(groupExtension, document);
			case ImplementationExtension implementationExtension -> _format(implementationExtension, document);
			case IntegerLiteral integerLiteral -> _format(integerLiteral, document);
			case ListType listType -> _format(listType, document);
			case Mode mode -> _format(mode, document);
			case ModeTransition modeTransition -> _format(modeTransition, document);
			case PrivatePackageSection privatePackageSection -> _format(privatePackageSection, document);
			case Property property -> _format(property, document);
			case PublicPackageSection publicPackageSection -> _format(publicPackageSection, document);
			case RealLiteral realLiteral -> _format(realLiteral, document);
			case SubprogramCall subprogramCall -> _format(subprogramCall, document);
			case SubprogramCallSequence subprogramCallSequence -> _format(subprogramCallSequence, document);
			case TypeExtension typeExtension -> _format(typeExtension, document);
			case AadlPackage aadlPackage -> _format(aadlPackage, document);
			case AccessSpecification accessSpecification -> _format(accessSpecification, document);
			case BasicProperty basicProperty -> _format(basicProperty, document);
			case ClassifierValue classifierValue -> _format(classifierValue, document);
			case ComputedValue computedValue -> _format(computedValue, document);
			case DefaultAnnexLibrary defaultAnnexLibrary -> _format(defaultAnnexLibrary, document);
			case FeatureGroupPrototypeActual featureGroupPrototypeActual ->
				_format(featureGroupPrototypeActual, document);
			case FeaturePrototypeReference featurePrototypeReference -> _format(featurePrototypeReference, document);
			case ModalPropertyValue modalPropertyValue -> _format(modalPropertyValue, document);
			case PortSpecification portSpecification -> _format(portSpecification, document);
			case PropertyConstant propertyConstant -> _format(propertyConstant, document);
			case PropertySet propertySet -> _format(propertySet, document);
			case RangeValue rangeValue -> _format(rangeValue, document);
			case RecordValue recordValue -> _format(recordValue, document);
			case ReferenceValue referenceValue -> _format(referenceValue, document);
			case UnitLiteral unitLiteral -> _format(unitLiteral, document);
			case ComponentPrototypeActual componentPrototypeActual -> _format(componentPrototypeActual, document);
			case ComponentPrototypeBinding componentPrototypeBinding -> _format(componentPrototypeBinding, document);
			case ComponentTypeRename componentTypeRename -> _format(componentTypeRename, document);
			case FeatureGroupPrototypeBinding featureGroupPrototypeBinding ->
				_format(featureGroupPrototypeBinding, document);
			case FeatureGroupTypeRename featureGroupTypeRename -> _format(featureGroupTypeRename, document);
			case FeaturePrototypeBinding featurePrototypeBinding -> _format(featurePrototypeBinding, document);
			case ListValue listValue -> _format(listValue, document);
			case MetaclassReference metaclassReference -> _format(metaclassReference, document);
			case Operation operation -> _format(operation, document);
			case PackageRename packageRename -> _format(packageRename, document);
			case XtextResource xtextResource -> _format(xtextResource, document);
			case ArrayDimension arrayDimension -> _format(arrayDimension, document);
			case ArrayRange arrayRange -> _format(arrayRange, document);
			case BasicPropertyAssociation basicPropertyAssociation -> _format(basicPropertyAssociation, document);
			case ComponentImplementationReference componentImplementationReference ->
				_format(componentImplementationReference, document);
			case ConnectedElement connectedElement -> _format(connectedElement, document);
			case ContainedNamedElement containedNamedElement -> _format(containedNamedElement, document);
			case ContainmentPathElement containmentPathElement -> _format(containmentPathElement, document);
			case EndToEndFlowSegment endToEndFlowSegment -> _format(endToEndFlowSegment, document);
			case FlowEnd flowEnd -> _format(flowEnd, document);
			case FlowSegment flowSegment -> _format(flowSegment, document);
			case ModeBinding modeBinding -> _format(modeBinding, document);
			case ModeTransitionTrigger modeTransitionTrigger -> _format(modeTransitionTrigger, document);
			case NumericRange numericRange -> _format(numericRange, document);
			case PropertyAssociation propertyAssociation -> _format(propertyAssociation, document);
			case EObject eObject -> _format(eObject, document);
			case null -> _format((Void) null, document);
			default -> _format(object, document);
		}
	}
}
