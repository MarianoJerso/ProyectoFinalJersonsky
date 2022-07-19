package model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="LINEA")
public class Linea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer lineaid;

    private Integer cantidad;

    private String descripcion;

    private BigDecimal precio;

    //bi-directional many-to-one association to Comprobante
    @ManyToOne
    @JoinColumn(name="comprobanteid")
    private Comprobante comprobante;

    //bi-directional many-to-one association to Producto
    @ManyToOne
    @JoinColumn(name="productoid")
    private Productos producto;

    public Linea() {

    }
    public Linea(Integer lineaid, Integer cantidad, String descripcion, BigDecimal precio, Comprobante comprobante, Productos producto) {
        this.lineaid = lineaid;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precio = precio;
        this.comprobante = comprobante;
        this.producto = producto;
    }

    public Integer getLineaid() {
        return lineaid;
    }

    public void setLineaid(Integer lineaid) {
        this.lineaid = lineaid;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Linea [lineaid=").append(lineaid).append(", cantidad=").append(cantidad).append(", ");
        if (descripcion != null)
            builder.append("descripcion=").append(descripcion).append(", ");
        if (precio != null)
            builder.append("precio=").append(precio);
        builder.append("]");
        return builder.toString();
    }
}
