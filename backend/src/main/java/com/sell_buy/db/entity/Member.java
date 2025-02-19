package com.sell_buy.db.entity;

import com.sell_buy.db.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member implements UserDetails {
    @Id
    @Column(name = "mem_id")
    private Long memId;
    @Column(name = "img_id")
    private Long imgId;
    @Column(name = "login_id")
    private String loginId;
    private String password;
    @Column(name = "user_name")
    private String name;
    private String nickname;
    private String address;
    private String email;
    @Column(name = "phone_num")
    private String phone;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.ROLE_USER;
    @Column(updatable = false, name = "create_date")
    private LocalDateTime regDate;

    @PrePersist
    public void prePersist() {
        this.regDate = this.regDate == null ? LocalDateTime.now() : this.regDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.loginId;
    }
}
