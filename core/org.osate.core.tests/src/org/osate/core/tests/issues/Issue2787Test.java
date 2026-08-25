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
import java.util.function.Function;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
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
 * A flow specification whose ends are feature arrays used to become a single flow specification instance
 * between the first element of each end, because the endpoint lookup returned the first feature instance
 * of the array. {@code Connection_Pattern} and {@code Connection_Set} apply to a flow specification, and
 * were never read there, so there was no way to say which source element flows to which destination
 * element either.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2787Test extends XtextTest {
	private static final String MODEL_DIR = "org.osate.core.tests/models/issue2787/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	private AnalysisErrorReporterManager errorManager;

	/**
	 * The model of issue #1833. Both flow specification ends are feature arrays of the same size, so the
	 * default {@code One_To_One} pairing gives each element its own flow specification instance.
	 */
	@Test
	public void flowSpecificationsAreExpandedPerElement() throws Exception {
		var instance = instantiate("Issue2787.aadl", "Top.i");

		assertEquals(List.of("Top_i_Instance.actuator.fsnk_1 : inp[1] -> <none>",
				"Top_i_Instance.actuator.fsnk_2 : inp[2] -> <none>",
				"Top_i_Instance.sensor.fsrc_1 : <none> -> outp[1]",
				"Top_i_Instance.sensor.fsrc_2 : <none> -> outp[2]"), flowSpecifications(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * The connection between the two feature arrays is expanded per element, and so is the end to end flow
	 * over it: one flow instance per element, each built from the flow specification instances of that
	 * element.
	 */
	@Test
	public void endToEndFlowIsBuiltPerElement() throws Exception {
		var instance = instantiate("Issue2787.aadl", "Top.i");

		assertEquals(List.of("sensor.outp[1] --> actuator.inp[1]", "sensor.outp[2] --> actuator.inp[2]"),
				names(instance.getAllConnectionInstances()));
		assertEquals(List.of("etef_1 : fsrc_1 -> sensor.outp[1] --> actuator.inp[1] -> fsnk_1",
				"etef_2 : fsrc_2 -> sensor.outp[2] --> actuator.inp[2] -> fsnk_2"), flows(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * The flow specification of the relay is realized by a flow implementation. The element a flow
	 * specification instance is for pins the element the implementation runs through, so the flow instances
	 * stay on one element from the sensor to the actuator.
	 */
	@Test
	public void flowImplementationStaysOnTheArrayElement() throws Exception {
		var instance = instantiate("Issue2787.aadl", "Top.viaImplementation");

		assertEquals(List.of("relay.worker.outp[1] --> actuator.inp[1]", "relay.worker.outp[2] --> actuator.inp[2]",
				"sensor.outp[1] --> relay.worker.inp[1]", "sensor.outp[2] --> relay.worker.inp[2]"),
				names(instance.getAllConnectionInstances()));
		assertEquals(List.of(
				"etef_1 : fsrc_1 -> sensor.outp[1] --> relay.worker.inp[1] -> wpath_1"
						+ " -> relay.worker.outp[1] --> actuator.inp[1] -> fsnk_1",
				"etef_2 : fsrc_2 -> sensor.outp[2] --> relay.worker.inp[2] -> wpath_2"
						+ " -> relay.worker.outp[2] --> actuator.inp[2] -> fsnk_2"),
				flows(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * Every pairing a flow specification over feature arrays can be given. The pairings, their order, and
	 * the reports are the ones the same property values produce on a connection, because the pairing is the
	 * same arithmetic.
	 */
	@Test
	public void patternsPairUpTheElements() throws Exception {
		var instance = instantiate("Issue2787Patterns.aadl", "Top.i");

		assertEquals(List.of("Top_i_Instance.boundary.absorb_1 : inp[1] -> <none>",
				"Top_i_Instance.boundary.absorb_2 : inp[2] -> <none>",
				"Top_i_Instance.boundary.emit_1 : <none> -> outp[1]",
				"Top_i_Instance.boundary.emit_2 : <none> -> outp[2]",
				"Top_i_Instance.boundary.emit_3 : <none> -> outp[3]",
				"Top_i_Instance.merger.merge_1 : inp[1] -> outp", "Top_i_Instance.merger.merge_2 : inp[2] -> outp",
				"Top_i_Instance.shifter.bidirectional_1 : inp[1] -> outp[2]",
				"Top_i_Instance.shifter.bidirectional_2 : inp[2] -> outp[3]",
				"Top_i_Instance.shifter.bidirectional_3 : inp[2] -> outp[1]",
				"Top_i_Instance.shifter.bidirectional_4 : inp[3] -> outp[2]",
				"Top_i_Instance.shifter.combined_1 : inp[2] -> outp[2]",
				"Top_i_Instance.shifter.combined_2 : inp[1] -> outp[1]",
				"Top_i_Instance.shifter.selected_1 : inp[1] -> outp[3]",
				"Top_i_Instance.shifter.selected_2 : inp[3] -> outp[1]",
				"Top_i_Instance.shifter.shifted_1 : inp[1] -> outp[2]",
				"Top_i_Instance.shifter.shifted_2 : inp[2] -> outp[3]",
				"Top_i_Instance.shifter.straight_1 : inp[1] -> outp[1]",
				"Top_i_Instance.shifter.straight_2 : inp[2] -> outp[2]",
				"Top_i_Instance.shifter.straight_3 : inp[3] -> outp[3]",
				"Top_i_Instance.splitter.split_1 : inp -> outp[1]",
				"Top_i_Instance.splitter.split_2 : inp -> outp[2]"), flowSpecifications(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * A pairing that cannot be produced leaves the flow specification instance in place, so the flow
	 * specification is still there to be referred to, and is reported the way the connection expansion
	 * reports the same situation.
	 */
	@Test
	public void unpairableFlowSpecificationsAreReported() throws Exception {
		var instance = instantiate("Issue2787Failures.aadl", "Top.i");

		assertEquals(List.of("Top_i_Instance.mismatch.wrongSizes : inp[1] -> outp[1]",
				"Top_i_Instance.plain.notAnArray : inp -> outp",
				"Top_i_Instance.underspecified.tooFewIndices : inp[1] -> outp"), flowSpecifications(instance));
		assertEquals(List.of(
				"Error: Array size mismatch (One_to_One) on flow specification wrongSizes"
						+ " in Top_i_Instance.mismatch: 4 at source and 3 at destination.",
				"Warning: Connection pattern specified for flow specification that does not connect array elements.",
				"Error: Too few indices for flow specification destination for tooFewIndices"), diagnostics(instance));
	}

	/**
	 * The flow specification instances of a model, as {@code path : source -> destination}, sorted. The
	 * name of the instance carries the pairing, and its two ends carry the array elements it pairs up.
	 */
	private List<String> flowSpecifications(SystemInstance instance) {
		return collect(instance, ComponentInstance::getFlowSpecifications, new ArrayList<>()).stream()
				.map(fsi -> fsi.getInstanceObjectPath() + " : " + end(fsi.getSource()) + " -> "
						+ end(fsi.getDestination()))
				.sorted()
				.toList();
	}

	private static String end(FeatureInstance fi) {
		return fi == null ? "<none>" : fi.getFullName();
	}

	/**
	 * The end to end flow instances of a model, as {@code name : element -> element -> ...}, sorted.
	 */
	private List<String> flows(SystemInstance instance) {
		return collect(instance, ComponentInstance::getEndToEndFlows, new ArrayList<>()).stream()
				.map(flow -> flow.getName() + " : " + String.join(" -> ",
						flow.getFlowElements().stream().map(InstanceObject::getName).toList()))
				.sorted()
				.toList();
	}

	private <T extends InstanceObject> List<T> collect(ComponentInstance ci,
			Function<ComponentInstance, List<T>> of, List<T> result) {
		result.addAll(of.apply(ci));
		ci.getComponentInstances().forEach(child -> collect(child, of, result));
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
