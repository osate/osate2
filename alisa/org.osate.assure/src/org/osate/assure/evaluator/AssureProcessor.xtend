package org.osate.assure.evaluator

import com.google.inject.Inject

//import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.ElseResult
import org.osate.assure.assure.ThenResult
import org.osate.assure.assure.AssureResult
import com.google.inject.ImplementedBy
import static extension org.osate.assure.util.AssureUtilExtension.*
import org.osate.assure.assure.ValidationResult
import org.osate.assure.assure.AssuranceEvidence
import org.osate.assure.assure.VerificationResult
import org.osate.verify.verify.SupportedTypes
import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter
import org.osate.assure.assure.AssureFactory
import com.rockwellcollins.atc.resolute.resolute.ProveStatement
import com.rockwellcollins.atc.resolute.resolute.ResoluteFactory
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.IEObjectDescription
import java.util.List
import org.eclipse.emf.ecore.EClass
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.aadl2.util.Aadl2Util
import org.eclipse.emf.common.util.URI
import java.util.ArrayList
import org.eclipse.core.resources.IWorkspaceRoot
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IProjectDescription
import org.eclipse.core.runtime.CoreException
import org.osate.alisa.common.scoping.CommonGlobalScopeProvider
import org.osate.results.results.ResultReport
import org.osate.assure.assure.ClaimResult
import org.osate.verify.util.IVerificationMethodDispatcher
import com.rockwellcollins.atc.resolute.analysis.values.NamedElementValue
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteProver
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteEvaluator
import com.rockwellcollins.atc.resolute.analysis.values.ResoluteValue
import com.rockwellcollins.atc.resolute.analysis.values.BoolValue
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.osate.alisa.common.common.ComputeDeclaration
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.osate.verify.verify.VerificationActivity
import org.osate.verify.verify.VerificationMethod
import org.osate.aadl2.util.OsateDebug
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter
import org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationContext
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.naming.QualifiedName
import org.osate.assure.assure.ElseType

@ImplementedBy(AssureProcessor)
interface IAssureProcessor {
	def void process(AssureResult assureResult);
}

/**
 * performs the processing of verification activities
 * records the result propagating up the counts
 * Will process only those that are TBD
 * It assumes the counts are ok
 */
class AssureProcessor implements IAssureProcessor {
	@Inject IVerificationMethodDispatcher dispatcher

	/**
	 * See the following documentation
	 * http://www.rcp-vision.com/1640/xtext-2-1-using-xbase-expressions/
	 * http://www.rcp-vision.com/1796/xtext-2-1-using-xbase-variables/
	 * about how to use the compiler
	 */
//	@Inject XbaseCompiler xbaseCompiler
	@Inject XbaseInterpreter xbaseInterpreter

	def void doProcess(AssuranceEvidence caseResult) {
		caseResult.claimResult.forEach[claimResult|claimResult.process]
		caseResult.subAssuranceEvidence.forEach[subcaseResult|subcaseResult.process]
	}

	def void doProcess(ClaimResult claimResult) {
		claimResult.verificationActivityResult.forEach[vaResult|vaResult.process]
		claimResult.subClaimResult.forEach[subclaimResult|subclaimResult.process]
	}

	def void doProcess(VerificationActivityResult vaResult) {
		if (vaResult.conditionResult != null) {
			vaResult.conditionResult.process
			if (vaResult.conditionResult instanceof PreconditionResult && !vaResult.conditionResult.isSuccess) {
				return
			}
		}
		runVerificationMethod(vaResult)
	}

