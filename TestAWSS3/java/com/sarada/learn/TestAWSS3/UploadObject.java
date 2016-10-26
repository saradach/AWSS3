package com.sarada.learn.TestAWSS3;

import java.io.File;

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class UploadObject {

	private static final String BUCKET_NAME ="saradashare";
	private static final String KEY_NAME = "104";
	private static final String FILE_NAME = "myson.jpg";
	
	public static void main(String[] args) {
		try {
		AmazonS3 s3client = new AmazonS3Client(new EnvironmentVariableCredentialsProvider());
		File file = new File(FILE_NAME);
		s3client.putObject(new PutObjectRequest(BUCKET_NAME, KEY_NAME, file));
		System.out.println("Uploaded Successfully");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
