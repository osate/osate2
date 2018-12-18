/*******************************************************************************
 * Copyright (c) 2009 EclipseSource Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     EclipseSource Corporation - initial API and implementation
 *******************************************************************************/
package org.osate.ui.projectvisualization;

public class CurrentError extends ErrorReporting {

	ErrorReporting currentError;
	public CurrentError(PluginVisualizationView view, Object bundle, ErrorReporting currentError) {
		super(view, bundle);
		this.currentError = currentError;
	}
	
	public String getErrorMessage() {
		return currentError.getErrorMessage() + " (Click here to suppress)" ;
	}

	public void handleError() {
		this.view.handleSuppressError();
	}

}
