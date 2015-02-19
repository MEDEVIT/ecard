package at.medevit.elexis.at.ecard.client.base.exceptionHandler;

import at.chipkarte.client.base.soap.constants.CardExceptionConstants;
import at.chipkarte.client.base.soap.exceptions.CardException;

public class CardExceptionHandler {

	public static void handle(CardException e){
		switch (e.getErrorCode()) {
		case CardExceptionConstants.TRANSPORT_PIN:
			// Transport PIN is still set
			break;
		default: 
			e.printStackTrace();
		}

	}
	
}