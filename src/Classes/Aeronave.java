package Classes;

import java.util.ArrayList;
import java.util.List;

public class Aeronave {
    private String modelo;
    private String numeroSerie;
    private List<Piloto> pilotos;

    public Aeronave(String modelo, String numeroSerie) {
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.pilotos = new ArrayList<>();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public void adicionarPiloto(Piloto piloto) {
        this.pilotos.add(piloto);
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo + ", Número de Série: " + numeroSerie + ", Pilotos: " + pilotos;
    }
}
