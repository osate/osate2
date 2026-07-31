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
package org.osate.analysis.flows.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.analysis.flows.FlowLatencyAnalysis;
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch;
import org.osate.analysis.flows.model.LatencyCSVReport;
import org.osate.result.ResultType;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class NoFlowLatencyReportTest {

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Test
	public void noFlowIsAnErrorAndRemovesStaleCsv() throws Exception {
		var pkg = testHelper.parseString("""
				package no_flow
				public
					system s
					end s;
					system implementation s.i
					end s.i;
				end no_flow;
				""");
		var implementation = pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(ComponentImplementation.class::isInstance)
				.map(ComponentImplementation.class::cast)
				.findFirst()
				.orElseThrow();
		var instance = InstantiateModel.instantiate(implementation);
		var instancePath = temporaryFolder.getRoot().toPath().resolve("no_flow.aaxl2");
		instance.eResource().setURI(URI.createFileURI(instancePath.toString()));

		var result = new FlowLatencyAnalysisSwitch(instance).invoke(instance, null, true, true, true, true, false);
		assertEquals(ResultType.ERROR, result.getResultType());
		assertEquals("No end-to-end flow instances were found", result.getMessage());
		assertTrue(result.getResults().stream().anyMatch(r -> r.getResultType() == ResultType.ERROR));

		Files.createDirectories(temporaryFolder.getRoot().toPath().resolve("reports").resolve("latency"));
		FlowLatencyAnalysis.saveAnalysisResult(result);
		Path resultPath = Path.of(java.net.URI.create(result.eResource().getURI().toString()));
		Path csvPath = resultPath.resolveSibling(resultPath.getFileName().toString().replaceFirst("\\.result$", ".csv"));
		Files.createDirectories(csvPath.getParent());
		Files.writeString(csvPath, "stale bogus latency data");

		LatencyCSVReport.generateCSVReport(result);
		assertFalse("no-flow analysis must remove a stale CSV", Files.exists(csvPath));
		assertTrue(Files.isRegularFile(resultPath));
	}
}
