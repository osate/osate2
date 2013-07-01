package edu.uah.rsesc.aadl.age.xtext;

import java.util.LinkedList;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;

// Xtext Model Listener that delegates the work to registers listeners
public class DelegatingXtextModelListener implements IXtextModelListener {
	private LinkedList<IXtextModelListener> modelListeners = new LinkedList<IXtextModelListener>();
	
	@Override
	public void modelChanged(final XtextResource resource) {
		for(final IXtextModelListener l : modelListeners) {
			l.modelChanged(resource);
		}
	}
	
	public final void addListener(final IXtextModelListener listener) {
		modelListeners.add(listener);
	}
	
	public final void removeListener(final IXtextModelListener listener) {
		modelListeners.remove(listener);
	}
}
