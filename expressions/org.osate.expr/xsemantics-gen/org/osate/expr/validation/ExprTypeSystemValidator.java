package org.osate.expr.validation;

import com.google.inject.Inject;
import org.eclipse.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xtext.validation.Check;
import org.osate.expr.ExprTypeSystem;
import org.osate.expr.expr.Expression;
import org.osate.expr.expr.VarDecl;
import org.osate.expr.validation.AbstractExprJavaValidator;

@SuppressWarnings("all")
public class ExprTypeSystemValidator extends AbstractExprJavaValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Inject
  protected ExprTypeSystem xsemanticsSystem;
  
  protected ExprTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
  
  @Check
  public void checkVarDecls(final VarDecl varDecl) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkVarDecls(varDecl),
    		varDecl);
  }
  
  @Check
  public void checkExpressions(final Expression exp) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkExpressions(exp),
    		exp);
  }
}
