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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.DEFAULT;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.LOCAL;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.UNDEFINED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertAbsent;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertAtLeastPropertySets;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertPresent;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertPropertySets;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertStatus;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.collapseAll;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.isShowDefaultValuesChecked;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.isShowUndefinedPropertiesChecked;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.item;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.setFilter;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.showDefaultValues;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.showOnlyImportedProperties;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.showUndefinedProperties;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.selectInEditor;

import java.util.List;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests the toolbar items of the AADL Property Values view and its filter box: showing and hiding the undefined
 * properties and the default values, restricting the tree to the property sets that the enclosing package imports,
 * filtering by property name, and collapsing the tree.
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class AadlPropertyViewFilterTest extends AadlPropertyViewTestBase {
	@Test
	public void testValueTogglesAreOffToBeginWith() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertPresent(PROPERTY_SET, "Int_Property");

		assertFalse("The toggle for undefined properties is checked", isShowUndefinedPropertiesChecked());
		assertFalse("The toggle for default values is checked", isShowDefaultValuesChecked());

		/* So only the properties for which the model declares a value are shown. */
		assertAbsent(PROPERTY_SET, "Int_With_Default");
		assertAbsent(PROPERTY_SET, "Inheritable_Property");
	}

	@Test
	public void testShowingAndHidingDefaultValues() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertAbsent(PROPERTY_SET, "Int_With_Default");

		showDefaultValues(true);
		assertStatus(DEFAULT, PROPERTY_SET, "Int_With_Default");
		/* The properties that have neither a declared nor a default value are still hidden. */
		assertAbsent(PROPERTY_SET, "Inheritable_Property");

		showDefaultValues(false);
		assertAbsent(PROPERTY_SET, "Int_With_Default");
		assertStatus(LOCAL, PROPERTY_SET, "Int_Property");
	}

	@Test
	public void testShowingAndHidingUndefinedProperties() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertAbsent(PROPERTY_SET, "Inheritable_Property");

		showUndefinedProperties(true);
		assertStatus(UNDEFINED, PROPERTY_SET, "Inheritable_Property");
		/* The properties that take their default value are still hidden. */
		assertAbsent(PROPERTY_SET, "Int_With_Default");

		showUndefinedProperties(false);
		assertAbsent(PROPERTY_SET, "Inheritable_Property");
		assertStatus(LOCAL, PROPERTY_SET, "Int_Property");
	}

	@Test
	public void testBothValueTogglesTogetherShowEveryApplicableProperty() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);

		showUndefinedProperties(true);
		showDefaultValues(true);

		assertStatus(LOCAL, PROPERTY_SET, "Int_Property");
		assertStatus(DEFAULT, PROPERTY_SET, "Int_With_Default");
		assertStatus(UNDEFINED, PROPERTY_SET, "Inheritable_Property");

		/* The property sets are no longer limited to the ones the model declares a value from. */
		assertPresent(NOT_IMPORTED_PROPERTY_SET);
		assertAtLeastPropertySets(3);
	}

	@Test
	public void testShowOnlyImportedPropertyGroups() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);

		/* Bring in property sets that the package does not import with a "with" clause. */
		showUndefinedProperties(true);
		showDefaultValues(true);
		assertPresent(NOT_IMPORTED_PROPERTY_SET);

		showOnlyImportedProperties(true);
		assertPropertySets(List.of(EXTRA_PROPERTY_SET, PROPERTY_SET));
		/* Within an imported property set every property is still shown. */
		assertStatus(UNDEFINED, PROPERTY_SET, "Inheritable_Property");

		showOnlyImportedProperties(false);
		assertPresent(NOT_IMPORTED_PROPERTY_SET);
	}

	@Test
	public void testFilterBoxRestrictsTheTreeToMatchingProperties() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertPresent(PROPERTY_SET, "Int_Property");
		assertPresent(EXTRA_PROPERTY_SET, "Extra_Int");

		setFilter("Number_List");
		assertPresent(PROPERTY_SET, "Number_List");
		assertAbsent(PROPERTY_SET, "Int_Property");
		/* A property set none of whose properties match is dropped from the tree. */
		assertAbsent(EXTRA_PROPERTY_SET);

		setFilter("");
		assertPresent(PROPERTY_SET, "Int_Property");
		assertPresent(EXTRA_PROPERTY_SET, "Extra_Int");
	}

	@Test
	public void testFilterBoxMatchesThePrefixOfAPropertyName() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertPresent(PROPERTY_SET, "Number_List");

		setFilter("Number_");
		assertPresent(PROPERTY_SET, "Number_List");
		assertPresent(PROPERTY_SET, "Number_Bounds");
		assertAbsent(PROPERTY_SET, "Bounds_With_Delta");
	}

	@Test
	public void testFilterBoxKeepsTheChildrenOfAMatchingProperty() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertPresent(PROPERTY_SET, "Number_Bounds", "minimum");

		setFilter("Number_Bounds");
		assertPresent(PROPERTY_SET, "Number_Bounds", "minimum");
		assertPresent(PROPERTY_SET, "Number_Bounds", "maximum");
	}

	@Test
	public void testCollapseAll() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);

		item(PROPERTY_SET).expand();
		assertTrue("The property set did not expand", item(PROPERTY_SET).isExpanded());

		collapseAll();
		assertFalse("Collapse All left the property set expanded", item(PROPERTY_SET).isExpanded());
	}
}
