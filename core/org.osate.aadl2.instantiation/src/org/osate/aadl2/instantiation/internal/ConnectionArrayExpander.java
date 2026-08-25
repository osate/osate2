/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.instantiation.internal;

import static org.osate.aadl2.modelsupport.util.AadlUtil.getElementCount;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.ArraySize;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2InstanceUtil;

/**
 * Expands the provisional connection instances of one instance model root into the final connection
 * set. A connection whose ends are array elements, or that carries {@code Connection_Pattern} or
 * {@code Connection_Set}, stands for one connection instance per pair of elements the pattern pairs up,
 * and a connection instance inside an element of a component array is replicated into the other
 * elements of that array.
 * <p>
 * The expansion replaces the provisional connection instances that
 * {@code CreateConnectionsSwitch} produced and deletes them, so it has to run before the connection
 * instances are validated and before the end to end flows are built over them.
 * <p>
 * {@code Connection_Pattern} and {@code Connection_Set} have to be cached on the provisional
 * connection instances before the expansion runs, see
 * {@link #isStructuralConnectionProperty(Property)}. Both associations are removed from the connection
 * instance they were read from, so they do not survive into the final connection set.
 * <p>
 * Which elements a pattern pairs up is {@link ArrayPatternExpansion}; this class decides what a pair of
 * indices becomes.
 * <p>
 * One expander expands one root once.
 */
public final class ConnectionArrayExpander {
	/* The properties that determine how a connection is expanded into connection instances */
	private static final String COMMUNICATION_PROPERTIES = "Communication_Properties";
	private static final String CONNECTION_PATTERN = "Connection_Pattern";
	private static final String CONNECTION_SET = "Connection_Set";

	private final AnalysisErrorReporterManager errManager;
	private final IProgressMonitor monitor;

	/**
	 * @param monitor the progress monitor
	 * @param errManager the error manager to report to
	 */
	public ConnectionArrayExpander(IProgressMonitor monitor, AnalysisErrorReporterManager errManager) {
		this.monitor = monitor;
		this.errManager = errManager;
	}

	/**
	 * Is this one of the properties that determine how many connection instances a connection expands
	 * into? Uses the same test as {@link #getPA(ConnectionInstance, String)}, which is what reads the
	 * cached values.
	 */
	public static boolean isStructuralConnectionProperty(Property property) {
		return isCommunicationProperty(property, CONNECTION_PATTERN)
				|| isCommunicationProperty(property, CONNECTION_SET);
	}

	/**
	 * Is this the named property of the standard {@code Communication_Properties} property set? The one
	 * test is shared by {@link #isStructuralConnectionProperty(Property)}, which decides which
	 * properties are cached on the provisional connection instances, and
	 * {@link #getPA(ConnectionInstance, String)}, which reads them from there, so the two cannot drift
	 * apart.
	 *
	 * @param property the property definition to test
	 * @param name the name of the property to look for
	 */
	private static boolean isCommunicationProperty(Property property, String name) {
		return name.equalsIgnoreCase(property.getName()) && property.getOwner() instanceof PropertySet ps
				&& COMMUNICATION_PROPERTIES.equalsIgnoreCase(ps.getName());
	}

