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

import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertAbsent;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertPresent;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.assertPropertySets;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.filterPropertySets;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.showDefaultValues;
import static org.osate.ui.tests.propertyview.util.AadlPropertyViewBot.showUndefinedProperties;
import static org.osate.ui.tests.propertyview.util.WorkbenchTestUtil.selectInEditor;

import java.util.List;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests the "Property Set Filters..." dialog in the view menu of the AADL Property Values view.
 * <p>
 * This is a class of its own with a single test because the view has no way back to not filtering by property set at
 * all: once the dialog has been confirmed the view keeps applying whatever filter it was given. Every test class opens
 * the view from scratch, so a following class is unaffected.
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class AadlPropertyViewPropertySetFilterTest extends AadlPropertyViewTestBase {
	@Test
	public void testPropertySetFilterDialog() {
		selectInEditor(MODEL_FILE, VALUED_IMPL);

		/* Bring in the property sets contributed by plug-ins, which is what the dialog lists. */
		showUndefinedProperties(true);
		showDefaultValues(true);
		assertPresent(NOT_IMPORTED_PROPERTY_SET);
		assertPresent(PROPERTY_SET, "Int_Property");

		/* Deselecting every property set empties the tree. */
		filterPropertySets(false);
		assertPropertySets(List.of());

		/* Selecting every property set brings the contributed property sets back. */
		filterPropertySets(true);
		assertPresent(NOT_IMPORTED_PROPERTY_SET);

		/*
		 * The dialog only lists the property sets that plug-ins contribute, so a property set that lives in the
		 * workspace can never be selected in it and stays hidden even after "Select All". This is the current behavior
		 * of the view, not necessarily the intended one.
		 */
		assertAbsent(PROPERTY_SET);
		assertAbsent(EXTRA_PROPERTY_SET);
	}
}
