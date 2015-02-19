/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap;

import at.chipkarte.client.base.soap.BaseProperty;
import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.uze.soap.exceptions.UzeAnspruchException;
import at.chipkarte.client.uze.soap.exceptions.UzeException;
import at.chipkarte.client.uze.soap.exceptions.UzeFachgebietException;
import at.chipkarte.client.uze.soap.exceptions.UzeInvalidParameterException;

/**
 * <p>
 * Dieses Service stellt die Funktionalit&auml;ten des &Uuml;ber-/Zu-/Einweisung
 * (UZE) zur Verf&uuml;gung.
 * </p>
 */
public interface IUzeService {

  /**
   * <p>
   * Diese Funktion liefert den Systemstatus des UZE- Services zur&uuml;ck.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgef&uuml;hrt.</li>
   * <li>Zugriff auf UZE
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#UZE_CORE UZE_CORE}).
   * </li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Kurz</p>
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @return Array mit Key und Wert eines Attributpaares, siehe auch {@link Property Property}<br>
   *           M&ouml;glicher Key siehe {@link at.chipkarte.client.base.soap.constants.StatusProperty#SERVICE_STATE SERVICE_STATE}.<br>
   *           M&ouml;gliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Modus Modus Konstanten}<br>
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  Property[] checkStatus(String dialogId) throws AccessException, DialogException, ServiceException;

  /**
   * <p>
   * Diese Funktion liefert die Fachgebiete, f&uuml;r die eine Zuweisung ohne Patientenkontakt erstellt werden kann.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <p>Keine weiteren.</p>
   * 
   * <p><B>Laufzeitgruppe: </B> Kurz</p>
   * @return Liste von Fachgebieten, siehe
   *         {@link at.chipkarte.client.base.soap.BaseProperty BaseProperty}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  BaseProperty[] getFachgebieteZo () throws ServiceException;

  /**
   * <p>
   * Diese Funktion liefert alle Weisungstypen, f&uuml;r die ein Leistungsanforderer eine UZE erstellen kann.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <p>Keine weiteren.</p>
   * 
   * <p><B>Laufzeitgruppe: </B> Kurz</p> 
   * @return Liste von Weisungstypen, siehe
   *         {@link at.chipkarte.client.base.soap.BaseProperty BaseProperty}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  BaseProperty[] getWeisungstypenLa() throws ServiceException;
  
  /**
   * <p>
   * Diese Funktion liefert alle Weisungstypen, f&uuml;r die ein Leistungserbringer eine UZE einl&ouml;sen kann.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <p>Keine weiteren.</p>
   * 
   * <p><B>Laufzeitgruppe: </B> Kurz</p> 
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @return Liste von Weisungstypen, siehe
   *         {@link at.chipkarte.client.base.soap.BaseProperty BaseProperty}
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  BaseProperty[] getWeisungstypenLe (String dialogId) throws  AccessException, DialogException, ServiceException;

  /**
   * <p>
   * Diese Funktion liefert alle Behandlungskontexte, f&uuml;r die ein Leistungsanforderer eine UZE erstellen kann.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <p>Keine weiteren.</p>
   * 
   * <p><B>Laufzeitgruppe: </B> Kurz</p> 
   * @return Liste von Behandlungskontexten, siehe
   *         {@link at.chipkarte.client.base.soap.BaseProperty BaseProperty}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  BaseProperty[] getBehandlungskontexte() throws ServiceException;

  /**
   * <p>
   * Diese Funktion liefert die Werte, die das Attribut Status der {@link at.chipkarte.client.uze.soap.UZEWeisung UZEWeisung}
   * besitzen kann, wenn Sie vom Leistungsanforderer modifizerbar sind.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <p>Keine weiteren.</p>
   * 
   * <p><B>Laufzeitgruppe: </B> Kurz</p> 
   * @return Liste von UzeStatus, siehe
   *         {@link at.chipkarte.client.base.soap.BaseProperty BaseProperty}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  BaseProperty[] getModifyUzeStatusLa() throws ServiceException;  

  /**
   * <p>
   * Diese Funktion liefert alle UZE Status, die eine UZE haben kann.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <p>Keine weiteren.</p>
   * 
   * <p><B>Laufzeitgruppe: </B> Kurz</p> 
   * @return Liste von UzeStatus, siehe
   *         {@link at.chipkarte.client.base.soap.BaseProperty BaseProperty}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  BaseProperty[] getAllUzeStatus() throws ServiceException;
  
  /**
   * <p>
   * Diese Funktion liefert alle MedikamentCodierungsysteme, die für die Angabe eines 
   * Medikament-Objektes verwendet werden können.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <p>Keine weiteren.</p>
   * 
   * <p><B>Laufzeitgruppe: </B> Kurz</p> 
   * @return Liste von MedikamentCodierungsysteme, siehe
   *         {@link at.chipkarte.client.base.soap.BaseProperty BaseProperty}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  BaseProperty[] getMedikamentCodierungsysteme() throws ServiceException;
  
  /**
   * <p>
   * Mit dieser Funktion werden all jene Daten einer UZEWeisung eines Patienten gepr&uuml;ft, 
   * die zur grunds&auml;tzlichen Ablehnung einer UZE-Speicherung f&uuml;hren k&ouml;nnen.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgef&uuml;hrt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf UZE
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#UZE_CORE UZE_CORE}).
   * </li>
   * <li>Eine g&uuml;ltige e-card steckt in dem Kartenleser, der dem angegebenen
   * Dialog zugeordnet bzw. der als Parameter angegeben ist, oder in den
   * Eingabeparametern ist die Sozialversicherungsnummer angegeben.</li>
   * </ul>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p> 
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *          Identifizierer des Kartenlesers. Dieser Parameter ist optional.
   *          Ist der Parameter nicht angegeben, wird der im Dialog gesetzte
   *          Kartenleser verwendet.
   * @param anspruchSvPersonReq
   *          Parameter zum Ermitteln der Informationen &uuml;ber Anspruch und SvPatient
   * @return anspruchSvPersonResp enth&auml;lt im Erfolgsfall die ermittelten Informationen &uuml;ber Anspruch und SvPatient.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws UzeAnspruchException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeAnspruchExceptionConstants#SELECT_ANSPRUCH SELECT_ANSPRUCH},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeAnspruchExceptionConstants#SELECT_ASVG_SVT SELECT_ASVG_SVT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeAnspruchExceptionConstants#SVT_CORRECTED SVT_CORRECTED}
   * @throws UzeException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_ANSPRUCH INVALID_ANSPRUCH},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#NO_ANSPRUCH NO_ANSPRUCH},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#NO_SUCH_ANSPRUCH NO_SUCH_ANSPRUCH},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#NO_SVPERSON NO_SVPERSON},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#NO_SVT_PROVIDED NO_SVT_PROVIDED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#NO_VERTRAG_FOR_FACHGEBIET NO_VERTRAG_FOR_FACHGEBIET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#ORDINATION_LE_NOT_FOUND ORDINATION_LE_NOT_FOUND},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#WEISUNGSTYP_NOT_ALLOWED WEISUNGSTYP_NOT_ALLOWED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#WRONG_FACHGEBIET_FOR_ZO WRONG_FACHGEBIET_FOR_ZO}
   * @throws UzeInvalidParameterException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#ANSPRUCH_AND_SVTCODE_SET ANSPRUCH_AND_SVTCODE_SET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_ANSPRUCH_ID INVALID_ANSPRUCH_ID},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_BEHANDLUNGSKONTEXT INVALID_BEHANDLUNGSKONTEXT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_FACHGEBIET INVALID_FACHGEBIET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_ORDID_LE INVALID_ORDID_LE},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_SVNUMBER INVALID_SVNUMBER},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_SVT INVALID_SVT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_WEISUNGSTYP INVALID_WEISUNGSTYP},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#LE_REQUIRED_FOR_ZO LE_REQUIRED_FOR_ZO},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#NO_SVPERSON_IDENTIFICATION NO_SVPERSON_IDENTIFICATION},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#WRONG_FACHGEBIET_FOR_ZO WRONG_FACHGEBIET_FOR_ZO},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_CONDITIONAL_SVNUMBER INVALID_CONDITIONAL_SVNUMBER}
   */  
  AnspruchSvPersonResp acquireAnspruchSvPerson(String dialogId, String cardReaderId, AnspruchSvPersonReq anspruchSvPersonReq) 
      throws AccessException, DialogException, CardException, ServiceException, UzeInvalidParameterException, UzeException, 
        UzeAnspruchException;

