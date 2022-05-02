package br.com.ilabgrupo2.desafio.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.ilabgrupo2.desafio.kafka_producer.KafkaService;
import br.com.ilabgrupo2.desafio.utils.S3Util;

@Controller
public class HelloController {
	@GetMapping("/")
    public String viewHomePage() {
        return "home";
    }
	
     
    @PostMapping("/upload")
    public String handleUploadForm(Model model, String description,
            @RequestParam("file") MultipartFile multipart) {
        String fileName = multipart.getOriginalFilename();
         
        System.out.println("Description: " + description);
        System.out.println("filename: " + fileName);
         
        String message = "";
         
        try {
            S3Util.uploadFile(fileName, multipart.getInputStream());
            message = "Your file has been uploaded successfully!";
            System.out.println("Enviando mensagem ...");
            KafkaService.sendMessage("JEAN-" + UUID.randomUUID().toString(), "8");
        } catch (Exception ex) {
            message = "Error uploading file: " + ex.getMessage();
        }
         
        model.addAttribute("message", message);
         
        return "message";              
    }
}


