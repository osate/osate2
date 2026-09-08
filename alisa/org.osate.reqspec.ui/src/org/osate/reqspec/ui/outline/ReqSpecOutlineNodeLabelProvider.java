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
package org.osate.reqspec.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeLabelProvider;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.util.CommonUtilExtension;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.ReqSpec;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.StakeholderGoals;
import org.osate.reqspec.reqSpec.SystemRequirementSet;

import com.google.inject.Inject;

public class ReqSpecOutlineNodeLabelProvider extends OutlineNodeLabelProvider {
	@Inject
	public ReqSpecOutlineNodeLabelProvider(final OutlineNodeLabelProvider.Delegate delegate) {
		super(delegate);
	}

	@Override
	public String getToolTipText(final Object element) {
		if (!(element instanceof EObjectNode node)) {
			return "";
		}
		var elementText = String.valueOf(node.getText());
		var object = new ResourceSetImpl().getEObject(node.getEObjectURI(), true);
		return switch (object) {
		case ReqSpec ignored -> elementText;
		case StakeholderGoals goals -> goals.getName();
		case Goal goal -> {
			var description = "";
			if (goal.getDescription() != null) {
				description = CommonUtilExtension.toText(goal.getDescription(), null);
				if (!description.isEmpty()) {
					description = System.lineSeparator() + " - " + description;
				}
			}
			yield goal.getName() + " - " + goal.getTitle() + description;
		}
		case SystemRequirementSet requirements -> requirements.getName();
		case Requirement requirement -> requirement.getName() + " - " + requirement.getTitle();
		case null, default -> elementText;
		};
	}

	@Override
	public String getText(final Object element) {
		System.out.println("element = " + element);
		var styledText = getStyledText(element);
		if (styledText != null) {
			styledText.toString();
		}
		return null;
	}
}