  /**
   * <p>
   * Mit dieser Funktion wird nach Leistungserbringern f&uuml;r Zuweisungen ohne Patientenkontakt gesucht.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgef&uuml;hrt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf UZE
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#UZE_CORE UZE_CORE}).
   * </li>
   * </ul>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p> 
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param leForZoSearchReq
   *          enth&auml;lt die Kritrien der Leistungserbringersuche.
   * @return VpOrdinationInfo[] enth&auml;lt die den Kriterien entsprechenden Leistungserbringer.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws UzeInvalidParameterException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#FG_FOR_ZO_NOT_ALLOWED FG_FOR_ZO_NOT_ALLOWED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_FACHGEBIET INVALID_FACHGEBIET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_VPNUMMER_FORMAT INVALID_VPNUMMER_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VP_VORNAME_WRONG_FORMAT VP_VORNAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VP_ZUNAME_WRONG_FORMAT VP_ZUNAME_WRONG_FORMAT}
   */           
  VpOrdinationInfo[] searchLeForZo(String dialogId, LeForZoSearchReq leForZoSearchReq)
      throws ServiceException, AccessException, DialogException, UzeInvalidParameterException, UzeException, CardException;
  
  /**
   * <p>
   * Mit dieser Funktion wird eine UZEWeisung erstellt und gespeichert.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgef&uuml;hrt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf UZE
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#UZE_CORE UZE_CORE}).
   * </li>
   * <li>Eine g&uuml;ltige e-card steckt in dem Kartenleser, der dem angegebenen
   * Dialog zugeordnet bzw. der als Parameter angegeben ist, oder in den
   * Eingabeparametern ist die Sozialversicherungsnummer angegeben.</li>
   * </ul>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *          Identifizierer des Kartenlesers. Dieser Parameter ist optional.
   *          Ist der Parameter nicht angegeben, wird der im Dialog gesetzte
   *          Kartenleser verwendet.
   * @param storeUzeReq
   *          Parameter zum Erstellen der UZE-Weisung.
   * @return UZEWeisung ist die im Erfolgsfall erstellte UZEWeisung.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws UzeAnspruchException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeAnspruchExceptionConstants#SELECT_ANSPRUCH SELECT_ANSPRUCH},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeAnspruchExceptionConstants#SELECT_ASVG_SVT SELECT_ASVG_SVT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeAnspruchExceptionConstants#SVT_CORRECTED SVT_CORRECTED}
   * @throws UzeException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_ANSPRUCH INVALID_ANSPRUCH},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#NO_ANSPRUCH NO_ANSPRUCH},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#NO_SUCH_ANSPRUCH NO_SUCH_ANSPRUCH},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#NO_SVPERSON NO_SVPERSON},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#NO_SVT_PROVIDED NO_SVT_PROVIDED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#NO_VERTRAG_FOR_FACHGEBIET NO_VERTRAG_FOR_FACHGEBIET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#ORDINATION_LE_NOT_FOUND ORDINATION_LE_NOT_FOUND},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#UZE_CODE_ERROR UZE_CODE_ERROR},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#UZE_CRYPTO_ERROR UZE_CRYPTO_ERROR},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#WEISUNGSTYP_NOT_ALLOWED WEISUNGSTYP_NOT_ALLOWED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#WRONG_FACHGEBIET_FOR_ZO WRONG_FACHGEBIET_FOR_ZO}
   * @throws UzeInvalidParameterException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#ADMIN_VERMERKE_WRONG_FORMAT ADMIN_VERMERKE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#AKUTTHERAPIE_WRONG_FORMAT AKUTTHERAPIE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#ALLERGIE_MU_INFO_WRONG_FORMAT ALLERGIE_MU_INFO_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#ANSPRUCH_AND_SVTCODE_SET ANSPRUCH_AND_SVTCODE_SET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#EMAIL_WRONG_FORMAT EMAIL_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#FACHABTEILUNG_WRONG_FORMAT FACHABTEILUNG_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#GEW_LEISTUNG_NOT_SET GEW_LEISTUNG_NOT_SET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#GEW_LEISTUNG_WRONG_FORMAT GEW_LEISTUNG_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_ADRESSE_LAND_WRONG_FORMAT HAUSARZT_ADRESSE_LAND_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_ADRESSE_ORT_WRONG_FORMAT HAUSARZT_ADRESSE_ORT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_ADRESSE_PLZ_WRONG_FORMAT HAUSARZT_ADRESSE_PLZ_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_ADRESSE_STRASSE_WRONG_FORMAT HAUSARZT_ADRESSE_STRASSE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_NAME_WRONG_FORMAT HAUSARZT_NAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_TELEFON_WRONG_FORMAT HAUSARZT_TELEFON_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_TITELHINTEN_WRONG_FORMAT HAUSARZT_TITELHINTEN_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_TITELVORNE_WRONG_FORMAT HAUSARZT_TITELVORNE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_VORNAME_WRONG_FORMAT HAUSARZT_VORNAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_ZUNAME_NOT_SET HAUSARZT_ZUNAME_NOT_SET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_ZUNAME_WRONG_FORMAT HAUSARZT_ZUNAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_ANTIKOAGULIERT INVALID_ANTIKOAGULIERT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_BEHANDLUNGSKONTEXT INVALID_BEHANDLUNGSKONTEXT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_BEWILLIGUNGSPFLICHT INVALID_BEWILLIGUNGSPFLICHT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_CONDITIONAL_SVNUMBER INVALID_CONDITIONAL_SVNUMBER},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_FACHGEBIET INVALID_FACHGEBIET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_ORDID_LE INVALID_ORDID_LE},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_SVNUMBER INVALID_SVNUMBER},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_SVT INVALID_SVT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_WEISUNGSTYP INVALID_WEISUNGSTYP},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERS_TITELHINTEN_WRONG_FORMAT KONTAKTPERS_TITELHINTEN_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERS_TITELVORNE_WRONG_FORMAT KONTAKTPERS_TITELVORNE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERS_VORNAME_WRONG_FORMAT KONTAKTPERS_VORNAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERS_ZUNAME_NOT_SET KONTAKTPERS_ZUNAME_NOT_SET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERS_ZUNAME_WRONG_FORMAT KONTAKTPERS_ZUNAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERSON_ADRESSE_LAND_WRONG_FORMAT KONTAKTPERSON_ADRESSE_LAND_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERSON_ADRESSE_ORT_WRONG_FORMAT KONTAKTPERSON_ADRESSE_ORT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERSON_ADRESSE_PLZ_WRONG_FORMAT KONTAKTPERSON_ADRESSE_PLZ_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERSON_ADRESSE_STRASSE_WRONG_FORMAT KONTAKTPERSON_ADRESSE_STRASSE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERSON_TELEFON_WRONG_FORMAT KONTAKTPERSON_TELEFON_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#LE_REQUIRED_FOR_ZO LE_REQUIRED_FOR_ZO},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#MEDDATEN_NOT_SET MEDDATEN_NOT_SET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#MEDIKATION_WRONG_FORMAT  MEDIKATION_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#NO_SVPERSON_IDENTIFICATION NO_SVPERSON_IDENTIFICATION},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#NOTIZ_LA_WRONG_FORMAT NOTIZ_LA_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#ORDINATIONSZEITEN_LE_WRONG_FORMAT ORDINATIONSZEITEN_LE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#PATIENT_ADRESSE_LAND_WRONG_FORMAT PATIENT_ADRESSE_LAND_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#PATIENT_ADRESSE_ORT_WRONG_FORMAT PATIENT_ADRESSE_ORT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#PATIENT_ADRESSE_PLZ_WRONG_FORMAT PATIENT_ADRESSE_PLZ_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#PATIENT_ADRESSE_STRASSE_WRONG_FORMAT PATIENT_ADRESSE_STRASSE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#PATIENTENVERFUEGUNG_WRONG_FORMAT PATIENTENVERFUEGUNG_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_ADRESSE_LAND_WRONG_FORMAT SACHWALTER_ADRESSE_LAND_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_ADRESSE_ORT_WRONG_FORMAT SACHWALTER_ADRESSE_ORT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_ADRESSE_PLZ_WRONG_FORMAT SACHWALTER_ADRESSE_PLZ_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_ADRESSE_STRASSE_WRONG_FORMAT SACHWALTER_ADRESSE_STRASSE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_TELEFON_WRONG_FORMAT SACHWALTER_TELEFON_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_TITELHINTEN_WRONG_FORMAT SACHWALTER_TITELHINTEN_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_TITELVORNE_WRONG_FORMAT SACHWALTER_TITELVORNE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_VORNAME_WRONG_FORMAT SACHWALTER_VORNAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_ZUNAME_NOT_SET SACHWALTER_ZUNAME_NOT_SET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_ZUNAME_WRONG_FORMAT SACHWALTER_ZUNAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SYMPTOMBESCHREIBUNG_WRONG_FORMAT SYMPTOMBESCHREIBUNG_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#TELEFON_LA_NOT_SET TELEFON_LA_NOT_SET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#TELEFON_LA_WRONG_FORMAT TELEFON_LA_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#TELEFON_PATIENT_WRONG_FORMAT TELEFON_PATIENT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERDACHTSDIAGNOSE_NOT_SET VERDACHTSDIAGNOSE_NOT_SET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERDACHTSDIAGNOSE_WRONG_FORMAT VERDACHTSDIAGNOSE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRAUENSPERSON_ADRESSE_LAND_WRONG_FORMAT VERTRAUENSPERSON_ADRESSE_LAND_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRAUENSPERSON_ADRESSE_ORT_WRONG_FORMAT VERTRAUENSPERSON_ADRESSE_ORT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRAUENSPERSON_ADRESSE_PLZ_WRONG_FORMAT VERTRAUENSPERSON_ADRESSE_PLZ_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRAUENSPERSON_ADRESSE_STRASSE_WRONG_FORMAT VERTRAUENSPERSON_ADRESSE_STRASSE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRAUENSPERSON_ADRESSE_WRONG_FORMAT VERTRAUENSPERSON_ADRESSE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRAUENSPERSON_TELEFON_WRONG_FORMAT VERTRAUENSPERSON_TELEFON_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRPERS_TITELHINTEN_WRONG_FORMAT VERTRPERS_TITELHINTEN_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRPERS_TITELVORNE_WRONG_FORMAT VERTRPERS_TITELVORNE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRPERS_VORNAME_WRONG_FORMAT VERTRPERS_VORNAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRPERS_ZUNAME_NOT_SET VERTRPERS_ZUNAME_NOT_SET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRPERS_ZUNAME_WRONG_FORMAT VERTRPERS_ZUNAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VORGESCHICHTE_WRONG_FORMAT VORGESCHICHTE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#WES_NEBENDIAGNOSEN_WRONG_FORMAT WES_NEBENDIAGNOSEN_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#WRONG_FACHGEBIET_FOR_ZO WRONG_FACHGEBIET_FOR_ZO}
   */
  UZEWeisung storeUze(String dialogId, String cardReaderId, StoreUzeReq storeUzeReq) 
      throws ServiceException, AccessException, DialogException, CardException, UzeInvalidParameterException, UzeException, 
      UzeAnspruchException;

