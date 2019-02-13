package org.osate.alisa2.view;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Element;
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

	public Collection<EObject> getAllNeighbors(EObject self) {
		return (Stream.concat(getSuccessorNeighbors(self).stream(), getPredecessorNeighbors(self).stream()))
				.collect(Collectors.toSet());
	}

	public Collection<EObject> getSuccessorNeighbors(EObject self) {
		return getNeighbors(self, true);
	}

	public Collection<EObject> getPredecessorNeighbors(EObject self) {
		return getNeighbors(self, false);
	}

	private Collection<EObject> getNeighbors(EObject self, boolean successors) {
		Set<EObject> ret = new HashSet<>();
		ComponentInstance ciSelf = (ComponentInstance) self;
		// Get the features
		ret.addAll(getImmediateNeighbors(ciSelf, 0, successors));
		for (Element subc : ciSelf.getChildren()) {
			if (subc instanceof ComponentInstance) {
				ret.addAll(getImmediateNeighbors((ComponentInstance) subc, 1, successors));
			}
		}
		return ret;
	}

	private Collection<EObject> getImmediateNeighbors(ComponentInstance ciSelf, int depth, boolean successors) {
		Set<EObject> ret = new HashSet<>();
		Set<ConnectionInstance> cis = new HashSet<>();
		for (FeatureInstance fi : ciSelf.getAllFeatureInstances()) {
			// Get their connections
			cis.clear();
			if (successors) {
				cis.addAll(fi.getSrcConnectionInstances());
			} else {
				cis.addAll(fi.getDstConnectionInstances());
			}
			for (ConnectionInstance ci : cis) {
				// Get their sources or destinations
				if (successors) {
					ret.add(getEnclosingComponentByDepth(ci.getDestination(), depth));
				} else {
					ret.add(getEnclosingComponentByDepth(ci.getSource(), depth));
				}
			}
		}
		return ret;
	}

	private EObject getEnclosingComponentByDepth(ConnectionInstanceEnd cie, int depth) {
		ComponentInstance ret = cie.getContainingComponentInstance();
		for (int x = 0; x < depth; x++) {
			ret = ret.getContainingComponentInstance();
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
