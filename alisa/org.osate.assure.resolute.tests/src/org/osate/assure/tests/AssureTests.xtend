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
		assertNoIssues(reg)
	}

//			, resoluteprefix+"BasicResolute.aadl", resoluteprefix+"BudgetResolute.aadl"
	@Test
	def void BasicResolutetest() {
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

	@Test
	def void BudgetResolutetest() {
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

		16.assertEquals(counts.successCount)
		21.assertEquals(counts.failCount)
		0.assertEquals(counts.errorCount)

		val mr = assuranceCaseResult.modelResult.head
		val clR2lat = mr.claimResult.get(2)
		constructMessage(clR2lat).assertEquals("sensortoactuatorresponse with Latency property value [12 ms .. 18 ms]")
	}

}
