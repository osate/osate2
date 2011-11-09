package org.osate.xtext.aadl2.propertyset.ui;

import org.osate.core.OsateCorePlugin;
import org.osate.xtext.aadl2.propertyset.ui.internal.PropertysetActivator;

import static com.google.inject.util.Modules.override;
import static com.google.inject.Guice.createInjector;

import com.google.inject.Injector;

public class MyPropertysetActivator extends PropertysetActivator {

	@Override
	public Injector getInjector(String languageName) {
		return OsateCorePlugin.getDefault().getInjector(languageName);
	}
	
	@Override
	protected void registerInjectorFor(String language) throws Exception {
		OsateCorePlugin.getDefault().registerInjectorFor(language, 
				createInjector(
		  override(override(getRuntimeModule(language)).with(getSharedStateModule())).with(getUiModule(language))));
	}

}
