6/9
TP CASI TERMINADO, FALTA AGREGAR LA ENTIDAD configuraciongeneral y darle valores en el main, falta agregar recuperacion de entidades y mostrarlas por consola.

Funcionamiento:

Se crearon las entidades con sus respectivas relaciones, TODAS SON UNIDIRECCIONALES. Usuario OneToMany a Pedido, Rubro OneToMany a Producto, Pedido OneToMany a DetallePedido, Pedido OneToOne a factura, Domicilio OneToMany a Pedido, Domicilio ManyToOne a Cliente, DetallePedido ManyToOne a Producto, Cliente OneToMany a Pedido.

Luego en el main (de forma hardcodeada) Se le va dando valor a cada objeto y guardando en su respectivo repositorio. Luego de ejecutar el programa se puede visualizar en la Base de Datos h2 cada tabla con sus respectivos datos.