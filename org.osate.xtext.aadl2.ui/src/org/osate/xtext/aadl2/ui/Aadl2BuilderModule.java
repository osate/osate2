package org.osate.xtext.aadl2.ui;

import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.osate.xtext.aadl2.ui.builder.OsateClusteringBuilderState;

import com.google.inject.Binder;
import com.google.inject.Scopes;

@SuppressWarnings("restriction")
public class Aadl2BuilderModule extends AbstractGenericModule {

	public void configureIBuilderstate(Binder binder) {
		binder.bind(IBuilderState.class).to(OsateClusteringBuilderState.class).in(Scopes.SINGLETON);
	}

}
