package org.osate.recspec.ui.spotlight.utils;

import java.util.Iterator;
import java.util.List;

import org.osate.reqspec.reqSpec.Requirement;

public class SpotlightUtil {

	public static final String WORST_CASE = "worst_case";
	public static final String BEST_CASE = "best_case";
	//TODO: need to get persisted version of SpotlightFactorValues where values are set by user
	private int totalLeafCounts;
	private List<Requirement> requirements;
	private SpotlightFactorValues factorVals = new SpotlightFactorValues();
	
		
	public SpotlightUtil() {
	}
	
	public double calculatePUR(){
		return calculateWorstCaseEffort() - calculateBestCaseEffort();
	}
	
	private double calculateBestCaseEffort(){
		return calculateBestCaseCocomoPower() * calculateBestCaseProductOfEffortMultipliers();
	}
	
	private double calculateBestCaseCocomoPower(){
		return factorVals.getEffortEstimationA() * (Math.pow(calculateBestCaseAdjustedSize(),calculateBestCaseExponent()));
	}

	private double calculateBestCaseAdjustedSize(){
		return calculateSzAssigned()*(1+(getRevl(BEST_CASE)/100));
	}

	private double calculateBestCaseExponent(){
		return factorVals.getEffortEstimationB() + (0.01 * calculateBestCaseSumOfScaleFactors());
	}

	private double calculateBestCaseProductOfEffortMultipliers(){
		double multiplier = 1;
		multiplier = calculateRely() * calculateCplx() * calculateTime() * calculateStor();
		double result = multiplier * calculateProductOfFactorValues();
		return result;
	}

	private double calculateBestCaseSumOfScaleFactors(){
		return calculateBestCasePrec() + factorVals.getFlex() + factorVals.getResl() + factorVals.getTeam() + factorVals.getPmat();
	}
	
	/////////////////////////////////////////////////////////////
	private double calculateProductOfFactorValues(){
		return factorVals.productOfFactorValues();
	}

	private double calculateSzAssigned(){
		return factorVals.getTlc() / getLeafRequirements().size();
	}
	/////////////////////////////////////////////////////////////	
	private double calculateWorstCaseEffort(){
		return calculateWorstCaseCocomoPower() * calculateWorstCaseProductOfEffortMultipliers();
	}
	
	private double calculateWorstCaseProductOfEffortMultipliers(){
		double multiplier = 1;
		multiplier = calculateRely() * calculateCplx() * calculateTime() * calculateStor();
		double result = multiplier * calculateProductOfFactorValues();
		return result;
	}
	
	private double calculateWorstCaseCocomoPower(){
		return factorVals.getEffortEstimationA() * (Math.pow(calculateWorstCaseAdjustedSize(),calculateWorstCaseExponent()));

	}
	private double calculateWorstCaseAdjustedSize(){
		return calculateSzAssigned()*(1+(getRevl(WORST_CASE)/100));
	}
	
	private double calculateWorstCaseExponent(){
		return factorVals.getEffortEstimationB() + (0.01 * calculateWorstCaseSumOfScaleFactors());
	}

	private double calculateWorstCaseSumOfScaleFactors(){
		return calculateWorstCasePrec() + factorVals.getFlex() + factorVals.getResl() + factorVals.getTeam() + factorVals.getPmat();
	}
	

	private double calculateBestCasePrec(){
		//TODO =IF(L76<>"",HLOOKUP(3,'6-Factor Rating Values'!$C$3:$H$4,2,FALSE),"")
		return 0;
	}
	private double calculateWorstCasePrec(){
		//TODO '6-Factor Rating Values'!AB76
		return 0;
	}
	private double calculateRely(){
		//TODO ='6-Factor Rating Values'!AP76
		return 0;
	}
	private double calculateCplx(){
		//TODO ='6-Factor Rating Values'!BR76
		return 0;
	}
	private double calculateTime(){
		//TODO ='6-Factor Rating Values'!BX76
		return 0;
	}
	private double calculateStor(){
		//TODO ='6-Factor Rating Values'!BY76
		return 0;
	}
	
	
	
	
	public double getRevl(String bestOrWorstCase){
		if (bestOrWorstCase.equals(BEST_CASE)){
			return 5;
		} else {
			Iterator<Requirement> iter = getLeafRequirements().iterator();
			boolean nonZeroVolatility = false;
			while (iter.hasNext()){
				Requirement nextRequirement = iter.next();
				if(nextRequirement.getChangeUncertainty() != null) {
					if (nextRequirement.getChangeUncertainty().getVolatility() > 0){
						nonZeroVolatility = true;
					}
				} 
			}
			if (nonZeroVolatility) {
				return 60;
			} else {
				//TODO: Not sure how this translates
				//IF(N76=3,45,  IF(M76=2,30,    IF(N76=2, 20,     5     )    )   )  ) ),"")
				//if 
			}
		}
		return 0;
	}

	public List<Requirement> getLeafRequirements() {
		return requirements;
	}

	public void setLeafRequirements(List<Requirement> requirements) {
		//TODO: need to set leaf requirements in SpotlightExportHandler
		this.requirements = requirements;
	}

}
