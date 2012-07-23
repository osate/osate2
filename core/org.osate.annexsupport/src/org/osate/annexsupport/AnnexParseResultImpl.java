package org.osate.annexsupport;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.xtext.parser.IParseResult;

public class AnnexParseResultImpl implements AnnexParseResult {
	private Notifier target;
	private IParseResult parseResult;
	private int annexOffset;
	
	public AnnexParseResultImpl(IParseResult parseResult, int annexOffset) {
		this.parseResult = parseResult;
		this.annexOffset = annexOffset;
	}
	
	@Override
	public IParseResult getParseResult() {
		return parseResult;
	}
	@Override
	public int getAnnexOffset() {
		return annexOffset;
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
		return type instanceof AnnexParseResult;
		// changed it because we were getting the Aadl2ItemProviderAdapterFactory  
//		return AnnexSource.class.isAssignableFrom((Class<?>)type);
	}


}
