package org.osate.verify.typing.validation;

import com.google.inject.Inject;
import org.eclipse.xtext.validation.Check;
import org.osate.alisa.common.typing.validation.CommonTypeSystemValidator;
import org.osate.verify.typing.VerifyTypeSystem;
import org.osate.verify.verify.VerificationActivity;

@SuppressWarnings("all")
public class VerifyTypeSystemValidator extends CommonTypeSystemValidator {
  @Inject
  protected VerifyTypeSystem xsemanticsSystem;
  
  @Override
  protected VerifyTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
  
  @Check
  public void checkActivityCalls(final VerificationActivity activity) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkActivityCalls(activity),
    		activity);
  }
}
