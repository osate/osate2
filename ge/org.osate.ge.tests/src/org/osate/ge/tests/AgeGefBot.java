package org.osate.ge.tests;

import static org.junit.Assert.assertNotNull;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.platform.GraphitiConnectionEditPart;
import org.eclipse.graphiti.ui.platform.GraphitiShapeEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefConnectionEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.results.Result;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.waits.ICondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotToolbarButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.hamcrest.BaseMatcher;
import org.hamcrest.CustomMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.impl.AbstractTypeImpl;
import org.osate.aadl2.impl.NamedElementImpl;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.graphiti.ShapeNames;
import org.osate.ge.internal.graphiti.diagram.PropertyUtil;
import org.osate.ge.internal.ui.dialogs.ClassifierOperationDialog;
import org.osate.ge.internal.ui.dialogs.CreateDiagramComposite;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

public class AgeGefBot {
	public static class AgeSWTBotGefEditor extends SWTBotGefEditor {
		private final AgeGefBot ageBot;
		private final Set<SWTBotGefConnectionEditPart> connectionEditParts = new HashSet<>();

		public AgeSWTBotGefEditor(final IEditorReference reference, final AgeGefBot ageBot,
				final SWTWorkbenchBot bot)
				throws WidgetNotFoundException {
			super(reference, bot);
			this.ageBot = Objects.requireNonNull(ageBot, "ageBot must not be null");
		}

		// Find all connections of editor
		public List<SWTBotGefConnectionEditPart> allConnections() {
			connectionEditParts.clear();
			findConnectionEditParts(this.rootEditPart());
			return connectionEditParts.stream().collect(Collectors.toList());
		}

		// Find connections of an edit part
		private List<SWTBotGefConnectionEditPart> childConnections(final SWTBotGefEditPart editPart) {
			connectionEditParts.clear();
			findConnectionEditParts(editPart);
			return connectionEditParts.stream().collect(Collectors.toList());
		}

		private void findConnectionEditParts(final SWTBotGefEditPart swtBotGefEditPart) {
			for (final SWTBotGefEditPart editPart : swtBotGefEditPart.children()) {
				findConnectionEditParts(editPart);
			}

			addConnectionEditPart.accept(swtBotGefEditPart);
		}

		public List<SWTBotGefConnectionEditPart> editPartConnections(final Matcher<? extends EditPart> matcher)
				throws WidgetNotFoundException {
			final List<SWTBotGefConnectionEditPart> matches = new ArrayList<>();
			for (final SWTBotGefConnectionEditPart c : allConnections()) {
				if (matcher.matches(c.part())) {
					matches.add(c);
				}
			}

			return matches;
		}

		private final Consumer<SWTBotGefEditPart> addConnectionEditPart = swtBotGefEditPart -> {
			if (swtBotGefEditPart.part() instanceof AbstractGraphicalEditPart) {
				final AbstractGraphicalEditPart agep = (AbstractGraphicalEditPart) swtBotGefEditPart.part();
				for (final Object ob : agep.getTargetConnections()) {
					if (ob instanceof GraphitiConnectionEditPart) {
						connectionEditParts.add(createEditPart((GraphitiConnectionEditPart) ob));
					}
				}

				for (final Object ob : agep.getSourceConnections()) {
					if (ob instanceof GraphitiConnectionEditPart) {
						connectionEditParts.add(createEditPart((GraphitiConnectionEditPart) ob));
					}
				}
			}
		};

		// Sets focus to the current editor and searches for a specified diagram element.
		public AgeDiagramElementBot element(final String... editPartPath) {
			setFocus();
			final SWTBotGefEditPart swtBotGefEditPart = ageBot.findEditPart(this, editPartPath);
			return new AgeDiagramElementBot(this, swtBotGefEditPart);
		}

		private AgeGefBot getAgeBot() {
			return ageBot;
		}
	}

	public static class AgeDiagramElementBot {
		private final AgeSWTBotGefEditor editorBot;
		private final SWTBotGefEditPart gefEditPartBot;

		private AgeDiagramElementBot(final AgeSWTBotGefEditor editorBot, final SWTBotGefEditPart gefEditPartBot) {
			this.editorBot = Objects.requireNonNull(editorBot, "editorBot must not be null");
			this.gefEditPartBot = Objects.requireNonNull(gefEditPartBot, "gefEditPartBot must not be null");
		}

		public void select() {
			editorBot.click(gefEditPartBot);
			editorBot.select(gefEditPartBot);
		}

		public void createChild(final String paletteEntryName, final String name, final Point position) {
			select();
			editorBot.getAgeBot().createToolItemAndRename(editorBot, paletteEntryName, position, name, gefEditPartBot);
		}

		public void resize(final int width, final int height) {
			select();
			gefEditPartBot.resize(PositionConstants.SOUTH_WEST, width, height);
		}

		public DiagramElement getDiagramElement() {
			final DiagramElement de = UIThreadRunnable.syncExec((Result<DiagramElement>) () -> {
				final PictogramElement pe = (PictogramElement)gefEditPartBot.part().getModel();
				final AgeDiagramEditor editor = (AgeDiagramEditor)editorBot.getReference().getEditor(true);
				return editor.getGraphitiAgeDiagram().getDiagramElement(pe);
			});

			assertNotNull("Unable to retrieve diagram element", de);
			return de;
		}

