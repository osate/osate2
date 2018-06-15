package org.osate.ge.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.MenuItem;
import org.hamcrest.CustomMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osate.aadl2.AbstractType;
import org.osate.ge.tests.AgeGefBot.AgeSWTBotGefEditor;

public class DirtyStateTest {
	final AgeGefBot bot = new AgeGefBot();

	@Before
	public void setUp() {
		bot.maximize();
		bot.createNewProjectAndPackage(ElementNames.projectName, ElementNames.packageName);
		bot.openDiagram(new String[] { ElementNames.projectName }, ElementNames.packageName);
	}

	@After
	public void tearDown() {
		bot.deleteProject(ElementNames.projectName);
	}

	@Test
	public void testDirtyState() {
		final AgeSWTBotGefEditor editor = bot.getEditor(ElementNames.packageName);
		bot.resizeEditPart(editor, new Point(600, 600), ElementNames.packageName);
		editor.save();
		assertFalse(editor.isDirty());
		bot.createToolItemAndRename(editor, AbstractType.class, new Point(45, 45), ElementNames.abstractTypeName,
				ElementNames.packageName);

		assertTrue(editor.isDirty());
		editor.save();
		assertFalse(editor.isDirty());

		// Test that undo and redo works properly with the dirty state.
		undo();
		assertTrue(editor.isDirty());
		redo();
		assertFalse(editor.isDirty());
	}

	private void undo() {
		bot.getActiveShell().menu().menu("Edit").menu(new CustomMatcher<MenuItem>("Undo Menu Item") {

			@Override
			public boolean matches(final Object item) {
				final MenuItem menuItem = (MenuItem) item;
				System.err.println(menuItem.getText());
				return menuItem.getText().startsWith("Undo");
			}
		}, false, 0).click();
	}

	private void redo() {
		bot.getActiveShell().menu().menu("Edit").menu(new CustomMatcher<MenuItem>("Redo Menu Item") {
			@Override
			public boolean matches(final Object item) {
				final MenuItem menuItem = (MenuItem) item;
				System.err.println(menuItem.getText());
				return menuItem.getText().startsWith("Redo");
			}
		}, false, 0).click();
	}
}
