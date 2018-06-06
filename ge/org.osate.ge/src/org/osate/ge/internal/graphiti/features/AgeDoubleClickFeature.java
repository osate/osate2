package org.osate.ge.internal.graphiti.features;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.osate.ge.internal.ui.util.UiUtil;

// ICustomFeature implementation that opens the properties view when a diagram element is double-clicked
public class AgeDoubleClickFeature extends AbstractCustomFeature {
	@Inject
	public AgeDoubleClickFeature(final IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getName() {
		return "Properties...";
	}

	@Override
	public boolean canExecute(final ICustomContext context) {
		return true;
	}

	@Override
	public void execute(final ICustomContext context) {
		UiUtil.openPropertiesView();
	}

	@Override
	public boolean hasDoneChanges() {
		return false;
	}
}
