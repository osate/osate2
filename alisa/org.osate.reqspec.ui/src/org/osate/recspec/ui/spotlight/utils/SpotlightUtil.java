package org.osate.recspec.ui.spotlight.utils;

import java.util.Iterator;
import java.util.List;

import org.osate.reqspec.reqSpec.Requirement;

/** KEY ASSUMPTIONS: (1) calculatePUR should *only* be called for a component 
 *                       having at least one architecturally-significant requirement (ASR) mapping to it.
 *                   (2) All ASRs have a rating for uncertainty [volatility nv precedence np]
 *                       with nv and np integers 1..3; 
 *                       (as of this writing, reqspec syntax requires uncertainty include
 *                       a third rated sub-factor: impact, though this is not used by Spotlight).
 *                   (3) ASRs must be assigned 1..3 categories like this:
 *                       category Quality.Safety Quality.Security Quality.Performance
 *                       (all other categories are ignored by Spotlight, but Spotlight identifies
 *                       a requirement as an ASR if it has at least one of these categorizations).
 * @author mdk
 *
 */
public class SpotlightUtil {

	public static final String WORST_CASE = "worst_case";
	public static final String BEST_CASE = "best_case";
	
	//TODO: need to get persisted version of SpotlightFactorValues where values are set by user

	private List<Requirement> requirements;
	private SpotlightFactorValues factorVals = new SpotlightFactorValues();
	
//		//I'm commenting next bit out as I don't understand why we're declaring a method having same name as class
//	public SpotlightUtil() {
//	}

	public double calculatePUR(double systemsize, int numleaves, double revlmax, double revlmedian, double precmedian, int numSafety, int numSecurity, int numSafeOrSecure, int numPerformance){ 
//		/* Debug */ System.out.println("systemsize = " + systemsize + "; numleaves = " + numleaves);
		double WCEffort = calculateWorstCaseEffort(systemsize, numleaves, revlmax, revlmedian, precmedian, numSafety, numSecurity, numSafeOrSecure, numPerformance);
		double BCEffort = calculateBestCaseEffort(systemsize, numleaves, revlmax, revlmedian, precmedian, numSafety, numSecurity, numSafeOrSecure, numPerformance);
//		/* Debug */ System.out.println(); System.out.println("WC Effort = " + WCEffort);
//		/* Debug */ System.out.println("BC Effort = " + BCEffort);
		return  WCEffort-BCEffort;
	}
	
	private double calculateBestCaseEffort(double systemsize, int numleaves, double revlmax, double revlmedian, double precmedian, int numSafety, int numSecurity, int numSafeOrSecure, int numPerformance){
		return calculateBestCaseCocomoPower(systemsize, numleaves, revlmax, revlmedian, precmedian) * calculateBestCaseProductOfEffortMultipliers(numSafety, numSecurity, numSafeOrSecure, numPerformance);
	}
	
	private double calculateBestCaseCocomoPower(double systemsize, int numleaves, double revlmax, double revlmedian, double precmedian){
				return factorVals.getEffortEstimationConstantA() * (Math.pow(calculateBestCaseAdjustedSize(systemsize, numleaves, revlmax, revlmedian),calculateBestCaseExponent(precmedian)));
	}

	private double calculateBestCaseAdjustedSize(double systemsize, int numleaves, double revlmax, double revlmedian){
		double adjSize = calculateSzAssigned(systemsize, numleaves)*(1+(getRevl(revlmax, revlmedian, true)/100.0));
//		/* Debug */ System.out.println("BC adjusted size = " + adjSize);
		return adjSize;
	}

	private double calculateBestCaseExponent(double precmedian){
				return factorVals.getEffortEstimationConstantB() + (0.01 * calculateBestCaseSumOfScaleFactors(precmedian));
	}

	private double calculateBestCaseProductOfEffortMultipliers(int numSafety, int numSecurity, int numSafeOrSecure, int numPerformance){
		double multiplier;
		multiplier = calculateRely(numSafety, numSecurity, true) * calculateCplx(numSafety, numSecurity, numSafeOrSecure, numPerformance, true) * calculateTime(numPerformance, true) * calculateStor();
		double result = multiplier * calculateProductOfFactorValues();
		return result;
	}

