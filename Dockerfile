FROM openjdk:19

ADD bin/App.jar App.jar

ENTRYPOINT ["java", "-jar","App.jar"]