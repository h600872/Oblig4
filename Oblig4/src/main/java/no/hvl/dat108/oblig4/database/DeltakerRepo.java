package no.hvl.dat108.oblig4.database;

import no.hvl.dat108.oblig4.model.Deltaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeltakerRepo extends JpaRepository<Deltaker, String> {
    Deltaker findDeltakerByMobilnummer(String id);
}
