-- Database: mobiledb

-- DROP DATABASE mobiledb;

CREATE DATABASE mobiledb
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'German_Germany.1252'
       LC_CTYPE = 'German_Germany.1252'
       CONNECTION LIMIT = -1;



-- Table: registration

-- DROP TABLE registration;

CREATE TABLE registration
(
  id serial NOT NULL,
  username varchar(20) NOT NULL,
  email varchar(50) NOT NULL,
  password varchar(20) NOT NULL,
  profilepic bytea,
  CONSTRAINT registration_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE registration
  OWNER TO postgres;
  
  
-- Table: categories

-- DROP TABLE categories;

CREATE TABLE categories
(
  id serial NOT NULL,
  category character(20) NOT NULL,
  CONSTRAINT categories_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE categories
  OWNER TO postgres;
  

 -- Table: attributes

-- DROP TABLE attributes;

CREATE TABLE attributes
(
  id serial NOT NULL,
  userid int NOT NULL,
  acting character(1) NOT NULL,
beard character(1) NOT NULL,
design character(1) NOT NULL,
dinner character(1) NOT NULL,
drink character(1) NOT NULL,
fastfood character(1) NOT NULL,
food character(1) NOT NULL,
freetime character(1) NOT NULL,
gender character(1) NOT NULL,
goingout character(1) NOT NULL,
hair character(1) NOT NULL,
music character(1) NOT NULL,
pet character(1) NOT NULL,
place character(1) NOT NULL,
plant character(1) NOT NULL,
season character(1) NOT NULL,
sports character(1) NOT NULL,
swimming character(1) NOT NULL,
CONSTRAINT attributes_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE attributes
  OWNER TO postgres;

