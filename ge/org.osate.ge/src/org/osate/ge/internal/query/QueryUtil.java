package org.osate.ge.internal.query;

public class QueryUtil {
	/**  
	 * Ensures the query only returns the first element
	 * @param q
	 * @return
	 */
	public static <T> PictogramQuery<T> ensureFirst(final PictogramQuery<T> q) {
		if(q instanceof FirstPictogramQuery) {
			return q;
		}
		
		return q.first();
	}
}
