/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.analysis.modes.reachability;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.result.AnalysisResult;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@ExtendWith(InjectionExtension.class)
@InjectWith(Aadl2InjectorProvider.class)
public class SOMTest extends XtextTest {

	private static final String PATH = "org.osate.analysis.modes.tests/models/SOMTest/";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testT00() throws Exception {
		testCounts("T00.aadl", 2, 1);
	}

	@Test
	public void testT00a() throws Exception {
		testCounts("T00a.aadl", 4, 3);
	}

	@Test
	public void testT01a() throws Exception {
		testCounts("T01a.aadl", 2, 1);
	}

	@Test
	public void testT01b() throws Exception {
		testCounts("T01b.aadl", 1, 0);
	}

	@Test
	public void testT02() throws Exception {
		testCounts("T02.aadl", 2, 2);
	}

	@Test
	public void testT03() throws Exception {
		testCounts("T03.aadl", 5, 7);
	}

	@Test
	public void testT04() throws Exception {
		testCounts("T04.aadl", 20, 36);
	}

	@Test
	public void testT04a() throws Exception {
		testCounts("T04a.aadl", 4, 4);
	}

	@Test
	public void testT04b() throws Exception {
		testCounts("T04b.aadl", 20, 36);
	}

	@Test
	public void testT05() throws Exception {
		testCounts("T05.aadl", 8, 12);
	}

	@Test
	public void testT06() throws Exception {
		testCounts("T06.aadl", 8, 12);
	}

	@Test
	public void testT10() throws Exception {
		testCounts("T10.aadl", 4, 3);
	}

	@Test
	public void testT11() throws Exception {
		testCounts("T11.aadl", 10, 13);
	}

	@Test
	public void testT20() throws Exception {
		testCounts("T20.aadl", 3, 2);
	}

	private void testCounts(String file, int somCount, int transitionCount) throws Exception {
		AadlPackage pkg = testHelper.parseFile(PATH + file);
		Optional<Classifier> impl = pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(c -> c.getName().equals("S.i"))
				.findFirst();

		var root = InstantiateModel.instantiate((ComponentImplementation) impl.get());
		assertEquals("S_i_Instance", root.getName());

		var ra = new ReachabilityAnalyzer();
		ra.analyze(root);
		var level = ra.getLastLevel();
		Util.assertCounts(level, somCount, transitionCount);
	}
}
