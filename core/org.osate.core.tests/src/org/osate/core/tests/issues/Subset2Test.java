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

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Subset2Test {
	private static final String AADL_TEXT = """
			package subset2

			public

			data mydata
			end mydata;

			bus genericbus
			end genericbus;

			-- bi-directional sub feature group
			feature group fgsub1
			features
			\tf1 : in data port mydata;
			\tf2 : in data port mydata;\t
			\tf4 : out data port mydata;\t
			end fgsub1;

			-- bi-directional subset feature group
			feature group fgsub2
			features
			\tf3 : in data port mydata;
			\tf4 : out data port mydata;\t
			\tb1: provides bus access genericbus;
			end fgsub2;


			-- Here, we have all
			-- the features within the same feature group.
			feature group fgfull
			features
			\tf1 : out data port mydata;
			\tf2 : out data port mydata;
			\tf3 : out data port mydata;
			\tf4 : in data port mydata;\t
			\tb1: requires bus access genericbus;
			end fgfull;

			--  sfull uses the feature group with
			--  all the features.
			system sfull
			features
			\tf : feature group fgfull;
			end sfull;


			--  sbus uses the bus feature group
			system sub2
			features
			\tf : feature group fgsub2;
			end sub2;


			--  sport uses the ports feature group.
			system sub1
			features
			\tf : feature group fgsub1;
			end sub1;

			system main
			end main;


			--  We use Subset matching to allow DDS type of support.
			system implementation main.subset
			subcomponents
			\tsfull 	: system sfull;
			\tsub1 : system sub1;
			\tsub2 : system sub2;
			\tconnections
			\t-- subc1 will generate connections in one direction only
			\t-- f4 is not included as it goes in the opposite direction to the connection.
			\tsub1c : feature group sfull.f -> sub1.f {Classifier_Matching_Rule => subset;};
			\t-- subc2 includes connections in both directions.
			\tsub2c : feature group sfull.f <-> sub2.f {Classifier_Matching_Rule => subset;};
			end main.subset;
			\t
			end subset2;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue480() throws Exception {
		AadlPackage pkg = testHelper.parseString(AADL_TEXT);
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		assertTrue("System implementation \"main.subset\" not found",
				classifiers.stream().anyMatch(classifier -> "main.subset".equals(classifier.getName())));
		SystemImplementation sysImpl = (SystemImplementation) classifiers.stream()
				.filter(classifier -> "main.subset".equals(classifier.getName()))
				.findFirst()
				.get();
		var instance = InstantiateModel.instantiate(sysImpl);
		assertEquals("main_subset_Instance", instance.getName());
		var connections = instance.getConnectionInstances();
		assertTrue("In main_subset_Instance: Expected 6 connections but found " + connections.size(),
				connections.size() == 6);
	}
}
