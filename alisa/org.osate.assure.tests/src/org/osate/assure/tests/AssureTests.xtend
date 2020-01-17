/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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

package org.osate.assure.tests

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.PropertySet
import org.osate.alisa.workbench.alisa.AssuranceCase
import org.osate.alisa.workbench.alisa.AssuranceTask
import org.osate.assure.assure.VerificationResult
import org.osate.assure.evaluator.AssureProcessor
import org.osate.assure.generator.IAssureConstructor
import org.osate.assure.util.ResoluteUtil
import org.osate.categories.categories.CategoriesDefinitions
import org.osate.organization.organization.Organization
import org.osate.reqspec.reqSpec.GlobalConstants
import org.osate.reqspec.reqSpec.GlobalRequirementSet
import org.osate.reqspec.reqSpec.ReqSpec
import org.osate.reqspec.reqSpec.StakeholderGoals
import org.osate.reqspec.reqSpec.SystemRequirementSet
import org.osate.testsupport.TestHelper
import org.osate.verify.verify.Verification
import org.osate.verify.verify.VerificationMethodRegistry
import org.osate.verify.verify.VerificationPlan

import static extension org.junit.Assert.*
import static extension org.osate.assure.util.AssureUtilExtension.*
import static extension org.osate.testsupport.AssertHelper.*

@RunWith(XtextRunner)
@InjectWith(FullAlisaInjectorProvider)
class AssureTests extends XtextTest {
	@Inject
	TestHelper<AssuranceCase> alisaTestHelper
	@Inject 
	protected extension ValidationTestHelper

	@Inject
	protected IAssureConstructor assureConstructor

	protected val projectprefix = "org.osate.assure.tests/models/SimpleControlSystem/"
	protected val propertiesprefix = projectprefix + "Properties/"
	protected val aadlprefix = projectprefix + "aadl/"
	protected val alisaprefix = projectprefix + "alisa/"
	protected val resoluteprefix = projectprefix + "resolute/"
	protected var primaryroot = null

	@Before
	def void setUp() {
		primaryroot = alisaTestHelper.parseFile(
			alisaprefix + "SCSVerification.alisa",
			aadlprefix + "SimpleControlSystem.aadl",
			propertiesprefix + "ACVIP.aadl",
			aadlprefix + "PhysicalResources.aadl",
			aadlprefix + "DataDictionary.aadl",
			aadlprefix + "Platform.aadl",
			aadlprefix + "Software.aadl",
			aadlprefix + "DigitalControlSystem.aadl",
			alisaprefix + "sei.org",
			alisaprefix + "authors.constants",
			alisaprefix + "predefined.cat",
			alisaprefix + "Resolute.methodregistry",
			alisaprefix + "Plugins.methodregistry",
			alisaprefix + "Alisa_Consistency.methodregistry",
			alisaprefix + "DCS.reqspec",
			alisaprefix + "dcsvplan.verify",
			alisaprefix + "DualSCS.reqspec",
			alisaprefix + "dualscsvplan.verify",
			alisaprefix + "globalReq.reqspec",
			alisaprefix + "GlobalVPlan.verify",
			alisaprefix + "Peter.reqspec",
			alisaprefix + "PeterPlan.verify",
			alisaprefix + "SCS.reqspec",
			alisaprefix + "scsvplan.verify",
			alisaprefix + "SCSTier0Reqs.reqspec",
			alisaprefix + "scstier0vplan.verify",
			alisaprefix + "SCSgoals2.goals",
			alisaprefix + "SCSVerificationNestedSensors.alisa",
			alisaprefix + "SCSImplementationReqs.reqspec",
			alisaprefix + "scsimplvplan.verify",
			resoluteprefix + "BasicResolute.aadl",
			resoluteprefix + "BudgetResolute.aadl"
		)


	}

