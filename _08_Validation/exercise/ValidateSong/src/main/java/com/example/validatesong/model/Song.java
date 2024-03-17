package com.example.validatesong.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    @NotBlank(message = "Trường không được để trống!")
    @Size(max = 800, message = "Tên không vượt quá 800 ký tự!")
    @Pattern(regexp = "^[a-zA-Z0-9]*$" ,message = "Không được chứa ký tự đặc biệt!")
    private String nameSong;
    @Column
    @NotBlank(message = "Trường không được để trống!")
    @Size(max = 300, message = "Tên không vượt quá 300 ký tự!")
    @Pattern(regexp = "^[a-zA-Z0-9]*$" ,message = "Không được chứa ký tự đặc biệt!")
    private String artist;
    @Column
    @NotBlank(message = "Trường không được để trống!")
    @Size(max = 1000, message = "Tên không vượt quá 1000 ký tự!")
    @Pattern(regexp = "^[a-zA-Z0-9,]+$" ,message = "Không được chứa ký tự đặc biệt!")
    private String categoryMusic;

    public Song() {
    }

    public Song(Long id, String nameSong, String artist, String categoryMusic) {
        this.id = id;
        this.nameSong = nameSong;
        this.artist = artist;
        this.categoryMusic = categoryMusic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategoryMusic() {
        return categoryMusic;
    }

    public void setCategoryMusic(String categoryMusic) {
        this.categoryMusic = categoryMusic;
    }
}

