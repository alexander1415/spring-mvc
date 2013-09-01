-- CREATE DATABASE dbspring

DROP TABLE IF EXISTS customer;

CREATE TABLE customer
(
  id numeric(10) NOT NULL,
  name character varying(100),
  CONSTRAINT customer_pkey PRIMARY KEY (id)
);

DROP SEQUENCE IF EXISTS seq_customer;
CREATE SEQUENCE seq_customer INCREMENT 1 MINVALUE 1 MAXVALUE 9999999999 START 1 CACHE 1;

ALTER TABLE  customer ALTER COLUMN  id SET DEFAULT nextval('seq_customer'::regclass);

INSERT INTO customer (name) VALUES
	('Warner Penckaps')
	,('Juan Perez')
	,('Milpo Torino')
	,('Julian Legaspi');

--SELECT * FROM customer;