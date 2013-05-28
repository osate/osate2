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

package org.osate.imv.persistence;

import java.util.Iterator;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.osate.aadl2.NamedElement;
import org.osate.imv.aadldiagram.AadlDiagram;
import org.osate.imv.aadldiagram.aadlfigures.components.ComponentFigure;
import org.osate.imv.aadldiagram.aadlfigures.features.FeatureFigure;
import org.osate.imv.aadldiagram.adapters.AadlComponentAdapter;
import org.osate.imv.aadldiagram.adapters.AadlConnectionAdapter;
import org.osate.imv.aadldiagram.adapters.AadlFeatureAdapter;
import org.osate.imv.aadldiagram.viewer.IAadlAdapterSaverDelegate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XmlAadlAdapterSaverDelegate implements IAadlAdapterSaverDelegate {

	public static final int COMPONENT_FIGURE_TYPE = 0;
	public static final int FEATURE_FIGURE_TYPE = 1;
	public static final int CONNECTION_FIGURE_TYPE = 2;

	private Document xmlDoc;

	public XmlAadlAdapterSaverDelegate(Document xmlDoc) {
		this.xmlDoc = xmlDoc;
	}

	@Override
	public void saveDiagram(AadlDiagram diagram) {
		// TODO save the diagrams current scale so that is can be restored.
	}

	@Override
	public void saveRootAdapter(AadlComponentAdapter rootAdapter) {
		String name = ((NamedElement)rootAdapter.getModelElement()).getFullName();
		// Get root xml element.
		Element rootElement = xmlDoc.getDocumentElement();

		// Check if container element already exists.
		NodeList nList = rootElement.getChildNodes();
		for(int i = 0; i < nList.getLength(); i++) {
			Node node = nList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element)node;
				if(element.getAttribute("name").equals(name)) {
					// The container element already exists so we will remove it.
					rootElement.removeChild(element);
					break;
				}
			}
		}

		writeAdapter(rootAdapter, rootElement);
	}

	private void writeAdapter(AadlComponentAdapter adapter, Element parentElement) {
		Element e = xmlDoc.createElement("element");

		e.setAttribute("type", Integer.toString(COMPONENT_FIGURE_TYPE));
		e.setAttribute("name", ((NamedElement)adapter.getModelElement()).getFullName());

		ComponentFigure figure = adapter.getFigure();

		// Get bounds.
		Rectangle bounds = figure.getBounds();

		// Set x and y attributes.
		e.setAttribute("x", Integer.toString(bounds.x));
		e.setAttribute("y", Integer.toString(bounds.y));

		// Set width and height attributes.
		e.setAttribute("width", Integer.toString(bounds.width));
		e.setAttribute("height", Integer.toString(bounds.height));

		Element childrenElement = xmlDoc.createElement("children");

		// Save subcomopnents.
		for(Iterator<AadlComponentAdapter> it = adapter.getChildComponents(); it.hasNext();)
			this.writeAdapter(it.next(), childrenElement);
		// Save features.
		for(Iterator<AadlFeatureAdapter> it = adapter.getChildFeatures(); it.hasNext();)
			this.writeAdapter(it.next(), childrenElement);
		// Save connections.
		for(Iterator<AadlConnectionAdapter> it = adapter.getChildConnections(); it.hasNext();)
			this.writeAdapter(it.next(), childrenElement);

		e.appendChild(childrenElement);
		parentElement.appendChild(e);
	}

	private void writeAdapter(AadlFeatureAdapter adapter, Element parentElement) {
		Element e = xmlDoc.createElement("element");

		e.setAttribute("type", Integer.toString(FEATURE_FIGURE_TYPE));
		e.setAttribute("name", ((NamedElement)adapter.getModelElement()).getFullName());

		FeatureFigure figure = adapter.getFigure();

		// Get bounds.
		Rectangle bounds = figure.getBounds();

		// Set x and y attributes.
		e.setAttribute("x", Integer.toString(bounds.x));
		e.setAttribute("y", Integer.toString(bounds.y));

		// Set width and height attributes.
		e.setAttribute("width", Integer.toString(bounds.width));
		e.setAttribute("height", Integer.toString(bounds.height));

		// Set the orientation attribute if this is a feature figure.
		e.setAttribute("orientation", Integer.toString(figure.getOrientation().getValue()));

		parentElement.appendChild(e);
	}

	private void writeAdapter(AadlConnectionAdapter adapter, Element parentElement) {
		Element e = xmlDoc.createElement("element");

		e.setAttribute("type", Integer.toString(CONNECTION_FIGURE_TYPE));
		e.setAttribute("name", ((NamedElement)adapter.getModelElement()).getFullName());

		Connection figure = adapter.getFigure();

		// Get point list.
		PointList points = figure.getPoints();
		for(int i = 0; i < points.size(); i++) {
			Point p = points.getPoint(i);
			Element pointElement = xmlDoc.createElement("point");
			pointElement.setAttribute("x", Integer.toString(p.x));
			pointElement.setAttribute("y", Integer.toString(p.y));
			// Append point element.
			e.appendChild(pointElement);
		}

		parentElement.appendChild(e);
	}

}
