package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.util.IColorConstant;

public interface StyleService {

	Style getStyle(Diagram diagram, String styleId);

	Style getSystemStyle(Diagram diagram, boolean isImplementation);

	Style getProcessStyle(Diagram diagram, boolean isImplementation);

	Style getThreadGroupStyle(Diagram diagram, boolean isImplementation);

	Style getThreadStyle(Diagram diagram, boolean isImplementation);

	Style getSubprogramStyle(Diagram diagram, boolean isImplementation);

	Style getSubprogramGroupStyle(Diagram diagram, boolean isImplementation);

	Style getDataStyle(Diagram diagram, boolean isImplementation);

	Style getAbstractStyle(Diagram diagram, boolean isImplementation);

	Style getVirtualBusStyle(Diagram diagram, boolean isImplementation);

	Style getVirtualProcessorStyle(Diagram diagram, boolean isImplementation);

	Style getBusStyle(Diagram diagram, boolean isImplementation);

	Style getProcessorStyle(Diagram diagram, boolean isImplementation);

	Style getDeviceStyle(Diagram diagram, boolean isImplementation);

	Style getMemoryStyle(Diagram diagram, boolean isImplementation);

	Style getFeatureGroupStyle(Diagram diagram);

	Style getShadedStyle(Diagram diagram);

	Style getImplementsStyle(Diagram diagram);

	Style getFlowSpecificationStyle(Diagram diagram);

	Style getExtendsStyle(Diagram diagram);

	Style getGeneralizationArrowHeadStyle(Diagram diagram);

	Style getDecoratorStyle(Diagram diagram);

	Style getModeTransitionTrigger(Diagram diagram);

	Style getLabelStyle(Diagram diagram);

	Style getFeatureStyle(Diagram diagram);

	Style getSubprogramAccessStyle(Diagram diagram);

	Style getSubprogramGroupAccessStyle(Diagram diagram);

	Style getBackgroundStyle(Diagram diagram);

	Style getFeatureGroupLargeCircleStyle(Diagram diagram);

	Style getFeatureGroupSmallCircleStyle(Diagram diagram);

	Style getModeStyle(Diagram diagram);

	Style getInitialModeStyle(Diagram diagram);

	IColorConstant getInSelectedModeColor();

}