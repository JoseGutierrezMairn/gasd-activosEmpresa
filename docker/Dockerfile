FROM openjdk:11
ENV host_address=jdbc:mysql://192.168.80.11:3306/activos_empresa
RUN mkdir /backend
ADD activos-0.0.1-jar-with-dependencies.jar /backend
ADD java.security /usr/local/openjdk-11/conf/security
CMD ["java","-jar","/backend/activos-0.0.1-jar-with-dependencies.jar"]