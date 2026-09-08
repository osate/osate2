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

import static org.junit.Assert.assertTrue;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Feature;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue277Test extends XtextTest {
	private static final String AADL_TEXT = """
			package issue277
			public
			\tsystem TestSys
			\t\tfeatures
			\t\t\tfg1: feature group TestExtendedFeatureGroup;
			\t\t\tfg2: feature group TestInvExtendedFeatureGroup;
			\tend TestSys;

			\tsystem TestSubSys
			\tend TestSubSys;

			\tsystem implementation TestSys.Impl
			\tend TestSys.Impl;

			  feature group BaseFG
			  \tfeatures
			  \t\tq: feature;
			  end BaseFG;
			 \s
			\tfeature group TestFeatureGroup extends BaseFG
			\t\tfeatures
			\t\t\ti: in feature;
			\t\t\tp: in feature;
			\tend TestFeatureGroup;

			\tfeature group TestExtendedFeatureGroup extends TestFeatureGroup
			\t\tfeatures
			\t\t\tp: refined to in data port;
			\tend TestExtendedFeatureGroup;

			\tfeature group TestInvFeatureGroup
			\t\tfeatures
			\t\t\to: out feature;
			\t\t\tr: out feature;
			\t\tinverse of TestFeatureGroup
			\tend TestInvFeatureGroup;

			\tfeature group TestInvExtendedFeatureGroup extends TestInvFeatureGroup
			\t\tinverse of TestExtendedFeatureGroup
			\tend TestInvExtendedFeatureGroup;
			end issue277;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue277() throws Exception {
		AadlPackage pkg = testHelper.parseString(AADL_TEXT);
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		assertTrue("Feature group type \"TestInvExtendedFeatureGroup\" not found",
				classifiers.stream()
						.anyMatch(classifier -> "TestInvExtendedFeatureGroup".equals(classifier.getName())));
		var fgt = classifiers.stream()
				.filter(classifier -> "TestInvExtendedFeatureGroup".equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		var features = fgt.getAllFeatures();
		var names = features.stream().map(Feature::getName).toList();
		assertTrue("Feature \"q\" not in feature group", names.contains("q"));
		assertTrue("Feature \"o\" not in feature group", names.contains("o"));
		assertTrue("Feature \"r\" not in feature group", names.contains("r"));
		assertTrue("Expected three features but found " + features.size() + ": " + names, features.size() == 3);
	}
}
