
# API case builder Spec

## 1. Resources: /API

resource API,there are two major resources:

- GET to query API
- POST to create API

### 1.1 /API GET

  * request parameters 
    - domain,separated by ```,```
    - apiNames, separated by ```,```
    - apiIds, separated by ```,```
    - keywords,tag,..... not implement yet
  * response
    - List of API description
    
### 1.2 /API POST
  * request body:
  
    ```
     {
       "apiName":"testAPI",
       "apiURL":"/test/",
       "apiDomainName":"testDomain",
       "apiMethod":"GET",
       "apiRequestBody":"a sample file or a json sample",
       "apiAcceptType":"application/json",
       "apiContentType":"application/json"
     }
    ```
  * response body:
    
    ```
      { 
        "apiId":123455,
        "apiName":"testAPI",
        "apiURL":"/test/",
        "apiDomainName":"testDomain",
        "apiMethod":"GET",
        "apiRequestBody":"a sample file or a json sample",
        "apiAcceptType":"application/json",
        "apiContentType":"application/json",
        "apiStatus":"active"
      }  
    ```    