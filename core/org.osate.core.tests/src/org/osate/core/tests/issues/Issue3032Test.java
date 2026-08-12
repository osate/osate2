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
import static org.junit.Assert.assertTrue;

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
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Connection expansion for arrays, {@code Connection_Pattern} and {@code Connection_Set} used to run
 * after connection validation and after end to end flow creation. Expansion deletes the provisional
 * connection instances that it replaces, which removed them from the flow instances that already
 * referred to them, and the expanded replacements were neither validated nor added to those flows.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3032Test extends XtextTest {
	private static final String MODEL_DIR = "org.osate.core.tests/models/issue3032/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	private AnalysisErrorReporterManager errorManager;

	/**
	 * A subcomponent array expands the connection into one connection instance per element. The end to
	 * end flow has to be built over those connection instances.
	 */
	@Test
	public void endToEndFlowUsesExpandedArrayConnection() throws Exception {
		SystemInstance instance = instantiate("Issue3032.aadl", "Top.i");

		assertEquals(List.of("producers[1].outp --> consumers[1].inp", "producers[2].outp --> consumers[2].inp"),
				names(instance.getAllConnectionInstances()));
		assertEquals(List.of(List.of("fsrc", "producers[1].outp --> consumers[1].inp", "fsnk")),
				flowElementNames(instance));
		assertNoDanglingFlowConnections(instance);
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * {@code Connection_Set} replaces the connection instance with one instance per index pair. The end
	 * to end flow has to be built over those connection instances.
	 */
	@Test
	public void endToEndFlowUsesConnectionSetConnection() throws Exception {
		SystemInstance instance = instantiate("Issue3032Set.aadl", "Top.matched");

		assertEquals(List.of("producers[1].outp --> consumers[1].inp", "producers[2].outp --> consumers[2].inp"),
				names(instance.getAllConnectionInstances()));
		assertEquals(List.of(List.of("fsrc", "producers[1].outp --> consumers[1].inp", "fsnk")),
				flowElementNames(instance));
		assertNoDanglingFlowConnections(instance);
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * A {@code Connection_Set} that crosses the element indices leaves no connection instance that
	 * continues the declared flow. Instantiation has to report that instead of producing a flow instance
	 * whose connection segment is missing.
	 */
	@Test
	public void unconnectableEndToEndFlowIsReported() throws Exception {
		SystemInstance instance = instantiate("Issue3032Set.aadl", "Top.crossed");

		assertEquals(List.of("producers[1].outp --> consumers[2].inp", "producers[2].outp --> consumers[1].inp"),
				names(instance.getAllConnectionInstances()));
		assertEquals(List.of(), flowElementNames(instance));
		assertEquals(List.of("Error: Cannot create end to end flow 'etef' because there are no semantic connections"
				+ " that connect to the start of the flow 'fsnk' at feature 'inp'"), diagnostics(instance));
	}

	/**
	 * {@code All_To_One} expands the connection into two connection instances that end at the same in
	 * data port. Connection validation only sees that conflict if it runs after the expansion.
	 */
	@Test
	public void expandedConnectionsAreValidated() throws Exception {
		SystemInstance instance = instantiate("Issue3032Validation.aadl", "Top.i");

		assertEquals(List.of("producers[1].outp --> consumer.inp", "producers[2].outp --> consumer.inp"),
				names(instance.getAllConnectionInstances()));

		String dataPortPath = instance.getComponentInstances()
				.get(0)
				.getComponentInstances()
				.stream()
				.filter(ci -> ci.getName().equals("consumer"))
				.findFirst()
				.orElseThrow()
				.getFeatureInstances()
				.get(0)
				.getInstanceObjectPath();
		List<String> messages = diagnostics(instance);

		assertTrue("expected the data port conflict to be reported, got " + messages,
				messages.contains("Error: More than one connection instance ends at data port"));
		assertEquals("expected one report per conflicting connection instance, got " + messages, 2,
				messages.stream()
						.filter(m -> m.equals("Error: More than one connection instance ends at data port "
								+ dataPortPath))
						.count());
	}

	/**
	 * Characterization of the lookup context used for the structural connection properties. The
	 * expansion evaluates {@code Connection_Pattern} and {@code Connection_Set} before the final
	 * connection instances exist, so the values it resolves must not change for any of these contexts.
	 * The number and the endpoints of the connection instances are what the resolved value determines.
	 * <p>
	 * {@code Top.inheriting} records that a value on a refined-from connection is not picked up for the
	 * refining connection, and {@code Top.modal} records that the first modal value is the one applied.
	 * Both are pre-existing behavior.
	 */
	@Test
	public void structuralPropertyLookupContextIsUnchanged() throws Exception {
		List<String> allToAll = List.of("producers[1].outp --> consumers[1].inp",
				"producers[1].outp --> consumers[2].inp", "producers[2].outp --> consumers[1].inp",
				"producers[2].outp --> consumers[2].inp");
		List<String> oneToOne = List.of("producers[1].outp --> consumers[1].inp",
				"producers[2].outp --> consumers[2].inp");

		assertEquals("Connection_Pattern declared on the connection", allToAll,
				names(instantiate("Issue3032Properties.aadl", "Top.direct").getAllConnectionInstances()));
		assertEquals("Connection_Pattern supplied by the enclosing implementation", allToAll,
				names(instantiate("Issue3032Properties.aadl", "Top.contextual").getAllConnectionInstances()));
		assertEquals("Connection_Pattern left on the refined-from connection", oneToOne,
				names(instantiate("Issue3032Properties.aadl", "Top.inheriting").getAllConnectionInstances()));
		assertEquals("Connection_Pattern declared per mode", allToAll,
				names(instantiate("Issue3032Properties.aadl", "Top.modal").getAllConnectionInstances()));
		assertEquals("Connection_Set supplied by the enclosing implementation",
				List.of("producers[1].outp --> consumers[2].inp"),
				names(instantiate("Issue3032Properties.aadl", "Top.contextualSet").getAllConnectionInstances()));
	}


	/**
	 * Characterization of contained property associations on a connection that the expansion replaces.
	 * Property caching runs on the final connection instances now instead of on the provisional ones, so
	 * what the expanded connections carry must not change.
	 * <p>
	 * {@code Top.perElement} indexes the component that owns the connection. The value reaches the
	 * connection instances of that element, which the replication produced as copies. Issue #3034
	 * corrected the connection reference contexts of those copies; before that fix the value reached no
	 * connection instance at all.
	 */
	@Test
	public void containedPropertiesOnExpandedConnectionsAreUnchanged() throws Exception {
		SystemInstance uniform = instantiate("Issue3032ContainedProperties.aadl", "Top.uniform");

		assertEquals(List.of("Top_uniform_Instance.nested.producers[1].outp --> consumers[1].inp = delayed",
				"Top_uniform_Instance.nested.producers[2].outp --> consumers[2].inp = delayed"),
				cachedTimings(uniform));
		assertEquals(List.of(), diagnostics(uniform));

		SystemInstance perElement = instantiate("Issue3032ContainedProperties.aadl", "Top.perElement");

		assertEquals(
				List.of("Top_perElement_Instance.nested[1].producers[1].outp --> consumers[1].inp = <none>",
						"Top_perElement_Instance.nested[1].producers[2].outp --> consumers[2].inp = <none>",
						"Top_perElement_Instance.nested[2].producers[1].outp --> consumers[1].inp = delayed",
						"Top_perElement_Instance.nested[2].producers[2].outp --> consumers[2].inp = delayed"),
				cachedTimings(perElement));
		assertEquals(List.of(), diagnostics(perElement));
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
	 * The expansion must not leave a flow instance referring to a connection instance that it deleted.
	 */
	private void assertNoDanglingFlowConnections(SystemInstance instance) {
		for (EndToEndFlowInstance flow : collectFlows(instance, new ArrayList<>())) {
			for (InstanceObject element : flow.getFlowElements()) {
				if (element instanceof ConnectionInstance conni) {
					assertNotNull("end to end flow " + flow.getName() + " refers to connection " + conni.getName()
							+ ", which is not contained in the instance model", conni.eResource());
				}
			}
		}
	}

	private List<List<String>> flowElementNames(SystemInstance instance) {
		return collectFlows(instance, new ArrayList<>()).stream()
				.map(flow -> flow.getFlowElements().stream().map(element -> element.getName()).toList())
				.toList();
	}

	private List<EndToEndFlowInstance> collectFlows(ComponentInstance ci, List<EndToEndFlowInstance> result) {
		result.addAll(ci.getEndToEndFlows());
		ci.getComponentInstances().forEach(child -> collectFlows(child, result));
		return result;
	}

	private SystemInstance instantiate(String model, String implementationName) throws Exception {
		AadlPackage pkg = testHelper.parseFile(MODEL_DIR + model);
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

	private List<String> names(List<? extends InstanceObject> objects) {
		return objects.stream().map(object -> object.getName()).sorted().toList();
	}

	private List<String> diagnostics(SystemInstance instance) {
		return ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource())).getErrors()
				.stream()
				.map(message -> message.kind + ": " + message.message)
				.toList();
	}
}
