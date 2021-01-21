package org.osate.analysis.resource.budgets.analysis.model.util;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.util.Switch;
import org.osate.analysis.resources.budgets.internal.models.analysis.AnalysisElement;

/**
 * Class for execute a traversal of an analysis model.  A traversal of model subtree is
 * performed by calling {@link #visitAnalysisElement(AnalysisElement)} on the root of the
 * subtree.  Each node is visited by passing it to the {@link Switch} object associated with
 * this object when it is constructed.
 *
 * <p>The class may also be associated with a {@link IProgressMonitor progress monitor}.  The traversal
 * tests the monitor for cancellation, and ends the traversal accordingly.   To mark progress during
 * traversal, the <em>same</em> progress monitor should also be referenced by and manipulated by the
 * {@code Switch} object.
 *
 * <p>Most analyses should only need a simple preorder or postorder traversal of the model.  The {@code static}
 * methods {@link #preOrder} and {@link #postOrder} accommodate this need.
 *
 * @author aarong
 *
 * @param <S> The class of the {@code Switch} object.
 */
public abstract class AnalysisModelTraversal<S extends Switch<?>> {
	private final S analysisSwitch;
	private final IProgressMonitor progressMonitor;

	/**
	 * Create a new analysis model traversal object.
	 * @param analysisSwitch The switch to use to process each model element.  Must not be {@code null}.
	 * @param progressMonitor The progress monitor to use to check for cancellation.  <em>May be {@code null}.</em>
	 */
	protected AnalysisModelTraversal(final S analysisSwitch, final IProgressMonitor progressMonitor) {
		this.analysisSwitch = analysisSwitch;
		this.progressMonitor = progressMonitor == null ? new NullProgressMonitor() : progressMonitor;
	}

	/**
	 * Visit the subtree of the model rooted at the given model element.
	 * @param analysisElement The model element to visit; must not be {@code null}.
	 */
	public final void visitAnaylsisElement(final AnalysisElement analysisElement) {
		// check for cancellation
		if (!progressMonitor.isCanceled()) {
			doVisitAnalysisElement(analysisElement);
		}
	}

	/**
	 * Called by {@link #doVisitAnalysisElement(AnalysisElement)}: Implement this method to visit the model
	 * element using {@link #visitSelf(AnalysisElement)} and
	 * visit the children.  The method {@link #visitChildren(AnalysisElement)} can be used to visit all
	 * the children, but is not suitable for an <em>in order</em> traversal.  To visit a child
	 * explicitly, pass the child to {@link AnalysisModelTraversal#visitAnaylsisElement(AnalysisElement)}.
	 *
	 * @param analysisElement The model element to visit; must not be {@code null}.  This method <em>must</em> call
	 * {@link #visitSelf(AnalysisElement)} on this element.
	 */
	protected abstract void doVisitAnalysisElement(AnalysisElement analysisElement);

	/**
	 * Visit the given analysis element by passing it to the switch.  Must only be
	 * called from {@link #doVisitAnalysisElement(AnalysisElement)}.
	 * @param analysisElement The model element to visit; must not be {@code null}.
	 */
	protected final void visitSelf(final AnalysisElement analysisElement) {
		analysisSwitch.doSwitch(analysisElement);
	}

	/**
	 * Iterates over all the children of the given model element as obtained from
	 * {@link AnalysisElement#getOrderedChildren()}.  This method is {@code final}&mdash;
	 * if you need visit the children in a specific order then there are two options:
	 * (1) override the {@link AnalysisElement#getOrderedChildren()} method of the
	 * model element; or (2) control the order of the visit in the implementation
	 * of {@link AnalysisModelTraversal#doVisitAnalysisElement(AnalysisElement)}.
	 * @param analysisElement The model element to visit; must not be {@code null}.
	 */
	protected final void visitChildren(final AnalysisElement analysisElement) {
		analysisElement.getOrderedChildren().forEach(child -> {
			// NB. getOrderedChildren() guarantees AnalysisElement objects
			visitAnaylsisElement((AnalysisElement) child);
		});
	}

	/**
	 * Perform a preorder traversal of the given model subtree; that is, it is guaranteed that every ancestor of a node <em>N</em>
	 * is visited before <em>N</em> is visited.
	 *
	 * @param root The root node of the model to visit; must not be {@code null}.
	 * @param analysisSwitch The switch to use to process each model element.  Must not be {@code null}.
	 * @param progressMonitor The progress monitor to use to check for cancellation.  <em>May be {@code null}.</em>
	 */
	public static <S extends Switch<?>> void preOrder(final AnalysisElement root, final S analysisSwitch,
			final IProgressMonitor progressMonitor) {
		final AnalysisModelTraversal<S> amt = new AnalysisModelTraversal<S>(analysisSwitch, progressMonitor) {
			@Override
			protected void doVisitAnalysisElement(final AnalysisElement analysisElement) {
				visitSelf(analysisElement);
				visitChildren(analysisElement);
			}
		};
		amt.visitAnaylsisElement(root);
	}

	/**
	 * Perform a postorder traversal of the given model subtree; that is, it is guaranteed that every descendant of a node <em>N</em>
	 * is visited before <em>N</em> is visited.
	 *
	 * @param root The root node of the model to visit; must not be {@code null}.
	 * @param analysisSwitch The switch to use to process each model element.  Must not be {@code null}.
	 * @param progressMonitor The progress monitor to use to check for cancellation.  <em>May be {@code null}.</em>
	 */
	public static <S extends Switch<?>> void postOrder(final AnalysisElement root, final S analysisSwitch,
			final IProgressMonitor progressMonitor) {
		final AnalysisModelTraversal<S> amt = new AnalysisModelTraversal<S>(analysisSwitch, progressMonitor) {
			@Override
			protected void doVisitAnalysisElement(final AnalysisElement analysisElement) {
				visitChildren(analysisElement);
				visitSelf(analysisElement);
			}
		};
		amt.visitAnaylsisElement(root);
	}
}
