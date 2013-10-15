package org.osate.analysis.lute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LuteResult {
	private int passed;
	private List<String> failMessages;
	private List<String> theoremsNames;
	
	public LuteResult() {
		this.passed = 0;
		this.failMessages = new ArrayList<String>();
		this.theoremsNames = new ArrayList<String>();
	}
	
	private LuteResult(int passed, List<String> failMessages) {
		this.passed = passed;
		this.failMessages = failMessages;
	}
	
	public static LuteResult pass() {
		return new LuteResult(1, Collections.<String> emptyList());
	}
	
	public static LuteResult fail(String message) {
		return new LuteResult(0, Collections.singletonList(message));
	}

	public static LuteResult empty() {
		return new LuteResult(0, Collections.<String> emptyList());
	}

	public int getPassed() {
		return passed;
	}

	public List<String> getFailMessages() {
		return Collections.unmodifiableList(failMessages);
	}
	
	public void addTheoremName (String s)
	{
		this.theoremsNames.add(s);
	}
	
	public List<String> getTheoremsNames() {
		return Collections.unmodifiableList(theoremsNames);
	}

	public void accumulate(LuteResult other) {
		this.passed += other.passed;
		this.failMessages.addAll(other.failMessages);
	}
}