  /**
   * <p>
   * Mit dieser Funktion werden vom Leistungsanforderer in einem bestimmten Zeitraum erstellte UZEWeisungen gesucht.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgef&uuml;hrt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf UZE
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#UZE_CORE UZE_CORE}).
   * </li>
   * <li>Eine g&uuml;ltige e-card steckt in dem Kartenleser, der dem angegebenen
   * Dialog zugeordnet bzw. der als Parameter angegeben ist, oder in den
   * Eingabeparametern ist die Sozialversicherungsnummer angegeben.</li>
   * </ul>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *          Identifizierer des Kartenlesers. Dieser Parameter ist optional.
   *          Ist der Parameter nicht angegeben, wird der im Dialog gesetzte
   *          Kartenleser verwendet.
   * @param uzeLaSearchReq Suchkriterien der UZEWeisungen.
   * @return UZEWeisung[] enth&auml;lt die den Suchkriterien entsprechenden UZEWeisungen.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws UzeException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#MAX_RESULTS_EXCEEDED MAX_RESULTS_EXCEEDED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#UZE_CRYPTO_ERROR UZE_CRYPTO_ERROR}
   * @throws UzeInvalidParameterException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#CODE_WRONG_FORMAT CODE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#DATE_ORDER_WRONG DATE_ORDER_WRONG},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_BIS_DATUM INVALID_BIS_DATUM},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_ORDID_LA INVALID_ORDID_LA},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_UZE_STATUS INVALID_UZE_STATUS},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_VON_DATUM INVALID_VON_DATUM},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_WEISUNGSTYP INVALID_WEISUNGSTYP},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_CONDITIONAL_SVNUMBER INVALID_CONDITIONAL_SVNUMBER}
   */
  UZEWeisung[] searchUzeLa(String dialogId, String cardReaderId, UzeLaSearchReq uzeLaSearchReq) 
    throws ServiceException, AccessException, DialogException, CardException, UzeInvalidParameterException, UzeException; 
  
