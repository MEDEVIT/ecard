/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der
 * Österreichischen Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder
 * einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap;

import at.chipkarte.client.base.soap.exceptions.CardException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;

/**
 * <p>
 * Dieses Service stellt die Basis-Funktionen des Ordinationsclient zur Verfügung. 
 * <br>Es beinhaltet
 * Funktionen für den Kartenzugriff sowie Funktionen für die Verwaltung eines Dialogs
 * (Auf-/Abbau) und stellt Vertragspartnerinformationen zur Verfügung.
 * </p>
 * @ecardOk rule=FileLengthCheck SS12 interface cannot be shortened or split up
 */
public interface IBaseService {

  /**
   * <p>
   * Diese Funktion generiert eine neue Dialog-Id. 
   * <br>Dabei wird geprüft, ob die maximale Anzahl der Dialoge pro Ordinationsclient
   * überschritten wurde und dadurch kein weiterer Dialogaufbau möglich ist.
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @param cardReaderId Identifizierer des Kartenlesers
   * @param produktInfo Informationen der Software, die diese Schnittstelle implementiert
   * @param extUID UserID vom externen System (z.B. KIS) (pseudonym/Klartext), optional
   * @param pushMessageEnabled Kennzeichen, ob die Abfrage neuer Nachrichten über den Push- bzw. Poll-Mechanismus erfolgt.    
   *          Wenn <i>true</i> übergeben wird oder das Kennzeichen nicht gesetzt ist, 
   *          dann können die Nachrichten nur mit der Funktion <i>getMessages()</i> abgefragt werden. 
   *          Bei <i>false</i> können nur mit <i>pollMessages()</i> die Nachrichten abgefragt werden.
   * @return DialogId - Identifiziert einen Dialog (dient als Referenz dieses Dialogs in anderen Funktionen) <br>
   *         Format: 32-stellig
   * @throws CardException
   *         {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws ServiceException
   *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#EXT_UID_INVALID EXT_UID_INVALID},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#PRODUKTINFO_INVALID PRODUKTINFO_INVALID},
   */
    String createDialog(String cardReaderId, ProduktInfo produktInfo, String extUID, Boolean pushMessageEnabled)
            throws CardException, DialogException, ServiceException;

  /**
   * <p>
   * Diese Funktion generiert eine neue (Enterprise-)Dialog-Id. 
   * <br>Dabei wird geprüft, ob die maximale Anzahl der Dialoge pro Ordinationsclient
   * überschritten wurde und dadurch kein weiterer Dialogaufbau möglich ist.
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @param cardReaderId Identifizierer des Kartenlesers
   * @param produktInfo Informationen der Software, die diese Schnittstelle implementiert
   * @param extUID UserID vom externen System (z.B. KIS) (pseudonym/Klartext), optional
   * @param vpNummer Vertragspartnernummer; Bei Verwendung von Software-Zertifikaten ist dieses Attribut verpflichtend.
   * @param pushMessageEnabled Kennzeichen, ob die Abfrage neuer Nachrichten über den Push- bzw. Poll-Mechanismus erfolgt.    
   *          Wenn <i>true</i> übergeben wird oder das Kennzeichen nicht gesetzt ist, 
   *          dann können die Nachrichten nur mit der Funktion <i>getMessages()</i> abgefragt werden. 
   *          Bei <i>false</i> können nur mit <i>pollMessages()</i> die Nachrichten abgefragt werden.
   * @return DialogId - Identifiziert einen Dialog (dient als Referenz dieses Dialogs in anderen Funktionen) <br>
   *         Format: 32-stellig
   * @throws CardException
   *         {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws ServiceException
   *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#EXT_UID_INVALID EXT_UID_INVALID},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#PRODUKTINFO_INVALID PRODUKTINFO_INVALID},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_VPNR_FORMAT INVALID_VPNR_FORMAT},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_PARAMETER_COMBINATION INVALID_PARAMETER_COMBINATION}
   */
    String createDialogEnt(String cardReaderId, ProduktInfo produktInfo, String extUID, String vpNummer, Boolean pushMessageEnabled)
            throws CardException, DialogException, ServiceException;

