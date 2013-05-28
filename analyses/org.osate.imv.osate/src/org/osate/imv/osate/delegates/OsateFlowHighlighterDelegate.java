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

package org.osate.imv.osate.delegates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Mode;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.imv.aadldiagram.adapters.IAadlElementAdapter;
import org.osate.imv.aadldiagram.providers.FlowHighlighterDelegate;
import org.osate.imv.model.FlowHighlighter;
import org.osate.imv.model.ModeManager;


public class OsateFlowHighlighterDelegate implements FlowHighlighterDelegate {

	private Mode currentMode;
	private List<FlowHighlighter> highlighters;

	public OsateFlowHighlighterDelegate() {
		// Do nothing.
	}

	public Mode getCurrentMode() {
		return currentMode;
	}

	public void setCurrentMode(Mode currentMode) {
		this.currentMode = currentMode;
	}

	public List<FlowHighlighter> getHighlighters() {
		return highlighters;
	}

	public void setHighlighters(List<FlowHighlighter> highlighters) {
		this.highlighters = highlighters;
	}

	@Override
	public void highlightFigure(IAadlElementAdapter adapter, Object containerElement) {
		boolean highlighterFound = false;
		Object modelElement = adapter.getModelElement();
		List<FlowHighlighter> highlightersForElement = new ArrayList<FlowHighlighter>();

		if(highlighters == null || currentMode == null)
			return;

		for (FlowHighlighter highlighter : highlighters) {
			FlowImplementation flowImpl = highlighter.getFlowImpl();
			EndToEndFlow etef = highlighter.getETEF();
			if (flowImpl != null){
				List<Object> flowElements = getFlowElements(containerElement, flowImpl);
				if (flowElements.contains(modelElement)) {
					highlighterFound = true;
					if (existsInCurrentMode(flowImpl) && highlighter.isHighlight()) {
						// The element is part of a flow.
						highlightersForElement.add(highlighter);
					}
				}
			}
			if (etef != null){
				List<Object> flowElements = getFlowElements(containerElement, etef);
				if (flowElements.contains(modelElement)) {
					highlighterFound = true;
					if (existsInCurrentMode(etef) && highlighter.isHighlight()) {
						// The element is part of a flow.
						highlightersForElement.add(highlighter);
					}
				}
			}
		}

		if(highlighterFound) {
			if(highlightersForElement.isEmpty())
				adapter.highlight(false, null);
			else if(highlightersForElement.size() > 1)
				adapter.highlight(true, ColorConstants.red);
			else
				adapter.highlight(true, highlightersForElement.get(0).getColor());
		}
	}

	protected boolean existsInCurrentMode(FlowImplementation flowImpl) {
		boolean retValue = false;
		boolean prevEDeliver = flowImpl.eDeliver();
		flowImpl.eSetDeliver(false);

		List<Mode> inModesList = flowImpl.getInModes();

		// The flow will be visible if ALL_MODES is the current mode, or if the selected flow does not have a
		// a mode assignment (i.e. it exists in all modes).
		if (this.currentMode == ModeManager.ALL_MODES || inModesList.isEmpty()) {
			retValue = true;
		} else {

			for (Iterator<Mode> modes = inModesList.iterator(); modes.hasNext();) {
				Mode mode = modes.next();
				if (this.currentMode.equals(mode)) {
					retValue = true;
					break;
				}
			}
		}

		flowImpl.eSetDeliver(prevEDeliver);

		return retValue;
	}

	protected boolean existsInCurrentMode(EndToEndFlow etef ) {
		boolean retValue = false;
		boolean prevEDeliver = etef.eDeliver();
		etef.eSetDeliver(false);

		List<Mode> inModesList = etef.getInModes();

		// The flow will be visible if ALL_MODES is the current mode, or if the selected flow does not have a
		// a mode assignment (i.e. it exists in all modes).
		if (this.currentMode == ModeManager.ALL_MODES || inModesList.isEmpty()) {
			retValue = true;
		} else {

			for (Iterator<Mode> modes = inModesList.iterator(); modes.hasNext();) {
				Mode mode = modes.next();
				if (this.currentMode.equals(mode)) {
					retValue = true;
					break;
				}
			}
		}

		etef.eSetDeliver(prevEDeliver);

		return retValue;
	}

