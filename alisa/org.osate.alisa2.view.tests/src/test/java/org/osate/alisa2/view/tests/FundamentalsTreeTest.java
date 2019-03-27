package org.osate.alisa2.view.tests;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.sirius.tests.support.api.TestsUtil;
import org.eclipse.sirius.tests.support.api.TreeTestCase;
import org.eclipse.sirius.tree.DTree;
import org.eclipse.sirius.tree.description.TreeDescription;
import org.eclipse.sirius.tree.ui.business.api.helper.TreeUIHelper;
import org.eclipse.sirius.tree.ui.tools.api.editor.DTreeEditor;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorPart;

public class FundamentalsTreeTest extends TreeTestCase {

	private static final String SEMANTIC_MODEL_PATH = "/org.osate.alisa2.model/model/safe2.ecore";
	private static final String MODELER_PATH = "/org.osate.alisa2.view/description/view.odesign";
	private static final String SESSION_PATH = "/org.osate.alisa2.view/description/representations.aird";

	private static final String TREE_DESCRIPTION_ID = "HackOverview";

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		genericSetUp(SEMANTIC_MODEL_PATH, MODELER_PATH, SESSION_PATH);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

// Adapted from org.eclipse.sirius.tests.api.tools.TreeItemRefreshTest.testRefreshElement()
	public void testFundamentalsTree() {
		final TreeDescription treeDescription = find(TREE_DESCRIPTION_ID);
		DTree newTree = (DTree) getRepresentations(TREE_DESCRIPTION_ID).toArray()[0];
		final TreeDescription desc = newTree.getDescription();
		IEditorPart openedEditor = DialectUIManager.INSTANCE.openEditor(session, newTree, new NullProgressMonitor());
		TestsUtil.synchronizationWithUIThread();
		DTreeEditor treeEditor = (DTreeEditor) openedEditor;
		Tree tree = (Tree) treeEditor.getControl();
		String currentHtml = TreeUIHelper.toContentHTMl(tree);

		assertEquals("yuss.", currentHtml);
	}

}
