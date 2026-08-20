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
import static org.osate.core.tests.instantiation.InstanceLookup.connectionNames;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.core.tests.instantiation.InstanceCharacterization;
import org.osate.core.tests.instantiation.InstanceRoots;
import org.osate.core.tests.instantiation.InstanceRun;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes referenced classifier roots, for issue #3037.
 *
 * <p>
 * A feature whose classifier resolves to a component classifier makes instantiation create
 * that classifier as a further root beside the system instance. Every model whose ports have
 * a data classifier has one, and since the Plan 1 pipeline change those roots go through the
 * same phases as the system instance, so the characterization harness snapshots every root of
 * the instance resource rather than the system instance alone. Before that it compared
 * nothing inside a referenced root at all.
 * </p>
 *
 * <p>
 * A referenced root with connections inside it is deliberately not covered: instantiation
 * crashes on that shape, and it did before issue #3037 as well, so it is follow-on work rather
 * than something this test can hold. What is covered here is that the roots exist, that they
 * carry their subcomponents and features, and what a system whose ports are typed by such a
 * classifier produces.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037ReferencedRootTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3037/ReferencedClassifiers.aadl";

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

	/** A system whose ports are typed by a classifier with internals, compared over all roots. */
	@Test
	public void aModelWithReferencedRootsAgrees() throws Exception {
		assertConnections("Top.referenced", "feeder.worker.outp -> drain.worker.inp");
		assertConnections("Feeder.i", "worker.outp -> outp");
		assertConnections("Drain.i", "inp -> worker.inp");
	}

	/**
	 * The roots the instance resource carries beside the system instance, and the one
	 * connection the model has. Asserted so that a harness that stopped snapshotting
	 * referenced roots, or a model that stopped producing them, fails here.
	 */
	@Test
	public void theResourceCarriesTheReferencedRoots() throws Exception {
		var run = isolated.run(MODEL, "Top.referenced");

		assertEquals(List.of("feeder.worker.outp -> drain.worker.inp"), connectionNames(run.instance()));
		assertEquals(List.of("ReferencedClassifiers::Element", "ReferencedClassifiers::Payload.i"),
				referencedRootNames(run));
		assertEquals("a referenced root with connections is excluded from characterization", List.of(),
				connectionNames(referencedRoot(run)));
	}

	private void assertConnections(String implementation, String... expected) throws Exception {
		InstanceCharacterization.assertConnections(isolated, MODEL, implementation, expected);
	}

	private static List<String> referencedRootNames(InstanceRun run) {
		return InstanceRoots.referenced(run.instance()).stream().map(ComponentInstance::getName).sorted().toList();
	}

	private static ComponentInstance referencedRoot(InstanceRun run) {
		return InstanceRoots.referenced(run.instance()).get(0);
	}
}
