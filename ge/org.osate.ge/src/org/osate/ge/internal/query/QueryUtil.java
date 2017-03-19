package org.osate.ge.internal.query;

public class QueryUtil {
	/**  
	 * Ensures the query only returns the first element. If the specified query is null, null is returned.
	 * @param q
	 * @return
	 */
	public static <T> AgeDiagramElementQuery<T> ensureFirst(final AgeDiagramElementQuery<T> q) {
		if(q == null) {
			return null;
		}
		
		if(q instanceof FirstQuery && ((FirstQuery<T>)q).getMaximumNumberOfResults() == 1) {
			return q;
		}
		
		return q.first();
	}
}
