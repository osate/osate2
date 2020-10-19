package org.osate.asap.view;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.asap.model.safe2.Accident;
import org.osate.asap.model.safe2.AccidentLevel;
import org.osate.asap.model.safe2.Constraint;
import org.osate.asap.model.safe2.Fundamental;
import org.osate.asap.model.safe2.Hazard;
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
	// Use hash sets since we mostly do lookups (less, but still sometimes: inserts & clears)
	private Set<EObject> forwardFocusSet = new HashSet<>();
	private Set<EObject> backwardFocusSet = new HashSet<>();
	private Set<Fundamental> fundamentalFocusSet = new HashSet<>();

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

	@Deprecated
	public boolean isFocused(EObject element) {
		return false;
	}

	public boolean isOnlyForwardFocused(EObject element) {
		return forwardFocusSet.contains(element) && (!backwardFocusSet.contains(element));
	}

	public boolean isOnlyBackwardFocused(EObject element) {
		return (!forwardFocusSet.contains(element)) && backwardFocusSet.contains(element);
	}

	public boolean isDoublyFocused(EObject element) {
		return forwardFocusSet.contains(element) && backwardFocusSet.contains(element);
	}

	public boolean isFundamentalFocused(EObject element) {
		return fundamentalFocusSet.contains(element);
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
		backwardFocusSet.addAll(AwasManager.getInstance().backwardReach(newFocus));
		forwardFocusSet.addAll(AwasManager.getInstance().forwardReach(newFocus));
	}

	private void handleFocusedFundamental(Fundamental newFocus) {
		fundamentalFocusSet.add(newFocus);
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
		backwardFocusSet.addAll(AwasManager.getInstance().backwardReach(et, feature));
		forwardFocusSet.addAll(AwasManager.getInstance().forwardReach(et, feature));
	}

	public void clearFocus() {
		forwardFocusSet.clear();
		backwardFocusSet.clear();
		fundamentalFocusSet.clear();
	}
}
