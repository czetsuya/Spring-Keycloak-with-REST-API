[![ko-fi](https://www.ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/S6S0YXPX)

# Spring Project Secured with Keycloak

A demo project created to demonstrate how a Spring project can be secured using a Keycloak server via bearer token.

Requirements:
- Keycloak server 6.0.1
- https://github.com/czetsuya/keycloak-react

Note:
- Make sure that you have the same Keycloak client credentials value for the 2 project ands Keycloak server.

If keycloak.json file is to be used instead of application.yml, set the following system variable and make sure that you have the file keycloak.json in src/main/resources.

keycloak.configurationFile = classpath:keycloak.json

Users

Role=User, kerri / kerri
Role=Admin, admin / admin