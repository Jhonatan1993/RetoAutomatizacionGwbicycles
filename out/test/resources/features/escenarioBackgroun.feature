#language: es
#Autor: Jhonatan Paternina

@HU
Característica: Verificar los productos de la tienda GW
  Como Usuario Quiero ver los productos Para colocarselos a mi bicicleta

  Antecedentes:
    Dado Jhonatan ingresa a la pagina Gwbicycles

  @caso1
  Escenario: visualiza los productos exitosamente
    Cuando busca los (.*) en la pagina Gwbicycles
    Entonces verifica que se visualizen los (.*) buscadoss

      | strProducto    |
      | Shorts Leisure |

  @caso2
  Escenario: visualiza los productos de manera fallida
    Cuando busca los (.*) en la pagina Gwbicycles
    Entonces verifica que no visualizen los (.*) buscado
      | strProducto   |
      | Shorts Leisur |