import java.math.BigDecimal;
import java.sql.Date;

public class Donador {
    private int idDonador;
    private String nombre;
    private String direccion;
    private String categoria;
    private int anioGraduacion;
    private Date fechaGarantiaDonativo;
    private BigDecimal cantidadGarantizada;
    private BigDecimal cantidadEnviada;
    private String metodoPago;
    private int numPagosElegidos;
    private String numTarjetaCredito;
    private String nombreCorporacionEmisora;
    private String direccionCorporacionEmisora;
    private String nombreConyuge;

    // Constructor
    public Donador(int idDonador, String nombre, String direccion, String categoria, int anioGraduacion, Date fechaGarantiaDonativo, BigDecimal cantidadGarantizada, BigDecimal cantidadEnviada, String metodoPago, int numPagosElegidos, String numTarjetaCredito, String nombreCorporacionEmisora, String direccionCorporacionEmisora, String nombreConyuge) {
        this.idDonador = idDonador;
        this.nombre = nombre;
        this.direccion = direccion;
        this.categoria = categoria;
        this.anioGraduacion = anioGraduacion;
        this.fechaGarantiaDonativo = fechaGarantiaDonativo;
        this.cantidadGarantizada = cantidadGarantizada;
        this.cantidadEnviada = cantidadEnviada;
        this.metodoPago = metodoPago;
        this.numPagosElegidos = numPagosElegidos;
        this.numTarjetaCredito = numTarjetaCredito;
        this.nombreCorporacionEmisora = nombreCorporacionEmisora;
        this.direccionCorporacionEmisora = direccionCorporacionEmisora;
        this.nombreConyuge = nombreConyuge;
    }

    // Getters y setters (puedes generarlos automáticamente en tu IDE)

    public int getIdDonador() {
        return idDonador;
    }

    public void setIdDonador(int idDonador) {
        this.idDonador = idDonador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAnioGraduacion() {
        return anioGraduacion;
    }

    public void setAnioGraduacion(int anioGraduacion) {
        this.anioGraduacion = anioGraduacion;
    }

    public Date getFechaGarantiaDonativo() {
        return fechaGarantiaDonativo;
    }

    public void setFechaGarantiaDonativo(Date fechaGarantiaDonativo) {
        this.fechaGarantiaDonativo = fechaGarantiaDonativo;
    }

    public BigDecimal getCantidadGarantizada() {
        return cantidadGarantizada;
    }

    public void setCantidadGarantizada(BigDecimal cantidadGarantizada) {
        this.cantidadGarantizada = cantidadGarantizada;
    }

    public BigDecimal getCantidadEnviada() {
        return cantidadEnviada;
    }

    public void setCantidadEnviada(BigDecimal cantidadEnviada) {
        this.cantidadEnviada = cantidadEnviada;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getNumPagosElegidos() {
        return numPagosElegidos;
    }

    public void setNumPagosElegidos(int numPagosElegidos) {
        this.numPagosElegidos = numPagosElegidos;
    }

    public String getNumTarjetaCredito() {
        return numTarjetaCredito;
    }

    public void setNumTarjetaCredito(String numTarjetaCredito) {
        this.numTarjetaCredito = numTarjetaCredito;
    }

    public String getNombreCorporacionEmisora() {
        return nombreCorporacionEmisora;
    }

    public void setNombreCorporacionEmisora(String nombreCorporacionEmisora) {
        this.nombreCorporacionEmisora = nombreCorporacionEmisora;
    }

    public String getDireccionCorporacionEmisora() {
        return direccionCorporacionEmisora;
    }

    public void setDireccionCorporacionEmisora(String direccionCorporacionEmisora) {
        this.direccionCorporacionEmisora = direccionCorporacionEmisora;
    }

    public String getNombreConyuge() {
        return nombreConyuge;
    }

    public void setNombreConyuge(String nombreConyuge) {
        this.nombreConyuge = nombreConyuge;
    }
}
