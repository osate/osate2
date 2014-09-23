package org.osate.analysis.flows.tests

import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.util.Files
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.analysis.flows.actions.CheckFlowLatency
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class FlowLatencyTest extends OsateTest {

	val projectName = "test"
	val projectRoot = "platform:/resource/" + projectName +"/"

	/**
	 *  Must build workspace before running any test. Otherwise we get exceptions.
	 */
	@Before
	def setUp() {
		val test_project = createProject(projectName, "packages")
		buildProject("Plugin_Resources", true)
		setResourceRoot(projectRoot + "packages")
	}

	@Test
	def void flows_pullprotocols() {
		val pullprotocolsFile = "pullprotocols.aadl"
		createFiles(pullprotocolsFile -> pullprotocolsText)
		suppressSerialization
		val result = testFile(pullprotocolsFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == 'stub.i'])

		// instantiate
		val sysImpl = cls.filter[name == 'stub.i'].head as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals("stub_i_Instance", instance.name)

		// check flow latency
		val errorManager = AnalysisErrorReporterManager.NULL_ERROR_MANANGER
		val checker = new CheckFlowLatency()
		val som = instance.systemOperationModes.head
		checker.invoke(new NullProgressMonitor, errorManager, instance, som)

		// read csv
		val uri = URI.createURI(
			projectRoot + "instances/reports/latency/pullprotocols_stub_i_Instance__latencylatency.csv")
		val file = workspaceRoot.getFile(new Path(uri.toPlatformString(true)))
		val actual = Files.readStreamIntoString(file.contents)
		assertEquals('error', expected.trim, actual.trim)
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
	 	STRequest: port requestor.SourceTracksRequest -> sender.SourceTracksRequest;
	 	STReply: port sender.SendSourceTrackSet -> requestor.ReceivedSourceTrackSet
	 		{Required_Virtual_Bus_Class => (classifier (PullProtocols::DCFMInputPullProtocol));};
	 	CTRequest: port requestor.CorrelatedTracksRequest -> sender.CorrelatedTracksRequest;
	 	CTReply: port sender.SendCorrelatedTrackSet -> requestor.ReceivedCorrelatedTrackSet;
	 	APRequest: port requestor.OwnAircraftPositionRequest -> sender.OwnAircraftPositionRequest;
	 	APReply: port sender.SendOwnAircraftPosition -> requestor.ReceivedOwnAircraftPosition;
	 flows
	 -- flow to measure latency of protocol. The result is to be reflected in the latency property of the virtual bus it implements
	 	XferOnly: end to end flow sender.SourceTrackFlow -> STReply -> requestor.SourceTrackReceivedFlow -> CTRequest ->
	 		sender.CorrelatedFlow -> CTReply -> requestor.CorrelatedTrackReceivedFlow -> 
	 		APRequest -> sender.AircraftPositionFlow -> APReply -> requestor.AircraftPositionReceivedFlow
	 		;--{Latency => 10 ms .. 10 ms;};
	 -- flow to be used when abstract implementation is used in the transfer instead of a protocol binding 
	 	Xfer: flow path SenderData -> incoming -> sender.SenderDataSetFLow -> STReply -> requestor.SourceTrackReceivedFlow -> CTRequest ->
	 		sender.CorrelatedFlow -> CTReply -> requestor.CorrelatedTrackReceivedFlow -> APRequest -> sender.AircraftPositionFlow -> APReply -> requestor.ReceivedDataSetFlow
	 		-> outgoing -> ReceiverData;
	 	properties
	 	-- alternating immediate/delayed emulates partition slots and communication within a frame.
	 	-- making all dealeyd emulates frame delayed corss partition communication.
	 	-- we could also indicates partitions by tagging the process as SEI::isPartition and a SEI::Partition_Latency
	 	-- Alternatively we can use virtual processor and the ARINC653 properties or the period on the virtual processor
	 		Timing => Immediate applies to STRequest,CTRequest,APRequest;
	 		Timing => Delayed applies to STReply,CTReply,APReply;
	 		Latency => 10 ms .. 10 ms applies to XferOnly;
	 		Period => 100 ms applies to sender, requestor;
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
	end PullDCFMDataSetRequestor;
	
	end PullProtocols;'''

	val expected = '''
Latency Analysis Report

Flow analysis for end to end flow XferOnly
Contributor,Min Specified,Min Value,Min Method,Max Specified,Max Value,Max Method,Comments,
Thread sender,,100.0ms,deadline,,100.0ms,deadline,Time to take to send the data over the network,
Delayed Connection sender.SendSourceTrackSet -> requestor.ReceivedSourceTrackSet,,0.0ms,period,,100.0ms,period,Data might arrive at dispatch time or next frame,
Protocol DCFMInputPullProtocol,,300.0ms,specified,,300.0ms,specified,Time required by the protocol stack,
Thread requestor,,0.0ms,immediate connection,,0.0ms,immediate connection,The connection is immediate and both parts are synchronized. Using either the min/max execution or assume execution time is negligible,
Immediate Connection requestor.CorrelatedTracksRequest -> sender.CorrelatedTracksRequest,,0.0ms,unknown,,0.0ms,unknown,,
Thread sender,,100.0ms,deadline,,100.0ms,deadline,Time to take to send the data over the network,
Delayed Connection sender.SendCorrelatedTrackSet -> requestor.ReceivedCorrelatedTrackSet,,0.0ms,period,,100.0ms,period,Data might arrive at dispatch time or next frame,
Thread requestor,,0.0ms,immediate connection,,0.0ms,immediate connection,The connection is immediate and both parts are synchronized. Using either the min/max execution or assume execution time is negligible,
Immediate Connection requestor.OwnAircraftPositionRequest -> sender.OwnAircraftPositionRequest,,0.0ms,unknown,,0.0ms,unknown,,
Thread sender,,100.0ms,deadline,,100.0ms,deadline,Time to take to send the data over the network,
Delayed Connection sender.SendOwnAircraftPosition -> requestor.ReceivedOwnAircraftPosition,,0.0ms,period,,100.0ms,period,Data might arrive at dispatch time or next frame,
Thread requestor,,100.0ms,deadline,,100.0ms,deadline,,
Total,0.0ms,700.0ms,,0.0ms,900.0ms,,
Flow Specification,,0.0ms,,,0.0ms,,
Informations,the minimal latency is not specified,
,the maximal latency is not specified,
	'''
}
