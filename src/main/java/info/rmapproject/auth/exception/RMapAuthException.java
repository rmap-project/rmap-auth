/**
 * 
 */
package info.rmapproject.auth.exception;

/**
 * @author khanson
 *
 */
public class RMapAuthException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 463336118510679273L;

	/**
	 * 
	 */
	public RMapAuthException() {
		super();
	}

	/**
	 * @param arg0
	 */
	public RMapAuthException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public RMapAuthException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public RMapAuthException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
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
