package com.project.web.store.controller;


import com.project.web.store.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.project.web.store.services.UserServiceImp;

@Controller
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping("/home")
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("home-page");
        return mav;
    }

    @GetMapping(value = "/user/all")
    public ModelAndView getAllUsers(User user) {
        ModelAndView mav = new ModelAndView("user-list");
        mav.addObject("users", userServiceImp.getAllUsers());
        mav.addObject("userId", user.getId());
        return mav;
    }

    @GetMapping("/user/{id}")
    public ModelAndView getById(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("user-page");
        mav.addObject("user", userServiceImp.getBy(id));
        return mav;
    }

    @GetMapping("/user/add")
    public ModelAndView createUserForm(Model model) {
        ModelAndView mav = new ModelAndView("user-add");
        model.addAttribute("user", new User());
        return mav;
    }

    @PostMapping("/user/add")
    public ModelAndView createUser(@ModelAttribute User user) {
        ModelAndView mav = new ModelAndView("user-add");
        mav.addObject("user", userServiceImp.createUser(user));
        mav.setViewName("redirect:/user/all");
        return mav;
    }

    @GetMapping("/user/edit/{id}")
    public ModelAndView updateUserForm(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("user-edit");
        mav.addObject("user", userServiceImp.getBy(id));
        return mav;
    }

    @PatchMapping(value = "user/edit/{id}")
    public ModelAndView updateUser(@PathVariable("id") Long id, @ModelAttribute User user) {
        ModelAndView mav = new ModelAndView("user-edit");
        userServiceImp.updateUser(id, user);
        mav.setViewName("redirect:/user/all");
        return mav;
    }

    @GetMapping("/user/delete/{id}")
    public ModelAndView deleteUserForm(@PathVariable("id") Long id){
        ModelAndView mav =new ModelAndView("user-delete");
        mav.addObject("user",userServiceImp.getBy(id));
        return  mav;
    }
    @DeleteMapping(value = "/user/delete/{id}")
    ModelAndView deleteUser(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("user-delete");
        userServiceImp.deleteUser(id);
        mav.setViewName("redirect:/user/all");
        return mav;
    }
}