	/**
	 * Expand the provisional connection instances below a root into the final connection set: create the
	 * connection instances the arrays, patterns and connection sets of the model call for, delete the
	 * provisional connection instances they replace, and replicate the connection instances of an array
	 * element into the other elements of that array.
	 *
	 * @param root the instance model root to expand the connection instances of
	 * @throws InterruptedException if instantiation is canceled
	 */
	public void processConnections(ComponentInstance root) throws InterruptedException {
		checkCanceled();
		EList<ComponentInstance> replicateConns = new UniqueEList<>();
		List<ConnectionInstance> toRemove = new ArrayList<>();
		EList<ConnectionInstance> connilist = root.getAllConnectionInstances();
		for (ConnectionInstance conni : connilist) {
			// track all component instances that contain connection instances
			replicateConns.add(conni.getComponentInstance());

			PropertyAssociation setPA = getPA(conni, CONNECTION_SET);
			PropertyAssociation patternPA = getPA(conni, CONNECTION_PATTERN);

			if (setPA == null && patternPA == null) {
				InstancePath srcPath = analyzePath(conni.getContainingComponentInstance(), conni.getSource());
				InstancePath dstPath = analyzePath(conni.getContainingComponentInstance(), conni.getDestination());
				if (srcPath == null || dstPath == null) {
					continue;
				}
				// only a connection with an array element at one of its ends is expanded
				if (srcPath.throughArrayElement() || dstPath.throughArrayElement()) {
					if (expandPattern(conni, false, null, srcPath.sizes(), dstPath.sizes())) {
						toRemove.add(conni);
					}
				}
			} else if (patternPA != null) {
				boolean isOpposite = Aadl2InstanceUtil.isOpposite(conni);
				EcoreUtil.remove(patternPA);
				List<PropertyExpression> patterns = ((ListValue) patternPA.getOwnedValues().get(0).getOwnedValue())
						.getOwnedListElements();
				boolean pathError = false;
				for (PropertyExpression pe : patterns) {
					List<PropertyExpression> pattern = ((ListValue) pe).getOwnedListElements();

					InstancePath srcPath = analyzePath(conni.getContainingComponentInstance(), conni.getSource());
					InstancePath dstPath = analyzePath(conni.getContainingComponentInstance(), conni.getDestination());
					if (srcPath == null || dstPath == null) {
						pathError = true;
						break;
					}
					if (!srcPath.throughArrayElement() && !dstPath.throughArrayElement()) {
						errManager.warning(conni,
								"Connection pattern specified for connection that does not connect array elements.");
					} else {
						if (expandPattern(conni, isOpposite, pattern, srcPath.sizes(), dstPath.sizes())) {
							toRemove.add(conni);
						}
					}
				}
				if (pathError) {
					continue;
				}
			}
			// no else as we want both the pattern and the connection set evaluated
			if (setPA != null) {
				EcoreUtil.remove(setPA);
				// TODO-LW: modal conn set allowed?
				List<Long> srcIndices;
				List<Long> dstIndices;
				for (PropertyExpression pe : ((ListValue) setPA.getOwnedValues().get(0).getOwnedValue())
						.getOwnedListElements()) {
					RecordValue rv = (RecordValue) pe;

					srcIndices = getIndices(rv, "src");
					dstIndices = getIndices(rv, "dst");
					if (Aadl2InstanceUtil.isOpposite(conni)) {
						// flip indices since we are going in the opposite direction
						createNewConnection(conni, dstIndices, srcIndices);
					} else {
						createNewConnection(conni, srcIndices, dstIndices);
					}
				}
				toRemove.add(conni);
			}
		}
		for (ConnectionInstance conni : toRemove) {
			EcoreUtil.delete(conni);
		}
		replicateConnections(replicateConns);
	}

	private void replicateConnections(EList<ComponentInstance> replicateConns) {
		for (ComponentInstance ci : replicateConns) {
			if (isInArray(ci)) {
				doReplicateConnections(ci);
			}
		}
	}

	private boolean isInArray(ComponentInstance ci) {
		while (!(ci instanceof SystemInstance)) {
			if (!ci.getIndices().isEmpty()) {
				return true;
			}
			ci = ci.getContainingComponentInstance();
		}
		return false;
	}

	private ComponentInstance outermostArray(ComponentInstance ci) {
		ComponentInstance res = null;
		while (!(ci instanceof SystemInstance)) {
			if (!ci.getIndices().isEmpty()) {
				res = ci;
			}
			ci = ci.getContainingComponentInstance();
		}
		return res;
	}

	private void doReplicateConnections(ComponentInstance ci) {
		String origPath = getComponentInstanceNamePath(ci);
		ComponentInstance outermostParent = outermostArray(ci).getContainingComponentInstance();
		doReplicateConnections(ci, origPath, outermostParent);
	}

	private void doReplicateConnections(ComponentInstance ci, String origPath, ComponentInstance targetParent) {
		for (ComponentInstance targetci : targetParent.getComponentInstances()) {
			// do it only for sibling components. Misses out on enclosing arrays
			if (targetci.getConnectionInstances().isEmpty()) {
				// only if it does not yet have connection instances
				String targetpath = getComponentInstanceNamePath(targetci);
				// compare paths without indices
				if (origPath.equalsIgnoreCase(targetpath)) {
					for (ConnectionInstance conni : ci.getConnectionInstances()) {
						createNewConnection(conni, targetci);
					}
				} else if (origPath.startsWith(targetpath)) {
					doReplicateConnections(ci, origPath, targetci);
				}
			}
		}
	}

