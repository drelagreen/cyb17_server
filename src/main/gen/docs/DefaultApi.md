# DefaultApi

All URIs are relative to *http://0.0.0.0:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**parkIdGet**](DefaultApi.md#parkIdGet) | **GET** /park/{id} | Get information about a specific park |
| [**rootGet**](DefaultApi.md#rootGet) | **GET** / | Hello World! |
| [**stationsGet**](DefaultApi.md#stationsGet) | **GET** /stations | Get a list of stations |
| [**stationsIdGet**](DefaultApi.md#stationsIdGet) | **GET** /stations/{id} | Get information about a specific station |
| [**wayIdGet**](DefaultApi.md#wayIdGet) | **GET** /way/{id} | Get information about a specific way |


<a name="parkIdGet"></a>
# **parkIdGet**
> Park parkIdGet(id)

Get information about a specific park

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://0.0.0.0:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | Park ID
    try {
      Park result = apiInstance.parkIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#parkIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**| Park ID | |

### Return type

[**Park**](Park.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |

<a name="rootGet"></a>
# **rootGet**
> String rootGet()

Hello World!

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://0.0.0.0:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      String result = apiInstance.rootGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#rootGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="stationsGet"></a>
# **stationsGet**
> List&lt;StationShort&gt; stationsGet()

Get a list of stations

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://0.0.0.0:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      List<StationShort> result = apiInstance.stationsGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#stationsGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;StationShort&gt;**](StationShort.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="stationsIdGet"></a>
# **stationsIdGet**
> Station stationsIdGet(id)

Get information about a specific station

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://0.0.0.0:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | Station ID
    try {
      Station result = apiInstance.stationsIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#stationsIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**| Station ID | |

### Return type

[**Station**](Station.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |

<a name="wayIdGet"></a>
# **wayIdGet**
> Way wayIdGet(id)

Get information about a specific way

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://0.0.0.0:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer id = 56; // Integer | Way ID
    try {
      Way result = apiInstance.wayIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#wayIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**| Way ID | |

### Return type

[**Way**](Way.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |

