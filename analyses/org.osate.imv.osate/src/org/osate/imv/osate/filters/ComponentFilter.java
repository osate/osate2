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

package org.osate.imv.osate.filters;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.imv.aadldiagram.viewer.AadlDiagramViewer;
import org.osate.imv.model.ElementInhibitStatus;


public class ComponentFilter extends ViewerFilter implements PropertyChangeListener {

	private Map<ComponentCategory, Boolean> componentMap;

	private AadlDiagramViewer viewer;

	public ComponentFilter(List<ElementInhibitStatus<ComponentCategory>> componentInhibitList, AadlDiagramViewer viewer){
		this.viewer = viewer;
		populateFeatureMap(componentInhibitList);
	}

	public void inhibitComponentCategory(ComponentCategory category, boolean inhibit){
		synchronized(componentMap){
			componentMap.put(category, inhibit);
		}
	}

	protected void populateFeatureMap(List<ElementInhibitStatus<ComponentCategory>> componentInhibitList){
		// Create map to store key/value pairs consisting of a component category and a boolean value indicating
		// if the component should be visible.
		componentMap = new HashMap<ComponentCategory, Boolean>();

		synchronized(componentMap){
			// Populate map with component categories. All components will initially be visible.
			for(Iterator<ElementInhibitStatus<ComponentCategory>> it = componentInhibitList.iterator(); it.hasNext();){
				ElementInhibitStatus<ComponentCategory> inhibitStatus = it.next();
				// Register for property change events.
				inhibitStatus.addPropertyChangeListener(ElementInhibitStatus.INHIBIT_PROPERTY, this);
				// Add to map.
				componentMap.put(inhibitStatus.getCategory(), inhibitStatus.isInhibited()); // Uses auto-boxing.
			}
		}
	}

	protected boolean isComponentVisible(NamedElement component){
		Boolean inhibit = null;

		ComponentCategory category = component instanceof ComponentInstance?((ComponentInstance)component).getCategory():((ComponentClassifier)component).getCategory();
		synchronized(componentMap){
			inhibit = componentMap.get(category);
		}
		if(inhibit == null)
			inhibit = false; // Should never happen.

		return !inhibit.booleanValue();
	}


	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		boolean displayElement = true;
		// If the parentElement is null, then the element object corresponds to the
		// active figure. The active figure will always be visible so it will not be filtered.
		if(parentElement != null && (element instanceof ComponentInstance|| element instanceof ComponentClassifier)){
			displayElement = isComponentVisible((NamedElement)element);
		}

		return displayElement;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		String property = event.getPropertyName();
		if(property.equals(ElementInhibitStatus.INHIBIT_PROPERTY)){
			Object source = event.getSource();
			if(source instanceof ElementInhibitStatus) {
				ElementInhibitStatus<ComponentCategory> inhibitStatus = (ElementInhibitStatus<ComponentCategory>) source;
				inhibitComponentCategory(inhibitStatus.getCategory(), inhibitStatus.isInhibited());
				viewer.runFilters();
			}
		}
	}
}
