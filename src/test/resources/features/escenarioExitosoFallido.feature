#language: es
#Autor: Jhonatan Paternina
@HU
Característica: Verificar los productos de la tienda GW
  Como Usuario Quiero ver los productos Para colocarselos a mi bicicleta

  @caso1
  Escenario: visualiza los productos exitosamente
    Dado que Jhonatan ingresa a la tienda GW
    Cuando busca los productos GW
    Entonces verifica que se visualizen los productos buscados


  @caso2
  Escenario: visualiza los productos de manera fallida
    Dado que Jhonatan ingresa a la tienda GWBisicleta
    Cuando busca los productos de la tienda GW
    Entonces verifica que no visualizen los productos buscados