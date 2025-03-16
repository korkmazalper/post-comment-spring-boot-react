# post-comment-spring-boot-react

The Original Project is coded by Dilruba Köse

# User Posts and Comments project - Spring Boot - React

# Entity Relation Diagramm(Template at the beginning)

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


