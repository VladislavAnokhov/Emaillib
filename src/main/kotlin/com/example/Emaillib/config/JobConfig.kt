package com.example.Emaillib.config

import com.example.Emaillib.listener.JobErrorListener
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
@EnableBatchProcessing
class JobConfig(
    private val jobErrorListener: JobErrorListener,
    private val jobRepository: JobRepository,
    private val transactionManager: PlatformTransactionManager
) {

    @Bean
    fun sampleJob(): Job {
        return JobBuilder("sampleJob", jobRepository)
            .listener(jobErrorListener)
            .start(sampleStep())
            .build()
    }

    @Bean
    fun sampleStep(): Step {
        return StepBuilder("sampleStep", jobRepository)
            .tasklet { _, _ ->
                throw RuntimeException("Test Exception")
                RepeatStatus.FINISHED
            }
            .transactionManager(transactionManager)
            .build()
    }
}
