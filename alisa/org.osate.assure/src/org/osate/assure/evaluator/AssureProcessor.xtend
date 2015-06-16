package org.osate.assure.evaluator

import com.google.inject.Inject

//import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.FailThenResult
import org.osate.assure.assure.AndThenResult
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

	def void doProcess(AssuranceEvidence caseResult) {
		caseResult.claimResult.forEach[claimResult|claimResult.process]
		caseResult.subAssuranceEvidence.forEach[subcaseResult|subcaseResult.process]
	}

	def void doProcess(ClaimResult claimResult) {
		claimResult.verificationActivityResult.forEach[vaResult|vaResult.process]
		claimResult.subClaimResult.forEach[subclaimResult|subclaimResult.process]
	}

	def void doProcess(VerificationActivityResult vaResult) {
		vaResult.validationResult.forEach[assumptionResult|assumptionResult.process]
		vaResult.preconditionResult.forEach[preconditionResult|preconditionResult.process]
		if (vaResult.preconditionResult.success) {
			runVerificationMethod(vaResult)
		}
	}

	def void doProcess(FailThenResult vaResult) {
		vaResult.first.forEach[expr|expr.process]
		if (vaResult.unknownThen && vaResult.first.hasUnknown) {
			vaResult.recordFailThen
			vaResult.second.forEach[expr|expr.process]
		} else if (vaResult.failThen && vaResult.first.hasFailed) {
			vaResult.recordFailThen
			vaResult.second.forEach[expr|expr.process]
		} else if (vaResult.first.hasFailedOrUnknown) {
			vaResult.recordFailThen
			vaResult.second.forEach[expr|expr.process]
		} else {
			vaResult.recordNoFailThen
		}
	}

	def void doProcess(AndThenResult vaResult) {
		vaResult.first.forEach[expr|expr.process]
		if (vaResult.first.isSuccessFul) {
			vaResult.second.forEach[expr|expr.process]
			vaResult.recordNoSkip
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
			FailThenResult: assureResult.doProcess
			AndThenResult: assureResult.doProcess
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
		var Class[] classesToLoad
		
		
		if (verificationResult instanceof VerificationActivityResult)
		{
			val verificationActivityResult =  verificationResult as VerificationActivityResult
			val verificationActivity = verificationActivityResult.target as VerificationActivity
			val verificationMethod = verificationActivityResult.method as VerificationMethod
			
			if (verificationActivity.parameters.size != verificationMethod.params.size)
			{
				OsateDebug.osateDebug("[AssureProcessor] not the same number of parameters");
			}
			val nbParams = verificationMethod.params.size
			var i = 0
			
			classesToLoad = newArrayOfSize(nbParams)
			
			while (i < nbParams)
			{
				var JvmType varType
				if (verificationActivity.parameters.get(i) instanceof XVariableDeclaration)
				{
					varType = (verificationActivity.parameters.get(i) as XVariableDeclaration).type.type
				}
				else
				{
					varType = (verificationActivity.parameters.get(i) as ComputeDeclaration).type.type
				}
				
				var paramType = (verificationMethod.params.get(i) as JvmFormalParameter).parameterType.type
				println ("Param var" + i + ":" + varType.identifier)
				println ("Param par" + i + ":" + paramType.identifier)
				classesToLoad.set(i, Class.forName(varType.identifier))
				if (! varType.equals(paramType))
				{ 
					println("Mismatch parameters types")
					return
				}
				
				i = i + 1
				
				
			}
		}
		
		try {
			switch (method.methodType) {
				case SupportedTypes.PREDICATE: {
					res = dispatcher.dispatchVerificationMethod(method, target, classesToLoad)
					if (res != null && res instanceof Boolean && res != true) {
						setToFail(verificationResult, "");
					} else {
						setToSuccess(verificationResult)
					}
				}
				case SupportedTypes.ANALYSIS: {
					res = dispatcher.dispatchVerificationMethod(method, target, classesToLoad) // returning the marker or diagnostic id as string
					switch (method.reporting) {
						case ASSERTEXCEPTION: {
							// handled by catch clauses
						}
						case DIAGNOSTICS: {
							// to be handled
						}
						case null,
						case ERRORMARKER,
						case MARKER: {
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
						case RESULTREPORT: {
							if (res instanceof ResultReport) {
								verificationResult.resultReport = res
							} else {
								setToFail(verificationResult, "No result report from analysis");
							}
						}
					}
				}
				case SupportedTypes.COMPUTE: {
					res = dispatcher.dispatchVerificationMethod(method, target, classesToLoad)

					// TODO Evaluate predicate function
					verificationResult.addInfoIssue(verificationResult,
						"Need to compare analysis result " + toString(res))
				}
				case SupportedTypes.RESOLUTEPROVE: {

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
							evaluateProveStatement(provecall) as com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
						if (proof.valid) {
							setToSuccess(verificationResult)
						} else {
							val proveri = AssureFactory.eINSTANCE.createResultIssue
							proof.doResoluteResults(proveri)
							setToFail(verificationResult, proveri.issues)
						}
					}
				}
				case SupportedTypes.RESOLUTEPREDICATE: {
					val si = verificationResult.caseSubject.systemInstance
					val EvaluationContext context = new EvaluationContext(si, sets, featToConnsMap);
					val ResoluteEvaluator evaluator = new ResoluteEvaluator(context, null);
					val fncall = createWrapperFnCall(verificationResult)
					if (fncall == null) {
						setToError(verificationResult,
							"Could not find Resolute Function " + verificationResult.method.name)
					} else {
						try {
							val ResoluteValue resultvalue = evaluator.caseFnCallExpr(fncall)
							if (resultvalue instanceof BoolValue) {
								if (resultvalue.getBool) {
									setToSuccess(verificationResult)
								} else {
									setToFail(verificationResult, "Resolute predicate evaluated to false")
								}
							} else {
								setToError(verificationResult, "Expected boolean result. Found "+resultvalue.type)
							}
						} catch (Throwable t) {
							setToError(verificationResult,
								"Verification activity did not complete. Exception: " + t.message)
						}
					}
				}
				case SupportedTypes.RESOLUTECOMPUTE: {
					val si = verificationResult.caseSubject.systemInstance
					val EvaluationContext context = new EvaluationContext(si, sets, featToConnsMap);
					val ResoluteEvaluator evaluator = new ResoluteEvaluator(context, null);
					val fncall = createWrapperFnCall(verificationResult)
					if (fncall == null) {
						setToError(verificationResult,
							"Could not find Resolute Function " + verificationResult.method.name)
					} else {
						try {
							val ResoluteValue resultvalue = evaluator.caseFnCallExpr(fncall)
							// TODO evaluate claim predicate
							if (resultvalue instanceof BoolValue) {
								if (resultvalue.getBool) {
									setToSuccess(verificationResult)
								} else {
									setToFail(verificationResult, "Resolute function evaluated to false")
								}
							} else {
								setToFail(verificationResult, "Expected boolean result. Found "+resultvalue.type)
							}
						} catch (Throwable t) {
							setToError(verificationResult,
								"Verification activity did not complete. Exception: " + t.message)
						}
					}
				}
				case MANUAL: {
				}
			} // end switch on method
		} catch (AssertionError e) {
			setToFail(verificationResult, e);
		} catch (ThreadDeath e) { // don't catch ThreadDeath by accident
			throw e;
		} catch (Throwable e) {
			setToError(verificationResult, e);
		}
		verificationResult.eResource.save(null)
	}

	def ProveStatement createWrapperProveCall(VerificationResult vr) {
		val resoluteFunction = vr.method.methodPath
		val factory = ResoluteFactory.eINSTANCE
		val found = resolveResoluteFunction(vr, resoluteFunction)

		//		val found = findResoluteFunction(vr,resoluteFunction)
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
		val found = resolveResoluteFunction(vr, resoluteFunction)
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

	//	@Inject
	//	public ResoluteLinkingService resoluteLinkingService;
	//
	//	final static PSNode psNode = new PSNode();
	def FunctionDefinition resolveResoluteFunction(EObject context, String resoluteFunctionName) {

		//		psNode.setText(resoluteFunctionName);
		//		val List<EObject> boundList = resoluteLinkingService.getLinkedObjects(context,
		//				ResolutePackage.eINSTANCE.getFnCallExpr_Fn(), psNode);
		//		if (boundList.size() > 0) {
		//			return  boundList.get(0) as FunctionDefinition;
		//		}
		val res = getNamedElementByType(context, resoluteFunctionName, ResolutePackage.eINSTANCE.getFunctionDefinition())
		return res as FunctionDefinition
	}

	def EObject getNamedElementByType(EObject context, String name, EClass eclass) {

		// This code will only link to objects in the projects visible from the current project
		val Iterable<IEObjectDescription> allObjectTypes = EMFIndexRetrieval.
			getAllEObjectsOfTypeInWorkspace(context, eclass);
		val String contextProject = context.eResource().getURI().segment(1);
		val List<String> visibleProjects = getVisibleProjects(contextProject);

		for (IEObjectDescription eod : allObjectTypes) {
			if (eod.getName().getLastSegment().equalsIgnoreCase(name)) {
				var EObject res = eod.getEObjectOrProxy();
				res = EcoreUtil.resolve(res, context.eResource().getResourceSet());
				if (!Aadl2Util.isNull(res)) {
					val URI linkUri = res.eResource().getURI();
					val String linkProject = linkUri.segment(1);
					if (visibleProjects.contains(linkProject)) {
						return res;
					}
				}
			}
		}

		return null;
	}

	def List<String> getVisibleProjects(String contextProjectName) {
		val List<String> result = new ArrayList<String>();
		result.add(contextProjectName);

		val IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		val IProject contextProject = root.getProject(URI.decode(contextProjectName));
		if (!contextProject.exists() || !contextProject.isAccessible() || !contextProject.isOpen())
			return result;
		try {
			val IProjectDescription description = contextProject.getDescription();
			for (IProject referencedProject : description.getReferencedProjects()) {
				result.add(URI.encodeSegment(referencedProject.getName(), false));
			}
		} catch (CoreException ex) {
			ex.printStackTrace();
		}

		return result;
	}

	def FunctionDefinition findResoluteFunction(EObject context, String resoluteFunctionName) {
		val scope = scopeProvider as CommonGlobalScopeProvider
		val foundlist = scope.getGlobalEObjectDescriptions(context, ResolutePackage.eINSTANCE.getFunctionDefinition(),
			null)
		val filteredlist = foundlist.filter[eod|eod.getName().getLastSegment().equalsIgnoreCase(resoluteFunctionName)]
		if(filteredlist.length == 0) return null
		return filteredlist.head as FunctionDefinition
	}

}
