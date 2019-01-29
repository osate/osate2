package org.osate.alisa2.view;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
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
		// Get the features
		for (FeatureInstance fi : ((ComponentInstance) self).getAllFeatureInstances()) {
			// Get their connections
			for (ConnectionInstance ci : fi.getAllEnclosingConnectionInstances()) {
				// Get their sources or destinations
				if (fi.getDirection() == DirectionType.IN) {
					ret.add(ci.getSource().getContainingComponentInstance());
				} else if (fi.getDirection() == DirectionType.OUT) {
					ret.add(ci.getDestination().getContainingComponentInstance());
				} else { // fi.getDirection() == IN_OUT
					ret.add(ci.getSource().getContainingComponentInstance());
					ret.add(ci.getDestination().getContainingComponentInstance());
				}
			}
		}
		return ret;
	}

	public EList<ConnectionInstance> getAllConnectionInstances(EObject self) {
		return ((ComponentInstance) self).getConnectionInstances();
	}
}
