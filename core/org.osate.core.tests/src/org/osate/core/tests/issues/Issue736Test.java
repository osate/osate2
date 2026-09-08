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

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Element;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue736Test extends XtextTest {
	private static final String AADL_TEXT = """
			package pkg
			public
			\tsystem s
			\t\tmodes
			\t\t\tm1: initial mode;
			\t\t\tm2: mode;
			\tend s;
			\t
			\tsystem implementation s.i
			\t\tsubcomponents
			\t\t\tsub1: system in modes (m1);
			\t\t\tsub2: system in modes (m2);
			\tend s.i;
			end pkg;
			""";

	private static class SubcomponentInstanceProcessor extends ForAllElement {
		@Override
		protected boolean suchThat(Element obj) {
			return obj instanceof ComponentInstance && !(obj instanceof SystemInstance);
		}
	}

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue736() throws Exception {
		AadlPackage pkg = testHelper.parseString(AADL_TEXT);
		assertEquals("pkg", pkg.getName());
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();

		SystemImplementation declared = (SystemImplementation) classifiers.get(1);
		assertEquals("s.i", declared.getName());
		SystemImplementation sysImpl = (SystemImplementation) classifiers.stream()
				.filter(classifier -> "s.i".equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		SystemInstance instance = InstantiateModel.instantiate(sysImpl);
		assertEquals("s_i_Instance", instance.getName());
		assertEquals(2, new SubcomponentInstanceProcessor().defaultTraversal(instance).size());
		instance.setCurrentSystemOperationMode(instance.getSystemOperationModes().get(0));
		assertEquals(1, new SubcomponentInstanceProcessor().defaultTraversal(instance).size());
	}
}
