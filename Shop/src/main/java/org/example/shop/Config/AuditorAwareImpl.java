package org.example.shop.Config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

//인터페이스의 구현체는 Impl를 보통 붙힘
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        //인증정보 Security에서 땡겨오는 메서드
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = "";
        if (authentication != null) {
            userId = authentication.getName();
        }
        return Optional.of(userId);
    }
}
