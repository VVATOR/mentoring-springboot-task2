package com.epam.mentoring.springboot.repository;

import com.epam.mentoring.springboot.beans.Friendships;
import com.epam.mentoring.springboot.repository.impl.FriendshipCustomRepository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface FriendshipRepository extends CrudRepository<Friendships, Integer>,FriendshipCustomRepository {

   List<Friendships> getFriendshipsByUserId1(Integer id);
}
