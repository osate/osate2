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

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue810Test {
	@Inject
	ValidationTestHelper validationTestHelper;

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue810() throws Exception {
		String pkg1 = """
				package pkg1
				public
				\tabstract a1
				\tend a1;
				\t
				\tabstract implementation a1.i
				\t\tsubcomponents
				\t\t\tsub1: abstract a2;
				\t\t\tsub2: abstract a2;
				\t\tconnections
				\t\t\tconn1: feature group sub1.fg1 -> sub2.fg2;
				\t\t\tconn3: feature group sub1.fg3.fg5 -> sub2.fg4.fg5;
				\tend a1.i;
				\t
				\tabstract a2
				\t\tfeatures
				\t\t\tfg1: out feature group fgt1;
				\t\t\tfg2: in feature group inverse of fgt1;
				\t\t\tfg3: feature group fgt2;
				\t\t\tfg4: feature group inverse of fgt2;
				\tend a2;
				\t
				\tfeature group fgt1
				\t\tfeatures
				\t\t\tp1: out data port;
				\tend fgt1;
				\t
				\tfeature group fgt2
				\t\tfeatures
				\t\t\tfg5: out feature group fgt1;
				\tend fgt2;
				end pkg1;
				""";
		validationTestHelper.assertNoIssues(testHelper.parseString(pkg1));
	}
}
