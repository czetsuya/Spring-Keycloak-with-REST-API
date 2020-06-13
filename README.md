[![patreon](https://c5.patreon.com/external/logo/become_a_patron_button.png)](https://www.patreon.com/bePatron?u=12280211)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

# Spring Project Secured with Keycloak

A demo project created to demonstrate how a Spring project can be secured using a Keycloak server via bearer token.

SpringDoc URLs:

 - springdoc.api-docs=/api-docs
 - springdoc.swagger-ui.path=/swagger-ui.html

## Requirements:

- Keycloak server 10.0.1
- https://github.com/czetsuya/keycloak-react

*In case you will be using Keycloak version greater than 7.0.0, the Keycloak team has introduced the notion of feature and uploading the json file has become one of them. Sadly, it is disabled by default. To enable realm, upload run Keycloak with the given parameter:

```
standalone.bat -Djboss.socket.binding.port-offset=1 -Dkeycloak.profile.feature.upload_scripts=enabled
```

Here's the documentation: https://www.keycloak.org/docs/latest/server_installation/, look at the profiles section.

## Running Keycloak in Docker

To run Keycloak as a docker container and enable the realm configuration upload, the keycloak.profile.feature.upload_scripts must be set.

```sh
docker run -d -p 8080:8080 -e JAVA_OPTS="-Dkeycloak.profile.feature.scripts=enabled -Dkeycloak.profile.feature.upload_scripts=enabled" -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=kerri jboss/keycloak
```

## Running Keycloak as Standalone

Import the realm file inside the config folder. If you're not familiar with the installation process, visit the blog I have written in the reference section below.

When you import the realm it will also create the users below.

### Users

Role=User, kerri / kerri
Role=Admin, admin / admin


## Note:

- Make sure that you have the same Keycloak client credentials value for the 2 project ands Keycloak server.

If keycloak.json file is to be used instead of application.yml, set the following system variable and make sure that you have the file keycloak.json in src/main/resources.

keycloak.configurationFile = classpath:keycloak.json

## References

 - https://czetsuya-tech.blogspot.com/2020/02/download-and-configure-keycloak-sso-server.html
 - https://github.com/springdoc/springdoc-openapi-maven-plugin

## Authors

 * **Edward P. Legaspi** - *Java Architect* - [czetsuya](https://github.com/czetsuya)
