package com.tyranno.ssg.option.infrastucture;

import com.tyranno.ssg.option.domain.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long>{

}