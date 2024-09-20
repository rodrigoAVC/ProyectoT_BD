-- CRUD de Entidades fuertes con Procedimientos Almacenados:

-- CRUD Tiendas
CREATE PROCEDURE insertTiendas 
	@nombre VARCHAR(30),
	@horario VARCHAR(30)
AS
BEGIN 
	INSERT INTO tiendas(nombre,horario)
	VALUES(@nombre,@horario)
END;

CREATE PROCEDURE updateTiendas
	@idT INT,
	@nombre VARCHAR(30),
	@horario VARCHAR(30)
AS
BEGIN
	UPDATE tiendas
	SET
		nombre = COALESCE(@nombre,nombre),
		horario = COALESCE(@horario,horario)
	WHERE tiendas.idT = @idT
END;

CREATE PROCEDURE deleteTiendas
	@idT INT
AS
BEGIN
	DELETE FROM tiendas
	WHERE tiendas.idT = @idT
END;
	
-- CRUD Clientes
CREATE PROCEDURE insertClientes
	@nombre VARCHAR(50),
	@correo VARCHAR(50)
AS
BEGIN
	INSERT INTO clientes(nombre,correo)
	VALUES(@nombre,@correo)
END;

CREATE PROCEDURE updateClientes
	@idC INT,
	@nombre VARCHAR(50),
	@correo VARCHAR(50)
AS
BEGIN
	UPDATE clientes
	SET
		nombre = COALESCE(@nombre,nombre),
		correo = COALESCE(@correo,correo)
	WHERE clientes.idC = @idC
END;

CREATE PROCEDURE deleteClientes
	@idC INT
AS
BEGIN
	DELETE FROM clientes
	WHERE clientes.idC = @idC
END;

-- CRUD Vendedores
CREATE PROCEDURE insertVendedores
	@nombre VARCHAR(50)
AS
BEGIN
	INSERT INTO vendedores(nombre_vendedor)
	VALUES(@nombre)
END;

CREATE PROCEDURE updateVendedores
	@idV INT,
	@nombre VARCHAR(50)
AS
BEGIN
	UPDATE vendedores 
	SET
		nombre_vendedor = COALESCE(@nombre,nombre_vendedor)
	WHERE vendedores.idV = @idV
END;

CREATE PROCEDURE deleteVendedores
	@idV INT
AS
BEGIN
	DELETE FROM vendedores
	WHERE vendedores.idV = @idV
END;

-- CRUD Productos
CREATE PROCEDURE insertProductos
	@numero INT,
	@nombre VARCHAR(50),
	@tamanio FLOAT ,
	@embalaje VARCHAR(40),
	@marca VARCHAR(20),
	@tipo VARCHAR(30)
AS
BEGIN
	INSERT INTO productos(numero,nombre,tamanio,embalaje,marca,tipo)
	VALUES(@numero,@nombre,@tamanio,@embalaje,@marca,@tipo)
END;

CREATE PROCEDURE updateProductos
	@upc INT,
	@numero INT,
	@nombre VARCHAR(50),
	@tamanio FLOAT ,
	@embalaje VARCHAR(40),
	@marca VARCHAR(20),
	@tipo VARCHAR(30)
AS
BEGIN
	UPDATE productos
	SET
		numero = COALESCE(@numero,numero),
		nombre = COALESCE(@nombre,nombre),
		tamanio = COALESCE(@tamanio,tamanio),
		embalaje = COALESCE(@embalaje,embalaje),
		marca = COALESCE(@marca,marca),
		tipo = COALESCE(@tipo,tipo)

	WHERE productos.upc = @upc
END;

CREATE PROCEDURE deleteProductos
	@upc INT
AS
BEGIN 
	DELETE FROM productos 
	WHERE productos.upc = @upc
END;

-- CRUD Facturas
CREATE PROCEDURE insertarFacturas
	@idT INT,
	@idC INT,
	@fecha DATE,
	@subtotal FLOAT,
	@ISV VARCHAR(30),
	@total FLOAT
AS
BEGIN
	INSERT INTO facturas(idT,idC,fecha,subtotal,ISV,total)
	VALUES(@idT,@idC,@fecha,@subtotal,@ISV,@total)
	DECLARE @numero INT;
    SET @numero = SCOPE_IDENTITY();
    INSERT INTO detalles_facturas(numero)
    VALUES(@numero);
	
END;

CREATE PROCEDURE updateFacturas
	@numero INT,
	@idT INT,
	@idC INT,
	@fecha DATE,
	@subtotal FLOAT,
	@ISV VARCHAR(30),
	@total FLOAT
AS
BEGIN
	UPDATE facturas
	SET
		idT = COALESCE(@idT,idT),
		idC = COALESCE(@idC,idC),
		fecha = COALESCE(@fecha,fecha),
		subtotal= COALESCE(@subtotal,subtotal),
		ISV = COALESCE(@ISV,ISV),
		total = COALESCE(@total,total)
	WHERE facturas.numero = @numero
END;

CREATE PROCEDURE deleteFacturas
	@numero INT
AS
BEGIN
	DELETE FROM facturas
	WHERE facturas.numero = @numero
	DELETE FROM detalles_facturas
	WHERE detalles_facturas.numero = @numero
END;

-- CRUD Ubicaciones
CREATE PROCEDURE insertUbicaciones
	@idT INT,
	@ubicacion VARCHAR(100)
AS
BEGIN
	INSERT INTO ubicaciones(idT,ubicacion)
	VALUES(@idT,@ubicacion)
END;

CREATE Procedure deleteUbicaciones
	@idT INT
AS
BEGIN
	DELETE FROM ubicaciones
	WHERE ubicaciones.idT = @idT
END;

-- CRUD Vende 
CREATE PROCEDURE insertVende
	@idV INT,
	@upc INT
AS
BEGIN
	INSERT INTO vende(idV,upc)
	VALUES(@idV,@upc)
END;

CREATE PROCEDURE deleteVende
	@idV INT,
	@upc INT
AS
BEGIN 
	DELETE FROM vende
	WHERE vende.idV = @idV AND vende.upc = @upc
END;

-- CRUD TIENE
CREATE PROCEDURE insertTiene
	@idT INT,
	@upc INT,
	@precio float,
	@cantidad INT,
	@reordenar VARCHAR(30)
AS
BEGIN
	INSERT INTO tiene(idT,upc,precio,cantidad,reordenar)
	VALUES(@idT,@upc,@precio,@cantidad,@reordenar)
END;

CREATE PROCEDURE updateTiene
	@idT INT,
	@upc INT,
	@precio float,
	@cantidad INT,
	@reordenar VARCHAR(30)
AS
BEGIN
	UPDATE tiene
	SET
		precio = COALESCE(@precio,precio),
		cantidad = COALESCE(@cantidad,cantidad),
		reordenar = COALESCE(@reordenar,reordenar)
	WHERE tiene.idT = @idT AND tiene.upc = @upc
END;

CREATE PROCEDURE deleteTiene
	@idT INT,
	@upc INT
AS
BEGIN
	DELETE FROM tiene
	WHERE tiene.idT = idT AND tiene.upc = upc
END;