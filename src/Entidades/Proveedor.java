package Entidades;

public class Proveedor {

    private int idproveedor;
    private String proveedor;

    public Proveedor() {
    }

    public Proveedor(int idproveedor, String proveedor) {
        this.idproveedor = idproveedor;
        this.proveedor = proveedor;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
}
