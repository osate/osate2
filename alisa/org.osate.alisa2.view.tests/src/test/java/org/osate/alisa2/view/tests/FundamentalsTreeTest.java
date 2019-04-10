package org.osate.alisa2.view.tests;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.sirius.tests.support.api.TestsUtil;
import org.eclipse.sirius.tests.support.api.TreeTestCase;
import org.eclipse.sirius.tree.DTree;
import org.eclipse.sirius.tree.ui.business.api.helper.TreeUIHelper;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.tools.internal.editor.AbstractDTreeEditor;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorPart;

public class FundamentalsTreeTest extends TreeTestCase {

	private static final String PLUGIN_ID = "org.osate.alisa2.view.tests";

	private static final String AIRD_FILE = "representations.aird";

	private static final String DATA_UNIT_DIR = PLUGIN_ID + "/src/test/resources/BoundaryDiagramTests/";

	private static final String SEMANTIC_MODEL_PATH = "org.osate.alisa2.model/model/safe2.ecore";
	private static final String MODELER_PATH = "org.osate.alisa2.view/description/view.odesign";

	private IEditorPart openedEditor;

	private static final String TREE_REPRESENTATION_NAME = "Containment";

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		genericSetUp(SEMANTIC_MODEL_PATH, MODELER_PATH, DATA_UNIT_DIR + AIRD_FILE);
		DTree tree = (DTree) getRepresentations(TREE_REPRESENTATION_NAME).toArray()[0];
		openedEditor = DialectUIManager.INSTANCE.openEditor(session, tree, new NullProgressMonitor());
		TestsUtil.synchronizationWithUIThread();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testFundamentalsTree() {
		AbstractDTreeEditor treeEditor = (AbstractDTreeEditor) openedEditor;
		Tree tree = treeEditor.getTableViewer().getTreeViewer().getTree();
		String currentHtml = TreeUIHelper.toContentHTMl(tree);
		// @formatter:off
		assertEquals("<table>\n" +
				"<tr><td>patient</td></tr>\n" +
				"<tr><td>clinician</td></tr>\n" +
				"<tr><td>pulseOx</td></tr>\n" +
				"<tr><td>appLogic</td></tr>\n" +
				"<tr><td></td></tr>\n" +
				"<tr><td>appDisplay</td></tr>\n" +
				"<tr><td></td></tr>\n" +
				"</table>", currentHtml);
		// @formatter:on
	}

}
