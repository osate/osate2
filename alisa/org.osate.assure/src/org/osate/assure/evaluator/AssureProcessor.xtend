/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */

package org.osate.assure.evaluator

import com.google.inject.ImplementedBy
import it.xsemantics.runtime.RuleEnvironment
import it.xsemantics.runtime.RuleFailedException
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.junit.runner.JUnitCore
import org.osate.aadl2.Aadl2Factory
import org.osate.aadl2.BooleanLiteral
import org.osate.aadl2.NamedElement
import org.osate.aadl2.NumberValue
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.PropertyValue
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.InstanceReferenceValue
import org.osate.aadl2.properties.PropertyNotPresentException
import org.osate.alisa.common.common.CommonFactory
import org.osate.alisa.common.typing.CommonInterpreter
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.AssureResult
import org.osate.assure.assure.ClaimResult
import org.osate.assure.assure.ElseResult
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.PredicateResult
import org.osate.assure.assure.SubsystemResult
import org.osate.assure.assure.ThenResult
import org.osate.assure.assure.ValidationResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.VerificationResult
import org.osate.assure.util.AssureUtilExtension
import org.osate.assure.util.ExecuteResoluteUtil
import org.osate.categories.categories.CategoryFilter
import org.osate.pluginsupport.ExecuteJavaUtil
import org.osate.pluginsupport.ExecutePythonUtil
import org.osate.reqspec.reqSpec.ValuePredicate
import org.osate.result.AnalysisResult
import org.osate.result.BooleanValue
import org.osate.result.Diagnostic
import org.osate.result.DiagnosticType
import org.osate.result.IntegerValue
import org.osate.result.RealValue
import org.osate.result.Result
import org.osate.result.ResultFactory
import org.osate.result.ResultType
import org.osate.result.StringValue
import org.osate.verify.util.VerificationMethodDispatchers
import org.osate.verify.util.VerifyJavaUtil
import org.osate.verify.verify.AgreeMethod
import org.osate.verify.verify.FormalParameter
import org.osate.verify.verify.JUnit4Method
import org.osate.verify.verify.JavaMethod
import org.osate.verify.verify.ManualMethod
import org.osate.verify.verify.PluginMethod
import org.osate.verify.verify.PythonMethod
import org.osate.verify.verify.ResoluteMethod
import org.osate.verify.verify.VerificationMethod
import org.osate.xtext.aadl2.properties.util.PropertyUtils

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import static extension org.osate.assure.util.AssureUtilExtension.*
import static extension org.osate.result.util.ResultUtil.*
import static extension org.osate.verify.util.VerifyUtilExtension.*

@ImplementedBy(AssureProcessor)
interface IAssureProcessor {
	def void processCase(AssuranceCaseResult assureResult, CategoryFilter filter, IProgressMonitor monitor,
		boolean save);

	def void setProgressUpdater((URI)=>void progressUpdater)

	def void setRequirementsCoverageUpdater(=>void requirementsCoverageUpdater)
}

/**
 * performs the processing of verification activities
 * records the result propagating up the counts
 * Will process only those that are TBD
 * It assumes the counts are ok
 */
class AssureProcessor implements IAssureProcessor {

	var CommonInterpreter interpreter = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(
		URI.createFileURI("dummy.___common___")).get(CommonInterpreter)

	var IProgressMonitor progressmonitor = new NullProgressMonitor

	@Accessors(PUBLIC_SETTER)
	(URI)=>void progressUpdater
	@Accessors(PUBLIC_SETTER)
	=>void requirementsCoverageUpdater

	val RuleEnvironment env = new RuleEnvironment
	val computes = new HashMap<String, PropertyExpression>
	val vals = new HashMap<String, Object>

	var long start = 0

	var CategoryFilter filter;
	var boolean save = true

	var private static boolean RESOLUTE_INSTALLED;

