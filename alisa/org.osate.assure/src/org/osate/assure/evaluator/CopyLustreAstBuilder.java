package org.osate.assure.evaluator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.rockwellcollins.atc.agree.agree.AssumeStatement;
import com.rockwellcollins.atc.agree.agree.LemmaStatement;
import com.rockwellcollins.atc.agree.analysis.Activator;
import com.rockwellcollins.atc.agree.analysis.AgreeException;
import com.rockwellcollins.atc.agree.analysis.AgreeUtils;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeASTBuilder;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeConnection;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeNode;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeNode.TimingModel;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeProgram;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeStatement;
import com.rockwellcollins.atc.agree.analysis.ast.AgreeVar;
import com.rockwellcollins.atc.agree.analysis.preferences.PreferenceConstants;

import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
import jkind.lustre.BoolExpr;
import jkind.lustre.CondactExpr;
import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.IfThenElseExpr;
import jkind.lustre.IntExpr;
import jkind.lustre.NamedType;
import jkind.lustre.Node;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.Program;
import jkind.lustre.RecordType;
import jkind.lustre.TupleExpr;
import jkind.lustre.Type;
import jkind.lustre.TypeDef;
import jkind.lustre.UnaryExpr;
import jkind.lustre.UnaryOp;
import jkind.lustre.VarDecl;
import jkind.lustre.builders.NodeBuilder;

public class CopyLustreAstBuilder {

	protected static List<Node> nodes;
	protected static final String guarSuffix = "__GUARANTEE";
	protected static final String assumeSuffix = "__ASSUME";
	protected static final String lemmaSuffix = "__LEMMA";

	public static Program getRealizabilityLustreProgram(AgreeProgram agreeProgram) {

		List<TypeDef> types = new ArrayList<>();
		for (Type type : agreeProgram.globalTypes) {
			RecordType recType = (RecordType) type;
			types.add(new TypeDef(recType.id, type));
		}

		List<Expr> assertions = new ArrayList<>();
		List<VarDecl> locals = new ArrayList<>();
		List<VarDecl> inputs = new ArrayList<>();
		List<Equation> equations = new ArrayList<>();
		List<String> properties = new ArrayList<>();

		AgreeNode topNode = agreeProgram.topNode;

		for (AgreeStatement assumption : topNode.assumptions) {
			assertions.add(assumption.expr);
		}

		int i = 0;

		for (AgreeStatement guarantee : topNode.guarantees) {
			String guarName = guarSuffix + i++;
			locals.add(new AgreeVar(guarName, NamedType.BOOL, guarantee.reference, topNode.compInst));
			equations.add(new Equation(new IdExpr(guarName), guarantee.expr));
			properties.add(guarName);
		}

		List<String> inputStrs = new ArrayList<>();
		for (AgreeVar var : topNode.inputs) {
			inputs.add(var);
			inputStrs.add(var.id);
		}

		for (AgreeVar var : topNode.outputs) {
			inputs.add(var);
		}

		// perhaps we should break out eq statements into implementation
		// equations
		// and type equations. This would clear this up
		for (AgreeStatement statement : topNode.assertions) {
			if (AgreeUtils.statementIsContractEqOrProperty(statement)) {

				// this is a strange hack we have to do. we have to make
				// equation and property
				// statements not assertions. They should all be binary
				// expressions with an
				// equals operator. We will need to removing their corresponding
				// variable
				// from the inputs and add them to the local variables
				BinaryExpr binExpr = (BinaryExpr) statement.expr;
				IdExpr varId = (IdExpr) binExpr.left;

				boolean found = false;
				int index;
				for (index = 0; index < inputs.size(); index++) {
					VarDecl var = inputs.get(index);
					if (var.id.equals(varId.id)) {
						found = true;
						break;
					}

				}
				if (!found || binExpr.op != BinaryOp.EQUAL) {
					throw new AgreeException(
							"Something went very wrong with the lustre generation in the realizability analysis");
				}
				locals.add(inputs.remove(index));
				equations.add(new Equation(varId, binExpr.right));
			}
		}

		NodeBuilder builder = new NodeBuilder("main");
		builder.addInputs(inputs);
		builder.addLocals(locals);
		builder.addEquations(equations);
		builder.addProperties(properties);
		builder.addAssertions(assertions);
		builder.setRealizabilityInputs(inputStrs);

		Node main = builder.build();
		List<Node> nodes = new ArrayList<>();
		nodes.add(main);
		nodes.addAll(agreeProgram.globalLustreNodes);
		Program program = new Program(types, null, nodes, main.id);

		return program;

	}

