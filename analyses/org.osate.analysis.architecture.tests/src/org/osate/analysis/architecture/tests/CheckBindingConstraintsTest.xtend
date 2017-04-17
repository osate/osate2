package org.osate.analysis.architecture.tests

import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.analysis.architecture.actions.CheckBindingConstraints
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals
import static extension org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile

@RunWith(XtextRunner2)
@InjectWith(Aadl2UiInjectorProvider)
class CheckBindingConstraintsTest extends OsateTest {
	override getProjectName() {
		"Check_Binding_Constraints_Test"
	}
	
	@Test
	def void testCheckBindingConstraints() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				system s1
					features
						dp1: in data port;
						dp2: in data port;
						edp1: in event data port;
						edp2: in event data port;
				end s1;
				
				system implementation s1.i
					subcomponents
						ps_sub1: process ps1.i;
						proc_sub1: processor proc1;
						proc_sub2: processor proc1;
						vp_sub1: virtual processor vp1;
						vp_sub2: virtual processor vp1;
						dev_sub1: device dev1;
						dev_sub2: device dev1;
						m_sub1: memory m1;
						m_sub2: memory m1;
						d_sub1: data d1;
						d_sub2: data d1;
						subp_sub1: subprogram subp1;
						subp_sub2: subprogram subp1;
						vb_sub1: virtual bus vb1;
						vb_sub2: virtual bus vb1;
					connections
						conn1: feature proc_sub1.af1 -> proc_sub2.af1;
						conn2: feature proc_sub1.af1 -> proc_sub2.af1;
					properties
						--Processor Binding
						
						Allowed_Processor_Binding => (reference(proc_sub1)) applies to ps_sub1.t_sub1;
						Actual_Processor_Binding => (reference(proc_sub2)) applies to ps_sub1.t_sub1;
						
						Allowed_Processor_Binding => (reference(proc_sub1)) applies to vp_sub1;
						Actual_Processor_Binding => (reference(proc_sub2)) applies to vp_sub1;
						
						Allowed_Processor_Binding => (reference(proc_sub1)) applies to dev_sub1;
						Actual_Processor_Binding => (reference(proc_sub2)) applies to dev_sub1;
						
						--Processor Binding Class
						
						Allowed_Processor_Binding_Class => (classifier(proc2)) applies to ps_sub1.t_sub2;
						Actual_Processor_Binding => (reference(proc_sub1)) applies to ps_sub1.t_sub2;
						
						Allowed_Processor_Binding_Class => (classifier(proc2)) applies to vp_sub2;
						Actual_Processor_Binding => (reference(proc_sub1)) applies to vp_sub2;
						
						Allowed_Processor_Binding_Class => (classifier(proc2)) applies to dev_sub2;
						Actual_Processor_Binding => (reference(proc_sub1)) applies to dev_sub2;
						
						
						
						--Memory Binding
						
						Allowed_Memory_Binding => (reference(m_sub1)) applies to ps_sub1.t_sub1;
						Actual_Memory_Binding => (reference(m_sub2)) applies to ps_sub1.t_sub1;
						
						Allowed_Memory_Binding => (reference(m_sub1)) applies to dev_sub1;
						Actual_Memory_Binding => (reference(m_sub2)) applies to dev_sub1;
						
						Allowed_Memory_Binding => (reference(m_sub1)) applies to d_sub1;
						Actual_Memory_Binding => (reference(m_sub2)) applies to d_sub1;
						
						Allowed_Memory_Binding => (reference(m_sub1)) applies to subp_sub1;
						Actual_Memory_Binding => (reference(m_sub2)) applies to subp_sub1;
						
						Allowed_Memory_Binding => (reference(m_sub1)) applies to proc_sub1;
						Actual_Memory_Binding => (reference(m_sub2)) applies to proc_sub1;
						
						Allowed_Memory_Binding => (reference(m_sub1)) applies to vp_sub1;
						Actual_Memory_Binding => (reference(m_sub2)) applies to vp_sub1;
						
						Allowed_Memory_Binding => (reference(m_sub1)) applies to dp1;
						Actual_Memory_Binding => (reference(m_sub2)) applies to dp1;
						
						Allowed_Memory_Binding => (reference(m_sub1)) applies to edp1;
						Actual_Memory_Binding => (reference(m_sub2)) applies to edp1;
						