	new() {
		env.add('vals', vals)
		env.add('computes', computes)
		try {
			val isresolute = ExecuteResoluteUtil.eInstance.tryLoad();
			if (isresolute){
				RESOLUTE_INSTALLED = true;
			} else {
				RESOLUTE_INSTALLED = false;
			}
		} catch (NoClassDefFoundError e) {
			RESOLUTE_INSTALLED = false;
		}
	}

	def void startSubTask(VerificationActivityResult vaResult) {
		progressmonitor.subTask(vaResult.target.name)
		start = System.currentTimeMillis();
	}

	def void doneSubTask(VerificationActivityResult vaResult) {
		progressmonitor.worked(1)
		val stop = System.currentTimeMillis();
		vaResult.metrics.executionTime = (stop - start)
	}

	override processCase(AssuranceCaseResult assureResult, CategoryFilter filter, IProgressMonitor monitor,
		boolean save) {
		progressmonitor = monitor
		this.filter = filter;
		this.save = save;
		val count = AssureUtilExtension.numberVerificationResults(assureResult)
		try {
			progressmonitor.beginTask(assureResult.name, count)
			assureResult.process
		} finally {
			saveAssureResult(assureResult)
			progressmonitor.done
		}

		updateRequirementsCoverage();
	}

	def void saveAssureResult(AssureResult assureResult) {
		if (save && assureResult.eResource !== null) {
			assureResult.eResource.save(null)
		}
	}

	def dispatch void process(AssuranceCaseResult caseResult) {
		caseResult.modelResult.forEach[modelResult|modelResult.process]
	}

	def dispatch void process(ModelResult modelResult) {
		modelResult.claimResult.forEach[claimResult|claimResult.process]
		modelResult.subsystemResult.forEach[claimResult|claimResult.process]
		modelResult.subAssuranceCase.forEach[subcaseResult|subcaseResult.process]
	}

	def dispatch void process(SubsystemResult caseResult) {
		caseResult.claimResult.forEach[claimResult|claimResult.process]
		caseResult.subsystemResult.forEach[subcaseResult|subcaseResult.process]
	}

	def dispatch void process(ClaimResult claimResult) {
		if (claimResult.targetReference.requirement.requirement.evaluateRequirementFilter(filter)) {
			vals.clear
			computes.clear
			claimResult.verificationActivityResult.forEach[vaResult|vaResult.process]
			claimResult.predicateResult?.process
			claimResult.subClaimResult.forEach[subclaimResult|subclaimResult.process]
		}
	}

	def dispatch void process(VerificationActivityResult vaResult) {

		if (vaResult.targetReference.verificationActivity.evaluateVerificationActivityFilter(filter) &&
			vaResult.targetReference.verificationActivity.evaluateVerificationMethodFilter(filter)) {
			startSubTask(vaResult)
			if (vaResult.preconditionResult !== null) {
				vaResult.preconditionResult.process
				if (!vaResult.preconditionResult.isSuccess) {
					doneSubTask(vaResult)
					return
				}
			}
			runVerificationMethod(vaResult)
			if (vaResult.validationResult !== null) {
				vaResult.validationResult.process
			}
			doneSubTask(vaResult)
		}
	}

	def dispatch void process(ElseResult vaResult) {
		vaResult.first.forEach[expr|expr.process]
		if (vaResult.first.hasError) {
			vaResult.recordElse(ResultType.ERROR)
			vaResult.error.forEach[expr|expr.process]
		} else if (vaResult.first.isFailed) {
			vaResult.recordElse(ResultType.FAILURE)
			vaResult.fail.forEach[expr|expr.process]
		} else {
			vaResult.recordNoElse
		}
	}

	def dispatch void process(ThenResult vaResult) {
		vaResult.first.forEach[expr|expr.process]
		if (vaResult.first.isSuccess) {
			vaResult.recordNoSkip
			vaResult.second.forEach[expr|expr.process]
		} else {
			vaResult.recordSkip
		}
	}

	def dispatch void process(ValidationResult validationResult) {
		runVerificationMethod(validationResult)
	}

	def dispatch void process(PreconditionResult preconditionResult) {
		runVerificationMethod(preconditionResult)
	}

