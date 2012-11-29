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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;


public class FlowManager {

	public static final NamedElement NO_CONTAINER_COMPONENT = null;

	private NamedElement containerComponent = NO_CONTAINER_COMPONENT;

	private AadlPackage containerPackage = null;

	private Map<NamedElement, List<FlowHighlighter>> flowImplMap;

	public FlowManager() {
		flowImplMap = new HashMap<NamedElement, List<FlowHighlighter>>();
	}

	public void clearCache() {
		flowImplMap.clear();
	}

	public void setContainerComponent(NamedElement containerComponent) {
		this.containerComponent = containerComponent;
	}

	public void setContainerPackage(AadlPackage pkg) {
		this.containerPackage = pkg;
	}

	public List<FlowHighlighter> getFlowHighlighters() {
		if(this.containerComponent == NO_CONTAINER_COMPONENT)
			return new ArrayList<FlowHighlighter>(0); // Return empty list.

		List<FlowHighlighter> highlighters = flowImplMap.get(this.containerComponent);
		if(highlighters == null) {
			highlighters = createFlowHighlighters(this.containerComponent);
			flowImplMap.put(this.containerComponent, highlighters);
		}
		return highlighters;
	}

	protected List<FlowHighlighter> createFlowHighlighters(NamedElement element) {
		List<FlowHighlighter> highlighters = new ArrayList<FlowHighlighter>();
		ComponentClassifier cl = element instanceof ComponentInstance? ((ComponentInstance)element).getComponentClassifier():(ComponentImplementation) element;
		ComponentImplementation componentImpl = cl instanceof ComponentImplementation?(ComponentImplementation) cl : null;//this.getComponentImpl(instance);
		if (componentImpl != null) {
			List<FlowImplementation> flowImplementations = componentImpl.getAllFlowImplementations();
			for (Iterator<FlowImplementation> it = flowImplementations.iterator(); it.hasNext();) {
				FlowImplementation flowImpl = it.next();
				// Create flow highlighter and add it to the list.
				highlighters.add(createFlowHighlighter(flowImpl));
			}
			List<EndToEndFlow> etefs = componentImpl.getAllEndToEndFlows();
			for (Iterator<EndToEndFlow> it = etefs.iterator(); it.hasNext();) {
				EndToEndFlow etefImpl = it.next();
				// Create flow highlighter and add it to the list.
				highlighters.add(createFlowHighlighter(etefImpl));
			}
//			// phf add flows from inner components to selectable list
//			EList<ComponentInstance> children = instance.getComponentInstances();
//			for (ComponentInstance componentInstance : children) {
//				List<FlowHighlighter> chflows = createFlowHighlighters(componentInstance);
//				highlighters.addAll(chflows);
//			}
		}

		return highlighters;
	}

	protected FlowHighlighter createFlowHighlighter(FlowImplementation flowImpl) {
		return new FlowHighlighter(flowImpl);
	}

	protected FlowHighlighter createFlowHighlighter(EndToEndFlow etef) {
		return new FlowHighlighter(etef);
	}
//
//	private ComponentImplementation getComponentImpl(ComponentInstance instance) {
//		ComponentImplementation retComp = null;
//		List<? extends NamedElement> instantiatedElements = containerComponent.getInstantiatedObjects();
//		if(instantiatedElements.size() >= 1) {
//			NamedElement e = instantiatedElements.get(0);
//			if(e instanceof ComponentImplementation) {
//				retComp = (ComponentImplementation)e;
//			} else if(e instanceof Subcomponent) {
//				retComp = ((Subcomponent)e).getComponentImplementation();
//			}
//		}
//		return retComp;
//	}
}
