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
public class Issue702Test extends XtextTest {
	private static final String AADL_TEXT = """
			package fgpt
			public
			\tfeature group Sense_Whole
			\t	features
			\t		D1: in data port;
			\t		D2: in data port;
			\t		D3: in data port;
			\t		D4: in data port;
			\t		D5: in data port;
			\tend Sense_Whole;
			\t
			\tsystem sys
			\tend sys;
			\t
			\tsystem implementation sys.root
			\t	subcomponents
			\t		External: system Ext.base;
			\t		Container: system Container.base;
			\t	connections
			\t		sense: feature group External.Sense -> Container.Sense;
			\tend sys.root;
			\t
			\tsystem Container
			\t	features
			\t		Sense: feature group Sense_Whole;
			\tend Container;
			\t
			\tsystem implementation Container.base
			\t	subcomponents
			\t		S1: system Sub1.base;
			\t	connections
			\t		Sub1_D1: port Sense.D1 -> S1.D1;
			\t		Sub1_D2: port Sense.D2 -> S1.D2;
			\t		Sub1_D3: port Sense.D3 -> S1.D3;
			\tend Container.base;
			\t
			\tsystem Sub1
			\t	features
			\t		D1: in data port;
			\t		D2: in data port;
			\t		D3: in data port;
			\tend Sub1;
			\t
			\tsystem implementation Sub1.base
			\tend Sub1.base;
			\t
			\tsystem Ext
			\t	features
			\t		Sense: feature group inverse of Sense_Whole;
			\tend Ext;
			\t
			\tsystem implementation Ext.base
			\tend Ext.base;
			end fgpt;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue702() throws Exception {
		AadlPackage pkg = testHelper.parseString(AADL_TEXT);
		assertEquals("fgpt", pkg.getName());
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();

		SystemImplementation declared = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(2);
		assertEquals("sys.root", declared.getName());
		SystemImplementation sysImpl = (SystemImplementation) classifiers.stream()
				.filter(classifier -> "sys.root".equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		var instance = InstantiateModel.instantiate(sysImpl);
		assertEquals("sys_root_Instance", instance.getName());
		assertEquals(3, instance.getConnectionInstances().size());
	}
}
