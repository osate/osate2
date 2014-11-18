/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
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
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 * $Id: Aadl2AdapterFactory.java,v 1.81 2011-04-11 13:35:56 lwrage Exp $
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
	@Override
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
		@Override
		public Adapter caseElement(Element object) {
			return createElementAdapter();
		}

		@Override
		public Adapter caseComment(Comment object) {
			return createCommentAdapter();
		}

		@Override
		public Adapter caseType(Type object) {
			return createTypeAdapter();
		}

		@Override
		public Adapter caseNamedElement(NamedElement object) {
			return createNamedElementAdapter();
		}

		@Override
		public Adapter casePropertyAssociation(PropertyAssociation object) {
			return createPropertyAssociationAdapter();
		}

		@Override
		public Adapter caseProperty(Property object) {
			return createPropertyAdapter();
		}

		@Override
		public Adapter caseBasicProperty(BasicProperty object) {
			return createBasicPropertyAdapter();
		}

		@Override
		public Adapter caseTypedElement(TypedElement object) {
			return createTypedElementAdapter();
		}

		@Override
		public Adapter casePropertyType(PropertyType object) {
			return createPropertyTypeAdapter();
		}

		@Override
		public Adapter caseAbstractNamedValue(AbstractNamedValue object) {
			return createAbstractNamedValueAdapter();
		}

		@Override
		public Adapter caseArraySizeProperty(ArraySizeProperty object) {
			return createArraySizePropertyAdapter();
		}

		@Override
		public Adapter casePropertyExpression(PropertyExpression object) {
			return createPropertyExpressionAdapter();
		}

		@Override
		public Adapter caseMetaclassReference(MetaclassReference object) {
			return createMetaclassReferenceAdapter();
		}

		@Override
		public Adapter casePropertyOwner(PropertyOwner object) {
			return createPropertyOwnerAdapter();
		}

		@Override
		public Adapter caseClassifier(Classifier object) {
			return createClassifierAdapter();
		}

		@Override
		public Adapter caseNamespace(Namespace object) {
			return createNamespaceAdapter();
		}

		@Override
		public Adapter caseClassifierFeature(ClassifierFeature object) {
			return createClassifierFeatureAdapter();
		}

		@Override
		public Adapter caseGeneralization(Generalization object) {
			return createGeneralizationAdapter();
		}

		@Override
		public Adapter caseDirectedRelationship(DirectedRelationship object) {
			return createDirectedRelationshipAdapter();
		}

		@Override
		public Adapter caseRelationship(Relationship object) {
			return createRelationshipAdapter();
		}

		@Override
		public Adapter caseAnnexSubclause(AnnexSubclause object) {
			return createAnnexSubclauseAdapter();
		}

		@Override
		public Adapter caseModalElement(ModalElement object) {
			return createModalElementAdapter();
		}

		@Override
		public Adapter caseMode(Mode object) {
			return createModeAdapter();
		}

		@Override
		public Adapter caseModeFeature(ModeFeature object) {
			return createModeFeatureAdapter();
		}

		@Override
		public Adapter casePrototype(Prototype object) {
			return createPrototypeAdapter();
		}

		@Override
		public Adapter caseStructuralFeature(StructuralFeature object) {
			return createStructuralFeatureAdapter();
		}

		@Override
		public Adapter caseRefinableElement(RefinableElement object) {
			return createRefinableElementAdapter();
		}

		@Override
		public Adapter caseCalledSubprogram(CalledSubprogram object) {
			return createCalledSubprogramAdapter();
		}

		@Override
		public Adapter casePrototypeBinding(PrototypeBinding object) {
			return createPrototypeBindingAdapter();
		}

		@Override
		public Adapter caseContainedNamedElement(ContainedNamedElement object) {
			return createContainedNamedElementAdapter();
		}

		@Override
		public Adapter caseContainmentPathElement(ContainmentPathElement object) {
			return createContainmentPathElementAdapter();
		}

		@Override
		public Adapter caseArrayRange(ArrayRange object) {
			return createArrayRangeAdapter();
		}

		@Override
		public Adapter caseModalPropertyValue(ModalPropertyValue object) {
			return createModalPropertyValueAdapter();
		}

		@Override
		public Adapter caseBehavioralFeature(BehavioralFeature object) {
			return createBehavioralFeatureAdapter();
		}

		@Override
		public Adapter caseArrayDimension(ArrayDimension object) {
			return createArrayDimensionAdapter();
		}

		@Override
		public Adapter caseArraySize(ArraySize object) {
			return createArraySizeAdapter();
		}

		@Override
		public Adapter caseArrayableElement(ArrayableElement object) {
			return createArrayableElementAdapter();
		}

		@Override
		public Adapter caseComponentImplementationReference(ComponentImplementationReference object) {
			return createComponentImplementationReferenceAdapter();
		}

		@Override
		public Adapter caseComponentImplementation(ComponentImplementation object) {
			return createComponentImplementationAdapter();
		}

		@Override
		public Adapter caseComponentClassifier(ComponentClassifier object) {
			return createComponentClassifierAdapter();
		}

		@Override
		public Adapter caseSubcomponentType(SubcomponentType object) {
			return createSubcomponentTypeAdapter();
		}

		@Override
		public Adapter caseFeatureClassifier(FeatureClassifier object) {
			return createFeatureClassifierAdapter();
		}

		@Override
		public Adapter caseModeTransition(ModeTransition object) {
			return createModeTransitionAdapter();
		}

		@Override
		public Adapter caseModeTransitionTrigger(ModeTransitionTrigger object) {
			return createModeTransitionTriggerAdapter();
		}

		@Override
		public Adapter caseContext(Context object) {
			return createContextAdapter();
		}

		@Override
		public Adapter caseTriggerPort(TriggerPort object) {
			return createTriggerPortAdapter();
		}

		@Override
		public Adapter caseComponentType(ComponentType object) {
			return createComponentTypeAdapter();
		}

		@Override
		public Adapter caseFeature(Feature object) {
			return createFeatureAdapter();
		}

		@Override
		public Adapter caseFeatureConnectionEnd(FeatureConnectionEnd object) {
			return createFeatureConnectionEndAdapter();
		}

		@Override
		public Adapter caseConnectionEnd(ConnectionEnd object) {
			return createConnectionEndAdapter();
		}

		@Override
		public Adapter caseComponentPrototype(ComponentPrototype object) {
			return createComponentPrototypeAdapter();
		}

		@Override
		public Adapter caseFlowSpecification(FlowSpecification object) {
			return createFlowSpecificationAdapter();
		}

		@Override
		public Adapter caseFlowFeature(FlowFeature object) {
			return createFlowFeatureAdapter();
		}

		@Override
		public Adapter caseFlow(Flow object) {
			return createFlowAdapter();
		}

		@Override
		public Adapter caseModalPath(ModalPath object) {
			return createModalPathAdapter();
		}

		@Override
		public Adapter caseFlowElement(FlowElement object) {
			return createFlowElementAdapter();
		}

		@Override
		public Adapter caseEndToEndFlowElement(EndToEndFlowElement object) {
			return createEndToEndFlowElementAdapter();
		}

		@Override
		public Adapter caseFlowEnd(FlowEnd object) {
			return createFlowEndAdapter();
		}

		@Override
		public Adapter caseTypeExtension(TypeExtension object) {
			return createTypeExtensionAdapter();
		}

		@Override
		public Adapter caseFeatureGroup(FeatureGroup object) {
			return createFeatureGroupAdapter();
		}

		@Override
		public Adapter caseCallContext(CallContext object) {
			return createCallContextAdapter();
		}

		@Override
		public Adapter caseDirectedFeature(DirectedFeature object) {
			return createDirectedFeatureAdapter();
		}

		@Override
		public Adapter caseFeatureGroupConnectionEnd(FeatureGroupConnectionEnd object) {
			return createFeatureGroupConnectionEndAdapter();
		}

		@Override
		public Adapter caseFeatureType(FeatureType object) {
			return createFeatureTypeAdapter();
		}

		@Override
		public Adapter caseFeatureGroupType(FeatureGroupType object) {
			return createFeatureGroupTypeAdapter();
		}

		@Override
		public Adapter caseGroupExtension(GroupExtension object) {
			return createGroupExtensionAdapter();
		}

		@Override
		public Adapter caseBusAccess(BusAccess object) {
			return createBusAccessAdapter();
		}

		@Override
		public Adapter caseAccess(Access object) {
			return createAccessAdapter();
		}

		@Override
		public Adapter caseAccessConnectionEnd(AccessConnectionEnd object) {
			return createAccessConnectionEndAdapter();
		}

		@Override
		public Adapter caseBusSubcomponentType(BusSubcomponentType object) {
			return createBusSubcomponentTypeAdapter();
		}

		@Override
		public Adapter caseDataAccess(DataAccess object) {
			return createDataAccessAdapter();
		}

		@Override
		public Adapter caseParameterConnectionEnd(ParameterConnectionEnd object) {
			return createParameterConnectionEndAdapter();
		}

		@Override
		public Adapter casePortConnectionEnd(PortConnectionEnd object) {
			return createPortConnectionEndAdapter();
		}

		@Override
		public Adapter caseDataSubcomponentType(DataSubcomponentType object) {
			return createDataSubcomponentTypeAdapter();
		}

		@Override
		public Adapter caseDataPort(DataPort object) {
			return createDataPortAdapter();
		}

		@Override
		public Adapter casePort(Port object) {
			return createPortAdapter();
		}

		@Override
		public Adapter caseEventDataPort(EventDataPort object) {
			return createEventDataPortAdapter();
		}

		@Override
		public Adapter caseEventPort(EventPort object) {
			return createEventPortAdapter();
		}

		@Override
		public Adapter caseParameter(Parameter object) {
			return createParameterAdapter();
		}

		@Override
		public Adapter caseSubprogramAccess(SubprogramAccess object) {
			return createSubprogramAccessAdapter();
		}

		@Override
		public Adapter caseSubprogramSubcomponentType(SubprogramSubcomponentType object) {
			return createSubprogramSubcomponentTypeAdapter();
		}

		@Override
		public Adapter caseSubprogramGroupAccess(SubprogramGroupAccess object) {
			return createSubprogramGroupAccessAdapter();
		}

		@Override
		public Adapter caseSubprogramGroupSubcomponentType(SubprogramGroupSubcomponentType object) {
			return createSubprogramGroupSubcomponentTypeAdapter();
		}

		@Override
		public Adapter caseAbstractFeature(AbstractFeature object) {
			return createAbstractFeatureAdapter();
		}

		@Override
		public Adapter caseFeaturePrototype(FeaturePrototype object) {
			return createFeaturePrototypeAdapter();
		}

		@Override
		public Adapter caseFeatureGroupPrototype(FeatureGroupPrototype object) {
			return createFeatureGroupPrototypeAdapter();
		}

		@Override
		public Adapter caseSubcomponent(Subcomponent object) {
			return createSubcomponentAdapter();
		}

		@Override
		public Adapter caseModeBinding(ModeBinding object) {
			return createModeBindingAdapter();
		}

		@Override
		public Adapter caseFlowImplementation(FlowImplementation object) {
			return createFlowImplementationAdapter();
		}

		@Override
		public Adapter caseFlowSegment(FlowSegment object) {
			return createFlowSegmentAdapter();
		}

		@Override
		public Adapter caseConnection(Connection object) {
			return createConnectionAdapter();
		}

		@Override
		public Adapter caseConnectedElement(ConnectedElement object) {
			return createConnectedElementAdapter();
		}

		@Override
		public Adapter caseImplementationExtension(ImplementationExtension object) {
			return createImplementationExtensionAdapter();
		}

		@Override
		public Adapter caseRealization(Realization object) {
			return createRealizationAdapter();
		}

		@Override
		public Adapter caseEndToEndFlow(EndToEndFlow object) {
			return createEndToEndFlowAdapter();
		}

		@Override
		public Adapter caseEndToEndFlowSegment(EndToEndFlowSegment object) {
			return createEndToEndFlowSegmentAdapter();
		}

		@Override
		public Adapter caseAbstractSubcomponent(AbstractSubcomponent object) {
			return createAbstractSubcomponentAdapter();
		}

		@Override
		public Adapter caseAbstract(Abstract object) {
			return createAbstractAdapter();
		}

		@Override
		public Adapter caseAbstractSubcomponentType(AbstractSubcomponentType object) {
			return createAbstractSubcomponentTypeAdapter();
		}

		@Override
		public Adapter caseAccessConnection(AccessConnection object) {
			return createAccessConnectionAdapter();
		}

		@Override
		public Adapter caseParameterConnection(ParameterConnection object) {
			return createParameterConnectionAdapter();
		}

		@Override
		public Adapter casePortConnection(PortConnection object) {
			return createPortConnectionAdapter();
		}

		@Override
		public Adapter caseFeatureConnection(FeatureConnection object) {
			return createFeatureConnectionAdapter();
		}

		@Override
		public Adapter caseFeatureGroupConnection(FeatureGroupConnection object) {
			return createFeatureGroupConnectionAdapter();
		}

		@Override
		public Adapter caseProcessorFeature(ProcessorFeature object) {
			return createProcessorFeatureAdapter();
		}

		@Override
		public Adapter caseInternalFeature(InternalFeature object) {
			return createInternalFeatureAdapter();
		}

		@Override
		public Adapter caseEventSource(EventSource object) {
			return createEventSourceAdapter();
		}

		@Override
		public Adapter caseEventDataSource(EventDataSource object) {
			return createEventDataSourceAdapter();
		}

		@Override
		public Adapter caseDataClassifier(DataClassifier object) {
			return createDataClassifierAdapter();
		}

		@Override
		public Adapter caseData(Data object) {
			return createDataAdapter();
		}

		@Override
		public Adapter casePortProxy(PortProxy object) {
			return createPortProxyAdapter();
		}

		@Override
		public Adapter caseSubprogramProxy(SubprogramProxy object) {
			return createSubprogramProxyAdapter();
		}

		@Override
		public Adapter caseSubprogramClassifier(SubprogramClassifier object) {
			return createSubprogramClassifierAdapter();
		}

		@Override
		public Adapter caseSubprogram(Subprogram object) {
			return createSubprogramAdapter();
		}

		@Override
		public Adapter caseAnnexLibrary(AnnexLibrary object) {
			return createAnnexLibraryAdapter();
		}

		@Override
		public Adapter caseDefaultAnnexLibrary(DefaultAnnexLibrary object) {
			return createDefaultAnnexLibraryAdapter();
		}

		@Override
		public Adapter caseDefaultAnnexSubclause(DefaultAnnexSubclause object) {
			return createDefaultAnnexSubclauseAdapter();
		}

		@Override
		public Adapter casePublicPackageSection(PublicPackageSection object) {
			return createPublicPackageSectionAdapter();
		}

		@Override
		public Adapter casePackageSection(PackageSection object) {
			return createPackageSectionAdapter();
		}

		@Override
		public Adapter casePackageRename(PackageRename object) {
			return createPackageRenameAdapter();
		}

		@Override
		public Adapter caseAadlPackage(AadlPackage object) {
			return createAadlPackageAdapter();
		}

		@Override
		public Adapter caseModelUnit(ModelUnit object) {
			return createModelUnitAdapter();
		}

		@Override
		public Adapter casePrivatePackageSection(PrivatePackageSection object) {
			return createPrivatePackageSectionAdapter();
		}

		@Override
		public Adapter caseComponentTypeRename(ComponentTypeRename object) {
			return createComponentTypeRenameAdapter();
		}

		@Override
		public Adapter caseFeatureGroupTypeRename(FeatureGroupTypeRename object) {
			return createFeatureGroupTypeRenameAdapter();
		}

		@Override
		public Adapter caseComponentPrototypeBinding(ComponentPrototypeBinding object) {
			return createComponentPrototypeBindingAdapter();
		}

		@Override
		public Adapter caseComponentPrototypeActual(ComponentPrototypeActual object) {
			return createComponentPrototypeActualAdapter();
		}

		@Override
		public Adapter caseFeatureGroupPrototypeBinding(FeatureGroupPrototypeBinding object) {
			return createFeatureGroupPrototypeBindingAdapter();
		}

		@Override
		public Adapter caseFeatureGroupPrototypeActual(FeatureGroupPrototypeActual object) {
			return createFeatureGroupPrototypeActualAdapter();
		}

		@Override
		public Adapter caseFeaturePrototypeActual(FeaturePrototypeActual object) {
			return createFeaturePrototypeActualAdapter();
		}

		@Override
		public Adapter caseFeaturePrototypeBinding(FeaturePrototypeBinding object) {
			return createFeaturePrototypeBindingAdapter();
		}

		@Override
		public Adapter caseAccessSpecification(AccessSpecification object) {
			return createAccessSpecificationAdapter();
		}

		@Override
		public Adapter casePortSpecification(PortSpecification object) {
			return createPortSpecificationAdapter();
		}

		@Override
		public Adapter caseFeaturePrototypeReference(FeaturePrototypeReference object) {
			return createFeaturePrototypeReferenceAdapter();
		}

		@Override
		public Adapter caseSubprogramCallSequence(SubprogramCallSequence object) {
			return createSubprogramCallSequenceAdapter();
		}

		@Override
		public Adapter caseSubprogramCall(SubprogramCall object) {
			return createSubprogramCallAdapter();
		}

		@Override
		public Adapter caseBehavioredImplementation(BehavioredImplementation object) {
			return createBehavioredImplementationAdapter();
		}

		@Override
		public Adapter caseAbstractType(AbstractType object) {
			return createAbstractTypeAdapter();
		}

		@Override
		public Adapter caseAbstractClassifier(AbstractClassifier object) {
			return createAbstractClassifierAdapter();
		}

		@Override
		public Adapter caseVirtualProcessorSubcomponentType(VirtualProcessorSubcomponentType object) {
			return createVirtualProcessorSubcomponentTypeAdapter();
		}

		@Override
		public Adapter caseVirtualBusSubcomponentType(VirtualBusSubcomponentType object) {
			return createVirtualBusSubcomponentTypeAdapter();
		}

		@Override
		public Adapter caseThreadGroupSubcomponentType(ThreadGroupSubcomponentType object) {
			return createThreadGroupSubcomponentTypeAdapter();
		}

		@Override
		public Adapter caseThreadSubcomponentType(ThreadSubcomponentType object) {
			return createThreadSubcomponentTypeAdapter();
		}

		@Override
		public Adapter caseSystemSubcomponentType(SystemSubcomponentType object) {
			return createSystemSubcomponentTypeAdapter();
		}

		@Override
		public Adapter caseProcessSubcomponentType(ProcessSubcomponentType object) {
			return createProcessSubcomponentTypeAdapter();
		}

		@Override
		public Adapter caseMemorySubcomponentType(MemorySubcomponentType object) {
			return createMemorySubcomponentTypeAdapter();
		}

		@Override
		public Adapter caseDeviceSubcomponentType(DeviceSubcomponentType object) {
			return createDeviceSubcomponentTypeAdapter();
		}

		@Override
		public Adapter caseProcessorSubcomponentType(ProcessorSubcomponentType object) {
			return createProcessorSubcomponentTypeAdapter();
		}

		@Override
		public Adapter caseAbstractImplementation(AbstractImplementation object) {
			return createAbstractImplementationAdapter();
		}

		@Override
		public Adapter caseBusSubcomponent(BusSubcomponent object) {
			return createBusSubcomponentAdapter();
		}

		@Override
		public Adapter caseBus(Bus object) {
			return createBusAdapter();
		}

		@Override
		public Adapter caseDataSubcomponent(DataSubcomponent object) {
			return createDataSubcomponentAdapter();
		}

		@Override
		public Adapter caseDeviceSubcomponent(DeviceSubcomponent object) {
			return createDeviceSubcomponentAdapter();
		}

		@Override
		public Adapter caseDevice(Device object) {
			return createDeviceAdapter();
		}

		@Override
		public Adapter caseMemorySubcomponent(MemorySubcomponent object) {
			return createMemorySubcomponentAdapter();
		}

		@Override
		public Adapter caseMemory(Memory object) {
			return createMemoryAdapter();
		}

		@Override
		public Adapter caseProcessSubcomponent(ProcessSubcomponent object) {
			return createProcessSubcomponentAdapter();
		}

		@Override
		public Adapter caseProcess(org.osate.aadl2.Process object) {
			return createProcessAdapter();
		}

		@Override
		public Adapter caseProcessorSubcomponent(ProcessorSubcomponent object) {
			return createProcessorSubcomponentAdapter();
		}

		@Override
		public Adapter caseProcessor(Processor object) {
			return createProcessorAdapter();
		}

		@Override
		public Adapter caseSystemSubcomponent(SystemSubcomponent object) {
			return createSystemSubcomponentAdapter();
		}

		@Override
		public Adapter caseSystem(org.osate.aadl2.System object) {
			return createSystemAdapter();
		}

		@Override
		public Adapter caseSubprogramSubcomponent(SubprogramSubcomponent object) {
			return createSubprogramSubcomponentAdapter();
		}

		@Override
		public Adapter caseSubprogramGroupSubcomponent(SubprogramGroupSubcomponent object) {
			return createSubprogramGroupSubcomponentAdapter();
		}

		@Override
		public Adapter caseSubprogramGroup(SubprogramGroup object) {
			return createSubprogramGroupAdapter();
		}

		@Override
		public Adapter caseThreadSubcomponent(ThreadSubcomponent object) {
			return createThreadSubcomponentAdapter();
		}

		@Override
		public Adapter caseThread(org.osate.aadl2.Thread object) {
			return createThreadAdapter();
		}

		@Override
		public Adapter caseThreadGroupSubcomponent(ThreadGroupSubcomponent object) {
			return createThreadGroupSubcomponentAdapter();
		}

		@Override
		public Adapter caseThreadGroup(org.osate.aadl2.ThreadGroup object) {
			return createThreadGroupAdapter();
		}

		@Override
		public Adapter caseVirtualBusSubcomponent(VirtualBusSubcomponent object) {
			return createVirtualBusSubcomponentAdapter();
		}

		@Override
		public Adapter caseVirtualBus(VirtualBus object) {
			return createVirtualBusAdapter();
		}

		@Override
		public Adapter caseVirtualProcessorSubcomponent(VirtualProcessorSubcomponent object) {
			return createVirtualProcessorSubcomponentAdapter();
		}

		@Override
		public Adapter caseVirtualProcessor(VirtualProcessor object) {
			return createVirtualProcessorAdapter();
		}

		@Override
		public Adapter caseAbstractPrototype(AbstractPrototype object) {
			return createAbstractPrototypeAdapter();
		}

		@Override
		public Adapter caseBusClassifier(BusClassifier object) {
			return createBusClassifierAdapter();
		}

		@Override
		public Adapter caseBusType(BusType object) {
			return createBusTypeAdapter();
		}

		@Override
		public Adapter caseBusImplementation(BusImplementation object) {
			return createBusImplementationAdapter();
		}

		@Override
		public Adapter caseBusPrototype(BusPrototype object) {
			return createBusPrototypeAdapter();
		}

		@Override
		public Adapter caseDataType(DataType object) {
			return createDataTypeAdapter();
		}

		@Override
		public Adapter caseDataImplementation(DataImplementation object) {
			return createDataImplementationAdapter();
		}

		@Override
		public Adapter caseDataPrototype(DataPrototype object) {
			return createDataPrototypeAdapter();
		}

		@Override
		public Adapter caseDeviceClassifier(DeviceClassifier object) {
			return createDeviceClassifierAdapter();
		}

		@Override
		public Adapter caseDeviceType(DeviceType object) {
			return createDeviceTypeAdapter();
		}

		@Override
		public Adapter caseDeviceImplementation(DeviceImplementation object) {
			return createDeviceImplementationAdapter();
		}

		@Override
		public Adapter caseDevicePrototype(DevicePrototype object) {
			return createDevicePrototypeAdapter();
		}

		@Override
		public Adapter caseMemoryClassifier(MemoryClassifier object) {
			return createMemoryClassifierAdapter();
		}

		@Override
		public Adapter caseMemoryType(MemoryType object) {
			return createMemoryTypeAdapter();
		}

		@Override
		public Adapter caseMemoryImplementation(MemoryImplementation object) {
			return createMemoryImplementationAdapter();
		}

		@Override
		public Adapter caseMemoryPrototype(MemoryPrototype object) {
			return createMemoryPrototypeAdapter();
		}

		@Override
		public Adapter caseSubprogramType(SubprogramType object) {
			return createSubprogramTypeAdapter();
		}

		@Override
		public Adapter caseSubprogramImplementation(SubprogramImplementation object) {
			return createSubprogramImplementationAdapter();
		}

		@Override
		public Adapter caseSubprogramPrototype(SubprogramPrototype object) {
			return createSubprogramPrototypeAdapter();
		}

		@Override
		public Adapter caseSubprogramGroupClassifier(SubprogramGroupClassifier object) {
			return createSubprogramGroupClassifierAdapter();
		}

		@Override
		public Adapter caseSubprogramGroupType(SubprogramGroupType object) {
			return createSubprogramGroupTypeAdapter();
		}

		@Override
		public Adapter caseSubprogramGroupImplementation(SubprogramGroupImplementation object) {
			return createSubprogramGroupImplementationAdapter();
		}

		@Override
		public Adapter caseSubprogramGroupPrototype(SubprogramGroupPrototype object) {
			return createSubprogramGroupPrototypeAdapter();
		}

		@Override
		public Adapter caseSystemClassifier(SystemClassifier object) {
			return createSystemClassifierAdapter();
		}

		@Override
		public Adapter caseSystemType(SystemType object) {
			return createSystemTypeAdapter();
		}

		@Override
		public Adapter caseSystemImplementation(SystemImplementation object) {
			return createSystemImplementationAdapter();
		}

		@Override
		public Adapter caseSystemPrototype(SystemPrototype object) {
			return createSystemPrototypeAdapter();
		}

		@Override
		public Adapter caseProcessorClassifier(ProcessorClassifier object) {
			return createProcessorClassifierAdapter();
		}

		@Override
		public Adapter caseProcessorType(ProcessorType object) {
			return createProcessorTypeAdapter();
		}

		@Override
		public Adapter caseProcessorImplementation(ProcessorImplementation object) {
			return createProcessorImplementationAdapter();
		}

		@Override
		public Adapter caseProcessorPrototype(ProcessorPrototype object) {
			return createProcessorPrototypeAdapter();
		}

		@Override
		public Adapter caseProcessClassifier(ProcessClassifier object) {
			return createProcessClassifierAdapter();
		}

		@Override
		public Adapter caseProcessType(ProcessType object) {
			return createProcessTypeAdapter();
		}

		@Override
		public Adapter caseProcessImplementation(ProcessImplementation object) {
			return createProcessImplementationAdapter();
		}

		@Override
		public Adapter caseProcessPrototype(ProcessPrototype object) {
			return createProcessPrototypeAdapter();
		}

		@Override
		public Adapter caseThreadClassifier(ThreadClassifier object) {
			return createThreadClassifierAdapter();
		}

		@Override
		public Adapter caseThreadType(ThreadType object) {
			return createThreadTypeAdapter();
		}

		@Override
		public Adapter caseThreadImplementation(ThreadImplementation object) {
			return createThreadImplementationAdapter();
		}

		@Override
		public Adapter caseThreadPrototype(ThreadPrototype object) {
			return createThreadPrototypeAdapter();
		}

		@Override
		public Adapter caseThreadGroupClassifier(ThreadGroupClassifier object) {
			return createThreadGroupClassifierAdapter();
		}

		@Override
		public Adapter caseThreadGroupType(ThreadGroupType object) {
			return createThreadGroupTypeAdapter();
		}

		@Override
		public Adapter caseThreadGroupImplementation(ThreadGroupImplementation object) {
			return createThreadGroupImplementationAdapter();
		}

		@Override
		public Adapter caseThreadGroupPrototype(ThreadGroupPrototype object) {
			return createThreadGroupPrototypeAdapter();
		}

		@Override
		public Adapter caseVirtualBusClassifier(VirtualBusClassifier object) {
			return createVirtualBusClassifierAdapter();
		}

		@Override
		public Adapter caseVirtualBusType(VirtualBusType object) {
			return createVirtualBusTypeAdapter();
		}

		@Override
		public Adapter caseVirtualBusImplementation(VirtualBusImplementation object) {
			return createVirtualBusImplementationAdapter();
		}

		@Override
		public Adapter caseVirtualBusPrototype(VirtualBusPrototype object) {
			return createVirtualBusPrototypeAdapter();
		}

		@Override
		public Adapter caseVirtualProcessorClassifier(VirtualProcessorClassifier object) {
			return createVirtualProcessorClassifierAdapter();
		}

		@Override
		public Adapter caseVirtualProcessorType(VirtualProcessorType object) {
			return createVirtualProcessorTypeAdapter();
		}

		@Override
		public Adapter caseVirtualProcessorImplementation(VirtualProcessorImplementation object) {
			return createVirtualProcessorImplementationAdapter();
		}

		@Override
		public Adapter caseVirtualProcessorPrototype(VirtualProcessorPrototype object) {
			return createVirtualProcessorPrototypeAdapter();
		}

		@Override
		public Adapter caseBasicPropertyAssociation(BasicPropertyAssociation object) {
			return createBasicPropertyAssociationAdapter();
		}

		@Override
		public Adapter casePropertyConstant(PropertyConstant object) {
			return createPropertyConstantAdapter();
		}

		@Override
		public Adapter caseStringLiteral(StringLiteral object) {
			return createStringLiteralAdapter();
		}

		@Override
		public Adapter casePropertyValue(PropertyValue object) {
			return createPropertyValueAdapter();
		}

		@Override
		public Adapter caseNumberValue(NumberValue object) {
			return createNumberValueAdapter();
		}

		@Override
		public Adapter caseUnitLiteral(UnitLiteral object) {
			return createUnitLiteralAdapter();
		}

		@Override
		public Adapter caseEnumerationLiteral(EnumerationLiteral object) {
			return createEnumerationLiteralAdapter();
		}

		@Override
		public Adapter caseClassifierValue(ClassifierValue object) {
			return createClassifierValueAdapter();
		}

		@Override
		public Adapter caseReferenceValue(ReferenceValue object) {
			return createReferenceValueAdapter();
		}

		@Override
		public Adapter caseBooleanLiteral(BooleanLiteral object) {
			return createBooleanLiteralAdapter();
		}

		@Override
		public Adapter caseRangeValue(RangeValue object) {
			return createRangeValueAdapter();
		}

		@Override
		public Adapter caseIntegerLiteral(IntegerLiteral object) {
			return createIntegerLiteralAdapter();
		}

		@Override
		public Adapter caseRealLiteral(RealLiteral object) {
			return createRealLiteralAdapter();
		}

		@Override
		public Adapter caseOperation(Operation object) {
			return createOperationAdapter();
		}

		@Override
		public Adapter caseRecordValue(RecordValue object) {
			return createRecordValueAdapter();
		}

		@Override
		public Adapter caseComputedValue(ComputedValue object) {
			return createComputedValueAdapter();
		}

		@Override
		public Adapter caseListValue(ListValue object) {
			return createListValueAdapter();
		}

		@Override
		public Adapter caseNamedValue(NamedValue object) {
			return createNamedValueAdapter();
		}

		@Override
		public Adapter casePropertySet(PropertySet object) {
			return createPropertySetAdapter();
		}

		@Override
		public Adapter caseGlobalNamespace(GlobalNamespace object) {
			return createGlobalNamespaceAdapter();
		}

		@Override
		public Adapter caseNonListType(NonListType object) {
			return createNonListTypeAdapter();
		}

		@Override
		public Adapter caseAadlBoolean(AadlBoolean object) {
			return createAadlBooleanAdapter();
		}

		@Override
		public Adapter caseAadlString(AadlString object) {
			return createAadlStringAdapter();
		}

		@Override
		public Adapter caseAadlInteger(AadlInteger object) {
			return createAadlIntegerAdapter();
		}

		@Override
		public Adapter caseNumberType(NumberType object) {
			return createNumberTypeAdapter();
		}

		@Override
		public Adapter caseUnitsType(UnitsType object) {
			return createUnitsTypeAdapter();
		}

		@Override
		public Adapter caseEnumerationType(EnumerationType object) {
			return createEnumerationTypeAdapter();
		}

		@Override
		public Adapter caseNumericRange(NumericRange object) {
			return createNumericRangeAdapter();
		}

		@Override
		public Adapter caseAadlReal(AadlReal object) {
			return createAadlRealAdapter();
		}

		@Override
		public Adapter caseClassifierType(ClassifierType object) {
			return createClassifierTypeAdapter();
		}

		@Override
		public Adapter caseRangeType(RangeType object) {
			return createRangeTypeAdapter();
		}

		@Override
		public Adapter caseRecordType(RecordType object) {
			return createRecordTypeAdapter();
		}

		@Override
		public Adapter caseRecordField(RecordField object) {
			return createRecordFieldAdapter();
		}

		@Override
		public Adapter caseReferenceType(ReferenceType object) {
			return createReferenceTypeAdapter();
		}

		@Override
		public Adapter caseListType(ListType object) {
			return createListTypeAdapter();
		}

		@Override
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
	@Override
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
