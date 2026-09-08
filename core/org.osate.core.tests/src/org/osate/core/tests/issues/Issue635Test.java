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

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue635Test extends XtextTest {
	private static final String PS_TEXT = """
			property set ps635 is
			\tp0: aadlboolean applies to (data, system implementation);
			\tp1: aadlboolean applies to (system type);
			\tp2: aadlboolean applies to (memory, system);
			\tp3: aadlboolean applies to (system subcomponent);
			\tq0: aadlboolean applies to (feature);
			\tq1: aadlboolean applies to (access);
			\tq2: aadlboolean applies to (port);
			\tq3: aadlboolean applies to (feature group);
			\tq4: aadlboolean applies to (feature group type);
			\tr1: aadlboolean applies to (all);
			end ps635;
			""";

	private static final String AADL_TEXT = """
			package issue635
			public
			\twith ps635;

			\tfeature group fg
			\t\tfeatures
			\t\t\tf0: feature {
			\t\t\t\tps635::q0 => true;\t
			\t\t\t};
			\t\t\tf1: in data port {
			\t\t\t\tps635::q0 => true;\t
			\t\t\t\tps635::q2 => true;\t
			\t\t\t\tps635::r1 => true;
			\t\t\t};
			\t\t\tf2: provides bus access {
			\t\t\t\tps635::q0 => true;\t
			\t\t\t\tps635::q1 => true;\t
			\t\t\t};
			\tend fg;
			\t
			\tsystem top
			\t\tfeatures
			\t\t\tfg: feature group fg;
			\t\tproperties
			\t\t\tps635::p1 => false;
			\t\t\tps635::p2 => false;
			\t\t\t
			\t\t\tps635::q0 => true applies to fg;
			\t\t\tps635::q3 => false applies to fg;
			\tend top;

			\tsystem implementation top.i
			\t\tsubcomponents
			\t\t\tsub: system top;
			\t\t\tsub1: system;
			\t\tproperties
			\t\t\tps635::p0 => true;
			\t\t\tps635::p2 => true;
			\t\t\tps635::p2 => true applies to sub1;
			\t\t\tps635::p3 => true applies to sub1;
			\tend top.i;
			\t
			end issue635;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue635() throws Exception {
		AadlPackage pkg = testHelper.parseString(AADL_TEXT, PS_TEXT);
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		assertTrue("System implementation \"top.i\" not found",
				classifiers.stream().anyMatch(classifier -> "top.i".equals(classifier.getName())));
		SystemImplementation sysImpl = (SystemImplementation) classifiers.stream()
				.filter(classifier -> "top.i".equals(classifier.getName()))
				.findFirst()
				.get();
		var instance = InstantiateModel.instantiate(sysImpl);
		assertEquals("top_i_Instance", instance.getName());

		assertEquals("In top_i_Instance: Did not find expected properties",
				propertyNames(instance.getOwnedPropertyAssociations()), List.of("p0", "p2"));
		var fg = instance.getFeatureInstances().get(0);
		assertEquals("In feature group fg: Did not find expected properties",
				propertyNames(fg.getOwnedPropertyAssociations()), List.of("q0", "q3"));
		assertEquals("In feature fg.f2: Did not find expected properties",
				propertyNames(fg.getFeatureInstances().get(0).getOwnedPropertyAssociations()), List.of("q0", "q1"));
		assertEquals("In feature fg.f1: Did not find expected properties",
				propertyNames(fg.getFeatureInstances().get(1).getOwnedPropertyAssociations()),
				List.of("q0", "q2", "r1"));
		assertEquals("In feature fg.f0: Did not find expected properties",
				propertyNames(fg.getFeatureInstances().get(2).getOwnedPropertyAssociations()), List.of("q0"));
		assertEquals("In component sub: Did not find expected properties",
				propertyNames(instance.getComponentInstances().get(0).getOwnedPropertyAssociations()),
				List.of("p2", "p1"));
		assertEquals("In component sub1: Did not find expected properties",
				propertyNames(instance.getComponentInstances().get(1).getOwnedPropertyAssociations()),
				List.of("p2", "p3"));
	}

	private static List<String> propertyNames(List<PropertyAssociation> associations) {
		return associations.stream().map(association -> association.getProperty().getName()).toList();
	}
}
