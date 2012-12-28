package org.osate.aadl2.errormodel.analysis;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.instance.InstanceObject;

public class EMSUtil {
	
	public static void unsetAll(InstanceObject root){
		TreeIterator<Object> it = EcoreUtil.getAllContents(root, false);
		while (it.hasNext()) {
			InstanceObject io = (InstanceObject) it.next();
			ErrorModelState st = (ErrorModelState) ErrorModelStateAdapterFactory.INSTANCE.adapt(io, ErrorModelState.class);
			st.unsetAll();
		}
	}
	
	public static void removeAll(InstanceObject root){
		TreeIterator<Object> it = EcoreUtil.getAllContents(root, false);
		while (it.hasNext()) {
			InstanceObject io = (InstanceObject) it.next();
			Adapter st = ErrorModelStateAdapterFactory.INSTANCE.adapt(io, ErrorModelState.class);
			Notifier notifier = st.getTarget();
			notifier.eAdapters().remove(st);
			st.setTarget(null);
		}
	}

}
