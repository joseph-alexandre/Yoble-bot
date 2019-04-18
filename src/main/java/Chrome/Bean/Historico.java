package Chrome.Bean;

public class Historico {
    private String data;
    private String hora;

    public Historico(String data, String hora) {
        this.data = data;
        this.hora = hora;
    }

    public Historico() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
