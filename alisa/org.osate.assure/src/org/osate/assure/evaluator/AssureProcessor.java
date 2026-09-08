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
package org.osate.assure.evaluator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.XbaseGenerated;
import org.junit.runner.JUnitCore;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.PropertyValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.alisa.common.common.CommonFactory;
import org.osate.alisa.common.common.TypeRef;
import org.osate.alisa.common.typing.CommonInterpreter;
import org.osate.alisa.common.util.CommonUtilExtension;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.ElseResult;
import org.osate.assure.assure.ModelResult;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.PredicateResult;
import org.osate.assure.assure.SubsystemResult;
import org.osate.assure.assure.ThenResult;
import org.osate.assure.assure.ValidationResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.categories.categories.CategoryFilter;
import org.osate.pluginsupport.ExecuteJavaUtil;
import org.osate.reqspec.reqSpec.ValuePredicate;
import org.osate.resolute.ResoluteUtil;
import org.osate.result.AnalysisResult;
import org.osate.result.BooleanValue;
import org.osate.result.Diagnostic;
import org.osate.result.DiagnosticType;
import org.osate.result.IntegerValue;
import org.osate.result.RealValue;
import org.osate.result.ResultFactory;
import org.osate.result.ResultType;
import org.osate.result.StringValue;
import org.osate.result.util.ResultUtil;
import org.osate.verify.internal.util.VerificationMethodDispatchers;
import org.osate.verify.internal.util.VerifyJavaUtil;
import org.osate.verify.internal.util.VerifyUtilExtension;
import org.osate.verify.verify.AgreeMethod;
import org.osate.verify.verify.FormalParameter;
import org.osate.verify.verify.JUnit4Method;
import org.osate.verify.verify.JavaMethod;
import org.osate.verify.verify.ManualMethod;
import org.osate.verify.verify.PluginMethod;
import org.osate.verify.verify.PythonMethod;
import org.osate.verify.verify.ResoluteMethod;
import org.osate.verify.verify.VerificationMethod;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

/**
 * Performs verification activities, records their results, and propagates result counts.
 */
public class AssureProcessor implements IAssureProcessor {
	private CommonInterpreter interpreter = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.___common___"))
			.get(CommonInterpreter.class);
	private IProgressMonitor progressmonitor = new NullProgressMonitor();
	private Procedure1<? super URI> progressUpdater;
	private Procedure0 requirementsCoverageUpdater;
	private final RuleEnvironment env = new RuleEnvironment();
	private final HashMap<String, PropertyExpression> computes = new HashMap<>();
	private final HashMap<String, Object> vals = new HashMap<>();
	private long start;
	private CategoryFilter filter;
	private boolean save = true;

	public AssureProcessor() {
		env.add("vals", vals);
		env.add("computes", computes);
	}

	public void startSubTask(VerificationActivityResult vaResult) {
		progressmonitor.subTask(AssureUtilExtension.getTarget(vaResult).getName());
		start = System.currentTimeMillis();
	}

	public void doneSubTask(VerificationActivityResult vaResult) {
		progressmonitor.worked(1);
		vaResult.getMetrics().setExecutionTime(System.currentTimeMillis() - start);
	}

	@Override
	public void processCase(AssuranceCaseResult assureResult, CategoryFilter filter, IProgressMonitor monitor,
			boolean save) {
		progressmonitor = monitor;
		this.filter = filter;
		this.save = save;
		try {
			progressmonitor.beginTask(assureResult.getName(),
					AssureUtilExtension.numberVerificationResults(assureResult));
			process(assureResult);
		} finally {
			saveAssureResult(assureResult);
			progressmonitor.done();
		}
		updateRequirementsCoverage();
	}

	public void saveAssureResult(AssureResult assureResult) {
		try {
			if (save && assureResult.eResource() != null) {
				assureResult.eResource().save(null);
			}
		} catch (Throwable e) {
			throw sneakyThrow(e);
		}
	}

	protected void _process(AssuranceCaseResult result) {
		result.getModelResult().forEach(this::process);
	}

	protected void _process(ModelResult result) {
		result.getClaimResult().forEach(this::process);
		result.getSubsystemResult().forEach(this::process);
		result.getSubAssuranceCase().forEach(this::process);
	}

