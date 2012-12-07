/*
Copyright (c) 2011, Rockwell Collins.
Developed with the sponsorship of the Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/

package org.osate.validation;

public class IndentedBuffer {
	private StringBuilder sb = new StringBuilder();
	private int indent = 0;
	private boolean newline = true;
	
	public void indent() {
		indent += 2;
	}
	
	public void unindent() {
		indent -= 2;
	}
	
	public void println(String text) {
		print(text);
		sb.append("\n");
		newline = true;
	}
	
	public void print(String string) {
		if (newline) {
			for (int i = 0; i < indent; i++) {
				sb.append(" ");
			}
			newline = false;
		}
		sb.append(string);
	}
	
	public void newline() {
		sb.append("\n");
		newline = true;
	}
	
	@Override
	public String toString() {
		return sb.toString();
	}
}
