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
import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter
import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr
import com.rockwellcollins.atc.resolute.resolute.NestedDotID
import com.rockwellcollins.atc.resolute.resolute.ProveStatement
import com.rockwellcollins.atc.resolute.resolute.ResoluteFactory
import com.rockwellcollins.atc.resolute.resolute.ThisExpr
import java.util.ArrayList
import java.util.List
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.osate.aadl2.BooleanLiteral
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.NumberValue
import org.osate.aadl2.RealLiteral
import org.osate.aadl2.StringLiteral
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.SystemInstance
import org.osate.alisa.common.common.APropertyReference
import org.osate.alisa.common.common.AVariableReference
import org.osate.alisa.common.common.CommonFactory
import org.osate.alisa.common.common.ValDeclaration
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.ElseResult
import org.osate.assure.assure.ElseType
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.SubsystemResult
import org.osate.assure.assure.ThenResult
import org.osate.assure.assure.ValidationResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.VerificationExecutionState
import org.osate.assure.assure.VerificationResult
import org.osate.assure.util.AssureUtilExtension
import org.osate.results.results.ResultReport
import org.osate.verify.util.VerificationMethodDispatchers
import org.osate.verify.verify.AgreeMethod
import org.osate.verify.verify.FormalParameter
import org.osate.verify.verify.JavaMethod
import org.osate.verify.verify.ManualMethod
import org.osate.verify.verify.PluginMethod
import org.osate.verify.verify.ResoluteMethod
import org.osate.xtext.aadl2.properties.util.PropertyUtils

import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import static extension org.osate.assure.util.AssureUtilExtension.*
import org.osate.aadl2.PropertyConstant
import org.junit.runner.JUnitCore
import org.junit.runner.Result
import org.osate.verify.verify.JUnit4Method
import org.osate.aadl2.PropertyExpression
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.swt.widgets.Display
import org.eclipse.core.runtime.OperationCanceledException
import org.osate.categories.categories.CategoryFilter

@ImplementedBy(AssureProcessor)
interface IAssureProcessor {
	def void processCase(AssuranceCaseResult assureResult, CategoryFilter filter, IProgressMonitor monitor);
	def void setProgressTreeViewer (TreeViewer viewPage);
}

/**
 * performs the processing of verification activities
 * records the result propagating up the counts
 * Will process only those that are TBD
 * It assumes the counts are ok
 */
class AssureProcessor implements IAssureProcessor {

	var IProgressMonitor progressmonitor
	
	var TreeViewer progressTreeViewer

	var long start = 0

	def void startSubTask(VerificationActivityResult vaResult) {
		progressmonitor.subTask(vaResult.target.name) // + " on " + vaResult.claimSubject.name)
		start = System.currentTimeMillis();
	}

	def void doneSubTask(VerificationActivityResult vaResult) {
		progressmonitor.worked(1)
		val stop = System.currentTimeMillis();
		vaResult.metrics.executionTime = (stop - start)

//		val instanceroot = vaResult.assuranceCaseInstanceModel
//		val targetComponent = findTargetSystemComponentInstance(instanceroot, vaResult.enclosingSubsystemResult)
		val targetPath = vaResult.buildCaseModelElementPath
		System.out.println(
			"Evaluation time: " + (stop - start) / 1000.0 + "s :" + vaResult.target.name + " on " + targetPath);
	}

