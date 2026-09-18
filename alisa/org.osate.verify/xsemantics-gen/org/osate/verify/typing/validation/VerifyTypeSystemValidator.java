package org.osate.verify.typing.validation;

import com.google.inject.Inject;
import org.eclipse.xtext.validation.Check;
import org.osate.alisa.common.typing.validation.CommonTypeSystemValidator;
import org.osate.verify.typing.VerifyTypeSystem;
import org.osate.verify.verify.FormalParameter;
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
  public void checkVerificationMethodParams(final FormalParameter formal) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkVerificationMethodParams(formal),
    		formal);
  }

  @Check
  public void checkActivityArguments(final VerificationActivity activity) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkActivityArguments(activity),
    		activity);
  }

  @Check
  public void checkActivityReturns(final VerificationActivity activity) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkActivityReturns(activity),
    		activity);
  }

  @Check
  public void checkPropertyTypes(final VerificationActivity activity) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkPropertyTypes(activity),
    		activity);
  }
}