	def dispatch void process(PredicateResult predicateResult) {
		// runVerificationMethod will set up the Environment for the predicate evaluation 
		runVerificationMethod(predicateResult)
	}

	/**
	 * who needs to understand the method types?
	 * the runVerificationMethod dispatcher may do different catch methods
	 * The dispatchVerificationMethod may know from its label what type it is.
	 * The methods are expected to return boolean for predicate, 
	 * null or bool for analysis with results in marker/diagnostic, or the result report object
	 */
	def void runVerificationMethod(VerificationResult verificationResult) {
		if (progressmonitor.isCanceled)
			throw new OperationCanceledException

		var method = verificationResult.method;
		// the next outer assurance case object that refers to a system implementation. 
		var instanceroot = verificationResult.getAssuranceCaseInstanceModel(save)
		if (instanceroot === null) {
			setToError(verificationResult, "Could not find instance model", null)
			saveAssureResult(verificationResult)
			updateProgress(verificationResult)
			return
		}
		var ComponentInstance targetComponent = instanceroot
		targetComponent = findTargetSystemComponentInstance(instanceroot, verificationResult.enclosingSubsystemResult)
		if (targetComponent === null) {
			setToError(verificationResult, "Unresolved target system for claim", null)
			saveAssureResult(verificationResult)
			updateProgress(verificationResult)
			return
		}
		// target element is the element referred to by the requirement. This may be empty
		val targetElement = verificationResult.caseTargetModelElement
		var InstanceObject target = targetComponent
		if (targetElement !== null && targetElement.name !== null) {
				target = targetComponent.findElementInstance(targetElement)
				if (target === null) { target =  targetComponent }
			}
		env.add("component", targetComponent)
		env.add("element", target)

		if (verificationResult instanceof PredicateResult) {
			evaluatePredicate(verificationResult)
			saveAssureResult(verificationResult)
			updateProgress(verificationResult)
			return
		}

		// parameters are those specified as part of the method call in the verification activity
		var Iterable<? extends EObject> parameters
		if (verificationResult instanceof VerificationActivityResult) {
			parameters = verificationResult.target.actuals
		} else if (verificationResult instanceof ValidationResult) {
			parameters = method.validation.parameters
			method = method.validation.method
		} else if (verificationResult instanceof PreconditionResult) {
			parameters = method.precondition.parameters
			method = method.precondition.method
		}

		// the actual parameters can be fewer than the formal parameters. i.e., the last few may be optional
		if (parameters.size < method.formals.size) {
			setToError(verificationResult, "Fewer actual parameters than formal parameters for verification activity",
				null)
			saveAssureResult(verificationResult)
			updateProgress(verificationResult)
			return
		}
		val nbParams = method.formals.size
		var i = 0
		// parameterObjects is the list of objects actually passed to the call.
		// This means actual parameter values that are references to "val" are resolved to the value object
		// In this context we also convert from StringLiteral to String if String is expected.
		// Same for RealLiteral, IntegerLiteral, and BooleanLiteral.
		var List<PropertyExpression> parameterObjects = new ArrayList(parameters.size)

		for (p : parameters) {
			var PropertyExpression exp
			// first handle references to formal parameters, as used in precondition and validation calls
			if (p instanceof FormalParameter) {
				val varesult = verificationResult.eContainer as VerificationActivityResult
				val aps = varesult.target.actuals
				val idx = method.formals.indexOf(p)
				if (idx >= 0) {
					exp = aps.get(idx)
				} else {
					setToError(verificationResult,
						"Referenced formal parameter " + p.name + " of method " + method.name +
							" does not have an actual value", null)
					saveAssureResult(verificationResult)
					updateProgress(verificationResult)
					return
				}
			} else if (p instanceof PropertyExpression) {
				exp = p
			} else {
				var formalParam = method.formals.get(i)
				setToError(verificationResult,
					"Actual parameter for " + formalParam.name + " of method " + method.name +
						" does not have an actual value", null)
				saveAssureResult(verificationResult)
				updateProgress(verificationResult)
				return
			}

			val result = interpreter.interpretExpression(env, exp)
			if (result.failed) {
				var formalParam = method.formals.get(i)
				setToError(verificationResult,
					"Could not evaluate expression for " + formalParam.name + " of method " + method.name + ": " +
						result.ruleFailedException, null)
				saveAssureResult(verificationResult)
				updateProgress(verificationResult)
				return
			}
			var actual = result.value

			if (i < nbParams) {
				var formalParam = method.formals.get(i)
				i = i + 1
				if (actual instanceof NumberValue) {
					if (formalParam.unit !== null && actual.unit !== null &&
						!formalParam.unit.name.equals(actual.unit.name)) {
						actual = AssureUtilExtension.convertValueToUnit(actual, formalParam.unit)
					}
				}
				parameterObjects.add(actual)
			}
		}

		try {
			val methodtype = method.methodKind
			switch (methodtype) {
				PluginMethod: {
					// The parameters are objects from the Properties Meta model. It is up to the plugin interface method to convert to Java base types
					val res = VerificationMethodDispatchers.eInstance.
						dispatchVerificationMethod(methodtype, instanceroot, parameterObjects) // returning the marker or diagnostic id as string
					if (res instanceof String) {
						val result = res as String
						if (target instanceof ConnectionInstance) {
							val conns = findConnectionInstances(targetComponent.connectionInstances, target)
							for (conni : conns) {
								addMarkersAsResult(verificationResult, conni, result, method)
							}
						} else {
							addMarkersAsResult(verificationResult, target, result, method)
						}
					} else if (res instanceof AnalysisResult) {
						var foundResult = false
						for (Result r : res.results) {
							if (r.modelElement === target || matchEnclosingComponentInstance(r, target)) {
								foundResult = true
								val issues = r.diagnostics
								if (verificationResult.isError){
								} else if (isResultError(r) ) {
									setToError(verificationResult)
								} else if ( isResultFailure(r)) {
									setToFail(verificationResult)
								} else {
									setToSuccess(verificationResult)
								}
								for (issue : issues) {
									val c = EcoreUtil.copy(issue)
									verificationResult.issues.add(c)
								}
							}
						}
						for (issue : res.diagnostics) {
							val c = EcoreUtil.copy(issue)
							verificationResult.issues.add(c)
						}
						if (! foundResult) {
							// requirement target does not match Result source reference
							// Typically occurs when the analysis is performed on an element, e.g., ETEF, while the requirement 
							// does not include a 'for' <target model element>
							setToError(verificationResult,
								"No Result found for requirement verification target " + target.name, target)
						}
					} else if (res instanceof Result) {
						if (res.modelElement === target) {
							val issues = res.diagnostics
							if (isResultError(res) ) {
								setToError(verificationResult)
							} else if (isResultFailure(res)) {
								setToFail(verificationResult)
							} else {
								setToSuccess(verificationResult)
							}
							for (issue : issues) {
								val c = EcoreUtil.copy(issue)
								verificationResult.issues.add(c)
							}
						} else {
							// requirement target does not match Result source reference
							// Typically occurs when the analysis is performed on an element, e.g., ETEF, while the requirement 
							// does not include a 'for' <target model element>
							setToError(verificationResult,
								"Result is not for requirement verification target " + target.name, target)
						}
					} else {
						setToError(verificationResult,
							"Analysis return type is not a string, Result, or AnalysisResult", targetComponent);
					}
				}
				AgreeMethod: {
					setToError(verificationResult, "Execution of AGREE methods is not supported")
				}
				JUnit4Method: {
					val test = ExecuteJavaUtil.eInstance.getJavaClass(methodtype.classPath);
					val junit = new JUnitCore();
					val result = junit.run(test);
					if (result.failureCount == 0) {
						setToSuccess(verificationResult)
					} else {
						val proveri = ResultFactory.eINSTANCE.createResult
						result.doJUnitResults(proveri)
						setToFail(verificationResult, proveri.diagnostics)
					}
				}
				ManualMethod: {
				}
				default: {
					// The parameters are objects from the Properties Meta model. May need to get converted to Java base types
					executeVerificationMethod(verificationResult, method, targetComponent, target,
						parameterObjects)
				}
			} // end switch on method
		} catch (AssertionError e) {
			setToFail(verificationResult, e);
		} catch (ThreadDeath e) { // don't catch ThreadDeath by accident
			throw e;
		} catch (Throwable e) {
			setToError(verificationResult, e);
		}
		saveAssureResult(verificationResult)
		updateProgress(verificationResult)
	}

