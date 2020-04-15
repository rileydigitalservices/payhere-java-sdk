# MTN MoMo API Java Client</h1>

<strong>Power your apps with our MTN MoMo API</strong>

<div>
  <a href="https://spectrum.chat/payhere-api-sdk/">Spectrum</a>
  <br><br>
</div>


[![Build Status](https://travis-ci.com/rileydigitalservices/payhere-java-sdk.svg?branch=master)](https://travis-ci.com/rileydigitalservices/payhere-java-sdk)
[![Coverage Status](https://coveralls.io/repos/github/rileydigitalservices/payhere-java-sdk/badge.svg?branch=master)](https://coveralls.io/github/rileydigitalservices/payhere-java-sdk?branch=master)
[![Join the community on Spectrum](https://withspectrum.github.io/badge/badge.svg)](https://spectrum.chat/payhere-api-sdk/)

## Requirements

Java 1.8 or later.

## Installation

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.rileydigitalservices</groupId>
  <artifactId>payhere-sdk</artifactId>
  <version>1.2.0</version>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.rileydigitalservices:payhere-sdk:1.2.0"
```

## User Credentials

You get the `APP-ID`, `username` and `password` from `https://dashboard.payhere.africa/register`.

The credentials for the sandbox environment can be used straight away. In production, the credentials are provided for you after KYC requirements are met.

## Configuration

Before we can fully utilize the library, we need to specify global configurations. The global configuration using the requestOpts builder. By default, these are picked from environment variables,
but can be overidden using the RequestOpts builder

* `PAYHERE_BASE_URL`: An optional base url to the Payhere API. By default the staging base url will be used
* `PAYHERE_ENVIRONMENT`: Optional enviroment, either "sandbox" or "production". Default is 'sandbox'
* `PAYHERE_APP_ID`:  The APP-ID assigned for your app
* `PAYHERE_USERNAME`: The username for authentictation,
* `PAYHERE_PASSWORD`:  The password for authentication

### Per-request Configuration

``` java

 RequestOptions opts = RequestOptions.builder()
                        .setAppId("MY_APP_ID")
                        .setUsername("MY_USERNAME")
                        .setPassword("MY_PASSWORD")
                        .setBaseUrl("NEW_PAYHERE_BASE_URL")  // Override the default base url
                        .setTargetEnvironment("sandbox") // Override default target environment
                        build();

```


## Inpayments

Used for Receiving money

PayhereInpaymentsExample.java

```java
import java.util.HashMap;
import java.util.Map;

import com.rileydigitalservices.payhere.network.RequestOptions;
import com.rileydigitalservices.payhere.network.inpayments.InpaymentsClient;


public class PayhereInpaymentsExample {

    public static void main(String[] args)  {

         // Make a request to pay call
         RequestOptions opts = RequestOptions.builder()
                        .setAppId("MY_APP_ID")
                        .setUsername("MY_USERNAME")
                        .setPassword("MY_PASSWORD").build();

                HashMap<String, String> inpaymentMap = new HashMap<String, String>();
                inpaymentMap.put("amount", "100");
                inpaymentMap.put("mobile", "1234");
                inpaymentMap.put("processingNumber", "ext123");
                inpaymentMap.put("narration", "testNarration");

                InpaymentsClient client = new InpaymentsClient(opts);

                try {
                    String transactionRef = client.requestToPay(inpaymentMap);
                    System.out.println(transactionRef);
                } catch (PayhereApiException e) {
                    e.printStackTrace();
                }
    }
}
```

### Methods

1. `requestToPay`: This operation is used to request a payment from a consumer (Payer). The payer will be asked to authorize the payment. The transaction is executed once the payer has authorized the payment. The transaction will be in status PENDING until it is authorized or declined by the payer or it is timed out by the system. Status of the transaction can be validated by using `getTransactionStatus`.

2. `getTransaction`: Retrieve transaction information using the `transactionId` returned by `requestToPay`. You can invoke it at intervals until the transaction fails or succeeds. If the transaction has failed, it will throw an appropriate error.


## Outpayments

Used for sending out money

PayhereOutpaymentsExample.java

```java
import java.util.HashMap;
import java.util.Map;

import com.rileydigitalservices.payhere.network.RequestOptions;
import com.rileydigitalservices.payhere.network.outpayments.OutpaymentsClient;


public class PayhereOutpaymentsExample {

    public static void main(String[] args)  {

                // Make a request to pay call
                RequestOptions opts = RequestOptions.builder()
                                .setAppId("MY_APP_ID")
                                .setUsername("MY_USERNAME")
                                .setPassword("MY_PASSWORD").build();


                HashMap<String, String> outpaymentMap = new HashMap<String, String>();
                outpaymentMap.put("amount", "100");
                outpaymentMap.put("mobile", "1234");
                outpaymentMap.put("processingNumber", "ext123");
                outpaymentMap.put("narration", "testNarration");

                OutpaymentsClient client = new OutpaymentsClient(opts);

                try {
                    String transactionRef = client.transfer(outpaymentMap);
                    System.out.println(transactionRef);
                } catch (PayhereApiException e) {
                    e.printStackTrace();
                }
    }
}
```

### Methods

1. `transfer`: Used to transfer an amount from the owner’s account to a payee account. Status of the transaction can be validated by using the `getTransactionStatus` method.

2. `getTransaction`: Retrieve transaction information using the `transactionId` returned by `transfer`. You can invoke it at intervals until the transaction fails or succeeds.


## Development 

You must have Gradle installed. To run the tests:

```bash
    ./gradlew test
```

The library uses [Project Lombok][lombok]. While it is not a requirement, you might want to install a [plugin][lombok-plugins] for your favorite IDE to facilitate development.

[lombok]: https://projectlombok.org
[lombok-plugins]: https://projectlombok.org/setup/overview

# Thank you. 
