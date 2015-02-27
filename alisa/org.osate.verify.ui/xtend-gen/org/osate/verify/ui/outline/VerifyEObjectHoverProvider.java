package org.osate.verify.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.osate.aadl2.Classifier;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.util.CommonUtilExtension;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.util.ReqSpecUtilExtension;
import org.osate.verify.verify.VerificationActivity;

@SuppressWarnings("all")
public class VerifyEObjectHoverProvider extends DefaultEObjectHoverProvider {
  public String getHoverInfoAsHtml(final EObject o) {
    boolean _matched = false;
    if (!_matched) {
      if (o instanceof VerificationActivity) {
        _matched=true;
        final Requirement req = ((VerificationActivity)o).getRequirement();
        String _elvis = null;
        String _title = req.getTitle();
        if (_title != null) {
          _elvis = _title;
        } else {
          _elvis = "";
        }
        final String z = _elvis;
        Description _description = req.getDescription();
        String _text = null;
        if (_description!=null) {
          Classifier _requirementTarget = ReqSpecUtilExtension.requirementTarget(req);
          _text=CommonUtilExtension.toText(_description, _requirementTarget);
        }
        final String zz = _text;
        final String res = ((z + ": ") + zz);
        return res;
      }
    }
    return "No message!!";
  }
}