  /**
   * <p>
   * Diese Funktion ermittelt alle verfügbaren Kartenleser, die an den Ordinationsclient
   * angeschlossen sind.
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @return Liste der verfügbaren Kartenleser
   * 
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  CardReader[] getCardReaders() throws ServiceException;

  /**
   * <p>
   * Diese Funktion liest die Daten der aktuell gesteckten Karte.
   * </p>
   * <p>
   *  <B>Voraussetzung: </B>
   *  <ul><li>Eine gültige Karte steckt im angegebenen Kartenleser. </li></ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @param cardReaderId Identifizierer des Kartenlesers
   * @return Daten der gesteckten Karte
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * 
   */
  Card getCardData(String cardReaderId) throws CardException, ServiceException;

  /**
   * <p>
   * Diese Funktion liest die erweiterten Daten der aktuell gesteckten Karte.
   * </p>
   * <p>
   * <B>Voraussetzung: </B>
   * <ul><li>Eine gültige Karte steckt im angegebenen Kartenleser. </li></ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @param cardReaderId Identifizierer des Kartenlesers
   * @param CIN Kartennummer einer bereits zuvor gelesenen Karte (um sicherzustellen, dass die Daten
   *          von der gleichen Karte gelesen werden). Wenn null, erfolgt keine Prüfung.
   * @return Erweiterte Daten der gesteckten Karte (mögliche Werte siehe
   *         {@link at.chipkarte.client.base.soap.constants.CardProperty CardProperty})
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   *           
   * @ecardOk rule=ParameterNameCheck we don't want to change parameter names in existing JavaDoc
   */
  Property[] getExtendedCardData(String cardReaderId, String CIN) throws CardException,
      ServiceException;

