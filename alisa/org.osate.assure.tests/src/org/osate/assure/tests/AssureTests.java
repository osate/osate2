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
package org.osate.assure.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.osate.testsupport.AssertHelper.assertWarning;

import java.util.ArrayList;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.PropertySet;
import org.osate.alisa.workbench.alisa.AssuranceCase;
import org.osate.alisa.workbench.alisa.AssuranceTask;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.evaluator.AssureProcessor;
import org.osate.assure.generator.IAssureConstructor;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.categories.categories.CategoriesDefinitions;
import org.osate.organization.organization.Organization;
import org.osate.reqspec.reqSpec.GlobalConstants;
import org.osate.reqspec.reqSpec.GlobalRequirementSet;
import org.osate.reqspec.reqSpec.ReqSpec;
import org.osate.reqspec.reqSpec.StakeholderGoals;
import org.osate.reqspec.reqSpec.SystemRequirementSet;
import org.osate.resolute.ResoluteUtil;
import org.osate.testsupport.TestHelper;
import org.osate.verify.verify.Verification;
import org.osate.verify.verify.VerificationMethodRegistry;
import org.osate.verify.verify.VerificationPlan;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(FullAlisaInjectorProvider.class)
public class AssureTests extends XtextTest {
	@Inject
	private TestHelper<AssuranceCase> alisaTestHelper;

	@Inject
	protected ValidationTestHelper validationTestHelper;

	@Inject
	protected IAssureConstructor assureConstructor;

	protected final String projectprefix = "org.osate.assure.tests/models/SimpleControlSystem/";
	protected final String propertiesprefix = projectprefix + "Properties/";
	protected final String aadlprefix = projectprefix + "aadl/";
	protected final String alisaprefix = projectprefix + "alisa/";
	protected final String resoluteprefix = projectprefix + "resolute/";
	protected Object primaryroot;

	@Before
	public void setUp() {
		primaryroot = alisaTestHelper.parseFile(alisaprefix + "SCSVerification.alisa",
				aadlprefix + "SimpleControlSystem.aadl", propertiesprefix + "ACVIP.aadl",
				aadlprefix + "PhysicalResources.aadl", aadlprefix + "DataDictionary.aadl", aadlprefix + "Platform.aadl",
				aadlprefix + "Software.aadl", aadlprefix + "DigitalControlSystem.aadl", alisaprefix + "sei.org",
				alisaprefix + "authors.constants", alisaprefix + "predefined.cat",
				alisaprefix + "Resolute.methodregistry", alisaprefix + "Plugins.methodregistry",
				alisaprefix + "Alisa_Consistency.methodregistry", alisaprefix + "DCS.reqspec",
				alisaprefix + "dcsvplan.verify", alisaprefix + "DualSCS.reqspec", alisaprefix + "dualscsvplan.verify",
				alisaprefix + "globalReq.reqspec", alisaprefix + "GlobalVPlan.verify", alisaprefix + "Peter.reqspec",
				alisaprefix + "PeterPlan.verify", alisaprefix + "SCS.reqspec", alisaprefix + "scsvplan.verify",
				alisaprefix + "SCSTier0Reqs.reqspec", alisaprefix + "scstier0vplan.verify",
				alisaprefix + "SCSgoals2.goals", alisaprefix + "SCSVerificationNestedSensors.alisa",
				alisaprefix + "SCSImplementationReqs.reqspec", alisaprefix + "scsimplvplan.verify",
				resoluteprefix + "BasicResolute.aadl", resoluteprefix + "BudgetResolute.aadl");
	}

	private Resource getResource(String path) {
		var assuranceCase = (AssuranceCase) primaryroot;
		return assuranceCase.eResource().getResourceSet().getResource(URI.createURI(path), true);
	}

	private static FluentIssueCollection newIssueCollection(FluentIssueCollection testFileResult) {
		return new FluentIssueCollection(testFileResult.getResource(), new ArrayList<Issue>(), new ArrayList<String>());
	}

