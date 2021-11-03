package com.example.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ElectronicsServlet {
    static public ArrayList<Electronic> electronics = new ArrayList<Electronic>() {
        {
            add(new Electronic("misha", "alexander", 777.0));
            add(new Electronic("serega", "evgen", 666.0));
            add(new Electronic("alesha", "ilya", 33.0));
            add(new Electronic("misha", "kostya", 123.0));
        }
    };
    @GetMapping("/")
    public String homeGet(Model model) {
        model.addAttribute("electronics", electronics);
        return "TableView";
    }

    @GetMapping("/add")
    public String addGet() {
        return "Add";
    }

    @PostMapping("/add")
    public String addPost(@RequestParam String nameModel, @RequestParam String nameCompany, @RequestParam Double cost) {
        electronics.add(new Electronic(nameModel, nameCompany, cost));
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editGet(@PathVariable(value = "id") int id, Model model) {
        Electronic electronic = electronics.get(id);
        model.addAttribute("electronic", electronic);
        return "Edit";
    }

    @PostMapping("/{id}/edit")
    public String addPost(@PathVariable(value = "id") int id, @RequestParam String nameModel, @RequestParam String nameCompany, @RequestParam Double cost) {
        electronics.set(id, new Electronic(nameModel, nameCompany, cost));
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteGet(@PathVariable(value = "id") int id, Model model) {
        Electronic electronic = electronics.get(id);
        model.addAttribute("electronic", electronic);
        model.addAttribute("id", id);
        return "Delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteGet(@PathVariable(value = "id") int id) {
        electronics.remove(id);
        return "redirect:/";
    }
}