	public static Program getAssumeGuaranteeLustreProgram(AgreeProgram agreeProgram, boolean monolithic) {

		nodes = new ArrayList<>();
		List<TypeDef> types = new ArrayList<>();
		for (Type type : agreeProgram.globalTypes) {
			RecordType recType = (RecordType) type;
			types.add(new TypeDef(recType.id, type));
		}

		AgreeNode flatNode = flattenAgreeNode(agreeProgram.topNode, "_TOP__", monolithic);
		List<Expr> assertions = new ArrayList<>();
		List<VarDecl> locals = new ArrayList<>();
		List<VarDecl> inputs = new ArrayList<>();
		List<Equation> equations = new ArrayList<>();
		List<String> properties = new ArrayList<>();

		for (AgreeStatement assumption : flatNode.assumptions) {
			assertions.add(assumption.expr);
		}

		for (AgreeStatement assertion : flatNode.assertions) {
			assertions.add(assertion.expr);
		}

		int i = 0;
		for (AgreeStatement guarantee : flatNode.lemmas) {
			String guarName = guarSuffix + i++;
			locals.add(new AgreeVar(guarName, NamedType.BOOL, guarantee.reference, flatNode.compInst));
			equations.add(new Equation(new IdExpr(guarName), guarantee.expr));
			properties.add(guarName);
		}

		for (AgreeStatement guarantee : flatNode.guarantees) {
			String guarName = guarSuffix + i++;
			locals.add(new AgreeVar(guarName, NamedType.BOOL, guarantee.reference, flatNode.compInst));
			equations.add(new Equation(new IdExpr(guarName), guarantee.expr));
			properties.add(guarName);
		}

		for (AgreeVar var : flatNode.inputs) {
			inputs.add(var);
		}

		for (AgreeVar var : flatNode.outputs) {
			if (var.reference instanceof AssumeStatement || var.reference instanceof LemmaStatement) {
				properties.add(var.id);
			}
			inputs.add(var);
		}

		NodeBuilder builder = new NodeBuilder("main");
		builder.addInputs(inputs);
		builder.addLocals(locals);
		builder.addEquations(equations);
		builder.addProperties(properties);
		builder.addAssertions(assertions);

		Node main = builder.build();
		nodes.add(main);
		nodes.addAll(agreeProgram.globalLustreNodes);
		Program program = new Program(types, null, nodes, main.id);

		return program;

	}

	public static List<Pair<String, Program>> getConsistencyChecks(AgreeProgram agreeProgram, boolean monolithic) {

		List<Pair<String, Program>> programs = new ArrayList<>();
		List<TypeDef> types = new ArrayList<>();
		for (Type type : agreeProgram.globalTypes) {
			RecordType recType = (RecordType) type;
			types.add(new TypeDef(recType.id, type));
		}

		nodes = new ArrayList<>();
		Node topConsist = getConsistencyLustreNode(agreeProgram.topNode, false);
		// we don't want node lemmas to show up in the consistency check
		for (Node node : agreeProgram.globalLustreNodes) {
			nodes.add(removeProperties(node));
		}
		nodes.add(topConsist);

		Program topConsistProg = new Program(types, null, nodes, topConsist.id);

		programs.add(Tuples.create("This component consistent", topConsistProg));

		for (AgreeNode subNode : agreeProgram.topNode.subNodes) {
			nodes = new ArrayList<>();
			if (monolithic) {
				subNode = flattenAgreeNode(subNode, "_TOP__", true);
			}
			Node subConsistNode = getConsistencyLustreNode(subNode, monolithic);
			for (Node node : agreeProgram.globalLustreNodes) {
				nodes.add(removeProperties(node));
			}
			nodes.add(subConsistNode);
			Program subConsistProg = new Program(types, null, nodes, subConsistNode.id);

			programs.add(Tuples.create(subNode.id + " consistent", subConsistProg));
		}

		nodes = new ArrayList<>();
		AgreeNode compositionNode = flattenAgreeNode(agreeProgram.topNode, "_TOP__", monolithic);

		Node topCompositionConsist = getConsistencyLustreNode(compositionNode, true);
		for (Node node : agreeProgram.globalLustreNodes) {
			nodes.add(removeProperties(node));
		}
		// nodes.addAll(agreeProgram.globalLustreNodes);
		nodes.add(topCompositionConsist);

		Program topCompositConsistProg = new Program(types, null, nodes, topCompositionConsist.id);

		programs.add(Tuples.create("Component composition consistent", topCompositConsistProg));

		return programs;
	}

