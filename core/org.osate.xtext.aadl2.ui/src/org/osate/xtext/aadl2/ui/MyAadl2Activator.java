package org.osate.xtext.aadl2.ui;


import static com.google.inject.Guice.createInjector;
import static com.google.inject.util.Modules.override;

import org.apache.log4j.Logger;
import org.osate.core.OsateCorePlugin;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;

public class MyAadl2Activator extends Aadl2Activator {
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		try {
			registerInjectorFor(ORG_OSATE_XTEXT_AADL2_AADL2);
			
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
