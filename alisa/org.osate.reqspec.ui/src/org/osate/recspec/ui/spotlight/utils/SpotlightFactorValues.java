package org.osate.recspec.ui.spotlight.utils;

/**
 * Class for storing user and defalut assigned values for spotlight
 * 
 * @author mdk klream
 *
 */

public class SpotlightFactorValues {
	// The 22 COCOMO II cost drivers’ 6 ratings (VL, L, N, H, VH, XH) are
	// declared as constants, and they are given the non-negative values
	// associated with them in the COCOMO II model definition manual (COCOMO II
	// Model Definition Manual, page 75). However, the model definition manual
	// doesn’t always assign values for all six ratings (specifically, VL, L,
	// and XL ratings are sometimes not assigned any values), and so -1.00 was
	// assigned to these in order to treat all 22 cost drivers uniformly. A
	// simple test for negative values will then help determine when a
	// particular cost driver actually has a rating defined in the model
	// definition manual.

	public static final double PREC_VL = 6.20;
	public static final double PREC_L = 4.96;
	public static final double PREC_N = 3.72;
	public static final double PREC_H = 2.48;
	public static final double PREC_VH = 1.24;
	public static final double PREC_XH = 0.00;
	public static final double FLEX_VL = 5.07;
	public static final double FLEX_L = 4.05;
	public static final double FLEX_N = 3.04;
	public static final double FLEX_H = 2.03;
	public static final double FLEX_VH = 1.01;
	public static final double FLEX_XH = 0.00;
	public static final double RESL_VL = 7.07;
	public static final double RESL_L = 5.65;
	public static final double RESL_N = 4.24;
	public static final double RESL_H = 2.83;
	public static final double RESL_VH = 1.41;
	public static final double RESL_XH = 0.00;
	public static final double TEAM_VL = 5.48;
	public static final double TEAM_L = 4.38;
	public static final double TEAM_N = 3.29;
	public static final double TEAM_H = 2.19;
	public static final double TEAM_VH = 1.10;
	public static final double TEAM_XH = 0.00;
	public static final double PMAT_VL = 7.80;
	public static final double PMAT_L = 6.24;
	public static final double PMAT_N = 4.68;
	public static final double PMAT_H = 3.12;
	public static final double PMAT_VH = 1.56;
	public static final double PMAT_XH = 0.00;
	public static final double RELY_VL = 0.82;
	public static final double RELY_L = 0.92;
	public static final double RELY_N = 1.00;
	public static final double RELY_H = 1.10;
	public static final double RELY_VH = 1.26;
	public static final double RELY_XH = -1.00;
	public static final double DATA_VL = -1.00;
	public static final double DATA_L = 0.90;
	public static final double DATA_N = 1.00;
	public static final double DATA_H = 1.14;
	public static final double DATA_VH = 1.28;
	public static final double DATA_XH = -1.00;
	public static final double CPLX_VL = 0.73;
	public static final double CPLX_L = 0.87;
	public static final double CPLX_N = 1.00;
	public static final double CPLX_H = 1.17;
	public static final double CPLX_VH = 1.34;
	public static final double CPLX_XH = 1.74;
	public static final double RUSE_VL = -1.00;
	public static final double RUSE_L = 0.95;
	public static final double RUSE_N = 1.00;
	public static final double RUSE_H = 1.07;
	public static final double RUSE_VH = 1.15;
	public static final double RUSE_XH = 1.24;
	public static final double DOCU_VL = 0.81;
	public static final double DOCU_L = 0.91;
	public static final double DOCU_N = 1.00;
	public static final double DOCU_H = 1.11;
	public static final double DOCU_VH = 1.23;
	public static final double DOCU_XH = -1.00;
	public static final double TIME_VL = -1.00;
	public static final double TIME_L = -1.00;
	public static final double TIME_N = 1.00;
	public static final double TIME_H = 1.11;
	public static final double TIME_VH = 1.29;
	public static final double TIME_XH = 1.63;
	public static final double STOR_VL = -1.00;
	public static final double STOR_L = -1.00;
	public static final double STOR_N = 1.00;
	public static final double STOR_H = 1.05;
	public static final double STOR_VH = 1.17;
	public static final double STOR_XH = 1.46;
	public static final double PVOL_VL = -1.00;
	public static final double PVOL_L = 0.87;
	public static final double PVOL_N = 1.00;
	public static final double PVOL_H = 1.15;
	public static final double PVOL_VH = 1.30;
	public static final double PVOL_XH = -1.00;
	public static final double ACAP_VL = 1.42;
	public static final double ACAP_L = 1.19;
	public static final double ACAP_N = 1.00;
	public static final double ACAP_H = 0.85;
	public static final double ACAP_VH = 0.71;
	public static final double ACAP_XH = -1.00;
	public static final double PCAP_VL = 1.34;
	public static final double PCAP_L = 1.15;
	public static final double PCAP_N = 1.00;
	public static final double PCAP_H = 0.88;
	public static final double PCAP_VH = 0.76;
	public static final double PCAP_XH = -1.00;
	public static final double PCON_VL = 1.29;
	public static final double PCON_L = 1.12;
	public static final double PCON_N = 1.00;
	public static final double PCON_H = 0.90;
	public static final double PCON_VH = 0.81;
	public static final double PCON_XH = -1.00;
	public static final double APEX_VL = 1.22;
	public static final double APEX_L = 1.10;
	public static final double APEX_N = 1.00;
	public static final double APEX_H = 0.88;
	public static final double APEX_VH = 0.81;
	public static final double APEX_XH = -1.00;
	public static final double PLEX_VL = 1.19;
	public static final double PLEX_L = 1.09;
	public static final double PLEX_N = 1.00;
	public static final double PLEX_H = 0.91;
	public static final double PLEX_VH = 0.85;
	public static final double PLEX_XH = -1.00;
	public static final double LTEX_VL = 1.20;
	public static final double LTEX_L = 1.09;
	public static final double LTEX_N = 1.00;
	public static final double LTEX_H = 0.91;
	public static final double LTEX_VH = 0.84;
	public static final double LTEX_XH = -1.00;
	public static final double TOOL_VL = 1.17;
	public static final double TOOL_L = 1.09;
	public static final double TOOL_N = 1.00;
	public static final double TOOL_H = 0.90;
	public static final double TOOL_VH = 0.78;
	public static final double TOOL_XH = -1.00;
	public static final double SITE_VL = 1.22;
	public static final double SITE_L = 1.09;
	public static final double SITE_N = 1.00;
	public static final double SITE_H = 0.93;
	public static final double SITE_VH = 0.86;
	public static final double SITE_XH = 0.80;
	public static final double SCED_VL = 1.43;
	public static final double SCED_L = 1.14;
	public static final double SCED_N = 1.00;
	public static final double SCED_H = 1.00;
	public static final double SCED_VH = 1.00;
	public static final double SCED_XH = -1.00;

