package org.osate.recspec.ui.spotlight.utils;

/**
 * KEY ASSUMPTIONS: (1) calculatePUR should *only* be called for a leaf
 * component instance having at least one architecturally-significant
 * requirement (ASR) mapping to it (ASR defined in assumption #3). (2) All ASRs
 * mapping to that component have a rating for uncertainty [volatility nv
 * precedence np] with nv and np integers 1..3. (As of this writing, reqspec
 * syntax requires uncertainty include a third rated sub-factor: impact, though
 * this is not used by Spotlight.) (3) ASRs are requirements that are assigned
 * at least one of the following categories: category: Quality.Safety
 * Quality.Security Quality.Performance (All other categories are ignored by
 * Spotlight, but Spotlight identifies a requirement as an ASR if it has at
 * least one of these categorizations).
 * 
 * @author mdk
 *
 */
public class SpotlightUtil {

	// TODO: need to get persisted version of SpotlightFactorValues where values
	// are set by user.
	//
	// Until then, the following declaration is intended to ensure no one
	// inadvertently instantiates this class
	private SpotlightUtil() {
	}

	private static final boolean IS_BEST_CASE = true;

	// Method calculatePUR is the sole public method in SpotlightUtil. It
	// calculates the "Potential for Uncertainty Reduction" in person months,
	// which is an estimate of how much effort can be saved by having the
	// architect work on that leaf component by further solution development
	// (architecting) that component (e.g., decomposing that component into
	// subcomponents that effectively separate safety and security vs.
	// performance concerns (derived ASRs); or reducing the average # of ASRs
	// allocated to each component or subcomponent, in general).
	// The estimate of PUR is achieved by using the COCOMO II
	// cost estimation model, with 5 scale factors and 17 effort multipliers,
	// using the defaults established in Java package SpotlightFactorValues for
	// 4 of the scale factors and 14 of the effort multipliers. The remaining 4
	// factors are derived from information in the ASRs mapped to that leaf
	// component. COCOMO II model is applied twice, once in worst case scenario,
	// and once in a best case scenario; the only difference being in the
	// ratings derived for PREC, RELY, CPLX, and TIME; plus a fifth factor,
	// REVL, used to adjust leaf component size by an estimate of future
	// growth. The result is two effort estimates, one worst case, and the other
	// best case. The two estimates are subtracted and the difference PUR
	// is a rough measure of the opportunity for system development savings (as
	// measured in person months) that might accrue.
	public static double calculatePUR(int numberLeaves, double revlMax, double revlMedian, double precMedian,
			int numSafety, int numSecurity, int numPerformance) {

		double WCEffort = calculateEffort(numberLeaves, revlMax, revlMedian, precMedian, numSafety, numSecurity,
				numPerformance, !(IS_BEST_CASE));
		double BCEffort = calculateEffort(numberLeaves, revlMax, revlMedian, precMedian, numSafety, numSecurity,
				numPerformance, IS_BEST_CASE);

		return Math.floor(WCEffort - BCEffort);
	}

	private static double calculateEffort(int numberLeaves, double revlMax, double revlMedian, double precMedian,
			int numSafety, int numSecurity, int numPerformance, boolean isForBestCase) {

		return calculateCocomoPower(numberLeaves, revlMax, revlMedian, precMedian, isForBestCase)
				* calculateProductOfEffortMultipliers(numSafety, numSecurity, numPerformance, isForBestCase);
	}

	private static double calculateProductOfEffortMultipliers(int numSafety, int numSecurity, int numPerformance,
			boolean isForBestCase) {

		double result = calculateRely(numSafety, numSecurity)
				* calculateCplx(numSafety, numSecurity, numPerformance, isForBestCase) * calculateTime(numPerformance)
				* SpotlightFactorValues.productOfFourteenDefaultEffortMultipliers();
		return result;
	}

	private static double calculateCocomoPower(int numberLeaves, double revlMax, double revlMedian, double precMedian,
			boolean isForBestCase) {

		return SpotlightFactorValues.EFFORT_ESTIMATION_CONSTANT_A
				* Math.pow(calculateAdjustedSize(numberLeaves, revlMax, revlMedian, isForBestCase),
						calculateExponent(precMedian, isForBestCase));

	}

	private static double calculateAdjustedSize(int numberLeaves, double revlMax, double revlMedian,
			boolean isForBestCase) {

		return calculateComponentSize(numberLeaves) * (1 + (getRevl(revlMax, revlMedian, isForBestCase) / 100.0));

	}

	private static double calculateExponent(double precMedian, boolean isForBestCase) {

		return SpotlightFactorValues.EFFORT_ESTIMATION_CONSTANT_B
				+ (0.01 * calculateSumOfScaleFactors(precMedian, isForBestCase));

	}

