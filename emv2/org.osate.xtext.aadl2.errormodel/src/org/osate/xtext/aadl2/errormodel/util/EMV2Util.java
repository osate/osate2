package org.osate.xtext.aadl2.errormodel.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2InstanceUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.errorModel.AllExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
import org.osate.xtext.aadl2.errormodel.errorModel.impl.AndExpressionImpl;
import org.osate.xtext.aadl2.errormodel.errorModel.impl.OrExpressionImpl;

public class EMV2Util {

	public final static String ErrorModelAnnexName = "EMV2";

	public static String getLibraryName(ErrorModelLibrary lib) {
		AadlPackage root = EcoreUtil2.getContainerOfType(lib, AadlPackage.class);
		if (root != null) {
			return root.getName();
		}
		return lib.getName();
	}

	public static ErrorSource getErrorSource(ComponentInstance ci, ErrorPropagation ep) {
		Collection<ErrorFlow> flows = getAllErrorFlows(ci);
		for (ErrorFlow ef : flows) {
			if (ef instanceof ErrorSource) {
				ErrorSource es = (ErrorSource) ef;
				if (es.getSourceModelElement() == ep) {
					return es;
				}

			}
		}
		return null;
	}

	/**
	 * get ErrorModelSubclause object in the classifier
	 * @param cl classifier
	 * @return ErrorModelSubclause
	 */
	private static void getClassifierEMV2Subclause(ComponentClassifier cl, EList<ErrorModelSubclause> result) {
		ErrorModelSubclause ems = getOwnEMV2Subclause(cl);
		if (ems != null) {
			result.add(ems);
		}
	}

	/**
	 * recursively add all EMV2 subclauses of classifier and its extends ancestors
	 * in case of implementations do not follow to the type
	 * cl can be null or an unresolved proxy.
	 * if cl has a subclause its subclause is added before following the extends hierarhy
	 * @param cl Component Implementation
	 * @param result list of EMV2 subclauses
	 */
	private static void getAllClassifierEMV2Subclause(ComponentClassifier cl, EList<ErrorModelSubclause> result) {
		if (!Aadl2Util.isNull(cl)) {
			getClassifierEMV2Subclause(cl, result);
			getAllClassifierEMV2Subclause((ComponentClassifier) cl.getExtended(), result);
		}
	}

	/**
	 * return the list of EMV2 subclauses of the classifier and
	 * The extends hierarchy and the type in the case of an implementation are searched for the ErrorModelSubcany of its extends ancestors
	 * @param element declarative model element or error annex element or instance object
	 * @return ErrorModelSubclause
	 */
	public static EList<ErrorModelSubclause> getAllContainingClassifierEMV2Subclauses(Element element) {
		Classifier cl = null;
		if (element instanceof InstanceObject) {
			ComponentInstance ci = ((InstanceObject) element).getComponentInstance();
			cl = ci.getComponentClassifier();
		} else if (element != null) {
			cl = getAssociatedClassifier(element);
		}
		EList<ErrorModelSubclause> result = new BasicEList<ErrorModelSubclause>();
		if (cl == null) {
			ErrorModelSubclause localemsc = getContainingErrorModelSubclause(element);
			if (localemsc != null) {
				result.add(localemsc);
			}
			return result;
		}
		if (cl instanceof ComponentImplementation) {
			getAllClassifierEMV2Subclause((ComponentImplementation) cl, result);
			getAllClassifierEMV2Subclause(((ComponentImplementation) cl).getType(), result);
		} else if (cl instanceof ComponentType) {
			getAllClassifierEMV2Subclause((ComponentType) cl, result);
		}
		return result;
	}

	/**
	 * return the component classifier that this subclause element belongs to.
	 * The subclause can be embedded or separate.
	 * @param an EObject in a EMV2 subclause
	 * @return ComponentClassifier
	 */
	public static ComponentClassifier getAssociatedClassifier(Element emv2Element) {

		ComponentClassifier cl = (ComponentClassifier) emv2Element.getContainingClassifier();
		if (cl != null) {
			return cl;
		}
		ErrorModelSubclause emsc = getContainingErrorModelSubclause(emv2Element);
		if (emsc == null || !emsc.getName().equalsIgnoreCase("EMV2")) {
			// we are not inside an EMV2 subclause
			return null;
		}
		return Aadl2GlobalScopeUtil.get(emsc, Aadl2Package.eINSTANCE.getComponentClassifier(), emsc.getQualifiedName());
	}

	/**
	 * get the separately stored EMV2 subclause, which is assumed to have the name of the classifier
	 * @param cl Component Classifier
	 * @return ErrorModelSubclause
	 */
	public static ErrorModelSubclause getAssociatedEMV2Subclause(ComponentClassifier cl) {
		return Aadl2GlobalScopeUtil.get(cl, ErrorModelPackage.eINSTANCE.getErrorModelSubclause(),
				cl.getQualifiedName());
	}

	/**
	 * get the error model subclause for the specified classifier.
	 * Do it for the separately stored first, if not found then embedded subclause
	 * Does not look in the extends hierarchy
	 * @param cl CLassifier
	 * @return
	 */
	public static ErrorModelSubclause getOwnEMV2Subclause(ComponentClassifier cl) {
		if (cl == null) {
			return null;
		}
		// separately stored EMV2 subclause
		ErrorModelSubclause emsc = getAssociatedEMV2Subclause(cl);
		if (emsc != null) {
			return emsc;
		}
		// embedded EMV2 subclause
		return getEmbeddedEMV2Subclause(cl);
	}

	public static ErrorModelSubclause getEmbeddedEMV2Subclause(ComponentClassifier cl) {
		// embedded EMV2 subclause
		EList<AnnexSubclause> asl = cl.getOwnedAnnexSubclauses();
		for (AnnexSubclause al : asl) {
			AnnexSubclause actal = ((DefaultAnnexSubclause) al).getParsedAnnexSubclause();
			if (actal instanceof ErrorModelSubclause) {
				return ((ErrorModelSubclause) actal);
			}
		}
		return null;

	}

	/**
	 * find the first subclause on the classifier or its extends hierarchy.
	 * When used on a component implementation this method does not go from an implementation to a type.
	 *
	 * @param cl
	 * @return
	 */
	public static ErrorModelSubclause getExtendsEMV2Subclause(ComponentClassifier cl) {
		if (cl == null) {
			return null;
		}
		ErrorModelSubclause ems = getOwnEMV2Subclause(cl);
		if (ems != null) {
			return ems;
		}
		if (!Aadl2Util.isNull(cl.getExtended())) {
			ems = getExtendsEMV2Subclause((ComponentClassifier) cl.getExtended());
			if (ems != null) {
				return ems;
			}
		}
		return null;
	}

