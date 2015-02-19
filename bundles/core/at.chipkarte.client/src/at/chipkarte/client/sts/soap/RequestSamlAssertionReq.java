/*
 * (C) SVCBE 2008
 */
package at.chipkarte.client.sts.soap;

/**
 * Enthält die Eingangsdaten zum Aufruf der Funktion
 * {@link at.chipkarte.client.sts.soap.IStsService#requestSamlAssertion(String, RequestSamlAssertionReq, String) requestSamlAssertion}.
 */
public class RequestSamlAssertionReq {
  private String _ticketSubject;
  private String _responseURL;

  /**
   * Das Subject ist eine URL und beinhaltet den Ticketnamen und die fuer 
   * die Ausstellung des jeweiligen Tickets benoetigetn Parameter.<br>
   * Format: http://ns.svc.co.at/sts/[TicketName]/[TicketInfo]?VPNR=[VPNR]<br>
   * Unterstützte Ticketsubjects siehe Zusatzdokument "Ticketinformation".
   * 
   */
  public String getTicketSubject() {
    return _ticketSubject;
  }
  /**
   * Anhand dieser URL wird geprueft ob der Requester dem e-card System bekannt ist. <br>
   * Unbekannten Requestern werden keine Tickets ausgestellt.
   * Ist der Requester bekannt wird die ResponseURL als AudienceRestriction des ausgestellten
   * Tickets uebernommen und das Ticket an diese URL versendet.
   * Format: maximal 1024 Zeichen, gueltige URL.
   */
  public String getResponseURL() {
    return _responseURL;
  }

  public void setTicketSubject(String ticketSubject) {
    this._ticketSubject = ticketSubject;
  }

  
  public void setResponseURL(String responseURL) {
    this._responseURL = responseURL;
  }

}
