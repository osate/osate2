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
package org.osate.ge.ba.handlers;

import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.DiagramCreationUtil;
import org.osate.ge.ProjectUtil;
import org.osate.ge.ba.diagram.diagramType.BehaviorAnnexDiagramType;
import org.osate.ge.ba.util.SelectionUtil;

public class CreateBehaviorAnnexDiagramHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		// Get diagram and selected BOCs
		final List<BusinessObjectContext> selectedBusinessObjectContexts = SelectionUtil
				.getSelectedBusinessObjectContexts();
		if (selectedBusinessObjectContexts.isEmpty()) {
			throw new RuntimeException("No element selected");
		}

		final BehaviorAnnex behaviorAnnex = (BehaviorAnnex) selectedBusinessObjectContexts.get(0).getBusinessObject();
		final Classifier classifier = Objects.requireNonNull(behaviorAnnex.getContainingClassifier(),
				"Classifier cannot be null");
		final DefaultAnnexSubclause annexSubclause = (DefaultAnnexSubclause) behaviorAnnex.getOwner();


		final StringBuilder fileName = new StringBuilder(classifier.getQualifiedName().replaceAll("::|:|\\.", "_"));
		fileName.append("_");
		fileName.append(classifier.getOwnedAnnexSubclauses().indexOf(annexSubclause));

		DiagramCreationUtil.createDiagram(activeEditor, fileName.toString(), new BehaviorAnnexDiagramType(),
				behaviorAnnex);

		return null;
	}


	@Override
	public void setEnabled(final Object evaluationContext) {
		boolean enabled = false;
		final List<BusinessObjectContext> selectedBusinessObjectContexts = SelectionUtil
				.getSelectedBusinessObjectContexts();
		if (selectedBusinessObjectContexts.size() == 1) {
			final Object bo = selectedBusinessObjectContexts.get(0).getBusinessObject();
			enabled = bo instanceof BehaviorAnnex
					&& ProjectUtil.getProjectForBo(bo).isPresent();
		}

		setBaseEnabled(enabled);
	}
}
