package edu.uah.rsesc.aadl.age.xtext;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.osate.aadl2.NamedElement;

// Xtext Model Listener that delegates the work to registers listeners
public class AgeXtextModelListener implements IXtextModelListener {
	private LinkedList<ModelChangeListener> modelListeners = new LinkedList<ModelChangeListener>();
	private Map<String, XtextResourceSet> packageNameToResourceSetMap = new HashMap<String, XtextResourceSet>(); // Mapping from qualified name of the root of a resource to the resource set that contains the latest modification
	
	@Override
	public void modelChanged(final XtextResource resource) {
		if(resource.getContents().size() > 0) {
			final EObject obj = resource.getContents().get(0);
			if(obj instanceof NamedElement) {
				final String qualifiedName = ((NamedElement)obj).getQualifiedName();
				final XtextResourceSet resourceSet = (XtextResourceSet)resource.getResourceSet();
				packageNameToResourceSetMap.put(qualifiedName, resourceSet);
			}
			
			// Call other listeners
			for(final ModelChangeListener l : modelListeners) {
				l.modelChanged();
			}
		}
	}
	
	public XtextResourceSet getResourceSet(final String packageName) {
		return packageNameToResourceSetMap.get(packageName);
	}
	
	public final void addListener(final ModelChangeListener listener) {
		modelListeners.add(listener);
	}
	
	public final void removeListener(final ModelChangeListener listener) {
		modelListeners.remove(listener);
	}
}
