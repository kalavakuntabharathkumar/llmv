package com.example.modelflow.validation;
import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class ValidatorTest{
@Test void liberty(){assertTrue(new LibertyValidator().validate("library (x) { }").valid());assertFalse(new LibertyValidator().validate("cell(x)").valid());}
@Test void lef(){assertTrue(new LefValidator().validate("MACRO X END X").valid());assertFalse(new LefValidator().validate("VERSION 5.8").valid());}}
