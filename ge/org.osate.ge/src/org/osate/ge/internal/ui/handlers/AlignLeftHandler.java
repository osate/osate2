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
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.ui.handlers.AlignmentHelper.AlignmentElement;
import org.osate.ge.internal.ui.handlers.AlignmentHelper.HorizontalAxis;
import org.osate.ge.internal.ui.util.UiUtil;

public class AlignLeftHandler extends AbstractHandler {
	private static final AlignmentHelper alignmentHelper = AlignmentHelper.create(new HorizontalAxis());

	// This handler allows for alignment of selected diagram elements that are not docked left or right.
	// Any selected element must not an ancestor of another selected element.
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		final List<AlignmentElement> alignmentElements = selectedDiagramElements.stream()
				.map(de -> new AlignmentElement(de, alignmentHelper.getAxisLocation()))
				.collect(Collectors.toList());

		diagram.modify("Align Left", m -> {
			final AlignmentElement primaryAlignmentElement = Objects.requireNonNull(
					AlignmentHelper.getPrimaryAlignmentElement(alignmentElements), "primary element must not be null");
			for (final AlignmentElement alignmentElement : alignmentElements) {
				alignmentHelper.alignElement(m, alignmentElement,
						primaryAlignmentElement.getAbsoluteLocation(),
						0);
			}
		});

		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(alignmentHelper.getEnabled());
	}
}
