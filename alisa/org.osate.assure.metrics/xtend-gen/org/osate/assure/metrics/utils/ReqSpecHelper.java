package org.osate.assure.metrics.utils;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.osate.aadl2.ComponentClassifier;
import org.osate.assure.metrics.utils.AadlHelper;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.SystemRequirements;

@SuppressWarnings("all")
public class ReqSpecHelper {
  public static ComponentClassifier getRelatedComponentClassifier(final Requirement req) {
    EObject _eContainer = req.eContainer();
    String _plus = ("container" + _eContainer);
    InputOutput.<String>println(_plus);
    ComponentClassifier _target = req.getTarget();
    boolean _equals = Objects.equal(_target, null);
    if (_equals) {
      EObject _eContainer_1 = req.eContainer();
      ComponentClassifier _target_1 = ((SystemRequirements) _eContainer_1).getTarget();
      return ((ComponentClassifier) _target_1);
    }
    return null;
  }
  
  public static int getCoverageLevel(final Requirement req, final ComponentClassifier cl) {
    final ComponentClassifier cc = ReqSpecHelper.getRelatedComponentClassifier(req);
    boolean _equals = Objects.equal(cc, null);
    if (_equals) {
      return (-1);
    }
    boolean _equals_1 = Objects.equal(cc, cl);
    if (_equals_1) {
      return 1;
    }
    boolean _isSubcomponent = AadlHelper.isSubcomponent(cc, cl);
    if (_isSubcomponent) {
      return 2;
    }
    return 0;
  }
}
