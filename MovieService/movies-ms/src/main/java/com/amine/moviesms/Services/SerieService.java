package com.amine.moviesms.Services;

import org.springframework.stereotype.Service;

import com.amine.moviesms.Entities.Serie;
import com.amine.moviesms.Repositories.SerieRepository;

import java.util.List;

@Service
public class SerieService {
    private final SerieRepository serieRepository;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }


    public Serie findById(String id) {
        return serieRepository.findById(id).orElse(null);
    }


    public List<Serie> findAll() {
        return serieRepository.findAll();
    }


    public Serie save(Serie serie) {
        return serieRepository.save(serie);
    }


    public void deleteById(String id) {
        serieRepository.deleteById(id);
    }
}
