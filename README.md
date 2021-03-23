# library

You can run this application with the following commands:

cd library
./mvnw spring-boot:run

You will need to have the following environment variables set to the correct values:

1. datasource_url
2. datasource_username
3. datasource_password
    
Note that datasource_url should be a JDBC URL and that you must have a MySQL database running with a schema called 'library'.  

For example:

    ./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Ddatasource_url=jdbc:mysql://localhost:3306/library?serverTimezone=UTC&useLegacyDatetimeCode=false&useSSL=false -Ddatasource_username=art -Ddatasource_password=vand3lay"