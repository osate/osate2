package org.osate.xtext.aadl2.errormodel.validation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Context;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Port;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPointConnection;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeUseContext;
import org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl;
import org.osate.xtext.aadl2.errormodel.util.EM2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class ErrorModelJavaValidator extends AbstractErrorModelJavaValidator {

	@Override
	protected boolean isResponsible(Map<Object, Object> context, EObject eObject) {
		return (eObject.eClass().getEPackage() == ErrorModelPackageImpl.eINSTANCE
				|| eObject instanceof Connection || eObject instanceof PropertyAssociation);
	}

	@Check(CheckType.FAST)
	public void caseErrorPropagation(ErrorPropagation errorPropagation) {
		checkDirectionType(errorPropagation);
	}

	@Check(CheckType.FAST)
	public void casePropagationPoint(PropagationPoint propagationPoint) {
		checkUniquePropagationPointorConnection(propagationPoint);
	}

	@Check(CheckType.FAST)
	public void casePropertyAssociation(PropertyAssociation propertyAssociation) {
		// check that error type is contained in type set of target element
		EList<ContainedNamedElement> apto = propertyAssociation.getAppliesTos();
		for (ContainedNamedElement containedNamedElement : apto) {
			EList<ContainmentPathElement> cpe = containedNamedElement
					.getContainmentPathElements();
			if (cpe.size() > 1) {
				ContainmentPathElement obj = cpe.get(cpe.size() - 1);
				if (obj.getNamedElement() instanceof ErrorType) {
					ErrorType et = (ErrorType) obj.getNamedElement();
					ContainmentPathElement target = cpe.get(cpe.size() - 2);
					NamedElement ne = target.getNamedElement();
					TypeSet tts = null;
					if (ne instanceof ErrorBehaviorState) {
						tts = ((ErrorBehaviorState) ne).getTypeSet();
					} else if (ne instanceof ErrorPropagation) {
						tts = ((ErrorPropagation) ne).getTypeSet();
					} else if (ne instanceof ErrorEvent) {
						tts = ((ErrorEvent) ne).getTypeSet();
					}
					TypeToken tt = ErrorModelFactory.eINSTANCE
							.createTypeToken();
					tt.getType().add(et);
					if (EM2TypeSetUtil.contains(tts, tt)) {

					}
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void casePropagationPointConnection(PropagationPointConnection opc) {
		checkUniquePropagationPointorConnection(opc);
	}

	@Check(CheckType.FAST)
	public void caseErrorType(ErrorType et) {
		checkCyclicExtends(et);
	}

	@Check(CheckType.FAST)
	public void caseTypeSet(TypeSet ts) {
		checkTypeSetUniqueTypes(ts);
	}

	@Check(CheckType.FAST)
	public void caseTypeToken(TypeToken tt) {
		checkTypeTokenUniqueTypes(tt);
	}

	@Check(CheckType.FAST)
	public void caseRecoverEvent(RecoverEvent recoverEvent) {
		checkRecoverEventTriggerType(recoverEvent);
	}

	@Check(CheckType.NORMAL)
	public void caseConditionElement(ConditionElement conditionElement) {
		checkConditionElementType(conditionElement);
	}

	@Check(CheckType.NORMAL)
	public void caseErrorModelSubclause(ErrorModelSubclause subclause) {
		Collection<NamedElement> names = EMV2Util.getAllNamedElements(subclause);
		EList<NamedElement> doubles = EMV2Util.findDoubleNamedElementsInList(names);
		for (NamedElement namedElement : doubles) {
			error(namedElement, namedElement.getName()+" has duplicate error propagations.");
		}
	}

	@Check(CheckType.NORMAL)
	public void caseErrorPropagations(ErrorPropagations errorPropagations) {
		checkOnePropagationAndContainmentPoint(errorPropagations);
	}

	@Check(CheckType.NORMAL)
	public void caseTypeMappingSet(TypeMappingSet tms) {
		// checkElementRuleConsistency(tms);
	}

	@Check(CheckType.NORMAL)
	public void caseErrorModelLibrary(ErrorModelLibrary errorModelLibrary) {
		if (errorModelLibrary.getName() == null)
			errorModelLibrary.setName("emv2");
		boolean cyclicextends = checkCyclicExtends(errorModelLibrary);
		checkUniqueDefiningIdentifiers(errorModelLibrary, cyclicextends);
	}

	@Check(CheckType.NORMAL)
	public void caseErrorBehaviorStateMachine(ErrorBehaviorStateMachine ebsm) {
		// checkCyclicExtends(ebsm);
		checkUniqueEBSMElements(ebsm);
	}


	@Check(CheckType.NORMAL)
	public void caseErrorBehaviorTransition(ErrorBehaviorTransition ebt) {
		checkTransitionSourceTypes(ebt);
		checkTransitionTargetTypes(ebt);
	}

	@Check(CheckType.NORMAL)
	public void caseErrorDetection(ErrorDetection ebt) {
		checkDetectionSourceTypes(ebt);
	}

	@Check(CheckType.NORMAL)
	public void caseTypeUseContext(TypeUseContext typeUseContext) {
		checkMultipleUses(typeUseContext);
		checkMultipleErrorTypesInUsesTypes(typeUseContext);
	}

	@Check(CheckType.NORMAL)
	public void caseErrorSource(ErrorSource ef) {
		checkErrorSourceTypes(ef);
		checkFlowDirection(ef);
	}

	@Check(CheckType.NORMAL)
	public void caseOutgoingPropagationCondition(OutgoingPropagationCondition ef) {
		checkOutgoingTypes(ef);
	}

	@Check(CheckType.NORMAL)
	public void caseErrorSink(ErrorSink ef) {
		checkErrorSinkTypes(ef);
		checkFlowDirection(ef);
	}

	@Check(CheckType.NORMAL)
	public void caseErrorPath(ErrorPath ef) {
		checkErrorPathTypes(ef);
		checkFlowDirection(ef);
	}

	@Check(CheckType.NORMAL)
	public void caseConnection(Connection conn) {
		checkConnectionErrorTypes(conn);
	}

	private void checkRecoverEventTriggerType(RecoverEvent recoverEvent) {
		EList<NamedElement> cl = recoverEvent.getCondition();
		for (NamedElement namedElement : cl) {
			if (!(namedElement instanceof Port || namedElement instanceof ModeTransition)) {
				error(recoverEvent, "Recover event trigger reference '"
						+ namedElement.getName()
						+ "' is not a port or mode transition.");
			}
		}
	}

	private void checkConditionElementType(ConditionElement conditionElement) {
		EventOrPropagation ep = conditionElement.getIncoming();
		TypeSet triggerTS = null;
		String triggerName = "";
		if (ep instanceof ErrorPropagation){
			triggerTS = ((ErrorPropagation)ep).getTypeSet();
			triggerName = "propagation "+EMV2Util.getPrintName((ErrorPropagation)ep);
		} else if (ep instanceof ErrorEvent){
			triggerTS = ((ErrorEvent)ep).getTypeSet();
			triggerName = "event "+((ErrorBehaviorEvent)ep).getName();
		}
		TypeSet condTS = conditionElement.getConstraint();
		if (triggerTS == null&&condTS == null) return;
		if (triggerTS == null && condTS != null){
			error(conditionElement,"Condition has type contraint but referenced "+triggerName+" does not.");
		} else 
		if (!EM2TypeSetUtil.contains(triggerTS,
				condTS)) {
			error(conditionElement,
					"Condition type constraint "+EMV2Util.getPrintName(condTS)+"is not contained in type set "+EMV2Util.getPrintName(triggerTS)+"of referenced "+triggerName);
		}
	}

	private void checkDirectionType(ErrorPropagation errorPropagation) {
		DirectionType pd = errorPropagation.getDirection();
			DirectionType portd = EMV2Util.getErrorPropagationFeatureDirection(errorPropagation);
			if (!(pd.getName().equalsIgnoreCase(portd.getName()) || portd == DirectionType.IN_OUT))
				error(errorPropagation,
						"Propagation direction does not match port direction.");
	}

	private void checkOnePropagationAndContainmentPoint(
			ErrorPropagations errorPropagations) {
		EList<ErrorPropagation> eps = errorPropagations.getPropagations();
		int epssize = eps.size();
		for (int i = 0; i < epssize - 1; i++) {
			ErrorPropagation ep1 = eps.get(i);
			for (int k = i + 1; k < epssize; k++) {
				ErrorPropagation ep2 = eps.get(k);
				if (EMV2Util.getPrintName(ep1) == EMV2Util.getPrintName(ep2)) {
					// uniqueness needs to take into account direction
					if ((ep1.isNot() && ep2.isNot() || !ep1.isNot()
							&& !ep2.isNot()) && ep1.getDirection() == ep2.getDirection()) {
						error(ep2,
								(ep1.isNot() ? "Error containment "
										: "Error propagation ")
										+ EMV2Util.getPrintName(ep2)
										+ " already defined.");
					}
				}
			}
		}
	}

	private void checkFlowDirection(ErrorSource errorSource) {
		ErrorPropagation ep = errorSource.getOutgoing();
		if (!Aadl2Util.isNull(ep)) {
			DirectionType epd = ep.getDirection();
			if (!(epd.equals(DirectionType.OUT))) {
				error(errorSource,
						EMV2Util.getPrintName(ep)
								+ " of error source is not an outgoing propagation point.");
			}
		}
	}

	private void checkFlowDirection(ErrorSink errorSink) {
		ErrorPropagation ep = errorSink.getIncoming();
		if (!Aadl2Util.isNull(ep)) {
			DirectionType epd = ep.getDirection();
			if (!(epd.equals(DirectionType.IN))) {
				error(errorSink,
						EMV2Util.getPrintName(ep)
								+ " of error sink is not an incoming propagation point.");
			}
		}
	}

	private void checkFlowDirection(ErrorPath errorPath) {
		ErrorPropagation ep = errorPath.getIncoming();
		if (!Aadl2Util.isNull(ep)) {
			DirectionType epd = ep.getDirection();
			if (!(epd.equals(DirectionType.IN))) {
				error(errorPath,
						"Source "
								+ EMV2Util.getPrintName(ep)
								+ " of error path is not an incoming propagation point.");
			}
		}
		ep = errorPath.getOutgoing();
		if (!Aadl2Util.isNull(ep)) {
			DirectionType epd = ep.getDirection();
			if (!(epd.equals(DirectionType.OUT))) {
				error(errorPath,
						"Target "
								+ EMV2Util.getPrintName(ep)
								+ " of error path is not an outgoing propagation point.");
			}
		}
	}

	// private void checkElementMappingTypeConsistency(ElementTypeMapping
	// etMapping){
	// ErrorType srcET = etMapping.getSource();
	// ErrorType tgtET = etMapping.getTarget();
	// if (!Aadl2Util.isNull(srcET) && !Aadl2Util.isNull(tgtET)){
	// if (!EM2TypeSetUtil.inSameTypeHierarchy(srcET, tgtET)){
	// error(etMapping,
	// "Source and target error types are not in same type hierarchy");
	// }
	// }
	// }
	//
	// private void
	// checkElementTransformTypeConsistency(ElementTypeTransformation etXform){
	// ErrorType srcET = etXform.getSource();
	// ErrorType conET = etXform.getContributor();
	// ErrorType tgtET = etXform.getTarget();
	// if (!Aadl2Util.isNull(srcET) && !Aadl2Util.isNull(tgtET)){
	// if (!EM2TypeSetUtil.inSameTypeHierarchy(srcET, tgtET)){
	// error(etXform,
	// "Source type "+srcET.getName()+" and target type "+tgtET.getName()+" are not in same type hierarchy");
	// }
	// }
	// if (!Aadl2Util.isNull(srcET) && !Aadl2Util.isNull(conET)){
	// if (!EM2TypeSetUtil.inSameTypeHierarchy(srcET, conET)){
	// error(etXform,
	// "Source type "+srcET.getName()+" and contributor type "+conET.getName()+" are not in same type hierarchy");
	// }
	// }
	// }
	//
	// private void checkElementRuleConsistency(TypeMappingSet tms){
	// HashSet<ErrorType> sourceTypes = new HashSet<ErrorType>();
	// for (TypeMapping tm : tms.getMapping()){
	// if (tm instanceof ElementTypeMapping){
	// ErrorType et = ((ElementTypeMapping) tm).getSource();
	// if (sourceTypes.contains(et)){
	// error(tm,
	// "Type "+et.getName()+" already being mapped");
	// } else {
	// sourceTypes.add(et);
	// }
	// }
	// }
	// }

	private void checkTypeSetUniqueTypes(TypeSet ts) {
		EList<TypeToken> etlist = ts.getElementType();
		int size = etlist.size();
		for (int i = 0; i < size - 1; i++) {
			TypeToken tok = etlist.get(i);
			for (int k = i + 1; k < size; k++) {
				TypeToken tok2 = etlist.get(k);
				if (EM2TypeSetUtil.contains(tok, tok2)
						|| EM2TypeSetUtil.contains(tok2, tok)) {
					error(ts, "Typeset elements " + EMV2Util.getPrintName(tok)
							+ " and " + EMV2Util.getPrintName(tok2)
							+ " are not disjoint.");
				}
			}
		}
	}

	private void checkTypeTokenUniqueTypes(TypeToken ts) {
		HashSet<ErrorType> sourceTypes = new HashSet<ErrorType>();
		for (ErrorType et : ts.getType()) {
			ErrorType root = EM2TypeSetUtil.rootType(et);
			if (sourceTypes.contains(root)) {
				error(et,
						"Another element type has same root type "
								+ root.getName() + " as " + et.getName());
			} else {
				sourceTypes.add(et);
			}
		}
	}

	private void checkMultipleUses(TypeUseContext tuc) {
		HashSet<ErrorModelLibrary> etlset = new HashSet<ErrorModelLibrary>();
		for (ErrorModelLibrary etl : EMV2Util.getUseTypes(tuc)) {
			if (etlset.contains(etl)) {
				error(tuc, "Error type library " + EMV2Util.getPrintName(etl)
						+ " exists more than once in 'uses types' clause");
			} else {
				etlset.add(etl);
			}
		}
	}

	private void checkMultipleErrorTypesInUsesTypes(TypeUseContext tuc) {
		Hashtable<String, EObject> etlset = new Hashtable<String, EObject>(10,
				10);
		for (ErrorModelLibrary etl : EMV2Util.getUseTypes(tuc)) {
			EList<ErrorTypes> typeslist = etl.getTypes();
			for (ErrorTypes errorTypes : typeslist) {
				if (etlset.containsKey(errorTypes.getName())) {
					ErrorModelLibrary eml = EMV2Util
							.getContainingErrorModelLibrary((Element) etlset
									.get(errorTypes.getName()));
					error(tuc, "Error type or type set " + errorTypes.getName()
							+ " in library " + EMV2Util.getPrintName(etl)
							+ " already exists in error type library "
							+ EMV2Util.getPrintName(eml));
				} else {
					etlset.put(errorTypes.getName(), errorTypes);
				}
			}
		}
	}

	private void checkUniqueEBSMElements(ErrorBehaviorStateMachine ebsm) {
		Hashtable<String, EObject> etlset = new Hashtable<String, EObject>(10,10);
		for (ErrorBehaviorEvent oep : ebsm.getEvents()) {
			if (etlset.containsKey(oep.getName())) {
				error(oep, "error behavior event "+oep.getName()+ " defined more than once");
			} else {
				etlset.put(oep.getName(), oep);
			}
		}
		for (ErrorBehaviorState oep : ebsm.getStates()) {
			if (etlset.containsKey(oep.getName())) {
				error(oep, "error behavior state "+oep.getName()+ " previously defined as "+etlset.get(oep.getName()).eClass().getName());
			} else {
				etlset.put(oep.getName(), oep);
			}
		}
		for (ErrorBehaviorTransition oep : ebsm.getTransitions()) {
			if (etlset.containsKey(oep.getName())) {
				error(oep, "error behavior transition "+oep.getName()+ " previously defined as "+etlset.get(oep.getName()).eClass().getName());
			} else {
				etlset.put(oep.getName(), oep);
			}
		}
	}

	private void checkUniquePropagationPointorConnection(NamedElement ep) {
		Collection<PropagationPoint> tab = EMV2Util.getAllPropagationPoints(ep.getContainingClassifier());
		for (PropagationPoint oep : tab) {
			if (oep != ep && oep.getName().equalsIgnoreCase(ep.getName())) {
				error(ep,
						"Propagation point "+(ep instanceof PropagationPointConnection?"connection ":"")
								+ ep.getName()+ " conflicts with propagation point.");
			}
		}
		for (PropagationPointConnection oep : EMV2Util.getAllPropagationPointConnections(ep.getContainingClassifier())) {
			if (oep != ep && oep.getName().equalsIgnoreCase(ep.getName())) {
				error(ep,
						"Propagation point "+(ep instanceof PropagationPointConnection?"connection ":"")+
				ep.getName()+ "' conflicts with propagation point connection.");
			}
		}
		EObject searchResult = null;
		Classifier cl = AadlUtil.getContainingClassifier(ep);
		if (cl instanceof ComponentImplementation) {
			searchResult = ((ComponentImplementation) cl).getType()
					.findNamedElement(ep.getName());
		} else {
			searchResult = AadlUtil.getContainingClassifier(ep)
					.findNamedElement(ep.getName());
		}
		if (searchResult != null) {
			error(ep,
					"Propagation point " + ep.getName()
							+ " conflicts with feature in component type "
							+ cl.getName());
		}
	}


	private void checkUniqueDefiningIdentifiers(ErrorModelLibrary etl,
			boolean cyclicextends) {
		Hashtable<String, EObject> types = new Hashtable<String, EObject>(10,
				10);
		checkUniqueDefiningEBSMMappingsTransformations(etl, types);
		if (cyclicextends)
			return;
		for (ErrorModelLibrary xetl : etl.getExtends()) {
			checkUniqueInheritedDefiningErrorTypes(xetl, types);
		}
	}

	private void checkUniqueDefiningEBSMMappingsTransformations(
			ErrorModelLibrary etl, Hashtable<String, EObject> types) {
		for (ErrorBehaviorStateMachine ebsm : etl.getBehaviors()) {
			if (types.containsKey(ebsm.getName())) {
				error(ebsm,
						"Error behavior state machine identifier "
								+ ebsm.getName()
								+ " is not unique in error model library");
			}
			types.put(ebsm.getName(), ebsm);
		}
		for (TypeMappingSet tms : etl.getMappings()) {
			if (types.containsKey(tms.getName())) {
				error(tms, "Type mapping set identifier " + tms.getName()
						+ " is not unique in error model library");
			}
			types.put(tms.getName(), tms);
		}
		for (TypeTransformationSet tts : etl.getTransformations()) {
			if (types.containsKey(tts.getName())) {
				error(tts,
						"Type transformation set identifier " + tts.getName()
								+ " is not unique in error model library");
			}
			types.put(tts.getName(), tts);
		}
		for (ErrorTypes ets : etl.getTypes()) {
			if (types.containsKey(ets.getName())) {
				error(ets,
						"Error type or type set (alias) identifier "
								+ ets.getName()
								+ " is not unique in error model library");
			}
			types.put(ets.getName(), ets);
		}
	}

	private void checkUniqueInheritedDefiningErrorTypes(ErrorModelLibrary etl,
			Hashtable<String, EObject> types) {
		for (ErrorTypes et : etl.getTypes()) {
			if (types.containsKey(et.getName())) {
				ErrorModelLibrary eml = EMV2Util
						.getContainingErrorModelLibrary(et);
				error(et,
						"Error type or type set (alias) "
								+ et.getName()
								+ " inherited from "
								+ EMV2Util.getPrintName(eml)
								+ " conflicts with another defining identifier in error type library");
			}
			types.put(et.getName(), et);
		}
		for (ErrorModelLibrary xetl : etl.getExtends()) {
			checkUniqueInheritedDefiningErrorTypes(xetl, types);
		}
	}

	private boolean checkCyclicExtends(ErrorModelLibrary etl) {
		if (etl.getExtends() == null)
			return false;
		HashSet<ErrorModelLibrary> result = new HashSet<ErrorModelLibrary>();
		return recursiveCheckCyclicExtends(etl, result);
	}

	private boolean recursiveCheckCyclicExtends(ErrorModelLibrary etl,
			HashSet<ErrorModelLibrary> shetl) {
		boolean result = false;
		if (etl.getExtends() != null) {
			shetl.add(etl);
			EList<ErrorModelLibrary> etllist = etl.getExtends();
			for (ErrorModelLibrary xetl : etllist) {
				if (shetl.contains(xetl)) {
					error(xetl,
							"Cycle in extends of error type library "
									+ etl.getName());
					result = true;
				} else {
					result = result || recursiveCheckCyclicExtends(xetl, shetl);
				}
			}
			shetl.remove(etl);
		}
		return result;
	}

	private void checkCyclicExtends(ErrorType origet) {
		ErrorType et = origet;
		if (et.getSuperType() == null)
			return;
		HashSet<ErrorType> result = new HashSet<ErrorType>();
		while (et.getSuperType() != null) {
			result.add(et);
			et = et.getSuperType();
			if (result.contains(et)) {
				error(origet, "Cycle in supertype hierarchy of error type "
						+ origet.getName() + " at type " + et.getName());
				return;
			}
		}
	}

	// private void checkCyclicExtends(ErrorBehaviorStateMachine origebsm){
	// ErrorBehaviorStateMachine ebsm = origebsm;
	// if (ebsm.getExtends() == null) return;
	// HashSet<ErrorBehaviorStateMachine> result = new
	// HashSet<ErrorBehaviorStateMachine>();
	// while (ebsm.getExtends() != null){
	// result.add(ebsm);
	// ebsm = ebsm.getExtends();
	// if (result.contains(ebsm)){
	// error(origebsm,
	// "Cycle in extends of error behavior state machine "+origebsm.getName());
	// return;
	// }
	// }
	// }

	private void checkErrorSourceTypes(ErrorSource ef) {
		ErrorPropagation ep = ef.getOutgoing();
		if (!EM2TypeSetUtil.contains(ep.getTypeSet(),
				ef.getTypeTokenConstraint())) {
			error(ef,
					"Type token constraint "
							+ EMV2Util.getPrintName(ef.getTypeTokenConstraint())
							+ " is not contained in type set of outgoing propagation "
							+ EMV2Util.getPrintName(ep)
							+ EMV2Util.getPrintName(ep.getTypeSet()));
		}
	}

	private void checkOutgoingTypes(OutgoingPropagationCondition opc) {
		ErrorPropagation ep = opc.getOutgoing();
		if (!EM2TypeSetUtil.contains(ep.getTypeSet(),
				opc.getTypeToken())) {
			error(opc,
					"Outgoing error type "+EMV2Util.getPrintName(opc.getTypeToken())+" is not contained in type set of outgoing error propagation specification \'"
							+ EMV2Util.getPrintName(ep) + "\'");
		}
	}

	private void checkTransitionTargetTypes(ErrorBehaviorTransition ebt) {
		ErrorBehaviorState ebs = ebt.getTarget();
		TypeSet ebsTS = ebs.getTypeSet();
		TypeToken ebtargetTS = ebt.getTargetToken();
		if (ebsTS == null && ebtargetTS == null) return;
		if (ebsTS == null && ebtargetTS != null) {
			error(ebt,
					"Target state "+ebs.getName()+" does not have a type set declared but the transition target specifies "
							+ EMV2Util.getPrintName(ebtargetTS) );
		} else
		if (!EM2TypeSetUtil.contains(ebsTS,
				ebtargetTS)) {
			error(ebt,
					"Target type "+EMV2Util.getPrintName(ebt.getTargetToken())+" is not contained in type set of error behavior state \'"
							+ ebs.getName() + "\'");
		}
	}

	private void checkDetectionSourceTypes(ErrorDetection ebt) {
		ErrorBehaviorState ebs = ebt.getState();
		if (ebs == null) return;
		TypeSet ebsTS = ebs.getTypeSet();
		TypeSet srcTS = ebt.getTypeTokenConstraint();
		if (ebsTS == null && srcTS == null) return;
		if (ebsTS == null && srcTS != null) {
			error(ebt,
					"Source state "+ebs.getName()+" does not have a type set declared but the detection source specifies "
							+ EMV2Util.getPrintName(srcTS) );
		} else
		if (!EM2TypeSetUtil.contains(ebsTS,
				srcTS)) {
			error(ebt,
					"Source type "+EMV2Util.getPrintName(srcTS)+" is not contained in type set of error behavior state \'"
							+ ebs.getName() + "\'");
		}
	}

	private void checkTransitionSourceTypes(ErrorBehaviorTransition ebt) {
		ErrorBehaviorState ebs = ebt.getSource();
		if (ebs == null) return;
		TypeSet ebsTS = ebs.getTypeSet();
		TypeSet srcTS = ebt.getTypeTokenConstraint();
		if (ebsTS == null && srcTS == null) return;
		if (ebsTS == null && srcTS != null) {
			error(ebt,
					"Source state "+ebs.getName()+" does not have a type set declared but the transition source specifies "
							+ EMV2Util.getPrintName(srcTS) );
		} else
		if (!EM2TypeSetUtil.contains(ebsTS,
				srcTS)) {
			error(ebt,
					"Source type "+EMV2Util.getPrintName(srcTS)+" is not contained in type set of error behavior state \'"
							+ ebs.getName() + "\'");
		}
	}

	private void checkErrorSinkTypes(ErrorSink ef) {
		ErrorPropagation ep = ef.getIncoming();
		if (!EM2TypeSetUtil.contains(ep.getTypeSet(),
				ef.getTypeTokenConstraint())) {
			error(ef,
					"Type token constraint is not contained in type set of incoming propagation \""
							+ EMV2Util.getPrintName(ep) + "\"");
		}
	}

	private void checkErrorPathTypes(ErrorPath ef) {
		ErrorPropagation epin = ef.getIncoming();
		if (ef.getTypeTokenConstraint() != null) {
			if (!EM2TypeSetUtil.contains(epin.getTypeSet(),
					ef.getTypeTokenConstraint())) {
				error(ef,
						"Type token constraint is not contained in type set of incoming propagation \""
								+ EMV2Util.getPrintName(epin) + "\"");
			}
		}
		ErrorPropagation epout = ef.getOutgoing();
		if (ef.getTargetToken() != null) {
			if (!EM2TypeSetUtil.contains(epout.getTypeSet(),
					ef.getTargetToken())) {
				error(ef,
						"Target token is not contained in type set of outgoing propagation "
								+ EMV2Util.getPrintName(epout));
			}
		} else {
			// path has not target token so we have to match the incoming constraint
			if (!EM2TypeSetUtil.contains(epout.getTypeSet(),
					ef.getTypeTokenConstraint())) {
				error(ef,
						"Incoming path type constraint is not contained in type set of outgoing propagation "
								+ EMV2Util.getPrintName(epout));
			}
			
		}
	}

	private void checkConnectionErrorTypes(Connection conn) {
		ComponentImplementation cimpl = conn.getContainingComponentImpl();
		ConnectionEnd src = conn.getAllSource();
		Context srcCxt = conn.getAllSourceContext();
		ErrorPropagation srcprop = null;
		ErrorPropagation srccontain = null;
		ErrorModelSubclause srcems = null;
		String srcname = (src instanceof Subcomponent)?"access":src.getName();
		if (srcCxt instanceof Subcomponent) {
			ComponentClassifier cl = ((Subcomponent) srcCxt).getClassifier();
			srcems = EMV2Util.getFirstEMV2Subclause(cl);
		} else if (src instanceof Subcomponent) {
			ComponentClassifier cl = ((Subcomponent) src).getClassifier();
			srcems = EMV2Util.getFirstEMV2Subclause(cl);
		} else {
			srcems = EMV2Util.getFirstEMV2Subclause(cimpl);
		}
		if (srcems != null){
			srcprop = EMV2Util.findOutgoingErrorPropagation(srcems, srcname);
			srccontain = EMV2Util.findOutgoingErrorContainment(srcems,srcname);
		}
		ConnectionEnd dst = conn.getAllDestination();
		Context dstCxt = conn.getAllDestinationContext();
		ErrorModelSubclause dstems = null;
		ErrorPropagation dstprop = null;
		ErrorPropagation dstcontain = null;
		String dstname = (dst instanceof Subcomponent)?"access":dst.getName();
		if (dstCxt instanceof Subcomponent) {
			ComponentClassifier cl = ((Subcomponent) dstCxt).getClassifier();
			dstems = EMV2Util.getFirstEMV2Subclause(cl);
		} else if (dst instanceof Subcomponent) {
				ComponentClassifier cl = ((Subcomponent) dst).getClassifier();
				dstems = EMV2Util.getFirstEMV2Subclause(cl);
		} else {
			dstems = EMV2Util.getFirstEMV2Subclause(cimpl);
		}
		if (dstems != null){
			dstprop = EMV2Util.findIncomingErrorPropagation(dstems, dstname);
			dstcontain = EMV2Util.findIncomingErrorContainment(dstems,dstname);
		}
		if (srcprop != null && dstprop != null) {
			if (!EM2TypeSetUtil.contains(dstprop.getTypeSet(),
					srcprop.getTypeSet())) {
				error(conn,
						"Outgoing propagation  "
								+ EMV2Util.getPrintName(srcprop)
								+ EMV2Util.getPrintName(srcprop.getTypeSet())
								+ " has error types not handled by incoming propagation "
								+ EMV2Util.getPrintName(dstprop)
								+ EMV2Util.getPrintName(dstprop.getTypeSet()));
			}
		}
		if (srccontain != null && dstcontain != null) {
			if (!EM2TypeSetUtil.contains(srccontain.getTypeSet(),
					dstcontain.getTypeSet())) {
				error(conn,
						"Outgoing containment  "
								+ EMV2Util.getPrintName(srcprop)
								+ EMV2Util.getPrintName(srcprop.getTypeSet())
								+ " does not contain error types listed by incoming containment "
								+ EMV2Util.getPrintName(dstprop)
								+ EMV2Util.getPrintName(dstprop.getTypeSet()));
			}
		}
		if (srcCxt instanceof Subcomponent && srcprop == null
				&& srccontain == null && dstCxt instanceof Subcomponent
				&& (dstprop != null || dstcontain != null)) {
			if (srcems != null) {
				// has an EMV2 subclause but no propagation specification for
				// the feature
				warning(conn,
						"Connection source has no error propagation/containment but target does: "
								+ (dstprop != null ? EMV2Util
										.getPrintName(dstprop) : EMV2Util
										.getPrintName(dstcontain)));
			} else {
				// TODO check in instance model for connection end point if no
				// error model subclause
				warning(conn,
						"Connection source has no error model subclause but target does: "
								+ (dstprop != null ? EMV2Util
										.getPrintName(dstprop) : EMV2Util
										.getPrintName(dstcontain))
								+ ". Please add error model to source or validate against error model of source subcomponents in instance model");
			}
		}
		if (dstCxt instanceof Subcomponent && dstprop == null
				&& dstCxt instanceof Subcomponent && dstcontain == null
				&& (srcprop != null || srccontain != null)) {
			if (dstems != null) {
				// has an EMV2 subclause but no propagation specification for
				// the feature
				warning(conn,
						"Connection target has no error propagation/containment but source does: "
								+ (srcprop != null ? EMV2Util
										.getPrintName(srcprop) : EMV2Util
										.getPrintName(srccontain)));
			} else {
				// TODO check in instance model for connection end point if no
				// error model subclause
				warning(conn,
						"Connection target has no error model subclause but source does: "
								+ (srcprop != null ? EMV2Util
										.getPrintName(srcprop) : EMV2Util
										.getPrintName(srccontain))
								+ ". Please add error model to target or validate against error model of target subcomponents in instance model");
			}
		}

		if (conn.isBidirectional()) {
			// check for error flow in the opposite direction
			if (srcems != null) {
				dstprop = EMV2Util.findIncomingErrorPropagation(srcems,
						srcname);
				dstcontain = EMV2Util.findIncomingErrorContainment(srcems,
						srcname);
			} else {
				dstprop = null;
				dstcontain = null;
			}
			if (dstems != null) {
				srcprop = EMV2Util.findOutgoingErrorPropagation(dstems,
						dstname);
				srccontain = EMV2Util.findOutgoingErrorContainment(dstems,
						dstname);
			} else {
				srcprop = null;
				srccontain = null;
			}

			if (srcprop != null && dstprop != null) {
				if (!EM2TypeSetUtil.contains(dstprop.getTypeSet(),
						srcprop.getTypeSet())) {
					error(conn,
							"Outgoing propagation  "
									+ EMV2Util.getPrintName(srcprop)
									+ EMV2Util.getPrintName(srcprop
											.getTypeSet())
									+ " has error types not handled by incoming propagation "
									+ EMV2Util.getPrintName(dstprop)
									+ EMV2Util.getPrintName(dstprop
											.getTypeSet()));
				}
			}
			if (srccontain != null && dstcontain != null) {
				if (!EM2TypeSetUtil.contains(srccontain.getTypeSet(),
						dstcontain.getTypeSet())) {
					error(conn,
							"Outgoing containment  "
									+ EMV2Util.getPrintName(srcprop)
									+ EMV2Util.getPrintName(srcprop
											.getTypeSet())
									+ " does not contain error types listed by incoming containment "
									+ EMV2Util.getPrintName(dstprop)
									+ EMV2Util.getPrintName(dstprop
											.getTypeSet()));
				}
			}
			if (srcCxt instanceof Subcomponent
					&& dstCxt instanceof Subcomponent && srcprop == null
					&& srccontain == null
					&& (dstprop != null || dstcontain != null)) {
				if (dstems != null) { // we are doing opposite direction
					// has an EMV2 subclause but no propagation specification
					// for the feature
					warning(conn,
							"Connection source has no error propagation/containment but target does: "
									+ (dstprop != null ? EMV2Util
											.getPrintName(dstprop) : EMV2Util
											.getPrintName(dstcontain)));
				} else {
					// TODO check in instance model for connection end point if
					// no error model subclause
					warning(conn,
							"Connection source has no error model subclause but target does: "
									+ (dstprop != null ? EMV2Util
											.getPrintName(dstprop) : EMV2Util
											.getPrintName(dstcontain))
									+ ". Please validate propagations in instance model");
				}
			}
			if (dstCxt instanceof Subcomponent
					&& dstCxt instanceof Subcomponent && dstprop == null
					&& dstcontain == null
					&& (srcprop != null || srccontain != null)) {
				if (dstems != null) {
					// has an EMV2 subclause but no propagation specification
					// for the feature
					warning(conn,
							"Connection target has no error propagation/containment but source does: "
									+ (srcprop != null ? EMV2Util
											.getPrintName(srcprop) : EMV2Util
											.getPrintName(srccontain)));
				} else {
					// TODO check in instance model for connection end point if
					// no error model subclause
					warning(conn,
							"Connection target has no error model subclause but source does: "
									+ (srcprop != null ? EMV2Util
											.getPrintName(srcprop) : EMV2Util
											.getPrintName(srccontain))
									+ ". Please validate propagations in instance model");
				}
			}

		}
	}

}
