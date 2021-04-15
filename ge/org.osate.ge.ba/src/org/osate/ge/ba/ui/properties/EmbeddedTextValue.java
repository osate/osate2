package org.osate.ge.ba.ui.properties;

/**
 * Text information for editing embedded models
 */
public class EmbeddedTextValue {
	private final String wholeText;
	private final String prefix;
	private final int offset;
	private final String editableText;
	private final int updateLength;

	public EmbeddedTextValue(final String orignalText, final String prefix, final String editableText, final String suffix) {
		this.prefix = prefix;
		this.editableText = editableText;
		final String prefixWithLineEnding = prefix + "\n";
		wholeText = prefixWithLineEnding + editableText + "\n" + suffix;
		// Offset to show text within embedded styled text
		offset = prefixWithLineEnding.length();
		// Length of text to replace
		updateLength = orignalText.length() - prefix.length() - suffix.length();
	}

	public int getUpdateLength() {
		return updateLength;
	}

	public String getEditableText() {
		return editableText;
	}

	public int getEditableTextOffset() {
		return offset;
	}

	public String getWholeText() {
		return wholeText;
	}

	public String getPrefix() {
		return prefix;
	}
}
