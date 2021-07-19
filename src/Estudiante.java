
public class Estudiante {
    
    private int identificacion;
    private String nombre;
    private String carrera;
    private double promedio;
    
    public Estudiante(){
    
    }
    
    public Estudiante (int identificacion, String nombre, String carrera, double promedio) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "identificacion=" + identificacion + ", nombre=" + nombre + ", carrera=" + carrera + ", promedio=" + promedio + '}';
    }
    
    
    
}