	public List<Object> getFlowElements(Object activeObject, Object flowObject) {
		List<Object> flowElements = new ArrayList<Object>();

		if(activeObject == null || flowObject == null)
			return flowElements; // Return empty list.

		if(//activeObject instanceof ComponentInstance &&
				flowObject instanceof FlowImplementation) {
			FlowImplementation flowImpl = (FlowImplementation)flowObject;

			FlowSpecification flowSpec = flowImpl.getSpecification();
			if (flowSpec.getAllInEnd() != null)
				flowElements.add(flowSpec.getAllInEnd().getFeature());
//				flowElements.add(componentInstance.findFeatureInstance(flowSpec.getAllInEnd().getFeature()));
			if (flowSpec.getAllOutEnd() != null)
				flowElements.add(flowSpec.getAllOutEnd().getFeature());
//				flowElements.add(componentInstance.findFeatureInstance(flowSpec.getAllOutEnd().getFeature()));

			for (Iterator<FlowSegment> segmentIterator = flowImpl.getOwnedFlowSegments().iterator(); segmentIterator.hasNext();) {
				FlowSegment seg = segmentIterator.next();
				Context context = seg.getContext();

				FlowElement flowEle = seg.getFlowElement();
				if (flowEle instanceof FlowSpecification) {
					if (((FlowSpecification) flowEle).getAllInEnd()!=null){
						flowElements.add( ((FlowSpecification) flowEle).getAllInEnd().getFeature());
//						flowElements.add(featureInstanceForFeature(componentInstance, context, ((FlowSpecification) flowEle).getAllInEnd().getFeature()));
					}
					if (((FlowSpecification) flowEle).getAllOutEnd()!=null){
						flowElements.add(((FlowSpecification) flowEle).getAllOutEnd().getFeature());
//						flowElements.add(featureInstanceForFeature(componentInstance, context, ((FlowSpecification) flowEle).getAllOutEnd().getFeature()));
					}
					// phf: add subflow
					if ( activeObject instanceof ComponentInstance &&
							context instanceof Subcomponent){
//						ComponentInstance ci = componentInstance.findSubcomponentInstance((Subcomponent)context);
						ComponentClassifier cl = ((Subcomponent)context).getAllClassifier();
						if (cl instanceof ComponentImplementation){
							EList<FlowImplementation> fli = ((ComponentImplementation)cl).getAllFlowImplementations();
							for (FlowImplementation flowImplementation : fli) {
								if (flowImplementation.getSpecification() == flowEle){
									List<Object> sublist = getFlowElements(activeObject // was ci
											, flowImplementation);
									flowElements.addAll(sublist);
								}
							}
						}
					}
				} else if(flowEle instanceof Connection) {
					flowElements.add(flowEle); // We have found the connection reference associated with the connection object.
//					List<ConnectionInstance> connectionInstances = componentInstance.findConnectionInstance((Connection)flowEle);
//					for(Iterator<ConnectionInstance> connectionIterator = connectionInstances.iterator(); connectionIterator.hasNext();) {
//						ConnectionInstance connInstance = connectionIterator.next();
//						for(Iterator<ConnectionReference> referenceIterator = connInstance.getConnectionReferences().iterator(); referenceIterator.hasNext();) {
//							ConnectionReference connRef = referenceIterator.next();
//							if(connRef.getConnection().equals(flowEle)) {
//								flowElements.add(connRef); // We have found the connection reference associated with the connection object.
//							}
//						}
//					}
				} else if(flowEle instanceof Subcomponent) {
					flowElements.add((Subcomponent)flowEle);
//					flowElements.add(componentInstance.findSubcomponentInstance((Subcomponent)flowEle));
				} else if(flowEle instanceof DataAccess) {
					flowElements.add( (Feature)flowEle);
//					flowElements.add(featureInstanceForFeature(componentInstance, context, (Feature)flowEle));
				} else {
					System.err.println("Unrecognized flow element: " + flowEle);
				}
			}
		} else
		if(//activeObject instanceof ComponentInstance &&
				flowObject instanceof EndToEndFlow) {
			EndToEndFlow etef = (EndToEndFlow)flowObject;


			for (Iterator<EndToEndFlowSegment> segmentIterator = etef.getOwnedEndToEndFlowSegments().iterator(); segmentIterator.hasNext();) {
				EndToEndFlowSegment seg = segmentIterator.next();
				Context context = seg.getContext();

				EndToEndFlowElement flowEle = seg.getFlowElement();
				if (flowEle instanceof FlowSpecification) {
					if (((FlowSpecification) flowEle).getAllInEnd()!=null)
						flowElements.add( ((FlowSpecification) flowEle).getAllInEnd().getFeature());
//					flowElements.add(featureInstanceForFeature(componentInstance, context, ((FlowSpecification) flowEle).getAllInEnd().getFeature()));
					if (((FlowSpecification) flowEle).getAllOutEnd()!=null)
						flowElements.add(((FlowSpecification) flowEle).getAllOutEnd().getFeature());
//					flowElements.add(featureInstanceForFeature(componentInstance, context, ((FlowSpecification) flowEle).getAllOutEnd().getFeature()));
					// phf: add subflow
					if ( activeObject instanceof ComponentInstance &&
							context instanceof Subcomponent){
//						ComponentInstance ci = componentInstance.findSubcomponentInstance((Subcomponent)context);
						ComponentClassifier cl = ((Subcomponent)context).getAllClassifier();
						if (cl instanceof ComponentImplementation){
							EList<FlowImplementation> fli = ((ComponentImplementation)cl).getAllFlowImplementations();
							for (FlowImplementation flowImplementation : fli) {
								if (flowImplementation.getSpecification() == flowEle){
									List<Object> sublist = getFlowElements(activeObject // was ci
											, flowImplementation);
									flowElements.addAll(sublist);
								}
							}
						}
					}
				} else if(flowEle instanceof Connection) {
					flowElements.add(flowEle); // We have found the connection reference associated with the connection object.
//					List<ConnectionInstance> connectionInstances = componentInstance.findConnectionInstance((Connection)flowEle);
//					for(Iterator<ConnectionInstance> connectionIterator = connectionInstances.iterator(); connectionIterator.hasNext();) {
//						ConnectionInstance connInstance = connectionIterator.next();
//						for(Iterator<ConnectionReference> referenceIterator = connInstance.getConnectionReferences().iterator(); referenceIterator.hasNext();) {
//							ConnectionReference connRef = referenceIterator.next();
//							if(connRef.getConnection().equals(flowEle)) {
//								flowElements.add(connRef); // We have found the connection reference associated with the connection object.
//							}
//						}
//					}
				} else if(flowEle instanceof Subcomponent) {
					flowElements.add((Subcomponent)flowEle);
//					flowElements.add(componentInstance.findSubcomponentInstance((Subcomponent)flowEle));
				} else if(flowEle instanceof DataAccess) {
					flowElements.add( (Feature)flowEle);
//					flowElements.add(featureInstanceForFeature(componentInstance, context, (Feature)flowEle));
				} else {
					System.err.println("Unrecognized flow element: " + flowEle);
				}
			}
		}


		return flowElements;
	}

//	protected FeatureInstance featureInstanceForFeature(ComponentInstance component, Context context, Feature feature) {
//		FeatureInstance featureInstance = null;
//
//		if (context == null || context instanceof ComponentImplementation) {
//			//lookup feature in the context using the connection src
//			featureInstance = component.findFeatureInstance(feature);
//		} else if (context instanceof Subcomponent) {
//			//lookup feature in the subcomponent
//			featureInstance = component.findSubcomponentInstance((Subcomponent) context).findFeatureInstance(
//					feature);
//		}
//
//		return featureInstance;
//	}
}
