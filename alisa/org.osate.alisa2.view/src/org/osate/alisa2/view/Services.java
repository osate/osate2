package org.osate.alisa2.view;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;

/**
 * The services class used by VSM.
 */
public class Services {

    /**
    * See http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24 for documentation on how to write service methods.
    */
    public EObject myService(EObject self, String arg) {
       // TODO Auto-generated code
      return self;
    }

	public Collection<EObject> getNeighbors(EObject self) {
		Set<EObject> ret = new HashSet<>();
		Set<ConnectionInstance> cis = new HashSet<>();
		// Get the features
		for (FeatureInstance fi : ((ComponentInstance) self).getAllFeatureInstances()) {
			// Get their connections
			cis.clear();
			cis.addAll(fi.getDstConnectionInstances());
			for (ConnectionInstance ci : fi.getAllEnclosingConnectionInstances()) {
				ConnectionInstanceEnd cieSrc = ci.getSource();
				ConnectionInstanceEnd cieDst = ci.getDestination();
				ComponentInstance srcCI = cieSrc.getContainingComponentInstance();
				ComponentInstance dstCI = cieDst.getContainingComponentInstance();
				if (srcCI == self) {
					ret.add(dstCI);
				} else if (dstCI == self) {
					ret.add(srcCI);
				}
				cieSrc = null;
			}
//			cis.addAll(fi.getSrcConnectionInstances());
//			for (ConnectionInstance ci : cis) {
//				// Get their sources or destinations
//				if (fi.getDirection() == DirectionType.IN) {
//					ret.add(ci.getSource().getContainingComponentInstance());
//				} else if (fi.getDirection() == DirectionType.OUT) {
//					ret.add(ci.getDestination().getContainingComponentInstance());
//				} else { // fi.getDirection() == IN_OUT
//					ret.add(ci.getSource().getContainingComponentInstance());
//					ret.add(ci.getDestination().getContainingComponentInstance());
//				}
//			}
		}
		return ret;
	}

	public EList<ComponentInstance> getAllComponents(EObject self) {
		return ((ComponentInstance) self).getAllComponentInstances();
	}

	public EList<ConnectionInstance> getAllConnectionInstances(EObject self) {
		return ((ComponentInstance) self).getConnectionInstances();
	}

	public boolean isLeafComponent(EObject self) {
		return ((ComponentInstance) self).getAllComponentInstances().size() == 1;
	}

	public boolean isNestedComponent(EObject self) {
		return ((ComponentInstance) self).getContainingComponentInstance() != null;
	}

	public boolean isHardware(EObject self) {
		// XXX TODO FIXME
		// See usage in ContainedTopology->NoHardware->MappingFilterHIDE
		// just enumerate HW elements -- ie, is processor, etc. Check instanceutil, there may be something there\
		return false;
	}
}