	def boolean matchEnclosingComponentInstance(Result r, EObject target) {
		if (r.modelElement instanceof InstanceObject) {
			return (r.modelElement as InstanceObject).componentInstance === target
		}
		return false
	}

	def updateRequirementsCoverage() {
		if (requirementsCoverageUpdater !== null) {
			requirementsCoverageUpdater.apply
		}
	}

	def PropertyExpression toLiteral(Object data, UnitLiteral unit) {
		switch data {
			Boolean: {
				val b = Aadl2Factory.eINSTANCE.createBooleanLiteral
				b.value = data
				b
			}
			Integer: {
				val i = Aadl2Factory.eINSTANCE.createIntegerLiteral
				i.value = data
				if(unit !== null) i.unit = unit
				i
			}
			Double: {
				val r = Aadl2Factory.eINSTANCE.createRealLiteral
				r.value = data
				if(unit !== null) r.unit = unit
				r
			}
			String: {
				val str = Aadl2Factory.eINSTANCE.createStringLiteral
				str.value = data
				str
			}
			BooleanValue: {
				val b = Aadl2Factory.eINSTANCE.createBooleanLiteral
				b.value = data.value
				b
			}
			IntegerValue: {
				val i = Aadl2Factory.eINSTANCE.createIntegerLiteral
				i.value = data.value
				if(unit !== null) i.unit = unit
				i
			}
			RealValue: {
				val r = Aadl2Factory.eINSTANCE.createRealLiteral
				r.value = data.value
				if(unit !== null) r.unit = unit
				r
			}
			StringValue: {
				val str = Aadl2Factory.eINSTANCE.createStringLiteral
				str.value = data.value
				str
			}
			InstanceObject: {
				val objref = CommonFactory.eINSTANCE.createAModelReference
				objref.modelElement = data
				objref
			}
			InstanceReferenceValue: {
				val objref = CommonFactory.eINSTANCE.createAModelReference
				objref.modelElement = data.referencedInstanceObject
				objref
			}
			default:
				data as PropertyExpression
		}
	}

