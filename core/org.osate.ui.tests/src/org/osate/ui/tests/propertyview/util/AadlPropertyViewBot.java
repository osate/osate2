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
package org.osate.ui.tests.propertyview.util;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.regex.Pattern;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.waits.ICondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotRootMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotToolbarToggleButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.eclipse.ui.PlatformUI;

/**
 * Commands and assertions for the AADL Property Values view.
 * <p>
 * A tree item is addressed by the path of its labels, starting at the property set: <code>{"Timing_Properties",
 * "Compute_Execution_Time", "maximum"}</code>. The assertions wait for the expected result instead of reading the tree
 * once, because the view fills its tree from the {@code Updating Property View} job after the workbench selection
 * changes, so the tree is briefly empty or still shows the previously selected element.
 * <p>
 * Every interaction goes through SWTBot or through {@code Widget.notifyListeners}, which synthesize SWT events and
 * deliver them to a specific widget. No test in this bundle uses real mouse or keyboard input, so a test cannot be
 * disturbed by, and cannot disturb, whatever else is happening on the machine that runs it.
 */
public final class AadlPropertyViewBot {
	public static final String VIEW_ID = "org.osate.xtext.aadl2.ui.propertyview.AadlPropertyView";

	public static final String VIEW_TITLE = "AADL Property Values";

	/** Text of the label the view shows instead of its tree when the selection cannot have properties. */
	public static final String NO_PROPERTIES_TO_SHOW = "No properties to show: Please select a single AADL element that can have properties.";

	/** Column of the tree that shows the property set, property, field, list index or range bound name. */
	public static final int PROPERTY_COLUMN = 0;

	/** Column of the tree that shows the property value. */
	public static final int VALUE_COLUMN = 1;

	/** Column of the tree that shows where the value comes from. */
	public static final int STATUS_COLUMN = 2;

	/* The contents of the status column; these mirror PropertyStatus.toString(). */
	public static final String LOCAL = "local";
	public static final String LOCAL_CONTAINED = "local contained";
	public static final String SHARED_LOCAL_CONTAINED = "shared local contained";
	public static final String INHERITED = "inherited";
	public static final String DEFAULT = "default";
	public static final String UNDEFINED = "undefined";

	/* The items of the tree's context menu. */
	public static final String OPEN_PROPERTY_DEFINITION = "Open Property Definition";
	public static final String OPEN_PROPERTY_ASSOCIATION = "Open Property Association";
	public static final String CREATE_LOCAL_PROPERTY_ASSOCIATION = "Create Local Property Association";
	public static final String CREATE_LOCAL_CONTAINED_PROPERTY_ASSOCIATION = "Create Local Contained Property Association";
	public static final String MAKE_LOCAL = "Make Local";
	public static final String MAKE_LOCAL_CONTAINED = "Make Local Contained";
	public static final String REMOVE = "Remove";

	/** Every item of the tree's context menu, in the order in which the view adds them. */
	public static final List<String> ALL_CONTEXT_MENU_ITEMS = List.of(OPEN_PROPERTY_DEFINITION,
			OPEN_PROPERTY_ASSOCIATION, CREATE_LOCAL_PROPERTY_ASSOCIATION, CREATE_LOCAL_CONTAINED_PROPERTY_ASSOCIATION,
			MAKE_LOCAL, MAKE_LOCAL_CONTAINED, REMOVE);

	/*
	 * Tool tips of the toolbar items. The two toggles describe the action they will perform, so their tool tip changes
	 * when they are toggled and both spellings have to be looked for.
	 */
	private static final String COLLAPSE_ALL = "Collapse All";
	private static final String SHOW_UNDEFINED = "Show undefined properties";
	private static final String HIDE_UNDEFINED = "Hide undefined properties";
	private static final String SHOW_DEFAULT = "Show default property values";
	private static final String HIDE_DEFAULT = "Hide default property values";
	private static final String SHOW_ONLY_IMPORTED = "Show imported properties only";
	private static final String SHOW_ALL_AVAILABLE = "Show all available properties";

	private static final String PROPERTY_SET_FILTERS_MENU = "Property Set Filters...";
	private static final String PROPERTY_SET_FILTERS_DIALOG = "Property Set Filters";

