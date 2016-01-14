#!/usr/bin/env bash

brew install cassandra
# pip install cassandra-driver
brew install cassandra-driver

# start cassandra
/usr/local/bin/cassandra -f

### Start a Cassandra shell cqlsh
# ```
# /usr/local/bin/cqlsh
# ```

#
#### Setup Keyspace and Tables
#
#```
#CREATE KEYSPACE example
#WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
#
#USE example;
#
#CREATE TABLE users (
#  user_id int PRIMARY KEY,
#  uname text,
#  fname text,
#  lname text
#);
#```