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
import org.osate.aadl2.instantiation.testing.CharacterizationRun;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.core.tests.instantiation.StrategyDifference;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Compares the two traversal strategies over the five kinds of access connection and the
 * four component categories that end a semantic connection, for issue #3037.
 *
 * <p>
 * The corpus exercises access connections only in combination with feature groups, short
 * access, or an invalid model, so these are the plain cases: one shared component, one
 * access feature, and legs that descend to reach them. An access connection is also the
 * only shape whose endpoint is a component rather than a feature, which is where a leg
 * stops because there is nothing left to continue from and where expansion has no member to
 * pair against.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037AccessAndEndingTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3037/AccessAndEndings.aadl";

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

	/** Shared data, reached from an access feature two containment levels down. */
	@Test
	public void dataAccessAgrees() throws Exception {
		assertSameModel("DataHolder.i");
		assertSameModel("Top.sharedData");

		assertEquals(List.of("shared -> holder.user.store"), connectionNames("Top.sharedData"));
	}

	/** Shared bus, reached by a device, which does not end a connection at an access feature. */
	@Test
	public void busAccessAgrees() throws Exception {
		assertSameModel("BusHolder.i");
		assertSameModel("Top.sharedBus");

		assertEquals(List.of("backbone -> holder.user.net"), connectionNames("Top.sharedBus"));
	}

	/** Shared virtual bus, reached by a processor. */
	@Test
	public void virtualBusAccessAgrees() throws Exception {
		assertSameModel("VirtualBusHolder.i");
		assertSameModel("Top.sharedVirtualBus");

		assertEquals(List.of("transport -> holder.user.channel"), connectionNames("Top.sharedVirtualBus"));
	}

	/**
	 * A shared subprogram, with a leg descending on each side of the pivot. The source leg
	 * reaches through a thread to the subprogram inside it, which is the case that
	 * distinguishes ending a connection at a port from ending it at an access feature.
	 */
	@Test
	public void subprogramAccessAgrees() throws Exception {
		assertSameModel("ServiceProvider.i");
		assertSameModel("ProviderHolder.i");
		assertSameModel("ClientHolder.i");
		assertSameModel("Top.sharedSubprogram");

		assertEquals(List.of("provider.provider.body -> consumer.client.call"),
				connectionNames("Top.sharedSubprogram"));
	}

	/** Shared subprogram group. */
	@Test
	public void subprogramGroupAccessAgrees() throws Exception {
		assertSameModel("GroupHolder.i");
		assertSameModel("Top.sharedSubprogramGroup");

		assertEquals(List.of("library -> holder.user.lib"), connectionNames("Top.sharedSubprogramGroup"));
	}

	/**
	 * A port connection into a thread, a device, a processor, and a virtual processor, each of
	 * which carries the port onwards to a subcomponent inside.
	 *
	 * <p>
	 * The connection from outside ends at the category's own port, one instance per
	 * destination. The inner connection produces none at all: a path that leaves a port and
	 * arrives at something the component itself contains is refused, the rule issue #2032
	 * added to stop a connection from an abstract subcomponent's port to a port of its
	 * containing thread. Both strategies apply it, so all four inner connections are absent
	 * from both models, which is why this fixture is a characterization of that rule rather
	 * than only of where a leg stops.
	 * </p>
	 *
	 * <p>
	 * The same thread instantiated on its own does create that connection, because the rule
	 * applies to components the traversal descends into and not to the root: a thread
	 * implementation instantiated alone is the whole model, and its internals are still
	 * reached. Both strategies agree on that too.
	 * </p>
	 */
	@Test
	public void connectionEndingCategoriesAgree() throws Exception {
		assertSameModel("EndingThread.i");
		assertSameModel("ThreadHost.i");
		assertSameModel("EndingDevice.i");
		assertSameModel("EndingProcessor.i");
		assertSameModel("EndingVirtualProcessor.i");
		assertSameModel("Top.endings");

		assertEquals(List.of("feeder.outp -> cpu.inp", "feeder.outp -> dev.inp", "feeder.outp -> host.th.inp",
				"feeder.outp -> vcpu.inp"), connectionNames("Top.endings"));
		assertEquals("the rule applies to a component descended into, not to the root",
				List.of("inp -> inner.inp"), connectionNames("EndingThread.i"));
	}

	private void assertSameModel(String implementation) throws Exception {
		StrategyDifference.assertSameModel(isolated, MODEL, implementation);
	}

	/** The across-first connection instance names, sorted, so a count cannot pass vacuously. */
	private List<String> connectionNames(String implementation) throws Exception {
		CharacterizationRun run = isolated.run(MODEL, implementation, "ACROSS_FIRST", false);
		return run.instance()
				.getAllConnectionInstances()
				.stream()
				.map(connection -> connection.getName())
				.sorted()
				.toList();
	}
}
