package com.shekhargulati.codegolf;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AcronymMakerTest {

    @Test
    public void acronymOfUnitedStatesOfAmericaIsUSA() throws Exception {
        final String input = "United States of America";
        final String acronym = AcronymMaker.acronym(input);
        assertThat(acronym, equalTo("USA"));
    }

    @Test
    public void acronymOfUnitedStatesOfAmericaIsUSA_lowercase() throws Exception {
        final String input = "united states of america";
        final String acronym = AcronymMaker.acronym(input);
        assertThat(acronym, equalTo("USA"));
    }

    @Test
    public void acronymOfLightAmplificationByStimulationOfEmittedRadiationIsLASER() throws Exception {
        final String input = "Light Amplification by Stimulation of Emitted Radiation";
        final String acronym = AcronymMaker.acronym(input);
        assertThat(acronym, equalTo("LASER"));
    }

    @Test
    public void acronymOfJordanOfTheWorldIsJTW() throws Exception {
        final String input = "Jordan Of the World";
        final String acronym = AcronymMaker.acronym(input);
        assertThat(acronym, equalTo("JTW"));
    }

}