package com.rileydigitalservices.payhere;

import java.io.IOException;
import java.util.HashMap;

import com.rileydigitalservices.payhere.network.PayhereException;
import com.rileydigitalservices.payhere.network.RequestOptions;
import com.rileydigitalservices.payhere.network.inpayments.InpaymentsClient;

import org.apache.commons.cli.ParseException;


public class Payhere {


  Payhere() {


  }

  /**
   * Provision Sandbox Account.
   *
   * @param args providerCallBackHost and primaryKey(Ocp-Apim-Subscription-Key)
   * @throws ParseException when args are missing
   * @throws IOException    when network error occurs
   */
  public static void main(String[] args) throws ParseException, IOException {


    // Make a request to pay call
    RequestOptions opts = RequestOptions.builder()
        .build();

    HashMap<String, String> collMap = new HashMap<String, String>();
    collMap.put("amount", "100");
    collMap.put("msisdn", "0782123456");
    collMap.put("ProcessingNumber", "ext123");
    collMap.put("narration", "testNarration");

    InpaymentsClient client = new InpaymentsClient(opts);

    try {
      String transactionRef = client.requestToPay(collMap);
      System.out.println(transactionRef);
    } catch (PayhereException e) {
      e.printStackTrace();
    }


  }

}
