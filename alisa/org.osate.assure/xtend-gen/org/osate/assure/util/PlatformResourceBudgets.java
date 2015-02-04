package org.osate.assure.util;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.analysis.flows.actions.CheckFlowLatency;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.assure.util.DefaultVerificationMethodDispatcher;
import org.osate.assure.util.IVerificationMethodDispatcher;
import org.osate.xtext.aadl2.properties.util.GetProperties;

@SuppressWarnings("all")
public class PlatformResourceBudgets extends DefaultVerificationMethodDispatcher implements IVerificationMethodDispatcher {
  /**
   * normal constructor
   */
  public PlatformResourceBudgets() {
    super();
  }
  
  /**
   * constructor to initialize to he parameter for JUnit
   */
  public PlatformResourceBudgets(final SystemInstance si) {
    PlatformResourceBudgets.systemInstance = si;
  }
  
  private static SystemInstance systemInstance;
  
  /**
   * sum up MIPS budgets of subcomponent implementations.
   * This variant uses set operations to calculates the sum over the MIPS budgets
   * It works on component implementations on the assumption
   * that each subcomponent has an assigned budget
   */
  public double sumSubBudgets(final ComponentImplementation cimpl) {
    EList<Subcomponent> _allSubcomponents = cimpl.getAllSubcomponents();
    final Function1<Subcomponent, Double> _function = new Function1<Subcomponent, Double>() {
      public Double apply(final Subcomponent it) {
        return Double.valueOf(GetProperties.getMIPSBudgetInMIPS(it, 0.0));
      }
    };
    List<Double> _map = ListExtensions.<Subcomponent, Double>map(_allSubcomponents, _function);
    final Function2<Double, Double, Double> _function_1 = new Function2<Double, Double, Double>() {
      public Double apply(final Double a, final Double b) {
        return Double.valueOf(DoubleExtensions.operator_plus(a, b));
      }
    };
    return (double) IterableExtensions.<Double>reduce(_map, _function_1);
  }
  
  /**
   * sum up MIPS budgets of subcomponent implementations.
   * This variant uses set operations to calculates the sum over the MIPS budgets
   * It works on component implementations on the assumption
   * that each subcomponent has an assigned budget
   */
  public double sumSubBudgets(final ComponentInstance ci) {
    EList<ComponentInstance> _allComponentInstances = ci.getAllComponentInstances();
    final Function1<ComponentInstance, Double> _function = new Function1<ComponentInstance, Double>() {
      public Double apply(final ComponentInstance it) {
        return Double.valueOf(GetProperties.getGrossWeight(it, 0.0));
      }
    };
    List<Double> _map = ListExtensions.<ComponentInstance, Double>map(_allComponentInstances, _function);
    final Function2<Double, Double, Double> _function_1 = new Function2<Double, Double, Double>() {
      public Double apply(final Double a, final Double b) {
        return Double.valueOf(DoubleExtensions.operator_plus(a, b));
      }
    };
    return (double) IterableExtensions.<Double>reduce(_map, _function_1);
  }
  
