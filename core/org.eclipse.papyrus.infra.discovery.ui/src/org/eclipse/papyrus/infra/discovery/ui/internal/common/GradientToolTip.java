/*******************************************************************************
 * Copyright (c) 2004, 2009 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *     Obeo - adaptation for Amalgamation, EMF based and no Mylyn dependency
 *     CEA LIST - adaptation to Papyrus
 *******************************************************************************/

package org.eclipse.papyrus.infra.discovery.ui.internal.common;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;

/**
 * A Custom JFace ToolTip that applies a gradient to the contents
 *
 * @author Shawn Minto
 * @since 3.2
 */
public abstract class GradientToolTip extends ToolTip {

	private NotificationPopupColors colors;

	private LocalResourceManager resourceManager;

	public GradientToolTip(Control control, int style, boolean manualActivation) {
		super(control, style, manualActivation);
		initResources(control);
	}

	public GradientToolTip(Control control) {
		super(control);
		initResources(control);
	}

	private void initResources(Control control) {
		resourceManager = new LocalResourceManager(JFaceResources.getResources());
		colors = new NotificationPopupColors(control.getDisplay(), resourceManager);
	}

	@Override
	protected final Composite createToolTipContentArea(Event event, final Composite parent) {
		GradientCanvas gradient = new GradientCanvas(parent, SWT.NONE);
		gradient.setSeparatorVisible(false);
		GridLayout headLayout = new GridLayout();
		headLayout.marginHeight = 0;
		headLayout.marginWidth = 0;
		headLayout.horizontalSpacing = 0;
		headLayout.verticalSpacing = 0;
		headLayout.numColumns = 1;
		gradient.setLayout(headLayout);

		gradient.setBackgroundGradient(new Color[] { colors.getGradientBegin(), colors.getGradientEnd() },
				new int[] { 100 }, true);

		createToolTipArea(event, gradient);

		// force a null background so that the gradient shines through
		for (Control c : gradient.getChildren()) {
			setNullBackground(c);
		}

		return gradient;
	}

	private void setNullBackground(final Control outerCircle) {
		outerCircle.setBackground(null);
		if (outerCircle instanceof Composite) {
			((Composite) outerCircle).setBackgroundMode(SWT.INHERIT_FORCE);
			for (Control c : ((Composite) outerCircle).getChildren()) {
				setNullBackground(c);
			}
		}
	}

	protected abstract Composite createToolTipArea(Event event, Composite parent);
}
