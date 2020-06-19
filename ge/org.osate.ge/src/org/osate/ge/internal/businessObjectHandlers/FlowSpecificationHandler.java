/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.businessObjectHandlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Named;

import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataType;
import org.osate.aadl2.DeviceType;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.Port;
import org.osate.aadl2.ProcessType;
import org.osate.aadl2.ProcessorType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramGroupType;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.ThreadGroupType;
import org.osate.aadl2.ThreadType;
import org.osate.aadl2.VirtualProcessorType;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanRename;
import org.osate.ge.di.GetName;
import org.osate.ge.di.Names;
import org.osate.ge.di.ValidateName;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.AadlFeatureUtil;
import org.osate.ge.internal.util.EditingUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

class FlowSpecificationHandler {
	private static final StandaloneQuery componentClassifierOrSubcomponentQuery = StandaloneQuery.create(
			(root) -> root.ancestors().first(2).filter((fa) -> fa.getBusinessObject() instanceof ComponentClassifier
					|| fa.getBusinessObject() instanceof Subcomponent).first());
	private static final StandaloneQuery contextQuery = StandaloneQuery
			.create((root) -> root.ancestors().filter((fa) -> fa.getBusinessObject() instanceof FeatureGroup).first());

	// Basics
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs) {
		return fs.getName();
	}

	@CanRename
	@CanDelete
	public boolean canEdit(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs) {
		return true;
	}

	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs,
			final @Named(Names.NAME) String value, final NamingService namingService) {
		return namingService.checkNameValidity(fs, value);
	}

	// Helper functions
	protected static boolean canOwnFlowSpecification(final Object bo) {
		return bo instanceof ThreadGroupType || bo instanceof ThreadType || bo instanceof VirtualProcessorType
				|| bo instanceof ProcessType || bo instanceof DeviceType || bo instanceof AbstractType
				|| bo instanceof ProcessorType || bo instanceof DataType || bo instanceof SystemType
				|| bo instanceof SubprogramType || bo instanceof SubprogramGroupType;
	}

	protected static String getNewFlowSpecificationName(final ComponentType ct, final NamingService namingService) {
		return namingService.buildUniqueIdentifier(ct, "new_flow_spec");
	}

	protected static Context getContext(final BusinessObjectContext featureBoc, final QueryService queryService) {
		return (Context) queryService.getFirstBusinessObject(contextQuery, featureBoc);
	}

	protected static List<ComponentType> getPotentialOwnersByFeature(BusinessObjectContext featureBoc,
			final QueryService queryService) {
		final Context context = getContext(featureBoc, queryService);
		final Feature feature = (Feature) featureBoc.getBusinessObject();
		final String childName = context == null ? feature.getName() : context.getName();
		if (childName == null) {
			return Collections.emptyList();
		}

		final BusinessObjectContext containerBoc = getFlowSpecificationOwnerBoc(featureBoc, queryService);
		if (containerBoc == null) {
			return Collections.emptyList();
		}
		final Element bo = (Element) containerBoc.getBusinessObject();

		return EditingUtil.getPotentialClassifierTypesForEditing(bo).stream()
				.filter(tmpBo -> canOwnFlowSpecification(tmpBo)).map(ComponentType.class::cast)
				.filter(ct -> hasFeatureWithName(ct, childName)).collect(Collectors.toList());
	}

	private static boolean hasFeatureWithName(final ComponentType ct, final String nameToCheck) {
		return ct.getAllFeatures().stream().map(f -> f.getName()).anyMatch(n -> nameToCheck.equalsIgnoreCase(n));
	}

	/**
	 * Get the business object context for the container/owner of a flow specification involving the specified feature
	 * @param featureBoc
	 * @param queryService
	 * @return
	 */
	protected static BusinessObjectContext getFlowSpecificationOwnerBoc(BusinessObjectContext featureBoc,
			final QueryService queryService) {
		return queryService.getFirstResult(componentClassifierOrSubcomponentQuery, featureBoc);
	}

	/**
	 * Returns whether a specified feature diagram element may be used as a flow end for a flow specification.
	 * feature, its direction must be IN OUT or match the specified direction
	 */
	protected static boolean isValidFlowEnd(final Feature feature, final BusinessObjectContext featureBoc,
			final DirectionType requiredDirection, final QueryService queryService) {
		// Ensure that the feature is contained in a component type
		if (getPotentialOwnersByFeature(featureBoc, queryService).size() == 0) {
			return false;
		}

		// Check that the feature is of the appropriate type
		if (!(feature instanceof Port || feature instanceof Parameter || feature instanceof DataAccess
				|| feature instanceof FeatureGroup || feature instanceof AbstractFeature)) {
			return false;
		}

		// If it is a direct feature, it must have the specified direction or be an in out feature. Take into account feature group, inverse, etc..
		if (feature instanceof DirectedFeature) {
			// Determine the actual direction of the feature. Since it could effected by things like inverse feature groups, etc
			final DirectedFeature df = (DirectedFeature) feature;
			DirectionType direction = df.getDirection();
			if (direction == DirectionType.IN || direction == DirectionType.OUT) {
				if (AadlFeatureUtil.isFeatureInverted(featureBoc)) {
					direction = (direction == DirectionType.IN) ? DirectionType.OUT : DirectionType.IN;
				}
			}

			if (direction != requiredDirection && direction != DirectionType.IN_OUT) {
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
		if (flowEnd == null || flowEnd.getFeature() == null) {
			return null;
		}

		final List<Object> path = new ArrayList<>(2);
		if (flowEnd.getContext() != null) {
			path.add(flowEnd.getContext());
		}

		path.add(flowEnd.getFeature());

		return path.toArray();
	}
}
