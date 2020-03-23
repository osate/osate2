/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.assure.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;

import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext;
import com.rockwellcollins.atc.resolute.analysis.execution.FeatureToConnectionsMap;
import com.rockwellcollins.atc.resolute.analysis.execution.NamedElementComparator;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteEvaluator;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteFailException;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteProver;
import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.analysis.values.NamedElementValue;
import com.rockwellcollins.atc.resolute.analysis.values.ResoluteValue;
import com.rockwellcollins.atc.resolute.analysis.views.ResoluteResultContentProvider;
import com.rockwellcollins.atc.resolute.resolute.BoolExpr;
import com.rockwellcollins.atc.resolute.resolute.Expr;
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;
import com.rockwellcollins.atc.resolute.resolute.IntExpr;
import com.rockwellcollins.atc.resolute.resolute.NestedDotID;
import com.rockwellcollins.atc.resolute.resolute.RealExpr;
import com.rockwellcollins.atc.resolute.resolute.ResoluteFactory;
import com.rockwellcollins.atc.resolute.resolute.StringExpr;
import com.rockwellcollins.atc.resolute.resolute.ThisExpr;
import com.rockwellcollins.atc.resolute.validation.BaseType;

public class ResoluteInterface {

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
			initializeSets(systemroot, sets);
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

	public ResoluteInterface() {
	}

	/**
	 * invokes Resolute claim function on targetComponent or targetElement if not null.
	 * instanceroot is used to initialize the Resolute evaluation context.
	 * targetComponent is the evaluation context
	 * targetElement is the model element within the component instance or null.
	 * parameterObjects is a list of additional parameters of types RealLiteral, IntegerLiteral, StringLiteral, BooleanLiteral
	 * parameterObjects can be null or an empty list.
	 * The return value is an Issue object with subissues for the list of issues returned in the Resolute ClaimResult.
	 * If the proof fails then the top Issue is set to FAIL, if successful it is set to SUCCESS
	 */
	public EObject executeResoluteFunctionOnce(EObject fundef, final ComponentInstance targetComponent,
			final InstanceObject targetElement, List<PropertyExpression> parameterObjects) {
		FunctionDefinition fd = (FunctionDefinition) fundef;
		initializeResoluteContext(targetComponent.getSystemInstance());
		EvaluationContext context = new EvaluationContext(targetComponent, sets, featToConnsMap);
		// check for claim function
		FnCallExpr fcncall = createWrapperFunctionCall(fd, targetElement, parameterObjects);
		if (fcncall != null) {
//			if (fcncall.getFn().getBody() instanceof ClaimBody) {
			// using com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
			ResoluteProver prover = new ResoluteProver(context) {

				@Override
				protected ResoluteEvaluator createResoluteEvaluator() {
					return new ResoluteEvaluator(context, varStack.peek()) {
						@Override
						public ResoluteValue caseThisExpr(ThisExpr object) {
							// We prepare a thisexpr with either the component instance as context object or a single reference to a model element
							// See createWrapperFunctionCall
							NamedElement curr = context.getThisInstance();
							if (object.getSub() != null) {
								curr = object.getSub().getBase();
							}
							return new NamedElementValue(curr);
						}
					};
				}

			};

			try {
				ResoluteResult res = prover.doSwitch(fcncall);
				return doResoluteResults(res);
			} catch (ResoluteFailException e) {
				return ResultUtil.createFailureResult(e.getMessage(), targetElement);
			}
//			} else {
//				// computational function
//				ResoluteEvaluator engine = new ResoluteEvaluator(context, null) {
//					@Override
//					public ResoluteValue caseThisExpr(ThisExpr object) {
//						// We prepare a thisexpr with either the component instance as context object or a single reference to a model element
//						// See createWrapperFunctionCall
//						NamedElement curr = context.getThisInstance();
//						if (object.getSub() != null) {
//							curr = object.getSub().getBase();
//						}
//						return new NamedElementValue(curr);
//					}
//				};
//				Object res = engine.doSwitch(fcncall);
//				return null;
//			}
		} else {
			return ResultUtil.createErrorDiagnostic("Could not find Resolute Function " + fd.getName(), fd);
		}
	}

	private FnCallExpr createWrapperFunctionCall(FunctionDefinition fd, InstanceObject io,
			List<PropertyExpression> params) {
		ResoluteFactory factory = ResoluteFactory.eINSTANCE;
		FnCallExpr call = factory.createFnCallExpr();
		call.setFn(fd);
		int fdparams = fd.getArgs().size();
		int aparams = 0;
		if (params != null) {
			aparams = params.size();
		}
		if (fdparams == aparams + 1) {
			call.getArgs().add(createInstanceObjectReference(io));
		}
		if (params != null) {
			addParams(call, params);
		}
		return call;
	}

	private ThisExpr createInstanceObjectReference(InstanceObject io) {
		ResoluteFactory factory = ResoluteFactory.eINSTANCE;
		NestedDotID nid = null;
		if (io != null) {
			nid = factory.createNestedDotID();
			nid.setBase(io);
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
				boolval.setVal((BooleanLiteral) p);
				call.getArgs().add(boolval);
			} else if (p instanceof InstanceReferenceValue) {
				Expr ref = createInstanceObjectReference(((InstanceReferenceValue) p).getReferencedInstanceObject());
				call.getArgs().add(ref);
			}
		}
	}

	static private ResoluteResultContentProvider resoluteContent = new ResoluteResultContentProvider();

	private Result doResoluteResults(ResoluteResult resRes) {
		if (resRes instanceof ClaimResult) {
			Result ri = null;
			ClaimResult rr = (ClaimResult) resRes;
			if (rr.isValid()) {
				ri = ResultUtil.createSuccessResult(rr.getText(), rr.getLocation());
			} else {
				ri = ResultUtil.createFailureResult(rr.getText(), rr.getLocation());
			}
			Object[] subrrs = resoluteContent.getChildren(rr);
			for (Object subrr : subrrs) {
				ClaimResult subclaim = (ClaimResult) subrr;
				ri.getSubResults().add(doResoluteResults(subclaim));
			}
			return ri;
		} else if (resRes instanceof ResoluteResult) {
			Result ri = null;
			if (resRes.isValid()) {
				ri = ResultUtil.createSuccessResult("XXX", null);
			} else {
				ri = ResultUtil.createFailureResult("XXX", null);
			}
			return ri;
		}
		return null;
	}

}