	private static double calculateSumOfScaleFactors(double precMedian, boolean isForBestCase) {

		return calculatePrec(precMedian, isForBestCase) + SpotlightFactorValues.sumOfFourDefaultScaleFactors();

	}

	// The following methods calculate the 5 factors (1 scale factor, 3 effort
	// multipliers, and 1 size-adjustment factor) from information contained in
	// the ASRs.

	// Method calculatePrec estimates, best-case and worst-case, the rating for
	// the COCOMO II factor PREC, which reflects the degree to which the leaf
	// component is precedented (i.e., the degree to which components like this
	// have // been built before, and thus the development risk of successfully
	// developing the component should be relatively low. These estimates are
	// based on the ASR precedented-ness ratings.
	//
	private static double calculatePrec(double precMedian, boolean isForBestCase) {

		double precRatingValue;
		if (isForBestCase) {
			// In the best case, PREC doesn't depend on the argument precMedian
			// but is just PREC_VH (the opposite of an unprecedented component).
			precRatingValue = SpotlightFactorValues.PREC_VH;
		} else {
			// In the worst case, PREC is defined as follows: 1->VL, etc.
			int precMedianTimesTen = (int) (precMedian * 10);

			switch (precMedianTimesTen) {
			case 10:
				precRatingValue = SpotlightFactorValues.PREC_VL;
				break;
			case 15:
				precRatingValue = SpotlightFactorValues.PREC_L;
				break;
			case 20:
				precRatingValue = SpotlightFactorValues.PREC_N;
				break;
			case 25:
				precRatingValue = SpotlightFactorValues.PREC_H;
				break;
			case 30:
				precRatingValue = SpotlightFactorValues.PREC_VH;
				break;
			default:
				precRatingValue = SpotlightFactorValues.PREC_N;
			}
		}
		
		return precRatingValue;
		
	}

	// Method calculateRely estimates, best-case and worst-case, the rating for
	// the COCOMO II factor RELY, which reflects the degree of required
	// reliability for the leaf component, and thus the development risk of
	// successfully achieving the desired reliability for that component.
	// These estimates are based on whether the ASRs that map to the component
	// are categorized as Safety and Security.
	//
	private static double calculateRely(int numSafety, int numSecurity) {
		// Returns H or VH if there are any safety or security requirements for
		// the
		// leaf component addressed by the arguments; otherwise, returns N (for
		// Nominal).

		if (numSafety >= 1)
			return SpotlightFactorValues.RELY_VH;
		if (numSecurity >= 1)
			return SpotlightFactorValues.RELY_H;
		return SpotlightFactorValues.RELY_N;
	}

	// Method calculateCplx estimates, best-case and worst-case, the rating for
	// the COCOMO II factor CPLX, which reflects both the complexity of the
	// problem to be solved and the solution approach. Of course, since our
	// worst-case and best-case estimates of CPLX are derived from the ASRs that
	// map to the leaf component, our estimates are primarily an estimate of
	// problem complexity, rather than solution complexity (the latter would
	// require analyzing the AADL model for the leaf component--a capability the
	// current method does not yet have.
	//
	private static double calculateCplx(int numSafety, int numSecurity, int numPerformance, boolean isForBestCase) {
		// The int parameters (numSafety, numSecurity, numPerformance) must
		// all be non-negative.
		//
		// For Worst Case: assumes that safety and security requirements
		// conflict with performance requirements, requiring careful attention
		// to tradeoffs and thus analysis of possible solutions to achieve
		// needed safety and security while minimizing impact on performance. As
		// a proxy to the amount of potential conflict among such requirements,
		// Spotlight multiplies sum of counts of Safety or Security requirements
		// plus one (plus one so that we're never multiplying by 0) and the
		// count of Performance requirements plus one.
		//
		// But for Best Case, Spotlight assumes that it is possible to better
		// partition the system and re-distribute the allocation of requirements
		// (either at a higher level above the leaf component, or among the
		// subcomponents of the leaf component itself) so that safety and
		// security requirements can be allocated in a way that doesn't
		// interfere with performance. So for Best Case, Spotlight only
		// considers the maximum of the same two factors that Spotlight
		// multiplies in the Worst Case.
		//
		// In either case, ASRComplexity is the square root of the resulting
		// expression. Note that if either the count of Performance or sum of
		// Safety and Security counts is zero, the Worst Case degenerates to the
		// Best Case (they are treated the same).

		int sumSafetySecurity = numSafety + numSecurity;
		int maxSafetySecurityVsPerformance = Math.max(sumSafetySecurity, numPerformance) + 1;
		int degreeOfPotentialConflict = (sumSafetySecurity + 1) * (numPerformance + 1);
		double asrComplexity;

		if (isForBestCase) {
			asrComplexity = Math.sqrt(maxSafetySecurityVsPerformance);
		} else {
			asrComplexity = Math.sqrt(degreeOfPotentialConflict);
		}

		if (asrComplexity >= 3.5) /* then XH */ return SpotlightFactorValues.CPLX_XH;
		if (asrComplexity >= 3.0) /* then VH */ return SpotlightFactorValues.CPLX_VH;
		// The test below for 2.4 rather than 2.5 is not a typo. If
		// SumSafetySecurity = 2 and numPerformance = 1, then I want the
		// ASRComplexity to be rated High, rather than Nominal.
		if (asrComplexity >= 2.4) /* then H */ return SpotlightFactorValues.CPLX_H;
		if (asrComplexity >= 2.0) /* then N */ return SpotlightFactorValues.CPLX_N;
		if (asrComplexity >= 1.5) /* then L */ return SpotlightFactorValues.CPLX_L;
		/* else VL */ return SpotlightFactorValues.CPLX_VL;
	}

