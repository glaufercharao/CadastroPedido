CREATE TABLE TB_PEDIDO(
	ID SERIAL,
	UUID_PEDIDO VARCHAR(100),
	PRIMARY KEY (ID), UNIQUE(UUID_PEDIDO)
)