	@Test
	def void SEIOrgtest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "sei.org"), true)
		val org = scssrc.contents.get(0) as Organization
		org => [
			"sei".assertEquals(name)
			assertTrue(stakeholder.size > 1)
			stakeholder.get(0) => [
				"phf".assertEquals(name)
			]
			stakeholder.get(1) => [
				"dpg".assertEquals(name)
			]
		]
		assertNoIssues(org)
	}

	@Test
	def void Categorytest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "predefined.cat"), true)
		val cd = scssrc.contents.get(0) as CategoriesDefinitions
		cd => [
			4.assertEquals(categories.size)
			categories.get(0) => [
				"Quality".assertEquals(name)
				13.assertEquals(category.size)
			]
			categories.get(1) => [
				"Phase".assertEquals(name)
				9.assertEquals(category.size)
			]
		]
		assertNoIssues(cd)
	}

	@Test
	def void Constantstest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "authors.constants"), true)
		val reqspec = scssrc.contents.get(0) as ReqSpec
		val gc = reqspec.parts.get(0) as GlobalConstants
		gc => [
			"authors".assertEquals(name)
			1.assertEquals(constants.size)
		]
		assertNoIssues(gc)
	}

	@Test
	def void ACVIPPropstest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(propertiesprefix + "ACVIP.aadl"), true)
		val ps = scssrc.contents.get(0) as PropertySet
		ps => [
			"ACVIP".assertEquals(name)
			2.assertEquals(ownedProperties.size)
			1.assertEquals(ownedPropertyConstants.size)
		]
		assertNoIssues(ps)
	}

	@Test
	def void SCSAadltest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(aadlprefix + "SimpleControlSystem.aadl"), true)
		val pkg = scssrc.contents.get(0) as AadlPackage
		pkg => [
			"SimpleControlSystem".assertEquals(name)
			8.assertEquals(publicSection.ownedClassifiers.size)
		]
		assertNoIssues(pkg)
	}

	@Test
	def void DataDictionarystest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(aadlprefix + "DataDictionary.aadl"), true)
		val pkg = scssrc.contents.get(0) as AadlPackage
		pkg => [
			"DataDictionary".assertEquals(name)
			2.assertEquals(publicSection.ownedClassifiers.size)
		]
		assertNoIssues(pkg)
	}

	@Test
	def void Platformtest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(aadlprefix + "Platform.aadl"), true)
		val pkg = scssrc.contents.get(0) as AadlPackage
		pkg => [
			"Platform".assertEquals(name)
			6.assertEquals(publicSection.ownedClassifiers.size)
		]
		assertNoIssues(pkg)
	}

	@Test
	def void Softwaretest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(aadlprefix + "Software.aadl"), true)
		val pkg = scssrc.contents.get(0) as AadlPackage
		pkg => [
			"Software".assertEquals(name)
			11.assertEquals(publicSection.ownedClassifiers.size)
		]
		assertNoIssues(pkg)
	}

	@Test
	def void DigitalControlSystemtest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(aadlprefix + "DigitalControlSystem.aadl"), true)
		val pkg = scssrc.contents.get(0) as AadlPackage
		pkg => [
			"DigitalControlSystem".assertEquals(name)
			9.assertEquals(publicSection.ownedClassifiers.size)
		]
		assertNoIssues(pkg)
	}

	@Test
	def void ResoluteRegistrytest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "Resolute.methodregistry"), true)
		val ver = scssrc.contents.get(0) as Verification
		val reg = ver.contents.get(0) as VerificationMethodRegistry
		reg => [
			"Resolute".assertEquals(name)
			13.assertEquals(methods.size)
		]
		val validate = validate(scssrc);
		13.assertEquals(validate.size)
	}

	@Test
	def void PluginsRegistrytest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "Plugins.methodregistry"), true)
		val ver = scssrc.contents.get(0) as Verification
		val reg = ver.contents.get(0) as VerificationMethodRegistry
		reg => [
			"Plugins".assertEquals(name)
			13.assertEquals(methods.size)
		]
		assertNoIssues(reg)
	}

	@Test
	def void Alisa_ConsistencyRegistrytest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "Alisa_Consistency.methodregistry"), true)
		val ver = scssrc.contents.get(0) as Verification
		val reg = ver.contents.get(0) as VerificationMethodRegistry
		reg => [
			"Alisa_Consistency".assertEquals(name)
			17.assertEquals(methods.size)
		]
//		assertNoErrors(reg)	
		assertNoIssues(reg)
	}

//			,alisaprefix+"DCS.reqspec",alisaprefix+"dcsvplan.verify"
	@Test
	def void DCSReqSpectest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "DCS.reqspec"), true)

		val testFileResult = issues = alisaTestHelper.testResource(scssrc)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		val reqspec = scssrc.contents.get(0) as ReqSpec
		val srs = reqspec.parts.get(0) as SystemRequirementSet
		srs => [
			"dcsreqs".assertEquals(name)
			1.assertEquals(constants.size)
			2.assertEquals(requirements.size)
			requirements.get(0) => [
				"R1".assertEquals(name)
				it.assertWarning(testFileResult.issues, issueCollection,
					"System requirement should have stakeholder goal or requirement reference")
			]
			constants.get(0) => [
				"MaximumLatency".assertEquals(name)
			]
			requirements.get(1) => [
				"R2".assertEquals(name)
				it.assertWarning(testFileResult.issues, issueCollection,
					"System requirement should have stakeholder goal or requirement reference")
			]
		]
		srs.assertWarning(testFileResult.issues, issueCollection,
			"Features without requirement: power canbusaccess sensor1in sensor2In actuatorOut")
		assertNoErrors(srs)
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	@Test
	def void DCSVPlantest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "dcsvplan.verify"), true)
		val ver = scssrc.contents.get(0) as Verification
		val vp = ver.contents.get(0) as VerificationPlan
		vp => [
			"dcsvplan".assertEquals(name)
			2.assertEquals(claim.size)
			claim.get(0) => [
				2.assertEquals(activities.size)
			]
		]
		assertNoIssues(vp)
	}

