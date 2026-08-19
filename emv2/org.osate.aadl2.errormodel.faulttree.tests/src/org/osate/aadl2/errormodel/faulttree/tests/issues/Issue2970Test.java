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
 * aries to this license with respect to the terms applicable to the Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.errormodel.faulttree.tests.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.errormodel.FaultTree.LogicOperation;
import org.osate.aadl2.errormodel.faulttree.generation.CreateFTAModel;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class Issue2970Test {
	private static final String MODEL_PATH = "org.osate.aadl2.errormodel.faulttree.tests/models/issue2970/Issue2970.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	private SystemInstance instance;

	@Before
	public void parseAndInstantiateModel() throws Exception {
		var model = testHelper.parseFile(MODEL_PATH);
		validationHelper.assertNoIssues(model);
		var rootImplementation = model.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> "Root.i".equalsIgnoreCase(classifier.getName()))
				.findFirst();
		assertTrue("Missing Root.i classifier", rootImplementation.isPresent());
		instance = InstantiateModel.instantiate((ComponentImplementation) rootImplementation.get());
	}

	@Test
	public void preservesAndConditionAsSingleCutSet() {
		var fms = instance.getComponentInstances().get(0);
		var cutSets = CreateFTAModel.createMinimalCutSet(fms,
				"outgoing propagation on actuatorOut{ServiceError}");

		assertNotNull(cutSets);
		assertEquals(1, cutSets.getRoot().getSubEvents().size());
		var cutSet = cutSets.getRoot().getSubEvents().get(0);
		assertEquals(LogicOperation.AND, cutSet.getSubEventLogic());
		assertEquals(2, cutSet.getSubEvents().size());
		Set<String> eventNames = cutSet.getSubEvents()
				.stream()
				.map(event -> (ErrorEvent) event.getRelatedEMV2Object())
				.map(ErrorEvent::getName)
				.collect(Collectors.toSet());
		assertEquals(Set.of("ev1", "ev2"), eventNames);
	}
}