	private String getComponentInstanceNamePath(ComponentInstance ci) {
		if (ci instanceof SystemInstance) {
			return ci.getName();
		}
		final String path = getComponentInstanceNamePath(ci.getContainingComponentInstance());
		final String localname = ci.getName();

		return path + "." + localname;
	}

	/**
	 * Expand a connection instance into the connection instances that its array dimensions, its
	 * {@code Connection_Pattern} or the default pattern call for.
	 *
	 * @param conni the connection instance to expand
	 * @param isOpposite whether the connection instance goes against the direction of the declaration
	 * @param patterns the value of {@code Connection_Pattern}, one literal per dimension, or {@code null}
	 *            to expand with the default pattern
	 * @param srcSizes the sizes of the array dimensions of the source end, outside in
	 * @param dstSizes the sizes of the array dimensions of the destination end, outside in
	 * @return whether the provisional connection instance has to be deleted; a short pattern is rejected
	 *         without a replacement, while failures that may still describe one scalar connection leave it
	 *         in place
	 */
	private boolean expandPattern(ConnectionInstance conni, boolean isOpposite, List<PropertyExpression> patterns,
			List<Integer> srcSizes, List<Integer> dstSizes) {
		var container = conni.getContainingComponentInstance();
		var subject = new ArrayPatternExpansion.Subject(conni, "connection", conni.getFullName(), container,
				container.getFullName());
		return new ArrayPatternExpansion(errManager, subject, isOpposite, patterns, srcSizes, dstSizes,
				(srcIndices, dstIndices) -> createNewConnection(conni, srcIndices, dstIndices)).expand();
	}

	private List<Long> getIndices(RecordValue rv, String field) {
		List<Long> indices = new ArrayList<>();
		for (BasicPropertyAssociation fv : rv.getOwnedFieldValues()) {
			if (fv.getProperty().getName().equalsIgnoreCase(field)) {
				ListValue lv = (ListValue) fv.getOwnedValue();
				EList<PropertyExpression> vlist = lv.getOwnedListElements();
				for (PropertyExpression elem : vlist) {
					indices.add(((IntegerLiteral) elem).getValue());
				}
			}
		}
		return indices;
	}

	/**
	 * The association of a {@code Communication_Properties} property cached on a provisional connection
	 * instance, or {@code null} if the connection has none.
	 *
	 * @param conni the connection instance to look in
	 * @param name the name of the property to look for
	 */
	private PropertyAssociation getPA(ConnectionInstance conni, String name) {
		for (PropertyAssociation pa : conni.getOwnedPropertyAssociations()) {
			if (isCommunicationProperty(pa.getProperty(), name)) {
				return pa;
			}
		}
		return null;
	}

	/**
	 * Returns the instance objects from {@code end} up to, but excluding, {@code container}. A
	 * connection end path is relative to its containing component instance, so reaching any other root
	 * is an error rather than a successful stopping condition.
	 */
	private List<InstanceObject> getConnectionEndPath(ComponentInstance container, ConnectionInstanceEnd end) {
		if (container == null) {
			String endPath = end == null ? "<null>" : end.getInstanceObjectPath();
			String message = "Cannot analyze connection end '" + endPath + "' without a containing component instance";
			if (end == null) {
				errManager.internalError(message);
			} else {
				errManager.error(end, message);
			}
			return null;
		}
		List<InstanceObject> path = new ArrayList<>();
		InstanceObject current = end;
		while (current != container) {
			if (current == null || !(current.getOwner() instanceof InstanceObject owner)) {
				String endPath = end == null ? "<null>" : end.getInstanceObjectPath();
				errManager.error(container, "Connection end '" + endPath + "' is not contained in component instance '"
						+ container.getInstanceObjectPath() + "'");
				return null;
			}
			path.add(current);
			current = owner;
		}
		return path;
	}

