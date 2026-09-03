/**
 * AADL-BA-FrontEnd
 *
 * Copyright (c) 2011-2021 TELECOM ParisTech and CNRS
 *
 * TELECOM ParisTech/LTCI
 *
 * Authors: see AUTHORS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba.analyzers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.Property;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.ba.aadlba.Any;
import org.osate.ba.aadlba.AssignmentAction;
import org.osate.ba.aadlba.BasicAction;
import org.osate.ba.aadlba.BehaviorAction;
import org.osate.ba.aadlba.BehaviorActionBlock;
import org.osate.ba.aadlba.BehaviorActionCollection;
import org.osate.ba.aadlba.BehaviorActions;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorCondition;
import org.osate.ba.aadlba.BehaviorElement;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.aadlba.BehaviorVariable;
import org.osate.ba.aadlba.CondStatement;
import org.osate.ba.aadlba.DataRepresentation;
import org.osate.ba.aadlba.ElementHolder;
import org.osate.ba.aadlba.ElementValues;
import org.osate.ba.aadlba.ElseStatement;
import org.osate.ba.aadlba.ExecuteCondition;
import org.osate.ba.aadlba.Factor;
import org.osate.ba.aadlba.ForOrForAllStatement;
import org.osate.ba.aadlba.IfStatement;
import org.osate.ba.aadlba.IntegerRange;
import org.osate.ba.aadlba.IterativeVariable;
import org.osate.ba.aadlba.PortDequeueAction;
import org.osate.ba.aadlba.PortSendAction;
import org.osate.ba.aadlba.Relation;
import org.osate.ba.aadlba.SimpleExpression;
import org.osate.ba.aadlba.Term;
import org.osate.ba.aadlba.ValueExpression;
import org.osate.ba.aadlba.WhileOrDoUntilStatement;
import org.osate.ba.utils.AadlBaUtils;
import org.osate.ba.utils.AadlBaVisitors;
import org.osate.ba.utils.DimensionException;

/**
 * Checks an already resolved strict Behavior Annex model. Name binding, ambiguity resolution, holder construction, and
 * containment replacement are performed before this checker runs; this class never mutates the supplied model.
 */
public class AadlBaTypeChecker {
	private final BehaviorAnnex ba;
	private final ComponentClassifier baParentContainer;
	private final DataTypeChecker dataChecker;
	private final AnalysisErrorReporterManager errManager;

	/**
	 * @deprecated use {@link #AadlBaTypeChecker(BehaviorAnnex, ComponentClassifier, DataTypeChecker,
	 *             AnalysisErrorReporterManager)} when the behavior annex may be detached
	 */
	@Deprecated
	public AadlBaTypeChecker(BehaviorAnnex ba, DataTypeChecker dataChecker, AnalysisErrorReporterManager errManager) {
		this(ba, AadlBaVisitors.getParentComponent(ba), dataChecker, errManager);
	}

	/**
	 * Constructs a type checker for an already resolved strict Behavior Annex model.
	 *
	 * @param ba the behavior annex
	 * @param parentContainer the component which owns the behavior annex
	 * @param dataChecker the data type checker
	 * @param errManager the error reporter manager
	 */
	public AadlBaTypeChecker(BehaviorAnnex ba, ComponentClassifier parentContainer, DataTypeChecker dataChecker,
			AnalysisErrorReporterManager errManager) {
		this.ba = ba;
		this.baParentContainer = AadlBaVisitors.getParentComponent(ba, parentContainer);
		this.dataChecker = dataChecker;
		this.errManager = errManager;
	}

	/**
	 * Checks the type consistency of the resolved strict model without changing it.
	 *
	 * @return {@code true} when all checked types are consistent
	 */
	public boolean checkTypes() {
		boolean result = checkResolvedModel();
		for (BehaviorVariable variable : ba.getVariables()) {
			result &= checkBehaviorVariable(variable);
		}
		for (BehaviorTransition transition : ba.getTransitions()) {
			result &= checkBehaviorTransition(transition);
		}
		return result;
	}

