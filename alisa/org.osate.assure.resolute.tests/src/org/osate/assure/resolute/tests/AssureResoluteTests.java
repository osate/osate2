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

package org.osate.assure.resolute.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.osate.assure.util.AssureUtilExtension.constructMessage;
import static org.osate.assure.util.AssureUtilExtension.recomputeAllCounts;
import static org.osate.assure.util.AssureUtilExtension.resetToTBD;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.alisa.workbench.alisa.AssuranceCase;
import org.osate.assure.evaluator.AssureProcessor;
import org.osate.assure.tests.AssureTests;
import org.osate.resolute.ResoluteUtil;
import org.osate.verify.verify.Verification;
import org.osate.verify.verify.VerificationMethodRegistry;

import com.google.inject.Inject;

/**
 * Checks Resolute method registration, annex definitions, and assurance-case evaluation.
 */
@RunWith(XtextRunner.class)
@InjectWith(FullAlisaInjectorProvider.class)
public class AssureResoluteTests extends AssureTests {

	@Inject
	protected ValidationTestHelper validationTestHelper;

	@Test
	@Override
	public void ResoluteRegistrytest() {
		var assuranceCase = (AssuranceCase) primaryroot;
		var resourceSet = assuranceCase.eResource().getResourceSet();
		var resource = resourceSet.getResource(URI.createURI(alisaprefix + "Resolute.methodregistry"), true);
		var verification = (Verification) resource.getContents().getFirst();
		var registry = (VerificationMethodRegistry) verification.getContents().getFirst();
		assertEquals("Resolute", registry.getName());
		assertEquals(13, registry.getMethods().size());
		validationTestHelper.assertNoIssues(registry);
	}

	// , resoluteprefix+"BasicResolute.aadl", resoluteprefix+"BudgetResolute.aadl"
	@Test
	public void BasicResolutetest() {
		var assuranceCase = (AssuranceCase) primaryroot;
		var resourceSet = assuranceCase.eResource().getResourceSet();
		var resource = resourceSet.getResource(URI.createURI(resoluteprefix + "BasicResolute.aadl"), true);
		var aadlPackage = (AadlPackage) resource.getContents().getFirst();
		assertTrue(ResoluteUtil.isResoluteInstalled());
		assertEquals("BasicResolute", aadlPackage.getName());
		var annexLibraries = aadlPackage.getPublicSection().getOwnedAnnexLibraries();
		assertEquals(1, annexLibraries.size());
		var annexLibrary = (DefaultAnnexLibrary) annexLibraries.getFirst();
		assertEquals(5, ResoluteUtil.getResolute().getDefinitions(annexLibrary.getParsedAnnexLibrary()).size());
		validationTestHelper.assertNoIssues(aadlPackage);
	}

	@Test
	public void BudgetResolutetest() {
		var assuranceCase = (AssuranceCase) primaryroot;
		var resourceSet = assuranceCase.eResource().getResourceSet();
		var resource = resourceSet.getResource(URI.createURI(resoluteprefix + "BudgetResolute.aadl"), true);
		var aadlPackage = (AadlPackage) resource.getContents().getFirst();
		assertTrue(ResoluteUtil.isResoluteInstalled());
		assertEquals("BudgetResolute", aadlPackage.getName());
		var annexLibraries = aadlPackage.getPublicSection().getOwnedAnnexLibraries();
		assertEquals(1, annexLibraries.size());
		var annexLibrary = (DefaultAnnexLibrary) annexLibraries.getFirst();
		assertEquals(22, ResoluteUtil.getResolute().getDefinitions(annexLibrary.getParsedAnnexLibrary()).size());
		validationTestHelper.assertNoIssues(aadlPackage);
	}

	@Test
	@Override
	public void SCSAssuranceInstancetest() {
		var assuranceCase = (AssuranceCase) primaryroot;
		// null pointer exception in Global reference finder for ReqSpec
		// Resource set is null
		// when running as OSATE resource descriptions is a DirtyStateAware...
		var assuranceCaseResult = assureConstructor.generateFullAssuranceCase(assuranceCase);
		resetToTBD(assuranceCaseResult, null);
		recomputeAllCounts(assuranceCaseResult, null);
		var counts = assuranceCaseResult.getMetrics();
		assertEquals(37, counts.getTbdCount());
		var processor = new AssureProcessor();
		processor.processCase(assuranceCaseResult, null, new NullProgressMonitor(), false);
		assertEquals(0, counts.getTbdCount());
		assertEquals(16, counts.getSuccessCount());
		assertEquals(21, counts.getFailCount());
		assertEquals(0, counts.getErrorCount());

		var modelResults = assuranceCaseResult.getModelResult();
		var modelResult = modelResults.isEmpty() ? null : modelResults.getFirst();
		var latencyClaim = modelResult.getClaimResult().get(2);
		assertEquals(constructMessage(latencyClaim),
				"sensortoactuatorresponse with Latency property value [12 ms .. 18 ms]");
	}
}
