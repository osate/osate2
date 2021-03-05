/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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

import com.google.inject.ConfigurationException
import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.ProvisionException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.transaction.RecordingCommand
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.formatting2.FormatterRequest
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.IFormatter2
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter
import org.eclipse.xtext.formatting2.ITextReplacerContext
import org.eclipse.xtext.formatting2.internal.AbstractTextReplacer
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeModelBasedRegionAccess
import org.eclipse.xtext.formatting2.regionaccess.internal.StringBasedRegionAccess
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.IResourceFactory
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.serializer.impl.Serializer
import org.osate.aadl2.AadlBoolean
import org.osate.aadl2.AadlInteger
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AadlReal
import org.osate.aadl2.AadlString
import org.osate.aadl2.AbstractFeature
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.AbstractPrototype
import org.osate.aadl2.AbstractSubcomponent
import org.osate.aadl2.AbstractType
import org.osate.aadl2.AccessConnection
import org.osate.aadl2.AccessSpecification
import org.osate.aadl2.AnnexLibrary
import org.osate.aadl2.ArrayDimension
import org.osate.aadl2.BasicProperty
import org.osate.aadl2.BehavioredImplementation
import org.osate.aadl2.BusAccess
import org.osate.aadl2.BusImplementation
import org.osate.aadl2.BusPrototype
import org.osate.aadl2.BusSubcomponent
import org.osate.aadl2.BusType
import org.osate.aadl2.Classifier
import org.osate.aadl2.ClassifierType
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.ComponentImplementationReference
import org.osate.aadl2.ComponentPrototype
import org.osate.aadl2.ComponentPrototypeActual
import org.osate.aadl2.ComponentPrototypeBinding
import org.osate.aadl2.ComponentType
import org.osate.aadl2.ComponentTypeRename
import org.osate.aadl2.ConnectedElement
import org.osate.aadl2.Connection
import org.osate.aadl2.ContainedNamedElement
import org.osate.aadl2.DataAccess
import org.osate.aadl2.DataImplementation
import org.osate.aadl2.DataPort
import org.osate.aadl2.DataPrototype
import org.osate.aadl2.DataSubcomponent
import org.osate.aadl2.DataType
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.DeviceImplementation
import org.osate.aadl2.DevicePrototype
import org.osate.aadl2.DeviceSubcomponent
import org.osate.aadl2.DeviceType
import org.osate.aadl2.EndToEndFlow
import org.osate.aadl2.EndToEndFlowSegment
import org.osate.aadl2.EnumerationType
import org.osate.aadl2.EventDataPort
import org.osate.aadl2.EventDataSource
import org.osate.aadl2.EventPort
import org.osate.aadl2.EventSource
import org.osate.aadl2.FeatureConnection
import org.osate.aadl2.FeatureGroup
import org.osate.aadl2.FeatureGroupConnection
import org.osate.aadl2.FeatureGroupPrototype
import org.osate.aadl2.FeatureGroupPrototypeActual
import org.osate.aadl2.FeatureGroupPrototypeBinding
import org.osate.aadl2.FeatureGroupType
import org.osate.aadl2.FeatureGroupTypeRename
import org.osate.aadl2.FeaturePrototype
import org.osate.aadl2.FeaturePrototypeBinding
import org.osate.aadl2.FeaturePrototypeReference
import org.osate.aadl2.FlowEnd
import org.osate.aadl2.FlowImplementation
import org.osate.aadl2.FlowSegment
import org.osate.aadl2.FlowSpecification
import org.osate.aadl2.GroupExtension
import org.osate.aadl2.ImplementationExtension
import org.osate.aadl2.ListType
import org.osate.aadl2.MemoryImplementation
import org.osate.aadl2.MemoryPrototype
import org.osate.aadl2.MemorySubcomponent
import org.osate.aadl2.MemoryType
import org.osate.aadl2.MetaclassReference
import org.osate.aadl2.Mode
import org.osate.aadl2.ModeBinding
import org.osate.aadl2.ModeTransition
import org.osate.aadl2.ModeTransitionTrigger
import org.osate.aadl2.NamedElement
import org.osate.aadl2.NumericRange
import org.osate.aadl2.PackageRename
import org.osate.aadl2.PackageSection
import org.osate.aadl2.Parameter
import org.osate.aadl2.ParameterConnection
import org.osate.aadl2.PortConnection
import org.osate.aadl2.PortProxy
import org.osate.aadl2.PortSpecification
import org.osate.aadl2.PrivatePackageSection
import org.osate.aadl2.ProcessImplementation
import org.osate.aadl2.ProcessPrototype
import org.osate.aadl2.ProcessSubcomponent
import org.osate.aadl2.ProcessType
import org.osate.aadl2.ProcessorImplementation
import org.osate.aadl2.ProcessorPrototype
import org.osate.aadl2.ProcessorSubcomponent
import org.osate.aadl2.ProcessorType
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.PropertyConstant
import org.osate.aadl2.PropertySet
import org.osate.aadl2.PublicPackageSection
import org.osate.aadl2.RangeType
import org.osate.aadl2.RecordType
import org.osate.aadl2.ReferenceType
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.SubprogramAccess
import org.osate.aadl2.SubprogramCall
import org.osate.aadl2.SubprogramCallSequence
import org.osate.aadl2.SubprogramGroupAccess
import org.osate.aadl2.SubprogramGroupImplementation
import org.osate.aadl2.SubprogramGroupPrototype
import org.osate.aadl2.SubprogramGroupSubcomponent
import org.osate.aadl2.SubprogramGroupType
import org.osate.aadl2.SubprogramImplementation
import org.osate.aadl2.SubprogramPrototype
import org.osate.aadl2.SubprogramProxy
import org.osate.aadl2.SubprogramSubcomponent
import org.osate.aadl2.SubprogramType
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.SystemPrototype
import org.osate.aadl2.SystemSubcomponent
import org.osate.aadl2.SystemType
import org.osate.aadl2.ThreadGroupImplementation
import org.osate.aadl2.ThreadGroupPrototype
import org.osate.aadl2.ThreadGroupSubcomponent
import org.osate.aadl2.ThreadGroupType
import org.osate.aadl2.ThreadImplementation
import org.osate.aadl2.ThreadPrototype
import org.osate.aadl2.ThreadSubcomponent
import org.osate.aadl2.ThreadType
import org.osate.aadl2.TypeExtension
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.UnitsType
import org.osate.aadl2.VirtualBusImplementation
import org.osate.aadl2.VirtualBusPrototype
import org.osate.aadl2.VirtualBusSubcomponent
import org.osate.aadl2.VirtualBusType
import org.osate.aadl2.VirtualProcessorImplementation
import org.osate.aadl2.VirtualProcessorPrototype
import org.osate.aadl2.VirtualProcessorSubcomponent
import org.osate.aadl2.VirtualProcessorType
import org.osate.annexsupport.AnnexUtil
import org.osate.annexsupport.ParseResultHolder
import org.osate.xtext.aadl2.properties.formatting2.PropertiesFormatter
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess

/**
 * @since 5.0
 */
@SuppressWarnings("all")
class Aadl2Formatter extends PropertiesFormatter {
	@Inject extension Aadl2GrammarAccess
	
	def dispatch void format(PropertySet propertySet, extension IFormattableDocument document) {
		propertySet.surround[noSpace]
		
		//Declaration line
		propertySet.regionFor.keyword(propertySetAccess.setKeyword_1).surround[oneSpace]
		val isKeyword = propertySet.regionFor.keyword(propertySetAccess.isKeyword_3)
		isKeyword.prepend[oneSpace].append[setNewLines(1, 1, 2)]
		val endKeyword = propertySet.regionFor.keyword(propertySetAccess.endKeyword_7)
		interior(isKeyword, endKeyword, [indent])
		
		//With statements
		val withSemicolons = propertySet.regionFor.keywords(propertySetAccess.semicolonKeyword_4_3)
		if (!withSemicolons.empty) {
			propertySet.regionFor.keywords(propertySetAccess.withKeyword_4_0).forEach[append[oneSpace]]
			propertySet.regionFor.keywords(propertySetAccess.commaKeyword_4_2_0).forEach[prepend[noSpace].append[oneSpace]]
			withSemicolons.take(withSemicolons.size - 1).forEach[prepend[noSpace].append[newLines = 1]]
			val newLineCount = if (propertySet.ownedPropertyTypes.empty &&
				propertySet.ownedProperties.empty &&
				propertySet.ownedPropertyConstants.empty &&
				propertySet.ownedAnnexSubclauses.empty
			) {
				1
			} else {
				2
			}
			withSemicolons.last.prepend[noSpace].append[newLines = newLineCount]
		}
		
		//Contents
		propertySet.ownedPropertyTypes.forEach[it.format(document)]
		propertySet.ownedProperties.forEach[it.format(document)]
		propertySet.ownedPropertyConstants.forEach[it.format(document)]
		propertySet.ownedAnnexSubclauses.forEach[it.format(document)]
		
		//End line
		endKeyword.append[oneSpace]
		propertySet.regionFor.keyword(propertySetAccess.semicolonKeyword_9).prepend[noSpace]
	}
	
	def dispatch void format(AadlBoolean aadlBoolean, extension IFormattableDocument document) {
		if (aadlBoolean.name !== null) {
			aadlBoolean.conditionalAppend(document, [setNewLines(1, 1, 2)])
			aadlBoolean.regionFor.keyword(booleanTypeAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
			aadlBoolean.regionFor.keyword(booleanTypeAccess.aadlbooleanKeyword_3).prepend[oneSpace].append[noSpace]
		}
	}
	
	def dispatch void format(AadlString aadlString, extension IFormattableDocument document) {
		if (aadlString.name !== null) {
			aadlString.conditionalAppend(document, [setNewLines(1, 1, 2)])
			aadlString.regionFor.keyword(stringTypeAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
			aadlString.regionFor.keyword(stringTypeAccess.aadlstringKeyword_3).prepend[oneSpace].append[noSpace]
		}
	}
	
	def dispatch void format(EnumerationType enumerationType, extension IFormattableDocument document) {
		if (enumerationType.name === null) {
			enumerationType.regionFor.keyword(unnamedEnumerationTypeAccess.enumerationKeyword_0).append[oneSpace]
			formatEnumerationTypeCommon(document, enumerationType.regionFor.keyword(unnamedEnumerationTypeAccess.leftParenthesisKeyword_1),
				enumerationType.regionFor.keyword(unnamedEnumerationTypeAccess.rightParenthesisKeyword_4),
				enumerationType.regionFor.keywords(unnamedEnumerationTypeAccess.commaKeyword_3_0)
			)
		} else {
			enumerationType.conditionalAppend(document, [setNewLines(1, 1, 2)])
			enumerationType.regionFor.keyword(enumerationTypeAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
			enumerationType.regionFor.keyword(enumerationTypeAccess.enumerationKeyword_3).surround[oneSpace]
			formatEnumerationTypeCommon(document, enumerationType.regionFor.keyword(enumerationTypeAccess.leftParenthesisKeyword_4),
				enumerationType.regionFor.keyword(enumerationTypeAccess.rightParenthesisKeyword_7),
				enumerationType.regionFor.keywords(enumerationTypeAccess.commaKeyword_6_0)
			)
			enumerationType.regionFor.keyword(propertyTypeAccess.semicolonKeyword_1).prepend[noSpace]
		}
	}
	
	def private formatEnumerationTypeCommon(extension IFormattableDocument document, ISemanticRegion leftParenthesis, ISemanticRegion rightParenthesis, Iterable<ISemanticRegion> commas) {
		interior(leftParenthesis, rightParenthesis, [indent])
		leftParenthesis.append[noSpace; setNewLines(0, 0, 1); autowrap]
		commas.forEach[prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]]
		if (rightParenthesis !== null) {
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1]
			} else {
				rightParenthesis.prepend[noSpace]
			}
		}
	}
	
