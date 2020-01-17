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

import java.util.Stack;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;

/**
 * Traversal implementation that visits all the Component Implementations used in
 * the subtree rooted at the given node in a prefix order. That is, given a component implementation, it
 * <ol>
 *   <li>visits the component implementation
 *   <li>For each subcomponent (including subprogram subcomponents) it
 *       recursively visits the component implementation of the subcomponent,
 *       if the full component implementation is given.
 * </ol>
 *
 * <p>A particular component implementation may be visited more than once.
 *
 * @author aarong
 */
final class TopDownComponentImplTraversal extends AbstractTopDownComponentTraversal {

	protected TopDownComponentImplTraversal(final IProcessingMethod pm) {
		super(pm);
	}

	@Override
	protected void visitComponentImpl(final ComponentImplementation cimpl) {
		processingMethod.processObject(cimpl);
	}

	@Override
	protected void visitSubcomponent(final Subcomponent sc, final Stack visited) {
		final ComponentImplementation ci = sc.getComponentImplementation();
		if (ci != null) {
			processDown(ci, visited);
		}
	}
}
