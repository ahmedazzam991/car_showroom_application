@Controller
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String index(Model model) {
        List cars = restTemplate.getForObject("http://car-service/cars", List.class);
        List showrooms = restTemplate.getForObject("http://showroom-service/showrooms", List.class);
        model.addAttribute("cars", cars);
        model.addAttribute("showrooms", showrooms);
        return "index";
    }
}

