package info.rmapproject.auth.utils;

import info.rmapproject.auth.exception.ErrorCode;
import info.rmapproject.auth.exception.RMapAuthException;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Random;

import javax.xml.bind.DatatypeConverter;

/**
 * Utilities to support the rmap-auth component
 * @author khanson
 *
 */
public class Utils {
	
	/**
	 * Characters that are valid for use in a random string generator
	 */
	private static char[] VALID_CHARACTERS =
		    "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456879".toCharArray();
	
	/**
	 * Generate a random string of the length defined
	 * This used to create API keys and secrets.
	 * @param numChars
	 * @return
	 */
	public static String generateRandomString(int numChars) {
	  SecureRandom srand = new SecureRandom();
	    Random rand = new Random();
	    char[] buff = new char[numChars];

	    for (int i = 0; i < numChars; ++i) {
	      // reseed rand once you've used up all available entropy bits
	      if ((i % 10) == 0) {
	          rand.setSeed(srand.nextLong()); // 64 bits of random!
	      }
	      buff[i] = VALID_CHARACTERS[rand.nextInt(VALID_CHARACTERS.length)];
	    }
	    return new String(buff);
	  }

	/**
	 * Converts a given string to a Sha256 encoded string. Used to generate
	 * authIds
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String getSha256Hash(String str) throws Exception {
		String sha256Hash = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(str.getBytes("UTF-8"));
			sha256Hash = DatatypeConverter.printHexBinary(hash);
			sha256Hash = sha256Hash.toLowerCase();
		} catch (Exception ex){
			throw new RMapAuthException(ErrorCode.ER_PROBLEM_GENERATING_NEW_AUTHKEYURI.getMessage());
		}
		return sha256Hash;
	  }

	
	
} 

