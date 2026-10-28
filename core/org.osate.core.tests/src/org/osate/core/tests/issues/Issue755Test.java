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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.util.InstanceUtil;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.modeltraversal.SOMIterator;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue755Test extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void nonModalInstanceHasNoSystemOperationModes() throws Exception {
		var instance = instantiate("NonModal.i");
		assertEquals(0, instance.getSystemOperationModes().size());
		assertNull(instance.getInitialSystemOperationMode());
	}

	@Test
	public void nonModalAnalysisRunsOnceWithoutAMode() throws Exception {
		var instance = instantiate("NonModal.i");
		var iterator = new SOMIterator(instance);
		assertTrue(iterator.hasNext());
		assertNull(iterator.nextSOM());
		assertNull(instance.getCurrentSystemOperationMode());
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, iterator::next);
		assertTrue(InstanceUtil.isNoMode(null));
	}

	@Test
	public void modalAnalysisStillVisitsEachModeAndClearsState() throws Exception {
		var instance = instantiate("Modal.i");
		assertEquals(2, instance.getSystemOperationModes().size());
		assertSame(instance.getSystemOperationModes().getFirst(), instance.getInitialSystemOperationMode());
		var iterator = new SOMIterator(instance);
		for (var mode : instance.getSystemOperationModes()) {
			assertTrue(iterator.hasNext());
			assertSame(mode, iterator.next());
			assertSame(mode, instance.getCurrentSystemOperationMode());
		}
		assertFalse(iterator.hasNext());
		assertNull(instance.getCurrentSystemOperationMode());
	}

	@Test
	public void clearingModeThroughSetterClearsModalState() throws Exception {
		var instance = instantiate("Modal.i");
		instance.setCurrentSystemOperationMode(instance.getInitialSystemOperationMode());
		instance.setCurrentSystemOperationMode(null);
		assertNull(instance.getCurrentSystemOperationMode());
	}

	@Test
	public void legacyNoModesInstanceRemainsUsable() throws Exception {
		var instance = instantiate("NonModal.i");
		instance.getSystemOperationModes().clear();
		var legacyMode = instance.createSystemOperationMode();
		legacyMode.setName("No Modes");
		assertSame(legacyMode, instance.getInitialSystemOperationMode());
		assertTrue(InstanceUtil.isNoMode(legacyMode));
		var iterator = new SOMIterator(instance);
		assertTrue(iterator.hasNext());
		assertSame(legacyMode, iterator.next());
		assertFalse(iterator.hasNext());
		assertNull(instance.getCurrentSystemOperationMode());
	}

	@Test
	public void nonModalRequiredConnectionIsStillChecked() throws Exception {
		var manager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		var instance = InstantiateModel.instantiate(implementation("NonModal.required"), manager);
		assertTrue(instance.getSystemOperationModes().isEmpty());
		var messages = ((QueuingAnalysisErrorReporter) manager.getReporter(instance.eResource())).getErrors();
		assertEquals(1, messages.size());
		var message = messages.getFirst();
		assertEquals(QueuingAnalysisErrorReporter.Kind.WARNING, message.kind);
		assertEquals("Feature is required to be connected but is not", message.message);
		assertSame(instance.getComponentInstances().getFirst().getFeatureInstances().getFirst(), message.where);
	}

	private SystemInstance instantiate(String name) throws Exception {
		return InstantiateModel.instantiate(implementation(name));
	}

	private ComponentImplementation implementation(String name) throws Exception {
		var pkg = testHelper.parseFile("org.osate.core.tests/models/issue755/Issue755.aadl");
		validationHelper.assertNoIssues(pkg);
		return (ComponentImplementation) pkg.getOwnedPublicSection().getOwnedClassifiers().stream()
				.filter(classifier -> classifier.getName().equals(name)).findFirst().orElseThrow();
	}
}
