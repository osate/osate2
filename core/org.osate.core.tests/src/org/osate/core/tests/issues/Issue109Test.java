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
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Objects;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue109Test {
	private static final String FILE = "org.osate.core.tests/models/issue109/issue109.aadl";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testInstantiation() throws Exception {
		AadlPackage pkg = testHelper.parseFile(FILE);
		ComponentImplementation impl = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> "T.i".equals(classifier.getName()))
				.findFirst()
				.get();
		var instance = InstantiateModel.instantiate(impl);
		assertEquals("T_i_Instance", instance.getName());

		var mt1 = instance.getModeTransitionInstances().get(0);
		var compB = instance.getComponentInstances()
				.stream()
				.filter(component -> "b".equals(component.getName()))
				.findFirst()
				.get();
		var mt2 = compB.getModeTransitionInstances().get(0);
		var mt3 = compB.getModeTransitionInstances().get(1);

		assertTrue(mt1.getTriggers().size() == 1);
		assertTrue(Objects.equals(mt1.getTriggers().get(0), featureNamed(compB.getFeatureInstances(), "e")));
		assertTrue(mt2.getTriggers().size() == 1);
		assertTrue(Objects.equals(mt2.getTriggers().get(0), featureNamed(compB.getFeatureInstances(), "e")));
		assertTrue(mt3.getTriggers().size() == 1);
		assertTrue(Objects.equals(mt3.getTriggers().get(0),
				featureNamed(featureNamed(compB.getFeatureInstances(), "fg").getFeatureInstances(), "f")));
	}

	private static FeatureInstance featureNamed(List<FeatureInstance> features, String name) {
		return features.stream().filter(feature -> name.equals(feature.getName())).findFirst().orElse(null);
	}
}
