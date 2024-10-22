/**
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file).
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
import static org.osate.ge.aadl2.internal.AadlReferenceUtil.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestCommands.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestUtil.*;
import static org.osate.ge.tests.endToEnd.util.UiTestUtil.*;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.junit.Test;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.ge.gef.ui.transientviews.TransientView;
import org.osate.ge.gef.ui.transientviews.TransientViewTreeNode;
import org.osate.ge.tests.endToEnd.util.DiagramElementReference;
import org.osate.ge.tests.endToEnd.util.DiagramReference;

import javafx.embed.swt.FXCanvas;
import javafx.scene.Scene;

public class TransientViewTest {
	private static final String TRANSIENT_VIEW_TEST = "ge_transient_view_test";

	@Test
	public void testTransientView() {
		final String classifierName = "TestSystem";

		// Create a project
		prepareForTesting();
		createAadlProject(TRANSIENT_VIEW_TEST);

		// Create package
		createNewPackageWithPackageDiagram(TRANSIENT_VIEW_TEST, TRANSIENT_VIEW_TEST);

		// Create a classifier
		final DiagramReference pkgDiagram = defaultDiagram(TRANSIENT_VIEW_TEST, TRANSIENT_VIEW_TEST);
		final DiagramElementReference pkgRef = packageElement(TRANSIENT_VIEW_TEST);
		createElementAndLayout(pkgDiagram, pkgRef, "System Type", getClassifierRelativeReference("new_classifier"),
				classifierName);

		// Save and Close
		saveAndCloseDiagramEditor(pkgDiagram);

		// Get resource for package
		final IFile pkgFile = ResourcesPlugin.getWorkspace()
				.getRoot()
				.getProject(TRANSIENT_VIEW_TEST)
				.getFile(TRANSIENT_VIEW_TEST + ".aadl");
		assertTrue("Unable to find package file", pkgFile.exists());

		// Open model
		final ResourceSetImpl rs = new ResourceSetImpl();
		final URI uri = URI.createPlatformResourceURI(pkgFile.getFullPath().toString(), true);
		final Resource r = rs.getResource(uri, true);
		try {
			r.load(null);
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}

		// Access the package and classifier objects
		final AadlPackage pkg = (AadlPackage) r.getContents().get(0);
		final Classifier classifier = pkg.getPublicSection().getOwnedClassifiers().get(0);

		// Create a tree containing the package and the classifier
		final TransientViewTreeNode treeRoot = TransientViewTreeNode.createRoot();
		final TransientViewTreeNode pkgViewNode = TransientViewTreeNode.createChild(treeRoot, pkg);
		final TransientViewTreeNode classifierViewNode = TransientViewTreeNode.createChild(pkgViewNode, classifier);

		// Create transient view
		final TransientView transientView = new TransientView(treeRoot);

		// Verify that nodes exist for package and classifier
		assertNotNull("Unable to retrieve package scene node", transientView.getSceneNode(pkgViewNode));
		assertNotNull("Unable to retrieve classifier scene node", transientView.getSceneNode(classifierViewNode));

		// Create window
		try {
			// Open a window that contains the scene nodes
			final var shell = UIThreadRunnable.syncExec(() -> {
				final Shell newShell = new Shell(Display.getDefault().getActiveShell(), SWT.SHELL_TRIM);
				newShell.setSize(640, 480);
				newShell.setText("Transient View Test");
				newShell.setLayout(new FillLayout());

				final FXCanvas fxCanvas = new FXCanvas(newShell, SWT.NONE);
				fxCanvas.setScene(new Scene(transientView.getRootSceneNode()));
				newShell.open();
				return newShell;
			});

			// Close the window
			UIThreadRunnable.syncExec(() -> {
				shell.close();
			});
		} catch (final Exception ex) {
			throw new RuntimeException("Unable to display transient view", ex);
		}
	}
}
