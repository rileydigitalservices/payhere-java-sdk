package com.rileydigitalservices.network.inpayments;

import java.io.IOException;
import java.util.HashMap;

import com.rileydigitalservices.payhere.network.PayhereException;
import com.rileydigitalservices.payhere.network.RequestOptions;
import com.rileydigitalservices.payhere.network.inpayments.InpaymentsClient;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;

public class LiveInpaymentsClientTest {

  /**
   * Test request to pay.
   *
   * @throws IOException when network error
   */

  @Test
  public void testRequestToPay() throws IOException {

    RequestOptions opts = RequestOptions.builder()
        .build();
    assertNotNull(opts.getAppId());
    assertNotNull(opts.getUsername());
    assertNotNull(opts.getPassword());


    HashMap<String, String> collMap = new HashMap<String, String>();
    collMap.put("amount", "100");
    collMap.put("msisdn", "0782123456");
    collMap.put("processingNumber", "ext123");
    collMap.put("narration", "testNarration");

    InpaymentsClient client = new InpaymentsClient(opts);

    try {
      String transactionRef = client.requestToPay(collMap);
      assertNotNull(transactionRef);

    } catch (PayhereException e) {
      e.printStackTrace();
    }


  }


}
