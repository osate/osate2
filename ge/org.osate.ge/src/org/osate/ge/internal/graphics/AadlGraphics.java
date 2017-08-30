package org.osate.ge.internal.graphics;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.PortCategory;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.LineWidth;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;

/**
 * Helper class for retrieving the appropriate graphic for an AADL element
 *
 */
public class AadlGraphics {
	private static final Graphic defaultGraphic = RectangleBuilder.create().build(); // Fallback graphic when a specialized graphic is not supported
	private static final Graphic abstractGraphic = RectangleBuilder.create().build();
	private static final Graphic busGraphic = BusGraphicBuilder.create().build();
	private static final Graphic dataGraphic = RectangleBuilder.create().build();
	private static final Graphic deviceGraphic = DeviceGraphicBuilder.create().build();
	private static final Graphic memoryGraphic = MemoryGraphicBuilder.create().build();
	private static final Graphic processGraphic = ParallelogramBuilder.create().horizontalOffset(20).build();
	private static final Graphic processorGraphic = ProcessorGraphicBuilder.create().build();
	private static final Graphic subprogramGraphic = EllipseBuilder.create().build();
	private static final Graphic subprogramGroupGraphic = EllipseBuilder.create().build();
	private static final Graphic systemGraphic = RectangleBuilder.create().rounded().build();
	private static final Graphic threadGraphic = ParallelogramBuilder.create().horizontalOffset(20).build();
	private static final Graphic threadGroupGraphic = RectangleBuilder.create().rounded().build();
	private static final Graphic virtualBusGraphic = BusGraphicBuilder.create().build();
	private static final Graphic virtualProcessorGraphic = ProcessorGraphicBuilder.create().build();
	private static final Graphic featureGroupTypeGraphic = FeatureGroupTypeGraphicBuilder.create().build();
	private static final Style topCenteredLabelStyle = StyleBuilder.create().labelsTop().labelsHorizontalCenter()
			.build();
	private final static Style dashedStyle = StyleBuilder.create(topCenteredLabelStyle).dashed().build();
	private final static Style implStyle = StyleBuilder.create(topCenteredLabelStyle).lineWidth(LineWidth.Medium)
			.build();
	private final static Style dashedImplStyle = StyleBuilder.create(dashedStyle, implStyle).build();

	public static Graphic getGraphic(final Classifier classifier) {
		if(classifier instanceof ComponentClassifier) {
			return getGraphic((ComponentClassifier)classifier);
		} else if(classifier instanceof FeatureGroupType) {
			return featureGroupTypeGraphic;
		}

		return defaultGraphic;
	}

	public static Style getStyle(final Classifier classifier) {
		if (classifier instanceof ComponentClassifier) {
			return getStyle((ComponentClassifier) classifier);
		}

		return topCenteredLabelStyle;
	}

	public static Graphic getFeatureGraphic(final EClass featureClass, DirectionType direction) {
		final FeatureGraphicBuilder builder = FeatureGraphicBuilder.create();

		// Configure the feature type
		final Aadl2Package aadl2Pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
		if(featureClass == aadl2Pkg.getAbstractFeature()) {
			builder.abstractFeature();
		} else if(featureClass == aadl2Pkg.getEventPort()) {
			builder.eventPort();
		} else if(featureClass == aadl2Pkg.getDataPort() || featureClass == aadl2Pkg.getParameter()) {
			builder.dataPort();
		} else if(featureClass == aadl2Pkg.getEventDataPort()) {
			builder.eventDataPort();
		} else if(featureClass == aadl2Pkg.getSubprogramAccess()) {
			builder.subprogramAccess();
		} else if(featureClass == aadl2Pkg.getSubprogramGroupAccess()) {
			builder.subprogramGroupAccess();
		} else if(featureClass == aadl2Pkg.getDataAccess()) {
			builder.dataAccess();
		} else if(featureClass == aadl2Pkg.getBusAccess()) {
			builder.busAccess();
		} else if(featureClass == aadl2Pkg.getFeatureGroup()) {
			builder.featureGroup();
		} else if(featureClass == aadl2Pkg.getPortProxy()) {
			builder.portProxy();
		} else if(featureClass == aadl2Pkg.getEventSource()) {
			builder.eventSource();
		} else if(featureClass == aadl2Pkg.getEventDataSource()) {
			builder.eventDataSource();
		} else if(featureClass == aadl2Pkg.getSubprogramProxy()) {
			builder.subprogramProxy();
		} else {
			return defaultGraphic;
		}

		switch(direction) {
		case IN:
			builder.input();
			break;

		case OUT:
			builder.output();
			break;

		case IN_OUT:
			builder.bidirectional();
			break;
		}

		return builder.build();
	}

