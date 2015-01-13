package org.osate.alisa.common.util;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

@SuppressWarnings("all")
public abstract class AlisaVerifyTest {
  private static Logger LOGGER = Logger.getLogger(AlisaVerifyTest.class);
  
  public void handleErrorMarkers(final InstanceObject instance, final String markertype) {
    final Resource res = instance.eResource();
    final EList<Resource.Diagnostic> err = res.getErrors();
    final String mt = "org.osate.analysis.flows.FlowLatencyObjectMarker";
    final IResource irsrc = OsateResourceUtil.convertToIResource(res);
  }
  
  public void handleIssues() {
  }
}