	protected static Node removeProperties(Node node) {
		NodeBuilder builder = new NodeBuilder(node.id);
		builder.addInputs(node.inputs);
		builder.addOutputs(node.outputs);
		builder.addLocals(node.locals);
		builder.addEquations(node.equations);

		return builder.build();
	}

	protected static Node getConsistencyLustreNode(AgreeNode agreeNode, boolean withAssertions) {

		List<Expr> assertions = new ArrayList<>();
		List<VarDecl> locals = new ArrayList<>();
		List<VarDecl> inputs = new ArrayList<>();
		List<Equation> equations = new ArrayList<>();
		List<String> properties = new ArrayList<>();

		Expr stuffConj = new BoolExpr(true);

		for (AgreeStatement assumption : agreeNode.assumptions) {
			stuffConj = new BinaryExpr(stuffConj, BinaryOp.AND, assumption.expr);
		}

		for (AgreeStatement guarantee : agreeNode.guarantees) {
			stuffConj = new BinaryExpr(stuffConj, BinaryOp.AND, guarantee.expr);
		}

		// TODO should we include lemmas in the consistency check?
		// for(AgreeStatement guarantee : agreeNode.lemmas){
		// histConj = new BinaryExpr(histConj, BinaryOp.AND, guarantee.expr);
		// }

		if (withAssertions) {
			for (AgreeStatement assertion : agreeNode.assertions) {
				stuffConj = new BinaryExpr(stuffConj, BinaryOp.AND, assertion.expr);
			}
		} else {
			// perhaps we should break out eq statements into implementation
			// equations
			// and type equations. This would clear this up
			for (AgreeStatement assertion : agreeNode.assertions) {
				if (AgreeUtils.statementIsContractEqOrProperty(assertion)) {
					stuffConj = new BinaryExpr(stuffConj, BinaryOp.AND, assertion.expr);
				}
			}
		}

		for (AgreeVar var : agreeNode.inputs) {
			inputs.add(var);
		}

		for (AgreeVar var : agreeNode.outputs) {
			inputs.add(var);
		}

		EObject classifier = agreeNode.compInst.getComponentClassifier();

		AgreeVar countVar = new AgreeVar("__COUNT", NamedType.INT, null, null);
		AgreeVar stuffVar = new AgreeVar("__STUFF", NamedType.BOOL, null, null);
		AgreeVar histVar = new AgreeVar("__HIST", NamedType.BOOL, null, null);
		AgreeVar propVar = new AgreeVar("__PROP", NamedType.BOOL, classifier, agreeNode.compInst);

		locals.add(countVar);
		locals.add(stuffVar);
		locals.add(histVar);
		locals.add(propVar);

		IdExpr countId = new IdExpr(countVar.id);
		IdExpr stuffId = new IdExpr(stuffVar.id);
		IdExpr histId = new IdExpr(histVar.id);
		IdExpr propId = new IdExpr(propVar.id);

		equations.add(new Equation(stuffId, stuffConj));

		Expr histExpr = new UnaryExpr(UnaryOp.PRE, histId);
		histExpr = new BinaryExpr(histExpr, BinaryOp.AND, stuffId);
		histExpr = new BinaryExpr(stuffId, BinaryOp.ARROW, histExpr);
		equations.add(new Equation(histId, histExpr));

		Expr countExpr = new UnaryExpr(UnaryOp.PRE, countId);
		countExpr = new BinaryExpr(countExpr, BinaryOp.PLUS, new IntExpr(BigInteger.ONE));
		countExpr = new BinaryExpr(new IntExpr(BigInteger.ZERO), BinaryOp.ARROW, countExpr);
		equations.add(new Equation(countId, countExpr));

		IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
		int consistDetph = prefs.getInt(PreferenceConstants.PREF_CONSIST_DEPTH);

		Expr propExpr = new BinaryExpr(countId, BinaryOp.EQUAL, new IntExpr(BigInteger.valueOf(consistDetph)));
		propExpr = new BinaryExpr(propExpr, BinaryOp.AND, histId);
		equations.add(new Equation(propId, new UnaryExpr(UnaryOp.NOT, propExpr)));
		properties.add(propId.id);

		NodeBuilder builder = new NodeBuilder("consistency");
		builder.addInputs(inputs);
		builder.addLocals(locals);
		builder.addEquations(equations);
		builder.addProperties(properties);
		builder.addAssertions(assertions);

		Node node = builder.build();

		return node;

	}

