package br.com.ilabgrupo2.desafio.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
<<<<<<< HEAD

    @PostMapping("/upload")
    public String handleUploadForm(Model model, String description,
        @RequestParam("file") MultipartFile multipart) throws IOException, InterruptedException, ExecutionException {
        String fileName = multipart.getOriginalFilename();

=======
	
    @PostMapping("/upload")
    public String handleUploadForm(Model model, String description,
            @RequestParam("file") MultipartFile multipart) throws IOException, InterruptedException, ExecutionException {

        String fileName = multipart.getOriginalFilename();
                
>>>>>>> 2810e74145563bd4783e6a9bd11eff72789838bc
        BufferedReader br;
        List<String> result = new ArrayList<>();
        String message = "";
        String teste = "";

        try {
            String line;
            InputStream is = multipart.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                String entryLine = "<p>" + line + "</p>";
                result.add(entryLine);
            }

            teste = result.toString().substring(1, result.toString().length()-1).replace(",", "").replace(";",  " | ");

            S3Util.uploadFile(fileName, multipart.getInputStream());

            System.out.println("Enviando mensagem para servidor kafka...");
<<<<<<< HEAD

=======
>>>>>>> 2810e74145563bd4783e6a9bd11eff72789838bc
            KafkaService.sendMessage("Nova lista de produtos: ", fileName);

            message = "Upload realizado com sucesso!";

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            message = "Erro ao fazer upload: " + ex.getMessage();
        }       

        model.addAttribute("message", message);
        model.addAttribute("readedCsvHeader", teste);

        return "message";
    }
}
