# Update following variables before execute this shell file
# DB_HOST = Database host name or IP address
# DB_PORT = Database Port number. The default port is 27017
# DB_NAME = Database name (e.g. sph-dev, sph-test, sph)
# e.g. mongo localhost:27017/sph-dev  ./article-seed.js

mongo <<DB_HOST>>:<<DB_PORT>>/<<DB_NAME>> ./article-seed.js