package org.osate.xtext.aadl2.errormodel.ui;

import org.apache.log4j.Logger;
import org.osate.core.OsateCorePlugin;
import org.osate.xtext.aadl2.errormodel.ui.internal.ErrorModelActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;

public class MyErrorModelActivator extends ErrorModelActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		try {
			registerInjectorFor(ORG_OSATE_XTEXT_AADL2_ERRORMODEL_ERRORMODEL);

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
		OsateCorePlugin.getDefault().registerInjectorFor(language, createInjector(language));
//		// change in Xtext 2.3
//		  override(override(getRuntimeModule(language)).with(getSharedStateModule())).with(getUiModule(language))));
	}

}