	private boolean checkResolvedModel() {
		boolean result = true;
		for (TreeIterator<EObject> contents = EcoreUtil.getAllContents(ba, true); contents.hasNext();) {
			EObject object = contents.next();
			if (object instanceof ElementHolder && ((ElementHolder) object).getElement() == null) {
				reportError((Element) object, "resolved behavior annex holder has no element");
				result = false;
			}
		}
		return result;
	}

	private boolean checkBehaviorVariable(BehaviorVariable variable) {
		boolean result = variable.getDataClassifier() instanceof DataClassifier;
		if (!result) {
			reportError(variable, "behavior variable data classifier is not resolved");
		}
		for (org.osate.aadl2.PropertyAssociation association : variable.getOwnedPropertyAssociations()) {
			if (!(association.getProperty() instanceof Property)) {
				reportError(variable, "behavior variable property association is not resolved");
				result = false;
			}
		}
		return result;
	}

	private boolean checkBehaviorTransition(BehaviorTransition transition) {
		boolean result = true;
		BehaviorCondition condition = transition.getCondition();
		if (condition instanceof ExecuteCondition) {
			result &= checkExecuteCondition((ExecuteCondition) condition);
		}
		if (transition.getActionBlock() != null) {
			result &= checkBehaviorActionBlock(transition.getActionBlock());
		}
		return result;
	}

	private boolean checkExecuteCondition(ExecuteCondition condition) {
		if (condition instanceof ValueExpression) {
			TypeHolder type = checkValueExpression((ValueExpression) condition);
			return checkRepresentation((BehaviorElement) condition, "the execute condition", type,
					DataRepresentation.BOOLEAN);
		}
		return true;
	}

	private boolean checkBehaviorActionBlock(BehaviorActionBlock block) {
		return checkBehaviorActions(block.getContent());
	}

	private boolean checkBehaviorActions(BehaviorActions actions) {
		if (actions == null) {
			return true;
		} else if (actions instanceof BehaviorAction) {
			return checkBehaviorAction((BehaviorAction) actions);
		}

		boolean result = true;
		for (BehaviorAction action : ((BehaviorActionCollection) actions).getActions()) {
			result &= checkBehaviorAction(action);
		}
		return result;
	}

	private boolean checkBehaviorAction(BehaviorAction action) {
		if (action instanceof BehaviorActionBlock) {
			return checkBehaviorActionBlock((BehaviorActionBlock) action);
		} else if (action instanceof BasicAction) {
			return checkBasicAction((BasicAction) action);
		} else if (action instanceof CondStatement) {
			return checkConditionalStatement((CondStatement) action);
		}
		return true;
	}

	private boolean checkBasicAction(BasicAction action) {
		if (action instanceof AssignmentAction) {
			return checkAssignment((AssignmentAction) action);
		} else if (action instanceof PortSendAction) {
			return checkPortSend((PortSendAction) action);
		} else if (action instanceof PortDequeueAction) {
			return checkPortDequeue((PortDequeueAction) action);
		}
		return true;
	}

	private boolean checkAssignment(AssignmentAction action) {
		if (action.getValueExpression() instanceof Any) {
			return true;
		}

		TypeHolder targetType = getType(action.getTarget());
		TypeHolder expressionType = checkValueExpression(action.getValueExpression());
		if (targetType == null || expressionType == null) {
			return false;
		}
		if (!dataChecker.conformsTo(targetType, expressionType, true)) {
			reportTypeError(action.getValueExpression(), "assignment", targetType.toString(), expressionType.toString());
			return false;
		}
		return true;
	}

	private boolean checkPortSend(PortSendAction action) {
		if (action.getPort() == null || action.getValueExpression() == null) {
			return true;
		}
		TypeHolder portType = getType(action.getPort());
		TypeHolder valueType = checkValueExpression(action.getValueExpression());
		if (portType == null || valueType == null) {
			return false;
		}
		if (!dataChecker.conformsTo(portType, valueType, true)) {
			reportTypeError(action, "port send action", portType.toString(), valueType.toString());
			return false;
		}
		return true;
	}