	def updateProgress(VerificationResult result) {
		if (progressUpdater !== null) {
			progressUpdater.apply(result.URI)
		}
	}

	def void evaluatePredicate(PredicateResult predicateResult) {
		val predicate = predicateResult.predicate
		computes.clear
		evaluatePredicate(predicateResult, predicate)
	}

	def void evaluatePredicate(VerificationResult vResult, ValuePredicate predicate) {
		try {
			val result = interpreter.interpretExpression(env, predicate.xpression)
			if (result.failed) {
				setToError(vResult,
					"Could not evaluate value predicate: " + getFailedMsg(result.ruleFailedException), null)
			} else {
				val success = (result.value as BooleanLiteral).getValue
				if (success) {
					setToSuccess(vResult)
				} else {
					setToFail(vResult)
				}
			}
		} catch (AssertionError e) {
			setToFail(vResult, e);
		} catch (ThreadDeath e) { // don't catch ThreadDeath by accident
			throw e;
		} catch (Throwable e) {
			setToError(vResult, e);
		}
	}

	def void evaluateComputePredicate(Result pResult, ValuePredicate predicate) {
		try {
			val result = interpreter.interpretExpression(env, predicate.xpression)
			if (result.failed) {
				setToError(pResult,"Could not evaluate value predicate: " + getFailedMsg(result.ruleFailedException))
			} else {
				val success = (result.value as BooleanLiteral).getValue
				if (success) {
					pResult.resultType = ResultType.SUCCESS
				} else {
					pResult.resultType = ResultType.FAILURE
				}
			}
		} catch (AssertionError e) {
			pResult.resultType = ResultType.FAILURE
			if (pResult.message === null){
				pResult.message = e.message
			} else {
				pResult.diagnostics.add(createErrorDiagnostic(
					e.message, null))
			}
		} catch (ThreadDeath e) { // don't catch ThreadDeath by accident
			throw e;
		} catch (Throwable e) {
			setToError(pResult,e.message)
		}
	}

