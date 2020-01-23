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
package org.osate.ge.internal.ui.dialogs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.ContentFilter;
import org.osate.ge.DiagramType;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.filtering.Filtering;
import org.osate.ge.internal.model.BusinessObjectProxy;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.ui.util.ImageUiHelper;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.internal.util.BusinessObjectContextHelper;
import org.osate.ge.internal.util.BusinessObjectProviderHelper;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.internal.util.StringUtil;

import com.google.common.collect.ImmutableSet;

public class DefaultDiagramConfigurationDialogModel implements DiagramConfigurationDialog.Model, AutoCloseable {
	private final ProjectReferenceService referenceService;
	private final ExtensionService extService;
	private final ProjectProvider projectProvider;
	private final DiagramType diagramType;
	private final BusinessObjectProviderHelper bopHelper;
	private final BusinessObjectContextHelper bocHelper;

	public DefaultDiagramConfigurationDialogModel(final ProjectReferenceService referenceService,
			final ExtensionService extService,
			final ProjectProvider projectProvider,
			final DiagramType diagramType) {
		this.referenceService = Objects.requireNonNull(referenceService, "referenceService must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.projectProvider = Objects.requireNonNull(projectProvider, "projectProvider must not be null");
		this.diagramType = Objects.requireNonNull(diagramType, "diagramType must not be null");
		this.bopHelper = new BusinessObjectProviderHelper(extService);
		this.bocHelper = new BusinessObjectContextHelper(extService);
	}


	@Override
	public void close() {
		bocHelper.close();
		bopHelper.close();
	}

	@Override
	public RelativeBusinessObjectReference getRelativeBusinessObjectReference(final Object bo) {
		final RelativeBusinessObjectReference result = referenceService.getRelativeReference(bo);
		return result;
	}

	@Override
	public boolean isProxy(final Object bo) {
		return bo instanceof BusinessObjectProxy;
	}

	@Override
	public Object resolve(final Object bo) {
		if (bo instanceof BusinessObjectProxy) {
			return ((BusinessObjectProxy) bo).resolve(referenceService);
		}

		return bo;
	}

	@Override
	public Collection<Object> getChildBusinessObjects(final BusinessObjectContext boc) {
		return bopHelper.getChildBusinessObjects(boc);
	}

	@Override
	public String getName(final BusinessObjectContext boc) {
		// Pad with an extra space to avoid text from being clipped.
		return UiUtil.getDescription(boc, extService, bocHelper) + " ";
	}

	@Override
	public ImmutableSet<ContentFilter> getDefaultContentFilters(final Object bo) {
		return diagramType.getApplicableDefaultContentFilters(bo, extService);
	}

	@Override
	public Map<String, Collection<String>> getAadlProperties() {
		// Retrieve properties from the EMF Index
		final Map<String, Collection<String>> result = new HashMap<>();
		for(final IEObjectDescription propDesc : ScopedEMFIndexRetrieval.getAllEObjectsByType(projectProvider.getProject(), Aadl2Factory.eINSTANCE.getAadl2Package().getProperty())) {
			final QualifiedName qn = propDesc.getQualifiedName();
			if(qn.getSegmentCount() == 2) { // Qualified property names should only have two segments.
				final String propertySetName = qn.getFirstSegment();
				final String propertyName = qn.getLastSegment();
				Collection<String> propertySetProperties = result.get(propertySetName);
				if(propertySetProperties == null) {
					propertySetProperties = new ArrayList<>();
					result.put(propertySetName, propertySetProperties);
				}

				propertySetProperties.add(propertyName);
			}
		}
		return result;
	}

	@Override
	public Object getBusinessObject(final CanonicalBusinessObjectReference ref) {
		return referenceService.resolve(ref);
	}

	@Override
	public String getContextDescription(final Object contextBo) {
		if(contextBo instanceof NamedElement) {
			final NamedElement ne = (NamedElement)contextBo;
			return ne.getQualifiedName() + " (" + StringUtil.camelCaseToUser(ne.eClass().getName()) + ")";
		} else {
			// Create a business object context and use getName() to return the type.
			return getName(new BusinessObjectContext() {
				@Override
				public Collection<? extends Queryable> getChildren() {
					return Collections.emptyList();
				}

				@Override
				public BusinessObjectContext getParent() {
					return null;
				}

				@Override
				public Object getBusinessObject() {
					return contextBo;
				}
			});
		}
	}

	@Override
	public boolean shouldShowBusinessObject(final Object bo) {
		return Filtering.isConfigurable(extService, bo);
	}

	@Override
	public Image getImage(final Object bo) {
		return ImageUiHelper.getImage(bo);
	}
}
