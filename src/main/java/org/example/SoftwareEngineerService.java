package org.example;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(
            SoftwareEngineerRepository softwareEngineerRepository
    ){
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return this.softwareEngineerRepository.findAll(); //returns all fields, not preferable in real implementation
        //use .stream().map()
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        this.softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return this.softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                id + "Not found"));
    }

    public void deleteSoftwareEngineerById(Integer id) {
        if (!this.softwareEngineerRepository.existsById(id)) {
            throw new IllegalStateException(id + " not found");
        }
        this.softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineerById(Integer id, SoftwareEngineer update) {
        SoftwareEngineer softwareEng = softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                id + " not found"));
        softwareEng.setName(update.getName());
        softwareEng.setTechStack(update.getTechStack());
        softwareEngineerRepository.save(softwareEng);
    }
}
