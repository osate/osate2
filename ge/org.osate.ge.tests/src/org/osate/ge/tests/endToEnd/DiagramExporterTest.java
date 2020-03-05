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
