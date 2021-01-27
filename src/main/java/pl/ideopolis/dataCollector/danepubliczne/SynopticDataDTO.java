package pl.ideopolis.dataCollector.danepubliczne;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SynopticDataDTO {


    @JsonProperty("id_stacji")
    private int idStacji;

    @JsonProperty("stacja")
    private String stacja;

    @JsonProperty("data_pomiaru")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataPomiaru;

    @JsonProperty("godzina_pomiaru")
    private int godzinaPomiaru;

    @JsonProperty("temperatura")
    private double temperatura;

    @JsonProperty("predkosc_wiatru")
    private double predkoscWiatru;

    @JsonProperty("kierunek_wiatru")
    private double kierunekWiatru;

    @JsonProperty("wilgotnosc_wzgledna")
    private double wilgotnoscWzgledna;

    @JsonProperty("suma_opadu")
    private double sumaOpadu;

    @JsonProperty("cisnienie")
    private double cisnienie;

    public SynopticDataDTO() {
    }

    public int getIdStacji() {
        return idStacji;
    }

    public String getStacja() {
        return stacja;
    }

    public Date getDataPomiaru() {
        return dataPomiaru;
    }

    public int getGodzinaPomiaru() {
        return godzinaPomiaru;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getPredkoscWiatru() {
        return predkoscWiatru;
    }

    public double getKierunekWiatru() {
        return kierunekWiatru;
    }

    public double getWilgotnoscWzgledna() {
        return wilgotnoscWzgledna;
    }

    public double getSumaOpadu() {
        return sumaOpadu;
    }

    public double getCisnienie() {
        return cisnienie;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nSynopticDataDTO");
        sb.append("\nidStacji: ").append(this.idStacji);
        sb.append("\nstacja: ").append(this.stacja);
        sb.append("\ndataPomiaru: ").append(this.dataPomiaru);
        sb.append("\ngodzinaPomiaru: ").append(this.godzinaPomiaru);
        sb.append("\ntemperatura: ").append(this.temperatura);
        sb.append("\npredkoscWiatru: ").append(this.predkoscWiatru);
        sb.append("\nkierunekWiatru: ").append(this.kierunekWiatru);
        sb.append("\nwilgotnoscWzgledna: ").append(this.wilgotnoscWzgledna);
        sb.append("\nsumaOpadu: ").append(this.sumaOpadu);
        sb.append("\ncisnienie: ").append(this.cisnienie);
        return sb.toString();
    }

}
