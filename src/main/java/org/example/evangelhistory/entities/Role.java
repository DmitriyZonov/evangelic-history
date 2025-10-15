package org.example.evangelhistory.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    Set<User> users;

    public Role(){
    }
    public Role(@NotNull Long id){
        this.id = id;
    }
    public String getAuthority() {
        return getName();
    }
}
