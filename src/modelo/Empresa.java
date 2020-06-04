package modelo;

public class Empresa extends Cliente{
    private String nit;
    private String nombreEmpresa;
    private String seccionComerial;


    public Empresa() {

    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombre) {
        this.nombreEmpresa = nombre;
    }

    public String getSeccionComerial() {
        return seccionComerial;
    }

    public void setSeccionComerial(String seccionComerial) {
        this.seccionComerial = seccionComerial;
    }
}
