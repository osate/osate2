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

import static java.util.Objects.isNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@ExtendWith(InjectionExtension.class)
@InjectWith(Aadl2InjectorProvider.class)
public class TRExamplesTest extends XtextTest {

	private static final String PATH = "org.osate.analysis.modes.tests/models/Report_Examples/";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testExample1() throws Exception {
		testCounts("Example_1.aadl", "S.i0", 4, 8);
		testCounts("Example_1.aadl", "S.i1", 4, 6);
		testCounts("Example_1.aadl", "S.i2", 3, 5);
		testCounts("Example_1.aadl", "S.i3", 2, 2);
	}

	@Test
	public void testExample2() throws Exception {
		testCounts("Example_2.aadl", "S.i0", 2, 2);
		testCounts("Example_2.aadl", "S.i1", 2, 1);
		testCounts("Example_2.aadl", "S.i2", 1, 0);
	}

	@Test
	public void testExample3() throws Exception {
		testCounts("Example_3.aadl", "S.i0", 2, 2);
	}

	@Test
	public void testExample4() throws Exception {
		testCounts("Example_4.aadl", "S.i0", 4, 8);
		testCounts("Example_4.aadl", "S.i1", 4, 6);
		testCounts("Example_4.aadl", "S.i2", 8, 16);
	}

	private void testCounts(String file, String rootName, int somCount, int transitionCount) throws Exception {
		AadlPackage pkg = testHelper.parseFile(PATH + file);
		Optional<Classifier> impl = pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(c -> c.getName().equals(rootName))
				.findFirst();

		var root = InstantiateModel.instantiate((ComponentImplementation) impl.get());
		assertEquals(rootName.replace('.', '_') + "_Instance", root.getName());

		var rs = root.eResource().getResourceSet();
		var uri = URI.createFileURI("dummy");
		var res = rs.getResource(uri, false);

		if (isNull(res)) {
			res = rs.createResource(uri);
		} else {
			res.unload();
		}

		var md = new ModeDomain(root, res);
		md.analyze(null, null);
		var level = md.getAnalyzer().getLastLevel();
		Util.assertCounts(level, somCount, transitionCount);
	}
}
