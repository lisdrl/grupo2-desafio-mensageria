package br.com.ilabgrupo2.desafio.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Controller
public class UploadController {

    private static final String BUCKET = "grupo2-bucket";
     
    public static void uploadFile(String fileName, InputStream inputStream) throws S3Exception, AwsServiceException, SdkClientException, IOException {
        
    	S3Client client = S3Client.builder().build();
         
        PutObjectRequest request = PutObjectRequest.builder()
                            .bucket(BUCKET)
                            .key(fileName)
                            .build();
         
        client.putObject(request,
                RequestBody.fromInputStream(inputStream, inputStream.available()));
    }
}