	private static final SWTWorkbenchBot bot = new SWTWorkbenchBot();

	// All methods are static
	private AadlPropertyViewBot() {
	}

	/**
	 * Opens the view if it is not open yet.
	 */
	public static void open() {
		UIThreadRunnable.syncExec(() -> {
			try {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(VIEW_ID);
			} catch (final Exception e) {
				fail("Unable to open the " + VIEW_TITLE + " view: " + e);
			}
		});
		view();
	}

	/**
	 * Closes the view if it is open and opens it again, so that it starts from its initial state.
	 * <p>
	 * This is the only way to undo a property set filter: once the "Property Set Filters" dialog has been confirmed
	 * once, the view keeps filtering by property set and offers no way back to not filtering at all.
	 */
	public static void reopen() {
		close();
		open();
	}

	/**
	 * Closes the view if it is open.
	 */
	public static void close() {
		for (final SWTBotView open : bot.views()) {
			if (VIEW_TITLE.equals(open.getTitle())) {
				open.close();
			}
		}
	}

	public static SWTBotView view() {
		return bot.viewById(VIEW_ID);
	}

	/**
	 * Waits until the view shows its property tree and returns it. The view hides the tree while it looks up the
	 * properties of a newly selected element and whenever the selection cannot have properties.
	 */
	public static SWTBotTree tree() {
		waitUntil(() -> findTree() != null, "The " + VIEW_TITLE + " view does not show its property tree");
		return findTree();
	}

	/**
	 * Asserts that the view shows its "no properties to show" message rather than a property tree.
	 */
	public static void assertNoPropertiesShown() {
		waitUntil(AadlPropertyViewBot::isNoPropertiesLabelShown,
				"The " + VIEW_TITLE + " view does not show '" + NO_PROPERTIES_TO_SHOW + "'");
	}

	/**
	 * Returns the tree item at the given path of labels, failing if it does not appear.
	 */
	public static SWTBotTreeItem item(final String... path) {
		waitUntil(() -> findItem(path) != null, describe(path) + " is not shown in the " + VIEW_TITLE + " view");
		return findItem(path);
	}

	/**
	 * Asserts that the tree eventually shows an item at the given path of labels.
	 */
	public static void assertPresent(final String... path) {
		item(path);
	}

	/**
	 * Asserts that the tree eventually stops showing an item at the given path of labels. Waits for the tree first, so
	 * that the assertion cannot be satisfied by the view still hiding the tree while it looks up the properties of a
	 * newly selected element.
	 */
	public static void assertAbsent(final String... path) {
		tree();
		try {
			waitUntil(() -> findItem(path) == null, "");
		} catch (final TimeoutException e) {
			fail(describe(path) + " is shown in the " + VIEW_TITLE + " view but was not expected");
		}
	}

	/**
	 * Asserts the contents of the status column of the item at the given path of labels.
	 */
	public static void assertStatus(final String expected, final String... path) {
		assertCell(STATUS_COLUMN, "Status", expected, path);
	}

	/**
	 * Asserts the contents of the value column of the item at the given path of labels.
	 */
	public static void assertValue(final String expected, final String... path) {
		assertCell(VALUE_COLUMN, "Value", expected, path);
	}

	/**
	 * Asserts that the contents of the value column of the item at the given path of labels matches {@code regex}. Used
	 * for the values that the view renders with the AADL serializer, where the amount of white space between the tokens
	 * is not part of what is being tested.
	 */
	public static void assertValueMatches(final String regex, final String... path) {
		final Pattern pattern = Pattern.compile(regex);
		final String[] actual = new String[1];
		try {
			waitUntil(() -> {
				actual[0] = cell(VALUE_COLUMN, path);
				return actual[0] != null && pattern.matcher(actual[0]).matches();
			}, "");
		} catch (final TimeoutException e) {
			fail("Value of " + describe(path) + " was '" + actual[0] + "', which does not match '" + regex + "'");
		}
	}

