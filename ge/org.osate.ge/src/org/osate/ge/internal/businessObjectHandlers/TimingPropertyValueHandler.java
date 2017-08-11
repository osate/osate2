package org.osate.ge.internal.businessObjectHandlers;

import java.awt.geom.Point2D;
import javax.inject.Named;
import org.osate.aadl2.Connection;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.PolyBuilder;
import org.osate.ge.internal.AgeDiagramProvider;
import org.osate.ge.internal.model.AgePropertyValue;
import org.osate.ge.internal.model.PropertyValueGroup;
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
	
	private final PropertyValueGroupHandler fallbackBoh = new PropertyValueGroupHandler();
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) PropertyValueGroup pvg) {
		if (qualifiedTimingPropertyName.equalsIgnoreCase(pvg.getProperty().getQualifiedName())) {
			AgePropertyValue pv = pvg.getFirstValueBasedOnCompletelyProcessedAssociation();
			if(pv != null && pv.getValue() instanceof NamedValue) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isImmediateTimingProperty(final Object bo) {
		if(!(bo instanceof PropertyValueGroup)) {
			return false;
		}
		
		final PropertyValueGroup pvg = (PropertyValueGroup)bo;
		if(qualifiedTimingPropertyName.equalsIgnoreCase(pvg.getProperty().getQualifiedName())) {
			AgePropertyValue pv = pvg.getFirstValueBasedOnCompletelyProcessedAssociation();
			if(pv != null && pv.getValue() instanceof NamedValue) {
				final NamedValue namedValue = (NamedValue)pv.getValue();
				if(namedValue.getNamedValue() instanceof NamedElement) {
					final NamedElement ne = (NamedElement)namedValue.getNamedValue();
					return CommunicationProperties.IMMEDIATE.equalsIgnoreCase(ne.getName());
				}
			}
		}
		
		return false;
	}
	
	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final @Named(Names.BUSINESS_OBJECT) PropertyValueGroup pvg,
			final QueryService queryService,
			final AgeDiagramProvider diagramProvider) {
		final Object parentBo = boc.getParent() == null ? null : boc.getParent().getBusinessObject();
		
		// Use default property handler if the BO isn't a connection or connection reference.
		if(!(parentBo instanceof Connection || parentBo instanceof ConnectionReference)) {
			return fallbackBoh.getGraphicalConfiguration(boc, pvg, diagramProvider);
		}
		
		final NamedValue namedValue = (NamedValue)pvg.getFirstValueBasedOnCompletelyProcessedAssociation().getValue();
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
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final @Named(Names.BUSINESS_OBJECT) PropertyValueGroup pvg,
			final QueryService queryService) {		
		// Only used for the fallback handler
		return fallbackBoh.getName(boc, pvg, queryService);
	}
}
