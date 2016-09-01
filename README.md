# Java SDK for Pay.nl

---

- [Quick start and examples](#usage)

---

This SDK is available as JAR file.

With this SDK you will be able to start transactions and retrieve transactions with their status for the Pay.nl payment service provider.

### Requirements

This SDK depends on the following:
* [Google GSON library](https://github.com/google/gson) (included in JAR release)


### Usage
_Creating a transaction_
```Java
         TransactionService transaction = new TransactionService();
         transaction.setToken("token");
         transaction.setServiceId("SL-code-here");
         transaction.setTestMode(false);
         transaction.setAmount(199); // 1.99 euro
         transaction.setIpAddress("127.0.0.1");
         transaction.setfinishUrl("https://pay.nl"); // Params will be added by Pay.nl
         transaction.transactionData.setDescription("Test Payment");
         transaction.transactionData.setOrderExchangeUrl("https://pay.nl"); // Status exchange URL
         transaction.endUser.setLanguage("NL"); // ISO code (ISO 639-1)
         transaction.endUser.setInitials("T");
         transaction.endUser.setLastName("Testpersoon");
         transaction.endUser.address.setStreetName("Example street");
         transaction.endUser.address.setStreetNumber("1");
         transaction.endUser.address.setZipCode("1234AA");
         transaction.endUser.address.setCity("Spijkenisse");
         transaction.startRequest(); // Do the actual request
         TransactionResult result = transaction.getResult(); // Return the result object
         if (result.request.result.equalsIgnoreCase("1")) {
             System.out.println(result.transaction.transactionId);
             System.out.println(result.transaction.paymentURL);
         } else {
             System.out.println("Error: "+ result.request.errorMessage); // Get the error message
         }
```

Retrieving transaction status
```Java
        // Getting transaction status
        TransactionInfoService transactionInfoService = new TransactionInfoService();
        transactionInfoService.setServiceId("SL-6418-1480");
        transactionInfoService.setToken("Replacebytoken");
        transactionInfoService.setTransactionId("696298750X366d6a");
        transactionInfoService.startRequest();
        TransactionInfoResult result = transactionInfoService.getResult();
        System.out.println("This transaction is paid: " + result.isPaid());
        System.out.println("This transaction is canceled: " + result.isCanceled());
        System.out.println("This transaction is pending: " + result.isPending());
        System.out.println("Payment state: " + result.getPaymentState());
        System.out.println(result.request.result);
        System.out.println(result.request.errorMessage);
```

### Contributing

Please file pull requests to this repository, when checked, this will be merged and included in next releases.


### License

This SDK is available as open source under the terms of the [MIT License](http://opensource.org/licenses/MIT).
