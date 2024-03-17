package com.example.validatesong.controller;

import com.example.validatesong.model.Song;
import com.example.validatesong.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("song",new Song());
        return "/create";
    }
    @GetMapping("/list")
    public String listAll(){
        return "/list";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute Song song, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/create";
        }
        iSongService.save(song);
        return "redirect:/song/list";
    }
}
