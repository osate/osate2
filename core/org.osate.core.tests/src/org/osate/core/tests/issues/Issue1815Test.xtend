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
package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.FlowSpecificationInstance

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1815Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1815/"
	val static NO_FLOW_PROPS = "NoFlowProps.aadl"
	
	val static TOP_IMPL = "Top.impl"
	val static SYSTEM_NAME = "Top_impl_Instance"
	
	val static FS = "fs"
	val static FS1 = "fs1"
	
	val static A1 = "a1"
	val static M1 = "m1"
	
	val static LATENCY = "Latency"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testSubcomponents1() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + NO_FLOW_PROPS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == TOP_IMPL] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(SYSTEM_NAME, instance.name)

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(0, messages.size)
		
		// find subcomponent a1
		val a1 = instance.componentInstances.findFirst[name == A1] as ComponentInstance
		checkPropertiesOfFlowSpecs(a1)
		
		// find subcomponent m1
		val m1 = instance.componentInstances.findFirst[name == M1] as ComponentInstance
		checkPropertiesOfFlowSpecs(m1)
		
		/* Check the system instance itself.  This is where the error was that we fixed.  The property
		 * association was missing from the flow spec instance 'fs' on the system instance.
		 */
		 checkPropertiesOfFlowSpecs(instance)

	}
	
	private def void checkPropertiesOfFlowSpecs(ComponentInstance ci) {
		checkForPropertyAssociation(ci, FS)
		checkForPropertyAssociation(ci, FS1)
	}
	
	/*
	 * Check that the given component instance has a flow spec with the given name, and that flow spec 
	 * has a LATENCY property association.
	 */
	private def void checkForPropertyAssociation(ComponentInstance ci, String flowSpecName) {
		val fs = ci.flowSpecifications.findFirst[name == flowSpecName] as FlowSpecificationInstance
		
		val propAssocs = fs.ownedPropertyAssociations
		assertEquals(1, propAssocs.size)
		
		val pa = propAssocs.get(0)
		assertEquals(LATENCY, pa.property.name)
	}
}