  /**
   * This method invokes the summation and then evaluates the result against the predicate
   * The predicate is a lambda function with the limit bound to an external value
   */
  public Boolean evaluateSubBudget(final ComponentInstance ne, final Function1<? super Double, ? extends Boolean> pred) {
    boolean _xblockexpression = false;
    {
      final double actualBudget = this.sumSubBudgets(ne);
      String _name = ne.getName();
      String _plus = (_name + " is over budget ");
      String _plus_1 = (_plus + Double.valueOf(actualBudget));
      Boolean _apply = pred.apply(Double.valueOf(actualBudget));
      Assert.assertTrue(_plus_1, (_apply).booleanValue());
      _xblockexpression = true;
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  public Boolean assertSumSubBudgets(final ComponentInstance root) {
    Boolean _xblockexpression = null;
    {
      final double BudgetLimit = 0.5;
      final Function1<Double, Boolean> _function = new Function1<Double, Boolean>() {
        public Boolean apply(final Double actualBudget) {
          return Boolean.valueOf(((actualBudget).doubleValue() <= BudgetLimit));
        }
      };
      _xblockexpression = this.evaluateSubBudget(root, _function);
    }
    return _xblockexpression;
  }
  
  public void assertSumSubBudgetsMax(final ComponentInstance root, final int max) {
    final Function1<Double, Boolean> _function = new Function1<Double, Boolean>() {
      public Boolean apply(final Double actualBudget) {
        return Boolean.valueOf(((actualBudget).doubleValue() <= max));
      }
    };
    this.evaluateSubBudget(root, _function);
  }
  
  @Test
  public void assertSumSubBudgets() {
    this.assertSumSubBudgets(PlatformResourceBudgets.systemInstance);
  }
  
  public boolean validateSubBudgetPrecondition(final NamedElement ne) {
    return true;
  }
  
  public String allFlowLatencyAnalysis(final SystemInstance instance) {
    String _xblockexpression = null;
    {
      final CheckFlowLatency checker = new CheckFlowLatency();
      final String markerType = checker.getMarkerType();
      boolean _hasRun = AssureUtilExtension.getHasRun(markerType, instance);
      boolean _not = (!_hasRun);
      if (_not) {
        EList<SystemOperationMode> _systemOperationModes = instance.getSystemOperationModes();
        final SystemOperationMode som = IterableExtensions.<SystemOperationMode>head(_systemOperationModes);
        try {
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          checker.invoke(_nullProgressMonitor, null, instance, som);
          AssureUtilExtension.setHasRun(markerType, instance);
        } catch (final Throwable _t) {
          if (_t instanceof Throwable) {
            final Throwable e = (Throwable)_t;
            AssureUtilExtension.unsetHasRun(markerType, instance);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      _xblockexpression = markerType;
    }
    return _xblockexpression;
  }
  
  public String flowLatencyAnalysis(final EndToEndFlowInstance etefi) {
    String _xblockexpression = null;
    {
      final CheckFlowLatency checker = new CheckFlowLatency();
      final String markerType = checker.getMarkerType();
      NamedElement _elementRoot = etefi.getElementRoot();
      final SystemInstance instance = ((SystemInstance) _elementRoot);
      boolean _hasRun = AssureUtilExtension.getHasRun(markerType, instance);
      boolean _not = (!_hasRun);
      if (_not) {
        EList<SystemOperationMode> _systemOperationModes = instance.getSystemOperationModes();
        final SystemOperationMode som = IterableExtensions.<SystemOperationMode>head(_systemOperationModes);
        try {
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          checker.invoke(_nullProgressMonitor, null, instance, som);
          AssureUtilExtension.setHasRun(markerType, instance);
        } catch (final Throwable _t) {
          if (_t instanceof Throwable) {
            final Throwable e = (Throwable)_t;
            AssureUtilExtension.unsetHasRun(markerType, instance);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      _xblockexpression = markerType;
    }
    return _xblockexpression;
  }
  
  public Object dispatchVerificationMethod(final String methodPath, final VerificationActivityResult vr) {
    Object _xblockexpression = null;
    {
      final InstanceObject target = AssureUtilExtension.getClaimSubject(vr);
      Object _xifexpression = null;
      if ((target instanceof ComponentInstance)) {
        Object _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(methodPath, "org.osate.assure.util.PlatformResourceBudgets.assertSumSubBudgets")) {
            _matched=true;
            _switchResult = this.assertSumSubBudgets(((ComponentInstance)target));
          }
        }
        if (!_matched) {
          if (Objects.equal(methodPath, "org.osate.assure.util.PlatformResourceBudgets.sumSubBudgets")) {
            _matched=true;
            _switchResult = Double.valueOf(this.sumSubBudgets(((ComponentInstance)target)));
          }
        }
        if (!_matched) {
          if (Objects.equal(methodPath, "org.osate.assure.util.PlatformResourceBudgets.flowLatencyAnalysis")) {
            _matched=true;
            if ((target instanceof SystemInstance)) {
              final String mt = this.allFlowLatencyAnalysis(((SystemInstance)target));
              return Boolean.valueOf(AssureUtilExtension.addAllErrorMarkers(vr, target, mt));
            }
            return null;
          }
        }
        _xifexpression = ((Object)_switchResult);
      } else {
        if ((target instanceof EndToEndFlowInstance)) {
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (Objects.equal(methodPath, "org.osate.assure.util.PlatformResourceBudgets.flowLatencyAnalysis")) {
              _matched_1=true;
              final String mt_1 = this.flowLatencyAnalysis(((EndToEndFlowInstance)target));
              return Boolean.valueOf(AssureUtilExtension.addErrorMarkers(vr, target, mt_1));
            }
          }
        }
      }
      _xblockexpression = ((Object)_xifexpression);
    }
    return ((Comparable<?>)_xblockexpression);
  }
}
