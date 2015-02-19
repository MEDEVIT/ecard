package at.chipkarte.client.dmp.soap.exceptions;

import at.chipkarte.client.base.soap.exceptions.BaseExceptionContent;

public class DmpExceptionContent extends BaseExceptionContent {

  private String[] _svtCodes = null;

  /**
   * @return SVT Liste.
   */
  public String[] getSvtCodes() {
    return _svtCodes;
  }

  /**
   * @param svtCodes SVT Liste.
   */
  public void setSvtCodes(String[] svtCodes) {
    _svtCodes = svtCodes;
  }
}
