package org.osate.assure.evaluator

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter
import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition
import com.rockwellcollins.atc.resolute.resolute.ProveStatement
import com.rockwellcollins.atc.resolute.resolute.ResoluteFactory
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage
import java.util.ArrayList
import java.util.List
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IProjectDescription
import org.eclipse.core.resources.IWorkspaceRoot
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.CoreException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.osate.aadl2.util.Aadl2Util
import org.osate.alisa.common.scoping.CommonGlobalScopeProvider
import org.osate.assure.assure.AssureFactory
import org.osate.assure.assure.VerificationResult
import org.osate.results.results.ResultReport
import org.osate.verify.verify.SupportedTypes
import org.osate.verify.verify.VerificationMethod
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval

import static extension org.osate.assure.util.AssureUtilExtension.*
import static extension org.osate.assure.evaluator.AnalysisPluginInterface.*

@ImplementedBy(DefaultVerificationMethodDispatcher)
interface IVerificationMethodDispatcher {
	def Object dispatchVerificationMethod(VerificationMethod vm, VerificationResult vr);

	def void runVerificationMethod(VerificationResult verificationActivityResult);
}

class DefaultVerificationMethodDispatcher implements IVerificationMethodDispatcher {

	override Object dispatchVerificationMethod(VerificationMethod vm, VerificationResult vr) {
		val target = vr.claimSubject
			switch (vm.methodPath) {
//				case "org.osate.assure.analysis.PlatformResourceBudgets.assertSumSubBudgets" : {
//					if ( target instanceof ComponentInstance) return target.assertSumSubBudgets
//				}
//				case "org.osate.assure.analysis.PlatformResourceBudgets.sumSubBudgets": {
//					if ( target instanceof ComponentInstance) return target.sumSubBudgets
//				}
				case "org.osate.assure.analysis.PlatformResourceBudgets.flowLatencyAnalysis": {
					return target.flowLatencyAnalysis
				}
				case "org.osate.assure.analysis.PlatformResourceBudgets.A429Consistency": {
					return target.A429Consistency
				}
				case "org.osate.assure.analysis.PlatformResourceBudgets.ConnectionBindingConsistency": {
					return target.ConnectionBindingConsistency
				}
				case "org.osate.assure.analysis.PlatformResourceBudgets.PowerAnalysis": {
					return target.PowerAnalysis
				}
				case "org.osate.assure.analysis.PlatformResourceBudgets.PortDataConsistency": {
					return target.PortDataConsistency
				}
				case "org.osate.assure.analysis.PlatformResourceBudgets.MassAnalysis": {
					return target.MassAnalysis
				}
			}
		return null
	}

	/**
 * who needs to understand the method types?
 * the runVerificationMethod dispatcher may do different catch methods
 * The dispatchVerificationMethod may know from its label what type it is.
 * The methods are expected to return boolean for predicate, 
 * null or bool for analysis with results in marker/diagnostic, or the result report object
 */
	override void runVerificationMethod(VerificationResult verificationResult) {
		val method = verificationResult.method;
		var Object res = null
		try {
			switch (method.methodType) {
				case SupportedTypes.PREDICATE: {
					res = dispatchVerificationMethod(method, verificationResult)
					if (res != null && res instanceof Boolean && res != true) {
						setToFail(verificationResult, "");
					} else {
						setToSuccess(verificationResult)
					}
				}
				case SupportedTypes.ANALYSIS: {
					res = dispatchVerificationMethod(method, verificationResult) // returning the marker or diagnostic id as string
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
					res = dispatchVerificationMethod(method, verificationResult)

					// TODO Evaluate predicate function
					verificationResult.addInfoIssue(verificationResult.claimSubject,
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
							"Could not find Resolute Function " + verificationResult.method.name )
					} else {

						// using com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
						val ClaimResult proof = interpreter.evaluateProveStatement(provecall) as ClaimResult
						if (proof.valid) {
							setToSuccess(verificationResult)
						} else {
							val proveri = AssureFactory.eINSTANCE.createResultIssue
							proof.doResoluteResults(proveri)
							setToFail(verificationResult, proveri.issues)
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
