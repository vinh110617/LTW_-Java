package com.example.bai3.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bai3.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, UUID> {
    
    @Query("SELECT r FROM Room r WHERE :keyword IS NULL OR r.roomCode LIKE %:keyword% OR r.roomName LIKE %:keyword%")
    List<Room> searchRooms(@Param("keyword") String keyword);
}