	protected void _process(SubsystemResult result) {
		result.getClaimResult().forEach(this::process);
		result.getSubsystemResult().forEach(this::process);
	}

	protected void _process(ClaimResult result) {
		if (VerifyUtilExtension.evaluateRequirementFilter(result.getTargetReference().getRequirement().getRequirement(),
				filter)) {
			vals.clear();
			computes.clear();
			result.getVerificationActivityResult().forEach(this::process);
			if (result.getPredicateResult() != null) {
				process(result.getPredicateResult());
			}
			result.getSubClaimResult().forEach(this::process);
		}
	}

	protected void _process(VerificationActivityResult result) {
		var activity = result.getTargetReference().getVerificationActivity();
		if (VerifyUtilExtension.evaluateVerificationActivityFilter(activity, filter)
				&& VerifyUtilExtension.evaluateVerificationMethodFilter(activity, filter)) {
			startSubTask(result);
			if (result.getPreconditionResult() != null) {
				process(result.getPreconditionResult());
				if (!AssureUtilExtension.isSuccess(result.getPreconditionResult())) {
					doneSubTask(result);
					return;
				}
			}
			runVerificationMethod(result);
			if (result.getValidationResult() != null) {
				process(result.getValidationResult());
			}
			doneSubTask(result);
		}
	}

	protected void _process(ElseResult result) {
		result.getFirst().forEach(this::process);
		if (AssureUtilExtension.hasError(result.getFirst())) {
			AssureUtilExtension.recordElse(result, ResultType.ERROR);
			result.getError().forEach(this::process);
		} else if (AssureUtilExtension.isFailed(result.getFirst())) {
			AssureUtilExtension.recordElse(result, ResultType.FAILURE);
			result.getFail().forEach(this::process);
		} else {
			AssureUtilExtension.recordNoElse(result);
		}
	}

	protected void _process(ThenResult result) {
		result.getFirst().forEach(this::process);
		if (AssureUtilExtension.isSuccess(result.getFirst())) {
			AssureUtilExtension.recordNoSkip(result);
			result.getSecond().forEach(this::process);
		} else {
			AssureUtilExtension.recordSkip(result);
		}
	}

	protected void _process(ValidationResult result) {
		runVerificationMethod(result);
	}

	protected void _process(PreconditionResult result) {
		runVerificationMethod(result);
	}

	protected void _process(PredicateResult result) {
		runVerificationMethod(result);
	}

