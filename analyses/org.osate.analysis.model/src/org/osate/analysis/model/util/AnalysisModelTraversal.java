/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.analysis.model.util;

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Switch;
import org.osate.analysis.model.AnalysisElement;

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
 * <p>It is unlikely that a Switch implementation used with this traversal is going to have a meaningful return
 * type.  We cannot use the {@link Void} class as the return type, however, because the only legal value
 * for {@code Void} is {@code null}.  The switch methods are supposed to return {@code null} when the method
 * has not handled the case and the case method for the superclass should be invoked.  For this reason,
 * the enum {@link Nothing} is provided that has one member {@link Nothing#NONE}.  The switches can use the return
 * type of {@code Nothing} and return {@code Nothing.NONE} in the normal case, and {@code null} when the case
 * is not handled.
 *
 * @author aarong
 *
 * @param <S> The class of the {@code Switch} object.
 */
public abstract class AnalysisModelTraversal<S extends Switch<?>> {
	/**
	 * Enumeration with a single value {@link #NONE}.  Meant to be used as the return value for Switch implementations
	 * used when traversing the model.
	 */
	public static enum Nothing {
		NONE
	};

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
	public final void visitAnalysisElement(final AnalysisElement analysisElement) {
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
	 * explicitly, pass the child to {@link AnalysisModelTraversal#visitAnalysisElement(AnalysisElement)}.
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
		for (final Iterator<EObject> childrenIter = analysisElement.getOrderedChildren().iterator(); childrenIter
				.hasNext() && !progressMonitor.isCanceled();) {
			// NB. getOrderedChildren() guarantees AnalysisElement objects
			visitAnalysisElement((AnalysisElement) childrenIter.next());
		}
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
		amt.visitAnalysisElement(root);
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
		amt.visitAnalysisElement(root);
	}
}
