package org.osate.xtext.aadl2.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.osate.aadl2.modelsupport.resources.PredeclaredProperties;

import com.google.inject.Inject;

public class CreatePredeclaredPropertiesHandler extends AbstractHandler {


		@Inject
		private EObjectAtOffsetHelper eObjectAtOffsetHelper;

		public Object execute(ExecutionEvent event) throws ExecutionException {
			PredeclaredProperties.initPluginContributedAadl();
			return null;
		}

}
