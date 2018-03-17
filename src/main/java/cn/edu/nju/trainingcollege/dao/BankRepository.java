package cn.edu.nju.trainingcollege.dao;

import cn.edu.nju.trainingcollege.entity.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<BankEntity,String> {
}
