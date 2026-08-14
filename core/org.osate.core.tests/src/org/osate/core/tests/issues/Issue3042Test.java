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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
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
 * Regression test for issue #3042.
 *
 * <p>
 * A connection whose direction does not work out is instantiated, and connection
 * validation reports the error against the connection instance. It used to be rejected
 * while the instance model was being built, with the error attached to whichever
 * component the traversal was extending a path inside.
 * </p>
 *
 * <p>
 * The fixture is the existing {@code Issue582/TestAbstractDirection.aadl} rather than a
 * new one. Its shape is the one that reaches this check: both features are declared
 * abstract and refined to a direction by extension, so each declaration passes
 * declarative validation while the instance directions do not compose. A connection
 * that both declares and violates a direction rule, such as a port connection into an
 * outgoing port, is rejected by the declarative validator and never reaches the
 * instantiator at all.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3042Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/Issue582/TestAbstractDirection.aadl";
	private static final String CONNECTION = "srcSys.f0 -> destSys.f0";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	/** Outgoing to incoming between peers is valid, so nothing is reported. */
	@Test
	public void aValidDirectionReportsNothing() throws Exception {
		Instantiated instantiated = instantiate("Top.out_to_in");

		assertEquals(List.of(CONNECTION), connectionNames(instantiated));
		assertEquals(List.of(), errors(instantiated));
	}

	/**
	 * Crossing between peers into an outgoing feature. The connection instance exists and
	 * carries the error, which is reported once.
	 */
	@Test
	public void anInvalidDirectionIsReportedOnTheConnectionInstance() throws Exception {
		Instantiated instantiated = instantiate("Top.out_to_out");

		assertEquals(List.of(CONNECTION), connectionNames(instantiated));
		assertEquals(List.of("Error on " + CONNECTION + ": Connection has no valid direction"), errors(instantiated));
	}

	/**
	 * A connection whose source is an incoming feature produces nothing at all, and this
	 * check is not what decides that. The traversal only starts at outgoing features, so
	 * no path is ever begun; there is no connection instance to attach a diagnostic to and
	 * no diagnostic either.
	 */
	@Test
	public void aConnectionLeavingAnIncomingFeatureIsNeverStarted() throws Exception {
		Instantiated instantiated = instantiate("Top.in_to_in");

		assertEquals(List.of(), connectionNames(instantiated));
		assertEquals(List.of(), errors(instantiated));
	}

	private static List<String> connectionNames(Instantiated instantiated) {
		return instantiated.instance()
				.getAllConnectionInstances()
				.stream()
				.map(ConnectionInstance::getName)
				.sorted()
				.toList();
	}

	/** Each diagnostic with the name of the element it is attached to. */
	private static List<String> errors(Instantiated instantiated) {
		return ((QueuingAnalysisErrorReporter) instantiated.manager()
				.getReporter(instantiated.instance().eResource())).getErrors()
				.stream()
				.map(message -> message.kind + " on "
						+ (message.where instanceof ConnectionInstance connection ? connection.getName()
								: String.valueOf(message.where))
						+ ": " + message.message)
				.sorted()
				.toList();
	}

	private record Instantiated(SystemInstance instance, AnalysisErrorReporterManager manager) {
	}

	private Instantiated instantiate(String implementation) throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		var impl = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals(implementation))
				.findFirst()
				.orElseThrow();
		var manager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		return new Instantiated(InstantiateModel.instantiate(impl, manager), manager);
	}
}