	public static String getRelativeLocation(String location) {
		int dotIndex = location.indexOf(".");
		if (dotIndex < 0) {
			return "";
		}
		return location.substring(dotIndex + 1);
	}

	protected static Equation getHist(IdExpr histId, Expr expr) {
		Expr preHist = new UnaryExpr(UnaryOp.PRE, histId);
		Expr preAndNow = new BinaryExpr(preHist, BinaryOp.AND, expr);
		return new Equation(histId, new BinaryExpr(expr, BinaryOp.ARROW, preAndNow));
	}

	protected static Node getInputLatchingNode(IdExpr clockExpr, List<VarDecl> inputs, String nodeName) {
		List<VarDecl> outputs = new ArrayList<>();
		List<VarDecl> locals = new ArrayList<>();
		List<Equation> equations = new ArrayList<>();

		String clockRiseName = "__RISE";
		locals.add(new VarDecl(clockRiseName, NamedType.BOOL));
		IdExpr clockRiseId = new IdExpr(clockRiseName);

		Expr preClock = new UnaryExpr(UnaryOp.PRE, clockExpr);
		Expr notPreClock = new UnaryExpr(UnaryOp.NOT, preClock);
		Expr clockRise = new BinaryExpr(notPreClock, BinaryOp.AND, clockExpr);
		clockRise = new BinaryExpr(clockExpr, BinaryOp.ARROW, clockRise);

		equations.add(new Equation(clockRiseId, clockRise));

		for (VarDecl var : inputs) {
			String latchName = "latched__" + var.id;
			IdExpr input = new IdExpr(var.id);
			IdExpr latchId = new IdExpr(latchName);
			outputs.add(new VarDecl(latchName, var.type));

			Expr preLatch = new UnaryExpr(UnaryOp.PRE, latchId);
			equations.add(new Equation(latchId,
					new BinaryExpr(input, BinaryOp.ARROW, new IfThenElseExpr(clockRiseId, input, preLatch))));
		}

		inputs.add(new VarDecl(clockExpr.id, NamedType.BOOL));

		NodeBuilder builder = new NodeBuilder(nodeName);
		builder.addInputs(inputs);
		builder.addOutputs(outputs);
		builder.addLocals(locals);
		builder.addEquations(equations);

		return builder.build();
	}

