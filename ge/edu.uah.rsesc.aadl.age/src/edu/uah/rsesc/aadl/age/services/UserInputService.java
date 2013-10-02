package edu.uah.rsesc.aadl.age.services;

import org.eclipse.graphiti.features.context.IDeleteContext;

/**
 * Contains methods for getting information from the user.
 * @author philip.alldredge
 *
 */
public interface UserInputService {
	/**
	 * Confirms deletion with the user
	 * @param context
	 * @return whether or not the user confirmed the deletion.
	 */
	boolean confirmDelete(final IDeleteContext context);
}
