# Plaza Java API Library

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/com.plazafyi/plaza-java)](https://central.sonatype.com/artifact/com.plazafyi/plaza-java/0.1.0)
[![javadoc](https://javadoc.io/badge2/com.plazafyi/plaza-java/0.1.0/javadoc.svg)](https://javadoc.io/doc/com.plazafyi/plaza-java/0.1.0)

<!-- x-release-please-end -->

The Plaza Java SDK provides convenient access to the [Plaza REST API](https://docs.plaza.fyi) from applications written in Java.

The Plaza Java SDK is similar to the Plaza Kotlin SDK but with minor differences that make it more ergonomic for use in Java, such as `Optional` instead of nullable values, `Stream` instead of `Sequence`, and `CompletableFuture` instead of suspend functions.

It is generated with [Stainless](https://www.stainless.com/).

## MCP Server

Use the Plaza MCP Server to enable AI assistants to interact with this API, allowing them to explore endpoints, make test requests, and use documentation to help integrate this SDK into your application.

[![Add to Cursor](https://cursor.com/deeplink/mcp-install-dark.svg)](https://cursor.com/en-US/install-mcp?name=%40plazafyi%2Fmcp&config=eyJjb21tYW5kIjoibnB4IiwiYXJncyI6WyIteSIsIkBwbGF6YWZ5aS9tY3AiXSwiZW52Ijp7IlBMQVpBX0FQSV9LRVkiOiJNeSBBUEkgS2V5In19)
[![Install in VS Code](https://img.shields.io/badge/_-Add_to_VS_Code-blue?style=for-the-badge&logo=data:image/svg%2bxml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIGZpbGw9Im5vbmUiIHZpZXdCb3g9IjAgMCA0MCA0MCI+PHBhdGggZmlsbD0iI0VFRSIgZmlsbC1ydWxlPSJldmVub2RkIiBkPSJNMzAuMjM1IDM5Ljg4NGEyLjQ5MSAyLjQ5MSAwIDAgMS0xLjc4MS0uNzNMMTIuNyAyNC43OGwtMy40NiAyLjYyNC0zLjQwNiAyLjU4MmExLjY2NSAxLjY2NSAwIDAgMS0xLjA4Mi4zMzggMS42NjQgMS42NjQgMCAwIDEtMS4wNDYtLjQzMWwtMi4yLTJhMS42NjYgMS42NjYgMCAwIDEgMC0yLjQ2M0w3LjQ1OCAyMCA0LjY3IDE3LjQ1MyAxLjUwNyAxNC41N2ExLjY2NSAxLjY2NSAwIDAgMSAwLTIuNDYzbDIuMi0yYTEuNjY1IDEuNjY1IDAgMCAxIDIuMTMtLjA5N2w2Ljg2MyA1LjIwOUwyOC40NTIuODQ0YTIuNDg4IDIuNDg4IDAgMCAxIDEuODQxLS43MjljLjM1MS4wMDkuNjk5LjA5MSAxLjAxOS4yNDVsOC4yMzYgMy45NjFhMi41IDIuNSAwIDAgMSAxLjQxNSAyLjI1M3YuMDk5LS4wNDVWMzMuMzd2LS4wNDUuMDk1YTIuNTAxIDIuNTAxIDAgMCAxLTEuNDE2IDIuMjU3bC04LjIzNSAzLjk2MWEyLjQ5MiAyLjQ5MiAwIDAgMS0xLjA3Ny4yNDZabS43MTYtMjguOTQ3LTExLjk0OCA5LjA2MiAxMS45NTIgOS4wNjUtLjAwNC0xOC4xMjdaIi8+PC9zdmc+)](https://vscode.stainless.com/mcp/%7B%22name%22%3A%22%40plazafyi%2Fmcp%22%2C%22command%22%3A%22npx%22%2C%22args%22%3A%5B%22-y%22%2C%22%40plazafyi%2Fmcp%22%5D%2C%22env%22%3A%7B%22PLAZA_API_KEY%22%3A%22My%20API%20Key%22%7D%7D)

> Note: You may need to set environment variables in your MCP client.

<!-- x-release-please-start-version -->

The REST API documentation can be found on [docs.plaza.fyi](https://docs.plaza.fyi). Javadocs are available on [javadoc.io](https://javadoc.io/doc/com.plazafyi/plaza-java/0.1.0).

<!-- x-release-please-end -->

## Installation

<!-- x-release-please-start-version -->

### Gradle

```kotlin
implementation("com.plazafyi:plaza-java:0.1.0")
```

### Maven

```xml
<dependency>
  <groupId>com.plazafyi</groupId>
  <artifactId>plaza-java</artifactId>
  <version>0.1.0</version>
</dependency>
```

<!-- x-release-please-end -->

## Requirements

This library requires Java 8 or later.

## Usage

```java
import com.plazafyi.client.PlazaClient;
import com.plazafyi.client.okhttp.PlazaOkHttpClient;
import com.plazafyi.models.FeatureCollection;
import com.plazafyi.models.features.FeatureQueryParams;

// Configures using the `plaza.apiKey` and `plaza.baseUrl` system properties
// Or configures using the `PLAZA_API_KEY` and `PLAZA_BASE_URL` environment variables
PlazaClient client = PlazaOkHttpClient.fromEnv();

FeatureCollection featureCollection = client.features().query();
```

## Client configuration

Configure the client using system properties or environment variables:

```java
import com.plazafyi.client.PlazaClient;
import com.plazafyi.client.okhttp.PlazaOkHttpClient;

// Configures using the `plaza.apiKey` and `plaza.baseUrl` system properties
// Or configures using the `PLAZA_API_KEY` and `PLAZA_BASE_URL` environment variables
PlazaClient client = PlazaOkHttpClient.fromEnv();
```

Or manually:

```java
import com.plazafyi.client.PlazaClient;
import com.plazafyi.client.okhttp.PlazaOkHttpClient;

PlazaClient client = PlazaOkHttpClient.builder()
    .apiKey("My API Key")
    .build();
```

Or using a combination of the two approaches:

```java
import com.plazafyi.client.PlazaClient;
import com.plazafyi.client.okhttp.PlazaOkHttpClient;

PlazaClient client = PlazaOkHttpClient.builder()
    // Configures using the `plaza.apiKey` and `plaza.baseUrl` system properties
    // Or configures using the `PLAZA_API_KEY` and `PLAZA_BASE_URL` environment variables
    .fromEnv()
    .apiKey("My API Key")
    .build();
```

See this table for the available options:

| Setter    | System property | Environment variable | Required | Default value         |
| --------- | --------------- | -------------------- | -------- | --------------------- |
| `apiKey`  | `plaza.apiKey`  | `PLAZA_API_KEY`      | true     | -                     |
| `baseUrl` | `plaza.baseUrl` | `PLAZA_BASE_URL`     | true     | `"https://plaza.fyi"` |

System properties take precedence over environment variables.

> [!TIP]
> Don't create more than one client in the same application. Each client has a connection pool and
> thread pools, which are more efficient to share between requests.

### Modifying configuration

To temporarily use a modified client configuration, while reusing the same connection and thread pools, call `withOptions()` on any client or service:

```java
import com.plazafyi.client.PlazaClient;

PlazaClient clientWithOptions = client.withOptions(optionsBuilder -> {
    optionsBuilder.baseUrl("https://example.com");
    optionsBuilder.maxRetries(42);
});
```

The `withOptions()` method does not affect the original client or service.

## Requests and responses

To send a request to the Plaza API, build an instance of some `Params` class and pass it to the corresponding client method. When the response is received, it will be deserialized into an instance of a Java class.

For example, `client.features().query(...)` should be called with an instance of `FeatureQueryParams`, and it will return an instance of `FeatureCollection`.

## Immutability

Each class in the SDK has an associated [builder](https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java) or factory method for constructing it.

Each class is [immutable](https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html) once constructed. If the class has an associated builder, then it has a `toBuilder()` method, which can be used to convert it back to a builder for making a modified copy.

Because each class is immutable, builder modification will _never_ affect already built class instances.

## Asynchronous execution

The default client is synchronous. To switch to asynchronous execution, call the `async()` method:

```java
import com.plazafyi.client.PlazaClient;
import com.plazafyi.client.okhttp.PlazaOkHttpClient;
import com.plazafyi.models.FeatureCollection;
import com.plazafyi.models.features.FeatureQueryParams;
import java.util.concurrent.CompletableFuture;

// Configures using the `plaza.apiKey` and `plaza.baseUrl` system properties
// Or configures using the `PLAZA_API_KEY` and `PLAZA_BASE_URL` environment variables
PlazaClient client = PlazaOkHttpClient.fromEnv();

CompletableFuture<FeatureCollection> featureCollection = client.async().features().query();
```

Or create an asynchronous client from the beginning:

```java
import com.plazafyi.client.PlazaClientAsync;
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync;
import com.plazafyi.models.FeatureCollection;
import com.plazafyi.models.features.FeatureQueryParams;
import java.util.concurrent.CompletableFuture;

// Configures using the `plaza.apiKey` and `plaza.baseUrl` system properties
// Or configures using the `PLAZA_API_KEY` and `PLAZA_BASE_URL` environment variables
PlazaClientAsync client = PlazaOkHttpClientAsync.fromEnv();

CompletableFuture<FeatureCollection> featureCollection = client.features().query();
```

The asynchronous client supports the same options as the synchronous one, except most methods return `CompletableFuture`s.

## Binary responses

The SDK defines methods that return binary responses, which are used for API responses that shouldn't necessarily be parsed, like non-JSON data.

These methods return [`HttpResponse`](plaza-java-core/src/main/kotlin/com/plazafyi/core/http/HttpResponse.kt):

```java
import com.plazafyi.core.http.HttpResponse;
import com.plazafyi.models.tiles.TileGetParams;

TileGetParams params = TileGetParams.builder()
    .z(0L)
    .x(0L)
    .y(0L)
    .build();
HttpResponse tile = client.tiles().get(params);
```

To save the response content to a file, use the [`Files.copy(...)`](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#copy-java.io.InputStream-java.nio.file.Path-java.nio.file.CopyOption...-) method:

```java
import com.plazafyi.core.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

try (HttpResponse response = client.tiles().get(params)) {
    Files.copy(
        response.body(),
        Paths.get(path),
        StandardCopyOption.REPLACE_EXISTING
    );
} catch (Exception e) {
    System.out.println("Something went wrong!");
    throw new RuntimeException(e);
}
```

Or transfer the response content to any [`OutputStream`](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html):

```java
import com.plazafyi.core.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

try (HttpResponse response = client.tiles().get(params)) {
    response.body().transferTo(Files.newOutputStream(Paths.get(path)));
} catch (Exception e) {
    System.out.println("Something went wrong!");
    throw new RuntimeException(e);
}
```

## Raw responses

The SDK defines methods that deserialize responses into instances of Java classes. However, these methods don't provide access to the response headers, status code, or the raw response body.

To access this data, prefix any HTTP method call on a client or service with `withRawResponse()`:

```java
import com.plazafyi.core.http.Headers;
import com.plazafyi.core.http.HttpResponseFor;
import com.plazafyi.models.FeatureCollection;
import com.plazafyi.models.features.FeatureQueryParams;

HttpResponseFor<FeatureCollection> featureCollection = client.features().withRawResponse().query();

int statusCode = featureCollection.statusCode();
Headers headers = featureCollection.headers();
```

You can still deserialize the response into an instance of a Java class if needed:

```java
import com.plazafyi.models.FeatureCollection;

FeatureCollection parsedFeatureCollection = featureCollection.parse();
```

## Error handling

The SDK throws custom unchecked exception types:

- [`PlazaServiceException`](plaza-java-core/src/main/kotlin/com/plazafyi/errors/PlazaServiceException.kt): Base class for HTTP errors. See this table for which exception subclass is thrown for each HTTP status code:

  | Status | Exception                                                                                                               |
  | ------ | ----------------------------------------------------------------------------------------------------------------------- |
  | 400    | [`BadRequestException`](plaza-java-core/src/main/kotlin/com/plazafyi/errors/BadRequestException.kt)                     |
  | 401    | [`UnauthorizedException`](plaza-java-core/src/main/kotlin/com/plazafyi/errors/UnauthorizedException.kt)                 |
  | 403    | [`PermissionDeniedException`](plaza-java-core/src/main/kotlin/com/plazafyi/errors/PermissionDeniedException.kt)         |
  | 404    | [`NotFoundException`](plaza-java-core/src/main/kotlin/com/plazafyi/errors/NotFoundException.kt)                         |
  | 422    | [`UnprocessableEntityException`](plaza-java-core/src/main/kotlin/com/plazafyi/errors/UnprocessableEntityException.kt)   |
  | 429    | [`RateLimitException`](plaza-java-core/src/main/kotlin/com/plazafyi/errors/RateLimitException.kt)                       |
  | 5xx    | [`InternalServerException`](plaza-java-core/src/main/kotlin/com/plazafyi/errors/InternalServerException.kt)             |
  | others | [`UnexpectedStatusCodeException`](plaza-java-core/src/main/kotlin/com/plazafyi/errors/UnexpectedStatusCodeException.kt) |

- [`PlazaIoException`](plaza-java-core/src/main/kotlin/com/plazafyi/errors/PlazaIoException.kt): I/O networking errors.

- [`PlazaRetryableException`](plaza-java-core/src/main/kotlin/com/plazafyi/errors/PlazaRetryableException.kt): Generic error indicating a failure that could be retried by the client.

- [`PlazaInvalidDataException`](plaza-java-core/src/main/kotlin/com/plazafyi/errors/PlazaInvalidDataException.kt): Failure to interpret successfully parsed data. For example, when accessing a property that's supposed to be required, but the API unexpectedly omitted it from the response.

- [`PlazaException`](plaza-java-core/src/main/kotlin/com/plazafyi/errors/PlazaException.kt): Base class for all exceptions. Most errors will result in one of the previously mentioned ones, but completely generic errors may be thrown using the base class.

## Logging

The SDK uses the standard [OkHttp logging interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor).

Enable logging by setting the `PLAZA_LOG` environment variable to `info`:

```sh
export PLAZA_LOG=info
```

Or to `debug` for more verbose logging:

```sh
export PLAZA_LOG=debug
```

## ProGuard and R8

Although the SDK uses reflection, it is still usable with [ProGuard](https://github.com/Guardsquare/proguard) and [R8](https://developer.android.com/topic/performance/app-optimization/enable-app-optimization) because `plaza-java-core` is published with a [configuration file](plaza-java-core/src/main/resources/META-INF/proguard/plaza-java-core.pro) containing [keep rules](https://www.guardsquare.com/manual/configuration/usage).

ProGuard and R8 should automatically detect and use the published rules, but you can also manually copy the keep rules if necessary.

## Jackson

The SDK depends on [Jackson](https://github.com/FasterXML/jackson) for JSON serialization/deserialization. It is compatible with version 2.13.4 or higher, but depends on version 2.18.2 by default.

The SDK throws an exception if it detects an incompatible Jackson version at runtime (e.g. if the default version was overridden in your Maven or Gradle config).

If the SDK threw an exception, but you're _certain_ the version is compatible, then disable the version check using the `checkJacksonVersionCompatibility` on [`PlazaOkHttpClient`](plaza-java-client-okhttp/src/main/kotlin/com/plazafyi/client/okhttp/PlazaOkHttpClient.kt) or [`PlazaOkHttpClientAsync`](plaza-java-client-okhttp/src/main/kotlin/com/plazafyi/client/okhttp/PlazaOkHttpClientAsync.kt).

> [!CAUTION]
> We make no guarantee that the SDK works correctly when the Jackson version check is disabled.

Also note that there are bugs in older Jackson versions that can affect the SDK. We don't work around all Jackson bugs ([example](https://github.com/FasterXML/jackson-databind/issues/3240)) and expect users to upgrade Jackson for those instead.

## Network options

### Retries

The SDK automatically retries 2 times by default, with a short exponential backoff between requests.

Only the following error types are retried:

- Connection errors (for example, due to a network connectivity problem)
- 408 Request Timeout
- 409 Conflict
- 429 Rate Limit
- 5xx Internal

The API may also explicitly instruct the SDK to retry or not retry a request.

To set a custom number of retries, configure the client using the `maxRetries` method:

```java
import com.plazafyi.client.PlazaClient;
import com.plazafyi.client.okhttp.PlazaOkHttpClient;

PlazaClient client = PlazaOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

### Timeouts

Requests time out after 1 minute by default.

To set a custom timeout, configure the method call using the `timeout` method:

```java
import com.plazafyi.models.FeatureCollection;

FeatureCollection featureCollection = client.features().query(RequestOptions.builder().timeout(Duration.ofSeconds(30)).build());
```

Or configure the default for all method calls at the client level:

```java
import com.plazafyi.client.PlazaClient;
import com.plazafyi.client.okhttp.PlazaOkHttpClient;
import java.time.Duration;

PlazaClient client = PlazaOkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build();
```

### Proxies

To route requests through a proxy, configure the client using the `proxy` method:

```java
import com.plazafyi.client.PlazaClient;
import com.plazafyi.client.okhttp.PlazaOkHttpClient;
import java.net.InetSocketAddress;
import java.net.Proxy;

PlazaClient client = PlazaOkHttpClient.builder()
    .fromEnv()
    .proxy(new Proxy(
      Proxy.Type.HTTP, new InetSocketAddress(
        "https://example.com", 8080
      )
    ))
    .build();
```

If the proxy responds with `407 Proxy Authentication Required`, supply credentials by also configuring `proxyAuthenticator`:

```java
import com.plazafyi.client.PlazaClient;
import com.plazafyi.client.okhttp.PlazaOkHttpClient;
import com.plazafyi.core.http.ProxyAuthenticator;

PlazaClient client = PlazaOkHttpClient.builder()
    .fromEnv()
    .proxy(...)
    // Or a custom implementation of `ProxyAuthenticator`.
    .proxyAuthenticator(ProxyAuthenticator.basic("username", "password"))
    .build();
```

### Connection pooling

To customize the underlying OkHttp connection pool, configure the client using the `maxIdleConnections` and `keepAliveDuration` methods:

```java
import com.plazafyi.client.PlazaClient;
import com.plazafyi.client.okhttp.PlazaOkHttpClient;
import java.time.Duration;

PlazaClient client = PlazaOkHttpClient.builder()
    .fromEnv()
    // If `maxIdleConnections` is set, then `keepAliveDuration` must be set, and vice versa.
    .maxIdleConnections(10)
    .keepAliveDuration(Duration.ofMinutes(2))
    .build();
```

If both options are unset, OkHttp's default connection pool settings are used.

### HTTPS

> [!NOTE]
> Most applications should not call these methods, and instead use the system defaults. The defaults include
> special optimizations that can be lost if the implementations are modified.

To configure how HTTPS connections are secured, configure the client using the `sslSocketFactory`, `trustManager`, and `hostnameVerifier` methods:

```java
import com.plazafyi.client.PlazaClient;
import com.plazafyi.client.okhttp.PlazaOkHttpClient;

PlazaClient client = PlazaOkHttpClient.builder()
    .fromEnv()
    // If `sslSocketFactory` is set, then `trustManager` must be set, and vice versa.
    .sslSocketFactory(yourSSLSocketFactory)
    .trustManager(yourTrustManager)
    .hostnameVerifier(yourHostnameVerifier)
    .build();
```

### Environments

The SDK sends requests to the production by default. To send requests to a different environment, configure the client like so:

```java
import com.plazafyi.client.PlazaClient;
import com.plazafyi.client.okhttp.PlazaOkHttpClient;

PlazaClient client = PlazaOkHttpClient.builder()
    .fromEnv()
    .local()
    .build();
```

### Custom HTTP client

The SDK consists of three artifacts:

- `plaza-java-core`
  - Contains core SDK logic
  - Does not depend on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`PlazaClient`](plaza-java-core/src/main/kotlin/com/plazafyi/client/PlazaClient.kt), [`PlazaClientAsync`](plaza-java-core/src/main/kotlin/com/plazafyi/client/PlazaClientAsync.kt), [`PlazaClientImpl`](plaza-java-core/src/main/kotlin/com/plazafyi/client/PlazaClientImpl.kt), and [`PlazaClientAsyncImpl`](plaza-java-core/src/main/kotlin/com/plazafyi/client/PlazaClientAsyncImpl.kt), all of which can work with any HTTP client
- `plaza-java-client-okhttp`
  - Depends on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`PlazaOkHttpClient`](plaza-java-client-okhttp/src/main/kotlin/com/plazafyi/client/okhttp/PlazaOkHttpClient.kt) and [`PlazaOkHttpClientAsync`](plaza-java-client-okhttp/src/main/kotlin/com/plazafyi/client/okhttp/PlazaOkHttpClientAsync.kt), which provide a way to construct [`PlazaClientImpl`](plaza-java-core/src/main/kotlin/com/plazafyi/client/PlazaClientImpl.kt) and [`PlazaClientAsyncImpl`](plaza-java-core/src/main/kotlin/com/plazafyi/client/PlazaClientAsyncImpl.kt), respectively, using OkHttp
- `plaza-java`
  - Depends on and exposes the APIs of both `plaza-java-core` and `plaza-java-client-okhttp`
  - Does not have its own logic

This structure allows replacing the SDK's default HTTP client without pulling in unnecessary dependencies.

#### Customized [`OkHttpClient`](https://square.github.io/okhttp/3.x/okhttp/okhttp3/OkHttpClient.html)

> [!TIP]
> Try the available [network options](#network-options) before replacing the default client.

To use a customized `OkHttpClient`:

1. Replace your [`plaza-java` dependency](#installation) with `plaza-java-core`
2. Copy `plaza-java-client-okhttp`'s [`OkHttpClient`](plaza-java-client-okhttp/src/main/kotlin/com/plazafyi/client/okhttp/OkHttpClient.kt) class into your code and customize it
3. Construct [`PlazaClientImpl`](plaza-java-core/src/main/kotlin/com/plazafyi/client/PlazaClientImpl.kt) or [`PlazaClientAsyncImpl`](plaza-java-core/src/main/kotlin/com/plazafyi/client/PlazaClientAsyncImpl.kt), similarly to [`PlazaOkHttpClient`](plaza-java-client-okhttp/src/main/kotlin/com/plazafyi/client/okhttp/PlazaOkHttpClient.kt) or [`PlazaOkHttpClientAsync`](plaza-java-client-okhttp/src/main/kotlin/com/plazafyi/client/okhttp/PlazaOkHttpClientAsync.kt), using your customized client

### Completely custom HTTP client

To use a completely custom HTTP client:

1. Replace your [`plaza-java` dependency](#installation) with `plaza-java-core`
2. Write a class that implements the [`HttpClient`](plaza-java-core/src/main/kotlin/com/plazafyi/core/http/HttpClient.kt) interface
3. Construct [`PlazaClientImpl`](plaza-java-core/src/main/kotlin/com/plazafyi/client/PlazaClientImpl.kt) or [`PlazaClientAsyncImpl`](plaza-java-core/src/main/kotlin/com/plazafyi/client/PlazaClientAsyncImpl.kt), similarly to [`PlazaOkHttpClient`](plaza-java-client-okhttp/src/main/kotlin/com/plazafyi/client/okhttp/PlazaOkHttpClient.kt) or [`PlazaOkHttpClientAsync`](plaza-java-client-okhttp/src/main/kotlin/com/plazafyi/client/okhttp/PlazaOkHttpClientAsync.kt), using your new client class

## Undocumented API functionality

The SDK is typed for convenient usage of the documented API. However, it also supports working with undocumented or not yet supported parts of the API.

### Parameters

To set undocumented parameters, call the `putAdditionalHeader`, `putAdditionalQueryParam`, or `putAdditionalBodyProperty` methods on any `Params` class:

```java
import com.plazafyi.core.JsonValue;
import com.plazafyi.models.features.FeatureQueryParams;

FeatureQueryParams params = FeatureQueryParams.builder()
    .putAdditionalHeader("Secret-Header", "42")
    .putAdditionalQueryParam("secret_query_param", "42")
    .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
    .build();
```

These can be accessed on the built object later using the `_additionalHeaders()`, `_additionalQueryParams()`, and `_additionalBodyProperties()` methods.

To set a documented parameter or property to an undocumented or not yet supported _value_, pass a [`JsonValue`](plaza-java-core/src/main/kotlin/com/plazafyi/core/Values.kt) object to its setter:

```java
import com.plazafyi.models.features.FeatureQueryParams;

FeatureQueryParams params = FeatureQueryParams.builder().build();
```

The most straightforward way to create a [`JsonValue`](plaza-java-core/src/main/kotlin/com/plazafyi/core/Values.kt) is using its `from(...)` method:

```java
import com.plazafyi.core.JsonValue;
import java.util.List;
import java.util.Map;

// Create primitive JSON values
JsonValue nullValue = JsonValue.from(null);
JsonValue booleanValue = JsonValue.from(true);
JsonValue numberValue = JsonValue.from(42);
JsonValue stringValue = JsonValue.from("Hello World!");

// Create a JSON array value equivalent to `["Hello", "World"]`
JsonValue arrayValue = JsonValue.from(List.of(
  "Hello", "World"
));

// Create a JSON object value equivalent to `{ "a": 1, "b": 2 }`
JsonValue objectValue = JsonValue.from(Map.of(
  "a", 1,
  "b", 2
));

// Create an arbitrarily nested JSON equivalent to:
// {
//   "a": [1, 2],
//   "b": [3, 4]
// }
JsonValue complexValue = JsonValue.from(Map.of(
  "a", List.of(
    1, 2
  ),
  "b", List.of(
    3, 4
  )
));
```

Normally a `Builder` class's `build` method will throw [`IllegalStateException`](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html) if any required parameter or property is unset.

To forcibly omit a required parameter or property, pass [`JsonMissing`](plaza-java-core/src/main/kotlin/com/plazafyi/core/Values.kt):

```java
import com.plazafyi.core.JsonMissing;
import com.plazafyi.models.features.FeatureQueryParams;
import com.plazafyi.models.features.FeatureRetrieveParams;

FeatureQueryParams params = FeatureRetrieveParams.builder()
    .type(JsonMissing.of())
    .build();
```

### Response properties

To access undocumented response properties, call the `_additionalProperties()` method:

```java
import com.plazafyi.core.JsonValue;
import java.util.Map;

Map<String, JsonValue> additionalProperties = client.features().query(params)._additionalProperties();
JsonValue secretPropertyValue = additionalProperties.get("secretProperty");

String result = secretPropertyValue.accept(new JsonValue.Visitor<>() {
    @Override
    public String visitNull() {
        return "It's null!";
    }

    @Override
    public String visitBoolean(boolean value) {
        return "It's a boolean!";
    }

    @Override
    public String visitNumber(Number value) {
        return "It's a number!";
    }

    // Other methods include `visitMissing`, `visitString`, `visitArray`, and `visitObject`
    // The default implementation of each unimplemented method delegates to `visitDefault`, which throws by default, but can also be overridden
});
```

To access a property's raw JSON value, which may be undocumented, call its `_` prefixed method:

```java
import com.plazafyi.core.JsonField;
import java.util.Optional;

JsonField<Object> field = client.features().query(params)._field();

if (field.isMissing()) {
  // The property is absent from the JSON response
} else if (field.isNull()) {
  // The property was set to literal null
} else {
  // Check if value was provided as a string
  // Other methods include `asNumber()`, `asBoolean()`, etc.
  Optional<String> jsonString = field.asString();

  // Try to deserialize into a custom type
  MyClass myObject = field.asUnknown().orElseThrow().convert(MyClass.class);
}
```

### Response validation

In rare cases, the API may return a response that doesn't match the expected type. For example, the SDK may expect a property to contain a `String`, but the API could return something else.

By default, the SDK will not throw an exception in this case. It will throw [`PlazaInvalidDataException`](plaza-java-core/src/main/kotlin/com/plazafyi/errors/PlazaInvalidDataException.kt) only if you directly access the property.

Validating the response is _not_ forwards compatible with new types from the API for existing fields.

If you would still prefer to check that the response is completely well-typed upfront, then either call `validate()`:

```java
import com.plazafyi.models.FeatureCollection;

FeatureCollection featureCollection = client.features().query(params).validate();
```

Or configure the method call to validate the response using the `responseValidation` method:

```java
import com.plazafyi.models.FeatureCollection;

FeatureCollection featureCollection = client.features().query(RequestOptions.builder().responseValidation(true).build());
```

Or configure the default for all method calls at the client level:

```java
import com.plazafyi.client.PlazaClient;
import com.plazafyi.client.okhttp.PlazaOkHttpClient;

PlazaClient client = PlazaOkHttpClient.builder()
    .fromEnv()
    .responseValidation(true)
    .build();
```

## FAQ

### Why don't you use plain `enum` classes?

Java `enum` classes are not trivially [forwards compatible](https://www.stainless.com/blog/making-java-enums-forwards-compatible). Using them in the SDK could cause runtime exceptions if the API is updated to respond with a new enum value.

### Why do you represent fields using `JsonField<T>` instead of just plain `T`?

Using `JsonField<T>` enables a few features:

- Allowing usage of [undocumented API functionality](#undocumented-api-functionality)
- Lazily [validating the API response against the expected shape](#response-validation)
- Representing absent vs explicitly null values

### Why don't you use [`data` classes](https://kotlinlang.org/docs/data-classes.html)?

It is not [backwards compatible to add new fields to a data class](https://kotlinlang.org/docs/api-guidelines-backward-compatibility.html#avoid-using-data-classes-in-your-api) and we don't want to introduce a breaking change every time we add a field to a class.

### Why don't you use checked exceptions?

Checked exceptions are widely considered a mistake in the Java programming language. In fact, they were omitted from Kotlin for this reason.

Checked exceptions:

- Are verbose to handle
- Encourage error handling at the wrong level of abstraction, where nothing can be done about the error
- Are tedious to propagate due to the [function coloring problem](https://journal.stuffwithstuff.com/2015/02/01/what-color-is-your-function)
- Don't play well with lambdas (also due to the function coloring problem)

## Semantic versioning

This package generally follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions, though certain backwards-incompatible changes may be released as minor versions:

1. Changes to library internals which are technically public but not intended or documented for external use. _(Please open a GitHub issue to let us know if you are relying on such internals.)_
2. Changes that we do not expect to impact the vast majority of users in practice.

We take backwards-compatibility seriously and work hard to ensure you can rely on a smooth upgrade experience.

We are keen for your feedback; please open an [issue](https://www.github.com/plazafyi/plaza-java/issues) with questions, bugs, or suggestions.