	/**
	 * Asserts the labels of the children of the item at the given path of labels, in the order in which the tree shows
	 * them.
	 */
	public static void assertChildren(final List<String> expected, final String... path) {
		final List<String> actual = new ArrayList<>();
		try {
			waitUntil(() -> {
				actual.clear();
				actual.addAll(children(path));
				return expected.equals(actual);
			}, "");
		} catch (final TimeoutException e) {
			assertEquals("Children of " + describe(path), expected, actual);
		}
	}

	/**
	 * Returns the labels of the children of the item at the given path of labels.
	 */
	public static List<String> children(final String... path) {
		final SWTBotTreeItem item = findItem(path);
		if (item == null) {
			return List.of();
		}
		item.expand();
		return Arrays.stream(item.getItems()).map(SWTBotTreeItem::getText).toList();
	}

	/**
	 * Returns the labels of the top level items of the tree, which are the property sets that contain at least one
	 * property that applies to the selected element and that passes the view's filters.
	 */
	public static List<String> propertySets() {
		tree();
		return findPropertySets();
	}

	/**
	 * Asserts the labels of the top level items of the tree, in the order in which the tree shows them.
	 */
	public static void assertPropertySets(final List<String> expected) {
		tree();
		final List<String> actual = new ArrayList<>();
		try {
			waitUntil(() -> {
				actual.clear();
				actual.addAll(findPropertySets());
				return expected.equals(actual);
			}, "");
		} catch (final TimeoutException e) {
			assertEquals("Property sets shown in the " + VIEW_TITLE + " view", expected, actual);
		}
	}

	/**
	 * Asserts that the tree shows at least {@code minimum} property sets. Used where the exact set depends on which
	 * property sets the installation contributes, and only the fact that there are more than the ones the model imports
	 * matters.
	 */
	public static void assertAtLeastPropertySets(final int minimum) {
		tree();
		final List<String> actual = new ArrayList<>();
		try {
			waitUntil(() -> {
				actual.clear();
				actual.addAll(findPropertySets());
				return actual.size() >= minimum;
			}, "");
		} catch (final TimeoutException e) {
			fail("Expected at least " + minimum + " property sets in the " + VIEW_TITLE + " view but found " + actual);
		}
	}

	/**
	 * Shows or hides the properties that have neither a declared value nor a default value.
	 */
	public static void showUndefinedProperties(final boolean show) {
		setToggle(show, SHOW_UNDEFINED, HIDE_UNDEFINED);
	}

	/**
	 * Shows or hides the properties that take their default value.
	 */
	public static void showDefaultValues(final boolean show) {
		setToggle(show, SHOW_DEFAULT, HIDE_DEFAULT);
	}

	/**
	 * Restricts the tree to the properties of the property sets that the enclosing package imports with a "with" clause,
	 * or lifts that restriction.
	 */
	public static void showOnlyImportedProperties(final boolean only) {
		setToggle(only, SHOW_ONLY_IMPORTED, SHOW_ALL_AVAILABLE);
	}

	public static boolean isShowUndefinedPropertiesChecked() {
		return toggle(SHOW_UNDEFINED, HIDE_UNDEFINED).isChecked();
	}

	public static boolean isShowDefaultValuesChecked() {
		return toggle(SHOW_DEFAULT, HIDE_DEFAULT).isChecked();
	}

	public static void collapseAll() {
		view().toolbarPushButton(COLLAPSE_ALL).click();
	}

	/**
	 * Types {@code text} into the tree's filter box.
	 */
	public static void setFilter(final String text) {
		waitUntil(() -> findFilterBox() != null, "The " + VIEW_TITLE + " view does not show its filter box");
		findFilterBox().setText(text);
	}

	/**
	 * Opens the "Property Set Filters" dialog, presses "Select All" or "Deselect All", and confirms it.
	 */
	public static void filterPropertySets(final boolean selectAll) {
		view().viewMenu(PROPERTY_SET_FILTERS_MENU).click();
		final SWTBotShell dialog = bot.shell(PROPERTY_SET_FILTERS_DIALOG);
		dialog.activate();
		dialog.bot().button(selectAll ? "Select All" : "Deselect All").click();
		dialog.bot().button("OK").click();
		bot.waitUntil(Conditions.shellCloses(dialog));
	}

