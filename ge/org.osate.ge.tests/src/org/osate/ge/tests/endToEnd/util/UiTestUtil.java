/**
* Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.tests.endToEnd.util;

import static org.eclipse.swtbot.swt.finder.SWTBotAssert.*;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.finders.WorkbenchContentsFinder;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.AbstractSWTBot;
import org.eclipse.swtbot.swt.finder.widgets.AbstractSWTBotControl;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotCLabel;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotCanvas;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotSpinner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTableItem;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.gef.DiagramEditorNode;
import org.osate.ge.gef.LabelNode;
import org.osate.ge.gef.palette.Palette;
import org.osate.ge.gef.palette.PaletteGroup;
import org.osate.ge.gef.palette.PaletteItem;
import org.osate.ge.gef.ui.editor.AgeEditor;
import org.osate.ge.gef.ui.editor.AgeEditorPaletteModel;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.swt.BorderedCLabel;
import org.osate.ge.tests.fx.JavaFXBot;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Provides functions for controlling the user interface.
 * This class should not contain as little OSATE specific functionality as possible.
 * Rather it wraps SWTBot and GEF functionality into assertions and commands so that it can be used to build higher level assertions
 * and commands.
 * Public methods of this class should be a minimal wrapper around SWTBot and GEF and not return any SWTBot or GEF specific data structures.
 * Typically, only primitive values should be returned.
 */
public class UiTestUtil {
	private static final SWTWorkbenchBot bot;
	private static final JavaFXBot fxBot = new JavaFXBot();
	private static final HashSet<String> allowedViewTitles = Sets.newHashSet("AADL Navigator", "AADL Diagrams",
			"Properties", "Outline");

	// All methods are static
	private UiTestUtil() {
	}

	static {
		bot = new SWTWorkbenchBot();
		SWTBotPreferences.TIMEOUT = 10000;
	}