	protected static Node getLustreNode(AgreeNode agreeNode, String nodePrefix, boolean monolithic) {

		List<VarDecl> inputs = new ArrayList<>();
		List<VarDecl> locals = new ArrayList<>();
		List<Equation> equations = new ArrayList<>();
		List<Expr> assertions = new ArrayList<>();

		Expr assumeConjExpr = new BoolExpr(true);
		int i = 0;
		for (AgreeStatement statement : agreeNode.assumptions) {
			String inputName = assumeSuffix + i++;
			inputs.add(new AgreeVar(inputName, NamedType.BOOL, statement.reference, agreeNode.compInst));
			IdExpr assumeId = new IdExpr(inputName);
			assertions.add(new BinaryExpr(assumeId, BinaryOp.EQUAL, statement.expr));
			assumeConjExpr = new BinaryExpr(assumeId, BinaryOp.AND, assumeConjExpr);
		}

		int j = 0;
		if (monolithic) {
			for (AgreeStatement statement : agreeNode.lemmas) {
				String inputName = lemmaSuffix + j++;
				inputs.add(new AgreeVar(inputName, NamedType.BOOL, statement.reference, agreeNode.compInst));
				IdExpr lemmaId = new IdExpr(inputName);
				assertions.add(new BinaryExpr(lemmaId, BinaryOp.EQUAL, statement.expr));
			}
		}

		String assumeHistName = assumeSuffix + "__HIST";
		String assumeConjName = assumeSuffix + "__CONJ";
		IdExpr assumeHistId = new IdExpr(assumeHistName);
		IdExpr assumeConjId = new IdExpr(assumeConjName);

		locals.add(new VarDecl(assumeHistName, NamedType.BOOL));
		locals.add(new VarDecl(assumeConjName, NamedType.BOOL));

		equations.add(new Equation(assumeConjId, assumeConjExpr));
		equations.add(getHist(assumeHistId, assumeConjId));

		Expr guarConjExpr = new BoolExpr(true);
		for (AgreeStatement statement : agreeNode.guarantees) {
			guarConjExpr = new BinaryExpr(statement.expr, BinaryOp.AND, guarConjExpr);
		}
		if (monolithic) {
			for (AgreeStatement statement : agreeNode.lemmas) {
				guarConjExpr = new BinaryExpr(statement.expr, BinaryOp.AND, guarConjExpr);
			}
		}
		assertions.add(new BinaryExpr(assumeHistId, BinaryOp.IMPLIES, guarConjExpr));

		// we only add the assertions of an agreenode if we are performing
		// monolithic verification. However, we should add EQ statements
		// with left hand sides which part of the agreeNode assertions
		for (AgreeStatement statement : agreeNode.assertions) {
			if (monolithic || AgreeUtils.statementIsContractEqOrProperty(statement)) {
				assertions.add(statement.expr);
			}
		}

		Expr assertExpr = new BoolExpr(true);
		for (Expr expr : assertions) {
			assertExpr = new BinaryExpr(expr, BinaryOp.AND, assertExpr);
		}

		String outputName = "__ASSERT";
		List<VarDecl> outputs = new ArrayList<>();
		outputs.add(new VarDecl(outputName, NamedType.BOOL));
		equations.add(new Equation(new IdExpr(outputName), assertExpr));

		// gather the remaining inputs
		for (AgreeVar var : agreeNode.inputs) {
			inputs.add(var);
		}
		for (AgreeVar var : agreeNode.outputs) {
			inputs.add(var);
		}

		NodeBuilder builder = new NodeBuilder(nodePrefix + agreeNode.id);
		builder.addInputs(inputs);
		builder.addOutputs(outputs);
		builder.addLocals(locals);
		builder.addEquations(equations);

		return builder.build();
	}

	protected static AgreeNode flattenAgreeNode(AgreeNode agreeNode, String nodePrefix, boolean monolithic) {

		List<AgreeVar> inputs = new ArrayList<>();
		List<AgreeVar> outputs = new ArrayList<>();
		List<AgreeVar> locals = new ArrayList<>();
		List<AgreeStatement> assertions = new ArrayList<>();

		Expr someoneTicks = null;
		for (AgreeNode subAgreeNode : agreeNode.subNodes) {
			String prefix = subAgreeNode.id + AgreeASTBuilder.dotChar;
			Expr clockExpr = getClockExpr(agreeNode, subAgreeNode);

			if (someoneTicks == null) {
				someoneTicks = clockExpr;
			} else {
				someoneTicks = new BinaryExpr(someoneTicks, BinaryOp.OR, clockExpr);
			}

			AgreeNode flatNode;
			if (monolithic) {
				flatNode = flattenAgreeNode(subAgreeNode, nodePrefix + subAgreeNode.id + AgreeASTBuilder.dotChar,
						monolithic);
			} else {
				flatNode = subAgreeNode;
			}

			Node lustreNode = addSubNodeLustre(agreeNode, nodePrefix, flatNode, monolithic);

			addInputsAndOutputs(inputs, outputs, flatNode, lustreNode, prefix, monolithic);

			addCondactCall(agreeNode, nodePrefix, inputs, assertions, flatNode, prefix, clockExpr, lustreNode);

			addClockHolds(agreeNode, assertions, flatNode, clockExpr, prefix, lustreNode);

			addInitConstraint(agreeNode, outputs, assertions, flatNode, prefix, clockExpr, lustreNode);

		}

		if (agreeNode.timing == TimingModel.ASYNC) {
			if (someoneTicks == null) {
				throw new AgreeException("Somehow we generated a clock constraint without any clocks."
						+ " Perhaps none of your subcomponents have an agree annex?");
			}
			assertions.add(new AgreeStatement("someone ticks", someoneTicks, null));
		}

		addConnectionConstraints(agreeNode, assertions);

		// add any clock constraints
		assertions.addAll(agreeNode.assertions);
		assertions.add(new AgreeStatement("", agreeNode.clockConstraint, null));
		inputs.addAll(agreeNode.inputs);
		outputs.addAll(agreeNode.outputs);
		locals.addAll(agreeNode.locals);

		return new AgreeNode(agreeNode.id, inputs, outputs, locals, null, agreeNode.subNodes, assertions,
				agreeNode.assumptions, agreeNode.guarantees, agreeNode.lemmas, new BoolExpr(true),
				agreeNode.initialConstraint, agreeNode.clockVar, agreeNode.reference, null, agreeNode.compInst);
	}

