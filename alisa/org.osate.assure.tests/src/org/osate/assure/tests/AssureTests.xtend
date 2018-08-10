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

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(FullAlisaInjectorProvider)  
class AssureTests extends XtextTest {
	@Inject
	TestHelper<AssuranceCase> alisaTestHelper

	val projectprefix = "org.osate.assure.tests/models/SimpleControlSystem/"
	val propertiesprefix = projectprefix+"Properties/"
	val aadlprefix = projectprefix+"aadl/"
	val alisaprefix = projectprefix+"alisa/"
	val resoluteprefix = projectprefix+"resolute/"

	@Test
	def void aadltest() {
		val pkg = alisaTestHelper.parseFile(alisaprefix+"SCSVerification.alisa"
			,aadlprefix+"SimpleControlSystem.aadl"
			,propertiesprefix+"ACVIP.aadl", propertiesprefix+"Physical.aadl",
			aadlprefix+"PhysicalResources.aadl",aadlprefix+"DataDictionary.aadl",
			aadlprefix+"Platform.aadl",aadlprefix+"Software.aadl", aadlprefix+"DigitalControlSystem.aadl"
			,alisaprefix+"sei.org" ,alisaprefix+"authors.constants" 
			,alisaprefix+"Resolute.methodregistry"
			,alisaprefix+"mymethods.methodregistry"
			,alisaprefix+"DCS.reqspec",alisaprefix+"dcsvplan.verify"
			,alisaprefix+"DualSCS.reqspec",alisaprefix+"dualscsvplan.verify"
			,alisaprefix+"globalReq.reqspec" ,alisaprefix+"GlobalVPlan.verify" 
			,alisaprefix+"Peter.reqspec" ,alisaprefix+"PeterPlan.verify" 
			,alisaprefix+"SCS.reqspec" ,alisaprefix+"scsvplan.verify" 
			,alisaprefix+"SCSImplementationReqs.reqspec" ,alisaprefix+"scsimplvplan.verify" 
			,alisaprefix+"SCSgoals2.goals"  
			, resoluteprefix+"BasicResolute.aadl", resoluteprefix+"BudgetResolute.aadl"
		)
		pkg => [
			"SimpleControlSystem".assertEquals(name)	
			
			]	
		}
	
}