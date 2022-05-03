package br.com.ilabgrupo2.desafio.controller;

import br.com.ilabgrupo2.desafio.models.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.ilabgrupo2.desafio.utils.S3Util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
	@GetMapping("/")
    public String viewHomePage() {
        return "home";
    }
	
     
    @PostMapping("/upload")
    public String handleUploadForm(Model model, String description,
            @RequestParam("file") MultipartFile multipart) throws IOException {
        System.out.println(multipart);
        String fileName = multipart.getOriginalFilename();
//        System.out.println("filename: " + fileName);
//        System.out.println("description" + description);
        System.out.println(multipart);

        BufferedReader br;
        List<String> result = new ArrayList<>();
        try {
            String line;
            InputStream is = multipart.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                String bre = "<p>" + line + "</p>";
                result.add(bre);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(result);
        String teste = result.toString().substring(1, result.toString().length()-1).replace(",", "").replace(";",  " | ");

         
        String message = "";
        String divClass = "";
        String readedCsv = result.toString();
//        String readedCsvHeader = readedCsv.substring(0, readedCsv.lastIndexOf("data")+4);
//        String readedCsvContent = readedCsv.substring(readedCsv.lastIndexOf("data")+5, readedCsv.length()-1);
//        System.out.println(readedCsvHeader);
//        System.out.println(readedCsvContent);

        try {
            S3Util.uploadFile(fileName, multipart.getInputStream());
            message = "Upload realizado com sucesso!";
        } catch (Exception ex) {
            message = "Erro ao fazer upload: " + ex.getMessage();
        }
         
        model.addAttribute("message", message);
        model.addAttribute("readedCsvHeader", teste);
//        model.addAttribute("readedCsvContent", readedCsvContent);

//        File f = new File();
//        BufferedReader reader = new BufferedReader(multipart);
//
//        String line;
//        Produto p = null;
//        System.out.println(reader);

        return "message";
    }
}