  /**
   * <p>
   * Mit dieser Funktion wird nach modifizierbaren UZEWeisungen durch den Leistungsanforderer gesucht.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgef&uuml;hrt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf UZE
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#UZE_CORE UZE_CORE}).
   * </li>
   * <li>Eine g&uuml;ltige e-card steckt in dem Kartenleser, der dem angegebenen
   * Dialog zugeordnet bzw. der als Parameter angegeben ist, oder in den
   * Eingabeparametern ist die Sozialversicherungsnummer angegeben.</li>
   * </ul>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p> 
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *          Identifizierer des Kartenlesers. Dieser Parameter ist optional.
   *          Ist der Parameter nicht angegeben, wird der im Dialog gesetzte
   *          Kartenleser verwendet.
   * @param modifiableUzeLaSearchReq Suchkriterien der modifizierbaren UZEWeisungen.
   * @return ModifiableUzeSearchResp enth&auml;lt die modifizierbaren UZEWeisungen.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws UzeException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#MAX_RESULTS_EXCEEDED MAX_RESULTS_EXCEEDED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#UZE_CRYPTO_ERROR UZE_CRYPTO_ERROR}
   * @throws UzeInvalidParameterException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#CODE_WRONG_FORMAT CODE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_UZE_STATUS INVALID_UZE_STATUS},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_WEISUNGSTYP INVALID_WEISUNGSTYP},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_CONDITIONAL_SVNUMBER INVALID_CONDITIONAL_SVNUMBER}
   */
  ModifiableUzeSearchResp searchModifiableUzeLa(String dialogId, String cardReaderId, 
      ModifiableUzeLaSearchReq modifiableUzeLaSearchReq)
    throws ServiceException, AccessException, DialogException, CardException, UzeInvalidParameterException, UzeException;

