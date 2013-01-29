package org.osate.analysis.lute.language;

import org.osate.analysis.lute.LuteResult;
import org.osate.analysis.lute.utils.Logger;

public class WhenStmt extends Stmt {
	final private Expr expr;
	final private Stmt body;

	public WhenStmt(Expr expr, Stmt body) {
		super();
		this.expr = expr;
		this.body = body;
	}

	@Override
	public LuteResult exec(Environment env, Logger log) {
		if (expr.eval(env).getBool()) {
			return body.exec(env, log);
		} else {
			return LuteResult.empty();
		}
	}
}
