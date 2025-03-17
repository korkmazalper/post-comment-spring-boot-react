# post-comment-spring-boot-react

The Original Project is coded by Dilruba Köse

# User Posts and Comments project - Spring Boot - React

## Tech-Stack

- SpringBoot 3.4.3
- Mysql 8.4.4-1.el9 (Docker)
- React 19.0.0

# Entity Relation Diagramm(Draft at the beginning, can be improved)

````mermaid
erDiagram
    USERS ||--o{ POSTS: creates
    USERS ||--o{ COMMENTS: writes
    USERS ||--o{ LIKES: leaves
    POSTS ||--o{ COMMENTS: has
    POSTS ||--o{ LIKES: receives
    COMMENTS ||--o{ LIKES: receives

    USERS {
        int id PK
        string username
        string password
    }

    POSTS {
        int id PK
        int userId FK
        string title
        string text
    }

    COMMENTS {
        int id PK
        int userId FK
        int postId FK
        string text
    }

    LIKES {
        int id PK
        int userId FK
        int postId FK
    }

````

- Class Diagramm (Draft)

````mermaid
classDiagram
    direction TB
    class Comment {
        - User user
        - Post post
        - String text
        - Long id
        - LocalDateTime createdAt
        - LocalDateTime updatedAt
    }
    class CommentController {
        - CommentService commentService
    }
    class CommentCreateRequest {
        - Long postId
        - String text
        - Long userId
        - Long id
    }
    class CommentService {
        - CommentRepository commentRepository
        - UserService userService
        - PostService postService
    }
    class CommentUpdateRequest {
        - String text
    }
    class Like {
        - Long id
        - Post post
        - User user
    }
    class Post {
        - Long id
        - LocalDateTime updatedAt
        - LocalDateTime createdAt
        - String title
        - User user
        - String text
    }
    class PostController {
        - PostService postService
    }
    class PostCreateRequest {
        - Long userId
        - Long id
        - String text
        - String title
    }
    class PostService {
        - PostRepository postRepository
        - UserService userService
    }
    class PostUpdateRequest {
        - String title
        - String text
    }
    class User {
        - String userName
        - Long id
        - String password
    }
    class UserService {
        - UserRepository userRepository
    }

    Comment "1" *--> "post 1" Post
    Comment "1" *--> "user 1" User
    CommentController "1" *--> "commentService 1" CommentService
    CommentService "1" *--> "postService 1" PostService
    CommentService "1" *--> "userService 1" UserService
    Like "1" *--> "post 1" Post
    Like "1" *--> "user 1" User
    Post "1" *--> "user 1" User
    PostController "1" *--> "postService 1" PostService
    PostService "1" *--> "userService 1" UserService

````


