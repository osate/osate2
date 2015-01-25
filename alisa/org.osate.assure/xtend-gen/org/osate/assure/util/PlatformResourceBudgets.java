package org.osate.assure.util;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
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
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
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
  public void evaluateSubBudget(final ComponentInstance ne, final Function1<? super Double, ? extends Boolean> pred) {
    final double actualBudget = this.sumSubBudgets(ne);
    String _name = ne.getName();
    String _plus = (_name + " is over budget ");
    String _plus_1 = (_plus + Double.valueOf(actualBudget));
    Boolean _apply = pred.apply(Double.valueOf(actualBudget));
    Assert.assertTrue(_plus_1, (_apply).booleanValue());
  }
  
  public void assertSumSubBudgets(final ComponentInstance root) {
    final double BudgetLimit = 0.5;
    final String Description = ("R1: Sub budgets must be within " + Double.valueOf(BudgetLimit));
    final Function1<Double, Boolean> _function = new Function1<Double, Boolean>() {
      public Boolean apply(final Double actualBudget) {
        return Boolean.valueOf(((actualBudget).doubleValue() <= BudgetLimit));
      }
    };
    this.evaluateSubBudget(root, _function);
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
  
  public void dispatchVerificationMethod(final String methodPath, final InstanceObject target) {
    if ((target instanceof ComponentInstance)) {
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(methodPath, "org.osate.assure.util.PlatformResourceBudgets.assertSumSubBudgets")) {
          _matched=true;
          this.assertSumSubBudgets(((ComponentInstance)target));
        }
      }
      if (!_matched) {
        if (Objects.equal(methodPath, "org.osate.assure.util.PlatformResourceBudgets.sumSubBudgets")) {
          _matched=true;
          this.sumSubBudgets(((ComponentInstance)target));
        }
      }
    }
  }
}
