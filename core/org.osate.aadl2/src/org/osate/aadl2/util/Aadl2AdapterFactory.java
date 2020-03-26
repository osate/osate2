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
package org.osate.aadl2.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.Aadl2Package
 * @generated
 */
public class Aadl2AdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Aadl2Package modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aadl2AdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Aadl2Package.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Aadl2Switch<Adapter> modelSwitch = new Aadl2Switch<Adapter>() {
		public Adapter caseElement(Element object) {
			return createElementAdapter();
		}
		public Adapter caseComment(Comment object) {
			return createCommentAdapter();
		}
		public Adapter caseType(Type object) {
			return createTypeAdapter();
		}
		public Adapter caseNamedElement(NamedElement object) {
			return createNamedElementAdapter();
		}
		public Adapter casePropertyAssociation(PropertyAssociation object) {
			return createPropertyAssociationAdapter();
		}
		public Adapter caseProperty(Property object) {
			return createPropertyAdapter();
		}
		public Adapter caseBasicProperty(BasicProperty object) {
			return createBasicPropertyAdapter();
		}
		public Adapter caseTypedElement(TypedElement object) {
			return createTypedElementAdapter();
		}
		public Adapter casePropertyType(PropertyType object) {
			return createPropertyTypeAdapter();
		}
		public Adapter caseAbstractNamedValue(AbstractNamedValue object) {
			return createAbstractNamedValueAdapter();
		}
		public Adapter casePropertyExpression(PropertyExpression object) {
			return createPropertyExpressionAdapter();
		}
		public Adapter caseMetaclassReference(MetaclassReference object) {
			return createMetaclassReferenceAdapter();
		}
		public Adapter casePropertyOwner(PropertyOwner object) {
			return createPropertyOwnerAdapter();
		}
		public Adapter caseClassifier(Classifier object) {
			return createClassifierAdapter();
		}
		public Adapter caseNamespace(Namespace object) {
			return createNamespaceAdapter();
		}
		public Adapter caseClassifierFeature(ClassifierFeature object) {
			return createClassifierFeatureAdapter();
		}
		public Adapter caseGeneralization(Generalization object) {
			return createGeneralizationAdapter();
		}
		public Adapter caseDirectedRelationship(DirectedRelationship object) {
			return createDirectedRelationshipAdapter();
		}
		public Adapter caseRelationship(Relationship object) {
			return createRelationshipAdapter();
		}
		public Adapter caseAnnexSubclause(AnnexSubclause object) {
			return createAnnexSubclauseAdapter();
		}
		public Adapter caseModalElement(ModalElement object) {
			return createModalElementAdapter();
		}
		public Adapter caseMode(Mode object) {
			return createModeAdapter();
		}
		public Adapter caseModeFeature(ModeFeature object) {
			return createModeFeatureAdapter();
		}
		public Adapter casePrototype(Prototype object) {
			return createPrototypeAdapter();
		}
		public Adapter caseStructuralFeature(StructuralFeature object) {
			return createStructuralFeatureAdapter();
		}
		public Adapter caseRefinableElement(RefinableElement object) {
			return createRefinableElementAdapter();
		}
		public Adapter caseCalledSubprogram(CalledSubprogram object) {
			return createCalledSubprogramAdapter();
		}
		public Adapter casePrototypeBinding(PrototypeBinding object) {
			return createPrototypeBindingAdapter();
		}
		public Adapter caseContainedNamedElement(ContainedNamedElement object) {
			return createContainedNamedElementAdapter();
		}
		public Adapter caseContainmentPathElement(ContainmentPathElement object) {
			return createContainmentPathElementAdapter();
		}
		public Adapter caseArrayRange(ArrayRange object) {
			return createArrayRangeAdapter();
		}
		public Adapter caseModalPropertyValue(ModalPropertyValue object) {
			return createModalPropertyValueAdapter();
		}
		public Adapter caseBehavioralFeature(BehavioralFeature object) {
			return createBehavioralFeatureAdapter();
		}
		public Adapter caseArrayDimension(ArrayDimension object) {
			return createArrayDimensionAdapter();
		}
		public Adapter caseArraySize(ArraySize object) {
			return createArraySizeAdapter();
		}
		public Adapter caseArraySizeProperty(ArraySizeProperty object) {
			return createArraySizePropertyAdapter();
		}
		public Adapter caseArrayableElement(ArrayableElement object) {
			return createArrayableElementAdapter();
		}
		public Adapter caseComponentImplementationReference(ComponentImplementationReference object) {
			return createComponentImplementationReferenceAdapter();
		}
		public Adapter caseComponentImplementation(ComponentImplementation object) {
			return createComponentImplementationAdapter();
		}
		public Adapter caseComponentClassifier(ComponentClassifier object) {
			return createComponentClassifierAdapter();
		}
		public Adapter caseSubcomponentType(SubcomponentType object) {
			return createSubcomponentTypeAdapter();
		}
		public Adapter caseFeatureClassifier(FeatureClassifier object) {
			return createFeatureClassifierAdapter();
		}
		public Adapter caseModeTransition(ModeTransition object) {
			return createModeTransitionAdapter();
		}
		public Adapter caseModeTransitionTrigger(ModeTransitionTrigger object) {
			return createModeTransitionTriggerAdapter();
		}
		public Adapter caseContext(Context object) {
			return createContextAdapter();
		}
		public Adapter caseTriggerPort(TriggerPort object) {
			return createTriggerPortAdapter();
		}
		public Adapter caseComponentType(ComponentType object) {
			return createComponentTypeAdapter();
		}
		public Adapter caseFeature(Feature object) {
			return createFeatureAdapter();
		}
		public Adapter caseFeatureConnectionEnd(FeatureConnectionEnd object) {
			return createFeatureConnectionEndAdapter();
		}
		public Adapter caseConnectionEnd(ConnectionEnd object) {
			return createConnectionEndAdapter();
		}
		public Adapter caseComponentPrototype(ComponentPrototype object) {
			return createComponentPrototypeAdapter();
		}
		public Adapter caseFlowSpecification(FlowSpecification object) {
			return createFlowSpecificationAdapter();
		}
		public Adapter caseFlowFeature(FlowFeature object) {
			return createFlowFeatureAdapter();
		}
		public Adapter caseFlow(Flow object) {
			return createFlowAdapter();
		}
		public Adapter caseModalPath(ModalPath object) {
			return createModalPathAdapter();
		}
		public Adapter caseFlowElement(FlowElement object) {
			return createFlowElementAdapter();
		}
		public Adapter caseEndToEndFlowElement(EndToEndFlowElement object) {
			return createEndToEndFlowElementAdapter();
		}
		public Adapter caseFlowEnd(FlowEnd object) {
			return createFlowEndAdapter();
		}
		public Adapter caseTypeExtension(TypeExtension object) {
			return createTypeExtensionAdapter();
		}
		public Adapter caseFeatureGroup(FeatureGroup object) {
			return createFeatureGroupAdapter();
		}
		public Adapter caseCallContext(CallContext object) {
			return createCallContextAdapter();
		}
		public Adapter caseDirectedFeature(DirectedFeature object) {
			return createDirectedFeatureAdapter();
		}
		public Adapter caseFeatureGroupConnectionEnd(FeatureGroupConnectionEnd object) {
			return createFeatureGroupConnectionEndAdapter();
		}
		public Adapter caseFeatureType(FeatureType object) {
			return createFeatureTypeAdapter();
		}
		public Adapter caseFeatureGroupType(FeatureGroupType object) {
			return createFeatureGroupTypeAdapter();
		}
		public Adapter caseGroupExtension(GroupExtension object) {
			return createGroupExtensionAdapter();
		}
		public Adapter caseBusAccess(BusAccess object) {
			return createBusAccessAdapter();
		}
		public Adapter caseAccess(Access object) {
			return createAccessAdapter();
		}
		public Adapter caseAccessConnectionEnd(AccessConnectionEnd object) {
			return createAccessConnectionEndAdapter();
		}
		public Adapter caseBusFeatureClassifier(BusFeatureClassifier object) {
			return createBusFeatureClassifierAdapter();
		}
		public Adapter caseDataAccess(DataAccess object) {
			return createDataAccessAdapter();
		}
		public Adapter caseParameterConnectionEnd(ParameterConnectionEnd object) {
			return createParameterConnectionEndAdapter();
		}
		public Adapter casePortConnectionEnd(PortConnectionEnd object) {
			return createPortConnectionEndAdapter();
		}
		public Adapter caseDataSubcomponentType(DataSubcomponentType object) {
			return createDataSubcomponentTypeAdapter();
		}
		public Adapter caseAbstractFeatureClassifier(AbstractFeatureClassifier object) {
			return createAbstractFeatureClassifierAdapter();
		}
		public Adapter caseDataPort(DataPort object) {
			return createDataPortAdapter();
		}
		public Adapter casePort(Port object) {
			return createPortAdapter();
		}
		public Adapter caseEventDataPort(EventDataPort object) {
			return createEventDataPortAdapter();
		}
		public Adapter caseEventPort(EventPort object) {
			return createEventPortAdapter();
		}
		public Adapter caseParameter(Parameter object) {
			return createParameterAdapter();
		}
		public Adapter caseSubprogramAccess(SubprogramAccess object) {
			return createSubprogramAccessAdapter();
		}
		public Adapter caseSubprogramSubcomponentType(SubprogramSubcomponentType object) {
			return createSubprogramSubcomponentTypeAdapter();
		}
		public Adapter caseSubprogramGroupAccess(SubprogramGroupAccess object) {
			return createSubprogramGroupAccessAdapter();
		}
		public Adapter caseSubprogramGroupSubcomponentType(SubprogramGroupSubcomponentType object) {
			return createSubprogramGroupSubcomponentTypeAdapter();
		}
		public Adapter caseAbstractFeature(AbstractFeature object) {
			return createAbstractFeatureAdapter();
		}
		public Adapter caseFeaturePrototype(FeaturePrototype object) {
			return createFeaturePrototypeAdapter();
		}
		public Adapter caseFeatureGroupPrototype(FeatureGroupPrototype object) {
			return createFeatureGroupPrototypeAdapter();
		}
		public Adapter caseSubcomponent(Subcomponent object) {
			return createSubcomponentAdapter();
		}
		public Adapter caseModeBinding(ModeBinding object) {
			return createModeBindingAdapter();
		}
		public Adapter caseFlowImplementation(FlowImplementation object) {
			return createFlowImplementationAdapter();
		}
		public Adapter caseFlowSegment(FlowSegment object) {
			return createFlowSegmentAdapter();
		}
		public Adapter caseConnection(Connection object) {
			return createConnectionAdapter();
		}
		public Adapter caseConnectedElement(ConnectedElement object) {
			return createConnectedElementAdapter();
		}
		public Adapter caseImplementationExtension(ImplementationExtension object) {
			return createImplementationExtensionAdapter();
		}
		public Adapter caseRealization(Realization object) {
			return createRealizationAdapter();
		}
		public Adapter caseEndToEndFlow(EndToEndFlow object) {
			return createEndToEndFlowAdapter();
		}
		public Adapter caseEndToEndFlowSegment(EndToEndFlowSegment object) {
			return createEndToEndFlowSegmentAdapter();
		}
		public Adapter caseAbstractSubcomponent(AbstractSubcomponent object) {
			return createAbstractSubcomponentAdapter();
		}
		public Adapter caseAbstract(Abstract object) {
			return createAbstractAdapter();
		}
		public Adapter caseAbstractSubcomponentType(AbstractSubcomponentType object) {
			return createAbstractSubcomponentTypeAdapter();
		}
		public Adapter caseAccessConnection(AccessConnection object) {
			return createAccessConnectionAdapter();
		}
		public Adapter caseParameterConnection(ParameterConnection object) {
			return createParameterConnectionAdapter();
		}
		public Adapter casePortConnection(PortConnection object) {
			return createPortConnectionAdapter();
		}
		public Adapter caseFeatureConnection(FeatureConnection object) {
			return createFeatureConnectionAdapter();
		}
		public Adapter caseFeatureGroupConnection(FeatureGroupConnection object) {
			return createFeatureGroupConnectionAdapter();
		}
		public Adapter caseProcessorFeature(ProcessorFeature object) {
			return createProcessorFeatureAdapter();
		}
		public Adapter caseInternalFeature(InternalFeature object) {
			return createInternalFeatureAdapter();
		}
		public Adapter caseEventSource(EventSource object) {
			return createEventSourceAdapter();
		}
		public Adapter caseEventDataSource(EventDataSource object) {
			return createEventDataSourceAdapter();
		}
		public Adapter caseDataClassifier(DataClassifier object) {
			return createDataClassifierAdapter();
		}
		public Adapter caseData(Data object) {
			return createDataAdapter();
		}
		public Adapter casePortProxy(PortProxy object) {
			return createPortProxyAdapter();
		}
		public Adapter caseSubprogramProxy(SubprogramProxy object) {
			return createSubprogramProxyAdapter();
		}
		public Adapter caseSubprogramClassifier(SubprogramClassifier object) {
			return createSubprogramClassifierAdapter();
		}
		public Adapter caseSubprogram(Subprogram object) {
			return createSubprogramAdapter();
		}
		public Adapter caseAnnexLibrary(AnnexLibrary object) {
			return createAnnexLibraryAdapter();
		}
		public Adapter caseDefaultAnnexLibrary(DefaultAnnexLibrary object) {
			return createDefaultAnnexLibraryAdapter();
		}
		public Adapter caseDefaultAnnexSubclause(DefaultAnnexSubclause object) {
			return createDefaultAnnexSubclauseAdapter();
		}
		public Adapter casePublicPackageSection(PublicPackageSection object) {
			return createPublicPackageSectionAdapter();
		}
		public Adapter casePackageSection(PackageSection object) {
			return createPackageSectionAdapter();
		}
		public Adapter casePackageRename(PackageRename object) {
			return createPackageRenameAdapter();
		}
		public Adapter caseAadlPackage(AadlPackage object) {
			return createAadlPackageAdapter();
		}
		public Adapter caseModelUnit(ModelUnit object) {
			return createModelUnitAdapter();
		}
		public Adapter casePrivatePackageSection(PrivatePackageSection object) {
			return createPrivatePackageSectionAdapter();
		}
		public Adapter caseComponentTypeRename(ComponentTypeRename object) {
			return createComponentTypeRenameAdapter();
		}
		public Adapter caseFeatureGroupTypeRename(FeatureGroupTypeRename object) {
			return createFeatureGroupTypeRenameAdapter();
		}
		public Adapter caseComponentPrototypeBinding(ComponentPrototypeBinding object) {
			return createComponentPrototypeBindingAdapter();
		}
		public Adapter caseComponentPrototypeActual(ComponentPrototypeActual object) {
			return createComponentPrototypeActualAdapter();
		}
		public Adapter caseFeatureGroupPrototypeBinding(FeatureGroupPrototypeBinding object) {
			return createFeatureGroupPrototypeBindingAdapter();
		}
		public Adapter caseFeatureGroupPrototypeActual(FeatureGroupPrototypeActual object) {
			return createFeatureGroupPrototypeActualAdapter();
		}
		public Adapter caseFeaturePrototypeActual(FeaturePrototypeActual object) {
			return createFeaturePrototypeActualAdapter();
		}
		public Adapter caseFeaturePrototypeBinding(FeaturePrototypeBinding object) {
			return createFeaturePrototypeBindingAdapter();
		}
		public Adapter caseAccessSpecification(AccessSpecification object) {
			return createAccessSpecificationAdapter();
		}
		public Adapter casePortSpecification(PortSpecification object) {
			return createPortSpecificationAdapter();
		}
		public Adapter caseFeaturePrototypeReference(FeaturePrototypeReference object) {
			return createFeaturePrototypeReferenceAdapter();
		}
		public Adapter caseSubprogramCallSequence(SubprogramCallSequence object) {
			return createSubprogramCallSequenceAdapter();
		}
		public Adapter caseSubprogramCall(SubprogramCall object) {
			return createSubprogramCallAdapter();
		}
		public Adapter caseBehavioredImplementation(BehavioredImplementation object) {
			return createBehavioredImplementationAdapter();
		}
		public Adapter caseAbstractType(AbstractType object) {
			return createAbstractTypeAdapter();
		}
		public Adapter caseAbstractClassifier(AbstractClassifier object) {
			return createAbstractClassifierAdapter();
		}
		public Adapter caseVirtualProcessorSubcomponentType(VirtualProcessorSubcomponentType object) {
			return createVirtualProcessorSubcomponentTypeAdapter();
		}
		public Adapter caseVirtualBusSubcomponentType(VirtualBusSubcomponentType object) {
			return createVirtualBusSubcomponentTypeAdapter();
		}
		public Adapter caseThreadGroupSubcomponentType(ThreadGroupSubcomponentType object) {
			return createThreadGroupSubcomponentTypeAdapter();
		}
		public Adapter caseThreadSubcomponentType(ThreadSubcomponentType object) {
			return createThreadSubcomponentTypeAdapter();
		}
		public Adapter caseSystemSubcomponentType(SystemSubcomponentType object) {
			return createSystemSubcomponentTypeAdapter();
		}
		public Adapter caseProcessSubcomponentType(ProcessSubcomponentType object) {
			return createProcessSubcomponentTypeAdapter();
		}
		public Adapter caseMemorySubcomponentType(MemorySubcomponentType object) {
			return createMemorySubcomponentTypeAdapter();
		}
		public Adapter caseDeviceSubcomponentType(DeviceSubcomponentType object) {
			return createDeviceSubcomponentTypeAdapter();
		}
		public Adapter caseBusSubcomponentType(BusSubcomponentType object) {
			return createBusSubcomponentTypeAdapter();
		}
		public Adapter caseProcessorSubcomponentType(ProcessorSubcomponentType object) {
			return createProcessorSubcomponentTypeAdapter();
		}
		public Adapter caseAbstractImplementation(AbstractImplementation object) {
			return createAbstractImplementationAdapter();
		}
		public Adapter caseBusSubcomponent(BusSubcomponent object) {
			return createBusSubcomponentAdapter();
		}
		public Adapter caseBus(Bus object) {
			return createBusAdapter();
		}
		public Adapter caseDataSubcomponent(DataSubcomponent object) {
			return createDataSubcomponentAdapter();
		}
		public Adapter caseDeviceSubcomponent(DeviceSubcomponent object) {
			return createDeviceSubcomponentAdapter();
		}
		public Adapter caseDevice(Device object) {
			return createDeviceAdapter();
		}
		public Adapter caseMemorySubcomponent(MemorySubcomponent object) {
			return createMemorySubcomponentAdapter();
		}
		public Adapter caseMemory(Memory object) {
			return createMemoryAdapter();
		}
		public Adapter caseProcessSubcomponent(ProcessSubcomponent object) {
			return createProcessSubcomponentAdapter();
		}
		public Adapter caseProcess(org.osate.aadl2.Process object) {
			return createProcessAdapter();
		}
		public Adapter caseProcessorSubcomponent(ProcessorSubcomponent object) {
			return createProcessorSubcomponentAdapter();
		}
		public Adapter caseProcessor(Processor object) {
			return createProcessorAdapter();
		}
		public Adapter caseSystemSubcomponent(SystemSubcomponent object) {
			return createSystemSubcomponentAdapter();
		}
		public Adapter caseSystem(org.osate.aadl2.System object) {
			return createSystemAdapter();
		}
		public Adapter caseSubprogramSubcomponent(SubprogramSubcomponent object) {
			return createSubprogramSubcomponentAdapter();
		}
		public Adapter caseSubprogramGroupSubcomponent(SubprogramGroupSubcomponent object) {
			return createSubprogramGroupSubcomponentAdapter();
		}
		public Adapter caseSubprogramGroup(SubprogramGroup object) {
			return createSubprogramGroupAdapter();
		}
		public Adapter caseThreadSubcomponent(ThreadSubcomponent object) {
			return createThreadSubcomponentAdapter();
		}
		public Adapter caseThread(org.osate.aadl2.Thread object) {
			return createThreadAdapter();
		}
		public Adapter caseThreadGroupSubcomponent(ThreadGroupSubcomponent object) {
			return createThreadGroupSubcomponentAdapter();
		}
		public Adapter caseThreadGroup(org.osate.aadl2.ThreadGroup object) {
			return createThreadGroupAdapter();
		}
		public Adapter caseVirtualBusSubcomponent(VirtualBusSubcomponent object) {
			return createVirtualBusSubcomponentAdapter();
		}
		public Adapter caseVirtualBus(VirtualBus object) {
			return createVirtualBusAdapter();
		}
		public Adapter caseVirtualProcessorSubcomponent(VirtualProcessorSubcomponent object) {
			return createVirtualProcessorSubcomponentAdapter();
		}
		public Adapter caseVirtualProcessor(VirtualProcessor object) {
			return createVirtualProcessorAdapter();
		}
		public Adapter caseAbstractPrototype(AbstractPrototype object) {
			return createAbstractPrototypeAdapter();
		}
		public Adapter caseBusClassifier(BusClassifier object) {
			return createBusClassifierAdapter();
		}
		public Adapter caseBusType(BusType object) {
			return createBusTypeAdapter();
		}
		public Adapter caseBusImplementation(BusImplementation object) {
			return createBusImplementationAdapter();
		}
		public Adapter caseBusPrototype(BusPrototype object) {
			return createBusPrototypeAdapter();
		}
		public Adapter caseDataType(DataType object) {
			return createDataTypeAdapter();
		}
		public Adapter caseDataImplementation(DataImplementation object) {
			return createDataImplementationAdapter();
		}
		public Adapter caseDataPrototype(DataPrototype object) {
			return createDataPrototypeAdapter();
		}
		public Adapter caseDeviceClassifier(DeviceClassifier object) {
			return createDeviceClassifierAdapter();
		}
		public Adapter caseDeviceType(DeviceType object) {
			return createDeviceTypeAdapter();
		}
		public Adapter caseDeviceImplementation(DeviceImplementation object) {
			return createDeviceImplementationAdapter();
		}
		public Adapter caseDevicePrototype(DevicePrototype object) {
			return createDevicePrototypeAdapter();
		}
		public Adapter caseMemoryClassifier(MemoryClassifier object) {
			return createMemoryClassifierAdapter();
		}
		public Adapter caseMemoryType(MemoryType object) {
			return createMemoryTypeAdapter();
		}
		public Adapter caseMemoryImplementation(MemoryImplementation object) {
			return createMemoryImplementationAdapter();
		}
		public Adapter caseMemoryPrototype(MemoryPrototype object) {
			return createMemoryPrototypeAdapter();
		}
		public Adapter caseSubprogramType(SubprogramType object) {
			return createSubprogramTypeAdapter();
		}
		public Adapter caseSubprogramImplementation(SubprogramImplementation object) {
			return createSubprogramImplementationAdapter();
		}
		public Adapter caseSubprogramPrototype(SubprogramPrototype object) {
			return createSubprogramPrototypeAdapter();
		}
		public Adapter caseSubprogramGroupClassifier(SubprogramGroupClassifier object) {
			return createSubprogramGroupClassifierAdapter();
		}
		public Adapter caseSubprogramGroupType(SubprogramGroupType object) {
			return createSubprogramGroupTypeAdapter();
		}
		public Adapter caseSubprogramGroupImplementation(SubprogramGroupImplementation object) {
			return createSubprogramGroupImplementationAdapter();
		}
		public Adapter caseSubprogramGroupPrototype(SubprogramGroupPrototype object) {
			return createSubprogramGroupPrototypeAdapter();
		}
		public Adapter caseSystemClassifier(SystemClassifier object) {
			return createSystemClassifierAdapter();
		}
		public Adapter caseSystemType(SystemType object) {
			return createSystemTypeAdapter();
		}
		public Adapter caseSystemImplementation(SystemImplementation object) {
			return createSystemImplementationAdapter();
		}
		public Adapter caseSystemPrototype(SystemPrototype object) {
			return createSystemPrototypeAdapter();
		}
		public Adapter caseProcessorClassifier(ProcessorClassifier object) {
			return createProcessorClassifierAdapter();
		}
		public Adapter caseProcessorType(ProcessorType object) {
			return createProcessorTypeAdapter();
		}
		public Adapter caseProcessorImplementation(ProcessorImplementation object) {
			return createProcessorImplementationAdapter();
		}
		public Adapter caseProcessorPrototype(ProcessorPrototype object) {
			return createProcessorPrototypeAdapter();
		}
		public Adapter caseProcessClassifier(ProcessClassifier object) {
			return createProcessClassifierAdapter();
		}
		public Adapter caseProcessType(ProcessType object) {
			return createProcessTypeAdapter();
		}
		public Adapter caseProcessImplementation(ProcessImplementation object) {
			return createProcessImplementationAdapter();
		}
		public Adapter caseProcessPrototype(ProcessPrototype object) {
			return createProcessPrototypeAdapter();
		}
		public Adapter caseThreadClassifier(ThreadClassifier object) {
			return createThreadClassifierAdapter();
		}
		public Adapter caseThreadType(ThreadType object) {
			return createThreadTypeAdapter();
		}
		public Adapter caseThreadImplementation(ThreadImplementation object) {
			return createThreadImplementationAdapter();
		}
		public Adapter caseThreadPrototype(ThreadPrototype object) {
			return createThreadPrototypeAdapter();
		}
		public Adapter caseThreadGroupClassifier(ThreadGroupClassifier object) {
			return createThreadGroupClassifierAdapter();
		}
		public Adapter caseThreadGroupType(ThreadGroupType object) {
			return createThreadGroupTypeAdapter();
		}
		public Adapter caseThreadGroupImplementation(ThreadGroupImplementation object) {
			return createThreadGroupImplementationAdapter();
		}
		public Adapter caseThreadGroupPrototype(ThreadGroupPrototype object) {
			return createThreadGroupPrototypeAdapter();
		}
		public Adapter caseVirtualBusClassifier(VirtualBusClassifier object) {
			return createVirtualBusClassifierAdapter();
		}
		public Adapter caseVirtualBusType(VirtualBusType object) {
			return createVirtualBusTypeAdapter();
		}
		public Adapter caseVirtualBusImplementation(VirtualBusImplementation object) {
			return createVirtualBusImplementationAdapter();
		}
		public Adapter caseVirtualBusPrototype(VirtualBusPrototype object) {
			return createVirtualBusPrototypeAdapter();
		}
		public Adapter caseVirtualProcessorClassifier(VirtualProcessorClassifier object) {
			return createVirtualProcessorClassifierAdapter();
		}
		public Adapter caseVirtualProcessorType(VirtualProcessorType object) {
			return createVirtualProcessorTypeAdapter();
		}
		public Adapter caseVirtualProcessorImplementation(VirtualProcessorImplementation object) {
			return createVirtualProcessorImplementationAdapter();
		}
		public Adapter caseVirtualProcessorPrototype(VirtualProcessorPrototype object) {
			return createVirtualProcessorPrototypeAdapter();
		}
		public Adapter caseBasicPropertyAssociation(BasicPropertyAssociation object) {
			return createBasicPropertyAssociationAdapter();
		}
		public Adapter casePropertyConstant(PropertyConstant object) {
			return createPropertyConstantAdapter();
		}
		public Adapter caseStringLiteral(StringLiteral object) {
			return createStringLiteralAdapter();
		}
		public Adapter casePropertyValue(PropertyValue object) {
			return createPropertyValueAdapter();
		}
		public Adapter caseNumberValue(NumberValue object) {
			return createNumberValueAdapter();
		}
		public Adapter caseUnitLiteral(UnitLiteral object) {
			return createUnitLiteralAdapter();
		}
		public Adapter caseEnumerationLiteral(EnumerationLiteral object) {
			return createEnumerationLiteralAdapter();
		}
		public Adapter caseClassifierValue(ClassifierValue object) {
			return createClassifierValueAdapter();
		}
		public Adapter caseReferenceValue(ReferenceValue object) {
			return createReferenceValueAdapter();
		}
		public Adapter caseBooleanLiteral(BooleanLiteral object) {
			return createBooleanLiteralAdapter();
		}
		public Adapter caseRangeValue(RangeValue object) {
			return createRangeValueAdapter();
		}
		public Adapter caseIntegerLiteral(IntegerLiteral object) {
			return createIntegerLiteralAdapter();
		}
		public Adapter caseRealLiteral(RealLiteral object) {
			return createRealLiteralAdapter();
		}
		public Adapter caseOperation(Operation object) {
			return createOperationAdapter();
		}
		public Adapter caseRecordValue(RecordValue object) {
			return createRecordValueAdapter();
		}
		public Adapter caseComputedValue(ComputedValue object) {
			return createComputedValueAdapter();
		}
		public Adapter caseListValue(ListValue object) {
			return createListValueAdapter();
		}
		public Adapter caseNamedValue(NamedValue object) {
			return createNamedValueAdapter();
		}
		public Adapter casePropertySet(PropertySet object) {
			return createPropertySetAdapter();
		}
		public Adapter caseGlobalNamespace(GlobalNamespace object) {
			return createGlobalNamespaceAdapter();
		}
		public Adapter caseNonListType(NonListType object) {
			return createNonListTypeAdapter();
		}
		public Adapter caseAadlBoolean(AadlBoolean object) {
			return createAadlBooleanAdapter();
		}
		public Adapter caseAadlString(AadlString object) {
			return createAadlStringAdapter();
		}
		public Adapter caseAadlInteger(AadlInteger object) {
			return createAadlIntegerAdapter();
		}
		public Adapter caseNumberType(NumberType object) {
			return createNumberTypeAdapter();
		}
		public Adapter caseUnitsType(UnitsType object) {
			return createUnitsTypeAdapter();
		}
		public Adapter caseEnumerationType(EnumerationType object) {
			return createEnumerationTypeAdapter();
		}
		public Adapter caseNumericRange(NumericRange object) {
			return createNumericRangeAdapter();
		}
		public Adapter caseAadlReal(AadlReal object) {
			return createAadlRealAdapter();
		}
		public Adapter caseClassifierType(ClassifierType object) {
			return createClassifierTypeAdapter();
		}
		public Adapter caseRangeType(RangeType object) {
			return createRangeTypeAdapter();
		}
		public Adapter caseRecordType(RecordType object) {
			return createRecordTypeAdapter();
		}
		public Adapter caseRecordField(RecordField object) {
			return createRecordFieldAdapter();
		}
		public Adapter caseReferenceType(ReferenceType object) {
			return createReferenceTypeAdapter();
		}
		public Adapter caseListType(ListType object) {
			return createListTypeAdapter();
		}
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Comment
	 * @generated
	 */
	public Adapter createCommentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Namespace
	 * @generated
	 */
	public Adapter createNamespaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.PropertyAssociation <em>Property Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.PropertyAssociation
	 * @generated
	 */
	public Adapter createPropertyAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.BasicPropertyAssociation <em>Basic Property Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.BasicPropertyAssociation
	 * @generated
	 */
	public Adapter createBasicPropertyAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.TypedElement
	 * @generated
	 */
	public Adapter createTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ClassifierFeature <em>Classifier Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ClassifierFeature
	 * @generated
	 */
	public Adapter createClassifierFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.RefinableElement <em>Refinable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.RefinableElement
	 * @generated
	 */
	public Adapter createRefinableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeatureClassifier <em>Feature Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FeatureClassifier
	 * @generated
	 */
	public Adapter createFeatureClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.BehavioralFeature <em>Behavioral Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.BehavioralFeature
	 * @generated
	 */
	public Adapter createBehavioralFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ArrayDimension <em>Array Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ArrayDimension
	 * @generated
	 */
	public Adapter createArrayDimensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Classifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Classifier
	 * @generated
	 */
	public Adapter createClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Generalization <em>Generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Generalization
	 * @generated
	 */
	public Adapter createGeneralizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DirectedRelationship <em>Directed Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DirectedRelationship
	 * @generated
	 */
	public Adapter createDirectedRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Relationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Relationship
	 * @generated
	 */
	public Adapter createRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Prototype <em>Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Prototype
	 * @generated
	 */
	public Adapter createPrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ComponentClassifier <em>Component Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ComponentClassifier
	 * @generated
	 */
	public Adapter createComponentClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubcomponentType <em>Subcomponent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubcomponentType
	 * @generated
	 */
	public Adapter createSubcomponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Mode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Mode
	 * @generated
	 */
	public Adapter createModeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ModeFeature <em>Mode Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ModeFeature
	 * @generated
	 */
	public Adapter createModeFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ModeTransition <em>Mode Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ModeTransition
	 * @generated
	 */
	public Adapter createModeTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ModeTransitionTrigger <em>Mode Transition Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ModeTransitionTrigger
	 * @generated
	 */
	public Adapter createModeTransitionTriggerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.TriggerPort <em>Trigger Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.TriggerPort
	 * @generated
	 */
	public Adapter createTriggerPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Context
	 * @generated
	 */
	public Adapter createContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Port
	 * @generated
	 */
	public Adapter createPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DirectedFeature <em>Directed Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DirectedFeature
	 * @generated
	 */
	public Adapter createDirectedFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.PrototypeBinding <em>Prototype Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.PrototypeBinding
	 * @generated
	 */
	public Adapter createPrototypeBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ArrayableElement <em>Arrayable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ArrayableElement
	 * @generated
	 */
	public Adapter createArrayableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ArraySize <em>Array Size</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ArraySize
	 * @generated
	 */
	public Adapter createArraySizeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AnnexSubclause <em>Annex Subclause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AnnexSubclause
	 * @generated
	 */
	public Adapter createAnnexSubclauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.StructuralFeature <em>Structural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.StructuralFeature
	 * @generated
	 */
	public Adapter createStructuralFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ModalElement <em>Modal Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ModalElement
	 * @generated
	 */
	public Adapter createModalElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ModeBinding <em>Mode Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ModeBinding
	 * @generated
	 */
	public Adapter createModeBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AbstractSubcomponentType <em>Abstract Subcomponent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AbstractSubcomponentType
	 * @generated
	 */
	public Adapter createAbstractSubcomponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ComponentImplementationReference <em>Component Implementation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ComponentImplementationReference
	 * @generated
	 */
	public Adapter createComponentImplementationReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeatureConnectionEnd <em>Feature Connection End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FeatureConnectionEnd
	 * @generated
	 */
	public Adapter createFeatureConnectionEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Subcomponent <em>Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Subcomponent
	 * @generated
	 */
	public Adapter createSubcomponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.TypeExtension <em>Type Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.TypeExtension
	 * @generated
	 */
	public Adapter createTypeExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ComponentType
	 * @generated
	 */
	public Adapter createComponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Feature
	 * @generated
	 */
	public Adapter createFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FlowSpecification <em>Flow Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FlowSpecification
	 * @generated
	 */
	public Adapter createFlowSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FlowFeature <em>Flow Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FlowFeature
	 * @generated
	 */
	public Adapter createFlowFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Flow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Flow
	 * @generated
	 */
	public Adapter createFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.EndToEndFlowElement <em>End To End Flow Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.EndToEndFlowElement
	 * @generated
	 */
	public Adapter createEndToEndFlowElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FlowEnd <em>Flow End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FlowEnd
	 * @generated
	 */
	public Adapter createFlowEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeatureGroup <em>Feature Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FeatureGroup
	 * @generated
	 */
	public Adapter createFeatureGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeatureGroupConnectionEnd <em>Feature Group Connection End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FeatureGroupConnectionEnd
	 * @generated
	 */
	public Adapter createFeatureGroupConnectionEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeatureType <em>Feature Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FeatureType
	 * @generated
	 */
	public Adapter createFeatureTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.CallContext <em>Call Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.CallContext
	 * @generated
	 */
	public Adapter createCallContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ConnectionEnd <em>Connection End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ConnectionEnd
	 * @generated
	 */
	public Adapter createConnectionEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeatureGroupType <em>Feature Group Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FeatureGroupType
	 * @generated
	 */
	public Adapter createFeatureGroupTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.GroupExtension <em>Group Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.GroupExtension
	 * @generated
	 */
	public Adapter createGroupExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ComponentImplementation <em>Component Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ComponentImplementation
	 * @generated
	 */
	public Adapter createComponentImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FlowImplementation <em>Flow Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FlowImplementation
	 * @generated
	 */
	public Adapter createFlowImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Connection
	 * @generated
	 */
	public Adapter createConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ConnectedElement <em>Connected Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ConnectedElement
	 * @generated
	 */
	public Adapter createConnectedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FlowElement <em>Flow Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FlowElement
	 * @generated
	 */
	public Adapter createFlowElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Realization <em>Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Realization
	 * @generated
	 */
	public Adapter createRealizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AbstractSubcomponent <em>Abstract Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AbstractSubcomponent
	 * @generated
	 */
	public Adapter createAbstractSubcomponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ComponentPrototype <em>Component Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ComponentPrototype
	 * @generated
	 */
	public Adapter createComponentPrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ComponentPrototypeBinding <em>Component Prototype Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ComponentPrototypeBinding
	 * @generated
	 */
	public Adapter createComponentPrototypeBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ComponentPrototypeActual <em>Component Prototype Actual</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ComponentPrototypeActual
	 * @generated
	 */
	public Adapter createComponentPrototypeActualAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeatureGroupPrototype <em>Feature Group Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FeatureGroupPrototype
	 * @generated
	 */
	public Adapter createFeatureGroupPrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeatureGroupPrototypeBinding <em>Feature Group Prototype Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FeatureGroupPrototypeBinding
	 * @generated
	 */
	public Adapter createFeatureGroupPrototypeBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeatureGroupPrototypeActual <em>Feature Group Prototype Actual</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FeatureGroupPrototypeActual
	 * @generated
	 */
	public Adapter createFeatureGroupPrototypeActualAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeaturePrototype <em>Feature Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FeaturePrototype
	 * @generated
	 */
	public Adapter createFeaturePrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeaturePrototypeBinding <em>Feature Prototype Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FeaturePrototypeBinding
	 * @generated
	 */
	public Adapter createFeaturePrototypeBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeaturePrototypeActual <em>Feature Prototype Actual</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FeaturePrototypeActual
	 * @generated
	 */
	public Adapter createFeaturePrototypeActualAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AccessSpecification <em>Access Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AccessSpecification
	 * @generated
	 */
	public Adapter createAccessSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.PortSpecification <em>Port Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.PortSpecification
	 * @generated
	 */
	public Adapter createPortSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeaturePrototypeReference <em>Feature Prototype Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FeaturePrototypeReference
	 * @generated
	 */
	public Adapter createFeaturePrototypeReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Abstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Abstract
	 * @generated
	 */
	public Adapter createAbstractAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AbstractClassifier <em>Abstract Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AbstractClassifier
	 * @generated
	 */
	public Adapter createAbstractClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.EndToEndFlow <em>End To End Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.EndToEndFlow
	 * @generated
	 */
	public Adapter createEndToEndFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.EndToEndFlowSegment <em>End To End Flow Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.EndToEndFlowSegment
	 * @generated
	 */
	public Adapter createEndToEndFlowSegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeatureConnection <em>Feature Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FeatureConnection
	 * @generated
	 */
	public Adapter createFeatureConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.PublicPackageSection <em>Public Package Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.PublicPackageSection
	 * @generated
	 */
	public Adapter createPublicPackageSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.PackageSection <em>Package Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.PackageSection
	 * @generated
	 */
	public Adapter createPackageSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.PackageRename <em>Package Rename</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.PackageRename
	 * @generated
	 */
	public Adapter createPackageRenameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AadlPackage <em>Aadl Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AadlPackage
	 * @generated
	 */
	public Adapter createAadlPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ModelUnit <em>Model Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ModelUnit
	 * @generated
	 */
	public Adapter createModelUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.PrivatePackageSection <em>Private Package Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.PrivatePackageSection
	 * @generated
	 */
	public Adapter createPrivatePackageSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ComponentTypeRename <em>Component Type Rename</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ComponentTypeRename
	 * @generated
	 */
	public Adapter createComponentTypeRenameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeatureGroupTypeRename <em>Feature Group Type Rename</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FeatureGroupTypeRename
	 * @generated
	 */
	public Adapter createFeatureGroupTypeRenameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AnnexLibrary <em>Annex Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AnnexLibrary
	 * @generated
	 */
	public Adapter createAnnexLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.GlobalNamespace <em>Global Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.GlobalNamespace
	 * @generated
	 */
	public Adapter createGlobalNamespaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.NonListType <em>Non List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.NonListType
	 * @generated
	 */
	public Adapter createNonListTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.PropertySet <em>Property Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.PropertySet
	 * @generated
	 */
	public Adapter createPropertySetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.PropertyType <em>Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.PropertyType
	 * @generated
	 */
	public Adapter createPropertyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ContainedNamedElement <em>Contained Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ContainedNamedElement
	 * @generated
	 */
	public Adapter createContainedNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ArrayRange <em>Array Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ArrayRange
	 * @generated
	 */
	public Adapter createArrayRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ModalPropertyValue <em>Modal Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ModalPropertyValue
	 * @generated
	 */
	public Adapter createModalPropertyValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ContainmentPathElement <em>Containment Path Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ContainmentPathElement
	 * @generated
	 */
	public Adapter createContainmentPathElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.PropertyExpression <em>Property Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.PropertyExpression
	 * @generated
	 */
	public Adapter createPropertyExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.BasicProperty <em>Basic Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.BasicProperty
	 * @generated
	 */
	public Adapter createBasicPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.PropertyConstant <em>Property Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.PropertyConstant
	 * @generated
	 */
	public Adapter createPropertyConstantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DefaultAnnexLibrary <em>Default Annex Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DefaultAnnexLibrary
	 * @generated
	 */
	public Adapter createDefaultAnnexLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DefaultAnnexSubclause <em>Default Annex Subclause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DefaultAnnexSubclause
	 * @generated
	 */
	public Adapter createDefaultAnnexSubclauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AbstractFeature <em>Abstract Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AbstractFeature
	 * @generated
	 */
	public Adapter createAbstractFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ModalPath <em>Modal Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ModalPath
	 * @generated
	 */
	public Adapter createModalPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FlowSegment <em>Flow Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FlowSegment
	 * @generated
	 */
	public Adapter createFlowSegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AccessConnection <em>Access Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AccessConnection
	 * @generated
	 */
	public Adapter createAccessConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ParameterConnection <em>Parameter Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ParameterConnection
	 * @generated
	 */
	public Adapter createParameterConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ParameterConnectionEnd <em>Parameter Connection End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ParameterConnectionEnd
	 * @generated
	 */
	public Adapter createParameterConnectionEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.PortConnection <em>Port Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.PortConnection
	 * @generated
	 */
	public Adapter createPortConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.PortConnectionEnd <em>Port Connection End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.PortConnectionEnd
	 * @generated
	 */
	public Adapter createPortConnectionEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AccessConnectionEnd <em>Access Connection End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AccessConnectionEnd
	 * @generated
	 */
	public Adapter createAccessConnectionEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.BusFeatureClassifier <em>Bus Feature Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.BusFeatureClassifier
	 * @generated
	 */
	public Adapter createBusFeatureClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.FeatureGroupConnection <em>Feature Group Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.FeatureGroupConnection
	 * @generated
	 */
	public Adapter createFeatureGroupConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ProcessorFeature <em>Processor Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ProcessorFeature
	 * @generated
	 */
	public Adapter createProcessorFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.InternalFeature <em>Internal Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.InternalFeature
	 * @generated
	 */
	public Adapter createInternalFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.EventSource <em>Event Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.EventSource
	 * @generated
	 */
	public Adapter createEventSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.EventDataSource <em>Event Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.EventDataSource
	 * @generated
	 */
	public Adapter createEventDataSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.PortProxy <em>Port Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.PortProxy
	 * @generated
	 */
	public Adapter createPortProxyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramProxy <em>Subprogram Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramProxy
	 * @generated
	 */
	public Adapter createSubprogramProxyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DataAccess <em>Data Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DataAccess
	 * @generated
	 */
	public Adapter createDataAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DataClassifier <em>Data Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DataClassifier
	 * @generated
	 */
	public Adapter createDataClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DataSubcomponentType <em>Data Subcomponent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DataSubcomponentType
	 * @generated
	 */
	public Adapter createDataSubcomponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AbstractFeatureClassifier <em>Abstract Feature Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AbstractFeatureClassifier
	 * @generated
	 */
	public Adapter createAbstractFeatureClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Data <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Data
	 * @generated
	 */
	public Adapter createDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.BusAccess <em>Bus Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.BusAccess
	 * @generated
	 */
	public Adapter createBusAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Access <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Access
	 * @generated
	 */
	public Adapter createAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.BusClassifier <em>Bus Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.BusClassifier
	 * @generated
	 */
	public Adapter createBusClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.BusSubcomponentType <em>Bus Subcomponent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.BusSubcomponentType
	 * @generated
	 */
	public Adapter createBusSubcomponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Bus <em>Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Bus
	 * @generated
	 */
	public Adapter createBusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramAccess <em>Subprogram Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramAccess
	 * @generated
	 */
	public Adapter createSubprogramAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.CalledSubprogram <em>Called Subprogram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.CalledSubprogram
	 * @generated
	 */
	public Adapter createCalledSubprogramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramClassifier <em>Subprogram Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramClassifier
	 * @generated
	 */
	public Adapter createSubprogramClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramSubcomponentType <em>Subprogram Subcomponent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramSubcomponentType
	 * @generated
	 */
	public Adapter createSubprogramSubcomponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Subprogram <em>Subprogram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Subprogram
	 * @generated
	 */
	public Adapter createSubprogramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DataPort <em>Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DataPort
	 * @generated
	 */
	public Adapter createDataPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.EventPort <em>Event Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.EventPort
	 * @generated
	 */
	public Adapter createEventPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.EventDataPort <em>Event Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.EventDataPort
	 * @generated
	 */
	public Adapter createEventDataPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramGroupAccess <em>Subprogram Group Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramGroupAccess
	 * @generated
	 */
	public Adapter createSubprogramGroupAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramGroupClassifier <em>Subprogram Group Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramGroupClassifier
	 * @generated
	 */
	public Adapter createSubprogramGroupClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramGroupSubcomponentType <em>Subprogram Group Subcomponent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramGroupSubcomponentType
	 * @generated
	 */
	public Adapter createSubprogramGroupSubcomponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramGroup <em>Subprogram Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramGroup
	 * @generated
	 */
	public Adapter createSubprogramGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ImplementationExtension <em>Implementation Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ImplementationExtension
	 * @generated
	 */
	public Adapter createImplementationExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Device <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Device
	 * @generated
	 */
	public Adapter createDeviceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DeviceSubcomponentType <em>Device Subcomponent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DeviceSubcomponentType
	 * @generated
	 */
	public Adapter createDeviceSubcomponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DeviceClassifier <em>Device Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DeviceClassifier
	 * @generated
	 */
	public Adapter createDeviceClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DeviceSubcomponent <em>Device Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DeviceSubcomponent
	 * @generated
	 */
	public Adapter createDeviceSubcomponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DeviceType <em>Device Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DeviceType
	 * @generated
	 */
	public Adapter createDeviceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DeviceImplementation <em>Device Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DeviceImplementation
	 * @generated
	 */
	public Adapter createDeviceImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DevicePrototype <em>Device Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DevicePrototype
	 * @generated
	 */
	public Adapter createDevicePrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.BusSubcomponent <em>Bus Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.BusSubcomponent
	 * @generated
	 */
	public Adapter createBusSubcomponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AbstractType <em>Abstract Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AbstractType
	 * @generated
	 */
	public Adapter createAbstractTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AbstractImplementation <em>Abstract Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AbstractImplementation
	 * @generated
	 */
	public Adapter createAbstractImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.BehavioredImplementation <em>Behaviored Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.BehavioredImplementation
	 * @generated
	 */
	public Adapter createBehavioredImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DataSubcomponent <em>Data Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DataSubcomponent
	 * @generated
	 */
	public Adapter createDataSubcomponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.MemorySubcomponent <em>Memory Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.MemorySubcomponent
	 * @generated
	 */
	public Adapter createMemorySubcomponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Memory <em>Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Memory
	 * @generated
	 */
	public Adapter createMemoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.MemorySubcomponentType <em>Memory Subcomponent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.MemorySubcomponentType
	 * @generated
	 */
	public Adapter createMemorySubcomponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.MemoryClassifier <em>Memory Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.MemoryClassifier
	 * @generated
	 */
	public Adapter createMemoryClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ProcessSubcomponent <em>Process Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ProcessSubcomponent
	 * @generated
	 */
	public Adapter createProcessSubcomponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Process
	 * @generated
	 */
	public Adapter createProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ProcessSubcomponentType <em>Process Subcomponent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ProcessSubcomponentType
	 * @generated
	 */
	public Adapter createProcessSubcomponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ProcessClassifier <em>Process Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ProcessClassifier
	 * @generated
	 */
	public Adapter createProcessClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ProcessorSubcomponent <em>Processor Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ProcessorSubcomponent
	 * @generated
	 */
	public Adapter createProcessorSubcomponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Processor <em>Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Processor
	 * @generated
	 */
	public Adapter createProcessorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ProcessorSubcomponentType <em>Processor Subcomponent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ProcessorSubcomponentType
	 * @generated
	 */
	public Adapter createProcessorSubcomponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ProcessorClassifier <em>Processor Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ProcessorClassifier
	 * @generated
	 */
	public Adapter createProcessorClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SystemSubcomponent <em>System Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SystemSubcomponent
	 * @generated
	 */
	public Adapter createSystemSubcomponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.System
	 * @generated
	 */
	public Adapter createSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SystemSubcomponentType <em>System Subcomponent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SystemSubcomponentType
	 * @generated
	 */
	public Adapter createSystemSubcomponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SystemClassifier <em>System Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SystemClassifier
	 * @generated
	 */
	public Adapter createSystemClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramSubcomponent <em>Subprogram Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramSubcomponent
	 * @generated
	 */
	public Adapter createSubprogramSubcomponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramGroupSubcomponent <em>Subprogram Group Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramGroupSubcomponent
	 * @generated
	 */
	public Adapter createSubprogramGroupSubcomponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ThreadSubcomponent <em>Thread Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ThreadSubcomponent
	 * @generated
	 */
	public Adapter createThreadSubcomponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Thread <em>Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Thread
	 * @generated
	 */
	public Adapter createThreadAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ThreadSubcomponentType <em>Thread Subcomponent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ThreadSubcomponentType
	 * @generated
	 */
	public Adapter createThreadSubcomponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ThreadClassifier <em>Thread Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ThreadClassifier
	 * @generated
	 */
	public Adapter createThreadClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ThreadGroupSubcomponent <em>Thread Group Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ThreadGroupSubcomponent
	 * @generated
	 */
	public Adapter createThreadGroupSubcomponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ThreadGroup <em>Thread Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ThreadGroup
	 * @generated
	 */
	public Adapter createThreadGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ThreadGroupSubcomponentType <em>Thread Group Subcomponent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ThreadGroupSubcomponentType
	 * @generated
	 */
	public Adapter createThreadGroupSubcomponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ThreadGroupClassifier <em>Thread Group Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ThreadGroupClassifier
	 * @generated
	 */
	public Adapter createThreadGroupClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.VirtualBusSubcomponent <em>Virtual Bus Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.VirtualBusSubcomponent
	 * @generated
	 */
	public Adapter createVirtualBusSubcomponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.VirtualBus <em>Virtual Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.VirtualBus
	 * @generated
	 */
	public Adapter createVirtualBusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.VirtualBusClassifier <em>Virtual Bus Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.VirtualBusClassifier
	 * @generated
	 */
	public Adapter createVirtualBusClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.VirtualProcessorSubcomponent <em>Virtual Processor Subcomponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.VirtualProcessorSubcomponent
	 * @generated
	 */
	public Adapter createVirtualProcessorSubcomponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.VirtualProcessor <em>Virtual Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.VirtualProcessor
	 * @generated
	 */
	public Adapter createVirtualProcessorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.VirtualBusSubcomponentType <em>Virtual Bus Subcomponent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.VirtualBusSubcomponentType
	 * @generated
	 */
	public Adapter createVirtualBusSubcomponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.VirtualProcessorSubcomponentType <em>Virtual Processor Subcomponent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.VirtualProcessorSubcomponentType
	 * @generated
	 */
	public Adapter createVirtualProcessorSubcomponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AbstractPrototype <em>Abstract Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AbstractPrototype
	 * @generated
	 */
	public Adapter createAbstractPrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.VirtualProcessorClassifier <em>Virtual Processor Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.VirtualProcessorClassifier
	 * @generated
	 */
	public Adapter createVirtualProcessorClassifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramCallSequence <em>Subprogram Call Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramCallSequence
	 * @generated
	 */
	public Adapter createSubprogramCallSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramCall <em>Subprogram Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramCall
	 * @generated
	 */
	public Adapter createSubprogramCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.BusType <em>Bus Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.BusType
	 * @generated
	 */
	public Adapter createBusTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.BusImplementation <em>Bus Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.BusImplementation
	 * @generated
	 */
	public Adapter createBusImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.BusPrototype <em>Bus Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.BusPrototype
	 * @generated
	 */
	public Adapter createBusPrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DataType
	 * @generated
	 */
	public Adapter createDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DataImplementation <em>Data Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DataImplementation
	 * @generated
	 */
	public Adapter createDataImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.DataPrototype <em>Data Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.DataPrototype
	 * @generated
	 */
	public Adapter createDataPrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.MemoryType <em>Memory Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.MemoryType
	 * @generated
	 */
	public Adapter createMemoryTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.MemoryImplementation <em>Memory Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.MemoryImplementation
	 * @generated
	 */
	public Adapter createMemoryImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.MemoryPrototype <em>Memory Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.MemoryPrototype
	 * @generated
	 */
	public Adapter createMemoryPrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SystemType <em>System Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SystemType
	 * @generated
	 */
	public Adapter createSystemTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SystemImplementation <em>System Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SystemImplementation
	 * @generated
	 */
	public Adapter createSystemImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SystemPrototype <em>System Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SystemPrototype
	 * @generated
	 */
	public Adapter createSystemPrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ThreadType <em>Thread Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ThreadType
	 * @generated
	 */
	public Adapter createThreadTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ThreadImplementation <em>Thread Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ThreadImplementation
	 * @generated
	 */
	public Adapter createThreadImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ThreadPrototype <em>Thread Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ThreadPrototype
	 * @generated
	 */
	public Adapter createThreadPrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ThreadGroupType <em>Thread Group Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ThreadGroupType
	 * @generated
	 */
	public Adapter createThreadGroupTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ThreadGroupImplementation <em>Thread Group Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ThreadGroupImplementation
	 * @generated
	 */
	public Adapter createThreadGroupImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ThreadGroupPrototype <em>Thread Group Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ThreadGroupPrototype
	 * @generated
	 */
	public Adapter createThreadGroupPrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.VirtualBusType <em>Virtual Bus Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.VirtualBusType
	 * @generated
	 */
	public Adapter createVirtualBusTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.VirtualBusImplementation <em>Virtual Bus Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.VirtualBusImplementation
	 * @generated
	 */
	public Adapter createVirtualBusImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.VirtualBusPrototype <em>Virtual Bus Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.VirtualBusPrototype
	 * @generated
	 */
	public Adapter createVirtualBusPrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.VirtualProcessorType <em>Virtual Processor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.VirtualProcessorType
	 * @generated
	 */
	public Adapter createVirtualProcessorTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.VirtualProcessorImplementation <em>Virtual Processor Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.VirtualProcessorImplementation
	 * @generated
	 */
	public Adapter createVirtualProcessorImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.VirtualProcessorPrototype <em>Virtual Processor Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.VirtualProcessorPrototype
	 * @generated
	 */
	public Adapter createVirtualProcessorPrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramGroupType <em>Subprogram Group Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramGroupType
	 * @generated
	 */
	public Adapter createSubprogramGroupTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramGroupImplementation <em>Subprogram Group Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramGroupImplementation
	 * @generated
	 */
	public Adapter createSubprogramGroupImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramGroupPrototype <em>Subprogram Group Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramGroupPrototype
	 * @generated
	 */
	public Adapter createSubprogramGroupPrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ProcessorType <em>Processor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ProcessorType
	 * @generated
	 */
	public Adapter createProcessorTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ProcessorImplementation <em>Processor Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ProcessorImplementation
	 * @generated
	 */
	public Adapter createProcessorImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ProcessorPrototype <em>Processor Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ProcessorPrototype
	 * @generated
	 */
	public Adapter createProcessorPrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ProcessType <em>Process Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ProcessType
	 * @generated
	 */
	public Adapter createProcessTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ProcessImplementation <em>Process Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ProcessImplementation
	 * @generated
	 */
	public Adapter createProcessImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ProcessPrototype <em>Process Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ProcessPrototype
	 * @generated
	 */
	public Adapter createProcessPrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramType <em>Subprogram Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramType
	 * @generated
	 */
	public Adapter createSubprogramTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramImplementation <em>Subprogram Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramImplementation
	 * @generated
	 */
	public Adapter createSubprogramImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.SubprogramPrototype <em>Subprogram Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.SubprogramPrototype
	 * @generated
	 */
	public Adapter createSubprogramPrototypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AbstractNamedValue <em>Abstract Named Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AbstractNamedValue
	 * @generated
	 */
	public Adapter createAbstractNamedValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ArraySizeProperty <em>Array Size Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ArraySizeProperty
	 * @generated
	 */
	public Adapter createArraySizePropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.PropertyValue <em>Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.PropertyValue
	 * @generated
	 */
	public Adapter createPropertyValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.NumberType <em>Number Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.NumberType
	 * @generated
	 */
	public Adapter createNumberTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.UnitsType <em>Units Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.UnitsType
	 * @generated
	 */
	public Adapter createUnitsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AadlInteger <em>Aadl Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AadlInteger
	 * @generated
	 */
	public Adapter createAadlIntegerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AadlReal <em>Aadl Real</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AadlReal
	 * @generated
	 */
	public Adapter createAadlRealAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AadlBoolean <em>Aadl Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AadlBoolean
	 * @generated
	 */
	public Adapter createAadlBooleanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.AadlString <em>Aadl String</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.AadlString
	 * @generated
	 */
	public Adapter createAadlStringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.EnumerationType <em>Enumeration Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.EnumerationType
	 * @generated
	 */
	public Adapter createEnumerationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.NumericRange <em>Numeric Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.NumericRange
	 * @generated
	 */
	public Adapter createNumericRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.EnumerationLiteral <em>Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.EnumerationLiteral
	 * @generated
	 */
	public Adapter createEnumerationLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.UnitLiteral <em>Unit Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.UnitLiteral
	 * @generated
	 */
	public Adapter createUnitLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.StringLiteral
	 * @generated
	 */
	public Adapter createStringLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.NumberValue <em>Number Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.NumberValue
	 * @generated
	 */
	public Adapter createNumberValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ClassifierValue <em>Classifier Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ClassifierValue
	 * @generated
	 */
	public Adapter createClassifierValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ReferenceValue <em>Reference Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ReferenceValue
	 * @generated
	 */
	public Adapter createReferenceValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.BooleanLiteral
	 * @generated
	 */
	public Adapter createBooleanLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.RangeValue <em>Range Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.RangeValue
	 * @generated
	 */
	public Adapter createRangeValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.IntegerLiteral
	 * @generated
	 */
	public Adapter createIntegerLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.RealLiteral <em>Real Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.RealLiteral
	 * @generated
	 */
	public Adapter createRealLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.RecordValue <em>Record Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.RecordValue
	 * @generated
	 */
	public Adapter createRecordValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ComputedValue <em>Computed Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ComputedValue
	 * @generated
	 */
	public Adapter createComputedValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ListValue <em>List Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ListValue
	 * @generated
	 */
	public Adapter createListValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.NamedValue <em>Named Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.NamedValue
	 * @generated
	 */
	public Adapter createNamedValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ClassifierType <em>Classifier Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ClassifierType
	 * @generated
	 */
	public Adapter createClassifierTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.MetaclassReference <em>Metaclass Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.MetaclassReference
	 * @generated
	 */
	public Adapter createMetaclassReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.PropertyOwner <em>Property Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.PropertyOwner
	 * @generated
	 */
	public Adapter createPropertyOwnerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ReferenceType <em>Reference Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ReferenceType
	 * @generated
	 */
	public Adapter createReferenceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.ListType <em>List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.ListType
	 * @generated
	 */
	public Adapter createListTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.RangeType <em>Range Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.RangeType
	 * @generated
	 */
	public Adapter createRangeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.RecordType <em>Record Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.RecordType
	 * @generated
	 */
	public Adapter createRecordTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.RecordField <em>Record Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.RecordField
	 * @generated
	 */
	public Adapter createRecordFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // Aadl2AdapterFactory
