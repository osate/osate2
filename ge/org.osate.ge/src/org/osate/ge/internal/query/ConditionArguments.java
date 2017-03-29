package org.osate.ge.internal.query;

/**
 * Provides access to the arguments used to evaluate the condition for {@link Query#ifElse(org.osate.ge.query.Supplier, org.osate.ge.query.Supplier, org.osate.ge.query.Supplier)}. 
 * @param <A> the type of the query argument
 * @noextend
 * @noimplement
 * @see Query#ifElse(org.osate.ge.query.Supplier, org.osate.ge.query.Supplier, org.osate.ge.query.Supplier)
 */
public interface ConditionArguments<A> {
	/**
	 * Returns the business object that is associated with the diagram element on which the condition is being evaluated.
	 * @return the diagram element's business object
	 */
	Object getBusinessObject();
	
	/**
	 * Returns the query argument 
	 * @return the query argument
	 */
	A getQueryArgument();
}
