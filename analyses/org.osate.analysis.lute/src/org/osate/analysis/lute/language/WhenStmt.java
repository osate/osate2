package org.osate.analysis.lute.language;

import org.osate.analysis.lute.LuteFailure;
import org.osate.analysis.lute.LuteResult;
import org.slf4j.Logger;

public class WhenStmt extends Stmt {
	final private Expr expr;
	final private Stmt body;

	public WhenStmt(Expr expr, Stmt body) {
		super();
		this.expr = expr;
		this.body = body;
	}

	@Override
	public int exec(Environment env, Logger log) throws LuteFailure{ 
		if (expr.eval(env).getBool()) {
			return body.exec(env, log);
		} else {
			return 0;
		}
	}
}
