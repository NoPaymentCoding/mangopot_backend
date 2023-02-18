package mangopot_backend.mangopot_backend.comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentRepository extends JpaRepository<Comment, Long> {
}
