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
package org.osate.ge.ba.businessobjecthandlers;

import java.util.Optional;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Classifier;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.internal.AadlReferenceUtil;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.CustomDeleteContext;
import org.osate.ge.businessobjecthandling.CustomDeleter;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.Graphic;

/**
 * Business object handler for {@link BehaviorAnnex}. This handler only exists to prevent the annex from being added by the AADL
 * business object provider. Since the object isn't contributed at this time, the other methods are not necessary.
 *
 */
public class BehaviorAnnexHandler implements BusinessObjectHandler, CustomDeleter {
	private static final String TYPE_BA = "ba";
	private static final Graphic graphic = EllipseBuilder.create().build();

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(BehaviorAnnex.class).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final BehaviorAnnex ba = ctx.getBusinessObject(BehaviorAnnex.class).get();
		// TODO can BA be part of component?
		// TODO owner is DefaultSubclause
		final Classifier classifier = ba.getContainingClassifier();
		int index = classifier.getOwnedAnnexSubclauses().indexOf(ba.getOwner());
		return new CanonicalBusinessObjectReference(TYPE_BA,
				ctx.getBusinessObject(BehaviorAnnex.class).get().getQualifiedName() + index);
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		final BehaviorAnnex ba = ctx.getBusinessObject(BehaviorAnnex.class).get();
		// TODO can BA be part of component?
		// TODO owner is DefaultSubclause
		final Classifier classifier = ba.getContainingClassifier();
		int index = classifier.getOwnedAnnexSubclauses().indexOf(ba.getOwner());
		return AadlReferenceUtil.buildSimpleRelativeReference(TYPE_BA,
				ctx.getBusinessObject(BehaviorAnnex.class).get());
		/*
		 * return AadlReferenceUtil
		 * .buildSimpleRelativeReference(DeclarativeReferenceType.MODE.getId(),
		 * ctx.getBusinessObject(Mode.class).get());
		 */
	}


	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		return Optional.of(GraphicalConfigurationBuilder.create().graphic(graphic).build());
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return true;
	}

	@Override
	public String getName(final GetNameContext ctx) {
		// TODO all BA's have same name? Yes, but label could be "BA for Impl"...
		final BehaviorAnnex ba = ctx.getBusinessObject(BehaviorAnnex.class).get();
		System.err.println(ba + " ba");
		final Classifier classifier = ba.getContainingClassifier();
		System.err.println(ba.getOwner() + " owner");
		System.err.println(classifier + " classfi");
		if (classifier != null) {
			int index = classifier.getOwnedAnnexSubclauses().indexOf(ba.getOwner());
			return "BA " + Integer.toString(index);
		}

		System.err.println(ba + " removing ba");

		return "";
	}

	@Override
	public void delete(final CustomDeleteContext ctx) {
		System.err.println("DELTING");
		System.err.println(ctx.getReadonlyBoToDelete(BehaviorAnnex.class) + " readonoly");
		ctx.getReadonlyBoToDelete(BehaviorAnnex.class)
				.ifPresent(ba -> System.err.println(ba.getOwner() + " getOwneAAr"));
		System.err.println(ctx.getContainerBusinessObject(BehaviorAnnex.class) + " container");
		ctx.getContainerBusinessObject(BehaviorAnnex.class).ifPresent(das -> {
			das.getOwnedElements().forEach(e -> System.err.println(e + " EEE"));
			System.err.println(das.getOwner() + " getOwner");
			EcoreUtil.delete(das.getOwner());
			EcoreUtil.delete(das);
		});
	}
}
