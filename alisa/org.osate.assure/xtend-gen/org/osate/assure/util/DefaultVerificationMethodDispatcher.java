package org.osate.assure.util;

import com.google.common.base.Objects;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.assure.util.IVerificationMethodDispatcher;
import org.osate.verify.verify.SupportedTypes;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;

@SuppressWarnings("all")
public class DefaultVerificationMethodDispatcher implements IVerificationMethodDispatcher {
  public Object runVerificationMethod(final VerificationActivityResult verificationActivityResult) {
    try {
      Object _xblockexpression = null;
      {
        VerificationActivity _target = verificationActivityResult.getTarget();
        final VerificationMethod method = _target.getMethod();
        Object _xifexpression = null;
        SupportedTypes _methodType = method.getMethodType();
        boolean _equals = Objects.equal(_methodType, SupportedTypes.SINGLEPREDICATE);
        if (_equals) {
          Object _xblockexpression_1 = null;
          {
            final String methodpath = method.getMethodPath();
            Object _xtrycatchfinallyexpression = null;
            try {
              Object _xblockexpression_2 = null;
              {
                InstanceObject _caseSubject = AssureUtilExtension.getCaseSubject(verificationActivityResult);
                final Object res = this.dispatchVerificationMethod(methodpath, _caseSubject);
                AssureUtilExtension.setToSuccess(verificationActivityResult);
                _xblockexpression_2 = res;
              }
              _xtrycatchfinallyexpression = _xblockexpression_2;
            } catch (final Throwable _t) {
              if (_t instanceof AssertionError) {
                final AssertionError e = (AssertionError)_t;
                Object _xblockexpression_3 = null;
                {
                  AssureUtilExtension.setToFail(verificationActivityResult, e);
                  _xblockexpression_3 = null;
                }
                _xtrycatchfinallyexpression = _xblockexpression_3;
              } else if (_t instanceof ThreadDeath) {
                final ThreadDeath e_1 = (ThreadDeath)_t;
                throw e_1;
              } else if (_t instanceof Throwable) {
                final Throwable e_2 = (Throwable)_t;
                Object _xblockexpression_4 = null;
                {
                  AssureUtilExtension.setToError(verificationActivityResult, e_2);
                  _xblockexpression_4 = null;
                }
                _xtrycatchfinallyexpression = _xblockexpression_4;
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
            _xblockexpression_1 = _xtrycatchfinallyexpression;
          }
          _xifexpression = _xblockexpression_1;
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Object dispatchVerificationMethod(final String methodPath, final InstanceObject target) {
    String _qualifiedName = target.getQualifiedName();
    String _plus = ((("Dispatching " + methodPath) + " on ") + _qualifiedName);
    return InputOutput.<Object>println(_plus);
  }
}
