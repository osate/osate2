/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil.                                               *
 * Contributions by Peter Feiler and Julien Delange                                 *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.aadldiagram;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.FreeformViewport;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.ScalableFreeformLayeredPane;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.zest.layouts.InvalidLayoutConfiguration;
import org.eclipse.zest.layouts.LayoutEntity;
import org.eclipse.zest.layouts.LayoutRelationship;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.imv.aadldiagram.aadlfigures.components.ComponentFigure;
import org.osate.imv.aadldiagram.adapters.AadlComponentAdapter;
import org.osate.imv.aadldiagram.adapters.AadlConnectionAdapter;
import org.osate.imv.aadldiagram.adapters.AadlFeatureAdapter;
import org.osate.imv.aadldiagram.adapters.IAadlElementAdapter;
import org.osate.imv.aadldiagram.draw2d.BendpointHelper;


public class AadlDiagram extends FigureCanvas {

	public static final IAadlElementAdapter NO_SELECTED_ADAPTER = null;

	public static final float MAX_ZOOM_LEVEL = 2.0f;
	public static final float MIN_ZOOM_LEVEL = 0.5f;

	private static final float SCALE_INCREMENT = 0.20f;

	public static final double DEFAULT_SCALE = 1.0f;

	private IAadlElementAdapter selectedAdapter = NO_SELECTED_ADAPTER;

	private ScalableFreeformLayeredPane scalableFigureLayeredPane;

	private FreeformLayer figureLayer;

	private AadlComponentAdapter rootAdapter;

	private int nestingLevel = 1;
	
	private boolean doDirectConnections = false;

	public AadlDiagram(Composite parent) {
		super(parent, SWT.DOUBLE_BUFFERED);
		setViewport(new FreeformViewport());
		initializeScalableFigureLayer();
		setBackground(ColorConstants.white);
	}

	public void setRootAdapter(AadlComponentAdapter rootAdapter) {
		this.rootAdapter = rootAdapter;
		this.figureLayer.removeAll();
		this.figureLayer.add(rootAdapter.getFigure(), new Rectangle(new Point(0, 0), rootAdapter.getFigure().getPreferredSize()));
	}


	public AadlComponentAdapter getRootAdapter() {
		return this.rootAdapter;
	}

	public void scaleToFit() {
		FreeformViewport viewport = (FreeformViewport)this.scalableFigureLayeredPane.getParent();
		Rectangle viewArea = viewport.getClientArea();
		this.scalableFigureLayeredPane.setScale(1);
		Rectangle extent = this.scalableFigureLayeredPane.getFreeformExtent().union(0, 0);

		double wScale = ((double) viewArea.width) / extent.width;
		double hScale = ((double) viewArea.height) / extent.height;
		double scale = (float) Math.min(wScale, hScale);

		this.scalableFigureLayeredPane.setScale(scale);
	}

	public void setScale(double scale){
		double newScale = 1;
		if(scale >= MIN_ZOOM_LEVEL && scale <= MAX_ZOOM_LEVEL) {
			newScale = scale;
		}else if(scale < MIN_ZOOM_LEVEL) {
			newScale = MIN_ZOOM_LEVEL;
		}else if(scale > MAX_ZOOM_LEVEL) {
			newScale = MAX_ZOOM_LEVEL;
		}

		this.scalableFigureLayeredPane.setScale(newScale);
	}

	public double getScale() {
		return this.scalableFigureLayeredPane.getScale();
	}

	public void incrementScale() {
		this.setScale(this.getScale() + SCALE_INCREMENT);
	}

	public void decrementScale() {
		this.setScale(this.getScale() - SCALE_INCREMENT);
	}

	public void incrementNestingLevel() {
		Object obj = this.getRootModelElement();
		if (obj instanceof ComponentInstance){
			int max = hierarchyDepth((ComponentInstance)obj);
			if (nestingLevel < max ){
				this.nestingLevel++;
			}
		}
	}
	

