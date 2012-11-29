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
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureCategory;

public class ImvModelProvider implements IImvModelProvider {

	private List<ElementInhibitStatus<FeatureCategory>> featureInhibitList;
	private List<ElementInhibitStatus<ComponentCategory>> componentInhibitList;

	private ModeManager modeManager;
	private FlowManager flowManager;

	private NamedElement containerComponent;

	private Mode currentMode;

	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	public ImvModelProvider(ComponentInstance containerComponent) {
		/* Initialize the IMV model. */
		this.containerComponent = containerComponent;
		this.modeManager = new ModeManager();
		this.flowManager = new FlowManager();
		this.currentMode = this.modeManager.getCurrentMode(containerComponent);
		populateFeatureInhibitList();
		populateComponentInhibitList();
	}


	@Override
	public Mode getCurrentMode() {
		return this.currentMode;
	}

	@Override
	public void setCurrentMode(Mode mode) {
		this.modeManager.setCurrentMode(mode, this.containerComponent);
		propertyChangeSupport.firePropertyChange(CURRENT_MODE_PROPERTY, this.currentMode, this.currentMode = mode);
	}

	@Override
	public NamedElement getContainerComponent() {
		return this.containerComponent;
	}

	@Override
	public void setContainerComponent(NamedElement container) {
		this.currentMode = this.modeManager.getCurrentMode(container);
		this.flowManager.setContainerComponent(container);
		propertyChangeSupport.firePropertyChange(CONTAINER_COMPONENT_PROPERTY, this.containerComponent, this.containerComponent = container);
	}

	@Override
	public List<FlowHighlighter> getFlowHighlighters() {
		return this.flowManager.getFlowHighlighters();
	}

	@Override
	public List<ElementInhibitStatus<FeatureCategory>> getFeatureInhibitList(){
		return featureInhibitList;
	}

	@Override
	public List<ElementInhibitStatus<ComponentCategory>> getComponentInhibitList(){
		return componentInhibitList;
	}


	@Override
	public void dispose() {
		// Nothing to dispose of.
	}

	@Override
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	@Override
	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
	}

	private void populateFeatureInhibitList() {
		featureInhibitList = new ArrayList<ElementInhibitStatus<FeatureCategory>>();
		for(Iterator<FeatureCategory> it = FeatureCategory.VALUES.iterator(); it.hasNext();){
			featureInhibitList.add(new ElementInhibitStatus<FeatureCategory>(it.next()));
		}
	}

	private void populateComponentInhibitList() {
		componentInhibitList = new ArrayList<ElementInhibitStatus<ComponentCategory>>();
		for(Iterator<ComponentCategory> it = ComponentCategory.VALUES.iterator(); it.hasNext();){
			componentInhibitList.add(new ElementInhibitStatus<ComponentCategory>(it.next()));
		}
	}

}
