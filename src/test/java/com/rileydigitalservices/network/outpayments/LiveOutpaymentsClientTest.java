package com.rileydigitalservices.network.outpayments;

import java.io.IOException;
import java.util.HashMap;

import com.rileydigitalservices.payhere.network.PayhereException;
import com.rileydigitalservices.payhere.network.RequestOptions;
import com.rileydigitalservices.payhere.network.outpayments.OutpaymentsClient;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;

public class LiveOutpaymentsClientTest {

  /**
   * Test outpayments.
   *
   * @throws IOException when netowk error.
   */

  @Test
  public void testTransfer() throws IOException {


    RequestOptions opts = RequestOptions.builder()
        .build();


    HashMap<String, String> collMap = new HashMap<String, String>();
    collMap.put("amount", "100");
    collMap.put("msisdn", "0782123456");
    collMap.put("processingNumber", "ext123");
    collMap.put("narration", "testNarration");

    OutpaymentsClient client = new OutpaymentsClient(opts);

    try {
      String transactionRef = client.transfer(collMap);
      assertNotNull(transactionRef);

    } catch (PayhereException e) {
      e.printStackTrace();
    }

  }

}
