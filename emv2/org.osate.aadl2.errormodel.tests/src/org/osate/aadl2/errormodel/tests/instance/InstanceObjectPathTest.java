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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.osate.pluginsupport.ScopeFunctions.with;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.TypeProductInstance;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class InstanceObjectPathTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void testInstanceObjectPath() throws Exception {
		var pkg = testHelper.parseFile(
				"org.osate.aadl2.errormodel.tests/models/instantiation/Flows/error_path_with_product_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		with(InstantiateModel.instantiate(system), systemInstance -> {
			assertEquals("s_i_Instance.f_in", systemInstance.getFeatureInstances().get(0).getInstanceObjectPath());
			assertEquals("s_i_Instance.f_out", systemInstance.getFeatureInstances().get(1).getInstanceObjectPath());
			with((EMV2AnnexInstance) systemInstance.getAnnexInstances().get(0), annex -> {
				with(annex.getPropagations().get(0), propagation -> {
					assertEquals("s_i_Instance.EMV2.f_in", propagation.getInstanceObjectPath());
					assertEquals("s_i_Instance.EMV2.f_in.{ServiceError}",
							propagation.getInTypeSet().getInstanceObjectPath());
					assertEquals("s_i_Instance.EMV2.f_in.{ServiceError}.ServiceError",
							propagation.getInTypeSet().getElements().get(0).getInstanceObjectPath());
				});
				with(annex.getPropagations().get(1), propagation -> {
					assertEquals(
							"s_i_Instance.EMV2.f_out.{ConcurrencyError, ConcurrencyError * ReplicationError}.ConcurrencyError * ReplicationError",
							propagation.getOutTypeSet().getElements().get(1).getInstanceObjectPath());
					assertEquals(
							"s_i_Instance.EMV2.f_out.{ConcurrencyError, ConcurrencyError * ReplicationError}.ConcurrencyError * ReplicationError.ReplicationError",
							((TypeProductInstance) propagation.getOutTypeSet().getElements().get(1)).getTypes()
									.get(1)
									.getInstanceObjectPath());
				});
				assertEquals("s_i_Instance.EMV2.path_1", annex.getErrorFlows().get(0).getInstanceObjectPath());
			});
		});
	}
}