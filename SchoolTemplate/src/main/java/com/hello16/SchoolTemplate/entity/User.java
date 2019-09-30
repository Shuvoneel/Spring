package com.hello16.SchoolTemplate.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table
public class User {

    //    Fields Name start..............................................
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Enter Username")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "Enter Password")
    private String password;

    @NotEmpty(message = "Assign Role")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
    //    Fields Name end.........................................

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(User user) {               // This will be used in super(user) of CustomUserDetails
        this.username = user.username;
        this.password = user.password;
        this.roles = user.roles;
    }

    public User(@NotEmpty(message = "Enter Username") String username, @NotEmpty(message = "Enter your password") String password, @NotEmpty(message = "Select your role") Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
