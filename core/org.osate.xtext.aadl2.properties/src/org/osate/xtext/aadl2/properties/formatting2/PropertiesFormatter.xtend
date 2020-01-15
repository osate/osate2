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
package org.osate.xtext.aadl2.properties.formatting2;

import com.google.inject.Inject
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.ITextReplacer
import org.eclipse.xtext.formatting2.internal.SinglelineCodeCommentReplacer
import org.eclipse.xtext.formatting2.internal.SinglelineDocCommentReplacer
import org.eclipse.xtext.formatting2.regionaccess.IComment
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch
import org.osate.aadl2.ArrayRange
import org.osate.aadl2.BasicPropertyAssociation
import org.osate.aadl2.ClassifierValue
import org.osate.aadl2.ComputedValue
import org.osate.aadl2.ContainmentPathElement
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.ListValue
import org.osate.aadl2.ModalPropertyValue
import org.osate.aadl2.Operation
import org.osate.aadl2.RangeValue
import org.osate.aadl2.RealLiteral
import org.osate.aadl2.RecordValue
import org.osate.aadl2.ReferenceValue
import org.osate.xtext.aadl2.properties.services.PropertiesGrammarAccess
import org.eclipse.xtext.formatting2.ITextReplacerContext

class PropertiesFormatter extends AbstractFormatter2 {
	@Inject extension PropertiesGrammarAccess
	
	override createCommentReplacer(IComment comment) {
		val grammarElement = comment.grammarElement
		if (grammarElement instanceof AbstractRule) {
			if (comment.lineRegions.head.indentation.length > 0) {
				return new SinglelineDocCommentReplacer(comment, "--") {
					override createReplacements(ITextReplacerContext context) {
						context
					}
				}
			} else {
				return new SinglelineCodeCommentReplacer(comment, "--")
			}
		}
		val elementName = new GrammarElementTitleSwitch().showQualified.showRule.doSwitch(grammarElement)
		throw new IllegalStateException("No " + ITextReplacer.simpleName + " configured for " + elementName)
	}
	
