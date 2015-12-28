package io.hedwig.blog.repository;

import io.hedwig.blog.domain.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by patrick on 15/10/23.
 */
public interface PostRepository extends CrudRepository<Post,Long> {
}
