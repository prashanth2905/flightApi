## Getting Started

Start your application by running the below commands.
1) ./gradlew clean build
2) ./gradlew boot-run

once the application is up and running use the below endpoint

http://localhost:8080/swagger-ui.html#/flight-api-controller

pass in the origin and date to get the result back. Example:

http://192.168.0.163:8080/api/flightApi?origin=PAR&departureDate=2018-10-01