	/**
	 * The path from a connection instance end up to its containing component instance, described by one
	 * entry per step for the names and the dimensions, and by one entry per array dimension for the sizes
	 * and the indices.
	 *
	 * @param names the name of every instance object along the path, bottom up
	 * @param dims the number of declared array dimensions of every instance object along the path, zero
	 *            for one that is not an array element
	 * @param sizes the size of every array dimension along the path, bottom up
	 * @param indices the index of the path in every array dimension along the path, bottom up
	 */
	private record InstancePath(List<String> names, List<Integer> dims, List<Integer> sizes, List<Long> indices) {
		/**
		 * Does this path go through an array element? An empty size list and a dimension list of nothing
		 * but zeros are the same statement, because every step contributes one size per declared
		 * dimension.
		 */
		boolean throughArrayElement() {
			return !sizes.isEmpty();
		}
	}

	/**
	 * Describe the path from a connection instance end up to the component instance that contains the
	 * connection instance.
	 *
	 * @param container the component instance the path is relative to
	 * @param end the connection instance end the path starts at
	 * @return the path, or {@code null} if the end is not contained in {@code container}, which is
	 *         reported
	 */
	private InstancePath analyzePath(ComponentInstance container, ConnectionInstanceEnd end) {
		List<InstanceObject> path = getConnectionEndPath(container, end);
		if (path == null) {
			return null;
		}
		List<String> names = new ArrayList<>();
		List<Integer> dims = new ArrayList<>();
		List<Integer> sizes = new ArrayList<>();
		List<Long> indices = new ArrayList<>();
		for (InstanceObject current : path) {
			int d = 0;

			names.add(current.getName());
			if (current instanceof ComponentInstance componentInstance) {
				d = componentInstance.getSubcomponent().getArrayDimensions().size();
				if (d != 0) {
					indices.addAll(componentInstance.getIndices());
					for (ArrayDimension ad : componentInstance.getSubcomponent().getArrayDimensions()) {
						ArraySize as = ad.getSize();

						sizes.add((int) getElementCount(as, current.getContainingComponentInstance()));
					}
				}
			} else if (current instanceof FeatureInstance featureInstance && featureInstance.getIndex() != 0) {
				d = 1;
				indices.add(featureInstance.getIndex());
				Feature f = featureInstance.getFeature();
				ArraySize as = f.getArrayDimensions().get(0).getSize();

				sizes.add((int) getElementCount(as, current.getContainingComponentInstance()));
			}
			dims.add(d);
		}
		return new InstancePath(names, dims, sizes, indices);
	}

	/**
	 * Create a copy of the connection instance with the specified indices for the source and the
	 * destination.
	 *
	 * @param conni the connection instance to copy
	 * @param srcIndices the indices of the source end
	 * @param dstIndices the indices of the destination end
	 */
	private void createNewConnection(ConnectionInstance conni, List<Long> srcIndices, List<Long> dstIndices) {
		ComponentInstance container = conni.getContainingComponentInstance();
		ConnectionInstance newConn = EcoreUtil.copy(conni);
		newConn.setSource(null);
		newConn.setDestination(null);
		ConnectionReference topConnRef = Aadl2InstanceUtil.getTopConnectionReference(newConn);
		InstancePath srcPath = analyzePath(container, conni.getSource());
		if (srcPath == null) {
			return;
		}
		if (srcIndices.size() != srcPath.sizes().size() &&
		// filter out one side being an element without index (array of 1) (many to one mapping)
				!(srcPath.sizes().isEmpty() && dstIndices.size() == 1)) {
			errManager.error(container,
					"Source indices " + srcIndices + " do not match source dimension " + srcPath.sizes().size());
		}
		InstanceObject src = resolveConnectionInstancePath(newConn, topConnRef, container, container, srcPath, srcIndices,
				End.SOURCE);
		InstancePath dstPath = analyzePath(container, conni.getDestination());
		if (dstPath == null) {
			return;
		}
		if (dstIndices.size() != dstPath.sizes().size() &&
		// filter out one side being an element without index (array of 1) (many to one mapping)
				!(dstPath.sizes().isEmpty() && dstIndices.size() == 1)) {
			errManager.error(container,
					"For " + newConn.getConnectionReferences().get(0).getFullName() + " : " + newConn.getFullName()
							+ ", destination indices " + dstIndices + " do not match destination dimension "
							+ dstPath.sizes().size());
		}
		InstanceObject dst = resolveConnectionInstancePath(newConn, topConnRef, container, container, dstPath, dstIndices,
				End.DESTINATION);
		if (src == null) {
			errManager.error(container, "Connection source not found");
		}
		if (dst == null) {
			errManager.error(container, "Connection destination not found");
		}
		if (src == null || dst == null) {
			return;
		}

		String name = connectionInstanceName(container, src, dst);
		ConnectionInstance duplicate = (ConnectionInstance) AadlUtil
				.findNamedElementInList(container.getConnectionInstances(), name);
		if (duplicate != null && duplicate != conni) { // conni will be removed later
			errManager.warning(container, "There is already another connection between the same endpoints");
		}
		newConn.setSource((ConnectionInstanceEnd) src);
		newConn.setDestination((ConnectionInstanceEnd) dst);
		alignConnectionReferenceEndpoints(newConn);
		newConn.setName(name);
		container.getConnectionInstances().add(newConn);

	}

