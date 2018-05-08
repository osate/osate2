/*
 * <copyright>
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
 * @version $Id: AbstractTraversal.java,v 1.5 2010-03-29 19:17:54 jseibel Exp $
 */
package org.osate.aadl2.modelsupport.modeltraversal;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Element;

/**
 * TODO
 *
 * @author aarong
 */
abstract class AbstractTraversal {
	/**
	 * The processing object that defines what to do with a given
	 * model element.
	 */
	protected final IProcessingMethod processingMethod;

	/**
	 * Create a new traversal helper that uses the given processing method.
	 */
	protected AbstractTraversal(final IProcessingMethod pm) {
		processingMethod = pm;
	}

	/**
	 * Process the model starting at the given root node.
	 */
	public abstract void visitRoot(Element root);

	/**
	 * Execute the traversal algorithm using the given list of root
	 * objects. The traversal is run on each root node in the order they appear
	 * in the list.
	 *
	 * <p>
	 * This method checks whether the processing has been cancelled after
	 * visiting each element, and terminates the processing if the traversal has
	 * been cancelled.
	 *
	 * @return The {@link IProcessingMethod#getResultList() result list} of the
	 *         encapsulated processing method.
	 */
	public final EList<Element> visitList(final List<? extends Element> roots) {
		int i;
		final int listSize;

		listSize = roots.size();
		for (i = 0; (processingMethod.notCancelled()) && i < listSize; i++) {
			visitRoot(roots.get(i));
		}
		return processingMethod.getResultList();
	}

	/**
	 * Process all AADL models in the AadlWorkspace. This is an optional
	 * operation.
	 *
	 * <p>
	 * This method checks whether the processing has been cancelled after
	 * visiting each element, and terminates the processing if the traversal has
	 * been cancelled.
	 *
	 * @return The {@link IProcessingMethod#getResultList() result list} of the
	 *         encapsulated processing method.
	 *
	 * @exception UnsupportedOperationException
	 *                Thrown if this operation is not supported.
	 */
	public abstract EList visitWorkspace();

	/**
	 * Process all declarative AADL models in the AadlWorkspace. This is an
	 * optional operation.
	 *
	 * <p>
	 * This method checks whether the processing has been cancelled after
	 * visiting each element, and terminates the processing if the traversal has
	 * been cancelled.
	 *
	 * @return The {@link IProcessingMethod#getResultList() result list} of the
	 *         encapsulated processing method.
	 *
	 * @exception UnsupportedOperationException
	 *                Thrown if this operation is not supported.
	 */
	public abstract EList visitWorkspaceDeclarativeModels();

	/**
	 * Process all AADL instance models in the AadlWorkspace. This is an
	 * optional operation.
	 *
	 * <p>
	 * This method checks whether the processing has been cancelled after
	 * visiting each element, and terminates the processing if the traversal has
	 * been cancelled.
	 *
	 * @return The {@link IProcessingMethod#getResultList() result list} of the
	 *         encapsulated processing method.
	 *
	 * @exception UnsupportedOperationException
	 *                Thrown if this operation is not supported.
	 */
	public abstract EList visitWorkspaceInstanceModels();
}