  /**
   * <p>
   * Mit dieser Funktion wird eine UZE ge&auml;ndert.
   * Es sind nur Daten &auml;nderbar, die nicht am Patienteninformationsblatt ausgedruckt werden.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgef&uuml;hrt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf UZE
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#UZE_CORE UZE_CORE}).
   * </li>
   * <li>Eine &auml;nderbare UZEWeisung liegt vor.</li>
   * </ul>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param uzeLaChangeReq enth&auml;lt die zu &auml;ndernden Werte der UZEWeisung.
   * @return UZEWeisung enth&auml;lt im Erfolgsfall die ge&auml;nderte UZEWeisung. 
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws UzeException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_UZE_ID INVALID_UZE_ID},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_UZE_VERSION INVALID_UZE_VERSION},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#MODIFYING_TIME_EXPIRED MODIFYING_TIME_EXPIRED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#NO_VERTRAG_FOR_FACHGEBIET NO_VERTRAG_FOR_FACHGEBIET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#ORDINATION_LE_NOT_FOUND ORDINATION_LE_NOT_FOUND},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#UZE_CRYPTO_ERROR UZE_CRYPTO_ERROR}
   * @throws UzeInvalidParameterException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#ADMIN_VERMERKE_WRONG_FORMAT ADMIN_VERMERKE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#EMAIL_WRONG_FORMAT EMAIL_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_ADRESSE_LAND_WRONG_FORMAT HAUSARZT_ADRESSE_LAND_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_ADRESSE_ORT_WRONG_FORMAT HAUSARZT_ADRESSE_ORT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_ADRESSE_PLZ_WRONG_FORMAT HAUSARZT_ADRESSE_PLZ_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_ADRESSE_STRASSE_WRONG_FORMAT HAUSARZT_ADRESSE_STRASSE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_TELEFON_WRONG_FORMAT HAUSARZT_TELEFON_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_TITELHINTEN_WRONG_FORMAT HAUSARZT_TITELHINTEN_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_TITELVORNE_WRONG_FORMAT HAUSARZT_TITELVORNE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_VORNAME_WRONG_FORMAT HAUSARZT_VORNAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_ZUNAME_NOT_SET HAUSARZT_ZUNAME_NOT_SET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#HAUSARZT_ZUNAME_WRONG_FORMAT HAUSARZT_ZUNAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_ORDID_LE INVALID_ORDID_LE},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_UZE_ID INVALID_UZE_ID},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_UZE_VERSION INVALID_UZE_VERSION},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERS_TITELHINTEN_WRONG_FORMAT KONTAKTPERS_TITELHINTEN_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERS_TITELVORNE_WRONG_FORMAT KONTAKTPERS_TITELVORNE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERS_VORNAME_WRONG_FORMAT KONTAKTPERS_VORNAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERS_ZUNAME_NOT_SET KONTAKTPERS_ZUNAME_NOT_SET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERS_ZUNAME_WRONG_FORMAT KONTAKTPERS_ZUNAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERSON_ADRESSE_LAND_WRONG_FORMAT KONTAKTPERSON_ADRESSE_LAND_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERSON_ADRESSE_ORT_WRONG_FORMAT KONTAKTPERSON_ADRESSE_ORT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERSON_ADRESSE_PLZ_WRONG_FORMAT KONTAKTPERSON_ADRESSE_PLZ_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERSON_ADRESSE_STRASSE_WRONG_FORMAT KONTAKTPERSON_ADRESSE_STRASSE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#KONTAKTPERSON_TELEFON_WRONG_FORMAT KONTAKTPERSON_TELEFON_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#NOTIZFELD_WRONG_FORMAT NOTIZFELD_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#ORDINATIONSZEITEN_LE_WRONG_FORMAT ORDINATIONSZEITEN_LE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#PATIENT_ADRESSE_LAND_WRONG_FORMAT PATIENT_ADRESSE_LAND_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#PATIENT_ADRESSE_ORT_WRONG_FORMAT PATIENT_ADRESSE_ORT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#PATIENT_ADRESSE_PLZ_WRONG_FORMAT PATIENT_ADRESSE_PLZ_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#PATIENT_ADRESSE_STRASSE_WRONG_FORMAT PATIENT_ADRESSE_STRASSE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#PATIENTENVERFUEGUNG_WRONG_FORMAT PATIENTENVERFUEGUNG_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_ADRESSE_LAND_WRONG_FORMAT SACHWALTER_ADRESSE_LAND_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_ADRESSE_ORT_WRONG_FORMAT SACHWALTER_ADRESSE_ORT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_ADRESSE_PLZ_WRONG_FORMAT SACHWALTER_ADRESSE_PLZ_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_ADRESSE_STRASSE_WRONG_FORMAT SACHWALTER_ADRESSE_STRASSE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_TELEFON_WRONG_FORMAT SACHWALTER_TELEFON_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_TITELHINTEN_WRONG_FORMAT SACHWALTER_TITELHINTEN_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_TITELVORNE_WRONG_FORMAT SACHWALTER_TITELVORNE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_VORNAME_WRONG_FORMAT SACHWALTER_VORNAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_ZUNAME_NOT_SET SACHWALTER_ZUNAME_NOT_SET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#SACHWALTER_ZUNAME_WRONG_FORMAT SACHWALTER_ZUNAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#TELEFON_PATIENT_WRONG_FORMAT TELEFON_PATIENT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRAUENSPERSON_ADRESSE_LAND_WRONG_FORMAT VERTRAUENSPERSON_ADRESSE_LAND_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRAUENSPERSON_ADRESSE_ORT_WRONG_FORMAT VERTRAUENSPERSON_ADRESSE_ORT_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRAUENSPERSON_ADRESSE_PLZ_WRONG_FORMAT VERTRAUENSPERSON_ADRESSE_PLZ_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRAUENSPERSON_ADRESSE_STRASSE_WRONG_FORMAT VERTRAUENSPERSON_ADRESSE_STRASSE_WRONG_FORMAT},,
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRAUENSPERSON_TELEFON_WRONG_FORMAT VERTRAUENSPERSON_TELEFON_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRPERS_TITELHINTEN_WRONG_FORMAT VERTRPERS_TITELHINTEN_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRPERS_TITELVORNE_WRONG_FORMAT VERTRPERS_TITELVORNE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRPERS_VORNAME_WRONG_FORMAT VERTRPERS_VORNAME_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRPERS_ZUNAME_NOT_SET VERTRPERS_ZUNAME_NOT_SET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VERTRPERS_ZUNAME_WRONG_FORMAT VERTRPERS_ZUNAME_WRONG_FORMAT}
   */
  UZEWeisung changeUzeLa(String dialogId, UzeLaChangeReq uzeLaChangeReq) throws ServiceException, AccessException, 
    DialogException, UzeInvalidParameterException, UzeException;

