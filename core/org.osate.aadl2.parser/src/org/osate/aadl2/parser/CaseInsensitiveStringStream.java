package org.osate.aadl2.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;

public class CaseInsensitiveStringStream extends ANTLRInputStream {
	public CaseInsensitiveStringStream(InputStream inStream) throws IOException
	{
			super(inStream);
	}

	public CaseInsensitiveStringStream(String fileName) throws IOException
	{
			super(new FileInputStream(fileName));
	}

	public CaseInsensitiveStringStream(String fileName, String encoding)
	throws IOException {
			super(new FileInputStream(fileName), encoding);
	}
		    
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
