package org.osate.xtext.aadl2.ui;

import org.osate.core.OsateCorePlugin;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;
import static com.google.inject.util.Modules.override;
import static com.google.inject.Guice.createInjector;

import com.google.inject.Injector;

public class MyAadl2Activator extends Aadl2Activator {

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
