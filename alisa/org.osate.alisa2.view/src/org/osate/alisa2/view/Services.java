package org.osate.alisa2.view;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.EdgeTarget;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

/**
 * Services / supporting utility methods used by the SAFE2.0 view. Note this
 * portion of the docs:
 * https://www.eclipse.org/sirius/doc/specifier/general/Writing_Queries.html
 *
 * Warning: Java service methods should be stateless. There is no guarantee
 * that two successive invocations of the same service method on two model
 * elements (or even on the same one) will use the same instance of the
 * service class.
 *
 *  @author Sam Procter
 */
public class Services {

	/**
	 * Get all the "Neighbors" of the specified component, where neighbor is defined as another
	 * component that directly communicates (ie, without any intermediaries) with this one
	 *
	 * @param self The component the focus on
	 * @return The set of neighbors for the given component.
	 */
	public static Collection<EObject> getAllNeighbors(EObject self) {
		return (Stream.concat(getSuccessorNeighbors(self).stream(), getPredecessorNeighbors(self).stream()))
				.collect(Collectors.toSet());
	}

	/**
	 * Get all the neighbors of the component's neighbors (cf {@link #getAllNeighbors(EObject)}.
	 * More specifically, get all the successor's successors and the predecessors predecessors.
	 *
	 * @param self The component to focus on
	 * @return The set of one-hop neighbors for the given component
	 */
	public static Collection<EObject> getOneHopNeighbors(EObject self) {
		Set<EObject> ret = new HashSet<>();
		for (EObject succ : getSuccessorNeighbors(self)) {
			ret.addAll(getSuccessorNeighbors(succ));
		}
		for (EObject pred : getPredecessorNeighbors(self)) {
			ret.addAll(getPredecessorNeighbors(pred));
		}
		return ret;
	}

	/**
	 * Get all the "Successors" of the specified component, where successor is defined as another
	 * component that receives messages directly (ie, without any intermediaries) from this one
	 *
	 * @param self The component to get the neighbors of
	 * @return The set of successors to the given component.
	 */
	public static Collection<EObject> getSuccessorNeighbors(EObject self) {
		return AwasManager.getInstance().getSuccessorNeighbors((ComponentInstance) self);
	}

	/**
	 * Get all the "Predecessors" of the specified component, where predecessor is defined as another
	 * component that sends messages directly (ie, without any intermediaries) to this one
	 *
	 * @param self The component to get the neighbors of
	 * @return The set of predecessors to the given component.
	 */
	public static Collection<EObject> getPredecessorNeighbors(EObject self) {
		return AwasManager.getInstance().getPredecessorNeighbors((ComponentInstance) self);
	}

	public static EList<ComponentInstance> getAllComponents(EObject self) {
		return ((ComponentInstance) self).getAllComponentInstances();
	}

	public static EList<ConnectionInstance> getAllConnectionInstances(EObject self) {
		return ((ComponentInstance) self).getConnectionInstances();
	}

	public static boolean isLeafComponent(EObject self) {
		return ((ComponentInstance) self).getAllComponentInstances().size() == 1;
	}

	public static boolean isNestedComponent(EObject self) {
		return ((ComponentInstance) self).getContainingComponentInstance() != null;
	}

