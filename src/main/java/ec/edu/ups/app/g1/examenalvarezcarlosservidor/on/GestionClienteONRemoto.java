package ec.edu.ups.app.g1.examenalvarezcarlosservidor.on;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.app.g1.examenalvarezcarlosservidor.modelo.Cliente;

@Remote
public interface GestionClienteONRemoto {
	public boolean registrarCliente(Cliente cliente) throws Exception;
	public List<Cliente> buscarCliente(String dni);
}