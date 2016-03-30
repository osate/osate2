/* <copyright>
 * Copyright  2004-2006 by Carnegie Mellon University, all rights reserved.
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
 *
 * </copyright>
 *
 *
 * @version $Id: BottomUpComponentImplTraversal.java,v 1.5 2010-03-29 19:17:54 jseibel Exp $
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