	/**
	 * Returns true if this is the first connection between two components. Used to prevent double-creating
	 * edges between one-hop neighbors when those neighbors "close the loop" ie, are connected to each other.
	 *
	 * Note that this checks both directions -- ie, if the target is already connected to the source, this
	 * will block a connection from the source to the target.
	 *
	 * @param self Required by the Sirius infrastructure, but ignored.
	 * @param source The source node in the diagram
	 * @param target The target node in the diagram
	 * @return True if no connection exists, false otherwise
	 */
	public static boolean isFirstConnection(EObject self, DSemanticDecorator source, DSemanticDecorator target) {
		EdgeTarget eTarget = (EdgeTarget) target; // Explicit cast to avoid nuisance 'unlikely argument type' marker
		EdgeTarget eSource = (EdgeTarget) source; // Explicit cast to avoid nuisance 'unlikely argument type' marker
		for (DEdge edge : eSource.getIncomingEdges()) {
			if ((edge.getSourceNode()).equals(eTarget)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Get the "root" error types referenced by a particular EObject. That is,
	 * for every error type referenced by self, we get the root of that type's
	 * hierarchy.
	 *
	 * @param self The component to get the error types from
	 * @return A set of root error types
	 */
	public static Collection<EObject> getRootErrorTypes(EObject self) {
		Set<EObject> ret = new HashSet<>();

		// Adapted from org.osate.xtext.aadl2.errormodel.util.EMV2Util.findErrorTypeSet(Element, String)
		for (ErrorModelSubclause currSubclause : EMV2Util.getAllContainingClassifierEMV2Subclauses((Element) self)) {
			for (ErrorModelLibrary currLibrary : currSubclause.getUseTypes()) {
				for (ErrorType currType : currLibrary.getTypes()) {
					ret.add(getRootType(currType));
				}
			}
		}
		return ret;
	}

	public static Collection<EObject> getRootErrorTypesByConnection(EObject self) {
		// TODO Stubbed this out, use either Hari's or Peter's or someone else's calculation
		// It's hard because you have error models at different levels of the hierarchy, and
		// so I don't think it's appropes to calculate that myself
//		return (new Random()).nextBoolean() ? Collections.emptySet()
//				: Collections
//						.singleton(getRootErrorTypes(self).toArray()[new Random()
//								.nextInt(getRootErrorTypes(self).size())]);
		return AwasManager.getInstance().getRootErrorTypesByConnection((ConnectionInstance) self);
		
	}

	/**
	 * Get the root error type associated with the given type. We walk up the
	 * type's hierarchy until we're at the top, then return that.
	 *
	 * @param err The type to get the root type from
	 * @return The root type (which may be the 'err' parameter, if it has no supertype)
	 */
	private static ErrorType getRootType(ErrorType err) {
		ErrorType ret = err;
		while (ret.getSuperType() != null) {
			ret = ret.getSuperType();
		}
		return ret;
	}

	/**
	 * Get text appropriate for the error type column header
	 *
	 * @param self The error type to get the title from
	 * @return Appropriate header text
	 */
	public static String getErrorTypeColumnHeader(EObject self) {
		return ((ErrorType) self).getName();
	}

	public static String getControlActionRowHeader(EObject self) {
		return ((ConnectionInstance) self).getName();
	}

	/**
	 * Gets incoming features for the supplied component instance. More
	 * specifically, the features whose DirectionType is IN
	 *
	 * @param self The component to get the in features for
	 * @return The set of features
	 */
	public static Collection<EObject> getInFeatures(EObject self) {
		return ((ComponentInstance) self).getFeatureInstances().stream()
				.filter(f -> f.getDirection() == DirectionType.IN).collect(Collectors.toSet());
	}

	/**
	 * Gets outgoing features for the supplied component instance. More
	 * specifically, the features whose DirectionType is OUT
	 *
	 * @param self The component to get the out features for
	 * @return The set of features
	 */
	public static Collection<EObject> getOutFeatures(EObject self) {
		return ((ComponentInstance) self).getFeatureInstances().stream()
				.filter(f -> f.getDirection() == DirectionType.OUT).collect(Collectors.toSet());
	}

	/**
	 * Gets bidirectional features for the supplied component instance. More
	 * specifically, the features whose DirectionType is IN_OUT
	 *
	 * @param self The component to get the bidirectional features for
	 * @return The set of features
	 */
	public static Collection<EObject> getInOutFeatures(EObject self) {
		return ((ComponentInstance) self).getFeatureInstances().stream()
				.filter(f -> f.getDirection() == DirectionType.IN_OUT).collect(Collectors.toSet());
	}

	/**
	 * Checks to see if the given EObject is part of whatever has been
	 * focused by the user
	 *
	 * @param self The component or connection to check
	 * @return True if the parameter is part of the user's focus, false otherwise
	 */
	public static boolean isFocused(EObject self) {
		return FocusManager.getInstance().isFocused(self);
	}

	public static Collection<EObject> debug(EObject self) {
		return null;
	}
}