	/**
	 * Opens the context menu of the item at the given path of labels and reports whether each of {@code labels} is
	 * enabled. The whole menu is read in one go because the view rebuilds it, and recomputes the enablement of every
	 * item in it, each time it is shown.
	 */
	public static Map<String, Boolean> contextMenuEnablement(final String[] path, final List<String> labels) {
		final SWTBotRootMenu menu = item(path).contextMenu();
		final Map<String, Boolean> enablement = new LinkedHashMap<>();
		for (final String label : labels) {
			enablement.put(label, menu.menu(label, true, 0).isEnabled());
		}
		menu.hide();
		return enablement;
	}

	/**
	 * Asserts the enabled state of every item of the context menu of the item at the given path of labels.
	 * {@code enabledItems} lists the items that must be enabled; every other item of
	 * {@link #ALL_CONTEXT_MENU_ITEMS} must be disabled.
	 */
	public static void assertContextMenuEnablement(final String[] path, final List<String> enabledItems) {
		final Map<String, Boolean> expected = new LinkedHashMap<>();
		for (final String label : ALL_CONTEXT_MENU_ITEMS) {
			expected.put(label, enabledItems.contains(label));
		}
		assertEquals("Context menu of " + describe(path), expected,
				contextMenuEnablement(path, ALL_CONTEXT_MENU_ITEMS));
	}

	/**
	 * Clicks an item of the context menu of the item at the given path of labels.
	 */
	public static void clickContextMenu(final String[] path, final String label) {
		item(path).contextMenu(label).click();
	}

	/**
	 * Replaces the value of the item at the given path of labels: activates the cell editor of the value column by
	 * clicking the already selected cell, enters {@code value} and applies it with Enter.
	 */
	public static void editValue(final String value, final String... path) {
		final SWTBotTreeItem item = item(path);
		reveal(item);
		item.select();
		item.click(VALUE_COLUMN);
		enterValueInCellEditor(value);
	}

	/**
	 * Enters {@code value} into the cell editor of the value column and applies it with Enter. Used on its own after a
	 * context menu item that opens the cell editor itself.
	 * <p>
	 * The Enter key is delivered as an {@link ST#VerifyKey} event sent straight to the cell editor's widget rather than
	 * through SWTBot's keyboard, so that the test does not depend on real keyboard input and cannot be disturbed by
	 * whatever else has the keyboard focus on the machine running it. {@link ST#VerifyKey} is the event that the cell
	 * editor listens for, because a single line cell editor has to apply its value before the content assist popup
	 * consumes the key.
	 */
	public static void enterValueInCellEditor(final String value) {
		waitUntil(() -> findCellEditor() != null, "The cell editor of the value column did not open");
		final SWTBotStyledText cellEditor = findCellEditor();
		cellEditor.setText(value);
		waitUntil(() -> value.equals(cellEditor.getText()),
				"The cell editor of the value column does not contain '" + value + "'");
		UIThreadRunnable.syncExec(() -> {
			final Event enter = new Event();
			enter.character = SWT.CR;
			enter.keyCode = SWT.CR;
			enter.doit = true;
			cellEditor.widget.notifyListeners(ST.VerifyKey, enter);
		});
		waitUntil(() -> findCellEditor() == null, "The cell editor of the value column did not close");
	}

	/**
	 * Returns the view to the state it has when it is first opened: both value toggles and the imported properties
	 * toggle off, no text in the filter box, and every property set collapsed. The property set filters cannot be reset
	 * because the view has no way to go back to not filtering by property set at all.
	 */
	public static void resetFilters() {
		showUndefinedProperties(false);
		showDefaultValues(false);
		if (toggle(SHOW_ONLY_IMPORTED, SHOW_ALL_AVAILABLE).isEnabled()) {
			showOnlyImportedProperties(false);
		}
		/* The filter box is part of the tree, so it only exists while the view shows the tree. */
		if (findTree() != null) {
			setFilter("");
			collapseAll();
		}
	}

	private static void assertCell(final int column, final String columnName, final String expected,
			final String[] path) {
		final String[] actual = new String[1];
		try {
			waitUntil(() -> {
				actual[0] = cell(column, path);
				return expected.equals(actual[0]);
			}, "");
		} catch (final TimeoutException e) {
			assertEquals(columnName + " of " + describe(path), expected, actual[0]);
		}
	}

