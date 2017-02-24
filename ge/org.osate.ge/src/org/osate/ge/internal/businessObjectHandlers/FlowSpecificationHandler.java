package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataType;
import org.osate.aadl2.DeviceType;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.Port;
import org.osate.aadl2.ProcessType;
import org.osate.aadl2.ProcessorType;
import org.osate.aadl2.SubprogramGroupType;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.ThreadGroupType;
import org.osate.aadl2.ThreadType;
import org.osate.aadl2.VirtualProcessorType;
import org.osate.ge.Categories;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.Names;
import org.osate.ge.internal.DiagramElementProxy;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.AadlFeatureService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.util.ImageHelper;

class FlowSpecificationHandler {
	private static final StandaloneDiagramElementQuery componentTypeQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof ComponentType).first());
	private static final StandaloneDiagramElementQuery contextQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof Context).first());
	
	/*
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs) {
		return true;
	}
	*/
	
	protected static boolean canOwnFlowSpecification(final Object diagramBo) {
		return diagramBo instanceof ThreadGroupType || 
				diagramBo instanceof ThreadType || 
				diagramBo instanceof VirtualProcessorType || 
				diagramBo instanceof ProcessType ||
				diagramBo instanceof DeviceType ||
				diagramBo instanceof AbstractType ||
				diagramBo instanceof ProcessorType ||
				diagramBo instanceof DataType ||
				diagramBo instanceof SystemType ||
				diagramBo instanceof SubprogramType ||
				diagramBo instanceof SubprogramGroupType;
	}
	
	protected static String getNewFlowSpecificationName(final ComponentType ct, final NamingService namingService) {
		return namingService.buildUniqueIdentifier(ct, "new_flow_spec");		
	}
	
	protected static Context getContext(final DiagramElementProxy featureDiagramElement, final QueryService queryService) {
		return (Context)queryService.getFirstBusinessObject(contextQuery, featureDiagramElement);
	}
	
	protected static ComponentType getComponentType(final @Named(InternalNames.TARGET_DIAGRAM_ELEMENT_PROXY) DiagramElementProxy targetDiagramElement,
			final QueryService queryService) {
		return (ComponentType)queryService.getFirstBusinessObject(componentTypeQuery, targetDiagramElement);
	}	

	/**
	 * Returns whether a specified feature diagram element may be used as a flow end for a flow specification.
	 * feature, its direction must be IN OUT or match the specified direction
	 */
	protected static boolean isValidFlowEnd(final Feature feature,
			final DiagramElementProxy featureDiagramElement, 
			final DirectionType requiredDirection, 
			final AadlFeatureService featureService,
			final QueryService queryService) {
		// Ensure that the feature is contained in a component type
		if(getComponentType(featureDiagramElement, queryService) == null) {
			return false;
		}
		
		// Check that the feature is of the appropriate type
		if(!(feature instanceof Port || feature instanceof Parameter || feature instanceof DataAccess || feature instanceof FeatureGroup || feature instanceof AbstractFeature)) {
			return false;
		}
		
		// If it is a direct feature, it must have the specified direction or be an in out feature. Take into account feature group, inverse, etc..
		if(feature instanceof DirectedFeature) {
			// Determine the actual direction of the feature. Since it could effected by things like inverse feature groups, etc
			final DirectedFeature df = (DirectedFeature)feature;
			DirectionType direction = df.getDirection();
	 		if(direction == DirectionType.IN || direction == DirectionType.OUT) {
	 			if(featureService.isFeatureInverted(featureDiagramElement)) {
	 				direction = (direction == DirectionType.IN) ? DirectionType.OUT : DirectionType.IN;
	 			}
	 		}	
	 		
 			if(direction != requiredDirection && direction != DirectionType.IN_OUT) {
 				return false;
 			}
		}
		
		return true;
	}
}
