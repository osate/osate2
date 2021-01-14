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
package org.osate.xtext.aadl2.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractPrototype;
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.ArraySize;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.BusImplementation;
import org.osate.aadl2.BusPrototype;
import org.osate.aadl2.BusSubcomponent;
import org.osate.aadl2.BusType;
import org.osate.aadl2.ClassifierType;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentImplementationReference;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.ComponentTypeRename;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataImplementation;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataPrototype;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DataType;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.DeviceImplementation;
import org.osate.aadl2.DevicePrototype;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.DeviceType;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventDataSource;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.EventSource;
import org.osate.aadl2.FeatureConnection;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeatureGroupTypeRename;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.FeaturePrototypeReference;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListType;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.MemoryImplementation;
import org.osate.aadl2.MemoryPrototype;
import org.osate.aadl2.MemorySubcomponent;
import org.osate.aadl2.MemoryType;
import org.osate.aadl2.MetaclassReference;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.NumericRange;
import org.osate.aadl2.Operation;
import org.osate.aadl2.PackageRename;
import org.osate.aadl2.ParameterConnection;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.PortProxy;
import org.osate.aadl2.PortSpecification;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ProcessPrototype;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessType;
import org.osate.aadl2.ProcessorImplementation;
import org.osate.aadl2.ProcessorPrototype;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.ProcessorType;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.Realization;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceType;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramGroupImplementation;
import org.osate.aadl2.SubprogramGroupPrototype;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramGroupType;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramPrototype;
import org.osate.aadl2.SubprogramProxy;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemPrototype;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.ThreadGroupImplementation;
import org.osate.aadl2.ThreadGroupPrototype;
import org.osate.aadl2.ThreadGroupSubcomponent;
import org.osate.aadl2.ThreadGroupType;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.ThreadPrototype;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.ThreadType;
import org.osate.aadl2.TypeExtension;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.VirtualBusImplementation;
import org.osate.aadl2.VirtualBusPrototype;
import org.osate.aadl2.VirtualBusSubcomponent;
import org.osate.aadl2.VirtualBusType;
import org.osate.aadl2.VirtualProcessorImplementation;
import org.osate.aadl2.VirtualProcessorPrototype;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.VirtualProcessorType;
import org.osate.xtext.aadl2.properties.serializer.PropertiesSemanticSequencer;
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractAadl2SemanticSequencer extends PropertiesSemanticSequencer {

	@Inject
	private Aadl2GrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Aadl2Package.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case Aadl2Package.AADL_BOOLEAN:
				if (rule == grammarAccess.getPropertyTypeRule()
						|| rule == grammarAccess.getBooleanTypeRule()) {
					sequence_BooleanType(context, (AadlBoolean) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnnamedPropertyTypeRule()
						|| rule == grammarAccess.getUnnamedBooleanTypeRule()) {
					sequence_UnnamedBooleanType(context, (AadlBoolean) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.AADL_INTEGER:
				if (rule == grammarAccess.getPropertyTypeRule()
						|| rule == grammarAccess.getIntegerTypeRule()) {
					sequence_IntegerType(context, (AadlInteger) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnnamedPropertyTypeRule()
						|| rule == grammarAccess.getUnnamedIntegerTypeRule()) {
					sequence_UnnamedIntegerType(context, (AadlInteger) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.AADL_PACKAGE:
				sequence_AadlPackage(context, (AadlPackage) semanticObject); 
				return; 
			case Aadl2Package.AADL_REAL:
				if (rule == grammarAccess.getPropertyTypeRule()
						|| rule == grammarAccess.getRealTypeRule()) {
					sequence_RealType(context, (AadlReal) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnnamedPropertyTypeRule()
						|| rule == grammarAccess.getUnnamedRealTypeRule()) {
					sequence_UnnamedRealType(context, (AadlReal) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.AADL_STRING:
				if (rule == grammarAccess.getPropertyTypeRule()
						|| rule == grammarAccess.getStringTypeRule()) {
					sequence_StringType(context, (AadlString) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnnamedPropertyTypeRule()
						|| rule == grammarAccess.getUnnamedStringTypeRule()) {
					sequence_UnnamedStringType(context, (AadlString) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.ABSTRACT_FEATURE:
				sequence_AbstractFeature(context, (AbstractFeature) semanticObject); 
				return; 
			case Aadl2Package.ABSTRACT_IMPLEMENTATION:
				sequence_AbstractImplementation(context, (AbstractImplementation) semanticObject); 
				return; 
			case Aadl2Package.ABSTRACT_PROTOTYPE:
				sequence_AbstractPrototype(context, (AbstractPrototype) semanticObject); 
				return; 
			case Aadl2Package.ABSTRACT_SUBCOMPONENT:
				sequence_AbstractSubcomponent(context, (AbstractSubcomponent) semanticObject); 
				return; 
			case Aadl2Package.ABSTRACT_TYPE:
				sequence_AbstractType(context, (AbstractType) semanticObject); 
				return; 
			case Aadl2Package.ACCESS_CONNECTION:
				sequence_AccessConnection(context, (AccessConnection) semanticObject); 
				return; 
			case Aadl2Package.ACCESS_SPECIFICATION:
				sequence_AccessSpecification(context, (AccessSpecification) semanticObject); 
				return; 
			case Aadl2Package.ARRAY_DIMENSION:
				sequence_ArrayDimension(context, (ArrayDimension) semanticObject); 
				return; 
			case Aadl2Package.ARRAY_RANGE:
				sequence_ArrayRange(context, (ArrayRange) semanticObject); 
				return; 
			case Aadl2Package.ARRAY_SIZE:
				sequence_ArraySize(context, (ArraySize) semanticObject); 
				return; 
			case Aadl2Package.BASIC_PROPERTY:
				sequence_RecordField(context, (BasicProperty) semanticObject); 
				return; 
			case Aadl2Package.BASIC_PROPERTY_ASSOCIATION:
				sequence_FieldPropertyAssociation(context, (BasicPropertyAssociation) semanticObject); 
				return; 
			case Aadl2Package.BOOLEAN_LITERAL:
				sequence_BooleanLiteral(context, (BooleanLiteral) semanticObject); 
				return; 
			case Aadl2Package.BUS_ACCESS:
				sequence_BusAccess(context, (BusAccess) semanticObject); 
				return; 
			case Aadl2Package.BUS_IMPLEMENTATION:
				sequence_BusImplementation(context, (BusImplementation) semanticObject); 
				return; 
			case Aadl2Package.BUS_PROTOTYPE:
				sequence_BusPrototype(context, (BusPrototype) semanticObject); 
				return; 
			case Aadl2Package.BUS_SUBCOMPONENT:
				sequence_BusSubcomponent(context, (BusSubcomponent) semanticObject); 
				return; 
			case Aadl2Package.BUS_TYPE:
				sequence_BusType(context, (BusType) semanticObject); 
				return; 
			case Aadl2Package.CLASSIFIER_TYPE:
				if (rule == grammarAccess.getPropertyTypeRule()
						|| rule == grammarAccess.getClassifierTypeRule()) {
					sequence_ClassifierType(context, (ClassifierType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnnamedPropertyTypeRule()
						|| rule == grammarAccess.getUnnamedClassifierTypeRule()) {
					sequence_UnnamedClassifierType(context, (ClassifierType) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.CLASSIFIER_VALUE:
				if (rule == grammarAccess.getConstantPropertyExpressionRule()
						|| rule == grammarAccess.getPropertyExpressionRule()
						|| rule == grammarAccess.getComponentClassifierTermRule()) {
					sequence_ComponentClassifierTerm(context, (ClassifierValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getQCReferenceRule()
						|| rule == grammarAccess.getPropertyOwnerRule()) {
					sequence_QCReference(context, (ClassifierValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.COMPONENT_IMPLEMENTATION_REFERENCE:
				sequence_ComponentImplementationReference(context, (ComponentImplementationReference) semanticObject); 
				return; 
			case Aadl2Package.COMPONENT_PROTOTYPE_ACTUAL:
				sequence_ComponentReference(context, (ComponentPrototypeActual) semanticObject); 
				return; 
			case Aadl2Package.COMPONENT_PROTOTYPE_BINDING:
				sequence_ComponentPrototypeBinding(context, (ComponentPrototypeBinding) semanticObject); 
				return; 
			case Aadl2Package.COMPONENT_TYPE_RENAME:
				sequence_CTRename(context, (ComponentTypeRename) semanticObject); 
				return; 
			case Aadl2Package.COMPUTED_VALUE:
				sequence_ComputedTerm(context, (ComputedValue) semanticObject); 
				return; 
			case Aadl2Package.CONNECTED_ELEMENT:
				if (rule == grammarAccess.getConnectedElementChainRule()) {
					sequence_ConnectedElementChain(context, (ConnectedElement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getConnectedElementRule()) {
					sequence_ConnectedElement(context, (ConnectedElement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getAbstractConnectionEndRule()) {
					sequence_ConnectedElement_InternalEvent_ProcessorPort(context, (ConnectedElement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getNestedConnectedElementRule()) {
					sequence_ConnectedElement_NestedConnectedElement(context, (ConnectedElement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getProcessorConnectionEndRule()) {
					sequence_ConnectedElement_ProcessorPort(context, (ConnectedElement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getAccessConnectionEndRule()) {
					sequence_ConnectedElement_ProcessorSubprogram(context, (ConnectedElement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getInternalEventRule()) {
					sequence_InternalEvent(context, (ConnectedElement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getProcessorPortRule()) {
					sequence_ProcessorPort(context, (ConnectedElement) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getProcessorSubprogramRule()) {
					sequence_ProcessorSubprogram(context, (ConnectedElement) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.CONTAINED_NAMED_ELEMENT:
				sequence_ContainmentPath(context, (ContainedNamedElement) semanticObject); 
				return; 
			case Aadl2Package.CONTAINMENT_PATH_ELEMENT:
				sequence_ContainmentPathElement(context, (ContainmentPathElement) semanticObject); 
				return; 
			case Aadl2Package.DATA_ACCESS:
				sequence_DataAccess(context, (DataAccess) semanticObject); 
				return; 
			case Aadl2Package.DATA_IMPLEMENTATION:
				sequence_DataImplementation(context, (DataImplementation) semanticObject); 
				return; 
			case Aadl2Package.DATA_PORT:
				sequence_DataPort(context, (DataPort) semanticObject); 
				return; 
			case Aadl2Package.DATA_PROTOTYPE:
				sequence_DataPrototype(context, (DataPrototype) semanticObject); 
				return; 
			case Aadl2Package.DATA_SUBCOMPONENT:
				sequence_DataSubcomponent(context, (DataSubcomponent) semanticObject); 
				return; 
			case Aadl2Package.DATA_TYPE:
				sequence_DataType(context, (DataType) semanticObject); 
				return; 
			case Aadl2Package.DEFAULT_ANNEX_LIBRARY:
				sequence_DefaultAnnexLibrary(context, (DefaultAnnexLibrary) semanticObject); 
				return; 
			case Aadl2Package.DEFAULT_ANNEX_SUBCLAUSE:
				sequence_DefaultAnnexSubclause(context, (DefaultAnnexSubclause) semanticObject); 
				return; 
			case Aadl2Package.DEVICE_IMPLEMENTATION:
				sequence_DeviceImplementation(context, (DeviceImplementation) semanticObject); 
				return; 
			case Aadl2Package.DEVICE_PROTOTYPE:
				sequence_DevicePrototype(context, (DevicePrototype) semanticObject); 
				return; 
			case Aadl2Package.DEVICE_SUBCOMPONENT:
				sequence_DeviceSubcomponent(context, (DeviceSubcomponent) semanticObject); 
				return; 
			case Aadl2Package.DEVICE_TYPE:
				sequence_DeviceType(context, (DeviceType) semanticObject); 
				return; 
			case Aadl2Package.END_TO_END_FLOW:
				sequence_EndToEndFlow(context, (EndToEndFlow) semanticObject); 
				return; 
			case Aadl2Package.END_TO_END_FLOW_SEGMENT:
				if (rule == grammarAccess.getETEConnectionFlowRule()) {
					sequence_ETEConnectionFlow(context, (EndToEndFlowSegment) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getETESubcomponentFlowRule()) {
					sequence_ETESubcomponentFlow(context, (EndToEndFlowSegment) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.ENUMERATION_LITERAL:
				sequence_EnumerationLiteral(context, (EnumerationLiteral) semanticObject); 
				return; 
			case Aadl2Package.ENUMERATION_TYPE:
				if (rule == grammarAccess.getPropertyTypeRule()
						|| rule == grammarAccess.getEnumerationTypeRule()) {
					sequence_EnumerationType(context, (EnumerationType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnnamedPropertyTypeRule()
						|| rule == grammarAccess.getUnnamedEnumerationTypeRule()) {
					sequence_UnnamedEnumerationType(context, (EnumerationType) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.EVENT_DATA_PORT:
				sequence_EventDataPort(context, (EventDataPort) semanticObject); 
				return; 
			case Aadl2Package.EVENT_DATA_SOURCE:
				sequence_EventDataSource(context, (EventDataSource) semanticObject); 
				return; 
			case Aadl2Package.EVENT_PORT:
				sequence_EventPort(context, (EventPort) semanticObject); 
				return; 
			case Aadl2Package.EVENT_SOURCE:
				sequence_EventSource(context, (EventSource) semanticObject); 
				return; 
			case Aadl2Package.FEATURE_CONNECTION:
				sequence_FeatureConnection(context, (FeatureConnection) semanticObject); 
				return; 
			case Aadl2Package.FEATURE_GROUP:
				sequence_FeatureGroup(context, (FeatureGroup) semanticObject); 
				return; 
			case Aadl2Package.FEATURE_GROUP_CONNECTION:
				sequence_FeatureGroupConnection(context, (FeatureGroupConnection) semanticObject); 
				return; 
			case Aadl2Package.FEATURE_GROUP_PROTOTYPE:
				sequence_FeatureGroupPrototype(context, (FeatureGroupPrototype) semanticObject); 
				return; 
			case Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL:
				sequence_FeatureGroupPrototypeActual(context, (FeatureGroupPrototypeActual) semanticObject); 
				return; 
			case Aadl2Package.FEATURE_GROUP_PROTOTYPE_BINDING:
				sequence_FeatureGroupPrototypeBinding(context, (FeatureGroupPrototypeBinding) semanticObject); 
				return; 
			case Aadl2Package.FEATURE_GROUP_TYPE:
				sequence_FeatureGroupType(context, (FeatureGroupType) semanticObject); 
				return; 
			case Aadl2Package.FEATURE_GROUP_TYPE_RENAME:
				sequence_FGTRename(context, (FeatureGroupTypeRename) semanticObject); 
				return; 
			case Aadl2Package.FEATURE_PROTOTYPE:
				sequence_FeaturePrototype(context, (FeaturePrototype) semanticObject); 
				return; 
			case Aadl2Package.FEATURE_PROTOTYPE_BINDING:
				sequence_FeaturePrototypeBinding(context, (FeaturePrototypeBinding) semanticObject); 
				return; 
			case Aadl2Package.FEATURE_PROTOTYPE_REFERENCE:
				sequence_FeaturePrototypeReference(context, (FeaturePrototypeReference) semanticObject); 
				return; 
			case Aadl2Package.FLOW_END:
				sequence_FlowEnd(context, (FlowEnd) semanticObject); 
				return; 
			case Aadl2Package.FLOW_IMPLEMENTATION:
				if (rule == grammarAccess.getFlowPathImplRule()) {
					sequence_FlowPathImpl(context, (FlowImplementation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFlowImplementationRule()) {
					sequence_FlowPathImpl_FlowSinkImpl_FlowSourceImpl(context, (FlowImplementation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFlowSinkImplRule()) {
					sequence_FlowSinkImpl(context, (FlowImplementation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFlowSourceImplRule()) {
					sequence_FlowSourceImpl(context, (FlowImplementation) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.FLOW_SEGMENT:
				if (rule == grammarAccess.getConnectionFlowRule()) {
					sequence_ConnectionFlow(context, (FlowSegment) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSubcomponentFlowRule()) {
					sequence_SubcomponentFlow(context, (FlowSegment) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.FLOW_SPECIFICATION:
				if (rule == grammarAccess.getFlowSpecificationRule()) {
					sequence_FlowPathSpec_FlowSinkSpec_FlowSourceSpec_FlowSpecRefinement(context, (FlowSpecification) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFlowPathSpecRule()) {
					sequence_FlowPathSpec(context, (FlowSpecification) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFlowSinkSpecRule()) {
					sequence_FlowSinkSpec(context, (FlowSpecification) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFlowSourceSpecRule()) {
					sequence_FlowSourceSpec(context, (FlowSpecification) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFlowSpecRefinementRule()) {
					sequence_FlowSpecRefinement(context, (FlowSpecification) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.GROUP_EXTENSION:
				sequence_GroupExtension(context, (GroupExtension) semanticObject); 
				return; 
			case Aadl2Package.IMPLEMENTATION_EXTENSION:
				sequence_ImplementationExtension(context, (ImplementationExtension) semanticObject); 
				return; 
			case Aadl2Package.INTEGER_LITERAL:
				if (rule == grammarAccess.getNumberValueRule()
						|| rule == grammarAccess.getIntegerLitRule()) {
					sequence_IntegerLit(context, (IntegerLiteral) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getConstantPropertyExpressionRule()
						|| rule == grammarAccess.getPropertyExpressionRule()
						|| rule == grammarAccess.getIntegerTermRule()
						|| rule == grammarAccess.getNumAltRule()) {
					sequence_IntegerTerm(context, (IntegerLiteral) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.LIST_TYPE:
				sequence_ListType(context, (ListType) semanticObject); 
				return; 
			case Aadl2Package.LIST_VALUE:
				sequence_ListTerm(context, (ListValue) semanticObject); 
				return; 
			case Aadl2Package.MEMORY_IMPLEMENTATION:
				sequence_MemoryImplementation(context, (MemoryImplementation) semanticObject); 
				return; 
			case Aadl2Package.MEMORY_PROTOTYPE:
				sequence_MemoryPrototype(context, (MemoryPrototype) semanticObject); 
				return; 
			case Aadl2Package.MEMORY_SUBCOMPONENT:
				sequence_MemorySubcomponent(context, (MemorySubcomponent) semanticObject); 
				return; 
			case Aadl2Package.MEMORY_TYPE:
				sequence_MemoryType(context, (MemoryType) semanticObject); 
				return; 
			case Aadl2Package.METACLASS_REFERENCE:
				if (rule == grammarAccess.getAllReferenceRule()) {
					sequence_AllReference(context, (MetaclassReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getQMReferenceRule()
						|| rule == grammarAccess.getPropertyOwnerRule()) {
					sequence_QMReference(context, (MetaclassReference) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.MODAL_PROPERTY_VALUE:
				if (rule == grammarAccess.getModalPropertyValueRule()) {
					sequence_ModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getOptionalModalPropertyValueRule()) {
					sequence_OptionalModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyValueRule()) {
					sequence_PropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.MODE:
				sequence_Mode(context, (Mode) semanticObject); 
				return; 
			case Aadl2Package.MODE_BINDING:
				sequence_ModeRef(context, (ModeBinding) semanticObject); 
				return; 
			case Aadl2Package.MODE_TRANSITION:
				sequence_ModeTransition(context, (ModeTransition) semanticObject); 
				return; 
			case Aadl2Package.MODE_TRANSITION_TRIGGER:
				sequence_Trigger(context, (ModeTransitionTrigger) semanticObject); 
				return; 
			case Aadl2Package.NAMED_VALUE:
				if (rule == grammarAccess.getConstantValueRule()
						|| rule == grammarAccess.getNumAltRule()) {
					sequence_ConstantValue(context, (NamedValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getConstantPropertyExpressionRule()
						|| rule == grammarAccess.getPropertyExpressionRule()
						|| rule == grammarAccess.getLiteralorReferenceTermRule()) {
					sequence_LiteralorReferenceTerm(context, (NamedValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.NUMERIC_RANGE:
				if (rule == grammarAccess.getIntegerRangeRule()) {
					sequence_IntegerRange(context, (NumericRange) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getRealRangeRule()) {
					sequence_RealRange(context, (NumericRange) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.OPERATION:
				sequence_SignedConstant(context, (Operation) semanticObject); 
				return; 
			case Aadl2Package.PACKAGE_RENAME:
				if (rule == grammarAccess.getPackageRenameRule()) {
					sequence_PackageRename(context, (PackageRename) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getRenameAllRule()) {
					sequence_RenameAll(context, (PackageRename) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.PARAMETER:
				sequence_Parameter(context, (org.osate.aadl2.Parameter) semanticObject); 
				return; 
			case Aadl2Package.PARAMETER_CONNECTION:
				sequence_ParameterConnection(context, (ParameterConnection) semanticObject); 
				return; 
			case Aadl2Package.PORT_CONNECTION:
				sequence_PortConnection(context, (PortConnection) semanticObject); 
				return; 
			case Aadl2Package.PORT_PROXY:
				sequence_PortProxy(context, (PortProxy) semanticObject); 
				return; 
			case Aadl2Package.PORT_SPECIFICATION:
				sequence_PortSpecification(context, (PortSpecification) semanticObject); 
				return; 
			case Aadl2Package.PRIVATE_PACKAGE_SECTION:
				sequence_PrivatePackageSection(context, (PrivatePackageSection) semanticObject); 
				return; 
			case Aadl2Package.PROCESS_IMPLEMENTATION:
				sequence_ProcessImplementation(context, (ProcessImplementation) semanticObject); 
				return; 
			case Aadl2Package.PROCESS_PROTOTYPE:
				sequence_ProcessPrototype(context, (ProcessPrototype) semanticObject); 
				return; 
			case Aadl2Package.PROCESS_SUBCOMPONENT:
				sequence_ProcessSubcomponent(context, (ProcessSubcomponent) semanticObject); 
				return; 
			case Aadl2Package.PROCESS_TYPE:
				sequence_ProcessType(context, (ProcessType) semanticObject); 
				return; 
			case Aadl2Package.PROCESSOR_IMPLEMENTATION:
				sequence_ProcessorImplementation(context, (ProcessorImplementation) semanticObject); 
				return; 
			case Aadl2Package.PROCESSOR_PROTOTYPE:
				sequence_ProcessorPrototype(context, (ProcessorPrototype) semanticObject); 
				return; 
			case Aadl2Package.PROCESSOR_SUBCOMPONENT:
				sequence_ProcessorSubcomponent(context, (ProcessorSubcomponent) semanticObject); 
				return; 
			case Aadl2Package.PROCESSOR_TYPE:
				sequence_ProcessorType(context, (ProcessorType) semanticObject); 
				return; 
			case Aadl2Package.PROPERTY:
				sequence_PropertyDefinition(context, (Property) semanticObject); 
				return; 
			case Aadl2Package.PROPERTY_ASSOCIATION:
				if (rule == grammarAccess.getBasicPropertyAssociationRule()) {
					sequence_BasicPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPModelRule()
						|| rule == grammarAccess.getContainedPropertyAssociationRule()) {
					sequence_ContainedPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyAssociationRule()) {
					sequence_PropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.PROPERTY_CONSTANT:
				sequence_PropertyConstant(context, (PropertyConstant) semanticObject); 
				return; 
			case Aadl2Package.PROPERTY_SET:
				sequence_PropertySet(context, (PropertySet) semanticObject); 
				return; 
			case Aadl2Package.PUBLIC_PACKAGE_SECTION:
				sequence_PublicPackageSection(context, (PublicPackageSection) semanticObject); 
				return; 
			case Aadl2Package.RANGE_TYPE:
				if (rule == grammarAccess.getPropertyTypeRule()
						|| rule == grammarAccess.getRangeTypeRule()) {
					sequence_RangeType(context, (RangeType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnnamedPropertyTypeRule()
						|| rule == grammarAccess.getUnnamedRangeTypeRule()) {
					sequence_UnnamedRangeType(context, (RangeType) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.RANGE_VALUE:
				sequence_NumericRangeTerm(context, (RangeValue) semanticObject); 
				return; 
			case Aadl2Package.REAL_LITERAL:
				if (rule == grammarAccess.getNumberValueRule()
						|| rule == grammarAccess.getRealLitRule()) {
					sequence_RealLit(context, (RealLiteral) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getConstantPropertyExpressionRule()
						|| rule == grammarAccess.getPropertyExpressionRule()
						|| rule == grammarAccess.getRealTermRule()
						|| rule == grammarAccess.getNumAltRule()) {
					sequence_RealTerm(context, (RealLiteral) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.REALIZATION:
				sequence_Realization(context, (Realization) semanticObject); 
				return; 
			case Aadl2Package.RECORD_TYPE:
				if (rule == grammarAccess.getPropertyTypeRule()
						|| rule == grammarAccess.getRecordTypeRule()) {
					sequence_RecordType(context, (RecordType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnnamedPropertyTypeRule()
						|| rule == grammarAccess.getUnnamedRecordTypeRule()) {
					sequence_UnnamedRecordType(context, (RecordType) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.RECORD_VALUE:
				if (rule == grammarAccess.getOldRecordTermRule()) {
					sequence_OldRecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getConstantPropertyExpressionRule()
						|| rule == grammarAccess.getPropertyExpressionRule()
						|| rule == grammarAccess.getRecordTermRule()) {
					sequence_RecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.REFERENCE_TYPE:
				if (rule == grammarAccess.getPropertyTypeRule()
						|| rule == grammarAccess.getReferenceTypeRule()) {
					sequence_ReferenceType(context, (ReferenceType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnnamedPropertyTypeRule()
						|| rule == grammarAccess.getUnnamedReferenceTypeRule()) {
					sequence_UnnamedReferenceType(context, (ReferenceType) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.REFERENCE_VALUE:
				sequence_ReferenceTerm(context, (ReferenceValue) semanticObject); 
				return; 
			case Aadl2Package.STRING_LITERAL:
				sequence_StringTerm(context, (StringLiteral) semanticObject); 
				return; 
			case Aadl2Package.SUBPROGRAM_ACCESS:
				sequence_SubprogramAccess(context, (SubprogramAccess) semanticObject); 
				return; 
			case Aadl2Package.SUBPROGRAM_CALL:
				sequence_SubprogramCall(context, (SubprogramCall) semanticObject); 
				return; 
			case Aadl2Package.SUBPROGRAM_CALL_SEQUENCE:
				sequence_SubprogramCallSequence(context, (SubprogramCallSequence) semanticObject); 
				return; 
			case Aadl2Package.SUBPROGRAM_GROUP_ACCESS:
				sequence_SubprogramGroupAccess(context, (SubprogramGroupAccess) semanticObject); 
				return; 
			case Aadl2Package.SUBPROGRAM_GROUP_IMPLEMENTATION:
				sequence_SubprogramGroupImplementation(context, (SubprogramGroupImplementation) semanticObject); 
				return; 
			case Aadl2Package.SUBPROGRAM_GROUP_PROTOTYPE:
				sequence_SubprogramGroupPrototype(context, (SubprogramGroupPrototype) semanticObject); 
				return; 
			case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT:
				sequence_SubprogramGroupSubcomponent(context, (SubprogramGroupSubcomponent) semanticObject); 
				return; 
			case Aadl2Package.SUBPROGRAM_GROUP_TYPE:
				sequence_SubprogramGroupType(context, (SubprogramGroupType) semanticObject); 
				return; 
			case Aadl2Package.SUBPROGRAM_IMPLEMENTATION:
				sequence_SubprogramImplementation(context, (SubprogramImplementation) semanticObject); 
				return; 
			case Aadl2Package.SUBPROGRAM_PROTOTYPE:
				sequence_SubprogramPrototype(context, (SubprogramPrototype) semanticObject); 
				return; 
			case Aadl2Package.SUBPROGRAM_PROXY:
				sequence_SubprogramProxy(context, (SubprogramProxy) semanticObject); 
				return; 
			case Aadl2Package.SUBPROGRAM_SUBCOMPONENT:
				sequence_SubprogramSubcomponent(context, (SubprogramSubcomponent) semanticObject); 
				return; 
			case Aadl2Package.SUBPROGRAM_TYPE:
				sequence_SubprogramType(context, (SubprogramType) semanticObject); 
				return; 
			case Aadl2Package.SYSTEM_IMPLEMENTATION:
				sequence_SystemImplementation(context, (SystemImplementation) semanticObject); 
				return; 
			case Aadl2Package.SYSTEM_PROTOTYPE:
				sequence_SystemPrototype(context, (SystemPrototype) semanticObject); 
				return; 
			case Aadl2Package.SYSTEM_SUBCOMPONENT:
				sequence_SystemSubcomponent(context, (SystemSubcomponent) semanticObject); 
				return; 
			case Aadl2Package.SYSTEM_TYPE:
				sequence_SystemType(context, (SystemType) semanticObject); 
				return; 
			case Aadl2Package.THREAD_GROUP_IMPLEMENTATION:
				sequence_ThreadGroupImplementation(context, (ThreadGroupImplementation) semanticObject); 
				return; 
			case Aadl2Package.THREAD_GROUP_PROTOTYPE:
				sequence_ThreadGroupPrototype(context, (ThreadGroupPrototype) semanticObject); 
				return; 
			case Aadl2Package.THREAD_GROUP_SUBCOMPONENT:
				sequence_ThreadGroupSubcomponent(context, (ThreadGroupSubcomponent) semanticObject); 
				return; 
			case Aadl2Package.THREAD_GROUP_TYPE:
				sequence_ThreadGroupType(context, (ThreadGroupType) semanticObject); 
				return; 
			case Aadl2Package.THREAD_IMPLEMENTATION:
				sequence_ThreadImplementation(context, (ThreadImplementation) semanticObject); 
				return; 
			case Aadl2Package.THREAD_PROTOTYPE:
				sequence_ThreadPrototype(context, (ThreadPrototype) semanticObject); 
				return; 
			case Aadl2Package.THREAD_SUBCOMPONENT:
				sequence_ThreadSubcomponent(context, (ThreadSubcomponent) semanticObject); 
				return; 
			case Aadl2Package.THREAD_TYPE:
				sequence_ThreadType(context, (ThreadType) semanticObject); 
				return; 
			case Aadl2Package.TYPE_EXTENSION:
				sequence_TypeExtension(context, (TypeExtension) semanticObject); 
				return; 
			case Aadl2Package.UNIT_LITERAL:
				if (rule == grammarAccess.getUnitLiteralConversionRule()) {
					sequence_UnitLiteralConversion(context, (UnitLiteral) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnitLiteralRule()) {
					sequence_UnitLiteral(context, (UnitLiteral) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.UNITS_TYPE:
				if (rule == grammarAccess.getPropertyTypeRule()
						|| rule == grammarAccess.getUnitsTypeRule()) {
					sequence_UnitsType(context, (UnitsType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnnamedPropertyTypeRule()
						|| rule == grammarAccess.getUnnamedUnitsTypeRule()) {
					sequence_UnnamedUnitsType(context, (UnitsType) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.VIRTUAL_BUS_IMPLEMENTATION:
				sequence_VirtualBusImplementation(context, (VirtualBusImplementation) semanticObject); 
				return; 
			case Aadl2Package.VIRTUAL_BUS_PROTOTYPE:
				sequence_VirtualBusPrototype(context, (VirtualBusPrototype) semanticObject); 
				return; 
			case Aadl2Package.VIRTUAL_BUS_SUBCOMPONENT:
				sequence_VirtualBusSubcomponent(context, (VirtualBusSubcomponent) semanticObject); 
				return; 
			case Aadl2Package.VIRTUAL_BUS_TYPE:
				sequence_VirtualBusType(context, (VirtualBusType) semanticObject); 
				return; 
			case Aadl2Package.VIRTUAL_PROCESSOR_IMPLEMENTATION:
				sequence_VirtualProcessorImplementation(context, (VirtualProcessorImplementation) semanticObject); 
				return; 
			case Aadl2Package.VIRTUAL_PROCESSOR_PROTOTYPE:
				sequence_VirtualProcessorPrototype(context, (VirtualProcessorPrototype) semanticObject); 
				return; 
			case Aadl2Package.VIRTUAL_PROCESSOR_SUBCOMPONENT:
				sequence_VirtualProcessorSubcomponent(context, (VirtualProcessorSubcomponent) semanticObject); 
				return; 
			case Aadl2Package.VIRTUAL_PROCESSOR_TYPE:
				sequence_VirtualProcessorType(context, (VirtualProcessorType) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Model returns AadlPackage
	 *     AadlPackage returns AadlPackage
	 *
	 * Constraint:
	 *     (
	 *         name=PNAME 
	 *         ((ownedPublicSection=PublicPackageSection ownedPrivateSection=PrivatePackageSection?) | ownedPrivateSection=PrivatePackageSection) 
	 *         ownedPropertyAssociation+=BasicPropertyAssociation*
	 *     )
	 */
	protected void sequence_AadlPackage(ISerializationContext context, AadlPackage semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AbstractFeature returns AbstractFeature
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[AbstractFeature|REFINEDNAME]) 
	 *         (in?='in' | out?='out')? 
	 *         (featurePrototype=[FeaturePrototype|QCREF] | abstractFeatureClassifier=[AbstractFeatureClassifier|QCREF])? 
	 *         arrayDimension+=ArrayDimension? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_AbstractFeature(ISerializationContext context, AbstractFeature semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns AbstractImplementation
	 *     ComponentImplementation returns AbstractImplementation
	 *     AbstractImplementation returns AbstractImplementation
	 *
	 * Constraint:
	 *     (
	 *         ownedRealization=Realization 
	 *         name=INAME 
	 *         ownedExtension=ImplementationExtension? 
	 *         (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)? 
	 *         (ownedPrototype+=Prototype+ | noPrototypes?='none')? 
	 *         (
	 *             (
	 *                 ownedVirtualBusSubcomponent+=VirtualBusSubcomponent? 
	 *                 (
	 *                     (
	 *                         ownedSystemSubcomponent+=SystemSubcomponent | 
	 *                         ownedSubprogramSubcomponent+=SubprogramSubcomponent | 
	 *                         ownedSubprogramGroupSubcomponent+=SubprogramGroupSubcomponent | 
	 *                         ownedThreadSubcomponent+=ThreadSubcomponent | 
	 *                         ownedThreadGroupSubcomponent+=ThreadGroupSubcomponent | 
	 *                         ownedProcessSubcomponent+=ProcessSubcomponent | 
	 *                         ownedProcessorSubcomponent+=ProcessorSubcomponent | 
	 *                         ownedVirtualProcessorSubcomponent+=VirtualProcessorSubcomponent | 
	 *                         ownedMemorySubcomponent+=MemorySubcomponent | 
	 *                         ownedDeviceSubcomponent+=DeviceSubcomponent | 
	 *                         ownedBusSubcomponent+=BusSubcomponent | 
	 *                         ownedDataSubcomponent+=DataSubcomponent | 
	 *                         ownedAbstractSubcomponent+=AbstractSubcomponent
	 *                     )? 
	 *                     ownedVirtualBusSubcomponent+=VirtualBusSubcomponent?
	 *                 )*
	 *             ) | 
	 *             noSubcomponents?='none'
	 *         )? 
	 *         ownedEventDataSource+=EventDataSource? 
	 *         (ownedEventSource+=EventSource? ownedEventDataSource+=EventDataSource?)* 
	 *         ownedPortProxy+=PortProxy? 
	 *         (ownedSubprogramProxy+=SubprogramProxy? ownedPortProxy+=PortProxy?)* 
	 *         (ownedSubprogramCallSequence+=SubprogramCallSequence+ | noCalls?='none')? 
	 *         (
	 *             (
	 *                 ownedParameterConnection+=ParameterConnection? 
	 *                 (
	 *                     (
	 *                         ownedPortConnection+=PortConnection | 
	 *                         ownedAccessConnection+=AccessConnection | 
	 *                         ownedFeatureGroupConnection+=FeatureGroupConnection | 
	 *                         ownedFeatureConnection+=FeatureConnection
	 *                     )? 
	 *                     ownedParameterConnection+=ParameterConnection?
	 *                 )*
	 *             ) | 
	 *             noConnections?='none'
	 *         )? 
	 *         ((ownedFlowImplementation+=FlowImplementation | ownedEndToEndFlow+=EndToEndFlow)+ | noFlows?='none')? 
	 *         ((ownedMode+=Mode? (ownedModeTransition+=ModeTransition? ownedMode+=Mode?)*) | noModes?='none')? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_AbstractImplementation(ISerializationContext context, AbstractImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Prototype returns AbstractPrototype
	 *     ComponentPrototype returns AbstractPrototype
	 *     AbstractPrototype returns AbstractPrototype
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[ComponentPrototype|REFINEDNAME]) 
	 *         constrainingClassifier=[ComponentClassifier|QCREF]? 
	 *         array?='['? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_AbstractPrototype(ISerializationContext context, AbstractPrototype semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AbstractSubcomponent returns AbstractSubcomponent
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[AbstractSubcomponent|REFINEDNAME]) 
	 *         (abstractSubcomponentType=[AbstractSubcomponentType|QCREF] (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (
	 *             arrayDimension+=ArrayDimension+ 
	 *             (implementationReference+=ComponentImplementationReference implementationReference+=ComponentImplementationReference*)?
	 *         )? 
	 *         ownedPropertyAssociation+=ContainedPropertyAssociation* 
	 *         (ownedModeBinding+=ModeRef ownedModeBinding+=ModeRef*)?
	 *     )
	 */
	protected void sequence_AbstractSubcomponent(ISerializationContext context, AbstractSubcomponent semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns AbstractType
	 *     ComponentType returns AbstractType
	 *     AbstractType returns AbstractType
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (ownedExtension=TypeExtension (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (noPrototypes?='none' | ownedPrototype+=Prototype+)? 
	 *         (
	 *             noFeatures?='none' | 
	 *             (
	 *                 ownedSubprogramAccess+=SubprogramAccess? 
	 *                 (
	 *                     (
	 *                         ownedDataPort+=DataPort | 
	 *                         ownedEventPort+=EventPort | 
	 *                         ownedEventDataPort+=EventDataPort | 
	 *                         ownedFeatureGroup+=FeatureGroup | 
	 *                         ownedDataAccess+=DataAccess | 
	 *                         ownedBusAccess+=BusAccess | 
	 *                         ownedSubprogramGroupAccess+=SubprogramGroupAccess | 
	 *                         ownedAbstractFeature+=AbstractFeature
	 *                     )? 
	 *                     ownedSubprogramAccess+=SubprogramAccess?
	 *                 )*
	 *             )
	 *         )? 
	 *         (ownedFlowSpecification+=FlowSpecification+ | noFlows?='none')? 
	 *         ((derivedModes?=RequiresModesKeywords ownedMode+=Mode+) | (ownedMode+=Mode | ownedModeTransition+=ModeTransition)+ | noModes?='none')? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_AbstractType(ISerializationContext context, AbstractType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AccessConnection returns AccessConnection
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             (name=ID accessCategory=AccessCategory source=AccessConnectionEnd bidirectional?='<->'? destination=AccessConnectionEnd) | 
	 *             (refined=[AccessConnection|REFINEDNAME] accessCategory=AccessCategory)
	 *         ) 
	 *         ownedPropertyAssociation+=PropertyAssociation* 
	 *         (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *     )
	 */
	protected void sequence_AccessConnection(ISerializationContext context, AccessConnection semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AccessSpecification returns AccessSpecification
	 *
	 * Constraint:
	 *     (kind=AccessDirection category=AccessCategory classifier=[ComponentClassifier|QCREF]?)
	 */
	protected void sequence_AccessSpecification(ISerializationContext context, AccessSpecification semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AllReference returns MetaclassReference
	 *
	 * Constraint:
	 *     metaclassName+='all'
	 */
	protected void sequence_AllReference(ISerializationContext context, MetaclassReference semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ArrayDimension returns ArrayDimension
	 *
	 * Constraint:
	 *     size=ArraySize?
	 */
	protected void sequence_ArrayDimension(ISerializationContext context, ArrayDimension semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ArraySize returns ArraySize
	 *
	 * Constraint:
	 *     (size=INTVALUE | sizeProperty=[ArraySizeProperty|QPREF])
	 */
	protected void sequence_ArraySize(ISerializationContext context, ArraySize semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyType returns AadlBoolean
	 *     BooleanType returns AadlBoolean
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_BooleanType(ISerializationContext context, AadlBoolean semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getBooleanTypeAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     BusAccess returns BusAccess
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Feature|REFINEDNAME]) 
	 *         kind=AccessDirection 
	 *         virtual?='virtual'? 
	 *         busFeatureClassifier=[BusSubcomponentType|QCREF]? 
	 *         arrayDimension+=ArrayDimension? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_BusAccess(ISerializationContext context, BusAccess semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns BusImplementation
	 *     ComponentImplementation returns BusImplementation
	 *     BusImplementation returns BusImplementation
	 *
	 * Constraint:
	 *     (
	 *         ownedRealization=Realization 
	 *         name=INAME 
	 *         ownedExtension=ImplementationExtension? 
	 *         (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)? 
	 *         (ownedPrototype+=Prototype+ | noPrototypes?='none')? 
	 *         (
	 *             (
	 *                 ownedVirtualBusSubcomponent+=VirtualBusSubcomponent? 
	 *                 (ownedAbstractSubcomponent+=AbstractSubcomponent? ownedVirtualBusSubcomponent+=VirtualBusSubcomponent?)*
	 *             ) | 
	 *             noSubcomponents?='none'
	 *         )? 
	 *         ownedEventSource+=EventSource? 
	 *         (ownedEventDataSource+=EventDataSource? ownedEventSource+=EventSource?)* 
	 *         ((ownedMode+=Mode | ownedModeTransition+=ModeTransition)+ | noModes?='none')? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_BusImplementation(ISerializationContext context, BusImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Prototype returns BusPrototype
	 *     ComponentPrototype returns BusPrototype
	 *     BusPrototype returns BusPrototype
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[ComponentPrototype|REFINEDNAME]) 
	 *         constrainingClassifier=[ComponentClassifier|QCREF]? 
	 *         array?='['? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_BusPrototype(ISerializationContext context, BusPrototype semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     BusSubcomponent returns BusSubcomponent
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Subcomponent|REFINEDNAME]) 
	 *         (busSubcomponentType=[BusSubcomponentType|QCREF] (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (
	 *             arrayDimension+=ArrayDimension+ 
	 *             (implementationReference+=ComponentImplementationReference implementationReference+=ComponentImplementationReference*)?
	 *         )? 
	 *         ownedPropertyAssociation+=ContainedPropertyAssociation* 
	 *         (ownedModeBinding+=ModeRef ownedModeBinding+=ModeRef*)?
	 *     )
	 */
	protected void sequence_BusSubcomponent(ISerializationContext context, BusSubcomponent semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns BusType
	 *     ComponentType returns BusType
	 *     BusType returns BusType
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (ownedExtension=TypeExtension (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (noPrototypes?='none' | ownedPrototype+=Prototype+)? 
	 *         (
	 *             noFeatures?='none' | 
	 *             (
	 *                 ownedEventDataPort+=EventDataPort? 
	 *                 (
	 *                     (
	 *                         ownedFeatureGroup+=FeatureGroup | 
	 *                         ownedBusAccess+=BusAccess | 
	 *                         ownedDataPort+=DataPort | 
	 *                         ownedEventPort+=EventPort | 
	 *                         ownedAbstractFeature+=AbstractFeature
	 *                     )? 
	 *                     ownedEventDataPort+=EventDataPort?
	 *                 )*
	 *             )
	 *         )? 
	 *         ((derivedModes?=RequiresModesKeywords ownedMode+=Mode+) | (ownedMode+=Mode | ownedModeTransition+=ModeTransition)+ | noModes?='none')? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_BusType(ISerializationContext context, BusType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     CTRename returns ComponentTypeRename
	 *
	 * Constraint:
	 *     (name=ID? category=ComponentCategory renamedComponentType=[ComponentType|QCREF])
	 */
	protected void sequence_CTRename(ISerializationContext context, ComponentTypeRename semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyType returns ClassifierType
	 *     ClassifierType returns ClassifierType
	 *
	 * Constraint:
	 *     (name=ID (classifierReference+=QMReference classifierReference+=QMReference*)?)
	 */
	protected void sequence_ClassifierType(ISerializationContext context, ClassifierType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ComponentImplementationReference returns ComponentImplementationReference
	 *
	 * Constraint:
	 *     (implementation=[ComponentImplementation|QCREF] (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)
	 */
	protected void sequence_ComponentImplementationReference(ISerializationContext context, ComponentImplementationReference semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrototypeBinding returns ComponentPrototypeBinding
	 *     ComponentPrototypeBinding returns ComponentPrototypeBinding
	 *
	 * Constraint:
	 *     (formal=[Prototype|ID] (actual+=ComponentReference | (actual+=ComponentReference actual+=ComponentReference*)))
	 */
	protected void sequence_ComponentPrototypeBinding(ISerializationContext context, ComponentPrototypeBinding semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ComponentReference returns ComponentPrototypeActual
	 *
	 * Constraint:
	 *     (category=ComponentCategory subcomponentType=[SubcomponentType|QCREF] (binding+=PrototypeBinding binding+=PrototypeBinding*)?)
	 */
	protected void sequence_ComponentReference(ISerializationContext context, ComponentPrototypeActual semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ConnectedElementChain returns ConnectedElement
	 *
	 * Constraint:
	 *     (connectionEnd=[ConnectionEnd|ID] next=ConnectedElementChain?)
	 */
	protected void sequence_ConnectedElementChain(ISerializationContext context, ConnectedElement semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ConnectedElement returns ConnectedElement
	 *
	 * Constraint:
	 *     (context=[Context|ID]? connectionEnd=[ConnectionEnd|ID])
	 */
	protected void sequence_ConnectedElement(ISerializationContext context, ConnectedElement semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AbstractConnectionEnd returns ConnectedElement
	 *
	 * Constraint:
	 *     ((context=[Context|ID]? connectionEnd=[ConnectionEnd|ID]) | connectionEnd=[PortProxy|ID] | connectionEnd=[InternalFeature|ID])
	 */
	protected void sequence_ConnectedElement_InternalEvent_ProcessorPort(ISerializationContext context, ConnectedElement semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NestedConnectedElement returns ConnectedElement
	 *
	 * Constraint:
	 *     ((context=[Context|ID] connectionEnd=[ConnectionEnd|ID] next=ConnectedElementChain) | (context=[Context|ID]? connectionEnd=[ConnectionEnd|ID]))
	 */
	protected void sequence_ConnectedElement_NestedConnectedElement(ISerializationContext context, ConnectedElement semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ProcessorConnectionEnd returns ConnectedElement
	 *
	 * Constraint:
	 *     ((context=[Context|ID]? connectionEnd=[ConnectionEnd|ID]) | connectionEnd=[PortProxy|ID])
	 */
	protected void sequence_ConnectedElement_ProcessorPort(ISerializationContext context, ConnectedElement semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AccessConnectionEnd returns ConnectedElement
	 *
	 * Constraint:
	 *     ((context=[Context|ID]? connectionEnd=[ConnectionEnd|ID]) | connectionEnd=[SubprogramProxy|ID])
	 */
	protected void sequence_ConnectedElement_ProcessorSubprogram(ISerializationContext context, ConnectedElement semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ConnectionFlow returns FlowSegment
	 *
	 * Constraint:
	 *     flowElement=[Connection|ID]
	 */
	protected void sequence_ConnectionFlow(ISerializationContext context, FlowSegment semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getFlowSegment_FlowElement()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getFlowSegment_FlowElement()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getConnectionFlowAccess().getFlowElementConnectionIDTerminalRuleCall_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getFlowSegment_FlowElement(), false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DataAccess returns DataAccess
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Feature|REFINEDNAME]) 
	 *         kind=AccessDirection 
	 *         dataFeatureClassifier=[DataSubcomponentType|QCREF]? 
	 *         arrayDimension+=ArrayDimension? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_DataAccess(ISerializationContext context, DataAccess semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns DataImplementation
	 *     ComponentImplementation returns DataImplementation
	 *     DataImplementation returns DataImplementation
	 *
	 * Constraint:
	 *     (
	 *         ownedRealization=Realization 
	 *         name=INAME 
	 *         ownedExtension=ImplementationExtension? 
	 *         (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)? 
	 *         (ownedPrototype+=Prototype+ | noPrototypes?='none')? 
	 *         (
	 *             (ownedAbstractSubcomponent+=AbstractSubcomponent | ownedDataSubcomponent+=DataSubcomponent | ownedSubprogramSubcomponent+=SubprogramSubcomponent)+ | 
	 *             noSubcomponents?='none'
	 *         )? 
	 *         (ownedEventSource+=EventSource? ownedEventDataSource+=EventDataSource?)* 
	 *         (
	 *             (
	 *                 (
	 *                     (ownedEventSource+=EventSource? noConnections?='none'? ownedEndToEndFlow+=EndToEndFlow?) | 
	 *                     (
	 *                         ownedEventSource+=EventSource? 
	 *                         (ownedFeatureConnection+=FeatureConnection? (ownedAccessConnection+=AccessConnection | ownedFeatureGroupConnection+=FeatureGroupConnection)?)* 
	 *                         ownedFeatureConnection+=FeatureConnection? 
	 *                         ownedEndToEndFlow+=EndToEndFlow?
	 *                     )
	 *                 ) 
	 *                 (ownedFlowImplementation+=FlowImplementation? ownedEndToEndFlow+=EndToEndFlow?)* 
	 *                 ((ownedModeTransition+=ModeTransition? (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*) | noModes?='none')?
	 *             ) | 
	 *             (
	 *                 ownedEventSource+=EventSource? 
	 *                 noConnections?='none'? 
	 *                 noFlows?='none'? 
	 *                 ((ownedModeTransition+=ModeTransition? (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*) | noModes?='none')
	 *             ) | 
	 *             (
	 *                 ownedEventSource+=EventSource? 
	 *                 (ownedFeatureConnection+=FeatureConnection? (ownedAccessConnection+=AccessConnection | ownedFeatureGroupConnection+=FeatureGroupConnection)?)* 
	 *                 (
	 *                     (
	 *                         ownedFeatureConnection+=FeatureConnection? 
	 *                         noFlows?='none'? 
	 *                         ownedModeTransition+=ModeTransition? 
	 *                         (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*
	 *                     ) | 
	 *                     (ownedFeatureConnection+=FeatureConnection? noFlows?='none'? noModes?='none')
	 *                 )
	 *             )
	 *         ) 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_DataImplementation(ISerializationContext context, DataImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataPort returns DataPort
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Feature|REFINEDNAME]) 
	 *         ((in?='in' out?='out'?) | out?='out') 
	 *         dataFeatureClassifier=[DataSubcomponentType|QCREF]? 
	 *         arrayDimension+=ArrayDimension? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_DataPort(ISerializationContext context, DataPort semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Prototype returns DataPrototype
	 *     ComponentPrototype returns DataPrototype
	 *     DataPrototype returns DataPrototype
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[ComponentPrototype|REFINEDNAME]) 
	 *         constrainingClassifier=[ComponentClassifier|QCREF]? 
	 *         array?='['? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_DataPrototype(ISerializationContext context, DataPrototype semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataSubcomponent returns DataSubcomponent
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Subcomponent|REFINEDNAME]) 
	 *         (dataSubcomponentType=[DataSubcomponentType|QCREF] (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (
	 *             arrayDimension+=ArrayDimension+ 
	 *             (implementationReference+=ComponentImplementationReference implementationReference+=ComponentImplementationReference*)?
	 *         )? 
	 *         ownedPropertyAssociation+=ContainedPropertyAssociation* 
	 *         (ownedModeBinding+=ModeRef ownedModeBinding+=ModeRef*)?
	 *     )
	 */
	protected void sequence_DataSubcomponent(ISerializationContext context, DataSubcomponent semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns DataType
	 *     ComponentType returns DataType
	 *     DataType returns DataType
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (ownedExtension=TypeExtension (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (noPrototypes?='none' | ownedPrototype+=Prototype+)? 
	 *         (
	 *             noFeatures?='none' | 
	 *             (
	 *                 ownedSubprogramAccess+=SubprogramAccess? 
	 *                 (
	 *                     (
	 *                         ownedFeatureGroup+=FeatureGroup | 
	 *                         ownedDataAccess+=DataAccess | 
	 *                         ownedSubprogramGroupAccess+=SubprogramGroupAccess | 
	 *                         ownedAbstractFeature+=AbstractFeature
	 *                     )? 
	 *                     ownedSubprogramAccess+=SubprogramAccess?
	 *                 )*
	 *             )
	 *         )? 
	 *         (ownedFlowSpecification+=FlowSpecification+ | noFlows?='none')? 
	 *         ((derivedModes?=RequiresModesKeywords ownedMode+=Mode+) | (ownedMode+=Mode | ownedModeTransition+=ModeTransition)+ | noModes?='none')? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_DataType(ISerializationContext context, DataType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AnnexLibrary returns DefaultAnnexLibrary
	 *     DefaultAnnexLibrary returns DefaultAnnexLibrary
	 *
	 * Constraint:
	 *     (name=ID sourceText=ANNEXTEXT)
	 */
	protected void sequence_DefaultAnnexLibrary(ISerializationContext context, DefaultAnnexLibrary semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()));
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getDefaultAnnexLibrary_SourceText()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getDefaultAnnexLibrary_SourceText()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getDefaultAnnexLibraryAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getDefaultAnnexLibraryAccess().getSourceTextANNEXTEXTTerminalRuleCall_2_0(), semanticObject.getSourceText());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AnnexSubclause returns DefaultAnnexSubclause
	 *     DefaultAnnexSubclause returns DefaultAnnexSubclause
	 *
	 * Constraint:
	 *     (name=ID sourceText=ANNEXTEXT (inMode+=[Mode|ID] inMode+=[Mode|ID]*)?)
	 */
	protected void sequence_DefaultAnnexSubclause(ISerializationContext context, DefaultAnnexSubclause semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns DeviceImplementation
	 *     ComponentImplementation returns DeviceImplementation
	 *     DeviceImplementation returns DeviceImplementation
	 *
	 * Constraint:
	 *     (
	 *         ownedRealization=Realization 
	 *         name=INAME 
	 *         ownedExtension=ImplementationExtension? 
	 *         (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)? 
	 *         (ownedPrototype+=Prototype+ | noPrototypes?='none')? 
	 *         (
	 *             (
	 *                 ownedAbstractSubcomponent+=AbstractSubcomponent? 
	 *                 (
	 *                     (ownedDataSubcomponent+=DataSubcomponent | ownedVirtualBusSubcomponent+=VirtualBusSubcomponent | ownedBusSubcomponent+=BusSubcomponent)? 
	 *                     ownedAbstractSubcomponent+=AbstractSubcomponent?
	 *                 )*
	 *             ) | 
	 *             noSubcomponents?='none'
	 *         )? 
	 *         ownedEventDataSource+=EventDataSource? 
	 *         (ownedEventSource+=EventSource? ownedEventDataSource+=EventDataSource?)* 
	 *         ownedSubprogramProxy+=SubprogramProxy? 
	 *         (ownedPortProxy+=PortProxy? ownedSubprogramProxy+=SubprogramProxy?)* 
	 *         (
	 *             (
	 *                 ownedPortConnection+=PortConnection | 
	 *                 ownedAccessConnection+=AccessConnection | 
	 *                 ownedFeatureGroupConnection+=FeatureGroupConnection | 
	 *                 ownedFeatureConnection+=FeatureConnection
	 *             )+ | 
	 *             noConnections?='none'
	 *         )? 
	 *         (
	 *             (
	 *                 (ownedEndToEndFlow+=EndToEndFlow? ownedFlowImplementation+=FlowImplementation?)* 
	 *                 (
	 *                     (ownedEndToEndFlow+=EndToEndFlow? noModes?='none'?) | 
	 *                     (ownedEndToEndFlow+=EndToEndFlow? ownedModeTransition+=ModeTransition? (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*)
	 *                 )
	 *             ) | 
	 *             (noFlows?='none'? ownedModeTransition+=ModeTransition? (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*) | 
	 *             (noFlows?='none'? noModes?='none'?)
	 *         ) 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_DeviceImplementation(ISerializationContext context, DeviceImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Prototype returns DevicePrototype
	 *     ComponentPrototype returns DevicePrototype
	 *     DevicePrototype returns DevicePrototype
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[ComponentPrototype|REFINEDNAME]) 
	 *         constrainingClassifier=[ComponentClassifier|QCREF]? 
	 *         array?='['? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_DevicePrototype(ISerializationContext context, DevicePrototype semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DeviceSubcomponent returns DeviceSubcomponent
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Subcomponent|REFINEDNAME]) 
	 *         (deviceSubcomponentType=[DeviceSubcomponentType|QCREF] (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (
	 *             arrayDimension+=ArrayDimension+ 
	 *             (implementationReference+=ComponentImplementationReference implementationReference+=ComponentImplementationReference*)?
	 *         )? 
	 *         ownedPropertyAssociation+=ContainedPropertyAssociation* 
	 *         (ownedModeBinding+=ModeRef ownedModeBinding+=ModeRef*)?
	 *     )
	 */
	protected void sequence_DeviceSubcomponent(ISerializationContext context, DeviceSubcomponent semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns DeviceType
	 *     ComponentType returns DeviceType
	 *     DeviceType returns DeviceType
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (ownedExtension=TypeExtension (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (noPrototypes?='none' | ownedPrototype+=Prototype+)? 
	 *         (
	 *             noFeatures?='none' | 
	 *             (
	 *                 ownedEventPort+=EventPort? 
	 *                 (
	 *                     (
	 *                         ownedDataPort+=DataPort | 
	 *                         ownedEventDataPort+=EventDataPort | 
	 *                         ownedFeatureGroup+=FeatureGroup | 
	 *                         ownedBusAccess+=BusAccess | 
	 *                         ownedSubprogramAccess+=SubprogramAccess | 
	 *                         ownedSubprogramGroupAccess+=SubprogramGroupAccess | 
	 *                         ownedAbstractFeature+=AbstractFeature
	 *                     )? 
	 *                     ownedEventPort+=EventPort?
	 *                 )*
	 *             )
	 *         )? 
	 *         (ownedFlowSpecification+=FlowSpecification+ | noFlows?='none')? 
	 *         ((derivedModes?=RequiresModesKeywords ownedMode+=Mode+) | (ownedMode+=Mode | ownedModeTransition+=ModeTransition)+ | noModes?='none')? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_DeviceType(ISerializationContext context, DeviceType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ETEConnectionFlow returns EndToEndFlowSegment
	 *
	 * Constraint:
	 *     flowElement=[Connection|ID]
	 */
	protected void sequence_ETEConnectionFlow(ISerializationContext context, EndToEndFlowSegment semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getEndToEndFlowSegment_FlowElement()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getEndToEndFlowSegment_FlowElement()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getETEConnectionFlowAccess().getFlowElementConnectionIDTerminalRuleCall_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getEndToEndFlowSegment_FlowElement(), false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ETESubcomponentFlow returns EndToEndFlowSegment
	 *
	 * Constraint:
	 *     (context=[Subcomponent|ID]? flowElement=[EndToEndFlowElement|ID])
	 */
	protected void sequence_ETESubcomponentFlow(ISerializationContext context, EndToEndFlowSegment semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EndToEndFlow returns EndToEndFlow
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             (
	 *                 name=ID 
	 *                 ownedEndToEndFlowSegment+=ETESubcomponentFlow 
	 *                 (ownedEndToEndFlowSegment+=ETEConnectionFlow ownedEndToEndFlowSegment+=ETESubcomponentFlow)+
	 *             ) | 
	 *             refined=[EndToEndFlow|REFINEDNAME]
	 *         ) 
	 *         ownedPropertyAssociation+=PropertyAssociation* 
	 *         (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *     )
	 */
	protected void sequence_EndToEndFlow(ISerializationContext context, EndToEndFlow semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EnumerationLiteral returns EnumerationLiteral
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_EnumerationLiteral(ISerializationContext context, EnumerationLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getEnumerationLiteralAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     PropertyType returns EnumerationType
	 *     EnumerationType returns EnumerationType
	 *
	 * Constraint:
	 *     (name=ID ownedLiteral+=EnumerationLiteral ownedLiteral+=EnumerationLiteral*)
	 */
	protected void sequence_EnumerationType(ISerializationContext context, EnumerationType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EventDataPort returns EventDataPort
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Feature|REFINEDNAME]) 
	 *         ((in?='in' out?='out'?) | out?='out') 
	 *         dataFeatureClassifier=[DataSubcomponentType|QCREF]? 
	 *         arrayDimension+=ArrayDimension? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_EventDataPort(ISerializationContext context, EventDataPort semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EventDataSource returns EventDataSource
	 *
	 * Constraint:
	 *     (name=ID dataClassifier=[DataClassifier|QCREF]? ownedPropertyAssociation+=PropertyAssociation*)
	 */
	protected void sequence_EventDataSource(ISerializationContext context, EventDataSource semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EventPort returns EventPort
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Feature|REFINEDNAME]) 
	 *         ((in?='in' out?='out'?) | out?='out') 
	 *         arrayDimension+=ArrayDimension? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_EventPort(ISerializationContext context, EventPort semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EventSource returns EventSource
	 *
	 * Constraint:
	 *     (name=ID ownedPropertyAssociation+=PropertyAssociation*)
	 */
	protected void sequence_EventSource(ISerializationContext context, EventSource semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FGTRename returns FeatureGroupTypeRename
	 *
	 * Constraint:
	 *     (name=ID? renamedFeatureGroupType=[FeatureGroupType|QCREF])
	 */
	protected void sequence_FGTRename(ISerializationContext context, FeatureGroupTypeRename semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FeatureConnection returns FeatureConnection
	 *
	 * Constraint:
	 *     (
	 *         ((name=ID source=NestedConnectedElement bidirectional?='<->'? destination=NestedConnectedElement) | refined=[FeatureConnection|REFINEDNAME]) 
	 *         ownedPropertyAssociation+=PropertyAssociation* 
	 *         (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *     )
	 */
	protected void sequence_FeatureConnection(ISerializationContext context, FeatureConnection semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FeatureGroupConnection returns FeatureGroupConnection
	 *
	 * Constraint:
	 *     (
	 *         ((name=ID source=NestedConnectedElement bidirectional?='<->'? destination=NestedConnectedElement) | refined=[FeatureGroupConnection|REFINEDNAME]) 
	 *         ownedPropertyAssociation+=PropertyAssociation* 
	 *         (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *     )
	 */
	protected void sequence_FeatureGroupConnection(ISerializationContext context, FeatureGroupConnection semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FeatureGroupPrototypeActual returns FeatureGroupPrototypeActual
	 *
	 * Constraint:
	 *     (featureType=[FeatureType|QCREF] (binding+=PrototypeBinding binding+=PrototypeBinding*)?)
	 */
	protected void sequence_FeatureGroupPrototypeActual(ISerializationContext context, FeatureGroupPrototypeActual semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrototypeBinding returns FeatureGroupPrototypeBinding
	 *     FeatureGroupPrototypeBinding returns FeatureGroupPrototypeBinding
	 *
	 * Constraint:
	 *     (formal=[Prototype|ID] actual=FeatureGroupPrototypeActual)
	 */
	protected void sequence_FeatureGroupPrototypeBinding(ISerializationContext context, FeatureGroupPrototypeBinding semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getPrototypeBinding_Formal()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getPrototypeBinding_Formal()));
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getFeatureGroupPrototypeBinding_Actual()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getFeatureGroupPrototypeBinding_Actual()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getFeatureGroupPrototypeBindingAccess().getFormalPrototypeIDTerminalRuleCall_0_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getPrototypeBinding_Formal(), false));
		feeder.accept(grammarAccess.getFeatureGroupPrototypeBindingAccess().getActualFeatureGroupPrototypeActualParserRuleCall_3_0(), semanticObject.getActual());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Prototype returns FeatureGroupPrototype
	 *     FeatureGroupPrototype returns FeatureGroupPrototype
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[FeatureGroupPrototype|REFINEDNAME]) 
	 *         constrainingFeatureGroupType=[FeatureGroupType|QCREF]? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_FeatureGroupPrototype(ISerializationContext context, FeatureGroupPrototype semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns FeatureGroupType
	 *     FeatureGroupType returns FeatureGroupType
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (ownedExtension=GroupExtension (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (noPrototypes?='none' | ownedPrototype+=Prototype+)? 
	 *         (
	 *             ownedDataPort+=DataPort | 
	 *             ownedEventPort+=EventPort | 
	 *             ownedEventDataPort+=EventDataPort | 
	 *             ownedFeatureGroup+=FeatureGroup | 
	 *             ownedDataAccess+=DataAccess | 
	 *             ownedBusAccess+=BusAccess | 
	 *             ownedSubprogramAccess+=SubprogramAccess | 
	 *             ownedSubprogramGroupAccess+=SubprogramGroupAccess | 
	 *             ownedAbstractFeature+=AbstractFeature | 
	 *             ownedParameter+=Parameter
	 *         )* 
	 *         inverse=[FeatureGroupType|QCREF]? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_FeatureGroupType(ISerializationContext context, FeatureGroupType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FeatureGroup returns FeatureGroup
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Feature|REFINEDNAME]) 
	 *         (in?='in' | out?='out')? 
	 *         (inverse?=InverseOfKeywords? featureType=[FeatureType|QCREF])? 
	 *         arrayDimension+=ArrayDimension? 
	 *         ownedPropertyAssociation+=ContainedPropertyAssociation*
	 *     )
	 */
	protected void sequence_FeatureGroup(ISerializationContext context, FeatureGroup semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrototypeBinding returns FeaturePrototypeBinding
	 *     FeaturePrototypeBinding returns FeaturePrototypeBinding
	 *
	 * Constraint:
	 *     (formal=[Prototype|ID] (actual=PortSpecification | actual=AccessSpecification | actual=FeaturePrototypeReference))
	 */
	protected void sequence_FeaturePrototypeBinding(ISerializationContext context, FeaturePrototypeBinding semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FeaturePrototypeReference returns FeaturePrototypeReference
	 *
	 * Constraint:
	 *     ((in?='in' | out?='out')? prototype=[FeaturePrototype|ID])
	 */
	protected void sequence_FeaturePrototypeReference(ISerializationContext context, FeaturePrototypeReference semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Prototype returns FeaturePrototype
	 *     FeaturePrototype returns FeaturePrototype
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[FeaturePrototype|REFINEDNAME]) 
	 *         (in?='in' | out?='out')? 
	 *         constrainingClassifier=[ComponentClassifier|QCREF]? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_FeaturePrototype(ISerializationContext context, FeaturePrototype semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FlowEnd returns FlowEnd
	 *
	 * Constraint:
	 *     (context=[Context|ID]? feature=[Feature|ID])
	 */
	protected void sequence_FlowEnd(ISerializationContext context, FlowEnd semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FlowPathImpl returns FlowImplementation
	 *
	 * Constraint:
	 *     (
	 *         specification=[FlowSpecification|ID] 
	 *         kind=FlowPath 
	 *         inEnd=FlowEnd 
	 *         ((ownedFlowSegment+=ConnectionFlow ownedFlowSegment+=SubcomponentFlow)* ownedFlowSegment+=ConnectionFlow)? 
	 *         outEnd=FlowEnd 
	 *         ownedPropertyAssociation+=PropertyAssociation* 
	 *         (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *     )
	 */
	protected void sequence_FlowPathImpl(ISerializationContext context, FlowImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FlowImplementation returns FlowImplementation
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             specification=[FlowSpecification|ID] 
	 *             kind=FlowSource 
	 *             (ownedFlowSegment+=SubcomponentFlow ownedFlowSegment+=ConnectionFlow)* 
	 *             outEnd=FlowEnd 
	 *             ownedPropertyAssociation+=PropertyAssociation* 
	 *             (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *         ) | 
	 *         (
	 *             specification=[FlowSpecification|ID] 
	 *             kind=FlowSink 
	 *             inEnd=FlowEnd 
	 *             (ownedFlowSegment+=ConnectionFlow ownedFlowSegment+=SubcomponentFlow)* 
	 *             ownedPropertyAssociation+=PropertyAssociation* 
	 *             (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *         ) | 
	 *         (
	 *             specification=[FlowSpecification|ID] 
	 *             kind=FlowPath 
	 *             inEnd=FlowEnd 
	 *             ((ownedFlowSegment+=ConnectionFlow ownedFlowSegment+=SubcomponentFlow)* ownedFlowSegment+=ConnectionFlow)? 
	 *             outEnd=FlowEnd 
	 *             ownedPropertyAssociation+=PropertyAssociation* 
	 *             (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *         )
	 *     )
	 */
	protected void sequence_FlowPathImpl_FlowSinkImpl_FlowSourceImpl(ISerializationContext context, FlowImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FlowSpecification returns FlowSpecification
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             name=ID 
	 *             kind=FlowSource 
	 *             outEnd=FlowEnd 
	 *             ownedPropertyAssociation+=PropertyAssociation* 
	 *             (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *         ) | 
	 *         (
	 *             name=ID 
	 *             kind=FlowSink 
	 *             InEnd=FlowEnd 
	 *             ownedPropertyAssociation+=PropertyAssociation* 
	 *             (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *         ) | 
	 *         (
	 *             name=ID 
	 *             kind=FlowPath 
	 *             InEnd=FlowEnd 
	 *             outEnd=FlowEnd 
	 *             ownedPropertyAssociation+=PropertyAssociation* 
	 *             (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *         ) | 
	 *         (
	 *             refined=[FlowSpecification|REFINEDNAME] 
	 *             kind=FlowKind 
	 *             ownedPropertyAssociation+=PropertyAssociation* 
	 *             (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *         )
	 *     )
	 */
	protected void sequence_FlowPathSpec_FlowSinkSpec_FlowSourceSpec_FlowSpecRefinement(ISerializationContext context, FlowSpecification semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FlowPathSpec returns FlowSpecification
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         kind=FlowPath 
	 *         InEnd=FlowEnd 
	 *         outEnd=FlowEnd 
	 *         ownedPropertyAssociation+=PropertyAssociation* 
	 *         (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *     )
	 */
	protected void sequence_FlowPathSpec(ISerializationContext context, FlowSpecification semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FlowSinkImpl returns FlowImplementation
	 *
	 * Constraint:
	 *     (
	 *         specification=[FlowSpecification|ID] 
	 *         kind=FlowSink 
	 *         inEnd=FlowEnd 
	 *         (ownedFlowSegment+=ConnectionFlow ownedFlowSegment+=SubcomponentFlow)* 
	 *         ownedPropertyAssociation+=PropertyAssociation* 
	 *         (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *     )
	 */
	protected void sequence_FlowSinkImpl(ISerializationContext context, FlowImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FlowSinkSpec returns FlowSpecification
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         kind=FlowSink 
	 *         InEnd=FlowEnd 
	 *         ownedPropertyAssociation+=PropertyAssociation* 
	 *         (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *     )
	 */
	protected void sequence_FlowSinkSpec(ISerializationContext context, FlowSpecification semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FlowSourceImpl returns FlowImplementation
	 *
	 * Constraint:
	 *     (
	 *         specification=[FlowSpecification|ID] 
	 *         kind=FlowSource 
	 *         (ownedFlowSegment+=SubcomponentFlow ownedFlowSegment+=ConnectionFlow)* 
	 *         outEnd=FlowEnd 
	 *         ownedPropertyAssociation+=PropertyAssociation* 
	 *         (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *     )
	 */
	protected void sequence_FlowSourceImpl(ISerializationContext context, FlowImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FlowSourceSpec returns FlowSpecification
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         kind=FlowSource 
	 *         outEnd=FlowEnd 
	 *         ownedPropertyAssociation+=PropertyAssociation* 
	 *         (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *     )
	 */
	protected void sequence_FlowSourceSpec(ISerializationContext context, FlowSpecification semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FlowSpecRefinement returns FlowSpecification
	 *
	 * Constraint:
	 *     (
	 *         refined=[FlowSpecification|REFINEDNAME] 
	 *         kind=FlowKind 
	 *         ownedPropertyAssociation+=PropertyAssociation* 
	 *         (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *     )
	 */
	protected void sequence_FlowSpecRefinement(ISerializationContext context, FlowSpecification semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     GroupExtension returns GroupExtension
	 *
	 * Constraint:
	 *     extended=[FeatureGroupType|QCREF]
	 */
	protected void sequence_GroupExtension(ISerializationContext context, GroupExtension semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getGroupExtension_Extended()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getGroupExtension_Extended()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getGroupExtensionAccess().getExtendedFeatureGroupTypeQCREFParserRuleCall_1_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getGroupExtension_Extended(), false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ImplementationExtension returns ImplementationExtension
	 *
	 * Constraint:
	 *     extended=[ComponentImplementation|QCREF]
	 */
	protected void sequence_ImplementationExtension(ISerializationContext context, ImplementationExtension semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getImplementationExtension_Extended()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getImplementationExtension_Extended()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getImplementationExtensionAccess().getExtendedComponentImplementationQCREFParserRuleCall_1_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getImplementationExtension_Extended(), false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     NumberValue returns IntegerLiteral
	 *     IntegerLit returns IntegerLiteral
	 *
	 * Constraint:
	 *     value=SignedInt
	 */
	protected void sequence_IntegerLit(ISerializationContext context, IntegerLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getIntegerLiteral_Value()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getIntegerLiteral_Value()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getIntegerLitAccess().getValueSignedIntParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     IntegerRange returns NumericRange
	 *
	 * Constraint:
	 *     (
	 *         (lowerBound=IntegerTerm | lowerBound=SignedConstant | lowerBound=ConstantValue) 
	 *         (upperBound=IntegerTerm | upperBound=SignedConstant | upperBound=ConstantValue)
	 *     )
	 */
	protected void sequence_IntegerRange(ISerializationContext context, NumericRange semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyType returns AadlInteger
	 *     IntegerType returns AadlInteger
	 *
	 * Constraint:
	 *     (name=ID range=IntegerRange? (ownedUnitsType=UnnamedUnitsType | referencedUnitsType=[UnitsType|QPREF])?)
	 */
	protected void sequence_IntegerType(ISerializationContext context, AadlInteger semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     InternalEvent returns ConnectedElement
	 *
	 * Constraint:
	 *     connectionEnd=[InternalFeature|ID]
	 */
	protected void sequence_InternalEvent(ISerializationContext context, ConnectedElement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getInternalEventAccess().getConnectionEndInternalFeatureIDTerminalRuleCall_2_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd(), false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     UnnamedPropertyType returns ListType
	 *     ListType returns ListType
	 *
	 * Constraint:
	 *     (referencedElementType=[PropertyType|QPREF] | ownedElementType=UnnamedPropertyType)
	 */
	protected void sequence_ListType(ISerializationContext context, ListType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns MemoryImplementation
	 *     ComponentImplementation returns MemoryImplementation
	 *     MemoryImplementation returns MemoryImplementation
	 *
	 * Constraint:
	 *     (
	 *         ownedRealization=Realization 
	 *         name=INAME 
	 *         ownedExtension=ImplementationExtension? 
	 *         (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)? 
	 *         (ownedPrototype+=Prototype+ | noPrototypes?='none')? 
	 *         (
	 *             (
	 *                 ownedMemorySubcomponent+=MemorySubcomponent? 
	 *                 ((ownedAbstractSubcomponent+=AbstractSubcomponent | ownedBusSubcomponent+=BusSubcomponent)? ownedMemorySubcomponent+=MemorySubcomponent?)*
	 *             ) | 
	 *             noSubcomponents?='none'
	 *         )? 
	 *         (ownedEventSource+=EventSource | ownedEventDataSource+=EventDataSource)* 
	 *         (
	 *             (
	 *                 (ownedFeatureConnection+=FeatureConnection? (ownedAccessConnection+=AccessConnection | ownedFeatureGroupConnection+=FeatureGroupConnection)?)* 
	 *                 (
	 *                     (ownedFeatureConnection+=FeatureConnection? noModes?='none'?) | 
	 *                     (ownedFeatureConnection+=FeatureConnection? ownedModeTransition+=ModeTransition? (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*)
	 *                 )
	 *             ) | 
	 *             (noConnections?='none'? ownedModeTransition+=ModeTransition? (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*) | 
	 *             (noConnections?='none'? noModes?='none'?)
	 *         ) 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_MemoryImplementation(ISerializationContext context, MemoryImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Prototype returns MemoryPrototype
	 *     ComponentPrototype returns MemoryPrototype
	 *     MemoryPrototype returns MemoryPrototype
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[ComponentPrototype|REFINEDNAME]) 
	 *         constrainingClassifier=[ComponentClassifier|QCREF]? 
	 *         array?='['? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_MemoryPrototype(ISerializationContext context, MemoryPrototype semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MemorySubcomponent returns MemorySubcomponent
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Subcomponent|REFINEDNAME]) 
	 *         (memorySubcomponentType=[MemorySubcomponentType|QCREF] (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (
	 *             arrayDimension+=ArrayDimension+ 
	 *             (implementationReference+=ComponentImplementationReference implementationReference+=ComponentImplementationReference*)?
	 *         )? 
	 *         ownedPropertyAssociation+=ContainedPropertyAssociation* 
	 *         (ownedModeBinding+=ModeRef ownedModeBinding+=ModeRef*)?
	 *     )
	 */
	protected void sequence_MemorySubcomponent(ISerializationContext context, MemorySubcomponent semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns MemoryType
	 *     ComponentType returns MemoryType
	 *     MemoryType returns MemoryType
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (ownedExtension=TypeExtension (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (noPrototypes?='none' | ownedPrototype+=Prototype+)? 
	 *         (
	 *             noFeatures?='none' | 
	 *             (
	 *                 ownedEventPort+=EventPort? 
	 *                 (
	 *                     (
	 *                         ownedFeatureGroup+=FeatureGroup | 
	 *                         ownedBusAccess+=BusAccess | 
	 *                         ownedDataPort+=DataPort | 
	 *                         ownedEventDataPort+=EventDataPort | 
	 *                         ownedAbstractFeature+=AbstractFeature
	 *                     )? 
	 *                     ownedEventPort+=EventPort?
	 *                 )*
	 *             )
	 *         )? 
	 *         ((derivedModes?=RequiresModesKeywords ownedMode+=Mode+) | (ownedMode+=Mode | ownedModeTransition+=ModeTransition)+ | noModes?='none')? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_MemoryType(ISerializationContext context, MemoryType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ModeRef returns ModeBinding
	 *
	 * Constraint:
	 *     (parentMode=[Mode|ID] derivedMode=[Mode|ID]?)
	 */
	protected void sequence_ModeRef(ISerializationContext context, ModeBinding semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ModeTransition returns ModeTransition
	 *
	 * Constraint:
	 *     (
	 *         name=ID? 
	 *         source=[Mode|ID] 
	 *         ownedTrigger+=Trigger 
	 *         ownedTrigger+=Trigger* 
	 *         destination=[Mode|ID] 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_ModeTransition(ISerializationContext context, ModeTransition semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Mode returns Mode
	 *
	 * Constraint:
	 *     (name=ID initial?='initial'? ownedPropertyAssociation+=PropertyAssociation*)
	 */
	protected void sequence_Mode(ISerializationContext context, Mode semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PackageRename returns PackageRename
	 *
	 * Constraint:
	 *     (name=ID renamedPackage=[AadlPackage|PNAME] renameAll?='all'?)
	 */
	protected void sequence_PackageRename(ISerializationContext context, PackageRename semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ParameterConnection returns ParameterConnection
	 *
	 * Constraint:
	 *     (
	 *         ((name=ID source=ConnectedElement destination=ConnectedElement) | refined=[ParameterConnection|REFINEDNAME]) 
	 *         ownedPropertyAssociation+=PropertyAssociation* 
	 *         (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *     )
	 */
	protected void sequence_ParameterConnection(ISerializationContext context, ParameterConnection semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Parameter returns Parameter
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Feature|REFINEDNAME]) 
	 *         ((in?='in' out?='out'?) | out?='out') 
	 *         dataFeatureClassifier=[DataSubcomponentType|QCREF]? 
	 *         arrayDimension+=ArrayDimension? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_Parameter(ISerializationContext context, org.osate.aadl2.Parameter semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PortConnection returns PortConnection
	 *
	 * Constraint:
	 *     (
	 *         ((name=ID source=AbstractConnectionEnd bidirectional?='<->'? destination=AbstractConnectionEnd) | refined=[PortConnection|REFINEDNAME]) 
	 *         ownedPropertyAssociation+=PropertyAssociation* 
	 *         (inModeOrTransition+=[ModeFeature|ID] inModeOrTransition+=[ModeFeature|ID]*)?
	 *     )
	 */
	protected void sequence_PortConnection(ISerializationContext context, PortConnection semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PortProxy returns PortProxy
	 *
	 * Constraint:
	 *     (name=ID dataClassifier=[DataClassifier|QCREF]? ownedPropertyAssociation+=PropertyAssociation*)
	 */
	protected void sequence_PortProxy(ISerializationContext context, PortProxy semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PortSpecification returns PortSpecification
	 *
	 * Constraint:
	 *     (((in?='in' out?='out'?) | out?='out') category=PortCategory classifier=[ComponentClassifier|QCREF]?)
	 */
	protected void sequence_PortSpecification(ISerializationContext context, PortSpecification semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PrivatePackageSection returns PrivatePackageSection
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             (ownedPackageRename+=PackageRename | ownedPackageRename+=RenameAll | ownedFeatureGroupTypeRename+=FGTRename | ownedComponentTypeRename+=CTRename)? 
	 *             (importedUnit+=[ModelUnit|PNAME] importedUnit+=[ModelUnit|PNAME]*)?
	 *         )+ 
	 *         ownedClassifier+=Classifier? 
	 *         (ownedAnnexLibrary+=AnnexLibrary? ownedClassifier+=Classifier?)*
	 *     )
	 */
	protected void sequence_PrivatePackageSection(ISerializationContext context, PrivatePackageSection semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns ProcessImplementation
	 *     ComponentImplementation returns ProcessImplementation
	 *     ProcessImplementation returns ProcessImplementation
	 *
	 * Constraint:
	 *     (
	 *         ownedRealization=Realization 
	 *         name=INAME 
	 *         ownedExtension=ImplementationExtension? 
	 *         (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)? 
	 *         (ownedPrototype+=Prototype+ | noPrototypes?='none')? 
	 *         (
	 *             (
	 *                 ownedAbstractSubcomponent+=AbstractSubcomponent? 
	 *                 (
	 *                     (
	 *                         ownedThreadGroupSubcomponent+=ThreadGroupSubcomponent | 
	 *                         ownedThreadSubcomponent+=ThreadSubcomponent | 
	 *                         ownedSubprogramSubcomponent+=SubprogramSubcomponent | 
	 *                         ownedSubprogramGroupSubcomponent+=SubprogramGroupSubcomponent | 
	 *                         ownedDataSubcomponent+=DataSubcomponent
	 *                     )? 
	 *                     ownedAbstractSubcomponent+=AbstractSubcomponent?
	 *                 )*
	 *             ) | 
	 *             noSubcomponents?='none'
	 *         )? 
	 *         (ownedEventSource+=EventSource | ownedEventDataSource+=EventDataSource)* 
	 *         (ownedPortProxy+=PortProxy? ownedSubprogramProxy+=SubprogramProxy?)* 
	 *         (
	 *             (
	 *                 (
	 *                     (ownedPortProxy+=PortProxy? noConnections?='none'? ownedFlowImplementation+=FlowImplementation?) | 
	 *                     (
	 *                         ownedPortProxy+=PortProxy? 
	 *                         (
	 *                             ownedFeatureConnection+=FeatureConnection? 
	 *                             (ownedPortConnection+=PortConnection | ownedAccessConnection+=AccessConnection | ownedFeatureGroupConnection+=FeatureGroupConnection)?
	 *                         )* 
	 *                         ownedFeatureConnection+=FeatureConnection? 
	 *                         ownedFlowImplementation+=FlowImplementation?
	 *                     )
	 *                 ) 
	 *                 (ownedEndToEndFlow+=EndToEndFlow? ownedFlowImplementation+=FlowImplementation?)* 
	 *                 ((ownedModeTransition+=ModeTransition? (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*) | noModes?='none')?
	 *             ) | 
	 *             (
	 *                 ownedPortProxy+=PortProxy? 
	 *                 noConnections?='none'? 
	 *                 noFlows?='none'? 
	 *                 ((ownedModeTransition+=ModeTransition? (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*) | noModes?='none')
	 *             ) | 
	 *             (
	 *                 ownedPortProxy+=PortProxy? 
	 *                 (
	 *                     ownedFeatureConnection+=FeatureConnection? 
	 *                     (ownedPortConnection+=PortConnection | ownedAccessConnection+=AccessConnection | ownedFeatureGroupConnection+=FeatureGroupConnection)?
	 *                 )* 
	 *                 (
	 *                     (
	 *                         ownedFeatureConnection+=FeatureConnection? 
	 *                         noFlows?='none'? 
	 *                         ownedModeTransition+=ModeTransition? 
	 *                         (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*
	 *                     ) | 
	 *                     (ownedFeatureConnection+=FeatureConnection? noFlows?='none'? noModes?='none')
	 *                 )
	 *             )
	 *         ) 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_ProcessImplementation(ISerializationContext context, ProcessImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Prototype returns ProcessPrototype
	 *     ComponentPrototype returns ProcessPrototype
	 *     ProcessPrototype returns ProcessPrototype
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[ComponentPrototype|REFINEDNAME]) 
	 *         constrainingClassifier=[ComponentClassifier|QCREF]? 
	 *         array?='['? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_ProcessPrototype(ISerializationContext context, ProcessPrototype semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ProcessSubcomponent returns ProcessSubcomponent
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Subcomponent|REFINEDNAME]) 
	 *         (processSubcomponentType=[ProcessSubcomponentType|QCREF] (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (
	 *             arrayDimension+=ArrayDimension+ 
	 *             (implementationReference+=ComponentImplementationReference implementationReference+=ComponentImplementationReference*)?
	 *         )? 
	 *         ownedPropertyAssociation+=ContainedPropertyAssociation* 
	 *         (ownedModeBinding+=ModeRef ownedModeBinding+=ModeRef*)?
	 *     )
	 */
	protected void sequence_ProcessSubcomponent(ISerializationContext context, ProcessSubcomponent semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns ProcessType
	 *     ComponentType returns ProcessType
	 *     ProcessType returns ProcessType
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (ownedExtension=TypeExtension (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (noPrototypes?='none' | ownedPrototype+=Prototype+)? 
	 *         (
	 *             noFeatures?='none' | 
	 *             (
	 *                 ownedEventPort+=EventPort? 
	 *                 (
	 *                     (
	 *                         ownedDataPort+=DataPort | 
	 *                         ownedEventDataPort+=EventDataPort | 
	 *                         ownedFeatureGroup+=FeatureGroup | 
	 *                         ownedDataAccess+=DataAccess | 
	 *                         ownedSubprogramAccess+=SubprogramAccess | 
	 *                         ownedSubprogramGroupAccess+=SubprogramGroupAccess | 
	 *                         ownedAbstractFeature+=AbstractFeature
	 *                     )? 
	 *                     ownedEventPort+=EventPort?
	 *                 )*
	 *             )
	 *         )? 
	 *         (ownedFlowSpecification+=FlowSpecification+ | noFlows?='none')? 
	 *         ((derivedModes?=RequiresModesKeywords ownedMode+=Mode+) | (ownedMode+=Mode | ownedModeTransition+=ModeTransition)+ | noModes?='none')? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_ProcessType(ISerializationContext context, ProcessType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns ProcessorImplementation
	 *     ComponentImplementation returns ProcessorImplementation
	 *     ProcessorImplementation returns ProcessorImplementation
	 *
	 * Constraint:
	 *     (
	 *         ownedRealization=Realization 
	 *         name=INAME 
	 *         ownedExtension=ImplementationExtension? 
	 *         (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)? 
	 *         (ownedPrototype+=Prototype+ | noPrototypes?='none')? 
	 *         (
	 *             (
	 *                 ownedVirtualBusSubcomponent+=VirtualBusSubcomponent? 
	 *                 (
	 *                     (
	 *                         ownedMemorySubcomponent+=MemorySubcomponent | 
	 *                         ownedAbstractSubcomponent+=AbstractSubcomponent | 
	 *                         ownedBusSubcomponent+=BusSubcomponent | 
	 *                         ownedVirtualProcessorSubcomponent+=VirtualProcessorSubcomponent
	 *                     )? 
	 *                     ownedVirtualBusSubcomponent+=VirtualBusSubcomponent?
	 *                 )*
	 *             ) | 
	 *             noSubcomponents?='none'
	 *         )? 
	 *         (ownedEventSource+=EventSource | ownedEventDataSource+=EventDataSource)* 
	 *         (
	 *             (
	 *                 (
	 *                     (
	 *                         (
	 *                             ownedPortConnection+=PortConnection? 
	 *                             (ownedAccessConnection+=AccessConnection | ownedFeatureGroupConnection+=FeatureGroupConnection | ownedFeatureConnection+=FeatureConnection)?
	 *                         )* 
	 *                         ownedPortConnection+=PortConnection? 
	 *                         ownedEndToEndFlow+=EndToEndFlow?
	 *                     ) | 
	 *                     (noConnections?='none'? ownedEndToEndFlow+=EndToEndFlow?)
	 *                 ) 
	 *                 (ownedFlowImplementation+=FlowImplementation? ownedEndToEndFlow+=EndToEndFlow?)* 
	 *                 ((ownedMode+=Mode? (ownedModeTransition+=ModeTransition? ownedMode+=Mode?)*) | noModes?='none')?
	 *             ) | 
	 *             (
	 *                 (
	 *                     ownedPortConnection+=PortConnection? 
	 *                     (ownedAccessConnection+=AccessConnection | ownedFeatureGroupConnection+=FeatureGroupConnection | ownedFeatureConnection+=FeatureConnection)?
	 *                 )* 
	 *                 (
	 *                     (ownedPortConnection+=PortConnection? noFlows?='none'? ownedMode+=Mode? (ownedModeTransition+=ModeTransition? ownedMode+=Mode?)*) | 
	 *                     (ownedPortConnection+=PortConnection? noFlows?='none'? noModes?='none')
	 *                 )
	 *             ) | 
	 *             (noConnections?='none'? noFlows?='none'? noModes?='none') | 
	 *             (noConnections?='none'? noFlows?='none'? ownedMode+=Mode? (ownedModeTransition+=ModeTransition? ownedMode+=Mode?)*)
	 *         ) 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_ProcessorImplementation(ISerializationContext context, ProcessorImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ProcessorPort returns ConnectedElement
	 *
	 * Constraint:
	 *     connectionEnd=[PortProxy|ID]
	 */
	protected void sequence_ProcessorPort(ISerializationContext context, ConnectedElement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getProcessorPortAccess().getConnectionEndPortProxyIDTerminalRuleCall_2_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd(), false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Prototype returns ProcessorPrototype
	 *     ComponentPrototype returns ProcessorPrototype
	 *     ProcessorPrototype returns ProcessorPrototype
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[ComponentPrototype|REFINEDNAME]) 
	 *         constrainingClassifier=[ComponentClassifier|QCREF]? 
	 *         array?='['? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_ProcessorPrototype(ISerializationContext context, ProcessorPrototype semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ProcessorSubcomponent returns ProcessorSubcomponent
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Subcomponent|REFINEDNAME]) 
	 *         (
	 *             processorSubcomponentType=[ProcessorSubcomponentType|QCREF] 
	 *             (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?
	 *         )? 
	 *         (
	 *             arrayDimension+=ArrayDimension+ 
	 *             (implementationReference+=ComponentImplementationReference implementationReference+=ComponentImplementationReference*)?
	 *         )? 
	 *         ownedPropertyAssociation+=ContainedPropertyAssociation* 
	 *         (ownedModeBinding+=ModeRef ownedModeBinding+=ModeRef*)?
	 *     )
	 */
	protected void sequence_ProcessorSubcomponent(ISerializationContext context, ProcessorSubcomponent semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ProcessorSubprogram returns ConnectedElement
	 *
	 * Constraint:
	 *     connectionEnd=[SubprogramProxy|ID]
	 */
	protected void sequence_ProcessorSubprogram(ISerializationContext context, ConnectedElement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getProcessorSubprogramAccess().getConnectionEndSubprogramProxyIDTerminalRuleCall_2_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getConnectedElement_ConnectionEnd(), false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns ProcessorType
	 *     ComponentType returns ProcessorType
	 *     ProcessorType returns ProcessorType
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (ownedExtension=TypeExtension (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (noPrototypes?='none' | ownedPrototype+=Prototype+)? 
	 *         (
	 *             noFeatures?='none' | 
	 *             (
	 *                 ownedEventDataPort+=EventDataPort? 
	 *                 (
	 *                     (
	 *                         ownedDataPort+=DataPort | 
	 *                         ownedEventPort+=EventPort | 
	 *                         ownedFeatureGroup+=FeatureGroup | 
	 *                         ownedBusAccess+=BusAccess | 
	 *                         ownedSubprogramAccess+=SubprogramAccess | 
	 *                         ownedSubprogramGroupAccess+=SubprogramGroupAccess | 
	 *                         ownedAbstractFeature+=AbstractFeature
	 *                     )? 
	 *                     ownedEventDataPort+=EventDataPort?
	 *                 )*
	 *             )
	 *         )? 
	 *         (ownedFlowSpecification+=FlowSpecification+ | noFlows?='none')? 
	 *         ((derivedModes?=RequiresModesKeywords ownedMode+=Mode+) | (ownedMode+=Mode | ownedModeTransition+=ModeTransition)+ | noModes?='none')? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_ProcessorType(ISerializationContext context, ProcessorType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyConstant returns PropertyConstant
	 *
	 * Constraint:
	 *     (name=ID (referencedPropertyType=[PropertyType|QPREF] | ownedPropertyType=UnnamedPropertyType) constantValue=ConstantPropertyExpression)
	 */
	protected void sequence_PropertyConstant(ISerializationContext context, PropertyConstant semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyDefinition returns Property
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         inherit?='inherit'? 
	 *         (referencedPropertyType=[PropertyType|QPREF] | ownedPropertyType=UnnamedPropertyType) 
	 *         defaultValue=PropertyExpression? 
	 *         ((appliesTo+=PropertyOwner appliesTo+=PropertyOwner*) | appliesTo+=AllReference)
	 *     )
	 */
	protected void sequence_PropertyDefinition(ISerializationContext context, Property semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns PropertySet
	 *     PropertySet returns PropertySet
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (importedUnit+=[PropertySet|ID] importedUnit+=[PropertySet|ID]*)* 
	 *         (ownedPropertyType+=PropertyType | ownedProperty+=PropertyDefinition | ownedPropertyConstant+=PropertyConstant)* 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_PropertySet(ISerializationContext context, PropertySet semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PublicPackageSection returns PublicPackageSection
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             (ownedPackageRename+=PackageRename | ownedPackageRename+=RenameAll | ownedFeatureGroupTypeRename+=FGTRename | ownedComponentTypeRename+=CTRename)? 
	 *             (importedUnit+=[ModelUnit|PNAME] importedUnit+=[ModelUnit|PNAME]*)?
	 *         )+ 
	 *         ownedClassifier+=Classifier? 
	 *         (ownedAnnexLibrary+=AnnexLibrary? ownedClassifier+=Classifier?)*
	 *     )
	 */
	protected void sequence_PublicPackageSection(ISerializationContext context, PublicPackageSection semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     QCReference returns ClassifierValue
	 *     PropertyOwner returns ClassifierValue
	 *
	 * Constraint:
	 *     classifier=[ComponentClassifier|FQCREF]
	 */
	protected void sequence_QCReference(ISerializationContext context, ClassifierValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getClassifierValue_Classifier()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getClassifierValue_Classifier()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getQCReferenceAccess().getClassifierComponentClassifierFQCREFParserRuleCall_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getClassifierValue_Classifier(), false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     QMReference returns MetaclassReference
	 *     PropertyOwner returns MetaclassReference
	 *
	 * Constraint:
	 *     (annexName=ID? (metaclassName+=CoreKeyWord | metaclassName+=ID)+)
	 */
	protected void sequence_QMReference(ISerializationContext context, MetaclassReference semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyType returns RangeType
	 *     RangeType returns RangeType
	 *
	 * Constraint:
	 *     (name=ID (ownedNumberType=UnnamedIntegerType | ownedNumberType=UnnamedRealType | referencedNumberType=[NumberType|QPREF]))
	 */
	protected void sequence_RangeType(ISerializationContext context, RangeType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NumberValue returns RealLiteral
	 *     RealLit returns RealLiteral
	 *
	 * Constraint:
	 *     value=SignedReal
	 */
	protected void sequence_RealLit(ISerializationContext context, RealLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getRealLiteral_Value()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getRealLiteral_Value()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getRealLitAccess().getValueSignedRealParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     RealRange returns NumericRange
	 *
	 * Constraint:
	 *     (
	 *         (lowerBound=RealTerm | lowerBound=SignedConstant | lowerBound=ConstantValue) 
	 *         (upperBound=RealTerm | upperBound=SignedConstant | upperBound=ConstantValue)
	 *     )
	 */
	protected void sequence_RealRange(ISerializationContext context, NumericRange semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyType returns AadlReal
	 *     RealType returns AadlReal
	 *
	 * Constraint:
	 *     (name=ID range=RealRange? (ownedUnitsType=UnnamedUnitsType | referencedUnitsType=[UnitsType|QPREF])?)
	 */
	protected void sequence_RealType(ISerializationContext context, AadlReal semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Realization returns Realization
	 *
	 * Constraint:
	 *     implemented=[ComponentType|ID]
	 */
	protected void sequence_Realization(ISerializationContext context, Realization semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getRealization_Implemented()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getRealization_Implemented()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getRealizationAccess().getImplementedComponentTypeIDTerminalRuleCall_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getRealization_Implemented(), false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     RecordField returns BasicProperty
	 *
	 * Constraint:
	 *     (name=ID (referencedPropertyType=[PropertyType|QPREF] | ownedPropertyType=UnnamedPropertyType))
	 */
	protected void sequence_RecordField(ISerializationContext context, BasicProperty semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyType returns RecordType
	 *     RecordType returns RecordType
	 *
	 * Constraint:
	 *     (name=ID ownedField+=RecordField+)
	 */
	protected void sequence_RecordType(ISerializationContext context, RecordType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyType returns ReferenceType
	 *     ReferenceType returns ReferenceType
	 *
	 * Constraint:
	 *     (name=ID (namedElementReference+=QMReference namedElementReference+=QMReference*)?)
	 */
	protected void sequence_ReferenceType(ISerializationContext context, ReferenceType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RenameAll returns PackageRename
	 *
	 * Constraint:
	 *     (renamedPackage=[AadlPackage|PNAME] renameAll?='all')
	 */
	protected void sequence_RenameAll(ISerializationContext context, PackageRename semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getPackageRename_RenamedPackage()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getPackageRename_RenamedPackage()));
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getPackageRename_RenameAll()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getPackageRename_RenameAll()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getRenameAllAccess().getRenamedPackageAadlPackagePNAMEParserRuleCall_1_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getPackageRename_RenamedPackage(), false));
		feeder.accept(grammarAccess.getRenameAllAccess().getRenameAllAllKeyword_3_0(), semanticObject.isRenameAll());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     PropertyType returns AadlString
	 *     StringType returns AadlString
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_StringType(ISerializationContext context, AadlString semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getStringTypeAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SubcomponentFlow returns FlowSegment
	 *
	 * Constraint:
	 *     (context=[Subcomponent|ID]? flowElement=[FlowElement|ID])
	 */
	protected void sequence_SubcomponentFlow(ISerializationContext context, FlowSegment semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SubprogramAccess returns SubprogramAccess
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Feature|REFINEDNAME]) 
	 *         kind=AccessDirection 
	 *         subprogramFeatureClassifier=[SubprogramSubcomponentType|QCREF]? 
	 *         arrayDimension+=ArrayDimension? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_SubprogramAccess(ISerializationContext context, SubprogramAccess semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SubprogramCallSequence returns SubprogramCallSequence
	 *
	 * Constraint:
	 *     (name=ID ownedSubprogramCall+=SubprogramCall+ ownedPropertyAssociation+=PropertyAssociation* (inMode+=[Mode|ID] inMode+=[Mode|ID]*)?)
	 */
	protected void sequence_SubprogramCallSequence(ISerializationContext context, SubprogramCallSequence semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SubprogramCall returns SubprogramCall
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (
	 *             (context=[CallContext|PNAME] calledSubprogram=[CalledSubprogram|ID]) | 
	 *             calledSubprogram=[CalledSubprogram|PNAME] | 
	 *             calledSubprogram=[SubprogramProxy|ID]
	 *         ) 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_SubprogramCall(ISerializationContext context, SubprogramCall semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SubprogramGroupAccess returns SubprogramGroupAccess
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Feature|REFINEDNAME]) 
	 *         kind=AccessDirection 
	 *         subprogramGroupFeatureClassifier=[SubprogramGroupSubcomponentType|QCREF]? 
	 *         arrayDimension+=ArrayDimension? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_SubprogramGroupAccess(ISerializationContext context, SubprogramGroupAccess semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns SubprogramGroupImplementation
	 *     ComponentImplementation returns SubprogramGroupImplementation
	 *     SubprogramGroupImplementation returns SubprogramGroupImplementation
	 *
	 * Constraint:
	 *     (
	 *         ownedRealization=Realization 
	 *         name=INAME 
	 *         ownedExtension=ImplementationExtension? 
	 *         (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)? 
	 *         (ownedPrototype+=Prototype+ | noPrototypes?='none')? 
	 *         (
	 *             (
	 *                 ownedSubprogramSubcomponent+=SubprogramSubcomponent? 
	 *                 (
	 *                     (
	 *                         ownedAbstractSubcomponent+=AbstractSubcomponent | 
	 *                         ownedSubprogramGroupSubcomponent+=SubprogramGroupSubcomponent | 
	 *                         ownedDataSubcomponent+=DataSubcomponent
	 *                     )? 
	 *                     ownedSubprogramSubcomponent+=SubprogramSubcomponent?
	 *                 )*
	 *             ) | 
	 *             noSubcomponents?='none'
	 *         )? 
	 *         ownedEventDataSource+=EventDataSource? 
	 *         (ownedEventSource+=EventSource? ownedEventDataSource+=EventDataSource?)* 
	 *         ownedSubprogramProxy+=SubprogramProxy? 
	 *         (ownedPortProxy+=PortProxy? ownedSubprogramProxy+=SubprogramProxy?)* 
	 *         (
	 *             (ownedAccessConnection+=AccessConnection | ownedFeatureGroupConnection+=FeatureGroupConnection | ownedFeatureConnection+=FeatureConnection)+ | 
	 *             noConnections?='none'
	 *         )? 
	 *         ((ownedMode+=Mode? (ownedModeTransition+=ModeTransition? ownedMode+=Mode?)*) | noModes?='none')? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_SubprogramGroupImplementation(ISerializationContext context, SubprogramGroupImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Prototype returns SubprogramGroupPrototype
	 *     ComponentPrototype returns SubprogramGroupPrototype
	 *     SubprogramGroupPrototype returns SubprogramGroupPrototype
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[ComponentPrototype|REFINEDNAME]) 
	 *         constrainingClassifier=[ComponentClassifier|QCREF]? 
	 *         array?='['? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_SubprogramGroupPrototype(ISerializationContext context, SubprogramGroupPrototype semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SubprogramGroupSubcomponent returns SubprogramGroupSubcomponent
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Subcomponent|REFINEDNAME]) 
	 *         (
	 *             subprogramGroupSubcomponentType=[SubprogramGroupSubcomponentType|QCREF] 
	 *             (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?
	 *         )? 
	 *         (
	 *             arrayDimension+=ArrayDimension+ 
	 *             (implementationReference+=ComponentImplementationReference implementationReference+=ComponentImplementationReference*)?
	 *         )? 
	 *         ownedPropertyAssociation+=ContainedPropertyAssociation* 
	 *         (ownedModeBinding+=ModeRef ownedModeBinding+=ModeRef*)?
	 *     )
	 */
	protected void sequence_SubprogramGroupSubcomponent(ISerializationContext context, SubprogramGroupSubcomponent semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns SubprogramGroupType
	 *     ComponentType returns SubprogramGroupType
	 *     SubprogramGroupType returns SubprogramGroupType
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (ownedExtension=TypeExtension (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (noPrototypes?='none' | ownedPrototype+=Prototype+)? 
	 *         (
	 *             noFeatures?='none' | 
	 *             (
	 *                 ownedSubprogramAccess+=SubprogramAccess | 
	 *                 ownedFeatureGroup+=FeatureGroup | 
	 *                 ownedSubprogramGroupAccess+=SubprogramGroupAccess | 
	 *                 ownedAbstractFeature+=AbstractFeature
	 *             )+
	 *         )? 
	 *         (ownedFlowSpecification+=FlowSpecification+ | noFlows?='none')? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_SubprogramGroupType(ISerializationContext context, SubprogramGroupType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns SubprogramImplementation
	 *     ComponentImplementation returns SubprogramImplementation
	 *     SubprogramImplementation returns SubprogramImplementation
	 *
	 * Constraint:
	 *     (
	 *         ownedRealization=Realization 
	 *         name=INAME 
	 *         ownedExtension=ImplementationExtension? 
	 *         (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)? 
	 *         (ownedPrototype+=Prototype+ | noPrototypes?='none')? 
	 *         (
	 *             (
	 *                 ownedAbstractSubcomponent+=AbstractSubcomponent? 
	 *                 (
	 *                     (ownedSubprogramSubcomponent+=SubprogramSubcomponent | ownedDataSubcomponent+=DataSubcomponent)? 
	 *                     ownedAbstractSubcomponent+=AbstractSubcomponent?
	 *                 )*
	 *             ) | 
	 *             noSubcomponents?='none'
	 *         )? 
	 *         ownedEventDataSource+=EventDataSource? 
	 *         (ownedEventSource+=EventSource? ownedEventDataSource+=EventDataSource?)* 
	 *         (ownedPortProxy+=PortProxy | ownedSubprogramProxy+=SubprogramProxy)* 
	 *         (ownedSubprogramCallSequence+=SubprogramCallSequence+ | noCalls?='none')? 
	 *         (
	 *             (
	 *                 (
	 *                     (
	 *                         (
	 *                             ownedPortConnection+=PortConnection? 
	 *                             (
	 *                                 ownedAccessConnection+=AccessConnection | 
	 *                                 ownedFeatureGroupConnection+=FeatureGroupConnection | 
	 *                                 ownedFeatureConnection+=FeatureConnection | 
	 *                                 ownedParameterConnection+=ParameterConnection
	 *                             )?
	 *                         )* 
	 *                         ownedPortConnection+=PortConnection? 
	 *                         ownedEndToEndFlow+=EndToEndFlow?
	 *                     ) | 
	 *                     (noConnections?='none'? ownedEndToEndFlow+=EndToEndFlow?)
	 *                 ) 
	 *                 (ownedFlowImplementation+=FlowImplementation? ownedEndToEndFlow+=EndToEndFlow?)* 
	 *                 ((ownedModeTransition+=ModeTransition? (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*) | noModes?='none')?
	 *             ) | 
	 *             (
	 *                 (
	 *                     ownedPortConnection+=PortConnection? 
	 *                     (
	 *                         ownedAccessConnection+=AccessConnection | 
	 *                         ownedFeatureGroupConnection+=FeatureGroupConnection | 
	 *                         ownedFeatureConnection+=FeatureConnection | 
	 *                         ownedParameterConnection+=ParameterConnection
	 *                     )?
	 *                 )* 
	 *                 (
	 *                     (
	 *                         ownedPortConnection+=PortConnection? 
	 *                         noFlows?='none'? 
	 *                         ownedModeTransition+=ModeTransition? 
	 *                         (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*
	 *                     ) | 
	 *                     (ownedPortConnection+=PortConnection? noFlows?='none'? noModes?='none')
	 *                 )
	 *             ) | 
	 *             (noConnections?='none'? noFlows?='none'? noModes?='none') | 
	 *             (noConnections?='none'? noFlows?='none'? ownedModeTransition+=ModeTransition? (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*)
	 *         ) 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_SubprogramImplementation(ISerializationContext context, SubprogramImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Prototype returns SubprogramPrototype
	 *     ComponentPrototype returns SubprogramPrototype
	 *     SubprogramPrototype returns SubprogramPrototype
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[ComponentPrototype|REFINEDNAME]) 
	 *         constrainingClassifier=[ComponentClassifier|QCREF]? 
	 *         array?='['? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_SubprogramPrototype(ISerializationContext context, SubprogramPrototype semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SubprogramProxy returns SubprogramProxy
	 *
	 * Constraint:
	 *     (name=ID subprogramClassifier=[SubprogramClassifier|QCREF]? ownedPropertyAssociation+=PropertyAssociation*)
	 */
	protected void sequence_SubprogramProxy(ISerializationContext context, SubprogramProxy semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SubprogramSubcomponent returns SubprogramSubcomponent
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Subcomponent|REFINEDNAME]) 
	 *         (
	 *             subprogramSubcomponentType=[SubprogramSubcomponentType|QCREF] 
	 *             (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?
	 *         )? 
	 *         (
	 *             arrayDimension+=ArrayDimension+ 
	 *             (implementationReference+=ComponentImplementationReference implementationReference+=ComponentImplementationReference*)?
	 *         )? 
	 *         ownedPropertyAssociation+=ContainedPropertyAssociation* 
	 *         (ownedModeBinding+=ModeRef ownedModeBinding+=ModeRef*)?
	 *     )
	 */
	protected void sequence_SubprogramSubcomponent(ISerializationContext context, SubprogramSubcomponent semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns SubprogramType
	 *     ComponentType returns SubprogramType
	 *     SubprogramType returns SubprogramType
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (ownedExtension=TypeExtension (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (noPrototypes?='none' | ownedPrototype+=Prototype+)? 
	 *         (
	 *             noFeatures?='none' | 
	 *             (
	 *                 ownedDataAccess+=DataAccess? 
	 *                 (
	 *                     (
	 *                         ownedParameter+=Parameter | 
	 *                         ownedEventPort+=EventPort | 
	 *                         ownedEventDataPort+=EventDataPort | 
	 *                         ownedFeatureGroup+=FeatureGroup | 
	 *                         ownedSubprogramAccess+=SubprogramAccess | 
	 *                         ownedSubprogramGroupAccess+=SubprogramGroupAccess | 
	 *                         ownedAbstractFeature+=AbstractFeature
	 *                     )? 
	 *                     ownedDataAccess+=DataAccess?
	 *                 )*
	 *             )
	 *         )? 
	 *         (ownedFlowSpecification+=FlowSpecification+ | noFlows?='none')? 
	 *         ((derivedModes?=RequiresModesKeywords ownedMode+=Mode+) | (ownedMode+=Mode | ownedModeTransition+=ModeTransition)+ | noModes?='none')? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_SubprogramType(ISerializationContext context, SubprogramType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns SystemImplementation
	 *     ComponentImplementation returns SystemImplementation
	 *     SystemImplementation returns SystemImplementation
	 *
	 * Constraint:
	 *     (
	 *         ownedRealization=Realization 
	 *         name=INAME 
	 *         ownedExtension=ImplementationExtension? 
	 *         (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)? 
	 *         (ownedPrototype+=Prototype+ | noPrototypes?='none')? 
	 *         (
	 *             (
	 *                 ownedSubprogramSubcomponent+=SubprogramSubcomponent? 
	 *                 (
	 *                     (
	 *                         ownedSystemSubcomponent+=SystemSubcomponent | 
	 *                         ownedSubprogramGroupSubcomponent+=SubprogramGroupSubcomponent | 
	 *                         ownedProcessSubcomponent+=ProcessSubcomponent | 
	 *                         ownedProcessorSubcomponent+=ProcessorSubcomponent | 
	 *                         ownedVirtualProcessorSubcomponent+=VirtualProcessorSubcomponent | 
	 *                         ownedMemorySubcomponent+=MemorySubcomponent | 
	 *                         ownedDeviceSubcomponent+=DeviceSubcomponent | 
	 *                         ownedBusSubcomponent+=BusSubcomponent | 
	 *                         ownedVirtualBusSubcomponent+=VirtualBusSubcomponent | 
	 *                         ownedDataSubcomponent+=DataSubcomponent | 
	 *                         ownedAbstractSubcomponent+=AbstractSubcomponent
	 *                     )? 
	 *                     ownedSubprogramSubcomponent+=SubprogramSubcomponent?
	 *                 )*
	 *             ) | 
	 *             noSubcomponents?='none'
	 *         )? 
	 *         (ownedEventSource+=EventSource | ownedEventDataSource+=EventDataSource)* 
	 *         (ownedSubprogramProxy+=SubprogramProxy? ownedPortProxy+=PortProxy?)* 
	 *         (
	 *             (
	 *                 (
	 *                     (ownedSubprogramProxy+=SubprogramProxy? noConnections?='none'? ownedFlowImplementation+=FlowImplementation?) | 
	 *                     (
	 *                         ownedSubprogramProxy+=SubprogramProxy? 
	 *                         (
	 *                             ownedAccessConnection+=AccessConnection? 
	 *                             (ownedPortConnection+=PortConnection | ownedFeatureGroupConnection+=FeatureGroupConnection | ownedFeatureConnection+=FeatureConnection)?
	 *                         )* 
	 *                         ownedAccessConnection+=AccessConnection? 
	 *                         ownedFlowImplementation+=FlowImplementation?
	 *                     )
	 *                 ) 
	 *                 (ownedEndToEndFlow+=EndToEndFlow? ownedFlowImplementation+=FlowImplementation?)* 
	 *                 ((ownedModeTransition+=ModeTransition? (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*) | noModes?='none')?
	 *             ) | 
	 *             (
	 *                 ownedSubprogramProxy+=SubprogramProxy? 
	 *                 noConnections?='none'? 
	 *                 noFlows?='none'? 
	 *                 ((ownedModeTransition+=ModeTransition? (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*) | noModes?='none')
	 *             ) | 
	 *             (
	 *                 ownedSubprogramProxy+=SubprogramProxy? 
	 *                 (
	 *                     ownedAccessConnection+=AccessConnection? 
	 *                     (ownedPortConnection+=PortConnection | ownedFeatureGroupConnection+=FeatureGroupConnection | ownedFeatureConnection+=FeatureConnection)?
	 *                 )* 
	 *                 (
	 *                     (
	 *                         ownedAccessConnection+=AccessConnection? 
	 *                         noFlows?='none'? 
	 *                         ownedModeTransition+=ModeTransition? 
	 *                         (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*
	 *                     ) | 
	 *                     (ownedAccessConnection+=AccessConnection? noFlows?='none'? noModes?='none')
	 *                 )
	 *             )
	 *         ) 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_SystemImplementation(ISerializationContext context, SystemImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Prototype returns SystemPrototype
	 *     ComponentPrototype returns SystemPrototype
	 *     SystemPrototype returns SystemPrototype
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[ComponentPrototype|REFINEDNAME]) 
	 *         constrainingClassifier=[ComponentClassifier|QCREF]? 
	 *         array?='['? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_SystemPrototype(ISerializationContext context, SystemPrototype semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SystemSubcomponent returns SystemSubcomponent
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Subcomponent|REFINEDNAME]) 
	 *         (systemSubcomponentType=[SystemSubcomponentType|QCREF] (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (
	 *             arrayDimension+=ArrayDimension+ 
	 *             (implementationReference+=ComponentImplementationReference implementationReference+=ComponentImplementationReference*)?
	 *         )? 
	 *         ownedPropertyAssociation+=ContainedPropertyAssociation* 
	 *         (ownedModeBinding+=ModeRef ownedModeBinding+=ModeRef*)?
	 *     )
	 */
	protected void sequence_SystemSubcomponent(ISerializationContext context, SystemSubcomponent semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns SystemType
	 *     ComponentType returns SystemType
	 *     SystemType returns SystemType
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (ownedExtension=TypeExtension (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (ownedPrototype+=Prototype+ | noPrototypes?='none')? 
	 *         (
	 *             (
	 *                 ownedDataPort+=DataPort | 
	 *                 ownedEventPort+=EventPort | 
	 *                 ownedEventDataPort+=EventDataPort | 
	 *                 ownedFeatureGroup+=FeatureGroup | 
	 *                 ownedDataAccess+=DataAccess | 
	 *                 ownedBusAccess+=BusAccess | 
	 *                 ownedSubprogramAccess+=SubprogramAccess | 
	 *                 ownedSubprogramGroupAccess+=SubprogramGroupAccess | 
	 *                 ownedAbstractFeature+=AbstractFeature
	 *             )+ | 
	 *             noFeatures?='none'
	 *         )? 
	 *         (ownedFlowSpecification+=FlowSpecification+ | noFlows?='none')? 
	 *         (
	 *             (derivedModes?=RequiresModesKeywords ownedMode+=Mode+) | 
	 *             (ownedMode+=Mode? (ownedModeTransition+=ModeTransition? ownedMode+=Mode?)*) | 
	 *             noModes?='none'
	 *         )? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_SystemType(ISerializationContext context, SystemType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns ThreadGroupImplementation
	 *     ComponentImplementation returns ThreadGroupImplementation
	 *     ThreadGroupImplementation returns ThreadGroupImplementation
	 *
	 * Constraint:
	 *     (
	 *         ownedRealization=Realization 
	 *         name=INAME 
	 *         ownedExtension=ImplementationExtension? 
	 *         (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)? 
	 *         (ownedPrototype+=Prototype+ | noPrototypes?='none')? 
	 *         (
	 *             (
	 *                 ownedThreadGroupSubcomponent+=ThreadGroupSubcomponent? 
	 *                 (
	 *                     (
	 *                         ownedThreadSubcomponent+=ThreadSubcomponent | 
	 *                         ownedSubprogramSubcomponent+=SubprogramSubcomponent | 
	 *                         ownedSubprogramGroupSubcomponent+=SubprogramGroupSubcomponent | 
	 *                         ownedDataSubcomponent+=DataSubcomponent | 
	 *                         ownedAbstractSubcomponent+=AbstractSubcomponent
	 *                     )? 
	 *                     ownedThreadGroupSubcomponent+=ThreadGroupSubcomponent?
	 *                 )*
	 *             ) | 
	 *             noSubcomponents?='none'
	 *         )? 
	 *         ownedEventDataSource+=EventDataSource? 
	 *         (ownedEventSource+=EventSource? ownedEventDataSource+=EventDataSource?)* 
	 *         (ownedPortProxy+=PortProxy | ownedSubprogramProxy+=SubprogramProxy)* 
	 *         (
	 *             (
	 *                 (
	 *                     (
	 *                         (
	 *                             ownedAccessConnection+=AccessConnection? 
	 *                             (ownedPortConnection+=PortConnection | ownedFeatureGroupConnection+=FeatureGroupConnection | ownedFeatureConnection+=FeatureConnection)?
	 *                         )* 
	 *                         ownedAccessConnection+=AccessConnection? 
	 *                         ownedEndToEndFlow+=EndToEndFlow?
	 *                     ) | 
	 *                     (noConnections?='none'? ownedEndToEndFlow+=EndToEndFlow?)
	 *                 ) 
	 *                 (ownedFlowImplementation+=FlowImplementation? ownedEndToEndFlow+=EndToEndFlow?)* 
	 *                 ((ownedMode+=Mode? (ownedModeTransition+=ModeTransition? ownedMode+=Mode?)*) | noModes?='none')?
	 *             ) | 
	 *             (
	 *                 (
	 *                     ownedAccessConnection+=AccessConnection? 
	 *                     (ownedPortConnection+=PortConnection | ownedFeatureGroupConnection+=FeatureGroupConnection | ownedFeatureConnection+=FeatureConnection)?
	 *                 )* 
	 *                 (
	 *                     (ownedAccessConnection+=AccessConnection? noFlows?='none'? ownedMode+=Mode? (ownedModeTransition+=ModeTransition? ownedMode+=Mode?)*) | 
	 *                     (ownedAccessConnection+=AccessConnection? noFlows?='none'? noModes?='none')
	 *                 )
	 *             ) | 
	 *             (noConnections?='none'? noFlows?='none'? noModes?='none') | 
	 *             (noConnections?='none'? noFlows?='none'? ownedMode+=Mode? (ownedModeTransition+=ModeTransition? ownedMode+=Mode?)*)
	 *         ) 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_ThreadGroupImplementation(ISerializationContext context, ThreadGroupImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Prototype returns ThreadGroupPrototype
	 *     ComponentPrototype returns ThreadGroupPrototype
	 *     ThreadGroupPrototype returns ThreadGroupPrototype
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[ComponentPrototype|REFINEDNAME]) 
	 *         constrainingClassifier=[ComponentClassifier|QCREF]? 
	 *         array?='['? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_ThreadGroupPrototype(ISerializationContext context, ThreadGroupPrototype semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ThreadGroupSubcomponent returns ThreadGroupSubcomponent
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Subcomponent|REFINEDNAME]) 
	 *         (
	 *             threadGroupSubcomponentType=[ThreadGroupSubcomponentType|QCREF] 
	 *             (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?
	 *         )? 
	 *         (
	 *             arrayDimension+=ArrayDimension+ 
	 *             (implementationReference+=ComponentImplementationReference implementationReference+=ComponentImplementationReference*)?
	 *         )? 
	 *         ownedPropertyAssociation+=ContainedPropertyAssociation* 
	 *         (ownedModeBinding+=ModeRef ownedModeBinding+=ModeRef*)?
	 *     )
	 */
	protected void sequence_ThreadGroupSubcomponent(ISerializationContext context, ThreadGroupSubcomponent semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns ThreadGroupType
	 *     ComponentType returns ThreadGroupType
	 *     ThreadGroupType returns ThreadGroupType
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (ownedExtension=TypeExtension (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (noPrototypes?='none' | ownedPrototype+=Prototype+)? 
	 *         (
	 *             noFeatures?='none' | 
	 *             (
	 *                 ownedDataPort+=DataPort | 
	 *                 ownedEventPort+=EventPort | 
	 *                 ownedEventDataPort+=EventDataPort | 
	 *                 ownedFeatureGroup+=FeatureGroup | 
	 *                 ownedDataAccess+=DataAccess | 
	 *                 ownedSubprogramAccess+=SubprogramAccess | 
	 *                 ownedSubprogramGroupAccess+=SubprogramGroupAccess | 
	 *                 ownedAbstractFeature+=AbstractFeature
	 *             )+
	 *         )? 
	 *         (ownedFlowSpecification+=FlowSpecification+ | noFlows?='none')? 
	 *         (
	 *             (derivedModes?=RequiresModesKeywords ownedMode+=Mode+) | 
	 *             (ownedModeTransition+=ModeTransition? (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*) | 
	 *             noModes?='none'
	 *         )? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_ThreadGroupType(ISerializationContext context, ThreadGroupType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns ThreadImplementation
	 *     ComponentImplementation returns ThreadImplementation
	 *     ThreadImplementation returns ThreadImplementation
	 *
	 * Constraint:
	 *     (
	 *         ownedRealization=Realization 
	 *         name=INAME 
	 *         ownedExtension=ImplementationExtension? 
	 *         (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)? 
	 *         (ownedPrototype+=Prototype+ | noPrototypes?='none')? 
	 *         (
	 *             (
	 *                 ownedSubprogramSubcomponent+=SubprogramSubcomponent? 
	 *                 (
	 *                     (
	 *                         ownedSubprogramGroupSubcomponent+=SubprogramGroupSubcomponent | 
	 *                         ownedDataSubcomponent+=DataSubcomponent | 
	 *                         ownedAbstractSubcomponent+=AbstractSubcomponent
	 *                     )? 
	 *                     ownedSubprogramSubcomponent+=SubprogramSubcomponent?
	 *                 )*
	 *             ) | 
	 *             noSubcomponents?='none'
	 *         )? 
	 *         ownedEventDataSource+=EventDataSource? 
	 *         (ownedEventSource+=EventSource? ownedEventDataSource+=EventDataSource?)* 
	 *         ownedSubprogramProxy+=SubprogramProxy? 
	 *         (ownedPortProxy+=PortProxy? ownedSubprogramProxy+=SubprogramProxy?)* 
	 *         (ownedSubprogramCallSequence+=SubprogramCallSequence+ | noCalls?='none')? 
	 *         (
	 *             (
	 *                 ownedPortConnection+=PortConnection | 
	 *                 ownedAccessConnection+=AccessConnection | 
	 *                 ownedFeatureGroupConnection+=FeatureGroupConnection | 
	 *                 ownedFeatureConnection+=FeatureConnection | 
	 *                 ownedParameterConnection+=ParameterConnection
	 *             )+ | 
	 *             noConnections?='none'
	 *         )? 
	 *         (
	 *             (
	 *                 (ownedFlowImplementation+=FlowImplementation? ownedEndToEndFlow+=EndToEndFlow?)* 
	 *                 (
	 *                     (ownedFlowImplementation+=FlowImplementation? noModes?='none'?) | 
	 *                     (ownedFlowImplementation+=FlowImplementation? ownedModeTransition+=ModeTransition? (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*)
	 *                 )
	 *             ) | 
	 *             (noFlows?='none'? ownedModeTransition+=ModeTransition? (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*) | 
	 *             (noFlows?='none'? noModes?='none'?)
	 *         ) 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_ThreadImplementation(ISerializationContext context, ThreadImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Prototype returns ThreadPrototype
	 *     ComponentPrototype returns ThreadPrototype
	 *     ThreadPrototype returns ThreadPrototype
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[ComponentPrototype|REFINEDNAME]) 
	 *         constrainingClassifier=[ComponentClassifier|QCREF]? 
	 *         array?='['? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_ThreadPrototype(ISerializationContext context, ThreadPrototype semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ThreadSubcomponent returns ThreadSubcomponent
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Subcomponent|REFINEDNAME]) 
	 *         (threadSubcomponentType=[ThreadSubcomponentType|QCREF] (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (
	 *             arrayDimension+=ArrayDimension+ 
	 *             (implementationReference+=ComponentImplementationReference implementationReference+=ComponentImplementationReference*)?
	 *         )? 
	 *         ownedPropertyAssociation+=ContainedPropertyAssociation* 
	 *         (ownedModeBinding+=ModeRef ownedModeBinding+=ModeRef*)?
	 *     )
	 */
	protected void sequence_ThreadSubcomponent(ISerializationContext context, ThreadSubcomponent semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns ThreadType
	 *     ComponentType returns ThreadType
	 *     ThreadType returns ThreadType
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (ownedExtension=TypeExtension (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (noPrototypes?='none' | ownedPrototype+=Prototype+)? 
	 *         (
	 *             noFeatures?='none' | 
	 *             (
	 *                 ownedDataPort+=DataPort | 
	 *                 ownedEventPort+=EventPort | 
	 *                 ownedEventDataPort+=EventDataPort | 
	 *                 ownedFeatureGroup+=FeatureGroup | 
	 *                 ownedDataAccess+=DataAccess | 
	 *                 ownedSubprogramAccess+=SubprogramAccess | 
	 *                 ownedSubprogramGroupAccess+=SubprogramGroupAccess | 
	 *                 ownedAbstractFeature+=AbstractFeature
	 *             )+
	 *         )? 
	 *         (ownedFlowSpecification+=FlowSpecification+ | noFlows?='none')? 
	 *         (
	 *             (derivedModes?=RequiresModesKeywords ownedMode+=Mode+) | 
	 *             (ownedModeTransition+=ModeTransition? (ownedMode+=Mode? ownedModeTransition+=ModeTransition?)*) | 
	 *             noModes?='none'
	 *         )? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_ThreadType(ISerializationContext context, ThreadType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Trigger returns ModeTransitionTrigger
	 *
	 * Constraint:
	 *     ((context=[Context|ID]? triggerPort=[Port|ID]) | triggerPort=[InternalFeature|ID] | triggerPort=[PortProxy|ID])
	 */
	protected void sequence_Trigger(ISerializationContext context, ModeTransitionTrigger semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeExtension returns TypeExtension
	 *
	 * Constraint:
	 *     extended=[ComponentType|QCREF]
	 */
	protected void sequence_TypeExtension(ISerializationContext context, TypeExtension semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getTypeExtension_Extended()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getTypeExtension_Extended()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getTypeExtensionAccess().getExtendedComponentTypeQCREFParserRuleCall_1_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getTypeExtension_Extended(), false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     UnitLiteralConversion returns UnitLiteral
	 *
	 * Constraint:
	 *     (name=ID baseUnit=[UnitLiteral|ID] factor=NumberValue)
	 */
	protected void sequence_UnitLiteralConversion(ISerializationContext context, UnitLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()));
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getUnitLiteral_BaseUnit()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getUnitLiteral_BaseUnit()));
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getUnitLiteral_Factor()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getUnitLiteral_Factor()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getUnitLiteralConversionAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getUnitLiteralConversionAccess().getBaseUnitUnitLiteralIDTerminalRuleCall_2_0_1(), semanticObject.eGet(Aadl2Package.eINSTANCE.getUnitLiteral_BaseUnit(), false));
		feeder.accept(grammarAccess.getUnitLiteralConversionAccess().getFactorNumberValueParserRuleCall_4_0(), semanticObject.getFactor());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     UnitLiteral returns UnitLiteral
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_UnitLiteral(ISerializationContext context, UnitLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient((EObject) semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject) semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, (EObject) semanticObject);
		feeder.accept(grammarAccess.getUnitLiteralAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     PropertyType returns UnitsType
	 *     UnitsType returns UnitsType
	 *
	 * Constraint:
	 *     (name=ID ownedLiteral+=UnitLiteral ownedLiteral+=UnitLiteralConversion*)
	 */
	protected void sequence_UnitsType(ISerializationContext context, UnitsType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnnamedPropertyType returns AadlBoolean
	 *     UnnamedBooleanType returns AadlBoolean
	 *
	 * Constraint:
	 *     {AadlBoolean}
	 */
	protected void sequence_UnnamedBooleanType(ISerializationContext context, AadlBoolean semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnnamedPropertyType returns ClassifierType
	 *     UnnamedClassifierType returns ClassifierType
	 *
	 * Constraint:
	 *     (classifierReference+=QMReference classifierReference+=QMReference*)?
	 */
	protected void sequence_UnnamedClassifierType(ISerializationContext context, ClassifierType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnnamedPropertyType returns EnumerationType
	 *     UnnamedEnumerationType returns EnumerationType
	 *
	 * Constraint:
	 *     (ownedLiteral+=EnumerationLiteral ownedLiteral+=EnumerationLiteral*)
	 */
	protected void sequence_UnnamedEnumerationType(ISerializationContext context, EnumerationType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnnamedPropertyType returns AadlInteger
	 *     UnnamedIntegerType returns AadlInteger
	 *
	 * Constraint:
	 *     (range=IntegerRange? (ownedUnitsType=UnnamedUnitsType | referencedUnitsType=[UnitsType|QPREF])?)
	 */
	protected void sequence_UnnamedIntegerType(ISerializationContext context, AadlInteger semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnnamedPropertyType returns RangeType
	 *     UnnamedRangeType returns RangeType
	 *
	 * Constraint:
	 *     (ownedNumberType=UnnamedIntegerType | ownedNumberType=UnnamedRealType | referencedNumberType=[NumberType|QPREF])
	 */
	protected void sequence_UnnamedRangeType(ISerializationContext context, RangeType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnnamedPropertyType returns AadlReal
	 *     UnnamedRealType returns AadlReal
	 *
	 * Constraint:
	 *     (range=RealRange? (ownedUnitsType=UnnamedUnitsType | referencedUnitsType=[UnitsType|QPREF])?)
	 */
	protected void sequence_UnnamedRealType(ISerializationContext context, AadlReal semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnnamedPropertyType returns RecordType
	 *     UnnamedRecordType returns RecordType
	 *
	 * Constraint:
	 *     ownedField+=RecordField+
	 */
	protected void sequence_UnnamedRecordType(ISerializationContext context, RecordType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnnamedPropertyType returns ReferenceType
	 *     UnnamedReferenceType returns ReferenceType
	 *
	 * Constraint:
	 *     (namedElementReference+=QMReference namedElementReference+=QMReference*)?
	 */
	protected void sequence_UnnamedReferenceType(ISerializationContext context, ReferenceType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnnamedPropertyType returns AadlString
	 *     UnnamedStringType returns AadlString
	 *
	 * Constraint:
	 *     {AadlString}
	 */
	protected void sequence_UnnamedStringType(ISerializationContext context, AadlString semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnnamedPropertyType returns UnitsType
	 *     UnnamedUnitsType returns UnitsType
	 *
	 * Constraint:
	 *     (ownedLiteral+=UnitLiteral ownedLiteral+=UnitLiteralConversion*)
	 */
	protected void sequence_UnnamedUnitsType(ISerializationContext context, UnitsType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns VirtualBusImplementation
	 *     ComponentImplementation returns VirtualBusImplementation
	 *     VirtualBusImplementation returns VirtualBusImplementation
	 *
	 * Constraint:
	 *     (
	 *         ownedRealization=Realization 
	 *         name=INAME 
	 *         ownedExtension=ImplementationExtension? 
	 *         (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)? 
	 *         (ownedPrototype+=Prototype+ | noPrototypes?='none')? 
	 *         (
	 *             (
	 *                 ownedAbstractSubcomponent+=AbstractSubcomponent? 
	 *                 (ownedVirtualBusSubcomponent+=VirtualBusSubcomponent? ownedAbstractSubcomponent+=AbstractSubcomponent?)*
	 *             ) | 
	 *             noSubcomponents?='none'
	 *         )? 
	 *         (ownedEventSource+=EventSource | ownedEventDataSource+=EventDataSource)* 
	 *         ((ownedMode+=Mode? (ownedModeTransition+=ModeTransition? ownedMode+=Mode?)*) | noModes?='none')? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_VirtualBusImplementation(ISerializationContext context, VirtualBusImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Prototype returns VirtualBusPrototype
	 *     ComponentPrototype returns VirtualBusPrototype
	 *     VirtualBusPrototype returns VirtualBusPrototype
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[ComponentPrototype|REFINEDNAME]) 
	 *         constrainingClassifier=[ComponentClassifier|QCREF]? 
	 *         array?='['? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_VirtualBusPrototype(ISerializationContext context, VirtualBusPrototype semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     VirtualBusSubcomponent returns VirtualBusSubcomponent
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Subcomponent|REFINEDNAME]) 
	 *         (virtualBusSubcomponentType=[VirtualBusClassifier|QCREF] (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (
	 *             arrayDimension+=ArrayDimension+ 
	 *             (implementationReference+=ComponentImplementationReference implementationReference+=ComponentImplementationReference*)?
	 *         )? 
	 *         ownedPropertyAssociation+=ContainedPropertyAssociation* 
	 *         (ownedModeBinding+=ModeRef ownedModeBinding+=ModeRef*)?
	 *     )
	 */
	protected void sequence_VirtualBusSubcomponent(ISerializationContext context, VirtualBusSubcomponent semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns VirtualBusType
	 *     ComponentType returns VirtualBusType
	 *     VirtualBusType returns VirtualBusType
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (ownedExtension=TypeExtension (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (noPrototypes?='none' | ownedPrototype+=Prototype+)? 
	 *         (
	 *             noFeatures?='none' | 
	 *             (
	 *                 ownedEventDataPort+=EventDataPort? 
	 *                 (
	 *                     (
	 *                         ownedFeatureGroup+=FeatureGroup | 
	 *                         ownedDataPort+=DataPort | 
	 *                         ownedEventPort+=EventPort | 
	 *                         ownedAbstractFeature+=AbstractFeature | 
	 *                         ownedBusAccess+=BusAccess
	 *                     )? 
	 *                     ownedEventDataPort+=EventDataPort?
	 *                 )*
	 *             )
	 *         )? 
	 *         ((derivedModes?=RequiresModesKeywords ownedMode+=Mode+) | (ownedMode+=Mode | ownedModeTransition+=ModeTransition)+ | noModes?='none')? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_VirtualBusType(ISerializationContext context, VirtualBusType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns VirtualProcessorImplementation
	 *     ComponentImplementation returns VirtualProcessorImplementation
	 *     VirtualProcessorImplementation returns VirtualProcessorImplementation
	 *
	 * Constraint:
	 *     (
	 *         ownedRealization=Realization 
	 *         name=INAME 
	 *         ownedExtension=ImplementationExtension? 
	 *         (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)? 
	 *         (ownedPrototype+=Prototype+ | noPrototypes?='none')? 
	 *         (
	 *             (
	 *                 ownedAbstractSubcomponent+=AbstractSubcomponent? 
	 *                 (
	 *                     (ownedVirtualBusSubcomponent+=VirtualBusSubcomponent | ownedVirtualProcessorSubcomponent+=VirtualProcessorSubcomponent)? 
	 *                     ownedAbstractSubcomponent+=AbstractSubcomponent?
	 *                 )*
	 *             ) | 
	 *             noSubcomponents?='none'
	 *         )? 
	 *         ownedEventDataSource+=EventDataSource? 
	 *         (ownedEventSource+=EventSource? ownedEventDataSource+=EventDataSource?)* 
	 *         (ownedSubprogramProxy+=SubprogramProxy? ownedPortProxy+=PortProxy?)* 
	 *         (
	 *             (
	 *                 ownedSubprogramProxy+=SubprogramProxy? 
	 *                 (
	 *                     ownedAccessConnection+=AccessConnection? 
	 *                     (ownedPortConnection+=PortConnection | ownedFeatureGroupConnection+=FeatureGroupConnection | ownedFeatureConnection+=FeatureConnection)?
	 *                 )* 
	 *                 (
	 *                     (ownedAccessConnection+=AccessConnection? noFlows?='none'?) | 
	 *                     (
	 *                         ownedAccessConnection+=AccessConnection? 
	 *                         ownedEndToEndFlow+=EndToEndFlow? 
	 *                         (ownedFlowImplementation+=FlowImplementation? ownedEndToEndFlow+=EndToEndFlow?)*
	 *                     )
	 *                 )
	 *             ) | 
	 *             (
	 *                 ownedSubprogramProxy+=SubprogramProxy? 
	 *                 noConnections?='none'? 
	 *                 ownedEndToEndFlow+=EndToEndFlow? 
	 *                 (ownedFlowImplementation+=FlowImplementation? ownedEndToEndFlow+=EndToEndFlow?)*
	 *             ) | 
	 *             (ownedSubprogramProxy+=SubprogramProxy? noConnections?='none'? noFlows?='none'?)
	 *         ) 
	 *         ((ownedMode+=Mode | ownedModeTransition+=ModeTransition)+ | noModes?='none')? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_VirtualProcessorImplementation(ISerializationContext context, VirtualProcessorImplementation semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Prototype returns VirtualProcessorPrototype
	 *     ComponentPrototype returns VirtualProcessorPrototype
	 *     VirtualProcessorPrototype returns VirtualProcessorPrototype
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[ComponentPrototype|REFINEDNAME]) 
	 *         constrainingClassifier=[ComponentClassifier|QCREF]? 
	 *         array?='['? 
	 *         ownedPropertyAssociation+=PropertyAssociation*
	 *     )
	 */
	protected void sequence_VirtualProcessorPrototype(ISerializationContext context, VirtualProcessorPrototype semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     VirtualProcessorSubcomponent returns VirtualProcessorSubcomponent
	 *
	 * Constraint:
	 *     (
	 *         (name=ID | refined=[Subcomponent|REFINEDNAME]) 
	 *         (
	 *             virtualProcessorSubcomponentType=[VirtualProcessorSubcomponentType|QCREF] 
	 *             (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?
	 *         )? 
	 *         (
	 *             arrayDimension+=ArrayDimension+ 
	 *             (implementationReference+=ComponentImplementationReference implementationReference+=ComponentImplementationReference*)?
	 *         )? 
	 *         ownedPropertyAssociation+=ContainedPropertyAssociation* 
	 *         (ownedModeBinding+=ModeRef ownedModeBinding+=ModeRef*)?
	 *     )
	 */
	protected void sequence_VirtualProcessorSubcomponent(ISerializationContext context, VirtualProcessorSubcomponent semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Classifier returns VirtualProcessorType
	 *     ComponentType returns VirtualProcessorType
	 *     VirtualProcessorType returns VirtualProcessorType
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (ownedExtension=TypeExtension (ownedPrototypeBinding+=PrototypeBinding ownedPrototypeBinding+=PrototypeBinding*)?)? 
	 *         (noPrototypes?='none' | ownedPrototype+=Prototype+)? 
	 *         (
	 *             noFeatures?='none' | 
	 *             (
	 *                 ownedDataPort+=DataPort? 
	 *                 (
	 *                     (
	 *                         ownedEventPort+=EventPort | 
	 *                         ownedEventDataPort+=EventDataPort | 
	 *                         ownedFeatureGroup+=FeatureGroup | 
	 *                         ownedSubprogramAccess+=SubprogramAccess | 
	 *                         ownedSubprogramGroupAccess+=SubprogramGroupAccess | 
	 *                         ownedAbstractFeature+=AbstractFeature | 
	 *                         ownedBusAccess+=BusAccess
	 *                     )? 
	 *                     ownedDataPort+=DataPort?
	 *                 )*
	 *             )
	 *         )? 
	 *         (ownedFlowSpecification+=FlowSpecification+ | noFlows?='none')? 
	 *         ((derivedModes?=RequiresModesKeywords ownedMode+=Mode+) | (ownedMode+=Mode | ownedModeTransition+=ModeTransition)+ | noModes?='none')? 
	 *         (ownedPropertyAssociation+=ContainedPropertyAssociation+ | noProperties?='none')? 
	 *         ownedAnnexSubclause+=AnnexSubclause*
	 *     )
	 */
	protected void sequence_VirtualProcessorType(ISerializationContext context, VirtualProcessorType semanticObject) {
		genericSequencer.createSequence(context, (EObject) semanticObject);
	}
	
	
}
