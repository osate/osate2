/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swtbot.eclipse.finder.finders.WorkbenchContentsFinder;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.AbstractSWTBot;
import org.eclipse.swtbot.swt.finder.widgets.AbstractSWTBotControl;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotCanvas;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotSpinner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTableItem;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

import com.google.common.collect.ImmutableList;

/**
 * Provides functions for controlling the user interface.
 * This class should not contain as little OSATE specific functionality as possible.
 * Rather it wraps SWTBot and GEF functionality into assertions and commands so that it can be used to build higher level assertions
 * and commands.
 * Public methods of this class should be a minimal wrapper around SWTBot and GEF and not return any SWTBot or GEF specific data structures.
 * Typically, only primitive values should be returned.
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
	 * Clicks the radio button at specified index.
	 */
	public static void clickCheckBox(final int index) {
		bot.checkBox(index).click();
	}

	/**
	 * Clicks the button which has the specified text.
	 */
	public static void clickButton(final String text) {
		final SWTBotButton btn = bot.button(text);
		btn.click();
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
	public static void assertActiveShellTitleContains(final String value) {
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

	public static void clickViewTab(final String title) {
		final SWTBotCanvas canvas = findViewCanvasByTitle(title);
		canvas.click();
	}

	public static void clickTableItem(final int tableIndex, final String tableItem) {
		bot.table().getTableItem(tableItem).click();
	}

	public static void clickTableItem(final int tableIndex, final int rowIndex) {
		bot.table().getTableItem(rowIndex).click();
	}

	public static int getNumberOfTableRows(final int tableIndex) {
		return bot.table().rowCount();
	}

	public static void assertNumberOfTableRows(final int tableIndex, final int expectedValue) {
		assertEquals("Unexpected number of table rows", expectedValue, getNumberOfTableRows(tableIndex));
	}

	public static void assertTableItemText(final int tableIndex, final int rowIndex,
			final String expectedValue) {
		assertEquals("Unexpected table item text", expectedValue, bot.table().getTableItem(rowIndex).getText());
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
	 * Doubleclicks an item at the specified texts in the first tree in the view with the specified title.
	 * Throws an exception if it is unable to do so.
	 */
	public static void doubleClickItemInTreeView(final String viewTitle, final String... itemTexts) {
		final Optional<SWTBotTreeItem> item = getItemInTree(getFirstTreeInView(viewTitle), itemTexts);
		assertTrue("Item with texts '" + String.join(",", itemTexts) + "' not found in tree", item.isPresent());
		item.get().doubleClick();
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
				.filter(tmpItem -> tmpItem.getText().equals(itemTexts[0])).findAny();
		if (item.isPresent()) {
			for (int i = 1; i < itemTexts.length && item.isPresent(); i++) {
				final SWTBotTreeItem treeItem = item.get();
				if (!treeItem.isExpanded()) {
					treeItem.expand();
				}

				final String searchText = itemTexts[i];
				item = Arrays.stream(treeItem.getItems()).filter(tmpItem -> tmpItem.getText().equals(searchText))
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
	 * Saves the specified editor
	 */
	public static void saveDiagramEditor(final DiagramReference diagram) {
		getDiagramEditorBot(diagram).save();
	}

	/**
	 * Saves and closes the specified editor
	 */
	public static void saveAndCloseDiagramEditor(final DiagramReference diagram) {
		getDiagramEditorBot(diagram).saveAndClose();
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

	/**
	 * Activates the palette item
	 * @param editor the editor
	 * @param itemText the text for the palette item
	 */
	public static void activatePaletteItem(final DiagramReference diagram, final String itemText) {
		getDiagramEditorBot(diagram).activateTool(itemText);
	}

	private static SWTBotGefEditor getDiagramEditorBot(final DiagramReference diagram) {
		final IEditorReference editor = getEditorReference(AgeDiagramEditor.class, diagram.getUri());
		return new SWTBotGefEditor(editor, bot);
	}

	/**
	 * Activates the selection tool for the editor for the specified diagram. Does not open or activate the editor.
	 * Precondition: editor for the diagram must be active.
	 */
	public static void activateSelectionTool(final DiagramReference diagram) {
		assertDiagramEditorActive(diagram);
		getDiagramEditorBot(diagram).activateDefaultTool();
	}

	// Scrolls to and clicks a DiagramElement
	public static void clickDiagramElement(final DiagramReference diagram, DiagramElementReference element) {
		final AgeDiagramEditor editor = getDiagramEditor(diagram);

		final DiagramElement de = getDiagramElement(diagram, element)
				.orElseThrow(() -> new RuntimeException("Cannot find relative reference for '" + element + "'."));

		// Get the edit part
		final PictogramElement pe = editor.getGraphitiAgeDiagram().getPictogramElement(de);
		final EditPart editPart = editor.getDiagramBehavior().getEditPartForPictogramElement(pe);

		// Scroll to the edit part
		final IEditorReference editorRef = getEditorReference(AgeDiagramEditor.class, diagram.getUri());

		final SWTBotGefEditor editorBot = getDiagramEditorBot(diagram);
		final List<SWTBotGefEditPart> botEditParts = findEditParts(editorBot, Collections.singletonList(editPart));

		scrollToEditPart(editorRef, editPart);

		// Click element
		editorBot.click(botEditParts.get(0));
	}

	private static void scrollToEditPart(final IEditorReference editorRef, final EditPart editPart) {
		final AgeDiagramEditor editor = (AgeDiagramEditor) editorRef.getEditor(false);
		assertNotNull("Editor is null", editor);

		Display.getDefault().syncExec(() -> {
			// Get the figure canvas for the editor
			final Control viewerControl = editor.getGraphicalViewer().getControl();
			assertTrue("Graphical viewer control is not a FigureCanvas instance",
					viewerControl instanceof FigureCanvas);
			final FigureCanvas viewerCanvas = (FigureCanvas) viewerControl;
			// Get the figure
			assertTrue("Edit part is not a GraphicalEditPart", editPart instanceof GraphicalEditPart);

			final IFigure figure = ((GraphicalEditPart) editPart).getFigure();
			assertNotNull("Figure is null", figure);

			// Get absolute bounds
			final Rectangle bounds = figure.getBounds().getCopy();

			// Scroll to the edit part
			viewerCanvas.scrollTo(bounds.x, bounds.y);
		});
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

	private static List<SWTBotGefEditPart> findEditParts(final SWTBotGefEditor editor,
			final List<EditPart> editPartsToFind) {
		final Matcher<EditPart> matcher = new BaseMatcher<EditPart>() {
			@Override
			public boolean matches(final Object editPart) {
				return editPartsToFind.contains(editPart);
			}

			@Override
			public void describeTo(final Description description) {
				description.appendText("Find edit parts");
			}
		};

		return editor.editParts(matcher);
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
	 * Sets the nth text for the shell with specified title.
	 */
	public static void setTextForShell(final String title, final int index, final String text) {
		bot.shell(title).bot().text(index).setText(text);
	}

	/**
	 * Sends an event to the listeners of specified text located on the shell with specified title.
	 * @param title the title of the shell
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
	 * Clicks the button with specified text on the shell with specified title.
	 */
	public static void clickButtonForShell(final String title, final String text) {
		final SWTBotButton btn = bot.shell(title).bot().button(text);
		btn.click();
	}

	/**
	 * Returns the AgeDiagramEditor instance for the specified diagram. Does not open or activate the editor for the specified diagram.
	 */
	public static AgeDiagramEditor getDiagramEditor(final DiagramReference diagram) {
		final IEditorReference editorRef = getEditorReference(AgeDiagramEditor.class, diagram.getUri());
		final AgeDiagramEditor editor = (AgeDiagramEditor) editorRef.getEditor(false);
		assertNotNull("Unable to get editor for '" + diagram + "'", editor);
		return editor;
	}

	/**
	 * Does not open or activate the editor the specified diagram.
	 */
	public static void selectDiagramElements(final DiagramReference diagram,
			final DiagramElementReference... elements) {
		final AgeDiagramEditor editor = getDiagramEditor(diagram);

		final List<EditPart> editPartsToSelect = new ArrayList<>();
		for (int i = 0; i < elements.length; i++) {
			final DiagramElementReference element = elements[i];
			final DiagramElement de = getDiagramElement(diagram, element)
					.orElseThrow(() -> new RuntimeException("Cannot find element for '" + element + "'."));

			final PictogramElement pe = editor.getGraphitiAgeDiagram().getPictogramElement(de);
			final EditPart editPart = editor.getDiagramBehavior().getEditPartForPictogramElement(pe);
			assertNotNull("Edit part is null", editPart);
			editPartsToSelect.add(editPart);
		}

		final SWTBotGefEditor editorBot = getDiagramEditorBot(diagram);
		final List<SWTBotGefEditPart> partBots = findEditParts(editorBot, editPartsToSelect);
		editorBot.select(partBots);

		// Assert elements are selected
		assertTrue("Elements '" + getDiagramElementReferences(elements) + "' were not selected",
				editorBot.selectedEditParts().containsAll(partBots));
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
	public static void renameElementDirectEdit(final DiagramReference diagram, final DiagramElementReference parent,
			final RelativeBusinessObjectReference newAfterCreate, final String newName) {
		final DiagramElementReference newAfterCreateElement = parent.join(newAfterCreate);
		final DiagramElement de = getDiagramElement(diagram, newAfterCreateElement).orElseThrow(
				() -> new RuntimeException("Cannot find relative reference for '" + newAfterCreateElement + "'."));

		// Get the edit part
		final AgeDiagramEditor editor = getDiagramEditor(diagram);
		final PictogramElement pe = editor.getGraphitiAgeDiagram().getPictogramElement(de);
		final EditPart editPart = editor.getDiagramBehavior().getEditPartForPictogramElement(pe);

		// Scroll to the edit part
		final IEditorReference editorRef = getEditorReference(AgeDiagramEditor.class, diagram.getUri());
		scrollToEditPart(editorRef, editPart);

		final SWTBotGefEditor editorBot = getDiagramEditorBot(diagram);

		final GraphicalEditPart p = (GraphicalEditPart) editPart;
		final Point centerOfLabel = getPoint(p.getFigure()).orElseThrow(
				() -> new RuntimeException("Cannot find label for diagram element ' " + de.getLabelName() + "."));

		editorBot.click(centerOfLabel.x, centerOfLabel.y);
		Display.getDefault().syncExec(() -> {
			final Control graphicalViewerControl = getDiagramEditor(diagram).getGraphicalViewer().getControl();
			final Event event = new Event();
			event.x = centerOfLabel.x;
			event.y = centerOfLabel.y;
			graphicalViewerControl.notifyListeners(SWT.MouseMove, event);

			final DirectEditRequest req = new DirectEditRequest();
			req.setLocation(centerOfLabel);
			editPart.performRequest(req);
		});

		editorBot.directEditType(newName);
	}

	private static Optional<Point> getPoint(final IFigure figure) {
		if (figure instanceof Label) {
			final Label label = (Label) figure;
			final Rectangle bounds = ((Label) figure).getBounds().getCopy();
			label.translateToAbsolute(bounds);
			return Optional.of(bounds.getCenter());
		}

		for (final Object child : figure.getChildren()) {
			final Optional<Point> point = getPoint((IFigure) child);
			if (point.isPresent()) {
				return point;
			}
		}

		return Optional.empty();
	}

	/**
	 * Returns an optional describing the diagram element contained in the editor for the specified diagram.
	 * Does not open or activate the editor for the specified diagram.
	 */
	public static Optional<DiagramElement> getDiagramElement(final DiagramReference diagram,
			final DiagramElementReference element) {
		final AgeDiagramEditor editor = getDiagramEditor(diagram);
		final AgeDiagram ageDiagram = editor.getAgeDiagram();
		ImmutableList<RelativeBusinessObjectReference> refs = element.pathToElement;
		DiagramElement de = ageDiagram.getByRelativeReference(refs.get(0));
		for (int i = 1; i < refs.size() && de != null; i++) {
			de = de.getByRelativeReference(refs.get(i));
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
		return isEditorActive(AgeDiagramEditor.class, diagram.getUri());
	}
}
