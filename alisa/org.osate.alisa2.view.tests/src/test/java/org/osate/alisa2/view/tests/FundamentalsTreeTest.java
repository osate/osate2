package org.osate.alisa2.view.tests;

import java.util.Collection;

//import org.eclipse.sirius.tests.junit;
import org.eclipse.sirius.tests.unit.common.TreeCommonTest;
import org.eclipse.sirius.tree.DTree;
import org.eclipse.sirius.tree.business.internal.dialect.common.viewpoint.GlobalContext;
import org.eclipse.sirius.viewpoint.DRepresentation;

public class FundamentalsTreeTest extends TreeCommonTest {

	private GlobalContext ctx;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		ctx = new GlobalContext(session.getModelAccessor(), session.getInterpreter(), null);
	}

	@Override
	protected void tearDown() throws Exception {
		ctx = null;

		super.tearDown();
	}

	public void testItemOrders() {

		Collection<DRepresentation> trees = getRepresentations(TREE_DESCRIPTION_ID, semanticModel);

		// Check tests data.
		assertTrue("Tests data have changed, review this test.", trees.size() == 1);
		assertTrue("Tests data have changed, review this test.", trees.iterator().next() instanceof DTree);

		final DTree dTree = (DTree) trees.iterator().next();

//		checkItemOrder(dTree);
//
//		// Refresh should not change order
//		session.getTransactionalEditingDomain().getCommandStack()
//				.execute(new RecordingCommand(session.getTransactionalEditingDomain()) {
//
//					@Override
//					protected void doExecute() {
//						new DTreeUserInteraction(dTree, ctx).refreshContent(defaultProgress);
//					}
//				});
//
//		checkItemOrder(dTree);

	}

}
