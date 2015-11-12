package org.osate.alisa.common.scoping;

import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public abstract class AlisaAbstractDeclarativeScopeProvider extends CommonScopeProvider { // AbstractDeclarativeScopeProvider {

	public final static String NAMED_DELEGATE = "org.osate.alisa.common.scoping.AlisaAbstractDeclarativeScopeProvider.delegate";

	@Inject
	@Named(NAMED_DELEGATE)
	private IScopeProvider myDelegate;

	@Override
	public void setDelegate(IScopeProvider delegate) {
		this.myDelegate = delegate;
	}

	@Override
	public IScopeProvider getDelegate() {
		return myDelegate;
	}
}
