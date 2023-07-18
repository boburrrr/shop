package org.example.shop.service;

import lombok.RequiredArgsConstructor;
import org.example.shop.model.card.Hisob;
import org.example.shop.repository.HisobRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HisobService {
    private final HisobRepository hisobRepository;
    public int addHisob(Hisob hisob){
        hisobRepository.addHisob(hisob);
        return 200;
    }
    public Hisob getById(UUID id){
        return hisobRepository.getById(id);
    }
    public void deleteById(UUID id){
        hisobRepository.deleteById(id);
    }
    public void updateHisobBalance(UUID id, Double balance){
        hisobRepository.updateHisobBalance(id,balance);
    }
}