	public static Graphic getFeatureGraphic(final PortCategory portCategory, final DirectionType direction) {
		final FeatureGraphicBuilder builder = FeatureGraphicBuilder.create();

		switch(portCategory) {
		case DATA:
			builder.dataPort();
			break;

		case EVENT:
			builder.eventPort();
			break;

		case EVENT_DATA:
			builder.eventDataPort();
			break;

		default:
			return defaultGraphic;
		}

		switch(direction) {
		case IN:
			builder.input();
			break;

		case OUT:
			builder.output();
			break;

		case IN_OUT:
			builder.bidirectional();
			break;
		}

		return builder.build();
	}

	public static Graphic getFeatureGraphic(final AccessCategory accessCategory, final DirectionType direction) {
		final FeatureGraphicBuilder builder = FeatureGraphicBuilder.create();

		switch(accessCategory) {
		case BUS:
			builder.busAccess();
			break;

		case DATA:
			builder.dataAccess();
			break;

		case SUBPROGRAM:
			builder.subprogramAccess();
			break;

		case SUBPROGRAM_GROUP:
			builder.subprogramGroupAccess();
			break;

		default:
			return defaultGraphic;
		}

		switch(direction) {
		case IN:
			builder.input();
			break;

		case OUT:
			builder.output();
			break;

		case IN_OUT:
			builder.bidirectional();
			break;
		}

		return builder.build();
	}

	private static Graphic getGraphic(final ComponentClassifier cc) {
		return getGraphic(cc.getCategory());
	}

	public static Graphic getGraphic(final ComponentCategory cc) {
		switch(cc) {
		case ABSTRACT:
			return abstractGraphic;

		case BUS:
			return busGraphic;

		case DATA:
			return dataGraphic;

		case DEVICE:
			return deviceGraphic;

		case MEMORY:
			return memoryGraphic;

		case PROCESS:
			return processGraphic;

		case PROCESSOR:
			return processorGraphic;

		case SUBPROGRAM:
			return subprogramGraphic;

		case SUBPROGRAM_GROUP:
			return subprogramGroupGraphic;

		case SYSTEM:
			return systemGraphic;

		case THREAD:
			return threadGraphic;

		case THREAD_GROUP:
			return threadGroupGraphic;

		case VIRTUAL_BUS:
			return virtualBusGraphic;

		case VIRTUAL_PROCESSOR:
			return virtualProcessorGraphic;

		default:
			return defaultGraphic;
		}
	}

	private static Style getStyle(final ComponentClassifier cc) {
		return getStyle(cc.getCategory(), cc instanceof ComponentImplementation);
	}

	public static Style getStyle(final ComponentCategory cc, final boolean isImplementation) {
		final boolean isDashed = cc == ComponentCategory.ABSTRACT || cc == ComponentCategory.THREAD || cc == ComponentCategory.THREAD_GROUP
				|| cc == ComponentCategory.SUBPROGRAM_GROUP || cc == ComponentCategory.VIRTUAL_BUS
				|| cc == ComponentCategory.VIRTUAL_PROCESSOR;

		if (isImplementation) {
			return isDashed ? dashedImplStyle : implStyle;
		} else {
			return isDashed ? dashedStyle : topCenteredLabelStyle;
		}

	}
}
