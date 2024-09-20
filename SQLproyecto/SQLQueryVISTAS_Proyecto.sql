-- Vistas

-- Inventario
CREATE VIEW vista_Inventario AS
SELECT t.nombre AS NombreTienda, p.nombre AS NombreProducto, ti.cantidad AS Cantidad, ti.precio AS Precio
FROM tiene AS ti
INNER JOIN tiendas t ON ti.idT = t.idT
INNER JOIN productos p ON ti.upc = p.upc;

-- Compras por cliente
CREATE VIEW vista_ComprasPorCliente AS
SELECT 
	c.nombre AS NombreCliente,
	c.idC AS idCliente,
	COUNT(numero) AS NumeroCompras
FROM  facturas f INNER JOIN clientes c ON f.idC = c.idC
GROUP BY c.idC, c.nombre;

-- Historial de ventas por tienda
CREATE VIEW vista_HistorialVentasxTienda AS
SELECT
	t.nombre AS NombreTienda,
	t.idT AS idTienda,
	COUNT(f.total) AS NumeroVentas
FROM facturas f INNER JOIN tiendas t ON f.idT = t.idT
GROUP BY t.idT, t.nombre;

-- 5 tiendas con mas ventas en lo que va del año 
CREATE VIEW vista_Top5TiendasConMasVentas AS
SELECT 
    TOP 5 t.nombre AS NombreTienda,
    SUM(f.total) AS TotalVentas
FROM 
    facturas f
    INNER JOIN tiendas t ON f.idT = t.idT
WHERE 
    YEAR(f.fecha) = YEAR(GETDATE()) 
GROUP BY 
    t.nombre
ORDER BY 
    TotalVentas DESC;  


-- Top 20 productos por tienda
CREATE VIEW vista_Top20ProductsPorTienda AS
WITH ventasProducto AS (
    SELECT 
        t.idT,                          
        t.nombre AS Tienda,             
        p.nombre AS Producto,           
        SUM(f.numero) AS TotalVentas 
    FROM 
        tiendas t
    INNER JOIN 
        facturas f ON t.idT = f.idT   
    INNER JOIN 
        productos p ON f.numero = p.numero   
    GROUP BY 
        t.idT, t.nombre, p.nombre       
)
SELECT 
    Tienda, 
    Producto, 
    TotalVentas
FROM (
    SELECT 
        Tienda, 
        Producto, 
        TotalVentas, 
        ROW_NUMBER() OVER (PARTITION BY Tienda ORDER BY TotalVentas DESC) AS Ranking
    FROM 
        ventasProducto
) AS RankedVentas
WHERE 
    Ranking <= 20;  

-- Productos más vendidos a parte de computadoras
CREATE VIEW vista_Top3ProductosNoComputadora AS
WITH TiposProducto AS (
    SELECT DISTINCT
        p.tipo AS TipoProducto,
        SUM(f.numero) AS TotalVentas
    FROM 
        productos p
    INNER JOIN 
        facturas f ON p.numero = f.numero
    WHERE 
        p.nombre != 'Computadora'  
    GROUP BY 
        p.tipo
)
SELECT 
    TipoProducto, 
    TotalVentas
FROM (
    SELECT 
        TipoProducto, 
        TotalVentas, 
        ROW_NUMBER() OVER (ORDER BY TotalVentas DESC) AS Ranking
    FROM 
        TiposProducto
) AS RankedProductos
WHERE 
   Ranking <= 3;

-- Tiendas donde se vende más PS5 que XBOX
CREATE VIEW vw_CocaColaVsPepsi AS
WITH ComparacionVentas AS (
    SELECT 
        t.nombre AS Tienda, 
        p.nombre AS Producto,
        SUM(f.numero) AS TotalVentas
    FROM 
        tiendas t
    INNER JOIN 
        facturas f ON t.idT = f.idT
    INNER JOIN 
        detalles_facturas df ON f.numero = df.numero
    INNER JOIN 
        productos p ON df.numero = p.numero
    WHERE 
        p.nombre IN ('PS5', 'XBOX')  
    GROUP BY 
        t.nombre, p.nombre
)
SELECT 
    Tienda,
    SUM(CASE WHEN Producto = 'PS5' THEN TotalVentas ELSE 0 END) AS CocaColaVentas,
    SUM(CASE WHEN Producto = 'XBOX' THEN TotalVentas ELSE 0 END) AS PepsiVentas,
    CASE 
        WHEN SUM(CASE WHEN Producto = 'PS5' THEN TotalVentas ELSE 0 END) > 
             SUM(CASE WHEN Producto = 'XBOX' THEN TotalVentas ELSE 0 END) 
        THEN 'PS5'
        ELSE 'XBOX'
    END AS MasVendido
FROM 
    ComparacionVentas
GROUP BY 
    Tienda;




