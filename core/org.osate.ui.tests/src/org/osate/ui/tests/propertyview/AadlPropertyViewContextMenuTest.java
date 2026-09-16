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
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.DEFAULT;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.INHERITED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.LOCAL;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.LOCAL_CONTAINED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.MAKE_LOCAL;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.MAKE_LOCAL_CONTAINED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.OPEN_PROPERTY_ASSOCIATION;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.OPEN_PROPERTY_DEFINITION;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.REMOVE;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.SHARED_LOCAL_CONTAINED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.UNDEFINED;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertContextMenuEnablement;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertPresent;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertStatus;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.showDefaultValues;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.showUndefinedProperties;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.selectInEditor;

import java.util.List;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests which items of the context menu of the AADL Property Values view are enabled. The view recomputes this from the
 * kind of tree item that is selected, from where the value of the selected property comes from, and from what kind of
 * model element the view is showing, so there is one test per interesting combination of the three.
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class AadlPropertyViewContextMenuTest extends AadlPropertyViewTestBase {
	@Test
	public void testPropertySetNode() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertPresent(PROPERTY_SET);

		/* A property set can only be opened; none of the actions on a value apply to it. */
		assertContextMenuEnablement(new String[] { PROPERTY_SET }, List.of(OPEN_PROPERTY_DEFINITION));
	}

	@Test
	public void testLocalPropertyOfAClassifier() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertStatus(LOCAL, PROPERTY_SET, "Int_Property");

		/*
		 * The value is already local, so it can be opened and removed. It cannot be made local contained because a
		 * classifier is not contained in anything that could hold the association.
		 */
		assertContextMenuEnablement(new String[] { PROPERTY_SET, "Int_Property" },
				List.of(OPEN_PROPERTY_DEFINITION, OPEN_PROPERTY_ASSOCIATION, REMOVE));
	}

	@Test
	public void testModalPropertyOfAClassifier() {
		selectInEditor(MODEL_FILE, SWITCHED_IMPL);
		assertStatus(LOCAL, PROPERTY_SET, "Int_Property");

		/* A modal association cannot be edited from the view, so it cannot be removed either. */
		assertContextMenuEnablement(new String[] { PROPERTY_SET, "Int_Property" },
				List.of(OPEN_PROPERTY_DEFINITION, OPEN_PROPERTY_ASSOCIATION));
	}

	@Test
	public void testUndefinedPropertyOfAClassifier() {
		selectInEditor(MODEL_FILE, PLAIN_IMPL);
		showUndefinedProperties(true);
		assertStatus(UNDEFINED, PROPERTY_SET, "Int_Property");

		/* There is no association yet, so one can be created but nothing can be moved or removed. */
		assertContextMenuEnablement(new String[] { PROPERTY_SET, "Int_Property" },
				List.of(OPEN_PROPERTY_DEFINITION, CREATE_LOCAL_PROPERTY_ASSOCIATION));
	}

	@Test
	public void testDefaultValuedPropertyOfAClassifier() {
		selectInEditor(MODEL_FILE, PLAIN_IMPL);
		showDefaultValues(true);
		assertStatus(DEFAULT, PROPERTY_SET, "Int_With_Default");

		/* The default value can be turned into a local association either by creating one or by making it local. */
		assertContextMenuEnablement(new String[] { PROPERTY_SET, "Int_With_Default" },
				List.of(OPEN_PROPERTY_DEFINITION, CREATE_LOCAL_PROPERTY_ASSOCIATION, MAKE_LOCAL));
	}

	@Test
	public void testLocalContainedPropertyOfASubcomponent() {
		selectInEditor(MODEL_FILE, ONLY_CHILD);
		assertStatus(LOCAL_CONTAINED, PROPERTY_SET, "Int_Property");

		/* The association is already contained and applies to this subcomponent alone. */
		assertContextMenuEnablement(new String[] { PROPERTY_SET, "Int_Property" },
				List.of(OPEN_PROPERTY_DEFINITION, OPEN_PROPERTY_ASSOCIATION, MAKE_LOCAL, REMOVE));
	}

	@Test
	public void testInheritedPropertyOfASubcomponent() {
		selectInEditor(MODEL_FILE, ONLY_CHILD);
		assertStatus(INHERITED, PROPERTY_SET, "Inheritable_Property");

		/*
		 * The association belongs to the enclosing implementation, so everything that gives this subcomponent a value of
		 * its own is offered, but the inherited association itself cannot be removed from here.
		 */
		assertContextMenuEnablement(new String[] { PROPERTY_SET, "Inheritable_Property" },
				List.of(OPEN_PROPERTY_DEFINITION, OPEN_PROPERTY_ASSOCIATION, CREATE_LOCAL_PROPERTY_ASSOCIATION,
						CREATE_LOCAL_CONTAINED_PROPERTY_ASSOCIATION, MAKE_LOCAL, MAKE_LOCAL_CONTAINED));
	}

	@Test
	public void testSharedLocalContainedPropertyOfASubcomponent() {
		selectInEditor(MODEL_FILE, FIRST_CHILD);
		assertStatus(SHARED_LOCAL_CONTAINED, PROPERTY_SET, "Flag_Property");

		/*
		 * The association applies to more than one subcomponent, so there is no single association to open for this one.
		 * Remove is offered because the check behind it does not distinguish a shared association from one that applies
		 * to this subcomponent alone; this is the current behavior of the view, not necessarily the intended one.
		 */
		assertContextMenuEnablement(new String[] { PROPERTY_SET, "Flag_Property" },
				List.of(OPEN_PROPERTY_DEFINITION, MAKE_LOCAL, MAKE_LOCAL_CONTAINED, REMOVE));
	}

	@Test
	public void testRecordField() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertPresent(PROPERTY_SET, "Position_Property", "Horizontal");

		/* A field of a record value with more than one field can be removed from the value. */
		assertContextMenuEnablement(new String[] { PROPERTY_SET, "Position_Property", "Horizontal" },
				List.of(OPEN_PROPERTY_DEFINITION, REMOVE));
	}

	@Test
	public void testLastRemainingRecordField() {
		selectInEditor(MODEL_FILE, VALUED_PARTIAL);
		assertPresent(PROPERTY_SET, "Position_Property", "Horizontal");

		/* Removing the only field of a record value would leave an empty value, so it is not offered. */
		assertContextMenuEnablement(new String[] { PROPERTY_SET, "Position_Property", "Horizontal" },
				List.of(OPEN_PROPERTY_DEFINITION));
	}

	@Test
	public void testListElement() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertPresent(PROPERTY_SET, "Number_List", "# 0");

		/* A list element has no property definition of its own, but it can be removed from the list. */
		assertContextMenuEnablement(new String[] { PROPERTY_SET, "Number_List", "# 0" }, List.of(REMOVE));
	}

	@Test
	public void testRangeBounds() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);
		assertPresent(PROPERTY_SET, "Number_Bounds", "minimum");

		/* A range always has a minimum and a maximum, so neither can be removed. */
		assertContextMenuEnablement(new String[] { PROPERTY_SET, "Number_Bounds", "minimum" }, List.of());
		assertContextMenuEnablement(new String[] { PROPERTY_SET, "Number_Bounds", "maximum" }, List.of());

		/* The delta of a range is optional, so it can be removed. */
		assertContextMenuEnablement(new String[] { PROPERTY_SET, "Bounds_With_Delta", "delta" }, List.of(REMOVE));
	}
}
