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

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyAssociation;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.AssignmentAction;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.ClassifierFeaturePropertyReference;
import org.osate.ba.aadlba.ClassifierPropertyReference;
import org.osate.ba.aadlba.ElementHolder;
import org.osate.ba.aadlba.PropertyReference;
import org.osate.ba.aadlba.PropertySetPropertyReference;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;

/**
 * AS5506/3 Rev A D.7 admits {@code self} as the component element of a property reference, where it names the component
 * containing the annex subclause. Verifies that translation preserves that component as the classifier of the strict
 * property reference, that {@code self} still resolves a feature or subcomponent name behind it, and that on its own it
 * is neither a value nor an assignment target.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3172Test {
	private static final String MODELS = "org.osate.ba.tests/models/issue3172/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void selfNamesTheContainingTypeOfAPropertyReference() throws Exception {
		assertEquals(List.of("ClassifierPropertyReference(classifier=Issue3172::reader, "
				+ "PropertyAssociationHolder:Priority)",
				"ClassifierPropertyReference(classifier=Issue3172::reader, PropertyAssociationHolder:Priority)",
				"ClassifierPropertyReference(classifier=Issue3172::reader, BasicPropertyHolder:Deadline)",
				"DataPortHolder:input"), assignedValues(0));
	}

	@Test
	public void selfNamesTheContainingImplementationOfAPropertyReference() throws Exception {
		assertEquals(List.of("ClassifierPropertyReference(classifier=Issue3172::writer.impl, "
				+ "PropertyAssociationHolder:Priority)", "DataSubcomponentHolder:storage"), assignedValues(1));
	}

	@Test
	public void selfAloneIsNeitherAValueNorAnAssignmentTarget() throws Exception {
		assertEquals(List.of("ERROR: resolved behavior annex holder has no element",
				"ERROR: resolved behavior annex holder has no element"), issues("SelfNotAValue.aadl"));
	}

	/** Describes the value of every assignment of the given subclause, in the order the actions are written. */
	private List<String> assignedValues(final int annexIndex) throws Exception {
		var result = new ArrayList<String>();
		strictAnnex(annexIndex).eAllContents().forEachRemaining(object -> {
			if (object instanceof AssignmentAction assignment) {
				result.add(describeValue(assignment.getValueExpression()));
			}
		});
		return result;
	}

	private BehaviorAnnex strictAnnex(final int annexIndex) throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3172.aadl");
		validationHelper.assertNoIssues(root);
		return BehaviorAnnexUtil.getStrictModel(AnnexUtil.getAllDefaultAnnexSubclauses(root).get(annexIndex));
	}

	private List<String> issues(final String model) throws Exception {
		// Xtext does not hand back the issues of one resource in the order the checkers report them.
		return testHelper.testFile(MODELS + model)
				.getIssues()
				.stream()
				.map(issue -> issue.getSeverity() + ": " + issue.getMessage())
				.sorted()
				.toList();
	}

	/**
	 * Describes a value by the property reference it reads or the holder it names, so that a run without the fix
	 * reports the reference it did build rather than failing to compile.
	 */
	private static String describeValue(final EObject value) {
		if (value instanceof PropertyReference reference) {
			return describe(reference);
		}
		if (value instanceof ElementHolder holder) {
			return value.eClass().getName() + ":" + name(holder.getElement());
		}
		var children = new ArrayList<String>();
		for (var child : value.eContents()) {
			children.add(describeValue(child));
		}
		return children.size() == 1 ? children.get(0) : value.eClass().getName() + children;
	}

	private static String describe(final PropertyReference reference) {
		var result = new StringJoiner(", ", reference.eClass().getName() + "(", ")");
		if (reference instanceof ClassifierPropertyReference classifierReference) {
			result.add("classifier=" + name(classifierReference.getClassifier(), true));
		} else if (reference instanceof ClassifierFeaturePropertyReference componentReference) {
			var component = componentReference.getComponent();
			result.add("component=" + (component == null ? "<null>"
					: component.eClass().getName() + ":" + name(component.getElement())));
		} else if (reference instanceof PropertySetPropertyReference propertySetReference) {
			result.add("propertySet=" + name(propertySetReference.getPropertySet()));
		}
		for (var propertyName : reference.getProperties()) {
			var holder = propertyName.getProperty();
			result.add(holder.eClass().getName() + ":" + property(holder.getElement()));
		}
		return result.toString();
	}

	private static String property(final Element element) {
		if (element instanceof PropertyAssociation association) {
			return name(association.getProperty());
		}
		return element instanceof NamedElement named ? name(named) : String.valueOf(element);
	}

	private static String name(final NamedElement element) {
		return name(element, false);
	}

	private static String name(final NamedElement element, final boolean qualified) {
		if (element == null) {
			return "<null>";
		}
		return qualified ? element.getQualifiedName() : element.getName();
	}
}
