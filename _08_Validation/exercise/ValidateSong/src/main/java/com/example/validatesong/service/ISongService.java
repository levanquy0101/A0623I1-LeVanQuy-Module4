package com.example.validatesong.service;

import com.example.validatesong.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
}
