package com.example.appbook.controller;

import com.example.appbook.model.Book;
import com.example.appbook.model.Borrow;
import com.example.appbook.model.User;
import com.example.appbook.service.IBookService;
import com.example.appbook.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("books")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowService iBorrowService;
    @GetMapping("")
    public String showListBook(Model model){
        List<Book> bookList = iBookService.findAll();
        model.addAttribute("bookList",bookList);
        return "/home";
    }
    @GetMapping("/result")
    public String showResult(){
        return "/result";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("book",new Book());
        return "/create";
    }
    @GetMapping("/{id}/detail")
    public String showDetail(@PathVariable Long id, Model model){
        Book book = iBookService.findById(id);
//        Borrow borrow = new Borrow();
        model.addAttribute("book", book);
//        model.addAttribute("borrow",borrow);
        return "/detail";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Book book){
        iBookService.save(book);
        return "redirect:/books";
    }
    @PostMapping("/borrow")
    public String borrow(@RequestParam("bookId") Long id, @RequestParam("userName") String userName, RedirectAttributes redirect){
        Book book = iBookService.findById(id);
        book.setQuantity(book.getQuantity()-1);

        User user = new User();
        user.setName(userName);
        LocalDate borrowDate = LocalDate.now();
        Integer code_borrow = new Random().nextInt(90000) + 10000;
        Borrow borrow = new Borrow(code_borrow,book,user,borrowDate);
        iBorrowService.save(borrow);

        redirect.addFlashAttribute("message",code_borrow);
        return "redirect:/books/result";
    }
    @GetMapping("/return")
    public String showReturn(){
        return "/return";
    }
    @PostMapping("/return")
    public String returnBook( @RequestParam("code_borrow") Integer code_borrow,Model model,RedirectAttributes redirect){
        try {
        Borrow borrow = iBorrowService.findbyCode(code_borrow);
        Book book = iBookService.findById(borrow.getBook().getId());
        book.setQuantity(book.getQuantity()+1);
        iBookService.save(book);
        iBorrowService.delete(borrow);
        redirect.addFlashAttribute("returnBook","Bạn đã trả sách thành công!");
        }catch (Exception e){
            System.out.println("Mã trả không hợp lệ!"+e);
            model.addAttribute("mess", "Mã trả không hợp lệ!");
            return "/return";
        }
        return "redirect:/books/result";
    }

}
