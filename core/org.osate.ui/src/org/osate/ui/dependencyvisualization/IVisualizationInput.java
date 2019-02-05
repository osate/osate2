package org.osate.ui.dependencyvisualization;

import java.util.stream.Stream;

import org.eclipse.zest.core.viewers.GraphViewer;

/**
 * Used by {@link AbstractDependencyVisualizationView} to handle the logic of a directed graph.
 */
interface IVisualizationInput {
	/**
	 * Called by the {@link GraphViewer}'s content provider.
	 */
	Object[] getGraphElements();

	/**
	 * Called by the {@link GraphViewer}'s content provider.
	 */
	Object[] getConnectedTo(Object entity);

	/**
	 * Called by the {@link GraphViewer}'s label provider to determine if a node should be colored in orange.
	 */
	Stream<?> getConnectedToBothDirections(Object entity);

	/**
	 * Called by the {@link GraphViewer}'s label provider to determine if a node should be colored light blue.
	 */
	boolean isInScope(Object entity);

	IVisualizationInput EMPTY = new IVisualizationInput() {
		@Override
		public Object[] getGraphElements() {
			return new Object[0];
		}

		@Override
		public Object[] getConnectedTo(Object entity) {
			return new Object[0];
		}

		@Override
		public Stream<?> getConnectedToBothDirections(Object entity) {
			return Stream.empty();
		}

		@Override
		public boolean isInScope(Object entity) {
			return false;
		}
	};
}