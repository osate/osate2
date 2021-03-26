package org.osate.ge.ba.ui.properties;

/**
 * Text information for editing embedded models
 */
class EmbeddedTextValue {
	private final String wholeText;
	private final String prefix;
	private final int offset;
	private final String editableText;
	private final int updateLength;
	private final String originalText;

	public EmbeddedTextValue(final String orignalText, final String prefix, final String editableText,
			final String suffix) {
		this.prefix = prefix;
		this.editableText = editableText;
		this.originalText = orignalText;
		final String prefixWithLineEnding = prefix + "\n";
		wholeText = prefixWithLineEnding + editableText + "\n" + suffix;
		// Offset to show text within embedded styled text
		offset = prefixWithLineEnding.length();
		// Length of text to replace
		updateLength = orignalText.length() - prefix.length() - suffix.length();
	}

	String getOriginalText() {
		return originalText;
	}

	int getUpdateLength() {
		return updateLength;
	}

	String getEditableText() {
		return editableText;
	}

	int getEditableTextOffset() {
		return offset;
	}

	String getWholeText() {
		return wholeText;
	}

	String getPrefix() {
		return prefix;
	}
}
