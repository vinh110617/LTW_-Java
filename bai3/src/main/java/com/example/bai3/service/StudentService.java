package com.example.bai3.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.bai3.entity.Student;
import com.example.bai3.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Lấy toàn bộ danh sách sinh viên
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    // Tìm kiếm theo từ khóa (Nếu rỗng thì lấy tất cả)
    public List<Student> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return studentRepository.findAll();
        }
        return studentRepository.searchStudents(keyword.trim());
    }

    // Lấy thông tin sinh viên theo ID (UUID)
    public Student getById(UUID id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sinh viên với id: " + id));
    }

    // Thêm mới hoặc cập nhật thông tin sinh viên
    public Student save(Student student) {
        if (student.getId() == null && studentRepository.existsByStudentCode(student.getStudentCode())) {
            throw new RuntimeException("Mã sinh viên " + student.getStudentCode() + " đã tồn tại!");
        }
        return studentRepository.save(student);
    }

    // Xóa sinh viên theo ID
    public void delete(UUID id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy sinh viên với id: " + id + " để xóa.");
        }
        studentRepository.deleteById(id);
    }
}