	@Test
	public void SEIOrgtest() {
		var organization = (Organization) getResource(alisaprefix + "sei.org").getContents().getFirst();
		assertEquals("sei", organization.getName());
		assertTrue(organization.getStakeholder().size() > 1);
		assertEquals("phf", organization.getStakeholder().get(0).getName());
		assertEquals("dpg", organization.getStakeholder().get(1).getName());
		validationTestHelper.assertNoIssues(organization);
	}

	@Test
	public void Categorytest() {
		var categories = (CategoriesDefinitions) getResource(alisaprefix + "predefined.cat").getContents().getFirst();
		assertEquals(4, categories.getCategories().size());
		assertEquals("Quality", categories.getCategories().get(0).getName());
		assertEquals(13, categories.getCategories().get(0).getCategory().size());
		assertEquals("Phase", categories.getCategories().get(1).getName());
		assertEquals(9, categories.getCategories().get(1).getCategory().size());
		validationTestHelper.assertNoIssues(categories);
	}

	@Test
	public void Constantstest() {
		var reqspec = (ReqSpec) getResource(alisaprefix + "authors.constants").getContents().getFirst();
		var constants = (GlobalConstants) reqspec.getParts().getFirst();
		assertEquals("authors", constants.getName());
		assertEquals(1, constants.getConstants().size());
		validationTestHelper.assertNoIssues(constants);
	}

	@Test
	public void ACVIPPropstest() {
		var propertySet = (PropertySet) getResource(propertiesprefix + "ACVIP.aadl").getContents().getFirst();
		assertEquals("ACVIP", propertySet.getName());
		assertEquals(2, propertySet.getOwnedProperties().size());
		assertEquals(1, propertySet.getOwnedPropertyConstants().size());
		validationTestHelper.assertNoIssues(propertySet);
	}

	@Test
	public void SCSAadltest() {
		assertAadlPackage("SimpleControlSystem.aadl", "SimpleControlSystem", 8);
	}

	@Test
	public void DataDictionarystest() {
		assertAadlPackage("DataDictionary.aadl", "DataDictionary", 2);
	}

	@Test
	public void Platformtest() {
		assertAadlPackage("Platform.aadl", "Platform", 6);
	}

	@Test
	public void Softwaretest() {
		assertAadlPackage("Software.aadl", "Software", 11);
	}

	@Test
	public void DigitalControlSystemtest() {
		assertAadlPackage("DigitalControlSystem.aadl", "DigitalControlSystem", 9);
	}

	private void assertAadlPackage(String fileName, String expectedName, int expectedClassifierCount) {
		var aadlPackage = (AadlPackage) getResource(aadlprefix + fileName).getContents().getFirst();
		assertEquals(expectedName, aadlPackage.getName());
		assertEquals(expectedClassifierCount, aadlPackage.getPublicSection().getOwnedClassifiers().size());
		validationTestHelper.assertNoIssues(aadlPackage);
	}

	@Test
	public void ResoluteRegistrytest() {
		var resource = getResource(alisaprefix + "Resolute.methodregistry");
		var registry = getRegistry(resource);
		assertEquals("Resolute", registry.getName());
		assertEquals(13, registry.getMethods().size());
		assertEquals(13, validationTestHelper.validate(resource).size());
	}

	@Test
	public void PluginsRegistrytest() {
		var registry = getRegistry(getResource(alisaprefix + "Plugins.methodregistry"));
		assertEquals("Plugins", registry.getName());
		assertEquals(12, registry.getMethods().size());
		validationTestHelper.assertNoIssues(registry);
	}

	@Test
	public void Alisa_ConsistencyRegistrytest() {
		var registry = getRegistry(getResource(alisaprefix + "Alisa_Consistency.methodregistry"));
		assertEquals("Alisa_Consistency", registry.getName());
		assertEquals(17, registry.getMethods().size());
		validationTestHelper.assertNoIssues(registry);
	}

