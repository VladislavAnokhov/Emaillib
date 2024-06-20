package com.example.Emaillib

import org.springframework.batch.core.Job
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class EmailLibApplication{
	@Bean
	fun run(jobLauncher: JobLauncher, @Qualifier("sampleJob") job: Job): CommandLineRunner {
		return CommandLineRunner {
			val jobParameters = org.springframework.batch.core.JobParametersBuilder()
				.addString("JobID", System.currentTimeMillis().toString())
				.toJobParameters()
			jobLauncher.run(job, jobParameters)
		}
	}
}

fun main(args: Array<String>) {
	runApplication<EmailLibApplication>(*args)
}
