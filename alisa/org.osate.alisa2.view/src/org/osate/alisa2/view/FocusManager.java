package org.osate.alisa2.view;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.alisa2.model.safe2.Accident;
import org.osate.alisa2.model.safe2.AccidentLevel;
import org.osate.alisa2.model.safe2.Constraint;
import org.osate.alisa2.model.safe2.Fundamental;
import org.osate.alisa2.model.safe2.Hazard;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

/**
 * Singleton that provides access to focus related functionality. We use a
 * singleton because a) Sirius's java services can't hold state, and b) we
 * never want multiple things focused at the same time.
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

		if (newFocus instanceof Fundamental) {
			handleFocusedFundamental((Fundamental) newFocus);
		} else if (newFocus instanceof ComponentInstance) {
			handleFocusedComponent((ComponentInstance) newFocus);
		}


		// components need to add themselves, as well as connections between themselves

		/*-

		 * Expandable Things
		 	* Under Fundamentals: (probz collapsable under their own thing, since Accident Levels would have like a trillion)
		 		* Affected Components
		 	* Under Components on Containment view:
				* Affected Fundamentals
		 * Focusable Things
		 	* Fundamentals
		 	* Components
		 * Calkalations
			 * Fundamental -> Error Type @ Component -> Forward and Backward Slice
			 * Component -> Error Type set -> For each, forward and backward slice -> Fundamentals (based on constraint-Error Type links)

		 */
	}

	private void handleFocusedComponent(ComponentInstance newFocus) {
		focusSet.addAll(AWASManager.getInstance().backwardReach(newFocus));
		focusSet.addAll(AWASManager.getInstance().forwardReach(newFocus));
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
			handleFocusedErrorType(((Hazard) newFocus).getErrorType(), ((Hazard) newFocus).getSystemElement());
			for (Constraint c : ((Hazard) newFocus).getConstraint()) {
				handleFocusedFundamental(c);
			}
		}
		if (newFocus instanceof Constraint) {
			handleFocusedErrorType(((Constraint) newFocus).getHazard().getErrorType(),
					((Constraint) newFocus).getPort());
		}
	}

	private void handleFocusedErrorType(ErrorType et, FeatureInstance feature) {
		// slicing stuff -- add components from forward and backward slice
		focusSet.addAll(AWASManager.getInstance().backwardReach(et, feature));
//		focusSet.addAll(AWASManager.getInstance().forwardReach(et, componentInstance));
		focusSet.size();
	}

	public void clearFocus() {
		focusSet.clear();
	}
}
