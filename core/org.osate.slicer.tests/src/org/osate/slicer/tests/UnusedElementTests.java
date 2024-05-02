/*******************************************************************************
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.slicer.tests;

import static org.junit.Assert.assertEquals;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.slicer.SlicerRepresentation;
import org.osate.slicer.SlicerRepresentation.ErrorStateValidity;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

/*
 *  * Key:
        * ->o -- Initial state
        * o -- State (not initial, non-terminating)
        * * -- Terminating state
        * *Expected Error*
    1. o->* *No Source*
    2. ->o->o *No Sink*
    3. ->o->o * *No Sink*
    4. ->o->o
         \>* *No Sink*
    5. ->o->o->* *No Error*
 */

@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class UnusedElementTests {
	@Inject
	TestHelper<AadlPackage> myTestHelper;

	private SlicerRepresentation tlg1, tlg2, tlg3, tlg4, tlg5;
	private SystemInstance si1, si2, si3, si4, si5;
	private String[] vertices;

	@Before
	public void setUp() throws Exception {
		tlg1 = new SlicerRepresentation();
		tlg2 = new SlicerRepresentation();
		tlg3 = new SlicerRepresentation();
		tlg4 = new SlicerRepresentation();
		tlg5 = new SlicerRepresentation();
		var pkg = myTestHelper.parseFile("org.osate.slicer.tests/aadl-models/UnusedElementTests.aadl");
		var sysImpl1 = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var sysImpl2 = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(2);
		var sysImpl3 = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(3);
		var sysImpl4 = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(4);
		var sysImpl5 = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(5);
		si1 = InstantiateModel.instantiate(sysImpl1);
		si2 = InstantiateModel.instantiate(sysImpl2);
		si3 = InstantiateModel.instantiate(sysImpl3);
		si4 = InstantiateModel.instantiate(sysImpl4);
		si5 = InstantiateModel.instantiate(sysImpl5);
		tlg1.buildGraph(si1);
		tlg2.buildGraph(si2);
		tlg3.buildGraph(si3);
		tlg4.buildGraph(si4);
		tlg5.buildGraph(si5);

		vertices = new String[6];
		vertices[0] = "sys_impl_Instance.a.o1TimingSrc.ItemTimingError";
		vertices[1] = "sys_impl_Instance.a.o1.ItemTimingError";
		vertices[2] = "sys_impl_Instance.b.i1.ItemTimingError";
		vertices[3] = "sys_impl_Instance.b.o3.ItemTimingError";
		vertices[4] = "sys_impl_Instance.c.i3.ItemTimingError";
		vertices[5] = "sys_impl_Instance.c.o3TimingSink.ItemTimingError";
	}

	@Test
	public void testSinkReachability() {
		assertEquals(0, tlg1.getErrorSources(ErrorStateValidity.INVALID).size());
		assertEquals(1, tlg2.getErrorSources(ErrorStateValidity.INVALID).size());
		assertEquals(1, tlg3.getErrorSources(ErrorStateValidity.INVALID).size());
		assertEquals(1, tlg4.getErrorSources(ErrorStateValidity.INVALID).size());
		assertEquals(0, tlg5.getErrorSources(ErrorStateValidity.INVALID).size());

		assertEquals(0, tlg1.getErrorSources(ErrorStateValidity.VALID).size());
		assertEquals(0, tlg2.getErrorSources(ErrorStateValidity.VALID).size());
		assertEquals(0, tlg3.getErrorSources(ErrorStateValidity.VALID).size());
		assertEquals(0, tlg4.getErrorSources(ErrorStateValidity.VALID).size());
		assertEquals(1, tlg5.getErrorSources(ErrorStateValidity.VALID).size());

		assertEquals(0, tlg1.getErrorSources(ErrorStateValidity.ALL).size());
		assertEquals(1, tlg2.getErrorSources(ErrorStateValidity.ALL).size());
		assertEquals(1, tlg3.getErrorSources(ErrorStateValidity.ALL).size());
		assertEquals(1, tlg4.getErrorSources(ErrorStateValidity.ALL).size());
		assertEquals(1, tlg5.getErrorSources(ErrorStateValidity.ALL).size());
	}

	@Test
	public void testSourceReachability() {
		assertEquals(1, tlg1.getErrorSinks(ErrorStateValidity.INVALID).size());
		assertEquals(0, tlg2.getErrorSinks(ErrorStateValidity.INVALID).size());
		assertEquals(1, tlg3.getErrorSinks(ErrorStateValidity.INVALID).size());
		assertEquals(0, tlg4.getErrorSinks(ErrorStateValidity.INVALID).size());
		assertEquals(0, tlg5.getErrorSinks(ErrorStateValidity.INVALID).size());

		assertEquals(0, tlg1.getErrorSinks(ErrorStateValidity.VALID).size());
		assertEquals(0, tlg2.getErrorSinks(ErrorStateValidity.VALID).size());
		assertEquals(0, tlg3.getErrorSinks(ErrorStateValidity.VALID).size());
		assertEquals(1, tlg4.getErrorSinks(ErrorStateValidity.VALID).size());
		assertEquals(1, tlg5.getErrorSinks(ErrorStateValidity.VALID).size());

		assertEquals(1, tlg1.getErrorSinks(ErrorStateValidity.ALL).size());
		assertEquals(0, tlg2.getErrorSinks(ErrorStateValidity.ALL).size());
		assertEquals(1, tlg3.getErrorSinks(ErrorStateValidity.ALL).size());
		assertEquals(1, tlg4.getErrorSinks(ErrorStateValidity.ALL).size());
		assertEquals(1, tlg5.getErrorSinks(ErrorStateValidity.ALL).size());
	}
}
