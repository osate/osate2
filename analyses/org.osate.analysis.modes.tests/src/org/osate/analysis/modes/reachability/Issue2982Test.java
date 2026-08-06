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
package org.osate.analysis.modes.reachability;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.result.ResultType;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@ExtendWith(InjectionExtension.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2982Test extends XtextTest {

	private static final String PATH = "org.osate.analysis.modes.tests/models/issue2982/Issue2982.aadl";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Inject
	ValidationTestHelper validationHelper;

	@Test
	public void canceledBeforeAnalysisReturnsTbd() throws Exception {
		var monitor = new CancellingProgressMonitor(1);
		var result = new ReachabilityAnalyzer(instantiate("S.i")).analyzeModel(monitor);

		assertAll(() -> assertEquals(ResultType.TBD, result.getResultType()),
				() -> assertEquals("Analysis was cancelled", result.getMessage()), () -> assertTrue(monitor.done));
	}

	@Test
	public void canceledDuringGraphConstructionStopsAnalysis() throws Exception {
		var monitor = new CancellingProgressMonitor(3);
		var result = new ReachabilityAnalyzer(instantiate("Nested.i")).analyzeModel(monitor);

		assertAll(() -> assertEquals(ResultType.TBD, result.getResultType()),
				() -> assertEquals("Analysis was cancelled", result.getMessage()),
				() -> assertTrue(result.getDiagnostics().isEmpty()), () -> assertEquals(3, monitor.cancellationChecks),
				() -> assertTrue(monitor.done));
	}

	private SystemInstance instantiate(String name) throws Exception {
		var pkg = testHelper.parseFile(PATH);
		validationHelper.assertNoIssues(pkg);
		var implementation = pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(ComponentImplementation.class::isInstance)
				.map(ComponentImplementation.class::cast)
				.filter(ci -> ci.getName().equals(name))
				.findFirst()
				.orElseThrow();
		return InstantiateModel.instantiate(implementation);
	}

	private static final class CancellingProgressMonitor implements IProgressMonitor {
		private final int cancelOnCheck;
		private int cancellationChecks;
		private boolean canceled;
		private boolean done;

		private CancellingProgressMonitor(int cancelOnCheck) {
			this.cancelOnCheck = cancelOnCheck;
		}

		@Override
		public void beginTask(String name, int totalWork) {
		}

		@Override
		public void done() {
			done = true;
		}

		@Override
		public void internalWorked(double work) {
		}

		@Override
		public boolean isCanceled() {
			return canceled || ++cancellationChecks >= cancelOnCheck;
		}

		@Override
		public void setCanceled(boolean value) {
			canceled = value;
		}

		@Override
		public void setTaskName(String name) {
		}

		@Override
		public void subTask(String name) {
		}

		@Override
		public void worked(int work) {
		}
	}
}
