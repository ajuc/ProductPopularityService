# ProductPopularityService
(Almost) REST service that shows products and how many times they were viewed.

Installation:

1. have maven and jdk installed
2. download the zip or clone the repository
3. unpack the zip if needed
4. enter the directory ProductPopularityService
5. enter in command line:
   mvn install
   and see if all the test cases pass (they should).
6. enter in command line:
   mvn spring-boot:run
   and in browser go to:
       localhost:8080/products
       localhost:8080/products/1   (or any other id)
       localhost:8080/products?name=Hammer (or any other name)
   
       


