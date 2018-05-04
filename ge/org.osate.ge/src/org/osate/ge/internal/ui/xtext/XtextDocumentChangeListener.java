package org.osate.ge.internal.ui.xtext;

import org.eclipse.emf.common.util.URI;

public interface XtextDocumentChangeListener {
	void documentChanged(URI resourceUri);
}
