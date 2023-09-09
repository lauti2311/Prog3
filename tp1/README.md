
Detalles del Codigo:

Se crearon las entidades con sus respectivas relaciones, TODAS SON UNIDIRECCIONALES. Usuario OneToMany a Pedido, Rubro OneToMany a Producto, Pedido OneToMany a DetallePedido, Pedido OneToOne a factura, Domicilio OneToMany a Pedido, Domicilio ManyToOne a Cliente, DetallePedido ManyToOne a Producto, Cliente OneToMany a Pedido.

Luego en el main (de forma hardcodeada) Se le va dando valor a cada objeto y guardando en su respectivo repositorio. Luego de ejecutar el programa se puede visualizar en la Base de Datos h2 cada tabla con sus respectivos datos. Tambien se puede visualizar en consola un pequeño mensaje de "Estoy funcionando" y datos de dos clientes con sus respectivos pedidos.

Funcionamiento:
-Clonar el repositorio tp1
-Abrir el proyecto desde el IntelliJ
-Ejectuar el programa
-Abrir la base de datos H2 mediante el siguiente link: http://localhost:8080/h2-console/
