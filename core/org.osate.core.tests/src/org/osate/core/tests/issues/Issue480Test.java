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
public class Issue480Test extends XtextTest {
	private static final String AADL_TEXT = """
			package issue480
			public
			\t
			\tfeature group ps
			\t	features
			\t		p1: in data port;
			\t		p2: out data port;
			\tend ps;
			
			\tsystem top
			\t	features
			\t		fg: feature group;
			\t		ps: feature group ps;
			\tend top;
			\t
			\tsystem implementation top.i
			\t	subcomponents
			\t		l: abstract a;
			\t		r: abstract b;
			\t	connections
			\t		c01: feature group l.fg -> fg;
			\t		c02: feature group l.ps <-> fg;
			\t		c03: feature group l.fg <-> ps;
			\t		c04: feature group l.ps <-> ps;
			
			\t		c11: feature group fg -> l.fg;
			\t		c12: feature group ps <-> l.fg;
			\t		c13: feature group fg <-> l.ps;
			\t		c14: feature group ps <-> l.ps;
			\t	\t
			\t		c21: feature group l.fg -> r.fg;
			\t		c22: feature group l.ps <-> r.fg;
			\t		c23: feature group l.fg <-> r.ps;
			\t		c24: feature group l.ps <-> r.ps;
			\tend top.i;
			\t
			\tabstract a
			\t	features
			\t		fg: feature group;
			\t		ps: feature group ps;
			\tend a;
			\t
			\tabstract b
			\t	features
			\t		fg: feature group;
			\t		ps: feature group inverse of ps;
			\tend b;
			\t
			end issue480;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void issue480() throws Exception {
		AadlPackage pkg = testHelper.parseString(AADL_TEXT);
		var classifiers = pkg.getOwnedPublicSection().getOwnedClassifiers();
		assertTrue("System implementation \"top.i\" not found",
				classifiers.stream().anyMatch(classifier -> "top.i".equals(classifier.getName())));
		SystemImplementation sysImpl = (SystemImplementation) classifiers.stream()
				.filter(classifier -> "top.i".equals(classifier.getName()))
				.findFirst()
				.get();
		var instance = InstantiateModel.instantiate(sysImpl);
		assertEquals("top_i_Instance", instance.getName());
		var connections = instance.getConnectionInstances();
		assertTrue("In top_i_Instance: Expected 21 connections but found " + connections.size(),
				connections.size() == 21);
	}
}
