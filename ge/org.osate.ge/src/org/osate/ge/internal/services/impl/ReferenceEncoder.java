package org.osate.ge.internal.services.impl;

// Helper class for encoding and decoding references. Handles escaping characters. Encoded strings are guaranteed not to include spaces
public class ReferenceEncoder {
	private static final char OUTER_ESCAPE_CHAR = '$'; // Used to start an escape sequence or to indicate a space when used afte ran inner escape character
	private static final char INNER_ESCAPE_CHAR = '%';
	private static final String ESCAPED_INNER_ESCAPE_CHAR = Character.toString(INNER_ESCAPE_CHAR) + INNER_ESCAPE_CHAR;	
	
	public static String encode(final String[] segs) {
		final StringBuilder sb = new StringBuilder();
		ReferenceEncoder.encodeSegment(sb, segs[0]);
		for(int i = 1; i < segs.length; i++) {
			sb.append(' ');
			if(segs[i] == null) {
				return null;
			}
			
			encodeSegment(sb, segs[i]);
		}
		
		return sb.toString();
	}
	
	public static String[] decode(final String referenceStr) {
		final String[] ref = referenceStr.split(" ");
		if(ref.length < 1) {
			return null;
		}
		
		// Restore spaces
		final StringBuilder sb = new StringBuilder();
		for(int i = 0; i < ref.length; i++) {
			sb.setLength(0);
			decodeSegment(sb, ref[i]);
			ref[i] = sb.toString();
		}
		
		return ref;
	}
	
	public static void encodeSegment(final StringBuilder sb, final String seg) {
		for(int i = 0; i < seg.length(); i++) {
			final char ch = seg.charAt(i);
			if(ch == OUTER_ESCAPE_CHAR) {
				sb.append(OUTER_ESCAPE_CHAR);
				sb.append(ch);
			} else if(ch == INNER_ESCAPE_CHAR) {
				sb.append(OUTER_ESCAPE_CHAR);
				sb.append(ESCAPED_INNER_ESCAPE_CHAR);
			} else if(ch == ' ') {
				sb.append(OUTER_ESCAPE_CHAR);
				sb.append(INNER_ESCAPE_CHAR);
				sb.append(OUTER_ESCAPE_CHAR);
			} else {
				sb.append(ch);
			}
		}
	}
	
	public static void decodeSegment(final StringBuilder sb, final String seg) {
		final int len = seg.length();
		for(int i = 0; i < len; i++) {
			char ch = seg.charAt(i);
			if(ch == OUTER_ESCAPE_CHAR) {
				i++;				
				if(i < len) {
					ch = seg.charAt(i);
					if(ch == OUTER_ESCAPE_CHAR) {
						sb.append(ch);
					} else if(ch == INNER_ESCAPE_CHAR) {
						i++;
						if(i < len) {
							ch = seg.charAt(i);
							if(ch == OUTER_ESCAPE_CHAR) {
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
	}

	// Simple main function that encodes and decodes strings for testing purposes.
	public static void main(final String[] args) {
		final StringBuilder sb = new StringBuilder();
		testEncodeDecode(sb, "Test");
		testEncodeDecode(sb, "C$");
		testEncodeDecode(sb, "C$ DE");
		testEncodeDecode(sb, "C$_DE");
	}
	
	private static void testEncodeDecode(final StringBuilder sb, final String str) {
		sb.setLength(0);
		encodeSegment(sb, str);
		final String encoded = sb.toString();
		sb.setLength(0);
		decodeSegment(sb, encoded);
		final String decoded = sb.toString();
		System.out.println("'" + str + "' : '" + encoded + "' : '" + decoded + "'");
	}
}
