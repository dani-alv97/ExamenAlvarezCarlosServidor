package ec.edu.ups.app.g1.examenalvarezcarlosservidor.on;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.app.g1.examenalvarezcarlosservidor.dao.ClienteDAO;
import ec.edu.ups.app.g1.examenalvarezcarlosservidor.modelo.Cliente;


@Stateless
public class GestionClienteON implements GestionClienteONRemoto{
	@Inject
	private ClienteDAO daoCliente;
	public boolean registrarCliente(Cliente cliente) throws Exception {
		try {
			daoCliente.insert(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al registrar");
		}
		return true;
	}
	public List<Cliente> buscarCliente(String dni) {
		return daoCliente.listarClienteDNI(dni);
	}	
}
