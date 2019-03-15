/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */

package org.osate.assure.tests

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import com.rockwellcollins.atc.resolute.resolute.ResoluteLibrary
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.aadl2.PropertySet
import org.osate.alisa.workbench.alisa.AssuranceCase
import org.osate.alisa.workbench.alisa.AssuranceTask
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
	@Inject extension ValidationTestHelper

	@Inject
	IAssureConstructor assureConstructor

	val projectprefix = "org.osate.assure.tests/models/SimpleControlSystem/"
	val propertiesprefix = projectprefix + "Properties/"
	val aadlprefix = projectprefix + "aadl/"
	val alisaprefix = projectprefix + "alisa/"
	val resoluteprefix = projectprefix + "resolute/"
	var primaryroot = null

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
			alisaprefix + "SCSImplementationReqs.reqspec",
			alisaprefix + "scsimplvplan.verify",
			alisaprefix + "SCSgoals2.goals",
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
			7.assertEquals(publicSection.ownedClassifiers.size)
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
			7.assertEquals(publicSection.ownedClassifiers.size)
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
		if (ResoluteUtil.isResoluteInstalled()) {
			assertNoIssues(reg)
		} else {
			val validate = validate(scssrc);
			13.assertEquals(validate.size)
		}
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
			12.assertEquals(methods.size)
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
	def void SCSImplVPlantest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix + "scsimplvplan.verify"), true)
		val ver = scssrc.contents.get(0) as Verification
		val vp = ver.contents.get(0) as VerificationPlan
		vp => [
			"scsimplvplan".assertEquals(name)
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

//			, resoluteprefix+"BasicResolute.aadl", resoluteprefix+"BudgetResolute.aadl"
	@Test
	def void BasicResolutetest() {
		if (ResoluteUtil.isResoluteInstalled()) {
			val ac = primaryroot as AssuranceCase
			val rs = ac.eResource.resourceSet
			val scssrc = rs.getResource(URI.createURI(resoluteprefix + "BasicResolute.aadl"), true)
			val pkg = scssrc.contents.get(0) as AadlPackage
			pkg => [
				"BasicResolute".assertEquals(name)
				1.assertEquals(publicSection.ownedAnnexLibraries.size)
				(publicSection.ownedAnnexLibraries.get(0) as DefaultAnnexLibrary).
					parsedAnnexLibrary as ResoluteLibrary => [
					5.assertEquals(definitions.size)
				]
			]
			assertNoIssues(pkg)
		}
	}

	@Test
	def void BudgetResolutetest() {
		if (ResoluteUtil.isResoluteInstalled()) {
			val ac = primaryroot as AssuranceCase
			val rs = ac.eResource.resourceSet
			val scssrc = rs.getResource(URI.createURI(resoluteprefix + "BudgetResolute.aadl"), true)
			val pkg = scssrc.contents.get(0) as AadlPackage
			pkg => [
				"BudgetResolute".assertEquals(name)
				1.assertEquals(publicSection.ownedAnnexLibraries.size)
				(publicSection.ownedAnnexLibraries.get(0) as DefaultAnnexLibrary).
					parsedAnnexLibrary as ResoluteLibrary => [
					22.assertEquals(definitions.size)
				]
			]
			assertNoIssues(pkg)
		}
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
		if (ResoluteUtil.isResoluteInstalled()) {
			16.assertEquals(counts.successCount)
			21.assertEquals(counts.failCount)
			0.assertEquals(counts.errorCount)
		} else {
			9.assertEquals(counts.successCount)
			11.assertEquals(counts.failCount)
			17.assertEquals(counts.errorCount)
		}
	}

}
