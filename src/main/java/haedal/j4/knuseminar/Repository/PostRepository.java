package haedal.j4.knuseminar.Repository;


import haedal.j4.knuseminar.Domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
