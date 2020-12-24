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
package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.PortConnection
import org.osate.aadl2.ProcessImplementation
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*
import org.osate.aadl2.SystemType
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.Connection
import java.util.List
import org.osate.aadl2.instance.ComponentInstance

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2318Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue2318/"
	val static FILE01 = "DirectionTests/UniqueNames/UniDirToContainer_unique.aadl"
	val static FILE02 = "DirectionTests/UniqueNames/BiDirToContainer_OutToIn_unique.aadl"
	val static FILE03 = "DirectionTests/UniqueNames/BiDirToContainer_InToOut_unique.aadl"
	val static FILE04 = "DirectionTests/UniqueNames/UniDirPeerToPeer_unique.aadl"
	val static FILE05 = "DirectionTests/UniqueNames/BiDirPeerToPeer_LtoR_unique.aadl"
	val static FILE06 = "DirectionTests/UniqueNames/BiDirPeerToPeer_RtoL_unique.aadl"
	
	val static FILE11 = "DirectionTests/SameNames/UniDirToContainer_same.aadl"
	val static FILE12 = "DirectionTests/SameNames/BiDirToContainer_OutToIn_same.aadl"
	val static FILE13 = "DirectionTests/SameNames/BiDirToContainer_InToOut_same.aadl"
	val static FILE14 = "DirectionTests/SameNames/UniDirPeerToPeer_same.aadl"
	val static FILE15 = "DirectionTests/SameNames/BiDirPeerToPeer_LtoR_same.aadl"
	val static FILE16 = "DirectionTests/SameNames/BiDirPeerToPeer_RtoL_same.aadl"

	val static TOPLEVEL_I = "toplevel.i"
	val static SUBSYSTEM_I = "subsystem.i"
	val static CONN = "conn"
	val static CONN2 = "conn2"

	val static FIND_FEATURE = "findTests/findFeatureInstance.aadl"

	val static ORIGINAL = "original"
	val static REFINED = "refinedd" // yes, two d's --- "refined" is a keyword, so cannot be a name
	val static UNRELATED = "unrelated"

	val static FIND_SUBCOMPONENT = "findTests/findSubcomponentInstance.aadl"
		
	val static XORIGINAL = "X.original"
	val static XREFINED = "X.refinedd" // yes, two d's --- "refined" is a keyword, so cannot be a name
	val static XUNRELATED = "X.unrelated"

	val static FIND_FLOW_SPEC = "findTests/findFlowSpecInstance.aadl"
	val static FIND_END_TO_END_FLOW = "findTests/findEndToEndFlowInstance.aadl"
	val static FIND_CONNECTION = "findTests/findConnectionInstance.aadl"
	
	val static BI_DIR_PORT_SIMPLE_SAMENAMES = "issueTests/BiDirPortSimple_samenames.aadl"
	val static BI_DIR_PORT_SIMPLE_UNIQUENAMES = "issueTests/BiDirPortSimple_uniquenames.aadl"
	val static FEATURE_GROUP_TEST = "issueTests/FeatureGroupTest.aadl"

	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void UniDirToContainer_unique() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE01)
		
		// Get the declarative connections
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val conn = toplevel.ownedConnections.findFirst[name == CONN] as PortConnection
		
		val subsystem = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == SUBSYSTEM_I] as ProcessImplementation
		val conn2 = subsystem.ownedConnections.findFirst[name == CONN2] as PortConnection
		
		// instantiate
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		assertEquals(1, instance.connectionInstances.size())
		val ci = instance.connectionInstances.get(0)
		assertEquals(false, ci.bidirectional)
		assertEquals(2, ci.connectionReferences.size())
		val cr0 = ci.connectionReferences.get(0)
		val cr1 = ci.connectionReferences.get(1)
		assertEquals(conn2, cr0.connection)
		assertEquals(false, cr0.reverse)
		assertEquals(conn, cr1.connection)
		assertEquals(false, cr1.reverse)
		assertEquals(cr1.source, cr0.destination)
	}
	
	@Test
	def void BiDirToContainer_OutToIn_unique() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE02)
		
		// Get the declarative connections
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val conn = toplevel.ownedConnections.findFirst[name == CONN] as PortConnection
		
		val subsystem = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == SUBSYSTEM_I] as ProcessImplementation
		val conn2 = subsystem.ownedConnections.findFirst[name == CONN2] as PortConnection
		
		// instantiate
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		assertEquals(2, instance.connectionInstances.size())
		{
			val ci0 = instance.connectionInstances.get(0)
			assertEquals(1, ci0.connectionReferences.size())
			val cr0 = ci0.connectionReferences.get(0)
			assertEquals(conn, cr0.connection)
			assertEquals(false, cr0.reverse)
		}		
		
		{
			val ci1 = instance.connectionInstances.get(1)
			assertEquals(false, ci1.bidirectional)
			assertEquals(2, ci1.connectionReferences.size())
			val cr0 = ci1.connectionReferences.get(0)
			val cr1 = ci1.connectionReferences.get(1)
			assertEquals(conn2, cr0.connection)
			assertEquals(false, cr0.reverse)
			assertEquals(conn, cr1.connection)
			assertEquals(true, cr1.reverse)
			assertEquals(cr1.source, cr0.destination)
		}
	}
	
	@Test
	def void BiDirToContainer_InToOut_unique() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE03)
		
		// Get the declarative connections
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val conn = toplevel.ownedConnections.findFirst[name == CONN] as PortConnection
		
		val subsystem = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == SUBSYSTEM_I] as ProcessImplementation
		val conn2 = subsystem.ownedConnections.findFirst[name == CONN2] as PortConnection
		
		// instantiate
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		assertEquals(2, instance.connectionInstances.size())
		{
			val ci0 = instance.connectionInstances.get(0)
			assertEquals(1, ci0.connectionReferences.size())
			val cr0 = ci0.connectionReferences.get(0)
			assertEquals(conn, cr0.connection)
			assertEquals(true, cr0.reverse)
		}		
		
		{
			val ci1 = instance.connectionInstances.get(1)
			assertEquals(false, ci1.bidirectional)
			assertEquals(2, ci1.connectionReferences.size())
			val cr0 = ci1.connectionReferences.get(0)
			val cr1 = ci1.connectionReferences.get(1)
			assertEquals(conn2, cr0.connection)
			assertEquals(false, cr0.reverse)
			assertEquals(conn, cr1.connection)
			assertEquals(false, cr1.reverse)
			assertEquals(cr1.source, cr0.destination)
		}
	}
	
	@Test
	def void UniDirPeerToPeer_unique() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE04)
		
		// Get the declarative connections
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val conn = toplevel.ownedConnections.findFirst[name == CONN] as PortConnection
		
		val subsystem = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == SUBSYSTEM_I] as ProcessImplementation
		val conn2 = subsystem.ownedConnections.findFirst[name == CONN2] as PortConnection
		
		// instantiate
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		assertEquals(1, instance.connectionInstances.size())
		val ci = instance.connectionInstances.get(0)
		assertEquals(false, ci.bidirectional)
		assertEquals(2, ci.connectionReferences.size())
		val cr0 = ci.connectionReferences.get(0)
		val cr1 = ci.connectionReferences.get(1)
		assertEquals(conn2, cr0.connection)
		assertEquals(false, cr0.reverse)
		assertEquals(conn, cr1.connection)
		assertEquals(false, cr1.reverse)
		assertEquals(cr1.source, cr0.destination)
	}
	
	@Test
	def void BiDirPeerToPeer_LtoR_unique() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE05)
		
		// Get the declarative connections
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val conn = toplevel.ownedConnections.findFirst[name == CONN] as PortConnection
		
		val subsystem = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == SUBSYSTEM_I] as ProcessImplementation
		val conn2 = subsystem.ownedConnections.findFirst[name == CONN2] as PortConnection
		
		// instantiate
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		assertEquals(2, instance.connectionInstances.size())
		{
			val ci0 = instance.connectionInstances.get(0)
			assertEquals(1, ci0.connectionReferences.size())
			val cr0 = ci0.connectionReferences.get(0)
			assertEquals(conn, cr0.connection)
			assertEquals(false, cr0.reverse)
		}		
		
		{
			val ci1 = instance.connectionInstances.get(1)
			assertEquals(false, ci1.bidirectional)
			assertEquals(2, ci1.connectionReferences.size())
			val cr0 = ci1.connectionReferences.get(0)
			val cr1 = ci1.connectionReferences.get(1)
			assertEquals(conn2, cr0.connection)
			assertEquals(false, cr0.reverse)
			assertEquals(conn, cr1.connection)
			assertEquals(true, cr1.reverse)
			assertEquals(cr1.source, cr0.destination)
		}
	}
	
	@Test
	def void BiDirPeerToPeer_RtoL_unique() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE06)
		
		// Get the declarative connections
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val conn = toplevel.ownedConnections.findFirst[name == CONN] as PortConnection
		
		val subsystem = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == SUBSYSTEM_I] as ProcessImplementation
		val conn2 = subsystem.ownedConnections.findFirst[name == CONN2] as PortConnection
		
		// instantiate
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		assertEquals(2, instance.connectionInstances.size())
		{
			val ci0 = instance.connectionInstances.get(0)
			assertEquals(1, ci0.connectionReferences.size())
			val cr0 = ci0.connectionReferences.get(0)
			assertEquals(conn, cr0.connection)
			assertEquals(true, cr0.reverse)
		}		
		
		{
			val ci1 = instance.connectionInstances.get(1)
			assertEquals(false, ci1.bidirectional)
			assertEquals(2, ci1.connectionReferences.size())
			val cr0 = ci1.connectionReferences.get(0)
			val cr1 = ci1.connectionReferences.get(1)
			assertEquals(conn2, cr0.connection)
			assertEquals(false, cr0.reverse)
			assertEquals(conn, cr1.connection)
			assertEquals(false, cr1.reverse)
			assertEquals(cr1.source, cr0.destination)
		}
	}

	
	@Test
	def void UniDirToContainer_same() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE11)
		
		// Get the declarative connections
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val conn = toplevel.ownedConnections.findFirst[name == CONN] as PortConnection
		
		val subsystem = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == SUBSYSTEM_I] as ProcessImplementation
		val conn2 = subsystem.ownedConnections.findFirst[name == CONN2] as PortConnection
		
		// instantiate
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		assertEquals(1, instance.connectionInstances.size())
		val ci = instance.connectionInstances.get(0)
		assertEquals(false, ci.bidirectional)
		assertEquals(2, ci.connectionReferences.size())
		val cr0 = ci.connectionReferences.get(0)
		val cr1 = ci.connectionReferences.get(1)
		assertEquals(conn2, cr0.connection)
		assertEquals(false, cr0.reverse)
		assertEquals(conn, cr1.connection)
		assertEquals(false, cr1.reverse)
		assertEquals(cr1.source, cr0.destination)
	}
	
	@Test
	def void BiDirToContainer_OutToIn_same() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE12)
		
		// Get the declarative connections
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val conn = toplevel.ownedConnections.findFirst[name == CONN] as PortConnection
		
		val subsystem = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == SUBSYSTEM_I] as ProcessImplementation
		val conn2 = subsystem.ownedConnections.findFirst[name == CONN2] as PortConnection
		
		// instantiate
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		assertEquals(2, instance.connectionInstances.size())
		{
			val ci0 = instance.connectionInstances.get(0)
			assertEquals(1, ci0.connectionReferences.size())
			val cr0 = ci0.connectionReferences.get(0)
			assertEquals(conn, cr0.connection)
			assertEquals(false, cr0.reverse)
		}		
		
		{
			val ci1 = instance.connectionInstances.get(1)
			assertEquals(false, ci1.bidirectional)
			assertEquals(2, ci1.connectionReferences.size())
			val cr0 = ci1.connectionReferences.get(0)
			val cr1 = ci1.connectionReferences.get(1)
			assertEquals(conn2, cr0.connection)
			assertEquals(false, cr0.reverse)
			assertEquals(conn, cr1.connection)
			assertEquals(true, cr1.reverse)
			assertEquals(cr1.source, cr0.destination)
		}
	}
	
	@Test
	def void BiDirToContainer_InToOut_same() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE13)
		
		// Get the declarative connections
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val conn = toplevel.ownedConnections.findFirst[name == CONN] as PortConnection
		
		val subsystem = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == SUBSYSTEM_I] as ProcessImplementation
		val conn2 = subsystem.ownedConnections.findFirst[name == CONN2] as PortConnection
		
		// instantiate
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		assertEquals(2, instance.connectionInstances.size())
		{
			val ci0 = instance.connectionInstances.get(0)
			assertEquals(1, ci0.connectionReferences.size())
			val cr0 = ci0.connectionReferences.get(0)
			assertEquals(conn, cr0.connection)
			assertEquals(true, cr0.reverse)
		}		
		
		{
			val ci1 = instance.connectionInstances.get(1)
			assertEquals(false, ci1.bidirectional)
			assertEquals(2, ci1.connectionReferences.size())
			val cr0 = ci1.connectionReferences.get(0)
			val cr1 = ci1.connectionReferences.get(1)
			assertEquals(conn2, cr0.connection)
			assertEquals(false, cr0.reverse)
			assertEquals(conn, cr1.connection)
			assertEquals(false, cr1.reverse)
			assertEquals(cr1.source, cr0.destination)
		}
	}
	
	@Test
	def void UniDirPeerToPeer_same() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE14)
		
		// Get the declarative connections
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val conn = toplevel.ownedConnections.findFirst[name == CONN] as PortConnection
		
		val subsystem = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == SUBSYSTEM_I] as ProcessImplementation
		val conn2 = subsystem.ownedConnections.findFirst[name == CONN2] as PortConnection
		
		// instantiate
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		assertEquals(1, instance.connectionInstances.size())
		val ci = instance.connectionInstances.get(0)
		assertEquals(false, ci.bidirectional)
		assertEquals(2, ci.connectionReferences.size())
		val cr0 = ci.connectionReferences.get(0)
		val cr1 = ci.connectionReferences.get(1)
		assertEquals(conn2, cr0.connection)
		assertEquals(false, cr0.reverse)
		assertEquals(conn, cr1.connection)
		assertEquals(false, cr1.reverse)
		assertEquals(cr1.source, cr0.destination)
	}
	
	@Test
	def void BiDirPeerToPeer_LtoR_same() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE15)
		
		// Get the declarative connections
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val conn = toplevel.ownedConnections.findFirst[name == CONN] as PortConnection
		
		val subsystem = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == SUBSYSTEM_I] as ProcessImplementation
		val conn2 = subsystem.ownedConnections.findFirst[name == CONN2] as PortConnection
		
		// instantiate
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		assertEquals(2, instance.connectionInstances.size())
		{
			val ci0 = instance.connectionInstances.get(0)
			assertEquals(1, ci0.connectionReferences.size())
			val cr0 = ci0.connectionReferences.get(0)
			assertEquals(conn, cr0.connection)
			assertEquals(false, cr0.reverse)
		}		
		
		{
			val ci1 = instance.connectionInstances.get(1)
			assertEquals(false, ci1.bidirectional)
			assertEquals(2, ci1.connectionReferences.size())
			val cr0 = ci1.connectionReferences.get(0)
			val cr1 = ci1.connectionReferences.get(1)
			assertEquals(conn2, cr0.connection)
			assertEquals(false, cr0.reverse)
			assertEquals(conn, cr1.connection)
			assertEquals(true, cr1.reverse)
			assertEquals(cr1.source, cr0.destination)
		}
	}
	
	@Test
	def void BiDirPeerToPeer_RtoL_same() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE16)
		
		// Get the declarative connections
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val conn = toplevel.ownedConnections.findFirst[name == CONN] as PortConnection
		
		val subsystem = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == SUBSYSTEM_I] as ProcessImplementation
		val conn2 = subsystem.ownedConnections.findFirst[name == CONN2] as PortConnection
		
		// instantiate
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		assertEquals(2, instance.connectionInstances.size())
		{
			val ci0 = instance.connectionInstances.get(0)
			assertEquals(1, ci0.connectionReferences.size())
			val cr0 = ci0.connectionReferences.get(0)
			assertEquals(conn, cr0.connection)
			assertEquals(true, cr0.reverse)
		}		
		
		{
			val ci1 = instance.connectionInstances.get(1)
			assertEquals(false, ci1.bidirectional)
			assertEquals(2, ci1.connectionReferences.size())
			val cr0 = ci1.connectionReferences.get(0)
			val cr1 = ci1.connectionReferences.get(1)
			assertEquals(conn2, cr0.connection)
			assertEquals(false, cr0.reverse)
			assertEquals(conn, cr1.connection)
			assertEquals(false, cr1.reverse)
			assertEquals(cr1.source, cr0.destination)
		}
	}

	
	@Test
	def void findFeature() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FIND_FEATURE)
		
		// Get the declarative features
		val original = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == ORIGINAL] as SystemType
		val f_original = original.ownedFeatures.get(0)
		
		val refined = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == REFINED] as SystemType
		val f_refined = refined.ownedFeatures.get(0)
		
		val unrelated = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == UNRELATED] as SystemType
		val f_unrelated = unrelated.ownedFeatures.get(0)
		
		// instantiate
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		val original_ci = instance.componentInstances.get(0)
		val f_original_ci = original_ci.featureInstances.get(0)
		
		val refined_ci = instance.componentInstances.get(1)
		val f_refined_ci = refined_ci.featureInstances.get(0)
		
		val unrelated_ci = instance.componentInstances.get(2)
		val f_unrelated_ci = unrelated_ci.featureInstances.get(0)

		assertEquals(f_original_ci, original_ci.findFeatureInstance(f_original))
		assertEquals(f_original_ci, original_ci.findFeatureInstance(f_refined))
		assertEquals(null, original_ci.findFeatureInstance(f_unrelated))  

		assertEquals(f_refined_ci, refined_ci.findFeatureInstance(f_original))
		assertEquals(f_refined_ci, refined_ci.findFeatureInstance(f_refined))
		assertEquals(null, refined_ci.findFeatureInstance(f_unrelated))

		assertEquals(null, unrelated_ci.findFeatureInstance(f_original))
		assertEquals(null, unrelated_ci.findFeatureInstance(f_refined))
		assertEquals(f_unrelated_ci, unrelated_ci.findFeatureInstance(f_unrelated))
	}

	
	@Test
	def void findSubcomponent() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FIND_SUBCOMPONENT)
		
		// Get the declarative features
		val original = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == XORIGINAL] as SystemImplementation
		val s_original = original.ownedSubcomponents.get(0)
		
		val refined = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == XREFINED] as SystemImplementation
		val s_refined = refined.ownedSubcomponents.get(0)
		
		val unrelated = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == XUNRELATED] as SystemImplementation
		val s_unrelated = unrelated.ownedSubcomponents.get(0)
		
		// instantiate
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		val original_ci = instance.componentInstances.get(0)
		val s_original_ci = original_ci.componentInstances.get(0)
		
		val refined_ci = instance.componentInstances.get(1)
		val s_refined_ci = refined_ci.componentInstances.get(0)
		
		val unrelated_ci = instance.componentInstances.get(2)
		val s_unrelated_ci = unrelated_ci.componentInstances.get(0)

		assertEquals(s_original_ci, original_ci.findSubcomponentInstance(s_original))
		assertEquals(s_original_ci, original_ci.findSubcomponentInstance(s_refined))
		assertEquals(null, original_ci.findSubcomponentInstance(s_unrelated))

		assertEquals(s_refined_ci, refined_ci.findSubcomponentInstance(s_original))
		assertEquals(s_refined_ci, refined_ci.findSubcomponentInstance(s_refined))
		assertEquals(null, refined_ci.findSubcomponentInstance(s_unrelated)) 

		assertEquals(null, unrelated_ci.findSubcomponentInstance(s_original))
		assertEquals(null, unrelated_ci.findSubcomponentInstance(s_refined))
		assertEquals(s_unrelated_ci, unrelated_ci.findSubcomponentInstance(s_unrelated))
	}
	
	@Test
	def void findFlowSpec() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FIND_FLOW_SPEC)
		
		// Get the declarative features
		val original = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == ORIGINAL] as SystemType
		val fs_original = original.ownedFlowSpecifications.get(0)
		
		val refined = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == REFINED] as SystemType
		val fs_refined = refined.ownedFlowSpecifications.get(0)
		
		val unrelated = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == UNRELATED] as SystemType
		val fs_unrelated = unrelated.ownedFlowSpecifications.get(0)
		
		// instantiate
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		val original_ci = instance.componentInstances.get(0)
		val fs_original_ci = original_ci.flowSpecifications.get(0)
		
		val refined_ci = instance.componentInstances.get(1)
		val fs_refined_ci = refined_ci.flowSpecifications.get(0)
		
		val unrelated_ci = instance.componentInstances.get(2)
		val fs_unrelated_ci = unrelated_ci.flowSpecifications.get(0)

		assertEquals(fs_original_ci, original_ci.findFlowSpecInstance(fs_original))
		assertEquals(fs_original_ci, original_ci.findFlowSpecInstance(fs_refined))
		assertEquals(null, original_ci.findFlowSpecInstance(fs_unrelated))  // should be null, but due to bug is not

		assertEquals(fs_refined_ci, refined_ci.findFlowSpecInstance(fs_original))
		assertEquals(fs_refined_ci, refined_ci.findFlowSpecInstance(fs_refined))
		assertEquals(null, refined_ci.findFlowSpecInstance(fs_unrelated)) // should be null, but due to bug is not

		assertEquals(null, unrelated_ci.findFlowSpecInstance(fs_original))// should be null, but due to bug is not
		assertEquals(null, unrelated_ci.findFlowSpecInstance(fs_refined))// should be null, but due to bug is not
		assertEquals(fs_unrelated_ci, unrelated_ci.findFlowSpecInstance(fs_unrelated))
	}
	
	@Test
	def void findEndToEndFlow() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FIND_END_TO_END_FLOW)
		
		// Get the declarative features
		val original = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == XORIGINAL] as SystemImplementation
		val e2e_original = original.ownedEndToEndFlows.get(0)
		
		val refined = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == XREFINED] as SystemImplementation
		val e2e_refined = refined.ownedEndToEndFlows.get(0)
		
		val unrelated = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == XUNRELATED] as SystemImplementation
		val e2e_unrelated = unrelated.ownedEndToEndFlows.get(0)
		
		// instantiate
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		val original_ci = instance.componentInstances.get(0)
		val e2e_original_ci = original_ci.endToEndFlows.get(0)
		
		val refined_ci = instance.componentInstances.get(1)
		val e2e_refined_ci = refined_ci.endToEndFlows.get(0)
		
		val unrelated_ci = instance.componentInstances.get(2)
		val e2e_unrelated_ci = unrelated_ci.endToEndFlows.get(0)

		assertEquals(e2e_original_ci, original_ci.findEndToEndFlowInstance(e2e_original))
		assertEquals(e2e_original_ci, original_ci.findEndToEndFlowInstance(e2e_refined))
		assertEquals(null, original_ci.findEndToEndFlowInstance(e2e_unrelated))  // should be null, but due to bug is not

		assertEquals(e2e_refined_ci, refined_ci.findEndToEndFlowInstance(e2e_original))
		assertEquals(e2e_refined_ci, refined_ci.findEndToEndFlowInstance(e2e_refined))
		assertEquals(null, refined_ci.findEndToEndFlowInstance(e2e_unrelated)) // should be null, but due to bug is not

		assertEquals(null, unrelated_ci.findEndToEndFlowInstance(e2e_original))// should be null, but due to bug is not
		assertEquals(null, unrelated_ci.findEndToEndFlowInstance(e2e_refined))// should be null, but due to bug is not
		assertEquals(e2e_unrelated_ci, unrelated_ci.findEndToEndFlowInstance(e2e_unrelated))
	}

	
	@Test
	def void findConnection() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FIND_CONNECTION)
		
		// Get the declarative connections
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val co = toplevel.ownedConnections.get(0)
		val cr = toplevel.ownedConnections.get(1)
		val cu = toplevel.ownedConnections.get(2)
		
		val original = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == XORIGINAL] as SystemImplementation
		val conn_original = original.ownedConnections.get(0)
		
		val refined = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == XREFINED] as SystemImplementation
		val conn_refined = refined.ownedConnections.get(0)
		
		val unrelated = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == XUNRELATED] as SystemImplementation
		val conn_unrelated = unrelated.ownedConnections.get(0)
		
		val subsystem = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == SUBSYSTEM_I] as ProcessImplementation
		val conn2 = subsystem.ownedConnections.get(0)
		
		// instantiate
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)

		val original_ci = instance.componentInstances.get(0)
		val refined_ci = instance.componentInstances.get(1)
		val unrelated_ci = instance.componentInstances.get(2)

		val ci_original_ci = instance.connectionInstances.get(0)
		val ci_refined_ci = instance.connectionInstances.get(1)
		val ci_unrelated_ci = instance.connectionInstances.get(2)

		// Check that the connection instances are built correctly
		testConnectionReferences(ci_original_ci, conn2, conn_original, co)
		testConnectionReferences(ci_refined_ci, conn2, conn_refined, cr)
		testConnectionReferences(ci_unrelated_ci, conn2, conn_unrelated, cu)

		checkFound(original_ci, conn_original, ci_original_ci);
		checkFound(original_ci, conn_refined, ci_original_ci);
		checkNotFound(original_ci, conn_unrelated)

		checkFound(refined_ci, conn_original, ci_refined_ci);
		checkFound(refined_ci, conn_refined, ci_refined_ci);
		checkNotFound(refined_ci, conn_unrelated)
		
		checkNotFound(unrelated_ci, conn_original)
		checkNotFound(unrelated_ci, conn_refined)
		checkFound(unrelated_ci, conn_unrelated, ci_unrelated_ci)
	}
	
	def void testConnectionReferences(ConnectionInstance ci, Connection... connections) {
		val connRefs = ci.connectionReferences
		assertEquals(connections.size, connRefs.size)
		for (var i = 0; i < connections.size; i++) {
			assertEquals(connections.get(i), connRefs.get(i).connection)
		}
	}
	
	def void checkFound(ComponentInstance compInstance, Connection connection, ConnectionInstance expected) {
		val found = compInstance.findConnectionInstance(connection)
		assertEquals(1, found.size)
		assertEquals(expected, found.get(0))
	} 
	
	def void checkNotFound(ComponentInstance compInstance, Connection connection) {
		val found = compInstance.findConnectionInstance(connection)
		assertEquals(0, found.size)
	}
	
	@Test
	def void BiDirPortSimple_samenames() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + BI_DIR_PORT_SIMPLE_SAMENAMES)
		
		// Get the declarative connections
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val conn = toplevel.ownedConnections.get(0)
		
		val subsystem_i = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == SUBSYSTEM_I] as ProcessImplementation
		val conn2 = subsystem_i.ownedConnections.get(0)
		
		// instantiate
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)


		// Check that the connection instances are built correctly
		testConnectionReferences(instance.connectionInstances.get(0), conn, conn2)
		testConnectionReferences(instance.connectionInstances.get(1), conn2, conn)		
	}
	
	@Test
	def void BiDirPortSimple_uniquenames() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + BI_DIR_PORT_SIMPLE_UNIQUENAMES)
		
		// Get the declarative connections
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val conn = toplevel.ownedConnections.get(0)
		
		val subsystem_i = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == SUBSYSTEM_I] as ProcessImplementation
		val conn2 = subsystem_i.ownedConnections.get(0)
		
		// instantiate
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)


		// Check that the connection instances are built correctly
		testConnectionReferences(instance.connectionInstances.get(0), conn, conn2)
		testConnectionReferences(instance.connectionInstances.get(1), conn2, conn)		
	}
	
	@Test
	def void featureGroupTest() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FEATURE_GROUP_TEST)
		
		// Get the declarative connections
		val toplevel = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOPLEVEL_I] as SystemImplementation
		val conn = toplevel.ownedConnections.get(0)
		
		val subsystem_i = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == SUBSYSTEM_I] as ProcessImplementation
		val conn2 = subsystem_i.ownedConnections.get(0)
		
		// instantiate
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(toplevel, errorManager)


		// Check that the connection instances are built correctly
		testConnectionReferences(instance.connectionInstances.get(0), conn, conn2)
		testConnectionReferences(instance.connectionInstances.get(1), conn2, conn)		
	}
	
}
