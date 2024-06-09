@RestController
@RequestMapping("/showrooms")
public class ShowroomController {

    @Autowired
    private ShowroomRepository showroomRepository;

    @GetMapping
    public List<Showroom> getAllShowrooms() {
        return showroomRepository.findAll();
    }

    @PostMapping
    public Showroom createShowroom(@RequestBody Showroom showroom) {
        return showroomRepository.save(showroom);
    }
}

