/*
 * <copyright>
 * Copyright  2009 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.aadl2.modelsupport.modeltraversal;

import java.util.Iterator;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.AadlUtil;

/**
 * Traversal implementation that visits all the Component Implementations used in
 * the subtree rooted at the given node in a prefix order. That is, given a component implementation, it
 * <ol>
 * 	 <li>visits the component implementation
 * 	 <li>For each subcomponent (including subprogram subcomponents) it
 * 		 recursively visits the component implementation of the subcomponent,
 * 		 if the full component implementation is given.
 * </ol>
 *
 * <p>A particular component implementation may be visited more than once.
 *
 * @author aarong
 */
abstract class AbstractTopDownComponentTraversal extends AbstractTraversal {

	protected AbstractTopDownComponentTraversal(final IProcessingMethod pm) {
		super(pm);
	}

	@Override
	public final void visitRoot(Element root) {
		if (root instanceof ComponentImplementation) {
			final Stack<ComponentImplementation> visited = new Stack<ComponentImplementation>();
			processDown((ComponentImplementation) root, visited);
		} else {
			throw new IllegalArgumentException("Root node must be a ComponentImplementation");
		}
	}

	@Override
	public final EList visitWorkspace() {
		return visitWorkspaceDeclarativeModels();
	}

	@Override
	public final EList visitWorkspaceDeclarativeModels() {
		final Stack<ComponentImplementation> visited = new Stack<ComponentImplementation>();
		/*
		 * Our roots will be those component implementations that are not
		 * referenced by anything, e.g., top-level systems.
		 */
		final EList<ComponentImplementation> cil = AadlUtil.getAllComponentImpl();
		for (Iterator<ComponentImplementation> all = cil.iterator(); processingMethod.notCancelled()
				&& all.hasNext();) {
			final ComponentImplementation aobj = all.next();
			if (!hasUsageReferences(aobj, cil)) {
				processDown(aobj, visited);
			}
		}
		return processingMethod.getResultList();
	}

	@Override
	public final EList visitWorkspaceInstanceModels() {
		throw new UnsupportedOperationException("Visit all the instance models in the workspace not supported.");
	}

	protected final void processDown(final ComponentImplementation cimpl,
			final Stack<ComponentImplementation> visited) {
		/*
		 * Avoid loops in subcomponent nesting. This only happens in
		 * badly formed models, but we generally try to avoid it because
		 * we may be running as part of the analysis that detects bad
		 * models.
		 */
		if (!visited.contains(cimpl)) {
			visited.push(cimpl);

			/*
			 * Visit the current component impl, and then process all the
			 * subcomponents.
			 */
			visitComponentImpl(cimpl);

			final EList<Subcomponent> scl = cimpl.getAllSubcomponents();
			visitSubcomponents(scl, visited);

			visited.pop();
		}
	}

	private void visitSubcomponents(final EList<Subcomponent> scl, final Stack<ComponentImplementation> visited) {
		for (Iterator<Subcomponent> all = scl.iterator(); processingMethod.notCancelled() && all.hasNext();) {
			final Subcomponent sc = all.next();
			visitSubcomponent(sc, visited);
		}
	}

	protected abstract void visitComponentImpl(ComponentImplementation ci);

	protected abstract void visitSubcomponent(Subcomponent sc, Stack<ComponentImplementation> visited);

	private boolean hasUsageReferences(final ComponentClassifier aobj, final EList<ComponentImplementation> allci) {
		for (Iterator<ComponentImplementation> all = allci.iterator(); processingMethod.notCancelled()
				&& all.hasNext();) {
			ComponentImplementation ci = all.next();
			EList<Subcomponent> sublist = ci.getAllSubcomponents();
			for (Iterator<Subcomponent> it = sublist.iterator(); it.hasNext();) {
				Subcomponent sc = it.next();
				ComponentClassifier cc = sc.getAllClassifier();
				if (cc == aobj) {
					return true;
				}
			}
		}
		return false;
	}
}