/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.servicemanager.soap;

/**
 * Dieses Service stellt den Einstiegspunkt für die Vertragspartnersoftware dar. Der Zugriff auf alle weiteren Endpoints sollte 
 * immer durch Verwendung des Service-Manager erfolgen. Die URL eines weiteren Endpoints wird durch Aufruf der Funktion
 * {@link at.chipkarte.client.soap.IServiceManager#getServices getServices} abgefragt, wobei im Ergebnis auf Basis des Namens bzw.
 * der Version das entsprechende Service ermittelt und der zugehörige URL ausgelesen werden kann.
 */
public interface IServiceManager {

  /**
   * Diese Funktion liefert alle verfügbaren Services (SOAP-Endpoints). Von der Vertragspartnersoftware können die entsprechenden
   * Services anhand der mitgelieferten Informationen ausgewählt werden. Es können mehrere Services mit gleichen Namen vorkommen.
   * Diese unterscheiden sich dann durch ihre Version bzw. ihren Typ. Bei dem URL zum Service, siehe
   * {@link Service#getEndPointURL() EndPointURL} handelt es sich um eine <b>absolute</b> Adressangabe.
   * <p>
   * <B>Laufzeitgruppe: </B> Kurz
   * </p>
   * @return Liste von verfügbaren Services
   */
  Service[] getServices();

}
