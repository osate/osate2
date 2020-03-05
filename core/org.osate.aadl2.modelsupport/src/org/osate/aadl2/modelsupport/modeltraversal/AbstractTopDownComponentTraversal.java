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