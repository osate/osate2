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
package org.osate.ge.aadl2.internal;

import java.util.Optional;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;

public class ComponentInstanceHandler extends AadlBusinessObjectHandler {
	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(ComponentInstance.class).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final ComponentInstance bo = ctx.getBusinessObject(ComponentInstance.class).get();
		final String systemInstanceKey = AadlReferenceUtil.getSystemInstanceKey(bo);
		if (bo instanceof SystemInstance) {
			return AadlReferenceUtil.getCanonicalBusinessObjectReferenceForSystemInstance(systemInstanceKey);
		} else {
			return new CanonicalBusinessObjectReference(
					AadlReferenceUtil.INSTANCE_ID,
					AadlReferenceUtil.COMPONENT_INSTANCE_KEY,
					systemInstanceKey,
					bo.getInstanceObjectPath());
		}
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		final Object bo = ctx.getBusinessObject();
		if (bo instanceof SystemInstance) {
			return AadlReferenceUtil.getRelativeBusinessObjectReferenceForSystemInstance(
					AadlReferenceUtil.getSystemInstanceKey((SystemInstance) bo));
		} else {
			return new RelativeBusinessObjectReference(AadlReferenceUtil.INSTANCE_ID,
					AadlReferenceUtil.COMPONENT_INSTANCE_KEY, ((ComponentInstance) bo).getFullName());
		}
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final ComponentInstance ci = ctx.getBusinessObjectContext().getBusinessObject(ComponentInstance.class).get();
		return Optional.of(GraphicalConfigurationBuilder
				.create().graphic(AadlGraphics.getGraphic(ci.getCategory())).style(AadlGraphics
						.getStyle(ci.getCategory(), ci.getComponentClassifier() instanceof ComponentImplementation))
				.build());
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(ComponentInstance.class).map(ci -> ci.getFullName()).orElse("");
	}
}
