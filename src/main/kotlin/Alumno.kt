package samples

class Alumno(val nombre: String,val apellido: String,val paso: Boolean,val promedio:Double){
    override fun toString(): String {
        return "Alumno(nombre='$nombre', apellido='$apellido', paso=$paso, promedio=$promedio)"
    }

}
