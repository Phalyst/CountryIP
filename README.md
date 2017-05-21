# CountryIP

This application determines country name based on the given IP address

This application is a java maven project which use spring boot setup configurations 
and expose a country lookUp service which can be invoked by calling this link

http://server-name:8083/api/Country/{ipadress}

This application is configured to run on the server port 8083 
server-name be the machine ip-address which the application is running the application 
ipaddress = ipaddress as a String parameter to determine the country name

#ClientIP mobile
To make things interesting i ve provided an Android mobile client application which then consume 
the rest service provided by the above server for country lookUp
The android app is committed within this app directory, a package named infologic-pos-android
this client is already configured to run on a localhost machine which the IPaddress 10.0.2.2 in a case where
you might be running the country lookUp service on the same machine
in case you would want to run the app on a different machine ,you would need 
to change URL on the  ,infologic-pos-android/Res/Values file
