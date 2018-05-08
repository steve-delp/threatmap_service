package RansomwareSiteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin()
@RequestMapping("/ransomwareSites")
public class RansomwareSiteController {

    private final RansomwareSiteRepository repo;

    @Autowired
    RansomwareSiteController(RansomwareSiteRepository ransomwareSiteRepository) {
        this.repo = ransomwareSiteRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Iterable<RansomwareSite> readRansomwareSites() {
        return this.repo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    RansomwareSite addRansomwareSite(@RequestBody RansomwareSite input) {
        return this.repo.save(
                            new RansomwareSite(input.getCounty(), input.getIp(), input.getHost(),
                                    input.getUrl(), input.getMalware(), input.getLat(), input.getLon()));
    }

}