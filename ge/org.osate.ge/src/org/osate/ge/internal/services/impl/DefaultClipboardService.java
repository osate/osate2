package org.osate.ge.internal.services.impl;

import java.lang.ref.WeakReference;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.internal.services.ClipboardService;

public class DefaultClipboardService implements ClipboardService {
	public static class ContextFunction extends SimpleServiceContextFunction<ClipboardService> {
		@Override
		public ClipboardService createService(final IEclipseContext context) {
			return new DefaultClipboardService();
		}
	}

	// The clipboard is a weak reference so that it will be automatically cleared when there are no users of the clipboard.
	private WeakReference<Clipboard> weakClipboard = new WeakReference<>(null);

	@Override
	public synchronized Clipboard getClipboard() {
		Clipboard clipboard = weakClipboard.get();
		if(clipboard == null) {
			clipboard = new SimpleClipboard();
			weakClipboard = new WeakReference<>(clipboard);
		}

		return clipboard;
	}

	private static class SimpleClipboard implements Clipboard {
		private Object contents;

		@Override
		public Object getContents() {
			return contents;
		}

		@Override
		public void setContents(final Object value) {
			this.contents = value;
		}
	}
}
