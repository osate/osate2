/**
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2722Test extends XtextTest {

	private static final String PATH = "org.osate.core.tests/models/issue2722/";
	private static final String FILE1 = "Issue2722A.aadl";
	private static final String FILE2 = "Issue2722B.aadl";
	private static final String FILE3 = "Issue2722C.aadl";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testInstantiationA() throws Exception {
		AadlPackage pkg = testHelper.parseFile(PATH + FILE1);
		Optional<Classifier> impl = pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(c -> c.getName().equals("S.i"))
				.findFirst();

		SystemInstance instance = InstantiateModel.instantiate((ComponentImplementation) impl.get());
		Assert.assertEquals("S_i_Instance", instance.getName());

		ConnectionInstance conni = instance.getConnectionInstances().get(0);
		Assert.assertEquals("l.ll.o -> r.rr.i", conni.getName());
		EList<SystemOperationMode> soms = conni.getInSystemOperationModes();
		Assert.assertEquals(1,  soms.size());
		Assert.assertEquals(soms.get(0), instance.getSystemOperationModes().get(0));
	}

	@Test
	public void testInstantiationB() throws Exception {
		AadlPackage pkg = testHelper.parseFile(PATH + FILE2);
		Optional<Classifier> impl = pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(c -> c.getName().equals("S.i"))
				.findFirst();

		SystemInstance instance = InstantiateModel.instantiate((ComponentImplementation) impl.get());
		Assert.assertEquals("S_i_Instance", instance.getName());

		ConnectionInstance conni = instance.getConnectionInstances().get(0);
		Assert.assertEquals("l.ll.o -> r.rr.i", conni.getName());
		EList<SystemOperationMode> soms = conni.getInSystemOperationModes();
		Assert.assertEquals(1, soms.size());
		Assert.assertEquals(soms.get(0), instance.getSystemOperationModes().get(1));
	}

	@Test
	public void testInstantiationC1() throws Exception {
		AadlPackage pkg = testHelper.parseFile(PATH + FILE3);
		Optional<Classifier> impl = pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(c -> c.getName().equals("C.with_modes"))
				.findFirst();

		SystemInstance instance = InstantiateModel.instantiate((ComponentImplementation) impl.get());
		Assert.assertEquals("C_with_modes_Instance", instance.getName());

		ConnectionInstance conni = instance.getConnectionInstances().get(0);
		Assert.assertEquals("f_in -> snk1.f_in", conni.getName());
		EList<SystemOperationMode> soms = conni.getInSystemOperationModes();
		Assert.assertEquals(1, soms.size());
		Assert.assertEquals(soms.get(0), instance.getSystemOperationModes().get(1));

		conni = instance.getConnectionInstances().get(1);
		Assert.assertEquals("src1.f_out -> f_out", conni.getName());
		soms = conni.getInSystemOperationModes();
		Assert.assertEquals(1, soms.size());
		Assert.assertEquals(soms.get(0), instance.getSystemOperationModes().get(0));

		conni = instance.getConnectionInstances().get(2);
		Assert.assertEquals("src2.f_out -> snk2.f_in", conni.getName());
		soms = conni.getInSystemOperationModes();
		Assert.assertEquals(1, soms.size());
		Assert.assertEquals(soms.get(0), instance.getSystemOperationModes().get(0));
	}

	@Test
	public void testInstantiationC2() throws Exception {
		AadlPackage pkg = testHelper.parseFile(PATH + FILE3);
		Optional<Classifier> impl = pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(c -> c.getName().equals("C.modal_wrappers"))
				.findFirst();

		SystemInstance instance = InstantiateModel.instantiate((ComponentImplementation) impl.get());
		Assert.assertEquals("C_modal_wrappers_Instance", instance.getName());

		ConnectionInstance conni = instance.getConnectionInstances().get(0);
		Assert.assertEquals("f_in -> snk1.y.f_in", conni.getName());
		EList<SystemOperationMode> soms = conni.getInSystemOperationModes();
		Assert.assertEquals(8, soms.size());
		Assert.assertEquals(soms.get(0), instance.getSystemOperationModes().get(4));
		Assert.assertEquals(soms.get(1), instance.getSystemOperationModes().get(5));
		Assert.assertEquals(soms.get(2), instance.getSystemOperationModes().get(6));
		Assert.assertEquals(soms.get(3), instance.getSystemOperationModes().get(7));
		Assert.assertEquals(soms.get(4), instance.getSystemOperationModes().get(12));
		Assert.assertEquals(soms.get(5), instance.getSystemOperationModes().get(13));
		Assert.assertEquals(soms.get(6), instance.getSystemOperationModes().get(14));
		Assert.assertEquals(soms.get(7), instance.getSystemOperationModes().get(15));

		conni = instance.getConnectionInstances().get(1);
		Assert.assertEquals("src1.x.f_out -> f_out", conni.getName());
		soms = conni.getInSystemOperationModes();
		Assert.assertEquals(8, soms.size());
		Assert.assertEquals(soms.get(0), instance.getSystemOperationModes().get(0));
		Assert.assertEquals(soms.get(1), instance.getSystemOperationModes().get(1));
		Assert.assertEquals(soms.get(2), instance.getSystemOperationModes().get(2));
		Assert.assertEquals(soms.get(3), instance.getSystemOperationModes().get(3));
		Assert.assertEquals(soms.get(4), instance.getSystemOperationModes().get(4));
		Assert.assertEquals(soms.get(5), instance.getSystemOperationModes().get(5));
		Assert.assertEquals(soms.get(6), instance.getSystemOperationModes().get(6));
		Assert.assertEquals(soms.get(7), instance.getSystemOperationModes().get(7));

		conni = instance.getConnectionInstances().get(2);
		Assert.assertEquals("src2.x.f_out -> snk2.y.f_in", conni.getName());
		soms = conni.getInSystemOperationModes();
		Assert.assertEquals(4, soms.size());
		Assert.assertEquals(soms.get(0), instance.getSystemOperationModes().get(1));
		Assert.assertEquals(soms.get(1), instance.getSystemOperationModes().get(5));
		Assert.assertEquals(soms.get(2), instance.getSystemOperationModes().get(9));
		Assert.assertEquals(soms.get(3), instance.getSystemOperationModes().get(13));
	}

}
