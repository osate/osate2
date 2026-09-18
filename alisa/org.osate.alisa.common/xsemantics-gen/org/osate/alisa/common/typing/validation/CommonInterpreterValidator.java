package org.osate.alisa.common.typing.validation;

import com.google.inject.Inject;
import org.eclipse.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.osate.alisa.common.typing.CommonInterpreter;

@SuppressWarnings("all")
public class CommonInterpreterValidator extends AbstractDeclarativeValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;

  @Inject
  protected CommonInterpreter xsemanticsSystem;

  protected CommonInterpreter getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
