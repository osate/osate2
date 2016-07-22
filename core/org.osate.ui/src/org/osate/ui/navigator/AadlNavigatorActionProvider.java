package org.osate.ui.navigator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

import com.google.inject.Injector;

public class AadlNavigatorActionProvider extends CommonActionProvider {
	private final IURIEditorOpener editorOpener;
	
	public AadlNavigatorActionProvider() {
		Injector injector = Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2);
		editorOpener = injector.getInstance(IURIEditorOpener.class);
	}
	
	@Override
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);
		actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, new Action() {
			@Override
			public void run() {
				List<Object> selectedElements = Arrays.asList(getActionSite().getStructuredViewer().getStructuredSelection().toArray());
				Stream<ContributedAadlFile> files = selectedElements.stream().filter(file -> file instanceof ContributedAadlFile).map(file -> (ContributedAadlFile)file);
				files.forEach(file -> editorOpener.open(file.getURI(), true));
			}
		});
	}
}