	/**
	 * Create a copy of the connection instance in another element of the array the connection instance
	 * belongs to.
	 *
	 * @param conni the connection instance to copy
	 * @param targetComponent the component instance the copy belongs to
	 */
	private void createNewConnection(ConnectionInstance conni, ComponentInstance targetComponent) {
		ComponentInstance origComponent = conni.getContainingComponentInstance();
		ConnectionInstance newConn = EcoreUtil.copy(conni);
		newConn.setSource(null);
		newConn.setDestination(null);
		ConnectionReference topConnRef = Aadl2InstanceUtil.getTopConnectionReference(newConn);
		InstancePath srcPath = analyzePath(origComponent, conni.getSource());
		if (srcPath == null) {
			return;
		}
		InstanceObject src = resolveConnectionInstancePath(newConn, topConnRef, targetComponent, targetComponent, srcPath,
				srcPath.indices(), End.SOURCE);
		InstancePath dstPath = analyzePath(origComponent, conni.getDestination());
		if (dstPath == null) {
			return;
		}
		InstanceObject dst = resolveConnectionInstancePath(newConn, topConnRef, targetComponent, targetComponent, dstPath,
				dstPath.indices(), End.DESTINATION);
		if (src == null) {
			errManager.error(targetComponent, "Connection source not found");
		}
		if (dst == null) {
			errManager.error(targetComponent, "Connection destination not found");
		}
		if (src == null || dst == null) {
			return;
		}

		relocateConnectionReferenceContexts(newConn, origComponent, targetComponent);
		newConn.setSource((ConnectionInstanceEnd) src);
		newConn.setDestination((ConnectionInstanceEnd) dst);
		alignConnectionReferenceEndpoints(newConn);
		newConn.setName(connectionInstanceName(targetComponent, src, dst));
		targetComponent.getConnectionInstances().add(newConn);

	}

	/**
	 * The name of a connection instance, which is the path of its source and the path of its destination
	 * relative to the component instance that contains it.
	 *
	 * @param container the component instance that contains the connection instance
	 * @param src the source of the connection instance
	 * @param dst the destination of the connection instance
	 * @return the name of the connection instance
	 */
	private static String connectionInstanceName(ComponentInstance container, InstanceObject src, InstanceObject dst) {
		String containerPath = container.getInstanceObjectPath();
		return relativeInstanceObjectPath(containerPath, src) + " --> "
				+ relativeInstanceObjectPath(containerPath, dst);
	}

	/**
	 * The path of a connection end relative to the component instance that contains the connection
	 * instance, or its absolute path if it is not below that component instance.
	 */
	private static String relativeInstanceObjectPath(String containerPath, InstanceObject end) {
		String endPath = end.getInstanceObjectPath();
		return endPath.startsWith(containerPath) ? endPath.substring(containerPath.length() + 1) : endPath;
	}

