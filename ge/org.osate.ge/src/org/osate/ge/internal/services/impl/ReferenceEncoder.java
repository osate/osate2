package org.osate.ge.internal.services.impl;

// Helper class for encoding and decoding references. Handles escaping characters. Encoded strings are guaranteed not to include spaces
public class ReferenceEncoder {
	private static final char ESCAPE_CHAR = '$';
	
	public static String encodeSegment(final String seg) {
		final StringBuilder sb = new StringBuilder(); // TODO: PASS IT IN?
		for(int i = 0; i < seg.length(); i++) {
			final char ch = seg.charAt(i);
			if(ch == ESCAPE_CHAR) {
				sb.append(ESCAPE_CHAR);
				sb.append(ch);
			} else if(ch == '_') {
				sb.append(ESCAPE_CHAR);
				sb.append("__");
			} else if(ch == ' ') {
				sb.append(ESCAPE_CHAR);
				sb.append('_');
				sb.append(ESCAPE_CHAR);
			} else {
				sb.append(ch);
			}
		}
		
		return sb.toString();
	}
	
	public static String decodeSegment(final String seg) {
		final StringBuilder sb = new StringBuilder(); // TODO: PASS IT IN?
		final int len = seg.length();
		for(int i = 0; i < len; i++) {
			char ch = seg.charAt(i);
			if(ch == ESCAPE_CHAR) {
				i++;				
				if(i < len) {
					ch = seg.charAt(i);
					if(ch == ESCAPE_CHAR) {
						sb.append(ch);
					} else if(ch == '_') {
						i++;
						if(i < len) {
							ch = seg.charAt(i);
							if(ch == ESCAPE_CHAR) {
								sb.append(' ');
							} else {
								sb.append(ch);
							}
						}
					}
				}				
			} else {
				sb.append(ch);
			}
		}
				
		return sb.toString();
	}
	
	// PROBLEM.. Splitting it... There encoded has spaces in it
	public static void main(final String[] args) {
		testEncodeDecode("Test");
		testEncodeDecode("C$");
		testEncodeDecode("C$ DE");
		testEncodeDecode("C$_DE");
	}
	
	private static void testEncodeDecode(final String str) {
		final String encoded = encodeSegment(str);
		final String decoded = decodeSegment(encoded);
		System.out.println("'" + str + "' : '" + encoded + "' : '" + decoded + "'");
	}
}