	protected static void addConnectionConstraints(AgreeNode agreeNode, List<AgreeStatement> assertions) {
		for (AgreeConnection conn : agreeNode.connections) {
			String destName = conn.destinationNode == null ? "" : conn.destinationNode.id + AgreeASTBuilder.dotChar;
			destName = destName + conn.destinationVarName;

			String sourName = conn.sourceNode == null ? "" : conn.sourceNode.id + AgreeASTBuilder.dotChar;
			sourName = sourName + conn.sourceVarName;

			Expr connExpr;

			if (!conn.delayed) {
				connExpr = new BinaryExpr(new IdExpr(sourName), BinaryOp.EQUAL, new IdExpr(destName));
			} else {
				// we need to get the correct type for the connection
				// we can assume that the source and destination types are
				// the same at this point
				Type type = null;
				for (AgreeVar var : conn.sourceNode.outputs) {
					if (var.id.equals(conn.sourceVarName)) {
						type = var.type;
					}
				}
				if (type == null) {
					throw new AgreeException("Could not find type for variable '" + sourName);
				}
				Expr initExpr = AgreeUtils.getInitValueFromType(type);
				Expr preSource = new UnaryExpr(UnaryOp.PRE, new IdExpr(sourName));
				Expr sourExpr = new BinaryExpr(initExpr, BinaryOp.ARROW, preSource);
				connExpr = new BinaryExpr(sourExpr, BinaryOp.EQUAL, new IdExpr(destName));
			}

			assertions.add(new AgreeStatement("", connExpr, conn.reference));

		}
	}

	protected static void addInitConstraint(AgreeNode agreeNode, List<AgreeVar> outputs,
			List<AgreeStatement> assertions, AgreeNode subAgreeNode, String prefix, Expr clockExpr, Node lustreNode) {
		if (agreeNode.timing != TimingModel.SYNC) {
			String tickedName = subAgreeNode.id + "___TICKED";
			outputs.add(new AgreeVar(tickedName, NamedType.BOOL, null, agreeNode.compInst));
			Expr tickedId = new IdExpr(tickedName);
			Expr preTicked = new UnaryExpr(UnaryOp.PRE, tickedId);
			Expr tickedOrPre = new BinaryExpr(clockExpr, BinaryOp.OR, preTicked);
			Expr initOrTicked = new BinaryExpr(clockExpr, BinaryOp.ARROW, tickedOrPre);
			Expr tickedEq = new BinaryExpr(tickedId, BinaryOp.EQUAL, initOrTicked);

			assertions.add(new AgreeStatement("", tickedEq, null));

			// we have two re-write the ids in the initial expressions
			CopyIdRewriter rewriter = new CopyIdRewriter() {

				@Override
				public IdExpr rewrite(IdExpr id) {
					// TODO Auto-generated method stub
					return new IdExpr(prefix + id.id);
				}
			};
			Expr newInit = subAgreeNode.initialConstraint.accept(new CopyIdRewriteVisitor(rewriter));

			Expr initConstr = new BinaryExpr(new UnaryExpr(UnaryOp.NOT, tickedId), BinaryOp.IMPLIES, newInit);
			assertions.add(new AgreeStatement("", initConstr, null));

			// we also need to add hold expressions for the assumptions and
			// lemmas
			Expr assumeLemmaTrue = new BoolExpr(true);
			for (VarDecl lustreVar : lustreNode.inputs) {
				AgreeVar var = (AgreeVar) lustreVar;
				if (var.reference instanceof AssumeStatement || var.reference instanceof LemmaStatement) {
					assumeLemmaTrue = new BinaryExpr(assumeLemmaTrue, BinaryOp.AND, new IdExpr(prefix + var.id));
				}
			}
			assumeLemmaTrue = new BinaryExpr(new UnaryExpr(UnaryOp.NOT, tickedId), BinaryOp.IMPLIES, assumeLemmaTrue);
			assertions.add(new AgreeStatement("", assumeLemmaTrue, null));

		}
	}

