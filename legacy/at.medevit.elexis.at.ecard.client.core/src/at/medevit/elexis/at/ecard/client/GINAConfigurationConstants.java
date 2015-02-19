package at.medevit.elexis.at.ecard.client;

/**
 * Configuration constants
 */
public class GINAConfigurationConstants {

	public static final String CONFIG_BASE = "at.medevit.elexis.at.ecard.client";
	
	// Configuration constants
	public static final String CFG_GINA_IP = CONFIG_BASE+"/gina.address";
	public static final String CFG_GINA_LOCAL_CCR = CONFIG_BASE+"/gina.local.ccr";
	public static final String ENABLE_LOCAL_CCR = CONFIG_BASE+"/gina.local.enable";
	
	// User settings
	public static final String CFG_AUTO_SELECT_PATIENT_IF_AVAILABLE = CONFIG_BASE+"/auto.select.patient.if.available";
	public static final String CFG_AUTO_SELECT_MANDANT_IF_AVAILABLE = CONFIG_BASE+"/auto.select.mandant.if.available";
	
	/** mandant specific: preselected Fachgebiet */
	public static final String CFG_MANDANT_PRE_SELECTED_FACHGEBIET = CONFIG_BASE+"/preselected.fachgebiet";
	/** mandant specific: preselcted Behandlungsfall */
	public static final String CFG_MANDANT_PRE_SELECTED_BEHANDLUNGSFALL = CONFIG_BASE+"/preselected.behandlungsfall";
	
	/** Shared identifier for missing value */
	public static final String NO_VALUE = "N/A NONE N/A";
	
}
