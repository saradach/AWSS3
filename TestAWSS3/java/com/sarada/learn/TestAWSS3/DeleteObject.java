package com.sarada.learn.TestAWSS3;

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;

public class DeleteObject {

	private static final String BUCKET_NAME ="saradashare";
	private static final String KEY_NAME = "104";
	
	public static void main(String[] args) {
		AmazonS3 s3client = new AmazonS3Client(new EnvironmentVariableCredentialsProvider());
		s3client.deleteObject(new DeleteObjectRequest(BUCKET_NAME, KEY_NAME));
		System.out.println("Deleted Successfully");
	}

}
