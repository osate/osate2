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
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.alisa.workbench.alisa.AssuranceCase
import org.osate.testsupport.TestHelper
import org.osate.testsupport.TestResourceSetHelper

import static extension org.junit.Assert.*
import org.eclipse.emf.common.util.URI
import org.junit.Before
import org.osate.aadl2.PropertySet
import org.osate.organization.organization.Organization
import org.osate.reqspec.reqSpec.GlobalConstants
import org.osate.reqspec.reqSpec.ReqSpec
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.osate.organization.organization.Stakeholder
import org.osate.verify.verify.Verification
import org.osate.verify.verify.VerificationMethodRegistry

@RunWith(XtextRunner)
@InjectWith(FullAlisaInjectorProvider)  
class AssureTests extends XtextTest {
	@Inject
	TestHelper<AssuranceCase> alisaTestHelper
	@Inject extension ValidationTestHelper

	val projectprefix = "org.osate.assure.tests/models/SimpleControlSystem/"
	val propertiesprefix = projectprefix+"Properties/"
	val aadlprefix = projectprefix+"aadl/"
	val alisaprefix = projectprefix+"alisa/"
	val resoluteprefix = projectprefix+"resolute/"
	var primaryroot = null

	@Before
	def void setUp() {
		primaryroot = alisaTestHelper.parseFile(alisaprefix+"SCSVerification.alisa"
			,aadlprefix+"SimpleControlSystem.aadl"
			,propertiesprefix+"ACVIP.aadl", propertiesprefix+"Physical.aadl",
			aadlprefix+"PhysicalResources.aadl",aadlprefix+"DataDictionary.aadl",
			aadlprefix+"Platform.aadl",aadlprefix+"Software.aadl", aadlprefix+"DigitalControlSystem.aadl"
			,alisaprefix+"sei.org" ,alisaprefix+"authors.constants" 
			,alisaprefix+"Resolute.methodregistry"
			,alisaprefix+"Alisa_Consistency.methodregistry"
			,alisaprefix+"DCS.reqspec",alisaprefix+"dcsvplan.verify"
			,alisaprefix+"DualSCS.reqspec",alisaprefix+"dualscsvplan.verify"
			,alisaprefix+"globalReq.reqspec" ,alisaprefix+"GlobalVPlan.verify" 
			,alisaprefix+"Peter.reqspec" ,alisaprefix+"PeterPlan.verify" 
			,alisaprefix+"SCS.reqspec" ,alisaprefix+"scsvplan.verify" 
			,alisaprefix+"SCSImplementationReqs.reqspec" ,alisaprefix+"scsimplvplan.verify" 
			,alisaprefix+"SCSgoals2.goals"  
			, resoluteprefix+"BasicResolute.aadl", resoluteprefix+"BudgetResolute.aadl"
		)
	}


	@Test
	def void SEIOrgtest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix+"sei.org"), true)
		val org = scssrc.contents.get(0) as Organization
		org => [
			"sei".assertEquals(name)
			assertTrue(stakeholder.size > 1)	
			stakeholder.get(0) as Stakeholder => [
				"phf".assertEquals(name)
			]
			stakeholder.get(1) as Stakeholder => [
				"dpg".assertEquals(name)
			]
		]
		assertNoIssues(org)	
	}
	
	@Test
	def void Constantstest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix+"authors.constants"), true)
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
		val scssrc = rs.getResource(URI.createURI(propertiesprefix+"ACVIP.aadl"), true)
		val ps = scssrc.contents.get(0) as PropertySet
		ps => [
			"ACVIP".assertEquals(name)	
			2.assertEquals(ownedProperties.size)
			1.assertEquals(ownedPropertyConstants.size)
			]	
		assertNoIssues(ps)	
	}

	@Test
	def void PhysicalPropstest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(propertiesprefix+"Physical.aadl"), true)
		val ps = scssrc.contents.get(0) as PropertySet
		ps => [
			"Physical".assertEquals(name)	
			1.assertEquals(ownedProperties.size)
			2.assertEquals(ownedPropertyTypes.size)
			]	
		assertNoIssues(ps)	
	}

	@Test
	def void SCSAadltest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(aadlprefix+"SimpleControlSystem.aadl"), true)
		val pkg = scssrc.contents.get(0) as AadlPackage
		pkg => [
			"SimpleControlSystem".assertEquals(name)	
			7.assertEquals(publicSection.ownedClassifiers.size)
			]	
		assertNoIssues(pkg)	
	}


	@Test
	def void PhysicalResourcestest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(aadlprefix+"PhysicalResources.aadl"), true)
		val pkg = scssrc.contents.get(0) as AadlPackage
		pkg => [
			"PhysicalResources".assertEquals(name)	
			4.assertEquals(publicSection.ownedClassifiers.size)
			]	
		assertNoIssues(pkg)	
	}

	@Test
	def void DataDictionarystest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(aadlprefix+"DataDictionary.aadl"), true)
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
		val scssrc = rs.getResource(URI.createURI(aadlprefix+"Platform.aadl"), true)
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
		val scssrc = rs.getResource(URI.createURI(aadlprefix+"Software.aadl"), true)
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
		val scssrc = rs.getResource(URI.createURI(aadlprefix+"DigitalControlSystem.aadl"), true)
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
		val scssrc = rs.getResource(URI.createURI(alisaprefix+"Resolute.methodregistry"), true)
		val ver = scssrc.contents.get(0) as Verification
		val reg = ver.contents.get(0) as VerificationMethodRegistry
		reg => [
			"Resolute".assertEquals(name)	
			13.assertEquals(methods.size)
			]	
		assertNoIssues(reg)	
	}

	@Test
	def void Alisa_ConsistencyRegistrytest() {
		val ac = primaryroot as AssuranceCase
		val rs = ac.eResource.resourceSet
		val scssrc = rs.getResource(URI.createURI(alisaprefix+"Alisa_Consistency.methodregistry"), true)
		val ver = scssrc.contents.get(0) as Verification
		val reg = ver.contents.get(0) as VerificationMethodRegistry
		reg => [
			"Alisa_Consistency".assertEquals(name)	
			8.assertEquals(methods.size)
			]	
		assertNoIssues(reg)	
	}

//			,alisaprefix+"DCS.reqspec",alisaprefix+"dcsvplan.verify"
//			,alisaprefix+"DualSCS.reqspec",alisaprefix+"dualscsvplan.verify"
//			,alisaprefix+"globalReq.reqspec" ,alisaprefix+"GlobalVPlan.verify" 
//			,alisaprefix+"Peter.reqspec" ,alisaprefix+"PeterPlan.verify" 
//			,alisaprefix+"SCS.reqspec" ,alisaprefix+"scsvplan.verify" 
//			,alisaprefix+"SCSImplementationReqs.reqspec" ,alisaprefix+"scsimplvplan.verify" 
//			,alisaprefix+"SCSgoals2.goals"  
//			, resoluteprefix+"BasicResolute.aadl", resoluteprefix+"BudgetResolute.aadl"

	
}