Kata de Combate RPG
====================

Instrucciones:
———————-
- Hacer la Kata en Kotlin
- Completar cada iteracion sin tener conocimiento de las demas
- Hacer TDD de manera disciplinada
- Aplicar las 4 reglas del diseño simple y los temas que venimos aprendiendo (clean code, SOLID, etc)
- Ser honesto: hacer las iteraciones de a una, no buscar soluciones en internet. La idea es aprender y permitirnos equivocarnos.

Iteracion 1:
—————-
1) Todos los personajes cuando son creados tienen 1000 de salud, nivel 1 y estan vivos.
2) Un personaje puede ejercer daño a otro personaje. El daño se resta de la salud. Cuando el daño supera la salud actual entonces la salud pasa a ser 0 y el personaje muere.
3) Un personaje puede curar a otro personaje. Los personajes muertos no pueden ser curados. La salud no puede superar las 1000 unidades.

Iteracion 2:
—————-
1) Un personaje no se puede hacer daño a si mismo.
2) Un personaje solo se puede curar a si mismo.
3) Cuando se hace daño: 
  - si el atacado tiene 5 o más niveles por encima del nivel del atacante, el daño se reduce en un 50%
  - si el atacado tiene 5 o menos niveles por debajo del nivel del atacante, el daño se incrementa en un 50%

Iteracion 3:
—————-
1) Los personajes tienen un rango maximo de ataque.
2) Los luchadores Melee (cuerpo a cuerpo) tienen un rango de 2 metros.
3) Los luchadores Ranged (a distancia) tienen un rango de 20 metros.
4) Los personajes tienen que estar en rango para poder atacar.

Retrospectiva (Reflexionar y anotar):
—————-—————-——————————-
- Estas pudiendo seguir los requerimientos? Alguna iteracion fue mas dificil?
- Te sentis bien con tu diseño? Es escalable y facil de adaptar a los nuevos requerimientos?
- Esta todo testeado? Te sentis seguro con tu codigo?

Iteracion 4:
—————-
1) Los personajes pueden pertencer a una o más facciones. Los personajes no pertenecen a ninguna faccion cuando se crean.
2) Un personaje se puede unir o abandonar una faccion.
3) Los personajes de la misma faccion son considerados aliados.
4) Los aliados no se pueden dañar entre si.
5) Los aliados se pueden curar entre si.

Iteracion 5:
—————-
1) Los personajes pueden dañar "cosas" que no son personajes (por ej un arbol, una casa, etc.)
2) Las cosas no pueden ser curadas y no hacen daño.
3) Las cosas no pertenecen a facciones, son neutrales.
4) Cuando su salud se reduce a 0 las cosas son destruidas.
5) Por ejemplo se puede crear una cosa llamada "Arbol" con 2000 de salud.

Retrospectiva (Reflexionar y anotar):
—————-—————-—————-——
- Que problemas encontraste?
- Que aprendiste?
