# PaymentRiderApp
 API developed to making payments for a means of transport.
 
 you can use this app clone the repository and using it, like to explained below:
 1. Clone the repository using the command: git clone https://github.com/relativismofisico/PaymentRiderApp.git
 2. Use your preferred IDE
 3. You create a BD, its name will be "db_payment_rider_driver"
 4. Import and compile the project as a maven application
 5. the application by  default insert few test data.
 
For test, you mill make:
 
   1. Start Rider
   URL: http://localhost:8080/api/versionDemo/rider/start/{userId}
   Method: POST
   Where {userId} is the user with role rider (Using in this case 1)
   in this url you can add user with role rider.
   BODY: { "latitude": "12", "longitude": "13" }
   
   2. End Rider
   URL: http://localhost:8080/api/versionDemo/rider/end/{userId]/{riderId}
   Method: PUT
   Where {userId}, {riderId} are the user with role rider (Using in this case 1 for rider and 2 for user's uder)
   The url return the ride id that you use here.
   BODY: { "installments": 2 ,  "reference": "med", "km": "10", "minutes": 200} 
   
   3. Status Transaction
   URL: http://localhost:8080/api/versionDemo/api/pays/Status/transaction/{transactionId}
   Method: GET
   Where {transactionId} is the id transaction
   in this url you can see the transaction's status . 

  4. There is a user with a pay methods in BD, but if you want a test with a other values, firt you should a tokenize card with the 
  PaymentGateway (In this case Wompi) using the url  https://sandbox.wompi.co/v1/tokens/cards and then using the endpoint
  
   created PayMethod 
   URL: http://localhost:8080/api/versionDemo/api/pays//{userId}
   Method: POST
   Where {userId} is the user with role rider
   The url create a paymethod for using to rider
   

