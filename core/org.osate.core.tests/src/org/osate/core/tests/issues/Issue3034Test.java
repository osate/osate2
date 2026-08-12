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
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * A connection declared in a subcomponent array is instantiated for the first array element only and
 * then replicated into the other elements. The replication re-resolved the endpoints of the copy
 * against the target element but kept the connection reference contexts of the element it copied from,
 * so every replicated connection named the first element as the context of the connection reference
 * that goes across. A contained property association that indexes one array element resolves through
 * {@code ComponentInstance.findConnectionInstance()}, which matches on that context, so the value was
 * applied to the connections of every element or to no connection at all.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3034Test extends XtextTest {
	private static final String MODEL_DIR = "org.osate.core.tests/models/issue3034/";
	private static final String MODEL = MODEL_DIR + "Issue3034.aadl";
	private static final String NESTED_MODEL = MODEL_DIR + "Issue3034Nested.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	private AnalysisErrorReporterManager errorManager;

	/**
	 * Every connection reference of a replicated connection instance names the array element that
	 * contains it.
	 */
	@Test
	public void replicatedConnectionReferencesNameTheirElement() throws Exception {
		SystemInstance instance = instantiate(MODEL, "Top.noIndex");

		assertEquals(List.of(
				"Top_noIndex_Instance.nested[1].producers[1].outp --> consumers[1].inp"
						+ " = [c in Top_noIndex_Instance.nested[1]]",
				"Top_noIndex_Instance.nested[1].producers[2].outp --> consumers[2].inp"
						+ " = [c in Top_noIndex_Instance.nested[1]]",
				"Top_noIndex_Instance.nested[2].producers[1].outp --> consumers[1].inp"
						+ " = [c in Top_noIndex_Instance.nested[2]]",
				"Top_noIndex_Instance.nested[2].producers[2].outp --> consumers[2].inp"
						+ " = [c in Top_noIndex_Instance.nested[2]]"),
				referenceContexts(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * A containment path that indexes the first element of the array that owns the connection applies
	 * the value to the connection instances of that element and to no other.
	 */
	@Test
	public void containedPropertyOnIndexedElementAppliesToThatElement() throws Exception {
		SystemInstance instance = instantiate(MODEL, "Top.first");

		assertEquals(List.of("Top_first_Instance.nested[1].producers[1].outp --> consumers[1].inp = delayed",
				"Top_first_Instance.nested[1].producers[2].outp --> consumers[2].inp = delayed",
				"Top_first_Instance.nested[2].producers[1].outp --> consumers[1].inp = <none>",
				"Top_first_Instance.nested[2].producers[2].outp --> consumers[2].inp = <none>"),
				cachedTimings(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * A containment path that indexes an element whose connection instances are replicated copies
	 * applies the value to the connection instances of that element.
	 */
	@Test
	public void containedPropertyOnSecondElementIsNotLost() throws Exception {
		SystemInstance instance = instantiate(MODEL, "Top.second");

		assertEquals(List.of("Top_second_Instance.nested[1].producers[1].outp --> consumers[1].inp = <none>",
				"Top_second_Instance.nested[1].producers[2].outp --> consumers[2].inp = <none>",
				"Top_second_Instance.nested[2].producers[1].outp --> consumers[1].inp = delayed",
				"Top_second_Instance.nested[2].producers[2].outp --> consumers[2].inp = delayed"),
				cachedTimings(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * Control: a containment path without an index names every element of the array, and an indexed
	 * containment path whose last element is a component resolves to that component instance only.
	 * Both are unaffected by the connection reference context.
	 */
	@Test
	public void containedPropertyWithoutIndexAppliesToAllElements() throws Exception {
		SystemInstance allElements = instantiate(MODEL, "Top.noIndex");

		assertEquals(List.of("Top_noIndex_Instance.nested[1].producers[1].outp --> consumers[1].inp = delayed",
				"Top_noIndex_Instance.nested[1].producers[2].outp --> consumers[2].inp = delayed",
				"Top_noIndex_Instance.nested[2].producers[1].outp --> consumers[1].inp = delayed",
				"Top_noIndex_Instance.nested[2].producers[2].outp --> consumers[2].inp = delayed"),
				cachedTimings(allElements));
		assertEquals(List.of(), diagnostics(allElements));

		SystemInstance componentTarget = instantiate(MODEL, "Top.componentTarget");

		assertEquals(List.of("Top_componentTarget_Instance.nested[2].producers[1]"),
				pathsWithProperty(componentTarget, "Period"));
		assertEquals(List.of(), diagnostics(componentTarget));
	}

	/**
	 * The complete connection reference chain of a replicated connection instance names the component
	 * instances of the element that contains it. The contexts of the enclosed references are already
	 * corrected by the endpoint resolution; the context of the reference that goes across is the one
	 * the replication left behind.
	 */
	@Test
	public void replicatedConnectionReferenceChainNamesItsElement() throws Exception {
		SystemInstance instance = instantiate(NESTED_MODEL, "Top.i");

		assertEquals(List.of(
				"Top_i_Instance.nested[1].producer_side.p.outp -> consumer_side.cs.inp"
						+ " = [up in Top_i_Instance.nested[1].producer_side,"
						+ " across in Top_i_Instance.nested[1],"
						+ " down in Top_i_Instance.nested[1].consumer_side]",
				"Top_i_Instance.nested[2].producer_side.p.outp --> consumer_side.cs.inp"
						+ " = [up in Top_i_Instance.nested[2].producer_side,"
						+ " across in Top_i_Instance.nested[2],"
						+ " down in Top_i_Instance.nested[2].consumer_side]"),
				referenceContexts(instance));
		assertEquals(List.of("Top_i_Instance.nested[1].producer_side.p.outp -> consumer_side.cs.inp = <none>",
				"Top_i_Instance.nested[2].producer_side.p.outp --> consumer_side.cs.inp = delayed"),
				cachedTimings(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * The connection and the context of every connection reference, keyed by the path of the connection
	 * instance.
	 */
	private List<String> referenceContexts(SystemInstance instance) {
		return instance.getAllConnectionInstances()
				.stream()
				.map(conni -> conni.getInstanceObjectPath() + " = " + conni.getConnectionReferences()
						.stream()
						.map(connRef -> connRef.getConnection().getName() + " in "
								+ connRef.getContext().getInstanceObjectPath())
						.toList())
				.sorted()
				.toList();
	}

	/**
	 * The Timing value cached on each connection instance, keyed by the path of the connection instance.
	 */
	private List<String> cachedTimings(SystemInstance instance) {
		return instance.getAllConnectionInstances()
				.stream()
				.map(conni -> conni.getInstanceObjectPath() + " = " + cachedTiming(conni))
				.sorted()
				.toList();
	}

	private String cachedTiming(ConnectionInstance conni) {
		return conni.getOwnedPropertyAssociations()
				.stream()
				.filter(pa -> pa.getProperty().getName().equalsIgnoreCase("Timing"))
				.map(pa -> (NamedValue) pa.getOwnedValues().get(0).getOwnedValue())
				.map(value -> ((EnumerationLiteral) value.getNamedValue()).getName())
				.findFirst()
				.orElse("<none>");
	}

	/**
	 * The paths of all component instances that cache the named property.
	 */
	private List<String> pathsWithProperty(ComponentInstance ci, String propertyName) {
		List<String> result = new ArrayList<>();

		if (ci.getOwnedPropertyAssociations()
				.stream()
				.anyMatch(pa -> pa.getProperty().getName().equalsIgnoreCase(propertyName))) {
			result.add(ci.getInstanceObjectPath());
		}
		ci.getComponentInstances().forEach(child -> result.addAll(pathsWithProperty(child, propertyName)));
		return result;
	}

	private SystemInstance instantiate(String model, String implementationName) throws Exception {
		AadlPackage pkg = testHelper.parseFile(model);
		validationHelper.assertNoIssues(pkg);
		ComponentImplementation implementation = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals(implementationName))
				.findFirst()
				.orElseThrow();
		errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);

		SystemInstance instance = InstantiateModel.instantiate(implementation, errorManager);

		assertNotNull(instance);
		return instance;
	}

	private List<String> diagnostics(SystemInstance instance) {
		return ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource())).getErrors()
				.stream()
				.map(message -> message.kind + ": " + message.message)
				.toList();
	}
}
