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

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ClassifierValue
import org.osate.aadl2.ComponentType
import org.osate.aadl2.ListType
import org.osate.aadl2.ModelUnit
import org.osate.aadl2.NamedElement
import org.osate.aadl2.RecordType
import org.osate.aadl2.UnitsType
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.AssertHelper
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import org.osate.aadl2.PropertySet

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class PropertySetReferencesTest extends XtextTest {

	@Inject
	TestHelper<ModelUnit> testHelper

	@Inject
	extension AssertHelper assertHelper

	/*
	 * Tests the reference PropertySet_ImportedUnit used in the parser rule PropertySet.
	 * Tests the reference ClassifierValue_classifier used in the parser rule QCReference.
	 * The scope for these rules are automatically provided, so there is no scoping method to test here.
	 * 
	 * Tests scope_UnitLiteral_baseUnit, scope_NumberType_referencedUnitsType, scope_RangeType_numberType, scope_BasicProperty_referencedPropertyType,
	 * scope_ListType_referencedElementType, scope_PropertyConstant_referencedPropertyType
	 */
	@Test
	def void testPropertySetReferences() {
		val propertySet = testHelper.parseString(ps, pack1, pack2) as PropertySet
		propertySet => [
			"ps".assertEquals(name)
			// Tests the reference PropertySet_ImportedUnit
			assertScope(Aadl2Package::eINSTANCE.propertySet_ImportedUnit, #[
				"AADL_Project",
				"Communication_Properties",
				"Deployment_Properties",
				"Memory_Properties",
				"Modeling_Properties",
				"Programming_Properties",
				"Thread_Properties",
				"Timing_Properties",
				"pack1",
				"pack2",
				"ps"
			])
			ownedPropertyTypes.get(0) as UnitsType => [
				"ut1".assertEquals(name)
				ownedLiterals.get(0) => [
					"ul1".assertEquals(name)
					// Tests scope_UnitLiteral_baseUnit
					assertScope(Aadl2Package::eINSTANCE.unitLiteral_BaseUnit, #["ul1", "ul2", "ul3", "ul4"])
				]
				ownedLiterals.get(1) => [
					"ul2".assertEquals(name)
					// Tests scope_UnitLiteral_baseUnit
					assertScope(Aadl2Package::eINSTANCE.unitLiteral_BaseUnit, #["ul1", "ul2", "ul3", "ul4"])
				]
				ownedLiterals.get(2) => [
					"ul3".assertEquals(name)
					// Tests scope_UnitLiteral_baseUnit
					assertScope(Aadl2Package::eINSTANCE.unitLiteral_BaseUnit, #["ul1", "ul2", "ul3", "ul4"])
				]
				ownedLiterals.get(3) => [
					"ul4".assertEquals(name)
					// Tests scope_UnitLiteral_baseUnit
					assertScope(Aadl2Package::eINSTANCE.unitLiteral_BaseUnit, #["ul1", "ul2", "ul3", "ul4"])
				]
			]
			ownedPropertyTypes.get(1) => [
				"pt1".assertEquals(name)
				// Tests scope_NumberType_referencedUnitsType
				assertScope(Aadl2Package::eINSTANCE.numberType_ReferencedUnitsType, #[
					"Data_Rate_Units",
					"Data_Volume_Units",
					"Processor_Speed_Units",
					"Size_Units",
					"Time_Units",
					"ps::ut1",
					"AADL_Project::Data_Rate_Units",
					"AADL_Project::Data_Volume_Units",
					"AADL_Project::Processor_Speed_Units",
					"AADL_Project::Size_Units",
					"AADL_Project::Time_Units"
				])
			]
			ownedPropertyTypes.get(2) => [
				"pt2".assertEquals(name)
				// Tests scope_NumberType_referencedUnitsType
				assertScope(Aadl2Package::eINSTANCE.numberType_ReferencedUnitsType, #[
					"Data_Rate_Units",
					"Data_Volume_Units",
					"Processor_Speed_Units",
					"Size_Units",
					"Time_Units",
					"ps::ut1",
					"AADL_Project::Data_Rate_Units",
					"AADL_Project::Data_Volume_Units",
					"AADL_Project::Processor_Speed_Units",
					"AADL_Project::Size_Units",
					"AADL_Project::Time_Units"
				])
			]
			ownedPropertyTypes.get(3) => [
				"pt3".assertEquals(name)
				// Tests scope_RangeType_numberType
				assertScope(Aadl2Package::eINSTANCE.rangeType_NumberType, #[
					"Data_Volume",
					"Size",
					"Time",
					"ps::pt1",
					"ps::pt2",
					"AADL_Project::Data_Volume",
					"AADL_Project::Size",
					"AADL_Project::Time"
				])
			]
			ownedPropertyTypes.get(4) as RecordType => [
				"pt4".assertEquals(name)
				ownedFields.get(0) => [
					"f1".assertEquals(name)
					// Tests scope_BasicProperty_referencedPropertyType
					assertScope(Aadl2Package::eINSTANCE.basicProperty_ReferencedPropertyType, #[
						"Access_Rights",
						"Array_Size_Range",
						"Connection_Pair",
						"Data_Rate_Units",
						"Data_Volume",
						"Data_Volume_Units",
						"IO_Reference_Time",
						"IO_Time_Spec",
						"Priority_Mapping",
						"Processor_Speed_Units",
						"Rate_Spec",
						"Size",
						"Size_Range",
						"Size_Units",
						"Supported_Active_Thread_Handling_Protocols",
						"Supported_Classifier_Substitutions",
						"Supported_Concurrency_Control_Protocols",
						"Supported_Connection_Patterns",
						"Supported_Connection_QoS",
						"Supported_Dispatch_Protocols",
						"Supported_Distributions",
						"Supported_Hardware_Source_Languages",
						"Supported_Queue_Processing_Protocols",
						"Supported_Scheduling_Protocols",
						"Supported_Source_Languages",
						"Time",
						"Time_Range",
						"Time_Units",
						"ps::pt1",
						"ps::pt2",
						"ps::pt3",
						"ps::pt4",
						"ps::ut1",
						"AADL_Project::Data_Rate_Units",
						"AADL_Project::Data_Volume",
						"AADL_Project::Data_Volume_Units",
						"AADL_Project::Processor_Speed_Units",
						"AADL_Project::Size_Units",
						"AADL_Project::Supported_Active_Thread_Handling_Protocols",
						"AADL_Project::Supported_Classifier_Substitutions",
						"AADL_Project::Supported_Concurrency_Control_Protocols",
						"AADL_Project::Supported_Connection_Patterns",
						"AADL_Project::Supported_Connection_QoS",
						"AADL_Project::Supported_Dispatch_Protocols",
						"AADL_Project::Supported_Distributions",
						"AADL_Project::Supported_Hardware_Source_Languages",
						"AADL_Project::Supported_Queue_Processing_Protocols",
						"AADL_Project::Supported_Scheduling_Protocols",
						"AADL_Project::Supported_Source_Languages",
						"AADL_Project::Time_Units",
						"Communication_Properties::Connection_Pair",
						"Communication_Properties::IO_Reference_Time",
						"Communication_Properties::IO_Time_Spec",
						"Communication_Properties::Rate_Spec",
						"Deployment_Properties::Priority_Mapping",
						"Memory_Properties::Access_Rights",
						"Modeling_Properties::Array_Size_Range",
						"AADL_Project::Size",
						"AADL_Project::Size_Range",
						"AADL_Project::Time",
						"AADL_Project::Time_Range"
					])
				]
				ownedFields.get(1) => [
					"f2".assertEquals(name)
					// Tests scope_BasicProperty_referencedPropertyType
					assertScope(Aadl2Package::eINSTANCE.basicProperty_ReferencedPropertyType, #[
						"Access_Rights",
						"Array_Size_Range",
						"Connection_Pair",
						"Data_Rate_Units",
						"Data_Volume",
						"Data_Volume_Units",
						"IO_Reference_Time",
						"IO_Time_Spec",
						"Priority_Mapping",
						"Processor_Speed_Units",
						"Rate_Spec",
						"Size",
						"Size_Range",
						"Size_Units",
						"Supported_Active_Thread_Handling_Protocols",
						"Supported_Classifier_Substitutions",
						"Supported_Concurrency_Control_Protocols",
						"Supported_Connection_Patterns",
						"Supported_Connection_QoS",
						"Supported_Dispatch_Protocols",
						"Supported_Distributions",
						"Supported_Hardware_Source_Languages",
						"Supported_Queue_Processing_Protocols",
						"Supported_Scheduling_Protocols",
						"Supported_Source_Languages",
						"Time",
						"Time_Range",
						"Time_Units",
						"ps::pt1",
						"ps::pt2",
						"ps::pt3",
						"ps::pt4",
						"ps::ut1",
						"AADL_Project::Data_Rate_Units",
						"AADL_Project::Data_Volume",
						"AADL_Project::Data_Volume_Units",
						"AADL_Project::Processor_Speed_Units",
						"AADL_Project::Size_Units",
						"AADL_Project::Supported_Active_Thread_Handling_Protocols",
						"AADL_Project::Supported_Classifier_Substitutions",
						"AADL_Project::Supported_Concurrency_Control_Protocols",
						"AADL_Project::Supported_Connection_Patterns",
						"AADL_Project::Supported_Connection_QoS",
						"AADL_Project::Supported_Dispatch_Protocols",
						"AADL_Project::Supported_Distributions",
						"AADL_Project::Supported_Hardware_Source_Languages",
						"AADL_Project::Supported_Queue_Processing_Protocols",
						"AADL_Project::Supported_Scheduling_Protocols",
						"AADL_Project::Supported_Source_Languages",
						"AADL_Project::Time_Units",
						"Communication_Properties::Connection_Pair",
						"Communication_Properties::IO_Reference_Time",
						"Communication_Properties::IO_Time_Spec",
						"Communication_Properties::Rate_Spec",
						"Deployment_Properties::Priority_Mapping",
						"Memory_Properties::Access_Rights",
						"Modeling_Properties::Array_Size_Range",
						"AADL_Project::Size",
						"AADL_Project::Size_Range",
						"AADL_Project::Time",
						"AADL_Project::Time_Range"
					])
				]
			]
			ownedProperties.get(1) => [
				"def2".assertEquals(name)
				ownedPropertyType => [
					// Tests scope_NumberType_referencedUnitsType
					assertScope(Aadl2Package::eINSTANCE.numberType_ReferencedUnitsType, #[
						"Data_Rate_Units",
						"Data_Volume_Units",
						"Processor_Speed_Units",
						"Size_Units",
						"Time_Units",
						"ps::ut1",
						"AADL_Project::Data_Rate_Units",
						"AADL_Project::Data_Volume_Units",
						"AADL_Project::Processor_Speed_Units",
						"AADL_Project::Size_Units",
						"AADL_Project::Time_Units"
					])
				]
			]
			ownedProperties.get(2) => [
				"def3".assertEquals(name)
				ownedPropertyType => [
					// Tests scope_NumberType_referencedUnitsType
					assertScope(Aadl2Package::eINSTANCE.numberType_ReferencedUnitsType, #[
						"Data_Rate_Units",
						"Data_Volume_Units",
						"Processor_Speed_Units",
						"Size_Units",
						"Time_Units",
						"ps::ut1",
						"AADL_Project::Data_Rate_Units",
						"AADL_Project::Data_Volume_Units",
						"AADL_Project::Processor_Speed_Units",
						"AADL_Project::Size_Units",
						"AADL_Project::Time_Units"
					])
				]
			]
			ownedProperties.get(3) => [
				"def4".assertEquals(name)
				ownedPropertyType => [
					// Tests scope_RangeType_numberType
					assertScope(Aadl2Package::eINSTANCE.rangeType_NumberType, #[
						"Data_Volume",
						"Size",
						"Time",
						"ps::pt1",
						"ps::pt2",
						"AADL_Project::Data_Volume",
						"AADL_Project::Size",
						"AADL_Project::Time"
					])
				]
			]
			ownedProperties.get(4) => [
				"def5".assertEquals(name)
				appliesTos.head as ClassifierValue => [
					"pack2::a2.i".assertEquals(classifier.getQualifiedName())
					// Tests the reference ClassifierValue_classifier
					assertScope(Aadl2Package::eINSTANCE.classifierValue_Classifier,
						#["pack1::a1", "pack2::a2", "pack2::a2.i"])
				]
			]
			ownedProperties.get(5) => [
				"def6".assertEquals(name)
				// Tests scope_BasicProperty_referencedPropertyType
				assertScope(Aadl2Package::eINSTANCE.basicProperty_ReferencedPropertyType, #[
					"Access_Rights",
					"Array_Size_Range",
					"Connection_Pair",
					"Data_Rate_Units",
					"Data_Volume",
					"Data_Volume_Units",
					"IO_Reference_Time",
					"IO_Time_Spec",
					"Priority_Mapping",
					"Processor_Speed_Units",
					"Rate_Spec",
					"Size",
					"Size_Range",
					"Size_Units",
					"Supported_Active_Thread_Handling_Protocols",
					"Supported_Classifier_Substitutions",
					"Supported_Concurrency_Control_Protocols",
					"Supported_Connection_Patterns",
					"Supported_Connection_QoS",
					"Supported_Dispatch_Protocols",
					"Supported_Distributions",
					"Supported_Hardware_Source_Languages",
					"Supported_Queue_Processing_Protocols",
					"Supported_Scheduling_Protocols",
					"Supported_Source_Languages",
					"Time",
					"Time_Range",
					"Time_Units",
					"ps::pt1",
					"ps::pt2",
					"ps::pt3",
					"ps::pt4",
					"ps::ut1",
					"AADL_Project::Data_Rate_Units",
					"AADL_Project::Data_Volume",
					"AADL_Project::Data_Volume_Units",
					"AADL_Project::Processor_Speed_Units",
					"AADL_Project::Size_Units",
					"AADL_Project::Supported_Active_Thread_Handling_Protocols",
					"AADL_Project::Supported_Classifier_Substitutions",
					"AADL_Project::Supported_Concurrency_Control_Protocols",
					"AADL_Project::Supported_Connection_Patterns",
					"AADL_Project::Supported_Connection_QoS",
					"AADL_Project::Supported_Dispatch_Protocols",
					"AADL_Project::Supported_Distributions",
					"AADL_Project::Supported_Hardware_Source_Languages",
					"AADL_Project::Supported_Queue_Processing_Protocols",
					"AADL_Project::Supported_Scheduling_Protocols",
					"AADL_Project::Supported_Source_Languages",
					"AADL_Project::Time_Units",
					"Communication_Properties::Connection_Pair",
					"Communication_Properties::IO_Reference_Time",
					"Communication_Properties::IO_Time_Spec",
					"Communication_Properties::Rate_Spec",
					"Deployment_Properties::Priority_Mapping",
					"Memory_Properties::Access_Rights",
					"Modeling_Properties::Array_Size_Range",
					"AADL_Project::Size",
					"AADL_Project::Size_Range",
					"AADL_Project::Time",
					"AADL_Project::Time_Range"
				])
			]
			ownedProperties.get(6) => [
				"def7".assertEquals(name)
				ownedPropertyType as ListType => [
					"ps::pt1".assertEquals(elementType.getQualifiedName())
					// Tests scope_ListType_referencedElementType
					assertScope(Aadl2Package::eINSTANCE.listType_ReferencedElementType, #[
						"Access_Rights",
						"Array_Size_Range",
						"Connection_Pair",
						"Data_Rate_Units",
						"Data_Volume",
						"Data_Volume_Units",
						"IO_Reference_Time",
						"IO_Time_Spec",
						"Priority_Mapping",
						"Processor_Speed_Units",
						"Rate_Spec",
						"Size",
						"Size_Range",
						"Size_Units",
						"Supported_Active_Thread_Handling_Protocols",
						"Supported_Classifier_Substitutions",
						"Supported_Concurrency_Control_Protocols",
						"Supported_Connection_Patterns",
						"Supported_Connection_QoS",
						"Supported_Dispatch_Protocols",
						"Supported_Distributions",
						"Supported_Hardware_Source_Languages",
						"Supported_Queue_Processing_Protocols",
						"Supported_Scheduling_Protocols",
						"Supported_Source_Languages",
						"Time",
						"Time_Range",
						"Time_Units",
						"ps::pt1",
						"ps::pt2",
						"ps::pt3",
						"ps::pt4",
						"ps::ut1",
						"AADL_Project::Data_Rate_Units",
						"AADL_Project::Data_Volume",
						"AADL_Project::Data_Volume_Units",
						"AADL_Project::Processor_Speed_Units",
						"AADL_Project::Size_Units",
						"AADL_Project::Supported_Active_Thread_Handling_Protocols",
						"AADL_Project::Supported_Classifier_Substitutions",
						"AADL_Project::Supported_Concurrency_Control_Protocols",
						"AADL_Project::Supported_Connection_Patterns",
						"AADL_Project::Supported_Connection_QoS",
						"AADL_Project::Supported_Dispatch_Protocols",
						"AADL_Project::Supported_Distributions",
						"AADL_Project::Supported_Hardware_Source_Languages",
						"AADL_Project::Supported_Queue_Processing_Protocols",
						"AADL_Project::Supported_Scheduling_Protocols",
						"AADL_Project::Supported_Source_Languages",
						"AADL_Project::Time_Units",
						"Communication_Properties::Connection_Pair",
						"Communication_Properties::IO_Reference_Time",
						"Communication_Properties::IO_Time_Spec",
						"Communication_Properties::Rate_Spec",
						"Deployment_Properties::Priority_Mapping",
						"Memory_Properties::Access_Rights",
						"Modeling_Properties::Array_Size_Range",
						"AADL_Project::Size",
						"AADL_Project::Size_Range",
						"AADL_Project::Time",
						"AADL_Project::Time_Range"
					])
				]
			]
			ownedPropertyConstants.get(1) => [
				"const2".assertEquals(name)
				// Tests scope_PropertyConstant_referencedPropertyType
				assertScope(Aadl2Package::eINSTANCE.propertyConstant_ReferencedPropertyType, #[
					"Access_Rights",
					"Array_Size_Range",
					"Connection_Pair",
					"Data_Rate_Units",
					"Data_Volume",
					"Data_Volume_Units",
					"IO_Reference_Time",
					"IO_Time_Spec",
					"Priority_Mapping",
					"Processor_Speed_Units",
					"Rate_Spec",
					"Size",
					"Size_Range",
					"Size_Units",
					"Supported_Active_Thread_Handling_Protocols",
					"Supported_Classifier_Substitutions",
					"Supported_Concurrency_Control_Protocols",
					"Supported_Connection_Patterns",
					"Supported_Connection_QoS",
					"Supported_Dispatch_Protocols",
					"Supported_Distributions",
					"Supported_Hardware_Source_Languages",
					"Supported_Queue_Processing_Protocols",
					"Supported_Scheduling_Protocols",
					"Supported_Source_Languages",
					"Time",
					"Time_Range",
					"Time_Units",
					"ps::pt1",
					"ps::pt2",
					"ps::pt3",
					"ps::pt4",
					"ps::ut1",
					"AADL_Project::Data_Rate_Units",
					"AADL_Project::Data_Volume",
					"AADL_Project::Data_Volume_Units",
					"AADL_Project::Processor_Speed_Units",
					"AADL_Project::Size_Units",
					"AADL_Project::Supported_Active_Thread_Handling_Protocols",
					"AADL_Project::Supported_Classifier_Substitutions",
					"AADL_Project::Supported_Concurrency_Control_Protocols",
					"AADL_Project::Supported_Connection_Patterns",
					"AADL_Project::Supported_Connection_QoS",
					"AADL_Project::Supported_Dispatch_Protocols",
					"AADL_Project::Supported_Distributions",
					"AADL_Project::Supported_Hardware_Source_Languages",
					"AADL_Project::Supported_Queue_Processing_Protocols",
					"AADL_Project::Supported_Scheduling_Protocols",
					"AADL_Project::Supported_Source_Languages",
					"AADL_Project::Time_Units",
					"Communication_Properties::Connection_Pair",
					"Communication_Properties::IO_Reference_Time",
					"Communication_Properties::IO_Time_Spec",
					"Communication_Properties::Rate_Spec",
					"Deployment_Properties::Priority_Mapping",
					"Memory_Properties::Access_Rights",
					"Modeling_Properties::Array_Size_Range",
					"AADL_Project::Size",
					"AADL_Project::Size_Range",
					"AADL_Project::Time",
					"AADL_Project::Time_Range"
				])
			]
		]
	}

	/*
	 * Tests the reference ArraySize_SizeProperty used in the parser rule ArraySize.
	 */
	@Test
	def void testPropertySetReferences2() {
		val pkg = testHelper.parseString(pack1, ps, pack2) as AadlPackage
		pkg => [
			"pack1".assertEquals(name)
			publicSection.ownedClassifiers.head as ComponentType => [
				"a1".assertEquals(name)
				ownedAbstractFeatures.head => [
					"af".assertEquals(name)
					arrayDimensions.head.size => [
						"ps::const1".assertEquals((sizeProperty as NamedElement).qualifiedName())
						// Tests the reference ArraySize_SizeProperty
						assertScope(Aadl2Package::eINSTANCE.arraySize_SizeProperty, #[
							"Max_Aadlinteger",
							"Max_Base_Address",
							"Max_Byte_Count",
							"Max_Memory_Size",
							"Max_Queue_Size",
							"Max_Target_Integer",
							"Max_Thread_Limit",
							"Max_Time",
							"Max_Urgency",
							"Max_Volume",
							"Max_Word_Space",
							"Supported_Classifier_Complement_Matches",
							"Supported_Classifier_Equivalence_Matches",
							"Supported_Classifier_Subset_Matches",
							"Supported_Type_Conversions",
							"ps::const1",
							"ps::const2",
							"AADL_Project::Max_Aadlinteger",
							"AADL_Project::Max_Base_Address",
							"AADL_Project::Max_Byte_Count",
							"AADL_Project::Max_Memory_Size",
							"AADL_Project::Max_Queue_Size",
							"AADL_Project::Max_Target_Integer",
							"AADL_Project::Max_Thread_Limit",
							"AADL_Project::Max_Time",
							"AADL_Project::Max_Urgency",
							"AADL_Project::Max_Volume",
							"AADL_Project::Max_Word_Space",
							"AADL_Project::Supported_Classifier_Complement_Matches",
							"AADL_Project::Supported_Type_Conversions",
							"AADL_Project::Supported_Classifier_Equivalence_Matches",
							"AADL_Project::Supported_Classifier_Subset_Matches"
						])
					]
				]
			]
		]
	}

	val ps = '''
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
	'''

	val pack1 = '''
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
	'''

	val pack2 = '''
		package pack2
		public
		  abstract a2
		  end a2;
		  
		  abstract implementation a2.i
		  end a2.i;
		end pack2;
	'''
}
