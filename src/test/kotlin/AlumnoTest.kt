import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import samples.Alumno

class AlumnoTest {


    @Test
    fun `alumno_creation`() {
        val alumno = Alumno("Pablo", "Tapia", true, 6.5)
        assertEquals("Pablo", alumno.nombre)
        assertEquals("Tapia", alumno.apellido)
        assertTrue(alumno.paso)
        assertEquals(6.5, alumno.promedio)
    }

    @Test
    fun `filtrado`() {
        val alumno = Alumno("Pablo", "Tapia", false, 6.5)
        val alumno1 = Alumno("Pedro", "Aznar", true, 7.5)
        val alumno2 = Alumno("Alicia", "Aznar", true, 9.5)
        val alumno3 = Alumno("rrr", "rrrr", true, 8.5)
        val alumno4 = Alumno("eeee", "eeee", true, 3.5)
        val alumno6 = Alumno("sss", "sss", true, 1.5)
        val alumno7 = Alumno("Benjamin", "Menendez", true, 10.5)
        val alumno8 = Alumno("Bonjamin", "Menendez", true, 10.5)
        val alumnos = listOf(alumno, alumno1, alumno2, alumno3, alumno4, alumno6, alumno7,alumno8)


        val aprobadosYPromedioMayor4 = alumnos.filter { it.paso && it.promedio > 4 }
        val ordenadosPorApellidoYNombre = aprobadosYPromedioMayor4.sortedWith(compareBy({ it.apellido }, { it.nombre }))
        println(ordenadosPorApellidoYNombre.take(10))

    }
}

