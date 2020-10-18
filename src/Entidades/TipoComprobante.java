package Entidades;

public class TipoComprobante {
    private int idtipocompr;
    private String direccion;
    private String documento;
    private String razon_social;

    public TipoComprobante() {
    }

    public TipoComprobante(int idtipocompr, String direccion, String documento, String razon_social) {
        this.idtipocompr = idtipocompr;
        this.direccion = direccion;
        this.documento = documento;
        this.razon_social = razon_social;
    }

    public int getIdtipocompr() {
        return idtipocompr;
    }

    public void setIdtipocompr(int idtipocompr) {
        this.idtipocompr = idtipocompr;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }
}
