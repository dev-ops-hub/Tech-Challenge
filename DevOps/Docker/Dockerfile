FROM openjdk:8

EXPOSE 80

WORKDIR /user/local/bin

copy QueryFormApplication-0.0.1-SNAPSHOT.war webapp.war 

CMD ["java", "-Dspring.profiles.active=docker-spring", "-jar", "webapp.war"]
