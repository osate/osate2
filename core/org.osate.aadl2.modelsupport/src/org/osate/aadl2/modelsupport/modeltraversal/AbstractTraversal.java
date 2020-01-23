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
