FROM payara/micro
EXPOSE 9990
ENTRYPOINT ["java", "-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=9990", "-jar", "/opt/payara/payara-micro.jar", "--deploy"]
COPY ./build/libs/kalah.war .
CMD ["kalah.war"]