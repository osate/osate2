package org.osate.alisa2.view;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.EdgeTarget;
import org.eclipse.sirius.table.business.internal.metamodel.spec.DCellSpec;
import org.eclipse.sirius.table.metamodel.table.DColumn;
import org.eclipse.sirius.table.metamodel.table.DLine;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.parsesupport.AObject;
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
	 * Gets the current object's container.
	 *
	 * Used by: FamilyErrors.Table Creation CreateFamilyErrors.Advanced-Browse Expression
	 *
	 * @param self The object to get the container of
	 * @return The object's container
	 */
	public static EObject getContainer(EObject self) {
		return self.eContainer();
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
	 * Used by: TopLevelErrors.ErrorTypesTopLevelErrors.General-Semantic Candidates Expression
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
					ret.add(AsapUtil.getRootType(currType));
				}
			}
		}
		return ret;
	}

	public static EObject getRootErrorType(EObject errorType) {
		return AsapUtil.getRootType((ErrorType) errorType);
	}

	/**
	 * Gets the root error types associated with each error type sent on a connection
	 *
	 * Used by: TopLevelErrors.HasError.General-Column Finder Expression
	 *
	 * @param self
	 * @return
	 */
	public static Collection<EObject> getRootErrorTypesByConnection(EObject self) {
		//@formatter:off
		return AwasManager.getInstance().getRootErrorTypesByConnection((ConnectionInstance) self).stream()
	    	.filter(c -> c instanceof ErrorType)
	    	.map(c -> (ErrorType) c)
	    	.map(AsapUtil::getRootType)
	    	.collect(Collectors.toSet());
		//@formatter:on
	}

	/**
	 * Gets the error types sent on a connection
	 *
	 * Used by: FamilyErrors.HasError.General-Column Finder Expression
	 *
	 * @param self The connection
	 * @return A set of error types sent on the connection
	 */
	public static Collection<EObject> getErrorTypesByConnection(EObject self) {
		//@formatter:off
		return AwasManager.getInstance().getRootErrorTypesByConnection((ConnectionInstance) self).stream()
	    	.filter(c -> c instanceof ErrorType)
	    	.collect(Collectors.toSet());
		//@formatter:on
	}

	/**
	 * Get text appropriate for the error type column header
	 *
	 * Used by:
	 * 	* FamilyErrors.ErrorTypesFamilyErrors.Label-Header Label Expression
	 * 	* TopLevelErrors.ErrorTypesTopLevelErrors.Label-Header Label Expression
	 *
	 * @param self The error type to get the title from
	 * @return Appropriate header text
	 */
	public static String getErrorTypeColumnHeader(EObject self) {
		return ((ErrorType) self).getName();
	}

	/**
	 * Used by:
	 * 	* FamilyErrors.ControlActionsFamilyErrors.Label-Header Label Expression
	 *  * TopLevelErrors.ControlActionsTopLevelErrors.Label-Header Label Expression
	 */
	public static String getControlActionRowHeader(EObject self) {
		return ((ConnectionInstance) self).getName();
	}

	/**
	 * Used by: FamilyErrors.ErrorTypesFamilyErrors.General-Semantic Candidates Expression
	 *
	 * @param self A connection. Currently unused, but required by Sirius.
	 * @param containerView The cell the user clicked, used for determining the error family.
	 * @return All error types that have the error type referenced by the cell's column as a supertype
	 */
	public static Collection<EObject> getFamilyErrorTypes(EObject self, DCellSpec containerView) {
		ErrorType root = (ErrorType) containerView.getColumn().getSemanticElements().get(0);
		ResourceSet rs = root.eResource().getResourceSet();
		ErrorTypeTreeBuilder ettb;

		Collection<EObject> subtypes = new HashSet<>();
		Queue<ErrorType> toProcess = new LinkedList<>();
		ErrorType curType;
		toProcess.add(root);
		while (!toProcess.isEmpty()) {
			ettb = new ErrorTypeTreeBuilder(rs); // Have to re-init for each call of findUsage to avoid NPE
			curType = toProcess.poll();
			//@formatter:off
			Collection<ErrorType> newTypes = ettb.findUsage(curType).stream()
					.map(e -> (ErrorType) e.getEObject())
					.collect(Collectors.toSet());
			//@formatter:on
			toProcess.addAll(newTypes);
			subtypes.addAll(newTypes);
		}
		return subtypes;
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

	public static String getCauseAndCompensation(EObject self, EObject lineSemantic, EObject columnSemantic,
			EObject root, DLine line, DColumn column, EObject container) {
		EClass eClazz = self.eClass();
		FeatureInstance fi = (FeatureInstance) ((ConnectionInstance) self).getSource();
		Collection settings = EcoreUtil.UsageCrossReferencer.find(fi, self.eResource().getResourceSet());
		if (!line.getLines().isEmpty()) {
			return "Cause: Bad stuff happened.";
		} else {
			return "Compensation: Bad stuff should not happen.";
		}
	}

	public static EObject duplicate(EObject self) {
		return self;
	}

	public static Collection<EObject> debug(EObject self) {
		return null;// service:getFamilyErrorTypes(containerView)
	}

	public static boolean debugPrecondition(EObject self) {
		return true;
	}

	/**
	 * This class is used by {@link #getFamilyErrorTypes(EObject, DCellSpec)} to
	 * calculate all subtypes of a particular error type.
	 *
	 * This is lightly adapted from pages 524-525 of "EMF Eclipse Modeling
	 * Foundation" by Steinberg, Budinsky, Paternostro, and Merks (2nd ed)
	 *
	 * @author sprocter
	 *
	 */
	private static class ErrorTypeTreeBuilder extends UsageCrossReferencer {
		protected ErrorTypeTreeBuilder(ResourceSet resourceSet) {
			super(resourceSet);
		}

		private static final long serialVersionUID = 1L;

		@Override
		protected boolean crossReference(EObject eObject, EReference eReference, EObject referencedObj) {
			// We only want supertype references (left hand side) and those types
			// that actually cross-reference our object (right hand side)
			return eReference.getName().equals("superType") && super.crossReference(eObject, eReference, referencedObj);
		}

		@Override
		protected boolean containment(EObject eObject) {
			// This restricts the search to AADL objects that point at the error type
			// (as opposed to, eg, sirius objects)
			return eObject instanceof AObject;
		}

		@Override
		public Collection<Setting> findUsage(EObject eObject) {
			// we have to override this to change its visibility
			return super.findUsage(eObject);
		}
	}
}
