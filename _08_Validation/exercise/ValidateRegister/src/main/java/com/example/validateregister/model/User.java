package com.example.validateregister.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    @NotBlank(message = "Tên không được để trống!")
    @Size(min = 2, max = 45, message = "Tên phải có từ 2 đến 45 ký tự!")
    private String firstName;
    @Column
    @NotBlank(message = "Họ không được để trống!")
    @Size(min = 2, max = 45, message = "Họ phải có từ 2 đến 45 ký tự!")
    private String lastName;
    @Column
    @NotBlank(message = "Số điện thoại không được để trống!")
    @Pattern(regexp = "\\d{10}", message = "Số điện thoại nhất định phải 10 số!")
    private String phone;
    @Column
    @NotNull(message = "Trường không được để trống!")
    @Min(value = 18,message = "Tuổi phải lớn hoặc bằng 18!")
    private Integer age;
    @Column
    @NotBlank(message = "Email không được chứa khoảng cách!")
//    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Phải đúng định dạng email!")
    @Email(message = "Phải đúng định dạng Email!")
    private String email;
    @Column
    @NotBlank(message = "Mật khẩu không được để trống!")
    private String password;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String phone, Integer age, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
