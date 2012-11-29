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
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.imv.aadldiagram.viewer.AadlDiagramViewer;
import org.osate.imv.model.ElementInhibitStatus;


public class FeatureFilter extends ViewerFilter implements PropertyChangeListener {

	private Map<FeatureCategory, Boolean> featureMap;

	private AadlDiagramViewer viewer;

	public FeatureFilter(List<ElementInhibitStatus<FeatureCategory>> featureInhibitList, AadlDiagramViewer viewer){
		this.viewer = viewer;
		populateFeatureMap(featureInhibitList);
	}

	public void inhibitFeatureCategory(FeatureCategory category, boolean inhibit){
		synchronized(featureMap){
			featureMap.put(category, inhibit);
		}
	}

	protected void populateFeatureMap(List<ElementInhibitStatus<FeatureCategory>> featureInhibitList){
		// Create map to store key/value pairs consisting of a feature category an a boolean value indicating
		// if the feature should be visible.
		featureMap = new HashMap<FeatureCategory, Boolean>();

		synchronized(featureMap){
			// Populate map with feature categories. All features will initially be visible.
			for(Iterator<ElementInhibitStatus<FeatureCategory>> it = featureInhibitList.iterator(); it.hasNext();){
				ElementInhibitStatus<FeatureCategory> inhibitStatus = it.next();
				// Register for property change events.
				inhibitStatus.addPropertyChangeListener(ElementInhibitStatus.INHIBIT_PROPERTY, this);
				// Add to map.
				featureMap.put(inhibitStatus.getCategory(), inhibitStatus.isInhibited()); // Uses auto-boxing.
			}
		}
	}

	protected boolean isFeatureVisible(NamedElement feature){
		Boolean inhibit = null;

		FeatureCategory category = feature instanceof FeatureInstance?((FeatureInstance)feature).getCategory():getCategory((Feature)feature);
		synchronized(featureMap){
			inhibit = featureMap.get(category);
		}
		if(inhibit == null)
			inhibit = false; // Should never happen.

		return !inhibit.booleanValue();
	}

	protected FeatureCategory getCategory(Feature feature){
		if (feature instanceof DataPort) return FeatureCategory.DATA_PORT;
		if (feature instanceof EventDataPort) return FeatureCategory.EVENT_DATA_PORT;
		if (feature instanceof EventPort) return FeatureCategory.EVENT_PORT;
		if (feature instanceof Parameter) return FeatureCategory.PARAMETER;
		if (feature instanceof DataAccess) return FeatureCategory.DATA_ACCESS;
		if (feature instanceof BusAccess) return FeatureCategory.BUS_ACCESS;
		if (feature instanceof SubprogramAccess) return FeatureCategory.SUBPROGRAM_ACCESS;
		if (feature instanceof SubprogramGroupAccess) return FeatureCategory.SUBPROGRAM_GROUP_ACCESS;
		if (feature instanceof FeatureGroup) return FeatureCategory.FEATURE_GROUP;
		if (feature instanceof AbstractFeature) return FeatureCategory.ABSTRACT_FEATURE;
		return null;
	}



	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		boolean displayElement = true;
		// If the parent element is equal to the input element, then the feature will always be
		// displayed to provide context to the user.
		if(parentElement != null && viewer.getInput() != parentElement){
			if(element instanceof FeatureInstance)
				displayElement = isFeatureVisible((NamedElement)element);
		}

		return displayElement;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		String property = event.getPropertyName();
		if(property.equals(ElementInhibitStatus.INHIBIT_PROPERTY)){
			Object source = event.getSource();
			if(source instanceof ElementInhibitStatus) {
				ElementInhibitStatus<FeatureCategory> inhibitStatus = (ElementInhibitStatus<FeatureCategory>) source;
				inhibitFeatureCategory(inhibitStatus.getCategory(), inhibitStatus.isInhibited());
				viewer.runFilters();
			}
		}
	}

}
