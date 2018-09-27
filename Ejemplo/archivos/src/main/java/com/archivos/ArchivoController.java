package com.archivos;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ArchivoController {
	
	@Autowired
	private ArchivoRepository repoAr;

	@GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {
    	/*
        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));
        */
        return "uploadForm";
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes, HttpServletRequest request) throws IllegalStateException, IOException {
	    ClassPathResource res = new ClassPathResource("src/main/resources/files/"); //Esta función nos ayuda a guardar los archivos en la carpeta
	    //resource, este path lo vamos a guardar en la base de datos.
		File path = new File(res.getPath());
	    String nombre = file.getOriginalFilename();
	    if (nombre != null && nombre.length() > 0) {
	    	try {
	    		File salvarArchivo = new File(path.getAbsolutePath() + File.separator + nombre);
	    		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(salvarArchivo));
	    		stream.write(file.getBytes());
	    		stream.close();
			} catch (Exception e) {
				System.out.println("ERROR");
			}
	    }
	    ArchivoModel archivo = new ArchivoModel(nombre,res.getPath()+nombre);
	    repoAr.save(archivo);
        return "redirect:/";
    }

}
