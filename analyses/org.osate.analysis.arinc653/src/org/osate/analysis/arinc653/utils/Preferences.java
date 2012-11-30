package org.osate.analysis.arinc653.utils;

public class Preferences {
	
	private static Preferences instance = null;
	public static int MAJOR_FRAME_DELAYED = 1;
	public static int IMMEDIATE = 0;
	public static int INVALID = -1;
	
	private int connectionType;
	
	public Preferences ()
	{
		connectionType = MAJOR_FRAME_DELAYED;
	}
	
	public static Preferences getInstance ()
	{
		if (instance == null)
		{
			instance = new Preferences ();
		}
		return instance;
	}
	
	public void setConnectionType (int v)
	{
		this.connectionType = v;
	}
	
	public int getConnectionType ()
	{
		return this.connectionType;
	}
	
	public boolean useMajorFrameDelayedCommunication ()
	{
		return (this.connectionType == MAJOR_FRAME_DELAYED);
	}
	
	
	public boolean useImmediateCommunication ()
	{
		return (this.connectionType == IMMEDIATE);
	}
}
