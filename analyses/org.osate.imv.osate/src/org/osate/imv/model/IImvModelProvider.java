/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.model;

import java.beans.PropertyChangeListener;
import java.util.List;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.FeatureCategory;

public interface IImvModelProvider {
	public static final String CURRENT_MODE_PROPERTY = "currentMode";
	public static final String CONTAINER_COMPONENT_PROPERTY = "containerComponent";
	public Mode getCurrentMode();
	public void setCurrentMode(Mode mode);
	public NamedElement getContainerComponent();
	public void setContainerComponent(NamedElement container);
	public List<FlowHighlighter> getFlowHighlighters();
	public List<ElementInhibitStatus<FeatureCategory>> getFeatureInhibitList();
	public List<ElementInhibitStatus<ComponentCategory>> getComponentInhibitList();
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);
	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);
	public void dispose();
}
