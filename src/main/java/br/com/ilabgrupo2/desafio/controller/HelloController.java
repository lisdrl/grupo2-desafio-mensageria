package br.com.ilabgrupo2.desafio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/")
    public String viewHomePage() {
        return "home";
    }
	
     
//    @PostMapping("/upload")
//    public String handleUploadForm(Model model, String description,
//            @RequestParam("file") MultipartFile multipart) {
//        String fileName = multipart.getOriginalFilename();
//         
//        System.out.println("Description: " + description);
//        System.out.println("filename: " + fileName);
//         
//        String message = "";
//         
//        try {
//            UploadController.uploadFile(fileName, multipart.getInputStream());
//            message = "Your file has been uploaded successfully!";
//        } catch (Exception ex) {
//            message = "Error uploading file: " + ex.getMessage();
//        }
//         
//        model.addAttribute("message", message);
//         
//        return "message";              
//    }
}


