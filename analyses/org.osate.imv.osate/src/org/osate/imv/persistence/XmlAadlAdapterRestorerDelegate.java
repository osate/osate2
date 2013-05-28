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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.osate.aadl2.NamedElement;
import org.osate.imv.aadldiagram.AadlDiagram;
import org.osate.imv.aadldiagram.aadlfigures.components.ComponentConnectionAnchor;
import org.osate.imv.aadldiagram.aadlfigures.components.ComponentFigure;
import org.osate.imv.aadldiagram.aadlfigures.features.FeatureFigure;
import org.osate.imv.aadldiagram.aadlfigures.features.FeatureOrientation;
import org.osate.imv.aadldiagram.adapters.AadlComponentAdapter;
import org.osate.imv.aadldiagram.adapters.AadlConnectionAdapter;
import org.osate.imv.aadldiagram.adapters.AadlFeatureAdapter;
import org.osate.imv.aadldiagram.draw2d.BendpointHelper;
import org.osate.imv.aadldiagram.draw2d.SelectableMevConnectionFigure;
import org.osate.imv.aadldiagram.viewer.IAadlAdapterRestorerDelegate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class XmlAadlAdapterRestorerDelegate implements IAadlAdapterRestorerDelegate {

	private Document xmlDoc;
	private AadlDiagram diagram;

	public XmlAadlAdapterRestorerDelegate(Document xmlDoc) {
		this.xmlDoc = xmlDoc;
	}

	@Override
	public void restoreDiagram(AadlDiagram diagram) {
		this.diagram = diagram;
		// TODO restore diagram scale.
	}

	@Override
	public void restoreAadlComponentAdapter(AadlComponentAdapter adapter) {
		Element xmlElement = this.getElementFromObject(adapter.getModelElement(), XmlAadlAdapterSaverDelegate.COMPONENT_FIGURE_TYPE);
		if (xmlElement != null) {
			Rectangle constraint = this.getRect(xmlElement);

			ComponentFigure figure = adapter.getFigure();
			IFigure parent = figure.getParent();
			if (parent != null && constraint != null) {
				figure.setBounds(constraint.getCopy());
				// We need to store the relative bounds.
				Rectangle parentBounds = parent.getBounds();
				parent.getLayoutManager().setConstraint(figure, constraint.setLocation(constraint.x - parentBounds.x, constraint.y - parentBounds.y));
			}
		}
	}

	@Override
	public void restoreAadlFeatureAdapter(AadlFeatureAdapter adapter) {
		Element xmlElement = this.getElementFromObject(adapter.getModelElement(), XmlAadlAdapterSaverDelegate.FEATURE_FIGURE_TYPE);
		if (xmlElement != null) {
			Rectangle constraint = this.getRect(xmlElement);

			FeatureFigure figure = adapter.getFigure();
			IFigure parent = figure.getParent();
			if (parent != null && constraint != null) {
				figure.setBounds(constraint.getCopy());
				// We need to store the relative bounds.
				Rectangle parentBounds = parent.getBounds();
				parent.getLayoutManager().setConstraint(figure, constraint.setLocation(constraint.x - parentBounds.x, constraint.y - parentBounds.y));
			}

			// Restore feature orientation.
			figure.setOrientation(this.getOrientation(xmlElement));
		}
	}

	@Override
	public void restoreAadlConnectionAdapter(AadlConnectionAdapter adapter) {
		Element xmlElement = this.getElementFromObject(adapter.getModelElement(), XmlAadlAdapterSaverDelegate.CONNECTION_FIGURE_TYPE);
		if (xmlElement != null) {
			PointList points = this.getPointList(xmlElement);
			SelectableMevConnectionFigure figure = adapter.getFigure();
			figure.setPoints(points);

			Point start = points.getFirstPoint();
			Point last = points.getLastPoint();

			ConnectionAnchor srcAnchor = figure.getSourceAnchor();
			if(srcAnchor instanceof ComponentConnectionAnchor)
				((ComponentConnectionAnchor)srcAnchor).setInitialAbsoluteLocation(start);
			ConnectionAnchor targetAnchor = figure.getTargetAnchor();
			if(targetAnchor instanceof ComponentConnectionAnchor)
				((ComponentConnectionAnchor)targetAnchor).setInitialAbsoluteLocation(last);

			List<Bendpoint> bendpointList = new ArrayList<Bendpoint>(points.size() - 2);

			// Restore bendbpoints.
			for(int i = 1; i < points.size() - 1; i++) {
				Point p = points.getPoint(i);
				RelativeBendpoint bp = BendpointHelper.calculateRelativeBendpoint(p, start, last, figure);
				bendpointList.add(bp);
			}

			ConnectionRouter router = figure.getConnectionRouter();
			router.setConstraint(figure, bendpointList);
		}
	}

	public Element getElementFromObject(Object element, int type) {
		Element retElement = null;

		Element containerElement = getContainerElement();
		if(containerElement != null) {
			NamedElement namedElement = (NamedElement)element;

			if(type == XmlAadlAdapterSaverDelegate.COMPONENT_FIGURE_TYPE || type ==  XmlAadlAdapterSaverDelegate.FEATURE_FIGURE_TYPE) {
				NamedElement parentElement = (NamedElement)namedElement.getOwner();
				if(parentElement == null || namedElement.getFullName().equals(containerElement.getAttribute("name"))) {
					retElement = containerElement;
				} else if(parentElement.getFullName().equals(containerElement.getAttribute("name"))) {
					retElement = getChildElementByName(namedElement.getFullName(), containerElement, type);
				} else {
					Element newParentElement = getChildElementByName(parentElement.getFullName(), containerElement, XmlAadlAdapterSaverDelegate.COMPONENT_FIGURE_TYPE);
					if(newParentElement != null) {
						retElement = getChildElementByName(namedElement.getFullName(), newParentElement, type);
					}
				}
			} else if(type == XmlAadlAdapterSaverDelegate.CONNECTION_FIGURE_TYPE) {
				retElement = getChildElementByName(namedElement.getFullName(), containerElement, type);
			}
		}

		return retElement;
	}

	private Element getContainerElement() {
		Element retElement = null;
		Element rootElement = xmlDoc.getDocumentElement();

		String name = ((NamedElement)this.diagram.getRootModelElement()).getFullName();

		NodeList nList = rootElement.getChildNodes();
		for(int i = 0; i < nList.getLength(); i++) {
			Node node = nList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element)node;
				if(element.getAttribute("name").equals(name)) {
					// We have found the container element.
					retElement = element;
					break;
				}
			}
		}

		return retElement;
	}

	private Element getChildElementByName(String name, Element parentElement, int type) {
		Element retElement = null;

		NodeList nList = parentElement.getElementsByTagName("children").item(0).getChildNodes();
		for(int i = 0; i < nList.getLength(); i++) {
			Node node = nList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element)node;
				if(element.getAttribute("name").equals(name) && getElementType(element) == type) {
					// We have found a matching element.
					retElement = element;
					break;
				}
			}
		}

		return retElement;
	}

	public PointList getPointList(Element element) {
		PointList points = new PointList();
		NodeList nodes = element.getElementsByTagName("point");
		for(int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element pointElement = (Element)node;
				Point p = new Point();
				p.x = Integer.parseInt(pointElement.getAttribute("x"));
				p.y = Integer.parseInt(pointElement.getAttribute("y"));
				points.addPoint(p);
			}
		}
		return points;
	}

	public Rectangle getRect(Element element) {
		int x = Integer.parseInt(element.getAttribute("x"));
		int y = Integer.parseInt(element.getAttribute("y"));
		int w = Integer.parseInt(element.getAttribute("width"));
		int h = Integer.parseInt(element.getAttribute("height"));

		return new Rectangle(x, y, w, h);
	}

	public FeatureOrientation getOrientation(Element element) {
		int value = Integer.parseInt(element.getAttribute("orientation"));
		return FeatureOrientation.get(value);
	}

	public int getElementType(Element element) {
		return Integer.parseInt(element.getAttribute("type"));
	}
}