	private static VerificationMethodRegistry getRegistry(Resource resource) {
		var verification = (Verification) resource.getContents().getFirst();
		return (VerificationMethodRegistry) verification.getContents().getFirst();
	}

	@Test
	public void DCSReqSpectest() {
		var resource = getResource(alisaprefix + "DCS.reqspec");
		var testFileResult = issues = alisaTestHelper.testResource(resource);
		var issueCollection = newIssueCollection(testFileResult);
		var reqspec = (ReqSpec) resource.getContents().getFirst();
		var requirements = (SystemRequirementSet) reqspec.getParts().getFirst();

		assertEquals("dcsreqs", requirements.getName());
		assertEquals(1, requirements.getConstants().size());
		assertEquals(2, requirements.getRequirements().size());
		assertEquals("R1", requirements.getRequirements().get(0).getName());
		assertWarning(requirements.getRequirements().get(0), testFileResult.getIssues(), issueCollection,
				"System requirement should have stakeholder goal or requirement reference");
		assertEquals("MaximumLatency", requirements.getConstants().getFirst().getName());
		assertEquals("R2", requirements.getRequirements().get(1).getName());
		assertWarning(requirements.getRequirements().get(1), testFileResult.getIssues(), issueCollection,
				"System requirement should have stakeholder goal or requirement reference");
		assertWarning(requirements, testFileResult.getIssues(), issueCollection,
				"Features without requirement: power canbusaccess sensor1in sensor2In actuatorOut");
		assertExpectedIssues(requirements, testFileResult, issueCollection);
	}

	@Test
	public void DCSVPlantest() {
		var verificationPlan = getVerificationPlan("dcsvplan.verify");
		assertEquals("dcsvplan", verificationPlan.getName());
		assertEquals(2, verificationPlan.getClaim().size());
		assertEquals(2, verificationPlan.getClaim().getFirst().getActivities().size());
		validationTestHelper.assertNoIssues(verificationPlan);
	}

	@Test
	public void DualSCSReqSpectest() {
		var resource = getResource(alisaprefix + "DualSCS.reqspec");
		var testFileResult = issues = alisaTestHelper.testResource(resource);
		var issueCollection = newIssueCollection(testFileResult);
		var reqspec = (ReqSpec) resource.getContents().getFirst();
		var requirements = (SystemRequirementSet) reqspec.getParts().getFirst();

		assertEquals("DualSCSreqs", requirements.getName());
		assertEquals(0, requirements.getConstants().size());
		assertEquals(4, requirements.getRequirements().size());
		assertEquals("SR1", requirements.getRequirements().get(0).getName());
		assertEquals("SR1_1", requirements.getRequirements().get(1).getName());
		assertEquals("SR1_2", requirements.getRequirements().get(2).getName());
		assertEquals("SR1_3", requirements.getRequirements().get(3).getName());
		assertWarning(requirements, testFileResult.getIssues(), issueCollection,
				"Features without requirement: power force backuppower");
		assertExpectedIssues(requirements, testFileResult, issueCollection);
	}

	@Test
	public void DualSCSVPlantest() {
		var verificationPlan = getVerificationPlan("dualscsvplan.verify");
		assertEquals("DualSCSvplan", verificationPlan.getName());
		assertEquals(1, verificationPlan.getClaim().size());
		var claim = verificationPlan.getClaim().getFirst();
		assertEquals(1, claim.getSubclaim().get(0).getActivities().size());
		assertEquals(1, claim.getSubclaim().get(1).getActivities().size());
		assertEquals(1, claim.getSubclaim().get(2).getActivities().size());
		validationTestHelper.assertNoIssues(verificationPlan);
	}