	private static String cell(final int column, final String[] path) {
		final SWTBotTreeItem item = findItem(path);
		return item == null ? null : item.cell(column);
	}

	private static List<String> findPropertySets() {
		final SWTBotTree tree = findTree();
		return tree == null ? List.of() : Arrays.stream(tree.getAllItems()).map(SWTBotTreeItem::getText).toList();
	}

	/*
	 * The lookups below answer "is it there?" in one pass instead of using SWTBot's, which wait SWTBotPreferences.TIMEOUT
	 * before reporting that a widget is missing. Absence is a normal answer here: the view hides its tree while it looks
	 * up properties, and several assertions are about an item not being shown. Polling a lookup that waits 20 seconds for
	 * every negative answer would make every one of those assertions take 20 seconds, and would leave the surrounding
	 * wait no time to make a second attempt.
	 */

	private static SWTBotTree findTree() {
		final List<Tree> trees = view().bot().getFinder().findControls(widgetOfType(Tree.class));
		return trees.isEmpty() ? null : new SWTBotTree(trees.get(0));
	}

	private static SWTBotText findFilterBox() {
		final List<Text> boxes = view().bot().getFinder().findControls(widgetOfType(Text.class));
		return boxes.isEmpty() ? null : new SWTBotText(boxes.get(0));
	}

	private static SWTBotStyledText findCellEditor() {
		final List<StyledText> editors = view().bot().getFinder().findControls(widgetOfType(StyledText.class));
		return editors.isEmpty() ? null : new SWTBotStyledText(editors.get(0));
	}

	private static boolean isNoPropertiesLabelShown() {
		return !view().bot()
				.getFinder()
				.findControls(allOf(widgetOfType(Label.class), withText(NO_PROPERTIES_TO_SHOW)))
				.isEmpty();
	}

	private static SWTBotTreeItem findItem(final String[] path) {
		final SWTBotTree tree = findTree();
		if (tree == null) {
			return null;
		}
		TreeItem item = childWithText(tree.widget, path[0]);
		for (int i = 1; i < path.length && item != null; i++) {
			/*
			 * The tree is filled by a JFace viewer, which only creates the children of an item when it is expanded.
			 */
			new SWTBotTreeItem(item).expand();
			item = childWithText(item, path[i]);
		}
		return item == null ? null : new SWTBotTreeItem(item);
	}

	private static TreeItem childWithText(final Widget parent, final String text) {
		return UIThreadRunnable.syncExec(() -> {
			if (parent.isDisposed()) {
				return null;
			}
			final TreeItem[] children = parent instanceof Tree tree ? tree.getItems() : ((TreeItem) parent).getItems();
			for (final TreeItem child : children) {
				if (text.equals(child.getText())) {
					return child;
				}
			}
			return null;
		});
	}

	private static void reveal(final SWTBotTreeItem item) {
		UIThreadRunnable.syncExec(() -> item.widget.getParent().showItem(item.widget));
	}

	private static void setToggle(final boolean on, final String tooltipWhenOff, final String tooltipWhenOn) {
		final SWTBotToolbarToggleButton button = toggle(tooltipWhenOff, tooltipWhenOn);
		if (button.isChecked() != on) {
			button.click();
		}
	}

	private static SWTBotToolbarToggleButton toggle(final String... tooltips) {
		for (final String tooltip : tooltips) {
			try {
				return view().toolbarToggleButton(tooltip);
			} catch (final WidgetNotFoundException e) {
				// Try the tool tip the item has in its other state.
			}
		}
		throw new WidgetNotFoundException(
				"No toggle in the " + VIEW_TITLE + " view has one of the tool tips " + Arrays.toString(tooltips));
	}

	private static void waitUntil(final BooleanSupplier condition, final String failureMessage) {
		bot.waitUntil(condition(condition, failureMessage));
	}

	private static ICondition condition(final BooleanSupplier condition, final String failureMessage) {
		return new DefaultCondition() {
			@Override
			public boolean test() {
				return condition.getAsBoolean();
			}

			@Override
			public String getFailureMessage() {
				return failureMessage;
			}
		};
	}

	private static String describe(final String[] path) {
		return "'" + String.join(" > ", path) + "'";
	}
}
