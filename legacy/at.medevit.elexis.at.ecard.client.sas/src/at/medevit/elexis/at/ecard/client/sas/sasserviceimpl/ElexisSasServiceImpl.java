package at.medevit.elexis.at.ecard.client.sas.sasserviceimpl;

import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.sas.soap.AbfrageErgebnis;
import at.chipkarte.client.sas.soap.Suchkriterien;
import at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienException;
import at.chipkarte.client.sas.soap.exceptions.SasException;
import at.medevit.elexis.at.ecard.client.sas.SasService;

public class ElexisSasServiceImpl implements IElexisSasService {
	
	@Override
	public Property[] checkStatus(String dialogId) throws AccessException, ServiceException,
		DialogException{
		return SasService.getInstance(null).checkStatus(dialogId);
	}
	
	@Override
	public AbfrageErgebnis svNummerAbfragen(String dialogId,
		Suchkriterien svNummerAbfragenSuchkriterien) throws AccessException, SasException,
		InvalidParameterSuchkriterienException, ServiceException, DialogException{
		return SasService.getInstance(null).svNummerAbfragen(dialogId,
			svNummerAbfragenSuchkriterien);
	}
	
	@Override
	public AbfrageErgebnis patientendatenAbfragen(String dialogId, String svNummer)
		throws AccessException, SasException, InvalidParameterSuchkriterienException,
		DialogException, ServiceException{
		return SasService.getInstance(null).patientendatenAbfragen(dialogId, svNummer);
	}
	
}
