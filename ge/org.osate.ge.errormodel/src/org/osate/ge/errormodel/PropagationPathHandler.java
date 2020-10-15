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
package org.osate.ge.errormodel;

import java.util.Optional;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.DockingPosition;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.GraphicalExtensionUtil;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.CanCopyContext;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.CanRenameContext;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.businessobjecthandling.RenameContext;
import org.osate.ge.errormodel.util.ErrorModelNamingUtil;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.query.QueryResult;
import org.osate.ge.query.StandaloneQuery;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint;

public class PropagationPathHandler implements BusinessObjectHandler {
	private static final Graphic graphic = ConnectionBuilder.create().build();

	// Assumes root is the containing classifier
	private static StandaloneQuery propagationPointQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.descendantsByBusinessObjectsRelativeReference(
					(QualifiedPropagationPoint p) -> getBusinessObjectPath(p), 1).first());

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(PropagationPath.class).filter(bo -> bo.getContainingClassifier() != null)
				.isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final PropagationPath bo = ctx.getBusinessObject(PropagationPath.class).get();
		return new CanonicalBusinessObjectReference(ErrorModelReferenceUtil.TYPE_PROPAGATION_PATH,
				ctx.getReferenceBuilder().getCanonicalReference(bo.getContainingClassifier()).encode(), bo.getName());
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		return ErrorModelReferenceUtil
				.getRelativeReferenceForPropagationPath(ctx.getBusinessObject(PropagationPath.class).get().getName());
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return true;
	}

	@Override
	public boolean canCopy(final CanCopyContext ctx) {
		return false;
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final PropagationPath bo = ctx.getBusinessObjectContext().getBusinessObject(PropagationPath.class).get();
		final BusinessObjectContext classifierBoc = ctx.getBusinessObjectContext().getParent();
		if (classifierBoc == null) {
			return Optional.empty();
		}

		// Determine source and destination of the connection
		final QueryResult src = ctx.getQueryService().getFirstResult(propagationPointQuery, classifierBoc, bo.getSource()).orElse(null);
		final QueryResult dst = ctx.getQueryService().getFirstResult(propagationPointQuery, classifierBoc, bo.getTarget()).orElse(null);

		// Determine style
		final StyleBuilder sb = StyleBuilder.create(GraphicalExtensionUtil.isInherited(ctx.getBusinessObjectContext())
				? GraphicalExtensionUtil.STYLE_INHERITED_ELEMENT
				: Style.EMPTY).lineWidth(2.0);

		final boolean partial = (src != null && src.isPartial()) || (dst != null && dst.isPartial());
		if (partial) {
			sb.dotted();
		}

		return Optional.of(GraphicalConfigurationBuilder.create().graphic(graphic).style(sb.build())
				.defaultDockingPosition(DockingPosition.ANY).source(src == null ? null : src.getBusinessObjectContext())
				.destination(dst == null ? null : dst.getBusinessObjectContext()).build());
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(PropagationPath.class).map(bo -> bo.getName()).orElse("");
	}

	@Override
	public boolean canRename(final CanRenameContext ctx) {
		return true;
	}

	@Override
	public Optional<String> validateName(final RenameContext ctx) {
		return ErrorModelNamingUtil.validateSubclauseChildName(ctx);
	}

	private static Object[] getBusinessObjectPath(final QualifiedPropagationPoint p) {
		if (p == null) {
			return null;
		}

		// Determine the needed size for the array
		int count = 0;
		for (QualifiedPropagationPoint t = p; t != null; t = t.getNext()) {
			if ((t.getSubcomponent() == null || t.getSubcomponent().getSubcomponent() == null)
					&& t.getPropagationPoint() == null) {
				return null;
			}
			count++;
		}

		// Populate the array with the path
		final Object[] path = new Object[count];
		int index = 0;
		for (QualifiedPropagationPoint t = p; t != null; t = t.getNext()) {
			path[index++] = t.getSubcomponent() == null ? t.getPropagationPoint()
					: t.getSubcomponent().getSubcomponent();
		}

		return path;
	}
}
