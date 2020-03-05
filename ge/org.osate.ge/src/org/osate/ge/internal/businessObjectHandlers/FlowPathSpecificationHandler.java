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

import java.util.List;

import javax.inject.Named;

import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.Categories;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.BuildCreateOperation;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.graphics.AadlGraphics;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.AadlInheritanceUtil;
import org.osate.ge.internal.util.EditingUtil;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class FlowPathSpecificationHandler extends FlowSpecificationHandler {
	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference((FlowSpecification fs) -> getBusinessObjectsPathToFlowEnd(fs.getAllInEnd())).first());
	private static StandaloneQuery partialSrcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference((FlowSpecification fs) -> getBusinessObjectsPathToFlowEnd(fs.getAllInEnd()), 1).first());
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference((FlowSpecification fs) -> getBusinessObjectsPathToFlowEnd(fs.getAllOutEnd())).first());
	private static StandaloneQuery partialDstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().descendantsByBusinessObjectsRelativeReference((FlowSpecification fs) -> getBusinessObjectsPathToFlowEnd(fs.getAllOutEnd()), 1).first());

	// Basics
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs) {
		return fs.getKind() == FlowKind.PATH;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(
			final @Named(Names.BUSINESS_OBJECT) FlowSpecification fs,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final QueryService queryService) {
		BusinessObjectContext src = queryService.getFirstResult(srcQuery, boc);
		BusinessObjectContext dst = queryService.getFirstResult(dstQuery, boc);
		boolean partial = false;

		if(src == null) {
			src = queryService.getFirstResult(partialSrcQuery, boc);
			partial = true;
		}

		if(dst == null) {
			dst = queryService.getFirstResult(partialDstQuery, boc);
			partial = true;
		}

		final StyleBuilder sb = StyleBuilder
				.create(AadlInheritanceUtil.isInherited(boc) ? Styles.INHERITED_ELEMENT : Style.EMPTY)
				.lineWidth(4.0).
				backgroundColor(Color.BLACK);

		if (partial) {
			sb.dotted();
		}

		return GraphicalConfigurationBuilder.create().
				graphic(AadlGraphics.getFlowSpecificationGraphic(fs))
				.style(sb.build()).
				source(src).
				destination(dst).
				build();
	}

	// Creating
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		if (!BusinessObjectHandlerUtil.diagramSupportsPackageOrClassifiers(diagramBo)) {
			return null;
		}

		return new PaletteEntry[] {
				PaletteEntryBuilder.create().connectionCreation().label("Flow Path Specification")
				.icon(ImageHelper.getImage("FlowPath")).category(Categories.FLOWS).context(FlowKind.PATH)
				.build(),
		};
	}

	@CanStartConnection
	public boolean canStartConnection(@Named(Names.SOURCE_BO) final Feature srcFeature,
			@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc,
			final @Named(Names.PALETTE_ENTRY_CONTEXT) FlowKind flowKind,
			final QueryService queryService) {
		if(flowKind != FlowKind.PATH) {
			return false;
		}

		return isValidFlowEnd(srcFeature, srcBoc, DirectionType.IN, queryService);
	}

	@CanCreate
	public boolean canCreate(@Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext srcBoc,
			@Named(Names.DESTINATION_BO) final Feature dstFeature,
			@Named(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext dstBoc,
			final QueryService queryService) {

		final List<ComponentType> potentialOwners = getPotentialOwners(srcBoc, dstBoc, queryService);
		if (potentialOwners.size() == 0) {
			return false;

		}
		return isValidFlowEnd(dstFeature, dstBoc, DirectionType.OUT, queryService);
	}

	private List<ComponentType> getPotentialOwners(final BusinessObjectContext srcBoc,
			final BusinessObjectContext dstBoc, final QueryService queryService) {
		final List<ComponentType> potentialOwners = getPotentialOwnersByFeature(srcBoc, queryService);
		potentialOwners.retainAll(getPotentialOwnersByFeature(dstBoc, queryService));
		return potentialOwners;
	}

	@BuildCreateOperation
	public Operation buildCreateOperation(final @Named(Names.SOURCE_BO) Feature srcFeature,
			final @Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext srcBoc,
			final @Named(Names.DESTINATION_BO) Feature dstFeature,
			final @Named(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext dstBoc,
			final QueryService queryService,
			final NamingService namingService) {
		final BusinessObjectContext container = getFlowSpecificationOwnerBoc(srcBoc, queryService);
		if (container == null) {
			return null;
		}

		return Operation.create(createOp -> {
			EditingUtil.selectClassifier(createOp, getPotentialOwners(srcBoc, dstBoc, queryService))
			.modifyPreviousResult(ct -> {
				final FlowSpecification fs = ct.createOwnedFlowSpecification();
				fs.setKind(FlowKind.PATH);
				fs.setName(getNewFlowSpecificationName(ct, namingService));

				// Create the flow ends
				final FlowEnd inFlowEnd = fs.createInEnd();
				inFlowEnd.setFeature(srcFeature);
				inFlowEnd.setContext(getContext(srcBoc, queryService));

				final FlowEnd outFlowEnd = fs.createOutEnd();
				outFlowEnd.setFeature(dstFeature);
				outFlowEnd.setContext(getContext(dstBoc, queryService));

				ct.setNoFlows(false);

				return StepResultBuilder.create().showNewBusinessObject(container, fs).build();
			});
		});
	}
}
