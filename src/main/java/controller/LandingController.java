package com.example.landing.controller;


import com.example.landing.dto.SubscriberForm;
import com.example.landing.entity.Subscriber;
import com.example.landing.repository.SubscriberRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LandingController {


private final SubscriberRepository subscriberRepository;


public LandingController(SubscriberRepository subscriberRepository) {
this.subscriberRepository = subscriberRepository;
}


@GetMapping("/")
public String index(Model model) {
if (!model.containsAttribute("subscriberForm")) {
model.addAttribute("subscriberForm", new SubscriberForm());
}
return "index";
}


@PostMapping("/subscribe")
public String subscribe(@ModelAttribute("subscriberForm") @Valid SubscriberForm form,
BindingResult bindingResult,
RedirectAttributes redirectAttributes) {


if (bindingResult.hasErrors()) {
return "index";
}


if (subscriberRepository.existsByEmail(form.getEmail())) {
bindingResult.rejectValue("email", "error.email", "This email is already subscribed.");
return "index";
}


Subscriber s = new Subscriber(form.getEmail());
subscriberRepository.save(s);


redirectAttributes.addFlashAttribute("email", form.getEmail());
return "redirect:/success";
}


@GetMapping("/success")
public String success() {
return "success";
}
}