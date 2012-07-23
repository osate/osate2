package org.osate.annexsupport;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

public class AnnexSourceImpl implements AnnexSource {
	private Notifier target;
	private String srcText;
	private int offset;
	
	public AnnexSourceImpl(String srcText, int offset) {
		this.srcText = srcText;
		this.offset = offset;
	}
	
	@Override
	public String getSourceText() {
		return srcText;
	}

	@Override
	public int getSourceTextOffset() {
		return offset;
	}

	@Override
	public void notifyChanged(Notification notification) {
	}
	

	@Override
	public Notifier getTarget() {
		return target;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		target = newTarget;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type instanceof AnnexSource;
		// changed it because we were getting the Aadl2ItemProviderAdapterFactory  
//		return AnnexSource.class.isAssignableFrom((Class<?>)type);
	}

}
