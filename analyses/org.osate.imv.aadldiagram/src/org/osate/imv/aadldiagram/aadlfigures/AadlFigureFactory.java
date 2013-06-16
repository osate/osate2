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

package org.osate.imv.aadldiagram.aadlfigures;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.osate.imv.aadldiagram.aadlfigures.components.AbstractFigure;
import org.osate.imv.aadldiagram.aadlfigures.components.BusFigure;
import org.osate.imv.aadldiagram.aadlfigures.components.ComponentFigure;
import org.osate.imv.aadldiagram.aadlfigures.components.ComponentTitleBorder;
import org.osate.imv.aadldiagram.aadlfigures.components.DataFigure;
import org.osate.imv.aadldiagram.aadlfigures.components.DeviceFigure;
import org.osate.imv.aadldiagram.aadlfigures.components.MemoryFigure;
import org.osate.imv.aadldiagram.aadlfigures.components.ProcessFigure;
import org.osate.imv.aadldiagram.aadlfigures.components.ProcessorFigure;
import org.osate.imv.aadldiagram.aadlfigures.components.SubprogramFigure;
import org.osate.imv.aadldiagram.aadlfigures.components.SubprogramGroupFigure;
import org.osate.imv.aadldiagram.aadlfigures.components.SystemFigure;
import org.osate.imv.aadldiagram.aadlfigures.components.ThreadFigure;
import org.osate.imv.aadldiagram.aadlfigures.components.ThreadGroupFigure;
import org.osate.imv.aadldiagram.aadlfigures.features.AbstractFeature;
import org.osate.imv.aadldiagram.aadlfigures.features.AccessFeatureFigure;
import org.osate.imv.aadldiagram.aadlfigures.features.DataPortFeature;
import org.osate.imv.aadldiagram.aadlfigures.features.EventDataPortFeature;
import org.osate.imv.aadldiagram.aadlfigures.features.EventPortFeature;
import org.osate.imv.aadldiagram.aadlfigures.features.FeatureFigure;
import org.osate.imv.aadldiagram.aadlfigures.features.FeatureFigure.FeatureLabelStyle;
import org.osate.imv.aadldiagram.aadlfigures.features.FeatureGroupFigure;
import org.osate.imv.aadldiagram.aadlfigures.features.ParameterFeatureFigure;
import org.osate.imv.aadldiagram.adapters.AadlBindingAdapter;
import org.osate.imv.aadldiagram.adapters.AadlComponentAdapter;
import org.osate.imv.aadldiagram.adapters.AadlConnectionAdapter;
import org.osate.imv.aadldiagram.adapters.AadlFeatureAdapter;
import org.osate.imv.aadldiagram.adapters.AadlFlowPathAdapter;
import org.osate.imv.aadldiagram.adapters.IAadlElementAdapter;
import org.osate.imv.aadldiagram.bindingdecorations.BindingDecoration;
import org.osate.imv.aadldiagram.bindingdecorations.BindingDecorationType;
import org.osate.imv.aadldiagram.bindingdecorations.BindingDecoratorLocator;
import org.osate.imv.aadldiagram.connectiondecorations.ConnectionDecoratorLocator;
import org.osate.imv.aadldiagram.connectiondecorations.PortConnectionDecoration;
import org.osate.imv.aadldiagram.connectiondecorations.PortConnectionDecoration.DecorationType;
import org.osate.imv.aadldiagram.draw2d.BendpointHelper;
import org.osate.imv.aadldiagram.draw2d.SelectableMevBindingFigure;
import org.osate.imv.aadldiagram.draw2d.SelectableMevConnectionFigure;
import org.osate.imv.aadldiagram.layout.AadlComponentLayout;
import org.osate.imv.aadldiagram.propertydecorations.PropertyDecorationSupport;


public class AadlFigureFactory {
	/** Singleton instance. */
	private static AadlFigureFactory instance;

	private static final Color CONTAINER_SELECTION_COLOR = ColorConstants.black;
	private static final Color NORMAL_SELECTION_COLOR = new Color(Display.getCurrent(), 0, 9, 94);

	private static final Color DEFAULT_CONTAINER_BG_COLOR = new Color(Display.getCurrent(), 201, 250, 255);
	private static final Color DEFAULT_NORMAL_BG_COLOR = ColorConstants.white;

	private PropertyDecorationSupport propertyDecorationSupport;

