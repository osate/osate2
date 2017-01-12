package org.osate.ge.internal.businessObjectHandlers;

import java.util.stream.Stream;

import javax.inject.Named;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.di.GetNameLabelConfiguration;
import org.osate.ge.internal.graphics.AadlGraphics;
import org.osate.ge.internal.labels.LabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;

public class ComponentInstanceHandler {	
	private static final LabelConfiguration nameLabelConfiguration = LabelConfigurationBuilder.create().top().horizontalCenter().build();
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ComponentInstance ci) {
		return true;
	}
		
	@GetGraphic
	public Graphic getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT) ComponentInstance ci) {
		return AadlGraphics.getGraphic(ci.getComponentClassifier());
	}	
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ComponentInstance ci) {
		return ci.getFullName();
	}
	
	@GetNameLabelConfiguration
	public LabelConfiguration getNameLabelConfiguration() {
		return nameLabelConfiguration;
	}
	
	@GetChildren
	public Stream<?> getChildren(final @Named(Names.BUSINESS_OBJECT) ComponentInstance ci) {
		Stream.Builder<Object> connectionReferenceStreamBuilder = Stream.builder();
		for(final ConnectionInstance connectionInstance : ci.getConnectionInstances()) {
			for(final ConnectionReference cr : connectionInstance.getConnectionReferences()) {
				connectionReferenceStreamBuilder.add(cr);
			}
		}	

		return Stream.concat(Stream.concat(ci.getComponentInstances().stream(), 
				ci.getFeatureInstances().stream()),
				connectionReferenceStreamBuilder.build());
	}
}