	/**
	 * Function that should be called to perform test setup which is shared with all tests
	 */
	public static void prepareForTesting() {
		// Sets the window size. Most of the test functions are size independent but selecting tabs in the properties view requires the tab to be visible.
		Display.getDefault().syncExec(() -> {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().setSize(1920, 1080);

			// Close all views whose titles aren't in the whitelist
			for (final SWTBotView view : bot.views()) {
				if (!allowedViewTitles.contains(view.getTitle())) {
					view.close();
				}
			}

			// Save and close all editors
			for (final SWTBotEditor editor : bot.editors()) {
				editor.saveAndClose();
			}

			System.gc();
		});
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
	 * Checks the item in the tree at the specified item text path in the first tree in the shell with the specified title.
	 * Throws an exception if it is unable to do so.
	 */
	public static void checkTreeItemInWindowWithTitle(final String title, final String... itemTexts) {
		final Optional<SWTBotTreeItem> item = getItemInTree(bot.shell(title).bot().tree(0), itemTexts);
		assertTrue("Item with texts '" + String.join(",", itemTexts) + "' not found in tree", item.isPresent());
		item.orElseThrow().check();
	}

	/**
	 * Waits for a window with the specified title to appear but is not the specified window.
	 */
	public static void waitForOtherWindowWithTitle(final String title, final Shell windowToIgnore) {
		waitUntil(() -> {
			final AtomicBoolean result = new AtomicBoolean(false);
			Display.getDefault().syncExec(() -> {
				final Shell activeShell = bot.getFinder().activeShell();
				result.set(activeShell != null && activeShell != windowToIgnore
						&& Objects.equals(title, bot.activeShell().getText()));
			});

			return result.get();
		}, "Unable to find window with title '" + title + "' which is also not the specified window");
	}

	/**
	 * Returns the active shell
	 * @return the active shell
	 */
	public static Shell getActiveWindow() {
		return bot.getFinder().activeShell();
	}

	public static void setFocusToShell(final String title) {
		bot.shell(title).setFocus();
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
	public static void setTextFieldText(final int index, final String value) {
		bot.text(index).setText(value);
		assertTextFieldText("New value not valid", index, value);
	}

	/**
	 * Asserts that the text field with the specified ID has the specified value.
	 */
	public static void assertTextFieldWithIdText(final String message, final String id, final String expectedValue) {
		final SWTBotText text = bot.textWithId(id);
		assertEquals(message, expectedValue, text.getText());
	}

	/**
	 * Sets the text for the text with the specified ID.
	 * @param id is the text field's id
	 * @param value is the new value
	 */
	public static void setTextFieldWithIdText(final String id, final String value) {
		bot.textWithId(id).setText(value);
		assertTextFieldWithIdText("New value not valid", id, value);
	}

	/**
	 * Sets the focus to a text widget with the specified ID
	 * @param id is the ID of the text widget
	 */
	public static void setFocusToTextFieldWithId(final String id) {
		bot.textWithId(id).setFocus();
	}

	/**
	 * Asserts that the nth spinner has the specified value.
	 */
	public static void assertSpinnerValue(final String message, final int index, final int expectedValue) {
		final SWTBotSpinner spinner = bot.spinner(index);
		assertEquals(message, expectedValue, spinner.getSelection());
	}

	/**
	 * Sets the text in the nth spinner to the specified value.
	 * @param index
	 * @param value
	 */
	public static void setSpinnerValue(final int index, final int value) {
		bot.spinner(index).setSelection(value);
		assertSpinnerValue("New value not valid", index, value);
	}

	/**
	 * Asserts that the nth combo box has the specified selection.
	 */
	public static void assertComboBoxSelection(final String message, final int index, final String expected) {
		assertEquals(message, expected, bot.comboBox(index).getText());
	}

	/**
	 * Waits until the nth combo box has the specified selection
	 */
	public static void waitUntilComboBoxSelect(final int comboIndex, final String text) {
		waitUntil(() -> Objects.equals(text, bot.comboBox(comboIndex).getText()),
				"Combo selection does not match '" + text + "'");
	}

	/**
	 * Waits until the combo box with the specified ID has the specified selection
	 */
	public static void waitUntilComboBoxWithIdSelect(final String id, final String text) {
		waitUntil(() -> Objects.equals(text, bot.comboBoxWithId(id).getText()),
				"Combo selection does not match '" + text + "'");
	}

	/**
	 * Sets the selection of the nth combo box to the specified value.
	 */
	public static void setComboBoxSelection(final int index, final String value) {
		bot.comboBox(index).setSelection(value);
		assertComboBoxSelection("New value not valid", index, value);
	}

	/**
	 * Sets the combo box with specified ID to the specified value.
	 */
	public static void setComboBoxWithIdSelection(final String id, final String value) {
		bot.comboBoxWithId(id).setSelection(value);
	}

	/**
	 * Clicks the radio button which has the specified text.
	 */
	public static void clickRadioButton(final String text) {
		bot.radio(text).click();
	}

	/**
	 * Returns whether the radio button with the specified mnemonic is selected.
	 */
	public static boolean isRadioButtonSelected(final String text) {
		return bot.radio(text).isSelected();
	}

	/**
	 * Clicks the check box at specified index.
	 */
	public static void clickCheckbox(final int index) {
		bot.checkBox(index).click();
	}

	/**
	 * Types the specified text in the StyledText with the specified id.
	 */
	public static void typeInStyledText(final String id, final String text) {
		final SWTBotStyledText styledText = bot.styledTextWithId(id);
		styledText.setText(text);

		Display.getDefault().syncExec(() -> {
			// Send notification
			styledText.widget.notifyListeners(SWT.KeyUp, new Event());
		});

		waitForStyledTextToMatch(id, text);
	}

	/**
	 * Executes {@link IHandlerService} command with specified id and event.
	 */
	public static void executeHandlerServiceCommandWithId(final String cmdId,
			final org.eclipse.swt.widgets.Event event) {
		Display.getDefault().asyncExec(() -> {
			final IHandlerService service = PlatformUI.getWorkbench().getService(IHandlerService.class);
			try {
				service.executeCommand(cmdId, event);
			} catch (final Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Returns the text of the StyledText with the specified id.
	 */
	public static String getStyledTextWithIdText(final String id) {
		final SWTBotStyledText styledText = bot.styledTextWithId(id);
		return styledText.getText();
	}

	public static void waitForStyledTextToMatch(final String id, final String text) {
		final SWTBotStyledText styledText = bot.styledTextWithId(id);
		waitUntil(() -> styledText.getText().equals(text),
				"StyledText text '" + styledText.getText() + "' does not match expected '" + text + "'");
	}

	/**
	 * Clicks the checkbox with the specified mnemonic text
	 */
	public static void clickCheckbox(final String text) {
		bot.checkBox(text).click();
	}

	/**
	 * Clicks the checkbox with the specified id
	 */
	public static void clickCheckboxById(final String id) {
		bot.checkBoxWithId(id).click();
	}

	/**
	 * Returns whether check box with the specified mnemonic text is checked
	 */
	public static boolean isCheckboxChecked(final String text) {
		return bot.checkBox(text).isChecked();
	}

	/**
	 * Returns whether check box with the specified id is checked
	 */
	public static boolean isCheckboxCheckedById(final String id) {
		return bot.checkBoxWithId(id).isChecked();
	}

	/**
	 * Clicks the button which has the specified text.
	 */
	public static void clickButton(final String text) {
		final SWTBotButton btn = bot.button(text);
		btn.click();
	}

	/**
	 * Clicks the nth button which has the specified text.
	 */
	public static void clickButton(final String text, final int index) {
		final SWTBotButton btn = bot.button(text, index);
		btn.click();
	}

	/**
	 * Clicks the button which has the specified testing ID.
	 */
	public static void clickButtonWithId(final String id) {
		final SWTBotButton btn = bot.buttonWithId(id);
		btn.click();
	}

	/**
	 * Clicks the checkbox which has the specified testing ID.
	 */
	public static void clickCheckboxWithId(final String id) {
		bot.checkBoxWithId(id).click();
	}

	public static void clickToolbarItem(final String title) {
		bot.toolbarButtonWithTooltip(title).click();
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
	public static void assertActiveWindowTitleContains(final String value) {
		assertContains(value, bot.activeShell().getText());
	}

	/**
	 * Asserts that a view with the specified title is visible
	 */
	public static void assertViewIsVisible(final String title) {
		bot.viewByTitle(title);
	}

	public static void setViewFocus(final String title) {
		bot.viewByTitle(title).setFocus();
	}

	/**
	 * Clicks a properties view tab. If the tab is not visible due to scrolling, it will not be clicked.
	 * @param title
	 */
	public static void clickPropertiesViewTab(final String title) {
		final SWTBotCanvas canvas = findViewCanvasByTitle(title);
		canvas.click();
	}

	public static void clickTableItem(final int tableIndex, final String tableItem) {
		bot.table(tableIndex).getTableItem(tableItem).click();
	}

	public static void clickTableItem(final int tableIndex, final int rowIndex) {
		bot.table(tableIndex).getTableItem(rowIndex).click();
	}

	public static int getNumberOfTableRows(final int tableIndex) {
		return bot.table(tableIndex).rowCount();
	}

	public static void assertNumberOfTableRows(final int tableIndex, final int expectedValue) {
		assertEquals("Unexpected number of table rows", expectedValue, getNumberOfTableRows(tableIndex));
	}

	public static void assertTableItemText(final int tableIndex, final int rowIndex, final String expectedValue) {
		assertEquals("Unexpected table item text", expectedValue,
				bot.table(tableIndex).getTableItem(rowIndex).getText());
	}

	public static void selectListWithIdItems(final String id, final String... texts) {
		bot.listWithId(id).select(texts);
	}

	public static void selectListWithIdItem(final String id, final String text) {
		selectListWithIdItems(id, text);
	}

	public static void selectListItems(final int listIndex, final String... texts) {
		bot.list(listIndex).select(texts);
	}

	public static void selectListItem(final int listIndex, final String text) {
		selectListItems(listIndex, text);
	}

	public static void doubleClickListItem(final int listIndex, final String text) {
		bot.list(listIndex).doubleClick(text);
	}

	/**
	 * Returns whether the text for a Label with the specified id
	 */
	public static String getTextForLabelWithId(final String id) {
		return bot.labelWithId(id).getText();
	}

	/**
	 * Returns whether the text for a {@link BorderedCLabel} with the specified id
	 */
	public static String getTextForBorderedClabelWithId(final String id) {
		@SuppressWarnings("unchecked")
		final BorderedCLabel label = bot.widget(allOf(widgetOfType(BorderedCLabel.class), withId(id)), 0);
		final String[] value = { "" };
		UIThreadRunnable.syncExec(() -> {
			value[0] = new SWTBotCLabel((CLabel) label.getChildren()[0]).getText();
		});

		return value[0];
	}

	/**
	 * Returns the text for the text field with the specified id
	 */
	public static String getTextForTextFieldWithId(final String id) {
		return bot.textWithId(id).getText();
	}

	/**
	 * Returns whether an item with the specified text is contained in the list with the specified ID.
	 */
	public static boolean doesItemExistsInListWithId(final String id, final String text) {
		return Arrays.asList(bot.listWithId(id).getItems()).contains(text);
	}

	/**
	 * Returns whether the text of the items in the list with a specified ID matches a specified value.
	 */
	public static boolean itemsMatchInListWithId(final String id, final String[] texts) {
		return Arrays.deepEquals(bot.listWithId(id).getItems(), texts);
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
		item.orElseThrow().select();
	}

	/**
	 * Doubleclicks an item at the specified texts in the first tree in the view with the specified title.
	 * Throws an exception if it is unable to do so.
	 */
	public static void doubleClickItemInTreeView(final String viewTitle, final String... itemTexts) {
		final Optional<SWTBotTreeItem> item = getItemInTree(getFirstTreeInView(viewTitle), itemTexts);
		assertTrue("Item with texts '" + String.join(",", itemTexts) + "' not found in tree", item.isPresent());
		item.orElseThrow().doubleClick();
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
	 * Expands the tree as it finds the items.
	 * @param itemTexts a path to the item containing the text of each item along the tree hierarchy.
	 * @returns an empty optional if the item is not found. Otherwise, it returns an optional containing the item.
	 */
	private static Optional<SWTBotTreeItem> getItemInTree(final SWTBotTree tree, final String... itemTexts) {
		Optional<SWTBotTreeItem> item = Arrays.stream(tree.getAllItems())
				.filter(tmpItem -> tmpItem.getText().equals(itemTexts[0]))
				.findAny();

		if (item.isPresent()) {
			for (int i = 1; i < itemTexts.length && item.isPresent(); i++) {
				final SWTBotTreeItem treeItem = item.get();
				if (!treeItem.isExpanded()) {
					treeItem.expand();
				}

				final String searchText = itemTexts[i];
				item = Arrays.stream(treeItem.getItems())
						.filter(tmpItem -> tmpItem.getText().equals(searchText))
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
		return isMatchingEditor(editor, editorClass, inputName);
	}

	private static boolean isMatchingEditor(final IEditorReference editor, final Class<?> editorClass,
			final String inputName) {
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

	private static IEditorReference getEditorReference(final Class<?> editorClass, final String inputName) {
		final WorkbenchContentsFinder finder = new WorkbenchContentsFinder();
		final Optional<IEditorReference> editor = finder.findEditors(new BaseMatcher<IEditorReference>() {

			@Override
			public boolean matches(final Object item) {
				if (!(item instanceof IEditorReference)) {
					return false;
				}

				final IEditorReference editor = (IEditorReference) item;
				return isMatchingEditor(editor, editorClass, inputName);
			}

			@Override
			public void describeTo(final Description description) {
			}
		}).stream().findAny();

		return editor.orElseThrow(() -> new RuntimeException("Cannot find editor '" + inputName + "'."));
	}

	/**
	 * Focus the specified editor
	 */
	public static void focusDiagramEditor(final DiagramReference diagram) {
		getDiagramEditorBot(diagram).setFocus();
	}

	/**
	 * Saves the specified editor
	 */
	public static void saveDiagramEditor(final DiagramReference diagram) {
		getDiagramEditorBot(diagram).save();
	}

	/**
	 * Saves and closes the specified diagram editor
	 */
	public static void saveAndCloseDiagramEditor(final DiagramReference diagram) {
		getDiagramEditorBot(diagram).saveAndClose();
	}

	/**
	 * Saves and closes the specified editor
	 */
	public static void saveAndCloseTextEditorByTitle(final String inputName) {
		final IEditorReference editor = getEditorReference(XtextEditor.class, inputName);
		new SWTBotEditor(editor, bot).saveAndClose();
	}

	/**
	 * Returns whether there is an open editor with the specified input name
	 */
	public static boolean isEditorOpen(final Class<?> editorClass, final String inputName) {
		return bot.editors(new BaseMatcher<IEditorReference>() {
			@Override
			public boolean matches(final Object value) {
				if (!(value instanceof IEditorReference)) {
					return false;
				}

				final IEditorReference editor = (IEditorReference) value;
				return isMatchingEditor(editor, editorClass, inputName);
			}

			@Override
			public void describeTo(final Description description) {
				description.appendText("is editor open. Editor Class: '" + editorClass.getCanonicalName()
						+ "'. Input: '" + inputName + "'");
			}
		}).size() > 0;
	}

	/**
	 * Returns a bot for the focused widget
	 */
	public static AbstractSWTBot<?> getFocusedWidget() {
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

	/**
	 * Selects an item from the command
	 * @param editor the editor
	 * @param itemText the text for the palette item
	 */
	public static void selectPaletteItem(final DiagramReference diagram, final String itemText) {
		final AgeEditor editor = getDiagramEditor(diagram);

		// Find the palette item
		final PaletteItem<?> paletteItem = UIThreadRunnable.syncExec(() -> {
			final Scene scene = editor.getFxCanvas().getScene();
			final Palette<?, ?> palette = (Palette<?, ?>) scene.lookup("#" + DiagramEditorNode.PALETTE_ID);
			for (final Node tmp : palette.lookupAll("." + PaletteItem.STYLE_CLASS)) {
				final PaletteItem<?> tmpItem = (PaletteItem<?>) tmp;
				final Button paletteItemButton = tmpItem.getButton();
				if (itemText.equals(paletteItemButton.getText())) {
					return tmpItem;
				}
			}
			return null;
		});

		// Assert that the item was found
		assertNotNull("Unable to find palette item with label '" + itemText + "'", paletteItem);

		//
		// Expand the palette group
		//
		// Find the palette group
		Node tmp;
		for (tmp = paletteItem.getParent(); tmp != null; tmp = tmp.getParent()) {
			if (tmp instanceof PaletteGroup) {
				break;
			}
		}

		final PaletteGroup<?, ?> paletteGroup = (PaletteGroup<?, ?>) tmp;

		// If there is a palette group, expand it if necessary
		if (paletteGroup != null && !paletteGroup.isExpanded()) {
			fxBot.click(paletteGroup);
			waitUntil(() -> paletteGroup.isExpanded(), "Palette group not expanded");
		}

		// Click the item to select it
		fxBot.click(paletteItem);

		// Wait for the item to be active
		final AgeEditorPaletteModel paletteModel = editor.getPaletteModel();
		waitUntil(() -> {
			return itemText.equalsIgnoreCase(paletteModel.getItemLabel(paletteModel.getActiveItem()));
		}, "Unable to activate palette item `" + itemText + "`");
	}

	private static SWTBotEditor getDiagramEditorBot(final DiagramReference diagram) {
		final IEditorReference editor = getEditorReference(AgeEditor.class, diagram.getInputName());
		return new SWTBotEditor(editor, bot);
	}

	/**
	 * Activates the selection tool for the editor for the specified diagram. Does not open or activate the editor.
	 * Precondition: editor for the diagram must be active.
	 */
	public static void activateSelectionTool(final DiagramReference diagram) {
		selectPaletteItem(diagram, "Select");
	}

	// Scrolls to and clicks a DiagramElement
	public static void clickDiagramElement(final DiagramReference diagram, DiagramElementReference element) {
		final AgeEditor editor = getDiagramEditor(diagram);

		final DiagramElement de = getDiagramElement(diagram, element)
				.orElseThrow(() -> new RuntimeException("Cannot find diagram element for '" + element + "'."));

		final Node sceneNode = editor.getSceneNode(de);
		assertNotNull("Unable to retrieve scene node", sceneNode);

		Display.getDefault().syncExec(() -> editor.scrollToTopLeft(sceneNode));

		fxBot.click(sceneNode);
	}

	private static SWTBotCanvas findViewCanvasByTitle(final String title) {
		final List<Canvas> canvas = bot.activeView().bot().getFinder().findControls(new BaseMatcher<Canvas>() {
			@Override
			public boolean matches(final Object item) {
				return item instanceof Canvas && ((Canvas) item).toString().equals(title);
			}

			@Override
			public void describeTo(final Description description) {
			}
		});

		assertTrue("Cannot find view canvas '" + title + "'", canvas.size() > 0);
		return new SWTBotCanvas(canvas.get(0));
	}

	/**
	 * Clicks the context menu option for the tree item in the outline view.
	 * @param treeItems is the name of the elements to traverse in the outline view
	 * @param menuItem is the menu item to select
	 */
	public static void clickContextMenuOfOutlineViewItem(final String[] treeItems, final String[] menuItem) {
		final SWTBotTree tree = bot.viewByTitle("Outline").bot().tree();
		SWTBotTreeItem treeItem = findTreeItem(tree.getAllItems(), treeItems[0]);
		final String[] nodes = Arrays.copyOfRange(treeItems, 1, treeItems.length);

		for (final String node : nodes) {
			treeItem = findTreeItem(treeItem.getItems(), node).expand();
		}

		treeItem.contextMenu().menu(menuItem).click();
	}

	/**
	 * Selects the tree item in the outline view.
	 * @param treeItems is the name of the elements to traverse in the outline view
	 */
	public static void clickElementInOutlineView(final String... treeItems) {
		final SWTBotTree tree = bot.viewByTitle("Outline").bot().tree();
		SWTBotTreeItem treeItem = findTreeItem(tree.getAllItems(), treeItems[0]);
		final String[] nodes = Arrays.copyOfRange(treeItems, 1, treeItems.length);

		for (final String node : nodes) {
			treeItem = findTreeItem(treeItem.getItems(), node).expand();
		}

		treeItem.click();
	}

	private static SWTBotTreeItem findTreeItem(final SWTBotTreeItem[] items, final String treeItem) {
		for (final SWTBotTreeItem item : items) {
			final String text = item.getText().substring(item.getText().lastIndexOf(" ") + 1);
			if (text.equalsIgnoreCase(treeItem)) {
				return item;
			}
		}

		throw new RuntimeException("Could not find tree item '" + treeItem + "' in the outline view.");
	}

	/**
	 * Sets the nth text for the window with specified title.
	 */
	public static void setTextForWindow(final String title, final int index, final String text) {
		bot.shell(title).bot().text(index).setText(text);
	}

	/**
	 * Sends an event to the listeners of specified text located on the window with specified title.
	 * @param title the title of the window
	 * @param index the index of the text
	 * @param eventType the type of event to notify listeners
	 * @param event the event to send to listeners
	 */
	public static void sendTextKeyUpEvent(final String title, final int index, final int eventType, final Event event) {
		Display.getDefault().syncExec(() -> {
			// Send notification
			bot.shell(title).bot().text(index).widget.notifyListeners(eventType, event);
		});
	}

	/**
	 * Clicks the button with specified text on the window with specified title.
	 */
	public static void clickButtonForWindow(final String title, final String text) {
		final SWTBotButton btn = bot.shell(title).bot().button(text);
		btn.click();
	}

	/**
	 * Returns the AgeDiagramEditor instance for the specified diagram. Does not open or activate the editor for the specified diagram.
	 */
	public static AgeEditor getDiagramEditor(final DiagramReference diagram) {
		final IEditorReference editorRef = getEditorReference(AgeEditor.class, diagram.getInputName());
		final AgeEditor editor = (AgeEditor) editorRef.getEditor(false);
		assertNotNull("Unable to get editor for '" + diagram + "'", editor);
		return editor;
	}

	/**
	 * Does not open or activate the editor the specified diagram.
	 */
	public static void selectDiagramElements(final DiagramReference diagram,
			final DiagramElementReference... elements) {
		final AgeEditor editor = getDiagramEditor(diagram);
		final Set<DiagramElement> diagramElementsToSelect = new HashSet<>();
		for (int i = 0; i < elements.length; i++) {
			final DiagramElementReference element = elements[i];
			final DiagramElement de = getDiagramElement(diagram, element)
					.orElseThrow(() -> new RuntimeException("Cannot find element for '" + element + "'."));
			diagramElementsToSelect.add(de);
		}

		Display.getDefault().syncExec(() -> {
			editor.getFxCanvas().forceFocus();
			editor.selectDiagramNodes(diagramElementsToSelect);
		});

		waitUntil(() -> diagramElementsToSelect.equals(editor.getSelectedDiagramElementSet()),
				"Elements '" + getDiagramElementReferences(elements) + "' are not selected");
	}

	private static String getDiagramElementReferences(final DiagramElementReference... elements) {
		final List<String> segments = new ArrayList<>();
		for (final DiagramElementReference element : elements) {
			segments.add(element.toString());
		}

		return String.join(", ", segments);
	}

	/**
	 * Renames the specified element executing direct edit on the diagram elements label.
	 */
	public static void renameElementDirectEdit(final DiagramReference diagram, final DiagramElementReference element,
			final String newName, final String expectedNewLabel) {
		selectDiagramElements(diagram, element);

		// Get the editor
		final AgeEditor editor = getDiagramEditor(diagram);

		final DiagramElement de = getDiagramElement(diagram, element)
				.orElseThrow(() -> new RuntimeException("Cannot find diagram element for '" + element + "'."));

		// Find the primary label
		final LabelNode primaryLabel = editor.getGefDiagram().getPrimaryLabelSceneNode(de);



		// Find the scene node for the primary label
		assertNotNull("Unable to find primary label", primaryLabel);

		// Reveal and click the primary label
		Display.getDefault().syncExec(() -> editor.reveal(primaryLabel));
		fxBot.firePressAndReleasePrimaryMouseButtonEvents(primaryLabel);
		waitUntil(
				() -> UIThreadRunnable
						.syncExec(() -> editor.getFxCanvas().getScene().getFocusOwner() instanceof TextField),
				"edit field does not have focus.");

		final Node eventTarget = UIThreadRunnable.syncExec(() -> editor.getFxCanvas().getScene().getFocusOwner());

		// Type to edit text
		fxBot.type(eventTarget, newName);

		// Press enter to finish
		fxBot.pressAndReleaseEnterKey(eventTarget);

		// Wait until the label changes to the expected value
		waitUntil(() -> UIThreadRunnable.syncExec(() -> Objects.equals(primaryLabel.getText(), expectedNewLabel)),
				"primary label does not have expected value after rename");
	}

	public static void renameElementDirectEdit(final DiagramReference diagram, final DiagramElementReference element,
			final String newName) {
		renameElementDirectEdit(diagram, element, newName, newName);
	}

	/**
	 * Returns an optional describing the diagram element contained in the editor for the specified diagram.
	 * Does not open or activate the editor for the specified diagram.
	 */
	public static Optional<DiagramElement> getDiagramElement(final DiagramReference diagram,
			final DiagramElementReference element) {
		final AgeEditor editor = getDiagramEditor(diagram);
		final AgeDiagram ageDiagram = editor.getDiagram();
		ImmutableList<RelativeBusinessObjectReference> refs = element.pathToElement;
		DiagramElement de = ageDiagram.getChildByRelativeReference(refs.get(0));
		for (int i = 1; i < refs.size() && de != null; i++) {
			de = de.getChildByRelativeReference(refs.get(i));
		}

		return Optional.ofNullable(de);
	}

	public static void assertDiagramEditorActive(final DiagramReference diagram) {
		assertTrue(isDiagramEditorActive(diagram));
	}

	/**
	 * Returns whether the OSATE Diagram Editor is active with its input set to the path indicated by the path segments.
	 * The diagram file extension should not be included in the path segments.
	 */
	public static boolean isDiagramEditorActive(final DiagramReference diagram) {
		return isEditorActive(AgeEditor.class, diagram.getInputName());
	}
}
