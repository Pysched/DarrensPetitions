# Use the Tomcat image as the base image
FROM tomcat:latest

# Copy the WAR file from the build context into the Tomcat webapps directory
ADD target/*.war /usr/local/tomcat/webapps/

# Expose the port the Tomcat server will be listening on
EXPOSE 8080

# Start the Tomcat server
CMD ["catalina.sh", "run"]