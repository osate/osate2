package org.osate.annexsupport;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.xtext.parser.IParseResult;

/**
 * Adapter for attaching information regarding the Annex source text to a model object.
 * @author peter
 */
public interface AnnexParseResult extends Adapter {
	/**
	 * Retrieves the ParseResult object for the Annex
	 * @return the source text
	 */
	IParseResult getParseResult();

/**
 * retrieves the offset of teh annex text from the beginning of the file
 * @return
 */
	int getAnnexOffset() ;

}
