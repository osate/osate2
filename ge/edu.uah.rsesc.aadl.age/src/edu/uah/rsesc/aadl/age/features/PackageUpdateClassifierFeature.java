package edu.uah.rsesc.aadl.age.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.osate.aadl2.AbstractClassifier;
import org.osate.aadl2.BusClassifier;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DeviceClassifier;
import org.osate.aadl2.MemoryClassifier;
import org.osate.aadl2.ProcessClassifier;
import org.osate.aadl2.ProcessorClassifier;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.SubprogramGroupClassifier;
import org.osate.aadl2.SystemClassifier;
import org.osate.aadl2.ThreadClassifier;
import org.osate.aadl2.ThreadGroupClassifier;
import org.osate.aadl2.VirtualBusClassifier;
import org.osate.aadl2.VirtualProcessorClassifier;

import edu.uah.rsesc.aadl.age.util.StyleUtil;

public class PackageUpdateClassifierFeature extends AbstractUpdateFeature {
	public PackageUpdateClassifierFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		return (getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof Classifier);
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		//System.out.println("UPDATE NEEDED?");
	//	context.getPictogramElement().g
	//	return Reason.createTrueReason();
		return Reason.createFalseReason();
		//return null;
	}

	@Override
	public boolean update(IUpdateContext context) {
		//System.out.println("UPDATING....");
		
		return false;
	}
}
