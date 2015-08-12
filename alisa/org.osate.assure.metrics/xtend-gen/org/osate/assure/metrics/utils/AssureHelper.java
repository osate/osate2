package org.osate.assure.metrics.utils;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.assure.assure.AssuranceEvidence;
import org.osate.assure.assure.ClaimResult;
import org.osate.reqspec.reqSpec.Requirement;

@SuppressWarnings("all")
public class AssureHelper {
  public static List<Requirement> getRequirements(final AssuranceEvidence evidence) {
    List<Requirement> _xblockexpression = null;
    {
      final List<Requirement> res = new ArrayList<Requirement>();
      EList<ClaimResult> _claimResult = evidence.getClaimResult();
      final Procedure1<ClaimResult> _function = new Procedure1<ClaimResult>() {
        @Override
        public void apply(final ClaimResult cr) {
          Requirement _target = cr.getTarget();
          res.add(_target);
          Requirement _target_1 = cr.getTarget();
          String _plus = ("ClaimResult" + _target_1);
          InputOutput.<String>println(_plus);
        }
      };
      IterableExtensions.<ClaimResult>forEach(_claimResult, _function);
      _xblockexpression = res;
    }
    return _xblockexpression;
  }
  
  public static List<ComponentInstance> getComponentsInstance(final AssuranceEvidence evidence) {
    InstanceObject _instance = evidence.getInstance();
    SystemInstance _systemInstance = _instance.getSystemInstance();
    return _systemInstance.getAllComponentInstances();
  }
}
