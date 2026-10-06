package com.example.modelflow.validation;
import org.springframework.stereotype.Component;import java.util.*;
@Component public class LefValidator{
public ValidationResult validate(String s){List<String>e=new ArrayList<>();if(s==null||s.isBlank())e.add("LEF content is empty");else{if(!s.contains("MACRO"))e.add("Missing MACRO declaration");if(!s.contains("END"))e.add("Missing END marker");}return new ValidationResult(e.isEmpty(),e);}}