	def void doProcess(ElseResult vaResult) {
		vaResult.first.forEach[expr|expr.process]
		if (vaResult.first.hasOther) {
			vaResult.recordElse(ElseType.OTHER)
			vaResult.other.forEach[expr|expr.process]
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

	def void doProcess(ThenResult vaResult) {
		vaResult.first.forEach[expr|expr.process]
		if (vaResult.first.isSuccess) {
			vaResult.recordNoSkip
			vaResult.second.forEach[expr|expr.process]
		} else {
			vaResult.recordSkip
		}
	}

	def void doProcess(ValidationResult assumptionResult) {
		runVerificationMethod(assumptionResult)
	}

	def void doProcess(PreconditionResult preconditionResult) {
		runVerificationMethod(preconditionResult)
	}

	override void process(AssureResult assureResult) {
		switch (assureResult) {
			AssuranceEvidence: assureResult.doProcess
			ClaimResult: assureResult.doProcess
			VerificationActivityResult: assureResult.doProcess
			ElseResult: assureResult.doProcess
			ThenResult: assureResult.doProcess
			ValidationResult: assureResult.doProcess
			PreconditionResult: assureResult.doProcess
		}
	}

	/**
	 * who needs to understand the method types?
	 * the runVerificationMethod dispatcher may do different catch methods
	 * The dispatchVerificationMethod may know from its label what type it is.
	 * The methods are expected to return boolean for predicate, 
	 * null or bool for analysis with results in marker/diagnostic, or the result report object
	 */
	def void runVerificationMethod(VerificationResult verificationResult) {
		val method = verificationResult.method;
		var Object res = null
		val target = verificationResult.claimSubject
		var Object[] parameters
		val ctx = new DefaultEvaluationContext()

		if (verificationResult instanceof VerificationActivityResult) {
			val verificationActivityResult = verificationResult as VerificationActivityResult
			val verificationActivity = verificationActivityResult.target as VerificationActivity
			val verificationMethod = verificationActivityResult.method as VerificationMethod

			if (verificationActivity.parameters.size != verificationMethod.params.size) {
				OsateDebug.osateDebug("[AssureProcessor] not the same number of parameters");
			}
			val nbParams = verificationMethod.params.size
			var i = 0

			parameters = newArrayOfSize(nbParams)

			while (i < nbParams) {
				var JvmType varType
				var Object param
				if (verificationActivity.parameters.get(i) instanceof XVariableDeclaration) {
					val varDecl = verificationActivity.parameters.get(i) as XVariableDeclaration
					varType = varDecl.type.type
					try {
						val IEvaluationResult r = xbaseInterpreter.evaluate(varDecl, ctx, CancelIndicator.NullImpl)
						param = ctx.getValue(QualifiedName.create(varDecl.name))
						println(varDecl.name + " = " + param)
					} catch (Exception e) {
						e.printStackTrace
					}
				} else {
					varType = (verificationActivity.parameters.get(i) as ComputeDeclaration).type.type
					val myClass = Class.forName(varType.qualifiedName)
//					println ("myClass=" + myClass.name)
					/**
					 * FIX how to exchange data and return values
					 */
					switch (myClass.name.toLowerCase) {
						case "java.lang.double": {
							param = myClass.constructors.get(0).newInstance(-1.0)
						}
						case "java.lang.integer": {
							param = myClass.constructors.get(0).newInstance(-1)
						}
						default: {
							param = myClass.newInstance
						}
					}

				}

				var paramType = (verificationMethod.params.get(i) as JvmFormalParameter).parameterType.type

//				println ("Param var" + i + ":" + varType.identifier)
//				println ("Param par" + i + ":" + paramType.identifier)
				parameters.set(i, param)
				if (! varType.equals(paramType)) {
					println("Mismatch parameters types")
					return
				}

				i = i + 1

			}
		}

		try {
			switch (method.methodType) {
				case SupportedTypes.JAVA: {
					res = dispatcher.dispatchVerificationMethod(method, target, parameters)
					if (res != null) {

						if (res instanceof Boolean) {

							if (res != true) {
								setToFail(verificationResult, "");
							} else {
								setToSuccess(verificationResult)
							}
						} else if (res instanceof ResultReport) {
							verificationResult.resultReport = res
						} else {
							setToFail(verificationResult, "No result report from analysis");
						}
					}
				}
				case SupportedTypes.ANALYSISPLUGIN: {
					res = dispatcher.dispatchVerificationMethod(method, target, parameters) // returning the marker or diagnostic id as string
					if (res instanceof String) {
						val subject = verificationResult.caseSubject
						val errors = addMarkers(verificationResult, subject, res, method)
						if (errors) {
							setToFail(verificationResult);
						} else {
							setToSuccess(verificationResult)
						}
					} else {
						setToFail(verificationResult, "Analysis return type is not a string of MarkerType");
					}
				}
				case SupportedTypes.RESOLUTE: {

					// Resolute handling See AssureUtil for setup	
					val si = verificationResult.caseSubject.systemInstance
					val EvaluationContext context = new EvaluationContext(si, sets, featToConnsMap);
					val ResoluteInterpreter interpreter = new ResoluteInterpreter(context);
					val provecall = createWrapperProveCall(verificationResult)
					if (provecall == null) {
						setToError(verificationResult,
							"Could not find Resolute Function " + verificationResult.method.name)
					} else {

						// using com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
						val com.rockwellcollins.atc.resolute.analysis.results.ClaimResult proof = interpreter.
							evaluateProveStatement(
								provecall) as com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
							if (proof.valid) {
								setToSuccess(verificationResult)
							} else {
								val proveri = AssureFactory.eINSTANCE.createResultIssue
								proof.doResoluteResults(proveri)
								setToFail(verificationResult, proveri.issues)
							}
						}
					}
//					case SupportedTypes.RESOLUTEPREDICATE: {
//						val si = verificationResult.caseSubject.systemInstance
//						val EvaluationContext context = new EvaluationContext(si, sets, featToConnsMap);
//						val ResoluteEvaluator evaluator = new ResoluteEvaluator(context, null);
//						val fncall = createWrapperFnCall(verificationResult)
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
//					case SupportedTypes.RESOLUTECOMPUTE: {
//						val si = verificationResult.caseSubject.systemInstance
//						val EvaluationContext context = new EvaluationContext(si, sets, featToConnsMap);
//						val ResoluteEvaluator evaluator = new ResoluteEvaluator(context, null);
//						val fncall = createWrapperFnCall(verificationResult)
//						if (fncall == null) {
//							setToError(verificationResult,
//								"Could not find Resolute Function " + verificationResult.method.name)
//						} else {
//							try {
//								val ResoluteValue resultvalue = evaluator.caseFnCallExpr(fncall)
//								// TODO evaluate claim predicate
//								if (resultvalue instanceof BoolValue) {
//									if (resultvalue.getBool) {
//										setToSuccess(verificationResult)
//									} else {
//										setToFail(verificationResult, "Resolute function evaluated to false")
//									}
//								} else {
//									setToFail(verificationResult, "Expected boolean result. Found " + resultvalue.type)
//								}
//							} catch (Throwable t) {
//								setToError(verificationResult,
//									"Verification activity did not complete. Exception: " + t.message)
//							}
//						}
//					}
					case MANUAL: {
					}
				} // end switch on method
			} catch (AssertionError e) {
				setToFail(verificationResult, e);
			} catch (ThreadDeath e) { // don't catch ThreadDeath by accident
				throw e;
			} catch (Throwable e) {
//			System.out.println("BLABLA2");
				setToError(verificationResult, e);
				throw e;
			}
			verificationResult.eResource.save(null)
		}

		def ProveStatement createWrapperProveCall(VerificationResult vr) {
			val resoluteFunction = vr.method.methodPath
			val factory = ResoluteFactory.eINSTANCE
//			val found = resolveResoluteFunction(vr, resoluteFunction)

			 val found = findResoluteFunction(vr,resoluteFunction)
			if(found == null) return null
			val call = factory.createFnCallExpr
			call.fn = found
			call.args.add(factory.createThisExpr)
			val prove = factory.createProveStatement
			prove.expr = call
			prove
		}

		def createWrapperFnCall(VerificationResult vr) {
			val resoluteFunction = vr.method.methodPath
			val factory = ResoluteFactory.eINSTANCE
			val target = factory.createIdExpr
			target.id = vr.claimSubject
			val call = factory.createFnCallExpr
			val found = findResoluteFunction(vr, resoluteFunction)
			call.fn = found
			call.args.add(target)
			call
		}

		def String toString(Object o) {
			switch (o) {
				Integer: o.toString
				Long: o.toString
				Double: o.toString
				String: o
				default: "an object"
			}
		}

		@Inject
		public IGlobalScopeProvider scopeProvider;


		def FunctionDefinition findResoluteFunction(EObject context, String resoluteFunctionName) {
			val scope = scopeProvider as CommonGlobalScopeProvider
			val foundlist = scope.getGlobalEObjectDescriptions(context,
				ResolutePackage.eINSTANCE.getFunctionDefinition(), [ eod |
				eod.getName().getLastSegment().equalsIgnoreCase(resoluteFunctionName)
			])
			if(foundlist.length == 0) return null
			return EcoreUtil.resolve(foundlist.head.EObjectOrProxy,context) as FunctionDefinition
		}

	}
