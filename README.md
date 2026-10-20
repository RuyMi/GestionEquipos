# ruymiau

This project was created using the [Ktor Project Generator](https://start.ktor.io).

Here are some useful links to get you started:
 * [Ktor Documentation](https://ktor.io/docs/home.html)
 * [Ktor GitHub page](https://github.com/ktorio/ktor)
 * [Ktor Slack chat](https://app.slack.com/client/T09229ZC6/C0A974TJ9). [Request an invite](https://surveys.jetbrains.com/s3/kotlin-slack-sign-up).


## Features
Here's a list of features included in this project:

| Name | Description |
|------|-------------|
| [Content Negotiation](https://start.ktor.io/p/io.ktor/server-content-negotiation) | Provides automatic content conversion according to Content-Type and Accept headers |
| [kotlinx.serialization](https://start.ktor.io/p/io.ktor/server-kotlinx-serialization) | Handles JSON serialization using kotlinx.serialization library |
| [Authentication](https://start.ktor.io/p/io.ktor/server-auth) | Provides extension point for handling the Authorization header |
| [Simple Cache](https://start.ktor.io/p/com.ucasoft/server-simple-cache) | Provides API for cache management |
| [Exposed](https://start.ktor.io/p/org.jetbrains/server-exposed) | Adds Exposed database to your application |
| [Koin](https://start.ktor.io/p/io.insert-koin/server-koin) | Provides dependency injection |
| [Call Logging](https://start.ktor.io/p/io.ktor/server-call-logging) | Logs client requests |
| [Status Pages](https://start.ktor.io/p/io.ktor/server-status-pages) | Provides exception handling for routes |
| [Static Content](https://start.ktor.io/p/io.ktor/server-static-content) | Serves static files from defined locations |
| [Authentication Basic](https://start.ktor.io/p/io.ktor/server-auth-basic) | Handles 'Basic' username / password authentication scheme |
| [Swagger](https://start.ktor.io/p/io.ktor/server-swagger) | Serves Swagger UI for your project |
| [Simple Memory Cache](https://start.ktor.io/p/com.ucasoft/server-simple-memory-cache) | Provides memory cache for Simple Cache plugin |
| [Compression](https://start.ktor.io/p/io.ktor/server-compression) | Compresses responses using encoding algorithms like GZIP |
| [CORS](https://start.ktor.io/p/io.ktor/server-cors) | Enables Cross-Origin Resource Sharing (CORS) |


## Building & Running
To build or run the project, use one of the following tasks:


| Task | Description |
|------|-------------|
| `./gradlew test`    | Run the tests     |
| `./gradlew build`   | Build the project |
| `./gradlew run`     | Run the server    |

If the server starts successfully, you'll see the following output:
```
2024-12-04 14:32:45.584 [main] INFO  Application - Application started in 0.303 seconds.
2024-12-04 14:32:45.682 [main] INFO  Application - Responding at http://0.0.0.0:8080
```
