package Entidades;

public class Comprobante {
    private int idcomprobante;
    private TipoComprobante tipo;
    private String fecha;
    private Venta v;
    private String razonsocial;
    private String documento;
    private double total;

    public Comprobante() {
    }

    public Comprobante(int idcomprobante, TipoComprobante tipo, String fecha, Venta v, String razonsocial, String documento, double total) {
        this.idcomprobante = idcomprobante;
        this.tipo = tipo;
        this.fecha = fecha;
        this.v = v;
        this.razonsocial = razonsocial;
        this.documento = documento;
        this.total = total;
    }

    public TipoComprobante getTipo() {
        return tipo;
    }

    public void setTipo(TipoComprobante tipo) {
        this.tipo = tipo;
    }

    public int getIdcomprobante() {
        return idcomprobante;
    }

    public void setIdcomprobante(int idcomprobante) {
        this.idcomprobante = idcomprobante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Venta getV() {
        return v;
    }

    public void setV(Venta v) {
        this.v = v;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
