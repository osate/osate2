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
package org.osate.core.tests;

import static org.junit.Assert.assertEquals;

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
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class PropertyTests extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void scope_A() throws Exception {
		String p1 = """
				package p1
				public
				  with p, ps1, ps;
				 \s
				  system s1 extends p::s
				    properties
				      ps::prop => 10cm;
				      ps1::prop1 => 10cm;
				      period => 1sec;
				  end s1;
				 \s
				  system implementation s1.i
				  subcomponents
				    d: data;
				  end s1.i;
				 \s
				end p1;
				""";
		String ps1 = """
				property set ps1 is
				  len_units1: type units (cm, m => cm * 100);
				  prop1: aadlinteger units ps1::len_units1 applies to (system);
				end ps;
				""";
		String ps = """
				property set ps is
				  len_units: type units (cm, m => cm * 100);
				  prop: aadlinteger units ps::len_units applies to (system);
				end ps;
				""";
		String p = """
				package p
				public
				  with ps;
				 \s
				  system s
				    properties
				      ps::prop => 10cm;
				  end s;
				 \s
				end p;
				""";

		AadlPackage pkg = testHelper.parseString(p1, ps1, ps, p);

		assertAllCrossReferencesResolvable(pkg);

		var pas = pkg.getOwnedPublicSection().getOwnedClassifiers().get(0).getOwnedPropertyAssociations();
		assertEquals("prop", pas.get(0).getProperty().getName());
		assertEquals("Period", pas.getLast().getProperty().getName());

		// instantiate
		SystemImplementation sysImpl = (SystemImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.getLast();
		var instance = InstantiateModel.instantiate(sysImpl);
		assertEquals("s1_i_Instance", instance.getName());
		assertEquals(1, instance.getComponentInstances().size());
		assertEquals("d", instance.getComponentInstances().get(0).getName());
	}
}
