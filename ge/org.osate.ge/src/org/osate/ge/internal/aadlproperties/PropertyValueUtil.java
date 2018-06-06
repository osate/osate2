package org.osate.ge.internal.aadlproperties;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class PropertyValueUtil {
	private static StandaloneQuery classifierQuery = StandaloneQuery.create((rootQuery) -> rootQuery.children().children().filterByBusinessObjectCanonicalReference(qa -> qa).first());
	private static StandaloneQuery partialInstanceObjectQuery = StandaloneQuery.create((rootQuery) -> rootQuery
			.descendantsByBusinessObjectsRelativeReference((InstanceObject io) -> getInstanceObjectPath(io), 1)
			.first());
	private static StandaloneQuery instanceObjectQuery = StandaloneQuery.create((rootQuery) -> rootQuery
			.descendantsByBusinessObjectsRelativeReference((InstanceObject io) -> getInstanceObjectPath(io)).first());

	public static Queryable getReferencedClassifier(final Queryable q,
			final ClassifierValue cv,
			final QueryService queryService) {
		// Decide whether to show it as connection or not.
		Queryable top = q;
		while(top.getParent() != null) {
			top = top.getParent();
		}

		return queryService.getFirstResult(classifierQuery, top, cv.getClassifier());
	}

	public static AadlPropertyResolutionResults getReferencedInstanceObject(final Queryable q, final InstanceObject io,
			final QueryService queryService) {

		// Decide whether to show it as connection or not.
		Queryable top = q;
		while (top.getParent() != null) {
			top = top.getParent();
		}

		final Queryable dst = queryService.getFirstResult(partialInstanceObjectQuery, top, io);
		final boolean hasPartial = dst != null;
		final Queryable referencedQueryable = queryService.getFirstResult(instanceObjectQuery, top, io);
		final boolean isPartial = hasPartial && dst != referencedQueryable;
		return new AadlPropertyResolutionResults(dst, isPartial);
	}

	private static Object[] getInstanceObjectPath(final InstanceObject io) {
		final LinkedList<InstanceObject> path = new LinkedList<InstanceObject>();
		for (EObject tmp = io; tmp instanceof InstanceObject; tmp = tmp.eContainer()) {
			path.addFirst((InstanceObject) tmp);
		}
		return path.toArray(new Object[path.size()]);
	}
}
