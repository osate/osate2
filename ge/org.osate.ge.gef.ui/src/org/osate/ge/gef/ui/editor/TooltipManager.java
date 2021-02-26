/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.gef.ui.editor;

import java.util.Objects;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.ui.TooltipContributor;
import org.osate.ge.ui.TooltipContributorContext;

// TODO: Rename
public class TooltipManager {
	private final ExtensionRegistryService extensionRegistry;
	private Shell tooltipShell = null;
	private DiagramElement tooltipElement = null;
	private double tooltipCursorX = Double.MIN_VALUE;
	private double tooltipCursorY = Double.MIN_VALUE;
	private final int cursorMoveThreshold = 40;

	public TooltipManager(final ExtensionRegistryService extensionRegistry) {
		this.extensionRegistry = Objects.requireNonNull(extensionRegistry, "extensionRegistry must not be null");
	}

	public void mouseEnter(final DiagramElement diagramElement) {
		// TODO: Update stack
	}

	// TODO
	public void mouseExit(final DiagramElement diagramElement) {
		// TODO: Update stack
		disposeCurrentToolTip();
	}

	// TDO: Trigger automatically
	public void mouseHover(final double x, final double y) {
		final DiagramElement hoverElement = null; // TODO: Find the diagram element

		// Only show tooltips if a diagram element was found
		if (hoverElement != null) {
			if (hoverElement != tooltipElement || exceedsCursorMoveThreshold(x, y)) {
				disposeCurrentToolTip();

				if (hoverElement.getBusinessObject() != null) {
					tooltipElement = hoverElement;

					// Create new tooltip shell
					final Display display = Display.getCurrent();
					tooltipShell = new Shell(display.getActiveShell(), SWT.ON_TOP | SWT.TOOL | SWT.CENTER);
					tooltipShell.setVisible(false);
					tooltipShell.setBackground(display.getSystemColor(SWT.COLOR_INFO_BACKGROUND));
					tooltipShell.setBackgroundMode(SWT.INHERIT_FORCE);

					// Configure layout
					final GridLayout tooltipLayout = GridLayoutFactory.fillDefaults().create();
					tooltipLayout.marginLeft = 5;
					tooltipLayout.marginRight = 5;
					tooltipShell.setLayout(tooltipLayout);

					// Call tooltip contributors
					final TooltipContributorContext tooltipContext = new TooltipContributorContext(tooltipShell,
							tooltipElement);
					for (final TooltipContributor tooltipContributor : extensionRegistry.getTooltipContributors()) {
						tooltipContributor.addTooltipContents(tooltipContext);
					}

					// Show tooltip shell if something was contributed
					if (tooltipShell.getChildren().length > 0) {
						// Attempt to restrict the width of widget which are wider than the preferred maximum.
						for (final Control tooltipChild : tooltipShell.getChildren()) {
							final int maxTooltipWidth = 600;
							if (tooltipChild.computeSize(SWT.DEFAULT, SWT.DEFAULT).x > maxTooltipWidth) {
								tooltipChild.setLayoutData(
										GridDataFactory.fillDefaults().hint(maxTooltipWidth, SWT.DEFAULT).create());
							}
						}

						final Point point = display.getCursorLocation();
						tooltipShell.setLocation(point.x, point.y + 20);
						tooltipCursorX = x;
						tooltipCursorY = y;
						tooltipShell.pack(true);
						tooltipShell.setVisible(true);
					}
				}
			}
		}
	}

	// TODO
//	public void mouseMove(final MouseEvent e) {
//		final PictogramElement movePe = getPictogramElementByControlCoordinates(e.x, e.y);
//		final DiagramElement moveElement = movePe == null ? null : graphitiAgeDiagram.getClosestDiagramElement(movePe);
//		if (tooltipShell != null && (movePe instanceof Diagram || moveElement != tooltipElement
//				|| exceedsCursorMoveThreshold(e.x, e.y))) {
//			disposeCurrentToolTip();
//		}
//	}

	private void disposeCurrentToolTip() {
		if (tooltipShell != null) {
			tooltipShell.dispose();
		}

		tooltipShell = null;
		tooltipElement = null;
		tooltipCursorX = Integer.MIN_VALUE;
		tooltipCursorY = Integer.MIN_VALUE;
	}

	private boolean exceedsCursorMoveThreshold(final double cursorX, final double cursorY) {
		return (Math.abs(cursorX - tooltipCursorX) + Math.abs(cursorY - tooltipCursorY)) >= cursorMoveThreshold;
	}

	// TODO
//	@Override
//	public void partClosed(final IWorkbenchPart part) {
//		if (part == editor) {
//			disposeCurrentToolTip();
//
//			// Unregister listeners
//			if (editor.getGraphicalViewer() != null && editor.getGraphicalViewer().getControl() != null) {
//				editor.getGraphicalViewer().getControl().removeMouseMoveListener(this);
//				editor.getGraphicalViewer().getControl().removeMouseTrackListener(this);
//			}
//
//			if (editor.getSite() != null && editor.getSite().getWorkbenchWindow() != null
//					&& editor.getSite().getWorkbenchWindow().getPartService() != null) {
//				editor.getSite().getWorkbenchWindow().getPartService().removePartListener(this);
//			}
//		}
//	}

	// TODO
//	@Override
//	public void partDeactivated(final IWorkbenchPart part) {
//		if (part == editor) {
//			disposeCurrentToolTip();
//		}
//	}

}
