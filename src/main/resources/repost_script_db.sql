CREATE TABLE orders
(
  id serial NOT NULL,
  title text NOT NULL,
  description text NOT NULL,
  target_link text NOT NULL,
  back_link text NOT NULL,
  CONSTRAINT torder_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE orders
  OWNER TO postgres;