package org.osate.expr.evaluation.validation;

import com.google.inject.Inject;
import org.eclipse.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.osate.expr.evaluation.ExprInterpreter;

@SuppressWarnings("all")
public class ExprInterpreterValidator extends AbstractDeclarativeValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Inject
  protected ExprInterpreter xsemanticsSystem;
  
  protected ExprInterpreter getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