	def String getFailedMsg(RuleFailedException e) {
		var tmp = e;
		while (tmp.cause !== null) {
			tmp = tmp.cause as RuleFailedException;
		}
		return tmp.message
	}

	// ----------------------------
	// Execution of Verification methods
	// ----------------------------
	/*
	 * lookup targetElement and handle connection instances
	 * check on properties
	 * Then call on ExecuteMethodOnce, which handles Java and Resolute
	 */
	def void executeVerificationMethod(VerificationResult verificationResult, VerificationMethod method,
		ComponentInstance targetComponent, InstanceObject target, List<PropertyExpression> parameters) {
		if (target instanceof ConnectionInstance) {
			val conns = findConnectionInstances(targetComponent.connectionInstances, target)
			for (conni : conns) {
				if (checkPropertyValues(verificationResult, conni)) {
					verificationResult.executeMethodOnce(method, targetComponent, conni, parameters)
				}
			}
			// fix verification activity result state
			if (verificationResult.results.hasResultErrors) {
				setToError(verificationResult)
			} else if (verificationResult.results.hasResultFailures) {
				setToFail(verificationResult)
			}
		} else if (target !== null) {
			if (checkPropertyValues(verificationResult, target)) {
				verificationResult.executeMethodOnce(method, targetComponent, target, parameters)
			}
		} else {
			setToError(verificationResult, "Could not find target element instance " + target.name,
				targetComponent)
		}
	}

	def void executeMethodOnce(VerificationResult verificationResult, VerificationMethod method,
		ComponentInstance targetComponent, InstanceObject target, List<PropertyExpression> parameters) {
		val methodtype = method.methodKind
		switch (methodtype) {
			JavaMethod: {
				executeJavaMethodOnce(verificationResult, method, target, parameters);
			}
			ResoluteMethod: {
				executeResoluteMethodOnce(verificationResult, method, targetComponent, target, parameters);
			}
			PythonMethod: {
				executePythonOnce(verificationResult, method, target, parameters);
			}
		}
	}
	
	def void executePythonOnce(VerificationResult verificationResult, VerificationMethod method,
	InstanceObject target, List<PropertyExpression> parameters) {
		val engine = new ExecutePythonUtil
		val methodtype = method.methodKind as PythonMethod
		val scriptURL = "platform:/resource/"+ methodtype.methodPath; //"platform:/plugin/org.osate.assure/modelstatistics2.py";
		val objects = VerifyJavaUtil.getActualJavaObjects(method.formals, target, parameters)
		var returned = engine.runPythonScript(scriptURL,objects);
		if (returned instanceof Result){
			if (returned.isResultError){
				objects.remove(0)
				returned = engine.runPythonScript(scriptURL,objects);
			}
		}
		processExecutionResult(verificationResult, method, target, returned)
	}
	

	def void executeResoluteMethodOnce(VerificationResult verificationResult, VerificationMethod method,
		ComponentInstance targetComponent, InstanceObject target, List<PropertyExpression> parameters) {
		if (RESOLUTE_INSTALLED) {
			val methodtype = method.methodKind as ResoluteMethod
			val fundef = methodtype.methodReference
			val returned = ExecuteResoluteUtil.eInstance.executeResoluteFunctionOnce(fundef, targetComponent, target,
				parameters)
			processExecutionResult(verificationResult, method, target, returned)
		} else {
			setToError(verificationResult, "Resolute not installed")
		}
	}