	/**
	 * Keep the ends of a copied connection's reference chain aligned with the ends that were resolved
	 * for the copy. Re-resolving from a declaration that names a feature group can otherwise leave the
	 * reference at the group, and a failed nested lookup can leave it in the original array element.
	 *
	 * @param connection the copied connection whose source and destination have been resolved
	 */
	private void alignConnectionReferenceEndpoints(ConnectionInstance connection) {
		List<ConnectionReference> references = connection.getConnectionReferences();
		if (!references.isEmpty()) {
			references.getFirst().setSource(connection.getSource());
			references.getLast().setDestination(connection.getDestination());
		}
	}

	/**
	 * Point the connection references of a replicated connection instance at the array element that now
	 * contains them. The copy keeps the contexts of the element it was copied from. Resolving the
	 * endpoints gives every enclosed connection reference a context in the target element, but nothing
	 * updates the context of the reference that goes across in the copied element.
	 *
	 * @param newConn the copy of the connection instance
	 * @param origComponent the component instance that contains the original connection instance
	 * @param targetComponent the component instance that will contain the copy
	 */
	private void relocateConnectionReferenceContexts(ConnectionInstance newConn, ComponentInstance origComponent,
			ComponentInstance targetComponent) {
		for (ConnectionReference connRef : newConn.getConnectionReferences()) {
			ComponentInstance relocated = relocateComponentInstance(connRef.getContext(), origComponent,
					targetComponent);
			if (relocated != null) {
				connRef.setContext(relocated);
			}
		}
	}

	/**
	 * Find the component instance in the target element that corresponds to a component instance in the
	 * element the connection instance was copied from.
	 *
	 * @param original the component instance to relocate
	 * @param origComponent the root of the subtree the original belongs to
	 * @param targetComponent the root of the subtree to relocate into
	 * @return the corresponding component instance, or null if the original is neither
	 *         <code>origComponent</code> nor contained in it, or if it has no counterpart
	 */
	private ComponentInstance relocateComponentInstance(ComponentInstance original, ComponentInstance origComponent,
			ComponentInstance targetComponent) {
		if (original == null) {
			return null;
		}
		if (original == origComponent) {
			return targetComponent;
		}
		ComponentInstance parent = relocateComponentInstance(original.getContainingComponentInstance(), origComponent,
				targetComponent);
		if (parent == null) {
			return null;
		}
		for (ComponentInstance candidate : parent.getComponentInstances()) {
			if (candidate.getName().equalsIgnoreCase(original.getName())
					&& candidate.getIndices().equals(original.getIndices())) {
				return candidate;
			}
		}
		return null;
	}

	/**
	 * Which end of a connection instance is being resolved. Resolution walks the connection references
	 * from the component instance that contains the connection instance down to the end, which is
	 * towards the beginning of the reference chain for the source and towards its end for the
	 * destination. Everything else the two directions do is a mirror image of each other, so they differ
	 * only in the accessors collected here: the near end of a connection reference is the end being
	 * resolved and the far end is the other one.
	 */
	private enum End {
		SOURCE {
			@Override
			ConnectionInstanceEnd near(ConnectionReference connRef) {
				return connRef.getSource();
			}

			@Override
			void setNear(ConnectionReference connRef, ConnectionInstanceEnd end) {
				connRef.setSource(end);
			}

			@Override
			ConnectionInstanceEnd far(ConnectionReference connRef) {
				return connRef.getDestination();
			}

			@Override
			void setFar(ConnectionReference connRef, ConnectionInstanceEnd end) {
				connRef.setDestination(end);
			}

			@Override
			ConnectionReference next(ConnectionInstance conni, ConnectionReference connRef) {
				return Aadl2InstanceUtil.getPreviousConnectionReference(conni, connRef);
			}
		},
		DESTINATION {
			@Override
			ConnectionInstanceEnd near(ConnectionReference connRef) {
				return connRef.getDestination();
			}

			@Override
			void setNear(ConnectionReference connRef, ConnectionInstanceEnd end) {
				connRef.setDestination(end);
			}

			@Override
			ConnectionInstanceEnd far(ConnectionReference connRef) {
				return connRef.getSource();
			}

			@Override
			void setFar(ConnectionReference connRef, ConnectionInstanceEnd end) {
				connRef.setSource(end);
			}

			@Override
			ConnectionReference next(ConnectionInstance conni, ConnectionReference connRef) {
				return Aadl2InstanceUtil.getNextConnectionReference(conni, connRef);
			}
		};

