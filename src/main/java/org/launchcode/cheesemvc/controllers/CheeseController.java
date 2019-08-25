package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    private static ArrayList<Cheese> cheeses = new ArrayList<>();

    // Request path: /cheese
    @RequestMapping(value="")
    public String index(Model model){

        model.addAttribute("title", "My Cheeses");
        model.addAttribute("cheeses", cheeses);
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String aName, @RequestParam String aDescription){
        Cheese cheese = new Cheese(aName, aDescription);
        cheeses.add(cheese);

        //redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String displayDeleteCheeseForm(Model model){
        return "cheese/delete";
    }

    @RequestMapping(value="delete", method = RequestMethod.POST)
    public String processDeleteCheeseForm(Model model, @RequestParam Cheese cheese){
        model.addAttribute("deleteForm", cheese);

        model.addAttribute("cheeses", cheese);
        cheeses.remove(cheese);

        //redirect to /cheese
        return "redirect: /cheese";
    }

}
