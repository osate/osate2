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
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue835Test {
	private static final String PS_TEXT = """
			property set ps835 is
			\tc: constant Time => 2ms;
			\trt: type record (f: Time; f1: list of Time;);
			\trp: ps835::rt applies to (all);
			end ps835;
			""";

	private static final String AADL_TEXT = """
			package issue835
			public
			\twith ps835;
			\tabstract C
			\tend C;
			\t
			\tabstract implementation C.i
			\t	properties
			\t		ps835::rp => [f => ps835::c; f1 => (ps835::c, ps835::c);];
			\t		compute_execution_time => ps835::c .. ps835::c;
			\tend C.i;
			
			end issue835;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue835() throws Exception {
		AadlPackage pkg = testHelper.parseString(AADL_TEXT, PS_TEXT);
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		assertTrue("Component implementation \"C.i\" not found",
				classifiers.stream().anyMatch(classifier -> "C.i".equals(classifier.getName())));
		AbstractImplementation sysImpl = (AbstractImplementation) classifiers.stream()
				.filter(classifier -> "C.i".equals(classifier.getName()))
				.findFirst()
				.get();
		var instance = InstantiateModel.instantiate(sysImpl);
		assertEquals("C_i_Instance", instance.getName());
		var pas = instance.getOwnedPropertyAssociations();

		RecordValue exp0 = (RecordValue) pas.get(0).getOwnedValues().get(0).getOwnedValue();
		IntegerLiteral f0 = (IntegerLiteral) exp0.getOwnedFieldValues().get(0).getOwnedValue();
		assertTrue("Expected value 2 for ps835::rp.f", f0.getValue() == 2);
		ListValue f1 = (ListValue) exp0.getOwnedFieldValues().get(1).getOwnedValue();
		IntegerLiteral e0 = (IntegerLiteral) f1.getOwnedListElements().get(0);
		assertTrue("Expected value 2 for ps835::rp.f1#0", e0.getValue() == 2);
		/* The original reads element 0 again here; kept as is. */
		IntegerLiteral e1 = (IntegerLiteral) f1.getOwnedListElements().get(0);
		assertTrue("Expected value 2 for ps835::rp.f1#1", e1.getValue() == 2);

		RangeValue exp1 = (RangeValue) pas.get(1).getOwnedValues().get(0).getOwnedValue();
		IntegerLiteral min = (IntegerLiteral) exp1.getMinimum();
		assertTrue("Expected value 2 for min compute execution time", min.getValue() == 2);
		IntegerLiteral max = (IntegerLiteral) exp1.getMaximum();
		assertTrue("Expected value 2 for max compute execution time", max.getValue() == 2);
	}
}
