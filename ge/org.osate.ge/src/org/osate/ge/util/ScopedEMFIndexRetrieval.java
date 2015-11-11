package org.osate.ge.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.osate.core.OsateCorePlugin;
import org.osate.ge.ui.util.SelectionHelper;

import com.google.inject.Injector;

public class ScopedEMFIndexRetrieval {
	/**
	* Gets a collection containing all EObjects of a specified type which may be directly referenced from the project containing the specified resource.
	*/
	public static Collection<IEObjectDescription> getAllEObjectsByType(final Resource resource, final EClass type) {
		return getAllEObjectsByType(SelectionHelper.getProject(resource), type);
	}
	
	/**
	* Gets a collection containing all EObjects of a specified type which may be directly referenced from the specified project
	*/
	public static Collection<IEObjectDescription> getAllEObjectsByType(final IProject project, final EClass type) {
		final Set<IResourceDescription> resourceDescriptions = calculateResourceDescriptions(getReferenceableProjects(project));
		final List<IEObjectDescription> objectDescriptions = new ArrayList<IEObjectDescription>();
		
		for(final IResourceDescription rd : resourceDescriptions) {
			for(final IEObjectDescription od : rd.getExportedObjectsByType(type)) {
				objectDescriptions.add(od);	
			}			
		}
		
		return objectDescriptions;
	}
	
	/**
	 * Returns the set of projects that can be referenced from the specified project. Includes the specified project. 
	 * Not recursive(Projects referenced by referenced projects are not included).
	 * @param resource
	 * @return
	 */
	private static Set<IProject> getReferenceableProjects(final IProject project) {
		try {
			final Set<IProject> projects = new HashSet<IProject>();
			projects.add(project);
			
			for(final IProject referencedProject : project.getReferencedProjects()) {
				if(!projects.contains(referencedProject)) {
					projects.add(referencedProject);
				}
			}

			return projects;
		} catch(final CoreException ex) {
			throw new RuntimeException(ex);
		}		 
	}
	
	public static Set<IResourceDescription> calculateResourceDescriptions(final Set<IProject> projects) {
		final Set<IResourceDescription> resourceDescriptions = new HashSet<IResourceDescription>();
		final Injector injector = OsateCorePlugin.getDefault().getInjector("org.osate.xtext.aadl2.properties.Properties");
		final ResourceDescriptionsProvider resourceDescProvider = injector.getInstance(ResourceDescriptionsProvider.class);
		final IResourceDescriptions resDescriptions = resourceDescProvider.getResourceDescriptions(new XtextResourceSet());
		for(final IResourceDescription resDesc : resDescriptions.getAllResourceDescriptions()) {
			final IPath resPath = new Path(resDesc.getURI().toPlatformString(true));
			for(final IProject p : projects) {
				if(p.getFullPath().isPrefixOf(resPath)) {
					resourceDescriptions.add(resDesc);
				}
			}
		}
		
		return resourceDescriptions;
	}
}
