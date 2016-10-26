package com.sarada.learn.TestAWSS3;

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class RetrieveObjects {

	private static final String BUCKET_NAME ="saradashare";
	
	public static void main(String[] args) {
		AmazonS3 s3client = new AmazonS3Client(new EnvironmentVariableCredentialsProvider());        

		ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
		    .withBucketName(BUCKET_NAME);
		ObjectListing objectListing;

		do {
		        objectListing = s3client.listObjects(listObjectsRequest);
		        for (S3ObjectSummary objectSummary : 
		            objectListing.getObjectSummaries()) {
		            System.out.println( " - " + objectSummary.getKey() + "  " +
		                    "(size = " + objectSummary.getSize() + 
		                    ")");
		        }
		        listObjectsRequest.setMarker(objectListing.getNextMarker());
		} while (objectListing.isTruncated());
	}
}
