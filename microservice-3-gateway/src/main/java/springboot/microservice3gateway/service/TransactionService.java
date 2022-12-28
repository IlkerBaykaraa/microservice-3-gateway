package springboot.microservice3gateway.service;

import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.microservice3gateway.request.ITransactionServiceRequest;
import springboot.microservice3gateway.utils.RetrofitUtils;

import java.util.List;

@Service
public class TransactionService implements ITransactionService{
    @Autowired
    private ITransactionServiceRequest transactionServiceRequest;

    @Override
    public JsonElement saveTransaction (JsonElement transaction)
    {
        return RetrofitUtils.executeInBlock(transactionServiceRequest.saveTransaction(transaction));
    }

    @Override
    public void deleteTransaction(Long transactionId)
    {
        RetrofitUtils.executeInBlock(transactionServiceRequest.deleteTransaction(transactionId));
    }

    @Override
    public List<JsonElement> getAllTransactions() {
        return RetrofitUtils.executeInBlock(transactionServiceRequest.getAllTransaction());
    }


}