	override processCase(AssuranceCaseResult assureResult, CategoryFilter filter, IProgressMonitor monitor) {
		progressmonitor = monitor
		val count = AssureUtilExtension.numberVerificationResults(assureResult)
		try {
			progressmonitor.beginTask(assureResult.name, count)
			assureResult.process
		}finally{
			progressmonitor.done
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

	def dispatch void process(org.osate.assure.assure.ClaimResult claimResult) {
		claimResult.verificationActivityResult.forEach[vaResult|vaResult.process]
		claimResult.subClaimResult.forEach[subclaimResult|subclaimResult.process]
	}

	def dispatch void process(VerificationActivityResult vaResult) {
		startSubTask(vaResult)
		if (vaResult.executionState != VerificationExecutionState.TODO) {
			doneSubTask(vaResult)
			return;
		}
		if (vaResult.preconditionResult != null) {
			vaResult.preconditionResult.process
			if (!vaResult.preconditionResult.isSuccess) {
				doneSubTask(vaResult)
				return
			}
		}
		runVerificationMethod(vaResult)
		if (vaResult.validationResult != null) {
			vaResult.validationResult.process
		}
		doneSubTask(vaResult)
	}

	def dispatch void process(ElseResult vaResult) {
		vaResult.first.forEach[expr|expr.process]
		if (vaResult.first.hasError) {
			vaResult.recordElse(ElseType.ERROR)
			vaResult.error.forEach[expr|expr.process]
		} else if (vaResult.first.isFailed) {
			vaResult.recordElse(ElseType.FAIL)
			vaResult.fail.forEach[expr|expr.process]
		} else if (vaResult.first.isTimeout) {
			vaResult.recordElse(ElseType.TIMEOUT)
			vaResult.timeout.forEach[expr|expr.process]
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

	/**
	 * who needs to understand the method types?
	 * the runVerificationMethod dispatcher may do different catch methods
	 * The dispatchVerificationMethod may know from its label what type it is.
	 * The methods are expected to return boolean for predicate, 
	 * null or bool for analysis with results in marker/diagnostic, or the result report object
	 */
	def void runVerificationMethod(VerificationResult verificationResult) {
		if( progressmonitor.isCanceled )
			throw new OperationCanceledException
			
		val method = verificationResult.method;
		// target element is the element referred to by the requirement. This may be empty
		val targetElement = verificationResult.caseTargetModelElement
		// the next outer assurance case object that refers to a system implementation. 
		var instanceroot = verificationResult.assuranceCaseInstanceModel
		if (instanceroot == null) {
			setToError(verificationResult, "Could not find instance model", null)
			return
		}
		var ComponentInstance targetComponent = instanceroot
		targetComponent = findTargetSystemComponentInstance(instanceroot, verificationResult.enclosingSubsystemResult)
		if (targetComponent == null) {
			setToError(verificationResult, "Unresolved target system for claim", null)
			return
		}
		var InstanceObject target = targetComponent
		if (targetElement != null) {
			if (targetElement.eIsProxy) {
				setToError(verificationResult, "Unresolved target element for claim", targetComponent)
				return
			}
			val x = targetComponent.findElementInstance(targetElement)
			target = x ?: targetComponent
		}
		//actualParameters are those specified as part of the method call in the verification activity
		var Iterable actualParameters
		if (verificationResult instanceof VerificationActivityResult) {
			actualParameters = verificationResult.target.parameters
		} else if (verificationResult instanceof ValidationResult) {
			actualParameters = method.validation.parameters
		} else if (verificationResult instanceof PreconditionResult) {
			actualParameters = method.precondition.parameters
		}

		// the actual parameters can be fewer than the formal parameters. i.e., the last few may be optional
		if (actualParameters.size < method.params.size) {
			setToError(verificationResult, "Fewer actual parameters than formal parameters for verification activity",
				null)
			return
		}
		val nbParams = method.params.size
		var i = 0
		// actualParameterObjects is the list of objects actually passed to the call.
		// This means actual parameter values that are references to "val" are resolved to the value object
		// In this context we also convert from StringLiteral to String if String is expected.
		// Same for RealLiteral, IntegerLiteral, and BooleanLiteral.
		var List<PropertyExpression> actualParameterObjects = new ArrayList(actualParameters.size)

		for (ap : actualParameters) {
			var PropertyExpression actual 
			// first handle references to formal parameters, as used in precondition and validation calls
			if (ap instanceof FormalParameter) {
				val varesult = verificationResult.eContainer as VerificationActivityResult
				val aps = varesult.target.parameters
				val idx = method.params.indexOf(ap)
				if (idx >= 0) {
					actual = aps.get(idx).valueCopy
				} else {
					setToError(verificationResult,
						"Referenced formal parameter " + ap.name + " of method " + method.name +
							" does not have an actual value", null)
					return
				}
			} else if (ap instanceof PropertyExpression){
				actual = ap.valueCopy
			} else {
				var formalParam = method.params.get(i)
				setToError(verificationResult,
					"Actual parameter for " + formalParam.name + " of method " + method.name +
						" does not have an actual value", null)
				return
			}

			if (i < nbParams) {
				var formalParam = method.params.get(i)
				if (actual instanceof NumberValue) {
					if (formalParam.unit != null && actual.unit != null &&
						!formalParam.unit.name.equals(actual.unit.name)) {
						actual = convertValueToUnit(actual, formalParam.unit)
					}
				}
				
				val paramType = formalParam.parameterType
				if (actual == null){
					return
				}
				var typeName = actual.getClass.name
				val idx = typeName.lastIndexOf('.')
				if (idx >=0) typeName = typeName.substring(idx+1)
				if (typeName.endsWith("Impl")) typeName = typeName.substring(0,typeName.length-4)
				if (typeName != null && paramType != null && 
					! (typeName.equalsIgnoreCase(paramType)
						|| typeName.equalsIgnoreCase("RealLiteral") && paramType.equalsIgnoreCase("real")
						|| typeName.equalsIgnoreCase("IntegerLiteral") && paramType.equalsIgnoreCase("int")
						|| typeName.equalsIgnoreCase("StringLiteral") && paramType.equalsIgnoreCase("string")
						|| typeName.equalsIgnoreCase("BooleanLiteral") && paramType.equalsIgnoreCase("bool")
					)
				) {
					setToError(verificationResult,
						"Parameter " + formalParam.name + ": mismatched types " + paramType + " and actual " +
							typeName, null)
					return
				}
			actualParameterObjects.add(actual)
			i = i + 1
			}
		}
		if (verificationResult instanceof VerificationActivityResult) {
			checkProperties(target, verificationResult)
		}

		try {
			val methodtype = method.methodKind
			switch (methodtype) {
				JavaMethod: {
					// The parameters are objects from the Properties Meta model. May need to get converted to Java base types
					executeJavaMethod(verificationResult, methodtype, target, actualParameterObjects)
					verificationResult.eResource.save(null)
					updateProgress(verificationResult)
				}
				PluginMethod: {
					// The parameters are objects from the Properties Meta model. It is up to the plugin interface method to convert to Java base types
					val res = VerificationMethodDispatchers.eInstance.
						dispatchVerificationMethod(methodtype, instanceroot, actualParameterObjects) // returning the marker or diagnostic id as string
					if (res instanceof String) {
						addMarkersAsResult(verificationResult, target, res, method)
					} else {
						setToError(verificationResult, "Analysis return type is not a string of MarkerType", target);
					}
					verificationResult.eResource.save(null)
					updateProgress(verificationResult)
				}
				ResoluteMethod: {
					// The parameters are objects from the Properties Meta model. Resolute likes them this way
					AssureUtilExtension.initializeResoluteContext(instanceroot);
					val EvaluationContext context = new EvaluationContext(instanceroot, sets, featToConnsMap);
					val ResoluteInterpreter interpreter = new ResoluteInterpreter(context);
					val provecall = createWrapperProveCall(methodtype, targetComponent, actualParameterObjects)
					if (provecall == null) {
						setToError(verificationResult,
							"Could not find Resolute Function " + verificationResult.method.name)
					} else {

						// using com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
						val ClaimResult proof = interpreter.evaluateProveStatement(provecall) as ClaimResult
						if (proof.valid) {
							setToSuccess(verificationResult)
						} else {
							val proveri = CommonFactory.eINSTANCE.createResultIssue
							proof.doResoluteResults(proveri)
							setToFail(verificationResult, proveri.issues)
						}
					}
					if(verificationResult == null){
						System.out.println("verificationResult 4444444eod    ");
					}
					if(verificationResult.eResource == null){
						System.out.println("verificationResult eResource 4444444eod    ");
					}
					try{
						verificationResult.eResource.save(null)
					}catch (NullPointerException ee) {
						System.out.println("Null Resource in saving");
					}
					updateProgress(verificationResult)
				}
				AgreeMethod: {
					AssureUtilExtension.initializeResoluteContext(instanceroot);
					
					val agreemethod = methodtype as AgreeMethod
					
					if (agreemethod.isAll) { // is recursive
						//System.out.println("AgreeMethodAgreeMethodAgreeMethod executeURI ALL   ");
					
					} else if (agreemethod.singleLayer) {
						System.out.println("AgreeMethodAgreeMethodAgreeMethod executeSystemInstance SINGLE   ");
						val AgreeVerifySingleHandler verHandler = new AgreeVerifySingleHandler (verificationResult);
						
						//verHandler.executeSystemInstance(instanceroot, progressTreeViewer);
						
						//Currently Agree does not work on Flows or Connections so this is valid
						verHandler.executeSystemInstance(target as ComponentInstance, progressTreeViewer);
					}
					
					//Should not save here because it is job based
					//verificationResult.eResource.save(null)
				}
//					case SupportedTypes.RESOLUTEPREDICATE: {
//					AssureUtilExtension.initializeResoluteContext(instance);
//						val EvaluationContext context = new EvaluationContext(instance, sets, featToConnsMap);
//						val ResoluteEvaluator evaluator = new ResoluteEvaluator(context, null);
//						val fncall = createWrapperFnCall(verificationResult,parameters)
//						if (fncall == null) {
//							setToError(verificationResult,
//								"Could not find Resolute Function " + verificationResult.method.name)
//						} else {
//							try {
//								val ResoluteValue resultvalue = evaluator.caseFnCallExpr(fncall)
//								if (resultvalue instanceof BoolValue) {
//									if (resultvalue.getBool) {
//										setToSuccess(verificationResult)
//									} else {
//										setToFail(verificationResult, "Resolute predicate evaluated to false")
//									}
//								} else {
//									setToError(verificationResult, "Expected boolean result. Found " + resultvalue.type)
//								}
//							} catch (Throwable t) {
//								setToError(verificationResult,
//									"Verification activity did not complete. Exception: " + t.message)
//							}
//						}
//					}
				JUnit4Method: {
					val test = VerificationMethodDispatchers.eInstance.findClass(methodtype.classPath); 
					val junit = new JUnitCore(); 
					val result = junit.run(test);
						if (result.failureCount == 0) {
							setToSuccess(verificationResult)
						} else {
							val proveri = CommonFactory.eINSTANCE.createResultIssue
							result.doJUnitResults(proveri)
							setToFail(verificationResult, proveri.issues)
						}
					verificationResult.eResource.save(null)
					updateProgress(verificationResult)
				}
				ManualMethod: {
					verificationResult.eResource.save(null)
					updateProgress(verificationResult)
				}
			} // end switch on method
		} catch (AssertionError e) {
			setToFail(verificationResult, e);
			verificationResult.eResource.save(null)
			updateProgress(verificationResult)
		} catch (ThreadDeath e) { // don't catch ThreadDeath by accident
			throw e;
		} catch (Throwable e) {
			setToError(verificationResult, e);
			//e.printStackTrace;
			try{
				verificationResult.eResource.save(null)
			}catch (NullPointerException ee) {
				System.out.println("Null Resource in saving");
			}
			updateProgress(verificationResult)
		}
		//verificationResult.eResource.save(null)
		
		
	}
	
	def updateProgress(VerificationResult result) {
		if(progressTreeViewer != null){
			Display.getDefault().asyncExec(new Runnable() {
			override void run() {
				progressTreeViewer.update(result, null)
			}
		});
		}
	}

	def executeJavaMethod(VerificationResult verificationResult, JavaMethod methodtype, InstanceObject target,
		List<PropertyExpression> parameters) {
		val res = VerificationMethodDispatchers.eInstance.workspaceInvoke(methodtype, target, parameters)
		if (res != null) {
			if (res instanceof Boolean) {
				if (res != true) {
					setToFail(verificationResult, "", target);
				} else {
					setToSuccess(verificationResult)
				}
			} else if (res instanceof String) {
				setToSuccess(verificationResult, res, target)
			} else if (res instanceof ResultReport) {
				verificationResult.resultReport = res
			} else {
				setToError(verificationResult, "No result report from analysis", target);
			}
		}

	}

	def ProveStatement createWrapperProveCall(ResoluteMethod rm, ComponentInstance ci, List<PropertyExpression> params) {
		val found = rm.methodReference
		val factory = ResoluteFactory.eINSTANCE
		if(found == null) return null
		val call = factory.createFnCallExpr
		call.fn = found
		call.args.add(createComponentinstanceReference(ci))
		addParams(call, params)
		val prove = factory.createProveStatement
		prove.expr = call
		prove
	}

	def ThisExpr createComponentinstanceReference(ComponentInstance ci) {
		val factory = ResoluteFactory.eINSTANCE
		var NestedDotID nid = null
		var nci = ci
		while (!(nci instanceof SystemInstance)) {
			val x = factory.createNestedDotID
			x.base = nci.subcomponent
			x.sub = nid
			nid = x
			nci = nci.eContainer as ComponentInstance
		}
		val te = factory.createThisExpr
		te.sub = nid
		te
	}

	def addParams(FnCallExpr call, List<PropertyExpression> params) {
		for (p : params) {
			if (p instanceof RealLiteral) {
				val realval = ResoluteFactory.eINSTANCE.createRealExpr
				realval.^val = p
				call.args.add(realval)
			} else if (p instanceof IntegerLiteral) {
				val intval = ResoluteFactory.eINSTANCE.createIntExpr
				intval.^val = p
				call.args.add(intval)
			} else if (p instanceof StringLiteral) {
				val stringval = ResoluteFactory.eINSTANCE.createStringExpr
				stringval.^val = p
				call.args.add(stringval)
			} else if (p instanceof BooleanLiteral) {
				val stringval = ResoluteFactory.eINSTANCE.createBoolExpr
				stringval.^val = p
				call.args.add(stringval)
			}
		}
	}

	def createWrapperFnCall(ResoluteMethod vr, List<PropertyExpression> params) {
		val found = vr.methodReference
		val factory = ResoluteFactory.eINSTANCE
		val target = factory.createIdExpr
		target.id = vr.caseTargetModelElement
		val call = factory.createFnCallExpr
		call.fn = found
		call.args.add(target)
		addParams(call, params)
		call
	}

	def boolean checkProperties(InstanceObject object, VerificationActivityResult result) {
		val method = result.method
		val properties = method.properties
		val values = result.target.propertyValues

		val iter1 = properties.iterator
		val iter2 = values.iterator
		var success = true;

		while (iter1.hasNext && iter2.hasNext) {
			val property = iter1.next
			val variable = iter2.next

			try {
				val value = variable.value
				if (value instanceof NumberValue) {
					val unit = value.unit
					val reqValue = value.getScaledValue(unit)
					val modelValue = PropertyUtils.getScaledNumberValue(object, property, unit)

					if (reqValue != modelValue) {
						println(
							"Property " + property.getQualifiedName() + ": Value in model (" + modelValue + unit.name +
								") does not match required value (" + reqValue + unit.name + ")")
						result.addErrorIssue(object,
							"Property " + property.getQualifiedName() + ": Value in model (" + modelValue + unit.name +
								") does not match required value (" + reqValue + unit.name + ")")
						result.setToFail
					} else {
						println("   match " + modelValue + " == " + reqValue)
					}
				}
			} catch (Exception e) {
				e.printStackTrace
			}
		}
		return success;
	}
	
	override void setProgressTreeViewer (TreeViewer treeViewer ) {
		progressTreeViewer = treeViewer
	}
	
}

