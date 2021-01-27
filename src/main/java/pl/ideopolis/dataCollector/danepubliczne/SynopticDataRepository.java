package pl.ideopolis.dataCollector.danepubliczne;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface SynopticDataRepository extends JpaRepository<SynopticData, Long> {

    @Query("SELECT d " +
            "FROM SynopticData d " +
            "WHERE ((d.idStacji = ?1) AND " +
            "(d.dataPomiaru = ?2) AND " +
            "(d.godzinaPomiaru = ?3))")
    Optional<SynopticData> findMatchingEntry(int idStacji, Date dataPomiaru, int godzinaPomiaru);

}