  /**
   * <p>
   * Mit dieser Funktion wird eine erstellte UZEWeisung durch den Leistungsanforderer storniert.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgef&uuml;hrt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf UZE
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#UZE_CORE UZE_CORE}).
   * </li>
   * <li>Eine stornierbare (erstellte) UZEWeisung liegt vor.</li>
   * </ul>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p> 
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param uzeId ID der zu stornierenden UZEWeisung.
   * @param version Versionsnummer der zu stornierenden UZEWeisung. 
   * @return UZEWeisung ist die im Erfolgsfall stornierte UZEWeisung.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws UzeException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_UZE_ID INVALID_UZE_ID},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_UZE_VERSION INVALID_UZE_VERSION},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#MODIFYING_TIME_EXPIRED MODIFYING_TIME_EXPIRED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#UZE_CRYPTO_ERROR UZE_CRYPTO_ERROR}
   * @throws UzeInvalidParameterException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_UZE_ID INVALID_UZE_ID},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_UZE_VERSION INVALID_UZE_VERSION}
   */
  UZEWeisung cancelUzeLa(String dialogId, Long uzeId, Integer version) 
      throws ServiceException, AccessException, DialogException, UzeInvalidParameterException, UzeException;

  /**
   * <p>
   * Mit dieser Funktion wird ein Storno einer UZEWeisung zur&uuml;ckgesetzt.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgef&uuml;hrt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf UZE
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#UZE_CORE UZE_CORE}).
   * </li>
   * <li>Eine stornierte UZEWeisung liegt vor.</li>
   * </ul>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p> 
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param uzeId ID der r&uuml;ckzusetzenden UZEWeisung.
   * @param version Versionsnummer der r&uuml;ckzusetzenden UZEWeisung. 
   * @return UZEWeisung enth&auml;lt im Erfolgsfall die zur&uuml;ckgesetzte UZEWeisung.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws UzeException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_UZE_ID INVALID_UZE_ID},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_UZE_VERSION INVALID_UZE_VERSION},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#MODIFYING_TIME_EXPIRED MODIFYING_TIME_EXPIRED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#UZE_CRYPTO_ERROR UZE_CRYPTO_ERROR}
   *           
   * @throws UzeInvalidParameterException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_UZE_ID INVALID_UZE_ID},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_UZE_VERSION INVALID_UZE_VERSION}
   */  
  UZEWeisung restoreUzeLa(String dialogId, Long uzeId, Integer version)
      throws ServiceException, AccessException, DialogException, UzeInvalidParameterException, UzeException;
  
  /**
   * <p>
   * Mit dieser Funktion wird nach einl&ouml;sbaren UZEWeisungen gesucht.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgef&uuml;hrt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf UZE
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#UZE_CORE UZE_CORE}).
   * </li>
   * <li>Eine g&uuml;ltige e-card steckt in dem Kartenleser, der dem angegebenen
   * Dialog zugeordnet bzw. der als Parameter angegeben ist, oder in den
   * Eingabeparametern ist die Sozialversicherungsnummer angegeben.</li>
   * </ul>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p> 
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *          Identifizierer des Kartenlesers. Dieser Parameter ist optional.
   *          Ist der Parameter nicht angegeben, wird der im Dialog gesetzte
   *          Kartenleser verwendet.
   * @param realizableUzeSearchReq Suchkriterien der einl&ouml;sbaren UZEWeisungen.
   * @return RealizableUzeSearchResp enth&auml;lt die einl&ouml;sbaren UZEWeisungen.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws UzeException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_CARD_EXCEPTION INVALID_CARD_EXCEPTION},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_SIGNATURE_EXCEPTION INVALID_SIGNATURE_EXCEPTION},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#MAX_RESULTS_EXCEEDED MAX_RESULTS_EXCEEDED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#UZE_CRYPTO_ERROR UZE_CRYPTO_ERROR}
   * @throws UzeInvalidParameterException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#ANLAGE_READ_ERROR ANLAGE_READ_ERROR},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#CARD_OR_CODE_REQUIRED CARD_OR_CODE_REQUIRED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#CODE_WRONG_FORMAT CODE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_FACHGEBIET INVALID_FACHGEBIET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#NO_SVPERSON_IDENTIFICATION NO_SVPERSON_IDENTIFICATION},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_CONDITIONAL_SVNUMBER INVALID_CONDITIONAL_SVNUMBER}
   */
  RealizableUzeSearchResp searchRealizableUze(String dialogId, String cardReaderId, RealizableUzeSearchReq realizableUzeSearchReq) 
      throws ServiceException, AccessException, DialogException, CardException, UzeInvalidParameterException, UzeException;

