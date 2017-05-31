package org.osate.ge.internal.diagram.boTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.ContentsFilter;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;

public class BusinessObjectNode implements BusinessObjectContext {
	private BusinessObjectNode parent;
	private final RelativeBusinessObjectReference relativeReference; // May be null only for root nodes
	private Object bo; // May be null for root nodes
	private boolean manual = false; // Species whether the object was manually specified(true) or if it was created automatically based on the auto contents filter or other mechanism.
	private ContentsFilter autoContentsFilter;
	private Map<RelativeBusinessObjectReference, BusinessObjectNode> children;
	private Completeness completeness = Completeness.UNKNOWN;
	
	public BusinessObjectNode(final BusinessObjectNode parent, 
			final RelativeBusinessObjectReference relativeReference, 
			final Object bo,
			final boolean manual,
			final ContentsFilter autoContentsFilter,
			final Completeness completeness) {
		this.parent = parent;
		this.relativeReference = relativeReference;
		this.bo = bo;
		this.manual = manual;
		this.autoContentsFilter = autoContentsFilter == null ? ContentsFilter.DEFAULT : autoContentsFilter;
		this.completeness = Objects.requireNonNull(completeness, "completeness must not be null");
		
		if(parent != null) {
			parent.addChild(this);
		}
	}

	public RelativeBusinessObjectReference getRelativeReference() {
		return relativeReference;
	}
	
	@Override
	public BusinessObjectNode getParent() {
		return parent;
	}

	@Override
	public Object getBusinessObject() {
		return bo;
	}
	
	public void setBusinessObject(final Object value) {
		this.bo = value;
	}
	
	public boolean isManual() {
		return manual;
	}

	public void setManual(final boolean value) {
		this.manual = value;
	}
	
	public ContentsFilter getAutoContentsFilter() {
		return autoContentsFilter;
	}

	public Completeness getCompleteness() {
		return completeness;
	}
	
	public void setCompleteness(final Completeness value) {
		this.completeness = Objects.requireNonNull(value, "value must not be null");
	}
	
	/**
	 * Returns an unmodifiable map. Never null.
	 * @return
	 */
	public Collection<BusinessObjectNode> getChildren() {
		return children == null ? Collections.emptyList() : Collections.unmodifiableCollection(children.values());
	}
	
	/**
	 * Returns an unmodifiable map. Never null.
	 * @return
	 */
	public Map<RelativeBusinessObjectReference, BusinessObjectNode> getChildrenMap() {
		return children == null ? Collections.emptyMap() : Collections.unmodifiableMap(children);
	}
	
	public BusinessObjectNode getChild(final RelativeBusinessObjectReference ref) {
		if(children == null) {
			return null;
		}
		
		return children.get(ref);
	}
	
	private void addChild(final BusinessObjectNode node) {
		if(children == null) {
			children = new HashMap<>();
		}
		
		if(children.containsKey(node)) {
			throw new RuntimeException("Node already has a child with reference: " + node.relativeReference);
		}
		
		children.put(node.relativeReference, node);
	}
	
	/**
	 * Looks for a node in tree which has the same relative reference path as searchNode.
	 * @param tree
	 * @param searchNode
	 * @return
	 */
	public static BusinessObjectNode findNodeByRelativeReferences(final BusinessObjectNode tree, final BusinessObjectNode searchNode) {
		// Build path to node we want to find
		final Deque<RelativeBusinessObjectReference> path = new ArrayDeque<RelativeBusinessObjectReference>();
		for(BusinessObjectNode t = searchNode; t.getParent() != null; t = t.getParent()) {
			path.push(t.relativeReference);
		}
		
		// Pop the path from the stack and find it in the specified tree
		BusinessObjectNode t = tree;
		while(t != null && !path.isEmpty()) {
			final RelativeBusinessObjectReference pathSegment = path.pop();
			t = t.getChild(pathSegment);
		}
		
		return t;
	}
	
	/**
	 * Creates a copy of the specified node.
	 * The copy is the root of a new tree.
	 * Removes leaf nodes which are not manual.
	 * Resets the completeness state of all nodes
	 * @param n
	 * @return
	 */
	public static BusinessObjectNode pruneAutomaticBranches(final BusinessObjectNode n) {		
		final BusinessObjectNode newNode = new BusinessObjectNode(null, n.relativeReference, n.bo, n.manual, n.autoContentsFilter, Completeness.UNKNOWN);
		
		// Prune and add children
		for(final BusinessObjectNode child : n.getChildren()) {
			final BusinessObjectNode prunedChild = pruneAutomaticChild(child);
			if(prunedChild != null) {
				prunedChild.parent = newNode;
				newNode.addChild(prunedChild);
			}
		}
		
		return newNode;
		
	}
	
	public static BusinessObjectNode pruneAutomaticChild(final BusinessObjectNode n) {
		// Prune Children
		final Collection<BusinessObjectNode> prunedChildren = new ArrayList<>();		
		for(final BusinessObjectNode child : n.getChildren()) {
			final BusinessObjectNode prunedChild = pruneAutomaticChild(child);
			if(prunedChild != null) {
				prunedChildren.add(prunedChild);
			}
		}
		
		// Create a new node if the original node was manual or if any of its descendants were manual
		if(prunedChildren.size() > 0 || n.manual) {
			final BusinessObjectNode newNode = new BusinessObjectNode(null, n.relativeReference, n.bo, n.manual, n.autoContentsFilter, Completeness.UNKNOWN);
			
			// Add the pruned children to the node
			for(final BusinessObjectNode newChild : prunedChildren) {
				newChild.parent = newNode;
				newNode.addChild(newChild);
			}
			
			return newNode;
		}
		
		return null;
	}
}
