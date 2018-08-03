package org.osate.assure.metrics.utils;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;

@SuppressWarnings("all")
public class AadlHelper {
  public static boolean isSubcomponent(final ComponentClassifier parent, final ComponentClassifier lookFor) {
    boolean _equals = Objects.equal(parent, lookFor);
    if (_equals) {
      return true;
    }
    if ((parent instanceof ComponentImplementation)) {
      EList<Subcomponent> _allSubcomponents = ((ComponentImplementation)parent).getAllSubcomponents();
      for (final Subcomponent sc : _allSubcomponents) {
        ComponentClassifier _classifier = sc.getClassifier();
        boolean _isSubcomponent = AadlHelper.isSubcomponent(_classifier, lookFor);
        if (_isSubcomponent) {
          return true;
        }
      }
    }
    return false;
  }
}