	private AadlFigureFactory() {
		this.propertyDecorationSupport = new PropertyDecorationSupport();
	}

	public static synchronized AadlFigureFactory getInstance() {
		if (instance == null)
			instance = new AadlFigureFactory();

		return instance;
	}

	public ComponentFigure buildFigure(AadlComponentAdapter adapter) {
		ComponentFigure figure = null;

		// Get the adapters category.
		switch (adapter.getCategory()) {
		case SYSTEM:
			figure = buildSystemFigure(adapter);
			break;
		case PROCESS:
			figure = buildProcessFigure(adapter);
			break;
		case THREAD:
			figure = buildThreadFigure(adapter);
			break;
		case DEVICE:
			figure = buildDeviceFigure(adapter);
			break;
		case BUS:
			figure = buildBusFigure(adapter, false);
			break;
		case VIRTUAL_BUS:
			figure = buildBusFigure(adapter, true);
			break;
		case MEMORY:
			figure = buildMemoryFigure(adapter);
			break;
		case ABSTRACT:
			figure = buildAbstractFigure(adapter);
			break;
		case PROCESSOR:
			figure = buildProcessorFigure(adapter, false);
			break;
		case VIRTUAL_PROCESSOR:
			figure = buildProcessorFigure(adapter, true);
			break;
		case THREAD_GROUP:
			figure = buildThreadGroupFigure(adapter);
			break;
		case DATA:
			figure = buildDataFigure(adapter);
			break;
		case SUBPROGRAM:
			figure = buildSubprogramFigure(adapter);
			break;
		case SUBPROGRAM_GROUP:
			figure = buildSubprogramGroupFigure(adapter);
			break;
		default:
			System.err.println("Component category " + adapter.getCategory() + " is NOT currently supported.");
		}
		

		if (figure != null) {
			figure.setAdapter(adapter);
			// Set border
			Border border = new ComponentTitleBorder(adapter.toString());
			figure.setBorder(border);

			// Set layout manager.
			figure.setLayoutManager(new AadlComponentLayout());

			// Set figure mover.
			if (adapter.isContainer()) {
				figure.setBackgroundColor(DEFAULT_CONTAINER_BG_COLOR);
				figure.setSelectionColor(CONTAINER_SELECTION_COLOR);
			} else {
				figure.setBackgroundColor(DEFAULT_NORMAL_BG_COLOR);
				figure.setSelectionColor(NORMAL_SELECTION_COLOR);
			}

			// Add property decorations.
			this.propertyDecorationSupport.addPropertyDecorations(adapter.getCategory(), figure, adapter.getModelElement());
		}

		return figure;
	}

	public FeatureFigure buildFigure(AadlFeatureAdapter adapter) {
		FeatureFigure figure = null;
		IAadlElementAdapter parentAdapter = adapter.getParentAdapter();

		Assert.isNotNull(parentAdapter);
		Assert.isTrue(parentAdapter instanceof AadlComponentAdapter);

		FeatureLabelStyle style = ((AadlComponentAdapter) parentAdapter).isContainer() ? FeatureLabelStyle.LABEL_STYLE1
				: FeatureLabelStyle.LABEL_STYLE2;

		switch (adapter.getCategory()) {
		case DATA_PORT:
			figure = buildDataPortFigure(adapter, style);
			break;
		case EVENT_DATA_PORT:
			figure = buildEventDataPortFigure(adapter, style);
			break;
		case EVENT_PORT:
			figure = buildEventPortFigure(adapter, style);
			break;
		case BUS_ACCESS:
		case DATA_ACCESS:
		case SUBPROGRAM_ACCESS:
		case SUBPROGRAM_GROUP_ACCESS:
			figure = buildAccessFeatureFigure(adapter, style);
			break;
		case FEATURE_GROUP:
			figure = buildFeatureGroupFigure(adapter, style);
			break;
		case ABSTRACT_FEATURE:
			figure = buildAbstractFeatureFigure(adapter, style);
			break;
		case PARAMETER:
			figure = buildParameterFigure(adapter, style);
			break;
		default:
			System.err.println("Feature category " + adapter.getCategory() + " is NOT currently supported.");
		}

		return figure;
	}

