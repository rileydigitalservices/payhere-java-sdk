package com.rileydigitalservices.payhere.network;

import java.io.IOException;

/**
 * An exception class for the response.
 */
public final class PayhereException extends IOException {


  /**
   * PayhereException.
   *
   * @param response String
   */
  public PayhereException(String response) {
    super(response);

  }
}
