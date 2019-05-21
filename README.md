# fastCGI-in-Java
FastCGI programming in Java: library and a demo program. \
The Java library is from libfcgi-dev Debian package.\
# How to compile the program
- Compile the library and export class files to current directory\
javac -d . libfcgi-java/*.java\
- Compile the main program\
javac tnFCGI.java\
- Build program JAR file\
jar cvfm tnFCGI.jar tnFCGI.MF *.class\
# How to run the program
## Prerequisites
- Web server that supports fast CGI, NGINX for example\
## Run program using nginx on Linux (Ubuntu/Debian)
- Setup the program to run as a service (please check systemd)
- Configure NGINX to talk with the program using fastCGI
Here below is an example of NGINX web setting \
>            location /jar/ {
>                fastcgi_pass 127.0.0.1:9000;
>                fastcgi_param PATH_INFO         $fastcgi_path_info;
>                fastcgi_param SCRIPT_NAME       $fastcgi_script_name;
>                fastcgi_param SCRIPT_FILENAME   $document_root$fastcgi_script_name;
>                fastcgi_param QUERY_STRING      $query_string;
>                fastcgi_param REQUEST_METHOD    $request_method;
>                fastcgi_param CONTENT_TYPE      $content_type;
>                fastcgi_param CONTENT_LENGTH    $content_length;
>                fastcgi_param REQUEST_URI       $request_uri;
>                fastcgi_param DOCUMENT_URI      $document_uri;
>                fastcgi_param DOCUMENT_ROOT     $document_root;
>                fastcgi_param SERVER_PROTOCOL   $server_protocol;
>                fastcgi_param REMOTE_ADDR       $clientip;
>                #include /etc/nginx/fastcgi_params; # or check more params in this file
>            }
### Using Unix Socket
This example shows how to use the java program as a fastcgi service of your website under subfolder 'jar' using TCP socket. You may customize the source code to let this program talk with NGINX through Unix socket. 
