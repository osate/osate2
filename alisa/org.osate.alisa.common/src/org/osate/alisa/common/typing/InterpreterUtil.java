package org.osate.alisa.common.typing;

import com.google.common.base.Objects;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.UnitLiteral;

@SuppressWarnings("all")
public class InterpreterUtil {
  public static UnitLiteral smallerUnit(final UnitLiteral unit1, final UnitLiteral unit2) {
    UnitLiteral _xifexpression = null;
    boolean _or = false;
    boolean _equals = Objects.equal(unit1, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = Objects.equal(unit2, null);
      _or = _equals_1;
    }
    if (_or) {
      _xifexpression = null;
    } else {
      UnitLiteral _xifexpression_1 = null;
      boolean _equals_2 = Objects.equal(unit1, unit2);
      if (_equals_2) {
        _xifexpression_1 = unit1;
      } else {
        UnitLiteral _xblockexpression = null;
        {
          final RealLiteral tester = Aadl2Factory.eINSTANCE.createRealLiteral();
          tester.setValue(1.0);
          tester.setUnit(unit1);
          UnitLiteral _xifexpression_2 = null;
          double _scaledValue = tester.getScaledValue(unit2);
          boolean _lessThan = (_scaledValue < 1.0);
          if (_lessThan) {
            _xifexpression_2 = unit1;
          } else {
            _xifexpression_2 = unit2;
          }
          _xblockexpression = _xifexpression_2;
        }
        _xifexpression_1 = _xblockexpression;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public static int compareTo(final NumberValue v1, final NumberValue v2) {
    int _xblockexpression = (int) 0;
    {
      UnitLiteral _unit = v1.getUnit();
      UnitLiteral _unit_1 = v2.getUnit();
      final UnitLiteral minUnit = InterpreterUtil.smallerUnit(_unit, _unit_1);
      int _xifexpression = (int) 0;
      boolean _and = false;
      if (!(v1 instanceof IntegerLiteral)) {
        _and = false;
      } else {
        _and = (v2 instanceof IntegerLiteral);
      }
      if (_and) {
        int _xblockexpression_1 = (int) 0;
        {
          long _xifexpression_1 = (long) 0;
          UnitLiteral _unit_2 = v1.getUnit();
          boolean _equals = Objects.equal(_unit_2, null);
          if (_equals) {
            _xifexpression_1 = ((IntegerLiteral) v1).getValue();
          } else {
            double _scaledValue = v1.getScaledValue(minUnit);
            _xifexpression_1 = Math.round(_scaledValue);
          }
          final long s1 = _xifexpression_1;
          long _xifexpression_2 = (long) 0;
          UnitLiteral _unit_3 = v2.getUnit();
          boolean _equals_1 = Objects.equal(_unit_3, null);
          if (_equals_1) {
            _xifexpression_2 = ((IntegerLiteral) v2).getValue();
          } else {
            double _scaledValue_1 = v2.getScaledValue(minUnit);
            _xifexpression_2 = Math.round(_scaledValue_1);
          }
          final long s2 = _xifexpression_2;
          _xblockexpression_1 = Long.valueOf(s1).compareTo(Long.valueOf(s2));
        }
        _xifexpression = _xblockexpression_1;
      } else {
        int _xblockexpression_2 = (int) 0;
        {
          double _xifexpression_1 = (double) 0;
          UnitLiteral _unit_2 = v1.getUnit();
          boolean _equals = Objects.equal(_unit_2, null);
          if (_equals) {
            double _xifexpression_2 = (double) 0;
            if ((v1 instanceof IntegerLiteral)) {
              _xifexpression_2 = ((IntegerLiteral)v1).getValue();
            } else {
              _xifexpression_2 = ((RealLiteral) v1).getValue();
            }
            _xifexpression_1 = _xifexpression_2;
          } else {
            _xifexpression_1 = v1.getScaledValue(minUnit);
          }
          final double s1 = _xifexpression_1;
          double _xifexpression_3 = (double) 0;
          UnitLiteral _unit_3 = v2.getUnit();
          boolean _equals_1 = Objects.equal(_unit_3, null);
          if (_equals_1) {
            double _xifexpression_4 = (double) 0;
            if ((v2 instanceof IntegerLiteral)) {
              _xifexpression_4 = ((IntegerLiteral)v2).getValue();
            } else {
              _xifexpression_4 = ((RealLiteral) v2).getValue();
            }
            _xifexpression_3 = _xifexpression_4;
          } else {
            _xifexpression_3 = v2.getScaledValue(minUnit);
          }
          final double s2 = _xifexpression_3;
          _xblockexpression_2 = Double.valueOf(s1).compareTo(Double.valueOf(s2));
        }
        _xifexpression = _xblockexpression_2;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public static NumberValue add(final NumberValue v1, final NumberValue v2) {
    NumberValue _xblockexpression = null;
    {
      UnitLiteral _unit = v1.getUnit();
      UnitLiteral _unit_1 = v2.getUnit();
      final UnitLiteral minUnit = InterpreterUtil.smallerUnit(_unit, _unit_1);
      NumberValue _xifexpression = null;
      boolean _and = false;
      if (!(v1 instanceof IntegerLiteral)) {
        _and = false;
      } else {
        _and = (v2 instanceof IntegerLiteral);
      }
      if (_and) {
        IntegerLiteral _xblockexpression_1 = null;
        {
          long _xifexpression_1 = (long) 0;
          UnitLiteral _unit_2 = v1.getUnit();
          boolean _equals = Objects.equal(_unit_2, null);
          if (_equals) {
            _xifexpression_1 = ((IntegerLiteral) v1).getValue();
          } else {
            double _scaledValue = v1.getScaledValue(minUnit);
            _xifexpression_1 = Math.round(_scaledValue);
          }
          final long s1 = _xifexpression_1;
          long _xifexpression_2 = (long) 0;
          UnitLiteral _unit_3 = v2.getUnit();
          boolean _equals_1 = Objects.equal(_unit_3, null);
          if (_equals_1) {
            _xifexpression_2 = ((IntegerLiteral) v2).getValue();
          } else {
            double _scaledValue_1 = v2.getScaledValue(minUnit);
            _xifexpression_2 = Math.round(_scaledValue_1);
          }
          final long s2 = _xifexpression_2;
          final IntegerLiteral result = Aadl2Factory.eINSTANCE.createIntegerLiteral();
          result.setValue((s1 + s2));
          result.setUnit(minUnit);
          _xblockexpression_1 = result;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        RealLiteral _xblockexpression_2 = null;
        {
          double _xifexpression_1 = (double) 0;
          UnitLiteral _unit_2 = v1.getUnit();
          boolean _equals = Objects.equal(_unit_2, null);
          if (_equals) {
            double _xifexpression_2 = (double) 0;
            if ((v1 instanceof IntegerLiteral)) {
              _xifexpression_2 = ((IntegerLiteral)v1).getValue();
            } else {
              _xifexpression_2 = ((RealLiteral) v1).getValue();
            }
            _xifexpression_1 = _xifexpression_2;
          } else {
            _xifexpression_1 = v1.getScaledValue(minUnit);
          }
          final double s1 = _xifexpression_1;
          double _xifexpression_3 = (double) 0;
          UnitLiteral _unit_3 = v2.getUnit();
          boolean _equals_1 = Objects.equal(_unit_3, null);
          if (_equals_1) {
            double _xifexpression_4 = (double) 0;
            if ((v2 instanceof IntegerLiteral)) {
              _xifexpression_4 = ((IntegerLiteral)v2).getValue();
            } else {
              _xifexpression_4 = ((RealLiteral) v2).getValue();
            }
            _xifexpression_3 = _xifexpression_4;
          } else {
            _xifexpression_3 = v2.getScaledValue(minUnit);
          }
          final double s2 = _xifexpression_3;
          final RealLiteral result = Aadl2Factory.eINSTANCE.createRealLiteral();
          result.setValue((s1 + s2));
          result.setUnit(minUnit);
          _xblockexpression_2 = result;
        }
        _xifexpression = _xblockexpression_2;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public static NumberValue subtract(final NumberValue v1, final NumberValue v2) {
    NumberValue _xifexpression = null;
    if ((v2 instanceof IntegerLiteral)) {
      NumberValue _xblockexpression = null;
      {
        final IntegerLiteral neg = Aadl2Factory.eINSTANCE.createIntegerLiteral();
        long _value = ((IntegerLiteral)v2).getValue();
        long _minus = (-_value);
        neg.setValue(_minus);
        UnitLiteral _unit = ((IntegerLiteral)v2).getUnit();
        neg.setUnit(_unit);
        _xblockexpression = InterpreterUtil.add(v1, neg);
      }
      _xifexpression = _xblockexpression;
    } else {
      NumberValue _xblockexpression_1 = null;
      {
        final RealLiteral neg = Aadl2Factory.eINSTANCE.createRealLiteral();
        double _value = ((RealLiteral) v2).getValue();
        double _minus = (-_value);
        neg.setValue(_minus);
        UnitLiteral _unit = v2.getUnit();
        neg.setUnit(_unit);
        _xblockexpression_1 = InterpreterUtil.add(v1, neg);
      }
      _xifexpression = _xblockexpression_1;
    }
    return _xifexpression;
  }
  
  public static NumberValue multiply(final NumberValue v1, final NumberValue v2) {
    NumberValue _xblockexpression = null;
    {
      UnitLiteral _xifexpression = null;
      UnitLiteral _unit = v1.getUnit();
      boolean _notEquals = (!Objects.equal(_unit, null));
      if (_notEquals) {
        _xifexpression = v1.getUnit();
      } else {
        _xifexpression = v2.getUnit();
      }
      final UnitLiteral unit = _xifexpression;
      NumberValue _xifexpression_1 = null;
      boolean _and = false;
      if (!(v1 instanceof IntegerLiteral)) {
        _and = false;
      } else {
        _and = (v2 instanceof IntegerLiteral);
      }
      if (_and) {
        IntegerLiteral _xblockexpression_1 = null;
        {
          final long s1 = ((IntegerLiteral) v1).getValue();
          final long s2 = ((IntegerLiteral) v2).getValue();
          final IntegerLiteral result = Aadl2Factory.eINSTANCE.createIntegerLiteral();
          result.setValue((s1 * s2));
          result.setUnit(unit);
          _xblockexpression_1 = result;
        }
        _xifexpression_1 = _xblockexpression_1;
      } else {
        RealLiteral _xblockexpression_2 = null;
        {
          double _xifexpression_2 = (double) 0;
          if ((v1 instanceof IntegerLiteral)) {
            _xifexpression_2 = ((IntegerLiteral)v1).getValue();
          } else {
            _xifexpression_2 = ((RealLiteral) v1).getValue();
          }
          final double s1 = _xifexpression_2;
          double _xifexpression_3 = (double) 0;
          if ((v2 instanceof IntegerLiteral)) {
            _xifexpression_3 = ((IntegerLiteral)v2).getValue();
          } else {
            _xifexpression_3 = ((RealLiteral) v2).getValue();
          }
          final double s2 = _xifexpression_3;
          final RealLiteral result = Aadl2Factory.eINSTANCE.createRealLiteral();
          result.setValue((s1 * s2));
          result.setUnit(unit);
          _xblockexpression_2 = result;
        }
        _xifexpression_1 = _xblockexpression_2;
      }
      _xblockexpression = _xifexpression_1;
    }
    return _xblockexpression;
  }
  
  public static RealLiteral divide(final NumberValue v1, final NumberValue v2) {
    RealLiteral _xblockexpression = null;
    {
      UnitLiteral _unit = v1.getUnit();
      UnitLiteral _unit_1 = v2.getUnit();
      final UnitLiteral minUnit = InterpreterUtil.smallerUnit(_unit, _unit_1);
      boolean _and = false;
      UnitLiteral _unit_2 = v1.getUnit();
      boolean _notEquals = (!Objects.equal(_unit_2, null));
      if (!_notEquals) {
        _and = false;
      } else {
        UnitLiteral _unit_3 = v2.getUnit();
        boolean _notEquals_1 = (!Objects.equal(_unit_3, null));
        _and = _notEquals_1;
      }
      final boolean twoUnits = _and;
      UnitLiteral _xifexpression = null;
      UnitLiteral _unit_4 = v1.getUnit();
      boolean _notEquals_2 = (!Objects.equal(_unit_4, null));
      if (_notEquals_2) {
        _xifexpression = v1.getUnit();
      } else {
        _xifexpression = v2.getUnit();
      }
      final UnitLiteral unit = _xifexpression;
      double _xifexpression_1 = (double) 0;
      if ((!twoUnits)) {
        double _xifexpression_2 = (double) 0;
        if ((v1 instanceof IntegerLiteral)) {
          _xifexpression_2 = ((IntegerLiteral)v1).getValue();
        } else {
          _xifexpression_2 = ((RealLiteral) v1).getValue();
        }
        _xifexpression_1 = _xifexpression_2;
      } else {
        _xifexpression_1 = v1.getScaledValue(minUnit);
      }
      final double s1 = _xifexpression_1;
      double _xifexpression_3 = (double) 0;
      if ((!twoUnits)) {
        double _xifexpression_4 = (double) 0;
        if ((v2 instanceof IntegerLiteral)) {
          _xifexpression_4 = ((IntegerLiteral)v2).getValue();
        } else {
          _xifexpression_4 = ((RealLiteral) v2).getValue();
        }
        _xifexpression_3 = _xifexpression_4;
      } else {
        _xifexpression_3 = v2.getScaledValue(minUnit);
      }
      final double s2 = _xifexpression_3;
      final RealLiteral result = Aadl2Factory.eINSTANCE.createRealLiteral();
      result.setValue((s1 / s2));
      UnitLiteral _xifexpression_5 = null;
      if (twoUnits) {
        _xifexpression_5 = minUnit;
      } else {
        _xifexpression_5 = unit;
      }
      result.setUnit(_xifexpression_5);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static IntegerLiteral divideInt(final IntegerLiteral v1, final IntegerLiteral v2) {
    IntegerLiteral _xblockexpression = null;
    {
      UnitLiteral _unit = v1.getUnit();
      UnitLiteral _unit_1 = v2.getUnit();
      final UnitLiteral minUnit = InterpreterUtil.smallerUnit(_unit, _unit_1);
      boolean _and = false;
      UnitLiteral _unit_2 = v1.getUnit();
      boolean _notEquals = (!Objects.equal(_unit_2, null));
      if (!_notEquals) {
        _and = false;
      } else {
        UnitLiteral _unit_3 = v2.getUnit();
        boolean _notEquals_1 = (!Objects.equal(_unit_3, null));
        _and = _notEquals_1;
      }
      final boolean twoUnits = _and;
      UnitLiteral _xifexpression = null;
      UnitLiteral _unit_4 = v1.getUnit();
      boolean _notEquals_2 = (!Objects.equal(_unit_4, null));
      if (_notEquals_2) {
        _xifexpression = v1.getUnit();
      } else {
        _xifexpression = v2.getUnit();
      }
      final UnitLiteral unit = _xifexpression;
      long _xifexpression_1 = (long) 0;
      if ((!twoUnits)) {
        _xifexpression_1 = v1.getValue();
      } else {
        double _scaledValue = v1.getScaledValue(minUnit);
        _xifexpression_1 = Math.round(_scaledValue);
      }
      final long s1 = _xifexpression_1;
      long _xifexpression_2 = (long) 0;
      if ((!twoUnits)) {
        _xifexpression_2 = v2.getValue();
      } else {
        double _scaledValue_1 = v2.getScaledValue(minUnit);
        _xifexpression_2 = Math.round(_scaledValue_1);
      }
      final long s2 = _xifexpression_2;
      final IntegerLiteral result = Aadl2Factory.eINSTANCE.createIntegerLiteral();
      result.setValue((s1 / s2));
      UnitLiteral _xifexpression_3 = null;
      if (twoUnits) {
        _xifexpression_3 = minUnit;
      } else {
        _xifexpression_3 = unit;
      }
      result.setUnit(_xifexpression_3);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static IntegerLiteral mod(final IntegerLiteral v1, final IntegerLiteral v2) {
    IntegerLiteral _xblockexpression = null;
    {
      UnitLiteral _unit = v1.getUnit();
      UnitLiteral _unit_1 = v2.getUnit();
      final UnitLiteral minUnit = InterpreterUtil.smallerUnit(_unit, _unit_1);
      boolean _and = false;
      UnitLiteral _unit_2 = v1.getUnit();
      boolean _notEquals = (!Objects.equal(_unit_2, null));
      if (!_notEquals) {
        _and = false;
      } else {
        UnitLiteral _unit_3 = v2.getUnit();
        boolean _notEquals_1 = (!Objects.equal(_unit_3, null));
        _and = _notEquals_1;
      }
      final boolean twoUnits = _and;
      UnitLiteral _xifexpression = null;
      UnitLiteral _unit_4 = v1.getUnit();
      boolean _notEquals_2 = (!Objects.equal(_unit_4, null));
      if (_notEquals_2) {
        _xifexpression = v1.getUnit();
      } else {
        _xifexpression = v2.getUnit();
      }
      final UnitLiteral unit = _xifexpression;
      long _xifexpression_1 = (long) 0;
      if ((!twoUnits)) {
        _xifexpression_1 = v1.getValue();
      } else {
        double _scaledValue = v1.getScaledValue(minUnit);
        _xifexpression_1 = Math.round(_scaledValue);
      }
      final long s1 = _xifexpression_1;
      long _xifexpression_2 = (long) 0;
      if ((!twoUnits)) {
        _xifexpression_2 = v2.getValue();
      } else {
        double _scaledValue_1 = v2.getScaledValue(minUnit);
        _xifexpression_2 = Math.round(_scaledValue_1);
      }
      final long s2 = _xifexpression_2;
      final IntegerLiteral result = Aadl2Factory.eINSTANCE.createIntegerLiteral();
      result.setValue((s1 % s2));
      UnitLiteral _xifexpression_3 = null;
      if (twoUnits) {
        _xifexpression_3 = minUnit;
      } else {
        _xifexpression_3 = unit;
      }
      result.setUnit(_xifexpression_3);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
}
