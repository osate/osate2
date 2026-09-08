/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue575Test extends XtextTest {
	private static final String AADL_TEXT = """
			package issue575
			public
			
			\tfeature group FG
			\t	features
			\t		outMsg: out event data port;
			\t		inMsg: in data port;
			\t		inoutMsg: in out data port;
			\tend FG;
			
			\tsystem Box
			\t	features
			\t		ioports: feature group FG;
			\t	flows
			\t		outFlow: flow source ioports.outMsg;
			\t		inFlow: flow sink ioports.inMsg;
			\tend Box;
			
			\tprocess P
			\t	features
			\t		ioports: feature group inverse of FG;
			\t	flows
			\t		processFlow: flow path ioports.outMsg -> ioports.inMsg;
			\tend P;
			
			\tprocess implementation P.i
			\t	subcomponents
			\t		t1: thread T.i;
			\t	connections
			\t		c: feature group ioports <-> t1.ioports;
			\t	flows
			\t		processFlow: flow path ioports.outMsg -> c -> t1.threadFlow -> c -> ioports.inMsg;
			\tend P.i;
			
			\tthread T
			\t	features
			\t		ioports: feature group inverse of FG;
			\t	flows
			\t		threadFlow: flow path ioports.outMsg -> ioports.inMsg;
			\tend T;
			
			\tthread implementation T.i
			\tend T.i;
			
			\tsystem S
			\tend S;
			
			\tsystem implementation S.top
			\t	subcomponents
			\t		proc: process P.i;
			\t		box: system Box;
			\t	connections
			\t		c: feature group box.ioports <-> proc.ioports;
			\t	flows
			\t		f_bb_proc_bb: end to end flow box.outFlow -> c -> proc.processFlow -> c -> box.inFlow;
			\tend S.top;
			
			end issue575;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue575() throws Exception {
		AadlPackage pkg = testHelper.parseString(AADL_TEXT);
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		assertTrue("System implementation \"S.top\" not found",
				classifiers.stream().anyMatch(classifier -> "S.top".equals(classifier.getName())));
		SystemImplementation sysImpl = (SystemImplementation) classifiers.stream()
				.filter(classifier -> "S.top".equals(classifier.getName()))
				.findFirst()
				.get();
		var instance = InstantiateModel.instantiate(sysImpl);
		assertEquals("S_top_Instance", instance.getName());
		var connections = instance.getConnectionInstances();
		assertTrue("In S_top_instance: Expected 4 connections but found " + connections.size(),
				connections.size() == 4);
		var etes = instance.getEndToEndFlows();
		assertTrue("In S_top_instance: Expected 1 end to end flow but found " + etes.size(),
				etes.size() == 1);
	}
}