	public void runVerificationMethod(VerificationResult verificationResult) {
		if (progressmonitor.isCanceled()) {
			throw new OperationCanceledException();
		}

		var method = AssureUtilExtension.getMethod(verificationResult);
		var instanceRoot = AssureUtilExtension.getAssuranceCaseInstanceModel(verificationResult, save);
		if (instanceRoot == null) {
			finishWithError(verificationResult, "Could not find instance model", null);
			return;
		}

		var targetComponent = AssureUtilExtension.findTargetSystemComponentInstance(instanceRoot,
				AssureUtilExtension.getEnclosingSubsystemResult(verificationResult));
		if (targetComponent == null) {
			finishWithError(verificationResult, "Unresolved target system for claim", null);
			return;
		}

		var targetElement = AssureUtilExtension.getCaseTargetModelElement(verificationResult);
		InstanceObject target = targetComponent;
		if (targetElement != null && targetElement.getName() != null) {
			target = CommonUtilExtension.findElementInstance(targetComponent, targetElement);
			if (target == null) {
				finishWithError(verificationResult, "Unresolved target model element in instance for claim",
						targetElement);
				return;
			}
		}
		env.add("target", target);

		if (verificationResult instanceof PredicateResult predicateResult) {
			evaluatePredicate(predicateResult);
			finish(verificationResult);
			return;
		}

		Iterable<? extends EObject> parameters = switch (verificationResult) {
		case VerificationActivityResult activityResult -> AssureUtilExtension.getTarget(activityResult).getActuals();
		case ValidationResult ignored -> {
			var validation = method.getValidation();
			var validationParameters = validation.getParameters();
			method = validation.getMethod();
			yield validationParameters;
		}
		case PreconditionResult ignored -> {
			var precondition = method.getPrecondition();
			var preconditionParameters = precondition.getParameters();
			method = precondition.getMethod();
			yield preconditionParameters;
		}
		case null, default -> null;
		};

		if (size(parameters) < method.getFormals().size()) {
			finishWithError(verificationResult,
					"Fewer actual parameters than formal parameters for verification activity", null);
			return;
		}

		var formalCount = method.getFormals().size();
		var formalIndex = 0;
		var parameterObjects = new ArrayList<PropertyExpression>(size(parameters));
		for (var parameter : parameters) {
			PropertyExpression expression;
			switch (parameter) {
			case FormalParameter formalParameter -> {
				var activityResult = (VerificationActivityResult) verificationResult.eContainer();
				var actuals = AssureUtilExtension.getTarget(activityResult).getActuals();
				var index = method.getFormals().indexOf(formalParameter);
				if (index < 0) {
					finishWithError(verificationResult, "Referenced formal parameter " + formalParameter.getName()
							+ " of method " + method.getName() + " does not have an actual value", null);
					return;
				}
				expression = actuals.get(index);
			}
			case PropertyExpression propertyExpression -> expression = propertyExpression;
			case null, default -> {
				var formalParameter = method.getFormals().get(formalIndex);
				finishWithError(verificationResult, "Actual parameter for " + formalParameter.getName() + " of method "
						+ method.getName() + " does not have an actual value", null);
				return;
			}
			}

			var interpretation = interpreter.interpretExpression(env, expression);
			if (interpretation.failed()) {
				var formalParameter = method.getFormals().get(formalIndex);
				finishWithError(verificationResult,
						"Could not evaluate expression for " + formalParameter.getName() + " of method "
								+ method.getName() + ": "
								+ CommonUtilExtension.getFailedMsg(interpretation.getRuleFailedException()),
						null);
				return;
			}

			PropertyValue actual = interpretation.getValue();
			if (formalIndex < formalCount) {
				var formalParameter = method.getFormals().get(formalIndex++);
				if (actual instanceof NumberValue number && formalParameter.getUnit() != null
						&& number.getUnit() != null
						&& !formalParameter.getUnit().getName().equals(number.getUnit().getName())) {
					actual = AssureUtilExtension.convertValueToUnit(number, formalParameter.getUnit());
				}
				parameterObjects.add(actual);
			}
		}

		try {
			var methodKind = method.getMethodKind();
			switch (methodKind) {
			case PluginMethod pluginMethod -> processPluginResult(verificationResult, method, targetComponent, target,
					VerificationMethodDispatchers.eInstance.dispatchVerificationMethod(pluginMethod, instanceRoot,
							parameterObjects));
			case AgreeMethod ignored ->
				AssureUtilExtension.setToError(verificationResult, "Execution of AGREE methods is not supported");
			case JUnit4Method junitMethod -> {
				var test = ExecuteJavaUtil.getJavaClass(junitMethod.getClassPath());
				var result = new JUnitCore().run(test);
				if (result.getFailureCount() == 0) {
					AssureUtilExtension.setToSuccess(verificationResult);
				} else {
					var proverResult = ResultFactory.eINSTANCE.createResult();
					AssureUtilExtension.doJUnitResults(result, proverResult);
					AssureUtilExtension.setToFail(verificationResult, proverResult.getDiagnostics());
				}
			}
			case ManualMethod ignored -> {
			}
			case null, default ->
				executeVerificationMethod(verificationResult, method, targetComponent, target, parameterObjects);
			}
		} catch (AssertionError e) {
			AssureUtilExtension.setToFail(verificationResult, e);
		} catch (Throwable e) {
			AssureUtilExtension.setToError(verificationResult, e);
		}
		finish(verificationResult);
	}

