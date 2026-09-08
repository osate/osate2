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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ScopeTests {
	@Inject
	TestHelper<AadlPackage> testHelper;

	@Inject
	ValidationTestHelper validationTestHelper;

	@Inject
	IScopeProvider scopeProvider;

	@Test
	public void scope_Classifier_InMode() throws Exception {
		AadlPackage pkg = testHelper.parseString("""
				package scopeInModes
				public
				
				  subprogram sb1
				    modes
				      m1: initial mode;
				  end sb1;
				 \s
				  subprogram sb2 extends sb1
				    modes
				      m2: mode;
				  end sb2;
				 \s
				  subprogram implementation sb2.i
				    subcomponents
				      d: data in modes (m1);
				  end sb2.i;
				
				end scopeInModes;
				""");

		SubprogramImplementation impl = (SubprogramImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.getLast();
		var subcomp = impl.getOwnedDataSubcomponents().get(0);
		assertEquals("d", subcomp.getName());
		assertScope(subcomp, Aadl2Package.eINSTANCE.getModalElement_InMode(), "m2, m1");
	}

	@Test
	public void scope_CallSequence_InMode() throws Exception {
		AadlPackage pkg = testHelper.parseString("""
				package scopeInModes
				public
				
				  subprogram sb1
				  end sb1;
				 \s
				  subprogram implementation sb1.i1
				    modes
				      m1: initial mode;
				  end sb1.i1;
				
				  subprogram implementation sb1.i2 extends sb1.i1
				    calls
				      cl1: {
				      	cl11: subprogram sb1;
				      } in modes (m1, m2);
				    modes
				      m2: mode;
				  end sb1.i2;
				
				end scopeInModes;
				""");

		SubprogramImplementation impl = (SubprogramImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.getLast();
		var callSeq = impl.getOwnedSubprogramCallSequences().get(0);
		assertEquals("cl1", callSeq.getName());
		assertScope(callSeq, Aadl2Package.eINSTANCE.getModalElement_InMode(), "m2, m1");
	}

	private void assertScope(EObject context, EReference reference, CharSequence expected) {
		validationTestHelper.assertNoErrors(context);
		var names = new StringBuilder();
		for (IEObjectDescription description : scopeProvider.getScope(context, reference).getAllElements()) {
			if (names.length() > 0) {
				names.append(", ");
			}
			names.append(description.getName());
		}
		assertEquals(expected, names.toString());
	}
}
