/*
 *
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
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
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */

package org.osate.xtext.aadl2.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.osate.aadl2.*;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.properties.PropertyLookupException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.xtext.aadl2.properties.util.AadlProject;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.MemoryProperties;
import org.osate.xtext.aadl2.properties.util.ModelingProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;
import org.osate.xtext.aadl2.scoping.Aadl2GlobalScopeProvider;

import com.google.inject.Inject;

public class Aadl2JavaValidator extends AbstractAadl2JavaValidator {
	public static final String MISMATCHED_BEGINNING_AND_ENDING_IDENTIFIERS = "org.osate.xtext.aadl2.mismatched_beginning_and_ending_identifiers";
	public static final String DUPLICATE_COMPONENT_TYPE_NAME = "org.osate.xtext.aadl2.duplicate_component_type_names";
	public static final String DUPLICATE_LITERAL_IN_ENUMERATION = "org.osate.xtext.aadl2.duplicate_literal_in_enumeration";
	public static final String UNIT_LITERAL_OUT_OF_ORDER = "org.osate.xtext.aadl2.unit_literal_out_of_order";
	public static final String MODE_NOT_DEFINED_IN_CONTAINER = "org.osate.xtext.aadl2.mode_not_defined_in_container";
	public static final String SELF_NOT_ALLOWED = "org.osate.xtext.aadl2.self_not_alllowed";
	public static final String PROCESSOR_NOT_ALLOWED = "org.osate.xtext.aadl2.processor_not_allowed";
	public static final String INCONSISTENT_FLOW_KIND = "org.osate.xtext.aadl2.inconsistent_flow_kind";
	public static final String OUT_FLOW_FEATURE_IDENTIFIER_NOT_SPEC = "org.osate.xtext.aadl2.out_flow_feature_identifier_not_spec";
	public static final String IN_FLOW_FEATURE_IDENTIFIER_NOT_SPEC = "org.osate.xtext.aadl2.in_flow_feature_identifier_not_spec";
	public static final String SUBCOMPONENT_NOT_IN_FLOW_MODE = "org.osate.xtext.aadl2.subcomponent_not_in_flow_mode";
	public static final String CONNECTION_NOT_IN_FLOW_MODE = "org.osate.xtext.aadl2.connection_not_in_flow_mode";
	public static final String END_TO_END_FLOW_SEGMENT_NOT_IN_MODE = "org.osate.xtext.aadl2.end_to_end_flow_segment_not_in_mode";
	public static final String GENERIC_TEXT_REPLACEMENT = "org.osate.xtext.aadl2.generic_text_replacement";
	public static final String ARRAY_SIZE_NOT_EQUAL_REFERENCE_LIST_SIZE = "org.osate.xtext.aadl2.array_size_not_equal_reference_list_size";
	public static final String PROTOTYPE_NOT_ARRAY = "org.osate.xtext.aadl2.prototype_not_array";
	public static final String PROTOTYPE_BINDING_DIRECTION_NOT_CONSISTENT_WITH_FORMAL = "org.osate.xtext.aadl2.prototype_binding_direction_not_consistent_with_formal";
	public static final String INCOMPATIBLE_DIRECTION_FOR_PROTOTYPE_REFINEMENT = "org.osate.xtext.aadl2.incompatible_direction_for_prototype_refinement";
	public static final String INCOMPATIBLE_FEATURE_DIRECTION_IN_REFINEMENT = "org.osate.xtext.aadl2.incompatible_feature_direction_in_refinement";
	public static final String ABSTRACT_FEATURE_DIRECTION_NOT_IN_PROTOTYPE = "org.osate.xtext.aadl2.abstract_feature_direction_not_in_prototype";
	public static final String ABSTRACT_FEATURE_DIRECTION_DOES_NOT_MATCH_PROTOTYPE = "org.osate.xtext.aadl2.abstract_feature_direction_does_not_match_prototype";
	public static final String ADDED_DIRECTION_IN_ABSTRACT_FEATURE_REFINEMENT = "org.osate.xtext.aadl2.added_direction_in_abstract_feature_refinement";
	public static final String ADDED_PROTOTYPE_OR_CLASSIFIER_IN_ABSTRACT_FEATURE_REFINEMENT = "org.osate.xtext.aadl2.added_prototype_or_classifier_in_abstract_feature_refinement";
	public static final String CHAINED_INVERSE_FEATURE_GROUP_TYPES = "org.osate.xtext.aadl2.chained_inverse_feature_group_types";
	public static final String EXTENDED_INVERSE_FEATURE_GROUP_TYPE = "org.osate.xtext.aadl2.extended_inverse_feature_group_type";
	public static final String INVERSE_IN_FEATURE_GROUP_TYPE_EXTENSION = "org.osate.xtext.aadl2.inverse_in_feature_group_type_extension";
	public static final String INVERSE_IN_FEATURE_GROUP = "org.osate.xtext.aadl2.inverse_in_feature_group";
	public static final String DIRECTION_NOT_SAME_AS_FEATURE_GROUP_MEMBERS = "org.osate.xtext.aadl2.direction_not_same_as_feature_group_members";
	public static final String REVERSE_ACCESS_KIND = "org.osate.xtext.aadl2.reverse_access_kind";
	public static final String NUMERIC_RANGE_UPPER_LESS_THAN_LOWER = "org.osate.xtext.aadl2.numeric_range_upper_less_than_lower";
	public static final String MAKE_CONNECTION_BIDIRECTIONAL = "org.osate.xtext.aadl2.make_connection_bidirectional";
	public static final String WITH_NOT_USED = "org.osate.xtext.aadl2.with_not_used";
	public static final String DATA_SIZE_INCONSISTENT = "org.osate.xtext.aadl2.data_size_inconsistent";

	@Check(CheckType.FAST)
	public void caseComponentImplementation(ComponentImplementation componentImplementation) {
		if (hasExtendCycles(componentImplementation)) {
			return;
		}
		checkComponentImplementationUniqueNames(componentImplementation);
		checkComponentImplementationInPackageSection(componentImplementation);
		checkComponentImplementationModes(componentImplementation);
		checkFlowImplementationModeCompatibilityWithRefinedFlowSegments(componentImplementation);
		checkModeSpecificFlowImplementations(componentImplementation);
		checkInheritedMissingModes(componentImplementation);
		checkEndId(componentImplementation);
	}

	@Check(CheckType.FAST)
	public void caseTypeExtension(TypeExtension typeExtension) {
		checkTypeExtensionCategory(typeExtension);
		checkFeaturesOfExtendedAbstractType((ComponentType) typeExtension.getSpecific());
		checkClassifierReferenceInWith(typeExtension.getExtended(), typeExtension);
	}

	@Check(CheckType.FAST)
	public void caseComponentType(ComponentType componentType) {
		if (hasExtendCycles(componentType)) {
			return;
		}
		checkComponentTypeUniqueNames(componentType);
		checkComponentTypeModes(componentType);
		checkForInheritedFeatureArrays(componentType);
		checkEndId(componentType);
		checkInheritedMissingModes(componentType);
	}

	@Check(CheckType.FAST)
	public void caseImplementationExtension(ImplementationExtension implementationExtension) {
		checkExtensionAndRealizationHierarchy(implementationExtension);
		checkImplementationExtensionCategory(implementationExtension);
		checkSubcomponentsOfExtendedAbstractImplementation(
				(ComponentImplementation) implementationExtension.getSpecific());
		checkClassifierReferenceInWith(implementationExtension.getExtended(), implementationExtension);
	}

	@Check(CheckType.FAST)
	public void caseRealization(Realization realization) {
		checkRealizationCategory(realization);
	}

	@Check(CheckType.FAST)
	public void caseComponentTypeRename(ComponentTypeRename componentTypeRename) {
		checkComponentTypeRenameCategory(componentTypeRename);
		checkClassifierReferenceInWith(componentTypeRename.getRenamedComponentType(), componentTypeRename);
	}

	@Check(CheckType.FAST)
	public void caseFeatureGroupTypeRename(FeatureGroupTypeRename fgtRename) {
		checkClassifierReferenceInWith(fgtRename.getRenamedFeatureGroupType(), fgtRename);
	}

	@Check(CheckType.FAST)
	public void caseSubcomponent(Subcomponent subcomponent) {
		checkForCyclicDeclarations(subcomponent);
		checkSubcomponentCategory(subcomponent);
		checkSubcomponentRefinementCategory(subcomponent);
		checkSubcomponentRefinementClassifierSubstitution(subcomponent);
		checkSubcomponentsHierarchy(subcomponent);
		checkClassifierReferenceInWith(subcomponent.getClassifier(), subcomponent);
		checkSubcomponentImplementationReferenceList(subcomponent);
		checkSubcomponentMissingModeValues(subcomponent);
	}

	@Check(CheckType.FAST)
	public void caseModalElement(ModalElement modalElement) {
		checkModalElementMissingModeValues(modalElement);
	}

	@Check(CheckType.FAST)
	public void caseComponentPrototype(ComponentPrototype prototype) {
		checkComponentPrototypeCategory(prototype);
		checkRefinedOfComponentPrototype(prototype);
		checkCategoryOfRefinedComponentPrototype(prototype);
		checkArrayOfRefinedComponentPrototype(prototype);
		checkClassifierReferenceInWith(prototype.getConstrainingClassifier(), prototype);
	}

	@Check(CheckType.FAST)
	public void caseComponentPrototypeBinding(ComponentPrototypeBinding binding) {
		checkComponentPrototypeBindingCategory(binding);
		checkFormalOfComponentPrototypeBinding(binding);
	}

	@Check(CheckType.FAST)
	public void caseComponentPrototypeActual(ComponentPrototypeActual prototypeActual) {
		checkComponentPrototypeActualComponentCategory(prototypeActual);
		if (prototypeActual.getSubcomponentType() instanceof Classifier) {
			checkClassifierReferenceInWith((Classifier) prototypeActual.getSubcomponentType(), prototypeActual);
		}
	}

	@Check(CheckType.FAST)
	public void caseFeaturePrototypeBinding(FeaturePrototypeBinding binding) {
		checkFeaturePrototypeBindingDirection(binding);
		checkFormalOfFeaturePrototypeBinding(binding);
	}

	@Check(CheckType.FAST)
	public void caseFeatureGroupPrototypeBinding(FeatureGroupPrototypeBinding binding) {
		checkFormalOfFeatureGroupPrototypeBinding(binding);
	}

	@Check(CheckType.FAST)
	public void caseFeatureGroupPrototypeActual(FeatureGroupPrototypeActual prototypeActual) {
		if (prototypeActual.getFeatureType() instanceof Classifier) {
			checkClassifierReferenceInWith((Classifier) prototypeActual.getFeatureType(), prototypeActual);
		}
	}

	@Check(CheckType.FAST)
	public void caseFeatureGroupPrototype(FeatureGroupPrototype prototype) {
		checkRefinedOfFeatureGroupPrototype(prototype);
	}

	@Check(CheckType.FAST)
	public void caseFeaturePrototype(FeaturePrototype prototype) {
		checkRefinedOfFeaturePrototype(prototype);
		checkDirectionOfRefinedFeaturePrototype(prototype);
	}

	@Check(CheckType.FAST)
	public void casePortSpecification(PortSpecification portspec) {
		checkClassifierReferenceInWith(portspec.getClassifier(), portspec);
	}

	@Check(CheckType.FAST)
	public void caseAccessSpecification(AccessSpecification accessspec) {
		checkClassifierReferenceInWith(accessspec.getClassifier(), accessspec);
	}

	@Check(CheckType.FAST)
	public void caseArraySize(ArraySize arraySize) {
		if (arraySize.getSizeProperty() != null) {
			checkPropertySetElementReference((NamedElement) (arraySize.getSizeProperty()), arraySize);
			checkArraySizeIsAadlintegerNoUnits(arraySize);
		}
	}

	@Check(CheckType.FAST)
	public void caseComponentImplementationReference(ComponentImplementationReference ciref) {
		checkClassifierReferenceInWith(ciref.getImplementation(), ciref);
	}

	@Check(CheckType.FAST)
	public void caseDataType(DataType dataType) {
		checkForInheritedFlowsAndModesFromAbstractType(dataType);

	}

	@Check(CheckType.FAST)
	public void caseDataImplementation(DataImplementation dataImplementation) {
		checkForInheritedFlowsAndModesFromAbstractImplementation(dataImplementation);
		checkDataSizeProperty(dataImplementation);
	}

	@Check(CheckType.FAST)
	public void caseThreadGroupImplementation(ThreadGroupImplementation threadGroupImplementation) {
		checkForInheritedCallSequenceFromAbstractImplementation(threadGroupImplementation);

	}

	@Check(CheckType.FAST)
	public void caseProcessorImplementation(ProcessorImplementation processorImplementation) {
		checkForInheritedCallSequenceFromAbstractImplementation(processorImplementation);

	}

	@Check(CheckType.FAST)
	public void caseVirtualProcessorImplementation(VirtualProcessorImplementation virtualProcessorImplementation) {
		checkForInheritedCallSequenceFromAbstractImplementation(virtualProcessorImplementation);

	}

	@Check(CheckType.FAST)
	public void caseMemoryType(MemoryType memoryType) {
		checkForInheritedFlowsFromAbstractType(memoryType);

	}

	@Check(CheckType.FAST)
	public void caseMemoryImplementation(MemoryImplementation memoryImplementation) {
		checkForInheritedFlowsAndCallSequenceFromAbstractImplementation(memoryImplementation);

	}

	@Check(CheckType.FAST)
	public void caseBusType(BusType busType) {
		checkForInheritedFlowsFromAbstractType(busType);

	}

	@Check(CheckType.FAST)
	public void caseBusImplementation(BusImplementation busImplementation) {
		checkForInheritedConnectionsFlowsAndCallsFromAbstractImplementation(busImplementation);

	}

	@Check(CheckType.FAST)
	public void caseVirtualBusType(VirtualBusType virtualBusType) {
		checkForInheritedFlowsFromAbstractType(virtualBusType);

	}

	@Check(CheckType.FAST)
	public void caseVirtualBusImplementation(VirtualBusImplementation virtualBusImplementation) {
		checkForInheritedConnectionsFlowsAndCallsFromAbstractImplementation(virtualBusImplementation);

	}

	@Check(CheckType.FAST)
	public void caseDeviceImplementation(DeviceImplementation deviceImplementation) {
		checkForInheritedCallsFromAbstractImplementation(deviceImplementation);

	}

	@Check(CheckType.FAST)
	public void caseFeature(Feature feature) {
		checkTypeOfFeatureRefinement(feature);
		checkFeatureRefinementClassifierSubstitution(feature);
		checkForFeatureArrays(feature);
		checkForArraysInRefinedFeature(feature);
		checkForArrayDimensionSizeInRefinedFeature(feature);
		if (feature instanceof FeatureGroup) {
			checkClassifierReferenceInWith(((FeatureGroup) feature).getFeatureGroupType(), feature);
		} else {
			checkClassifierReferenceInWith(feature.getClassifier(), feature);
		}
		checkRefinedFeatureAsTransitionTrigger(feature);
		// checkPropertyAssocs(feature);
	}

	@Check(CheckType.FAST)
	public void caseConnection(Connection connection) {
		checkDefiningID(connection);
		checkReferencesToInternalFeatures(connection);

	}

	@Check(CheckType.FAST)
	public void casePortConnection(PortConnection connection) {
		typeCheckPortConnectionEnd(connection.getSource());
		typeCheckPortConnectionEnd(connection.getDestination());
		checkPortConnectionClassifiers(connection);
		checkConnectionDirection(connection);
		checkPortConnectionEnds(connection);

	}

	@Check(CheckType.FAST)
	public void caseParameterConnection(ParameterConnection connection) {
		typeCheckParameterConnectionEnd(connection.getSource());
		typeCheckParameterConnectionEnd(connection.getDestination());
		checkParameterConnectionClassifiers(connection);
	}

	@Check(CheckType.FAST)
	public void caseAccessConnection(AccessConnection connection) {
		typeCheckAccessConnectionEnd(connection.getSource());
		typeCheckAccessConnectionEnd(connection.getDestination());
		checkAccessConnectionCategory(connection);
		checkAccessConnectionProvidesRequires(connection);
		checkAccessConnectionClassifiers(connection);
	}

	@Check(CheckType.FAST)
	public void caseFeatureConnection(FeatureConnection connection) {
		if (connection.getSource().getConnectionEnd() instanceof FeatureGroupConnectionEnd
				&& connection.getDestination().getConnectionEnd() instanceof FeatureGroupConnectionEnd) {
			typeCheckFeatureGroupConnectionEnd(connection.getSource());
			typeCheckFeatureGroupConnectionEnd(connection.getDestination());
			checkFeatureGroupConnectionDirection(connection);
			checkFeatureGroupConnectionClassifiers(connection);
		} else {
			typeCheckFeatureConnectionEnd(connection.getSource());
			typeCheckFeatureConnectionEnd(connection.getDestination());
			checkConnectionDirection(connection);
			checkFeatureConnectionFeatureGroupToFeatureOrAbstract(connection);
		}
	}

	@Check(CheckType.FAST)
	public void caseFeatureGroupConnection(FeatureGroupConnection connection) {
		typeCheckFeatureGroupConnectionEnd(connection.getSource());
		typeCheckFeatureGroupConnectionEnd(connection.getDestination());
		checkFeatureGroupConnectionDirection(connection);
		checkFeatureGroupConnectionClassifiers(connection);
	}

	@Check(CheckType.FAST)
	public void caseFlowSpecification(FlowSpecification flow) {
		checkFlowFeatureDirection(flow);
	}

	@Check(CheckType.FAST)
	public void caseFlowEnd(FlowEnd flowEnd) {
		checkFlowFeatureType(flowEnd);
	}

	@Check(CheckType.FAST)
	public void caseFlowImplementation(FlowImplementation flow) {
		if (flow.getKind().equals(FlowKind.SOURCE) || flow.getKind().equals(FlowKind.PATH)) {
			checkOutFeatureIdentifier(flow);
		}
		if (flow.getKind().equals(FlowKind.SINK) || flow.getKind().equals(FlowKind.PATH)) {
			checkInFeatureIdentifier(flow);
		}
		checkConsistentFlowKind(flow);
		checkFlowConnectionOrder(flow);
		checkFlowConnectionEnds(flow);
		checkFlowSegmentModes(flow);
		checkSubcomponentFlows(flow);
		// checkFlowPathElements(flow);
	}

	@Check(CheckType.FAST)
	public void caseEndToEndFlow(EndToEndFlow flow) {
		typeCheckEndToEndFlowSegments(flow);
		checkEndToEndFlowSegments(flow);
		checkFlowConnectionEnds(flow);
		checkNestedEndToEndFlows(flow);
		checkEndToEndFlowModes(flow);
		checkSubcomponentFlows(flow);
	}

	@Check(CheckType.FAST)
	public void caseDirectedFeature(DirectedFeature feature) {
		checkFeatureDirectionInRefinement(feature);

	}

	@Check(CheckType.FAST)
	public void caseAbstractFeature(AbstractFeature feature) {
		checkAbstractFeatureAndPrototypeDirectionConsistency(feature);
		checkForAddedDirectionInAbstractFeatureRefinement(feature);
		checkForAddedPrototypeOrClassifierInAbstractFeatureRefinement(feature);

	}

	@Check(CheckType.FAST)
	public void caseFeatureGroupType(FeatureGroupType featureGroupType) {
		checkEndId(featureGroupType);
		if (hasExtendCycles(featureGroupType)) {
			return;
		}
		checkForChainedInverseFeatureGroupTypes(featureGroupType);
		checkFeatureGroupTypeUniqueNames(featureGroupType);
		checkClassifierReferenceInWith(featureGroupType.getInverse(), featureGroupType);
		checkFeaturesInInverseFeatureGroupType(featureGroupType);
	}

	@Check(CheckType.FAST)
	public void caseGroupExtension(GroupExtension extension) {
		checkForExtendingAnInverseFeatureGroupType(extension);
		checkForInverseInFeatureGroupTypeExtension(extension);
		checkForRequiredInverseInFeatureGroupTypeExtension(extension);
		checkClassifierReferenceInWith(extension.getExtended(), extension);
	}

	@Check(CheckType.FAST)
	public void caseFeatureGroup(FeatureGroup featureGroup) {
		checkForInverseInFeatureGroup(featureGroup);
		checkDirectionOfFeatureGroupMembers(featureGroup);
		checkLegalFeatureGroup(featureGroup);
	}

	@Check(CheckType.FAST)
	public void caseSubprogramAccess(SubprogramAccess subprogramAccess) {
		checkSubprogramAccessPrototypeReference(subprogramAccess);
		checkProvidesAccessOnly(subprogramAccess);
		checkRequiresAccessOnly(subprogramAccess);
	}

	@Check(CheckType.FAST)
	public void caseSubprogramGroupAccess(SubprogramGroupAccess subprogramGroupAccess) {
		checkSubprogramGroupAccessPrototypeReference(subprogramGroupAccess);
		checkProvidesAccessOnly(subprogramGroupAccess);
		checkRequiresAccessOnly(subprogramGroupAccess);
	}

	@Check(CheckType.FAST)
	public void caseAccess(Access access) {
		checkForAbstractFeatureDirectionInAccessRefinement(access);
		checkForAccessTypeInAccessRefinement(access);
	}

	@Check(CheckType.FAST)
	public void caseDataAccess(DataAccess dataAccess) {
		checkDataAccessPrototypeReference(dataAccess);
		checkRequiresAccessOnly(dataAccess);
	}

	@Check(CheckType.FAST)
	public void caseBusAccess(BusAccess busAccess) {
		checkBusAccessPrototypeReference(busAccess);
	}

	@Check(CheckType.FAST)
	public void caseSubprogramCall(SubprogramCall callSpec) {
		if (callSpec.getCalledSubprogram() instanceof Classifier) {
			checkClassifierReferenceInWith((Classifier) callSpec.getCalledSubprogram(), callSpec);
		}
		if (callSpec.getContext() instanceof Classifier) {
			checkClassifierReferenceInWith((Classifier) callSpec.getContext(), callSpec);
		}
	}

	@Check(CheckType.NORMAL)
	public void caseAadlPackage(AadlPackage pack) {
		String findings;

		findings = hasDuplicatesAadlPackage(pack);
		if (findings != null) {
			error(pack, "Package " + pack.getName() + " has duplicates " + findings);
		}
	}

	@Check(CheckType.FAST)
	public void casePropertySet(PropertySet propSet) {
		checkWithsAreUsed(propSet);
		checkForDuplicatesPropertySet(propSet);
	}

	@Check(CheckType.NORMAL)
	public void caseModelUnit(ModelUnit pack) {
		checkEndId(pack);
	}

	@Check(CheckType.FAST)
	public void caseClassifier(Classifier cl) {
		checkExtendCycles(cl);
		// checkEndId(cl);
	}

	@Check(CheckType.FAST)
	public void caseUnitsType(final UnitsType ut) {
		final EList<EnumerationLiteral> literals = ut.getOwnedLiterals();
		EList<NamedElement> doubles = AadlUtil.findDoubleNamedElementsInList(literals);
		if (doubles.size() > 0) {
			for (NamedElement ne : doubles) {
				error(ne, "Unit '" + ne.getName() + "' previously declared in enumeration");
			}
		}
	}

	@Check(CheckType.FAST)
	public void caseUnitLiteral(final UnitLiteral ul) {
		if (ul.getBaseUnit() != null && !ul.getBaseUnit().eIsProxy()) {
			EList<EnumerationLiteral> literals = ((UnitsType) ul.getOwner()).getOwnedLiterals();
			int ulIndex = literals.indexOf(ul);
			String[] literalNamesAndUri = new String[(ulIndex * 2) + 1];
			literalNamesAndUri[0] = ul.getBaseUnit().getName();
			int i = 1;
			for (EnumerationLiteral nextEL : literals) {
				if (literals.indexOf(nextEL) < ulIndex) {
					literalNamesAndUri[i] = nextEL.getName();
					i++;
					literalNamesAndUri[i] = EcoreUtil.getURI(nextEL).toString();
					i++;
				}
			}
			if (ul.equals(ul.getBaseUnit())) {
				error('\'' + ul.getName() + "' cannot be its own base unit", ul, null, UNIT_LITERAL_OUT_OF_ORDER,
						literalNamesAndUri);

			} else if (literals.indexOf(ul.getBaseUnit()) >= literals.indexOf(ul)) {
				error('\'' + ul.getBaseUnit().getName() + "' is not declared before '" + ul.getName() + '\'', ul, null,
						UNIT_LITERAL_OUT_OF_ORDER, literalNamesAndUri);
			}
		}
	}

	@Check(CheckType.FAST)
	public void caseEnumerationType(final EnumerationType et) {
		final EList<EnumerationLiteral> literals = et.getOwnedLiterals();
		EList<NamedElement> doubles = AadlUtil.findDoubleNamedElementsInList(literals);
		if (doubles.size() > 0) {
			for (NamedElement ne : doubles) {
				error("Literal '" + ne.getName() + "' previously declared in enumeration", ne, null,
						DUPLICATE_LITERAL_IN_ENUMERATION, ne.getName());
			}
		}
	}

	@Check(CheckType.FAST)
	public void caseRangeType(RangeType nt) {
		// checkRangeType(nt);
		if (nt.getNumberType() != nt.getOwnedNumberType()) {
			checkPropertySetElementReference(nt.getNumberType(), nt);
		}
	}

	@Check(CheckType.FAST)
	public void caseBasicProperty(BasicProperty bp) {
		if (bp.getPropertyType() != bp.getOwnedPropertyType()) {
			checkPropertySetElementReference(bp.getPropertyType(), bp);
		}
	}

	@Check(CheckType.FAST)
	public void caseProperty(Property bp) {
		if (bp.getPropertyType() != bp.getOwnedPropertyType()) {
			checkPropertySetElementReference(bp.getPropertyType(), bp);
		}
		checkPropertyDefinition(bp);
	}

	@Check(CheckType.FAST)
	public void caseListType(ListType bp) {
		if (bp.getElementType() != bp.getOwnedElementType()) {
			checkPropertySetElementReference(bp.getElementType(), bp);
		}
	}

	@Check(CheckType.FAST)
	public void casePropertyConstant(PropertyConstant bp) {
		if (bp.getPropertyType() != bp.getOwnedPropertyType()) {
			checkPropertySetElementReference(bp.getPropertyType(), bp);
		}
		checkPropertyConstant(bp);
	}

	@Check(CheckType.FAST)
	public void caseNumberType(NumberType nt) {
		checkNumberType(nt);
		if (nt.getUnitsType() != nt.getOwnedUnitsType()) {
			checkPropertySetElementReference(nt.getUnitsType(), nt);
		}
	}

	@Check(CheckType.FAST)
	public void caseNamedElement(NamedElement ne) {
		checkForDuplicatePropertyAssociations(ne);
	}

	@Check(CheckType.FAST)
	public void caseAadlinteger(final AadlInteger ai) {
		checkAadlinteger(ai);
	}

	@Check(CheckType.FAST)
	public void caseModeTransitionTrigger(ModeTransitionTrigger trigger) {
		typeCheckModeTransitionTrigger(trigger);
	}

	@Check(CheckType.FAST)
	public void casePackageSection(PackageSection packageSection) {
		checkWithsAreUsed(packageSection);
	}

	@Override
	public void checkForAppendsInContainedPropertyAssociation(PropertyAssociation propertyAssoc) {
		List<ContainedNamedElement> appliesTos = propertyAssoc.getAppliesTos();
		if (null != appliesTos && !appliesTos.isEmpty()) {
			if (propertyAssoc.isAppend()) {
				error("Append operator '+=>' cannot be used in contained property associations", propertyAssoc,
						Aadl2Package.eINSTANCE.getPropertyAssociation_Append());
			}
		}
	}

	public void checkWithsAreUsed(PackageSection packageSection) {
		List<ModelUnit> importedUnits = packageSection.getImportedUnits();
		ImportedUnitsLoop: for (ModelUnit nextImportedUnit : importedUnits) {
			if (!Aadl2Util.isNull(nextImportedUnit)) {
				if (nextImportedUnit.equals(packageSection.eContainer())) {
					StringBuilder errMsg = new StringBuilder(nextImportedUnit.getName());
					errMsg.append(" in 'with' clause of ");
					String publicOrPrivate = "public";
					if (packageSection instanceof PrivatePackageSection) {
						publicOrPrivate = "private";
					}
					errMsg.append(publicOrPrivate);
					errMsg.append(" package section refers to the containing package and is not needed.");
					String importedUnitURI = EcoreUtil.getURI(nextImportedUnit).toString();
					warning(errMsg.toString(), packageSection, Aadl2Package.eINSTANCE.getPackageSection_ImportedUnit(),
							importedUnits.indexOf(nextImportedUnit), WITH_NOT_USED, nextImportedUnit.getName(),
							importedUnitURI);
					continue ImportedUnitsLoop;
				}
				if (AadlUtil.isPredeclaredPropertySet(nextImportedUnit.getName())) {
					StringBuilder errMsg = new StringBuilder(nextImportedUnit.getName());
					errMsg.append(" in 'with' clause of ");
					String publicOrPrivate = "public";
					if (packageSection instanceof PrivatePackageSection) {
						publicOrPrivate = "private";
					}
					errMsg.append(publicOrPrivate);
					errMsg.append(" package section is a predeclared property set and is not needed.");
					String importedUnitURI = EcoreUtil.getURI(nextImportedUnit).toString();
					warning(errMsg.toString(), packageSection, Aadl2Package.eINSTANCE.getPackageSection_ImportedUnit(),
							importedUnits.indexOf(nextImportedUnit), WITH_NOT_USED, nextImportedUnit.getName(),
							importedUnitURI);
					continue ImportedUnitsLoop;
				}

				TreeIterator<EObject> packageSectionContents = packageSection.eAllContents();
				while (packageSectionContents.hasNext()) {
					EObject nextObject = packageSectionContents.next();
					EList<EObject> crossReferences = nextObject.eCrossReferences();
					for (EObject crossReference : crossReferences) {
						EObject container = crossReference.eContainer();
						if (nextImportedUnit.equals(container)) {
							continue ImportedUnitsLoop;
						} else {
							while (container != null && !(container instanceof AadlPackage)
									&& !(container instanceof PropertySet)) {
								container = container.eContainer();
								if (container.equals(nextImportedUnit)) {
									continue ImportedUnitsLoop;
								}
							}
						}
					}
				}

				AadlPackage aadlPackage = EcoreUtil2.getContainerOfType(packageSection, AadlPackage.class);
				if (packageSection instanceof PublicPackageSection || aadlPackage.getPublicSection() == null) {
					TreeIterator<EObject> packageContents = aadlPackage.eAllContents();
					while (packageContents.hasNext()) {
						EObject nextObject = packageContents.next();
						PackageSection packSec = EcoreUtil2.getContainerOfType(nextObject, PackageSection.class);
						if (packSec != null) {
							continue;
						}
						EList<EObject> crossReferences = nextObject.eCrossReferences();
						for (EObject crossReference : crossReferences) {
							EObject container = crossReference.eContainer();
							if (nextImportedUnit.equals(container)) {
								continue ImportedUnitsLoop;
							} else {
								while (container != null && !(container instanceof AadlPackage)
										&& !(container instanceof PropertySet)) {
									container = container.eContainer();
									if (container.equals(nextImportedUnit)) {
										continue ImportedUnitsLoop;
									}
								}
							}
						}
					}
				}

				StringBuilder errMsg = new StringBuilder(nextImportedUnit.getName());
				errMsg.append(" in 'with' clause of ");
				String publicOrPrivate = "public";
				if (packageSection instanceof PrivatePackageSection) {
					publicOrPrivate = "private";
				}
				errMsg.append(publicOrPrivate);
				errMsg.append(" package section is not used.");
				String importedUnitURI = EcoreUtil.getURI(nextImportedUnit).toString();
				warning(errMsg.toString(), packageSection, Aadl2Package.eINSTANCE.getPackageSection_ImportedUnit(),
						importedUnits.indexOf(nextImportedUnit), WITH_NOT_USED, nextImportedUnit.getName(),
						importedUnitURI);
			}
		}
	}

	public void checkWithsAreUsed(PropertySet propertySet) {
		List<ModelUnit> importedUnits = propertySet.getImportedUnits();
		ImportedUnitsLoop: for (ModelUnit nextImportedUnit : importedUnits) {
			if (nextImportedUnit.equals(propertySet)) {
				StringBuilder errMsg = new StringBuilder(nextImportedUnit.getName());
				errMsg.append(" in 'with' clause refers to the containing package and is not needed.");
				String importedUnitURI = EcoreUtil.getURI(nextImportedUnit).toString();
				warning(errMsg.toString(), propertySet, Aadl2Package.eINSTANCE.getPropertySet_ImportedUnit(),
						importedUnits.indexOf(nextImportedUnit), WITH_NOT_USED, nextImportedUnit.getName(),
						importedUnitURI);
				continue ImportedUnitsLoop;
			}
			if (AadlUtil.isPredeclaredPropertySet(nextImportedUnit.getName())) {
				StringBuilder errMsg = new StringBuilder(nextImportedUnit.getName());
				errMsg.append(" in 'with' clause is a predeclared property set and is not needed.");
				String importedUnitURI = EcoreUtil.getURI(nextImportedUnit).toString();
				warning(errMsg.toString(), propertySet, Aadl2Package.eINSTANCE.getPropertySet_ImportedUnit(),
						importedUnits.indexOf(nextImportedUnit), WITH_NOT_USED, nextImportedUnit.getName(),
						importedUnitURI);
				continue ImportedUnitsLoop;

			}

			TreeIterator<EObject> allContents = propertySet.eAllContents();
			while (allContents.hasNext()) {
				EObject nextObject = allContents.next();
				EList<EObject> crossReferences = nextObject.eCrossReferences();
				for (EObject crossReference : crossReferences) {
					EObject container = crossReference.eContainer();
					if (nextImportedUnit.equals(container)) {
						continue ImportedUnitsLoop;
					} else {
						while (container != null && !(container instanceof AadlPackage)
								&& !(container instanceof PropertySet)) {
							container = container.eContainer();
							if (container.equals(nextImportedUnit)) {
								continue ImportedUnitsLoop;
							}
						}
					}
				}
			}
			StringBuilder errMsg = new StringBuilder(nextImportedUnit.getName());
			errMsg.append(" in 'with' clause is not used.");
			String importedUnitURI = EcoreUtil.getURI(nextImportedUnit).toString();
			warning(errMsg.toString(), propertySet, Aadl2Package.eINSTANCE.getPropertySet_ImportedUnit(),
					importedUnits.indexOf(nextImportedUnit), WITH_NOT_USED, nextImportedUnit.getName(),
					importedUnitURI);
		}
	}

	public void checkForCyclicDeclarations(Subcomponent subcomponent) {
		ComponentClassifier subcomponentType = subcomponent.getClassifier();
		Classifier containingClassifier = subcomponent.getContainingClassifier();
		if (subcomponentType == null) {
			return;
		}
		if (subcomponentType.equals(containingClassifier)) {
			error(subcomponent,
					"The type of subcomponent '" + subcomponent.getName() + "' cannot be the object that contains it");
		} else {
			if (isSubcomponentCircularDependency(subcomponentType, containingClassifier, new ArrayList<Classifier>())) {
				error(subcomponent, "Invalid circular dependency. Subcomponent '" + subcomponent.getName()
						+ "' directly or indirectly contains '" + containingClassifier.getName() + "'.");
			}
		}
	}

	private boolean isSubcomponentCircularDependency(ComponentClassifier subcomponentType,
			Classifier startContainingClassifier, List<Classifier> previouslyVisitedClassifiers) {
		if (subcomponentType == null) {
			return false;
		}
		if (previouslyVisitedClassifiers.contains(subcomponentType)) {
			return true;
		} else {
			previouslyVisitedClassifiers.add(subcomponentType);
		}
		if (subcomponentType instanceof ComponentImplementation) {
			List<Subcomponent> otherSubComponents = ((ComponentImplementation) subcomponentType).getAllSubcomponents();
			for (Subcomponent otherSubc : otherSubComponents) {
				if (otherSubc.getClassifier() != null) {
					if (otherSubc.getClassifier().equals(startContainingClassifier)) {
						return true;
					} else {
						if (isSubcomponentCircularDependency(otherSubc.getClassifier(), startContainingClassifier,
								previouslyVisitedClassifiers)) {
							return true;
						}
					}
				}
			}
		}
		previouslyVisitedClassifiers.remove(subcomponentType);
		return false;
	}

	public void checkForDuplicatePropertyAssociations(NamedElement ne) {
		class Holder {
			String appliesTo;
			Property property;
			PropertyAssociation propertyAssociation;

			Holder(String appliesTo, Property property, PropertyAssociation propertyAssociation) {
				this.appliesTo = appliesTo;
				this.property = property;
				this.propertyAssociation = propertyAssociation;
			}

			@Override
			public boolean equals(Object arg0) {
				return (null != arg0 && arg0 instanceof Holder && appliesTo.equals(((Holder) arg0).appliesTo)
						&& property.equals(((Holder) arg0).property));
			}
		}

		List<PropertyAssociation> propertyAssociations = ne.getOwnedPropertyAssociations();
		List<Holder> holderList = new ArrayList<Holder>();
		for (PropertyAssociation propertyAssoc : propertyAssociations) {
			Property property = propertyAssoc.getProperty();
			List<ContainedNamedElement> appliesTos = propertyAssoc.getAppliesTos();
			if (null == appliesTos || appliesTos.isEmpty()) {
				String appliesToString = ne.getName();
				holderList.add(new Holder(appliesToString, property, propertyAssoc));
			} else {
				for (ContainedNamedElement appliesTo : appliesTos) {
					String appliesToString = buildAppliesToString(appliesTo);
					holderList.add(new Holder(appliesToString, property, propertyAssoc));
				}
			}
		}

		Holder[] holders = new Holder[holderList.size()];
		holderList.toArray(holders);
		List<Integer> arrayNumbers = new ArrayList<Integer>();

		for (int i = 0; i < holders.length; i++) {
			for (int j = 0; j < holders.length; j++) {
				if (holders[i].appliesTo != null && holders[i].appliesTo.length() > 0) {
					if (i != j && holders[i].equals(holders[j]) && !arrayNumbers.contains(i)) {
						arrayNumbers.add(i);
					}
				}
			}
		}

		for (Integer arrayNumber : arrayNumbers) {
			StringBuilder errorMessage = new StringBuilder();
			errorMessage.append("Duplicate value assignments to property ");
			errorMessage.append(holders[arrayNumber].property.getName());
			error(holders[arrayNumber].propertyAssociation, errorMessage.toString());
		}
	}

	private String buildAppliesToString(ContainedNamedElement cne) {
		List<ContainmentPathElement> cpes = cne.getContainmentPathElements();
		StringBuilder result = new StringBuilder();
		int i = 0;
		for (ContainmentPathElement cpe : cpes) {
			if (!cpe.getArrayRanges().isEmpty()) {
				return "";
			}
			if (i > 0) {
				result.append(".");
			}
			result.append(cpe.getNamedElement().getName());
			i++;
		}
		return result.toString();
	}

	public void checkModalElementMissingModeValues(ModalElement modalElement) {
		if (modalElement instanceof Subcomponent) {
			return;
		}
		List<Mode> modalElementInModes = modalElement.getInModes();
		List<Mode> elementAllInModes = modalElement.getAllInModes();
		List<Mode> allContainerModes = new ArrayList<Mode>();

		if (null == elementAllInModes || elementAllInModes.isEmpty()) {
			Classifier containingClassifier = modalElement.getContainingClassifier();
			if (containingClassifier instanceof ComponentImplementation) {
				ComponentImplementation componentImpl = (ComponentImplementation) containingClassifier;
				allContainerModes = componentImpl.getAllModes();
			} else if (containingClassifier instanceof ComponentType) {
				ComponentType componentType = (ComponentType) containingClassifier;
				allContainerModes = componentType.getAllModes();
			}
		}

		List<PropertyAssociation> ownedPropertyAssociations = modalElement.getOwnedPropertyAssociations();
		for (PropertyAssociation ownedPropertyAssociation : ownedPropertyAssociations) {
			Property property = ownedPropertyAssociation.getProperty();
			boolean defaultValue = false;
			List<ModalPropertyValue> modalPropertyValues = ownedPropertyAssociation.getOwnedValues();
			List<Mode> modesForAllModalPropertyValues = buildModeListForAllModalPropertyValues(modalPropertyValues,
					modalElementInModes);
			if (null != modalPropertyValues && !modalPropertyValues.isEmpty()) {
				ModalPropertyValue lastMpv = modalPropertyValues.get(modalPropertyValues.size() - 1);
				if (lastMpv.getInModes() == null || lastMpv.getInModes().isEmpty()) {
					defaultValue = true;
				}
			}

			for (ModalPropertyValue modalPropertyValue : modalPropertyValues) {
				List<Mode> inModes = modalPropertyValue.getInModes();
				boolean modeNotDefined = false;
				for (Mode inMode : inModes) {
					if (null != modalElementInModes && !modalElementInModes.isEmpty()) {
						if (!modalElementInModes.contains(inMode)) {
							String inModeURI = EcoreUtil.getURI(inMode).toString();
							String containerURI = EcoreUtil.getURI(modalElement).toString();

							List<Mode> proposedReplacementModes = new ArrayList<Mode>();
							for (Mode meInMode : modalElementInModes) {
								if (!modesForAllModalPropertyValues.contains(meInMode)) {
									proposedReplacementModes.add(meInMode);
								}
							}
							String[] issueData = new String[(proposedReplacementModes.size() * 2) + 5];
							issueData[0] = inMode.getName();
							issueData[1] = inModeURI;
							issueData[2] = modalElement.getName();
							issueData[3] = containerURI;
							issueData[4] = EcoreUtil.getURI(modalPropertyValue).toString();
							int i = 5;
							for (Mode propsedReplacementMode : proposedReplacementModes) {
								issueData[i++] = propsedReplacementMode.getName();
								issueData[i++] = EcoreUtil.getURI(propsedReplacementMode).toString();
							}

							error(inMode.getName()
									+ " is not a valid mode because it is not in the modes defined for container "
									+ modalElement.getName(), modalPropertyValue, null, MODE_NOT_DEFINED_IN_CONTAINER,
									issueData);

							modeNotDefined = true;
							continue;
						}
					}
				}

				if (null == allContainerModes || allContainerModes.isEmpty()) {
					if (!modeNotDefined) {
						for (Mode modalElementInMode : modalElementInModes) {
							if (!modesForAllModalPropertyValues.contains(modalElementInMode) && !defaultValue) {
								warning(ownedPropertyAssociation,
										"Value not set for mode " + modalElementInMode.getName() + " for property "
												+ property.getQualifiedName());
							}
						}
					}
				} else {
					for (Mode containerMode : allContainerModes) {
						if (!modesForAllModalPropertyValues.contains(containerMode) && !defaultValue) {
							warning(ownedPropertyAssociation, "Value not set for mode " + containerMode.getName()
									+ " for property " + property.getQualifiedName());
						}
					}
				}
			}
		}
	}

	public List<Mode> buildModeListForAllModalPropertyValues(List<ModalPropertyValue> modalPropertyValues,
			List<Mode> modalElementInModes) {
		List<Mode> resultModes = new ArrayList<Mode>();

		if (null != modalPropertyValues && !modalPropertyValues.isEmpty()) {
			ModalPropertyValue lastMpv = modalPropertyValues.get(modalPropertyValues.size() - 1);
			if (lastMpv.getInModes() == null || lastMpv.getInModes().isEmpty()) {
				resultModes.addAll(modalElementInModes);
			} else {
				for (ModalPropertyValue modalPropertyValue : modalPropertyValues) {
					List<Mode> inModes = modalPropertyValue.getInModes();
					for (Mode inMode : inModes) {
						if (!resultModes.contains(inMode)) {
							resultModes.add(inMode);
						}
					}
				}
			}
		}
		return resultModes;
	}

	public void checkReferencesToInternalFeatures(Connection connection) {
		List<ConnectedElement> connectedElements = new ArrayList<ConnectedElement>();
		connectedElements.add(connection.getSource());
		connectedElements.add(connection.getDestination());

		for (ConnectedElement connectedElement : connectedElements) {
			ConnectionEnd connectionEnd = connectedElement.getConnectionEnd();
			ICompositeNode conElemNNode = NodeModelUtils.getNode(connectedElement);
			INode lln = getLastLeaf(conElemNNode).getPreviousSibling();

			String prefix = "";
			while (!prefix.equalsIgnoreCase("self") && !prefix.equalsIgnoreCase("processor")) {
				while (lln instanceof HiddenLeafNode) {
					lln = lln.getPreviousSibling();
				}
				if (lln == null) {
					return;
				} else {
					prefix = (null == lln.getText() ? "" : lln.getText());
					lln = lln.getPreviousSibling();
				}
			}
			String offSet = "" + (lln.getOffset() + 1);
			String alternateConnectionEndType = "";

			if (prefix.equalsIgnoreCase("self")) {
				if (!(connectionEnd instanceof InternalFeature)) {
					if (connectionEnd instanceof ProcessorFeature) {
						alternateConnectionEndType = "processor";
					}
					error("Only internal features may follow the keyword 'self'", connectedElement, null,
							SELF_NOT_ALLOWED, offSet, alternateConnectionEndType);

				}
			} else if (prefix.equalsIgnoreCase("processor")) {
				if (!(connectionEnd instanceof ProcessorFeature)) {
					if (connectionEnd instanceof InternalFeature) {
						alternateConnectionEndType = "self";
					}
					error("Only processor features may follow the keyword 'processor'", connectedElement, null,
							PROCESSOR_NOT_ALLOWED, offSet, alternateConnectionEndType);
				}
			}
		}
	}

	/**
	 * check ID at after 'end'
	 */
	public void checkEndId(Classifier cl) {
		ICompositeNode n = NodeModelUtils.getNode(cl);
		INode lln = getLastLeaf(n).getPreviousSibling();
		while (lln instanceof HiddenLeafNode) {
			lln = lln.getPreviousSibling();
		}
		if (lln == null) {
			return;
		}
		String ss = lln.getText().replaceAll("--.*(\\r|\\n)", "").replaceAll(" ", "").replaceAll("\t", "")
				.replaceAll("\n", "").replaceAll("\r", "");
		if (!ss.equalsIgnoreCase(cl.getName())) {
			int endingIdentifierOffset = lln.getTotalOffset() + lln.getText().indexOf(ss);
			warning("Ending '" + ss + "' does not match defining identifier '" + cl.getName() + "'", cl,
					Aadl2Package.eINSTANCE.getNamedElement_Name(), MISMATCHED_BEGINNING_AND_ENDING_IDENTIFIERS,
					cl.getName(), ss, Integer.toString(endingIdentifierOffset));
			// XXX TODO
			// IXtextDocument xtextDocument = context.getXtextDocument();
			// String firstLetter = xtextDocument.get(issue.getOffset(), 1);
			// xtextDocument.replace(issue.getOffset(), 1,
			// Strings.toFirstUpper(firstLetter));
		}
	}

	public void checkEndId(ModelUnit mu) {
		ICompositeNode n = NodeModelUtils.getNode(mu);
		INode lln = getPreviousNode(getLastLeaf(n));
		String ss = lln.getText().replaceAll(" ", "").replaceAll("\t", "").replaceAll("\n", "").replaceAll("\r", "");
		// lln = getPreviousNode(lln);
		// while (lln.getText().equalsIgnoreCase("::")) {
		// lln = getPreviousNode(lln);
		// ss = lln.getText() + "::" + ss;
		// }
		// ss = ss.replaceAll(" ", "");
		if (!ss.equalsIgnoreCase(mu.getName())) {
			int endingIdentifierOffset = lln.getTotalOffset() + lln.getText().indexOf(ss);
			warning("Ending '" + ss + "' does not match defining identifier '" + mu.getName() + "'", mu,
					Aadl2Package.eINSTANCE.getNamedElement_Name(), MISMATCHED_BEGINNING_AND_ENDING_IDENTIFIERS,
					mu.getName(), ss, Integer.toString(endingIdentifierOffset));
		}
	}

	/**
	 * Checks the second part of legality rule 3 in section 10.2 (Flow
	 * Implementations) on page 188. "The out_flow feature of a flow
	 * implementation must be identical to the out_flow feature of the
	 * corresponding flow specification."
	 */
	private void checkOutFeatureIdentifier(FlowImplementation flow) {
		if (Aadl2Util.isNull(flow.getSpecification()) || Aadl2Util.isNull(flow.getSpecification().getAllOutEnd())) {
			return;
		}

		ICompositeNode n = NodeModelUtils.getNode(flow);

		INode lln = getLastLeaf(n);
		String outFeatureName = lln.getText().replaceAll(" ", "").replaceAll("\t", "").replaceAll("\r", "")
				.replaceAll("\n", "");
		int featureOffset = lln.getOffset();
		int contextOffset = -99;

		lln = getPreviousNode(lln);
		String outContextName = null;
		if (lln != null && lln.getText().replaceAll(" ", "").replaceAll("\t", "").replaceAll("\r", "")
				.replaceAll("\n", "").equals(".")) {
			lln = getPreviousNode(lln);
			outContextName = lln.getText().replaceAll(" ", "").replaceAll("\t", "").replaceAll("\r", "")
					.replaceAll("\n", "");
			contextOffset = lln.getOffset();
		}
		FlowSpecification spec = flow.getSpecification();
		if (Aadl2Util.isNull(spec)) {
			return;
		}
		FlowEnd outEnd = spec.getAllOutEnd();
		if (Aadl2Util.isNull(outEnd)) {
			return;
		}
		Context specContext = outEnd.getContext();
		Feature specFeature = outEnd.getFeature();
		if (Aadl2Util.isNull(specFeature) || (specContext != null && Aadl2Util.isUnresolved(specContext))) {
			// the feature is unresolved or null; or the context is unresolved.
			// the context could be null but should not be unresolved for the
			// checking to occur
			return;
		}
		// if the feature names don't match
		if ((!outFeatureName.equalsIgnoreCase(specFeature.getName()) ||
		// if the spec has a context, but the impl doesn't: flow spec
		// picks an element from a FG
				(outContextName == null && !Aadl2Util.isNull(specContext)) ||
				// if the impl has a context (FG), but the spec doesn't (feature
				// is FG)
				(outContextName != null && Aadl2Util.isNull(specContext)) ||
				// if the context names don't match
				(outContextName != null && !outContextName.equalsIgnoreCase(specContext.getName())))) {
			String outImplName = (outContextName != null ? outContextName + '.' : "") + outFeatureName;
			String specName = (specContext != null ? specContext.getName() + '.' : "") + specFeature.getName();
			error('\'' + outImplName + "' does not match the out flow feature identifier '" + specName
					+ "' in the flow specification.", flow, null, OUT_FLOW_FEATURE_IDENTIFIER_NOT_SPEC, outImplName,
					specName, "" + featureOffset, "" + contextOffset);
		}
	}

	/**
	 * Checks the first part of legality rule 3 in section 10.2 (Flow
	 * Implementations) on page 188. "The in_flow feature of a flow
	 * implementation must be identical to the in_flow feature of the
	 * corresponding flow specification."
	 */
	private void checkInFeatureIdentifier(FlowImplementation flow) {
		ICompositeNode n = NodeModelUtils.getNode(flow);
		INode lln = n.getFirstChild();
		while (lln instanceof HiddenLeafNode) {
			lln = lln.getNextSibling();
		}
		lln = getNextNode(getNextNode(getNextNode(getNextNode(lln))));
		String inFeatureName = lln.getText().replaceAll(" ", "").replaceAll("\t", "").replaceAll("\r", "")
				.replaceAll("\n", "");
		int featureOffset = lln.getOffset();
		String inContextName = null;
		int idx = inFeatureName.indexOf(".");
		if (idx >= 0) {
			inContextName = inFeatureName.substring(0, idx);
			inFeatureName = inFeatureName.substring(idx + 1, inFeatureName.length());
		}
		FlowSpecification spec = flow.getSpecification();
		if (Aadl2Util.isNull(spec)) {
			return;
		}
		FlowEnd inEnd = spec.getAllInEnd();
		if (Aadl2Util.isNull(inEnd)) {
			return;
		}
		Context specContext = inEnd.getContext();
		Feature specFeature = inEnd.getFeature();
		if (Aadl2Util.isNull(specFeature) || (specContext != null && Aadl2Util.isUnresolved(specContext))) {
			// the feature is unresolved or null; or the context is unresolved.
			// the context could be null but should not be unresolved for the
			// checking to occur
			return;
		}
		// if the feature names don't match
		if ((!inFeatureName.equalsIgnoreCase(specFeature.getName()) ||
		// if the spec has a context, but the impl doesn't
				(inContextName == null && !Aadl2Util.isNull(specContext)) ||
				// if the impl has a context, but the spec doesn't
				(inContextName != null && Aadl2Util.isNull(specContext)) ||
				// if the context names don't match
				(inContextName != null && specContext != null
						&& !inContextName.equalsIgnoreCase(specContext.getName())))) {
			String inImplName = (inContextName != null ? inContextName + '.' : "") + inFeatureName;
			String specName = (specContext != null ? specContext.getName() + '.' : "") + specFeature.getName();
			error('\'' + inImplName + "' does not match the in flow feature identifier '" + specName
					+ "' in the flow specification.", flow, null, IN_FLOW_FEATURE_IDENTIFIER_NOT_SPEC, inImplName,
					specName, "" + featureOffset);// , "" + contextOffset);
		}
	}

	private void checkConsistentFlowKind(FlowImplementation flowimpl) {
		FlowKind implkind = flowimpl.getKind();
		FlowSpecification spec = flowimpl.getSpecification();
		if (spec != null && !spec.eIsProxy()) {
			FlowKind speckind = spec.getKind();
			if (implkind != speckind) {
				String offSet = "" + findKeywordOffset(flowimpl, implkind.toString());
				error("Flow implementation " + spec.getName() + " must be a flow " + speckind.getName()
						+ " (same as its flow spec)", flowimpl, null, INCONSISTENT_FLOW_KIND, implkind.getName(),
						speckind.getName(), offSet);

			}
		}
	}

	/**
	 * Checks legality rule 1 in section 10.2 (Flow Implementations) on page
	 * 188. "The source of a connection named in a flow implementation
	 * declaration must be the same as the in_flow feature of the flow
	 * implementation, or as the out flow feature of the directly preceding
	 * subcomponent flow specification, if present."
	 *
	 * Checks legality rule 2 in section 10.2 (Flow Implementations) on page
	 * 188. "The destination of a connection named in a flow implementation
	 * declaration must be the same as the out flow feature of the flow
	 * implementation, or as the in_flow feature of the directly succeeding
	 * subcomponent flow specification, if present.
	 */
	private void checkFlowConnectionOrder(FlowImplementation flow) {
		if (Aadl2Util.isNull(flow.getSpecification())) {
			return;
		}
		EList<FlowSegment> segs = flow.getOwnedFlowSegments();
		boolean connNext = true;
		if (flow.getKind().equals(FlowKind.SOURCE)) {
			// the first element in a flow source should be a subcomponent/flow
			// spec
			connNext = false;
		}
		for (FlowSegment flowSegment : segs) {
			FlowElement fe = flowSegment.getFlowElement();
			if (connNext) {
				// expecting a connection
				connNext = !connNext;
				if (!fe.eIsProxy() && !(fe instanceof Connection)) {
					StringBuilder errorMessage = new StringBuilder("Expected Connection, found ");
					errorMessage.append(getEClassDisplayName(fe.eClass()));
					errorMessage.append(" '");
					errorMessage.append(fe.getName());
					errorMessage.append("'");
					error(flowSegment, errorMessage.toString());
				}
			} else {
				// expecting a component and flow spec
				connNext = !connNext;
				if (!fe.eIsProxy() && (flowSegment.getContext() == null || !flowSegment.getContext().eIsProxy())
						&& !((flowSegment.getContext() == null
								&& (fe instanceof DataAccess || fe instanceof Subcomponent))
								|| (flowSegment.getContext() instanceof Subcomponent
										&& fe instanceof FlowSpecification))) {
					StringBuilder errorMessage = new StringBuilder(
							"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found ");
					if (flowSegment.getContext() != null) {
						errorMessage.append(getEClassDisplayName(flowSegment.getContext().eClass()));
						errorMessage.append(".");
					}
					errorMessage.append(getEClassDisplayName(fe.eClass()));
					errorMessage.append(" '");
					if (flowSegment.getContext() != null) {
						errorMessage.append(flowSegment.getContext().getName());
						errorMessage.append(".");
					}
					errorMessage.append(fe.getName());
					errorMessage.append("'");
					error(flowSegment, errorMessage.toString());
				}
			}
		}
	}

	/**
	 * Checks legality rule 1 in section 10.2 (Flow Implementations) on page
	 * 188. "The source of a connection named in a flow implementation
	 * declaration must be the same as the in_flow feature of the flow
	 * implementation, or as the out flow feature of the directly preceding
	 * subcomponent flow specification, if present."
	 *
	 * Checks legality rule 2 in section 10.2 (Flow Implementations) on page
	 * 188. "The destination of a connection named in a flow implementation
	 * declaration must be the same as the out flow feature of the flow
	 * implementation, or as the in_flow feature of the directly succeeding
	 * subcomponent flow specification, if present.
	 */
	private void checkFlowConnectionEnds(FlowImplementation flow) {
		if (Aadl2Util.isNull(flow.getSpecification())) {
			return;
		}
		for (int i = 0; i < flow.getOwnedFlowSegments().size(); i++) {
			ConnectionEnd ce = null;
			Context cxt = null;
			if (flow.getOwnedFlowSegments().get(i).getFlowElement() instanceof Connection) {
				Connection connection = (Connection) flow.getOwnedFlowSegments().get(i).getFlowElement();
				ce = connection.getAllSource();
				cxt = connection.getAllSourceContext();
				boolean didReverse = false;
				if (i == 0) {
					FlowEnd inEnd = flow.getSpecification().getAllInEnd();
					if (Aadl2Util.isNull(inEnd)) {
						return;
					}
					if (!isMatchingConnectionPoint(inEnd.getFeature(), inEnd.getContext(), ce, cxt)) {
						boolean noMatch = false;
						if (connection.isAllBidirectional()) {
							didReverse = true;
							ce = connection.getAllDestination();
							cxt = connection.getAllDestinationContext();
							if (!isMatchingConnectionPoint(inEnd.getFeature(), inEnd.getContext(), ce, cxt)) {
								noMatch = true;
							}
						} else {
							noMatch = true;
						}
						if (noMatch) {
							error(flow.getOwnedFlowSegments().get(i),
									"The source of connection '" + connection.getName()
											+ "' does not match the in flow feature '"
											+ (inEnd.getContext() != null ? inEnd.getContext().getName() + '.' : "")
											+ inEnd.getFeature().getName() + '\'');
						}
					}
				} else {
					FlowElement prevFlowElement = flow.getOwnedFlowSegments().get(i - 1).getFlowElement();
					if (prevFlowElement instanceof FlowSpecification) {
						FlowSpecification previousFlowSegment = (FlowSpecification) prevFlowElement;
						FlowEnd outEnd = previousFlowSegment.getAllOutEnd();
						if (Aadl2Util.isNull(outEnd)) {
							return;
						}
						if (!isMatchingConnectionPoint(outEnd.getFeature(), outEnd.getContext(), ce, cxt)) {
							boolean noMatch = false;
							if (connection.isAllBidirectional()) {
								didReverse = true;
								ce = connection.getAllDestination();
								cxt = connection.getAllDestinationContext();
								if (!isMatchingConnectionPoint(outEnd.getFeature(), outEnd.getContext(), ce, cxt)) {
									noMatch = true;
								}
							} else {
								noMatch = true;
							}
							if (noMatch) {
								error(flow.getOwnedFlowSegments().get(i),
										"The source of connection '" + connection.getName()
												+ "' does not match the out flow feature of the preceding subcomponent flow specification '"
												+ flow.getOwnedFlowSegments().get(i - 1).getContext().getName() + '.'
												+ previousFlowSegment.getName() + '\'');
							}
						}
					} else if (prevFlowElement instanceof Subcomponent) {
						if (prevFlowElement != cxt) {
							error(flow.getOwnedFlowSegments().get(i),
									"The source of connection '" + connection.getName()
											+ "' does not match the preceding subcomponent '"
											+ ((Subcomponent) prevFlowElement).getName() + '\'');
						}
					}
				}
				if (didReverse) {
					ce = connection.getAllSource();
					cxt = connection.getAllSourceContext();
				} else {
					ce = connection.getAllDestination();
					cxt = connection.getAllDestinationContext();
				}
				if (i == flow.getOwnedFlowSegments().size() - 1) {
					FlowEnd outEnd = flow.getSpecification().getAllOutEnd();
					if (Aadl2Util.isNull(outEnd)) {
						return;
					}
					if (ce instanceof Feature) {
						if (!isMatchingConnectionPoint(outEnd.getFeature(), outEnd.getContext(), ce, cxt)) {
							error(flow.getOwnedFlowSegments().get(i),
									"The destination of connection '" + connection.getName()
											+ "' does not match the out flow feature '"
											+ (outEnd.getContext() != null ? outEnd.getContext().getName() + '.' : "")
											+ outEnd.getFeature().getName() + '\'');
						}
					}
				} else {
					FlowElement felem = flow.getOwnedFlowSegments().get(i + 1).getFlowElement();
					if (felem instanceof FlowSpecification) {
						FlowSpecification nextFlowSegment = (FlowSpecification) felem;
						FlowEnd inEnd = nextFlowSegment.getAllInEnd();
						if (Aadl2Util.isNull(inEnd)) {
							return;
						}
						if (ce instanceof Feature) {
							if (!isMatchingConnectionPoint(inEnd.getFeature(), inEnd.getContext(), ce, cxt)) {
								error(flow.getOwnedFlowSegments().get(i),
										"The destination of connection '" + connection.getName()
												+ "' does not match the in flow feature of the succeeding subcomponent flow specification '"
												+ flow.getOwnedFlowSegments().get(i + 1).getContext().getName() + '.'
												+ nextFlowSegment.getName() + '\'');
							}
						}
					} else if (felem instanceof Subcomponent) {
						if (felem != cxt) {
							error(flow.getOwnedFlowSegments().get(i),
									"The destination component '" + cxt.getName() + "' of connection '"
											+ connection.getName() + "' does not match the succeeding subcomponent  '"
											+ ((Subcomponent) felem).getName() + '\'');
						}

					}
				}
			}
		}
	}

	/**
	 * If a flow segment is a subcomponent, preceding and following connections
	 * may not continue inside that subcomponent (issue #345)
	 */
	private void checkSubcomponentFlows(EndToEndFlow flow) {
		for (int i = 0; i < flow.getOwnedEndToEndFlowSegments().size(); i++) {
			EndToEndFlowSegment segment = flow.getOwnedEndToEndFlowSegments().get(i);
			if (segment.getFlowElement() instanceof Subcomponent) {
				Subcomponent sub = (Subcomponent) segment.getFlowElement();
				List<Connection> conns = new ArrayList<Connection>(2);
				if (i > 0) {
					Element elem = flow.getOwnedEndToEndFlowSegments().get(i - 1).getFlowElement();
					if (elem instanceof Connection) {
						conns.add((Connection) elem);
					}
				}
				if (i < flow.getOwnedEndToEndFlowSegments().size() - 1) {
					Element elem = flow.getOwnedEndToEndFlowSegments().get(i + 1).getFlowElement();
					if (elem instanceof Connection) {
						conns.add((Connection) elem);
					}
				}
				checkSubcomponentFlowHelper(segment, sub, conns);
			}
		}
	}

	/**
	 * If a flow segment is a subcomponent, preceding and following connections
	 * may not continue inside that subcomponent (issue #345)
	 */
	private void checkSubcomponentFlows(FlowImplementation flow) {
		for (int i = 0; i < flow.getOwnedFlowSegments().size(); i++) {
			FlowSegment segment = flow.getOwnedFlowSegments().get(i);
			if (segment.getFlowElement() instanceof Subcomponent) {
				Subcomponent sub = (Subcomponent) segment.getFlowElement();
				List<Connection> conns = new ArrayList<Connection>(2);
				if (i > 0) {
					Element elem = flow.getOwnedFlowSegments().get(i - 1).getFlowElement();
					if (elem instanceof Connection) {
						conns.add((Connection) elem);
					}
				}
				if (i < flow.getOwnedFlowSegments().size() - 1) {
					Element elem = flow.getOwnedFlowSegments().get(i + 1).getFlowElement();
					if (elem instanceof Connection) {
						conns.add((Connection) elem);
					}
				}
				checkSubcomponentFlowHelper(segment, sub, conns);
			}
		}
	}

	/**
	 * Check if one of the connections continues inside the subcomponent
	 *
	 * @param segment
	 *            - attach error to this model element
	 * @param sub
	 *            - subcomponent at which connections should end
	 * @param conns
	 *            - connection(s) immediately before/after the subcomponent
	 */
	private void checkSubcomponentFlowHelper(Element segment, Subcomponent sub, List<Connection> conns) {
		for (Connection conn : conns) {
			ConnectionEnd ce = null;
			if (sub == conn.getAllSourceContext()) {
				ce = conn.getAllSource();
			} else if (sub == conn.getAllDestinationContext()) {
				ce = conn.getAllDestination();
			}
			if (ce != null) {
				for (Connection innerConn : sub.getComponentImplementation().getAllConnections()) {
					if ((innerConn.getAllSourceContext() == null && innerConn.getAllSource() == ce)
							|| (innerConn.getAllDestinationContext() == null && innerConn.getAllDestination() == ce)) {
						// connection continues inside subcomponent
						error(segment, "Connection '" + conn.getName() + "' continues inside subcomponent '"
								+ sub.getName() + "'");
						break;
					}
				}
			}
		}
	}

	/**
	 * see if the endpoints of the connection and the flow spec point to the
	 * same thing. They may be refinements of the other. They may be features of
	 * feature groups on one or the other side.
	 *
	 * @param fsFeature
	 * @param fsContext
	 * @param connEnd
	 * @param connContext
	 * @return
	 */
	private boolean isMatchingConnectionPoint(Feature fsFeature, Context fsContext, ConnectionEnd connEnd,
			Context connContext) {
		if (!(connEnd instanceof Feature)) {
			return true;
		}
		Feature connFeature = (Feature) connEnd;
		return AadlUtil.isSameOrRefines(fsFeature, connFeature) || AadlUtil.isSameOrRefines(connFeature, fsFeature)
		// flow spec points to feature within fg, connection points to fg
				|| (fsContext instanceof FeatureGroup && connFeature instanceof FeatureGroup
						&& (AadlUtil.isSameOrRefines((FeatureGroup) connFeature, (FeatureGroup) fsContext)
								|| AadlUtil.isSameOrRefines((FeatureGroup) fsContext, (FeatureGroup) connFeature)))
				// both contexts are feature groups. Let's check
				// for features lining up
				|| (fsContext instanceof FeatureGroup && connContext instanceof FeatureGroup
						&& (AadlUtil.isSameOrRefines(fsFeature, connFeature)
								|| AadlUtil.isSameOrRefines(connFeature, fsFeature)))
				// the flow spec has a FG as context and a
				// feature within. The connection can only point
				// to FG.
				|| (fsFeature instanceof FeatureGroup && connContext instanceof FeatureGroup
						&& (AadlUtil.isSameOrRefines((FeatureGroup) connContext, fsFeature)
								|| AadlUtil.isSameOrRefines(fsFeature, (FeatureGroup) connContext)));
	}

	/**
	 * Checks legality rule 5 in section 10.2 (Flow Implementations) on page
	 * 189. "In case of a mode-specific flow implementation, the connections and
	 * the subcomponents named in the flow implementation must be declared at
	 * least for the modes listed in the in modes statement of the flow
	 * implementation."
	 */
	private void checkFlowSegmentModes(FlowImplementation flow) {
		if (flow.getContainingComponentImpl().getAllModes().isEmpty()) {
			return;
		}
		EList<Mode> flowModes = flow.getAllInModes();
		if (flowModes.isEmpty()) {
			flowModes = flow.getContainingComponentImpl().getAllModes();
		}
		for (FlowSegment flowSegment : flow.getOwnedFlowSegments()) {
			if (flowSegment.getContext() == null && flowSegment.getFlowElement() instanceof Subcomponent) {
				Subcomponent subcomponent = (Subcomponent) flowSegment.getFlowElement();
				EList<Mode> subcomponentModes = subcomponent.getAllInModes();
				if (subcomponentModes.isEmpty()) {
					subcomponentModes = subcomponent.getContainingComponentImpl().getAllModes();
				}
				for (Mode flowMode : flowModes) {
					if (!subcomponentModes.contains(flowMode)) {
						String flowModeName = flowMode.getName();
						String flowModeURI = EcoreUtil.getURI(flowMode).toString();
						String subcomponentName = subcomponent.getName();
						String subcomponentURI = EcoreUtil.getURI(subcomponent).toString();
						error("Subcomponent '" + subcomponentName + "' does not exist in mode '" + flowModeName + "'",
								flowSegment, null, SUBCOMPONENT_NOT_IN_FLOW_MODE, flowModeName, flowModeURI,
								subcomponentName, subcomponentURI);
					}
				}

			} else if (flowSegment.getContext() instanceof Subcomponent) {
				Subcomponent subcomponent = (Subcomponent) flowSegment.getContext();
				EList<Mode> subcomponentModes = subcomponent.getAllInModes();
				if (subcomponentModes.isEmpty()) {
					subcomponentModes = subcomponent.getContainingComponentImpl().getAllModes();
				}
				for (Mode flowMode : flowModes) {
					if (!subcomponentModes.contains(flowMode)) {
						String flowModeName = flowMode.getName();
						String flowModeURI = EcoreUtil.getURI(flowMode).toString();
						String subcomponentName = subcomponent.getName();
						String subcomponentURI = EcoreUtil.getURI(subcomponent).toString();
						error("Subcomponent '" + subcomponentName + "' does not exist in mode '" + flowModeName + "'",
								flowSegment, null, SUBCOMPONENT_NOT_IN_FLOW_MODE, flowModeName, flowModeURI,
								subcomponentName, subcomponentURI);
					}
				}
			} else if (flowSegment.getContext() == null && flowSegment.getFlowElement() instanceof Connection) {
				Connection connection = (Connection) flowSegment.getFlowElement();
				EList<Mode> connectionModes = connection.getAllInModes();
				if (connectionModes.isEmpty()) {
					connectionModes = connection.getContainingComponentImpl().getAllModes();
				}
				for (Mode flowMode : flowModes) {
					if (!connectionModes.contains(flowMode)) {
						String flowModeName = flowMode.getName();
						String flowModeURI = EcoreUtil.getURI(flowMode).toString();
						String connectionName = connection.getName();
						String connectiontURI = EcoreUtil.getURI(connection).toString();
						error("Connection '" + connectionName + "' does not exist in mode '" + flowModeName + "'",
								flowSegment, null, CONNECTION_NOT_IN_FLOW_MODE, flowModeName, flowModeURI,
								connectionName, connectiontURI);
					}
				}
			}
		}
	}

	private List<String> resolveCompositeNodeToList(ICompositeNode cNode) {
		List<String> nodes = new ArrayList<String>();

		BidiIterable<INode> iterable = cNode.getChildren();
		Iterator<INode> iter = iterable.iterator();
		while (iter.hasNext()) {
			INode iterNode = iter.next();
			if (iterNode instanceof HiddenLeafNode) {
				continue;
			} else if (iterNode instanceof LeafNode) {
				nodes.add(iterNode.getText().trim());
			} else if (iterNode instanceof CompositeNode) {
				nodes.addAll(resolveCompositeNodeToList((CompositeNode) iterNode));
			}
		}
		return nodes;
	}

	private int findKeywordOffset(EObject object, String searchword) {
		ICompositeNode n = NodeModelUtils.getNode(object);
		INode lln = findFirstKeywordNodeEqualToString(n, nodeSearchString(searchword));
		return lln.getOffset();
	}

	private INode findFirstKeywordNodeEqualToString(ICompositeNode cNode, String searchFor) {
		INode result = null;
		searchFor = searchFor.toLowerCase();

		BidiIterable<INode> iterable = cNode.getChildren();
		Iterator<INode> iter = iterable.iterator();
		while (iter.hasNext()) {
			INode iterNode = iter.next();
			if (iterNode instanceof HiddenLeafNode) {
				continue;
			} else if (iterNode instanceof LeafNode) {
				if (iterNode.getGrammarElement() instanceof Keyword) {
					if (iterNode.getText().toLowerCase().equalsIgnoreCase(searchFor)) {
						return iterNode;
					}
				}
			} else if (iterNode instanceof CompositeNode) {
				result = findFirstKeywordNodeEqualToString((CompositeNode) iterNode, searchFor);
				if (null != result) {
					return result;
				}
			}
		}
		return result;
	}

	private INode findFirstArraySizeNodeEqualToSize(ICompositeNode cNode, long searchForValue) {
		INode result = null;
		BidiIterable<INode> iterable = cNode.getChildren();
		Iterator<INode> iter = iterable.iterator();
		while (iter.hasNext()) {
			INode iterNode = iter.next();
			if (iterNode instanceof HiddenLeafNode) {
				continue;
			} else if (iterNode instanceof LeafNode) {
				continue;
			} else if (iterNode instanceof CompositeNodeWithSemanticElement) {
				if (iterNode.getSemanticElement() instanceof ArrayDimension) {
					ArrayDimension arrayDimension = (ArrayDimension) iterNode.getSemanticElement();
					if (searchForValue == arrayDimension.getSize().getSize()) {
						return iterNode;
					}
				}
			} else if (iterNode instanceof CompositeNode) {
				result = findFirstArraySizeNodeEqualToSize((CompositeNode) iterNode, searchForValue);
				if (null != result) {
					return result;
				}
			}
		}
		return result;
	}

	// private void checkFlowPathElements(FlowImplementation flowimplementation)
	// {
	//
	// if (!flowimplementation.getKind().equals(FlowKind.PATH)) {
	// return;
	// }
	//
	// FlowSpecification spec = flowimplementation.getSpecification();
	// if (Aadl2Util.isNull(spec)) {
	// return;
	// }
	//
	// FlowEnd specIn = spec.getAllInEnd();
	// if (Aadl2Util.isNull(specIn)) {
	// return;
	// }
	// FlowEnd specOut = spec.getAllOutEnd();
	// if (Aadl2Util.isNull(specOut)) {
	// return;
	// }
	//
	// String specInContext = (specIn.getContext() != null) ?
	// specIn.getContext().getName() + "." : "";
	// String specOutContext = (specOut.getContext() != null) ?
	// specOut.getContext().getName() + "." : "";
	// String specInFeature = specIn.getFeature().getName();
	// String specOutFeature = specOut.getFeature().getName();
	// String specInName = specInContext + specInFeature;
	// String specOutName = specOutContext + specOutFeature;
	//
	// ICompositeNode n = NodeModelUtils.getNode(flowimplementation);
	// List<String> resolvedComposite = resolveCompositeNodeToList(n);
	//
	// if (null == resolvedComposite || resolvedComposite.isEmpty() ||
	// !resolvedComposite.contains("->")) {
	// return;
	// }
	//
	// int index = resolvedComposite.size() - 1;
	//
	// String outFeature = resolvedComposite.get(index--);
	// String outContext = "";
	//
	// if (resolvedComposite.get(index).equals(".")) {
	// index--;
	// }
	// if (resolvedComposite.get(index).equals("->")) {
	// outContext = "";
	// } else {
	// outContext = resolvedComposite.get(index--);
	// }
	// String outImpl = outContext + ((outContext.equals("")) ? "" : ".") +
	// outFeature;
	//
	// String inFeature = "";
	// String inContext = "";
	//
	// index = 0;
	// for (int i = 0; i < resolvedComposite.size(); i++) {
	// if (resolvedComposite.get(i).equalsIgnoreCase("path")) {
	// index = i + 1;
	// break;
	// }
	// }
	//
	// inFeature = resolvedComposite.get(index++);
	// if (resolvedComposite.get(index++).equals(".")) {
	// inContext = inFeature;
	// inFeature = resolvedComposite.get(index);
	// }
	//
	// String inImpl = inContext + ((inContext.equals("")) ? "" : ".") +
	// inFeature;
	//
	// if (!inImpl.equalsIgnoreCase(specInName)) {
	// error(flowimplementation, "Flow implementation In type: " + inImpl
	// + " differs from specification In type: " + specInName);
	// }
	// if (!outImpl.equalsIgnoreCase(specOutName)) {
	// error(flowimplementation, "Flow implementation Out type: " + outImpl
	// + " differs from specification Out type: " + specOutName);
	// }
	// }

	/**
	 * Partially checks legality rule 7 in section 10.2 (Flow Implementations)
	 * on page 189. "Component type extensions may refine flow specifications
	 * and component implementation extensions may refine subcomponents and
	 * connections with in modes statements. A flow implementation that is
	 * inherited by the extension must be consistent with the modes of the
	 * refined flow specifications, subcomponents, and connections if named in
	 * the flow implementation according to rules (L4) and (L5). Otherwise, the
	 * flow implementation has to be defined again in the component
	 * implementation extension and satisfy rules (L4) and (L5)." This method
	 * checks the (L5) portion of (L7).
	 */
	private void checkFlowImplementationModeCompatibilityWithRefinedFlowSegments(
			ComponentImplementation componentImplementation) {
		if (componentImplementation.getAllModes().isEmpty()) {
			return;
		}
		ArrayList<Subcomponent> subcomponentRefinements = new ArrayList<Subcomponent>();
		for (Subcomponent subcomponent : componentImplementation.getOwnedSubcomponents()) {
			if (subcomponent.getRefined() != null) {
				subcomponentRefinements.add(subcomponent);
			}
		}
		ArrayList<Connection> connectionRefinements = new ArrayList<Connection>();
		for (Connection connection : componentImplementation.getOwnedConnections()) {
			if (connection.getRefined() != null) {
				connectionRefinements.add(connection);
			}
		}
		if (subcomponentRefinements.size() == 0 && connectionRefinements.size() == 0) {
			return;
		}
		ArrayList<FlowImplementation> inheritedFlows = new ArrayList<FlowImplementation>();
		for (FlowImplementation flow : removeOverridenFlowImplementations(
				componentImplementation.getAllFlowImplementations())) {
			if (!componentImplementation.getOwnedFlowImplementations().contains(flow)) {
				inheritedFlows.add(flow);
			}
		}
		if (inheritedFlows.size() == 0) {
			return;
		}
		for (FlowImplementation flow : inheritedFlows) {
			EList<Mode> flowModes = flow.getAllInModes();
			if (flowModes.isEmpty()) {
				flowModes = componentImplementation.getAllModes();
			}
			for (FlowSegment flowSegment : flow.getOwnedFlowSegments()) {
				if (flowSegment.getContext() == null && flowSegment.getFlowElement() instanceof Subcomponent) {
					Subcomponent subcomponentRefinement = findSubcomponentRefinement(
							(Subcomponent) flowSegment.getFlowElement(), subcomponentRefinements);
					if (subcomponentRefinement != null) {
						EList<Mode> subcomponentModes = subcomponentRefinement.getAllInModes();
						if (subcomponentModes.isEmpty()) {
							subcomponentModes = componentImplementation.getAllModes();
						}
						for (Mode flowMode : flowModes) {
							if (!subcomponentModes.contains(flowMode)) {
								String flowModeName = flowMode.getName();
								String flowModeURI = EcoreUtil.getURI(flowMode).toString();
								String subcomponentName = subcomponentRefinement.getName();
								String subcomponentURI = EcoreUtil.getURI(subcomponentRefinement).toString();
								error("Inherited flow implementation '" + flow.getSpecification().getName()
										+ "' refers to subcomponent refinement '" + subcomponentRefinement.getName()
										+ "' which does not exist in mode '" + flowMode.getName() + "'",
										subcomponentRefinement, null, SUBCOMPONENT_NOT_IN_FLOW_MODE, flowModeName,
										flowModeURI, subcomponentName, subcomponentURI);
							}
						}
					}
				} else if (flowSegment.getContext() instanceof Subcomponent) {
					Subcomponent subcomponentRefinement = findSubcomponentRefinement(
							(Subcomponent) flowSegment.getContext(), subcomponentRefinements);
					if (subcomponentRefinement != null) {
						EList<Mode> subcomponentModes = subcomponentRefinement.getAllInModes();
						if (subcomponentModes.isEmpty()) {
							subcomponentModes = componentImplementation.getAllModes();
						}
						for (Mode flowMode : flowModes) {
							if (!subcomponentModes.contains(flowMode)) {
								String flowModeName = flowMode.getName();
								String flowModeURI = EcoreUtil.getURI(flowMode).toString();
								String subcomponentName = subcomponentRefinement.getName();
								String subcomponentURI = EcoreUtil.getURI(subcomponentRefinement).toString();
								error("Inherited flow implementation '" + flow.getSpecification().getName()
										+ "' refers to subcomponent refinement '" + subcomponentRefinement.getName()
										+ "' which does not exist in mode '" + flowMode.getName() + "'",
										subcomponentRefinement, null, SUBCOMPONENT_NOT_IN_FLOW_MODE, flowModeName,
										flowModeURI, subcomponentName, subcomponentURI);
							}
						}
					}
				} else if (flowSegment.getContext() == null && flowSegment.getFlowElement() instanceof Connection) {
					Connection connectionRefinement = findConnectionRefinement(
							(Connection) flowSegment.getFlowElement(), connectionRefinements);
					if (connectionRefinement != null) {
						EList<Mode> connectionModes = connectionRefinement.getAllInModes();
						if (connectionModes.isEmpty()) {
							connectionModes = componentImplementation.getAllModes();
						}
						for (Mode flowMode : flowModes) {
							if (!connectionModes.contains(flowMode)) {
								String flowModeName = flowMode.getName();
								String flowModeURI = EcoreUtil.getURI(flowMode).toString();
								String connectionName = connectionRefinement.getName();
								String connectiontURI = EcoreUtil.getURI(connectionRefinement).toString();
								error("Connection '" + connectionName + "' does not exist in mode '" + flowModeName
										+ "'", connectionRefinement, null, CONNECTION_NOT_IN_FLOW_MODE, flowModeName,
										flowModeURI, connectionName, connectiontURI);
							}
						}
					}
				}
			}
		}
	}

	private ArrayList<FlowImplementation> removeOverridenFlowImplementations(EList<FlowImplementation> flows) {
		ArrayList<FlowImplementation> flowsToReturn = new ArrayList<FlowImplementation>();
		HashSet<Integer> indiciesToIgnore = new HashSet<Integer>();
		for (int i = 0; i < flows.size(); i++) {
			if (!indiciesToIgnore.contains(i)) {
				FlowImplementation correctFlow = flows.get(i);
				for (int j = i + 1; j < flows.size(); j++) {
					if (!indiciesToIgnore.contains(j)) {
						if (correctFlow.getSpecification() == flows.get(j).getSpecification()) {
							if (flows.get(j).getContainingClassifier()
									.isDescendentOf(correctFlow.getContainingClassifier())) {
								correctFlow = flows.get(j);
							}
							indiciesToIgnore.add(j);
						}
					}
				}
				flowsToReturn.add(correctFlow);
			}
		}
		return flowsToReturn;
	}

	private Subcomponent findSubcomponentRefinement(Subcomponent baseSubcomponent,
			ArrayList<Subcomponent> subcomponentRefinements) {
		for (Subcomponent refinement : subcomponentRefinements) {
			for (Subcomponent currentParent = refinement
					.getRefined(); currentParent != null; currentParent = currentParent.getRefined()) {
				if (currentParent == baseSubcomponent) {
					return refinement;
				}
			}
		}
		return null;
	}

	private Connection findConnectionRefinement(Connection baseConnection,
			ArrayList<Connection> connectionRefinements) {
		for (Connection refinement : connectionRefinements) {
			for (Connection currentParent = refinement
					.getRefined(); currentParent != null; currentParent = currentParent.getRefined()) {
				if (currentParent == baseConnection) {
					return refinement;
				}
			}
		}
		return null;
	}

	/**
	 * Checks legality rule 4 in section 10.2 (Flow Implementations) on page
	 * 189. "If the component implementation provides mode-specific flow
	 * implementations, as indicated by the in modes statement, then the set of
	 * modes in the in modes statement of all flow implementations for a given
	 * flow specification must include all the modes for which the flow
	 * specification is declared."
	 *
	 * Partially checks legality rule 7 in section 10.2 (Flow Implementations)
	 * on page 189. "Component type extensions may refine flow specifications
	 * and component implementation extensions may refine subcomponents and
	 * connections with in modes statements. A flow implementation that is
	 * inherited by the extension must be consistent with the modes of the
	 * refined flow specifications, subcomponents, and connections if named in
	 * the flow implementation according to rules (L4) and (L5). Otherwise, the
	 * flow implementation has to be defined again in the component
	 * implementation extension and satisfy rules (L4) and (L5). This method
	 * checks the (L4) portion of (L7).
	 */
	private void checkModeSpecificFlowImplementations(ComponentImplementation componentImplementation) {
		EList<Mode> componentModes = componentImplementation.getAllModes();
		if (componentModes.isEmpty()) {
			return;
		}
		HashMap<FlowSpecification, HashSet<Mode>> allFlowImplementationModes = new HashMap<FlowSpecification, HashSet<Mode>>();
		for (FlowImplementation flowImplementation : componentImplementation.getAllFlowImplementations()) {
			HashSet<Mode> flowModesSet = allFlowImplementationModes.get(flowImplementation.getSpecification());
			if (flowModesSet == null) {
				flowModesSet = new HashSet<Mode>();
				allFlowImplementationModes.put(flowImplementation.getSpecification(), flowModesSet);
			}
			if (flowImplementation.getAllInModes().isEmpty()) {
				flowModesSet.addAll(componentModes);
			} else {
				flowModesSet.addAll(flowImplementation.getAllInModes());
			}
		}
		for (Entry<FlowSpecification, HashSet<Mode>> entry : allFlowImplementationModes.entrySet()) {
			EList<Mode> flowSpecificationModes = entry.getKey().getAllInModes();
			if (flowSpecificationModes.isEmpty()) {
				flowSpecificationModes = componentImplementation.getAllModes();
			}
			for (Mode flowSpecificationMode : flowSpecificationModes) {
				if (!entry.getValue().contains(flowSpecificationMode)) {
					error(componentImplementation, "Flow implementation '" + entry.getKey().getName()
							+ "' needs to be declared for mode '" + flowSpecificationMode.getName() + '\'');
				}
			}
		}
	}

	/**
	 * Partially checks naming rule 3 in section 10.3 (End-To-End Flows) on page
	 * 191. "The subcomponent flow identifier of an end-to-end flow declaration
	 * must name an optional flow specification in the component type of the
	 * named subcomponent or to a data component in the form of a data
	 * subcomponent, provides data access, or requires data access."
	 */
	private void typeCheckEndToEndFlowSegments(EndToEndFlow flow) {
		for (int i = 0; i < flow.getOwnedEndToEndFlowSegments().size(); i++) {
			EndToEndFlowSegment segment = flow.getOwnedEndToEndFlowSegments().get(i);
			if ((segment.getContext() == null || !segment.getContext().eIsProxy()) && segment.getFlowElement() != null
					&& !segment.getFlowElement().eIsProxy()) {
				if (i % 2 == 0) {
					// Checking ETESubcomponentFlow
					if (segment.getContext() == null) {
						if (segment.getFlowElement() instanceof Connection) {
							error(segment, "Illegal reference to connection '" + segment.getFlowElement().getName()
									+ "'.  Expecting subcomponent flow or end-to-end flow reference.");
						} else if (segment.getFlowElement() instanceof FlowSpecification) {
							error(segment, "Illegal reference to '" + segment.getFlowElement().getName()
									+ "'.  Cannot refer to a flow specification in the local classifier's namespace.");
						} else if (segment.getFlowElement() instanceof DataAccess && i > 0
								&& i < flow.getOwnedEndToEndFlowSegments().size() - 1) {
							error(segment, "Illegal reference to '" + segment.getFlowElement().getName()
									+ "'.  Cannot refer to a data access except for the first and last segment of an end-to-end flow.");
						}
					} else if (segment.getContext() instanceof Subcomponent) {
						if (!(segment.getFlowElement() instanceof FlowSpecification)) {
							error(StringExtensions
									.toFirstUpper(getEClassDisplayNameWithIndefiniteArticle(
											segment.getFlowElement().eClass()))
									+ " in " + getEClassDisplayNameWithIndefiniteArticle(segment.getContext().eClass())
									+ " is not a valid subcomponent flow.", segment,
									Aadl2Package.eINSTANCE.getEndToEndFlowSegment_FlowElement());
						}
					} else {
						error("Anything in " + getEClassDisplayNameWithIndefiniteArticle(segment.getContext().eClass())
								+ " is not a valid subcomponent flow.", segment,
								Aadl2Package.eINSTANCE.getEndToEndFlowSegment_Context());
					}
				} else {
					// Checking ETEConnectionFlow
					// Because of the parser rule ETEConnectionFlow, we know
					// that the segment.getContext() is null.
					if (!(segment.getFlowElement() instanceof Connection)) {
						error(segment, "Expected Connection, found "
								+ getEClassDisplayName(segment.getFlowElement().eClass()) + '.');
					}
				}
			}
		}
	}

	/**
	 * Checks legality rule 1 in section 10.3 (End-To-End Flows) on page 191.
	 * "The flow specifications identified by the
	 * flow_path_subcomponent_flow_identifier must be flow paths, if present."
	 *
	 * Checks legality rule 2 in section 10.3 (End-To-End Flows) on page 191.
	 * "The start_subcomponent_flow_identifier must refer to a flow path or flow
	 * source, or to a data component."
	 *
	 * Checks legality rule 3 in section 10.3 (End-To-End Flows) on page 191.
	 * "The end_subcomponent_flow_identifier must refer to a flow path or a flow
	 * sink, or to a data component."
	 */
	@SuppressWarnings("incomplete-switch")
	private void checkEndToEndFlowSegments(EndToEndFlow flow) {
		for (int i = 0; i < flow.getOwnedEndToEndFlowSegments().size(); i++) {
			EndToEndFlowSegment segment = flow.getOwnedEndToEndFlowSegments().get(i);
			if (i % 2 == 0 && segment.getContext() instanceof Subcomponent && !segment.getContext().eIsProxy()
					&& segment.getFlowElement() instanceof FlowSpecification && !segment.getFlowElement().eIsProxy()) {
				if (i == 0) {
					// first element of an ETEF
					if (((FlowSpecification) segment.getFlowElement()).getKind() == FlowKind.SINK) {
						error(segment,
								"Illegal reference to '" + segment.getContext().getName() + '.'
										+ segment.getFlowElement().getName()
										+ "'.  First segment of end-to-end flow cannot refer to a flow sink.");
					}
				} else if (i == flow.getOwnedEndToEndFlowSegments().size() - 1) {
					// last element of ETEF
					if (((FlowSpecification) segment.getFlowElement()).getKind() == FlowKind.SOURCE) {
						error(segment,
								"Illegal reference to '" + segment.getContext().getName() + '.'
										+ segment.getFlowElement().getName()
										+ "'.  Last segment of end-to-end flow cannot refer to a flow source.");
					}
				} else {
					// an intermediate ETEF
					switch (((FlowSpecification) segment.getFlowElement()).getKind()) {
					case SOURCE:
						error(segment, "Illegal reference to '" + segment.getContext().getName() + '.'
								+ segment.getFlowElement().getName()
								+ "'.  Cannot refer to a flow source except for the first segment of an end-to-end flow.");
					case SINK:
						error(segment, "Illegal reference to '" + segment.getContext().getName() + '.'
								+ segment.getFlowElement().getName()
								+ "'.  Cannot refer to a flow sink except for the last segment of an end-to-end flow.");
					}
				}
			}
		}
	}

	private void checkFlowConnectionEnds(EndToEndFlow flow) {
		int size = flow.getOwnedEndToEndFlowSegments().size();
		for (int i = 0; i < size; i++) {
			ConnectionEnd ce = null;
			Context cxt = null;
			EndToEndFlowElement flowElement = flow.getOwnedEndToEndFlowSegments().get(i).getFlowElement();
			if (i % 2 == 1 && flowElement instanceof Connection && !flowElement.eIsProxy()) {
				// for connection (every even element) check that it matches up
				// with the preceding flow specification
				Connection connection = (Connection) flow.getOwnedEndToEndFlowSegments().get(i).getFlowElement();
				ce = connection.getAllSource();
				cxt = connection.getAllSourceContext();
				boolean didReverse = false;
				if (i > 0 && flow.getOwnedEndToEndFlowSegments().get(i - 1)
						.getFlowElement() instanceof FlowSpecification) {
					FlowSpecification previousFlowSegment = (FlowSpecification) flow.getOwnedEndToEndFlowSegments()
							.get(i - 1).getFlowElement();
					FlowEnd outEnd = previousFlowSegment.getAllOutEnd();
					if (Aadl2Util.isNull(outEnd)) {
						return;
					}
					if (!isMatchingConnectionPoint(outEnd.getFeature(), outEnd.getContext(), ce, cxt)) {
						if (connection.isAllBidirectional()) {
							ce = connection.getAllDestination();
							cxt = connection.getAllDestinationContext();
							if (!isMatchingConnectionPoint(outEnd.getFeature(), outEnd.getContext(), ce, cxt)) {
								error(flow.getOwnedEndToEndFlowSegments().get(i),
										"The source of connection '" + connection.getName()
												+ "' does not match the out flow feature of the preceding subcomponent flow specification '"
												+ flow.getOwnedEndToEndFlowSegments().get(i - 1).getContext().getName()
												+ '.' + previousFlowSegment.getName() + '\'');
							} else {
								didReverse = true;
							}
						}
					}
				} else if (i > 0
						&& flow.getOwnedEndToEndFlowSegments().get(i - 1).getFlowElement() instanceof Subcomponent) {
					Subcomponent previousFlowSegment = (Subcomponent) flow.getOwnedEndToEndFlowSegments().get(i - 1)
							.getFlowElement();
					if (connection.isAllBidirectional()) {
						ce = connection.getAllSource();
						cxt = connection.getAllSourceContext();
						if (cxt == null && !ce.equals(previousFlowSegment)) {
							error(flow.getOwnedEndToEndFlowSegments().get(i),
									"The source of connection '" + connection.getName()
											+ "' does not match the out flow feature of the preceding subcomponent '"
											+ previousFlowSegment.getName() + '\'');
							didReverse = true;
						} else {
							didReverse = false;
						}
					}

				}
				if (didReverse) {
					ce = connection.getAllSource();
					cxt = connection.getAllSourceContext();
				} else {
					ce = connection.getAllDestination();
					cxt = connection.getAllDestinationContext();
				}
				if (i + 1 < size) {
					EndToEndFlowElement felem = flow.getOwnedEndToEndFlowSegments().get(i + 1).getFlowElement();
					if (felem instanceof FlowSpecification) {
						FlowSpecification nextFlowSegment = (FlowSpecification) felem;
						FlowEnd inEnd = nextFlowSegment.getAllInEnd();
						if (Aadl2Util.isNull(inEnd)) {
							return;
						}
						if (ce instanceof Feature) {
							if (!isMatchingConnectionPoint(inEnd.getFeature(), inEnd.getContext(), ce, cxt)) {
								error(flow.getOwnedEndToEndFlowSegments().get(i),
										"The destination of connection '" + connection.getName()
												+ "' does not match the in flow feature of the succeeding subcomponent flow specification '"
												+ flow.getOwnedEndToEndFlowSegments().get(i + 1).getContext().getName()
												+ '.' + nextFlowSegment.getName() + '\'');
							}
						}
					} else if (felem instanceof Subcomponent) {
						Subcomponent nextFlowSegment = (Subcomponent) felem;
						if (cxt == null && !ce.equals(nextFlowSegment)) {
							error(flow.getOwnedEndToEndFlowSegments().get(i),
									"The destination of connection '" + connection.getName()
											+ "' does not match the out flow feature of the succeeding subcomponent '"
											+ nextFlowSegment.getName() + '\'');
						}
					}
				}
			}
		}
	}

	/**
	 * Checks legality rule 4 in section 10.3 (End-To-End Flows) on page 191.
	 * "If an end-to-end flow is referenced in an end-to-end flow declaration,
	 * then its first and last subcomponent flow must name the same port as the
	 * preceding or succeeding connection."
	 *
	 * Checks a proposed legality rule for end-to-end flows. "If the
	 * start_subcomponent_flow_identifier or
	 * flow_path_subcomponent_flow_identifier refers to an end-to-end flow, then
	 * the referenced flow's last subcomponent flow cannot be a flow sink."
	 *
	 * Checks a proposed legality rule for end-to-end flows. "If the
	 * end_subcomponent_flow_identifier or
	 * flow_path_subcomponent_flow_identifier refers to an end-to-end flow, then
	 * the referenced flows's first subcomponent flow cannot be a flow source."
	 */
	private void checkNestedEndToEndFlows(EndToEndFlow flow) {
		for (int i = 0; i < flow.getOwnedEndToEndFlowSegments().size(); i++) {
			EndToEndFlowSegment segment = flow.getOwnedEndToEndFlowSegments().get(i);
			if (i % 2 == 0 && segment.getContext() == null && segment.getFlowElement() instanceof EndToEndFlow
					&& !segment.getFlowElement().eIsProxy()) {
				EndToEndFlow referencedFlow = (EndToEndFlow) segment.getFlowElement();
				if (i < flow.getOwnedEndToEndFlowSegments().size() - 1) {
					if (referencedFlow.getOwnedEndToEndFlowSegments()
							.get(referencedFlow.getOwnedEndToEndFlowSegments().size() - 1)
							.getFlowElement() instanceof FlowSpecification) {
						FlowSpecification referencedEndFlowSpec = (FlowSpecification) referencedFlow
								.getOwnedEndToEndFlowSegments()
								.get(referencedFlow.getOwnedEndToEndFlowSegments().size() - 1).getFlowElement();
						if (referencedEndFlowSpec.getKind() == FlowKind.SINK) {
							error(segment, "The last subcomponent flow of '" + referencedFlow.getName()
									+ "' cannot be a flow sink.");
						} else if (referencedEndFlowSpec.getKind() == FlowKind.PATH && flow
								.getOwnedEndToEndFlowSegments().get(i + 1).getFlowElement() instanceof Connection) {
							Connection nextConnection = (Connection) flow.getOwnedEndToEndFlowSegments().get(i + 1)
									.getFlowElement();
							if (referencedEndFlowSpec.getAllOutEnd().getFeature() != nextConnection.getAllSource()) {
								error(segment,
										"The last subcomponent flow of '" + referencedFlow.getName()
												+ "' does not name the same feature as the source of the succeeding connection '"
												+ nextConnection.getName() + "'.");
							}
						}
					}
				}
				if (i > 0) {
					if (referencedFlow.getOwnedEndToEndFlowSegments().get(0)
							.getFlowElement() instanceof FlowSpecification) {
						FlowSpecification referencedStartFlowSpec = (FlowSpecification) referencedFlow
								.getOwnedEndToEndFlowSegments().get(0).getFlowElement();
						if (referencedStartFlowSpec.getKind() == FlowKind.SOURCE) {
							error(segment, "The first subcomponent flow of '" + referencedFlow.getName()
									+ "' cannot be a flow source.");
						} else if (referencedStartFlowSpec.getKind() == FlowKind.PATH && flow
								.getOwnedEndToEndFlowSegments().get(i - 1).getFlowElement() instanceof Connection) {
							Connection previousConnection = (Connection) flow.getOwnedEndToEndFlowSegments().get(i - 1)
									.getFlowElement();
							if (referencedStartFlowSpec.getAllInEnd().getFeature() != previousConnection
									.getAllDestination()) {
								error(segment,
										"The first subcomponent flow of '" + referencedFlow.getName()
												+ "' does not name the same feature as the destination of the preceding connection '"
												+ previousConnection.getName() + "'.");
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Checks legality rule 5 in section 10.3 (End-To-End Flows) on page 192.
	 * "In case of a mode specific end-to-end flow declarations, the named
	 * connections and the subcomponents of the named flow specifications must
	 * be declared for the modes listed in the in modes statement."
	 */
	private void checkEndToEndFlowModes(EndToEndFlow flow) {
		EList<Mode> neededModes = flow.getAllInModes();
		if (neededModes.isEmpty()) {
			neededModes = flow.getContainingComponentImpl().getAllModes();
		}
		if (neededModes.isEmpty()) {
			return;
		}
		for (EndToEndFlowSegment segment : flow.getAllFlowSegments()) {
			EList<Mode> segmentModes = null;
			String targetURI = "";
			String targetName = "";
			if (segment.getContext() != null && segment.getContext() instanceof ModalElement) {
				segmentModes = ((ModalElement) segment.getContext()).getAllInModes();
				targetName = segment.getContext().getName();
				targetURI = EcoreUtil.getURI(segment.getContext()).toString();
			} else if (segment.getContext() == null && segment.getFlowElement() instanceof ModalElement) {
				segmentModes = ((ModalElement) segment.getFlowElement()).getAllInModes();
				targetName = segment.getFlowElement().getName();
				targetURI = EcoreUtil.getURI(segment.getFlowElement()).toString();
			}
			if (segmentModes != null && !segmentModes.isEmpty()) {
				for (Mode neededMode : neededModes) {
					if (!segmentModes.contains(neededMode)) {
						String neededModeName = neededMode.getName();
						String neededModeURI = EcoreUtil.getURI(neededMode).toString();
						error("'" + targetName + "' does not exist in mode '" + neededModeName + "'.", segment, null,
								END_TO_END_FLOW_SEGMENT_NOT_IN_MODE, targetName, targetURI, neededModeName,
								neededModeURI);
					}
				}
			}
		}
	}

	public void checkExtendCycles(Classifier cl) {
		if (hasExtendCycles(cl)) {
			Generalization extension;
			if (cl instanceof ComponentType) {
				extension = ((ComponentType) cl).getOwnedExtension();
			} else if (cl instanceof ComponentImplementation) {
				extension = ((ComponentImplementation) cl).getOwnedExtension();
			} else {
				extension = ((FeatureGroupType) cl).getOwnedExtension();
			}
			error(extension, "The extends hierarchy of " + cl.getName() + " has a cycle.");
		}
	}

	protected INode getLastLeaf(INode node) {
		INode result = node;
		while (result instanceof ICompositeNode) {
			result = ((ICompositeNode) result).getLastChild();
		}
		return result != null ? result : node;
	}

	protected INode getPreviousNode(INode node) {
		INode lln = node.getPreviousSibling();
		while (lln instanceof HiddenLeafNode) {
			lln = lln.getPreviousSibling();
		}
		return lln;
	}

	protected INode getNextNode(INode node) {
		INode lln = node.getNextSibling();
		while (lln instanceof HiddenLeafNode) {
			lln = lln.getNextSibling();
		}
		return lln;
	}

	/**
	 * check for unique names in component type
	 */
	public void checkComponentTypeUniqueNames(ComponentType type) {
		// process in core package
		EList<NamedElement> l = new BasicEList<NamedElement>();
		l.addAll(type.getAllFlowSpecifications());
		l.addAll(type.getAllFeatures());
		l.addAll(type.getAllModes());
		l.addAll(type.getAllModeTransitions());
		l.addAll(type.getAllPrototypes());
		l = sortNamedElements(l);
		EList<NamedElement> doubles = AadlUtil.findDoubleNamedElementsInList(l);
		if (doubles.size() > 0) {
			for (NamedElement ne : doubles) {
				if (type.getOwnedElements().isEmpty() || !type.getOwnedElements().contains(ne)) {
					continue;
				}
				if (ne instanceof Mode || ne instanceof ModeTransition) {
					error(ne, ne.eClass().getName() + " identifier '" + ne.getName() + "' previously defined.");
				} else if (ne instanceof FlowSpecification) {
					error(ne, ne.eClass().getName() + " identifier '" + ne.getName()
							+ "' previously defined. Maybe you forgot 'refined to'");
				} else {
					Classifier classifier = ne.getContainingClassifier();
					List<NamedElement> dupesInClassifier = findDupesInSameClassifier(classifier, ne);
					if (dupesInClassifier.size() > 1) {
						for (NamedElement dupeNe : dupesInClassifier) {
							error(dupeNe,
									"Duplicate identifiers '" + dupeNe.getName() + "' in " + classifier.getName());
						}
						continue;
					}

					List<Classifier> extendedClassifiers = getExtendedClassifiersWithElement(classifier, ne);
					if (extendedClassifiers.size() < 1) {
						continue;
					}

					NamedElement duplicated = null;
					duplicated = extendedClassifiers.get(0).findNamedElement(ne.getName());
					if ((!((duplicated instanceof AbstractFeature && ne instanceof Feature)
							|| (duplicated instanceof AbstractPrototype && ne instanceof Prototype))
							&& !ne.eClass().equals(duplicated.eClass()))
							|| ((duplicated instanceof AbstractFeature && ne instanceof Prototype)
									|| (duplicated instanceof Prototype & ne instanceof AbstractFeature))) {
						error(ne, duplicated.eClass().getName() + " identifier '" + ne.getName()
								+ "' previously defined in " + duplicated.getContainingClassifier().getName());
					} else if (((ne instanceof Feature && ((Feature) ne).getRefined() != null)
							&& (duplicated instanceof Feature && ((Feature) duplicated).getRefined() != null))
							|| ((ne instanceof Prototype && ((Prototype) ne).getRefined() != null)
									&& (duplicated instanceof Prototype
											&& ((Prototype) duplicated).getRefined() != null))) {
						continue;
					} else if (((ne instanceof Feature && ((Feature) ne).getRefined() != null)
							&& (duplicated instanceof Feature && ((Feature) duplicated).getRefined() == null))
							|| ((ne instanceof Prototype && ((Prototype) ne).getRefined() != null)
									&& (duplicated instanceof Prototype
											&& ((Prototype) duplicated).getRefined() == null))) {
						continue;
					} else {
						postRefineableErrorWithFix(ne, duplicated);
					}
				}
			}
		}
	}

	/**
	 * check for unique names in implementation
	 */
	public void checkComponentImplementationUniqueNames(ComponentImplementation impl) {
		// process in core package
		EList<NamedElement> usedNames = new BasicEList<NamedElement>();
		usedNames.addAll(impl.getAllPrototypes());
		usedNames.addAll(impl.getAllFeatures());
		usedNames.addAll(impl.getAllSubcomponents());
		usedNames.addAll(impl.getAllConnections());
		usedNames.addAll(impl.getAllModes());
		usedNames.addAll(impl.getAllModeTransitions());
		if (!Aadl2Util.isNull(impl.getType())) {
			usedNames.addAll(impl.getType().getAllFlowSpecifications());
		}
		usedNames.addAll(impl.getAllEndToEndFlows());

		ArrayList<SubprogramCallSequence> csl = null;
		if (impl instanceof BehavioredImplementation) {
			csl = new ArrayList<SubprogramCallSequence>();
			for (ComponentImplementation currentImpl = impl; currentImpl instanceof BehavioredImplementation; currentImpl = currentImpl
					.getExtended()) {
				csl.addAll(((BehavioredImplementation) currentImpl).getOwnedSubprogramCallSequences());
			}
		}

		if (csl != null) {
			usedNames.addAll(csl);
			for (SubprogramCallSequence subprogramCallSequence : csl) {
				usedNames.addAll(subprogramCallSequence.getOwnedSubprogramCalls());
			}
		}

		usedNames = sortNamedElements(usedNames);

		EList<NamedElement> doubles = AadlUtil.findDoubleNamedElementsInList(usedNames);
		if (doubles.size() > 0) {
			for (NamedElement ne : doubles) {

				if ((!(ne instanceof SubprogramCall)) && !impl.getOwnedElements().contains(ne)) {
					continue;
				}

				if (ne instanceof SubprogramCall) {
					NamedElement foundNe = impl.findNamedElement(ne.getName());
					if (null == foundNe) {
						continue;
					}
				}

				Classifier classifier = ne.getContainingClassifier();
				List<NamedElement> dupesInClassifier = findDupesInSameClassifier(classifier, ne);
				if (dupesInClassifier.size() > 1) {
					for (NamedElement dupeNe : dupesInClassifier) {
						error(dupeNe, "Duplicate identifiers '" + dupeNe.getName() + "' in " + classifier.getName());
					}
					continue;
				}

				List<Classifier> extendedClassifiers = getExtendedClassifiersWithElement(classifier, ne);
				List<Classifier> implementedTypeClassifiers = new ArrayList<Classifier>();
				if (classifier instanceof ComponentImplementation) {
					implementedTypeClassifiers = getImplementedClassifiersWithElement(
							((ComponentImplementation) classifier), ne);
				}
				for (Classifier nextClassifier : extendedClassifiers) {
					if (!implementedTypeClassifiers.contains(nextClassifier)) {
						implementedTypeClassifiers.add(nextClassifier);
					}
				}

				if (implementedTypeClassifiers.size() < 1) {
					continue;
				}

				NamedElement duplicated = null;
				duplicated = implementedTypeClassifiers.get(0).findNamedElement(ne.getName());

				if (ne instanceof Subcomponent && duplicated instanceof Subcomponent) {
					postRefineableErrorWithFix(ne, duplicated);
				} else if (ne instanceof Prototype && duplicated instanceof Prototype) {
					if (null != ((Prototype) ne).getRefined()) {
						continue;
					}
					postRefineableErrorWithFix(ne, duplicated);
				} else if (ne instanceof Subcomponent) {
					error(ne, "Identifier '" + ne.getName() + "' has previously been defined in '"
							+ duplicated.getContainingClassifier().getQualifiedName() + "'");

				} else if (ne instanceof Mode && duplicated instanceof Mode) {
					error(ne, "Mode '" + ne.getName() + "' has previously been defined in '"
							+ duplicated.getContainingClassifier().getQualifiedName() + "'");
				} else if (ne instanceof ModeTransition && duplicated instanceof ModeTransition) {
					error(ne, "Mode Transition '" + ne.getName() + "' has previously been defined in '"
							+ duplicated.getContainingClassifier().getQualifiedName() + "'");
				} else if (ne instanceof ModeTransition) {
					error(ne, "Identifier '" + ne.getName() + "' has previously been defined in '"
							+ duplicated.getContainingClassifier().getQualifiedName() + "'");
				} else if (ne instanceof Connection && duplicated instanceof Connection) {
					error(ne,
							"Connection '" + ne.getName() + "' has previously been defined in '"
									+ duplicated.getContainingClassifier().getQualifiedName() + "'. "
									+ "Maybe you forgot 'refined to'");
				} else if (ne instanceof EndToEndFlow && duplicated instanceof EndToEndFlow) {
					error(ne,
							"End to end flow '" + ne.getName() + "' has previously been defined in '"
									+ duplicated.getContainingClassifier().getQualifiedName() + "'. "
									+ "Maybe you forgot 'refined to'");
				} else if (ne instanceof SubprogramCallSequence) {
					error(ne, "Idenitifer '" + ne.getName() + "' has previously been defined in '"
							+ duplicated.getContainingClassifier().getQualifiedName() + "'");
				} else if (ne instanceof SubprogramCall) {
					error(ne, "Identifier '" + ne.getName() + "' has previously been defined in '"
							+ duplicated.getContainingClassifier().getQualifiedName() + "'");
				} else if (!ne.eClass().equals(duplicated.eClass())) {
					error(ne, "Identifier '" + ne.getName() + "' has previously been defined in '"
							+ duplicated.getContainingClassifier().getQualifiedName() + "'");
				} else {
					// least helpful catch all error in case something was
					// overlooked
					error(ne,
							"Identifier '" + ne.getName() + "' has previously been defined in implementation '"
									+ duplicated.getContainingClassifier().getQualifiedName() + "' or in type '"
									+ impl.getTypeName() + "'");
				}
			}
		}
	}

	private void postRefineableErrorWithFix(NamedElement ne, NamedElement duplicated) {
		ICompositeNode n = NodeModelUtils.getNode(ne);
		INode cn = findFirstKeywordNodeEqualToString(n, ":");
		INode nextNode = cn.getNextSibling();
		String leadingSpace = "";
		String trailingSpace = " ";
		if (nextNode instanceof LeafNode && nextNode.getText().substring(0, 1).equals(" ")) {
			leadingSpace = " ";
			trailingSpace = "";
		} else {
			while (nextNode instanceof CompositeNode) {
				nextNode = ((CompositeNode) nextNode).getFirstChild();
				if (nextNode instanceof LeafNode && ((LeafNode) nextNode).getText().substring(0, 1).equals(" ")) {
					leadingSpace = " ";
					trailingSpace = "";
				}
			}
		}
		String cnOffset = "" + cn.getTotalOffset();
		String replacementVal = ":" + leadingSpace + "refined to" + trailingSpace;
		String errMsg = ne.eClass().getName() + " identifier '" + ne.getName() + "' previously defined in "
				+ duplicated.getContainingClassifier().getName() + ". Maybe you forgot 'refined to'";

		error(errMsg, ne, Aadl2Package.eINSTANCE.getNamedElement_Name(), DUPLICATE_COMPONENT_TYPE_NAME, ne.getName(),
				cnOffset, replacementVal);

	}

	private List<Classifier> getExtendedClassifiersWithElement(Classifier classifier, NamedElement ne) {
		Classifier extended = classifier.getExtended();
		if (null == extended && classifier instanceof ComponentImplementation) {
			extended = ((ComponentImplementation) classifier).getType();
		}
		List<Classifier> extendedClassifiers = new ArrayList<Classifier>();
		while (null != extended) {
			EList<Element> ownedElements = extended.getOwnedElements();
			if (null != ownedElements) {
				for (Element ownedElement : ownedElements) {
					if (ownedElement instanceof NamedElement
							&& ((NamedElement) ownedElement).getName().equalsIgnoreCase(ne.getName())) {
						extendedClassifiers.add(extended);
					}
					if (ownedElement instanceof SubprogramCallSequence) {
						EList<SubprogramCall> subProgCalls = ((SubprogramCallSequence) ownedElement)
								.getOwnedSubprogramCalls();
						for (SubprogramCall spc : subProgCalls) {
							if (((NamedElement) spc).getName().equalsIgnoreCase(ne.getName())) {
								extendedClassifiers.add(extended);
							}
						}
					}
				}
			}
			Classifier tempClassifier = extended;
			extended = extended.getExtended();
			if (null == extended && tempClassifier instanceof ComponentImplementation) {
				extended = ((ComponentImplementation) tempClassifier).getType();
			}
		}
		return extendedClassifiers;
	}

	private List<Classifier> getImplementedClassifiersWithElement(ComponentImplementation classifier, NamedElement ne) {
		List<Classifier> extendedClassifiers = new ArrayList<Classifier>();
		Classifier extended = classifier.getType();
		EList<Element> ownedElements = extended.getOwnedElements();
		if (null != ownedElements) {
			for (Element ownedElement : ownedElements) {
				if (ownedElement instanceof NamedElement
						&& ((NamedElement) ownedElement).getName().equalsIgnoreCase(ne.getName())) {
					extendedClassifiers.add(extended);
				}
				if (ownedElement instanceof SubprogramCallSequence) {
					EList<SubprogramCall> subProgCalls = ((SubprogramCallSequence) ownedElement)
							.getOwnedSubprogramCalls();
					for (SubprogramCall spc : subProgCalls) {
						if (((NamedElement) spc).getName().equalsIgnoreCase(ne.getName())) {
							extendedClassifiers.add(extended);
						}
					}
				}
			}
		}

		List<Classifier> extendedFromTypeClassifiers = getExtendedClassifiersWithElement(extended, ne);
		extendedClassifiers.addAll(extendedFromTypeClassifiers);
		return extendedClassifiers;
	}

	private List<NamedElement> findDupesInSameClassifier(Classifier classifier, NamedElement ne) {
		List<NamedElement> dupesInClassifier = new ArrayList<NamedElement>();
		EList<Element> oe = classifier.getOwnedElements();

		if (null != oe) {
			for (Element ownedElement : oe) {
				if (ownedElement instanceof NamedElement
						&& ((NamedElement) ownedElement).getName().equalsIgnoreCase(ne.getName())) {
					dupesInClassifier.add((NamedElement) ownedElement);
				}
				if (ownedElement instanceof SubprogramCallSequence) {
					EList<SubprogramCall> spCalls = ((SubprogramCallSequence) ownedElement).getOwnedSubprogramCalls();
					for (SubprogramCall subCall : spCalls) {
						if (subCall.getName().equalsIgnoreCase(ne.getName())) {
							dupesInClassifier.add(subCall);
						}
					}
				}
			}
		}
		return dupesInClassifier;
	}

	private EList<NamedElement> sortNamedElements(EList<NamedElement> list) {
		Collections.sort(list, new Comparator<NamedElement>() {

			@Override
			public int compare(NamedElement a, NamedElement b) {
				int aExtendCount = -1;
				Classifier aExtended = a.getContainingClassifier();
				while (null != aExtended) {
					aExtendCount++;
					if (aExtended instanceof ComponentImplementation && null == aExtended.getExtended()) {
						aExtended = ((ComponentImplementation) aExtended).getType();
					} else {
						aExtended = aExtended.getExtended();
					}
				}
				int bExtendCount = -1;
				Classifier bExtended = b.getContainingClassifier();
				while (null != bExtended) {
					bExtendCount++;
					if (bExtended instanceof ComponentImplementation && null == bExtended.getExtended()) {
						bExtended = ((ComponentImplementation) bExtended).getType();
					} else {
						bExtended = bExtended.getExtended();
					}
				}
				return aExtendCount - bExtendCount;
			}
		});
		return list;
	}

	/**
	 * check for unique names in Feature Group type
	 */
	public void checkFeatureGroupTypeUniqueNames(FeatureGroupType type) {
		// process in core package
		EList<NamedElement> l = new BasicEList<NamedElement>();
		l.addAll(type.getAllFeatures());
		l.addAll(type.getAllPrototypes());
		l = sortNamedElements(l);

		EList<NamedElement> doubles = AadlUtil.findDoubleNamedElementsInList(l);
		if (doubles.size() > 0) {
			for (NamedElement ne : doubles) {
				if (type.getOwnedElements().isEmpty() || !type.getOwnedElements().contains(ne)) {
					continue;
				}
				Classifier classifier = ne.getContainingClassifier();
				List<NamedElement> dupesInClassifier = findDupesInSameClassifier(classifier, ne);
				if (dupesInClassifier.size() > 1) {
					for (NamedElement dupeNe : dupesInClassifier) {
						error(dupeNe, "Duplicate identifiers '" + dupeNe.getName() + "' in " + classifier.getName());
					}
					continue;
				}

				List<Classifier> extendedClassifiers = getExtendedClassifiersWithElement(classifier, ne);
				if (extendedClassifiers.size() < 1) {
					continue;
				}

				NamedElement duplicated = null;
				duplicated = extendedClassifiers.get(0).findNamedElement(ne.getName());
				if ((!((duplicated instanceof AbstractFeature && ne instanceof Feature)
						|| (duplicated instanceof AbstractPrototype && ne instanceof Prototype))
						&& !ne.eClass().equals(duplicated.eClass()))
						|| ((duplicated instanceof AbstractFeature && ne instanceof Prototype)
								|| (duplicated instanceof Prototype & ne instanceof AbstractFeature))) {
					error(ne, duplicated.eClass().getName() + " identifier '" + ne.getName()
							+ "' previously defined in " + duplicated.getContainingClassifier().getName());
				} else if (((ne instanceof Feature && ((Feature) ne).getRefined() != null)
						&& (duplicated instanceof Feature && ((Feature) duplicated).getRefined() != null))
						|| ((ne instanceof Prototype && ((Prototype) ne).getRefined() != null)
								&& (duplicated instanceof Prototype
										&& ((Prototype) duplicated).getRefined() != null))) {
					continue;
				} else if (((ne instanceof Feature && ((Feature) ne).getRefined() != null)
						&& (duplicated instanceof Feature && ((Feature) duplicated).getRefined() == null))
						|| ((ne instanceof Prototype && ((Prototype) ne).getRefined() != null)
								&& (duplicated instanceof Prototype
										&& ((Prototype) duplicated).getRefined() == null))) {
					continue;
				} else {
					postRefineableErrorWithFix(ne, duplicated);
				}
			}
		}
	}

	/*
	 * supporting semantic check methods They can on the error reporter thus
	 * reside in here
	 */

	/**
	 * Checks legality rule 3 in section 4.2 (Packages) on page 32. "A component
	 * implementation may be declared in both the public and private part of a
	 * package. In that case the declaration in the public part may only contain
	 * a properties subclause and a modes subclause."
	 *
	 * Checks semantic rule 9 in section 4.2 (Packages) on page 33. "A component
	 * implementation can be declared in both the public and private section of
	 * a package. If it is declared in both, then the public declaration is
	 * limited to containing property associations and modes and only those
	 * items are visible outside the package. This allows component
	 * implementation to be made visible to other packages as variants of the
	 * same component type, while the details of the implementation, i.e., its
	 * realization expressed by the subcomponents and connections subclauses,
	 * are hidden in the private part. The two declarations represent the same
	 * component implementation.
	 */
	private void checkComponentImplementationInPackageSection(ComponentImplementation componentImplementation) {
		if (componentImplementation.getOwner() instanceof PublicPackageSection
				&& ((AadlPackage) componentImplementation.getElementRoot()).getPrivateSection() != null
				&& ((AadlPackage) componentImplementation.getElementRoot()).getPrivateSection()
						.findNamedElement(componentImplementation.getName()) instanceof ComponentImplementation) {
			for (EObject child : componentImplementation.getOwnedElements()) {
				if (child instanceof ClassifierFeature && !(child instanceof ModeFeature)) {
					error("When a component implementation is declared in both the public section and the private"
							+ " section of a package, the implementation declaration in the public section can only contain a"
							+ " properties subclause and a modes subclause.", child,
							Aadl2Package.eINSTANCE.getComponentClassifier_OwnedMode());
				}
			}
		}
	}

	/**
	 * Checks that the category of the component type rename is identical to the
	 * category of the specified component type. This requirement is not in the
	 * standard yet. Peter has been informed and it should be in a future
	 * errata.
	 */
	private void checkComponentTypeRenameCategory(ComponentTypeRename componentTypeRename) {
		if (Aadl2Util.isNull(componentTypeRename.getRenamedComponentType())) {
			return;
		}
		if (!componentTypeRename.getCategory().equals(componentTypeRename.getRenamedComponentType().getCategory())) {
			String wrongCategoryName = componentTypeRename.getCategory().getName();
			String rightCategoryName = componentTypeRename.getRenamedComponentType().getCategory().getName();
			String offset = "" + findKeywordOffset(componentTypeRename, wrongCategoryName);
			error("The category of '" + componentTypeRename.getRenamedComponentType().getQualifiedName() + "' is not "
					+ componentTypeRename.getCategory().getName(), componentTypeRename, null, GENERIC_TEXT_REPLACEMENT,
					wrongCategoryName, rightCategoryName, offset);
		}
	}

	/**
	 * Checks legality rule 3 in section 4.3 (Component Types) on page 36. "The
	 * category of the component type being extended must match the category of
	 * the extending component type, i.e., they must be identical or the
	 * category being extended must be abstract."
	 */
	private void checkTypeExtensionCategory(TypeExtension typeExtension) {
		ComponentType parent = typeExtension.getExtended();
		ComponentType child = (ComponentType) typeExtension.getSpecific();
		if (!canExtend(parent, child)) {
			String changeFrom = child.getCategory().getName();
			String changeTo = parent.getCategory().getName();
			String offset = "" + findKeywordOffset(child, changeFrom);
			error("Cannot extend '" + parent.getQualifiedName() + "'.  Incompatible categories.", child, null,
					GENERIC_TEXT_REPLACEMENT, changeFrom, changeTo, offset);
		}
	}

	private String nodeSearchString(String changeFrom) {
		int spaceIndex = changeFrom.indexOf(" ");
		if (spaceIndex < 0) {
			return changeFrom;
		} else {
			return changeFrom.substring(0, spaceIndex);
		}
	}

	/**
	 * Checks legality rule 5 in section 4.3 (Component Types) on page 36.
	 * "A component type must not contain both a requires_modes_subcluase and a modes_subclause."
	 *
	 * Checks legality rule 6 in section 4.3 (Component Types) on page 36. "If
	 * the extended component type and an ancestor component type in the extends
	 * hierarchy contain modes subclauses, they must both be
	 * requires_modes_subclause or modes_subclause."
	 */
	private void checkComponentTypeModes(ComponentType componentType) {
		boolean containsModes = false;
		boolean containsRequiresModes = false;
		if (hasExtendCycles(componentType)) {
			return;
		}
		for (ComponentType currentType = componentType; currentType != null; currentType = currentType.getExtended()) {
			for (Mode currentMode : currentType.getOwnedModes()) {
				if (currentMode.isDerived()) {
					containsRequiresModes = true;
				} else {
					containsModes = true;
				}
			}
		}
		if (containsModes && containsRequiresModes) {
			error(componentType, "Component types cannot contain both modes and requires modes.");
		}
	}

	/**
	 * Checks naming rule 6 in section 4.4 (Component Implementations) on page
	 * 41. "In a component implementation extension, the component type
	 * identifier of the component implementation being extended, which appears
	 * after the reserved word extends, must be the same as or an ancestor of
	 * the component type of the extension. The component implementation being
	 * extended may exist in another package. In this case the component
	 * implementation name is qualified with the package name."
	 */
	private void checkExtensionAndRealizationHierarchy(ImplementationExtension implementationExtension) {
		ComponentImplementation parent = implementationExtension.getExtended();
		ComponentImplementation child = (ComponentImplementation) implementationExtension.getSpecific();
		ComponentType typeOfParent = parent.getType();
		ComponentType typeOfChild = child.getType();
		boolean isAncestor = false;
		if (Aadl2Util.isNull(typeOfParent)) {
			return;
		}
		if (Aadl2Util.isNull(typeOfChild)) {
			return;
		}
		if (hasExtendCycles(typeOfChild)) {
			return;
		}
		for (ComponentType currentType = typeOfChild; currentType != null
				&& !isAncestor; currentType = currentType.getExtended()) {
			if (currentType.equals(typeOfParent)) {
				isAncestor = true;
			}
		}
		if (!isAncestor) {
			error(implementationExtension, '\'' + typeOfParent.getQualifiedName() + "' is not an ancestor of '"
					+ typeOfChild.getQualifiedName() + "'.");
		}
	}

	/**
	 * Checks legality rule 3 in section 4.4 (Component Implementations) on page
	 * 42. "The category of the component implementation must be identical to
	 * the category of the component type for which the component implementation
	 * is declared."
	 */
	private void checkRealizationCategory(Realization realization) {
		ComponentType type = realization.getImplemented();
		if (Aadl2Util.isNull(type)) {
			return; // unresolved type. has been reported already as such. no
					// need to check category
		}
		ComponentImplementation implementation = (ComponentImplementation) realization.getSpecific();
		if (!type.getCategory().equals(implementation.getCategory())) {
			String changeFrom = implementation.getCategory().getName();
			String changeTo = type.getCategory().getName();
			String offset = "" + findKeywordOffset(implementation, changeFrom);
			error("The category of '" + type.getQualifiedName() + "' is not " + implementation.getCategory() + ".",
					realization, null, GENERIC_TEXT_REPLACEMENT, changeFrom, changeTo, offset);
		}
	}

	/**
	 * Checks legality rule 4 in section 4.4 (Component Implementation) on page
	 * 42. "If the component implementation extends another component
	 * implementation, the category of both must match, i.e., they must be
	 * identical or the category being extended must be abstract."
	 */
	private void checkImplementationExtensionCategory(ImplementationExtension implementationExtension) {
		ComponentImplementation parent = implementationExtension.getExtended();
		ComponentImplementation child = (ComponentImplementation) implementationExtension.getSpecific();
		if (!canExtend(parent, child)) {
			String changeFrom = child.getCategory().getName();
			String changeTo = parent.getCategory().getName();
			String offset = "" + findKeywordOffset(child, changeFrom);

			error("Cannot extend '" + parent.getQualifiedName() + "'.  Incompatible categories.", child, null,
					GENERIC_TEXT_REPLACEMENT, changeFrom, changeTo, offset);
		}
	}

	/**
	 * Checks legality rule 6 in section 4.4 (Component Implementations) on page
	 * 42. "If the component type of the component implementation contains a
	 * requires_modes_subclause then the component implementation must not
	 * contain any modes subclause."
	 *
	 * Checks legality rule 7 in section 4.4 (Component Implementations) on page
	 * 42. "If modes are declared in the component type, then modes cannot be
	 * declared in component implementations."
	 */
	private void checkComponentImplementationModes(ComponentImplementation componentImplementation) {
		if (!componentImplementation.getOwnedModes().isEmpty()) {
			boolean typeHasModes = false;
			if (hasExtendCycles(componentImplementation.getType())) {
				return;
			}
			for (ComponentType currentType = componentImplementation.getType(); currentType != null
					&& !typeHasModes; currentType = currentType.getExtended()) {
				if (!currentType.getOwnedModes().isEmpty()) {
					typeHasModes = true;
				}
			}
			if (typeHasModes) {
				error(componentImplementation,
						"Implementation cannot contain modes because modes or requires modes are inherited from the type.");
			}
		}
	}

	/**
	 * Checks legality rule 9 in section 4.4 (Component Implementations) on page
	 * 42. "The category of a subcomponent being refined must match the category
	 * of the refining subcomponent declaration, i.e., they must be identical or
	 * the category being refined must be abstract."
	 *
	 * Checks legality rule 3 in section 4.5 (Subcomponents) on page 47. "In a
	 * subcomponent refinement declaration the component category may be refined
	 * from abstract to one of the concrete component categories. Otherwise the
	 * category must be the same as that of the subcomponent being refined."
	 */
	private void checkSubcomponentRefinementCategory(Subcomponent subcomponent) {
		ComponentCategory subcomponentCategory = subcomponent.getCategory();
		if (subcomponent.getRefined() != null) {
			ComponentCategory refinedCategory = subcomponent.getRefined().getCategory();
			if (!subcomponentCategory.equals(refinedCategory) && !refinedCategory.equals(ComponentCategory.ABSTRACT)) {

				String changeFrom = subcomponentCategory.getName();
				String changeTo = refinedCategory.getName();
				String offset = "" + findKeywordOffset(subcomponent, changeFrom);
				error("Cannot refine subcomponent.  Incompatible categories.", subcomponent, null,
						GENERIC_TEXT_REPLACEMENT, changeFrom, changeTo, offset);
			}
		}
	}

	/**
	 * Checks legality rule 1 in section 4.5 (Subcomponents) on page 47. "The
	 * category of the subcomponent declaration must match the category of its
	 * corresponding component classifier reference or its prototype reference,
	 * i.e., they must be identical, or in the case of a classifier reference
	 * the referenced classifier category may be abstract."
	 */
	private void checkSubcomponentCategory(Subcomponent subcomponent) {
		ComponentCategory subcomponentCategory = subcomponent.getCategory();
		ComponentClassifier componentClassifier = subcomponent.getClassifier();
		ComponentPrototype componentPrototype = subcomponent.getPrototype();
		if (componentClassifier != null) {
			if (!subcomponentCategory.equals(componentClassifier.getCategory())
					&& !componentClassifier.getCategory().equals(ComponentCategory.ABSTRACT)) {
				error(subcomponent,
						"The category of the subcomponent is incompatible with the category of the classifier");
			}
		} else if (componentPrototype != null) {
			if (!subcomponentCategory.equals(getComponentPrototypeCategory(componentPrototype))) {
				error(subcomponent,
						"The category of the subcomponent is incompatible with the category of the prototype");
			}
		}
	}

	/**
	 * Checks legality rule 7 in section 4.6 (Abstract Components) on page 53.
	 * "If an abstract component type is refined to a concrete category, the
	 * features of the abstract component type must be acceptable for the
	 * concrete component type."
	 */
	private void checkFeaturesOfExtendedAbstractType(ComponentType componentType) {
		ComponentCategory typeCategory = null;
		if (componentType instanceof AbstractType) {
			return;
		} else if (componentType instanceof DataType) {
			typeCategory = ComponentCategory.DATA;
		} else if (componentType instanceof SubprogramType) {
			typeCategory = ComponentCategory.SUBPROGRAM;
		} else if (componentType instanceof SubprogramGroupType) {
			typeCategory = ComponentCategory.SUBPROGRAM_GROUP;
		} else if (componentType instanceof ThreadType) {
			typeCategory = ComponentCategory.THREAD;
		} else if (componentType instanceof ThreadGroupType) {
			typeCategory = ComponentCategory.THREAD_GROUP;
		} else if (componentType instanceof ProcessType) {
			typeCategory = ComponentCategory.PROCESS;
		} else if (componentType instanceof ProcessorType) {
			typeCategory = ComponentCategory.PROCESSOR;
		} else if (componentType instanceof VirtualProcessorType) {
			typeCategory = ComponentCategory.VIRTUAL_PROCESSOR;
		} else if (componentType instanceof MemoryType) {
			typeCategory = ComponentCategory.MEMORY;
		} else if (componentType instanceof BusType) {
			typeCategory = ComponentCategory.BUS;
		} else if (componentType instanceof VirtualBusType) {
			typeCategory = ComponentCategory.VIRTUAL_BUS;
		} else if (componentType instanceof DeviceType) {
			typeCategory = ComponentCategory.DEVICE;
		} else if (componentType instanceof SystemType) {
			typeCategory = ComponentCategory.SYSTEM;
		}
		Set<FeatureType> acceptableFeatureTypes = acceptableFeaturesForTypes.get(typeCategory);
		HashSet<FeatureType> typesOfInheritedFeatures = new HashSet<FeatureType>();
		if (hasExtendCycles(componentType)) {
			return;
		}
		for (ComponentType parent = componentType.getExtended(); parent instanceof AbstractType; parent = parent
				.getExtended()) {
			for (Feature feature : parent.getOwnedFeatures()) {
				typesOfInheritedFeatures.add(getFeatureType(feature));
			}
		}
		for (FeatureType featureType : typesOfInheritedFeatures) {
			if (!acceptableFeatureTypes.contains(featureType)) {

				String changeFrom = typeCategory.getName();
				String offset = "" + findKeywordOffset(componentType, changeFrom);
				error("A " + changeFrom + " type cannot extend an abstract type that contains "
						+ featureType.getNameWithIndefiniteArticle() + '.', componentType.getOwnedExtension(), null,
						GENERIC_TEXT_REPLACEMENT, changeFrom, ComponentCategory.ABSTRACT.toString(), offset);

			}
		}
	}

	/**
	 * Checks legality rule 8 in section 4.6 (Abstract Components) on page 53.
	 * "If an abstract component implementation is refined to a concrete
	 * category, the subcomponents of the abstract component implementation must
	 * be acceptable for the concrete component implementation."
	 */
	private void checkSubcomponentsOfExtendedAbstractImplementation(ComponentImplementation componentImplementation) {
		ComponentCategory implementationCategory = null;
		if (componentImplementation instanceof AbstractImplementation) {
			return;
		} else if (componentImplementation instanceof DataImplementation) {
			implementationCategory = ComponentCategory.DATA;
		} else if (componentImplementation instanceof SubprogramImplementation) {
			implementationCategory = ComponentCategory.SUBPROGRAM;
		} else if (componentImplementation instanceof SubprogramGroupImplementation) {
			implementationCategory = ComponentCategory.SUBPROGRAM_GROUP;
		} else if (componentImplementation instanceof ThreadImplementation) {
			implementationCategory = ComponentCategory.THREAD;
		} else if (componentImplementation instanceof ThreadGroupImplementation) {
			implementationCategory = ComponentCategory.THREAD_GROUP;
		} else if (componentImplementation instanceof ProcessImplementation) {
			implementationCategory = ComponentCategory.PROCESS;
		} else if (componentImplementation instanceof ProcessorImplementation) {
			implementationCategory = ComponentCategory.PROCESSOR;
		} else if (componentImplementation instanceof VirtualProcessorImplementation) {
			implementationCategory = ComponentCategory.VIRTUAL_PROCESSOR;
		} else if (componentImplementation instanceof MemoryImplementation) {
			implementationCategory = ComponentCategory.MEMORY;
		} else if (componentImplementation instanceof BusImplementation) {
			implementationCategory = ComponentCategory.BUS;
		} else if (componentImplementation instanceof VirtualBusImplementation) {
			implementationCategory = ComponentCategory.VIRTUAL_BUS;
		} else if (componentImplementation instanceof DeviceImplementation) {
			implementationCategory = ComponentCategory.DEVICE;
		} else if (componentImplementation instanceof SystemImplementation) {
			implementationCategory = ComponentCategory.SYSTEM;
		}
		Set<ComponentCategory> acceptableSubcomponentCategories = acceptableSubcomponentCategoriesForImplementations
				.get(implementationCategory);
		HashSet<ComponentCategory> categoriesOfInheritedSubcomponents = new HashSet<ComponentCategory>();
		if (hasExtendCycles(componentImplementation)) {
			return;
		}
		for (ComponentImplementation parent = componentImplementation
				.getExtended(); parent instanceof AbstractImplementation; parent = parent.getExtended()) {
			for (Subcomponent subcomponent : parent.getOwnedSubcomponents()) {
				categoriesOfInheritedSubcomponents.add(subcomponent.getCategory());
			}
		}
		for (ComponentCategory subcomponentCategory : categoriesOfInheritedSubcomponents) {
			if (!acceptableSubcomponentCategories.contains(subcomponentCategory)) {
				error(componentImplementation.getOwnedExtension(),
						"A " + implementationCategory.getName()
								+ " implementation cannot extend an abstract implementation that contains a "
								+ subcomponentCategory.getName() + " subcomponent.");
			}
		}
	}

	private void checkSubcomponentImplementationReferenceList(Subcomponent subcomponent) {

		EList<ComponentImplementationReference> impReferences = subcomponent.getImplementationReferences();
		if (impReferences != null && !impReferences.isEmpty()) {
			warning(subcomponent, "List of implementation reference not fully implemented in instantiator.");
			ComponentClassifier classifier = subcomponent.getClassifier();

			if (!(null != classifier && classifier instanceof ComponentType)) {
				error(subcomponent,
						"Implementation reference list not allowed when the subcomponent classifier is not a component type.");
				return;
			}
			ComponentType componentType = subcomponent.getComponentType();

			for (ComponentImplementationReference nextReference : impReferences) {
				ComponentType refType = nextReference.getImplementation().getType();
				if (!componentType.equals(refType)) {
					error(nextReference, "Implementation reference not of the specified type.");
				}
			}

			List<ArrayDimension> arrayDimensions = subcomponent.getArrayDimensions();

			long arrayProduct = 0;
			for (ArrayDimension dimension : arrayDimensions) {

				long dimensionSize = 0;
				if (dimension == null || dimension.getSize() == null) {
					return;
				} else if (dimension.getSize().getSize() != 0) {
					dimensionSize = dimension.getSize().getSize();
				} else if (dimension.getSize().getSizeProperty() == null) {
					return;
				} else {
					// look up property, if not valid then return
					ArraySizeProperty asp = dimension.getSize().getSizeProperty();
					if (asp instanceof PropertyConstant) {
						PropertyConstant pc = (PropertyConstant) asp;
						PropertyExpression cv = pc.getConstantValue();
						if (cv instanceof IntegerLiteral) {
							dimensionSize = ((IntegerLiteral) cv).getValue();
						}
					} else if (asp instanceof Property) {
						error(dimension,
								"Array size cannot be a property if implementation reference list is defined.");
						return;
					}
				}

				if (dimensionSize < 1) {
					return;
				} else {
					if (arrayProduct == 0) {
						arrayProduct++;
					}
					arrayProduct = arrayProduct * dimensionSize;
				}
			}
			if (impReferences.size() != arrayProduct) {
				if (arrayDimensions.size() == 1) {
					String changeFrom = "" + arrayDimensions.get(0).getSize().getSize();
					String changeTo = "" + impReferences.size();

					error("Size of component implementation reference list not the same as array size.", subcomponent,
							null, ARRAY_SIZE_NOT_EQUAL_REFERENCE_LIST_SIZE, changeFrom, changeTo);
				} else {
					error(subcomponent, "Size of component implementation reference list not the same as array size.");
				}
			}
		}
	}

	/**
	 * Checks legality rule 7 in section 4.6 (Abstract Components) on page 53.
	 * "If an abstract component type is refined to a concrete category, the
	 * features of the abstract component type must be acceptable for the
	 * concrete component type."
	 *
	 * Checks legality rule 8 in section 4.6 (Abstract Components) on page 53.
	 * "If an abstract component implementation is refined to a concrete
	 * category, the subcomponents of the abstract component implementation must
	 * be acceptable for the concrete component implementation." Note: this also
	 * covers rule L5 in section 4.6.
	 */
	private void checkSubcomponentsHierarchy(Subcomponent subcomponent) {
		if (subcomponent.getCategory().equals(ComponentCategory.ABSTRACT)) {
			return;
		}
		Subcomponent refinedSubcomponent = subcomponent;
		while (refinedSubcomponent.getClassifier() == null && refinedSubcomponent.getPrototype() == null
				&& refinedSubcomponent.getRefined() != null) {
			refinedSubcomponent = refinedSubcomponent.getRefined();
		}
		if (refinedSubcomponent.getClassifier() instanceof AbstractImplementation) {
			Set<ComponentCategory> acceptableSubcomponentCategories = acceptableSubcomponentCategoriesForImplementations
					.get(subcomponent.getCategory());
			HashSet<ComponentCategory> categoriesOfNestedSubcomponents = new HashSet<ComponentCategory>();
			if (hasExtendCycles(refinedSubcomponent.getClassifier())) {
				return;
			}
			for (ComponentImplementation impl = (ComponentImplementation) refinedSubcomponent
					.getClassifier(); impl instanceof AbstractImplementation; impl = impl.getExtended()) {
				for (Subcomponent nestedSubcomponent : impl.getOwnedSubcomponents()) {
					categoriesOfNestedSubcomponents.add(nestedSubcomponent.getCategory());
				}
			}
			for (ComponentCategory nestedSubcomponentCategory : categoriesOfNestedSubcomponents) {
				if (!acceptableSubcomponentCategories.contains(nestedSubcomponentCategory)) {
					String changeFrom = subcomponent.getCategory().getName();
					String offset = "" + findKeywordOffset(subcomponent, changeFrom);
					error("A " + subcomponent.getCategory().getName()
							+ " subcomponent cannot refer to an abstract implementation that contains a "
							+ nestedSubcomponentCategory.getName() + " subcomponent.", subcomponent, null,
							GENERIC_TEXT_REPLACEMENT, changeFrom, ComponentCategory.ABSTRACT.toString(), offset);
				}
			}
		}
		AbstractType abstractType;
		if (refinedSubcomponent.getClassifier() instanceof AbstractType) {
			abstractType = (AbstractType) refinedSubcomponent.getClassifier();
		} else if (refinedSubcomponent.getClassifier() instanceof AbstractImplementation &&
		// This second part of this if expression will not be false for
		// semantically correct models.
				((AbstractImplementation) refinedSubcomponent.getClassifier()).getOwnedRealization()
						.getImplemented() instanceof AbstractType) {
			abstractType = ((AbstractImplementation) refinedSubcomponent.getClassifier()).getType();
		} else {
			abstractType = null;
		}
		if (abstractType != null) {
			Set<FeatureType> acceptableFeatureTypes = acceptableFeaturesForTypes.get(subcomponent.getCategory());
			HashSet<FeatureType> typesOfNestedFeatures = new HashSet<FeatureType>();
			if (hasExtendCycles(abstractType)) {
				return;
			}
			for (ComponentType type = abstractType; type instanceof AbstractType; type = type.getExtended()) {
				for (Feature nestedFeature : type.getOwnedFeatures()) {
					typesOfNestedFeatures.add(getFeatureType(nestedFeature));
				}
			}
			for (FeatureType nestedFeatureType : typesOfNestedFeatures) {
				if (!acceptableFeatureTypes.contains(nestedFeatureType)) {
					String changeFrom = subcomponent.getCategory().getName();
					String offset = "" + findKeywordOffset(subcomponent, changeFrom);
					error("A " + subcomponent.getCategory().getName()
							+ " subcomponent cannot refer to an abstract type that contains "
							+ nestedFeatureType.getNameWithIndefiniteArticle() + '.', subcomponent, null,
							GENERIC_TEXT_REPLACEMENT, changeFrom, ComponentCategory.ABSTRACT.toString(), offset);
				}
			}
		}
	}

	/**
	 * Checks that the category of the prototype is identical to the category of
	 * the specified component classifier. Rule L2 in section 4.7 (revised
	 * AADLV2) "The component category of the optional component classifier
	 * reference in the component prototype declaration must match the category
	 * in the prototype declaration."
	 */
	private void checkComponentPrototypeCategory(ComponentPrototype prototype) {
		if (prototype.getConstrainingClassifier() != null && !getComponentPrototypeCategory(prototype)
				.equals(prototype.getConstrainingClassifier().getCategory())) {

			String changeFrom = getComponentPrototypeCategory(prototype).getName();
			String changeTo = prototype.getConstrainingClassifier().getCategory().getName();
			String offset = "" + findKeywordOffset(prototype, changeFrom);

			error("The category of '" + prototype.getConstrainingClassifier().getQualifiedName() + "' is not "
					+ getComponentPrototypeCategory(prototype).getName(), prototype, null, GENERIC_TEXT_REPLACEMENT,
					changeFrom, changeTo, offset);
		}
	}

	/**
	 * Checks legality rule 1 in section 4.7 (Prototypes) on page 56. "The
	 * component category declared in the component prototype binding must match
	 * the component category of the prototype, or the declared category
	 * component category of the prototype must be abstract."
	 */
	private void checkComponentPrototypeBindingCategory(ComponentPrototypeBinding binding) {
		if (binding.getFormal() instanceof ComponentPrototype) {
			ComponentCategory formalCategory = getComponentPrototypeCategory((ComponentPrototype) binding.getFormal());
			if (!formalCategory.equals(ComponentCategory.ABSTRACT)) {
				for (ComponentPrototypeActual actual : binding.getActuals()) {
					if (!formalCategory.equals(actual.getCategory())) {
						String changeFrom = actual.getCategory().getName();
						String changeTo = formalCategory.getName();
						String offset = "" + findKeywordOffset(binding, changeFrom);

						error("The category of the formal prototype is not compatible with the category specified in the"
								+ " prototype binding.", actual, null, GENERIC_TEXT_REPLACEMENT, changeFrom, changeTo,
								offset);
					}
				}
			}
		}
	}

	/**
	 * Checks legality rule 10 in section 4.7 (Prototypes) on page 56. "(L10)
	 * The component category of the classifier reference or prototype reference
	 * in a prototype binding declaration must match the category of the
	 * prototype."
	 */
	private void checkComponentPrototypeActualComponentCategory(ComponentPrototypeActual actual) {
		if (actual.eIsProxy()) {
			error(actual, "The prototype actual could not be found.");
		} else {
			SubcomponentType st = actual.getSubcomponentType();
			if (st == null) {
				error(actual, "The classifier or prototype of the prototype actual could not be found.");
			} else if (!actual.getCategory().equals(ComponentCategory.ABSTRACT) && !actual.getCategory()
					.equals(st instanceof ComponentClassifier ? ((ComponentClassifier) st).getCategory()
							: getComponentPrototypeCategory((ComponentPrototype) st))) {
				ComponentCategory componentCategory = st instanceof ComponentClassifier
						? ((ComponentClassifier) st).getCategory()
						: getComponentPrototypeCategory((ComponentPrototype) st);
				String changeFrom = actual.getCategory().getName();
				String changeTo = componentCategory.getName();
				String offset = "" + findKeywordOffset(actual, changeFrom);

				error("The category of the referenced classifier is not compatible the category specified in the prototype binding.",
						actual, null, GENERIC_TEXT_REPLACEMENT, changeFrom, changeTo, offset);
			}
		}
	}

	/**
	 * Checks legality rule 6 in section 4.7 (Prototypes) on page 56. "If the
	 * direction is declared for feature prototypes, then the prototype actual
	 * satisfies the direction according to the same rules as for feature
	 * refinements (see Section 8); in the case of ports the direction must be
	 * in or out; in the case of data access, the access right must be read-only
	 * for in and write-only for out; in the case of bus access, subprogram
	 * access and subprogram group access the direction must not be in nor out."
	 * Peter is going to change the wording of this to make parts of it less
	 * restrictive.
	 *
	 * Checks legality rule 11 in section 4.7 (Prototypes) on page 57. "(L11) If
	 * a direction is specified for an abstract feature in a prototype
	 * declaration, then the direction of the prototype actual must match that
	 * declared in the prototype."
	 */
	private void checkFeaturePrototypeBindingDirection(FeaturePrototypeBinding binding) {
		if (binding.getFormal() instanceof FeaturePrototype) {
			DirectionType formalDirection = ((FeaturePrototype) binding.getFormal()).getDirection();
			if (formalDirection != null && !formalDirection.equals(DirectionType.IN_OUT)
					&& !(binding.getActual() instanceof AccessSpecification)) {
				DirectionType actualDirection;
				if (binding.getActual() instanceof FeaturePrototypeReference) {
					actualDirection = ((FeaturePrototypeReference) binding.getActual()).getDirection();
				} else {
					actualDirection = ((PortSpecification) binding.getActual()).getDirection();
				}
				if (!formalDirection.equals(DirectionType.IN_OUT) && !formalDirection.equals(actualDirection)) {
					String changeFrom = actualDirection.toString();
					String changeTo = formalDirection.toString();
					error("The direction specified in the binding is inconsistent with the direction of the formal prototype.",
							binding, null, PROTOTYPE_BINDING_DIRECTION_NOT_CONSISTENT_WITH_FORMAL, changeFrom,
							changeTo);
				}
			}
		}
	}

	/**
	 * Checks that the formal prototype of a ComponentPrototypeBinding is a
	 * ComponentPrototype. Rule L12 in Section 4.7.
	 */
	private void checkFormalOfComponentPrototypeBinding(ComponentPrototypeBinding binding) {
		Prototype formal = binding.getFormal();
		// formal might be null or a proxy if it could not be resolved.
		// in that case that is already reported.
		if (!Aadl2Util.isNull(formal) && !(binding.getFormal() instanceof ComponentPrototype)) {
			error(binding, '\'' + binding.getFormal().getName() + "' is not a component prototype.");
		}
	}

	/**
	 * Checks that the formal prototype of a FeatureGroupPrototypeBinding is a
	 * FeatureGroupPrototype. Rule L12 in Section 4.7.
	 */
	private void checkFormalOfFeatureGroupPrototypeBinding(FeatureGroupPrototypeBinding binding) {
		if (!(binding.getFormal() instanceof FeatureGroupPrototype)) {
			error(binding, '\'' + binding.getFormal().getName() + "' is not a feature group prototype.");
		}
	}

	/**
	 * Checks that the formal prototype of a FeaturePrototypeBinding is a
	 * FeaturePrototype. Rule L12 in Section 4.7.
	 */
	private void checkFormalOfFeaturePrototypeBinding(FeaturePrototypeBinding binding) {
		if (!(binding.getFormal() instanceof FeaturePrototype)) {
			error(binding, '\'' + binding.getFormal().getName() + "' is not a feature prototype.");
		}
	}

	/**
	 * Checks that component prototype refinements only refine component
	 * prototypes. Rule L13 in Section 4.7.
	 */
	private void checkRefinedOfComponentPrototype(ComponentPrototype prototype) {
		if (prototype.getRefined() != null && !(prototype.getRefined() instanceof ComponentPrototype)) {
			error(prototype, '\'' + prototype.getName() + "' is not a component prototype.");
		}
	}

	/**
	 * Checks that feature group prototype refinements only refine feature group
	 * prototypes. Rule L12 in Section 4.7.
	 */
	private void checkRefinedOfFeatureGroupPrototype(FeatureGroupPrototype prototype) {
		if (prototype.getRefined() != null && !(prototype.getRefined() instanceof FeatureGroupPrototype)) {
			error(prototype, '\'' + prototype.getName() + "' is not a feature group prototype.");
		}
	}

	/**
	 * Checks that feature prototype refinements only refine feature prototypes.
	 * Rule L12 in Section 4.7.
	 */
	private void checkRefinedOfFeaturePrototype(FeaturePrototype prototype) {
		if (prototype.getRefined() != null && !(prototype.getRefined() instanceof FeaturePrototype)) {
			error(prototype, '\'' + prototype.getName() + "' is not a feature prototype.");
		}
	}

	/**
	 * Checks semantic rule 6 in section 4.7 (Prototypes) on page 57. "A
	 * prototype refinement can increase the constraints on classifiers to be
	 * supplied. The newly specified category, classifier, and array dimensions
	 * must satisfy the same matching rules as the prototype bindings." This
	 * method checks the component category only.
	 */
	private void checkCategoryOfRefinedComponentPrototype(ComponentPrototype prototype) {
		if (prototype.getRefined() != null && prototype.getRefined() instanceof ComponentPrototype) {
			ComponentCategory refinedPrototypeCategory = getComponentPrototypeCategory(
					(ComponentPrototype) prototype.getRefined());
			if (!refinedPrototypeCategory.equals(ComponentCategory.ABSTRACT)
					&& !refinedPrototypeCategory.equals(getComponentPrototypeCategory(prototype))) {

				ComponentCategory prototypeCategory = getComponentPrototypeCategory(prototype);
				String changeFrom = prototypeCategory.getName();
				String changeTo = refinedPrototypeCategory.getName();
				String offset = "" + findKeywordOffset(prototype, changeFrom);
				error("Incompatible category for prototype refinement.", prototype, null, GENERIC_TEXT_REPLACEMENT,
						changeFrom, changeTo, offset);
			}
		}
	}

	/**
	 * Checks semantic rule 6 in section 4.7 (Prototypes) on page 57. "A
	 * prototype refinement can increase the constraints on classifiers to be
	 * supplied. The newly specified category, classifier, and array dimensions
	 * must satisfy the same matching rules as the prototype bindings." This
	 * method checks for array compatibility only.
	 */
	private void checkArrayOfRefinedComponentPrototype(ComponentPrototype prototype) {
		if (prototype.getRefined() != null && prototype.getRefined() instanceof ComponentPrototype) {
			ComponentPrototype refinedPrototype = (ComponentPrototype) prototype.getRefined();
			if (refinedPrototype.isArray() && !prototype.isArray()) {
				error("Prototype must be an array because the refined prototype is an array.", prototype, null,
						PROTOTYPE_NOT_ARRAY);
			}
		}
	}

	/**
	 * Checks semantic rule 6 in section 4.7 (Prototypes) on page 57. "A
	 * prototype refinement can increase the constraints on classifiers to be
	 * supplied. The newly specified category, classifier, and array dimensions
	 * must satisfy the same matching rules as the prototype bindings." This
	 * method checks for feature direction only.
	 */
	private void checkDirectionOfRefinedFeaturePrototype(FeaturePrototype prototype) {
		if (prototype.getRefined() != null && prototype.getRefined() instanceof FeaturePrototype) {
			DirectionType refinedPrototypeDirection = ((FeaturePrototype) prototype.getRefined()).getDirection();
			if (refinedPrototypeDirection != null && !refinedPrototypeDirection.equals(DirectionType.IN_OUT)
					&& !refinedPrototypeDirection.equals(prototype.getDirection())) {

				String changeFrom = "";
				String changeTo = "";
				if (prototype.getDirection().equals(DirectionType.IN_OUT)) {
					changeFrom = "feature";
					changeTo = refinedPrototypeDirection.toString() + " feature";
				} else {
					changeFrom = prototype.getDirection().toString();
					changeTo = refinedPrototypeDirection.toString();
				}
				error("Incompatible direction for prototype refinement.", prototype, null,
						INCOMPATIBLE_DIRECTION_FOR_PROTOTYPE_REFINEMENT, changeFrom, changeTo);
			}
		}
	}

	/**
	 * Checks legality rule 2 in section 5.1 (Data) on page 62.
	 * "A data type declaration must not contain a flow specification or modes subclause."
	 * This rule is partly checked by the parser. This method checks for
	 * inherited members from an AbstractType.
	 */
	private void checkForInheritedFlowsAndModesFromAbstractType(DataType dataType) {
		boolean parentHasFlowSpecs = false;
		boolean parentHasModes = false;
		boolean parentHasModeTransitions = false;
		if (hasExtendCycles(dataType)) {
			return;
		}
		for (ComponentType parentType = dataType
				.getExtended(); parentType instanceof AbstractType; parentType = parentType.getExtended()) {
			if (!parentType.getOwnedFlowSpecifications().isEmpty()) {
				parentHasFlowSpecs = true;
			}
			if (!parentType.getOwnedModes().isEmpty()) {
				parentHasModes = true;
			}
			if (!parentType.getOwnedModeTransitions().isEmpty()) {
				parentHasModeTransitions = true;
			}
		}

		String changeFrom = dataType.getCategory().getName();
		String offset = "" + findKeywordOffset(dataType, changeFrom);

		if (parentHasFlowSpecs) {
			error("A data type cannot extend an abstract type that contains a flow specification.",
					dataType.getOwnedExtension(), null, GENERIC_TEXT_REPLACEMENT, changeFrom,
					ComponentCategory.ABSTRACT.toString(), offset);
		}
		if (parentHasModes) {
			error("A data type cannot extend an abstract type that contains modes.", dataType.getOwnedExtension(), null,
					GENERIC_TEXT_REPLACEMENT, changeFrom, ComponentCategory.ABSTRACT.toString(), offset);
		}
		if (parentHasModeTransitions) {
			error("A data type cannot extend an abstract type that contains a mode transition.",
					dataType.getOwnedExtension(), null, GENERIC_TEXT_REPLACEMENT, changeFrom,
					ComponentCategory.ABSTRACT.toString(), offset);
		}
	}

	/**
	 * Checks legality rule 4 in section 5.1 (Data) on page 62. "A data
	 * implementation must not contain a flow implementation, an end-to-end flow
	 * specification, or a modes subclause." This rule is partly checked by the
	 * parser. This method checks for inherited members from an
	 * AbstractImplementation.
	 */
	private void checkForInheritedFlowsAndModesFromAbstractImplementation(DataImplementation dataImplementation) {
		boolean parentHasFlowImpl = false;
		boolean parentHasETEFlow = false;
		boolean parentHasModes = false;
		boolean parentHasModeTransition = false;
		if (hasExtendCycles(dataImplementation)) {
			return;
		}
		for (ComponentImplementation parentImplementation = dataImplementation
				.getExtended(); parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation
						.getExtended()) {
			if (!parentImplementation.getOwnedFlowImplementations().isEmpty()) {
				parentHasFlowImpl = true;
			}
			if (!parentImplementation.getOwnedEndToEndFlows().isEmpty()) {
				parentHasETEFlow = true;
			}
			if (!parentImplementation.getOwnedModes().isEmpty()) {
				parentHasModes = true;
			}
			if (!parentImplementation.getOwnedModeTransitions().isEmpty()) {
				parentHasModeTransition = true;
			}
		}
		if (parentHasFlowImpl) {
			error(dataImplementation.getOwnedExtension(),
					"A data implementation cannot extend an abstract implementation that contains a flow implementation.");
		}
		if (parentHasETEFlow) {
			error(dataImplementation.getOwnedExtension(),
					"A data implementation cannot extend an abstract implementation that contains an end to end flow.");
		}
		if (parentHasModes) {
			error(dataImplementation.getOwnedExtension(),
					"A data implementation cannot extend an abstract implementation that contains modes.");
		}
		if (parentHasModeTransition) {
			error(dataImplementation.getOwnedExtension(),
					"A data implementation cannot extend an abstract implementation that contains a mode transition.");
		}
	}

	private void checkDataSizeProperty(DataImplementation dataImplementation) {
		Property dataSizeProperty = GetProperties.lookupPropertyDefinition(dataImplementation, MemoryProperties._NAME,
				MemoryProperties.DATA_SIZE);
		UnitLiteral Bytes = GetProperties.findUnitLiteral(dataSizeProperty, AadlProject.B_LITERAL);
		double implementationSize = PropertyUtils.getScaledNumberValue(dataImplementation, dataSizeProperty, Bytes,
				0.0);
		if (implementationSize == 0.0) {
			dataSizeProperty = GetProperties.lookupPropertyDefinition(dataImplementation, MemoryProperties._NAME,
					MemoryProperties.SOURCE_DATA_SIZE);
			implementationSize = PropertyUtils.getScaledNumberValue(dataImplementation, dataSizeProperty, Bytes, 0.0);
		}
		double sum = GetProperties.sumElementsDataSize(dataImplementation, Bytes);
		if (implementationSize == 0.0 || sum == 0.0) {
			return;
		}
		if (sum > implementationSize) {
			error("Data size of \"" + dataImplementation.getName() + "\" (" + (long) implementationSize
					+ " Bytes) is smaller than the sum of its subcomponents (" + (long) sum + " Bytes).",
					dataImplementation, Aadl2Package.eINSTANCE.getNamedElement_Name(), DATA_SIZE_INCONSISTENT);
		} else if (sum < implementationSize) {
			error("Data size of \"" + dataImplementation.getName() + "\" (" + (long) implementationSize
					+ " Bytes) is larger than the sum of its subcomponents (" + (long) sum + " Bytes).",
					dataImplementation, Aadl2Package.eINSTANCE.getNamedElement_Name(), DATA_SIZE_INCONSISTENT);
		}
		// try {
		// LongWithUnits implementationSize = new
		// LongWithUnits((IntegerLiteral)PropertyUtils.getSimplePropertyValue(dataImplementation,
		// dataSizeProperty));
		// List<Optional<LongWithUnits>> subcomponentSizes =
		// getSizesForSubcomponents(dataImplementation,
		// dataSizeProperty).collect(Collectors.toList());
		// Optional<LongWithUnits> optionalSum =
		// subcomponentSizes.stream().filter(subcomponentSize ->
		// subcomponentSize.isPresent()).map(subcomponentSize ->
		// subcomponentSize.get()).reduce((a, b) -> a.add(b));
		// if (optionalSum.isPresent()) {
		// LongWithUnits sum = optionalSum.get();
		// if (subcomponentSizes.stream().anyMatch(subcomponentSize ->
		// !subcomponentSize.isPresent())) {
		// if (sum.isGreaterThan(implementationSize)) {
		// error("Data size of \"" + dataImplementation.getName() + "\" (" +
		// implementationSize + ") is smaller than the sum of its subcomponents
		// (" + sum +").",
		// dataImplementation, Aadl2Package.eINSTANCE.getNamedElement_Name());
		// }
		// } else if (!implementationSize.equals(sum)) {
		// error("Data size of \"" + dataImplementation.getName() + "\" (" +
		// implementationSize + ") does not match the sum of its subcomponents
		// (" + sum + ").",
		// dataImplementation, Aadl2Package.eINSTANCE.getNamedElement_Name());
		// }
		// }
		// } catch (PropertyIsModalException | PropertyNotPresentException e) {
		// //Do not report any errors in this case.
		// }
	}

	private static Stream<Optional<LongWithUnits>> getSizesForSubcomponents(DataImplementation dataImplementation,
			Property dataSizeProperty) {
		return dataImplementation.getAllSubcomponents().stream()
				.filter(subcomponent -> subcomponent instanceof DataSubcomponent)
				.<Optional<LongWithUnits>> flatMap(dataSubcomponent -> {
					try {
						return Stream.of(Optional.of(new LongWithUnits((IntegerLiteral) PropertyUtils
								.getSimplePropertyValue(dataSubcomponent, dataSizeProperty))));
					} catch (PropertyNotPresentException e) {
						ComponentImplementation subcomponentClassifier = dataSubcomponent.getComponentImplementation();
						if (subcomponentClassifier instanceof DataImplementation) {
							return getSizesForSubcomponents((DataImplementation) subcomponentClassifier,
									dataSizeProperty);
						} else {
							return Stream.of(Optional.empty());
						}
					}
				});
	}

	private static class LongWithUnits {
		private final long value;
		private final UnitLiteral unit;

		public LongWithUnits(IntegerLiteral integerLiteral) {
			value = integerLiteral.getValue();
			unit = integerLiteral.getUnit();
		}

		private LongWithUnits(long value, UnitLiteral unit) {
			this.value = value;
			this.unit = unit;
		}

		public LongWithUnits add(LongWithUnits other) {
			if (unit == other.unit) {
				return new LongWithUnits(value + other.value, unit);
			} else {
				UnitLiteral targetUnit = getTargetUnit(unit, other.unit);
				LongWithUnits thisConverted = convertTo(targetUnit);
				LongWithUnits otherConverted = other.convertTo(targetUnit);
				return new LongWithUnits(thisConverted.value + otherConverted.value, targetUnit);
			}
		}

		public boolean isGreaterThan(LongWithUnits other) {
			if (unit == other.unit) {
				return value > other.value;
			} else {
				UnitLiteral targetUnit = getTargetUnit(unit, other.unit);
				LongWithUnits thisConverted = convertTo(targetUnit);
				LongWithUnits otherConverted = other.convertTo(targetUnit);
				return thisConverted.value > otherConverted.value;
			}
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof LongWithUnits) {
				LongWithUnits other = (LongWithUnits) obj;
				if (unit == other.unit) {
					return value == other.value;
				} else {
					UnitLiteral targetUnit = getTargetUnit(unit, other.unit);
					LongWithUnits thisConverted = convertTo(targetUnit);
					LongWithUnits otherConverted = other.convertTo(targetUnit);
					return thisConverted.value == otherConverted.value;
				}
			} else {
				return false;
			}
		}

		@Override
		public String toString() {
			return value + " " + unit.getName();
		}

		private static UnitLiteral getTargetUnit(UnitLiteral a, UnitLiteral b) {
			final EList<EnumerationLiteral> unitLiterals = ((UnitsType) a.getOwner()).getOwnedLiterals();
			if (unitLiterals.indexOf(a) < unitLiterals.indexOf(b)) {
				return a;
			} else {
				return b;
			}
		}

		private LongWithUnits convertTo(UnitLiteral targetUnit) {
			if (unit == targetUnit) {
				return this;
			} else {
				long currentValue = value;
				UnitLiteral currentUnit = unit;
				while (currentUnit != targetUnit) {
					currentValue = currentValue * ((IntegerLiteral) currentUnit.getFactor()).getValue();
					currentUnit = currentUnit.getBaseUnit();
				}
				return new LongWithUnits(currentValue, currentUnit);
			}
		}
	}

	/**
	 * Checks legality rule 4 in section 5.5 (Thread Groups) on page 95.
	 * "A thread group must not contain a subprogam calls subclause." This rule
	 * is partly checked by the parser. This method checks for inherited members
	 * from an AbstractImplementation.
	 */
	private void checkForInheritedCallSequenceFromAbstractImplementation(
			ThreadGroupImplementation threadGroupImplementation) {
		boolean parentHasCallSequence = false;
		if (hasExtendCycles(threadGroupImplementation)) {
			return;
		}
		for (ComponentImplementation parentImplementation = threadGroupImplementation
				.getExtended(); parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation
						.getExtended()) {
			if (!((AbstractImplementation) parentImplementation).getOwnedSubprogramCallSequences().isEmpty()) {
				parentHasCallSequence = true;
			}
		}
		if (parentHasCallSequence) {
			error(threadGroupImplementation.getOwnedExtension(),
					"A thread group implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}

	/**
	 * Checks legality rule 5 in section 6.1 (Processors) on page 102.
	 * "A processor implementation must not contain a subprogram calls subclause."
	 * This rule is partly checked by the parser. This method checks for
	 * inherited members from an AbstractImplementation.
	 */
	private void checkForInheritedCallSequenceFromAbstractImplementation(
			ProcessorImplementation processorImplementation) {
		boolean parentHasCallSequence = false;
		if (hasExtendCycles(processorImplementation)) {
			return;
		}
		for (ComponentImplementation parentImplementation = processorImplementation
				.getExtended(); parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation
						.getExtended()) {
			if (!((AbstractImplementation) parentImplementation).getOwnedSubprogramCallSequences().isEmpty()) {
				parentHasCallSequence = true;
			}
		}
		if (parentHasCallSequence) {
			error(processorImplementation.getOwnedExtension(),
					"A processor implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}

	/**
	 * Checks legality rule 4 in section 6.2 (Virtual Processors) on page 106.
	 * "A virtual processor implementation must not contain a subprogram calls subclause."
	 * This rule is partly checked by the parser. This method checks for
	 * inherited members from an AbstractImplementation.
	 */
	private void checkForInheritedCallSequenceFromAbstractImplementation(
			VirtualProcessorImplementation virtualProcessorImplementation) {
		boolean parentHasCallSequence = false;
		if (hasExtendCycles(virtualProcessorImplementation)) {
			return;
		}
		for (ComponentImplementation parentImplementation = virtualProcessorImplementation
				.getExtended(); parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation
						.getExtended()) {
			if (!((AbstractImplementation) parentImplementation).getOwnedSubprogramCallSequences().isEmpty()) {
				parentHasCallSequence = true;
			}
		}
		if (parentHasCallSequence) {
			error(virtualProcessorImplementation.getOwnedExtension(),
					"A virtual processor implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}

	/**
	 * Checks legality rule 1 in section 6.3 (Memory) on page 109. "A memory
	 * type can contain bus access declarations, feature groups, a modes
	 * subclause, and property associations. It must not contain flow
	 * specifications." This rule is partly checked by the parser. This method
	 * checks for inherited members from an AbstractType.
	 */
	private void checkForInheritedFlowsFromAbstractType(MemoryType memoryType) {
		boolean parentHasFlowSpec = false;
		if (hasExtendCycles(memoryType)) {
			return;
		}
		for (ComponentType parentType = memoryType
				.getExtended(); parentType instanceof AbstractType; parentType = parentType.getExtended()) {
			if (!parentType.getOwnedFlowSpecifications().isEmpty()) {
				parentHasFlowSpec = true;
			}
		}
		if (parentHasFlowSpec) {
			String changeFrom = memoryType.getCategory().getName();
			String offset = "" + findKeywordOffset(memoryType, changeFrom);
			error("A memory type cannot extend an abstract type that contains a flow specification.",
					memoryType.getOwnedExtension(), null, GENERIC_TEXT_REPLACEMENT, changeFrom,
					ComponentCategory.ABSTRACT.toString(), offset);
		}

	}

	/**
	 * Checks legality rule 5 in section 6.3 (Memory) on page 110.
	 * "A memory implementation must not contain flows subclause, or subprogram calls subclause."
	 * This rule is partly checked by the parser. This method checks for
	 * inherited members from an AbstractImplementation.
	 */
	private void checkForInheritedFlowsAndCallSequenceFromAbstractImplementation(
			MemoryImplementation memoryImplementation) {
		boolean parentHasFlowImpl = false;
		boolean parentHasETEFlow = false;
		boolean parentHasCallSequence = false;
		if (hasExtendCycles(memoryImplementation)) {
			return;
		}
		for (ComponentImplementation parentImplementation = memoryImplementation
				.getExtended(); parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation
						.getExtended()) {
			if (!parentImplementation.getOwnedFlowImplementations().isEmpty()) {
				parentHasFlowImpl = true;
			}
			if (!parentImplementation.getOwnedEndToEndFlows().isEmpty()) {
				parentHasETEFlow = true;
			}
			if (!((AbstractImplementation) parentImplementation).getOwnedSubprogramCallSequences().isEmpty()) {
				parentHasCallSequence = true;
			}
		}
		if (parentHasFlowImpl) {
			error(memoryImplementation.getOwnedExtension(),
					"A memory implementation cannot extend an abstract implementation that contains a flow implementation.");
		}
		if (parentHasETEFlow) {
			error(memoryImplementation.getOwnedExtension(),
					"A memory implementation cannot extend an abstract implementation that contains an end to end flow.");
		}
		if (parentHasCallSequence) {
			error(memoryImplementation.getOwnedExtension(),
					"A memory implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}

	/**
	 * Checks legality rule 2 in section 6.4 (Buses) on page 111.
	 * "A bus type must not contain any flow specifications." This rule is
	 * partly checked by the parser. This method checks for inherited members
	 * from an AbstractType.
	 */
	private void checkForInheritedFlowsFromAbstractType(BusType busType) {
		boolean parentHasFlowSpec = false;
		if (hasExtendCycles(busType)) {
			return;
		}
		for (ComponentType parentType = busType
				.getExtended(); parentType instanceof AbstractType; parentType = parentType.getExtended()) {
			if (!parentType.getOwnedFlowSpecifications().isEmpty()) {
				parentHasFlowSpec = true;
			}
		}
		if (parentHasFlowSpec) {
			String changeFrom = busType.getCategory().getName();
			String offset = "" + findKeywordOffset(busType, changeFrom);
			error("A bus type cannot extend an abstract type that contains a flow specification.",
					busType.getOwnedExtension(), null, GENERIC_TEXT_REPLACEMENT, changeFrom,
					ComponentCategory.ABSTRACT.toString(), offset);
		}
	}

	/**
	 * Checks legality rule 5 in section 6.4 (Buses) on page 111. "A bus
	 * implementation must not contain a connections subclause, flows subclause,
	 * or subprogram calls subclause." This rule is partly checked by the
	 * parser. This method checks for inherited members from an
	 * AbstractImplementation.
	 */
	private void checkForInheritedConnectionsFlowsAndCallsFromAbstractImplementation(
			BusImplementation busImplementation) {
		boolean parentHasConnections = false;
		boolean parentHasFlowImpl = false;
		boolean parentHasETEFlow = false;
		boolean parentHasCallSequence = false;
		if (hasExtendCycles(busImplementation)) {
			return;
		}
		for (ComponentImplementation parentImplementation = busImplementation
				.getExtended(); parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation
						.getExtended()) {
			if (!parentImplementation.getOwnedConnections().isEmpty()) {
				parentHasConnections = true;
			}
			if (!parentImplementation.getOwnedFlowImplementations().isEmpty()) {
				parentHasFlowImpl = true;
			}
			if (!parentImplementation.getOwnedEndToEndFlows().isEmpty()) {
				parentHasETEFlow = true;
			}
			if (!((AbstractImplementation) parentImplementation).getOwnedSubprogramCallSequences().isEmpty()) {
				parentHasCallSequence = true;
			}
		}
		if (parentHasConnections) {
			error(busImplementation.getOwnedExtension(),
					"A bus implementation cannot extend an abstract implementation that contains a connection.");
		}
		if (parentHasFlowImpl) {
			error(busImplementation.getOwnedExtension(),
					"A bus implementation cannot extend an abstract implementation that contains a flow implementation.");
		}
		if (parentHasETEFlow) {
			error(busImplementation.getOwnedExtension(),
					"A bus implementation cannot extend an abstract implementation that contains an end to end flow.");
		}
		if (parentHasCallSequence) {
			error(busImplementation.getOwnedExtension(),
					"A bus implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}

	/**
	 * Checks legality rule 2 in section 6.5 (Virtual Buses) on page 114.
	 * "A virtual bus type must not contain flow specifications." This rule is
	 * partly checked by the parser. This method checks for inhertied members
	 * from an AbstractType.
	 */
	private void checkForInheritedFlowsFromAbstractType(VirtualBusType virtualBusType) {
		boolean parentHasFlowSpec = false;
		if (hasExtendCycles(virtualBusType)) {
			return;
		}
		for (ComponentType parentType = virtualBusType
				.getExtended(); parentType instanceof AbstractType; parentType = parentType.getExtended()) {
			if (!parentType.getOwnedFlowSpecifications().isEmpty()) {
				parentHasFlowSpec = true;
			}
		}
		if (parentHasFlowSpec) {
			String changeFrom = virtualBusType.getCategory().getName();
			String offset = "" + findKeywordOffset(virtualBusType, changeFrom);
			error("A virtual bus type cannot extend an abstract type that contains a flow specification.",
					virtualBusType.getOwnedExtension(), null, GENERIC_TEXT_REPLACEMENT, changeFrom,
					ComponentCategory.ABSTRACT.toString(), offset);
		}
	}

	/**
	 * Checks legality rule 5 in section 6.5 (Virtual Buses) on page 114. "A
	 * virtual bus implementation must not contain a connections subclause,
	 * flows subclause, or subprogram calls subclause." This rule is partly
	 * checked by the parser. This method checks for inherited members from an
	 * AbstractImplementation.
	 */
	private void checkForInheritedConnectionsFlowsAndCallsFromAbstractImplementation(
			VirtualBusImplementation virtualBusImplementation) {
		boolean parentHasConnections = false;
		boolean parentHasFlowImpl = false;
		boolean parentHasETEFlow = false;
		boolean parentHasCallSequence = false;
		if (hasExtendCycles(virtualBusImplementation)) {
			return;
		}
		for (ComponentImplementation parentImplementation = virtualBusImplementation
				.getExtended(); parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation
						.getExtended()) {
			if (!parentImplementation.getOwnedConnections().isEmpty()) {
				parentHasConnections = true;
			}
			if (!parentImplementation.getOwnedFlowImplementations().isEmpty()) {
				parentHasFlowImpl = true;
			}
			if (!parentImplementation.getOwnedEndToEndFlows().isEmpty()) {
				parentHasETEFlow = true;
			}
			if (!((AbstractImplementation) parentImplementation).getOwnedSubprogramCallSequences().isEmpty()) {
				parentHasCallSequence = true;
			}
		}
		if (parentHasConnections) {
			error(virtualBusImplementation.getOwnedExtension(),
					"A virtual bus implementation cannot extend an abstract implementation that contains a connection.");
		}
		if (parentHasFlowImpl) {
			error(virtualBusImplementation.getOwnedExtension(),
					"A virtual bus implementation cannot extend an abstract implementation that contains a flow implementation.");
		}
		if (parentHasETEFlow) {
			error(virtualBusImplementation.getOwnedExtension(),
					"A virtual bus implementation cannot extend an abstract implementation that contains an end to end flow.");
		}
		if (parentHasCallSequence) {
			error(virtualBusImplementation.getOwnedExtension(),
					"A virtual bus implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}

	/**
	 * Checks legality rule 2 in section 6.6 (Devices) on page 117.
	 * "A device component implementation must not contain a subprogram calls subclause."
	 * This rule is partly checked by the parser. This method checks for
	 * inherited members from an AbstractImplementation.
	 */
	private void checkForInheritedCallsFromAbstractImplementation(DeviceImplementation deviceImplementation) {
		boolean parentHasCallSequence = false;
		if (hasExtendCycles(deviceImplementation)) {
			return;
		}
		for (ComponentImplementation parentImplementation = deviceImplementation
				.getExtended(); parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation
						.getExtended()) {
			if (!((AbstractImplementation) parentImplementation).getOwnedSubprogramCallSequences().isEmpty()) {
				parentHasCallSequence = true;
			}
		}
		if (parentHasCallSequence) {
			error(deviceImplementation.getOwnedExtension(),
					"A device implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}

	/**
	 * Checks legality rule 2 in section 8 (Features and Shared Access) on page
	 * 125. "A feature refinement declaration of a feature and the original
	 * feature must both be declared as port, parameter, access feature, or
	 * feature group, or the original feature must be declared as abstract
	 * feature."
	 *
	 * Checks legality rule 4 in section 8.3 (Ports) on page 132. "The port
	 * category of a port refinement must be the same as the category of the
	 * port being refined, or the port being refined must be an abstract
	 * feature." This method was not written with L4 specifically in mind, but
	 * it does properly check L4. This is because there are separate meta-model
	 * classes for the various port categories (DataPort, EventPort, and
	 * EventDataPort). If this data were stored in a field in Port, then this
	 * method would not be sufficient for L4.
	 */
	private void checkTypeOfFeatureRefinement(Feature feature) {
		Feature refined = feature.getRefined();
		if (!Aadl2Util.isNull(refined) && !(feature.getRefined() instanceof AbstractFeature)
				&& !feature.eClass().equals(refined.eClass())) {
			error(feature, "Cannot refine " + FEATURE_CLASS_NAMES_WITH_ARTICLE.get(refined.eClass()) + " into "
					+ FEATURE_CLASS_NAMES_WITH_ARTICLE.get(feature.eClass()) + '.');
		}
	}

	/**
	 * Checks legality rule 3 in section 8 (Features and Shared Access) on page
	 * 125.
	 * "Feature arrays must only be declared for threads, devices, and processors."
	 */
	private void checkForFeatureArrays(Feature feature) {
		Element e = feature.getOwner();
		if (e instanceof ComponentType) {
			ComponentType componentType = (ComponentType) e;
			if (!(componentType instanceof AbstractType) && !(componentType instanceof ThreadType)
					&& !(componentType instanceof DataType) && !(componentType instanceof MemoryType)
					&& !(componentType instanceof BusType) &&
					// JD : allow for system type as well
					!(componentType instanceof SystemType) && !(componentType instanceof DeviceType)
					&& !(componentType instanceof ProcessorType)) {
				if (!feature.getArrayDimensions().isEmpty()) {
					error(feature,
							"Feature arrays can only be declared for abstract, thread, device, bus, data, memory, system and processor classifiers.");
					return;
				}
			}
			if (feature instanceof FeatureGroup) {
				// feature array can either be on the feature group declaration
				// or on
				// on features inside the feature group type of the feature
				// group.
				// Having it on both would lead to a multi-dimensional feature
				// array.
				FeatureGroup fg = (FeatureGroup) feature;
				if (!fg.getArrayDimensions().isEmpty()) {
					FeatureGroupType fgt = fg.getAllFeatureGroupType();
					if (containsFeatureArrays(fgt)) {
						error(feature,
								"Feature group declared as array contains feature arrays. The resulting feature array would be multi-dimensional.");
					}
				}
			}
		}
	}

	private void checkLegalFeatureGroup(FeatureGroup fg) {
		Element e = fg.getOwner();
		if (e instanceof SubprogramGroupType) {
			if (containsNonSubprogramGroupFeatures(fg.getAllFeatureGroupType())) {
				error(fg,
						"Feature group in Subprogram Group Type can only contain Subprogram Access, Subprogram Group Access, or Abstract features.");
			}
		} else if (e instanceof SubprogramType) {
			if (containsNonSubprogramFeatures(fg.getAllFeatureGroupType())) {
				error(fg,
						"Feature group in Subprogram Type can only contain Subprogram Access, Subprogram Group Access, Data Access, Abstract, Parameter, Event Port, Event Data Port features.");
			}
		}

	}

	private boolean containsFeatureArrays(FeatureGroupType fgt) {
		if (Aadl2Util.isNull(fgt)) {
			return false;
		}
		EList<Feature> fl = fgt.getAllFeatures();
		for (Feature feature : fl) {
			if (!feature.getArrayDimensions().isEmpty()) {
				return true;
			} else if (feature instanceof FeatureGroup) {
				if (containsFeatureArrays(((FeatureGroup) feature).getAllFeatureGroupType())) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean containsNonSubprogramGroupFeatures(FeatureGroupType fgt) {
		if (Aadl2Util.isNull(fgt)) {
			return false;
		}
		EList<Feature> fl = fgt.getAllFeatures();
		for (Feature feature : fl) {
			if (feature instanceof FeatureGroup) {
				if (containsNonSubprogramGroupFeatures(((FeatureGroup) feature).getAllFeatureGroupType())) {
					return true;
				}
			} else if (!(feature instanceof SubprogramAccess || feature instanceof SubprogramGroupAccess
					|| feature instanceof AbstractFeature)) {
				return true;
			}
		}
		return false;
	}

	private boolean containsNonSubprogramFeatures(FeatureGroupType fgt) {
		if (Aadl2Util.isNull(fgt)) {
			return false;
		}
		EList<Feature> fl = fgt.getAllFeatures();
		for (Feature feature : fl) {
			if (feature instanceof FeatureGroup) {
				if (containsNonSubprogramFeatures(((FeatureGroup) feature).getAllFeatureGroupType())) {
					return true;
				}
			} else if (!(feature instanceof SubprogramAccess || feature instanceof SubprogramGroupAccess
					|| feature instanceof AbstractFeature || feature instanceof Parameter
					|| feature instanceof DataAccess || feature instanceof EventPort
					|| feature instanceof EventDataPort)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks legality rule 3 in section 8 (Features and Shared Access) on page
	 * 125.
	 * "Feature arrays must only be declared for threads, devices, and processors."
	 */
	private void checkForInheritedFeatureArrays(ComponentType componentType) {
		if (!(componentType instanceof AbstractType) && !(componentType instanceof ThreadType)
				&& !(componentType instanceof DeviceType) && !(componentType instanceof ProcessorType)) {
			boolean parentHasFeatureArray = false;
			if (hasExtendCycles(componentType)) {
				return;
			}
			for (ComponentType parentType = componentType
					.getExtended(); parentType instanceof AbstractType; parentType = parentType.getExtended()) {
				for (Feature inheritedFeature : parentType.getOwnedFeatures()) {
					if (!inheritedFeature.getArrayDimensions().isEmpty()) {
						parentHasFeatureArray = true;
					}
				}
			}
			if (parentHasFeatureArray) {
				String changeFrom = componentType.getCategory().getName();
				String offset = "" + findKeywordOffset(componentType, changeFrom);
				error("A " + changeFrom + " type cannot extend an abstract type that contains feature arrays.",
						componentType.getOwnedExtension(), null, GENERIC_TEXT_REPLACEMENT, changeFrom,
						ComponentCategory.ABSTRACT.toString(), offset);
			}
		}
	}

	/**
	 * Checks legality rule 4 in section 8 (Features and Shared Access) on page
	 * 125. "If the feature refinement specifies an array dimension, then the
	 * feature being refined must have an array dimension."
	 */
	private void checkForArraysInRefinedFeature(Feature feature) {
		if (!feature.getArrayDimensions().isEmpty() && feature.getRefined() != null
				&& feature.getRefined().getArrayDimensions().isEmpty()) {
			error(feature,
					"Cannot specify an array dimension because the refined feature doesn't have an array dimension.");
		}
	}

	/**
	 * Checks legality rule 5 in section 8 (Features and Shared Access) on page
	 * 125. "If the refinement specifies an array dimension size, then the
	 * feature being refined must not have an array dimension size."
	 */
	private void checkForArrayDimensionSizeInRefinedFeature(Feature feature) {
		// TODO-phf: Now we have to check the list of ArrayDimensions if each
		// has the size field set.
		// if (!feature.getArrayDimensions().isEmpty() &&
		// !feature.getArraySpecification().getSizes().isEmpty() &&
		// feature.getRefined() != null &&
		// !feature.getRefined().getArrayDimensions().isEmpty() &&
		// !feature.getRefined().getArraySpecification().getSizes().isEmpty())
		// {
		// error(feature.getArraySpecification().getSizes().get(0),
		// "Cannot specify an array dimension size because the refined feature
		// already specified the array dimension size.");
		// }
	}
	
	/**
	 * See issue #671.
	 * If an AbstractFeature is a trigger port, then it cannot be refined to another feature which is not a subtype of TriggerPort.
	 */
	private void checkRefinedFeatureAsTransitionTrigger(Feature feature) {
		ComponentType component = EcoreUtil2.getContainerOfType(feature, ComponentType.class);
		Feature refined = feature.getRefined();
		if (component != null && refined instanceof AbstractFeature && !(feature instanceof TriggerPort)) {
			Stream<ModeTransition> transitions = component.getAllModeTransitions().stream();
			Stream<ModeTransitionTrigger> triggers = transitions.flatMap(transition -> transition.getOwnedTriggers().stream());
			if (triggers.anyMatch(trigger -> trigger.getTriggerPort() == refined)) {
				error("Cannot refine to " + FEATURE_CLASS_NAMES_WITH_ARTICLE.get(feature.eClass()) + ". '" + feature.getName() + "' is used as a mode transition trigger.",
						feature, Aadl2Package.eINSTANCE.getFeature_Refined());
			}
		}
	}

	/**
	 * Checks legality rule 1 in section 8.1 (Abstract Features) on page 126.
	 * "The feature direction in a refined feature declaration must be identical
	 * to the feature direction in the feature declaration being refined, or the
	 * feature being refined must not have a direction."
	 *
	 * Checks legality rule 2 in section 8.1 (Abstract Features) on page 127.
	 * "If the direction of an abstract feature is specified, then the direction
	 * must be satisfied by the refinement (see also the rules for feature
	 * prototypes in Section 4.7); in the case of ports the direction must be in
	 * or out; in the case of data access, the access right must be read-only
	 * for in and write-only for out; in the case of bus access, subprogram
	 * access and subprogram group access the direction must not be in nor out."
	 * This method does not check access features.
	 *
	 * Checks legality rule 5 in section 8.3 (Ports) on page 133. "The port
	 * direction of a port refinement must be the same as the direction of the
	 * feature being refined. If the feature being refined is an abstract
	 * feature without direction, then all port directions are acceptable."
	 *
	 * Checks legality rule 4 in section 8.5 (Subprogram Parameters) on page
	 * 148. "The parameter direction of a parameter refinement must be the same
	 * as the direction of the feature being refined. If the feature being
	 * refined is an abstract feature without direction, then all parameter
	 * directions are acceptable."
	 */
	private void checkFeatureDirectionInRefinement(DirectedFeature feature) {
		DirectionType direction = feature.getDirection();
		if (feature.getRefined() instanceof DirectedFeature) {
			DirectionType originalDirection = ((DirectedFeature) feature.getRefined()).getDirection();
			// For ports and parameters, the directions must be the same value.
			// All other DirectedFeatures have the option of refining from
			// IN_OUT to IN or OUT.
			// in case of a feature group leaving off the direction mean it
			// inherits the original direction.
			if (!direction.equals(originalDirection) && ((feature.getRefined() instanceof Port
					|| feature.getRefined() instanceof Parameter || !originalDirection.equals(DirectionType.IN_OUT)))) {

				String changeFrom = direction.getName();
				String changeTo = originalDirection.getName();
				error("The direction in feature refinement must be the same or in case of abstract features or feature groups"
						+ " the original direction must be 'in out'.  The direction of the refined feature is '"
						+ changeFrom + "' while original direction is '" + changeTo + "'.", feature, null,
						INCOMPATIBLE_FEATURE_DIRECTION_IN_REFINEMENT, changeFrom, changeTo);
			}
		}
	}

	/**
	 * Checks legality rule 3 in section 8.1 (Abstract Features) on page 127.
	 * "An abstract feature with a feature prototype identifier and the
	 * prototype being referenced must both specify the same direction or no
	 * direction."
	 */
	private void checkAbstractFeatureAndPrototypeDirectionConsistency(AbstractFeature feature) {
		if (feature.getFeaturePrototype() != null) {
			DirectionType featureDirection = feature.getDirection();
			DirectionType prototypeDirection = feature.getFeaturePrototype().getDirection();
			String changeFrom = featureDirection.getName();
			String changeTo = prototypeDirection.getName();
			if (!featureDirection.equals(prototypeDirection)) {
				if (prototypeDirection.equals(DirectionType.IN_OUT)) {
					error("A direction cannot be specified on the abstract feature because its prototype does not specify a direction.",
							feature, null, ABSTRACT_FEATURE_DIRECTION_NOT_IN_PROTOTYPE, changeFrom);
				} else {
					error("The direction of the abstract feature must match the direction of its prototype."
							+ "  The prototype's direction is '" + prototypeDirection.getName() + "'.", feature, null,
							ABSTRACT_FEATURE_DIRECTION_DOES_NOT_MATCH_PROTOTYPE, changeFrom, changeTo);
				}
			}
		}
	}

	/**
	 * Checks legality rule 4 in section 8.1 (Abstract Features) on page 127.
	 * "An abstract feature refinement declaration of a feature with a feature
	 * prototype reference must only add property associations."
	 */
	private void checkForAddedDirectionInAbstractFeatureRefinement(AbstractFeature feature) {
		Feature refinedFeature = feature.getRefined();
		while (refinedFeature instanceof AbstractFeature
				&& ((AbstractFeature) refinedFeature).getFeaturePrototype() == null) {
			refinedFeature = refinedFeature.getRefined();
		}
		if (refinedFeature instanceof AbstractFeature) {
			if (((AbstractFeature) refinedFeature).getDirection().equals(DirectionType.IN_OUT)
					&& !feature.getDirection().equals(DirectionType.IN_OUT)) {
				String changeFrom = feature.getDirection().getName();
				error("The refined feature refers to a feature prototype.  Therefore, a direction cannot be added in the"
						+ " refinement because the direction will be specified in the prototype binding.", feature,
						null, ADDED_DIRECTION_IN_ABSTRACT_FEATURE_REFINEMENT, changeFrom);
			}
		}
	}

	/**
	 * Checks legality rule 4 in section 8.1 (Abstract Features) on page 127.
	 * "An abstract feature refinement declaration of a feature with a feature
	 * prototype reference must only add property associations."
	 */
	private void checkForAddedPrototypeOrClassifierInAbstractFeatureRefinement(AbstractFeature feature) {
		AbstractFeature refinedFeature = (AbstractFeature) feature.getRefined();
		while (refinedFeature != null && refinedFeature.getFeaturePrototype() == null) {
			refinedFeature = (AbstractFeature) refinedFeature.getRefined();
		}
		if (refinedFeature != null && feature.getFeaturePrototype() != null
				&& !feature.getFeaturePrototype().equals(refinedFeature.getFeaturePrototype())) {

			String changeFrom = feature.getFeaturePrototype().getName();
			error("The refined feature already refers to a prototype.  "
					+ "The prototype cannot be changed in the refinement.", feature, null,
					ADDED_PROTOTYPE_OR_CLASSIFIER_IN_ABSTRACT_FEATURE_REFINEMENT, changeFrom);
		}
	}

	/**
	 * Checks legality rule 2 in section 8.2 (Feature Groups and Feature Group
	 * Types) on page 129. "A feature group type can be declared to be the
	 * inverse of another feature group type, as indicated by the reserved words
	 * inverse of and the name of a feature group type. Any feature group type
	 * named in an inverse of statement cannot itself contain an inverse of
	 * statement. This means that several feature groups can be declared to be
	 * the inverse of one feature group, e.g., B inverse of A and C inverse of A
	 * is acceptable. However, chaining of inverses is not permitted, e.g., B
	 * inverse of A and C inverse of B is not acceptable."
	 */
	private void checkForChainedInverseFeatureGroupTypes(FeatureGroupType featureGroupType) {
		if (featureGroupType.getInverse() != null && featureGroupType.getInverse().getInverse() != null) {
			error("A feature group type cannot be an inverse of another feature group type that already "
					+ "contains an 'inverse of' declaration.", featureGroupType, null,
					CHAINED_INVERSE_FEATURE_GROUP_TYPES);
		}
	}

	private boolean isCircularExtension(FeatureGroupType featureGroupType) {
		if (null != featureGroupType.getExtended()) {
			FeatureGroupType extended = featureGroupType.getExtended();
			List<FeatureGroupType> featureGroupTypes = new ArrayList<FeatureGroupType>();
			while (extended != null) {
				if (extended.equals(featureGroupType) || featureGroupTypes.contains(extended)) {
					error(featureGroupType.getOwnedExtension(), "Feature Group extension has circular dependency.");
					extended = null;
					return true;
				}
				featureGroupTypes.add(extended);
				extended = extended.getExtended();
			}
		}
		return false;
	}

	private List<Feature> sortFeaturesByOffset(List<Feature> features) {
		if (features == null) {
			return null;
		}
		SortedMap<Integer, Feature> featureMap = new TreeMap<Integer, Feature>();
		for (Feature nextFeature : features) {
			featureMap.put(NodeModelUtils.getNode(nextFeature).getOffset(), nextFeature);
		}
		return new ArrayList<Feature>(featureMap.values());
	}

	private void checkFeaturesInInverseFeatureGroupType(FeatureGroupType featureGroupType) {
		FeatureGroupType inverse = featureGroupType.getInverse();
		if (inverse != null) {
			List<Feature> features = sortFeaturesByOffset(featureGroupType.getOwnedFeatures());
			List<Feature> inverseFeatures = sortFeaturesByOffset(inverse.getOwnedFeatures());
			if (features.size() == 0) {
				return;
			}
			if (features.size() != inverseFeatures.size()) {
				error(featureGroupType, "Feature Group features list count differs from that of its inverse");
				return;
			}
			for (int i = 0; i < features.size(); i++) {
				Feature feature = features.get(i);
				Feature inverseFeature = inverseFeatures.get(i);

				if (!feature.eClass().equals(inverseFeature.eClass())) {
					error(feature, "Feature Group feature type differs from that of its inverse");
					continue;
				}

				// cast to type, if port or access then make sure directions are
				// opposite
				if (feature instanceof DirectedFeature) {
					DirectionType directType = ((DirectedFeature) feature).getDirection();
					DirectionType directTypeInversed = directType.getInverseDirection();
					DirectionType inverseDirection = ((DirectedFeature) inverseFeature).getDirection();
					if (!directTypeInversed.equals(inverseDirection)) {
						error(feature, "Feature Group feature direction not opposite that of its inverse");
					}
				}
				if (feature instanceof Access) {
					if (((Access) feature).getKind().equals(((Access) inverseFeature).getKind())) {
						error(feature, "Feature Group feature access kind is same as that of its inverse");
					}
				}
			}
		}
	}

	/**
	 * Checks legality rule 3 in section 8.2 (Feature Groups and Feature Group
	 * Types) on page 129. "Only feature group types without inverse of or
	 * feature group types with features and inverse of can be extended."
	 */
	private void checkForExtendingAnInverseFeatureGroupType(GroupExtension extension) {
		FeatureGroupType extended = extension.getExtended();

		if (extended.getInverse() != null && extended.getOwnedFeatures().isEmpty()) {
			error("Cannot extend a feature group type that contains an 'inverse of' declaration,"
					+ " but does not contain any locally defined features.", extension, null,
					EXTENDED_INVERSE_FEATURE_GROUP_TYPE);
		}
	}

	/**
	 * Checks legality rule 4 in section 8.2 (Feature Groups and Feature Group
	 * Types) on page 129. "A feature group type that is an extension of another
	 * feature group type without an inverse of cannot contain an inverse of
	 * statement."
	 */
	private void checkForInverseInFeatureGroupTypeExtension(GroupExtension extension) {
		FeatureGroupType extended = extension.getExtended();
		FeatureGroupType extending = (FeatureGroupType) extension.getSpecific();
		if (extending.getInverse() != null && extended.getInverse() == null) {
			error("A feature group type with an 'inverse of' declaration cannot extend a feature group type "
					+ "without an 'inverse of' declaration.", extension, null, INVERSE_IN_FEATURE_GROUP_TYPE_EXTENSION);
		}
	}

	/**
	 * Checks legality rule 5 in section 8.2 (Feature Groups and Feature Group
	 * Types) on page 129. "The feature group type that is an extension of
	 * another feature group type with features and inverse of that adds
	 * features must have an inverse of to identify the feature group type whose
	 * inverse it is."
	 */
	private void checkForRequiredInverseInFeatureGroupTypeExtension(GroupExtension extension) {
		FeatureGroupType extended = extension.getExtended();
		FeatureGroupType extending = (FeatureGroupType) extension.getSpecific();
		if (!extended.getOwnedFeatures().isEmpty() && extended.getInverse() != null
				&& !extending.getOwnedFeatures().isEmpty() && extending.getInverse() == null) {
			// XXX: phf commented out because we may allow independnet
			// refinement and then pick up the inverseof from the ancestor
			// warning(extending,
			// "Must specify inverse because local features are defined and the
			// extended feature group type has an"
			// + " 'inverse of' declaration.");
		}
	}

	/**
	 * Checks legality rule 6 in section 8.2 (Feature Groups and Feature Group
	 * Types) on page 129. "A feature group declaration with an inverse of
	 * statement must only reference feature group types without an inverse of
	 * statement."
	 */
	private void checkForInverseInFeatureGroup(FeatureGroup featureGroup) {
		if (featureGroup.isInverse() && featureGroup.getFeatureGroupType() != null
				&& featureGroup.getFeatureGroupType().getInverse() != null) {
			error("A feature group type with an 'inverse of' declaration cannot extend a feature group type "
					+ "without an 'inverse of' declaration.", featureGroup, null, INVERSE_IN_FEATURE_GROUP);
		}
	}

	/**
	 * Checks legality rule 13 in section 8.2 (Feature Groups and Feature Group
	 * Types) on page 129. "If an in or out direction is specified as part of a
	 * feature group declaration, then all features inside the feature group
	 * must satisfy this direction."
	 */
	private void checkDirectionOfFeatureGroupMembers(FeatureGroup featureGroup) {
		DirectionType fgDirection = featureGroup.getDirection();
		String currentDirection = fgDirection.getName();
		if (!fgDirection.equals(DirectionType.IN_OUT) && featureGroup.getFeatureGroupType() != null) {
			if (featureGroup.isInverse()) {
				fgDirection = fgDirection.getInverseDirection();
			}
			int errorCount = 0;
			List<String> directions = new ArrayList<String>();

			for (Feature feature : featureGroup.getFeatureGroupType().getAllFeatures()) {
				if (feature instanceof DirectedFeature) {
					DirectionType direction = ((DirectedFeature) feature).getDirection();
					if (!direction.equals(fgDirection)) {
						errorCount++;
					}
					directions.add(direction.getName());
				}
			}
			Set<String> uniqueDirectionSet = new HashSet<String>(directions);
			String validDirection = "";
			if (uniqueDirectionSet.size() == 1) {
				List<String> uniqueDirections = new ArrayList<String>(uniqueDirectionSet);
				validDirection = uniqueDirections.get(0);
			}

			if (featureGroup.isInverse() && validDirection.equals("in")) {
				validDirection = "out";
			} else if (featureGroup.isInverse() && validDirection.equals("out")) {
				validDirection = "in";
			}
			if (errorCount > 0) {
				error("All ports, parameters, feature groups, and abstract features in the referenced feature group"
						+ " type must satisfy the direction specified in the feature group.", featureGroup, null,
						DIRECTION_NOT_SAME_AS_FEATURE_GROUP_MEMBERS, validDirection, currentDirection);
			}
		}
	}

	/**
	 * Checks legality rule L1 for section 8.4 (Subprogram and Subprogram Group
	 * Access) "If a subprogram access refers to a component classifier or a
	 * component prototype, then the category of the classifier or prototype
	 * must be subprogram." For references to classifiers, the meta-model only
	 * allows for a subprogram classifier. Therefore, this method only checks
	 * the prototype reference.
	 */
	private void checkSubprogramAccessPrototypeReference(SubprogramAccess subprogramAccess) {
		Prototype sp = subprogramAccess.getPrototype();
		if (sp != null && !(subprogramAccess.getPrototype() instanceof SubprogramPrototype)) {
			error(subprogramAccess, "The category of the referenced component prototype must be subprogram.");
		}
	}

	/**
	 * Checks legality rule L2 for section 8.4 (Subprogram and Subprogram Group
	 * Access) "If a subprogram group access refers to a component classifier or
	 * a component prototype, then the category of the classifier or prototype
	 * must be subprogram group." For references to classifiers, the meta-model
	 * only allows for a subprogram group classifier. Therefore, this method
	 * only checks the prototype reference.
	 */
	private void checkSubprogramGroupAccessPrototypeReference(SubprogramGroupAccess subprogramGroupAccess) {
		Prototype sp = subprogramGroupAccess.getPrototype();
		if (sp != null && !(sp instanceof SubprogramGroupPrototype)) {
			error(subprogramGroupAccess,
					"The category of the referenced component prototype must be subprogram group.");
		}
	}

	/**
	 * Checks legality rule L3 for section 8.4 (Subprogram and Subprogram Group
	 * Access) "An abstract feature can be refined into a subprogram access or a
	 * subprogram group access. In this case, the abstract feature must not have
	 * a direction specified."
	 *
	 * Checks legality rule L4 for section 8.6 (Data Component Access) "An
	 * abstract feature can be refined into a data access. In this case, the
	 * abstract feature must not have a direction specified."
	 *
	 * Checks legality rule L4 for section 8.7 (Bus Component Access) "An
	 * abstract feature can be refined into a bus access. In this case, the
	 * abstract feature must not have a direction specified."
	 */
	private void checkForAbstractFeatureDirectionInAccessRefinement(Access access) {
		if (access.getRefined() instanceof AbstractFeature
				&& !((AbstractFeature) access.getRefined()).getDirection().equals(DirectionType.IN_OUT)) {
			error(access, "An abstract feature with a direction specified cannot be refined into an access feature.");
		}
	}

	/**
	 * Checks legality rule L6 for section 8.4 (Subprogram and Subprogram Group
	 * Access) "A provides subprogram access cannot be refined to a requires
	 * subprogram access and a requires subprogram access cannot be refined to a
	 * provides subprogram access. Similarly, a provides subprogram group access
	 * cannot be refined to a requires subprogram group access and a requires
	 * subprogram group access cannot be refined to a provides subprogram group
	 * access."
	 *
	 * Checks legality rule L3 for section 8.6 (Data Component Access) "A
	 * provides data access cannot be refined to a requires data access and a
	 * requires data access cannot be refined to a provides data access."
	 *
	 * Checks rule L3 for section 8.7 (Bus Component Access) "A provides bus
	 * access cannot be refined to a requires bus access and a requires bus
	 * access cannot be refined to a provides bus access."
	 */
	private void checkForAccessTypeInAccessRefinement(Access access) {
		if (access.getRefined() instanceof Access
				&& !access.getKind().equals(((Access) access.getRefined()).getKind())) {

			String changeFrom = access.getKind().getName();
			String changeTo = ((Access) access.getRefined()).getKind().getName();
			StringBuilder errorMessage = new StringBuilder("A ");
			errorMessage.append(changeTo);
			errorMessage.append(" access cannot be refined into a ");
			errorMessage.append(changeFrom);
			errorMessage.append(" access.");

			error(errorMessage.toString(), access, null, REVERSE_ACCESS_KIND, changeFrom, changeTo);

		}
	}

	/**
	 * Checks legality rule L1 for section 8.6 (Data Component Access) "If a
	 * data access refers to a component classifier or a component prototype,
	 * then the category of the classifier or prototype must be data." For
	 * references to classifiers, the meta-model only allows for a data
	 * classifier. Therefore, this method only checks the prototype reference.
	 */
	private void checkDataAccessPrototypeReference(DataAccess dataAccess) {
		Prototype dp = dataAccess.getPrototype();
		if (dp != null && !(dp instanceof DataPrototype)) {
			error(dataAccess, "The category of the referenced component prototype must be data.");
		}
	}

	private void checkRequiresAccessOnly(DataAccess dataAccess) {
		Classifier cl = ((Feature) dataAccess).getContainingClassifier();
		if ((cl instanceof SubprogramType)) {
			if (dataAccess.getKind().equals(AccessType.PROVIDES)) {
				error("Subprograms cannot have provides data access.", dataAccess, null, REVERSE_ACCESS_KIND,
						AccessType.PROVIDES.getName(), AccessType.REQUIRES.getName());
			}
		}
	}

	private void checkBusAccessPrototypeReference(BusAccess busAccess) {
		Prototype dp = busAccess.getPrototype();
		if (dp != null && !(dp instanceof BusPrototype)) {
			error(busAccess, "The category of the referenced component prototype must be bus.");
		}
	}

	private void checkProvidesAccessOnly(SubprogramAccess spAccess) {
		Classifier cl = ((Feature) spAccess).getContainingClassifier();
		if ((cl instanceof ProcessorType || cl instanceof VirtualProcessorType || cl instanceof DeviceType)) {
			if (spAccess.getKind().equals(AccessType.REQUIRES)) {
				error("Processor, VirtualProcessor, Device cannot have requires subprogram access.", spAccess, null,
						REVERSE_ACCESS_KIND, AccessType.REQUIRES.getName(), AccessType.PROVIDES.getName());
			}
		}
	}

	private void checkProvidesAccessOnly(SubprogramGroupAccess spAccess) {
		Classifier cl = ((Feature) spAccess).getContainingClassifier();
		if ((cl instanceof ProcessorType || cl instanceof VirtualProcessorType || cl instanceof DeviceType)) {
			if (spAccess.getKind().equals(AccessType.REQUIRES)) {
				error("Processor, VirtualProcessor, Device cannot have requires subprogram group access.", spAccess,
						null, REVERSE_ACCESS_KIND, AccessType.REQUIRES.getName(), AccessType.PROVIDES.getName());
			}
		}
	}

	private void checkRequiresAccessOnly(SubprogramAccess spAccess) {
		Classifier cl = ((Feature) spAccess).getContainingClassifier();
		if ((cl instanceof SubprogramType)) {
			if (spAccess.getKind().equals(AccessType.PROVIDES)) {
				error("Subprograms cannot have provides subprogram access.", spAccess, null, REVERSE_ACCESS_KIND,
						AccessType.PROVIDES.getName(), AccessType.REQUIRES.getName());
			}
		}
	}

	private void checkRequiresAccessOnly(SubprogramGroupAccess spAccess) {
		Classifier cl = ((Feature) spAccess).getContainingClassifier();
		if ((cl instanceof SubprogramType)) {
			if (spAccess.getKind().equals(AccessType.PROVIDES)) {
				error("Subprograms cannot have provides subprogram group access.", spAccess, null, REVERSE_ACCESS_KIND,
						AccessType.PROVIDES.getName(), AccessType.REQUIRES.getName());
			}
		}
	}

	private void checkDefiningID(Connection conn) {
		// TODO enable for 2.1 compatibility checking
		String name = conn.getName();
		if (name == null || name.isEmpty()) {
			error(conn, "Connection is missing defining identifier. Required in AADL V2.1");
		}
	}

	/**
	 * Checks legality rule L13 for section 9.2 (Port Connections) "For
	 * connections between data ports, event data ports, and data access, the
	 * data classifier of the source port must match the data type of the
	 * destination port. The Classifier_Matching_Rule property specifies the
	 * rule to be applied to match the data classifier of a connection source to
	 * the data classifier of a connection destination."
	 *
	 * Checks legality rule L14 for section 9.2 (Port Connections) "The
	 * following rules are supported:
	 *
	 * -Classifier_Match: The source data type and data implementation must be
	 * identical to the data type or data implementation of the destination. If
	 * the destination classifier is a component type, then any implementation
	 * of the source matches. This is the default rule.
	 *
	 * -Equivalence: An indication that the two classifiers of a connection are
	 * considered to match if they are listed in the
	 * Supported_Classifier_Equivalence_Matches property. Acceptable data
	 * classifiers matches are specified as
	 * Supported_Classifier_Equivalence_Matches property with pairs of
	 * classifier values representing acceptable matches. Either element of the
	 * pair can be the source or destination classifier. Equivalence is intended
	 * to be used when the data types are considered to be identical, i.e., no
	 * conversion is necessary. The Supported_Classifier_Equivalence_Matches
	 * property is declared globally as a property constant.
	 *
	 * -Subset: A mapping of (a subset of) data elements of the source port data
	 * type to all data elements of the destination port data type. Acceptable
	 * data classifier matches are specified as
	 * Supported_Classifier_Subset_Matches property with pairs of classifier
	 * values representing acceptable matches. The first element of each pair
	 * specifies the acceptable source classifier, while the second element
	 * specifies the acceptable destination classifier. The
	 * Supported_Classifier_Subset_Matches property is declared globally as a
	 * property constant. A virtual bus or bus must represent a protocol that
	 * supports subsetting, such as OMG DDS.
	 *
	 * -Conversion: A mapping of the source port data type to the destination
	 * port data type, where the source port data type requires a conversion to
	 * the destination port data type. Acceptable data classifier matches are
	 * specified as Supported_Type_Conversions property with pairs of classifier
	 * values representing acceptable matches. The first element of each pair
	 * specifies the acceptable source classifier, while the second element
	 * specifies the acceptable destination classifier. The
	 * Supported_Type_Conversions property may be declared globally as a
	 * property constant. A virtual bus or bus must support the conversion from
	 * the source data classifier to the destination classifier."
	 */
	private void checkPortConnectionClassifiers(PortConnection connection) {
		ConnectionEnd source = connection.getAllSource();
		ConnectionEnd destination = connection.getAllDestination();
		if ((source instanceof DataAccess || source instanceof DataSubcomponent || source instanceof DataPort
				|| source instanceof EventDataPort)
				&& (destination instanceof DataAccess || destination instanceof DataSubcomponent
						|| destination instanceof DataPort || destination instanceof EventDataPort)) {
			Classifier sourceClassifier;
			Classifier destinationClassifier;
			if (source instanceof DataSubcomponent) {
				sourceClassifier = ((DataSubcomponent) source).getAllClassifier();
			} else {
				sourceClassifier = ((Feature) source).getAllClassifier();
			}
			if (destination instanceof DataSubcomponent) {
				destinationClassifier = ((DataSubcomponent) destination).getAllClassifier();
			} else {
				destinationClassifier = ((Feature) destination).getAllClassifier();
			}
			if (sourceClassifier == null && destinationClassifier != null) {
				warning('\'' + source.getName() + "' is missing a classifier.", connection,
						Aadl2Package.eINSTANCE.getConnection_Source());
			} else if (sourceClassifier != null && destinationClassifier == null) {
				warning('\'' + destination.getName() + "' is missing a classifier.", connection,
						Aadl2Package.eINSTANCE.getConnection_Destination());
			} else if (sourceClassifier != null && destinationClassifier != null) {
				Property classifierMatchingRuleProperty = GetProperties.lookupPropertyDefinition(connection,
						ModelingProperties._NAME, ModelingProperties.CLASSIFIER_MATCHING_RULE);
				EnumerationLiteral classifierMatchingRuleValue = null;
				if (classifierMatchingRuleProperty != null) {
					try {
						classifierMatchingRuleValue = PropertyUtils.getEnumLiteral(connection,
								classifierMatchingRuleProperty);
					} catch (PropertyNotPresentException e) {
						classifierMatchingRuleValue = null;
					}
				}
				if (classifierMatchingRuleValue == null
						|| ModelingProperties.CLASSIFIER_MATCH.equalsIgnoreCase(classifierMatchingRuleValue.getName())
				// ||
				// classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.COMPLEMENT)
				) {
					// if (classifierMatchingRuleValue != null &&
					// ModelingProperties.COMPLEMENT.equalsIgnoreCase(classifierMatchingRuleValue.getName()))
					// {
					// warning(connection, "The classifier matching rule '" +
					// ModelingProperties.COMPLEMENT + "' is not supported for
					// port connections. Using rule '" +
					// ModelingProperties.CLASSIFIER_MATCH +
					// "' instead.");
					// }
					if (!testClassifierMatchRule(connection, source, sourceClassifier, destination,
							destinationClassifier)) {
						error(connection, '\'' + source.getName() + "' and '" + destination.getName()
								+ "' have incompatible classifiers.");
					}
				} else if (classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.TYPE_EXTENSION)) {
					if (!AadlUtil.isokClassifierSubstitutionTypeExtension(destinationClassifier, sourceClassifier)) {
						warning("Source classifier " + sourceClassifier.getName()
								+ " is not a 'Type Extension' of destination " + destinationClassifier.getName(),
								connection, Aadl2Package.eINSTANCE.getConnection_Source());
					}
				} else if (ModelingProperties.EQUIVALENCE.equalsIgnoreCase(classifierMatchingRuleValue.getName())) {
					if (!testClassifierMatchRule(connection, source, sourceClassifier, destination,
							destinationClassifier)
							&& !classifiersFoundInSupportedClassifierEquivalenceMatchesProperty(connection,
									sourceClassifier, destinationClassifier)) {
						error(connection,
								"The types of '" + source.getName() + "' and '" + destination.getName() + "' ('"
										+ sourceClassifier.getQualifiedName() + "' and '"
										+ destinationClassifier.getQualifiedName()
										+ "') are incompatible and they are not listed as matching classifiers in the property constant '"
										+ AadlProject.SUPPORTED_CLASSIFIER_EQUIVALENCE_MATCHES + "'.");
					}
				} else if (ModelingProperties.SUBSET.equalsIgnoreCase(classifierMatchingRuleValue.getName())) {
					if (!testClassifierMatchRule(connection, source, sourceClassifier, destination,
							destinationClassifier)
							&& !classifiersFoundInSupportedClassifierSubsetMatchesProperty(connection, sourceClassifier,
									destinationClassifier)) {
						error(connection,
								"The types of '" + source.getName() + "' and '" + destination.getName() + "' ('"
										+ sourceClassifier.getQualifiedName() + "' and '"
										+ destinationClassifier.getQualifiedName()
										+ "') are incompatible and they are not listed as matching classifiers in the property constant '"
										+ AadlProject.SUPPORTED_CLASSIFIER_SUBSET_MATCHES + "'.");
					}
				} else if (ModelingProperties.CONVERSION.equalsIgnoreCase(classifierMatchingRuleValue.getName())) {
					if (!testClassifierMatchRule(connection, source, sourceClassifier, destination,
							destinationClassifier)
							&& !classifiersFoundInSupportedTypeConversionsProperty(connection, sourceClassifier,
									destinationClassifier)) {
						error(connection,
								"The types of '" + source.getName() + "' and '" + destination.getName() + "' ('"
										+ sourceClassifier.getQualifiedName() + "' and '"
										+ destinationClassifier.getQualifiedName()
										+ "') are incompatible and they are not listed as matching classifiers in the property constant '"
										+ AadlProject.SUPPORTED_TYPE_CONVERSIONS + "'.");
					}
				}
			}
		}
	}

	private boolean testClassifierMatchRule(Connection connection, ConnectionEnd source, Classifier sourceClassifier,
			ConnectionEnd destination, Classifier destinationClassifier) {
		if (sourceClassifier != destinationClassifier) {
			if (sourceClassifier instanceof ComponentType && destinationClassifier instanceof ComponentImplementation) {
				if (!sourceClassifier.equals(((ComponentImplementation) destinationClassifier).getType())) {
					warning(connection, "The types of '" + source.getName() + "' and '" + destination.getName()
							+ "' do not match.");
				}
			} else if (sourceClassifier instanceof ComponentImplementation
					&& destinationClassifier instanceof ComponentType) {
				if (!destinationClassifier.equals(((ComponentImplementation) sourceClassifier).getType())) {
					warning(connection, "The types of '" + source.getName() + "' and '" + destination.getName()
							+ "' do not match.");
				}
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean classifiersFoundInSupportedClassifierEquivalenceMatchesProperty(Connection connection,
			Classifier source, Classifier destination) {
		PropertyConstant matchesPropertyConstant = GetProperties.lookupPropertyConstant(connection,
				AadlProject.SUPPORTED_CLASSIFIER_EQUIVALENCE_MATCHES);
		if (matchesPropertyConstant == null) {
			return false;
		}
		PropertyExpression constantValue = matchesPropertyConstant.getConstantValue();
		if (!(constantValue instanceof ListValue)) {
			return false;
		}
		for (PropertyExpression classifierPair : ((ListValue) constantValue).getOwnedListElements()) {
			if (classifierPair instanceof ListValue) {
				EList<PropertyExpression> innerListElements = ((ListValue) classifierPair).getOwnedListElements();
				if (innerListElements.size() == 2 && innerListElements.get(0) instanceof ClassifierValue
						&& innerListElements.get(1) instanceof ClassifierValue) {
					Classifier firstPairElement = ((ClassifierValue) innerListElements.get(0)).getClassifier();
					Classifier secondPairElement = ((ClassifierValue) innerListElements.get(1)).getClassifier();
					if ((firstPairElement == source && secondPairElement == destination)
							|| (firstPairElement == destination && secondPairElement == source)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean classifiersFoundInSupportedClassifierSubsetMatchesProperty(Connection connection, Classifier source,
			Classifier destination) {
		PropertyConstant matchesPropertyConstant = GetProperties.lookupPropertyConstant(connection,
				AadlProject.SUPPORTED_CLASSIFIER_SUBSET_MATCHES);
		if (matchesPropertyConstant == null) {
			return false;
		}
		PropertyExpression constantValue = matchesPropertyConstant.getConstantValue();
		if (!(constantValue instanceof ListValue)) {
			return false;
		}
		for (PropertyExpression classifierPair : ((ListValue) constantValue).getOwnedListElements()) {
			if (classifierPair instanceof ListValue) {
				EList<PropertyExpression> innerListElements = ((ListValue) classifierPair).getOwnedListElements();
				if (innerListElements.size() == 2 && innerListElements.get(0) instanceof ClassifierValue
						&& innerListElements.get(1) instanceof ClassifierValue) {
					Classifier firstPairElement = ((ClassifierValue) innerListElements.get(0)).getClassifier();
					Classifier secondPairElement = ((ClassifierValue) innerListElements.get(1)).getClassifier();
					if (firstPairElement == source && secondPairElement == destination) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean classifiersFoundInSupportedTypeConversionsProperty(Connection connection, Classifier source,
			Classifier destination) {
		PropertyConstant conversionsPropertyConstant = GetProperties.lookupPropertyConstant(connection,
				AadlProject.SUPPORTED_TYPE_CONVERSIONS);
		if (conversionsPropertyConstant == null) {
			return false;
		}
		PropertyExpression constantValue = conversionsPropertyConstant.getConstantValue();
		if (!(constantValue instanceof ListValue)) {
			return false;
		}
		for (PropertyExpression classifierPair : ((ListValue) constantValue).getOwnedListElements()) {
			if (classifierPair instanceof ListValue) {
				EList<PropertyExpression> innerListElements = ((ListValue) classifierPair).getOwnedListElements();
				if (innerListElements.size() == 2 && innerListElements.get(0) instanceof ClassifierValue
						&& innerListElements.get(1) instanceof ClassifierValue) {
					Classifier firstPairElement = ((ClassifierValue) innerListElements.get(0)).getClassifier();
					Classifier secondPairElement = ((ClassifierValue) innerListElements.get(1)).getClassifier();
					if (firstPairElement == source && secondPairElement == destination) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private void checkFeatureRefinementClassifierSubstitution(Feature feature) {
		if (!Aadl2Util.isNull(feature.getRefined())) {
			Classifier refinedCl = feature.getClassifier();
			Classifier originalCl = feature.getRefined().getClassifier();
			if (!Aadl2Util.isNull(refinedCl) && !Aadl2Util.isNull(originalCl)) {
				checkClassifierSubstitutionMatch(feature, originalCl, refinedCl);
			}
		}
	}

	private void checkSubcomponentRefinementClassifierSubstitution(Subcomponent subcomponent) {
		if (!Aadl2Util.isNull(subcomponent.getRefined())) {
			ComponentClassifier refinedCl = subcomponent.getClassifier();
			ComponentClassifier originalCl = subcomponent.getRefined().getClassifier();
			if (!Aadl2Util.isNull(refinedCl) && !Aadl2Util.isNull(originalCl)) {
				checkClassifierSubstitutionMatch(subcomponent, originalCl, refinedCl);
			}
		}
	}

	private void checkClassifierSubstitutionMatch(NamedElement target, Classifier originalClassifier,
			Classifier refinedClassifier) {
		Property classifierMatchingRuleProperty = GetProperties.lookupPropertyDefinition(target,
				ModelingProperties._NAME, ModelingProperties.CLASSIFIER_SUBSTITUTION_RULE);
		EnumerationLiteral classifierMatchingRuleValue;
		try {
			classifierMatchingRuleValue = PropertyUtils.getEnumLiteral(target, classifierMatchingRuleProperty);
		} catch (PropertyLookupException e) {
			classifierMatchingRuleValue = null;
		}
		if (classifierMatchingRuleValue == null
				|| ModelingProperties.CLASSIFIER_MATCH.equalsIgnoreCase(classifierMatchingRuleValue.getName())) {
			if (!AadlUtil.isokClassifierSubstitutionMatch(originalClassifier, refinedClassifier)) {
				warning(target, "Classifier " + originalClassifier.getName() + " refined to "
						+ refinedClassifier.getName() + " does not satisfy 'Classifier Match'");
			}
		} else if (classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.TYPE_EXTENSION)) {
			if (!AadlUtil.isokClassifierSubstitutionTypeExtension(originalClassifier, refinedClassifier)) {
				warning(target, "Classifier " + originalClassifier.getName() + " refined to "
						+ refinedClassifier.getName() + " does not satisfy 'Type Extension'");
			}
		} else if (ModelingProperties.SIGNATURE_MATCH.equalsIgnoreCase(classifierMatchingRuleValue.getName())) {
			info(target, "Signature Match checking in clasifier substitution of refinement check not implemented yet.");
		}
	}

	private void checkFeatureConnectionFeatureGroupToFeatureOrAbstract(Connection connection) {
		ConnectionEnd source = connection.getAllSource();
		ConnectionEnd destination = connection.getAllDestination();
		if (source instanceof FeatureGroup
				&& !(destination instanceof FeatureGroup || destination instanceof AbstractFeature)) {
			error(connection,
					"If source is a Feature Group then destination must be either a Feature Group or an Abstract Feature.");
		}
		if (destination instanceof FeatureGroup
				&& !(source instanceof FeatureGroup || source instanceof AbstractFeature)) {
			error(connection,
					"If destination is a Feature Group then source must be either a Feature Group or an Abstract Feature.");
		}
	}

	/**
	 * Check direction of ConnectionEnd in connections
	 */
	private void checkConnectionDirection(Connection connection) {
		ConnectionEnd source = connection.getAllSource();
		ConnectionEnd destination = connection.getAllDestination();
		if (source instanceof ConnectionEnd && destination instanceof ConnectionEnd) {
			DirectionType srcDirection = DirectionType.IN_OUT;
			DirectionType dstDirection = DirectionType.IN_OUT;
			if (source instanceof DirectedFeature) {
				srcDirection = ((DirectedFeature) source).getDirection();
			}
			if (destination instanceof DirectedFeature) {
				dstDirection = ((DirectedFeature) destination).getDirection();
			}
			if (source instanceof DataSubcomponent || source instanceof DataAccess) {
				// TODO check access right to limit to in or out
			}
			if (destination instanceof DataSubcomponent || destination instanceof DataAccess) {
				// TODO check access right to limit to in or out
			}
			Context srcContext = connection.getAllSourceContext();
			Context dstContext = connection.getAllDestinationContext();
			if (srcContext instanceof FeatureGroup) {
				if (((FeatureGroup) srcContext).isInverse()) {
					srcDirection = srcDirection.getInverseDirection();
				}
				FeatureGroupType srcFGT = getFGTforPrototype(((FeatureGroup) srcContext).getFeatureType());
				FeatureGroupType contsrcFGT = (FeatureGroupType) ((Feature) source).getContainingClassifier();
				if (srcFGT != contsrcFGT && !Aadl2Util.isNull(srcFGT) && srcFGT.getInverse() != null) {
					// feature group type has inverse and feature is defined in
					// the inverse FGT
					srcDirection = srcDirection.getInverseDirection();
				}
			}
			if (dstContext instanceof FeatureGroup) {
				if (((FeatureGroup) dstContext).isInverse()) {
					dstDirection = dstDirection.getInverseDirection();
				}
				FeatureGroupType dstFGT = getFGTforPrototype(((FeatureGroup) dstContext).getFeatureType());
				FeatureGroupType contdstFGT = (FeatureGroupType) ((Feature) destination).getContainingClassifier();
				if (dstFGT != contdstFGT && !Aadl2Util.isNull(dstFGT) && dstFGT.getInverse() != null) {
					dstDirection = dstDirection.getInverseDirection();
				}
			}
			if ((srcContext instanceof Subcomponent && dstContext instanceof Subcomponent)
					// between ports of subcomponents
					|| (srcContext == null && source instanceof DataSubcomponent && dstContext instanceof Subcomponent)
					// from a data subcomponent to a port
					|| (dstContext == null && destination instanceof DataSubcomponent
							&& srcContext instanceof Subcomponent)
			// from a data subcomponent to a port
			) {
				if (!(srcDirection.outgoing() && dstDirection.incoming())) {
					error(connection, "Source must be outgoing and destination incoming.");
				}
			} else if ((srcContext instanceof Subcomponent || dstContext instanceof Subcomponent)
					|| (srcContext instanceof SubprogramCall || dstContext instanceof SubprogramCall)) {
				// going up or down hierarchy
				if (!sameDirection(srcDirection, dstDirection)) {
					error(connection, "Source feature '" + source.getName() + "' and destination feature '"
							+ destination.getName() + "' must have same direction.");
				}
				if ((srcContext instanceof Subcomponent) || (srcContext instanceof SubprogramCall)) {
					if (!(srcDirection.outgoing())) {
						error("Outgoing connection requires outgoing feature '" + srcContext.getName() + "."
								+ source.getName() + "'.", connection, Aadl2Package.eINSTANCE.getConnection_Source());
					}
					if (!(dstDirection.outgoing())) {
						error("Outgoing connection requires outgoing feature '" + destination.getName() + "'.",
								connection, Aadl2Package.eINSTANCE.getConnection_Destination());
					}
				}
				if ((dstContext instanceof Subcomponent) || (dstContext instanceof SubprogramCall)) {
					if (!(dstDirection.incoming())) {
						error("Incoming connection requires incoming feature '" + dstContext.getName() + "."
								+ destination.getName() + "'.", connection,
								Aadl2Package.eINSTANCE.getConnection_Destination());
					}
					if (!(srcDirection.incoming())) {
						error("Incoming connection requires incoming feature '" + source.getName() + "'.", connection,
								Aadl2Package.eINSTANCE.getConnection_Source());
					}
				}
			} else if (source instanceof InternalFeature || destination instanceof InternalFeature) {
				// internal event or event data port. One is acceptable, but not both.
				if (source instanceof InternalFeature && destination instanceof InternalFeature) {
					error(connection, "Cannot connect two internal features of the containing component.");
				}
			} else {
				// we have a connection a component implementation going
				// directly from its incoming feature to an outgoing feature
				error(connection,
						"Illegal connection: Cannot directly connect two features of the containing component.");
			}
		}
	}

	//
	// /**
	// * Check direction of ConnectionEnd in port connections
	// */
	// private void checkFeatureConnectionDirection(Connection connection) {
	// ConnectionEnd source = connection.getAllSource();
	// ConnectionEnd destination = connection.getAllDestination();
	// if (source instanceof FeatureConnectionEnd && destination instanceof
	// FeatureConnectionEnd) {
	// DirectionType srcDirection = DirectionType.IN_OUT;
	// DirectionType dstDirection = DirectionType.IN_OUT;
	// if (source instanceof DirectedFeature) {
	// srcDirection = ((DirectedFeature) source).getDirection();
	// }
	// if (destination instanceof DirectedFeature) {
	// dstDirection = ((DirectedFeature) destination).getDirection();
	// }
	// Context srcContext = connection.getAllSourceContext();
	// Context dstContext = connection.getAllDestinationContext();
	// if (srcContext instanceof FeatureGroup) {
	// if (((FeatureGroup) srcContext).isInverse()) {
	// srcDirection = srcDirection.getInverseDirection();
	// }
	// FeatureGroupType srcFGT = getFGTforPrototype(((FeatureGroup)
	// srcContext).getFeatureType());
	// FeatureGroupType contsrcFGT = (FeatureGroupType) ((Feature)
	// source).getContainingClassifier();
	// if (srcFGT != contsrcFGT && !Aadl2Util.isNull(srcFGT) &&
	// srcFGT.getInverse() != null) {
	// // feature group type has inverse and feature is defined in the inverse
	// FGT
	// srcDirection = srcDirection.getInverseDirection();
	// }
	// }
	// if (dstContext instanceof FeatureGroup) {
	// if (((FeatureGroup) dstContext).isInverse()) {
	// dstDirection = dstDirection.getInverseDirection();
	// }
	// FeatureGroupType dstFGT = getFGTforPrototype(((FeatureGroup)
	// dstContext).getFeatureType());
	// FeatureGroupType contdstFGT = (FeatureGroupType) ((Feature)
	// destination).getContainingClassifier();
	// if (dstFGT != contdstFGT && !Aadl2Util.isNull(dstFGT) &&
	// dstFGT.getInverse() != null) {
	// dstDirection = dstDirection.getInverseDirection();
	// }
	// }
	// if ((srcContext instanceof Subcomponent && dstContext instanceof
	// Subcomponent)
	// // between ports of subcomponents
	// || (srcContext == null && source instanceof DataSubcomponent &&
	// dstContext instanceof Subcomponent)
	// // from a data subcomponent to a port
	// || (dstContext == null && destination instanceof DataSubcomponent &&
	// srcContext instanceof Subcomponent)
	// // from a data subcomponent to a port
	// ) {
	// if (!(srcDirection.outgoing() && dstDirection.incoming())) {
	// error(connection, "Source must be outgoing and destination incoming.");
	// }
	// } else if ((srcContext instanceof Subcomponent || dstContext instanceof
	// Subcomponent)
	// || (srcContext instanceof SubprogramCall || dstContext instanceof
	// SubprogramCall)) {
	// // going up or down hierarchy
	// if (!sameDirection(srcDirection, dstDirection)) {
	// error(connection, "Source feature '" + source.getName() + "' and
	// destination feature '"
	// + destination.getName() + "' must have same direction.");
	// }
	// if ((srcContext instanceof Subcomponent) || (srcContext instanceof
	// SubprogramCall)) {
	// if (!(srcDirection.outgoing())) {
	// error("Outgoing connection requires outgoing feature '" +
	// srcContext.getName() + "."
	// + source.getName() + "'.", connection,
	// Aadl2Package.eINSTANCE.getConnection_Source());
	// }
	// if (!(dstDirection.outgoing())) {
	// error("Outgoing connection requires outgoing feature '" +
	// destination.getName() + "'.",
	// connection, Aadl2Package.eINSTANCE.getConnection_Destination());
	// }
	// }
	// if ((dstContext instanceof Subcomponent) || (dstContext instanceof
	// SubprogramCall)) {
	// if (!(dstDirection.incoming())) {
	// error("Incoming connection requires incoming feature '" +
	// dstContext.getName() + "."
	// + destination.getName() + "'.", connection,
	// Aadl2Package.eINSTANCE.getConnection_Destination());
	// }
	// if (!(srcDirection.incoming())) {
	// error("Incoming connection requires incoming feature '" +
	// source.getName() + "'.", connection,
	// Aadl2Package.eINSTANCE.getConnection_Source());
	// }
	// }
	// } else {
	//
	// // we have a connection a component implementation going directly from
	// its incoming feature to an outgoing feature
	// if (!(srcDirection.incoming() && dstDirection.outgoing())) {
	// error(connection, "Source feature '" + source.getName()
	// + "' must be incoming and destination feature '" + destination.getName()
	// + "' must be outgoing.");
	// }
	// }
	// }
	// }

	/**
	 * @param proto
	 * @return the feature group type or null
	 */
	private FeatureGroupType getFGTforPrototype(org.osate.aadl2.FeatureType ft) {
		if (Aadl2Util.isNull(ft)) {
			return null;
		}

		if (ft instanceof FeatureGroupType) {
			return (FeatureGroupType) ft;
		}

		FeatureGroupPrototype proto = (FeatureGroupPrototype) ft;
		ComponentImplementation impl = proto.getContainingComponentImpl();

		for (PrototypeBinding b : impl.getOwnedPrototypeBindings()) {
			if (b.getFormal() == proto) {
				FeatureGroupPrototypeActual actual = ((FeatureGroupPrototypeBinding) b).getActual();
				if (!Aadl2Util.isNull(actual)) {
					return getFGTforPrototype(actual.getFeatureType());
				}
			}
		}
		// no binding found
		return null;
	}

	/**
	 * Check connection ends of port connections Section 9.2 Legality rule L5
	 */
	private void checkPortConnectionEnds(PortConnection connection) {
		ConnectionEnd source = connection.getAllSource();
		ConnectionEnd destination = connection.getAllDestination();
		if (source instanceof PortConnectionEnd && destination instanceof PortConnectionEnd) {
			if (source instanceof EventPort
					&& !(destination instanceof EventPort || destination instanceof EventSource)) {
				error(connection, "Source event port '" + source.getName()
						+ "' must be connected to an (internal) event port destination.");
				return;
			}
			if (source instanceof EventSource && !(destination instanceof EventPort)) {
				error(connection, "Source internal event port '" + source.getName()
						+ "' must be connected to an event port destination.");
				return;
			}
			if (source instanceof DataPort && !(destination instanceof EventPort || destination instanceof DataPort
					|| destination instanceof EventDataPort || destination instanceof DataSubcomponent
					|| destination instanceof DataAccess)) {
				error(connection, "Source data port '" + source.getName()
						+ "' must be connected to an event, data, or event data port, data subcomponent or data access destination.");
				return;
			}
			if (source instanceof EventDataPort && !(destination instanceof EventPort || destination instanceof DataPort
					|| destination instanceof EventDataPort || destination instanceof DataSubcomponent
					|| destination instanceof DataAccess || destination instanceof EventDataSource)) {
				error(connection, "Source event data port '" + source.getName()
						+ "' must be connected to an event, data, or event data port, internal event data port, data subcomponent or data access destination.");
				return;
			}
			if (source instanceof DataSubcomponent && !(destination instanceof EventPort
					|| destination instanceof DataPort || destination instanceof EventDataPort)) {
				error(connection, "Source data subcomponent '" + source.getName()
						+ "' must be connected to an event, data, or event data port destination.");
				return;
			}
			if (source instanceof DataAccess && !(destination instanceof EventPort || destination instanceof DataPort
					|| destination instanceof EventDataPort)) {
				error(connection, "Source data access feature '" + source.getName()
						+ "' must be connected to an event, data, or event data port destination.");
				return;
			}
			if (source instanceof EventDataSource
					&& !(destination instanceof EventDataPort || destination instanceof DataPort)) {
				error(connection, "Source internal event data port '" + source.getName()
						+ "' must be connected to an event data port destination.");
				return;
			}
		}
	}

	/**
	 * Checks legality rule L4 for section 9.3 (Parameter Connections) "The data
	 * classifier of the source and destination must match. The matching rules
	 * as specified by the Classifier_Matching_Rule property apply (see Section
	 * 9.2 (L13)). By default the data classifiers must be match."
	 */
	private void checkParameterConnectionClassifiers(ParameterConnection connection) {
		ConnectionEnd source = connection.getAllSource();
		ConnectionEnd destination = connection.getAllDestination();
		if (source instanceof ParameterConnectionEnd && destination instanceof ParameterConnectionEnd) {
			Classifier sourceClassifier;
			Classifier destinationClassifier;
			if (source instanceof DataSubcomponent) {
				sourceClassifier = ((DataSubcomponent) source).getAllClassifier();
			} else {
				sourceClassifier = ((Feature) source).getAllClassifier();
			}
			if (destination instanceof DataSubcomponent) {
				destinationClassifier = ((DataSubcomponent) destination).getAllClassifier();
			} else {
				destinationClassifier = ((Feature) destination).getAllClassifier();
			}
			if (sourceClassifier == null && destinationClassifier != null) {
				warning('\'' + source.getName() + "' is missing a classifier.", connection,
						Aadl2Package.eINSTANCE.getConnection_Source());
			} else if (sourceClassifier != null && destinationClassifier == null) {
				warning('\'' + destination.getName() + "' is missing a classifier.", connection,
						Aadl2Package.eINSTANCE.getConnection_Destination());
			} else if (sourceClassifier != null && destinationClassifier != null) {
				Property classifierMatchingRuleProperty = GetProperties.lookupPropertyDefinition(connection,
						ModelingProperties._NAME, ModelingProperties.CLASSIFIER_MATCHING_RULE);
				EnumerationLiteral classifierMatchingRuleValue;
				try {
					classifierMatchingRuleValue = PropertyUtils.getEnumLiteral(connection,
							classifierMatchingRuleProperty);
				} catch (PropertyNotPresentException e) {
					classifierMatchingRuleValue = null;
				}
				if (classifierMatchingRuleValue == null
						|| classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.CLASSIFIER_MATCH)
				// ||
				// classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.COMPLEMENT)
				) {
					// if (classifierMatchingRuleValue != null &&
					// classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.COMPLEMENT))
					// {
					// warning(connection, "The classifier matching rule '" +
					// ModelingProperties.COMPLEMENT + "' is not supported for
					// parameter connections. Using rule '" +
					// ModelingProperties.CLASSIFIER_MATCH +
					// "' instead.");
					// }
					if (!testClassifierMatchRule(connection, source, sourceClassifier, destination,
							destinationClassifier)) {
						error(connection, '\'' + source.getName() + "' and '" + destination.getName()
								+ "' have incompatible classifiers.");
					}
				} else if (classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.TYPE_EXTENSION)) {
					if (!AadlUtil.isokClassifierSubstitutionTypeExtension(destinationClassifier, sourceClassifier)) {
						warning("Source classifier " + sourceClassifier.getName()
								+ " is not a 'Type Extension' of destination " + destinationClassifier.getName(),
								connection, Aadl2Package.eINSTANCE.getConnection_Source());
					}
				} else if (classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.EQUIVALENCE)) {
					if (!testClassifierMatchRule(connection, source, sourceClassifier, destination,
							destinationClassifier)
							&& !classifiersFoundInSupportedClassifierEquivalenceMatchesProperty(connection,
									sourceClassifier, destinationClassifier)) {
						error(connection,
								"The types of '" + source.getName() + "' and '" + destination.getName() + "' ('"
										+ sourceClassifier.getQualifiedName() + "' and '"
										+ destinationClassifier.getQualifiedName()
										+ "') are incompatible and they are not listed as matching classifiers in the property constant '"
										+ AadlProject.SUPPORTED_CLASSIFIER_EQUIVALENCE_MATCHES + "'.");
					}
				} else if (classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.SUBSET)) {
					if (!testClassifierMatchRule(connection, source, sourceClassifier, destination,
							destinationClassifier)
							&& !classifiersFoundInSupportedClassifierSubsetMatchesProperty(connection, sourceClassifier,
									destinationClassifier)) {
						error(connection,
								"The types of '" + source.getName() + "' and '" + destination.getName() + "' ('"
										+ sourceClassifier.getQualifiedName() + "' and '"
										+ destinationClassifier.getQualifiedName()
										+ "') are incompatible and they are not listed as matching classifiers in the property constant '"
										+ AadlProject.SUPPORTED_CLASSIFIER_SUBSET_MATCHES + "'.");
					}
				} else if (classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.CONVERSION)) {
					if (!testClassifierMatchRule(connection, source, sourceClassifier, destination,
							destinationClassifier)
							&& !classifiersFoundInSupportedTypeConversionsProperty(connection, sourceClassifier,
									destinationClassifier)) {
						error(connection,
								"The types of '" + source.getName() + "' and '" + destination.getName() + "' ('"
										+ sourceClassifier.getQualifiedName() + "' and '"
										+ destinationClassifier.getQualifiedName()
										+ "') are incompatible and they are not listed as matching classifiers in the property constant '"
										+ AadlProject.SUPPORTED_TYPE_CONVERSIONS + "'.");
					}
				}
			}
		}
	}

	private void typeCheckAccessConnectionEnd(ConnectedElement connectedElement) {
		Context connectionContext = connectedElement.getContext();
		ConnectionEnd connectionEnd = connectedElement.getConnectionEnd();
		if ((connectionContext != null && connectionContext.eIsProxy()) || connectionEnd == null
				|| connectionEnd.eIsProxy()) {
			// Don't validate if the context or connection end could not be
			// resolved.
			return;
		}
		if (connectionContext == null) {
			if (!(connectionEnd instanceof AccessConnectionEnd)) {
				error(StringExtensions.toFirstUpper(getEClassDisplayNameWithIndefiniteArticle(connectionEnd.eClass()))
						+ " is not a valid access connection end.", connectedElement,
						Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd());
			}
		} else if (connectionContext instanceof Subcomponent || connectionContext instanceof FeatureGroup
				|| connectionContext instanceof SubprogramCall) {
			if (!(connectionEnd instanceof Access
					|| (connectionEnd instanceof DataSubcomponent && (connectionContext instanceof DataSubcomponent
							|| connectionContext instanceof AbstractSubcomponent)))) {
				error(StringExtensions.toFirstUpper(getEClassDisplayNameWithIndefiniteArticle(connectionEnd.eClass()))
						+ " in " + getEClassDisplayNameWithIndefiniteArticle(connectionContext.eClass())
						+ " is not a valid access connection end.", connectedElement,
						Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd());
			}
		} else {
			error("Anything in " + getEClassDisplayNameWithIndefiniteArticle(connectionContext.eClass())
					+ " is not a valid access connection end.", connectedElement,
					Aadl2Package.eINSTANCE.getConnectedElement_Context());
		}
	}

	private void typeCheckFeatureConnectionEnd(ConnectedElement connectedElement) {
		Context connectionContext = connectedElement.getContext();
		ConnectionEnd connectionEnd = connectedElement.getConnectionEnd();
		if ((connectionContext != null && connectionContext.eIsProxy()) || connectionEnd == null
				|| connectionEnd.eIsProxy()) {
			// Don't validate if the context or connection end could not be
			// resolved.
			return;
		}
		if (connectionContext == null) {
			if (!(connectionEnd instanceof FeatureConnectionEnd)) {
				error(StringExtensions.toFirstUpper(getEClassDisplayNameWithIndefiniteArticle(connectionEnd.eClass()))
						+ " is not a valid feature connection end.", connectedElement,
						Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd());
			}
		} else if (connectionContext instanceof Subcomponent || connectionContext instanceof FeatureGroup
				|| connectionContext instanceof SubprogramCall) {
			if (!(connectionEnd instanceof Feature)) {
				error(StringExtensions.toFirstUpper(getEClassDisplayNameWithIndefiniteArticle(connectionEnd.eClass()))
						+ " in " + getEClassDisplayNameWithIndefiniteArticle(connectionContext.eClass())
						+ " is not a valid feature connection end.", connectedElement,
						Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd());
			}
		} else {
			error("Anything in " + getEClassDisplayNameWithIndefiniteArticle(connectionContext.eClass())
					+ " is not a valid feature connection end.", connectedElement,
					Aadl2Package.eINSTANCE.getConnectedElement_Context());
		}
	}

	private void typeCheckFeatureGroupConnectionEnd(ConnectedElement connectedElement) {
		Context connectionContext = connectedElement.getContext();
		ConnectionEnd connectionEnd = connectedElement.getConnectionEnd();
		if ((connectionContext != null && connectionContext.eIsProxy()) || connectionEnd == null
				|| connectionEnd.eIsProxy()) {
			// Don't validate if the context or connection end could not be
			// resolved.
			return;
		}
		if (connectionContext == null) {
			if (!(connectionEnd instanceof FeatureGroupConnectionEnd)) {
				error(StringExtensions.toFirstUpper(getEClassDisplayNameWithIndefiniteArticle(connectionEnd.eClass()))
						+ " is not a valid feature group connection end.", connectedElement,
						Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd());
			}
		} else if (connectionContext instanceof Subcomponent || connectionContext instanceof FeatureGroup) {
			if (!(connectionEnd instanceof FeatureGroupConnectionEnd)) {
				error(StringExtensions.toFirstUpper(getEClassDisplayNameWithIndefiniteArticle(connectionEnd.eClass()))
						+ " in " + getEClassDisplayNameWithIndefiniteArticle(connectionContext.eClass())
						+ " is not a valid feature group connection end.", connectedElement,
						Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd());
			}
		} else {
			error("Anything in " + getEClassDisplayNameWithIndefiniteArticle(connectionContext.eClass())
					+ " is not a valid feature group connection end.", connectedElement,
					Aadl2Package.eINSTANCE.getConnectedElement_Context());
		}
	}

	private void typeCheckParameterConnectionEnd(ConnectedElement connectedElement) {
		Context connectionContext = connectedElement.getContext();
		ConnectionEnd connectionEnd = connectedElement.getConnectionEnd();
		if ((connectionContext != null && connectionContext.eIsProxy()) || connectionEnd == null
				|| connectionEnd.eIsProxy()) {
			// Don't validate if the context or connection end could not be
			// resolved.
			return;
		}
		if (connectionContext == null) {
			if (!(connectionEnd instanceof ParameterConnectionEnd)) {
				error(StringExtensions.toFirstUpper(getEClassDisplayNameWithIndefiniteArticle(connectionEnd.eClass()))
						+ " is not a valid parameter connection end.", connectedElement,
						Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd());
			}
		} else if (connectionContext instanceof Parameter || connectionContext instanceof DataPort
				|| connectionContext instanceof EventDataPort) {
			if (!(connectionEnd instanceof DataSubcomponent)) {
				error(StringExtensions.toFirstUpper(getEClassDisplayNameWithIndefiniteArticle(connectionEnd.eClass()))
						+ " in " + getEClassDisplayNameWithIndefiniteArticle(connectionContext.eClass())
						+ " is not a valid parameter connection end.", connectedElement,
						Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd());
			}
		} else if (connectionContext instanceof SubprogramCall) {
			if (!(connectionEnd instanceof Parameter)) {
				error(StringExtensions.toFirstUpper(getEClassDisplayNameWithIndefiniteArticle(connectionEnd.eClass()))
						+ " in " + getEClassDisplayNameWithIndefiniteArticle(connectionContext.eClass())
						+ " is not a valid parameter connection end.", connectedElement,
						Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd());
			}
		} else if (connectionContext instanceof FeatureGroup) {
			if (!(connectionEnd instanceof ParameterConnectionEnd)) {
				error(StringExtensions.toFirstUpper(getEClassDisplayNameWithIndefiniteArticle(connectionEnd.eClass()))
						+ " in " + getEClassDisplayNameWithIndefiniteArticle(connectionContext.eClass())
						+ " is not a valid parameter connection end.", connectedElement,
						Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd());
			}
		} else {
			error("Anything in " + getEClassDisplayNameWithIndefiniteArticle(connectionContext.eClass())
					+ " is not a valid parameter connection end.", connectedElement,
					Aadl2Package.eINSTANCE.getConnectedElement_Context());
		}
	}

	private void typeCheckPortConnectionEnd(ConnectedElement connectedElement) {
		Context connectionContext = connectedElement.getContext();
		ConnectionEnd connectionEnd = connectedElement.getConnectionEnd();
		if ((connectionContext != null && connectionContext.eIsProxy()) || connectionEnd == null
				|| connectionEnd.eIsProxy()) {
			// Don't validate if the context or connection end could not be
			// resolved.
			return;
		}
		if (connectionContext == null) {
			if (!(connectionEnd instanceof PortConnectionEnd)) {
				error(StringExtensions.toFirstUpper(getEClassDisplayNameWithIndefiniteArticle(connectionEnd.eClass()))
						+ " is not a valid port connection end.", connectedElement,
						Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd());
			}
		} else if (connectionContext instanceof FeatureGroup || connectionContext instanceof SubprogramCall) {
			if (!(connectionEnd instanceof PortConnectionEnd) || connectionEnd instanceof InternalFeature
					|| connectionEnd instanceof PortProxy) {
				error(StringExtensions.toFirstUpper(getEClassDisplayNameWithIndefiniteArticle(connectionEnd.eClass()))
						+ " in " + getEClassDisplayNameWithIndefiniteArticle(connectionContext.eClass())
						+ " is not a valid port connection end.", connectedElement,
						Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd());
			}
		} else if (connectionContext instanceof Subcomponent) {
			if (!(connectionEnd instanceof Port || connectionEnd instanceof DataAccess)
					&& !(connectionContext instanceof DataSubcomponent && connectionEnd instanceof DataSubcomponent)) {
				error(StringExtensions.toFirstUpper(getEClassDisplayNameWithIndefiniteArticle(connectionEnd.eClass()))
						+ " in " + getEClassDisplayNameWithIndefiniteArticle(connectionContext.eClass())
						+ " is not a valid port connection end.", connectedElement,
						Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd());
			}
		} else if (connectionContext instanceof DataPort || connectionContext instanceof EventDataPort) {
			if (!(connectionEnd instanceof DataSubcomponent)) {
				error(StringExtensions.toFirstUpper(getEClassDisplayNameWithIndefiniteArticle(connectionEnd.eClass()))
						+ " in " + getEClassDisplayNameWithIndefiniteArticle(connectionContext.eClass())
						+ " is not a valid port connection end.", connectedElement,
						Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd());
			}
		} else {
			error("Anything in " + getEClassDisplayNameWithIndefiniteArticle(connectionContext.eClass())
					+ " is not a valid port connection end.", connectedElement,
					Aadl2Package.eINSTANCE.getConnectedElement_Context());
		}
	}

	private void typeCheckModeTransitionTrigger(ModeTransitionTrigger trigger) {
		Context triggerContext = trigger.getContext();
		TriggerPort triggerPort = trigger.getTriggerPort();
		if ((triggerContext != null && triggerContext.eIsProxy()) || triggerPort == null || triggerPort.eIsProxy()) {
			// Don't validate if the context or trigger port could not be
			// resolved.
			return;
		}
		if (triggerContext instanceof Subcomponent || triggerContext instanceof FeatureGroup
				|| triggerContext instanceof SubprogramCall) {
			if (!(triggerPort instanceof AbstractFeature || triggerPort instanceof Port)) {
				error(StringExtensions.toFirstUpper(getEClassDisplayNameWithIndefiniteArticle(triggerPort.eClass()))
						+ " in " + getEClassDisplayName(triggerContext.eClass())
						+ " is not a valid mode transition trigger.", trigger,
						Aadl2Package.eINSTANCE.getModeTransitionTrigger_TriggerPort());
			}
		} else if (triggerContext != null) {
			error("Anything in " + getEClassDisplayNameWithIndefiniteArticle(triggerContext.eClass())
					+ " is not a valid mode transition trigger.", trigger,
					Aadl2Package.eINSTANCE.getModeTransitionTrigger_Context());
		}
	}

	private static String getEClassDisplayName(EClass eClass) {
		StringBuilder displayName = new StringBuilder(eClass.getName());
		for (int i = displayName.length() - 1; i > 0; i--) {
			if (Character.isUpperCase(displayName.charAt(i))) {
				displayName.insert(i, ' ');
			}
		}
		return displayName.toString();
	}

	/**
	 * Check category of source and destination Section 9.4 Legality rule L11
	 */
	private void checkAccessConnectionCategory(AccessConnection connection) {
		AccessCategory connectionCategory = connection.getAccessCategory();

		ConnectionEnd source = connection.getAllSource();
		AccessCategory sourceCategory = null;
		if (source instanceof SubprogramProxy) {
			sourceCategory = AccessCategory.SUBPROGRAM;
		} else if (source instanceof Access) {
			sourceCategory = ((Access) source).getCategory();
		} else if (source instanceof BusSubcomponent) {
			sourceCategory = AccessCategory.BUS;
		} else if (source instanceof DataSubcomponent) {
			sourceCategory = AccessCategory.DATA;
		} else if (source instanceof SubprogramSubcomponent) {
			sourceCategory = AccessCategory.SUBPROGRAM;
		} else if (source instanceof SubprogramGroupSubcomponent) {
			sourceCategory = AccessCategory.SUBPROGRAM_GROUP;
		}

		ConnectionEnd destination = connection.getAllDestination();
		AccessCategory destinationCategory = null;
		if (destination instanceof SubprogramProxy) {
			destinationCategory = AccessCategory.SUBPROGRAM;
		} else if (destination instanceof Access) {
			destinationCategory = ((Access) destination).getCategory();
		} else if (destination instanceof BusSubcomponent) {
			destinationCategory = AccessCategory.BUS;
		} else if (destination instanceof DataSubcomponent) {
			destinationCategory = AccessCategory.DATA;
		} else if (destination instanceof SubprogramSubcomponent) {
			destinationCategory = AccessCategory.SUBPROGRAM;
		} else if (destination instanceof SubprogramGroupSubcomponent) {
			destinationCategory = AccessCategory.SUBPROGRAM_GROUP;
		}

		if (sourceCategory != null && !connectionCategory.equals(sourceCategory)) {
			error("The source of a " + connectionCategory.getName() + " access connection must be a "
					+ connectionCategory.getName() + " access feature or a " + connectionCategory.getName()
					+ " subcomponent.", connection, Aadl2Package.eINSTANCE.getConnection_Source());
		}

		if (destinationCategory != null && !connectionCategory.equals(destinationCategory)) {
			error("The destination of a " + connectionCategory.getName() + " access connection must be a "
					+ connectionCategory.getName() + " access feature or a " + connectionCategory.getName()
					+ " subcomponent.", connection, Aadl2Package.eINSTANCE.getConnection_Destination());
		}
	}

	/**
	 * Check provides/requires of access connection ends Section 9.4 Legality
	 * rules L5, L6, and L7
	 */
	private void checkAccessConnectionProvidesRequires(AccessConnection connection) {
		ConnectionEnd source = connection.getAllSource();
		ConnectionEnd destination = connection.getAllDestination();
		AccessType sourceType = null;
		AccessType destinationType = null;
		Context srcContext = connection.getAllSourceContext();
		Context dstContext = connection.getAllDestinationContext();

		if (source instanceof Access) {
			sourceType = ((Access) source).getKind();
			if (srcContext instanceof FeatureGroup) {
				if (((FeatureGroup) srcContext).isInverse()) {
					sourceType = sourceType.getInverseType();
				}
				FeatureGroupType srcFGT = ((FeatureGroup) srcContext).getAllFeatureGroupType();
				FeatureGroupType contsrcFGT = (FeatureGroupType) ((Access) source).getContainingClassifier();
				if (!srcFGT.equals(contsrcFGT) && srcFGT.getInverse() != null) {
					// feature group type has inverse and feature is defined in
					// the inverse FGT
					sourceType = sourceType.getInverseType();
				}
			}
		}

		if (destination instanceof Access) {
			destinationType = ((Access) destination).getKind();
			if (dstContext instanceof FeatureGroup) {
				if (((FeatureGroup) dstContext).isInverse()) {
					destinationType = destinationType.getInverseType();
				}
				FeatureGroupType dstFGT = ((FeatureGroup) dstContext).getAllFeatureGroupType();
				FeatureGroupType contdstFGT = (FeatureGroupType) ((Access) destination).getContainingClassifier();
				if (!dstFGT.equals(contdstFGT) && dstFGT.getInverse() != null) {
					// feature group type has inverse and feature is defined in
					// the inverse FGT
					destinationType = destinationType.getInverseType();
				}
			}
		}

		// Test for L5: connection between access features of sibling components
		if (srcContext instanceof Subcomponent && dstContext instanceof Subcomponent && source instanceof Access
				&& destination instanceof Access) {
			if (sourceType.equals(AccessType.PROVIDES) && destinationType.equals(AccessType.PROVIDES)) {
				error(connection,
						"Source and destination of access connections between sibling components cannot both be 'provides'.");
			}
			if (sourceType.equals(AccessType.REQUIRES) && destinationType.equals(AccessType.REQUIRES)) {
				error(connection,
						"Source and destination of access connections between sibling components cannot both be 'requires'.");
			}
		}
		// Test for the common case of L6 and L7: connection between an access
		// feature in the containing component and an access feature in a
		// subcomponent.
		else if (source instanceof Access && destination instanceof Access
				&& ((srcContext instanceof Subcomponent && (dstContext == null || dstContext instanceof FeatureGroup))
						|| (dstContext instanceof Subcomponent
								&& (srcContext == null || srcContext instanceof FeatureGroup)))) {
			if (!sourceType.equals(destinationType)) {
				error(connection,
						"Source and destination must both be provides or requires for a connection mapping features up or down the containment hierarchy.");
			}
		}
		// Test for L6: connection between subcomponent and access feature
		else if (source instanceof Subcomponent && destination instanceof Access
				&& (dstContext == null || dstContext instanceof FeatureGroup)) {
			if (!destinationType.equals(AccessType.PROVIDES)) {
				error('\'' + destination.getName()
						+ "' must be a provides access feature for a connection from an accessed subcomponent.",
						connection, Aadl2Package.eINSTANCE.getConnection_Destination());
			}
		}
		// Test for L6: connection between access feature and subcomponent
		else if (destination instanceof Subcomponent && source instanceof Access
				&& (srcContext == null || srcContext instanceof FeatureGroup)) {
			if (!sourceType.equals(AccessType.PROVIDES)) {
				error('\'' + source.getName()
						+ "' must be a provides access feature for a connection to a accessed subcomponent.",
						connection, Aadl2Package.eINSTANCE.getConnection_Source());
			}
		}
		// Test for L7: connection between subcomponent and access feature of
		// subcomponent
		else if (source instanceof Subcomponent && destination instanceof Access
				&& dstContext instanceof Subcomponent) {
			if (!destinationType.equals(AccessType.REQUIRES)) {
				error('\'' + destination.getName()
						+ "' must be a requires access feature for a connection from an accessed subcomponent.",
						connection, Aadl2Package.eINSTANCE.getConnection_Destination());
			}
		}
		// Test for L7: connection between access feature of subcomponent and
		// subcomponent
		else if (destination instanceof Subcomponent && source instanceof Access
				&& srcContext instanceof Subcomponent) {
			if (!sourceType.equals(AccessType.REQUIRES)) {
				error('\'' + source.getName()
						+ "' must be a requires access feature for a connection to an accessed subcomponent.",
						connection, Aadl2Package.eINSTANCE.getConnection_Source());
			}
		}
	}

	/**
	 * Checks legality rule L9 for section 9.4 (Access Connections) "For access
	 * connections the classifier of the provider access must match to the
	 * classifier of the requires access according to the
	 * Classifier_Matching_Rules property. By default the classifiers must be
	 * the same (see Section 9.1)."
	 */
	private void checkAccessConnectionClassifiers(AccessConnection connection) {
		ConnectionEnd source = connection.getAllSource();
		ConnectionEnd destination = connection.getAllDestination();
		if (source instanceof AccessConnectionEnd && destination instanceof AccessConnectionEnd) {
			Classifier sourceClassifier = null;
			Classifier destinationClassifier = null;
			// for type extension
			boolean invert = false;
			AccessType srckind = null;
			AccessType dstkind = null;
			Context srcCxt = null;
			Context dstCxt = null;
			if (source instanceof Access) {
				sourceClassifier = ((Access) source).getAllClassifier();
				srckind = ((Access) source).getKind();
				srcCxt = connection.getAllSourceContext();
			} else if (source instanceof Subcomponent) {
				sourceClassifier = ((Subcomponent) source).getAllClassifier();
				invert = true;
			} else if (source instanceof SubprogramProxy) {
				sourceClassifier = ((SubprogramProxy) source).getSubprogramClassifier();
			}
			if (destination instanceof Access) {
				dstkind = ((Access) destination).getKind();
				destinationClassifier = ((Access) destination).getAllClassifier();
				dstCxt = connection.getAllDestinationContext();
			} else if (destination instanceof Subcomponent) {
				destinationClassifier = ((Subcomponent) destination).getAllClassifier();
			} else if (destination instanceof SubprogramProxy) {
				destinationClassifier = ((SubprogramProxy) destination).getSubprogramClassifier();
			}
			// now we have the classifier

			if (sourceClassifier == null && destinationClassifier != null) {
				warning('\'' + source.getName() + "' is missing a classifier.", connection,
						Aadl2Package.eINSTANCE.getConnection_Source());
			} else if (sourceClassifier != null && destinationClassifier == null) {
				warning('\'' + destination.getName() + "' is missing a classifier.", connection,
						Aadl2Package.eINSTANCE.getConnection_Destination());
			} else if (sourceClassifier != null && destinationClassifier != null) {
				Property classifierMatchingRuleProperty = GetProperties.lookupPropertyDefinition(connection,
						ModelingProperties._NAME, ModelingProperties.CLASSIFIER_MATCHING_RULE);
				EnumerationLiteral classifierMatchingRuleValue;
				try {
					classifierMatchingRuleValue = PropertyUtils.getEnumLiteral(connection,
							classifierMatchingRuleProperty);
				} catch (PropertyNotPresentException e) {
					classifierMatchingRuleValue = null;
				}
				if (classifierMatchingRuleValue == null
						|| classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.CLASSIFIER_MATCH)
				// ||
				// classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.COMPLEMENT)
				) {
					// if (classifierMatchingRuleValue != null &&
					// classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.COMPLEMENT))
					// {
					// warning(connection, "The classifier matching rule '" +
					// ModelingProperties.COMPLEMENT + "' is not supported for
					// access connections. Using rule '" +
					// ModelingProperties.CLASSIFIER_MATCH +
					// "' instead.");
					// }
					if (!testClassifierMatchRule(connection, source, sourceClassifier, destination,
							destinationClassifier)) {
						error(connection, '\'' + source.getName() + "' and '" + destination.getName()
								+ "' have incompatible classifiers.");
					}
				} else if (classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.TYPE_EXTENSION)) {
					// first figure out which way to check for type extension
					// the shared component has to be a type extension of the
					// required access type.
					// from provides to requires between subcomponents, provides
					// sub to enclosing provides, from enclosing requires to sub
					// requires
					// either can be source or destination.
					if (AccessType.PROVIDES == srckind && dstkind == AccessType.PROVIDES
							&& dstCxt instanceof Subcomponent) {
						invert = true;
					}
					if (srckind == (AccessType.REQUIRES) && dstkind == (AccessType.REQUIRES)
							&& srcCxt instanceof Subcomponent) {
						invert = true;
					}
					if (srckind == (AccessType.REQUIRES) && dstkind == (AccessType.PROVIDES)) {
						invert = true;
					}
					if (invert) {
						if (!AadlUtil.isokClassifierSubstitutionTypeExtension(destinationClassifier,
								sourceClassifier)) {
							warning("Destination classifier " + destinationClassifier.getName() + " connected to "
									+ sourceClassifier.getName() + " does not satisfy 'Type Extension'", connection,
									Aadl2Package.eINSTANCE.getConnection_Destination());
						}
					} else {
						if (!AadlUtil.isokClassifierSubstitutionTypeExtension(sourceClassifier,
								destinationClassifier)) {
							warning("Source classifier " + sourceClassifier.getName() + " connected to "
									+ destinationClassifier.getName() + " does not satisfy 'Type Extension'",
									connection, Aadl2Package.eINSTANCE.getConnection_Source());
						}
					}
				} else if (classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.EQUIVALENCE)) {
					if (!testClassifierMatchRule(connection, source, sourceClassifier, destination,
							destinationClassifier)
							&& !classifiersFoundInSupportedClassifierEquivalenceMatchesProperty(connection,
									sourceClassifier, destinationClassifier)) {
						error(connection,
								"The types of '" + source.getName() + "' and '" + destination.getName() + "' ('"
										+ sourceClassifier.getQualifiedName() + "' and '"
										+ destinationClassifier.getQualifiedName()
										+ "') are incompatible and they are not listed as matching classifiers in the property constant '"
										+ AadlProject.SUPPORTED_CLASSIFIER_EQUIVALENCE_MATCHES + "'.");
					}
				} else if (classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.SUBSET)) {
					if (!testClassifierMatchRule(connection, source, sourceClassifier, destination,
							destinationClassifier)
							&& !classifiersFoundInSupportedClassifierSubsetMatchesProperty(connection, sourceClassifier,
									destinationClassifier)) {
						error(connection,
								"The types of '" + source.getName() + "' and '" + destination.getName() + "' ('"
										+ sourceClassifier.getQualifiedName() + "' and '"
										+ destinationClassifier.getQualifiedName()
										+ "') are incompatible and they are not listed as matching classifiers in the property constant '"
										+ AadlProject.SUPPORTED_CLASSIFIER_SUBSET_MATCHES + "'.");
					}
				} else if (classifierMatchingRuleValue.getName().equalsIgnoreCase(ModelingProperties.CONVERSION)) {
					if (!testClassifierMatchRule(connection, source, sourceClassifier, destination,
							destinationClassifier)
							&& !classifiersFoundInSupportedTypeConversionsProperty(connection, sourceClassifier,
									destinationClassifier)) {
						error(connection,
								"The types of '" + source.getName() + "' and '" + destination.getName() + "' ('"
										+ sourceClassifier.getQualifiedName() + "' and '"
										+ destinationClassifier.getQualifiedName()
										+ "') are incompatible and they are not listed as matching classifiers in the property constant '"
										+ AadlProject.SUPPORTED_TYPE_CONVERSIONS + "'.");
					}
				}
			}
		}
	}

	/**
	 * Checks that the feature of a flow is a DataAccess, FeatureGroup,
	 * Parameter, or Port. Section 10.1 Naming Rule N2.
	 */
	private void checkFlowFeatureType(FlowEnd flowEnd) {
		Context flowEndContext = flowEnd.getContext();
		Feature flowFeature = flowEnd.getFeature();
		if ((flowEndContext != null && flowEndContext.eIsProxy()) || flowFeature == null || flowFeature.eIsProxy()) {
			// Don't validate if the context or feature could not be resolved.
			return;
		}
		if (flowEndContext != null && !(flowEndContext instanceof FeatureGroup)) {
			error("Anything in " + getEClassDisplayNameWithIndefiniteArticle(flowEndContext.eClass())
					+ " is not a valid flow specification feature.", flowEnd,
					Aadl2Package.eINSTANCE.getFlowEnd_Context());
		} else if (!(flowFeature instanceof DataAccess) && !(flowFeature instanceof AbstractFeature)
				&& !(flowFeature instanceof FeatureGroup) && !(flowFeature instanceof Parameter)
				&& !(flowFeature instanceof Port)) {
			error('\'' + (flowEndContext != null ? flowEndContext.getName() + '.' : "") + flowFeature.getName()
					+ "' must be a port, parameter, data access, feature group, or abstract feature.", flowEnd,
					Aadl2Package.eINSTANCE.getFlowEnd_Feature());
		}
	}

	/**
	 * Checks the direction of features used in flow specs. Section 10.1
	 * Legality Rules L1, L2, L3, L4, L5, L6, L7, L8, L9, and L10
	 *
	 * @param flow
	 */
	private void checkFlowFeatureDirection(FlowSpecification flow) {
		FlowEnd inEnd = flow.getInEnd();
		if (inEnd != null) {
			Context inCxt = inEnd.getContext();
			Feature inFeature = inEnd.getFeature();
			if ((inCxt == null || (!inCxt.eIsProxy() && inCxt instanceof FeatureGroup)) && !Aadl2Util.isNull(inFeature)
					&& (inFeature instanceof DataAccess || inFeature instanceof AbstractFeature
							|| inFeature instanceof FeatureGroup || inFeature instanceof Parameter
							|| inFeature instanceof Port)) {
				boolean oppositeDirection = false;
				if (inCxt instanceof FeatureGroup) {
					FeatureGroup fg = (FeatureGroup) inCxt;
					if (fg.isInverse()) {
						oppositeDirection = !oppositeDirection;
					}
					FeatureGroupType fgt = fg.getAllFeatureGroupType();
					if (!Aadl2Util.isNull(fgt)) {
						if (!Aadl2Util.isNull(fgt.getInverse()) && fgt.getOwnedFeatures().isEmpty()) {
							// change direction since the FGT is an inverse and
							// does not have features, i.e., the inEnd points to
							// a
							// feature in the inverse of FGT
							oppositeDirection = !oppositeDirection;
						}
					}
				}
				checkIncomingFeatureDirection(inFeature, flow, oppositeDirection, true);
			}
		}
		FlowEnd outEnd = flow.getOutEnd();
		if (outEnd != null) {
			Context outCxt = outEnd.getContext();
			Feature outFeature = outEnd.getFeature();
			if ((outCxt == null || (!outCxt.eIsProxy() && outCxt instanceof FeatureGroup))
					&& !Aadl2Util.isNull(outFeature)
					&& (outFeature instanceof DataAccess || outFeature instanceof AbstractFeature
							|| outFeature instanceof FeatureGroup || outFeature instanceof Parameter
							|| outFeature instanceof Port)) {
				boolean oppositeDirection = false;
				if (outCxt instanceof FeatureGroup) {
					FeatureGroup fg = (FeatureGroup) outCxt;
					if (fg.isInverse()) {
						oppositeDirection = !oppositeDirection;
					}
					FeatureGroupType fgt = fg.getAllFeatureGroupType();
					if (!Aadl2Util.isNull(fgt)) {
						if (!Aadl2Util.isNull(fgt.getInverse()) && fgt.getOwnedFeatures().isEmpty()) {
							// change direction since the FGT is an inverse and
							// does not have features, i.e., the inEnd points to
							// a
							// feature in the inverse of FGT
							oppositeDirection = !oppositeDirection;
						}
					}
				}
				checkOutgoingFeatureDirection(outFeature, flow, oppositeDirection, true);
			}
		}
	}

	private boolean checkIncomingFeatureDirection(Feature inFeature, FlowSpecification flow, boolean inverseOf,
			boolean report) {
		// Test for L2
		if (inFeature instanceof Port || inFeature instanceof Parameter || inFeature instanceof AbstractFeature) {
			DirectionType fDirection = ((DirectedFeature) inFeature).getDirection();
			if (inverseOf) {
				fDirection = fDirection.getInverseDirection();
			}
			if (!fDirection.incoming()) {
				if (report) {
					error(flow.getInEnd(), '\''
							+ (flow.getInEnd().getContext() != null ? flow.getInEnd().getContext().getName() + '.' : "")
							+ inFeature.getName() + "' must be an in or in out feature.");
				}
				return false;
			} else {
				return true;
			}
		}
		// Test for L4
		else if (inFeature instanceof DataAccess) {
			Property accessRightProperty = GetProperties.lookupPropertyDefinition(flow, MemoryProperties._NAME,
					MemoryProperties.ACCESS_RIGHT);
			EnumerationLiteral accessRightValue = PropertyUtils.getEnumLiteral(inFeature, accessRightProperty);
			String accessrightname = accessRightValue.getName();
			if (inverseOf) {
				accessrightname = MemoryProperties.getInverseDirection(accessrightname);
			}
			if (!accessrightname.equalsIgnoreCase(MemoryProperties.READ_ONLY)
					&& !accessrightname.equalsIgnoreCase(MemoryProperties.READ_WRITE)) {
				if (report) {
					error(flow.getInEnd(),
							'\'' + (flow.getInEnd().getContext() != null ? flow.getInEnd().getContext().getName() + '.'
									: "") + inFeature.getName()
									+ "' must have an access right of Read_Only or Read_Write.");
				}
				return false;
			} else {
				return true;
			}
		}
		// Test for L6
		else if (inFeature instanceof FeatureGroup) {
			FeatureGroupType fgt = ((FeatureGroup) inFeature).getAllFeatureGroupType();
			boolean inInverseof = ((FeatureGroup) inFeature).isInverse();
			if (!Aadl2Util.isNull(fgt)) {
				if (!Aadl2Util.isNull(fgt.getInverse()) && fgt.getOwnedFeatures().isEmpty()) {
					inInverseof = !inInverseof;
				}
				if (fgt.getAllFeatures().isEmpty()) {
					return true;
				}
				for (Feature f : fgt.getAllFeatures()) {
					// check to see if there is at least one incoming feature in
					// the feature group
					if (checkIncomingFeatureDirection(f, flow, inInverseof ? !inverseOf : inverseOf, false)) {
						return true;
					}
				}
				if (report) {
					error(flow.getInEnd(), '\''
							+ (flow.getInEnd().getContext() != null ? flow.getInEnd().getContext().getName() + '.' : "")
							+ inFeature.getName()
							+ "' must contain at least one in or in out port or parameter, at least data access with an access right of Read_Only or Read_Write, or be empty.");
					return false;
				}
			}
			return true;
		}
		return false;

	}

	private boolean checkOutgoingFeatureDirection(Feature outFeature, FlowSpecification flow, boolean inverseOf,
			boolean report) {
		// Test for L3
		if (outFeature instanceof Port || outFeature instanceof Parameter || outFeature instanceof AbstractFeature) {
			DirectionType fDirection = ((DirectedFeature) outFeature).getDirection();
			if (inverseOf) {
				fDirection = fDirection.getInverseDirection();
			}

			if (!fDirection.outgoing()) {
				if (report) {
					error(flow.getOutEnd(),
							'\'' + (flow.getOutEnd().getContext() != null
									? flow.getOutEnd().getContext().getName() + '.' : "") + outFeature.getName()
									+ "' must be an out or in out feature.");
				}
				return false;
			} else {
				return true;
			}
		}
		// Test for L5
		else if (outFeature instanceof DataAccess) {
			Property accessRightProperty = GetProperties.lookupPropertyDefinition(flow, MemoryProperties._NAME,
					MemoryProperties.ACCESS_RIGHT);
			EnumerationLiteral accessRightValue = PropertyUtils.getEnumLiteral(outFeature, accessRightProperty);
			String accessrightname = accessRightValue.getName();

			if (!accessrightname.equalsIgnoreCase(MemoryProperties.WRITE_ONLY)
					&& !accessrightname.equalsIgnoreCase(MemoryProperties.READ_WRITE)) {
				if (report) {
					error(flow.getOutEnd(),
							'\'' + (flow.getOutEnd().getContext() != null
									? flow.getOutEnd().getContext().getName() + '.' : "") + outFeature.getName()
									+ "' must have an access right of Write_Only or Read_Write.");
				}
				return false;
			} else {
				return true;
			}
		}
		// Test for L7
		else if (outFeature instanceof FeatureGroup) {
			FeatureGroupType fgt = ((FeatureGroup) outFeature).getAllFeatureGroupType();
			boolean outInverseof = ((FeatureGroup) outFeature).isInverse();
			if (fgt != null) {
				if (!Aadl2Util.isNull(fgt.getInverse()) && fgt.getOwnedFeatures().isEmpty()) {
					// change direction only if inverse of and no features.
					// Otherwise, we check features in this fgt
					outInverseof = !outInverseof;
					// set up inverse fgt to be examined for features of the
					// correct direction
					fgt = fgt.getInverse();
				}
				if (fgt.getAllFeatures().isEmpty()) {
					return true;
				}
				for (Feature f : fgt.getAllFeatures()) {
					if (checkOutgoingFeatureDirection(f, flow, outInverseof ? !inverseOf : inverseOf, false)) {
						return true;
					}
				}
				if (report) {
					error(flow.getOutEnd(), '\''
							+ (flow.getOutEnd().getContext() != null ? flow.getOutEnd().getContext().getName() + '.'
									: "")
							+ outFeature.getName()
							+ "' must contain at least one out or in out port or parameter, at least one data access with an access right of Write_Only or Read_Write, or be empty.");
				}
				return false;
			} else {
				return true;
			}
		}
		return false;

	}

	/**
	 * @param pn
	 */
	private void checkPropertyDefinition(final Property pn) {
		// Check the type correctness of the default value, if any
		typeCheckPropertyValues(pn.getPropertyType(), pn.getDefaultValue(), pn, pn.getQualifiedName());
		checkAppliesTo(pn);
	}

	/**
	 * check that the Meta model names exist
	 *
	 * @param pd
	 */
	private void checkAppliesTo(final Property pd) {
		for (PropertyOwner appliesTo : pd.getAppliesTos()) {
			if (appliesTo instanceof MetaclassReference) {
				MetaclassReference metaRef = (MetaclassReference) appliesTo;
				if (metaRef.getAnnexName() == null && metaRef.getMetaclass() == null) {
					error(pd, metaRef.getErrorMessage());
				}
			}
		}
	}

	private void checkPropertyConstant(final PropertyConstant pc) {
		/*
		 * Check the type correctness of the values. The parser enforces some of
		 * this, but can't do it if the type is given by reference, and it
		 * cannot check that a int or real is within range.
		 */
		typeCheckPropertyValues(pc.getPropertyType(), pc.getConstantValue(), pc, pc.getQualifiedName());
	}

	//
	// /**
	// * check property associations for the element
	// * @param element Element. It may not have a Properties object.
	// */
	// private void checkPropertyAssocs(
	// final NamedElement element, final boolean isSubcomponent) {
	// final List assocs;
	// if (element instanceof Classifier) {
	// /* 15 February 2007: Not sure this what should really be done.
	// * This breaks list +=> for one thing. Taking this out for
	// * the moment; it was put in on 6 Feb 2007.
	// */
	//// assocs = ((Classifier) element).getAllPropertyAssociations();
	// assocs = element.getOwnedPropertyAssociations();
	// } else {
	// assocs = element.getOwnedPropertyAssociations();
	// }
	// if (assocs == null) return;
	//
	// // map: PropertyDeclaration -> set of mode-binding pairs
	// final Map propsToModes = new HashMap();
	// // 2 level map: PropertyDeclaration -> EList of property holders -> set
	// of mode-binding pairs
	// final Map containedPropsToModes = new HashMap();
	// for (final Iterator iter = assocs.iterator(); iter.hasNext(); ) {
	// final PropertyAssociation pa = (PropertyAssociation) iter.next();
	// // check only if property name was resolved
	// final Property pd = pa.getProperty();
	// if (pd != null) {
	// /* This is where we should check constant property
	// * associations, but it's too much work to do that.
	// */
	// if (pa.isConstant()) {
	// warning(pa,
	// "Constant property associations are not checked");
	// }
	//
	// /* Check that the association follows the prop's "applies to".
	// */
	// checkAssociationAppliesTo(element, pa);
	//
	// /* Check that this PA hasn't already associated a value with
	// * the property (modulo modes).
	// */
	// checkUniqueAssociation(element, propsToModes, pa);
	// checkUniqueContainedAssociation(element, containedPropsToModes, pa);
	//
	// // Check that the association has good "in modes"
	// checkInModes(element, pa);
	//
	// // Check that the association is type correct
	// typeCheckPropertyValues(pd.getPropertyType(), pd.isList(),
	// pa.getOwnedValues());
	//
	// // Check "list of" issues
	// checkListOf(pa);
	//
	// // Check that Overflow_handling_protocol and Queue_size only
	// // appear on in event ports and in event data ports
	// checkPortProperties(element, pa);
	// }
	// }
	// }
	//
	// private static class ModeBindingPair {
	// private final Mode mode;
	// private final ComponentClassifier binding;
	//
	// public ModeBindingPair(final Mode m, final ComponentClassifier cc) {
	// mode = m;
	// binding = cc;
	// }
	//
	// public boolean equals(final Object o) {
	// if (o instanceof ModeBindingPair) {
	// final ModeBindingPair mbp = (ModeBindingPair) o;
	// return ((mode == null && mbp.mode == null) || mode.equals(mbp.mode))
	// && ((binding == null && mbp.binding == null) ||
	// binding.equals(mbp.binding));
	// } else {
	// return false;
	// }
	// }
	//
	// public int hashCode() {
	// final int hc1 = (mode == null) ? 0 : mode.hashCode();
	// final int hc2 = (binding == null) ? 0 : binding.hashCode();
	// return hc1 * 13 + hc2;
	// }
	//
	// public String toString() {
	// final String s1 = (mode == null) ? "none" : mode.getName();
	// final String s2 = (binding == null) ? "none" :
	// binding.getQualifiedName();
	// return "(" + s1 + ", " + s2 + ")";
	// }
	// }
	//
	// private static final List NULL_LIST = Collections.singletonList(null);
	//
	// private static Set createPairs(final List modes, final List bindings) {
	// final Set pairs = new HashSet();
	//
	// final List modesList = (modes == null || modes.isEmpty()) ? NULL_LIST :
	// modes;
	// final List bindingsList = (bindings == null || bindings.isEmpty()) ?
	// NULL_LIST : bindings;
	// for (final Iterator i = modesList.iterator(); i.hasNext();) {
	// final Mode mode = (Mode) i.next();
	// for (final Iterator j = bindingsList.iterator(); j.hasNext();) {
	// final ComponentClassifier binding = (ComponentClassifier) j.next();
	// pairs.add(new ModeBindingPair(mode, binding));
	// }
	// }
	// return pairs;
	// }
	//
	// private void checkUniqueAssociation(
	// final NamedElement ph, final Map propsToModes, final PropertyAssociation
	// pa) {
	// if (pa.getAppliesTos() == null || pa.getAppliesTos().size() == 0) {
	// final Property pd = pa.getProperty();
	// Set definedInModes = (Set) propsToModes.get(pd);
	// if (definedInModes == null) {
	// definedInModes = new HashSet();
	// propsToModes.put(pd, definedInModes);
	// }
	// checkForDuplicateAssociation(ph, pa, definedInModes);
	// }
	// }
	//
	// private void checkUniqueContainedAssociation(
	// final NamedElement ph,
	// final Map containedPropsToModes, final PropertyAssociation pa) {
	// final String appliesTo = unparseContainedAppliesToPath(pa);
	// if (appliesTo.length() > 0) {
	// final Property pd = pa.getProperty();
	// Map subMap = (Map) containedPropsToModes.get(pd);
	// if (subMap == null) {
	// subMap = new HashMap();
	// containedPropsToModes.put(pd, subMap);
	// }
	// Set definedInModes = (Set) subMap.get(appliesTo);
	// if (definedInModes == null) {
	// definedInModes = new HashSet();
	// subMap.put(appliesTo, definedInModes);
	// }
	// checkForDuplicateAssociation(ph, pa, definedInModes);
	// }
	// }
	//
	// /**
	// * @param pa
	// * @param definedInModes
	// */
	// private void checkForDuplicateAssociation(
	// final NamedElement ph,
	// final PropertyAssociation pa, Set definedInModes) {
	// final EList inBinding = pa.getInBindings();
	// final Set pairs = createPairs(inModes, inBinding);
	// final Set alreadyDefined = new HashSet();
	// for (final Iterator i = pairs.iterator(); i.hasNext(); ) {
	// final ModeBindingPair mbp = (ModeBindingPair) i.next();
	// if (definedInModes.contains(mbp)) {
	// alreadyDefined.add(mbp);
	// }
	// }
	// definedInModes.addAll(pairs);
	//
	// if (!alreadyDefined.isEmpty()) {
	// final String appliesTo = unparseContainedAppliesToPath(pa);
	// for (final Iterator i = alreadyDefined.iterator(); i.hasNext();) {
	// final ModeBindingPair mbp = (ModeBindingPair) i.next();
	// error(ph,
	// "\"" + ph.getName() + "\" has multiple property associations for \"" +
	// pa.getProperty().getQualifiedName() + "\"" +
	// ((appliesTo.length() == 0) ? "" : (" applying to " + appliesTo)) +
	// ((mbp.mode == null) ? "" : (" in mode " + mbp.mode.getName())) +
	// ((mbp.binding == null) ? "" : (" in binding " +
	// mbp.binding.getQualifiedName())));
	// }
	// }
	// }
	//
	// private String unparseContainedAppliesToPath(final PropertyAssociation
	// pa) {
	// final List appliesTo = pa.getAppliesTos();
	// final StringBuffer sb = new StringBuffer();
	// for (final Iterator i = appliesTo.iterator(); i.hasNext();) {
	// final NamedElement ne = (NamedElement) i.next();
	// sb.append(ne.getName());
	// if (i.hasNext()) sb.append('.');
	// }
	// return sb.toString();
	// }
	//
	// /**
	// * Checks legality rule from Section 4.5 Subcomponents:
	// *
	// * <blockquote>If the subcomponent declaration contains an in_modes
	// * statement and any of its property associations also contains an
	// in_modes
	// * statement, then the modes named in the property association must be a
	// * subset of those named in the subcomponent declaration. </blockquote>
	// *
	// * @param element
	// * The property holder whose in_modes should be checked. This
	// * method is only interested in SubprogramSubcomponent,
	// * Subcomponent, Connection, and FlowSequence elements.
	// *
	// * @param pa
	// * The particular property association whose in_modes must be a
	// * subset of the modes in which <code>element</code> exists.
	// */
	// private void checkInModes(final NamedElement element, final
	// PropertyAssociation pa) {
	// final EList innerModes = pa.getInModes();
	// if (innerModes != null) {
	// EList outerModes = null;
	// if (element instanceof SubprogramSubcomponent) {
	// /* We need to treat SubprogramSubcomponents specially because
	// * the modes they exist in are controlled by the CallSequence.
	// */
	// final SubprogramCallSequence cs = (SubprogramCallSequence)
	// element.eContainer();
	// outerModes = cs.getInModes();
	// } else if (element instanceof Subcomponent
	// || element instanceof Connection
	// || element instanceof FlowElement) {
	// outerModes = ((ModalElement) element).getInModes();
	// }
	//
	// if (outerModes != null) {
	// // Empty set means that no modes were declared, i.e., all modes
	// if (!outerModes.isEmpty()
	// && !outerModes.containsAll(innerModes)) {
	// error(pa,
	// "Property association has more modes than its container");
	// }
	// }
	// }
	// }
	//
	// /**
	// * Check that non-list properties do not get associated with a list of
	// * values:
	// *
	// * <blockquote>
	// * If the property declaration for the associated property name
	// * does not contain the reserved words list of, the property_value must be
	// a
	// * single_property_value. If the property declaration for the associated
	// * property name contains the reserved words list of, the property_value
	// can
	// * be a single_property_value, which is interpreted to be a list of one
	// * value.
	// *
	// * The property association operator +=> must only be used if the property
	// * declaration for the associated property name contains the reserved
	// words
	// * list of.
	// * </blockquote>
	// *
	// * @param pa
	// */
	// private void checkListOf(final PropertyAssociation pa) {
	// final Property pn = pa.getProperty();
	// if (pn == null)
	// return;
	// final EList value = pa.getOwnedValues();
	// if (!pn.isList()) {
	// // Must only have one value associated with the property
	// if (value == null || value.size() == 0) {
	// error(pa,
	// "Scalar properties must have a value");
	// } else if (value.size() > 1) {
	// error(pa,
	// "Scalar properties cannot be associated with a list");
	// }
	// if (pa.isAppend()) {
	// error(pa,
	// "Cannot append to a scalar property");
	// }
	// }
	// }
	//
	// /**
	// * Checks contraints on the <code>Overflow_Handling_Protocol</code>,
	// * <code>Queue_Processing_Protocol</code>, <code>Dequeue_Protocol</code>,
	// * <code>Queue_Size</code> properties as specificed in Section 8.1 Ports:
	// *
	// * <blockquote>The property names Overflow_Handling_Protocol,
	// * Queue_Processing_Protocol, Dequeue_Protocol, and Queue_Size
	// * may only appear in property associations for in event ports and in
	// event
	// * data ports. </blockquote>
	// *
	// * <p>The <code>applies to</code> clause in the property definition
	// * already makes sure they only appear on <code>event port</code>
	// * and <code>event data port</code> (and <code>subprogram</code> for all
	// * but <code>Dequeue_Protocol</code>). So here we check that the port
	// * is an <code>in port</code>.
	// *
	// * @param ph
	// * The property holder
	// * @param pa
	// * The property association to check
	// */
	// private void checkPortProperties(final NamedElement ph, final
	// PropertyAssociation pa) {
	// if (ph instanceof EventPort || ph instanceof EventDataPort) {
	// final Property pd = pa.getProperty();
	// if (pd ==
	// PropertiesLinkingService.getPropertiesLinkingService(ph).findPropertyDefinition(ph,CommunicationProperties.OVERFLOW_HANDLING_PROTOCOL)
	// ||
	// pd.getName().equalsIgnoreCase(CommunicationProperties.QUEUE_SIZE) ||
	// pdgetName().equalsIgnoreCase(CommunicationProperties.UE_PROCESSING_PROTOTOCOL)
	// ||
	// pd == DEQUEUE_PROTOCOL_PD) {
	// final DirectionType dir = ((Port) ph).getDirection();
	// if (dir != DirectionType.IN) {
	// error(pa,
	// "Property \"" + pd.getName() +
	// "\" is only allowed on in event ports and in event data ports");
	// }
	// }
	// }
	// }
	//
	//

	private static FeatureType getFeatureType(Feature feature) {
		if (feature instanceof DataPort) {
			switch (((DataPort) feature).getDirection()) {
			case IN:
				return FeatureType.IN_DATA_PORT;
			case OUT:
				return FeatureType.OUT_DATA_PORT;
			case IN_OUT:
				return FeatureType.IN_OUT_DATA_PORT;
			}
		} else if (feature instanceof EventPort) {
			switch (((EventPort) feature).getDirection()) {
			case IN:
				return FeatureType.IN_EVENT_PORT;
			case OUT:
				return FeatureType.OUT_EVENT_PORT;
			case IN_OUT:
				return FeatureType.IN_OUT_EVENT_PORT;
			}
		} else if (feature instanceof EventDataPort) {
			switch (((EventDataPort) feature).getDirection()) {
			case IN:
				return FeatureType.IN_EVENT_DATA_PORT;
			case OUT:
				return FeatureType.OUT_EVENT_DATA_PORT;
			case IN_OUT:
				return FeatureType.IN_OUT_EVENT_DATA_PORT;
			}
		} else if (feature instanceof FeatureGroup) {
			return FeatureType.FEATURE_GROUP;
		} else if (feature instanceof DataAccess) {
			switch (((DataAccess) feature).getKind()) {
			case PROVIDES:
				return FeatureType.PROVIDES_DATA_ACCESS;
			case REQUIRES:
				return FeatureType.REQUIRES_DATA_ACCESS;
			}
		} else if (feature instanceof SubprogramAccess) {
			switch (((SubprogramAccess) feature).getKind()) {
			case PROVIDES:
				return FeatureType.PROVIDES_SUBPROGRAM_ACCESS;
			case REQUIRES:
				return FeatureType.REQUIRES_SUBPROGRAM_ACCESS;
			}
		} else if (feature instanceof SubprogramGroupAccess) {
			switch (((SubprogramGroupAccess) feature).getKind()) {
			case PROVIDES:
				return FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS;
			case REQUIRES:
				return FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS;
			}
		} else if (feature instanceof BusAccess) {
			switch (((BusAccess) feature).getKind()) {
			case PROVIDES:
				return FeatureType.PROVIDES_BUS_ACCESS;
			case REQUIRES:
				return FeatureType.REQUIRES_BUS_ACCESS;
			}
		} else if (feature instanceof AbstractFeature) {
			return FeatureType.ABSTRACT_FEATURE;
		} else if (feature instanceof Parameter) {
			return FeatureType.PARAMETER;
		}
		return null;
	}

	static {
		HashMap<ComponentCategory, Set<FeatureType>> featuresForTypes = new HashMap<ComponentCategory, Set<FeatureType>>();

		// Abstract Types
		FeatureType[] featureTypesArray = new FeatureType[] { FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT,
				FeatureType.IN_OUT_DATA_PORT, FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT,
				FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT, FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP, FeatureType.PROVIDES_DATA_ACCESS,
				FeatureType.PROVIDES_SUBPROGRAM_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.PROVIDES_BUS_ACCESS, FeatureType.REQUIRES_DATA_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS, FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.REQUIRES_BUS_ACCESS, FeatureType.ABSTRACT_FEATURE };
		Set<FeatureType> featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray) {
			featureTypesSet.add(featureType);
		}
		featuresForTypes.put(ComponentCategory.ABSTRACT, Collections.unmodifiableSet(featureTypesSet));

		// Data Types
		featureTypesArray = new FeatureType[] { FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS, FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.FEATURE_GROUP, FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray) {
			featureTypesSet.add(featureType);
		}
		featuresForTypes.put(ComponentCategory.DATA, Collections.unmodifiableSet(featureTypesSet));

		// Subprogram Types
		featureTypesArray = new FeatureType[] { FeatureType.OUT_EVENT_PORT, FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.FEATURE_GROUP, FeatureType.REQUIRES_DATA_ACCESS, FeatureType.REQUIRES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS, FeatureType.PARAMETER, FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray) {
			featureTypesSet.add(featureType);
		}
		featuresForTypes.put(ComponentCategory.SUBPROGRAM, Collections.unmodifiableSet(featureTypesSet));

		// Subprogram Group Types
		featureTypesArray = new FeatureType[] { FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS, FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.FEATURE_GROUP, FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray) {
			featureTypesSet.add(featureType);
		}
		featuresForTypes.put(ComponentCategory.SUBPROGRAM_GROUP, Collections.unmodifiableSet(featureTypesSet));

		// Thread Types
		featureTypesArray = new FeatureType[] { FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT,
				FeatureType.IN_OUT_DATA_PORT, FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT,
				FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT, FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP, FeatureType.PROVIDES_DATA_ACCESS,
				FeatureType.REQUIRES_DATA_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS, FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray) {
			featureTypesSet.add(featureType);
		}
		featuresForTypes.put(ComponentCategory.THREAD, Collections.unmodifiableSet(featureTypesSet));

		// Thread Group Types
		featureTypesArray = new FeatureType[] { FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT,
				FeatureType.IN_OUT_DATA_PORT, FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT,
				FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT, FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP, FeatureType.PROVIDES_DATA_ACCESS,
				FeatureType.REQUIRES_DATA_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS, FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray) {
			featureTypesSet.add(featureType);
		}
		featuresForTypes.put(ComponentCategory.THREAD_GROUP, Collections.unmodifiableSet(featureTypesSet));

		// Process Types
		featureTypesArray = new FeatureType[] { FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT,
				FeatureType.IN_OUT_DATA_PORT, FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT,
				FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT, FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP, FeatureType.PROVIDES_DATA_ACCESS,
				FeatureType.REQUIRES_DATA_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS, FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray) {
			featureTypesSet.add(featureType);
		}
		featuresForTypes.put(ComponentCategory.PROCESS, Collections.unmodifiableSet(featureTypesSet));

		// Processor Types
		featureTypesArray = new FeatureType[] { FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS, FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT,
				FeatureType.IN_OUT_DATA_PORT, FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT,
				FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT, FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP, FeatureType.REQUIRES_BUS_ACCESS,
				FeatureType.PROVIDES_BUS_ACCESS, FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray) {
			featureTypesSet.add(featureType);
		}
		featuresForTypes.put(ComponentCategory.PROCESSOR, Collections.unmodifiableSet(featureTypesSet));

		// Virtual Processor Types
		featureTypesArray = new FeatureType[] { FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS, FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT,
				FeatureType.IN_OUT_DATA_PORT, FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT,
				FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT, FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP, FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray) {
			featureTypesSet.add(featureType);
		}
		featuresForTypes.put(ComponentCategory.VIRTUAL_PROCESSOR, Collections.unmodifiableSet(featureTypesSet));

		// Memory Types
		featureTypesArray = new FeatureType[] { FeatureType.REQUIRES_BUS_ACCESS, FeatureType.PROVIDES_BUS_ACCESS,
				FeatureType.FEATURE_GROUP, FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray) {
			featureTypesSet.add(featureType);
		}
		featuresForTypes.put(ComponentCategory.MEMORY, Collections.unmodifiableSet(featureTypesSet));

		// Bus Types
		featureTypesArray = new FeatureType[] { FeatureType.REQUIRES_BUS_ACCESS, FeatureType.FEATURE_GROUP,
				FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray) {
			featureTypesSet.add(featureType);
		}
		featuresForTypes.put(ComponentCategory.BUS, Collections.unmodifiableSet(featureTypesSet));

		// Virtual Bus Types
		featureTypesSet = Collections.emptySet();
		featuresForTypes.put(ComponentCategory.VIRTUAL_BUS, featureTypesSet);

		// Device Types
		featureTypesArray = new FeatureType[] { FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT,
				FeatureType.IN_OUT_DATA_PORT, FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT,
				FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT, FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP, FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS, FeatureType.REQUIRES_BUS_ACCESS,
				FeatureType.PROVIDES_BUS_ACCESS, FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray) {
			featureTypesSet.add(featureType);
		}
		featuresForTypes.put(ComponentCategory.DEVICE, Collections.unmodifiableSet(featureTypesSet));

		// System Types
		featureTypesArray = new FeatureType[] { FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT,
				FeatureType.IN_OUT_DATA_PORT, FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT,
				FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT, FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP, FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS, FeatureType.PROVIDES_BUS_ACCESS,
				FeatureType.REQUIRES_BUS_ACCESS, FeatureType.PROVIDES_DATA_ACCESS, FeatureType.REQUIRES_DATA_ACCESS,
				FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray) {
			featureTypesSet.add(featureType);
		}
		featuresForTypes.put(ComponentCategory.SYSTEM, Collections.unmodifiableSet(featureTypesSet));

		acceptableFeaturesForTypes = Collections.unmodifiableMap(featuresForTypes);

		HashMap<ComponentCategory, Set<ComponentCategory>> categoriesForImplementations = new HashMap<ComponentCategory, Set<ComponentCategory>>();

		// Abstract Implementations
		HashSet<ComponentCategory> categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory currentCategory : ComponentCategory.values()) {
			categoriesSet.add(currentCategory);
		}
		categoriesForImplementations.put(ComponentCategory.ABSTRACT, Collections.unmodifiableSet(categoriesSet));

		// Data Implementations
		ComponentCategory[] categoriesArray = new ComponentCategory[] { ComponentCategory.DATA,
				ComponentCategory.SUBPROGRAM, ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray) {
			categoriesSet.add(category);
		}
		categoriesForImplementations.put(ComponentCategory.DATA, Collections.unmodifiableSet(categoriesSet));

		// Subprogram Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.DATA, ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray) {
			categoriesSet.add(category);
		}
		categoriesForImplementations.put(ComponentCategory.SUBPROGRAM, Collections.unmodifiableSet(categoriesSet));

		// Subprogram Group Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.SUBPROGRAM, ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray) {
			categoriesSet.add(category);
		}
		categoriesForImplementations.put(ComponentCategory.SUBPROGRAM_GROUP,
				Collections.unmodifiableSet(categoriesSet));

		// Thread Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.DATA, ComponentCategory.SUBPROGRAM,
				ComponentCategory.SUBPROGRAM_GROUP, ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray) {
			categoriesSet.add(category);
		}
		categoriesForImplementations.put(ComponentCategory.THREAD, Collections.unmodifiableSet(categoriesSet));

		// Thread Group Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.DATA, ComponentCategory.SUBPROGRAM,
				ComponentCategory.SUBPROGRAM_GROUP, ComponentCategory.THREAD, ComponentCategory.THREAD_GROUP,
				ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray) {
			categoriesSet.add(category);
		}
		categoriesForImplementations.put(ComponentCategory.THREAD_GROUP, Collections.unmodifiableSet(categoriesSet));

		// Process Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.DATA, ComponentCategory.SUBPROGRAM,
				ComponentCategory.SUBPROGRAM_GROUP, ComponentCategory.THREAD, ComponentCategory.THREAD_GROUP,
				ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray) {
			categoriesSet.add(category);
		}
		categoriesForImplementations.put(ComponentCategory.PROCESS, Collections.unmodifiableSet(categoriesSet));

		// Processor Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.VIRTUAL_PROCESSOR, ComponentCategory.MEMORY,
				ComponentCategory.BUS, ComponentCategory.VIRTUAL_BUS, ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray) {
			categoriesSet.add(category);
		}
		categoriesForImplementations.put(ComponentCategory.PROCESSOR, Collections.unmodifiableSet(categoriesSet));

		// Virtual Processor Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.VIRTUAL_PROCESSOR, ComponentCategory.VIRTUAL_BUS,
				ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray) {
			categoriesSet.add(category);
		}
		categoriesForImplementations.put(ComponentCategory.VIRTUAL_PROCESSOR,
				Collections.unmodifiableSet(categoriesSet));

		// Memory Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.MEMORY, ComponentCategory.BUS,
				ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray) {
			categoriesSet.add(category);
		}
		categoriesForImplementations.put(ComponentCategory.MEMORY, Collections.unmodifiableSet(categoriesSet));

		// Bus Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.VIRTUAL_BUS, ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray) {
			categoriesSet.add(category);
		}
		categoriesForImplementations.put(ComponentCategory.BUS, Collections.unmodifiableSet(categoriesSet));

		// Virtual Bus Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.VIRTUAL_BUS, ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray) {
			categoriesSet.add(category);
		}
		categoriesForImplementations.put(ComponentCategory.VIRTUAL_BUS, Collections.unmodifiableSet(categoriesSet));

		// Device Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.BUS, ComponentCategory.VIRTUAL_BUS,
				ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray) {
			categoriesSet.add(category);
		}
		categoriesForImplementations.put(ComponentCategory.DEVICE, Collections.unmodifiableSet(categoriesSet));

		// System Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.DATA, ComponentCategory.SUBPROGRAM,
				ComponentCategory.SUBPROGRAM_GROUP, ComponentCategory.PROCESS, ComponentCategory.PROCESSOR,
				ComponentCategory.VIRTUAL_PROCESSOR, ComponentCategory.MEMORY, ComponentCategory.BUS,
				ComponentCategory.VIRTUAL_BUS, ComponentCategory.DEVICE, ComponentCategory.SYSTEM,
				ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray) {
			categoriesSet.add(category);
		}
		categoriesForImplementations.put(ComponentCategory.SYSTEM, Collections.unmodifiableSet(categoriesSet));

		acceptableSubcomponentCategoriesForImplementations = Collections.unmodifiableMap(categoriesForImplementations);

		Map<EClass, String> featureClassNamesWithArticle = new HashMap<EClass, String>();
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getAbstractFeature(), "an abstract feature");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getBusAccess(), "a bus access");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getDataAccess(), "a data access");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getSubprogramAccess(), "a subprogram access");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getSubprogramGroupAccess(),
				"a subprogram group access");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getFeatureGroup(), "a feature group");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getParameter(), "a parameter");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getDataPort(), "a data port");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getEventDataPort(), "an event data port");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getEventPort(), "an event port");
		FEATURE_CLASS_NAMES_WITH_ARTICLE = Collections.unmodifiableMap(featureClassNamesWithArticle);
	}

	private static enum FeatureType {
		IN_DATA_PORT("an in data port"), OUT_DATA_PORT("an out data port"), IN_OUT_DATA_PORT(
				"an in out data port"), IN_EVENT_PORT("an in event port"), OUT_EVENT_PORT(
						"an out event port"), IN_OUT_EVENT_PORT("an in out event port"), IN_EVENT_DATA_PORT(
								"an in event data port"), OUT_EVENT_DATA_PORT(
										"an out event data port"), IN_OUT_EVENT_DATA_PORT(
												"an in out event data port"), FEATURE_GROUP(
														"a feature group"), PROVIDES_DATA_ACCESS(
																"a provides data access"), REQUIRES_DATA_ACCESS(
																		"a requires data access"), PROVIDES_SUBPROGRAM_ACCESS(
																				"a provides subprogram access"), REQUIRES_SUBPROGRAM_ACCESS(
																						"a requires subprogram access"), PROVIDES_SUBPROGRAM_GROUP_ACCESS(
																								"a provides subprogram group access"), REQUIRES_SUBPROGRAM_GROUP_ACCESS(
																										"a requires subprogram group access"), PROVIDES_BUS_ACCESS(
																												"a provides bus access"), REQUIRES_BUS_ACCESS(
																														"a requires bus access"), ABSTRACT_FEATURE(
																																"an abstract feature"), PARAMETER(
																																		"a parameter");

		private final String nameWithIndefiniteArticle;

		private FeatureType(String nameWithIndefiniteArticle) {
			this.nameWithIndefiniteArticle = nameWithIndefiniteArticle;
		}

		public String getNameWithIndefiniteArticle() {
			return nameWithIndefiniteArticle;
		}
	}

	private static final Map<ComponentCategory, Set<FeatureType>> acceptableFeaturesForTypes;
	private static final Map<ComponentCategory, Set<ComponentCategory>> acceptableSubcomponentCategoriesForImplementations;
	private static final Map<EClass, String> FEATURE_CLASS_NAMES_WITH_ARTICLE;

	/**
	 * Checks if {@code child} can extend {@code parent}.
	 */
	public static boolean canExtend(ComponentType parent, ComponentType child) {
		// null test to handle unresolved parent reference
		return (!Aadl2Util.isNull(parent)) && (parent.eClass() == child.eClass() || parent instanceof AbstractType);
	}

	/**
	 * Checks if {@code child} can extend {@code parent}.
	 */
	public static boolean canExtend(ComponentImplementation parent, ComponentImplementation child) {
		// null test to handle unresolved parent reference
		return (!Aadl2Util.isNull(parent))
				&& (parent.eClass() == child.eClass() || parent instanceof AbstractImplementation);
	}

	public static ComponentCategory getComponentPrototypeCategory(ComponentPrototype prototype) {
		String eClassname = prototype.eClass().getName();
		String s = eClassname.substring(0, eClassname.length() - 9);
		int secondCapitalLetterIndex = -1;
		for (int i = 1; secondCapitalLetterIndex == -1 && i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				secondCapitalLetterIndex = i;
			}
		}
		if (secondCapitalLetterIndex != -1) {
			s = s.substring(0, secondCapitalLetterIndex) + " " + s.substring(secondCapitalLetterIndex);
		}
		ComponentCategory prototypeCategory = ComponentCategory.get(s.toLowerCase());
		return prototypeCategory;
	}

	/**
	 * Check that a number type is well formed. The range values (if any) should
	 * be such that the lower bound is not greater than the upper bound.
	 * Satisfies legality rule from Section 10.1.1:
	 *
	 * <blockquote> The value of the first numeric literal that appears in a
	 * range of a number_type must not be greater than the value of the second
	 * numeric literal. </blockquote>
	 */
	protected void checkNumberType(final NumberType nt) {
		/*
		 * NOTE: NumericResolver + Parser already make sure the bounds are both
		 * reals or both integers, as appropriate.
		 */
		final NumericRange range = nt.getRange();
		if (range == null) {
			return;
		}
		PropertyExpression lowerPE = range.getLowerBound();
		PropertyExpression upperPE = range.getUpperBound();
		// TODO : handle NamedValue
		if (lowerPE instanceof NamedValue) {
			if (((NamedValue) lowerPE).getNamedValue() instanceof PropertyConstant) {
				lowerPE = ((PropertyConstant) ((NamedValue) lowerPE).getNamedValue()).getConstantValue();
			}
		}
		if (upperPE instanceof NamedValue) {
			if (((NamedValue) upperPE).getNamedValue() instanceof PropertyConstant) {
				upperPE = ((PropertyConstant) ((NamedValue) upperPE).getNamedValue()).getConstantValue();
			}
		}
		NumberValue lowerNV = lowerPE instanceof NumberValue ? (NumberValue) lowerPE : null;
		NumberValue upperNV = upperPE instanceof NumberValue ? (NumberValue) upperPE : null;
		boolean doLowerIsGreaterThanUpperCheck = true;
		if (lowerNV != null && upperNV != null) {
			/*
			 * Check: (1) the bounds have units if the type has units; (2) the
			 * lower bounds is <= the upper bound.
			 */
			if (nt.getUnitsType() != null) {
				EList<EnumerationLiteral> allUTElements = nt.getUnitsType().getOwnedLiterals();
				String[] unitNamesAndURIs = new String[allUTElements.size() * 2];
				int i = 0;
				for (EnumerationLiteral elem : allUTElements) {
					unitNamesAndURIs[i] = elem.getName();
					i++;
					unitNamesAndURIs[i] = EcoreUtil.getURI(elem).toString();
					i++;
				}
				if (lowerNV.getUnit() == null) {
					doLowerIsGreaterThanUpperCheck = false;
					error("lower bound is missing a unit", lowerNV, null, MISSING_NUMBERVALUE_UNITS, unitNamesAndURIs);
				}
				if (upperNV.getUnit() == null) {
					doLowerIsGreaterThanUpperCheck = false;
					error("upper bound is missing a unit", upperNV, null, MISSING_NUMBERVALUE_UNITS, unitNamesAndURIs);
				}
			}
			if (doLowerIsGreaterThanUpperCheck) {
				final double lower = lowerNV.getScaledValue();
				final double upper = upperNV.getScaledValue();
				if (lower > upper) {
					String lowerURI = EcoreUtil.getURI(range.getLowerBound()).toString();
					String upperURI = EcoreUtil.getURI(range.getUpperBound()).toString();
					String changeFrom = "";
					if (nt instanceof AadlInteger) {
						changeFrom = "aadlinteger";
					} else {
						changeFrom = "aadlreal";
					}
					String offSet = "" + findKeywordOffset(nt, changeFrom);

					error("Range lower bound is greater than range upper bound", range, null,
							NUMERIC_RANGE_UPPER_LESS_THAN_LOWER, lowerURI, upperURI, changeFrom, offSet);
				}
			}
		}
	}

	/**
	 * Check that if an aadlinteger type has units that the units have only
	 * integer multipliers.
	 */
	protected void checkAadlinteger(final AadlInteger ai) {
		final UnitsType units = ai.getUnitsType();
		if (units != null) {
			for (Iterator<EnumerationLiteral> i = units.getOwnedLiterals().iterator(); i.hasNext();) {
				final UnitLiteral ul = (UnitLiteral) i.next();
				final NumberValue factor = ul.getFactor();
				if (factor != null && !(factor instanceof IntegerLiteral)) {
					error(ai, "Integer type has unit (" + ul.getName() + ") with non-integer factor ("
							+ ul.getFactor().toString() + ")");
				}
			}
		}
	}

	/**
	 * Check that an ArraySizeProperty is aadlinteger type has no unit
	 */
	protected void checkArraySizeIsAadlintegerNoUnits(final ArraySize arraySize) {

		boolean foundError = false;
		PropertyType propertyType = null;

		ArraySizeProperty asp = arraySize.getSizeProperty();
		if (null == asp) {
			return;
		}
		if (asp instanceof Property) {
			error(arraySize, "Array size should only be integer or property constant value, not a property value");
			return;
			// propertyType = ((Property) asp).getPropertyType();
		} else if (asp instanceof PropertyConstant) {
			propertyType = ((PropertyConstant) asp).getPropertyType();
		}

		if (null != propertyType && !propertyType.eIsProxy()) {
			if (!(propertyType instanceof AadlInteger)) {
				foundError = true;
			} else {
				if (((AadlInteger) propertyType).getUnitsType() != null) {
					foundError = true;
				}
			}
		}

		if (foundError) {
			error(arraySize, "Array size should only be an Integer type with no units");
		}
	}

	@Inject
	private IGlobalScopeProvider scopeProvider;

	/**
	 * check whether there are duplicate names
	 */
	public String hasDuplicatesAadlPackage(AadlPackage context) {
		// project dependency based global scope
		List<IEObjectDescription> findings = ((Aadl2GlobalScopeProvider) scopeProvider).getDuplicates(context);
		if (!findings.isEmpty()) {
			return getNames(findings);
		}
		return null;
		// // workspace is global namespace
		// String crossRefString = ((NamedElement) context).getName();
		// List <IEObjectDescription> ielist = new Stack<IEObjectDescription>();
		// EList<IEObjectDescription> plist =
		// EMFIndexRetrieval.getAllPackagesInWorkspace(context);
		// for (IEObjectDescription ieObjectDescription : plist) {
		// String s = ieObjectDescription.getQualifiedName().toString();
		// if (crossRefString.equalsIgnoreCase(s)) {
		// if (ieObjectDescription.getEObjectOrProxy() != context){
		// ielist.add(ieObjectDescription);
		// }
		// }
		// }
		// if( !ielist.isEmpty()) {
		// return getNames(ielist);
		// }
		// return null;
	}

	/**
	 * check whether there are duplicate names
	 */
	public void checkForDuplicatesPropertySet(PropertySet propSet) {
		// project dependency based global scope
		if (!propSet.getName().equals("AADL_Project")) {
			List<IEObjectDescription> findings = ((Aadl2GlobalScopeProvider) scopeProvider).getDuplicates(propSet);
			if (!findings.isEmpty()) {
				error(propSet, "Property set " + propSet.getName() + " has duplicates " + findings);
			}
		}
	}

	protected String getNames(List<IEObjectDescription> findings) {
		String res = "";
		boolean doComma = false;
		for (IEObjectDescription ieObjectDescription : findings) {
			URI uri = ieObjectDescription.getEObjectURI().trimFragment();
			String pack = uri.path().replaceFirst("/resource/", "");
			res = res + (doComma ? ", " : "") + pack;
			doComma = true;
		}
		return res;
	}

	public EList<Classifier> getSelfPlusAncestors(Classifier cl) {
		EList<Classifier> cls = new BasicInternalEList<Classifier>(Classifier.class);
		cls.add(cl);
		while (cl.getExtended() != null) {
			if (cls.contains(cl.getExtended())) {
				return cls;
			}
			cl = cl.getExtended();
			cls.add(cl);
		}
		return cls;
	}

	public boolean hasExtendCycles(Classifier cl) {
		EList<Classifier> cls = new BasicInternalEList<Classifier>(Classifier.class);
		cls.add(cl);
		while (cl.getExtended() != null) {
			if (cls.contains(cl.getExtended())) {
				return true;
			}
			cl = cl.getExtended();
			cls.add(cl);
		}
		return false;
	}

	public boolean sameDirection(DirectionType srcDirection, DirectionType destDirection) {
		return (srcDirection.incoming() && destDirection.incoming())
				|| (srcDirection.outgoing() && destDirection.outgoing());
	}

	/**
	 * Check category of source and destination Section 9.5 Legality rules L5-8
	 */
	private void checkFeatureGroupConnectionDirection(Connection connection) {
		if (connection.isAllBidirectional()) {
			return;
		}
		ConnectionEnd source = connection.getAllSource();
		ConnectionEnd destination = connection.getAllDestination();
		if (source instanceof FeatureGroupConnectionEnd && destination instanceof FeatureGroupConnectionEnd) {
			Context srccxt = connection.getAllSourceContext();
			Context dstcxt = connection.getAllDestinationContext();
			boolean inverseContext = false;
			if (srccxt instanceof Subcomponent && dstcxt instanceof Subcomponent) {
				// sibling to sibling
				if (((FeatureGroup) source).getDirection().equals(DirectionType.IN)) {
					error("The direction of the source " + source.getName()
							+ " of a directional feature group connection must not be in", connection,
							Aadl2Package.eINSTANCE.getConnection_Source(), MAKE_CONNECTION_BIDIRECTIONAL);
				} else if (((FeatureGroup) source).getDirection().equals(DirectionType.IN_OUT)) {
					inverseContext = srccxt instanceof FeatureGroup && ((FeatureGroup) srccxt).isInverse();
					checkDirectionOfFeatureGroupMembers((FeatureGroup) source, DirectionType.IN, connection,
							Aadl2Package.eINSTANCE.getConnection_Source(), inverseContext);
				}
				if (((FeatureGroup) destination).getDirection().equals(DirectionType.OUT)) {
					error("The direction of the destination " + destination.getName()
							+ " of a directional feature group connection must not be out", connection,
							Aadl2Package.eINSTANCE.getConnection_Destination(), MAKE_CONNECTION_BIDIRECTIONAL);
				} else if (((FeatureGroup) destination).getDirection().equals(DirectionType.IN_OUT)) {
					inverseContext = dstcxt instanceof FeatureGroup && ((FeatureGroup) dstcxt).isInverse();
					checkDirectionOfFeatureGroupMembers((FeatureGroup) destination, DirectionType.OUT, connection,
							Aadl2Package.eINSTANCE.getConnection_Destination(), inverseContext);
				}
			} else if (!(srccxt instanceof Subcomponent)) {
				// going down
				if (((FeatureGroup) source).getDirection().equals(DirectionType.OUT)) {
					error("The direction of the source " + source.getName()
							+ " of this incoming directional feature group connection must not be out", connection,
							Aadl2Package.eINSTANCE.getConnection_Source(), MAKE_CONNECTION_BIDIRECTIONAL);
				} else if (((FeatureGroup) source).getDirection().equals(DirectionType.IN_OUT)) {
					inverseContext = srccxt instanceof FeatureGroup && ((FeatureGroup) srccxt).isInverse();
					checkDirectionOfFeatureGroupMembers((FeatureGroup) source, DirectionType.OUT, connection,
							Aadl2Package.eINSTANCE.getConnection_Source(), inverseContext);
				}

				if (((FeatureGroup) destination).getDirection().equals(DirectionType.OUT)) {
					error("The direction of the destination " + destination.getName()
							+ " of this incoming directional feature group connection must not be out", connection,
							Aadl2Package.eINSTANCE.getConnection_Destination(), MAKE_CONNECTION_BIDIRECTIONAL);
				} else if (((FeatureGroup) destination).getDirection().equals(DirectionType.IN_OUT)) {
					inverseContext = dstcxt instanceof FeatureGroup && ((FeatureGroup) dstcxt).isInverse();
					checkDirectionOfFeatureGroupMembers((FeatureGroup) destination, DirectionType.OUT, connection,
							Aadl2Package.eINSTANCE.getConnection_Destination(), inverseContext);
				}
			} else if (!(dstcxt instanceof Subcomponent)) {
				// going up
				if (((FeatureGroup) source).getDirection().equals(DirectionType.IN)) {
					error("The direction of the source " + source.getName()
							+ " of this outgoing directional feature group connection must not be in", connection,
							Aadl2Package.eINSTANCE.getConnection_Destination(), MAKE_CONNECTION_BIDIRECTIONAL);
				} else if (((FeatureGroup) source).getDirection().equals(DirectionType.IN_OUT)) {
					inverseContext = srccxt instanceof FeatureGroup && ((FeatureGroup) srccxt).isInverse();
					checkDirectionOfFeatureGroupMembers((FeatureGroup) source, DirectionType.IN, connection,
							Aadl2Package.eINSTANCE.getConnection_Source(), inverseContext);
				}
				if (((FeatureGroup) destination).getDirection().equals(DirectionType.IN)) {
					error("The direction of the destination " + destination.getName()
							+ " of this outgoing directional feature group connection must not be in", connection,
							Aadl2Package.eINSTANCE.getConnection_Destination(), MAKE_CONNECTION_BIDIRECTIONAL);
				} else if (((FeatureGroup) destination).getDirection().equals(DirectionType.IN_OUT)) {
					inverseContext = dstcxt instanceof FeatureGroup && ((FeatureGroup) dstcxt).isInverse();
					checkDirectionOfFeatureGroupMembers((FeatureGroup) destination, DirectionType.IN, connection,
							Aadl2Package.eINSTANCE.getConnection_Destination(), inverseContext);
				}
			}
		}
	}

	/**
	 * Checks legality rule 8 in section 9.5 the endpoints of a directional
	 * feature group must be consistent with the direction.
	 */
	private void checkDirectionOfFeatureGroupMembers(FeatureGroup featureGroup, DirectionType notDir, Connection conn,
			EStructuralFeature structuralFeature, boolean inverseContext) {
		FeatureGroupType fgt = featureGroup.getFeatureGroupType();
		if (fgt == null) {
			return;
		}
		for (Feature feature : fgt.getAllFeatures()) {
			boolean invfg = featureGroup.isInverse() || inverseContext;

			boolean invfgt = fgt.getInverse() != null && fgt.getOwnedFeatures().isEmpty()
					&& Aadl2Util.isNull(fgt.getExtended());

			boolean inverse = (invfg && !invfgt) || (!invfg && invfgt);

			if (feature instanceof DirectedFeature) {
				DirectionType featureDirection = ((DirectedFeature) feature).getDirection();

				if (featureDirection == DirectionType.IN_OUT) {
					break;
				}
				boolean dirEquals = featureDirection.equals(notDir);

				if ((!inverse && dirEquals) || (inverse && !dirEquals)) {
					// error("Feature " + feature.getName() + " in the
					// referenced feature group " + featureGroup.getName()
					// + " must not be " + notDir.getName() + " due to the
					// direction of the connection", conn,
					// structuralFeature);
					error("Feature " + feature.getName() + " in the referenced feature group " + featureGroup.getName()
							+ " must not be " + notDir.getName() + " due to the direction of the connection", conn,
							structuralFeature, MAKE_CONNECTION_BIDIRECTIONAL);

				}
			}
		}
	}

	/**
	 * Checks legality rule L3 for section 9.5 (Feature Group Connections) "The
	 * following rules are supported for feature group connection declarations
	 * that represent a connection up or down the containment hierarchy:
	 *
	 * -Classifier_Match: The source feature group type must be identical to the
	 * feature group type of the destination. This is the default rule.
	 *
	 * -Equivalence: An indication that the two classifiers of a connection are
	 * considered to match if they are listed in the
	 * Supported_Classifier_Equivalence_Matches property. Matching feature group
	 * types are specified by the Supported_Classifier_Equivalence_Matches
	 * property with pairs of classifier values representing acceptable matches.
	 * Either element of the pair can be the source or destination classifier.
	 * Equivalence is intended to be used when the feature group types are
	 * considered to be identical, i.e., their elements match. The
	 * Supported_Classifier_Equivalence_Matches property is declared globally as
	 * a property constant.
	 *
	 * -Subset: An indication that the two classifiers of a connection are
	 * considered to match if the outer feature group has outcoming features
	 * that are a subset of outgoing features of the inner feature group, and if
	 * the inner feature group has incoming features that are a subset of
	 * incoming features of the outer feature group. The pairs of features are
	 * expected to have the same name."
	 *
	 * Checks legality rule L4 for section 9.5 (Feature Group Connections) "The
	 * following rules are supported for feature group connection declarations
	 * that represent a connection between two subcomponents, i.e., sibling
	 * component:
	 *
	 * -Classifier_Match: The source feature group type must be the complement
	 * of the feature group type of the destination. This is the default rule.
	 *
	 * -Complement: An indication that the two classifiers of a connection are
	 * considered to complement if they are listed in the
	 * Supported_Classifier_Complement_Matches property. Matching feature group
	 * types are specified by the Supported_Classifier_Complement_Matches
	 * property with pairs of classifier values representing acceptable matches.
	 * Either element of the pair can be the source or destination classifier.
	 * Complement is intended to be used when the feature group types are
	 * considered to be identical, i.e., their elements match. The
	 * Supported_Classifier_Complement_Matches property is declared globally as
	 * a property constant.
	 *
	 * -Subset: An indication that the two classifiers of a connection are
	 * considered to match if each has incoming features that are a subset of
	 * outgoing features of the other. The pairs of features are expected to
	 * have the same name."
	 */
	private void checkFeatureGroupConnectionClassifiers(Connection connection) {
		if (!(connection.getAllSource() instanceof FeatureGroup)
				|| !(connection.getAllDestination() instanceof FeatureGroup)) {
			return;
		}
		FeatureGroup source = (FeatureGroup) connection.getAllSource();
		FeatureGroup destination = (FeatureGroup) connection.getAllDestination();
		FeatureGroupType sourceType = source.getAllFeatureGroupType();
		FeatureGroupType destinationType = destination.getAllFeatureGroupType();
		if (sourceType == null || destinationType == null) {
			return;
		}
		Property classifierMatchingRuleProperty = GetProperties.lookupPropertyDefinition(connection,
				ModelingProperties._NAME, ModelingProperties.CLASSIFIER_MATCHING_RULE);
		EnumerationLiteral classifierMatchingRuleValue;
		try {
			classifierMatchingRuleValue = PropertyUtils.getEnumLiteral(connection, classifierMatchingRuleProperty);
		} catch (PropertyNotPresentException e) {
			classifierMatchingRuleValue = null;
		}
		Context srcContext = connection.getAllSourceContext();
		Context dstContext = connection.getAllDestinationContext();
		// connection across or through a component
		if (srcContext instanceof Subcomponent && dstContext instanceof Subcomponent
				|| (srcContext == null || srcContext instanceof FeatureGroup)
						&& (dstContext == null || dstContext instanceof FeatureGroup)) {
			if (classifierMatchingRuleValue == null
					|| ModelingProperties.CLASSIFIER_MATCH.equalsIgnoreCase(classifierMatchingRuleValue.getName())
					|| ModelingProperties.EQUIVALENCE.equalsIgnoreCase(classifierMatchingRuleValue.getName())
					|| ModelingProperties.CONVERSION.equalsIgnoreCase(classifierMatchingRuleValue.getName())) {
				if (classifierMatchingRuleValue != null
						&& ModelingProperties.EQUIVALENCE.equalsIgnoreCase(classifierMatchingRuleValue.getName())) {
					warning(connection,
							"The classifier matching rule '" + ModelingProperties.EQUIVALENCE
									+ "' is not supported for feature group connections between two subcomponents. Using rule '"
									+ ModelingProperties.CLASSIFIER_MATCH + "' instead.");
				}
				if (classifierMatchingRuleValue != null
						&& ModelingProperties.CONVERSION.equalsIgnoreCase(classifierMatchingRuleValue.getName())) {
					warning(connection,
							"The classifier matching rule '" + ModelingProperties.CONVERSION
									+ "' is not supported for feature group connections. Using rule '"
									+ ModelingProperties.CLASSIFIER_MATCH + "' instead.");
				}
				if (!testIfFeatureGroupsAreInverses(source, srcContext, destination, dstContext)) {
					error(connection, "The feature groups '" + source.getName() + "' and '" + destination.getName()
							+ "' are not inverses of each other.");
				}
			}
			// XXX TODO should have the EQUIVALENCE test for across with inverse
			// else if
			// (ModelingProperties.COMPLEMENT.equalsIgnoreCase(classifierMatchingRuleValue.getName()))
			// {
			// if (!testIfFeatureGroupTypesAreInverses(source, sourceType,
			// destination, destinationType) &&
			// !classifiersFoundInSupportedClassifierComplementMatchesProperty(connection,
			// sourceType, destinationType)) {
			// error(connection, "The types of '" + source.getName() + "' and '"
			// + destination.getName() + "' ('" + sourceType.getQualifiedName()
			// + "' and '" + destinationType.getQualifiedName() +
			// "') are not inverse types and they are not listed as matching
			// classifiers in the property constant '" +
			// AadlProject.SUPPORTED_CLASSIFIER_COMPLEMENT_MATCHES + "'.");
			// }
			// }
			else if (ModelingProperties.SUBSET.equalsIgnoreCase(classifierMatchingRuleValue.getName())) {
				if (!testIfFeatureGroupsAreInverses(source, srcContext, destination, dstContext)
						&& !checkIfFeatureGroupTypesAreSiblingSubsets(sourceType, source.isInverse(), destinationType,
								destination.isInverse())) {
					error(connection,
							"The types of '" + source.getName() + "' and '" + destination.getName() + "' ('"
									+ sourceType.getQualifiedName() + "' and '" + destinationType.getQualifiedName()
									+ "') are not inverse types and they do not satisfy the Subset rule for classifier matching.  In order to satisfy this rule, the incoming features of each feature group must be a"
									+ " subset of the outgoing features in the opposite feature group.");
				}
			}
			// does not work because of ports in both directions. WOuld have to
			// be subset
			// else if
			// (ModelingProperties.TYPE_EXTENSION.equalsIgnoreCase(classifierMatchingRuleValue.getName()))
			// {
			// if (!testIfFeatureGroupTypeExtension(destinationType,
			// sourceType)) {
			// error(connection, "The type "+ sourceType.getQualifiedName() +"
			// of '" + source.getName() + "' is not a type extension of type "+
			// destinationType.getQualifiedName() +" of '" +
			// destination.getName()+"'");
			// }
			// }

		} else { // up or down hierarchy
			boolean cxtFGIsInverse = false;
			if (connection.getAllSourceContext() instanceof FeatureGroup) {
				cxtFGIsInverse = ((FeatureGroup) connection.getAllSourceContext()).isInverse();
			} else if (connection.getAllDestinationContext() instanceof FeatureGroup) {
				cxtFGIsInverse = ((FeatureGroup) connection.getAllDestinationContext()).isInverse();
			}
			if (classifierMatchingRuleValue == null
					|| ModelingProperties.CLASSIFIER_MATCH.equalsIgnoreCase(classifierMatchingRuleValue.getName())
					|| ModelingProperties.CONVERSION.equalsIgnoreCase(classifierMatchingRuleValue.getName())
			// ||
			// ModelingProperties.COMPLEMENT.equalsIgnoreCase(classifierMatchingRuleValue.getName())
			) {
				if (classifierMatchingRuleValue != null
						&& ModelingProperties.CONVERSION.equalsIgnoreCase(classifierMatchingRuleValue.getName())) {
					warning(connection,
							"The classifier matching rule '" + ModelingProperties.CONVERSION
									+ "' is not supported for feature group connections. Using rule '"
									+ ModelingProperties.CLASSIFIER_MATCH + "' instead.");
				}
				// if (classifierMatchingRuleValue != null &&
				// ModelingProperties.COMPLEMENT.equalsIgnoreCase(classifierMatchingRuleValue.getName()))
				// {
				// warning(connection, "The classifier matching rule '" +
				// ModelingProperties.COMPLEMENT +
				// "' is not supported for feature group connections that
				// connect up or down the containment hierarchy. Using rule '" +
				// ModelingProperties.CLASSIFIER_MATCH + "' instead.");
				// }
				if (sourceType == destinationType) {
					if (cxtFGIsInverse ? source.isInverse() == destination.isInverse()
							: source.isInverse() != destination.isInverse()) {
						error(connection,
								"For connections that connect up or down the containment hierarchy, the feature group types of the source and destination must be identical."
										+ " They cannot be inverses of each other.");
					}
				} else {
					if (isSameInExtends(sourceType, destinationType)) {
						if (cxtFGIsInverse ? source.isInverse() == destination.isInverse()
								: source.isInverse() != destination.isInverse()) {
							error(connection, "Ancestor feature group types match, but feature group '"
									+ source.getName() + "' and '" + destination.getName() + "' differ in inverse of.");
						} else {
							warning(connection, "The feature group type of '" + source.getName() + "' and '"
									+ destination.getName() + "' do not match, but their ancestors do.");
						}
					} else {
						error(connection,
								"The feature group types of the source and destination feature groups must be identical for connections that connect up or down the containment hierarchy.");
					}
				}
			} else if (ModelingProperties.EQUIVALENCE.equalsIgnoreCase(classifierMatchingRuleValue.getName())) {
				if (!testIfFeatureGroupTypesAreIdentical(source, sourceType, destination, destinationType)
						&& !classifiersFoundInSupportedClassifierEquivalenceMatchesProperty(connection, sourceType,
								destinationType)) {
					error(connection,
							"The types of '" + source.getName() + "' and '" + destination.getName() + "' ('"
									+ sourceType.getQualifiedName() + "' and '" + destinationType.getQualifiedName()
									+ "') are not identical and they are not listed as matching classifiers in the property constant '"
									+ AadlProject.SUPPORTED_CLASSIFIER_EQUIVALENCE_MATCHES + "'.");
				}
			} else if (ModelingProperties.SUBSET.equalsIgnoreCase(classifierMatchingRuleValue.getName())) {
				FeatureGroup innerFeatureGroup;
				FeatureGroupType innerFeatureGroupType;
				FeatureGroup outerFeatureGroup;
				FeatureGroupType outerFeatureGroupType;
				if (connection.getAllSourceContext() instanceof Subcomponent) {
					innerFeatureGroup = source;
					innerFeatureGroupType = sourceType;
					outerFeatureGroup = destination;
					outerFeatureGroupType = destinationType;
				} else {
					outerFeatureGroup = source;
					outerFeatureGroupType = sourceType;
					innerFeatureGroup = destination;
					innerFeatureGroupType = destinationType;
				}
				if (!testIfFeatureGroupTypesAreIdentical(source, sourceType, destination, destinationType)
						&& !checkIfFeatureGroupTypesAreUpAndDownSubsets(innerFeatureGroupType,
								innerFeatureGroup.isInverse(), outerFeatureGroupType, outerFeatureGroup.isInverse())) {
					error(connection,
							"The types of '" + source.getName() + "' and '" + destination.getName() + "' ('"
									+ sourceType.getQualifiedName() + "' and '" + destination.getQualifiedName()
									+ "') are not identical and they do not satisfy the Subset rule for classifier matching.  In order to satisfy this rule, the incoming features of the inner feature group must be a"
									+ " subset of the incoming features of the outer feature group and the outgoing features of the outer feature group must be a subset of the outgoing features of the inner feature"
									+ " group.");
				}
			}
			// works
			// else if
			// (ModelingProperties.TYPE_EXTENSION.equalsIgnoreCase(classifierMatchingRuleValue.getName()))
			// {
			// FeatureGroup innerFeatureGroup;
			// FeatureGroupType innerFeatureGroupType;
			// FeatureGroup outerFeatureGroup;
			// FeatureGroupType outerFeatureGroupType;
			// if (connection.getAllSourceContext() instanceof Subcomponent) {
			// innerFeatureGroup = source;
			// innerFeatureGroupType = sourceType;
			// outerFeatureGroup = destination;
			// outerFeatureGroupType = destinationType;
			// }
			// else {
			// outerFeatureGroup = source;
			// outerFeatureGroupType = sourceType;
			// innerFeatureGroup = destination;
			// innerFeatureGroupType = destinationType;
			// }
			// if (!testIfFeatureGroupTypeExtension(innerFeatureGroupType,
			// outerFeatureGroupType)) {
			// error(connection, "The type "+
			// outerFeatureGroupType.getQualifiedName() +" of '" +
			// outerFeatureGroup.getName() + "' is not a type extension of type
			// "+ outerFeatureGroupType.getQualifiedName() +" of '" +
			// outerFeatureGroup.getName()+"'");
			// }
			// }
		}
	}

	private boolean testIfFeatureGroupsAreInverses(FeatureGroup source, Context sourceContext, FeatureGroup destination,
			Context destinationContext) {
		return isInverse(source, sourceContext) ^ isInverse(destination, destinationContext);
	}

	private boolean isInverse(FeatureGroup fg, Context context) {
		boolean result = fg.isInverse();

		result ^= fg.getAllFeatureGroupType().getInverse() != null;

		if (context instanceof FeatureGroup) {
			FeatureGroup parent = (FeatureGroup) context;
			result ^= parent.isInverse();
			FeatureGroupType parentType = parent.getAllFeatureGroupType();
			result ^= parentType.getInverse() != null;
		}
		return result;
	}

	private boolean testIfFeatureGroupTypeExtensionsAreInverses(FeatureGroup source, FeatureGroupType sourceType,
			FeatureGroup destination, FeatureGroupType destinationType) {
		// one is the ancestor of the other
		// then the fg must have opposite inverses
		if (AadlUtil.isSameOrExtends(sourceType, destinationType)
				|| AadlUtil.isSameOrExtends(destinationType, sourceType)) {
			return (source.isInverse() && !destination.isInverse()) || (!source.isInverse() && destination.isInverse());
		}
		if (isInverseOfInExtends(sourceType, destinationType)) {
			// fg must be the same (both inverse or both not inverse)
			return (source.isInverse() && destination.isInverse()) || (!source.isInverse() && !destination.isInverse());
		}
		if (isSameInExtends(sourceType, destinationType)) {
			// they have a common FGT root
			return (source.isInverse() && !destination.isInverse()) || (!source.isInverse() && destination.isInverse());
		}
		return false;
	}

	public boolean isInverseOfInExtends(FeatureGroupType srcpgt, FeatureGroupType dstpgt) {
		EList<Classifier> srcancestors = getSelfPlusAncestors(srcpgt);
		FeatureGroupType dstfgt = dstpgt;
		while (!Aadl2Util.isNull(dstfgt)) {
			if (!Aadl2Util.isNull(dstfgt.getInverse())) {
				if (srcancestors.contains(dstfgt.getInverse())) {
					return true;
				}
			}
			dstfgt = dstfgt.getExtended();
		}
		EList<Classifier> dstancestors = getSelfPlusAncestors(dstpgt);
		FeatureGroupType srcfgt = srcpgt;
		while (!Aadl2Util.isNull(srcfgt)) {
			if (!Aadl2Util.isNull(srcfgt.getInverse())) {
				if (dstancestors.contains(srcfgt.getInverse())) {
					return true;
				}
			}
			srcfgt = srcfgt.getExtended();
		}
		return false;
	}

	public boolean isSameInExtends(FeatureGroupType srcpgt, FeatureGroupType dstpgt) {
		EList<Classifier> srcancestors = getSelfPlusAncestors(srcpgt);
		FeatureGroupType dstfgt = dstpgt;
		while (!Aadl2Util.isNull(dstfgt)) {
			if (srcancestors.contains(dstfgt)) {
				return true;
			}
			dstfgt = dstfgt.getExtended();
		}
		return false;
	}

	private boolean testIfFeatureGroupTypeExtension(FeatureGroupType originalType, FeatureGroupType extendedType) {
		if (originalType == extendedType.getExtended()) {
			return true;
		}
		if (extendedType.getInverse() != null && originalType == extendedType.getInverse()) {
			return true;
		}
		return false;
	}

	private boolean testIfFeatureGroupTypesAreIdentical(FeatureGroup source, FeatureGroupType sourceType,
			FeatureGroup destination, FeatureGroupType destinationType) {
		if (sourceType == destinationType) {
			if (source.isInverse() != destination.isInverse()) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * Complies with the criteria for complementing feature group types
	 * specified in legality rules L8 through L12 in section 8.2 (Feature Groups
	 * and Feature Group Types) "(L8) The number of feature or feature groups
	 * contained in the feature group and its complement must be identical; (L9)
	 * Each of the decalred features or feature groups in a feature group must
	 * be a pair-wise complement with that in the feature group complement, with
	 * pairs determined by declaration order. In the case of feature group types
	 * extensions, the feature and feature group declarations in the extension
	 * are considered to be declared after the declarations in the feature group
	 * type being extended; (L10) If both feature group types have zero
	 * features, then they are considered to complement each other; (L11) Ports
	 * are pair-wise complementary if they satisfy the port connection rules
	 * specified in Section 9.2.1. This includes appropriate port direction and
	 * matching of data component classifier references according to classifier
	 * matching rules (see Section 9.5 legality rules (L3) and (L4); (L12)
	 * Access features are pair-wise complementary if they satisfy the access
	 * connection rules in Section 9.4."
	 */
	// It seems that this method may not be needed anymore. It is left here just
	// in case it will
	// be needed in the future. It is currently incomplete.
	// private boolean
	// checkIfFeatureGroupTypesComplementEachOther(FeatureGroupType sourceType,
	// boolean isSourceFGInverse, FeatureGroupType destinationType, boolean
	// isDestinationFGInverse) {
	// EList<Feature> allSourceFeatures = sourceType.getAllFeatures();
	// EList<Feature> allDestinationFeatures = destinationType.getAllFeatures();
	// if (allSourceFeatures.size() == 0 && allDestinationFeatures.size() == 0)
	// return true;
	// if (allSourceFeatures.size() != allDestinationFeatures.size())
	// return false;
	// Iterator<Feature> sourceFeaturesIterator = allSourceFeatures.iterator();
	// Iterator<Feature> destinationFeaturesIterator =
	// allDestinationFeatures.iterator();
	// while (sourceFeaturesIterator.hasNext() &&
	// destinationFeaturesIterator.hasNext()) {
	// Feature sourceFeature = sourceFeaturesIterator.next();
	// Feature destinationFeature = destinationFeaturesIterator.next();
	// if (sourceFeature instanceof Port && destinationFeature instanceof Port)
	// {
	// //Check port types
	// if (sourceFeature instanceof EventPort && !(destinationFeature instanceof
	// EventPort))
	// return false;
	//
	// //Check direction
	// DirectionType sourceDirection = ((Port)sourceFeature).getDirection();
	// DirectionType destinationDirection =
	// ((Port)destinationFeature).getDirection();
	// if (isSourceFGInverse)
	// sourceDirection = sourceDirection.getInverseDirection();
	// if (sourceType != sourceFeature.getContainingClassifier() &&
	// sourceType.getInverse() != null) {
	// //feature group type has inverse and feature is defined in the inverse
	// FGT
	// sourceDirection = sourceDirection.getInverseDirection();
	// }
	// if (isDestinationFGInverse)
	// destinationDirection = destinationDirection.getInverseDirection();
	// if (destinationType != destinationFeature.getContainingClassifier() &&
	// destinationType.getInverse() != null) {
	// //feature group type has inverse and feature is defined in the inverse
	// FGT
	// destinationDirection = destinationDirection.getInverseDirection();
	// }
	// if ((sourceDirection == DirectionType.IN && destinationDirection ==
	// DirectionType.IN) || (sourceDirection == DirectionType.OUT &&
	// destinationDirection == DirectionType.OUT))
	// return false;
	//
	// //Check classifier
	// ComponentClassifier sourceClassifier = sourceFeature.getAllClassifier();
	// ComponentClassifier destinationClassifier =
	// destinationFeature.getAllClassifier();
	// if (sourceClassifier != null && destinationClassifier != null &&
	// sourceClassifier != destinationClassifier) {
	// if ((sourceClassifier instanceof ComponentType && destinationClassifier
	// instanceof ComponentType) ||
	// (sourceClassifier instanceof ComponentImplementation &&
	// destinationClassifier instanceof ComponentImplementation)) {
	// return false;
	// }
	// }
	// }
	// }
	// return true;
	// }

	private boolean checkIfFeatureGroupTypesAreUpAndDownSubsets(FeatureGroupType innerType, boolean isInnerFGInverse,
			FeatureGroupType outerType, boolean isOuterFGInverse) {
		for (Feature innerFeature : innerType.getAllFeatures()) {
			if (innerFeature instanceof DirectedFeature) {
				DirectionType innerDirection = ((DirectedFeature) innerFeature).getDirection();
				if (isInnerFGInverse) {
					innerDirection = innerDirection.getInverseDirection();
				}
				if (innerType != innerFeature.getContainingClassifier() && innerType.getInverse() != null) {
					// feature group type has inverse and feature is defined in
					// the inverse FGT
					innerDirection = innerDirection.getInverseDirection();
				}
				// if (innerDirection.incoming()) {
				// need to find incoming feature in outer feature group
				boolean matchingFeatureFound = false;
				for (Feature outerFeature : outerType.getAllFeatures()) {
					if (innerFeature.getName().equalsIgnoreCase(outerFeature.getName())) {
						matchingFeatureFound = true;
						if (outerFeature instanceof DirectedFeature) {
							DirectionType outerDirection = ((DirectedFeature) outerFeature).getDirection();
							if (isOuterFGInverse) {
								outerDirection = outerDirection.getInverseDirection();
							}
							if (outerType != outerFeature.getContainingClassifier() && outerType.getInverse() != null) {
								// feature group type has inverse and feature is
								// defined in the inverse FGT
								outerDirection = outerDirection.getInverseDirection();
							}
							// if (!outerDirection.incoming())
							// return false;
							if (!innerFeature.eClass().equals(outerFeature.eClass())) {
								return false;
							}
						} else {
							return false;
						}
					}
				}
				if (!matchingFeatureFound) {
					return false;
					// }
				}
			}
		}

		// for (Feature outerFeature : outerType.getAllFeatures()) {
		// if (outerFeature instanceof DirectedFeature) {
		// DirectionType outerDirection =
		// ((DirectedFeature)outerFeature).getDirection();
		// if (isOuterFGInverse)
		// outerDirection = outerDirection.getInverseDirection();
		// if (outerType != outerFeature.getContainingClassifier() &&
		// outerType.getInverse() != null) {
		// //feature group type has inverse and feature is defined in the
		// inverse FGT
		// outerDirection = outerDirection.getInverseDirection();
		// }
		// if (outerDirection.outgoing()) {
		// //need to find outgoing feature in inner feature group
		// boolean matchingFeatureFound = false;
		// for (Feature innerFeature : innerType.getAllFeatures()) {
		// if (outerFeature.getName().equalsIgnoreCase(innerFeature.getName()))
		// {
		// matchingFeatureFound = true;
		// if (innerFeature instanceof DirectedFeature) {
		// DirectionType innerDirection =
		// ((DirectedFeature)innerFeature).getDirection();
		// if (isInnerFGInverse)
		// innerDirection = innerDirection.getInverseDirection();
		// if (innerType != innerFeature.getContainingClassifier() &&
		// innerType.getInverse() != null) {
		// //feature group type has inverse and feature is defined in the
		// inverse FGT
		// innerDirection = innerDirection.getInverseDirection();
		// }
		// if (!innerDirection.outgoing())
		// return false;
		// if (!outerFeature.eClass().equals(innerFeature.eClass()))
		// return false;
		// }
		// else
		// return false;
		// }
		// }
		// if (!matchingFeatureFound)
		// return false;
		// }
		// }
		// }

		return true;
	}

	private boolean checkIfFeatureGroupTypesAreSiblingSubsets(FeatureGroupType sourceType, boolean isSourceFGInverse,
			FeatureGroupType destinationType, boolean isDestinationFGInverse) {
		for (Feature sourceFeature : sourceType.getAllFeatures()) {
			if (sourceFeature instanceof DirectedFeature) {
				DirectionType sourceDirection = ((DirectedFeature) sourceFeature).getDirection();
				if (isSourceFGInverse) {
					sourceDirection = sourceDirection.getInverseDirection();
				}
				if (sourceType != sourceFeature.getContainingClassifier() && sourceType.getInverse() != null) {
					// feature group type has inverse and feature is defined in
					// the inverse FGT
					sourceDirection = sourceDirection.getInverseDirection();
				}
				if (sourceDirection.incoming()) {
					// need to find outgoing feature in destination
					boolean matchingFeatureFound = false;
					for (Feature destinationFeature : destinationType.getAllFeatures()) {
						if (sourceFeature.getName().equalsIgnoreCase(destinationFeature.getName())) {
							matchingFeatureFound = true;
							if (destinationFeature instanceof DirectedFeature) {
								DirectionType destinationDirection = ((DirectedFeature) destinationFeature)
										.getDirection();
								if (isDestinationFGInverse) {
									destinationDirection = destinationDirection.getInverseDirection();
								}
								if (destinationType != destinationFeature.getContainingClassifier()
										&& destinationType.getInverse() != null) {
									// feature group type has inverse and
									// feature is defined in the inverse FGT
									destinationDirection = destinationDirection.getInverseDirection();
								}
								if (!destinationDirection.outgoing()) {
									return false;
								}
								if (!sourceFeature.eClass().equals(destinationFeature.eClass())) {
									return false;
								}
							} else {
								return false;
							}
						}
					}
					if (!matchingFeatureFound) {
						return false;
					}
				}
			}
		}

		for (Feature destinationFeature : destinationType.getAllFeatures()) {
			if (destinationFeature instanceof DirectedFeature) {
				DirectionType destinationDirection = ((DirectedFeature) destinationFeature).getDirection();
				if (isDestinationFGInverse) {
					destinationDirection = destinationDirection.getInverseDirection();
				}
				if (destinationType != destinationFeature.getContainingClassifier()
						&& destinationType.getInverse() != null) {
					// feature group type has inverse and feature is defined in
					// the inverse FGT
					destinationDirection = destinationDirection.getInverseDirection();
				}
				if (destinationDirection.incoming()) {
					// need to find outgoing feature in source
					boolean matchingFeatureFound = false;
					for (Feature sourceFeature : sourceType.getAllFeatures()) {
						if (destinationFeature.getName().equalsIgnoreCase(sourceFeature.getName())) {
							matchingFeatureFound = true;
							if (sourceFeature instanceof DirectedFeature) {
								DirectionType sourceDirection = ((DirectedFeature) sourceFeature).getDirection();
								if (isSourceFGInverse) {
									sourceDirection = sourceDirection.getInverseDirection();
								}
								if (sourceType != sourceFeature.getContainingClassifier()
										&& sourceType.getInverse() != null) {
									// feature group type has inverse and
									// feature is defined in the inverse FGT
									sourceDirection = sourceDirection.getInverseDirection();
								}
								if (!sourceDirection.outgoing()) {
									return false;
								}
								if (!destinationFeature.eClass().equals(sourceFeature.eClass())) {
									return false;
								}
							} else {
								return false;
							}
						}
					}
					if (!matchingFeatureFound) {
						return false;
					}
				}
			}
		}

		return true;
	}

	private boolean classifiersFoundInSupportedClassifierComplementMatchesProperty(FeatureGroupConnection connection,
			FeatureGroupType source, FeatureGroupType destination) {
		PropertyConstant matchesPropertyConstant = GetProperties.lookupPropertyConstant(connection,
				AadlProject.SUPPORTED_CLASSIFIER_COMPLEMENT_MATCHES);
		if (matchesPropertyConstant == null) {
			return false;
		}
		PropertyExpression constantValue = matchesPropertyConstant.getConstantValue();
		if (!(constantValue instanceof ListValue)) {
			return false;
		}
		for (PropertyExpression classifierPair : ((ListValue) constantValue).getOwnedListElements()) {
			if (classifierPair instanceof ListValue) {
				EList<PropertyExpression> innerListElements = ((ListValue) classifierPair).getOwnedListElements();
				if (innerListElements.size() == 2 && innerListElements.get(0) instanceof ClassifierValue
						&& innerListElements.get(1) instanceof ClassifierValue) {
					Classifier firstPairElement = ((ClassifierValue) innerListElements.get(0)).getClassifier();
					Classifier secondPairElement = ((ClassifierValue) innerListElements.get(1)).getClassifier();
					if ((firstPairElement == source && secondPairElement == destination)
							|| (firstPairElement == destination && secondPairElement == source)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	static public void applyTest(EObject element, List<String> data) throws Exception {
		ResourceSet resourceSet = element.eResource().getResourceSet();

		NamedElement duplicated = (NamedElement) resourceSet.getEObject(URI.createURI(data.get(1)), true);

		// ((DataPort) element).setOut(true);
		// ((DataPort) element).setIn(false);
		((Feature) element).setName(null);
		((Feature) element).setRefined((Feature) duplicated);
		java.lang.System.out.println(((Feature) element).getRefined());
	}
}