	private void processPluginResult(VerificationResult verificationResult, VerificationMethod method,
			ComponentInstance targetComponent, InstanceObject target, Object returned) {
		switch (returned) {
		case String markerType -> {
			switch (target) {
			case ConnectionInstance connection -> {
				for (var instance : CommonUtilExtension
						.findConnectionInstances(targetComponent.getConnectionInstances(), connection)) {
					AssureUtilExtension.addMarkersAsResult(verificationResult, instance, markerType, method);
				}
			}
			case EndToEndFlowInstance flow -> {
				for (var instance : CommonUtilExtension.findETEFInstances(targetComponent.getEndToEndFlows(), flow)) {
					AssureUtilExtension.addMarkersAsResult(verificationResult, instance, markerType, method);
				}
			}
			case null, default ->
				AssureUtilExtension.addMarkersAsResult(verificationResult, target, markerType, method);
			}
		}
		case AnalysisResult analysisResult -> {
			var foundResult = false;
			for (var result : analysisResult.getResults()) {
				if (result.getModelElement() == target || matchEnclosingComponentInstance(result, target)) {
					foundResult = true;
					recordResultStatus(verificationResult, result);
					copyDiagnostics(result.getDiagnostics(), verificationResult);
				}
			}
			copyDiagnostics(analysisResult.getDiagnostics(), verificationResult);
			if (!foundResult) {
				AssureUtilExtension.setToError(verificationResult,
						"No Result found for requirement verification target " + target.getName(), target);
			}
		}
		case org.osate.result.Result result -> {
			if (result.getModelElement() == target) {
				recordResultStatusAlways(verificationResult, result);
				copyDiagnostics(result.getDiagnostics(), verificationResult);
			} else {
				AssureUtilExtension.setToError(verificationResult,
						"Result is not for requirement verification target " + target.getName(), target);
			}
		}
		case null, default -> AssureUtilExtension.setToError(verificationResult,
				"Analysis return type is not a string, Result, or AnalysisResult", targetComponent);
		}
	}

	private static void recordResultStatus(VerificationResult verificationResult, org.osate.result.Result result) {
		if (!AssureUtilExtension.isError(verificationResult)) {
			recordResultStatusAlways(verificationResult, result);
		}
	}

	private static void recordResultStatusAlways(VerificationResult verificationResult,
			org.osate.result.Result result) {
		if (ResultUtil.isResultError(result)) {
			AssureUtilExtension.setToError(verificationResult);
		} else if (ResultUtil.isResultFailure(result)) {
			AssureUtilExtension.setToFail(verificationResult);
		} else {
			AssureUtilExtension.setToSuccess(verificationResult);
		}
	}

	private static void copyDiagnostics(Collection<Diagnostic> diagnostics, VerificationResult verificationResult) {
		diagnostics.stream().map(EcoreUtil::copy).forEach(verificationResult.getIssues()::add);
	}

	public boolean matchEnclosingComponentInstance(org.osate.result.Result result, EObject target) {
		return result.getModelElement() instanceof InstanceObject instance && instance.getComponentInstance() == target;
	}

	public void updateRequirementsCoverage() {
		if (requirementsCoverageUpdater != null) {
			requirementsCoverageUpdater.apply();
		}
	}

	public Object getType(FormalParameter formalParameter) {
		return getType(formalParameter.getType());
	}

	public Object getType(PropertyType propertyType) {
		return switch (propertyType) {
		case AadlBoolean ignored -> Boolean.class;
		case AadlInteger ignored -> Integer.class;
		case AadlReal ignored -> Double.class;
		case AadlString ignored -> String.class;
		case TypeRef typeRef -> getType(typeRef.getRef());
		case null, default -> null;
		};
	}

	public PropertyExpression toLiteral(Object data, FormalParameter formalParameter) {
		var unit = formalParameter == null ? null : formalParameter.getUnit();
		var expectedType = getType(formalParameter);
		return switch (data) {
		case Boolean value -> {
			var literal = Aadl2Factory.eINSTANCE.createBooleanLiteral();
			literal.setValue(value);
			yield literal;
		}
		case Integer value -> numberLiteral(value, expectedType, unit);
		case Double value -> numberLiteral(value, expectedType, unit);
		case String value -> {
			var literal = Aadl2Factory.eINSTANCE.createStringLiteral();
			literal.setValue(value);
			yield literal;
		}
		case BooleanValue value -> {
			var literal = Aadl2Factory.eINSTANCE.createBooleanLiteral();
			literal.setValue(value.isValue());
			yield literal;
		}
		case IntegerValue value -> numberLiteral(value.getValue(), expectedType, unit);
		case RealValue value -> numberLiteral(value.getValue(), expectedType, unit);
		case StringValue value -> {
			var literal = Aadl2Factory.eINSTANCE.createStringLiteral();
			literal.setValue(value.getValue());
			yield literal;
		}
		case InstanceObject instance -> {
			var reference = CommonFactory.eINSTANCE.createAModelReference();
			reference.setModelElement(instance);
			yield reference;
		}
		case InstanceReferenceValue value -> {
			var reference = CommonFactory.eINSTANCE.createAModelReference();
			reference.setModelElement(value.getReferencedInstanceObject());
			yield reference;
		}
		case null -> null;
		default -> (PropertyExpression) data;
		};
	}