	def dispatch void format(ModalPropertyValue modalPropertyValue, extension IFormattableDocument document) {
		modalPropertyValue.ownedValue.format(document)
		
		//OptionalModalPropertyValue
		val leftParenthesis = modalPropertyValue.regionFor.keyword(optionalModalPropertyValueAccess.leftParenthesisKeyword_1_1)
		val rightParenthesis = modalPropertyValue.regionFor.keyword(optionalModalPropertyValueAccess.rightParenthesisKeyword_1_4)
		if (leftParenthesis !== null && rightParenthesis !== null) {
			modalPropertyValue.regionFor.keyword(inModesKeywordsAccess.inKeyword_0).surround[oneSpace]
			interior(leftParenthesis, rightParenthesis, [indent])
			leftParenthesis.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
			modalPropertyValue.regionFor.keywords(optionalModalPropertyValueAccess.commaKeyword_1_3_0).forEach[
				prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]
			]
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1]
			} else {
				rightParenthesis.prepend[noSpace]
			}
		}
	}
	
	def dispatch void format(ReferenceValue referenceValue, extension IFormattableDocument document) {
		referenceValue.regionFor.keyword(referenceTermAccess.leftParenthesisKeyword_1).prepend[oneSpace].append[noSpace]
		referenceValue.path.format(document)
		referenceValue.regionFor.keyword(referenceTermAccess.rightParenthesisKeyword_3).prepend[noSpace]
	}
	
	def dispatch void format(RecordValue recordValue, extension IFormattableDocument document) {
		val leftBracket = recordValue.regionFor.keyword(recordTermAccess.leftSquareBracketKeyword_0)
		val rightBracket = recordValue.regionFor.keyword(recordTermAccess.rightSquareBracketKeyword_2)
		interior(leftBracket, rightBracket, [indent])
		leftBracket.append[noSpace; setNewLines(0, 0, 1); autowrap]
		recordValue.ownedFieldValues.tail.forEach[prepend[oneSpace; setNewLines(0, 0, 1); autowrap]]
		recordValue.ownedFieldValues.forEach[it.format(document)]
		if (rightBracket !== null) {
			if (rightBracket.previousHiddenRegion.multiline) {
				rightBracket.prepend[newLines = 1]
			} else {
				rightBracket.prepend[noSpace]
			}
		}
	}
	
	def dispatch void format(ComputedValue computedValue, extension IFormattableDocument document) {
		computedValue.regionFor.keyword(computedTermAccess.leftParenthesisKeyword_1).prepend[oneSpace].append[noSpace]
		computedValue.regionFor.keyword(computedTermAccess.rightParenthesisKeyword_3).prepend[noSpace]
	}
	
	def dispatch void format(ClassifierValue classifierValue, extension IFormattableDocument document) {
		classifierValue.regionFor.keyword(componentClassifierTermAccess.leftParenthesisKeyword_1).prepend[oneSpace].append[noSpace]
		classifierValue.regionFor.keyword(componentClassifierTermAccess.rightParenthesisKeyword_3).prepend[noSpace]
	}
	
	def dispatch void format(ListValue listValue, extension IFormattableDocument document) {
		val leftParenthesis = listValue.regionFor.keyword(listTermAccess.leftParenthesisKeyword_1)
		if (listValue.ownedListElements.empty) {
			leftParenthesis.append[noSpace]
		} else {
			val rightParenthesis = listValue.regionFor.keyword(listTermAccess.rightParenthesisKeyword_3)
			interior(leftParenthesis, rightParenthesis, [indent])
			leftParenthesis.append[noSpace; setNewLines(0, 0, 1); autowrap]
			listValue.regionFor.keywords(listTermAccess.commaKeyword_2_1_0).forEach[
				prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]
			]
			listValue.ownedListElements.forEach[it.format(document)]
			if (rightParenthesis !== null) {
				if (rightParenthesis.previousHiddenRegion.multiline) {
					rightParenthesis.prepend[newLines = 1]
				} else {
					rightParenthesis.prepend[noSpace]
				}
			}
		}
	}
	
	def dispatch void format(BasicPropertyAssociation basicPropertyAssociation, extension IFormattableDocument document) {
		basicPropertyAssociation.regionFor.keyword(fieldPropertyAssociationAccess.equalsSignGreaterThanSignKeyword_1).surround[oneSpace]
		basicPropertyAssociation.ownedValue.format(document)
		basicPropertyAssociation.regionFor.keyword(fieldPropertyAssociationAccess.semicolonKeyword_3).prepend[noSpace]
	}
	
	def dispatch void format(ContainmentPathElement containmentPathElement, extension IFormattableDocument document) {
		//Array range
		containmentPathElement.arrayRanges.forEach[
			prepend[noSpace]
			it.format(document)
		]
		
		//Next element in path
		containmentPathElement.regionFor.keyword(containmentPathElementAccess.fullStopKeyword_1_0).surround[noSpace]
		containmentPathElement.path.format(document)
	}
	
	def dispatch void format(ArrayRange arrayRange, extension IFormattableDocument document) {
		arrayRange.regionFor.keyword(arrayRangeAccess.leftSquareBracketKeyword_1).append[noSpace]
		arrayRange.regionFor.keyword(arrayRangeAccess.fullStopFullStopKeyword_3_0).surround[oneSpace]
		arrayRange.regionFor.keyword(arrayRangeAccess.rightSquareBracketKeyword_4).prepend[noSpace]
	}
	
	def dispatch void format(Operation operation, extension IFormattableDocument document) {
		operation.regionFor.assignment(signedConstantAccess.opAssignment_0).append[noSpace]
	}
	
	def dispatch void format(IntegerLiteral integerLiteral, extension IFormattableDocument document) {
		val unitAssignment = integerLiteral.regionFor.assignment(integerTermAccess.unitAssignment_1)
		if (unitAssignment !== null && unitAssignment.text.length <= 2) {
			unitAssignment.prepend[noSpace]
		} else {
			unitAssignment.prepend[oneSpace]
		}
	}
	
	def dispatch void format(RealLiteral realLiteral, extension IFormattableDocument document) {
		val unitAssignment = realLiteral.regionFor.assignment(realTermAccess.unitAssignment_1)
		if (unitAssignment !== null && unitAssignment.text.length <= 2) {
			unitAssignment.prepend[noSpace]
		} else {
			unitAssignment.prepend[oneSpace]
		}
	}
	
	def dispatch void format(RangeValue rangeValue, extension IFormattableDocument document) {
		rangeValue.minimum.format(document)
		rangeValue.regionFor.keyword(numericRangeTermAccess.fullStopFullStopKeyword_1).surround[oneSpace]
		rangeValue.maximum.format(document)
		rangeValue.regionFor.keyword(numericRangeTermAccess.deltaKeyword_3_0).surround[oneSpace]
		rangeValue.delta.format(document)
	}
}