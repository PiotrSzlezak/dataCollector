package pl.ideopolis.dataCollector.logs;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Logs")
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    @Column(name="data_source")
    @Enumerated(EnumType.STRING)
    private DataSource dataSource;

    @Column(name="number_of_new_entries")
    private int numberOfNewEntries;

    public Log() {
    }

    public Log(Date date, DataSource dataSource, int numberOfNewEntries) {
        this.date = date;
        this.dataSource = dataSource;
        this.numberOfNewEntries = numberOfNewEntries;
    }
}
