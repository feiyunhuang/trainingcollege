package cn.edu.nju.trainingcollege.dao;

import cn.edu.nju.trainingcollege.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,Integer> {

}
