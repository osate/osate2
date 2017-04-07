package org.osate.ge.internal.businessObjectHandlers;

import java.util.ArrayList;
import java.util.List;

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
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowSpecification;
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
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.GetName;
import org.osate.ge.di.Names;
import org.osate.ge.di.SetName;
import org.osate.ge.di.ValidateName;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.di.CanRename;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.RefactoringService;
import org.osate.ge.internal.util.AadlFeatureUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

class FlowSpecificationHandler {
	private static final StandaloneQuery componentTypeQuery = StandaloneQuery.create((root) -> root.ancestors().first(2).filter((fa) -> fa.getBusinessObject() instanceof ComponentType).first());
	private static final StandaloneQuery contextQuery = StandaloneQuery.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof Context).first());
	
	// Basics
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs) {
		return fs.getName();
	}

	// Rename and Editing
	@CanRename
	@CanDelete
	public boolean canEdit(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs, final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc, final QueryService queryService) {
		final Object containerBo = queryService.getFirstBusinessObject(componentTypeQuery, boc);
		return fs.getContainingClassifier() == containerBo;
	}
	
	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs, final @Named(Names.NAME) String value, final NamingService namingService) {
		return namingService.checkNameValidity(fs, value);
	}
	
	@SetName
	public void setName(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs, final @Named(Names.NAME) String value, final RefactoringService refactoringService) {
		refactoringService.renameElement(fs, value);
	}
	
	// Helper functions
	protected static boolean canOwnFlowSpecification(final Object bo) {
		return bo instanceof ThreadGroupType || 
				bo instanceof ThreadType || 
				bo instanceof VirtualProcessorType || 
				bo instanceof ProcessType ||
				bo instanceof DeviceType ||
				bo instanceof AbstractType ||
				bo instanceof ProcessorType ||
				bo instanceof DataType ||
				bo instanceof SystemType ||
				bo instanceof SubprogramType ||
				bo instanceof SubprogramGroupType;
	}
	
	protected static String getNewFlowSpecificationName(final ComponentType ct, final NamingService namingService) {
		return namingService.buildUniqueIdentifier(ct, "new_flow_spec");		
	}
	
	protected static Context getContext(final BusinessObjectContext featureBoc, final QueryService queryService) {
		return (Context)queryService.getFirstBusinessObject(contextQuery, featureBoc);
	}
	
	protected static ComponentType getComponentTypeByFeature(BusinessObjectContext featureBoc,
			final QueryService queryService) {
		return (ComponentType)queryService.getFirstBusinessObject(componentTypeQuery, featureBoc);
	}

	/**
	 * Returns whether a specified feature diagram element may be used as a flow end for a flow specification.
	 * feature, its direction must be IN OUT or match the specified direction
	 */
	protected static boolean isValidFlowEnd(final Feature feature,
			final BusinessObjectContext featureBoc, 
			final DirectionType requiredDirection, 
			final QueryService queryService) {
		// Ensure that the feature is contained in a component type
		if(getComponentTypeByFeature(featureBoc, queryService) == null) {
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
	 			if(AadlFeatureUtil.isFeatureInverted(featureBoc)) {
	 				direction = (direction == DirectionType.IN) ? DirectionType.OUT : DirectionType.IN;
	 			}
	 		}	
	 		
 			if(direction != requiredDirection && direction != DirectionType.IN_OUT) {
 				return false;
 			}
		}
		
		return true;
	}
	
	/**
	 * Gets an array of business objects which describes the logical diagram element path to the flow end.
	 * @param ctx
	 * @param flowEnd
	 * @return
	 */
	protected static Object[] getBusinessObjectsPathToFlowEnd(final FlowEnd flowEnd) {
		if(flowEnd == null || flowEnd.getFeature() == null) {
			return null;
		}
		
		final List<Object> path = new ArrayList<>(2);
		if(flowEnd.getContext() != null) {
			path.add(flowEnd.getContext());
		}
		
		path.add(flowEnd.getFeature());

		return path.toArray();
	}
}
