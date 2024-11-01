package com.example.Artifex.Prompt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/prompt")
public class PromptController {

    private final PromptService promptService;

    @Autowired // will make promptService instantiated for us
    public PromptController(PromptService promptService) {
        this.promptService = promptService;
    }


    @PostMapping
    public List<String> getImage(@RequestBody Prompt prompt) {
         return PromptService.generateImg(prompt);
    }


    // post req for generating image


}
