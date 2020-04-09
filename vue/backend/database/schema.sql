BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS landmarks;

CREATE TABLE users (
  id serial PRIMARY KEY,
  username varchar(255) NOT NULL UNIQUE,     -- Username
  password varchar(32) NOT NULL,      -- Password
  salt varchar(256) NOT NULL,          -- Password Salt
  role varchar(255) NOT NULL default('user')
);

CREATE TABLE landmarks (
  id serial PRIMARY KEY,
  name varchar(255) NOT NULL,
  address varchar(255) NOT NULL,
  zipcode integer NOT NULL,
  city varchar(255) NOT NULL,
  state varchar(255) NOt NULL,
  Latitude integer NOT NULL,
  Longitude Integer NOT NULL,
  Description varchar(255) NOT NULL
);

COMMIT TRANSACTION;
