# **The power of Java interface and Generics in Spring Boot: parameterize the Spring Data Repository so that it can easily switch to different SQL databases or to NoSql (MongoDb) without having to change the business logic (Service layer)**

This article was born from a work need that I satisfied and is dedicated to a dear colleague of mine who told me that it is not possible to parameterize Spring Data repositories with an interface, Chatgpt says about the same thing, for now....


I'll describe the use case I encountered: an application receives MQTT data in various formats, performs its processing, and ultimately persists/reads the data to/from a SQL database with specific tables and column names (specific entities in JPA). The same application must be able to, by simply changing the Spring profile, save/read the same data to/from a table in another SQL database whose tables have different names and column names (another entity in JPA), while leaving the business logic (Service layer) intact. For this Spring Data use case, different entities would mean different repositories (duplicates for each profile) and different services (duplicates for each profile), thus a project with a lot of repetitive code. Not only that, since there is uncertainty about the system design, the application may decide that at the end of the processing it should save/read to/from a NoSQL database (MongoDb). Without using the interface as a parameter of the repostitory I would have had to create a single project with repeated code, or a Git project for each listener taking care to keep the logic aligned.


I apologize in advance for the antipatterns in the project and for the repeated code but this is a simulation in which a specific problem is focused on and solved, this project has essentially an educational and descriptive purpose of the solution to a problem that may be recurring.

Last night I spent a couple of hours taking my code from a Spring Boot project from a couple of years ago and writing this article.

You can clone it and enjoy launching it locally.

This is entirely the result of my knowledge and ChatGpt doesn't give the correct answer, for now….

#java #spring #interface #nosql #mongodb #generics 

In 2021 I worked for an Italian company that provides electronic toll collection and mobility services, primarily for drivers and logistics operators in Europe. OBU (On-Board Unit) is the device installed inside a vehicle that enables communication with tolling systems. 

Let’s assume that the OBU (On-Board Unit) sends different JSON-formatted position data depending on the country where the vehicle is currently moving.
For example:

In Italy, it sends:

{"latitudine": 41.9028, "longitudine": 12.4964, "obu_ita": "ITA-001"}

 In Poland, it sends:

{"szerokosc": 52.2297, "długosc": 21.0122, "obu_pol": "POL-001"}


Each message is published to a country-specific MQTT queue — Italian messages go to the Italian MQTT queue, and Polish messages to the Polish one.After receiving the messages, assume the system applies the same business logic regardless of country. However, the processed data from each queue is persisted into different databases and different tables, one per country. Different tables like these:

Poland: obu_message_poland


CREATE TABLE obu_message_poland 

(
    id BIGINT PRIMARY KEY,

    szerokosc DOUBLE PRECISION,

    dlugosc DOUBLE PRECISION,

    obu_pol VARCHAR(255)

)


Italy: obu_message_ita

CREATE TABLE obu_message_ita 

(
    id BIGINT PRIMARY KEY,

    latitudine DOUBLE PRECISION,

    longitudine DOUBLE PRECISION,

    obu_ita VARCHAR(255)

)

I had to carefully design the MQTT listener architecture to support this multi-country persistence strategy, while ensuring that the same internal business logic was preserved across all listeners. 

**Without using the interface as a parameter of the repostitory I would have had to create a single project with repeated code, or a Git project for each country taking care to keep the logic aligned.**