	private double calculateBestCaseSumOfScaleFactors(double precmedian){
		double calculatedBCprec = calculateBestCasePrec(precmedian); 
//		/* Debug */ System.out.println("BC precedence = " + calculatedBCprec);
		return calculatedBCprec + factorVals.getFlex() + factorVals.getResl() + factorVals.getTeam() + factorVals.getPmat();
	}
	
	///////////////////////////////////////////////////////////// above: calculating best case related values
	private double calculateProductOfFactorValues(){
		return factorVals.productOfFactorValues();
	}

	private double calculateSzAssigned(double systemsize, int numleaves){
		return systemsize / numleaves; // Alternative approach: return factorVals.getTlc() / getLeafRequirements().size();
		}
	/////////////////////////////////////////////////////////////	below: calculating worst case related values

	private double calculateWorstCaseEffort(double systemsize, int numleaves, double revlmax, double revlmedian, double precmedian, int numSafety, int numSecurity, int numSafeOrSecure, int numPerformance){
		
		double WCPower = calculateWorstCaseCocomoPower(systemsize, numleaves, revlmax, revlmedian, precmedian);
		double WCProductMultipliers = calculateWorstCaseProductOfEffortMultipliers(numSafety, numSecurity, numSafeOrSecure, numPerformance);
//		/* Debug */  System.out.print("WC power = " + WCPower);
//		/* Debug */  System.out.println(" WC product effort multipliers = " + WCProductMultipliers);
		return WCPower * WCProductMultipliers;
	}
	
	private double calculateWorstCaseProductOfEffortMultipliers(int numSafety, int numSecurity, int numSafeOrSecure, int numPerformance){
		double derivedRELY = calculateRely(numSafety, numSecurity, false);
		double derivedCPLX = calculateCplx(numSafety, numSecurity, numSafeOrSecure, numPerformance, false);
		double derivedTIME = calculateTime(numPerformance, false);
		double derivedSTOR = calculateStor();
		double derivedFromDefaults = calculateProductOfFactorValues();
//		/* Debug */ System.out.println(); 
//		/* Debug */ System.out.println("Effort Multipliers: ");
//		/* Debug */ System.out.print(" RELY = " + derivedRELY);
//		/* Debug */ System.out.print(" CPLX = " + derivedCPLX);
//		/* Debug */ System.out.print(" TIME = " + derivedTIME);
//		/* Debug */ System.out.print(" Product of Defaults = " + derivedFromDefaults);
//		/* Debug */ System.out.println();
		double result = derivedRELY * derivedCPLX * derivedTIME * derivedSTOR * derivedFromDefaults;
		return result;
	}
	
	private double calculateWorstCaseCocomoPower(double systemsize, int numleaves, double revlmax, double revlmedian, double precmedian){
		double WCexp = calculateWorstCaseExponent(precmedian);
		double WCsize = calculateWorstCaseAdjustedSize(systemsize, numleaves, revlmax, revlmedian);
		double WCpowerPreA = Math.pow(WCsize, WCexp);
		double EffortEstConstA = factorVals.getEffortEstimationConstantA();
//		/* Debug */ System.out.print("WC exponent = " + WCexp);
//		/* Debug */ System.out.print("  WC size = " + WCsize);
//		/* Debug */ System.out.println("  WC power (pre-A) = " + WCpowerPreA);
		return EffortEstConstA * WCpowerPreA;
	}

	private double calculateWorstCaseAdjustedSize(double systemsize, int numleaves, double revlmax, double revlmedian){
		double adjSize = calculateSzAssigned(systemsize, numleaves)*(1+(getRevl(revlmax, revlmedian, false)/100.0));
		return adjSize;
	}
	
	private double calculateWorstCaseExponent(double precmedian){
		return factorVals.getEffortEstimationConstantB() + (0.01 * calculateWorstCaseSumOfScaleFactors(precmedian));
	}