		/** The end of a connection reference that is on the side being resolved. */
		abstract ConnectionInstanceEnd near(ConnectionReference connRef);

		abstract void setNear(ConnectionReference connRef, ConnectionInstanceEnd end);

		/** The end of a connection reference that is on the other side. */
		abstract ConnectionInstanceEnd far(ConnectionReference connRef);

		abstract void setFar(ConnectionReference connRef, ConnectionInstanceEnd end);

		/** The connection reference one step further towards the end being resolved. */
		abstract ConnectionReference next(ConnectionInstance conni, ConnectionReference connRef);
	}

	/**
	 * resolve downgoing source or destination of the connection reference.
	 * we do so by re-retrieving the feature instance based on the existing connection instance end name.
	 * If the connection reference is up or down going we also fill in the other end.
	 * @param targetConnRef the connection reference to resolve
	 * @param outerConnRef the connection reference one level up
	 * @param target the component instance to resolve the end in
	 * @param end which end of the connection instance is being resolved
	 * @param idx the index of the feature instance to resolve to
	 * @param fgidx the index of the enclosing feature group instance to resolve to
	 * @return the resolved end
	 */
	private ConnectionInstanceEnd resolveConnectionReference(ConnectionReference targetConnRef,
			ConnectionReference outerConnRef, ComponentInstance target, End end, long idx, long fgidx) {
		ConnectionInstanceEnd near = end.near(targetConnRef);
		ConnectionInstanceEnd far = end.far(targetConnRef);
		if (target.getName().equalsIgnoreCase(near.getName())) {
			// we point to a component instance, such as a bus or data component in an access connection
			end.setNear(targetConnRef, target);
		} else if (near instanceof FeatureInstance) {
			// re-resolve the feature of the end we are resolving
			ConnectionInstanceEnd found = findConnectionEnd(target.getFeatureInstances(), near, idx, target, fgidx);
			if (found != null) {
				end.setNear(targetConnRef, found);
			}
		}
		// now we need to resolve the upper end, which is the other end of this connection reference
		if (outerConnRef != null && targetConnRef != outerConnRef) {
			// we need to fix the context of the connection reference
			ConnectionInstanceEnd outerNear = end.near(outerConnRef);
			targetConnRef.setContext(outerNear.getComponentInstance());
			// we are not at the top so we fix up the upper end of the connection reference
			if (far.getOwner() instanceof ComponentInstance && far.getName().equalsIgnoreCase(outerNear.getName())) {
				end.setFar(targetConnRef, outerNear);
			} else {
				// the outer end points to the enclosing feature group. reresolve the feature in this feature group
				ConnectionInstanceEnd found = findConnectionEnd(((FeatureInstance) outerNear).getFeatureInstances(), far,
						idx, target, fgidx);
				if (found != null) {
					end.setFar(targetConnRef, found);
				}
			}
		}
		return end.near(targetConnRef);
	}

	/**
	 * Look up the counterpart of a connection end of the connection instance that was copied. If the end
	 * itself is not among the candidates, look for the feature group that contains it instead, which is
	 * always looked for in the component instance the copy resolves against.
	 *
	 * @param candidates the feature instances the end itself is looked for in
	 * @param end the connection end of the original connection instance
	 * @param idx the index of the feature instance to resolve to
	 * @param target the component instance the enclosing feature group is looked for in
	 * @param fgidx the index of the enclosing feature group instance to resolve to
	 * @return the counterpart, or {@code null} if neither lookup found one
	 */
	private static ConnectionInstanceEnd findConnectionEnd(List<FeatureInstance> candidates, ConnectionInstanceEnd end,
			long idx, ComponentInstance target, long fgidx) {
		ConnectionInstanceEnd found = (ConnectionInstanceEnd) AadlUtil.findNamedElementInList(candidates, end.getName(),
				idx);
		if (found == null && end.getOwner() instanceof FeatureInstance parent) {
			found = (ConnectionInstanceEnd) AadlUtil.findNamedElementInList(target.getFeatureInstances(),
					parent.getName(), fgidx);
		}
		return found;
	}

