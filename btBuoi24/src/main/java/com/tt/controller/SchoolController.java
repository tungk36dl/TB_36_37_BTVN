package com.tt.controller;


import com.tt.Entity.School;
import com.tt.repository.SchoolRepository;
import com.tt.req.SchoolReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class SchoolController {

    @Autowired // Tự động tạo ra đối tượng productRepo
    private SchoolRepository schoolRepo;

    // Laays
    @GetMapping("getAll")
    public List<School> getAll() {
        List<School> schools = schoolRepo.findAll();
        log.info("\ngetAll");
        return schools;
    }
    // Theem school
    @PostMapping ("save")
    public ResponseEntity<?> saveSchool(@RequestBody SchoolReq schoolReq) {
        School school = new School();
        try {
            school.setSchoolName(schoolReq.getSchoolName());
            school.setAddress(schoolReq.getAddress());
            school.setNumTeacher(schoolReq.getNumTeacher());
            schoolRepo.save(school);
//            log.debug("\n SAVE SCHOOL");
            return new ResponseEntity<>("\nCreate succsess", HttpStatus.OK);
        } catch (Exception e) {
//            log.debug("\n SAVE SCHOOL ERROR \n");
            log.error(e.toString());
        }
        return new ResponseEntity<>("\n Save error" ,HttpStatus.BAD_REQUEST);
    }

    @PutMapping ("edit/{id}")
    public ResponseEntity<?> editSchool(@RequestParam Integer id, @RequestBody SchoolReq schoolReq) {
        School school = schoolRepo.findById(id).orElse(null);

        if(school != null) {
            try {
                school.setSchoolName(schoolReq.getSchoolName());
                school.setAddress(schoolReq.getAddress());
                school.setNumTeacher(schoolReq.getNumTeacher());
                schoolRepo.save(school);
                log.debug("\n EDIT SCHOOL successfully");
                return new ResponseEntity<>("\nEdit succsess" , HttpStatus.OK);
            }catch (Exception e) {
                log.error(e.toString());
            }
        }

        log.error("\nKhong timf thay id");
        return new ResponseEntity<>("\nEdit error" , HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteSchool(@RequestParam Integer id) {
            School school = schoolRepo.findById(id).orElse(null);
            if(school != null) {
                schoolRepo.delete(school);
                log.error("\n DELETE SCHOOL");
                return new ResponseEntity<>("\nDelete succsess", HttpStatus.OK);
            }

            log.error("\nKhong thay id");
            return new ResponseEntity<>("\nDelete error", HttpStatus.BAD_REQUEST);
    }



}
