# DALL-E Image Generation API with Spring Boot

This project is a Spring Boot application that allows users to generate images using the DALL-E model. Users can input prompts through the API, and the application will return custom-generated images based on these prompts. This repository provides a robust and scalable backend solution for integrating DALL-E's capabilities into any Java-based application.

## Features

- **User Prompted Image Generation**: Accepts user input (prompts) for image generation and returns high-quality images generated via the DALL-E model.
- **RESTful API**: Built using Spring Boot with RESTful endpoints for seamless integration and ease of use.
- **Asynchronous Requests**: Supports asynchronous request handling for enhanced performance, especially useful when dealing with complex image generation requests.
- **Error Handling & Validation**: Includes validation and error handling to ensure prompt inputs are appropriate and the system remains stable under load.
- **Scalable Architecture**: Built on a scalable architecture, making it easy to expand and integrate with other services or UI components.
- **Dockerized Setup**: Contains Docker support for easy deployment and scaling in different environments.

## Technologies

- **Java 11+**: Core programming language.
- **Spring Boot**: Application framework to provide the backend structure.
- **DALL-E Model**: Integrated with OpenAI's DALL-E API for image generation.
- **Docker**: For containerized deployments.
- **Maven**: Build automation.

## Getting Started

### Prerequisites
- Java 11+
- Docker (optional, for containerized deployment)
- DALL-E API Key (from OpenAI)

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/dalle-image-generation-spring-boot.git
   cd dalle-image-generation-spring-boot
   ```

2. **Configure API Key**:
   Set up the DALL-E API key in the application properties:
   ```properties
   openai.api.key=YOUR_API_KEY
   ```

3. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

### Docker Setup (Optional)
To run the application in Docker:
```bash
docker build -t dalle-spring-boot .
docker run -p 8080:8080 -e OPENAI_API_KEY=YOUR_API_KEY dalle-spring-boot
```

## Usage

- **Generate Image**: Send a POST request to `/api/v1/images` with a JSON payload containing the prompt:
   ```json
   {
      "prompt": "A futuristic cityscape at night with neon lights"
   }
   ```

- **Response**: The API will return an image URL or binary data depending on configuration.

## Contributing

Contributions are welcome! Please create a fork and submit a pull request with any improvements or new features.

## License

This project is licensed under the MIT License.

---

This application provides a straightforward way to generate custom images through simple prompts using DALL-E, ideal for developers looking to integrate AI-powered image generation into their Java applications.
