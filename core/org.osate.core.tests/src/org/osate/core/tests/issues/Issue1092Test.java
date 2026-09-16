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

import java.util.List;
import java.util.function.Predicate;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter.Kind;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter.Message;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1092Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue1092/";
	private static final String IMPLICIT_MAPPING_TEST = "ImplicitMapping.aadl";
	private static final String EXPLICIT_MAPPING_TEST = "ExplicitMapping.aadl";
	private static final String REGULAR_MODES_TEST = "RegularModes.aadl";
	private static final String UNMAPPED_MODES_TEST = "UnmappedModes.aadl";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testImplicitMapping() throws Exception {
		testMappedModes(IMPLICIT_MAPPING_TEST, "m1", "m2");
	}

	@Test
	public void testExplicitMapping() throws Exception {
		testMappedModes(EXPLICIT_MAPPING_TEST, "x1", "x2");
	}

	@Test
	public void testRegularModes() throws Exception {
		var pkg = getPackage(REGULAR_MODES_TEST);
		var instance = getSystemInstance(pkg, "main.impl", "main_impl_Instance", null);

		var proc = instance.getComponentInstances().get(0);
		assertTrue("System is expected to have exactly one subcomponent", instance.getComponentInstances().size() == 1);
		assertTrue("Process 'proc' is expected as the only child of system", proc.getName().equals("proc"));
		assertTrue("Process 'proc' is expected to exactly 2 modes", proc.getModeInstances().size() == 2);
		var procM1 = getAndTestElement(proc.getModeInstances(), 0,
				"Mode 'm1' is expected as the first mode of 'proc'", mode -> mode.getName().equals("m1"));
		var procM2 = getAndTestElement(proc.getModeInstances(), 1,
				"Mode 'm2' is expected as the second mode of 'proc'", mode -> mode.getName().equals("m2"));

		assertTrue("Process 'proc' is expected to have exactly 2 subcomponents",
				proc.getComponentInstances().size() == 2);
		var t1 = getAndTestElement(proc.getComponentInstances(), 0,
				"Thread 't1' is expected as the first subcomponent of 'proc'", thread -> thread.getName().equals("t1"));
		var t2 = getAndTestElement(proc.getComponentInstances(), 1,
				"Thread 't2' is expected as the second subcomponent of 'proc'",
				thread -> thread.getName().equals("t2"));

		var t1Modes = testThreadRegularModes(t1, "m1", "m2");
		var t2Modes = testThreadRegularModes(t2, "m1", "m2");

		assertTrue("System is expected to have exactly 8 system operation modes",
				instance.getSystemOperationModes().size() == 8);
		var soms = instance.getSystemOperationModes();
		var som0 = testSystemOperationMode(soms.get(0), procM1, t1Modes.get(0), t2Modes.get(0));
		var som1 = testSystemOperationMode(soms.get(1), procM1, t1Modes.get(0), t2Modes.get(1));
		var som2 = testSystemOperationMode(soms.get(2), procM1, t1Modes.get(1), t2Modes.get(0));
		var som3 = testSystemOperationMode(soms.get(3), procM1, t1Modes.get(1), t2Modes.get(1));
		var som4 = testSystemOperationMode(soms.get(4), procM2, t1Modes.get(0), t2Modes.get(0));
		var som5 = testSystemOperationMode(soms.get(5), procM2, t1Modes.get(0), t2Modes.get(1));
		var som6 = testSystemOperationMode(soms.get(6), procM2, t1Modes.get(1), t2Modes.get(0));
		var som7 = testSystemOperationMode(soms.get(7), procM2, t1Modes.get(1), t2Modes.get(1));

		var t1PropertyValues = propertyValues(t1);
		testPropertyValueModes(t1PropertyValues.get(0).getInModes(), som0, som1, som4, som5);
		testPropertyValueModes(t1PropertyValues.get(1).getInModes(), som2, som3, som6, som7);

		var t2PropertyValues = propertyValues(t2);
		testPropertyValueModes(t2PropertyValues.get(0).getInModes(), som0, som2, som4, som6);
		testPropertyValueModes(t2PropertyValues.get(1).getInModes(), som1, som3, som5, som7);
	}

	@Test
	public void testUnmappedModes() throws Exception {
		var pkg = getPackage(UNMAPPED_MODES_TEST);

		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		var instance = getSystemInstance(pkg, "main.impl", "main_impl_Instance", errorManager);
		var reporter = (QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource());
		var messages = reporter.getErrors();

		assertTrue("Instance model should have exactly 4 errors", messages.size() == 4);

		var proc = instance.getComponentInstances().get(0);
		assertTrue("System is expected to have exactly one subcomponent", instance.getComponentInstances().size() == 1);
		assertTrue("Process 'proc' is expected as the only child of system", proc.getName().equals("proc"));
		assertTrue("Process 'proc' is expected to exactly 2 modes", proc.getModeInstances().size() == 2);
		var procM1 = getAndTestElement(proc.getModeInstances(), 0,
				"Mode 'm1' is expected as the first mode of 'proc'", mode -> mode.getName().equals("m1"));
		var procM2 = getAndTestElement(proc.getModeInstances(), 1,
				"Mode 'm2' is expected as the second mode of 'proc'", mode -> mode.getName().equals("m2"));

		assertTrue("Process 'proc' is expected to have exactly 2 subcomponents",
				proc.getComponentInstances().size() == 2);
		var t1 = getAndTestElement(proc.getComponentInstances(), 0,
				"Thread 't1' is expected as the first subcomponent of 'proc'", thread -> thread.getName().equals("t1"));
		var t2 = getAndTestElement(proc.getComponentInstances(), 1,
				"Thread 't2' is expected as the second subcomponent of 'proc'",
				thread -> thread.getName().equals("t2"));

		testThreadUnmappedModes(messages, t1, "x1", "x2");
		testThreadUnmappedModes(messages, t2, "x1", "x2");

		assertTrue("System is expected to have exactly 8 system operation modes",
				instance.getSystemOperationModes().size() == 2);
		testSystemOperationMode(instance.getSystemOperationModes().get(0), procM1);
		testSystemOperationMode(instance.getSystemOperationModes().get(1), procM2);
	}

	private void testMappedModes(String fileName, String threadModeName1, String threadModeName2) throws Exception {
		var pkg = getPackage(fileName);
		var instance = getSystemInstance(pkg, "main.impl", "main_impl_Instance", null);

		var proc = instance.getComponentInstances().get(0);
		assertTrue("System is expected to have exactly one subcomponent", instance.getComponentInstances().size() == 1);
		assertTrue("Process 'proc' is expected as the only child of system", proc.getName().equals("proc"));
		assertTrue("Process 'proc' is expected to exactly 2 modes", proc.getModeInstances().size() == 2);
		var procM1 = getAndTestElement(proc.getModeInstances(), 0,
				"Mode 'm1' is expected as the first mode of 'proc'", mode -> mode.getName().equals("m1"));
		var procM2 = getAndTestElement(proc.getModeInstances(), 1,
				"Mode 'm2' is expected as the second mode of 'proc'", mode -> mode.getName().equals("m2"));

		assertTrue("Process 'proc' is expected to have exactly 2 subcomponents",
				proc.getComponentInstances().size() == 2);
		var t1 = getAndTestElement(proc.getComponentInstances(), 0,
				"Thread 't1' is expected as the first subcomponent of 'proc'", thread -> thread.getName().equals("t1"));
		var t2 = getAndTestElement(proc.getComponentInstances(), 1,
				"Thread 't2' is expected as the second subcomponent of 'proc'",
				thread -> thread.getName().equals("t2"));

		var t1Modes = testThreadRequiredModes(proc, procM1, procM2, t1, threadModeName1, threadModeName2);
		var t2Modes = testThreadRequiredModes(proc, procM1, procM2, t2, threadModeName1, threadModeName2);

		assertTrue("System is expected to have exactly 2 system operation modes",
				instance.getSystemOperationModes().size() == 2);
		var som1 = testSystemOperationMode(instance.getSystemOperationModes().get(0), procM1, t1Modes.get(0),
				t2Modes.get(0));
		var som2 = testSystemOperationMode(instance.getSystemOperationModes().get(1), procM2, t2Modes.get(1),
				t2Modes.get(1));

		assertSingleModePropertyValues(t1, som1, som2);
		assertSingleModePropertyValues(t2, som1, som2);
	}

	private static void assertSingleModePropertyValues(ComponentInstance thread, SystemOperationMode som1,
			SystemOperationMode som2) {
		var propertyValues = propertyValues(thread);
		var value1 = propertyValues.get(0);
		assertTrue("The first property value is expected to have exactly 1 mode", value1.getInModes().size() == 1);
		assertTrue("The first property value is expected to be in system operation mode '" + som1.getName() + "'",
				value1.getInModes().get(0) == som1);
		var value2 = propertyValues.get(1);
		assertTrue("The second property value is expected to have exactly 1 mode", value2.getInModes().size() == 1);
		assertTrue("The second property value is expected to be in system operation mode '" + som2.getName() + "'",
				value2.getInModes().get(0) == som2);
	}

	private static EList<ModalPropertyValue> propertyValues(ComponentInstance thread) {
		var properties = thread.getOwnedPropertyAssociations();
		assertTrue("Thread '" + thread.getName() + "' is expected to have exactly 1 property association",
				properties.size() == 1);
		var values = properties.get(0).getOwnedValues();
		assertTrue("Thread '" + thread.getName() + "' is expected to have exactly 2 property values",
				values.size() == 2);
		return values;
	}

	private static void testPropertyValueModes(List<Mode> actualModes, SystemOperationMode... testModes) {
		assertTrue("The property value is expected to have exactly " + testModes.length + " modes",
				actualModes.size() == testModes.length);
		for (var mode : testModes) {
			assertTrue("The property value is expected to be in system operation mode '" + mode.getName() + "'",
					actualModes.contains(mode));
		}
	}

	private static SystemOperationMode testSystemOperationMode(SystemOperationMode som, ModeInstance... modes) {
		assertTrue("System operation mode '" + som.getName() + "' is expected to have exactly " + modes.length
				+ " current modes", som.getCurrentModes().size() == modes.length);
		for (var mode : modes) {
			assertTrue("System operation mode '" + som.getName() + "' is expected to have mode '" + mode.getName()
					+ "' as a current mode", som.getCurrentModes().contains(mode));
		}
		return som;
	}

	private static List<ModeInstance> testThreadUnmappedModes(List<Message> messages, ComponentInstance thread,
			String modeName1, String modeName2) {
		var modes = threadModes(thread, modeName1, modeName2);
		for (var mode : modes) {
			assertTrue("Mode '" + mode.getName() + "' of '" + thread.getName() + "' is expected to be derived",
					mode.isDerived());
			assertTrue("Mode '" + mode.getName() + "' of '" + thread.getName() + "' is expected to have no parents",
					mode.getParents().isEmpty());
			testForError(messages, mode,
					"Required mode '" + mode.getName() + "' not found in containing component");
		}
		return modes;
	}

	private static void testForError(List<Message> messages, EObject element, String expectedMessage) {
		var error = messages.stream().filter(message -> message.where == element).findFirst().orElseThrow();
		assertEquals(Kind.ERROR, error.kind);
		assertEquals(expectedMessage, error.message);
	}

	private static List<ModeInstance> testThreadRegularModes(ComponentInstance thread, String modeName1,
			String modeName2) {
		var modes = threadModes(thread, modeName1, modeName2);
		for (var mode : modes) {
			assertTrue("Mode '" + mode.getName() + "' of '" + thread.getName() + "' is expected to not be derived",
					!mode.isDerived());
		}
		return modes;
	}

	private static List<ModeInstance> testThreadRequiredModes(ComponentInstance proc, ModeInstance procM1,
			ModeInstance procM2, ComponentInstance thread, String modeName1, String modeName2) {
		var modes = threadModes(thread, modeName1, modeName2);
		testModeMapping(proc, thread, procM1, modes.get(0));
		testModeMapping(proc, thread, procM2, modes.get(1));
		return modes;
	}

	private static List<ModeInstance> threadModes(ComponentInstance thread, String modeName1, String modeName2) {
		assertTrue("Thread '" + thread.getName() + "' is expected to have exactly 2 modes",
				thread.getModeInstances().size() == 2);
		var mode1 = getAndTestElement(thread.getModeInstances(), 0,
				"Mode '" + modeName1 + "' is expected as the first mode of '" + thread.getName() + "'",
				mode -> mode.getName().equals(modeName1));
		var mode2 = getAndTestElement(thread.getModeInstances(), 1,
				"Mode '" + modeName2 + "' is expected as the second mode of '" + thread.getName() + "'",
				mode -> mode.getName().equals(modeName2));
		return List.of(mode1, mode2);
	}

	private static void testModeMapping(ComponentInstance parentComponent, ComponentInstance subComponent,
			ModeInstance parentMode, ModeInstance subMode) {
		assertTrue("Mode '" + subMode.getName() + "' of '" + subComponent.getName() + "' is expected to be derived",
				subMode.isDerived());
		assertTrue("Mode '" + subMode.getName() + "' of '" + subComponent.getName() + "' is expected to have mode '"
				+ parentMode.getName() + "' of '" + parentComponent.getName() + "' as its parent",
				subMode.getParents().get(0) == parentMode);
	}

	private static <X> X getAndTestElement(EList<X> list, int index, String message, Predicate<X> test) {
		var element = list.get(index);
		assertTrue(message, test.test(element));
		return element;
	}

	private AadlPackage getPackage(String fileName) throws Exception {
		var result = testHelper.testFile(PROJECT_LOCATION + fileName);
		return (AadlPackage) result.getResource().getContents().getFirst();
	}

	private static SystemInstance getSystemInstance(AadlPackage pkg, String systemImplName,
			String expectedInstanceName, AnalysisErrorReporterManager errorManager) throws Exception {
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		var implementation = (SystemImplementation) classifiers.stream()
				.filter(classifier -> systemImplName.equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		assertTrue("System implementation \"" + systemImplName + "\" not found", implementation != null);

		// Instantiate system
		var instance = InstantiateModel.instantiate(implementation, errorManager);
		assertEquals(expectedInstanceName, instance.getName());
		return instance;
	}
}
