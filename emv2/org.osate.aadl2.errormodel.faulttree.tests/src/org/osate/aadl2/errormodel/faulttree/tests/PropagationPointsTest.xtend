/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.aadl2.errormodel.faulttree.tests

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.errormodel.FaultTree.LogicOperation
import org.osate.aadl2.errormodel.FaultTree.util.FaultTreeUtils
import org.osate.aadl2.errormodel.faulttree.generation.CreateFTAModel
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class PropagationPointsTest  {

	@Inject
	TestHelper<AadlPackage> testHelper

	var static SystemInstance instance
	var static SystemInstance instance2
	var primaryroot = null

	@Before
	/**
	 * All tests use the same model
	 */
	def void initWorkspace() {
		val aadlFile = "propagationpointstest.aadl"
		val aadlFile2 = "propagationpointfeaturetest.aadl"
		val modelroot = "org.osate.aadl2.errormodel.faulttree.tests/models/PropagationPoints/"

		primaryroot = testHelper.parseFile(modelroot + aadlFile,modelroot + aadlFile2)

			instance = instanceGenerator(modelroot + aadlFile,'main.commonsource')
			instance2 = instanceGenerator(modelroot + aadlFile2,'main.commonsource')
	}


	def SystemInstance instanceGenerator(String filename, String rootclassifier) {
		val ac = primaryroot as AadlPackage
		val rs = ac.eResource.resourceSet
		val targetsrc = rs.getResource(URI.createURI(filename), true)

		// get the correct package
		val pkg = targetsrc.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('', cls.exists[name == rootclassifier])
		// instantiate
		val sysImpl = cls.findFirst[name == rootclassifier] as ComponentImplementation
		return InstantiateModel::instantiate(sysImpl)
	}


	/**
	 * example with 2 sensors, compute, and one actuator.
	 * we run fault tree, fault trace, cutset, and parts fault tree
	 */
	@Test
	def void propagationpointsfaulttree() {
		val start = "outgoing propagation on observation{ServiceOmission}"
		val ft = CreateFTAModel.createFaultTree(instance, start)
		assertEquals(ft.events.size, 6)
		val andevent = ft.root.subEvents.get(1) 
		assertEquals(andevent.subEventLogic, LogicOperation.AND)
		val actual = ft.root.computedProbability
		assertEquals(7.1e-8, actual.doubleValue, 0.1e-8)
	}

	@Test
	def void propagationpointsfaulttrace() {
		val start = "outgoing propagation on observation{ServiceOmission}"
		val ftrace = CreateFTAModel.createFaultTrace(instance, start)
		assertEquals(ftrace.events.size, 15)
	}

	@Test
	def void propagationpointspartsfaulttree() {
		val start = "state FailStop"
		val ft = CreateFTAModel.createPartsFaultTree(instance, start)
		assertEquals(ft.events.size, 7)
		val andevent = FaultTreeUtils.findEvent(ft, "Intermediate1")
		assertEquals(andevent.subEventLogic, LogicOperation.AND)
	}

	@Test
	def void propagationpointscutsetsstate() {
		val start = "state FailStop"
		val cutsets = CreateFTAModel.createMinimalCutSet(instance, start)
		assertEquals(cutsets.events.size, 8)
		// three cutsets
		assertEquals(cutsets.root.subEvents.size, 3)
		val cutset1 = FaultTreeUtils.findEvent(cutsets, "Cutset3")
		assertEquals(6.5e-10, cutset1.computedProbability.doubleValue, 0.1e-10)
		val cutset2 = FaultTreeUtils.findEvent(cutsets, "Cutset1")
		assertEquals(4.9e-15, cutset2.computedProbability.doubleValue, 0.1e-15)
		val cutset3 = FaultTreeUtils.findEvent(cutsets, "Cutset2")
		assertEquals(7.0e-8, cutset3.computedProbability.doubleValue, 0.1e-8)
	}

	@Test
	def void propagationpointscutsetsoutprop() {
		val start = "outgoing propagation on observation{ServiceOmission}"
		val cutsets = CreateFTAModel.createMinimalCutSet(instance, start)
		assertEquals(cutsets.events.size, 8)
		// three cutsets
		assertEquals(cutsets.root.subEvents.size, 3)
		val cutset1 = FaultTreeUtils.findEvent(cutsets, "Cutset1")
		assertEquals(6.5e-10, cutset1.computedProbability.doubleValue, 0.1e-10)
		val cutset2 = FaultTreeUtils.findEvent(cutsets, "Cutset2")
		assertEquals(4.9e-15, cutset2.computedProbability.doubleValue, 0.1e-15)
		val cutset3 = FaultTreeUtils.findEvent(cutsets, "Cutset3")
		assertEquals(7.0e-8, cutset3.computedProbability.doubleValue, 0.1e-8)
	}

	@Test
	def void propagationpointfeaturefaulttree() {
		val start = "outgoing propagation on observation{ServiceOmission}"
		val ft = CreateFTAModel.createFaultTree(instance2, start)
		assertEquals(ft.events.size, 6)
		val andevent = ft.root.subEvents.get(1) 
		assertEquals(andevent.subEventLogic, LogicOperation.AND)
		val actual = ft.root.computedProbability
		assertEquals(7.1e-8, actual.doubleValue, 0.1e-8)
	}

	@Test
	def void propagationpointfeaturefaulttrace() {
		val start = "outgoing propagation on observation{ServiceOmission}"
		val ftrace = CreateFTAModel.createFaultTrace(instance2, start)
		assertEquals(ftrace.events.size, 15)
	}

	@Test
	def void propagationpointfeaturecutsets() {
		val start = "outgoing propagation on observation{ServiceOmission}"
		val cutsets = CreateFTAModel.createMinimalCutSet(instance2, start)
		assertEquals(cutsets.events.size, 8)
		// three cutsets
		assertEquals(cutsets.root.subEvents.size, 3)
		val cutset1 = FaultTreeUtils.findEvent(cutsets, "Cutset1")
		assertEquals(6.5e-10, cutset1.computedProbability.doubleValue, 0.1e-10)
		val cutset2 = FaultTreeUtils.findEvent(cutsets, "Cutset2")
		assertEquals(4.9e-15, cutset2.computedProbability.doubleValue, 0.1e-15)
		val cutset3 = FaultTreeUtils.findEvent(cutsets, "Cutset3")
		assertEquals(7.0e-8, cutset3.computedProbability.doubleValue, 0.1e-8)
	}

}
