package org.osate.alisa.common.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
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
}
