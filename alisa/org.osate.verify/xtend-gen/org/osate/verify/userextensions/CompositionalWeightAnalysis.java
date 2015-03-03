package org.osate.verify.userextensions;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.xtext.aadl2.properties.util.GetProperties;

@SuppressWarnings("all")
public class CompositionalWeightAnalysis {
  /**
   * sum up weight limits of direct subcomponents
   */
  public static double sumSubWeightLimits(final ComponentInstance ci) {
    EList<ComponentInstance> _componentInstances = ci.getComponentInstances();
    final Function1<ComponentInstance, Double> _function = new Function1<ComponentInstance, Double>() {
      public Double apply(final ComponentInstance it) {
        return Double.valueOf(GetProperties.getWeightLimit(it, 0.0));
      }
    };
    List<Double> _map = ListExtensions.<ComponentInstance, Double>map(_componentInstances, _function);
    return CompositionalWeightAnalysis.sum(_map);
  }
  
  public static double sum(final List<Double> doublecollection) {
    final Function2<Double, Double, Double> _function = new Function2<Double, Double, Double>() {
      public Double apply(final Double a, final Double b) {
        return Double.valueOf(DoubleExtensions.operator_plus(a, b));
      }
    };
    return (double) IterableExtensions.<Double, Double>fold(doublecollection, Double.valueOf(0.0), _function);
  }
  
  public static double WeightLimitReserve(final ComponentInstance ci) {
    EList<ComponentInstance> _componentInstances = ci.getComponentInstances();
    boolean _isEmpty = _componentInstances.isEmpty();
    if (_isEmpty) {
      return 0.0;
    }
    double _weightLimit = GetProperties.getWeightLimit(ci, 0.0);
    double _sumSubWeightLimits = CompositionalWeightAnalysis.sumSubWeightLimits(ci);
    return (_weightLimit - _sumSubWeightLimits);
  }
  
  public static boolean WeightLimitInvariant(final ComponentInstance ci) {
    EList<ComponentInstance> _componentInstances = ci.getComponentInstances();
    boolean _isEmpty = _componentInstances.isEmpty();
    if (_isEmpty) {
      return true;
    }
    double _weightLimit = GetProperties.getWeightLimit(ci, 0.0);
    double _sumSubWeightLimits = CompositionalWeightAnalysis.sumSubWeightLimits(ci);
    return (_weightLimit == _sumSubWeightLimits);
  }
  
  public static int subsWithWeightLimit(final ComponentInstance ci) {
    EList<ComponentInstance> _componentInstances = ci.getComponentInstances();
    boolean _isEmpty = _componentInstances.isEmpty();
    if (_isEmpty) {
      return (-1);
    }
    EList<ComponentInstance> _componentInstances_1 = ci.getComponentInstances();
    final Function1<ComponentInstance, Boolean> _function = new Function1<ComponentInstance, Boolean>() {
      public Boolean apply(final ComponentInstance it) {
        return Boolean.valueOf(GetProperties.hasAssignedPropertyValue(it, "SEI::WeightLimit"));
      }
    };
    Iterable<ComponentInstance> _filter = IterableExtensions.<ComponentInstance>filter(_componentInstances_1, _function);
    return ((Object[])Conversions.unwrapArray(_filter, Object.class)).length;
  }
  
  public static boolean assumeWithWeightLimit(final ComponentInstance ci) {
    boolean _xblockexpression = false;
    {
      final int count = CompositionalWeightAnalysis.subsWithWeightLimit(ci);
      if ((count < 0)) {
        return true;
      }
      EList<ComponentInstance> _componentInstances = ci.getComponentInstances();
      final int sz = ((Object[])Conversions.unwrapArray(_componentInstances, Object.class)).length;
      final int ratio = ((count * 100) / sz);
      String _plus = (Integer.valueOf(ratio) + "% of ");
      String _name = ci.getName();
      String _plus_1 = (_plus + _name);
      String _plus_2 = (_plus_1 + " subcomponents without weight limit");
      Assert.assertEquals(_plus_2, count, sz);
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public static double sumAllWeightLimits(final ComponentInstance ci) {
    EList<ComponentInstance> _allComponentInstances = ci.getAllComponentInstances();
    final Function1<ComponentInstance, Double> _function = new Function1<ComponentInstance, Double>() {
      public Double apply(final ComponentInstance it) {
        return Double.valueOf(GetProperties.getWeightLimit(it, 0.0));
      }
    };
    List<Double> _map = ListExtensions.<ComponentInstance, Double>map(_allComponentInstances, _function);
    return CompositionalWeightAnalysis.sum(_map);
  }
}
