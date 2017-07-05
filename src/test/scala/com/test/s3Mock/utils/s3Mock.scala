package com.test.s3Mock.utils

import io.findify.s3mock.S3Mock
import com.amazonaws.auth.{AWSStaticCredentialsProvider, AnonymousAWSCredentials}
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.services.s3.{AmazonS3, AmazonS3Builder, AmazonS3ClientBuilder}
import com.amazonaws.services.s3.transfer.TransferManagerBuilder

    
object s3Mock {
  new S3Mock.Builder().withPort(8001).withInMemoryBackend().build().start

  val endpoint = new EndpointConfiguration("http://localhost:8001", "us-east-1")
  val client = AmazonS3ClientBuilder
    .standard()
    .withPathStyleAccessEnabled(true)  
    .withEndpointConfiguration(endpoint)
    .withCredentials(new AWSStaticCredentialsProvider(new AnonymousAWSCredentials()))     
    .build()

  val txManager = TransferManagerBuilder
    .standard()
    .withS3Client(client)
    .build()
}