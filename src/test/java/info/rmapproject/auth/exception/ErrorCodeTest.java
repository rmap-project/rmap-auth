package info.rmapproject.auth.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ErrorCodeTest {

	@Test
	public void testGetMessage() {
		String message = ErrorCode.ER_KEY_INACTIVE.getMessage();
		assertEquals(message, "The key provided is inactive");
	}

}
