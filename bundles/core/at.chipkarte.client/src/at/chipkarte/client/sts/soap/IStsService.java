/*
 * (C) SVCBE 2008
 */
package at.chipkarte.client.sts.soap;

import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.sts.soap.exceptions.InvalidParameterStsException;
import at.chipkarte.client.sts.soap.exceptions.StsException;

/**
 * <p>
 * Dieses Service stellt die Funktionalitäten des Security Token Service (STS)
 * zur Verfügung.
 * </p>
 */
public interface IStsService {

  /**
   * <p>
   * Diese Funktion liefert den Systemstatus des STS zurück.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf STS (siehe
   * {@link at.chipkarte.client.base.soap.constants.Berechtigungen#STS_CORE STS_CORE}).
   * </li>
   * </ul>
   * </p>
   * 
   * <p>
   * <B>Laufzeitgruppe: </B> Kurz
   * </p>
   * 
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @return Array mit Key und Wert eines Attributpaares, siehe auch
   *         {@link Property Property}<br>
   *         Möglicher Key siehe
   *         {@link at.chipkarte.client.base.soap.constants.StatusProperty#SERVICE_STATE SERVICE_STATE}.<br>
   *         Mögliche Werte siehe
   *         {@link at.chipkarte.client.base.soap.constants.Modus Modus Konstanten}<br>
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_STS_CORE MISSING_STS_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  Property[] checkStatus(String dialogId) throws DialogException, AccessException, ServiceException;

  /**
   * <p>
   * Mit dieser Funktion kann ein SAML-Ticket, zur Authentifizierung gegenüber
   * Drittsystemen, generiert werden.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Der Dialog ist im Online-Modus.</li>
   * <li>Zugriff auf STS (siehe
   * {@link at.chipkarte.client.base.soap.constants.Berechtigungen#STS_CORE STS_CORE}).
   * </li>
   * <li>Wenn die Abfrage mit der e-card durchgeführt wird, muss diese im
   * Kartenleser, der als Attribut angegeben ist, gesteckt sein.</li>
   * <li>Es wird nur dann auf eine gesteckte Karte zugegriffen, wenn explizit
   * ein Kartenleser angegeben ist (d.h. das Attribut cardReaderId befüllt ist).</li>
   * </ul>
   * </p>
   * 
   * <p>
   * <B>Laufzeitgruppe: </B> Mittel
   * </p>
   * 
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param requestSamlAssertionReq
   *          Parameter zum Anfordern eines SAML-Tickets.
   * @param cardReaderId
   *          Id eines Kartenlesers (optional).
   * @return Generierte SAML-Assertion als XML-String.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_STS_CORE MISSING_STS_CORE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_CERTIFICATE INVALID_CERTIFICATE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_MISMATCH CERTIFICATE_MISMATCH},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_SIGNATURE_ALGORITHM_INVALID CERTIFICATE_SIGNATURE_ALGORITHM_INVALID}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_OCARD WRONG_OCARD}
   * @throws StsException
   *           {@link at.chipkarte.client.sts.soap.constants.StsExceptionConstants#ASSERTION_SIGNING_FAILED ASSERTION_SIGNING_FAILED},
   *           {@link at.chipkarte.client.sts.soap.constants.StsExceptionConstants#PATIENT_CONTACT_QUALITY_VIOLATION PATIENT_CONTACT_QUALITY_VIOLATION},
   *           {@link at.chipkarte.client.sts.soap.constants.StsExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.sts.soap.constants.StsExceptionConstants#INVALID_SIGNATURE_EXCEPTION INVALID_SIGNATURE_EXCEPTION},
   *           {@link at.chipkarte.client.sts.soap.constants.StsExceptionConstants#NO_SVPERSON NO_SVPERSON},
   *           {@link at.chipkarte.client.sts.soap.constants.StsExceptionConstants#TICKETNAME_INVALID_NO_CONFIG_FOR_VERSION TICKETNAME_INVALID_NO_CONFIG_FOR_VERSION},
   *           {@link at.chipkarte.client.sts.soap.constants.StsExceptionConstants#NO_QUALIFICATION_FOR_REQUEST_ASSERTION NO_QUALIFICATION_FOR_REQUEST_ASSERTION},
   * @throws InvalidParameterStsException
   *           {@link at.chipkarte.client.sts.soap.constants.InvalidParameterStsExceptionConstants#INPUT_SVNUMBER_NOT_IDENT_CARD_SVNUMBER INPUT_SVNUMBER_NOT_IDENT_CARD_SVNUMBER},
   *           {@link at.chipkarte.client.sts.soap.constants.InvalidParameterStsExceptionConstants#INVALID_SV_NUMBER INVALID_SV_NUMBER},
   *           {@link at.chipkarte.client.sts.soap.constants.InvalidParameterStsExceptionConstants#SAME_TICKETPARAMETER_REPEATED SAME_TICKETPARAMETER_REPEATED},
   *           {@link at.chipkarte.client.sts.soap.constants.InvalidParameterStsExceptionConstants#TICKETPARAMETER_WRONG_FORMAT TICKETPARAMETER_WRONG_FORMAT},
   */
  RequestSamlAssertionResp requestSamlAssertion(String dialogId, RequestSamlAssertionReq requestSamlAssertionReq,
      String cardReaderId) throws AccessException, ServiceException, DialogException, CardException, StsException,
      InvalidParameterStsException;

}