  /**
   * <p>
   * Mit dieser Funktion wird nach einl&ouml;sbaren Zuweisungen ohne Patientenkontakt gesucht.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgef&uuml;hrt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf UZE
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#UZE_CORE UZE_CORE}).
   * </li>
   * </ul>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p> 
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param realizableZoSearchReq Suchkriterien der einl&ouml;sbaren ZOs.
   * @return UZEWeisung[] enth&auml;lt die den Suchkriterien entsprechenden ZOs. 
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws UzeException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#MAX_RESULTS_EXCEEDED MAX_RESULTS_EXCEEDED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#UZE_CRYPTO_ERROR UZE_CRYPTO_ERROR}
   * @throws UzeInvalidParameterException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#CODE_WRONG_FORMAT CODE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#DATE_ORDER_WRONG DATE_ORDER_WRONG},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_BIS_DATUM INVALID_BIS_DATUM},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_CONDITIONAL_SVNUMBER INVALID_CONDITIONAL_SVNUMBER},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_VON_DATUM INVALID_VON_DATUM}
   */
  UZEWeisung[] searchRealizableZo(String dialogId, RealizableZoSearchReq realizableZoSearchReq) 
      throws ServiceException, AccessException, DialogException, UzeInvalidParameterException, UzeException; 

  /**
   * <p>
   * Mit dieser Funktion wird eine erstellte UZEWeisung durch den Leistungserbringer eingel&ouml;st.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgef&uuml;hrt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf UZE
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#UZE_CORE UZE_CORE}).
   * </li>
   * <li>Eine einl&ouml;sbare (erstellte) UZEWeisung liegt vor.</li>
   * </ul>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p> 
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param realizeUzeReq Parameter zum Einl&ouml;sen der UZEWeisung.
   * @return UZEWeisung ist die im Erfolgsfall eingel&ouml;ste UZEWeisung.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws UzeAnspruchException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeAnspruchExceptionConstants#SELECT_ANSPRUCH SELECT_ANSPRUCH},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeAnspruchExceptionConstants#SELECT_ASVG_SVT SELECT_ASVG_SVT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeAnspruchExceptionConstants#SVT_CORRECTED SVT_CORRECTED}
   * @throws UzeException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#CODE_MISMATCH CODE_MISMATCH},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#FG_CHANGE_NOT_ALLOWED_FOR_WEISUNGSTYP FG_CHANGE_NOT_ALLOWED_FOR_WEISUNGSTYP},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INCOMPATIBLE_FACHGEBIET INCOMPATIBLE_FACHGEBIET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INCOMPATIBLE_ORDID INCOMPATIBLE_ORDID},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_ANSPRUCH INVALID_ANSPRUCH},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_TICKET_FOR_UZE INVALID_TICKET_FOR_UZE},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_TICKET_SIGNATURE INVALID_TICKET_SIGNATURE},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_UZE_ID INVALID_UZE_ID},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_UZE_VERSION INVALID_UZE_VERSION},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#MISSING_RIGHT_FOR_EINLOESUNG MISSING_RIGHT_FOR_EINLOESUNG},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#NO_ANSPRUCH NO_ANSPRUCH},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#NO_SUCH_ANSPRUCH NO_SUCH_ANSPRUCH},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#NO_SVT_PROVIDED NO_SVT_PROVIDED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#NO_VERTRAG_FOR_FACHGEBIET NO_VERTRAG_FOR_FACHGEBIET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#UZE_BEWILLIGUNG_MISSING UZE_BEWILLIGUNG_MISSING},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#UZE_NOT_REALIZABLE UZE_NOT_REALIZABLE},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#UZE_CRYPTO_ERROR UZE_CRYPTO_ERROR}
   * @throws UzeInvalidParameterException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#ANSPRUCH_AND_SVTCODE_SET ANSPRUCH_AND_SVTCODE_SET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#CODE_OR_TICKET_REQUIRED CODE_OR_TICKET_REQUIRED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#CODE_WRONG_FORMAT CODE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_ANSPRUCH_ID INVALID_ANSPRUCH_ID},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_BEWILLIGUNGSPFLICHT INVALID_BEWILLIGUNGSPFLICHT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_FG_EINLOESUNG INVALID_FG_EINLOESUNG},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_SVT INVALID_SVT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_TICKET_FOR_VERTRAGSPARTNER INVALID_TICKET_FOR_VERTRAGSPARTNER},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_TICKET INVALID_TICKET},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_UZE_ID INVALID_UZE_ID},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_UZE_VERSION INVALID_UZE_VERSION},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#WRONG_FG_EINLOESUNG_FOR_ORDINATION WRONG_FG_EINLOESUNG_FOR_ORDINATION}
   *@throws UzeFachgebietException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeFachgebietExceptionConstants#WRONG_FG_FOR_EINLOESUNG WRONG_FG_FOR_EINLOESUNG}
   */
  UZEWeisung realizeUze(String dialogId, RealizeUzeReq realizeUzeReq) 
      throws ServiceException, AccessException, DialogException, UzeInvalidParameterException, UzeFachgebietException, UzeException, UzeAnspruchException;

  /**
   * <p>
   * Mit dieser Funktion werden vom Leistungserbringer in einem bestimmten Zeitraum eingel&ouml;ste UZEWeisungen gesucht.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgef&uuml;hrt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf UZE
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#UZE_CORE UZE_CORE}).
   * </li>
   * <li>Eine g&uuml;ltige e-card steckt in dem Kartenleser, der dem angegebenen
   * Dialog zugeordnet bzw. der als Parameter angegeben ist, oder in den
   * Eingabeparametern ist die Sozialversicherungsnummer angegeben.</li>
   * </ul>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p> 
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *          Identifizierer des Kartenlesers. Dieser Parameter ist optional.
   *          Ist der Parameter nicht angegeben, wird der im Dialog gesetzte
   *          Kartenleser verwendet.
   * @param uzeLeSearchReq Suchkriterien der UZEWeisungen.
   * @return UZEWeisung[] enth&auml;lt die den Suchkriterien entsprechenden UZEWeisungen.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws UzeException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#MAX_RESULTS_EXCEEDED MAX_RESULTS_EXCEEDED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#UZE_CRYPTO_ERROR UZE_CRYPTO_ERROR}
   * @throws UzeInvalidParameterException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#CODE_WRONG_FORMAT CODE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#DATE_ORDER_WRONG DATE_ORDER_WRONG},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_BIS_DATUM INVALID_BIS_DATUM},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_ORDID_LE INVALID_ORDID_LE},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_VON_DATUM INVALID_VON_DATUM},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_WEISUNGSTYP INVALID_WEISUNGSTYP},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_CONDITIONAL_SVNUMBER INVALID_CONDITIONAL_SVNUMBER}
   */
  UZEWeisung[] searchUzeLe(String dialogId, String cardReaderId, UzeLeSearchReq uzeLeSearchReq) 
  throws ServiceException, AccessException, DialogException, CardException, UzeInvalidParameterException, UzeException;
  
