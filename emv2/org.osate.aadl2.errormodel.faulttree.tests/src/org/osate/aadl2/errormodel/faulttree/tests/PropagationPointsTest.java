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
package org.osate.aadl2.errormodel.faulttree.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.errormodel.FaultTree.LogicOperation;
import org.osate.aadl2.errormodel.FaultTree.util.FaultTreeUtils;
import org.osate.aadl2.errormodel.faulttree.generation.CreateFTAModel;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
/**
 * Verifies fault-tree, fault-trace, parts-tree, and cut-set analysis when EMV2 propagation points are used directly or
 * through features.
 */
public class PropagationPointsTest {
	private static final String PROPAGATION_START = "outgoing propagation on observation{ServiceOmission}";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	private static SystemInstance instance;
	private static SystemInstance instance2;
	private AadlPackage primaryRoot;

	@Before
	public void initWorkspace() throws Exception {
		var aadlFile = "propagationpointstest.aadl";
		var featureAadlFile = "propagationpointfeaturetest.aadl";
		var modelRoot = "org.osate.aadl2.errormodel.faulttree.tests/models/PropagationPoints/";
		primaryRoot = (AadlPackage) testHelper.parseFile(modelRoot + aadlFile, modelRoot + featureAadlFile);
		instance = instantiate(modelRoot + aadlFile, "main.commonsource");
		instance2 = instantiate(modelRoot + featureAadlFile, "main.commonsource");
	}

	private SystemInstance instantiate(final String filename, final String rootClassifier) throws Exception {
		var aadlPackage = (AadlPackage) primaryRoot.eResource().getResourceSet()
				.getResource(URI.createURI(filename), true).getContents().getFirst();
		var classifier = aadlPackage.getOwnedPublicSection().getOwnedClassifiers().stream()
				.filter(candidate -> rootClassifier.equals(candidate.getName())).findFirst();
		assertTrue(classifier.isPresent());
		return InstantiateModel.instantiate((ComponentImplementation) classifier.orElseThrow());
	}

	@Test
	public void propagationpointsfaulttree() {
		var faultTree = CreateFTAModel.createFaultTree(instance, PROPAGATION_START);
		assertEquals(6, faultTree.getEvents().size());
		assertEquals(LogicOperation.AND, faultTree.getRoot().getSubEvents().get(1).getSubEventLogic());
		assertEquals(7.1e-8, faultTree.getRoot().getComputedProbability().doubleValue(), 0.1e-8);
	}

	@Test
	public void propagationpointsfaulttrace() {
		var faultTrace = CreateFTAModel.createFaultTrace(instance, PROPAGATION_START);
		assertEquals(15, faultTrace.getEvents().size());
	}

	@Test
	public void propagationpointspartsfaulttree() {
		var faultTree = CreateFTAModel.createPartsFaultTree(instance, "state FailStop");
		assertEquals(7, faultTree.getEvents().size());
		assertEquals(LogicOperation.AND, FaultTreeUtils.findEvent(faultTree, "Intermediate1").getSubEventLogic());
	}

	@Test
	public void propagationpointscutsetsstate() {
		assertCutSets(CreateFTAModel.createMinimalCutSet(instance, "state FailStop"), "Cutset3", "Cutset1", "Cutset2");
	}

	@Test
	public void propagationpointscutsetsoutprop() {
		assertCutSets(CreateFTAModel.createMinimalCutSet(instance, PROPAGATION_START), "Cutset1", "Cutset2", "Cutset3");
	}

	@Test
	public void propagationpointfeaturefaulttree() {
		var faultTree = CreateFTAModel.createFaultTree(instance2, PROPAGATION_START);
		assertEquals(6, faultTree.getEvents().size());
		assertEquals(LogicOperation.AND, faultTree.getRoot().getSubEvents().get(1).getSubEventLogic());
		assertEquals(7.1e-8, faultTree.getRoot().getComputedProbability().doubleValue(), 0.1e-8);
	}

	@Test
	public void propagationpointfeaturefaulttrace() {
		var faultTrace = CreateFTAModel.createFaultTrace(instance2, PROPAGATION_START);
		assertEquals(15, faultTrace.getEvents().size());
	}

	@Test
	public void propagationpointfeaturecutsets() {
		assertCutSets(CreateFTAModel.createMinimalCutSet(instance2, PROPAGATION_START), "Cutset1", "Cutset2",
				"Cutset3");
	}

	private static void assertCutSets(final org.osate.aadl2.errormodel.FaultTree.FaultTree cutSets,
			final String firstName, final String secondName, final String thirdName) {
		assertEquals(8, cutSets.getEvents().size());
		assertEquals(3, cutSets.getRoot().getSubEvents().size());
		assertEquals(6.5e-10, FaultTreeUtils.findEvent(cutSets, firstName).getComputedProbability().doubleValue(),
				0.1e-10);
		assertEquals(4.9e-15, FaultTreeUtils.findEvent(cutSets, secondName).getComputedProbability().doubleValue(),
				0.1e-15);
		assertEquals(7.0e-8, FaultTreeUtils.findEvent(cutSets, thirdName).getComputedProbability().doubleValue(),
				0.1e-8);
	}
}
