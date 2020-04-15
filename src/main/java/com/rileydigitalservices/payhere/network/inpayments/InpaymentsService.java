package com.rileydigitalservices.payhere.network.inpayments;

import com.rileydigitalservices.payhere.models.RequestToPay;
import com.rileydigitalservices.payhere.models.Transaction;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface InpaymentsService {


  /**
   * requestToPay.
   *
   * @param body RequestBody
   * @param ref  String
   * @return Void
   */
  @POST("/inpayemnts")
  @Headers("Content-Type: application/json")
  Call<Void> requestToPay(@Body RequestToPay body);

  /**
   * Get Transaction Status.
   *
   * @param transactionId String
   * @return Transaction object
   */
  @GET("/inpayments/{transactionId}")
  @Headers("Content-Type: application/json")
  Call<Transaction> getTransactionStatus(@Path("transactionId") String transactionId);

}
