# HYSocialMedia

HYSocialMedia is a social media application built with Spring Boot and Maven. It provides functionalities for user registration, login, posting messages, and more.

## Prerequisites

- Java 17
- Maven 3.6+
- Docker (optional, for containerization)

## Getting Started

### Clone the repository

```sh
git clone https://github.com/hank-1017/HYSocialMedia.git
cd HYSocialMedia
```

### Build the project

```sh
mvn clean package
```

### Run the application

```sh
java -jar target/HYSocialMedia_back-0.0.1.jar
```

The application will start on port 8080 by default.

## Docker

### Build Docker image

```sh
docker build -t hysocialmedia_back .
```

### Run Docker container

```sh
docker run -d -p 8080:8080 --name hysocialmedia_back_container hysocialmedia_back
```

### Stop Docker container

```sh
docker stop hysocialmedia_back_container
docker rm hysocialmedia_back_container
```

## API Endpoints

### User Controller

- `POST /user/register` - Register a new user
- `POST /user/login` - User login
- `GET /user/getLoginUser` - Get the currently logged-in user
- `GET /user/logout` - Logout the current user

### Post Controller

- `GET /post/lastest` - Get the latest post
- `POST /post/new` - Create a new post
- `GET /post/show` - Show all posts
- `DELETE /post/delete/{id}` - Delete a post by ID
- `GET /post/edit` - Get a post by ID for editing
- `PUT /post/edit` - Update a post



