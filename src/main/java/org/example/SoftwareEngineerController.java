package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/software-engineers")
public class SoftwareEngineerController {

    @GetMapping
    @RequestMapping("/list")
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return List.of(
                new SoftwareEngineer(1, "John Doe", "Js, node, react, tailwindcss"),
                new SoftwareEngineer(2, "John Doe2", "Java"),
                new SoftwareEngineer(3, "John Doe3", "python")
        );
    }

    @GetMapping
    @RequestMapping("/count")
    public int getCountOfSoftwareEngineers() {
        return SoftwareEngineer.getCount();
    }
}
