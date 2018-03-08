package org.osate.verify.util;

import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.NamedElement
import java.util.HashMap
import java.util.SortedSet
import org.osate.aadl2.instance.ComponentInstance
import java.util.Map
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.ComponentCategory
import java.util.TreeSet
import org.osate.result.Issue
import org.osate.result.ResultFactory
import org.osate.result.IssueType
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition
import com.rockwellcollins.atc.resolute.resolute.ProveStatement
import java.util.List
import org.osate.aadl2.PropertyExpression
import com.rockwellcollins.atc.resolute.resolute.ResoluteFactory
import com.rockwellcollins.atc.resolute.resolute.ThisExpr
import com.rockwellcollins.atc.resolute.resolute.NestedDotID
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr
import org.osate.aadl2.RealLiteral
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.StringLiteral
import org.osate.aadl2.BooleanLiteral
import com.rockwellcollins.atc.resolute.analysis.execution.FeatureToConnectionsMap
import com.rockwellcollins.atc.resolute.analysis.execution.NamedElementComparator
import com.rockwellcollins.atc.resolute.validation.BaseType
import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult
import org.osate.result.util.ResultUtil
import com.rockwellcollins.atc.resolute.analysis.views.ResoluteResultContentProvider
import org.eclipse.emf.ecore.EObject
import com.rockwellcollins.atc.resolute.resolute.FailExpr

public class ExecuteUtil {

	/**
	 * interface with Resolute
	 * we initialize the sets on demand. See populate function.
	 * We reset the sets and maps on an evelaution run.
	 */
	static var SystemInstance systemroot

	static var Map<String,SortedSet<NamedElement>>sets
	static var FeatureToConnectionsMap
	featToConnsMap

	def

	static FeatureToConnectionsMap getFeatToConnsMap() {
		if (featToConnsMap === null) {
			populateResoluteContext
		}
		return featToConnsMap
	}

	def

	static Map<String, SortedSet<NamedElement>> getSets() {
		if (sets === null) {
			populateResoluteContext
		}
		return sets
	}

	def

	static initializeResoluteContext(SystemInstance si) {
		if (systemroot != si) {
			sets = null
			featToConnsMap = null
			systemroot = si
		}
	}

	def

	private static void populateResoluteContext() {
		sets = new HashMap<String, SortedSet<NamedElement>>()
		systemroot.initializeSets(sets);
		featToConnsMap = new FeatureToConnectionsMap(systemroot);
	}

	def

	private static void initializeSets(ComponentInstance ci, Map<String, SortedSet<NamedElement>> sets) {
		if (ci === null) {
			return;
		}

		addToSet(sets, getCategoryName(ci.getCategory()), ci);
		addToSet(sets, "component", ci);

		for (ComponentInstance sub : ci.getComponentInstances()) {
			initializeSets(sub, sets);
		}

		for (ConnectionInstance conn : ci.getConnectionInstances()) {
			addToSet(sets, "connection", conn);
		}
	}

	def

	private static String getCategoryName(ComponentCategory category) {
		return new BaseType(category).toString();
	}

	def

	private static void addToSet(Map<String, SortedSet<NamedElement>> sets, String name, NamedElement ne) {
		var SortedSet<NamedElement> set = sets.get(name);
		if (set === null) {
			set = new TreeSet<NamedElement>(new NamedElementComparator());
			sets.put(name, set);
		}
		set.add(ne);
	}

	/**
	 * invokes Resolute call function on target component instance. instanceroot is used to initialize the Resolute evaluation context.
	 * parameterObjects can be null or an empty list.
	 * The return value is an Issue object with subissues for the list of issues returned in the Resolute ClaimResult.
	 * If the proof fails then the top Issue is set to FAIL, if successful it is set to SUCCESS
	 */
	def

	static Issue executeResoluteFunction(EObject fundef,SystemInstance instanceroot,ComponentInstance targetComponent,List<PropertyExpression> parameterObjects) {
		val fd = fundef as FunctionDefinition
		initializeResoluteContext(instanceroot);
		val EvaluationContext context = new EvaluationContext(instanceroot, sets, featToConnsMap);
		// check for claim function or compute function
		val ResoluteInterpreter interpreter = new ResoluteInterpreter(context);
		val proveri = ResultFactory.eINSTANCE.createIssue
		val provecall = createWrapperProveCall(fd, targetComponent, parameterObjects)
		if (provecall !== null) {
			// using com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
			val ResoluteResult proof = interpreter.evaluateProveStatement(provecall) as ResoluteResult
			doResoluteResults(proof,proveri)
		} else {
			proveri.issueType = IssueType.FAIL
			proveri.message = "Could not find Resolute Function " + fd.name
			proveri.sourceReference = targetComponent
		}
		return proveri
	}

	def

	static ProveStatement createWrapperProveCall(FunctionDefinition fd, ComponentInstance ci,
		List<PropertyExpression> params) {
		val factory = ResoluteFactory.eINSTANCE
		val call = factory.createFnCallExpr
		call.fn = fd
		call.args.add(createComponentinstanceReference(ci))
		if (params !== null){
			addParams(call, params)
		}
		val prove = factory.createProveStatement
		prove.expr = call
		prove
	}

	def

	static ThisExpr createComponentinstanceReference(ComponentInstance ci) {
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

	def

	static addParams(FnCallExpr call, List<PropertyExpression> params) {
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

	static val resoluteContent = new ResoluteResultContentProvider


	def

	static void doResoluteResults(ResoluteResult rr, Issue ri) {
		if (rr.valid){
			ri.issueType = IssueType.SUCCESS
		} else {
			ri.issueType = IssueType.FAIL
		}
		val subrrs = resoluteContent.getChildren(rr)
		subrrs.forEach [ subrr |
			val subclaim = subrr as com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
			val subri = if (subclaim.isValid)
					ri.addSuccessIssue(subclaim.location, subclaim.text)
				else
					ri.addFailIssue(subclaim.location, subclaim.text)
			subclaim.doResoluteResults(subri)
		]
	}
	def static Issue addIssue(Issue ri, IssueType type, EObject target, String message) {
		val issue = ResultFactory.eINSTANCE.createIssue
		issue.message = message
		issue.issueType = type;
		if (target instanceof FunctionDefinition) {
			issue.sourceReference = target
		} else if (!(target instanceof FailExpr)) {
			issue.sourceReference = target
		} else if (target instanceof FailExpr) {
			if (message.length > 14) {
				issue.message = message.substring(15)
			}
		}
		ri.issues.add(issue)
		issue
	}

	def static Issue addFailIssue(Issue ri, EObject target, String message) {
		addIssue(ri, IssueType.FAIL, target, message)
	}

	def static Issue addSuccessIssue(Issue ri, EObject target, String message) {
		addIssue(ri, IssueType.SUCCESS, target, message)
	}

}
