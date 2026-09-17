package com.example.bai2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    // ==========================================
    // BÀI 2: API với Path Variable (@PathVariable)
    // URL test: http://localhost:8080/api/student/10
    // ==========================================
    @GetMapping("/student/{id}")
    public String getStudentById(@PathVariable int id) {
        return "Sinh viên có mã: " + id;
    }

    // ==========================================
    // BÀI 3: API nhận tham số (@RequestParam)
    // URL test 1: http://localhost:8080/api/student?name=Nam
    // URL test 2: http://localhost:8080/api/searchStudent?name=Nam&age=20
    // ==========================================
    @GetMapping("/student")
    public String greet(@RequestParam String name) {
        return "Xin chào " + name;
    }

    // Hỗ trợ cả gõ chữ hoa (searchStudent) lẫn chữ thường (searchstudent)
    @GetMapping({"/searchstudent", "/searchStudent"})
    public String searchStudent(@RequestParam String name,
                                @RequestParam(defaultValue = "1") int age) {
        return "Tên=" + name + ", tuổi=" + age;
    }

    // ==========================================
    // BÀI 4: Trả về JSON Object & Danh sách (List)
    // URL test 1: http://localhost:8080/api/students
    // URL test 2: http://localhost:8080/api/studentall
    // ==========================================
    @GetMapping("/students")
    public Student getStudent() {
        return new Student(1, "Nguyễn Văn A", 20);
    }

    @GetMapping("/studentall")
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "A", 20));
        list.add(new Student(2, "B", 21));
        return list;
    }

    // ==========================================
    // BÀI 5: Dữ liệu nằm trong Header (@RequestHeader)
    // URL test: http://localhost:8080/api/getstudent
    // ==========================================
    @GetMapping("/getstudent")
    public String getStudentsHeader(@RequestHeader(value = "Authorization", defaultValue = "No Header") String inputstring) {
        return "Authorization = " + inputstring;
    }
}