package org.osate.ge.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osate.aadl2.AbstractType;
import org.osate.ge.DiagramExporter;
import org.osate.ge.tests.AgeGefBot.AgeSWTBotGefEditor;

public class DiagramExporterTest {
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
	public void createNewAADLPackage() {
		final AgeSWTBotGefEditor editor = bot.getEditor(ElementNames.packageName);
		bot.resizeEditPart(editor, new Point(600, 600), ElementNames.packageName);
		bot.createToolItemAndRename(editor, AbstractType.class, new Point(45, 45), ElementNames.abstractTypeName,
				ElementNames.packageName);
		editor.saveAndClose();

		// Must run in an UI thread
		Display.getDefault().syncExec(() -> {
			try {
				final IFile diagramFile = (IFile) ResourcesPlugin.getWorkspace().getRoot()
						.findMember(ElementNames.projectName + "/diagrams/" + editor.getReference().getPartName());
				final File tmpFile = File.createTempFile("org.osate.ge.tests.diagram_export", ".png");
				tmpFile.deleteOnExit();
				DiagramExporter.exportDiagramAsPng(diagramFile, tmpFile);
				assertTrue(tmpFile.exists());
			} catch (final IOException e) {
				Assert.fail("Export diagram test IOException: " + e.getMessage());
			}
		});
	}
}
