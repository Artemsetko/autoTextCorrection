package corrector;

/**
 * Created by АРТЁМ on 23.12.2015.
 */

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorrectorController {

    Corrector corrector = new Corrector();

    @RequestMapping("/corrected")
    public String corrected(@RequestBody String name) {
        return corrector.correctString(name);
    }
}