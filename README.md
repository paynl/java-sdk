# Java SDK for Pay.nl

---

- [Quick start and examples](#usage)

---

This SDK is available as JAR file.

With this SDK you will be able to start transactions and retrieve transactions with their status for the Pay.nl payment service provider.

### Requirements

This SDK depends on the following:
* [Google GSON library](https://github.com/google/gson) (included in JAR release)

### Getting everything installed
You can import nl.pay.sdk from the Maven repository at [Sonatype](https://oss.sonatype.org/#nexus-search;quick~pay.nl).
You should see it, when looking for:
 nl.pay:sdk

You should select the latest version in your IDE.


### Usage

_Fetching available payment methods and banks_
```Java
        ServiceListService service = new ServiceListService();
        service.setToken("token");
        service.setServiceId("SL-code-here");

        ServiceListResult serviceListResult = service.getResult();

        serviceListResult.getPaymentMethods().values().forEach(paymentMethod -> {
            System.out.println(paymentMethod.id+" - "+paymentMethod.name);

            if(paymentMethod.paymentOptionSubList != null){
                paymentMethod.paymentOptionSubList.values().forEach(bank ->{
                    System.out.println(" ↳ "+bank.id+" - "+bank.name);
                });
            }
        });

```

_Creating a transaction_
```Java
         TransactionService transaction = new TransactionService();
         transaction.setToken("token");
         transaction.setServiceId("SL-code-here");
         transaction.setTestMode(false);
         transaction.setPaymentOptionId(10); // PaymentMethod.id from the example above
         transaction.setPaymentOptionSubId(1); // bank.id from the example above
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
         // Optionally : sending products to the system
         Product prod = new Product();
         prod.setType(Product.PRODUCT_TYPE_DOWNLOAD);
         prod.setPrice(98);
         prod.setDescription("Test product download");
         prod.setQuantity(1);
         prod.setProductId("1");
         transaction.saleData.addProduct(prod);
         
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

Refunding a transaction
```Java
        TransactionRefundService refund = new TransactionRefundService();
        refund.setToken("token_here");
        refund.setServiceId("SL-code-here");
        refund.setAmount(200);
        refund.setTransactionId("EX-code-inthis-field");
        refund.setDescription("Test refund");
        refund.startRequest();
        nl.pay.sdk.refund.TransactionResult result = refund.getResult();
        if (result.getAmountRefunded() == 0)
        {
            System.out.println(result.getError());
            System.out.println(result.description);
        }
        System.out.println(result.getAmountRefunded());
```

### Contributing

Please file pull requests to this repository, when checked, this will be merged and included in next releases.


### License

This SDK is available as open source under the terms of the [MIT License](http://opensource.org/licenses/MIT).
