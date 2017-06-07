package org.osate.ge.internal.businessObjectHandlers;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.graphics.LabelBuilder;
import org.osate.ge.internal.model.PropertyResultValue;
import org.osate.ge.internal.util.PropertyResult.ReferenceValueWithContext;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;
import org.osate.ge.internal.util.PropertyValueFormatter;

public class PropertyResultValueHandler {
	private final Graphic labelGraphic = LabelBuilder.create().build();
	private static final Graphic referenceGraphic = ConnectionBuilder.create().
			dashed().
			destinationTerminator(ArrowBuilder.create().filled().small().build()).
			build();
	private static final Graphic partialGraphic = ConnectionBuilder.create().
			dotted().
			destinationTerminator(ArrowBuilder.create().filled().small().build()).
			build();
	private static StandaloneQuery cneQuery = StandaloneQuery.create((rootQuery) -> rootQuery.descendantsByBusinessObjectsRelativeReference((ContainedNamedElement cne) -> getBusinessObjectsPath(cne)).first());
	private static StandaloneQuery partialCneQuery = StandaloneQuery.create((rootQuery) -> rootQuery.descendantsByBusinessObjectsRelativeReference((ContainedNamedElement cne) -> getBusinessObjectsPath(cne), 1).first());
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) PropertyResultValue prv) {
		return true;
	}
	
	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final @Named(Names.BUSINESS_OBJECT) PropertyResultValue prv,
			final QueryService queryService) {
		final boolean isReference = prv.getValue() instanceof ReferenceValueWithContext;
		
		if(isReference || prv.getArrayIndices().size() == 0) {
			if(isReference) {
				final ReferenceValueWithContext rvc = (ReferenceValueWithContext)prv.getValue();
				boolean showAsConnection = true;
				// Get the queryable
				BusinessObjectContext tmp = boc;
				for(int i = 0; i <= rvc.ownerAncestorLevel; i++) { // Iterate ownerAncestorLevel+1 times since we need to navigate to the property owner
					tmp = tmp.getParent();
					if(tmp == null) {
						showAsConnection = false;
						break;
					}
				}
				
				// TODO: Does the DefaultTreeExpander even need to retrieve these results if we are showing the full list
				// BOH will decide whether to show it as connection or not.
				final BusinessObjectContext dst = queryService.getFirstResult(partialCneQuery, tmp, rvc.referenceValue);
				if(dst == null) {
					showAsConnection = false;
				}				

				if(showAsConnection) {
					final BusinessObjectContext referencedQueryable = queryService.getFirstResult(cneQuery, tmp, rvc.referenceValue);
					final boolean partial = dst != referencedQueryable || containsArrayElementReference(rvc.referenceValue);
					return GraphicalConfigurationBuilder.create().
							graphic(partial ? partialGraphic : referenceGraphic).
							source(boc.getParent()).
							destination(dst).
							build();
				} else {
					return createTextGraphicalConfiguration();
				}				
			} else {			
				return createTextGraphicalConfiguration();
			}
		}
		
		return null;
	}
	
	private GraphicalConfiguration createTextGraphicalConfiguration() {
		return GraphicalConfigurationBuilder.create().
				graphic(labelGraphic).
				decoration().
				build();
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final @Named(Names.BUSINESS_OBJECT) PropertyResultValue prv) {
		return PropertyValueFormatter.getUserString(boc.getParent(), prv, false);
	}
	
	private static boolean containsArrayElementReference(final ContainedNamedElement cne) {
		if(cne == null) {
			return false;
		}
		
		for(ContainmentPathElement pathElement = cne.getPath(); pathElement != null; pathElement = pathElement.getPath()) {
			if(pathElement.getArrayRanges() != null && pathElement.getArrayRanges().size() > 0) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Gets an array of business objects which describes the logical diagram element path to a contained named element
	 * Ignores array references
	 * @param ctx
	 * @param cne
	 * @return
	 */
	private static Object[] getBusinessObjectsPath(final ContainedNamedElement cne) {
		if(cne == null) {
			return null;
		}
		
		final List<Object> path = new ArrayList<>();
		for(ContainmentPathElement pathElement = cne.getPath(); pathElement != null; pathElement = pathElement.getPath()) {
			path.add(pathElement.getNamedElement());
		}
		
		return path.toArray();
	}
}
