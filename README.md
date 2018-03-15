# Overview
This Web Service implements [__identifiers.org__](http://identifiers.org) Namespace Registration API for programmatically submit registration requests.


# Running the Namespace Registration Service
This service can be run in _standalone_ mode, i.e. if you just want to bring this service up for programmatically submit namespace registration requests.

For this version of the service to run in _standalone_ mode you will need a working installation of [Docker](http://docker.com), and credentials to access an SMTP service.

Download, from this repo, the file named [_docker-compose-standalone.yml_](https://raw.githubusercontent.com/identifiers-org/cloud-ws-register/master/docker-compose-standalone.yml), and edit the environment variables with the credentials to access an SMTP service, e.g. below an example on how to do it for a Gmail account (**you will need to enable 'less secure' apps in the security section of your e-mail account**, because the current version of this service doesn't support OAuth2 yet).

```vim
- WS_REGISTRY_CONFIG_EMAIL_HOST=smtp.gmail.com
- WS_REGISTRY_CONFIG_EMAIL_PORT=587
- WS_REGISTRY_CONFIG_EMAIL_USERNAME=email_account@gmail.com
- WS_REGISTRY_CONFIG_EMAIL_PASSWORD=email_account_password
- WS_REGISTRY_CONFIG_EMAIL_TRANSPORT_PROTOCOL=smtp
- WS_REGISTRY_CONFIG_EMAIL_BOOLEAN_SMTP_AUTH=true
- WS_REGISTRY_CONFIG_EMAIL_BOOLEAN_START_TLS=true
- WS_REGISTRY_CONFIG_EMAIL_BOOLEAN_DEBUG=true
```

Once you've modified the _Docker Compose_ file, you can launch the _Namespace Registration Service_ via the following command

> docker-compose -f docker-compose-standalone.yml up -d

This will start the service in the background, to stop it, just run

> docker-compose -f docker-compose-standalone.yml down


# Submitting Requests to the Namespace Registration Service
There is a Java based library, [libapi](https://github.com/identifiers-org/cloud-libapi), that implements a client for this Web
Service.

Please, refer to its documentation on how to connect to [identifiers.org](https://identifiers.org) Web Services.


# Contributions
Documentation for developers will be coming soon, through the repository Wiki.


### Contact
Manuel Bernal Llinares
