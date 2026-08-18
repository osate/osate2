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

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.core.tests.instantiation.InstanceCharacterization;
import org.osate.core.tests.instantiation.InstanceRun;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Compares the two traversal strategies over connections that reach the parameters of a
 * subprogram call, for issue #3037.
 *
 * <p>
 * The corpus has subprogram calls only in a thread instantiated as the root, and source-first
 * refuses a parameter destination whenever the declaration sits in the root, so nothing said
 * what happens when the call is below it. Both placements are compared here.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037ParameterCallTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3037/ParameterCalls.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private IsolatedInstantiation isolated;

	@Test
	public void theFixtureIsValid() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(MODEL));
	}

	/**
	 * The thread with the call instantiated on its own. Neither strategy creates a connection
	 * instance for any of its three parameter connections, and the reason is upstream of both:
	 * a subprogram call is not instantiated, so {@code step.arg} and {@code step.result} have
	 * no instance object for a connection instance to end at. Only the subprogram subcomponent
	 * the call refers to and the data subcomponent become instances.
	 */
	@Test
	public void aCallInTheRootAgrees() throws Exception {
		assertConnections("Caller.i");

		assertEquals("the call itself contributes no instance object",
				List.of("Caller_i_Instance", "Caller_i_Instance.body", "Caller_i_Instance.store"),
				componentPaths("Caller.i"));
	}

	/**
	 * The same thread two containment levels below the root, which is where source-first's rule
	 * against a parameter destination in the instantiation root does not apply. It makes no
	 * difference: the only connection instances are the two that end at the thread's own ports,
	 * because the call still has no instance object. That settles the open question of whether
	 * across-first was missing connections by not seeding subprogram calls; there are none to
	 * miss at this baseline.
	 */
	@Test
	public void aCallBelowTheRootAgrees() throws Exception {
		assertConnections("Host.i", "inp -> worker.inp", "worker.outp -> outp");
		assertConnections("Top.withCall", "feeder.outp -> host.worker.inp", "host.worker.outp -> collector.inp");

	}

	private void assertConnections(String implementation, String... expected) throws Exception {
		InstanceCharacterization.assertConnections(isolated, MODEL, implementation, expected);
	}

	/** The across-first connection instance names, sorted, so a count cannot pass vacuously. */
	private List<String> connectionNames(String implementation) throws Exception {
		InstanceRun run = isolated.run(MODEL, implementation);
		return roots(run).stream()
				.flatMap(root -> root.getAllConnectionInstances().stream())
				.map(ConnectionInstance::getName)
				.sorted()
				.toList();
	}

	/** The component instances of a run, so that a vacuous fixture cannot pass. */
	private List<String> componentPaths(String implementation) throws Exception {
		InstanceRun run = isolated.run(MODEL, implementation);
		return run.instance()
				.getAllComponentInstances()
				.stream()
				.map(ComponentInstance::getInstanceObjectPath)
				.sorted()
				.toList();
	}

	/** Every root of the instance resource, since a data classifier gets one of its own. */
	private static List<ComponentInstance> roots(InstanceRun run) {
		return run.instance()
				.eResource()
				.getContents()
				.stream()
				.filter(ComponentInstance.class::isInstance)
				.map(ComponentInstance.class::cast)
				.toList();
	}
}
