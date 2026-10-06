package com.example.modelflow.api;
import com.example.modelflow.model.*;import com.example.modelflow.validation.*;import org.springframework.http.*;import org.springframework.web.bind.annotation.*;import java.util.*;
@RestController @RequestMapping("/api") public class ModelController{
final LibertyValidator lv;final LefValidator fv;final ModelReleaseRepository repo;final CharacterizationJobRunner jobs;
public ModelController(LibertyValidator l,LefValidator f,ModelReleaseRepository r,CharacterizationJobRunner j){lv=l;fv=f;repo=r;jobs=j;}
@GetMapping("/health") public Map<String,String> health(){return Map.of("status","UP");}
@GetMapping("/models") public List<ModelRelease> models(){return repo.findAll();}
@PostMapping("/models/validate") public ResponseEntity<?> validate(@RequestBody ValidationRequest q){
var l=lv.validate(q.libertyContent());var f=fv.validate(q.lefContent());String s=l.valid()&&f.valid()?"APPROVED":"REJECTED";
var saved=repo.save(new ModelRelease(q.macroName(),s,l.valid(),f.valid()));String job=s.equals("APPROVED")?jobs.submit(q.macroName()):"not-submitted";
return ResponseEntity.ok(Map.of("release",saved,"libertyErrors",l.errors(),"lefErrors",f.errors(),"characterizationJob",job));}
@GetMapping("/releases/{id}") public ResponseEntity<ModelRelease> get(@PathVariable Long id){return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}}
