/*
 * (C) SVC 2010
 */
package at.chipkarte.client.das.soap;

import at.chipkarte.client.base.soap.Property;
import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.das.soap.exceptions.DasException;
import at.chipkarte.client.das.soap.exceptions.DasInvalidParameterException;

/**
 * <p>
 * Dieses Service stellt die Funktionalitäten des Datenabfrageservices (DAS) zur Verfügung
 * </p>
 */
public interface IDasService {
  /**
   * <p>
   * Diese Funktion liefert den Systemstatus des DAS zurück.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Zugriff auf DAS
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DAS_CORE DAS_CORE}).
   * </li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Kurz</p>
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @return Array mit Key und Wert eines Attributpaares, siehe auch {@link Property Property}<br>
   *           Möglicher Key siehe {@link at.chipkarte.client.base.soap.constants.StatusProperty#SERVICE_STATE SERVICE_STATE}.<br>
   *           Mögliche Werte siehe {@link at.chipkarte.client.base.soap.constants.Modus Modus Konstanten}<br>
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DAS_CORE MISSING_DAS_CORE}
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
   * Diese Funktion liefert einen ökonomischen Vergleich von Arzneispezialitäten
   * anhand einer übergebenen Pharmanummer zurück.
   * </p>
   * <p>
   * <b>Voraussetzungen: </b>
   * <ul>
   * <li>Funktion
   * {@link at.chipkarte.client.base.soap.IBaseService#setDialogAddress(String, String) setDialogAddress}
   * wurde erfolgreich ausgeführt.</li>
   * <li>Online Modus des Dialogs.</li>
   * <li>Zugriff auf DAS
   *     (siehe {@link at.chipkarte.client.base.soap.constants.Berechtigungen#DAS_CORE DAS_CORE}).
   * </li>
   * </ul>
   * </p>
   * 
   * <p><B>Laufzeitgruppe: </B> Mittel</p>
   * @param dialogId
   *          Dialog ID eines aufgebauten Dialogs.
   * @param pharmaNumber
   *          Pharmanummer des Medikaments. <br/>
   *          Format: 7-stellig, numerisch. <br/>
   *          Die Pharmanummer muss den Regeln für Pharmanummern (Prüfziffer) entsprechen. 
   * @return Ergebnis des ökonomischen Vergleichs
   * @throws AccessException
   *           {@link at.chipkarte.client.base.soap.constants.AccessExceptionConstants#MISSING_DAS_CORE MISSING_DAS_CORE}
   * @throws DialogException
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_INVALID DIALOG_INVALID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_NOT_AUTHENTICATED DIALOG_NOT_AUTHENTICATED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_NOTSET ORDINATION_ID_NOTSET},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI TOO_MANY_OPEN_DIALOGS_FOR_OR_CLI},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_UNKNOWN DIALOG_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#ORDINATION_ID_UNKNOWN ORDINATION_ID_UNKNOWN},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#CORRUPT_DIALOGID CORRUPT_DIALOGID},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_OFFLINE_MODUS_CHANGED_ONLINE DIALOG_OFFLINE_MODUS_CHANGED_ONLINE},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_CANCELED DIALOG_CANCELED},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#DIALOG_TIMEOUT DIALOG_TIMEOUT},
   *           {@link at.chipkarte.client.base.soap.constants.DialogExceptionConstants#INVALID_TRANSACTION_ID INVALID_TRANSACTION_ID}
   * @throws ServiceException
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INTERNAL_ERROR INTERNAL_ERROR},
   *           {@link at.chipkarte.client.base.soap.constants.ServiceExceptionConstants#INCOMPATIBILITY_EXCEPTION INCOMPATIBILITY_EXCEPTION}
   * @throws DasInvalidParameterException
   *           {@link at.chipkarte.client.das.soap.constants.DasInvalidParameterExceptionConstants#IEKO_PHARMA_NUMBER_NOT_SET IEKO_PHARMA_NUMBER_NOT_SET},
   *           {@link at.chipkarte.client.das.soap.constants.DasInvalidParameterExceptionConstants#IEKO_PHARMA_NUMBER_INVALID IEKO_PHARMA_NUMBER_INVALID}
   * @throws DasException
   *           {@link at.chipkarte.client.das.soap.constants.DasExceptionConstants#IEKO_NO_COMPARISON_FOUND IEKO_NO_COMPARISON_FOUND}
   */
  IEKOEconomicGrouping retrieveIEKOEconomicGrouping(String dialogId, String pharmaNumber) throws DialogException, AccessException, 
  ServiceException, DasInvalidParameterException, DasException;
}