	/**
	 * this method resolves the connection instance from the top connection reference down the source or the destination
	 * @param newconn Connection Instance whose paths need to be resolved
	 * @param topref Connection Reference going across components
	 * @param resolutionRoot component instance from which the path is resolved
	 * @param diagnosticTarget resource-backed object used for diagnostics
	 * @param path the names and dimensions of the path of the original connection end, bottom up
	 * @param indices The indices to be used for elements that are arrays
	 * @param end Go down the source path or the destination path
	 * @return ConnectionInstanceEnd the ultimate source/destination object (feature instance or component instance)
	 */
	private ConnectionInstanceEnd resolveConnectionInstancePath(ConnectionInstance newconn, ConnectionReference topref,
			ComponentInstance resolutionRoot, Element diagnosticTarget, InstancePath path, List<Long> indices,
			End end) {
		final List<String> names = path.names();
		final List<Integer> dims = path.dims();
		// the connection reference to be resolved
		ConnectionReference targetConnRef = topref;
		ConnectionReference outerConnRef = topref;
		ConnectionInstanceEnd resolutionContext = resolutionRoot;
		// we have to process the indices backwards since we go top down
		// offset starts with the last element of the indices array
		int offset = indices.size() - 1;
		int count = dims.size() - 1;
		ConnectionInstanceEnd result = null;
		for (int nameidx = names.size() - 1; nameidx >= 0; nameidx--) {
			String name = names.get(nameidx);
			List<InstanceObject> owned = new ArrayList<>();
			int dim = dims.get(count);
			if (resolutionContext instanceof ComponentInstance componentContext) {
				// if nextConnRef is null it is because we are going to look up feature instances inside the last component instance
				owned.addAll(componentContext.getComponentInstances());
				owned.addAll(componentContext.getFeatureInstances());
			} else if (resolutionContext instanceof FeatureInstance featureContext) {
				owned.addAll(featureContext.getFeatureInstances());
			}

			if (dim == 0) {
				resolutionContext = (ConnectionInstanceEnd) AadlUtil.findNamedElementInList(owned, name);
			} else {
				// find the object based on its name and indices
				outer: for (InstanceObject io : owned) {
					if (io.getName().equalsIgnoreCase(name)) {
						try {
							if (io instanceof ComponentInstance componentInstance) {
								// we need to deal with possibly more than one index
								int d = dim - 1;
								for (long i : componentInstance.getIndices()) {
									if (i != indices.get(offset - d)) {
										continue outer;
									}
									d--;
								}
							} else {
								// we have a feature that may have an index or zero index
								if (((FeatureInstance) io).getIndex() != indices.get(offset)) {
									continue outer;
								}
							}
						} catch (IndexOutOfBoundsException e) {
							errManager.warning(diagnosticTarget,
									"Too few indices for connection end, using first array element");
						}
						resolutionContext = (ConnectionInstanceEnd) io;
						break;
					}
				}
			}
			if (resolutionContext == null) {
				return null;
			}
			// resolve the connref
			if (targetConnRef != null && resolutionContext instanceof ComponentInstance) {
				int dimfeature = dims.get(0);
				int dimfg = 0;
				if (dims.size() > 1) {
					dimfg = dims.get(1);
				}
				result = resolveConnectionReference(targetConnRef, outerConnRef, (ComponentInstance) resolutionContext,
						end, dimfeature == 0 ? 0 : indices.get(0),
						dimfg == 0 ? 0 : (dimfeature == 0 ? indices.get(0) : indices.get(1)));
			} else {
				// the resolved feature has been found
				result = resolutionContext;
			}
			if (targetConnRef != null && result instanceof FeatureInstance) {
				end.setNear(targetConnRef, result);
			}
			// now we need to update the connref pointers
			outerConnRef = targetConnRef;
			targetConnRef = end.next(newconn, outerConnRef);
			// reduce the offset by the processed indices of the element we just looked up
			offset -= dim;
			// reduce the index into the dims array to get the next number of dimensions
			count--;
		}
		return result;
	}

	/**
	 * Stop the current instantiation if the user canceled it.
	 *
	 * @throws InterruptedException if the progress monitor reports cancellation
	 */
	private void checkCanceled() throws InterruptedException {
		if (monitor.isCanceled()) {
			throw new InterruptedException();
		}
	}
}
