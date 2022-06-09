package fr.univ_amu.iut;

import fr.univ_amu.iut.model.Acteur;
import fr.univ_amu.iut.model.Usage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestModel {
    private static int Null;
    private static final int NULL = Null;
    Usage usageTest = new Usage();
    Acteur acteurTest = new Acteur();
    @Test
    public void should_change_nom() {
        usageTest.setNom("Jérémy");
        assertThat(usageTest.getNom().equals("Jérémy"));
    }

    @Test
    public void should_return_nom() {
        usageTest.setNom("Phyyyz");
        assertThat(usageTest.getNom().equals("Phyyyz"));
    }

    @Test
    public void should_return_id_with_good_increment() {
        assertThat(acteurTest.getId() != Null);
    }
}

