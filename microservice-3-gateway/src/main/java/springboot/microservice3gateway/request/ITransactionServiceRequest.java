package springboot.microservice3gateway.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ITransactionServiceRequest {

    @POST("/api/transaction")
    Call<JsonElement> saveTransaction(@Body JsonElement requestBody);

    @DELETE("/api/transaction/{transactionId}")
    Call<Void> deleteTransaction(@Path("transactionId") Long productId);

    @GET("/api/transaction")
    Call<List<JsonElement>> getAllTransaction();


}