	// Method calculateTime estimates, best-case and worst-case, the rating for
	// the COCOMO II factor TIME, which reflects the degree to which component
	// time performance is constrained by a combination of ASRs and design
	// decisions.
	// The current implementation of the method only analyzes the ASRs that map
	// to the leaf component, determining the number of ASRs categorized as
	// Category.Performance.
	// In a future version of the method, it might be possible to infer at a
	// parent or ancestor component level when time performance becomes critical
	// and set the TIME rating of all descendant leaf components to be VH or XH,
	// accordingly.
	//
	private static double calculateTime(int numPerformance) {
		// Until Spotlight can query the AADL model, Alisa verification result,
		// or Alisa assurance case for processor utilization, we'll use the
		// number of ASRs categorized as Performance that map to the component
		// to determine the TIME rating.

		if (numPerformance >= 3) /* then XH */ return SpotlightFactorValues.TIME_XH;
		if (numPerformance == 2) /* then VH */ return SpotlightFactorValues.TIME_VH;
		if (numPerformance == 1) /* then H */ return SpotlightFactorValues.TIME_H;
		/* else N */ return SpotlightFactorValues.TIME_N;
	}

	// Method getRevl provides worst-case and best-case estimates of the COCOMO
	// II parameter REVL, which is not a scale factor, nor an effort multiplier,
	// but rather used to adjust the size estimate based on future software
	// growth due to requirements volatility. In COCOMO II, REVL is actually a
	// percentage ranging from 0 to 100, i.e., a continuous variable (unlike the
	// scale factors and effort multipliers, which are all ordinal with
	// VL,L,N,H,VH,XH ratings), but we simplify the use of the factor
	// REVL by assuming specific values in the range 0 to 100 can be attained,
	// and treat REVL as we have the other COCOMO II factors as having VL, L, N,
	// H, and VH (XH not used) ratings, and associated values, which are defined
	// in SpotlightFactorValues. In this way, though we initially assumed all
	// leaf components are about the same size, we penalize leaf components
	// having (apparently) high volatility based on the volatility ratings of
	// the ASRs that map to them, by adjusting their size higher, thereby
	// amplifying the worst-case and best-case effort estimate difference, and
	// resulting in a higher rating for such volatile leaf components,
	// will rise higher in the rankings and are more likely to receive deserved
	// attention for further requirements exploration or development of a more
	// robust solution less sensitive to requirements volatility.
	//
	private static double getRevl(double max, double median, boolean isForBestCase) {
		if (isForBestCase)
			return SpotlightFactorValues.REVL_VL;
		/* else worst case */
		if (median == 3.0)
			return SpotlightFactorValues.REVL_VH;
		if (max == 3.0)
			return SpotlightFactorValues.REVL_H;
		if (median == 2.0)
			return SpotlightFactorValues.REVL_N;
		if (max == 2.0)
			return SpotlightFactorValues.REVL_L;
		return SpotlightFactorValues.REVL_VL;
	}

	// Method calculateComponentSize takes the total system size defined in
	// package SpotlightFactorValues and divides it by the passed argument,
	// which should be equal to the number of leaf components in the current
	// architectural description of the system that is being spotlighted.
	//
	// TODO: Actually, this method should only be called once for each
	// invocation of Spotlight, rather than for each leaf component. In a
	// future version of Spotlight, perhaps move this method into the
	// Spotlight Handler Xtend package, call it once there, and pass the
	// average leaf component size as an argument to the call to
	// cacluatePUR.
	//
	private static double calculateComponentSize(int numberLeaves) {

		return SpotlightFactorValues.TOTAL_SYSTEM_SIZE / numberLeaves;
	}

}
