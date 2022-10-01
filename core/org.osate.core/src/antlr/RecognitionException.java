package antlr;

/**
 * This is a modified copy of ANTLR's RecognitionException. This is needed by the Behavior Annex as it catches ANTLR 4
 * RecognitionExceptions and converts them to ANTLR 3 RecognitionExceptions. Previously, we had included an antlr.jar
 * file in org.osate.core in order to make RecognitionException available to other plug-ins. This seemed overkill as
 * only RecognitionException was required. Therefore, we decided to copy RecognitionException and its parent
 * ANTLRException and delete the jar file.
 *
 * The source for RecognitionException was found here:
 * https://github.com/nco/antlr2/blob/master/antlr/RecognitionException.java
 */
/**
 * @deprecated
 */
@Deprecated(since="5.0")
@SuppressWarnings("serial")
public class RecognitionException extends ANTLRException {
	private final String fileName;
	private final int line;
	private final int column;

	public RecognitionException() {
		this("parsing error");
	}

	public RecognitionException(String message) {
		this(message, null, -1, -1);
	}

	public RecognitionException(String message, String fileName, int line) {
		this(message, fileName, line, -1);
	}

	public RecognitionException(String message, String fileName, int line, int column) {
		super(message);
		this.fileName = fileName;
		this.line = line;
		this.column = column;
	}

	public String getFilename() {
		return fileName;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	public String getErrorMessage() {
		return getMessage();
	}

	@Override
	public String toString() {
		var builder = new StringBuilder();
		if (fileName != null) {
			builder.append(fileName);
			builder.append(':');
		}
		if (line != -1) {
			if (fileName == null) {
				builder.append("line ");
			}
			builder.append(line);
			if (column != -1) {
				builder.append(':');
				builder.append(column);
			}
			builder.append(':');
		}
		builder.append(' ');
		builder.append(getMessage());
		return builder.toString();
	}
}