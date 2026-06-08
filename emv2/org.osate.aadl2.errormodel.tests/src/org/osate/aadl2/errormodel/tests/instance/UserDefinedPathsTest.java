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
package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.osate.pluginsupport.ScopeFunctions.with;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.UserDefinedPath;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class UserDefinedPathsTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/UserDefinedPaths/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void testUserDefinedPath() throws Exception {
		var pkg = testHelper.parseFile(PATH + "user_defined_path.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((UserDefinedPath) annexInstance.getPropagationPaths().get(0), userDefinedPath -> {
			assertEquals("path1", userDefinedPath.getName());
			assertEquals("path1", userDefinedPath.getPath().getName());
			assertEquals("left_point", userDefinedPath.getSourcePoint().getName());
			assertEquals("left_point", userDefinedPath.getSourcePropagation().getName());
			assertTrue(userDefinedPath.getSourcePropagation().getSourceUserDefinedPaths().contains(userDefinedPath));
			assertEquals("right_point", userDefinedPath.getDestinationPoint().getName());
			assertEquals("right_point", userDefinedPath.getDestinationPropagation().getName());
			assertTrue(userDefinedPath.getDestinationPropagation()
					.getDestinationUserDefinedPaths()
					.contains(userDefinedPath));
		});
	}

	@Test
	public void testNoPropagations() throws Exception {
		var pkg = testHelper.parseFile(PATH + "no_propagations.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((UserDefinedPath) annexInstance.getPropagationPaths().get(0), userDefinedPath -> {
			assertEquals("path1", userDefinedPath.getName());
			assertEquals("path1", userDefinedPath.getPath().getName());
			assertEquals("left_point", userDefinedPath.getSourcePoint().getName());
			assertNull(userDefinedPath.getSourcePropagation());
			assertEquals("right_point", userDefinedPath.getDestinationPoint().getName());
			assertNull(userDefinedPath.getDestinationPropagation());
		});
	}

	@Test
	public void testWrongDirection() throws Exception {
		var pkg = testHelper.parseFile(PATH + "wrong_direction.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((UserDefinedPath) annexInstance.getPropagationPaths().get(0), userDefinedPath -> {
			assertEquals("path1", userDefinedPath.getName());
			assertEquals("path1", userDefinedPath.getPath().getName());
			assertEquals("left_point", userDefinedPath.getSourcePoint().getName());
			assertNull(userDefinedPath.getSourcePropagation());
			assertEquals("right_point", userDefinedPath.getDestinationPoint().getName());
			assertNull(userDefinedPath.getDestinationPropagation());
		});
	}

	@Test
	public void testReferenceToFeature() throws Exception {
		var pkg = testHelper.parseFile(PATH + "reference_to_feature.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		// Tests that a propagation path which refers to a feature is not instantiated.
		assertEquals(0, annexInstance.getPropagationPaths().size());
	}

	@Test
	public void testUnnamedPaths() throws Exception {
		var pkg = testHelper.parseFile(PATH + "unnamed_paths.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((UserDefinedPath) annexInstance.getPropagationPaths().get(0), userDefinedPath -> {
			assertEquals("left.EMV2.left_point -> right.EMV2.right_point", userDefinedPath.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) system.getOwnedAnnexSubclauses().get(0))
					.getParsedAnnexSubclause()).getPaths().get(0), userDefinedPath.getPath());
			assertEquals("left_point", userDefinedPath.getSourcePoint().getName());
			assertEquals("left_point", userDefinedPath.getSourcePropagation().getName());
			assertTrue(userDefinedPath.getSourcePropagation().getSourceUserDefinedPaths().contains(userDefinedPath));
			assertEquals("right_point", userDefinedPath.getDestinationPoint().getName());
			assertEquals("right_point", userDefinedPath.getDestinationPropagation().getName());
			assertTrue(userDefinedPath.getDestinationPropagation()
					.getDestinationUserDefinedPaths()
					.contains(userDefinedPath));
		});
		with((UserDefinedPath) annexInstance.getPropagationPaths().get(1), userDefinedPath -> {
			assertEquals("right.EMV2.right_point -> left.EMV2.left_point", userDefinedPath.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) system.getOwnedAnnexSubclauses().get(0))
					.getParsedAnnexSubclause()).getPaths().get(1), userDefinedPath.getPath());
			assertEquals("right_point", userDefinedPath.getSourcePoint().getName());
			assertEquals("right_point", userDefinedPath.getSourcePropagation().getName());
			assertTrue(userDefinedPath.getSourcePropagation().getSourceUserDefinedPaths().contains(userDefinedPath));
			assertEquals("left_point", userDefinedPath.getDestinationPoint().getName());
			assertEquals("left_point", userDefinedPath.getDestinationPropagation().getName());
			assertTrue(userDefinedPath.getDestinationPropagation()
					.getDestinationUserDefinedPaths()
					.contains(userDefinedPath));
		});
	}

	@Test
	public void testOverriddenPropagationPath() throws Exception {
		var pkg = testHelper.parseFile(PATH + "overridden_propagation_path.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(2);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((UserDefinedPath) annexInstance.getPropagationPaths().get(0), userDefinedPath -> {
			assertEquals("path1", userDefinedPath.getName());
			assertEquals("path1", userDefinedPath.getPath().getName());
			assertEquals("point3", userDefinedPath.getSourcePoint().getName());
			assertEquals("point3", userDefinedPath.getSourcePropagation().getName());
			assertTrue(userDefinedPath.getSourcePropagation().getSourceUserDefinedPaths().contains(userDefinedPath));
			assertEquals("point4", userDefinedPath.getDestinationPoint().getName());
			assertEquals("point4", userDefinedPath.getDestinationPropagation().getName());
			assertTrue(userDefinedPath.getDestinationPropagation()
					.getDestinationUserDefinedPaths()
					.contains(userDefinedPath));
		});
	}
}