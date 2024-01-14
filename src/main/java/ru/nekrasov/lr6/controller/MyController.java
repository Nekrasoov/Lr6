package ru.nekrasov.lr6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nekrasov.lr6.entity.Student;
import ru.nekrasov.lr6.model.Response;
import ru.nekrasov.lr6.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> allStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        return ResponseEntity.ok(allStudents);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Студент с id " + id + " не найден");
        }
    }
    @PostMapping("/students")
    public ResponseEntity<Response> saveStudent(@RequestBody Student student) {
        try {
            studentService.saveStudent(student);
            return ResponseEntity.ok(new Response("Студент успешно сохранен"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("Ошибка при сохранении студента"));
        }
    }
    @PutMapping("/students")
    public ResponseEntity<Response> updateStudent(@RequestBody Student student) {
        try {
            studentService.saveStudent(student);
            return ResponseEntity.ok(new Response("Студент успешно обновлен"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("Ошибка при обновлении студента"));
        }
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Response> deleteStudent(@PathVariable("id") int id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok(new Response("Студент успешно удален"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("Ошибка при удалении студента"));
        }
    }
}
