package org.osate.ge.internal.services;

public interface ClipboardService {
	interface Clipboard {
		Object getContents();

		void setContents(Object value);
	}

	/**
	 * Retrieves access to the clipboard. Each editor that uses the clipboard should hold a reference to the clipboard. If there no
	 * references to the clipboard, it may be freed.
	 * @return
	 */
	Clipboard getClipboard();
}
