package br.com.ilabgrupo2.desafio.services;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

public class DownloadFile {
	
	public static void main(String[] args) throws IOException { 
	String bucketName = "grupo2-bucket";
	String keyName = "PlanilhaAleatoria.csv";
	
	AwsCredentialsProvider credentialsProvider = new AwsCredentialsProvider() {
        @Override
        public AwsCredentials resolveCredentials() {
            return new AwsCredentials() {
                @Override
                public String accessKeyId() {
                    return System.getenv("AWS_ACCESS_KEY");
                }
    
                @Override
                public String secretAccessKey() {
                    return System.getenv("AWS_SECRET_KEY");
                }
            };
        }
    };
	
	S3Client client = S3Client.builder()
				.region(Region.US_EAST_1)
				.credentialsProvider(credentialsProvider)
				.build();
	
	GetObjectRequest request = GetObjectRequest.builder()
			.bucket(bucketName)
			.key(keyName)
			.build();

	ResponseInputStream<GetObjectResponse> inputStream = client.getObject(request); 
	//Não precisa criar novo arquivo e dar um nom, q é essa linha debaixo
	BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(keyName));
	
	byte[] buffer = new byte[4096];
	int bytesRead = -1; 
	
	while ((bytesRead = inputStream.read(buffer)) != -1) { 
		outputStream.write(buffer, 0, bytesRead);
	}
	
	inputStream.close();
	outputStream.close();
	}
}
