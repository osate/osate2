package org.osate.xtext.aadl2.properties.ui;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.util.Modules.override;

import org.apache.log4j.Logger;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
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

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		try {
			registerInjectorFor(ORG_OSATE_XTEXT_AADL2_PROPERTIES_PROPERTIES);
			
			EMFIndexRetrieval.registerResourceProviders(rdp, rspr);
			
		} catch (Exception e) {
			Logger.getLogger(getClass()).error(e.getMessage(), e);
			throw e;
		}
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
