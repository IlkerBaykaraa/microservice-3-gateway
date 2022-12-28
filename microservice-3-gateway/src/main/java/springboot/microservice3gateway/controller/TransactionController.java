package springboot.microservice3gateway.controller;

import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.microservice3gateway.service.ITransactionService;

@RestController
@RequestMapping("/gateway/transaction")
public class TransactionController
{
    @Autowired
    private ITransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> saveTransaction(@RequestBody JsonElement transaction)
    {
        //may be change
        return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
    }

    @DeleteMapping("/{transactionId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long transactionId)
    {
       try {
           transactionService.deleteTransaction(transactionId);
       }
       catch (Exception e)
       {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }

       return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllTransaction(){
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }
}
