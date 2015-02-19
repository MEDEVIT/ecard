package at.medevit.elexis.at.ecard.client;

public class GINAServiceConstants {

	// Certificate Locations - relative to gina base path
	public static final String GINA_RELATIVE_URL_CA_PEM_LOCATION = "/ecard/certificates/gina_ca.pem";
	public static final String GINA_RELATIVE_URL_CA_CER_LOCATION = "/ecard/certificates/gina_ca.cer";

	// TimeOut Settings for GINA Requests
	public static final String GINA_REQUEST_TIMEOUT_SHORT = "kurz"; // >= 15
																	// Sekunden
	public static final String GINA_REQUEST_TIMEOUT_MIDDLE = "mittel"; // >= 60
																		// Sekunden
	public static final String GINA_REQUEST_TIMEOUT_LONG = "lang"; // >= 1500
																	// Sekunden
	public static final String[] GINA_REQUEST_TIMEOUT = {
			GINA_REQUEST_TIMEOUT_SHORT, GINA_REQUEST_TIMEOUT_MIDDLE,
			GINA_REQUEST_TIMEOUT_LONG };

}
