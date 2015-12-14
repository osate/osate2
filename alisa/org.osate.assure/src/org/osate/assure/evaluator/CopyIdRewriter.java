package org.osate.assure.evaluator;

import jkind.lustre.IdExpr;

public interface CopyIdRewriter {
    public IdExpr rewrite(IdExpr id);
}
