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
 * conditions contained in any such Third Party Software or separate license file distributed with this program. The
 * parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries of this
 * license with respect to the terms applicable to their Third Party Software. Third Party Software licenses only
 * apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.StringLiteral;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Tests that AADL string literals follow issue #809: quotation marks inside a double-quoted string
 * are doubled, and single quotes cannot delimit a string. The semantic and serialized values are
 * both checked so the lexer and value converter remain consistent.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue809Test extends XtextTest {
	private static final String MODEL_DIR = "org.osate.core.tests/models/issue809/";

	@Inject
	private TestHelper<ModelUnit> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private ISerializer serializer;

	@Test
	public void doubledQuotationMarksRepresentAQuotationMark() throws Exception {
		var propertySet = (PropertySet) testHelper.parseFile(MODEL_DIR + "Issue809.aadl");
		validationHelper.assertNoIssues(propertySet);
		var literal = (StringLiteral) propertySet.getOwnedPropertyConstants().getFirst().getConstantValue();

		assertEquals("OSATE says \"hello\".", literal.getValue());
		assertTrue(serializer.serialize(propertySet).contains("\"OSATE says \"\"hello\"\".\""));
	}

	@Test
	public void singleQuotesCannotDelimitAString() throws Exception {
		var propertySet = testHelper.parseFile(MODEL_DIR + "Issue809SingleQuoted.aadl");

		assertFalse(propertySet.eResource().getErrors().isEmpty());
	}
}
