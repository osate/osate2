package org.osate.ge.internal.diagram.updating;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetName;
import org.osate.ge.di.Names;
import org.osate.ge.internal.BusinessObjectContext;
import org.osate.ge.internal.businessObjectHandlers.BusinessObjectHandlerProvider;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.DiagramConfiguration;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ReferenceService;

// TODO: Rename
/**
 * Implementation of BusinessObjectTreeFactory which use business handlers to build the tree.
 *
 */
public class DefaultBusinessObjectTreeFactory implements BusinessObjectTreeFactory {
	private static final int MAX_DEPTH = 10;
	private final BusinessObjectHandlerProvider bohProvider;
	private final ExtensionService extService;
	private final ReferenceService refService;
	
	public DefaultBusinessObjectTreeFactory(final BusinessObjectHandlerProvider bohProvider, 
			final ExtensionService extService,
			final ReferenceService refService) {
		this.bohProvider = Objects.requireNonNull(bohProvider, "bohProvider must not be null");
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.refService = Objects.requireNonNull(refService, "refService must not be null");
	}
	
	@Override
	public BusinessObjectTree createBusinessObjectTree(final DiagramConfiguration configuration) {
		// Create nodes for each of it's children
		final List<BusinessObjectTreeNode> rootNodes = new ArrayList<>();
		
		if(configuration.getRootBoReference() != null) {
			// Get the root business object
			final Object rootBo = refService.resolve(configuration.getRootBoReference());
			if(rootBo != null) {
				// Create a business object context for the root node
				final BusinessObjectContext rootBoc = new BusinessObjectContext() {			
					@Override
					public BusinessObjectContext getParent() {
						return null;
					}
					
					@Override
					public Object getBusinessObject() {
						return rootBo;
					}
				};
		
				// Refresh Child Nodes
				final IEclipseContext eclipseCtx = extService.createChildContext();
				try {
					createNodes(eclipseCtx, rootBoc, rootNodes, 1);
				} finally {
					eclipseCtx.dispose();
				}
			}
		}
		
		// Create the tree object
		final Collection<BusinessObjectTreeNode> unmodifiableRootNodes = Collections.unmodifiableCollection(rootNodes);
		return new BusinessObjectTree() {
			@Override
			public Collection<BusinessObjectTreeNode> getRootNodes() {
				return unmodifiableRootNodes;
			}
			
		};
	}
	
	private void createNodes(final IEclipseContext eclipseCtx, 
			final BusinessObjectContext boc, 
			final Collection<BusinessObjectTreeNode> nodes,
			int depth) {
		final Object bo = boc.getBusinessObject();
		final Object boHandler = bohProvider.getApplicableBusinessObjectHandler(bo);	
		if(boHandler == null) {
			return;
		}
		
		eclipseCtx.set(Names.BUSINESS_OBJECT, bo);
		eclipseCtx.set(InternalNames.BUSINESS_OBJECT_CONTEXT, boc);
		
		final int nextDepth = depth + 1;
		if(nextDepth > MAX_DEPTH) {
			final Stream<?> childBos = (Stream<?>)ContextInjectionFactory.invoke(boHandler, GetChildren.class, eclipseCtx, null);
			if(childBos != null) {
				final Iterator<?> childIt = childBos.iterator();
			    if (childIt.hasNext()) {
			    	final Object childBo = childIt.next();
			    	
			    	// Create node
					final RelativeBusinessObjectReference relReference = Objects.requireNonNull(refService.getRelativeReference(childBo), "Unable to build relative reference for " + childBo);
					final CanonicalBusinessObjectReference canonicalReference = Objects.requireNonNull(refService.getCanonicalReference(childBo), "Unable to build canonical reference for " + childBo);
					final String name = (String)ContextInjectionFactory.invoke(boHandler, GetName.class, eclipseCtx, null);
					
			    	final SimpleBusinessObjectTreeNode childNode = new SimpleBusinessObjectTreeNode(boc, childBo, relReference, canonicalReference, name);
			    	nodes.add(childNode);
			    	
			    	// Populate Children
			    	createNodes(eclipseCtx, childNode, childNode.children, nextDepth);
			    }					    
			}
		}
	}
		
	private static class SimpleBusinessObjectTreeNode implements BusinessObjectTreeNode, BusinessObjectContext {
		private final BusinessObjectContext parentBoc;
		private final Object bo;
		private final RelativeBusinessObjectReference relReference;
		private final CanonicalBusinessObjectReference canonicalReference;
		private final String name;
		private final Collection<BusinessObjectTreeNode> children = new ArrayList<>();
		private final Collection<BusinessObjectTreeNode> unmodifiableChildren = Collections.unmodifiableCollection(children);
		
		public SimpleBusinessObjectTreeNode(final BusinessObjectContext parentBoc, 
				final Object bo,
				final RelativeBusinessObjectReference relReference,
				final CanonicalBusinessObjectReference canonicalReference,
				final String name) {
			this.parentBoc = Objects.requireNonNull(parentBoc, "parentBoc must not be null");
			this.bo = Objects.requireNonNull(bo, "bo must not be null");
			this.relReference = Objects.requireNonNull(relReference, "relReference must not be null");
			this.canonicalReference = Objects.requireNonNull(canonicalReference, "canonicalReference must not be null");
			this.name = name;
		}
		
		@Override
		public BusinessObjectContext getParent() {
			return parentBoc;
		}

		@Override
		public Object getBusinessObject() {
			return bo;
		}

		@Override
		public RelativeBusinessObjectReference getRelativeReference() {
			return relReference;
		}

		@Override
		public CanonicalBusinessObjectReference getCanonicalReference() {
			return canonicalReference;
		}

		@Override
		public Collection<BusinessObjectTreeNode> getChildren() {
			return unmodifiableChildren;
		}

		@Override
		public String getName() {
			return name;
		}		
	};
}
