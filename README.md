# Spring Project Secured with Keycloak

A demo project created to demonstrate how a Spring project can be secured using a Keycloak server via bearer token.

SpringDoc URLs:

 - springdoc.api-docs=/api-docs
 - springdoc.swagger-ui.path=/swagger-ui.html

## Requirements:

- Keycloak server 6.0.1
- https://github.com/czetsuya/keycloak-react

*In case you will be using Keycloak version greater than 7.0.0, the Keycloak team has introduced the notion of feature and uploading the json file has become one of them. Sadly, it is disabled by default. To enable realm, upload run Keycloak with the given parameter:

```
standalone.bat -Dkeycloak.profile.feature.upload_scripts=enabled
```

Here's the documentation: https://www.keycloak.org/docs/latest/server_installation/, look at the profiles section.

## Note:

- Make sure that you have the same Keycloak client credentials value for the 2 project ands Keycloak server.

If keycloak.json file is to be used instead of application.yml, set the following system variable and make sure that you have the file keycloak.json in src/main/resources.

keycloak.configurationFile = classpath:keycloak.json

## Users

Role=User, kerri / kerri
Role=Admin, admin / admin

## References

 - https://github.com/springdoc/springdoc-openapi-maven-plugin
