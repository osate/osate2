package org.osate.alisa.common.util;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.osate.aadl2.NamedElement;
import org.osate.alisa.common.common.ComputeDeclaration;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.common.ShowValue;

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
      ShowValue _showValue = de.getShowValue();
      boolean _notEquals_1 = (!Objects.equal(_showValue, null));
      if (_notEquals_1) {
        ShowValue _showValue_1 = de.getShowValue();
        XVariableDeclaration _ref = null;
        if (_showValue_1!=null) {
          _ref=_showValue_1.getRef();
        }
        final XVariableDeclaration decl = _ref;
        if ((decl instanceof ComputeDeclaration)) {
        }
        String _elvis = null;
        XExpression _right = null;
        if (decl!=null) {
          _right=decl.getRight();
        }
        String _string = null;
        if (_right!=null) {
          _string=_right.toString();
        }
        if (_string != null) {
          _elvis = _string;
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
}
