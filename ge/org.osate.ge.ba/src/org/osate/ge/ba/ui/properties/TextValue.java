package org.osate.ge.ba.ui.properties;

class TextValue {
	private final String wholeText;
	private final String prefix;
	private final String suffix;
	private final int offset;
	private final String editableText;

	public TextValue(final String prefix, final String editableText, final String suffix) {
		final String prefixWithLineEnding = prefix + "\n";
		this.prefix = prefix;
		this.suffix = suffix;
		this.editableText = editableText;
		wholeText = prefixWithLineEnding + editableText + "\n" + suffix;
		offset = prefixWithLineEnding.length();
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

	String getSuffix() {
		return suffix;
	}
}
