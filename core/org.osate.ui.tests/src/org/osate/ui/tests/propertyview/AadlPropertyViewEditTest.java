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

import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.CREATE_LOCAL_CONTAINED_PROPERTY_ASSOCIATION;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.CREATE_LOCAL_PROPERTY_ASSOCIATION;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.INHERITED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.LOCAL;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.LOCAL_CONTAINED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.MAKE_LOCAL;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.MAKE_LOCAL_CONTAINED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.REMOVE;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.UNDEFINED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertChildren;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertStatus;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertValue;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.clickContextMenu;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.editValue;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.enterValueInCellEditor;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.showUndefinedProperties;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.assertEditorTextContains;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.assertEditorTextDoesNotContain;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.assertEditorTextOccurrences;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.selectInEditor;

import java.util.List;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests the modifications that can be made through the AADL Property Values view: editing a value in the value column,
 * turning an inherited or default value into a local or local contained association, creating an association for a
 * property that has none, and removing a value.
 * <p>
 * The view changes the text editor's document rather than the file on disk, so each test asserts both on what the view
 * shows afterwards and on the text the view wrote. The setup reopens the editor before each test, which discards these
 * modifications.
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class AadlPropertyViewEditTest extends AadlPropertyViewTestBase {
	@Test
	public void testEditScalarValue() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertValue("7", PROPERTY_SET, "Int_Property");

		editValue("8", PROPERTY_SET, "Int_Property");

		assertValue("8", PROPERTY_SET, "Int_Property");
		assertStatus(LOCAL, PROPERTY_SET, "Int_Property");
		assertEditorTextContains(MODEL_FILE, "Int_Property => 8;");
	}

	@Test
	public void testEditRecordField() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertValue("3", PROPERTY_SET, "Position_Property", "Horizontal");

		editValue("6", PROPERTY_SET, "Position_Property", "Horizontal");

		assertValue("6", PROPERTY_SET, "Position_Property", "Horizontal");
		assertValue("4", PROPERTY_SET, "Position_Property", "Vertical");
		assertEditorTextContains(MODEL_FILE, "Horizontal => 6;");
	}

	@Test
	public void testEditListElement() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertValue("2", PROPERTY_SET, "Number_List", "# 1");

		editValue("20", PROPERTY_SET, "Number_List", "# 1");

		assertValue("20", PROPERTY_SET, "Number_List", "# 1");
		assertChildren(List.of("# 0", "# 1", "# 2"), PROPERTY_SET, "Number_List");
		assertEditorTextContains(MODEL_FILE, "(1, 20, 3)");
	}

	@Test
	public void testEditRangeBound() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertValue("9", PROPERTY_SET, "Number_Bounds", "maximum");

		editValue("12", PROPERTY_SET, "Number_Bounds", "maximum");

		assertValue("12", PROPERTY_SET, "Number_Bounds", "maximum");
		assertValue("1", PROPERTY_SET, "Number_Bounds", "minimum");
		assertEditorTextContains(MODEL_FILE, "1 .. 12;");
	}

	@Test
	public void testMakeLocal() {
		selectInEditor(MODEL_FILE, ONLY_CHILD);
		assertStatus(INHERITED, PROPERTY_SET, "Inheritable_Property");
		/* The only association that mentions the property is the one on the enclosing implementation. */
		assertEditorTextOccurrences(MODEL_FILE, "Inheritable_Property", 1);

		clickContextMenu(new String[] { PROPERTY_SET, "Inheritable_Property" }, MAKE_LOCAL);

		/* The subcomponent gets a copy of the inherited value; the inherited association stays where it is. */
		assertStatus(LOCAL, PROPERTY_SET, "Inheritable_Property");
		assertValue("5", PROPERTY_SET, "Inheritable_Property");
		assertEditorTextOccurrences(MODEL_FILE, "Inheritable_Property", 2);
	}

	@Test
	public void testMakeLocalContained() {
		selectInEditor(MODEL_FILE, ONLY_CHILD);
		assertStatus(INHERITED, PROPERTY_SET, "Inheritable_Property");
		assertEditorTextOccurrences(MODEL_FILE, "Inheritable_Property", 1);

		clickContextMenu(new String[] { PROPERTY_SET, "Inheritable_Property" }, MAKE_LOCAL_CONTAINED);

		/* The copy goes onto the enclosing implementation with an applies to clause naming the subcomponent. */
		assertStatus(LOCAL_CONTAINED, PROPERTY_SET, "Inheritable_Property");
		assertValue("5", PROPERTY_SET, "Inheritable_Property");
		assertEditorTextOccurrences(MODEL_FILE, "Inheritable_Property", 2);
	}

	@Test
	public void testMakeLocalContainedAssociationLocal() {
		selectInEditor(MODEL_FILE, ONLY_CHILD);
		assertStatus(LOCAL_CONTAINED, PROPERTY_SET, "Int_Property");

		clickContextMenu(new String[] { PROPERTY_SET, "Int_Property" }, MAKE_LOCAL);

		/* The contained association applied to this subcomponent alone, so it moves rather than being copied. */
		assertStatus(LOCAL, PROPERTY_SET, "Int_Property");
		assertValue("11", PROPERTY_SET, "Int_Property");
		assertEditorTextDoesNotContain(MODEL_FILE, "applies to only_child");
	}

	@Test
	public void testCreateLocalPropertyAssociation() {
		selectInEditor(MODEL_FILE, PLAIN_IMPL);
		showUndefinedProperties(true);
		assertStatus(UNDEFINED, PROPERTY_SET, "Int_Property");

		clickContextMenu(new String[] { PROPERTY_SET, "Int_Property" }, CREATE_LOCAL_PROPERTY_ASSOCIATION);
		enterValueInCellEditor("3");

		assertStatus(LOCAL, PROPERTY_SET, "Int_Property");
		assertValue("3", PROPERTY_SET, "Int_Property");
		assertEditorTextContains(MODEL_FILE, "Property_View_Properties::Int_Property => 3;");
	}

	@Test
	public void testCreateLocalContainedPropertyAssociation() {
		selectInEditor(MODEL_FILE, ONLY_CHILD);
		assertStatus(INHERITED, PROPERTY_SET, "Inheritable_Property");

		clickContextMenu(new String[] { PROPERTY_SET, "Inheritable_Property" },
				CREATE_LOCAL_CONTAINED_PROPERTY_ASSOCIATION);
		enterValueInCellEditor("9");

		assertStatus(LOCAL_CONTAINED, PROPERTY_SET, "Inheritable_Property");
		assertValue("9", PROPERTY_SET, "Inheritable_Property");
		assertEditorTextContains(MODEL_FILE,
				"Property_View_Properties::Inheritable_Property => 9 applies to only_child;");
	}

	@Test
	public void testRemoveLocalContainedAssociation() {
		selectInEditor(MODEL_FILE, ONLY_CHILD);
		/* Keep the row visible after the value is gone. */
		showUndefinedProperties(true);
		assertStatus(LOCAL_CONTAINED, PROPERTY_SET, "Int_Property");

		clickContextMenu(new String[] { PROPERTY_SET, "Int_Property" }, REMOVE);

		assertStatus(UNDEFINED, PROPERTY_SET, "Int_Property");
		assertValue("", PROPERTY_SET, "Int_Property");
		assertEditorTextDoesNotContain(MODEL_FILE, "applies to only_child");
	}

	@Test
	public void testRemoveRecordField() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertChildren(List.of("Horizontal", "Vertical"), PROPERTY_SET, "Position_Property");

		clickContextMenu(new String[] { PROPERTY_SET, "Position_Property", "Vertical" }, REMOVE);

		assertChildren(List.of("Horizontal"), PROPERTY_SET, "Position_Property");
		assertEditorTextDoesNotContain(MODEL_FILE, "Vertical => 4");
	}

	@Test
	public void testRemoveListElement() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertChildren(List.of("# 0", "# 1", "# 2"), PROPERTY_SET, "Number_List");

		clickContextMenu(new String[] { PROPERTY_SET, "Number_List", "# 1" }, REMOVE);

		assertChildren(List.of("# 0", "# 1"), PROPERTY_SET, "Number_List");
		assertValue("1", PROPERTY_SET, "Number_List", "# 0");
		assertValue("3", PROPERTY_SET, "Number_List", "# 1");
	}

	@Test
	public void testRemoveRangeDelta() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertChildren(List.of("minimum", "maximum", "delta"), PROPERTY_SET, "Bounds_With_Delta");

		clickContextMenu(new String[] { PROPERTY_SET, "Bounds_With_Delta", "delta" }, REMOVE);

		assertChildren(List.of("minimum", "maximum"), PROPERTY_SET, "Bounds_With_Delta");
		assertEditorTextDoesNotContain(MODEL_FILE, "delta 2");
	}
}
