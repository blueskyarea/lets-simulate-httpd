#!/bin/bash
echo "entrypoint.sh is running."

# Replace the placeholder in server.xml.template with the JVM_ROUTE environment variable
envsubst < /usr/local/tomcat/conf/server.xml.template > /usr/local/tomcat/conf/server.xml

# Debug: Output the generated server.xml
echo "Generated server.xml:"
cat /usr/local/tomcat/conf/server.xml

# Debug: Check if server.xml.template exists
if [ -f /usr/local/tomcat/conf/server.xml.template ]; then
    echo "server.xml.template exists."
else
    echo "server.xml.template is missing."
fi

# Start Tomcat
exec catalina.sh run