	@Test
	public void GlobalReqSpectest() {
		var resource = getResource(alisaprefix + "globalReq.reqspec");
		var testFileResult = issues = alisaTestHelper.testResource(resource);
		var issueCollection = newIssueCollection(testFileResult);
		var reqspec = (ReqSpec) resource.getContents().getFirst();
		var requirements = (GlobalRequirementSet) reqspec.getParts().getFirst();

		assertEquals("globalReq", requirements.getName());
		assertEquals(0, requirements.getConstants().size());
		assertEquals(2, requirements.getRequirements().size());
		assertEquals("connected", requirements.getRequirements().get(0).getName());
		assertWarning(requirements.getRequirements().get(0), testFileResult.getIssues(), issueCollection,
				"System requirement should have stakeholder goal or requirement reference");
		assertEquals("Allconnected", requirements.getRequirements().get(1).getName());
		assertWarning(requirements.getRequirements().get(1), testFileResult.getIssues(), issueCollection,
				"System requirement should have stakeholder goal or requirement reference");
		assertExpectedIssues(requirements, testFileResult, issueCollection);
	}

	@Test
	public void GlobalVPlantest() {
		var verificationPlan = getVerificationPlan("GlobalVPlan.verify");
		assertEquals("globalVPlan", verificationPlan.getName());
		assertEquals(2, verificationPlan.getClaim().size());
		assertEquals(2, verificationPlan.getClaim().get(0).getActivities().size());
		assertEquals(1, verificationPlan.getClaim().get(1).getActivities().size());
		validationTestHelper.assertNoIssues(verificationPlan);
	}

	@Test
	public void PeterReqSpectest() {
		var resource = getResource(alisaprefix + "Peter.reqspec");
		var testFileResult = issues = alisaTestHelper.testResource(resource);
		var issueCollection = newIssueCollection(testFileResult);
		var reqspec = (ReqSpec) resource.getContents().getFirst();
		var requirements = (GlobalRequirementSet) reqspec.getParts().getFirst();

		assertEquals("Peter", requirements.getName());
		assertEquals(0, requirements.getConstants().size());
		assertEquals(1, requirements.getRequirements().size());
		assertEquals("req1", requirements.getRequirements().getFirst().getName());
		assertWarning(requirements.getRequirements().getFirst(), testFileResult.getIssues(), issueCollection,
				"System requirement should have stakeholder goal or requirement reference");
		assertExpectedIssues(requirements, testFileResult, issueCollection);
	}

	@Test
	public void PeterVPlantest() {
		var verificationPlan = getVerificationPlan("PeterPlan.verify");
		assertEquals("PeterPlan", verificationPlan.getName());
		assertEquals(1, verificationPlan.getClaim().size());
		assertEquals(1, verificationPlan.getClaim().getFirst().getActivities().size());
		validationTestHelper.assertNoIssues(verificationPlan);
	}

	@Test
	public void SCSReqSpectest() {
		var resource = getResource(alisaprefix + "SCS.reqspec");
		var testFileResult = issues = alisaTestHelper.testResource(resource);
		var issueCollection = newIssueCollection(testFileResult);
		var reqspec = (ReqSpec) resource.getContents().getFirst();
		var requirements = (SystemRequirementSet) reqspec.getParts().getFirst();

		assertEquals("scsreqs", requirements.getName());
		assertEquals(0, requirements.getConstants().size());
		assertEquals(2, requirements.getRequirements().size());
		assertEquals("R1", requirements.getRequirements().get(0).getName());
		assertEquals("R3", requirements.getRequirements().get(1).getName());
		assertWarning(requirements, testFileResult.getIssues(), issueCollection, "Features without requirement: force");
		assertExpectedIssues(requirements, testFileResult, issueCollection);
	}

	@Test
	public void SCSVPlantest() {
		var verificationPlan = getVerificationPlan("scsvplan.verify");
		assertEquals("scsvplan", verificationPlan.getName());
		assertEquals(2, verificationPlan.getClaim().size());
		assertEquals(3, verificationPlan.getClaim().get(0).getActivities().size());
		assertEquals(3, verificationPlan.getClaim().get(1).getActivities().size());
		validationTestHelper.assertNoIssues(verificationPlan);
	}

