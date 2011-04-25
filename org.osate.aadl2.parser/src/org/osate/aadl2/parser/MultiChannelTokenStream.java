package org.osate.aadl2.parser;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenSource;

public class MultiChannelTokenStream extends CommonTokenStream {
	public MultiChannelTokenStream() {
		super();
	}

	public MultiChannelTokenStream(TokenSource tokenSource) {
		super(tokenSource);
	}

	public MultiChannelTokenStream(TokenSource tokenSource, int channel) {
		super(tokenSource,channel);
	}

	public int indexOfPreviousInChannelToken(int i){
		if (i>0)
			i--;
		return this.skipOffTokenChannelsReverse(i);
	}
}
