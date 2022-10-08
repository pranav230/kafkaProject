# Kafka Project
 
* It is a spring boot application that will take the record information from a file and push it into a Kafka topic. The record will be consisting a subscriber, case, patient, and service inside it.
* It will segregate the data on the basis of objects and send that data to the particular topics. It will perform those actions using both KStreams and KSQL.
* This data will also be going to the Ktables using KSQL.
* All the data for the objects will be fed to a postgres DB using KConnect.

<i>Note: The Ksql queries and Connector configurations can be found in the resources folder.</i>
