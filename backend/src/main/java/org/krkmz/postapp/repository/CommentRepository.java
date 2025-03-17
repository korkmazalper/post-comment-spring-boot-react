package org.krkmz.postapp.repository;

import org.krkmz.postapp.entity.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends BaseRepository<Comment, Long> {

}
