package ec.edu.ups.app.g1.examenalvarezcarlosservidor.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.app.g1.examenalvarezcarlosservidor.modelo.Cliente;
@Stateless

public class ClienteDAO {
	

	@Inject
	private EntityManager em;
	public ClienteDAO(){
		
	}
	public boolean insert(Cliente c) throws Exception {
		boolean bandera = true;
		try {
			em.persist(c);
		}catch(Exception e) {
			bandera = false;
		}
		return bandera;
	}
	public List<Cliente> listarClienteDNI(String dni){
		String jpql = "SELECT c FROM Cliente c WHERE c.cliente_dni = ?1";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter(1, dni);
		return (List<Cliente>) q.getResultList();
	}
}