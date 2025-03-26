import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteController {
    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/cliente/login")
    public String loginForm() {
        return "cliente-login";
    }

    @PostMapping("/cliente/excluir")
    public String excluirCliente(@RequestParam("cpf") String cpf) {
        clienteService.excluirCliente(cpf);
        return "redirect:/login";
    }

    @GetMapping("/cliente/novo")
    public String novoClienteForm() {
        return "cliente-novo";
    }

    @GetMapping("/cliente/editar/{cpf}")
    public String editarClienteForm(@PathVariable("cpf") String cpf, Model model) {
        Cliente cliente = clienteService.buscarClientePorCpf(cpf);
        model.addAttribute("cliente", cliente);
        return "cliente-editar";
    }

    @PostMapping("/cliente/editar")
    public String editarCliente(@ModelAttribute Cliente cliente) {
        clienteService.atualizarCliente(cliente);
        return "redirect:/clientes";
    }
}