	private boolean checkPortDequeue(PortDequeueAction action) {
		if (action.getTarget() == null) {
			return true;
		}
		TypeHolder portType = getType(action.getPort());
		TypeHolder targetType = getType(action.getTarget());
		if (portType == null || targetType == null) {
			return false;
		}
		if (!dataChecker.conformsTo(portType, targetType, true)) {
			reportTypeError(action, "port dequeue action", portType.toString(), targetType.toString());
			return false;
		}
		return true;
	}

	private boolean checkConditionalStatement(CondStatement statement) {
		if (statement instanceof IfStatement) {
			IfStatement ifStatement = (IfStatement) statement;
			boolean result = checkBooleanExpression(ifStatement.getLogicalValueExpression());
			result &= checkBehaviorActions(ifStatement.getBehaviorActions());
			ElseStatement elseStatement = ifStatement.getElseStatement();
			if (elseStatement != null) {
				result &= elseStatement instanceof IfStatement ? checkConditionalStatement((IfStatement) elseStatement)
						: checkBehaviorActions(elseStatement.getBehaviorActions());
			}
			return result;
		} else if (statement instanceof WhileOrDoUntilStatement) {
			WhileOrDoUntilStatement loop = (WhileOrDoUntilStatement) statement;
			return checkBooleanExpression(loop.getLogicalValueExpression())
					& checkBehaviorActions(loop.getBehaviorActions());
		} else if (statement instanceof ForOrForAllStatement) {
			return checkForOrForAll((ForOrForAllStatement) statement);
		}
		return true;
	}

	private boolean checkForOrForAll(ForOrForAllStatement statement) {
		boolean result = statement.getIterativeVariable().getDataClassifier() instanceof DataClassifier;
		if (!result) {
			reportError(statement.getIterativeVariable(), "iterative variable data classifier is not resolved");
		}
		result &= checkElementValues(statement.getIteratedValues(), statement.getIterativeVariable(), statement);
		result &= checkBehaviorActions(statement.getBehaviorActions());
		return result;
	}

	private boolean checkElementValues(ElementValues values, IterativeVariable variable, ForOrForAllStatement statement) {
		TypeHolder valuesType;
		if (values instanceof IntegerRange) {
			IntegerRange range = (IntegerRange) values;
			TypeHolder lower = getType(range.getLowerIntegerValue());
			TypeHolder upper = getType(range.getUpperIntegerValue());
			if (lower == null || upper == null || !dataChecker.conformsTo(lower, upper, true)) {
				reportError(range, "'integer range' error type : its integer values are not consistent");
				return false;
			}
			valuesType = dataChecker.getTopLevelType(lower, upper);
			valuesType.setDimension(1);
		} else {
			valuesType = getType(values);
			if (valuesType == null) {
				return false;
			}
			if (values instanceof org.osate.ba.aadlba.EventDataPortHolder) {
				valuesType.setDimension(1);
			}
		}

		TypeHolder variableType = getType(variable);
		boolean result = variableType != null && dataChecker.conformsTo(valuesType, variableType, false);
		if (!result && variableType != null) {
			reportError(statement, "'iterative variable' type error: an array of \"" + variableType
					+ "\" expected, found \"" + valuesType + "\".");
		}
		if (valuesType.getDimension() == 0) {
			reportError(values, "iterated values are not an array");
			result = false;
		}
		return result;
	}

	private boolean checkBooleanExpression(ValueExpression expression) {
		TypeHolder type = checkValueExpression(expression);
		return checkRepresentation(expression, null, type, DataRepresentation.BOOLEAN);
	}

