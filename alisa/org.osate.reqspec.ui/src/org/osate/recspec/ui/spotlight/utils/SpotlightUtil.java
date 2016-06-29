package org.osate.recspec.ui.spotlight.utils;

public class SpotlightUtil {

	public static final String WORST_CASE = "worst_case";
	public static final String BEST_CASE = "best_case";
	public SpotlightUtil() {
	}
	
	public float getRevl(String bestOrWorstCase){
		if (bestOrWorstCase.equals(BEST_CASE)){
			return 5;
		} else {
			//=IF(Spotlight!L76=1,
			//if leaf

			//   IF(COUNT(Spotlight!M76       : Spotlight!V76)=0,5,
			//   if none of requirements is ASR 0 else
			
			//			IF(
			//				=IF(MIN(C76:L76)<>0, MEDIAN(C76:L76), "")=3,60,
			//				if (any of requirements has non zero volatility rating then if the median of those = 3 return 60
			//              else 
			//				IF(N76=3,45,  IF(M76=2,30,    IF(N76=2, 20,     5     )    )   )  ) ),"")
				
			return 0;
		}
	}

}
