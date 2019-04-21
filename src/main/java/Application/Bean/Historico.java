package Application.Bean;

public class Historico {
    private String data;
    private String hora;
    private String arquivoAtual;

    public Historico(String data, String hora) {
        this.data = data;
        this.hora = hora;
        this.arquivoAtual = arquivoAtual;
    }

    public Historico() {
    }

    public Historico(String arquivoAtual) {
        this.arquivoAtual = arquivoAtual;
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

    public String getArquivoAtual() {
        return arquivoAtual;
    }

    public void setArquivoAtual(String arquivoAtual) {
        this.arquivoAtual = arquivoAtual;
    }
}
