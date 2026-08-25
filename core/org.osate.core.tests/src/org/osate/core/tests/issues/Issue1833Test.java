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
import org.osate.aadl2.instance.ComponentInstance;
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
 * A flow segment that names a subcomponent array was resolved with findSubcomponentInstance, which
 * returns the first element of the array, so an end to end flow over such an array became a single flow
 * instance through element 1 no matter how many connection instances the array connection stood for.
 * <p>
 * This is Aaron Greenhouse's second example in the issue. The first one, where the multiplicity comes
 * from feature arrays rather than subcomponent arrays, is issue #2787.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1833Test extends XtextTest {
	private static final String MODEL_DIR = "org.osate.core.tests/models/issue1833/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	private AnalysisErrorReporterManager errorManager;

	/**
	 * The model of the issue. The connection between the two arrays is expanded per element, so the flow
	 * over it has one instance per element, each through the array element of its own index.
	 */
	@Test
	public void endToEndFlowIsBuiltPerArrayElement() throws Exception {
		var instance = instantiate("Issue1833.aadl", "Top.i");

		assertEquals(List.of("emitters[1].outp --> receivers[1].inp", "emitters[2].outp --> receivers[2].inp"),
				names(instance.getAllConnectionInstances()));
		assertEquals(List.of(
				"etef_1 : emitters[1].fsrc -> emitters[1].outp --> receivers[1].inp -> receivers[1].fsnk",
				"etef_2 : emitters[2].fsrc -> emitters[2].outp --> receivers[2].inp -> receivers[2].fsnk"),
				flows(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * Writing out the One_To_One pattern the issue's example used changes nothing, since it is the default.
	 */
	@Test
	public void anExplicitOneToOnePatternIsTheSame() throws Exception {
		var instance = instantiate("Issue1833.aadl", "Top.patterned");

		assertEquals(List.of(
				"etef_1 : emitters[1].fsrc -> emitters[1].outp --> receivers[1].inp -> receivers[1].fsnk",
				"etef_2 : emitters[2].fsrc -> emitters[2].outp --> receivers[2].inp -> receivers[2].fsnk"),
				flows(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * A pattern that crosses the indices. Each flow still exists, but it ends in the other element of the
	 * receiver array, which is reachable only if the segment resolves to every element.
	 */
	@Test
	public void aCrossingPatternKeepsBothFlows() throws Exception {
		var instance = instantiate("Issue1833.aadl", "Top.crossed");

		assertEquals(List.of("emitters[1].outp --> receivers[2].inp", "emitters[2].outp --> receivers[1].inp"),
				names(instance.getAllConnectionInstances()));
		assertEquals(List.of(
				"etef_1 : emitters[1].fsrc -> emitters[1].outp --> receivers[2].inp -> receivers[2].fsnk",
				"etef_2 : emitters[2].fsrc -> emitters[2].outp --> receivers[1].inp -> receivers[1].fsnk"),
				flows(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * All_To_All connects every emitter to every receiver, so there is a flow per pair. Which flow gets
	 * which number depends on the order the branches were forked in, so the numbers and the paths are
	 * asserted separately.
	 */
	@Test
	public void everyPairOfElementsGetsAFlow() throws Exception {
		var instance = instantiate("Issue1833.aadl", "Top.broadcast");

		assertEquals(List.of("etef_1", "etef_2", "etef_3", "etef_4"), names(flowInstances(instance)));
		assertEquals(List.of("emitters[1].fsrc -> emitters[1].outp --> receivers[1].inp -> receivers[1].fsnk",
				"emitters[1].fsrc -> emitters[1].outp --> receivers[2].inp -> receivers[2].fsnk",
				"emitters[2].fsrc -> emitters[2].outp --> receivers[1].inp -> receivers[1].fsnk",
				"emitters[2].fsrc -> emitters[2].outp --> receivers[2].inp -> receivers[2].fsnk"),
				flowPaths(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * Only the source is an array, so All_To_One applies and both emitters have a flow into the one
	 * receiver.
	 */
	@Test
	public void bothElementsFlowIntoOneReceiver() throws Exception {
		var instance = instantiate("Issue1833.aadl", "Top.fanIn");

		assertEquals(List.of("etef_1 : emitters[1].fsrc -> emitters[1].outp --> receiver.inp -> receiver.fsnk",
				"etef_2 : emitters[2].fsrc -> emitters[2].outp --> receiver.inp -> receiver.fsnk"), flows(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * A nested end to end flow that is replicated per array element replicates the flow that contains it,
	 * and each replica of the container refers to the nested replica of its own element. Here the nested
	 * flow ends the container, so the container reaches it along a connection.
	 */
	@Test
	public void aReplicatedNestedFlowReplicatesItsContainer() throws Exception {
		var instance = instantiate("Issue1833.aadl", "Top.nested");

		assertEquals(List.of(
				"inner_1 : relays[1].fpath -> relays[1].outp --> receivers[1].inp -> receivers[1].fsnk",
				"inner_2 : relays[2].fpath -> relays[2].outp --> receivers[2].inp -> receivers[2].fsnk",
				"outer_1 : emitters[1].fsrc -> emitters[1].outp --> relays[1].inp -> inner_1",
				"outer_2 : emitters[2].fsrc -> emitters[2].outp --> relays[2].inp -> inner_2"), flows(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * The nested flow starts the container. Nothing constrains which replica a replica of the container
	 * takes, so the fork is over the nested replicas themselves, and the container continues after the one
	 * it took.
	 */
	@Test
	public void aReplicatedNestedFlowCanStartItsContainer() throws Exception {
		var instance = instantiate("Issue1833.aadl", "Top.nestedAtStart");

		assertEquals(List.of("inner_1 : emitters[1].fsrc -> emitters[1].outp --> relays[1].inp -> relays[1].fpath",
				"inner_2 : emitters[2].fsrc -> emitters[2].outp --> relays[2].inp -> relays[2].fpath",
				"outer_1 : inner_1 -> relays[1].outp --> receivers[1].inp -> receivers[1].fsnk",
				"outer_2 : inner_2 -> relays[2].outp --> receivers[2].inp -> receivers[2].fsnk"), flows(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * The nested flow sits in the middle of the container, which therefore both reaches it along a
	 * connection and continues after it along another.
	 */
	@Test
	public void aReplicatedNestedFlowCanSitInTheMiddle() throws Exception {
		var instance = instantiate("Issue1833.aadl", "Top.nestedInMiddle");

		assertEquals(List.of(
				"inner_1 : firstRelays[1].fpath -> firstRelays[1].outp --> secondRelays[1].inp"
						+ " -> secondRelays[1].fpath",
				"inner_2 : firstRelays[2].fpath -> firstRelays[2].outp --> secondRelays[2].inp"
						+ " -> secondRelays[2].fpath",
				"outer_1 : emitters[1].fsrc -> emitters[1].outp --> firstRelays[1].inp -> inner_1"
						+ " -> secondRelays[1].outp --> receivers[1].inp -> receivers[1].fsnk",
				"outer_2 : emitters[2].fsrc -> emitters[2].outp --> firstRelays[2].inp -> inner_2"
						+ " -> secondRelays[2].outp --> receivers[2].inp -> receivers[2].fsnk"), flows(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * The nested flow starts at a flow specification that is realized by a flow implementation, so it
	 * carries a leading declarative connection. The connection instance by which a replica of the container
	 * reaches a nested replica has to contain that connection, which is what keeps the two on the same
	 * element.
	 */
	@Test
	public void aReplicatedNestedFlowCanStartInsideAnImplementation() throws Exception {
		var instance = instantiate("Issue1833.aadl", "Top.nestedThroughImplementation");

		assertEquals(List.of(
				"inner_1 : boxes[1].relay.fpath -> boxes[1].relay.outp --> receivers[1].inp -> receivers[1].fsnk",
				"inner_2 : boxes[2].relay.fpath -> boxes[2].relay.outp --> receivers[2].inp -> receivers[2].fsnk",
				"outer_1 : emitters[1].fsrc -> emitters[1].outp --> boxes[1].relay.inp -> inner_1",
				"outer_2 : emitters[2].fsrc -> emitters[2].outp --> boxes[2].relay.inp -> inner_2"), flows(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * The end to end flow instances of a model, as {@code name : element -> element -> ...}, sorted. An
	 * element is named by its path relative to the system instance, so which array element a flow goes
	 * through is part of what is asserted.
	 */
	private List<String> flows(SystemInstance instance) {
		return flowInstances(instance).stream().map(flow -> flow.getName() + " : " + path(instance, flow)).sorted()
				.toList();
	}

	/** The paths of the end to end flow instances of a model, without their names, sorted. */
	private List<String> flowPaths(SystemInstance instance) {
		return flowInstances(instance).stream().map(flow -> path(instance, flow)).sorted().toList();
	}

	private String path(SystemInstance instance, EndToEndFlowInstance flow) {
		return String.join(" -> ",
				flow.getFlowElements().stream().map(element -> relative(instance, element)).toList());
	}

	/**
	 * The path of an instance object relative to the system instance. A nested flow instance is named
	 * rather than expanded, so the containment of one flow in another stays visible.
	 */
	private String relative(SystemInstance instance, InstanceObject element) {
		if (element instanceof EndToEndFlowInstance nested) {
			return nested.getName();
		}
		var prefix = instance.getInstanceObjectPath() + ".";
		var elementPath = element.getInstanceObjectPath();
		return elementPath.startsWith(prefix) ? elementPath.substring(prefix.length()) : elementPath;
	}

	private List<EndToEndFlowInstance> flowInstances(ComponentInstance ci) {
		return collectFlows(ci, new ArrayList<>());
	}

	private List<EndToEndFlowInstance> collectFlows(ComponentInstance ci, List<EndToEndFlowInstance> result) {
		result.addAll(ci.getEndToEndFlows());
		ci.getComponentInstances().forEach(child -> collectFlows(child, result));
		return result;
	}

	private SystemInstance instantiate(String model, String implementationName) throws Exception {
		var pkg = testHelper.parseFile(MODEL_DIR + model);
		validationHelper.assertNoIssues(pkg);
		var implementation = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals(implementationName))
				.findFirst()
				.orElseThrow();
		errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);

		var instance = InstantiateModel.instantiate(implementation, errorManager);

		assertNotNull(instance);
		return instance;
	}

	private List<String> names(List<? extends InstanceObject> objects) {
		return objects.stream().map(InstanceObject::getName).sorted().toList();
	}

	private List<String> diagnostics(SystemInstance instance) {
		return ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource())).getErrors()
				.stream()
				.map(message -> message.kind + ": " + message.message)
				.sorted()
				.toList();
	}
}
