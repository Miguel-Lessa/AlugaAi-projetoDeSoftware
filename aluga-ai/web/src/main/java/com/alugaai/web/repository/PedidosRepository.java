package com.alugaai.web.repository;

import com.alugaai.web.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {
    Optional<Pedidos> findByClienteCpf(String cpf);
}