	public void decrementNestingLevel() {
		if (this.nestingLevel > 1){
			this.nestingLevel--;
		}
	}

//	protected void makeVisible(AadlComponentAdapter compAdapter,int nestingLevel){
//		if (nestingLevel == 0){
//		compAdapter.getFigure().setVisible(true);
//		Iterator<AadlFeatureAdapter> cfit = compAdapter.getChildFeatures();
//		while (cfit.hasNext()){
//			cfit.next().getFigure().setVisible(true);
//		}
//		} else {
//			Iterator<AadlComponentAdapter> cit = compAdapter.getChildComponents();
//			while (cit.hasNext()){
//				AadlComponentAdapter childAdapter = cit.next();
//				makeVisible(childAdapter,nestingLevel-1);
//			}
//		}
//		
//	}

//	protected void makeInvisible(AadlComponentAdapter compAdapter,int nestingLevel){
//		if (nestingLevel == 0){
//			compAdapter.getFigure().setVisible(false);
//			Iterator<AadlFeatureAdapter> cfit = compAdapter.getChildFeatures();
//			while (cfit.hasNext()){
//				cfit.next().getFigure().setVisible(false);
//			}
//		} else {
//			Iterator<AadlComponentAdapter> cit = compAdapter.getChildComponents();
//			while (cit.hasNext()){
//				AadlComponentAdapter childAdapter = cit.next();
//				makeInvisible(childAdapter,nestingLevel-1);
//			}
//		}
//		
//	}


	protected int hierarchyDepth(ComponentInstance ci){
		int result =0;
		EList<ComponentInstance> subcil = ci.getComponentInstances();
		if (!subcil.isEmpty())
			result = 1;
		for (ComponentInstance componentInstance : subcil) {
			int res = hierarchyDepth(componentInstance);
			if (res > result-1) result = res+1;
		}
		return result;
	}

	public int getNestingLevel() {
		return nestingLevel;
	}

	public void resizeToFit() {
		if(this.rootAdapter == null)
			return;
		Point max = Point.SINGLETON;
		max.setLocation(0, 0);
		for(Iterator<AadlComponentAdapter> it = this.rootAdapter.getChildComponents(); it.hasNext();) {
			AadlComponentAdapter compAdapter = it.next();
			Rectangle rect = compAdapter.getFigure().getBounds();
			Point rectBottomRight = rect.getBottomRight();
			Dimension dif = max.getDifference(rectBottomRight);
			if(dif.width < 0) max.x = rectBottomRight.x;
			if(dif.height < 0) max.y = rectBottomRight.y;
			// XXX TODO add flowpaths
//			for (Iterator<AadlFlowPathAdapter> itt = compAdapter.getChildFlowPaths(); it.hasNext();){
//				AadlFlowPathAdapter flowAdapter = itt.next();
//				if(flowAdapter.getSourceAdapter().getParentAdapter().isContainer() || flowAdapter.getDestinationAdapter().getParentAdapter().isContainer())
//					continue;
//				Rectangle flowrect = flowAdapter.getFigure().getBounds();
//				Point flowrectBottomRight = flowrect.getBottomRight();
//				Dimension flowdif = max.getDifference(flowrectBottomRight);
//				if(flowdif.width < 0) max.x = flowrectBottomRight.x;
//				if(flowdif.height < 0) max.y = flowrectBottomRight.y;
//			}
		}
		for(Iterator<AadlConnectionAdapter> it = this.rootAdapter.getChildConnections(); it.hasNext();) {
			AadlConnectionAdapter connAdapter = it.next();
			if(connAdapter.getSourceAdapter().getParentAdapter().isContainer() || connAdapter.getDestinationAdapter().getParentAdapter().isContainer())
				continue;
			Rectangle rect = connAdapter.getFigure().getBounds();
			Point rectBottomRight = rect.getBottomRight();
			Dimension dif = max.getDifference(rectBottomRight);
			if(dif.width < 0) max.x = rectBottomRight.x;
			if(dif.height < 0) max.y = rectBottomRight.y;
		}

		// Add padding to edges.
		max.x += 50;
		max.y += 50;

		ComponentFigure figure = this.rootAdapter.getFigure();
		Point loc = figure.getBounds().getLocation();
		Rectangle newBounds = new Rectangle(loc.x, loc.y, max.x - loc.x, max.y - loc.y );
		figure.getParent().getLayoutManager().setConstraint(figure, newBounds);
		figure.setBounds(newBounds);
	}

	public Object getRootModelElement() {
		return this.rootAdapter.getModelElement();
	}


