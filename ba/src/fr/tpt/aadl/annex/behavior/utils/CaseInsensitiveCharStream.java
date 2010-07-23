package fr.tpt.aadl.annex.behavior.utils;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;

public class CaseInsensitiveCharStream extends ANTLRStringStream {

	public CaseInsensitiveCharStream(String src)
	{
		super(src);
	}
	
	@Override
	public int LA(int i) {
		if ( i==0 ) {
			return 0; // undefined
		}
		if ( i<0 ) {
			i++; // e.g., translate LA(-1) to use offset 0 
		}

		if ( (p+i-1) >= n ) {
            //System.out.println("char LA("+i+")=EOF; p="+p);
            return CharStream.EOF;
        }
        //System.out.println("char LA("+i+")="+data.charAt(p+i-1)+";p="+p);
		if (Character.isUpperCase(data[p+i-1]))
        	return Character.toLowerCase(data[p+i-1]);
		
		return data[p+i-1];
	}
}
