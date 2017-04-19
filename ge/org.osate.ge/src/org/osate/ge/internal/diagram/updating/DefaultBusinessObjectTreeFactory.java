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
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetName;
import org.osate.ge.di.Names;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.DiagramConfiguration;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ReferenceService;

/**
 * Implementation of BusinessObjectTreeFactory which use business handlers to build the tree.
 *
 */
public class DefaultBusinessObjectTreeFactory implements BusinessObjectTreeFactory {
	private static final int MAX_DEPTH = 10;
	private final ExtensionService extService;
	private final ReferenceService refService;
	
	public DefaultBusinessObjectTreeFactory(final ExtensionService extService,
			final ReferenceService refService) {
		this.extService = Objects.requireNonNull(extService, "extService must not be null");
		this.refService = Objects.requireNonNull(refService, "refService must not be null");
	}
	
	@Override
	public BusinessObjectTree createBusinessObjectTree(final DiagramConfiguration configuration) {
		// Create nodes for each of it's children
		final List<BusinessObjectTreeNode> rootNodes = new ArrayList<>();
		if(configuration.getRootBoReference() != null) {
			// Get the root business object
			Object rootBo = refService.resolve(configuration.getRootBoReference());
			// TODO: How to handle not finding the root reference?
			if(rootBo != null) {		
				// Refresh Child Nodes
				final IEclipseContext eclipseCtx = extService.createChildContext();
				try {
					createNode(eclipseCtx, 
							null,
							rootBo,
							rootNodes,
							1);
				} finally {
					eclipseCtx.dispose();
				}
			}
		}
		
		// Create the tree object
		final SimpleBusinessObjectTree tree = new SimpleBusinessObjectTree(rootNodes);
		return tree;
	}
	
	private void createNode(final IEclipseContext eclipseCtx, 
			final BusinessObjectContext parentBoc, 
			final Object bo,
			final Collection<BusinessObjectTreeNode> nodes,
			int depth) {    	
    	// Create node	
		final RelativeBusinessObjectReference relReference = Objects.requireNonNull(refService.getRelativeReference(bo), "Unable to build relative reference for " + bo);
		final CanonicalBusinessObjectReference canonicalReference = Objects.requireNonNull(refService.getCanonicalReference(bo), "Unable to build canonical reference for " + bo);
		final Object boHandler = extService.getApplicableBusinessObjectHandler(bo);
		if(boHandler == null) {
			throw new RuntimeException("Unable to retrieve business object handler for " + bo);
		}
				
		// Create the node
    	final SimpleBusinessObjectTreeNode childNode = new SimpleBusinessObjectTreeNode(parentBoc, bo, relReference, canonicalReference, boHandler);
    	nodes.add(childNode);
    	
		// Populate the context
		eclipseCtx.set(Names.BUSINESS_OBJECT, bo);
		eclipseCtx.set(Names.BUSINESS_OBJECT_CONTEXT, childNode);
		
    	// Set the name
    	childNode.name = (String)ContextInjectionFactory.invoke(boHandler, GetName.class, eclipseCtx, null);
    	
    	// Populate Children
    	final int nextDepth = depth + 1;
    	if(nextDepth <= MAX_DEPTH) {
    		createNodesForChildren(eclipseCtx, boHandler, childNode, childNode.children, nextDepth);
    	}
	}
	
	/**
	 * 
	 * @param eclipseCtx must be populated with the fields for the parent to allow retrieving of children.
	 * @param boHandler
	 * @param parentBoc
	 * @param nodes
	 * @param depth
	 */
	private void createNodesForChildren(final IEclipseContext eclipseCtx, 
			final Object boHandler,
			final BusinessObjectContext parentBoc,
			final Collection<BusinessObjectTreeNode> nodes,
			int depth) {
		final Stream<?> childBos = (Stream<?>)ContextInjectionFactory.invoke(boHandler, GetChildren.class, eclipseCtx, null);
		if(childBos != null) {
			final Iterator<?> childIt = childBos.iterator();
		    while(childIt.hasNext()) {
		    	final Object childBo = childIt.next();
		    	createNode(eclipseCtx, parentBoc, childBo, nodes, depth);
		    }					    
		}
	}
	
	private static class SimpleBusinessObjectTree implements BusinessObjectTree, Queryable {
		private final Collection<BusinessObjectTreeNode> rootNodes;
		
		public SimpleBusinessObjectTree(final Collection<BusinessObjectTreeNode> rootNodes) {
			this.rootNodes = Collections.unmodifiableCollection(rootNodes);
		}
		
		@Override
		public Queryable getParent() {
			return null;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Collection<? extends Queryable> getChildren() {
			return (Collection<? extends Queryable>) getRootNodes();
		}

		@Override
		public Object getBusinessObject() {
			return null;
		}

		@Override
		public Collection<BusinessObjectTreeNode> getRootNodes() {
			return rootNodes;
		}
		
	}
		
	private static class SimpleBusinessObjectTreeNode implements BusinessObjectTreeNode, BusinessObjectContext {
		private final BusinessObjectContext parentBoc;
		private final Object bo;
		private final RelativeBusinessObjectReference relReference;
		private final CanonicalBusinessObjectReference canonicalReference;
		private final Object boHandler;
		private String name;
		private final Collection<BusinessObjectTreeNode> children = new ArrayList<>();
		private final Collection<?> unmodifiableChildren = Collections.unmodifiableCollection(children);
		
		public SimpleBusinessObjectTreeNode(final BusinessObjectContext parentBoc, 
				final Object bo,
				final RelativeBusinessObjectReference relReference,
				final CanonicalBusinessObjectReference canonicalReference,
				final Object boHandler) {
			this.parentBoc = parentBoc;
			this.bo = Objects.requireNonNull(bo, "bo must not be null");
			this.relReference = Objects.requireNonNull(relReference, "relReference must not be null");
			this.canonicalReference = Objects.requireNonNull(canonicalReference, "canonicalReference must not be null");
			this.boHandler = Objects.requireNonNull(boHandler, "boHandler must not be null");
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

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public Collection getChildren() {
			return (Collection<Queryable>) unmodifiableChildren;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public Object getBusinessObjectHandler() {
			return boHandler;
		}
	};
}
