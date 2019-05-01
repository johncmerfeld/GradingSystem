#!/usr/bin/env bash

set -e

echo "Setting up database..."

# do a password check?

datadir=$(mysql -N -s -u root -e 'select @@datadir')

cp -r dummy_data $datadir

cat sql/init.sql | mysql -u root
cat sql/dummy_data.sql | mysql -u root

echo "Database successfully set up!"

set +e
