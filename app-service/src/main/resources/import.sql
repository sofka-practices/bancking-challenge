--TABLA PERSONA
INSERT INTO t_personas (apellido, direccion, genero, nombre, tipo_documento, telefono, numero_documento) VALUES ('Lema', 'Otavalo sn y principal', 'Masculino', 'Jose', 'Cedula Ciudadania', '098254785', '10236547');
INSERT INTO t_personas (apellido, direccion, genero, nombre, tipo_documento, telefono, numero_documento) VALUES ('Apellido_test', 'Direccion_1 test', 'Femenino', 'Nombre_1', 'Cedula Ciudadania', '091254785', '20236547');
INSERT INTO t_personas (apellido, direccion, genero, nombre, tipo_documento, telefono, numero_documento) VALUES ('Apellido_test_2', 'Direccion_test_1', 'Masculino', 'Nombre_2', 'Cedula Extranejeria', '099254789', '30236547');
INSERT INTO t_personas (apellido, direccion, genero, nombre, tipo_documento, telefono, numero_documento) VALUES ('Apellido_test_3', 'Direccion_test_2', 'Femenino', 'Nombre_3', 'Tarjeta Identidad', '039254783', '1002345678');
INSERT INTO t_personas (apellido, direccion, genero, nombre, tipo_documento, telefono, numero_documento) VALUES ('Apellido_test_4', 'Direccion_test_3', 'Masculino', 'Nombre_4', 'Cedula Extranejeria', '059254785', '1001345678');

--TABLA CLIENTES
INSERT INTO t_clientes (password, usuario, id_persona, estado) VALUES ('1234', 'dApellido_test', 2, 'ACTIVO');
INSERT INTO t_clientes (password, usuario, id_persona, estado) VALUES ('1234', 'nApellido_test_2', 3, 'INACTIVO');
INSERT INTO t_clientes (password, usuario, id_persona, estado) VALUES ('1234', 'nApellido_test_3', 4, 'INACTIVO');
INSERT INTO t_clientes (password, usuario, id_persona, estado) VALUES ('1234', 'nApellido_test_4', 5, 'ACTIVO');
INSERT INTO t_clientes (password, usuario, id_persona, estado) VALUES ('1234', 'jlema', 1, 'ACTIVO');

--TABLA CUENTAS
INSERT INTO t_cuentas (estado_cuenta, numero_cuenta, saldo_actual, tipo_cuenta, id_cliente) VALUES ('ACTIVO', '178758', '100000', 'AHORRO', 1);
INSERT INTO t_cuentas (estado_cuenta, numero_cuenta, saldo_actual, tipo_cuenta, id_cliente) VALUES ('INACTIVO', '978759', '100000', 'CORRIENTE', 2);
INSERT INTO t_cuentas (estado_cuenta, numero_cuenta, saldo_actual, tipo_cuenta, id_cliente) VALUES ('BLOQUEADO', '878758', '1000000', 'AHORRO', 3);
INSERT INTO t_cuentas (estado_cuenta, numero_cuenta, saldo_actual, tipo_cuenta, id_cliente) VALUES ('ACTIVO', '778757', '20000000', 'CORRIENTE', 4);
INSERT INTO t_cuentas (estado_cuenta, numero_cuenta, saldo_actual, tipo_cuenta, id_cliente) VALUES ('ACTIVO', '678756', '0', 'AHORRO', 5);

--TABLA MOVIMIENTOS
INSERT INTO t_movimientos (fecha_movimiento, saldo, saldo_anterior, tipo_movimiento, valor_movimiento, id_cuenta) VALUES ('2023-01-01', '100000', '100000', 'DEBITO', '50000', 1);
INSERT INTO t_movimientos (fecha_movimiento, saldo, saldo_anterior, tipo_movimiento, valor_movimiento, id_cuenta) VALUES ('2023-02-01', '100000', '100000', 'CREDITO', '50000', 2);
INSERT INTO t_movimientos (fecha_movimiento, saldo, saldo_anterior, tipo_movimiento, valor_movimiento, id_cuenta) VALUES ('2023-03-01', '1000000', '1000000', 'DEBITO', -50000, 3);
INSERT INTO t_movimientos (fecha_movimiento, saldo, saldo_anterior, tipo_movimiento, valor_movimiento, id_cuenta) VALUES ('2023-01-02', '20000000', '20000000', 'CREDITO', '50000', 4);
INSERT INTO t_movimientos (fecha_movimiento, saldo, saldo_anterior, tipo_movimiento, valor_movimiento, id_cuenta) VALUES ('2023-01-03', '0', '0', 'DEBITO', '50000', 5);