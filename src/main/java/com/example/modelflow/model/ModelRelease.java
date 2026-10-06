package com.example.modelflow.model;
import jakarta.persistence.*;import java.time.Instant;
@Entity public class ModelRelease{
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id; String macroName,status; boolean libertyValid,lefValid; Instant createdAt=Instant.now();
public ModelRelease(){} public ModelRelease(String m,String s,boolean l,boolean f){macroName=m;status=s;libertyValid=l;lefValid=f;}
public Long getId(){return id;} public String getMacroName(){return macroName;} public String getStatus(){return status;} public boolean isLibertyValid(){return libertyValid;} public boolean isLefValid(){return lefValid;} public Instant getCreatedAt(){return createdAt;}}
