package com.javastudy.cashbook.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.ToString;

@ToString
public class LoginUserDetails implements UserDetails{
    private static final long serialVersionUID = 1L;
    private String memberId;
    private String memberPw;
    private String memberName;
    private boolean enabled;
    private String rolename;

    // 생성자
    public LoginUserDetails(CashbookMemberDTO dto) {
        this.memberId = dto.getMemberId();
        this.memberPw = dto.getMemberPw();
        this.memberName = dto.getMemberName();
        this.enabled = dto.isEnabled();
        this.rolename = dto.getRolename();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority(){
            private static final long serialVersionUID=1L;
            @Override
            public String getAuthority(){
                return rolename;
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return this.memberPw;
    }

    @Override
    public String getUsername() {
        return this.memberId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    



    
}
