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
package org.osate.ba.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.Property;
import org.osate.aadl2.RealLiteral;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.ClassifierFeaturePropertyReference;
import org.osate.ba.aadlba.ClassifierPropertyReference;
import org.osate.ba.aadlba.PropertyReference;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Checks D.7 unit categories without selecting instance-dependent property values. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3191Test extends XtextTest {
	private static final String MODELS = "org.osate.ba.tests/models/issue3191/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void unitlessAndTimePropertiesAreAcceptedAndKeepTheirUnits() throws Exception {
		var root = parse("Issue3191");
		validationHelper.assertNoIssues(root);
		var references = references(root);
		var integer = (IntegerLiteral) references.get(3).getProperties().getFirst().getProperty().getElement();
		assertEquals(3, integer.getValue());
		assertEquals("ms", integer.getUnit().getName());
		var real = (RealLiteral) references.get(4).getProperties().getFirst().getProperty().getElement();
		assertEquals(1.5, real.getValue(), 0.0);
		assertEquals("sec", real.getUnit().getName());
	}

	@Test
	public void prefixedTimeReferencesRetainTheirOwnersAndPropertyDefinitions() throws Exception {
		var root = parse("Issue3191");
		validationHelper.assertNoIssues(root);
		var references = references(root);
		var self = (ClassifierPropertyReference) references.get(5);
		assertEquals("Issue3191::reader.impl", self.getClassifier().getQualifiedName());
		var property = (Property) self.getProperties().getFirst().getProperty().getElement();
		assertEquals("Issue3191Properties::Time_Int", property.getQualifiedName());
		var feature = (ClassifierFeaturePropertyReference) references.get(6);
		assertEquals("input", feature.getComponent().getElement().getName());
		assertSame(property, feature.getProperties().getFirst().getProperty().getElement());
		assertTrue(references.get(7).getProperties().getFirst().getProperty().getElement() instanceof Property);
	}

	@Test
	public void otherUnitCategoriesAreReportedAtEachReference() throws Exception {
		var root = parse("DisallowedUnits");
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		var issues = validationHelper.validate(root).stream().sorted(Comparator.comparing(Issue::getOffset)).toList();
		assertEquals(issues.toString(), 9, issues.size());
		assertEquals(List.of("#Issue3191Properties::Size_Int", "#Issue3191Properties::Size_Real",
				"#Issue3191Properties::Size_Int", "#Issue3191Properties::Size_Int",
				"#Issue3191Properties::Size_Without_Default", "#Issue3191Properties::Size_Constant",
				"#Issue3191Properties::Other", "#Issue3191Properties::Record_Value.size",
				"#Issue3191Properties::Record_Without_Default.size"), issues.stream().map(issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("org.osate.xtext.aadl2.ba.propertyReferenceUnits", issue.getCode());
			assertEquals("Behavior Annex property references must be unitless or use AADL_Project::Time_Units",
					issue.getMessage());
			return source.substring(issue.getOffset(), issue.getOffset() + issue.getLength());
		}).toList());
	}

	private AadlPackage parse(String name) {
		var root = testHelper.parseFile(MODELS + name + ".aadl", MODELS + "Issue3191Properties.aadl");
		root.eResource().getResourceSet().getResources().stream()
				.filter(resource -> resource.getURI().lastSegment().equals("Issue3191Properties.aadl"))
				.forEach(resource -> validationHelper.assertNoIssues(resource.getContents().getFirst()));
		return root;
	}

	private static List<PropertyReference> references(AadlPackage root) {
		var strict = BehaviorAnnexUtil.getStrictModel(AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst());
		var result = new ArrayList<PropertyReference>();
		strict.eAllContents().forEachRemaining(object -> {
			if (object instanceof PropertyReference reference) {
				result.add(reference);
			}
		});
		return result;
	}
}
