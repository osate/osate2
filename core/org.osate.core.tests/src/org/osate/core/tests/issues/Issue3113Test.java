/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK OR COPYRIGHT INFRINGEMENT.
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
 * conditions contained in any such Third Party Software or separate license file distributed with this program. The
 * parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries of this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
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
import org.osate.aadl2.instance.EndToEndFlowInstance;
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
 * A flow specification end reached through a feature group that is an array became a single flow
 * specification instance on the first element of that group, because the expansion decided whether an end
 * was an array element from the index of the end itself, which is zero for a feature of a feature group
 * type. The index of such an end sits on the enclosing feature group instance.
 * <p>
 * Connection instantiation expands a connection across the elements of such a group, so the connection
 * set covered every element while the flow specifications covered only the first, and the end to end
 * flows built over them inherited that. Nothing was reported for the dropped elements.
 * <p>
 * This is the case issue #2787 left out; it expanded an end that is a feature array itself.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3113Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3113/Issue3113.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	private AnalysisErrorReporterManager errorManager;

	/**
	 * Every element of the feature group array gets its own flow specification instance. {@code emit} has
	 * one array end and {@code relay} has two, which the default {@code One_To_One} pairs up by index.
	 */
	@Test
	public void flowSpecificationsAreExpandedPerFeatureGroupElement() throws Exception {
		var instance = instantiate("Top.i");

		assertEquals(List.of("a.absorb_1 : bundles[1].signal -> <none>", "a.absorb_2 : bundles[2].signal -> <none>",
				"e.emit_1 : <none> -> bundles[1].signal", "e.emit_2 : <none> -> bundles[2].signal",
				"e.relay_1 : bundles[1].ack -> bundles[1].signal",
				"e.relay_2 : bundles[2].ack -> bundles[2].signal"), flowSpecifications(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * The end to end flow over the connection between the two feature group arrays has one instance per
	 * element, each through the element of its own index. The connection instances are asserted alongside
	 * them: they always covered both elements, and the flows now agree with them.
	 */
	@Test
	public void endToEndFlowIsBuiltPerFeatureGroupElement() throws Exception {
		var instance = instantiate("Top.i");

		assertEquals(List.of("a.bundles[1].ack --> e.bundles[1].ack", "a.bundles[2].ack --> e.bundles[2].ack",
				"e.bundles[1].signal --> a.bundles[1].signal", "e.bundles[2].signal --> a.bundles[2].signal"),
				names(instance.getAllConnectionInstances()));
		assertEquals(List.of(
				"ete_1 : e.emit_1 -> e.bundles[1].signal --> a.bundles[1].signal -> a.absorb_1",
				"ete_2 : e.emit_2 -> e.bundles[2].signal --> a.bundles[2].signal -> a.absorb_2"), flows(instance));
		assertEquals(List.of(), diagnostics(instance));
	}

	/**
	 * The flow specification instances of a model, as {@code path : source -> destination} relative to the
	 * system instance, sorted. The name carries the pairing and the two ends carry the array elements.
	 */
	private List<String> flowSpecifications(SystemInstance instance) {
		return collect(instance, ComponentInstance::getFlowSpecifications, new ArrayList<>()).stream()
				.map(fsi -> relative(instance, fsi) + " : " + end(fsi.getSource()) + " -> "
						+ end(fsi.getDestination()))
				.sorted()
				.toList();
	}

	/** The end to end flow instances of a model, as {@code name : element -> element -> ...}, sorted. */
	private List<String> flows(SystemInstance instance) {
		return collect(instance, ComponentInstance::getEndToEndFlows, new ArrayList<>()).stream()
				.map(flow -> flow.getName() + " : " + String.join(" -> ",
						flow.getFlowElements().stream().map(element -> relative(instance, element)).toList()))
				.sorted()
				.toList();
	}

	/** A flow specification end, relative to the component instance whose flow specification it is. */
	private static String end(FeatureInstance fi) {
		if (fi == null) {
			return "<none>";
		}
		var prefix = fi.getContainingComponentInstance().getInstanceObjectPath() + ".";
		var path = fi.getInstanceObjectPath();
		return path.startsWith(prefix) ? path.substring(prefix.length()) : path;
	}

	/**
	 * The path of an instance object relative to the system instance, so which array element it belongs to
	 * is part of what is asserted.
	 */
	private static String relative(SystemInstance instance, InstanceObject object) {
		var prefix = instance.getInstanceObjectPath() + ".";
		var path = object.getInstanceObjectPath();
		return path.startsWith(prefix) ? path.substring(prefix.length()) : path;
	}

	private static <T> List<T> collect(ComponentInstance ci, Function<ComponentInstance, List<T>> reader,
			List<T> result) {
		result.addAll(reader.apply(ci));
		ci.getComponentInstances().forEach(child -> collect(child, reader, result));
		return result;
	}

	private SystemInstance instantiate(String implementationName) throws Exception {
		var pkg = testHelper.parseFile(MODEL);
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

	private static List<String> names(List<? extends InstanceObject> objects) {
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
