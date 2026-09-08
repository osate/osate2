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
public class Issue567Test extends XtextTest {
	private static final String AADL_TEXT = """
			package issue567
			public

			\tfeature group FG
			\t\tfeatures
			\t\t\toutMsg: out event data port;
			\t\t\tinMsg: in data port;
			\tend FG;

			\tsystem Box
			\t\tfeatures
			\t\t\tioports: feature group FG;
			\t\tflows
			\t\t\toutFlow: flow source ioports.outMsg;
			\t\t\tinFlow: flow sink ioports.inMsg;
			\tend Box;

			\tprocess P
			\t\tfeatures
			\t\t\tioports: feature group inverse of FG;
			\t\tflows
			\t\t\tprocessFlow: flow path ioports.outMsg -> ioports.inMsg;
			\tend P;

			\tprocess implementation P.i
			\t\tsubcomponents
			\t\t\tt1: thread T.i;
			\t\tconnections
			\t\t\tc: feature group ioports <-> t1.ioports;
			\t\tflows
			\t\t\tprocessFlow: flow path ioports.outMsg -> c -> t1.threadFlow -> c -> ioports.inMsg;
			\tend P.i;

			\tthread T
			\t\tfeatures
			\t\t\tioports: feature group inverse of FG;
			\t\tflows
			\t\t\tthreadFlow: flow path ioports.outMsg -> ioports.inMsg;
			\tend T;

			\tthread implementation T.i
			\tend T.i;

			\tsystem S
			\tend S;

			\tsystem implementation S.top
			\t\tsubcomponents
			\t\t\tproc: process P.i;
			\t\t\tbox: system Box;
			\t\tconnections
			\t\t\tc: feature group box.ioports <-> proc.ioports;
			\t\tflows
			\t\t\tf_bb_proc_bb: end to end flow box.outFlow -> c -> proc.processFlow -> c -> box.inFlow;
			\tend S.top;

			end issue567;\t\
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue567() throws Exception {
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
		assertTrue("In S_top_instance: Expected 2 connections but found " + connections.size(),
				connections.size() == 2);
		var etes = instance.getEndToEndFlows();
		assertTrue("In S_top_instance: Expected 1 end to end flow but found " + etes.size(),
				etes.size() == 1);
	}
}