//			,alisaprefix+"DualSCS.reqspec",alisaprefix+"dualscsvplan.verify"
	@Test
	def void DualSCSReqSpectest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "DualSCS.reqspec"), true)

		val testFileResult = issues = alisaTestHelper.testResource(scssrc)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		val reqspec = scssrc.contents.get(0) as ReqSpec
		val srs = reqspec.parts.get(0) as SystemRequirementSet
		srs => [
			"DualSCSreqs".assertEquals(name)
			0.assertEquals(constants.size)
			4.assertEquals(requirements.size)
			requirements.get(0) => [
				"SR1".assertEquals(name)
			]
			requirements.get(1) => [
				"SR1_1".assertEquals(name)
			]
			requirements.get(2) => [
				"SR1_2".assertEquals(name)
			]
			requirements.get(3) => [
				"SR1_3".assertEquals(name)
			]
		]
		srs.assertWarning(testFileResult.issues, issueCollection,
			"Features without requirement: power force backuppower")
		assertNoErrors(srs)
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	@Test
	def void DualSCSVPlantest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "dualscsvplan.verify"), true)
		val ver = scssrc.contents.get(0) as Verification
		val vp = ver.contents.get(0) as VerificationPlan
		vp => [
			"DualSCSvplan".assertEquals(name)
			1.assertEquals(claim.size)
			claim.get(0) => [
				subclaim.get(0) => [
					1.assertEquals(activities.size)
				]
				subclaim.get(1) => [
					1.assertEquals(activities.size)
				]
				subclaim.get(2) => [
					1.assertEquals(activities.size)
				]
			]
		]
		assertNoIssues(vp)
	}

//			,alisaprefix+"globalReq.reqspec" ,alisaprefix+"GlobalVPlan.verify" 
	@Test
	def void GlobalReqSpectest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "globalReq.reqspec"), true)

		val testFileResult = issues = alisaTestHelper.testResource(scssrc)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		val reqspec = scssrc.contents.get(0) as ReqSpec
		val srs = reqspec.parts.get(0) as GlobalRequirementSet
		srs => [
			"globalReq".assertEquals(name)
			0.assertEquals(constants.size)
			2.assertEquals(requirements.size)
			requirements.get(0) => [
				"connected".assertEquals(name)
				it.assertWarning(testFileResult.issues, issueCollection,
					"System requirement should have stakeholder goal or requirement reference")
			]
			requirements.get(1) => [
				"Allconnected".assertEquals(name)
				it.assertWarning(testFileResult.issues, issueCollection,
					"System requirement should have stakeholder goal or requirement reference")
			]
		]
		assertNoErrors(srs)
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	@Test
	def void GlobalVPlantest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "GlobalVPlan.verify"), true)
		val ver = scssrc.contents.get(0) as Verification
		val vp = ver.contents.get(0) as VerificationPlan
		vp => [
			"globalVPlan".assertEquals(name)
			2.assertEquals(claim.size)
			claim.get(0) => [
				2.assertEquals(activities.size)
			]
			claim.get(1) => [
				1.assertEquals(activities.size)
			]
		]
		assertNoIssues(vp)
	}

//			,alisaprefix+"Peter.reqspec" ,alisaprefix+"PeterPlan.verify" 
	@Test
	def void PeterReqSpectest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "Peter.reqspec"), true)

		val testFileResult = issues = alisaTestHelper.testResource(scssrc)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		val reqspec = scssrc.contents.get(0) as ReqSpec
		val srs = reqspec.parts.get(0) as GlobalRequirementSet
		srs => [
			"Peter".assertEquals(name)
			0.assertEquals(constants.size)
			1.assertEquals(requirements.size)
			requirements.get(0) => [
				"req1".assertEquals(name)
				it.assertWarning(testFileResult.issues, issueCollection,
					"System requirement should have stakeholder goal or requirement reference")
			]
		]
		assertNoErrors(srs)
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	@Test
	def void PeterVPlantest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "PeterPlan.verify"), true)
		val ver = scssrc.contents.get(0) as Verification
		val vp = ver.contents.get(0) as VerificationPlan
		vp => [
			"PeterPlan".assertEquals(name)
			1.assertEquals(claim.size)
			claim.get(0) => [
				1.assertEquals(activities.size)
			]
		]
		assertNoIssues(vp)
	}

