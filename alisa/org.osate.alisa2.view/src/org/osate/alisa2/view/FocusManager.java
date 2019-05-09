package org.osate.alisa2.view;

import org.eclipse.emf.ecore.EObject;

/**
 * Singleton that provides access to focus related functionality. We use a
 * singleton because a) Java services can't hold state, and b) we never want
 * multiple things focused at the same time.
 *
 * See Wikipedia for the code the lazy initialization is adapted from:
 * https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
 * @author Sam Procter
 *
 */
public class FocusManager {

	/**
	 * The user's focus
	 */
	private EObject focus;

	/**
	 * Private constructor to enforce singleton pattern. Note that we also
	 * initialize the focus to null.
	 */
	private FocusManager() {
		focus = null;
	}

	private static class LazyHolder {
		static final FocusManager INSTANCE = new FocusManager();
	}

	public static FocusManager getInstance() {
		return LazyHolder.INSTANCE;
	}

	public EObject getFocus() {
		return focus;
	}

	public void setFocus(EObject newFocus) {
		focus = newFocus;
	}

	public void initFocusGraph() {
		/*-

		 * Expandable Things
		 	* Under Fundamentals: (probz collapsable under their own thing, since Accident Levels would have like a trillion)
		 		* Error types
		 		* Affected Components
		 	* Under Components on Containment view:
		 		* Error Types
				* Affected Fundamentals
		 * Focusable Things
		 	* Fundamentals
		 	* Components
		 * Calkalations
			 * Fundamental -> Error Type @ Component -> Forward and Backward Slice
			 * Component -> Error Type set -> Fundamentals
		
		 */
	}
}
