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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.modelsupport.util.AadlUtil;

/**
 * Traversal implementation that visits all the component implementations in the
 * subtree rooted at the given node in reverse containment order. That is, a
 * component implementation is visited before all the component implementations
 * that reference it.
 *
 * @author aarong
 */
final class BottomUpComponentImplTraversal extends AbstractTraversal {
	public BottomUpComponentImplTraversal(final IProcessingMethod pm) {
		super(pm);
	}

	@Override
	public void visitRoot(final Element root) {
		if (root instanceof ComponentImplementation) {
			final EList cil = new ForAllElement().processTopDownComponentImpl((ComponentImplementation) root);
			processBottomUpComponentImpl(cil);
		} else {
			throw new IllegalArgumentException("Root node must be a ComponentImpl");
		}
	}

	@Override
	public EList visitWorkspace() {
		return visitWorkspaceDeclarativeModels();
	}

	@Override
	public EList visitWorkspaceDeclarativeModels() {
		processBottomUpComponentImpl(AadlUtil.getAllComponentImpl());
		return processingMethod.getResultList();
	}

	@Override
	public EList visitWorkspaceInstanceModels() {
		throw new UnsupportedOperationException("Visit all the instance models in the workspace not supported.");
	}

	private void processBottomUpComponentImpl(final EList<ComponentImplementation> cil) {
		final EList<ComponentImplementation> leafNodes = new BasicEList<ComponentImplementation>();
		for (Iterator<ComponentImplementation> all = cil.iterator(); all.hasNext();) {
			final ComponentImplementation aobj = all.next();
			/**
			 * FIXME: verify that we traverse all subcomponents owned and inherited
			 */
			final EList<Subcomponent> subs = aobj.getOwnedSubcomponents();
			final EList<SubprogramCall> calls;
			if (aobj instanceof BehavioredImplementation) {
				calls = ((BehavioredImplementation) aobj).getSubprogramCalls();
			} else {
				calls = new BasicEList<SubprogramCall>();
			}
			// all component impls without subcomponent - they are the bottom
			if (subs.isEmpty() && calls.isEmpty()) {
				leafNodes.add(aobj);
			} else {
				// also add it if none of the subs point to a component impl
				boolean foundnone = true;
				for (Iterator<Subcomponent> it = subs.iterator(); foundnone && it.hasNext();) {
					final Subcomponent sc = it.next();
					if (sc.getAllClassifier() instanceof ComponentImplementation) {
						foundnone = false;
					}
				}
				// now do the same for subprogram calls
				for (Iterator<SubprogramCall> iit = calls.iterator(); foundnone && iit.hasNext();) {
					SubprogramCall sc = iit.next();
					if (sc.getCalledSubprogram() instanceof ComponentImplementation) {
						foundnone = false;
					}
				}
				if (foundnone) {
					leafNodes.add(aobj);
				}
			}
		}
		// now process the encl list
		EList<ComponentImplementation> nextLevel = leafNodes;
		while (processingMethod.notCancelled() && !nextLevel.isEmpty()) {
			nextLevel = processUpComponentImpls(nextLevel, cil);
		}
	}

	/**
	 * Working our way up the declaration hierarchy. process list of compoennt
	 * impls and return list of component impl that have references to these
	 * component impls in their subcomponents
	 *
	 * @param list
	 *                 List of component impl to be processed
	 * @param allci
	 *                 The list of all component impls
	 * @return list of component impls whose subcomponents reference the
	 *             compoennt impls in the list
	 */
	private EList<ComponentImplementation> processUpComponentImpls(final EList<ComponentImplementation> list,
			final EList<ComponentImplementation> allci) {
		final EList<ComponentImplementation> encl = new UniqueEList<ComponentImplementation>();
		for (Iterator<ComponentImplementation> it = list.iterator(); processingMethod.notCancelled() && it.hasNext();) {
			final ComponentImplementation aobj = it.next();
			processingMethod.processObject(aobj);
			addUsageReferences(aobj, encl, allci);
		}
		return encl;
	}

	/**
	 * add component impls with usage references to the specified aobj
	 * (Compopnent Impl)
	 *
	 * @param aobj
	 *                 the component impl being referenced
	 * @param encl
	 *                 the EList of component impl that has references to aobj;
	 *                 references are added to it
	 * @param allci
	 *                 The list of all component impls
	 */
	private void addUsageReferences(ComponentImplementation aobj, EList<ComponentImplementation> encl,
			EList<ComponentImplementation> allci) {
		for (Iterator<ComponentImplementation> all = allci.iterator(); processingMethod.notCancelled()
				&& all.hasNext();) {
			final ComponentImplementation ci = all.next();
			final EList<Subcomponent> sublist = ci.getAllSubcomponents();
			addUsageReferencesSubcomponents(sublist, encl, aobj, ci);

			EList<SubprogramCall> calls;
			if (ci instanceof BehavioredImplementation) {
				calls = ((BehavioredImplementation) ci).getSubprogramCalls();
			} else {
				calls = new BasicEList<SubprogramCall>();
			}
			addUsageReferencesSubprogramCalls(calls, encl, aobj, ci);
		}
	}

	private void addUsageReferencesSubcomponents(final EList<Subcomponent> sublist, EList<ComponentImplementation> encl,
			ComponentImplementation aobj, final ComponentImplementation ci) {
		for (Iterator<Subcomponent> it = sublist.iterator(); it.hasNext();) {
			final Subcomponent sc = it.next();
			final ComponentClassifier cc = sc.getAllClassifier();
			if (cc == aobj) {
				encl.add(ci);
			}
		}
	}

	private void addUsageReferencesSubprogramCalls(final EList<SubprogramCall> calls,
			EList<ComponentImplementation> encl, ComponentImplementation aobj, final ComponentImplementation ci) {
		for (Iterator<SubprogramCall> it = calls.iterator(); it.hasNext();) {
			final SubprogramCall sc = it.next();
			if (sc instanceof SubprogramCall) {
				final CalledSubprogram csub = sc.getCalledSubprogram();
				if (csub == aobj) {
					encl.add(ci);
				}
			}
		}
	}
}
