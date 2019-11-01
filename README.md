# Project for nexign

This is an example api for nexign with spring boot.

Negate balance not allowed ;-)

Active profile is set to dev

io.swagger.controllers.DBHelper class initialize DB


## Overview  

### Balances-api-controller : the balances API
POST /balances/{userId}
modify balance for subscriber

### Bperations-api-controller : the operations API
POST /operations/{userId}
make subscriber operation

###  Subscribers-api-controller : the subscribers API
GET /subscribers
get subscribers info

POST /subscribers
create new subscriber

DELETE /subscribers/{userId}
delete subscriber

GET /subscribers/{userId}
get subscriber info

GET /subscribers/{userId}/balance
show balance for subscriber

GET /subscribers/{userId}/status
show status for subscriber

# Detailed api

http://127.0.0.1:8000/MinimaJack/nexign/1.0.0/