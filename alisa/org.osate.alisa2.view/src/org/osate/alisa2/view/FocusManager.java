package org.osate.alisa2.view;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.alisa2.model.safe2.Accident;
import org.osate.alisa2.model.safe2.AccidentLevel;
import org.osate.alisa2.model.safe2.Constraint;
import org.osate.alisa2.model.safe2.Fundamental;
import org.osate.alisa2.model.safe2.Hazard;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

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
///			handleFocusedErrorType(((Hazard) newFocus).getErrorType(), ((Hazard) newFocus).getSystemElement());
			handleFocusedHazard(((Hazard) newFocus));
			for (Constraint c : ((Hazard) newFocus).getConstraint()) {
				handleFocusedFundamental(c);
			}
		}
		if (newFocus instanceof Constraint) {
			handleFocusedErrorType(((Constraint) newFocus).getHazard().getErrorType(),
					((Constraint) newFocus).getPort());
		}
	}

	private void handleFocusedHazard(Hazard h) {
		// The hazard contains a port and a state in that element's component-specific state machine
		//
		// Ideally we'd get a component and a state, but we can't get a reference to a feature instance
		// from an error behavior state, so we have to fudge it by asking for a feature instance directly.
		//
		// 1. Get the feature and state
		FeatureInstance fi = h.getSystemElement();
		ErrorBehaviorState ebs = h.getSystemState();

		// 2. Make sure the state exists in this component, and find the transitions which target it
		boolean found = false;
		ErrorModelSubclause emv2Subclause = EMV2Util
				.getOwnEMV2Subclause(fi.getContainingComponentInstance().getClassifier());
		if (emv2Subclause == null) {
			// The target component doesn't have an EMV2 block.
			// TODO: Handle this gracefully / inform the user
			return;
		}
		Collection<ErrorBehaviorTransition> transitions = emv2Subclause.getTransitions();
		Set<ErrorBehaviorTransition> transitionsWeCareAbout = new HashSet<>();
		for (ErrorBehaviorTransition t : transitions) {
			if (t.getTarget().equals(ebs)) {
				transitionsWeCareAbout.add(t);
				found = true;
			}
		}
		if (!found) {
			// Couldn't find the state as a target in the component's error behavior state machine
			// TODO: Handle this gracefully / inform the user
			return;
		}

		// 3. Get the error type from each of the incoming error propagations that can move us to
		// this state
		for (ErrorBehaviorTransition t : transitionsWeCareAbout) {
			if (t.getCondition() instanceof ConditionElement) {
				EList<TypeToken> tokenSet = ((ConditionElement) t.getCondition()).getConstraint().getTypeTokens();
				if (tokenSet.size() == 1 && tokenSet.get(0).getType().size() == 1
						&& tokenSet.get(0).getType().get(0) instanceof ErrorType) {
					// 4. Slice on each of these error propagations
					handleFocusedErrorType((ErrorType) tokenSet.get(0).getType().get(0), fi);
				} else {
					//TODO: Handle this gracefully
				}
			} else {
				//TODO: Handle this gracefully / check for other element types
			}
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
