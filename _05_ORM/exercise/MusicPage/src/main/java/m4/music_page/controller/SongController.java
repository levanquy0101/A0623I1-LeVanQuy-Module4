package m4.music_page.controller;

import m4.music_page.model.Song;
import m4.music_page.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping
    public ModelAndView list() {
        List<Song> songs = songService.findAll();
        return new ModelAndView("list", "res", songs);
    }

    @GetMapping(value ={"form","form/{id}"})
    public String viewForm(Model model, @PathVariable(required = false) Long id){
        if(null != id){
            Optional<Song> opSong = songService.findById(id);
            opSong.ifPresent(song -> model.addAttribute("song", song));
        }
        else{
            model.addAttribute("song", new Song());
        }

        return "form";
    }

    @PostMapping
    public String save(Song song){
        songService.save(song);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        songService.delete(id);
        return "redirect:/";
    }


    @GetMapping("file/{code}")
    public ResponseEntity<Resource> playMp3(HttpServletRequest request, @PathVariable String code) {
        return songService.downloadFile(request.getServletContext(), code);
    }
}