  /**
   * <p>
   * Mit dieser Funktion kann der PIN-Code der o-card neu gesetzt werden.
   * </p>
   * <p>
   * <B>Voraussetzung: </B>
   * <ul><li>Eine gültige o-card steckt im angegebenen Kartenleser.</li></ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @param cardReaderId Identifizierer des Kartenlesers
   * @param cin Kartennummer einer bereits zuvor gelesenen Karte (um sicherzustellen, dass die Daten
   *          von der gleichen Karte gelesen werden). Wenn null, erfolgt keine Prüfung.
   * @param oldPin aktueller PIN-Code der o-card
   * @param newPin Neuer PIN, der auf der o-card gesetzt werden soll
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CIN_NOT_IDENT CIN_NOT_IDENT},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#PIN_LOCKED PIN_LOCKED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_PIN INVALID_PIN},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_PIN WRONG_PIN},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#TRANSPORT_PIN TRANSPORT_PIN},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  void changePin(String cardReaderId, String cin, String oldPin, String newPin)
      throws CardException, ServiceException;

  /**
   * <p>
   * Mit dieser Funktion kann eine o-card, die durch mehrmalige falsche PIN-Eingabe gesperrt wurde,
   * wieder entsperrt werden, indem der PIN-Code der o-card neu gesetzt wird.
   * </p>
   * <p>
   * <B>Voraussetzung: </B>
   * <ul><li>Eine gültige o-card steckt im angegebenen Kartenleser.</li>
   * <li>Die Karte wurde durch mehrmalige Eingabe eines falschen PIN-Codes gesperrt. </li>
   * </ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @param cardReaderId Identifizierer des Kartenlesers
   * @param cin Kartennummer einer bereits zuvor gelesenen Karte (um sicherzustellen, dass die Daten
   *          von der gleichen Karte gelesen werden). Wenn null, erfolgt keine Prüfung.
   * @param puk PUK-Code der o-card
   * @param newPin Neuer PIN, der auf der o-card gesetzt werden soll
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CIN_NOT_IDENT CIN_NOT_IDENT},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_PIN INVALID_PIN},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_PUK INVALID_PUK},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_PUK WRONG_PUK},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#PUK_LOCKED PUK_LOCKED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  void changePinWithPuk(String cardReaderId, String cin, String puk, String newPin)
      throws CardException, ServiceException;

  /**
   * <p>
   * Diese Funktion testet den Zugriff auf die Karte, die sich im angegebenen Kartenleser befindet.
   * </p>
   * <p>
   * <B>Voraussetzung: </B>
   * <ul><li>Eine gültige Karte steckt im angegebenen Kartenleser </li></ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @return Resultat des Kartentests (der Wert "0" bedeutet OK - sonst Fehlercode laut
   *         {@link at.chipkarte.client.base.soap.exceptions.CardException})
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  Integer doCardTest(String cardReaderId) throws CardException, ServiceException;

  /**
   * <p>
   * Durch diese Funktion wird ein Dialog authentifiziert. 
   * <br>Diese Authentifizierung erfolgt durch
   * Prüfen der PIN der o-card sowie bei verfügbarer Serververbindung durch die Verifikation der
   * o-card-Signatur sowie einer Gültigkeitsprüfung der Karte.
   * </p>
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#createDialog createDialog} oder
   * {@link at.chipkarte.client.base.soap.IBaseService#createDialogEnt createDialogEnt} erfolgreich
   * ausgeführt </li>
   * <li>Gültige Ordinationskarte steckt in dem Kartenleser, der dem angegebenen Dialog zugeordnet ist </li>
   * </ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Mittel </p>
   * 
   * @param dialogId Dialog-Id, die durch die Methode
   *          {@link at.chipkarte.client.base.soap.IBaseService#createDialog createDialog}
   *          oder {@link at.chipkarte.client.base.soap.IBaseService#createDialogEnt createDialogEnt}
   *          erzeugt wurde
   * @param cin Kartennummer einer bereits zuvor gelesenen Karte (um sicherzustellen, dass die Daten
   *          von der gleichen Karte gelesen werden). Wenn null, erfolgt keine Prüfung.
   * @param pin PIN der Ordinationskarte
   * @param cardReaderId Identifizierer des Kartenlesers
   * @return Authentifizierungsstatus bzw. Informationen über den Vertragspartners sowie
   *         Ordinationsadressen. <br>
   *         Im Offline-Modus des Ordinationsclient werden für das Objekt <i>VertragspartnerV2</i>
   *         die Felder 
   *         <ul>
   *            <li>AuthenticationStatus und</li>
   *            <li>VpId</li>
   *         </ul>
   *         nicht versorgt.
   *         
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARD_CHANGED CARD_CHANGED}
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CIN_NOT_IDENT CIN_NOT_IDENT},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#DEFECT_CARD DEFECT_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_PIN INVALID_PIN},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#NO_CARD NO_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#PIN_LOCKED PIN_LOCKED},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#TRANSPORT_PIN TRANSPORT_PIN},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_CARD WRONG_CARD},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#WRONG_PIN WRONG_PIN},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_ALREADY_AUTHENTICATED DIALOG_ALREADY_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#SIGNATURE_INVALID SIGNATURE_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#OCARD_INVALID OCARD_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_ID_ALREADY_EXISTS DIALOG_ID_ALREADY_EXISTS},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_CARD_READER NO_CARD_READER},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#OCARD_GINA_MISMATCH OCARD_GINA_MISMATCH},
   *           
   */
  VertragspartnerV2 authenticateDialog(String dialogId, String cin, String pin,
      String cardReaderId) throws CardException, DialogException, 
      ServiceException;

