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

import javax.inject.Named;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetNameForUserInterface;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.LabelBuilder;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class GeneralizatonHandler {
	private static final Graphic extendsGraphic = ConnectionBuilder.create().destinationTerminator(ArrowBuilder.create().open().build()).build();
	private static final Style extendsStyle = StyleBuilder.create().backgroundColor(Color.BLACK).build();
	private static final Graphic implementsGraphic = ConnectionBuilder.create()
			.destinationTerminator(ArrowBuilder.create().open().build()).build();
	private static final Style implementsStyle = StyleBuilder.create().backgroundColor(Color.BLACK).dashed().build();
	private static final Graphic labelGraphic = LabelBuilder.create().build();
	private static StandaloneQuery nestedClassifierQuery = StandaloneQuery.create((rootQuery) -> rootQuery.descendantsByBusinessObjectsRelativeReference((Generalization g) -> getBusinessObjectPath(g.getGeneral())));

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		return bo instanceof Realization || bo instanceof TypeExtension || bo instanceof ImplementationExtension || bo instanceof GroupExtension;
	}

	@CanDelete
	public boolean canDeleteGeneralization(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		return bo instanceof TypeExtension || bo instanceof ImplementationExtension || bo instanceof GroupExtension;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT) Object bo,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final QueryService queryService) {
		final BusinessObjectContext destination = getDestination(boc, queryService);

		if(destination == null) {
			return GraphicalConfigurationBuilder.create().
					graphic(labelGraphic).
					decoration().
					build();
		} else {
			return GraphicalConfigurationBuilder.create().
					graphic(getConnectionGraphicalRepresentation(bo)).
					style(getStyle(bo)).
					source(boc.getParent()). // Source is the owner of the BO
					destination(getDestination(boc, queryService)).
					build();
		}
	}

	private Graphic getConnectionGraphicalRepresentation(final Object bo) {
		return bo instanceof Realization ? implementsGraphic : extendsGraphic;
	}

	private Style getStyle(final Object bo) {
		return bo instanceof Realization ? implementsStyle : extendsStyle;
	}

	private BusinessObjectContext getDestination(final BusinessObjectContext boc,
			final QueryService queryService) {
		final BusinessObjectContext pkgBoc = boc.getParent().getParent();
		if(pkgBoc == null) {
			return null;
		}

		final BusinessObjectContext packageParentBoc = pkgBoc.getParent();

		// Showing generalizations as connections is only supported on diagrams which contain package symbols
		if(packageParentBoc == null) {
			return null;
		}

		return queryService.getFirstResult(nestedClassifierQuery, packageParentBoc, boc.getBusinessObject());
	}

	private static Object[] getBusinessObjectPath(final Classifier c) {
		return new Object[] { c.getElementRoot(), c };
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) Generalization generalization,
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final QueryService queryService) {
		// Don't show the name when displaying as a connection
		if(getDestination(boc, queryService) != null) {
			return null;
		}

		final Classifier general = generalization.getGeneral();
		if(general == null) {
			return null;
		}

		final Classifier specific = generalization.getSpecific();
		if (specific == null) {
			return null;
		}

		// Only show the name of the general element if both elements are in the same package.
		final String generalName;
		if (general.getElementRoot() == specific.getElementRoot()) {
			generalName = general.getName();
		} else {
			generalName = general.getQualifiedName();
		}

		return (generalization instanceof Realization ? "Implements " : "Extends ") + generalName;
	}

	@GetNameForUserInterface
	public String getNameForUi(final @Named(Names.BUSINESS_OBJECT) Generalization generalization) {
		final Classifier general = generalization.getGeneral();
		if(general == null) {
			return null;
		}

		final Classifier specific = generalization.getSpecific();
		if (specific == null) {
			return null;
		}

		// Only show the name of the general element if both elements are in the same package.
		final String generalName;
		if (general.getElementRoot() == specific.getElementRoot()) {
			generalName = general.getName();
		} else {
			generalName = general.getQualifiedName();
		}

		return (generalization instanceof Realization ? "Implements " : "Extends ") + generalName;
	}
}