						--Memory Binding Class
						
						Allowed_Memory_Binding_Class => (classifier(m2)) applies to ps_sub1.t_sub2;
						Actual_Memory_Binding => (reference(m_sub1)) applies to ps_sub1.t_sub2;
						
						Allowed_Memory_Binding_Class => (classifier(m2)) applies to dev_sub2;
						Actual_Memory_Binding => (reference(m_sub1)) applies to dev_sub2;
						
						Allowed_Memory_Binding_Class => (classifier(m2)) applies to d_sub2;
						Actual_Memory_Binding => (reference(m_sub1)) applies to d_sub2;
						
						Allowed_Memory_Binding_Class => (classifier(m2)) applies to subp_sub2;
						Actual_Memory_Binding => (reference(m_sub1)) applies to subp_sub2;
						
						Allowed_Memory_Binding_Class => (classifier(m2)) applies to proc_sub2;
						Actual_Memory_Binding => (reference(m_sub1)) applies to proc_sub2;
						
						Allowed_Memory_Binding_Class => (classifier(m2)) applies to vp_sub2;
						Actual_Memory_Binding => (reference(m_sub1)) applies to vp_sub2;
						
						Allowed_Memory_Binding_Class => (classifier(m2)) applies to dp2;
						Actual_Memory_Binding => (reference(m_sub1)) applies to dp2;
						
						Allowed_Memory_Binding_Class => (classifier(m2)) applies to edp2;
						Actual_Memory_Binding => (reference(m_sub1)) applies to edp2;
						
						
						
						--Connection Binding
						
						Allowed_Connection_Binding => (reference(m_sub1)) applies to dp1;
						Actual_Connection_Binding => (reference(m_sub2)) applies to dp1;
						
						Allowed_Connection_Binding => (reference(m_sub1)) applies to conn1;
						Actual_Connection_Binding => (reference(m_sub2)) applies to conn1;
						
						Allowed_Connection_Binding => (reference(m_sub1)) applies to ps_sub1.t_sub1;
						Actual_Connection_Binding => (reference(m_sub2)) applies to ps_sub1.t_sub1;
						
						Allowed_Connection_Binding => (reference(m_sub1)) applies to vb_sub1;
						Actual_Connection_Binding => (reference(m_sub2)) applies to vb_sub1;
						
						--Connection Binding Class
						
						Allowed_Connection_Binding_Class => (classifier(proc2)) applies to dp2;
						Actual_Connection_Binding => (reference(proc_sub1)) applies to dp2;
						
						Allowed_Connection_Binding_Class => (classifier(proc2)) applies to conn2;
						Actual_Connection_Binding => (reference(proc_sub1)) applies to conn2;
						
						Allowed_Connection_Binding_Class => (classifier(proc2)) applies to ps_sub1.t_sub2;
						Actual_Connection_Binding => (reference(proc_sub1)) applies to ps_sub1.t_sub2;
						
						Allowed_Connection_Binding_Class => (classifier(proc2)) applies to vb_sub2;
						Actual_Connection_Binding => (reference(proc_sub1)) applies to vb_sub2;
				end s1.i;
				
				process ps1
				end ps1;
				
				process implementation ps1.i
					subcomponents
						t_sub1: thread t1;
						t_sub2: thread t1;
				end ps1.i;
				
				processor proc1
					features
						af1: feature;
				end proc1;
				
				processor proc2
				end proc2;
				
				thread t1
				end t1;
				
				virtual processor vp1
				end vp1;
				
				device dev1
				end dev1;
				
				memory m1
				end m1;
				
				memory m2
				end m2;
				
				data d1
				end d1;
				
				subprogram subp1
				end subp1;
				
