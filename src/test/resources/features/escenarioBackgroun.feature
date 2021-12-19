#language: es
#Autor: Jhonatan Paternina

@HU
Característica: Verificar los productos de la tienda GW
  Como Usuario Quiero ver los productos Para colocarselos a mi bicicleta

  Antecedentes:
    Dado Jhonatan ingresa a la pagina Gwbicycles

  @caso1
  Esquema del escenario: visualiza los productos exitosamente
    Cuando busca los <strProducto> en la pagina Gwbicycles
    Entonces verifica que se visualizen los <strProducto> buscadoss
    Ejemplos:
      | strProducto    |
      | Shorts Leisure |

  @caso2
  Esquema del escenario: visualiza los productos de manera fallida
    Cuando busca los <strProducto> en la pagina Gw
    Entonces verifica que no visualizen los <strProducto> buscado
    Ejemplos:
      | strProducto    |
      | Shorts Leisure |