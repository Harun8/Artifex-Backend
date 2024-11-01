package com.example.Artifex.LLM;

import com.example.Artifex.ConfigLoader;
import com.example.Artifex.Image.Image;
import com.example.Artifex.Image.ImageRepository;
import com.example.Artifex.Prompt.Prompt;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Service
public class OpenAiService {


    private static ImageRepository imageRepository;

    @Autowired
    public OpenAiService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }



    public static List<String> fetchImage(Prompt prompt) {
        ConfigLoader configLoader = new ConfigLoader();
        String apiKey = configLoader.getApiKey();
        String endpoint = "https://api.openai.com/v1/images/generations";
        String payload = String.format( "{"
                + "\"prompt\": \"%s\","
                + "\"n\": 4,"
                + "\"size\": \"1024x1024\""
                + "}", prompt.getPrompt() );

        List<String> errorList = new ArrayList<>();

        try {
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = payload.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int statusCode = conn.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_OK) {
                // Read the response body
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line.trim());
                    }

                    // Parse JSON response to get the image URL
                    JSONObject jsonResponse = new JSONObject(response.toString());
                    JSONArray dataArray = jsonResponse.getJSONArray("data");
                    List<String> imageUrls = new ArrayList<>();
                    String imageUrl = "";
                    for (int i = 0; i < dataArray.length(); i++) {
                        imageUrl = dataArray.getJSONObject(i).getString("url");
                        imageUrls.add(imageUrl);
                        //System.out.println("Image URL " + (i + 1) + ": " + imageUrl);  // Log each URL
                    }

                    //downloadImage(imageUrl, "generated_image.png");


                    byte[] imageBuffer = downloadImageAsBuffer(imageUrl);




                    // Create and save Image object
                    Image image = new Image(imageBuffer, prompt.getPrompt());
                    imageRepository.save(image); // Save each image buffer
                    return imageUrls;

                }
            } else {
                System.out.println("Request failed with status code: " + statusCode);
            }
            conn.disconnect();
        } catch (Exception e) {
            return errorList;
        }
        return errorList;
    }

    private static byte[] downloadImageAsBuffer(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (InputStream inputStream = connection.getInputStream()) {
            return inputStream.readAllBytes(); // Reads all bytes as buffer
        }
    }


}
