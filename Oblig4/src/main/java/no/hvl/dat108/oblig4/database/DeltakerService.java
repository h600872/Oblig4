package no.hvl.dat108.oblig4.database;

import no.hvl.dat108.oblig4.model.Deltaker;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeltakerService {
    private final DeltakerRepo deltakerRepo;

    public DeltakerService(DeltakerRepo deltakerRepo) {
        this.deltakerRepo = deltakerRepo;
    }

    public Deltaker hentDeltaker(String mobilnummer) {
        return deltakerRepo.findDeltakerByMobilnummer(mobilnummer);
    }

    public boolean deltakerFinnes(Deltaker deltaker) {
        return deltakerRepo.findDeltakerByMobilnummer(deltaker.getMobilnummer()) != null;
    }

    public boolean deltakerFinnes(String mobilnummer) {
        return hentDeltaker(mobilnummer) != null;
    }

    public void leggTilDeltaker(Deltaker deltaker) {
        deltakerRepo.save(deltaker);
    }

    public List<Deltaker> hentAlleDeltakere() {
        return deltakerRepo.findAll().stream().sorted((o1, o2) -> {
            int compare = o1.getFornavn().compareTo(o2.getFornavn());
            if (compare == 0) {
                return o1.getEtternavn().compareTo(o2.getEtternavn());
            }
            return compare;
        }).toList();
    }
}
