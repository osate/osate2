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
package org.osate.core.tests.instantiation.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;

/**
 * How the system operation modes are enumerated: one per combination of the modes of the modal
 * components, in the order the modal components appear in a pre-order walk of the hierarchy, with a
 * component that is not active in a combination contributing nothing to it.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class SystemOperationModeInstantiationTest extends AbstractComponentInstantiationTest {
	private static final String FILE = "SystemOperationModes.aadl";

	/** A model without modes gets the one system operation mode that stands for the normal state. */
	@Test
	public void modelWithoutModesGetsTheNormalSystemOperationMode() throws Exception {
		var result = instantiate(FILE, "NonModal.i");

		assertEquals(List.of(InstantiateModel.NORMAL_SOM_NAME), somNames(result.instance()));
		assertTrue(result.instance().getSystemOperationModes().get(0).getCurrentModes().isEmpty());
		assertEquals(List.of(), diagnostics(result));
	}

	/**
	 * Two modal components produce the product of their modes, numbered from one, with the mode of the
	 * component found last changing fastest.
	 */
	@Test
	public void severalModalComponentsProduceTheProductOfTheirModes() throws Exception {
		var result = instantiate(FILE, "Product.i");

		assertEquals(List.of("som_1", "som_2", "som_3", "som_4", "som_5", "som_6"), somNames(result.instance()));
		assertEquals(List.of(List.of("Product_i_Instance.a.a1", "Product_i_Instance.b.b1"),
				List.of("Product_i_Instance.a.a1", "Product_i_Instance.b.b2"),
				List.of("Product_i_Instance.a.a1", "Product_i_Instance.b.b3"),
				List.of("Product_i_Instance.a.a2", "Product_i_Instance.b.b1"),
				List.of("Product_i_Instance.a.a2", "Product_i_Instance.b.b2"),
				List.of("Product_i_Instance.a.a2", "Product_i_Instance.b.b3")), somModes(result.instance()));
	}

	/**
	 * A modal component that is not active in one of its parent's modes contributes no mode to the
	 * combinations built over that parent mode, so those collapse into a single system operation mode.
	 */
	@Test
	public void inactiveComponentContributesNoMode() throws Exception {
		var result = instantiate(FILE, "Nested.i");

		assertEquals(List.of("som_1", "som_2", "som_3"), somNames(result.instance()));
		assertEquals(List.of(List.of("Nested_i_Instance.n1", "Nested_i_Instance.inner.a1"),
				List.of("Nested_i_Instance.n1", "Nested_i_Instance.inner.a2"),
				List.of("Nested_i_Instance.n2")), somModes(result.instance()));
	}

	/** Required modes restrict the product to the combinations the mode map allows. */
	@Test
	public void requiredModesRestrictTheProduct() throws Exception {
		var result = instantiate(FILE, "DerivedParent.i");

		assertEquals(List.of("som_1", "som_2"), somNames(result.instance()));
		assertEquals(List.of(List.of("DerivedParent_i_Instance.n1", "DerivedParent_i_Instance.child.n1"),
				List.of("DerivedParent_i_Instance.n2", "DerivedParent_i_Instance.child.n2")),
				somModes(result.instance()));
	}

	/**
	 * Enumeration stops once as many system operation modes as the limit allows have been created, and
	 * reports that the list is incomplete. The limit is a project or workspace preference, so this test
	 * reaches the enumeration directly to set one.
	 */
	@Test
	public void enumerationStopsAtTheLimitAndReportsIt() throws Exception {
		var impl = implementation(FILE, "Product.i");
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		SystemInstance instance = InstantiateModel.instantiate(impl, errorManager);
		assertEquals(6, instance.getSystemOperationModes().size());
		instance.getSystemOperationModes().clear();

		new LimitedEnumeration(errorManager).enumerate(instance, 4);

		assertEquals(List.of("som_1", "som_2", "som_3", "som_4"), somNames(instance));
		var reporter = (QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource());
		assertEquals(List.of("Warning Product_i_Instance: "
				+ "List of system operation modes is incomplete (see project property 'Instantiation')"),
				reporter.getErrors()
						.stream()
						.map(message -> message.kind + " " + path(instance) + ": " + message.message)
						.toList());
	}

	/** Reaches {@code createSystemOperationModes}, which is protected, with a limit of our choosing. */
	private static final class LimitedEnumeration extends InstantiateModel {
		private LimitedEnumeration(AnalysisErrorReporterManager errorManager) {
			super(new NullProgressMonitor(), errorManager);
		}

		private void enumerate(SystemInstance root, int limit) throws InterruptedException {
			createSystemOperationModes(root, limit);
		}
	}
}
