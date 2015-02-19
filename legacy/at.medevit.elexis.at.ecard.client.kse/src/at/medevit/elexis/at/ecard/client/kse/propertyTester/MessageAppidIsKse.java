package at.medevit.elexis.at.ecard.client.kse.propertyTester;

import org.eclipse.core.expressions.PropertyTester;

import at.chipkarte.client.base.soap.Message;
import at.chipkarte.client.soap.constants.ServiceName;

/**
 * Tests if a message is bound for the kse application. Referenced by plugin.xml as
 * property tester.
 */
public class MessageAppidIsKse extends PropertyTester {
	
	public static final String ID = "at.medevit.elexis.at.ecard.client.kse.MessageAppidIsKse";
	
	public MessageAppidIsKse(){
	}
	
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue){
		Message m = (Message) receiver;
		if (m.getAppid().equalsIgnoreCase(ServiceName.KSE_SERVICE)) return true;
		return false; 
	}
	
}
