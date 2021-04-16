package org.osate.ge.ba.ui.properties;

/**
 * Text information for editing embedded models
 */
public class EmbeddedTextValue {
	private final String wholeText;
	private final String prefix;
	private final String suffix;
	private final int offset;
	private final String editableText;
	private int updateOffset;
	private int updateLength;

	public EmbeddedTextValue(final String originalText, final String prefix, final String editableText, final String suffix) {
		this.prefix = prefix;
		updateOffset = prefix.length();
		this.suffix = suffix;
		this.editableText = editableText;
		final String prefixWithLineEnding = prefix + "\n";
		wholeText = prefixWithLineEnding + editableText + "\n" + suffix;
		// Offset to show text within embedded styled text
		offset = prefixWithLineEnding.length();
		// Length of text to replace
		updateLength = Math.max(0, originalText.length() - prefix.length() - suffix.length());
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

	public String getSuffix() {
		return suffix;
	}

	public int getUpdateOffset() {
		return updateOffset;
	}

	public void setUpdateOffset(final int updateOffset) {
		this.updateOffset = updateOffset;
	}

	public void setUpdateLength(final int updateLength) {
		this.updateLength = updateLength;
	}
}