  /**
  * <p> 
  * Durch diese Funktion wird ein (Enterprise-)Dialog authentifiziert. 
  * <br>Die Signatur wird für die Authentifizierung übergeben.
  * </p>
  * <p>
  * <B>Voraussetzung: </B>
  * <ul>
  * <li>Funktion {@link #createDialogEnt createDialogEnt} erfolgreich ausgeführt </li>
  * <li>Die Signatur ist im Message Header des <i>authenticateDialogEnt</i> Requests gesetzt. </li>
  * </ul> 
  * </p>
  * <p><B>Laufzeitgruppe: </B> Mittel </p>
  * 
  * @param dialogId Dialog-Id, die durch die Methode {@link #createDialog createDialogEnt} erzeugt wurde
  * @return Authentifizierungsstatus bzw. Informationen über den Vertragspartners sowie Ordinationsadressen. <br>
  *         Im Offline-Modus des Ordinationsclient werden für das Objekt <i>VertragspartnerV2</i> die Felder
  *         <ul>
   *            <li>AuthenticationStatus und</li>
   *            <li>VpId</li>
   *         </ul>
   *         nicht versorgt.
   *         
  * @throws ServiceException
  *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
  *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
  *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
  * @throws DialogException
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_ALREADY_AUTHENTICATED DIALOG_ALREADY_AUTHENTICATED},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_CERTIFICATE INVALID_CERTIFICATE},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_ID_ALREADY_EXISTS DIALOG_ID_ALREADY_EXISTS},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_ID_MISMATCH DIALOG_ID_MISMATCH},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_SIGNATURE NO_SIGNATURE},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NO_VPNR_NUMBER NO_VPNR_NUMBER},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_PROBLEM_OCARD_DIALOG_REQUIRED CERTIFICATE_PROBLEM_OCARD_DIALOG_REQUIRED},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#OCARD_GINA_MISMATCH OCARD_GINA_MISMATCH},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#PARAMETER_MISMATCH_EXCEPTION PARAMETER_MISMATCH_EXCEPTION},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_TIMESTAMPS_INVALID CERTIFICATE_TIMESTAMPS_INVALID},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_TIMESTAMP_INTERVAL_INVALID CERTIFICATE_TIMESTAMP_INTERVAL_INVALID},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_REQUEST_OUT_OF_DATE CERTIFICATE_REQUEST_OUT_OF_DATE},
  *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CERTIFICATE_SIGNATURE_ALGORITHM_INVALID CERTIFICATE_SIGNATURE_ALGORITHM_INVALID}
  */
 VertragspartnerV2 authenticateDialogEnt(String dialogId) throws DialogException, ServiceException;
  
  /**
   * <p>
   * Diese Funktion ordnet dem Dialog eine Ordinationsadresse zu.
   * </p>
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul><li>Funktion {@link #authenticateDialog authenticateDialog}/{@link #authenticateDialogEnt authenticateDialogEnt} 
   * wurde erfolgreich ausgeführt </li></ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Mittel </p>
   * 
   * @param dialogId Dialog-Id, die durch die Methode {@link #createDialog createDialog}/{@link #createDialogEnt createDialogEnt} erzeugt
   *          wurde
   * @param ordinationId Identifiziert eine Ordination, die dem Dialog zugeordnet werden soll
   *          (kann über {@link at.chipkarte.client.base.soap.Ordination#getOrdinationId} aus dem Rückgabewert von 
   *          {@link #authenticateDialog authenticateDialog}/{@link #authenticateDialogEnt authenticateDialogEnt} ermittelt werden)
   * @param taetigkeitsBereichId Identifiziert einen Tätigkeitsbereich, der dem Dialog zugeordnet werden soll
   *          (kann über {@link at.chipkarte.client.base.soap.TaetigkeitsBereich#getId()} aus dem Rückgabewert von 
   *          {@link #authenticateDialog authenticateDialog}/{@link #authenticateDialogEnt authenticateDialogEnt} ermittelt werden)
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ADDRESS_ALREADY_SET ADDRESS_ALREADY_SET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_INVALID ORDINATION_ID_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID}
   */
  void setDialogAddress(String dialogId, String ordinationId, String taetigkeitsBereichId) throws DialogException,
      ServiceException;

  /**
   * <p>
   * Diese Funktion beendet einen aufgebauten Dialog.
   * </p>
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul><li>Funktion {@link #createDialog createDialog}/{@link #createDialogEnt createDialogEnt} wurde erfolgreich ausgeführt. </li></ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Mittel </p>
   * 
   * @param dialogId Dialog-Id des Dialogs, der geschlossen werden soll. Die Id wurde durch die
   *          Methode {@link #createDialog createDialog}/{@link #createDialogEnt createDialogEnt} erzeugt.
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   */
  void closeDialog(String dialogId) throws DialogException, ServiceException;

  /**
   * <p>
   * Diese Funktion ermittelt den Status des Ordinationsclient und liefert eine Liste von Status-Properties zurück. 
   * <br>Die Funktion sollte in regelmäßigen Zeitabständen gepollt werden (z.B. im
   * Intervall von einigen Minuten) um einen möglichst aktuellen Zustand des Systems zu bekommen.
   * <br/>
   * Wenn der Dialog nicht mehr gültig ist, wird eine DialogException
   * {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID}
   * geliefert.
   * </p>
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul><li>Funktion {@link #setDialogAddress(String, String) setDialogAddress} wurde erfolgreich
   * ausgeführt. </li></ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @param dialogId Dialog-Id eines aufgebauten Dialogs zu dem Statusinformationen abgefragt werden sollen. Die Id 
   *          wurde durch die Methode {@link #createDialog createDialog}/{@link #createDialogEnt createDialogEnt} erzeugt.
   * @return Liste von Status-Properties (mögliche Keys in der Liste der Properties siehe
   *         {@link at.chipkarte.client.base.soap.constants.StatusProperty StatusProperty})
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE}
   */
  Property[] checkStatus(String dialogId) throws DialogException, ServiceException;

