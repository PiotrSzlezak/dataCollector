package pl.ideopolis.dataCollector.danepubliczne;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "SynopticData")
@Table(name = "synoptic_data")
public class SynopticData {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "id_stacji")
    private int idStacji;

    @Column(name = "stacja")
    private String stacja;

    @Column(name = "data_pomiaru")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataPomiaru;

    @Column(name = "godzina_pomiaru")
    private int godzinaPomiaru;

    @Column(name = "temperatura")
    private double temperatura;

    @Column(name = "predkosc_wiatru")
    private double predkoscWiatru;

    @Column(name = "kierunek_wiatru")
    private double kierunekWiatru;

    @Column(name = "wilgotnosc_wzgledna")
    private double wilgotnoscWzgledna;

    @Column(name = "suma_opadu")
    private double sumaOpadu;

    @Column(name = "cisnienie")
    private double cisnienie;

    public SynopticData() {
    }

    public SynopticData(SynopticDataDTO dto) {
        this.idStacji = dto.getIdStacji();
        this.stacja = dto.getStacja();
        this.dataPomiaru = dto.getDataPomiaru();
        this.godzinaPomiaru = dto.getGodzinaPomiaru();
        this.temperatura = dto.getTemperatura();
        this.predkoscWiatru = dto.getPredkoscWiatru();
        this.kierunekWiatru = dto.getKierunekWiatru();
        this.wilgotnoscWzgledna = dto.getWilgotnoscWzgledna();
        this.sumaOpadu = dto.getSumaOpadu();
        this.cisnienie = dto.getCisnienie();
    }

    public Long getId() {
        return id;
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
    public String toString(){
        StringBuilder sb = new StringBuilder("SynopticDataDTO");
        sb.append("\nid: ").append(this.id);
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
