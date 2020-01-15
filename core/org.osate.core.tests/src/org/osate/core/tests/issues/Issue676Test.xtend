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
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*
import org.osate.aadl2.Connection
import org.osate.aadl2.instance.ConnectionInstance

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue676Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue676/"
	val static ISSUE643 = "issue643.aadl"
	val static ISSUE676 = "issue676.aadl"

	val static TOP_I = "top.i"
	val static INSTANCE_NAME1 = "top_i_Instance"
	val static E2E = "e2e"
	
	val static S_I = "s.i"
	val static INSTANCE_NAME2 = "s_i_Instance"
	val static CONN1 = "conn1"
	val static CONN2 = "conn2"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue643() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + ISSUE643)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOP_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME1, instance.name)

		/* The original problem was that the end to end flow was not being instantiated.  So if we 
		 * find the flow in the instance model, things are good.
		 */
		val endToEndFlows = sysImpl.allEndToEndFlows
		assertEquals(1, endToEndFlows.size)
		assertEquals(E2E, endToEndFlows.get(0).name)
	}
	
	@Test
	def void testIssue676() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + ISSUE676)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == S_I] as SystemImplementation
		val conn1 = sysImpl.ownedConnections.findFirst[name == CONN1] as Connection
		val conn2 = sysImpl.ownedConnections.findFirst[name == CONN2] as Connection
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME2, instance.name)

		/* The original problem was that the two connection instances (one in each direction) were being merged into 
		 * a single bidirectional connection instance.  So we should have 2 connection instances.
		 */
		val connections = instance.connectionInstances
		assertEquals(2, connections.size) 
		
		testConnectionInstance(connections.get(0), conn2)
		testConnectionInstance(connections.get(1), conn1)
	}
	
	private def void testConnectionInstance(ConnectionInstance ci, Connection c) {
		assertEquals(false, ci.isBidirectional)
		val refs = ci.connectionReferences
		assertEquals(1, refs.size)
		assertEquals(c, refs.get(0).connection)
	}
}
