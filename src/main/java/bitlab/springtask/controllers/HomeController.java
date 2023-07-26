package bitlab.springtask.controllers;

import bitlab.springtask.DBManager;
import bitlab.springtask.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("items", DBManager.getItems());
        return "home";
    }
    @PostMapping("/add-item")
    public String add(Item item){
    DBManager.addItem(item);
    return "redirect:/";
    }
    @GetMapping("/details"+"/"+"{id}")
    public String itemDetails(@PathVariable Long id,
                              Model model){
    Item item=DBManager.getItemById(id);
    model.addAttribute("zat",item);
    return "details";
    }
    @PostMapping("/edit-item/{id}")
    public String edit( @PathVariable Long id,
        @RequestParam(name="name") String name,
                        @RequestParam(name = "description") String description,
                        @RequestParam(name = "price") double price,
                        @RequestParam(name="category") String category) {
        Item i = DBManager.getItemById(id);
        i.setName(name);
        i.setPrice(price);
        i.setDescription(description);
        i.setCategory(category);
        return "redirect:/details/"+id;
    }
    @PostMapping("/delete-item/{id}")
    public String delete(@PathVariable Long id) {
        DBManager.deleteItem(id);
        return "redirect:/";
    }
}
