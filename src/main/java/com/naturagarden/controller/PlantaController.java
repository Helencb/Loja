package com.naturagarden.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.naturagarden.model.Planta;
import com.naturagarden.repository.PlantaRepository;

import java.util.List;
import java.util.Optional;

    @AllArgsConstructor
    @NoArgsConstructor
    @RestController
    @RequestMapping("/plantas") // URL base dos endpoints
    public class PlantaController {

        @Autowired
        private PlantaRepository plantaRepository;

        // 🔹 1. Listar todas as plantas (GET)
        @GetMapping
        public List<Planta> listarTodas() {
            return plantaRepository.findAll();
        }

        // 🔹 2. Buscar planta por ID (GET)
        @GetMapping("/{id}")
        public Optional<Planta> buscarPorId(@PathVariable Long id) {
            return plantaRepository.findById(id);
        }

        // 🔹 3. Cadastrar nova planta (POST)
        @PostMapping
        public Planta cadastrar(@RequestBody Planta planta) {
            return plantaRepository.save(planta);
        }

        // 🔹 4. Atualizar planta existente (PUT)
        @PutMapping("/{id}")
        public Planta atualizar(@PathVariable Long id, @RequestBody Planta novaPlanta) {
            return plantaRepository.findById(id)
                    .map(planta -> {
                        planta.setNome(novaPlanta.getNome());
                        planta.setPreco(novaPlanta.getPreco());
                        planta.setAmbiente(novaPlanta.getAmbiente());
                        return plantaRepository.save(planta);
                    })
                    .orElseThrow(() -> new RuntimeException("Planta não encontrada!"));
        }

        // 🔹 5. Deletar planta (DELETE)
        @DeleteMapping("/{id}")
        public String deletar(@PathVariable Long id) {
            plantaRepository.deleteById(id);
            return "Planta deletada com sucesso!";
        }
    }

