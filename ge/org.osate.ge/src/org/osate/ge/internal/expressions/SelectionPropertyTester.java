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
package org.osate.ge.internal.expressions;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.jface.viewers.ISelection;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.ui.tools.ToolUtil;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.internal.util.DiagramElementUtil;

/**
 * Property testers for use with objects implementing ISelection
 *
 */
public class SelectionPropertyTester extends PropertyTester {
	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		final ISelection selection = (ISelection) receiver;
		if (property.equals("allAreDiagramElementsWithSameParent")) {
			return DiagramElementUtil.allHaveSameParent(SelectionUtil.getSelectedDiagramElements(selection, false));
		} else if (property.equals("singleNamedElementInComponentImplementation")) { // Returns false if there is more than one element or if the element is not
			// a descendant of a component implementation or if the diagram element's BO is not a named element.
			final List<DiagramElement> diagramElements = SelectionUtil.getSelectedDiagramElements(selection, false);
			return diagramElements.size() == 1
					&& ToolUtil.findComponentImplementationBoc(diagramElements.get(0)) != null;
		} else if (property.contentEquals("namedElementsInSameComponentImplementation")) { // Returns false if all selected elements are not descendants of the
			// same component implementation or if any diagram element's BO is not a named element.
			final List<DiagramElement> diagramElements = SelectionUtil.getSelectedDiagramElements(selection, false);

			// Get component implementation ancestor for each named element
			final List<BusinessObjectContext> ciBocs = diagramElements
					.stream().map(de -> ToolUtil.findComponentImplementationBoc(de)).collect(Collectors.toList());

			// Require at least one component implement BOC and the first must be non-null.
			if (ciBocs.size() == 0 || ciBocs.get(0) == null) {
				return false;
			}

			// Require all component implementation BOCs to be equal
			final BusinessObjectContext firstBoc = ciBocs.get(0);
			return ciBocs.stream().allMatch(tmpBoc -> tmpBoc == firstBoc);
		}
		return false;
	}
}
