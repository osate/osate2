package org.osate.assure.util

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter
import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition
import com.rockwellcollins.atc.resolute.resolute.ProveStatement
import com.rockwellcollins.atc.resolute.resolute.ResoluteFactory
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.osate.alisa.common.scoping.CommonGlobalScopeProvider
import org.osate.assure.assure.AssureFactory
import org.osate.assure.assure.VerificationActivityResult
import org.osate.verify.verify.SupportedTypes

import static extension org.osate.assure.util.AssureUtilExtension.*
import org.eclipse.emf.ecore.EObject
import com.rockwellcollins.atc.resolute.linking.ResoluteLinkingService
import org.osate.xtext.aadl2.properties.util.PSNode
import java.util.List
import org.eclipse.xtext.resource.IEObjectDescription
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.aadl2.util.Aadl2Util
import org.eclipse.emf.common.util.URI
import org.eclipse.core.resources.IWorkspaceRoot
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IProjectDescription
import org.eclipse.core.runtime.CoreException
import java.util.ArrayList

@ImplementedBy(DefaultVerificationMethodDispatcher)
interface IVerificationMethodDispatcher {
	def Object dispatchVerificationMethod(String methodPath, VerificationActivityResult vr);
	def void runVerificationMethod(VerificationActivityResult verificationActivityResult);
}

class DefaultVerificationMethodDispatcher implements IVerificationMethodDispatcher{
	
	override Object dispatchVerificationMethod(String methodPath, VerificationActivityResult vr) {
		println("Dispatching "+methodPath + " on "+vr.claimSubject.getQualifiedName)
		return null
		}

/**
 * who needs to understand the method types?
 * the runVerificationMethod dispatcher may do different catch methods
 * The dispatchVerificationMethod may know from its label what type it is.
 */

	override void runVerificationMethod(VerificationActivityResult verificationActivityResult) {
		val method = verificationActivityResult.getTarget().getMethod();
		val methodpath = method.getMethodPath();
		switch method.getMethodType() {
			case SupportedTypes.SINGLEPREDICATE : //|| SupportedTypes.SINGLEANALYSIS || SupportedTypes.ASSERTIONEXCEPTION: 
			{
			try { 
				val res = dispatchVerificationMethod(methodpath, verificationActivityResult)
				if (res != null && res instanceof Boolean && res != true){
				setToFail(verificationActivityResult, "");
				} else {
					setToSuccess(verificationActivityResult)
				}
			} catch (AssertionError e) {
				setToFail(verificationActivityResult, e);
			} catch (ThreadDeath e) { // don't catch ThreadDeath by accident
				throw e;
			} catch (Throwable e) {
				setToError(verificationActivityResult, e);
			}
			}
			
		case SupportedTypes.MULTIMARKER: {
			try { 
				val res = dispatchVerificationMethod(methodpath, verificationActivityResult)
				if (res != null && res instanceof Boolean && res != true){
				setToFail(verificationActivityResult, "");
				} else {
				setToSuccess(verificationActivityResult)
				}
//			} catch (AssertionError e) {
//				setToFail(verificationActivityResult, e);
//				null
			} catch (ThreadDeath e) { // don't catch ThreadDeath by accident
				throw e;
			} catch (Throwable e) {
				setToError(verificationActivityResult, e);
			}
		}
		case SupportedTypes.RESOLUTEPROVE:{
			// Resolute handling See AssureUtil for setup	
			val si = verificationActivityResult.caseSubject.systemInstance
			val EvaluationContext context = new EvaluationContext(si, sets, featToConnsMap);
			val ResoluteInterpreter interpreter = new ResoluteInterpreter(context);
			val provecall = createWrapperProveCall(verificationActivityResult)
			if (provecall == null) {
				setToError(verificationActivityResult,"Could not find Resolute Function '"+verificationActivityResult.methodName+"'")
				return
			}
			val ClaimResult proof = interpreter.evaluateProveStatement(provecall) as ClaimResult
			if (proof.valid){
				setToSuccess(verificationActivityResult)
			} else {
				val proveri = AssureFactory.eINSTANCE.createResultIssue
				proof.doResoluteResults(proveri)
				setToFail(verificationActivityResult, proveri.issues)
			}
		}
		}
		verificationActivityResult.eResource.save(null)
	}
	
	def ProveStatement createWrapperProveCall(VerificationActivityResult vr){
		val resoluteFunction = vr.methodName
		val factory = ResoluteFactory.eINSTANCE
		val found = resolveResoluteFunction(vr,resoluteFunction)
//		val found = findResoluteFunction(vr,resoluteFunction)
		if (found == null) return null
		val call = factory.createFnCallExpr
		call.fn = found
		call.args.add(factory.createThisExpr)
		val prove = factory.createProveStatement
		prove.expr = call
		prove
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
		val Iterable<IEObjectDescription> allObjectTypes = EMFIndexRetrieval.getAllEObjectsOfTypeInWorkspace(context,
				eclass);
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
		val foundlist = scope.getGlobalEObjectDescriptions(context,ResolutePackage.eINSTANCE.getFunctionDefinition(), null)
		val filteredlist = foundlist.filter[eod|eod.getName().getLastSegment().equalsIgnoreCase(resoluteFunctionName)]		
		if (filteredlist.length == 0 ) return null
		return filteredlist.head as FunctionDefinition
	}
	
	
}