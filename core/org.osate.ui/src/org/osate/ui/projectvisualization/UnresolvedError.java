/*******************************************************************************
 * Copyright 2005-2006, CHISEL Group, University of Victoria, Victoria, BC,
 * Canada. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: The Chisel Group, University of Victoria IBM CAS, IBM Toronto
 * Lab
 ******************************************************************************/
package org.osate.ui.projectvisualization;

public class UnresolvedError extends ErrorReporting {

	public final static String ERROR_MESSAGE = "Unresolved Bundle";

	public UnresolvedError(PluginVisualizationView view) {
		super(view, null);
	}

	/**
	 * Handle the error.  In this case we should filter the nodes that are not part of the problem
	 */
	public void handleError() {
		view.handleUnresolvedDependencyError(this);
	}
	
	public String getErrorMessage() {
		return ERROR_MESSAGE;
	}
}