	def void executeJavaMethodOnce(VerificationResult verificationResult, VerificationMethod method,
		InstanceObject target, List<PropertyExpression> parameters) {
		val methodtype = method.methodKind as JavaMethod
		val newClasses = VerifyJavaUtil.getParameterClasses(methodtype)
		val objects = VerifyJavaUtil.getActualJavaObjects(methodtype, target, parameters)
		var returned = ExecuteJavaUtil.eInstance.invokeJavaMethod(methodtype.methodPath, newClasses, objects)
		if (returned === null || returned instanceof Exception){
			// try without first parameter if targetType not specified
			if (method.targetType === null){
				newClasses.remove(0);
				objects.remove(0);
				returned = ExecuteJavaUtil.eInstance.invokeJavaMethod(methodtype.methodPath, newClasses, objects)
			}
		}
		processExecutionResult(verificationResult, method, target, returned)
	}

	/*
	 * process execution results
	 * We interpret boolean, Diagnostic, Result, AnalysisResult. We also interpret any returned object other than the previous as compute variable 
	 */
	def void processExecutionResult(VerificationResult verificationResult, VerificationMethod method,
		InstanceObject target, Object returned) {
		if (returned !== null) {
			if (returned instanceof Boolean && method.results.empty) {
				if (returned != true) {
					setToFail(verificationResult);
				} else {
					setToSuccess(verificationResult)
				}
			} else if (returned instanceof Result) {
				verificationResult.results.add(returned)
				if (verificationResult instanceof VerificationActivityResult) {
					evaluateComputePredicate(verificationResult, method, target, returned)
				}
				if (verificationResult.isError){
					// no need to do anything 
				} else if (isResultError(returned) ) {
					setToError(verificationResult)
				} else if (isResultFailure(returned)) {
					setToFail(verificationResult)
				} else {
					setToSuccess(verificationResult)
				}
			} else if (returned instanceof Diagnostic) {
				if (returned.diagnosticType == DiagnosticType.ERROR) {
					setToFail(verificationResult)
				} else {
					setToSuccess(verificationResult)
				}
				verificationResult.issues.add(returned)
			} else if (returned instanceof AnalysisResult) {
				if (returned.isAnalysisResultError){
					setToError(verificationResult)
				} else {
					if (verificationResult instanceof VerificationActivityResult) {
						for (Result r : returned.results) {
							evaluateComputePredicate(verificationResult, method, target, r)
						}	
					}
					if (verificationResult.isError){
						// no need to do anything 
					} else if (hasResultErrors(returned) ) {
						setToError(verificationResult)
					} else if ( hasResultFailures(returned)) {
						setToFail(verificationResult)
					} else {
						setToSuccess(verificationResult)
					}
				}
				// record a reference to the AnalysisResult
				verificationResult.analysisresult = returned
			} else if (returned instanceof Exception){
				setToError(verificationResult, "Verification method execution exception: "+returned.message,
					target);
				
			} else if (method.results.size == 1) {
				// set compute variable value from the returned value
				if (verificationResult instanceof VerificationActivityResult) {
					val predicate = verificationResult.claimResult.target.predicate
					if (predicate instanceof ValuePredicate) {
						if (containsComputeVariables(predicate)) {
							val computevars = verificationResult.targetReference.verificationActivity.computes
							if (computevars.size == 1) {
								val computeRef = computevars.head
								val tunit = method.results.head?.unit
								val rval = toLiteral(returned, tunit)
								// reset computes variables for interpreter
								computes.clear
								computes.put(computeRef.compute.name, rval)
								evaluatePredicate(verificationResult, predicate)
							} else {
								setToError(verificationResult,
									"One value returned but " + computevars.size + " compute variable assignments")
							}
							return
						} else {
							setToError(verificationResult, "Non-boolean single return value and predicate without compute variable",
							target);
						}
					}
					setToError(verificationResult, "Single return value expected to be boolean value",
					target);
				} else {
					setToError(verificationResult, "Precondition or Validation expect boolean as single return value",
					target);
				}
			} else {
				setToError(verificationResult, "Single non-boolean return value but no expected compute variable for predicate",
					target);
			}
		} else {
			// 
			setToError(verificationResult, "Java method does not include class",
					target);
		}

	}