	public SelectableMevConnectionFigure buildFigure(AadlConnectionAdapter adapter) {
		SelectableMevConnectionFigure figure = null;
		IAadlElementAdapter srcAdapter = adapter.getSourceAdapter();
		IAadlElementAdapter dstAdapter = adapter.getDestinationAdapter();

		// Create figure.
		figure = new SelectableMevConnectionFigure();

		// Set connection anchors.
		figure.setSourceAnchor(srcAdapter.getConnectionAnchor(figure));
		figure.setTargetAnchor(dstAdapter.getConnectionAnchor(figure));

		figure.setConnectionRouter(new BendpointConnectionRouter());
		figure.setLayoutManager(new DelegatingLayout());
		Object ele = adapter.getModelElement();
		ILabelProvider lp = adapter.getLabelProvider();
		String s2=lp.getText(ele);
			if (s2 != null && s2.length() > 0){
				figure.setToolTip(new Label(s2));
		}
		

		BendpointHelper.setDefaultBendpoints(figure);

		// Configure connection figure.
		figure.setAntialias(SWT.ON);

		// Set decoration.
		switch(adapter.getDecorationType()) 
		{
			case IMMEDIATE:
			{
				figure.add(new PortConnectionDecoration(DecorationType.IMMEDIATE), new ConnectionDecoratorLocator(figure, ConnectionLocator.MIDDLE));
				break;
			}
			case DELAYED:
			{
				figure.add(new PortConnectionDecoration(DecorationType.DELAYED), new ConnectionDecoratorLocator(figure, ConnectionLocator.MIDDLE));
				break;
			}
		}

		return figure;
	}

	public SelectableMevConnectionFigure buildFigure(AadlFlowPathAdapter adapter) {
		SelectableMevConnectionFigure figure = null;
		IAadlElementAdapter srcAdapter = adapter.getSourceAdapter();
		IAadlElementAdapter dstAdapter = adapter.getDestinationAdapter();

		// Create figure.
		figure = new SelectableMevConnectionFigure();

		// Set connection anchors.
		figure.setSourceAnchor(srcAdapter.getConnectionAnchor(figure));
		figure.setTargetAnchor(dstAdapter.getConnectionAnchor(figure));

		figure.setConnectionRouter(new BendpointConnectionRouter());
		figure.setLayoutManager(new DelegatingLayout());
		Object ele = adapter.getModelElement();
		ILabelProvider lp = adapter.getLabelProvider();
		String s2=lp.getText(ele);
		if (s2 != null && s2.length() > 0){
			figure.setToolTip(new Label(s2));
	}
		

		BendpointHelper.setDefaultBendpoints(figure);

//		// Configure connection figure.
//		figure.setAntialias(SWT.ON);
//
//		// Set decoration.
//		switch(adapter.getDecorationType()) 
//		{
//			case IMMEDIATE:
//			{
//				figure.add(new PortConnectionDecoration(DecorationType.IMMEDIATE), new ConnectionDecoratorLocator(figure, ConnectionLocator.MIDDLE));
//				break;
//			}
//			case DELAYED:
//			{
//				figure.add(new PortConnectionDecoration(DecorationType.DELAYED), new ConnectionDecoratorLocator(figure, ConnectionLocator.MIDDLE));
//				break;
//			}
//		}

		return figure;
	}

	public SelectableMevBindingFigure buildFigure(AadlBindingAdapter adapter) {
		SelectableMevBindingFigure figure = null;
		IAadlElementAdapter processAdapter = adapter.getProcessAdapter();
		IAadlElementAdapter boundResourceAdapter = adapter.getBoundResourceAdapter();

		// Create figure.
		figure = new SelectableMevBindingFigure();

		// Set connection anchors.
		figure.setSourceAnchor(processAdapter.getConnectionAnchor(figure));
		figure.setTargetAnchor(boundResourceAdapter.getConnectionAnchor(figure));

		figure.setConnectionRouter(new BendpointConnectionRouter());
		figure.setLayoutManager(new DelegatingLayout());

		BendpointHelper.setDefaultBendpoints(figure);

		// Configure connection figure.
		figure.setAntialias(SWT.ON);

		// Set decoration.
		switch(adapter.getDecorationType()) 
		{
		
		case MEMORY:
			{
				figure.add(new BindingDecoration(BindingDecorationType.MEMORY), new BindingDecoratorLocator(figure, ConnectionLocator.MIDDLE));
			break;
			}
		
		case PROCESSOR:
			{
				figure.add(new BindingDecoration(BindingDecorationType.PROCESSOR), new BindingDecoratorLocator(figure, ConnectionLocator.MIDDLE));
				break;
			}
			
			default:
			{
				figure.add(new BindingDecoration(BindingDecorationType.PROCESSOR), new BindingDecoratorLocator(figure, ConnectionLocator.MIDDLE));
				break;
			}
		}

		return figure;
	}
	
	
	private ComponentFigure buildBusFigure(AadlComponentAdapter adapter, boolean virtual) {
		ComponentFigure figure = new BusFigure(virtual);
		return figure;
	}

