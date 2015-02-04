package org.osate.alisa.common.util;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.osate.aadl2.NamedElement;
import org.osate.alisa.common.common.ConstantDecl;
import org.osate.alisa.common.common.ConstantValue;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.IntegerTerm;
import org.osate.alisa.common.common.RealTerm;
import org.osate.alisa.common.common.ShowValue;
import org.osate.alisa.common.common.StringTerm;

@SuppressWarnings("all")
public class CommonUtilExtension {
  public static String toText(final Description desc, final NamedElement target) {
    EList<DescriptionElement> _description = desc.getDescription();
    final Function1<DescriptionElement, String> _function = new Function1<DescriptionElement, String>() {
      public String apply(final DescriptionElement de) {
        return CommonUtilExtension.toText(de, target);
      }
    };
    List<String> _map = ListExtensions.<DescriptionElement, String>map(_description, _function);
    final Function2<String, String, String> _function_1 = new Function2<String, String, String>() {
      public String apply(final String a, final String b) {
        return (a + b);
      }
    };
    return IterableExtensions.<String>reduce(_map, _function_1);
  }
  
  public static String toText(final DescriptionElement de, final NamedElement target) {
    String _xblockexpression = null;
    {
      String _text = de.getText();
      boolean _notEquals = (!Objects.equal(_text, null));
      if (_notEquals) {
        return de.getText();
      }
      boolean _isNewline = de.isNewline();
      if (_isNewline) {
        return "\n";
      }
      ShowValue _value = de.getValue();
      boolean _notEquals_1 = (!Objects.equal(_value, null));
      if (_notEquals_1) {
        String _elvis = null;
        ShowValue _value_1 = de.getValue();
        ConstantDecl _ref = _value_1.getRef();
        ConstantValue _constantvalue = null;
        if (_ref!=null) {
          _constantvalue=_ref.getConstantvalue();
        }
        String _text_1 = null;
        if (_constantvalue!=null) {
          _text_1=CommonUtilExtension.toText(_constantvalue);
        }
        if (_text_1 != null) {
          _elvis = _text_1;
        } else {
          _elvis = "";
        }
        return _elvis;
      }
      boolean _and = false;
      boolean _isThisTarget = de.isThisTarget();
      if (!_isThisTarget) {
        _and = false;
      } else {
        boolean _notEquals_2 = (!Objects.equal(target, null));
        _and = _notEquals_2;
      }
      if (_and) {
        String nm = target.getName();
        boolean _endsWith = nm.endsWith("_Instance");
        if (_endsWith) {
          int _length = nm.length();
          int _minus = (_length - 9);
          String _substring = nm.substring(0, _minus);
          nm = _substring;
        }
        return nm;
      }
      _xblockexpression = "";
    }
    return _xblockexpression;
  }
  
  public static String toText(final ConstantValue cv) {
    boolean _matched = false;
    if (!_matched) {
      if (cv instanceof StringTerm) {
        _matched=true;
        return ((StringTerm)cv).getValue();
      }
    }
    if (!_matched) {
      if (cv instanceof RealTerm) {
        _matched=true;
        String _elvis = null;
        String _value = ((RealTerm)cv).getValue();
        String _unit = ((RealTerm)cv).getUnit();
        String _plus = (_value + _unit);
        if (_plus != null) {
          _elvis = _plus;
        } else {
          _elvis = "";
        }
        return _elvis;
      }
    }
    if (!_matched) {
      if (cv instanceof IntegerTerm) {
        _matched=true;
        String _elvis = null;
        int _value = ((IntegerTerm)cv).getValue();
        String _string = Integer.valueOf(_value).toString();
        String _unit = ((IntegerTerm)cv).getUnit();
        String _plus = (_string + _unit);
        if (_plus != null) {
          _elvis = _plus;
        } else {
          _elvis = "";
        }
        return _elvis;
      }
    }
    return null;
  }
}
