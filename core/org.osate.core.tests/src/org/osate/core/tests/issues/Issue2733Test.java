/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL.
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

import java.util.Comparator;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.RecordType;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Record fields share a namespace within their record type, but the validator did not check that
 * namespace for duplicate names. This test requires diagnostics on each field that repeats an earlier
 * field while ensuring a neighboring record with distinct fields remains valid.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2733Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue2733/Issue2733.aadl";
	private static final String MESSAGE = "Field 'field' previously declared in record type";

	@Inject
	private TestHelper<ModelUnit> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void duplicateRecordFieldNamesAreReported() throws Exception {
		var propertySet = (PropertySet) testHelper.parseFile(MODEL);
		var issues = validationHelper.validate(propertySet)
				.stream()
				.sorted(Comparator.comparingInt(issue -> issue.getOffset() == null ? -1 : issue.getOffset()))
				.toList();
		var duplicateRecord = (RecordType) propertySet.getOwnedPropertyTypes().get(1);

		assertEquals(2, issues.size());
		for (var i = 0; i < issues.size(); i++) {
			var issue = issues.get(i);
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals(MESSAGE, issue.getMessage());
			assertEquals(EcoreUtil.getURI(duplicateRecord.getOwnedFields().get(i + 1)), issue.getUriToProblem());
		}
	}
}
