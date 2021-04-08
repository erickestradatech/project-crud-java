package modelo;

public class Empleado {

    private String code;
    private String nome;
    private int hora;
    private double tar;

    public Empleado() {

    }

    public Empleado(String code, String nome, int hora, double tar) {
        this.code = code;
        this.nome = nome;
        this.hora = hora;
        this.tar = tar;
    }

    public double sbruto() {
        return hora * tar;
    }

    public double afp() {
        return sbruto() * 0.11;
    }

    public double total() {
        return sbruto() - afp();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public double getTar() {
        return tar;
    }

    public void setTar(double tar) {
        this.tar = tar;
    }

}
