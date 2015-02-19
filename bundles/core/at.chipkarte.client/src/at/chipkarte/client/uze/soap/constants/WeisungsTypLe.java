/*
 * (C) Siemens and SVCBE 2007
 */
package at.chipkarte.client.uze.soap.constants;

/**
 * Beschreibt die Weisungstypen, die der Leistungserbringer einl&ouml;sen kann.
 */
public class WeisungsTypLe {
  
  /**
   * <b>U</b>eber<b>W</b>eisung.
   */
  public static final String UEBERWEISUNG = "UW";
  
  /**
   * <b>Z</b>uweisung <b>M</b>it Patientenkontakt.
   */
  public static final String ZUWEISUNG_MIT_PATIENTENKONTAKT = "ZM";
  
  /**
   * <b>Z</b>uweisung <b>O</b>hne Patientenkontakt.
   */
  public static final String ZUWEISUNG_OHNE_PATIENTENKONTAKT = "ZO";
  
  /**
   * <b>E</b>in<b>W</b>eisung.
    * Nur wenn das entsprechende Recht des VPs vorhanden ist.
   */
  public static final String EINWEISUNG = "EW";
}