	protected static void addClockHolds(AgreeNode agreeNode, List<AgreeStatement> assertions, AgreeNode subAgreeNode,
			Expr clockExpr, String prefix, Node lustreNode) {
		if (agreeNode.timing != TimingModel.SYNC) {
			Expr hold = new BoolExpr(true);
			for (AgreeVar outVar : subAgreeNode.outputs) {
				Expr varId = new IdExpr(prefix + outVar.id);
				Expr pre = new UnaryExpr(UnaryOp.PRE, varId);
				Expr eqPre = new BinaryExpr(varId, BinaryOp.EQUAL, pre);
				hold = new BinaryExpr(hold, BinaryOp.AND, eqPre);
			}

			for (VarDecl lustreVar : lustreNode.inputs) {
				AgreeVar var = (AgreeVar) lustreVar;
				if (var.reference instanceof AssumeStatement || var.reference instanceof LemmaStatement) {
					Expr varId = new IdExpr(prefix + var.id);
					Expr pre = new UnaryExpr(UnaryOp.PRE, varId);
					Expr eqPre = new BinaryExpr(varId, BinaryOp.EQUAL, pre);
					hold = new BinaryExpr(hold, BinaryOp.AND, eqPre);
				}
			}

			Expr notClock = new UnaryExpr(UnaryOp.NOT, clockExpr);
			Expr notClockHold = new BinaryExpr(notClock, BinaryOp.IMPLIES, hold);
			notClockHold = new BinaryExpr(new BoolExpr(true), BinaryOp.ARROW, notClockHold);
			assertions.add(new AgreeStatement("", notClockHold, null));
		}
	}

	protected static void addCondactCall(AgreeNode agreeNode, String nodePrefix, List<AgreeVar> inputs,
			List<AgreeStatement> assertions, AgreeNode subAgreeNode, String prefix, Expr clockExpr, Node lustreNode) {
		List<Expr> inputIds = new ArrayList<>();
		for (VarDecl var : lustreNode.inputs) {
			inputIds.add(new IdExpr(prefix + var.id));
		}

		if (agreeNode.timing == TimingModel.LATCHED) {
			addLatchedConstraints(nodePrefix, inputs, assertions, subAgreeNode, prefix, inputIds);
		}

		Expr condactExpr = new CondactExpr(clockExpr, new NodeCallExpr(lustreNode.id, inputIds),
				Collections.singletonList(new BoolExpr(true)));

		AgreeStatement condactCall = new AgreeStatement("", condactExpr, null);
		assertions.add(condactCall);
	}

	protected static void addInputsAndOutputs(List<AgreeVar> inputs, List<AgreeVar> outputs, AgreeNode subAgreeNode,
			Node lustreNode, String prefix, boolean monolithic) {
		int varCount = 0;
		for (AgreeVar var : subAgreeNode.inputs) {
			varCount++;
			AgreeVar input = new AgreeVar(prefix + var.id, var.type, var.reference, var.compInst);
			inputs.add(input);
		}

		for (AgreeVar var : subAgreeNode.outputs) {
			varCount++;
			AgreeVar output = new AgreeVar(prefix + var.id, var.type, var.reference, var.compInst);
			outputs.add(output);
		}

		// right now we do not support local variables in our translation
		for (AgreeVar var : subAgreeNode.locals) {
			varCount++;
			AgreeVar local = new AgreeVar(prefix + var.id, var.type, var.reference, var.compInst);
			outputs.add(local);
		}

		int i = 0;
		for (AgreeStatement statement : subAgreeNode.assumptions) {
			varCount++;
			AgreeVar output = new AgreeVar(prefix + assumeSuffix + i++, NamedType.BOOL, statement.reference,
					subAgreeNode.compInst);
			outputs.add(output);
		}

		int j = 0;
		if (monolithic) {
			for (AgreeStatement statement : subAgreeNode.lemmas) {
				varCount++;
				AgreeVar output = new AgreeVar(prefix + lemmaSuffix + j++, NamedType.BOOL, statement.reference,
						subAgreeNode.compInst);
				outputs.add(output);
			}
		}

		inputs.add(subAgreeNode.clockVar);

		if (lustreNode.inputs.size() != varCount) {
			throw new AgreeException("Something went wrong during node flattening");
		}
	}

