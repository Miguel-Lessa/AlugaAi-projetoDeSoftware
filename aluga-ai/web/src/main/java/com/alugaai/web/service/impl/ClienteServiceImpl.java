package com.alugaai.web.service.impl;

import com.alugaai.web.dto.ClienteDto;
import com.alugaai.web.model.Cliente;
import com.alugaai.web.repository.ClienteRepository;
import com.alugaai.web.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void atualizarCliente(ClienteDto clienteDto) {
        Cliente cliente = clienteRepository.findById(clienteDto.getCpf())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        cliente.setNome(clienteDto.getNome());
        cliente.setCpf(clienteDto.getCpf());
        cliente.setSenha(clienteDto.getSenha());
        cliente.setEndereco(clienteDto.getEndereco());
        cliente.setProfissao(clienteDto.getProfissao());
        cliente.setEmpregadoras(clienteDto.getEmpregadoras());
        cliente.setRendimentos(clienteDto.getRendimentos());
        clienteRepository.save(cliente);
    }

    @Override
    public void excluirCliente(String idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        clienteRepository.delete(cliente);
    }


    @Override
    public Cliente criarNovoPedido() {
        return new Cliente();
    }


    private ClienteDto mapToClienteDto(Cliente cliente) {
        return ClienteDto.builder()
                .cpf(cliente.getCpf())
                .nome(cliente.getNome())
                .senha(cliente.getSenha())
                .endereco(cliente.getEndereco())
                .profissao(cliente.getProfissao())
                .rendimentos(cliente.getRendimentos())
                .empregadoras(cliente.getEmpregadoras())
                .build();
    }

//    public static Cliente mapToClub(ClienteDto clienteDto) {
//        return Cliente.builder()
//                .cpf(clienteDto.getCpf())
//                .nome(clienteDto.getNome())
//                .senha(clienteDto.getSenha())
//                .endereco(clienteDto.getEndereco())
//                .profissao(clienteDto.getProfissao())
//                .rendimentos(clienteDto.getRendimentos())
//                .empregadoras(clienteDto.getEmpregadoras().stream()
//                        .map(event -> mapToP(event)) // Corrected lambda syntax
//                        .collect(Collectors.toList()))
//                .build();
//    }
}
