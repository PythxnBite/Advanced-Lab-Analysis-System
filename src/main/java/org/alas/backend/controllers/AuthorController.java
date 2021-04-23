package org.alas.backend.controllers;

import org.alas.backend.documents.Exam;
import org.alas.backend.documents.Module;
import org.alas.backend.services.ModuleService;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final ModuleService moduleService;

    public AuthorController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    /*
     *
     * TODO: Extract All Modules related the author.
     *  input:
     *   authorId - the id of the author making the request
     *  output:
     *   list of modules associated with the author
     *
     * */
    @GetMapping("/modules")
    public ResponseEntity<?> getAllModules(KeycloakPrincipal<KeycloakSecurityContext> principal) {
//        TODO: write logic here.
        String authorId = principal.getKeycloakSecurityContext().getToken().getSubject();

        return new ResponseEntity<>("", HttpStatus.OK);
    }

    /*
     *
     * TODO: Create a new module with the given details
     *  input:
     *   authorId - the id of the author creating the module
     *   moduleName - name of the module
     *   moduleDescription - description of the module
     *   batches - list of batches associated with the module
     *   authors - list of authors associated with the module
     *  output:
     *   if (module created) - 200 OK
     *   else - error
     *
     * */
    @PostMapping("/modules")
    public ResponseEntity<?> createNewModule(KeycloakPrincipal<KeycloakSecurityContext> principal, Module module) {
//        TODO : write logic here
        String authorId = principal.getKeycloakSecurityContext().getToken().getSubject();
        try {
            module.setOriginalAuthor(authorId);
            moduleService.createModule(module);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /*
     *
     * TODO: Return all data associated with the given moduleId
     *  input:
     *   moduleId: ID of the required Module
     *  output:
     *   name: module name
     *   desc: module Description
     *   batches: list of batches associated with the module
     *   originalAuthor: id of original author
     *   authorList: List of authors with their permissions
     *   examsList: List of exams associated with the module
     * */
    @GetMapping("/module/{moduleId}")
    public ResponseEntity<Module> getModuleData(@PathVariable String moduleId, KeycloakPrincipal<KeycloakSecurityContext> principal) {
//        TODO: write logic here
        String authorId = principal.getKeycloakSecurityContext().getToken().getSubject();
        try {
            Module module = moduleService.getModuleForAuthor(moduleId, authorId);
            return new ResponseEntity<>(module, HttpStatus.OK);
        } catch (Exception e) {
            System.err.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /*
     *
     * TODO: Update given module's data
     *  input:
     *   moduleId: Id of the required Module
     *   moduleData: Data object containing changed information(only changed information)
     *  output:
     *   if(updated with no error): 200 OK
     *   else: error
     *
     * */
    @PutMapping("/module/{moduleId}")
    public ResponseEntity<?> updateModuleData(@PathVariable String moduleId, KeycloakPrincipal<KeycloakSecurityContext> principal) {
//        TODO: write logic here
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     *
     * TODO: delete the given module
     *  input:
     *   moduleId: id of the required module
     *   authorId: id of the author making the request
     *  output:
     *   if(author has right and module is deleted without problem): 200 OK
     *   else: error
     *
     * */
    @DeleteMapping("/module/{moduleId}")
    public ResponseEntity<?> deleteModule(@PathVariable String moduleId, KeycloakPrincipal<KeycloakSecurityContext> principal) {
//        TODO: Write logic here
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/exams")
    public ResponseEntity<?> getAllAuthorExams(@RequestParam String authorId, KeycloakPrincipal<KeycloakSecurityContext> principal) {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    /*
     * Create a new Exam
     * */
    @PostMapping("/exams")
    public ResponseEntity<String> createExam(@RequestBody Exam exam, KeycloakPrincipal<KeycloakSecurityContext> principal) {

        return new ResponseEntity<>("Exam Created", HttpStatus.CREATED);
    }

    /*
     *
     * TODO: Review function and refactor
     * */
    @GetMapping("/exams/{examId}")
    public ResponseEntity<?> getExamWithAnswersById(@PathVariable String examId, KeycloakPrincipal<KeycloakSecurityContext> principal) {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    /*
     *
     * TODO: Update exam using given examId
     *  input:
     *   examId: id of the required exam
     *   examData: changed exam data
     *  output:
     *  @return
     *   if(updated properly): 200 OK
     *   else: error
     * */
    @PutMapping("/exam/{examId}")
    public ResponseEntity<?> updateExamByExamId(@PathVariable String examId, KeycloakPrincipal<KeycloakSecurityContext> principal) {
//        TODO: Write logic here
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     *
     * TODO: Delete exam using given examId
     *  input:
     *   examId: id of the required exam
     *  output:
     *   if(deleted properly): 200 OK
     *   else: error
     * */
    @DeleteMapping("/exam/{examId}")
    public ResponseEntity<?> deleteExamByExamId(@PathVariable String examId, KeycloakPrincipal<KeycloakSecurityContext> principal) {
//        TODO: Write logic here
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     *
     * end the exam prematurely
     * */
    @GetMapping("/exams/{examId}/end")
    public ResponseEntity<String> endExam(@PathVariable String examId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}