/*
 * (C) Siemens and SVCBE 2004
 */

package at.chipkarte.client.base.soap.constants;

/**
 * Fehlerkonstanten für fehlende Rechte eines Vertragspartners zur Ausführung bestimmter Funktionen.
 */
public final class AccessExceptionConstants {

  private AccessExceptionConstants() {
    // nothing to do
  }
  
  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'KSE.FULL' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_KSE_FULL = 1;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'KSE.CORE' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_KSE_CORE = 2;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'ABS.CORE' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_ABS_CORE = 3;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'ABS.ARZTBRIEF' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_ABS_ARZTBRIEF = 4;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'ABS.REZEPTUR' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_ABS_REZEPTUR = 5;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'BASE.CORE' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_BASE_CORE = 6;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'SAS.CORE' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_SAS_CORE = 7;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'VDAS.CORE' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_VDAS_CORE = 8;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'DMP.CORE' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_DMP_CORE = 9;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'TSV.CORE' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_TSV_CORE = 11;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'AUM.CORE' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_AUM_CORE = 12;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'UZE.CORE' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_UZE_CORE = 13;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'UZE.UZE_EW_EINLOESEN' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_UZE_EW_EINLOESEN = 14;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'UZE.UZE_FG_UEBERGREIFEND' Voraussetzung
   * ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_UZE_FG_UEBERGREIFEND = 15;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'VDAS.ANSPRUCH_HISTORISCH' Voraussetzung
   * ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_VDAS_ANSPRUCH_HISTORISCH = 16;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'DBAS.CORE' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_DBAS_CORE = 17;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'STS.CORE' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_STS_CORE = 18;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'DAS.CORE' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_DAS_CORE = 19;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'DBAS.QZK' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_DBAS_QZK = 20;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'SAS.ADRESSABFRAGE' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_SAS_ADRESSABFRAGE = 29;

  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'PROP.CORE' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_PROP_CORE = 30;
  
  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'BKF.CORE' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_BKF_CORE = 31;
  
  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'BKF.MAMMO' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_BKF_MAMMO = 32;
  
  /**
   * Diese Exception tritt auf, wenn eine Funktion aufgerufen wird, für die das Recht 'BKF.ASSESSMENT' Voraussetzung ist. <br>
   * ORCLI-Code: CL-A0005
   */
  public static final int MISSING_BKF_ASSESSMENT = 33;
  
  
}