	/**
	 * return first error model subclause that has a use types and return the list of libraries
	 * @param cl
	 * @return EList<ErrorModelLibrary>
	 */
	public static EList<ErrorModelLibrary> getErrorModelSubclauseWithUseTypes(Classifier cl) {
		EList<ErrorModelSubclause> result = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : result) {
			return errorModelSubclause.getUseTypes();
		}
		return null;
	}

	/**
	 * Check to see if all NamedElements in the Elist have a unique name.
	 * Do not account for Error Propagations. They are checked separately.
	 * this method handles error propagations as well, using their printname.
	 *
	 * list can contain object that are not NamedElements.
	 * @param el EList or NamedElements or other objects
	 * @return EList of NameElements that are defining a previously defined name
	 */
	public static List<NamedElement> findDoubleNamedElementsInList(Collection<?> el) {
		List<NamedElement> result = new ArrayList<NamedElement>();
		final Set<String> seen = new HashSet<String>();

		if (el != null) {
			for (final Object obj : el) {
				if (obj instanceof NamedElement && !(obj instanceof ErrorPropagation)) {
					final NamedElement lit = (NamedElement) obj;
					String name = lit.getName();
					if (name != null && !name.isEmpty()) {
						name = name.toLowerCase();
						if (!seen.add(name)) {
							result.add(lit);
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * find propagation point including those inherited from classifiers being extended
	 * @param element context
	 * @param name String
	 * @return PropagationPoint propagation point
	 */
	public static PropagationPoint findPropagationPoint(Element element, String name) {
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(element);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<PropagationPoint> eflist = errorModelSubclause.getPoints();
			for (PropagationPoint propPoint : eflist) {
				if (name.equalsIgnoreCase(propPoint.getName())) {
					return propPoint;
				}
			}
		}
		return null;
	}

	public static String getPath(FeatureorPPReference ref) {
		if (ref == null) {
			return "";
		}
		if (ref.getNext() != null) {
			return ref.getFeatureorPP().getName() + "." + getPath(ref.getNext());
		} else {
			return ref.getFeatureorPP().getName();
		}
	}

	/**
	 * Find error propagation in classifier hierarchy
	 * name can be a dotted name
	 * @param elem the context whose containing classifier is searched hierarchically to find the error propagation
	 * @param name
	 * @param dir
	 * @return
	 */
	public static ErrorPropagation findErrorContainment(Element elem, String name, DirectionType dir) {
		Classifier cl = getAssociatedClassifier(elem);
		if (cl != null) {
			return findErrorContainment(cl, name, dir);
		}
		return null;
	}

	/**
	 * Find error propagation  starting with the specified classifier
	 * goes up the inheritance hierarchy
	 * name can be a dotted name
	 * @param cl the classifier in the context of which we find the error propagation
	 * @param name
	 * @param dir
	 * @return
	 */
	public static ErrorPropagation findErrorContainment(Classifier cl, String name, DirectionType dir) {
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<ErrorPropagation> eflist = errorModelSubclause.getPropagations();
			for (ErrorPropagation ep : eflist) {
				if (ep.isNot() && ep.getDirection().equals(dir)) {
					if (ep.getKind() != null) {
						if (ep.getKind().equalsIgnoreCase(name)) {
							return ep;
						}
					} else {
						String refname = EMV2Util.getPath(ep.getFeatureorPPRef());
						if (refname.equalsIgnoreCase(name)) {
							return ep;
						}
					}
				}
			}
		}
		return null;
	}

	public static ErrorPropagation findSubcomponentOrIncomingErrorProparation(Element elem, String name) {
		Classifier cl = getAssociatedClassifier(elem);
		if (cl == null) {
			return null;
		}
		EList<Subcomponent> subs;
		int idx = name.indexOf('.');
		boolean foundSub = false;
		boolean findMore = true;
		while (idx != -1 && findMore) {
			String subname = name.substring(0, idx);
			findMore = false;
			if (cl instanceof ComponentImplementation) {
				subs = ((ComponentImplementation) cl).getAllSubcomponents();
				for (Subcomponent sub : subs) {
					if (sub.getName().equalsIgnoreCase(subname)) {
						name = name.substring(idx + 1);
						cl = sub.getClassifier();
						idx = name.indexOf('.');
						foundSub = true;
						findMore = true;
					}
				}
			}
		}

		if (foundSub) {
			return EMV2Util.findErrorPropagation(cl, name, DirectionType.OUT);
		} else {
			return EMV2Util.findErrorPropagation(cl, name, DirectionType.IN);
		}
	}

	/**
	 * Find error propagation in classifier hierarchy
	 * name can be a dotted name
	 * @param elem the context whose containing classifier is searched hierarchically to find the error propagation
	 * @param name
	 * @param dir
	 * @return
	 */
	public static ErrorPropagation findErrorPropagation(Element elem, String name, DirectionType dir) {
		Classifier cl = getAssociatedClassifier(elem);
		if (cl != null) {
			return findErrorPropagation(cl, name, dir);
		}
		return null;
	}

	/**
	 * Find error propagation in classifier hierarchy
	 * name can be a dotted name
	 * @param cl the classifier in the context of which we find the error propagation
	 * @param name
	 * @param dir
	 * @return
	 */
	public static ErrorPropagation findErrorPropagation(Classifier cl, String name, DirectionType dir) {
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<ErrorPropagation> eflist = errorModelSubclause.getPropagations();
			for (ErrorPropagation ep : eflist) {
				if (!ep.isNot() && ep.getDirection().equals(dir)) {
					if (ep.getKind() != null) {
						if (ep.getKind().equalsIgnoreCase(name)) {
							return ep;
						}
					} else {
						String refname = EMV2Util.getPath(ep.getFeatureorPPRef());
						if (refname != null && name.equalsIgnoreCase(refname)) {
							return ep;
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * find the incoming error propagation point of the specified name
	 * @param cl the classifier in the context of which we find the error propagation
	 * @param eppName Name of error propagation point we are looking for
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findIncomingErrorPropagation(Classifier cl, String eppName) {
		return findErrorPropagation(cl, eppName, DirectionType.IN);
	}

	/**
	 * find the outgoing error propagation point of the specified name
	 * @param cl the classifier in the context of which we find the error propagation
	 * @param eppName Name of error propagation point we are looking for
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findOutgoingErrorPropagation(Classifier cl, String eppName) {
		return findErrorPropagation(cl, eppName, DirectionType.OUT);
	}

	/**
	 * find the outgoing error containment point of the specified name
	 * @param cl the classifier in the context of which we find the error propagation
	 * @param eppName Name of error propagation point we are looking for
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findOutgoingErrorContainment(Classifier cl, String eppName) {
		return findErrorContainment(cl, eppName, DirectionType.OUT);
	}

	/**
	 * find the incoming error propagation point of the specified name
	 * @param cl the classifier in the context of which we find the error propagation
	 * @param eppName Name of error propagation point we are looking for
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findIncomingErrorContainment(Classifier cl, String eppName) {
		return findErrorContainment(cl, eppName, DirectionType.IN);
	}

	public static String getFeatureInstancePath(FeatureInstance fi) {
		String res = fi.getName();
		NamedElement current = fi;
		while (current.getOwner() instanceof FeatureInstance) {
			current = (NamedElement) current.getOwner();
			res = current.getName() + "." + res;
		}
		return res;
	}

	/**
	 * Get outgoing error propagation associated with feature instance or its enclosing feature instance
	 * Find it for the current feature instance or any enclosing feature instances
	 * @param fi feature instance
	 * @return error propagation
	 */
	public static ErrorPropagation getOutgoingErrorPropagation(FeatureInstance fi) {
		if (!fi.getFlowDirection().outgoing()) {
			return null;
		}
		ComponentInstance ci = fi.getContainingComponentInstance();
		FeatureInstance current = fi;
		ErrorPropagation res = EMV2Util.findOutgoingErrorPropagation(ci.getComponentClassifier(),
				getFeatureInstancePath(current));
		while (res == null && current.getOwner() instanceof FeatureInstance) {
			current = (FeatureInstance) current.getOwner();
			res = EMV2Util.findOutgoingErrorPropagation(ci.getComponentClassifier(), getFeatureInstancePath(current));
		}
		return res;
	}

	/**
	 * Get incoming error propagation associated with feature instance or its enclosing feature instance
	 * @param fi feature instance
	 * @return error propagation
	 */
	public static ErrorPropagation getIncomingErrorPropagation(FeatureInstance fi) {
		if (!fi.getFlowDirection().incoming()) {
			return null;
		}
		ComponentInstance ci = fi.getContainingComponentInstance();
		FeatureInstance current = fi;
		ErrorPropagation res = EMV2Util.findIncomingErrorPropagation(ci.getComponentClassifier(),
				getFeatureInstancePath(current));
		while (res == null && current.getOwner() instanceof FeatureInstance) {
			current = (FeatureInstance) current.getOwner();
			return EMV2Util.findIncomingErrorPropagation(ci.getComponentClassifier(), getFeatureInstancePath(current));
		}
		return res;
	}

	/**
	 * Get outgoing error propagation associated with feature instance or its enclosing feature instance
	 * @param fi feature instance
	 * @return error propagation
	 */
	public static ErrorPropagation getOutgoingErrorContainment(FeatureInstance fi) {
		if (!fi.getFlowDirection().outgoing()) {
			return null;
		}
		ComponentInstance ci = fi.getContainingComponentInstance();
		FeatureInstance current = fi;
		ErrorPropagation res = EMV2Util.findOutgoingErrorContainment(ci.getComponentClassifier(),
				getFeatureInstancePath(current));
		while (res == null && current.getOwner() instanceof FeatureInstance) {
			current = (FeatureInstance) current.getOwner();
			return EMV2Util.findOutgoingErrorContainment(ci.getComponentClassifier(), getFeatureInstancePath(current));
		}
		return res;
	}

	/**
	 * Get incoming error propagation associated with feature instance or its enclosing feature instance
	 * @param fi feature instance
	 * @return error propagation
	 */
	public static ErrorPropagation getIncomingErrorContainment(FeatureInstance fi) {
		if (!fi.getFlowDirection().incoming()) {
			return null;
		}
		ComponentInstance ci = fi.getContainingComponentInstance();
		FeatureInstance current = fi;
		ErrorPropagation res = EMV2Util.findIncomingErrorContainment(ci.getComponentClassifier(),
				getFeatureInstancePath(current));
		while (res == null && current.getOwner() instanceof FeatureInstance) {
			current = (FeatureInstance) current.getOwner();
			return EMV2Util.findIncomingErrorContainment(ci.getComponentClassifier(), getFeatureInstancePath(current));
		}
		return res;
	}

	/**
	 * Get incoming error propagation associated with component instance access
	 * @param ci component instance
	 * @return error propagation
	 */
	public static ErrorPropagation getIncomingAccessErrorPropagation(ComponentInstance ci) {
		return EMV2Util.findIncomingErrorPropagation(ci.getComponentClassifier(), "access");
	}

	/**
	 * Get outgoing error propagation associated with component instance access
	 * @param ci component instance
	 * @return error propagation
	 */
	public static ErrorPropagation getOutgoingAccessErrorPropagation(ComponentInstance ci) {
		return EMV2Util.findOutgoingErrorPropagation(ci.getComponentClassifier(), "access");
	}

	/**
	 * Get incoming error Containment associated with component instance access
	 * @param ci component instance
	 * @return error propagation
	 */
	public static ErrorPropagation getIncomingAccessErrorContainment(ComponentInstance ci) {
		return EMV2Util.findIncomingErrorContainment(ci.getComponentClassifier(), "access");
	}

	/**
	 * Get outgoing error Containment associated with component instance access
	 * @param ci component instance
	 * @return error propagation
	 */
	public static ErrorPropagation getOutgoingAccessErrorContainment(ComponentInstance ci) {
		return EMV2Util.findOutgoingErrorContainment(ci.getComponentClassifier(), "access");
	}

	/**
	 * find error flow starting with given classifier by looking through all error flows
	 * @param cl
	 * @param name
	 * @return ErrorFlow
	 */
	public static ErrorFlow findErrorFlow(Element el, String name) {
		Classifier cl = getAssociatedClassifier(el);
		if (cl != null) {
			Collection<ErrorFlow> eflist = getAllErrorFlows(cl);
			return (ErrorFlow) AadlUtil.findNamedElementInList(eflist, name);
		}
		return null;
	}

	/**
	 * Find ConnectionErrorSource with given classifier by looking through all connection error sources
	 * @param conni the connection instance whose connection declarations we're using
	 * @return the connection error source or null
	 */

	public static ErrorSource findConnectionErrorSourceForConnection(ConnectionInstance conni) {
		for (ConnectionReference connref : conni.getConnectionReferences()) {
			Connection conn = connref.getConnection();
			Classifier cl = getAssociatedClassifier(conn);
			if (cl != null) {
				Collection<ErrorSource> ceslist = getAllConnectionErrorSources(cl);
				for (ErrorSource ces : ceslist) {
					if (ces.isAll() || ces.getSourceModelElement().getName().equalsIgnoreCase(conn.getName())) {
						return ces;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Find ErrorType with given name by looking through all error types
	 * referenced in all EMV2 subclauses of the supplied element's containing
	 * classifier
	 * @param el the element whose classifier we're using
	 * @param name the name of the Errortype to search for
	 * @return the specified error type, or null, if either the element's classifier is null or no
	 * ErrorType by the specified name was found
	 */
	public static ErrorType findErrorType(Element el, String name) {
		Classifier cl = getAssociatedClassifier(el);
		if (cl != null) {
			for (ErrorModelSubclause currSubclause : getAllContainingClassifierEMV2Subclauses(cl)) {
				for (ErrorModelLibrary currLibrary : currSubclause.getUseTypes()) {
					return (ErrorType) AadlUtil.findNamedElementInList(currLibrary.getTypes(), name);
				}
			}
		}
		return null;
	}

	/**
	 * Find ErrorType set with given name by looking through all error types
	 * referenced in all EMV2 subclauses of the supplied element's containing
	 * classifier
	 * @param el the element whose classifier we're using
	 * @param name the name of the ErrorTypeSet to search for
	 * @return the specified error type set, or null, if either the element's classifier is null or no
	 * ErrorType by the specified name was found
	 */
	public static TypeSet findErrorTypeSet(Element el, String name) {
		Classifier cl = getAssociatedClassifier(el);
		if (cl != null) {
			for (ErrorModelSubclause currSubclause : getAllContainingClassifierEMV2Subclauses(cl)) {
				for (ErrorModelLibrary currLibrary : currSubclause.getUseTypes()) {
					return (TypeSet) AadlUtil.findNamedElementInList(currLibrary.getTypesets(), name);
				}
			}
		}
		return null;
	}

	/**
	 * find the error flow whose incoming error propagation point is flowSource
	 * @param eps List of error propagations
	 * @param flowSource ErrorPropagation
	 * @return ErrorFlow list
	 */
	public static EList<ErrorFlow> findErrorFlowFrom(Collection<ErrorFlow> efs, ErrorPropagation flowSource) {
		EList<ErrorFlow> result = new BasicEList<ErrorFlow>();
		for (ErrorFlow ef : efs) {
			ErrorPropagation eprop = null;
			if (ef instanceof ErrorPath) {
				ErrorPath ep = (ErrorPath) ef;
				eprop = ep.getIncoming();
			} else if (ef instanceof ErrorSink) {
				ErrorSink es = (ErrorSink) ef;
				eprop = es.getIncoming();

			}
			if (eprop != null && eprop == flowSource) {
				result.add(ef);
			}
		}
		return result;
	}

	/**
	 * find the error flow whose incoming error propagation point is flowSource
	 * @param eps List of error propagations
	 * @param flowSource ErrorPropagation
	 * @return ErrorFlow list
	 */
	public static EList<ErrorFlow> findErrorFlow(Collection<ErrorFlow> efs, ErrorPropagation flowSource,
			ErrorTypes sourceType, ErrorPropagation flowTarget, ErrorTypes targetType) {
		EList<ErrorFlow> result = new BasicEList<ErrorFlow>();
		for (ErrorFlow ef : efs) {
			if (ef instanceof ErrorPath && flowSource != null) {
				ErrorPath ep = (ErrorPath) ef;
				if ((!ep.isAllIncoming() && EMV2Util.isSame(flowSource, ep.getIncoming()))
						&& (!ep.isAllOutgoing() && EMV2Util.isSame(flowTarget, ep.getOutgoing()))) {
					if (EMV2TypeSetUtil.contains(ep.getTypeTokenConstraint(), sourceType)
							&& EMV2TypeSetUtil.contains(ep.getTargetToken(), targetType)) {
						result.add(ep);
					}
				}
			} else if (ef instanceof ErrorSource) {
				ErrorSource es = (ErrorSource) ef;
				if (!es.isAll() && EMV2Util.isSame(flowTarget, es.getSourceModelElement())
						&& EMV2TypeSetUtil.contains(es.getTypeTokenConstraint(), targetType)) {
					result.add(es);
				}
			}
		}
		return result;
	}

	public static boolean areEquivalent(ErrorPropagation ep1, ErrorPropagation ep2) {
		String path1 = getPath(ep1.getFeatureorPPRef());
		String path2 = getPath(ep2.getFeatureorPPRef());
		return path1.equalsIgnoreCase(path2) && EMV2TypeSetUtil.contains(ep1.getTypeSet(), ep2.getTypeSet())
				&& EMV2TypeSetUtil.contains(ep2.getTypeSet(), ep1.getTypeSet());
	}

	/**
	 * Return true if a ConditionExpression object contains a reference to a specific error propagation.
	 * In fact, we are looking for an incoming error propagation that may trigger a condition
	 * (for example, switching to a state, propagating an error, etc.
	 *
	 * @param conditionExpression : the conditionExpression that may contain a reference to the error propagation
	 * @param errorPropagation    : the incoming propagation we are looking for as a referenced condition
	 * @return if the conditionExpression contains a reference (either with a or or and) to the error propagation passed as the second parameter.
	 */
	public static boolean errorConditionContainsIncomingPropagation(ConditionExpression conditionExpression,
			ErrorPropagation errorPropagation) {
		boolean result = false;
		if (conditionExpression instanceof ConditionElement) {
			ConditionElement ce = (ConditionElement) conditionExpression;
			NamedElement eop = getErrorModelElement(ce);
			if (eop instanceof ErrorPropagation) {
				if (areEquivalent((ErrorPropagation) eop, errorPropagation)) {
					return true;
				}
			}
		}

		if (conditionExpression instanceof AndExpressionImpl) {
			AndExpressionImpl ae = (AndExpressionImpl) conditionExpression;
			for (ConditionExpression ce : ae.getOperands()) {
				if (errorConditionContainsIncomingPropagation(ce, errorPropagation)) {
					result = true;
				}
			}
		}

		if (conditionExpression instanceof OrExpressionImpl) {
			OrExpressionImpl oe = (OrExpressionImpl) conditionExpression;
			for (ConditionExpression ce : oe.getOperands()) {
				if (errorConditionContainsIncomingPropagation(ce, errorPropagation)) {
					result = true;
				}
			}
		}

		return result;
	}

	/**
	 * For a given component and errorPropagation, it gives all the potential
	 * other outgoingpropagation. When we have a component with
	 * an incoming error propagation, this can be an error sink. On the other
	 * hand, receiving this error may trigger a state that will be used
	 * to propagate an error.
	 *
	 * Consider the model below. In that case, the pedalvalue feature is
	 * an error sink and makes the component to switch to the Failed state.
	 * On the other hand, being in the Failed state sends
	 * the NoValue error on brake and skid.
	 *
	 * In that case, the following method is used to return
	 * the outgoing error propagation related to an specific incoming
	 * error propagation. In the following examples, the incoming error
	 * propagation is pedalvalue, the outgoing error propagation Failed/brake and Failed/skid
	 *
	 * 	component error behavior
	 * 		transitions
	 * 			terrfrompedal 		: Operational -[pedalvalue{NoService}]-> Failed;
	 * 		propagations
	 * 			p1 : Failed -[]-> brake(NoValue);
	 * 			p2 : Failed -[]-> skid(NoValue);
	 * 		end component;
	 *
	 * @param component
	 * @param flowSource
	 * @return
	 */
	public static EList<OutgoingPropagationCondition> getAdditionalOutgoingPropagation(ComponentInstance component,
			ErrorPropagation flowSource) {
		EList<OutgoingPropagationCondition> result = new BasicEList<OutgoingPropagationCondition>();

		for (ErrorBehaviorTransition trans : EMV2Util.getAllErrorBehaviorTransitions(component)) {
			if (errorConditionContainsIncomingPropagation(trans.getCondition(), flowSource)) {

				for (OutgoingPropagationCondition opc : EMV2Util.getAllOutgoingPropagationConditions(component)) {

					if ((!result.contains(opc)) && (opc.getState() == trans.getTarget())) {
						result.add(opc);
					}
				}

			}

		}
		return result;
	}

	public static EList<ErrorFlow> findErrorFlowFromComponentInstance(ComponentInstance component,
			ErrorPropagation flowSource) {
		EList<ErrorFlow> result = new BasicEList<ErrorFlow>();
		Collection<ErrorFlow> efs = EMV2Util.getAllErrorFlows(component.getComponentClassifier());
		ErrorFlow toAdd;
		for (ErrorFlow ef : efs) {
			ErrorPropagation eprop = null;
			toAdd = ef;
			boolean isall = false;
			if (ef instanceof ErrorPath) {
				ErrorPath ep = (ErrorPath) ef;
				eprop = ep.getIncoming();
				isall = ep.isAllIncoming();
			} else if (ef instanceof ErrorSink) {
				ErrorSink es = (ErrorSink) ef;
				eprop = es.getIncoming();
				isall = es.isAllIncoming();
			}
			if ((eprop != null && eprop == flowSource) || isall) {
				result.add(toAdd);
			}
		}
		return result;
	}

	/**
	 * find the error flow whose outgoing error propagation point is flowSource
	 * @param eps List of error propagations
	 * @param flowSource ErrorPropagation
	 * @return ErrorFlow list
	 */
	public static EList<ErrorFlow> findReverseErrorFlowFrom(Collection<ErrorFlow> efs, ErrorPropagation flowSource) {
		EList<ErrorFlow> result = new BasicEList<ErrorFlow>();
		for (ErrorFlow ef : efs) {
			ErrorPropagation eprop = null;
			boolean isall = false;
			if (ef instanceof ErrorPath) {
				ErrorPath ep = (ErrorPath) ef;
				eprop = ep.getOutgoing();
				isall = ep.isAllOutgoing();
			} else if (ef instanceof ErrorSource
					&& ((ErrorSource) ef).getSourceModelElement() instanceof ErrorPropagation) {
				ErrorSource es = (ErrorSource) ef;
				eprop = (ErrorPropagation) es.getSourceModelElement();
				isall = es.isAll();
			}
			if ((eprop != null && eprop == flowSource) || isall) {
				result.add(ef);
			}
		}
		return result;
	}

	public static Collection<ErrorPropagation> getOutgoingPropagationOrAll(ErrorSource errorSource) {
		Collection<ErrorPropagation> eplist = null;
		if (errorSource.getSourceModelElement() != null
				&& errorSource.getSourceModelElement() instanceof ErrorPropagation) {
			eplist = new BasicEList<ErrorPropagation>();
			eplist.add((ErrorPropagation) errorSource.getSourceModelElement());
		} else if (errorSource.isAll()) {
			eplist = EMV2Util.getAllOutgoingErrorPropagations(getAssociatedClassifier(errorSource));
		}
		return eplist;
	}

	public static Collection<ErrorPropagation> getOutgoingPropagationOrAll(ErrorPath errorPath) {
		Collection<ErrorPropagation> eplist = null;
		if (errorPath.getOutgoing() != null) {
			eplist = new BasicEList<ErrorPropagation>();
			eplist.add(errorPath.getOutgoing());
		} else if (errorPath.isAllOutgoing()) {
			eplist = EMV2Util.getAllOutgoingErrorPropagations(getAssociatedClassifier(errorPath));
		}
		return eplist;
	}

	/**
	 * find Error Behavior State utilizing use behavior or within EBSM
	 *
	 * @param context context of the reference to the state
	 * @param name String
	 * @return ErrorBehavior State
	 */
	public static ErrorBehaviorState findErrorBehaviorState(Element context, String name) {
		ErrorBehaviorStateMachine ebsm;
		if (context instanceof QualifiedErrorBehaviorState) {
			// look up state in state machine of subcomponent
			QualifiedErrorBehaviorState qualifiedState = (QualifiedErrorBehaviorState) context;
			Subcomponent sub = qualifiedState.getSubcomponent().getSubcomponent();
			ComponentClassifier subcl = sub.getAllClassifier();
			if (subcl == null) {
				return null;
			}
			return findErrorBehaviorState(subcl, name);
		} else {
//			// first see if it is in type bindings
//			EList<ErrorBehaviorState> typebindings = getErrorBehaviorStateTypeBindings(context);
//			if (typebindings != null){
//				for (ErrorBehaviorState ebs : typebindings) {
//					if (name.equalsIgnoreCase(ebs.getName())){
//						return ebs;
//					}
//				}
//			}
			// resolve in local context, which is assumed to be an EBSM
			ebsm = EMV2Util.getErrorBehaviorStateMachine(context);
			return findErrorBehaviorStateInEBSM(ebsm, name);
		}
	}

//	/**
//	 * need to use this if the error behavior state is in the state machine and it is overwritten by type binding
//	 * @param es Error State whose type we are looking for
//	 * @param context context of reference to error state
//	 * @return TypeSet
//	 */
//	public static TypeSet getErrorTypeSet(ErrorBehaviorState es, Element context){
//		EList<ErrorBehaviorState> typebindings = getErrorBehaviorStateTypeBindings(context);
//		for (ErrorBehaviorState typeBinding : typebindings) {
//			if (es.getName().equalsIgnoreCase(typeBinding.getName())){
//				return typeBinding.getTypeSet();
//			}
//		}
//		return es.getTypeSet();
//	}

//	/**
//	 * get the type bindings list from use behavior
//	 * @param element
//	 * @return
//	 */
//	public static EList<ErrorBehaviorState> getErrorBehaviorStateTypeBindings(Element element){
//		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(element);
//		for (ErrorModelSubclause errorModelSubclause : emslist) {
//			EList<ErrorBehaviorState> result = errorModelSubclause.getStateTypeBindings();
//			if (result!= null){
//				return result;
//			}
//		}
//		return null;
//	}

	/**
	 * find error behavior state in state machine
	 * @param ebsm
	 * @param name
	 * @return
	 */
	private static ErrorBehaviorState findErrorBehaviorStateInEBSM(ErrorBehaviorStateMachine ebsm, String name) {
		if (ebsm != null) {
			EList<ErrorBehaviorState> ebsl = ebsm.getStates();
			for (ErrorBehaviorState ebs : ebsl) {
				if (Aadl2Util.getItemNameWithoutQualification(name).equalsIgnoreCase(ebs.getName())) {
					return ebs;
				}
			}
//			// enable if we support extends on EBSM
//			if (ebsm.getExtends() != null){
//				return findErrorBehaviorStateInEBSM(ebsm.getExtends(), name);
//			}
		}
		return null;
	}

	/**
	 * find error behavior transition in the specified context, i.e., its enclosing classifier subclause or inherited subclauses
	 * we look in the component error behavior sections first, and then in the EBSM of the use behavior.
	 * @param context
	 * @param name
	 * @return
	 */
	public static ErrorBehaviorTransition findErrorBehaviorTransition(Element context, String name) {
		Classifier cl = getAssociatedClassifier(context);
		if (cl != null) {
			// we are not in an error library
			ErrorBehaviorTransition ebt = findErrorBehaviorTransitioninCEB(cl, name);
			if (ebt != null) {
				return ebt;
			}
			// find it in the EBSM from the use behavior
			return findErrorBehaviorTransitioninUseBehavior(cl, name);
		} else {
			// we are inside an error library resolving transition references
			ErrorBehaviorStateMachine ebsm = EMV2Util.getErrorBehaviorStateMachine(context);
			return findErrorBehaviorTransitionInEBSM(ebsm, name);
		}
	}

	/**
	 * find transition in EBSM specified in use behavior
	 * @param cl classifier as context of use behavior
	 * @param name
	 * @return
	 */
	private static ErrorBehaviorTransition findErrorBehaviorTransitioninUseBehavior(Classifier cl, String name) {
		if (cl == null) {
			return null;
		}
		ErrorBehaviorStateMachine ebsm = EMV2Util.getErrorBehaviorStateMachine(cl);
		if (ebsm != null) {
			return findErrorBehaviorTransitionInEBSM(ebsm, name);
		}
		return null;
	}

	/**
	 * find transition in EBSM
	 * @param ebsm
	 * @param name
	 * @return
	 */
	private static ErrorBehaviorTransition findErrorBehaviorTransitionInEBSM(ErrorBehaviorStateMachine ebsm,
			String name) {
		if (ebsm != null) {
			EList<ErrorBehaviorTransition> ebsl = ebsm.getTransitions();
			for (ErrorBehaviorTransition ebs : ebsl) {
				if (Aadl2Util.getItemNameWithoutQualification(name).equalsIgnoreCase(ebs.getName())) {
					return ebs;
				}
			}
//			// enable if we introduce extends of EBSM
//			if (ebsm.getExtends() != null){
//				return findErrorBehaviorTransitionInEBSM(ebsm.getExtends(), name);
//			}
		}
		return null;
	}

	/**
	 * find the error behavior transition in the component error behavior looking in all inherited subclauses according to extends and type of implementation
	 * @param cl
	 * @param name
	 * @return
	 */
	private static ErrorBehaviorTransition findErrorBehaviorTransitioninCEB(Classifier cl, String name) {
		if (cl == null) {
			return null;
		}
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorBehaviorTransition res = findOwnErrorBehaviorTransition(errorModelSubclause, name);
			if (res != null) {
				return res;
			}
		}
		return null;
	}

	/**
	 * find transition in given subclause component error behavior
	 * @param ems
	 * @param name
	 * @return
	 */
	private static ErrorBehaviorTransition findOwnErrorBehaviorTransition(ErrorModelSubclause ems, String name) {
		if (ems == null) {
			return null;
		}
		EList<ErrorBehaviorTransition> transitions = ems.getTransitions();
		for (ErrorBehaviorTransition errorBehaviorTransition : transitions) {
			if (name.equalsIgnoreCase(errorBehaviorTransition.getName())) {
				return errorBehaviorTransition;
			}
		}
		return null;
	}

	private static ErrorBehaviorEvent findOwnErrorBehaviorEvent(ErrorModelSubclause ems, String name) {
		if (ems == null) {
			return null;
		}
		EList<ErrorBehaviorEvent> events = ems.getEvents();
		for (ErrorBehaviorEvent errorBehaviorEvent : events) {
			if (name.equalsIgnoreCase(errorBehaviorEvent.getName())) {
				return errorBehaviorEvent;
			}
		}
		return null;
	}

	/**
	 * find the error behavior event in the component error behavior looking in all inherited subclauses according to extends and type of implementation
	 * @param cl ComponentClassifier (May be null)
	 * @param name
	 * @return
	 */
	private static ErrorBehaviorEvent findErrorBehaviorEventinCEB(Classifier cl, String name) {
		if (cl == null) {
			return null;
		}
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorBehaviorEvent res = findOwnErrorBehaviorEvent(errorModelSubclause, name);
			if (res != null) {
				return res;
			}
		}
		return null;
	}

	/**
	 * find error behavior event in the specified context, i.e., its enclosing classifier subclause or inherited subclauses
	 * we look in the component error behavior sections first, and then in the EBSM of the use behavior.
	 * @param context
	 * @param name
	 * @return
	 */
	public static ErrorBehaviorEvent findErrorBehaviorEvent(Element context, String name) {
		Classifier cl = getAssociatedClassifier(context);
		// we are not in an error library
		ErrorBehaviorEvent ebt = findErrorBehaviorEventinCEB(cl, name);
		if (ebt != null) {
			return ebt;
		}
		// find it in the EBSM from the context
		ErrorBehaviorStateMachine ebsm = EMV2Util.getErrorBehaviorStateMachine(context);
		return findErrorBehaviorEventInEBSM(ebsm, name);
	}

	private static ErrorBehaviorEvent findErrorBehaviorEventInEBSM(ErrorBehaviorStateMachine ebsm, String name) {
		if (ebsm != null) {
			EList<ErrorBehaviorEvent> ebsl = ebsm.getEvents();
			for (ErrorBehaviorEvent ebs : ebsl) {
				if (Aadl2Util.getItemNameWithoutQualification(name).equalsIgnoreCase(ebs.getName())) {
					return ebs;
				}
			}
//			// enable if we support extends of EBSM
//			if (ebsm.getExtends() != null){
//				return findErrorBehaviorEventInEBSM(ebsm.getExtends(), name);
//			}
		}
		return null;
	}

	/**
	 * find Error Detection in own subclause component error behavior
	 * @param ems
	 * @param name
	 * @return
	 */
	private static OutgoingPropagationCondition findOwnOutgoingPropagationCondition(ErrorModelSubclause ems,
			ErrorPropagation ep, ErrorTypes type) {
		if (ems == null) {
			return null;
		}
		EList<OutgoingPropagationCondition> outgoingPs = ems.getOutgoingPropagationConditions();
		for (OutgoingPropagationCondition outgoingPropagationCondition : outgoingPs) {
			if (outgoingPropagationCondition.isAllPropagations()
					|| EMV2Util.isSame(outgoingPropagationCondition.getOutgoing(), ep)) {
				if (EMV2TypeSetUtil.contains(outgoingPropagationCondition.getTypeToken(), type)) {
					return outgoingPropagationCondition;
				}
			}
		}
		return null;
	}

	/**
	 * find outgoing propagation condition in the specified context.
	 * we look in the component error behavior sections .
	 * @param context
	 * @param ep
	 * @return
	 */
	public static boolean existsOutgoingPropagationCondition(Element context, ErrorPropagation ep, ErrorTypes type) {
		Classifier cl = getAssociatedClassifier(context);
		if (cl == null) {
			return false;
		}
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			OutgoingPropagationCondition res = findOwnOutgoingPropagationCondition(errorModelSubclause, ep, type);
			if (res != null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * return list of outgoing error propagations including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorPropagation> list of ErrorPropagations excluding duplicates
	 */
	public static Collection<ErrorPropagation> getAllOutgoingErrorPropagations(Classifier cl) {
		return getAllErrorPropagations(cl, DirectionType.OUT);
	}

	/**
	 * return list of error propagations including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorPropagation> list of ErrorPropagations excluding duplicates
	 */
	public static Collection<ErrorPropagation> getAllIncomingErrorPropagations(Classifier cl) {
		return getAllErrorPropagations(cl, DirectionType.IN);
	}

	public static Collection<ErrorPropagation> getAllIncomingErrorPropagations(ComponentInstance ci) {
		return getAllErrorPropagations(ci.getComponentClassifier(), DirectionType.IN);
	}

	/**
	 * return list of error propagations including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorPropagation> list of ErrorPropagation excluding duplicates
	 */
	public static Collection<ErrorPropagation> getAllErrorPropagations(Classifier cl, DirectionType dir) {
		HashMap<String, ErrorPropagation> result = new LinkedHashMap<>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<ErrorPropagation> eflist = errorModelSubclause.getPropagations();
			for (ErrorPropagation errorProp : eflist) {
				if (!errorProp.isNot() && errorProp.getDirection().equals(dir)) {
					String epname = EMV2Util.getPrintName(errorProp);
					if (!result.containsKey(epname)) {
						result.put(epname, errorProp);
					}
				}
			}
		}
		return result.values();
	}

	/**
	 * return list of ConnectionErrorSource including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ConnectionErrorSource> list of ConnectionErrorSource excluding duplicates
	 */
	public static Collection<ErrorSource> getAllConnectionErrorSources(Classifier cl) {
		HashMap<String, ErrorSource> result = new LinkedHashMap<>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<ErrorSource> eflist = errorModelSubclause.getConnectionErrorSources();
			for (ErrorSource errorProp : eflist) {
				String epname = EMV2Util.getPrintName(errorProp);
				if (!result.containsKey(epname)) {
					result.put(epname, errorProp);
				}
			}
		}
		return result.values();
	}

	/**
	 * determine if two propagations match by name.
	 * This is useful when we have inherited error propagations and one reference points
	 * to the original and the second one to the one overriding the original.
	 * @param ep1
	 * @param ep2
	 * @return
	 */
	public static boolean isSame(ErrorPropagation ep1, ErrorPropagation ep2) {
		return (getPropagationName(ep1).equalsIgnoreCase(getPropagationName(ep2)));

	}

	/**
	 * compare NamedElements by name.
	 * Useful when dealing with inheritence.
	 * @param errorModelElement1
	 * @param errorModelElement2
	 * @return
	 */
	public static boolean isSame(NamedElement errorModelElement1, NamedElement errorModelElement2) {
		if (errorModelElement1 instanceof ErrorPropagation && errorModelElement2 instanceof ErrorPropagation) {
			return isSame((ErrorPropagation) errorModelElement1, (ErrorPropagation) errorModelElement2);
		}
		return (errorModelElement1.getName().equalsIgnoreCase(errorModelElement2.getName()));
	}

	/**
	 * Determine if the two expressions are the same.
	 * Compare operators and compare referenced elements by pathname
	 * @param ce1
	 * @param ce2
	 * @return
	 */
	public static boolean isEqual(ConditionExpression ce1, ConditionExpression ce2) {
		if ((ce1 == null) && (ce2 == null)) {
			return true;
		}

		if (ce1 == null) {
			return false;
		}

		if (ce2 == null) {
			return false;
		}

		if (ce1.getClass() != ce2.getClass()) {
			return false;
		}
		// ConditionElement
		// AndExpression
		// SAndExpression
		// OrlessExpression
		// SOrExpression
		// SAndExpression
		// OrmoreExpression
		// They are the same class, so we test for only one being a certain class
		if (ce1 instanceof ConditionElement) {
			ConditionElement element1 = (ConditionElement) ce1;
			ConditionElement element2 = (ConditionElement) ce2;
			return (getPathNameWithoutType(element1.getQualifiedErrorPropagationReference().getEmv2Target())
					.equalsIgnoreCase(
							getPathNameWithoutType(element2.getQualifiedErrorPropagationReference().getEmv2Target())));
		}

		if (ce1 instanceof AndExpression) {
			AndExpression expr1 = (AndExpression) ce1;
			AndExpression expr2 = (AndExpression) ce2;
			if (expr1.getOperands().size() != expr2.getOperands().size()) {
				return false;
			}

			for (int i = 0; i < expr1.getOperands().size(); i++) {
				if (!isEqual(expr1.getOperands().get(i), expr2.getOperands().get(i))) {
					return false;
				}
			}
			return true;
		}

		if (ce1 instanceof OrExpression) {
			OrExpression expr1 = (OrExpression) ce1;
			OrExpression expr2 = (OrExpression) ce2;
			if (expr1.getOperands().size() != expr2.getOperands().size()) {
				return false;
			}

			for (int i = 0; i < expr1.getOperands().size(); i++) {
				if (!isEqual(expr1.getOperands().get(i), expr2.getOperands().get(i))) {
					return false;
				}
			}
			return true;
		}
		OsateDebug.osateDebug("[EMV2Util] isEqual does not handled this class type " + ce1 + "|" + ce2);
		return false;
	}

	/**
	 * return list of error containments including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorPropagation> list of ErrorPropagations excluding duplicates
	 */
	public static Collection<ErrorPropagation> getAllErrorContainments(Classifier cl, DirectionType dir) {
		HashMap<String, ErrorPropagation> result = new LinkedHashMap<>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<ErrorPropagation> eflist = errorModelSubclause.getPropagations();
			for (ErrorPropagation errorProp : eflist) {
				if (errorProp.isNot() && errorProp.getDirection().equals(dir)) {
					String epname = EMV2Util.getPrintName(errorProp);
					if (!result.containsKey(epname)) {
						result.put(epname, errorProp);
					}
				}
			}
		}
		return result.values();
	}

	/**
	 * return list of error flow including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorFlow> list of error flow
	 */
	public static Collection<ErrorFlow> getAllErrorFlows(Classifier cl) {
		HashMap<String, ErrorFlow> result = new LinkedHashMap<>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<ErrorFlow> eflist = errorModelSubclause.getFlows();
			for (ErrorFlow errorFlow : eflist) {
				if (!result.containsKey(errorFlow.getName())) {
					result.put(errorFlow.getName(), errorFlow);
				}
			}
		}
		return result.values();
	}

	public static Collection<ErrorFlow> getAllErrorFlows(ComponentInstance ci) {
		return getAllErrorFlows(ci.getComponentClassifier());
	}

	/**
	 * return list of error sources including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorSource> list of error flow
	 */
	public static Collection<ErrorSource> getAllErrorSources(Classifier cl) {
		HashMap<String, ErrorSource> result = new LinkedHashMap<>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<ErrorFlow> eflist = errorModelSubclause.getFlows();
			for (ErrorFlow errorFlow : eflist) {
				if (errorFlow instanceof ErrorSource) {
					if (!result.containsKey(errorFlow.getName())) {
						result.put(errorFlow.getName(), (ErrorSource) errorFlow);
					}
				}
			}
		}
		return result.values();
	}

	public static Collection<ErrorSource> getAllErrorSources(ComponentInstance ci) {
		return getAllErrorSources(ci.getComponentClassifier());
	}

	/**
	 * return list of error paths including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorSource> list of error paths declared in the flow section
	 */
	public static Collection<ErrorPath> getAllErrorPaths(Classifier cl) {
		HashMap<String, ErrorPath> result = new LinkedHashMap<>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<ErrorFlow> eflist = errorModelSubclause.getFlows();
			for (ErrorFlow errorFlow : eflist) {
				if (errorFlow instanceof ErrorPath) {
					if (!result.containsKey(errorFlow.getName())) {
						result.put(errorFlow.getName(), (ErrorPath) errorFlow);
					}
				}
			}
		}
		return result.values();
	}

	public static Collection<ErrorPath> getAllErrorPaths(ComponentInstance ci) {
		return getAllErrorPaths(ci.getComponentClassifier());
	}

	/**
	 * return list of error sinks including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorSource> list of error sinks declared in the flow section
	 */
	public static Collection<ErrorSink> getAllErrorSinks(Classifier cl) {
		HashMap<String, ErrorSink> result = new LinkedHashMap<>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<ErrorFlow> eflist = errorModelSubclause.getFlows();
			for (ErrorFlow errorFlow : eflist) {
				if (errorFlow instanceof ErrorSink) {
					if (!result.containsKey(errorFlow.getName())) {
						result.put(errorFlow.getName(), (ErrorSink) errorFlow);
					}
				}
			}
		}
		return result.values();
	}

	public static Collection<ErrorSink> getAllErrorSinks(ComponentInstance ci) {
		return getAllErrorSinks(ci.getComponentClassifier());
	}

	/** return the name for an error propagation **/
	public static String getPropagationName(ErrorPropagation propagation) {
		String res = propagation.getKind();
		if (res != null) {
			return res;
		}
		return getPath(propagation.getFeatureorPPRef());
	}

	/**
	 * return type transformation set to be used for connections.
	 * Looks for use transformations in classifier or inherited from classifiers being extended
	 * @param cl Classifier
	 * @return TypeTransformationSet
	 */
	public static TypeTransformationSet getAllTypeTransformationSet(ComponentInstance ci) {
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(ci);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			TypeTransformationSet tts = errorModelSubclause.getTypeTransformationSet();
			if (tts != null) {
				return tts;
			}
		}
		return null;
	}

	/**
	 * return type mapping set to be used for bindings other than connection bindings.
	 * Looks for use type equivalence in classifier or inherited from classifiers being extended
	 * Also look in parent component instances, i.e., the equivalence mapping is inherited down the component hierarchy
	 * @param ci Component Instance
	 * @return TypeMappingSet
	 */
	public static TypeMappingSet getAllTypeEquivalenceMapping(ComponentInstance ci) {
		while (ci != null) {
			EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(ci);
			for (ErrorModelSubclause errorModelSubclause : emslist) {
				TypeMappingSet tms = errorModelSubclause.getTypeEquivalence();
				if (tms != null) {
					return tms;
				}
			}
			ci = ci.getContainingComponentInstance();
		}
		return null;
	}

	public static TypeMappingSet getAllTypeEquivalenceMapping(Classifier cl) {

		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			TypeMappingSet tms = errorModelSubclause.getTypeEquivalence();
			if (tms != null) {
				return tms;
			}
		}

		return null;
	}

	/**
	 * return list of propagation points including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<PropagationPoint> list of propagation points as HashMap for quick lookup of names
	 */
	public static Collection<PropagationPoint> getAllPropagationPoints(Classifier cl) {
		HashMap<String, PropagationPoint> result = new LinkedHashMap<>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<PropagationPoint> eflist = errorModelSubclause.getPoints();
			for (PropagationPoint propPoint : eflist) {
				if (!result.containsKey(propPoint.getName())) {
					result.put(propPoint.getName(), propPoint);
				}
			}
		}
		return result.values();
	}

	/**
	 * return list of PropagationPaths including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<PropagationPath> list of PropagationPaths as HashMap for quick lookup of names
	 */
	public static Collection<PropagationPath> getAllPropagationPaths(Classifier cl) {
		HashMap<String, PropagationPath> result = new LinkedHashMap<>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<PropagationPath> eflist = errorModelSubclause.getPaths();
			for (PropagationPath propPointConn : eflist) {
				if (!result.containsKey(propPointConn.getName())) {
					result.put(propPointConn.getName(), propPointConn);
				}
			}
		}
		return result.values();
	}

	/**
	 * return list of ErrorBehaviorEvents including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorBehaviorEvent> list of ErrorBehaviorEvents as HashMap for quick lookup of names
	 */
	public static Collection<ErrorBehaviorEvent> getAllErrorBehaviorEvents(Classifier cl) {
		HashMap<String, ErrorBehaviorEvent> result = new LinkedHashMap<>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		boolean foundEBSM = false;
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorBehaviorStateMachine ebsm = errorModelSubclause.getUseBehavior();
			EList<ErrorBehaviorEvent> eflist = errorModelSubclause.getEvents();
			for (ErrorBehaviorEvent ebe : eflist) {
				if (!result.containsKey(ebe.getName())) {
					result.put(ebe.getName(), ebe);
				}
			}
			if (!foundEBSM && ebsm != null) {
				foundEBSM = true;
				eflist = ebsm.getEvents();
				for (ErrorBehaviorEvent ebe : eflist) {
					if (!result.containsKey(ebe.getName())) {
						result.put(ebe.getName(), ebe);
					}
				}
			}

		}
		return result.values();
	}

	public static Collection<ErrorBehaviorEvent> getAllErrorBehaviorEvents(ComponentInstance ci) {
		return getAllErrorBehaviorEvents(ci.getComponentClassifier());
	}

	/**
	 * return list of ErrorBehaviorStates including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorBehaviorState> list of ErrorBehaviorStates as HashMap for quick lookup of names
	 */
	public static Collection<ErrorBehaviorState> getAllErrorBehaviorStates(Classifier cl) {
		HashMap<String, ErrorBehaviorState> result = new LinkedHashMap<>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorBehaviorStateMachine ebsm = errorModelSubclause.getUseBehavior();
			if (ebsm != null) {
				EList<ErrorBehaviorState> eflist = ebsm.getStates();
				for (ErrorBehaviorState ebs : eflist) {
					if (!result.containsKey(ebs.getName())) {
						result.put(ebs.getName(), ebs);
					}
				}
				return result.values();
			}

		}
		return Collections.emptyList();
	}

	public static Collection<ErrorBehaviorState> getAllErrorBehaviorStates(ComponentInstance ci) {
		return getAllErrorBehaviorStates(ci.getComponentClassifier());
	}

	/**
	 * return list of ErrorBehaviorEvents including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<ErrorBehaviorEvent> list of ErrorBehaviorEvents as HashMap for quick lookup of names
	 */
	public static Collection<ErrorBehaviorTransition> getAllErrorBehaviorTransitions(Classifier cl) {
		BasicEList<ErrorBehaviorTransition> unlist = new BasicEList<ErrorBehaviorTransition>();
		Collection<ErrorBehaviorTransition> res = getAllErrorBehaviorTransitions(cl, unlist).values();

		BasicEList<ErrorBehaviorTransition> result = new BasicEList<ErrorBehaviorTransition>();
		if (cl == null) {
			return result;
		}
		result.addAll(res);
		result.addAll(unlist);
		return result;
	}

	public static Collection<ErrorBehaviorTransition> getAllErrorBehaviorTransitions(ComponentInstance ci) {
		return getAllErrorBehaviorTransitions(ci.getComponentClassifier());
	}

	private static void getAllConditionElementsFromConditionExpression(EList<ConditionElement> propagations,
			ConditionExpression ce) {

		if (ce instanceof ConditionElement) {
			ConditionElement element = (ConditionElement) ce;
			propagations.add(element);
		} else if (ce instanceof AndExpression) {
			AndExpression and = (AndExpression) ce;
			for (ConditionExpression foobar : and.getOperands()) {
				getAllConditionElementsFromConditionExpression(propagations, foobar);
			}
		} else if (ce instanceof OrExpression) {
			OrExpression or = (OrExpression) ce;
			for (ConditionExpression foobar : or.getOperands()) {
				getAllConditionElementsFromConditionExpression(propagations, foobar);
			}
		} else if (ce instanceof OrmoreExpression) {
			OrmoreExpression or = (OrmoreExpression) ce;
			for (ConditionExpression foobar : or.getOperands()) {
				getAllConditionElementsFromConditionExpression(propagations, foobar);
			}
		} else if (ce instanceof OrlessExpression) {
			OrlessExpression or = (OrlessExpression) ce;
			for (ConditionExpression foobar : or.getOperands()) {
				getAllConditionElementsFromConditionExpression(propagations, foobar);
			}
		} else if (ce instanceof AllExpression) {
			AllExpression or = (AllExpression) ce;
			for (ConditionExpression foobar : or.getOperands()) {
				getAllConditionElementsFromConditionExpression(propagations, foobar);
			}
		}
	}

	/**
	 * return the list of all ConditionElement associated with an ErrorBehaviorTransition.
	 * In fact, for a transition, we can have several condition element enclosed in and and or branches.
	 * This methods returns all the condition element referenced inside this constructs.
	 * @param ebt the behavior transition that contains all the condition elements.
	 * @return all the condition element related to the behavior transition
	 */
	public static Collection<ConditionElement> getAllConditionElementsFromConditionExpression(
			ErrorBehaviorTransition ebt) {
		EList<ConditionElement> result = new BasicEList<ConditionElement>();
		getAllConditionElementsFromConditionExpression(result, ebt.getCondition());
		return result;
	}

	public static Collection<ConditionElement> getAllConditionElementsFromConditionExpression(
			OutgoingPropagationCondition ebt) {
		EList<ConditionElement> result = new BasicEList<ConditionElement>();
		getAllConditionElementsFromConditionExpression(result, ebt.getCondition());
		return result;
	}

	public static Collection<ConditionElement> getAllConditionElementsFromConditionExpression(CompositeState cs) {
		EList<ConditionElement> result = new BasicEList<ConditionElement>();
		getAllConditionElementsFromConditionExpression(result, cs.getCondition());
		return result;
	}

	public static Collection<ConditionElement> getAllConditionElementsFromConditionExpression(ConditionExpression ce) {
		EList<ConditionElement> result = new BasicEList<ConditionElement>();
		getAllConditionElementsFromConditionExpression(result, ce);
		return result;
	}

	/**
	 * return list of ErrorBehaviorTransition including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @param unnamed Collection of unnamed ErrorBehaviorTransition
	 * @return Collection<ErrorBehaviorTransition> list of ErrorBehaviorTransition as HashMap for quick lookup of names
	 */
	private static HashMap<String, ErrorBehaviorTransition> getAllErrorBehaviorTransitions(Classifier cl,
			Collection<ErrorBehaviorTransition> unnamed) {
		HashMap<String, ErrorBehaviorTransition> result = new LinkedHashMap<>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		boolean foundEBSM = false;
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorBehaviorStateMachine ebsm = errorModelSubclause.getUseBehavior();
			EList<ErrorBehaviorTransition> eflist = errorModelSubclause.getTransitions();
			for (ErrorBehaviorTransition ebt : eflist) {
				if (ebt.getName() == null) {
					unnamed.add(ebt);
				} else {
					if (!result.containsKey(ebt.getName())) {
						result.put(ebt.getName(), ebt);
					}
				}
			}
			if (!foundEBSM && ebsm != null) {
				foundEBSM = true;
				eflist = ebsm.getTransitions();
				for (ErrorBehaviorTransition ebt : eflist) {
					if (ebt.getName() == null) {
						unnamed.add(ebt);
					} else {
						if (!result.containsKey(ebt.getName())) {
							result.put(ebt.getName(), ebt);
						}
					}
				}
			}

		}
		return result;
	}

	/**
	 * return list of OutgoingPropagationCondition including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<OutgoingPropagationCondition> list of OutgoingPropagationCondition
	 */
	public static Collection<OutgoingPropagationCondition> getAllOutgoingPropagationConditions(Classifier cl) {
		BasicEList<OutgoingPropagationCondition> unlist = new BasicEList<OutgoingPropagationCondition>();
		Collection<OutgoingPropagationCondition> res = getAllOutgoingPropagationConditions(cl, unlist).values();
		unlist.addAll(res);
		return unlist;
	}

	public static Collection<OutgoingPropagationCondition> getAllOutgoingPropagationConditions(ComponentInstance ci) {
		return getAllOutgoingPropagationConditions(ci.getComponentClassifier());
	}

	/**
	 * return list of OutgoingPropagationCondition including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @param unnamed Collection of unnamed OutgoingPropagationCondition
	 * @return Collection<ErrorBehaviorTransition> list of OutgoingPropagationCondition as HashMap for quick lookup of names
	 */
	private static HashMap<String, OutgoingPropagationCondition> getAllOutgoingPropagationConditions(Classifier cl,
			Collection<OutgoingPropagationCondition> unnamed) {
		HashMap<String, OutgoingPropagationCondition> result = new LinkedHashMap<>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<OutgoingPropagationCondition> eflist = errorModelSubclause.getOutgoingPropagationConditions();
			for (OutgoingPropagationCondition ebt : eflist) {
				if (ebt.getName() == null) {
					unnamed.add(ebt);
				} else {
					if (!result.containsKey(ebt.getName())) {
						result.put(ebt.getName(), ebt);
					}
				}
			}
		}
		return result;
	}

	/**
	 * return list of CompositeState including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<CompositeState> list of CompositeState
	 */
	public static EList<CompositeState> getAllCompositeStates(Classifier cl) {
		EList<CompositeState> unlist = new BasicEList<CompositeState>();
		Collection<CompositeState> res = getAllCompositeStates(cl, unlist).values();
		unlist.addAll(res);
		return unlist;
	}

	public static EList<CompositeState> getAllCompositeStates(ComponentInstance ci) {
		return getAllCompositeStates(ci.getComponentClassifier());
	}

	/**
	 * return list of CompositeState including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @param unnamed Collection of unnamed CompositeState
	 * @return Collection<CompositeState> list of CompositeState as HashMap for quick lookup of names
	 */
	private static HashMap<String, CompositeState> getAllCompositeStates(Classifier cl,
			Collection<CompositeState> unnamed) {
		HashMap<String, CompositeState> result = new LinkedHashMap<>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<CompositeState> eslist = errorModelSubclause.getStates();
			for (CompositeState es : eslist) {
				if (es.getName() == null) {
					unnamed.add(es);
				} else {
					if (!result.containsKey(es.getName())) {
						result.put(es.getName(), es);
					}
				}
			}
		}
		return result;
	}

	/**
	 * return list of OutgoingPropagationCondition including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @return Collection<OutgoingPropagationCondition> list of OutgoingPropagationCondition
	 */
	public static Collection<ErrorDetection> getAllErrorDetections(Classifier cl) {
		BasicEList<ErrorDetection> unlist = new BasicEList<ErrorDetection>();
		Collection<ErrorDetection> res = getAllErrorDetections(cl, unlist).values();
		res.addAll(unlist);
		return res;
	}

	/**
	 * return list of OutgoingPropagationCondition including those inherited from classifiers being extended
	 * @param cl Classifier
	 * @param unnamed Collection of unnamed OutgoingPropagationCondition
	 * @return Collection<ErrorBehaviorTransition> list of OutgoingPropagationCondition as HashMap for quick lookup of names
	 */
	public static HashMap<String, ErrorDetection> getAllErrorDetections(Classifier cl,
			Collection<ErrorDetection> unnamed) {
		HashMap<String, ErrorDetection> result = new LinkedHashMap<>();
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<ErrorDetection> eflist = errorModelSubclause.getErrorDetections();
			for (ErrorDetection ebt : eflist) {
				if (ebt.getName() == null) {
					unnamed.add(ebt);
				} else {
					if (!result.containsKey(ebt.getName())) {
						result.put(ebt.getName(), ebt);
					}
				}
			}
		}
		return result;
	}

	/**
	 * return list of NamedElements in error model subclause
	 * @param ems error model subclause
	 * @return Collection<NamedElement> list of defined named elements
	 */
	public static Collection<NamedElement> getAllNamedElements(ErrorModelSubclause ems) {
		Collection<NamedElement> result = new BasicEList<NamedElement>();
		result.addAll(ems.getPropagations());
		result.addAll(ems.getFlows());
		result.addAll(ems.getEvents());
		result.addAll(ems.getTransitions());
		result.addAll(ems.getOutgoingPropagationConditions());
		result.addAll(ems.getErrorDetections());
		return result;
	}

	public static void getAllNamedElements(ErrorBehaviorStateMachine ebsm, Collection<NamedElement> result) {
		if (ebsm == null) {
			return;
		}
		result.addAll(ebsm.getEvents());
		result.addAll(ebsm.getStates());
		result.addAll(ebsm.getTransitions());
	}

	/**
	 * get Error Behavior State Machine (ebsm) in context  of the element
	 * This means the ebsm is either an enclosing container or the ebsm is referenced by an enclosing use behavior declaration.
	 * @param element
	 * @return
	 */
	public static ErrorBehaviorStateMachine getErrorBehaviorStateMachine(Element element) {
		EObject container = element;
		// find enclosing ebsm
		while (container != null) {
			if (container instanceof ErrorBehaviorStateMachine) {
				return (ErrorBehaviorStateMachine) container;
			}
			container = container.eContainer();
		}
		// now find it in use behavior clause
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(element);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorBehaviorStateMachine ebsm = errorModelSubclause.getUseBehavior();
			if (ebsm != null) {
				return ebsm;
			}
		}
		return null;
	}

	/**
	 * get the enclosing error model library.
	 * Returns null if the element is not in a error model library
	 * @param element
	 * @return ErrorModelLibrary or null
	 */
	public static ErrorModelLibrary getContainingErrorModelLibrary(Element element) {
		EObject container = element;
		while (container != null && !(container instanceof ErrorModelLibrary)) {
			container = container.eContainer();
		}
		return (ErrorModelLibrary) container;
	}

	/**
	 * get the enclosing error model subclause.
	 * Returns null if the element is not in a error model subclause
	 * @param element
	 * @return ErrorModelSubclause or null
	 */
	public static ErrorModelSubclause getContainingErrorModelSubclause(EObject element) {
		EObject container = element;
		while (container != null && !(container instanceof ErrorModelSubclause)) {
			container = container.eContainer();
		}
		return (ErrorModelSubclause) container;
	}

	/**
	 * return the feature the error propagation is pointing to or null
	 * @param ep
	 * @return Feature
	 */
	public static Feature getFeature(ErrorPropagation ep) {
		FeatureorPPReference forppref = ep.getFeatureorPPRef();
		if (forppref == null) {
			return null;
		}
		while (forppref.getNext() != null) {
			forppref = forppref.getNext();
		}
		if (forppref.getFeatureorPP() instanceof Feature) {
			return (Feature) forppref.getFeatureorPP();
		}
		return null;
	}

	/**
	 * return true if error propagation points to an access point
	 * @param ep
	 * @return Feature
	 */
	public static boolean isAccess(ErrorPropagation ep) {
		String s = ep.getKind();
		return (s != null) && (s.equalsIgnoreCase("access"));
	}

	/**
	 * return true if error propagation points to generic (functional) binding
	 * @param ep
	 * @return Feature
	 */
	public static boolean isBinding(ErrorPropagation ep) {
		String s = ep.getKind();
		return (s != null) && (s.equalsIgnoreCase("bindings"));
	}

	public static String getPrintName(Element el) {
		if (el instanceof ErrorPropagation) {
			ErrorPropagation ep = (ErrorPropagation) el;
			return getPrintName(ep);
		}
		if (el instanceof TypeSet) {
			TypeSet ts = (TypeSet) el;
			return getPrintName(ts);
		}
		if (el instanceof NamedElement) {
			NamedElement ne = (NamedElement) el;
			if (ne.getName() != null) {
				return ne.getName();
			}
		}
		return "";
	}

	public static String getDirectionName(Element el) {
		if (el instanceof ErrorPropagation) {
			ErrorPropagation ep = (ErrorPropagation) el;
			return getDirectionName(ep);
		}
		if (el instanceof TypeSet) {
			TypeSet ts = (TypeSet) el;
			return getPrintName(ts);
		}
		if (el instanceof NamedElement) {
			NamedElement ne = (NamedElement) el;
			if (ne.getName() != null) {
				return ne.getName();
			}
		}
		return "";
	}

	public static String getName(EObject el) {
		if (el instanceof ErrorPropagation) {
			ErrorPropagation ep = (ErrorPropagation) el;
			return getPropagationName(ep);
		}
		if (el instanceof TypeSet) {
			TypeSet ts = (TypeSet) el;
			return getName(ts);
		}
		if (el instanceof NamedElement) {
			NamedElement ne = (NamedElement) el;
			if (ne.getName() != null) {
				return ne.getName();
			}
		}
		return "";
	}

	/**
	 * get printName of Error Propagation
	 * @param ep
	 * @return
	 */
	public static String getPrintName(ErrorPropagation ep) {
		return getPropagationName(ep);
	}

	public static String getDirectionName(ErrorPropagation ep) {
		return ep.getDirection().getLiteral() + "-" + getPropagationName(ep);
	}

	public static String getPrintNameWithoutType(EMV2Path ep) {
		if (ep == null) {
			return "";
		}
		EMV2PathElement epe = ep.getEmv2Target();
		if (epe == null) {
			return "";
		}
		ContainmentPathElement cpe = ep.getContainmentPath();
		String prefix;
		if (cpe == null) {
			prefix = "";
		} else {
			prefix = "^" + cpe.getNamedElement().getName();
		}
		while (cpe.getPath() != null) {
			cpe = cpe.getPath();
			prefix = prefix + "." + cpe.getNamedElement().getName();
		}
		if (!prefix.isEmpty()) {
			prefix = prefix + '@';
		}
		if (epe.getEmv2PropagationKind() != null) {
			return prefix + epe.getEmv2PropagationKind();
		} else {
			return getPathNameWithoutType(epe);
		}
	}

	public static String getPrintName(EMV2Path ep) {
		if (ep == null) {
			return "";
		}
		EMV2PathElement epe = ep.getEmv2Target();
		if (epe == null) {
			return "";
		}
		ContainmentPathElement cpe = ep.getContainmentPath();
		String prefix;
		if (cpe == null) {
			prefix = "";
		} else {
			prefix = "^" + cpe.getNamedElement().getName();
			cpe = cpe.getPath();
		}
		while (cpe != null) {
			prefix = prefix + "." + cpe.getNamedElement().getName();
			cpe = cpe.getPath();
		}
		if (!prefix.isEmpty()) {
			prefix = prefix + '@';
		}
		if (epe.getEmv2PropagationKind() != null) {
			return prefix + epe.getEmv2PropagationKind()
					+ (epe.getErrorType() != null ? "." + epe.getErrorType().getName() : "");
		} else {
			return getPathName(epe);
		}
	}

	/**
	 * **********************************
	 * methods for retrieving elements in an EMV2Path
	 */

	/**
	 * This method returns the error type if referenced in the containment path
	 * This applies only to paths in EMV2PropertionAssociation
	 * In ConditionElement the type or type set is
	 * @param ep
	 * @return
	 */
	public static ErrorTypes getErrorType(EMV2Path ep) {
		EMV2PathElement last = getLast(ep.getEmv2Target());
		if (last.getNamedElement() instanceof ErrorTypes) {
			return (ErrorTypes) last.getNamedElement();
		}
		if (last.getErrorType() != null) {
			return last.getErrorType();
		}
		return null;
	}

	/**
	 * Get the error model element pointed to by the EMV2Path.
	 * An error model element can be ErrorSource, ErrorSink, ErrorPath, ErrorPropagaiton, ErrorState,
	 * ErrorBehaviorEvent (ErrorEvent, RecoverEvent, RepairEvent), ErrorBehaviorTransition
	 * This works for condition elements (ConditionElement, SConditionElement)
	 * @param ce ConditionElement
	 * @return NamedElement
	 */
	public static NamedElement getErrorModelElement(ConditionElement ce) {
		return getErrorModelElement(ce.getQualifiedErrorPropagationReference());
	}

	/**
	 * get the error propagation pointed to by the EMV2Path or null if not an error propagation.
	 * This method calls getErrorModelElement
	 * @param ce ConditionElement
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation getErrorPropagation(SConditionElement ce) {
		return getErrorPropagation(ce.getQualifiedErrorPropagationReference());
	}

	/**
	 * get the error propagation or error behavior event pointed to by the EMV2Path or null if not an error propagation.
	 * This method calls getErrorModelElement
	 * @param ce ConditionElement
	 * @return EventOrPropagation
	 */
	public static EventOrPropagation getErrorEventOrPropagation(ConditionElement ce) {
		return getErrorEventOrPropagation(ce.getQualifiedErrorPropagationReference());
	}

	/**
	 * get the error propagation pointed to by the EMV2Path or null if not an error propagation.
	 * This method calls getErrorModelElement
	 * @param epath EMV2Path
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation getErrorPropagation(EMV2Path epath) {
		NamedElement res = getErrorModelElement(epath);
		if (res instanceof ErrorPropagation) {
			return (ErrorPropagation) res;
		}
		return null;
	}

	/**
	 * get the error propagation or error behavior event pointed to by the EMV2Path or null if not an error propagation.
	 * This method calls getErrorModelElement
	 * @param epath EMV2Path
	 * @return EventOrPropagation
	 */
	public static EventOrPropagation getErrorEventOrPropagation(EMV2Path epath) {
		if (epath == null) {
			return null;
		}
		NamedElement res = getErrorModelElement(epath);
		if (res instanceof ErrorPropagation || res instanceof ErrorBehaviorEvent) {
			return (EventOrPropagation) res;
		}
		return null;
	}

	/**
	 * Get the error model element pointed to by the EMV2Path.
	 * An error model element can be ErrorSource, ErrorSink, ErrorPath, ErrorPropagaiton, ErrorState,
	 * ErrorBehaviorEvent (ErrorEvent, RecoverEvent, RepairEvent), ErrorBehaviorTransition
	 * This works for condition elements (ConditionElement, SConditionElement)
	 * @param epath EMV2Path
	 * @return NamedElement
	 */
	public static NamedElement getErrorModelElement(EMV2Path epath) {
		if (epath == null) {
			return null;
		}
		EMV2PathElement target = getLast(epath.getEmv2Target());
		if (target.getNamedElement() instanceof ErrorTypes) {
			EObject prev = target.eContainer();
			if (prev instanceof EMV2PathElement) {
				target = (EMV2PathElement) prev;
			} else {
				return null;
			}
		}
		NamedElement prop = target.getNamedElement();
		if (prop != null) {
			return prop;
		}
		String kind = target.getEmv2PropagationKind();
		ComponentClassifier cxtcl = EMV2Util.getAssociatedClassifier(epath);
		if (target.eContainer() instanceof EMV2PathElement) {
			// should be a subcomponent reference
			NamedElement cxt = ((EMV2PathElement) target.eContainer()).getNamedElement();
			if (cxt instanceof Subcomponent) {
				cxtcl = ((Subcomponent) cxt).getAllClassifier();
			}
		} else {
			if (epath.getContainmentPath() != null) {
				ContainmentPathElement last = getLast(epath.getContainmentPath());
				if (last.getNamedElement() instanceof Subcomponent) {
					cxtcl = ((Subcomponent) last.getNamedElement()).getAllClassifier();
				}
			}
		}
		ErrorPropagation ep = findErrorPropagation(cxtcl, kind, DirectionType.IN);
		if (ep == null) {
			ep = findErrorPropagation(cxtcl, kind, DirectionType.OUT);
		}
		return ep;
	}

	public static EMV2PathElement getLast(EMV2PathElement ep) {
		EMV2PathElement result = ep;
		while (result.getPath() != null) {
			result = result.getPath();
		}
		return result;
	}

	/**
	 * return the last subcomponent in the EMV2Path
	 * @param epath EMV2Path
	 * @return Subcomponent
	 */
	public static Subcomponent getLastSubcomponent(EMV2Path epath) {
		if (epath.getContainmentPath() != null) {
			// handle paths that come from the EMV2PropertyAssociation with the new syntax for the core path
			ContainmentPathElement last = getLast(epath.getContainmentPath());
			if (last.getNamedElement() instanceof Subcomponent) {
				return (Subcomponent) last.getNamedElement();
			}
			return null;
		}
		EMV2PathElement epe = epath.getEmv2Target();
		Subcomponent result = null;
		while (epe != null) {
			if (epe.getNamedElement() instanceof Subcomponent) {
				result = (Subcomponent) epe.getNamedElement();
			}
			epe = epe.getPath();
		}
		return result;
	}

	/**
	 * get the last component instance in the epath relative to the component instance root
	 * Returns root if the path does not include subcomponents.
	 * Returns null if the component instance is not found, i.e., the path subcomponent references cannot be found in the
	 * component instance hierarchy.
	 * @param epath EMV2Path that includes EMV2PathElements pointing to subcomponents.
	 * @param root ComponentInstance that is the root of the subcomponent section of the path
	 * @return ComponentInstance
	 */
	public static ComponentInstance getLastComponentInstance(EMV2Path epath, ComponentInstance root) {
		ComponentInstance result = root;
		if (epath.getContainmentPath() != null) {
			// handle paths that come from the EMV2PropertyAssociation with the new syntax for the core path
			ContainmentPathElement ce = epath.getContainmentPath();
			while (ce != null && result != null) {
				if (ce.getNamedElement() instanceof Subcomponent) {
					Subcomponent sub = (Subcomponent) ce.getNamedElement();
					result = result.findSubcomponentInstance(sub);
				}
				ce = ce.getPath();
			}
			return result;
		}
		EMV2PathElement epe = epath.getEmv2Target();
		while (epe != null && result != null) {
			if (epe.getNamedElement() instanceof Subcomponent) {
				Subcomponent sub = (Subcomponent) epe.getNamedElement();
				result = result.findSubcomponentInstance(sub);
			}
			epe = epe.getPath();
		}
		return result;
	}

	public static ComponentInstance getLastComponentInstance(QualifiedErrorBehaviorState qs, ComponentInstance root) {
		ComponentInstance referencedInstance;
		referencedInstance = root;
		while (qs != null && referencedInstance != null) {
			referencedInstance = referencedInstance.findSubcomponentInstance(qs.getSubcomponent().getSubcomponent());
			qs = qs.getNext();
		}
		return referencedInstance;
	}

	public static ContainmentPathElement getLast(ContainmentPathElement ep) {
		if (ep == null) {
			return null;
		}
		ContainmentPathElement result = ep;
		while (result.getPath() != null) {
			result = result.getPath();
		}
		return result;
	}

	public static String getPathNameWithoutType(EMV2PathElement ep) {
		if (ep == null || ep.getNamedElement() instanceof ErrorTypes) {
			return "";
		}
		String path = getPathNameWithoutType(ep.getPath());
		String myname = getPrintName(ep.getNamedElement());
		if (myname == null) {
			return path;
		}
		if (!path.isEmpty()) {
			return myname + "." + path;
		} else {
			return myname;
		}
	}

	public static String getPathName(EMV2PathElement ep) {
		if (ep == null) {
			return "";
		}
		String path = getPathName(ep.getPath());
		String myname = getPrintName(ep.getNamedElement());
		if (myname == null) {
			return path;
		}
		if (!path.isEmpty()) {
			return myname + "." + path;
		} else {
			return myname;
		}
	}

	public static String getPrintName(TypeSet ts) {
		if (ts == null) {
			return "";
		}
		EList<TypeToken> tel = ts.getTypeTokens();
		return getPrintName(tel);
	}

	public static String getName(TypeSet ts) {
		if (ts == null) {
			return "";
		}
		if (ts.getName() != null) {
			return ts.getName();
		}
		EList<TypeToken> tel = ts.getTypeTokens();
		return getName(tel);
	}

	public static String getPrintName(ErrorModelLibrary eml) {
		return AadlUtil.getContainingPackage(eml).getName();
	}

	public static String getPrintName(TypeToken tu) {
		if (tu == null) {
			return "";
		}
		return "{" + getName(tu) + "}";
	}

	public static String getName(TypeToken tu) {
		if (tu == null) {
			return "";
		}
		String res = "";
		for (ErrorTypes et : tu.getType()) {
			if (res.isEmpty()) {
				res = et.getName();
			} else {
				res = res + '*' + et.getName();
			}
		}
		return res;
	}

	public static String getName(EList<TypeToken> tul) {
		boolean docomma = false;
		String res = "";
		for (TypeToken typeSetElement : tul) {
			EList<ErrorTypes> et = typeSetElement.getType();
			if (docomma) {
				res = res + ',';
			} else {
				docomma = true;
			}
			if (et != null && !et.isEmpty()) {
				boolean doproduct = false;
				for (ErrorTypes errorType : et) {
					if (doproduct) {
						res = res + "*";
					} else {
						doproduct = true;
					}
					res = res + errorType.getName();
				}
			}
		}
		return res;
	}

	public static String getPrintName(EList<TypeToken> tul) {
		boolean docomma = false;
		String res = "{";
		for (TypeToken typeSetElement : tul) {
			EList<ErrorTypes> et = typeSetElement.getType();
			if (docomma) {
				res = res + ',';
			} else {
				docomma = true;
			}
			if (et != null && !et.isEmpty()) {
				boolean doproduct = false;
				for (ErrorTypes errorType : et) {
					if (doproduct) {
						res = res + "*";
					} else {
						doproduct = true;
					}
					res = res + errorType.getName();
				}
			}
		}
		return res + "}";
	}

	/**
	 * resolve the errortype if it is an alias, otherwise return the error type
	 * @param et ErrorType that may be an alias
	 * @return ErrorType without alias
	 */
	public static ErrorType resolveAlias(ErrorType et) {
		if (Aadl2Util.isNull(et)) {
			return null;
		}
		HashSet<ErrorType> result = new HashSet<ErrorType>();
		while (!Aadl2Util.isNull(et.getAliasedType())) {
			result.add(et);
			et = et.getAliasedType();
			if (result.contains(et)) {
				return et;
			}
		}
		return et;
	}

	/**
	 * resolve the typeset if it is an alias, otherwise return the typeset
	 * @param typeset TypeSet
	 * @return TypeSet resolved TypeSet
	 */
	public static TypeSet resolveAlias(TypeSet typeset) {
		if (Aadl2Util.isNull(typeset)) {
			return null;
		}
		HashSet<TypeSet> result = new HashSet<TypeSet>();
		while (!Aadl2Util.isNull(typeset.getAliasedType())) {
			result.add(typeset);
			typeset = typeset.getAliasedType();
			if (result.contains(typeset)) {
				return typeset;
			}
		}
		return typeset;
	}

	/**
	 * find the actual ErrorTypes following the alias link
	 * @param et
	 * @return
	 */
	public static ErrorTypes resolveAlias(ErrorTypes et) {
		if (Aadl2Util.isNull(et)) {
			return null;
		}
		return (et instanceof ErrorType) ? EMV2Util.resolveAlias((ErrorType) et) : EMV2Util.resolveAlias((TypeSet) et);
	}

	/**
	 *  figure out the target typetoken based on the source and type mappings
	 * Path can be a connection instance, a flow spec instance, or an error flow
	 * If null or no mapping found, then use source type token
	 * @param path connection instance, flow spec instance, error flow
	 * @param path path of mapping
	 * @return TypeToken
	 */
	public static TypeToken mapToken(TypeToken sourceToken, EObject path) {
		TypeToken result = sourceToken;
		if (path instanceof ConnectionInstance) {
			if (sourceToken != null) {
				// TODO lookup type transformations for connections and use them to determine target type
				ConnectionReference connref = Aadl2InstanceUtil.getTopConnectionReference((ConnectionInstance) path);
				ComponentInstance parentci = connref.getContext();
				TypeTransformationSet tts = getAllTypeTransformationSet(parentci);
				result = EMV2TypeSetUtil.mapTypeToken(sourceToken, tts);
			}
		} else if (path instanceof ErrorPath) {
			ErrorPath epath = (ErrorPath) path;
			// map the token
			TypeSet ttup = epath.getTargetToken();
			if (ttup == null) {
				// map token via tms
				TypeMappingSet tms = getUseMappings(epath);
				if (tms != null) {
					result = EMV2TypeSetUtil.mapTypeToken(sourceToken, tms);
				}
			} else {
				result = ttup.getTypeTokens().get(0);
			}
		} else if (path instanceof FlowSpecificationInstance) {
			// pass on source token
		}
		return result;
	}

	/**
	 * get TypeMappingSet listed in Use Mappings
	 * @param context Type use context
	 * @return EList<ErrorModelLibrary>
	 */
	public static TypeMappingSet getUseMappings(ErrorPath context) {
		// handle local type mapping set
		if (context.getTypeMappingSet() != null) {
			return context.getTypeMappingSet();
		}
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(context);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			TypeMappingSet tms = errorModelSubclause.getTypeMappingSet();
			if (tms != null) {
				return tms;
			}
		}
		return null;
	}

	public static EList<ErrorModelLibrary> EmptyElist = new BasicEList<ErrorModelLibrary>();

	/**
	 * get list of ErrorModelLibraries listed in UseTypes
	 * @param context Type use context
	 * @return EList<ErrorModelLibrary>
	 */
	public static EList<ErrorModelLibrary> getUseTypes(Element context) {
		EObject useTypesContainer = context;
		while (useTypesContainer != null && !(useTypesContainer instanceof ErrorModelLibrary
				|| useTypesContainer instanceof ErrorModelSubclause
				|| useTypesContainer instanceof TypeTransformationSet || useTypesContainer instanceof TypeMappingSet
				|| useTypesContainer instanceof ErrorBehaviorStateMachine)) {
			useTypesContainer = useTypesContainer.eContainer();
		}
		if (useTypesContainer instanceof ErrorModelSubclause) {
			EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(context);
			for (ErrorModelSubclause errorModelSubclause : emslist) {
				EList<ErrorModelLibrary> eml = errorModelSubclause.getUseTypes();
				if (!eml.isEmpty()) {
					return eml;
				}
			}
			return EmptyElist;
		}
		if (useTypesContainer instanceof TypeTransformationSet) {
			return ((TypeTransformationSet) useTypesContainer).getUseTypes();
		}
		if (useTypesContainer instanceof TypeMappingSet) {
			return ((TypeMappingSet) useTypesContainer).getUseTypes();
		}
		if (useTypesContainer instanceof ErrorBehaviorStateMachine) {
			return ((ErrorBehaviorStateMachine) useTypesContainer).getUseTypes();
		}
		if (useTypesContainer instanceof ErrorModelLibrary) {
			return ((ErrorModelLibrary) useTypesContainer).getUseTypes();
		}
		return EmptyElist;
	}

	/**
	 * find the model object that contains the condition expression
	 * @param ce Condition Expression
	 * @return EObject
	 */
	public static EObject getConditionExpressionContext(EObject ce) {
		EObject res = ce;
		while (res != null && res instanceof ConditionExpression) {
			res = res.eContainer();
		}
		return res;
	}

	/**
	 * get error type (last element of containment path, if present
	 * Otherwise return null
	 * @param containedNamedElement Containment path
	 * @return EList<ErrorType>
	 */
	public static ErrorType getContainmentErrorType(ContainedNamedElement containedNamedElement) {
		EList<ContainmentPathElement> cpes = containedNamedElement.getContainmentPathElements();
		if (!cpes.isEmpty()) {
			ContainmentPathElement cpe = cpes.get(cpes.size() - 1);
			NamedElement appliestome = cpe.getNamedElement();
			if (appliestome instanceof ErrorType) {
				return ((ErrorType) appliestome);
			}
		}
		return null;
	}

	/**
	 * take inheritance into account
	 * @param ci
	 * @return
	 */
	public static boolean hasEMV2Subclause(ComponentInstance ci) {
		return hasEMV2Subclause(ci.getComponentClassifier());
	}

	public static boolean hasErrorPropagations(ComponentInstance ci) {
		return hasErrorPropagations(ci.getComponentClassifier());
	}

	public static boolean hasErrorPropagations(ComponentClassifier cl) {
		if (cl == null) {
			return false;
		}
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<ErrorPropagation> eflist = errorModelSubclause.getPropagations();
			if (!eflist.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	/**
	 *
	 * @param cl 	The component classifier that is under test to have
	 * 				an error-annex subclause.
	 * @return		True is the component classifier has an error annex
	 * 				subclause. False otherwise.
	 */
	public static boolean hasEMV2Subclause(ComponentClassifier cl) {
		if (cl == null) {
			return false;
		}
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		return (!emslist.isEmpty());
	}

	public static boolean hasComponentErrorBehaviorTransitions(ComponentInstance ci) {
		return hasComponentErrorBehaviorTransitions(ci.getComponentClassifier());
	}

	public static boolean hasComponentErrorBehaviorTransitions(ComponentClassifier cl) {
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {

			if (!errorModelSubclause.getTransitions().isEmpty()) {
				return true;
			}
			if (errorModelSubclause.getUseBehavior() != null
					&& !errorModelSubclause.getUseBehavior().getTransitions().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasComponentErrorBehaviorStates(ComponentInstance ci) {
		return hasComponentErrorBehaviorStates(ci.getComponentClassifier());
	}

	public static boolean hasComponentErrorBehaviorStates(ComponentClassifier cl) {
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorBehaviorStateMachine cet = errorModelSubclause.getUseBehavior();
			if (cet != null) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasCompositeErrorBehavior(ComponentInstance ci) {
		return hasCompositeErrorBehavior(ci.getComponentClassifier());
	}

	public static boolean hasCompositeErrorBehavior(ComponentClassifier cl) {
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<CompositeState> ceb = errorModelSubclause.getStates();
			if (!ceb.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasOutgoingPropagations(ComponentInstance ci) {
		Collection<ErrorPropagation> ceb = getAllOutgoingErrorPropagations(ci.getComponentClassifier());
		return !ceb.isEmpty();
	}

	public static boolean hasErrorBehaviorStates(ComponentInstance ci) {
		Collection<ErrorBehaviorState> ceb = getAllErrorBehaviorStates(ci);
		return !ceb.isEmpty();
	}

	public static boolean hasOutgoingPropagationCondition(ComponentInstance ci) {
		return hasOutgoingPropagationCondition(ci.getComponentClassifier());
	}

	public static boolean hasOutgoingPropagationCondition(ComponentClassifier cl) {
		EList<ErrorModelSubclause> emslist = getAllContainingClassifierEMV2Subclauses(cl);
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			EList<OutgoingPropagationCondition> ceb = errorModelSubclause.getOutgoingPropagationConditions();
			if (!ceb.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * retrieve list of component instances that have EMV2 clauses
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	@SuppressWarnings("unchecked")
	public static EList<ComponentInstance> getComponentInstancesWithEMV2Subclause(ComponentInstance ci) {
		EList<?> result = new ForAllElement() {
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance && (EMV2Util.hasEMV2Subclause((ComponentInstance) obj)));
			}
		}.processPreOrderComponentInstance(ci);
		return (EList<ComponentInstance>) result;
	}

	/**
	 * retrieve list of component instances that have error propagations specified
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	@SuppressWarnings("unchecked")
	public static EList<ComponentInstance> getComponentInstancesWithErrorPropagations(ComponentInstance ci) {
		EList<?> result = new ForAllElement() {
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance && (EMV2Util.hasErrorPropagations((ComponentInstance) obj)));
			}
		}.processPreOrderComponentInstance(ci);
		return (EList<ComponentInstance>) result;
	}

	/**
	 * retrieve list of component instances that have component error behavior specified
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	@SuppressWarnings("unchecked")
	public static EList<ComponentInstance> getComponentInstancesWithComponentErrorBehaviorStates(ComponentInstance ci) {
		EList<?> result = new ForAllElement() {
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance
						&& (EMV2Util.hasComponentErrorBehaviorStates((ComponentInstance) obj)));
			}
		}.processPreOrderComponentInstance(ci);
		return (EList<ComponentInstance>) result;
	}

	/**
	 * retrieve list of component instances that have component error behavior specified
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	@SuppressWarnings("unchecked")
	public static EList<ComponentInstance> getComponentInstancesWithComponentErrorBehaviorTransitions(
			ComponentInstance ci) {
		EList<?> result = new ForAllElement() {
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance
						&& (EMV2Util.hasComponentErrorBehaviorTransitions((ComponentInstance) obj)));
			}
		}.processPreOrderComponentInstance(ci);
		return (EList<ComponentInstance>) result;
	}

	/**
	 * retrieve list of component instances that have composite error behavior specified
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	@SuppressWarnings("unchecked")
	public static EList<ComponentInstance> getComponentInstancesWithCompositeErrorBehavior(ComponentInstance ci) {
		EList<?> result = new ForAllElement() {
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance
						&& (EMV2Util.hasCompositeErrorBehavior((ComponentInstance) obj)));
			}
		}.processPreOrderComponentInstance(ci);
		return (EList<ComponentInstance>) result;
	}

	/**
	 * returns the feature instance in the component instance that is referenced by the Error Propagation (or Containment)
	 * @param ep
	 * @param ci
	 * @return
	 */
	public static FeatureInstance findFeatureInstance(ErrorPropagation ep, ComponentInstance ci) {
		if (ep == null) {
			return null;
		}
		FeatureorPPReference forppref = ep.getFeatureorPPRef();
		if (forppref == null || forppref.getFeatureorPP() instanceof PropagationPoint) {
			return null;
		}
		FeatureInstance container = ci.findFeatureInstance((Feature) forppref.getFeatureorPP());
		while (forppref.getNext() != null) {
			forppref = forppref.getNext();
			NamedElement ne = forppref.getFeatureorPP();
			if (ne instanceof Feature) {
				Feature fe = (Feature) ne;
				FeatureInstance fi = container.findFeatureInstance(fe);
				if (fi != null) {
					container = fi;
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
		return container;
	}

	/**
	 * returns the feature instance in the component instance that is referenced by the Error Propagation (or Containment)
	 * @param ep
	 * @param ci
	 * @return
	 */
	public static NamedElement getErrorPropagationFeature(ErrorPropagation ep, ComponentInstance ci) {
		Feature f = getFeature(ep);
		if (f == null) {
			return ci;
		}
		return f;
	}

	/**
	 * returns the feature instance in the component instance that is referenced by the Error Propagation (or Containment)
	 * @param ep
	 * @param ci
	 * @return
	 */
	public static DirectionType getErrorPropagationFeatureDirection(ErrorPropagation ep) {
		FeatureorPPReference fref = ep.getFeatureorPPRef();
		boolean inverse = false;
		NamedElement f = null;
		DirectionType featuredir = DirectionType.IN_OUT;
		while (fref != null) {
			f = fref.getFeatureorPP();
			fref = fref.getNext();
			if (f instanceof FeatureGroup && fref != null) {
				FeatureGroup fg = (FeatureGroup) f;
				FeatureGroupType fgt = fg.getAllFeatureGroupType();
				if (fg.isInverse()) {
					inverse = !inverse;
				}
				if (fgt != null && fgt.getInverse() != null
						&& !fgt.getOwnedFeatures().contains(fref.getFeatureorPP())) {
					inverse = !inverse;
				}
			}
		}

		if (f instanceof DirectedFeature) {
			featuredir = ((DirectedFeature) f).getDirection();
			if (inverse) {
				return featuredir.getInverseDirection();
			} else {
				return featuredir;
			}
		}
		return featuredir;
	}

	/**
	 * return true if error propagation points to feature instance
	 * @param ep Error Propagation (or Containment)
	 * @param fi Feature Instance
	 * @return Boolean
	 */
	public static boolean isErrorPropagationOf(ErrorPropagation ep, FeatureInstance fi) {
		if (Aadl2Util.isNull(fi.getFeature())) {
			return false; // not to a feature
		}
		Feature f = getFeature(ep);
		return f.getName().equalsIgnoreCase(fi.getFeature().getName());
	}

	public static PropagationPoint getPropagationPoint(ErrorPropagation ep) {
		FeatureorPPReference ref = ep.getFeatureorPPRef();
		if (ref instanceof PropagationPoint) {
			return (PropagationPoint) ref;
		}
		return null;
	}

	/**
	 * for compatibility reasons.
	 * The path is now right recursive and most code interprets that path.
	 */
	public static EList<FeatureorPPReference> getFeatureorPPRefs(ErrorPropagation errorPropagation) {
		final EList<FeatureorPPReference> list = new BasicEList<>();
		for (FeatureorPPReference current = errorPropagation.getFeatureorPPRef(); current != null; current = current
				.getNext()) {
			list.add(current);
		}
		return list;
	}

	public static EList<SubcomponentElement> getSubcomponents(QualifiedPropagationPoint propagationPoint) {
		final EList<SubcomponentElement> list = new BasicEList<>();
		for (QualifiedPropagationPoint current = propagationPoint; current.getSubcomponent() != null;) {
			list.add(current.getSubcomponent());
			current = current.getNext();
		}
		return list;
	}

	public static NamedElement getEndPoint(QualifiedPropagationPoint propagationPointPath) {
		QualifiedPropagationPoint current = propagationPointPath;
		while (current != null && current.getPropagationPoint() == null) {
			current = current.getNext();
		}
		return current == null ? null : current.getPropagationPoint();
	}

	public static EList<SubcomponentElement> getSubcomponents(SConditionElement conditionElement) {
		final EList<SubcomponentElement> list = new BasicEList<>();
		for (QualifiedErrorBehaviorState current = conditionElement.getQualifiedState(); current
				.getSubcomponent() != null;) {
			list.add(current.getSubcomponent());
			current = current.getNext();
		}
		return list;
	}

	public static ErrorBehaviorState getState(SConditionElement conditionElement) {
		for (QualifiedErrorBehaviorState current = conditionElement
				.getQualifiedState(); current != null; current = current.getNext()) {
			if (current.getState() != null) {
				return current.getState();
			}
		}
		return null;
	}

	public static boolean checkCyclicExtends(ErrorModelLibrary etl) {
		if (etl.getExtends() == null) {
			return false;
		}
		HashSet<ErrorModelLibrary> result = new HashSet<ErrorModelLibrary>();
		return recursiveCheckCyclicExtends(etl, result);
	}

	private static boolean recursiveCheckCyclicExtends(ErrorModelLibrary etl, HashSet<ErrorModelLibrary> shetl) {
		boolean result = false;
		if (etl.getExtends() != null) {
			shetl.add(etl);
			EList<ErrorModelLibrary> etllist = etl.getExtends();
			for (ErrorModelLibrary xetl : etllist) {
				if (shetl.contains(xetl)) {
					result = true;
				} else {
					result = result || recursiveCheckCyclicExtends(xetl, shetl);
				}
			}
			shetl.remove(etl);
		}
		return result;
	}

	public static boolean isProcessor(ErrorPropagation ep) {
		return (ep != null) && (ep.getKind() != null) && (ep.getKind().equalsIgnoreCase("processor"));
	}

	public static String stripUnderScore(String value) {
		if (value == null) {
			return value;
		}
		return value.replaceAll("_", "");
	}

}