	protected static Node addSubNodeLustre(AgreeNode agreeNode, String nodePrefix, AgreeNode flatNode,
			boolean monolithic) {

		Node lustreNode = getLustreNode(flatNode, nodePrefix, monolithic);
		addToNodes(lustreNode);
		return lustreNode;
	}

	protected static void addLatchedConstraints(String nodePrefix, List<AgreeVar> inputs,
			List<AgreeStatement> assertions, AgreeNode subAgreeNode, String prefix, List<Expr> inputIds) {
		String latchNodeString = nodePrefix + subAgreeNode.id + "__LATCHED_INPUTS";

		List<Expr> nonLatchedInputs = new ArrayList<>();
		List<Expr> latchedInputs = new ArrayList<>();
		List<VarDecl> latchedVars = new ArrayList<>();
		for (AgreeVar var : subAgreeNode.inputs) {
			String latchedName = prefix + "latched___" + var.id;
			AgreeVar latchedVar = new AgreeVar(latchedName, var.type, var.reference, subAgreeNode.compInst);
			inputs.add(latchedVar);
			latchedVars.add(latchedVar);
			nonLatchedInputs.add(new IdExpr(prefix + var.id));
			latchedInputs.add(new IdExpr(latchedName));
		}

		// have to add the clock variable to the node call as well
		nonLatchedInputs.add(new IdExpr(subAgreeNode.clockVar.id));
		Node latchNode = getInputLatchingNode(new IdExpr(subAgreeNode.clockVar.id), latchedVars, latchNodeString);

		addToNodes(latchNode);
		NodeCallExpr latchedNodeCall = new NodeCallExpr(latchNodeString, nonLatchedInputs);
		Expr latchedInputEq;
		if (latchedInputs.size() != 1) {
			latchedInputEq = new TupleExpr(latchedInputs);
		} else {
			latchedInputEq = latchedInputs.get(0);
		}
		latchedInputEq = new BinaryExpr(latchedInputEq, BinaryOp.EQUAL, latchedNodeCall);
		assertions.add(new AgreeStatement("", latchedInputEq, null));

		// remove the references to the non-latched inputs
		List<Expr> inputIdsReplace = new ArrayList<>();
		for (Expr inExpr : inputIds) {
			boolean replaced = false;
			for (AgreeVar var : subAgreeNode.inputs) {
				if (((IdExpr) inExpr).id.equals(prefix + var.id)) {
					inputIdsReplace.add(new IdExpr(prefix + "latched___" + var.id));
					replaced = true;
					break;
				}
			}
			if (!replaced) {
				inputIdsReplace.add(inExpr);
			}
		}

		inputIds.clear();
		inputIds.addAll(inputIdsReplace);
	}

	protected static Expr getClockExpr(AgreeNode agreeNode, AgreeNode subNode) {

		IdExpr clockId = new IdExpr(subNode.clockVar.id);
		switch (agreeNode.timing) {
		case SYNC:
			return new BoolExpr(true);
		case ASYNC:
			return clockId;
		case LATCHED:
			Expr preClock = new UnaryExpr(UnaryOp.PRE, clockId);
			Expr notClock = new UnaryExpr(UnaryOp.NOT, clockId);
			Expr andExpr = new BinaryExpr(preClock, BinaryOp.AND, notClock);
			Expr clockExpr = new BinaryExpr(new BoolExpr(false), BinaryOp.ARROW, andExpr);
			return clockExpr;
		default:
			throw new AgreeException("unhandled timing type: '" + agreeNode.timing + "");
		}

	}

	protected static void addToNodes(Node node) {
		for (Node inList : nodes) {
			if (node.id.equals(inList.id)) {
				throw new AgreeException(
						"AGREE Lustre AST Builder attempted to add multiple nodes of name '" + node.id + "'");
			}
		}
		nodes.add(node);
	}

}
