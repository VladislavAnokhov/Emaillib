# EmailLib

## Introduction
EmailLib is a Kotlin library for intercepting errors in Spring Batch jobs and sending email notifications to configured recipients.

## Configuration

1. Add the library to your project:
    ```kotlin
    dependencies {
        implementation("com.example:emaillib:1.0.0")
    }
    ```

2. Configure the database:
    - For local development (H2):
      ```yaml
      spring:
        datasource:
          url: jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
          driver-class-name: org.h2.Driver
          username: sa
          password:
        jpa:
          hibernate:
            ddl-auto: update
          show-sql: true
      ```

    - For production (Oracle):
      ```yaml
      spring:
        datasource:
          url: jdbc:oracle:thin:@//your-oracle-db-host:1521/your-service-name
          driver-class-name: oracle.jdbc.OracleDriver
          username: your_username
          password: your_password
        jpa:
          hibernate:
            ddl-auto: update
          show-sql: true
      ```

3. Configure the mail sender:
    ```yaml
    spring:
      mail:
        host: smtp.example.com
        port: 587
        username: your_username
        password: your_password
    ```

4. Use the listener in your job:
    ```kotlin
    @Bean
    fun job(jobBuilderFactory: JobBuilderFactory, stepBuilderFactory: StepBuilderFactory, jobErrorListener: JobErrorListener): Job {
        return jobBuilderFactory.get("exampleJob")
            .incrementer(RunIdIncrementer())
            .listener(jobErrorListener)
            .start(stepBuilderFactory.get("exampleStep").tasklet { _, _ -> 
                // Simulate a failure
                throw RuntimeException("Simulated error")
                RepeatStatus.FINISHED 
            }.build())
            .build()
    }
    ```

5. Configure the recipients using the REST API:
    ```bash
    curl -X POST -H "Content-Type: application/json" -d '{"name": "John Doe", "email": "john.doe@example.com", "batchName": "exampleJob", "errorType": "JOB_FAILURE"}' http://localhost:8080/recipients
    ```

## Usage
The library will automatically intercept errors in Spring Batch jobs, send email notifications to the configured recipients, and log errors and sent emails in the database.

## Contributions
If you wish to contribute to this project, please open a pull request or report an issue.#   E m a i l l i b  
 