	/*
	 * evaluate value predicate with compute variable results bound. Result is recorded in returned
	 */
	def void evaluateComputePredicate(VerificationActivityResult verificationResult, VerificationMethod method, InstanceObject target,
		Result returned) {
		val predicate = verificationResult.claimResult.target.predicate
		if(!returned.resultSuccess || verificationResult.isError || predicate === null || !(predicate instanceof ValuePredicate)) return;
		val valuePredicate = predicate as ValuePredicate
		if (!containsComputeVariables(valuePredicate)) {
			return
		}
		val computevars = verificationResult.targetReference.verificationActivity.computes
		if (computevars.isEmpty) {
			setToError(returned, 'No return values assigned to compute variables')
			return
		}
		// reset computes for each predicate evaluation
		env.decrement("element")
		env.add("element", target)
		computes.clear
		val formalIter = method.results.iterator
		val valsIter = returned.values.iterator
		if (computevars.size <= returned.values.size && computevars.size <= method.results.size) {
			computevars.forEach [ computeRef |
				val value = valsIter.next
				val formalReturn = formalIter.next
				val tunit = formalReturn?.unit
				computes.put(computeRef.compute.name, toLiteral(value, tunit))
			]
			evaluateComputePredicate(returned, valuePredicate)
		} else {
			setToError(returned, 'Fewer values returned than expected as compute variables')
		}
	}

	/*
	 * check property values in method specification
	 */
	def boolean checkPropertyValues(VerificationResult verificationResult, InstanceObject target) {
		if (verificationResult instanceof VerificationActivityResult) {
			val method = verificationResult.method
			val properties = method.properties
			val exps = verificationResult.target.propertyValues

			val propIter = properties.iterator
			val expIter = exps.iterator
			var success = true;

			while (propIter.hasNext && expIter.hasNext) {
				val property = propIter.next
				val exp = expIter.next

				try {
					val expResult = interpreter.interpretExpression(env, exp)
					if (expResult.failed) {
						setToError(verificationResult, "Could not evaluate expression for " + property.name + ": " +
							expResult.ruleFailedException, null)
						success = false
					} else {
						var PropertyValue modelPropValue = null
						val propertyIsSet = try {
								val modelExp = target.getSimplePropertyValue(property)
								modelPropValue = if(modelExp instanceof PropertyValue) modelExp else null
								true
							} catch (PropertyNotPresentException e) {
								false
							}
						val value = expResult.value
						if (propertyIsSet) {
							if (value instanceof NumberValue) {
								val unit = value.unit
								val reqValue = value.getScaledValue(unit)
								val modelValue = PropertyUtils.getScaledNumberValue(target, property, unit)

								if (reqValue != modelValue) {
									verificationResult.addErrorIssue(target,
										"Property " + property.getQualifiedName() + ": Value in model (" +
											modelValue + unit.name + ") does not match required value (" +
											reqValue + unit.name + ")")
									verificationResult.setToFail
								}
							} else {
								if (value != modelPropValue) {
									verificationResult.addErrorIssue(target,
										"Property " + property.getQualifiedName() + ": Value in model (" +
											modelPropValue + ") does not match required value (" + value + ")")
									verificationResult.setToFail
								}
							}
						} else {
							// set property
							val pa = target.createOwnedPropertyAssociation
							pa.property = property
							val mpv = pa.createOwnedValue
							mpv.setOwnedValue(EcoreUtil.copy(value))
						}
					}
				} catch (Exception e) {
					verificationResult.setToError("Could not process property " + property.name)
				}
			}
			return success
		} else {
			return true
		}
	}
}