//			,alisaprefix+"SCS.reqspec" ,alisaprefix+"scsvplan.verify" 
	@Test
	def void SCSReqSpectest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "SCS.reqspec"), true)

		val testFileResult = issues = alisaTestHelper.testResource(scssrc)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		val reqspec = scssrc.contents.get(0) as ReqSpec
		val srs = reqspec.parts.get(0) as SystemRequirementSet
		srs => [
			"scsreqs".assertEquals(name)
			0.assertEquals(constants.size)
			2.assertEquals(requirements.size)
			requirements.get(0) => [
				"R1".assertEquals(name)
			]
			requirements.get(1) => [
				"R3".assertEquals(name)
			]
		]
		srs.assertWarning(testFileResult.issues, issueCollection, "Features without requirement: force")
		assertNoErrors(srs)
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	@Test
	def void SCSVPlantest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "scsvplan.verify"), true)
		val ver = scssrc.contents.get(0) as Verification
		val vp = ver.contents.get(0) as VerificationPlan
		vp => [
			"scsvplan".assertEquals(name)
			2.assertEquals(claim.size)
			claim.get(0) => [
				3.assertEquals(activities.size)
			]
			claim.get(1) => [
				3.assertEquals(activities.size)
			]
		]
		assertNoIssues(vp)
	}

//			,alisaprefix+"SCSImplementationReqs.reqspec" ,alisaprefix+"scsimplvplan.verify" 
	@Test
	def void SCSTier0ReqSpectest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "SCSTier0Reqs.reqspec"), true)

		val testFileResult = issues = alisaTestHelper.testResource(scssrc)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		val reqspec = scssrc.contents.get(0) as ReqSpec
		val srs = reqspec.parts.get(0) as SystemRequirementSet
		srs => [
			"SCSTier0reqs".assertEquals(name)
			0.assertEquals(constants.size)
			5.assertEquals(requirements.size)
			requirements.get(0) => [
				"R2_Lat".assertEquals(name)
			]
			requirements.get(1) => [
				"DCS_R1".assertEquals(name)
				it.assertWarning(testFileResult.issues, issueCollection,
					"System requirement should have stakeholder goal or requirement reference")
			]
			requirements.get(2) => [
				"Sensor1_R1".assertEquals(name)
				it.assertWarning(testFileResult.issues, issueCollection,
					"System requirement should have stakeholder goal or requirement reference")
			]
			requirements.get(3) => [
				"Sensor2_R1".assertEquals(name)
				it.assertWarning(testFileResult.issues, issueCollection,
					"System requirement should have stakeholder goal or requirement reference")
			]
			requirements.get(4) => [
				"Actuator_R1".assertEquals(name)
				it.assertWarning(testFileResult.issues, issueCollection,
					"System requirement should have stakeholder goal or requirement reference")
			]
		]
		srs.assertWarning(testFileResult.issues, issueCollection, "Features without requirement: power force")
		assertNoErrors(srs)
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	@Test
	def void SCSImplementationReqSpectest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "SCSImplementationReqs.reqspec"), true)

		val testFileResult = issues = alisaTestHelper.testResource(scssrc)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		val reqspec = scssrc.contents.get(0) as ReqSpec
		val srs = reqspec.parts.get(0) as SystemRequirementSet
		srs => [
			"SCSImplementationreqs".assertEquals(name)
			0.assertEquals(constants.size)
			1.assertEquals(requirements.size)
			requirements.get(0) => [
				"R2_Lat".assertEquals(name)
			]
		]
		srs.assertWarning(testFileResult.issues, issueCollection, "Features without requirement: power force")
		assertNoErrors(srs)
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}


	@Test
	def void SCSTier0VPlantest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "scstier0vplan.verify"), true)
		val ver = scssrc.contents.get(0) as Verification
		val vp = ver.contents.get(0) as VerificationPlan
		vp => [
			"scstier0vplan".assertEquals(name)
			5.assertEquals(claim.size)
			claim.get(0) => [
				1.assertEquals(activities.size)
			]
			claim.get(1) => [
				0.assertEquals(activities.size)
			]
		]
		assertNoIssues(vp)
	}

	@Test
	def void SCSImplVPlantest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "scsimplvplan.verify"), true)
		val ver = scssrc.contents.get(0) as Verification
		val vp = ver.contents.get(0) as VerificationPlan
		vp => [
			"scsimplvplan".assertEquals(name)
			1.assertEquals(claim.size)
			claim.get(0) => [
				1.assertEquals(activities.size)
			]
		]
		assertNoIssues(vp)
	}

