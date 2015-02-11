package org.osate.ge.diagrams.common;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.ui.platform.AbstractImageProvider;
import org.eclipse.graphiti.ui.platform.IImageProvider;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.eclipse.emf.common.util.URI;

public class AgeImageProvider extends AbstractImageProvider implements
		IImageProvider {
	public AgeImageProvider() {
	}
	protected static final String PREFIX = "org.osate.ge.diagrams.common.";
	public static String getImage(final EClass c) {
		return PREFIX + c.getName();
	}
	
	private void addImageFilePath(final EClass c) {
		addImageFilePath(c, c);
	}
	//Using EClass IC to hold name for the correct icon to be registered to EClass c
	private void addImageFilePath(final EClass c, final EClass ic) {
		//Using URI plugInImage to access images registered in plug-in dependency
		final URI plugInImage = URI.createPlatformPluginURI("org.osate.aadl2.edit/icons/full/obj16/"+ ic.getName() + ".gif", true);
		addImageFilePath(PREFIX + c.getName(), plugInImage.toString());
	}
	
	@Override
	protected void addAvailableImages() {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		addImageFilePath(p.getAbstractType());
		addImageFilePath(p.getAbstractImplementation());
		addImageFilePath(p.getBusType());
		addImageFilePath(p.getBusImplementation());
		addImageFilePath(p.getDataType());
		addImageFilePath(p.getDataImplementation());
		addImageFilePath(p.getDeviceType());
		addImageFilePath(p.getDeviceImplementation());
		addImageFilePath(p.getFeatureGroupType(), p.getFeatureGroup());
		addImageFilePath(p.getMemoryType());
		addImageFilePath(p.getMemoryImplementation());
		addImageFilePath(p.getProcessType());
		addImageFilePath(p.getProcessImplementation());
		addImageFilePath(p.getProcessorType());
		addImageFilePath(p.getProcessorImplementation());
		addImageFilePath(p.getSubprogramType());
		addImageFilePath(p.getSubprogramImplementation());
		addImageFilePath(p.getSubprogramGroupType());
		addImageFilePath(p.getSubprogramGroupImplementation());
		addImageFilePath(p.getSystemType());
		addImageFilePath(p.getSystemImplementation());
		addImageFilePath(p.getThreadType());
		addImageFilePath(p.getThreadImplementation());
		addImageFilePath(p.getThreadGroupType());
		addImageFilePath(p.getThreadGroupImplementation());
		addImageFilePath(p.getVirtualBusType());
		addImageFilePath(p.getVirtualBusImplementation());
		addImageFilePath(p.getVirtualProcessorType());
		addImageFilePath(p.getVirtualProcessorImplementation());
		addImageFilePath(p.getAbstractFeature());
		addImageFilePath(p.getBusAccess());
		addImageFilePath(p.getDataAccess());
		addImageFilePath(p.getDataPort());
		addImageFilePath(p.getEventDataPort());
		addImageFilePath(p.getEventPort());
		addImageFilePath(p.getFeatureGroup());
		addImageFilePath(p.getSubprogramAccess());
		addImageFilePath(p.getSubprogramGroupAccess());
		addImageFilePath(p.getAccessConnection());
		addImageFilePath(p.getFeatureConnection());
		addImageFilePath(p.getFeatureGroupConnection());
		addImageFilePath(p.getParameterConnection(), p.getAccessConnection());
		addImageFilePath(p.getPortConnection());
		addImageFilePath(p.getAbstractSubcomponent(), p.getAbstractType());
		addImageFilePath(p.getBusSubcomponent());
		addImageFilePath(p.getDataSubcomponent());
		addImageFilePath(p.getDeviceSubcomponent());
		addImageFilePath(p.getMemorySubcomponent());
		addImageFilePath(p.getProcessorSubcomponent());
		addImageFilePath(p.getProcessSubcomponent());
		addImageFilePath(p.getSubprogramSubcomponent());
		addImageFilePath(p.getSubprogramGroupSubcomponent());
		addImageFilePath(p.getSystemSubcomponent());
		addImageFilePath(p.getThreadSubcomponent());
		addImageFilePath(p.getThreadGroupSubcomponent());
		addImageFilePath(p.getVirtualBusSubcomponent());
		addImageFilePath(p.getVirtualProcessorSubcomponent());
		addImageFilePath(p.getMode());
		addImageFilePath(p.getModeTransition());
		addImageFilePath(p.getParameter());
		addImageFilePath(p.getEventSource(), p.getEventPort());
		addImageFilePath(p.getEventDataSource(), p.getEventDataPort());
		addImageFilePath(p.getPortProxy(),p.getAbstractFeature());
		addImageFilePath(p.getSubprogramProxy(), p.getSubprogramAccess());
		addImageFilePath(p.getFlowSpecification(), p.getModeTransition());
		addImageFilePath(p.getGeneralization(), p.getModeTransition());
	}
}
