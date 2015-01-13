package org.osate.alisa.common.util

import org.apache.log4j.Logger
import org.eclipse.core.resources.IResource
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil

abstract class AlisaVerifyTest {

	private static Logger LOGGER = Logger.getLogger(AlisaVerifyTest);

  def void handleErrorMarkers(InstanceObject instance, String markertype){
		// XXX phf trying to get to markers
		val res = instance.eResource
		val err= res.errors
		val mt = "org.osate.analysis.flows.FlowLatencyObjectMarker"
		val IResource irsrc = OsateResourceUtil.convertToIResource(res);
//		val markersforanalysis = irsrc.findMarkers(mt,true,IResource.DEPTH_INFINITE )  // analysisMarkerType
//		val highestSeverityLevel = irsrc.findMaxProblemSeverity(mt ,true,IResource.DEPTH_INFINITE )
//  		markersforanalysis.forEach[m|m.getAtribute(AadlConstants.AADLURI)]
  }
  
  
  def void handleIssues(){
  	// Xtext issues. Collected as FluentIssueCollection which also allows messages to be included.
//  	assertConstraints(
//  issues.errorsOnly()
//        .inLine(1)
//        .under(Modul.class, "person")
//        .named("name")
//        .oneOfThemContains("missing display name")
	}
}
