package com.example.bai3.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bai3.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    // Tìm kiếm sinh viên theo từ khóa (mã SV, họ tên, email, SĐT)
    @Query("SELECT s FROM Student s WHERE " +
           ":kw IS NULL OR :kw = '' OR " +
           "LOWER(s.studentCode) LIKE LOWER(CONCAT('%', :kw, '%')) OR " +
           "LOWER(s.fullName) LIKE LOWER(CONCAT('%', :kw, '%')) OR " +
           "LOWER(s.email) LIKE LOWER(CONCAT('%', :kw, '%')) OR " +
           "LOWER(s.phone) LIKE LOWER(CONCAT('%', :kw, '%'))")
    List<Student> searchStudents(@Param("kw") String keyword);

    // Kiểm tra trùng mã sinh viên khi thêm mới
    boolean existsByStudentCode(String studentCode);
}