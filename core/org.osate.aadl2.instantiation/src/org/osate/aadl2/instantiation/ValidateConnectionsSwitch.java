package org.osate.aadl2.instantiation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;

class ValidateConnectionsSwitch extends AadlProcessingSwitchWithProgress {

	Map<InstanceObject, InstantiatedClassifier> classifierCache;

	public ValidateConnectionsSwitch(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			Map<InstanceObject, InstantiatedClassifier> classifierCache) {
		super(monitor, errManager);
		this.classifierCache = classifierCache;
	}

	@Override
	protected void initSwitches() {
		instanceSwitch = new InstanceSwitch<String>() {

			@Override
			public String caseComponentInstance(final ComponentInstance ci) {
				if (monitor.isCanceled()) {
					cancelTraversal();
					return DONE;
				}
				validateConnections(ci);
				return DONE;
			}
		};
	}

	private void validateConnections(ComponentInstance ci) {
		removeShortAccessConnections(ci);
		// more
	}

	/**
	 * If a feature group contains access and port features we may have created incomplete access connections that
	 * end, e.g., on a thread, but for which there is also a complete connection to a subcomponent of this thread.
	 * This method finds these connections and deletes them from the instance model.
	 *
	 * @param ci - Validate connections owned by ci
	 */
	private void removeShortAccessConnections(ComponentInstance ci) {
		List<ConnectionInstance> connis = ci.getConnectionInstances();
		List<ConnectionInstance> toRemove = new ArrayList<>();
		Map<ConnectionInstanceEnd, List<ConnectionInstance>> bySrc = connis.stream()
				.collect(Collectors.groupingBy(ConnectionInstance::getSource));
		Map<ConnectionInstanceEnd, List<ConnectionInstance>> byDst = connis.stream()
				.collect(Collectors.groupingBy(ConnectionInstance::getSource));

		connis.stream().forEach(conni -> {
			if (conni.getKind() != ConnectionKind.ACCESS_CONNECTION) {
				return;
			}
			ConnectionInstanceEnd src = conni.getSource();
			ConnectionInstanceEnd dst = conni.getDestination();

			boolean remove = bySrc.getOrDefault(src, Collections.emptyList())
					.stream()
					.anyMatch(test -> shouldCompare(test, conni) && startsWith(test, conni));
			remove |= bySrc.getOrDefault(dst, Collections.emptyList())
					.stream()
					.anyMatch(test -> shouldCompare(test, conni) && startsWithReverse(test, conni));
			remove |= byDst.getOrDefault(dst, Collections.emptyList())
					.stream()
					.anyMatch(test -> shouldCompare(test, conni) && endsWith(test, conni));
			remove |= byDst.getOrDefault(src, Collections.emptyList())
					.stream()
					.anyMatch(test -> shouldCompare(test, conni) && endsWithReverse(test, conni));
			if (remove) {
				toRemove.add(conni);
			}
		});
		connis.removeAll(toRemove);
	}

	private boolean shouldCompare(ConnectionInstance test, ConnectionInstance conni) {
		return test != conni && test.getKind() == ConnectionKind.ACCESS_CONNECTION;
	}

	private boolean startsWith(ConnectionInstance test, ConnectionInstance conni) {
		List<ConnectionReference> testRefs = test.getConnectionReferences();
		List<ConnectionReference> connRefs = conni.getConnectionReferences();
		if (connRefs.size() >= testRefs.size()) {
			return false;
		}

		Iterator<ConnectionReference> testing = testRefs.iterator();
		Iterator<ConnectionReference> prefix = connRefs.iterator();

		while (prefix.hasNext()) {
			ConnectionReference t = testing.next();
			ConnectionReference p = prefix.next();
			if (t.getConnection() != p.getConnection()) {
				return false;
			}
			if (!prefix.hasNext()) {
				return t.getDestination() == p.getDestination();
			}
		}
		return false;
	}

	private boolean startsWithReverse(ConnectionInstance test, ConnectionInstance conni) {
		List<ConnectionReference> testRefs = test.getConnectionReferences();
		List<ConnectionReference> connRefs = conni.getConnectionReferences();
		if (connRefs.size() >= testRefs.size()) {
			return false;
		}

		Iterator<ConnectionReference> testing = testRefs.iterator();
		ListIterator<ConnectionReference> prefix = connRefs.listIterator(connRefs.size());

		while (prefix.hasPrevious()) {
			ConnectionReference t = testing.next();
			ConnectionReference p = prefix.previous();
			if (t.getConnection() != p.getConnection()) {
				return false;
			}
			if (!prefix.hasPrevious()) {
				return t.getDestination() == p.getSource();
			}
		}
		return false;
	}

	private boolean endsWith(ConnectionInstance test, ConnectionInstance conni) {
		List<ConnectionReference> testRefs = test.getConnectionReferences();
		List<ConnectionReference> connRefs = conni.getConnectionReferences();
		if (connRefs.size() >= testRefs.size()) {
			return false;
		}

		ListIterator<ConnectionReference> testing = test.getConnectionReferences()
				.listIterator(test.getConnectionReferences().size());
		ListIterator<ConnectionReference> prefix = connRefs.listIterator(connRefs.size());

		while (prefix.hasPrevious()) {
			ConnectionReference t = testing.previous();
			ConnectionReference p = prefix.previous();
			if (t.getConnection() != p.getConnection()) {
				return false;
			}
			if (!prefix.hasPrevious()) {
				return t.getSource() == p.getSource();
			}
		}
		return false;
	}

	private boolean endsWithReverse(ConnectionInstance test, ConnectionInstance conni) {
		List<ConnectionReference> testRefs = test.getConnectionReferences();
		List<ConnectionReference> connRefs = conni.getConnectionReferences();
		if (connRefs.size() >= testRefs.size()) {
			return false;
		}

		ListIterator<ConnectionReference> testing = test.getConnectionReferences()
				.listIterator(test.getConnectionReferences().size());
		Iterator<ConnectionReference> prefix = connRefs.iterator();

		while (prefix.hasNext()) {
			ConnectionReference t = testing.previous();
			ConnectionReference p = prefix.next();
			if (t.getConnection() != p.getConnection()) {
				return false;
			}
			if (!prefix.hasNext()) {
				return t.getSource() == p.getDestination();
			}
		}
		return false;
	}

}
