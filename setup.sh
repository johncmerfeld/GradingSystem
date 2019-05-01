#!/usr/bin/env bash

set -e

echo "Setting up database..."

# copy dummy data into MySQL's local directory
datadir=$(mysql -N -s -u root -e 'select @@datadir')
cp -r dummy_data $datadir

# create database and tables
cat sql/init.sql | mysql -u root

# load dummy data into the database
cat sql/dummy_data.sql | mysql -u root

echo "Database successfully set up!"

set +e
