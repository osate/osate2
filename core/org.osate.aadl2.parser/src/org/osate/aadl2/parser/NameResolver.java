/*
 * <copyright>
 * Copyright  2009 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.aadl2.parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.*;
import org.osate.aadl2.modelsupport.eclipseinterface.OsateResourceManager;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;


public class NameResolver {
	private final Aadl2Factory aadl2Factory = Aadl2Factory.eINSTANCE;
	private final Aadl2Package aadl2Package = aadl2Factory.getAadl2Package();

	private final Set<? extends ReferenceRecord> references;
	private final AnalysisErrorReporterManager errManager;

	public NameResolver(Set<? extends ReferenceRecord> references, AnalysisErrorReporterManager errManager) {
		this.references = references;
		this.errManager = errManager;
	}

	public void process() {
		HashSet<ParserReferenceType> referenceTypesWithErrors = new HashSet<ParserReferenceType>();
		for (ReferenceRecord referenceRecord : references) {
			ParserReferenceType referenceType = referenceRecord.getReferenceType();
			HashSet<ParserReferenceType> intersection = new HashSet<ParserReferenceType>(
					referenceType.getDependencies());
			intersection.retainAll(referenceTypesWithErrors);
			if (!intersection.isEmpty())
				referenceTypesWithErrors.add(referenceType);
			else {
				Element referencingObject = referenceRecord.getReferencingObject();
				String[] labels = referenceRecord.getLabels();
				int numberOfErrors = errManager.getNumErrors();
				switch (referenceType) {
				case WithStatementReference:
					if (referencingObject instanceof PackageSection)
						caseWithStatementReference_PackageSection((PackageSection) referencingObject, labels[0]);
					else
						caseWithStatementReference_PropertySet((PropertySet) referencingObject, labels[0]);
					break;
				case PackageRenameReference:
					casePackageRenameReference((PackageRename) referencingObject, labels[0]);
					break;
				case RenamesAll:
					caseRenamesAll((PackageRename) referencingObject, labels[0]);
					break;
				case ComponentTypeRename:
					caseComponentTypeRename((ComponentTypeRename) referencingObject, labels[0], labels[1]);
					break;
				case FeatureGroupTypeRename:
					caseFeatureGroupTypeRename((FeatureGroupTypeRename) referencingObject, labels[0], labels[1]);
					break;
				case RealizationReference:
					caseRealizationReference((Realization) referencingObject, labels[0]);
					break;
				case ComponentTypeExtensionReference:
					if (labels.length == 1) //Only has component type name.
						caseComponentTypeExtensionReference((ComponentType) referencingObject, null, labels[0]);
					else
						//Has component type name and package name.  Example: "pkg::type".
						caseComponentTypeExtensionReference((ComponentType) referencingObject, labels[0], labels[1]);
					break;
				case ComponentImplementationExtensionReference:
					if (labels.length == 2) //Only has type name and implementation name.
					{
						caseComponentImplementationExtensionReference((ImplementationExtension) referencingObject,
								null, labels[0] + "." + labels[1]);
					} else //Has type name, implementation name, and package name.  Example: "pkg::type.i".
					{
						caseComponentImplementationExtensionReference((ImplementationExtension) referencingObject,
								labels[0], labels[1] + "." + labels[2]);
					}
					break;
				case FeatureGroupTypeExtendReference:
					if (labels.length == 1) //Only has feature group type name.
						caseFeatureGroupTypeExtendReference((FeatureGroupType) referencingObject, null, labels[0]);
					else
						//Has feature group type name and package name.  Example: "pkg::fgt".
						caseFeatureGroupTypeExtendReference((FeatureGroupType) referencingObject, labels[0], labels[1]);
					break;
				case FeatureGroupTypeInverseOfReference:
					if (labels.length == 1) //Only has feature group type name.
						caseFeatureGroupTypeInverseOfReference((FeatureGroupType) referencingObject, null, labels[0]);
					else
						//Has feature group type name and package name.  Example: "pkg::fgt".
						caseFeatureGroupTypeInverseOfReference((FeatureGroupType) referencingObject, labels[0],
								labels[1]);
					break;
				case FeatureGroupClassifierReference:
					caseFeatureGroupClassifierReference((FeatureGroup) referencingObject, labels[0], labels[1]);
					break;
				case FeatureGroupPrototypeOrClassifierReference:
					caseFeatureGroupPrototypeOrClassifierReference((FeatureGroup) referencingObject, labels[0]);
					break;
				case AccessFeatureClassifierReference:
					switch (((Access) referencingObject).getCategory()) {
					case BUS:
						caseAccessFeatureClassifierReference_BusAccess((BusAccess) referencingObject, labels[0],
								labels[1]);
						break;
					case DATA:
						caseAccessFeatureClassifierReference_DataAccess((DataAccess) referencingObject, labels[0],
								labels[1]);
						break;
					case SUBPROGRAM:
						caseAccessFeatureClassifierReference_SubprogramAccess((SubprogramAccess) referencingObject,
								labels[0], labels[1]);
						break;
					case SUBPROGRAM_GROUP:
						caseAccessFeatureClassifierReference_SubprogramGroupAccess(
								(SubprogramGroupAccess) referencingObject, labels[0], labels[1]);
						break;
					default:
						throw new AssertionError("Unexpected Enum Literal: "
								+ ((Access) referencingObject).getCategory());
					}
					break;
				case AccessFeaturePrototypeOrClassifierReference:
					caseAccessFeaturePrototypeOrClassifierReference((Access) referencingObject, labels[0]);
					break;
				case SubcomponentClassifierReference:
					if (labels.length == 1) //Only has classifier name.
						caseSubcomponentClassifierReference((Subcomponent) referencingObject, null, labels[0]);
					else
						//Has classifier name and package name.
						caseSubcomponentClassifierReference((Subcomponent) referencingObject, labels[0], labels[1]);
					break;
				case SubcomponentPrototypeOrClassifierReference:
					caseSubcomponentPrototypeOrClassifierReference((Subcomponent) referencingObject, labels[0]);
					break;
				case ParameterClassifierReference:
					caseParameterClassifierReference((Parameter) referencingObject, labels[0], labels[1]);
					break;
				case ParameterPrototypeOrClassifierReference:
					caseParameterPrototypeOrClassifierReference((Parameter) referencingObject, labels[0]);
					break;
				case PortClassifierReference:
					casePortClassifierReference((Port) referencingObject, labels[0], labels[1]);
					break;
				case PortPrototypeOrClassifierReference:
					casePortPrototypeOrClassifierReference((Port) referencingObject, labels[0]);
					break;
				case FeaturePrototypeClassifierReference:
					if (labels.length == 1) //Only has classifier name.
						caseFeaturePrototypeClassifierReference((FeaturePrototype) referencingObject, null, labels[0]);
					else
						//Has classifier name and package name.
						caseFeaturePrototypeClassifierReference((FeaturePrototype) referencingObject, labels[0],
								labels[1]);
					break;
				case ComponentPrototypeClassifierReference:
					if (labels.length == 1) //Only has classifier name.
						caseComponentPrototypeClassifierReference((ComponentPrototype) referencingObject, null,
								labels[0]);
					else
						//Has classifier name and package name.
						caseComponentPrototypeClassifierReference((ComponentPrototype) referencingObject, labels[0],
								labels[1]);
					break;
				case FeatureGroupPrototypeClassifierReference:
					if (labels.length == 1) //Only has feature group type name.
						caseFeatureGroupPrototypeClassifierReference((FeatureGroupPrototype) referencingObject, null,
								labels[0]);
					else
						//Has feature group type name and package name.
						caseFeatureGroupPrototypeClassifierReference((FeatureGroupPrototype) referencingObject,
								labels[0], labels[1]);
					break;
				case FeaturePortSpecificationClassifierReference:
					if (labels.length == 1) //Only has classifier name.
						caseFeaturePortSpecificationClassifierReference((PortSpecification) referencingObject, null,
								labels[0]);
					else
						//Has feature group type name and package name.
						caseFeaturePortSpecificationClassifierReference((PortSpecification) referencingObject,
								labels[0], labels[1]);
					break;
				case FeatureGroupTypeReference:
					if (labels.length == 1) //Only has feature group type name.
						caseFeatureGroupTypeReference((FeatureGroupReference) referencingObject, null, labels[0]);
					else
						//Has feature group type name and package name.
						caseFeatureGroupTypeReference((FeatureGroupReference) referencingObject, labels[0], labels[1]);
					break;
				case PrototypeOrFeatureGroupTypeReference:
					casePrototypeOrFeatureGroupTypeReference((FeatureGroupPrototypeBinding) referencingObject,
							labels[0]);
					break;
				case ClassifierReference:
					if (labels.length == 1) //Only has classifier name.
						caseClassifierReference((ComponentReference) referencingObject, null, labels[0]);
					else
						//Has classifier name and package name.
						caseClassifierReference((ComponentReference) referencingObject, labels[0], labels[1]);
					break;
				case PrototypeOrClassifierReference:
					casePrototypeOrClassifierReference((ComponentPrototypeBinding) referencingObject,
							(ComponentCategory) referenceRecord.getResolvedObjects().get(0), labels[0]);
					break;
				case PrototypeFormalReference:
					casePrototypeFormalReference((PrototypeBinding) referencingObject, labels[0]);
					break;
				case FeatureAccessSpecificationClassifierReference:
					if (labels.length == 1) //Only has classifier name.
						caseFeatureAccessSpecificationClassifierReference((AccessSpecification) referencingObject,
								null, labels[0]);
					else
						//Has classifier name and package name.
						caseFeatureAccessSpecificationClassifierReference((AccessSpecification) referencingObject,
								labels[0], labels[1]);
					break;
				case FeaturePrototypeReference:
					caseFeaturePrototypeReference((FeaturePrototypeReference) referencingObject, labels[0]);
					break;
				case FeatureClassifierReference:
					caseFeatureClassifierReference((AbstractFeature) referencingObject, labels[0], labels[1]);
					break;
				case FeatureClassifierOrPrototypeReference:
					caseFeatureClassifierOrPrototypeReference((AbstractFeature) referencingObject, labels[0]);
					break;
				case SourceModeReference:
					caseSourceModeReference((ModeTransition) referencingObject, labels[0]);
					break;
				case DestinationModeReference:
					caseDestinationModeReference((ModeTransition) referencingObject, labels[0]);
					break;
				case ModeOrTransitionReference:
					caseModeOrTransitionReference((ModalPath) referencingObject, labels[0]);
					break;
				case InModesReference:
					caseInModesReference((ModalElement) referencingObject, labels[0]);
					break;
				case BaseUnitIdentifierReference:
					caseBaseUnitIdentifierReference((UnitLiteral) referencingObject, labels[0]);
					break;
				case PropertyUnitsTypeReference:
					if (labels.length == 1) //Only has units type name.
						casePropertyUnitsTypeReference((NumberType) referencingObject, null, labels[0]);
					else
						//Has units type name and property set name.
						casePropertyUnitsTypeReference((NumberType) referencingObject, labels[0], labels[1]);
					break;
				case PropertyValuePropertyTypeReference:
					if (labels.length == 1) //Only has property type name.
						casePropertyValuePropertyTypeReference((Property) referencingObject, null, labels[0]);
					else
						//Has property type name and property set name.
						casePropertyValuePropertyTypeReference((Property) referencingObject, labels[0], labels[1]);
					break;
				case PropertyTypeReference:
					if (labels.length == 1) //Only has property type name.
						casePropertyTypeReference((TypedElement) referencingObject, null, labels[0]);
					else
						//Has property type name and property set name.
						casePropertyTypeReference((TypedElement) referencingObject, labels[0], labels[1]);
					break;
				case RangeTypePropertyTypeReference:
					if (labels.length == 1) //Only has number type name.
						caseRangeTypePropertyTypeReference((RangeType) referencingObject, null, labels[0]);
					else
						//Has number type name and property set name.
						caseRangeTypePropertyTypeReference((RangeType) referencingObject, labels[0], labels[1]);
					break;
				case IntegerRangeLowerBoundConstantReference:
					if (labels.length == 1) //Only has property constant name.
						caseIntegerRangeLowerBoundConstantReference((NumericRange) referencingObject, null, null,
								labels[0]);
					else if (labels.length == 2) {
						if (labels[0].equals("+") || labels[0].equals("-")) //Has sign and property constant name.
							caseIntegerRangeLowerBoundConstantReference((NumericRange) referencingObject, labels[0],
									null, labels[1]);
						else
							//Has property set name and property constant name.
							caseIntegerRangeLowerBoundConstantReference((NumericRange) referencingObject, null,
									labels[0], labels[1]);
					} else
						//Has sign, property set name, and property constant name.
						caseIntegerRangeLowerBoundConstantReference((NumericRange) referencingObject, labels[0],
								labels[1], labels[2]);
					break;
				case IntegerRangeUpperBoundConstantReference:
					if (labels.length == 1) //Only has property constant name.
						caseIntegerRangeUpperBoundConstantReference((NumericRange) referencingObject, null, null,
								labels[0]);
					else if (labels.length == 2) {
						if (labels[0].equals("+") || labels[0].equals("-")) //Has sign and property constant name.
							caseIntegerRangeUpperBoundConstantReference((NumericRange) referencingObject, labels[0],
									null, labels[1]);
						else
							//Has property set name and property constant name.
							caseIntegerRangeUpperBoundConstantReference((NumericRange) referencingObject, null,
									labels[0], labels[1]);
					} else
						//Has sign, property set name, and property constant name.
						caseIntegerRangeUpperBoundConstantReference((NumericRange) referencingObject, labels[0],
								labels[1], labels[2]);
					break;
				case RealRangeLowerBoundConstantReference:
					if (labels.length == 1) //Only has property constant name.
						caseRealRangeLowerBoundConstantReference((NumericRange) referencingObject, null, null,
								labels[0]);
					else if (labels.length == 2) {
						if (labels[0].equals("+") || labels[0].equals("-")) //Has sign and property constant name.
							caseRealRangeLowerBoundConstantReference((NumericRange) referencingObject, labels[0], null,
									labels[1]);
						else
							//Has property set name and property constant name.
							caseRealRangeLowerBoundConstantReference((NumericRange) referencingObject, null, labels[0],
									labels[1]);
					} else
						//Has sign, property set name, and property constant name.
						caseRealRangeLowerBoundConstantReference((NumericRange) referencingObject, labels[0],
								labels[1], labels[2]);
					break;
				case RealRangeUpperBoundConstantReference:
					if (labels.length == 1) //Only has property constant name.
						caseRealRangeUpperBoundConstantReference((NumericRange) referencingObject, null, null,
								labels[0]);
					else if (labels.length == 2) {
						if (labels[0].equals("+") || labels[0].equals("-")) //Has sign and property constant name.
							caseRealRangeUpperBoundConstantReference((NumericRange) referencingObject, labels[0], null,
									labels[1]);
						else
							//Has property set name and property constant name.
							caseRealRangeUpperBoundConstantReference((NumericRange) referencingObject, null, labels[0],
									labels[1]);
					} else
						//Has sign, property set name, and property constant name.
						caseRealRangeUpperBoundConstantReference((NumericRange) referencingObject, labels[0],
								labels[1], labels[2]);
					break;
				case PropertyDefinitionReference:
					if (labels.length == 1) //Only has property definition name.
						casePropertyDefinitionReference((PropertyAssociation) referencingObject, null, labels[0]);
					else
						//Has property definition name and property set name.
						casePropertyDefinitionReference((PropertyAssociation) referencingObject, labels[0], labels[1]);
					break;
				case PropertyRecordFieldReference:
					casePropertyRecordFieldReference((BasicPropertyAssociation) referencingObject, labels[0]);
					break;
				case PropertyUnitLiteralReference:
					casePropertyUnitLiteralReference((NumberValue) referencingObject, labels[0]);
					break;
				case PortRefinementReference:
					casePortRefinementReference((Port) referencingObject, labels[0]);
					break;
				case ComponentPrototypeRefinementReference:
					caseComponentPrototypeRefinementReference((ComponentPrototype) referencingObject, labels[0]);
					break;
				case FeaturePrototypeRefinementReference:
					caseFeaturePrototypeRefinementReference((FeaturePrototype) referencingObject, labels[0]);
					break;
				case FeatureGroupPrototypeRefinementReference:
					caseFeatureGroupPrototypeRefinementReference((FeatureGroupPrototype) referencingObject, labels[0]);
					break;
				case FeatureGroupRefinementReference:
					caseFeatureGroupRefinementReference((FeatureGroup) referencingObject, labels[0]);
					break;
				case AccessFeatureRefinementReference:
					caseAccessFeatureRefinementReference((Access) referencingObject, labels[0]);
					break;
				case ParameterRefinementReference:
					caseParameterRefinementReference((Parameter) referencingObject, labels[0]);
					break;
				case FlowSpecificationRefinementReference:
					caseFlowSpecificationRefinementReference((FlowSpecification) referencingObject, labels[0]);
					break;
				case SubcomponentRefinementReference:
					caseSubcomponentRefinementReference((Subcomponent) referencingObject, labels[0]);
					break;
				case EndToEndFlowRefinementReference:
					caseEndToEndFlowRefinementReference((EndToEndFlow) referencingObject, labels[0]);
					break;
				case ConnectionRefinementReference:
					caseConnectionRefinementReference((Connection) referencingObject, labels[0]);
					break;
				case PackageSubprogramCallReference:
					casePackageSubprogramCallReference((SubprogramCall) referencingObject, labels[0], labels[1]);
					break;
				case PackageAndContextSubprogramCallReference:
					casePackageAndContextSubprogramCallReference((SubprogramCall) referencingObject, labels[0],
							labels[1], labels[2]);
					break;
				case SubprogramCallReference:
					caseSubprogramCallReference((SubprogramCall) referencingObject, labels[0]);
					break;
				case ContextSubprogramCallReference:
					caseContextSubprogramCallReference((SubprogramCall) referencingObject, labels[0], labels[1]);
					break;
				case ModeTriggerFromExternalPortReference:
					caseModeTriggerFromExternalPortReference((TriggerPort) referencingObject, labels[0]);
					break;
				case ModeTriggerFromSubcomponentOrFeatureGroupReference:
					caseModeTriggerFromSubcomponentOrFeatureGroupReference((TriggerPort) referencingObject, labels[0],
							labels[1]);
					break;
				case PropertyOrConstantReference:
					if (labels.length == 2) {
						if (labels[0].equals("+") || labels[0].equals("-")) //Has sign and property name.
							casePropertyOrConstantReference(referencingObject, labels[0], null, labels[1]);
						else
							//Has property set name and property name.
							casePropertyOrConstantReference(referencingObject, null, labels[0], labels[1]);
					} else
						//Has sign, property set name, and property name.
						casePropertyOrConstantReference(referencingObject, labels[0], labels[1], labels[2]);
					break;
				case EnumerationLiteralOrPropertyOrConstantReference:
					caseEnumerationLiteralOrPropertyOrConstantReference(referencingObject, labels[0]);
					break;
				case FeatureGroupConnectionSourceContextReference:
					caseFeatureGroupConnectionSourceContextReference((FeatureGroupConnection) referencingObject,
							labels[0]);
					break;
				case FeatureGroupConnectionDestinationContextReference:
					caseFeatureGroupConnectionDestinationContextReference((FeatureGroupConnection) referencingObject,
							labels[0]);
					break;
				case FeatureGroupConnectionSourceReference:
					caseFeatureGroupConnectionSourceReference((FeatureGroupConnection) referencingObject, labels[0]);
					break;
				case FeatureGroupConnectionDestinationReference:
					caseFeatureGroupConnectionDestinationReference((FeatureGroupConnection) referencingObject,
							labels[0]);
					break;
				case FeatureConnectionSourceContextReference:
					caseFeatureConnectionSourceContextReference((FeatureConnection) referencingObject, labels[0]);
					break;
				case FeatureConnectionDestinationContextReference:
					caseFeatureConnectionDestinationContextReference((FeatureConnection) referencingObject, labels[0]);
					break;
				case FeatureConnectionSourceReference:
					caseFeatureConnectionSourceReference((FeatureConnection) referencingObject, labels[0]);
					break;
				case FeatureConnectionDestinationReference:
					caseFeatureConnectionDestinationReference((FeatureConnection) referencingObject, labels[0]);
					break;
				case AccessConnectionSourceContextReference:
					caseAccessConnectionSourceContextReference((AccessConnection) referencingObject, labels[0]);
					break;
				case AccessConnectionDestinationContextReference:
					caseAccessConnectionDestinationContextReference((AccessConnection) referencingObject, labels[0]);
					break;
				case AccessConnectionSourceReference:
					caseAccessConnectionSourceReference((AccessConnection) referencingObject, labels[0]);
					break;
				case AccessConnectionDestinationReference:
					caseAccessConnectionDestinationReference((AccessConnection) referencingObject, labels[0]);
					break;
				case ParameterConnectionSourceContextReference:
					caseParameterConnectionSourceContextReference((ParameterConnection) referencingObject, labels[0]);
					break;
				case ParameterConnectionDestinationContextReference:
					caseParameterConnectionDestinationContextReference((ParameterConnection) referencingObject,
							labels[0]);
					break;
				case ParameterConnectionSourceReference:
					caseParameterConnectionSourceReference((ParameterConnection) referencingObject, labels[0]);
					break;
				case ParameterConnectionDestinationReference:
					caseParameterConnectionDestinationReference((ParameterConnection) referencingObject, labels[0]);
					break;
				case PortConnectionSourceContextReference:
					casePortConnectionSourceContextReference((PortConnection) referencingObject, labels[0]);
					break;
				case PortConnectionDestinationContextReference:
					casePortConnectionDestinationContextReference((PortConnection) referencingObject, labels[0]);
					break;
				case PortConnectionSourcePortReference:
					casePortConnectionSourcePortReference((PortConnection) referencingObject, labels[0]);
					break;
				case PortConnectionDestinationPortReference:
					casePortConnectionDestinationPortReference((PortConnection) referencingObject, labels[0]);
					break;
				case FlowSpecificationInFeatureReference:
					if (labels.length == 1) //Only has feature name.
						caseFlowSpecificationInFeatureReference((FlowSpecification) referencingObject, null, labels[0]);
					else
						//Has feature group name and feature name.
						caseFlowSpecificationInFeatureReference((FlowSpecification) referencingObject, labels[0],
								labels[1]);
					break;
				case FlowSpecificationOutFeatureReference:
					if (labels.length == 1) //Only has feature name.
						caseFlowSpecificationOutFeatureReference((FlowSpecification) referencingObject, null, labels[0]);
					else
						//Has feature group name and feature name.
						caseFlowSpecificationOutFeatureReference((FlowSpecification) referencingObject, labels[0],
								labels[1]);
					break;
				case FlowImplementationSpecificationReference:
					caseFlowImplementationSpecificationReference((FlowImplementation) referencingObject, labels[0]);
					break;
				case FlowImplementationConnectionReference:
					caseFlowImplementationConnectionReference((StructuralFeature) referencingObject, labels[0]);
					break;
				case FlowImplementationFlowElementReference:
					if (labels.length == 1) //Only has flow element name.
						caseFlowImplementationFlowElementReference((StructuralFeature) referencingObject, null,
								labels[0]);
					else
						//Has context name and flow element name.
						caseFlowImplementationFlowElementReference((StructuralFeature) referencingObject, labels[0],
								labels[1]);
					break;
				case FlowImplementationInFeatureReference:
					if (labels.length == 1) //Only has feature name.
						caseFlowImplementationInFeatureReference((FlowImplementation) referencingObject, null,
								labels[0]);
					else
						//Has context name and feature name.
						caseFlowImplementationInFeatureReference((FlowImplementation) referencingObject, labels[0],
								labels[1]);
					break;
				case FlowImplementationOutFeatureReference:
					if (labels.length == 1) //Only has feature name.
						caseFlowImplementationOutFeatureReference((FlowImplementation) referencingObject, null,
								labels[0]);
					else
						//Has context name and feature name.
						caseFlowImplementationOutFeatureReference((FlowImplementation) referencingObject, labels[0],
								labels[1]);
					break;
				case ModeMappingReference:
					caseModeMappingReference((Subcomponent) referencingObject, labels[0], labels[1]);
					break;
				case PropertyAssociationInBindingReference:
					if (labels.length == 1) //Only has classifier name.
						casePropertyAssociationInBindingReference((PropertyAssociation) referencingObject, null,
								labels[0]);
					else
						//Has package name and classifier name.
						casePropertyAssociationInBindingReference((PropertyAssociation) referencingObject, labels[0],
								labels[1]);
					break;
				case ContainedPathElementReference:
					caseContainedPathElementReference((ContainmentPathElement) referencingObject, labels[0]);
					break;
				case ArrayElementClassifierReference:
					if (labels.length == 1) //Only has component implementation name.
						caseArrayElementClassifierReference((ComponentImplementationReference) referencingObject, null,
								labels[0]);
					else
						//Has package name and component implementation name.
						caseArrayElementClassifierReference((ComponentImplementationReference) referencingObject,
								labels[0], labels[1]);
					break;
				case AbstractFeatureRefinementReference:
					caseAbstractFeatureRefinementReference((AbstractFeature) referencingObject, labels[0]);
					break;
				case BooleanOrConstantPropertyOrConstantReference:
					caseBooleanOrConstantPropertyOrConstantReference((ConstantValue) referencingObject, labels[0],
							labels[1]);
					break;
				case BooleanOrConstantEnumerationLiteralOrPropertyOrConstantReference:
					caseBooleanOrConstantEnumerationLiteralOrPropertyOrConstantReference(
							(ConstantValue) referencingObject, labels[0]);
					break;
				case ClassifierValueComponentTypeReference:
					if (labels.length == 1) //Only has type name.
						casePropertyOwnerComponentTypeReference((ClassifierValue) referencingObject, null, labels[0]);
					else
						//Has package name and type name.
						casePropertyOwnerComponentTypeReference((ClassifierValue) referencingObject, labels[0],
								labels[1]);
					break;
				case ClassifierValueComponentImplementationReference:
					if (labels.length == 2) //Only has type name and implementation name.
						casePropertyOwnerComponentImplementationReference((ClassifierValue) referencingObject, null,
								labels[0], labels[1]);
					else //Has package name, type name, and implementation name.
					{
						casePropertyOwnerComponentImplementationReference((ClassifierValue) referencingObject,
								labels[0], labels[1], labels[2]);
					}
					break;
				case DimensionPropertyReference:
					if (labels.length == 1) //Only has constant or definition name.
						caseDimensionPropertyReference((ArraySpecification) referencingObject, null, labels[0]);
					else
						//Has property set name and constant or definition name.
						caseDimensionPropertyReference((ArraySpecification) referencingObject, labels[0], labels[1]);
					break;
				case LowerBoundPropertyConstantReference:
					if (labels.length == 1) //Only has property constant name.
						caseLowerBoundPropertyConstantReference((RangeValue) referencingObject, null, null, labels[0]);
					else if (labels.length == 2) {
						if (labels[0].equals("+") || labels[0].equals("-")) //Has sign and property constant name.
							caseLowerBoundPropertyConstantReference((RangeValue) referencingObject, labels[0], null,
									labels[1]);
						else
							//Has property set name and property constant name.
							caseLowerBoundPropertyConstantReference((RangeValue) referencingObject, null, labels[0],
									labels[1]);
					} else
						//Has sign, property set name, and property constant name.
						caseLowerBoundPropertyConstantReference((RangeValue) referencingObject, labels[0], labels[1],
								labels[2]);
					break;
				case UpperBoundPropertyConstantReference:
					if (labels.length == 1) //Only has property constant name.
						caseUpperBoundPropertyConstantReference((RangeValue) referencingObject, null, null, labels[0]);
					else if (labels.length == 2) {
						if (labels[0].equals("+") || labels[0].equals("-")) //Has sign and property constant name.
							caseUpperBoundPropertyConstantReference((RangeValue) referencingObject, labels[0], null,
									labels[1]);
						else
							//Has property set name and property constant name.
							caseUpperBoundPropertyConstantReference((RangeValue) referencingObject, null, labels[0],
									labels[1]);
					} else
						//Has sign, property set name, and property constant name.
						caseUpperBoundPropertyConstantReference((RangeValue) referencingObject, labels[0], labels[1],
								labels[2]);
					break;
				case DeltaPropertyConstantReference:
					if (labels.length == 1) //Only has property constant name.
						caseDeltaPropertyConstantReference((RangeValue) referencingObject, null, null, labels[0]);
					else if (labels.length == 2) {
						if (labels[0].equals("+") || labels[0].equals("-")) //Has sign and property constant name.
							caseDeltaPropertyConstantReference((RangeValue) referencingObject, labels[0], null,
									labels[1]);
						else
							//Has property set name and property constant name.
							caseDeltaPropertyConstantReference((RangeValue) referencingObject, null, labels[0],
									labels[1]);
					} else
						//Has sign, property set name, and property constant name.
						caseDeltaPropertyConstantReference((RangeValue) referencingObject, labels[0], labels[1],
								labels[2]);
					break;

				case AnnexElementReference:
				case ModeTriggerFromProcessorReference:
				case ModeTriggerFromSelfReference:
				case ProcessorSubprogramCallReference:
				case RefinementReference:
					//Do nothing.  See comments on the reference types to see why nothing is done.
					break;
				default:
					errManager.internalError("Unaccounted for reference type: " + referenceType.name());
				}
				if (numberOfErrors != errManager.getNumErrors())
					referenceTypesWithErrors.add(referenceType);
			}
		}
	}

	private void caseWithStatementReference_PackageSection(PackageSection packageSection,
			String importedPackageSectionOrPropertySetName) {
		NamedElement searchResult = OsateResourceManager
				.findPackageOrPropertySet(importedPackageSectionOrPropertySetName);
		if (searchResult instanceof AadlPackage)
			packageSection.getImportedPackages().add((AadlPackage) searchResult);
		else if (searchResult instanceof PropertySet)
			packageSection.getImportedPropertySets().add((PropertySet) searchResult);
		else
			//searchResult should be null.  If it is not, then OsateResourceManager.findPackageOrPropertySet() is broken.
			errManager.error(packageSection, "Package or property set '" + importedPackageSectionOrPropertySetName
					+ "' not found");
	}

	private void caseWithStatementReference_PropertySet(PropertySet propertySet,
			String importedPackageSectionOrPropertySetName) {
		NamedElement searchResult = OsateResourceManager
				.findPackageOrPropertySet(importedPackageSectionOrPropertySetName);
		if (searchResult instanceof AadlPackage)
			propertySet.getImportedPackages().add((AadlPackage) searchResult);
		else if (searchResult instanceof PropertySet)
			propertySet.getImportedPropertySets().add((PropertySet) searchResult);
		else
			//searchResult should be null.  If it is not, then OsateResourceManager.findPackageOrPropertySet() is broken.
			errManager.error(propertySet, "Package or property set '" + importedPackageSectionOrPropertySetName
					+ "' not found");
	}

	//TODO: Check for naming conflicts.
	private void casePackageRenameReference(PackageRename packageRename, String renamedPackageName) {
		AadlPackage importedPackage = findImportedPackage(renamedPackageName,
				getContainingPackageSection(packageRename));
		if (importedPackage != null)
			packageRename.setRenamedPackage(importedPackage);
		else
			errManager.error(packageRename, "Package '" + renamedPackageName + "' is not declared in a with statement");
	}

	//TODO: Check for naming conflicts.
	private void caseRenamesAll(PackageRename packageRename, String renamedPackageName) {
		AadlPackage importedPackage = findImportedPackage(renamedPackageName,
				getContainingPackageSection(packageRename));
		if (importedPackage != null)
			packageRename.setRenamedPackage(importedPackage);
		else
			errManager.error(packageRename, "Package '" + renamedPackageName + "' is not declared in a with statement");
	}

	//TODO: Check for naming conflicts.
	private void caseComponentTypeRename(ComponentTypeRename componentTypeRename, String packageName,
			String componentTypeName) {
		AadlPackage importedPackage = findImportedPackage(packageName, getContainingPackageSection(componentTypeRename));
		if (importedPackage != null) {
			PublicPackageSection publicSection = importedPackage.getPublicSection();
			if (publicSection != null) {
				NamedElement member = publicSection.findNamedElement(componentTypeName, true);
				if (member instanceof ComponentType) {
					componentTypeRename.setRenamedComponentType((ComponentType) member);
					return;
				} else if (member != null) {
					errManager.error(componentTypeRename, '\'' + packageName + "::" + componentTypeName
							+ "' is not a component type");
					return;
				}
			}
			errManager.error(componentTypeRename,
					capitalizeFirstLetterOnly(componentTypeRename.getCategory().getName()) + " '" + packageName + "::"
							+ componentTypeName + "' not found");
		} else
			errManager.error(componentTypeRename, "Package '" + packageName + "' is not declared in a with statement");
	}

	//TODO: Check for naming conflicts.
	private void caseFeatureGroupTypeRename(FeatureGroupTypeRename featureGroupTypeRename, String packageName,
			String featureGroupTypeName) {
		AadlPackage importedPackage = findImportedPackage(packageName,
				getContainingPackageSection(featureGroupTypeRename));
		if (importedPackage != null) {
			PublicPackageSection publicSection = importedPackage.getPublicSection();
			if (publicSection != null) {
				NamedElement member = publicSection.findNamedElement(featureGroupTypeName, true);
				if (member instanceof FeatureGroupType) {
					featureGroupTypeRename.setRenamedFeatureGroupType((FeatureGroupType) member);
					return;
				} else if (member != null) {
					errManager.error(featureGroupTypeRename, '\'' + packageName + "::" + featureGroupTypeName
							+ "' is not a feature group type");
					return;
				}
			}
			errManager.error(featureGroupTypeRename, "Feature group type '" + packageName + "::" + featureGroupTypeName
					+ "' not found");
		} else
			errManager.error(featureGroupTypeRename, "Package '" + packageName
					+ "' is not declared in a with statement");
	}

	private void caseRealizationReference(Realization realization, String componentTypeName) {
		ComponentImplementation implementation = (ComponentImplementation) realization.eContainer();
		NamedElement searchResult = findNamedElementInAadlPackage(componentTypeName,
				getContainingPackageSection(implementation));
		if (searchResult instanceof ComponentType)
			realization.setImplemented((ComponentType) searchResult);
		else if (searchResult != null)
			errManager.error(realization, '\'' + componentTypeName + "' is not a component type");
		else {
			errManager.error(realization, capitalizeFirstLetterOnly(implementation.getCategory()) + " type '"
					+ componentTypeName + "' not found");
		}
	}

	//TODO: Check for cycles.
	//TODO: What should we do if the parent is abstract and the child is not abstract and the
	//		parent contains items that cannot exist in the child?
	private void caseComponentTypeExtensionReference(ComponentType extendingComponentType, String packageName,
			String extendedComponentTypeName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, extendedComponentTypeName,
				getContainingPackageSection(extendingComponentType));
		if (searchResult instanceof ComponentType) {
			TypeExtension ext = aadl2Factory.createTypeExtension();

			ext.setExtended((ComponentType) searchResult);
			extendingComponentType.setOwnedExtension(ext);
		} else if (searchResult != null) {
			errManager.error(extendingComponentType, '\'' + getQualifiedName(packageName, extendedComponentTypeName)
					+ "' is not a component type");
		} else
			errManager.error(extendingComponentType, '\'' + getQualifiedName(packageName, extendedComponentTypeName)
					+ "' not found");
	}

	//TODO: Check for cycles.
	//TODO: The standard states that "In a component implementation extension, the component type
	//		identifier of the component implementation being extended, which appears after the
	//		reserved word extends, must be the same as or an ancestor of the component type of
	//		the extension."  Check this.
	//TODO: What should we do if the parent is abstract and the child is not abstract and the
	//		parent contains items that cannot exist in the child?
	//TODO: Check for name conflicts from extension and type.  Example:
	//
	//		abstract a
	//		end a;
	//
	//		abstract a2 extends a
	//		features
	//			f: in event port;
	//		end a2;
	//
	//		abstract implementation a.i
	//		subcomponents
	//			f: data d;
	//		end a.i;
	//
	//		abstract implementation a2.i extends a.i
	//		end a2.i;
	//
	//		There should be an error on a2.i because it inherits f from a2 and from a.i.
	//		Another example:
	//
	//		abstract a
	//		prototypes
	//			p: feature;
	//		end a;
	//
	//		abstract a2 extends a (p => in event port)
	//		end a2;
	//
	//		abstract implementation a.i
	//		end a.i;
	//
	//		abstract implementation a.i2 extends a.i (p => in event port)
	//		end a.i2;
	//
	//		abstract implementation a2.i extends a.i2
	//		end a2.i;
	//
	//		There should be an error on a2.i because there are multiple bindings on the prototyep p.
	private void caseComponentImplementationExtensionReference(ImplementationExtension implementationExtension,
			String packageName, String extendedComponentImplementationName) {
		ComponentImplementation extendingComponentImplementation = (ComponentImplementation) implementationExtension
				.eContainer();
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, extendedComponentImplementationName,
				getContainingPackageSection(extendingComponentImplementation));
		if (searchResult instanceof ComponentImplementation) {
			implementationExtension.setExtended((ComponentImplementation) searchResult);
		} else if (searchResult != null) {
			errManager.error(implementationExtension,
					'\'' + getQualifiedName(packageName, extendedComponentImplementationName)
							+ "' is not a component implementation");
		} else {
			errManager.error(implementationExtension,
					'\'' + getQualifiedName(packageName, extendedComponentImplementationName) + "' not found");
		}
	}

	//TODO: Check for cycles.
	private void caseFeatureGroupTypeExtendReference(FeatureGroupType extendingFeatureGroupType, String packageName,
			String extendedFeatureGroupTypeName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, extendedFeatureGroupTypeName,
				getContainingPackageSection(extendingFeatureGroupType));
		if (searchResult instanceof FeatureGroupType) {
			GroupExtension ext = aadl2Factory.createGroupExtension();

			ext.setExtended((FeatureGroupType) searchResult);
			extendingFeatureGroupType.setOwnedExtension(ext);
		} else if (searchResult != null) {
			errManager.error(extendingFeatureGroupType,
					"Cannot extend '" + getQualifiedName(packageName, extendedFeatureGroupTypeName) + '\'');
		} else
			errManager.error(extendingFeatureGroupType,
					'\'' + getQualifiedName(packageName, extendedFeatureGroupTypeName) + "' not found");
	}

	private void caseFeatureGroupTypeInverseOfReference(FeatureGroupType invertedFeatureGroupType, String packageName,
			String originalFeatureGroupTypeName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, originalFeatureGroupTypeName,
				getContainingPackageSection(invertedFeatureGroupType));
		if (searchResult instanceof FeatureGroupType)
			invertedFeatureGroupType.setInverse((FeatureGroupType) searchResult);
		else if (searchResult != null) {
			errManager.error(invertedFeatureGroupType,
					'\'' + getQualifiedName(packageName, originalFeatureGroupTypeName)
							+ "' is not a feature group type");
		} else
			errManager.error(invertedFeatureGroupType,
					'\'' + getQualifiedName(packageName, originalFeatureGroupTypeName) + "' not found");
	}

	private void caseFeatureGroupClassifierReference(FeatureGroup featureGroup, String packageName,
			String featureGroupTypeName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, featureGroupTypeName,
				getContainingPackageSection(featureGroup));
		if (searchResult instanceof FeatureGroupType)
			featureGroup.setFeatureGroupType((FeatureGroupType) searchResult);
		else if (searchResult != null)
			errManager.error(featureGroup, '\'' + getQualifiedName(packageName, featureGroupTypeName)
					+ "' is not a feature group type");
		else
			errManager.error(featureGroup, '\'' + getQualifiedName(packageName, featureGroupTypeName) + "' not found");
	}

	private void caseFeatureGroupPrototypeOrClassifierReference(FeatureGroup featureGroup,
			String prototypeOrFeatureGroupTypeName) {
		NamedElement searchResult = getContainingClassifier(featureGroup).findNamedElement(
				prototypeOrFeatureGroupTypeName);
		if (searchResult instanceof Prototype)
			featureGroup.setPrototype((Prototype) searchResult);
		else
			caseFeatureGroupClassifierReference(featureGroup, null, prototypeOrFeatureGroupTypeName);
	}

	private void caseAccessFeatureClassifierReference_BusAccess(BusAccess busAccess, String packageName,
			String classifierName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, classifierName,
				getContainingPackageSection(busAccess));
		if (searchResult instanceof BusClassifier)
			busAccess.setBusClassifier((BusClassifier) searchResult);
		else if (searchResult != null)
			errManager.error(busAccess, '\'' + getQualifiedName(packageName, classifierName)
					+ "' is not a bus classifier");
		else
			errManager.error(busAccess, '\'' + getQualifiedName(packageName, classifierName) + "' not found");
	}

	private void caseAccessFeatureClassifierReference_DataAccess(DataAccess dataAccess, String packageName,
			String classifierName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, classifierName,
				getContainingPackageSection(dataAccess));
		if (searchResult instanceof DataClassifier)
			dataAccess.setDataClassifier((DataClassifier) searchResult);
		else if (searchResult != null)
			errManager.error(dataAccess, '\'' + getQualifiedName(packageName, classifierName)
					+ "' is not a data classifier");
		else
			errManager.error(dataAccess, '\'' + getQualifiedName(packageName, classifierName) + "' not found");
	}

	private void caseAccessFeatureClassifierReference_SubprogramAccess(SubprogramAccess subprogramAccess,
			String packageName, String classifierName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, classifierName,
				getContainingPackageSection(subprogramAccess));
		if (searchResult instanceof SubprogramClassifier)
			subprogramAccess.setSubprogramClassifier((SubprogramClassifier) searchResult);
		else if (searchResult != null)
			errManager.error(subprogramAccess, '\'' + getQualifiedName(packageName, classifierName)
					+ "' is not a subprogram classifier");
		else
			errManager.error(subprogramAccess, '\'' + getQualifiedName(packageName, classifierName) + "' not found");
	}

	private void caseAccessFeatureClassifierReference_SubprogramGroupAccess(
			SubprogramGroupAccess subprogramGroupAccess, String packageName, String classifierName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, classifierName,
				getContainingPackageSection(subprogramGroupAccess));
		if (searchResult instanceof SubprogramGroupClassifier)
			subprogramGroupAccess.setSubprogramGroupClassifier((SubprogramGroupClassifier) searchResult);
		else if (searchResult != null) {
			errManager.error(subprogramGroupAccess, '\'' + getQualifiedName(packageName, classifierName)
					+ "' is not a subprogram group classifier");
		} else
			errManager.error(subprogramGroupAccess, '\'' + getQualifiedName(packageName, classifierName)
					+ "' not found");
	}

	private void caseAccessFeaturePrototypeOrClassifierReference(Access accessFeature, String prototypeOrClassifierName) {
		NamedElement searchResult = getContainingClassifier(accessFeature).findNamedElement(prototypeOrClassifierName);
		if (searchResult instanceof Prototype)
			accessFeature.setPrototype((Prototype) searchResult);
		else {
			switch (accessFeature.getCategory()) {
			case BUS:
				caseAccessFeatureClassifierReference_BusAccess((BusAccess) accessFeature, null,
						prototypeOrClassifierName);
				break;
			case DATA:
				caseAccessFeatureClassifierReference_DataAccess((DataAccess) accessFeature, null,
						prototypeOrClassifierName);
				break;
			case SUBPROGRAM:
				caseAccessFeatureClassifierReference_SubprogramAccess((SubprogramAccess) accessFeature, null,
						prototypeOrClassifierName);
				break;
			case SUBPROGRAM_GROUP:
				caseAccessFeatureClassifierReference_SubprogramGroupAccess((SubprogramGroupAccess) accessFeature, null,
						prototypeOrClassifierName);
				break;
			default:
				throw new AssertionError("Unexpected Enum Literal: " + accessFeature.getCategory());
			}
		}
	}

	//TODO: Check for cycles.
	private void caseSubcomponentClassifierReference(Subcomponent subcomponent, String packageName,
			String classifierName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, classifierName,
				getContainingPackageSection(subcomponent));
		if (searchResult instanceof AbstractClassifier)
			subcomponent.setAbstractClassifier((AbstractClassifier) searchResult);
		else if (searchResult instanceof ComponentClassifier) {
			String classifierCategory = ((ComponentClassifier) searchResult).getCategory();
			String subcomponentCategory = subcomponent.getCategory().getName();
			if (subcomponentCategory.equals(classifierCategory)) {
				switch (subcomponent.getCategory()) {
				case BUS:
					((BusSubcomponent) subcomponent).setBusClassifier((BusClassifier) searchResult);
					break;
				case DATA:
					((DataSubcomponent) subcomponent).setDataClassifier((DataClassifier) searchResult);
					break;
				case DEVICE:
					((DeviceSubcomponent) subcomponent).setDeviceClassifier((DeviceClassifier) searchResult);
					break;
				case MEMORY:
					((MemorySubcomponent) subcomponent).setMemoryClassifier((MemoryClassifier) searchResult);
					break;
				case PROCESS:
					((ProcessSubcomponent) subcomponent).setProcessClassifier((ProcessClassifier) searchResult);
					break;
				case PROCESSOR:
					((ProcessorSubcomponent) subcomponent).setProcessorClassifier((ProcessorClassifier) searchResult);
					break;
				case SUBPROGRAM:
					((SubprogramSubcomponent) subcomponent)
							.setSubprogramClassifier((SubprogramClassifier) searchResult);
					break;
				case SUBPROGRAM_GROUP:
					((SubprogramGroupSubcomponent) subcomponent)
							.setSubprogramGroupClassifier((SubprogramGroupClassifier) searchResult);
					break;
				case SYSTEM:
					((SystemSubcomponent) subcomponent).setSystemClassifier((SystemClassifier) searchResult);
					break;
				case THREAD:
					((ThreadSubcomponent) subcomponent).setThreadClassifier((ThreadClassifier) searchResult);
					break;
				case THREAD_GROUP:
					((ThreadGroupSubcomponent) subcomponent)
							.setThreadGroupClassifier((ThreadGroupClassifier) searchResult);
					break;
				case VIRTUAL_BUS:
					((VirtualBusSubcomponent) subcomponent)
							.setVirtualBusClassifier((VirtualBusClassifier) searchResult);
					break;
				case VIRTUAL_PROCESSOR:
					((VirtualProcessorSubcomponent) subcomponent)
							.setVirtualProcessorClassifier((VirtualProcessorClassifier) searchResult);
					break;
				//Should not be Abstract.
				default:
					throw new AssertionError("Unexpected enum literal: " + subcomponent.getCategory());
				}
			} else {
				errManager.error(subcomponent, '\'' + getQualifiedName(packageName, classifierName)
						+ "' is not an abstract or " + subcomponentCategory + " classifier");
			}
		} else if (searchResult != null) {
			errManager.error(subcomponent, '\'' + getQualifiedName(packageName, classifierName)
					+ "' is not an abstract or " + subcomponent.getCategory() + " classifier");
		} else
			errManager.error(subcomponent, '\'' + getQualifiedName(packageName, classifierName) + "' not found");
	}

	private void caseSubcomponentPrototypeOrClassifierReference(Subcomponent subcomponent,
			String prototypeOrClassifierName) {
		NamedElement searchResult = getContainingClassifier(subcomponent).findNamedElement(prototypeOrClassifierName);
		if (searchResult instanceof ComponentPrototype)
			subcomponent.setPrototype((ComponentPrototype) searchResult);
		else if (searchResult != null && !searchResult.equals(subcomponent))
			errManager.error(subcomponent, '\'' + prototypeOrClassifierName + "' is not a component prototype");
		else
			caseSubcomponentClassifierReference(subcomponent, null, prototypeOrClassifierName);
	}

	private void caseParameterClassifierReference(Parameter parameter, String packageName, String classifierName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, classifierName,
				getContainingPackageSection(parameter));
		if (searchResult instanceof DataClassifier)
			parameter.setDataClassifier((DataClassifier) searchResult);
		else if (searchResult != null)
			errManager.error(parameter, '\'' + getQualifiedName(packageName, classifierName)
					+ "' is not a data classifier");
		else
			errManager.error(parameter, '\'' + getQualifiedName(packageName, classifierName) + "' not found");
	}

	private void caseParameterPrototypeOrClassifierReference(Parameter parameter, String prototypeOrClassifierName) {
		NamedElement searchResult = getContainingClassifier(parameter).findNamedElement(prototypeOrClassifierName);
		if (searchResult instanceof Prototype)
			parameter.setPrototype((Prototype) searchResult);
		else
			caseParameterClassifierReference(parameter, null, prototypeOrClassifierName);
	}

	private void casePortClassifierReference(Port port, String packageName, String classifierName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, classifierName,
				getContainingPackageSection(port));
		if (searchResult instanceof DataClassifier) {
			if (port instanceof DataPort)
				((DataPort) port).setDataClassifier((DataClassifier) searchResult);
			else
				((EventDataPort) port).setDataClassifier((DataClassifier) searchResult);
		} else if (searchResult != null)
			errManager.error(port, '\'' + getQualifiedName(packageName, classifierName) + "' is not a data classifier");
		else
			errManager.error(port, '\'' + getQualifiedName(packageName, classifierName) + "' not found");
	}

	private void casePortPrototypeOrClassifierReference(Port port, String prototypeOrClassifierName) {
		NamedElement searchResult = getContainingClassifier(port).findNamedElement(prototypeOrClassifierName);
		if (searchResult instanceof Prototype)
			port.setPrototype((Prototype) searchResult);
		else
			casePortClassifierReference(port, null, prototypeOrClassifierName);
	}

	private void caseFeaturePrototypeClassifierReference(FeaturePrototype prototype, String packageName,
			String classifierName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, classifierName,
				getContainingPackageSection(prototype));
		if (searchResult instanceof ComponentClassifier)
			prototype.setConstrainingClassifier((ComponentClassifier) searchResult);
		else if (searchResult != null)
			errManager.error(prototype, '\'' + getQualifiedName(packageName, classifierName)
					+ "' is not a component classifier");
		else
			errManager.error(prototype, '\'' + getQualifiedName(packageName, classifierName) + "' not found");
	}

	private void caseComponentPrototypeClassifierReference(ComponentPrototype prototype, String packageName,
			String classifierName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, classifierName,
				getContainingPackageSection(prototype));
		if (searchResult instanceof ComponentClassifier)
			prototype.setConstrainingClassifier((ComponentClassifier) searchResult);
		else if (searchResult != null)
			errManager.error(prototype, '\'' + getQualifiedName(packageName, classifierName)
					+ "' is not a component classifier");
		else
			errManager.error(prototype, '\'' + getQualifiedName(packageName, classifierName) + "' not found");
	}

	private void caseFeatureGroupPrototypeClassifierReference(FeatureGroupPrototype prototype, String packageName,
			String featureGroupTypeName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, featureGroupTypeName,
				getContainingPackageSection(prototype));
		if (searchResult instanceof FeatureGroupType)
			prototype.setConstrainingFeatureGroupType((FeatureGroupType) searchResult);
		else if (searchResult != null)
			errManager.error(prototype, '\'' + getQualifiedName(packageName, featureGroupTypeName)
					+ "' is not a feature group type");
		else
			errManager.error(prototype, '\'' + getQualifiedName(packageName, featureGroupTypeName) + "' not found");
	}

	private void caseFeaturePortSpecificationClassifierReference(PortSpecification portSpecification,
			String packageName, String classifierName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, classifierName,
				getContainingPackageSection(portSpecification));
		if (searchResult instanceof ComponentClassifier)
			portSpecification.setClassifier((ComponentClassifier) searchResult);
		else if (searchResult != null)
			errManager.error(portSpecification, '\'' + getQualifiedName(packageName, classifierName)
					+ "' is not a component classifier");
		else
			errManager.error(portSpecification, '\'' + getQualifiedName(packageName, classifierName) + "' not found");
	}

	private void caseFeatureGroupTypeReference(FeatureGroupReference featureGroupReference, String packageName,
			String featureGroupTypeName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, featureGroupTypeName,
				getContainingPackageSection(featureGroupReference));
		if (searchResult instanceof FeatureGroupType)
			featureGroupReference.setFeatureGroupType((FeatureGroupType) searchResult);
		else if (searchResult != null) {
			errManager.error(featureGroupReference, '\'' + getQualifiedName(packageName, featureGroupTypeName)
					+ "' is not a feature group type");
		} else
			errManager.error(featureGroupReference, '\'' + getQualifiedName(packageName, featureGroupTypeName)
					+ "' not found");
	}

	private void casePrototypeOrFeatureGroupTypeReference(FeatureGroupPrototypeBinding prototypeBinding,
			String prototypeOrFeatureGroupTypeName) {
		NamedElement searchResult = getContainingClassifier(prototypeBinding).findNamedElement(
				prototypeOrFeatureGroupTypeName);
		if (searchResult instanceof FeatureGroupPrototype) {
			FeatureGroupPrototypeReference prototypeReference = (FeatureGroupPrototypeReference) prototypeBinding
					.createActual(aadl2Package.getFeatureGroupPrototypeReference());
			prototypeReference.setPrototype((FeatureGroupPrototype) searchResult);
		} else if (searchResult != null)
			errManager.error(prototypeBinding, '\'' + prototypeOrFeatureGroupTypeName
					+ "' is not a feature group prototype");
		else {
			FeatureGroupReference featureGroupReference = (FeatureGroupReference) prototypeBinding
					.createActual(aadl2Package.getFeatureGroupReference());
			caseFeatureGroupTypeReference(featureGroupReference, null, prototypeOrFeatureGroupTypeName);
		}
	}

	private void caseClassifierReference(ComponentReference componentReference, String packageName,
			String classifierName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, classifierName,
				getContainingPackageSection(componentReference));
		if (searchResult instanceof ComponentClassifier)
			componentReference.setClassifier((ComponentClassifier) searchResult);
		else if (searchResult != null)
			errManager.error(componentReference, '\'' + getQualifiedName(packageName, classifierName)
					+ "' is not a component classifier");
		else
			errManager.error(componentReference, '\'' + getQualifiedName(packageName, classifierName) + "' not found");
	}

	private void casePrototypeOrClassifierReference(ComponentPrototypeBinding prototypeBinding,
			ComponentCategory componentCategory, String prototypeOrClassifierName) {
		NamedElement searchResult = getContainingClassifier(prototypeBinding).findNamedElement(
				prototypeOrClassifierName);
		if (searchResult instanceof ComponentPrototype) {
			ComponentPrototypeReference prototypeReference = (ComponentPrototypeReference) prototypeBinding
					.createActual(aadl2Package.getComponentPrototypeReference());
			prototypeReference.setPrototype((ComponentPrototype) searchResult);
			prototypeReference.setCategory(componentCategory);
		} else if (searchResult != null)
			errManager.error(prototypeBinding, '\'' + prototypeOrClassifierName + "' is not a component prototype");
		else {
			ComponentReference componentReference = (ComponentReference) prototypeBinding.createActual(aadl2Package
					.getComponentReference());
			componentReference.setCategory(componentCategory);
			caseClassifierReference(componentReference, null, prototypeOrClassifierName);
		}
	}

	private void casePrototypeFormalReference(PrototypeBinding prototypeBinding, String prototypeName) {
		Classifier prototypeOwner;
		Element owner = prototypeBinding.getOwner();
		if (owner instanceof ComponentType)
			prototypeOwner = ((ComponentType) owner).getExtended();
		else if (owner instanceof ComponentImplementation)
			prototypeOwner = ((ComponentImplementation) owner).getExtended();
		else if (owner instanceof FeatureGroupType)
			prototypeOwner = ((FeatureGroupType) owner).getExtended();
		else if (owner instanceof Subcomponent)
			prototypeOwner = ((Subcomponent) owner).getClassifier();
		else if (owner instanceof ComponentImplementationReference)
			prototypeOwner = ((ComponentImplementationReference) owner).getImplementation();
		else if (owner instanceof ComponentReference)
			prototypeOwner = ((ComponentReference) owner).getClassifier();
		else if (owner instanceof FeatureGroupReference)
			prototypeOwner = ((FeatureGroupReference) owner).getFeatureGroupType();
		else {
			throw new AssertionError(
					"prototypeBinding.getOwner() is not an instance of ComponentType, ComponentImplementation,"
							+ " FeatureGroupType, Subcomponent, ComponentReference, or FeatureGroupReference");
		}
		NamedElement searchResult = prototypeOwner.findNamedElement(prototypeName);
		if (searchResult instanceof Prototype)
			prototypeBinding.setFormal((Prototype) searchResult);
		else if (searchResult != null)
			errManager.error(prototypeBinding, '\'' + prototypeName + "' is not a prototype");
		else
			errManager.error(prototypeBinding,
					'\'' + prototypeName + "' not found in '" + prototypeOwner.getQualifiedName() + '\'');
	}

	private void caseFeatureAccessSpecificationClassifierReference(AccessSpecification accessSpecification,
			String packageName, String classifierName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, classifierName,
				getContainingPackageSection(accessSpecification));
		if (searchResult instanceof ComponentClassifier)
			accessSpecification.setClassifier((ComponentClassifier) searchResult);
		else if (searchResult != null)
			errManager.error(accessSpecification, '\'' + getQualifiedName(packageName, classifierName)
					+ "' is not a component classifier");
		else
			errManager.error(accessSpecification, '\'' + getQualifiedName(packageName, classifierName) + "' not found");
	}

	private void caseFeaturePrototypeReference(FeaturePrototypeReference prototypeReference, String prototypeName) {
		NamedElement searchResult = getContainingClassifier(prototypeReference).findNamedElement(prototypeName);
		if (searchResult instanceof FeaturePrototype)
			prototypeReference.setPrototype((FeaturePrototype) searchResult);
		else if (searchResult != null)
			errManager.error(prototypeReference, '\'' + prototypeName + "' is not a feature prototype");
		else
			errManager.error(prototypeReference, '\'' + prototypeName + "' not found");
	}

	private void caseFeatureClassifierReference(AbstractFeature abstractFeature, String packageName,
			String classifierName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, classifierName,
				getContainingPackageSection(abstractFeature));
		if (searchResult instanceof ComponentClassifier)
			abstractFeature.setComponentClassifier((ComponentClassifier) searchResult);
		else if (searchResult != null)
			errManager.error(abstractFeature, '\'' + getQualifiedName(packageName, classifierName)
					+ "' is not a component classifier");
		else
			errManager.error(abstractFeature, '\'' + getQualifiedName(packageName, classifierName) + "' not found");
	}

	private void caseFeatureClassifierOrPrototypeReference(AbstractFeature abstractFeature,
			String prototypeOrClassifierName) {
		NamedElement searchResult = getContainingClassifier(abstractFeature)
				.findNamedElement(prototypeOrClassifierName);
		if (searchResult instanceof Prototype)
			abstractFeature.setPrototype((Prototype) searchResult);
		else
			caseFeatureClassifierReference(abstractFeature, null, prototypeOrClassifierName);
	}

	private void caseSourceModeReference(ModeTransition modeTransition, String modeName) {
		NamedElement searchResult = getContainingClassifier(modeTransition).findNamedElement(modeName);
		if (searchResult instanceof Mode)
			modeTransition.setSource((Mode) searchResult);
		else if (searchResult != null)
			errManager.error(modeTransition, '\'' + modeName + "' is not a mode");
		else
			errManager.error(modeTransition, '\'' + modeName + "' not found");
	}

	private void caseDestinationModeReference(ModeTransition modeTransition, String modeName) {
		NamedElement searchResult = getContainingClassifier(modeTransition).findNamedElement(modeName);
		if (searchResult instanceof Mode)
			modeTransition.setDestination((Mode) searchResult);
		else if (searchResult != null)
			errManager.error(modeTransition, '\'' + modeName + "' is not a mode");
		else
			errManager.error(modeTransition, '\'' + modeName + "' not found");
	}

	private void caseModeOrTransitionReference(ModalPath modalPath, String modeOrTransitionName) {
		NamedElement searchResult = getContainingClassifier(modalPath).findNamedElement(modeOrTransitionName);
		if (searchResult instanceof Mode)
			modalPath.getInModes().add((Mode) searchResult);
		else if (searchResult instanceof ModeTransition)
			modalPath.getInTransitions().add((ModeTransition) searchResult);
		else if (searchResult != null)
			errManager.error(modalPath, '\'' + modeOrTransitionName + "' is not a mode or a mode transition");
		else
			errManager.error(modalPath, '\'' + modeOrTransitionName + "' not found");
	}

	private void caseInModesReference(ModalElement modalElement, String modeName) {
		NamedElement searchResult = getContainingClassifier(modalElement).findNamedElement(modeName);
		if (searchResult instanceof Mode)
			modalElement.getInModes().add((Mode) searchResult);
		else if (searchResult != null)
			errManager.error(modalElement, '\'' + modeName + "' is not a mode");
		else
			errManager.error(modalElement, '\'' + modeName + "' is not a mode");
	}

	private void caseBaseUnitIdentifierReference(UnitLiteral unitLiteral, String baseUnitName) {
		UnitsType unitsType = (UnitsType) unitLiteral.getOwner();
		UnitLiteral baseUnit = (UnitLiteral) unitsType.findNamedElement(baseUnitName);
		if (baseUnit != null) {
			if (unitsType.getOwnedLiterals().indexOf(baseUnit) < unitsType.getOwnedLiterals().indexOf(unitLiteral))
				unitLiteral.setBaseUnit(baseUnit);
			else
				errManager.error(unitLiteral, '\'' + baseUnitName
						+ "' must be defined before it is used in a conversion factor");
		} else
			errManager.error(unitLiteral, '\'' + baseUnitName + "' not found");
	}

	private void casePropertyUnitsTypeReference(NumberType numberType, String propertySetName, String unitsTypeName) {
		NamedElement searchResult = findNamedElementInPropertySet(propertySetName, unitsTypeName,
				getContainingPropertySet(numberType));
		if (searchResult instanceof UnitsType)
			numberType.setUnitsType((UnitsType) searchResult);
		else if (searchResult != null)
			errManager.error(numberType, '\'' + getQualifiedName(propertySetName, unitsTypeName)
					+ "' is not a units type");
		else
			errManager.error(numberType, '\'' + getQualifiedName(propertySetName, unitsTypeName) + "' not found");
	}

	private void casePropertyValuePropertyTypeReference(Property propertyDefinition, String propertySetName,
			String propertyTypeName) {
		NamedElement searchResult = findNamedElementInPropertySet(propertySetName, propertyTypeName,
				getContainingPropertySet(propertyDefinition));
		if (searchResult instanceof PropertyType)
			propertyDefinition.setType((PropertyType) searchResult);
		else if (searchResult != null)
			errManager.error(propertyDefinition, '\'' + getQualifiedName(propertySetName, propertyTypeName)
					+ "' is not a property type");
		else
			errManager.error(propertyDefinition, '\'' + getQualifiedName(propertySetName, propertyTypeName)
					+ "' not found");
	}

	private void casePropertyTypeReference(TypedElement recordFieldOrConstant, String propertySetName,
			String propertyTypeName) {
		NamedElement searchResult = findNamedElementInPropertySet(propertySetName, propertyTypeName,
				getContainingPropertySet(recordFieldOrConstant));
		if (searchResult instanceof PropertyType)
			recordFieldOrConstant.setType((PropertyType) searchResult);
		else if (searchResult != null)
			errManager.error(recordFieldOrConstant, '\'' + getQualifiedName(propertySetName, propertyTypeName)
					+ "' is not a property type");
		else
			errManager.error(recordFieldOrConstant, '\'' + getQualifiedName(propertySetName, propertyTypeName)
					+ "' not found");
	}

	private void caseRangeTypePropertyTypeReference(RangeType rangeType, String propertySetName, String numberTypeName) {
		NamedElement searchResult = findNamedElementInPropertySet(propertySetName, numberTypeName,
				getContainingPropertySet(rangeType));
		if (searchResult instanceof NumberType)
			rangeType.setNumberType((NumberType) searchResult);
		else if (searchResult != null)
			errManager.error(rangeType, '\'' + getQualifiedName(propertySetName, numberTypeName)
					+ "' is not a number property type");
		else
			errManager.error(rangeType, '\'' + getQualifiedName(propertySetName, numberTypeName) + "' not found");
	}

	private void caseIntegerRangeLowerBoundConstantReference(NumericRange numericRange, String signAsString,
			String propertySetName, String propertyConstantName) {
		OperationKind sign;
		if (signAsString == null)
			sign = null;
		else if (signAsString.equals("+"))
			sign = OperationKind.PLUS;
		else if (signAsString.equals("-"))
			sign = OperationKind.MINUS;
		else
			throw new IllegalArgumentException("signAsString must be \"+\" or \"-\".");
		NamedElement searchResult = findNamedElementInPropertySet(propertySetName, propertyConstantName,
				getContainingPropertySet(numericRange));
		if (searchResult instanceof PropertyConstant) {
			ConstantValue constantValue;
			if (sign != null) {
				Operation operation = (Operation) numericRange.createLowerBound(aadl2Package.getOperation());
				operation.setOp(sign);
				constantValue = (ConstantValue) operation
						.createOwnedPropertyExpression(aadl2Package.getConstantValue());
			} else
				constantValue = (ConstantValue) numericRange.createLowerBound(aadl2Package.getConstantValue());
			constantValue.setConstant((PropertyConstant) searchResult);
		} else if (searchResult != null)
			errManager.error(numericRange, '\'' + getQualifiedName(propertySetName, propertyConstantName)
					+ "' is not a property constant");
		else
			errManager.error(numericRange, '\'' + getQualifiedName(propertySetName, propertyConstantName)
					+ "' not found");
	}

	private void caseIntegerRangeUpperBoundConstantReference(NumericRange numericRange, String signAsString,
			String propertySetName, String propertyConstantName) {
		OperationKind sign;
		if (signAsString == null)
			sign = null;
		else if (signAsString.equals("+"))
			sign = OperationKind.PLUS;
		else if (signAsString.equals("-"))
			sign = OperationKind.MINUS;
		else
			throw new IllegalArgumentException("signAsString must be \"+\" or \"-\".");
		NamedElement searchResult = findNamedElementInPropertySet(propertySetName, propertyConstantName,
				getContainingPropertySet(numericRange));
		if (searchResult instanceof PropertyConstant) {
			ConstantValue constantValue;
			if (sign != null) {
				Operation operation = (Operation) numericRange.createUpperBound(aadl2Package.getOperation());
				operation.setOp(sign);
				constantValue = (ConstantValue) operation
						.createOwnedPropertyExpression(aadl2Package.getConstantValue());
			} else
				constantValue = (ConstantValue) numericRange.createUpperBound(aadl2Package.getConstantValue());
			constantValue.setConstant((PropertyConstant) searchResult);
		} else if (searchResult != null)
			errManager.error(numericRange, '\'' + getQualifiedName(propertySetName, propertyConstantName)
					+ "' is not a property constant");
		else
			errManager.error(numericRange, '\'' + getQualifiedName(propertySetName, propertyConstantName)
					+ "' not found");
	}

	private void caseRealRangeLowerBoundConstantReference(NumericRange numericRange, String signAsString,
			String propertySetName, String propertyConstantName) {
		OperationKind sign;
		if (signAsString == null)
			sign = null;
		else if (signAsString.equals("+"))
			sign = OperationKind.PLUS;
		else if (signAsString.equals("-"))
			sign = OperationKind.MINUS;
		else
			throw new IllegalArgumentException("signAsString must be \"+\" or \"-\".");
		NamedElement searchResult = findNamedElementInPropertySet(propertySetName, propertyConstantName,
				getContainingPropertySet(numericRange));
		if (searchResult instanceof PropertyConstant) {
			ConstantValue constantValue;
			if (sign != null) {
				Operation operation = (Operation) numericRange.createLowerBound(aadl2Package.getOperation());
				operation.setOp(sign);
				constantValue = (ConstantValue) operation
						.createOwnedPropertyExpression(aadl2Package.getConstantValue());
			} else
				constantValue = (ConstantValue) numericRange.createLowerBound(aadl2Package.getConstantValue());
			constantValue.setConstant((PropertyConstant) searchResult);
		} else if (searchResult != null)
			errManager.error(numericRange, '\'' + getQualifiedName(propertySetName, propertyConstantName)
					+ "' is not a property constant");
		else
			errManager.error(numericRange, '\'' + getQualifiedName(propertySetName, propertyConstantName)
					+ "' not found");
	}

	private void caseRealRangeUpperBoundConstantReference(NumericRange numericRange, String signAsString,
			String propertySetName, String propertyConstantName) {
		OperationKind sign;
		if (signAsString == null)
			sign = null;
		else if (signAsString.equals("+"))
			sign = OperationKind.PLUS;
		else if (signAsString.equals("-"))
			sign = OperationKind.MINUS;
		else
			throw new IllegalArgumentException("signAsString must be \"+\" or \"-\".");
		NamedElement searchResult = findNamedElementInPropertySet(propertySetName, propertyConstantName,
				getContainingPropertySet(numericRange));
		if (searchResult instanceof PropertyConstant) {
			ConstantValue constantValue;
			if (sign != null) {
				Operation operation = (Operation) numericRange.createUpperBound(aadl2Package.getOperation());
				operation.setOp(sign);
				constantValue = (ConstantValue) operation
						.createOwnedPropertyExpression(aadl2Package.getConstantValue());
			} else
				constantValue = (ConstantValue) numericRange.createUpperBound(aadl2Package.getConstantValue());
			constantValue.setConstant((PropertyConstant) searchResult);
		} else if (searchResult != null)
			errManager.error(numericRange, '\'' + getQualifiedName(propertySetName, propertyConstantName)
					+ "' is not a property constant");
		else
			errManager.error(numericRange, '\'' + getQualifiedName(propertySetName, propertyConstantName)
					+ "' not found");
	}

	private void casePropertyDefinitionReference(PropertyAssociation propertyAssociation, String propertySetName,
			String propertyDefinitionName) {
		PackageSection context = getContainingPackageSection(propertyAssociation);
		if (context == null && propertyAssociation.getElementRoot() instanceof AadlPackage) {
			context = ((AadlPackage) propertyAssociation.getElementRoot()).getPublicSection();
		}
		if (context != null) {
			NamedElement searchResult = findNamedElementInPropertySet(propertySetName, propertyDefinitionName, context);
			if (searchResult instanceof Property)
				propertyAssociation.setProperty((Property) searchResult);
			else if (searchResult != null) {
				errManager.error(propertyAssociation, '\'' + getQualifiedName(propertySetName, propertyDefinitionName)
						+ "' is not a property definition");
			} else
				errManager.error(propertyAssociation, '\'' + getQualifiedName(propertySetName, propertyDefinitionName)
						+ "' not found");
		} else
			errManager.error(propertyAssociation, '\'' + getQualifiedName(propertySetName, propertyDefinitionName)
					+ "' not found");
	}

	/*
	 * Nested record values can be tricky. Consider this example from
	 * Memory_Properties:
	 * 
	 * Access_Time: record ( First: IO_Time_Spec; Last: IO_Time_Spec;) => (First
	 * => (Time => Start; Offset => 0.0 ns .. 0.0 ns;); Last => (Time =>
	 * Completion; Offset => 0.0 ns .. 0.0 ns;);) applies to (data access);
	 * 
	 * In this example, this method will be called six times: to resolve First,
	 * First.Time, First.Offset, Last, Last.Time, and Last.Offset. [Note that
	 * the dot notation used in the previous sentence is not official AADL. I
	 * used it only to differentiate the two Time labels and the two Offset
	 * labels.] First and Last can be resolved without any problems. The
	 * dependencies required by First and Last are taken care of by the order of
	 * literals in ParserReferenceType. However, the resolution of First.Time
	 * depends on the resolution of First. This means that the reference type
	 * PropertyRecordFieldReference depends on the reference type
	 * PropertyRecordFieldReference. A reference type that depends on itself
	 * cannot be handled by the order of literals in ParserReferenceType.
	 * Luckily, since First appears before First.Time in the text, the parser
	 * adds a reference record for First before it adds a reference record for
	 * First.Time. When reference records have the same reference type, their
	 * ordering is based on the order of insertion. This method assumes that it
	 * will be called for First before First.Time. If First.Time is passed to
	 * this method before First, then First.Time will not be resolved and there
	 * will be no message stating that it was not resolved. This is because of
	 * how this method resolves First.Time. It will navigate up the containment
	 * hierarchy from First.Time to First and call First.getProperty(). If
	 * First.getProperty() returns a RecordField, then this method go to the
	 * type and search for Time. If First.getProperty() returns null, then this
	 * method assumes that the resolution of First failed. It also assumes that
	 * there is a problem marker on First and that there is no need to place a
	 * problem marker on First.Time.
	 */
	private void casePropertyRecordFieldReference(BasicPropertyAssociation basicPropertyAssociation, String fieldName) {
		RecordType recordType;
		Element owner = basicPropertyAssociation.getOwner();
		while (owner != null
				&& !(owner instanceof Property || owner instanceof PropertyAssociation
						|| owner instanceof PropertyConstant || owner instanceof BasicPropertyAssociation)) {
			owner = owner.getOwner();
		}
		if (owner instanceof Property) //Default value of a property definition.
		{
			//TODO: Need to check that the type of the property is a record type.
			//		We should do this when the type of the definition is resolved in PropertyValuePropertyTypeReference.
			recordType = (RecordType) ((Property) owner).getType();
		} else if (owner instanceof PropertyAssociation) //Value of the association.
		{
			//TODO: Need to check that the property definition is of a record type.
			//		We should do this when the definition of the association is resolved in PropertyDefinitionReference.
			recordType = (RecordType) ((PropertyAssociation) owner).getProperty().getType();
		} else if (owner instanceof PropertyConstant) //Value of the constant.
		{
			//TODO: Need to check that the type of the property constant is a record type.
			//		We should do this when the type of the constant is resolved in PropertyTypeReference.
			recordType = (RecordType) ((PropertyConstant) owner).getType();
		} else if (owner instanceof BasicPropertyAssociation) //Nested record value.
		{
			BasicPropertyAssociation outerRecordAssociation = (BasicPropertyAssociation) owner;
			if (outerRecordAssociation.getProperty() == null) {
				//The resolution of the outer record association failed.  The inner record association depends on the outer one.
				//Do not resolve the inner association and do not create a new problem marker.  If the resolution of the outer
				//association failed, then there is already a problem marker there.
				return;
			}
			//TODO: Need to check that the type of the outer record field is a record type.
			//		We should do this in this method, but at a previous point in the call stack.
			recordType = (RecordType) ((BasicPropertyAssociation) owner).getProperty().getType();
		} else {
			errManager.internalError("Problem in NameResolver.casePropertyRecordFieldReference."
					+ "  Unaccounted for situation with model object: " + basicPropertyAssociation);
			return;
		}
		RecordField field = (RecordField) recordType.findNamedElement(fieldName);
		if (field != null)
			basicPropertyAssociation.setProperty(field);
		else
			errManager.error(basicPropertyAssociation, '\'' + fieldName + "' not found");
	}

	private void casePropertyUnitLiteralReference(NumberValue numberValue, String unitLiteralName) {
		UnitsType unitsType;
		Element owner = numberValue.getOwner();
		while (owner instanceof ListValue)
			owner = owner.getOwner();
		if (owner instanceof NumericRange) //Lower bound or upper bound values of a number property type.
			unitsType = ((NumberType) owner.getOwner()).getUnitsType();
		else {
			if (owner instanceof RangeValue)
				owner = owner.getOwner();
			PropertyType propertyType;
			if (owner instanceof PropertyConstant) //Value of the property constant.
			{
				//TODO: Need to check that the type of the property constant is correct for the value.
				//		We should do this when the type of the constant is resolved in PropertyTypeReference.
				propertyType = (PropertyType) ((PropertyConstant) owner).getType();
			} else if (owner instanceof Property) //Default value of a property definition.
			{
				//TODO: Need to check that the type of the property definition is correct for the value.
				//		We should do this when the type of the definition is resolved in PropertyValuePropertyTypeReference.
				propertyType = (PropertyType) ((Property) owner).getType();
			} else if (owner instanceof ModalPropertyValue && owner.getOwner() instanceof PropertyAssociation) //Value of an association.
			{
				//TODO: Need to check that the type of the property definition is correct for the value.
				//		We should do this when the definition of the association is resolved in PropertyDefinitionReference.
				propertyType = (PropertyType) ((PropertyAssociation) owner.getOwner()).getProperty().getType();
			} else if (owner instanceof BasicPropertyAssociation) //Inner value of a record value.
			{
				//TODO: Need to check that the type of the record field is correct for the value.
				//		We should do this when the record field of the record value is resolved in PropertyRecordFieldReference.
				propertyType = (PropertyType) ((BasicPropertyAssociation) owner).getProperty().getType();
			} else {
				errManager.internalError("Problem in NameResolver.casePropertyUnitLiteralReference."
						+ "  Unaccounted for situation with model object: " + numberValue);
				return;
			}
			if (propertyType instanceof NumberType)
				unitsType = ((NumberType) propertyType).getUnitsType();
			else
				unitsType = ((RangeType) propertyType).getNumberType().getUnitsType();
		}
		if (unitsType != null) {
			UnitLiteral literal = (UnitLiteral) unitsType.findNamedElement(unitLiteralName);
			if (literal != null)
				numberValue.setUnit(literal);
			else
				errManager.error(numberValue, '\'' + unitLiteralName + "' not found");
		} else
			errManager.error(numberValue, "Cannot use a unit on a property that does not have units");
	}

	private void casePortRefinementReference(Port refiningPort, String refinedFeatureName) {
		Classifier containingClassifier = getContainingClassifier(refiningPort);
		Classifier extendedClassifier;
		if (containingClassifier instanceof ComponentType)
			extendedClassifier = ((ComponentType) containingClassifier).getExtended();
		else
			//Must be a FeatureGroupType.  Ports cannot be contained in a ComponentImplementation.
			extendedClassifier = ((FeatureGroupType) containingClassifier).getExtended();
		NamedElement searchResult = extendedClassifier.findNamedElement(refinedFeatureName);
		if (searchResult instanceof Feature)
			refiningPort.setRefined((Feature) searchResult);
		else if (searchResult != null)
			errManager.error(refiningPort, '\'' + refinedFeatureName + "' is not a feature");
		else
			errManager.error(refiningPort, '\'' + refinedFeatureName + "' not found in extension hierarchy");
	}

	private void caseComponentPrototypeRefinementReference(ComponentPrototype refiningPrototype,
			String refinedPrototypeName) {
		Classifier containingClassifier = getContainingClassifier(refiningPrototype);
		NamedElement searchResult;
		if (containingClassifier instanceof ComponentType) {
			searchResult = ((ComponentType) containingClassifier).getExtended().findNamedElement(refinedPrototypeName);
		} else if (containingClassifier instanceof ComponentImplementation) {
			searchResult = ((ComponentImplementation) containingClassifier).getExtended().findNamedElement(
					refinedPrototypeName);
			if (searchResult != null && !(getContainingClassifier(searchResult) instanceof ComponentImplementation))
				searchResult = null;
		} else {
			searchResult = ((FeatureGroupType) containingClassifier).getExtended().findNamedElement(
					refinedPrototypeName);
		}
		if (searchResult instanceof Prototype)
			refiningPrototype.setRefined((Prototype) searchResult);
		else if (searchResult != null)
			errManager.error(refiningPrototype, '\'' + refinedPrototypeName + "' is not a prototype");
		else
			errManager.error(refiningPrototype, '\'' + refinedPrototypeName + "' not found in extension hierarchy");
	}

	private void caseFeaturePrototypeRefinementReference(FeaturePrototype refiningPrototype, String refinedPrototypeName) {
		Classifier containingClassifier = getContainingClassifier(refiningPrototype);
		NamedElement searchResult;
		if (containingClassifier instanceof ComponentType) {
			searchResult = ((ComponentType) containingClassifier).getExtended().findNamedElement(refinedPrototypeName);
		} else if (containingClassifier instanceof ComponentImplementation) {
			searchResult = ((ComponentImplementation) containingClassifier).getExtended().findNamedElement(
					refinedPrototypeName);
			if (searchResult != null && !(getContainingClassifier(searchResult) instanceof ComponentImplementation))
				searchResult = null;
		} else {
			searchResult = ((FeatureGroupType) containingClassifier).getExtended().findNamedElement(
					refinedPrototypeName);
		}
		if (searchResult instanceof Prototype)
			refiningPrototype.setRefined((Prototype) searchResult);
		else if (searchResult != null)
			errManager.error(refiningPrototype, '\'' + refinedPrototypeName + "' is not a prototype");
		else
			errManager.error(refiningPrototype, '\'' + refinedPrototypeName + "' not found in extension hierarchy");
	}

	private void caseFeatureGroupPrototypeRefinementReference(FeatureGroupPrototype refiningPrototype,
			String refinedPrototypeName) {
		Classifier containingClassifier = getContainingClassifier(refiningPrototype);
		NamedElement searchResult;
		if (containingClassifier instanceof ComponentType) {
			searchResult = ((ComponentType) containingClassifier).getExtended().findNamedElement(refinedPrototypeName);
		} else if (containingClassifier instanceof ComponentImplementation) {
			searchResult = ((ComponentImplementation) containingClassifier).getExtended().findNamedElement(
					refinedPrototypeName);
			if (searchResult != null && !(getContainingClassifier(searchResult) instanceof ComponentImplementation))
				searchResult = null;
		} else {
			searchResult = ((FeatureGroupType) containingClassifier).getExtended().findNamedElement(
					refinedPrototypeName);
		}
		if (searchResult instanceof Prototype)
			refiningPrototype.setRefined((Prototype) searchResult);
		else if (searchResult != null)
			errManager.error(refiningPrototype, '\'' + refinedPrototypeName + "' is not a prototype");
		else
			errManager.error(refiningPrototype, '\'' + refinedPrototypeName + "' not found in extension hierarchy");
	}

	private void caseFeatureGroupRefinementReference(FeatureGroup refiningFeatureGroup, String refinedFeatureName) {
		Classifier containingClassifier = getContainingClassifier(refiningFeatureGroup);
		Classifier extendedClassifier;
		if (containingClassifier instanceof ComponentType)
			extendedClassifier = ((ComponentType) containingClassifier).getExtended();
		else
			//Must be a FeatureGroupType.  FeatureGroups cannot be contained in a ComponentImplementation.
			extendedClassifier = ((FeatureGroupType) containingClassifier).getExtended();
		NamedElement searchResult = extendedClassifier.findNamedElement(refinedFeatureName);
		if (searchResult instanceof Feature)
			refiningFeatureGroup.setRefined((Feature) searchResult);
		else if (searchResult != null)
			errManager.error(refiningFeatureGroup, '\'' + refinedFeatureName + "' is not a feature");
		else
			errManager.error(refiningFeatureGroup, '\'' + refinedFeatureName + "' not found in extension hierarchy");
	}

	private void caseAccessFeatureRefinementReference(Access refiningAccessFeature, String refinedFeatureName) {
		Classifier containingClassifier = getContainingClassifier(refiningAccessFeature);
		Classifier extendedClassifier;
		if (containingClassifier instanceof ComponentType)
			extendedClassifier = ((ComponentType) containingClassifier).getExtended();
		else
			//Must be a FeatureGroupType.  AccessFeatures cannot be contained in a ComponentImplementation.
			extendedClassifier = ((FeatureGroupType) containingClassifier).getExtended();
		NamedElement searchResult = extendedClassifier.findNamedElement(refinedFeatureName);
		if (searchResult instanceof Feature)
			refiningAccessFeature.setRefined((Feature) searchResult);
		else if (searchResult != null)
			errManager.error(refiningAccessFeature, '\'' + refinedFeatureName + "' is not a feature");
		else
			errManager.error(refiningAccessFeature, '\'' + refinedFeatureName + "' not found in extension hierarchy");
	}

	private void caseParameterRefinementReference(Parameter refiningParameter, String refinedFeatureName) {
		NamedElement searchResult = ((SubprogramType) getContainingClassifier(refiningParameter)).getExtended()
				.findNamedElement(refinedFeatureName);
		if (searchResult instanceof Feature)
			refiningParameter.setRefined((Feature) searchResult);
		else if (searchResult != null)
			errManager.error(refiningParameter, '\'' + refinedFeatureName + "' is not a feature");
		else
			errManager.error(refiningParameter, '\'' + refinedFeatureName + "' not found in extension hierarchy");
	}

	private void caseFlowSpecificationRefinementReference(FlowSpecification refiningFlowSpec, String refinedFlowSpecName) {
		NamedElement searchResult = ((ComponentType) getContainingClassifier(refiningFlowSpec)).getExtended()
				.findNamedElement(refinedFlowSpecName);
		if (searchResult instanceof FlowSpecification)
			refiningFlowSpec.setRefined((FlowSpecification) searchResult);
		else if (searchResult != null)
			errManager.error(refiningFlowSpec, '\'' + refinedFlowSpecName + "' is not a flow specification");
		else
			errManager.error(refiningFlowSpec, '\'' + refinedFlowSpecName + "' not found in extension hierarchy");
	}

	private void caseSubcomponentRefinementReference(Subcomponent refiningSubcomponent, String refinedSubcomponentName) {
		NamedElement searchResult = ((ComponentImplementation) getContainingClassifier(refiningSubcomponent))
				.getExtended().findNamedElement(refinedSubcomponentName);
		if (searchResult instanceof Subcomponent)
			refiningSubcomponent.setRefined((Subcomponent) searchResult);
		else if (searchResult != null)
			errManager.error(refiningSubcomponent, '\'' + refinedSubcomponentName + "' is not a subcomponent");
		else
			errManager.error(refiningSubcomponent, '\'' + refinedSubcomponentName
					+ "' not found in extension hierarchy");
	}

	private void caseEndToEndFlowRefinementReference(EndToEndFlow refiningETEFlow, String refinedETEFlowName) {
		NamedElement searchResult = ((ComponentImplementation) getContainingClassifier(refiningETEFlow)).getExtended()
				.findNamedElement(refinedETEFlowName);
		if (searchResult instanceof EndToEndFlow)
			refiningETEFlow.setRefined((EndToEndFlow) searchResult);
		else if (searchResult != null)
			errManager.error(refiningETEFlow, '\'' + refinedETEFlowName + "' is not an end to end flow");
		else
			errManager.error(refiningETEFlow, '\'' + refinedETEFlowName + "' not found in extension hierarchy");
	}

	private void caseConnectionRefinementReference(Connection refiningConnection, String refinedConnectionName) {
		NamedElement searchResult = ((ComponentImplementation) getContainingClassifier(refiningConnection))
				.getExtended().findNamedElement(refinedConnectionName);
		if (searchResult instanceof Connection)
			refiningConnection.setRefined((Connection) searchResult);
		else if (searchResult != null)
			errManager.error(refiningConnection, '\'' + refinedConnectionName + "' is not a connection");
		else
			errManager.error(refiningConnection, '\'' + refinedConnectionName + "' not found in extension hierarchy");
	}

	private void casePackageSubprogramCallReference(SubprogramCall subprogramCall, String packageName,
			String subprogramTypeName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, subprogramTypeName,
				getContainingPackageSection(subprogramCall));
		if (searchResult instanceof SubprogramType)
			subprogramCall.setCalledSubprogram((SubprogramType) searchResult);
		else if (searchResult != null)
			errManager.error(subprogramCall, '\'' + getQualifiedName(packageName, subprogramTypeName)
					+ "' is not a subprogram type");
		else
			errManager.error(subprogramCall, '\'' + getQualifiedName(packageName, subprogramTypeName) + "' not found");
	}

	private void casePackageAndContextSubprogramCallReference(SubprogramCall subprogramCall, String packageName,
			String typeName, String implementationOrAccessName) {
		NamedElement implementationSearchResult = findNamedElementInAadlPackage(packageName, typeName + '.'
				+ implementationOrAccessName, getContainingPackageSection(subprogramCall));
		if (implementationSearchResult instanceof SubprogramImplementation)
			subprogramCall.setCalledSubprogram((SubprogramImplementation) implementationSearchResult);
		else {
			NamedElement typeSearchResult = findNamedElementInAadlPackage(packageName, typeName,
					getContainingPackageSection(subprogramCall));
			if (typeSearchResult instanceof DataType || typeSearchResult instanceof SubprogramGroupType
					|| typeSearchResult instanceof AbstractType) {
				NamedElement accessSearchResult = ((ComponentType) typeSearchResult)
						.findNamedElement(implementationOrAccessName);
				if (accessSearchResult instanceof SubprogramAccess) {
					subprogramCall.setContext((CallContext) typeSearchResult);
					subprogramCall.setCalledSubprogram((SubprogramAccess) accessSearchResult);
				} else if (accessSearchResult != null) {
					errManager.error(subprogramCall, '\'' + getQualifiedName(packageName, typeName) + '.'
							+ implementationOrAccessName + "' is not a subprogram access");
				} else {
					errManager.error(subprogramCall, '\'' + implementationOrAccessName + "' not found in '"
							+ getQualifiedName(packageName, typeName) + '\'');
				}
			} else if (typeSearchResult != null) {
				errManager.error(subprogramCall, '\'' + getQualifiedName(packageName, typeName)
						+ "' is not an abstract, data, or subprogram group type");
			} else if (implementationSearchResult != null) {
				errManager.error(subprogramCall, '\'' + getQualifiedName(packageName, typeName) + '.'
						+ implementationOrAccessName + "' is not a subprogram implementation");
			} else {
				errManager.error(subprogramCall, '\'' + getQualifiedName(packageName, typeName) + '.'
						+ implementationOrAccessName + "' not found");
			}
		}
	}

	private void caseSubprogramCallReference(SubprogramCall subprogramCall, String calledSubprogramName) {
		NamedElement searchResult = getContainingClassifier(subprogramCall).findNamedElement(calledSubprogramName);
		if (searchResult instanceof SubprogramSubcomponent || searchResult instanceof SubprogramAccess)
			subprogramCall.setCalledSubprogram((CalledSubprogram) searchResult);
		else if (searchResult instanceof ComponentPrototype)
			subprogramCall.setPrototype((ComponentPrototype) searchResult);
		else if (searchResult != null) {
			errManager.error(subprogramCall, '\'' + calledSubprogramName
					+ "' is not a subprogram subcomponent, subprogram access, or component prototype");
		} else
			casePackageSubprogramCallReference(subprogramCall, null, calledSubprogramName);
	}

	private void caseContextSubprogramCallReference(SubprogramCall subprogramCall, String contextName,
			String calledSubprogramName) {
		NamedElement contextSearchResult = getContainingClassifier(subprogramCall).findNamedElement(contextName);
		if (contextSearchResult instanceof SubprogramGroupSubcomponent) {
			Subcomponent subcomponent = (Subcomponent) contextSearchResult;
			while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement calledSubprogramSearchResult = subcomponent.getClassifier().findNamedElement(
						calledSubprogramName);
				if (calledSubprogramSearchResult instanceof SubprogramAccess) {
					subprogramCall.setContext((SubprogramGroupSubcomponent) contextSearchResult);
					subprogramCall.setCalledSubprogram((SubprogramAccess) calledSubprogramSearchResult);
				} else
					errManager.error(subprogramCall, '\'' + contextName + '.' + calledSubprogramName
							+ "' is not a subprogram access");
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(subprogramCall), subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement calledSubprogramSearchResult = classifier.findNamedElement(calledSubprogramName);
					if (calledSubprogramSearchResult instanceof SubprogramAccess) {
						subprogramCall.setContext((SubprogramGroupSubcomponent) contextSearchResult);
						subprogramCall.setCalledSubprogram((SubprogramAccess) calledSubprogramSearchResult);
					} else
						errManager.error(subprogramCall, '\'' + contextName + '.' + calledSubprogramName
								+ "' is not a subprogram access");
				} else
					errManager.error(subprogramCall, '\'' + calledSubprogramName + "' not found in '" + contextName
							+ '\'');
			} else
				errManager.error(subprogramCall, '\'' + calledSubprogramName + "' not found in '" + contextName + '\'');
		} else if (contextSearchResult instanceof FeatureGroup) {
			FeatureGroup featureGroup = (FeatureGroup) contextSearchResult;
			while (featureGroup.getFeatureGroupType() == null && featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement calledSubprogramSearchResult = featureGroup.getFeatureGroupType().findNamedElement(
						calledSubprogramName);
				if (calledSubprogramSearchResult instanceof SubprogramAccess) {
					subprogramCall.setContext((FeatureGroup) contextSearchResult);
					subprogramCall.setCalledSubprogram((SubprogramAccess) calledSubprogramSearchResult);
				} else
					errManager.error(subprogramCall, '\'' + contextName + '.' + calledSubprogramName
							+ "' is not a subprogram access");
			} else if (featureGroup.getPrototype() != null) {
				//TODO: Need to make sure that the feature group refers to a feature group prototype.
				//		This should be done in FeatureGroupPrototypeOrClassifierReference
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(subprogramCall), (FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement calledSubprogramSearchResult = featureGroupType.findNamedElement(calledSubprogramName);
					if (calledSubprogramSearchResult instanceof SubprogramAccess) {
						subprogramCall.setContext((FeatureGroup) contextSearchResult);
						subprogramCall.setCalledSubprogram((SubprogramAccess) calledSubprogramSearchResult);
					} else
						errManager.error(subprogramCall, '\'' + contextName + '.' + calledSubprogramName
								+ "' is not a subprogram access");
				} else
					errManager.error(subprogramCall, '\'' + calledSubprogramName + "' not found in '" + contextName
							+ '\'');
			} else
				errManager.error(subprogramCall, '\'' + calledSubprogramName + "' not found in '" + contextName + '\'');
		} else if (contextSearchResult instanceof SubprogramGroupAccess) {
			SubprogramGroupAccess subprogramGroupAccess = (SubprogramGroupAccess) contextSearchResult;
			while (subprogramGroupAccess.getSubprogramGroupClassifier() == null
					&& subprogramGroupAccess.getPrototype() == null
					&& subprogramGroupAccess.getRefined() instanceof SubprogramGroupAccess) {
				subprogramGroupAccess = (SubprogramGroupAccess) subprogramGroupAccess.getRefined();
			}
			if (subprogramGroupAccess.getSubprogramGroupClassifier() != null) {
				NamedElement calledSubprogramSearchResult = subprogramGroupAccess.getSubprogramGroupClassifier()
						.findNamedElement(calledSubprogramName);
				if (calledSubprogramSearchResult instanceof SubprogramAccess) {
					subprogramCall.setContext((SubprogramGroupAccess) contextSearchResult);
					subprogramCall.setCalledSubprogram((SubprogramAccess) calledSubprogramSearchResult);
				} else
					errManager.error(subprogramCall, '\'' + contextName + '.' + calledSubprogramName
							+ "' is not a subprogram access");
			} else if (subprogramGroupAccess.getPrototype() != null) {
				//TODO: Need to make sure that the subprogram group access refers to a component prototype.
				//		This should be done in AccessFeaturePrototypeOrClassifierReference.
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(subprogramCall),
						(ComponentPrototype) subprogramGroupAccess.getPrototype());
				if (classifier != null) {
					NamedElement calledSubprogramSearchResult = classifier.findNamedElement(calledSubprogramName);
					if (calledSubprogramSearchResult instanceof SubprogramAccess) {
						subprogramCall.setContext((SubprogramGroupAccess) contextSearchResult);
						subprogramCall.setCalledSubprogram((SubprogramAccess) calledSubprogramSearchResult);
					} else
						errManager.error(subprogramCall, '\'' + contextName + '.' + calledSubprogramName
								+ "' is not a subprogram access");
				} else
					errManager.error(subprogramCall, '\'' + calledSubprogramName + "' not found in '" + contextName
							+ '\'');
			} else
				errManager.error(subprogramCall, '\'' + calledSubprogramName + "' not found in '" + contextName + '\'');
		} else if (contextSearchResult != null) {
			errManager.error(subprogramCall, '\'' + contextName
					+ "' is not a subprogram group subcomponent, subprogram group access, or feature group");
		} else
			casePackageAndContextSubprogramCallReference(subprogramCall, null, contextName, calledSubprogramName);
	}

	private void caseModeTriggerFromExternalPortReference(TriggerPort triggerPort, String portName) {
		NamedElement searchResult = getContainingClassifier(triggerPort).findNamedElement(portName);
		if (searchResult instanceof Port)
			triggerPort.setPort((Port) searchResult);
		else if (searchResult != null)
			errManager.error(triggerPort, '\'' + portName + "' is not a port");
		else
			errManager.error(triggerPort, '\'' + portName + "' not found");
	}

	//TODO: Clean this up!
	private void caseModeTriggerFromSubcomponentOrFeatureGroupReference(TriggerPort triggerPort, String contextName,
			String portName) {
		NamedElement contextSearchResult = getContainingClassifier(triggerPort).findNamedElement(contextName);
		if (contextSearchResult instanceof Subcomponent) {
			Subcomponent subcomponent = (Subcomponent) contextSearchResult;
			while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement portSearchResult = subcomponent.getClassifier().findNamedElement(portName);
				if (portSearchResult instanceof Port) {
					triggerPort.setContext((Subcomponent) contextSearchResult);
					triggerPort.setPort((Port) portSearchResult);
				} else
					errManager.error(triggerPort, '\'' + contextName + '.' + portName + "' is not a port");
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(triggerPort), subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement portSearchResult = classifier.findNamedElement(portName);
					if (portSearchResult instanceof Port) {
						triggerPort.setContext((Subcomponent) contextSearchResult);
						triggerPort.setPort((Port) portSearchResult);
					} else
						errManager.error(triggerPort, '\'' + contextName + '.' + portName + "' is not a port");
				} else
					errManager.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
			} else
				errManager.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
		} else if (contextSearchResult instanceof FeatureGroup) {
			FeatureGroup featureGroup = (FeatureGroup) contextSearchResult;
			while (featureGroup.getFeatureGroupType() == null && featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement portSearchResult = featureGroup.getFeatureGroupType().findNamedElement(portName);
				if (portSearchResult instanceof Port) {
					triggerPort.setContext((FeatureGroup) contextSearchResult);
					triggerPort.setPort((Port) portSearchResult);
				} else
					errManager.error(triggerPort, '\'' + contextName + '.' + portName + "' is not a port");
			} else if (featureGroup.getPrototype() != null) {
				//TODO: Need to make sure that the feature group refers to a feature group prototype.
				//		This should be done in FeatureGroupPrototypeOrClassifierReference.
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(triggerPort), (FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement portSearchResult = featureGroupType.findNamedElement(portName);
					if (portSearchResult instanceof Port) {
						triggerPort.setContext((FeatureGroup) contextSearchResult);
						triggerPort.setPort((Port) portSearchResult);
					} else
						errManager.error(triggerPort, '\'' + contextName + '.' + portName + "' is not a port");
				} else
					errManager.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
			} else
				errManager.error(triggerPort, '\'' + portName + "' not found in '" + portName + '\'');
		} else if (contextSearchResult instanceof SubprogramCall) {
			SubprogramCall subprogramCall = (SubprogramCall) contextSearchResult;
			if (subprogramCall.getCalledSubprogram() instanceof SubprogramClassifier) {
				NamedElement portSearchResult = ((SubprogramClassifier) subprogramCall.getCalledSubprogram())
						.findNamedElement(portName);
				if (portSearchResult instanceof Port) {
					triggerPort.setContext(subprogramCall);
					triggerPort.setPort((Port) portSearchResult);
				} else
					errManager.error(triggerPort, '\'' + contextName + '.' + portName + "' is not a port");
			} else if (subprogramCall.getCalledSubprogram() instanceof SubprogramSubcomponent) {
				Subcomponent subcomponent = (SubprogramSubcomponent) subprogramCall.getCalledSubprogram();
				while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
						&& subcomponent.getRefined() != null)
					subcomponent = subcomponent.getRefined();
				if (subcomponent.getClassifier() != null) {
					NamedElement portSearchResult = subcomponent.getClassifier().findNamedElement(portName);
					if (portSearchResult instanceof Port) {
						triggerPort.setContext(subprogramCall);
						triggerPort.setPort((Port) portSearchResult);
					} else
						errManager.error(triggerPort, '\'' + contextName + '.' + portName + "' is not a port");
				} else if (subcomponent.getPrototype() != null) {
					ComponentClassifier classifier = findClassifierForComponentPrototype(
							getContainingClassifier(triggerPort), subcomponent.getPrototype());
					if (classifier != null) {
						NamedElement portSearchResult = classifier.findNamedElement(portName);
						if (portSearchResult instanceof Port) {
							triggerPort.setContext(subprogramCall);
							triggerPort.setPort((Port) portSearchResult);
						} else
							errManager.error(triggerPort, '\'' + contextName + '.' + portName + "' is not a port");
					} else
						errManager.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
				} else
					errManager.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
			} else if (subprogramCall.getCalledSubprogram() instanceof SubprogramAccess) {
				Feature access = (SubprogramAccess) subprogramCall.getCalledSubprogram();
				while (access.getClassifier() == null && access.getPrototype() == null && access.getRefined() != null)
					access = access.getRefined();
				if (access.getClassifier() != null) {
					NamedElement portSearchResult = access.getClassifier().findNamedElement(portName);
					if (portSearchResult instanceof Port) {
						triggerPort.setContext(subprogramCall);
						triggerPort.setPort((Port) portSearchResult);
					} else
						errManager.error(triggerPort, '\'' + contextName + '.' + portName + "' is not a port");
				} else if (access.getPrototype() instanceof ComponentPrototype) {
					CallContext callContext = subprogramCall.getContext();
					if (callContext instanceof AbstractType || callContext instanceof DataType
							|| callContext instanceof SubprogramGroupType) {
						ComponentClassifier classifier = findClassifierForComponentPrototype(
								(ComponentType) callContext, (ComponentPrototype) access.getPrototype());
						if (classifier != null) {
							NamedElement portSearchResult = classifier.findNamedElement(portName);
							if (portSearchResult instanceof Port) {
								triggerPort.setContext(subprogramCall);
								triggerPort.setPort((Port) portSearchResult);
							} else
								errManager.error(triggerPort, '\'' + contextName + '.' + portName + "' is not a port");
						} else
							errManager.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
					} else if (callContext instanceof FeatureGroup) {
						FeatureGroup callContextFeatureGroup = (FeatureGroup) callContext;
						FeatureGroupType prototypeContext;
						while (callContextFeatureGroup.getFeatureGroupType() == null
								&& callContextFeatureGroup.getPrototype() == null
								&& callContextFeatureGroup.getRefined() instanceof FeatureGroup) {
							callContextFeatureGroup = (FeatureGroup) callContextFeatureGroup.getRefined();
						}
						if (callContextFeatureGroup.getFeatureGroupType() != null)
							prototypeContext = callContextFeatureGroup.getFeatureGroupType();
						else if (callContextFeatureGroup.getPrototype() instanceof FeatureGroupPrototype) {
							prototypeContext = findFeatureGroupTypeForFeatureGroupPrototype(
									getContainingClassifier(triggerPort),
									(FeatureGroupPrototype) callContextFeatureGroup.getPrototype());
						} else
							prototypeContext = null;
						if (prototypeContext != null) {
							ComponentClassifier classifier = findClassifierForComponentPrototype(prototypeContext,
									(ComponentPrototype) access.getPrototype());
							if (classifier != null) {
								NamedElement portSearchResult = classifier.findNamedElement(portName);
								if (portSearchResult instanceof Port) {
									triggerPort.setContext(subprogramCall);
									triggerPort.setPort((Port) portSearchResult);
								} else
									errManager.error(triggerPort, '\'' + contextName + '.' + portName
											+ "' is not a port");
							} else
								errManager
										.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
						} else
							errManager.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
					} else if (callContext instanceof SubprogramGroupAccess) {
						Feature callContextAccess = (SubprogramGroupAccess) callContext;
						Classifier prototypeContext;
						while (callContextAccess.getClassifier() == null && callContextAccess.getPrototype() == null
								&& callContextAccess.getRefined() != null) {
							callContextAccess = callContextAccess.getRefined();
						}
						if (callContextAccess.getClassifier() != null)
							prototypeContext = callContextAccess.getClassifier();
						else if (callContextAccess.getPrototype() instanceof ComponentPrototype) {
							prototypeContext = findClassifierForComponentPrototype(
									getContainingClassifier(triggerPort),
									(ComponentPrototype) callContextAccess.getPrototype());
						} else
							prototypeContext = null;
						if (prototypeContext != null) {
							ComponentClassifier classifier = findClassifierForComponentPrototype(prototypeContext,
									(ComponentPrototype) access.getPrototype());
							if (classifier != null) {
								NamedElement portSearchResult = classifier.findNamedElement(portName);
								if (portSearchResult instanceof Port) {
									triggerPort.setContext(subprogramCall);
									triggerPort.setPort((Port) portSearchResult);
								} else
									errManager.error(triggerPort, '\'' + contextName + '.' + portName
											+ "' is not a port");
							} else
								errManager
										.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
						} else
							errManager.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
					} else if (callContext instanceof SubprogramGroupSubcomponent) {
						Subcomponent callContextSubcomponent = (SubprogramGroupSubcomponent) callContext;
						while (callContextSubcomponent.getClassifier() == null
								&& callContextSubcomponent.getPrototype() == null
								&& callContextSubcomponent.getRefined() != null) {
							callContextSubcomponent = callContextSubcomponent.getRefined();
						}
						if (callContextSubcomponent.getClassifier() != null) {
							ComponentClassifier classifier;
							if (callContextSubcomponent.getOwnedPrototypeBindings().isEmpty()) {
								classifier = findClassifierForComponentPrototype(
										callContextSubcomponent.getClassifier(),
										(ComponentPrototype) access.getPrototype());
							} else {
								classifier = findClassifierForComponentPrototype(
										callContextSubcomponent.getClassifier(), callContextSubcomponent,
										(ComponentPrototype) access.getPrototype());
							}
							if (classifier != null) {
								NamedElement portSearchResult = classifier.findNamedElement(portName);
								if (portSearchResult instanceof Port) {
									triggerPort.setContext(subprogramCall);
									triggerPort.setPort((Port) portSearchResult);
								} else
									errManager.error(triggerPort, '\'' + contextName + '.' + portName
											+ "' is not a port");
							} else
								errManager
										.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
						} else if (callContextSubcomponent.getPrototype() != null) {
							Classifier prototypeContext = findClassifierForComponentPrototype(
									getContainingClassifier(triggerPort), callContextSubcomponent.getPrototype());
							if (prototypeContext != null) {
								ComponentClassifier classifier = findClassifierForComponentPrototype(prototypeContext,
										(ComponentPrototype) access.getPrototype());
								if (classifier != null) {
									NamedElement portSearchResult = classifier.findNamedElement(portName);
									if (portSearchResult instanceof Port) {
										triggerPort.setContext(subprogramCall);
										triggerPort.setPort((Port) portSearchResult);
									} else
										errManager.error(triggerPort, '\'' + contextName + '.' + portName
												+ "' is not a port");
								} else
									errManager.error(triggerPort, '\'' + portName + "' not found in '" + contextName
											+ '\'');
							} else
								errManager
										.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
						} else
							errManager.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
					} else //callContext is null.
					{
						ComponentClassifier classifier = findClassifierForComponentPrototype(
								getContainingClassifier(triggerPort), (ComponentPrototype) access.getPrototype());
						if (classifier != null) {
							NamedElement portSearchResult = classifier.findNamedElement(portName);
							if (portSearchResult instanceof Port) {
								triggerPort.setContext(subprogramCall);
								triggerPort.setPort((Port) portSearchResult);
							} else
								errManager.error(triggerPort, '\'' + contextName + '.' + portName + "' is not a port");
						} else
							errManager.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
					}
				} else
					errManager.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
			} else //subprogramCall.getCalledSubprogram() is null.  The subprogram call refers to a prototype.
			{
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(triggerPort), (ComponentPrototype) subprogramCall.getPrototype());
				if (classifier != null) {
					NamedElement portSearchResult = classifier.findNamedElement(portName);
					if (portSearchResult instanceof Port) {
						triggerPort.setContext(subprogramCall);
						triggerPort.setPort((Port) portSearchResult);
					} else
						errManager.error(triggerPort, '\'' + contextName + '.' + portName + "' is not a port");
				} else
					errManager.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
			}
		} else if (contextSearchResult instanceof ProcessorCall)
			errManager.error(triggerPort, '\'' + portName + "' not found in '" + contextName + '\'');
		else if (contextSearchResult != null)
			errManager.error(triggerPort, '\'' + contextName
					+ "' is not a subcomponent, feature group, or subprogram call");
		else
			errManager.error(triggerPort, '\'' + contextName + "' not found");
	}

	private void casePropertyOrConstantReference(Element propertyValueOwner, String signAsString,
			String propertySetName, String propertyOrConstantName) {
		OperationKind sign;
		if (signAsString == null)
			sign = null;
		else if (signAsString.equals("+"))
			sign = OperationKind.PLUS;
		else if (signAsString.equals("-"))
			sign = OperationKind.MINUS;
		else
			throw new IllegalArgumentException("signAsString must be \"+\" or \"-\".");
		NamedElement searchResult = findNamedElementInPropertySet(propertySetName, propertyOrConstantName,
				getContainingTopLevelNamespace(propertyValueOwner));
		if (searchResult instanceof Property) {
			PropertyReference propertyReference;
			if (sign != null) {
				Operation operation;
				if (propertyValueOwner instanceof PropertyConstant)
					operation = (Operation) ((PropertyConstant) propertyValueOwner).createConstantValue(aadl2Package
							.getOperation());
				else if (propertyValueOwner instanceof Property)
					operation = (Operation) ((Property) propertyValueOwner).createDefaultValue(aadl2Package
							.getOperation());
				else if (propertyValueOwner instanceof BasicPropertyAssociation)
					operation = (Operation) ((BasicPropertyAssociation) propertyValueOwner)
							.createOwnedValue(aadl2Package.getOperation());
				else if (propertyValueOwner instanceof ModalPropertyValue)
					operation = (Operation) ((ModalPropertyValue) propertyValueOwner).createOwnedValue(aadl2Package
							.getOperation());
				else if (propertyValueOwner instanceof ListValue)
					operation = (Operation) ((ListValue) propertyValueOwner).createOwnedListElement(aadl2Package
							.getOperation());
				else {
					errManager.internalError("Problem in NameResolver.casePropertyOrConstantReference."
							+ "  Unaccounted for situation with model object: " + propertyValueOwner);
					return;
				}
				operation.setOp(sign);
				propertyReference = (PropertyReference) operation.createOwnedPropertyExpression(aadl2Package
						.getPropertyReference());
			} else if (propertyValueOwner instanceof PropertyConstant) {
				propertyReference = (PropertyReference) ((PropertyConstant) propertyValueOwner)
						.createConstantValue(aadl2Package.getPropertyReference());
			} else if (propertyValueOwner instanceof Property)
				propertyReference = (PropertyReference) ((Property) propertyValueOwner).createDefaultValue(aadl2Package
						.getPropertyReference());
			else if (propertyValueOwner instanceof BasicPropertyAssociation) {
				propertyReference = (PropertyReference) ((BasicPropertyAssociation) propertyValueOwner)
						.createOwnedValue(aadl2Package.getPropertyReference());
			} else if (propertyValueOwner instanceof ModalPropertyValue) {
				propertyReference = (PropertyReference) ((ModalPropertyValue) propertyValueOwner)
						.createOwnedValue(aadl2Package.getPropertyReference());
			} else if (propertyValueOwner instanceof ListValue) {
				propertyReference = (PropertyReference) ((ListValue) propertyValueOwner)
						.createOwnedListElement(aadl2Package.getPropertyReference());
			} else {
				errManager.internalError("Problem in NameResolver.casePropertyOrConstantReference."
						+ "  Unaccounted for situation with model object: " + propertyValueOwner);
				return;
			}
			propertyReference.setProperty((Property) searchResult);
		} else if (searchResult instanceof PropertyConstant) {
			ConstantValue constantValue;
			if (sign != null) {
				Operation operation;
				if (propertyValueOwner instanceof PropertyConstant)
					operation = (Operation) ((PropertyConstant) propertyValueOwner).createConstantValue(aadl2Package
							.getOperation());
				else if (propertyValueOwner instanceof Property)
					operation = (Operation) ((Property) propertyValueOwner).createDefaultValue(aadl2Package
							.getOperation());
				else if (propertyValueOwner instanceof BasicPropertyAssociation)
					operation = (Operation) ((BasicPropertyAssociation) propertyValueOwner)
							.createOwnedValue(aadl2Package.getOperation());
				else if (propertyValueOwner instanceof ModalPropertyValue)
					operation = (Operation) ((ModalPropertyValue) propertyValueOwner).createOwnedValue(aadl2Package
							.getOperation());
				else if (propertyValueOwner instanceof ListValue)
					operation = (Operation) ((ListValue) propertyValueOwner).createOwnedListElement(aadl2Package
							.getOperation());
				else {
					errManager.internalError("Problem in NameResolver.casePropertyOrConstantReference."
							+ "  Unaccounted for situation with model object: " + propertyValueOwner);
					return;
				}
				operation.setOp(sign);
				constantValue = (ConstantValue) operation
						.createOwnedPropertyExpression(aadl2Package.getConstantValue());
			} else if (propertyValueOwner instanceof PropertyConstant)
				constantValue = (ConstantValue) ((PropertyConstant) propertyValueOwner)
						.createConstantValue(aadl2Package.getConstantValue());
			else if (propertyValueOwner instanceof Property)
				constantValue = (ConstantValue) ((Property) propertyValueOwner).createDefaultValue(aadl2Package
						.getConstantValue());
			else if (propertyValueOwner instanceof BasicPropertyAssociation) {
				constantValue = (ConstantValue) ((BasicPropertyAssociation) propertyValueOwner)
						.createOwnedValue(aadl2Package.getConstantValue());
			} else if (propertyValueOwner instanceof ModalPropertyValue)
				constantValue = (ConstantValue) ((ModalPropertyValue) propertyValueOwner).createOwnedValue(aadl2Package
						.getConstantValue());
			else if (propertyValueOwner instanceof ListValue)
				constantValue = (ConstantValue) ((ListValue) propertyValueOwner).createOwnedListElement(aadl2Package
						.getConstantValue());
			else {
				errManager.internalError("Problem in NameResolver.casePropertyOrConstantReference."
						+ "  Unaccounted for situation with model object: " + propertyValueOwner);
				return;
			}
			constantValue.setConstant((PropertyConstant) searchResult);
		} else if (searchResult != null) {
			errManager.error(propertyValueOwner, '\'' + getQualifiedName(propertySetName, propertyOrConstantName)
					+ "' is not a property definition or a property constant");
		} else
			errManager.error(propertyValueOwner, '\'' + getQualifiedName(propertySetName, propertyOrConstantName)
					+ "' not found");
	}

	private void caseEnumerationLiteralOrPropertyOrConstantReference(Element propertyValueOwner,
			String literalOrPropertyOrConstantName) {
		Element propertyValueOwnerAboveList = propertyValueOwner;
		while (propertyValueOwnerAboveList instanceof ListValue)
			propertyValueOwnerAboveList = propertyValueOwnerAboveList.getOwner();
		PropertyType propertyType;
		if (propertyValueOwnerAboveList instanceof PropertyConstant)
			propertyType = (PropertyType) ((PropertyConstant) propertyValueOwnerAboveList).getType();
		else if (propertyValueOwnerAboveList instanceof Property)
			propertyType = (PropertyType) ((Property) propertyValueOwnerAboveList).getType();
		else if (propertyValueOwnerAboveList instanceof BasicPropertyAssociation)
			propertyType = (PropertyType) ((BasicPropertyAssociation) propertyValueOwnerAboveList).getProperty()
					.getType();
		else if (propertyValueOwnerAboveList instanceof ModalPropertyValue) {
			propertyType = (PropertyType) ((PropertyAssociation) ((ModalPropertyValue) propertyValueOwnerAboveList)
					.getOwner()).getProperty().getType();
		} else {
			errManager.internalError("Problem in NameResolver.caseEnumerationLiteralOrPropertyOrConstantReference."
					+ "  Unaccounted for situation with model object: " + propertyValueOwner);
			return;
		}
		if (propertyType instanceof EnumerationType) {
			EnumerationLiteral literal = (EnumerationLiteral) ((EnumerationType) propertyType)
					.findNamedElement(literalOrPropertyOrConstantName);
			if (literal != null) {
				EnumerationValue enumValue;
				if (propertyValueOwner instanceof PropertyConstant) {
					enumValue = (EnumerationValue) ((PropertyConstant) propertyValueOwner)
							.createConstantValue(aadl2Package.getEnumerationValue());
				} else if (propertyValueOwner instanceof Property)
					enumValue = (EnumerationValue) ((Property) propertyValueOwner).createDefaultValue(aadl2Package
							.getEnumerationValue());
				else if (propertyValueOwner instanceof BasicPropertyAssociation) {
					enumValue = (EnumerationValue) ((BasicPropertyAssociation) propertyValueOwner)
							.createOwnedValue(aadl2Package.getEnumerationValue());
				} else if (propertyValueOwner instanceof ModalPropertyValue) {
					enumValue = (EnumerationValue) ((ModalPropertyValue) propertyValueOwner)
							.createOwnedValue(aadl2Package.getEnumerationValue());
				} else if (propertyValueOwner instanceof ListValue)
					enumValue = (EnumerationValue) ((ListValue) propertyValueOwner).createOwnedListElement(aadl2Package
							.getEnumerationValue());
				else {
					errManager
							.internalError("Problem in NameResolver.caseEnumerationLiteralOrPropertyOrConstantReference."
									+ "  Unaccounted for situation with model object: " + propertyValueOwner);
					return;
				}
				enumValue.setLiteral(literal);
			} else
				errManager.error(propertyValueOwner, '\'' + literalOrPropertyOrConstantName + "' not found");
		} else
			casePropertyOrConstantReference(propertyValueOwner, null, null, literalOrPropertyOrConstantName);
	}

	private void caseFeatureGroupConnectionSourceContextReference(FeatureGroupConnection connection,
			String sourceContextName) {
		NamedElement searchResult = getContainingClassifier(connection).findNamedElement(sourceContextName);
		if (searchResult instanceof Subcomponent || searchResult instanceof FeatureGroup)
			connection.setSourceContext((Context) searchResult);
		else if (searchResult != null)
			errManager.error(connection, '\'' + sourceContextName + "' is not a subcomponent or a feature group");
		else
			errManager.error(connection, '\'' + sourceContextName + "' not found");
	}

	private void caseFeatureGroupConnectionDestinationContextReference(FeatureGroupConnection connection,
			String destinationContextName) {
		NamedElement searchResult = getContainingClassifier(connection).findNamedElement(destinationContextName);
		if (searchResult instanceof Subcomponent || searchResult instanceof FeatureGroup)
			connection.setDestinationContext((Context) searchResult);
		else if (searchResult != null)
			errManager.error(connection, '\'' + destinationContextName + "' is not a subcomponent or a feature group");
		else
			errManager.error(connection, '\'' + destinationContextName + "' not found");
	}

	private void caseFeatureGroupConnectionSourceReference(FeatureGroupConnection connection,
			String sourceFeatureGroupName) {
		if (connection.getSourceContext() == null) {
			NamedElement searchResult = getContainingClassifier(connection).findNamedElement(sourceFeatureGroupName);
			if (searchResult instanceof FeatureGroupConnectionEnd)
				connection.setSource((FeatureGroupConnectionEnd) searchResult);
			else if (searchResult != null)
				errManager.error(connection, '\'' + sourceFeatureGroupName + "' is not a feature group");
			else
				errManager.error(connection, '\'' + sourceFeatureGroupName + "' not found");
		} else if (connection.getSourceContext() instanceof Subcomponent) {
			Subcomponent subcomponent = (Subcomponent) connection.getSourceContext();
			while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement searchResult = subcomponent.getClassifier().findNamedElement(sourceFeatureGroupName);
				if (searchResult instanceof FeatureGroupConnectionEnd)
					connection.setSource((FeatureGroupConnectionEnd) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + subcomponent.getName() + '.' + sourceFeatureGroupName
							+ "' is not a feature group");
				else
					errManager.error(connection,
							'\'' + sourceFeatureGroupName + "' not found in '" + subcomponent.getName() + '\'');
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection), subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier.findNamedElement(sourceFeatureGroupName);
					if (searchResult instanceof FeatureGroupConnectionEnd)
						connection.setSource((FeatureGroupConnectionEnd) searchResult);
					else if (searchResult != null) {
						errManager.error(connection, '\'' + subcomponent.getName() + '.' + sourceFeatureGroupName
								+ "' is not a feature group");
					} else
						errManager.error(connection,
								'\'' + sourceFeatureGroupName + "' not found in '" + subcomponent.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + sourceFeatureGroupName + "' not found in '" + subcomponent.getName() + '\'');
			} else
				errManager.error(connection,
						'\'' + sourceFeatureGroupName + "' not found in '" + subcomponent.getName() + '\'');
		} else //connection.getSourceContext() is a FeatureGroup
		{
			FeatureGroup featureGroup = (FeatureGroup) connection.getSourceContext();
			while (featureGroup.getFeatureGroupType() == null && featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType().findNamedElement(sourceFeatureGroupName);
				if (searchResult instanceof FeatureGroupConnectionEnd)
					connection.setSource((FeatureGroupConnectionEnd) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + featureGroup.getName() + '.' + sourceFeatureGroupName
							+ "' is not a feature group");
				else
					errManager.error(connection,
							'\'' + sourceFeatureGroupName + "' not found in '" + featureGroup.getName() + '\'');
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(connection), (FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType.findNamedElement(sourceFeatureGroupName);
					if (searchResult instanceof FeatureGroupConnectionEnd)
						connection.setSource((FeatureGroupConnectionEnd) searchResult);
					else if (searchResult != null) {
						errManager.error(connection, '\'' + featureGroup.getName() + '.' + sourceFeatureGroupName
								+ "' is not a feature group");
					} else
						errManager.error(connection,
								'\'' + sourceFeatureGroupName + "' not found in '" + featureGroup.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + sourceFeatureGroupName + "' not found in '" + featureGroup.getName() + '\'');
			} else
				errManager.error(connection,
						'\'' + sourceFeatureGroupName + "' not found in '" + featureGroup.getName() + '\'');
		}
	}

	private void caseFeatureGroupConnectionDestinationReference(FeatureGroupConnection connection,
			String destinationFeatureGroupName) {
		if (connection.getDestinationContext() == null) {
			NamedElement searchResult = getContainingClassifier(connection).findNamedElement(
					destinationFeatureGroupName);
			if (searchResult instanceof FeatureGroupConnectionEnd)
				connection.setDestination((FeatureGroupConnectionEnd) searchResult);
			else if (searchResult != null)
				errManager.error(connection, '\'' + destinationFeatureGroupName + "' is not a feature group");
			else
				errManager.error(connection, '\'' + destinationFeatureGroupName + "' not found");
		} else if (connection.getDestinationContext() instanceof Subcomponent) {
			Subcomponent subcomponent = (Subcomponent) connection.getDestinationContext();
			while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement searchResult = subcomponent.getClassifier().findNamedElement(destinationFeatureGroupName);
				if (searchResult instanceof FeatureGroupConnectionEnd)
					connection.setDestination((FeatureGroupConnectionEnd) searchResult);
				else if (searchResult != null) {
					errManager.error(connection, '\'' + subcomponent.getName() + '.' + destinationFeatureGroupName
							+ "' is not a feature group");
				} else
					errManager.error(connection,
							'\'' + destinationFeatureGroupName + "' not found in '" + subcomponent.getName() + '\'');
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection), subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier.findNamedElement(destinationFeatureGroupName);
					if (searchResult instanceof FeatureGroupConnectionEnd)
						connection.setDestination((FeatureGroupConnectionEnd) searchResult);
					else if (searchResult != null) {
						errManager.error(connection, '\'' + subcomponent.getName() + '.' + destinationFeatureGroupName
								+ "' is not a feature group");
					} else
						errManager.error(connection, '\'' + destinationFeatureGroupName + "' not found in '"
								+ subcomponent.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + destinationFeatureGroupName + "' not found in '" + subcomponent.getName() + '\'');
			} else
				errManager.error(connection,
						'\'' + destinationFeatureGroupName + "' not found in '" + subcomponent.getName() + '\'');
		} else //connection.getDestinationContext() is a FeatureGroup
		{
			FeatureGroup featureGroup = (FeatureGroup) connection.getDestinationContext();
			while (featureGroup.getFeatureGroupType() == null && featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType().findNamedElement(
						destinationFeatureGroupName);
				if (searchResult instanceof FeatureGroupConnectionEnd)
					connection.setDestination((FeatureGroupConnectionEnd) searchResult);
				else if (searchResult != null) {
					errManager.error(connection, '\'' + featureGroup.getName() + '.' + destinationFeatureGroupName
							+ "' is not a feature group");
				} else
					errManager.error(connection,
							'\'' + destinationFeatureGroupName + "' not found in '" + featureGroup.getName() + '\'');
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(connection), (FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType.findNamedElement(destinationFeatureGroupName);
					if (searchResult instanceof FeatureGroupConnectionEnd)
						connection.setDestination((FeatureGroupConnectionEnd) searchResult);
					else if (searchResult != null) {
						errManager.error(connection, '\'' + featureGroup.getName() + '.' + destinationFeatureGroupName
								+ "' is not a feature group");
					} else
						errManager.error(connection, '\'' + destinationFeatureGroupName + "' not found in '"
								+ featureGroup.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + destinationFeatureGroupName + "' not found in '" + featureGroup.getName() + '\'');
			} else
				errManager.error(connection,
						'\'' + destinationFeatureGroupName + "' not found in '" + featureGroup.getName() + '\'');
		}
	}

	private void caseFeatureConnectionSourceContextReference(FeatureConnection connection, String sourceContextName) {
		NamedElement searchResult = getContainingClassifier(connection).findNamedElement(sourceContextName);
		if (searchResult instanceof Subcomponent || searchResult instanceof FeatureGroup)
			connection.setSourceContext((Context) searchResult);
		else if (searchResult != null)
			errManager.error(connection, '\'' + sourceContextName + "' is not a subcomponent or a feature group");
		else
			errManager.error(connection, '\'' + sourceContextName + "' not found");
	}

	private void caseFeatureConnectionDestinationContextReference(FeatureConnection connection,
			String destinationContextName) {
		NamedElement searchResult = getContainingClassifier(connection).findNamedElement(destinationContextName);
		if (searchResult instanceof Subcomponent || searchResult instanceof FeatureGroup)
			connection.setDestinationContext((Context) searchResult);
		else if (searchResult != null)
			errManager.error(connection, '\'' + destinationContextName + "' is not a subcomponent or a feature group");
		else
			errManager.error(connection, '\'' + destinationContextName + "' not found");
	}

	private void caseFeatureConnectionSourceReference(FeatureConnection connection, String sourceFeatureName) {
		if (connection.getSourceContext() == null) {
			NamedElement searchResult = getContainingClassifier(connection).findNamedElement(sourceFeatureName);
			if (searchResult instanceof FeatureConnectionEnd)
				connection.setSource((FeatureConnectionEnd) searchResult);
			else if (searchResult != null)
				errManager.error(connection, '\'' + sourceFeatureName + "' is not a feature");
			else
				errManager.error(connection, '\'' + sourceFeatureName + "' not found");
		} else if (connection.getSourceContext() instanceof Subcomponent) {
			Subcomponent subcomponent = (Subcomponent) connection.getSourceContext();
			while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement searchResult = subcomponent.getClassifier().findNamedElement(sourceFeatureName);
				if (searchResult instanceof FeatureConnectionEnd)
					connection.setSource((FeatureConnectionEnd) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + subcomponent.getName() + '.' + sourceFeatureName
							+ "' is not a feature");
				else
					errManager.error(connection, '\'' + sourceFeatureName + "' not found in '" + subcomponent.getName()
							+ '\'');
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection), subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier.findNamedElement(sourceFeatureName);
					if (searchResult instanceof FeatureConnectionEnd)
						connection.setSource((FeatureConnectionEnd) searchResult);
					else if (searchResult != null)
						errManager.error(connection, '\'' + subcomponent.getName() + '.' + sourceFeatureName
								+ "' is not a feature");
					else
						errManager.error(connection,
								'\'' + sourceFeatureName + "' not found in '" + subcomponent.getName() + '\'');
				} else
					errManager.error(connection, '\'' + sourceFeatureName + "' not found in '" + subcomponent.getName()
							+ '\'');
			} else
				errManager.error(connection, '\'' + sourceFeatureName + "' not found in '" + subcomponent.getName()
						+ '\'');
		} else //connection.getSourceContext() is a FeatureGroup
		{
			FeatureGroup featureGroup = (FeatureGroup) connection.getSourceContext();
			while (featureGroup.getFeatureGroupType() == null && featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType().findNamedElement(sourceFeatureName);
				if (searchResult instanceof FeatureConnectionEnd)
					connection.setSource((FeatureConnectionEnd) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + featureGroup.getName() + '.' + sourceFeatureName
							+ "' is not a feature");
				else
					errManager.error(connection, '\'' + sourceFeatureName + "' not found in '" + featureGroup.getName()
							+ '\'');
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(connection), (FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType.findNamedElement(sourceFeatureName);
					if (searchResult instanceof FeatureConnectionEnd)
						connection.setSource((FeatureConnectionEnd) searchResult);
					else if (searchResult != null)
						errManager.error(connection, '\'' + featureGroup.getName() + '.' + sourceFeatureName
								+ "' is not a feature");
					else
						errManager.error(connection,
								'\'' + sourceFeatureName + "' not found in '" + featureGroup.getName() + '\'');
				} else
					errManager.error(connection, '\'' + sourceFeatureName + "' not found in '" + featureGroup.getName()
							+ '\'');
			} else
				errManager.error(connection, '\'' + sourceFeatureName + "' not found in '" + featureGroup.getName()
						+ '\'');
		}
	}

	private void caseFeatureConnectionDestinationReference(FeatureConnection connection, String destinationFeatureName) {
		if (connection.getDestinationContext() == null) {
			NamedElement searchResult = getContainingClassifier(connection).findNamedElement(destinationFeatureName);
			if (searchResult instanceof FeatureConnectionEnd)
				connection.setDestination((FeatureConnectionEnd) searchResult);
			else if (searchResult != null)
				errManager.error(connection, '\'' + destinationFeatureName + "' is not a feature");
			else
				errManager.error(connection, '\'' + destinationFeatureName + "' not found");
		} else if (connection.getDestinationContext() instanceof Subcomponent) {
			Subcomponent subcomponent = (Subcomponent) connection.getDestinationContext();
			while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement searchResult = subcomponent.getClassifier().findNamedElement(destinationFeatureName);
				if (searchResult instanceof FeatureConnectionEnd)
					connection.setDestination((FeatureConnectionEnd) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + subcomponent.getName() + '.' + destinationFeatureName
							+ "' is not a feature");
				else
					errManager.error(connection,
							'\'' + destinationFeatureName + "' not found in '" + subcomponent.getName() + '\'');
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection), subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier.findNamedElement(destinationFeatureName);
					if (searchResult instanceof FeatureConnectionEnd)
						connection.setDestination((FeatureConnectionEnd) searchResult);
					else if (searchResult != null)
						errManager.error(connection, '\'' + subcomponent.getName() + '.' + destinationFeatureName
								+ "' is not a feature");
					else
						errManager.error(connection,
								'\'' + destinationFeatureName + "' not found in '" + subcomponent.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + destinationFeatureName + "' not found in '" + subcomponent.getName() + '\'');
			} else
				errManager.error(connection,
						'\'' + destinationFeatureName + "' not found in '" + subcomponent.getName() + '\'');
		} else //connection.getDestinationContext() is a FeatureGroup
		{
			FeatureGroup featureGroup = (FeatureGroup) connection.getDestinationContext();
			while (featureGroup.getFeatureGroupType() == null && featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType().findNamedElement(destinationFeatureName);
				if (searchResult instanceof FeatureConnectionEnd)
					connection.setDestination((FeatureConnectionEnd) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + featureGroup.getName() + '.' + destinationFeatureName
							+ "' is not a feature");
				else
					errManager.error(connection,
							'\'' + destinationFeatureName + "' not found in '" + featureGroup.getName() + '\'');
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(connection), (FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType.findNamedElement(destinationFeatureName);
					if (searchResult instanceof FeatureConnectionEnd)
						connection.setDestination((FeatureConnectionEnd) searchResult);
					else if (searchResult != null)
						errManager.error(connection, '\'' + featureGroup.getName() + '.' + destinationFeatureName
								+ "' is not a feature");
					else
						errManager.error(connection,
								'\'' + destinationFeatureName + "' not found in '" + featureGroup.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + destinationFeatureName + "' not found in '" + featureGroup.getName() + '\'');
			} else
				errManager.error(connection,
						'\'' + destinationFeatureName + "' not found in '" + featureGroup.getName() + '\'');
		}
	}

	private void caseAccessConnectionSourceContextReference(AccessConnection connection, String sourceContextName) {
		NamedElement searchResult = getContainingClassifier(connection).findNamedElement(sourceContextName);
		if (searchResult instanceof FeatureGroup || searchResult instanceof Subcomponent)
			connection.setSourceContext((Context) searchResult);
		else if (searchResult != null)
			errManager.error(connection, '\'' + sourceContextName + "' is not a feature group or a subcomponent");
		else
			errManager.error(connection, '\'' + sourceContextName + "' not found");
	}

	private void caseAccessConnectionDestinationContextReference(AccessConnection connection,
			String destinationContextName) {
		NamedElement searchResult = getContainingClassifier(connection).findNamedElement(destinationContextName);
		if (searchResult instanceof FeatureGroup || searchResult instanceof Subcomponent)
			connection.setDestinationContext((Context) searchResult);
		else if (searchResult != null)
			errManager.error(connection, '\'' + destinationContextName + "' is not a feature group or a subcomponent");
		else
			errManager.error(connection, '\'' + destinationContextName + "' not found");
	}

	private void caseAccessConnectionSourceReference(AccessConnection connection, String sourceAccessName) {
		if (connection.getSourceContext() == null) {
			NamedElement searchResult = getContainingClassifier(connection).findNamedElement(sourceAccessName);
			if (searchResult instanceof AccessConnectionEnd)
				connection.setSource((AccessConnectionEnd) searchResult);
			else if (searchResult != null) {
				errManager.error(connection, '\'' + sourceAccessName
						+ "' is not an access feature or a data, bus, subprogram, or subprogram group subcomponent");
			} else
				errManager.error(connection, '\'' + sourceAccessName + "' not found");
		} else if (connection.getSourceContext() instanceof FeatureGroup) {
			FeatureGroup featureGroup = (FeatureGroup) connection.getSourceContext();
			while (featureGroup.getFeatureGroupType() == null && featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType().findNamedElement(sourceAccessName);
				if (searchResult instanceof Access)
					connection.setSource((Access) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + featureGroup.getName() + '.' + sourceAccessName
							+ "' is not an access feature");
				else
					errManager.error(connection, '\'' + sourceAccessName + "' not found in '" + featureGroup.getName()
							+ '\'');
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(connection), (FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType.findNamedElement(sourceAccessName);
					if (searchResult instanceof Access)
						connection.setSource((Access) searchResult);
					else if (searchResult != null)
						errManager.error(connection, '\'' + featureGroup.getName() + '.' + sourceAccessName
								+ "' is not an access feature");
					else
						errManager.error(connection,
								'\'' + sourceAccessName + "' not found in '" + featureGroup.getName() + '\'');
				} else
					errManager.error(connection, '\'' + sourceAccessName + "' not found in '" + featureGroup.getName()
							+ '\'');
			} else
				errManager.error(connection, '\'' + sourceAccessName + "' not found in '" + featureGroup.getName()
						+ '\'');
		} else //connection.getSourceContext() is a Subcomponent
		{
			Subcomponent subcomponent = (Subcomponent) connection.getSourceContext();
			while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement searchResult = subcomponent.getClassifier().findNamedElement(sourceAccessName);
				if (searchResult instanceof Access)
					connection.setSource((Access) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + subcomponent.getName() + '.' + sourceAccessName
							+ "' is not an access feature");
				else
					errManager.error(connection, '\'' + sourceAccessName + "' not found in '" + subcomponent.getName()
							+ '\'');
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection), subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier.findNamedElement(sourceAccessName);
					if (searchResult instanceof Access)
						connection.setSource((Access) searchResult);
					else if (searchResult != null)
						errManager.error(connection, '\'' + subcomponent.getName() + '.' + sourceAccessName
								+ "' is not an access feature");
					else
						errManager.error(connection,
								'\'' + sourceAccessName + "' not found in '" + subcomponent.getName() + '\'');
				} else
					errManager.error(connection, '\'' + sourceAccessName + "' not found in '" + subcomponent.getName()
							+ '\'');
			} else
				errManager.error(connection, '\'' + sourceAccessName + "' not found in '" + subcomponent.getName()
						+ '\'');
		}
	}

	private void caseAccessConnectionDestinationReference(AccessConnection connection, String destinationAccessName) {
		if (connection.getDestinationContext() == null) {
			NamedElement searchResult = getContainingClassifier(connection).findNamedElement(destinationAccessName);
			if (searchResult instanceof AccessConnectionEnd)
				connection.setDestination((AccessConnectionEnd) searchResult);
			else if (searchResult != null) {
				errManager.error(connection, '\'' + destinationAccessName
						+ "' is not an access feature or a data, bus, subprogram, or subprogram group subcomponent");
			} else
				errManager.error(connection, '\'' + destinationAccessName + "' not found");
		} else if (connection.getDestinationContext() instanceof FeatureGroup) {
			FeatureGroup featureGroup = (FeatureGroup) connection.getDestinationContext();
			while (featureGroup.getFeatureGroupType() == null && featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType().findNamedElement(destinationAccessName);
				if (searchResult instanceof Access)
					connection.setDestination((Access) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + featureGroup.getName() + '.' + destinationAccessName
							+ "' is not an access feature");
				else
					errManager.error(connection,
							'\'' + destinationAccessName + "' not found in '" + featureGroup.getName() + '\'');
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(connection), (FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType.findNamedElement(destinationAccessName);
					if (searchResult instanceof Access)
						connection.setDestination((Access) searchResult);
					else if (searchResult != null) {
						errManager.error(connection, '\'' + featureGroup.getName() + '.' + destinationAccessName
								+ "' is not an access feature");
					} else
						errManager.error(connection,
								'\'' + destinationAccessName + "' not found in '" + featureGroup.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + destinationAccessName + "' not found in '" + featureGroup.getName() + '\'');
			} else
				errManager.error(connection, '\'' + destinationAccessName + "' not found in '" + featureGroup.getName()
						+ '\'');
		} else //connection.getDestinationContext() is a Subcomponent
		{
			Subcomponent subcomponent = (Subcomponent) connection.getDestinationContext();
			while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement searchResult = subcomponent.getClassifier().findNamedElement(destinationAccessName);
				if (searchResult instanceof Access)
					connection.setDestination((Access) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + subcomponent.getName() + '.' + destinationAccessName
							+ "' is not an access feature");
				else
					errManager.error(connection,
							'\'' + destinationAccessName + "' not found in '" + subcomponent.getName() + '\'');
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection), subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier.findNamedElement(destinationAccessName);
					if (searchResult instanceof Access)
						connection.setDestination((Access) searchResult);
					else if (searchResult != null) {
						errManager.error(connection, '\'' + subcomponent.getName() + '.' + destinationAccessName
								+ "' is not an access feature");
					} else
						errManager.error(connection,
								'\'' + destinationAccessName + "' not found in '" + subcomponent.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + destinationAccessName + "' not found in '" + subcomponent.getName() + '\'');
			} else
				errManager.error(connection, '\'' + destinationAccessName + "' not found in '" + subcomponent.getName()
						+ '\'');
		}
	}

	private void caseParameterConnectionSourceContextReference(ParameterConnection connection, String sourceContextName) {
		NamedElement searchResult = getContainingClassifier(connection).findNamedElement(sourceContextName);
		if (searchResult instanceof Parameter || searchResult instanceof SubprogramCall
				|| searchResult instanceof DataPort || searchResult instanceof EventDataPort
				|| searchResult instanceof FeatureGroup) {
			connection.setSourceContext((Context) searchResult);
		} else if (searchResult != null) {
			errManager.error(connection, '\'' + sourceContextName
					+ "' is not a parameter, data port, event data port, feature group, or subprogram call");
		} else
			errManager.error(connection, '\'' + sourceContextName + "' not found");
	}

	private void caseParameterConnectionDestinationContextReference(ParameterConnection connection,
			String destinationContextName) {
		NamedElement searchResult = getContainingClassifier(connection).findNamedElement(destinationContextName);
		if (searchResult instanceof Parameter || searchResult instanceof SubprogramCall
				|| searchResult instanceof DataPort || searchResult instanceof EventDataPort
				|| searchResult instanceof FeatureGroup) {
			connection.setDestinationContext((Context) searchResult);
		} else if (searchResult != null) {
			errManager.error(connection, '\'' + destinationContextName
					+ "' is not a parameter, data port, event data port, feature group, or subprogram call");
		} else
			errManager.error(connection, '\'' + destinationContextName + "' not found");
	}

	private void caseParameterConnectionSourceReference(ParameterConnection connection, String sourceParameterName) {
		if (connection.getSourceContext() == null) {
			NamedElement searchResult = getContainingClassifier(connection).findNamedElement(sourceParameterName);
			if (searchResult instanceof ParameterConnectionEnd)
				connection.setSource((ParameterConnectionEnd) searchResult);
			else if (searchResult != null) {
				errManager.error(connection, '\'' + sourceParameterName
						+ "' is not a parameter, data access, data port, event data port, or data subcomponent");
			} else
				errManager.error(connection, '\'' + sourceParameterName + "' not found");
		} else if (connection.getSourceContext() instanceof FeatureGroup) {
			FeatureGroup featureGroup = (FeatureGroup) connection.getSourceContext();
			while (featureGroup.getFeatureGroupType() == null && featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType().findNamedElement(sourceParameterName);
				if (searchResult instanceof ParameterConnectionEnd)
					connection.setSource((ParameterConnectionEnd) searchResult);
				else if (searchResult != null) {
					errManager.error(connection, '\'' + featureGroup.getName() + '.' + sourceParameterName
							+ "' is not a parameter, data access, data port, or event data port");
				} else
					errManager.error(connection,
							'\'' + sourceParameterName + "' not found in '" + featureGroup.getName() + '\'');
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(connection), (FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType.findNamedElement(sourceParameterName);
					if (searchResult instanceof ParameterConnectionEnd)
						connection.setSource((ParameterConnectionEnd) searchResult);
					else if (searchResult != null) {
						errManager.error(connection, '\'' + featureGroup.getName() + '.' + sourceParameterName
								+ "' is not a parameter, data access, data port, or event data port");
					} else
						errManager.error(connection,
								'\'' + sourceParameterName + "' not found in '" + featureGroup.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + sourceParameterName + "' not found in '" + featureGroup.getName() + '\'');
			} else
				errManager.error(connection, '\'' + sourceParameterName + "' not found in '" + featureGroup.getName()
						+ '\'');
		} else if (connection.getSourceContext() instanceof SubprogramCall) {
			SubprogramCall subprogramCall = (SubprogramCall) connection.getSourceContext();
			if (subprogramCall.getCalledSubprogram() instanceof SubprogramClassifier) {
				NamedElement searchResult = ((SubprogramClassifier) subprogramCall.getCalledSubprogram())
						.findNamedElement(sourceParameterName);
				if (searchResult instanceof Parameter)
					connection.setSource((Parameter) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + subprogramCall.getName() + '.' + sourceParameterName
							+ "' is not a parameter");
				else
					errManager.error(connection,
							'\'' + sourceParameterName + "' not found in '" + subprogramCall.getName() + '\'');
			} else if (subprogramCall.getCalledSubprogram() instanceof SubprogramSubcomponent) {
				Subcomponent subcomponent = (SubprogramSubcomponent) subprogramCall.getCalledSubprogram();
				while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
						&& subcomponent.getRefined() != null)
					subcomponent = subcomponent.getRefined();
				if (subcomponent.getClassifier() != null) {
					NamedElement searchResult = subcomponent.getClassifier().findNamedElement(sourceParameterName);
					if (searchResult instanceof Parameter)
						connection.setSource((Parameter) searchResult);
					else if (searchResult != null)
						errManager.error(connection, '\'' + subprogramCall.getName() + '.' + sourceParameterName
								+ "' is not a parameter");
					else
						errManager.error(connection,
								'\'' + sourceParameterName + "' not found in '" + subprogramCall.getName() + '\'');
				} else if (subcomponent.getPrototype() != null) {
					ComponentClassifier classifier = findClassifierForComponentPrototype(
							getContainingClassifier(connection), subcomponent.getPrototype());
					if (classifier != null) {
						NamedElement searchResult = classifier.findNamedElement(sourceParameterName);
						if (searchResult instanceof Parameter)
							connection.setSource((Parameter) searchResult);
						else if (searchResult != null) {
							errManager.error(connection, '\'' + subprogramCall.getName() + '.' + sourceParameterName
									+ "' is not a parameter");
						} else
							errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
									+ subprogramCall.getName() + '\'');
					} else
						errManager.error(connection,
								'\'' + sourceParameterName + "' not found in '" + subprogramCall.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + sourceParameterName + "' not found in '" + subprogramCall.getName() + '\'');
			} else if (subprogramCall.getCalledSubprogram() instanceof SubprogramAccess) {
				Feature access = (SubprogramAccess) subprogramCall.getCalledSubprogram();
				while (access.getClassifier() == null && access.getPrototype() == null && access.getRefined() != null)
					access = access.getRefined();
				if (access.getClassifier() != null) {
					NamedElement searchResult = access.getClassifier().findNamedElement(sourceParameterName);
					if (searchResult instanceof Parameter)
						connection.setSource((Parameter) searchResult);
					else if (searchResult != null)
						errManager.error(connection, '\'' + subprogramCall.getName() + '.' + sourceParameterName
								+ "' is not a parameter");
					else
						errManager.error(connection,
								'\'' + sourceParameterName + "' not found in '" + subprogramCall.getName() + '\'');
				} else if (access.getPrototype() instanceof ComponentPrototype) {
					CallContext callContext = subprogramCall.getContext();
					if (callContext instanceof AbstractType || callContext instanceof DataType
							|| callContext instanceof SubprogramGroupType) {
						ComponentClassifier classifier = findClassifierForComponentPrototype(
								(ComponentType) callContext, (ComponentPrototype) access.getPrototype());
						if (classifier != null) {
							NamedElement searchResult = classifier.findNamedElement(sourceParameterName);
							if (searchResult instanceof Parameter)
								connection.setSource((Parameter) searchResult);
							else if (searchResult != null) {
								errManager.error(connection, '\'' + subprogramCall.getName() + '.'
										+ sourceParameterName + "' is not a parameter");
							} else {
								errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
										+ subprogramCall.getName() + '\'');
							}
						} else
							errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
									+ subprogramCall.getName() + '\'');
					} else if (callContext instanceof FeatureGroup) {
						FeatureGroup callContextFeatureGroup = (FeatureGroup) callContext;
						FeatureGroupType prototypeContext;
						while (callContextFeatureGroup.getFeatureGroupType() == null
								&& callContextFeatureGroup.getPrototype() == null
								&& callContextFeatureGroup.getRefined() instanceof FeatureGroup) {
							callContextFeatureGroup = (FeatureGroup) callContextFeatureGroup.getRefined();
						}
						if (callContextFeatureGroup.getFeatureGroupType() != null)
							prototypeContext = callContextFeatureGroup.getFeatureGroupType();
						else if (callContextFeatureGroup.getPrototype() instanceof FeatureGroupPrototype) {
							prototypeContext = findFeatureGroupTypeForFeatureGroupPrototype(
									getContainingClassifier(connection),
									(FeatureGroupPrototype) callContextFeatureGroup.getPrototype());
						} else
							prototypeContext = null;
						if (prototypeContext != null) {
							ComponentClassifier classifier = findClassifierForComponentPrototype(prototypeContext,
									(ComponentPrototype) access.getPrototype());
							if (classifier != null) {
								NamedElement searchResult = classifier.findNamedElement(sourceParameterName);
								if (searchResult instanceof Parameter)
									connection.setSource((Parameter) searchResult);
								else if (searchResult != null) {
									errManager.error(connection, '\'' + subprogramCall.getName() + '.'
											+ sourceParameterName + "' is not a parameter");
								} else {
									errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
											+ subprogramCall.getName() + '\'');
								}
							} else {
								errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
										+ subprogramCall.getName() + '\'');
							}
						} else
							errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
									+ subprogramCall.getName() + '\'');
					} else if (callContext instanceof SubprogramGroupAccess) {
						Feature callContextAccess = (SubprogramGroupAccess) callContext;
						Classifier prototypeContext;
						while (callContextAccess.getClassifier() == null && callContextAccess.getPrototype() == null
								&& callContextAccess.getRefined() != null) {
							callContextAccess = callContextAccess.getRefined();
						}
						if (callContextAccess.getClassifier() != null)
							prototypeContext = callContextAccess.getClassifier();
						else if (callContextAccess.getPrototype() instanceof ComponentPrototype) {
							prototypeContext = findClassifierForComponentPrototype(getContainingClassifier(connection),
									(ComponentPrototype) callContextAccess.getPrototype());
						} else
							prototypeContext = null;
						if (prototypeContext != null) {
							ComponentClassifier classifier = findClassifierForComponentPrototype(prototypeContext,
									(ComponentPrototype) access.getPrototype());
							if (classifier != null) {
								NamedElement searchResult = classifier.findNamedElement(sourceParameterName);
								if (searchResult instanceof Parameter)
									connection.setSource((Parameter) searchResult);
								else if (searchResult != null) {
									errManager.error(connection, '\'' + subprogramCall.getName() + '.'
											+ sourceParameterName + "' is not a parameter");
								} else {
									errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
											+ subprogramCall.getName() + '\'');
								}
							} else {
								errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
										+ subprogramCall.getName() + '\'');
							}
						} else
							errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
									+ subprogramCall.getName() + '\'');
					} else if (callContext instanceof SubprogramGroupSubcomponent) {
						Subcomponent callContextSubcomponent = (SubprogramGroupSubcomponent) callContext;
						while (callContextSubcomponent.getClassifier() == null
								&& callContextSubcomponent.getPrototype() == null
								&& callContextSubcomponent.getRefined() != null) {
							callContextSubcomponent = callContextSubcomponent.getRefined();
						}
						if (callContextSubcomponent.getClassifier() != null) {
							ComponentClassifier classifier;
							if (callContextSubcomponent.getOwnedPrototypeBindings().isEmpty()) {
								classifier = findClassifierForComponentPrototype(
										callContextSubcomponent.getClassifier(),
										(ComponentPrototype) access.getPrototype());
							} else {
								classifier = findClassifierForComponentPrototype(
										callContextSubcomponent.getClassifier(), callContextSubcomponent,
										(ComponentPrototype) access.getPrototype());
							}
							if (classifier != null) {
								NamedElement searchResult = classifier.findNamedElement(sourceParameterName);
								if (searchResult instanceof Parameter)
									connection.setSource((Parameter) searchResult);
								else if (searchResult != null) {
									errManager.error(connection, '\'' + subprogramCall.getName() + '.'
											+ sourceParameterName + "' is not a parameter");
								} else {
									errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
											+ subprogramCall.getName() + '\'');
								}
							} else {
								errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
										+ subprogramCall.getName() + '\'');
							}
						} else if (callContextSubcomponent.getPrototype() != null) {
							Classifier prototypeContext = findClassifierForComponentPrototype(
									getContainingClassifier(connection), callContextSubcomponent.getPrototype());
							if (prototypeContext != null) {
								ComponentClassifier classifier = findClassifierForComponentPrototype(prototypeContext,
										(ComponentPrototype) access.getPrototype());
								if (classifier != null) {
									NamedElement searchResult = classifier.findNamedElement(sourceParameterName);
									if (searchResult instanceof Parameter)
										connection.setSource((Parameter) searchResult);
									else if (searchResult != null) {
										errManager.error(connection, '\'' + subprogramCall.getName() + '.'
												+ sourceParameterName + "' is not a parameter");
									} else {
										errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
												+ subprogramCall.getName() + '\'');
									}
								} else {
									errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
											+ subprogramCall.getName() + '\'');
								}
							} else {
								errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
										+ subprogramCall.getName() + '\'');
							}
						} else
							errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
									+ subprogramCall.getName() + '\'');
					} else //callContext is null.
					{
						ComponentClassifier classifier = findClassifierForComponentPrototype(
								getContainingClassifier(connection), (ComponentPrototype) access.getPrototype());
						if (classifier != null) {
							NamedElement searchResult = classifier.findNamedElement(sourceParameterName);
							if (searchResult instanceof Parameter)
								connection.setSource((Parameter) searchResult);
							else if (searchResult != null) {
								errManager.error(connection, '\'' + subprogramCall.getName() + '.'
										+ sourceParameterName + "' is not a parameter");
							} else {
								errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
										+ subprogramCall.getName() + '\'');
							}
						} else
							errManager.error(connection, '\'' + sourceParameterName + "' not found in '"
									+ subprogramCall.getName() + '\'');
					}
				} else
					errManager.error(connection,
							'\'' + sourceParameterName + "' not found in '" + subprogramCall.getName() + '\'');
			} else //subprogramCall.getCalledSubprogram() is null.  The subprogram call refers to a prototype.
			{
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection), (ComponentPrototype) subprogramCall.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier.findNamedElement(sourceParameterName);
					if (searchResult instanceof Parameter)
						connection.setSource((Parameter) searchResult);
					else if (searchResult != null)
						errManager.error(connection, '\'' + subprogramCall.getName() + '.' + sourceParameterName
								+ "' is not a parameter");
					else
						errManager.error(connection,
								'\'' + sourceParameterName + "' not found in '" + subprogramCall.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + sourceParameterName + "' not found in '" + subprogramCall.getName() + '\'');
			}
		} else //connection.getSourceContext() is a Parameter, DataPort, or EventDataPort
		{
			Feature sourceContext = (Feature) connection.getSourceContext();
			while (sourceContext.getClassifier() == null && sourceContext.getPrototype() == null
					&& sourceContext.getRefined() != null) {
				sourceContext = sourceContext.getRefined();
			}
			if (sourceContext.getClassifier() != null) {
				NamedElement searchResult = sourceContext.getClassifier().findNamedElement(sourceParameterName);
				if (searchResult instanceof DataSubcomponent)
					connection.setSource((DataSubcomponent) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + sourceContext.getName() + '.' + sourceParameterName
							+ "' is not a data subcomponent");
				else
					errManager.error(connection,
							'\'' + sourceParameterName + "' not found in '" + sourceContext.getName() + '\'');
			} else if (sourceContext.getPrototype() instanceof ComponentPrototype) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection), (ComponentPrototype) sourceContext.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier.findNamedElement(sourceParameterName);
					if (searchResult instanceof DataSubcomponent)
						connection.setSource((DataSubcomponent) searchResult);
					else if (searchResult != null)
						errManager.error(connection, '\'' + sourceContext.getName() + '.' + sourceParameterName
								+ "' is not a parameter");
					else
						errManager.error(connection,
								'\'' + sourceParameterName + "' not found in '" + sourceContext.getName() + '\'');
				}
			} else
				errManager.error(connection, '\'' + sourceParameterName + "' not found in '" + sourceContext.getName()
						+ '\'');
		}
	}

	private void caseParameterConnectionDestinationReference(ParameterConnection connection,
			String destinationParameterName) {
		if (connection.getDestinationContext() == null) {
			NamedElement searchResult = getContainingClassifier(connection).findNamedElement(destinationParameterName);
			if (searchResult instanceof ParameterConnectionEnd)
				connection.setDestination((ParameterConnectionEnd) searchResult);
			else if (searchResult != null) {
				errManager.error(connection, '\'' + destinationParameterName
						+ "' is not a parameter, data access, data port, event data port, or data subcomponent");
			} else
				errManager.error(connection, '\'' + destinationParameterName + "' not found");
		} else if (connection.getDestinationContext() instanceof FeatureGroup) {
			FeatureGroup featureGroup = (FeatureGroup) connection.getDestinationContext();
			while (featureGroup.getFeatureGroupType() == null && featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType().findNamedElement(
						destinationParameterName);
				if (searchResult instanceof ParameterConnectionEnd)
					connection.setDestination((ParameterConnectionEnd) searchResult);
				else if (searchResult != null) {
					errManager.error(connection, '\'' + featureGroup.getName() + '.' + destinationParameterName
							+ "' is not a parameter, data access, data port, or event data port");
				} else
					errManager.error(connection,
							'\'' + destinationParameterName + "' not found in '" + featureGroup.getName() + '\'');
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(connection), (FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType.findNamedElement(destinationParameterName);
					if (searchResult instanceof ParameterConnectionEnd)
						connection.setDestination((ParameterConnectionEnd) searchResult);
					else if (searchResult != null) {
						errManager.error(connection, '\'' + featureGroup.getName() + '.' + destinationParameterName
								+ "' is not a parameter, data access, data port, or event data port");
					} else
						errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
								+ featureGroup.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + destinationParameterName + "' not found in '" + featureGroup.getName() + '\'');
			} else
				errManager.error(connection,
						'\'' + destinationParameterName + "' not found in '" + featureGroup.getName() + '\'');
		} else if (connection.getDestinationContext() instanceof SubprogramCall) {
			SubprogramCall subprogramCall = (SubprogramCall) connection.getDestinationContext();
			if (subprogramCall.getCalledSubprogram() instanceof SubprogramClassifier) {
				NamedElement searchResult = ((SubprogramClassifier) subprogramCall.getCalledSubprogram())
						.findNamedElement(destinationParameterName);
				if (searchResult instanceof Parameter)
					connection.setDestination((Parameter) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + subprogramCall.getName() + '.' + destinationParameterName
							+ "' is not a parameter");
				else
					errManager.error(connection,
							'\'' + destinationParameterName + "' not found in '" + subprogramCall.getName() + '\'');
			} else if (subprogramCall.getCalledSubprogram() instanceof SubprogramSubcomponent) {
				Subcomponent subcomponent = (SubprogramSubcomponent) subprogramCall.getCalledSubprogram();
				while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
						&& subcomponent.getRefined() != null)
					subcomponent = subcomponent.getRefined();
				if (subcomponent.getClassifier() != null) {
					NamedElement searchResult = subcomponent.getClassifier().findNamedElement(destinationParameterName);
					if (searchResult instanceof Parameter)
						connection.setDestination((Parameter) searchResult);
					else if (searchResult != null) {
						errManager.error(connection, '\'' + subprogramCall.getName() + '.' + destinationParameterName
								+ "' is not a parameter");
					} else
						errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
								+ subprogramCall.getName() + '\'');
				} else if (subcomponent.getPrototype() != null) {
					ComponentClassifier classifier = findClassifierForComponentPrototype(
							getContainingClassifier(connection), subcomponent.getPrototype());
					if (classifier != null) {
						NamedElement searchResult = classifier.findNamedElement(destinationParameterName);
						if (searchResult instanceof Parameter)
							connection.setDestination((Parameter) searchResult);
						else if (searchResult != null) {
							errManager.error(connection, '\'' + subprogramCall.getName() + '.'
									+ destinationParameterName + "' is not a parameter");
						} else {
							errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
									+ subprogramCall.getName() + '\'');
						}
					} else
						errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
								+ subprogramCall.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + destinationParameterName + "' not found in '" + subprogramCall.getName() + '\'');
			} else if (subprogramCall.getCalledSubprogram() instanceof SubprogramAccess) {
				Feature access = (SubprogramAccess) subprogramCall.getCalledSubprogram();
				while (access.getClassifier() == null && access.getPrototype() == null && access.getRefined() != null)
					access = access.getRefined();
				if (access.getClassifier() != null) {
					NamedElement searchResult = access.getClassifier().findNamedElement(destinationParameterName);
					if (searchResult instanceof Parameter)
						connection.setDestination((Parameter) searchResult);
					else if (searchResult != null) {
						errManager.error(connection, '\'' + subprogramCall.getName() + '.' + destinationParameterName
								+ "' is not a parameter");
					} else
						errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
								+ subprogramCall.getName() + '\'');
				} else if (access.getPrototype() instanceof ComponentPrototype) {
					CallContext callContext = subprogramCall.getContext();
					if (callContext instanceof AbstractType || callContext instanceof DataType
							|| callContext instanceof SubprogramGroupType) {
						ComponentClassifier classifier = findClassifierForComponentPrototype(
								(ComponentType) callContext, (ComponentPrototype) access.getPrototype());
						if (classifier != null) {
							NamedElement searchResult = classifier.findNamedElement(destinationParameterName);
							if (searchResult instanceof Parameter)
								connection.setDestination((Parameter) searchResult);
							else if (searchResult != null) {
								errManager.error(connection, '\'' + subprogramCall.getName() + '.'
										+ destinationParameterName + "' is not a parameter");
							} else {
								errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
										+ subprogramCall.getName() + '\'');
							}
						} else {
							errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
									+ subprogramCall.getName() + '\'');
						}
					} else if (callContext instanceof FeatureGroup) {
						FeatureGroup callContextFeatureGroup = (FeatureGroup) callContext;
						FeatureGroupType prototypeContext;
						while (callContextFeatureGroup.getFeatureGroupType() == null
								&& callContextFeatureGroup.getPrototype() == null
								&& callContextFeatureGroup.getRefined() instanceof FeatureGroup) {
							callContextFeatureGroup = (FeatureGroup) callContextFeatureGroup.getRefined();
						}
						if (callContextFeatureGroup.getFeatureGroupType() != null)
							prototypeContext = callContextFeatureGroup.getFeatureGroupType();
						else if (callContextFeatureGroup.getPrototype() instanceof FeatureGroupPrototype) {
							prototypeContext = findFeatureGroupTypeForFeatureGroupPrototype(
									getContainingClassifier(connection),
									(FeatureGroupPrototype) callContextFeatureGroup.getPrototype());
						} else
							prototypeContext = null;
						if (prototypeContext != null) {
							ComponentClassifier classifier = findClassifierForComponentPrototype(prototypeContext,
									(ComponentPrototype) access.getPrototype());
							if (classifier != null) {
								NamedElement searchResult = classifier.findNamedElement(destinationParameterName);
								if (searchResult instanceof Parameter)
									connection.setDestination((Parameter) searchResult);
								else if (searchResult != null) {
									errManager.error(connection, '\'' + subprogramCall.getName() + '.'
											+ destinationParameterName + "' is not a parameter");
								} else {
									errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
											+ subprogramCall.getName() + '\'');
								}
							} else {
								errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
										+ subprogramCall.getName() + '\'');
							}
						} else {
							errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
									+ subprogramCall.getName() + '\'');
						}
					} else if (callContext instanceof SubprogramGroupAccess) {
						Feature callContextAccess = (SubprogramGroupAccess) callContext;
						Classifier prototypeContext;
						while (callContextAccess.getClassifier() == null && callContextAccess.getPrototype() == null
								&& callContextAccess.getRefined() != null) {
							callContextAccess = callContextAccess.getRefined();
						}
						if (callContextAccess.getClassifier() != null)
							prototypeContext = callContextAccess.getClassifier();
						else if (callContextAccess.getPrototype() instanceof ComponentPrototype) {
							prototypeContext = findClassifierForComponentPrototype(getContainingClassifier(connection),
									(ComponentPrototype) callContextAccess.getPrototype());
						} else
							prototypeContext = null;
						if (prototypeContext != null) {
							ComponentClassifier classifier = findClassifierForComponentPrototype(prototypeContext,
									(ComponentPrototype) access.getPrototype());
							if (classifier != null) {
								NamedElement searchResult = classifier.findNamedElement(destinationParameterName);
								if (searchResult instanceof Parameter)
									connection.setDestination((Parameter) searchResult);
								else if (searchResult != null) {
									errManager.error(connection, '\'' + subprogramCall.getName() + '.'
											+ destinationParameterName + "' is not a parameter");
								} else {
									errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
											+ subprogramCall.getName() + '\'');
								}
							} else {
								errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
										+ subprogramCall.getName() + '\'');
							}
						} else {
							errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
									+ subprogramCall.getName() + '\'');
						}
					} else if (callContext instanceof SubprogramGroupSubcomponent) {
						Subcomponent callContextSubcomponent = (SubprogramGroupSubcomponent) callContext;
						while (callContextSubcomponent.getClassifier() == null
								&& callContextSubcomponent.getPrototype() == null
								&& callContextSubcomponent.getRefined() != null) {
							callContextSubcomponent = callContextSubcomponent.getRefined();
						}
						if (callContextSubcomponent.getClassifier() != null) {
							ComponentClassifier classifier;
							if (callContextSubcomponent.getOwnedPrototypeBindings().isEmpty()) {
								classifier = findClassifierForComponentPrototype(
										callContextSubcomponent.getClassifier(),
										(ComponentPrototype) access.getPrototype());
							} else {
								classifier = findClassifierForComponentPrototype(
										callContextSubcomponent.getClassifier(), callContextSubcomponent,
										(ComponentPrototype) access.getPrototype());
							}
							if (classifier != null) {
								NamedElement searchResult = classifier.findNamedElement(destinationParameterName);
								if (searchResult instanceof Parameter)
									connection.setDestination((Parameter) searchResult);
								else if (searchResult != null) {
									errManager.error(connection, '\'' + subprogramCall.getName() + '.'
											+ destinationParameterName + "' is not a parameter");
								} else {
									errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
											+ subprogramCall.getName() + '\'');
								}
							} else {
								errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
										+ subprogramCall.getName() + '\'');
							}
						} else if (callContextSubcomponent.getPrototype() != null) {
							Classifier prototypeContext = findClassifierForComponentPrototype(
									getContainingClassifier(connection), callContextSubcomponent.getPrototype());
							if (prototypeContext != null) {
								ComponentClassifier classifier = findClassifierForComponentPrototype(prototypeContext,
										(ComponentPrototype) access.getPrototype());
								if (classifier != null) {
									NamedElement searchResult = classifier.findNamedElement(destinationParameterName);
									if (searchResult instanceof Parameter)
										connection.setDestination((Parameter) searchResult);
									else if (searchResult != null) {
										errManager.error(connection, '\'' + subprogramCall.getName() + '.'
												+ destinationParameterName + "' is not a parameter");
									} else {
										errManager.error(connection, '\'' + destinationParameterName
												+ "' not found in '" + subprogramCall.getName() + '\'');
									}
								} else {
									errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
											+ subprogramCall.getName() + '\'');
								}
							} else {
								errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
										+ subprogramCall.getName() + '\'');
							}
						} else {
							errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
									+ subprogramCall.getName() + '\'');
						}
					} else //callContext is null.
					{
						ComponentClassifier classifier = findClassifierForComponentPrototype(
								getContainingClassifier(connection), (ComponentPrototype) access.getPrototype());
						if (classifier != null) {
							NamedElement searchResult = classifier.findNamedElement(destinationParameterName);
							if (searchResult instanceof Parameter)
								connection.setDestination((Parameter) searchResult);
							else if (searchResult != null) {
								errManager.error(connection, '\'' + subprogramCall.getName() + '.'
										+ destinationParameterName + "' is not a parameter");
							} else {
								errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
										+ subprogramCall.getName() + '\'');
							}
						} else {
							errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
									+ subprogramCall.getName() + '\'');
						}
					}
				} else
					errManager.error(connection,
							'\'' + destinationParameterName + "' not found in '" + subprogramCall.getName() + '\'');
			} else //subprogramCall.getCalledSubprogram() is null.  The subprogram call refers to a prototype.
			{
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection), (ComponentPrototype) subprogramCall.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier.findNamedElement(destinationParameterName);
					if (searchResult instanceof Parameter)
						connection.setDestination((Parameter) searchResult);
					else if (searchResult != null) {
						errManager.error(connection, '\'' + subprogramCall.getName() + '.' + destinationParameterName
								+ "' is not a parameter");
					} else
						errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
								+ subprogramCall.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + destinationParameterName + "' not found in '" + subprogramCall.getName() + '\'');
			}
		} else //connection.getDestinationContext() is a Parameter, DataPort, or EventDataPort
		{
			Feature destinationContext = (Feature) connection.getDestinationContext();
			while (destinationContext.getClassifier() == null && destinationContext.getPrototype() == null
					&& destinationContext.getRefined() != null) {
				destinationContext = destinationContext.getRefined();
			}
			if (destinationContext.getClassifier() != null) {
				NamedElement searchResult = destinationContext.getClassifier().findNamedElement(
						destinationParameterName);
				if (searchResult instanceof DataSubcomponent)
					connection.setDestination((DataSubcomponent) searchResult);
				else if (searchResult != null) {
					errManager.error(connection, '\'' + destinationContext.getName() + '.' + destinationParameterName
							+ "' is not a data subcomponent");
				} else
					errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
							+ destinationContext.getName() + '\'');
			} else if (destinationContext.getPrototype() instanceof ComponentPrototype) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection), (ComponentPrototype) destinationContext.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier.findNamedElement(destinationParameterName);
					if (searchResult instanceof DataSubcomponent)
						connection.setDestination((DataSubcomponent) searchResult);
					else if (searchResult != null) {
						errManager.error(connection, '\'' + destinationContext.getName() + '.'
								+ destinationParameterName + "' is not a parameter");
					} else {
						errManager.error(connection, '\'' + destinationParameterName + "' not found in '"
								+ destinationContext.getName() + '\'');
					}
				}
			} else
				errManager.error(connection,
						'\'' + destinationParameterName + "' not found in '" + destinationContext.getName() + '\'');
		}
	}

	private void casePortConnectionSourceContextReference(PortConnection connection, String sourceContextName) {
		NamedElement searchResult = getContainingClassifier(connection).findNamedElement(sourceContextName);
		if (searchResult instanceof FeatureGroup || searchResult instanceof Subcomponent
				|| searchResult instanceof DataPort || searchResult instanceof EventDataPort) {
			connection.setSourceContext((Context) searchResult);
		} else if (searchResult != null)
			errManager.error(connection, '\'' + sourceContextName
					+ "' is not a feature group, subcomponent, data port, or event data port");
		else
			errManager.error(connection, '\'' + sourceContextName + "' not found");
	}

	private void casePortConnectionDestinationContextReference(PortConnection connection, String destinationContextName) {
		NamedElement searchResult = getContainingClassifier(connection).findNamedElement(destinationContextName);
		if (searchResult instanceof FeatureGroup || searchResult instanceof Subcomponent
				|| searchResult instanceof DataPort || searchResult instanceof EventDataPort) {
			connection.setDestinationContext((Context) searchResult);
		} else if (searchResult != null) {
			errManager.error(connection, '\'' + destinationContextName
					+ "' is not a feature group, subcomponent, data port, or event data port");
		} else
			errManager.error(connection, '\'' + destinationContextName + "' not found");
	}

	private void casePortConnectionSourcePortReference(PortConnection connection, String sourcePortName) {
		if (connection.getSourceContext() == null) {
			NamedElement searchResult = getContainingClassifier(connection).findNamedElement(sourcePortName);
			if (searchResult instanceof PortConnectionEnd)
				connection.setSource((PortConnectionEnd) searchResult);
			else if (searchResult != null)
				errManager.error(connection, '\'' + sourcePortName
						+ "' is not a port, data access, or data subcomponent");
			else
				errManager.error(connection, '\'' + sourcePortName + "' not found");
		} else if (connection.getSourceContext() instanceof FeatureGroup) {
			FeatureGroup featureGroup = (FeatureGroup) connection.getSourceContext();
			while (featureGroup.getFeatureGroupType() == null && featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType().findNamedElement(sourcePortName);
				if (searchResult instanceof PortConnectionEnd)
					connection.setSource((PortConnectionEnd) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + featureGroup.getName() + '.' + sourcePortName
							+ "' is not a port or data access");
				else
					errManager.error(connection, '\'' + sourcePortName + "' not found in '" + featureGroup.getName()
							+ '\'');
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(connection), (FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType.findNamedElement(sourcePortName);
					if (searchResult instanceof PortConnectionEnd)
						connection.setSource((PortConnectionEnd) searchResult);
					else if (searchResult != null)
						errManager.error(connection, '\'' + featureGroup.getName() + '.' + sourcePortName
								+ "' is not a port or data access");
					else
						errManager.error(connection,
								'\'' + sourcePortName + "' not found in '" + featureGroup.getName() + '\'');
				} else
					errManager.error(connection, '\'' + sourcePortName + "' not found in '" + featureGroup.getName()
							+ '\'');
			} else
				errManager
						.error(connection, '\'' + sourcePortName + "' not found in '" + featureGroup.getName() + '\'');
		} else if (connection.getSourceContext() instanceof DataSubcomponent) {
			Subcomponent subcomponent = (DataSubcomponent) connection.getSourceContext();
			while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement searchResult = subcomponent.getClassifier().findNamedElement(sourcePortName);
				if (searchResult instanceof DataSubcomponent)
					connection.setSource((DataSubcomponent) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + subcomponent.getName() + '.' + sourcePortName
							+ "' is not a data subcomponent");
				else
					errManager.error(connection, '\'' + sourcePortName + "' not found in '" + subcomponent.getName()
							+ '\'');
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection), subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier.findNamedElement(sourcePortName);
					if (searchResult instanceof DataSubcomponent)
						connection.setSource((DataSubcomponent) searchResult);
					else if (searchResult != null)
						errManager.error(connection, '\'' + subcomponent.getName() + '.' + sourcePortName
								+ "' is not a data subcomponent");
					else
						errManager.error(connection,
								'\'' + sourcePortName + "' not found in '" + subcomponent.getName() + '\'');
				} else
					errManager.error(connection, '\'' + sourcePortName + "' not found in '" + subcomponent.getName()
							+ '\'');
			} else
				errManager
						.error(connection, '\'' + sourcePortName + "' not found in '" + subcomponent.getName() + '\'');
		} else if (connection.getSourceContext() instanceof Subcomponent) {
			Subcomponent subcomponent = (Subcomponent) connection.getSourceContext();
			while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement searchResult = subcomponent.getClassifier().findNamedElement(sourcePortName);
				if (searchResult instanceof Port || searchResult instanceof DataAccess)
					connection.setSource((PortConnectionEnd) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + subcomponent.getName() + '.' + sourcePortName
							+ "' is not a port or data access");
				else
					errManager.error(connection, '\'' + sourcePortName + "' not found in '" + subcomponent.getName()
							+ '\'');
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection), subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier.findNamedElement(sourcePortName);
					if (searchResult instanceof Port || searchResult instanceof DataAccess)
						connection.setSource((PortConnectionEnd) searchResult);
					else if (searchResult != null)
						errManager.error(connection, '\'' + subcomponent.getName() + '.' + sourcePortName
								+ "' is not a port or data access");
					else
						errManager.error(connection,
								'\'' + sourcePortName + "' not found in '" + subcomponent.getName() + '\'');
				} else
					errManager.error(connection, '\'' + sourcePortName + "' not found in '" + subcomponent.getName()
							+ '\'');
			} else
				errManager
						.error(connection, '\'' + sourcePortName + "' not found in '" + subcomponent.getName() + '\'');
		} else //connection.getSourceContext() is a DataPort or EventDataPort
		{
			Feature sourceContext = (Port) connection.getSourceContext();
			while (sourceContext.getClassifier() == null && sourceContext.getPrototype() == null
					&& sourceContext.getRefined() != null)
				sourceContext = sourceContext.getRefined();
			if (sourceContext.getClassifier() != null) {
				NamedElement searchResult = sourceContext.getClassifier().findNamedElement(sourcePortName);
				if (searchResult instanceof DataSubcomponent)
					connection.setSource((DataSubcomponent) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + sourceContext.getName() + '.' + sourcePortName
							+ "' is not a data subcomponent");
				else
					errManager.error(connection, '\'' + sourcePortName + "' not found in '" + sourceContext.getName()
							+ '\'');
			} else if (sourceContext.getPrototype() instanceof ComponentPrototype) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection), (ComponentPrototype) sourceContext.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier.findNamedElement(sourcePortName);
					if (searchResult instanceof DataSubcomponent)
						connection.setSource((DataSubcomponent) searchResult);
					else if (searchResult != null)
						errManager.error(connection, '\'' + sourceContext.getName() + '.' + sourcePortName
								+ "' is not a data subcomponent");
					else
						errManager.error(connection,
								'\'' + sourcePortName + "' not found in '" + sourceContext.getName() + '\'');
				} else
					errManager.error(connection, '\'' + sourcePortName + "' not found in '" + sourceContext.getName()
							+ '\'');
			} else
				errManager.error(connection, '\'' + sourcePortName + "' not found in '" + sourceContext.getName()
						+ '\'');
		}
	}

	private void casePortConnectionDestinationPortReference(PortConnection connection, String destinationPortName) {
		if (connection.getDestinationContext() == null) {
			NamedElement searchResult = getContainingClassifier(connection).findNamedElement(destinationPortName);
			if (searchResult instanceof PortConnectionEnd)
				connection.setDestination((PortConnectionEnd) searchResult);
			else if (searchResult != null)
				errManager.error(connection, '\'' + destinationPortName
						+ "' is not a port, data access, or data subcomponent");
			else
				errManager.error(connection, '\'' + destinationPortName + "' not found");
		} else if (connection.getDestinationContext() instanceof FeatureGroup) {
			FeatureGroup featureGroup = (FeatureGroup) connection.getDestinationContext();
			while (featureGroup.getFeatureGroupType() == null && featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType().findNamedElement(destinationPortName);
				if (searchResult instanceof PortConnectionEnd)
					connection.setDestination((PortConnectionEnd) searchResult);
				else if (searchResult != null) {
					errManager.error(connection, '\'' + featureGroup.getName() + '.' + destinationPortName
							+ "' is not a port or data access");
				} else
					errManager.error(connection,
							'\'' + destinationPortName + "' not found in '" + featureGroup.getName() + '\'');
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(connection), (FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType.findNamedElement(destinationPortName);
					if (searchResult instanceof PortConnectionEnd)
						connection.setDestination((PortConnectionEnd) searchResult);
					else if (searchResult != null) {
						errManager.error(connection, '\'' + featureGroup.getName() + '.' + destinationPortName
								+ "' is not a port or data access");
					} else
						errManager.error(connection,
								'\'' + destinationPortName + "' not found in '" + featureGroup.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + destinationPortName + "' not found in '" + featureGroup.getName() + '\'');
			} else
				errManager.error(connection, '\'' + destinationPortName + "' not found in '" + featureGroup.getName()
						+ '\'');
		} else if (connection.getDestinationContext() instanceof DataSubcomponent) {
			Subcomponent subcomponent = (DataSubcomponent) connection.getDestinationContext();
			while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement searchResult = subcomponent.getClassifier().findNamedElement(destinationPortName);
				if (searchResult instanceof DataSubcomponent)
					connection.setDestination((DataSubcomponent) searchResult);
				else if (searchResult != null)
					errManager.error(connection, '\'' + subcomponent.getName() + '.' + destinationPortName
							+ "' is not a data subcomponent");
				else
					errManager.error(connection,
							'\'' + destinationPortName + "' not found in '" + subcomponent.getName() + '\'');
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection), subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier.findNamedElement(destinationPortName);
					if (searchResult instanceof DataSubcomponent)
						connection.setDestination((DataSubcomponent) searchResult);
					else if (searchResult != null) {
						errManager.error(connection, '\'' + subcomponent.getName() + '.' + destinationPortName
								+ "' is not a data subcomponent");
					} else
						errManager.error(connection,
								'\'' + destinationPortName + "' not found in '" + subcomponent.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + destinationPortName + "' not found in '" + subcomponent.getName() + '\'');
			} else
				errManager.error(connection, '\'' + destinationPortName + "' not found in '" + subcomponent.getName()
						+ '\'');
		} else if (connection.getDestinationContext() instanceof Subcomponent) {
			Subcomponent subcomponent = (Subcomponent) connection.getDestinationContext();
			while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement searchResult = subcomponent.getClassifier().findNamedElement(destinationPortName);
				if (searchResult instanceof Port || searchResult instanceof DataAccess)
					connection.setDestination((PortConnectionEnd) searchResult);
				else if (searchResult != null) {
					errManager.error(connection, '\'' + subcomponent.getName() + '.' + destinationPortName
							+ "' is not a port or data access");
				} else
					errManager.error(connection,
							'\'' + destinationPortName + "' not found in '" + subcomponent.getName() + '\'');
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection), subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier.findNamedElement(destinationPortName);
					if (searchResult instanceof Port || searchResult instanceof DataAccess)
						connection.setDestination((PortConnectionEnd) searchResult);
					else if (searchResult != null) {
						errManager.error(connection, '\'' + subcomponent.getName() + '.' + destinationPortName
								+ "' is not a port or data access");
					} else
						errManager.error(connection,
								'\'' + destinationPortName + "' not found in '" + subcomponent.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + destinationPortName + "' not found in '" + subcomponent.getName() + '\'');
			} else
				errManager.error(connection, '\'' + destinationPortName + "' not found in '" + subcomponent.getName()
						+ '\'');
		} else //connection.getDestinationContext() is a DataPort or EventDataPort
		{
			Feature destinationContext = (Port) connection.getDestinationContext();
			while (destinationContext.getClassifier() == null && destinationContext.getPrototype() == null
					&& destinationContext.getRefined() != null) {
				destinationContext = destinationContext.getRefined();
			}
			if (destinationContext.getClassifier() != null) {
				NamedElement searchResult = destinationContext.getClassifier().findNamedElement(destinationPortName);
				if (searchResult instanceof DataSubcomponent)
					connection.setDestination((DataSubcomponent) searchResult);
				else if (searchResult != null) {
					errManager.error(connection, '\'' + destinationContext.getName() + '.' + destinationPortName
							+ "' is not a data subcomponent");
				} else
					errManager.error(connection,
							'\'' + destinationPortName + "' not found in '" + destinationContext.getName() + '\'');
			} else if (destinationContext.getPrototype() instanceof ComponentPrototype) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection), (ComponentPrototype) destinationContext.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier.findNamedElement(destinationPortName);
					if (searchResult instanceof DataSubcomponent)
						connection.setDestination((DataSubcomponent) searchResult);
					else if (searchResult != null) {
						errManager.error(connection, '\'' + destinationContext.getName() + '.' + destinationPortName
								+ "' is not a data subcomponent");
					} else
						errManager.error(connection, '\'' + destinationPortName + "' not found in '"
								+ destinationContext.getName() + '\'');
				} else
					errManager.error(connection,
							'\'' + destinationPortName + "' not found in '" + destinationContext.getName() + '\'');
			} else
				errManager.error(connection,
						'\'' + destinationPortName + "' not found in '" + destinationContext.getName() + '\'');
		}
	}

	private void caseFlowSpecificationInFeatureReference(FlowSpecification flowSpec, String contextName,
			String featureName) {
		if (contextName == null) {
			NamedElement featureSearchResult = getContainingClassifier(flowSpec).findNamedElement(featureName);
			if (featureSearchResult instanceof Feature)
				flowSpec.setInFeature((Feature) featureSearchResult);
			else if (featureSearchResult != null)
				errManager.error(flowSpec, '\'' + featureName + "' is not a feature");
			else
				errManager.error(flowSpec, '\'' + featureName + "' not found");
		} else {
			NamedElement contextSearchResult = getContainingClassifier(flowSpec).findNamedElement(contextName);
			if (contextSearchResult instanceof FeatureGroup) {
				FeatureGroup context = (FeatureGroup) contextSearchResult;
				flowSpec.setInContext(context);
				while (context.getFeatureGroupType() == null && context.getPrototype() == null
						&& context.getRefined() instanceof FeatureGroup) {
					context = (FeatureGroup) context.getRefined();
				}
				if (context.getFeatureGroupType() != null) {
					NamedElement featureSearchResult = context.getFeatureGroupType().findNamedElement(featureName);
					if (featureSearchResult instanceof Feature)
						flowSpec.setInFeature((Feature) featureSearchResult);
					else if (featureSearchResult != null)
						errManager.error(flowSpec, '\'' + contextName + '.' + featureName + "' is not a feature");
					else
						errManager.error(flowSpec, '\'' + featureName + "' not found in '" + contextName + '\'');
				} else if (context.getPrototype() != null) {
					FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
							getContainingClassifier(flowSpec), (FeatureGroupPrototype) context.getPrototype());
					if (featureGroupType != null) {
						NamedElement featureSearchResult = featureGroupType.findNamedElement(featureName);
						if (featureSearchResult instanceof Feature)
							flowSpec.setInFeature((Feature) featureSearchResult);
						else if (featureSearchResult != null)
							errManager.error(flowSpec, '\'' + contextName + '.' + featureName + "' is not a feature");
						else
							errManager.error(flowSpec, '\'' + featureName + "' not found in '" + contextName + '\'');
					} else
						errManager.error(flowSpec, '\'' + featureName + "' not found in '" + contextName + '\'');
				} else
					errManager.error(flowSpec, '\'' + featureName + "' not found in '" + contextName + '\'');
			} else if (contextSearchResult != null)
				errManager.error(flowSpec, '\'' + contextName + "' is not a feature group");
			else
				errManager.error(flowSpec, '\'' + featureName + "' not found");
		}
	}

	private void caseFlowSpecificationOutFeatureReference(FlowSpecification flowSpec, String contextName,
			String featureName) {
		if (contextName == null) {
			NamedElement featureSearchResult = getContainingClassifier(flowSpec).findNamedElement(featureName);
			if (featureSearchResult instanceof Feature)
				flowSpec.setOutFeature((Feature) featureSearchResult);
			else if (featureSearchResult != null)
				errManager.error(flowSpec, '\'' + featureName + "' is not a feature");
			else
				errManager.error(flowSpec, '\'' + featureName + "' not found");
		} else {
			NamedElement contextSearchResult = getContainingClassifier(flowSpec).findNamedElement(contextName);
			if (contextSearchResult instanceof FeatureGroup) {
				FeatureGroup context = (FeatureGroup) contextSearchResult;
				flowSpec.setOutContext(context);
				while (context.getFeatureGroupType() == null && context.getPrototype() == null
						&& context.getRefined() instanceof FeatureGroup) {
					context = (FeatureGroup) context.getRefined();
				}
				if (context.getFeatureGroupType() != null) {
					NamedElement featureSearchResult = context.getFeatureGroupType().findNamedElement(featureName);
					if (featureSearchResult instanceof Feature)
						flowSpec.setOutFeature((Feature) featureSearchResult);
					else if (featureSearchResult != null)
						errManager.error(flowSpec, '\'' + contextName + '.' + featureName + "' is not a feature");
					else
						errManager.error(flowSpec, '\'' + featureName + "' not found in '" + contextName + '\'');
				} else if (context.getPrototype() != null) {
					FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
							getContainingClassifier(flowSpec), (FeatureGroupPrototype) context.getPrototype());
					if (featureGroupType != null) {
						NamedElement featureSearchResult = featureGroupType.findNamedElement(featureName);
						if (featureSearchResult instanceof Feature)
							flowSpec.setOutFeature((Feature) featureSearchResult);
						else if (featureSearchResult != null)
							errManager.error(flowSpec, '\'' + contextName + '.' + featureName + "' is not a feature");
						else
							errManager.error(flowSpec, '\'' + featureName + "' not found in '" + contextName + '\'');
					} else
						errManager.error(flowSpec, '\'' + featureName + "' not found in '" + contextName + '\'');
				} else
					errManager.error(flowSpec, '\'' + featureName + "' not found in '" + contextName + '\'');
			} else if (contextSearchResult != null)
				errManager.error(flowSpec, '\'' + contextName + "' is not a feature group");
			else
				errManager.error(flowSpec, '\'' + featureName + "' not found");
		}
	}

	private void caseFlowImplementationSpecificationReference(FlowImplementation flowImplementation, String flowName) {
		NamedElement searchResult = getContainingClassifier(flowImplementation).findNamedElement(flowName);
		if (searchResult instanceof FlowSpecification)
			flowImplementation.setSpecification((FlowSpecification) searchResult);
		else if (searchResult != null)
			errManager.error(flowImplementation, '\'' + flowName + "' is not a flow specification");
		else
			errManager.error(flowImplementation, '\'' + flowName + "' not found");
	}

	private void caseFlowImplementationConnectionReference(StructuralFeature flowImplementationOrEndToEndFlow,
			String connectionName) {
		NamedElement searchResult = getContainingClassifier(flowImplementationOrEndToEndFlow).findNamedElement(
				connectionName);
		if (searchResult instanceof Connection) {
			if (flowImplementationOrEndToEndFlow instanceof FlowImplementation)
				((FlowImplementation) flowImplementationOrEndToEndFlow).getFlowElements()
						.add((Connection) searchResult);
			else
				//flowImplementationOrEndToEndFlow is an EndToEndFlow
				((EndToEndFlow) flowImplementationOrEndToEndFlow).getFlowElements().add((Connection) searchResult);
		} else if (searchResult != null)
			errManager.error(flowImplementationOrEndToEndFlow, '\'' + connectionName + "' is not a connection");
		else
			errManager.error(flowImplementationOrEndToEndFlow, '\'' + connectionName + "' not found");
	}

	private void caseFlowImplementationFlowElementReference(StructuralFeature flowImplementationOrEndToEndFlow,
			String contextName, String flowElementName) {
		if (contextName != null) {
			NamedElement contextSearchResult = getContainingClassifier(flowImplementationOrEndToEndFlow)
					.findNamedElement(contextName);
			if (contextSearchResult instanceof Subcomponent) {
				Subcomponent subcomponent = (Subcomponent) contextSearchResult;
				while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
						&& subcomponent.getRefined() != null)
					subcomponent = subcomponent.getRefined();
				if (subcomponent.getClassifier() != null) {
					NamedElement flowElementSearchResult = subcomponent.getClassifier().findNamedElement(
							flowElementName);
					if (flowElementSearchResult instanceof FlowSpecification) {
						SubcomponentFlow subcomponentFlow;
						if (flowImplementationOrEndToEndFlow instanceof FlowImplementation)
							subcomponentFlow = ((FlowImplementation) flowImplementationOrEndToEndFlow)
									.createOwnedSubcomponentFlow();
						else
							//flowImplementationOrEndToEndFlow is an EndToEndFlow
							subcomponentFlow = ((EndToEndFlow) flowImplementationOrEndToEndFlow)
									.createOwnedSubcomponentFlow();
						subcomponentFlow.setContext((Subcomponent) contextSearchResult);
						subcomponentFlow.setFlowSpecification((FlowSpecification) flowElementSearchResult);
					} else if (flowElementSearchResult instanceof DataAccess) {
						SubcomponentFlow subcomponentFlow;
						if (flowImplementationOrEndToEndFlow instanceof FlowImplementation)
							subcomponentFlow = ((FlowImplementation) flowImplementationOrEndToEndFlow)
									.createOwnedSubcomponentFlow();
						else
							//flowImplementationOrEndToEndFlow is an EndToEndFlow
							subcomponentFlow = ((EndToEndFlow) flowImplementationOrEndToEndFlow)
									.createOwnedSubcomponentFlow();
						subcomponentFlow.setContext((Subcomponent) contextSearchResult);
						subcomponentFlow.setDataAccess((DataAccess) flowElementSearchResult);
					} else if (flowElementSearchResult != null) {
						errManager.error(flowImplementationOrEndToEndFlow, '\'' + contextName + '.' + flowElementName
								+ "' is not a flow specification or a data access feature");
					} else
						errManager.error(flowImplementationOrEndToEndFlow, '\'' + flowElementName + "' not found in '"
								+ contextName + '\'');
				} else if (subcomponent.getPrototype() != null) {
					ComponentClassifier classifier = findClassifierForComponentPrototype(
							getContainingClassifier(flowImplementationOrEndToEndFlow), subcomponent.getPrototype());
					if (classifier != null) {
						NamedElement flowElementSearchResult = classifier.findNamedElement(flowElementName);
						if (flowElementSearchResult instanceof FlowSpecification) {
							SubcomponentFlow subcomponentFlow;
							if (flowImplementationOrEndToEndFlow instanceof FlowImplementation)
								subcomponentFlow = ((FlowImplementation) flowImplementationOrEndToEndFlow)
										.createOwnedSubcomponentFlow();
							else
								//flowImplementationOrEndToEndFlow is an EndToEndFlow
								subcomponentFlow = ((EndToEndFlow) flowImplementationOrEndToEndFlow)
										.createOwnedSubcomponentFlow();
							subcomponentFlow.setContext((Subcomponent) contextSearchResult);
							subcomponentFlow.setFlowSpecification((FlowSpecification) flowElementSearchResult);
						} else if (flowElementSearchResult instanceof DataAccess) {
							SubcomponentFlow subcomponentFlow;
							if (flowImplementationOrEndToEndFlow instanceof FlowImplementation)
								subcomponentFlow = ((FlowImplementation) flowImplementationOrEndToEndFlow)
										.createOwnedSubcomponentFlow();
							else
								//flowImplementationOrEndToEndFlow is an EndToEndFlow
								subcomponentFlow = ((EndToEndFlow) flowImplementationOrEndToEndFlow)
										.createOwnedSubcomponentFlow();
							subcomponentFlow.setContext((Subcomponent) contextSearchResult);
							subcomponentFlow.setDataAccess((DataAccess) flowElementSearchResult);
						} else if (flowElementSearchResult != null) {
							errManager.error(flowImplementationOrEndToEndFlow, '\'' + contextName + '.'
									+ flowElementName + "' is not a flow specification or a data access feature");
						} else {
							errManager.error(flowImplementationOrEndToEndFlow, '\'' + flowElementName
									+ "' not found in '" + contextName + '\'');
						}
					} else
						errManager.error(flowImplementationOrEndToEndFlow, '\'' + flowElementName + "' not found in '"
								+ contextName + '\'');
				} else
					errManager.error(flowImplementationOrEndToEndFlow, '\'' + flowElementName + "' not found in '"
							+ contextName + '\'');
			} else if (contextSearchResult != null)
				errManager.error(flowImplementationOrEndToEndFlow, '\'' + contextName + "' is not a subcomponent");
			else
				errManager.error(flowImplementationOrEndToEndFlow, '\'' + contextName + "' not found");
		} else {
			NamedElement flowElementSearchResult = getContainingClassifier(flowImplementationOrEndToEndFlow)
					.findNamedElement(flowElementName);
			if (flowImplementationOrEndToEndFlow instanceof FlowImplementation) {
				if (flowElementSearchResult instanceof Subcomponent || flowElementSearchResult instanceof DataAccess)
					((FlowImplementation) flowImplementationOrEndToEndFlow).getFlowElements().add(
							(FlowElement) flowElementSearchResult);
				else if (flowElementSearchResult != null)
					errManager.error(flowImplementationOrEndToEndFlow, '\'' + flowElementName
							+ "' is not a subcomponent or data access");
				else
					errManager.error(flowImplementationOrEndToEndFlow, '\'' + flowElementName + "' not found");
			} else //flowImplementationOrEndToEndFlow is an EndToEndFlow
			{
				if (flowElementSearchResult instanceof EndToEndFlow || flowElementSearchResult instanceof Subcomponent
						|| flowElementSearchResult instanceof DataAccess) {
					((EndToEndFlow) flowImplementationOrEndToEndFlow).getFlowElements().add(
							(EndToEndFlowElement) flowElementSearchResult);
				} else if (flowElementSearchResult != null) {
					errManager.error(flowImplementationOrEndToEndFlow, '\'' + flowElementName
							+ "' is not an end to end flow, subcomponent, or data access");
				} else
					errManager.error(flowImplementationOrEndToEndFlow, '\'' + flowElementName + "' not found");
			}
		}
	}

	private void caseFlowImplementationInFeatureReference(FlowImplementation flowImplementation, String contextName,
			String featureName) {
		FlowSpecification flowSpec = flowImplementation.getSpecification();
		while (flowSpec.getInFeature() == null && flowSpec.getRefined() != null)
			flowSpec = flowSpec.getRefined();
		if (contextName != null) {
			if (!(flowSpec.getInContext() != null && flowSpec.getInContext().getName().equalsIgnoreCase(contextName) && flowSpec
					.getInFeature().getName().equalsIgnoreCase(featureName))) {
				errManager.error(flowImplementation, '\'' + contextName + '.' + featureName
						+ "' does not match the in feature refered to by the flow specification '" + flowSpec.getName()
						+ '\'');
			}
		} else if (!flowSpec.getInFeature().getName().equalsIgnoreCase(featureName)) {
			errManager.error(flowImplementation, '\'' + featureName
					+ "' does not match the in feature refered to by the flow specification '" + flowSpec.getName()
					+ '\'');
		}
	}

	private void caseFlowImplementationOutFeatureReference(FlowImplementation flowImplementation, String contextName,
			String featureName) {
		FlowSpecification flowSpec = flowImplementation.getSpecification();
		while (flowSpec.getOutFeature() == null && flowSpec.getRefined() != null)
			flowSpec = flowSpec.getRefined();
		if (contextName != null) {
			if (!(flowSpec.getOutContext() != null && flowSpec.getOutContext().getName().equalsIgnoreCase(contextName) && flowSpec
					.getOutFeature().getName().equalsIgnoreCase(featureName))) {
				errManager.error(
						flowImplementation,
						'\'' + contextName + '.' + featureName
								+ "' does not match the out feature refered to by the flow specification '"
								+ flowSpec.getName() + '\'');
			}
		} else if (!flowSpec.getOutFeature().getName().equalsIgnoreCase(featureName)) {
			errManager.error(flowImplementation, '\'' + featureName
					+ "' does not match the out feature refered to by the flow specification '" + flowSpec.getName()
					+ '\'');
		}
	}

	private void caseModeMappingReference(Subcomponent subcomponent, String parentModeName, String derivedModeName) {
		NamedElement parentModeSearchResult = getContainingClassifier(subcomponent).findNamedElement(parentModeName);
		if (parentModeSearchResult instanceof Mode) {
			ModeBinding modeBinding = subcomponent.createModeBinding();
			modeBinding.setParentMode((Mode) parentModeSearchResult);
			Subcomponent refinedSubcomponent = subcomponent;
			while (refinedSubcomponent.getClassifier() == null && refinedSubcomponent.getPrototype() == null
					&& refinedSubcomponent.getRefined() != null) {
				refinedSubcomponent = refinedSubcomponent.getRefined();
			}
			if (refinedSubcomponent.getClassifier() != null) {
				NamedElement derivedModeSearchResult = refinedSubcomponent.getClassifier().findNamedElement(
						derivedModeName);
				if (derivedModeSearchResult instanceof Mode)
					modeBinding.setDerivedMode((Mode) derivedModeSearchResult);
				else if (derivedModeSearchResult != null)
					errManager.error(subcomponent, '\'' + derivedModeName + "' is not a mode");
				else
					errManager.error(subcomponent, '\'' + derivedModeName + "' not found in '" + subcomponent.getName()
							+ '\'');
			} else if (refinedSubcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(subcomponent), refinedSubcomponent.getPrototype());
				if (classifier != null) {
					NamedElement derivedModeSearchResult = classifier.findNamedElement(derivedModeName);
					if (derivedModeSearchResult instanceof Mode)
						modeBinding.setDerivedMode((Mode) derivedModeSearchResult);
					else if (derivedModeSearchResult != null)
						errManager.error(subcomponent, '\'' + derivedModeName + "' is not a mode");
					else
						errManager.error(subcomponent,
								'\'' + derivedModeName + "' not found in '" + subcomponent.getName() + '\'');
				} else
					errManager.error(subcomponent, '\'' + derivedModeName + "' not found in '" + subcomponent.getName()
							+ '\'');
			} else
				errManager.error(subcomponent, '\'' + derivedModeName + "' not found in '" + subcomponent.getName()
						+ '\'');
		} else if (parentModeSearchResult != null)
			errManager.error(subcomponent, '\'' + parentModeName + "' is not a mode");
		else
			errManager.error(subcomponent, '\'' + parentModeName + "' not found");
	}

	private void casePropertyAssociationInBindingReference(PropertyAssociation propertyAssociation, String packageName,
			String classifierName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, classifierName,
				getContainingPackageSection(propertyAssociation));
		if (searchResult instanceof ProcessorClassifier || searchResult instanceof VirtualProcessorClassifier
				|| searchResult instanceof BusClassifier || searchResult instanceof VirtualBusClassifier
				|| searchResult instanceof MemoryClassifier) {
			propertyAssociation.getInBindings().add((Classifier) searchResult);
		} else if (searchResult != null) {
			errManager.error(propertyAssociation, '\'' + getQualifiedName(packageName, classifierName)
					+ "' is not a processor, virtual processor, bus, virtual bus, or memory classifier");
		} else
			errManager.error(propertyAssociation, '\'' + getQualifiedName(packageName, classifierName) + "' not found");
	}

	private void caseContainedPathElementReference(ContainmentPathElement pathElement, String elementName) {
		EList<ContainmentPathElement> path = ((ContainedNamedElement) pathElement.getOwner())
				.getContainmentPathElements();
		NamedElement propertyAssociationContainer = (NamedElement) getContainingPropertyAssociation(pathElement)
				.getOwner();
		int pathElementIndex = path.indexOf(pathElement);
		if (pathElementIndex == 0) {
			//For reference values, the root object of the path is the containing namespace.
			//For applies to, the root object is the object that contains the property association.
			if (pathElement.getOwner() instanceof ReferenceValue) {
				NamedElement searchResult = getContainingNamespace(pathElement).findNamedElement(elementName);
				if (searchResult != null)
					pathElement.setNamedElement(searchResult);
				else
					errManager.error(pathElement, '\'' + elementName + "' not found");
			} else if (propertyAssociationContainer instanceof Classifier) {
				NamedElement searchResult = ((Classifier) propertyAssociationContainer).findNamedElement(elementName);
				if (searchResult != null)
					pathElement.setNamedElement(searchResult);
				else
					errManager.error(pathElement, '\'' + elementName + "' not found");
			} else if (propertyAssociationContainer instanceof Subcomponent) {
				Subcomponent subcomponent = (Subcomponent) propertyAssociationContainer;
				while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
						&& subcomponent.getRefined() != null)
					subcomponent = subcomponent.getRefined();
				if (subcomponent.getClassifier() != null) {
					NamedElement searchResult = subcomponent.getClassifier().findNamedElement(elementName);
					if (searchResult != null)
						pathElement.setNamedElement(searchResult);
					else
						errManager.error(pathElement, '\'' + elementName + "' not found");
				} else if (subcomponent.getPrototype() != null) {
					ComponentClassifier classifier = findClassifierForComponentPrototype(
							getContainingClassifier(pathElement), subcomponent.getPrototype());
					if (classifier != null) {
						NamedElement searchResult = classifier.findNamedElement(elementName);
						if (searchResult != null)
							pathElement.setNamedElement(searchResult);
						else
							errManager.error(pathElement, '\'' + elementName + "' not found");
					} else
						errManager.error(pathElement, '\'' + elementName + "' not found");
				} else
					errManager.error(pathElement, '\'' + elementName + "' not found");
			} else if (propertyAssociationContainer instanceof FeatureGroup) {
				FeatureGroup featureGroup = (FeatureGroup) propertyAssociationContainer;
				while (featureGroup.getFeatureGroupType() == null && featureGroup.getPrototype() == null
						&& featureGroup.getRefined() instanceof FeatureGroup) {
					featureGroup = (FeatureGroup) featureGroup.getRefined();
				}
				if (featureGroup.getFeatureGroupType() != null) {
					NamedElement searchResult = featureGroup.getFeatureGroupType().findNamedElement(elementName);
					if (searchResult != null)
						pathElement.setNamedElement(searchResult);
					else
						errManager.error(pathElement, '\'' + elementName + "' not found");
				} else if (featureGroup.getPrototype() != null) {
					FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
							getContainingClassifier(pathElement), (FeatureGroupPrototype) featureGroup.getPrototype());
					if (featureGroupType != null) {
						NamedElement searchResult = featureGroupType.findNamedElement(elementName);
						if (searchResult != null)
							pathElement.setNamedElement(searchResult);
						else
							errManager.error(pathElement, '\'' + elementName + "' not found");
					} else
						errManager.error(pathElement, '\'' + elementName + "' not found");
				} else
					errManager.error(pathElement, '\'' + elementName + "' not found");
			} else
				errManager.error(pathElement, '\'' + elementName + "' not found");
		} else {
			if (path.get(pathElementIndex - 1).getNamedElement() instanceof Subcomponent) {
				Subcomponent subcomponent = (Subcomponent) path.get(pathElementIndex - 1).getNamedElement();
				while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null
						&& subcomponent.getRefined() != null)
					subcomponent = subcomponent.getRefined();
				if (subcomponent.getClassifier() != null) {
					NamedElement searchResult = subcomponent.getClassifier().findNamedElement(elementName);
					if (searchResult != null)
						pathElement.setNamedElement(searchResult);
					else {
						errManager.error(
								pathElement,
								'\'' + elementName + "' not found in '"
										+ reconstructPath(path.subList(0, pathElementIndex)) + '\'');
					}
				} else if (subcomponent.getPrototype() != null) {
					Classifier topLevelClassifier;
					ArrayList<Subcomponent> subcomponents;
					if (propertyAssociationContainer instanceof Classifier) {
						topLevelClassifier = (Classifier) propertyAssociationContainer;
						subcomponents = new ArrayList<Subcomponent>(pathElementIndex);
					} else {
						topLevelClassifier = getContainingClassifier(propertyAssociationContainer);
						subcomponents = new ArrayList<Subcomponent>(pathElementIndex + 1);
						subcomponents.add((Subcomponent) propertyAssociationContainer);
					}
					for (int i = 0; i < pathElementIndex; i++)
						subcomponents.add((Subcomponent) path.get(i).getNamedElement());
					ComponentClassifier classifier = findClassifierForComponentPrototype(topLevelClassifier,
							subcomponents, subcomponent.getPrototype());
					if (classifier != null) {
						NamedElement searchResult = classifier.findNamedElement(elementName);
						if (searchResult != null)
							pathElement.setNamedElement(searchResult);
						else {
							errManager.error(pathElement, '\'' + elementName + "' not found in '"
									+ reconstructPath(path.subList(0, pathElementIndex)) + '\'');
						}
					} else {
						errManager.error(
								pathElement,
								'\'' + elementName + "' not found in '"
										+ reconstructPath(path.subList(0, pathElementIndex)) + '\'');
					}
				} else {
					errManager.error(pathElement,
							'\'' + elementName + "' not found in '"
									+ reconstructPath(path.subList(0, pathElementIndex)) + '\'');
				}
			} else if (path.get(pathElementIndex - 1).getNamedElement() instanceof FeatureGroup) {
				FeatureGroup featureGroup = (FeatureGroup) path.get(pathElementIndex - 1).getNamedElement();
				while (featureGroup.getFeatureGroupType() == null && featureGroup.getPrototype() == null
						&& featureGroup.getRefined() instanceof FeatureGroup) {
					featureGroup = (FeatureGroup) featureGroup.getRefined();
				}
				if (featureGroup.getFeatureGroupType() != null) {
					NamedElement searchResult = featureGroup.getFeatureGroupType().findNamedElement(elementName);
					if (searchResult != null)
						pathElement.setNamedElement(searchResult);
					else {
						errManager.error(
								pathElement,
								'\'' + elementName + "' not found in '"
										+ reconstructPath(path.subList(0, pathElementIndex)) + '\'');
					}
				} else if (featureGroup.getPrototype() != null) {
					Classifier topLevelClassifier;
					ArrayList<StructuralFeature> subcomponentsAndFeatureGroups;
					if (propertyAssociationContainer instanceof Classifier) {
						topLevelClassifier = (Classifier) propertyAssociationContainer;
						subcomponentsAndFeatureGroups = new ArrayList<StructuralFeature>(pathElementIndex);
					} else {
						topLevelClassifier = getContainingClassifier(propertyAssociationContainer);
						subcomponentsAndFeatureGroups = new ArrayList<StructuralFeature>(pathElementIndex + 1);
						subcomponentsAndFeatureGroups.add((StructuralFeature) propertyAssociationContainer);
					}
					for (int i = 0; i < pathElementIndex; i++)
						subcomponentsAndFeatureGroups.add((StructuralFeature) path.get(i).getNamedElement());
					FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
							topLevelClassifier, subcomponentsAndFeatureGroups,
							(FeatureGroupPrototype) featureGroup.getPrototype());
					if (featureGroupType != null) {
						NamedElement searchResult = featureGroupType.findNamedElement(elementName);
						if (searchResult != null)
							pathElement.setNamedElement(searchResult);
						else {
							errManager.error(pathElement, '\'' + elementName + "' not found in '"
									+ reconstructPath(path.subList(0, pathElementIndex)) + '\'');
						}
					} else {
						errManager.error(
								pathElement,
								'\'' + elementName + "' not found in '"
										+ reconstructPath(path.subList(0, pathElementIndex)) + '\'');
					}
				} else {
					errManager.error(pathElement,
							'\'' + elementName + "' not found in '"
									+ reconstructPath(path.subList(0, pathElementIndex)) + '\'');
				}
			} else if (path.get(pathElementIndex - 1).getNamedElement() != null) {
				errManager.error(pathElement,
						'\'' + elementName + "' not found in '" + reconstructPath(path.subList(0, pathElementIndex))
								+ '\'');
			}
			/*
			 * If path.get(pathElementIndex - 1).getNamedElement() == null, then
			 * do nothing. This means that the previous element failed name
			 * resolution. An error marker has already been created. Don't
			 * create a new one.
			 */
		}
	}

	private void caseArrayElementClassifierReference(ComponentImplementationReference implementationReference,
			String packageName, String implementationName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, implementationName,
				getContainingPackageSection(implementationReference));
		if (searchResult instanceof ComponentImplementation)
			implementationReference.setImplementation((ComponentImplementation) searchResult);
		else if (searchResult != null) {
			errManager.error(implementationReference, '\'' + getQualifiedName(packageName, implementationName)
					+ "' is not a component implementation");
		} else
			errManager.error(implementationReference, '\'' + getQualifiedName(packageName, implementationName)
					+ "' not found");
	}

	private void caseAbstractFeatureRefinementReference(AbstractFeature refiningAbstractFeature,
			String refinedAbstractFeatureName) {
		Classifier containingClassifier = getContainingClassifier(refiningAbstractFeature);
		Classifier extendedClassifier;
		if (containingClassifier instanceof ComponentType)
			extendedClassifier = ((ComponentType) containingClassifier).getExtended();
		else
			//Must be a FeatureGroupType.  AbstractFeatures cannot be contained in a ComponentImplementation.
			extendedClassifier = ((FeatureGroupType) containingClassifier).getExtended();
		NamedElement searchResult = extendedClassifier.findNamedElement(refinedAbstractFeatureName);
		if (searchResult instanceof AbstractFeature)
			refiningAbstractFeature.setRefined((AbstractFeature) searchResult);
		else if (searchResult != null)
			errManager.error(refiningAbstractFeature, '\'' + refinedAbstractFeatureName
					+ "' is not an abstract feature");
		else
			errManager.error(refiningAbstractFeature, '\'' + refinedAbstractFeatureName
					+ "' not found in extension hierarchy");
	}

	private void caseBooleanOrConstantPropertyOrConstantReference(ConstantValue constantValue, String propertySetName,
			String propertyOrConstantName) {
		if (constantValue.getOwner() instanceof Operation) {
			NamedElement searchResult = findNamedElementInPropertySet(propertySetName, propertyOrConstantName,
					getContainingTopLevelNamespace(constantValue));
			if (searchResult instanceof PropertyConstant)
				constantValue.setConstant((PropertyConstant) searchResult);
			else if (searchResult != null) {
				errManager.error(constantValue, '\'' + getQualifiedName(propertySetName, propertyOrConstantName)
						+ "' is not a property constant");
			} else
				errManager.error(constantValue, '\'' + getQualifiedName(propertySetName, propertyOrConstantName)
						+ "' not found");
		} else if (constantValue.getOwner() instanceof PropertyConstant) {
			PropertyConstant propertyConstant = (PropertyConstant) constantValue.getOwner();
			propertyConstant.setConstantValue(null);
			casePropertyOrConstantReference(propertyConstant, null, propertySetName, propertyOrConstantName);
		} else if (constantValue.getOwner() instanceof ModalPropertyValue) {
			ModalPropertyValue mpv = (ModalPropertyValue) constantValue.getOwner();
			mpv.setOwnedValue(null);
			casePropertyOrConstantReference(mpv, null, propertySetName, propertyOrConstantName);
		} else if (constantValue.getOwner() instanceof BasicPropertyAssociation) {
			BasicPropertyAssociation bpa = (BasicPropertyAssociation) constantValue.getOwner();
			bpa.setOwnedValue(null);
			casePropertyOrConstantReference(bpa, null, propertySetName, propertyOrConstantName);
		} else if (constantValue.getOwner() instanceof Property) {
			Property property = (Property) constantValue.getOwner();
			property.setDefaultValue(null);
			casePropertyOrConstantReference(property, null, propertySetName, propertyOrConstantName);
		} else if (constantValue.getOwner() instanceof ListValue) {
			ListValue listValue = (ListValue) constantValue.getOwner();
			for (Iterator<PropertyExpression> iter = listValue.getOwnedListElements().iterator(); iter.hasNext();) {
				if (iter.next() == constantValue) {
					iter.remove();
					break;
				}
			}
			casePropertyOrConstantReference(listValue, null, propertySetName, propertyOrConstantName);
		} else {
			errManager.internalError("Problem in NameResolver.caseBooleanOrConstantPropertyOrConstantReference."
					+ "  Unaccounted for situation with model object: " + constantValue.getOwner());
		}
	}

	private void caseBooleanOrConstantEnumerationLiteralOrPropertyOrConstantReference(ConstantValue constantValue,
			String literalOrPropertyOrConstantName) {
		if (constantValue.getOwner() instanceof PropertyConstant) {
			PropertyConstant propertyConstant = (PropertyConstant) constantValue.getOwner();
			propertyConstant.setConstantValue(null);
			caseEnumerationLiteralOrPropertyOrConstantReference(propertyConstant, literalOrPropertyOrConstantName);
		} else if (constantValue.getOwner() instanceof ModalPropertyValue) {
			ModalPropertyValue mpv = (ModalPropertyValue) constantValue.getOwner();
			mpv.setOwnedValue(null);
			caseEnumerationLiteralOrPropertyOrConstantReference(mpv, literalOrPropertyOrConstantName);
		} else if (constantValue.getOwner() instanceof BasicPropertyAssociation) {
			BasicPropertyAssociation bpa = (BasicPropertyAssociation) constantValue.getOwner();
			bpa.setOwnedValue(null);
			caseEnumerationLiteralOrPropertyOrConstantReference(bpa, literalOrPropertyOrConstantName);
		} else if (constantValue.getOwner() instanceof Property) {
			Property property = (Property) constantValue.getOwner();
			property.setDefaultValue(null);
			caseEnumerationLiteralOrPropertyOrConstantReference(property, literalOrPropertyOrConstantName);
		} else if (constantValue.getOwner() instanceof ListValue) {
			ListValue listValue = (ListValue) constantValue.getOwner();
			for (Iterator<PropertyExpression> iter = listValue.getOwnedListElements().iterator(); iter.hasNext();) {
				if (iter.next() == constantValue) {
					iter.remove();
					break;
				}
			}
			caseEnumerationLiteralOrPropertyOrConstantReference(listValue, literalOrPropertyOrConstantName);
		} else {
			errManager
					.internalError("Problem in NameResolver.caseBooleanOrConstantEnumerationLiteralOrPropertyOrConstantReference."
							+ "  Unaccounted for situation with model object: " + constantValue.getOwner());
		}
	}

	private void casePropertyOwnerComponentTypeReference(ClassifierValue classifierValue, String packageName,
			String classifierName) {
		NamedElement searchResult = findNamedElementInAadlPackage(packageName, classifierName,
				getContainingTopLevelNamespace(classifierValue));
		if (searchResult instanceof Classifier)
			classifierValue.setClassifier((Classifier) searchResult);
		else if (searchResult != null)
			errManager.error(classifierValue, '\'' + getQualifiedName(packageName, classifierName)
					+ "' is not a classifier");
		else
			errManager.error(classifierValue, '\'' + getQualifiedName(packageName, classifierName) + "' not found");
	}

	private void casePropertyOwnerComponentImplementationReference(ClassifierValue classifierValue, String packageName,
			String typeName, String implementationName) {
		casePropertyOwnerComponentTypeReference(classifierValue, packageName, typeName + '.' + implementationName);
	}

	private void caseDimensionPropertyReference(ArraySpecification arraySpecification, String propertySetName,
			String constantOrDefinitionName) {
		NamedElement searchResult = findNamedElementInPropertySet(propertySetName, constantOrDefinitionName,
				getContainingPackageSection(arraySpecification));
		if (searchResult instanceof PropertyConstant) {
			ConstantValue constantValue = (ConstantValue) arraySpecification
					.createSize(aadl2Package.getConstantValue());
			constantValue.setConstant((PropertyConstant) searchResult);
		} else if (searchResult instanceof Property) {
			PropertyReference propertyReference = (PropertyReference) arraySpecification.createSize(aadl2Package
					.getPropertyReference());
			propertyReference.setProperty((Property) searchResult);
		} else if (searchResult != null) {
			errManager.error(arraySpecification, '\'' + getQualifiedName(propertySetName, constantOrDefinitionName)
					+ "' is not a property constant or a property definition");
		} else
			errManager.error(arraySpecification, '\'' + getQualifiedName(propertySetName, constantOrDefinitionName)
					+ "' not found");
	}

	private void caseLowerBoundPropertyConstantReference(RangeValue rangeValue, String signAsString,
			String propertySetName, String propertyConstantName) {
		OperationKind sign;
		if (signAsString == null)
			sign = null;
		else if (signAsString.equals("+"))
			sign = OperationKind.PLUS;
		else if (signAsString.equals("-"))
			sign = OperationKind.MINUS;
		else
			throw new IllegalArgumentException("signAsString must be \"+\" or \"-\".");
		NamedElement searchResult = findNamedElementInPropertySet(propertySetName, propertyConstantName,
				getContainingTopLevelNamespace(rangeValue));
		if (searchResult instanceof PropertyConstant) {
			ConstantValue constantValue;
			if (sign != null) {
				Operation operation = (Operation) rangeValue.createMinimum(aadl2Package.getOperation());
				operation.setOp(sign);
				constantValue = (ConstantValue) operation
						.createOwnedPropertyExpression(aadl2Package.getConstantValue());
			} else
				constantValue = (ConstantValue) rangeValue.createMinimum(aadl2Package.getConstantValue());
			constantValue.setConstant((PropertyConstant) searchResult);
		} else if (searchResult instanceof Property) {
			PropertyReference propertyReference;
			if (sign != null) {
				Operation operation = (Operation) rangeValue.createMinimum(aadl2Package.getOperation());
				operation.setOp(sign);
				propertyReference = (PropertyReference) operation.createOwnedPropertyExpression(aadl2Package
						.getPropertyReference());
			} else
				propertyReference = (PropertyReference) rangeValue.createMinimum(aadl2Package.getPropertyReference());
			propertyReference.setProperty((Property) searchResult);
		} else if (searchResult != null)
			errManager.error(rangeValue, '\'' + getQualifiedName(propertySetName, propertyConstantName)
					+ "' is not a property constant or a property definition");
		else
			errManager
					.error(rangeValue, '\'' + getQualifiedName(propertySetName, propertyConstantName) + "' not found");
	}

	private void caseUpperBoundPropertyConstantReference(RangeValue rangeValue, String signAsString,
			String propertySetName, String propertyConstantName) {
		OperationKind sign;
		if (signAsString == null)
			sign = null;
		else if (signAsString.equals("+"))
			sign = OperationKind.PLUS;
		else if (signAsString.equals("-"))
			sign = OperationKind.MINUS;
		else
			throw new IllegalArgumentException("signAsString must be \"+\" or \"-\".");
		NamedElement searchResult = findNamedElementInPropertySet(propertySetName, propertyConstantName,
				getContainingTopLevelNamespace(rangeValue));
		if (searchResult instanceof PropertyConstant) {
			ConstantValue constantValue;
			if (sign != null) {
				Operation operation = (Operation) rangeValue.createMaximum(aadl2Package.getOperation());
				operation.setOp(sign);
				constantValue = (ConstantValue) operation
						.createOwnedPropertyExpression(aadl2Package.getConstantValue());
			} else
				constantValue = (ConstantValue) rangeValue.createMaximum(aadl2Package.getConstantValue());
			constantValue.setConstant((PropertyConstant) searchResult);
		} else if (searchResult instanceof Property) {
			PropertyReference propertyReference;
			if (sign != null) {
				Operation operation = (Operation) rangeValue.createMaximum(aadl2Package.getOperation());
				operation.setOp(sign);
				propertyReference = (PropertyReference) operation.createOwnedPropertyExpression(aadl2Package
						.getPropertyReference());
			} else
				propertyReference = (PropertyReference) rangeValue.createMaximum(aadl2Package.getPropertyReference());
			propertyReference.setProperty((Property) searchResult);
		} else if (searchResult != null)
			errManager.error(rangeValue, '\'' + getQualifiedName(propertySetName, propertyConstantName)
					+ "' is not a property constant or a property definition");
		else
			errManager
					.error(rangeValue, '\'' + getQualifiedName(propertySetName, propertyConstantName) + "' not found");
	}

	private void caseDeltaPropertyConstantReference(RangeValue rangeValue, String signAsString, String propertySetName,
			String propertyConstantName) {
		OperationKind sign;
		if (signAsString == null)
			sign = null;
		else if (signAsString.equals("+"))
			sign = OperationKind.PLUS;
		else if (signAsString.equals("-"))
			sign = OperationKind.MINUS;
		else
			throw new IllegalArgumentException("signAsString must be \"+\" or \"-\".");
		NamedElement searchResult = findNamedElementInPropertySet(propertySetName, propertyConstantName,
				getContainingTopLevelNamespace(rangeValue));
		if (searchResult instanceof PropertyConstant) {
			ConstantValue constantValue;
			if (sign != null) {
				Operation operation = (Operation) rangeValue.createDelta(aadl2Package.getOperation());
				operation.setOp(sign);
				constantValue = (ConstantValue) operation
						.createOwnedPropertyExpression(aadl2Package.getConstantValue());
			} else
				constantValue = (ConstantValue) rangeValue.createDelta(aadl2Package.getConstantValue());
			constantValue.setConstant((PropertyConstant) searchResult);
		} else if (searchResult != null)
			errManager.error(rangeValue, '\'' + getQualifiedName(propertySetName, propertyConstantName)
					+ "' is not a property constant");
		else
			errManager
					.error(rangeValue, '\'' + getQualifiedName(propertySetName, propertyConstantName) + "' not found");
	}

	private static String reconstructPath(List<ContainmentPathElement> path) {
		if (path.size() == 0)
			throw new IllegalArgumentException("path cannot be an empty list.");
		StringBuilder pathAsString = new StringBuilder(path.get(0).getNamedElement().getName());
		for (int i = 1; i < path.size(); i++) {
			pathAsString.append('.');
			pathAsString.append(path.get(i).getNamedElement().getName());
		}
		return pathAsString.toString();
	}

	/**
	 * Dependencies: PrototypeFormalReference, ClassifierReference, PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
	 * 				 ComponentPrototypeRefinementReference.
	 * 		Based on the type of containingClassifier: ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
	 * 												   RealizationReference, FeatureGroupTypeExtendReference.
	 */
	/*
	 * TODO: Check for circular dependencies with prototypes. Example:
	 * 
	 * abstract a prototypes p1: subprogram group; p2: subprogram group; end a;
	 * 
	 * abstract implementation a.i ( p1 => p2, p2 => p1) subcomponents sub:
	 * subprogram group p1; calls sequence1: { call1: subprogram
	 * sub.access_feature_1; end a.i;
	 * 
	 * This will cause a stack overflow!
	 */
	private static ComponentClassifier findClassifierForComponentPrototype(Classifier containingClassifier,
			ComponentPrototype prototype) {
		//TODO: Need to check that the prototype binding is a component prototype binding.  In PrototypeFormalReference,
		//		we should check that component prototypes are bound by component prototype bindings.
		ComponentPrototypeBinding binding = (ComponentPrototypeBinding) findPrototypeBinding(containingClassifier,
				prototype);
		if (binding != null && binding.getActuals().size() >= 1) {
			if (binding.getActuals().get(0) instanceof ComponentReference)
				return ((ComponentReference) binding.getActuals().get(0)).getClassifier();
			else //It is a ComponentPrototypeReference
			{
				ComponentClassifier classifierForReferencedPrototype = findClassifierForComponentPrototype(
						containingClassifier,
						((ComponentPrototypeReference) binding.getActuals().get(0)).getPrototype());
				if (classifierForReferencedPrototype != null)
					return classifierForReferencedPrototype;
			}
		}
		while (prototype.getConstrainingClassifier() == null && prototype.getRefined() != null) {
			//TODO: Need to check that the component prototype refines a component prototype.
			//		This should be done in ComponentPrototypeRefinementReference.
			prototype = (ComponentPrototype) prototype.getRefined();
		}
		if (prototype.getConstrainingClassifier() != null)
			return prototype.getConstrainingClassifier();
		else
			return null;
	}

	/**
	 * Dependencies: PrototypeFormalReference, ClassifierReference, PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
	 * 				 ComponentPrototypeRefinementReference.
	 * 		Based on the type of classifierPrototypeContext: ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
	 * 														 RealizationReference, FeatureGroupTypeExtendReference.
	 */
	/*
	 * TODO: Check for circular dependencies with prototypes.
	 */
	private static ComponentClassifier findClassifierForComponentPrototype(Classifier classifierPrototypeContext,
			Subcomponent subcomponentPrototypeContext, ComponentPrototype prototype) {
		//TODO: Need to check that the prototype binding is a component prototype binding.  In PrototypeFormalReference,
		//		we should check that component prototypes are bound by component prototype bindings.
		ComponentPrototypeBinding binding = (ComponentPrototypeBinding) findPrototypeBinding(
				classifierPrototypeContext, subcomponentPrototypeContext, prototype);
		if (binding != null && binding.getActuals().size() >= 1) {
			if (binding.getActuals().get(0) instanceof ComponentReference)
				return ((ComponentReference) binding.getActuals().get(0)).getClassifier();
			else //It is a ComponentPrototypeReference
			{
				ComponentClassifier classifierForReferencedPrototype = findClassifierForComponentPrototype(
						classifierPrototypeContext, subcomponentPrototypeContext,
						((ComponentPrototypeReference) binding.getActuals().get(0)).getPrototype());
				if (classifierForReferencedPrototype != null)
					return classifierForReferencedPrototype;
			}
		}
		while (prototype.getConstrainingClassifier() == null && prototype.getRefined() != null) {
			//TODO: Need to check that the component prototype refines a component prototype.
			//		This should be done in ComponentPrototypeRefinementReference.
			prototype = (ComponentPrototype) prototype.getRefined();
		}
		if (prototype.getConstrainingClassifier() != null)
			return prototype.getConstrainingClassifier();
		else
			return null;
	}

	/**
	 * Dependencies: PrototypeFormalReference, ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
	 * 				 RealizationReference, ClassifierReference, PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
	 * 				 ComponentPrototypeRefinementReference.
	 */
	/*
	 * TODO: Check for circular dependencies with prototypes.
	 */
	private static ComponentClassifier findClassifierForComponentPrototype(Classifier topLevelClassifier,
			List<Subcomponent> subcomponents, ComponentPrototype prototype) {
		if (subcomponents.size() == 1) {
			ComponentPrototypeBinding binding = (ComponentPrototypeBinding) findPrototypeBinding(topLevelClassifier,
					prototype);
			if (binding != null && binding.getActuals().size() >= 1) {
				if (binding.getActuals().get(0) instanceof ComponentReference)
					return ((ComponentReference) binding.getActuals().get(0)).getClassifier();
				else //It is a ComponentPrototypeReference
				{
					ComponentClassifier classifierForReferencedPrototype = findClassifierForComponentPrototype(
							topLevelClassifier, subcomponents,
							((ComponentPrototypeReference) binding.getActuals().get(0)).getPrototype());
					if (classifierForReferencedPrototype != null)
						return classifierForReferencedPrototype;
				}
			}
		} else {
			ComponentPrototypeBinding binding = (ComponentPrototypeBinding) findPrototypeBinding(
					getContainingClassifier(subcomponents.get(subcomponents.size() - 1)), prototype);
			if (binding != null && binding.getActuals().size() >= 1) {
				if (binding.getActuals().get(0) instanceof ComponentReference)
					return ((ComponentReference) binding.getActuals().get(0)).getClassifier();
				else //It is a ComponentPrototypeReference
				{
					ComponentClassifier classifierForReferencedPrototype = findClassifierForComponentPrototype(
							topLevelClassifier, subcomponents,
							((ComponentPrototypeReference) binding.getActuals().get(0)).getPrototype());
					if (classifierForReferencedPrototype != null)
						return classifierForReferencedPrototype;
				}
			} else {
				binding = (ComponentPrototypeBinding) findPrototypeBinding(subcomponents.get(subcomponents.size() - 2),
						prototype);
				if (binding != null) {
					if (binding.getActuals().get(0) instanceof ComponentReference)
						return ((ComponentReference) binding.getActuals().get(0)).getClassifier();
					else //It is a ComponentPrototypeReference
					{
						ComponentClassifier classifierForReferencedPrototype = findClassifierForComponentPrototype(
								topLevelClassifier, subcomponents.subList(0, subcomponents.size() - 1),
								((ComponentPrototypeReference) binding.getActuals().get(0)).getPrototype());
						if (classifierForReferencedPrototype != null)
							return classifierForReferencedPrototype;
					}
				}
			}
		}
		while (prototype.getConstrainingClassifier() == null && prototype.getRefined() != null) {
			//TODO: Need to check that the component prototype refines a component prototype.
			//		This should be done in ComponentPrototypeRefinementReference.
			prototype = (ComponentPrototype) prototype.getRefined();
		}
		if (prototype.getConstrainingClassifier() != null)
			return prototype.getConstrainingClassifier();
		else
			return null;
	}

	/**
	 * Dependencies: PrototypeFormalReference, FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference,
	 * 				 FeatureGroupPrototypeClassifierReference, FeatureGroupPrototypeRefinementReference.
	 * 		Based on the type of containingClassifier: ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
	 * 												   RealizationReference, FeatureGroupTypeExtendReference.
	 */
	//TODO: Check for circular dependencies with prototypes.
	private static FeatureGroupType findFeatureGroupTypeForFeatureGroupPrototype(Classifier containingClassifier,
			FeatureGroupPrototype prototype) {
		//TODO: Need to check that the prototype binding is a feature group prototype binding.  In PrototypeFormalReference,
		//		we should check that feature group prototypes are bound by feature group prototype bindings.
		FeatureGroupPrototypeBinding binding = (FeatureGroupPrototypeBinding) findPrototypeBinding(
				containingClassifier, prototype);
		if (binding != null) {
			if (binding.getActual() instanceof FeatureGroupReference)
				return ((FeatureGroupReference) binding.getActual()).getFeatureGroupType();
			else //It is a FeatureGroupPrototypeReference
			{
				FeatureGroupType featureGroupTypeForReferencedPrototype = findFeatureGroupTypeForFeatureGroupPrototype(
						containingClassifier, ((FeatureGroupPrototypeReference) binding.getActual()).getPrototype());
				if (featureGroupTypeForReferencedPrototype != null)
					return featureGroupTypeForReferencedPrototype;
			}
		}
		while (prototype.getConstrainingFeatureGroupType() == null && prototype.getRefined() != null) {
			//TODO: Need to check that the feature group prototype refines a feature group prototype.
			//		This should be done in FeatureGroupPrototypeRefinementReference.
			prototype = (FeatureGroupPrototype) prototype.getRefined();
		}
		if (prototype.getConstrainingFeatureGroupType() != null)
			return prototype.getConstrainingFeatureGroupType();
		else
			return null;
	}

	/**
	 * Dependencies: PrototypeFormalReference, FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference,
	 * 				 FeatureGroupPrototypeClassifierReference, FeatureGroupPrototypeRefinementReference.
	 * 		Based on the type of topLevelClassifier: ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
	 * 												 RealizationReference, FeatureGroupTypeExtendReference.
	 */
	//TODO: Check for circular dependencies with prototypes.
	private static FeatureGroupType findFeatureGroupTypeForFeatureGroupPrototype(Classifier topLevelClassifier,
			List<StructuralFeature> subcomponentsAndFeatureGroups, FeatureGroupPrototype prototype) {
		if (subcomponentsAndFeatureGroups.size() == 1) {
			FeatureGroupPrototypeBinding binding = (FeatureGroupPrototypeBinding) findPrototypeBinding(
					topLevelClassifier, prototype);
			if (binding != null) {
				if (binding.getActual() instanceof FeatureGroupReference)
					return ((FeatureGroupReference) binding.getActual()).getFeatureGroupType();
				else //It is a FeatureGroupPrototypeReference
				{
					FeatureGroupType featureGroupTypeForReferencedPrototype = findFeatureGroupTypeForFeatureGroupPrototype(
							topLevelClassifier, subcomponentsAndFeatureGroups,
							((FeatureGroupPrototypeReference) binding.getActual()).getPrototype());
					if (featureGroupTypeForReferencedPrototype != null)
						return featureGroupTypeForReferencedPrototype;
				}
			}
		} else {
			FeatureGroupPrototypeBinding binding = (FeatureGroupPrototypeBinding) findPrototypeBinding(
					getContainingClassifier(subcomponentsAndFeatureGroups.get(subcomponentsAndFeatureGroups.size() - 1)),
					prototype);
			if (binding != null) {
				if (binding.getActual() instanceof FeatureGroupReference)
					return ((FeatureGroupReference) binding.getActual()).getFeatureGroupType();
				else //It is a FeatureGroupPrototypeReference
				{
					FeatureGroupType featureGroupTypeForReferencedPrototype = findFeatureGroupTypeForFeatureGroupPrototype(
							topLevelClassifier, subcomponentsAndFeatureGroups,
							((FeatureGroupPrototypeReference) binding.getActual()).getPrototype());
					if (featureGroupTypeForReferencedPrototype != null)
						return featureGroupTypeForReferencedPrototype;
				}
			} else if (subcomponentsAndFeatureGroups.get(subcomponentsAndFeatureGroups.size() - 2) instanceof Subcomponent) {
				binding = (FeatureGroupPrototypeBinding) findPrototypeBinding(
						(Subcomponent) subcomponentsAndFeatureGroups.get(subcomponentsAndFeatureGroups.size() - 2),
						prototype);
				if (binding != null) {
					if (binding.getActual() instanceof FeatureGroupReference)
						return ((FeatureGroupReference) binding.getActual()).getFeatureGroupType();
					else //It is a FeatureGroupPrototypeReference
					{
						FeatureGroupType featureGroupTypeForReferencedPrototype = findFeatureGroupTypeForFeatureGroupPrototype(
								topLevelClassifier,
								subcomponentsAndFeatureGroups.subList(0, subcomponentsAndFeatureGroups.size() - 1),
								((FeatureGroupPrototypeReference) binding.getActual()).getPrototype());
						if (featureGroupTypeForReferencedPrototype != null)
							return featureGroupTypeForReferencedPrototype;
					}
				}
			}
		}
		while (prototype.getConstrainingFeatureGroupType() == null && prototype.getRefined() != null)
			prototype = (FeatureGroupPrototype) prototype.getRefined();
		if (prototype.getConstrainingFeatureGroupType() != null)
			return prototype.getConstrainingFeatureGroupType();
		else
			return null;
	}

	private static AadlPackage findImportedPackage(String name, Namespace context) {
		EList<AadlPackage> importedPackages;
		if (context instanceof PropertySet)
			importedPackages = ((PropertySet) context).getImportedPackages();
		else
			importedPackages = ((PackageSection) context).getImportedPackages();
		for (AadlPackage importedPackage : importedPackages)
			if (importedPackage.getName().equalsIgnoreCase(name))
				return importedPackage;
		if (context instanceof PrivatePackageSection && ((AadlPackage) context.eContainer()).getPublicSection() != null)
			for (AadlPackage importedPackage : ((AadlPackage) context.eContainer()).getPublicSection()
					.getImportedPackages())
				if (importedPackage.getName().equalsIgnoreCase(name))
					return importedPackage;
		return null;
	}

	private static PropertySet findImportedPropertySet(String name, Namespace context) {
		EList<PropertySet> importedPropertySets;
		if (context instanceof PropertySet)
			importedPropertySets = ((PropertySet) context).getImportedPropertySets();
		else
			importedPropertySets = ((PackageSection) context).getImportedPropertySets();
		for (PropertySet importedPropertySet : importedPropertySets)
			if (importedPropertySet.getName().equalsIgnoreCase(name))
				return importedPropertySet;
		return null;
	}

	private static PackageSection getContainingPackageSection(Element element) {
		Element container = element.getOwner();
		while (container != null && !(container instanceof PackageSection))
			container = container.getOwner();
		return (PackageSection) container;
	}

	private static PropertySet getContainingPropertySet(Element element) {
		return (PropertySet) element.getElementRoot();
	}

	private static Namespace getContainingTopLevelNamespace(Element element) {
		Element container = element.getOwner();
		while (container != null && !(container instanceof PackageSection) && !(container instanceof PropertySet))
			container = container.getOwner();
		return (Namespace) container;
	}

	private static Namespace getContainingNamespace(Element element) {
		Element container = element.getOwner();
		while (container != null && !(container instanceof Namespace))
			container = container.getOwner();
		return (Namespace) container;
	}

	private static PropertyAssociation getContainingPropertyAssociation(ContainmentPathElement pathElement) {
		Element container = pathElement.getOwner();
		while (container != null && !(container instanceof PropertyAssociation))
			container = container.getOwner();
		return (PropertyAssociation) container;
	}

	/**
	 * Converts the first character of the String s to upper case and converts all other characters to lower case.
	 * This is used to make messages to the user look nice.
	 */
	private static String capitalizeFirstLetterOnly(String s) {
		StringBuilder builder = new StringBuilder(s.toLowerCase());
		builder.setCharAt(0, Character.toUpperCase(builder.charAt(0)));
		return builder.toString();
	}

	/**
	 * Search for a {@link NamedElement} in a package.  If {@code context} is a {@link PublicPackageSection}, then this
	 * method will search through the {@link PublicPackageSection} only.  If {@code context} is a
	 * {@link PrivatePackageSection}, then this method will search through the {@link PrivatePackageSection} and its
	 * corresponding {@link PublicPackageSection}.  This is different from
	 * {@link PrivatePackageSection#findNamedElement(String)} and
	 * {@link PrivatePackageSection#findNamedElement(String, boolean)} because those methods will not search through
	 * the corresponding {@link PublicPackageSection}.  This method does use
	 * {@link PackageSection#findNamedElement(String, boolean)}, so it will search for {@link ComponentType}s and
	 * {@link FeatureGroupType}s in the renames statements.
	 * 
	 * Dependencies: RenamesAll, ComponentTypeRename, FeatureGroupTypeRename.
	 * 
	 * @param name The name of the {@link NamedElement} to search for.
	 * @param context The {@link PackageSection} that contains the {@link Element} that needs the search result.
	 * @return The {@link NamedElement} or {@code null} if it cannot be found.
	 */
	private static NamedElement findNamedElementInAadlPackage(String name, PackageSection context) {
		NamedElement result = context.findNamedElement(name, false);
		if (result == null && context instanceof PrivatePackageSection
				&& ((AadlPackage) context.eContainer()).getPublicSection() != null)
			result = ((AadlPackage) context.eContainer()).getPublicSection().findNamedElement(name, false);
		return result;
	}

	/**
	 * Search for a {@link NamedElement} with the name {@code elementName} in the package specified by
	 * {@code packageName}.  This method will first check that the specified package is accessible within {@code context}.
	 * This is done by checking that {@code packageName} appears in a with statement or package rename of {@code context}
	 * or {@code context}'s corresponding {@link PublicPackageSection} if {@code context} is a {@link PrivatePackageSection}.
	 * If the package is not accessible, then {@code null} will be returned.  If the element cannot be found in the specified
	 * package, then {@code null} will be returned.
	 * 
	 * Dependencies:
	 * 		If packageName is null or refers to context: RenamesAll, ComponentTypeRename, FeatureGroupTypeRename.
	 * 		If packageName refers to a different package: WithStatementReference, PackageRenameReference.
	 * 
	 * @param packageName The name of the package that contains the element to search for.
	 * @param elementName The name of the element to search for.
	 * @param context The {@link PackageSection} that needs to refer to the specified {@link Element}.
	 * @return The {@link NamedElement} or {@code null} if it cannot be found.
	 */
	private static NamedElement findNamedElementInAadlPackage(String packageName, String elementName, Namespace context) {
		if (context instanceof PackageSection
				&& (packageName == null || context.getName().equalsIgnoreCase(packageName)))
			return findNamedElementInAadlPackage(elementName, (PackageSection) context);
		else {
			AadlPackage aadlPackage = null;

			if (context instanceof PackageSection) {
				PackageRename packageRename = findPackageRename(packageName, (PackageSection) context);
				if (packageRename != null)
					aadlPackage = packageRename.getRenamedPackage();
				else
					aadlPackage = findImportedPackage(packageName, context);
			} else
				aadlPackage = findImportedPackage(packageName, context);

			if (aadlPackage != null && aadlPackage.getPublicSection() != null)
				return aadlPackage.getPublicSection().findNamedElement(elementName, true);
			else
				return null;
		}
	}

	/**
	 * Dependencies:
	 * 		If propertySetName is the name of a different, non standard property set: WithStatementReference.
	 */
	private static NamedElement findNamedElementInPropertySet(String propertySetName, String elementName,
			Namespace context) {
		if (propertySetName == null) {
			for (PropertySet predeclaredPropertySet : OsateResourceManager.getPredeclaredPropertySets()) {
				NamedElement searchResult = predeclaredPropertySet.findNamedElement(elementName);
				if (searchResult != null)
					return searchResult;
			}
			return null;
		} else {
			PropertySet propertySet;
			if (context instanceof PropertySet && context.getName().equalsIgnoreCase(propertySetName))
				propertySet = (PropertySet) context;
			else {
				propertySet = findImportedPropertySet(propertySetName, context);
				if (propertySet == null)
					for (PropertySet predeclaredPropertySet : OsateResourceManager.getPredeclaredPropertySets())
						if (predeclaredPropertySet.getName().equalsIgnoreCase(propertySetName))
							propertySet = predeclaredPropertySet;
			}
			if (propertySet != null)
				return propertySet.findNamedElement(elementName);
			else
				return null;
		}
	}

	/**
	 * Search for a {@link PackageRename} in a package.  If {@code context} is a {@link PrivatePackageSection}, then
	 * this method will also search through the {@link PackageRename}s of the corresponding {@link PublicPackageSection}.
	 * The {@link PackageRename#isRenameAll() renameAll} flag of the returned {@link PackageRename} will be {@code false}.
	 * 
	 * @param name The name of the {@link PackageRename} to search for.
	 * @param context The {@link PackageSection} that contains the {@link Element} that needs a {@link PackageRename}.
	 * @return The {@link PackageRename} or {@code null} if it cannot be found.
	 */
	private static PackageRename findPackageRename(String name, PackageSection context) {
		NamedElement searchResult = context.findNamedElement(name, false);
		if (searchResult == null && context instanceof PrivatePackageSection
				&& ((AadlPackage) context.eContainer()).getPublicSection() != null) {
			searchResult = ((AadlPackage) context.eContainer()).getPublicSection().findNamedElement(name, false);
		}
		if (searchResult instanceof PackageRename)
			return (PackageRename) searchResult;
		else
			return null;
	}

	private static String getQualifiedName(String packageOrPropertySetName, String elementName) {
		if (packageOrPropertySetName == null)
			return elementName;
		else
			return packageOrPropertySetName + "::" + elementName;
	}

	private static Classifier getContainingClassifier(Element element) {
		Element container = element.getOwner();
		while (container != null && !(container instanceof Classifier))
			container = container.getOwner();
		return (Classifier) container;
	}

	/**
	 * Dependencies: PrototypeFormalReference.
	 * 		Based on the type of classifier: ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference,
	 * 										 FeatureGroupTypeExtendReference.
	 */
	private static PrototypeBinding findPrototypeBinding(Classifier classifier, Prototype prototype) {
		for (PrototypeBinding binding : classifier.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		for (Generalization generalization : classifier.getGeneralizations()) {
			PrototypeBinding result = findPrototypeBinding(generalization.getGeneral(), prototype);
			if (result != null)
				return result;
		}
		return null;
	}

	/**
	 * Dependencies: PrototypeFormalReference.
	 * 		Based on the type of classifierPrototypeContext: ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
	 * 														 RealizationReference, FeatureGroupTypeExtendReference.
	 */
	private static PrototypeBinding findPrototypeBinding(Classifier classifierPrototypeContext,
			Subcomponent subcomponentPrototypeContext, Prototype prototype) {
		for (PrototypeBinding binding : subcomponentPrototypeContext.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		for (PrototypeBinding binding : classifierPrototypeContext.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		for (Generalization generalization : classifierPrototypeContext.getGeneralizations()) {
			PrototypeBinding result = findPrototypeBinding(generalization.getGeneral(), prototype);
			if (result != null)
				return result;
		}
		return null;
	}

	/**
	 * Dependencies: PrototypeFormalReference.
	 */
	private static PrototypeBinding findPrototypeBinding(Subcomponent subcomponent, Prototype prototype) {
		for (PrototypeBinding binding : subcomponent.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		return null;
	}
}