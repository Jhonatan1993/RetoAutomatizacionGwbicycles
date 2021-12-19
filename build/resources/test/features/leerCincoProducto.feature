#language:es
#Autor: Jhonatan Paternina Rojas

@HU
Característica: HU-001 Buscar productos en gwbicycles
  yo como usuario de gwbicycles
  quiero buscar cinco productos para ver los nombres en pantalla

  @scenario1
  Esquema del escenario: Buscar productos
    Dado que me encuentro en la pagina de Gwbicycles
    Cuando busque los <strProducto>
    Entonces podre ver los <strProducto> en pantalla
    Ejemplos:
      | strProducto |
      | Shorts Leisure                        |
      | Camisilla Interior Spider             |
      | Pantaloneta Plug Sport Sin Cargaderas |
      | Medias Colombia                       |
      | Chaqueta Camo Reflective              |
