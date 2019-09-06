package org.osate.ge.tests.endToEnd;

import static org.junit.Assert.*;
import static org.osate.ge.internal.services.impl.DeclarativeReferenceBuilder.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestCommands.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestUtil.*;
import static org.osate.ge.tests.endToEnd.util.UiTestUtil.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import javax.imageio.stream.MemoryCacheImageOutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.widgets.Display;
import org.junit.Test;
import org.osate.ge.DiagramExporter;

/**
 * Creates a package with a single classifier and confirms that exporting a diagram using the API creates a file.
 *
 */
public class DiagramExporterTest {
	@Test
	public void testExporter() {
		final String PROJECT_NAME = "exporter_test";
		final String PKG_NAME = "test_pkg";
		createAadlProject(PROJECT_NAME);
		createNewPackageWithPackageDiagram(PROJECT_NAME, PKG_NAME);

		createElementAndLayout(defaultDiagram(PROJECT_NAME, PKG_NAME), packageElement(PKG_NAME), "Abstract Type",
				getClassifierRelativeReference("new_classifier"), "TestAbstractType");

		saveDiagramEditor(defaultDiagram(PROJECT_NAME, PKG_NAME));

		// Must run in an UI thread
		final AtomicReference<RuntimeException> exception = new AtomicReference<>();
		Display.getDefault().syncExec(() -> {
			try {
				final IFile diagramFile = (IFile) ResourcesPlugin.getWorkspace().getRoot()
						.findMember(PROJECT_NAME + "/diagrams/" + PKG_NAME + ".aadl_diagram");
				final File tmpFile = File.createTempFile("org.osate.ge.tests.diagram_export", ".png");
				tmpFile.deleteOnExit();
				DiagramExporter.exportDiagramAsPng(diagramFile, tmpFile);
				assertTrue(tmpFile.exists());

				final ByteArrayOutputStream baos = new ByteArrayOutputStream(48000);
				DiagramExporter.exportDiagramAsPng(diagramFile, baos);
				baos.flush();
				assertTrue(baos.size() > 0);

				baos.reset();

				final MemoryCacheImageOutputStream mcios = new MemoryCacheImageOutputStream(baos);
				DiagramExporter.exportDiagramAsPng(diagramFile, mcios);
				mcios.flush();
				assertTrue(baos.size() > 0);
			} catch (final IOException e) {
				exception.set(new RuntimeException(e));
			} catch (final RuntimeException e) {
				exception.set(e);
			}
		});

		if (exception.get() != null) {
			throw exception.get();
		}
	}
}
