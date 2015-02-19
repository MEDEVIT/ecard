/*
 * (C) Siemens and SVCBE 2004
 */

package at.chipkarte.client.base.soap.constants;

/**
 *  Fehlerkonstanten für die {@link at.chipkarte.client.base.soap.exceptions.BCardException BCardException} (Bürgerkarte).
 * 
 */
public class BCardExceptionConstants {

  /**
   * Es sind keine Bürgerkartendaten vorhanden. Möglicherweise wurde zuvor nicht die Funktion
   * {@link at.chipkarte.client.base.soap.IBaseServiceCommon#getCardData(java.lang.String) getCardData} aufgerufen.
   * <br>ORCLI-Code: CL-A0003
   * 
   */
  public static final int NO_BCARD_DATA_AVAIL = 18;

  /**
   * Die angegebene Sozialversicherungsnummer stimmt nicht mit der Sozialversicherungsnummer der am Ordinations-Client gespeicherten
   * Daten der Bürgerkarte überein.
   * <br>ORCLI-Code: CL-A0004
   */
  public static final int NOMATCH_BCARD_SVNR = 19;

  /**
   * VSNR der SV Person kann nicht über bPK bestätigt werden. (Die Personenbindungsdaten der Bürgerkarte sind im e-card System nicht
   * zugeordnet. Der Patient muss eine Richtigstellung beantragen.) <br>
   * ORCLI-Code: ZS-00059
   */
  public static final int SVPERSON_NO_LONGER_FOUND = 26;

  /**
   * Versichertenperson kann nicht über bPK identifiziert werden (Die Personendaten der Genehmigungsanfrage sind inkonsistent).
   * <br>ORCLI-Code: ZS-00058
   */
  public static final int SVNR_CONFIRMATION = 27;

  /**
   * Die <b>P</b>ersonen<b>b</b>indungs<b>d</b>aten der Bürgerkarte des Patienten sind im e-card System 
   * nicht zugeordnet. 
   * Der Patient muss eine Zuordnung beantragen.
   * <br>ORCLI-Code: ZS-00056
   */
  public static final int PBD_NOT_ASSIGNED = 33;
}
