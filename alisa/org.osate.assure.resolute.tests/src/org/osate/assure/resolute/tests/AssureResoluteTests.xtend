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

package org.osate.assure.resolute.tests

import com.rockwellcollins.atc.resolute.resolute.ResoluteLibrary
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.alisa.workbench.alisa.AssuranceCase
import org.osate.assure.evaluator.AssureProcessor
import org.osate.assure.tests.AssureTests
import org.osate.verify.verify.Verification
import org.osate.verify.verify.VerificationMethodRegistry

import static extension org.junit.Assert.*
import static extension org.osate.assure.util.AssureUtilExtension.*

@RunWith(XtextRunner)
@InjectWith(FullAlisaInjectorProvider)
class AssureResoluteTests extends AssureTests {

	@Test
	override void ResoluteRegistrytest() {
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
	override void SCSAssuranceInstancetest() {
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
