package com.example.modelflow.validation;
import org.springframework.stereotype.Component;import java.util.*;
@Component public class LibertyValidator{
public ValidationResult validate(String s){List<String>e=new ArrayList<>();if(s==null||s.isBlank())e.add("Liberty content is empty");else{if(!s.contains("library"))e.add("Missing library declaration");if(!s.contains("{")||!s.contains("}"))e.add("Unbalanced Liberty block");}return new ValidationResult(e.isEmpty(),e);}}
