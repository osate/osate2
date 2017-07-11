package org.osate.ge.internal.businessObjectHandlers;

import java.awt.geom.Point2D;

import javax.inject.Named;

import org.osate.aadl2.Connection;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.PolyBuilder;
import org.osate.ge.internal.model.PropertyResultValue;
import org.osate.ge.services.QueryService;
import org.osate.xtext.aadl2.properties.util.CommunicationProperties;
public class TimingPropertyValueHandler {
	private static final String qualifiedTimingPropertyName = CommunicationProperties._NAME + "::" + CommunicationProperties.TIMING;
	
	private static final Graphic immediateGraphic = PolyBuilder.create().
			polyline().
			lineWidth(2).
			points(
			new Point2D.Double(8.0, -6), 
			new Point2D.Double(0.0, 0.0), 
			new Point2D.Double(8.0, 6.0),
			
			new Point2D.Double(0.0, 0.0),
			new Point2D.Double(8.0, 0.0),
			
			new Point2D.Double(16.0, -6), 
			new Point2D.Double(8.0, 0.0), 
			new Point2D.Double(16.0, 6.0)			
			).build();
	
	private static final Graphic delayedGraphic = PolyBuilder.create().
			polyline().
			lineWidth(2).
			points(
			new Point2D.Double(0.0, -10), 
			new Point2D.Double(0.0, 10.0),
			
			new Point2D.Double(0.0, 0.0),
			new Point2D.Double(5.0, 0.0),
			
			new Point2D.Double(5.0, -10), 
			new Point2D.Double(5.0, 10.0)			
			).build();
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) PropertyResultValue prv) {
		return (prv.getAppliedToBo() instanceof Connection || prv.getAppliedToBo() instanceof ConnectionInstance || prv.getAppliedToBo() instanceof ConnectionReference) &&
				qualifiedTimingPropertyName.equalsIgnoreCase(prv.getProperty().getQualifiedName()) && 
				prv.getValue() instanceof NamedValue;
	}
	
	public static boolean isImmediateTimingProperty(final Object bo) {
		if(!(bo instanceof PropertyResultValue)) {
			return false;
		}
		
		final PropertyResultValue prv = (PropertyResultValue)bo;
		if(qualifiedTimingPropertyName.equalsIgnoreCase(prv.getProperty().getQualifiedName()) &&
				prv.getValue() instanceof NamedValue) {
			final NamedValue namedValue = (NamedValue)prv.getValue();
			if(namedValue.getNamedValue() instanceof NamedElement) {
				final NamedElement ne = (NamedElement)namedValue.getNamedValue();
				return CommunicationProperties.IMMEDIATE.equalsIgnoreCase(ne.getName());
			}
		}
		
		return false;
	}
	
	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final @Named(Names.BUSINESS_OBJECT) PropertyResultValue prv,
			final QueryService queryService) {		
		final NamedValue namedValue = (NamedValue)prv.getValue();
		Graphic graphic = null;
		if(namedValue.getNamedValue() instanceof NamedElement) {
			final NamedElement ne = (NamedElement)namedValue.getNamedValue();
			if(CommunicationProperties.IMMEDIATE.equalsIgnoreCase(ne.getName())) {
				graphic = immediateGraphic;
			} else if(CommunicationProperties.DELAYED.equalsIgnoreCase(ne.getName())) {
				graphic = delayedGraphic;
			}
		}
		
		if(graphic == null) {
			return null;
		}
		
		return GraphicalConfigurationBuilder.create().
				graphic(graphic).
				decoration().
				build();
	}
}
