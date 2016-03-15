package org.osate.ge.internal;

import org.eclipse.graphiti.features.DefaultResizeConfiguration;

/** 
 * A default implementation of AgeResizeConfiguration that extends DefaultResizeConfiguration as well.
 *
 */
public class DefaultAgeResizeConfiguration extends DefaultResizeConfiguration implements AgeResizeConfiguration {
	private boolean hasMinimumSize = false;
	private int minimumWidth;
	private int minimumHeight;
	
	@Override
	public boolean hasMinimumSize() {
		return hasMinimumSize;
	}
	
	@Override
	public int getMinimumWidth() {
		return minimumWidth;
	}
	
	@Override
	public int getMinimumHeight() {
		return minimumHeight;
	}
	
	public void setMinimumSize(final int minimumWidth, final int minimumHeight) {
		this.minimumWidth = minimumWidth;
		this.minimumHeight = minimumHeight;
		this.hasMinimumSize = true;
	}
}
