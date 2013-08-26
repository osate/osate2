package org.osate.aadl2.errormodel.analysis;

import org.osate.aadl2.util.OsateDebug;
import org.osate2.aadl2.errormodel.analysis.prism.ModelType;
import org.osate.aadl2.errormodel.analysis.actions.FHAAction;
/**
 * Options for the PRISM tool. This is just a static
 * class to access the options values.
 * @author jdelange
 *
 */
public class Options 
{
	
	/*
	 * The type of model we are suppose to generate
	 */
	private static ModelType modelType = ModelType.DTMC;
	
	private static int fhaReportType = FHAAction.REPORT_TYPE_ARP4761;
	
	public static int getFhaReportType ()
	{
		return fhaReportType;
	}
	
	public static void setFhaReportType (int t)
	{
		//OsateDebug.osateDebug("set report type to " + t);
		fhaReportType = t;
	}
	
	public static ModelType getModelType ()
	{
		return modelType;
	}
	
	public static void setModelType (ModelType mt)
	{
		//OsateDebug.osateDebug("[Options] setModelType, argument=" + mt);
		modelType = mt;
	}
	
	public static int getFhaReportTypeFromString (String s)
	{
		if (s.equals("arp4761"))
		{
			//OsateDebug.osateDebug("choose arp4761");
			return FHAAction.REPORT_TYPE_ARP4761;
		}
		if (s.equals("milstd881"))
		{
			//OsateDebug.osateDebug("choose mil");

			return  FHAAction.REPORT_TYPE_MILSTD882;
		}
		return FHAAction.REPORT_TYPE_ARP4761;

	}
	
	public static String getStringFromFhaReportType (int t)
	{
		if (t == FHAAction.REPORT_TYPE_ARP4761)
		{
			return "ARP4761";
		}
		if (t == FHAAction.REPORT_TYPE_MILSTD882)
		{
			return "MILSTD881";
		}
		return "ARP4761";
	}
}
