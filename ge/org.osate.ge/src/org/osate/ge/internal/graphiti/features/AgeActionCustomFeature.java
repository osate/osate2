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
package org.osate.ge.internal.graphiti.features;

import java.util.Objects;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.AgeAction;

/**
 * Custom feature for wrapping an AgeAction into a Graphiti feature. This is needed to avoid accessing Graphiti's command stack directly.
 *
 */
public class AgeActionCustomFeature extends AbstractCustomFeature
{
	private final ActionExecutor actionExecutor;
	private final String label;
	private final AgeAction action;
	private boolean executeResult;

	public AgeActionCustomFeature(final ActionExecutor actionExecutor, final String label, final AgeAction action,
			final IFeatureProvider fp) {
		super(fp);
		this.actionExecutor = Objects.requireNonNull(actionExecutor, "actionExecutor must not be null");
		this.label = Objects.requireNonNull(label, "label must not be null");
		this.action = Objects.requireNonNull(action, "action must not be null");
	}


	@Override
	public String getName() {
		return label;
	}

	@Override
	public boolean isAvailable(final IContext context) {
		return true;
	}

	@Override
	public boolean canExecute(final ICustomContext context) {
		return action.canExecute();
	}

	@Override
	public void execute(final ICustomContext context) {
		executeResult = actionExecutor.execute(label, ActionExecutor.ExecutionMode.NORMAL, action);
	}

	/**
	 *
	 * @return the return value of the ActionExecutor.execute() call.
	 */
	public boolean getExecuteResult() {
		return executeResult;
	}

	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}

	@Override
	public boolean hasDoneChanges() {
		return true;
	}
}
