package org.osate.analysis.security;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

public class SecurityCheckAdapterFactory extends AdapterFactoryImpl {

	public static final AdapterFactory INSTANCE = new SecurityCheckAdapterFactory();

	@Override
	public boolean isFactoryForType(Object type) {
		return type == SecurityCheckData.class;
	}

	@Override
	protected Adapter createAdapter(Notifier target) {
		return new SecurityCheckAdapter();
	}
}