	// Though COCOMO II model defines REVL as a continuous factor: "to adjust
	// the effective size of the product caused by requirements evolution and
	// volatility caused by such factors as mission or user interface evolution,
	// technology upgrades, or COTS volatility. It is the percentage of code
	// discarded due to requirements evolution;" we define it as an ordinal
	// variable attaining specific percentages, using the same suffixes as for
	// the 22 COCOMO II cost drivers above.

	public static final double REVL_VL = 5;
	public static final double REVL_L = 20;
	public static final double REVL_N = 30;
	public static final double REVL_H = 45;
	public static final double REVL_VH = 60;
	public static final double REVL_XH = 90;

	// COCOMO II model definition manual also defines two effort estimation
	// constants:
	// the constant A is used as a multiplier and constant B as an addend in the
	// exponent.

	public static final double EFFORT_ESTIMATION_CONSTANT_A = 2.94;
	public static final double EFFORT_ESTIMATION_CONSTANT_B = 0.91;

	// Finally, we provide a default total size for the system,
	// which we will assume is measured in KSLOC.

	// TODO; There will need to be a screen for user to enter this value and a
	// way to persist this in OSATE

	public static final double TOTAL_SYSTEM_SIZE = 10000.0;

	// Then we will need some derived constants from the above.

	// TODO; There will need to be a screen for user to modify the ratings
	// selected for the four default scale factors and the fourteen
	// default effort mulipliers

	public static final double sumOfFourDefaultScaleFactors() {
		// Default ratings are used for 4 of the 5 scale factors (all but
		// PREC). The ratings are for those of a savvy,
		// process-disciplined organization, with a well-aligned and very
		// capable but not necessarily co-located team,
		// developing a safety-critical system in a regulated industry.
		//
		return FLEX_VL + RESL_VH + TEAM_VH + PMAT_H;
	}

	public static final double productOfFourteenDefaultEffortMultipliers() {
		// Default ratings are used for 14 of the 17 effort multipliers (all but
		// RELY, CPLX, TIME). The ratings are for those of a savvy,
		// process-disciplined organization, with a well-aligned and very
		// capable but not necessarily co-located team,
		// developing a safety-critical system in a regulated industry.
		//
		// Until we can query the AADL model or Alisa verification result or
		// assurance case for memory utilization, we'll assume STOR is Nominal.
		// Unlike calculateTime, we choose not to use num of performance ASRs
		// to maintain orthogonality between these two factors and not "double
		// count."

		return DATA_VH * RUSE_VH * DOCU_VH * STOR_N 
				* PVOL_VH * ACAP_VH * PCAP_VH * PCON_VH 
				* APEX_VH * PLEX_VH * LTEX_VH * TOOL_VH 
				* SITE_H * SCED_N;
	}

}
