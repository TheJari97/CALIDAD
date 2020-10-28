package Entidades;

public class Usuario {
    private int idusuario;
    private String nombre;
    private String apellido;
    private String documento;
    private int edad;
    private String telefono;
    private String password;
    private Cargo cargo;

    public Usuario() {
    }

    public Usuario(int idusuario, String nombre, String apellido, String documento, int edad, String telefono, String password, Cargo cargo) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.edad = edad;
        this.telefono = telefono;
        this.password = password;
        this.cargo = cargo;
    }

    public Usuario(int idusuario, String nombre, String apellido) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
}
