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
package org.osate.ui.tests.propertyview;

import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.DEFAULT;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.INHERITED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.LOCAL;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.LOCAL_CONTAINED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.SHARED_LOCAL_CONTAINED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.UNDEFINED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertAbsent;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertChildren;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertNoPropertiesShown;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertPresent;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertPropertySets;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertStatus;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertValue;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertValueMatches;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.showDefaultValues;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.showUndefinedProperties;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.selectInEditor;

import java.util.List;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests what the AADL Property Values view shows for a selected element: the property sets it groups the properties
 * into, the rendered value of each kind of property value, the structure it gives to list, range, record and modal
 * values, and where it reports that a value comes from.
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class AadlPropertyViewContentTest extends AadlPropertyViewTestBase {
	@Test
	public void testNoPropertiesForAnElementThatCannotHaveProperties() {
		/* The setup leaves the caret on the package section, which cannot have properties. */
		assertNoPropertiesShown();

		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertPresent(PROPERTY_SET, "Int_Property");

		selectInEditor(MODEL_FILE, PACKAGE_SECTION);
		assertNoPropertiesShown();
	}

	@Test
	public void testPropertySetsAreGroupedAndSortedByName() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);

		/*
		 * With undefined properties and default values hidden, only the property sets that the model declares a value
		 * from are shown, sorted by name without regard to case.
		 */
		assertPropertySets(List.of(EXTRA_PROPERTY_SET, PROPERTY_SET));
		assertValue("99", EXTRA_PROPERTY_SET, "Extra_Int");

		/* A property set node itself has no value and no status. */
		assertValue("", PROPERTY_SET);
		assertStatus("", PROPERTY_SET);
	}

	@Test
	public void testScalarValues() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);

		assertValue("7", PROPERTY_SET, "Int_Property");
		assertValue("\"seven\"", PROPERTY_SET, "Text_Property");
		assertValue("true", PROPERTY_SET, "Flag_Property");
		assertValue("Green", PROPERTY_SET, "Color_Property");

		assertStatus(LOCAL, PROPERTY_SET, "Int_Property");
		assertStatus(LOCAL, PROPERTY_SET, "Text_Property");
		assertStatus(LOCAL, PROPERTY_SET, "Flag_Property");
		assertStatus(LOCAL, PROPERTY_SET, "Color_Property");
	}

	@Test
	public void testListValueHasOneChildPerElement() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);

		assertValueMatches("\\(\\s*1\\s*,\\s*2\\s*,\\s*3\\s*\\)", PROPERTY_SET, "Number_List");
		assertChildren(List.of("# 0", "# 1", "# 2"), PROPERTY_SET, "Number_List");
		assertValue("1", PROPERTY_SET, "Number_List", "# 0");
		assertValue("2", PROPERTY_SET, "Number_List", "# 1");
		assertValue("3", PROPERTY_SET, "Number_List", "# 2");

		/* A list element is not a property, so the view reports no status for it. */
		assertStatus("", PROPERTY_SET, "Number_List", "# 0");
	}

	@Test
	public void testRangeValueHasOneChildPerBound() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);

		assertValueMatches("1\\s*\\.\\.\\s*9", PROPERTY_SET, "Number_Bounds");
		assertChildren(List.of("minimum", "maximum"), PROPERTY_SET, "Number_Bounds");
		assertValue("1", PROPERTY_SET, "Number_Bounds", "minimum");
		assertValue("9", PROPERTY_SET, "Number_Bounds", "maximum");

		/* A delta adds a third child. */
		assertValueMatches("1\\s*\\.\\.\\s*9\\s+delta\\s+2", PROPERTY_SET, "Bounds_With_Delta");
		assertChildren(List.of("minimum", "maximum", "delta"), PROPERTY_SET, "Bounds_With_Delta");
		assertValue("2", PROPERTY_SET, "Bounds_With_Delta", "delta");
	}

	@Test
	public void testRecordValueHasOneChildPerField() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);

		assertValueMatches("\\[\\s*Horizontal\\s*=>\\s*3\\s*;\\s*Vertical\\s*=>\\s*4\\s*;\\s*\\]", PROPERTY_SET,
				"Position_Property");
		assertChildren(List.of("Horizontal", "Vertical"), PROPERTY_SET, "Position_Property");
		assertValue("3", PROPERTY_SET, "Position_Property", "Horizontal");
		assertValue("4", PROPERTY_SET, "Position_Property", "Vertical");

		/* A field takes the status of the property association that contains it. */
		assertStatus(LOCAL, PROPERTY_SET, "Position_Property", "Horizontal");
	}

	@Test
	public void testFieldThatTheRecordValueLeavesOutIsUndefined() {
		selectInEditor(MODEL_FILE, VALUED_PARTIAL);

		/* Valued.Partial sets Horizontal but not Vertical. */
		assertChildren(List.of("Horizontal"), PROPERTY_SET, "Position_Property");

		showUndefinedProperties(true);
		assertChildren(List.of("Horizontal", "Vertical"), PROPERTY_SET, "Position_Property");
		assertStatus(UNDEFINED, PROPERTY_SET, "Position_Property", "Vertical");
		assertValue("", PROPERTY_SET, "Position_Property", "Vertical");
	}

	@Test
	public void testModalValueHasOneChildPerModeList() {
		selectInEditor(MODEL_FILE, SWITCHED_IMPL);

		/* A modal property association has no single value, so the property itself shows none. */
		assertStatus(LOCAL, PROPERTY_SET, "Int_Property");
		assertValue("", PROPERTY_SET, "Int_Property");

		assertChildren(List.of("in modes (idle)", "in modes (busy)"), PROPERTY_SET, "Int_Property");
		assertValue("1", PROPERTY_SET, "Int_Property", "in modes (idle)");
		assertValue("2", PROPERTY_SET, "Int_Property", "in modes (busy)");
	}

	@Test
	public void testDefaultValue() {
		selectInEditor(MODEL_FILE, PLAIN_IMPL);

		/* Plain.Impl declares no property association at all, so nothing is shown to begin with. */
		assertAbsent(PROPERTY_SET);

		showDefaultValues(true);
		assertStatus(DEFAULT, PROPERTY_SET, "Int_With_Default");
		assertValue("42", PROPERTY_SET, "Int_With_Default");

		/* A property without a default value is still undefined, so it is still hidden. */
		assertAbsent(PROPERTY_SET, "Int_Property");
	}

	@Test
	public void testUndefinedProperty() {
		selectInEditor(MODEL_FILE, PLAIN_IMPL);

		showUndefinedProperties(true);
		assertStatus(UNDEFINED, PROPERTY_SET, "Int_Property");
		assertValue("", PROPERTY_SET, "Int_Property");

		/* A property that has a default value is not undefined, so it is still hidden. */
		assertAbsent(PROPERTY_SET, "Int_With_Default");
	}

	@Test
	public void testInheritedFromExtendedImplementation() {
		selectInEditor(MODEL_FILE, VALUED_DERIVED);

		/* Valued.Derived extends Valued.Impl and declares nothing of its own. */
		assertStatus(INHERITED, PROPERTY_SET, "Int_Property");
		assertValue("7", PROPERTY_SET, "Int_Property");
	}

	@Test
	public void testLocalContainedAndInheritedOnSubcomponent() {
		selectInEditor(MODEL_FILE, ONLY_CHILD);

		/* Container.Impl declares Int_Property with an applies to clause naming only this subcomponent. */
		assertStatus(LOCAL_CONTAINED, PROPERTY_SET, "Int_Property");
		assertValue("11", PROPERTY_SET, "Int_Property");

		/* Inheritable_Property is declared with "inherit", so the value on Container.Impl reaches its subcomponents. */
		assertStatus(INHERITED, PROPERTY_SET, "Inheritable_Property");
		assertValue("5", PROPERTY_SET, "Inheritable_Property");
	}

	@Test
	public void testSharedLocalContainedOnSubcomponent() {
		selectInEditor(MODEL_FILE, FIRST_CHILD);

		/* Flag_Property is declared once with an applies to clause naming two subcomponents. */
		assertStatus(SHARED_LOCAL_CONTAINED, PROPERTY_SET, "Flag_Property");
		assertValue("true", PROPERTY_SET, "Flag_Property");
	}

	@Test
	public void testContainedAssociationsAreNotShownOnTheirOwner() {
		selectInEditor(MODEL_FILE, CONTAINER_IMPL);

		/* The value Container.Impl declares for itself. */
		assertStatus(LOCAL, PROPERTY_SET, "Inheritable_Property");
		assertValue("5", PROPERTY_SET, "Inheritable_Property");

		/* The associations that apply to the subcomponents give Container.Impl no value of its own. */
		assertAbsent(PROPERTY_SET, "Int_Property");
		assertAbsent(PROPERTY_SET, "Flag_Property");
	}
}
