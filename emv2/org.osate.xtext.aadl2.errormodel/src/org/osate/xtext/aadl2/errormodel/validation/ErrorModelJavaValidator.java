/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.errormodel.validation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Context;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Port;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Root;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
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
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class ErrorModelJavaValidator extends AbstractErrorModelJavaValidator {

	@Override
	protected boolean isResponsible(Map<Object, Object> context, EObject eObject) {
		return (eObject.eClass().getEPackage() == ErrorModelPackage.eINSTANCE || eObject instanceof Connection
				|| eObject instanceof PropertyAssociation);
	}

	// copy of casePropertyAssociation
	@Check(CheckType.FAST)
	public void caseEMV2PropertyAssociation(EMV2PropertyAssociation pa) {
		checkPropertyAssociation(pa);
	}

	protected void checkPropertyAssociation(EMV2PropertyAssociation pa) {
		// type check value against type
		Property pdef = pa.getProperty();
		if (Aadl2Util.isNull(pdef)) {
			return;
		}

		PropertyType pt = pdef.getPropertyType();
		if (Aadl2Util.isNull(pt)) {
			return;
		}

		EList<ModalPropertyValue> pvl = pa.getOwnedValues();
		for (ModalPropertyValue modalPropertyValue : pvl) {
			typeCheckPropertyValues(pt, modalPropertyValue.getOwnedValue(), pa, pdef.getQualifiedName());
		}
		checkAssociationAppliesTo(pa);
	}

	private void checkAssociationAppliesTo(final EMV2PropertyAssociation pa) {
		final Property pn = pa.getProperty();
		final EList<EMV2Path> appliesTo = pa.getEmv2Path();
		if (appliesTo == null || appliesTo.size() == 0) {
			Element element = pa.getOwner();
			if (element instanceof NamedElement) {
				final boolean applies = ((NamedElement) element).acceptsProperty(pn);
				if (!applies) {
					error(pa, "Property " + pa.getProperty().getQualifiedName() + " does not apply to "
							+ ((NamedElement) element).getName());
					// error(pa,
					// "Property " + pa.getQualifiedName() +
					// " does not apply to " + element.eClass().getName());
				}
			}
		} else {
			for (EMV2Path cna : appliesTo) {
				EMV2PathElement path = cna.getEmv2Target();
				if (path != null) {
					// only the last value is interesting to us
					final EMV2PathElement ph = EMV2Util.getLast(path);
					NamedElement ne = ph.getNamedElement();
					if (ne instanceof ErrorTypes) {
						ErrorTypes et = (ErrorTypes) ne;
						EObject prev = ph.eContainer();
						if (prev instanceof EMV2PathElement) {
							ne = ((EMV2PathElement) prev).getNamedElement();
							boolean noMatch = false;
							if (ne instanceof ErrorBehaviorState) {
								TypeSet ts = ((ErrorBehaviorState) ne).getTypeSet();
								noMatch = ts != null && !EMV2TypeSetUtil.contains(ts, et);
							} else if (ne instanceof ErrorPropagation) {
								String epname = EMV2Util.getPrintName((ErrorPropagation) ne);
								EList<ErrorPropagation> eplist = EMV2Util.getContainingErrorModelSubclause(ne)
										.getPropagations();
								Boolean foundType = false;
								for (ErrorPropagation ep : eplist) {
									if (epname.equalsIgnoreCase(EMV2Util.getPrintName(ep))) {
										TypeSet ts = ep.getTypeSet();
										if (EMV2TypeSetUtil.contains(ts, et)) {
											foundType = true;
											break;
										}
									}
								}
								noMatch = !foundType;
							} else if (ne instanceof ErrorEvent) {
								TypeSet ts = ((ErrorEvent) ne).getTypeSet();
								noMatch = ts != null && !EMV2TypeSetUtil.contains(ts, et);
							}
							if (noMatch) {
								error(pa,
										"Property " + pa.getProperty().getQualifiedName()
										+ " applies to refers to type " + EMV2Util.getPrintName(et)
										+ " not contained in type set of error propagation "
										+ EMV2Util.getPrintName(ne));
							}
						}
					}
					if (!Aadl2Util.isNull(ne)) {
						final boolean applies = ph.getNamedElement().acceptsProperty(pn);
						if (!applies) {
							error(pa, "Property " + pa.getProperty().getQualifiedName() + " does not apply to "
									+ EMV2Util.getPrintName(cna));
						}
					}
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void caseErrorPropagation(ErrorPropagation errorPropagation) {
		checkDirectionType(errorPropagation);
		checkTypePropagationAndContainment(errorPropagation);
	}

	@Check(CheckType.FAST)
	public void casePropagationPoint(PropagationPoint propagationPoint) {
		checkUniquePropagationPointorPath(propagationPoint);
	}

	@Override
	@Check(CheckType.FAST)
	public void casePropertyAssociation(PropertyAssociation propertyAssociation) {
		// check that error type is contained in type set of target element
		EList<ContainedNamedElement> apto = propertyAssociation.getAppliesTos();
		for (ContainedNamedElement containedNamedElement : apto) {
			EList<ContainmentPathElement> cpe = containedNamedElement.getContainmentPathElements();
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
					if (!EMV2TypeSetUtil.contains(tts, et)) {
						error(propertyAssociation, "Property " + propertyAssociation.getProperty().getQualifiedName()
								+ " applies to refers to type " + EMV2Util.getPrintName(et)
								+ " not contained in type set of error propagation " + EMV2Util.getPrintName(ne));
					}
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void casePropagationPointConnection(PropagationPath opc) {
		checkUniquePropagationPointorPath(opc);
	}

	@Check(CheckType.FAST)
	public void caseErrorType(ErrorType et) {
		checkCyclicExtends(et);
		checkCyclicRenames(et);
	}

	@Check(CheckType.FAST)
	public void caseTypeSet(TypeSet ts) {
		checkTypeSetUniqueTypes(ts);
		checkCyclicRenames(ts);

	}

	@Check(CheckType.FAST)
	public void caseTypeToken(TypeToken tt) {
		checkTypeTokenUniqueTypes(tt);
		checkTypeTokenSingleTypeSet(tt);
	}

	@Check(CheckType.FAST)
	public void caseRecoverEvent(RecoverEvent recoverEvent) {
		checkRecoverEventTriggerType(recoverEvent);
	}

	@Check(CheckType.FAST)
	public void caseRepairEvent(RecoverEvent recoverEvent) {
		checkRecoverEventTriggerType(recoverEvent);
	}

	@Check(CheckType.FAST)
	public void caseConditionElement(ConditionElement conditionElement) {
		checkConditionElementDirection(conditionElement);
		checkConditionElementType(conditionElement);
	}

	@Check(CheckType.FAST)
	public void caseSConditionElement(SConditionElement conditionElement) {
		checkSConditionElementType(conditionElement);
	}

	@Check(CheckType.FAST)
	public void caseErrorModelSubclause(ErrorModelSubclause subclause) {
		checkSubclauseAssociationToClassifier(subclause);
		checkDuplicateSubclause(subclause);
		checkOnePropagationAndContainmentPoint(subclause);
		Collection<NamedElement> names = EMV2Util.getAllNamedElements(subclause);
		List<NamedElement> doubles = EMV2Util.findDoubleNamedElementsInList(names);
		for (NamedElement namedElement : doubles) {
			if (!(namedElement instanceof ErrorPropagation)) {
				error(namedElement,
						"Subclause has more than one element with the name '" + namedElement.getName() + "'.");
			}
		}
		Collection<ErrorPropagation> ins = EMV2Util
				.getAllIncomingErrorPropagations(subclause.getContainingClassifier());
		for (ErrorPropagation errorPropagation : ins) {
			checkTypePropagationAndContainment(errorPropagation);
		}
		Collection<ErrorPropagation> outs = EMV2Util
				.getAllOutgoingErrorPropagations(subclause.getContainingClassifier());
		for (ErrorPropagation errorPropagation : outs) {
			checkTypePropagationAndContainment(errorPropagation);
		}
		checkUseBehavior(subclause);
	}

	@Check(CheckType.FAST)
	public void caseTypeMappingSet(TypeMappingSet tms) {
		// checkElementRuleConsistency(tms);
	}

	@Check(CheckType.FAST)
	public void caseErrorModelLibrary(ErrorModelLibrary errorModelLibrary) {
		if (errorModelLibrary.getName() == null) {
			errorModelLibrary.setName("emv2");
		}
		boolean cyclicextends = checkCyclicExtends(errorModelLibrary);
		checkUniqueDefiningIdentifiers(errorModelLibrary, cyclicextends);
	}

	@Check(CheckType.FAST)
	public void caseErrorBehaviorStateMachine(ErrorBehaviorStateMachine ebsm) {
		checkUniqueEBSMElements(ebsm);
	}

	@Check(CheckType.FAST)
	public void caseErrorBehaviorTransition(ErrorBehaviorTransition ebt) {
		checkTransitionSourceTypes(ebt);
		checkTransitionTargetTypes(ebt);
		checkBranches(ebt);
		checkTransitionTargetTriggerTypes(ebt);
	}

	@Check(CheckType.FAST)
	public void caseTransitionBranch(TransitionBranch ebt) {
		checkTransitionTargetTypes(ebt);
	}

	@Check(CheckType.FAST)
	public void caseErrorDetection(ErrorDetection ebt) {
		checkDetectionSourceTypes(ebt);
	}

	@Check(CheckType.FAST)
	public void caseErrorSource(ErrorSource ef) {
		checkErrorSourceTypes(ef);
		checkFlowDirection(ef);
	}

	@Check(CheckType.FAST)
	public void caseOutgoingPropagationCondition(OutgoingPropagationCondition opc) {
		checkOutgoingConditionSourceTypes(opc);
		checkOutgoingTypes(opc);
		checkHasConditionOrTypeToken(opc);
	}

	@Check(CheckType.FAST)
	public void caseErrorSink(ErrorSink ef) {
		checkErrorSinkTypes(ef);
		checkFlowDirection(ef);
	}

	@Check(CheckType.FAST)
	public void caseErrorPath(ErrorPath ef) {
		checkErrorPathTypes(ef);
		checkFlowDirection(ef);
		if (ef.getTypeMappingSet() != null) {
			warning(ef, "Legacy support: please declare 'use mappings' at subclause level.");
		}
	}

	@Check(CheckType.FAST)
	public void caseConnection(Connection conn) {
		checkConnectionErrorTypes(conn);
	}

	private void checkRecoverEventTriggerType(RecoverEvent recoverEvent) {
		EList<NamedElement> cl = recoverEvent.getEventInitiator();
		for (NamedElement namedElement : cl) {
			if (!(namedElement instanceof ModeTransition || namedElement instanceof Port
					|| namedElement instanceof InternalFeature)) {
				error(recoverEvent, "Recover event trigger reference '" + namedElement.getName()
				+ "' is not a port, component internal self event, or mode transition.");
			}
		}
	}

	private void checkUseBehavior(ErrorModelSubclause subclause) {
		// now find it in use behavior clause
		EList<ErrorModelSubclause> emslist = EMV2Util.getAllContainingClassifierEMV2Subclauses(subclause);
		ErrorBehaviorStateMachine foundEBMS = null;
		ComponentClassifier foundcl = null;
		for (ErrorModelSubclause errorModelSubclause : emslist) {
			ErrorBehaviorStateMachine ebsm = errorModelSubclause.getUseBehavior();
			if (ebsm != null) {
				if (foundEBMS != null && foundEBMS != ebsm) {
					ComponentClassifier cl = EMV2Util.getAssociatedClassifier(errorModelSubclause);
					if (cl instanceof ComponentImplementation && foundcl instanceof ComponentType) {
						error(foundcl,
								"use behavior '" + foundEBMS.getName() + "' of '" + foundcl.getQualifiedName()
								+ "' is not the same as use behavior '" + ebsm.getName() + "' of '"
								+ cl.getQualifiedName() + "'");
						return;
					} else {
						warning(foundcl,
								"use behavior '" + foundEBMS.getName() + "' of '" + foundcl.getQualifiedName()
								+ "' is not the same as use behavior '" + ebsm.getName() + "' of '"
								+ cl.getQualifiedName() + "'");
					}
				}
				foundEBMS = ebsm;
				foundcl = EMV2Util.getAssociatedClassifier(errorModelSubclause);
			}
		}
	}

	private void checkSConditionElementType(SConditionElement conditionElement) {
		// this method handles state part of composite. The incoming propagation is handled by the ConditionElement method.
		ErrorBehaviorState es = EMV2Util.getState(conditionElement);
		if (es == null) {
			return;
		}
		TypeSet triggerTS = null;
		String triggerName = "";
		triggerTS = es.getTypeSet();
		triggerName = "state " + es.getName();
		TypeSet condTS = conditionElement.getConstraint();
		if (condTS == null) {
			return;
		}
		if (triggerTS == null && condTS != null) {
			// it is ok for a state not to have a type set.
			error(conditionElement, "Condition has type constraint but referenced " + triggerName + " does not.");
		} else if (!EMV2TypeSetUtil.isNoError(condTS) && !EMV2TypeSetUtil.contains(triggerTS, condTS)) {
			error(conditionElement,
					"Condition type constraint " + EMV2Util.getPrintName(condTS) + "is not contained in type set "
							+ EMV2Util.getPrintName(triggerTS) + "of referenced " + triggerName);
		}
	}

	private void checkConditionElementDirection(ConditionElement conditionElement) {
		ErrorPropagation ep = EMV2Util.getErrorPropagation(conditionElement.getQualifiedErrorPropagationReference());
		Subcomponent sub = EMV2Util.getLastSubcomponent(conditionElement.getQualifiedErrorPropagationReference());
		if (ep == null) {
			return;
		}
		if (sub != null && ep.getDirection() != DirectionType.OUT) {
			error(conditionElement,
					"Referenced subcomponent error propagation " + EMV2Util.getPrintName(ep)
							+ " must be an out propagation");
		} else if (ep.getDirection() != DirectionType.IN) {
			error(conditionElement,
					"Referenced error propagation " + EMV2Util.getPrintName(ep) + " must be an in propagation");
		}
	}

	private void checkConditionElementType(ConditionElement conditionElement) {
		EventOrPropagation ep = EMV2Util.getErrorEventOrPropagation(conditionElement);
		if (ep == null) {
			return;
		}
		TypeSet triggerTS = null;
		String triggerName = "";
		if (ep instanceof ErrorPropagation) {
			triggerTS = ((ErrorPropagation) ep).getTypeSet();
			triggerName = "propagation " + EMV2Util.getPrintName((ErrorPropagation) ep);
		} else if (ep instanceof ErrorEvent) {
			triggerTS = ((ErrorEvent) ep).getTypeSet();
			triggerName = "event " + ((ErrorBehaviorEvent) ep).getName();
		}
		TypeSet condTS = conditionElement.getConstraint();
		if (condTS == null) {
			return;
		}
		if (triggerTS == null && condTS != null) {
			// it is ok for a state not to have a type set.
			error(conditionElement, "Condition has type constraint but referenced " + triggerName + " does not.");
		} else if (!EMV2TypeSetUtil.isNoError(condTS) && !EMV2TypeSetUtil.contains(triggerTS, condTS)) {
			error(conditionElement,
					"Condition type constraint " + EMV2Util.getPrintName(condTS) + "is not contained in type set "
							+ EMV2Util.getPrintName(triggerTS) + "of referenced " + triggerName);
		}
	}

	private void checkDirectionType(ErrorPropagation errorPropagation) {
		DirectionType pd = errorPropagation.getDirection();
		DirectionType portd = EMV2Util.getErrorPropagationFeatureDirection(errorPropagation);
		if (!(pd.getName().equalsIgnoreCase(portd.getName()) || portd == DirectionType.IN_OUT)) {
			error(errorPropagation, "Propagation '" + EMV2Util.getPropagationName(errorPropagation)
			+ "' direction does not match feature direction.");
		}
	}

	private void checkTypePropagationAndContainment(ErrorPropagation ep) {
		ErrorPropagation epopposite;
		if (ep.isNot())
		{
			return; // do it only for propagation, so we do not get double messages.
		}
		epopposite = EMV2Util.findErrorContainment(ep.getContainingClassifier(), EMV2Util.getPrintName(ep),
				ep.getDirection());
		if (epopposite == null) {
			return;
		}
		BasicEList<TypeToken> res = EMV2TypeSetUtil.getTypeSetIntersection(ep.getTypeSet(), epopposite.getTypeSet());
		if (!res.isEmpty()) {
			error(ep, "Error propagation and containment " + EMV2Util.getPrintName(ep)
			+ " have a common error type or type product " + EMV2Util.getPrintName(res));
		}
	}

	private void checkSubclauseAssociationToClassifier(ErrorModelSubclause emsc) {
		if (emsc.eContainer() instanceof EMV2Root) {
			ComponentClassifier cl = EMV2Util.getAssociatedClassifier(emsc);
			if (cl == null) {
				warning(emsc, "EMV2 subclause name '" + emsc.getName() + "' does not identify a component classifier.");
			}
		}
	}

	private void checkDuplicateSubclause(ErrorModelSubclause emsc) {
		ErrorModelSubclause duplicate = null;
		ComponentClassifier cl = null;
		if (emsc.eContainer() instanceof EMV2Root) {
			cl = EMV2Util.getAssociatedClassifier(emsc);
			duplicate = EMV2Util.getEmbeddedEMV2Subclause(cl);
		} else {
			cl = (ComponentClassifier) emsc.getContainingClassifier();
			duplicate = EMV2Util.getAssociatedEMV2Subclause(cl);
		}
		if (duplicate != null) {
			error(emsc, "EMV2 subclause for component '" + cl.getName()
			+ "' is both embedded in classifier and declared separately.");
		}
	}

	private void checkOnePropagationAndContainmentPoint(ErrorModelSubclause ems) {
		EList<ErrorPropagation> eps = ems.getPropagations();
		int epssize = eps.size();
		for (int i = 0; i < epssize - 1; i++) {
			ErrorPropagation ep1 = eps.get(i);
			for (int k = i + 1; k < epssize; k++) {
				ErrorPropagation ep2 = eps.get(k);
				if (EMV2Util.getPrintName(ep1).equalsIgnoreCase(EMV2Util.getPrintName(ep2))) {
					// uniqueness needs to take into account direction
					if (((ep1.isNot() && ep2.isNot()) || (!ep1.isNot() && !ep2.isNot()))
							&& ep1.getDirection() == ep2.getDirection()) {
						error(ep2, (ep1.isNot() ? "Error containment " : "Error propagation ")
								+ EMV2Util.getPrintName(ep2) + " can only be declared once [E.7.1 (L1)].");
					}
				}
			}
		}
	}

	private void checkFlowDirection(ErrorSource errorSource) {
		NamedElement ne = errorSource.getSourceModelElement();
		if (ne instanceof ErrorPropagation) {
			if (!Aadl2Util.isNull(ne)&&ne instanceof ErrorPropagation) {
				ErrorPropagation ep = (ErrorPropagation)ne;
				DirectionType epd = ep.getDirection();
				if (!(epd.equals(DirectionType.OUT))) {
					error(errorSource,
							EMV2Util.getPrintName(ep) + " of error source is not an outgoing propagation point.");
				}
			}
		}
	}

	private void checkFlowDirection(ErrorSink errorSink) {
		ErrorPropagation ep = errorSink.getIncoming();
		if (!Aadl2Util.isNull(ep)) {
			DirectionType epd = ep.getDirection();
			if (!(epd.equals(DirectionType.IN))) {
				error(errorSink, EMV2Util.getPrintName(ep) + " of error sink is not an incoming propagation point.");
			}
		}
	}

	private void checkFlowDirection(ErrorPath errorPath) {
		ErrorPropagation ep = errorPath.getIncoming();
		if (!Aadl2Util.isNull(ep)) {
			DirectionType epd = ep.getDirection();
			if (!(epd.equals(DirectionType.IN))) {
				error(errorPath,
						"Source " + EMV2Util.getPrintName(ep) + " of error path is not an incoming propagation point.");
			}
		}
		ep = errorPath.getOutgoing();
		if (!Aadl2Util.isNull(ep)) {
			DirectionType epd = ep.getDirection();
			if (!(epd.equals(DirectionType.OUT))) {
				error(errorPath,
						"Target " + EMV2Util.getPrintName(ep) + " of error path is not an outgoing propagation point.");
			}
		}
	}

	private void checkTypeSetUniqueTypes(TypeSet ts) {
		EList<TypeToken> etlist = ts.getTypeTokens();
		int size = etlist.size();
		for (int i = 0; i < size - 1; i++) {
			TypeToken tok = etlist.get(i);
			for (int k = i + 1; k < size; k++) {
				TypeToken tok2 = etlist.get(k);
				if (EMV2TypeSetUtil.contains(tok, tok2) || EMV2TypeSetUtil.contains(tok2, tok)) {
					error(ts, "Typeset elements " + EMV2Util.getPrintName(tok) + " and " + EMV2Util.getPrintName(tok2)
					+ " are not disjoint.");
				}
			}
		}
	}

	private void checkTypeTokenUniqueTypes(TypeToken ts) {
		if (ts.getType().size() < 2) {
			return;
		}
		Collection<ErrorType> matchTypes = new ArrayList<ErrorType>();
		for (ErrorTypes et : ts.getType()) {
			if (et instanceof ErrorType) {
				ErrorType match = sameRoot(matchTypes, (ErrorType) et);
				if (match != null) {
					error(ts, "Element type " + match.getName() + " and " + et.getName() + " have same root type");
				} else {
					matchTypes.add((ErrorType) et);
				}
			}
		}
	}

	private ErrorType sameRoot(Collection<ErrorType> matchTypes, ErrorType et) {
		ErrorType etroot = EMV2TypeSetUtil.rootType(et);
		for (ErrorType match : matchTypes) {
			if (etroot == EMV2TypeSetUtil.rootType(match)) {
				return match;
			}

		}
		return null;
	}

	private void checkTypeTokenSingleTypeSet(TypeToken ts) {
		EList<ErrorTypes> ets = ts.getType();
		if (ets.size() > 1) {
			ErrorTypes first = ets.get(0);
			if (first instanceof TypeSet) {
				error(ts, "Type product contains type set " + first.getName());
			}
		}
	}

	private void checkMultipleUses(Element useTypesContext) {
		HashSet<ErrorModelLibrary> etlset = new HashSet<ErrorModelLibrary>();
		for (ErrorModelLibrary etl : EMV2Util.getUseTypes(useTypesContext)) {
			if (etlset.contains(etl)) {
				error(useTypesContext, "Error type library " + EMV2Util.getPrintName(etl)
				+ " exists more than once in 'uses types' clause");
			} else {
				etlset.add(etl);
			}
		}
	}

	private void checkMultipleErrorTypesInUsesTypes(Element useTypesContext) {
		Hashtable<String, EObject> etlset = new Hashtable<String, EObject>(10, 10);
		for (ErrorModelLibrary etl : EMV2Util.getUseTypes(useTypesContext)) {
			EList<ErrorType> typeslist = etl.getTypes();
			for (ErrorType errorTypes : typeslist) {
				if (etlset.containsKey(errorTypes.getName())) {
					ErrorModelLibrary eml = EMV2Util
							.getContainingErrorModelLibrary((Element) etlset.get(errorTypes.getName()));
					error(useTypesContext,
							"Error type or type set " + errorTypes.getName() + " in library "
									+ EMV2Util.getPrintName(etl) + " already exists in error type library "
									+ EMV2Util.getPrintName(eml));
				} else {
					etlset.put(errorTypes.getName(), errorTypes);
				}
			}
			EList<TypeSet> typesetlist = etl.getTypesets();
			for (TypeSet typeset : typesetlist) {
				if (etlset.containsKey(typeset.getName())) {
					ErrorModelLibrary eml = EMV2Util
							.getContainingErrorModelLibrary((Element) etlset.get(typeset.getName()));
					error(useTypesContext,
							"Error type or type set " + typeset.getName() + " in library " + EMV2Util.getPrintName(etl)
							+ " already exists in error type library " + EMV2Util.getPrintName(eml));
				} else {
					etlset.put(typeset.getName(), typeset);
				}
			}
		}
	}

	private void checkUniqueEBSMElements(ErrorBehaviorStateMachine ebsm) {
		Hashtable<String, EObject> etlset = new Hashtable<String, EObject>(10, 10);
		for (ErrorBehaviorEvent oep : ebsm.getEvents()) {
			if (etlset.containsKey(oep.getName())) {
				error(oep, "error behavior event " + oep.getName() + " defined more than once");
			} else {
				etlset.put(oep.getName(), oep);
			}
		}
		for (ErrorBehaviorState oep : ebsm.getStates()) {
			if (etlset.containsKey(oep.getName())) {
				error(oep, "error behavior state " + oep.getName() + " previously defined as "
						+ etlset.get(oep.getName()).eClass().getName());
			} else {
				etlset.put(oep.getName(), oep);
			}
		}
		for (ErrorBehaviorTransition oep : ebsm.getTransitions()) {
			if (etlset.containsKey(oep.getName())) {
				error(oep, "error behavior transition " + oep.getName() + " previously defined as "
						+ etlset.get(oep.getName()).eClass().getName());
			} else {
				etlset.put(oep.getName(), oep);
			}
		}
	}

	private void checkUniquePropagationPointorPath(NamedElement ep) {
		Collection<PropagationPoint> tab = EMV2Util.getAllPropagationPoints(ep.getContainingClassifier());
		for (PropagationPoint oep : tab) {
			if (oep != ep && oep.getName().equalsIgnoreCase(ep.getName())) {
				error(ep, "Propagation point " + (ep instanceof PropagationPath ? "path " : "") + ep.getName()
				+ " conflicts with propagation point.");
			}
		}
		for (PropagationPath oep : EMV2Util.getAllPropagationPaths(ep.getContainingClassifier())) {
			if (oep != ep && oep.getName() != null && oep.getName().equalsIgnoreCase(ep.getName())) {
				error(ep, "Propagation point " + (ep instanceof PropagationPath ? "path " : "") + ep.getName()
				+ "' conflicts with propagation path.");
			}
		}
		EObject searchResult = null;
		Classifier cl = AadlUtil.getContainingClassifier(ep);
		if (cl instanceof ComponentImplementation) {
			searchResult = ((ComponentImplementation) cl).getType().findNamedElement(ep.getName());
		} else {
			searchResult = AadlUtil.getContainingClassifier(ep).findNamedElement(ep.getName());
		}
		if (searchResult != null) {
			error(ep,
					"Propagation point " + ep.getName() + " conflicts with feature in component type " + cl.getName());
		}
	}

	private void checkUniqueDefiningIdentifiers(ErrorModelLibrary etl, boolean cyclicextends) {
		Hashtable<String, EObject> types = new Hashtable<String, EObject>(10, 10);
		checkUniqueDefiningEBSMMappingsTransformations(etl, types);
		if (cyclicextends) {
			return;
		}
		for (ErrorModelLibrary xetl : etl.getExtends()) {
			checkUniqueInheritedDefiningErrorTypes(xetl, types);
		}
	}

	private void checkUniqueDefiningEBSMMappingsTransformations(ErrorModelLibrary etl,
			Hashtable<String, EObject> types) {
		for (ErrorBehaviorStateMachine ebsm : etl.getBehaviors()) {
			if (types.containsKey(ebsm.getName())) {
				error(ebsm, "Error behavior state machine identifier " + ebsm.getName()
				+ " is not unique in error model library");
			}
			types.put(ebsm.getName(), ebsm);
		}
		for (TypeMappingSet tms : etl.getMappings()) {
			if (types.containsKey(tms.getName())) {
				error(tms, "Type mapping set identifier " + tms.getName() + " is not unique in error model library");
			}
			types.put(tms.getName(), tms);
		}
		for (TypeTransformationSet tts : etl.getTransformations()) {
			if (types.containsKey(tts.getName())) {
				error(tts, "Type transformation set identifier " + tts.getName()
				+ " is not unique in error model library");
			}
			types.put(tts.getName(), tts);
		}
		for (ErrorTypes ets : etl.getTypes()) {
			if (types.containsKey(ets.getName())) {
				error(ets, "Error type or type set (alias) identifier " + ets.getName()
				+ " is not unique in error model library");
			}
			types.put(ets.getName(), ets);
		}
	}

	private void checkUniqueInheritedDefiningErrorTypes(ErrorModelLibrary etl, Hashtable<String, EObject> types) {
		for (ErrorTypes et : etl.getTypes()) {
			if (types.containsKey(et.getName())) {
				EObject source = types.get(et.getName());
				ErrorModelLibrary eml = EMV2Util.getContainingErrorModelLibrary(et);
				error(source,
						"Error type or type set (alias) " + et.getName() + " inherited from "
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
		if (etl.getExtends() == null) {
			return false;
		}
		HashSet<ErrorModelLibrary> result = new HashSet<ErrorModelLibrary>();
		return recursiveCheckCyclicExtends(etl, result);
	}

	private boolean recursiveCheckCyclicExtends(ErrorModelLibrary etl, HashSet<ErrorModelLibrary> shetl) {
		boolean result = false;
		if (etl.getExtends() != null) {
			shetl.add(etl);
			EList<ErrorModelLibrary> etllist = etl.getExtends();
			for (ErrorModelLibrary xetl : etllist) {
				if (shetl.contains(xetl)) {
					error(xetl, "Cycle in extends of error type library " + etl.getName());
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
		ErrorType et = EMV2Util.resolveAlias(origet);
		if (et.getSuperType() == null) {
			return;
		}
		HashSet<ErrorType> result = new HashSet<ErrorType>();
		while (et.getSuperType() != null) {
			result.add(et);
			ErrorType last = et;
			et = EMV2Util.resolveAlias(et.getSuperType());
			if (result.contains(et)) {
				error(origet, "Cycle in supertype hierarchy of error type " + origet.getName() + " at type "
						+ last.getName());
				return;
			}
		}
	}

	private void checkCyclicRenames(ErrorType origet) {
		ErrorType et = origet;
		if (et.getAliasedType() == null) {
			return;
		}
		HashSet<ErrorType> result = new HashSet<ErrorType>();
		while (et.getAliasedType() != null) {
			result.add(et);
			ErrorType last = et;
			et = et.getAliasedType();
			if (result.contains(et)) {
				error(origet, "Cycle in renames of error type " + origet.getName() + " at type " + last.getName());
				return;
			}
		}
	}

	private void checkCyclicRenames(TypeSet origet) {
		TypeSet et = origet;
		if (et.getAliasedType() == null) {
			return;
		}
		HashSet<TypeSet> result = new HashSet<TypeSet>();
		while (et.getAliasedType() != null) {
			result.add(et);
			TypeSet last = et;
			et = et.getAliasedType();
			if (result.contains(et)) {
				error(origet, "Cycle in renames of type set " + origet.getName() + " at type set " + last.getName());
				return;
			}
		}
	}

	private void checkOutgoingTypes(OutgoingPropagationCondition opc) {
		if (opc.getTypeToken() == null) {
			return;
		}
		ErrorPropagation ep = opc.getOutgoing();
		if (ep != null) {
			if (!EMV2TypeSetUtil.isNoError(opc.getTypeToken())
					&& !EMV2TypeSetUtil.contains(ep.getTypeSet(), opc.getTypeToken())) {
				error(opc,
						"Outgoing error type " + EMV2Util.getPrintName(opc.getTypeToken())
						+ " is not contained in type set of outgoing error propagation specification \'"
						+ EMV2Util.getPrintName(ep) + "\'");
			}
		} else {
			if (opc.isAllPropagations()) {
				// check containment for all of the outgoing propagation points
				Classifier cl = opc.getContainingClassifier();
				Collection<ErrorPropagation> eps = EMV2Util.getAllOutgoingErrorPropagations(cl);
				for (ErrorPropagation errorPropagation : eps) {
					if (opc.getTypeToken() != null) {
						if (!EMV2TypeSetUtil.isNoError(opc.getTypeToken())
								&& !EMV2TypeSetUtil.contains(errorPropagation.getTypeSet(), opc.getTypeToken())) {
							error(opc,
									"Outgoing error type " + EMV2Util.getPrintName(opc.getTypeToken())
									+ " is not contained in type set of outgoing propagation "
									+ EMV2Util.getPrintName(errorPropagation)
									+ EMV2Util.getPrintName(errorPropagation.getTypeSet()));
						}
					}
				}
			}
		}
	}

	private void checkHasConditionOrTypeToken(OutgoingPropagationCondition opc) {
		if (opc.getCondition() == null && opc.getTypeToken() == null) {
			error(opc, "Propagation condition must have at least a condition within brackets or a type set for the outgoing propagation");
		}
	}

	private void checkTransitionTargetTypes(ErrorBehaviorTransition ebt) {
		if (ebt.isSteadyState()) {
			return;
		}
		ErrorBehaviorState ebs = ebt.getTarget();
		if (ebs != null) {
			TypeSet ebsTS = ebs.getTypeSet();
			TypeSet tt = ebt.getTargetToken();
			if (tt == null || tt.getTypeTokens().isEmpty()) {
				return;
			}
			TypeToken ebtargetTS = tt.getTypeTokens().get(0);
			if (ebtargetTS == null) {
				return;
			}
			if (ebsTS == null && ebtargetTS != null) {
				error(ebt,
						"Target state " + ebs.getName()
						+ " does not have a type set declared but the transition target specifies "
						+ EMV2Util.getPrintName(ebtargetTS));
			} else if (!EMV2TypeSetUtil.contains(ebsTS, ebtargetTS)) {
				error(ebt, "Target type " + EMV2Util.getPrintName(ebt.getTargetToken())
				+ " is not contained in type set of error behavior state \'" + ebs.getName() + "\'");
			}
		}
	}

	private void checkTransitionTargetTriggerTypes(ErrorBehaviorTransition ebt) {
		if (ebt.isSteadyState()) {
			return;
		}
		ErrorBehaviorState targetstate = ebt.getTarget();
		if (targetstate != null) {
			TypeSet targetTS = targetstate.getTypeSet();
			if (targetTS == null) {
				return;
			}
			TypeSet tt = ebt.getTargetToken();
			if (tt != null) {
				return;
			}
			// state requires a type
			if (ebt.getCondition() instanceof ConditionElement) {
				// either the event must be typed or the source state must be typed
				EventOrPropagation ep = EMV2Util.getErrorEventOrPropagation((ConditionElement) ebt.getCondition());
				if (ep instanceof ErrorEvent) {
					ErrorEvent ev = (ErrorEvent) ep;
					TypeSet evTS = ev.getTypeSet();
					if (evTS == null) {
						TypeSet srcTS = ebt.getSource().getTypeSet();
						if (srcTS == null) {
							error(ebt,
									"Target state " + targetstate.getName()
											+ " requires type but the triggering error event "
											+ EMV2Util.getPrintName(ev) + " or source state "
											+ EMV2Util.getPrintName(ebt.getSource()) + " does not have a type");
						} else {
							// source typeset must be contained in target type set
							if (!EMV2TypeSetUtil.contains(targetTS, srcTS)) {
								error(ebt,
										"Target state " + targetstate.getName()
												+ " does not contain types of source state "
												+ EMV2Util.getPrintName(ebt.getSource()));
							}
						}
					} else {
						// error event has type. It must be consistent with the expected state type
						if (!EMV2TypeSetUtil.contains(targetTS, evTS)) {
							error(ebt, "Target state " + targetstate.getName()
									+ " does not contain types of error event " + EMV2Util.getPrintName(ev));
						}
					}
				} else if (ep instanceof ErrorPropagation) {
					ErrorPropagation eprop = (ErrorPropagation) ep;
					// we have an error propagation
					// we can check type compatibility
					if (!EMV2TypeSetUtil.contains(targetTS, eprop.getTypeSet())) {
						error(ebt, "Target state " + targetstate.getName()
								+ " does not contain types of error propagation " + EMV2Util.getPrintName(eprop));
					}
				}
			} else {
				// full condition expression
				// type transformation & events must be typed
				ErrorBehaviorStateMachine ebsm = (ErrorBehaviorStateMachine) targetstate.eContainer();
				if (ebsm.getUseTransformation().isEmpty()) {
					error(ebt, "Target state " + targetstate.getName()
							+ " does not include a target type but requires types. For conditions on multiple elements a target type must be assigned explicitly or a type transformation must be specified in the error behavior state machine"
							+ EMV2Util.getPrintName(ebsm));
				}
			}
		}
	}

	private void checkBranches(ErrorBehaviorTransition ebt) {
		EList<TransitionBranch> branches = ebt.getDestinationBranches();
		boolean foundsteady = false;
		boolean foundothers = false;
		BigDecimal prob = new BigDecimal(0.0, MathContext.UNLIMITED);
		if (branches.isEmpty()) {
			return;
		}
		for (TransitionBranch transitionBranch : branches) {
			if (transitionBranch.isSteadyState()) {
				if (foundsteady) {
					error(ebt, "More than one same state branch");
				} else {
					foundsteady = true;
				}
			}
			if (transitionBranch.getValue().isOthers()) {
				if (foundothers) {
					error(ebt, "More than one other branch");
				} else {
					foundothers = true;
				}
			}
			String bv = EMV2Util.stripUnderScore(transitionBranch.getValue().getRealvalue());
			Property sl = transitionBranch.getValue().getSymboliclabel();
			if (bv != null) {
				prob = prob.add(new BigDecimal(bv, MathContext.UNLIMITED));
			} else if (sl != null) {
				ComponentClassifier cl = EMV2Util.getAssociatedClassifier(ebt);
				List<EMV2PropertyAssociation> pa = EMV2Properties.getProperty(sl.getQualifiedName(), cl, ebt, null);
				for (EMV2PropertyAssociation emv2PropertyAssociation : pa) {
					prob = prob.add(new BigDecimal(EMV2Properties.getRealValue(emv2PropertyAssociation),
							MathContext.UNLIMITED));
				}
			}
		}
		if (!foundothers && prob.compareTo(new BigDecimal(1.0)) != 0) {
			error(ebt, "Sum of branch probabilities must be 1");
		}
		if (foundothers && prob.compareTo(new BigDecimal(1.0)) >= 0) {
			error(ebt, "Sum of branch probabilities must be less than 1 due to 'others'");
		}
	}

	private void checkTransitionTargetTypes(TransitionBranch ebt) {
		if (ebt.isSteadyState()) {
			return;
		}
		ErrorBehaviorState ebs = ebt.getTarget();
		if (ebs != null) {
			TypeSet ebsTS = ebs.getTypeSet();
			TypeSet tt = ebt.getTargetToken();
			if (tt == null || tt.getTypeTokens().isEmpty()) {
				return;
			}
			TypeToken ebtargetTS = tt.getTypeTokens().get(0);
			if (ebtargetTS == null) {
				return;
			}
			if (ebsTS == null && ebtargetTS != null) {
				error(ebt,
						"Target state " + ebs.getName()
						+ " does not have a type set declared but the transition target specifies "
						+ EMV2Util.getPrintName(ebtargetTS));
			} else if (!EMV2TypeSetUtil.contains(ebsTS, ebtargetTS)) {
				error(ebt, "Target type " + EMV2Util.getPrintName(ebt.getTargetToken())
				+ " is not contained in type set of error behavior state \'" + ebs.getName() + "\'");
			}
		}
	}

	private void checkOutgoingConditionSourceTypes(OutgoingPropagationCondition opc) {
		ErrorBehaviorState ebs = opc.getState();
		if (ebs == null) {
			return;
		}
		TypeSet ebsTS = ebs.getTypeSet();
		TypeSet srcTS = opc.getTypeTokenConstraint();
		if (srcTS == null) {
			return;
		}
		if (ebsTS == null && srcTS != null) {
			error(opc,
					"Error state " + ebs.getName()
					+ " does not have a type set declared but the outgoing propagation condition has type token "
					+ EMV2Util.getPrintName(srcTS));
		} else if (!EMV2TypeSetUtil.contains(ebsTS, srcTS)) {
			error(opc, "Outgoing condition state type set " + EMV2Util.getPrintName(srcTS)
			+ " is not contained in type set of error behavior state \'" + ebs.getName() + "\'");
		}
	}

	private void checkDetectionSourceTypes(ErrorDetection ebt) {
		ErrorBehaviorState ebs = ebt.getState();
		if (ebs == null) {
			return;
		}
		TypeSet ebsTS = ebs.getTypeSet();
		TypeSet srcTS = ebt.getTypeTokenConstraint();
		if (srcTS == null) {
			return;
		}
		if (ebsTS == null && srcTS != null) {
			error(ebt,
					"Source state " + ebs.getName()
					+ " does not have a type set declared but the detection source specifies "
					+ EMV2Util.getPrintName(srcTS));
		} else if (!EMV2TypeSetUtil.contains(ebsTS, srcTS)) {
			error(ebt, "Source type " + EMV2Util.getPrintName(srcTS)
			+ " is not contained in type set of error behavior state \'" + ebs.getName() + "\'");
		}
	}

	private void checkTransitionSourceTypes(ErrorBehaviorTransition ebt) {
		ErrorBehaviorState ebs = ebt.getSource();
		if (ebs == null) {
			return;
		}
		TypeSet ebsTS = ebs.getTypeSet();
		TypeSet srcTS = ebt.getTypeTokenConstraint();
		if (srcTS == null) {
			return;
		}
		if (ebsTS == null && srcTS != null) {
			error(ebt,
					"Source state " + ebs.getName()
					+ " does not have a type set declared but the transition source specifies "
					+ EMV2Util.getPrintName(srcTS));
		} else if (!EMV2TypeSetUtil.contains(ebsTS, srcTS)) {
			error(ebt, "Source type " + EMV2Util.getPrintName(srcTS)
			+ " is not contained in type set of error behavior state \'" + ebs.getName() + "\'");
		}
	}

	private void checkErrorSourceTypes(ErrorSource ef) {
		if (ef.getTypeTokenConstraint() == null) {
			return;
		}
		NamedElement ne = ef.getSourceModelElement();
		if (ne instanceof Connection) {
			return;
		}
		if (ne instanceof ErrorPropagation) {
			ErrorPropagation epout = (ErrorPropagation) ne;
			if (!EMV2TypeSetUtil.contains(epout.getTypeSet(), ef.getTypeTokenConstraint())) {
				error(ef,
						"Error source type constraint " + EMV2Util.getPrintName(ef.getTypeTokenConstraint())
						+ " is not contained in type set of outgoing propagation "
						+ EMV2Util.getPrintName(epout) + EMV2Util.getPrintName(epout.getTypeSet()));
			}
		} else if (ef.isAll()) {
			if (EMV2Util.getContainingErrorModelSubclause(ef).getConnectionErrorSources().contains(ef)) {
				return;
			}
			// check containment for all of the outgoing propagation points
			Classifier cl = ef.getContainingClassifier();
			Collection<ErrorPropagation> eps = EMV2Util.getAllOutgoingErrorPropagations(cl);
			for (ErrorPropagation errorPropagation : eps) {
				if (!EMV2TypeSetUtil.contains(errorPropagation.getTypeSet(), ef.getTypeTokenConstraint())) {
					error(ef,
							"Error source type constraint " + EMV2Util.getPrintName(ef.getTypeTokenConstraint())
							+ " is not contained in type set of outgoing propagation "
							+ EMV2Util.getPrintName(errorPropagation)
							+ EMV2Util.getPrintName(errorPropagation.getTypeSet()));
				}
			}
		}
	}

	private void checkErrorSinkTypes(ErrorSink ef) {
		if (ef.getTypeTokenConstraint() == null) {
			return;
		}
		ErrorPropagation ep = ef.getIncoming();
		if (ep != null) {
			if (!EMV2TypeSetUtil.contains(ep.getTypeSet(), ef.getTypeTokenConstraint())) {
				error(ef, "Type token constraint is not contained in type set of incoming propagation \""
						+ EMV2Util.getPrintName(ep) + "\"");
			}
		} else {
			// check containment for all of the incoming propagation points
			Classifier cl = ef.getContainingClassifier();
			Collection<ErrorPropagation> eps = EMV2Util.getAllIncomingErrorPropagations(cl);
			for (ErrorPropagation errorPropagation : eps) {
				if (!EMV2TypeSetUtil.contains(errorPropagation.getTypeSet(), ef.getTypeTokenConstraint())) {
					error(ef, "Type token constraint is not contained in type set of incoming propagation \""
							+ EMV2Util.getPrintName(errorPropagation) + "\"");
				}
			}
		}
	}

	private void checkErrorPathTypes(ErrorPath ef) {
		ErrorPropagation epin = ef.getIncoming();
		ErrorPropagation epout = ef.getOutgoing();
		if (ef.getTypeTokenConstraint() != null) {
			// check that incoming flow type constraint is contained in that of
			// in prop
			if (epin != null) {
				if (!EMV2TypeSetUtil.contains(epin.getTypeSet(), ef.getTypeTokenConstraint())) {
					error(ef, "Type token constraint is not contained in type set of incoming propagation "
							+ EMV2Util.getPrintName(epin));
				}
			} else {
				// check containment for all of the incoming propagation points
				Classifier cl = ef.getContainingClassifier();
				Collection<ErrorPropagation> eps = EMV2Util.getAllIncomingErrorPropagations(cl);
				for (ErrorPropagation errorPropagation : eps) {
					if (!EMV2TypeSetUtil.contains(errorPropagation.getTypeSet(), ef.getTypeTokenConstraint())) {
						error(ef, "Type token constraint is not contained in type set of incoming propagation "
								+ EMV2Util.getPrintName(errorPropagation));
					}
				}
			}
		}
		if (ef.getTargetToken() != null) {
			// check that outoging flow type token is contained in that of prop
			if (epout != null) {
				if (!EMV2TypeSetUtil.contains(epout.getTypeSet(), ef.getTargetToken())) {
					error(ef, "Target token is not contained in type set of outgoing propagation "
							+ EMV2Util.getPrintName(epout));
				}
			} else {
				// check containment for all of the outgoing propagation points
				Classifier cl = ef.getContainingClassifier();
				Collection<ErrorPropagation> eps = EMV2Util.getAllOutgoingErrorPropagations(cl);
				for (ErrorPropagation errorPropagation : eps) {
					if (!EMV2TypeSetUtil.contains(errorPropagation.getTypeSet(), ef.getTargetToken())) {
						error(ef, "Target token is not contained in type set of outgoing propagation "
								+ EMV2Util.getPrintName(errorPropagation));
					}
				}
			}
		} else {
			// no outgoing path type token
			if (ef.getTypeTokenConstraint() != null) {
				// match the incoming path constraint
				if (epout != null) {
					// need to handle use mappings
					if (!EMV2TypeSetUtil.contains(epout.getTypeSet(), ef.getTypeTokenConstraint())) {
						error(ef, "Incoming path type constraint is not contained in type set of outgoing propagation "
								+ EMV2Util.getPrintName(epout));
					}
				} else {
					// check containment for all of the outgoing propagation
					// points
					Classifier cl = ef.getContainingClassifier();
					Collection<ErrorPropagation> eps = EMV2Util.getAllOutgoingErrorPropagations(cl);
					for (ErrorPropagation errorPropagation : eps) {
						if (!EMV2TypeSetUtil.contains(errorPropagation.getTypeSet(), ef.getTypeTokenConstraint())) {
							error(ef,
									"Incoming path type constraint is not contained in type set of outgoing propagation "
											+ EMV2Util.getPrintName(errorPropagation));
						}
					}
				}
			} else {
				// no incoming or outgoing ef type constraint or token
				// check in to out type set of propagations for the flow
				if (epout != null && epin != null) {
					if (!EMV2TypeSetUtil.contains(epout.getTypeSet(), epin.getTypeSet())) {
						error(ef,
								"Incoming error propagation " + EMV2Util.getPrintName(epin)
								+ " constraint is not contained in type set of outgoing propagation "
								+ EMV2Util.getPrintName(epout));
					}
				} else if (epout == null && epin != null) {
					// check containment for all of the outgoing propagation
					// points against one incoming
					Classifier cl = ef.getContainingClassifier();
					Collection<ErrorPropagation> eps = EMV2Util.getAllOutgoingErrorPropagations(cl);
					for (ErrorPropagation allepout : eps) {
						if (!EMV2TypeSetUtil.contains(allepout.getTypeSet(), epin.getTypeSet())) {
							error(ef,
									"Incoming error propagation " + EMV2Util.getPrintName(epin)
									+ " constraint is not contained in type set of outgoing propagation "
									+ EMV2Util.getPrintName(allepout));
						}
					}
				} else if (epout != null && epin == null) {
					// check containment for all of the outgoing propagation
					// points against one incoming
					Classifier cl = ef.getContainingClassifier();
					Collection<ErrorPropagation> eps = EMV2Util.getAllIncomingErrorPropagations(cl);
					for (ErrorPropagation errorPropagation : eps) {
						if (!EMV2TypeSetUtil.contains(epout.getTypeSet(), errorPropagation.getTypeSet())) {
							error(ef,
									"Incoming error propagation " + EMV2Util.getPrintName(errorPropagation)
									+ " constraint is not contained in type set of outgoing propagation "
									+ EMV2Util.getPrintName(epout));
						}
					}
				} else if (epout == null && epin == null) {
					// check containment for all of the outgoing propagation
					// points against one incoming
					Classifier cl = ef.getContainingClassifier();
					Collection<ErrorPropagation> epsin = EMV2Util.getAllIncomingErrorPropagations(cl);
					Collection<ErrorPropagation> epsout = EMV2Util.getAllOutgoingErrorPropagations(cl);
					for (ErrorPropagation allepout : epsout) {
						for (ErrorPropagation allepin : epsin) {
							if (!EMV2TypeSetUtil.contains(allepout.getTypeSet(), allepin.getTypeSet())) {
								error(ef,
										"Incoming error propagation " + EMV2Util.getPrintName(epin)
										+ " constraint is not contained in type set of outgoing propagation "
										+ EMV2Util.getPrintName(epout));
							}
						}
					}
				}
			}
		}

	}

	private void checkConnectionErrorTypes(Connection conn) {
		ComponentImplementation cimpl = conn.getContainingComponentImpl();
		ConnectionEnd src = conn.getAllSource();
		Context srcCxt = conn.getAllSourceContext();
		ErrorPropagation srcprop = null;
		ErrorPropagation srccontain = null;
		Classifier srccl = null;
		String srcname = (src instanceof Subcomponent) ? "access" : src.getName();
		if (srcCxt instanceof Subcomponent) {
			srccl = ((Subcomponent) srcCxt).getClassifier();
		} else if (src instanceof Subcomponent) {
			srccl = ((Subcomponent) src).getClassifier();
		} else {
			srccl = cimpl;
		}
		if (srccl != null) {
			if (AadlUtil.isIncomingConnection(conn)) {
				srcprop = EMV2Util.findIncomingErrorPropagation(srccl, srcname);
				srccontain = EMV2Util.findIncomingErrorContainment(srccl, srcname);
			} else {
				srcprop = EMV2Util.findOutgoingErrorPropagation(srccl, srcname);
				srccontain = EMV2Util.findOutgoingErrorContainment(srccl, srcname);
			}
		}
		ConnectionEnd dst = conn.getAllDestination();
		Context dstCxt = conn.getAllDestinationContext();
		Classifier dstcl = null;
		ErrorPropagation dstprop = null;
		ErrorPropagation dstcontain = null;
		String dstname = (dst instanceof Subcomponent) ? "access" : dst.getName();
		if (dstCxt instanceof Subcomponent) {
			dstcl = ((Subcomponent) dstCxt).getClassifier();
		} else if (dst instanceof Subcomponent) {
			dstcl = ((Subcomponent) dst).getClassifier();
		} else {
			dstcl = cimpl;
		}
		if (dstcl != null) {
			if (AadlUtil.isOutgoingConnection(conn)) {
				dstprop = EMV2Util.findOutgoingErrorPropagation(dstcl, dstname);
				dstcontain = EMV2Util.findOutgoingErrorContainment(dstcl, dstname);
			} else {
				dstprop = EMV2Util.findIncomingErrorPropagation(dstcl, dstname);
				dstcontain = EMV2Util.findIncomingErrorContainment(dstcl, dstname);
			}
		}
		if (srcprop != null && dstprop != null) {
			if (!EMV2TypeSetUtil.contains(dstprop.getTypeSet(), srcprop.getTypeSet())) {

				TypeMappingSet typeEquivalence = EMV2Util.getAllTypeEquivalenceMapping(cimpl);

				if (typeEquivalence != null) {
					TypeToken mappedtt = EMV2TypeSetUtil.mapTypeToken(srcprop.getTypeSet(), typeEquivalence);
					if (mappedtt != null) {
						if (!EMV2TypeSetUtil.contains(dstprop.getTypeSet(), mappedtt)) {
							error(conn, "Source propagation  " + EMV2Util.getPrintName(srcprop)
							+ EMV2Util.getPrintName(srcprop.getTypeSet())
							+ " has error types not handled by destination propagation "
							+ EMV2Util.getPrintName(dstprop) + EMV2Util.getPrintName(dstprop.getTypeSet()));
						}
					}
				} else {
					error(conn,
							"Source propagation  " + EMV2Util.getPrintName(srcprop)
							+ EMV2Util.getPrintName(srcprop.getTypeSet())
							+ " has error types not handled by destination propagation "
							+ EMV2Util.getPrintName(dstprop) + EMV2Util.getPrintName(dstprop.getTypeSet()));
				}
			}
		}
		if (srccontain != null && dstcontain != null) {
			if (!EMV2TypeSetUtil.contains(srcprop.getTypeSet(), dstprop.getTypeSet())) {
				error(conn,
						"Source containment  " + EMV2Util.getPrintName(srcprop)
						+ EMV2Util.getPrintName(srcprop.getTypeSet())
						+ " does not contain error types listed by Source containment "
						+ EMV2Util.getPrintName(dstprop) + EMV2Util.getPrintName(dstprop.getTypeSet()));
			}
		}
		// TODO comment out once we handle this consistency check at the
		// instance level
		if (srcCxt instanceof Subcomponent && dstCxt instanceof Subcomponent) {
			// only when going across
			if (srccontain == null && dstcontain != null) {
				EList<ErrorModelSubclause> srcsubclauses = EMV2Util.getAllContainingClassifierEMV2Subclauses(srccl);
				if (!srcsubclauses.isEmpty()) {
					warning(conn,
							"No outgoing containment from " + srcCxt.getName() + " for incoming containment "
									+ EMV2Util.getPrintName(dstcontain) + EMV2Util.getPrintName(dstcontain.getTypeSet())
									+ ". Check for Unhandled Faults.");
				}
			}
			if (srcprop != null && dstprop == null) {
				EList<ErrorModelSubclause> dstsubclauses = EMV2Util.getAllContainingClassifierEMV2Subclauses(dstcl);
				if (!dstsubclauses.isEmpty()) {
					warning(conn,
							"No incoming error propagation from " + dstCxt.getName() + " for outgoing propagation "
									+ EMV2Util.getPrintName(srcprop) + EMV2Util.getPrintName(srcprop.getTypeSet())
									+ ". Check for Unhandled Faults.");
				}
			}
		}

		if (conn.isAllBidirectional()) {
			// check for error flow in the opposite direction
			if (srccl != null) {
				if (AadlUtil.isIncomingConnection(conn)) {
					dstprop = EMV2Util.findOutgoingErrorPropagation(srccl, srcname);
					dstcontain = EMV2Util.findOutgoingErrorContainment(srccl, srcname);
				} else {
					dstprop = EMV2Util.findIncomingErrorPropagation(srccl, srcname);
					dstcontain = EMV2Util.findIncomingErrorContainment(srccl, srcname);
				}
			} else {
				dstprop = null;
				dstcontain = null;
			}
			if (dstcl != null) {
				if (AadlUtil.isOutgoingConnection(conn)) {
					srcprop = EMV2Util.findIncomingErrorPropagation(dstcl, dstname);
					srccontain = EMV2Util.findIncomingErrorContainment(dstcl, dstname);
				} else {
					srcprop = EMV2Util.findOutgoingErrorPropagation(dstcl, dstname);
					srccontain = EMV2Util.findOutgoingErrorContainment(dstcl, dstname);
				}
			} else {
				srcprop = null;
				srccontain = null;
			}

			if (srcprop != null && dstprop != null) {
				if (!EMV2TypeSetUtil.contains(dstprop.getTypeSet(), srcprop.getTypeSet())) {
					error(conn,
							"Reverse direction: Destination propagation  " + EMV2Util.getPrintName(srcprop)
							+ EMV2Util.getPrintName(srcprop.getTypeSet())
							+ " has error types not handled by source propagation "
							+ EMV2Util.getPrintName(dstprop) + EMV2Util.getPrintName(dstprop.getTypeSet()));
				}
			}
			if (srccontain != null && dstcontain != null) {
				if (!EMV2TypeSetUtil.contains(srcprop.getTypeSet(), dstprop.getTypeSet())) {
					error(conn,
							"Reverse direction: Destination containment  " + EMV2Util.getPrintName(srcprop)
							+ EMV2Util.getPrintName(srcprop.getTypeSet())
							+ " does not contain error types listed by source containment "
							+ EMV2Util.getPrintName(dstprop) + EMV2Util.getPrintName(dstprop.getTypeSet()));
				}
			}
			// TODO comment out once we handle this consistency check at the
			// instance level
			if (srcCxt instanceof Subcomponent && dstCxt instanceof Subcomponent) {
				// only when going across
				if (srccontain == null && dstcontain != null) {
					warning(conn, "No outgoing containment for incoming containment "
							+ EMV2Util.getPrintName(dstcontain) + EMV2Util.getPrintName(dstcontain.getTypeSet()));
				}
				if (srcprop != null && dstprop == null) {
					warning(conn, "No incoming error propagation for outgoing propagation "
							+ EMV2Util.getPrintName(srcprop) + EMV2Util.getPrintName(srcprop.getTypeSet()));
				}
			}

		}
	}

}
