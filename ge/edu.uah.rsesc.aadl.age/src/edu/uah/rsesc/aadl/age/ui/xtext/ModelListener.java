package edu.uah.rsesc.aadl.age.ui.xtext;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

// Model Listener that delegates the work to registered listeners
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
	private LinkedList<IXtextModelListener> changeListeners = new LinkedList<IXtextModelListener>();

	public void removeDocumentInfo(final IXtextDocument document) {
		for(final Stack<Info> infoStack : packageNameToInfoMap.values()) {
			if(removeDocumentInfo(infoStack, document)) {
				// If the last xtext editor was just closed, refresh osate's resource set
				if(infoStack.size() == 0) {
					OsateResourceUtil.refreshResourceSet();
				}
				
				break;
			}
		}
	}
	
	public void modelChanged(final IXtextDocument document, final XtextResource resource) {
		if(resource.getContents().size() > 0) {
			final EObject obj = resource.getContents().get(0);

			//handleRenames(resource);
			
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
			for(final IXtextModelListener l : changeListeners) {
				l.modelChanged(resource);
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
	
	public final void addListener(final IXtextModelListener listener) {
		changeListeners.add(listener);
	}
	
	public final void removeListener(final IXtextModelListener listener) {
		changeListeners.remove(listener);
	}
	
	/**
	 * Searches an info stack for a value and removes it if found. Only removed the first value matching the criteria
	 * @param infoStack
	 * @param document
	 * @return the index of the info object removed
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
	
	/*
	Prototype WIP code to handle renames
	private Map<URI, NamedElement> uriToNamedElementMap = new HashMap<URI, NamedElement>();
	
	private void handleRenames(final XtextResource res) {		
		System.out.println("HANDLE RENAMES");
		System.out.println(res.getErrors());
		final NamedElement oldEl = uriToNamedElementMap.get(res.getURI());
		boolean updateContent = true; // Flag to determine whether to update the content if an updated value is found
		if(oldEl != null) {
			if(res.getContents().size() > 0) {
				final EObject newContent = res.getContents().get(0);
				
				if(oldEl instanceof AadlPackage) {
					if(newContent instanceof AadlPackage) {
						final AadlPackage oldPkg = (AadlPackage)oldEl;
						final AadlPackage newPkg = (AadlPackage)newContent;
						
						System.out.println(oldPkg.getName());
						System.out.println(newPkg.getName());

						// Handle version where old package doesn't have a name or new package doesn't have a name...
						// Otherwise when package is blanked and then changed it will never be handled...
						if(newPkg.getName() == null) {
							updateContent = false;
						} else {
							if(oldPkg.getName() != null) {
								if(!oldPkg.getName().equalsIgnoreCase(newPkg.getName())) {
									onPackageRenamed(oldPkg.getName(), newPkg.getName());
									
								}
							}
						}
					}
				}				
			}
		}
		
		// Store the element in the map
		if(res.getContents().size() > 0 && res.getContents().get(0) instanceof NamedElement) {
			if(updateContent) {
				uriToNamedElementMap.put(res.getURI(), (NamedElement)res.getContents().get(0));
			}
		} else {
			uriToNamedElementMap.remove(res.getURI());
		}
	}
	
	private void onPackageRenamed(final String oldName, final String newName) {
		System.out.println("RENAMED FROM: " + oldName + " to " + newName);
		
		// TODO: How to handle, try to rename all the qualified names, etc?
	}
	*/
}