	private TypeHolder checkValueExpression(ValueExpression expression) {
		EList<Relation> relations = expression.getRelations();
		if (relations.isEmpty()) {
			return null;
		}
		TypeHolder result = checkRelation(relations.get(0));
		for (int i = 1; result != null && i < relations.size(); i++) {
			TypeHolder next = checkRelation(relations.get(i));
			result = next == null ? null
					: dataChecker.checkDefinition(expression, expression.getLogicalOperators().get(i - 1), result, next);
		}
		return result;
	}

	private TypeHolder checkRelation(Relation relation) {
		TypeHolder first = checkSimpleExpression(relation.getFirstExpression());
		if (!relation.isSetRelationalOperator()) {
			return first;
		}
		TypeHolder second = checkSimpleExpression(relation.getSecondExpression());
		return first == null || second == null ? null
				: dataChecker.checkDefinition(relation, relation.getRelationalOperator(), first, second);
	}

	private TypeHolder checkSimpleExpression(SimpleExpression expression) {
		EList<Term> terms = expression.getTerms();
		if (terms.isEmpty()) {
			return null;
		}
		TypeHolder result = checkTerm(terms.get(0));
		if (result != null && expression.isSetUnaryAddingOperator()) {
			result = dataChecker.checkDefinition(expression, expression.getUnaryAddingOperator(), result);
		}
		for (int i = 1; result != null && i < terms.size(); i++) {
			TypeHolder next = checkTerm(terms.get(i));
			result = next == null ? null : dataChecker.checkDefinition(expression,
					expression.getBinaryAddingOperators().get(i - 1), result, next);
		}
		return result;
	}

	private TypeHolder checkTerm(Term term) {
		EList<Factor> factors = term.getFactors();
		if (factors.isEmpty()) {
			return null;
		}
		TypeHolder result = checkFactor(factors.get(0));
		for (int i = 1; result != null && i < factors.size(); i++) {
			TypeHolder next = checkFactor(factors.get(i));
			result = next == null ? null
					: dataChecker.checkDefinition(term, term.getMultiplyingOperators().get(i - 1), result, next);
		}
		return result;
	}

	private TypeHolder checkFactor(Factor factor) {
		TypeHolder first = getType(factor.getFirstValue());
		if (first == null) {
			return null;
		}
		if (factor.isSetUnaryBooleanOperator() || factor.isSetUnaryNumericOperator()) {
			Enumerator operator = factor.isSetUnaryBooleanOperator() ? factor.getUnaryBooleanOperator()
					: factor.getUnaryNumericOperator();
			return dataChecker.checkDefinition(factor, operator, first);
		} else if (factor.isSetBinaryNumericOperator()) {
			TypeHolder second = getType(factor.getSecondValue());
			return second == null ? null
					: dataChecker.checkDefinition(factor, factor.getBinaryNumericOperator(), first, second);
		}
		return first;
	}

	private TypeHolder getType(Element element) {
		if (element == null) {
			return null;
		} else if (element instanceof ValueExpression) {
			return checkValueExpression((ValueExpression) element);
		}
		try {
			return AadlBaUtils.getTypeHolder(element, baParentContainer);
		} catch (DimensionException exception) {
			reportDimensionException(exception);
		} catch (UnsupportedOperationException exception) {
			reportError(element, exception.getMessage());
		}
		return null;
	}

	private boolean checkRepresentation(BehaviorElement element, String name, TypeHolder type,
			DataRepresentation expected) {
		if (type == null) {
			return false;
		}
		if (type.getDataRep() != expected) {
			reportTypeError(element, name == null ? "expression" : name, expected.getName(), type.toString());
			return false;
		}
		return true;
	}

	private void reportDimensionException(DimensionException exception) {
		errManager.error(exception.getElement(), exception.getMessage());
	}

	private void reportTypeError(BehaviorElement element, String name, String expectedTypes, String typeFound) {
		reportError(element,
				"type error for '" + name + "', '" + expectedTypes + "' expected, found '" + typeFound + "'.");
	}

	private void reportError(Element element, String message) {
		errManager.error(element, message);
	}

}
