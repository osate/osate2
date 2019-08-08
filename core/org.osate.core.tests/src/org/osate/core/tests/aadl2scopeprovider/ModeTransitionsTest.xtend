/*
 *
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.core.tests.aadl2scopeprovider

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.AssertHelper
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class ModeTransitionsTest extends XtextTest {

	@Inject
	TestHelper<AadlPackage> testHelper

	@Inject
	extension AssertHelper assertHelper

	//Tests scope_ModeTransition_source, scope_ModeTransition_destination, scope_ModeTransitionTrigger_context, and scope_ModeTransitionTrigger_triggerPort
	@Test
	def void testModeTransitions() {
		val aadlText = '''
			package ModeTransitionScopeTest
			public
				abstract a1
				prototypes
					fgproto1: feature group fgt1;
					aproto1: abstract a2.i;
					subpproto1: subprogram subp1.i;
					subpgproto1: subprogram group subpg1;
				features
					af1: feature;
					ep1: in event port;
					dp1: in data port a2.i;
					dp2: in data port aproto1;
					fg1: feature group fgt1;
					fg2: feature group fgproto1;
					subpa1: provides subprogram access subp1.i;
					subpa2: provides subprogram access subpproto1;
					subpga1: provides subprogram group access subpg1;
					subpga2: provides subprogram group access subpgproto1;
				end a1;
				
				abstract implementation a1.i
				subcomponents
					asub1: abstract a2.i;
					asub2: abstract aproto1;
					subpsub1: subprogram subp1.i;
					subpsub2: subprogram subpproto1;
					subpgsub1: subprogram group subpg1;
					subpgsub2: subprogram group subpg1 (subpproto5 => subprogram subp1.i);
					subpgsub3: subprogram group subpgproto1;
				internal features
					es1: event;
				processor features
					pp1: port;
				calls sequence1: {
					--Classifier
					call1: subprogram subp1.i;
					--SubprogramSubcomponent(->Classifier)
					call2: subprogram subpsub1;
					--SubprogramSubcomponent(->Prototype)
					call3: subprogram subpsub2;
					--Prototype
					call4: subprogram subpproto1;
					--SubprogramAccess(->Classifier)
					call5: subprogram subpa1;
					--SubprogramAccess(->Prototype)
					call6: subprogram subpa2;
					--Classifier.SubprogramAccess(->Prototype)
					call7: subprogram subp1.subpa4;
					--FeatureGroup(->FeatureGroupType).SubprogramAccess(->Prototype)
					call8: subprogram fg1.subpa3;
					--FeatureGroup(->FeatureGroupPrototype).SubprogramAccess(->Prototype)
«««					call9: subprogram fg2.subpa3;
					--SubprogramGroupAccess(->Classifier).SubprogramAccess(->Prototype)
«««					call10: subprogram subpga1.subpa5;
					--SubprogramGroupAccess(->Prototype).SubprogramAccess(->Prototype)
«««					call11: subprogram subpga2.subpa5;
					--SubprogramGroupSubcomponent(No Bindings; ->Classifier).SubprogramAccess(->Prototype)
					call12: subprogram subpgsub1.subpa5;
					--SubprogramGroupSubcomponent(With Binding for calledSubprogram's Prototype; ->Classifier).SubprogramAccess(->Prototype)
					call13: subprogram subpgsub2.subpa6;
					--SubprogramGroupSubcomponent(->Prototype).SubprogramAccess(->Prototype)
«««					call14: subprogram subpgsub3.subpa5;
				};
				modes
					m1: initial mode;
					m2: mode;
					mt1: m1 -[
						--null.TriggerPort
						af1,
						--FeatureGroup(->FeatureGroupType).TriggerPort
						fg1.af3,
						--FeatureGroup(->FeatureGroupPrototype).TriggerPort
						fg2.af3,
						--Feature(->Classifier).TriggerPort
						dp1.af2,
						--Feature(->Prototype).TriggerPort
						dp2.af2,
						--Subcomponent(->Classifier).TriggerPort
						asub1.af2,
						--Subcomponent(->Prototype).TriggerPort
						asub2.af2,
						--SubprogramCall(->Classifier).TriggerPort
						call1.af4,
						--SubprogramCall(->SubprogramSubcomponent->Classifier).TriggerPort
						call2.af4,
						--SubprogramCall(->SubprogramSubcomponent->Prototype).TriggerPort
						call3.af4,
						--SubprogramCall(->Prototype).TriggerPort
						call4.af4,
						--SubprogramCall(->SubprogramAccess->Classifier).TriggerPort
						call5.af4,
						--SubprogramCall(context->null; calledSubprogram->SubprogramAccess->Prototype).TriggerPort
						call6.af4,
						--SubprogramCall(context->Classifier; calledSubprogram->SubprogramAccess->Prototype).TriggerPort
						call7.af4,
						--SubprogramCall(context->FeatureGroup->FeatureGroupType; calledSubprogram->SubprogramAccess->Prototype).TriggerPort
						call8.af4,
						--SubprogramCall(context->FeatureGroup->FeatureGroupPrototype; calledSubprogram->SubprogramAccess->Prototype).TriggerPort
«««						call9.af4,
						--SubprogramCall(context->SubprogramGroupAccess->Classifier; calledSubprogram->SubprogramAccess->Prototype).TriggerPort
«««						call10.af4,
						--SubprogramCall(context->SubprogramGroupAccess->Prototype; calledSubprogram->SubprogramAccess->Prototype).TriggerPort
«««						call11.af4,
						--SubprogramCall(context->SubprogramGroupSubcomponent(No Bindings)->Classifier; calledSubprogram->SubprogramAccess->Prototype).TriggerPort
						call12.af4,
						--SubprogramCall(context->SubprogramGroupSubcomponent(With Binding for calledSubprogram's Prototype)->Classifier; calledSubprogram->SubprogramAccess->Prototype).TriggerPort
						call13.af4--,
						--SubprogramCall(context->SubprogramGroupSubcomponent->Prototype; calledSubprogram->SubprogramAccess->Prototype).TriggerPort
«««						call14.af4
					]-> m2;
				end a1.i;
				
				abstract a2
				features
					af2: feature;
					ep2: in event port;
				end a2;
				
				abstract implementation a2.i
				internal features
					es2: event;
				processor features
					pp2: port;
				end a2.i;
				
				feature group fgt1
				prototypes
					subpproto2: subprogram subp1.i;
				features
					af3: feature;
					ep3: in event port;
					subpa3: provides subprogram access subpproto2;
				end fgt1;
				
				subprogram subp1
				prototypes
					subpproto3: subprogram subp1.i;
				features
					af4: feature;
					ep4: out event port;
					subpa4: requires subprogram access subpproto3;
				end subp1;
				
				subprogram implementation subp1.i
				internal features
					es3: event;
				processor features
					pp3: port;
				end subp1.i;
				
				subprogram group subpg1
				prototypes
					subpproto4: subprogram subp1.i;
					subpproto5: subprogram;
				features
					subpa5: provides subprogram access subpproto4;
					subpa6: provides subprogram access subpproto5;
				end subpg1;
			end ModeTransitionScopeTest;
		'''
		// Variable issues must be initialized for call to assertConstraints()
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"ModeTransitionScopeTest".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				ownedModeTransitions.head => [
					"mt1".assertEquals(name)
					//Tests scope_ModeTransition_source
					assertScope(Aadl2Package::eINSTANCE.modeTransition_Source, #["m1", "m2"])
					//Tests scope_ModeTransitionTrigger_context
					assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
						"call4", "call5", "call6", "call7", "call8", "dp1", "dp2", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransition, EReference)
					assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af1", "dp1", "dp2", "ep1", "es1", "pp1"])
					ownedTriggers.get(0) => [
						context.assertNull
						"af1".assertEquals(triggerPort.name)
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af1", "dp1", "dp2", "ep1", "es1", "pp1"])
					]
					ownedTriggers.get(1) => [
						"fg1".assertEquals(context.name)
						"af3".assertEquals(triggerPort.name)
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af3", "ep3"])
					]
					ownedTriggers.get(2) => [
						"fg2".assertEquals(context.name)
						"af3".assertEquals(triggerPort.name)
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af3", "ep3"])
					]
					ownedTriggers.get(3) => [
						"dp1".assertEquals(context.name)
						"af2".assertEquals(triggerPort.name)
						assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid mode transition trigger.")
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af2", "ep2", "es2", "pp2"])
					]
					ownedTriggers.get(4) => [
						"dp2".assertEquals(context.name)
						"af2".assertEquals(triggerPort.name)
						assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid mode transition trigger.")
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af2", "ep2", "es2", "pp2"])
					]
					ownedTriggers.get(5) => [
						"asub1".assertEquals(context.name)
						"af2".assertEquals(triggerPort.name)
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af2", "ep2", "es2", "pp2"])
					]
					ownedTriggers.get(6) => [
						"asub2".assertEquals(context.name)
						"af2".assertEquals(triggerPort.name)
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af2", "ep2", "es2", "pp2"])
					]
					ownedTriggers.get(7) => [
						"call1".assertEquals(context.name)
						"af4".assertEquals(triggerPort.name)
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af4", "ep4", "es3", "pp3"])
					]
					ownedTriggers.get(8) => [
						"call2".assertEquals(context.name)
						"af4".assertEquals(triggerPort.name)
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af4", "ep4", "es3", "pp3"])
					]
					ownedTriggers.get(9) => [
						"call3".assertEquals(context.name)
						"af4".assertEquals(triggerPort.name)
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af4", "ep4", "es3", "pp3"])
					]
					ownedTriggers.get(10) => [
						"call4".assertEquals(context.name)
						"af4".assertEquals(triggerPort.name)
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af4", "ep4", "es3", "pp3"])
					]
					ownedTriggers.get(11) => [
						"call5".assertEquals(context.name)
						"af4".assertEquals(triggerPort.name)
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af4", "ep4", "es3", "pp3"])
					]
					ownedTriggers.get(12) => [
						"call6".assertEquals(context.name)
						"af4".assertEquals(triggerPort.name)
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af4", "ep4", "es3", "pp3"])
					]
					ownedTriggers.get(13) => [
						"call7".assertEquals(context.name)
						"af4".assertEquals(triggerPort.name)
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af4", "ep4", "es3", "pp3"])
					]
					ownedTriggers.get(14) => [
						"call8".assertEquals(context.name)
						"af4".assertEquals(triggerPort.name)
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af4", "ep4", "es3", "pp3"])
					]
					ownedTriggers.get(15) => [
						"call12".assertEquals(context.name)
						"af4".assertEquals(triggerPort.name)
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af4", "ep4", "es3", "pp3"])
					]
					ownedTriggers.get(16) => [
						"call13".assertEquals(context.name)
						"af4".assertEquals(triggerPort.name)
						//Tests scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger, EReference)
						assertScope(Aadl2Package::eINSTANCE.modeTransitionTrigger_TriggerPort, #["af4", "ep4", "es3", "pp3"])
					]
					//Tests scope_ModeTransition_destination
					assertScope(Aadl2Package::eINSTANCE.modeTransition_Destination, #["m1", "m2"])
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}