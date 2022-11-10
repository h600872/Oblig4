package no.hvl.dat108.oblig4;

import no.hvl.dat108.oblig4.Util.InnloggingUtil;
import no.hvl.dat108.oblig4.Util.PassordUtil;
import no.hvl.dat108.oblig4.database.DeltakerRepo;
import no.hvl.dat108.oblig4.database.DeltakerService;
import no.hvl.dat108.oblig4.model.Deltaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Tests {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @InjectMocks
    DeltakerService ps;

    @Mock
    DeltakerRepo pr;

    @Autowired
    MockHttpSession session;



    /**********************************************************************************************************/
    // Test nr.1

    @Test
    void sjekkerOmDeltakerFinnesMedMobilnummer() {

        //Arrange
        when(pr.findDeltakerByMobilnummer("12345678")).thenReturn(
                new Deltaker("Arne", "Berge", "12345678", "popkorn", "mann"));

        //Act
        Deltaker deltaker1 = ps.hentDeltaker("12345678");
        boolean finnes = ps.deltakerFinnes(deltaker1);

        //Assert
        assertTrue(finnes);
    }


    /**********************************************************************************************************/
    // Test nr.2
    // Tester om ugyldig fornavn er ugyldig med harGyldig hjelpemetode

    @Test
    void erFornavnUgyldig() {

        //Arrange
        Deltaker deltaker1 = new Deltaker("arne", "Berge", "12345678", "popkorn", "mann");

        assertFalse(harGyldig("fornavn", deltaker1));
    }


    /**********************************************************************************************************/
    // Test nr.3
    // Tester om metoden hentAlleDeltakere får tak i alle deltakerne

    @Test
    void fårTakIAlleDeltakere() {
        Deltaker deltaker1 = new Deltaker("Arne", "Berge", "12345678", "popkorn", "mann");
        Deltaker deltaker2 = new Deltaker("Tora", "Jensen", "56738234", "MittMacPassord", "kvinne");
        Deltaker deltaker3 = new Deltaker("Lars", "Petter", "35435672", "filmkveld", "mann");

        when(pr.findAll()).thenReturn(List.of(
                deltaker1,
                deltaker2,
                deltaker3
        ));

        List<Deltaker> deltakere = ps.hentAlleDeltakere();

        assertEquals(3, deltakere.size());
        assertTrue(deltakere.contains(deltaker1));
    }


    /**********************************************************************************************************/
    // Test nr.4
    // Tester om ugyldig kjønn er ugyldig med hjelpemetoden erGyldig

    @Test
    void erKjonnUgyldig() {

        //Arrange
        Deltaker deltaker1 = new Deltaker("Arne", "Berge", "12345678", "popkorn", "delfin");

        assertFalse(harGyldig("kjonn", deltaker1));
    }


    /**********************************************************************************************************/
    // Test nr.5
    // Tester at me får IllegalArgumentException på passord eller salt = null
    @Test
    void ThrowsArgumentExceptionTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> PassordUtil.hashMedSalt(null, null));

    }

    /**********************************************************************************************************/

    // Hjelpemetode
    private boolean harGyldig(String feltnavn, Deltaker deltaker) {
        List<String> ugyldigeFelt = validator.validate(deltaker).stream()
                .map(v -> v.getPropertyPath().toString())
                .toList();

        return !ugyldigeFelt.contains(feltnavn);
    }

}