  /**
   * <p>
   * Diese Funktion übersiedelt eine Ordinationsadresse eines Vertragspartners.
   * </p>
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul>
   * <li>Funktion {@link #setDialogAddress(String, String) setDialogAddress} wurde erfolgreich
   * ausgeführt. </li>
   * <li>Online-Modus des Dialogs </li>
   * </ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Mittel </p>
   * 
   * @param dialogId Dialog-Id eines aufgebauten Dialogs 
   * @param ordinationId Id der zu übersiedelnden Adresse, siehe auch
   *          {@link Ordination#isUebersiedeln() Ordination.isUebersiedeln}. Die gültigen
   *          Ordinationsadressen sind im Objekt <code>VertragspartnerV2</code> enthalten, das
   *          von der Funktion {@link #authenticateDialog authenticateDialog}/{@link #authenticateDialogEnt authenticateDialogEnt} geliefert
   *          wird. Für die übersiedelte Adresse (die <i>ordinationId</i>) kann in Zukunft kein Dialog mehr aufgebaut werden.
   * @param forceUebersiedlung Dieser Parameter bestimmt, ob vor Durchführung der Übersiedlung auf eventuell vorhandene 
   *          Offlinekonsultationen für die abzuschließende Ordination geprüft werden soll.
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_INVALID ORDINATION_ID_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#NACHFOLGE_ORDID_NOTFOUND NACHFOLGE_ORDID_NOTFOUND},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#UEBERSIEDELN_OFFLINEDATA_DETECTED}
   */
  void uebersiedelnOrdination(String dialogId, String ordinationId, Boolean forceUebersiedlung) throws DialogException,
      ServiceException;

  /**
   * <p>
   * Diese Funktion liefert die aktuellen Nachrichten vom Messaging-System des e-card-Servers (Push-Mechanismus). 
   * <br>Die Benachrichtigung, dass eine neue Nachricht vorliegt, erfolgt durch Pollen der Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#checkStatus checkStatus}. Durch diesen
   * Mechanismus ist es möglich, asynchrone Nachrichten vom e-card-Serversystem zu übertragen. Dieser
   * Messaging-Mechanismus wird serviceübergreifend verwendet. An welches Service die Nachricht
   * adressiert ist, kann aus dem Objekt {@link at.chipkarte.client.base.soap.Message Message } 
   * ermittelt werden.
   * </p>
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul>
   * <li>Funktion {@link #setDialogAddress(String, String) setDialogAddress} wurde erfolgreich
   * ausgeführt. </li>
   * <li>Online-Modus des Dialogs </li>
   * </ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Lang </p>
   * 
   * @param dialogId Dialog-Id eines aufgebauten Dialogs 
   * @param newOnly Wenn <i>true</i>, werden nur die neuen Nachrichten geliefert, sonst alle. Das Flag
   *          <i>newOnly</i> wird nur innerhalb des Dialogs verwaltet.
   * @return Array von Messages
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#PUSHMSG_NOT_ALLOWED PUSHMSG_NOT_ALLOWED}
   */
  Message[] getMessages(String dialogId, Boolean newOnly) throws ServiceException,
      DialogException;

