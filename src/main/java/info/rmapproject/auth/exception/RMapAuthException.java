/**
 * 
 */
package info.rmapproject.auth.exception;

/**
 * Handle custom Exceptions for RMapAuth module
 * @author khanson
 *
 */
public class RMapAuthException extends RuntimeException {

	/**
	 * serial version id
	 */
	private static final long serialVersionUID = 463336118510679273L;

	/**
	 * Instantiate RMapAuthException
	 */
	public RMapAuthException() {
		super();
	}

	/**
	 * Instantiate RMapAuthException with an error message
	 * @param arg0
	 */
	public RMapAuthException(String arg0) {
		super(arg0);
	}

	/**
	 * Instantiate RMapAuthException with a throwable exception
	 * @param arg0
	 */
	public RMapAuthException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * Instantiate RMapAuthException with an error message and a throwable exception
	 * @param arg0
	 * @param arg1
	 */
	public RMapAuthException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instantiate RMapAuthException with an error message and a throwable exception
	 * and parameters for enableSuppression and writableStackTrace
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public RMapAuthException(String arg0, Throwable arg1,
			boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
