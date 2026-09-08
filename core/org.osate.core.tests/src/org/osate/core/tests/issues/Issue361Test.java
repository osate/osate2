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
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue361Test extends XtextTest {
	private static final String AADL_TEXT = """
			package issue361
			public
			\twith Base_Types;

			\tfeature group blk_ins
			\t\tfeatures
			\t\t\tinput: in data port Base_Types::Boolean;
			\tend blk_ins;

			\tfeature group blk_outs
			\t\tfeatures
			\t\t\toutput: out data port Base_Types::Boolean;
			\tend blk_outs;

			\tsystem Block
			\t\tfeatures\s
			\t\t\tins: feature group blk_ins;
			\t\t\touts: feature group blk_outs;
			\tend Block;

			\tsystem implementation Block.impl
			\t\tsubcomponents
			\t\t\tblk_process: process BlockProcess.impl;
			\t\tconnections
			\t\t\tpin: port ins.input -> blk_process.input;
			\t\t\tpout: port blk_process.output -> outs.output;
			\tend Block.impl;

			\tprocess BlockProcess
			\t\tfeatures
			\t\t\tinput: in data port Base_Types::Boolean;
			\t\t\toutput: out data port Base_Types::Boolean;
			\tend BlockProcess;

			\tprocess implementation BlockProcess.impl
			\tend BlockProcess.impl;

			end issue361;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue361() throws Exception {
		AadlPackage pkg = testHelper.parseString(AADL_TEXT);
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		assertTrue("System implementation \"Block.impl\" not found",
				classifiers.stream().anyMatch(classifier -> "Block.impl".equals(classifier.getName())));
		SystemImplementation sysImpl = (SystemImplementation) classifiers.stream()
				.filter(classifier -> "Block.impl".equals(classifier.getName()))
				.findFirst()
				.get();
		var instance = InstantiateModel.instantiate(sysImpl);
		assertEquals("Block_impl_Instance", instance.getName());
		var conns = instance.getConnectionInstances();
		var names = conns.stream().map(ConnectionInstance::getName).toList();
		assertTrue("Connection \"ins.input -> blk_process.input\" not created",
				names.contains("ins.input -> blk_process.input"));
		assertTrue("Connection \"blk_process.output -> outs.output\" not created",
				names.contains("blk_process.output -> outs.output"));
		assertTrue("Expected two connection instances but found " + conns.size(), conns.size() == 2);
	}
}
