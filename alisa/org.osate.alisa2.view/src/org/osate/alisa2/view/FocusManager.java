package org.osate.alisa2.view;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.osate.alisa2.model.safe2.Accident;
import org.osate.alisa2.model.safe2.AccidentLevel;
import org.osate.alisa2.model.safe2.Constraint;
import org.osate.alisa2.model.safe2.Fundamental;
import org.osate.alisa2.model.safe2.Hazard;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

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
	 * The set of elements included as part of the user's focus
	 */
	private Set<EObject> focusSet = new HashSet<>();

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

	public boolean isFocused(EObject element) {
		return focusSet.contains(element);
	}

	public void setFocus(EObject newFocus) {
		focus = newFocus;
		clearFocus();

		if(newFocus instanceof Fundamental) {
			handleFocusedFundamental((Fundamental) newFocus);
		}

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
			 * Component -> Error Type set -> For each, forward and backward slice -> Fundamentals (based on constraint-Error Type links)

		 */
	}

	private void handleFocusedFundamental(Fundamental newFocus) {
		focusSet.add(newFocus);
		if (newFocus instanceof AccidentLevel) {
			for (Accident a : ((AccidentLevel) newFocus).getAccident()) {
				handleFocusedFundamental(a);
			}
		}
		if (newFocus instanceof Accident) {
			for (Hazard h : ((Accident) newFocus).getHazard()) {
				handleFocusedFundamental(h);
			}
		}
		if (newFocus instanceof Hazard) {
			for (Constraint c : ((Hazard) newFocus).getConstraint()) {
				handleFocusedFundamental(c);
			}
		}
		if (newFocus instanceof Constraint) {
			handleFocusedErrorType(((Constraint) newFocus).getErrorType());
		}
	}

	private void handleFocusedErrorType(ErrorType et) {
		// slicing stuff -- add components from forward and backward slice
	}

	public void clearFocus() {
		focusSet.clear();
	}
}
