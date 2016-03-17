/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.editor;

import org.eclipse.ui.actions.LabelRetargetAction;
import org.osate.ge.internal.util.ExtensionUtil;

/**
 * Action to activate a tool provided by the tool service
 *
 */
public class ActivateToolRetargetAction extends LabelRetargetAction {
	public ActivateToolRetargetAction(final Object tool) {
		super(ExtensionUtil.getId(tool), ExtensionUtil.getDescription(tool));
		setHoverImageDescriptor(ExtensionUtil.getIcon(tool));
	}
}
