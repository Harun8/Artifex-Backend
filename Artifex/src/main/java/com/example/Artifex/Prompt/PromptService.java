package com.example.Artifex.Prompt;

import com.example.Artifex.LLM.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // making it a bean aka saying that it is a class that needs to be instantiated
public class PromptService {



    @Autowired
    private final OpenAiService openAiService;
    public PromptService(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }
    public static List<String> generateImg(Prompt prompt) {

        // call the correct model for know only dall-e
        return OpenAiService.fetchImage(prompt);




    }
}
