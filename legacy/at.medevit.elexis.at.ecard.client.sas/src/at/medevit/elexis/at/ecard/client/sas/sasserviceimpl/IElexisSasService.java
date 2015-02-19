package at.medevit.elexis.at.ecard.client.sas.sasserviceimpl;

public interface IElexisSasService {
	public at.chipkarte.client.base.soap.Property[] checkStatus(java.lang.String dialogId)
		throws at.chipkarte.client.base.soap.exceptions.AccessException,
		at.chipkarte.client.base.soap.exceptions.ServiceException,
		at.chipkarte.client.base.soap.exceptions.DialogException;
	
	public at.chipkarte.client.sas.soap.AbfrageErgebnis svNummerAbfragen(java.lang.String dialogId,
		at.chipkarte.client.sas.soap.Suchkriterien svNummerAbfragenSuchkriterien)
		throws at.chipkarte.client.base.soap.exceptions.AccessException,
		at.chipkarte.client.sas.soap.exceptions.SasException,
		at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienException,
		at.chipkarte.client.base.soap.exceptions.ServiceException,
		at.chipkarte.client.base.soap.exceptions.DialogException;
	
	public at.chipkarte.client.sas.soap.AbfrageErgebnis patientendatenAbfragen(
		java.lang.String dialogId, java.lang.String svNummer) throws 
		at.chipkarte.client.base.soap.exceptions.AccessException,
		at.chipkarte.client.sas.soap.exceptions.SasException,
		at.chipkarte.client.sas.soap.exceptions.InvalidParameterSuchkriterienException,
		at.chipkarte.client.base.soap.exceptions.DialogException,
		at.chipkarte.client.base.soap.exceptions.ServiceException;
}
