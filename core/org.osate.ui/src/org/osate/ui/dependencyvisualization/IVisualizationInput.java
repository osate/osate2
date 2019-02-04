package org.osate.ui.dependencyvisualization;

import java.util.stream.Stream;

interface IVisualizationInput {
	Object[] getGraphElements();

	Object[] getConnectedTo(Object entity);

	Stream<?> getConnectedToBothDirections(Object entity);

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