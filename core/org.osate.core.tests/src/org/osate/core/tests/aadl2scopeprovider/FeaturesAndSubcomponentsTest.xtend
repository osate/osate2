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
package org.osate.core.tests.aadl2scopeprovider

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.AbstractType
import org.osate.aadl2.FeatureGroupType
import org.osate.aadl2.SubprogramType
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.AssertHelper
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class FeaturesAndSubcomponentsTest extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Inject
	extension AssertHelper
	
	/*
	 * Tests scope_AbstractSubcomponent_abstractSubcomponentType, scope_SystemSubcomponent_systemSubcomponentType,
	 * scope_ProcessSubcomponent_processSubcomponentType, scope_ThreadGroupSubcomponent_threadGroupSubcomponentType,
	 * scope_ThreadSubcomponent_threadSubcomponentType, scope_SubprogramSubcomponent_subprogramSubcomponentType,
	 * scope_SubprogramGroupSubcomponent_subprogramGroupSubcomponentType, scope_ProcessorSubcomponent_processorSubcomponentType,
	 * scope_VirtualProcessorSubcomponent_virtualProcessorSubcomponentType, scope_DeviceSubcomponent_deviceSubcomponentType,
	 * scope_MemorySubcomponent_memorySubcomponentType, scope_BusSubcomponent_busSubcomponentType, scope_VirtualBusSubcomponent_virtualBusSubcomponentType,
	 * scope_DataSubcomponent_dataSubcomponentType, scope_DataPort_dataFeatureClassifier, scope_EventDataPort_dataFeatureClassifier,
	 * scope_FeatureGroup_featureType, scope_Parameter_dataFeatureClassifier, scope_SubprogramAccess_subprogramFeatureClassifier,
	 * scope_SubprogramGroupAccess_subprogramGroupFeatureClassifier, scope_BusAccess_busFeatureClassifier, scope_DataAccess_dataFeatureClassifier,
	 * and scope_AbstractFeature_featurePrototype
	 */
	 @Test
	def void testFeaturesAndSubcomponents() {
		val pack1 = '''
				package pack1
				public
				  with pack5;
				  
				  renames pack3::all;
				  renamed_package renames package pack4;
				  
				  renames abstract pack5::a5;
				  renames system pack5::s5;
				  renames process pack5::p5;
				  renames thread group pack5::tg5;
				  renames thread pack5::t5;
				  renames subprogram pack5::sub5;
				  renames subprogram group pack5::subg5;
				  renames processor pack5::proc5;
				  renames virtual processor pack5::vp5;
				  renames device pack5::dev5;
				  renames memory pack5::m5;
				  renames bus pack5::b5;
				  renames virtual bus pack5::vb5;
				  renames data pack5::d5;
				  renames feature group pack5::fgt5;
				  
				  ra renames abstract pack5::a6;
				  rs renames system pack5::s6;
				  rp renames process pack5::p6;
				  rtg renames thread group pack5::tg6;
				  rt renames thread pack5::t6;
				  rsub renames subprogram pack5::sub6;
				  rsubg renames subprogram group pack5::subg6;
				  rproc renames processor pack5::proc6;
				  rvp renames virtual processor pack5::vp6;
				  rdev renames device pack5::dev6;
				  rm renames memory pack5::m6;
				  rb renames bus pack5::b6;
				  rvb renames virtual bus pack5::vb6;
				  rd renames data pack5::d6;
				  rfgt renames feature group pack5::fgt6;
				  
				  abstract container
				  prototypes
				    aproto1: abstract;
				    sproto1: system;
				    pproto1: process;
				    tgproto1: thread group;
				    tproto1: thread;
				    subproto1: subprogram;
				    subgproto1: subprogram group;
				    procproto1: processor;
				    vpproto1: virtual processor;
				    devproto1: device;
				    mproto1: memory;
				    bproto1: bus;
				    vbproto1: virtual bus;
				    dproto1: data;
				    fgproto1: feature group;
				    fproto1: feature;
				  features
				    dport1: in data port d1;
				    edport1: in event data port d1;
				    fg1: feature group fgt1;
				    suba1: provides subprogram access sub1;
				    subga1: provides subprogram group access subg1;
				    ba1: provides bus access b1;
				    da1: provides data access d1;
				    af1: prototype fproto1;
				  end container;
				  
				  abstract implementation container.i
				  subcomponents
				    asub: abstract a1;
				    ssub: system s1;
				    psub: process p1;
				    tgsub: thread group tg1;
				    tsub: thread t1;
				    subsub: subprogram sub1;
				    subgsub: subprogram group subg1;
				    procsub: processor proc1;
				    vpsub: virtual processor vp1;
				    devsub: device dev1;
				    msub: memory m1;
				    bsub: bus b1;
				    vbsub: virtual bus vb1;
				    dsub: data d1;
				  end container.i;
				  
				  subprogram subcontainer
				  prototypes
				    aproto2: abstract;
				    sproto2: system;
				    pproto2: process;
				    tgproto2: thread group;
				    tproto2: thread;
				    subproto2: subprogram;
				    subgproto2: subprogram group;
				    procproto2: processor;
				    vpproto2: virtual processor;
				    devproto2: device;
				    mproto2: memory;
				    bproto2: bus;
				    vbproto2: virtual bus;
				    dproto2: data;
				    fgproto2: feature group;
				    fproto2: feature;
				  features
				    param1: in parameter d1;
				  end subcontainer;
				  
				  feature group fgtcontainer
				  prototypes
				    aproto3: abstract;
				    sproto3: system;
				    pproto3: process;
				    tgproto3: thread group;
				    tproto3: thread;
				    subproto3: subprogram;
				    subgproto3: subprogram group;
				    procproto3: processor;
				    vpproto3: virtual processor;
				    devproto3: device;
				    mproto3: memory;
				    bproto3: bus;
				    vbproto3: virtual bus;
				    dproto3: data;
				    fgproto3: feature group;
				    fproto3: feature;
				  features
				    dport2: in data port d1;
				    edport2: in event data port d1;
				    fg2: feature group fgt1;
				    param2: in parameter d1;
				    suba2: provides subprogram access sub1;
				    subga2: provides subprogram group access subg1;
				    ba2: provides bus access b1;
				    da2: provides data access d1;
				    af2: prototype fproto3;
				  end fgtcontainer;
				  
				  abstract a1
				  end a1;
				  
				  abstract implementation a1.i
				  end a1.i;
				  
				  system s1
				  end s1;
				  
				  system implementation s1.i
				  end s1.i;
				  
				  process p1
				  end p1;
				  
				  process implementation p1.i
				  end p1.i;
				  
				  thread group tg1
				  end tg1;
				  
				  thread group implementation tg1.i
				  end tg1.i;
				  
				  thread t1
				  end t1;
				  
				  thread implementation t1.i
				  end t1.i;
				  
				  subprogram sub1
				  end sub1;
				  
				  subprogram implementation sub1.i
				  end sub1.i;
				  
				  subprogram group subg1
				  end subg1;
				  
				  subprogram group implementation subg1.i
				  end subg1.i;
				  
				  processor proc1
				  end proc1;
				  
				  processor implementation proc1.i
				  end proc1.i;
				  
				  virtual processor vp1
				  end vp1;
				  
				  virtual processor implementation vp1.i
				  end vp1.i;
				  
				  device dev1
				  end dev1;
				  
				  device implementation dev1.i
				  end dev1.i;
				  
				  memory m1
				  end m1;
				  
				  memory implementation m1.i
				  end m1.i;
				  
				  bus b1
				  end b1;
				  
				  bus implementation b1.i
				  end b1.i;
				  
				  virtual bus vb1
				  end vb1;
				  
				  virtual bus implementation vb1.i
				  end vb1.i;
				  
				  data d1
				  end d1;
				  
				  data implementation d1.i
				  end d1.i;
				  
				  feature group fgt1
				  end fgt1;
				end pack1;
			'''
		val pack2 = '''
				package pack2
				public
				  abstract a2
				  end a2;
				  
				  abstract implementation a2.i
				  end a2.i;
				  
				  system s2
				  end s2;
				  
				  system implementation s2.i
				  end s2.i;
				  
				  process p2
				  end p2;
				  
				  process implementation p2.i
				  end p2.i;
				  
				  thread group tg2
				  end tg2;
				  
				  thread group implementation tg2.i
				  end tg2.i;
				  
				  thread t2
				  end t2;
				  
				  thread implementation t2.i
				  end t2.i;
				  
				  subprogram sub2
				  end sub2;
				  
				  subprogram implementation sub2.i
				  end sub2.i;
				  
				  subprogram group subg2
				  end subg2;
				  
				  subprogram group implementation subg2.i
				  end subg2.i;
				  
				  processor proc2
				  end proc2;
				  
				  processor implementation proc2.i
				  end proc2.i;
				  
				  virtual processor vp2
				  end vp2;
				  
				  virtual processor implementation vp2.i
				  end vp2.i;
				  
				  device dev2
				  end dev2;
				  
				  device implementation dev2.i
				  end dev2.i;
				  
				  memory m2
				  end m2;
				  
				  memory implementation m2.i
				  end m2.i;
				  
				  bus b2
				  end b2;
				  
				  bus implementation b2.i
				  end b2.i;
				  
				  virtual bus vb2
				  end vb2;
				  
				  virtual bus implementation vb2.i
				  end vb2.i;
				  
				  data d2
				  end d2;
				  
				  data implementation d2.i
				  end d2.i;
				  
				  feature group fgt2
				  end fgt2;
				end pack2;
			'''
		val pack3 = '''
				package pack3
				public
				  abstract a3
				  end a3;
				  
				  abstract implementation a3.i
				  end a3.i;
				  
				  system s3
				  end s3;
				  
				  system implementation s3.i
				  end s3.i;
				  
				  process p3
				  end p3;
				  
				  process implementation p3.i
				  end p3.i;
				  
				  thread group tg3
				  end tg3;
				  
				  thread group implementation tg3.i
				  end tg3.i;
				  
				  thread t3
				  end t3;
				  
				  thread implementation t3.i
				  end t3.i;
				  
				  subprogram sub3
				  end sub3;
				  
				  subprogram implementation sub3.i
				  end sub3.i;
				  
				  subprogram group subg3
				  end subg3;
				  
				  subprogram group implementation subg3.i
				  end subg3.i;
				  
				  processor proc3
				  end proc3;
				  
				  processor implementation proc3.i
				  end proc3.i;
				  
				  virtual processor vp3
				  end vp3;
				  
				  virtual processor implementation vp3.i
				  end vp3.i;
				  
				  device dev3
				  end dev3;
				  
				  device implementation dev3.i
				  end dev3.i;
				  
				  memory m3
				  end m3;
				  
				  memory implementation m3.i
				  end m3.i;
				  
				  bus b3
				  end b3;
				  
				  bus implementation b3.i
				  end b3.i;
				  
				  virtual bus vb3
				  end vb3;
				  
				  virtual bus implementation vb3.i
				  end vb3.i;
				  
				  data d3
				  end d3;
				  
				  data implementation d3.i
				  end d3.i;
				  
				  feature group fgt3
				  end fgt3;
				end pack3;
			'''
		val pack4 = '''
				package pack4
				public
				  abstract a4
				  end a4;
				  
				  abstract implementation a4.i
				  end a4.i;
				  
				  system s4
				  end s4;
				  
				  system implementation s4.i
				  end s4.i;
				  
				  process p4
				  end p4;
				  
				  process implementation p4.i
				  end p4.i;
				  
				  thread group tg4
				  end tg4;
				  
				  thread group implementation tg4.i
				  end tg4.i;
				  
				  thread t4
				  end t4;
				  
				  thread implementation t4.i
				  end t4.i;
				  
				  subprogram sub4
				  end sub4;
				  
				  subprogram implementation sub4.i
				  end sub4.i;
				  
				  subprogram group subg4
				  end subg4;
				  
				  subprogram group implementation subg4.i
				  end subg4.i;
				  
				  processor proc4
				  end proc4;
				  
				  processor implementation proc4.i
				  end proc4.i;
				  
				  virtual processor vp4
				  end vp4;
				  
				  virtual processor implementation vp4.i
				  end vp4.i;
				  
				  device dev4
				  end dev4;
				  
				  device implementation dev4.i
				  end dev4.i;
				  
				  memory m4
				  end m4;
				  
				  memory implementation m4.i
				  end m4.i;
				  
				  bus b4
				  end b4;
				  
				  bus implementation b4.i
				  end b4.i;
				  
				  virtual bus vb4
				  end vb4;
				  
				  virtual bus implementation vb4.i
				  end vb4.i;
				  
				  data d4
				  end d4;
				  
				  data implementation d4.i
				  end d4.i;
				  
				  feature group fgt4
				  end fgt4;
				end pack4;
			'''
		val pack5 = '''
				package pack5
				public
				  abstract a5
				  end a5;
				  
				  abstract implementation a5.i
				  end a5.i;
				  
				  system s5
				  end s5;
				  
				  system implementation s5.i
				  end s5.i;
				  
				  process p5
				  end p5;
				  
				  process implementation p5.i
				  end p5.i;
				  
				  thread group tg5
				  end tg5;
				  
				  thread group implementation tg5.i
				  end tg5.i;
				  
				  thread t5
				  end t5;
				  
				  thread implementation t5.i
				  end t5.i;
				  
				  subprogram sub5
				  end sub5;
				  
				  subprogram implementation sub5.i
				  end sub5.i;
				  
				  subprogram group subg5
				  end subg5;
				  
				  subprogram group implementation subg5.i
				  end subg5.i;
				  
				  processor proc5
				  end proc5;
				  
				  processor implementation proc5.i
				  end proc5.i;
				  
				  virtual processor vp5
				  end vp5;
				  
				  virtual processor implementation vp5.i
				  end vp5.i;
				  
				  device dev5
				  end dev5;
				  
				  device implementation dev5.i
				  end dev5.i;
				  
				  memory m5
				  end m5;
				  
				  memory implementation m5.i
				  end m5.i;
				  
				  bus b5
				  end b5;
				  
				  bus implementation b5.i
				  end b5.i;
				  
				  virtual bus vb5
				  end vb5;
				  
				  virtual bus implementation vb5.i
				  end vb5.i;
				  
				  data d5
				  end d5;
				  
				  data implementation d5.i
				  end d5.i;
				  
				  feature group fgt5
				  end fgt5;
				  
				  abstract a6
				  end a6;
				  
				  system s6
				  end s6;
				  
				  process p6
				  end p6;
				  
				  thread group tg6
				  end tg6;
				  
				  thread t6
				  end t6;
				  
				  subprogram sub6
				  end sub6;
				  
				  subprogram group subg6
				  end subg6;
				  
				  processor proc6
				  end proc6;
				  
				  virtual processor vp6
				  end vp6;
				  
				  device dev6
				  end dev6;
				  
				  memory m6
				  end m6;
				  
				  bus b6
				  end b6;
				  
				  virtual bus vb6
				  end vb6;
				  
				  data d6
				  end d6;
				  
				  feature group fgt6
				  end fgt6;
				end pack5;
			'''
		val pkg = testHelper.parseString(pack1, pack2, pack3, pack4, pack5)
		pkg => [
			"pack1".assertEquals(name)
			publicSection.ownedClassifiers.get(0) as AbstractType => [
				"container".assertEquals(name)
				ownedDataPorts.head => [
					"dport1".assertEquals(name)
					//Tests scope_DataPort_dataFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.dataPort_DataFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto1", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
				ownedEventDataPorts.head => [
					"edport1".assertEquals(name)
					//Tests scope_EventDataPort_dataFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.eventDataPort_DataFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto1", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
				ownedFeatureGroups.head => [
					"fg1".assertEquals(name)
					//Tests scope_FeatureGroup_featureType
					assertScope(Aadl2Package::eINSTANCE.featureGroup_FeatureType, #["fgproto1", "fgt1", "fgt3", "fgt5", "fgtcontainer", "rfgt",
						"pack1::fgt1", "pack1::fgtcontainer", "pack2::fgt2", "pack3::fgt3", "pack4::fgt4", "pack5::fgt5", "pack5::fgt6",
						"renamed_package::fgt4"
					])
				]
				ownedSubprogramAccesses.head => [
					"suba1".assertEquals(name)
					//Tests scope_SubprogramAccess_subprogramFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.subprogramAccess_SubprogramFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "ra", "rsub", "sub1", "sub1.i", "sub3", "sub3.i", "sub5", "subcontainer", "subproto1", "pack1::a1",
						"pack1::a1.i", "pack1::container", "pack1::container.i", "pack1::sub1", "pack1::sub1.i", "pack1::subcontainer", "pack2::a2",
						"pack2::a2.i", "pack2::sub2", "pack2::sub2.i", "pack3::a3", "pack3::a3.i", "pack3::sub3", "pack3::sub3.i", "pack4::a4", "pack4::a4.i",
						"pack4::sub4", "pack4::sub4.i", "pack5::a5", "pack5::a5.i", "pack5::a6", "pack5::sub5", "pack5::sub5.i", "pack5::sub6",
						"renamed_package::a4", "renamed_package::a4.i", "renamed_package::sub4", "renamed_package::sub4.i"
					])
				]
				ownedSubprogramGroupAccesses.head => [
					"subga1".assertEquals(name)
					//Tests scope_SubprogramGroupAccess_subprogramGroupFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.subprogramGroupAccess_SubprogramGroupFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5",
						"aproto1", "container", "container.i", "ra", "rsubg", "subg1", "subg1.i", "subg3", "subg3.i", "subg5", "subgproto1", "pack1::a1",
						"pack1::a1.i", "pack1::container", "pack1::container.i", "pack1::subg1", "pack1::subg1.i", "pack2::a2", "pack2::a2.i", "pack2::subg2",
						"pack2::subg2.i", "pack3::a3", "pack3::a3.i", "pack3::subg3", "pack3::subg3.i", "pack4::a4", "pack4::a4.i", "pack4::subg4",
						"pack4::subg4.i", "pack5::a5", "pack5::a5.i", "pack5::a6", "pack5::subg5", "pack5::subg5.i", "pack5::subg6", "renamed_package::a4",
						"renamed_package::a4.i", "renamed_package::subg4", "renamed_package::subg4.i"
					])
				]
				ownedBusAccesses.head => [
					"ba1".assertEquals(name)
					//Tests scope_BusAccess_busFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.busAccess_BusFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1", "b1", "b1.i",
						"b3", "b3.i", "b5", "bproto1", "container", "container.i", "ra", "rb", "rvb", "vb1", "vb1.i", "vb3", "vb3.i", "vb5", "vbproto1", "pack1::a1", "pack1::a1.i", "pack1::b1", "pack1::b1.i",
						"pack1::container", "pack1::container.i", "pack1::vb1", "pack1::vb1.i", "pack2::a2", "pack2::a2.i", "pack2::b2", "pack2::b2.i", "pack2::vb2", "pack2::vb2.i", "pack3::a3", "pack3::a3.i",
						"pack3::b3", "pack3::b3.i", "pack3::vb3", "pack3::vb3.i", "pack4::a4", "pack4::a4.i", "pack4::b4", "pack4::b4.i", "pack4::vb4", "pack4::vb4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::b5", "pack5::b5.i", "pack5::b6", "pack5::vb5", "pack5::vb5.i", "pack5::vb6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::b4", "renamed_package::b4.i", "renamed_package::vb4", "renamed_package::vb4.i"
					])
				]
				ownedDataAccesses.head => [
					"da1".assertEquals(name)
					//Tests scope_DataAccess_dataFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.dataAccess_DataFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto1", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
				ownedAbstractFeatures.head => [
					"af1".assertEquals(name)
					//Tests scope_AbstractFeature_featurePrototype
					assertScope(Aadl2Package::eINSTANCE.abstractFeature_FeaturePrototype, #["fproto1"])
				]
			]
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"container.i".assertEquals(name)
				ownedAbstractSubcomponents.head => [
					"asub".assertEquals(name)
					//Tests scope_AbstractSubcomponent_abstractSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.abstractSubcomponent_AbstractSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "ra", "pack1::a1", "pack1::a1.i", "pack1::container", "pack1::container.i", "pack2::a2", "pack2::a2.i",
						"pack3::a3", "pack3::a3.i", "pack4::a4", "pack4::a4.i", "pack5::a5", "pack5::a5.i", "pack5::a6", "renamed_package::a4",
						"renamed_package::a4.i"
					])
				]
				ownedSystemSubcomponents.head => [
					"ssub".assertEquals(name)
					//Tests scope_SystemSubcomponent_systemSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.systemSubcomponent_SystemSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "ra", "rs", "s1", "s1.i", "s3", "s3.i", "s5", "sproto1", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::s1", "pack1::s1.i", "pack2::a2", "pack2::a2.i", "pack2::s2", "pack2::s2.i", "pack3::a3", "pack3::a3.i",
						"pack3::s3", "pack3::s3.i", "pack4::a4", "pack4::a4.i", "pack4::s4", "pack4::s4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::s5", "pack5::s5.i", "pack5::s6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::s4", "renamed_package::s4.i"
					])
				]
				ownedProcessSubcomponents.head => [
					"psub".assertEquals(name)
					//Tests scope_ProcessSubcomponent_processSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.processSubcomponent_ProcessSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "p1", "p1.i", "p3", "p3.i", "p5", "pproto1", "ra", "rp", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::p1", "pack1::p1.i", "pack2::a2", "pack2::a2.i", "pack2::p2", "pack2::p2.i", "pack3::a3", "pack3::a3.i",
						"pack3::p3", "pack3::p3.i", "pack4::a4", "pack4::a4.i", "pack4::p4", "pack4::p4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::p5", "pack5::p5.i", "pack5::p6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::p4", "renamed_package::p4.i"
					])
				]
				ownedThreadGroupSubcomponents.head => [
					"tgsub".assertEquals(name)
					//Tests scope_ThreadGroupSubcomponent_threadGroupSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.threadGroupSubcomponent_ThreadGroupSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5",
						"aproto1", "container", "container.i", "ra", "rtg", "tg1", "tg1.i", "tg3", "tg3.i", "tg5", "tgproto1", "pack1::a1", "pack1::a1.i",
						"pack1::container", "pack1::container.i", "pack1::tg1", "pack1::tg1.i", "pack2::a2", "pack2::a2.i", "pack2::tg2", "pack2::tg2.i",
						"pack3::a3", "pack3::a3.i", "pack3::tg3", "pack3::tg3.i", "pack4::a4", "pack4::a4.i", "pack4::tg4", "pack4::tg4.i", "pack5::a5",
						"pack5::a5.i", "pack5::a6", "pack5::tg5", "pack5::tg5.i", "pack5::tg6", "renamed_package::a4", "renamed_package::a4.i",
						"renamed_package::tg4", "renamed_package::tg4.i"
					])
				]
				ownedThreadSubcomponents.head => [
					"tsub".assertEquals(name)
					//Tests scope_ThreadSubcomponent_threadSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.threadSubcomponent_ThreadSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "ra", "rt", "t1", "t1.i", "t3", "t3.i", "t5", "tproto1", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::t1", "pack1::t1.i", "pack2::a2", "pack2::a2.i", "pack2::t2", "pack2::t2.i", "pack3::a3", "pack3::a3.i",
						"pack3::t3", "pack3::t3.i", "pack4::a4", "pack4::a4.i", "pack4::t4", "pack4::t4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::t5", "pack5::t5.i", "pack5::t6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::t4", "renamed_package::t4.i"
					])
				]
				ownedSubprogramSubcomponents.head => [
					"subsub".assertEquals(name)
					//Tests scope_SubprogramSubcomponent_subprogramSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.subprogramSubcomponent_SubprogramSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5",
						"aproto1", "container", "container.i", "ra", "rsub", "sub1", "sub1.i", "sub3", "sub3.i", "sub5", "subcontainer", "subproto1",
						"pack1::a1", "pack1::a1.i", "pack1::container", "pack1::container.i", "pack1::sub1", "pack1::sub1.i", "pack1::subcontainer",
						"pack2::a2", "pack2::a2.i", "pack2::sub2", "pack2::sub2.i", "pack3::a3", "pack3::a3.i", "pack3::sub3", "pack3::sub3.i", "pack4::a4",
						"pack4::a4.i", "pack4::sub4", "pack4::sub4.i", "pack5::a5", "pack5::a5.i", "pack5::a6", "pack5::sub5", "pack5::sub5.i", "pack5::sub6",
						"renamed_package::a4", "renamed_package::a4.i", "renamed_package::sub4", "renamed_package::sub4.i"
					])
				]
				ownedSubprogramGroupSubcomponents.head => [
					"subgsub".assertEquals(name)
					//Tests scope_SubprogramGroupSubcomponent_subprogramGroupSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.subprogramGroupSubcomponent_SubprogramGroupSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5",
						"aproto1", "container", "container.i", "ra", "rsubg", "subg1", "subg1.i", "subg3", "subg3.i", "subg5", "subgproto1", "pack1::a1",
						"pack1::a1.i", "pack1::container", "pack1::container.i", "pack1::subg1", "pack1::subg1.i", "pack2::a2", "pack2::a2.i", "pack2::subg2",
						"pack2::subg2.i", "pack3::a3", "pack3::a3.i", "pack3::subg3", "pack3::subg3.i", "pack4::a4", "pack4::a4.i", "pack4::subg4",
						"pack4::subg4.i", "pack5::a5", "pack5::a5.i", "pack5::a6", "pack5::subg5", "pack5::subg5.i", "pack5::subg6", "renamed_package::a4",
						"renamed_package::a4.i", "renamed_package::subg4", "renamed_package::subg4.i"
					])
				]
				ownedProcessorSubcomponents.head => [
					"procsub".assertEquals(name)
					//Tests scope_ProcessorSubcomponent_processorSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.processorSubcomponent_ProcessorSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "proc1", "proc1.i", "proc3", "proc3.i", "proc5", "procproto1", "ra", "rproc", "pack1::a1", "pack1::a1.i",
						"pack1::container", "pack1::container.i", "pack1::proc1", "pack1::proc1.i", "pack2::a2", "pack2::a2.i", "pack2::proc2",
						"pack2::proc2.i", "pack3::a3", "pack3::a3.i", "pack3::proc3", "pack3::proc3.i", "pack4::a4", "pack4::a4.i", "pack4::proc4",
						"pack4::proc4.i", "pack5::a5", "pack5::a5.i", "pack5::a6", "pack5::proc5", "pack5::proc5.i", "pack5::proc6", "renamed_package::a4",
						"renamed_package::a4.i", "renamed_package::proc4", "renamed_package::proc4.i"
					])
				]
				ownedVirtualProcessorSubcomponents.head => [
					"vpsub".assertEquals(name)
					//Tests scope_VirtualProcessorSubcomponent_virtualProcessorSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.virtualProcessorSubcomponent_VirtualProcessorSubcomponentType, #["a1", "a1.i", "a3", "a3.i",
						"a5", "aproto1", "container", "container.i", "ra", "rvp", "vp1", "vp1.i", "vp3", "vp3.i", "vp5", "vpproto1", "pack1::a1",
						"pack1::a1.i", "pack1::container", "pack1::container.i", "pack1::vp1", "pack1::vp1.i", "pack2::a2", "pack2::a2.i", "pack2::vp2",
						"pack2::vp2.i", "pack3::a3", "pack3::a3.i", "pack3::vp3", "pack3::vp3.i", "pack4::a4", "pack4::a4.i", "pack4::vp4", "pack4::vp4.i",
						"pack5::a5", "pack5::a5.i", "pack5::a6", "pack5::vp5", "pack5::vp5.i", "pack5::vp6", "renamed_package::a4", "renamed_package::a4.i",
						"renamed_package::vp4", "renamed_package::vp4.i"
					])
				]
				ownedDeviceSubcomponents.head => [
					"devsub".assertEquals(name)
					//Tests scope_DeviceSubcomponent_deviceSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.deviceSubcomponent_DeviceSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "dev1", "dev1.i", "dev3", "dev3.i", "dev5", "devproto1", "ra", "rdev", "pack1::a1", "pack1::a1.i",
						"pack1::container", "pack1::container.i", "pack1::dev1", "pack1::dev1.i", "pack2::a2", "pack2::a2.i", "pack2::dev2", "pack2::dev2.i",
						"pack3::a3", "pack3::a3.i", "pack3::dev3", "pack3::dev3.i", "pack4::a4", "pack4::a4.i", "pack4::dev4", "pack4::dev4.i", "pack5::a5",
						"pack5::a5.i", "pack5::a6", "pack5::dev5", "pack5::dev5.i", "pack5::dev6", "renamed_package::a4", "renamed_package::a4.i",
						"renamed_package::dev4", "renamed_package::dev4.i"
					])
				]
				ownedMemorySubcomponents.head => [
					"msub".assertEquals(name)
					//Tests scope_MemorySubcomponent_memorySubcomponentType
					assertScope(Aadl2Package::eINSTANCE.memorySubcomponent_MemorySubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "m1", "m1.i", "m3", "m3.i", "m5", "mproto1", "ra", "rm", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::m1", "pack1::m1.i", "pack2::a2", "pack2::a2.i", "pack2::m2", "pack2::m2.i", "pack3::a3",
						"pack3::a3.i", "pack3::m3", "pack3::m3.i", "pack4::a4", "pack4::a4.i", "pack4::m4", "pack4::m4.i", "pack5::a5", "pack5::a5.i",
						"pack5::a6", "pack5::m5", "pack5::m5.i", "pack5::m6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::m4",
						"renamed_package::m4.i"
					])
				]
				ownedBusSubcomponents.head => [
					"bsub".assertEquals(name)
					//Tests scope_BusSubcomponent_busSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.busSubcomponent_BusSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1", "b1",
						"b1.i", "b3", "b3.i", "b5", "bproto1", "container", "container.i", "ra", "rb", "pack1::a1", "pack1::a1.i", "pack1::b1", "pack1::b1.i",
						"pack1::container", "pack1::container.i", "pack2::a2", "pack2::a2.i", "pack2::b2", "pack2::b2.i", "pack3::a3", "pack3::a3.i",
						"pack3::b3", "pack3::b3.i", "pack4::a4", "pack4::a4.i", "pack4::b4", "pack4::b4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::b5", "pack5::b5.i", "pack5::b6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::b4", "renamed_package::b4.i"
					])
				]
				ownedVirtualBusSubcomponents.head => [
					"vbsub".assertEquals(name)
					//Tests scope_VirtualBusSubcomponent_virtualBusSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.virtualBusSubcomponent_VirtualBusSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5",
						"aproto1", "container", "container.i", "ra", "rvb", "vb1", "vb1.i", "vb3", "vb3.i", "vb5", "vbproto1", "pack1::a1", "pack1::a1.i",
						"pack1::container", "pack1::container.i", "pack1::vb1", "pack1::vb1.i", "pack2::a2", "pack2::a2.i", "pack2::vb2", "pack2::vb2.i",
						"pack3::a3", "pack3::a3.i", "pack3::vb3", "pack3::vb3.i", "pack4::a4", "pack4::a4.i", "pack4::vb4", "pack4::vb4.i", "pack5::a5",
						"pack5::a5.i", "pack5::a6", "pack5::vb5", "pack5::vb5.i", "pack5::vb6", "renamed_package::a4", "renamed_package::a4.i",
						"renamed_package::vb4", "renamed_package::vb4.i"
					])
				]
				ownedDataSubcomponents.head => [
					"dsub".assertEquals(name)
					//Tests scope_DataSubcomponent_dataSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.dataSubcomponent_DataSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto1", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
			]
			publicSection.ownedClassifiers.get(2) as SubprogramType => [
				"subcontainer".assertEquals(name)
				ownedParameters.head => [
					"param1".assertEquals(name)
					//Tests scope_Parameter_dataFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.parameter_DataFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto2", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto2", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
			]
			publicSection.ownedClassifiers.get(3) as FeatureGroupType => [
				"fgtcontainer".assertEquals(name)
				ownedDataPorts.head => [
					"dport2".assertEquals(name)
					//Tests scope_DataPort_dataFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.dataPort_DataFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto3", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto3", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
				ownedEventDataPorts.head => [
					"edport2".assertEquals(name)
					//Tests scope_EventDataPort_dataFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.eventDataPort_DataFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto3", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto3", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
				ownedFeatureGroups.head => [
					"fg2".assertEquals(name)
					//Tests scope_FeatureGroup_featureType
					assertScope(Aadl2Package::eINSTANCE.featureGroup_FeatureType, #["fgproto3", "fgt1", "fgt3", "fgt5", "fgtcontainer", "rfgt",
						"pack1::fgt1", "pack1::fgtcontainer", "pack2::fgt2", "pack3::fgt3", "pack4::fgt4", "pack5::fgt5", "pack5::fgt6",
						"renamed_package::fgt4"
					])
				]
				ownedParameters.head => [
					"param2".assertEquals(name)
					//Tests scope_Parameter_dataFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.parameter_DataFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto3", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto3", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
				ownedSubprogramAccesses.head => [
					"suba2".assertEquals(name)
					//Tests scope_SubprogramAccess_subprogramFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.subprogramAccess_SubprogramFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto3",
						"container", "container.i", "ra", "rsub", "sub1", "sub1.i", "sub3", "sub3.i", "sub5", "subcontainer", "subproto3", "pack1::a1",
						"pack1::a1.i", "pack1::container", "pack1::container.i", "pack1::sub1", "pack1::sub1.i", "pack1::subcontainer", "pack2::a2",
						"pack2::a2.i", "pack2::sub2", "pack2::sub2.i", "pack3::a3", "pack3::a3.i", "pack3::sub3", "pack3::sub3.i", "pack4::a4", "pack4::a4.i",
						"pack4::sub4", "pack4::sub4.i", "pack5::a5", "pack5::a5.i", "pack5::a6", "pack5::sub5", "pack5::sub5.i", "pack5::sub6",
						"renamed_package::a4", "renamed_package::a4.i", "renamed_package::sub4", "renamed_package::sub4.i"
					])
				]
				ownedSubprogramGroupAccesses.head => [
					"subga2".assertEquals(name)
					//Tests scope_SubprogramGroupAccess_subprogramGroupFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.subprogramGroupAccess_SubprogramGroupFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5",
						"aproto3", "container", "container.i", "ra", "rsubg", "subg1", "subg1.i", "subg3", "subg3.i", "subg5", "subgproto3", "pack1::a1",
						"pack1::a1.i", "pack1::container", "pack1::container.i", "pack1::subg1", "pack1::subg1.i", "pack2::a2", "pack2::a2.i", "pack2::subg2",
						"pack2::subg2.i", "pack3::a3", "pack3::a3.i", "pack3::subg3", "pack3::subg3.i", "pack4::a4", "pack4::a4.i", "pack4::subg4",
						"pack4::subg4.i", "pack5::a5", "pack5::a5.i", "pack5::a6", "pack5::subg5", "pack5::subg5.i", "pack5::subg6", "renamed_package::a4",
						"renamed_package::a4.i", "renamed_package::subg4", "renamed_package::subg4.i"
					])
				]
				ownedBusAccesses.head => [
					"ba2".assertEquals(name)
					//Tests scope_BusAccess_busFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.busAccess_BusFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto3", "b1", "b1.i", "b3", 
						"b3.i", "b5", "bproto3", "container", "container.i", "ra", "rb", "rvb", "vb1", "vb1.i", "vb3", "vb3.i", "vb5", "vbproto3", "pack1::a1", 
						"pack1::a1.i", "pack1::b1", "pack1::b1.i", "pack1::container", "pack1::container.i", "pack1::vb1", "pack1::vb1.i", "pack2::a2", 
						"pack2::a2.i", "pack2::b2", "pack2::b2.i", "pack2::vb2", "pack2::vb2.i", "pack3::a3", "pack3::a3.i", "pack3::b3", "pack3::b3.i", 
						"pack3::vb3", "pack3::vb3.i", "pack4::a4", "pack4::a4.i", "pack4::b4", "pack4::b4.i", "pack4::vb4", "pack4::vb4.i", "pack5::a5", 
						"pack5::a5.i", "pack5::a6", "pack5::b5", "pack5::b5.i", "pack5::b6", "pack5::vb5", "pack5::vb5.i", "pack5::vb6", "renamed_package::a4", 
						"renamed_package::a4.i", "renamed_package::b4", "renamed_package::b4.i", "renamed_package::vb4", "renamed_package::vb4.i"
					])
				]
				ownedDataAccesses.head => [
					"da2".assertEquals(name)
					//Tests scope_DataAccess_dataFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.dataAccess_DataFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto3", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto3", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
				ownedAbstractFeatures.head => [
					"af2".assertEquals(name)
					//Tests scope_AbstractFeature_featurePrototype
					assertScope(Aadl2Package::eINSTANCE.abstractFeature_FeaturePrototype, #["fproto3"])
				]
			]
		]
	}
}