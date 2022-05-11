package br.com.ilabgrupo2.desafio.controller;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.ilabgrupo2.desafio.kafka_producer.KafkaService;
import br.com.ilabgrupo2.desafio.servicies.IDisplayContent;
import br.com.ilabgrupo2.desafio.servicies.IRedisService;
import br.com.ilabgrupo2.desafio.utils.S3Util;

@Controller
public class HelloController {
	
	@Autowired
	private IDisplayContent displayContent;
    @Autowired
    IRedisService redisService; 

    @GetMapping("/")
    public String viewHomePage() {

        System.out.print(" Entrou na controller \n \n"); 
        Set<String> clients = redisService.getClients();
        System.out.print("Lista de clientes: " + clients + "\n \n"); 
      return "home";
    }

    @GetMapping("/clients")
    public String viewClients(Model model) {
        Set<String> clients = redisService.getClients();
        
        model.addAttribute("clients", clients);
      return "clients";
    }


    @PostMapping("/upload")
    public String handleUploadForm(Model model, String description,
            @RequestParam("file") MultipartFile multipart) throws IOException, InterruptedException, ExecutionException {

        String fileName = multipart.getOriginalFilename();

        String message = "";
        String stringEntries = "";


        try {
            S3Util.uploadFile(fileName, multipart.getInputStream());
            stringEntries = displayContent.convertProductListToString();

            message = "Upload realizado com sucesso!";
            
            System.out.println("Enviando mensagem para servidor kafka...");
            KafkaService.sendMessage("Nova lista de produtos: ", fileName);

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            message = "Erro ao fazer upload: " + ex.getMessage();
        }       

        model.addAttribute("message", message);
        model.addAttribute("readedCsvHeader", stringEntries);

        return "message";
    }
}
