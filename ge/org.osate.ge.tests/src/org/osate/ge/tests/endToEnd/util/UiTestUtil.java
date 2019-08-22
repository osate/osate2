package org.osate.ge.tests.endToEnd.util;

import static org.eclipse.swtbot.swt.finder.SWTBotAssert.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swtbot.eclipse.finder.finders.WorkbenchContentsFinder;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.AbstractSWTBot;
import org.eclipse.swtbot.swt.finder.widgets.AbstractSWTBotControl;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTableItem;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;

/**
 * Provides functions for controlling the user interface.
 * This class should not contain any OSATE specific functionalities. Rather it wraps SWTBot functionality into assertions and commands so
 * that it can be used to build higher level assertions and commands.
 * Public methods of this class should be a minimal wrapper around SWTBot and not return any SWTBot specific data structures.
 * Normally, only primitive values should be returned.
 */
public class UiTestUtil {
	private static final SWTGefBot bot;

	// All methods are static
	private UiTestUtil() {
	}

	static {
		bot = new SWTGefBot();
		SWTBotPreferences.TIMEOUT = 5000;
	}

	/**
	 * Waits until the specified condition is true. Reports the specified failure message if the timeout expires.
	 */
	public static void waitUntil(final BooleanSupplier condition, final String failureMessage) {
		// Wait until the condition is true
		bot.waitUntil(new DefaultCondition() {
			@Override
			public boolean test() throws Exception {
				return condition.getAsBoolean();
			}

			@Override
			public String getFailureMessage() {
				return failureMessage;
			}
		});
	}

	/**
	 * Clicks a menu in the top level menu.
	 */
	public static void clickMenu(final String... texts) {
		bot.menu().menu(texts).click();
	}

	/**
	 * Waits for a window with the specified title to appear.
	 */
	public static void waitForWindowWithTitle(final String title) {
		bot.waitUntil(Conditions.shellIsActive(title));
	}

	/**
	 * Asserts that the nth text field has the specified value.
	 */
	public static void assertTextFieldText(final String message, final int index, final String expectedValue) {
		final SWTBotText text = bot.text(index);
		assertEquals(message, expectedValue, text.getText());
	}

	/**
	 * Sets the text in the nth text field to the specified value.
	 * @param index
	 * @param value
	 */
	public static void setTextField(final int index, final String value) {
		bot.text(index).setText(value);
		assertTextFieldText("New value not valid", index, value);
	}

	/**
	 * Asserts that the nth combo box has the specified selection.
	 */
	public static void assertComboBoxSelection(final String message, final int index, final String expected) {
		assertEquals(message, expected, bot.comboBox(index).getText());
	}

	/**
	 * Sets the selection of the nth combo box to the specified value.
	 */
	public static void setComboBoxSelection(final int index, final String value) {
		bot.comboBox(index).setSelection(value);
		assertComboBoxSelection("New value not valid", index, value);
	}

	/**
	 * Clicks the radio button which has the specified text.
	 */
	public static void clickRadioButton(final String text) {
		bot.radio(text).click();
	}

	/**
	 * Clicks the button which has the specified text.
	 */
	public static void clickButton(final String text) {
		final SWTBotButton btn = bot.button(text);
		btn.click();
	}

	/**
	 * Clicks the context menu of the focused widget
	 */
	public static void clickContextMenuOfFocused(final String... texts) {
		getFocusedWidget().contextMenu().menu(texts).click();
	}

	/**
	 * Asserts that the title of the active title contains the specified string
	 */
	public static void assertActiveShellTitleContains(final String value) {
		assertContains(value, bot.activeShell().getText());
	}

	/**
	 * Asserts that a view with the specified title is visible
	 */
	public static void assertViewIsVisible(final String title) {
		bot.viewByTitle(title);
	}

	/**
	 * Asserts that an item at the specified texts is contained in the first tree in the view with the specified title.
	 */
	public static void assertItemExistsInTreeView(final String viewTitle, final String... itemTexts) {
		assertTrue("Item with texts '" + String.join(",", itemTexts) + "' not found in view: " + viewTitle,
				doesItemExistsInTreeView(viewTitle, itemTexts));
	}

	/**
	 * Returns whether an item at the specified texts is contained in the first tree in the view with the specified title.
	 * Throws an exception if it is unable to find the tree.
	 */
	public static boolean doesItemExistsInTreeView(final String viewTitle, final String... itemTexts) {
		return getItemInTree(getFirstTreeInView(viewTitle), itemTexts).isPresent();
	}

	/**
	 * Selects an item at the specified texts in the first tree in the view with the specified title.
	 * Throws an exception if it is unable to do so.
	 */
	public static void selectItemInTreeView(final String viewTitle, final String... itemTexts) {
		final Optional<SWTBotTreeItem> item = getItemInTree(getFirstTreeInView(viewTitle), itemTexts);
		assertTrue("Item with texts '" + String.join(",", itemTexts) + "' not found in tree", item.isPresent());
		item.get().select();
	}

	/**
	 * Gets the first tree in the view with the specified title.
	 * Throws an exception if it is unable to do so.
	 */
	private static SWTBotTree getFirstTreeInView(final String viewTitle) {
		return bot.viewByTitle(viewTitle).bot().tree(0);
	}

	/**
	 * Returns an optional describing the tree item located at the specified texts from the specified tree.
	 * @param itemTexts a path to the item containing the text of each item along the tree hierarchy.
	 * @returns an empty optional if the item is not found. Otherwise, it returns an optional containing the item.
	 */
	private static Optional<SWTBotTreeItem> getItemInTree(final SWTBotTree tree, final String... itemTexts) {
		Optional<SWTBotTreeItem> item = Arrays.stream(tree.getAllItems())
				.filter(tmpItem -> tmpItem.getText().equals(itemTexts[0])).findAny();
		if (item.isPresent()) {
			for (int i = 1; i < itemTexts.length && item.isPresent(); i++) {
				item = Arrays.stream(item.get().getItems()).filter(tmpItem -> tmpItem.getText().equals(itemTexts[0]))
						.findAny();
			}
		}

		return item;
	}

	/**
	 * Returns whether the active editor is of the specified type and has the specified input name
	 */
	public static boolean isEditorActive(final Class<?> editorClass, final String inputName) {
		final WorkbenchContentsFinder finder = new WorkbenchContentsFinder();
		final IEditorReference editor = finder.findActiveEditor();
		// Check type of editor
		if (!editorClass.isInstance(editor.getEditor(false))) {
			return false;
		}

		// Check the name provided by the editor's input
		try {
			if (editor.getEditorInput() == null) {
				return false;
			}

			return Objects.equals(editor.getEditorInput().getName(), inputName);
		} catch (final PartInitException e) {
			// Print error and return false
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Returns a bot for the focused widget
	 */
	private static AbstractSWTBot<?> getFocusedWidget() {
		final Control focused = bot.getFocusedWidget();
		assertTrue("Focused widget is null", focused != null);
		return new AbstractSWTBotControl<Control>(focused);
	}

	/**
	 * Checks a row in the simple table which is the nth table in the active shell.
	 * Assumes the table is a simple table with checkboxes. Such a table does not have any columns.
	 */
	public static void checkItemInSimpleTable(final int tableIndex, final String text) {
		final SWTBotTable table = bot.table(tableIndex);
		for (int row = 0; row < table.rowCount(); row++) {
			final SWTBotTableItem rowItem = table.getTableItem(row);
			if (Objects.equals(rowItem.getText(), text)) {
				rowItem.check();
				return;
			}
		}
	}
}
