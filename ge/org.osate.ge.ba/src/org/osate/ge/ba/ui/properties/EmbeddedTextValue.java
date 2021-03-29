package org.osate.ge.ba.ui.properties;

/**
 * Text information for editing embedded models
 */
class EmbeddedTextValue {
	private final String wholeText;
	private String prefix;
	private String suffix;
	private final int offset;
	private final String editableText;
	private int updateLength;
	private final String originalText;
	private int updateOffset;

	public EmbeddedTextValue(final String originalText, final String prefix, final String editableText,
			final String suffix) {
		this.prefix = prefix;
		updateOffset = prefix.length();
		this.suffix = suffix;
		this.editableText = editableText;
		this.originalText = originalText;
		final String prefixWithLineEnding = prefix + "\n";
		wholeText = prefixWithLineEnding + editableText + "\n" + suffix;
		// Offset to show text within embedded styled text
		offset = prefixWithLineEnding.length();

		// Length of text to replace
		updateLength = Math.max(0, originalText.length() - prefix.length() - suffix.length());
	}

	String getOriginalText() {
		return originalText;
	}

	int getUpdateLength() {
		System.err.println(updateLength + " updateLength");
		return updateLength;
	}

	String getEditableText() {
		return editableText;
	}

	int getEditableTextOffset() {
		return offset;
	}

	int getUpdateOffset() {
		return updateOffset;
	}

	void setUpdateOffset(final int updateOffset) {
		this.updateOffset = updateOffset;
	}

	String getWholeText() {
		return wholeText;
	}

	String getPrefix() {
		return prefix;
	}

	String getSuffix() {
		return suffix;
	}

	public void setPrefix(final String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(final String suffix) {
		this.suffix = suffix;
	}

	void setUpdateLength(final int updateLength) {
		this.updateLength = updateLength;
	}
}
