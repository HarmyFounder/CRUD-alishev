package ru.harmyOwner.psd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.harmyOwner.psd.dao.PostsDAO;
import ru.harmyOwner.psd.models.Post;

@Controller
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    PostsDAO postsDAO;

    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("posts",postsDAO.all());
        return "all";
    }

    @GetMapping("/{id}")
    public String certain(@PathVariable("id")int id,Model model){
        model.addAttribute("post",postsDAO.certain(id));
        return "certain";
    }

    @GetMapping("/new")
    public String newPost(Model model){
        model.addAttribute("post",new Post());
        return "new";
    }


    @PostMapping()
    public String save(@ModelAttribute("post")Post post){
        postsDAO.save(post);
        return "redirect:/posts/all";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id")int id){
        model.addAttribute("post",postsDAO.certain(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("post")Post post,@PathVariable("id")int id){
        postsDAO.update(id,post);
        return "redirect:/posts/all";
    }


    @DeleteMapping ("/{id}")
    public String delete(@ModelAttribute("post")Post post,@PathVariable("id")int id){
        postsDAO.delete(id);
        return "redirect:/posts/all";
    }


}
