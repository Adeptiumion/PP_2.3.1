package pp_2_3_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pp_2_3_1.model.User;
import pp_2_3_1.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("create_user")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/create_new_user";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/users"; // Редиректим на главную.
    }

    @GetMapping("/user_by_id")
    public String userPage(@RequestParam("id") String id, Model model) {
        model.addAttribute("user_with_id", userService.readOne(Integer.parseInt(id)));
        return "users/update_user";
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.readAll());
        return "users/index";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") String id, @ModelAttribute("user_with_id")User user) {
        userService.update(Integer.parseInt(id), user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") String id){
        userService.delete(Integer.parseInt(id));
        return "redirect:/users";
    }


}