  /**
   * <p>
   * Diese Funktion liefert die aktuellen Nachrichten vom Messaging-System des e-card-Servers inklusive weiterer Parameter. 
   * <br>Es werden
   * <ul> 
   * <li>die Nachrichten ab dem angegebenen Suchzeitpunkt,</li> 
   * <li>der nächste Suchzeitpunkt in Millisekunden sowie</li> 
   * <li>ein Kennzeichen, ob die Anzahl der Nachrichten begrenzt
   * wurde und somit weitere Nachrichten verfügbar sind</li>
   * </ul><br>
   * geliefert.<br><br>
   *  
   * Für eine lückenlose 
   * und Duplikat-freie Zustellung der Nachrichten, sollte beim Polling für das Abrufen der Nachrichten der Parameter 
   * <i>Suchzeitpunkt</i> mit dem zuletzt zurückgegebenen nächsten Suchzeitpunkt versorgt werden.
   * Zwischen den einzelnen Aufrufen muss ein gewisses Intervall eingehalten werden. Wird das vorgeschriebene Intervall 
   * unterschritten, erfolgt keine Antwort.
   * Die Werte des Abfrageintervalls sind mittels der Funktion {@link #getMinMsgPollingIntervall(String) getMinMsgPollingIntervall} abzufragen. 
   * </p>
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul>
   * <li>Funktion {@link #setDialogAddress(String, String) setDialogAddress} wurde erfolgreich ausgeführt. </li>
   * <li>Online-Modus des Dialogs </li>
   * <li>Der Dialog wurde unter Verwendung des Poll-Mechanismus für das Abfragen von Nachrichten erstellt.<br>
   * (createDialog: <i>pushMessageEnabled</i>=<i>false</i> bzw. createDialogEnt: <i>pushMessageEnabled</i>=<i>false</i>)  </li>
   * </ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Lang </p>
   * 
   * @param dialogId Dialog-Id eines aufgebauten Dialogs 
   * @param suchzeitpunkt Suchzeitpunkt in Millisekunden, ab dem neue Nachrichten geliefert werden sollen 
   *    Format: JJJJMMTTHHmmssccc
   * @return Array von MessagePollResult
   * @throws ServiceException
   *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#POLLMSG_NOT_ALLOWED POLLMSG_NOT_ALLOWED},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#SUCHZEITPUNKT_INVALID SUCHZEITPUNKT_INVALID}
   */
  MessagePollResult pollMessages(String dialogId, String suchzeitpunkt) throws ServiceException, DialogException;
  
  /**
   * <p>
   * Die Funktion liefert das minimale Nachrichten-Poll-Intervall.
   * </p>
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul>
   * <li>Funktion {@link #setDialogAddress(String, String) setDialogAddress} wurde erfolgreich ausgeführt. </li>
   * <li>Online-Modus des Dialogs </li>
   * <li>Der Dialog wurde unter Verwendung des Poll-Mechanismus 
   * (createDialog: <i>pushMessageEnabled</i>=<i>false</i> bzw. createDialogEnt: <i>pushMessageEnabled</i>=<i>false</i>) für das Abfragen von Nachrichten erstellt. </li>
   * </ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @param dialogId Dialog-Id eines aufgebauten Dialogs 
   * @return Poll-Intervall
   * @throws ServiceException
   *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException 
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   *         {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#POLLMSG_NOT_ALLOWED POLLMSG_NOT_ALLOWED}
   */
  Integer getMinMsgPollingIntervall(String dialogId) throws ServiceException, DialogException;
  
  /**
   * <p>
   * Diese Funktion liefert Informationen über die Anzahl der maximal möglichen sowie der zurzeit
   * aufgebauten Dialoge.
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @return Information über Anzahl der Dialoge
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
   */
  DialogsInfo getFreeDialogs() throws ServiceException;

  /**
   * <p>
   * Diese Funktion liefert die aktuelle Softwareversion des Ordinationsclient. Eine Änderung
   * dieser Softwareversion muss nicht zwangsläufig eine Auswirkung auf die Vertragspartnersoftware-Schnittstelle haben. 
   * Dient beispielsweise als Zusatzinformation für Fehler-Reports,
   * Support u. ä.
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @return Softwareversion des Ordinationsclient
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
   */
  GinaVersion getGinaSoftwareVersion() throws ServiceException;

  /**
   * <p>
   * Diese Funktion liefert Daten zu den Verträgen des Vertragspartners.
   * </p>
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt </li>
   * <li>Online-Modus des Dialogs </li>
   * </ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Mittel </p>
   * 
   * @return Vertragsdaten
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#CONNECTION_ERROR CONNECTION_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   */
  VertragsDaten[] getVertraege(String dialogId) throws ServiceException, DialogException;

