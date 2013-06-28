package edu.uah.rsesc.aadl.age.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import edu.uah.rsesc.aadl.age.Activator;
import edu.uah.rsesc.aadl.age.util.DiagramOpener;
import edu.uah.rsesc.aadl.age.util.Log;
import edu.uah.rsesc.aadl.age.util.SelectionHelper;

/**
 * Handler for the open classifier diagram menu commands
 * @author philip.alldredge
 *
 */
public class OpenClassifierDiagramHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		try {
			Log.ok(getClass().getSimpleName() + " Started");			

			// Determine the classifier
			final Classifier classifier = getSelectedClassifier();
			if(classifier == null) {
				MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), Activator.PLUGIN_ID, "Select a classifier.");
			} else {
				DiagramOpener.create().openOrCreateDiagram(classifier);
			}
			Log.ok(getClass().getSimpleName() + " Finished");
		} catch(RuntimeException e) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), Activator.PLUGIN_ID, "Error opening classifier diagram handler: " + e.getMessage());
			Log.error("Error opening classifier diagram", e);
			throw e;
		}
		
		return null;
	}
	
	private Classifier getSelectedClassifier() {
		EObject obj = SelectionHelper.getSelectedObject();
		while(obj instanceof Element) {
			if(obj instanceof Classifier) {
				return (Classifier)obj;
			}
			
			obj = obj.eContainer();
		}

		return null;
	}
}