//			,alisaprefix+"SCSgoals2.goals"  
	@Test
	def void SCSGoalstest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "SCSgoals2.goals"), true)

		val reqspec = scssrc.contents.get(0) as ReqSpec
		val srs = reqspec.parts.get(0) as StakeholderGoals
		srs => [
			"SCSgoals".assertEquals(name)
			0.assertEquals(constants.size)
			6.assertEquals(goals.size)
			goals.get(0) => [
				"g1".assertEquals(name)
			]
			goals.get(1) => [
				"g2".assertEquals(name)
			]
		]
		assertNoIssues(srs)
	}

	@Test
	def void SCSAssuranceCasetest() {
		val ac = primaryroot as AssuranceCase
		ac => [
			"SCSCase".assertEquals(name)
			1.assertEquals(assurancePlans.size)
			assurancePlans.get(0) => [
				"SCSPlan".assertEquals(name)
			]
			1.assertEquals(tasks.size)
			tasks.get(0) as AssuranceTask => [
				"SCSWeight".assertEquals(name)
			]
		]
		assertNoIssues(ac)
	}

	@Test
	def void SCSAssuranceInstancetest() {
		val ac = primaryroot as AssuranceCase
		// null pointer exception in Global reference finder for ReqSpec
		// Resource set is null
		// when running as OSATE resource descriptions is a DirtyStateAware...
		val assuranceCaseResult = assureConstructor.generateFullAssuranceCase(ac)
		assuranceCaseResult.resetToTBD(null)
		assuranceCaseResult.recomputeAllCounts(null)
		val counts = assuranceCaseResult.metrics
		37.assertEquals(counts.tbdCount)
		val ap = new AssureProcessor
		ap.processCase(assuranceCaseResult, null, new NullProgressMonitor(), false)
		0.assertEquals(counts.tbdCount)
		
		9.assertEquals(counts.successCount)
		11.assertEquals(counts.failCount)
		17.assertEquals(counts.errorCount)
			
		val mr = assuranceCaseResult.modelResult.head
		val clR2lat = mr.claimResult.get(2)
		constructMessage(clR2lat).assertEquals("sensortoactuatorresponse with Latency property value [12 ms .. 18 ms]")
	}



	@Test
	def void SCSNestedSensorsAssuranceInstancetest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val acsrc = rs.getResource(URI.createURI(alisaprefix + "SCSVerificationNestedSensors.alisa"), true)
		val NSac = acsrc.contents.get(0) as AssuranceCase
		// null pointer exception in Global reference finder for ReqSpec
		// Resource set is null
		// when running as OSATE resource descriptions is a DirtyStateAware...
		val assuranceCaseResult = assureConstructor.generateFullAssuranceCase(NSac)
		assuranceCaseResult.resetToTBD(null)
		assuranceCaseResult.recomputeAllCounts(null)
		val counts = assuranceCaseResult.metrics
		22.assertEquals(counts.tbdCount)
		val ap = new AssureProcessor
		ap.processCase(assuranceCaseResult, null, new NullProgressMonitor(), false)
		0.assertEquals(counts.tbdCount)
		if (ResoluteUtil.isResoluteInstalled()) {
			8.assertEquals(counts.successCount)
			14.assertEquals(counts.failCount)
			0.assertEquals(counts.errorCount)
		} else {
			5.assertEquals(counts.successCount)
			7.assertEquals(counts.failCount)
			10.assertEquals(counts.errorCount)
		}
		val mr = assuranceCaseResult.modelResult.head
		val clR2lat = mr.claimResult.get(2)
		constructMessage(clR2lat).assertEquals("sensortoactuatorresponse_1 with Latency property value [12 ms .. 50 ms]")
		val eviR2lats = clR2lat.verificationActivityResult
		1.assertEquals(eviR2lats.size)
		val eviR2lat = eviR2lats.get(0) as VerificationResult
		// test for 2 AnalysisResult objects
		2.assertEquals(eviR2lat.analysisresult.size)
	}

}
