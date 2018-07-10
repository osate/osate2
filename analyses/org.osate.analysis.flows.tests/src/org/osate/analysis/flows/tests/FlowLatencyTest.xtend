package org.osate.analysis.flows.tests

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch
import org.osate.result.RealValue
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

import static extension org.junit.Assert.assertEquals

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class FlowLatencyTest extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	
	@Test
	def void flows_pullprotocols() {
		val pkg = testHelper.parseString(pullprotocolsText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 'stub.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'stub.i'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals("stub_i_Instance", instance.name)

		// check flow latency
		val checker = new FlowLatencyAnalysisSwitch(new NullProgressMonitor,  instance)
		val som = instance.systemOperationModes.head
		val latencyresult = checker.invoke(instance, som, true, true, true, true)
		val res = latencyresult.results.get(0)
		assertTrue((res.values.get(1) as RealValue).value == (304.0))
		assertTrue((res.values.get(2) as RealValue).value == (504.0))
		assertTrue((res.values.get(3) as RealValue).value == (4.0))
		assertTrue((res.values.get(4) as RealValue).value == (4.0))
		assertTrue((res.values.get(5) as RealValue).value == (300.0))
		assertTrue((res.values.get(6) as RealValue).value == (300.0))
		res.subResults.size.assertEquals(16)
	}

	val pullprotocolsText = '''
package PullProtocols
public

virtual bus DCFMInputPullProtocol
properties
Transmission_Type => pull;
Latency => 300 ms .. 300 ms ; -- should be allowed on virtual bus
-- Implemented_As => classifier (PullDCFMInputDataset.CrossPartition);
-- implemented_as wants a system implementation or an abstract implementation
-- On the other hand latency analysis currently assumes that threads sit inside processes for one way of recognizing partition boundaries.
end DCFMInputPullProtocol;

process PullDCFMInputDataset
features
SenderData: in data port ;
ReceiverData: out data port ;
flows
Xfer: flow path SenderData -> ReceiverData;
end PullDCFMInputDataset; 

process implementation PullDCFMInputDataset.CrossPartition
subcomponents
 sender: thread PullDCFMDataSetSender;
 requestor: thread PullDCFMDataSetRequestor;
 connections
 	incoming: port SenderData -> sender.SenderData;
 	outgoing: port requestor.ReceiverData -> ReceiverData;
 	STRequest: port requestor.SourceTracksRequest -> sender.SourceTracksRequest ;--{Timing => Immediate;};
 	STReply: port sender.SendSourceTrackSet -> requestor.ReceivedSourceTrackSet
 		;--{Timing => Delayed;};
 	CTRequest: port requestor.CorrelatedTracksRequest -> sender.CorrelatedTracksRequest;--{Timing => Immediate;};
 	CTReply: port sender.SendCorrelatedTrackSet -> requestor.ReceivedCorrelatedTrackSet;-- {Timing => Delayed;};
 	APRequest: port requestor.OwnAircraftPositionRequest -> sender.OwnAircraftPositionRequest;--{Timing => Immediate;};
 	APReply: port sender.SendOwnAircraftPosition -> requestor.ReceivedOwnAircraftPosition;-- {Timing => Delayed;};
 flows
 -- flow to measure latency of protocol. The result is to be reflected in the latency property of the virtual bus it implements
 	XferOnly: end to end flow sender.SourceTrackFlow -> STReply -> requestor.SourceTrackReceivedFlow -> CTRequest ->
 		sender.CorrelatedFlow -> CTReply -> requestor.CorrelatedTrackReceivedFlow -> 
 		APRequest -> sender.AircraftPositionFlow -> APReply -> requestor.AircraftPositionReceivedFlow;
-- 		{Latency => 10 ms .. 10 ms;};
 -- flow to be used when abstract implementation is used in the transfer instead of a protocol binding 
 	Xfer: flow path SenderData -> incoming -> sender.SenderDataSetFLow -> STReply -> requestor.SourceTrackReceivedFlow -> CTRequest ->
 		sender.CorrelatedFlow -> CTReply -> requestor.CorrelatedTrackReceivedFlow -> APRequest -> sender.AircraftPositionFlow -> APReply -> requestor.ReceivedDataSetFlow
 		-> outgoing -> ReceiverData;
 	properties
 	-- alternating immediate/delayed emulates partition slots and communication within a frame.
 	-- making all delayed emulates frame delayed cross partition communication.
 	-- we could also indicates partitions by tagging the process as SEI::isPartition and a SEI::Partition_Latency
 	-- Alternatively we can use virtual processor and the ARINC653 properties or the period on the virtual processor
 		Timing => Immediate applies to STRequest,CTRequest,APRequest;
 		Timing => Delayed applies to STReply,CTReply,APReply;
 		Latency => 300 ms .. 300 ms applies to XferOnly;
 		Period => 100 ms applies to sender, requestor;
-- 		Deadline => 1 ms applies to sender, requestor;
 		Dispatch_Protocol => Periodic applies to sender, requestor;
end PullDCFMInputDataset.CrossPartition;

system stub
end stub;

system implementation stub.i
subcomponents
 prot: process PullDCFMInputDataset.CrossPartition;
end stub.i;

thread PullDCFMDataSetSender
features
-- data to be transferred
SenderData: in data port  ;
-- protocol interaction ports
SourceTracksRequest: in data port;
SendSourceTrackSet: out data port ;
CorrelatedTracksRequest: in data port;
SendCorrelatedTrackSet: out data port ;
OwnAircraftPositionRequest: in data port;
SendOwnAircraftPosition: out data port  ;
flows
	SenderDataSetFLow: flow path SenderData -> SendSourceTrackSet;
	SourceTrackFlow: flow source SendSourceTrackSet;
	SourceTrackFlowpath: flow path SourceTracksRequest->SendSourceTrackSet;
	CorrelatedFlow: flow path CorrelatedTracksRequest -> SendCorrelatedTrackSet;
	AircraftPositionFlow: flow path OwnAircraftPositionRequest -> SendOwnAircraftPosition;
properties
	Dispatch_Protocol => Periodic;
	Latency => 1ms..1ms applies to SourceTrackFlowpath, CorrelatedFlow, AircraftPositionFlow;
end PullDCFMDataSetSender;

thread PullDCFMDataSetRequestor
features
-- data being transferred
ReceiverData: out data port  ;
-- protocol interaction ports
SourceTracksRequest: out data port;
ReceivedSourceTrackSet: in data port ;
CorrelatedTracksRequest: out data port;
ReceivedCorrelatedTrackSet: in data port ;
OwnAircraftPositionRequest: out data port;
ReceivedOwnAircraftPosition: in data port  ;
flows
	SourceTrackRequestFlow: flow source SourceTracksRequest;
	SourceTrackReceivedFlow: flow path ReceivedSourceTrackSet -> CorrelatedTracksRequest;
	CorrelatedTrackReceivedFlow: flow path ReceivedCorrelatedTrackSet -> OwnAircraftPositionRequest;
	AircraftPositionReceivedFlow: flow sink ReceivedOwnAircraftPosition ;
	ReceivedDataSetFlow: flow path ReceivedOwnAircraftPosition -> ReceiverData;
properties
	Dispatch_Protocol => Periodic;
	Latency => 1ms..1ms applies to SourceTrackReceivedFlow, CorrelatedTrackReceivedFlow;
	Latency => 0ms..0ms applies to SourceTracksRequest, AircraftPositionReceivedFlow;
	end PullDCFMDataSetRequestor;

end PullProtocols;
	'''


}
