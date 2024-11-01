package com.example.Artifex.Image;

import jakarta.persistence.*;

@Entity
@Table
public class Image {

    @Id
    @SequenceGenerator(
            name = "image_sequence",
            sequenceName = "image_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "image_sequence"
    )
    private long id;

    private String title;

    @Transient
    private String base64Image; // Not saved in the database

    @Lob // Large Object annotation to store binary data
    private byte[] imageData;

    public Image(byte[] imageData, String title) {
        this.imageData = imageData;
        this.title = title;
    }

    public Image() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}
