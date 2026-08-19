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
import static org.junit.Assert.assertTrue;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.errormodel.FaultTree.LogicOperation;
import org.osate.aadl2.errormodel.faulttree.generation.CreateFTAModel;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class Issue2927Test {
	private static final String MODEL_PATH = "org.osate.aadl2.errormodel.faulttree.tests/models/issue2927/Issue2927.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	private AadlPackage model;

	@Before
	public void parseModel() throws Exception {
		model = testHelper.parseFile(MODEL_PATH);
		validationHelper.assertNoIssues(model);
	}

	@Test
	public void computesKOrMoreFailureProbabilities() throws Exception {
		assertProbability("redundant_thing.i4_2", 5.9999200003E-10);
		assertProbability("redundant_thing.i4_3", 3.99997E-15);
		assertProbability("redundant_thing.i4_4", 1E-20);
	}

	private void assertProbability(final String classifierName, final double expected) throws Exception {
		var classifier = model.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(candidate -> candidateNameMatches(candidate.getName(), classifierName))
				.findFirst();
		assertTrue("Missing classifier " + classifierName, classifier.isPresent());

		var instance = InstantiateModel.instantiate((ComponentImplementation) classifier.get());
		assertKOrMoreProbability(CreateFTAModel.createFaultTree((SystemInstance) instance, "state Failed"), expected);
	}

	private static boolean candidateNameMatches(final String candidateName, final String expectedName) {
		return candidateName != null && candidateName.equalsIgnoreCase(expectedName);
	}

	private static void assertKOrMoreProbability(final FaultTree faultTree, final double expected) {
		var kOrMoreEvent = faultTree.getEvents()
				.stream()
				.filter(event -> event.getSubEventLogic() == LogicOperation.KORMORE)
				.findFirst();
		assertTrue("The generated fault tree does not contain a k-or-more event", kOrMoreEvent.isPresent());
		var actualProbability = kOrMoreEvent.get().getComputedProbability();
		assertEquals("Unexpected k-or-more probability", expected, actualProbability.doubleValue(), expected * 1.0E-12);
	}
}
