package RansomwareSiteService;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RansomwareSiteRepository extends CrudRepository<RansomwareSite, Long> {

    List<RansomwareSite> findByCounty(String county);
}