	@Test
	public void SCSTier0ReqSpectest() {
		var resource = getResource(alisaprefix + "SCSTier0Reqs.reqspec");
		var testFileResult = issues = alisaTestHelper.testResource(resource);
		var issueCollection = newIssueCollection(testFileResult);
		var reqspec = (ReqSpec) resource.getContents().getFirst();
		var requirements = (SystemRequirementSet) reqspec.getParts().getFirst();

		assertEquals("SCSTier0reqs", requirements.getName());
		assertEquals(0, requirements.getConstants().size());
		assertEquals(5, requirements.getRequirements().size());
		assertEquals("R2_Lat", requirements.getRequirements().get(0).getName());
		assertRequirementWarning(requirements, 1, "DCS_R1", testFileResult, issueCollection);
		assertRequirementWarning(requirements, 2, "Sensor1_R1", testFileResult, issueCollection);
		assertRequirementWarning(requirements, 3, "Sensor2_R1", testFileResult, issueCollection);
		assertRequirementWarning(requirements, 4, "Actuator_R1", testFileResult, issueCollection);
		assertWarning(requirements, testFileResult.getIssues(), issueCollection,
				"Features without requirement: power force");
		assertExpectedIssues(requirements, testFileResult, issueCollection);
	}

	private static void assertRequirementWarning(SystemRequirementSet requirements, int index, String expectedName,
			FluentIssueCollection testFileResult, FluentIssueCollection issueCollection) {
		var requirement = requirements.getRequirements().get(index);
		assertEquals(expectedName, requirement.getName());
		assertWarning(requirement, testFileResult.getIssues(), issueCollection,
				"System requirement should have stakeholder goal or requirement reference");
	}

	@Test
	public void SCSImplementationReqSpectest() {
		var resource = getResource(alisaprefix + "SCSImplementationReqs.reqspec");
		var testFileResult = issues = alisaTestHelper.testResource(resource);
		var issueCollection = newIssueCollection(testFileResult);
		var reqspec = (ReqSpec) resource.getContents().getFirst();
		var requirements = (SystemRequirementSet) reqspec.getParts().getFirst();

		assertEquals("SCSImplementationreqs", requirements.getName());
		assertEquals(0, requirements.getConstants().size());
		assertEquals(1, requirements.getRequirements().size());
		assertEquals("R2_Lat", requirements.getRequirements().getFirst().getName());
		assertWarning(requirements, testFileResult.getIssues(), issueCollection,
				"Features without requirement: power force");
		assertExpectedIssues(requirements, testFileResult, issueCollection);
	}

