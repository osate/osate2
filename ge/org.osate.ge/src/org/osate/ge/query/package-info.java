/**
 * Contains the query API. The query API allows building a query which is used to retrieve nodes from a {@link org.osate.ge.BusinessObjectContext} tree.
 * Older versions of the OSATE graphical editor API required the use of the query API. In some cases it is possible or more convenient
 * to use {@link org.osate.ge.BusinessObjectContext} methods directly.
 *
 * Queries are created using {@link org.osate.ge.query.ExecutableQuery} and then executed using {@link org.osate.ge.services.QueryService}.
 *
 **/
package org.osate.ge.query;