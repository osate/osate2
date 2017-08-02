/*
 *
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
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
package org.osate.core.tests.aadl2scopeprovider

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ClassifierValue
import org.osate.aadl2.ComponentType
import org.osate.aadl2.ListType
import org.osate.aadl2.NamedElement
import org.osate.aadl2.PropertySet
import org.osate.aadl2.RecordType
import org.osate.aadl2.UnitsType
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class PropertySetReferencesTest extends OsateTest {
	override getProjectName() {
		"Property_Set_References_Test"
	}
	
	/*
	 * Tests the reference ArraySize_SizeProperty used in the parser rule ArraySize.
	 * Tests the reference PropertySet_ImportedUnit used in the parser rule PropertySet.
	 * Tests the reference ClassifierValue_classifier used in the parser rule QCReference.
	 * The scope for these rules are automatically provided, so there is no scoping method to test here.
	 * 
	 * Tests scope_UnitLiteral_baseUnit, scope_NumberType_referencedUnitsType, scope_RangeType_numberType, scope_BasicProperty_referencedPropertyType,
	 * scope_ListType_referencedElementType, scope_PropertyConstant_referencedPropertyType
	 */
	@Test
	def void testPropertySetReferences() {
		createFiles("ps.aadl" -> '''
				property set ps is
				  with pack2;
				  
				  ut1: type units (ul1, ul2 => ul1 * 10, ul3 => ul2 * 10, ul4 => ul3 * 10);
				  
				  pt1: type aadlreal units ps::ut1;
				  pt2: type aadlinteger units ps::ut1;
				  pt3: type range of ps::pt1;
				  pt4: type record (
				    f1: ps::pt1;
				    f2: ps::pt2;
				  );
				  
				  def1: aadlinteger applies to (all);
				  def2: aadlreal units ps::ut1 applies to (all);
				  def3: aadlinteger units ps::ut1 applies to (all);
				  def4: range of ps::pt1 applies to (all);
				  def5: aadlboolean applies to (pack2::a2.i);
				  def6: ps::pt1 applies to (all);
				  def7: list of ps::pt1 applies to (all);
				  
				  const1: constant aadlinteger => 10;
				  const2: constant ps::pt1 => 1.0 ul1;
				end ps;
			''',
			"pack1.aadl" -> '''
				package pack1
				public
				  with ps;
				  
				  abstract a1
				  features
				    af: feature[ps::const1];
				  properties
				    ps::def1 => 4;
				  end a1;
				end pack1;
			''',
			"pack2.aadl" -> '''
				package pack2
				public
				  abstract a2
				  end a2;
				  
				  abstract implementation a2.i
				  end a2.i;
				end pack2;
			'''
		)
		suppressSerialization
		testFile("pack2.aadl")
		testFile("ps.aadl").resource.contents.head as PropertySet => [
			"ps".assertEquals(name)
			//Tests the reference PropertySet_ImportedUnit
			assertScopeModelUnitNamesOnly(Aadl2Package::eINSTANCE.propertySet_ImportedUnit, #["AADL_Project", "Communication_Properties", "Deployment_Properties",
				"Memory_Properties", "Modeling_Properties", "Programming_Properties", "Thread_Properties", "Timing_Properties", "pack1", "pack2", "ps"
			])
			ownedPropertyTypes.get(0) as UnitsType => [
				"ut1".assertEquals(name)
				ownedLiterals.get(0) => [
					"ul1".assertEquals(name)
					//Tests scope_UnitLiteral_baseUnit
					assertScope(Aadl2Package::eINSTANCE.unitLiteral_BaseUnit, #["ul1", "ul2", "ul3", "ul4"])
				]
				ownedLiterals.get(1) => [
					"ul2".assertEquals(name)
					//Tests scope_UnitLiteral_baseUnit
					assertScope(Aadl2Package::eINSTANCE.unitLiteral_BaseUnit, #["ul1", "ul2", "ul3", "ul4"])
				]
				ownedLiterals.get(2) => [
					"ul3".assertEquals(name)
					//Tests scope_UnitLiteral_baseUnit
					assertScope(Aadl2Package::eINSTANCE.unitLiteral_BaseUnit, #["ul1", "ul2", "ul3", "ul4"])
				]
				ownedLiterals.get(3) => [
					"ul4".assertEquals(name)
					//Tests scope_UnitLiteral_baseUnit
					assertScope(Aadl2Package::eINSTANCE.unitLiteral_BaseUnit, #["ul1", "ul2", "ul3", "ul4"])
				]
			]
			ownedPropertyTypes.get(1) => [
				"pt1".assertEquals(name)
				//Tests scope_NumberType_referencedUnitsType
				assertScope(Aadl2Package::eINSTANCE.numberType_ReferencedUnitsType, #["Data_Rate_Units", "Data_Volume_Units", "Processor_Speed_Units",
					"Size_Units", "Time_Units", "ps::ut1", "AADL_Project::Data_Rate_Units", "AADL_Project::Data_Volume_Units",
					"AADL_Project::Processor_Speed_Units", "AADL_Project::Size_Units", "AADL_Project::Time_Units"
				])
			]
			ownedPropertyTypes.get(2) => [
				"pt2".assertEquals(name)
				//Tests scope_NumberType_referencedUnitsType
				assertScope(Aadl2Package::eINSTANCE.numberType_ReferencedUnitsType, #["Data_Rate_Units", "Data_Volume_Units", "Processor_Speed_Units",
					"Size_Units", "Time_Units", "ps::ut1", "AADL_Project::Data_Rate_Units", "AADL_Project::Data_Volume_Units",
					"AADL_Project::Processor_Speed_Units", "AADL_Project::Size_Units", "AADL_Project::Time_Units"
				])
			]
			ownedPropertyTypes.get(3) => [
				"pt3".assertEquals(name)
				//Tests scope_RangeType_numberType
				assertScope(Aadl2Package::eINSTANCE.rangeType_NumberType, #["Data_Volume", "Size", "Time", "ps::pt1", "ps::pt2",
					"AADL_Project::Data_Volume", "AADL_Project::Size", "AADL_Project::Time"
				])
			]
			ownedPropertyTypes.get(4) as RecordType => [
				"pt4".assertEquals(name)
				ownedFields.get(0) => [
					"f1".assertEquals(name)
					//Tests scope_BasicProperty_referencedPropertyType
					assertScope(Aadl2Package::eINSTANCE.basicProperty_ReferencedPropertyType, #["Access_Rights", "Array_Size_Range", "Connection_Pair", "Data_Rate_Units",
						"Data_Volume", "Data_Volume_Units", "IO_Reference_Time", "IO_Time_Spec", "Priority_Mapping", "Processor_Speed_Units", "Rate_Spec",
						"Size", "Size_Range", "Size_Units", "Supported_Active_Thread_Handling_Protocols", "Supported_Classifier_Substitutions",
						"Supported_Concurrency_Control_Protocols", "Supported_Connection_Patterns", "Supported_Connection_QoS", "Supported_Dispatch_Protocols",
						"Supported_Distributions", "Supported_Hardware_Source_Languages", "Supported_Queue_Processing_Protocols",
						"Supported_Scheduling_Protocols", "Supported_Source_Languages", "Time", "Time_Range", "Time_Units", "ps::pt1", "ps::pt2", "ps::pt3",
						"ps::pt4", "ps::ut1", "AADL_Project::Data_Rate_Units", "AADL_Project::Data_Volume", "AADL_Project::Data_Volume_Units",
						"AADL_Project::Processor_Speed_Units", "AADL_Project::Size_Units", "AADL_Project::Supported_Active_Thread_Handling_Protocols",
						"AADL_Project::Supported_Classifier_Substitutions", "AADL_Project::Supported_Concurrency_Control_Protocols",
						"AADL_Project::Supported_Connection_Patterns", "AADL_Project::Supported_Connection_QoS", "AADL_Project::Supported_Dispatch_Protocols",
						"AADL_Project::Supported_Distributions", "AADL_Project::Supported_Hardware_Source_Languages",
						"AADL_Project::Supported_Queue_Processing_Protocols", "AADL_Project::Supported_Scheduling_Protocols",
						"AADL_Project::Supported_Source_Languages", "AADL_Project::Time_Units", "Communication_Properties::Connection_Pair",
						"Communication_Properties::IO_Reference_Time", "Communication_Properties::IO_Time_Spec", "Communication_Properties::Rate_Spec",
						"Deployment_Properties::Priority_Mapping", "Memory_Properties::Access_Rights", "Modeling_Properties::Array_Size_Range", "AADL_Project::Size",
						"AADL_Project::Size_Range", "AADL_Project::Time", "AADL_Project::Time_Range"
					])
				]
				ownedFields.get(1) => [
					"f2".assertEquals(name)
					//Tests scope_BasicProperty_referencedPropertyType
					assertScope(Aadl2Package::eINSTANCE.basicProperty_ReferencedPropertyType, #["Access_Rights", "Array_Size_Range", "Connection_Pair", "Data_Rate_Units",
						"Data_Volume", "Data_Volume_Units", "IO_Reference_Time", "IO_Time_Spec", "Priority_Mapping", "Processor_Speed_Units", "Rate_Spec",
						"Size", "Size_Range", "Size_Units", "Supported_Active_Thread_Handling_Protocols", "Supported_Classifier_Substitutions",
						"Supported_Concurrency_Control_Protocols", "Supported_Connection_Patterns", "Supported_Connection_QoS", "Supported_Dispatch_Protocols",
						"Supported_Distributions", "Supported_Hardware_Source_Languages", "Supported_Queue_Processing_Protocols",
						"Supported_Scheduling_Protocols", "Supported_Source_Languages", "Time", "Time_Range", "Time_Units", "ps::pt1", "ps::pt2", "ps::pt3",
						"ps::pt4", "ps::ut1", "AADL_Project::Data_Rate_Units", "AADL_Project::Data_Volume", "AADL_Project::Data_Volume_Units",
						"AADL_Project::Processor_Speed_Units", "AADL_Project::Size_Units", "AADL_Project::Supported_Active_Thread_Handling_Protocols",
						"AADL_Project::Supported_Classifier_Substitutions", "AADL_Project::Supported_Concurrency_Control_Protocols",
						"AADL_Project::Supported_Connection_Patterns", "AADL_Project::Supported_Connection_QoS", "AADL_Project::Supported_Dispatch_Protocols",
						"AADL_Project::Supported_Distributions", "AADL_Project::Supported_Hardware_Source_Languages",
						"AADL_Project::Supported_Queue_Processing_Protocols", "AADL_Project::Supported_Scheduling_Protocols",
						"AADL_Project::Supported_Source_Languages", "AADL_Project::Time_Units", "Communication_Properties::Connection_Pair",
						"Communication_Properties::IO_Reference_Time", "Communication_Properties::IO_Time_Spec", "Communication_Properties::Rate_Spec",
						"Deployment_Properties::Priority_Mapping", "Memory_Properties::Access_Rights", "Modeling_Properties::Array_Size_Range", "AADL_Project::Size",
						"AADL_Project::Size_Range", "AADL_Project::Time", "AADL_Project::Time_Range"
					])
				]
			]
			ownedProperties.get(1) => [
				"def2".assertEquals(name)
				ownedPropertyType => [
					//Tests scope_NumberType_referencedUnitsType
					assertScope(Aadl2Package::eINSTANCE.numberType_ReferencedUnitsType, #["Data_Rate_Units", "Data_Volume_Units",
						"Processor_Speed_Units", "Size_Units", "Time_Units", "ps::ut1", "AADL_Project::Data_Rate_Units", "AADL_Project::Data_Volume_Units",
						"AADL_Project::Processor_Speed_Units", "AADL_Project::Size_Units", "AADL_Project::Time_Units"
					])
				]
			]
			ownedProperties.get(2) => [
				"def3".assertEquals(name)
				ownedPropertyType => [
					//Tests scope_NumberType_referencedUnitsType
					assertScope(Aadl2Package::eINSTANCE.numberType_ReferencedUnitsType, #["Data_Rate_Units", "Data_Volume_Units",
						"Processor_Speed_Units", "Size_Units", "Time_Units", "ps::ut1", "AADL_Project::Data_Rate_Units", "AADL_Project::Data_Volume_Units",
						"AADL_Project::Processor_Speed_Units", "AADL_Project::Size_Units", "AADL_Project::Time_Units"
					])
				]
			]
			ownedProperties.get(3) => [
				"def4".assertEquals(name)
				ownedPropertyType => [
					//Tests scope_RangeType_numberType
					assertScope(Aadl2Package::eINSTANCE.rangeType_NumberType, #["Data_Volume", "Size", "Time", "ps::pt1", "ps::pt2",
						"AADL_Project::Data_Volume", "AADL_Project::Size", "AADL_Project::Time"
					])
				]
			]
			ownedProperties.get(4) => [
				"def5".assertEquals(name)
				appliesTos.head as ClassifierValue => [
					"pack2::a2.i".assertEquals(classifier.getQualifiedName())
					//Tests the reference ClassifierValue_classifier
					assertScope(Aadl2Package::eINSTANCE.classifierValue_Classifier, #["pack1::a1", "pack2::a2", "pack2::a2.i"])
				]
			]
			ownedProperties.get(5) => [
				"def6".assertEquals(name)
				//Tests scope_BasicProperty_referencedPropertyType
				assertScope(Aadl2Package::eINSTANCE.basicProperty_ReferencedPropertyType, #["Access_Rights", "Array_Size_Range", "Connection_Pair", "Data_Rate_Units",
					"Data_Volume", "Data_Volume_Units", "IO_Reference_Time", "IO_Time_Spec", "Priority_Mapping", "Processor_Speed_Units", "Rate_Spec", "Size",
					"Size_Range", "Size_Units", "Supported_Active_Thread_Handling_Protocols", "Supported_Classifier_Substitutions",
					"Supported_Concurrency_Control_Protocols", "Supported_Connection_Patterns", "Supported_Connection_QoS", "Supported_Dispatch_Protocols",
					"Supported_Distributions", "Supported_Hardware_Source_Languages", "Supported_Queue_Processing_Protocols", "Supported_Scheduling_Protocols",
					"Supported_Source_Languages", "Time", "Time_Range", "Time_Units", "ps::pt1", "ps::pt2", "ps::pt3", "ps::pt4", "ps::ut1",
					"AADL_Project::Data_Rate_Units", "AADL_Project::Data_Volume", "AADL_Project::Data_Volume_Units", "AADL_Project::Processor_Speed_Units",
					"AADL_Project::Size_Units", "AADL_Project::Supported_Active_Thread_Handling_Protocols", "AADL_Project::Supported_Classifier_Substitutions",
					"AADL_Project::Supported_Concurrency_Control_Protocols", "AADL_Project::Supported_Connection_Patterns",
					"AADL_Project::Supported_Connection_QoS", "AADL_Project::Supported_Dispatch_Protocols", "AADL_Project::Supported_Distributions",
					"AADL_Project::Supported_Hardware_Source_Languages", "AADL_Project::Supported_Queue_Processing_Protocols",
					"AADL_Project::Supported_Scheduling_Protocols", "AADL_Project::Supported_Source_Languages", "AADL_Project::Time_Units",
					"Communication_Properties::Connection_Pair", "Communication_Properties::IO_Reference_Time", "Communication_Properties::IO_Time_Spec",
					"Communication_Properties::Rate_Spec", "Deployment_Properties::Priority_Mapping", "Memory_Properties::Access_Rights", "Modeling_Properties::Array_Size_Range",
					"AADL_Project::Size", "AADL_Project::Size_Range", "AADL_Project::Time", "AADL_Project::Time_Range"
				])
			]
			ownedProperties.get(6) => [
				"def7".assertEquals(name)
				ownedPropertyType as ListType => [
					"ps::pt1".assertEquals(elementType.getQualifiedName())
					//Tests scope_ListType_referencedElementType
					assertScope(Aadl2Package::eINSTANCE.listType_ReferencedElementType, #["Access_Rights", "Array_Size_Range", "Connection_Pair", "Data_Rate_Units",
						"Data_Volume", "Data_Volume_Units", "IO_Reference_Time", "IO_Time_Spec", "Priority_Mapping", "Processor_Speed_Units", "Rate_Spec",
						"Size", "Size_Range", "Size_Units", "Supported_Active_Thread_Handling_Protocols", "Supported_Classifier_Substitutions",
						"Supported_Concurrency_Control_Protocols", "Supported_Connection_Patterns", "Supported_Connection_QoS", "Supported_Dispatch_Protocols",
						"Supported_Distributions", "Supported_Hardware_Source_Languages", "Supported_Queue_Processing_Protocols",
						"Supported_Scheduling_Protocols", "Supported_Source_Languages", "Time", "Time_Range", "Time_Units", "ps::pt1", "ps::pt2", "ps::pt3",
						"ps::pt4", "ps::ut1", "AADL_Project::Data_Rate_Units", "AADL_Project::Data_Volume", "AADL_Project::Data_Volume_Units",
						"AADL_Project::Processor_Speed_Units", "AADL_Project::Size_Units", "AADL_Project::Supported_Active_Thread_Handling_Protocols",
						"AADL_Project::Supported_Classifier_Substitutions", "AADL_Project::Supported_Concurrency_Control_Protocols",
						"AADL_Project::Supported_Connection_Patterns", "AADL_Project::Supported_Connection_QoS", "AADL_Project::Supported_Dispatch_Protocols",
						"AADL_Project::Supported_Distributions", "AADL_Project::Supported_Hardware_Source_Languages",
						"AADL_Project::Supported_Queue_Processing_Protocols", "AADL_Project::Supported_Scheduling_Protocols",
						"AADL_Project::Supported_Source_Languages", "AADL_Project::Time_Units", "Communication_Properties::Connection_Pair",
						"Communication_Properties::IO_Reference_Time", "Communication_Properties::IO_Time_Spec", "Communication_Properties::Rate_Spec",
						"Deployment_Properties::Priority_Mapping", "Memory_Properties::Access_Rights", "Modeling_Properties::Array_Size_Range", "AADL_Project::Size",
						"AADL_Project::Size_Range", "AADL_Project::Time", "AADL_Project::Time_Range"
					])
				]
			]
			ownedPropertyConstants.get(1) => [
				"const2".assertEquals(name)
				//Tests scope_PropertyConstant_referencedPropertyType
				assertScope(Aadl2Package::eINSTANCE.propertyConstant_ReferencedPropertyType, #["Access_Rights", "Array_Size_Range", "Connection_Pair", "Data_Rate_Units",
					"Data_Volume", "Data_Volume_Units", "IO_Reference_Time", "IO_Time_Spec", "Priority_Mapping", "Processor_Speed_Units", "Rate_Spec", "Size",
					"Size_Range", "Size_Units", "Supported_Active_Thread_Handling_Protocols", "Supported_Classifier_Substitutions",
					"Supported_Concurrency_Control_Protocols", "Supported_Connection_Patterns", "Supported_Connection_QoS", "Supported_Dispatch_Protocols",
					"Supported_Distributions", "Supported_Hardware_Source_Languages", "Supported_Queue_Processing_Protocols", "Supported_Scheduling_Protocols",
					"Supported_Source_Languages", "Time", "Time_Range", "Time_Units", "ps::pt1", "ps::pt2", "ps::pt3", "ps::pt4", "ps::ut1",
					"AADL_Project::Data_Rate_Units", "AADL_Project::Data_Volume", "AADL_Project::Data_Volume_Units", "AADL_Project::Processor_Speed_Units",
					"AADL_Project::Size_Units", "AADL_Project::Supported_Active_Thread_Handling_Protocols", "AADL_Project::Supported_Classifier_Substitutions",
					"AADL_Project::Supported_Concurrency_Control_Protocols", "AADL_Project::Supported_Connection_Patterns",
					"AADL_Project::Supported_Connection_QoS", "AADL_Project::Supported_Dispatch_Protocols", "AADL_Project::Supported_Distributions",
					"AADL_Project::Supported_Hardware_Source_Languages", "AADL_Project::Supported_Queue_Processing_Protocols",
					"AADL_Project::Supported_Scheduling_Protocols", "AADL_Project::Supported_Source_Languages", "AADL_Project::Time_Units",
					"Communication_Properties::Connection_Pair", "Communication_Properties::IO_Reference_Time", "Communication_Properties::IO_Time_Spec",
					"Communication_Properties::Rate_Spec", "Deployment_Properties::Priority_Mapping", "Memory_Properties::Access_Rights", "Modeling_Properties::Array_Size_Range",
					"AADL_Project::Size", "AADL_Project::Size_Range", "AADL_Project::Time", "AADL_Project::Time_Range"
				])
			]
		]
		testFile("pack1.aadl").resource.contents.head as AadlPackage => [
			"pack1".assertEquals(name)
			publicSection.ownedClassifiers.head as ComponentType => [
				"a1".assertEquals(name)
				ownedAbstractFeatures.head => [
					"af".assertEquals(name)
					arrayDimensions.head.size => [
						"ps::const1".assertEquals((sizeProperty as NamedElement).qualifiedName())
						//Tests the reference ArraySize_SizeProperty
						assertScope(Aadl2Package::eINSTANCE.arraySize_SizeProperty, #[
// PHF: we now only allow property constants
//						"Acceptable_Array_Size", "Access_Right", "Access_Time",
//							"Activate_Deadline", "Activate_Entrypoint", "Activate_Entrypoint_Call_Sequence", "Activate_Entrypoint_Source_Text",
//							"Activate_Execution_Time", "Active_Thread_Handling_Protocol", "Active_Thread_Queue_Handling_Protocol", "Actual_Connection_Binding",
//							"Actual_Function_Binding", "Actual_Latency", "Actual_Memory_Binding", "Actual_Processor_Binding", "Actual_Subprogram_Call",
//							"Actual_Subprogram_Call_Binding", "Allowed_Connection_Binding", "Allowed_Connection_Binding_Class", "Allowed_Connection_Type",
//							"Allowed_Dispatch_Protocol", "Allowed_Memory_Binding", "Allowed_Memory_Binding_Class", "Allowed_Message_Size", "Allowed_Period",
//							"Allowed_Physical_Access", "Allowed_Physical_Access_Class", "Allowed_Processor_Binding", "Allowed_Processor_Binding_Class",
//							"Allowed_Subprogram_Call", "Allowed_Subprogram_Call_Binding", "Assign_Time", "Base_Address", "Byte_Count",
//							"Classifier_Matching_Rule", "Classifier_Substitution_Rule", "Client_Subprogram_Execution_Time", "Clock_Jitter", "Clock_Period",
//							"Clock_Period_Range", "Code_Size", "Collocated", "Compute_Deadline", "Compute_Entrypoint", "Compute_Entrypoint_Call_Sequence",
//							"Compute_Entrypoint_Source_Text", "Compute_Execution_Time", "Concurrency_Control_Protocol", "Connection_Pattern", "Connection_Set",
//							"Criticality", "Data_Rate", "Data_Size", "Deactivate_Dealing", "Deactivate_Entrypoint", "Deactivate_Entrypoint_Call_Sequence",
//							"Deactivate_Entrypoint_Source_Text", "Deactivate_Execution_Time", "Deactivation_Policy", "Deadline", "Dequeue_Protocol",
//							"Dequeued_Items", "Device_Driver", "Device_Register_Address", "Dispatch_Able", "Dispatch_Jitter", "Dispatch_Offset",
//							"Dispatch_Protocol", "Dispatch_Trigger", "Execution_Time", "Fan_Out_Policy", "Finalize_Deadline", "Finalize_Entrypoint",
//							"Finalize_Entrypoint_Call_Sequence", "Finalize_Entrypoint_Source_Text", "Finalize_Execution_Time", "First_Dispatch_Time",
//							"Frame_Period", "Hardware_Description_Source_Text", "Hardware_Source_Language", "Heap_Size", "Implemented_As",
//							"Initialize_Deadline", "Initialize_Entrypoint", "Initialize_Entrypoint_Call_Sequence", "Initialize_Entrypoint_Source_Text",
//							"Initialize_Execution_Time", "Input_Rate", "Input_Time", "Latency", "Load_Deadline", "Load_Time", 
							"Max_Aadlinteger",
							"Max_Base_Address", "Max_Byte_Count", "Max_Memory_Size", "Max_Queue_Size", "Max_Target_Integer", "Max_Thread_Limit", "Max_Time",
							"Max_Urgency", 
							"Max_Volume", "Max_Word_Space", 
//							"Memory_Protocol", "Memory_Size", "Mode_Transition_Response", "Not_Collocated",
//							"Output_Rate", "Output_Time", "Overflow_Handling_Protocol", "POSIX_Scheduling_Policy", "Period", "Preemptive_Scheduler",
//							"Priority", "Priority_Map", "Priority_Range", "Process_Swap_Execution_Time", "Processor_Capacity", "Prototype_Substitution_Rule",
//							"Provided_Connection_Quality_Of_Service", "Provided_Virtual_Bus_Class", "Queue_Processing_Protocol", "Queue_Size", "Read_Time",
//							"Recover_Deadline", "Recover_Entrypoint", "Recover_Entrypoint_Call_Sequence", "Recover_Entrypoint_Source_Text",
//							"Recover_Execution_Time", "Reference_Processor", "Required_Connection", "Required_Connection_Quality_Of_Service",
//							"Required_Virtual_Bus_Class", "Resumption_Policy", "Runtime_Protection", "Runtime_Protection_Support", "Scheduler_Quantum",
//							"Scheduling_Protocol", "Slot_Time", "Source_Code_Size", "Source_Data_Size","Source_Heap_Size","Source_Language", "Source_Name","Source_Stack_Size", "Source_Text", "Stack_Size", "Startup_Deadline",
//							"Startup_Execution_Time", "Subprogram_Call_Rate", "Subprogram_Call_Type", 
							"Supported_Classifier_Complement_Matches", 	"Supported_Classifier_Equivalence_Matches", "Supported_Classifier_Subset_Matches", 
							"Supported_Type_Conversions", 
//							"Supported_Source_Language",
//							"Synchronized_Component", "Thread_Limit", "Thread_Swap_Execution_Time", "Time_Slot", "Timing",
//							"Transmission_Time", "Transmission_Type", "Type_Source_Name", "Urgency", "Word_Size", "Word_Space", "Write_Time", 
							"ps::const1","ps::const2", 
//							"ps::def1", "ps::def2", "ps::def3", "ps::def4", "ps::def5", "ps::def6", "ps::def7", 
							"AADL_Project::Max_Aadlinteger",
							"AADL_Project::Max_Base_Address", "AADL_Project::Max_Byte_Count", "AADL_Project::Max_Memory_Size", "AADL_Project::Max_Queue_Size",
							"AADL_Project::Max_Target_Integer", "AADL_Project::Max_Thread_Limit", "AADL_Project::Max_Time", "AADL_Project::Max_Urgency",
							"AADL_Project::Max_Volume", "AADL_Project::Max_Word_Space", 
							"AADL_Project::Supported_Classifier_Complement_Matches", "AADL_Project::Supported_Type_Conversions",
							"AADL_Project::Supported_Classifier_Equivalence_Matches", "AADL_Project::Supported_Classifier_Subset_Matches"
							//,
//							 "Communication_Properties::Actual_Latency",
//							"Communication_Properties::Connection_Pattern", "Communication_Properties::Connection_Set", "Communication_Properties::Data_Rate",
//							"Communication_Properties::Fan_Out_Policy", "Communication_Properties::Input_Rate", "Communication_Properties::Input_Time",
//							"Communication_Properties::Latency", "Communication_Properties::Output_Rate", "Communication_Properties::Output_Time",
//							"Communication_Properties::Overflow_Handling_Protocol", "Communication_Properties::Queue_Processing_Protocol",
//							"Communication_Properties::Queue_Size", "Communication_Properties::Required_Connection",
//							"Communication_Properties::Subprogram_Call_Rate", "Communication_Properties::Timing",
//							"Communication_Properties::Transmission_Time", "Communication_Properties::Transmission_Type",
//							"Deployment_Properties::Actual_Connection_Binding", "Deployment_Properties::Actual_Function_Binding",
//							"Deployment_Properties::Actual_Memory_Binding", "Deployment_Properties::Actual_Processor_Binding",
//							"Deployment_Properties::Actual_Subprogram_Call", "Deployment_Properties::Actual_Subprogram_Call_Binding",
//							"Deployment_Properties::Allowed_Connection_Binding", "Deployment_Properties::Allowed_Connection_Binding_Class",
//							"Deployment_Properties::Allowed_Connection_Type", "Deployment_Properties::Allowed_Dispatch_Protocol",
//							"Deployment_Properties::Allowed_Memory_Binding", "Deployment_Properties::Allowed_Memory_Binding_Class",
//							"Deployment_Properties::Allowed_Period", "Deployment_Properties::Allowed_Physical_Access",
//							"Deployment_Properties::Allowed_Physical_Access_Class", "Deployment_Properties::Allowed_Processor_Binding",
//							"Deployment_Properties::Allowed_Processor_Binding_Class", "Deployment_Properties::Allowed_Subprogram_Call",
//							"Deployment_Properties::Allowed_Subprogram_Call_Binding", "Deployment_Properties::Collocated",
//							"Deployment_Properties::Memory_Protocol", "Deployment_Properties::Not_Collocated", "Deployment_Properties::Preemptive_Scheduler",
//							"Deployment_Properties::Priority_Map", "Deployment_Properties::Priority_Range",
//							"Deployment_Properties::Provided_Connection_Quality_Of_Service", "Deployment_Properties::Provided_Virtual_Bus_Class",
//							"Deployment_Properties::Required_Connection_Quality_Of_Service", "Deployment_Properties::Required_Virtual_Bus_Class",
//							"Deployment_Properties::Runtime_Protection_Support", "Deployment_Properties::Scheduling_Protocol",
//							"Deployment_Properties::Thread_Limit", "Memory_Properties::Access_Right", "Memory_Properties::Access_Time",
//							"Memory_Properties::Allowed_Message_Size", "Memory_Properties::Assign_Time", "Memory_Properties::Base_Address",
//							"Memory_Properties::Byte_Count", "Memory_Properties::Code_Size", "Memory_Properties::Data_Size",
//							"Memory_Properties::Device_Register_Address", "Memory_Properties::Heap_Size", "Memory_Properties::Memory_Size",
//							"Memory_Properties::Read_Time", 
//							"Memory_Properties::Source_Code_Size", "Memory_Properties::Source_Data_Size", "Memory_Properties::Source_Heap_Size", "Memory_Properties::Source_Stack_Size", 
//							"Memory_Properties::Stack_Size", "Memory_Properties::Word_Size", "Memory_Properties::Word_Space",
//							"Memory_Properties::Write_Time", "Modeling_Properties::Acceptable_Array_Size", "Modeling_Properties::Classifier_Matching_Rule",
//							"Modeling_Properties::Classifier_Substitution_Rule", "Modeling_Properties::Implemented_As",
//							"Modeling_Properties::Prototype_Substitution_Rule", "Programming_Properties::Activate_Entrypoint",
//							"Programming_Properties::Activate_Entrypoint_Call_Sequence", "Programming_Properties::Activate_Entrypoint_Source_Text",
//							"Programming_Properties::Compute_Entrypoint", "Programming_Properties::Compute_Entrypoint_Call_Sequence",
//							"Programming_Properties::Compute_Entrypoint_Source_Text", "Programming_Properties::Deactivate_Entrypoint",
//							"Programming_Properties::Deactivate_Entrypoint_Call_Sequence", "Programming_Properties::Deactivate_Entrypoint_Source_Text",
//							"Programming_Properties::Device_Driver", "Programming_Properties::Finalize_Entrypoint",
//							"Programming_Properties::Finalize_Entrypoint_Call_Sequence", "Programming_Properties::Finalize_Entrypoint_Source_Text",
//							"Programming_Properties::Hardware_Description_Source_Text", "Programming_Properties::Hardware_Source_Language",
//							"Programming_Properties::Initialize_Entrypoint", "Programming_Properties::Initialize_Entrypoint_Call_Sequence",
//							"Programming_Properties::Initialize_Entrypoint_Source_Text", "Programming_Properties::Recover_Entrypoint",
//							"Programming_Properties::Recover_Entrypoint_Call_Sequence", "Programming_Properties::Recover_Entrypoint_Source_Text",
//							"Programming_Properties::Source_Language", "Programming_Properties::Source_Name", "Programming_Properties::Source_Text",
//							"Programming_Properties::Supported_Source_Language", "Programming_Properties::Type_Source_Name",
//							"Thread_Properties::Active_Thread_Handling_Protocol", "Thread_Properties::Active_Thread_Queue_Handling_Protocol",
//							"Thread_Properties::Concurrency_Control_Protocol", "Thread_Properties::Criticality", "Thread_Properties::Deactivation_Policy",
//							"Thread_Properties::Dequeue_Protocol", "Thread_Properties::Dequeued_Items", "Thread_Properties::Dispatch_Able",
//							"Thread_Properties::Dispatch_Protocol", "Thread_Properties::Dispatch_Trigger", "Thread_Properties::Mode_Transition_Response",
//							"Thread_Properties::POSIX_Scheduling_Policy", "Thread_Properties::Priority", "Thread_Properties::Resumption_Policy",
//							"Thread_Properties::Runtime_Protection", "Thread_Properties::Subprogram_Call_Type", "Thread_Properties::Synchronized_Component",
//							"Thread_Properties::Time_Slot", "Thread_Properties::Urgency", "Timing_Properties::Activate_Deadline",
//							"Timing_Properties::Activate_Execution_Time", "Timing_Properties::Client_Subprogram_Execution_Time",
//							"Timing_Properties::Clock_Jitter", "Timing_Properties::Clock_Period", "Timing_Properties::Clock_Period_Range",
//							"Timing_Properties::Compute_Deadline", "Timing_Properties::Compute_Execution_Time", "Timing_Properties::Deactivate_Dealing",
//							"Timing_Properties::Deactivate_Execution_Time", "Timing_Properties::Deadline", "Timing_Properties::Dispatch_Jitter",
//							"Timing_Properties::Dispatch_Offset", "Timing_Properties::Execution_Time", "Timing_Properties::Finalize_Deadline",
//							"Timing_Properties::Finalize_Execution_Time", "Timing_Properties::First_Dispatch_Time", "Timing_Properties::Frame_Period",
//							"Timing_Properties::Initialize_Deadline", "Timing_Properties::Initialize_Execution_Time", "Timing_Properties::Load_Deadline",
//							"Timing_Properties::Load_Time", "Timing_Properties::Period", "Timing_Properties::Process_Swap_Execution_Time",
//							"Timing_Properties::Processor_Capacity", "Timing_Properties::Recover_Deadline", "Timing_Properties::Recover_Execution_Time",
//							"Timing_Properties::Reference_Processor", "Timing_Properties::Scheduler_Quantum", "Timing_Properties::Slot_Time",
//							"Timing_Properties::Startup_Deadline", "Timing_Properties::Startup_Execution_Time", "Timing_Properties::Thread_Swap_Execution_Time"
						])
					]
				]
			]
		]
	}
}