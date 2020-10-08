package org.osate.annexsupport;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.parser.IParseResult;

/**
 * @since 3.0
 */
public class ParseResultHolder extends AdapterImpl {
	private IParseResult parseResult;
	
	public IParseResult getParseResult() {
		return parseResult;
	}
	
	public void setParseResult(IParseResult parseResult) {
		this.parseResult = parseResult;
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type == ParseResultHolder.class;
	}
	
	public static class Factory extends AdapterFactoryImpl {
		public static final Factory INSTANCE = new Factory();
		
		public ParseResultHolder adapt(Notifier target) {
			return (ParseResultHolder) adapt(target, ParseResultHolder.class);
		}
		
		@Override
		public boolean isFactoryForType(Object type) {
			return type == ParseResultHolder.class;
		}
		
		@Override
		protected Adapter createAdapter(Notifier target) {
			return new ParseResultHolder();
		}
	}
}