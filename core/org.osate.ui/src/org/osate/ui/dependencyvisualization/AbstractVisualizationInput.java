package org.osate.ui.dependencyvisualization;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

abstract class AbstractVisualizationInput<T> implements IVisualizationInput {
	protected final List<T> scopedElements;

	protected AbstractVisualizationInput(List<T> scopedElements) {
		this.scopedElements = Collections.unmodifiableList(scopedElements);
	}

	@Override
	public boolean isInScope(Object entity) {
		return scopedElements.contains(entity);
	}

	protected static <T> void traverseDependencies(T start, Set<T> visited, Predicate<T> filter,
			Function<T, Iterable<T>> getDependencies) {
		for (T dependency : getDependencies.apply(start)) {
			if (filter.test(dependency) && !visited.contains(dependency)) {
				visited.add(dependency);
				traverseDependencies(dependency, visited, filter, getDependencies);
			}
		}
	}
}