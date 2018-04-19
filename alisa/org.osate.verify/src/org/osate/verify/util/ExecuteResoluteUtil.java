package org.osate.verify.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.result.Diagnostic;
import org.osate.result.util.ResultUtil;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext;
import com.rockwellcollins.atc.resolute.analysis.execution.FeatureToConnectionsMap;
import com.rockwellcollins.atc.resolute.analysis.execution.NamedElementComparator;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteProver;
import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.analysis.views.ResoluteResultContentProvider;
import com.rockwellcollins.atc.resolute.resolute.BoolExpr;
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;
import com.rockwellcollins.atc.resolute.resolute.IntExpr;
import com.rockwellcollins.atc.resolute.resolute.NestedDotID;
import com.rockwellcollins.atc.resolute.resolute.ProveStatement;
import com.rockwellcollins.atc.resolute.resolute.RealExpr;
import com.rockwellcollins.atc.resolute.resolute.ResoluteFactory;
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;
import com.rockwellcollins.atc.resolute.resolute.StringExpr;
import com.rockwellcollins.atc.resolute.resolute.ThisExpr;
import com.rockwellcollins.atc.resolute.ui.internal.ResoluteActivator;
import com.rockwellcollins.atc.resolute.validation.BaseType;

public class ExecuteResoluteUtil {
	public static ExecuteResoluteUtil eInstance = new ExecuteResoluteUtil();

	public void tryLoad() throws NoClassDefFoundError {
		// Nothing needed since static initialization of this class already
		// tries to load Resolute
		FunctionDefinition fn = ResoluteFactory.eINSTANCE.createFunctionDefinition();
		fn.setName("dummy");
	}

	/**
	 * interface with Resolute
	 * we initialize the sets on demand. See populate function.
	 * We reset the sets and maps on an evaluation run.
	 */
	private SystemInstance systemroot;
	private Map<String, SortedSet<NamedElement>> sets;
	private FeatureToConnectionsMap featToConnsMap;

	private void initializeResoluteContext(SystemInstance si) {
		if (systemroot != si) {
			systemroot = si;
			sets = new HashMap<String, SortedSet<NamedElement>>();
			initializeSets(systemroot,sets);
			featToConnsMap = new FeatureToConnectionsMap(systemroot);
		}
	}

