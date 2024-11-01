package com.example.Artifex.Prompt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/prompt")
public class PromptController {

    private final PromptService promptService;

    @Autowired // will make promptService instantiated for us
    public PromptController(PromptService promptService) {
        this.promptService = promptService;
    }

    @GetMapping
    public String message(){
        return "API is up and running";
    }

    @PostMapping
    public List<String> getImage(@RequestBody Prompt prompt) {
         return PromptService.generateImg(prompt);
    }


    // post req for generating image


}
