package mangopot_backend.mangopot_backend.interest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/interest")
public class InterestController {

    private final InterestService interestService;

    @GetMapping()
    public ResponseEntity allInterestList(){
        List<Interest> interestAll = interestService.findInterestAll();
        return new ResponseEntity(interestAll, HttpStatus.OK);
    }

}