	private void initializeSets(ComponentInstance ci, Map<String, SortedSet<NamedElement>> sets) {
		if (ci == null) {
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

	private String getCategoryName(ComponentCategory category) {
		return new BaseType(category).toString();
	}

	private void addToSet(Map<String, SortedSet<NamedElement>> sets, String name, NamedElement ne) {
		SortedSet<NamedElement> set = sets.get(name);
		if (set == null) {
			set = new TreeSet<NamedElement>(new NamedElementComparator());
			sets.put(name, set);
		}
		set.add(ne);
	}

	public ExecuteResoluteUtil() {
		Injector injector = ResoluteActivator.getInstance().getInjector(
				ResoluteActivator.COM_ROCKWELLCOLLINS_ATC_RESOLUTE_RESOLUTE);
		injector.injectMembers(this);
	}
	@Inject
	IGlobalScopeProvider gscope;

	public Diagnostic executeResoluteFunction(String fundef, SystemInstance instanceroot,
			ComponentInstance targetComponent,
		List<PropertyExpression> parameterObjects) {
		Iterable<IEObjectDescription> allentries = gscope.getScope(instanceroot.eResource(), ResolutePackage.eINSTANCE.getFnCallExpr_Fn(), null).
			getAllElements();
		String funname = fundef.replaceAll("\"", "");
		for (IEObjectDescription description : allentries) {
			if (!description.getName().isEmpty() && description.getName().getLastSegment().equalsIgnoreCase(funname)) {
				EObject obj = EcoreUtil.resolve(description.getEObjectOrProxy(), targetComponent);
				return executeResoluteFunction(obj, instanceroot, targetComponent,
					parameterObjects);
			}
		}
		return null;
	}

	/**
	 * invokes Resolute claim function on target component instance. instanceroot is used to initialize the Resolute evaluation context.
	 * parameterObjects can be null or an empty list.
	 * The return value is an Issue object with subissues for the list of issues returned in the Resolute ClaimResult.
	 * If the proof fails then the top Issue is set to FAIL, if successful it is set to SUCCESS
	 */
	public Diagnostic executeResoluteFunction(EObject fundef, SystemInstance instanceroot,
			ComponentInstance targetComponent,
		List<PropertyExpression> parameterObjects) {
		FunctionDefinition fd = ( FunctionDefinition)fundef ;
		initializeResoluteContext(instanceroot);
		EvaluationContext context = new EvaluationContext(instanceroot, sets, featToConnsMap);
		// check for claim function
		FnCallExpr fcncall = createWrapperFunctionCall(fd, targetComponent, parameterObjects);
		if (fcncall != null) {
			// using com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
			ResoluteProver prover = new ResoluteProver(context);
			ResoluteResult res = prover.doSwitch(fcncall);
			return doResoluteResults(res);
		} else {
			return ResultUtil.createError("Could not find Resolute Function " + fd.getName(), targetComponent);
		}
	}

	private ProveStatement createWrapperProveCall(FunctionDefinition fd, ComponentInstance ci,
		List<PropertyExpression> params) {
		ResoluteFactory factory = ResoluteFactory.eINSTANCE;
		FnCallExpr call = createWrapperFunctionCall(fd, ci, params);
		ProveStatement prove = factory.createProveStatement();
		prove.setExpr(call);
		return prove;
	}

	private FnCallExpr createWrapperFunctionCall(FunctionDefinition fd, ComponentInstance ci,
			List<PropertyExpression> params) {
		ResoluteFactory factory = ResoluteFactory.eINSTANCE;
		FnCallExpr call = factory.createFnCallExpr();
		call.setFn(fd);
		call.getArgs().add(createComponentinstanceReference(ci));
		if (params != null) {
			addParams(call, params);
		}
		return call;
	}

	private ThisExpr createComponentinstanceReference(ComponentInstance ci) {
		ResoluteFactory factory = ResoluteFactory.eINSTANCE;
		NestedDotID nid = null;
		ComponentInstance nci = ci;
		while (!(nci instanceof SystemInstance)) {
			NestedDotID x = factory.createNestedDotID();
			x.setBase(nci.getSubcomponent());
			x.setSub(nid);
			nid = x;
			nci = (ComponentInstance) nci.eContainer();
		}
		ThisExpr te = factory.createThisExpr();
		te.setSub(nid);
		return te;
	}

	private void addParams(FnCallExpr call, List<PropertyExpression> params) {
		for (PropertyExpression p : params) {
			if (p instanceof RealLiteral) {
				RealExpr realval = ResoluteFactory.eINSTANCE.createRealExpr();
				realval.setVal((RealLiteral) p);
				call.getArgs().add(realval);
			} else if (p instanceof IntegerLiteral) {
				IntExpr intval = ResoluteFactory.eINSTANCE.createIntExpr();
				intval.setVal((IntegerLiteral) p);
				call.getArgs().add(intval);
			} else if (p instanceof StringLiteral) {
				StringExpr stringval = ResoluteFactory.eINSTANCE.createStringExpr();
				stringval.setVal((StringLiteral) p);
				call.getArgs().add(stringval);
			} else if (p instanceof BooleanLiteral) {
				BoolExpr boolval = ResoluteFactory.eINSTANCE.createBoolExpr();
				boolval.setVal ((BooleanLiteral)p);
				call.getArgs().add(boolval);
			}
		}
	}

	static private ResoluteResultContentProvider resoluteContent = new ResoluteResultContentProvider();

	private Diagnostic doResoluteResults(ResoluteResult resRes) {
		Diagnostic ri = null;
		if (resRes instanceof ClaimResult) {
			ClaimResult rr = (ClaimResult) resRes;
		if (rr.isValid()) {
			ri = ResultUtil.createSuccess(rr.getText(), rr.getLocation());
		} else {
			ri = ResultUtil.createFailure(rr.getText(), rr.getLocation());
		}
		Object[] subrrs = resoluteContent.getChildren(rr);
		for (Object subrr : subrrs) {
			ClaimResult subclaim = (ClaimResult) subrr;
			// in the future we may need to create an intermediary Result object
			ri.getIssues().add(doResoluteResults(subclaim));
		}
		}
		return ri;
	}


}
