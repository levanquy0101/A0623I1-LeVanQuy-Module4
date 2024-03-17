package com.example.validatesong.repository;

import com.example.validatesong.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Long> {
}