	def dispatch void format(UnitsType unitsType, extension IFormattableDocument document) {
		if (unitsType.name === null) {
			unitsType.regionFor.keyword(unnamedUnitsTypeAccess.unitsKeyword_0).append[oneSpace]
			formatUnitsTypeCommon(unitsType, document, unitsType.regionFor.keyword(unnamedUnitsTypeAccess.leftParenthesisKeyword_1),
				unitsType.regionFor.keyword(unnamedUnitsTypeAccess.rightParenthesisKeyword_4), unitsType.regionFor.keywords(unnamedUnitsTypeAccess.commaKeyword_3_0)
			)
		} else {
			unitsType.conditionalAppend(document, [setNewLines(1, 1, 2)])
			unitsType.regionFor.keyword(unitsTypeAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
			unitsType.regionFor.keyword(unitsTypeAccess.unitsKeyword_3).surround[oneSpace]
			formatUnitsTypeCommon(unitsType, document, unitsType.regionFor.keyword(unitsTypeAccess.leftParenthesisKeyword_4),
				unitsType.regionFor.keyword(unitsTypeAccess.rightParenthesisKeyword_7), unitsType.regionFor.keywords(unitsTypeAccess.commaKeyword_6_0)
			)
			unitsType.regionFor.keyword(propertyTypeAccess.semicolonKeyword_1).prepend[noSpace]
		}
	}
	
	def private formatUnitsTypeCommon(UnitsType unitsType, extension IFormattableDocument document, ISemanticRegion leftParenthesis, ISemanticRegion rightParenthesis, Iterable<ISemanticRegion> commas) {
		interior(leftParenthesis, rightParenthesis, [indent])
		leftParenthesis.append[noSpace; setNewLines(0, 0, 1); autowrap]
		unitsType.ownedLiterals.forEach[it.format(document)]
		commas.forEach[prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]]
		if (rightParenthesis !== null) {
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1]
			} else {
				rightParenthesis.prepend[noSpace]
			}
		}
	}
	
	def dispatch void format(UnitLiteral unitLiteral, extension IFormattableDocument document) {
		unitLiteral.regionFor.keyword(unitLiteralConversionAccess.equalsSignGreaterThanSignKeyword_1).surround[oneSpace]
		unitLiteral.regionFor.ruleCall(unitLiteralConversionAccess.STARParserRuleCall_3).surround[oneSpace]
	}
	
	def dispatch void format(AadlReal aadlReal, extension IFormattableDocument document) {
		if (aadlReal.name === null) {
			formatAadlRealCommon(aadlReal, document, aadlReal.regionFor.keyword(unnamedRealTypeAccess.unitsKeyword_3_1_0))
		} else {
			aadlReal.conditionalAppend(document, [setNewLines(1, 1, 2)])
			aadlReal.regionFor.keyword(realTypeAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
			aadlReal.regionFor.keyword(realTypeAccess.aadlrealKeyword_3).prepend[oneSpace]
			
			formatAadlRealCommon(aadlReal, document, aadlReal.regionFor.keyword(realTypeAccess.unitsKeyword_5_1_0))
			
			aadlReal.regionFor.keyword(propertyTypeAccess.semicolonKeyword_1).prepend[noSpace]
		}
	}
	
	def private formatAadlRealCommon(AadlReal aadlReal, extension IFormattableDocument document, ISemanticRegion unitsKeyword) {
		//Range
		aadlReal.range.prepend[oneSpace]
		aadlReal.range.format(document)
		
		//Owned units
		aadlReal.ownedUnitsType.prepend[oneSpace]
		aadlReal.ownedUnitsType.format(document)
		
		//Referenced units
		unitsKeyword.surround[oneSpace]
	}
	
	def dispatch void format(NumericRange numericRange, extension IFormattableDocument document) {
		numericRange.lowerBound.format(document)
		numericRange.regionFor.keyword(integerRangeAccess.fullStopFullStopKeyword_1).surround[oneSpace]
		numericRange.regionFor.keyword(realRangeAccess.fullStopFullStopKeyword_1).surround[oneSpace]
		numericRange.upperBound.format(document)
	}
	
	def dispatch void format(AadlInteger aadlInteger, extension IFormattableDocument document) {
		if (aadlInteger.name === null) {
			formatAadlIntegerCommon(aadlInteger, document, aadlInteger.regionFor.keyword(unnamedIntegerTypeAccess.unitsKeyword_3_1_0))
		} else {
			aadlInteger.conditionalAppend(document, [setNewLines(1, 1, 2)])
			aadlInteger.regionFor.keyword(integerTypeAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
			aadlInteger.regionFor.keyword(integerTypeAccess.aadlintegerKeyword_3).prepend[oneSpace]
			
			formatAadlIntegerCommon(aadlInteger, document, aadlInteger.regionFor.keyword(integerTypeAccess.unitsKeyword_5_1_0))
			
			aadlInteger.regionFor.keyword(propertyTypeAccess.semicolonKeyword_1).prepend[noSpace]
		}
	}
	
	def private formatAadlIntegerCommon(AadlInteger aadlInteger, extension IFormattableDocument document, ISemanticRegion unitsKeyword) {
		//Range
		aadlInteger.range.prepend[oneSpace]
		aadlInteger.range.format(document)
		
		//Owned Units
		aadlInteger.ownedUnitsType.prepend[oneSpace]
		aadlInteger.ownedUnitsType.format(document)
		
		//Referenced units
		unitsKeyword.surround[oneSpace]
	}
	
	def dispatch void format(RangeType rangeType, extension IFormattableDocument document) {
		if (rangeType.name === null) {
			rangeType.regionFor.keyword(rangeOfKeywordsAccess.rangeKeyword_0).append[oneSpace]
			
			formatRangeTypeCommon(rangeType, document, rangeType.regionFor.assignment(unnamedRangeTypeAccess.referencedNumberTypeAssignment_2_1))
		} else {
			rangeType.conditionalAppend(document, [setNewLines(1, 1, 2)])
			rangeType.regionFor.keyword(rangeTypeAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
			rangeType.regionFor.keyword(rangeOfKeywordsAccess.rangeKeyword_0).surround[oneSpace]
			
			formatRangeTypeCommon(rangeType, document, rangeType.regionFor.assignment(rangeTypeAccess.referencedNumberTypeAssignment_4_1))
			
			rangeType.regionFor.keyword(propertyTypeAccess.semicolonKeyword_1).prepend[noSpace]
		}
	}
	
	def private formatRangeTypeCommon(RangeType rangeType, extension IFormattableDocument document, ISemanticRegion referencedNumberType) {
		//Owned number type
		rangeType.ownedNumberType.prepend[oneSpace]
		rangeType.ownedNumberType.format(document)
		
		//Referenced number type
		referencedNumberType.prepend[oneSpace]
	}
	
	def dispatch void format(ClassifierType classifierType, extension IFormattableDocument document) {
		if (classifierType.name === null) {
			formatClassifierTypeCommon(classifierType, document, classifierType.regionFor.keyword(unnamedClassifierTypeAccess.leftParenthesisKeyword_2_0),
				classifierType.regionFor.keyword(unnamedClassifierTypeAccess.rightParenthesisKeyword_2_3),
				classifierType.regionFor.keywords(unnamedClassifierTypeAccess.commaKeyword_2_2_0)
			)
		} else {
			classifierType.conditionalAppend(document, [setNewLines(1, 1, 2)])
			classifierType.regionFor.keyword(classifierTypeAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
			classifierType.regionFor.keyword(classifierTypeAccess.classifierKeyword_3).prepend[oneSpace]
			
			formatClassifierTypeCommon(classifierType, document, classifierType.regionFor.keyword(classifierTypeAccess.leftParenthesisKeyword_4_0),
				classifierType.regionFor.keyword(classifierTypeAccess.rightParenthesisKeyword_4_3),
				classifierType.regionFor.keywords(classifierTypeAccess.commaKeyword_4_2_0)
			)
			
			classifierType.regionFor.keyword(propertyTypeAccess.semicolonKeyword_1).prepend[noSpace]
		}
	}
	
	def private formatClassifierTypeCommon(ClassifierType classifierType, extension IFormattableDocument document, ISemanticRegion leftParenthesis,
		ISemanticRegion rightParenthesis, Iterable<ISemanticRegion> commas
	) {
		if (leftParenthesis !== null && rightParenthesis !== null) {
			interior(leftParenthesis, rightParenthesis, [indent])
			leftParenthesis.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
			commas.forEach[prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]]
			classifierType.classifierReferences.forEach[it.format(document)]
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1]
			} else {
				rightParenthesis.prepend[noSpace]
			}
		}
	}
	
	def dispatch void format(MetaclassReference metaclassReference, extension IFormattableDocument document) {
		//Annex prefix
		metaclassReference.regionFor.assignment(QMReferenceAccess.annexNameAssignment_0_1).surround[noSpace]
		metaclassReference.regionFor.ruleCall(QMReferenceAccess.STARParserRuleCall_0_3).surround[noSpace]
		metaclassReference.regionFor.ruleCall(QMReferenceAccess.STARParserRuleCall_0_4).append[noSpace]
		
		//Names
		metaclassReference.regionFor.assignments(QMReferenceAccess.metaclassNameAssignment_1).tail.forEach[prepend[oneSpace]]
	}
	
	def dispatch void format(ReferenceType referenceType, extension IFormattableDocument document) {
		if (referenceType.name === null) {
			formatReferenceTypeCommon(referenceType, document, referenceType.regionFor.keyword(unnamedReferenceTypeAccess.leftParenthesisKeyword_2_0),
				referenceType.regionFor.keyword(unnamedReferenceTypeAccess.rightParenthesisKeyword_2_3),
				referenceType.regionFor.keywords(unnamedReferenceTypeAccess.commaKeyword_2_2_0)
			)
		} else {
			referenceType.conditionalAppend(document, [setNewLines(1, 1, 2)])
			referenceType.regionFor.keyword(referenceTypeAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
			referenceType.regionFor.keyword(referenceTypeAccess.referenceKeyword_3).prepend[oneSpace]
			
			formatReferenceTypeCommon(referenceType, document, referenceType.regionFor.keyword(referenceTypeAccess.leftParenthesisKeyword_4_0),
				referenceType.regionFor.keyword(referenceTypeAccess.rightParenthesisKeyword_4_3),
				referenceType.regionFor.keywords(referenceTypeAccess.commaKeyword_4_2_0)
			)
			
			referenceType.regionFor.keyword(propertyTypeAccess.semicolonKeyword_1).prepend[noSpace]
		}
	}
	
	def private formatReferenceTypeCommon(ReferenceType referenceType, extension IFormattableDocument document,
		ISemanticRegion leftParenthesis, ISemanticRegion rightParenthesis, Iterable<ISemanticRegion> commas
	) {
		if (leftParenthesis !== null && rightParenthesis !== null) {
			interior(leftParenthesis, rightParenthesis, [indent])
			leftParenthesis.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
			commas.forEach[prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]]
			referenceType.namedElementReferences.forEach[it.format(document)]
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1]
			} else {
				rightParenthesis.prepend[noSpace]
			}
		}
	}
	
	def dispatch void format(RecordType recordType, extension IFormattableDocument document) {
		if (recordType.name === null) {
			formatRecordTypeCommon(recordType, document, recordType.regionFor.keyword(unnamedRecordTypeAccess.leftParenthesisKeyword_1),
				recordType.regionFor.keyword(unnamedRecordTypeAccess.rightParenthesisKeyword_3)
			)
		} else {
			recordType.conditionalAppend(document, [setNewLines(1, 1, 2)])
			recordType.regionFor.keyword(recordTypeAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
			recordType.regionFor.keyword(recordTypeAccess.typeKeyword_2).append[oneSpace]
			formatRecordTypeCommon(recordType, document, recordType.regionFor.keyword(recordTypeAccess.leftParenthesisKeyword_4),
				recordType.regionFor.keyword(recordTypeAccess.rightParenthesisKeyword_6)
			)
			recordType.regionFor.keyword(propertyTypeAccess.semicolonKeyword_1).prepend[noSpace]
		}
	}
	
	def private formatRecordTypeCommon(RecordType recordType, extension IFormattableDocument document, ISemanticRegion leftParenthesis, ISemanticRegion rightParenthesis) {
		interior(leftParenthesis, rightParenthesis, [indent])
		leftParenthesis.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
		recordType.ownedFields.tail.forEach[prepend[oneSpace; setNewLines(0, 0, 1); autowrap]]
		recordType.ownedFields.forEach[it.format(document)]
		if (rightParenthesis !== null) {
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1]
			} else {
				rightParenthesis.prepend[noSpace]
			}
		}
	}
	
	def dispatch void format(BasicProperty basicProperty, extension IFormattableDocument document) {
		basicProperty.regionFor.keyword(recordFieldAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		basicProperty.ownedPropertyType.format(document)
		basicProperty.regionFor.keyword(recordFieldAccess.semicolonKeyword_3).prepend[noSpace]
	}
	
	def dispatch void format(ListType listType, extension IFormattableDocument document) {
		listType.regionFor.keyword(listOfKeywordsAccess.ofKeyword_1).surround[oneSpace]
		listType.ownedElementType.format(document)
	}
	
	def dispatch void format(PropertyConstant propertyConstant, extension IFormattableDocument document) {
		propertyConstant.conditionalAppend(document, [setNewLines(1, 1, 2)])
		propertyConstant.regionFor.keyword(propertyConstantAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		propertyConstant.regionFor.keyword(propertyConstantAccess.constantKeyword_2).append[oneSpace]
		
		//Owned property type
		propertyConstant.ownedPropertyType.format(document)
		
		propertyConstant.regionFor.keyword(propertyConstantAccess.equalsSignGreaterThanSignKeyword_4).surround[oneSpace]
		
		//Constant value
		propertyConstant.constantValue.format(document)
		
		propertyConstant.regionFor.keyword(propertyConstantAccess.semicolonKeyword_6).prepend[noSpace]
	}
	
	def dispatch void format(Property property, extension IFormattableDocument document) {
		property.conditionalAppend(document, [setNewLines(1, 1, 2)])
		property.regionFor.keyword(propertyDefinitionAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		property.regionFor.keyword(propertyDefinitionAccess.inheritInheritKeyword_2_0).append[oneSpace]
		
		//Owned property type
		property.ownedPropertyType.format(document)
		
		//Default value
		property.regionFor.keyword(propertyDefinitionAccess.equalsSignGreaterThanSignKeyword_4_0).surround[oneSpace]
		property.defaultValue.format(document)
		
		//Applies to
		property.regionFor.keyword(appliesToKeywordsAccess.appliesKeyword_0).surround[oneSpace]
		val leftParenthesis = property.regionFor.keyword(propertyDefinitionAccess.leftParenthesisKeyword_6)
		val rightParenthesis = property.regionFor.keyword(propertyDefinitionAccess.rightParenthesisKeyword_8)
		interior(leftParenthesis, rightParenthesis, [indent])
		leftParenthesis.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
		property.regionFor.keywords(propertyDefinitionAccess.commaKeyword_7_0_1_0).forEach[
			prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]
		]
		property.appliesTos.forEach[it.format(document)]
		if (rightParenthesis !== null) {
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1].append[noSpace]
			} else {
				rightParenthesis.surround[noSpace]
			}
		}
	}
	
	def dispatch void format(AadlPackage aadlPackage, extension IFormattableDocument document) {
		aadlPackage.surround[noSpace]
		
		//Declaration line
		aadlPackage.regionFor.assignment(aadlPackageAccess.nameAssignment_1).prepend[oneSpace].append[setNewLines(1, 1, 2)]
		
		//Sections
		aadlPackage.ownedPublicSection.format(document)
		aadlPackage.ownedPrivateSection.format(document)
		
		//Properties
		val propertiesKeyword = aadlPackage.regionFor.keyword(aadlPackageAccess.propertiesKeyword_3_0)
		propertiesKeyword.append[setNewLines(1, 1, 2)]
		val endKeyword = aadlPackage.regionFor.keyword(aadlPackageAccess.endKeyword_4)
		interior(propertiesKeyword, endKeyword, [indent])
		aadlPackage.ownedPropertyAssociations.forEach[
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]
		aadlPackage.regionFor.keyword(aadlPackageAccess.semicolonKeyword_3_1_1_1).prepend[noSpace].append[setNewLines(1, 1, 2)]
		
		//End line
		endKeyword.append[oneSpace]
		aadlPackage.regionFor.keyword(aadlPackageAccess.semicolonKeyword_6).prepend[noSpace]
	}
	
	def dispatch void format(PropertyAssociation propertyAssociation, extension IFormattableDocument document) {
		//Prefix
		propertyAssociation.regionFor.keyword("=>").surround[oneSpace]
		propertyAssociation.regionFor.keyword("+=>").surround[oneSpace]
		propertyAssociation.regionFor.keyword("constant").append[oneSpace]
		
		//Values
		propertyAssociation.ownedValues.forEach[it.format(document)]
		propertyAssociation.regionFor.keywords(",").forEach[prepend[noSpace].append[oneSpace]]
		
		//Applies to
		propertyAssociation.regionFor.keyword(appliesToKeywordsAccess.appliesKeyword_0).surround[oneSpace]
		propertyAssociation.regionFor.keyword(appliesToKeywordsAccess.toKeyword_1).append[oneSpace]
		propertyAssociation.appliesTos.forEach[it.format(document)]
		
		//In binding
		propertyAssociation.regionFor.keyword("in").surround[oneSpace]
		propertyAssociation.regionFor.keyword("(").prepend[oneSpace].append[noSpace]
		propertyAssociation.regionFor.keyword(")").prepend[noSpace]
		
		propertyAssociation.regionFor.keyword(";").prepend[noSpace]
	}
	
	def dispatch void format(PublicPackageSection publicPackageSection, extension IFormattableDocument document) {
		formatPackageSectionCommon(publicPackageSection, document,
			publicPackageSection.regionFor.keyword(publicPackageSectionAccess.publicKeyword_1),
			publicPackageSection.regionFor.keywords(publicPackageSectionAccess.withKeyword_2_0_0),
			publicPackageSection.regionFor.keywords(publicPackageSectionAccess.commaKeyword_2_0_2_0),
			publicPackageSection.regionFor.keywords(publicPackageSectionAccess.semicolonKeyword_2_0_3)
		)
	}
	
	def dispatch void format(PrivatePackageSection privatePackageSection, extension IFormattableDocument document) {
		formatPackageSectionCommon(privatePackageSection, document,
			privatePackageSection.regionFor.keyword(privatePackageSectionAccess.privateKeyword_1),
			privatePackageSection.regionFor.keywords(privatePackageSectionAccess.withKeyword_2_0_0),
			privatePackageSection.regionFor.keywords(privatePackageSectionAccess.commaKeyword_2_0_2_0),
			privatePackageSection.regionFor.keywords(privatePackageSectionAccess.semicolonKeyword_2_0_3)
		)
	}
	
	def private formatPackageSectionCommon(PackageSection packageSection, extension IFormattableDocument document,
		ISemanticRegion visibilityKeyword, Iterable<ISemanticRegion> withs, Iterable<ISemanticRegion> commas, Iterable<ISemanticRegion> semicolons
	) {
		if (!packageSection.eContents.empty || !packageSection.importedUnits.empty) {
			packageSection.interior[indent]
		}
		
		//Visibility label
		visibilityKeyword.append[setNewLines(1, 1, 2)]
		
		//With statements
		withs.forEach[append[oneSpace]]
		commas.forEach[prepend[noSpace].append[oneSpace]]
		semicolons.forEach[
			val newLineCount = switch nextElement : nextSemanticRegion?.semanticElement {
				Classifier,
				AnnexLibrary,
				PackageSection case nextElement != packageSection: 2
				default: 1
			}
			prepend[noSpace].append[newLines = newLineCount]
		]
		
		//Renames
		packageSection.ownedPackageRenames.forEach[it.format(document)]
		packageSection.ownedFeatureGroupTypeRenames.forEach[it.format(document)]
		packageSection.ownedComponentTypeRenames.forEach[it.format(document)]
		
		//Contents
		packageSection.ownedClassifiers.forEach[it.format(document)]
		packageSection.ownedAnnexLibraries.forEach[it.format(document)]
	}
	
	def dispatch void format(PackageRename packageRename, extension IFormattableDocument document) {
		val newLineCount = switch packageRename.regionForEObject?.nextSemanticRegion?.semanticElement {
			Classifier,
			AnnexLibrary,
			PackageSection: 2
			default: 1
		}
		packageRename.conditionalAppend(document, [newLines = newLineCount])
		
		//PackageRename parser rule
		packageRename.regionFor.keyword(packageRenameAccess.renamesKeyword_1).surround[oneSpace]
		packageRename.regionFor.keyword(packageRenameAccess.packageKeyword_2).append[oneSpace]
		packageRename.regionFor.keyword(packageRenameAccess.colonColonKeyword_4_0).surround[noSpace]
		packageRename.regionFor.keyword(packageRenameAccess.semicolonKeyword_5).prepend[noSpace]
		
		//RenameAll parser rule
		packageRename.regionFor.keyword(renameAllAccess.renamesKeyword_0).append[oneSpace]
		packageRename.regionFor.keyword(renameAllAccess.colonColonKeyword_2).surround[noSpace]
		packageRename.regionFor.keyword(renameAllAccess.semicolonKeyword_4).prepend[noSpace]
	}
	
	def dispatch void format(FeatureGroupTypeRename featureGroupTypeRename, extension IFormattableDocument document) {
		val newLineCount = switch featureGroupTypeRename.regionForEObject?.nextSemanticRegion?.semanticElement {
			Classifier,
			AnnexLibrary,
			PackageSection: 2
			default: 1
		}
		featureGroupTypeRename.conditionalAppend(document, [newLines = newLineCount])
		featureGroupTypeRename.regionFor.assignment(FGTRenameAccess.nameAssignment_0).append[oneSpace]
		featureGroupTypeRename.regionFor.keyword(featureGroupKeywordsAccess.featureKeyword_0).surround[oneSpace]
		featureGroupTypeRename.regionFor.keyword(featureGroupKeywordsAccess.groupKeyword_1).append[oneSpace]
		featureGroupTypeRename.regionFor.keyword(FGTRenameAccess.semicolonKeyword_4).prepend[noSpace]
	}
	
	def dispatch void format(ComponentTypeRename componentTypeRename, extension IFormattableDocument document) {
		val newLineCount = switch componentTypeRename.regionForEObject?.nextSemanticRegion?.semanticElement {
			Classifier,
			AnnexLibrary,
			PackageSection: 2
			default: 1
		}
		componentTypeRename.conditionalAppend(document, [newLines = newLineCount])
		componentTypeRename.regionFor.assignment(CTRenameAccess.nameAssignment_0).append[oneSpace]
		componentTypeRename.regionFor.assignment(CTRenameAccess.categoryAssignment_2).surround[oneSpace]
		componentTypeRename.regionFor.keyword(CTRenameAccess.semicolonKeyword_4).prepend[noSpace]
	}
	
	def dispatch void format(DefaultAnnexLibrary defaultAnnexLibrary, extension IFormattableDocument document) {
		val newLineCount = switch defaultAnnexLibrary.regionForEObject?.nextSemanticRegion?.semanticElement {
			Classifier,
			AnnexLibrary,
			PackageSection: 2
			default: 1
		}
		defaultAnnexLibrary.conditionalAppend(document, [setNewLines(newLineCount, newLineCount, 2)])
		defaultAnnexLibrary.regionFor.assignment(defaultAnnexLibraryAccess.nameAssignment_1).surround[oneSpace]
		
		val parsedLibrary = defaultAnnexLibrary.parsedAnnexLibrary
		val sourceTextRegion = defaultAnnexLibrary.regionFor.assignment(defaultAnnexLibraryAccess.sourceTextAssignment_2)
		formatAnnexText(parsedLibrary, defaultAnnexLibrary.name, sourceTextRegion, 1, document)
		performModification(defaultAnnexLibrary, [defaultAnnexLibrary.parsedAnnexLibrary = parsedLibrary])
		
		defaultAnnexLibrary.regionFor.keyword(defaultAnnexLibraryAccess.semicolonKeyword_3).prepend[noSpace]
	}
	
	def dispatch void format(AbstractType abstractType, extension IFormattableDocument document) {
		abstractType.regionFor.keyword(abstractTypeAccess.abstractKeyword_0).append[oneSpace]
		formatComponentTypeCommon(abstractType, document, abstractType.regionFor.assignment(abstractTypeAccess.nameAssignment_1))
	}
	
	def dispatch void format(SystemType systemType, extension IFormattableDocument document) {
		systemType.regionFor.keyword(systemTypeAccess.systemKeyword_0).append[oneSpace]
		formatComponentTypeCommon(systemType, document, systemType.regionFor.assignment(systemTypeAccess.nameAssignment_1))
	}
	
	def dispatch void format(ProcessType processType, extension IFormattableDocument document) {
		processType.regionFor.keyword(processTypeAccess.processKeyword_0).append[oneSpace]
		formatComponentTypeCommon(processType, document, processType.regionFor.assignment(processTypeAccess.nameAssignment_1))
	}
	
	def dispatch void format(ThreadGroupType threadGroupType, extension IFormattableDocument document) {
		threadGroupType.regionFor.keyword(threadGroupKeywordsAccess.groupKeyword_1).surround[oneSpace]
		formatComponentTypeCommon(threadGroupType, document, threadGroupType.regionFor.assignment(threadGroupTypeAccess.nameAssignment_1))
	}
	
	def dispatch void format(ThreadType threadType, extension IFormattableDocument document) {
		threadType.regionFor.keyword(threadTypeAccess.threadKeyword_0).append[oneSpace]
		formatComponentTypeCommon(threadType, document, threadType.regionFor.assignment(threadTypeAccess.nameAssignment_1))
	}
	
	def dispatch void format(SubprogramType subprogramType, extension IFormattableDocument document) {
		subprogramType.regionFor.keyword(subprogramTypeAccess.subprogramKeyword_0).append[oneSpace]
		formatComponentTypeCommon(subprogramType, document, subprogramType.regionFor.assignment(subprogramTypeAccess.nameAssignment_1))
	}
	
	def dispatch void format(SubprogramGroupType subprogramGroupType, extension IFormattableDocument document) {
		subprogramGroupType.regionFor.keyword(subprogramGroupKeywordsAccess.groupKeyword_1).surround[oneSpace]
		formatComponentTypeCommon(subprogramGroupType, document,
			subprogramGroupType.regionFor.assignment(subprogramGroupTypeAccess.nameAssignment_1)
		)
	}
	
	def dispatch void format(ProcessorType processorType, extension IFormattableDocument document) {
		processorType.regionFor.keyword(processorTypeAccess.processorKeyword_0).append[oneSpace]
		formatComponentTypeCommon(processorType, document, processorType.regionFor.assignment(processorTypeAccess.nameAssignment_1))
	}
	
	def dispatch void format(DeviceType deviceType, extension IFormattableDocument document) {
		deviceType.regionFor.keyword(deviceTypeAccess.deviceKeyword_0).append[oneSpace]
		formatComponentTypeCommon(deviceType, document, deviceType.regionFor.assignment(deviceTypeAccess.nameAssignment_1))
	}
	
	def dispatch void format(MemoryType memoryType, extension IFormattableDocument document) {
		memoryType.regionFor.keyword(memoryTypeAccess.memoryKeyword_0).append[oneSpace]
		formatComponentTypeCommon(memoryType, document, memoryType.regionFor.assignment(memoryTypeAccess.nameAssignment_1))
	}
	
	def dispatch void format(BusType busType, extension IFormattableDocument document) {
		busType.regionFor.keyword(busTypeAccess.busKeyword_0).append[oneSpace]
		formatComponentTypeCommon(busType, document, busType.regionFor.assignment(busTypeAccess.nameAssignment_1))
	}
	
	def dispatch void format(VirtualBusType virtualBusType, extension IFormattableDocument document) {
		virtualBusType.regionFor.keyword(virtualBusKeywordsAccess.busKeyword_1).surround[oneSpace]
		formatComponentTypeCommon(virtualBusType, document, virtualBusType.regionFor.assignment(virtualBusTypeAccess.nameAssignment_1))
	}
	
	def dispatch void format(VirtualProcessorType virtualProcessorType, extension IFormattableDocument document) {
		virtualProcessorType.regionFor.keyword(virtualProcessorKeywordsAccess.processorKeyword_1).surround[oneSpace]
		formatComponentTypeCommon(virtualProcessorType, document,
			virtualProcessorType.regionFor.assignment(virtualProcessorTypeAccess.nameAssignment_1)
		)
	}
	
	def dispatch void format(DataType dataType, extension IFormattableDocument document) {
		dataType.regionFor.keyword(dataTypeAccess.dataKeyword_0).append[oneSpace]
		formatComponentTypeCommon(dataType, document, dataType.regionFor.assignment(dataTypeAccess.nameAssignment_1))
	}
	
	def private formatComponentTypeCommon(ComponentType componentType, extension IFormattableDocument document,
		ISemanticRegion nameAssignment
	) {
		val newLineCount = switch componentType.regionForEObject?.nextSemanticRegion?.semanticElement {
			Classifier,
			AnnexLibrary,
			PackageSection: 2
			default: 1
		}
		componentType.conditionalAppend(document, [setNewLines(newLineCount, newLineCount, 2)])
		
		val endKeyword = componentType.regionFor.keyword("end")
		
		//Declaration line
		if (componentType.ownedExtension === null) {
			nameAssignment.append[setNewLines(1, 1, 2)]
			interior(nameAssignment, endKeyword, [indent])
		} else {
			nameAssignment.append[oneSpace]
			componentType.ownedExtension.format(document)
			if (componentType.ownedPrototypeBindings.empty) {
				componentType.ownedExtension.append[setNewLines(1, 1, 2)]
				interior(componentType.ownedExtension.allSemanticRegions.last, endKeyword, [indent])
			} else {
				val leftParenthesis = componentType.regionFor.keyword("(")
				val rightParenthesis = componentType.regionFor.keyword(")")
				interior(leftParenthesis, rightParenthesis, [indent])
				leftParenthesis.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
				componentType.regionFor.keywords(",").forEach[prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]]
				componentType.ownedPrototypeBindings.forEach[it.format(document)]
				if (rightParenthesis !== null) {
					if (rightParenthesis.previousHiddenRegion.multiline) {
						rightParenthesis.prepend[newLines = 1].append[setNewLines(1, 1, 2)]
					} else {
						rightParenthesis.prepend[noSpace].append[setNewLines(1, 1, 2)]
					}
					interior(rightParenthesis, endKeyword, [indent])
				}
			}
		}
		
		//Section headings
		val prototypesKeyword = componentType.regionFor.keyword("prototypes")
		val featuresKeyword = componentType.regionFor.keyword("features")
		val flowsKeyword = componentType.regionFor.keyword("flows")
		val requiresKeyword = componentType.regionFor.keyword("requires")
		val modesKeyword = componentType.regionFor.keyword("modes")
		val propertiesKeyword = componentType.regionFor.keyword("properties")
		val annexRegion = componentType.ownedAnnexSubclauses.head.semanticRegions.head
		
		if (prototypesKeyword !== null) {
			prototypesKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = featuresKeyword ?: flowsKeyword ?: requiresKeyword ?: modesKeyword ?: propertiesKeyword ?:
				annexRegion ?: endKeyword
			interior(prototypesKeyword, endMarker, [indent])
		}
		if (featuresKeyword !== null) {
			featuresKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = flowsKeyword ?: requiresKeyword ?: modesKeyword ?: propertiesKeyword ?: annexRegion ?:
				endKeyword
			interior(featuresKeyword, endMarker, [indent])
		}
		if (flowsKeyword !== null) {
			flowsKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = requiresKeyword ?: modesKeyword ?: propertiesKeyword ?: annexRegion ?: endKeyword
			interior(flowsKeyword, endMarker, [indent])
		}
		if (modesKeyword !== null) {
			modesKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = propertiesKeyword ?: annexRegion ?: endKeyword
			interior(modesKeyword, endMarker, [indent])
		}
		if (propertiesKeyword !== null) {
			propertiesKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = annexRegion ?: endKeyword
			interior(propertiesKeyword, endMarker, [indent])
		}
		requiresKeyword.append[oneSpace]
		
		//None keywords
		componentType.regionFor.keywords("none").forEach[append[noSpace]]
		
		//Semicolons after none keywords
		val semicolons = componentType.regionFor.keywords(";")
		if (semicolons.size > 1) {
			semicolons.take(semicolons.size - 1).forEach[append[setNewLines(1, 1, 2)]]
		}
		
		//Contents
		(componentType.ownedPrototypes +
			componentType.ownedFeatures +
			componentType.ownedFlowSpecifications +
			componentType.ownedModes +
			componentType.ownedModeTransitions +
			componentType.ownedAnnexSubclauses
		).forEach[it.format(document)]
		
		//Properties
		componentType.ownedPropertyAssociations.forEach[
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]
		
		//End line
		endKeyword.append[oneSpace]
		semicolons.last.prepend[noSpace]
	}
	
	def dispatch void format(TypeExtension typeExtension, extension IFormattableDocument document) {
		typeExtension.regionFor.keyword(typeExtensionAccess.extendsKeyword_0).append[oneSpace]
	}
	
	def dispatch void format(FeatureGroupPrototypeBinding featureGroupPrototypeBinding, extension IFormattableDocument document) {
		featureGroupPrototypeBinding.regionFor.keyword(featureGroupPrototypeBindingAccess.equalsSignGreaterThanSignKeyword_1).surround[oneSpace]
		featureGroupPrototypeBinding.regionFor.keyword(featureGroupKeywordsAccess.groupKeyword_1).surround[oneSpace]
		featureGroupPrototypeBinding.actual.format(document)
	}
	
	def dispatch void format(FeatureGroupPrototypeActual featureGroupPrototypeActual, extension IFormattableDocument document) {
		val leftParenthesis = featureGroupPrototypeActual.regionFor.keyword(featureGroupPrototypeActualAccess.leftParenthesisKeyword_1_0)
		val rightParenthesis = featureGroupPrototypeActual.regionFor.keyword(featureGroupPrototypeActualAccess.rightParenthesisKeyword_1_3)
		if (leftParenthesis !== null && rightParenthesis !== null) {
			interior(leftParenthesis, rightParenthesis, [indent])
			leftParenthesis.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
			featureGroupPrototypeActual.regionFor.keywords(featureGroupPrototypeActualAccess.commaKeyword_1_2_0).forEach[
				prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]
			]
			featureGroupPrototypeActual.bindings.forEach[it.format(document)]
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1]
			} else {
				rightParenthesis.prepend[noSpace]
			}
		}
	}
	
	def dispatch void format(FeaturePrototypeBinding featurePrototypeBinding, extension IFormattableDocument document) {
		featurePrototypeBinding.regionFor.keyword(featurePrototypeBindingAccess.equalsSignGreaterThanSignKeyword_1).surround[oneSpace]
		featurePrototypeBinding.actual.format(document)
	}
	
	def dispatch void format(PortSpecification portSpecification, extension IFormattableDocument document) {
		portSpecification.regionFor.keyword(portSpecificationAccess.inInKeyword_0_0_0_0).append[oneSpace]
		portSpecification.regionFor.keyword(portSpecificationAccess.outOutKeyword_0_0_1_0).append[oneSpace]
		portSpecification.regionFor.keyword(portSpecificationAccess.outOutKeyword_0_1_0).append[oneSpace]
		portSpecification.regionFor.keyword(portSpecificationAccess.portKeyword_2).prepend[oneSpace]
		portSpecification.regionFor.assignment(portSpecificationAccess.classifierAssignment_3).prepend[oneSpace]
	}
	
	def dispatch void format(AccessSpecification accessSpecification, extension IFormattableDocument document) {
		accessSpecification.regionFor.assignment(accessSpecificationAccess.categoryAssignment_1).surround[oneSpace]
		accessSpecification.regionFor.assignment(accessSpecificationAccess.classifierAssignment_3).prepend[oneSpace]
	}
	
	def dispatch void format(FeaturePrototypeReference featurePrototypeReference, extension IFormattableDocument document) {
		featurePrototypeReference.regionFor.keyword(featurePrototypeReferenceAccess.inInKeyword_0_0_0).append[oneSpace]
		featurePrototypeReference.regionFor.keyword(featurePrototypeReferenceAccess.outOutKeyword_0_1_0).append[oneSpace]
		featurePrototypeReference.regionFor.keyword(featurePrototypeReferenceAccess.featureKeyword_1).append[oneSpace]
	}
	
	def dispatch void format(ComponentPrototypeBinding componentPrototypeBinding, extension IFormattableDocument document) {
		componentPrototypeBinding.regionFor.keyword(componentPrototypeBindingAccess.equalsSignGreaterThanSignKeyword_1).surround[oneSpace]
		componentPrototypeBinding.actuals.forEach[it.format(document)]
		val leftParenthesis = componentPrototypeBinding.regionFor.keyword(componentPrototypeBindingAccess.leftParenthesisKeyword_2_1_0)
		val rightParenthesis = componentPrototypeBinding.regionFor.keyword(componentPrototypeBindingAccess.rightParenthesisKeyword_2_1_3)
		if (leftParenthesis !== null && rightParenthesis !== null) {
			interior(leftParenthesis, rightParenthesis, [indent])
			leftParenthesis.append[noSpace; setNewLines(0, 0, 1); autowrap]
			componentPrototypeBinding.regionFor.keywords(componentPrototypeBindingAccess.commaKeyword_2_1_2_0).forEach[
				prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]
			]
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1]
			} else {
				rightParenthesis.prepend[noSpace]
			}
		}
	}
	
	def dispatch void format(ComponentPrototypeActual componentPrototypeActual, extension IFormattableDocument document) {
		componentPrototypeActual.regionFor.assignment(componentReferenceAccess.categoryAssignment_0).append[oneSpace]
		val leftParenthesis = componentPrototypeActual.regionFor.keyword(componentReferenceAccess.leftParenthesisKeyword_2_0)
		val rightParenthesis = componentPrototypeActual.regionFor.keyword(componentReferenceAccess.rightParenthesisKeyword_2_3)
		if (leftParenthesis !== null && rightParenthesis !== null) {
			interior(leftParenthesis, rightParenthesis, [indent])
			leftParenthesis.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
			componentPrototypeActual.regionFor.keywords(componentReferenceAccess.commaKeyword_2_2_0).forEach[
				prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]
			]
			componentPrototypeActual.bindings.forEach[it.format(document)]
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1]
			} else {
				rightParenthesis.prepend[noSpace]
			}
		}
	}
	
	def dispatch void format(DataPort dataPort, extension IFormattableDocument document) {
		dataPort.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		//Named
		dataPort.regionFor.keyword(dataPortAccess.colonKeyword_1_0_1).prepend[noSpace].append[oneSpace]
		
		//Refined
		dataPort.regionFor.keyword(dataPortAccess.colonKeyword_1_1_1).prepend[noSpace].append[oneSpace]
		dataPort.regionFor.keyword(refinedToKeywordsAccess.toKeyword_1).surround[oneSpace]
		
		//Direction
		dataPort.regionFor.keyword(dataPortAccess.inInKeyword_2_0_0_0).append[oneSpace]
		dataPort.regionFor.keyword(dataPortAccess.outOutKeyword_2_0_1_0).append[oneSpace]
		dataPort.regionFor.keyword(dataPortAccess.outOutKeyword_2_1_0).append[oneSpace]
		
		dataPort.regionFor.keyword(dataPortKeywordsAccess.dataKeyword_0).append[oneSpace]
		dataPort.regionFor.assignment(dataPortAccess.dataFeatureClassifierAssignment_4).prepend[oneSpace]
		dataPort.arrayDimensions.forEach[
			prepend[noSpace]
			it.format(document)
		]
		
		formatCurlyProperties(dataPort, document, dataPort.regionFor.keyword(dataPortAccess.leftCurlyBracketKeyword_6_0),
			dataPort.regionFor.keyword(dataPortAccess.rightCurlyBracketKeyword_6_2)
		)
		dataPort.regionFor.keyword(dataPortAccess.semicolonKeyword_7).prepend[noSpace]
	}
	
	def dispatch void format(ArrayDimension arrayDimension, extension IFormattableDocument document) {
		arrayDimension.regionFor.keyword(arrayDimensionAccess.leftSquareBracketKeyword_1).append[noSpace]
		arrayDimension.size.format(document)
		arrayDimension.regionFor.keyword(arrayDimensionAccess.rightSquareBracketKeyword_3).prepend[noSpace]
	}
	
	def dispatch void format(EventDataPort eventDataPort, extension IFormattableDocument document) {
		eventDataPort.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		//Named
		eventDataPort.regionFor.keyword(eventDataPortAccess.colonKeyword_1_0_1).prepend[noSpace].append[oneSpace]
		
		//Refined
		eventDataPort.regionFor.keyword(eventDataPortAccess.colonKeyword_1_1_1).prepend[noSpace].append[oneSpace]
		eventDataPort.regionFor.keyword(refinedToKeywordsAccess.toKeyword_1).surround[oneSpace]
		
		//Direction
		eventDataPort.regionFor.keyword(eventDataPortAccess.inInKeyword_2_0_0_0).append[oneSpace]
		eventDataPort.regionFor.keyword(eventDataPortAccess.outOutKeyword_2_0_1_0).append[oneSpace]
		eventDataPort.regionFor.keyword(eventDataPortAccess.outOutKeyword_2_1_0).append[oneSpace]
		
		eventDataPort.regionFor.keyword(eventDataPortKeywordsAccess.dataKeyword_1).surround[oneSpace]
		eventDataPort.regionFor.assignment(eventDataPortAccess.dataFeatureClassifierAssignment_4).prepend[oneSpace]
		eventDataPort.arrayDimensions.forEach[
			prepend[noSpace]
			it.format(document)
		]
		
		formatCurlyProperties(eventDataPort, document, eventDataPort.regionFor.keyword(eventDataPortAccess.leftCurlyBracketKeyword_6_0),
			eventDataPort.regionFor.keyword(eventDataPortAccess.rightCurlyBracketKeyword_6_2)
		)
		eventDataPort.regionFor.keyword(eventDataPortAccess.semicolonKeyword_7).prepend[noSpace]
	}
	
	def dispatch void format(EventPort eventPort, extension IFormattableDocument document) {
		eventPort.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		//Named
		eventPort.regionFor.keyword(eventPortAccess.colonKeyword_1_0_1).prepend[noSpace].append[oneSpace]
		
		//Refined
		eventPort.regionFor.keyword(eventPortAccess.colonKeyword_1_1_1).prepend[noSpace].append[oneSpace]
		eventPort.regionFor.keyword(refinedToKeywordsAccess.toKeyword_1).surround[oneSpace]
		
		//Direction
		eventPort.regionFor.keyword(eventPortAccess.inInKeyword_2_0_0_0).append[oneSpace]
		eventPort.regionFor.keyword(eventPortAccess.outOutKeyword_2_0_1_0).append[oneSpace]
		eventPort.regionFor.keyword(eventPortAccess.outOutKeyword_2_1_0).append[oneSpace]
		
		eventPort.regionFor.keyword(eventPortKeywordsAccess.eventKeyword_0).append[oneSpace]
		eventPort.arrayDimensions.forEach[
			prepend[noSpace]
			it.format(document)
		]
		
		formatCurlyProperties(eventPort, document, eventPort.regionFor.keyword(eventPortAccess.leftCurlyBracketKeyword_5_0),
			eventPort.regionFor.keyword(eventPortAccess.rightCurlyBracketKeyword_5_2)
		)
		eventPort.regionFor.keyword(eventPortAccess.semicolonKeyword_6).prepend[noSpace]
	}
	
	def dispatch void format(FeatureGroup featureGroup, extension IFormattableDocument document) {
		featureGroup.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		//Named
		featureGroup.regionFor.keyword(featureGroupAccess.colonKeyword_0_0_1).prepend[noSpace].append[oneSpace]
		
		//Refined
		featureGroup.regionFor.keyword(featureGroupAccess.colonKeyword_0_1_1).prepend[noSpace].append[oneSpace]
		featureGroup.regionFor.keyword(refinedToKeywordsAccess.toKeyword_1).surround[oneSpace]
		
		//Direction
		featureGroup.regionFor.keyword(featureGroupAccess.inInKeyword_1_0_0).append[oneSpace]
		featureGroup.regionFor.keyword(featureGroupAccess.outOutKeyword_1_1_0).append[oneSpace]
		
		featureGroup.regionFor.keyword(featureGroupKeywordsAccess.featureKeyword_0).append[oneSpace]
		featureGroup.regionFor.keyword(inverseOfKeywordsAccess.inverseKeyword_0).surround[oneSpace]
		featureGroup.regionFor.assignment(featureGroupAccess.featureTypeAssignment_3_1).prepend[oneSpace]
		featureGroup.arrayDimensions.forEach[
			prepend[noSpace]
			it.format(document)
		]
		
		formatCurlyProperties(featureGroup, document, featureGroup.regionFor.keyword(featureGroupAccess.leftCurlyBracketKeyword_5_0),
			featureGroup.regionFor.keyword(featureGroupAccess.rightCurlyBracketKeyword_5_2)
		)
		featureGroup.regionFor.keyword(featureGroupAccess.semicolonKeyword_6).prepend[noSpace]
	}
	
	def dispatch void format(ContainedNamedElement containedNamedElement, extension IFormattableDocument document) {
		containedNamedElement.path.format(document)
	}
	
	def dispatch void format(Parameter parameter, extension IFormattableDocument document) {
		parameter.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		//Named
		parameter.regionFor.keyword(parameterAccess.colonKeyword_0_0_1).prepend[noSpace].append[oneSpace]
		
		//Refined
		parameter.regionFor.keyword(parameterAccess.colonKeyword_0_1_1).prepend[noSpace].append[oneSpace]
		parameter.regionFor.keyword(refinedToKeywordsAccess.toKeyword_1).surround[oneSpace]
		
		//Direction
		parameter.regionFor.keyword(parameterAccess.inInKeyword_1_0_0_0).append[oneSpace]
		parameter.regionFor.keyword(parameterAccess.outOutKeyword_1_0_1_0).append[oneSpace]
		parameter.regionFor.keyword(parameterAccess.outOutKeyword_1_1_0).append[oneSpace]
		
		parameter.regionFor.assignment(parameterAccess.dataFeatureClassifierAssignment_3).prepend[oneSpace]
		parameter.arrayDimensions.forEach[
			prepend[noSpace]
			it.format(document)
		]
		
		formatCurlyProperties(parameter, document, parameter.regionFor.keyword(parameterAccess.leftCurlyBracketKeyword_5_0),
			parameter.regionFor.keyword(parameterAccess.rightCurlyBracketKeyword_5_2)
		)
		parameter.regionFor.keyword(parameterAccess.semicolonKeyword_6).prepend[noSpace]
	}
	
	def dispatch void format(SubprogramAccess subprogramAccess, extension IFormattableDocument document) {
		subprogramAccess.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		//Named
		subprogramAccess.regionFor.keyword(subprogramAccessAccess.colonKeyword_0_0_1).prepend[noSpace].append[oneSpace]
		
		//Refined
		subprogramAccess.regionFor.keyword(subprogramAccessAccess.colonKeyword_0_1_1).prepend[noSpace].append[oneSpace]
		subprogramAccess.regionFor.keyword(refinedToKeywordsAccess.toKeyword_1).surround[oneSpace]
		
		subprogramAccess.regionFor.keyword(subprogramAccessKeywordsAccess.subprogramKeyword_0).surround[oneSpace]
		subprogramAccess.regionFor.assignment(subprogramAccessAccess.subprogramFeatureClassifierAssignment_3).prepend[oneSpace]
		subprogramAccess.arrayDimensions.forEach[
			prepend[noSpace]
			it.format(document)
		]
		
		formatCurlyProperties(subprogramAccess, document, subprogramAccess.regionFor.keyword(subprogramAccessAccess.leftCurlyBracketKeyword_5_0),
			subprogramAccess.regionFor.keyword(subprogramAccessAccess.rightCurlyBracketKeyword_5_2)
		)
		subprogramAccess.regionFor.keyword(subprogramAccessAccess.semicolonKeyword_6).prepend[noSpace]
	}
	
	def dispatch void format(SubprogramGroupAccess subprogramGroupAccess, extension IFormattableDocument document) {
		subprogramGroupAccess.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		//Named
		subprogramGroupAccess.regionFor.keyword(subprogramGroupAccessAccess.colonKeyword_0_0_1).prepend[noSpace].append[oneSpace]
		
		//Refined
		subprogramGroupAccess.regionFor.keyword(subprogramGroupAccessAccess.colonKeyword_0_1_1).prepend[noSpace].append[oneSpace]
		subprogramGroupAccess.regionFor.keyword(refinedToKeywordsAccess.toKeyword_1).surround[oneSpace]
		
		subprogramGroupAccess.regionFor.keyword(subprogramGroupAccessKeywordsAccess.subprogramKeyword_0).surround[oneSpace]
		subprogramGroupAccess.regionFor.keyword(subprogramGroupAccessKeywordsAccess.groupKeyword_1).append[oneSpace]
		subprogramGroupAccess.regionFor.assignment(subprogramGroupAccessAccess.subprogramGroupFeatureClassifierAssignment_3).prepend[oneSpace]
		subprogramGroupAccess.arrayDimensions.forEach[
			prepend[noSpace]
			it.format(document)
		]
		
		formatCurlyProperties(subprogramGroupAccess, document,
			subprogramGroupAccess.regionFor.keyword(subprogramGroupAccessAccess.leftCurlyBracketKeyword_5_0),
			subprogramGroupAccess.regionFor.keyword(subprogramGroupAccessAccess.rightCurlyBracketKeyword_5_2)
		)
		subprogramGroupAccess.regionFor.keyword(subprogramGroupAccessAccess.semicolonKeyword_6).prepend[noSpace]
	}
	
	def dispatch void format(BusAccess busAccess, extension IFormattableDocument document) {
		busAccess.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		//Named
		busAccess.regionFor.keyword(busAccessAccess.colonKeyword_0_0_1).prepend[noSpace].append[oneSpace]
		
		//Refined
		busAccess.regionFor.keyword(busAccessAccess.colonKeyword_0_1_1).prepend[noSpace].append[oneSpace]
		busAccess.regionFor.keyword(refinedToKeywordsAccess.toKeyword_1).surround[oneSpace]
		
		busAccess.regionFor.keyword(busAccessAccess.virtualVirtualKeyword_2_0).prepend[oneSpace]
		busAccess.regionFor.keyword(busAccessKeywordsAccess.busKeyword_0).surround[oneSpace]
		busAccess.regionFor.assignment(busAccessAccess.busFeatureClassifierAssignment_4).prepend[oneSpace]
		busAccess.arrayDimensions.forEach[
			prepend[noSpace]
			it.format(document)
		]
		
		formatCurlyProperties(busAccess, document, busAccess.regionFor.keyword(busAccessAccess.leftCurlyBracketKeyword_6_0),
			busAccess.regionFor.keyword(busAccessAccess.rightCurlyBracketKeyword_6_2)
		)
		busAccess.regionFor.keyword(busAccessAccess.semicolonKeyword_7).prepend[noSpace]
	}
	
	def dispatch void format(DataAccess dataAccess, extension IFormattableDocument document) {
		dataAccess.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		//Named
		dataAccess.regionFor.keyword(dataAccessAccess.colonKeyword_0_0_1).prepend[noSpace].append[oneSpace]
		
		//Refined
		dataAccess.regionFor.keyword(dataAccessAccess.colonKeyword_0_1_1).prepend[noSpace].append[oneSpace]
		dataAccess.regionFor.keyword(refinedToKeywordsAccess.toKeyword_1).surround[oneSpace]
		
		dataAccess.regionFor.keyword(dataAccessKeywordsAccess.dataKeyword_0).surround[oneSpace]
		dataAccess.regionFor.assignment(dataAccessAccess.dataFeatureClassifierAssignment_3).prepend[oneSpace]
		dataAccess.arrayDimensions.forEach[
			prepend[noSpace]
			it.format(document)
		]
		
		formatCurlyProperties(dataAccess, document, dataAccess.regionFor.keyword(dataAccessAccess.leftCurlyBracketKeyword_5_0),
			dataAccess.regionFor.keyword(dataAccessAccess.rightCurlyBracketKeyword_5_2)
		)
		dataAccess.regionFor.keyword(dataAccessAccess.semicolonKeyword_6).prepend[noSpace]
	}
	
	def dispatch void format(AbstractFeature abstractFeature, extension IFormattableDocument document) {
		abstractFeature.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		//Named
		abstractFeature.regionFor.keyword(abstractFeatureAccess.colonKeyword_0_0_1).prepend[noSpace].append[oneSpace]
		
		//Refined
		abstractFeature.regionFor.keyword(abstractFeatureAccess.colonKeyword_0_1_1).prepend[noSpace].append[oneSpace]
		abstractFeature.regionFor.keyword(refinedToKeywordsAccess.toKeyword_1).surround[oneSpace]
		
		//Direction
		abstractFeature.regionFor.keyword(abstractFeatureAccess.inInKeyword_1_0_0).append[oneSpace]
		abstractFeature.regionFor.keyword(abstractFeatureAccess.outOutKeyword_1_1_0).append[oneSpace]
		
		abstractFeature.regionFor.assignment(abstractFeatureAccess.featurePrototypeAssignment_2_0_1).prepend[oneSpace]
		abstractFeature.regionFor.assignment(abstractFeatureAccess.abstractFeatureClassifierAssignment_2_1_1).prepend[oneSpace]
		abstractFeature.arrayDimensions.forEach[
			prepend[noSpace]
			it.format(document)
		]
		
		formatCurlyProperties(abstractFeature, document, abstractFeature.regionFor.keyword(abstractFeatureAccess.leftCurlyBracketKeyword_4_0),
			abstractFeature.regionFor.keyword(abstractFeatureAccess.rightCurlyBracketKeyword_4_2)
		)
		abstractFeature.regionFor.keyword(abstractFeatureAccess.semicolonKeyword_5).prepend[noSpace]
	}
	
	def dispatch void format(Mode mode, extension IFormattableDocument document) {
		mode.conditionalAppend(document, [setNewLines(1, 1, 2)])
		mode.regionFor.keyword(modeAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		mode.regionFor.keyword(modeAccess.initialInitialKeyword_2_0).append[oneSpace]
		formatCurlyProperties(mode, document, mode.regionFor.keyword(modeAccess.leftCurlyBracketKeyword_4_0),
			mode.regionFor.keyword(modeAccess.rightCurlyBracketKeyword_4_2)
		)
		mode.regionFor.keyword(modeAccess.semicolonKeyword_5).prepend[noSpace]
	}
	
	def dispatch void format(ModeTransition modeTransition, extension IFormattableDocument document) {
		modeTransition.conditionalAppend(document, [setNewLines(1, 1, 2)])
		modeTransition.regionFor.keyword(modeTransitionAccess.colonKeyword_0_1).prepend[noSpace].append[oneSpace]
		
		//Triggers
		val leftMarker = modeTransition.regionFor.keyword(modeTransitionAccess.hyphenMinusLeftSquareBracketKeyword_2)
		val rightMarker = modeTransition.regionFor.keyword(modeTransitionAccess.rightSquareBracketHyphenMinusGreaterThanSignKeyword_5)
		interior(leftMarker, rightMarker, [indent])
		leftMarker.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
		modeTransition.ownedTriggers.forEach[it.format(document)]
		modeTransition.regionFor.keywords(modeTransitionAccess.commaKeyword_4_0).forEach[
			prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]
		]
		
		val previousHidden = rightMarker?.previousHiddenRegion
		if (previousHidden !== null && previousHidden.multiline) {
			rightMarker.prepend[newLines = 1].append[oneSpace]
		} else {
			rightMarker.prepend[noSpace].append[oneSpace]
		}
		
		formatCurlyProperties(modeTransition, document, modeTransition.regionFor.keyword(modeTransitionAccess.leftCurlyBracketKeyword_7_0),
			modeTransition.regionFor.keyword(modeTransitionAccess.rightCurlyBracketKeyword_7_2)
		)
		modeTransition.regionFor.keyword(modeTransitionAccess.semicolonKeyword_8).prepend[noSpace]
	}
	
	def private formatCurlyProperties(NamedElement namedElement, extension IFormattableDocument document, ISemanticRegion leftCurly, ISemanticRegion rightCurly) {
		if (leftCurly !== null && rightCurly !== null) {
			interior(leftCurly, rightCurly, [indent])
			leftCurly.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
			namedElement.ownedPropertyAssociations.tail.forEach[
				prepend[oneSpace; setNewLines(0, 0, 1); autowrap]
			]
			namedElement.ownedPropertyAssociations.forEach[it.format(document)]
			if (rightCurly.previousHiddenRegion.multiline) {
				rightCurly.prepend[newLines =  1]
			} else {
				rightCurly.prepend[noSpace]
			}
		}
	}
	
	def dispatch void format(ModeTransitionTrigger modeTransitionTrigger, extension IFormattableDocument document) {
		modeTransitionTrigger.regionFor.keyword(triggerAccess.fullStopKeyword_0_0_1).surround[noSpace]
		modeTransitionTrigger.regionFor.keyword(triggerAccess.fullStopKeyword_1_1).surround[noSpace]
		modeTransitionTrigger.regionFor.keyword(triggerAccess.fullStopKeyword_2_1).surround[noSpace]
	}
	
	def dispatch void format(FeatureGroupPrototype featureGroupPrototype, extension IFormattableDocument document) {
		featureGroupPrototype.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		//Named
		featureGroupPrototype.regionFor.keyword(featureGroupPrototypeAccess.colonKeyword_0_0_1).prepend[noSpace].append[oneSpace]
		
		//Refined
		featureGroupPrototype.regionFor.keyword(featureGroupPrototypeAccess.colonKeyword_0_1_1).prepend[noSpace].append[oneSpace]
		featureGroupPrototype.regionFor.keyword(refinedToKeywordsAccess.toKeyword_1).surround[oneSpace]
		
		featureGroupPrototype.regionFor.keyword(featureGroupKeywordsAccess.featureKeyword_0).append[oneSpace]
		featureGroupPrototype.regionFor.assignment(featureGroupPrototypeAccess.constrainingFeatureGroupTypeAssignment_2).prepend[oneSpace]
		formatCurlyProperties(featureGroupPrototype, document,
			featureGroupPrototype.regionFor.keyword(featureGroupPrototypeAccess.leftCurlyBracketKeyword_3_0),
			featureGroupPrototype.regionFor.keyword(featureGroupPrototypeAccess.rightCurlyBracketKeyword_3_2)
		)
		featureGroupPrototype.regionFor.keyword(featureGroupPrototypeAccess.semicolonKeyword_4).prepend[noSpace]
	}
	
	def dispatch void format(FeaturePrototype featurePrototype, extension IFormattableDocument document) {
		featurePrototype.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		//Named
		featurePrototype.regionFor.keyword(featurePrototypeAccess.colonKeyword_0_0_1).prepend[noSpace].append[oneSpace]
		
		//Refined
		featurePrototype.regionFor.keyword(featurePrototypeAccess.colonKeyword_0_1_1).prepend[noSpace].append[oneSpace]
		featurePrototype.regionFor.keyword(refinedToKeywordsAccess.toKeyword_1).surround[oneSpace]
		
		//Direction
		featurePrototype.regionFor.keyword(featurePrototypeAccess.inInKeyword_1_0_0).append[oneSpace]
		featurePrototype.regionFor.keyword(featurePrototypeAccess.outOutKeyword_1_1_0).append[oneSpace]
		
		featurePrototype.regionFor.assignment(featurePrototypeAccess.constrainingClassifierAssignment_3).prepend[oneSpace]
		formatCurlyProperties(featurePrototype, document, featurePrototype.regionFor.keyword(featurePrototypeAccess.leftCurlyBracketKeyword_4_0),
			featurePrototype.regionFor.keyword(featurePrototypeAccess.rightCurlyBracketKeyword_4_2)
		)
		featurePrototype.regionFor.keyword(featurePrototypeAccess.semicolonKeyword_5).prepend[noSpace]
	}
	
	def private formatComponentPrototypeCommon(ComponentPrototype componentPrototype, extension IFormattableDocument document, ISemanticRegion constrainingClassifierAssignment) {
		componentPrototype.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		//Named and refined
		componentPrototype.regionFor.keyword(":").prepend[noSpace].append[oneSpace]
		componentPrototype.regionFor.keyword("to").surround[oneSpace]
		
		constrainingClassifierAssignment.prepend[oneSpace]
		componentPrototype.regionFor.keyword("[").surround[noSpace]
		formatCurlyProperties(componentPrototype, document, componentPrototype.regionFor.keyword("{"),
			componentPrototype.regionFor.keyword("}")
		)
		componentPrototype.regionFor.keyword(";").prepend[noSpace]
	}
	
	def dispatch void format(AbstractPrototype abstractPrototype, extension IFormattableDocument document) {
		formatComponentPrototypeCommon(abstractPrototype, document,
			abstractPrototype.regionFor.assignment(abstractPrototypeAccess.constrainingClassifierAssignment_2)
		)
	}
	
	def dispatch void format(BusPrototype busPrototype, extension IFormattableDocument document) {
		formatComponentPrototypeCommon(busPrototype, document,
			busPrototype.regionFor.assignment(busPrototypeAccess.constrainingClassifierAssignment_2)
		)
	}
	
	def dispatch void format(DataPrototype dataPrototype, extension IFormattableDocument document) {
		formatComponentPrototypeCommon(dataPrototype, document,
			dataPrototype.regionFor.assignment(dataPrototypeAccess.constrainingClassifierAssignment_2)
		)
	}
	
	def dispatch void format(DevicePrototype devicePrototype, extension IFormattableDocument document) {
		formatComponentPrototypeCommon(devicePrototype, document,
			devicePrototype.regionFor.assignment(devicePrototypeAccess.constrainingClassifierAssignment_2)
		)
	}
	
	def dispatch void format(MemoryPrototype memoryPrototype, extension IFormattableDocument document) {
		formatComponentPrototypeCommon(memoryPrototype, document,
			memoryPrototype.regionFor.assignment(memoryPrototypeAccess.constrainingClassifierAssignment_2)
		)
	}
	
	def dispatch void format(ProcessPrototype processPrototype, extension IFormattableDocument document) {
		formatComponentPrototypeCommon(processPrototype, document,
			processPrototype.regionFor.assignment(processPrototypeAccess.constrainingClassifierAssignment_2)
		)
	}
	
	def dispatch void format(ProcessorPrototype processorPrototype, extension IFormattableDocument document) {
		formatComponentPrototypeCommon(processorPrototype, document,
			processorPrototype.regionFor.assignment(processorPrototypeAccess.constrainingClassifierAssignment_2)
		)
	}
	
	def dispatch void format(SubprogramPrototype subprogramPrototype, extension IFormattableDocument document) {
		formatComponentPrototypeCommon(subprogramPrototype, document,
			subprogramPrototype.regionFor.assignment(subprogramPrototypeAccess.constrainingClassifierAssignment_2)
		)
	}
	
	def dispatch void format(SubprogramGroupPrototype subprogramGroupPrototype, extension IFormattableDocument document) {
		formatComponentPrototypeCommon(subprogramGroupPrototype, document,
			subprogramGroupPrototype.regionFor.assignment(subprogramGroupPrototypeAccess.constrainingClassifierAssignment_2)
		)
		subprogramGroupPrototype.regionFor.keyword(subprogramGroupKeywordsAccess.subprogramKeyword_0).append[oneSpace]
	}
	
	def dispatch void format(SystemPrototype systemPrototype, extension IFormattableDocument document) {
		formatComponentPrototypeCommon(systemPrototype, document,
			systemPrototype.regionFor.assignment(systemPrototypeAccess.constrainingClassifierAssignment_2)
		)
	}
	
	def dispatch void format(ThreadPrototype threadPrototype, extension IFormattableDocument document) {
		formatComponentPrototypeCommon(threadPrototype, document,
			threadPrototype.regionFor.assignment(threadPrototypeAccess.constrainingClassifierAssignment_2)
		)
	}
	
	def dispatch void format(ThreadGroupPrototype threadGroupPrototype, extension IFormattableDocument document) {
		formatComponentPrototypeCommon(threadGroupPrototype, document,
			threadGroupPrototype.regionFor.assignment(threadGroupPrototypeAccess.constrainingClassifierAssignment_2)
		)
		threadGroupPrototype.regionFor.keyword(threadGroupKeywordsAccess.threadKeyword_0).append[oneSpace]
	}
	
	def dispatch void format(VirtualBusPrototype virtualBusPrototype, extension IFormattableDocument document) {
		formatComponentPrototypeCommon(virtualBusPrototype, document,
			virtualBusPrototype.regionFor.assignment(virtualBusPrototypeAccess.constrainingClassifierAssignment_2)
		)
		virtualBusPrototype.regionFor.keyword(virtualBusKeywordsAccess.virtualKeyword_0).append[oneSpace]
	}
	
	def dispatch void format(VirtualProcessorPrototype virtualProcessorPrototype, extension IFormattableDocument document) {
		formatComponentPrototypeCommon(virtualProcessorPrototype, document,
			virtualProcessorPrototype.regionFor.assignment(virtualProcessorPrototypeAccess.constrainingClassifierAssignment_2)
		)
		virtualProcessorPrototype.regionFor.keyword(virtualProcessorKeywordsAccess.virtualKeyword_0).append[oneSpace]
	}
	
	def dispatch void format(DefaultAnnexSubclause defaultAnnexSubclause, extension IFormattableDocument document) {
		defaultAnnexSubclause.conditionalAppend(document, [setNewLines(1, 1, 2)])
		defaultAnnexSubclause.regionFor.assignment(defaultAnnexSubclauseAccess.nameAssignment_1).surround[oneSpace]
		
		val parsedSubclause = defaultAnnexSubclause.parsedAnnexSubclause
		val sourceTextRegion = defaultAnnexSubclause.regionFor.assignment(defaultAnnexSubclauseAccess.sourceTextAssignment_2)
		formatAnnexText(parsedSubclause, defaultAnnexSubclause.name, sourceTextRegion, 2, document)
		performModification(defaultAnnexSubclause, [defaultAnnexSubclause.parsedAnnexSubclause = parsedSubclause])
		
		//In modes
		val leftParenthesis = defaultAnnexSubclause.regionFor.keyword(defaultAnnexSubclauseAccess.leftParenthesisKeyword_3_1)
		val rightParenthesis = defaultAnnexSubclause.regionFor.keyword(defaultAnnexSubclauseAccess.rightParenthesisKeyword_3_3)
		if (leftParenthesis !== null && rightParenthesis !== null) {
			defaultAnnexSubclause.regionFor.keyword(inModesKeywordsAccess.inKeyword_0).surround[oneSpace]
			interior(leftParenthesis, rightParenthesis, [indent])
			leftParenthesis.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
			defaultAnnexSubclause.regionFor.keywords(defaultAnnexSubclauseAccess.commaKeyword_3_2_1_0).forEach[
				prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]
			]
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1]
			} else {
				rightParenthesis.prepend[noSpace]
			}
		}
		
		defaultAnnexSubclause.regionFor.keyword(defaultAnnexSubclauseAccess.semicolonKeyword_4).prepend[noSpace]
	}
	
	def dispatch void format(FeatureGroupType featureGroupType, extension IFormattableDocument document) {
		val newLineCount = switch featureGroupType.regionForEObject?.nextSemanticRegion?.semanticElement {
			Classifier,
			AnnexLibrary,
			PackageSection: 2
			default: 1
		}
		featureGroupType.conditionalAppend(document, [setNewLines(newLineCount, newLineCount, 2)])
		
		featureGroupType.regionFor.keyword(featureGroupKeywordsAccess.groupKeyword_1).surround[oneSpace]
		
		val endKeyword = featureGroupType.regionFor.keyword(featureGroupTypeAccess.endKeyword_8)
		
		//Declaration line
		val nameAssignment = featureGroupType.regionFor.assignment(featureGroupTypeAccess.nameAssignment_1)
		if (featureGroupType.ownedExtension === null) {
			nameAssignment.append[setNewLines(1, 1, 2)]
			interior(nameAssignment, endKeyword, [indent])
		} else {
			nameAssignment.append[oneSpace]
			featureGroupType.ownedExtension.format(document)
			if (featureGroupType.ownedPrototypeBindings.empty) {
				featureGroupType.ownedExtension.append[setNewLines(1, 1, 2)]
				interior(featureGroupType.ownedExtension.allSemanticRegions.last, endKeyword, [indent])
			} else {
				val leftParenthesis = featureGroupType.regionFor.keyword(featureGroupTypeAccess.leftParenthesisKeyword_2_1_0)
				val rightParenthesis = featureGroupType.regionFor.keyword(featureGroupTypeAccess.rightParenthesisKeyword_2_1_3)
				interior(leftParenthesis, rightParenthesis, [indent])
				leftParenthesis.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
				featureGroupType.regionFor.keywords(featureGroupTypeAccess.commaKeyword_2_1_2_0).forEach[
					prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]
				]
				featureGroupType.ownedPrototypeBindings.forEach[it.format(document)]
				if (rightParenthesis !== null) {
					if (rightParenthesis.previousHiddenRegion.multiline) {
						rightParenthesis.prepend[newLines = 1].append[setNewLines(1, 1, 2)]
					} else {
						rightParenthesis.prepend[noSpace].append[setNewLines(1, 1, 2)]
					}
					interior(rightParenthesis, endKeyword, [indent])
				}
			}
		}
		
		//Section headings
		val prototypesKeyword = featureGroupType.regionFor.keyword(featureGroupTypeAccess.prototypesKeyword_3_0)
		val featuresKeyword = featureGroupType.regionFor.keyword(featureGroupTypeAccess.featuresKeyword_4_0)
		val inverseKeyword = featureGroupType.regionFor.keyword(inverseOfKeywordsAccess.inverseKeyword_0)
		val inverseAssignment = featureGroupType.regionFor.assignment(featureGroupTypeAccess.inverseAssignment_5_1)
		val propertiesKeyword = featureGroupType.regionFor.keyword(featureGroupTypeAccess.propertiesKeyword_6_0)
		val annexRegion = featureGroupType.ownedAnnexSubclauses.head.semanticRegions.head
		
		if (prototypesKeyword !== null) {
			prototypesKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = featuresKeyword ?: inverseKeyword ?: propertiesKeyword ?: annexRegion ?: endKeyword
			interior(prototypesKeyword, endMarker, [indent])
		}
		if (featuresKeyword !== null) {
			featuresKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = inverseKeyword ?: propertiesKeyword ?: annexRegion ?: endKeyword
			interior(featuresKeyword, endMarker, [indent])
		}
		if (propertiesKeyword !== null) {
			propertiesKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = annexRegion ?: endKeyword
			interior(propertiesKeyword, endMarker, [indent])
		}
		
		//None keywords
		featureGroupType.regionFor.keywords(featureGroupTypeAccess.noPrototypesNoneKeyword_3_1_0_0_0,
			featureGroupTypeAccess.noPropertiesNoneKeyword_6_1_1_0_0
		).forEach[append[noSpace]]
		
		//Semicolons after none keywords
		val semicolons = featureGroupType.regionFor.keywords(";")
		if (semicolons.size > 1) {
			semicolons.take(semicolons.size - 1).forEach[append[setNewLines(1, 1, 2)]]
		}
		
		//Contents
		(featureGroupType.ownedPrototypes +
			featureGroupType.ownedFeatures +
			featureGroupType.ownedAnnexSubclauses
		).forEach[it.format(document)]
		
		//Inverse of
		inverseKeyword.append[oneSpace]
		inverseAssignment.prepend[oneSpace].append[setNewLines(1, 1, 2)]
		
		//Properties
		featureGroupType.ownedPropertyAssociations.forEach[
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]
		
		//End line
		endKeyword.append[oneSpace]
		semicolons.last.prepend[noSpace]
	}
	
	def dispatch void format(GroupExtension groupExtension, extension IFormattableDocument document) {
		groupExtension.regionFor.keyword(groupExtensionAccess.extendsKeyword_0).append[oneSpace]
	}
	
	def private formatComponentImplementationCommon(ComponentImplementation componentImplementation, extension IFormattableDocument document,
		ISemanticRegion nameAssignment
	) {
		val newLineCount = switch componentImplementation.regionForEObject?.nextSemanticRegion?.semanticElement {
			Classifier,
			AnnexLibrary,
			PackageSection: 2
			default: 1
		}
		componentImplementation.conditionalAppend(document, [setNewLines(newLineCount, newLineCount, 2)])
		
		val endKeyword = componentImplementation.regionFor.keyword("end")
		
		//Declaration line
		componentImplementation.ownedRealization.prepend[oneSpace].append[noSpace]
		nameAssignment.prepend[noSpace]
		if (componentImplementation.ownedExtension === null && componentImplementation.ownedPrototypeBindings.empty) {
			nameAssignment.append[setNewLines(1, 1, 2)]
			interior(nameAssignment, endKeyword, [indent])
		} else {
			nameAssignment.append[oneSpace]
			componentImplementation.ownedExtension.format(document)
			if (componentImplementation.ownedPrototypeBindings.empty) {
				componentImplementation.ownedExtension.append[setNewLines(1, 1, 2)]
				interior(componentImplementation.ownedExtension.allSemanticRegions.last, endKeyword, [indent])
			} else {
				componentImplementation.ownedExtension.append[oneSpace]
				val leftParenthesis = componentImplementation.regionFor.keyword("(")
				val rightParenthesis = componentImplementation.regionFor.keyword(")")
				interior(leftParenthesis, rightParenthesis, [indent])
				leftParenthesis.append[noSpace; setNewLines(0, 0, 1); autowrap]
				componentImplementation.regionFor.keywords(",").forEach[prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]]
				componentImplementation.ownedPrototypeBindings.forEach[it.format(document)]
				if (rightParenthesis !== null) {
					if (rightParenthesis.previousHiddenRegion.multiline) {
						rightParenthesis.prepend[newLines = 1].append[setNewLines(1, 1, 2)]
					} else {
						rightParenthesis.prepend[noSpace].append[setNewLines(1, 1, 2)]
					}
					interior(rightParenthesis, endKeyword, [indent])
				}
			}
		}
		
		//Section headings
		val prototypesKeyword = componentImplementation.regionFor.keyword("prototypes")
		val subcomponentsKeyword = componentImplementation.regionFor.keyword("subcomponents")
		val internalKeyword = componentImplementation.regionFor.keyword(internalFeaturesKeywordsAccess.internalKeyword_0)
		val internalFeaturesKeyword = componentImplementation.regionFor.keyword(internalFeaturesKeywordsAccess.featuresKeyword_1)
		val processorKeyword = componentImplementation.regionFor.keyword(processorFeaturesKeywordsAccess.processorKeyword_0)
		val processorFeaturesKeyword = componentImplementation.regionFor.keyword(processorFeaturesKeywordsAccess.featuresKeyword_1)
		val callsKeyword = componentImplementation.regionFor.keyword("calls")
		val connectionsKeyword = componentImplementation.regionFor.keyword("connections")
		val flowsKeyword = componentImplementation.regionFor.keyword("flows")
		val modesKeyword = componentImplementation.regionFor.keyword("modes")
		val propertiesKeyword = componentImplementation.regionFor.keyword("properties")
		val annexRegion = componentImplementation.ownedAnnexSubclauses.head.semanticRegions.head
		
		if (prototypesKeyword !== null) {
			prototypesKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = subcomponentsKeyword ?: internalKeyword ?: processorKeyword ?: callsKeyword ?:
				connectionsKeyword ?: flowsKeyword ?: modesKeyword ?: propertiesKeyword ?: annexRegion ?: endKeyword
			interior(prototypesKeyword, endMarker, [indent])
		}
		if (subcomponentsKeyword !== null) {
			subcomponentsKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = internalKeyword ?: processorKeyword ?: callsKeyword ?: connectionsKeyword ?: flowsKeyword ?:
				modesKeyword ?: propertiesKeyword ?: annexRegion ?: endKeyword
			interior(subcomponentsKeyword, endMarker, [indent])
		}
		if (internalFeaturesKeyword !== null) {
			internalFeaturesKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = processorKeyword ?: callsKeyword ?: connectionsKeyword ?: flowsKeyword ?: modesKeyword ?:
				propertiesKeyword ?: annexRegion ?: endKeyword
			interior(internalFeaturesKeyword, endMarker, [indent])
		}
		if (processorFeaturesKeyword !== null) {
			processorFeaturesKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = callsKeyword ?: connectionsKeyword ?: flowsKeyword ?: modesKeyword ?: propertiesKeyword ?:
				annexRegion ?: endKeyword
			interior(processorFeaturesKeyword, endMarker, [indent])
		}
		if (callsKeyword !== null) {
			callsKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = connectionsKeyword ?: flowsKeyword ?: modesKeyword ?: propertiesKeyword ?: annexRegion ?:
				endKeyword
			interior(callsKeyword, endMarker, [indent])
		}
		if (connectionsKeyword !== null) {
			connectionsKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = flowsKeyword ?: modesKeyword ?: propertiesKeyword ?: annexRegion ?: endKeyword
			interior(connectionsKeyword, endMarker, [indent])
		}
		if (flowsKeyword !== null) {
			flowsKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = modesKeyword ?: propertiesKeyword ?: annexRegion ?: endKeyword
			interior(flowsKeyword, endMarker, [indent])
		}
		if (modesKeyword !== null) {
			modesKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = propertiesKeyword ?: annexRegion ?: endKeyword
			interior(modesKeyword, endMarker, [indent])
		}
		if (propertiesKeyword !== null) {
			propertiesKeyword.append[setNewLines(1, 1, 2)]
			val endMarker = annexRegion ?: endKeyword
			interior(propertiesKeyword, endMarker, [indent])
		}
		
		//Internal and processor features
		internalKeyword.append[oneSpace]
		processorKeyword.append[oneSpace]
		
		//None keywords
		componentImplementation.regionFor.keywords("none").forEach[append[noSpace]]
		
		//Semicolons after none keywords
		val semicolons = componentImplementation.regionFor.keywords(";")
		if (semicolons.size > 1) {
			semicolons.take(semicolons.size - 1).forEach[append[setNewLines(1, 1, 2)]]
		}
		
		//Contents
		(componentImplementation.ownedPrototypes +
			componentImplementation.ownedSubcomponents +
			componentImplementation.ownedInternalFeatures +
			componentImplementation.ownedProcessorFeatures +
			componentImplementation.ownedConnections +
			componentImplementation.ownedFlowImplementations +
			componentImplementation.ownedEndToEndFlows +
			componentImplementation.ownedModes +
			componentImplementation.ownedModeTransitions +
			componentImplementation.ownedAnnexSubclauses
		).forEach[it.format(document)]
		
		//Properties
		componentImplementation.ownedPropertyAssociations.forEach[
			append[setNewLines(1, 1, 2)]
			it.format(document)
		]
		
		//End line
		endKeyword.append[oneSpace]
		semicolons.last.prepend[noSpace]
	}
	
	def private formatBehavioredImplementationCommon(BehavioredImplementation behavioredImplementation, extension IFormattableDocument document,
		ISemanticRegion nameAssignment
	) {
		behavioredImplementation.ownedSubprogramCallSequences.forEach[it.format(document)]
		formatComponentImplementationCommon(behavioredImplementation, document, nameAssignment)
	}
	
	def dispatch void format(AbstractImplementation abstractImplementation, extension IFormattableDocument document) {
		abstractImplementation.regionFor.keyword(abstractImplementationKeywordsAccess.abstractKeyword_0).append[oneSpace]
		formatBehavioredImplementationCommon(abstractImplementation, document,
			abstractImplementation.regionFor.assignment(abstractImplementationAccess.nameAssignment_3)
		)
	}
	
	def dispatch void format(ThreadImplementation threadImplementation, extension IFormattableDocument document) {
		threadImplementation.regionFor.keyword(threadImplementationKeywordsAccess.threadKeyword_0).append[oneSpace]
		formatBehavioredImplementationCommon(threadImplementation, document,
			threadImplementation.regionFor.assignment(threadImplementationAccess.nameAssignment_3)
		)
	}
	
	def dispatch void format(SubprogramImplementation subprogramImplementation, extension IFormattableDocument document) {
		subprogramImplementation.regionFor.keyword(subprogramImplementationKeywordsAccess.subprogramKeyword_0).append[oneSpace]
		formatBehavioredImplementationCommon(subprogramImplementation, document,
			subprogramImplementation.regionFor.assignment(subprogramImplementationAccess.nameAssignment_3)
		)
	}
	
	def dispatch void format(SystemImplementation systemImplementation, extension IFormattableDocument document) {
		systemImplementation.regionFor.keyword(systemImplementationKeywordsAccess.systemKeyword_0).append[oneSpace]
		formatComponentImplementationCommon(systemImplementation, document,
			systemImplementation.regionFor.assignment(systemImplementationAccess.nameAssignment_3)
		)
	}
	
	def dispatch void format(ProcessImplementation processImplementation, extension IFormattableDocument document) {
		processImplementation.regionFor.keyword(processImplementationKeywordsAccess.processKeyword_0).append[oneSpace]
		formatComponentImplementationCommon(processImplementation, document,
			processImplementation.regionFor.assignment(processImplementationAccess.nameAssignment_3)
		)
	}
	
	def dispatch void format(ThreadGroupImplementation threadGroupImplementation, extension IFormattableDocument document) {
		threadGroupImplementation.regionFor.keyword(threadGroupImplementationKeywordsAccess.groupKeyword_1).surround[oneSpace]
		formatComponentImplementationCommon(threadGroupImplementation, document,
			threadGroupImplementation.regionFor.assignment(threadGroupImplementationAccess.nameAssignment_3)
		)
	}
	
	def dispatch void format(SubprogramGroupImplementation subprogramGroupImplementation, extension IFormattableDocument document) {
		subprogramGroupImplementation.regionFor.keyword(subprogramGroupImplementationKeywordsAccess.groupKeyword_1).surround[oneSpace]
		formatComponentImplementationCommon(subprogramGroupImplementation, document,
			subprogramGroupImplementation.regionFor.assignment(subprogramGroupImplementationAccess.nameAssignment_3)
		)
	}
	
	def dispatch void format(ProcessorImplementation processorImplementation, extension IFormattableDocument document) {
		processorImplementation.regionFor.keyword(processorImplementationKeywordsAccess.processorKeyword_0).append[oneSpace]
		formatComponentImplementationCommon(processorImplementation, document,
			processorImplementation.regionFor.assignment(processorImplementationAccess.nameAssignment_3)
		)
	}
	
	def dispatch void format(VirtualProcessorImplementation virtualProcessorImplementation, extension IFormattableDocument document) {
		virtualProcessorImplementation.regionFor.keyword(virtualProcessorImplementationKeywordsAccess.processorKeyword_1).surround[oneSpace]
		formatComponentImplementationCommon(virtualProcessorImplementation, document,
			virtualProcessorImplementation.regionFor.assignment(virtualProcessorImplementationAccess.nameAssignment_3)
		)
	}
	
	def dispatch void format(DeviceImplementation deviceImplementation, extension IFormattableDocument document) {
		deviceImplementation.regionFor.keyword(deviceImplementationKeywordsAccess.deviceKeyword_0).append[oneSpace]
		formatComponentImplementationCommon(deviceImplementation, document,
			deviceImplementation.regionFor.assignment(deviceImplementationAccess.nameAssignment_3)
		)
	}
	
	def dispatch void format(MemoryImplementation memoryImplementation, extension IFormattableDocument document) {
		memoryImplementation.regionFor.keyword(memoryImplementationKeywordsAccess.memoryKeyword_0).append[oneSpace]
		formatComponentImplementationCommon(memoryImplementation, document,
			memoryImplementation.regionFor.assignment(memoryImplementationAccess.nameAssignment_3)
		)
	}
	
	def dispatch void format(BusImplementation busImplementation, extension IFormattableDocument document) {
		busImplementation.regionFor.keyword(busImplementationKeywordsAccess.busKeyword_0).append[oneSpace]
		formatComponentImplementationCommon(busImplementation, document,
			busImplementation.regionFor.assignment(busImplementationAccess.nameAssignment_3)
		)
	}
	
	def dispatch void format(VirtualBusImplementation virtualBusImplementation, extension IFormattableDocument document) {
		virtualBusImplementation.regionFor.keyword(virtualBusImplementationKeywordsAccess.busKeyword_1).surround[oneSpace]
		formatComponentImplementationCommon(virtualBusImplementation, document,
			virtualBusImplementation.regionFor.assignment(virtualBusImplementationAccess.nameAssignment_3)
		)
	}
	
	def dispatch void format(DataImplementation dataImplementation, extension IFormattableDocument document) {
		dataImplementation.regionFor.keyword(dataImplementationKeywordsAccess.dataKeyword_0).append[oneSpace]
		formatComponentImplementationCommon(dataImplementation, document,
			dataImplementation.regionFor.assignment(dataImplementationAccess.nameAssignment_4)
		)
	}
	
	def dispatch void format(ImplementationExtension implementationExtension, extension IFormattableDocument document) {
		implementationExtension.regionFor.keyword(implementationExtensionAccess.extendsKeyword_0).append[oneSpace]
	}
	
	def dispatch void format(EventSource eventSource, extension IFormattableDocument document) {
		eventSource.conditionalAppend(document, [setNewLines(1, 1, 2)])
		eventSource.regionFor.keyword(eventSourceAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		formatCurlyProperties(eventSource, document,
			eventSource.regionFor.keyword(eventSourceAccess.leftCurlyBracketKeyword_3_0),
			eventSource.regionFor.keyword(eventSourceAccess.rightCurlyBracketKeyword_3_2)
		)
		eventSource.regionFor.keyword(eventSourceAccess.semicolonKeyword_4).prepend[noSpace]
	}
	
	def dispatch void format(EventDataSource eventDataSource, extension IFormattableDocument document) {
		eventDataSource.conditionalAppend(document, [setNewLines(1, 1, 2)])
		eventDataSource.regionFor.keyword(eventDataSourceAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		eventDataSource.regionFor.keyword(eventDataKeywordsAccess.eventKeyword_0).append[oneSpace]
		eventDataSource.regionFor.assignment(eventDataSourceAccess.dataClassifierAssignment_3).prepend[oneSpace]
		formatCurlyProperties(eventDataSource, document,
			eventDataSource.regionFor.keyword(eventDataSourceAccess.leftCurlyBracketKeyword_4_0),
			eventDataSource.regionFor.keyword(eventDataSourceAccess.rightCurlyBracketKeyword_4_2)
		)
		eventDataSource.regionFor.keyword(eventDataSourceAccess.semicolonKeyword_5).prepend[noSpace]
	}
	
	def dispatch void format(PortProxy portProxy, extension IFormattableDocument document) {
		portProxy.conditionalAppend(document, [setNewLines(1, 1, 2)])
		portProxy.regionFor.keyword(portProxyAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		portProxy.regionFor.assignment(portProxyAccess.dataClassifierAssignment_3).prepend[oneSpace]
		formatCurlyProperties(portProxy, document,
			portProxy.regionFor.keyword(portProxyAccess.leftCurlyBracketKeyword_4_0),
			portProxy.regionFor.keyword(portProxyAccess.rightCurlyBracketKeyword_4_2)
		)
		portProxy.regionFor.keyword(portProxyAccess.semicolonKeyword_5).prepend[noSpace]
	}
	
	def dispatch void format(SubprogramProxy subprogramProxy, extension IFormattableDocument document) {
		subprogramProxy.conditionalAppend(document, [setNewLines(1, 1, 2)])
		subprogramProxy.regionFor.keyword(subprogramProxyAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		subprogramProxy.regionFor.assignment(subprogramProxyAccess.subprogramClassifierAssignment_3).prepend[oneSpace]
		formatCurlyProperties(subprogramProxy, document,
			subprogramProxy.regionFor.keyword(subprogramProxyAccess.leftCurlyBracketKeyword_4_0),
			subprogramProxy.regionFor.keyword(subprogramProxyAccess.rightCurlyBracketKeyword_4_2)
		)
		subprogramProxy.regionFor.keyword(subprogramProxyAccess.semicolonKeyword_5).prepend[noSpace]
	}
	
	def dispatch void format(SubprogramCallSequence subprogramCallSequence, extension IFormattableDocument document) {
		subprogramCallSequence.conditionalAppend(document, [setNewLines(1, 1, 2)])
		subprogramCallSequence.regionFor.keyword(subprogramCallSequenceAccess.colonKeyword_1).prepend[noSpace].append[oneSpace]
		val leftCurly = subprogramCallSequence.regionFor.keyword(subprogramCallSequenceAccess.leftCurlyBracketKeyword_2)
		leftCurly.append[setNewLines(1, 1, 2)]
		interior(leftCurly, subprogramCallSequence.regionFor.keyword(subprogramCallSequenceAccess.rightCurlyBracketKeyword_4), [indent])
		subprogramCallSequence.ownedSubprogramCalls.forEach[it.format(document)]
		formatCurlyProperties(subprogramCallSequence, document,
			subprogramCallSequence.regionFor.keyword(subprogramCallSequenceAccess.leftCurlyBracketKeyword_5_0),
			subprogramCallSequence.regionFor.keyword(subprogramCallSequenceAccess.rightCurlyBracketKeyword_5_2)
		)
		
		//In modes
		val leftParenthesis = subprogramCallSequence.regionFor.keyword(subprogramCallSequenceAccess.leftParenthesisKeyword_6_1)
		val rightParenthesis = subprogramCallSequence.regionFor.keyword(subprogramCallSequenceAccess.rightParenthesisKeyword_6_3)
		if (leftParenthesis !== null && rightParenthesis !== null) {
			subprogramCallSequence.regionFor.keyword(inModesKeywordsAccess.inKeyword_0).surround[oneSpace]
			interior(leftParenthesis, rightParenthesis, [indent])
			leftParenthesis.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
			subprogramCallSequence.regionFor.keywords(subprogramCallSequenceAccess.commaKeyword_6_2_1_0).forEach[
				prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]
			]
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1]
			} else {
				rightParenthesis.prepend[noSpace]
			}
		}
		
		subprogramCallSequence.regionFor.keyword(subprogramCallSequenceAccess.semicolonKeyword_7).prepend[noSpace]
	}
	
	def dispatch void format(SubprogramCall subprogramCall, extension IFormattableDocument document) {
		subprogramCall.conditionalAppend(document, [setNewLines(1, 1, 2)])
		subprogramCall.regionFor.keyword(subprogramCallAccess.colonKeyword_2).prepend[noSpace].append[oneSpace]
		subprogramCall.regionFor.keyword(subprogramCallAccess.subprogramKeyword_3).append[oneSpace]
		subprogramCall.regionFor.keyword(subprogramCallAccess.fullStopKeyword_4_0_1).surround[noSpace]
		subprogramCall.regionFor.keyword(subprogramCallAccess.fullStopKeyword_4_2_1).surround[noSpace]
		formatCurlyProperties(subprogramCall, document,
			subprogramCall.regionFor.keyword(subprogramCallAccess.leftCurlyBracketKeyword_5_0),
			subprogramCall.regionFor.keyword(subprogramCallAccess.rightCurlyBracketKeyword_5_2)
		)
		subprogramCall.regionFor.keyword(subprogramCallAccess.semicolonKeyword_6).prepend[noSpace]
	}
	
	def private formatSubcomponentCommon(Subcomponent subcomponent, extension IFormattableDocument document,
		ISemanticRegion subcomponentTypeAssignment
	) {
		subcomponent.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		//Named and refined to
		subcomponent.regionFor.keyword(":").prepend[noSpace].append[oneSpace]
		subcomponent.regionFor.keyword("to").surround[oneSpace]
		
		subcomponentTypeAssignment.prepend[oneSpace]
		
		//Parenthesis found in prototype bindings, implementation references, and mode bindings
		subcomponent.regionFor.keywordPairs("(", ")").forEach[
			interior(key, value, [indent])
			key.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
			if (value.previousHiddenRegion.multiline) {
				value.prepend[newLines = 1]
			} else {
				value.prepend[noSpace]
			}
		]
		
		//Commas found in prototype bindings, implementation references, and mode bindings
		subcomponent.regionFor.keywords(",").forEach[prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]]
		
		subcomponent.ownedPrototypeBindings.forEach[it.format(document)]
		subcomponent.arrayDimensions.forEach[
			prepend[noSpace]
			it.format(document)
		]
		subcomponent.implementationReferences.forEach[it.format(document)]
		formatCurlyProperties(subcomponent, document, subcomponent.regionFor.keyword("{"), subcomponent.regionFor.keyword("}"))
		
		//In modes
		subcomponent.regionFor.keyword("in").surround[oneSpace]
		subcomponent.ownedModeBindings.forEach[it.format(document)]
		
		subcomponent.regionFor.keyword(";").prepend[noSpace]
	}
	
	def dispatch void format(AbstractSubcomponent abstractSubcomponent, extension IFormattableDocument document) {
		formatSubcomponentCommon(abstractSubcomponent, document,
			abstractSubcomponent.regionFor.assignment(abstractSubcomponentAccess.abstractSubcomponentTypeAssignment_2_0)
		)
	}
	
	def dispatch void format(SystemSubcomponent systemSubcomponent, extension IFormattableDocument document) {
		formatSubcomponentCommon(systemSubcomponent, document,
			systemSubcomponent.regionFor.assignment(systemSubcomponentAccess.systemSubcomponentTypeAssignment_2_0)
		)
	}
	
	def dispatch void format(ProcessSubcomponent processSubcomponent, extension IFormattableDocument document) {
		formatSubcomponentCommon(processSubcomponent, document,
			processSubcomponent.regionFor.assignment(processSubcomponentAccess.processSubcomponentTypeAssignment_2_0)
		)
	}
	
	def dispatch void format(ThreadGroupSubcomponent threadGroupSubcomponent, extension IFormattableDocument document) {
		threadGroupSubcomponent.regionFor.keyword(threadGroupKeywordsAccess.threadKeyword_0).append[oneSpace]
		formatSubcomponentCommon(threadGroupSubcomponent, document,
			threadGroupSubcomponent.regionFor.assignment(threadGroupSubcomponentAccess.threadGroupSubcomponentTypeAssignment_2_0)
		)
	}
	
	def dispatch void format(ThreadSubcomponent threadSubcomponent, extension IFormattableDocument document) {
		formatSubcomponentCommon(threadSubcomponent, document,
			threadSubcomponent.regionFor.assignment(threadSubcomponentAccess.threadSubcomponentTypeAssignment_2_0)
		)
	}
	
	def dispatch void format(SubprogramSubcomponent subprogramSubcomponent, extension IFormattableDocument document) {
		formatSubcomponentCommon(subprogramSubcomponent, document,
			subprogramSubcomponent.regionFor.assignment(subprogramSubcomponentAccess.subprogramSubcomponentTypeAssignment_2_0)
		)
	}
	
	def dispatch void format(SubprogramGroupSubcomponent subprogramGroupSubcomponent, extension IFormattableDocument document) {
		subprogramGroupSubcomponent.regionFor.keyword(subprogramGroupKeywordsAccess.subprogramKeyword_0).append[oneSpace]
		formatSubcomponentCommon(subprogramGroupSubcomponent, document,
			subprogramGroupSubcomponent.regionFor.assignment(subprogramGroupSubcomponentAccess.subprogramGroupSubcomponentTypeAssignment_2_0)
		)
	}
	
	def dispatch void format(ProcessorSubcomponent processorSubcomponent, extension IFormattableDocument document) {
		formatSubcomponentCommon(processorSubcomponent, document,
			processorSubcomponent.regionFor.assignment(processorSubcomponentAccess.processorSubcomponentTypeAssignment_2_0)
		)
	}
	
	def dispatch void format(VirtualProcessorSubcomponent virtualProcessorSubcomponent, extension IFormattableDocument document) {
		virtualProcessorSubcomponent.regionFor.keyword(virtualProcessorKeywordsAccess.virtualKeyword_0).append[oneSpace]
		formatSubcomponentCommon(virtualProcessorSubcomponent, document,
			virtualProcessorSubcomponent.regionFor.assignment(virtualProcessorSubcomponentAccess.virtualProcessorSubcomponentTypeAssignment_2_0)
		)
	}
	
	def dispatch void format(DeviceSubcomponent deviceSubcomponent, extension IFormattableDocument document) {
		formatSubcomponentCommon(deviceSubcomponent, document,
			deviceSubcomponent.regionFor.assignment(deviceSubcomponentAccess.deviceSubcomponentTypeAssignment_2_0)
		)
	}
	
	def dispatch void format(MemorySubcomponent memorySubcomponent, extension IFormattableDocument document) {
		formatSubcomponentCommon(memorySubcomponent, document,
			memorySubcomponent.regionFor.assignment(memorySubcomponentAccess.memorySubcomponentTypeAssignment_2_0)
		)
	}
	
	def dispatch void format(BusSubcomponent busSubcomponent, extension IFormattableDocument document) {
		formatSubcomponentCommon(busSubcomponent, document,
			busSubcomponent.regionFor.assignment(busSubcomponentAccess.busSubcomponentTypeAssignment_2_0)
		)
	}
	
	def dispatch void format(VirtualBusSubcomponent virtualBusSubcomponent, extension IFormattableDocument document) {
		virtualBusSubcomponent.regionFor.keyword(virtualBusKeywordsAccess.virtualKeyword_0).append[oneSpace]
		formatSubcomponentCommon(virtualBusSubcomponent, document,
			virtualBusSubcomponent.regionFor.assignment(virtualBusSubcomponentAccess.virtualBusSubcomponentTypeAssignment_2_0)
		)
	}
	
	def dispatch void format(DataSubcomponent dataSubcomponent, extension IFormattableDocument document) {
		formatSubcomponentCommon(dataSubcomponent, document,
			dataSubcomponent.regionFor.assignment(dataSubcomponentAccess.dataSubcomponentTypeAssignment_2_0)
		)
	}
	
	def dispatch void format(ComponentImplementationReference componentImplementationReference, extension IFormattableDocument document) {
		val leftParenthesis = componentImplementationReference.regionFor.keyword(componentImplementationReferenceAccess.leftParenthesisKeyword_2_0)
		val rightParenthesis = componentImplementationReference.regionFor.keyword(componentImplementationReferenceAccess.rightParenthesisKeyword_2_3)
		if (leftParenthesis !== null && rightParenthesis !== null) {
			interior(leftParenthesis, rightParenthesis, [indent])
			leftParenthesis.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
			componentImplementationReference.ownedPrototypeBindings.forEach[it.format(document)]
			componentImplementationReference.regionFor.keywords(componentImplementationReferenceAccess.commaKeyword_2_2_0).forEach[
				prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]
			]
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1]
			} else {
				rightParenthesis.prepend[noSpace]
			}
		}
	}
	
	def dispatch void format(ModeBinding modeBinding, extension IFormattableDocument document) {
		modeBinding.regionFor.keyword(modeRefAccess.equalsSignGreaterThanSignKeyword_1_0).surround[oneSpace]
	}
	
	def private formatConnectionCommon(Connection connection, extension IFormattableDocument document) {
		connection.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		//Named and refined to
		connection.regionFor.keyword(":").prepend[noSpace].append[oneSpace]
		connection.regionFor.keyword("to").surround[oneSpace]
		
		//Connection ends
		connection.source.surround[oneSpace]
		connection.source.format(document)
		connection.destination.prepend[oneSpace]
		connection.destination.format(document)
		
		formatCurlyProperties(connection, document, connection.regionFor.keyword("{"), connection.regionFor.keyword("}"))
		
		//In modes
		val leftParenthesis = connection.regionFor.keyword("(")
		val rightParenthesis = connection.regionFor.keyword(")")
		if (leftParenthesis !== null && rightParenthesis !== null) {
			connection.regionFor.keyword("in").surround[oneSpace]
			interior(leftParenthesis, rightParenthesis, [indent])
			leftParenthesis.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
			connection.regionFor.keywords(",").forEach[prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]]
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1]
			} else {
				rightParenthesis.prepend[noSpace]
			}
		}
		
		connection.regionFor.keyword(";").prepend[noSpace]
	}
	
	def dispatch void format(PortConnection portConnection, extension IFormattableDocument document) {
		formatConnectionCommon(portConnection, document)
	}
	
	def dispatch void format(AccessConnection accessConnection, extension IFormattableDocument document) {
		accessConnection.regionFor.keyword("access").prepend[oneSpace]
		formatConnectionCommon(accessConnection, document)
	}
	
	def dispatch void format(FeatureGroupConnection featureGroupConnection, extension IFormattableDocument document) {
		featureGroupConnection.regionFor.keyword("feature").append[oneSpace]
		formatConnectionCommon(featureGroupConnection, document)
	}
	
	def dispatch void format(FeatureConnection featureConnection, extension IFormattableDocument document) {
		formatConnectionCommon(featureConnection, document)
	}
	
	def dispatch void format(ParameterConnection parameterConnection, extension IFormattableDocument document) {
		formatConnectionCommon(parameterConnection, document)
	}
	
	def dispatch void format(ConnectedElement connectedElement, extension IFormattableDocument document) {
		connectedElement.regionFor.keyword(".").surround[noSpace]
	}
	
	def dispatch void format(FlowSpecification flowSpecification, extension IFormattableDocument document) {
		flowSpecification.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		//Named and refined to
		flowSpecification.regionFor.keyword(":").prepend[noSpace].append[oneSpace]
		flowSpecification.regionFor.keyword(refinedToKeywordsAccess.toKeyword_1).surround[oneSpace]
		
		flowSpecification.regionFor.keyword("flow").append[oneSpace]
		
		//In and out ends
		flowSpecification.inEnd.prepend[oneSpace]
		flowSpecification.inEnd.format(document)
		flowSpecification.regionFor.keyword(flowPathSpecAccess.hyphenMinusGreaterThanSignKeyword_5).prepend[oneSpace]
		flowSpecification.outEnd.prepend[oneSpace]
		flowSpecification.outEnd.format(document)
		
		formatCurlyProperties(flowSpecification, document, flowSpecification.regionFor.keyword("{"), flowSpecification.regionFor.keyword("}"))
		
		//In modes
		val leftParenthesis = flowSpecification.regionFor.keyword("(")
		val rightParenthesis = flowSpecification.regionFor.keyword(")")
		if (leftParenthesis !== null && rightParenthesis !== null) {
			flowSpecification.regionFor.keyword("in").surround[oneSpace]
			leftParenthesis.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
			interior(leftParenthesis, rightParenthesis, [indent])
			flowSpecification.regionFor.keywords(",").forEach[
				prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]
			]
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1]
			} else {
				rightParenthesis.prepend[noSpace]
			}
		}
		
		flowSpecification.regionFor.keyword(";").prepend[noSpace]
	}
	
	def dispatch void format(FlowEnd flowEnd, extension IFormattableDocument document) {
		flowEnd.regionFor.keyword(flowEndAccess.fullStopKeyword_0_1).surround[noSpace]
	}
	
	def dispatch void format(FlowImplementation flowImplementation, extension IFormattableDocument document) {
		flowImplementation.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		flowImplementation.regionFor.keyword(":").prepend[noSpace].append[oneSpace]
		flowImplementation.regionFor.assignment(flowSourceImplAccess.kindAssignment_3).surround[oneSpace]
		flowImplementation.regionFor.assignment(flowSinkImplAccess.kindAssignment_3).surround[oneSpace]
		flowImplementation.regionFor.assignment(flowPathImplAccess.kindAssignment_3).surround[oneSpace]
		
		//Segments
		flowImplementation.regionFor.keywords("->").forEach[surround[oneSpace]]
		flowImplementation.ownedFlowSegments.forEach[it.format(document)]
		
		formatCurlyProperties(flowImplementation, document, flowImplementation.regionFor.keyword("{"), flowImplementation.regionFor.keyword("}"))
		
		//In modes
		val leftParenthesis = flowImplementation.regionFor.keyword("(")
		val rightParenthesis = flowImplementation.regionFor.keyword(")")
		if (leftParenthesis !== null && rightParenthesis !== null) {
			flowImplementation.regionFor.keyword("in").surround[oneSpace]
			interior(leftParenthesis, rightParenthesis, [indent])
			leftParenthesis.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
			flowImplementation.regionFor.keywords(",").forEach[
				prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]
			]
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1]
			} else {
				rightParenthesis.prepend[noSpace]
			}
		}
		
		flowImplementation.regionFor.keyword(";").prepend[noSpace]
	}
	
	def dispatch void format(FlowSegment flowSegment, extension IFormattableDocument document) {
		flowSegment.regionFor.keyword(subcomponentFlowAccess.fullStopKeyword_0_1).surround[noSpace]
	}
	
	def dispatch void format(EndToEndFlow endToEndFlow, extension IFormattableDocument document) {
		endToEndFlow.conditionalAppend(document, [setNewLines(1, 1, 2)])
		
		if (endToEndFlow.refined === null) {
			//Named
			endToEndFlow.regionFor.keyword(endToEndFlowAccess.colonKeyword_0_0_1).prepend[noSpace].append[oneSpace]
			endToEndFlow.regionFor.keyword(endToEndFlowKeywordsAccess.toKeyword_1).surround[oneSpace]
			endToEndFlow.regionFor.keyword(endToEndFlowKeywordsAccess.flowKeyword_3).surround[oneSpace]
			endToEndFlow.ownedEndToEndFlowSegments.forEach[it.format(document)]
			endToEndFlow.regionFor.keywords("->").forEach[surround[oneSpace]]
		} else {
			//Refined to
			endToEndFlow.regionFor.keyword(endToEndFlowAccess.colonKeyword_0_1_1).prepend[noSpace].append[oneSpace]
			endToEndFlow.regionFor.keyword(refinedToKeywordsAccess.toKeyword_1).surround[oneSpace]
			endToEndFlow.regionFor.keyword(endToEndFlowKeywordsAccess.toKeyword_1).surround[oneSpace]
			endToEndFlow.regionFor.keyword(endToEndFlowKeywordsAccess.flowKeyword_3).prepend[oneSpace]
		}
		
		formatCurlyProperties(endToEndFlow, document,
			endToEndFlow.regionFor.keyword(endToEndFlowAccess.leftCurlyBracketKeyword_1_0),
			endToEndFlow.regionFor.keyword(endToEndFlowAccess.rightCurlyBracketKeyword_1_2)
		)
		
		//In modes
		val leftParenthesis = endToEndFlow.regionFor.keyword(endToEndFlowAccess.leftParenthesisKeyword_2_1)
		val rightParenthesis = endToEndFlow.regionFor.keyword(endToEndFlowAccess.rightParenthesisKeyword_2_4)
		if (leftParenthesis !== null && rightParenthesis !== null) {
			endToEndFlow.regionFor.keyword(inModesKeywordsAccess.inKeyword_0).surround[oneSpace]
			interior(leftParenthesis, rightParenthesis, [indent])
			leftParenthesis.prepend[oneSpace].append[noSpace; setNewLines(0, 0, 1); autowrap]
			endToEndFlow.regionFor.keywords(endToEndFlowAccess.commaKeyword_2_3_0).forEach[
				prepend[noSpace].append[oneSpace; setNewLines(0, 0, 1); autowrap]
			]
			if (rightParenthesis.previousHiddenRegion.multiline) {
				rightParenthesis.prepend[newLines = 1]
			} else {
				rightParenthesis.prepend[noSpace]
			}
		}
		
		endToEndFlow.regionFor.keyword(endToEndFlowAccess.semicolonKeyword_3).prepend[noSpace]
	}
	
	def dispatch void format(EndToEndFlowSegment endToEndFlowSegment, extension IFormattableDocument document) {
		endToEndFlowSegment.regionFor.keyword(ETESubcomponentFlowAccess.fullStopKeyword_0_1).surround[noSpace]
	}
	
	/**
	 * Appends if there is another semantic region after {@code appendAfter}.
	 */
	def private <T extends EObject> T conditionalAppend(T appendAfter, extension IFormattableDocument document,
		(IHiddenRegionFormatter)=>void initializer) {
		if (appendAfter?.regionForEObject?.nextSemanticRegion !== null) {
			appendAfter.append(initializer)
		}
		appendAfter
	}
	
	/**
	 * The process for formatting an annex is as follows:
	 * 1. Place the annex object into its own resource. This causes the annex text to effectively exist isolated and
	 *    independent of the surrounding core text.
	 * 2. Inject the annex formatter and format the annex text.
	 * 3. Replace the annex text in the aadl file with the formatted annex text.
	 * 
	 * The specifics of setting up the FormatterRequest for the annex formatter are different based upon how the core
	 * formatter was invoked. If the user invoked formatting on a text file, then the node model is available which is
	 * then used to setup the FormatterRequest. If formatting was invoked as a part of serialization, then the node
	 * model is not be available and the serializer is used to setup the FormatterRequest. 
	 * 
	 * We need to setup an XtextResource with the AnnexLibrary or AnnexSubclause as the root object. If the
	 * FormatterRequest is based on the node model, then the XtextResource also needs the IParseResult attached as well.
	 * This is necessary because the annex formatter takes a resource as a parameter and then it formats the
	 * AnnexLibrary or AnnexSubclause contained as a top level element of the resource.
	 * 
	 * For figuring out how to invoke the formatter such that a String is returned, I looked at
	 * FormatterTestHelper to learn how to do that. The method of most interest is
	 * assertFormatted(FormatterTestRequest).
	 *
	 * It was not obvious how to replace an ISemanticRegion with a given String. It is not enough to simply
	 * call ISemanticRegion.replaceWith(String). This must be wrapped in an ITextReplacer which is then
	 * added to the document. See https://www.eclipse.org/forums/index.php/t/1093069/
	 * 
	 * Since the annex object is placed into its resource, it is removed from its existing resource. The caller of this
	 * method is responsible for re-attaching the annex object to the DefaultAnnexLibrary or DefaultAnnexSubclause.
	 *
	 * @param annexObject The AnnexLibrary or AnnexSubclause to format.
	 * @param sourceTextRegion The ISemanticRegion for the sourceText assignment of the DefaultAnnexLibrary
	 *        or DefaultAnnexSubclause.
	 * @param indentationLevel Indentation level of the DefaultAnnexLibrary or DefaultAnnexSubclause. The
	 *        closing "**}" is placed at indentationLevel. All lines of the formatted annex text are placed
	 *        at indentationLevel + 1.
	 * @param document The document passed to the format method.
	 */
	def private void formatAnnexText(
		NamedElement annexObject,
		String annexName,
		ISemanticRegion sourceTextRegion,
		int indentationLevel,
		IFormattableDocument document
	) {
		if (annexObject !== null && sourceTextRegion !== null) {
			try {
				unsafeFormatAnnexText(annexObject, annexName, sourceTextRegion, indentationLevel, document)
			} catch (ConfigurationException e) {
				// ignore
			} catch (ProvisionException e) {
				// ignore
			}
		}
	}
	
	def private void unsafeFormatAnnexText(
		NamedElement annexObject,
		String annexName,
		ISemanticRegion sourceTextRegion,
		int indentationLevel,
		IFormattableDocument document
	) {
		if (textRegionAccess instanceof NodeModelBasedRegionAccess) {
			val annexParseResult = ParseResultHolder.Factory.INSTANCE.adapt(annexObject).parseResult
			if (annexParseResult !== null) {
				// Get the injector for the annex.
				val annexInjector = AnnexUtil.getInjector(annexParseResult)
				val annexFormatter = annexInjector?.getInstance(IFormatter2)
				if (annexFormatter !== null) {
					// Create resource and populate it with the library or subclause and the parse result.
					val fakeResource = setupAnnexResource(annexInjector, annexObject)
					fakeResource.parseResult = annexParseResult
					
					// Setup the formatting request based on the node model.
					val request = annexInjector.getInstance(FormatterRequest)
					val accessBuilder = annexInjector.getProvider(TextRegionAccessBuilder).get
					request.textRegionAccess = accessBuilder.forNodeModel(fakeResource).create
					
					// Format the annex text.
					invokeAnnexFormatter(annexFormatter, request, sourceTextRegion, indentationLevel, document)
				}
			}
		} else if (textRegionAccess instanceof StringBasedRegionAccess) {
			// Get the injector for the annex.
			val annexInjector = AnnexUtil.getInjector(annexName)
			val annexFormatter = annexInjector?.getInstance(IFormatter2)
			if (annexFormatter !== null) {
				// Create resource and populate it with the library or subclause.
				setupAnnexResource(annexInjector, annexObject)
				
				// Setup the formatting request with the serializer.
				val request = annexInjector.getInstance(FormatterRequest)
				val serializer = annexInjector.getInstance(ISerializer) as Serializer
				request.textRegionAccess = serializer.serializeToRegions(annexObject)
				
				// Format the annex text.
				invokeAnnexFormatter(annexFormatter, request, sourceTextRegion, indentationLevel, document)
			}
		}
	}
	
	def private static XtextResource setupAnnexResource(Injector annexInjector, NamedElement annexObject) {
		val resourceFactory = annexInjector.getInstance(IResourceFactory)
		val annexExtension = annexInjector.getInstance(FileExtensionProvider).primaryFileExtension
		val fakeURI = URI.createURI("__synthetic." + annexExtension)
		val fakeResource = resourceFactory.createResource(fakeURI) as XtextResource
		performModification(annexObject, [fakeResource.contents += annexObject])
		fakeResource
	}
	
	def private static void invokeAnnexFormatter(
		IFormatter2 annexFormatter,
		FormatterRequest request,
		ISemanticRegion sourceTextRegion,
		int indentationLevel,
		IFormattableDocument document
	) {
		val replacements = annexFormatter.format(request)
		val formatted = request.textRegionAccess.rewriter.renderToString(replacements)
		
		/*
		 * Insert the formatted text into the core document
		 * See https://www.eclipse.org/forums/index.php/t/1093069/
		 */
		document.addReplacer(new AbstractTextReplacer(document, sourceTextRegion) {
			override createReplacements(ITextReplacerContext context) {
				val annexIndentation = context.getIndentationString(indentationLevel + 1)
				
				val indented = new StringConcatenation
				indented.append(formatted, annexIndentation)
				val newText = '''
				{**
				«annexIndentation»«indented»
				«context.getIndentationString(indentationLevel)»**}'''
				
				if (newText != sourceTextRegion.text) {
					context.addReplacement(region.replaceWith(newText))
				}
				
				context
			}
		})
	}
	
	def private static void performModification(EObject semanticObject, ()=>void runnable) {
		val resourceSet = semanticObject?.eResource?.resourceSet
		val domain = if (resourceSet !== null) {
			TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(resourceSet)
		}
		if (domain === null) {
			runnable.apply
		} else {
			domain.commandStack.execute(new RecordingCommand(domain) {
				override protected doExecute() {
					runnable.apply
				}
			})
		}
	}
}