		public AgeSWTBotGefEditor openNewDiagram(final String name, final String diagramTypeLabel) {
			select();
			editorBot.clickContextMenu("New Diagram...");

			final SWTBot createDiagramBot = editorBot.bot().shell("Create Diagram").activate().bot();

			createDiagramBot.textWithId(CreateDiagramComposite.WIDGET_ID_NAME).setText(name);
			createDiagramBot.comboBoxWithId(CreateDiagramComposite.WIDGET_ID_TYPE).setSelection(diagramTypeLabel);

			createDiagramBot.button("OK").click();

			return editorBot.getAgeBot().getEditor(name);
		}
	}

	private static class AgeSWTGefBot extends SWTGefBot {
		private final AgeGefBot ageBot;
		private final Robot robot;

		public AgeSWTGefBot(final AgeGefBot ageBot) {
			this.ageBot = Objects.requireNonNull(ageBot, "ageBot must not be null");
			robot = Objects.requireNonNull(getRobot(), "Robot cannot be null.");
			robot.setAutoDelay(700);
		}

		private Robot getRobot() {
			try {
				return new Robot();
			} catch (final AWTException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected SWTBotGefEditor createEditor(final IEditorReference reference, final SWTWorkbenchBot bot) {
			return new AgeSWTBotGefEditor(reference, ageBot, bot);
		}

		@Override
		public AgeSWTBotGefEditor gefEditor(String fileName) throws WidgetNotFoundException {
			return (AgeSWTBotGefEditor) super.gefEditor(fileName);
		}

		private void mouseLeftClick(final int x, final int y) {
			mouseMove(x, y);
			mouseLeftClickPress();
			mouseLeftClickRelease();
		}

		private void mouseLeftClickPress() {
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		}

		private void mouseLeftClickRelease() {
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		}

		private void mouseMove(int x, int y) {
			robot.mouseMove(x, y);
		}

		private void setAutoDelay(int delay) {
			robot.setAutoDelay(delay);
		}

		private void keyPress(final int key) {
			robot.keyPress(key);
		}

		private void keyRelease(final int key) {
			robot.keyRelease(key);
		}
	}

	private final AgeSWTGefBot bot = new AgeSWTGefBot(this);
	// Context menu options
	final public static String associatedDiagram = "Associated Diagram";
	final public static String all = "All";

	public void createNewProject(final String projectName) {
		ensureReadyToTest();

		// Create project
		bot.menu("Other...", true).click();
		bot.tree().getTreeItem("AADL").expand().getNode("AADL Project").click();
		bot.button("Next >").click();
		bot.text().setText(projectName);
		bot.button("Finish").click();

		if (!bot.activePerspective().getLabel().equals("AADL")) {
			// Open AADL Perspective Dialog
			bot.button("Open Perspective").click();
		}
	}

	// Creates and new project and package. Closes the diagram and opens the text editor.
	public void createNewProjectAndPackage(final String projectName, final String packageName) {
		ensureReadyToTest();
		createNewProject(projectName);

		// Create AADL Package and close the diagram
		createAADLPackage(projectName, packageName).close();

		bot.tree().expandNode(new String[] { projectName }).getNode(packageName + ".aadl").click();
		bot.tree().contextMenu("Open").click();
	}

	// Closes the welcome page if it is open and configures SWTBot
	private void ensureReadyToTest() {
		SWTBotPreferences.TIMEOUT = 5000;
		closeWelcomePage();
	}

	// Close welcome page if necessary
	public void closeWelcomePage() {
		for (final SWTBotView view : bot.views()) {
			if (view.getTitle().equals("Welcome")) {
				view.close();
			}
		}
	}

	// Create a new package and diagram and opens the graphical editor.
	public AgeSWTBotGefEditor createAADLPackage(final String projectName, final String packageName) {
		bot.tree().select(projectName).contextMenu("AADL Package").click();
		bot.text().setText(packageName);
		clickRadio("Diagram Editor");
		clickButton("Finish");
		clickButton("OK");
		return bot.gefEditor(packageName + ".aadl_diagram");
	}

	public void clickButton(final String text) {
		bot.button(text).click();
	}

	public void clickCheckBox(final String text) {
		bot.checkBox(text).click();
	}

	public void clickRadio(final String text) {
		bot.radio(text).click();
	}

	public void clickTableOption(final String text) {
		bot.table().getTableItem(text).click();
	}


	// Create an implementation when a type already exists
	public void createImplementation(final AgeSWTBotGefEditor editor, final String toolType, final String typeName,
			final String elementName, final Point point, final String... parentName) {
		editor.setFocus();
		createToolItem(editor, toolType, point, parentName);
		waitUntilShellIsActive("Create Component Implementation");
		bot.shell("Create Component Implementation").setFocus();
		setText(elementName);
		clickRadio("Existing");
		clickButton("...");
		clickButton("OK");
		clickButton("OK");

		waitUntilElementExists(editor, typeName + "." + elementName);
	}

	public void waitUntil(final ICondition condition, final long timeout) {
		bot.waitUntil(condition, timeout);
	}

	public void deleteProject(final String projectName) {
		bot.tree().select(projectName).contextMenu("Delete").click();
		bot.checkBox("Delete project contents on disk (cannot be undone)").click();
		final SWTBotShell shell = bot.activeShell();
		bot.button("OK").click();
		bot.waitUntil(Conditions.shellCloses(shell));
	}

	public void openDiagram(final String projectName, final String fileName) {
		openDiagram(new String[] { projectName }, fileName);
	}

	public void openDiagram(final String[] nodePath, final String fileName) {
		bot.tree().expandNode(nodePath).getNode(fileName + ".aadl").click();
		bot.tree().contextMenu("Open Diagram").click();
	}

	public void waitUntilShellIsActive(final String shellTitle) {
		bot.waitUntil(org.eclipse.swtbot.swt.finder.waits.Conditions.shellIsActive(shellTitle));
	}

	public SWTBotShell getActiveShell() {
		return bot.activeShell();
	}

	public void waitUntilShellCloses(final SWTBotShell shell) {
		bot.waitUntil(org.eclipse.swtbot.swt.finder.waits.Conditions.shellCloses(shell));
	}

	public void createToolItem(final AgeSWTBotGefEditor editor, final String toolItem, final Point creationCoor,
			final String... editPartPath) {
		final SWTBotGefEditPart parent = findEditPart(editor, editPartPath);
		createToolItem(editor, toolItem, creationCoor, parent);
	}

	public void createToolItem(final AgeSWTBotGefEditor editor, final String toolItem, final Point creationCoor,
			final SWTBotGefEditPart parent) {
		editor.setFocus();
		mouseSelectElement(editor, parent);
		editor.activateTool(toolItem);
		final Rectangle rect = ((GraphitiShapeEditPart) parent.part()).getFigure().getBounds();
		// Scrollbar selections: Point(Vertical, Horizontal)
		final java.awt.Point scrollbarValues = scrollToPosition(editor, creationCoor);
		editor.click(rect.x + creationCoor.x - scrollbarValues.x, rect.y + creationCoor.y - scrollbarValues.y);
		editor.activateDefaultTool();
	}

	/**
	 * Adjust scroll bars to show new element creation location in editor view port
	 * @param editor gef editor
	 * @param creationCoor new element location
	 * @return current vertical and horizontal scroll bar values
	 */
	private java.awt.Point scrollToPosition(final SWTBotGefEditor editor, final Point creationCoor) {
		final java.awt.Point scrollbarValues = new java.awt.Point();
		editor.setFocus();
		final Display display = editor.getWidget().getDisplay();
		display.syncExec(() -> {
			final FigureCanvas canvas = (FigureCanvas) display.getFocusControl();
			final ScrollBar horizontalScrollBar = canvas.getHorizontalBar();
			if (horizontalScrollBar.getVisible()) {
				clickScrollBar(display, canvas, horizontalScrollBar, creationCoor.x);
			}

			final ScrollBar verticalScrollBar = canvas.getVerticalBar();
			if (verticalScrollBar.getVisible()) {
				clickScrollBar(display, canvas, verticalScrollBar, creationCoor.y);
			}

			scrollbarValues.x = horizontalScrollBar.getSelection();
			scrollbarValues.y = verticalScrollBar.getSelection();
		});

		return scrollbarValues;
	}

	private void clickScrollBar(final Display display, final FigureCanvas canvas, final ScrollBar scrollBar,
			final int axisValue) {
		// Set new scrollbar value
		scrollBar.setSelection(axisValue);

		// Get scrollbar screen position
		final org.eclipse.swt.graphics.Rectangle scrollBarBounds = scrollBar.getThumbBounds();
		final Point scrollBarPosition = display.map(canvas, null, scrollBarBounds.x, scrollBarBounds.y);

		// Click scroll bar for refresh of viewport
		bot.setAutoDelay(700);
		bot.mouseLeftClick(scrollBarPosition.x, scrollBarPosition.y);
	}

	public void createToolItemAndRename(final AgeSWTBotGefEditor editor, final Class<?> clazz, final Point p,
			final String newName, final String... editPathPath) {
		createToolItemAndRename(editor, ToolTypes.getToolItem(clazz), p, newName, editPathPath);
	}

	public void createToolItemAndRename(final AgeSWTBotGefEditor editor, String paletteEntryName, final Point p,
			final String newName, final String... editElementPath) {
		final SWTBotGefEditPart editPart = editor
				.editParts(new FindEditPart(getAgeFeatureProvider(editor), editElementPath)).get(0);
		createToolItemAndRename(editor, paletteEntryName, p, newName, editPart);
	}

	public void createToolItemAndRename(final AgeSWTBotGefEditor editor, String paletteEntryName, final Point p,
			final String newName, SWTBotGefEditPart editPart) {
		editor.select(editPart);
		editor.click(editPart);
		createToolItem(editor, paletteEntryName, p, editPart);
		final SWTBotGefEditPart newEditPart = getNewElement(editor, paletteEntryName);

		renameElement(editor, newEditPart, newName);
	}

	// Find new element
	public SWTBotGefEditPart getNewElement(final AgeSWTBotGefEditor editor, final Class<?> clazz) {
		return getNewElement(editor, clazz.getName());
	}

	public SWTBotGefEditPart getNewElement(final AgeSWTBotGefEditor editor, final String description) {
		final NewElementCondition newElementCondition = new NewElementCondition(editor, new NewElementMatcher(editor),
				description);
		waitUntil(newElementCondition, 5000);
		return newElementCondition.getNewElementEditPart();
	}

	// Find new connection
	public SWTBotGefConnectionEditPart getNewConnection(final AgeSWTBotGefEditor editor, final Class<?> clazz) {
		final NewConnectionCondition newConnectionCondition = new NewConnectionCondition(editor,
				new NewElementMatcher(editor), clazz);
		waitUntil(newConnectionCondition, 5000);
		return newConnectionCondition.getNewConnectionEditPart();
	}

	private class NewElementCondition extends DefaultCondition {
		private final String description;
		private final AgeSWTBotGefEditor editor;
		private final Matcher<EditPart> editPartMatcher;
		private List<SWTBotGefEditPart> editParts;

		private NewElementCondition(final AgeSWTBotGefEditor editor, final Matcher<EditPart> matcher,
				final String description) {
			this.editor = editor;
			this.editPartMatcher = matcher;
			this.description = description;
		}

		@Override
		public String getFailureMessage() {
			return description + " was not created.";
		};

		@Override
		public boolean test() throws Exception {
			editParts = editor.editParts(editPartMatcher);
			return !editParts.isEmpty();
		};

		private SWTBotGefEditPart getNewElementEditPart() {
			return editParts.get(0);
		}
	}

	private class NewConnectionCondition extends DefaultCondition {
		private final Class<?> clazz;
		private final AgeSWTBotGefEditor editor;
		private final Matcher<EditPart> editPartMatcher;
		private List<SWTBotGefConnectionEditPart> editParts;

		private NewConnectionCondition(final AgeSWTBotGefEditor editor, final Matcher<EditPart> matcher,
				final Class<?> clazz) {
			this.editor = editor;
			this.editPartMatcher = matcher;
			this.clazz = clazz;
		}

		@Override
		public String getFailureMessage() {
			return clazz + " was not created.";
		};

		@Override
		public boolean test() throws Exception {
			editParts = editor.editPartConnections(editPartMatcher);
			return !editParts.isEmpty();
		};

		private SWTBotGefConnectionEditPart getNewConnectionEditPart() {
			return editParts.get(0);
		}
	}

	public List<SWTBotGefConnectionEditPart> getNewConnectionEditPart(final AgeSWTBotGefEditor editor,
			final Class<?> clazz, final String... editPartPath) {
		editor.setFocus();
		final AgeFeatureProvider ageFeatureProvider = getAgeFeatureProvider(editor);
		final SWTBotGefEditPart parent = findEditPart(editor, editPartPath);
		return editor.childConnections(parent).stream().filter(editPart -> {
			final GraphitiConnectionEditPart gcep = (GraphitiConnectionEditPart) editPart.part();
			final Object bo = ageFeatureProvider.getBusinessObjectForPictogramElement(gcep.getPictogramElement());
			if (bo.getClass() == clazz) {
				return ((NamedElement) bo).getName().contains("new_");
			}

			return false;
		}).collect(Collectors.toList());
	}

	public List<SWTBotGefConnectionEditPart> getConnectionEditParts(final AgeSWTBotGefEditor editor,
			final String connectionName, final String... editPartPath) {
		final AgeFeatureProvider ageFeatureProvider = getAgeFeatureProvider(editor);
		final SWTBotGefEditPart parent = findEditPart(editor, editPartPath);

		return editor.childConnections(parent).stream().filter(editPart -> {
			final GraphitiConnectionEditPart gcep = (GraphitiConnectionEditPart) editPart.part();
			final Object bo = ageFeatureProvider.getBusinessObjectForPictogramElement(gcep.getPictogramElement());
			if (bo instanceof NamedElement) {
				return ((NamedElement) bo).getName().equalsIgnoreCase(connectionName);
			}

			return false;
		}).collect(Collectors.toList());
	}

	public SWTBotGefConnectionEditPart getNewConnectionEditPart(final AgeSWTBotGefEditor editor,
			final String... editPartPath) {
		final AgeFeatureProvider ageFeatureProvider = getAgeFeatureProvider(editor);
		final SWTBotGefEditPart parent = findEditPart(editor, editPartPath);

		return editor.childConnections(parent).stream().filter(editPart -> {
			final GraphitiConnectionEditPart gcep = (GraphitiConnectionEditPart) editPart.part();
			final Object bo = ageFeatureProvider.getBusinessObjectForPictogramElement(gcep.getPictogramElement());
			if (bo instanceof NamedElement) {
				return ((NamedElement) bo).getName().contains("new_");
			}

			return false;
		}).collect(Collectors.toList()).get(0);
	}

	public void waitUntilElementExists(final SWTBotGefEditor editor, final String elementName) {
		final AgeFeatureProvider ageFeatureProvider = getAgeFeatureProvider(editor);
		waitUntil(new DefaultCondition() {
			@Override
			public String getFailureMessage() {
				return "Element not renamed: " + elementName;
			};

			@Override
			public boolean test() throws Exception {
				return !editor.editParts(new FindEditPart(ageFeatureProvider, elementName)).isEmpty();
			};
		}, 5000);
	}

	public SWTBotTree getTree() {
		return bot.tree();
	}

	public AgeSWTBotGefEditor getEditor(final String editor) {
		return bot.gefEditor(editor + ".aadl_diagram");
	}

	public SWTBotEditor getActiveEditor() {
		return bot.activeEditor();
	}

	public void sleep(final int secs) {
		bot.sleep(secs * 1000);
	}

	public boolean isActiveEditor(final String title) {
		return bot.activeEditor().getTitle().equalsIgnoreCase(title + ".aadl_diagram");
	}

	public static class NewElementMatcher extends CustomMatcher<EditPart> {
		final private CharSequence charSeq = "new_";
		final private AgeFeatureProvider ageFeatureProvider;

		public NewElementMatcher(final SWTBotGefEditor editor) {
			super("New Element Matcher");
			this.ageFeatureProvider = getAgeFeatureProvider(editor);
		}

		@Override
		public boolean matches(final Object item) {
			if (item instanceof GraphitiShapeEditPart) {
				final GraphitiShapeEditPart gsep = (GraphitiShapeEditPart) item;
				final Object element = ageFeatureProvider
						.getBusinessObjectForPictogramElement(gsep.getPictogramElement());
				if (element instanceof NamedElement && gsep.isActive()) {
					final NamedElement namedElement = (NamedElement) element;
					return namedElement.getName().contains(charSeq);
				}
			} else if (item instanceof GraphitiConnectionEditPart) {
				final GraphitiConnectionEditPart gcep = (GraphitiConnectionEditPart) item;
				final Object element = ageFeatureProvider
						.getBusinessObjectForPictogramElement(gcep.getPictogramElement());
				if (element instanceof NamedElement && gcep.isActive()) {
					final NamedElement namedElement = (NamedElement) element;
					return namedElement.getName().contains(charSeq);
				}
			}

			return false;
		}
	}

	public void openAssociatedDiagramFromContextMenu(final SWTBotGefEditor editor, final String elementName) {
		final List<SWTBotGefEditPart> editPart = editor
				.editParts(new FindEditPart(getAgeFeatureProvider(editor), elementName));
		editor.click(editPart.get(0));
		sleep(2);
		editor.clickContextMenu("Associated Diagram");
		clickButton("Yes");
		clickButton("OK");
	}

	public void openTypeDiagramFromContextMenu(final SWTBotGefEditor editor, final String elementName) {
		final List<SWTBotGefEditPart> editPart = editor
				.editParts(new FindEditPart(getAgeFeatureProvider(editor), elementName));
		editor.select(editPart.get(0)).clickContextMenu("Type Diagram");
		clickButton("Yes");
		clickButton("OK");
	}

	public void executeContextMenuCommand(final SWTBotGefEditor editor, final String elementName,
			final String contextMenuCmd) {
		// Set focus for properties filters
		final AgeFeatureProvider ageFeatureProvider = (AgeFeatureProvider) ((GraphitiShapeEditPart) editor
				.mainEditPart().part()).getFeatureProvider();
		final List<SWTBotGefEditPart> list = editor.editParts(new FindEditPart(ageFeatureProvider, elementName));
		editor.setFocus();
		editor.select(list.get(0)).clickContextMenu(contextMenuCmd);
	}

	public void setText(final String text) {
		bot.text().setText(text);
	}

	public void setTextWithId(final String id, final String text) {
		bot.textWithId(id).setText(text);
	}

	public void maximize() {
		bot.getDisplay().syncExec(() -> bot.getDisplay().getActiveShell().setMaximized(true));
	}

	public SWTBotView getActiveView() {
		return bot.activeView();
	}

	public Widget getWidget(final String name) {
		return bot.widget(new WidgetMatcher(name));
	}

	// Select widget by sending SWT.MouseUp event
	public void selectWidget(final String widgetName) {
		final Widget widget = getWidget(widgetName);
		final Display display = PlatformUI.getWorkbench().getDisplay();
		// Notify widget of selection
		display.syncExec(() -> {
			widget.notifyListeners(SWT.MouseUp, createEvent(widget, display));
		});
	}

	private Event createEvent(final Widget widget, final Display display) {
		Event event = new Event();
		event.time = (int) System.currentTimeMillis();
		event.widget = widget;
		event.display = display;
		return event;
	}

	// Matching available widgets to widget wanted
	public class WidgetMatcher extends CustomMatcher<Widget> {
		final String widgetId;

		public WidgetMatcher(final String widgetId) {
			super("Finding: widgetId");
			this.widgetId = widgetId;
		}

		@Override
		public boolean matches(final Object item) {
			final Widget widget = (Widget) item;
			if (!widget.isDisposed()) {
				return widget.toString().equalsIgnoreCase(widgetId);
			}

			return false;
		};
	}


	public void setElementOptionRadioInPropertiesView(final SWTBotGefEditor editor, final String tabTitle,
			final String option, final String... elementPath) {
		editor.setFocus();
		final SWTBotGefEditPart editPart = findEditPart(editor, elementPath);
		editor.click(editPart);
		editor.select(editPart);
		selectWidget(tabTitle);
		editor.setFocus();
		editor.click(editPart);
		editor.select(editPart);

		clickRadio(option);
	}

	public void setElementOptionComboInPropertiesView(final AgeSWTBotGefEditor editor, final String tabTitle,
			final String comboId, final String selection, final String... elementPath) {
		editor.setFocus();
		final SWTBotGefEditPart editPart = findEditPart(editor, elementPath);
		editor.click(editPart);
		editor.select(editPart);
		selectWidget(tabTitle);
		editor.setFocus();
		editor.click(editPart);
		editor.select(editPart);

		bot.viewByTitle("Properties").setFocus();
		clickCombo(comboId, selection);
	}

	public void setElementOptionButtonInPropertiesView(final AgeSWTBotGefEditor editor, final String tabTitle,
			final String option, final String[]... elementPath) {
		editor.setFocus();
		clickElements(editor, elementPath);
		selectElements(editor, elementPath);
		selectWidget(tabTitle);
		editor.setFocus();
		clickElements(editor, elementPath);
		selectElements(editor, elementPath);
		clickButton(option);
	}

	public void openPropertiesView() {
		bot.viewByTitle("Properties").setFocus();
	}

	public static AgeFeatureProvider getAgeFeatureProvider(final SWTBotGefEditor editor) {
		return (AgeFeatureProvider) ((GraphitiShapeEditPart) editor.mainEditPart().part()).getFeatureProvider();
	}

	public static class FindEditPart extends BaseMatcher<EditPart> {
		private final List<String> editPartName;
		final AgeFeatureProvider ageFeatureProvider;

		public FindEditPart(final AgeFeatureProvider ageFeatureProvider, final String... editPartName) {
			this.editPartName = Arrays.asList(editPartName);
			this.ageFeatureProvider = ageFeatureProvider;
		}

		@Override
		public void describeTo(final Description description) {
			}

		@Override
		public boolean matches(final Object item) {
			if (item instanceof GraphitiShapeEditPart) {
				final GraphitiShapeEditPart gsep = (GraphitiShapeEditPart) item;
					final Object element = ageFeatureProvider
						.getBusinessObjectForPictogramElement(gsep.getPictogramElement());
				if (element instanceof NamedElement) {
						final NamedElementImpl namedElement = (NamedElementImpl) element;
						return editPartName.contains(namedElement.getName());
					}
			} else if (item instanceof AbstractGraphicalEditPart) {
				final AbstractGraphicalEditPart agep = (AbstractGraphicalEditPart) item;
				for (final Object ob : agep.getTargetConnections()) {
					if (ob instanceof GraphitiConnectionEditPart) {
						final GraphitiConnectionEditPart gcep = (GraphitiConnectionEditPart) ob;
						final Object element = ageFeatureProvider
								.getBusinessObjectForPictogramElement(gcep.getPictogramElement());
						if (element instanceof NamedElement) {
							final NamedElementImpl namedElement = (NamedElementImpl) element;
							return editPartName.contains(namedElement.getName());
						}
					}
				}

				for (final Object ob : agep.getSourceConnections()) {
					if (ob instanceof GraphitiConnectionEditPart) {
						final GraphitiConnectionEditPart gcep = (GraphitiConnectionEditPart) ob;
						final Object element = ageFeatureProvider
								.getBusinessObjectForPictogramElement(gcep.getPictogramElement());
						if (element instanceof NamedElement) {
							final NamedElementImpl namedElement = (NamedElementImpl) element;
							return editPartName.contains(namedElement.getName());
						}
					}
				}

			}

			return false;
		}
	}

	public void showEditor(final String editorName) {
		bot.waitUntil(new DefaultCondition() {
			@Override
			public String getFailureMessage() {
				return "editor not active";
			};

			@Override
			public boolean test() throws Exception {
				final SWTBotGefEditor editor = getEditor(editorName);
				editor.show();
				return getActiveEditor().getTitle().equalsIgnoreCase(editor.getTitle());
			};
		}, 10000);
	}

	public void resizeEditPart(final AgeSWTBotGefEditor editor, final Point newSize, final String... editPartPath) {
		editor.element(editPartPath).resize(newSize.x, newSize.y);
	}

	public SWTBotGefEditPart getEditPart(final SWTBotGefEditor editor, final String elementName) {
		return editor.editParts(new FindEditPart(getAgeFeatureProvider(editor), elementName)).get(0);
	}

	public List<SWTBotGefEditPart> findChild(final SWTBotGefEditor editor, final SWTBotGefEditPart parent,
			final String childName) {
		return parent.descendants(new FindEditPart(getAgeFeatureProvider(editor), childName));
	}

	public static Object getBusinessObject(final SWTBotGefEditor editor, final PictogramElement pe) {
		return getAgeFeatureProvider(editor).getBusinessObjectForPictogramElement(pe);
	}

	// Drill down edit parts to find desired edit part
	public SWTBotGefEditPart findEditPart(final SWTBotGefEditor editor, final String... editPartPath) {
		final AgeFeatureProvider ageFeatureProvider = getAgeFeatureProvider(editor);
		final Iterator<String> it = Arrays.asList(editPartPath).iterator();
		SWTBotGefEditPart editPartFound = editor.editParts(new FindEditPart(ageFeatureProvider, it.next())).get(0);
		while (it.hasNext()) {
			editPartFound = editPartFound.descendants(new FindEditPart(ageFeatureProvider, it.next())).get(0);
		}

		return editPartFound;
	}

	/**
	 * Use robot mouse to click a connection
	 * @param editor
	 * @param connection
	 */
	public void clickConnection(final SWTBotGefEditor editor, final Connection connection) {
		editor.setFocus();
		final org.eclipse.draw2d.geometry.Point midPoint = connection.getPoints().getMidpoint();
		final java.awt.Point renameLocation = new java.awt.Point();
		final Display display = editor.getWidget().getDisplay();
		display.syncExec(() -> {
			final FigureCanvas canvas = (FigureCanvas) display.getFocusControl();
			final Point point = PlatformUI.getWorkbench().getDisplay().map(canvas, null, midPoint.x, midPoint.y);
			renameLocation.x = point.x - canvas.getHorizontalBar().getSelection();
			renameLocation.y = point.y - canvas.getVerticalBar().getSelection();
		});

		// Click connection
		bot.setAutoDelay(700);
		bot.mouseLeftClick(renameLocation.x, renameLocation.y);
	}

	public void clickButtonWithId(final String id) {
		bot.buttonWithId(id).click();
	}

	public void clickButtonIndexWithId(final String id, int i) {
		bot.buttonWithId(id, i).click();
	}

	public void clickCombo(final String id, final String selection) {
		bot.viewByTitle("Properties").setFocus();
		bot.comboBoxWithId(id).setSelection(selection);
	}

	public void clickCheckBoxWithId(final String id) {
		bot.checkBoxWithId(id).click();
	}

	public void renameElement(final SWTBotGefEditor editor, final SWTBotGefEditPart newEditPart, final String newName) {
		bot.setAutoDelay(700);
		mouseSelectElement(editor, newEditPart);
		editor.select(newEditPart);
		editor.click(newEditPart);
		final java.awt.Point renameLocation = new java.awt.Point();
		setRenameLocation(editor, newEditPart, renameLocation);
		bot.mouseLeftClick(renameLocation.x, renameLocation.y);
		bot.mouseLeftClick(renameLocation.x, renameLocation.y);
		editor.directEditType(newName);
		waitUntilElementExists(editor, newName);
	}

	/**
	 * Find location of an edit part's name label.  Mouse has to be hovering over label for rename.
	 * @param editor
	 * @param newEditPart
	 * @param renameLocation
	 */
	private void setRenameLocation(final SWTBotGefEditor editor, final SWTBotGefEditPart newEditPart,
			final java.awt.Point renameLocation) {
		final GraphitiShapeEditPart gsep = (GraphitiShapeEditPart) newEditPart.part();
		final ContainerShape cs = (ContainerShape) gsep.getPictogramElement();
		final GraphicsAlgorithm labelGA = getLabelShape(cs).getGraphicsAlgorithm();
		editor.setFocus();
		editor.select(newEditPart);
		editor.click(newEditPart);

		final Display display = editor.getWidget().getDisplay();
		display.syncExec(() -> {
			final FigureCanvas canvas = (FigureCanvas) editor.getWidget().getDisplay().getFocusControl();
			final Rectangle bounds = gsep.getFigure().getBounds();
			final Point point = PlatformUI.getWorkbench().getDisplay().map(display.getFocusControl(), null, bounds.x,
					bounds.y);
			renameLocation.x = point.x - canvas.getHorizontalBar().getSelection() + labelGA.getX()
					+ labelGA.getWidth() / 2;
			renameLocation.y = point.y - canvas.getVerticalBar().getSelection() + labelGA.getY()
					+ labelGA.getHeight() / 2;
		});
	}

	/**
	 * Use robot to click element.  Using mouse to click has a different effect than editor.click(editpart) and editor.select(editpart).
	 * This method will bring selected element into full view on canvas.
	 * @param editor
	 * @param editPart
	 */
	public void mouseSelectElement(final SWTBotGefEditor editor, final SWTBotGefEditPart editPart) {
		final GraphitiShapeEditPart gsep = (GraphitiShapeEditPart) editPart.part();
		editor.setFocus();

		final Display display = editor.getWidget().getDisplay();
		display.syncExec(() -> {
			final FigureCanvas canvas = (FigureCanvas) display.getFocusControl();
			final Rectangle bounds = gsep.getFigure().getBounds();
			final Point point = PlatformUI.getWorkbench().getDisplay().map(display.getFocusControl(), null, bounds.x,
					bounds.y);
			bot.mouseLeftClick(point.x - canvas.getHorizontalBar().getSelection() + 3,
					point.y - canvas.getVerticalBar().getSelection() + 3);
		});
	}

	public void renameConnection(final SWTBotGefEditor editor, final SWTBotGefConnectionEditPart conEditPart,
			final ConnectionPoint connectionPoint, final String newName) {
		editor.setFocus();
		editor.select(conEditPart);

		final GraphitiConnectionEditPart gcep = (GraphitiConnectionEditPart) conEditPart.part();
		// Find label
		final ConnectionDecorator cd = getLabelShape((FreeFormConnection) gcep.getPictogramElement());
		final java.awt.Point conLblLocation = new java.awt.Point();
		setLabelLocation(editor, cd.getGraphicsAlgorithm(), connectionPoint.getValue(gcep), conLblLocation);
		bot.setAutoDelay(700);
		bot.mouseLeftClick(conLblLocation.x, conLblLocation.y);
		bot.mouseLeftClick(conLblLocation.x, conLblLocation.y);

		sleep(2);
		// Rename
		editor.directEditType(newName);
		waitUntilElementExists(editor, newName);
	}

	/**
	 * Find location of connection label.  Mouse must be hovering over label for rename.
	 * @param editor
	 * @param labelGA
	 * @param relativeLabelLocation
	 * @param conLblLocation
	 */
	private void setLabelLocation(SWTBotGefEditor editor, GraphicsAlgorithm labelGA,
			org.eclipse.draw2d.geometry.Point relativeLabelLocation, java.awt.Point conLblLocation) {
		final Display display = editor.getWidget().getDisplay();
		display.syncExec(() -> {
			final FigureCanvas canvas = (FigureCanvas) display.getFocusControl();
			final Point point = PlatformUI.getWorkbench().getDisplay()
					.map(display.getFocusControl(), null, relativeLabelLocation.x, relativeLabelLocation.y);
			conLblLocation.x = point.x - canvas.getHorizontalBar().getSelection() + labelGA.getX()
					+ labelGA.getWidth() / 2;
			conLblLocation.y = point.y - canvas.getVerticalBar().getSelection() + labelGA.getY()
					+ labelGA.getHeight() / 2;
		});
	}

	// Find connection label connection decorator
	private ConnectionDecorator getLabelShape(final FreeFormConnection ffc) {
		for (final ConnectionDecorator cd : ffc.getConnectionDecorators()) {
			if (ShapeNames.primaryLabelShapeName.equalsIgnoreCase(PropertyUtil.getName(cd))) {
				return cd;
				}
			}

		return null;
	}

	// Find element label shape
	private static Shape getLabelShape(final ContainerShape cs) {
		for (final Shape shape : cs.getChildren()) {
			if (ShapeNames.primaryLabelShapeName.equalsIgnoreCase(PropertyUtil.getName(shape))) {
				return shape;
				}
			}

		return null;
	}

	public void createAbstractTypeAndImplementation(final String packageName, final Point location) {
		final AgeSWTBotGefEditor editor = getEditor(packageName);
		editor.setFocus();
		editor.click(packageName);
		resizeEditPart(editor, new Point(600, 600), packageName);
		createToolItem(editor, ToolTypes.getToolItem(AbstractType.class), location, packageName);
		final SWTBotGefEditPart newEditPart = getNewElement(editor, AbstractTypeImpl.class);
		renameElement(editor, newEditPart, ElementNames.abstractTypeName);
		waitUntilElementExists(editor, ElementNames.abstractTypeName);
		createImplementation(editor, ToolTypes.getToolItem(AbstractImplementation.class), ElementNames.abstractTypeName,
				"impl", new Point(100, 200), packageName);
	}

	public void createTypeAndImplementation(final AgeSWTBotGefEditor editor, final Point point, final String implName,
			final String typeName, final String impl, final String packageName) {
		createToolItem(editor, impl, point, packageName);
		waitUntilShellIsActive("Create Component Implementation");
		setTextWithId(ClassifierOperationDialog.primaryPartIdentifier, implName);
		clickRadio("New Component Type");
		setTextWithId(ClassifierOperationDialog.baseValueIdentifier, typeName);
		clickButton("OK");
		waitUntilElementExists(editor, typeName + "." + implName);
	}

	public void clickElement(final SWTBotGefEditor editor, final String... elementPath) {
		editor.setFocus();
		editor.click(findEditPart(editor, elementPath));
	}

	public void selectElement(final SWTBotGefEditor editor, final String... elementPath) {
		editor.setFocus();
		editor.select(findEditPart(editor, elementPath));
		// Pause for editor update on selection
		sleep(3);
	}

	// Select multiple elements
	public void selectElements(final SWTBotGefEditor editor, final String[]... elementPaths) {
		editor.setFocus();
		final List<SWTBotGefEditPart> editParts = new ArrayList<>();
		for (final String[] elementPath : elementPaths) {
			editParts.add(findEditPart(editor, elementPath));
		}

		editor.select(editParts);
	}

	// Click elements one at a time
	public void clickElements(final SWTBotGefEditor editor, final String[]... elementPaths) {
		for (final String[] elementPath : elementPaths) {
			editor.click(findEditPart(editor, elementPath));
		}
	}

	public static String qualifiedName(final String projectName, final String classifierName) {
		return projectName + "::" + classifierName;
	}

	public SWTBotToolbarButton getToolbarButtonWithTooltip(final String tooltip) {
		return bot.toolbarButtonWithTooltip(tooltip);
	}

	public void clickToolbarButtonWithTooltip(final String tooltip) {
		bot.toolbarButtonWithTooltip(tooltip).click();
	}

	// Drag dialog down and to the left. This can be used to move a shell out of canvas for element selection.
	public void dragShellAwayFromEditor(final AgeSWTBotGefEditor editor, final String shellTitle) {
		final Display display = editor.getWidget().getDisplay();
		display.syncExec(() -> {
			final int y = display.getActiveShell().getBounds().height;
			final Shell shell = bot.shell(shellTitle).widget;
			shell.setFocus();
			final org.eclipse.swt.graphics.Rectangle outer = shell.getBounds();
			final org.eclipse.swt.graphics.Rectangle inner = shell.getClientArea();
			bot.setAutoDelay(50);
			bot.mouseMove(outer.x + outer.width / 2, outer.y + (outer.height - inner.height) / 2);
			bot.mouseLeftClickPress();
			bot.mouseMove(outer.width / 2, y / 2 - outer.height / 2);
			bot.mouseLeftClickRelease();
			bot.setAutoDelay(600);
		});
	}

	public void setFocusShell(final String title) {
		bot.shell(title).setFocus();
	}

	/**
	 * Return a connection point.  Used for label reference.
	 */
	public enum ConnectionPoint {
		FIRST {
			@Override
			public org.eclipse.draw2d.geometry.Point getValue(final GraphitiConnectionEditPart gcep) {
				return gcep.getConnectionFigure().getPoints().getFirstPoint();
			}
		},
		MIDDLE {
			@Override
			public org.eclipse.draw2d.geometry.Point getValue(final GraphitiConnectionEditPart gcep) {
				return gcep.getConnectionFigure().getPoints().getMidpoint();
			}
		},
		LAST {
			@Override
			public org.eclipse.draw2d.geometry.Point getValue(final GraphitiConnectionEditPart gcep) {
				return gcep.getConnectionFigure().getPoints().getLastPoint();
			}
		};

		public abstract org.eclipse.draw2d.geometry.Point getValue(final GraphitiConnectionEditPart gcep);
	}

	public void setConnectionOptionComboInPropertiesView(final AgeSWTBotGefEditor editor,
			final SWTBotGefConnectionEditPart connectionEditPart, final String tab, final String comboId,
			final String selection) {
		editor.select(connectionEditPart);
		clickConnection(editor, ((GraphitiConnectionEditPart) connectionEditPart.part()).getConnectionFigure());
		selectWidget("Appearance");
		editor.setFocus();
		editor.select(connectionEditPart);

		bot.viewByTitle("Properties").setFocus();
		clickCombo(comboId, selection);
	}

	public void keyPress(final int key) {
		bot.keyPress(key);
	}

	public void keyRelease(final int key) {
		bot.keyRelease(key);
	}

	/**
	 * Find editor and save and close.
	 * @param title of editor
	 */
	public void saveAndCloseEditor(final String title) {
		for (final SWTBotEditor editor : bot.editors()) {
			if (editor.getTitle().equalsIgnoreCase(title)) {
				editor.saveAndClose();
				return;
			}
		}
	}
}