				virtual bus vb1
				end vb1;
			end pkg1;
		''')
		suppressSerialization
		testFile(pkg1FileName).resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i".assertEquals(name)
				buildInstanceModelFile => [
					"s1_i_Instance".assertEquals(name)
					val issues = CheckBindingConstraints.runAnalysis(new NullProgressMonitor, it)
					30.assertEquals(issues.size)
					issues.get(0) => [
						"s1_i_Instance.dev_sub1".assertEquals(target.instanceObjectPath)
						"Device 'dev_sub1' has a processor binding to 'proc_sub2' which is not allowed by the property Allowed_Processor_Binding".assertEquals(message)
					]
					issues.get(1) => [
						"s1_i_Instance.dev_sub2".assertEquals(target.instanceObjectPath)
						"Device 'dev_sub2' has a processor binding to 'proc_sub1' which is not allowed by the property Allowed_Processor_Binding_Class".assertEquals(message)
					]
					issues.get(2) => [
						"s1_i_Instance.ps_sub1.t_sub1".assertEquals(target.instanceObjectPath)
						"Thread 't_sub1' has a processor binding to 'proc_sub2' which is not allowed by the property Allowed_Processor_Binding".assertEquals(message)
					]
					issues.get(3) => [
						"s1_i_Instance.ps_sub1.t_sub2".assertEquals(target.instanceObjectPath)
						"Thread 't_sub2' has a processor binding to 'proc_sub1' which is not allowed by the property Allowed_Processor_Binding_Class".assertEquals(message)
					]
					issues.get(4) => [
						"s1_i_Instance.vp_sub1".assertEquals(target.instanceObjectPath)
						"Virtual processor 'vp_sub1' has a processor binding to 'proc_sub2' which is not allowed by the property Allowed_Processor_Binding".assertEquals(message)
					]
					issues.get(5) => [
						"s1_i_Instance.vp_sub2".assertEquals(target.instanceObjectPath)
						"Virtual processor 'vp_sub2' has a processor binding to 'proc_sub1' which is not allowed by the property Allowed_Processor_Binding_Class".assertEquals(message)
					]
					issues.get(6) => [
						"s1_i_Instance.d_sub1".assertEquals(target.instanceObjectPath)
						"Data 'd_sub1' has a memory binding to 'm_sub2' which is not allowed by the property Allowed_Memory_Binding".assertEquals(message)
					]
					issues.get(7) => [
						"s1_i_Instance.d_sub2".assertEquals(target.instanceObjectPath)
						"Data 'd_sub2' has a memory binding to 'm_sub1' which is not allowed by the property Allowed_Memory_Binding_Class".assertEquals(message)
					]
					issues.get(8) => [
						"s1_i_Instance.dev_sub1".assertEquals(target.instanceObjectPath)
						"Device 'dev_sub1' has a memory binding to 'm_sub2' which is not allowed by the property Allowed_Memory_Binding".assertEquals(message)
					]
					issues.get(9) => [
						"s1_i_Instance.dev_sub2".assertEquals(target.instanceObjectPath)
						"Device 'dev_sub2' has a memory binding to 'm_sub1' which is not allowed by the property Allowed_Memory_Binding_Class".assertEquals(message)
					]
					issues.get(10) => [
						"s1_i_Instance.ps_sub1.t_sub1".assertEquals(target.instanceObjectPath)
						"Thread 't_sub1' has a memory binding to 'm_sub2' which is not allowed by the property Allowed_Memory_Binding".assertEquals(message)
					]
					issues.get(11) => [
						"s1_i_Instance.ps_sub1.t_sub2".assertEquals(target.instanceObjectPath)
						"Thread 't_sub2' has a memory binding to 'm_sub1' which is not allowed by the property Allowed_Memory_Binding_Class".assertEquals(message)
					]
					issues.get(12) => [
						"s1_i_Instance.proc_sub1".assertEquals(target.instanceObjectPath)
						"Processor 'proc_sub1' has a memory binding to 'm_sub2' which is not allowed by the property Allowed_Memory_Binding".assertEquals(message)
					]
					issues.get(13) => [
						"s1_i_Instance.proc_sub2".assertEquals(target.instanceObjectPath)
						"Processor 'proc_sub2' has a memory binding to 'm_sub1' which is not allowed by the property Allowed_Memory_Binding_Class".assertEquals(message)
					]
					issues.get(14) => [
						"s1_i_Instance.subp_sub1".assertEquals(target.instanceObjectPath)
						"Subprogram 'subp_sub1' has a memory binding to 'm_sub2' which is not allowed by the property Allowed_Memory_Binding".assertEquals(message)
					]
					issues.get(15) => [
						"s1_i_Instance.subp_sub2".assertEquals(target.instanceObjectPath)
						"Subprogram 'subp_sub2' has a memory binding to 'm_sub1' which is not allowed by the property Allowed_Memory_Binding_Class".assertEquals(message)
					]
					issues.get(16) => [
						"s1_i_Instance.vp_sub1".assertEquals(target.instanceObjectPath)
						"Virtual processor 'vp_sub1' has a memory binding to 'm_sub2' which is not allowed by the property Allowed_Memory_Binding".assertEquals(message)
					]
					issues.get(17) => [
						"s1_i_Instance.vp_sub2".assertEquals(target.instanceObjectPath)
						"Virtual processor 'vp_sub2' has a memory binding to 'm_sub1' which is not allowed by the property Allowed_Memory_Binding_Class".assertEquals(message)
					]
					issues.get(18) => [
						"s1_i_Instance.dp1".assertEquals(target.instanceObjectPath)
						"Data Port 'dp1' has a memory binding to 'm_sub2' which is not allowed by the property Allowed_Memory_Binding".assertEquals(message)
					]
					issues.get(19) => [
						"s1_i_Instance.dp2".assertEquals(target.instanceObjectPath)
						"Data Port 'dp2' has a memory binding to 'm_sub1' which is not allowed by the property Allowed_Memory_Binding_Class".assertEquals(message)
					]
					issues.get(20) => [
						"s1_i_Instance.edp1".assertEquals(target.instanceObjectPath)
						"Event Data Port 'edp1' has a memory binding to 'm_sub2' which is not allowed by the property Allowed_Memory_Binding".assertEquals(message)
					]
					issues.get(21) => [
						"s1_i_Instance.edp2".assertEquals(target.instanceObjectPath)
						"Event Data Port 'edp2' has a memory binding to 'm_sub1' which is not allowed by the property Allowed_Memory_Binding_Class".assertEquals(message)
					]
					issues.get(22) => [
						"s1_i_Instance.ps_sub1.t_sub1".assertEquals(target.instanceObjectPath)
						"Thread 't_sub1' has a connection binding to 'm_sub2' which is not allowed by the property Allowed_Connection_Binding".assertEquals(message)
					]
					issues.get(23) => [
						"s1_i_Instance.ps_sub1.t_sub2".assertEquals(target.instanceObjectPath)
						"Thread 't_sub2' has a connection binding to 'proc_sub1' which is not allowed by the property Allowed_Connection_Binding_Class".assertEquals(message)
					]
					issues.get(24) => [
						"s1_i_Instance.vb_sub1".assertEquals(target.instanceObjectPath)
						"Virtual bus 'vb_sub1' has a connection binding to 'm_sub2' which is not allowed by the property Allowed_Connection_Binding".assertEquals(message)
					]
					issues.get(25) => [
						"s1_i_Instance.vb_sub2".assertEquals(target.instanceObjectPath)
						"Virtual bus 'vb_sub2' has a connection binding to 'proc_sub1' which is not allowed by the property Allowed_Connection_Binding_Class".assertEquals(message)
					]
					issues.get(26) => [
						"s1_i_Instance.dp1".assertEquals(target.instanceObjectPath)
						"Data Port 'dp1' has a connection binding to 'm_sub2' which is not allowed by the property Allowed_Connection_Binding".assertEquals(message)
					]
					issues.get(27) => [
						"s1_i_Instance.dp2".assertEquals(target.instanceObjectPath)
						"Data Port 'dp2' has a connection binding to 'proc_sub1' which is not allowed by the property Allowed_Connection_Binding_Class".assertEquals(message)
					]
					issues.get(28) => [
						"s1_i_Instance.proc_sub1.af1 -> proc_sub2.af1".assertEquals(target.instanceObjectPath)
						"Connection 'proc_sub1.af1 -> proc_sub2.af1' has a connection binding to 'm_sub2' which is not allowed by the property Allowed_Connection_Binding".assertEquals(message)
					]
					issues.get(29) => [
						"s1_i_Instance.proc_sub1.af1 -> proc_sub2.af1".assertEquals(target.instanceObjectPath)
						"Connection 'proc_sub1.af1 -> proc_sub2.af1' has a connection binding to 'proc_sub1' which is not allowed by the property Allowed_Connection_Binding_Class".assertEquals(message)
					]
				]
			]
		]
	}
}