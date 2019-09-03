package com.dawntechbd.FileUpload.controller;

import com.dawntechbd.FileUpload.entity.Student;
import com.dawntechbd.FileUpload.repo.StudentRepo;
import com.dawntechbd.FileUpload.util.ImageOptimizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class StudentController {
    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";

    @Autowired
    private StudentRepo repo;
//    @Autowired
//    private ImageOptimizer imageOptimizer;

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws IOException {
        ModelAndView home = new ModelAndView();
        home.addObject("list", repo.findAll());
        home.addObject("student", new Student());
        home.setViewName("index");
        return home;
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes, Student student, BindingResult Result) throws IOException {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");

            return "redirect:/";
        }

        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            student.setFilePath("/images/" + file.getOriginalFilename());
            repo.save(student);
            System.out.println("=============== save success ============");
            redirectAttributes.addFlashAttribute("message",
                    "You've successfully uploaded '" + file.getOriginalFilename()+"'");
            //            // Get the file and save it somewhere

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "result";
    }

}
