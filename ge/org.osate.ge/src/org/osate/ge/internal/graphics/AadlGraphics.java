package org.osate.ge.internal.graphics;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;

/**
 * Helper class for retrieving the appropriate graphic for an AADL element 
 *
 */
public class AadlGraphics {
	private static final int typeLineWidth = 2;
	private static final int implLineWidth = 3;
	
	private static final Graphic defaultGraphic = RectangleBuilder.create().build(); // Fallback graphic when a specialized graphic is not supported
	private static final Graphic abstractGraphic = RectangleBuilder.create().dashed().lineWidth(typeLineWidth).build();
	private static final Graphic abstractImplGraphic = RectangleBuilder.create().dashed().lineWidth(implLineWidth).build();
	private static final Graphic busGraphic = BusGraphicBuilder.create().lineWidth(typeLineWidth).build();
	private static final Graphic busImplGraphic = BusGraphicBuilder.create().lineWidth(implLineWidth).build();
	private static final Graphic dataGraphic = RectangleBuilder.create().lineWidth(typeLineWidth).build();
	private static final Graphic dataImplGraphic = RectangleBuilder.create().lineWidth(implLineWidth).build();
	private static final Graphic deviceGraphic = DeviceGraphicBuilder.create().lineWidth(typeLineWidth).build();
	private static final Graphic deviceImplGraphic = DeviceGraphicBuilder.create().lineWidth(implLineWidth).build();
	private static final Graphic memoryGraphic = MemoryGraphicBuilder.create().lineWidth(typeLineWidth).build();
	private static final Graphic memoryImplGraphic = MemoryGraphicBuilder.create().lineWidth(implLineWidth).build();
	private static final Graphic processGraphic = ParallelogramBuilder.create().horizontalOffset(20).lineWidth(typeLineWidth).build();
	private static final Graphic processImplGraphic = ParallelogramBuilder.create().horizontalOffset(20).lineWidth(implLineWidth).build();
	private static final Graphic processorGraphic = ProcessorGraphicBuilder.create().lineWidth(typeLineWidth).build();
	private static final Graphic processorImplGraphic = ProcessorGraphicBuilder.create().lineWidth(implLineWidth).build();
	private static final Graphic subprogramGraphic = EllipseBuilder.create().lineWidth(typeLineWidth).build();
	private static final Graphic subprogramImplGraphic = EllipseBuilder.create().lineWidth(implLineWidth).build();
	private static final Graphic subprogramGroupGraphic = EllipseBuilder.create().dashed().lineWidth(typeLineWidth).build();
	private static final Graphic subprogramGroupImplGraphic = EllipseBuilder.create().dashed().lineWidth(implLineWidth).build();
	private static final Graphic systemGraphic = RectangleBuilder.create().rounded().lineWidth(typeLineWidth).build();
	private static final Graphic systemImplGraphic = RectangleBuilder.create().rounded().lineWidth(implLineWidth).build();	
	private static final Graphic threadGraphic = ParallelogramBuilder.create().horizontalOffset(20).dashed().lineWidth(typeLineWidth).build();
	private static final Graphic threadImplGraphic = ParallelogramBuilder.create().horizontalOffset(20).dashed().lineWidth(implLineWidth).build();
	private static final Graphic threadGroupGraphic = RectangleBuilder.create().rounded().dashed().lineWidth(typeLineWidth).build();
	private static final Graphic threadGroupImplGraphic = RectangleBuilder.create().rounded().dashed().lineWidth(implLineWidth).build();
	private static final Graphic virtualBusGraphic = BusGraphicBuilder.create().dashed().lineWidth(typeLineWidth).build();
	private static final Graphic virtualBusImplGraphic = BusGraphicBuilder.create().dashed().lineWidth(implLineWidth).build();
	private static final Graphic virtualProcessorGraphic = ProcessorGraphicBuilder.create().dashed().lineWidth(typeLineWidth).build();
	private static final Graphic virtualProcessorImplGraphic = ProcessorGraphicBuilder.create().dashed().lineWidth(implLineWidth).build();	
	private static final Graphic featureGroupTypeGraphic = FeatureGroupTypeGraphicBuilder.create().build();
	
	public static Graphic getGraphic(final Classifier classifier) {
		if(classifier instanceof ComponentClassifier) {
			return getGraphic((ComponentClassifier)classifier);
		} else if(classifier instanceof FeatureGroupType) {
			return featureGroupTypeGraphic;
		}
		
		return defaultGraphic;
	}
	
	public static Graphic getFeatureGraphic(final EClass featureClass, DirectionType direction) {
		final FeatureGraphicBuilder builder = FeatureGraphicBuilder.create();
		
		// Configure the feature type
		final Aadl2Package aadl2Pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
		if(featureClass == aadl2Pkg.getAbstractFeature()) {
			builder.abstractFeature();
		} else if(featureClass == aadl2Pkg.getEventPort()) {
			builder.eventPort();
		} else if(featureClass == aadl2Pkg.getDataPort()) {
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
	
	private static Graphic getGraphic(final ComponentClassifier cc) {
		return getGraphic(cc.getCategory(), cc instanceof ComponentImplementation);
	}
	
	private static Graphic getGraphic(final ComponentCategory cc, final boolean isImplementation) {
		switch(cc) {
		case ABSTRACT:
			return isImplementation ? abstractImplGraphic : abstractGraphic;
			
		case BUS:
			return isImplementation ? busImplGraphic : busGraphic;
			
		case DATA:
			return isImplementation ? dataImplGraphic : dataGraphic;
			
		case DEVICE:
			return isImplementation ? deviceImplGraphic : deviceGraphic;
			
		case MEMORY:
			return isImplementation ? memoryImplGraphic : memoryGraphic;
			
		case PROCESS:
			return isImplementation ? processImplGraphic : processGraphic;
			
		case PROCESSOR:
			return isImplementation ? processorImplGraphic : processorGraphic;
			
		case SUBPROGRAM:
			return isImplementation ? subprogramImplGraphic : subprogramGraphic;
			
		case SUBPROGRAM_GROUP:
			return isImplementation ? subprogramGroupImplGraphic : subprogramGroupGraphic;
			
		case SYSTEM:
			return isImplementation ? systemImplGraphic : systemGraphic;
			
		case THREAD:
			return isImplementation ? threadImplGraphic : threadGraphic;
			
		case THREAD_GROUP:
			return isImplementation ? threadGroupImplGraphic : threadGroupGraphic;
			
		case VIRTUAL_BUS:
			return isImplementation ? virtualBusImplGraphic : virtualBusGraphic;
			
		case VIRTUAL_PROCESSOR:
			return isImplementation ? virtualProcessorImplGraphic : virtualProcessorGraphic;
			
		default:
			return defaultGraphic;	
		}
	}	
}