  /**
   * <p>
   * Mit dieser Funktion wird nach modifizierbaren UZEWeisungen durch den Leistungserbringer gesucht.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgef&uuml;hrt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf UZE
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#UZE_CORE UZE_CORE}).
   * </li>
   * <li>Eine g&uuml;ltige e-card steckt in dem Kartenleser, der dem angegebenen
   * Dialog zugeordnet bzw. der als Parameter angegeben ist, oder in den
   * Eingabeparametern ist die Sozialversicherungsnummer angegeben.</li>
   * </ul>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p> 
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param cardReaderId
   *          Identifizierer des Kartenlesers. Dieser Parameter ist optional.
   *          Ist der Parameter nicht angegeben, wird der im Dialog gesetzte
   *          Kartenleser verwendet.
   * @param modifiableUzeLeSearchReq Suchkriterien der modifizierbaren UZEWeisungen.
   * @return ModifiableUzeSearchResp enth&auml;lt die modifizierbaren UZEWeisungen.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws UzeException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#MAX_RESULTS_EXCEEDED MAX_RESULTS_EXCEEDED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#UZE_CRYPTO_ERROR UZE_CRYPTO_ERROR}
   * @throws UzeInvalidParameterException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#CODE_WRONG_FORMAT CODE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_WEISUNGSTYP INVALID_WEISUNGSTYP},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_CONDITIONAL_SVNUMBER INVALID_CONDITIONAL_SVNUMBER}
   */
  ModifiableUzeSearchResp searchModifiableUzeLe(String dialogId, String cardReaderId, 
      ModifiableUzeLeSearchReq modifiableUzeLeSearchReq)
    throws ServiceException, AccessException, DialogException, CardException, UzeInvalidParameterException, UzeException;

  /**
   * <p>
   * Mit dieser Funktion wird die Einl&ouml;sung einer UZEWeisung storniert.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgef&uuml;hrt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf UZE
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#UZE_CORE UZE_CORE}).
   * </li>
   * <li>Eine eingel&ouml;ste UZEWeisung liegt vor.</li>
   * </ul>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p> 
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param uzeId ID der UZEWeisung, deren Einl&ouml;sung stornieret werden soll.
   * @param version Versionsnummer der UZEWeisung, deren Einl&ouml;sung stornieret werden soll.
   * @return UZEWeisung enth&auml;lt im Erfolgsfall die wieder einl&ouml;sbare UZEWeisung.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws UzeException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_UZE_ID INVALID_UZE_ID},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#INVALID_UZE_VERSION INVALID_UZE_VERSION},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#MODIFYING_TIME_EXPIRED MODIFYING_TIME_EXPIRED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeExceptionConstants#MODIFYING_TIME_EXPIRED UZE_CRYPTO_ERROR}
   * @throws UzeInvalidParameterException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_UZE_ID INVALID_UZE_ID},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_UZE_VERSION INVALID_UZE_VERSION}
   */
  UZEWeisung cancelUzeLe(String dialogId, Long uzeId, Integer version) 
      throws ServiceException, AccessException, DialogException, UzeInvalidParameterException, UzeException;
  
  /**
   * <p>
   * Mit dieser Funktion wird ein Patienteninformationsblatt erstellt.
   * </p>
   * 
   * <B>Voraussetzung:</B>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) 
   * setDialogAddress} wurde erfolgreich ausgef&uuml;hrt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf UZE
   * (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#UZE_CORE UZE_CORE}).
   * </li>
   * <li>Eine UZE im Zustand "erstellt" oder "eingel&ouml;st" liegt vor.</li>
   * </ul>
   *
   * <p><B>Laufzeitgruppe: </B> Mittel</p> 
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param vpOrdinationInfoPIB Informationen zur Ordination des Vertragspartners, bei dem die UZE eingel&ouml;st werden soll/kann.
   * @param uze UZE, zu der das Patienteninformationsblatt ausgedruckt werden soll.
   * @return PIBPrepareResp enth&auml;lt das Patienteninformationsblatt als HTML- Dokument.
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_UZE_CORE MISSING_UZE_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws UzeInvalidParameterException
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#ADRESSE_LE_WRONG_FORMAT ADRESSE_LE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#INVALID_WEISUNGSTYP INVALID_WEISUNGSTYP},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#OPT_LE_FOR_ZO_NOT_ALLOWED OPT_LE_FOR_ZO_NOT_ALLOWED},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#ORDINATIONSZEITEN_LE_WRONG_FORMAT ORDINATIONSZEITEN_LE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#UZE_NOT_SET_FOR_PIB UZE_NOT_SET_FOR_PIB},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#VORNAME_LE_WRONG_FORMAT VORNAME_LE_WRONG_FORMAT},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#WRONG_STATUS_FOR_PIB WRONG_STATUS_FOR_PIB},
   *           {@link at.chipkarte.client.uze.soap.constants.UzeInvalidParameterExceptionConstants#ZUNAME_LE_WRONG_FORMAT ZUNAME_LE_WRONG_FORMAT}
   */  
  PIBPrepareResp preparePatientenInformationsBlatt(String dialogId, VpOrdinationInfoPIB vpOrdinationInfoPIB, UZEWeisung uze)
    throws ServiceException, AccessException, DialogException, UzeInvalidParameterException, UzeException;  
}
