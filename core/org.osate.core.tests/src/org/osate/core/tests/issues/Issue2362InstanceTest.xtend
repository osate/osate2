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
import java.util.List
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter.Message
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.assertEquals

import static extension org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2362InstanceTest {
	val static FILE_LOCATION = "org.osate.core.tests/models/Issue2362/DeclarativeTests.aadl"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void test_Sub_to_provides() {
		testOutgoing("Sub_to_provides.comp_outgoing", "", "p")
		testIncoming("Sub_to_provides.comp_incoming", "", "p")
		testBidirectional("Sub_to_provides.comp_bidir", "", "p")
		testBidirectional("Sub_to_provides.comp_bidir2", "", "p")
	}
	
	@Test
	def void test_Sub_FG_to_provides() {
		testOutgoing("Sub_FG_to_provides.comp_outgoing", "", "fg.p")
		testIncoming("Sub_FG_to_provides.comp_incoming", "", "fg.p")
		testBidirectional("Sub_FG_to_provides.comp_bidir", "", "fg.p")
		testBidirectional("Sub_FG_to_provides.comp_bidir2", "", "fg.p")
	}
	
	@Test
	def void test_Sub_FG_inverse_to_provides() {
		testOutgoing("Sub_FG_inverse_to_provides.comp_outgoing", "", "fg.p")
		testIncoming("Sub_FG_inverse_to_provides.comp_incoming", "", "fg.p")
		testBidirectional("Sub_FG_inverse_to_provides.comp_bidir", "", "fg.p")
		testBidirectional("Sub_FG_inverse_to_provides.comp_bidir2", "", "fg.p")
	}
	
	@Test
	def void test_Sub_FG_inverse_to_provides2() {
		testOutgoing("Sub_FG_inverse_to_provides2.comp_outgoing", "", "fg.p")
		testIncoming("Sub_FG_inverse_to_provides2.comp_incoming", "", "fg.p")
		testBidirectional("Sub_FG_inverse_to_provides2.comp_bidir", "", "fg.p")
		testBidirectional("Sub_FG_inverse_to_provides2.comp_bidir2", "", "fg.p")
	}
	
	@Test
	def void test_Sub_FG_inverse_to_provides3() {
		testOutgoing("Sub_FG_inverse_to_provides3.comp_outgoing", "", "fg.p")
		testIncoming("Sub_FG_inverse_to_provides3.comp_incoming", "", "fg.p")
		testBidirectional("Sub_FG_inverse_to_provides3.comp_bidir", "", "fg.p")
		testBidirectional("Sub_FG_inverse_to_provides3.comp_bidir2", "", "fg.p")
	}
	
	@Test
	def void test_Sub_to_peer_requires() {
		testOutgoing("Sub_to_peer_requires.toPeer", "", "peer.r")
		testIncoming("Sub_to_peer_requires.fromPeer", "", "peer.r")
		testBidirectional("Sub_to_peer_requires.bidir", "", "peer.r")
		testBidirectional("Sub_to_peer_requires.bidir2", "", "peer.r")
	}
	
	@Test
	def void test_Sub_provides_to_provides() {
		testOutgoing("Sub_to_provides.sub_outgoing", "sub.p_", "p")
		testIncoming("Sub_to_provides.sub_incoming", "sub.p_", "p")
		testBidirectional("Sub_to_provides.sub_bidir", "sub.p_", "p")
		testBidirectional("Sub_to_provides.sub_bidir2", "sub.p_", "p")
	}
	
	@Test
	def void test_Sub_FG_provides_to_provides() {
		testOutgoing("Sub_FG_to_provides.sub_outgoing", "sub.p_", "fg.p")
		testIncoming("Sub_FG_to_provides.sub_incoming", "sub.p_", "fg.p")
		testBidirectional("Sub_FG_to_provides.sub_bidir", "sub.p_", "fg.p")
		testBidirectional("Sub_FG_to_provides.sub_bidir2", "sub.p_", "fg.p")
	}
	
	@Test
	def void test_Sub_FG_inverse_provides_to_provides() {
		testOutgoing("Sub_FG_inverse_to_provides.sub_outgoing", "sub.p_", "fg.p")
		testIncoming("Sub_FG_inverse_to_provides.sub_incoming", "sub.p_", "fg.p")
		testBidirectional("Sub_FG_inverse_to_provides.sub_bidir", "sub.p_", "fg.p")
		testBidirectional("Sub_FG_inverse_to_provides.sub_bidir2", "sub.p_", "fg.p")
	}
	
	@Test
	def void test_Sub_FG_inverse_provides_to_provides2() {
		testOutgoing("Sub_FG_inverse_to_provides2.sub_outgoing", "sub.p_", "fg.p")
		testIncoming("Sub_FG_inverse_to_provides2.sub_incoming", "sub.p_", "fg.p")
		testBidirectional("Sub_FG_inverse_to_provides2.sub_bidir", "sub.p_", "fg.p")
		testBidirectional("Sub_FG_inverse_to_provides2.sub_bidir2", "sub.p_", "fg.p")
	}
	
	@Test
	def void test_Sub_FG_inverse_provides_to_provides3() {
		testOutgoing("Sub_FG_inverse_to_provides3.sub_outgoing", "sub.p_", "fg.p")
		testIncoming("Sub_FG_inverse_to_provides3.sub_incoming", "sub.p_", "fg.p")
		testBidirectional("Sub_FG_inverse_to_provides3.sub_bidir", "sub.p_", "fg.p")
		testBidirectional("Sub_FG_inverse_to_provides3.sub_bidir2", "sub.p_", "fg.p")
	}

	@Test
	def void test_Peer_to_peer() {
		testOutgoing("Peer_to_peer.toPeer", "provider.p_", "requirer.r")
		testIncoming("Peer_to_peer.fromPeer", "provider.p_", "requirer.r")
		testBidirectional("Peer_to_peer.bidir", "provider.p_", "requirer.r")
		testBidirectional("Peer_to_peer.bidir2", "provider.p_", "requirer.r")
	}

	@Test
	def void test_To_sub_requires() {
		testOutgoing("To_sub_requires.incoming", "r_d_", "sub.r")
		testIncoming("To_sub_requires.outgoing", "r_d_", "sub.r")
		testBidirectional("To_sub_requires.bidir", "r_d_", "sub.r")
		testBidirectional("To_sub_requires.bidir2", "r_d_", "sub.r")
	}

	@Test
	def void test_FG_To_sub_requires() {
		testOutgoing("FG_To_sub_requires.incoming", "fg.r_d_", "sub.r")
		testIncoming("FG_To_sub_requires.outgoing", "fg.r_d_", "sub.r")
		testBidirectional("FG_To_sub_requires.bidir", "fg.r_d_", "sub.r")
		testBidirectional("FG_To_sub_requires.bidir2", "fg.r_d_", "sub.r")
	}

	@Test
	def void test_FG_inverse_To_sub_requires() {
		testOutgoing("FG_inverse_To_sub_requires.incoming", "fg.r_d_", "sub.r")
		testIncoming("FG_inverse_To_sub_requires.outgoing", "fg.r_d_", "sub.r")
		testBidirectional("FG_inverse_To_sub_requires.bidir", "fg.r_d_", "sub.r")
		testBidirectional("FG_inverse_To_sub_requires.bidir2", "fg.r_d_", "sub.r")
	}

	@Test
	def void test_FG_inverse_To_sub_requires2() {
		testOutgoing("FG_inverse_To_sub_requires2.incoming", "fg.r_d_", "sub.r")
		testIncoming("FG_inverse_To_sub_requires2.outgoing", "fg.r_d_", "sub.r")
		testBidirectional("FG_inverse_To_sub_requires2.bidir", "fg.r_d_", "sub.r")
		testBidirectional("FG_inverse_To_sub_requires2.bidir2", "fg.r_d_", "sub.r")
	}

	@Test
	def void test_FG_inverse_To_sub_requires3() {
		testOutgoing("FG_inverse_To_sub_requires3.incoming", "fg.r_d_", "sub.r")
		testIncoming("FG_inverse_To_sub_requires3.outgoing", "fg.r_d_", "sub.r")
		testBidirectional("FG_inverse_To_sub_requires3.bidir", "fg.r_d_", "sub.r")
		testBidirectional("FG_inverse_To_sub_requires3.bidir2", "fg.r_d_", "sub.r")
	}
	
	private def void testIncoming(String systemName, String prefix1, String prefix2) {
		val pkg = testHelper.parseFile(FILE_LOCATION)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == systemName] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 6)
		
		incomingErrors(messages, prefix1, prefix2)
	}
	
	private def void testOutgoing(String systemName, String prefix1, String prefix2) {
		val pkg = testHelper.parseFile(FILE_LOCATION)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == systemName] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 6)
		
		outgoingErrors(messages, prefix1, prefix2)
	}
	
	private def void testBidirectional(String systemName, String prefix1, String prefix2) {
		val pkg = testHelper.parseFile(FILE_LOCATION)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == systemName] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 12)
		
		outgoingErrors(messages, prefix1, prefix2)
		incomingErrors(messages, prefix1, prefix2)
	}
	
	protected def void outgoingErrors(List<Message> messages, String prefix1, String prefix2) {
		hasError(messages, prefix1 + "dd -> " + prefix2 + "_d_dd", "'" + prefix1 + "dd' and '" + prefix2 + "_d_dd' have incompatible classifiers.")
		hasError(messages, prefix1 + "e -> " + prefix2 + "_d_e", "'" + prefix1 + "e' and '" + prefix2 + "_d_e' have incompatible classifiers.")
		
		hasError(messages, prefix1 + "d -> " + prefix2 + "_e_d", "'" + prefix1 + "d' and '" + prefix2 + "_e_d' have incompatible classifiers.")
		hasError(messages, prefix1 + "dd -> " + prefix2 + "_e_dd",  "'" + prefix1 + "dd' and '" + prefix2 + "_e_dd' have incompatible classifiers.")
		hasError(messages, prefix1 + "di -> " + prefix2 + "_e_di", "The types of '" + prefix1 + "di' and '" + prefix2 + "_e_di' do not match.")
		hasError(messages, prefix1 + "dj -> " + prefix2 + "_e_dj", "The types of '" + prefix1 + "dj' and '" + prefix2 + "_e_dj' do not match.")
	}
	
	protected def void incomingErrors(List<Message> messages, String prefix1, String prefix2) {
		hasError(messages, prefix2 + "_d_dd -> " + prefix1 + "dd", "'" + prefix1 + "dd' and '" + prefix2 + "_d_dd' have incompatible classifiers.")
		hasError(messages, prefix2 + "_d_e -> " + prefix1 + "e", "'" + prefix1 + "e' and '" + prefix2 + "_d_e' have incompatible classifiers.")
		
		hasError(messages, prefix2 + "_e_d -> " + prefix1 + "d", "'" + prefix1 + "d' and '" + prefix2 + "_e_d' have incompatible classifiers.")
		hasError(messages, prefix2 + "_e_dd -> " + prefix1 + "dd",  "'" + prefix1 + "dd' and '" + prefix2 + "_e_dd' have incompatible classifiers.")
		hasError(messages, prefix2 + "_e_di -> " + prefix1 + "di", "The types of '" + prefix1 + "di' and '" + prefix2 + "_e_di' do not match.")
		hasError(messages, prefix2 + "_e_dj -> " + prefix1 + "dj", "The types of '" + prefix1 + "dj' and '" + prefix2 + "_e_dj' do not match.")
	}

	private static def void hasError(List<Message> messages, String connectionName, String errorMsg) {
		messages.findFirst[(where as ConnectionInstance).name == connectionName] => [
			assertEquals(kind, QueuingAnalysisErrorReporter.ERROR)
			assertEquals(message, errorMsg)
		]
	}
}
