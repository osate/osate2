package org.osate.expr.evaluation;

import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.expr.expr.Assertion;
import org.osate.expr.expr.EBooleanLiteral;
import org.osate.expr.expr.EDeclaration;
import org.osate.expr.expr.ExprSubclause;
import org.osate.expr.expr.Value;

import com.google.inject.Inject;

public class ExprProcessor {

	@Inject
	ExprInterpreter interpreter;

	@Inject
	RuleEnvironment env;

	public void evaluateExpr(ComponentInstance ci) {
		// evaluate local asserts
		Classifier c = ci.getComponentClassifier();
		for (AnnexSubclause as : c.getOwnedAnnexSubclauses()) {
			if (as.getName().equalsIgnoreCase("expr")) {
				ExprSubclause es = (ExprSubclause) ((DefaultAnnexSubclause) as).getParsedAnnexSubclause();
				if (es == null) {
					System.out.println("ERROR: expr subclause is not parsed");
				}
				evaluateExprSubclause(ci, es);
			}
		}
	}

	void evaluateExprSubclause(ComponentInstance ci, ExprSubclause es) {
		for (EDeclaration decl : es.getDecls()) {
			if (decl instanceof Assertion) {
				try {
					Assertion a = (Assertion) decl;
					System.out.println("evaluating assertion " + ci.getQualifiedName() + "." + a.getName());
					boolean result = evaluateAssertion(ci, a);
					System.out.println(" => " + result);
				} catch (RuleFailedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	boolean evaluateAssertion(ComponentInstance ci, Assertion a) {
		env.add("component", ci);
		Result<Value> result = interpreter.interpretExpression(env, a.getAssert());
		if (result.failed()) {
			throw result.getRuleFailedException();
		}
		return ((EBooleanLiteral) result.getValue()).isValue();
	}

}