	private static NumberValue numberLiteral(Number value, Object expectedType, UnitLiteral unit) {
		if (expectedType == Integer.class) {
			var literal = Aadl2Factory.eINSTANCE.createIntegerLiteral();
			if (value instanceof Double) {
				AssureUtilExtension.setValue(literal, value.doubleValue());
			} else {
				literal.setValue(value.longValue());
			}
			literal.setUnit(unit);
			return literal;
		}
		var literal = Aadl2Factory.eINSTANCE.createRealLiteral();
		literal.setValue(value.doubleValue());
		literal.setUnit(unit);
		return literal;
	}

	public void updateProgress(VerificationResult result) {
		if (progressUpdater != null) {
			progressUpdater.apply(EcoreUtil.getURI(result));
		}
	}

	public void evaluatePredicate(PredicateResult predicateResult) {
		computes.clear();
		evaluatePredicate(predicateResult, AssureUtilExtension.getPredicate(predicateResult));
	}

	public void evaluatePredicate(VerificationResult verificationResult, ValuePredicate predicate) {
		try {
			var result = interpreter.interpretExpression(env, predicate.getXpression());
			if (result.failed()) {
				AssureUtilExtension.setToError(verificationResult, "Could not evaluate value predicate: "
						+ CommonUtilExtension.getFailedMsg(result.getRuleFailedException()), null);
			} else if (((BooleanLiteral) result.getValue()).getValue()) {
				AssureUtilExtension.setToSuccess(verificationResult);
			} else {
				AssureUtilExtension.setToFail(verificationResult);
			}
		} catch (AssertionError e) {
			AssureUtilExtension.setToFail(verificationResult, e);
		} catch (Throwable e) {
			AssureUtilExtension.setToError(verificationResult, e);
		}
	}

