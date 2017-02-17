FROM java:8

ADD target/gene-app-1.0-SNAPSHOT.jar gene-app-1.0-SNAPSHOT.jar 

CMD ["java", "-jar", "gene-app-1.0-SNAPSHOT.jar" ]

