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
The _Namespace Registration Service_ runs on port 8081. Its main endpoint for registration requests is via **HTTP POST** requests to

> http://registry:8081

being 'registry' the name of the host that's running the service.

The _body_ of the registration requests must contain the following information:

```json
{
    "name": "Valid new testing prefix mynewprefix",
    "description": "This describes your namespace registration request, and it needs to be more than 50 characters long",
    "homePage": "http://your_home_page.tld/",
    "organization": "Your Organization Name",
    "preferredPrefix": "mynewprefix",
    "resourceAccessRule": "http://somewhere.tld/{$id}",
    "exampleIdentifier": "9875624",
    "regexPattern": "\\d+$",
    "references": [
        "Reference",
        "Publication",
        "Citation"
    ],
    "additionalInformation": "Additional information you'd like to attach to this registration request",
    "requester": {
        "name": "Requester name",
        "email": "requester_name@yourorganization.tld"
    }
}
```

If your request is **valid**, you will receive the corresponding _HTTP OK_ response and it will be queued for final review by a curator in [__identifiers.org__](http://identifiers.org).

In case your request is **not valid**, you will get an _HTTP BAD REQUEST_ response including the reasons why your request did not validate in the body of the response.


# Contributions
Documentation for developers will be coming soon, through the repository Wiki.


### Contact
Manuel Bernal Llinares