	private void assertExpectedIssues(EObject object, FluentIssueCollection testFileResult,
			FluentIssueCollection issueCollection) {
		validationTestHelper.assertNoErrors(object);
		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	@Test
	public void SCSTier0VPlantest() {
		var verificationPlan = getVerificationPlan("scstier0vplan.verify");
		assertEquals("scstier0vplan", verificationPlan.getName());
		assertEquals(5, verificationPlan.getClaim().size());
		assertEquals(1, verificationPlan.getClaim().get(0).getActivities().size());
		assertEquals(0, verificationPlan.getClaim().get(1).getActivities().size());
		validationTestHelper.assertNoIssues(verificationPlan);
	}

	@Test
	public void SCSImplVPlantest() {
		var verificationPlan = getVerificationPlan("scsimplvplan.verify");
		assertEquals("scsimplvplan", verificationPlan.getName());
		assertEquals(1, verificationPlan.getClaim().size());
		assertEquals(1, verificationPlan.getClaim().getFirst().getActivities().size());
		validationTestHelper.assertNoIssues(verificationPlan);
	}

	private VerificationPlan getVerificationPlan(String fileName) {
		var verification = (Verification) getResource(alisaprefix + fileName).getContents().getFirst();
		return (VerificationPlan) verification.getContents().getFirst();
	}

	@Test
	public void SCSGoalstest() {
		var reqspec = (ReqSpec) getResource(alisaprefix + "SCSgoals2.goals").getContents().getFirst();
		var goals = (StakeholderGoals) reqspec.getParts().getFirst();
		assertEquals("SCSgoals", goals.getName());
		assertEquals(0, goals.getConstants().size());
		assertEquals(6, goals.getGoals().size());
		assertEquals("g1", goals.getGoals().get(0).getName());
		assertEquals("g2", goals.getGoals().get(1).getName());
		validationTestHelper.assertNoIssues(goals);
	}

	@Test
	public void SCSAssuranceCasetest() {
		var assuranceCase = (AssuranceCase) primaryroot;
		assertEquals("SCSCase", assuranceCase.getName());
		assertEquals(1, assuranceCase.getAssurancePlans().size());
		assertEquals("SCSPlan", assuranceCase.getAssurancePlans().getFirst().getName());
		assertEquals(1, assuranceCase.getTasks().size());
		assertEquals("SCSWeight", ((AssuranceTask) assuranceCase.getTasks().getFirst()).getName());
		validationTestHelper.assertNoIssues(assuranceCase);
	}

	@Test
	public void SCSAssuranceInstancetest() {
		var assuranceCase = (AssuranceCase) primaryroot;
		// The resource set is null in the global ReqSpec reference finder when this runs with OSATE's
		// DirtyStateAware resource descriptions.
		var assuranceCaseResult = assureConstructor.generateFullAssuranceCase(assuranceCase);
		AssureUtilExtension.resetToTBD(assuranceCaseResult, null);
		AssureUtilExtension.recomputeAllCounts(assuranceCaseResult, null);
		var counts = assuranceCaseResult.getMetrics();
		assertEquals(37, counts.getTbdCount());
		new AssureProcessor().processCase(assuranceCaseResult, null, new NullProgressMonitor(), false);
		assertEquals(0, counts.getTbdCount());
		assertEquals(9, counts.getSuccessCount());
		assertEquals(11, counts.getFailCount());
		assertEquals(17, counts.getErrorCount());

		var claim = assuranceCaseResult.getModelResult().getFirst().getClaimResult().get(2);
		assertEquals(AssureUtilExtension.constructMessage(claim),
				"sensortoactuatorresponse with Latency property value [12 ms .. 18 ms]");
	}

	@Test
	public void SCSNestedSensorsAssuranceInstancetest() {
		var nestedCase = (AssuranceCase) getResource(alisaprefix + "SCSVerificationNestedSensors.alisa").getContents()
				.getFirst();
		// The resource set is null in the global ReqSpec reference finder when this runs with OSATE's
		// DirtyStateAware resource descriptions.
		var assuranceCaseResult = assureConstructor.generateFullAssuranceCase(nestedCase);
		AssureUtilExtension.resetToTBD(assuranceCaseResult, null);
		AssureUtilExtension.recomputeAllCounts(assuranceCaseResult, null);
		var counts = assuranceCaseResult.getMetrics();
		assertEquals(22, counts.getTbdCount());
		new AssureProcessor().processCase(assuranceCaseResult, null, new NullProgressMonitor(), false);
		assertEquals(0, counts.getTbdCount());
		if (ResoluteUtil.isResoluteInstalled()) {
			assertEquals(8, counts.getSuccessCount());
			assertEquals(14, counts.getFailCount());
			assertEquals(0, counts.getErrorCount());
		} else {
			assertEquals(5, counts.getSuccessCount());
			assertEquals(7, counts.getFailCount());
			assertEquals(10, counts.getErrorCount());
		}

		var claim = assuranceCaseResult.getModelResult().getFirst().getClaimResult().get(2);
		assertEquals(AssureUtilExtension.constructMessage(claim),
				"sensortoactuatorresponse_1 with Latency property value [12 ms .. 50 ms]");
		assertEquals(1, claim.getVerificationActivityResult().size());
		var verificationResult = (VerificationResult) claim.getVerificationActivityResult().getFirst();
		assertEquals(2, verificationResult.getAnalysisresult().size());
	}
}