  /**
   * <p>
   * Mit dieser Funktion werden alle zurzeit gültigen Krankenversicherungsträger geliefert.
   * </p>
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul><li>Keine </li></ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @return Array der Krankenversicherungsträger, siehe auch {@link SvtProperty SvtProperty}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  SvtProperty[] getSVTs() throws ServiceException;

  /**
   * <p>
   * Mit dieser Funktion werden alle zurzeit gültigen Fachgebiete geliefert.
   * </p>
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul><li>Keine </li></ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @return Array der Fachgebiete, siehe auch {@link BaseProperty BaseProperty}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   */
  BaseProperty[] getFachgebiete() throws ServiceException;

  /**
   * <p>
   * Mit dieser Funktion werden alle gültigen Fachgebiete einer bestimmten Ordination geliefert, für
   * die der Vertragspartner das Konsultationsrecht besitzt.
   * </p>
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul><li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt</li></ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz</p>
   * 
   * @param dialogId Dialog-Id eines aufgebauten Dialogs 
   * @param ordId Id der Ordination, für deren Verträge die Fachgebiete abgefragt werden sollen.
   *          Wenn <i>null</i>, werden die gültigen Fachgebiete für die Ordinationsadresse des aktuellen
   *          Dialogs geliefert.
   * @param taetigkeitsBereichId Id des Tätigkeitsbereichs, für den die Fachgebiete abgefragt werden sollen.
   *          Wenn <i>null</i>, werden die gültigen Fachgebiete für die Ausprägung des aktuellen Dialogs geliefert.
   * @return Array der Fachgebiete für eine bestimmte Ordination, siehe auch
   *         {@link BaseProperty BaseProperty}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_INVALID ORDINATION_ID_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID}
   */
  BaseProperty[] getFachgebieteByOrdId(String dialogId, String ordId, String taetigkeitsBereichId)
      throws DialogException, ServiceException;

  /**
   * <p>
   * Mit dieser Funktion werden die GINA-Information und die Verfügbarkeitsinformationen der auf der
   * GINA installierten Services geliefert.
   * </p>
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul><li>Keine</li></ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @return Objekt, mit Informationen zur GINA, siehe auch {@link StatusInformationen StatusInformationen}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
   */
  StatusInformationen getGinaAndServiceavailabilityInformation() throws ServiceException;

  /**
   * <p>
   * Mit dieser Funktion kann vor einem Request mit Kartenzugriff die Kartenleserzuordnung geändert
   * werden. 
   * <br>Es wird dem Dialog der Kartenleser mit der übergebenen
   * <i>CardReaderId</i> zugeordnet.
   * </p>
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul><li>Es ist zumindest ein Kartenleser am Ordinationsclient/der Server-GINA angeschlossen. </li></ul>
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @param dialogId Dialog-Id eines aufgebauten Dialogs 
   * @param cardReaderId Identifizierer des Kartenlesers
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   */
  void setCardReader(String dialogId, String cardReaderId) throws CardException,
      ServiceException, DialogException;

