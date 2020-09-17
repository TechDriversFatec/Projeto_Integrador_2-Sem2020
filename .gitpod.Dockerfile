FROM gitpod/workspace-full-vnc

USER root

# Install MySQL
RUN apt-get update \
 && apt-get install -y mysql-server \
 && apt-get clean && rm -rf /var/cache/apt/* /var/lib/apt/lists/* /tmp/* \
 && mkdir /var/run/mysqld \
 && chown -R gitpod:gitpod /etc/mysql /var/run/mysqld /var/log/mysql /var/lib/mysql /var/lib/mysql-files /var/lib/mysql-keyring /var/lib/mysql-upgrade

# Install our own MySQL config
COPY ./mysql.cnf /etc/mysql/mysql.conf.d/mysql.cnf

# Install default-login for MySQL clients
COPY ./client.cnf /etc/mysql/mysql.conf.d/client.cnf

COPY ./mysql-bashrc-launch.sh /etc/mysql/mysql-bashrc-launch.sh

RUN echo "/etc/mysql/mysql-bashrc-launch.sh" >> ~/.bashrc

USER gitpod