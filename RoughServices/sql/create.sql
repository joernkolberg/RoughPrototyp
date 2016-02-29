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
  username character(20) NOT NULL,
  email character(50) NOT NULL,
  password character(20) NOT NULL,
  CONSTRAINT registration_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE registration
  OWNER TO postgres;
