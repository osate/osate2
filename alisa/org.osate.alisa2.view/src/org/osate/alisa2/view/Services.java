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
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

/**
 * Services / supporting utility methods used by the SAFE2.0 view. Everything
 * is static because, as the docs explain:
 * https://www.eclipse.org/sirius/doc/specifier/general/Writing_Queries.html
 *
 * Warning: Java service methods should be stateless. There is no guarantee
 * that two successive invocations of the same service method on two model
 * elements (or even on the same one) will use the same instance of the
 * service class.
 *
 *  @author Sam
 */
public class Services {
	/**
	* See http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24 for documentation on how to write service methods.
	*/
	public static EObject myService(EObject self, String arg) {
		// TODO Auto-generated code
		return self;
	}

	/**
	 * Get all the "Neighbors" of the specified component, where neighbor is defined as another
	 * component that directly communicates (ie, without any intermediaries) with a) this one or
	 * b) one of the components contained within this component.
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
	 * component that receives messages directly (ie, without any intermediaries) from a) this one or
	 * b) one of the components contained within this component.
	 *
	 * @param self The component the focus on
	 * @return The set of successors to the given component.
	 */
	public static Collection<EObject> getSuccessorNeighbors(EObject self) {
		ComponentInstance selfCI = (ComponentInstance) self;
		return getNeighbors(selfCI, true, selfCI.getContainingComponentInstance());
	}

	/**
	 * Get all the "Predecessors" of the specified component, where predecessor is defined as another
	 * component that sends messages directly (ie, without any intermediaries) to a) this one or
	 * b) one of the components contained within this component.
	 *
	 * @param self The component the focus on
	 * @return The set of predecessors to the given component.
	 */
	public static Collection<EObject> getPredecessorNeighbors(EObject self) {
		ComponentInstance selfCI = (ComponentInstance) self;
		return getNeighbors(selfCI, false, selfCI.getContainingComponentInstance());
	}

	/**
	 * This method recursively builds the set of successors or predecessor components of the
	 * specified component.
	 *
	 * @param self The component to focus on
	 * @param successors True if we're getting the successors to the specified component, false otherwise
	 * @param origParent The parent of the originally specified component (ie, the original value of self)
	 * @return The set of successors (or predecessors) of the specified component.
	 */
	private static Collection<EObject> getNeighbors(ComponentInstance self, boolean successors,
			ComponentInstance origParent) {
		Set<EObject> ret = new HashSet<>();

		// Get the features
		ret.addAll(getImmediateNeighbors(self, successors, origParent));
		for (Element subc : self.getChildren()) {
			if (subc instanceof ComponentInstance) {
				ret.addAll(getNeighbors((ComponentInstance) subc, successors, origParent));
			}
		}
		return ret;
	}

	/**
	 * This method gets the immediate successors and predecessors of the specified component.
	 * Compared to {@link #getNeighbors(ComponentInstance, boolean, ComponentInstance)}, it does
	 * the actual neighbor-finding, and does not recurse.
	 *
	 * @param self The component to focus on
	 * @param successors True if we're getting the successors to the specified component, false otherwise
	 * @param origParent The parent of the originally specified component (ie, the original value of self)
	 * @return The set of immediate successors (or predecessors) of the specified component.
	 */
	private static Collection<EObject> getImmediateNeighbors(ComponentInstance self, boolean successors,
			ComponentInstance origParent) {
		Set<EObject> ret = new HashSet<>();
		Set<ConnectionInstance> cis = new HashSet<>();
		for (FeatureInstance fi : self.getAllFeatureInstances()) {
			// Get their connections
			cis.clear();
			if (successors) {
				cis.addAll(fi.getSrcConnectionInstances());
			} else {
				cis.addAll(fi.getDstConnectionInstances());
			}
			for (ConnectionInstance ci : cis) {
				// Get their sources or destinations
				if (successors) {
					ret.add(getDepthAppropriateNeighbor(ci.getDestination(), self, origParent));
				} else {
					ret.add(getDepthAppropriateNeighbor(ci.getSource(), self, origParent));
				}
			}
		}
		return ret;
	}

	/**
	 * This gets a container of the specified ConnectionInstanceEnd. The container will be contained in
	 * the parent parameter.
	 *
	 * @param cie The end to find the container of
	 * @param self The component that we begin checking for containment at.
	 * @param parent Containment checking stops once we reach the level of the children of this component.
	 * @return The containing ComponentInstance
	 */
	private static EObject getDepthAppropriateNeighbor(ConnectionInstanceEnd cie, ComponentInstance self,
			ComponentInstance parent) {
		ComponentInstance prev = self;
		ComponentInstance tempCI = cie.getContainingComponentInstance();
		while (tempCI != parent) {
			prev = tempCI;
			tempCI = tempCI.getContainingComponentInstance();
		}
		return prev;
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
	 * Returns true if this is the first connection between the components. Used to prevent double-creating
	 * edges between one-hop neighbors when those neighbors "close the loop" ie, are connected to each other.
	 *
	 * @param self Required by the Sirius infrastructure, but ignored.
	 * @param source The source node in the diagram
	 * @param target The target node in the diagram
	 * @return True if no connection exists, false otherwise
	 */
	public static boolean isFirstConnection(EObject self, DSemanticDecorator source, DSemanticDecorator target) {
		EdgeTarget eTarget = (EdgeTarget) target; // Explicit cast to avoid nuisance 'unlikely argument type' marker
		for (DEdge edge : ((EdgeTarget) source).getIncomingEdges()) {
			if ((edge.getSourceNode()).equals(eTarget)) {
				return false;
			}
		}
		return true;
	}

//	public static String getErrStrForTbl(EObject self, EObject lineSemantic, DColumn column) {
//		ErrorType et = null;
//		getDisjointSet((Element) self);
//		if (hasErr(et, lineSemantic)) {
//			return "*";
//		} else {
//			return " ";
//		}
//	}
//
//	private static void getDisjointSet(Element root) {
//		ErrorTypeUnionFind etuf = new ErrorTypeUnionFind<ErrorType>(Collections.EMPTY_SET);
//
//		// Adapted from org.osate.xtext.aadl2.errormodel.util.EMV2Util.findErrorTypeSet(Element, String)
//		for (ErrorModelSubclause currSubclause : EMV2Util.getAllContainingClassifierEMV2Subclauses(root.getOwner())) {
//			for (ErrorModelLibrary currLibrary : currSubclause.getUseTypes()) {
//				for (ErrorType currType : currLibrary.getTypes()) {
//					etuf.addElement(currType);
//				}
//			}
//		}
//
//		List<ErrorModelLibrary> libs = EMV2Util.getUseTypes(root.getOwner());
//		libs = null;
//	}

	public static Collection<EObject> getErrorTypes(EObject self) {
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

	public static Set<Object> getErrorTypesByConnection(EObject self) {
		// TODO Stubbed this out, use either Hari's or Peter's or someone else's calculation
		// It's hard because you have error models at different levels of the hierarchy, and
		// so I don't think it's appropes to calculate that myself
		return (new Random()).nextBoolean() ? Collections.emptySet()
				: Collections
						.singleton(getErrorTypes(self).toArray()[new Random().nextInt(getErrorTypes(self).size())]);
	}

	private static ErrorType getRootType(ErrorType err) {
		ErrorType ret = err;
		while (ret.getSuperType() != null) {
			ret = ret.getSuperType();
		}
		return ret;
	}

	public static String getErrorTypeColumnHeader(EObject self) {
		return ((ErrorType) self).getName();
	}
}
