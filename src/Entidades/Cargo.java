package Entidades;

public class Cargo {
    private int idcargo;
    private String Cargo;

    public Cargo() {
    }

    public Cargo(int idcargo, String Cargo) {
        this.idcargo = idcargo;
        this.Cargo = Cargo;
    }

    public int getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }
}
