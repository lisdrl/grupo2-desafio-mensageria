package br.com.ilabgrupo2.desafio.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.ilabgrupo2.desafio.kafka_producer.KafkaService;
import br.com.ilabgrupo2.desafio.model.Produto;
import br.com.ilabgrupo2.desafio.servicies.LoadDataService;
import br.com.ilabgrupo2.desafio.utils.S3Util;

@Controller
public class HelloController {
	
	@Autowired
	private LoadDataService loadDataService;
	
	
    @GetMapping("/")
    public String viewHomePage() {
        return "home";
    }
	
    @PostMapping("/upload")
    public String handleUploadForm(Model model, String description,
            @RequestParam("file") MultipartFile multipart) throws IOException, InterruptedException, ExecutionException {

        String fileName = multipart.getOriginalFilename();

        List<String> result = new ArrayList<>();
        String message = "";
        String entries = "";
        String stringEntries = "";

        try {
            S3Util.uploadFile(fileName, multipart.getInputStream());
            
            List<Produto> pList = loadDataService.findAllProducts();
            entries = "<p>" + "Nome" + " | " + "descrição" + " | " + "qtd" + " | " + "preço" + "<p>";
            result.add(entries);
            
            for (Produto p : pList) {
            	String name = p.getNome();
            	String desc = p.getDescricao();
            	String qtd  = p.getDescricao();
            	Double price = p.getPrice();
            	
            	entries = "<p>" + name + " | " + desc + " | " + qtd + " | " + price + "<p>";
            	result.add(entries);
            }
            
            stringEntries = result.toString().replace("[", "").replace("]", "").replace(",", "");

            System.out.println("Enviando mensagem para servidor kafka...");

            KafkaService.sendMessage("Nova lista de produtos: ", fileName);

            message = "Upload realizado com sucesso!";

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            message = "Erro ao fazer upload: " + ex.getMessage();
        }       

        model.addAttribute("message", message);
        model.addAttribute("readedCsvHeader", stringEntries);

        return "message";
    }
}
