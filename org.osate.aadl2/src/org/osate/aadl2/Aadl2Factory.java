/**
 * <copyright>
 * Copyright  2011 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
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
 */
package org.osate.aadl2;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.Aadl2Package
 * @generated
 */
public interface Aadl2Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Aadl2Factory eINSTANCE = org.osate.aadl2.impl.Aadl2FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comment</em>'.
	 * @generated
	 */
	Comment createComment();

	/**
	 * Returns a new object of class '<em>Property Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Association</em>'.
	 * @generated
	 */
	PropertyAssociation createPropertyAssociation();

	/**
	 * Returns a new object of class '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property</em>'.
	 * @generated
	 */
	Property createProperty();

	/**
	 * Returns a new object of class '<em>Basic Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Property</em>'.
	 * @generated
	 */
	BasicProperty createBasicProperty();

	/**
	 * Returns a new object of class '<em>Metaclass Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metaclass Reference</em>'.
	 * @generated
	 */
	MetaclassReference createMetaclassReference();

	/**
	 * Returns a new object of class '<em>Modal Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modal Element</em>'.
	 * @generated
	 */
	ModalElement createModalElement();

	/**
	 * Returns a new object of class '<em>Mode</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mode</em>'.
	 * @generated
	 */
	Mode createMode();

	/**
	 * Returns a new object of class '<em>Contained Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contained Named Element</em>'.
	 * @generated
	 */
	ContainedNamedElement createContainedNamedElement();

	/**
	 * Returns a new object of class '<em>Containment Path Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Containment Path Element</em>'.
	 * @generated
	 */
	ContainmentPathElement createContainmentPathElement();

	/**
	 * Returns a new object of class '<em>Array Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Range</em>'.
	 * @generated
	 */
	ArrayRange createArrayRange();

	/**
	 * Returns a new object of class '<em>Modal Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modal Property Value</em>'.
	 * @generated
	 */
	ModalPropertyValue createModalPropertyValue();

	/**
	 * Returns a new object of class '<em>Array Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Dimension</em>'.
	 * @generated
	 */
	ArrayDimension createArrayDimension();

	/**
	 * Returns a new object of class '<em>Array Size</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Size</em>'.
	 * @generated
	 */
	ArraySize createArraySize();

	/**
	 * Returns a new object of class '<em>Component Implementation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Implementation Reference</em>'.
	 * @generated
	 */
	ComponentImplementationReference createComponentImplementationReference();

	/**
	 * Returns a new object of class '<em>Mode Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mode Transition</em>'.
	 * @generated
	 */
	ModeTransition createModeTransition();

	/**
	 * Returns a new object of class '<em>Mode Transition Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mode Transition Trigger</em>'.
	 * @generated
	 */
	ModeTransitionTrigger createModeTransitionTrigger();

	/**
	 * Returns a new object of class '<em>Flow Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow Specification</em>'.
	 * @generated
	 */
	FlowSpecification createFlowSpecification();

	/**
	 * Returns a new object of class '<em>Flow End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow End</em>'.
	 * @generated
	 */
	FlowEnd createFlowEnd();

	/**
	 * Returns a new object of class '<em>Type Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Extension</em>'.
	 * @generated
	 */
	TypeExtension createTypeExtension();

	/**
	 * Returns a new object of class '<em>Feature Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Group</em>'.
	 * @generated
	 */
	FeatureGroup createFeatureGroup();

	/**
	 * Returns a new object of class '<em>Feature Group Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Group Type</em>'.
	 * @generated
	 */
	FeatureGroupType createFeatureGroupType();

	/**
	 * Returns a new object of class '<em>Group Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Group Extension</em>'.
	 * @generated
	 */
	GroupExtension createGroupExtension();

	/**
	 * Returns a new object of class '<em>Bus Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bus Access</em>'.
	 * @generated
	 */
	BusAccess createBusAccess();

	/**
	 * Returns a new object of class '<em>Data Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Access</em>'.
	 * @generated
	 */
	DataAccess createDataAccess();

	/**
	 * Returns a new object of class '<em>Data Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Port</em>'.
	 * @generated
	 */
	DataPort createDataPort();

	/**
	 * Returns a new object of class '<em>Event Data Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Data Port</em>'.
	 * @generated
	 */
	EventDataPort createEventDataPort();

	/**
	 * Returns a new object of class '<em>Event Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Port</em>'.
	 * @generated
	 */
	EventPort createEventPort();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Subprogram Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subprogram Access</em>'.
	 * @generated
	 */
	SubprogramAccess createSubprogramAccess();

	/**
	 * Returns a new object of class '<em>Subprogram Group Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subprogram Group Access</em>'.
	 * @generated
	 */
	SubprogramGroupAccess createSubprogramGroupAccess();

	/**
	 * Returns a new object of class '<em>Abstract Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Feature</em>'.
	 * @generated
	 */
	AbstractFeature createAbstractFeature();

	/**
	 * Returns a new object of class '<em>Mode Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mode Binding</em>'.
	 * @generated
	 */
	ModeBinding createModeBinding();

	/**
	 * Returns a new object of class '<em>Flow Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow Implementation</em>'.
	 * @generated
	 */
	FlowImplementation createFlowImplementation();

	/**
	 * Returns a new object of class '<em>Flow Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow Segment</em>'.
	 * @generated
	 */
	FlowSegment createFlowSegment();

	/**
	 * Returns a new object of class '<em>Connected Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connected Element</em>'.
	 * @generated
	 */
	ConnectedElement createConnectedElement();

	/**
	 * Returns a new object of class '<em>Implementation Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implementation Extension</em>'.
	 * @generated
	 */
	ImplementationExtension createImplementationExtension();

	/**
	 * Returns a new object of class '<em>Realization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Realization</em>'.
	 * @generated
	 */
	Realization createRealization();

	/**
	 * Returns a new object of class '<em>End To End Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End To End Flow</em>'.
	 * @generated
	 */
	EndToEndFlow createEndToEndFlow();

	/**
	 * Returns a new object of class '<em>End To End Flow Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End To End Flow Segment</em>'.
	 * @generated
	 */
	EndToEndFlowSegment createEndToEndFlowSegment();

	/**
	 * Returns a new object of class '<em>Abstract Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Subcomponent</em>'.
	 * @generated
	 */
	AbstractSubcomponent createAbstractSubcomponent();

	/**
	 * Returns a new object of class '<em>Access Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Access Connection</em>'.
	 * @generated
	 */
	AccessConnection createAccessConnection();

	/**
	 * Returns a new object of class '<em>Parameter Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Connection</em>'.
	 * @generated
	 */
	ParameterConnection createParameterConnection();

	/**
	 * Returns a new object of class '<em>Port Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Connection</em>'.
	 * @generated
	 */
	PortConnection createPortConnection();

	/**
	 * Returns a new object of class '<em>Feature Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Connection</em>'.
	 * @generated
	 */
	FeatureConnection createFeatureConnection();

	/**
	 * Returns a new object of class '<em>Feature Group Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Group Connection</em>'.
	 * @generated
	 */
	FeatureGroupConnection createFeatureGroupConnection();

	/**
	 * Returns a new object of class '<em>Event Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Source</em>'.
	 * @generated
	 */
	EventSource createEventSource();

	/**
	 * Returns a new object of class '<em>Event Data Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Data Source</em>'.
	 * @generated
	 */
	EventDataSource createEventDataSource();

	/**
	 * Returns a new object of class '<em>Port Proxy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Proxy</em>'.
	 * @generated
	 */
	PortProxy createPortProxy();

	/**
	 * Returns a new object of class '<em>Subprogram Proxy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subprogram Proxy</em>'.
	 * @generated
	 */
	SubprogramProxy createSubprogramProxy();

	/**
	 * Returns a new object of class '<em>Default Annex Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Annex Library</em>'.
	 * @generated
	 */
	DefaultAnnexLibrary createDefaultAnnexLibrary();

	/**
	 * Returns a new object of class '<em>Default Annex Subclause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Annex Subclause</em>'.
	 * @generated
	 */
	DefaultAnnexSubclause createDefaultAnnexSubclause();

	/**
	 * Returns a new object of class '<em>Public Package Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Public Package Section</em>'.
	 * @generated
	 */
	PublicPackageSection createPublicPackageSection();

	/**
	 * Returns a new object of class '<em>Package Rename</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package Rename</em>'.
	 * @generated
	 */
	PackageRename createPackageRename();

	/**
	 * Returns a new object of class '<em>Aadl Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aadl Package</em>'.
	 * @generated
	 */
	AadlPackage createAadlPackage();

	/**
	 * Returns a new object of class '<em>Private Package Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Private Package Section</em>'.
	 * @generated
	 */
	PrivatePackageSection createPrivatePackageSection();

	/**
	 * Returns a new object of class '<em>Component Type Rename</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Type Rename</em>'.
	 * @generated
	 */
	ComponentTypeRename createComponentTypeRename();

	/**
	 * Returns a new object of class '<em>Feature Group Type Rename</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Group Type Rename</em>'.
	 * @generated
	 */
	FeatureGroupTypeRename createFeatureGroupTypeRename();

	/**
	 * Returns a new object of class '<em>Abstract Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Type</em>'.
	 * @generated
	 */
	AbstractType createAbstractType();

	/**
	 * Returns a new object of class '<em>Abstract Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Implementation</em>'.
	 * @generated
	 */
	AbstractImplementation createAbstractImplementation();

	/**
	 * Returns a new object of class '<em>Subprogram Call Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subprogram Call Sequence</em>'.
	 * @generated
	 */
	SubprogramCallSequence createSubprogramCallSequence();

	/**
	 * Returns a new object of class '<em>Bus Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bus Subcomponent</em>'.
	 * @generated
	 */
	BusSubcomponent createBusSubcomponent();

	/**
	 * Returns a new object of class '<em>Data Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Subcomponent</em>'.
	 * @generated
	 */
	DataSubcomponent createDataSubcomponent();

	/**
	 * Returns a new object of class '<em>Device Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Device Subcomponent</em>'.
	 * @generated
	 */
	DeviceSubcomponent createDeviceSubcomponent();

	/**
	 * Returns a new object of class '<em>Memory Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Subcomponent</em>'.
	 * @generated
	 */
	MemorySubcomponent createMemorySubcomponent();

	/**
	 * Returns a new object of class '<em>Process Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Subcomponent</em>'.
	 * @generated
	 */
	ProcessSubcomponent createProcessSubcomponent();

	/**
	 * Returns a new object of class '<em>Processor Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Processor Subcomponent</em>'.
	 * @generated
	 */
	ProcessorSubcomponent createProcessorSubcomponent();

	/**
	 * Returns a new object of class '<em>System Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Subcomponent</em>'.
	 * @generated
	 */
	SystemSubcomponent createSystemSubcomponent();

	/**
	 * Returns a new object of class '<em>Subprogram Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subprogram Subcomponent</em>'.
	 * @generated
	 */
	SubprogramSubcomponent createSubprogramSubcomponent();

	/**
	 * Returns a new object of class '<em>Subprogram Group Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subprogram Group Subcomponent</em>'.
	 * @generated
	 */
	SubprogramGroupSubcomponent createSubprogramGroupSubcomponent();

	/**
	 * Returns a new object of class '<em>Thread Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thread Subcomponent</em>'.
	 * @generated
	 */
	ThreadSubcomponent createThreadSubcomponent();

	/**
	 * Returns a new object of class '<em>Thread Group Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thread Group Subcomponent</em>'.
	 * @generated
	 */
	ThreadGroupSubcomponent createThreadGroupSubcomponent();

	/**
	 * Returns a new object of class '<em>Virtual Bus Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Bus Subcomponent</em>'.
	 * @generated
	 */
	VirtualBusSubcomponent createVirtualBusSubcomponent();

	/**
	 * Returns a new object of class '<em>Virtual Processor Subcomponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Processor Subcomponent</em>'.
	 * @generated
	 */
	VirtualProcessorSubcomponent createVirtualProcessorSubcomponent();

	/**
	 * Returns a new object of class '<em>Abstract Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Prototype</em>'.
	 * @generated
	 */
	AbstractPrototype createAbstractPrototype();

	/**
	 * Returns a new object of class '<em>Bus Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bus Type</em>'.
	 * @generated
	 */
	BusType createBusType();

	/**
	 * Returns a new object of class '<em>Bus Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bus Implementation</em>'.
	 * @generated
	 */
	BusImplementation createBusImplementation();

	/**
	 * Returns a new object of class '<em>Bus Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bus Prototype</em>'.
	 * @generated
	 */
	BusPrototype createBusPrototype();

	/**
	 * Returns a new object of class '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type</em>'.
	 * @generated
	 */
	DataType createDataType();

	/**
	 * Returns a new object of class '<em>Data Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Implementation</em>'.
	 * @generated
	 */
	DataImplementation createDataImplementation();

	/**
	 * Returns a new object of class '<em>Data Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Prototype</em>'.
	 * @generated
	 */
	DataPrototype createDataPrototype();

	/**
	 * Returns a new object of class '<em>Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Device Type</em>'.
	 * @generated
	 */
	DeviceType createDeviceType();

	/**
	 * Returns a new object of class '<em>Device Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Device Implementation</em>'.
	 * @generated
	 */
	DeviceImplementation createDeviceImplementation();

	/**
	 * Returns a new object of class '<em>Device Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Device Prototype</em>'.
	 * @generated
	 */
	DevicePrototype createDevicePrototype();

	/**
	 * Returns a new object of class '<em>Memory Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Type</em>'.
	 * @generated
	 */
	MemoryType createMemoryType();

	/**
	 * Returns a new object of class '<em>Memory Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Implementation</em>'.
	 * @generated
	 */
	MemoryImplementation createMemoryImplementation();

	/**
	 * Returns a new object of class '<em>Memory Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Prototype</em>'.
	 * @generated
	 */
	MemoryPrototype createMemoryPrototype();

	/**
	 * Returns a new object of class '<em>Process Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Type</em>'.
	 * @generated
	 */
	ProcessType createProcessType();

	/**
	 * Returns a new object of class '<em>Processor Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Processor Type</em>'.
	 * @generated
	 */
	ProcessorType createProcessorType();

	/**
	 * Returns a new object of class '<em>Process Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Implementation</em>'.
	 * @generated
	 */
	ProcessImplementation createProcessImplementation();

	/**
	 * Returns a new object of class '<em>Process Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Prototype</em>'.
	 * @generated
	 */
	ProcessPrototype createProcessPrototype();

	/**
	 * Returns a new object of class '<em>Processor Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Processor Implementation</em>'.
	 * @generated
	 */
	ProcessorImplementation createProcessorImplementation();

	/**
	 * Returns a new object of class '<em>Processor Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Processor Prototype</em>'.
	 * @generated
	 */
	ProcessorPrototype createProcessorPrototype();

	/**
	 * Returns a new object of class '<em>Subprogram Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subprogram Type</em>'.
	 * @generated
	 */
	SubprogramType createSubprogramType();

	/**
	 * Returns a new object of class '<em>Subprogram Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subprogram Implementation</em>'.
	 * @generated
	 */
	SubprogramImplementation createSubprogramImplementation();

	/**
	 * Returns a new object of class '<em>Subprogram Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subprogram Prototype</em>'.
	 * @generated
	 */
	SubprogramPrototype createSubprogramPrototype();

	/**
	 * Returns a new object of class '<em>Subprogram Group Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subprogram Group Type</em>'.
	 * @generated
	 */
	SubprogramGroupType createSubprogramGroupType();

	/**
	 * Returns a new object of class '<em>Subprogram Group Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subprogram Group Implementation</em>'.
	 * @generated
	 */
	SubprogramGroupImplementation createSubprogramGroupImplementation();

	/**
	 * Returns a new object of class '<em>Subprogram Group Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subprogram Group Prototype</em>'.
	 * @generated
	 */
	SubprogramGroupPrototype createSubprogramGroupPrototype();

	/**
	 * Returns a new object of class '<em>System Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Type</em>'.
	 * @generated
	 */
	SystemType createSystemType();

	/**
	 * Returns a new object of class '<em>System Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Implementation</em>'.
	 * @generated
	 */
	SystemImplementation createSystemImplementation();

	/**
	 * Returns a new object of class '<em>System Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Prototype</em>'.
	 * @generated
	 */
	SystemPrototype createSystemPrototype();

	/**
	 * Returns a new object of class '<em>Thread Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thread Type</em>'.
	 * @generated
	 */
	ThreadType createThreadType();

	/**
	 * Returns a new object of class '<em>Thread Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thread Implementation</em>'.
	 * @generated
	 */
	ThreadImplementation createThreadImplementation();

	/**
	 * Returns a new object of class '<em>Thread Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thread Prototype</em>'.
	 * @generated
	 */
	ThreadPrototype createThreadPrototype();

	/**
	 * Returns a new object of class '<em>Thread Group Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thread Group Type</em>'.
	 * @generated
	 */
	ThreadGroupType createThreadGroupType();

	/**
	 * Returns a new object of class '<em>Thread Group Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thread Group Implementation</em>'.
	 * @generated
	 */
	ThreadGroupImplementation createThreadGroupImplementation();

	/**
	 * Returns a new object of class '<em>Thread Group Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thread Group Prototype</em>'.
	 * @generated
	 */
	ThreadGroupPrototype createThreadGroupPrototype();

	/**
	 * Returns a new object of class '<em>Virtual Bus Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Bus Type</em>'.
	 * @generated
	 */
	VirtualBusType createVirtualBusType();

	/**
	 * Returns a new object of class '<em>Virtual Bus Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Bus Implementation</em>'.
	 * @generated
	 */
	VirtualBusImplementation createVirtualBusImplementation();

	/**
	 * Returns a new object of class '<em>Virtual Bus Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Bus Prototype</em>'.
	 * @generated
	 */
	VirtualBusPrototype createVirtualBusPrototype();

	/**
	 * Returns a new object of class '<em>Virtual Processor Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Processor Type</em>'.
	 * @generated
	 */
	VirtualProcessorType createVirtualProcessorType();

	/**
	 * Returns a new object of class '<em>Virtual Processor Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Processor Implementation</em>'.
	 * @generated
	 */
	VirtualProcessorImplementation createVirtualProcessorImplementation();

	/**
	 * Returns a new object of class '<em>Virtual Processor Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Processor Prototype</em>'.
	 * @generated
	 */
	VirtualProcessorPrototype createVirtualProcessorPrototype();

	/**
	 * Returns a new object of class '<em>Component Prototype Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Prototype Binding</em>'.
	 * @generated
	 */
	ComponentPrototypeBinding createComponentPrototypeBinding();

	/**
	 * Returns a new object of class '<em>Component Prototype Actual</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Prototype Actual</em>'.
	 * @generated
	 */
	ComponentPrototypeActual createComponentPrototypeActual();

	/**
	 * Returns a new object of class '<em>Feature Group Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Group Prototype</em>'.
	 * @generated
	 */
	FeatureGroupPrototype createFeatureGroupPrototype();

	/**
	 * Returns a new object of class '<em>Feature Group Prototype Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Group Prototype Binding</em>'.
	 * @generated
	 */
	FeatureGroupPrototypeBinding createFeatureGroupPrototypeBinding();

	/**
	 * Returns a new object of class '<em>Feature Group Prototype Actual</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Group Prototype Actual</em>'.
	 * @generated
	 */
	FeatureGroupPrototypeActual createFeatureGroupPrototypeActual();

	/**
	 * Returns a new object of class '<em>Feature Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Prototype</em>'.
	 * @generated
	 */
	FeaturePrototype createFeaturePrototype();

	/**
	 * Returns a new object of class '<em>Feature Prototype Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Prototype Binding</em>'.
	 * @generated
	 */
	FeaturePrototypeBinding createFeaturePrototypeBinding();

	/**
	 * Returns a new object of class '<em>Access Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Access Specification</em>'.
	 * @generated
	 */
	AccessSpecification createAccessSpecification();

	/**
	 * Returns a new object of class '<em>Port Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Specification</em>'.
	 * @generated
	 */
	PortSpecification createPortSpecification();

	/**
	 * Returns a new object of class '<em>Feature Prototype Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Prototype Reference</em>'.
	 * @generated
	 */
	FeaturePrototypeReference createFeaturePrototypeReference();

	/**
	 * Returns a new object of class '<em>Subprogram Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subprogram Call</em>'.
	 * @generated
	 */
	SubprogramCall createSubprogramCall();

	/**
	 * Returns a new object of class '<em>Basic Property Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Property Association</em>'.
	 * @generated
	 */
	BasicPropertyAssociation createBasicPropertyAssociation();

	/**
	 * Returns a new object of class '<em>Property Constant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Constant</em>'.
	 * @generated
	 */
	PropertyConstant createPropertyConstant();

	/**
	 * Returns a new object of class '<em>Enumeration Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Literal</em>'.
	 * @generated
	 */
	EnumerationLiteral createEnumerationLiteral();

	/**
	 * Returns a new object of class '<em>Unit Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Literal</em>'.
	 * @generated
	 */
	UnitLiteral createUnitLiteral();

	/**
	 * Returns a new object of class '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal</em>'.
	 * @generated
	 */
	StringLiteral createStringLiteral();

	/**
	 * Returns a new object of class '<em>Classifier Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Classifier Value</em>'.
	 * @generated
	 */
	ClassifierValue createClassifierValue();

	/**
	 * Returns a new object of class '<em>Reference Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Value</em>'.
	 * @generated
	 */
	ReferenceValue createReferenceValue();

	/**
	 * Returns a new object of class '<em>Boolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal</em>'.
	 * @generated
	 */
	BooleanLiteral createBooleanLiteral();

	/**
	 * Returns a new object of class '<em>Range Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Range Value</em>'.
	 * @generated
	 */
	RangeValue createRangeValue();

	/**
	 * Returns a new object of class '<em>Integer Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Literal</em>'.
	 * @generated
	 */
	IntegerLiteral createIntegerLiteral();

	/**
	 * Returns a new object of class '<em>Real Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Literal</em>'.
	 * @generated
	 */
	RealLiteral createRealLiteral();

	/**
	 * Returns a new object of class '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation</em>'.
	 * @generated
	 */
	Operation createOperation();

	/**
	 * Returns a new object of class '<em>Record Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Record Value</em>'.
	 * @generated
	 */
	RecordValue createRecordValue();

	/**
	 * Returns a new object of class '<em>Computed Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computed Value</em>'.
	 * @generated
	 */
	ComputedValue createComputedValue();

	/**
	 * Returns a new object of class '<em>List Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Value</em>'.
	 * @generated
	 */
	ListValue createListValue();

	/**
	 * Returns a new object of class '<em>Named Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Value</em>'.
	 * @generated
	 */
	NamedValue createNamedValue();

	/**
	 * Returns a new object of class '<em>Property Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Set</em>'.
	 * @generated
	 */
	PropertySet createPropertySet();

	/**
	 * Returns a new object of class '<em>Global Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Global Namespace</em>'.
	 * @generated
	 */
	GlobalNamespace createGlobalNamespace();

	/**
	 * Returns a new object of class '<em>Aadl Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aadl Boolean</em>'.
	 * @generated
	 */
	AadlBoolean createAadlBoolean();

	/**
	 * Returns a new object of class '<em>Aadl String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aadl String</em>'.
	 * @generated
	 */
	AadlString createAadlString();

	/**
	 * Returns a new object of class '<em>Aadl Integer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aadl Integer</em>'.
	 * @generated
	 */
	AadlInteger createAadlInteger();

	/**
	 * Returns a new object of class '<em>Units Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Units Type</em>'.
	 * @generated
	 */
	UnitsType createUnitsType();

	/**
	 * Returns a new object of class '<em>Enumeration Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Type</em>'.
	 * @generated
	 */
	EnumerationType createEnumerationType();

	/**
	 * Returns a new object of class '<em>Numeric Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numeric Range</em>'.
	 * @generated
	 */
	NumericRange createNumericRange();

	/**
	 * Returns a new object of class '<em>Aadl Real</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aadl Real</em>'.
	 * @generated
	 */
	AadlReal createAadlReal();

	/**
	 * Returns a new object of class '<em>Classifier Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Classifier Type</em>'.
	 * @generated
	 */
	ClassifierType createClassifierType();

	/**
	 * Returns a new object of class '<em>Range Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Range Type</em>'.
	 * @generated
	 */
	RangeType createRangeType();

	/**
	 * Returns a new object of class '<em>Record Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Record Type</em>'.
	 * @generated
	 */
	RecordType createRecordType();

	/**
	 * Returns a new object of class '<em>Record Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Record Field</em>'.
	 * @generated
	 */
	RecordField createRecordField();

	/**
	 * Returns a new object of class '<em>Reference Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Type</em>'.
	 * @generated
	 */
	ReferenceType createReferenceType();

	/**
	 * Returns a new object of class '<em>List Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Type</em>'.
	 * @generated
	 */
	ListType createListType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Aadl2Package getAadl2Package();

} // Aadl2Factory
