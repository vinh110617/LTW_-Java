package com.example.bai3.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bai3.entity.Room;
import com.example.bai3.repository.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> searchRooms(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return roomRepository.findAll();
        }
        return roomRepository.searchRooms(keyword);
    }

    public Room getRoomById(UUID id) {
        return roomRepository.findById(id).orElse(null);
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public void deleteRoom(UUID id) {
        roomRepository.deleteById(id);
    }
}