	public ScalableFreeformLayeredPane getScalableFigureLayeredPane() {
		return scalableFigureLayeredPane;
	}

	public void setScalableFigureLayeredPane(ScalableFreeformLayeredPane scalableFigureLayeredPane) {
		this.scalableFigureLayeredPane = scalableFigureLayeredPane;
	}

	public void setSelectedAdapter(IAadlElementAdapter adapter){
		if(selectedAdapter != NO_SELECTED_ADAPTER){
			// un-select the previously selected figure.
			selectedAdapter.setSelected(false);
		}
		selectedAdapter = adapter;
		selectedAdapter.setSelected(true);
	}

	public IAadlElementAdapter getSelectedAdapter() {
		return selectedAdapter;
	}

	public void performAutoLayout() {
		List<LayoutEntity> nodesToLayout = new ArrayList<LayoutEntity>();
		List<LayoutRelationship> connectionsToLayout = new ArrayList<LayoutRelationship>();
		List<PolylineConnection> connectionsToRestore = new ArrayList<PolylineConnection>();
		AadlComponentAdapter rootAdapter = this.getRootAdapter();

		if(rootAdapter != null) {
			for(Iterator<AadlComponentAdapter> it = rootAdapter.getChildComponents(); it.hasNext();) {
				nodesToLayout.add(it.next().getLayoutItem());
			}

			for(Iterator<AadlConnectionAdapter> it = rootAdapter.getChildConnections(); it.hasNext();) {
				AadlConnectionAdapter connAdapter = it.next();
				if(!connAdapter.getSourceAdapter().getParentAdapter().isContainer() && !connAdapter.getDestinationAdapter().getParentAdapter().isContainer()) {
					connectionsToRestore.add(connAdapter.getFigure());
					connectionsToLayout.add(connAdapter.getLayoutItem());
				}
			}
			// TODO XXX FlowPath processing

			try {
				Point location = new Point(0, 0);
				Dimension size = getAutoLayoutArea();
				Rectangle layoutArea = new Rectangle(location, size);
				SpringLayoutAlgorithm layout = new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING | LayoutStyles.ENFORCE_BOUNDS);
				layout.setSpringLength(20);
				layout.applyLayout(nodesToLayout.toArray(new LayoutEntity[]{}), connectionsToLayout.toArray(new LayoutRelationship[]{}), layoutArea.x, layoutArea.y, layoutArea.width, layoutArea.height, false, false);

				// The size of the container figure is reset after the auto layout
				// because the auto layout does not respect the initial figure boundaries.
				ComponentFigure figure = rootAdapter.getFigure();
				Rectangle newBounds = new Rectangle(new Point(0, 0), figure.getPreferredSize());
				figure.getParent().getLayoutManager().setConstraint(figure, newBounds);
				figure.setBounds(newBounds);

				// The layout algorithm clears the constraints for the connection figures; therefore, the default bendpoints need to be reset.
				//this.resetBendpoints(connectionsToRestore);

			} catch (InvalidLayoutConfiguration e) {
				e.printStackTrace();
			}

		}

	}

	private Dimension getAutoLayoutArea() {
		// The layout area needs to be large enough to fit all figures in either a single
		// horizontal row or a a single vertical row (worst case condition).
		Dimension area = new Dimension();
		int padding = 0;

		for(Iterator<AadlComponentAdapter> it = this.rootAdapter.getChildComponents(); it.hasNext();) {
			Rectangle bounds = it.next().getFigure().getBounds();
			// Increase area.
			area.expand(bounds.width + padding, bounds.height + padding);
		}

		return area;
	}

	private void resetBendpoints(List<PolylineConnection> connections) {
		for(PolylineConnection connection : connections) {
			BendpointHelper.setDefaultBendpoints(connection);
			connection.layout();
		}
	}

	private void initializeScalableFigureLayer() {
		this.scalableFigureLayeredPane = new ScalableFreeformLayeredPane();
		this.scalableFigureLayeredPane.setScale(DEFAULT_SCALE);
		this.figureLayer = new FreeformLayer();
		this.figureLayer.setLayoutManager(new FreeformLayout());
		this.scalableFigureLayeredPane.add(this.figureLayer, "Primary");
		// Add the scalable pane to this figure canvas.
		this.setContents(this.scalableFigureLayeredPane);
	}

	
}
