package br.com.drbsoft.postbox.client.api.utils;

import static java.lang.String.format;

public class Utils {

	public static void checkNotNull(Object argument, String argumentName) {
        if (argument == null) {
            throw new IllegalArgumentException(format("The %s must not be null", argumentName));
        }
    }
	
	public static void checkArgument(boolean assertion, String message) {
        if (assertion) {
            throw new IllegalArgumentException(message);
        }
    }
}
