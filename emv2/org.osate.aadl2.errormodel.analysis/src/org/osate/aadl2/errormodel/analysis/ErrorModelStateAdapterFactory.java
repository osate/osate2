package org.osate.aadl2.errormodel.analysis;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

public class ErrorModelStateAdapterFactory extends AdapterFactoryImpl{
	
	public static AdapterFactory INSTANCE = new ErrorModelStateAdapterFactory();
	
	@Override
	public Adapter createAdapter(Notifier target, Object type){
		return new ErrorModelStateAdapter();
	}

	@Override
	public boolean isFactoryForType(Object type) {
		return (type == ErrorModelState.class);
	}
	
}