	private ComponentFigure buildSystemFigure(AadlComponentAdapter adapter) {
		ComponentFigure figure = new SystemFigure();
		return figure;
	}

	private ComponentFigure buildProcessFigure(AadlComponentAdapter adapter) {
		ComponentFigure figure = new ProcessFigure();
		return figure;
	}

	private ComponentFigure buildThreadFigure(AadlComponentAdapter adapter) {
		ComponentFigure figure = new ThreadFigure();
		return figure;
	}

	private ComponentFigure buildAbstractFigure(AadlComponentAdapter adapter) {
		ComponentFigure figure = new AbstractFigure();
		return figure;
	}

	private ComponentFigure buildDataFigure(AadlComponentAdapter adapter) {
		ComponentFigure figure = new DataFigure();
		return figure;
	}

	private ComponentFigure buildSubprogramFigure(AadlComponentAdapter adapter) {
		ComponentFigure figure = new SubprogramFigure();
		return figure;
	}

	private ComponentFigure buildSubprogramGroupFigure(AadlComponentAdapter adapter) {
		ComponentFigure figure = new SubprogramGroupFigure();
		return figure;
	}

	private ComponentFigure buildDeviceFigure(AadlComponentAdapter adapter) {
		ComponentFigure figure = new DeviceFigure();
		return figure;
	}

	private ComponentFigure buildMemoryFigure(AadlComponentAdapter adapter) {
		ComponentFigure figure = new MemoryFigure();
		return figure;
	}

	private ComponentFigure buildThreadGroupFigure(AadlComponentAdapter adapter) {
		ComponentFigure figure = new ThreadGroupFigure();
		return figure;
	}

	private ComponentFigure buildProcessorFigure(AadlComponentAdapter adapter, boolean virtual) {
		ComponentFigure figure = new ProcessorFigure(virtual);
		return figure;
	}

	private FeatureFigure buildDataPortFigure(AadlFeatureAdapter adapter, FeatureLabelStyle style) {
		FeatureFigure figure = new DataPortFeature(adapter.toString(), adapter.getDirectionType(), style);
		return figure;
	}

	private FeatureFigure buildFeatureGroupFigure(AadlFeatureAdapter adapter, FeatureLabelStyle style) {
		FeatureFigure figure = new FeatureGroupFigure(adapter.toString(), adapter.getDirectionType(), style);
		return figure;
	}

	private FeatureFigure buildParameterFigure(AadlFeatureAdapter adapter, FeatureLabelStyle style) {
		FeatureFigure figure = new ParameterFeatureFigure(adapter.toString(), adapter.getDirectionType(), style);
		return figure;
	}

	private FeatureFigure buildAccessFeatureFigure(AadlFeatureAdapter adapter, FeatureLabelStyle style) {
		AccessFeatureFigure figure = new AccessFeatureFigure(adapter.toString(), adapter.getDirectionType(), style, adapter.getCategory());
		return figure;
	}

	private FeatureFigure buildEventDataPortFigure(AadlFeatureAdapter adapter, FeatureLabelStyle style) {
		FeatureFigure figure = new EventDataPortFeature(adapter.toString(), adapter.getDirectionType(), style);
		return figure;
	}

	private FeatureFigure buildEventPortFigure(AadlFeatureAdapter adapter, FeatureLabelStyle style) {
		FeatureFigure figure = new EventPortFeature(adapter.toString(), adapter.getDirectionType(), style);
		return figure;
	}

	private FeatureFigure buildAbstractFeatureFigure(AadlFeatureAdapter adapter, FeatureLabelStyle style) {
		FeatureFigure figure = new AbstractFeature(adapter.toString(), adapter.getDirectionType(), style);
		return figure;
	}

}
