package org.osate.ge.internal.query;

public class QueryUtil {
	/**  
	 * Ensures the query only returns the first element. If the specified query is null, null is returned.
	 * @param q
	 * @return
	 */
	public static <T> DefaultQuery ensureFirst(final DefaultQuery q) {
		if(q == null) {
			return null;
		}
		
		if(q instanceof FirstQuery && ((FirstQuery)q).getMaximumNumberOfResults() == 1) {
			return q;
		}
		
		return q.first();
	}
}
