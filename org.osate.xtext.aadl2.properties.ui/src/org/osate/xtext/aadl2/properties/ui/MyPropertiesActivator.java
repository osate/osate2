package org.osate.xtext.aadl2.properties.ui;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.util.Modules.override;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.modelsupport.modeltraversal.TraverseWorkspace;
import org.osate.aadl2.modelsupport.resources.ModelLoadingAdapter;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.core.OsateCorePlugin;
import org.osate.xtext.aadl2.properties.ui.internal.PropertiesActivator;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;
import org.osgi.framework.BundleContext;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class MyPropertiesActivator extends PropertiesActivator implements org.eclipse.ui.IStartup{



    public void earlyStartup(){
    	new org.osate.xtext.aadl2.properties.PropertiesRuntimeModule();
    };
    

	@Inject
	private ResourceDescriptionsProvider rdp ; 
	 
	@Inject 
	 private IResourceServiceProvider.Registry rspr;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	// if inject does not work
//	private IResourceServiceProvider.Registry rspr = 
//			   IResourceServiceProvider.Registry.INSTANCE; 

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		try {
			registerInjectorFor(ORG_OSATE_XTEXT_AADL2_PROPERTIES_PROPERTIES);
			
			EMFIndexRetrieval.registerResourceProviders(rdp, rspr);
			IFile storage = TraverseWorkspace.getAADLProjectFile();
			ResourceSet rs = getResourceSet(storage);
			OsateResourceUtil.setResourceSet(rs);
			
		} catch (Exception e) {
			Logger.getLogger(getClass()).error(e.getMessage(), e);
			throw e;
		}
	}


	protected ResourceSet getResourceSet(IStorage storage) {
		if (storage instanceof IFile) {
			return resourceSetProvider.get(((IFile) storage).getProject());
		}
		return resourceSetProvider.get(null);
	}
	
	@Override
	public Injector getInjector(String languageName) {
		return OsateCorePlugin.getDefault().getInjector(languageName);
	}
	
	protected void registerInjectorFor(String language) throws Exception {
		OsateCorePlugin.getDefault().registerInjectorFor(language, 
				createInjector(
		  override(override(getRuntimeModule(language)).with(getSharedStateModule())).with(getUiModule(language))));
	}

}
