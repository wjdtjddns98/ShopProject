package org.example.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(value = {AuditingEntityListener.class}) //Jpa에게 해당 Entity는 Auditing 기능을 사용한다는것을 알림 (감시)
@MappedSuperclass // 상속받는 클래스에게 매핑 정보만 제공
@Getter
@Setter
public abstract class BaseTimeEntity {

    @CreatedDate
    @Column(updatable = false) // 해당 필드를 업데이트 할 수 없다
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column
    private LocalDateTime updateDate;

}
