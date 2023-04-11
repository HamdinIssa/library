package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.library.entity.Book;
import com.example.library.entity.Images;
import com.example.library.repository.UploadRepository;
import com.example.library.service.BookService;

import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/books")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookController {
   


  
    final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String listBooks(Model theModel) {
        // get book from db
        List<Book> theBooks = bookService.findAll();
        // add to the spring model
        theModel.addAttribute("books", theBooks);
        return "list-books";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        Book theBook = new Book();
        theModel.addAttribute("books", theBook);
        return "book-form";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int theID, Model theModel) {
        //get the book from the service
        Book theBook = bookService.findById(theID);
        //set book as a model attribute to pre-populate the form
        theModel.addAttribute("books", theBook);
        return "book-form";
    }
    @PostMapping("/save")
    public String saveBook(Model model,@ModelAttribute("books") Book theBook) {
        // save the book
        model.addAttribute("books", theBook);

        bookService.save(theBook);
        // use a redirect to prevent duplicate submissions
        return "redirect:/books/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int theId) {
        // delete the book
        bookService.deleteById(theId);
        return "redirect:/books/list";
    }

    @GetMapping("/search")
    public String findBookByName(Model model, @Param("keyword") String keyword){
        model.addAttribute("books", bookService.findBookByName(keyword));
        return "list-books";
    }
    @Autowired
	public UploadRepository uploadRepo;
    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/imageUpload")
	public String imageUpload(@RequestParam MultipartFile img, HttpSession session) {

		Images im = new Images();
		im.setImageName(img.getOriginalFilename());

        Images uploadImg = uploadRepo.save(img);

		

		if (uploadImg != null) {
			try {

				File saveFile = new ClassPathResource("static/img").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
				//System.out.println(path);
				Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        System.out.println(img.getOriginalFilename()
        );
		session.setAttribute("msg", "Image Upload Sucessfully");

		return "#";
	}
  
}