	private double calculateWorstCaseSumOfScaleFactors(double precmedian){
		double calculatedWCprec = calculateWorstCasePrec(precmedian); 
//		/* Debug */ System.out.println("WC precedence = " + calculatedWCprec);
		return calculatedWCprec + factorVals.getFlex() + factorVals.getResl() + factorVals.getTeam() + factorVals.getPmat();
	}
	

	private double calculateBestCasePrec(double precmedian){
		//In the best case, PREC doesn't depend on the argument precmedian but is just VH, which is 1.24
		return 1.24;
	}
	
	private double calculateWorstCasePrec(double precmedian){
		//In the worst case, PREC is defined as follows: 1.0->6.20, etc. per Table 10 in the COCOMO II Model Definition Manual, Version 2.1
		int precmedianTimes10 = (int) (precmedian*10);
		double precRatingValue;
		switch (precmedianTimes10) {
			case 10:	precRatingValue = 6.20;
						break;
			case 15:	precRatingValue = 4.96;
						break;
			case 20:	precRatingValue = 3.72;
						break;
			case 25:	precRatingValue = 2.48;
						break;
			case 30:	precRatingValue = 1.24;
						break;
			//Debug: eliminate these comment statements
			//without a break statement, will the following be reached and reset precRatingValue?? 
			//I'm turning off the break statement though because I'm having repeated crashes now and this was nearly the last change I made 
			default:	precRatingValue = 3.72; //use Nominal 3.72 as default
						break;
		}
		return precRatingValue;
	}
	
	private double calculateRely(int numSafety, int numSecurity, boolean bestcase){
		//No easy way in Spotlight to reflect an entirely different allocation of ASRs, and thus WC and BC are treated same way (bestcase param is ignored)
		if (numSafety >= 1) return 1.26;
		if (numSecurity >= 1) return 1.10;
		return 1.00;
	}
	
	private double calculateCplx(int numSafety, int numSecurity, int numSafeOrSecure, int numPerformance, boolean bestcase){
		//I'm implementing a bit different than in Excel but following the initial
		//    step of multiplying # of times categories of Safety or Security appear plus one
		//    and # of times Performance category appears plus one
		//    and then based on Excel spreadsheet formula, calibrating the CPLX levels accordingly.
		//Note: in an earlier version of this method, I had used the parameter numSafeOrSecure but no longer do so.

		int NumSafeSecure = numSafety + numSecurity;
		int ProductSSAndP = (NumSafeSecure+1)*(numPerformance+1);
//		/* Debug */ System.out.println("(SS+)*(P+) = " + ProductSSAndP);

		double SqrtProduct = Math.sqrt(ProductSSAndP);
		if (SqrtProduct >= 3.5) /* then XH */ return 1.74;
		if (SqrtProduct >= 3.0) /* then VH */ return 1.34;
		if (SqrtProduct >= 2.4) /* then VH */ return 1.17; //Not a typo, I'm trying to accommodate SS = 2 and P = 1 => ProductSSAndP = 6
		if (SqrtProduct >= 2.0) /* then N */ return 1.00;
		if (SqrtProduct >= 1.5) /* then L */ return 0.87;
		/* else VL */ return 0.73;
	}

	private double calculateTime(int numPerformance, boolean bestcase){
		//Until we can query the AADL model or Alisa verification result for processor utilization, we'll use num of performance ASRs mapping to component
		if (numPerformance >= 3) /* then XH */ return 1.63;
		if (numPerformance >= 2) /* then VH */ return 1.29;
		if (numPerformance >= 1) /* then H */ return 1.11;
		/* else N */ return 1.00;
	}
	
	private double calculateStor(){
		//Until we can query the AADL model or Alisa verification result or assurance for memory utilization, we'll assume TIME is Nominal
		//Unlike calculateTime, we choose not to use num of performance ASRs to maintain some degree of orthogonality between these two factors
		return 1.0;
	}
		
	public double getRevl (double max, double median, boolean bestcase){
		if (bestcase) return 5.0;
		/* else worst case */
		if (median==3.0) return 60.0;
		if (max==3.0) return 45.0;
		if (median==2.0) return 30.0;
		if (max==2.0) return 20.0;
		return 5.0;
	}
	
}
