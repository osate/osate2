package antlr;

/**
 * This is a modified copy of ANTLR's ANTLRException. This is needed by the Behavior Annex as it catches ANTLR 4
 * RecognitionExceptions and converts them to ANTLR 3 RecognitionExceptions. Previously, we had included an antlr.jar
 * file in org.osate.core in order to make RecognitionException available to other plug-ins. This seemed overkill as
 * only RecognitionException was required. Therefore, we decided to copy RecognitionException and its parent
 * ANTLRException and delete the jar file.
 *
 * The source for ANTLRException was found here:
 * https://github.com/nco/antlr2/blob/master/antlr/ANTLRException.java
 */
@SuppressWarnings("serial")
public class ANTLRException extends Exception {
	public ANTLRException() {
		super();
	}

	public ANTLRException(String message) {
		super(message);
	}

	public ANTLRException(String message, Throwable cause) {
		super(message, cause);
	}

	public ANTLRException(Throwable cause) {
		super(cause);
	}
}