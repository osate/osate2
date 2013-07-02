package edu.uah.rsesc.aadl.age.xtext;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.osate.aadl2.NamedElement;

// Model Listener that delegates the work to registers listeners
public class ModelListener {
	private class Info {
		public Info(XtextResourceSet rs, IXtextDocument document) {
			this.resourceSet = rs;
			this.document = document;
		}
		
		XtextResourceSet resourceSet;
		IXtextDocument document;
	}
	
	private Map<String, Stack<Info>> packageNameToInfoMap = new HashMap<String, Stack<Info>>();
	private LinkedList<ModelChangeListener> changeListeners = new LinkedList<ModelChangeListener>();

	public void removeDocumentInfo(final IXtextDocument document) {
		for(final Stack<Info> infoStack : packageNameToInfoMap.values()) {
			if(removeDocumentInfo(infoStack, document)) {
				break;
			}
		}
	}
	
	// TODO: Consider rename model changed event(s)... Call on inital xtext editor load
	// TODO: Rename
	// TODO: Have a way to remove things from the map... 	
	public void modelChanged(final IXtextDocument document, final XtextResource resource) {
		if(resource.getContents().size() > 0) {
			final EObject obj = resource.getContents().get(0);
			if(obj instanceof NamedElement) {
				final String qualifiedName = ((NamedElement)obj).getQualifiedName();
				
				// Get the resource set
				final XtextResourceSet resourceSet = (XtextResourceSet)resource.getResourceSet();	
				
				// Get all the info for the name
				if(!packageNameToInfoMap.containsKey(qualifiedName)) {
					packageNameToInfoMap.put(qualifiedName,  new Stack<Info>());
				}
				final Stack<Info> infoStack = packageNameToInfoMap.get(qualifiedName);
				
				// Find the info object for the document and remove it
				removeDocumentInfo(infoStack, document);
				
				// Add a new object to the top of the stack
				infoStack.push(new Info(resourceSet, document));
			}
			
			// Call other listeners
			for(final ModelChangeListener l : changeListeners) {
				l.modelChanged();
			}
		}
	}
	
	public XtextResourceSet getResourceSet(final String packageName) {
		final Stack<Info> infoStack = packageNameToInfoMap.get(packageName);
		return infoStack == null || infoStack.size() == 0 ? null : infoStack.peek().resourceSet;
	}
	
	public IXtextDocument getDocument(final String packageName) {
		final Stack<Info> infoStack = packageNameToInfoMap.get(packageName);
		return infoStack == null || infoStack.size() == 0 ? null : infoStack.peek().document;
	}
	
	public final void addListener(final ModelChangeListener listener) {
		changeListeners.add(listener);
	}
	
	public final void removeListener(final ModelChangeListener listener) {
		changeListeners.remove(listener);
	}
	
	/**
	 * Searches an info stack for a value and removes it if found. Only removed the first value matching the criteria
	 * @param infoStack
	 * @param document
	 * @return true if an item was removed
	 */
	private boolean removeDocumentInfo(final Stack<Info> infoStack, final IXtextDocument document) {
		final int index = getIndexByDocument(infoStack, document);
		if(index >= 0) {
			infoStack.remove(index);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Find the index of the info object in a stack using a document as the search criteria
	 * @param infoStack
	 * @param document
	 * @return the index in the stack. -1 if the document does not have an entry in the stack
	 */
	private int getIndexByDocument(final Stack<Info> infoStack, final IXtextDocument document) {
		for(int i = 0; i < infoStack.size(); i++) {
			final Info info = infoStack.get(i);
			if(info.document == document) {
				return i;
			}
		}
		return -1;
	}
}
