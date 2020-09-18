FROM mongo:bionic

RUN mkdir -p /etc/ssl
COPY cert/mongodb.pem /etc/ssl/
COPY cert/rootCA.pem /etc/ssl/
CMD ["mongod","--tlsMode", "requireTLS", "--tlsCertificateKeyFile", "/etc/ssl/mongodb.pem", "--tlsCAFile",  "/etc/ssl/rootCA.pem", "--tlsAllowConnectionsWithoutCertificates", "--tlsAllowInvalidCertificates"]

#build image manually
# docker build --tag mongo-tls:1.0.0 .
# configure own image
# docker run -d --name=mongo-tls  -p 27017:27017  -e MONGO_INITDB_ROOT_USERNAME=pi -e MONGO_INITDB_ROOT_PASSWORD=pi -v d:/Workdoc/telekom/docker-compose/mongo-tls/cert:/keys mongo:bionic --tlsMode requireTLS --tlsCertificateKeyFile /keys/mongodb.pem --tlsCAFile /keys/rootCA.pem --tlsAllowConnectionsWithoutCertificates
