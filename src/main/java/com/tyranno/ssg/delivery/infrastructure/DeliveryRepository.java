package com.tyranno.ssg.delivery.infrastructure;

import com.tyranno.ssg.delivery.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByUsersUuid(String uuid);

    Optional<Delivery> findByIsBaseDelivery(Byte isBaseDelivery);
}
