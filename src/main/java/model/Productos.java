package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name="PRODUCTOS")
public class Productos {

    @Id
    @Column(name= "PRODUCTOID")
    private Integer productoid;

    @Column(name="CODIGO")
    private Integer codigo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name="CANTIDAD")
    private Integer cantidad;

    @Column(name="PRECIO")
    private BigDecimal precio;

    //********************
    //** CONSTRUCTORES  **
    //********************

    public Productos() {}


    public Productos(Integer productoid, Integer codigo, String descripcion, Integer cantidad, BigDecimal precio) {
        this.productoid = productoid;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    //**********************
    //** GETTERS SETTERS  **
    //**********************


    public Integer getProductoid() {
        return productoid;
    }

    public void setProductoid (Integer productoid) {
        this.productoid = productoid;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}


