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
// Based on OSATE Graphical Editor. Modifications are:
/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data,
including any software or models in source or binary form, as well as any drawings, specifications,
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
 */
/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.osate.ge.BusinessObjectProvider;
import org.osate.ge.ContentFilter;
import org.osate.ge.DiagramType;
import org.osate.ge.FundamentalContentFilter;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.util.EclipseExtensionUtil;
import org.osate.ge.palette.PaletteCategory;
import org.osate.ge.palette.PaletteContributor;
import org.osate.ge.palette.internal.PaletteContributorRegistry;
import org.osate.ge.ui.TooltipContributor;
import org.osgi.framework.FrameworkUtil;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;

/**
 * Instantiates extensions which are registered via extension points.
 */
public class DefaultExtensionRegistryService implements ExtensionRegistryService {
	public static class ContextFunction extends SimpleServiceContextFunction<ExtensionRegistryService> {
		@Override
		public ExtensionRegistryService createService(final IEclipseContext context) {
			return new DefaultExtensionRegistryService();
		}
	}

	private static class PrioritizedExtensionInfo<T> {
		final private int priority;
		final private T object;

		public PrioritizedExtensionInfo(final int priority, final T object) {
			this.priority = priority;
			this.object = object;
		}

		public int getPriority() {
			return priority;
		}

		public T getObject() {
			return object;
		}
	}

	private static final String BUSINESS_OBJECT_HANDLERS_EXTENSION_POINT_ID = "org.osate.ge.businessObjectHandlers";
	private static final String TOOLTIP_EXTENSION_POINT_ID = "org.osate.ge.tooltips";
	private static final String BUSINESS_OBJECT_PROVIDERS_EXTENSION_POINT_ID = "org.osate.ge.businessObjectProviders";
	private static final String CONTENT_FILTERS_EXTENSION_POINT_ID = "org.osate.ge.contentFilters";
	private static final String DIAGRAM_TYPES_EXTENSION_POINT_ID = "org.osate.ge.diagramTypes";

	private final ImmutableList<BusinessObjectHandler> boHandlers;
	private final ImmutableList<TooltipContributor> tooltipContributors;
	private final ImmutableCollection<BusinessObjectProvider> businessObjectProviders;
	private final ImmutableCollection<ContentFilter> configurableContentFilters;
	private final ImmutableCollection<FundamentalContentFilter> fundamentalContentFilters;
	private final ImmutableCollection<DiagramType> diagramTypes;
	private final PaletteContributorRegistry paletteExtensions;

	public DefaultExtensionRegistryService() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		boHandlers = instantiatePrioritizedExtensions(registry, BUSINESS_OBJECT_HANDLERS_EXTENSION_POINT_ID, "handler",
				BusinessObjectHandler.class);
		tooltipContributors = instantiatePrioritizedExtensions(registry, TOOLTIP_EXTENSION_POINT_ID,
				"tooltipContributor", TooltipContributor.class);
		businessObjectProviders = EclipseExtensionUtil.instantiateSimpleExtensions(registry,
				BUSINESS_OBJECT_PROVIDERS_EXTENSION_POINT_ID,
				"provider", BusinessObjectProvider.class);
		configurableContentFilters = EclipseExtensionUtil.instantiateSimpleExtensions(registry,
				CONTENT_FILTERS_EXTENSION_POINT_ID,
				"contentFilter", ContentFilter.class);
		fundamentalContentFilters = EclipseExtensionUtil.instantiateSimpleExtensions(registry,
				CONTENT_FILTERS_EXTENSION_POINT_ID,
				"fundamentalContentFilter", FundamentalContentFilter.class);
		diagramTypes = EclipseExtensionUtil.instantiateSimpleExtensions(registry, DIAGRAM_TYPES_EXTENSION_POINT_ID,
				"diagramType",
				DiagramType.class);
		paletteExtensions = new PaletteContributorRegistry(registry);
	}

	@Override
	public List<BusinessObjectHandler> getBusinessObjectHandlers() {
		return boHandlers;
	}

	@Override
	public BusinessObjectHandler getApplicableBusinessObjectHandler(final Object bo) {
		if (bo == null) {
			return null;
		}

		// Don't return a handler for an EObject proxy
		if (bo instanceof EObject) {
			if (((EObject) bo).eIsProxy()) {
				return null;
			}
		}

		final IsApplicableContext ctx = new IsApplicableContext(bo);

		// Find the business object handler which is applicable for this business object
		for (final BusinessObjectHandler handler : getBusinessObjectHandlers()) {
			if (handler.isApplicable(ctx)) {
				return handler;
			}
		}

		return null;
	}

	@Override
	public List<PaletteCategory> getCategories() {
		return paletteExtensions.getCategories();
	}

	@Override
	public List<TooltipContributor> getTooltipContributors() {
		return tooltipContributors;
	}

	@Override
	public Collection<BusinessObjectProvider> getBusinessObjectProviders() {
		return businessObjectProviders;
	}

	@Override
	public ImmutableCollection<ContentFilter> getConfigurableContentFilters() {
		return configurableContentFilters;
	}

	@Override
	public ImmutableCollection<FundamentalContentFilter> getFundamentalContentFilters() {
		return fundamentalContentFilters;
	}

	@Override
	public ImmutableCollection<DiagramType> getDiagramTypes() {
		return diagramTypes;
	}

	@Override
	public ImmutableCollection<PaletteContributor> getPaletteContributors() {
		return paletteExtensions.getPaletteContributors();
	}

	// Extensions with a lower priority values are sorted so that they are earlier in the resulting collection
	private static <T> ImmutableList<T> instantiatePrioritizedExtensions(
			final IExtensionRegistry registry,
			final String extensionPointId,
			final String elementName, final Class<T> extClass) {
		final ILog logger = Platform.getLog(FrameworkUtil.getBundle(DefaultExtensionRegistryService.class));

		final ImmutableList.Builder<T> extensionListBuilder = ImmutableList.builder();
		final Comparator<PrioritizedExtensionInfo<T>> priorityComparator = (tooltipContributor1,
				tooltipContributor2) -> Integer.compare(tooltipContributor1.getPriority(),
						tooltipContributor2.getPriority());

				final IExtensionPoint extPoint = registry.getExtensionPoint(extensionPointId);
				if(extPoint != null) {
					final ArrayList<PrioritizedExtensionInfo<T>> prioritizedExtensionInfos = new ArrayList<>();
					for(final IExtension extension : extPoint.getExtensions()) {
						for(final IConfigurationElement ce : extension.getConfigurationElements()) {
							if(ce.getName().equals(elementName)) {
								final String priorityStr = ce.getAttribute("priority");
								final int priority = priorityStr == null ? Integer.MAX_VALUE : Integer.parseInt(priorityStr);
								try {
									final T contributor = extClass.cast(ce.createExecutableExtension("class"));
									final PrioritizedExtensionInfo<T> tooltipContributerInfo = new PrioritizedExtensionInfo<>(
											priority, contributor);
									prioritizedExtensionInfos.add(tooltipContributerInfo);
								} catch (final CoreException | ClassCastException e) {
									logger.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
											"Error instantiating extension", e));
								}
							}
						}
					}

					prioritizedExtensionInfos.sort(priorityComparator);
					for (final PrioritizedExtensionInfo<T> info : prioritizedExtensionInfos) {
						extensionListBuilder.add(info.getObject());
					}
				}

				return extensionListBuilder.build();
	}
}
