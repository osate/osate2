package org.osate.alisa.common.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.osate.alisa.common.typing.CommonTypeSystem;

@SuppressWarnings("all")
public class CommonTypeSystemValidator extends AbstractDeclarativeValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Inject
  protected CommonTypeSystem xsemanticsSystem;
  
  protected CommonTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
