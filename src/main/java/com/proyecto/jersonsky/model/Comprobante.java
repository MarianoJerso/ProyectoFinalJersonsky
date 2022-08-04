package com.proyecto.jersonsky.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

import static javax.persistence.FetchType.*;

@Entity
@Table(name="COMPROBANTES")
public class Comprobante {

    @Id
    @Column(name= "COMPROBANTEID")
    private Integer comprobanteid;

    @Column(name="FECHA")
    private Date fecha;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name="TOTAL")
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name="CLIENTEID")
    private Cliente cliente;

    @OneToMany(mappedBy="comprobante", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Linea> lineas;

    public Comprobante() {

    }

    public Comprobante(Integer comprobanteid, Date fecha, Integer cantidad, BigDecimal total, Cliente cliente) {
        this.comprobanteid = comprobanteid;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.total = total;
        this.cliente = cliente;
    }

    public Integer getComprobanteid() {
        return comprobanteid;
    }

    public void setComprobanteid(Integer comprobanteid) {
        this.comprobanteid = comprobanteid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Linea> getLineas() {
        return this.lineas;
    }

    public void setLineas(Set<Linea> lineas) {
        this.lineas = lineas;
    }

    public Linea addLinea(Linea linea) {
        getLineas().add(linea);
        linea.setComprobante(this);

        return linea;
    }

    public Linea removeLinea(Linea linea) {
        getLineas().remove(linea);
        linea.setComprobante(null);

        return linea;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Comprobante [");
        if (comprobanteid != null)
            builder.append("comprobanteid=").append(comprobanteid).append(", ");
        if (cantidad != null)
            builder.append("cantidad=").append(cantidad).append(", ");
        if (fecha != null)
            builder.append("fecha=").append(fecha).append(", ");
        if (total != null)
            builder.append("total=").append(total).append(", ");
        if (cliente != null)
            builder.append("cliente=").append(cliente).append(", ");
        if (lineas != null)
            builder.append("lineas=").append(lineas);
        builder.append("]");
        return builder.toString();
    }

    public void setFecha(java.util.Date date1) {
    }
}
