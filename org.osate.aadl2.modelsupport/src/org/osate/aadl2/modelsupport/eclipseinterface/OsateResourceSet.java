/*
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 */
package org.osate.aadl2.modelsupport.eclipseinterface;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.util.Aadl2ResourceImpl;
import org.osate.internal.workspace.AadlWorkspace;
import org.osate.workspace.IResourceUtility;


/**
 * @version $Id: OsateResourceSet.java,v 1.3 2009-12-01 15:31:08 lwrage Exp $
 */
public class OsateResourceSet extends ResourceSetImpl implements IEditingDomainProvider, IResourceChangeListener {
	
	/**
	 * change of named element name affects resources (models) that refer to it
	 */
	protected boolean propagateNameChange = true;
	private EditingDomain editingDomain;
	
	public OsateResourceSet() {
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	public void setEditingDomain(EditingDomain ed){
		editingDomain = ed;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)
	 */
	public void resourceChanged(IResourceChangeEvent event) {
		final List<IFile> files = new LinkedList<IFile>();
		// System.out.println("POST_CHANGE event");
		processDelta(event.getDelta(), true, files);
		if (!files.isEmpty()) {
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					OsateResourceManager.populateResourceSet(files);
				}
			});
		}
	}
	
	protected void processDelta(IResourceDelta delta, boolean loadModels, List<IFile> modelFiles) {
		IResourceDelta[] children = delta.getAffectedChildren();

		if ((delta.getFlags() & IResourceDelta.OPEN) != 0) {
			IProject project = (IProject) delta.getResource();
			loadModels = project.isOpen();
		}
		processChanged(delta, loadModels, modelFiles);
		for (int i = 0; i < children.length; i++) {
			processDelta(children[i], loadModels, modelFiles);
		}
	}
	
	protected void processChanged(IResourceDelta delta, boolean loadModels, List<IFile> modelFiles) {
		
				
/* 		int k = delta.getKind();
		int f = delta.getFlags();
		IResource r = delta.getResource();
		
		if ((k & IResourceDelta.ADDED) != 0) System.out.print("added "); 
		if ((k & IResourceDelta.REMOVED) != 0) System.out.print("removed "); 
		if ((k & IResourceDelta.CHANGED) != 0) System.out.print("changed ");
		
		if ((f & IResourceDelta.CONTENT) != 0) System.out.print("content ");
		if ((f & IResourceDelta.MOVED_FROM) != 0) System.out.print("moved from ");
		if ((f & IResourceDelta.MOVED_TO) != 0) System.out.print("moved to ");
		if ((f & IResourceDelta.COPIED_FROM) != 0) System.out.print("copied from ");
		if ((f & IResourceDelta.OPEN) != 0) System.out.print("open ");
		
		System.out.print(r.getFullPath().toString() + " " + loadModels);
		System.out.println();
*/ 		
		if ((delta.getKind() & IResourceDelta.ADDED) != 0 && loadModels) {
			IResource added = delta.getResource();
			if (added instanceof IFile && IResourceUtility.isAaxlFile(added)) {
				// System.out.println("LOAD" + added.getFullPath());
				modelFiles.add((IFile)added);
			}
		} 
		if ((delta.getKind() & IResourceDelta.REMOVED) != 0) {
			IResource deleted = delta.getResource();
			if (deleted instanceof IFile && !IResourceUtility.isAadlFile(deleted)) {
				URI uri = URI.createPlatformResourceURI(deleted.getFullPath().toString(), false);
				Resource res = getResource(uri, false);
				if (res != null) {
					res.unload();
					getResources().remove(res);
				}
				AadlWorkspace.getAadlWorkspace().removeFromLookupTable((IFile)deleted);
			}
		} 
//		if ((delta.getKind() & IResourceDelta.ADDED) != 0 &&
//				  (delta.getFlags() & IResourceDelta.MOVED_FROM) != 0) {
//			IPath moved = delta.getMovedFromPath();
//			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(moved);
//			OsateResourceManager.deleteComplementFile(file);
//		}
		if ((delta.getKind() & IResourceDelta.CHANGED) != 0 &&
				  (delta.getFlags() & IResourceDelta.CONTENT) != 0) {
			IResource changed = delta.getResource();
			if (changed instanceof IFile && OsateResourceManager.isAadlXMLResource(changed)) {
				Resource res = OsateResourceManager.getResource(changed);
				if (res != null && res instanceof Aadl2ResourceImpl ){
					if (!((Aadl2ResourceImpl)res).getJustSaved()){
// XXX this handles external update of XML file
						// when the file is written in multiple pieces
						// notification is kicked off multiple times and a reload is attempted on a partially complete file
						try {
							changed.setDerived(false);
						} catch (CoreException e) {
						}
						OsateResourceManager.untagModelWithSyntaxErrors(res);
						modelFiles.add((IFile)changed);
					} else {
						((Aadl2ResourceImpl)res).setJustSaved(false);
					}
					// force changed files to be reloaded
				}
			}
		}
	}
	
	public void saveAll(){
        // Save resources
		for (Resource resource : getResources())
		{
			if (resource.isModified()) {
				// will be unset by unparse activity
//				resource.setModified(false);
				if (resource instanceof Aadl2ResourceImpl) {
					Aadl2ResourceImpl cres= (Aadl2ResourceImpl)resource;
					// needs to call the CoreResoruce method, not the OSATEResoruceManager method
					// as that one would cause other saves to maintain pointers correctly.
					cres.save();
				} else {
					// save topcased diagrams
					if (resource.getURI().fileExtension().equalsIgnoreCase("aaxldi")) {
						Map<String, String> options = new HashMap<String, String>();
						options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
						try {
							resource.save(options);
						} catch (IOException e) {
							// TODO Auto-generated catch block
						}
					}
				}
			}
		}
	}
	
	/**
	 * make resources as modified if their model objects point to the named object
	 */
	public Set<Resource> doFindUnresolved(){
		Set<Resource> result = new HashSet<Resource>();
		Map<EObject, Collection<EStructuralFeature.Setting>> map = EcoreUtil.UnresolvedProxyCrossReferencer.find(this);
	    if (!map.isEmpty())
	    {
	      for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : map.entrySet())
	      {

	    	for (EStructuralFeature.Setting setting : entry.getValue())
	        {
	          EObject obj = setting.getEObject();
	          Resource res = obj.eResource();
	          result.add(res);
	        }
	      }
	    }
	    return result;
	}
	
	/**
	 * convert id into an id handled by EMF
	 * This interprets XPath and does the file lookup for packages and propertysets
	 * @param id String id stored as XPath in XML document
	 * @return String id in EMF format
	 */
	protected URI convertID(String id){
		URI iduri = URI.createPlatformResourceURI(id, false).trimFragment();
		final boolean isLocal = id.startsWith("//");
		final boolean isaPackage = id.indexOf("/aadlPackage") >= 0;
		final boolean isaPropertyset = id.indexOf("/propertySet") >= 0;
		final boolean isSpec = id.startsWith("/aadlSpec") && !(isaPackage || isaPropertyset);
		final boolean isInstance = id.startsWith("/systemInstance");
		String name = (id.indexOf("@name=")!=-1 &&id.indexOf("@name=") + 6< id.length())?id.substring(id.indexOf("@name=") + 6, id.indexOf("]")):"";
		// convert id to EMF version
		if (isLocal) {
			// a local reference
			return iduri;
		} else if (isSpec || isInstance) {
			Resource res = OsateResourceManager.findResource(name);
			if (res == null) {
				return null;
			}
			URI uri = res.getURI();
			return uri;
		} else if (isaPackage || isaPropertyset) {
			String fragment = "/" + id.substring(id.indexOf("]") + 1);
			String pkpsname = fragment.substring(fragment.indexOf("@name=") + 6, fragment.indexOf("]"));
//			if (isaPropertyset && (pkpsname.equalsIgnoreCase("AADL_Project") || pkpsname.equalsIgnoreCase("AADL_Properties"))) {
//				Preferences prefs = WorkspacePlugin.getDefault().getPluginPreferences();
//				String fileName;
//				URI uri;
//				
//				if (pkpsname.equalsIgnoreCase("AADL_Properties")) {
//					fileName = prefs.getString(WorkspacePlugin.AADL_PROPERTIES_FILE);
//				} else {
//					fileName = prefs.getString(WorkspacePlugin.AADL_PROJECT_FILE);						
//				}
//				uri = URI.createFileURI(fileName).trimFileExtension().appendFileExtension(WorkspacePlugin.MODEL_FILE_EXT);
//				return uri;
//			} else {
				URI uri=null;
				if (isaPackage){
					AadlPackage pkg = OsateResourceManager.findPublicAadlPackage(pkpsname, null);
					if (pkg == null){
						return null;
					}
					if (pkg.eResource() == null){
						return null;
					}
					uri = pkg.eResource().getURI();
				} else {
					// is a property set
					/* TODO: [PROPERTIES] uncomment and fixed once properties are added
					PropertySet ps = OsateResourceManager.findPropertySet(pkpsname, null);
					if (ps == null){
						return null;
					}
					if (ps.eResource() == null){
						return null;
					}
					uri = ps.eResource().getURI();
					*/
				}
				return uri;
//			}
		} else {
			// id is a qname or sth else
			return iduri;
		}
	}

	
	/*
	 * Javadoc copied from interface.
	 */
	public Resource getResource(URI uri, boolean loadOnDemand) {
		if (uri.segmentCount() > 0) {
			String s = uri.segment(0);
			if (s.startsWith("aadlSpec") || s.startsWith("systemInstance")) {
				uri = convertID(uri.toString());

				if (uri == null) {
					String name = s.substring(s.indexOf("@name=") + 6, s.indexOf("]"));
					Resource res = OsateResourceManager.findResource(name);
					if (res != null) {
						return res;
					}
					IFile file = AadlWorkspace.getAadlWorkspace().findAadlModelFile(name);
					if (file == null) {
						return null;
					}
					uri = URI.createPlatformResourceURI(file.getFullPath().toString(), false);
				}
			}
		}
		return (uri == null) ? null : super.getResource(uri,loadOnDemand);
	}

	@Override
	public Map<Object, Object> getLoadOptions() {
		return OsateResourceManager.LOAD_OPTIONS;
	}

	public Resource createResource(URI uri) {
		if (uri.segmentCount() > 0) {
			String s = uri.segment(0);
			if (s.startsWith("aadlSpec") || s.startsWith("systemInstance")){
				uri = convertID(uri.toString());
				if (uri == null) {
					String name = s.substring(s.indexOf("@name=") + 6, s.indexOf("]"));
					Resource res = OsateResourceManager.findResource(name);
					if (res != null) {
						return res;
					}
					IFile file = AadlWorkspace.getAadlWorkspace().findAadlModelFile(name);
					if (file == null) {
						return null;
					}
					uri = URI.createPlatformResourceURI(file.getFullPath().toString(), false);
				}
			}
		}
		return (uri == null) ? null : super.createResource(uri);
	}
	
	  /*
	   * Javadoc copied from interface.
	   */
	  public EObject getEObject(URI uri, boolean loadOnDemand)
	  {
	    Resource resource = getResource(uri.trimFragment(), loadOnDemand);
	    if (resource != null)
	    {
	    	if (uri.fragment() == null ){
	  		  if (uri.segmentCount()>0){
				  String s = uri.segment(0);
	    		if (s.startsWith("aadlSpec")||s.startsWith("systemInstance")){
	    			// turn into local fragment. EMF otherwise tries to interpret the first item as index
	    			String uristring = uri.toString();
	    			String fragment = uristring.substring(uristring.indexOf("]")+1);
		    		return resource.getEObject("/"+fragment);
	    		}
	  		  }
	  		  return null;
	    	} else {
	    		return resource.getEObject(uri.fragment());
	    	}
	    }
	    else
	    {
	      return null;
	    }
	  }

	/**
	 * detinrerm whether to propagate name changes to other resources or not
	 * @return true if requested to propagate
	 */
	public boolean isPropagateNameChange(){
		return propagateNameChange;
	}

	/**
	 * set whether to propagate name changes to other resources or not
	 * @param propagate
	 */
	public void setPropagateNameChange(boolean propagate){
		propagateNameChange = propagate;
	}

}