  /**
   * <p>
   * Mit dieser Funktion werden Ereignisse der Kartenleser ermittelt. 
   * <br>Ein Ereignis ist z.B. die Statusänderung von es ist keine Karte
   * gesteckt auf es ist eine Karte gesteckt. Es werden für alle auf der GINA bekannten Kartenleser laufend die aktuellen
   * Kartenleserstatus und Ereignisse ermittelt. Abhängig der Eingangsdaten (<i>statusId</i>) enthält das Rückgabeobjekt die aktuellen
   * Kartenleserstatus (momentaner Kartenleserstatus zum Abfragezeitpunkt - Initialabfrage) oder die aufgetretenen Ereignisse (Änderungen der
   * Kartenleserstatus seit dem letzten Aufruf - Deltaabfrage) in Form von Kartenleserstatus-Events.
   * </p>
   * <p>
   * <B>Voraussetzung: </B> 
   * <ul><li>Es ist zumindest ein Kartenleser am Ordinationsclient/Server-GINA angeschlossen. </li></ul>
   * </p>
   * <p>
   * <B>Laufzeitgruppe: </B> keine Zuordnung zu einer Laufzeitgruppe (durch den Übergabeparameter <i>userWaitTime</i>)
   * </p>
   * @param handle <i>Handle</i>, Identifikationskennzeichen, optional     
   *        <br>Rückgabewert aus <code>ReaderStatusResult</code>  bei jedem Funktionsaufruf wird ein neuer <i>Handle</i> retourniert 
   *        <ul>
   *        <li>wird der zuletzt erhaltene <i>Handle</i> übergeben, enthält das Rückgabeobjekt nur die aufgetretenen 
   *          Ereignisse seit der letzten Abfrage
   *          (Bsp.: Ausgabe Ereignis Leser 1: Änderung von "keine Karte" auf "Karte gesteckt", Kartentyp "e-card"; 
   *          keine Ausgabe für Leser 2 und 3 da noch immer keine Karte gesteckt und daher kein Ereignis aufgetreten ist, ...)
   *        </li>
   *        <li>
   *          wird ein Leerstring übergeben, enthält das Rückgabeobjekt die momentan aktuellen 
   *          Kartenleserstatus der Kartenleser zum Abfragezeitpunkt (Bsp.: Leser 1: "Karte gesteckt", 
   *          Kartentyp "e-card"; Leser 2: "keine Karte gesteckt"; Leser 3 "keine Karte gesteckt", ...) 
   *       </li>
   *       </ul> 
   * @param cardReaderId Objekt mit <i>cardReaderIds</i> (Identifizierer von Kartenleser), Filterkriterium, optional
   *        
   *        <ul>
   *        <li>wird eine Kartenleserliste übergeben, werden nur die Ereignisse/Kartenleserstatus der angegebenen Kartenleser
   *        retourniert 
   *        </li>
   *        <li>wird keine Kartenleserliste übergeben, werden die Ereignisse/Kartenleserstatus für alle Kartenleser
   *        retourniert. </li>
   *        </ul>
   *        <br>
   *        <i><u>Performancehinweis:</u> Bei sehr großen Installationen und einer nur geringfügig oder gar nicht eingeschränkten
   *        Kartenleserliste, kann es von Vorteil sein diesen Parameter leer zu lassen und die Filterung in der
   *        Vertragspartnersoftware selbst durchzuführen</i>
   *        
   * @param timeOut Maximale Wartezeit in Millisekunden, während dieser Zeit wartet die Funktion auf auftretende Ereignisse
   * @return Objekt, welches den aktuellen <i>Handle</i> und die aufgetretenen Kartenleserstatus-Events enthält, siehe auch
   *         {@link ReaderStatusResult ReaderStatusResult}
   * @throws ServiceException
   *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *         {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws CardException {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR}
   *         {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_TIMEOUT_PARAMETER INVALID_TIMEOUT_PARAMETER},
   *         {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADERCONTROL_NOT_STARTED CARDREADERCONTROL_NOT_STARTED}
   */
  ReaderStatusResult getReaderStatusEvents(String handle, String[] cardReaderId, Integer timeOut)
      throws CardException, ServiceException;

  /**
   * <p>
   * Mit dieser Funktion kann die Karte im Kartenleser explizit freigegeben werden.
   * </p>
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @param cardReaderId Identifizierer des Kartenlesers.
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws CardException
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#CARDREADER_IN_USE CARDREADER_IN_USE},
   *           {@link at.chipkarte.client.base.soap.constants.CardExceptionConstants#INVALID_CARD_READER_ID INVALID_CARD_READER_ID}
   * 
   */
  void releaseCardReader(String cardReaderId) throws CardException, ServiceException;

  /**
   * <p>
   * Diese Funktion gibt die mit dem Dialog verbundenen Rechte im Format
   * <code>Service.Recht</code> zurück.
   * </p>
   * <p>
   * <B>Voraussetzungen: </B> 
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt</li>
   * <li>Der Dialog wurde im Online-Modus aufgebaut. Wenn der Dialog
   * im Offline-Modus aufgebaut wurde, wird eine leere Liste zurückgegeben.
   * </li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Kurz </p>
   * 
   * @param dialogId Dialog-Id eines aufgebauten Dialogs 
   * @return Array der Rechte (String-Array)
   * 
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_INVALID ORDINATION_ID_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID}
   */
  String[] getBerechtigungen(String dialogId) throws ServiceException, DialogException;
  
}