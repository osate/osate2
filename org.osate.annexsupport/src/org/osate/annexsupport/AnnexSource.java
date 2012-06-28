package org.osate.annexsupport;

import org.eclipse.emf.common.notify.Adapter;

/**
 * Adapter for attaching information regarding the Annex source text to a model object.
 * @author philip
 */
public interface AnnexSource extends Adapter {
	/**
	 * Retrieves the source text for the Annex
	 * @return the source text
	 */
	String getSourceText();
	
	/**
	 * Returns the offset to the Annex source text
	 * @return the offset from the start of the source file to the AADL source text
	 */
	int getSourceTextOffset();
}
