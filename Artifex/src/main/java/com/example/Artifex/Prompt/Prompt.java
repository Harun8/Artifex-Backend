package com.example.Artifex.Prompt;

public class Prompt {

    private String model;
    private String prompt;
    private int nImages;
    private String imgSize;

    public Prompt(String model, String prompt, int nImages, String imgSize) {
        this.model = model;
        this.prompt = prompt;
        this.nImages = nImages;
        this.imgSize = imgSize;

    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getnImages() {
        return nImages;
    }

    public void setnImages(int nImages) {
        this.nImages = nImages;
    }

    public String getImgSize() {
        return imgSize;
    }

    public void setImgSize(String imgSize) {
        this.imgSize = imgSize;
    }
}
