--TRIGGEdatoModificadoRS:

-- Triggers Insert-Update-Delete para Tiendas

CREATE TRIGGER trg_InsertTiendas
ON tiendas
AFTER INSERT
AS
BEGIN
    INSERT INTO bitacora (usuario, tablaModificada, operacion, datoModificado,fecha)
    SELECT 
        SYSTEM_USER, 
        'tiendas', 
        'INSERT', 
        nombre + ', ' + horario,
		GETDATE()
    FROM inserted;
END;

CREATE TRIGGER trg_DeleteTiendas
ON tiendas
AFTER DELETE
AS
BEGIN
    INSERT INTO bitacora (usuario, tablaModificada, operacion, datoModificado, fecha)
    SELECT 
        SYSTEM_USER,
        'tiendas',
        'DELETE',
        COALESCE(nombre, 'Sin Nombre') + ', ' + COALESCE(horario, 'Sin Horario'),
        GETDATE()
    FROM deleted;
END;


CREATE TRIGGER trg_UpdateTiendas
ON tiendas
AFTER UPDATE
AS
BEGIN
    INSERT INTO bitacora (usuario, tablaModificada, operacion, datoModificado, fecha)
    SELECT 
        SYSTEM_USER,
        'tiendas',
        'UPDATE',
        CONCAT('V: ', COALESCE(d.nombre, 'Sin Nombre'), ', N: ', COALESCE(i.nombre, 'Sin Nombre')),
        GETDATE()
    FROM inserted i
    INNER JOIN deleted d ON i.idT = d.idT;
END;

-- Triggers Insert-Update-Delete para Tiendas

CREATE TRIGGER trg_InsertVendedores
ON vendedores
AFTER INSERT
AS
BEGIN
    INSERT INTO bitacora (usuario, tablaModificada, operacion, datoModificado,fecha)
    SELECT 
        SYSTEM_USER, 
        'vendedores', 
        'INSERT', 
        nombre_vendedor,
		GETDATE()
    FROM inserted;
END;

CREATE TRIGGER trg_DeleteVendedores
ON vendedores
AFTER DELETE
AS
BEGIN
    INSERT INTO bitacora (usuario, tablaModificada, operacion, datoModificado, fecha)
    SELECT 
        SYSTEM_USER,
        'vendedores',
        'DELETE',
        COALESCE(nombre_vendedor, 'Sin Nombre'),
        GETDATE()
    FROM deleted;
END;

CREATE TRIGGER trg_UpdateVendedores
ON vendedores
AFTER UPDATE
AS
BEGIN
    INSERT INTO bitacora (usuario, tablaModificada, operacion, datoModificado, fecha)
    SELECT 
        SYSTEM_USER,
        'vendedores',
        'UPDATE',
        CONCAT('V: ', COALESCE(d.nombre_vendedor, 'Sin Nombre'), ', N: ', COALESCE(i.nombre_vendedor, 'Sin Nombre')),
        GETDATE()
    FROM inserted i
    INNER JOIN deleted d ON i.idV = d.idV;
END;

-- Triggers Insert-Update-Delete para Clientes
CREATE TRIGGER trg_InsertClientes
ON clientes
AFTER INSERT
AS
BEGIN
    INSERT INTO bitacora (usuario, tablaModificada, operacion, datoModificado,fecha)
    SELECT 
        SYSTEM_USER, 
        'clientes', 
        'INSERT', 
        nombre,
		GETDATE()
    FROM inserted;
END;

CREATE TRIGGER trg_DeleteClientes
ON clientes
AFTER DELETE
AS
BEGIN
    INSERT INTO bitacora (usuario, tablaModificada, operacion, datoModificado, fecha)
    SELECT 
        SYSTEM_USER,
        'clientes',
        'DELETE',
        COALESCE(nombre, 'Sin Nombre'),
        GETDATE()
    FROM deleted;
END;

CREATE TRIGGER trg_UpdateClientes
ON clientes
AFTER UPDATE
AS
BEGIN
    INSERT INTO bitacora (usuario, tablaModificada, operacion, datoModificado, fecha)
    SELECT 
        SYSTEM_USER,
        'clientes',
        'UPDATE',
        CONCAT('V: ', COALESCE(d.nombre, 'Sin Nombre'), ', N: ', COALESCE(i.nombre, 'Sin Nombre')),
        GETDATE()
    FROM inserted i
    INNER JOIN deleted d ON i.idC = d.idC;
END;

-- Triggers Insert-Update-Delete para Facturas
CREATE TRIGGER trg_InsertFacturas
ON facturas
AFTER INSERT
AS
BEGIN
    INSERT INTO bitacora (usuario, tablaModificada, operacion, datoModificado,fecha)
    SELECT 
        SYSTEM_USER, 
        'facturas', 
        'INSERT', 
        numero,
		GETDATE()
    FROM inserted;
END;

CREATE TRIGGER trg_DeleteFacturas
ON facturas
AFTER DELETE
AS
BEGIN
    INSERT INTO bitacora (usuario, tablaModificada, operacion, datoModificado, fecha)
    SELECT 
        SYSTEM_USER,
        'facturas',
        'DELETE',
        COALESCE(numero, 'Sin Numero'),
        GETDATE()
    FROM deleted;
END;

CREATE TRIGGER trg_UpdateFacturas
ON facturas
AFTER UPDATE
AS
BEGIN
    INSERT INTO bitacora (usuario, tablaModificada, operacion, datoModificado, fecha)
    SELECT 
        SYSTEM_USER,
        'facturas',
        'UPDATE',
        CONCAT('V: ', COALESCE(d.ISV, 'Sin ISV'), ', N: ', COALESCE(i.ISV, 'Sin ISV')),
        GETDATE()
    FROM inserted i
    INNER JOIN deleted d ON i.numero = d.numero;
END;

-- Triggers Insert-Update-Delete para Productos
CREATE TRIGGER trg_InsertProductos
ON productos
AFTER INSERT
AS
BEGIN
    INSERT INTO bitacora (usuario, tablaModificada, operacion, datoModificado,fecha)
    SELECT 
        SYSTEM_USER, 
        'productos', 
        'INSERT', 
        nombre,
		GETDATE()
    FROM inserted;
END;

CREATE TRIGGER trg_DeleteProductos
ON productos
AFTER DELETE
AS
BEGIN
    INSERT INTO bitacora (usuario, tablaModificada, operacion, datoModificado, fecha)
    SELECT 
        SYSTEM_USER,
        'productos',
        'DELETE',
        COALESCE(nombre, 'Sin Nombre'),
        GETDATE()
    FROM deleted;
END;

CREATE TRIGGER trg_UpdateProductos
ON productos
AFTER UPDATE
AS
BEGIN
    INSERT INTO bitacora (usuario, tablaModificada, operacion, datoModificado, fecha)
    SELECT 
        SYSTEM_USER,
        'productos',
        'UPDATE',
        CONCAT('V: ', COALESCE(d.nombre, 'Sin Nombre'), ', N: ', COALESCE(i.nombre, 'Sin Nombre')),
        GETDATE()
    FROM inserted i
    INNER JOIN deleted d ON i.upc = d.upc;
END;

