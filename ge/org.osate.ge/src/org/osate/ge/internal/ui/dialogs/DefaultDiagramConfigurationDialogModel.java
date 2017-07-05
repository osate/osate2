package org.osate.ge.internal.ui.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.BuiltinContentsFilter;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.ContentsFilter;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.model.PropertyResultValue;
import org.osate.ge.internal.model.Tag;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.ui.util.ImageUiHelper;
import org.osate.ge.internal.util.BusinessObjectContextHelper;
import org.osate.ge.internal.util.BusinessObjectProviderHelper;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.internal.util.StringUtil;

public class DefaultDiagramConfigurationDialogModel implements DiagramConfigurationDialog.Model, AutoCloseable {
	private final ProjectReferenceService referenceService;
	private final ExtensionService extService;
	private final ProjectProvider projectProvider;
	private final BusinessObjectProviderHelper bopHelper;
	private final BusinessObjectContextHelper bocHelper;

	public DefaultDiagramConfigurationDialogModel(final ProjectReferenceService referenceService,
			final ExtensionService extService,
			final ProjectProvider projectProvider) {
		this.referenceService = Objects.requireNonNull(referenceService, "referenceService must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.projectProvider = Objects.requireNonNull(projectProvider, "projectProvider must not be null");
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
	public Collection<Object> getChildBusinessObjects(final BusinessObjectContext boc) {
		return bopHelper.getChildBusinessObjects(boc);
	}
	
	@Override
	public String getName(final BusinessObjectContext boc) {
		// Build a prefix based on the business object type
		final Object bo = boc.getBusinessObject();
		final String prefix;
		if(bo instanceof EObject) {
			prefix = StringUtil.camelCaseToUser(((EObject)bo).eClass().getName()) + " ";
		} else if(bo instanceof Tag) {
			prefix = "Misc ";
		} else {
			prefix ="";
		}
		
		// Call the business object handler's GetName method
		final Object boh = extService.getApplicableBusinessObjectHandler(bo);
		
		String baseName = bocHelper.getName(boc, boh);
		if(baseName == null) {
			if(bo instanceof NamedElement) {
				baseName = ((NamedElement) bo).getName();
			} 
			
			if(baseName == null) {
				return "<Unnamed " + bo.getClass() + ">";
			} else {
				return baseName;
			}
		}
		
		return prefix + baseName;
	}

	@Override
	public Collection<ContentsFilter> getContentsFilters() {
		return Arrays.asList(BuiltinContentsFilter.values());
	}
	
	@Override
	public ContentsFilter getDefaultContentsFilter(final Object bo) {
		return BuiltinContentsFilter.getDefault(bo);
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
	public boolean showBusinessObject(final Object bo) {
		return !(BuiltinContentsFilter.ALLOW_FUNDAMENTAL.test(bo) || bo instanceof PropertyResultValue);
	}

	@Override
	public Image getImage(final Object bo) {
		return ImageUiHelper.getImage(bo);
	}
}