	public void evaluateComputePredicate(org.osate.result.Result result, ValuePredicate predicate) {
		try {
			var interpretation = interpreter.interpretExpression(env, predicate.getXpression());
			if (interpretation.failed()) {
				ResultUtil.setToError(result, "Could not evaluate value predicate: "
						+ CommonUtilExtension.getFailedMsg(interpretation.getRuleFailedException()));
			} else {
				result.setResultType(((BooleanLiteral) interpretation.getValue()).getValue() ? ResultType.SUCCESS
						: ResultType.FAILURE);
			}
		} catch (AssertionError e) {
			result.setResultType(ResultType.FAILURE);
			if (result.getMessage() == null) {
				result.setMessage(e.getMessage());
			} else {
				result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(e.getMessage(), null));
			}
		} catch (Throwable e) {
			ResultUtil.setToError(result, e.getMessage());
		}
	}

	public void executeVerificationMethod(VerificationResult verificationResult, VerificationMethod method,
			ComponentInstance targetComponent, InstanceObject target, List<PropertyExpression> parameters) {
		switch (target) {
		case ConnectionInstance connection -> {
			for (var instance : CommonUtilExtension.findConnectionInstances(targetComponent.getConnectionInstances(),
					connection)) {
				if (checkPropertyValues(verificationResult, instance)) {
					executeMethodOnce(verificationResult, method, targetComponent, instance, parameters);
				}
			}
			updateAggregateStatus(verificationResult);
		}
		case EndToEndFlowInstance flow -> {
			for (var instance : CommonUtilExtension.findETEFInstances(targetComponent.getEndToEndFlows(), flow)) {
				if (checkPropertyValues(verificationResult, instance)) {
					executeMethodOnce(verificationResult, method, targetComponent, instance, parameters);
				}
			}
			updateAggregateStatus(verificationResult);
		}
		case null -> AssureUtilExtension.setToError(verificationResult,
				"Could not find target element instance " + target.getName(), targetComponent);
		default -> {
			if (checkPropertyValues(verificationResult, target)) {
				executeMethodOnce(verificationResult, method, targetComponent, target, parameters);
			}
		}
		}
	}

	private static void updateAggregateStatus(VerificationResult result) {
		if (ResultUtil.hasResultErrors(result.getResults())) {
			AssureUtilExtension.setToError(result);
		} else if (ResultUtil.hasResultFailures(result.getResults())) {
			AssureUtilExtension.setToFail(result);
		}
	}

	public void executeMethodOnce(VerificationResult verificationResult, VerificationMethod method,
			ComponentInstance targetComponent, InstanceObject target, List<PropertyExpression> parameters) {
		switch (method.getMethodKind()) {
		case JavaMethod ignored -> executeJavaMethodOnce(verificationResult, method, target, parameters);
		case ResoluteMethod ignored ->
			executeResoluteMethodOnce(verificationResult, method, targetComponent, target, parameters);
		case PythonMethod ignored ->
			AssureUtilExtension.setToError(verificationResult, "Python script execution not supported", null);
		case null, default -> {
		}
		}
	}

	public void executeResoluteMethodOnce(VerificationResult verificationResult, VerificationMethod method,
			ComponentInstance targetComponent, InstanceObject target, List<PropertyExpression> parameters) {
		if (ResoluteUtil.isResoluteInstalled()) {
			var resoluteMethod = (ResoluteMethod) method.getMethodKind();
			var returned = ResoluteUtil.getResolute()
					.executeResoluteFunctionOnce(resoluteMethod.getMethodReference(), targetComponent, target,
							parameters);
			processExecutionResult(verificationResult, method, target, returned);
		} else {
			AssureUtilExtension.setToError(verificationResult, "Resolute not installed");
		}
	}

	public void executeJavaMethodOnce(VerificationResult verificationResult, VerificationMethod method,
			InstanceObject target, List<PropertyExpression> parameters) {
		var javaMethod = (JavaMethod) method.getMethodKind();
		var parameterClasses = VerifyJavaUtil.getParameterClasses(javaMethod);
		var objects = VerifyJavaUtil.getActualJavaObjects(javaMethod, target, parameters);
		var returned = ExecuteJavaUtil.invokeJavaMethod(javaMethod.getMethodPath(),
				parameterClasses.toArray(Class<?>[]::new), objects.toArray());
		if ((returned == null || returned instanceof Exception) && method.getTargetType() == null) {
			parameterClasses.remove(0);
			objects.remove(0);
			returned = ExecuteJavaUtil.invokeJavaMethod(javaMethod.getMethodPath(),
					parameterClasses.toArray(Class<?>[]::new), objects.toArray());
		}
		processExecutionResult(verificationResult, method, target, returned);
	}

	public void processExecutionResult(VerificationResult verificationResult, VerificationMethod method,
			InstanceObject target, Object returned) {
		switch (returned) {
		case null -> AssureUtilExtension.setToError(verificationResult, "Java method does not include class", target);
		case Boolean value when method.getResults().isEmpty() -> {
			if (value) {
				AssureUtilExtension.setToSuccess(verificationResult);
			} else {
				AssureUtilExtension.setToFail(verificationResult);
			}
		}
		case org.osate.result.Result result -> {
			verificationResult.getResults().add(result);
			if (verificationResult instanceof VerificationActivityResult activityResult) {
				evaluateComputePredicate(activityResult, method, target, result);
			}
			recordResultStatus(verificationResult, result);
		}
		case Diagnostic diagnostic -> {
			if (diagnostic.getDiagnosticType() == DiagnosticType.ERROR) {
				AssureUtilExtension.setToFail(verificationResult);
			} else {
				AssureUtilExtension.setToSuccess(verificationResult);
			}
			verificationResult.getIssues().add(diagnostic);
		}
		case AnalysisResult analysisResult -> {
			if (ResultUtil.isAnalysisResultError(analysisResult)) {
				AssureUtilExtension.setToError(verificationResult);
			} else {
				if (verificationResult instanceof VerificationActivityResult activityResult) {
					analysisResult.getResults()
							.forEach(result -> evaluateComputePredicate(activityResult, method, target, result));
				}
				if (!AssureUtilExtension.isError(verificationResult)) {
					if (ResultUtil.hasResultErrors(analysisResult)) {
						AssureUtilExtension.setToError(verificationResult);
					} else if (ResultUtil.hasResultFailures(analysisResult)) {
						AssureUtilExtension.setToFail(verificationResult);
					} else {
						AssureUtilExtension.setToSuccess(verificationResult);
					}
				}
			}
			verificationResult.getAnalysisresult().add(analysisResult);
		}
		case Exception exception -> AssureUtilExtension.setToError(verificationResult,
				"Verification method execution exception: " + exception.getMessage(), target);
		case Object value when method.getResults().size() == 1 ->
			processComputeValue(verificationResult, method, target, value);
		default -> AssureUtilExtension.setToError(verificationResult,
				"Single non-boolean return value but no expected compute variable for predicate", target);
		}
	}

	private void processComputeValue(VerificationResult verificationResult, VerificationMethod method,
			InstanceObject target, Object returned) {
		if (verificationResult instanceof VerificationActivityResult activityResult) {
			var predicate = AssureUtilExtension.getTarget(AssureUtilExtension.getClaimResult(verificationResult))
					.getPredicate();
			if (predicate instanceof ValuePredicate valuePredicate) {
				if (AssureUtilExtension.containsComputeVariables(valuePredicate)) {
					var computeVariables = activityResult.getTargetReference().getVerificationActivity().getComputes();
					if (computeVariables.size() == 1) {
						computes.clear();
						computes.put(computeVariables.getFirst().getCompute().getName(),
								toLiteral(returned, method.getResults().getFirst()));
						evaluatePredicate(verificationResult, valuePredicate);
					} else {
						AssureUtilExtension.setToError(verificationResult,
								"One value returned but " + computeVariables.size() + " compute variable assignments");
					}
					return;
				}
				AssureUtilExtension.setToError(verificationResult,
						"Non-boolean single return value and predicate without compute variable", target);
			}
			AssureUtilExtension.setToError(verificationResult, "Single return value expected to be boolean value",
					target);
		} else {
			AssureUtilExtension.setToError(verificationResult,
					"Precondition or Validation expect boolean as single return value", target);
		}
	}

	public void evaluateComputePredicate(VerificationActivityResult verificationResult, VerificationMethod method,
			InstanceObject target, org.osate.result.Result returned) {
		var predicate = AssureUtilExtension.getTarget(AssureUtilExtension.getClaimResult(verificationResult))
				.getPredicate();
		if (!ResultUtil.isResultSuccess(returned) || AssureUtilExtension.isError(verificationResult)
				|| !(predicate instanceof ValuePredicate valuePredicate)
				|| !AssureUtilExtension.containsComputeVariables(valuePredicate)) {
			return;
		}
		var computeVariables = verificationResult.getTargetReference().getVerificationActivity().getComputes();
		if (computeVariables.isEmpty()) {
			ResultUtil.setToError(returned, "No return values assigned to compute variables");
			return;
		}
		env.decrement("element");
		env.add("element", target);
		computes.clear();
		var formalReturns = method.getResults().iterator();
		var values = returned.getValues().iterator();
		if (computeVariables.size() <= returned.getValues().size()
				&& computeVariables.size() <= method.getResults().size()) {
			for (var computeReference : computeVariables) {
				computes.put(computeReference.getCompute().getName(), toLiteral(values.next(), formalReturns.next()));
			}
			evaluateComputePredicate(returned, valuePredicate);
		} else {
			ResultUtil.setToError(returned, "Fewer values returned than expected as compute variables");
		}
	}

	public boolean checkPropertyValues(VerificationResult verificationResult, InstanceObject target) {
		if (!(verificationResult instanceof VerificationActivityResult activityResult)) {
			return true;
		}
		var properties = AssureUtilExtension.getMethod(verificationResult).getProperties().iterator();
		var expressions = AssureUtilExtension.getTarget(activityResult).getPropertyValues().iterator();
		var success = true;
		while (properties.hasNext() && expressions.hasNext()) {
			var property = properties.next();
			var expression = expressions.next();
			try {
				var expressionResult = interpreter.interpretExpression(env, expression);
				if (expressionResult.failed()) {
					AssureUtilExtension.setToError(verificationResult,
							"Could not evaluate expression for " + property.getName() + ": "
									+ CommonUtilExtension.getFailedMsg(expressionResult.getRuleFailedException()),
							null);
					success = false;
					continue;
				}
				PropertyValue modelValue = null;
				var propertyIsSet = true;
				try {
					var modelExpression = target.getSimplePropertyValue(property);
					if (modelExpression instanceof PropertyValue propertyValue) {
						modelValue = propertyValue;
					}
				} catch (PropertyNotPresentException e) {
					propertyIsSet = false;
				}
				var requiredValue = expressionResult.getValue();
				if (propertyIsSet) {
					checkPropertyValue(verificationResult, target, property, modelValue, requiredValue);
				} else {
					var association = target.createOwnedPropertyAssociation();
					association.setProperty(property);
					association.createOwnedValue().setOwnedValue(EcoreUtil.copy(requiredValue));
				}
			} catch (Exception e) {
				AssureUtilExtension.setToError(verificationResult, "Could not process property " + property.getName());
			}
		}
		return success;
	}

	private static void checkPropertyValue(VerificationResult verificationResult, InstanceObject target,
			Property property, PropertyValue modelValue, PropertyValue requiredValue) {
		if (requiredValue instanceof NumberValue number) {
			var unit = number.getUnit();
			var requiredNumber = number.getScaledValue(unit);
			var modelNumber = PropertyUtils.getScaledNumberValue(target, property, unit);
			if (requiredNumber != modelNumber) {
				AssureUtilExtension.addErrorIssue(verificationResult, target,
						"Property " + property.getQualifiedName() + ": Value in model (" + modelNumber + unit.getName()
								+ ") does not match required value (" + requiredNumber + unit.getName() + ")");
				AssureUtilExtension.setToFail(verificationResult);
			}
		} else if (!Objects.equals(requiredValue, modelValue)) {
			AssureUtilExtension.addErrorIssue(verificationResult, target, "Property " + property.getQualifiedName()
					+ ": Value in model (" + modelValue + ") does not match required value (" + requiredValue + ")");
			AssureUtilExtension.setToFail(verificationResult);
		}
	}

	@XbaseGenerated
	public void process(AssureResult result) {
		switch (result) {
		case PreconditionResult preconditionResult -> _process(preconditionResult);
		case PredicateResult predicateResult -> _process(predicateResult);
		case ValidationResult validationResult -> _process(validationResult);
		case VerificationActivityResult activityResult -> _process(activityResult);
		case ElseResult elseResult -> _process(elseResult);
		case ThenResult thenResult -> _process(thenResult);
		case AssuranceCaseResult assuranceCaseResult -> _process(assuranceCaseResult);
		case ClaimResult claimResult -> _process(claimResult);
		case ModelResult modelResult -> _process(modelResult);
		case SubsystemResult subsystemResult -> _process(subsystemResult);
		case null, default -> throw new IllegalArgumentException("Unhandled parameter types: [" + result + "]");
		}
	}

	@Override
	public void setProgressUpdater(Procedure1<? super URI> progressUpdater) {
		this.progressUpdater = progressUpdater;
	}

	@Override
	public void setRequirementsCoverageUpdater(Procedure0 requirementsCoverageUpdater) {
		this.requirementsCoverageUpdater = requirementsCoverageUpdater;
	}

	private void finishWithError(VerificationResult result, String message, EObject target) {
		AssureUtilExtension.setToError(result, message, target);
		finish(result);
	}

	private void finish(VerificationResult result) {
		saveAssureResult(result);
		updateProgress(result);
	}

	private static int size(Iterable<?> values) {
		if (values instanceof Collection<?> collection) {
			return collection.size();
		}
		var size = 0;
		for (var ignored : values) {
			size++;
		}
		return size;
	}

	@SuppressWarnings("unchecked")
	private static <T extends Throwable> RuntimeException sneakyThrow(Throwable throwable) throws T {
		throw (T) throwable;
	}
}
