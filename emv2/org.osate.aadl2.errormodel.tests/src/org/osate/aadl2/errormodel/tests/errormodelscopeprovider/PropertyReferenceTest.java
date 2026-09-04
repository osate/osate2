/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.errormodel.tests.errormodelscopeprovider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

/**
 * Verifies property-reference scoping in EMV2 associations and transition branches.
 */
@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class PropertyReferenceTest extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;
	private AssertHelper assertHelper = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.emv2")).<AssertHelper>get(AssertHelper.class);

	@Test
	public void testBranchValue() throws Exception {
		var ps1 = """
				property set ps1 is
				\tdef1: aadlreal applies to (all);
				end ps1;
				""";
		var lib1 = """
				package lib1
				public
				\tannex EMV2 {**
				\t\terror behavior bvr
				\t\tevents
				\t\t\terr_evt1: error event;
				\t\tstates
				\t\t\tbvr_state1: state;
				\t\t\tbvr_state2: state;
				\t\ttransitions
				\t\t\ttransition1: bvr_state1 -[ err_evt1 ]-> (bvr_state2 with 0.2_0, bvr_state2 with ps1::def1);
				\t\tend behavior;
				\t**};
				end lib1;
				""";
		var subclause1 = """
				package subclause1
				public
				\twith ps1;
				\t
				\tabstract a
				\tannex EMV2 {**
				\t\tuse behavior lib1::bvr;
				\t\t
				\t\tcomponent error behavior
				\t\tevents
				\t\t\terr_evt2: error event;
				\t\ttransitions
				\t\t\ttransition2: bvr_state1 -[ err_evt2 ]-> (bvr_state2 with 0.2, bvr_state2 with ps1::def1);
				\t\tend component;
				\t\t
				\t\tproperties
				\t\t\tps1::def1 => 0.7 applies to transition2;
				\t**};
				\tend a;
				end subclause1;
				""";
		final List<String> expectedScope = List.of("Acceptable_Array_Size", "Access_Right", "Access_Time",
				"Activate_Deadline", "Activate_Entrypoint", "Activate_Entrypoint_Call_Sequence",
				"Activate_Entrypoint_Source_Text", "Activate_Execution_Time", "Active_Thread_Handling_Protocol",
				"Active_Thread_Queue_Handling_Protocol", "Actual_Connection_Binding", "Actual_Function_Binding",
				"Actual_Latency", "Actual_Memory_Binding", "Actual_Processor_Binding", "Actual_Subprogram_Call",
				"Actual_Subprogram_Call_Binding", "Allowed_Connection_Binding", "Allowed_Connection_Binding_Class",
				"Allowed_Connection_Type", "Allowed_Dispatch_Protocol", "Allowed_Memory_Binding",
				"Allowed_Memory_Binding_Class", "Allowed_Message_Size", "Allowed_Period", "Allowed_Physical_Access",
				"Allowed_Physical_Access_Class", "Allowed_Processor_Binding", "Allowed_Processor_Binding_Class",
				"Allowed_Subprogram_Call", "Allowed_Subprogram_Call_Binding", "Assign_Time", "Base_Address",
				"Byte_Count", "Classifier_Matching_Rule", "Classifier_Substitution_Rule",
				"Client_Subprogram_Execution_Time", "Clock_Jitter", "Clock_Period", "Clock_Period_Range", "Code_Size",
				"Collocated", "Compute_Deadline", "Compute_Entrypoint", "Compute_Entrypoint_Call_Sequence",
				"Compute_Entrypoint_Source_Text", "Compute_Execution_Time", "Concurrency_Control_Protocol",
				"Connection_Pattern", "Connection_Set", "Criticality", "Data_Rate", "Data_Size", "Deactivate_Deadline",
				"Deactivate_Entrypoint", "Deactivate_Entrypoint_Call_Sequence", "Deactivate_Entrypoint_Source_Text",
				"Deactivate_Execution_Time", "Deactivation_Policy", "Deadline", "Dequeue_Protocol", "Dequeued_Items",
				"Device_Driver", "Device_Register_Address", "Dispatch_Able", "Dispatch_Jitter", "Dispatch_Offset",
				"Dispatch_Protocol", "Dispatch_Trigger", "Execution_Time", "Fan_Out_Policy", "Finalize_Deadline",
				"Finalize_Entrypoint", "Finalize_Entrypoint_Call_Sequence", "Finalize_Entrypoint_Source_Text",
				"Finalize_Execution_Time", "First_Dispatch_Time", "Frame_Period", "Hardware_Description_Source_Text",
				"Hardware_Source_Language", "Heap_Size", "Implemented_As", "Initialize_Deadline",
				"Initialize_Entrypoint", "Initialize_Entrypoint_Call_Sequence", "Initialize_Entrypoint_Source_Text",
				"Initialize_Execution_Time", "Input_Rate", "Input_Time", "Latency", "Load_Deadline", "Load_Time",
				"Memory_Protocol", "Memory_Size", "Mode_Transition_Response", "Not_Collocated", "Output_Rate",
				"Output_Time", "Overflow_Handling_Protocol", "POSIX_Scheduling_Policy", "Period",
				"Preemptive_Scheduler", "Priority", "Priority_Map", "Priority_Range", "Process_Swap_Execution_Time",
				"Processor_Capacity", "Prototype_Substitution_Rule", "Provided_Connection_Quality_Of_Service",
				"Provided_Virtual_Bus_Class", "Queue_Processing_Protocol", "Queue_Size", "Read_Time",
				"Recover_Deadline", "Recover_Entrypoint", "Recover_Entrypoint_Call_Sequence",
				"Recover_Entrypoint_Source_Text", "Recover_Execution_Time", "Reference_Processor",
				"Required_Connection", "Required_Connection_Quality_Of_Service", "Required_Virtual_Bus_Class",
				"Resumption_Policy", "Runtime_Protection", "Runtime_Protection_Support", "Scheduler_Quantum",
				"Scheduling_Protocol", "Slot_Time", "Source_Code_Size", "Source_Data_Size", "Source_Heap_Size",
				"Source_Language", "Source_Name", "Source_Stack_Size", "Source_Text", "Stack_Size", "Startup_Deadline",
				"Startup_Execution_Time", "Subprogram_Call_Rate", "Subprogram_Call_Type", "Supported_Source_Language",
				"Synchronized_Component", "Thread_Limit", "Thread_Swap_Execution_Time", "Time_Slot", "Timing",
				"Transmission_Time", "Transmission_Type", "Type_Source_Name", "Urgency", "Word_Size", "Word_Space",
				"Write_Time", "ps1::def1", "Communication_Properties::Actual_Latency",
				"Communication_Properties::Connection_Pattern", "Communication_Properties::Connection_Set",
				"Communication_Properties::Data_Rate", "Communication_Properties::Fan_Out_Policy",
				"Communication_Properties::Input_Rate", "Communication_Properties::Input_Time",
				"Communication_Properties::Latency", "Communication_Properties::Output_Rate",
				"Communication_Properties::Output_Time", "Communication_Properties::Overflow_Handling_Protocol",
				"Communication_Properties::Queue_Processing_Protocol", "Communication_Properties::Queue_Size",
				"Communication_Properties::Required_Connection", "Communication_Properties::Subprogram_Call_Rate",
				"Communication_Properties::Timing", "Communication_Properties::Transmission_Time",
				"Communication_Properties::Transmission_Type", "Deployment_Properties::Actual_Connection_Binding",
				"Deployment_Properties::Actual_Function_Binding", "Deployment_Properties::Actual_Memory_Binding",
				"Deployment_Properties::Actual_Processor_Binding", "Deployment_Properties::Actual_Subprogram_Call",
				"Deployment_Properties::Actual_Subprogram_Call_Binding",
				"Deployment_Properties::Allowed_Connection_Binding",
				"Deployment_Properties::Allowed_Connection_Binding_Class",
				"Deployment_Properties::Allowed_Connection_Type", "Deployment_Properties::Allowed_Dispatch_Protocol",
				"Deployment_Properties::Allowed_Memory_Binding", "Deployment_Properties::Allowed_Memory_Binding_Class",
				"Deployment_Properties::Allowed_Period", "Deployment_Properties::Allowed_Physical_Access",
				"Deployment_Properties::Allowed_Physical_Access_Class",
				"Deployment_Properties::Allowed_Processor_Binding",
				"Deployment_Properties::Allowed_Processor_Binding_Class",
				"Deployment_Properties::Allowed_Subprogram_Call",
				"Deployment_Properties::Allowed_Subprogram_Call_Binding", "Deployment_Properties::Collocated",
				"Deployment_Properties::Memory_Protocol", "Deployment_Properties::Not_Collocated",
				"Deployment_Properties::Preemptive_Scheduler", "Deployment_Properties::Priority_Map",
				"Deployment_Properties::Priority_Range",
				"Deployment_Properties::Provided_Connection_Quality_Of_Service",
				"Deployment_Properties::Provided_Virtual_Bus_Class",
				"Deployment_Properties::Required_Connection_Quality_Of_Service",
				"Deployment_Properties::Required_Virtual_Bus_Class",
				"Deployment_Properties::Runtime_Protection_Support", "Deployment_Properties::Scheduling_Protocol",
				"Deployment_Properties::Thread_Limit", "Memory_Properties::Access_Right",
				"Memory_Properties::Access_Time", "Memory_Properties::Allowed_Message_Size",
				"Memory_Properties::Assign_Time", "Memory_Properties::Base_Address", "Memory_Properties::Byte_Count",
				"Memory_Properties::Code_Size", "Memory_Properties::Data_Size",
				"Memory_Properties::Device_Register_Address", "Memory_Properties::Heap_Size",
				"Memory_Properties::Memory_Size", "Memory_Properties::Read_Time", "Memory_Properties::Source_Code_Size",
				"Memory_Properties::Source_Data_Size", "Memory_Properties::Source_Heap_Size",
				"Memory_Properties::Source_Stack_Size", "Memory_Properties::Stack_Size", "Memory_Properties::Word_Size",
				"Memory_Properties::Word_Space", "Memory_Properties::Write_Time",
				"Modeling_Properties::Acceptable_Array_Size", "Modeling_Properties::Classifier_Matching_Rule",
				"Modeling_Properties::Classifier_Substitution_Rule", "Modeling_Properties::Implemented_As",
				"Modeling_Properties::Prototype_Substitution_Rule", "Programming_Properties::Activate_Entrypoint",
				"Programming_Properties::Activate_Entrypoint_Call_Sequence",
				"Programming_Properties::Activate_Entrypoint_Source_Text", "Programming_Properties::Compute_Entrypoint",
				"Programming_Properties::Compute_Entrypoint_Call_Sequence",
				"Programming_Properties::Compute_Entrypoint_Source_Text",
				"Programming_Properties::Deactivate_Entrypoint",
				"Programming_Properties::Deactivate_Entrypoint_Call_Sequence",
				"Programming_Properties::Deactivate_Entrypoint_Source_Text", "Programming_Properties::Device_Driver",
				"Programming_Properties::Finalize_Entrypoint",
				"Programming_Properties::Finalize_Entrypoint_Call_Sequence",
				"Programming_Properties::Finalize_Entrypoint_Source_Text",
				"Programming_Properties::Hardware_Description_Source_Text",
				"Programming_Properties::Hardware_Source_Language", "Programming_Properties::Initialize_Entrypoint",
				"Programming_Properties::Initialize_Entrypoint_Call_Sequence",
				"Programming_Properties::Initialize_Entrypoint_Source_Text",
				"Programming_Properties::Recover_Entrypoint",
				"Programming_Properties::Recover_Entrypoint_Call_Sequence",
				"Programming_Properties::Recover_Entrypoint_Source_Text", "Programming_Properties::Source_Language",
				"Programming_Properties::Source_Name", "Programming_Properties::Source_Text",
				"Programming_Properties::Supported_Source_Language", "Programming_Properties::Type_Source_Name",
				"Thread_Properties::Active_Thread_Handling_Protocol",
				"Thread_Properties::Active_Thread_Queue_Handling_Protocol",
				"Thread_Properties::Concurrency_Control_Protocol", "Thread_Properties::Criticality",
				"Thread_Properties::Deactivation_Policy", "Thread_Properties::Dequeue_Protocol",
				"Thread_Properties::Dequeued_Items", "Thread_Properties::Dispatch_Able",
				"Thread_Properties::Dispatch_Protocol", "Thread_Properties::Dispatch_Trigger",
				"Thread_Properties::Mode_Transition_Response", "Thread_Properties::POSIX_Scheduling_Policy",
				"Thread_Properties::Priority", "Thread_Properties::Resumption_Policy",
				"Thread_Properties::Runtime_Protection", "Thread_Properties::Subprogram_Call_Type",
				"Thread_Properties::Synchronized_Component", "Thread_Properties::Time_Slot",
				"Thread_Properties::Urgency", "Timing_Properties::Activate_Deadline",
				"Timing_Properties::Activate_Execution_Time", "Timing_Properties::Client_Subprogram_Execution_Time",
				"Timing_Properties::Clock_Jitter", "Timing_Properties::Clock_Period",
				"Timing_Properties::Clock_Period_Range", "Timing_Properties::Compute_Deadline",
				"Timing_Properties::Compute_Execution_Time", "Timing_Properties::Deactivate_Deadline",
				"Timing_Properties::Deactivate_Execution_Time", "Timing_Properties::Deadline",
				"Timing_Properties::Dispatch_Jitter", "Timing_Properties::Dispatch_Offset",
				"Timing_Properties::Execution_Time", "Timing_Properties::Finalize_Deadline",
				"Timing_Properties::Finalize_Execution_Time", "Timing_Properties::First_Dispatch_Time",
				"Timing_Properties::Frame_Period", "Timing_Properties::Initialize_Deadline",
				"Timing_Properties::Initialize_Execution_Time", "Timing_Properties::Load_Deadline",
				"Timing_Properties::Load_Time", "Timing_Properties::Period",
				"Timing_Properties::Process_Swap_Execution_Time", "Timing_Properties::Processor_Capacity",
				"Timing_Properties::Recover_Deadline", "Timing_Properties::Recover_Execution_Time",
				"Timing_Properties::Reference_Processor", "Timing_Properties::Scheduler_Quantum",
				"Timing_Properties::Slot_Time", "Timing_Properties::Startup_Deadline",
				"Timing_Properties::Startup_Execution_Time", "Timing_Properties::Thread_Swap_Execution_Time",
				"Reference_Time", "Timing_Properties::Reference_Time");
		final FluentIssueCollection lib1TestResult = this.issues = this.testHelper.testString(lib1, ps1);
		final FluentIssueCollection lib1IssueCollection = new FluentIssueCollection(lib1TestResult.getResource(),
				new ArrayList<>(), new ArrayList<>());
		var aadlPackage = ((AadlPackage) (lib1TestResult.getResource().getContents()).getFirst());
		Assert.assertEquals("lib1", aadlPackage.getName());
		var errorBehaviorStateMachine = (((ErrorModelLibrary) ((DefaultAnnexLibrary) (aadlPackage.getPublicSection()
				.getOwnedAnnexLibraries()).getFirst()).getParsedAnnexLibrary()).getBehaviors()).getFirst();
		Assert.assertEquals("bvr", errorBehaviorStateMachine.getName());
		var errorBehaviorTransition = (errorBehaviorStateMachine.getTransitions()).getFirst();
		Assert.assertEquals("transition1", errorBehaviorTransition.getName());
		AssertHelper.assertError(errorBehaviorTransition, lib1TestResult.getIssues(), lib1IssueCollection,
				"Sum of branch probabilities must be 1");
		this.assertHelper.assertScope(errorBehaviorTransition.getDestinationBranches().get(1).getValue(),
				ErrorModelPackage.eINSTANCE.getBranchValue_Symboliclabel(), expectedScope);

		lib1IssueCollection.sizeIs(lib1TestResult.getIssues().size());
		this.assertConstraints(lib1IssueCollection);
		final FluentIssueCollection subclause1TestResult = this.issues = this.testHelper.testString(subclause1, lib1,
				ps1);
		final FluentIssueCollection subclause1IssueCollection = new FluentIssueCollection(
				subclause1TestResult.getResource(), new ArrayList<>(), new ArrayList<>());
		var aadlPackage2 = ((AadlPackage) (subclause1TestResult.getResource().getContents()).getFirst());
		Assert.assertEquals("subclause1", aadlPackage2.getName());
		var classifier = (aadlPackage2.getPublicSection().getOwnedClassifiers()).getFirst();
		Assert.assertEquals("a", classifier.getName());
		var errorBehaviorTransition2 = (((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier
				.getOwnedAnnexSubclauses()).getFirst()).getParsedAnnexSubclause()).getTransitions()).getFirst();
		Assert.assertEquals("transition2", errorBehaviorTransition2.getName());
		AssertHelper.assertError(errorBehaviorTransition2, subclause1TestResult.getIssues(), subclause1IssueCollection,
				"Sum of branch probabilities must be 1");
		this.assertHelper.assertScope(errorBehaviorTransition2.getDestinationBranches().get(1).getValue(),
				ErrorModelPackage.eINSTANCE.getBranchValue_Symboliclabel(), expectedScope);

		subclause1IssueCollection.sizeIs(subclause1TestResult.getIssues().size());
		this.assertConstraints(subclause1IssueCollection);

	}

	@Test
	public void testEMV2PropertyAssociation() throws Exception {
		var ps1 = """
				property set ps1 is
				\tdef1: aadlreal applies to (all);
				end ps1;
				""";
		var lib1 = """
				package lib1
				public
				\twith ps1;
				\t
				\tannex EMV2 {**
				\t\terror types
				\t\t\tt1: type;
				\t\tproperties
				\t\t\tps1::def1 => 1.1 applies to t1;
				\t\tend types;
				\t\t
				\t\terror behavior bvr1
				\t\tevents
				\t\t\terrorEvent1: error event;
				\t\tproperties
				\t\t\tps1::def1 => 2.2 applies to errorEvent1;
				\t\tend behavior;
				\t**};
				end lib1;
				""";
		var subclause1 = """
				package subclause1
				public
				\twith ps1;
				\t
				\tabstract a
				\tannex EMV2 {**
				\t\tcomponent error behavior
				\t\tevents
				\t\t\terrorEvent2: error event;
				\t\tend component;
				\t\t
				\t\tproperties
				\t\t\tps1::def1 => 3.3 applies to errorEvent2;
				\t**};
				\tend a;
				end subclause1;
				""";
		final List<String> expectedScope = List.of("Acceptable_Array_Size", "Access_Right", "Access_Time",
				"Activate_Deadline", "Activate_Entrypoint", "Activate_Entrypoint_Call_Sequence",
				"Activate_Entrypoint_Source_Text", "Activate_Execution_Time", "Active_Thread_Handling_Protocol",
				"Active_Thread_Queue_Handling_Protocol", "Actual_Connection_Binding", "Actual_Function_Binding",
				"Actual_Latency", "Actual_Memory_Binding", "Actual_Processor_Binding", "Actual_Subprogram_Call",
				"Actual_Subprogram_Call_Binding", "Allowed_Connection_Binding", "Allowed_Connection_Binding_Class",
				"Allowed_Connection_Type", "Allowed_Dispatch_Protocol", "Allowed_Memory_Binding",
				"Allowed_Memory_Binding_Class", "Allowed_Message_Size", "Allowed_Period", "Allowed_Physical_Access",
				"Allowed_Physical_Access_Class", "Allowed_Processor_Binding", "Allowed_Processor_Binding_Class",
				"Allowed_Subprogram_Call", "Allowed_Subprogram_Call_Binding", "Assign_Time", "Base_Address",
				"Byte_Count", "Classifier_Matching_Rule", "Classifier_Substitution_Rule",
				"Client_Subprogram_Execution_Time", "Clock_Jitter", "Clock_Period", "Clock_Period_Range", "Code_Size",
				"Collocated", "Compute_Deadline", "Compute_Entrypoint", "Compute_Entrypoint_Call_Sequence",
				"Compute_Entrypoint_Source_Text", "Compute_Execution_Time", "Concurrency_Control_Protocol",
				"Connection_Pattern", "Connection_Set", "Criticality", "Data_Rate", "Data_Size", "Deactivate_Deadline",
				"Deactivate_Entrypoint", "Deactivate_Entrypoint_Call_Sequence", "Deactivate_Entrypoint_Source_Text",
				"Deactivate_Execution_Time", "Deactivation_Policy", "Deadline", "Dequeue_Protocol", "Dequeued_Items",
				"Device_Driver", "Device_Register_Address", "Dispatch_Able", "Dispatch_Jitter", "Dispatch_Offset",
				"Dispatch_Protocol", "Dispatch_Trigger", "Execution_Time", "Fan_Out_Policy", "Finalize_Deadline",
				"Finalize_Entrypoint", "Finalize_Entrypoint_Call_Sequence", "Finalize_Entrypoint_Source_Text",
				"Finalize_Execution_Time", "First_Dispatch_Time", "Frame_Period", "Hardware_Description_Source_Text",
				"Hardware_Source_Language", "Heap_Size", "Implemented_As", "Initialize_Deadline",
				"Initialize_Entrypoint", "Initialize_Entrypoint_Call_Sequence", "Initialize_Entrypoint_Source_Text",
				"Initialize_Execution_Time", "Input_Rate", "Input_Time", "Latency", "Load_Deadline", "Load_Time",
				"Memory_Protocol", "Memory_Size", "Mode_Transition_Response", "Not_Collocated", "Output_Rate",
				"Output_Time", "Overflow_Handling_Protocol", "POSIX_Scheduling_Policy", "Period",
				"Preemptive_Scheduler", "Priority", "Priority_Map", "Priority_Range", "Process_Swap_Execution_Time",
				"Processor_Capacity", "Prototype_Substitution_Rule", "Provided_Connection_Quality_Of_Service",
				"Provided_Virtual_Bus_Class", "Queue_Processing_Protocol", "Queue_Size", "Read_Time",
				"Recover_Deadline", "Recover_Entrypoint", "Recover_Entrypoint_Call_Sequence",
				"Recover_Entrypoint_Source_Text", "Recover_Execution_Time", "Reference_Processor",
				"Required_Connection", "Required_Connection_Quality_Of_Service", "Required_Virtual_Bus_Class",
				"Resumption_Policy", "Runtime_Protection", "Runtime_Protection_Support", "Scheduler_Quantum",
				"Scheduling_Protocol", "Slot_Time", "Source_Code_Size", "Source_Data_Size", "Source_Heap_Size",
				"Source_Language", "Source_Name", "Source_Stack_Size", "Source_Text", "Stack_Size", "Startup_Deadline",
				"Startup_Execution_Time", "Subprogram_Call_Rate", "Subprogram_Call_Type", "Supported_Source_Language",
				"Synchronized_Component", "Thread_Limit", "Thread_Swap_Execution_Time", "Time_Slot", "Timing",
				"Transmission_Time", "Transmission_Type", "Type_Source_Name", "Urgency", "Word_Size", "Word_Space",
				"Write_Time", "ps1::def1", "Communication_Properties::Actual_Latency",
				"Communication_Properties::Connection_Pattern", "Communication_Properties::Connection_Set",
				"Communication_Properties::Data_Rate", "Communication_Properties::Fan_Out_Policy",
				"Communication_Properties::Input_Rate", "Communication_Properties::Input_Time",
				"Communication_Properties::Latency", "Communication_Properties::Output_Rate",
				"Communication_Properties::Output_Time", "Communication_Properties::Overflow_Handling_Protocol",
				"Communication_Properties::Queue_Processing_Protocol", "Communication_Properties::Queue_Size",
				"Communication_Properties::Required_Connection", "Communication_Properties::Subprogram_Call_Rate",
				"Communication_Properties::Timing", "Communication_Properties::Transmission_Time",
				"Communication_Properties::Transmission_Type", "Deployment_Properties::Actual_Connection_Binding",
				"Deployment_Properties::Actual_Function_Binding", "Deployment_Properties::Actual_Memory_Binding",
				"Deployment_Properties::Actual_Processor_Binding", "Deployment_Properties::Actual_Subprogram_Call",
				"Deployment_Properties::Actual_Subprogram_Call_Binding",
				"Deployment_Properties::Allowed_Connection_Binding",
				"Deployment_Properties::Allowed_Connection_Binding_Class",
				"Deployment_Properties::Allowed_Connection_Type", "Deployment_Properties::Allowed_Dispatch_Protocol",
				"Deployment_Properties::Allowed_Memory_Binding", "Deployment_Properties::Allowed_Memory_Binding_Class",
				"Deployment_Properties::Allowed_Period", "Deployment_Properties::Allowed_Physical_Access",
				"Deployment_Properties::Allowed_Physical_Access_Class",
				"Deployment_Properties::Allowed_Processor_Binding",
				"Deployment_Properties::Allowed_Processor_Binding_Class",
				"Deployment_Properties::Allowed_Subprogram_Call",
				"Deployment_Properties::Allowed_Subprogram_Call_Binding", "Deployment_Properties::Collocated",
				"Deployment_Properties::Memory_Protocol", "Deployment_Properties::Not_Collocated",
				"Deployment_Properties::Preemptive_Scheduler", "Deployment_Properties::Priority_Map",
				"Deployment_Properties::Priority_Range",
				"Deployment_Properties::Provided_Connection_Quality_Of_Service",
				"Deployment_Properties::Provided_Virtual_Bus_Class",
				"Deployment_Properties::Required_Connection_Quality_Of_Service",
				"Deployment_Properties::Required_Virtual_Bus_Class",
				"Deployment_Properties::Runtime_Protection_Support", "Deployment_Properties::Scheduling_Protocol",
				"Deployment_Properties::Thread_Limit", "Memory_Properties::Access_Right",
				"Memory_Properties::Access_Time", "Memory_Properties::Allowed_Message_Size",
				"Memory_Properties::Assign_Time", "Memory_Properties::Base_Address", "Memory_Properties::Byte_Count",
				"Memory_Properties::Code_Size", "Memory_Properties::Data_Size",
				"Memory_Properties::Device_Register_Address", "Memory_Properties::Heap_Size",
				"Memory_Properties::Memory_Size", "Memory_Properties::Read_Time", "Memory_Properties::Source_Code_Size",
				"Memory_Properties::Source_Data_Size", "Memory_Properties::Source_Heap_Size",
				"Memory_Properties::Source_Stack_Size", "Memory_Properties::Stack_Size", "Memory_Properties::Word_Size",
				"Memory_Properties::Word_Space", "Memory_Properties::Write_Time",
				"Modeling_Properties::Acceptable_Array_Size", "Modeling_Properties::Classifier_Matching_Rule",
				"Modeling_Properties::Classifier_Substitution_Rule", "Modeling_Properties::Implemented_As",
				"Modeling_Properties::Prototype_Substitution_Rule", "Programming_Properties::Activate_Entrypoint",
				"Programming_Properties::Activate_Entrypoint_Call_Sequence",
				"Programming_Properties::Activate_Entrypoint_Source_Text", "Programming_Properties::Compute_Entrypoint",
				"Programming_Properties::Compute_Entrypoint_Call_Sequence",
				"Programming_Properties::Compute_Entrypoint_Source_Text",
				"Programming_Properties::Deactivate_Entrypoint",
				"Programming_Properties::Deactivate_Entrypoint_Call_Sequence",
				"Programming_Properties::Deactivate_Entrypoint_Source_Text", "Programming_Properties::Device_Driver",
				"Programming_Properties::Finalize_Entrypoint",
				"Programming_Properties::Finalize_Entrypoint_Call_Sequence",
				"Programming_Properties::Finalize_Entrypoint_Source_Text",
				"Programming_Properties::Hardware_Description_Source_Text",
				"Programming_Properties::Hardware_Source_Language", "Programming_Properties::Initialize_Entrypoint",
				"Programming_Properties::Initialize_Entrypoint_Call_Sequence",
				"Programming_Properties::Initialize_Entrypoint_Source_Text",
				"Programming_Properties::Recover_Entrypoint",
				"Programming_Properties::Recover_Entrypoint_Call_Sequence",
				"Programming_Properties::Recover_Entrypoint_Source_Text", "Programming_Properties::Source_Language",
				"Programming_Properties::Source_Name", "Programming_Properties::Source_Text",
				"Programming_Properties::Supported_Source_Language", "Programming_Properties::Type_Source_Name",
				"Thread_Properties::Active_Thread_Handling_Protocol",
				"Thread_Properties::Active_Thread_Queue_Handling_Protocol",
				"Thread_Properties::Concurrency_Control_Protocol", "Thread_Properties::Criticality",
				"Thread_Properties::Deactivation_Policy", "Thread_Properties::Dequeue_Protocol",
				"Thread_Properties::Dequeued_Items", "Thread_Properties::Dispatch_Able",
				"Thread_Properties::Dispatch_Protocol", "Thread_Properties::Dispatch_Trigger",
				"Thread_Properties::Mode_Transition_Response", "Thread_Properties::POSIX_Scheduling_Policy",
				"Thread_Properties::Priority", "Thread_Properties::Resumption_Policy",
				"Thread_Properties::Runtime_Protection", "Thread_Properties::Subprogram_Call_Type",
				"Thread_Properties::Synchronized_Component", "Thread_Properties::Time_Slot",
				"Thread_Properties::Urgency", "Timing_Properties::Activate_Deadline",
				"Timing_Properties::Activate_Execution_Time", "Timing_Properties::Client_Subprogram_Execution_Time",
				"Timing_Properties::Clock_Jitter", "Timing_Properties::Clock_Period",
				"Timing_Properties::Clock_Period_Range", "Timing_Properties::Compute_Deadline",
				"Timing_Properties::Compute_Execution_Time", "Timing_Properties::Deactivate_Deadline",
				"Timing_Properties::Deactivate_Execution_Time", "Timing_Properties::Deadline",
				"Timing_Properties::Dispatch_Jitter", "Timing_Properties::Dispatch_Offset",
				"Timing_Properties::Execution_Time", "Timing_Properties::Finalize_Deadline",
				"Timing_Properties::Finalize_Execution_Time", "Timing_Properties::First_Dispatch_Time",
				"Timing_Properties::Frame_Period", "Timing_Properties::Initialize_Deadline",
				"Timing_Properties::Initialize_Execution_Time", "Timing_Properties::Load_Deadline",
				"Timing_Properties::Load_Time", "Timing_Properties::Period",
				"Timing_Properties::Process_Swap_Execution_Time", "Timing_Properties::Processor_Capacity",
				"Timing_Properties::Recover_Deadline", "Timing_Properties::Recover_Execution_Time",
				"Timing_Properties::Reference_Processor", "Timing_Properties::Scheduler_Quantum",
				"Timing_Properties::Slot_Time", "Timing_Properties::Startup_Deadline",
				"Timing_Properties::Startup_Execution_Time", "Timing_Properties::Thread_Swap_Execution_Time",
				"Reference_Time", "Timing_Properties::Reference_Time");
		var aadlPackage = ((AadlPackage) (this.testHelper.testString(lib1, ps1).getResource().getContents())
				.getFirst());
		Assert.assertEquals("lib1", aadlPackage.getName());
		var errorModelLibrary = ((ErrorModelLibrary) ((DefaultAnnexLibrary) (aadlPackage.getPublicSection()
				.getOwnedAnnexLibraries()).getFirst()).getParsedAnnexLibrary());
		var emv2PropertyAssociation2 = (errorModelLibrary.getProperties()).getFirst();
		PropertyExpression ownedValue = (emv2PropertyAssociation2.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(1.1, ((RealLiteral) ownedValue).getValue(), 0);
		this.assertHelper.assertScope(emv2PropertyAssociation2,
				Aadl2Package.eINSTANCE.getPropertyAssociation_Property(), expectedScope);
		var errorBehaviorStateMachine = (errorModelLibrary.getBehaviors()).getFirst();
		Assert.assertEquals("bvr1", errorBehaviorStateMachine.getName());
		var emv2PropertyAssociation = (errorBehaviorStateMachine.getProperties()).getFirst();
		PropertyExpression ownedValue2 = (emv2PropertyAssociation.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(2.2, ((RealLiteral) ownedValue2).getValue(), 0);
		this.assertHelper.assertScope(emv2PropertyAssociation, Aadl2Package.eINSTANCE.getPropertyAssociation_Property(),
				expectedScope);

		var aadlPackage2 = ((AadlPackage) (this.testHelper.testString(subclause1, lib1, ps1).getResource()
				.getContents()).getFirst());
		Assert.assertEquals("subclause1", aadlPackage2.getName());
		var emv2PropertyAssociation3 = (((ErrorModelSubclause) ((DefaultAnnexSubclause) ((aadlPackage2
				.getPublicSection().getOwnedClassifiers()).getFirst().getOwnedAnnexSubclauses()).getFirst())
				.getParsedAnnexSubclause()).getProperties()).getFirst();
		PropertyExpression ownedValue3 = (emv2PropertyAssociation3.getOwnedValues()).getFirst().getOwnedValue();
		Assert.assertEquals(3.3, ((RealLiteral) ownedValue3).getValue(), 0);
		this.assertHelper.assertScope(emv2PropertyAssociation3,
				Aadl2Package.eINSTANCE.getPropertyAssociation_Property(), expectedScope);

	}
}
