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
package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.util.ProjectUtil;

public class GoToImplementationDiagramHandler extends AbstractHandler {
	@Override
	public void setEnabled(final Object evaluationContext) {
		boolean enabled = false;
		final List<BusinessObjectContext> selectedBusinessObjectContexts = AgeHandlerUtil
				.getSelectedBusinessObjectContexts();
		if (selectedBusinessObjectContexts.size() == 1) {
			final Object bo = getComponentImplementation(selectedBusinessObjectContexts.get(0).getBusinessObject());
			enabled = bo != null && ProjectUtil.getProjectForBo(bo).isPresent();
		}

		setBaseEnabled(enabled);
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		// Get diagram and selected BOCs
		final List<BusinessObjectContext> selectedBusinessObjectContexts = AgeHandlerUtil
				.getSelectedBusinessObjectContexts();
		if (selectedBusinessObjectContexts.size() == 0) {
			throw new RuntimeException("No element selected");
		}

		final Object bo = selectedBusinessObjectContexts.get(0).getBusinessObject();

		final DiagramService diagramService = Objects.requireNonNull(Adapters.adapt(activeEditor, DiagramService.class),
				"Unable to retrieve diagram service");

		final ComponentImplementation ci = Objects.requireNonNull(getComponentImplementation(bo),
				"Unable to retrieve component implementation");
		diagramService.openOrCreateDiagramForBusinessObject(ci);

		return null;
	}

	private ComponentImplementation getComponentImplementation(final Object bo) {
		if(bo instanceof ComponentImplementation) {
			return (ComponentImplementation) bo;
		} else if(bo instanceof Subcomponent) {
			return ((Subcomponent) bo).getComponentImplementation();
		} else if (bo instanceof ComponentInstance) {
			return getComponentImplementation(((ComponentInstance) bo).getComponentClassifier());
		} else {
			return null;
		}
	}
}
