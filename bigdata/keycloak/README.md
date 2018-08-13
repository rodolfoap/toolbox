Keycloak

1. Uncompress Keycloak into /opt/keycloak

2. Create admin user:

    ./bin/add-user-keycloak.sh -u admin

3. Start the server:

    bin/standalone.sh -b 0.0.0.0 &

4. More scripts at the end of the file

5. Login as admin:

    http://localhost:8080/auth/

6. Add realm: myrealm

7. Check that the administrative console is using the myrealm realm (top left, switches with Master and Myrealm)

8. Add user: user1

9. Change password in User/Credentials/: mypassword, temporary: OFF

10. Logoff.

11. Login as user1 on http://localhost:8080//auth/realms/myrealm/account; check settings, logoff.

12. Check endpoints in http://localhost:8080/auth/realms/myrealm/.well-known/openid-configuration

13. Login as administrator.

14. Create client: myclient, Valid Redirect URIs: https://myservice.myrealm.com

15. Add role: Clients/myclient/Roles: operator

16. Grant operator to user1: Users/user1/Role_Mappings/Client_Roles/myclient/Assigned_Roles: operator

17. Verify that access token can be obtained:

    #!/bin/bash
    curl    -d "client_id=myclient"      	    \
            -d "username=user1"             \
            -d "password=mypassword"        \
            -d "grant_type=password" -i     \
            "http://localhost:8080/auth/realms/myrealm/protocol/openid-connect/token"

    HTTP/1.1 200 OK
    Connection: keep-alive
    Set-Cookie: KC_RESTART=; Version=1; Expires=Thu, 01-Jan-1970 00:00:10 GMT; Max-Age=0; Path=/auth/realms/myrealm/; HttpOnly
    Content-Type: application/json
    Content-Length: 2637
    Date: Wed, 01 Aug 2018 14:15:38 GMT

    {"access_token":"eyJhbGci ... dN6pTwqA",
     "expires_in":300,
     "refresh_expires_in":1800,
     "refresh_token":"eyJhbGci ... PlJTxOLQ",
     "token_type":"bearer",
     "not-before-policy":0,
     "session_state":"dee91096-7020-4a04-af23-5ee6dc54732d",
     "scope":"email profile"
    }

Some scripts:

$ cat curl.token
        #!/bin/bash

        echo

        set -x
        curl    -i                              \
                -trace-ascii                    \
                -d "client_id=myclient"       	\
                -d "username=user1"             \
                -d "password=mypassword"        \
                -d "grant_type=password"        \
                "http://192.168.1.131:8080/auth/realms/myrealm/protocol/openid-connect/token"

        set +x
        echo

$ cat initialize
        #!/bin/bash
        set -x

        ./bin/add-user-keycloak.sh -u admin

$ cat start
        #!/bin/bash
        set -x

        bin/standalone.sh -b 0.0.0.0 &

$ cat stop
        #!/bin/bash
        set -x

        kill $(ps --no-headers -faxwwo "pid,args"|grep keycloak|grep -v grep|awk '{print $1}')

