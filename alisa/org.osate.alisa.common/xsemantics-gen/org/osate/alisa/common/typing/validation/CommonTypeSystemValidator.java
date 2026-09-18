package org.osate.alisa.common.typing.validation;

import com.google.inject.Inject;
import org.eclipse.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xtext.validation.Check;
import org.osate.aadl2.PropertyExpression;
import org.osate.alisa.common.common.ValDeclaration;
import org.osate.alisa.common.typing.CommonTypeSystem;
import org.osate.alisa.common.validation.AbstractCommonValidator;

@SuppressWarnings("all")
public class CommonTypeSystemValidator extends AbstractCommonValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;

  @Inject
  protected CommonTypeSystem xsemanticsSystem;

  protected CommonTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }

  @Check
  public void checkValDecls(final ValDeclaration valDecl) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkValDecls(valDecl),
    		valDecl);
  }

  @Check
  public void checkExpressions(final PropertyExpression exp) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkExpressions(exp),
    		exp);
  }
}
