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
